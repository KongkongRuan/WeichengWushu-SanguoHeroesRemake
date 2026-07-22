import { RulesetId, normalizeRuleset } from './Ruleset';

export type MedalId = 'clear' | 'flawless' | 'swift';

export interface MedalSet { clear: boolean; flawless: boolean; swift: boolean; }
export interface BattleRecord { medals: MedalSet; bestCombo: number; bestBonusGold: number; clears: number; }
export interface BattleRecordProfile { version: 1; records: Record<string, BattleRecord>; }
export interface MedalEvaluation { earned: MedalId[]; failed: Partial<Record<MedalId, string>>; }

export function createBattleRecordKey(ruleset: RulesetId, gameMode: number, faction: number, battle: number): string {
  return `${normalizeRuleset(ruleset)}/${gameMode === 1 ? 'free' : 'story'}/${Math.max(0, faction | 0)}/${Math.max(0, battle | 0)}`;
}

export function createBattleRecordProfile(source?: Partial<BattleRecordProfile>): BattleRecordProfile {
  return { version: 1, records: source?.records && typeof source.records === 'object' ? { ...source.records } : {} };
}

export function evaluateMedals(input: { victory: boolean; leaks: number; quickDeploy: boolean; cheatsUsed: boolean }): MedalEvaluation {
  const earned: MedalId[] = [];
  const failed: Partial<Record<MedalId, string>> = {};
  if (input.victory) earned.push('clear'); else failed.clear = '未完成关卡';
  if (input.cheatsUsed) {
    failed.flawless = '使用过军令';
    failed.swift = '使用过军令';
  } else {
    if (input.leaks === 0) earned.push('flawless'); else failed.flawless = `有 ${input.leaks} 名敌军入城`;
    if (input.quickDeploy) earned.push('swift'); else failed.swift = '有波次超过 5 秒出兵';
  }
  return { earned, failed };
}

export function mergeBattleRecord(
  profile: BattleRecordProfile,
  key: string,
  evaluation: MedalEvaluation,
  bestCombo: number,
  bonusGold: number,
): { record: BattleRecord; newlyEarned: MedalId[] } {
  const old = profile.records[key] ?? {
    medals: { clear: false, flawless: false, swift: false }, bestCombo: 0, bestBonusGold: 0, clears: 0,
  };
  const newlyEarned = evaluation.earned.filter(id => !old.medals[id]);
  const record: BattleRecord = {
    medals: { ...old.medals },
    bestCombo: Math.max(old.bestCombo, bestCombo),
    bestBonusGold: Math.max(old.bestBonusGold, bonusGold),
    clears: old.clears + (evaluation.earned.includes('clear') ? 1 : 0),
  };
  for (const id of evaluation.earned) record.medals[id] = true;
  profile.records[key] = record;
  return { record, newlyEarned };
}

export const MEDAL_LABELS: Record<MedalId, string> = { clear: '破城', flawless: '无漏', swift: '迅捷' };

export function medalCount(record: BattleRecord | undefined): number {
  return record ? Object.values(record.medals).filter(Boolean).length : 0;
}
