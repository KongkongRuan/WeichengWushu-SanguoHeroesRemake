/**
 * Scale2x/Scale3x 算法 - 像素素材无损高清化
 * 原版游戏素材为低分辨率像素图，通过Scale2x/3x算法放大保持清晰度
 */

/**
 * Scale2x 算法: 将图像放大2倍，保持像素边缘清晰
 * 对每个像素P，检查其4个邻居(E,W,N,S)和对角线(A,B,C,D)
 * 规则:
 * - 若 E==W 且 N!=S: E0=E, E1=P, E2=P, E3=W (仅当匹配模式)
 */
export function scale2x(
  src: ImageData,
  dst: ImageData,
): void {
  const sw = src.width;
  const sh = src.height;
  const sd = src.data;
  const dd = dst.data;
  const dw = sw * 2;

  for (let y = 0; y < sh; y++) {
    for (let x = 0; x < sw; x++) {
      const si = (y * sw + x) * 4;
      const r = sd[si];
      const g = sd[si + 1];
      const b = sd[si + 2];
      const a = sd[si + 3];

      // 邻居
      const up = y > 0 ? (y - 1) * sw : 0;
      const down = y < sh - 1 ? (y + 1) * sw : (sh - 1) * sw;
      const left = x > 0 ? x - 1 : 0;
      const right = x < sw - 1 ? x + 1 : sw - 1;

      // B (上), D (下), E (左), F (右)
      const bi = (up + left) * 4;
      const ei = (y * sw + left) * 4;
      const fi = (y * sw + right) * 4;
      const di = (down + left) * 4;

      const br = sd[bi], bg = sd[bi + 1], bb = sd[bi + 2];
      const er = sd[ei], eg = sd[ei + 1], eb = sd[ei + 2];
      const fr = sd[fi], fg = sd[fi + 1], fb = sd[fi + 2];
      const dr = sd[di], dg = sd[di + 1], db = sd[di + 2];

      const sameColor = (r1: number, g1: number, b1: number, r2: number, g2: number, b2: number) =>
        r1 === r2 && g1 === g2 && b1 === b2;

      const eqB = sameColor(br, bg, bb, r, g, b);
      const eqD = sameColor(dr, dg, db, r, g, b);
      const eqE = sameColor(er, eg, eb, r, g, b);
      const eqF = sameColor(fr, fg, fb, r, g, b);

      // E0 (左上), E1 (右上), E2 (左下), E3 (右下)
      let e0r = r, e0g = g, e0b = b;
      let e1r = r, e1g = g, e1b = b;
      let e2r = r, e2g = g, e2b = b;
      let e3r = r, e3g = g, e3b = b;

      // Scale2x 规则
      if (!eqB && !eqD && eqE && !eqF) {
        // 左上 = E
        e0r = er; e0g = eg; e0b = eb;
      }
      if (!eqB && !eqD && !eqE && eqF) {
        // 右上 = F
        e1r = fr; e1g = fg; e1b = fb;
      }
      if (!eqB && !eqD && eqE && !eqF) {
        // 左下 = E
        e2r = er; e2g = eg; e2b = eb;
      }
      if (!eqB && !eqD && !eqE && eqF) {
        // 右下 = F
        e3r = fr; e3g = fg; e3b = fb;
      }

      // 写入目标
      const dx = x * 2;
      const dy = y * 2;
      const positions = [
        (dy * dw + dx) * 4,         // 左上
        (dy * dw + dx + 1) * 4,     // 右上
        ((dy + 1) * dw + dx) * 4,   // 左下
        ((dy + 1) * dw + dx + 1) * 4, // 右下
      ];
      const colors = [
        [e0r, e0g, e0b, a],
        [e1r, e1g, e1b, a],
        [e2r, e2g, e2b, a],
        [e3r, e3g, e3b, a],
      ];
      for (let i = 0; i < 4; i++) {
        const di2 = positions[i];
        dd[di2] = colors[i][0];
        dd[di2 + 1] = colors[i][1];
        dd[di2 + 2] = colors[i][2];
        dd[di2 + 3] = colors[i][3];
      }
    }
  }
}

/**
 * 将 canvas 内容放大2倍并保持像素清晰
 */
export function scaleCanvas2x(
  srcCanvas: HTMLCanvasElement,
  dstCanvas: HTMLCanvasElement,
): void {
  const sw = srcCanvas.width;
  const sh = srcCanvas.height;
  const dw = sw * 2;
  const dh = sh * 2;

  dstCanvas.width = dw;
  dstCanvas.height = dh;

  const sctx = srcCanvas.getContext('2d')!;
  const dctx = dstCanvas.getContext('2d')!;

  const srcImageData = sctx.getImageData(0, 0, sw, sh);
  const dstImageData = dctx.createImageData(dw, dh);

  scale2x(srcImageData, dstImageData);
  dctx.putImageData(dstImageData, 0, 0);
}

/**
 * 使用 canvas drawImage 进行最近邻放大 (备用方案)
 */
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
