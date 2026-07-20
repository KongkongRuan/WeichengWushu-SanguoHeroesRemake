/**
 * 敌人系统 - 敌人生成、移动、HP计算
 * 100%还原原版 c1107[30][18] 敌人数组和生成逻辑
 *
 * 关键修正:
 *   - 路径数据使用 F1164 (mapsp文件), 而非 C1161 (翻转模式)
 *   - 敌人沿路径瓦片移动, 从入口(1,2)到出口(5,6)
 *   - 渲染时应用相机偏移
 */
import { Renderer } from './Renderer';
import { MapData, PATH_EMPTY, PATH_ENTRY_1, PATH_ENTRY_2, PATH_EXIT_1, PATH_EXIT_2 } from './MapData';
import { SpriteLoader } from './SpriteLoader';
import {
  TILE_SIZE,
  MAX_ENEMIES,
  calculateEnemyHP,
  KILL_REWARD,
  ENEMY_COUNT_PER_LEVEL,
  MULTI_PATH_FLAG,
  MAP_TOP_BAR_H,
  MAP_VIEW_H,
  MAP_VIEW_W,
} from '../data/gameData';

// 敌人状态 (对应原版 c1107[n][3] / c1107[n][4])
export enum EnemyState {
  INACTIVE = 0,
  SPAWNING = 1,    // 正在进入 (对应原版 state 1)
  ACTIVE = 2,      // 活跃/移动中 (对应原版 state 0/2)
  MOVING = 3,      // 移动中
  DYING = 4,       // 死亡动画
  DEAD = 5,        // 已死亡
  ATTACKING = 6,   // 攻击塔 (对应原版 state 6)
}

export interface Enemy {
  x: number;           // 当前X坐标 (地图像素)
  y: number;           // 当前Y坐标 (地图像素)
  level: number;       // 关卡索引
  state: number;       // 状态
  type: number;        // 敌人类型
  variant: number;     // 敌人变体
  frame: number;       // 动画帧
  timer: number;       // 计时器
  effect: number;      // 效果
  hp: number;          // 当前HP
  maxHp: number;       // 最大HP
  speed: number;       // 速度
  dirX: number;        // X方向
  dirY: number;        // Y方向
  pathIdx: number;     // 路径索引
  pathStep: number;    // 路径步数
  targetX: number;     // 目标X (地图像素)
  targetY: number;     // 目标Y (地图像素)
  bonus1: number;      // 加成1
  bonus2: number;      // 加成2
}

export class EnemySystem {
  private renderer: Renderer;
  private mapData: MapData;
  private spriteLoader: SpriteLoader | null = null;
  private enemies: Enemy[] = [];
  private enemyCount: number = 0;
  private spawnTimer: number = 0;
  private spawnFlag: boolean = false;
  private totalSpawned: number = 0;
  private totalKilled: number = 0;
  private currentLevel: number = 0;
  private goldReward: number = 0;
  private onEnemyKilled: ((gold: number) => void) | null = null;
  private onEnemyEscaped: (() => void) | null = null;
  private pathCache: { x: number; y: number }[][] = [];
  private towerSystem: any = null;

  // 关卡是否已开始 (剧情阶段不生成敌人)
  private levelStarted: boolean = false;

  constructor(renderer: Renderer, mapData: MapData) {
    this.renderer = renderer;
    this.mapData = mapData;
    this.initEnemies();
  }

  private initEnemies(): void {
    this.enemies = [];
    for (let i = 0; i < MAX_ENEMIES; i++) {
      this.enemies.push(this.createEmptyEnemy());
    }
  }

  private createEmptyEnemy(): Enemy {
    return {
      x: 0, y: 0, level: 0, state: EnemyState.INACTIVE,
      type: 0, variant: 0, frame: 0, timer: 0, effect: 0,
      hp: 0, maxHp: 0, speed: 0, dirX: 0, dirY: 0,
      pathIdx: -1, pathStep: 0, targetX: 0, targetY: 0,
      bonus1: 0, bonus2: 0,
    };
  }

  setSpriteLoader(loader: SpriteLoader): void {
    this.spriteLoader = loader;
  }

  setTowerSystem(towerSystem: any): void {
    this.towerSystem = towerSystem;
  }

  setLevel(level: number): void {
    this.currentLevel = level;
    this.goldReward = KILL_REWARD[level] ?? 20;
    this.spawnTimer = 0;
    this.spawnFlag = false;
    this.levelStarted = false;
  }

  /**
   * 标记关卡已开始 (剧情阶段结束后调用)
   */
  startLevel(): void {
    this.levelStarted = true;
  }

  /**
   * 计算路径 - 基于 F1164 路径数据
   * 从入口点(1,2)沿路径瓦片追踪到出口点(5,6)
   */
  computePaths(): void {
    this.pathCache = [];
    const w = this.mapData.width;
    const h = this.mapData.height;

    // 找到所有入口点
    const entryPoints: { x: number; y: number; type: number }[] = [];
    for (let y = 0; y < h; y++) {
      for (let x = 0; x < w; x++) {
        const v = this.mapData.getPathTile(x, y);
        if (v === PATH_ENTRY_1 || v === PATH_ENTRY_2) {
          entryPoints.push({ x, y, type: v });
        }
      }
    }

    // 为每个入口点追踪路径
    for (const entry of entryPoints) {
      const path = this.tracePath(entry.x, entry.y, w, h);
      if (path.length > 1) {
        this.pathCache.push(path);
      }
    }

    // 如果没有找到路径, 尝试使用 spawnPoints
    if (this.pathCache.length === 0) {
      const spawnPoints = this.mapData.getSpawnPoints();
      for (const sp of spawnPoints) {
        if (sp.type === PATH_ENTRY_1 || sp.type === PATH_ENTRY_2) {
          const path = this.tracePath(sp.x, sp.y, w, h);
          if (path.length > 1) {
            this.pathCache.push(path);
          }
        }
      }
    }

    console.log(`EnemySystem: computed ${this.pathCache.length} paths`);
    for (let i = 0; i < this.pathCache.length; i++) {
      console.log(`  Path ${i}: ${this.pathCache[i].length} tiles, start=(${this.pathCache[i][0].x},${this.pathCache[i][0].y}) end=(${this.pathCache[i][this.pathCache[i].length-1].x},${this.pathCache[i][this.pathCache[i].length-1].y})`);
    }
  }

  /**
   * 从起点追踪路径 (BFS找到从入口到最近出口的最短路径)
   * 使用 parent map 记录路径, 避免数组索引问题
   */
  private tracePath(startX: number, startY: number, w: number, h: number): { x: number; y: number }[] {
    const dirs = [
      { dx: 0, dy: -1 }, { dx: 1, dy: 0 },
      { dx: 0, dy: 1 }, { dx: -1, dy: 0 },
    ];

    const startKey = `${startX},${startY}`;
    // parent map: childKey -> parentKey
    const parent = new Map<string, string | null>();
    parent.set(startKey, null);
    
    const queue: string[] = [startKey];
    let exitKey: string | null = null;

    while (queue.length > 0) {
      const curKey = queue.shift()!;
      const [cx, cy] = curKey.split(',').map(Number);

      // 检查是否到达出口 (排除起点)
      if (cx !== startX || cy !== startY) {
        const v = this.mapData.getPathTile(cx, cy);
        if (v === PATH_EXIT_1 || v === PATH_EXIT_2) {
          exitKey = curKey;
          break;
        }
      }

      // 扩展邻居
      for (const dir of dirs) {
        const nx = cx + dir.dx;
        const ny = cy + dir.dy;
        const nKey = `${nx},${ny}`;
        if (parent.has(nKey)) continue;
        if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;

        const nv = this.mapData.getPathTile(nx, ny);
        if (nv !== PATH_EMPTY) {
          parent.set(nKey, curKey);
          queue.push(nKey);
        }
      }
    }

    // 重建路径
    if (!exitKey) {
      return [];
    }

    const path: { x: number; y: number }[] = [];
    let key: string | null = exitKey;
    while (key !== null) {
      const [x, y] = key.split(',').map(Number);
      path.unshift({ x, y });
      key = parent.get(key) ?? null;
    }

    return path;
  }

  /**
   * 生成敌人
   */
  spawnEnemy(pathIdx: number, level: number, variant: number): boolean {
    if (this.enemyCount >= MAX_ENEMIES) return false;
    if (pathIdx < 0 || pathIdx >= this.pathCache.length) return false;

    const path = this.pathCache[pathIdx];
    if (path.length < 2) return false;

    const enemy = this.enemies[this.enemyCount];
    const startTile = path[0];
    enemy.x = startTile.x * TILE_SIZE;
    enemy.y = startTile.y * TILE_SIZE;
    enemy.level = level;
    enemy.state = EnemyState.MOVING;
    enemy.variant = variant;
    enemy.type = 3;
    enemy.frame = 0;
    enemy.timer = 0;
    enemy.effect = 0;
    enemy.pathIdx = pathIdx;
    enemy.pathStep = 1; // 从第二个路径点开始追踪
    enemy.dirX = 0;
    enemy.dirY = 0;
    enemy.bonus1 = 0;
    enemy.bonus2 = 0;

    // 设置第一个目标
    const nextTile = path[1];
    enemy.targetX = nextTile.x * TILE_SIZE;
    enemy.targetY = nextTile.y * TILE_SIZE;

    // 计算HP
    const hp = calculateEnemyHP(level, Math.max(0, variant), enemy.type);
    enemy.hp = hp;
    enemy.maxHp = hp;

    // 速度 (基于原版)
    enemy.speed = 0.8;

    this.enemyCount++;
    this.totalSpawned++;
    this.spawnFlag = false;

    return true;
  }

  /**
   * 更新所有敌人
   */
  update(deltaTime: number): void {
    // 关卡未开始时不生成敌人
    if (!this.levelStarted) return;

    // 更新生成计时器
    if (this.spawnTimer > 0) {
      this.spawnTimer -= deltaTime;
    } else {
      this.trySpawnEnemy();
    }

    // 更新每个敌人
    for (let i = 0; i < this.enemyCount; i++) {
      const enemy = this.enemies[i];
      if (enemy.state === EnemyState.INACTIVE || enemy.state === EnemyState.DEAD) continue;
      this.updateEnemy(enemy, deltaTime);
    }

    // 清理已死亡敌人
    this.compactEnemies();
  }

  /**
   * 尝试生成敌人
   */
  private trySpawnEnemy(): void {
    const maxEnemies = (ENEMY_COUNT_PER_LEVEL[this.currentLevel] ?? 3) * 20;

    if (this.totalSpawned < maxEnemies) {
      if (this.spawnFlag) {
        // 从路径缓存中生成敌人
        const multiPath = MULTI_PATH_FLAG[this.currentLevel] ?? 0;
        let pathIdx = 0;
        if (multiPath && this.pathCache.length > 1) {
          pathIdx = this.totalSpawned % this.pathCache.length;
        }
        const variant = multiPath ? (this.totalSpawned % ENEMY_COUNT_PER_LEVEL[this.currentLevel]) : -1;
        this.spawnEnemy(pathIdx, this.currentLevel, variant);
      }
    }

    // 设置下一个生成计时器
    this.spawnTimer = 60; // 约1秒生成一个
    this.spawnFlag = true;
  }

  /**
   * 更新单个敌人 - 沿路径移动
   */
  private updateEnemy(enemy: Enemy, dt: number): void {
    if (enemy.hp <= 0) {
      enemy.state = EnemyState.DEAD;
      this.totalKilled++;
      this.onEnemyKilled?.(this.goldReward);
      return;
    }

    // 攻击塔状态
    if (enemy.state === EnemyState.ATTACKING) {
      this.checkEnemyAttack(enemy);
      this.updateEnemyAnimation(enemy);
      return;
    }

    // 沿路径移动
    if (enemy.pathIdx >= 0 && enemy.pathIdx < this.pathCache.length) {
      const path = this.pathCache[enemy.pathIdx];
      if (path && enemy.pathStep < path.length) {
        const target = path[enemy.pathStep];
        const targetX = target.x * TILE_SIZE;
        const targetY = target.y * TILE_SIZE;

        const dx = targetX - enemy.x;
        const dy = targetY - enemy.y;
        const dist = Math.sqrt(dx * dx + dy * dy);

        if (dist < 2) {
          // 到达目标点, 前进到下一个路径点
          enemy.pathStep++;
          if (enemy.pathStep >= path.length) {
            // 敌人到达终点
            enemy.state = EnemyState.DEAD;
            this.onEnemyEscaped?.();
            return;
          }
        } else {
          // 检查前方是否有塔阻挡
          if (this.towerSystem && this.checkPathBlocked(enemy, path)) {
            enemy.state = EnemyState.ATTACKING;
            enemy.bonus1 = 0;
            return;
          }

          // 向目标移动
          const speed = enemy.speed * dt;
          enemy.x += (dx / dist) * speed;
          enemy.y += (dy / dist) * speed;
          enemy.dirX = Math.sign(dx);
          enemy.dirY = Math.sign(dy);
        }
      }
    }

    this.updateEnemyAnimation(enemy);
  }

  private updateEnemyAnimation(enemy: Enemy): void {
    enemy.timer++;
    if (enemy.timer >= 8) {
      enemy.timer = 0;
      enemy.frame = (enemy.frame + 1) % 4;
    }
  }

  private checkPathBlocked(enemy: Enemy, path: { x: number; y: number }[]): boolean {
    if (!this.towerSystem) return false;
    if (enemy.pathStep >= path.length) return false;

    const nextTile = path[enemy.pathStep];
    const towers = this.towerSystem.getTowers();
    for (const tower of towers) {
      if (tower.x === nextTile.x && tower.y === nextTile.y) {
        enemy.bonus2 = towers.indexOf(tower);
        return true;
      }
    }
    return false;
  }

  private checkEnemyAttack(enemy: Enemy): void {
    if (!this.towerSystem) {
      enemy.state = EnemyState.MOVING;
      return;
    }

    const towers = this.towerSystem.getTowers() as any[];
    if (towers.length === 0) {
      enemy.state = EnemyState.MOVING;
      enemy.bonus1 = 0;
      return;
    }

    const enemyDamage = 5 + enemy.level * 2;
    const attackRange = 24;
    const ex = enemy.x + TILE_SIZE / 2;
    const ey = enemy.y + TILE_SIZE / 2;

    // 简化: 直接攻击最近的塔
    let closestTower: any = null;
    let closestDist = Infinity;
    for (const tower of towers) {
      const tx = tower.x * TILE_SIZE + TILE_SIZE / 2;
      const ty = tower.y * TILE_SIZE + TILE_SIZE / 2;
      const dist = Math.sqrt((tx - ex) ** 2 + (ty - ey) ** 2);
      if (dist < attackRange && dist < closestDist) {
        closestTower = tower;
        closestDist = dist;
      }
    }

    if (closestTower) {
      enemy.bonus1++;
      if (enemy.bonus1 >= 3) {
        this.towerSystem.damageTower(closestTower, enemyDamage);
        enemy.bonus1 = 0;
      }
    } else {
      enemy.state = EnemyState.MOVING;
      enemy.bonus1 = 0;
    }
  }

  private compactEnemies(): void {
    let writeIdx = 0;
    for (let i = 0; i < this.enemyCount; i++) {
      if (this.enemies[i].state !== EnemyState.DEAD &&
          this.enemies[i].state !== EnemyState.INACTIVE) {
        if (writeIdx !== i) {
          this.enemies[writeIdx] = this.enemies[i];
          this.enemies[i] = this.createEmptyEnemy();
        }
        writeIdx++;
      }
    }
    this.enemyCount = writeIdx;
  }

  /**
   * 渲染所有敌人 (应用相机偏移)
   */
  render(): void {
    const camX = this.mapData.cameraX;
    const camY = this.mapData.cameraY;

    const vctx = this.renderer.virtualContext;
    vctx.save();
    vctx.beginPath();
    vctx.rect(0, MAP_TOP_BAR_H, MAP_VIEW_W, MAP_VIEW_H);
    vctx.clip();

    for (let i = 0; i < this.enemyCount; i++) {
      const enemy = this.enemies[i];
      if (enemy.state === EnemyState.INACTIVE || enemy.state === EnemyState.DEAD) continue;

      // 应用相机偏移: 屏幕坐标 = 地图坐标 - 相机坐标 + 视口偏移
      const px = enemy.x - camX;
      const py = enemy.y - camY + MAP_TOP_BAR_H;

      // 跳过不可见的敌人
      if (px < -TILE_SIZE || px > MAP_VIEW_W || py < MAP_TOP_BAR_H - TILE_SIZE || py > MAP_TOP_BAR_H + MAP_VIEW_H) continue;

      // 优先使用精灵图
      let spriteDrawn = false;
      if (this.spriteLoader) {
        const spriteIdx = (enemy.type * 4 + enemy.frame) % 48;
        const sprite = this.spriteLoader.getEnemySprite(spriteIdx);
        if (sprite) {
          this.renderer.drawImageRegion(
            sprite, 0, 0, 18, 18,
            px - 1, py - 1, 18, 18,
          );
          spriteDrawn = true;
        }
      }

      if (!spriteDrawn) {
        const colors = [0xFF4444, 0x44FF44, 0x4444FF, 0xFFFF44];
        const color = colors[enemy.frame % colors.length];
        this.renderer.setColor(color);
        this.renderer.fillRect(px, py, TILE_SIZE - 2, TILE_SIZE - 2);
      }

      // 血条
      if (enemy.hp < enemy.maxHp) {
        const barW = TILE_SIZE;
        const barH = 2;
        const hpRatio = enemy.hp / enemy.maxHp;
        this.renderer.setColor(0x000000);
        this.renderer.fillRect(px, py - 4, barW, barH);
        this.renderer.setColor(0xFF0000);
        this.renderer.fillRect(px, py - 4, barW * hpRatio, barH);
      }
    }

    vctx.restore();
  }

  getActiveEnemies(): Enemy[] {
    return this.enemies.slice(0, this.enemyCount);
  }

  get count(): number { return this.enemyCount; }
  get killed(): number { return this.totalKilled; }

  setCallbacks(onKilled: (gold: number) => void, onEscaped: () => void): void {
    this.onEnemyKilled = onKilled;
    this.onEnemyEscaped = onEscaped;
  }

  reset(): void {
    this.enemyCount = 0;
    this.totalSpawned = 0;
    this.totalKilled = 0;
    this.spawnTimer = 0;
    this.spawnFlag = false;
    this.levelStarted = false;
    this.initEnemies();
  }
}
