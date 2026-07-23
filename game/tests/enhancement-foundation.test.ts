import test from 'node:test';
import assert from 'node:assert/strict';
import { SeededRng } from '../src/enhancement/SeededRng';
import { FeatureContext, normalizeRuleset } from '../src/enhancement/Ruleset';
import { DeploymentTracker } from '../src/enhancement/WaveIntel';
import { createStorageKeys, CURRENT_SAVE_VERSION, migrateSaveData } from '../src/core/SaveSystem';
import { EnemySystem } from '../src/core/Enemy';
import { CombatEvents } from '../src/enhancement/CombatEvents';

test('同一种子产生相同序列，恢复状态后从同一位置继续', () => {
  const first = new SeededRng(123456);
  const second = new SeededRng(123456);
  assert.deepEqual(Array.from({ length: 8 }, () => first.nextInt(1000)), Array.from({ length: 8 }, () => second.nextInt(1000)));
  const state = first.snapshot();
  const expected = Array.from({ length: 5 }, () => first.next());
  const restored = new SeededRng(1);
  restored.restore(state);
  assert.deepEqual(Array.from({ length: 5 }, () => restored.next()), expected);
});

test('pick 与 shuffle 可复现且不修改输入数组', () => {
  const source = [1, 2, 3, 4, 5];
  const a = new SeededRng(99);
  const b = new SeededRng(99);
  assert.equal(a.pick(source), b.pick(source));
  assert.deepEqual(a.shuffle(source), b.shuffle(source));
  assert.deepEqual(source, [1, 2, 3, 4, 5]);
});

test('缺省和未知规则均迁移为经典，强化开关集中隔离', () => {
  assert.equal(normalizeRuleset(undefined), 'classic');
  assert.equal(normalizeRuleset('future'), 'classic');
  assert.equal(new FeatureContext('classic').council, false);
  assert.equal(new FeatureContext('enhanced').council, true);
});

test('v1 存档迁移到 v2 时保留原金币、城防、塔和战役进度', () => {
  const old = {
    version: 1, timestamp: 7, levelIndex: 2, currentLevel: 3, gold: 456, lives: 8,
    unlockedEffects: [1], branchProgress: [], globalAtkBonus: 0, globalFireRateBonus: 0,
    reloadHalf: false, goldDouble: false, awakenedHeroes: [], currentFaction: 1,
    towers: [{ x: 1, y: 2, type: 0, level: 1, damage: 15, range: 64, fireRate: 20, heroId: -1, effectType: 0, hp: 120, maxHp: 120 }],
    totalKills: 9, totalGoldEarned: 99, playTime: 12,
    factionX: 1, upgradeAc: 1, gameModeT: 0, campaignAO: 4,
  };
  const migrated = migrateSaveData(old)!;
  assert.equal(migrated.version, CURRENT_SAVE_VERSION);
  assert.equal(migrated.rulesetId, 'classic');
  assert.equal(migrated.gold, old.gold);
  assert.equal(migrated.lives, old.lives);
  assert.deepEqual(migrated.towers, old.towers);
  assert.equal(migrated.campaignAO, 4);
});

test('未来存档版本会被安全拒绝', () => {
  assert.equal(migrateSaveData({ version: CURRENT_SAVE_VERSION + 1 }), null);
});

test('正式版保留旧存储键且输入视口预览使用完全隔离的键', () => {
  const production = createStorageKeys('production');
  const preview = createStorageKeys('preview-build-input-viewport');
  assert.deepEqual(production, {
    save: 'weicheng_save_v1',
    settings: 'weicheng_settings_v1',
    cheatProfile: 'weicheng_cheat_profile_v1',
    enhancementProfile: 'weicheng_enhancement_profile_v1',
  });
  assert.deepEqual(preview, {
    save: 'weicheng_preview_build_input_viewport_save_v1',
    settings: 'weicheng_preview_build_input_viewport_settings_v1',
    cheatProfile: 'weicheng_preview_build_input_viewport_cheat_profile_v1',
    enhancementProfile: 'weicheng_preview_build_input_viewport_enhancement_profile_v1',
  });
  assert.equal(Object.values(production).some((key) => Object.values(preview).includes(key)), false);
});

test('连战阈值、上限、延迟降级和单波只发一次奖励', () => {
  const tracker = new DeploymentTracker();
  tracker.deploy(1, 99999);
  tracker.deploy(2, 1999);
  assert.equal(tracker.state.combo, 2);
  tracker.deploy(3, 5000);
  assert.equal(tracker.state.combo, 3);
  tracker.deploy(4, 100);
  tracker.deploy(5, 100);
  assert.equal(tracker.state.combo, 5);
  assert.equal(tracker.rewardWave(5), 5);
  assert.equal(tracker.rewardWave(5), 0);
  tracker.deploy(6, 5001);
  assert.equal(tracker.state.combo, 4);
});

test('军令清场阻止本波连战金币', () => {
  const tracker = new DeploymentTracker({ combo: 4 });
  assert.equal(tracker.rewardWave(2, true), 0);
});

test('连战准备倒计时耗尽时只下降一级且只结算一次', () => {
  const tracker = new DeploymentTracker({ combo: 4 });
  assert.equal(tracker.expireCombo(5000), false);
  assert.equal(tracker.state.combo, 4);
  assert.equal(tracker.expireCombo(5001), true);
  assert.equal(tracker.state.combo, 3);
  assert.equal(tracker.expireCombo(9000), false);
});

test('名将波后的整备期保护连战且出兵后只消费一次', () => {
  const tracker = new DeploymentTracker({ combo: 4 });
  tracker.protectPreparationAfter(4);
  assert.equal(tracker.isPreparationProtected(4), true);
  assert.equal(tracker.consumeProtectedPreparation(4), true);
  assert.equal(tracker.deploy(5, 60000, true).combo, 4);
  assert.equal(tracker.consumeProtectedPreparation(4), false);
});

test('强化波次预告与正式开始共用同一计划，运行态可往返恢复', () => {
  const map = {
    isPathFreeAtPixel: () => false,
    getSpawnCheckPixel: () => ({ x: 0, y: 0 }),
    releaseTileAtPixel() {}, occupyTileAtPixel() {},
  } as never;
  const events = new CombatEvents();
  const enemy = new EnemySystem({} as never, map);
  enemy.setLevel(0);
  enemy.setEnhancementContext('enhanced', new SeededRng(42), events, null);
  enemy.startLevel();
  const plan = enemy.prepareNextWavePlan();
  assert.ok(plan);
  assert.equal(enemy.prepareNextWavePlan(), plan);
  assert.equal(enemy.requestNextWave(), true);
  enemy.update();
  assert.equal(enemy.currentWave, plan!.wave);
  assert.equal(enemy.wavePlan?.enemyType, plan!.enemyType);

  const state = enemy.exportState();
  const restored = new EnemySystem({} as never, map);
  restored.setLevel(0);
  restored.setEnhancementContext('enhanced', new SeededRng(999), events, null);
  restored.restoreState(state);
  assert.deepEqual(restored.wavePlan, plan);
  assert.equal(restored.currentWave, 1);
});
