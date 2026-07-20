/**
 * 地图数据系统 - 加载和渲染地图
 * 100%还原原版 a.java 的地图渲染逻辑
 *
 * 原版数据结构:
 *   mapdatalv 文件 (4层):
 *     Layer 0 (B1160): tileLayer  - 瓦片索引 (背景层)
 *     Layer 1 (C1161): flipLayer  - 翻转模式 (0-7, 控制瓦片如何绘制)
 *     Layer 2-3: 重复数据 (未使用)
 *
 *   mapsp 文件 (4层, 仅关卡1-8):
 *     Layer 0 (F1164): pathLayer  - 路径瓦片索引 (0=空, 1/2=入口, 3=路径, 5/6=出口, 7+=其他路径)
 *     Layer 1 (G1165): pathFlipLayer - 路径翻转模式
 *     Layer 2-3: 重复数据 (未使用)
 *
 * 原版渲染 (a.java 行22260+, ak()方法):
 *   - 相机系统: bA/bC=当前相机XY, bP/bQ=目标相机XY (跟随建筑方框)
 *   - 可视区域: 240x276 像素 (y偏移13px)
 *   - 只渲染可见区域的瓦片 (19列 x 18行)
 *   - 路径层叠加在背景层之上
 *
 * 原版相机跟随 (a.java an()方法):
 *   - 建筑方框 bN/bO 在地图中移动
 *   - 当方框接近屏幕边缘时, 相机跟随移动
 *   - 边缘阈值: X=112px, Y=130px
 */
import { Renderer } from './Renderer';
import {
  TILE_SIZE,
  MAP_TOP_BAR_H,
  MAP_VIEW_H,
  MAP_VIEW_W,
  LOGICAL_HEIGHT,
} from '../data/gameData';

export interface LevelMapData {
  level: number;
  width: number;          // 地图宽度 (瓦片数, 对应 bG)
  height: number;         // 地图高度 (瓦片数, 对应 bH)
  tileLayer: number[];    // 背景瓦片索引 (对应 B1160)
  flipLayer: number[];    // 瓦片翻转模式 (对应 C1161, 值0-7)
  pathLayer: number[];    // 路径瓦片索引 (对应 F1164, 0=空)
  pathFlipLayer?: number[]; // 路径翻转模式 (对应 G1165)
  spawnPoints?: { x: number; y: number; type: number }[];
}

// 路径层值含义 (原版 F1164 的值)
export const PATH_EMPTY = 0;       // 空地
export const PATH_ENTRY_1 = 1;     // 入口类型1 (敌人生成点)
export const PATH_ENTRY_2 = 2;     // 入口类型2
export const PATH_WAYPOINT = 3;    // 路径点
export const PATH_ROAD_4 = 4;     // 路路瓦片4
export const PATH_EXIT_1 = 5;      // 出口类型1 (敌人终点)
export const PATH_EXIT_2 = 6;      // 出口类型2
export const PATH_ROAD_7 = 7;     // 路路瓦片7
export const PATH_BUILDABLE = 15;  // 可建造标记 (原版 tileLayer 中的值15, 关卡0用作路径标记)

// 原版关卡0不加载 mapsp 文件 (a.java 行7452: if (n != 0) { ... this.D(n); })
// 关卡0的路径数据直接嵌入在 tileLayer (B1160) 中
// 当 aN==0 (无mapsp) 时, 原版使用 tileLayer 值作为路径值 (a.java 行22286-22290)
// tileLayer 中值为 1,2,3,5,6,15 的瓦片即为路径瓦片

/**
 * 原版 m1075 数组: 关卡索引 → map图集索引
 * m1075 = [0,1,2,3,4,5,6,4,3] (9个元素, 对应关卡0-8)
 * bL = m1075[level] + 5 → map图集在 a1013 中的索引
 * H5中直接用 m1075[level] 作为 map0-6.png 的索引
 */
const MAP_ATLAS_INDEX: number[] = [0, 1, 2, 3, 4, 5, 6, 4, 3];

export class MapData {
  private renderer: Renderer;
  private mapData: LevelMapData | null = null;

  // 原版 map 图集 (map0.png ~ map6.png)
  private mapAtlases: Map<number, HTMLImageElement> = new Map();
  private currentAtlas: HTMLImageElement | null = null;
  private currentLevel: number = 0;

  // 相机系统 (对应原版 bA/bC/bP/bQ)
  private camX: number = 0;     // 当前相机X (像素)
  private camY: number = 0;     // 当前相机Y (像素)
  private targetCamX: number = 0; // 目标相机X (跟随建筑方框)
  private targetCamY: number = 0; // 目标相机Y

  // 建筑方框位置 (对应原版 bN/bO, 像素坐标)
  private boxX: number = 0;
  private boxY: number = 0;

  constructor(renderer: Renderer) {
    this.renderer = renderer;
  }

  /**
   * 预加载所有 map 图集 PNG
   */
  async preloadAtlases(basePath: string = './sprites/'): Promise<void> {
    const loadPromises: Promise<void>[] = [];
    for (let i = 0; i <= 6; i++) {
      loadPromises.push(this.loadAtlas(basePath, i));
    }
    await Promise.all(loadPromises);
    console.log(`MapData: loaded ${this.mapAtlases.size} map atlases`);
  }

  private loadAtlas(basePath: string, index: number): Promise<void> {
    return new Promise((resolve) => {
      const img = new Image();
      img.onload = () => {
        this.mapAtlases.set(index, img);
        resolve();
      };
      img.onerror = () => {
        console.warn(`MapData: failed to load map${index}.png`);
        resolve();
      };
      img.src = `${basePath}map${index}.png`;
    });
  }

  /**
   * 加载关卡地图数据
   */
  async loadLevel(level: number): Promise<void> {
    this.currentLevel = level;
    const mapLevel = this.resolveMapLevel(level);

    // 加载地图数据 JSON
    try {
      const mapResponse = await fetch(`./maps/level${mapLevel}.json`);
      if (!mapResponse.ok) throw new Error(`HTTP ${mapResponse.status}`);
      this.mapData = await mapResponse.json() as LevelMapData;
      this.mapData.level = level;
    } catch (e) {
      console.warn(`Failed to load map level${mapLevel}, using default:`, e);
      this.mapData = this.createDefaultMap(level);
    }

    // 设置当前关卡对应的 map 图集
    const atlasIdx = MAP_ATLAS_INDEX[mapLevel] ?? 0;
    this.currentAtlas = this.mapAtlases.get(atlasIdx) ?? null;

    // 初始化建筑方框位置 (对应原版 c1070)
    this.boxX = this.getBuildingBoxInit(level, 0);
    this.boxY = this.getBuildingBoxInit(level, 1);

    // 初始化相机 (对应原版 y1155=true 时的全量重绘)
    this.updateCameraTarget();
    this.camX = this.targetCamX;
    this.camY = this.targetCamY;
  }

  /**
   * 获取建筑方框初始位置
   */
  private getBuildingBoxInit(level: number, axis: number): number {
    const positions = [
      [336, 64], [64, 528], [160, 176], [560, 432], [592, 352],
      [256, 320], [320, 336], [96, 640], [96, 32],
    ];
    if (level < positions.length) return positions[level][axis];
    return positions[level % positions.length][axis];
  }

  /**
   * 解析关卡到地图文件的映射
   */
  private resolveMapLevel(level: number): number {
    if (level <= 8) return level;
    return level % 9;
  }

  /**
   * 创建默认地图 (当JSON文件不存在时)
   */
  private createDefaultMap(level: number): LevelMapData {
    const w = 15;
    const h = 20;
    const tiles = w * h;
    const tileLayer = new Array(tiles).fill(9);
    const flipLayer = new Array(tiles).fill(0);
    const pathLayer = new Array(tiles).fill(0);
    return { level, width: w, height: h, tileLayer, flipLayer, pathLayer };
  }

  // ============================================================
  // 相机系统 (对应原版 an() + ak())
  // ============================================================

  /**
   * 更新相机目标位置 (对应原版 an() 方法)
   * 建筑方框在地图中移动, 当方框接近屏幕边缘时相机跟随
   */
  updateCameraTarget(): void {
    if (!this.mapData) return;

    const mapWPx = this.mapData.width * TILE_SIZE;
    const mapHPx = this.mapData.height * TILE_SIZE;
    const thresholdX = 112; // 原版: n5 = 112
    const thresholdY = 130; // 原版: n3 = 130
    const boxSize = TILE_SIZE; // 建筑方框大小 = 1瓦片

    // X轴: 如果方框在阈值范围内, 相机跟随
    if (this.boxX >= thresholdX && this.boxX <= mapWPx - boxSize - thresholdX) {
      this.targetCamX = this.boxX - thresholdX;
    } else if (this.boxX < thresholdX) {
      this.targetCamX = 0;
    } else {
      this.targetCamX = mapWPx - MAP_VIEW_W;
    }

    // Y轴: 同理
    if (this.boxY >= thresholdY && this.boxY <= mapHPx - boxSize - thresholdY) {
      this.targetCamY = this.boxY - thresholdY;
    } else if (this.boxY < thresholdY) {
      this.targetCamY = 0;
    } else {
      this.targetCamY = mapHPx - MAP_VIEW_H;
    }

    // 边界限制
    this.targetCamX = Math.max(0, Math.min(this.targetCamX, Math.max(0, mapWPx - MAP_VIEW_W)));
    this.targetCamY = Math.max(0, Math.min(this.targetCamY, Math.max(0, mapHPx - MAP_VIEW_H)));
  }

  /**
   * 平滑移动相机到目标位置 (对应原版 ak() 中的渐进滚动)
   */
  updateCamera(): void {
    // 简单的线性插值 - 原版使用渐进滚动
    const dx = this.targetCamX - this.camX;
    const dy = this.targetCamY - this.camY;
    if (Math.abs(dx) > 1) {
      this.camX += dx * 0.15;
    } else {
      this.camX = this.targetCamX;
    }
    if (Math.abs(dy) > 1) {
      this.camY += dy * 0.15;
    } else {
      this.camY = this.targetCamY;
    }
  }

  /**
   * 移动建筑方框 (对应原版 al() 方法中的输入处理)
   * 返回是否需要重绘
   */
  moveBox(dirX: number, dirY: number): void {
    if (!this.mapData) return;
    const mapWPx = this.mapData.width * TILE_SIZE;
    const mapHPx = this.mapData.height * TILE_SIZE;

    this.boxX = Math.max(0, Math.min(this.boxX + dirX * TILE_SIZE, mapWPx - TILE_SIZE));
    this.boxY = Math.max(0, Math.min(this.boxY + dirY * TILE_SIZE, mapHPx - TILE_SIZE));

    this.updateCameraTarget();
  }

  // ============================================================
  // 兼容接口
  // ============================================================

  getTile(x: number, y: number): number {
    if (!this.mapData) return 0;
    const idx = y * this.mapData.width + x;
    return this.mapData.tileLayer[idx] ?? 0;
  }

  /**
   * 获取路径瓦片值 (F1164)
   * 关卡0: 使用 tileLayer (B1160) 作为路径 (原版 aN==0 时回退)
   * 其他关卡: 使用 pathLayer (F1164)
   */
  getPathTile(x: number, y: number): number {
    if (!this.mapData) return PATH_EMPTY;
    if (x < 0 || y < 0 || x >= this.mapData.width || y >= this.mapData.height) return PATH_EMPTY;
    const idx = y * this.mapData.width + x;
    
    if (this.useTileAsPath()) {
      // 关卡0: 使用 tileLayer 值作为路径
      // 原版中 tileLayer 的值 1,2,3,5,6,15 是路径标记
      const tileVal = this.mapData.tileLayer[idx] ?? 0;
      // 只返回路径相关值 (1,2,3,5,6,15), 其他视为空
      if (tileVal === 1 || tileVal === 2 || tileVal === 3 || 
          tileVal === 5 || tileVal === 6 || tileVal === 15) {
        return tileVal;
      }
      return PATH_EMPTY;
    }
    
    return this.mapData.pathLayer[idx] ?? PATH_EMPTY;
  }

  /**
   * 是否为敌人可行走路径 (非零路径瓦片)
   * 关卡0: 使用 tileLayer 值作为路径 (原版 aN==0 时回退到 B1160)
   * 其他关卡: 使用 pathLayer (F1164)
   */
  isWalkable(x: number, y: number): boolean {
    return this.getPathTile(x, y) !== PATH_EMPTY;
  }

  /**
   * 检查当前关卡是否使用 tileLayer 作为路径数据 (关卡0)
   * 原版: 当 aN==0 (无mapsp加载) 时, 使用 B1160 (tileLayer) 作为路径
   */
  private useTileAsPath(): boolean {
    if (!this.mapData) return false;
    // 检查 pathLayer 是否全为零 (关卡0没有mapsp数据)
    const { pathLayer } = this.mapData;
    if (!pathLayer || pathLayer.length === 0) return true;
    // 快速检查: 如果前100个元素都是0, 很可能没有路径数据
    let hasPathData = false;
    for (let i = 0; i < Math.min(pathLayer.length, 200); i++) {
      if (pathLayer[i] !== 0) { hasPathData = true; break; }
    }
    return !hasPathData;
  }

  /**
   * 是否为入口点 (敌人生成位置)
   */
  isEntryPoint(x: number, y: number): boolean {
    const v = this.getPathTile(x, y);
    return v === PATH_ENTRY_1 || v === PATH_ENTRY_2;
  }

  /**
   * 是否为出口点 (敌人终点)
   */
  isExitPoint(x: number, y: number): boolean {
    const v = this.getPathTile(x, y);
    return v === PATH_EXIT_1 || v === PATH_EXIT_2;
  }

  get width(): number {
    return this.mapData?.width ?? 0;
  }

  get height(): number {
    return this.mapData?.height ?? 0;
  }

  get mapWidthPx(): number {
    return (this.mapData?.width ?? 0) * TILE_SIZE;
  }

  get mapHeightPx(): number {
    return (this.mapData?.height ?? 0) * TILE_SIZE;
  }

  get cameraX(): number { return this.camX; }
  get cameraY(): number { return this.camY; }
  get buildingBoxX(): number { return this.boxX; }
  get buildingBoxY(): number { return this.boxY; }

  /**
   * 获取建筑方框的瓦片坐标
   * 对应原版 bN/16, bO/16
   */
  getBuildingBoxTile(): { tx: number; ty: number } {
    return {
      tx: Math.floor(this.boxX / TILE_SIZE),
      ty: Math.floor(this.boxY / TILE_SIZE),
    };
  }

  /**
   * 直接设置建筑方框位置 (触屏点击地图时使用)
   * 对应原版 al() 中 bN/bO 赋值
   */
  setBuildingBox(tileX: number, tileY: number): void {
    if (!this.mapData) return;
    this.boxX = Math.max(0, Math.min(tileX * TILE_SIZE, this.mapData.width * TILE_SIZE - TILE_SIZE));
    this.boxY = Math.max(0, Math.min(tileY * TILE_SIZE, this.mapData.height * TILE_SIZE - TILE_SIZE));
    this.updateCameraTarget();
  }

  getSpawnPoints(): { x: number; y: number; type: number }[] {
    return this.mapData?.spawnPoints ?? [];
  }

  /**
   * 将屏幕坐标转换为地图瓦片坐标
   */
  screenToTile(screenX: number, screenY: number): { tx: number; ty: number } {
    const mapX = screenX + this.camX;
    const mapY = (screenY - MAP_TOP_BAR_H) + this.camY;
    return {
      tx: Math.floor(mapX / TILE_SIZE),
      ty: Math.floor(mapY / TILE_SIZE),
    };
  }

  /**
   * 将地图瓦片坐标转换为屏幕坐标
   */
  tileToScreen(tx: number, ty: number): { x: number; y: number } {
    return {
      x: tx * TILE_SIZE - this.camX,
      y: ty * TILE_SIZE - this.camY + MAP_TOP_BAR_H,
    };
  }

  // ============================================================
  // 渲染 - 100%还原原版 a.java 的地图渲染逻辑
  // ============================================================

  /**
   * 渲染地图 (只渲染可见区域)
   * 对应原版 ak() 方法 + w() 方法
   */
  render(): void {
    if (!this.mapData) return;

    const { width, height, tileLayer, flipLayer, pathLayer, pathFlipLayer } = this.mapData;
    const TILES_PER_ROW = 4; // 原版 map 图集固定为 4 列

    // 计算可见瓦片范围
    const startCol = Math.floor(this.camX / TILE_SIZE);
    const startRow = Math.floor(this.camY / TILE_SIZE);
    const endCol = Math.min(width, startCol + Math.ceil(MAP_VIEW_W / TILE_SIZE) + 1);
    const endRow = Math.min(height, startRow + Math.ceil(MAP_VIEW_H / TILE_SIZE) + 1);

    const vctx = this.renderer.virtualContext;

    // 设置裁剪区域 (地图可视区域)
    vctx.save();
    vctx.beginPath();
    vctx.rect(0, MAP_TOP_BAR_H, MAP_VIEW_W, MAP_VIEW_H);
    vctx.clip();

    vctx.imageSmoothingEnabled = false;

    // 渲染背景瓦片层 (B1160 + C1161)
    for (let y = startRow; y < endRow; y++) {
      for (let x = startCol; x < endCol; x++) {
        const idx = y * width + x;
        const tileIdx = tileLayer[idx] & 0xFF;
        const flipMode = flipLayer[idx] ?? 0;
        const px = x * TILE_SIZE - this.camX;
        const py = y * TILE_SIZE - this.camY + MAP_TOP_BAR_H;

        if (this.currentAtlas) {
          this.drawTileWithFlip(this.currentAtlas, tileIdx, flipMode, px, py, TILES_PER_ROW);
        } else {
          this.renderTileByColor(tileIdx, px, py);
        }
      }
    }

    // 渲染路径层 (F1164 + G1165) - 叠加在背景层之上
    if (pathLayer && this.currentAtlas) {
      for (let y = startRow; y < endRow; y++) {
        for (let x = startCol; x < endCol; x++) {
          const idx = y * width + x;
          const pathIdx = pathLayer[idx] & 0xFF;
          if (pathIdx === 0) continue; // 空路径不绘制

          const pathFlip = pathFlipLayer?.[idx] ?? 0;
          const px = x * TILE_SIZE - this.camX;
          const py = y * TILE_SIZE - this.camY + MAP_TOP_BAR_H;

          // 路径层使用相同的图集, 瓦片索引偏移到路径区域
          // 原版使用 bM = n1076[level] + 33 作为路径图集
          // H5简化: 路径瓦片使用同一图集的不同区域
          this.drawTileWithFlip(this.currentAtlas, pathIdx, pathFlip, px, py, TILES_PER_ROW);
        }
      }
    }

    vctx.restore();
  }

  /**
   * 绘制建筑方框 (对应原版在地图上绘制的方框)
   */
  renderBuildingBox(): void {
    const px = this.boxX - this.camX;
    const py = this.boxY - this.camY + MAP_TOP_BAR_H;

    // 只在可见范围内绘制
    if (px < -TILE_SIZE || px > MAP_VIEW_W || py < MAP_TOP_BAR_H - TILE_SIZE || py > MAP_TOP_BAR_H + MAP_VIEW_H) return;

    const vctx = this.renderer.virtualContext;
    vctx.save();
    vctx.strokeStyle = '#FFD700';
    vctx.lineWidth = 1;
    vctx.strokeRect(px, py, TILE_SIZE, TILE_SIZE);
    // 内部半透明填充
    vctx.fillStyle = 'rgba(255, 215, 0, 0.15)';
    vctx.fillRect(px, py, TILE_SIZE, TILE_SIZE);
    vctx.restore();
  }

  /**
   * 绘制瓦片 (带翻转/旋转模式)
   * 100%还原原版 a.java 的 a(Image, int, int, int, int, int, int, int) 方法
   */
  private drawTileWithFlip(
    img: HTMLImageElement,
    tileIdx: number,
    flipMode: number,
    dx: number, dy: number,
    tilesPerRow: number,
  ): void {
    const sx = (tileIdx & (tilesPerRow - 1)) * TILE_SIZE;
    const sy = Math.floor(tileIdx / tilesPerRow) * TILE_SIZE;

    const vctx = this.renderer.virtualContext;
    vctx.save();
    vctx.imageSmoothingEnabled = false;

    switch (flipMode) {
      case 0:
        vctx.drawImage(img, sx, sy, TILE_SIZE, TILE_SIZE, dx, dy, TILE_SIZE, TILE_SIZE);
        break;
      case 1:
        vctx.translate(dx + TILE_SIZE, dy);
        vctx.scale(-1, 1);
        vctx.drawImage(img, sx, sy, TILE_SIZE, TILE_SIZE, 0, 0, TILE_SIZE, TILE_SIZE);
        break;
      case 2:
        vctx.translate(dx, dy + TILE_SIZE);
        vctx.scale(1, -1);
        vctx.drawImage(img, sx, sy, TILE_SIZE, TILE_SIZE, 0, 0, TILE_SIZE, TILE_SIZE);
        break;
      case 3:
        vctx.translate(dx + TILE_SIZE, dy + TILE_SIZE);
        vctx.scale(-1, -1);
        vctx.drawImage(img, sx, sy, TILE_SIZE, TILE_SIZE, 0, 0, TILE_SIZE, TILE_SIZE);
        break;
      case 4:
        vctx.translate(dx + TILE_SIZE, dy);
        vctx.scale(-1, 1);
        vctx.rotate(Math.PI / 2);
        vctx.drawImage(img, sx, sy, TILE_SIZE, TILE_SIZE, 0, 0, TILE_SIZE, TILE_SIZE);
        break;
      case 5:
        vctx.translate(dx, dy);
        vctx.rotate(Math.PI / 2);
        vctx.scale(-1, 1);
        vctx.drawImage(img, sx, sy, TILE_SIZE, TILE_SIZE, 0, 0, TILE_SIZE, TILE_SIZE);
        break;
      case 6:
        vctx.translate(dx, dy + TILE_SIZE);
        vctx.rotate(-Math.PI / 2);
        vctx.drawImage(img, sx, sy, TILE_SIZE, TILE_SIZE, 0, 0, TILE_SIZE, TILE_SIZE);
        break;
      case 7:
        vctx.translate(dx + TILE_SIZE, dy + TILE_SIZE);
        vctx.rotate(Math.PI);
        vctx.drawImage(img, sx, sy, TILE_SIZE, TILE_SIZE, 0, 0, TILE_SIZE, TILE_SIZE);
        break;
      default:
        vctx.drawImage(img, sx, sy, TILE_SIZE, TILE_SIZE, dx, dy, TILE_SIZE, TILE_SIZE);
        break;
    }

    vctx.restore();
  }

  /**
   * 用颜色渲染瓦片 (无图集时的备用方案)
   */
  private renderTileByColor(tileIdx: number, px: number, py: number): void {
    const TILE_COLORS: Record<number, number> = {
      0: 0x2a4a1a, 1: 0x8a6a3a, 2: 0x4a5a3a, 3: 0x8a7a4a,
      4: 0x3a5a1a, 5: 0x7a6a4a, 6: 0x6a5a3a, 7: 0x5a4a2a,
      8: 0x5a7a3a, 9: 0x4a6a2a, 10: 0x8a7a4a, 11: 0x9a8a5a,
      12: 0x5a4a2a, 13: 0x6a4a2a, 14: 0x7a5a3a, 15: 0x6a3a2a,
    };
    const color = TILE_COLORS[tileIdx] ?? 0x4a6a2a;
    this.renderer.setColor(color);
    this.renderer.fillRect(px, py, TILE_SIZE, TILE_SIZE);
  }

  /**
   * 渲染路径高亮 (建造模式)
   */
  renderPathOverlay(): void {
    if (!this.mapData) return;
    const { width, height, pathLayer } = this.mapData;

    const startCol = Math.floor(this.camX / TILE_SIZE);
    const startRow = Math.floor(this.camY / TILE_SIZE);
    const endCol = Math.min(width, startCol + Math.ceil(MAP_VIEW_W / TILE_SIZE) + 1);
    const endRow = Math.min(height, startRow + Math.ceil(MAP_VIEW_H / TILE_SIZE) + 1);

    const vctx = this.renderer.virtualContext;
    vctx.save();
    vctx.beginPath();
    vctx.rect(0, MAP_TOP_BAR_H, MAP_VIEW_W, MAP_VIEW_H);
    vctx.clip();

    for (let y = startRow; y < endRow; y++) {
      for (let x = startCol; x < endCol; x++) {
        const val = pathLayer[y * width + x];
        if (val !== PATH_EMPTY) {
          const px = x * TILE_SIZE - this.camX;
          const py = y * TILE_SIZE - this.camY + MAP_TOP_BAR_H;
          vctx.strokeStyle = 'rgba(255, 255, 0, 0.3)';
          vctx.lineWidth = 1;
          vctx.strokeRect(px, py, TILE_SIZE, TILE_SIZE);
        }
      }
    }

    vctx.restore();
  }

  /**
   * 检查瓦片是否可建造塔
   * 原版 b(int n, int n2) 方法: 检查 E1163 和 D1162 属性
   * H5简化: 不可建造在路径瓦片上, 不可建造在已有塔位置
   * 路径瓦片: pathLayer值非0 或 (关卡0) tileLayer值为1,2,3,5,6,15
   */
  isBuildable(x: number, y: number): boolean {
    if (!this.mapData) return false;
    if (x < 0 || y < 0 || x >= this.mapData.width || y >= this.mapData.height) return false;
    // 不能建造在路径上
    if (this.isWalkable(x, y)) return false;
    return true;
  }

  // ====== 旧接口兼容 (已废弃) ======
  setTileset(_img: HTMLImageElement, _tilesPerRow: number): void {}
  getPathType(x: number, y: number): number { return this.getPathTile(x, y); }
}
