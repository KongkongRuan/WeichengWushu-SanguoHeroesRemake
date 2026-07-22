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
}

export const DEPLOYMENT_CONFIG = {
  fastMs: 2000,
  eligibleMs: 5000,
  maxCombo: 5,
  goldPerCombo: 2,
  maxWaveBonus: 10,
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
  };
}

export class DeploymentTracker {
  readonly state: DeploymentState;

  constructor(state?: Partial<DeploymentState>) {
    this.state = createDeploymentState(state);
  }

  deploy(wave: number, elapsedMs: number): { combo: number; timely: boolean } {
    if (wave <= 1) {
      this.state.lastDeployedWave = Math.max(this.state.lastDeployedWave, wave);
      return { combo: this.state.combo, timely: true };
    }
    const elapsed = Math.max(0, elapsedMs);
    if (elapsed <= DEPLOYMENT_CONFIG.fastMs) this.state.combo += 2;
    else if (elapsed <= DEPLOYMENT_CONFIG.eligibleMs) this.state.combo += 1;
    else this.state.combo = 0;
    this.state.combo = Math.min(DEPLOYMENT_CONFIG.maxCombo, this.state.combo);
    this.state.maxCombo = Math.max(this.state.maxCombo, this.state.combo);
    this.state.lastDeployedWave = Math.max(this.state.lastDeployedWave, wave);
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

  /** 准备窗口耗尽时立即中断已有连战；没有连战时不产生重复结算。 */
  expireCombo(elapsedMs: number): boolean {
    if (this.state.combo <= 0 || Math.max(0, elapsedMs) <= DEPLOYMENT_CONFIG.eligibleMs) return false;
    this.state.combo = 0;
    return true;
  }

  resetCombo(): void {
    this.state.combo = 0;
  }

  serialize(): DeploymentState {
    return createDeploymentState(this.state);
  }
}

export const ENEMY_TYPE_NAMES = ['散兵', '步兵', '重装', '骑兵', '弓弩', '投石'];
