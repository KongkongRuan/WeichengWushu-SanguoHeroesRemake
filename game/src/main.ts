/**
 * 游戏入口 - 危城无双之三国群英 H5版
 * 所有点击/触摸输入由 Game 内部的 InputSystem 统一处理
 */
import { Game } from './core/Game';

const canvas = document.getElementById('game-canvas') as HTMLCanvasElement;
const game = new Game(canvas);

// 启动游戏
game.start().then(() => {
  console.log('Game started');
}).catch((e) => {
  console.error('Failed to start game:', e);
});
