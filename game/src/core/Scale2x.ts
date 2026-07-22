/**
 * 官方 Scale2x 邻域算法。
 *
 * 对中心像素 E 使用上(B)、左(D)、右(F)、下(H)四个邻居，生成：
 *   E0 E1
 *   E2 E3
 * 算法只补齐像素画中的斜边，不引入颜色、透明度或插值模糊。
 */
export function scale2x(src: ImageData, dst: ImageData): void {
  const sw = src.width;
  const sh = src.height;
  if (dst.width !== sw * 2 || dst.height !== sh * 2) {
    throw new Error('Scale2x destination must be exactly twice the source size');
  }

  const source = src.data;
  const target = dst.data;
  const dw = dst.width;

  const pixelIndex = (x: number, y: number): number => (y * sw + x) * 4;
  const equal = (a: number, b: number): boolean =>
    source[a] === source[b] &&
    source[a + 1] === source[b + 1] &&
    source[a + 2] === source[b + 2] &&
    source[a + 3] === source[b + 3];
  const write = (sourceIndex: number, x: number, y: number): void => {
    const targetIndex = (y * dw + x) * 4;
    target[targetIndex] = source[sourceIndex];
    target[targetIndex + 1] = source[sourceIndex + 1];
    target[targetIndex + 2] = source[sourceIndex + 2];
    target[targetIndex + 3] = source[sourceIndex + 3];
  };

  for (let y = 0; y < sh; y++) {
    for (let x = 0; x < sw; x++) {
      const e = pixelIndex(x, y);
      const b = pixelIndex(x, Math.max(0, y - 1));
      const d = pixelIndex(Math.max(0, x - 1), y);
      const f = pixelIndex(Math.min(sw - 1, x + 1), y);
      const h = pixelIndex(x, Math.min(sh - 1, y + 1));

      let e0 = e;
      let e1 = e;
      let e2 = e;
      let e3 = e;
      if (!equal(b, h) && !equal(d, f)) {
        if (equal(d, b)) e0 = d;
        if (equal(b, f)) e1 = f;
        if (equal(d, h)) e2 = d;
        if (equal(h, f)) e3 = f;
      }

      const dx = x * 2;
      const dy = y * 2;
      write(e0, dx, dy);
      write(e1, dx + 1, dy);
      write(e2, dx, dy + 1);
      write(e3, dx + 1, dy + 1);
    }
  }
}

/** 将 canvas 内容按 Scale2x 放大到另一个 canvas。 */
export function scaleCanvas2x(srcCanvas: HTMLCanvasElement, dstCanvas: HTMLCanvasElement): void {
  const sw = srcCanvas.width;
  const sh = srcCanvas.height;
  dstCanvas.width = sw * 2;
  dstCanvas.height = sh * 2;

  const sourceContext = srcCanvas.getContext('2d')!;
  const targetContext = dstCanvas.getContext('2d')!;
  const source = sourceContext.getImageData(0, 0, sw, sh);
  const target = targetContext.createImageData(sw * 2, sh * 2);
  scale2x(source, target);
  targetContext.putImageData(target, 0, 0);
}

/** 最近邻绘制工具，用于不适合 Scale2x 的临时画布。 */
export function drawImageNearest(
  ctx: CanvasRenderingContext2D,
  img: CanvasImageSource,
  dx: number,
  dy: number,
  dw: number,
  dh: number,
): void {
  ctx.save();
  ctx.imageSmoothingEnabled = false;
  ctx.drawImage(img, dx, dy, dw, dh);
  ctx.restore();
}
