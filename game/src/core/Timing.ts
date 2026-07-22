/** 原版主循环固定为 100ms（10Hz）一个逻辑帧。 */
export const LOGIC_STEP_MS = 100;
export const LOGIC_STEP_NORMALIZED = 6;

/**
 * 将任意刷新率的真实时间转换成固定逻辑步数。
 * 当页面后台挂起过久时限制追赶步数，防止恢复瞬间执行大量攻击/刷怪逻辑。
 */
export class FixedStepClock {
  private accumulatorMs = 0;

  constructor(private readonly stepMs: number = LOGIC_STEP_MS) {}

  advance(elapsedMs: number, speed: number = 1, maxSteps: number = 10): number {
    this.accumulatorMs += Math.max(0, elapsedMs) * Math.max(0, speed);
    const available = Math.floor((this.accumulatorMs + 1e-7) / this.stepMs);
    const steps = Math.min(available, Math.max(0, maxSteps));
    this.accumulatorMs -= steps * this.stepMs;
    if (available > maxSteps) this.accumulatorMs = 0;
    return steps;
  }

  reset(): void {
    this.accumulatorMs = 0;
  }
}

/**
 * 只累计页面可见期间的真实时间。
 *
 * 浏览器恢复后台标签页时，requestAnimationFrame 的时间戳会直接跨过整段
 * 挂起时间。可见性切换同时重置基准点，避免恢复后的第一帧把后台时间计入
 * 连战窗口、战斗逻辑或界面动画。
 */
export class VisibilityAwareClock {
  private lastTimestamp: number;
  private visible: boolean;

  constructor(initialTimestamp: number = 0, visible: boolean = true) {
    this.lastTimestamp = initialTimestamp;
    this.visible = visible;
  }

  setVisible(visible: boolean, timestamp: number): void {
    this.visible = visible;
    this.lastTimestamp = timestamp;
  }

  reset(timestamp: number): void {
    this.lastTimestamp = timestamp;
  }

  advance(timestamp: number, maxElapsedMs: number = 1000): number {
    const elapsedMs = this.visible
      ? Math.max(0, Math.min(Math.max(0, maxElapsedMs), timestamp - this.lastTimestamp))
      : 0;
    this.lastTimestamp = timestamp;
    return elapsedMs;
  }
}

/** 原版数组统一采用 base + increment * level(0-based)。 */
export function linearLevelValue(pair: readonly [number, number], level1: number): number {
  const level0 = Math.max(0, level1 - 1);
  return pair[0] + pair[1] * level0;
}

/** 原版 b(int)：建造费加上已经支付的逐级升级费，拆除时返还一半。 */
export function originalDemolishRefund(
  buildCost: number,
  upgradePair: readonly [number, number],
  level1: number,
): number {
  let invested = buildCost;
  for (let level0 = 0; level0 < Math.max(0, level1 - 1); level0++) {
    invested += upgradePair[0] + upgradePair[1] * level0;
  }
  return invested >> 1;
}

/** 原版 # 键允许出兵的完整条件。 */
export function canStartWave(state: {
  levelStarted: boolean;
  wavePending: boolean;
  enemyCount: number;
  spawnedInWave: number;
  waveSize: number;
  currentWave: number;
  totalWaves: number;
}): boolean {
  return state.levelStarted && !state.wavePending && state.enemyCount === 0 &&
    state.spawnedInWave === state.waveSize && state.currentWave < state.totalWaves;
}
