/**
 * 游戏入口 - 危城无双之三国群英 H5版
 */
import { Game, GameState } from './core/Game';

const canvas = document.getElementById('game-canvas') as HTMLCanvasElement;
const game = new Game(canvas);

// 全局点击处理 (菜单/游戏结束/胜利/通关时)
canvas.addEventListener('click', () => {
  if (game.currentState === GameState.MENU) {
    game.startNewGame();
  } else if (game.currentState === GameState.GAME_OVER) {
    game.startNewGame();
  } else if (game.currentState === GameState.LEVEL_COMPLETE) {
    game.nextLevel();
  } else if (game.currentState === GameState.VICTORY) {
    game.startNewGame();
  }
});

// 启动游戏
game.start().then(() => {
  console.log('Game started');
}).catch((e) => {
  console.error('Failed to start game:', e);
});
