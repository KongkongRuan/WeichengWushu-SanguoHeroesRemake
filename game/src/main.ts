/**
 * 游戏入口 - 危城无双之三国群英 H5版
 * 所有点击/触摸输入由 Game 内部的 InputSystem 统一处理
 */
import { Game } from './core/Game';
import '@fontsource-variable/noto-sans-sc/wght.css';

const canvas = document.getElementById('game-canvas') as HTMLCanvasElement;
const game = new Game(canvas);

// 调试句柄 (e2e 验证用)
(window as any).__game = game;

// Canvas 文字不会在字体下载后自动重排，先确保中文字体可用再启动主循环。
async function boot(): Promise<void> {
  await document.fonts.load('600 16px "Noto Sans SC Variable"', '危城无双三国群英');
  await document.fonts.ready;
  await game.start();
  console.log('Game started');
}

boot().catch((e) => {
  console.error('Failed to start game:', e);
});
