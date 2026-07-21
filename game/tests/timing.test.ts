import test from 'node:test';
import assert from 'node:assert/strict';
import {
  FixedStepClock,
  canStartWave,
  linearLevelValue,
  originalDemolishRefund,
} from '../src/core/Timing';
import { TowerSystem, type Tower } from '../src/core/Tower';
import {
  TOWER_AMBIENT_LAYER_TYPES,
  TOWER_AUX_LAYER_BY_TYPE,
  TOWER_GATE_LOAD_DIR_S1117,
  TOWER_GATE_LOAD_OFF_T1118,
  TOWER_RIGHT_FACING_TRANSFORMS,
  TOWER_PATH_FACING_TYPES,
  TOWER_ATTACK_DURATION_TICKS,
} from '../src/data/gameData';

function createTower(type: number, overrides: Partial<Tower> = {}): Tower {
  return {
    x: 0, y: 0, type, level: 1,
    damage: 30, range: 100, fireRate: 30,
    cooldown: 0, target: -1, angle: 0, heroId: -1, effectType: 0,
    hp: 100, maxHp: 100, debuffTimer: 0,
    frame: 0, orientation: 1, attackAnim: 0,
    attackState: 0, attackPhase: 0, attackFrame: 0, volleyFrames: [], liquidPattern: 0,
    buildEffect: 0, buildEffectFrame: 0,
    strikeX: 0, strikeY: 0,
    gateLoaded: false, gateState: 0, gateTimer: 0,
    ...overrides,
  };
}

function createEnemy(x: number = 48, y: number = 16, hp: number = 1000) {
  return { x, y, hp, state: 0, effect: 0, timer: 0, slowScale: 1 } as never;
}

function systemWithTower(tower: Tower): TowerSystem {
  const system = new TowerSystem({} as never, {} as never);
  (system as unknown as { towers: Tower[] }).towers = [tower];
  return system;
}

function visualSystem() {
  const draws: Array<{ key: string; sx: number }> = [];
  const renderer = {
    setColor() {},
    fillRect() {},
    drawRect() {},
    drawText() {},
    drawSpriteTransform(image: { key: string }, sx: number) {
      draws.push({ key: image.key, sx });
    },
  };
  const system = new TowerSystem(renderer as never, {} as never);
  (system as unknown as { spriteLoader: unknown }).spriteLoader = {
    getByPrefix(prefix: string, index: number) {
      return { key: `${prefix}_${index}`, width: 512, height: 512 };
    },
  };
  return { system, draws };
}

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

test('原版常驻 t 动画与攻击 bu 过程层使用独立分支', () => {
  assert.deepEqual([...TOWER_AMBIENT_LAYER_TYPES], [2, 3, 5, 8, 9]);
  for (const processOnlyType of [0, 1, 4, 6, 7, 10]) {
    assert.equal(TOWER_AMBIENT_LAYER_TYPES.includes(processOnlyType), false);
  }
});

test('烟火常驻火焰不依赖攻击状态，bu 蓄力层只在攻击状态绘制', () => {
  const { system, draws } = visualSystem();
  const tower = createTower(3, { attackState: 0, frame: 2 });
  const visual = system as unknown as {
    renderAmbientAnim(t: Tower, x: number, y: number): boolean;
    renderAttackProcess(t: Tower, x: number, y: number): boolean;
  };
  assert.equal(visual.renderAmbientAnim(tower, 0, 0), true);
  assert.equal(draws.some(draw => draw.key === 't3_1'), true);
  draws.length = 0;
  assert.equal(visual.renderAttackProcess(tower, 0, 0), false);
  assert.equal(draws.length, 0);
  tower.attackState = 1;
  tower.attackPhase = 0;
  tower.attackFrame = 0;
  assert.equal(visual.renderAttackProcess(tower, 0, 0), true);
  assert.equal(draws.some(draw => draw.key === 'bu_18'), true);
});

test('投石释放层使用动作帧而不是建筑等级选择素材', () => {
  const { system, draws } = visualSystem();
  const tower = createTower(7, {
    level: 6, attackState: 1, attackPhase: 1, attackFrame: 0,
    strikeX: 48, strikeY: 16,
  });
  const visual = system as unknown as {
    renderAttackProcess(t: Tower, x: number, y: number): boolean;
  };
  assert.equal(visual.renderAttackProcess(tower, 0, 0), true);
  assert.equal(draws.some(draw => draw.key === 'bu_29'), true);
  assert.equal(draws.some(draw => draw.key === 'bu_28' && draw.sx === 0), true);
});

test('原版分层顺序先画全部建筑本体，再把攻击过程叠加到顶层', () => {
  const { system } = visualSystem();
  const tower = createTower(0, { attackState: 1 });
  (system as unknown as { towers: Tower[] }).towers = [tower];
  const order: string[] = [];
  const visual = system as unknown as {
    renderModel(t: Tower, x: number, y: number): boolean;
    renderAmbientAnim(t: Tower, x: number, y: number): boolean;
    renderAttackProcess(t: Tower, x: number, y: number): boolean;
  };
  visual.renderModel = () => { order.push('model'); return true; };
  visual.renderAmbientAnim = () => { order.push('ambient'); return false; };
  visual.renderAttackProcess = () => { order.push('attack'); return true; };

  system.render();
  assert.deepEqual(order, ['model', 'ambient', 'attack']);
});

test('沸水与滚油会绘制道路上的主要液体攻击层', () => {
  for (const type of [8, 9]) {
    const { system, draws } = visualSystem();
    const tower = createTower(type, {
      attackState: 1, attackPhase: 1, attackFrame: 4, liquidPattern: 1,
    });
    const visual = system as unknown as {
      renderAttackProcess(t: Tower, x: number, y: number): boolean;
    };
    assert.equal(visual.renderAttackProcess(tower, 0, 0), true);
    assert.equal(draws.some(draw => draw.key === (type === 8 ? 'bu_31' : 'bu_35')), true);
  }
});

test('投石右向原图可转换为上右下左四个道路朝向', () => {
  assert.deepEqual([...TOWER_RIGHT_FACING_TRANSFORMS], [5, 0, 6, 1]);
});

test('投石与道路机关在攻击和升级期间保持建造时解析出的道路朝向', () => {
  assert.deepEqual([...TOWER_PATH_FACING_TYPES], [2, 6, 7, 8, 9, 10]);
});

test('每类建筑的攻击状态足够播放原版完整动作', () => {
  assert.deepEqual([...TOWER_ATTACK_DURATION_TICKS], [5, 13, 13, 20, 5, 20, 6, 30, 16, 16, 10]);
  assert.equal(TOWER_ATTACK_DURATION_TICKS[7], 30); // 13 帧蓄力 + 17 帧释放
});

test('投石升级和攻击不会改朝向，也不会重置常驻动画帧', () => {
  const tower = createTower(7, { frame: 5, orientation: 3 });
  const system = systemWithTower(tower);

  assert.equal(system.upgradeTower(tower), true);
  assert.equal(tower.orientation, 3);
  assert.equal(tower.buildEffect, 2);

  tower.buildEffect = 0;
  system.update([createEnemy()], 0, 0);
  assert.equal(tower.orientation, 3);
  assert.equal(tower.frame, 6);
  assert.equal(tower.attackState, 1);
  assert.equal(tower.attackPhase, 0);
  assert.equal(tower.attackFrame, 0);
  assert.equal(tower.attackAnim, TOWER_ATTACK_DURATION_TICKS[7]);
});

test('弓手塔与麻痹矢先进入五箭动作，命中帧才扣血', () => {
  for (const type of [0, 4]) {
    const tower = createTower(type);
    const enemy = createEnemy();
    const system = systemWithTower(tower);
    system.update([enemy], 0, 0);
    assert.equal(enemy.hp, 1000);
    assert.deepEqual(tower.volleyFrames, [0, 1, 2, 3, 4]);
    system.update([enemy], 0, 0);
    assert.equal(enemy.hp, 970);
    assert.deepEqual(tower.volleyFrames, [-1, 0, 1, 2, 3]);
  }
});

test('原版 6 号 Boss 完全免疫麻痹矢命中', () => {
  const tower = createTower(4);
  const enemy = createEnemy() as unknown as { hp: number; bossType: number };
  enemy.bossType = 6;
  const system = systemWithTower(tower);
  system.update([enemy as never], 0, 0);
  system.update([enemy as never], 0, 0);
  assert.equal(enemy.hp, 1000);
});

test('石灰瓶在第 4 帧命中并造成 48x48 范围伤害', () => {
  const tower = createTower(1);
  const primary = createEnemy(48, 16);
  const nearby = createEnemy(60, 20);
  const system = systemWithTower(tower);
  system.update([primary, nearby], 0, 0);
  for (let i = 0; i < 3; i++) system.update([primary, nearby], 0, 0);
  assert.equal(primary.hp, 1000);
  system.update([primary, nearby], 0, 0);
  assert.equal(primary.hp, 970);
  assert.equal(nearby.hp < 1000, true);
  assert.equal(nearby.hp > primary.hp, true);
});

test('烟火与寒冰先蓄力 13 帧，再在释放切换帧结算伤害', () => {
  for (const type of [3, 5]) {
    const tower = createTower(type);
    const enemy = createEnemy();
    const system = systemWithTower(tower);
    system.update([enemy], 0, 0);
    for (let i = 0; i < 12; i++) system.update([enemy], 0, 0);
    assert.equal(enemy.hp, 1000);
    system.update([enemy], 0, 0);
    assert.equal(tower.attackPhase, 1);
    assert.equal(tower.attackFrame, 0);
    assert.equal(enemy.hp < 1000, true);
  }
});

test('投石蓄力后在释放第 3 帧命中，而不是索敌时立即伤害', () => {
  const tower = createTower(7, { orientation: 3 });
  const enemy = createEnemy();
  const system = systemWithTower(tower);
  system.update([enemy], 0, 0);
  for (let i = 0; i < 13; i++) system.update([enemy], 0, 0);
  assert.equal(enemy.hp, 1000);
  assert.equal(tower.attackPhase, 1);
  for (let i = 0; i < 2; i++) system.update([enemy], 0, 0);
  assert.equal(enemy.hp, 1000);
  system.update([enemy], 0, 0);
  assert.equal(enemy.hp, 970);
});

test('突刺按三排时序逐帧结算路径伤害', () => {
  const tower = createTower(2, { orientation: 1 });
  const map = {
    getTerrain() { return 0; },
  };
  const system = new TowerSystem({} as never, map as never);
  (system as unknown as { towers: Tower[] }).towers = [tower];
  const enemy = createEnemy(56, 8);
  system.update([enemy], 0, 0);
  assert.equal(enemy.hp, 1000);
  system.update([enemy], 0, 0);
  assert.equal(tower.attackFrame, 1);
  assert.equal(enemy.hp, 970);
});

test('擂木在 6 帧释放过程中持续作用道路格', () => {
  const tower = createTower(6, { orientation: 1 });
  const map = {
    getTerrain() { return 0; },
  };
  const system = new TowerSystem({} as never, map as never);
  (system as unknown as { towers: Tower[] }).towers = [tower];
  const enemy = createEnemy(56, 8);
  system.update([enemy], 0, 0);
  system.update([enemy], 0, 0);
  const afterFirstHit = enemy.hp;
  system.update([enemy], 0, 0);
  assert.equal(tower.attackFrame, 2);
  assert.equal(enemy.hp < afterFirstHit, true);
  for (let i = 0; i < 4; i++) system.update([enemy], 0, 0);
  assert.equal(tower.attackState, 2);
  assert.equal(enemy.hp, 820);
});

test('沸水和滚油依次经历开启、持续、关闭三个子阶段', () => {
  for (const type of [8, 9]) {
    const tower = createTower(type, { orientation: 1 });
    const map = {
      getTerrain() { return 0; },
    };
    const system = new TowerSystem({} as never, map as never);
    (system as unknown as { towers: Tower[] }).towers = [tower];
    const enemy = createEnemy(56, 24);
    system.update([enemy], 0, 0);
    assert.equal(tower.attackPhase, 0);
    for (let i = 0; i < 2; i++) system.update([enemy], 0, 0);
    assert.equal(enemy.hp, 1000);
    system.update([enemy], 0, 0);
    assert.equal(tower.attackPhase, 1);
    assert.equal(enemy.hp < 1000, true);
    for (let i = 0; i < 11; i++) system.update([enemy], 0, 0);
    assert.equal(tower.attackPhase, 2);
  }
});

test('断龙闸保持原版落石 5 帧与闸墙 10 帧状态', () => {
  const tower = createTower(10, { orientation: 1, gateLoaded: true });
  const map = {
    getTerrain() { return 0; },
    setPathDefense() {},
  };
  const system = new TowerSystem({} as never, map as never);
  (system as unknown as { towers: Tower[] }).towers = [tower];
  assert.equal(system.releaseGate(tower), true);
  assert.equal(tower.attackPhase, 1);
  for (let i = 0; i < 5; i++) system.update([], 0, 0);
  assert.equal(tower.gateState, 2);
  assert.equal(tower.attackPhase, 2);
  for (let i = 0; i < 10; i++) system.update([], 0, 0);
  assert.equal(tower.gateState, 0);
  assert.equal(tower.attackState, 0);
});

test('魏国终阶断龙闸使用原版 46 点持久石阵，其余等级为 16', () => {
  const strengths: number[] = [];
  const tower = createTower(10, {
    level: 7, orientation: 1, gateLoaded: true,
  });
  const map = {
    getTerrain() { return 0; },
    setPathDefense(_x: number, _y: number, strength: number) { strengths.push(strength); },
  };
  const system = new TowerSystem({} as never, map as never);
  system.setFaction(1);
  (system as unknown as { towers: Tower[] }).towers = [tower];
  assert.equal(system.releaseGate(tower), true);
  for (let i = 0; i < 5; i++) system.update([], 0, 0);
  assert.equal(strengths.length > 0, true);
  assert.equal(strengths.every(strength => strength === 46), true);
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
