import { LOGICAL_HEIGHT, LOGICAL_WIDTH, MAP_TOP_BAR_H, MAP_VIEW_H, TILE_SIZE } from '../data/gameData';

export type ViewportPreference = 'classic' | 'wide';

export interface ViewportRect {
  x: number;
  y: number;
  width: number;
  height: number;
}

export interface ViewportMetrics {
  logicalWidth: number;
  logicalHeight: number;
  battleRect: ViewportRect;
  legacyRect: ViewportRect;
  mapOriginX: number;
  cssScale: number;
  physicalScale: number;
  dpr: number;
}

export interface ViewportOptions {
  availableCssWidth: number;
  availableCssHeight: number;
  dpr: number;
  wide: boolean;
  integerPhysicalScale: boolean;
}

export const MIN_LOGICAL_WIDTH = LOGICAL_WIDTH;
export const MAX_LOGICAL_WIDTH = 704;
export const TOUCH_LANDSCAPE_SIDE_CSS_WIDTH = 132;

export function calculateUsableViewportArea(
  availableCssWidth: number,
  availableCssHeight: number,
  touchOptimized: boolean,
): { width: number; height: number } {
  const width = Math.max(1, availableCssWidth);
  const height = Math.max(1, availableCssHeight);
  const usesLandscapeSidebars = touchOptimized && width > height && height <= 600;
  return {
    width: usesLandscapeSidebars
      ? Math.max(1, width - TOUCH_LANDSCAPE_SIDE_CSS_WIDTH * 2)
      : width,
    height,
  };
}

export function calculateLogicalWidth(
  availableCssWidth: number,
  availableCssHeight: number,
  wide: boolean,
): number {
  if (!wide) return MIN_LOGICAL_WIDTH;
  const safeHeight = Math.max(1, availableCssHeight);
  const heightScale = safeHeight / LOGICAL_HEIGHT;
  const rawLogicalWidth = Math.max(MIN_LOGICAL_WIDTH, availableCssWidth / heightScale);
  const clamped = Math.min(MAX_LOGICAL_WIDTH, rawLogicalWidth);
  return Math.max(MIN_LOGICAL_WIDTH, Math.floor(clamped / TILE_SIZE) * TILE_SIZE);
}

export function calculateViewportMetrics(options: ViewportOptions): ViewportMetrics {
  const dpr = Math.max(1, options.dpr || 1);
  const logicalWidth = calculateLogicalWidth(
    Math.max(1, options.availableCssWidth),
    Math.max(1, options.availableCssHeight),
    options.wide,
  );
  const maxPhysicalScale = Math.min(
    (Math.max(1, options.availableCssWidth) * dpr) / logicalWidth,
    (Math.max(1, options.availableCssHeight) * dpr) / LOGICAL_HEIGHT,
  );
  const physicalScale = options.integerPhysicalScale && maxPhysicalScale >= 1
    ? Math.max(1, Math.floor(maxPhysicalScale))
    : Math.max(1 / 80, Math.floor(maxPhysicalScale * 80) / 80);
  const legacyX = Math.floor((logicalWidth - LOGICAL_WIDTH) / 2);
  return {
    logicalWidth,
    logicalHeight: LOGICAL_HEIGHT,
    battleRect: { x: 0, y: MAP_TOP_BAR_H, width: logicalWidth, height: MAP_VIEW_H },
    legacyRect: { x: legacyX, y: 0, width: LOGICAL_WIDTH, height: LOGICAL_HEIGHT },
    mapOriginX: 0,
    cssScale: physicalScale / dpr,
    physicalScale,
    dpr,
  };
}
