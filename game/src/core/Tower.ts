/**
 * 塔系统 - 塔放置、攻击、升级
 * 还原原版 bu_* 精灵图和塔数值
 * 塔类型对照原版 TOWER_NAMES:
 *   0=石灰瓶 1=断龙闸 2=突刺 3=擂木 4=烟火
 *   5=投石 6=麻痹矢 7=沸水 8=寒冰 9=滚油
 *   10=石灰瓶装置(顶点) 11=断龙闸装置 12=突刺装置
 */
import { Renderer } from './Renderer';
import { MapData, PATH_BUILDABLE } from './MapData';
import { Enemy } from './Enemy';
import { SpriteLoader } from './SpriteLoader';
import { TILE_SIZE, TOWER_DATA_T, TOWER_DATA_U } from '../data/gameData';
import { TOWER_NAMES, TOWER_DESCRIPTIONS, HEROES, Hero } from '../data/heroes';
import type { TechTreeSystem } from './TechTree';

// 武将ID到武将对象的映射 (避免循环依赖, 在模块加载时构建)
const HEROES_MAP: Record<number, Hero> = {};
HEROES.forEach(h => { HEROES_MAP[h.id] = h; });

export interface Tower {
  x: number;          // 瓦片X坐标
  y: number;          // 瓦片Y坐标
  type: number;       // 塔类型 (0-12, 对应原版TOWER_NAMES)
  level: number;      // 塔等级
  damage: number;     // 攻击力
  range: number;      // 攻击范围
  fireRate: number;   // 攻击速度
  cooldown: number;   // 冷却计时器
  target: number;     // 目标敌人索引
  angle: number;      // 朝向角度
  heroId: number;     // 绑定武将ID (-1=无)
  effectType: number; // 特殊效果类型 (0=无 1=麻痹 2=冰冻 3=中毒 4=火焰 5=减速)
  // ====== 新增: 建筑血量 (对应原版 b1066 塔HP数据) ======
  hp: number;         // 当前血量
  maxHp: number;      // 最大血量
  // debuff 计时器 (对应原版 var16[15]=48)
  debuffTimer: number;
}

export class TowerSystem {
  private renderer: Renderer;
  private mapData: MapData;
  private spriteLoader: SpriteLoader | null = null;
  private techTree: TechTreeSystem | null = null;
  private towers: Tower[] = [];
  private selectedTower: Tower | null = null;
  private buildMode: boolean = false;
  private buildX: number = 0;
  private buildY: number = 0;
  private onGoldSpent: ((gold: number) => void) | null = null;
  private onHeroAwakened: ((hero: Hero, tower: Tower) => void) | null = null;
  private gold: number = 300;

  // 塔配置 - 使用原版塔名称和数值
  // 类型0-9为基础塔, 10-12为装置(升级顶点)
  private towerConfigs: Record<number, { name: string; cost: number; damage: number; range: number; fireRate: number; color: number; effect: number }> = {
    0: { name: TOWER_NAMES[0]  || '石灰瓶', cost: 50,  damage: 10, range: 64, fireRate: 30, color: 0x8B4513, effect: 0 },
    1: { name: TOWER_NAMES[1]  || '断龙闸', cost: 100, damage: 30, range: 80, fireRate: 60, color: 0x696969, effect: 0 },
    2: { name: TOWER_NAMES[2]  || '突刺',   cost: 80,  damage: 20, range: 72, fireRate: 45, color: 0x4169E1, effect: 0 },
    3: { name: TOWER_NAMES[3]  || '擂木',   cost: 70,  damage: 15, range: 60, fireRate: 40, color: 0x00CED1, effect: 0 },
    4: { name: TOWER_NAMES[4]  || '烟火',   cost: 120, damage: 40, range: 70, fireRate: 50, color: 0xFF4500, effect: 4 },
    5: { name: TOWER_NAMES[5]  || '投石',   cost: 90,  damage: 35, range: 76, fireRate: 55, color: 0x8B4513, effect: 0 },
    6: { name: TOWER_NAMES[6]  || '麻痹矢', cost: 110, damage: 18, range: 68, fireRate: 35, color: 0x9370DB, effect: 1 },
    7: { name: TOWER_NAMES[7]  || '沸水',   cost: 85,  damage: 25, range: 65, fireRate: 42, color: 0x1E90FF, effect: 4 },
    8: { name: TOWER_NAMES[8]  || '寒冰',   cost: 95,  damage: 22, range: 70, fireRate: 48, color: 0x00CED1, effect: 2 },
    9: { name: TOWER_NAMES[9]  || '滚油',   cost: 130, damage: 45, range: 75, fireRate: 58, color: 0xFF6347, effect: 4 },
    // 装置类型 (分支顶点)
    10: { name: TOWER_NAMES[10] || '石灰瓶装置', cost: 200, damage: 60,  range: 90,  fireRate: 25, color: 0xFFD700, effect: 0 },
    11: { name: TOWER_NAMES[11] || '断龙闸装置', cost: 250, damage: 80,  range: 95,  fireRate: 30, color: 0xFFD700, effect: 0 },
    12: { name: TOWER_NAMES[12] || '突刺装置',   cost: 300, damage: 100, range: 100, fireRate: 20, color: 0xFFD700, effect: 0 },
  };

  constructor(renderer: Renderer, mapData: MapData) {
    this.renderer = renderer;
    this.mapData = mapData;
  }

  /**
   * 设置金币
   */
  setGold(gold: number): void {
    this.gold = gold;
  }

  setOnGoldSpent(callback: (gold: number) => void): void {
    this.onGoldSpent = callback;
  }

  /**
   * 设置科技树系统引用
   */
  setTechTree(techTree: TechTreeSystem): void {
    this.techTree = techTree;
  }

  /**
   * 设置武将觉醒回调
   */
  setOnHeroAwakened(callback: (hero: Hero, tower: Tower) => void): void {
    this.onHeroAwakened = callback;
  }

  /**
   * 设置精灵图加载器
   */
  setSpriteLoader(loader: SpriteLoader): void {
    this.spriteLoader = loader;
  }

  /**
   * 进入建造模式
   */
  enterBuildMode(): void {
    this.buildMode = true;
  }

  exitBuildMode(): void {
    this.buildMode = false;
  }

  get isBuildMode(): boolean {
    return this.buildMode;
  }

  /**
   * 设置建造位置
   */
  setBuildPosition(x: number, y: number): void {
    this.buildX = x;
    this.buildY = y;
  }

  /**
   * 放置塔
   */
  placeTower(tileX: number, tileY: number, type: number): boolean {
    if (!this.mapData.isBuildable(tileX, tileY)) return false;

    // 检查是否已有塔
    if (this.towers.some(t => t.x === tileX && t.y === tileY)) return false;

    const config = this.towerConfigs[type];
    if (!config) return false;

    // 装填半价科技效果
    const actualCost = this.techTree?.isReloadHalf() ? Math.floor(config.cost / 2) : config.cost;
    if (this.gold < actualCost) return false;

    const tower: Tower = {
      x: tileX,
      y: tileY,
      type,
      level: 1,
      damage: config.damage,
      range: config.range,
      fireRate: config.fireRate,
      cooldown: 0,
      target: -1,
      angle: 0,
      heroId: -1,
      effectType: config.effect,
      // 新增: 初始化建筑血量 (基于塔类型和费用)
      hp: 100 + config.cost,
      maxHp: 100 + config.cost,
      debuffTimer: 0,
    };

    this.towers.push(tower);
    this.gold -= actualCost;
    this.onGoldSpent?.(actualCost);
    return true;
  }

  /**
   * 升级塔 - 集成科技树系统
   * 还原原版 j(I I I)V 升级逻辑
   */
  upgradeTower(tower: Tower): boolean {
    // 使用科技树系统检查是否可升级
    if (this.techTree) {
      const check = this.techTree.canUpgradeTech(tower);
      if (!check.canUpgrade) return false;

      const result = this.techTree.upgradeTech(tower);
      if (!result.success) return false;

      // 应用科技效果到塔属性
      tower.level++;
      tower.damage = Math.floor(tower.damage * 1.5);
      tower.range = Math.floor(tower.range * 1.1);
      tower.fireRate = Math.max(10, Math.floor(tower.fireRate * 0.85));

      // 检查武将觉醒
      if (result.hero) {
        tower.heroId = result.hero.id;
        // 装置塔获得额外加成
        tower.damage = Math.floor(tower.damage * 2);
        tower.range = Math.floor(tower.range * 1.5);
        this.onHeroAwakened?.(result.hero, tower);
      }
      return true;
    }

    // 无科技树时的备用逻辑
    const cost = 50 * tower.level;
    if (this.gold < cost) return false;
    tower.level++;
    tower.damage = Math.floor(tower.damage * 1.5);
    tower.range = Math.floor(tower.range * 1.2);
    tower.fireRate = Math.max(10, Math.floor(tower.fireRate * 0.8));
    this.gold -= cost;
    this.onGoldSpent?.(cost);
    return true;
  }

  /**
   * 出售塔
   */
  sellTower(tower: Tower): void {
    const refund = Math.floor(this.towerConfigs[tower.type].cost * tower.level * 0.7);
    this.gold += refund;
    this.towers = this.towers.filter(t => t !== tower);
    this.selectedTower = null;
  }

  /**
   * 更新所有塔 - 应用全局科技加成
   */
  update(enemies: Enemy[], offsetX: number, offsetY: number): void {
    // 新增: 更新 debuff 计时器
    this.updateDebuffs();

    // 获取全局科技加成
    const globalAtkBonus = this.techTree?.getGlobalAtkBonus() ?? 0;
    const globalFireRateBonus = this.techTree?.getGlobalFireRateBonus() ?? 0;

    for (const tower of this.towers) {
      if (tower.cooldown > 0) {
        tower.cooldown--;
        continue;
      }

      // 查找目标
      const tx = offsetX + tower.x * TILE_SIZE + TILE_SIZE / 2;
      const ty = offsetY + tower.y * TILE_SIZE + TILE_SIZE / 2;
      let closestDist = tower.range;
      let targetIdx = -1;

      for (let i = 0; i < enemies.length; i++) {
        const enemy = enemies[i];
        if (enemy.state === 0 || enemy.state === 5) continue;
        const ex = offsetX + enemy.x;
        const ey = offsetY + enemy.y;
        const dist = Math.sqrt((ex - tx) ** 2 + (ey - ty) ** 2);
        if (dist < closestDist) {
          closestDist = dist;
          targetIdx = i;
        }
      }

      if (targetIdx >= 0) {
        const target = enemies[targetIdx];
        const ex = offsetX + target.x;
        const ey = offsetY + target.y;
        tower.angle = Math.atan2(ey - ty, ex - tx);
        tower.target = targetIdx;

        // 计算实际伤害 (全局攻击加成 + 武将加成 + 科技效果)
        // 新增: 使用 TechTree 的 applyEffectsToTowerDamage 方法应用所有伤害相关科技
        let actualDamage = tower.damage;
        if (this.techTree) {
          actualDamage = this.techTree.applyEffectsToTowerDamage(tower, tower.damage);
          // 效果9: 周围塔增益
          const nearbyTowers = this.getNearbyTowers(tower, 64);
          const auraBonus = this.techTree.applyAuraBonus(tower, nearbyTowers);
          actualDamage = Math.floor(actualDamage * (1 + auraBonus));
        } else {
          // 退化方案: 仅使用全局加成
          actualDamage = tower.damage * (1 + globalAtkBonus);
        }
        if (tower.heroId >= 0) {
          actualDamage *= 1.5; // 武将觉醒后额外50%伤害
        }
        target.hp -= Math.floor(actualDamage);

        // 应用特殊效果 (塔自身效果)
        if (tower.effectType > 0 && target) {
          this.applyTowerEffect(target, tower.effectType, tower.level);
          // ====== 新增: 效果0 (attackTimeUp) - 攻击时间延长 ======
          // 延长塔特殊效果(麻痹/冰冻/中毒/火焰/减速)的持续时间
          if (this.techTree) {
            const attackTimeBonus = this.techTree.getAttackTimeBonus();
            if (attackTimeBonus > 0 && target.timer > 0) {
              target.timer = Math.floor(target.timer * (1 + attackTimeBonus));
            }
          }
        }

        // 新增: 应用科技树的范围效果 (效果4/5/10/11/15/16)
        if (this.techTree) {
          this.techTree.applyAoeEffectsToEnemy(target, tower.type, tower.level);
        }

        // 攻速受全局加成影响
        const actualFireRate = Math.max(5, Math.floor(tower.fireRate * (1 - globalFireRateBonus)));
        tower.cooldown = actualFireRate;
      } else {
        tower.target = -1;
      }
    }

    // 新增: 应用持续伤害效果 (中毒/火焰) 到所有活跃敌人
    if (this.techTree) {
      for (const enemy of enemies) {
        if (enemy.state === 0 || enemy.state === 5) continue;
        this.techTree.applyDamageOverTime(enemy, 1);
      }
    }
  }

  /**
   * 获取指定塔周围的塔列表 (新增方法)
   * 用于效果9 (auraAtkUp) 周围塔攻击增加
   * @param tower 中心塔
   * @param radius 搜索半径 (像素)
   */
  private getNearbyTowers(tower: Tower, radius: number): Tower[] {
    const result: Tower[] = [];
    const cx = tower.x;
    const cy = tower.y;
    const tileRadius = Math.ceil(radius / 16); // 16 = TILE_SIZE
    for (const t of this.towers) {
      if (t === tower) continue;
      const dx = Math.abs(t.x - cx);
      const dy = Math.abs(t.y - cy);
      if (dx <= tileRadius && dy <= tileRadius) {
        result.push(t);
      }
    }
    return result;
  }

  /**
   * 应用塔特殊效果到敌人
   */
  private applyTowerEffect(enemy: Enemy, effectType: number, towerLevel: number): void {
    switch (effectType) {
      case 1: // 麻痹
        enemy.effect = 1;
        enemy.timer = Math.max(enemy.timer, towerLevel * 10);
        break;
      case 2: // 冰冻
        enemy.effect = 2;
        enemy.speed = Math.max(0.1, enemy.speed * 0.5);
        break;
      case 3: // 中毒
        enemy.effect = 3;
        enemy.hp -= towerLevel * 2;
        break;
      case 4: // 火焰
        enemy.effect = 4;
        enemy.hp -= towerLevel * 3;
        break;
      case 5: // 减速
        enemy.speed = Math.max(0.2, enemy.speed * 0.7);
        break;
      default:
        break;
    }
  }

  /**
   * 渲染所有塔
   */
  render(offsetX: number = 0, offsetY: number = 0): void {
    for (const tower of this.towers) {
      const px = offsetX + tower.x * TILE_SIZE;
      const py = offsetY + tower.y * TILE_SIZE;
      const config = this.towerConfigs[tower.type];

      // 优先使用建筑精灵图，无则用颜色方块
      let spriteDrawn = false;
      if (this.spriteLoader) {
        // bu_* 系列建筑精灵图，按塔类型和等级选择
        const spriteIdx = tower.type * 8 + (tower.level - 1) * 2;
        const sprite = this.spriteLoader.getBuildingSprite(spriteIdx);
        if (sprite) {
          this.renderer.drawImage(sprite, px, py);
          spriteDrawn = true;
        }
      }

      if (!spriteDrawn) {
        // 绘制塔基座
        this.renderer.setColor(0x3a2a1a);
        this.renderer.fillRect(px, py, TILE_SIZE, TILE_SIZE);

        // 绘制塔身
        this.renderer.setColor(config.color);
        this.renderer.fillRect(px + 2, py + 2, TILE_SIZE - 4, TILE_SIZE - 4);
      }

      // 绘制等级
      this.renderer.setColor(0xFCFFCD);
      for (let i = 0; i < tower.level; i++) {
        this.renderer.fillRect(px + 2 + i * 3, py + TILE_SIZE - 4, 2, 2);
      }

      // ====== 新增: 绘制塔血条 (当血量不满时) ======
      if (tower.hp < tower.maxHp) {
        const barW = TILE_SIZE;
        const barH = 2;
        const hpRatio = Math.max(0, tower.hp / tower.maxHp);
        this.renderer.setColor(0x000000);
        this.renderer.fillRect(px, py - 4, barW, barH);
        // 血量颜色: >50% 绿, >25% 黄, <25% 红
        const hpColor = hpRatio > 0.5 ? 0x00FF00 : (hpRatio > 0.25 ? 0xFFC107 : 0xFF0000);
        this.renderer.setColor(hpColor);
        this.renderer.fillRect(px, py - 4, barW * hpRatio, barH);
      }

      // 绘制 debuff 状态 (被敌人施加 debuff 时闪烁)
      if (tower.debuffTimer > 0) {
        this.renderer.setColor(0x9370DB);
        this.renderer.drawRect(px - 1, py - 1, TILE_SIZE + 2, TILE_SIZE + 2);
      }

      // 绘制武将名称 (已觉醒时)
      if (tower.heroId >= 0) {
        const heroName = this.getHeroName(tower.heroId);
        if (heroName) {
          this.renderer.setColor(0xFFD700);
          this.renderer.drawText(heroName, px - 4, py - 10, 0xFFD700, 7);
        }
      }

      // 绘制攻击范围 (选中时)
      if (this.selectedTower === tower) {
        const cx = px + TILE_SIZE / 2;
        const cy = py + TILE_SIZE / 2;
        this.renderer.setColor(0xFFFFFF);
        const r = tower.range;
        this.renderer.virtualContext.beginPath();
        this.renderer.virtualContext.arc(cx, cy, r, 0, Math.PI * 2);
        this.renderer.virtualContext.stroke();
      }
    }

    // 绘制建造预览
    if (this.buildMode) {
      const px = offsetX + this.buildX * TILE_SIZE;
      const py = offsetY + this.buildY * TILE_SIZE;
      if (this.mapData.isBuildable(this.buildX, this.buildY)) {
        this.renderer.setColor(0x00FF00);
      } else {
        this.renderer.setColor(0xFF0000);
      }
      this.renderer.drawRect(px, py, TILE_SIZE, TILE_SIZE);
    }
  }

  /**
   * 获取塔列表
   */
  getTowers(): Tower[] {
    return this.towers;
  }

  /**
   * 选择塔
   */
  selectTower(tileX: number, tileY: number): Tower | null {
    const tower = this.towers.find(t => t.x === tileX && t.y === tileY);
    this.selectedTower = tower ?? null;
    return this.selectedTower;
  }

  /**
   * 获取建造位置
   */
  getBuildPosition(): { tx: number; ty: number } {
    return { tx: this.buildX, ty: this.buildY };
  }

  /**
   * 获取选中塔
   */
  getSelectedTower(): Tower | null {
    return this.selectedTower;
  }

  /**
   * 取消选择
   */
  deselectTower(): void {
    this.selectedTower = null;
  }

  /**
   * 获取塔配置
   */
  getTowerConfig(type: number) {
    return this.towerConfigs[type];
  }

  /**
   * 获取所有可建造的塔类型
   */
  getBuildableTowerTypes(): number[] {
    return Object.keys(this.towerConfigs).map(Number).filter(t => t <= 9);
  }

  /**
   * 根据ID获取武将名称
   */
  private getHeroName(heroId: number): string | null {
    // 从HEROES数组查找
    // 延迟导入避免循环依赖
    const hero = HEROES_MAP[heroId];
    return hero?.name ?? null;
  }

  /**
   * 重置塔系统 (新增方法)
   * 清空所有塔, 用于重新开始关卡
   */
  reset(): void {
    this.towers = [];
    this.selectedTower = null;
    this.buildMode = false;
    this.buildX = 0;
    this.buildY = 0;
  }

  // ============================================================
  // 新增: 敌人攻击塔接口 (对应原版 checkEnemyAttack / helperV_1P)
  // ============================================================

  /**
   * 对塔造成伤害 (新增方法)
   * 对应原版 helperV_1P 中塔HP递减逻辑
   * @param tower 目标塔
   * @param damage 伤害值
   * @returns 塔是否被摧毁
   */
  damageTower(tower: Tower, damage: number): boolean {
    // debuff 期间受到双倍伤害 (对应原版 var16[15]=48)
    const actualDamage = tower.debuffTimer > 0 ? damage * 2 : damage;
    tower.hp -= actualDamage;
    if (tower.hp <= 0) {
      // 塔被摧毁
      this.towers = this.towers.filter(t => t !== tower);
      if (this.selectedTower === tower) {
        this.selectedTower = null;
      }
      return true;
    }
    return false;
  }

  /**
   * 对塔施加 debuff (新增方法)
   * 对应原版 case 8,9 的 tower[15] = 48
   * @param tower 目标塔
   * @param duration debuff 持续时间 (帧)
   */
  applyDebuff(tower: Tower, duration: number = 48): void {
    tower.debuffTimer = Math.max(tower.debuffTimer, duration);
  }

  /**
   * 更新塔的 debuff 计时器 (新增方法)
   * 每帧调用
   */
  updateDebuffs(): void {
    for (const tower of this.towers) {
      if (tower.debuffTimer > 0) {
        tower.debuffTimer--;
      }
    }
  }

  /**
   * 获取指定位置附近的塔 (新增方法)
   * 用于敌人范围攻击
   * @param cx 中心X (像素)
   * @param cy 中心Y (像素)
   * @param range 搜索半径 (像素)
   * @returns 范围内的塔列表
   */
  getTowersInRange(cx: number, cy: number, range: number): Tower[] {
    const result: Tower[] = [];
    for (const tower of this.towers) {
      const tx = tower.x * TILE_SIZE + TILE_SIZE / 2;
      const ty = tower.y * TILE_SIZE + TILE_SIZE / 2;
      const dist = Math.sqrt((tx - cx) ** 2 + (ty - cy) ** 2);
      if (dist <= range) {
        result.push(tower);
      }
    }
    return result;
  }

  /**
   * 从存档数据恢复塔布局 (新增方法)
   * 对应原版 RMS 读取 sanGuoTdData 后的塔状态恢复
   */
  restoreFromSave(towersData: any[]): void {
    this.towers = [];
    if (!Array.isArray(towersData)) return;
    for (const td of towersData) {
      const config = this.towerConfigs[td.type];
      if (!config) continue;
      const maxHp = td.maxHp ?? (100 + config.cost);
      const tower: Tower = {
        x: td.x ?? 0,
        y: td.y ?? 0,
        type: td.type ?? 0,
        level: td.level ?? 1,
        damage: td.damage ?? config.damage,
        range: td.range ?? config.range,
        fireRate: td.fireRate ?? config.fireRate,
        cooldown: 0,
        target: -1,
        angle: 0,
        heroId: td.heroId ?? -1,
        effectType: td.effectType ?? config.effect,
        // 新增: 恢复建筑血量
        hp: td.hp ?? maxHp,
        maxHp,
        debuffTimer: 0,
      };
      this.towers.push(tower);
    }
  }
}
