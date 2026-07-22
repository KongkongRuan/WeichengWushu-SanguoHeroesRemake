export type CouncilModifierKey =
  | 'waveIncome' | 'buildDiscount' | 'upgradeDiscount' | 'salvageBonus'
  | 'fireDuration' | 'fireInitialDamage' | 'freezeShatterDamage' | 'freezeDuration'
  | 'poisonTickDamage' | 'limeFireRate' | 'paralyzeDuration' | 'paralyzeFireRate'
  | 'burningZoneDuration' | 'oilBuildCost' | 'lowDefenseDamage'
  | 'comboReward' | 'normalEnemySpeed';

export interface CouncilDefinition {
  id: string;
  name: string;
  benefit: string;
  cost: string;
  modifiers: Partial<Record<CouncilModifierKey, number>>;
  buildUses?: number;
  upgradeUses?: number;
  immediate?: 'reinforce_city';
  resetCombo?: boolean;
  maxStacks?: number;
}

export const COUNCIL_CONTENT_VERSION = 1;

export const COUNCIL_DEFINITIONS: readonly CouncilDefinition[] = [
  { id: 'steady_income', name: '稳固军饷', benefit: '每波完成额外 +6 金', cost: '无', modifiers: { waveIncome: 6 } },
  { id: 'rapid_works', name: '急造工事', benefit: '下一座建筑费用 -30%', cost: '一次性', modifiers: { buildDiscount: 0.3 }, buildUses: 1 },
  { id: 'veteran_engineers', name: '老练工匠', benefit: '接下来两次升级费用 -20%', cost: '两次', modifiers: { upgradeDiscount: 0.2 }, upgradeUses: 2 },
  { id: 'salvage_order', name: '拆旧补新', benefit: '拆除回收额外 +10%', cost: '不超过原造价', modifiers: { salvageBonus: 0.1 } },
  { id: 'long_burn', name: '延烧之策', benefit: '火焰持续时间 +25%', cost: '火焰初次伤害 -10%', modifiers: { fireDuration: 0.25, fireInitialDamage: -0.1 } },
  { id: 'deep_freeze', name: '深寒', benefit: '碎冰伤害 +10', cost: '冰冻持续时间 -10%', modifiers: { freezeShatterDamage: 10, freezeDuration: -0.1 } },
  { id: 'toxic_lime', name: '烈性石灰', benefit: '中毒每跳伤害 +2', cost: '石灰瓶攻击间隔 +10%', modifiers: { poisonTickDamage: 2, limeFireRate: 0.1 } },
  { id: 'overcharge', name: '强弩过载', benefit: '麻痹持续时间 +20%', cost: '麻痹矢攻击间隔 +10%', modifiers: { paralyzeDuration: 0.2, paralyzeFireRate: 0.1 } },
  { id: 'oil_reserve', name: '油料充足', benefit: '燃烧地带持续时间 +50%', cost: '滚油建造费用 +10%', modifiers: { burningZoneDuration: 0.5, oilBuildCost: 0.1 } },
  { id: 'reinforce_city', name: '临时加固', benefit: '立即恢复 1 城防', cost: '连战归零', modifiers: {}, immediate: 'reinforce_city', resetCombo: true },
  { id: 'last_stand', name: '背水', benefit: '城防不高于 3 时伤害 +20%', cost: '其他时间无收益', modifiers: { lowDefenseDamage: 0.2 } },
  { id: 'forced_march', name: '催军', benefit: '连战金币翻倍', cost: '普通敌军速度 +5%', modifiers: { comboReward: 2, normalEnemySpeed: 0.05 } },
] as const;

export const COUNCIL_BY_ID = new Map(COUNCIL_DEFINITIONS.map(def => [def.id, def]));
