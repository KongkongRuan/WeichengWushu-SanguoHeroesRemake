import test from 'node:test';
import assert from 'node:assert/strict';
import {
  calculateLogicalWidth,
  calculateUsableViewportArea,
  calculateViewportMetrics,
} from '../src/core/Viewport';
import { MapData } from '../src/core/MapData';

test('经典视野始终保持 240×320', () => {
  assert.equal(calculateLogicalWidth(2048, 1024, false), 240);
  const metrics = calculateViewportMetrics({
    availableCssWidth: 2048,
    availableCssHeight: 1024,
    dpr: 1,
    wide: false,
    integerPhysicalScale: false,
  });
  assert.equal(metrics.logicalWidth, 240);
  assert.equal(metrics.logicalHeight, 320);
  assert.deepEqual(metrics.legacyRect, { x: 0, y: 0, width: 240, height: 320 });
});

test('2048×1024 宽屏得到 640 逻辑像素且保持瓦片整数边界', () => {
  const metrics = calculateViewportMetrics({
    availableCssWidth: 2048,
    availableCssHeight: 1024,
    dpr: 2,
    wide: true,
    integerPhysicalScale: false,
  });
  assert.equal(metrics.logicalWidth, 640);
  assert.equal(metrics.logicalWidth % 16, 0);
  assert.equal(metrics.battleRect.width, 640);
  assert.deepEqual(metrics.legacyRect, { x: 200, y: 0, width: 240, height: 320 });
});

test('极宽屏视野上限为最宽地图的 704 逻辑像素', () => {
  assert.equal(calculateLogicalWidth(5120, 1440, true), 704);
});

test('常见桌面宽高比按高度反算视野并始终对齐 16px 瓦片', () => {
  const cases = [
    [1024, 768, 416],   // 4:3
    [1920, 1080, 560],  // 16:9
    [1920, 1200, 512],  // 16:10
    [2560, 1080, 704],  // 21:9，命中地图宽度上限
    [5120, 1440, 704],  // 32:9，继续保持上限
  ] as const;
  for (const [width, height, expected] of cases) {
    const logicalWidth = calculateLogicalWidth(width, height, true);
    assert.equal(logicalWidth, expected);
    assert.equal(logicalWidth % 16, 0);
  }
});

test('触屏横屏为两侧状态与操作栏预留安全区，竖屏和桌面不扣减宽度', () => {
  assert.deepEqual(calculateUsableViewportArea(844, 390, true), { width: 580, height: 390 });
  assert.deepEqual(calculateUsableViewportArea(568, 320, true), { width: 304, height: 320 });
  assert.deepEqual(calculateUsableViewportArea(390, 844, true), { width: 390, height: 844 });
  assert.deepEqual(calculateUsableViewportArea(844, 390, false), { width: 844, height: 390 });
});

test('窄地图在宽视口中居中，地图外侧不会被转换成可点击世界', () => {
  const map = new MapData({} as never);
  (map as unknown as { mapData: { width: number; height: number } }).mapData = { width: 20, height: 30 };
  map.setViewportWidth(640);
  assert.equal(map.screenMapOriginX, 160);
  assert.equal(map.isScreenInsideMap(159, 100), false);
  assert.equal(map.isScreenInsideMap(160, 100), true);
  assert.equal(map.isScreenInsideMap(479, 100), true);
  assert.equal(map.isScreenInsideMap(480, 100), false);
  assert.deepEqual(map.screenToTile(160, 20), { tx: 0, ty: 0 });
});

test('运行中改变战场宽度会尽量保留原世界中心', () => {
  const map = new MapData({} as never);
  (map as unknown as {
    mapData: { width: number; height: number };
    camX: number;
    targetCamX: number;
  }).mapData = { width: 44, height: 30 };
  (map as unknown as { camX: number; targetCamX: number }).camX = 300;
  (map as unknown as { camX: number; targetCamX: number }).targetCamX = 300;
  map.setViewportWidth(400);
  assert.equal(map.cameraX, 220);
  assert.equal(map.cameraX + map.viewWidth / 2, 420);
  map.updateCamera(1000);
  assert.equal(map.cameraX + map.viewWidth / 2, 420);
});
