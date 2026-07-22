/**
 * 金手指进度与规则。
 *
 * 这部分刻意不依赖渲染器或 localStorage，既方便存档迁移，也便于对军令上限、
 * 首次奖励和失败救援规则做纯逻辑测试。
 */

export const COMMAND_POINT_MAX = 5;

export type CheatAction =
  | 'cheat_gold'
  | 'cheat_defense'
  | 'cheat_clear_enemies'
  | 'cheat_gold_double'
  | 'cheat_all_tech';

export const CHEAT_COSTS: Readonly<Record<CheatAction, number>> = {
  cheat_gold: 1,
  cheat_defense: 2,
  cheat_clear_enemies: 2,
  cheat_gold_double: 3,
  cheat_all_tech: 5,
};

export interface CheatProfile {
  version: 1;
  commandPoints: number;
  storyCompleted: boolean;
  firstClearLevels: number[];
  flawlessLevels: number[];
  quickDeployLevels: number[];
  cleanVictoryKeys: string[];
  assistedVictoryKeys: string[];
  lastFailureKey: string | null;
  consecutiveFailures: number;
  rescueBattleKeys: string[];
}

export interface VictoryRewardInput {
  level: number;
  battleKey: string;
  usedCheat: boolean;
  flawless: boolean;
  quickDeploy: boolean;
}

export interface VictoryRewardResult {
  labels: string[];
  pointsAdded: number;
}

export interface SpendCommandResult {
  ok: boolean;
  spentRescue: number;
  spentCommandPoints: number;
}

export function createDefaultCheatProfile(): CheatProfile {
  return {
    version: 1,
    commandPoints: 0,
    storyCompleted: false,
    firstClearLevels: [],
    flawlessLevels: [],
    quickDeployLevels: [],
    cleanVictoryKeys: [],
    assistedVictoryKeys: [],
    lastFailureKey: null,
    consecutiveFailures: 0,
    rescueBattleKeys: [],
  };
}

/** 兼容缺字段、越界值和手工修改过的旧档案。 */
export function normalizeCheatProfile(raw: unknown): CheatProfile {
  const fallback = createDefaultCheatProfile();
  if (!raw || typeof raw !== 'object') return fallback;
  const value = raw as Partial<CheatProfile>;
  const numberArray = (candidate: unknown): number[] => Array.isArray(candidate)
    ? [...new Set(candidate.filter((item): item is number => Number.isInteger(item) && item >= 0))]
    : [];
  const stringArray = (candidate: unknown): string[] => Array.isArray(candidate)
    ? [...new Set(candidate.filter((item): item is string => typeof item === 'string' && item.length > 0))]
    : [];

  return {
    version: 1,
    commandPoints: Math.max(0, Math.min(COMMAND_POINT_MAX, Math.floor(Number(value.commandPoints) || 0))),
    storyCompleted: value.storyCompleted === true,
    firstClearLevels: numberArray(value.firstClearLevels),
    flawlessLevels: numberArray(value.flawlessLevels),
    quickDeployLevels: numberArray(value.quickDeployLevels),
    cleanVictoryKeys: stringArray(value.cleanVictoryKeys),
    assistedVictoryKeys: stringArray(value.assistedVictoryKeys),
    lastFailureKey: typeof value.lastFailureKey === 'string' ? value.lastFailureKey : null,
    consecutiveFailures: Math.max(0, Math.min(1, Math.floor(Number(value.consecutiveFailures) || 0))),
    rescueBattleKeys: stringArray(value.rescueBattleKeys),
  };
}

export function battleRecordKey(faction: number, level: number): string {
  return `${Math.max(0, faction | 0)}:${Math.max(0, level | 0)}`;
}

export function hasRescueCommand(profile: CheatProfile, battleKey: string): boolean {
  return profile.rescueBattleKeys.includes(battleKey);
}

export function availableCommandPoints(profile: CheatProfile, battleKey: string): number {
  return profile.commandPoints + (hasRescueCommand(profile, battleKey) ? 1 : 0);
}

/**
 * 扣除军令时优先使用只能留在当前关卡的救援军令，避免它在通关时白白消失。
 */
export function spendCommandPoints(
  profile: CheatProfile,
  battleKey: string,
  cost: number,
): SpendCommandResult {
  const normalizedCost = Math.max(0, Math.floor(cost));
  if (availableCommandPoints(profile, battleKey) < normalizedCost) {
    return { ok: false, spentRescue: 0, spentCommandPoints: 0 };
  }

  let remaining = normalizedCost;
  let spentRescue = 0;
  const rescueIndex = profile.rescueBattleKeys.indexOf(battleKey);
  if (remaining > 0 && rescueIndex >= 0) {
    profile.rescueBattleKeys.splice(rescueIndex, 1);
    remaining--;
    spentRescue = 1;
  }
  profile.commandPoints = Math.max(0, profile.commandPoints - remaining);
  return { ok: true, spentRescue, spentCommandPoints: remaining };
}

function awardCommandPoints(profile: CheatProfile, amount: number): number {
  const before = profile.commandPoints;
  profile.commandPoints = Math.min(COMMAND_POINT_MAX, before + Math.max(0, Math.floor(amount)));
  return profile.commandPoints - before;
}

/** 结算首次通关、无漏兵和快速出兵三种一次性奖励。 */
export function recordVictory(
  profile: CheatProfile,
  input: VictoryRewardInput,
): VictoryRewardResult {
  const labels: string[] = [];
  let requestedPoints = 0;

  if (!profile.firstClearLevels.includes(input.level)) {
    profile.firstClearLevels.push(input.level);
    labels.push('新关卡首次通关');
    requestedPoints++;
  }
  // 后两项是正攻挑战，使用金手指后不授予，避免用清场或加城防绕过条件。
  if (!input.usedCheat && input.flawless && !profile.flawlessLevels.includes(input.level)) {
    profile.flawlessLevels.push(input.level);
    labels.push('首次无人入城');
    requestedPoints++;
  }
  if (!input.usedCheat && input.quickDeploy && !profile.quickDeployLevels.includes(input.level)) {
    profile.quickDeployLevels.push(input.level);
    labels.push('全波次及时出兵');
    requestedPoints++;
  }

  const resultList = input.usedCheat ? profile.assistedVictoryKeys : profile.cleanVictoryKeys;
  if (!resultList.includes(input.battleKey)) resultList.push(input.battleKey);
  // 通关即结束这一关的失败连击和未使用救援令。
  profile.lastFailureKey = null;
  profile.consecutiveFailures = 0;
  profile.rescueBattleKeys = profile.rescueBattleKeys.filter((key) => key !== input.battleKey);

  return { labels, pointsAdded: awardCommandPoints(profile, requestedPoints) };
}

/**
 * 同一关连续失败两次后发放一枚救援军令。同一时间每关最多持有一枚；用掉后再失败
 * 两次可以重新获得，保证卡关玩家始终有一条继续推进的路。
 */
export function recordFailure(profile: CheatProfile, battleKey: string): boolean {
  if (hasRescueCommand(profile, battleKey)) {
    profile.lastFailureKey = battleKey;
    profile.consecutiveFailures = 0;
    return false;
  }

  if (profile.lastFailureKey === battleKey) profile.consecutiveFailures++;
  else {
    profile.lastFailureKey = battleKey;
    profile.consecutiveFailures = 1;
  }

  if (profile.consecutiveFailures < 2) return false;
  profile.rescueBattleKeys.push(battleKey);
  profile.consecutiveFailures = 0;
  return true;
}
