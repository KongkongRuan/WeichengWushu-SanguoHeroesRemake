import test from 'node:test';
import assert from 'node:assert/strict';
import {
  BAR_CAT_BUILD,
  BAR_CAT_TECH,
  BuildBarSystem,
  type BuildBarHost,
} from '../src/core/BuildBar';
import { CastleRenderer } from '../src/core/Castle';
import { Game, GameState } from '../src/core/Game';
import type { PointerSequenceEvent, PointerSequencePhase } from '../src/core/Input';
import {
  PLACEMENT_EDGE_MAX_SPEED,
  PLACEMENT_EDGE_MIN_SPEED,
  isHorizontalStripGesture,
  placementEdgeVelocity,
} from '../src/core/PlacementGesture';
import { CASTLE_PART_INIT_C1061 } from '../src/data/gameData';

function buildHost(enterPlacement: (type: number) => void): BuildBarHost {
  return {
    getGold: () => 0,
    trySpendGold: () => false,
    getTowerCount: () => 0,
    enterPlacement,
    upgradeTower: () => false,
    demolishTower() {},
    loadGate: () => false,
    releaseGate: () => false,
    getGateLoadCost: () => null,
    getUpgradeCost: () => null,
    getDemolishRefund: () => 0,
    renderTowerPreview() {},
    deselectTower() {},
    onTechBuilt() {},
  };
}

test('建筑卡片可由同一 pointer 直接转入预览，金币不足不会提前扣费或阻止拖动', () => {
  let type = -1;
  const bar = new BuildBarSystem({} as never);
  bar.setHost(buildHost(value => { type = value; }));
  bar.setTouchOptimized(true);
  bar.open(BAR_CAT_BUILD);
  bar.update(1000);
  const hit = bar.hitTestBuildCard(40, 210);
  assert.deepEqual(hit, { index: 0, item: 0, type: 0 });
  assert.equal(bar.beginDirectPlacement(hit!), true);
  assert.equal(type, 0);
  assert.equal(bar.isOpen, false);
});

test('建造与科技图标轨道在触屏和桌面布局下都连续滚动并吸附', () => {
  const touch = new BuildBarSystem({} as never);
  touch.setHost(buildHost(() => {}));
  touch.setTouchOptimized(true);
  touch.open(BAR_CAT_BUILD);
  touch.update(1000);
  assert.equal(touch.beginItemScroll(), true);
  touch.updateItemScroll(-86);
  touch.endItemScroll();
  assert.equal(touch.itemStripScrollOffset, 80);

  touch.open(BAR_CAT_TECH);
  touch.update(1000);
  assert.equal(touch.beginItemScroll(), true);
  touch.updateItemScroll(-100);
  touch.endItemScroll();
  assert.equal(touch.itemStripScrollOffset, 40);

  const desktop = new BuildBarSystem({} as never);
  desktop.setHost(buildHost(() => {}));
  desktop.open(BAR_CAT_BUILD);
  desktop.update(1000);
  assert.equal(desktop.beginItemScroll(), true);
  desktop.updateItemScroll(-65);
  desktop.endItemScroll();
  assert.equal(desktop.itemStripScrollOffset, 60);
});

test('横向图标滚动与向上直拖使用互斥方向判定', () => {
  assert.equal(isHorizontalStripGesture(30, 5), true);
  assert.equal(isHorizontalStripGesture(10, -30), false);
});

test('建造边缘滚屏只在24px感应带内启动，并按边缘深度加速', () => {
  assert.deepEqual(placementEdgeVelocity(120, 150, 240, 20, 296), { x: 0, y: 0, active: false });
  const shallow = placementEdgeVelocity(23, 150, 240, 20, 296);
  const deep = placementEdgeVelocity(0, 150, 240, 20, 296);
  assert.equal(shallow.active, true);
  assert.equal(Math.abs(shallow.x) > PLACEMENT_EDGE_MIN_SPEED, true);
  assert.equal(deep.x, -PLACEMENT_EDGE_MAX_SPEED);
});

function pointer(
  phase: PointerSequencePhase,
  x: number,
  y: number,
  cssDistance: number,
  startX = 60,
  startY = 230,
): PointerSequenceEvent {
  return {
    phase,
    pointerId: 7,
    pointerType: 'touch',
    x,
    y,
    startX,
    startY,
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

interface GameOverHarness {
  gameOverRestarting: boolean;
  gameOverSelection: number;
  handleGameOverTap(x: number, y: number): void;
  handleKeyDown(event: KeyboardEvent): void;
}

function gestureHarness() {
  let directStarts = 0;
  let scrollStarts = 0;
  let scrollUpdates = 0;
  let scrollEnds = 0;
  let taps = 0;
  let commits = 0;
  let buildMode = false;
  const game = Object.create(Game.prototype) as GestureHarness & Record<string, unknown>;
  Object.assign(game, {
    state: GameState.PLAYING,
    uiSystem: { isPaused: () => false, showMessage() {} },
    buildBar: {
      topY: 200,
      isItemStripScrollable: true,
      hitTestItemStrip: () => true,
      hitTestBuildCard: () => ({ index: 0, item: 0, type: 0 }),
      beginItemScroll: () => { scrollStarts++; return true; },
      updateItemScroll: () => { scrollUpdates++; },
      endItemScroll: () => { scrollEnds++; },
      beginDirectPlacement: () => { directStarts++; buildMode = true; return true; },
      handleTap: () => { taps++; return true; },
    },
    towerSystem: {
      get isBuildMode() { return buildMode; },
      get buildType() { return 0; },
      getBuildPosition: () => ({ tx: 1, ty: 1 }),
      setBuildPosition() {},
    },
    mapData: {
      width: 20,
      height: 20,
      isScreenInsideMap: () => true,
      screenToTile: () => ({ tx: 4, ty: 5 }),
      setBuildingBox() {},
    },
    tryPlacePendingTower: () => { commits++; },
  });
  return {
    game,
    values: () => ({ directStarts, scrollStarts, scrollUpdates, scrollEnds, taps, commits }),
  };
}

function placementTapHarness(pointerOnPreview: boolean) {
  let commits = 0;
  const game = Object.create(Game.prototype) as GestureHarness & Record<string, unknown>;
  Object.assign(game, {
    state: GameState.PLAYING,
    uiSystem: { isPaused: () => false, showMessage() {} },
    buildBar: { hitTestItemStrip: () => false },
    towerSystem: {
      isBuildMode: true,
      buildType: 0,
      getBuildPosition: () => ({ tx: 1, ty: 1 }),
      setBuildPosition() {},
    },
    mapData: {
      width: 20,
      height: 20,
      isScreenInsideMap: () => true,
      tileToScreen: () => pointerOnPreview ? ({ x: 40, y: 40 }) : ({ x: 160, y: 160 }),
    },
    tryPlacePendingTower: () => { commits++; },
  });
  return { game, commits: () => commits };
}

test('建筑卡横拖只滚列表，向上拖出栏才交接塔影并在松手时提交一次', () => {
  const horizontal = gestureHarness();
  horizontal.game.handleBuildPointerSequence(pointer('down', 60, 230, 0));
  horizontal.game.handleBuildPointerSequence(pointer('move', 100, 226, 40));
  horizontal.game.handleBuildPointerSequence(pointer('up', 100, 226, 40));
  assert.deepEqual(horizontal.values(), {
    directStarts: 0, scrollStarts: 1, scrollUpdates: 1, scrollEnds: 1, taps: 0, commits: 0,
  });

  const vertical = gestureHarness();
  vertical.game.handleBuildPointerSequence(pointer('down', 60, 230, 0));
  vertical.game.handleBuildPointerSequence(pointer('move', 64, 180, 50));
  vertical.game.handleBuildPointerSequence(pointer('up', 64, 180, 50));
  assert.equal(vertical.values().directStarts, 1);
  assert.equal(vertical.values().commits, 1);
  assert.equal(vertical.game.handleBuildPointerSequence(pointer('up', 64, 180, 50)), false);
  assert.equal(vertical.values().commits, 1);
});

test('塔影只接管从自身开始的拖动，轻点塔影仍确认建造，地图轻点留给原点击流程', () => {
  const preview = placementTapHarness(true);
  assert.equal(preview.game.handleBuildPointerSequence(pointer('down', 48, 48, 0, 48, 48)), true);
  assert.equal(preview.game.handleBuildPointerSequence(pointer('up', 48, 48, 0, 48, 48)), true);
  assert.equal(preview.commits(), 1);

  const map = placementTapHarness(false);
  assert.equal(map.game.handleBuildPointerSequence(pointer('down', 48, 48, 0, 48, 48)), false);
  assert.equal(map.commits(), 0);
});

test('建筑卡明显向下拖动后松手不会误触卡片', () => {
  const gesture = gestureHarness();
  gesture.game.handleBuildPointerSequence(pointer('down', 60, 230, 0));
  gesture.game.handleBuildPointerSequence(pointer('move', 64, 270, 40));
  gesture.game.handleBuildPointerSequence(pointer('up', 64, 270, 40));
  assert.deepEqual(gesture.values(), {
    directStarts: 0, scrollStarts: 0, scrollUpdates: 0, scrollEnds: 0, taps: 0, commits: 0,
  });
});

test('失败页载入期间锁定返回输入，按钮命中范围与绘制区域一致', () => {
  let activations = 0;
  let titleReturns = 0;
  let prevented = 0;
  const game = Object.create(Game.prototype) as GameOverHarness & Record<string, unknown>;
  Object.assign(game, {
    state: GameState.GAME_OVER,
    gameOverRestarting: true,
    gameOverSelection: 1,
    activateGameOverSelection: () => { activations++; },
    gotoTitle: () => { titleReturns++; },
  });

  game.handleGameOverTap(10, 276);
  assert.equal(game.gameOverSelection, 1);
  assert.equal(activations, 0);
  game.handleKeyDown({ key: 'Escape', preventDefault: () => { prevented++; } } as KeyboardEvent);
  assert.equal(titleReturns, 0);
  assert.equal(prevented, 1);

  game.gameOverRestarting = false;
  game.handleGameOverTap(10, 276);
  assert.equal(game.gameOverSelection, 0);
  assert.equal(activations, 1);
  game.handleGameOverTap(120, 290);
  game.handleGameOverTap(126, 302);
  assert.equal(activations, 1);
});

test('城墙定位框使用当前可见部件包围盒，科技完成后扩展到完整100×74范围', () => {
  const map = {
    ourCastlePos: { x: 100, y: 200 },
    cameraX: 0,
    cameraY: 0,
    isOurCastle: () => false,
  };
  const castle = new CastleRenderer({} as never, map as never);
  castle.setOurPartFilter([...CASTLE_PART_INIT_C1061]);
  assert.deepEqual(castle.getOurCastleWorldBounds(), { x: 100, y: 236, width: 96, height: 38 });
  assert.equal(castle.isOurCastleFocusTile(7, 15), true);
  assert.equal(castle.isOurCastleFocusTile(1, 1), false);

  castle.setOurPartFilter(new Array(10).fill(true));
  assert.deepEqual(castle.getOurCastleWorldBounds(), { x: 98, y: 200, width: 100, height: 74 });
});
