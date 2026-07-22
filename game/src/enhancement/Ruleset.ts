export type RulesetId = 'classic' | 'enhanced';

export const DEFAULT_RULESET: RulesetId = 'classic';

export function normalizeRuleset(value: unknown): RulesetId {
  return value === 'enhanced' ? 'enhanced' : DEFAULT_RULESET;
}

export function rulesetLabel(ruleset: RulesetId): string {
  return ruleset === 'enhanced' ? '强化' : '经典';
}

/** 集中声明增强功能开关，经典规则不会创建任何增强结算。 */
export class FeatureContext {
  constructor(readonly rulesetId: RulesetId = DEFAULT_RULESET) {}

  get enhanced(): boolean { return this.rulesetId === 'enhanced'; }
  get waveIntel(): boolean { return this.enhanced; }
  get deploymentRewards(): boolean { return this.enhanced; }
  get council(): boolean { return this.enhanced; }
  get reactions(): boolean { return this.enhanced; }
  get battleStats(): boolean { return this.enhanced; }
}
