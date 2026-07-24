import { DEPLOYMENT_CONFIG } from '../enhancement/WaveIntel';

export type MobileControlAction =
  | 'speed'
  | 'pause'
  | 'menu'
  | 'wave'
  | 'confirm'
  | 'cancel';

export type MobileControlContext = 'normal' | 'bar' | 'placement';

export interface MobileControlState {
  visible: boolean;
  gold: number;
  lives: number;
  level: number;
  wave: number;
  totalWaves: number;
  speed: number;
  paused: boolean;
  waveReady: boolean;
  comboCountdownSeconds: number | null;
  comboFastEligible: boolean;
  combo: number;
  battleIntel: string;
  context: MobileControlContext;
}

export type ComboWindowTier = 'fast' | 'sustain';

export interface ComboWindowPresentation {
  tier: ComboWindowTier;
  actionLabel: string;
  rewardLabel: string;
  progress: number;
}

export type ComboWindowCue = 'entered' | 'tier-shift' | null;

/**
 * 把连战规则转换成按钮文案。奖励展示实际可获得的等级，避免接近上限时虚报 +2。
 */
export function comboWindowPresentation(
  seconds: number | null,
  fastEligible: boolean,
  combo: number,
): ComboWindowPresentation | null {
  if (seconds == null || seconds <= 0) return null;
  const tier: ComboWindowTier = fastEligible ? 'fast' : 'sustain';
  const nominalGain = tier === 'fast' ? 2 : 1;
  const currentCombo = Math.max(0, Math.min(DEPLOYMENT_CONFIG.maxCombo, Math.floor(combo)));
  const actualGain = Math.min(nominalGain, DEPLOYMENT_CONFIG.maxCombo - currentCombo);
  return {
    tier,
    actionLabel: `${tier === 'fast' ? '立即出兵' : '继续连战'} ${seconds.toFixed(1)}`,
    rewardLabel: actualGain > 0 ? `连战 +${actualGain}` : `保持连战 ${currentCombo}`,
    progress: Math.max(0, Math.min(1, seconds / (DEPLOYMENT_CONFIG.eligibleMs / 1000))),
  };
}

/** 只在窗口出现和 +2 档转入 +1 档时提示，避免每 0.1 秒更新都触发振动。 */
export function comboWindowCue(
  previous: ComboWindowTier | null,
  current: ComboWindowTier | null,
): ComboWindowCue {
  if (current != null && previous == null) return 'entered';
  if (previous === 'fast' && current === 'sustain') return 'tier-shift';
  return null;
}

/**
 * 画布外的触屏控制层。
 *
 * 原作 240×320 画布在现代手机上会留下大块安全空白。这个控制层把空白
 * 变成大按钮和状态区，同时不改变战斗坐标、存档或桌面端布局。
 */
export class MobileControls {
  private callback: ((action: MobileControlAction) => void) | null = null;
  private readonly status = document.getElementById('mobile-status');
  private readonly controls = document.getElementById('mobile-controls');
  private readonly gameContainer = document.getElementById('game-container');
  private readonly gold = document.getElementById('mobile-gold');
  private readonly lives = document.getElementById('mobile-lives');
  private readonly level = document.getElementById('mobile-level');
  private readonly wave = document.getElementById('mobile-wave');
  private readonly intel = document.getElementById('mobile-intel');
  private readonly hint = document.getElementById('mobile-hint');
  private readonly speedButton = this.button('speed');
  private readonly pauseButton = this.button('pause');
  private readonly waveButton = this.button('wave');
  private readonly confirmButton = this.button('confirm');
  private readonly cancelButton = this.button('cancel');
  private lastStateKey = '';
  private comboTier: ComboWindowTier | null = null;

  constructor() {
    this.controls?.querySelectorAll<HTMLButtonElement>('[data-mobile-action]').forEach((button) => {
      button.addEventListener('click', () => {
        const action = button.dataset.mobileAction as MobileControlAction | undefined;
        if (!action || button.disabled) return;
        navigator.vibrate?.(8);
        this.callback?.(action);
      });
    });
  }

  private button(action: MobileControlAction): HTMLButtonElement | null {
    return this.controls?.querySelector<HTMLButtonElement>(`[data-mobile-action="${action}"]`) ?? null;
  }

  onAction(callback: (action: MobileControlAction) => void): void {
    this.callback = callback;
  }

  update(state: MobileControlState): void {
    const stateKey = JSON.stringify(state);
    if (stateKey === this.lastStateKey) return;
    this.lastStateKey = stateKey;

    if (this.status) this.status.hidden = !state.visible;
    if (this.controls) this.controls.hidden = !state.visible;
    if (!state.visible) {
      this.updateComboWindow(null, false);
      return;
    }

    if (this.gold) this.gold.textContent = `金 ${state.gold}`;
    if (this.lives) this.lives.textContent = `防 ${state.lives}`;
    if (this.level) this.level.textContent = `关 ${state.level + 1}`;
    if (this.wave) this.wave.textContent = `波 ${state.wave}/${state.totalWaves}`;
    if (this.intel) this.intel.textContent = state.battleIntel;

    if (this.speedButton) this.speedButton.textContent = `速度 ${state.speed}×`;
    if (this.pauseButton) this.pauseButton.textContent = state.paused ? '继续' : '暂停';
    const comboWindow = state.waveReady
      ? comboWindowPresentation(state.comboCountdownSeconds, state.comboFastEligible, state.combo)
      : null;
    this.updateComboWindow(comboWindow, state.paused);
    if (this.waveButton) {
      this.waveButton.disabled = !state.waveReady || state.paused;
      if (comboWindow) {
        this.waveButton.textContent = comboWindow.actionLabel;
        this.waveButton.dataset.comboReward = comboWindow.rewardLabel;
        this.waveButton.setAttribute(
          'aria-label',
          `${comboWindow.actionLabel}秒，${comboWindow.rewardLabel}`,
        );
      } else {
        this.waveButton.textContent = state.waveReady ? '出兵 ▶' : '波次进行中';
        delete this.waveButton.dataset.comboReward;
        this.waveButton.removeAttribute('aria-label');
      }
    }

    // 操作栏直接在画面内二次点击确认；大按钮只保留给需要移动塔影的建造选位。
    const contextual = state.context === 'placement' && !state.paused;
    if (this.confirmButton) {
      this.confirmButton.hidden = !contextual;
      this.confirmButton.textContent = '建造';
    }
    if (this.cancelButton) this.cancelButton.hidden = !contextual;

    if (this.hint) {
      this.hint.textContent = state.paused
        ? '战斗已暂停'
        : state.context === 'placement'
          ? '拖动塔影，松手建造 · 也可轻点选位'
          : state.context === 'bar'
            ? '点项目选择，再点同一项目确认 · 点栏外取消'
            : '单指拖动地图 · 轻点地块或防御塔';
    }
  }

  private updateComboWindow(presentation: ComboWindowPresentation | null, paused: boolean): void {
    const active = presentation != null;
    const cue = comboWindowCue(this.comboTier, presentation?.tier ?? null);
    const progress = `${((presentation?.progress ?? 0) * 100).toFixed(1)}%`;

    for (const target of [this.controls, this.gameContainer]) {
      if (!target) continue;
      target.classList.toggle('combo-active', active);
      target.classList.toggle('combo-fast', presentation?.tier === 'fast');
      target.classList.toggle('combo-sustain', presentation?.tier === 'sustain');
      if (active) target.style.setProperty('--combo-progress', progress);
      else target.style.removeProperty('--combo-progress');
    }

    if (this.gameContainer) {
      if (presentation) {
        this.gameContainer.dataset.comboCallout = `立即出兵 · ${presentation.rewardLabel}`;
      } else {
        delete this.gameContainer.dataset.comboCallout;
      }
    }

    if (!paused && typeof navigator !== 'undefined') {
      if (cue === 'entered') navigator.vibrate?.(24);
      else if (cue === 'tier-shift') navigator.vibrate?.(18);
    }
    this.comboTier = presentation?.tier ?? null;
  }
}
