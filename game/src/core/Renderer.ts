/**
 * 渲染器 - 混合渲染架构
 * 逻辑坐标 (240x320) 适配UI，物理像素坐标绘制高清精灵图
 * 原版游戏使用240x320逻辑分辨率，瓦片大小16px
 */
import { LOGICAL_WIDTH, LOGICAL_HEIGHT, TILE_SIZE } from '../data/gameData';

export class Renderer {
  private canvas: HTMLCanvasElement;
  private ctx: CanvasRenderingContext2D;
  private dpr: number = 1;
  private windowScale: number = 1;
  private renderScale: number = 2; // Scale2x

  // 虚拟画布 (逻辑分辨率)
  private virtualCanvas: HTMLCanvasElement;
  private virtualCtx: CanvasRenderingContext2D;

  // 图片缓存 (高清化后的图片)
  private imageCache: Map<string, HTMLCanvasElement> = new Map();

  constructor(canvas: HTMLCanvasElement) {
    this.canvas = canvas;
    this.ctx = canvas.getContext('2d', { alpha: false })!;
    this.ctx.imageSmoothingEnabled = false;

    this.virtualCanvas = document.createElement('canvas');
    this.virtualCanvas.width = LOGICAL_WIDTH;
    this.virtualCanvas.height = LOGICAL_HEIGHT;
    this.virtualCtx = this.virtualCanvas.getContext('2d', { alpha: false })!;
    this.virtualCtx.imageSmoothingEnabled = false;

    this.resize();
  }

  /**
   * 调整画布大小以适应窗口
   */
  resize(): void {
    this.dpr = window.devicePixelRatio || 1;
    const winW = window.innerWidth;
    const winH = window.innerHeight;

    // 计算缩放比例 (保持240:320 = 3:4比例)
    const scaleX = winW / LOGICAL_WIDTH;
    const scaleY = winH / LOGICAL_HEIGHT;
    this.windowScale = Math.min(scaleX, scaleY);

    // 物理像素尺寸
    const physW = Math.floor(LOGICAL_WIDTH * this.windowScale * this.dpr);
    const physH = Math.floor(LOGICAL_HEIGHT * this.windowScale * this.dpr);

    this.canvas.width = physW;
    this.canvas.height = physH;
    this.canvas.style.width = `${Math.floor(LOGICAL_WIDTH * this.windowScale)}px`;
    this.canvas.style.height = `${Math.floor(LOGICAL_HEIGHT * this.windowScale)}px`;

    this.ctx.imageSmoothingEnabled = false;
    this.ctx.setTransform(1, 0, 0, 1, 0, 0);
  }

  get totalScale(): number {
    return this.windowScale * this.dpr;
  }

  get virtualContext(): CanvasRenderingContext2D {
    return this.virtualCtx;
  }

  get displayCanvas(): HTMLCanvasElement {
    return this.canvas;
  }

  /**
   * 清空虚拟画布
   */
  clear(color: number = 0): void {
    const r = (color >> 16) & 0xFF;
    const g = (color >> 8) & 0xFF;
    const b = color & 0xFF;
    this.virtualCtx.fillStyle = `rgb(${r},${g},${b})`;
    this.virtualCtx.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);
  }

  /**
   * 在虚拟画布上绘制图片 (逻辑坐标)
   */
  drawImage(img: HTMLImageElement | HTMLCanvasElement, x: number, y: number): void {
    this.virtualCtx.drawImage(img, Math.floor(x), Math.floor(y));
  }

  /**
   * 绘制图片片段 (sprite sheet)
   */
  drawImageRegion(
    img: HTMLImageElement | HTMLCanvasElement,
    sx: number, sy: number, sw: number, sh: number,
    dx: number, dy: number, dw: number, dh: number,
  ): void {
    this.virtualCtx.drawImage(img, sx, sy, sw, sh, Math.floor(dx), Math.floor(dy), Math.floor(dw), Math.floor(dh));
  }

  /**
   * 绘制瓦片
   */
  drawTile(img: HTMLImageElement | HTMLCanvasElement, tileIndex: number, x: number, y: number, tilesPerRow: number, tileSize: number = TILE_SIZE): void {
    const sx = (tileIndex % tilesPerRow) * tileSize;
    const sy = Math.floor(tileIndex / tilesPerRow) * tileSize;
    this.drawImageRegion(img, sx, sy, tileSize, tileSize, x, y, tileSize, tileSize);
  }

  /**
   * 设置颜色
   */
  setColor(color: number): void {
    const r = (color >> 16) & 0xFF;
    const g = (color >> 8) & 0xFF;
    const b = color & 0xFF;
    this.virtualCtx.fillStyle = `rgb(${r},${g},${b})`;
    this.virtualCtx.strokeStyle = `rgb(${r},${g},${b})`;
  }

  /**
   * 填充矩形
   */
  fillRect(x: number, y: number, w: number, h: number): void {
    this.virtualCtx.fillRect(Math.floor(x), Math.floor(y), Math.floor(w), Math.floor(h));
  }

  /**
   * 绘制矩形
   */
  drawRect(x: number, y: number, w: number, h: number): void {
    this.virtualCtx.strokeRect(Math.floor(x), Math.floor(y), Math.floor(w), Math.floor(h));
  }

  /**
   * 设置裁剪区域
   */
  setClip(x: number, y: number, w: number, h: number): void {
    this.virtualCtx.save();
    this.virtualCtx.beginPath();
    this.virtualCtx.rect(Math.floor(x), Math.floor(y), Math.floor(w), Math.floor(h));
    this.virtualCtx.clip();
  }

  /**
   * 重置裁剪
   */
  resetClip(): void {
    this.virtualCtx.restore();
  }

  /**
   * 绘制文字
   */
  drawText(text: string, x: number, y: number, color: number = 0xFCFFCD, size: number = 10): void {
    this.setColor(color);
    this.virtualCtx.font = `${size}px monospace`;
    this.virtualCtx.textBaseline = 'top';
    this.virtualCtx.fillText(text, Math.floor(x), Math.floor(y));
  }

  /**
   * 将虚拟画布渲染到屏幕 (带高清缩放)
   */
  present(): void {
    const physW = this.canvas.width;
    const physH = this.canvas.height;

    this.ctx.imageSmoothingEnabled = false;
    this.ctx.setTransform(1, 0, 0, 1, 0, 0);
    this.ctx.fillStyle = '#000';
    this.ctx.fillRect(0, 0, physW, physH);

    this.ctx.drawImage(
      this.virtualCanvas,
      0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT,
      0, 0, physW, physH,
    );
  }

  /**
   * 屏幕坐标转逻辑坐标
   */
  screenToLogical(screenX: number, screenY: number): { x: number; y: number } {
    const rect = this.canvas.getBoundingClientRect();
    const x = ((screenX - rect.left) / rect.width) * LOGICAL_WIDTH;
    const y = ((screenY - rect.top) / rect.height) * LOGICAL_HEIGHT;
    return { x, y };
  }

  /**
   * 加载图片
   */
  async loadImage(src: string): Promise<HTMLImageElement> {
    return new Promise((resolve, reject) => {
      const img = new Image();
      img.onload = () => resolve(img);
      img.onerror = () => reject(new Error(`Failed to load: ${src}`));
      img.src = src;
    });
  }

  /**
   * 预处理图片：应用Scale2x放大并缓存
   */
  async preprocessImage(img: HTMLImageElement, key: string, scale: number = 2): Promise<HTMLCanvasElement> {
    if (this.imageCache.has(key)) {
      return this.imageCache.get(key)!;
    }

    const canvas = document.createElement('canvas');
    canvas.width = img.width * scale;
    canvas.height = img.height * scale;
    const ctx = canvas.getContext('2d')!;
    ctx.imageSmoothingEnabled = false;
    ctx.drawImage(img, 0, 0, canvas.width, canvas.height);

    this.imageCache.set(key, canvas);
    return canvas;
  }
}
