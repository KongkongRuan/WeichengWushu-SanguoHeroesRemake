import type { SerializedEnemySystem } from '../core/Enemy';
import { BattleStats, SerializedBattleStats } from './BattleStats';
import { CouncilRunState, createCouncilState } from './CouncilSystem';
import { ReactionRunState } from './ReactionSystem';
import { DeploymentState, WavePlan, createDeploymentState } from './WaveIntel';

export const ENHANCEMENT_CONTENT_VERSION = 1;

export interface MedalProgress {
  leaks: number;
  quickDeployEligible: boolean;
  cheatsUsed: boolean;
}

export interface EnhancedRunStateV1 {
  version: 1;
  contentVersion: number;
  seed: number;
  rngState: number;
  currentWavePlan: WavePlan | null;
  waveRuntime?: SerializedEnemySystem;
  deployment: DeploymentState;
  council: CouncilRunState;
  reactions: ReactionRunState;
  medalProgress: MedalProgress;
  stats: SerializedBattleStats;
  lastCompletedWave: number;
}

export function createEnhancedRunState(seed: number): EnhancedRunStateV1 {
  return {
    version: 1,
    contentVersion: ENHANCEMENT_CONTENT_VERSION,
    seed: seed >>> 0,
    rngState: seed >>> 0,
    currentWavePlan: null,
    deployment: createDeploymentState(),
    council: createCouncilState(),
    reactions: { frame: 0, burningZones: [], cooldowns: {} },
    medalProgress: { leaks: 0, quickDeployEligible: true, cheatsUsed: false },
    stats: new BattleStats().serialize(),
    lastCompletedWave: 0,
  };
}

export function normalizeEnhancedRunState(source: unknown, fallbackSeed: number): EnhancedRunStateV1 {
  const raw = source && typeof source === 'object' ? source as Partial<EnhancedRunStateV1> : {};
  const base = createEnhancedRunState(Number(raw.seed) || fallbackSeed);
  return {
    ...base,
    ...raw,
    version: 1,
    contentVersion: Number(raw.contentVersion) || ENHANCEMENT_CONTENT_VERSION,
    seed: (Number(raw.seed) >>> 0) || base.seed,
    rngState: (Number(raw.rngState) >>> 0) || base.rngState,
    currentWavePlan: raw.currentWavePlan ?? null,
    deployment: createDeploymentState(raw.deployment),
    council: createCouncilState(raw.council),
    reactions: raw.reactions ?? base.reactions,
    medalProgress: { ...base.medalProgress, ...(raw.medalProgress ?? {}) },
    stats: raw.stats ?? base.stats,
    lastCompletedWave: Math.max(0, Math.floor(raw.lastCompletedWave ?? 0)),
  };
}
