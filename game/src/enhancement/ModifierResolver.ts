import { COUNCIL_BY_ID, CouncilModifierKey } from '../data/enhancement/councilData';
import { CouncilSystem } from './CouncilSystem';
import { FeatureContext } from './Ruleset';

export class ModifierResolver {
  constructor(private features: FeatureContext, private council: CouncilSystem) {}

  private sum(key: CouncilModifierKey): number {
    if (!this.features.enhanced) return 0;
    return this.council.state.selectedIds.reduce((sum, id) => sum + (COUNCIL_BY_ID.get(id)?.modifiers[key] ?? 0), 0);
  }

  waveIncome(): number { return Math.max(0, Math.floor(this.sum('waveIncome'))); }
  comboRewardMultiplier(): number { return Math.max(1, this.sum('comboReward') || 1); }
  enemySpeed(base: number, _elite: boolean): number { return base; }
  enemyHealth(base: number, elite: boolean): number {
    return elite ? base : Math.max(1, Math.round(base * (1 + this.sum('normalEnemyHealth'))));
  }
  buildCost(base: number, towerType: number): number {
    let result = base;
    if (this.council.state.buildDiscountUses > 0) result *= 1 - this.sum('buildDiscount');
    if (towerType === 9) result *= 1 + this.sum('oilBuildCost');
    return Math.max(1, Math.round(result));
  }
  upgradeCost(base: number): number {
    const factor = this.council.state.upgradeDiscountUses > 0 ? 1 - this.sum('upgradeDiscount') : 1;
    return Math.max(1, Math.round(base * factor));
  }
  demolishRefund(base: number, maxInvested: number): number {
    return Math.min(maxInvested, Math.max(0, Math.floor(base * (1 + this.sum('salvageBonus')))));
  }
  directDamage(raw: number, towerType: number, lives: number): number {
    let factor = 1;
    if (lives <= 3) factor += this.sum('lowDefenseDamage');
    if (towerType === 3) factor += this.sum('fireInitialDamage');
    return Math.max(1, Math.floor(raw * factor));
  }
  fireDuration(base: number): number { return Math.max(1, Math.round(base * (1 + this.sum('fireDuration')))); }
  freezeDuration(base: number): number { return Math.max(1, Math.round(base * (1 + this.sum('freezeDuration')))); }
  paralyzeDuration(base: number): number { return Math.max(1, Math.round(base * (1 + this.sum('paralyzeDuration')))); }
  poisonDamage(base: number): number { return Math.max(0, Math.floor(base + this.sum('poisonTickDamage'))); }
  fireRate(base: number, towerType: number): number {
    const extra = towerType === 1 ? this.sum('limeFireRate') : towerType === 4 ? this.sum('paralyzeFireRate') : 0;
    return Math.max(0, Math.round(base * (1 + extra)));
  }
  freezeShatterDamage(base: number): number { return Math.max(0, Math.floor(base + this.sum('freezeShatterDamage'))); }
  burningZoneDuration(base: number): number { return Math.max(1, Math.round(base * (1 + this.sum('burningZoneDuration')))); }
}
