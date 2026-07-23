export interface WavePlan {
  wave: number;
  enemyType: number;
  count: number;
  spawnLane: number | null;
  bossType: number;
  bossId: number;
  elite: boolean;
}

export interface DeploymentState {
  combo: number;
  maxCombo: number;
  bonusGold: number;
  lastDeployedWave: number;
  rewardedWaves: number[];
  readyElapsedMs: number;
  comboDecayApplied: boolean;
  protectedPreparationWave: number | null;
}

export const DEPLOYMENT_CONFIG = {
  fastMs: 2000,
  eligibleMs: 5000,
  maxCombo: 5,
  goldPerCombo: 1,
  maxWaveBonus: 5,
} as const;

export function createDeploymentState(source?: Partial<DeploymentState>): DeploymentState {
  return {
    combo: Math.max(0, Math.min(DEPLOYMENT_CONFIG.maxCombo, source?.combo ?? 0)),
    maxCombo: Math.max(0, Math.min(DEPLOYMENT_CONFIG.maxCombo, source?.maxCombo ?? 0)),
    bonusGold: Math.max(0, Math.floor(source?.bonusGold ?? 0)),
    lastDeployedWave: Math.max(0, Math.floor(source?.lastDeployedWave ?? 0)),
    rewardedWaves: Array.isArray(source?.rewardedWaves)
      ? [...new Set(source.rewardedWaves.map(Number).filter(Number.isFinite))]
      : [],
    readyElapsedMs: Math.max(0, Number(source?.readyElapsedMs) || 0),
    comboDecayApplied: source?.comboDecayApplied === true,
    protectedPreparationWave: Number.isFinite(source?.protectedPreparationWave)
      ? Math.max(0, Math.floor(Number(source?.protectedPreparationWave)))
      : null,
  };
}

export class DeploymentTracker {
  readonly state: DeploymentState;

  constructor(state?: Partial<DeploymentState>) {
    this.state = createDeploymentState(state);
  }

  deploy(wave: number, elapsedMs: number, protectedPreparation: boolean = false): { combo: number; timely: boolean } {
    if (wave <= 1) {
      this.state.lastDeployedWave = Math.max(this.state.lastDeployedWave, wave);
      return { combo: this.state.combo, timely: true };
    }
    if (protectedPreparation) {
      this.state.comboDecayApplied = false;
      this.state.lastDeployedWave = Math.max(this.state.lastDeployedWave, wave);
      return { combo: this.state.combo, timely: true };
    }
    const elapsed = Math.max(0, elapsedMs);
    if (elapsed <= DEPLOYMENT_CONFIG.fastMs) this.state.combo += 2;
    else if (elapsed <= DEPLOYMENT_CONFIG.eligibleMs) this.state.combo += 1;
    else if (!this.state.comboDecayApplied) this.state.combo = Math.max(0, this.state.combo - 1);
    this.state.combo = Math.min(DEPLOYMENT_CONFIG.maxCombo, this.state.combo);
    this.state.maxCombo = Math.max(this.state.maxCombo, this.state.combo);
    this.state.lastDeployedWave = Math.max(this.state.lastDeployedWave, wave);
    this.state.comboDecayApplied = false;
    return { combo: this.state.combo, timely: elapsed <= DEPLOYMENT_CONFIG.eligibleMs };
  }

  rewardWave(wave: number, blocked: boolean = false, multiplier: number = 1): number {
    if (wave <= 1 || blocked || this.state.rewardedWaves.includes(wave)) return 0;
    const base = Math.min(DEPLOYMENT_CONFIG.maxWaveBonus, this.state.combo * DEPLOYMENT_CONFIG.goldPerCombo);
    const reward = Math.max(0, Math.floor(base * Math.max(1, multiplier)));
    this.state.rewardedWaves.push(wave);
    this.state.bonusGold += reward;
    return reward;
  }

  /** 准备窗口耗尽时只下降一级，并且同一个准备窗口只结算一次。 */
  expireCombo(elapsedMs: number): boolean {
    if (this.state.combo <= 0
      || this.state.comboDecayApplied
      || Math.max(0, elapsedMs) <= DEPLOYMENT_CONFIG.eligibleMs) return false;
    this.state.combo = Math.max(0, this.state.combo - 1);
    this.state.comboDecayApplied = true;
    return true;
  }

  protectPreparationAfter(wave: number): void {
    this.state.protectedPreparationWave = Math.max(0, Math.floor(wave));
    this.state.comboDecayApplied = false;
  }

  isPreparationProtected(wave: number): boolean {
    return this.state.protectedPreparationWave === Math.max(0, Math.floor(wave));
  }

  consumeProtectedPreparation(wave: number): boolean {
    if (!this.isPreparationProtected(wave)) return false;
    this.state.protectedPreparationWave = null;
    this.state.comboDecayApplied = false;
    return true;
  }

  resetCombo(): void {
    this.state.combo = 0;
    this.state.comboDecayApplied = false;
  }

  serialize(): DeploymentState {
    return createDeploymentState(this.state);
  }
}

export const ENEMY_TYPE_NAMES = ['散兵', '步兵', '重装', '骑兵', '弓弩', '投石'];
