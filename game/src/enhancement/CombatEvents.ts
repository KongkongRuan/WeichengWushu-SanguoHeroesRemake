export type CombatStatusId = 'paralyze' | 'freeze' | 'poison' | 'fire' | 'slow' | 'armor_break';
export type StatusRemovalReason = 'expired' | 'consumed' | 'replaced' | 'cleared' | 'enemy_removed';

export interface StatusAppliedEvent {
  enemyId: number;
  towerId: number;
  status: CombatStatusId;
  duration: number;
}

export interface CombatEventMap {
  wavePlanned: { wave: number; enemyType: number; count: number; bossId: number };
  waveStarted: { wave: number };
  waveCompleted: { wave: number; bonusGold: number };
  enemySpawned: { enemyId: number; wave: number; enemyType: number; elite: boolean };
  enemyDamaged: { enemyId: number; towerId: number; damage: number; category: 'direct' | 'dot' | 'reaction' };
  enemyDied: { enemyId: number; towerId: number | null };
  enemyEntered: { enemyId: number };
  towerBuilt: { towerId: number; type: number; cost: number };
  towerUpgraded: { towerId: number; level: number; cost: number };
  towerSold: { towerId: number; refund: number };
  towerAwakened: { towerId: number; heroId: number };
  statusApplied: StatusAppliedEvent;
  statusRefreshed: StatusAppliedEvent & { previousDuration: number };
  statusRemoved: {
    enemyId: number;
    towerId: number;
    status: CombatStatusId;
    reason: StatusRemovalReason;
  };
  enemyControlled: {
    enemyId: number;
    towerId: number;
    status: Extract<CombatStatusId, 'paralyze' | 'freeze' | 'slow'>;
    frames: number;
  };
  reactionTriggered: {
    reactionId: string;
    towerId: number;
    assistTowerId?: number;
    enemyId: number;
    damage: number;
    visualCue: string;
  };
  councilResolved: { wave: number; councilId: string | null };
  commandUsed: { action: string };
  levelEnded: { victory: boolean; cheatsUsed: boolean };
}

type Listener<K extends keyof CombatEventMap> = (payload: CombatEventMap[K]) => void;

/** 无渲染依赖的同步事件层；订阅者只能观察事实。 */
export class CombatEvents {
  private listeners = new Map<keyof CombatEventMap, Set<(payload: any) => void>>();

  on<K extends keyof CombatEventMap>(type: K, listener: Listener<K>): () => void {
    let bucket = this.listeners.get(type);
    if (!bucket) {
      bucket = new Set();
      this.listeners.set(type, bucket);
    }
    bucket.add(listener as (payload: any) => void);
    return () => bucket?.delete(listener as (payload: any) => void);
  }

  emit<K extends keyof CombatEventMap>(type: K, payload: CombatEventMap[K]): void {
    for (const listener of this.listeners.get(type) ?? []) listener(payload);
  }

  clear(): void {
    this.listeners.clear();
  }
}
