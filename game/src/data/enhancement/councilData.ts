export type CouncilModifierKey =
  | 'waveIncome' | 'buildDiscount' | 'upgradeDiscount' | 'salvageBonus'
  | 'fireDuration' | 'fireInitialDamage' | 'freezeShatterDamage' | 'freezeDuration'
  | 'poisonTickDamage' | 'limeFireRate' | 'paralyzeDuration' | 'paralyzeFireRate'
  | 'burningZoneDuration' | 'oilBuildCost' | 'lowDefenseDamage'
  | 'comboReward' | 'normalEnemyHealth';

export interface CouncilPrototypeGrant {
  /** 对应城池科技装置下标（0..4）。 */
  techIndex: number;
  /** 获得一次样机优惠的原版建筑类型（0..10）。 */
  towerType: number;
  /** 对应科技装置的一次性折扣。 */
  techDiscount: number;
  /** 对应建筑下一座样机的一次性折扣。 */
  towerDiscount: number;
}

export interface CouncilDefinition {
  id: string;
  name: string;
  benefit: string;
  cost: string;
  modifiers: Partial<Record<CouncilModifierKey, number>>;
  kind: 'economy' | 'combat' | 'survival';
  /** 只有场上已有对应建筑时才会进入候选，避免给玩家无法使用的死选项。 */
  requiresBuiltAny?: readonly number[];
  requiresBuiltAll?: readonly number[];
  buildUses?: number;
  upgradeUses?: number;
  /** 状态类军议附带的科技扶持与低价样机，均在实际购买后才消费。 */
  prototype?: CouncilPrototypeGrant;
  immediate?: 'reinforce_city';
  resetCombo?: boolean;
}

export const COUNCIL_CONTENT_VERSION = 3;

export const COUNCIL_DEFINITIONS: readonly CouncilDefinition[] = [
  {
    id: 'steady_income', name: '稳固军饷',
    benefit: '今后每波完成额外 +4 金', cost: '放弃本次其他军策',
    modifiers: { waveIncome: 4 }, kind: 'economy',
  },
  {
    id: 'rapid_works', name: '急造工事',
    benefit: '下一座建筑费用 -30%', cost: '仅生效一次',
    modifiers: { buildDiscount: 0.3 }, buildUses: 1, kind: 'economy',
  },
  {
    id: 'veteran_engineers', name: '老练工匠',
    benefit: '接下来两次升级费用 -20%', cost: '仅生效两次',
    modifiers: { upgradeDiscount: 0.2 }, upgradeUses: 2, kind: 'economy',
  },
  {
    id: 'salvage_order', name: '拆旧补新',
    benefit: '拆除回收额外 +10%', cost: '回收不超过实际投入',
    modifiers: { salvageBonus: 0.1 }, kind: 'economy',
  },
  {
    id: 'long_burn', name: '延烧之策',
    benefit: '火焰持续时间 +25%', cost: '烟火初次伤害 -10%',
    modifiers: { fireDuration: 0.25, fireInitialDamage: -0.1 }, kind: 'combat',
    prototype: { techIndex: 2, towerType: 3, techDiscount: 0.4, towerDiscount: 0.5 },
  },
  {
    id: 'deep_freeze', name: '深寒',
    benefit: '碎冰伤害 +10', cost: '冰冻持续时间 -10%',
    modifiers: { freezeShatterDamage: 10, freezeDuration: -0.1 }, kind: 'combat',
    prototype: { techIndex: 4, towerType: 5, techDiscount: 0.4, towerDiscount: 0.5 },
  },
  {
    id: 'toxic_lime', name: '烈性石灰',
    benefit: '中毒每跳伤害 +1', cost: '石灰瓶攻击间隔 +15%',
    modifiers: { poisonTickDamage: 1, limeFireRate: 0.15 }, kind: 'combat',
    prototype: { techIndex: 0, towerType: 1, techDiscount: 0.4, towerDiscount: 0.5 },
  },
  {
    id: 'overcharge', name: '强弩过载',
    benefit: '麻痹持续时间 +20%', cost: '麻痹矢攻击间隔 +10%',
    modifiers: { paralyzeDuration: 0.2, paralyzeFireRate: 0.1 }, kind: 'combat',
    prototype: { techIndex: 3, towerType: 4, techDiscount: 0.4, towerDiscount: 0.5 },
  },
  {
    id: 'oil_reserve', name: '油料充足',
    benefit: '油火燃烧地带持续时间 +50%', cost: '滚油建造费用 +10%',
    modifiers: { burningZoneDuration: 0.5, oilBuildCost: 0.1 }, kind: 'combat',
    requiresBuiltAny: [3],
    prototype: { techIndex: 4, towerType: 9, techDiscount: 0.4, towerDiscount: 0.5 },
  },
  {
    id: 'reinforce_city', name: '临时加固',
    benefit: '立即恢复 1 城防', cost: '连战归零',
    modifiers: {}, immediate: 'reinforce_city', resetCombo: true, kind: 'survival',
  },
  {
    id: 'last_stand', name: '背水',
    benefit: '城防不高于 3 时伤害 +20%', cost: '其他时间没有收益',
    modifiers: { lowDefenseDamage: 0.2 }, kind: 'survival',
  },
  {
    id: 'forced_march', name: '催军',
    benefit: '连战金币 +50%', cost: '普通敌军生命 +12%',
    modifiers: { comboReward: 1.5, normalEnemyHealth: 0.12 }, kind: 'combat',
  },
] as const;

export const COUNCIL_BY_ID = new Map(COUNCIL_DEFINITIONS.map(def => [def.id, def]));
