import test from 'node:test';
import assert from 'node:assert/strict';
import { Game, GameState } from '../src/core/Game';

interface WaveIntelInputHarness {
  state: GameState;
  waveIntelExpanded: boolean;
  features: { waveIntel: boolean };
  inputSystem: { isTouchOptimized: boolean };
  uiSystem: {
    handleTap(x: number, y: number): boolean;
    isPaused(): boolean;
    isPauseMenuVisible(): boolean;
  };
  buildBar: { isOpen: boolean };
  towerSystem: {
    isBuildMode: boolean;
    getBuildPosition(): { tx: number; ty: number };
    setBuildPosition(tx: number, ty: number): void;
  };
  mapData: {
    screenToTile(x: number, y: number): { tx: number; ty: number };
    setBuildingBox(tx: number, ty: number, followCamera: boolean): void;
    getBuildingBoxTile(): { tx: number; ty: number };
  };
  handleTap(x: number, y: number): void;
}

test('触屏端原军情横幅区域的道路格仍可用于建造选位', () => {
  let buildPosition = { tx: 0, ty: 0 };
  const game = Object.create(Game.prototype) as WaveIntelInputHarness;
  Object.assign(game, {
    state: GameState.PLAYING,
    waveIntelExpanded: false,
    features: { waveIntel: true },
    inputSystem: { isTouchOptimized: true },
    uiSystem: {
      handleTap: () => false,
      isPaused: () => false,
      isPauseMenuVisible: () => false,
    },
    buildBar: { isOpen: false },
    towerSystem: {
      isBuildMode: true,
      getBuildPosition: () => buildPosition,
      setBuildPosition: (tx: number, ty: number) => { buildPosition = { tx, ty }; },
    },
    mapData: {
      screenToTile: () => ({ tx: 4, ty: 2 }),
      setBuildingBox: () => {},
      getBuildingBoxTile: () => ({ tx: 4, ty: 2 }),
    },
  });

  game.handleTap(80, 30);

  assert.deepEqual(buildPosition, { tx: 4, ty: 2 });
  assert.equal(game.waveIntelExpanded, false);
});
