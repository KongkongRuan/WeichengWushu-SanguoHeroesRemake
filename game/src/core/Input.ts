/**
 * 统一输入系统。
 *
 * Pointer Events 让鼠标、触屏和触控笔共享同一套状态机，同时通过
 * pointer capture / pointercancel 避免手指滑出画布、来电中断或第二根
 * 手指加入时产生幽灵点击。
 */
import { Renderer } from './Renderer';
import { TILE_SIZE } from '../data/gameData';

export interface TouchPoint {
  id: number;
  x: number;
  y: number;
}

type InputCallback = (x: number, y: number) => void;
type InputModeCallback = (touchOptimized: boolean) => void;

export type PointerSequencePhase = 'down' | 'move' | 'up' | 'cancel';
export type PointerCancelReason =
  | 'pointercancel'
  | 'lost-capture'
  | 'second-pointer'
  | 'resize'
  | 'visibility-hidden'
  | 'external';

export interface PointerSequenceEvent {
  phase: PointerSequencePhase;
  pointerId: number;
  pointerType: string;
  x: number;
  y: number;
  startX: number;
  startY: number;
  clientX: number;
  clientY: number;
  cssDistance: number;
  durationMs: number;
  cancelReason?: PointerCancelReason;
}

/** 返回 true 会认领整个 pointer 序列，并抑制旧的 tap/drag 回调。 */
type PointerSequenceCallback = (event: PointerSequenceEvent) => boolean | void;

export class InputSystem {
  private renderer: Renderer;
  private canvas: HTMLCanvasElement;
  private tapCallback: InputCallback | null = null;
  private longPressCallback: InputCallback | null = null;
  private moveCallback: InputCallback | null = null;
  private dragEndCallback: InputCallback | null = null;
  private releaseCallback: InputCallback | null = null;
  private inputModeCallback: InputModeCallback | null = null;
  private pointerSequenceCallback: PointerSequenceCallback | null = null;

  private pressStartTime = 0;
  private pressStartX = 0;
  private pressStartY = 0;
  private pressStartClientX = 0;
  private pressStartClientY = 0;
  private lastX = 0;
  private lastY = 0;
  private isPressed = false;
  private isDragging = false;
  private activePointerId: number | null = null;
  private activePointerType = '';
  private sequenceClaimed = false;
  private longPressTimer: number | null = null;

  private readonly longPressThreshold = 500;
  /** 使用 CSS 像素，避免画布缩放后拖动阈值忽大忽小。 */
  private readonly tapThresholdCss = 10;
  private readonly touchLayoutOverride: boolean | null;
  private touchLayoutActive: boolean;

  constructor(renderer: Renderer) {
    this.renderer = renderer;
    this.canvas = renderer.displayCanvas;
    const override = new URLSearchParams(window.location.search).get('touch');
    this.touchLayoutOverride = override === '1' ? true : override === '0' ? false : null;
    this.touchLayoutActive = this.detectPrimaryTouchDevice();
    this.applyInputModeToDocument();
    this.setupListeners();
  }

  private detectPrimaryTouchDevice(): boolean {
    if (this.touchLayoutOverride !== null) return this.touchLayoutOverride;
    const coarse = window.matchMedia?.('(pointer: coarse)').matches ?? false;
    const noHover = window.matchMedia?.('(hover: none)').matches ?? false;
    return coarse || ((navigator.maxTouchPoints ?? 0) > 0 && noHover);
  }

  private applyInputModeToDocument(): void {
    document.documentElement.dataset.inputMode = this.touchLayoutActive ? 'touch' : 'pointer';
  }

  private activateTouchLayout(pointerType: string): void {
    if (this.touchLayoutOverride === false) return;
    if (pointerType !== 'touch' && pointerType !== 'pen') return;
    if (this.touchLayoutActive) return;
    this.touchLayoutActive = true;
    this.applyInputModeToDocument();
    this.inputModeCallback?.(true);
  }

  private setupListeners(): void {
    this.canvas.addEventListener('pointerdown', (event) => {
      if (this.activePointerId !== null && event.pointerId !== this.activePointerId) {
        event.preventDefault();
        this.cancelActivePointer('second-pointer');
        return;
      }
      if (!event.isPrimary || this.activePointerId !== null) return;
      if (event.pointerType === 'mouse' && event.button !== 0) return;

      event.preventDefault();
      this.activateTouchLayout(event.pointerType);
      this.activePointerId = event.pointerId;
      this.activePointerType = event.pointerType;
      try {
        this.canvas.setPointerCapture(event.pointerId);
      } catch {
        // 某些旧 WebView 不支持 capture；后续 cancel 仍能安全清理状态。
      }
      this.handleDown(event.pointerId, event.pointerType, event.clientX, event.clientY);
    });

    this.canvas.addEventListener('pointermove', (event) => {
      if (event.pointerId !== this.activePointerId || !this.isPressed) return;
      event.preventDefault();
      this.handleMove(event.pointerId, event.clientX, event.clientY);
    });

    this.canvas.addEventListener('pointerup', (event) => {
      if (event.pointerId !== this.activePointerId) return;
      event.preventDefault();
      this.handleUp(event.pointerId, event.clientX, event.clientY);
      this.finishPointer(event.pointerId);
    });

    this.canvas.addEventListener('pointercancel', (event) => {
      if (event.pointerId !== this.activePointerId) return;
      event.preventDefault();
      this.cancelActivePointer('pointercancel');
    });

    this.canvas.addEventListener('lostpointercapture', (event) => {
      if (event.pointerId !== this.activePointerId) return;
      this.cancelActivePointer('lost-capture', false);
    });

    this.canvas.addEventListener('contextmenu', (event) => event.preventDefault());
  }

  private finishPointer(pointerId: number): void {
    this.activePointerId = null;
    this.activePointerType = '';
    this.sequenceClaimed = false;
    try {
      if (this.canvas.hasPointerCapture(pointerId)) this.canvas.releasePointerCapture(pointerId);
    } catch {
      // 指针可能已由浏览器释放。
    }
  }

  private clearLongPressTimer(): void {
    if (this.longPressTimer !== null) {
      window.clearTimeout(this.longPressTimer);
      this.longPressTimer = null;
    }
  }

  private pointerEvent(
    phase: PointerSequencePhase,
    pointerId: number,
    clientX: number,
    clientY: number,
    cancelReason?: PointerCancelReason,
  ): PointerSequenceEvent {
    const pos = this.renderer.screenToLogical(clientX, clientY);
    return {
      phase,
      pointerId,
      pointerType: this.activePointerType,
      x: pos.x,
      y: pos.y,
      startX: this.pressStartX,
      startY: this.pressStartY,
      clientX,
      clientY,
      cssDistance: Math.hypot(clientX - this.pressStartClientX, clientY - this.pressStartClientY),
      durationMs: Math.max(0, performance.now() - this.pressStartTime),
      cancelReason,
    };
  }

  private emitPointerSequence(event: PointerSequenceEvent): boolean {
    const claimedNow = this.pointerSequenceCallback?.(event) === true;
    this.sequenceClaimed = this.sequenceClaimed || claimedNow;
    return this.sequenceClaimed;
  }

  private handleDown(pointerId: number, pointerType: string, clientX: number, clientY: number): void {
    const pos = this.renderer.screenToLogical(clientX, clientY);
    this.pressStartTime = performance.now();
    this.pressStartX = pos.x;
    this.pressStartY = pos.y;
    this.pressStartClientX = clientX;
    this.pressStartClientY = clientY;
    this.lastX = pos.x;
    this.lastY = pos.y;
    this.isPressed = true;
    this.isDragging = false;
    this.sequenceClaimed = false;

    const claimed = this.emitPointerSequence(this.pointerEvent('down', pointerId, clientX, clientY));

    this.clearLongPressTimer();
    if (claimed) return;
    this.longPressTimer = window.setTimeout(() => {
      this.longPressTimer = null;
      if (!this.isPressed || this.isDragging) return;
      if (performance.now() - this.pressStartTime < this.longPressThreshold) return;
      this.longPressCallback?.(this.pressStartX, this.pressStartY);
    }, this.longPressThreshold);
  }

  private handleMove(pointerId: number, clientX: number, clientY: number): void {
    const pos = this.renderer.screenToLogical(clientX, clientY);
    this.lastX = pos.x;
    this.lastY = pos.y;
    if (this.emitPointerSequence(this.pointerEvent('move', pointerId, clientX, clientY))) {
      this.clearLongPressTimer();
      return;
    }
    if (!this.isDragging) {
      const cssDistance = Math.hypot(
        clientX - this.pressStartClientX,
        clientY - this.pressStartClientY,
      );
      if (cssDistance < this.tapThresholdCss) return;
      this.isDragging = true;
      this.clearLongPressTimer();
    }
    this.moveCallback?.(pos.x, pos.y);
  }

  private handleUp(pointerId: number, clientX: number, clientY: number): void {
    if (!this.isPressed) return;
    this.isPressed = false;
    this.clearLongPressTimer();

    const pos = this.renderer.screenToLogical(clientX, clientY);
    const cssDistance = Math.hypot(
      clientX - this.pressStartClientX,
      clientY - this.pressStartClientY,
    );
    const duration = performance.now() - this.pressStartTime;

    if (this.emitPointerSequence(this.pointerEvent('up', pointerId, clientX, clientY))) {
      this.isDragging = false;
      return;
    }

    const wasDragging = this.isDragging;
    if (!wasDragging && cssDistance < this.tapThresholdCss && duration < this.longPressThreshold) {
      this.tapCallback?.(pos.x, pos.y);
    }

    if (wasDragging) this.dragEndCallback?.(pos.x, pos.y);
    this.releaseCallback?.(pos.x, pos.y);
    this.isDragging = false;
  }

  cancelActivePointer(reason: PointerCancelReason = 'external', releaseCapture: boolean = true): void {
    if (!this.isPressed || this.activePointerId === null) return;
    const pointerId = this.activePointerId;
    this.isPressed = false;
    this.clearLongPressTimer();
    const event = this.pointerEvent(
      'cancel',
      pointerId,
      this.pressStartClientX,
      this.pressStartClientY,
      reason,
    );
    event.x = this.lastX;
    event.y = this.lastY;
    const claimed = this.emitPointerSequence(event);
    if (!claimed) this.releaseCallback?.(this.lastX, this.lastY);
    this.isDragging = false;
    if (releaseCapture) this.finishPointer(pointerId);
    else {
      this.activePointerId = null;
      this.activePointerType = '';
      this.sequenceClaimed = false;
    }
  }

  get isTouchOptimized(): boolean {
    return this.touchLayoutActive;
  }

  onInputModeChange(callback: InputModeCallback): void {
    this.inputModeCallback = callback;
    callback(this.touchLayoutActive);
  }

  onPointerSequence(callback: PointerSequenceCallback): void {
    this.pointerSequenceCallback = callback;
  }

  onTap(callback: InputCallback): void {
    this.tapCallback = callback;
  }

  onLongPress(callback: InputCallback): void {
    this.longPressCallback = callback;
  }

  onMove(callback: InputCallback): void {
    this.moveCallback = callback;
  }

  /** 仅在真实 pointerup 且发生过拖动时触发；pointercancel 不会触发。 */
  onDragEnd(callback: InputCallback): void {
    this.dragEndCallback = callback;
  }

  onRelease(callback: InputCallback): void {
    this.releaseCallback = callback;
  }

  toTile(x: number, y: number, offsetX = 0, offsetY = 0): { tx: number; ty: number } {
    return {
      tx: Math.floor((x - offsetX) / TILE_SIZE),
      ty: Math.floor((y - offsetY) / TILE_SIZE),
    };
  }
}
