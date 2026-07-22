import test from 'node:test';
import assert from 'node:assert/strict';
import { Game, GameState } from '../src/core/Game';

interface CouncilInputHarness {
  state: GameState;
  councilSelectionIndex: number;
  councilTouchArmed: boolean;
  council: { pendingDefinitions: Array<{ id: string }> };
  handleKeyDown(event: KeyboardEvent): void;
  resolveCouncil(id: string | null): void;
}

function keyEvent(key: string): KeyboardEvent {
  return { key, preventDefault() {} } as KeyboardEvent;
}

test('军议弹出后连续确认键不会误选默认项', () => {
  const resolved: Array<string | null> = [];
  const game = Object.create(Game.prototype) as CouncilInputHarness;
  Object.assign(game, {
    state: GameState.COUNCIL,
    councilSelectionIndex: -1,
    councilTouchArmed: false,
    council: { pendingDefinitions: [{ id: 'reinforce_city' }, { id: 'steady_income' }] },
    resolveCouncil: (id: string | null) => resolved.push(id),
  });

  for (let i = 0; i < 5; i++) game.handleKeyDown(keyEvent('Enter'));
  game.handleKeyDown(keyEvent(' '));

  assert.deepEqual(resolved, []);
  assert.equal(game.councilSelectionIndex, -1);

  game.handleKeyDown(keyEvent('ArrowDown'));
  assert.equal(game.councilSelectionIndex, 0);
  game.handleKeyDown(keyEvent('Enter'));
  assert.deepEqual(resolved, ['reinforce_city']);
});

test('军议无默认项时向上选择从最后一项开始', () => {
  const resolved: Array<string | null> = [];
  const game = Object.create(Game.prototype) as CouncilInputHarness;
  Object.assign(game, {
    state: GameState.COUNCIL,
    councilSelectionIndex: -1,
    councilTouchArmed: false,
    council: { pendingDefinitions: [{ id: 'first' }, { id: 'last' }] },
    resolveCouncil: (id: string | null) => resolved.push(id),
  });

  game.handleKeyDown(keyEvent('ArrowUp'));
  assert.equal(game.councilSelectionIndex, 1);
  game.handleKeyDown(keyEvent('Enter'));
  assert.deepEqual(resolved, ['last']);
});
