import { COUNCIL_BY_ID, COUNCIL_DEFINITIONS, CouncilDefinition } from '../data/enhancement/councilData';
import { SeededRng } from './SeededRng';

export interface CouncilOfferContext {
  builtTowerTypes?: readonly number[];
}

export interface CouncilRunState {
  triggeredWaves: number[];
  pendingWave: number | null;
  pendingOffer: string[];
  selectedIds: string[];
  skippedWaves: number[];
  buildDiscountUses: number;
  upgradeDiscountUses: number;
  /** 尚未使用的军议科技折扣，按科技装置下标保存。 */
  techDiscounts: number[];
  /** 尚未使用的军议样机折扣，按建筑类型保存。 */
  prototypeDiscounts: number[];
}

const TECH_COUNT = 5;
const TOWER_TYPE_COUNT = 11;
const MAX_DISCOUNT = 0.95;

function normalizeDiscounts(source: unknown, length: number): number[] {
  const values = Array.isArray(source) ? source : [];
  return Array.from({ length }, (_, index) => {
    const value = Number(values[index]);
    return Number.isFinite(value) ? Math.max(0, Math.min(MAX_DISCOUNT, value)) : 0;
  });
}

export function createCouncilState(source?: Partial<CouncilRunState>): CouncilRunState {
  const ids = new Set(COUNCIL_DEFINITIONS.map(item => item.id));
  const valid = (items: unknown): string[] => Array.isArray(items)
    ? items.filter((id): id is string => typeof id === 'string' && ids.has(id))
    : [];
  return {
    triggeredWaves: Array.isArray(source?.triggeredWaves) ? [...new Set(source.triggeredWaves.map(Number))] : [],
    pendingWave: Number.isFinite(source?.pendingWave) ? Number(source?.pendingWave) : null,
    pendingOffer: valid(source?.pendingOffer),
    selectedIds: valid(source?.selectedIds),
    skippedWaves: Array.isArray(source?.skippedWaves) ? [...new Set(source.skippedWaves.map(Number))] : [],
    buildDiscountUses: Math.max(0, Math.floor(source?.buildDiscountUses ?? 0)),
    upgradeDiscountUses: Math.max(0, Math.floor(source?.upgradeDiscountUses ?? 0)),
    techDiscounts: normalizeDiscounts(source?.techDiscounts, TECH_COUNT),
    prototypeDiscounts: normalizeDiscounts(source?.prototypeDiscounts, TOWER_TYPE_COUNT),
  };
}

export class CouncilSystem {
  readonly state: CouncilRunState;

  constructor(private readonly rng: SeededRng, state?: Partial<CouncilRunState>) {
    this.state = createCouncilState(state);
  }

  offerAfterWave(
    wave: number,
    totalWaves: number,
    context: CouncilOfferContext = {},
  ): readonly CouncilDefinition[] {
    // 军议只在名将波结束后召开，让每四波形成“作战 → 斩将 → 整备”的完整节奏。
    if (wave <= 0 || wave >= totalWaves || wave % 4 !== 0) return [];
    if (this.state.triggeredWaves.includes(wave)) return this.pendingDefinitions;
    const selected = new Set(this.state.selectedIds);
    const built = new Set(context.builtTowerTypes ?? []);
    const candidates = COUNCIL_DEFINITIONS.filter(def => {
      if (selected.has(def.id)) return false;
      if (def.requiresBuiltAny?.length && !def.requiresBuiltAny.some(type => built.has(type))) return false;
      if (def.requiresBuiltAll?.length && !def.requiresBuiltAll.every(type => built.has(type))) return false;
      return true;
    });
    const offer: CouncilDefinition[] = [];
    const addOne = (kind: CouncilDefinition['kind']) => {
      const pool = this.rng.shuffle(candidates.filter(def => def.kind === kind && !offer.includes(def)));
      if (pool[0]) offer.push(pool[0]);
    };
    // 三张牌保持功能差异，避免一次军议全是金币折扣或全是当前无法理解的状态强化。
    addOne('combat');
    addOne('survival');
    addOne('economy');
    for (const def of this.rng.shuffle(candidates)) {
      if (offer.length >= 3) break;
      if (!offer.includes(def)) offer.push(def);
    }
    this.state.triggeredWaves.push(wave);
    this.state.pendingWave = wave;
    this.state.pendingOffer = offer.slice(0, 3).map(def => def.id);
    return this.pendingDefinitions;
  }

  get pendingDefinitions(): readonly CouncilDefinition[] {
    return this.state.pendingOffer.map(id => COUNCIL_BY_ID.get(id)).filter((x): x is CouncilDefinition => !!x);
  }

  resolve(id: string | null): CouncilDefinition | null {
    if (this.state.pendingWave == null) return null;
    const wave = this.state.pendingWave;
    let selected: CouncilDefinition | null = null;
    if (id != null && this.state.pendingOffer.includes(id)) {
      selected = COUNCIL_BY_ID.get(id) ?? null;
      if (selected) {
        if (!selected.immediate) this.state.selectedIds.push(selected.id);
        this.state.buildDiscountUses += selected.buildUses ?? 0;
        this.state.upgradeDiscountUses += selected.upgradeUses ?? 0;
        if (selected.prototype) {
          const grant = selected.prototype;
          this.state.techDiscounts[grant.techIndex] = Math.max(
            this.techDiscount(grant.techIndex),
            grant.techDiscount,
          );
          this.state.prototypeDiscounts[grant.towerType] = Math.max(
            this.prototypeDiscount(grant.towerType),
            grant.towerDiscount,
          );
        }
      }
    } else {
      this.state.skippedWaves.push(wave);
    }
    this.state.pendingWave = null;
    this.state.pendingOffer = [];
    return selected;
  }

  has(id: string): boolean {
    return this.state.selectedIds.includes(id);
  }

  consumeBuildDiscount(): boolean {
    if (this.state.buildDiscountUses <= 0) return false;
    this.state.buildDiscountUses--;
    return true;
  }

  consumeUpgradeDiscount(): boolean {
    if (this.state.upgradeDiscountUses <= 0) return false;
    this.state.upgradeDiscountUses--;
    return true;
  }

  techDiscount(techIndex: number): number {
    return this.state.techDiscounts[techIndex] ?? 0;
  }

  prototypeDiscount(towerType: number): number {
    return this.state.prototypeDiscounts[towerType] ?? 0;
  }

  consumeTechDiscount(techIndex: number): boolean {
    if (this.techDiscount(techIndex) <= 0) return false;
    this.state.techDiscounts[techIndex] = 0;
    return true;
  }

  consumePrototypeDiscount(towerType: number): boolean {
    if (this.prototypeDiscount(towerType) <= 0) return false;
    this.state.prototypeDiscounts[towerType] = 0;
    return true;
  }

  selectedDefinitions(): CouncilDefinition[] {
    return this.state.selectedIds.map(id => COUNCIL_BY_ID.get(id)).filter((x): x is CouncilDefinition => !!x);
  }

  serialize(): CouncilRunState {
    return createCouncilState(this.state);
  }
}
