import { COUNCIL_BY_ID, COUNCIL_DEFINITIONS, CouncilDefinition } from '../data/enhancement/councilData';
import { SeededRng } from './SeededRng';

export interface CouncilRunState {
  triggeredWaves: number[];
  pendingWave: number | null;
  pendingOffer: string[];
  selectedIds: string[];
  skippedWaves: number[];
  buildDiscountUses: number;
  upgradeDiscountUses: number;
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
  };
}

export class CouncilSystem {
  readonly state: CouncilRunState;

  constructor(private readonly rng: SeededRng, state?: Partial<CouncilRunState>) {
    this.state = createCouncilState(state);
  }

  offerAfterWave(wave: number, totalWaves: number): readonly CouncilDefinition[] {
    if (wave <= 0 || wave >= totalWaves || (wave & 1) !== 0) return [];
    if (this.state.triggeredWaves.includes(wave)) return this.pendingDefinitions;
    const selected = new Set(this.state.selectedIds);
    const candidates = COUNCIL_DEFINITIONS.filter(def => !selected.has(def.id));
    this.state.triggeredWaves.push(wave);
    this.state.pendingWave = wave;
    this.state.pendingOffer = this.rng.shuffle(candidates).slice(0, 3).map(def => def.id);
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
        this.state.selectedIds.push(selected.id);
        this.state.buildDiscountUses += selected.buildUses ?? 0;
        this.state.upgradeDiscountUses += selected.upgradeUses ?? 0;
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

  selectedDefinitions(): CouncilDefinition[] {
    return this.state.selectedIds.map(id => COUNCIL_BY_ID.get(id)).filter((x): x is CouncilDefinition => !!x);
  }

  serialize(): CouncilRunState {
    return createCouncilState(this.state);
  }
}
