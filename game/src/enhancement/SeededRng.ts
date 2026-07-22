export interface SerializedRng {
  algorithm: 'xorshift32';
  state: number;
}

const NON_ZERO_FALLBACK = 0x6d2b79f5;

/** 小型可保存 PRNG；所有强化内容随机数都从这里注入。 */
export class SeededRng {
  private state: number;

  constructor(seed: number) {
    this.state = (seed >>> 0) || NON_ZERO_FALLBACK;
  }

  next(): number {
    let x = this.state >>> 0;
    x ^= x << 13;
    x ^= x >>> 17;
    x ^= x << 5;
    this.state = (x >>> 0) || NON_ZERO_FALLBACK;
    return this.state / 0x100000000;
  }

  nextInt(maxExclusive: number): number {
    const max = Math.max(0, Math.floor(maxExclusive));
    return max <= 1 ? 0 : Math.floor(this.next() * max);
  }

  pick<T>(items: readonly T[]): T | undefined {
    return items.length === 0 ? undefined : items[this.nextInt(items.length)];
  }

  shuffle<T>(items: readonly T[]): T[] {
    const copy = [...items];
    for (let i = copy.length - 1; i > 0; i--) {
      const j = this.nextInt(i + 1);
      [copy[i], copy[j]] = [copy[j], copy[i]];
    }
    return copy;
  }

  snapshot(): SerializedRng {
    return { algorithm: 'xorshift32', state: this.state >>> 0 };
  }

  restore(snapshot: Partial<SerializedRng> | number): void {
    const value = typeof snapshot === 'number' ? snapshot : snapshot.state;
    this.state = (Number(value) >>> 0) || NON_ZERO_FALLBACK;
  }
}

export function createBattleSeed(level: number, faction: number, now: number = Date.now()): number {
  let seed = (Math.floor(now) ^ ((level + 1) * 0x9e3779b1) ^ ((faction + 1) * 0x85ebca6b)) >>> 0;
  seed ^= seed >>> 16;
  return seed || NON_ZERO_FALLBACK;
}
