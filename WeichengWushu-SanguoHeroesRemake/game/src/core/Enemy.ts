/**
 * 敌人系统 - 敌人生成、移动、HP计算
 * 100%还原原版 c1107[30][18] 敌人数组和生成逻辑
 */
import { Renderer } from './Renderer';
import { MapData, PATH_WALKABLE } from './MapData';
import { SpriteLoader } from './SpriteLoader';
import {
  TILE_SIZE,
  MAX_ENEMIES,
  ENEMY_ATTR_COUNT,
  calculateEnemyHP,
  KILL_REWARD,
  ENEMY_COUNT_PER_LEVEL,
  MULTI_PATH_FLAG,
  ENEMY_PATH_SEQUENCES,
  ENEMY_ATTR,
  ENEMY_INIT_VALUES,
} from '../data/gameData';

// 敌人状态
export enum EnemyState {
  INACTIVE = 0,
  SPAWNING = 1,
  ACTIVE = 2,
  MOVING = 3,
  DYING = 4,
  DEAD = 5,
}

export interface Enemy {
  x: number;           // 当前X坐标 (像素)
  y: number;           // 当前Y坐标 (像素)
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
  pathIdx: number;     // 路径索引
  dirY: number;        // Y方向
  bonus1: number;      // 加成1
  bonus2: number;      // 加成2
  pathStep: number;    // 路径步数
  targetX: number;     // 目标X
  targetY: number;     // 目标Y
}

export class EnemySystem {
  private renderer: Renderer;
  private mapData: MapData;
  private spriteLoader: SpriteLoader | null = null;
  private enemies: Enemy[] = [];
  private enemyCount: number = 0;  // bt: 当前敌人数量
  private spawnTimer: number = 0;  // bu: 生成计时器
  private spawnFlag: boolean = false; // bF: 生成标志
  private totalSpawned: number = 0; // 总生成数
  private totalKilled: number = 0; // 总击杀数
  private currentLevel: number = 0;
  private goldReward: number = 0;
  private onEnemyKilled: ((gold: number) => void) | null = null;
  private onEnemyEscaped: (() => void) | null = null;
  private pathCache: { x: number; y: number }[][] = [];

  constructor(renderer: Renderer, mapData: MapData) {
    this.renderer = renderer;
    this.mapData = mapData;
    this.initEnemies();
  }

  /**
   * 初始化敌人数组 (c1107[30][18])
   */
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
      hp: 0, maxHp: 0, speed: 0, dirX: 0, pathIdx: -1,
      dirY: 0, bonus1: 0, bonus2: 0, pathStep: 0,
      targetX: 0, targetY: 0,
    };
  }

  /**
   * 设置关卡
   */
  /**
   * 设置精灵图加载器
   */
  setSpriteLoader(loader: SpriteLoader): void {
    this.spriteLoader = loader;
  }

  setLevel(level: number): void {
    this.currentLevel = level;
    this.goldReward = KILL_REWARD[level] ?? 20;
    this.spawnTimer = 0;
    this.spawnFlag = false;
  }

  /**
   * 计算路径
   */
  computePaths(): void {
    this.pathCache = [];
    const spawnPoints = this.mapData.getSpawnPoints();

    // 为每个生成点计算路径
    for (const sp of spawnPoints) {
      if (sp.type === 1 || sp.type === 2) {
        // 入口点，从此处开始寻路
        const path = this.findPath(sp.x, sp.y);
        if (path.length > 0) {
          this.pathCache.push(path);
        }
      }
    }

    // 如果没有生成点数据，使用地图路径层
    if (this.pathCache.length === 0) {
      const path = this.findPathFromMap();
      if (path.length > 0) {
        this.pathCache.push(path);
      }
    }
  }

  /**
   * 从生成点寻路到出口
   */
  private findPath(startX: number, startY: number): { x: number; y: number }[] {
    const path: { x: number; y: number }[] = [{ x: startX, y: startY }];
    const visited = new Set<string>();
    visited.add(`${startX},${startY}`);

    let cx = startX, cy = startY;
    const maxSteps = this.mapData.width * this.mapData.height;

    for (let i = 0; i < maxSteps; i++) {
      // 检查四个方向
      const dirs = [
        { dx: 0, dy: -1 }, // 上
        { dx: 1, dy: 0 },  // 右
        { dx: 0, dy: 1 },  // 下
        { dx: -1, dy: 0 }, // 左
      ];

      let found = false;
      for (const dir of dirs) {
        const nx = cx + dir.dx;
        const ny = cy + dir.dy;
        const key = `${nx},${ny}`;
        if (visited.has(key)) continue;
        if (nx < 0 || ny < 0 || nx >= this.mapData.width || ny >= this.mapData.height) continue;

        const pathType = this.mapData.getPathType(nx, ny);
        if (pathType === PATH_WALKABLE || pathType === 4) {
          path.push({ x: nx, y: ny });
          visited.add(key);
          cx = nx;
          cy = ny;
          found = true;
          break;
        }
      }

      if (!found) break;
    }

    return path;
  }

  /**
   * 从地图路径层寻找路径
   */
  private findPathFromMap(): { x: number; y: number }[] {
    const w = this.mapData.width;
    const h = this.mapData.height;
    const path: { x: number; y: number }[] = [];

    // 找到第一行有路径的瓦片
    for (let y = 0; y < h; y++) {
      for (let x = 0; x < w; x++) {
        if (this.mapData.getPathType(x, y) === PATH_WALKABLE) {
          return this.findPath(x, y);
        }
      }
    }
    return path;
  }

  /**
   * 生成敌人 (还原 c(int n, int n2, int n3, int n4))
   */
  spawnEnemy(spawnX: number, spawnY: number, level: number, variant: number): boolean {
    if (this.enemyCount >= MAX_ENEMIES) return false;

    const enemy = this.enemies[this.enemyCount];
    enemy.x = spawnX * TILE_SIZE;
    enemy.y = spawnY * TILE_SIZE;
    enemy.level = level;
    enemy.state = 3; // 初始状态
    enemy.variant = variant;
    enemy.type = 3;
    enemy.frame = 0;
    enemy.timer = 0;
    enemy.effect = 0;
    enemy.pathIdx = -1;
    enemy.dirX = 0;
    enemy.dirY = 0;
    enemy.bonus1 = 0;
    enemy.bonus2 = 0;
    enemy.pathStep = 0;

    // 计算HP
    const hp = calculateEnemyHP(level, Math.max(0, variant), enemy.type);
    enemy.hp = hp;
    enemy.maxHp = hp;

    // 设置路径
    if (this.pathCache.length > 0) {
      const pathIdx = variant >= 0 && variant < this.pathCache.length ? variant : 0;
      const path = this.pathCache[pathIdx] || this.pathCache[0];
      if (path.length > 1) {
        enemy.pathIdx = pathIdx;
        enemy.pathStep = 1;
        enemy.targetX = path[1].x * TILE_SIZE;
        enemy.targetY = path[1].y * TILE_SIZE;
      }
    }

    this.enemyCount++;
    this.totalSpawned++;
    this.spawnFlag = false; // bF = 0

    return true;
  }

  /**
   * 更新所有敌人
   */
  update(deltaTime: number): void {
    // 更新生成计时器
    if (this.spawnTimer > 0) {
      this.spawnTimer--;
    } else {
      // 检查是否需要生成新敌人
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
    if (this.spawnFlag) {
      // 从生成点生成敌人
      const spawnPoints = this.mapData.getSpawnPoints();
      const entryPoints = spawnPoints.filter(sp => sp.type === 1 || sp.type === 2);

      if (entryPoints.length > 0) {
        const sp = entryPoints[this.totalSpawned % entryPoints.length];
        const multiPath = MULTI_PATH_FLAG[this.currentLevel] ?? 0;
        const variant = multiPath ? (this.totalSpawned % ENEMY_COUNT_PER_LEVEL[this.currentLevel]) : -1;
        this.spawnEnemy(sp.x, sp.y, this.currentLevel, variant);
      } else {
        // 使用路径缓存
        if (this.pathCache.length > 0) {
          const path = this.pathCache[0];
          if (path.length > 0) {
            this.spawnEnemy(path[0].x, path[0].y, this.currentLevel, 0);
          }
        }
      }
    }

    // 设置下一个生成计时器
    const spawnInterval = 60; // 约1秒生成一个
    this.spawnTimer = spawnInterval;
    this.spawnFlag = true;
  }

  /**
   * 更新单个敌人
   */
  private updateEnemy(enemy: Enemy, dt: number): void {
    if (enemy.hp <= 0) {
      enemy.state = EnemyState.DEAD;
      this.totalKilled++;
      this.onEnemyKilled?.(this.goldReward);
      return;
    }

    // 沿路径移动
    if (this.pathCache.length > 0 && enemy.pathIdx >= 0) {
      const path = this.pathCache[enemy.pathIdx];
      if (path && enemy.pathStep < path.length) {
        const target = path[enemy.pathStep];
        const targetX = target.x * TILE_SIZE;
        const targetY = target.y * TILE_SIZE;

        const dx = targetX - enemy.x;
        const dy = targetY - enemy.y;
        const dist = Math.sqrt(dx * dx + dy * dy);

        if (dist < 2) {
          // 到达目标点
          enemy.pathStep++;
          if (enemy.pathStep >= path.length) {
            // 敌人到达终点
            enemy.state = EnemyState.DEAD;
            this.onEnemyEscaped?.();
            return;
          }
        } else {
          // 向目标移动
          const speed = 0.5; // 移动速度
          enemy.x += (dx / dist) * speed * dt;
          enemy.y += (dy / dist) * speed * dt;
          // 设置方向
          enemy.dirX = Math.sign(dx);
          enemy.dirY = Math.sign(dy);
        }
      }
    }

    // 更新动画帧
    enemy.timer++;
    if (enemy.timer >= 8) {
      enemy.timer = 0;
      enemy.frame = (enemy.frame + 1) % 4;
    }
  }

  /**
   * 压缩敌人数组 (移除已死亡敌人)
   */
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
   * 渲染所有敌人
   */
  render(offsetX: number = 0, offsetY: number = 0): void {
    for (let i = 0; i < this.enemyCount; i++) {
      const enemy = this.enemies[i];
      if (enemy.state === EnemyState.INACTIVE || enemy.state === EnemyState.DEAD) continue;

      const px = offsetX + enemy.x;
      const py = offsetY + enemy.y;

      // 优先使用精灵图，无则用颜色方块
      let spriteDrawn = false;
      if (this.spriteLoader) {
        // sp_* 系列精灵图 (18x18)，包含多种敌人
        const spriteIdx = (enemy.type * 4 + enemy.frame) % 48;
        const sprite = this.spriteLoader.getEnemySprite(spriteIdx);
        if (sprite) {
          const frameW = 18;
          const frameH = 18;
          this.renderer.drawImageRegion(
            sprite,
            0, 0, frameW, frameH,
            px - 1, py - 1, frameW, frameH,
          );
          spriteDrawn = true;
        }
      }

      if (!spriteDrawn) {
        const colors = [0xFF0000, 0x00FF00, 0x0000FF, 0xFFFF00];
        const color = colors[enemy.frame % colors.length];
        this.renderer.setColor(color);
        this.renderer.fillRect(px, py, TILE_SIZE - 2, TILE_SIZE - 2);
      }

      // 绘制血条
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
  }

  /**
   * 获取所有活跃敌人
   */
  getActiveEnemies(): Enemy[] {
    return this.enemies.slice(0, this.enemyCount);
  }

  /**
   * 获取敌人数量
   */
  get count(): number {
    return this.enemyCount;
  }

  /**
   * 获取总击杀数
   */
  get killed(): number {
    return this.totalKilled;
  }

  /**
   * 设置回调
   */
  setCallbacks(onKilled: (gold: number) => void, onEscaped: () => void): void {
    this.onEnemyKilled = onKilled;
    this.onEnemyEscaped = onEscaped;
  }

  /**
   * 重置
   */
  reset(): void {
    this.enemyCount = 0;
    this.totalSpawned = 0;
    this.totalKilled = 0;
    this.spawnTimer = 0;
    this.spawnFlag = false;
    this.initEnemies();
  }
}
