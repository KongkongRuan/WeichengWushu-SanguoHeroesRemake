/**
 * 科技树系统 - 100%还原原版 a1052 科技树数组和升级逻辑
 * 还原 j(I I I)V 方法的科技分支选择和武将觉醒机制
 *
 * 原版逻辑:
 * - a1052[[S] 定义7条科技分支,每条分支是一个塔类型升级序列
 * - 升级时取 branchIdx = towerType >> 1, 从 a1052[branchIdx] 获取可升级序列
 * - 塔升到分支顶点(类型10=装置)时可觉醒武将
 * - 武将与阵营绑定: 蜀(刘备)/魏(曹操)/吴(孙权)/群(董卓)
 * - 科技效果分为17种(TECH_EFFECTS),影响攻击/减速/冰冻/麻痹/中毒/火焰等
 */
import {
  TECH_BRANCHES,
  TECH_EFFECTS,
  HEROES,
  TOWER_NAMES,
  TOWER_DESCRIPTIONS,
  HERO_VOICE_LINES,
  Faction,
  Hero,
  TechEffect,
} from '../data/heroes';
import { TOWER_UPGRADE_COST_R1101 } from '../data/gameData';
import { Tower } from './Tower';

// ============================================================
// 科技效果类型 - 17种效果对应原版 b1015[122]-b1015[154]
// ============================================================
export type TechEffectType =
  | 'attackTimeUp'      // 0: 攻击时间延长
  | 'damageUp'          // 1-3: 加强攻击伤害
  | 'aoeParalyze'       // 4: 范围麻痹
  | 'aoeFreeze'         // 5: 范围冰冻
  | 'globalAtkUp'       // 6: 全军攻击增加
  | 'reloadHalf'        // 7: 装填半价
  | 'fireRateUp'        // 8,13: 攻击频率
  | 'auraAtkUp'         // 9: 周围塔增益
  | 'aoeSlow'           // 10,11: 范围减速
  | 'poisonExtend'      // 12: 中毒延长
  | 'fireExtend'       // 14: 火焰延长
  | 'paralyzeUp'       // 15: 麻痹增强
  | 'freezeUp'         // 16: 冰冻增强
  | 'goldDouble';      // 金币翻倍 (金手指)

// 效果应用目标类型 (新增: 用于效果分发)
export type EffectTarget =
  | 'selfTower'         // 仅作用于释放该科技的塔
  | 'allTowers'         // 作用于所有塔
  | 'nearbyTowers'      // 作用于周围塔 (光环)
  | 'enemies'           // 作用于敌人
  | 'global'            // 全局效果
  | 'economy';          // 经济效果

// 效果应用上下文 (新增: 传递给 applyEffect 方法)
export interface EffectContext {
  sourceTower?: Tower;          // 触发效果的塔
  targetEnemies?: any[];        // 目标敌人列表
  nearbyTowers?: Tower[];       // 周围塔列表
  allTowers?: Tower[];          // 所有塔
}

export interface TechEffectInstance {
  id: number;
  type: TechEffectType;
  level: number;
  data: TechEffect;
}

export interface HeroState {
  hero: Hero;
  towerId: number;     // 绑定的塔索引
  awakened: boolean;   // 是否已觉醒
  faction: Faction;
}

// 科技分支状态
export interface BranchState {
  branchIndex: number;
  currentLevel: number;      // 当前已升级到的等级
  maxLevel: number;          // 分支最大等级
  towerTypes: number[];      // 该分支的塔类型序列
  unlocked: boolean;         // 是否已解锁
}

// ============================================================
// 科技树系统
// ============================================================
export class TechTreeSystem {
  // 已解锁的科技效果
  private unlockedEffects: Set<number> = new Set();
  // 科技效果实例
  private effectInstances: TechEffectInstance[] = [];
  // 各分支状态
  private branches: BranchState[] = [];
  // 已觉醒武将
  private awakenedHeroes: HeroState[] = [];
  // 当前阵营
  private currentFaction: Faction = Faction.SHU;
  // 金币
  private gold: number = 0;
  // 全局攻击加成 (科技效果6)
  private globalAtkBonus: number = 0;
  // 全局攻速加成
  private globalFireRateBonus: number = 0;
  // 金币翻倍标志
  private goldDouble: boolean = false;
  // 装填半价标志
  private reloadHalf: boolean = false;
  // ====== 新增: 17种科技效果等级跟踪 (对应原版 a1056 数组) ======
  // 局部效果等级 (作用于单个塔)
  private attackTimeUpLevel: number = 0;       // 效果0: 攻击时间延长
  private damageUpLevel: number = 0;           // 效果1-3: 伤害提升
  private aoeParalyzeLevel: number = 0;        // 效果4: 范围麻痹
  private aoeFreezeLevel: number = 0;          // 效果5: 范围冰冻
  private auraAtkUpLevel: number = 0;          // 效果9: 周围塔增益
  private aoeSlowLevel: number = 0;            // 效果10,11: 范围减速
  private poisonExtendLevel: number = 0;       // 效果12: 中毒延长
  private fireExtendLevel: number = 0;         // 效果14: 火焰延长
  private paralyzeUpLevel: number = 0;         // 效果15: 麻痹增强
  private freezeUpLevel: number = 0;           // 效果16: 冰冻增强
  // 塔类型解锁状态 (对应原版 e1105 数组, 索引为塔类型0-9)
  private towerTypeUnlocked: boolean[] = [
    true, false, false, false, false,
    false, false, false, false, false,
  ];

  private onGoldSpent: ((cost: number) => void) | null = null;
  private onHeroAwakened: ((hero: Hero) => void) | null = null;

  constructor() {
    this.initBranches();
  }

  /**
   * 初始化科技分支状态
   * 还原 a1052 数组结构
   */
  private initBranches(): void {
    this.branches = TECH_BRANCHES.map((branch, idx) => ({
      branchIndex: idx,
      currentLevel: 0,
      maxLevel: branch.length,
      towerTypes: branch,
      unlocked: idx === 0, // 分支0默认解锁
    }));
  }

  /**
   * 设置当前阵营
   */
  setFaction(faction: Faction): void {
    this.currentFaction = faction;
  }

  /**
   * 设置金币
   */
  setGold(gold: number): void {
    this.gold = gold;
  }

  setOnGoldSpent(cb: (cost: number) => void): void {
    this.onGoldSpent = cb;
  }

  setOnHeroAwakened(cb: (hero: Hero) => void): void {
    this.onHeroAwakened = cb;
  }

  /** TowerSystem 按原版终阶门禁完成升级后，把觉醒结果登记到存档状态。 */
  registerAwakenedHero(tower: Tower, hero: Hero): void {
    const towerId = this.getTowerId(tower);
    const existing = this.awakenedHeroes.find(h => h.towerId === towerId);
    if (existing) {
      existing.hero = hero;
      existing.awakened = true;
      existing.faction = this.currentFaction;
      return;
    }
    this.awakenedHeroes.push({
      hero,
      towerId,
      awakened: true,
      faction: this.currentFaction,
    });
  }

  /**
   * 获取所有分支状态
   */
  getBranches(): BranchState[] {
    return this.branches;
  }

  /**
   * 根据塔类型获取所属科技分支
   * 还原原版 j(I I I)V 中的 shr-int/lit8 v0, v10, 1 (towerType >> 1)
   */
  getBranchByTowerType(towerType: number): BranchState | null {
    const branchIdx = towerType >> 1;
    return this.branches[branchIdx] ?? null;
  }

  /**
   * 检查塔是否可以升级到下一个科技阶段
   * 还原原版 "现在还不能升级这个建筑" 检查逻辑
   */
  canUpgradeTech(tower: Tower): { canUpgrade: boolean; reason?: string; cost?: number } {
    const branch = this.getBranchByTowerType(tower.type);
    if (!branch) {
      return { canUpgrade: false, reason: '该塔无对应科技分支' };
    }

    // 原版塔等级是 0..6（H5实体层用 1..7 表示），费用来自 r1101，
    // 不是科技描述里的 100/150/200 金。科技建筑负责“能否建造”，
    // 已建成的塔可以按原版费用逐级升级。
    const nextLevel = tower.level;
    if (nextLevel >= 7) {
      return { canUpgrade: false, reason: '该塔已是最高级' };
    }

    const [baseCost, stepCost] = TOWER_UPGRADE_COST_R1101[tower.type] ?? [50, 50];
    const upgradeCost = baseCost + stepCost * Math.max(0, nextLevel - 1);
    if (this.gold < upgradeCost) {
      return { canUpgrade: false, reason: '金币不足', cost: upgradeCost };
    }

    // 获取下一个科技效果（达到顶级时仍允许觉醒武将）
    return { canUpgrade: true, cost: upgradeCost };
  }

  /**
   * 获取塔的下一个科技效果索引
   * 根据塔类型和当前等级计算
   */
  private getNextEffectIndex(tower: Tower): number {
    // 科技效果索引映射:
    // 分支0(基础塔): 效果0-2 (攻击时间/伤害x2)
    // 分支1(箭塔): 效果3-4 (伤害/范围麻痹)
    // 分支2(炮塔): 效果5-7 (冰冻/全军/装填)
    // 分支3(法塔): 效果8-9 (攻速/范围增益)
    // 分支4(冰塔): 效果10-12 (减速/中毒)
    // 分支5(火塔): 效果13-15 (攻速/火焰/麻痹)
    // 分支6(特殊): 效果16 (冰冻增强)

    const branchIdx = tower.type >> 1;
    const effectOffset = [
      0,  // 分支0 -> 效果0
      3,  // 分支1 -> 效果3
      5,  // 分支2 -> 效果5
      8,  // 分支3 -> 效果8
      10, // 分支4 -> 效果10
      13, // 分支5 -> 效果13
      16, // 分支6 -> 效果16
    ];

    const base = effectOffset[branchIdx] ?? 0;
    return base + (tower.level - 1);
  }

  /**
   * 升级塔的科技
   * 还原原版 j(I I I)V 升级逻辑
   */
  upgradeTech(tower: Tower): { success: boolean; effect?: TechEffect; hero?: Hero; reason?: string } {
    const check = this.canUpgradeTech(tower);
    if (!check.canUpgrade) {
      return { success: false, reason: check.reason };
    }

    const effectIdx = this.getNextEffectIndex(tower);
    const effect = TECH_EFFECTS[effectIdx] ?? TECH_EFFECTS[0];
    const [baseCost, stepCost] = TOWER_UPGRADE_COST_R1101[tower.type] ?? [50, 50];
    const upgradeCost = baseCost + stepCost * Math.max(0, tower.level - 1);

    // 扣除金币
    this.gold -= upgradeCost;
    this.onGoldSpent?.(upgradeCost);

    // 解锁科技效果
    this.unlockedEffects.add(effect.id);
    const effectType = this.mapEffectType(effect.id);
    this.effectInstances.push({
      id: effect.id,
      type: effectType,
      level: tower.level,
      data: effect,
    });

    // 应用全局效果
    this.applyGlobalEffect(effectType, tower.level);
    // 记录效果等级 (新增: 用于17种效果的应用)
    this.recordEffectLevel(effectType, tower.level);
    // 解锁塔类型 (新增: 对应原版 e1105 数组)
    // 根据科技分支索引解锁对应塔类型
    this.unlockTowerType(tower.type);
    // 同时解锁分支中的后续塔类型
    const branch = this.getBranchByTowerType(tower.type);
    if (branch) {
      for (const t of branch.towerTypes) {
        if (t <= 9) this.unlockTowerType(t);
      }
      // 更新分支状态
      branch.currentLevel = Math.max(branch.currentLevel, tower.level);
    }

    // 检查是否达到分支顶点 -> 觉醒武将
    if (branch && tower.level >= 5) {
      const hero = this.tryAwakenHero(tower, branch);
      if (hero) {
        return { success: true, effect, hero };
      }
    }

    return { success: true, effect };
  }

  /**
   * 将效果ID映射到类型
   */
  private mapEffectType(id: number): TechEffectType {
    if (id === 0) return 'attackTimeUp';
    if (id >= 1 && id <= 3) return 'damageUp';
    if (id === 4) return 'aoeParalyze';
    if (id === 5) return 'aoeFreeze';
    if (id === 6) return 'globalAtkUp';
    if (id === 7) return 'reloadHalf';
    if (id === 8 || id === 13) return 'fireRateUp';
    if (id === 9) return 'auraAtkUp';
    if (id === 10 || id === 11) return 'aoeSlow';
    if (id === 12) return 'poisonExtend';
    if (id === 14) return 'fireExtend';
    if (id === 15) return 'paralyzeUp';
    if (id === 16) return 'freezeUp';
    return 'damageUp';
  }

  /**
   * 应用全局科技效果
   * 对应原版 k(int) 方法中 g1065/h1060/b1059 数组的设置逻辑
   */
  private applyGlobalEffect(type: TechEffectType, level: number): void {
    switch (type) {
      case 'globalAtkUp':
        // 全军攻击增加: 每级+10%攻击力
        this.globalAtkBonus += 0.1;
        break;
      case 'fireRateUp':
        // 攻击频率: 每级攻速+8%
        this.globalFireRateBonus += 0.08;
        break;
      case 'reloadHalf':
        this.reloadHalf = true;
        break;
      case 'goldDouble':
        this.goldDouble = true;
        break;
      default:
        break;
    }
  }

  // ============================================================
  // 新增: 17种科技效果应用逻辑
  // 对应原版 e1105/f1106/a1056 数组对塔/敌人/金币的影响
  // ============================================================

  /**
   * 升级科技时记录效果等级 (新增方法)
   * 对应原版 k(int) 方法中 e1105[var3] = true 的设置
   */
  private recordEffectLevel(type: TechEffectType, level: number): void {
    switch (type) {
      case 'attackTimeUp':
        this.attackTimeUpLevel = Math.max(this.attackTimeUpLevel, level);
        break;
      case 'damageUp':
        this.damageUpLevel = Math.max(this.damageUpLevel, level);
        break;
      case 'aoeParalyze':
        this.aoeParalyzeLevel = Math.max(this.aoeParalyzeLevel, level);
        break;
      case 'aoeFreeze':
        this.aoeFreezeLevel = Math.max(this.aoeFreezeLevel, level);
        break;
      case 'auraAtkUp':
        this.auraAtkUpLevel = Math.max(this.auraAtkUpLevel, level);
        break;
      case 'aoeSlow':
        this.aoeSlowLevel = Math.max(this.aoeSlowLevel, level);
        break;
      case 'poisonExtend':
        this.poisonExtendLevel = Math.max(this.poisonExtendLevel, level);
        break;
      case 'fireExtend':
        this.fireExtendLevel = Math.max(this.fireExtendLevel, level);
        break;
      case 'paralyzeUp':
        this.paralyzeUpLevel = Math.max(this.paralyzeUpLevel, level);
        break;
      case 'freezeUp':
        this.freezeUpLevel = Math.max(this.freezeUpLevel, level);
        break;
      default:
        break;
    }
  }

  /**
   * 解锁塔类型 (新增方法)
   * 对应原版 e1105[塔类型] = true
   * @param towerType 塔类型索引 0-9
   */
  unlockTowerType(towerType: number): void {
    if (towerType >= 0 && towerType < this.towerTypeUnlocked.length) {
      this.towerTypeUnlocked[towerType] = true;
    }
  }

  /**
   * 检查塔类型是否已解锁
   * 对应原版 e1105[塔类型] 检查
   */
  isTowerTypeUnlocked(towerType: number): boolean {
    return this.towerTypeUnlocked[towerType] ?? false;
  }

  /**
   * 应用科技效果到塔 (新增方法)
   * 在塔攻击时调用, 根据已解锁科技效果修改塔属性
   * 对应原版 l(int) updateTowerLogic 中的科技效果应用
   *
   * @param tower 要应用效果的塔
   * @param baseDamage 基础伤害
   * @returns 应用效果后的实际伤害
   */
  applyEffectsToTowerDamage(tower: Tower, baseDamage: number): number {
    let damage = baseDamage;

    // 效果1-3: 加强攻击伤害 (每级+20%)
    if (this.damageUpLevel > 0) {
      damage *= (1 + 0.2 * this.damageUpLevel);
    }

    // 效果6: 全军攻击增加
    if (this.globalAtkBonus > 0) {
      damage *= (1 + this.globalAtkBonus);
    }

    // 效果9: 周围塔增益 (由 applyAuraBonus 单独处理, 这里不重复)

    return Math.floor(damage);
  }

  /**
   * 应用光环加成 (效果9: 周围塔攻击增加)
   * 对应原版在塔攻击时检查 f1106 数组的逻辑
   *
   * @param tower 当前塔
   * @param nearbyTowers 周围的塔列表
   * @returns 加成后的攻击力倍率
   */
  applyAuraBonus(tower: Tower, nearbyTowers: Tower[]): number {
    if (this.auraAtkUpLevel === 0) return 0;
    // 每个周围塔贡献5% * level 的攻击加成
    const bonusPerTower = 0.05 * this.auraAtkUpLevel;
    return Math.min(0.5, nearbyTowers.length * bonusPerTower);
  }

  /**
   * 应用范围效果到敌人 (新增方法)
   * 在塔攻击命中敌人时调用
   * 对应原版 s(int)/z(int) 方法中的效果应用逻辑
   *
   * @param enemy 目标敌人
   * @param towerType 释放塔的类型
   * @param towerLevel 释放塔的等级
   */
  applyAoeEffectsToEnemy(
    enemy: any,
    towerType: number,
    towerLevel: number,
  ): void {
    if (!enemy) return;

    // 效果4: 范围麻痹 - 设置敌人麻痹状态
    if (this.aoeParalyzeLevel > 0) {
      // 麻痹概率 = 30% + 10% * level
      const chance = 0.3 + 0.1 * this.aoeParalyzeLevel;
      if (Math.random() < chance) {
        enemy.effect = 1; // 麻痹
        // 效果15: 麻痹增强 - 延长麻痹时间
        const duration = (towerLevel * 10) * (1 + 0.5 * this.paralyzeUpLevel);
        enemy.timer = Math.max(enemy.timer ?? 0, duration);
      }
    }

    // 效果5: 范围冰冻 - 设置敌人冰冻状态
    if (this.aoeFreezeLevel > 0) {
      const chance = 0.3 + 0.1 * this.aoeFreezeLevel;
      if (Math.random() < chance) {
        enemy.effect = 2; // 冰冻
        // 效果16: 冰冻增强 - 延长冰冻时间
        const duration = (towerLevel * 8) * (1 + 0.5 * this.freezeUpLevel);
        enemy.timer = Math.max(enemy.timer ?? 0, duration);
      }
    }

    // 效果10,11: 范围减速
    if (this.aoeSlowLevel > 0) {
      const slowFactor = Math.max(0.3, 1 - 0.2 * this.aoeSlowLevel);
      enemy.effect = 5;
      enemy.slowScale = Math.min(enemy.slowScale ?? 1, slowFactor);
      enemy.timer = Math.max(enemy.timer ?? 0, towerLevel * 10);
    }
  }

  /**
   * 应用持续伤害效果到敌人 (新增方法)
   * 每帧调用, 处理中毒和火焰的持续伤害
   * 对应原版 s(int) 方法中的 timer 递减逻辑
   *
   * @param enemy 目标敌人
   * @param deltaTime 时间增量
   */
  applyDamageOverTime(enemy: any, deltaTime: number): void {
    if (!enemy || !enemy.effect) return;

    switch (enemy.effect) {
      case 3: { // 中毒
        const baseDmg = 2;
        // 效果12: 中毒时间延长 - 延长中毒持续时间
        const multiplier = 1 + 0.5 * this.poisonExtendLevel;
        enemy.hp = (enemy.hp ?? 0) - Math.floor(baseDmg * deltaTime * multiplier * (enemy.dotScale ?? 1));
        break;
      }
      case 4: { // 火焰
        const baseDmg = 3;
        // 效果14: 火焰伤害时间增加
        const multiplier = 1 + 0.5 * this.fireExtendLevel;
        enemy.hp = (enemy.hp ?? 0) - Math.floor(baseDmg * deltaTime * multiplier * (enemy.dotScale ?? 1));
        break;
      }
    }
  }

  /**
   * 获取攻击时间延长加成 (效果0)
   * 对应原版塔攻击持续时间的延长
   */
  getAttackTimeBonus(): number {
    // 每级延长10%攻击持续时间
    return 0.1 * this.attackTimeUpLevel;
  }

  /**
   * 获取效果目标的分类 (新增辅助方法)
   * 用于UI显示和效果分发
   */
  getEffectTarget(type: TechEffectType): EffectTarget {
    switch (type) {
      case 'attackTimeUp':
      case 'damageUp':
        return 'selfTower';
      case 'globalAtkUp':
      case 'fireRateUp':
      case 'reloadHalf':
        return 'allTowers';
      case 'auraAtkUp':
        return 'nearbyTowers';
      case 'aoeParalyze':
      case 'aoeFreeze':
      case 'aoeSlow':
      case 'poisonExtend':
      case 'fireExtend':
      case 'paralyzeUp':
      case 'freezeUp':
        return 'enemies';
      case 'goldDouble':
        return 'economy';
      default:
        return 'global';
    }
  }

  /**
   * 获取所有效果等级摘要 (新增方法)
   * 用于存档和UI显示
   */
  getEffectLevels(): Record<string, number> {
    return {
      attackTimeUp: this.attackTimeUpLevel,
      damageUp: this.damageUpLevel,
      aoeParalyze: this.aoeParalyzeLevel,
      aoeFreeze: this.aoeFreezeLevel,
      globalAtkUp: Math.floor(this.globalAtkBonus * 10),
      reloadHalf: this.reloadHalf ? 1 : 0,
      fireRateUp: Math.floor(this.globalFireRateBonus * 100),
      auraAtkUp: this.auraAtkUpLevel,
      aoeSlow: this.aoeSlowLevel,
      poisonExtend: this.poisonExtendLevel,
      fireExtend: this.fireExtendLevel,
      paralyzeUp: this.paralyzeUpLevel,
      freezeUp: this.freezeUpLevel,
      goldDouble: this.goldDouble ? 1 : 0,
    };
  }

  /**
   * 尝试觉醒武将
   * 还原原版 "升到顶可获得英雄" 逻辑
   * 根据阵营和分支选择对应武将
   */
  private tryAwakenHero(tower: Tower, branch: BranchState): Hero | null {
    // 检查是否已觉醒
    const existing = this.awakenedHeroes.find(h => h.towerId === this.getTowerId(tower));
    if (existing && existing.awakened) return null;

    // 根据阵营和分支选择武将
    // 分支0-6 对应不同武将槽位
    const heroSlot = branch.branchIndex;
    const hero = this.selectHeroByFaction(this.currentFaction, heroSlot);

    if (hero) {
      this.awakenedHeroes.push({
        hero,
        towerId: this.getTowerId(tower),
        awakened: true,
        faction: this.currentFaction,
      });
      this.onHeroAwakened?.(hero);
      return hero;
    }
    return null;
  }

  /**
   * 根据阵营和槽位选择武将
   * 每个阵营有7个武将槽位对应7条科技分支
   */
  private selectHeroByFaction(faction: Faction, slot: number): Hero | null {
    // 各阵营武将起始ID
    // 蜀: 0-6 (刘备,关羽,马超,黄忠,张飞,赵云,魏延)
    // 魏: 11-16,17-21 (曹操,典韦,张辽,夏侯渊,夏侯憞,许褚 + 文臣)
    // 吴: 22-27,28-32 (孙权,凌统,甘宁,黄盖,周泰,太史慈 + 文臣)
    // 群: 33-39+ (张梁,张宝,张角,华雄,貂蝉,吕布,董卓)

    const factionStart = [
      0,   // 蜀
      11,  // 魏
      22,  // 吴
      33,  // 群
    ];

    const start = factionStart[faction] ?? 0;
    // 武系武将每阵营7位 (槽位0-6)
    const heroId = start + slot;
    const hero = HEROES.find(h => h.id === heroId);
    return hero ?? null;
  }

  /**
   * 获取塔的唯一ID
   */
  private getTowerId(tower: Tower): number {
    return tower.x * 1000 + tower.y;
  }

  /**
   * 解锁科技分支
   */
  unlockBranch(branchIndex: number): boolean {
    const branch = this.branches[branchIndex];
    if (!branch) return false;
    if (branch.unlocked) return false;
    branch.unlocked = true;
    return true;
  }

  /**
   * 获取全局攻击加成
   */
  getGlobalAtkBonus(): number {
    return this.globalAtkBonus;
  }

  /**
   * 获取全局攻速加成
   */
  getGlobalFireRateBonus(): number {
    return this.globalFireRateBonus;
  }

  /**
   * 是否装填半价
   */
  isReloadHalf(): boolean {
    return this.reloadHalf;
  }

  /**
   * 是否金币翻倍
   */
  isGoldDouble(): boolean {
    return this.goldDouble;
  }

  /**
   * 设置金币翻倍
   */
  setGoldDouble(enabled: boolean): void {
    this.goldDouble = enabled;
  }

  /**
   * 获取已解锁科技效果
   */
  getUnlockedEffects(): TechEffectInstance[] {
    return this.effectInstances;
  }

  /**
   * 获取已觉醒武将
   */
  getAwakenedHeroes(): HeroState[] {
    return this.awakenedHeroes;
  }

  /**
   * 获取武将语音
   */
  getHeroVoiceLines(heroId: number): string[] {
    return HERO_VOICE_LINES[heroId] ?? [];
  }

  /**
   * 获取塔名称
   */
  getTowerName(type: number): string {
    return TOWER_NAMES[type] ?? '未知';
  }

  /**
   * 获取塔描述
   */
  getTowerDescription(type: number): string {
    return TOWER_DESCRIPTIONS[type] ?? '';
  }

  /**
   * 重置科技树
   */
  reset(): void {
    this.unlockedEffects.clear();
    this.effectInstances = [];
    this.awakenedHeroes = [];
    this.globalAtkBonus = 0;
    this.globalFireRateBonus = 0;
    this.goldDouble = false;
    this.reloadHalf = false;
    // 重置17种效果等级 (新增)
    this.attackTimeUpLevel = 0;
    this.damageUpLevel = 0;
    this.aoeParalyzeLevel = 0;
    this.aoeFreezeLevel = 0;
    this.auraAtkUpLevel = 0;
    this.aoeSlowLevel = 0;
    this.poisonExtendLevel = 0;
    this.fireExtendLevel = 0;
    this.paralyzeUpLevel = 0;
    this.freezeUpLevel = 0;
    // 重置塔类型解锁 (仅基础塔0解锁)
    this.towerTypeUnlocked = [
      true, false, false, false, false,
      false, false, false, false, false,
    ];
    this.initBranches();
  }

  /**
   * 金手指: 获得全部科技
   * 还原原版作弊码 "获得全部科技"
   */
  cheatGetAllTech(): void {
    for (let i = 0; i < TECH_EFFECTS.length; i++) {
      if (!this.unlockedEffects.has(i)) {
        this.unlockedEffects.add(i);
        const effect = TECH_EFFECTS[i];
        const type = this.mapEffectType(i);
        this.effectInstances.push({
          id: i,
          type,
          level: 1,
          data: effect,
        });
        this.applyGlobalEffect(type, 1);
        // 新增: 同时记录效果等级
        this.recordEffectLevel(type, 1);
      }
    }
    // 解锁所有分支
    for (const branch of this.branches) {
      branch.unlocked = true;
      branch.currentLevel = branch.maxLevel;
    }
    // 解锁所有塔类型 (新增)
    for (let i = 0; i < this.towerTypeUnlocked.length; i++) {
      this.towerTypeUnlocked[i] = true;
    }
    // 启用金币翻倍
    this.goldDouble = true;
  }

  /**
   * 从存档数据恢复科技树状态 (新增方法)
   * 对应原版 RMS 读取 sanGuoTdData 的恢复逻辑
   */
  restoreFromSave(data: any): void {
    if (!data) return;
    this.reset();
    // 恢复阵营
    if (data.faction !== undefined) {
      this.currentFaction = data.faction;
    }
    // 恢复金币
    if (data.gold !== undefined) {
      this.gold = data.gold;
    }
    // 恢复已解锁效果
    if (Array.isArray(data.unlockedEffects)) {
      for (const id of data.unlockedEffects) {
        this.unlockedEffects.add(id);
        const effect = TECH_EFFECTS[id];
        if (effect) {
          const type = this.mapEffectType(id);
          this.effectInstances.push({
            id,
            type,
            level: 1,
            data: effect,
          });
          this.applyGlobalEffect(type, 1);
          this.recordEffectLevel(type, 1);
        }
      }
    }
    // 恢复效果等级 (新增)
    if (data.effectLevels) {
      const lv = data.effectLevels;
      this.attackTimeUpLevel = lv.attackTimeUp ?? 0;
      this.damageUpLevel = lv.damageUp ?? 0;
      this.aoeParalyzeLevel = lv.aoeParalyze ?? 0;
      this.aoeFreezeLevel = lv.aoeFreeze ?? 0;
      this.auraAtkUpLevel = lv.auraAtkUp ?? 0;
      this.aoeSlowLevel = lv.aoeSlow ?? 0;
      this.poisonExtendLevel = lv.poisonExtend ?? 0;
      this.fireExtendLevel = lv.fireExtend ?? 0;
      this.paralyzeUpLevel = lv.paralyzeUp ?? 0;
      this.freezeUpLevel = lv.freezeUp ?? 0;
      if (lv.globalAtkUp) this.globalAtkBonus = lv.globalAtkUp * 0.1;
      if (lv.fireRateUp) this.globalFireRateBonus = lv.fireRateUp * 0.01;
      this.reloadHalf = lv.reloadHalf === 1;
      this.goldDouble = lv.goldDouble === 1;
    }
    // 恢复塔类型解锁状态
    if (Array.isArray(data.towerTypeUnlocked)) {
      for (let i = 0; i < this.towerTypeUnlocked.length && i < data.towerTypeUnlocked.length; i++) {
        this.towerTypeUnlocked[i] = data.towerTypeUnlocked[i];
      }
    }
    // 恢复分支状态
    if (Array.isArray(data.branchesState)) {
      for (let i = 0; i < this.branches.length && i < data.branchesState.length; i++) {
        this.branches[i].unlocked = data.branchesState[i].unlocked ?? false;
        this.branches[i].currentLevel = data.branchesState[i].currentLevel ?? 0;
      }
    }
    // 恢复已觉醒武将
    if (Array.isArray(data.awakenedHeroes)) {
      for (const hs of data.awakenedHeroes) {
        const hero = HEROES.find(h => h.id === hs.heroId);
        if (hero) {
          this.awakenedHeroes.push({
            hero,
            towerId: hs.towerId,
            awakened: true,
            faction: hs.faction ?? this.currentFaction,
          });
        }
      }
    }
  }

  /**
   * 导出科技树状态到存档数据 (新增方法)
   * 对应原版 RMS 写入 sanGuoTdData 的序列化逻辑
   */
  exportToSave(): any {
    return {
      faction: this.currentFaction,
      gold: this.gold,
      unlockedEffects: Array.from(this.unlockedEffects),
      effectLevels: this.getEffectLevels(),
      towerTypeUnlocked: [...this.towerTypeUnlocked],
      branchesState: this.branches.map(b => ({
        branchIndex: b.branchIndex,
        unlocked: b.unlocked,
        currentLevel: b.currentLevel,
      })),
      awakenedHeroes: this.awakenedHeroes.map(hs => ({
        heroId: hs.hero.id,
        towerId: hs.towerId,
        faction: hs.faction,
      })),
    };
  }

  /**
   * 获取科技效果数据(用于UI显示)
   */
  getTechEffectInfo(effectId: number): TechEffect | null {
    return TECH_EFFECTS[effectId] ?? null;
  }

  /**
   * 获取下一个可升级的科技效果
   */
  getNextTechEffect(tower: Tower): TechEffect | null {
    const idx = this.getNextEffectIndex(tower);
    return TECH_EFFECTS[idx] ?? null;
  }
}
