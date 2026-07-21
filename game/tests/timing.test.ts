import test from 'node:test';
import assert from 'node:assert/strict';
import {
  FixedStepClock,
  canStartWave,
  linearLevelValue,
  originalDemolishRefund,
} from '../src/core/Timing';
import { TowerSystem } from '../src/core/Tower';
import {
  TOWER_ATTACK_LAYER_TYPES,
  TOWER_ATTACK_ONLY_AUX_TYPES,
  TOWER_AUX_LAYER_BY_TYPE,
  TOWER_GATE_LOAD_DIR_S1117,
  TOWER_GATE_LOAD_OFF_T1118,
  TOWER_RIGHT_FACING_TRANSFORMS,
  shouldRenderTowerAuxLayer,
} from '../src/data/gameData';

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

function countAnimationFrames(refreshRate: number, seconds: number): number {
  const clock = new FixedStepClock(1000 / 60);
  const renderFrames = Math.round(refreshRate * seconds);
  const elapsedMs = 1000 / refreshRate;
  let frames = 0;
  for (let i = 0; i < renderFrames; i++) {
    frames += clock.advance(elapsedMs, 1, 6);
  }
  return frames;
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

test('片头动画固定约60FPS推进，不会被10Hz战斗时钟放慢', () => {
  assert.equal(countAnimationFrames(60, 1), 60);
  assert.equal(countAnimationFrames(120, 1), 60);
  assert.equal(countAnimationFrames(144, 1), 60);
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

test('断龙闸装填预览始终是沿朝向的一排三块石头', () => {
  const origin = { x: 100, y: 80 };
  const positions = TOWER_GATE_LOAD_DIR_S1117.map(([dx, dy], orientation) => {
    const [ox, oy] = TOWER_GATE_LOAD_OFF_T1118[orientation];
    return [0, 1, 2].map(i => [origin.x + ox + dx * i * 16, origin.y + oy + dy * i * 16]);
  });
  assert.deepEqual(positions[0], [[101, 85], [117, 85], [133, 85]]);
  assert.deepEqual(positions[1], [[129, 75], [129, 91], [129, 107]]);
  assert.deepEqual(positions[2], [[101, 107], [117, 107], [133, 107]]);
  assert.deepEqual(positions[3], [[101, 75], [101, 91], [101, 107]]);
});

test('11 类建筑始终使用同一套原版辅助层编号', () => {
  assert.deepEqual([...TOWER_AUX_LAYER_BY_TYPE], [
    'arrow', 'lime', 'spike', 'fire-ice', 'arrow', 'fire-ice',
    'log', 'catapult', 'liquid', 'liquid', 'gate',
  ]);
});

test('只有拥有攻击图集的建筑可以进入独立攻击贴图分支', () => {
  assert.deepEqual([...TOWER_ATTACK_LAYER_TYPES], [0, 2, 3, 4, 5, 8, 9]);
  for (const idleOnlyType of [1, 6, 7, 10]) {
    assert.equal(TOWER_ATTACK_LAYER_TYPES.includes(idleOnlyType), false);
  }
});

test('擂木、烟火、寒冰和投石的动作辅助层不会在待机时绘制', () => {
  assert.deepEqual([...TOWER_ATTACK_ONLY_AUX_TYPES], [3, 5, 6, 7]);
  for (const type of TOWER_ATTACK_ONLY_AUX_TYPES) {
    assert.equal(shouldRenderTowerAuxLayer(type, 0), false);
    assert.equal(shouldRenderTowerAuxLayer(type, 1), true);
  }
  assert.equal(shouldRenderTowerAuxLayer(2, 0), true); // 突刺仍保留待机孔洞
});

test('投石右向原图可转换为上右下左四个道路朝向', () => {
  assert.deepEqual([...TOWER_RIGHT_FACING_TRANSFORMS], [5, 0, 6, 1]);
});

test('投石建造后会自动朝向建筑左右两侧的敌人路径', () => {
  const resolveFacing = (roadX: number): number => {
    const map = {
      getTerrain(tx: number, ty: number) {
        return tx === roadX && ty >= 10 && ty <= 12 ? 0 : 8;
      },
    };
    const system = new TowerSystem({} as never, map as never);
    return (system as unknown as {
      resolvePathFacing(x: number, y: number, type: number): number;
    }).resolvePathFacing(10, 10, 7);
  };

  assert.equal(resolveFacing(9), 3);  // 道路在左，投石朝左
  assert.equal(resolveFacing(13), 1); // 道路在右，投石朝右
});
