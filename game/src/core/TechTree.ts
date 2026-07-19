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
import { Tower } from './Tower';

// ============================================================
// 科技效果类型
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

    if (!branch.unlocked) {
      return { canUpgrade: false, reason: '需要先升级城池解锁此分支' };
    }

    const nextLevel = tower.level;
    if (nextLevel >= branch.maxLevel) {
      return { canUpgrade: false, reason: '该塔已是最高级' };
    }

    // 获取下一个科技效果
    const effectIdx = this.getNextEffectIndex(tower);
    if (effectIdx < 0 || effectIdx >= TECH_EFFECTS.length) {
      return { canUpgrade: false, reason: '无可用科技效果' };
    }

    const effect = TECH_EFFECTS[effectIdx];
    if (this.gold < effect.cost) {
      return { canUpgrade: false, reason: '金币不足', cost: effect.cost };
    }

    return { canUpgrade: true, cost: effect.cost };
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
    const effect = TECH_EFFECTS[effectIdx];

    // 扣除金币
    this.gold -= effect.cost;
    this.onGoldSpent?.(effect.cost);

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

    // 更新分支状态
    const branch = this.getBranchByTowerType(tower.type);
    if (branch) {
      branch.currentLevel = Math.max(branch.currentLevel, tower.level);
    }

    // 检查是否达到分支顶点 -> 觉醒武将
    if (branch && tower.level >= branch.maxLevel - 1) {
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
    // 魏: 11-16,17-21 (曹操,典韦,张辽,夏侯渊,夏侯惇,许褚 + 文臣)
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
      }
    }
    // 解锁所有分支
    for (const branch of this.branches) {
      branch.unlocked = true;
      branch.currentLevel = branch.maxLevel;
    }
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
