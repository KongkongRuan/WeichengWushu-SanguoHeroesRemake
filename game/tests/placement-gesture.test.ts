import test from 'node:test';
import assert from 'node:assert/strict';
import { BuildBarSystem, BAR_CAT_BUILD, type BuildBarHost } from '../src/core/BuildBar';
import { TowerSystem, type Tower } from '../src/core/Tower';
import {
  PLACEMENT_EDGE_MAX_SPEED,
  PLACEMENT_EDGE_MIN_SPEED,
  placementEdgeVelocity,
} from '../src/core/PlacementGesture';

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

test('触屏塔卡可把同一 pointer 直接转入预览，金币不足不会提前阻止拖动', () => {
  let placedType = -1;
  const bar = new BuildBarSystem({ contentWidth: 240 } as never);
  bar.setHost(buildHost(type => { placedType = type; }));
  bar.setTouchOptimized(true);
  bar.open(BAR_CAT_BUILD);
  bar.update(1000);

  const hit = bar.hitTestTouchBuildCard(40, 220);
  assert.deepEqual(hit, { index: 0, type: 0 });
  assert.equal(bar.beginDirectPlacement(hit!), true);
  assert.equal(placedType, 0);
  assert.equal(bar.isOpen, false);
});

test('建造边缘滚屏只在 24px 感应带内启动，并按边缘深度线性加速', () => {
  assert.deepEqual(placementEdgeVelocity(120, 150, 240, 20, 296), { x: 0, y: 0, active: false });
  const shallow = placementEdgeVelocity(23, 150, 240, 20, 296);
  const deep = placementEdgeVelocity(0, 150, 240, 20, 296);
  assert.equal(shallow.active, true);
  assert.equal(shallow.x < 0, true);
  assert.equal(Math.abs(shallow.x) > PLACEMENT_EDGE_MIN_SPEED, true);
  assert.equal(deep.x, -PLACEMENT_EDGE_MAX_SPEED);
  assert.equal(placementEdgeVelocity(240, 296, 240, 20, 296).x, PLACEMENT_EDGE_MAX_SPEED);
  assert.equal(placementEdgeVelocity(240, 296, 240, 20, 296).y, PLACEMENT_EDGE_MAX_SPEED);
});

function placementMap() {
  return {
    width: 10,
    height: 10,
    isBuildableAt: () => true,
    getTerrain: () => 8,
    occupyBuildTile() {},
  };
}

test('放置校验区分越界、占用、地形、朝向、金币和锁定原因', () => {
  const map = placementMap();
  const system = new TowerSystem({} as never, map as never);
  system.setBuildCostProvider(() => 10);
  system.setGold(5);
  assert.equal(system.getPlacementFailure(9, 9, 0)?.code, 'out-of-bounds');
  assert.equal(system.getPlacementFailure(1, 1, 0)?.code, 'insufficient-gold');

  system.setGold(100);
  (system as unknown as { towers: Tower[] }).towers = [{ x: 1, y: 1, type: 0 } as Tower];
  assert.equal(system.getPlacementFailure(1, 1, 0)?.code, 'occupied');
  (system as unknown as { towers: Tower[] }).towers = [];

  const blockedMap = { ...map, isBuildableAt: () => false };
  const terrainSystem = new TowerSystem({} as never, blockedMap as never);
  terrainSystem.setGold(100);
  assert.equal(terrainSystem.getPlacementFailure(1, 1, 0)?.code, 'terrain');

  const directionSystem = new TowerSystem({} as never, map as never);
  directionSystem.setGold(100);
  assert.equal(directionSystem.getPlacementFailure(1, 1, 2)?.code, 'road-facing');

  const lockedSystem = new TowerSystem({} as never, map as never);
  lockedSystem.setGold(100);
  lockedSystem.setBuildUnlockCheck(() => false);
  assert.equal(lockedSystem.getPlacementFailure(1, 1, 0)?.code, 'locked');
});
