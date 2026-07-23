import test from 'node:test';
import assert from 'node:assert/strict';
import {
  bossBreachDamage,
  duplicateTowerSurcharge,
  enemyBreachDamage,
} from '../src/enhancement/BalanceRules';
import { TowerSystem } from '../src/core/Tower';
import { CouncilSystem } from '../src/enhancement/CouncilSystem';
import { ModifierResolver } from '../src/enhancement/ModifierResolver';
import { FeatureContext } from '../src/enhancement/Ruleset';
import { SeededRng } from '../src/enhancement/SeededRng';

test('经典规则保持一律扣 1，强化名将按波次明确扣 2/3 城防', () => {
  assert.equal(enemyBreachDamage('classic', 20, true), 1);
  assert.equal(enemyBreachDamage('enhanced', 4, false), 1);
  assert.equal(bossBreachDamage('enhanced', 4), 2);
  assert.equal(bossBreachDamage('enhanced', 15), 2);
  assert.equal(bossBreachDamage('enhanced', 16), 3);
  assert.equal(bossBreachDamage('enhanced', 24), 3);
});

test('同类建筑前三座原价，第四座起每座加 15% 且封顶 75%', () => {
  assert.equal(duplicateTowerSurcharge(0), 0);
  assert.equal(duplicateTowerSurcharge(2), 0);
  assert.equal(duplicateTowerSurcharge(3), 0.15);
  assert.equal(duplicateTowerSurcharge(4), 0.3);
  assert.equal(duplicateTowerSurcharge(20), 0.75);
});

test('建造价格明细同时返回最终价格和面向玩家的加价原因', () => {
  const map = { occupyBuildTile() {} } as never;
  const towers = new TowerSystem({} as never, map);
  towers.setBuildCostProvider(type => type === 1 ? 30 : null);
  towers.setEnhancementContext('enhanced', null, null, null, () => 10);
  towers.restoreFromSave([
    { instanceId: 1, x: 0, y: 0, type: 1, level: 1, orientation: 0 },
    { instanceId: 2, x: 2, y: 0, type: 1, level: 1, orientation: 0 },
    { instanceId: 3, x: 4, y: 0, type: 1, level: 1, orientation: 0 },
  ]);

  const detail = towers.getBuildCostDetail(1);
  assert.equal(detail.baseCost, 30);
  assert.equal(detail.existingSameType, 3);
  assert.equal(detail.duplicateSurcharge, 0.15);
  assert.equal(detail.finalCost, 35);
  assert.deepEqual(detail.explanations, ['同类第4座 +15%']);
});

test('样机折扣在同类加价前结算，并单独说明优惠来源', () => {
  const map = { occupyBuildTile() {} } as never;
  const towers = new TowerSystem({} as never, map);
  const council = new CouncilSystem(new SeededRng(1), { prototypeDiscounts: [0, 0.5] });
  const modifiers = new ModifierResolver(new FeatureContext('enhanced'), council);
  towers.setBuildCostProvider(type => type === 1 ? 30 : null);
  towers.setEnhancementContext('enhanced', null, modifiers, null, () => 10);
  towers.restoreFromSave([
    { instanceId: 1, x: 0, y: 0, type: 1, level: 1, orientation: 0 },
    { instanceId: 2, x: 2, y: 0, type: 1, level: 1, orientation: 0 },
    { instanceId: 3, x: 4, y: 0, type: 1, level: 1, orientation: 0 },
  ]);

  const detail = towers.getBuildCostDetail(1);
  assert.equal(detail.prototypeDiscount, 0.5);
  assert.equal(detail.duplicateSurcharge, 0.15);
  assert.equal(detail.finalCost, 17);
  assert.deepEqual(detail.explanations, ['首座样机 -50%', '同类第4座 +15%']);
});
