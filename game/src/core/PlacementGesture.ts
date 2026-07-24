export const POINTER_SCROLL_THRESHOLD_CSS = 10;
export const PLACEMENT_DRAG_THRESHOLD_CSS = 16;
export const BUILD_STRIP_AXIS_RATIO = 1.2;
export const PLACEMENT_EDGE_BAND = 24;
export const PLACEMENT_EDGE_DELAY_MS = 120;
export const PLACEMENT_EDGE_MIN_SPEED = 24;
export const PLACEMENT_EDGE_MAX_SPEED = 96;

export interface EdgeScrollVelocity {
  x: number;
  y: number;
  active: boolean;
}

function edgeAxisVelocity(position: number, min: number, max: number, band: number): number {
  if (position < min || position > max || band <= 0) return 0;
  let direction = 0;
  let depth = 0;
  if (position < min + band) {
    direction = -1;
    depth = (min + band - position) / band;
  } else if (position > max - band) {
    direction = 1;
    depth = (position - (max - band)) / band;
  }
  if (direction === 0) return 0;
  const clampedDepth = Math.max(0, Math.min(1, depth));
  return direction * (
    PLACEMENT_EDGE_MIN_SPEED
    + (PLACEMENT_EDGE_MAX_SPEED - PLACEMENT_EDGE_MIN_SPEED) * clampedDepth
  );
}

/** 建造拖动专用的无惯性边缘滚屏速度，单位为逻辑像素/秒。 */
export function placementEdgeVelocity(
  x: number,
  y: number,
  width: number,
  top: number,
  bottom: number,
  band: number = PLACEMENT_EDGE_BAND,
): EdgeScrollVelocity {
  const velocity = {
    x: edgeAxisVelocity(x, 0, width, band),
    y: edgeAxisVelocity(y, top, bottom, band),
    active: false,
  };
  velocity.active = velocity.x !== 0 || velocity.y !== 0;
  return velocity;
}

export function isHorizontalStripGesture(dx: number, dy: number): boolean {
  return Math.abs(dx) > Math.abs(dy) * BUILD_STRIP_AXIS_RATIO;
}
