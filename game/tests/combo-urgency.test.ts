import test from 'node:test';
import assert from 'node:assert/strict';
import { readFileSync } from 'node:fs';
import { resolve } from 'node:path';
import {
  comboWindowCue,
  comboWindowPresentation,
} from '../src/core/MobileControls';

test('连战提示严格使用 5 秒窗口，并以精确资格而非四舍五入后的 3.0 秒判断档位', () => {
  const fast = comboWindowPresentation(3.0, true, 2);
  assert.deepEqual(fast, {
    tier: 'fast',
    actionLabel: '立即出兵 3.0',
    rewardLabel: '连战 +2',
    progress: 0.6,
  });

  const sustain = comboWindowPresentation(3.0, false, 2);
  assert.deepEqual(sustain, {
    tier: 'sustain',
    actionLabel: '继续连战 3.0',
    rewardLabel: '连战 +1',
    progress: 0.6,
  });
  assert.equal(comboWindowPresentation(0, false, 2), null);
  assert.equal(comboWindowPresentation(null, false, 2), null);
});

test('连战按钮显示实际可增加的等级，并在满级时改为保持提示', () => {
  assert.equal(comboWindowPresentation(4.8, true, 1)?.rewardLabel, '连战 +2');
  assert.equal(comboWindowPresentation(4.8, true, 4)?.rewardLabel, '连战 +1');
  assert.equal(comboWindowPresentation(2.9, false, 4)?.rewardLabel, '连战 +1');
  assert.equal(comboWindowPresentation(4.8, true, 5)?.rewardLabel, '保持连战 5');
  assert.equal(comboWindowPresentation(2.9, false, 5)?.rewardLabel, '保持连战 5');
  assert.equal(comboWindowPresentation(9, true, 1)?.progress, 1);
});

test('短振只在连战窗口出现和快速档结束时触发', () => {
  assert.equal(comboWindowCue(null, 'fast'), 'entered');
  assert.equal(comboWindowCue('fast', 'fast'), null);
  assert.equal(comboWindowCue('fast', 'sustain'), 'tier-shift');
  assert.equal(comboWindowCue('sustain', 'sustain'), null);
  assert.equal(comboWindowCue('sustain', null), null);
});

test('触屏布局把连战出兵提升为整行主按钮，并保留无点击遮挡的战场边缘提示', () => {
  const html = readFileSync(resolve('index.html'), 'utf8');
  assert.match(html, /#mobile-controls\.combo-active \[data-mobile-action="wave"\][^{]*\{[^}]*grid-column:\s*1 \/ -1/s);
  assert.match(html, /#game-container\.combo-active::after/);
  assert.match(html, /pointer-events:\s*none/);
  assert.match(html, /var\(--combo-progress/);
  assert.match(html, /#game-container\.combo-sustain::after/);
});
