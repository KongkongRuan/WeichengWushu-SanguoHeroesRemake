import test from 'node:test';
import assert from 'node:assert/strict';
import { readFileSync } from 'node:fs';
import { resolve } from 'node:path';
import {
  FixedStepClock,
  canStartWave,
  linearLevelValue,
  originalDemolishRefund,
} from '../src/core/Timing';
import { TowerSystem, type Tower } from '../src/core/Tower';
import { EnemyState, EnemySystem, type Enemy } from '../src/core/Enemy';
import { MapData } from '../src/core/MapData';
import { BAR_CAT_TOWER, BuildBarSystem, type BuildBarHost } from '../src/core/BuildBar';
import { AudioSystem } from '../src/core/AudioSystem';
import { scale2x } from '../src/core/Scale2x';
import {
  availableCommandPoints,
  CHEAT_COSTS,
  COMMAND_POINT_MAX,
  createDefaultCheatProfile,
  recordFailure,
  recordVictory,
  spendCommandPoints,
} from '../src/core/CheatProgress';
import {
  TOWER_AMBIENT_LAYER_TYPES,
  TOWER_AUX_LAYER_BY_TYPE,
  TOWER_GATE_LOAD_DIR_S1117,
  TOWER_GATE_LOAD_OFF_T1118,
  TOWER_PATH_FACING_TYPES,
  TOWER_ATTACK_DURATION_TICKS,
  TOWER_PROJECTILE_RANGE_TYPES,
  MAX_ENEMIES,
  ENEMY_ARRAY_SIZE,
  ENEMY_ATTR_COUNT,
  TOWER_COST_Q1100,
  TOWER_UPGRADE_COST_R1101,
  TECH_COST_G1057,
  INITIAL_GOLD_BY_MODE,
} from '../src/data/gameData';

function createTower(type: number, overrides: Partial<Tower> = {}): Tower {
  return {
    x: 0, y: 0, type, level: 1,
    damage: 30, range: 100, fireRate: 30,
    cooldown: 0, target: -1, angle: 0, heroId: -1, effectType: 0,
    hp: 100, maxHp: 100, debuffTimer: 0,
    frame: 0, orientation: 1, attackAnim: 0,
    attackState: 0, attackPhase: 0, attackFrame: 0, volleyFrames: [], liquidPattern: 0,
    liquidIgnited: false,
    buildEffect: 0, buildEffectFrame: 0,
    strikeX: 0, strikeY: 0,
    gateLoaded: false, gateState: 0, gateTimer: 0,
    ...overrides,
  };
}

function createEnemy(x: number = 48, y: number = 16, hp: number = 1000, defense: number = 0) {
  return {
    x, y, hp, defense, state: 0, effect: 0, timer: 0, slowScale: 1,
    poisonTimer: 0, poisonFrame: 0,
  } as never;
}

function createMovingEnemy(overrides: Partial<Enemy> = {}): Enemy {
  return {
    x: 14, y: 8, hp: 100, defense: 0, goldReward: 5, speed: 2, baseSpeed: 2,
    slowScale: 1, dir: 1, variant: 0, animFrame: 0, state: EnemyState.WALK,
    maxHp: 100, unitType: 0, elite: false, spawnIndex: 0, bossType: 0,
    siegeAnim: 0, siegeTimer: 0, chargeTimer: 0, dieTimer: 0,
    effect: 0, timer: 0,
    dotScale: 1,
    fireTimer: 0, paralyzeTimer: 0, freezeTimer: 0, poisonTimer: 0, slowTimer: 0,
    fireFrame: 0, paralyzeFrame: 0, freezeFrame: 0, poisonFrame: 0, slowFrame: 0,
    poisonPower: 0, firePower: 8, hitTimer: -1, lastDamage: 0, impactDir: 0,
    ...overrides,
  };
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

test('军令金手指消耗符合配置且常驻军令不会超过5枚', () => {
  assert.deepEqual(CHEAT_COSTS, {
    cheat_gold: 1,
    cheat_defense: 2,
    cheat_clear_enemies: 2,
    cheat_gold_double: 3,
    cheat_all_tech: 5,
  });
  const profile = createDefaultCheatProfile();
  const reward = recordVictory(profile, {
    level: 0,
    battleKey: '0:0',
    usedCheat: false,
    flawless: true,
    quickDeploy: true,
  });
  assert.equal(reward.pointsAdded, 3);
  assert.equal(profile.commandPoints, 3);
  recordVictory(profile, {
    level: 1,
    battleKey: '0:1',
    usedCheat: false,
    flawless: true,
    quickDeploy: true,
  });
  assert.equal(profile.commandPoints, COMMAND_POINT_MAX);
});

test('首次挑战奖励不可重复，使用金手指后只发首次通关军令', () => {
  const profile = createDefaultCheatProfile();
  const assisted = recordVictory(profile, {
    level: 2,
    battleKey: '0:2',
    usedCheat: true,
    flawless: true,
    quickDeploy: true,
  });
  assert.deepEqual(assisted.labels, ['新关卡首次通关']);
  assert.equal(profile.commandPoints, 1);
  const cleanReplay = recordVictory(profile, {
    level: 2,
    battleKey: '0:2',
    usedCheat: false,
    flawless: true,
    quickDeploy: true,
  });
  assert.deepEqual(cleanReplay.labels, ['首次无人入城', '全波次及时出兵']);
  assert.equal(profile.commandPoints, 3);
  assert.deepEqual(recordVictory(profile, {
    level: 2,
    battleKey: '0:2',
    usedCheat: false,
    flawless: true,
    quickDeploy: true,
  }).labels, []);
});

test('同关连续失败两次发救援军令，消耗时优先使用救援额度', () => {
  const profile = createDefaultCheatProfile();
  profile.commandPoints = 2;
  assert.equal(recordFailure(profile, '1:3'), false);
  assert.equal(recordFailure(profile, '1:3'), true);
  assert.equal(availableCommandPoints(profile, '1:3'), 3);
  const spent = spendCommandPoints(profile, '1:3', CHEAT_COSTS.cheat_gold_double);
  assert.deepEqual(spent, { ok: true, spentRescue: 1, spentCommandPoints: 2 });
  assert.equal(profile.commandPoints, 0);
  assert.equal(availableCommandPoints(profile, '1:3'), 0);
  assert.equal(recordFailure(profile, '1:3'), false);
  assert.equal(recordFailure(profile, '1:3'), true);
});

test('倍速只缩放游戏逻辑，不依赖显示刷新率', () => {
  for (const hz of [60, 120, 144]) {
    assert.equal(countLogicSteps(hz, 10, 2), 200);
    assert.equal(countLogicSteps(hz, 10, 3), 300);
  }
});

test('倍速追帧预算按倍速扩大，不会在一次卡顿中丢掉额外战斗帧', () => {
  const normal = new FixedStepClock();
  const triple = new FixedStepClock();
  assert.equal(normal.advance(1000, 1, 10), 10);
  assert.equal(triple.advance(1000, 3, 30), 30);
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

test('格中心方向判断只检查占用位，不会提前消耗断龙闸石阵', () => {
  const map = new MapData({} as never);
  Object.assign(map as unknown as Record<string, unknown>, {
    mapData: { width: 2, height: 1 },
    terrain: [0, 1],
    pathDefense: [16, 0],
  });
  assert.equal(map.isPathUnoccupiedAtPixel(8, 8), true);
  assert.equal(map.getPathDefense(0, 0), 16);
  assert.equal(map.isPathUnoccupiedAtPixel(24, 8), false);
});

test('小兵被堵时只等待一帧，不会反复退回上一格中心', () => {
  const enemy = createMovingEnemy({ state: EnemyState.BLOCKED });
  const system = new EnemySystem({} as never, {} as never);
  const internal = system as unknown as {
    updateEnemy(target: Enemy, index: number): void;
  };
  internal.updateEnemy(enemy, 0);
  assert.equal(enemy.state, EnemyState.WALK);
  assert.equal(enemy.x, 14);
  assert.equal(enemy.y, 8);
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

test('悬停范围只对六类投掷/远程建筑显示', () => {
  assert.deepEqual([...TOWER_PROJECTILE_RANGE_TYPES], [0, 1, 3, 4, 5, 7]);
});

test('经济参数与原版 q1100/r1101/g1057 及每战初始金币一致', () => {
  assert.deepEqual([...TOWER_COST_Q1100], [20, 30, 40, 50, 40, 80, 40, 50, 60, 80, 30]);
  assert.deepEqual([...TOWER_UPGRADE_COST_R1101], [
    [10, 2], [15, 3], [20, 4], [20, 5], [10, 5], [30, 5],
    [10, 5], [20, 5], [20, 5], [30, 5], [20, 5],
  ]);
  assert.deepEqual([...TECH_COST_G1057], [20, 40, 60, 80, 100]);
  assert.deepEqual([...INITIAL_GOLD_BY_MODE], [300, 250]);
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

test('投石主模型遵从原版，不按道路方向旋转', () => {
  const system = new TowerSystem({} as never, {} as never);
  const resolveFacing = (system as unknown as {
    resolvePathFacing(x: number, y: number, type: number): number;
  }).resolvePathFacing;
  assert.equal(resolveFacing.call(system, 10, 10, 7), 0);
});

test('拥堵绕行不会选择进入后立即反向的道路格', () => {
  const map = {
    getPathDirAtPixel(x: number, y: number) {
      if (x === 0 && y === -16) return 1;
      if (x === 32 && y === 0) return 0;
      return 0;
    },
    isPathFreeAtPixel(x: number, y: number) {
      return x === 0 && y === 16;
    },
  };
  const system = new EnemySystem({} as never, map as never);
  const findDetour = (system as unknown as {
    findDetourDirection(x: number, y: number, previousDir: number): number;
  }).findDetourDirection;
  assert.equal(findDetour.call(system, 0, 0, 0), 0);
});

test('敌人防御力按原版减伤，伤害最低仍扣 1 点', () => {
  const tower = createTower(0, { damage: 30 });
  const enemy = createEnemy(48, 16, 100, 100);
  const system = systemWithTower(tower);
  system.update([enemy], 0, 0);
  system.update([enemy], 0, 0);
  assert.equal(enemy.hp, 99);
});

test('原版敌人池为 80×28，达到 30 个活动敌人后仍继续刷怪', () => {
  assert.equal(MAX_ENEMIES, 80);
  assert.equal(ENEMY_ARRAY_SIZE, 80);
  assert.equal(ENEMY_ATTR_COUNT, 28);

  const map = {
    getSpawnCheckPixel() { return { x: 8, y: 8 }; },
    getSpawnPixel() { return { x: 8, y: 8 }; },
    isPathFreeAtPixel() { return true; },
    getPathDirAtPixel() { return 0; },
    occupyTileAtPixel() {},
  };
  const system = new EnemySystem({} as never, map as never);
  const internal = system as unknown as {
    enemies: Enemy[];
    aT: number;
    aX: number;
    aR: number;
    spawnTick(): void;
  };
  internal.enemies = Array.from({ length: 30 }, (_, spawnIndex) => createMovingEnemy({ spawnIndex }));
  internal.aT = 30;
  internal.aX = 31;
  internal.aR = -1;
  internal.spawnTick();
  assert.equal(internal.enemies.length, 31);
  assert.equal(internal.aT, 31);
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
  assert.equal(tower.attackState, 0);
  system.update([createEnemy()], 0, 0);
  assert.equal(tower.orientation, 3);
  assert.equal(tower.frame, 7);
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

test('突刺伤害带按原版 D1162 写入时序，不与视觉伸缩帧混用', () => {
  const tower = createTower(2, { orientation: 1 });
  const system = systemWithTower(tower);
  const cells = (system as unknown as {
    spikeActiveCells(t: Tower, phase: number): { tx: number; ty: number }[];
  }).spikeActiveCells;
  assert.deepEqual(
    [1, 4, 7, 8, 9, 10, 11, 12].map(phase => cells.call(system, tower, phase).length),
    [3, 6, 6, 9, 0, 3, 3, 0],
  );
});

test('擂木命中后进入推出状态，不会在同一动作中逐帧重复扣血', () => {
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
  assert.equal(enemy.hp, afterFirstHit);
  for (let i = 0; i < 4; i++) system.update([enemy], 0, 0);
  assert.equal(tower.attackState, 2);
  assert.equal(enemy.hp, 970);
  assert.equal(enemy.state, EnemyState.HIT_PUSH);
});

test('擂木致命一击仍先完成原版 1→2→3 回弹状态再进入死亡', () => {
  const map = {
    isPathFreeAtPixel() { return false; },
    getPathDirAtPixel() { return 1; },
    isPathUnoccupiedAtPixel() { return true; },
    isOurCastleAtPixel() { return false; },
    occupyTileAtPixel() {},
    releaseTileAtPixel() {},
  };
  const system = new EnemySystem({} as never, map as never);
  const updateEnemy = (system as unknown as {
    updateEnemy(target: Enemy, index: number): void;
  }).updateEnemy;
  const enemy = createMovingEnemy({
    hp: 0, state: EnemyState.HIT_PUSH, impactDir: 0, dir: 1,
  });
  updateEnemy.call(system, enemy, 0);
  assert.equal(enemy.state, EnemyState.HIT_BACK);
  updateEnemy.call(system, enemy, 0);
  assert.equal(enemy.state, EnemyState.HIT_RECOVER);
  updateEnemy.call(system, enemy, 0);
  assert.equal(enemy.state, EnemyState.DYING);
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

test('投石建造不会因为道路位置自动改变朝向', () => {
  const map = {
    getTerrain(tx: number, ty: number) {
      return tx === 9 && ty >= 10 && ty <= 12 ? 0 : 8;
    },
  };
  const system = new TowerSystem({} as never, map as never);
  const resolveFacing = (system as unknown as {
    resolvePathFacing(x: number, y: number, type: number): number;
  }).resolvePathFacing;
  assert.equal(resolveFacing.call(system, 10, 10, 7), 0);
});

test('建造栏进入关闭动画后忽略连续确认，不会把装填变成释放或拆除', () => {
  const tower = createTower(10);
  let loads = 0;
  let releases = 0;
  let demolishes = 0;
  const host: BuildBarHost = {
    getGold: () => 999,
    trySpendGold: () => true,
    getTowerCount: () => 1,
    enterPlacement() {},
    upgradeTower: () => true,
    demolishTower: () => { demolishes++; },
    loadGate: target => { loads++; target.gateLoaded = true; return true; },
    releaseGate: target => { releases++; target.gateLoaded = false; target.gateState = 1; return true; },
    getGateLoadCost: () => 20,
    getUpgradeCost: () => 20,
    getDemolishRefund: () => 10,
    renderTowerPreview() {},
    deselectTower() {},
    onTechBuilt() {},
  };
  const bar = new BuildBarSystem({} as never);
  bar.setHost(host);
  bar.open(BAR_CAT_TOWER, tower);
  bar.confirm();
  bar.confirm();
  bar.confirm();
  assert.equal(loads, 1);
  assert.equal(releases, 0);
  assert.equal(demolishes, 0);
});

test('升级栏进入关闭动画后忽略第二次确认', () => {
  const tower = createTower(1);
  let upgrades = 0;
  const bar = new BuildBarSystem({} as never);
  bar.setHost({
    getGold: () => 999,
    trySpendGold: () => true,
    getTowerCount: () => 1,
    enterPlacement() {},
    upgradeTower: target => { upgrades++; target.level++; return true; },
    demolishTower() {},
    loadGate: () => false,
    releaseGate: () => false,
    getGateLoadCost: () => null,
    getUpgradeCost: () => 20,
    getDemolishRefund: () => 10,
    renderTowerPreview() {},
    deselectTower() {},
    onTechBuilt() {},
  });
  bar.open(BAR_CAT_TOWER, tower);
  bar.confirm();
  bar.confirm();
  assert.equal(upgrades, 1);
  assert.equal(tower.level, 2);
});

test('对应开局路线可升到七级并按 y1130 绑定武将', () => {
  const tower = createTower(1, { level: 6, damage: 25, effectType: 3 });
  const system = systemWithTower(tower);
  system.setGold(999);
  system.setFaction(0);
  system.setUpgradeMode(1); // 文系：建筑1-5
  assert.equal(system.upgradeTower(tower), true);
  assert.equal(tower.level, 7);
  assert.equal(tower.heroId, 6); // 蜀 y1130[1] = 魏延
  assert.equal(system.getHeroEffectDescription(tower), '中毒敌人同时减速');
  assert.equal(system.getUpgradeCost(tower), null);
});

test('君主已经觉醒也不能让建筑跨越开局选择的文武路线升到七级', () => {
  for (const [upgradeMode, wrongType] of [[0, 1], [1, 6]] as const) {
    const tower = createTower(wrongType, { level: 6 });
    const leader = createTower(0, { level: 7, heroId: 1 });
    const system = systemWithTower(tower);
    (system as unknown as { towers: Tower[] }).towers = [tower, leader];
    system.setGold(999);
    system.setUpgradeMode(upgradeMode);
    assert.equal(system.upgradeTower(tower), false);
    assert.equal(tower.level, 6);
    assert.match(system.getUpgradeFailureMessage(), /只能觉醒/);
  }
});

test('武系开局可以把武系建筑升到七级觉醒', () => {
  const tower = createTower(6, { level: 6 });
  const system = systemWithTower(tower);
  system.setGold(999);
  system.setFaction(0);
  system.setUpgradeMode(0);
  assert.equal(system.upgradeTower(tower), true);
  assert.equal(tower.level, 7);
  assert.equal(tower.heroId >= 0, true);
});

test('魏延加持的石灰瓶中毒时同时减速', () => {
  const tower = createTower(1, { level: 7, heroId: 6, effectType: 3 });
  const enemy = createEnemy();
  const system = systemWithTower(tower);
  const applyEffect = (system as unknown as {
    applyTowerEffect(target: Enemy, source: Tower): void;
  }).applyTowerEffect;
  applyEffect.call(system, enemy, tower);
  assert.equal((enemy as unknown as Enemy).effect, 3);
  assert.equal((enemy as unknown as Enemy).slowTimer, 48);
  assert.equal((enemy as unknown as Enemy).timer > 0, true);
  assert.equal((enemy as unknown as Enemy).poisonTimer, 48);
});

test('建筑方框可解析敌人并取得原版兵种名', () => {
  const enemy = createMovingEnemy({ x: 24, y: 24, unitType: 0 });
  const system = new EnemySystem({} as never, {} as never);
  (system as unknown as { enemies: Enemy[] }).enemies = [enemy];
  assert.equal(system.getEnemyAtTile(1, 1), enemy);
  assert.equal(system.getEnemyName(enemy), '散兵');
  assert.equal(system.getEnemyAtTile(3, 3), null);
});

test('石灰瓶实际命中写入独立中毒计时并使用原版 h_4 三帧标记绘制', () => {
  const tower = createTower(1, { effectType: 3 });
  const enemy = createEnemy();
  const nearby = createEnemy(60, 20);
  const outside = createEnemy(80, 16);
  const towerSystem = systemWithTower(tower);
  towerSystem.update([enemy, nearby, outside], 0, 0);
  for (let i = 0; i < 4; i++) towerSystem.update([enemy, nearby, outside], 0, 0);
  assert.equal((enemy as unknown as Enemy).poisonTimer, 48);
  assert.equal((nearby as unknown as Enemy).poisonTimer, 48);
  assert.equal((outside as unknown as Enemy).poisonTimer, 0);

  const draws: Array<{
    sx: number; sy: number; sw: number; sh: number;
    dx: number; dy: number; dw: number; dh: number;
  }> = [];
  const renderer = {
    drawImageRegion(
      _img: unknown, sx: number, sy: number, sw: number, sh: number,
      dx: number, dy: number, dw: number, dh: number,
    ) {
      draws.push({ sx, sy, sw, sh, dx, dy, dw, dh });
    },
    setColor() {},
    fillRect() {},
  };
  const system = new EnemySystem(renderer as never, {} as never);
  (system as unknown as { spriteLoader: unknown; visualFrame: number }).spriteLoader = {
    getByPrefix(prefix: string, index: number) {
      return prefix === 'h' && index === 4 ? {} : null;
    },
  };
  const renderStatus = (system as unknown as {
    renderStatusEffect(target: Enemy, x: number, y: number): void;
  }).renderStatusEffect;
  renderStatus.call(system, enemy as unknown as Enemy, 24, 24);
  assert.deepEqual(draws, [{
    sx: 0, sy: 0, sw: 14, sh: 11,
    dx: 16, dy: 8, dw: 14, dh: 11,
  }]);
});

test('其他状态覆盖通用 effect 后仍保留独立的中毒标记', () => {
  let draws = 0;
  const system = new EnemySystem({
    drawImageRegion() { draws++; },
    setColor() {},
    fillRect() {},
  } as never, {} as never);
  (system as unknown as { spriteLoader: unknown }).spriteLoader = {
    getByPrefix(prefix: string, index: number) {
      return prefix === 'h' && index === 4 ? {} : null;
    },
  };
  const renderStatus = (system as unknown as {
    renderStatusEffect(target: Enemy, x: number, y: number): void;
  }).renderStatusEffect;
  renderStatus.call(system, createMovingEnemy({
    effect: 2, timer: 10, poisonTimer: 30, poisonFrame: 2,
  }), 24, 24);
  assert.equal(draws, 1);
});

test('11 类建筑在 1/6/7 级严格使用原版伤害、范围和冷却成长', () => {
  const system = new TowerSystem({} as never, {} as never);
  const originalStats = (system as unknown as {
    originalStats(type: number, level: number): { damage: number; range: number; fireRate: number };
  }).originalStats;
  const expected = [
    [[15, 64, 20], [40, 104, 10], [45, 112, 8]],
    [[10, 48, 30], [25, 68, 15], [28, 72, 12]],
    [[30, 0, 60], [80, 0, 40], [90, 0, 36]],
    [[15, 64, 25], [40, 94, 15], [45, 100, 13]],
    [[15, 56, 30], [40, 86, 20], [45, 92, 18]],
    [[60, 64, 30], [110, 104, 20], [120, 112, 18]],
    [[20, 0, 60], [70, 0, 40], [80, 0, 36]],
    [[30, 48, 30], [80, 88, 20], [90, 96, 18]],
    [[40, 64, 80], [80, 84, 50], [88, 88, 44]],
    [[60, 64, 100], [135, 84, 75], [150, 88, 70]],
    [[50, 0, 0], [100, 0, 0], [110, 0, 0]],
  ];
  for (let type = 0; type < 11; type++) {
    assert.deepEqual(originalStats.call(system, type, 1), {
      damage: expected[type][0][0], range: expected[type][0][1], fireRate: expected[type][0][2],
    });
    assert.deepEqual(originalStats.call(system, type, 6), {
      damage: expected[type][1][0], range: expected[type][1][1], fireRate: expected[type][1][2],
    });
    assert.deepEqual(originalStats.call(system, type, 7), {
      damage: expected[type][2][0], range: expected[type][2][1], fireRate: expected[type][2][2],
    });
  }
});

test('远程建筑按敌人队列选择首个范围内目标，而不是选择最近目标', () => {
  const tower = createTower(0, { range: 100 });
  const fartherFirst = createEnemy(80, 16);
  const nearerSecond = createEnemy(24, 16);
  const system = systemWithTower(tower);
  const findTarget = (system as unknown as {
    findTargetIndex(t: Tower, enemies: Enemy[], ox: number, oy: number): number;
  }).findTargetIndex;
  assert.equal(findTarget.call(system, tower, [fartherFirst, nearerSecond], 0, 0), 0);
  assert.equal(findTarget.call(system, tower, [createEnemy(116, 16)], 0, 0), -1);
});

test('攻击动作期间冷却继续递减，蓄力建筑释放时重新装入完整冷却', () => {
  const arrow = createTower(0, { fireRate: 20 });
  const arrowEnemy = createEnemy();
  const arrowSystem = systemWithTower(arrow);
  arrowSystem.update([arrowEnemy], 0, 0);
  for (let i = 0; i < 5; i++) arrowSystem.update([arrowEnemy], 0, 0);
  assert.equal(arrow.attackState, 2);
  assert.equal(arrow.cooldown, 15);

  const catapult = createTower(7, { fireRate: 30 });
  const catapultEnemy = createEnemy();
  const catapultSystem = systemWithTower(catapult);
  catapultSystem.update([catapultEnemy], 0, 0);
  for (let i = 0; i < 13; i++) catapultSystem.update([catapultEnemy], 0, 0);
  assert.equal(catapult.attackPhase, 1);
  assert.equal(catapult.cooldown, 30);
  for (let i = 0; i < 17; i++) catapultSystem.update([catapultEnemy], 0, 0);
  assert.equal(catapult.attackState, 2);
  assert.equal(catapult.cooldown, 13);
});

test('石灰瓶与投石溅射按 level0>>2 重算 s1102，不是主伤害乘四分之一', () => {
  for (const [type, expected] of [[1, 13], [7, 40]] as const) {
    const tower = createTower(type, { level: 7, damage: type === 1 ? 28 : 90 });
    const system = systemWithTower(tower);
    const splashDamage = (system as unknown as { splashTowerDamage(t: Tower): number }).splashTowerDamage;
    assert.equal(splashDamage.call(system, tower), expected);
  }
});

test('寒冰与麻痹完全停止移动，减速才按原版整数半速移动', () => {
  const map = {
    width: 20,
    getPathDirAtPixel() { return 1; },
    isPathFreeAtPixel() { return true; },
    isPathUnoccupiedAtPixel() { return true; },
    isOurCastleAtPixel() { return false; },
    occupyTileAtPixel() {},
    releaseTileAtPixel() {},
  };
  const system = new EnemySystem({} as never, map as never);
  const updateEnemy = (system as unknown as {
    updateEnemy(target: Enemy, index: number): void;
  }).updateEnemy;

  const frozen = createMovingEnemy({ x: 14, y: 8, freezeTimer: 48 });
  updateEnemy.call(system, frozen, 0);
  assert.deepEqual([frozen.x, frozen.y, frozen.freezeTimer], [14, 8, 46]);

  const paralyzed = createMovingEnemy({ x: 14, y: 8, paralyzeTimer: 48 });
  updateEnemy.call(system, paralyzed, 0);
  assert.deepEqual([paralyzed.x, paralyzed.y, paralyzed.paralyzeTimer], [14, 8, 47]);

  const slowed = createMovingEnemy({ x: 8, y: 8, speed: 2, baseSpeed: 2, slowTimer: 48 });
  updateEnemy.call(system, slowed, 0);
  assert.equal(slowed.speed, 1);
  assert.equal(slowed.x, 9);
});

test('中毒与火焰独立按每 8 帧扣血，寒冰结束前追加 10 点碎冰伤害', () => {
  const map = {
    width: 20,
    getPathDirAtPixel() { return 1; },
    isPathFreeAtPixel() { return true; },
    isPathUnoccupiedAtPixel() { return true; },
    isOurCastleAtPixel() { return false; },
    occupyTileAtPixel() {},
    releaseTileAtPixel() {},
  };
  const system = new EnemySystem({} as never, map as never);
  const updateEnemy = (system as unknown as {
    updateEnemy(target: Enemy, index: number): void;
  }).updateEnemy;
  const dotted = createMovingEnemy({
    x: 14, y: 8, hp: 100, poisonTimer: 48, poisonPower: 7,
    fireTimer: 48, firePower: 8,
  });
  updateEnemy.call(system, dotted, 0);
  assert.equal(dotted.hp, 85);
  assert.equal(dotted.hitTimer, 3);

  const frozen = createMovingEnemy({ x: 14, y: 8, hp: 100, freezeTimer: 48 });
  for (let i = 0; i < 23; i++) updateEnemy.call(system, frozen, 0);
  assert.equal(frozen.hp, 90);
  assert.equal(frozen.freezeTimer, 2);
});

test('五类异常状态使用独立原版素材并按 r(int) 顺序叠加绘制', () => {
  const draws: number[] = [];
  const renderer = {
    drawImageRegion(img: { index: number }) { draws.push(img.index); },
    setColor() {},
    fillRect() {},
  };
  const system = new EnemySystem(renderer as never, {} as never);
  (system as unknown as { spriteLoader: unknown }).spriteLoader = {
    getByPrefix(prefix: string, index: number) { return prefix === 'h' ? { index } : null; },
  };
  const renderStatus = (system as unknown as {
    renderStatusEffect(target: Enemy, x: number, y: number): void;
  }).renderStatusEffect;
  const enemy = createMovingEnemy({
    freezeTimer: 10, freezeFrame: 2,
    slowTimer: 10, slowFrame: 1,
    poisonTimer: 10, poisonFrame: 2,
    fireTimer: 10, fireFrame: 3,
    paralyzeTimer: 10, paralyzeFrame: 1,
  });
  renderStatus.call(system, enemy, 24, 24);
  assert.deepEqual(draws, [5, 7, 4, 6, 3]);
});

test('敌人受击按原版播放爆点、七粒子和伤害数字', () => {
  const images: string[] = [];
  const texts: string[] = [];
  const renderer = {
    drawImageRegion(img: { key: string }) { images.push(img.key); },
    drawText(value: string) { texts.push(value); },
  };
  const system = new EnemySystem(renderer as never, {} as never);
  (system as unknown as { spriteLoader: unknown }).spriteLoader = {
    getByPrefix(prefix: string, index: number) { return { key: `${prefix}_${index}` }; },
  };
  const renderHit = (system as unknown as {
    renderHitEffect(target: Enemy, x: number, y: number): void;
  }).renderHitEffect;
  const enemy = createMovingEnemy({ hitTimer: 4, lastDamage: 17 });
  renderHit.call(system, enemy, 24, 24);
  assert.deepEqual(images, ['bu_22']);
  enemy.hitTimer = 3;
  renderHit.call(system, enemy, 24, 24);
  assert.equal(images.filter(key => key === 'h_0').length, 7);
  assert.deepEqual(texts, ['17']);
});

test('突刺和液体受 5 帧受击计时限制，沸水灭火，滚油遇火才点燃', () => {
  const cell = [{ tx: 3, ty: 1 }];
  const hitCells = (system: TowerSystem, tower: Tower, enemies: Enemy[]) => {
    const damageCells = (system as unknown as {
      damageEnemiesInCells(t: Tower, targets: Enemy[], cells: { tx: number; ty: number }[]): void;
    }).damageEnemiesInCells;
    damageCells.call(system, tower, enemies, cell);
  };

  const spike = createTower(2);
  const spikeEnemy = createEnemy(56, 24) as unknown as Enemy;
  const spikeSystem = systemWithTower(spike);
  hitCells(spikeSystem, spike, [spikeEnemy]);
  hitCells(spikeSystem, spike, [spikeEnemy]);
  assert.equal(spikeEnemy.hp, 970);

  const water = createTower(8, { effectType: 0 });
  const immune = createEnemy(56, 24) as unknown as Enemy;
  Object.assign(immune, { bossType: 4, fireTimer: 20, fireFrame: 2 });
  hitCells(systemWithTower(water), water, [immune]);
  assert.equal(immune.hp, 1000);
  assert.equal(immune.fireTimer, 0);

  const oil = createTower(9, { effectType: 4, attackPhase: 1, attackFrame: 4 });
  const unlit = createEnemy(56, 24) as unknown as Enemy;
  const burning = createEnemy(56, 24) as unknown as Enemy;
  const ignitedAfter = createEnemy(56, 24) as unknown as Enemy;
  Object.assign(burning, { fireTimer: 20, firePower: 8 });
  const oilSystem = systemWithTower(oil);
  hitCells(oilSystem, oil, [unlit]);
  assert.equal(unlit.fireTimer, 0);
  unlit.hitTimer = -1;
  hitCells(oilSystem, oil, [burning, ignitedAfter]);
  assert.equal(oil.liquidIgnited, true);
  assert.equal(oil.attackFrame, 2);
  assert.equal(ignitedAfter.fireTimer, 48);
});

test('吴国七级沸水/滚油只用中间条带触发，但给圆形射程内全部敌人减速', () => {
  for (const type of [8, 9]) {
    const tower = createTower(type, { level: 7, range: 88, orientation: 1 });
    const outsideStrip = createEnemy(24, 56) as unknown as Enemy;
    const trigger = createEnemy(56, 24) as unknown as Enemy;
    const system = systemWithTower(tower);
    system.setFaction(2);
    const findTarget = (system as unknown as {
      findTargetIndex(t: Tower, enemies: Enemy[], ox: number, oy: number): number;
    }).findTargetIndex;
    assert.equal(findTarget.call(system, tower, [outsideStrip, trigger], 0, 0), 1);
    assert.equal(outsideStrip.slowTimer, 48);
    assert.equal(trigger.slowTimer, 48);
  }
});

test('蜀国七级沸水/滚油由中间条带触发后伤害区扩为完整 3×3', () => {
  for (const type of [8, 9]) {
    const tower = createTower(type, { level: 7, orientation: 1, effectType: 0 });
    const system = systemWithTower(tower);
    system.setFaction(0);
    const projected = (system as unknown as {
      projectedDeviceCells(x: number, y: number, orientation: number, center?: boolean): { tx: number; ty: number }[];
    }).projectedDeviceCells;
    const full = projected.call(system, tower.x, tower.y, tower.orientation, false);
    const strip = projected.call(system, tower.x, tower.y, tower.orientation, true);
    const stripKeys = new Set(strip.map(cell => `${cell.tx},${cell.ty}`));
    const outside = full.find(cell => !stripKeys.has(`${cell.tx},${cell.ty}`));
    assert.ok(outside);
    const outsideEnemy = createEnemy((outside.tx << 4) + 8, (outside.ty << 4) + 8);
    const trigger = createEnemy((strip[0].tx << 4) + 8, (strip[0].ty << 4) + 8);

    system.update([outsideEnemy, trigger], 0, 0);
    for (let i = 0; i < 3; i++) system.update([outsideEnemy, trigger], 0, 0);
    assert.equal(tower.attackPhase, 1);
    assert.equal(outsideEnemy.hp < 1000, true);
    assert.equal(trigger.hp < 1000, true);
  }
});

test('魏国七级沸水/滚油持续阶段严格延长到 21 帧', () => {
  for (const type of [8, 9]) {
    const tower = createTower(type, { level: 7, orientation: 1, effectType: 0 });
    const system = systemWithTower(tower);
    system.setFaction(1);
    const trigger = createEnemy(56, 24);
    system.update([trigger], 0, 0);
    for (let i = 0; i < 3; i++) system.update([trigger], 0, 0);
    assert.equal(tower.attackPhase, 1);
    for (let i = 0; i < 20; i++) system.update([trigger], 0, 0);
    assert.equal(tower.attackPhase, 1);
    system.update([trigger], 0, 0);
    assert.equal(tower.attackPhase, 2);
  }
});

test('麻痹按等级阈值、寒冰按固定阈值，吴国两者均使用零阈值', () => {
  const tower = createTower(4, { level: 1 });
  const system = systemWithTower(tower);
  const roll = (system as unknown as {
    rollStatusEffect(t: Tower, freeze: boolean): boolean;
  }).rollStatusEffect;
  const originalRandom = Math.random;
  try {
    Math.random = () => 0.875;
    assert.equal(roll.call(system, tower, false), true);
    Math.random = () => 0.75;
    assert.equal(roll.call(system, tower, false), false);

    tower.level = 7;
    Math.random = () => 0.625;
    assert.equal(roll.call(system, tower, false), true);
    Math.random = () => 0.5;
    assert.equal(roll.call(system, tower, false), false);
    assert.equal(roll.call(system, tower, true), true);
    Math.random = () => 0.375;
    assert.equal(roll.call(system, tower, true), false);

    system.setFaction(2);
    Math.random = () => 0.125;
    assert.equal(roll.call(system, tower, false), true);
    assert.equal(roll.call(system, tower, true), true);
    Math.random = () => 0;
    assert.equal(roll.call(system, tower, false), false);
  } finally {
    Math.random = originalRandom;
  }
});

test('蜀国终阶突刺、擂木、断龙闸无视防御，其余攻击至少造成 1 点', () => {
  for (const [type, heroId] of [[2, 7], [6, 2], [10, 1]] as const) {
    const tower = createTower(type, { damage: 30, heroId });
    const enemy = createEnemy(48, 16, 100, 100) as unknown as Enemy;
    const system = systemWithTower(tower);
    const damage = (system as unknown as {
      damageEnemy(t: Tower, target: Enemy): boolean;
    }).damageEnemy;
    damage.call(system, tower, enemy);
    assert.equal(enemy.hp, 70);
  }
  const ordinary = createTower(0, { damage: 30 });
  const armored = createEnemy(48, 16, 100, 100) as unknown as Enemy;
  const ordinarySystem = systemWithTower(ordinary);
  (ordinarySystem as unknown as {
    damageEnemy(t: Tower, target: Enemy): boolean;
  }).damageEnemy.call(ordinarySystem, ordinary, armored);
  assert.equal(armored.hp, 99);
});

test('原版各专属 Boss 免疫与火冰互斥保持独立', () => {
  const lime = createTower(1, { target: 0, strikeX: 48, strikeY: 16, effectType: 3 });
  const limeBoss = createEnemy() as unknown as Enemy;
  Object.assign(limeBoss, { bossType: 8 });
  const limeSystem = systemWithTower(lime);
  (limeSystem as unknown as {
    damageLimeImpact(t: Tower, targets: Enemy[]): void;
  }).damageLimeImpact.call(limeSystem, lime, [limeBoss]);
  assert.equal(limeBoss.hp, 1000);

  const fire = createTower(3, {
    target: 0, effectType: 4, attackPhase: 0, attackFrame: 12, attackState: 1,
  });
  const fireBoss = createEnemy() as unknown as Enemy;
  Object.assign(fireBoss, { bossType: 5 });
  const fireSystem = systemWithTower(fire);
  (fireSystem as unknown as {
    advanceAttack(t: Tower, targets: Enemy[], ox: number, oy: number): void;
  }).advanceAttack.call(fireSystem, fire, [fireBoss], 0, 0);
  assert.equal(fireBoss.hp, 1000);

  const slowTower = createTower(7, { level: 7, heroId: 3 });
  const slowBoss = createMovingEnemy({ bossType: 7 });
  const slowSystem = systemWithTower(slowTower);
  assert.equal((slowSystem as unknown as {
    applyHeroSlow(target: Enemy, t: Tower): boolean;
  }).applyHeroSlow.call(slowSystem, slowBoss, slowTower), false);
  assert.equal(slowBoss.slowTimer, 0);

  const statusTarget = createMovingEnemy({ fireTimer: 48, fireFrame: 3 });
  const statusSystem = systemWithTower(createTower(5));
  const status = statusSystem as unknown as {
    setFreeze(target: Enemy, duration: number): void;
    setFire(target: Enemy, duration: number): void;
  };
  status.setFreeze.call(statusSystem, statusTarget, 48);
  assert.equal(statusTarget.fireTimer, 0);
  status.setFire.call(statusSystem, statusTarget, 48);
  assert.equal(statusTarget.freezeTimer, 0);
});

test('范围冰冻、范围麻痹、吴国液体减速与滚油只刷新计时而不重启动画', () => {
  const freezeTower = createTower(5, { level: 7, heroId: 21 });
  const freezeTarget = createMovingEnemy({ x: 24, y: 24 });
  const freezeNearby = createMovingEnemy({
    x: 32, y: 24, fireTimer: 20, fireFrame: 4, freezeFrame: 2,
  });
  const freezeSystem = systemWithTower(freezeTower);
  (freezeSystem as unknown as {
    applyHeroAreaEffect(t: Tower, target: Enemy, targets: Enemy[]): void;
  }).applyHeroAreaEffect.call(freezeSystem, freezeTower, freezeTarget, [freezeTarget, freezeNearby]);
  assert.equal(freezeNearby.freezeTimer, 48);
  assert.equal(freezeNearby.freezeFrame, 2);
  assert.equal(freezeNearby.fireTimer, 20);
  assert.equal(freezeNearby.fireFrame, 4);

  const paralyzeTower = createTower(4, { level: 7, heroId: 20 });
  const paralyzeNearby = createMovingEnemy({ x: 32, y: 24, paralyzeFrame: 2 });
  const paralyzeSystem = systemWithTower(paralyzeTower);
  (paralyzeSystem as unknown as {
    applyHeroAreaEffect(t: Tower, target: Enemy, targets: Enemy[]): void;
  }).applyHeroAreaEffect.call(
    paralyzeSystem, paralyzeTower, freezeTarget, [freezeTarget, paralyzeNearby],
  );
  assert.equal(paralyzeNearby.paralyzeTimer, 48);
  assert.equal(paralyzeNearby.paralyzeFrame, 2);

  const oil = createTower(9, { heroId: -1 });
  const oilTarget = createMovingEnemy({ freezeTimer: 20, freezeFrame: 2, fireFrame: 4 });
  const oilSystem = systemWithTower(oil);
  const refresh = oilSystem as unknown as {
    setSlow(target: Enemy, duration: number, resetFrame: boolean): void;
    setFire(target: Enemy, duration: number, resetFrame: boolean, clearFreeze: boolean): void;
  };
  oilTarget.slowFrame = 2;
  refresh.setSlow.call(oilSystem, oilTarget, 48, false);
  refresh.setFire.call(oilSystem, oilTarget, 48, false, false);
  assert.equal(oilTarget.slowFrame, 2);
  assert.equal(oilTarget.fireFrame, 4);
  assert.equal(oilTarget.freezeTimer, 20);
});

test('魏国伤害强化、君主加成与吴国投石光环按原版顺序结算', () => {
  const boosted = createTower(1, { level: 7, damage: 28, heroId: 17, x: 0, y: 0 });
  const lord = createTower(0, { heroId: 11, x: 10, y: 10 });
  const aura = createTower(7, { heroId: 25, x: 4, y: 0 });
  const system = new TowerSystem({} as never, {} as never);
  (system as unknown as { towers: Tower[] }).towers = [boosted, lord, aura];
  const combat = system as unknown as {
    towerDamage(t: Tower): number;
    splashTowerDamage(t: Tower): number;
  };
  assert.equal(combat.towerDamage.call(system, boosted), 50);
  assert.equal(combat.splashTowerDamage.call(system, boosted), 28);
});

test('火焰跳伤动态读取蜀国七级烟火是否仍在场', () => {
  const system = new EnemySystem({} as never, {} as never);
  const tick = (system as unknown as {
    updateStatusEffects(target: Enemy): boolean;
  }).updateStatusEffects;
  const enemy = createMovingEnemy({ hp: 100, fireTimer: 8, firePower: 8 });
  system.setFireDamage(16);
  tick.call(system, enemy);
  assert.equal(enemy.hp, 84);
  enemy.fireTimer = 8;
  system.setFireDamage(8);
  tick.call(system, enemy);
  assert.equal(enemy.hp, 76);
});

test('滚油只有实际遇到燃烧敌人后才绘制 bu_39 引燃层', () => {
  const { system, draws } = visualSystem();
  const tower = createTower(9, {
    attackState: 1, attackPhase: 1, attackFrame: 4, liquidIgnited: false,
  });
  const renderAttack = (system as unknown as {
    renderAttackProcess(t: Tower, x: number, y: number): boolean;
  }).renderAttackProcess;
  renderAttack.call(system, tower, 0, 0);
  assert.equal(draws.some(draw => draw.key === 'bu_39'), false);
  tower.liquidIgnited = true;
  renderAttack.call(system, tower, 0, 0);
  assert.equal(draws.some(draw => draw.key === 'bu_39'), true);
  draws.length = 0;
  tower.attackPhase = 2;
  tower.attackFrame = 1;
  renderAttack.call(system, tower, 0, 0);
  assert.equal(draws.some(draw => draw.key === 'bu_39'), true);
});

test('SoundFont 播放使用 AudioContext 时间而不是把 context 当作时间参数', () => {
  const calls: unknown[][] = [];
  const audio = new AudioSystem();
  Object.assign(audio as unknown as Record<string, unknown>, {
    audioContext: { currentTime: 12.5, state: 'running' },
    soundfont: { play: (...args: unknown[]) => calls.push(args) },
    volume: 0.5,
  });
  const handleMidi = (audio as unknown as {
    handleMidiEvent(event: unknown): void;
  }).handleMidiEvent;
  handleMidi.call(audio, { name: 'Note on', noteNumber: 69, velocity: 100 });
  assert.equal(calls.length, 1);
  assert.equal(calls[0][0], 69);
  assert.equal(calls[0][1], 12.5);
});

test('Scale2x 按 B/D/E/F/H 官方邻域公式补齐斜边', () => {
  const rgba = (r: number, g: number, b: number, a: number = 255) => [r, g, b, a];
  const black = rgba(0, 0, 0);
  const red = rgba(255, 0, 0);
  const green = rgba(0, 255, 0);
  const blue = rgba(0, 0, 255);
  const source = {
    width: 3,
    height: 3,
    data: new Uint8ClampedArray([
      ...black, ...red, ...black,
      ...red, ...black, ...green,
      ...black, ...blue, ...black,
    ]),
  } as ImageData;
  const target = {
    width: 6,
    height: 6,
    data: new Uint8ClampedArray(6 * 6 * 4),
  } as ImageData;

  scale2x(source, target);
  const pixel = (x: number, y: number) => Array.from(target.data.slice((y * 6 + x) * 4, (y * 6 + x + 1) * 4));
  assert.deepEqual(pixel(2, 2), red);
  assert.deepEqual(pixel(3, 2), black);
  assert.deepEqual(pixel(2, 3), black);
  assert.deepEqual(pixel(3, 3), black);
});

test('Scale2x 拒绝尺寸不匹配的目标缓冲区', () => {
  const source = { width: 1, height: 1, data: new Uint8ClampedArray(4) } as ImageData;
  const target = { width: 3, height: 2, data: new Uint8ClampedArray(24) } as ImageData;
  assert.throws(() => scale2x(source, target), /exactly twice/);
});

test('九张内嵌地图的瓦片、翻转与地形层完整且不是全灰兜底数据', () => {
  for (let level = 0; level <= 8; level++) {
    const filename = resolve(`public/maps/level${level}.json`);
    const map = JSON.parse(readFileSync(filename, 'utf8')) as {
      width: number;
      height: number;
      tileLayer: number[];
      flipLayer: number[];
      terrainLayer: number[];
    };
    const total = map.width * map.height;
    assert.equal(map.tileLayer.length, total, `level${level} tileLayer`);
    assert.equal(map.flipLayer.length, total, `level${level} flipLayer`);
    assert.equal(map.terrainLayer.length, total, `level${level} terrainLayer`);
    assert.ok(new Set(map.tileLayer).size > 1, `level${level} must not use the all-gray fallback`);
    assert.ok(map.terrainLayer.includes(10), `level${level} enemy castle anchor`);
    assert.ok(map.terrainLayer.includes(11), `level${level} friendly castle anchor`);
  }
});
