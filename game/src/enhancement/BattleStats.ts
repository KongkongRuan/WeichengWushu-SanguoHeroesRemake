export type DamageCategory = 'direct' | 'dot' | 'reaction';

export interface TowerBattleStat {
  instanceId: number;
  type: number;
  name: string;
  directDamage: number;
  dotDamage: number;
  reactionDamage: number;
  kills: number;
  reactions: number;
  reactionAssists: number;
  controlFrames: number;
  investment: number;
  sold: boolean;
}

export interface SerializedBattleStats {
  towers: TowerBattleStat[];
  totalReactions: number;
}

export class BattleStats {
  private towers = new Map<number, TowerBattleStat>();
  private totalReactions = 0;

  constructor(source?: Partial<SerializedBattleStats>) {
    for (const stat of source?.towers ?? []) this.towers.set(stat.instanceId, { ...stat });
    this.totalReactions = Math.max(0, source?.totalReactions ?? 0);
  }

  ensureTower(instanceId: number, type: number, name: string): TowerBattleStat {
    let stat = this.towers.get(instanceId);
    if (!stat) {
      stat = { instanceId, type, name, directDamage: 0, dotDamage: 0, reactionDamage: 0,
        kills: 0, reactions: 0, reactionAssists: 0, controlFrames: 0, investment: 0, sold: false };
      this.towers.set(instanceId, stat);
    }
    return stat;
  }

  invest(id: number, type: number, name: string, gold: number): void { this.ensureTower(id, type, name).investment += Math.max(0, gold); }
  damage(id: number, type: number, name: string, amount: number, category: DamageCategory): void {
    const stat = this.ensureTower(id, type, name);
    const value = Math.max(0, Math.floor(amount));
    if (category === 'direct') stat.directDamage += value;
    else if (category === 'dot') stat.dotDamage += value;
    else stat.reactionDamage += value;
  }
  kill(id: number, type: number, name: string): void { this.ensureTower(id, type, name).kills++; }
  reaction(id: number, type: number, name: string, assistId?: number): void {
    this.ensureTower(id, type, name).reactions++;
    if (assistId != null && this.towers.has(assistId)) this.towers.get(assistId)!.reactionAssists++;
    this.totalReactions++;
  }
  control(id: number, type: number, name: string, frames: number): void {
    this.ensureTower(id, type, name).controlFrames += Math.max(0, Math.floor(frames));
  }
  sold(id: number): void { const stat = this.towers.get(id); if (stat) stat.sold = true; }
  get(id: number): TowerBattleStat | undefined { return this.towers.get(id); }
  topDamage(limit: number = 3): TowerBattleStat[] {
    return [...this.towers.values()].sort((a, b) => this.totalDamage(b) - this.totalDamage(a)).slice(0, limit);
  }
  totalDamage(stat: TowerBattleStat): number { return stat.directDamage + stat.dotDamage + stat.reactionDamage; }
  get reactionCount(): number { return this.totalReactions; }
  serialize(): SerializedBattleStats { return { towers: [...this.towers.values()].map(x => ({ ...x })), totalReactions: this.totalReactions }; }
}
