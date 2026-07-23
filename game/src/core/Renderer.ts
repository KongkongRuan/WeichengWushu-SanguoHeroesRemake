/**
 * 渲染器：纵向保持 320 逻辑像素；战斗页可按屏幕比例扩展横向视野，
 * 其余页面仍在居中的 240×320 经典内容区绘制。
 */
import { LOGICAL_WIDTH, LOGICAL_HEIGHT, TILE_SIZE } from '../data/gameData';
import { scale2x } from './Scale2x';
import { calculateViewportMetrics, ViewportMetrics } from './Viewport';

export type DisplayMode = 'original' | 'hd';
type RenderImage = HTMLImageElement | HTMLCanvasElement;

const GAME_FONT_FAMILY = '"Noto Sans SC Variable", "Microsoft YaHei", sans-serif';

export class Renderer {
  private canvas: HTMLCanvasElement;
  private ctx: CanvasRenderingContext2D;
  private dpr: number = 1;
  private windowScale: number = 1;
  private physicalScale: number = 1;
  private mode: DisplayMode = 'hd';
  private wideViewport = false;
  private legacyContent = true;
  private availableCssWidth: number | null = null;
  private availableCssHeight: number | null = null;
  private viewport: ViewportMetrics = calculateViewportMetrics({
    availableCssWidth: LOGICAL_WIDTH,
    availableCssHeight: LOGICAL_HEIGHT,
    dpr: 1,
    wide: false,
    integerPhysicalScale: false,
  });

  private enhancedImages = new WeakMap<RenderImage, HTMLCanvasElement>();
  private enhancementFailures = new WeakSet<RenderImage>();
  private namedImageCache = new Map<string, HTMLCanvasElement>();

  constructor(canvas: HTMLCanvasElement) {
    this.canvas = canvas;
    this.ctx = canvas.getContext('2d', { alpha: false })!;
    this.resize();
  }

  /** 根据视口、DPR 与显示模式重建最终 backing canvas。 */
  resize(): void {
    this.dpr = Math.max(1, window.devicePixelRatio || 1);
    const viewport = window.visualViewport;
    const availableCssWidth = this.availableCssWidth ?? viewport?.width ?? window.innerWidth;
    const availableCssHeight = this.availableCssHeight ?? viewport?.height ?? window.innerHeight;
    this.viewport = calculateViewportMetrics({
      availableCssWidth,
      availableCssHeight,
      dpr: this.dpr,
      wide: this.wideViewport,
      integerPhysicalScale: this.mode === 'original',
    });
    this.physicalScale = this.viewport.physicalScale;

    this.canvas.width = Math.max(1, Math.round(this.viewport.logicalWidth * this.physicalScale));
    this.canvas.height = Math.max(1, Math.round(this.viewport.logicalHeight * this.physicalScale));
    this.canvas.style.width = `${this.canvas.width / this.dpr}px`;
    this.canvas.style.height = `${this.canvas.height / this.dpr}px`;
    this.canvas.style.imageRendering = this.mode === 'original' ? 'pixelated' : 'auto';

    this.windowScale = this.physicalScale / this.dpr;
    this.prepareContext();
  }

  setDisplayMode(mode: DisplayMode): void {
    if (this.mode === mode) return;
    this.mode = mode;
    this.resize();
  }

  setWideViewport(enabled: boolean): void {
    if (this.wideViewport === enabled) return;
    this.wideViewport = enabled;
    this.resize();
  }

  /** 同步输入布局实际留给 Canvas 的区域，并一次性重算宽屏模式。 */
  configureViewport(wide: boolean, availableCssWidth: number, availableCssHeight: number): void {
    this.wideViewport = wide;
    this.availableCssWidth = Math.max(1, availableCssWidth);
    this.availableCssHeight = Math.max(1, availableCssHeight);
    this.resize();
  }

  setContentLayout(layout: 'legacy' | 'battle'): void {
    const legacy = layout === 'legacy';
    if (this.legacyContent === legacy) return;
    this.legacyContent = legacy;
    this.prepareContext();
  }

  get displayMode(): DisplayMode {
    return this.mode;
  }

  get totalScale(): number {
    return this.physicalScale;
  }

  get metrics(): Readonly<ViewportMetrics> {
    return this.viewport;
  }

  get logicalWidth(): number {
    return this.viewport.logicalWidth;
  }

  get contentWidth(): number {
    return this.legacyContent ? LOGICAL_WIDTH : this.viewport.logicalWidth;
  }

  get isLegacyContent(): boolean {
    return this.legacyContent;
  }

  /** 兼容旧系统命名：该 context 现在就是最终高 DPI context。 */
  get virtualContext(): CanvasRenderingContext2D {
    return this.ctx;
  }

  get displayCanvas(): HTMLCanvasElement {
    return this.canvas;
  }

  private prepareContext(): void {
    this.ctx.setTransform(this.physicalScale, 0, 0, this.physicalScale, 0, 0);
    if (this.legacyContent) this.ctx.translate(this.viewport.legacyRect.x, this.viewport.legacyRect.y);
    this.ctx.imageSmoothingEnabled = false;
    this.ctx.globalAlpha = 1;
    this.ctx.textBaseline = 'top';
  }

  clear(color: number = 0): void {
    // 先清理整个动态画布，再恢复当前内容区变换。
    this.ctx.setTransform(this.physicalScale, 0, 0, this.physicalScale, 0, 0);
    this.setColor(color);
    this.ctx.fillRect(0, 0, this.viewport.logicalWidth, this.viewport.logicalHeight);
    this.prepareContext();
  }

  private dimensions(img: RenderImage): { width: number; height: number } {
    if (img instanceof HTMLImageElement) {
      return { width: img.naturalWidth || img.width, height: img.naturalHeight || img.height };
    }
    return { width: img.width, height: img.height };
  }

  /** 首次使用时生成 Scale2x 版本；缓存按图片对象隔离，不覆盖原始资产。 */
  private enhanced(img: RenderImage): { image: RenderImage; factor: number } {
    if (this.mode !== 'hd' || this.enhancementFailures.has(img)) return { image: img, factor: 1 };
    const cached = this.enhancedImages.get(img);
    if (cached) return { image: cached, factor: 2 };

    const { width, height } = this.dimensions(img);
    if (width <= 0 || height <= 0) return { image: img, factor: 1 };

    try {
      const sourceCanvas = document.createElement('canvas');
      sourceCanvas.width = width;
      sourceCanvas.height = height;
      const sourceContext = sourceCanvas.getContext('2d', { willReadFrequently: true })!;
      sourceContext.imageSmoothingEnabled = false;
      sourceContext.drawImage(img, 0, 0, width, height);

      const output = document.createElement('canvas');
      output.width = width * 2;
      output.height = height * 2;
      const outputContext = output.getContext('2d')!;
      const sourceData = sourceContext.getImageData(0, 0, width, height);
      const outputData = outputContext.createImageData(output.width, output.height);
      scale2x(sourceData, outputData);
      outputContext.putImageData(outputData, 0, 0);
      this.enhancedImages.set(img, output);
      return { image: output, factor: 2 };
    } catch (error) {
      // 跨域或浏览器内存限制时安全回退到原始像素图。
      console.warn('Scale2x enhancement skipped for an image', error);
      this.enhancementFailures.add(img);
      return { image: img, factor: 1 };
    }
  }

  drawImage(img: RenderImage, x: number, y: number): void {
    const { width, height } = this.dimensions(img);
    const drawable = this.enhanced(img);
    this.ctx.drawImage(drawable.image, Math.floor(x), Math.floor(y), width, height);
  }

  drawImageRegion(
    img: RenderImage,
    sx: number, sy: number, sw: number, sh: number,
    dx: number, dy: number, dw: number, dh: number,
  ): void {
    const drawable = this.enhanced(img);
    const factor = drawable.factor;
    this.ctx.drawImage(
      drawable.image,
      sx * factor, sy * factor, sw * factor, sh * factor,
      Math.floor(dx), Math.floor(dy), Math.floor(dw), Math.floor(dh),
    );
  }

  drawImageFlipped(img: RenderImage, x: number, y: number, flipH: boolean, flipV: boolean = false): void {
    const { width, height } = this.dimensions(img);
    this.ctx.save();
    this.ctx.translate(Math.floor(x) + (flipH ? width : 0), Math.floor(y) + (flipV ? height : 0));
    this.ctx.scale(flipH ? -1 : 1, flipV ? -1 : 1);
    this.drawImage(img, 0, 0);
    this.ctx.restore();
  }

  drawImageRotated(img: RenderImage, x: number, y: number, quarterTurns: number): void {
    this.ctx.save();
    this.ctx.translate(Math.floor(x), Math.floor(y));
    this.ctx.rotate(quarterTurns * Math.PI / 2);
    this.drawImage(img, 0, 0);
    this.ctx.restore();
  }

  drawSpriteTransform(
    img: RenderImage,
    sx: number, sy: number, sw: number, sh: number,
    dx: number, dy: number,
    transform: number,
  ): void {
    const x = Math.floor(dx);
    const y = Math.floor(dy);
    this.ctx.save();
    switch (transform) {
      case 1:
        this.ctx.translate(x + sw, y);
        this.ctx.scale(-1, 1);
        break;
      case 2:
        this.ctx.translate(x, y + sh);
        this.ctx.scale(1, -1);
        break;
      case 3:
        this.ctx.translate(x + sw, y + sh);
        this.ctx.scale(-1, -1);
        break;
      case 4:
        this.ctx.translate(x, y);
        this.ctx.rotate(Math.PI / 2);
        this.ctx.scale(-1, 1);
        break;
      case 5:
        this.ctx.translate(x, y + sw);
        this.ctx.rotate(-Math.PI / 2);
        break;
      case 6:
        this.ctx.translate(x + sh, y);
        this.ctx.rotate(Math.PI / 2);
        break;
      case 7:
        this.ctx.translate(x + sh, y + sw);
        this.ctx.rotate(Math.PI / 2);
        this.ctx.scale(1, -1);
        break;
      default:
        this.ctx.translate(x, y);
        break;
    }
    this.drawImageRegion(img, sx, sy, sw, sh, 0, 0, sw, sh);
    this.ctx.restore();
  }

  drawTile(img: RenderImage, tileIndex: number, x: number, y: number, tilesPerRow: number, tileSize: number = TILE_SIZE): void {
    const sx = (tileIndex % tilesPerRow) * tileSize;
    const sy = Math.floor(tileIndex / tilesPerRow) * tileSize;
    this.drawImageRegion(img, sx, sy, tileSize, tileSize, x, y, tileSize, tileSize);
  }

  setColor(color: number): void {
    const r = (color >> 16) & 0xFF;
    const g = (color >> 8) & 0xFF;
    const b = color & 0xFF;
    this.ctx.fillStyle = `rgb(${r},${g},${b})`;
    this.ctx.strokeStyle = `rgb(${r},${g},${b})`;
  }

  fillRect(x: number, y: number, w: number, h: number): void {
    this.ctx.fillRect(Math.floor(x), Math.floor(y), Math.floor(w), Math.floor(h));
  }

  drawRect(x: number, y: number, w: number, h: number): void {
    this.ctx.strokeRect(Math.floor(x), Math.floor(y), Math.floor(w), Math.floor(h));
  }

  setClip(x: number, y: number, w: number, h: number): void {
    this.ctx.save();
    this.ctx.beginPath();
    this.ctx.rect(Math.floor(x), Math.floor(y), Math.floor(w), Math.floor(h));
    this.ctx.clip();
  }

  resetClip(): void {
    this.ctx.restore();
  }

  setAlpha(alpha: number): void {
    this.ctx.globalAlpha = Math.max(0, Math.min(1, alpha));
  }

  setTextStyle(size: number = 10, weight: number = 600): void {
    this.ctx.font = `${weight} ${size}px ${GAME_FONT_FAMILY}`;
    this.ctx.textBaseline = 'top';
  }

  measureText(text: string, size: number = 10, weight: number = 600): TextMetrics {
    this.setTextStyle(size, weight);
    return this.ctx.measureText(text);
  }

  drawText(text: string, x: number, y: number, color: number = 0xFCFFCD, size: number = 10): void {
    this.setColor(color);
    this.setTextStyle(size);
    this.ctx.fillText(text, Math.floor(x), Math.floor(y));
  }

  /** 已直接绘制到最终画布，保留方法用于兼容现有主循环。 */
  present(): void {}

  screenToLogical(screenX: number, screenY: number): { x: number; y: number } {
    const rect = this.canvas.getBoundingClientRect();
    const rawX = ((screenX - rect.left) / rect.width) * this.viewport.logicalWidth;
    const rawY = ((screenY - rect.top) / rect.height) * this.viewport.logicalHeight;
    const x = this.legacyContent ? rawX - this.viewport.legacyRect.x : rawX;
    const y = this.legacyContent ? rawY - this.viewport.legacyRect.y : rawY;
    return { x, y };
  }

  async loadImage(src: string): Promise<HTMLImageElement> {
    return new Promise((resolve, reject) => {
      const img = new Image();
      img.onload = () => resolve(img);
      img.onerror = () => reject(new Error(`Failed to load: ${src}`));
      img.src = src;
    });
  }

  /** 兼容旧接口：显式预处理仍可使用，且不会修改传入图片。 */
  async preprocessImage(img: HTMLImageElement, key: string, scale: number = 2): Promise<HTMLCanvasElement> {
    const cached = this.namedImageCache.get(key);
    if (cached) return cached;

    const { width, height } = this.dimensions(img);
    const canvas = document.createElement('canvas');
    canvas.width = width * scale;
    canvas.height = height * scale;
    const context = canvas.getContext('2d')!;
    context.imageSmoothingEnabled = false;
    if (scale === 2) {
      const sourceCanvas = document.createElement('canvas');
      sourceCanvas.width = width;
      sourceCanvas.height = height;
      const sourceContext = sourceCanvas.getContext('2d')!;
      sourceContext.drawImage(img, 0, 0);
      const sourceData = sourceContext.getImageData(0, 0, width, height);
      const outputData = context.createImageData(canvas.width, canvas.height);
      scale2x(sourceData, outputData);
      context.putImageData(outputData, 0, 0);
    } else {
      context.drawImage(img, 0, 0, canvas.width, canvas.height);
    }
    this.namedImageCache.set(key, canvas);
    return canvas;
  }
}
