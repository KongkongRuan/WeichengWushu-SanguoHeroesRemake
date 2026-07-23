import test from 'node:test';
import assert from 'node:assert/strict';
import { COUNCIL_BY_ID, COUNCIL_DEFINITIONS } from '../src/data/enhancement/councilData';
import { CouncilSystem } from '../src/enhancement/CouncilSystem';
import { ModifierResolver } from '../src/enhancement/ModifierResolver';
import { FeatureContext } from '../src/enhancement/Ruleset';
import { SeededRng } from '../src/enhancement/SeededRng';

function modifiers(id: string, extra: Record<string, unknown> = {}) {
  const council = new CouncilSystem(new SeededRng(1), { selectedIds: [id], ...extra });
  return { council, resolver: new ModifierResolver(new FeatureContext('enhanced'), council) };
}

test('相同种子与触发波次生成相同且不重复的三项军议', () => {
  const a = new CouncilSystem(new SeededRng(2026));
  const b = new CouncilSystem(new SeededRng(2026));
  const idsA = a.offerAfterWave(4, 12, { builtTowerTypes: [1] }).map(x => x.id);
  const idsB = b.offerAfterWave(4, 12, { builtTowerTypes: [1] }).map(x => x.id);
  assert.deepEqual(idsA, idsB);
  assert.equal(new Set(idsA).size, 3);
});

test('军议只在非最终名将波触发，已选择内容不会立即重复', () => {
  const council = new CouncilSystem(new SeededRng(7));
  assert.deepEqual(council.offerAfterWave(2, 12), []);
  const first = council.offerAfterWave(4, 12);
  const selected = first[0].id;
  council.resolve(selected);
  const second = council.offerAfterWave(8, 12);
  assert.equal(second.some(item => item.id === selected), false);
  assert.deepEqual(council.offerAfterWave(12, 12), []);
});

test('军议跳过和存档恢复不会重复触发同一波', () => {
  const council = new CouncilSystem(new SeededRng(8));
  council.offerAfterWave(4, 12);
  council.resolve(null);
  const restored = new CouncilSystem(new SeededRng(8), council.serialize());
  assert.deepEqual(restored.offerAfterWave(4, 12), []);
  assert.deepEqual(restored.state.skippedWaves, [4]);
});

test('军议候选按已建建筑过滤，并保持战斗、生存、经济三类选择', () => {
  const council = new CouncilSystem(new SeededRng(2026));
  const offer = council.offerAfterWave(4, 12, { builtTowerTypes: [1] });
  assert.equal(offer.some(item => item.id === 'deep_freeze'), false);
  assert.deepEqual(new Set(offer.map(item => item.kind)), new Set(['combat', 'survival', 'economy']));
});

test('稳固军饷：每波增加 4 金', () => assert.equal(modifiers('steady_income').resolver.waveIncome(), 4));

test('急造工事：仅在有次数时提供 30% 建造折扣', () => {
  const { council, resolver } = modifiers('rapid_works', { buildDiscountUses: 1 });
  assert.equal(resolver.buildCost(100, 0), 70);
  council.consumeBuildDiscount();
  assert.equal(resolver.buildCost(100, 0), 100);
});

test('老练工匠：两次升级按 20% 折扣结算', () => {
  const { council, resolver } = modifiers('veteran_engineers', { upgradeDiscountUses: 2 });
  assert.equal(resolver.upgradeCost(55), 44);
  council.consumeUpgradeDiscount();
  assert.equal(resolver.upgradeCost(55), 44);
  council.consumeUpgradeDiscount();
  assert.equal(resolver.upgradeCost(55), 55);
});

test('拆旧补新：回收提高 10% 但不超过投入', () => {
  const { resolver } = modifiers('salvage_order');
  assert.equal(resolver.demolishRefund(50, 100), 55);
  assert.equal(resolver.demolishRefund(100, 100), 100);
});

test('延烧之策：延长火焰并降低初次火焰伤害', () => {
  const { resolver } = modifiers('long_burn');
  assert.equal(resolver.fireDuration(48), 60);
  assert.equal(resolver.directDamage(100, 3, 10), 90);
});

test('深寒：碎冰伤害增加且冰冻时间缩短', () => {
  const { resolver } = modifiers('deep_freeze');
  assert.equal(resolver.freezeShatterDamage(10), 20);
  assert.equal(resolver.freezeDuration(40), 36);
});

test('烈性石灰：毒伤增加且石灰瓶攻击间隔增长', () => {
  const { resolver } = modifiers('toxic_lime');
  assert.equal(resolver.poisonDamage(4), 5);
  assert.equal(resolver.fireRate(30, 1), 35);
});

test('强弩过载：麻痹时间与麻痹矢间隔各增长 20%/10%', () => {
  const { resolver } = modifiers('overcharge');
  assert.equal(resolver.paralyzeDuration(40), 48);
  assert.equal(resolver.fireRate(30, 4), 33);
});

test('油料充足：燃烧地带延长且滚油造价增长', () => {
  const { resolver } = modifiers('oil_reserve');
  assert.equal(resolver.burningZoneDuration(16), 24);
  assert.equal(resolver.buildCost(80, 9), 88);
});

test('临时加固：内容数据同时声明恢复城防与连战归零', () => {
  const def = COUNCIL_BY_ID.get('reinforce_city')!;
  assert.equal(def.immediate, 'reinforce_city');
  assert.equal(def.resetCombo, true);
});

test('背水：仅在城防不高于 3 时增加 20% 伤害', () => {
  const { resolver } = modifiers('last_stand');
  assert.equal(resolver.directDamage(100, 0, 3), 120);
  assert.equal(resolver.directDamage(100, 0, 4), 100);
});

test('催军：连战奖励提高 50% 并使普通敌军生命增加 12%', () => {
  const { resolver } = modifiers('forced_march');
  assert.equal(resolver.comboRewardMultiplier(), 1.5);
  assert.equal(resolver.enemyHealth(100, false), 112);
  assert.equal(resolver.enemyHealth(100, true), 100);
  assert.equal(resolver.enemySpeed(20, true), 20);
});

test('内容池恰好包含第一阶段约定的十二项', () => assert.equal(COUNCIL_DEFINITIONS.length, 12));
