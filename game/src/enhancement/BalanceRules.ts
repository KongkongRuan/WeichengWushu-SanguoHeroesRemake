import type { RulesetId } from './Ruleset';

export const ENHANCED_BALANCE = {
  earlyBossBreachDamage: 2,
  lateBossBreachDamage: 3,
  lateBossWave: 16,
  duplicateGraceCount: 3,
  duplicateSurchargeStep: 0.15,
  duplicateSurchargeCap: 0.75,
} as const;

/** 强化规则中，名将越到后期破城威胁越高；经典规则始终保持原版的 1 点。 */
export function bossBreachDamage(rulesetId: RulesetId, wave: number): number {
  if (rulesetId !== 'enhanced') return 1;
  return wave >= ENHANCED_BALANCE.lateBossWave
    ? ENHANCED_BALANCE.lateBossBreachDamage
    : ENHANCED_BALANCE.earlyBossBreachDamage;
}

export function enemyBreachDamage(rulesetId: RulesetId, wave: number, elite: boolean): number {
  return elite ? bossBreachDamage(rulesetId, wave) : 1;
}

/**
 * existingCount 是落成前已有的同类建筑数。前三座原价，从第四座开始每座 +15%，
 * 最高 +75%。该函数只计算强化规则的软性反堆叠费用。
 */
export function duplicateTowerSurcharge(existingCount: number): number {
  const paidDuplicates = Math.max(0, Math.floor(existingCount) - ENHANCED_BALANCE.duplicateGraceCount + 1);
  return Math.min(
    ENHANCED_BALANCE.duplicateSurchargeCap,
    paidDuplicates * ENHANCED_BALANCE.duplicateSurchargeStep,
  );
}

export function formatPercent(value: number): string {
  return `${Math.round(value * 100)}%`;
}
