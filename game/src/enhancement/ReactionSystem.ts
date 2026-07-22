import { REACTION_CONFIG, REACTION_LABELS } from '../data/enhancement/reactionData';
import { ModifierResolver } from './ModifierResolver';

export interface ReactionEnemyLike {
  instanceId?: number;
  x: number;
  y: number;
  hp: number;
  defense: number;
  bossType: number;
  fireTimer: number;
  freezeTimer: number;
  poisonTimer: number;
  paralyzeTimer: number;
  fireSourceTowerId?: number;
  freezeSourceTowerId?: number;
  poisonSourceTowerId?: number;
  paralyzeSourceTowerId?: number;
  armorBreakTimer?: number;
  armorBreakAmount?: number;
}

export interface ReactionTowerLike { instanceId?: number; type: number; level: number; }

export interface ReactionResult {
  reactionId: string;
  sourceTowerId: number;
  assistTowerId?: number;
  targetEnemyId: number;
  damage: number;
  consumedStatuses: string[];
  appliedStatuses: string[];
  visualCue: string;
  multiplier?: number;
}

export interface BurningZone {
  tx: number;
  ty: number;
  timer: number;
  tick: number;
  sourceTowerId: number;
}

export interface ReactionRunState { frame: number; burningZones: BurningZone[]; cooldowns: Record<string, number>; }

export class ReactionSystem {
  private frame = 0;
  private burningZones = new Map<string, BurningZone>();
  private cooldowns = new Map<string, number>();
  private processedEvents = new Set<string>();

  constructor(private modifiers: ModifierResolver, source?: Partial<ReactionRunState>) {
    this.frame = Math.max(0, source?.frame ?? 0);
    for (const zone of source?.burningZones ?? []) this.burningZones.set(`${zone.tx},${zone.ty}`, { ...zone });
    for (const [key, value] of Object.entries(source?.cooldowns ?? {})) this.cooldowns.set(key, Math.max(0, value));
  }

  resolveBeforeHit(eventId: string, tower: ReactionTowerLike, enemy: ReactionEnemyLike): ReactionResult | null {
    const type = tower.type === 19 ? 0 : tower.type;
    const enemyId = enemy.instanceId ?? 0;
    const eventKey = `${eventId}/${enemyId}`;
    if (this.processedEvents.has(eventKey)) return null;

    if ((type === 3 || type === 9 || type === 5) && ((type === 5 && enemy.fireTimer > 0) || (type !== 5 && enemy.freezeTimer > 0))) {
      const cooldownKey = `ice_fire_burst/${enemyId}`;
      if ((this.cooldowns.get(cooldownKey) ?? 0) > this.frame) return null;
      this.processedEvents.add(eventKey);
      this.cooldowns.set(cooldownKey, this.frame + REACTION_CONFIG.iceFireBurst.cooldown);
      enemy.fireTimer = 0;
      enemy.freezeTimer = 0;
      const assistTowerId = type === 5 ? enemy.fireSourceTowerId : enemy.freezeSourceTowerId;
      return this.result('ice_fire_burst', tower, enemy,
        REACTION_CONFIG.iceFireBurst.baseDamage + REACTION_CONFIG.iceFireBurst.perTowerLevel * tower.level,
        ['火焰', '冻结'], [], assistTowerId);
    }

    if (type === 8 && enemy.poisonTimer > 0) {
      this.processedEvents.add(eventKey);
      enemy.poisonTimer = Math.max(0, enemy.poisonTimer - REACTION_CONFIG.limeScald.poisonConsumed);
      enemy.armorBreakTimer = REACTION_CONFIG.limeScald.armorBreakDuration;
      enemy.armorBreakAmount = REACTION_CONFIG.limeScald.armorBreakBase + Math.floor(tower.level / 2);
      return this.result('lime_scald', tower, enemy, 0, ['中毒'], ['破防'], enemy.poisonSourceTowerId);
    }

    if ((type === 2 || type === 6) && enemy.paralyzeTimer > 0) {
      this.processedEvents.add(eventKey);
      enemy.paralyzeTimer = Math.max(0, enemy.paralyzeTimer - REACTION_CONFIG.paralyzePierce.paralyzeConsumed);
      return {
        ...this.result('paralyze_pierce', tower, enemy, 0, ['麻痹'], [], enemy.paralyzeSourceTowerId),
        multiplier: REACTION_CONFIG.paralyzePierce.multiplier,
      };
    }
    return null;
  }

  igniteGround(
    eventId: string,
    tower: ReactionTowerLike,
    tx: number,
    ty: number,
    assistTowerId: number = 0,
  ): ReactionResult | null {
    const key = `${tx},${ty}`;
    const eventKey = `oil_ignition/${eventId}/${key}`;
    if (this.processedEvents.has(eventKey)) return null;
    this.processedEvents.add(eventKey);
    const duration = this.modifiers.burningZoneDuration(REACTION_CONFIG.burningGround.duration);
    const zone = this.burningZones.get(key);
    if (zone) {
      zone.timer = duration;
      zone.sourceTowerId = tower.instanceId ?? 0;
    } else {
      this.burningZones.set(key, { tx, ty, timer: duration, tick: 0, sourceTowerId: tower.instanceId ?? 0 });
    }
    return {
      reactionId: 'oil_ignition', sourceTowerId: tower.instanceId ?? 0,
      assistTowerId: assistTowerId > 0 ? assistTowerId : undefined,
      targetEnemyId: -1, damage: 0,
      consumedStatuses: [], appliedStatuses: ['燃烧地带'], visualCue: REACTION_LABELS.oil_ignition,
    };
  }

  tickZones(enemies: readonly ReactionEnemyLike[], apply: (enemy: ReactionEnemyLike, damage: number, towerId: number) => void): void {
    this.frame++;
    for (const [key, zone] of this.burningZones) {
      zone.timer--;
      zone.tick++;
      if (zone.tick % REACTION_CONFIG.burningGround.interval === 0) {
        for (const enemy of enemies) {
          if (enemy.hp <= 0 || enemy.bossType === 5) continue;
          if ((enemy.x >> 4) === zone.tx && (enemy.y >> 4) === zone.ty) {
            apply(enemy, REACTION_CONFIG.burningGround.damage, zone.sourceTowerId);
          }
        }
      }
      if (zone.timer <= 0) this.burningZones.delete(key);
    }
    if (this.processedEvents.size > 512) this.processedEvents.clear();
  }

  serialize(): ReactionRunState {
    return { frame: this.frame, burningZones: [...this.burningZones.values()].map(x => ({ ...x })), cooldowns: Object.fromEntries(this.cooldowns) };
  }

  get zones(): readonly BurningZone[] { return [...this.burningZones.values()]; }

  private result(
    id: string,
    tower: ReactionTowerLike,
    enemy: ReactionEnemyLike,
    damage: number,
    consumed: string[],
    applied: string[],
    assistTowerId?: number,
  ): ReactionResult {
    return { reactionId: id, sourceTowerId: tower.instanceId ?? 0,
      assistTowerId: assistTowerId && assistTowerId > 0 ? assistTowerId : undefined,
      targetEnemyId: enemy.instanceId ?? 0, damage,
      consumedStatuses: consumed, appliedStatuses: applied, visualCue: REACTION_LABELS[id] ?? id };
  }
}
