import test from 'node:test';
import assert from 'node:assert/strict';
import { Game, GameState } from '../src/core/Game';

interface IntroInputHarness {
  state: GameState;
  introPhase: number;
  introAnimProgress: number;
  buildBar: { isOpen: boolean };
  towerSystem: { isBuildMode: boolean };
  uiSystem: { isPaused(): boolean };
  handleKeyDown(event: KeyboardEvent): void;
  endLevelIntro(): void;
  openBarForBoxTile(): void;
}

function keyEvent(key: string, repeat = false): KeyboardEvent & { prevented: boolean } {
  return {
    key,
    repeat,
    prevented: false,
    preventDefault() { this.prevented = true; },
  } as KeyboardEvent & { prevented: boolean };
}

test('Enter advances the level intro without opening the castle tech bar', () => {
  let introEnds = 0;
  let barOpens = 0;
  const game = Object.create(Game.prototype) as IntroInputHarness;
  Object.assign(game, {
    state: GameState.LEVEL_INTRO,
    introPhase: 0,
    introAnimProgress: 0,
    buildBar: { isOpen: false },
    towerSystem: { isBuildMode: false },
    uiSystem: { isPaused: () => false },
    endLevelIntro() {
      introEnds++;
      this.state = GameState.PLAYING;
    },
    openBarForBoxTile: () => { barOpens++; },
  });

  const repeatedDuringIntro = keyEvent('Enter', true);
  game.handleKeyDown(repeatedDuringIntro);
  assert.equal(game.introPhase, 0);
  assert.equal(repeatedDuringIntro.prevented, true);

  for (let expectedPhase = 1; expectedPhase <= 4; expectedPhase++) {
    const event = keyEvent('Enter');
    game.handleKeyDown(event);
    assert.equal(game.introPhase, expectedPhase);
    assert.equal(event.prevented, true);
    assert.equal(barOpens, 0);
  }

  game.handleKeyDown(keyEvent('Enter'));
  assert.equal(introEnds, 1);
  assert.equal(game.state, GameState.PLAYING);
  assert.equal(barOpens, 0);

  game.handleKeyDown(keyEvent('Enter', true));
  assert.equal(barOpens, 0);
});
