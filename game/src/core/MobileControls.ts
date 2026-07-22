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
  context: MobileControlContext;
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
  private readonly gold = document.getElementById('mobile-gold');
  private readonly lives = document.getElementById('mobile-lives');
  private readonly level = document.getElementById('mobile-level');
  private readonly wave = document.getElementById('mobile-wave');
  private readonly hint = document.getElementById('mobile-hint');
  private readonly speedButton = this.button('speed');
  private readonly pauseButton = this.button('pause');
  private readonly waveButton = this.button('wave');
  private readonly confirmButton = this.button('confirm');
  private readonly cancelButton = this.button('cancel');
  private lastStateKey = '';

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
    if (!state.visible) return;

    if (this.gold) this.gold.textContent = `金 ${state.gold}`;
    if (this.lives) this.lives.textContent = `防 ${state.lives}`;
    if (this.level) this.level.textContent = `关 ${state.level + 1}`;
    if (this.wave) this.wave.textContent = `波 ${state.wave}/${state.totalWaves}`;

    if (this.speedButton) this.speedButton.textContent = `速度 ${state.speed}×`;
    if (this.pauseButton) this.pauseButton.textContent = state.paused ? '继续' : '暂停';
    if (this.waveButton) {
      this.waveButton.disabled = !state.waveReady || state.paused;
      this.waveButton.textContent = state.waveReady ? '出兵 ▶' : '波次进行中';
    }

    const contextual = state.context !== 'normal' && !state.paused;
    if (this.confirmButton) {
      this.confirmButton.hidden = !contextual;
      this.confirmButton.textContent = state.context === 'placement' ? '建造' : '确认';
    }
    if (this.cancelButton) this.cancelButton.hidden = !contextual;

    if (this.hint) {
      this.hint.textContent = state.paused
        ? '战斗已暂停'
        : state.context === 'placement'
          ? '轻点地图移动预览，再点“建造”'
          : state.context === 'bar'
            ? '选择项目后点“确认”，点“取消”返回'
            : '单指拖动地图 · 轻点地块或防御塔';
    }
  }
}
