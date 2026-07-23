import test from 'node:test';
import assert from 'node:assert/strict';
import { Game, GameState } from '../src/core/Game';
import type { PointerSequenceEvent, PointerSequencePhase } from '../src/core/Input';

function pointer(
  phase: PointerSequencePhase,
  x: number,
  y: number,
  cssDistance: number,
): PointerSequenceEvent {
  return {
    phase,
    pointerId: 7,
    pointerType: 'touch',
    x,
    y,
    startX: 60,
    startY: 60,
    clientX: x,
    clientY: y,
    cssDistance,
    durationMs: 40,
    cancelReason: phase === 'cancel' ? 'pointercancel' : undefined,
  };
}

interface GestureHarness {
  buildGesture: unknown;
  handleBuildPointerSequence(event: PointerSequenceEvent): boolean;
}

function createHarness() {
  let buildMode = true;
  let buildPosition = { tx: 3, ty: 3 };
  let commits = 0;
  let messages = 0;
  let cardTaps = 0;
  let directStarts = 0;
  let buildType = 0;
  let conversionInput = { x: 0, y: 0 };
  let cardHit: { index: number; type: number } | null = null;
  const game = Object.create(Game.prototype) as GestureHarness & Record<string, unknown>;
  Object.assign(game, {
    state: GameState.PLAYING,
    inputSystem: { isTouchOptimized: true },
    uiSystem: {
      isPaused: () => false,
      showMessage: () => { messages++; },
    },
    renderer: { contentWidth: 240 },
    buildBar: {
      topY: 200,
      hitTestTouchBuildCard: () => cardHit,
      beginDirectPlacement: () => { directStarts++; buildMode = true; return true; },
      handleTap: () => { cardTaps++; return true; },
    },
    towerSystem: {
      get isBuildMode() { return buildMode; },
      get buildType() { return buildType; },
      getBuildPosition: () => buildPosition,
      setBuildPosition: (tx: number, ty: number) => { buildPosition = { tx, ty }; },
    },
    mapData: {
      width: 20,
      height: 30,
      isScreenInsideMap: () => true,
      tileToScreen: () => ({ x: 48, y: 48 }),
      screenToTile: (x: number, y: number) => { conversionInput = { x, y }; return { tx: 6, ty: 7 }; },
      setBuildingBox: () => {},
    },
    tryPlacePendingTower: () => { commits++; },
  });
  return {
    game,
    setCardHit(hit: { index: number; type: number } | null) { cardHit = hit; },
    setBuildType(type: number) { buildType = type; },
    values: () => ({ buildPosition, commits, messages, cardTaps, directStarts, conversionInput }),
  };
}

test('塔影必须越过 16 CSS px 才取得松手建造资格，重复 pointerup 只结算一次', () => {
  const harness = createHarness();
  const { game } = harness;
  assert.equal(game.handleBuildPointerSequence(pointer('down', 60, 60, 0)), true);
  assert.equal(game.handleBuildPointerSequence(pointer('move', 72, 60, 12)), true);
  game.handleBuildPointerSequence(pointer('up', 72, 60, 12));
  assert.equal(harness.values().commits, 0);
  assert.equal(harness.values().buildPosition.tx, 3);

  game.handleBuildPointerSequence(pointer('down', 60, 60, 0));
  game.handleBuildPointerSequence(pointer('move', 80, 80, 20));
  game.handleBuildPointerSequence(pointer('up', 80, 80, 20));
  assert.equal(harness.values().commits, 1);
  assert.deepEqual(harness.values().buildPosition, { tx: 6, ty: 7 });
  assert.equal(game.handleBuildPointerSequence(pointer('up', 80, 80, 20)), false);
  assert.equal(harness.values().commits, 1);
});

test('2×2 与 3×3 塔共享占地中心和 24px 抬升换算', () => {
  const twoByTwo = createHarness();
  twoByTwo.game.handleBuildPointerSequence(pointer('down', 60, 60, 0));
  twoByTwo.game.handleBuildPointerSequence(pointer('move', 80, 80, 20));
  assert.deepEqual(twoByTwo.values().conversionInput, { x: 64, y: 40 });

  const threeByThree = createHarness();
  threeByThree.setBuildType(2);
  threeByThree.game.handleBuildPointerSequence(pointer('down', 60, 60, 0));
  threeByThree.game.handleBuildPointerSequence(pointer('move', 80, 80, 20));
  assert.deepEqual(threeByThree.values().conversionInput, { x: 56, y: 32 });
});

test('pointercancel 清除建造资格，后续遗留 pointerup 不会提交', () => {
  const harness = createHarness();
  const { game } = harness;
  game.handleBuildPointerSequence(pointer('down', 60, 60, 0));
  game.handleBuildPointerSequence(pointer('move', 80, 80, 20));
  game.handleBuildPointerSequence(pointer('cancel', 80, 80, 20));
  assert.equal(game.handleBuildPointerSequence(pointer('up', 80, 80, 20)), false);
  assert.equal(harness.values().commits, 0);
});

test('塔卡内轻微滑动仍按轻点处理，越阈值并拖出栏才交接给塔影', () => {
  const harness = createHarness();
  const { game } = harness;
  harness.setCardHit({ index: 0, type: 0 });
  game.handleBuildPointerSequence(pointer('down', 60, 230, 0));
  game.handleBuildPointerSequence(pointer('move', 70, 220, 15));
  game.handleBuildPointerSequence(pointer('up', 70, 220, 15));
  assert.equal(harness.values().cardTaps, 1);
  assert.equal(harness.values().directStarts, 0);

  game.handleBuildPointerSequence(pointer('down', 60, 230, 0));
  game.handleBuildPointerSequence(pointer('move', 80, 180, 20));
  game.handleBuildPointerSequence(pointer('up', 80, 180, 20));
  assert.equal(harness.values().directStarts, 1);
  assert.equal(harness.values().commits, 1);
  assert.equal(harness.values().cardTaps, 1);
});
