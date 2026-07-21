/**
 * 触屏输入系统 - 适配触屏的现代化交互
 * 原版为按键手机，H5版改用触屏/鼠标点击
 */
import { Renderer } from './Renderer';
import { TILE_SIZE } from '../data/gameData';

export interface TouchPoint {
  id: number;
  x: number;  // 逻辑坐标
  y: number;  // 逻辑坐标
}

type InputCallback = (x: number, y: number) => void;

export class InputSystem {
  private renderer: Renderer;
  private canvas: HTMLCanvasElement;
  private tapCallback: InputCallback | null = null;
  private longPressCallback: InputCallback | null = null;
  private moveCallback: ((x: number, y: number) => void) | null = null;
  private releaseCallback: InputCallback | null = null;

  private pressStartTime: number = 0;
  private pressStartX: number = 0;
  private pressStartY: number = 0;
  private isPressed: boolean = false;
  private isDragging: boolean = false;
  private longPressThreshold: number = 500; // ms
  private tapThreshold: number = 10; // pixels

  constructor(renderer: Renderer) {
    this.renderer = renderer;
    this.canvas = renderer.displayCanvas;
    this.setupListeners();
  }

  private setupListeners(): void {
    // 触摸事件
    this.canvas.addEventListener('touchstart', (e) => {
      e.preventDefault();
      const touch = e.touches[0];
      this.handleDown(touch.clientX, touch.clientY);
    }, { passive: false });

    this.canvas.addEventListener('touchmove', (e) => {
      e.preventDefault();
      const touch = e.touches[0];
      this.handleMove(touch.clientX, touch.clientY);
    }, { passive: false });

    this.canvas.addEventListener('touchend', (e) => {
      e.preventDefault();
      // 使用 changedTouches 获取实际释放坐标, 避免重复转换
      const touch = e.changedTouches[0];
      if (touch) {
        this.handleUp(touch.clientX, touch.clientY);
      } else {
        this.handleUp(this.pressStartX, this.pressStartY);
      }
    }, { passive: false });

    // 鼠标事件
    this.canvas.addEventListener('mousedown', (e) => {
      this.handleDown(e.clientX, e.clientY);
    });

    this.canvas.addEventListener('mousemove', (e) => {
      if (this.isPressed) {
        this.handleMove(e.clientX, e.clientY);
      }
    });

    this.canvas.addEventListener('mouseup', (e) => {
      this.handleUp(e.clientX, e.clientY);
    });

    this.canvas.addEventListener('mouseleave', () => {
      if (this.isPressed) this.releaseCallback?.(this.lastX, this.lastY);
      this.isPressed = false;
      this.isDragging = false;
    });
  }

  private handleDown(clientX: number, clientY: number): void {
    const pos = this.renderer.screenToLogical(clientX, clientY);
    this.pressStartTime = Date.now();
    this.pressStartX = pos.x;
    this.pressStartY = pos.y;
    this.lastX = pos.x;
    this.lastY = pos.y;
    this.isPressed = true;
    this.isDragging = false;

    // 长按检测
    setTimeout(() => {
      if (this.isPressed &&
          Math.abs(this.pressStartX - this.getLastX()) < this.tapThreshold &&
          Math.abs(this.pressStartY - this.getLastY()) < this.tapThreshold) {
        if (Date.now() - this.pressStartTime >= this.longPressThreshold) {
          this.longPressCallback?.(this.pressStartX, this.pressStartY);
        }
      }
    }, this.longPressThreshold);
  }

  private lastX: number = 0;
  private lastY: number = 0;

  private getLastX(): number { return this.lastX; }
  private getLastY(): number { return this.lastY; }

  private handleMove(clientX: number, clientY: number): void {
    const pos = this.renderer.screenToLogical(clientX, clientY);
    this.lastX = pos.x;
    this.lastY = pos.y;
    if (!this.isDragging) {
      const dist = Math.hypot(pos.x - this.pressStartX, pos.y - this.pressStartY);
      if (dist < this.tapThreshold) return;
      this.isDragging = true;
    }
    this.moveCallback?.(pos.x, pos.y);
  }

  private handleUp(clientX: number, clientY: number): void {
    if (!this.isPressed) return;
    this.isPressed = false;

    const pos = this.renderer.screenToLogical(clientX, clientY);
    const dist = Math.sqrt(
      (pos.x - this.pressStartX) ** 2 + (pos.y - this.pressStartY) ** 2
    );
    const duration = Date.now() - this.pressStartTime;

    // 如果是轻触 (短时间 + 小位移)
    if (!this.isDragging && dist < this.tapThreshold && duration < this.longPressThreshold) {
      this.tapCallback?.(pos.x, pos.y);
    }

    this.releaseCallback?.(pos.x, pos.y);
    this.isDragging = false;
  }

  /**
   * 设置轻触回调
   */
  onTap(callback: InputCallback): void {
    this.tapCallback = callback;
  }

  /**
   * 设置长按回调
   */
  onLongPress(callback: InputCallback): void {
    this.longPressCallback = callback;
  }

  /**
   * 设置移动回调
   */
  onMove(callback: (x: number, y: number) => void): void {
    this.moveCallback = callback;
  }

  /**
   * 设置释放回调
   */
  onRelease(callback: InputCallback): void {
    this.releaseCallback = callback;
  }

  /**
   * 逻辑坐标转瓦片坐标
   */
  toTile(x: number, y: number, offsetX: number = 0, offsetY: number = 0): { tx: number; ty: number } {
    return {
      tx: Math.floor((x - offsetX) / TILE_SIZE),
      ty: Math.floor((y - offsetY) / TILE_SIZE),
    };
  }
}
