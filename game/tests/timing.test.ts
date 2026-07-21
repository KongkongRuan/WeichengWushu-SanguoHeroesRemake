import test from 'node:test';
import assert from 'node:assert/strict';
import {
  FixedStepClock,
  canStartWave,
  linearLevelValue,
  originalDemolishRefund,
} from '../src/core/Timing';

function countLogicSteps(refreshRate: number, seconds: number, speed: number = 1): number {
  const clock = new FixedStepClock();
  const renderFrames = Math.round(refreshRate * seconds);
  const elapsedMs = 1000 / refreshRate;
  let steps = 0;
  for (let i = 0; i < renderFrames; i++) {
    steps += clock.advance(elapsedMs, speed, 10);
  }
  return steps;
}

test('60/120/144Hz 在相同时长产生相同的 10Hz 逻辑帧', () => {
  assert.equal(countLogicSteps(60, 10), 100);
  assert.equal(countLogicSteps(120, 10), 100);
  assert.equal(countLogicSteps(144, 10), 100);
});

test('倍速只缩放游戏逻辑，不依赖显示刷新率', () => {
  for (const hz of [60, 120, 144]) {
    assert.equal(countLogicSteps(hz, 10, 2), 200);
    assert.equal(countLogicSteps(hz, 10, 3), 300);
  }
});

test('弓手塔冷却 20 在正常速度下稳定约为 2 秒', () => {
  for (const hz of [60, 120, 144]) {
    const steps = countLogicSteps(hz, 2);
    let cooldown = 20;
    for (let i = 0; i < steps; i++) cooldown--;
    assert.equal(cooldown, 0);
  }
});

test('第一波不会自动开始，必须满足原版 # 键条件', () => {
  const ready = {
    levelStarted: true,
    wavePending: false,
    enemyCount: 0,
    spawnedInWave: 0,
    waveSize: 0,
    currentWave: 0,
    totalWaves: 12,
  };
  assert.equal(canStartWave(ready), true);
  assert.equal(canStartWave({ ...ready, enemyCount: 1 }), false);
  assert.equal(canStartWave({ ...ready, wavePending: true }), false);
  assert.equal(canStartWave({ ...ready, levelStarted: false }), false);
});

test('塔属性与拆除返还使用原版线性公式', () => {
  assert.equal(linearLevelValue([15, 5], 1), 15);
  assert.equal(linearLevelValue([15, 5], 3), 25);
  assert.equal(linearLevelValue([20, -2], 6), 10);
  assert.equal(originalDemolishRefund(20, [10, 2], 1), 10);
  assert.equal(originalDemolishRefund(20, [10, 2], 3), 21);
});
