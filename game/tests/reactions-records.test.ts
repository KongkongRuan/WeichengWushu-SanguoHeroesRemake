import test from 'node:test';
import assert from 'node:assert/strict';
import { CouncilSystem } from '../src/enhancement/CouncilSystem';
import { ModifierResolver } from '../src/enhancement/ModifierResolver';
import { FeatureContext } from '../src/enhancement/Ruleset';
import { SeededRng } from '../src/enhancement/SeededRng';
import { ReactionSystem } from '../src/enhancement/ReactionSystem';
import { BattleStats } from '../src/enhancement/BattleStats';
import { CombatEvents } from '../src/enhancement/CombatEvents';
import { TowerSystem, type Tower } from '../src/core/Tower';
import { EnemyState, EnemySystem, type Enemy } from '../src/core/Enemy';
import {
  createBattleRecordKey, createBattleRecordProfile, evaluateMedals, medalCount, mergeBattleRecord,
} from '../src/enhancement/BattleRecords';

function reactionSystem(selectedIds: string[] = []) {
  const council = new CouncilSystem(new SeededRng(1), { selectedIds });
  return new ReactionSystem(new ModifierResolver(new FeatureContext('enhanced'), council));
}

function enemy(overrides: Record<string, unknown> = {}) {
  return {
    instanceId: 1, x: 32, y: 32, hp: 100, defense: 2, bossType: 0,
    fireTimer: 0, freezeTimer: 0, poisonTimer: 0, paralyzeTimer: 0,
    armorBreakTimer: 0, armorBreakAmount: 0, ...overrides,
  };
}

function tower(type: number, overrides: Partial<Tower> = {}): Tower {
  return {
    instanceId: 1, x: 0, y: 0, type, level: 1,
    damage: 30, range: 100, fireRate: 30, cooldown: 0, target: -1, angle: 0,
    heroId: -1, effectType: 0, hp: 100, maxHp: 100, debuffTimer: 0,
    frame: 0, orientation: 1, attackAnim: 0, attackState: 0, attackPhase: 0,
    attackFrame: 0, volleyFrames: [], liquidPattern: 0, liquidIgnited: false,
    buildEffect: 0, buildEffectFrame: 0, strikeX: 0, strikeY: 0,
    gateLoaded: false, gateState: 0, gateTimer: 0, attackSequence: 1,
    ...overrides,
  };
}

function combatEnemy(overrides: Partial<Enemy> = {}): Enemy {
  return {
    ...(enemy() as unknown as Enemy),
    goldReward: 5, speed: 2, baseSpeed: 2, slowScale: 1, dir: 1, variant: 0,
    animFrame: 0, state: EnemyState.WALK, maxHp: 100, unitType: 0, elite: false,
    spawnIndex: 0, siegeAnim: 0, siegeTimer: 0, chargeTimer: 0, dieTimer: 0,
    effect: 0, timer: 0, dotScale: 1, slowTimer: 0,
    fireFrame: 0, paralyzeFrame: 0, freezeFrame: 0, poisonFrame: 0, slowFrame: 0,
    poisonPower: 0, firePower: 8, hitTimer: -1, lastDamage: 0, impactDir: 0,
    ...overrides,
  };
}

function towerHarness(subject: Tower, ruleset: 'classic' | 'enhanced' = 'enhanced') {
  const events = new CombatEvents();
  const council = new CouncilSystem(new SeededRng(1));
  const modifiers = new ModifierResolver(new FeatureContext(ruleset), council);
  const reactions = new ReactionSystem(modifiers);
  const system = new TowerSystem({} as never, {} as never);
  (system as unknown as { towers: Tower[] }).towers = [subject];
  system.setEnhancementContext(ruleset, events, modifiers, reactions, () => 10);
  return { system, events, reactions };
}

test('冰火爆裂消耗火/冰状态并遵守每目标 30 帧冷却', () => {
  const system = reactionSystem();
  const target = enemy({ freezeTimer: 48 });
  const first = system.resolveBeforeHit('1:1', { instanceId: 1, type: 3, level: 2 }, target)!;
  assert.equal(first.reactionId, 'ice_fire_burst');
  assert.equal(first.damage, 28);
  assert.equal(target.freezeTimer, 0);
  target.freezeTimer = 48;
  assert.equal(system.resolveBeforeHit('1:2', { instanceId: 1, type: 3, level: 2 }, target), null);
});

test('深寒军议不改写冰火爆裂的固定伤害', () => {
  const target = enemy({ fireTimer: 48 });
  const result = reactionSystem(['deep_freeze']).resolveBeforeHit('2:1', { instanceId: 2, type: 5, level: 1 }, target)!;
  assert.equal(result.damage, 24);
});

test('石灰沸灼消耗至多 16 帧中毒并施加不叠加的破防', () => {
  const target = enemy({ poisonTimer: 12 });
  const result = reactionSystem().resolveBeforeHit('3:1', { instanceId: 3, type: 8, level: 5 }, target)!;
  assert.equal(result.reactionId, 'lime_scald');
  assert.equal(target.poisonTimer, 0);
  assert.equal(target.armorBreakTimer, 30);
  assert.equal(target.armorBreakAmount, 4);
});

test('麻痹穿刺只在同一攻击事件首次命中获得 25% 加成', () => {
  const system = reactionSystem();
  const target = enemy({ paralyzeTimer: 30 });
  const result = system.resolveBeforeHit('4:1', { instanceId: 4, type: 2, level: 1 }, target)!;
  assert.equal(result.multiplier, 1.25);
  assert.equal(target.paralyzeTimer, 20);
  assert.equal(system.resolveBeforeHit('4:1', { instanceId: 4, type: 2, level: 1 }, target), null);
});

test('油火引燃地带每 4 帧伤害一次、同格刷新且火免疫不受伤', () => {
  const system = reactionSystem();
  system.igniteGround('9:1', { instanceId: 9, type: 9, level: 1 }, 2, 2);
  system.igniteGround('10:1', { instanceId: 10, type: 9, level: 1 }, 2, 2);
  assert.equal(system.zones.length, 1);
  const normal = enemy();
  const immune = enemy({ instanceId: 2, bossType: 5 });
  const hits: number[] = [];
  for (let i = 0; i < 4; i++) system.tickZones([normal, immune], (_target, damage, source) => hits.push(damage + source));
  assert.deepEqual(hits, [14]);
});

test('TowerSystem 沸水命中中毒目标会触发石灰沸灼，经典规则保持原逻辑', () => {
  const water = tower(8, { instanceId: 8, level: 5, damage: 40 });
  const enhanced = towerHarness(water);
  const target = combatEnemy({ poisonTimer: 20, poisonSourceTowerId: 21 });
  const reactions: Array<{ id: string; assist?: number }> = [];
  enhanced.events.on('reactionTriggered', event => reactions.push({
    id: event.reactionId,
    assist: event.assistTowerId,
  }));
  const hitCells = (enhanced.system as unknown as {
    damageEnemiesInCells(t: Tower, targets: Enemy[], cells: { tx: number; ty: number }[]): void;
  }).damageEnemiesInCells;
  hitCells.call(enhanced.system, water, [target], [{ tx: 2, ty: 2 }]);
  assert.equal(target.poisonTimer, 4);
  assert.equal(target.armorBreakTimer, 30);
  assert.equal(target.armorBreakAmount, 4);
  assert.deepEqual(reactions, [{ id: 'lime_scald', assist: 21 }]);

  const classicWater = tower(8, { instanceId: 18, level: 5, damage: 40 });
  const classic = towerHarness(classicWater, 'classic');
  const classicTarget = combatEnemy({ poisonTimer: 20, poisonSourceTowerId: 21 });
  let classicReactions = 0;
  classic.events.on('reactionTriggered', () => classicReactions++);
  const classicHitCells = (classic.system as unknown as {
    damageEnemiesInCells(t: Tower, targets: Enemy[], cells: { tx: number; ty: number }[]): void;
  }).damageEnemiesInCells;
  classicHitCells.call(classic.system, classicWater, [classicTarget], [{ tx: 2, ty: 2 }]);
  assert.equal(classicTarget.poisonTimer, 20);
  assert.equal(classicTarget.armorBreakTimer, 0);
  assert.equal(classicReactions, 0);
});

test('TowerSystem 冰火爆裂只结算一次范围伤害并保留火免疫 Boss', () => {
  const fire = tower(3, { instanceId: 3, level: 2, damage: 15, effectType: 4 });
  const { system, events } = towerHarness(fire);
  const primary = combatEnemy({ instanceId: 1, x: 32, y: 32, freezeTimer: 48, freezeSourceTowerId: 12 });
  const nearby = combatEnemy({ instanceId: 2, x: 48, y: 32 });
  const fireImmune = combatEnemy({ instanceId: 3, x: 32, y: 48, bossType: 5 });
  (system as unknown as { activeEnemies: Enemy[] }).activeEnemies = [primary, nearby, fireImmune];
  const emitted: Array<{ id: string; assist?: number }> = [];
  events.on('reactionTriggered', event => emitted.push({ id: event.reactionId, assist: event.assistTowerId }));
  const damageEnemy = (system as unknown as {
    damageEnemy(t: Tower, target: Enemy): boolean;
  }).damageEnemy;
  damageEnemy.call(system, fire, primary);
  assert.equal(primary.hp, 61);
  assert.equal(nearby.hp, 74);
  assert.equal(fireImmune.hp, 100);
  assert.equal(primary.freezeTimer, 0);
  assert.deepEqual(emitted, [{ id: 'ice_fire_burst', assist: 12 }]);
});

test('TowerSystem 滚油同次攻击同格只记一次联动，后续攻击刷新但不叠加地带', () => {
  const oil = tower(9, {
    instanceId: 9, damage: 60, effectType: 4, attackPhase: 1, attackFrame: 4,
    attackSequence: 3,
  });
  const { system, events, reactions } = towerHarness(oil);
  const target = combatEnemy({ hp: 1000, maxHp: 1000, fireTimer: 20, fireSourceTowerId: 32 });
  const emitted: Array<{ assist?: number }> = [];
  events.on('reactionTriggered', event => emitted.push({ assist: event.assistTowerId }));
  const hitCells = (system as unknown as {
    damageEnemiesInCells(t: Tower, targets: Enemy[], cells: { tx: number; ty: number }[]): void;
  }).damageEnemiesInCells;
  const cell = [{ tx: 2, ty: 2 }];
  hitCells.call(system, oil, [target], cell);
  target.hitTimer = -1;
  hitCells.call(system, oil, [target], cell);
  assert.equal(reactions.zones.length, 1);
  assert.deepEqual(emitted, [{ assist: 32 }]);

  oil.attackSequence = 4;
  target.hitTimer = -1;
  hitCells.call(system, oil, [target], cell);
  assert.equal(reactions.zones.length, 1);
  assert.deepEqual(emitted, [{ assist: 32 }, { assist: 32 }]);
});

test('经典/强化、模式、阵营和战役组成互不覆盖的勋章键', () => {
  const keys = new Set([
    createBattleRecordKey('classic', 0, 0, 1),
    createBattleRecordKey('enhanced', 0, 0, 1),
    createBattleRecordKey('enhanced', 1, 0, 1),
    createBattleRecordKey('enhanced', 1, 1, 1),
    createBattleRecordKey('enhanced', 1, 1, 2),
  ]);
  assert.equal(keys.size, 5);
});

test('勋章能解释漏兵、延迟出兵和军令失效原因', () => {
  const leaked = evaluateMedals({ victory: true, leaks: 2, quickDeploy: false, cheatsUsed: false });
  assert.deepEqual(leaked.earned, ['clear']);
  assert.match(leaked.failed.flawless!, /2/);
  assert.match(leaked.failed.swift!, /5 秒/);
  const cheated = evaluateMedals({ victory: true, leaks: 0, quickDeploy: true, cheatsUsed: true });
  assert.equal(cheated.failed.flawless, '使用过军令');
});

test('重复通关只标记新获得勋章，不覆盖最佳连战与金币', () => {
  const profile = createBattleRecordProfile();
  const key = createBattleRecordKey('enhanced', 0, 2, 4);
  const full = evaluateMedals({ victory: true, leaks: 0, quickDeploy: true, cheatsUsed: false });
  assert.equal(mergeBattleRecord(profile, key, full, 4, 20).newlyEarned.length, 3);
  assert.equal(mergeBattleRecord(profile, key, full, 2, 5).newlyEarned.length, 0);
  assert.equal(medalCount(profile.records[key]), 3);
  assert.equal(profile.records[key].bestCombo, 4);
});

test('战报分别累计直接、持续、联动伤害并保留已拆除塔', () => {
  const stats = new BattleStats();
  stats.invest(1, 3, '烟火', 50);
  stats.invest(2, 5, '寒冰', 80);
  stats.damage(1, 3, '烟火', 10, 'direct');
  stats.damage(1, 3, '烟火', 8, 'dot');
  stats.damage(1, 3, '烟火', 28, 'reaction');
  stats.kill(1, 3, '烟火');
  stats.reaction(1, 3, '烟火', 2);
  stats.control(1, 3, '烟火', 48);
  stats.sold(1);
  const saved = stats.serialize();
  const restored = new BattleStats(saved);
  const record = restored.get(1)!;
  assert.equal(restored.totalDamage(record), 46);
  assert.equal(record.kills, 1);
  assert.equal(record.sold, true);
  assert.equal(record.controlFrames, 48);
  assert.equal(restored.get(2)!.reactionAssists, 1);
});

test('状态契约区分首次施加、刷新和移除', () => {
  const fire = tower(3, { instanceId: 7, effectType: 4 });
  const { system, events } = towerHarness(fire);
  const target = combatEnemy({ instanceId: 12 });
  const applied: unknown[] = [];
  const refreshed: unknown[] = [];
  const removed: unknown[] = [];
  events.on('statusApplied', event => applied.push(event));
  events.on('statusRefreshed', event => refreshed.push(event));
  events.on('statusRemoved', event => removed.push(event));
  const applyEffect = (system as unknown as {
    applyTowerEffect(target: Enemy, source: Tower): boolean;
  }).applyTowerEffect;
  const setFreeze = (system as unknown as {
    setFreeze(target: Enemy, duration: number, resetFrame: boolean, extinguishFire: boolean, towerId: number): void;
  }).setFreeze;

  applyEffect.call(system, target, fire);
  target.fireTimer = 47;
  applyEffect.call(system, target, fire);
  setFreeze.call(system, target, 48, true, true, 8);

  assert.deepEqual(applied, [
    { enemyId: 12, towerId: 7, status: 'fire', duration: 48 },
    { enemyId: 12, towerId: 8, status: 'freeze', duration: 48 },
  ]);
  assert.deepEqual(refreshed, [
    { enemyId: 12, towerId: 7, status: 'fire', duration: 48, previousDuration: 47 },
  ]);
  assert.deepEqual(removed, [
    { enemyId: 12, towerId: 7, status: 'fire', reason: 'replaced' },
  ]);
});

test('有效控制统计按实际生效逻辑帧累计，刷新不会预记完整持续时间', () => {
  const events = new CombatEvents();
  const stats = new BattleStats();
  events.on('enemyControlled', ({ towerId, frames }) => stats.control(towerId, 4, '麻痹矢', frames));
  const system = new EnemySystem({} as never, {} as never);
  system.setEnhancementContext('enhanced', new SeededRng(1), events, null);
  const target = combatEnemy({ instanceId: 15, paralyzeTimer: 2, paralyzeSourceTowerId: 4 });
  const tick = (system as unknown as { updateStatusEffects(target: Enemy): boolean }).updateStatusEffects;
  const removed: unknown[] = [];
  events.on('statusRemoved', event => removed.push(event));

  tick.call(system, target);
  tick.call(system, target);
  tick.call(system, target);

  assert.equal(stats.get(4)?.controlFrames, 2);
  assert.deepEqual(removed, [
    { enemyId: 15, towerId: 4, status: 'paralyze', reason: 'expired' },
  ]);
});

test('塔觉醒会发出稳定塔 ID 与英雄 ID', () => {
  const subject = tower(0, { instanceId: 23, level: 6 });
  const { system, events } = towerHarness(subject);
  const awakened: unknown[] = [];
  events.on('towerAwakened', event => awakened.push(event));
  const awaken = (system as unknown as { awakenHero(source: Tower): void }).awakenHero;
  awaken.call(system, subject);
  assert.deepEqual(awakened, [{ towerId: 23, heroId: 0 }]);
});
