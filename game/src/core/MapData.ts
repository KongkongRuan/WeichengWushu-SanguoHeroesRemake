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
 *     Layer 0 (F1164): pathLayer  - mapsp 叠加装饰瓦片索引 (0=无装饰)
 *     Layer 1 (G1165): pathFlipLayer - 装饰瓦片翻转模式 (SpriteTransform 0-7)
 *     Layer 2-3: 重复数据 (未使用)
 *
 *   mapdata 文件 (1层):
 *     terrainLayer (E1163): 属性层, 每字节语义:
 *       0/2/4/6: 路径格, 方向=值>>1 (0上1右2下3左, 配合 DIRECTIONS_K1081)
 *       奇数:    运行时被敌人占用的路径格 (敌人进入时+1, 离开-1,
 *                见原版 a(int,int,boolean) 行11058-11085)
 *       8: 可建造草地; 9: 障碍/装饰; 10: 敌城格(出生侧); 11: 我城格(终点); >=12: 塔占用
 *
 * 原版渲染 (a.java 行22260+, ak()方法):
 *   - 相机系统: bA/bC=当前相机XY, bP/bQ=目标相机XY (跟随建筑方框)
 *   - 可视区域: 240x276 像素 (y偏移13px)
 *   - 只渲染可见区域的瓦片 (19列 x 18行)
 *   - mapsp 装饰层叠加在背景层之上 (w(int,int,int) 行25959-26143)
 *
 * 原版相机跟随 (a.java an()方法):
 *   - 建筑方框 bN/bO 在地图中移动
 *   - 当方框接近屏幕边缘时, 相机跟随移动
 *   - 边缘阈值: X=112px, Y=130px
 */
import { Renderer } from './Renderer';
import { SpriteLoader } from './SpriteLoader';
import {
  TILE_SIZE,
  MAP_TOP_BAR_H,
  MAP_VIEW_H,
  MAP_VIEW_W,
  TILESET_MAP_M1075,
  OVERLAY_ATLAS_N1076,
  SPAWN_POINTS_B1069,
  CURSOR_CORNER_O1156,
} from '../data/gameData';

export interface LevelMapData {
  level: number;
  width: number;          // 地图宽度 (瓦片数, 对应 bG)
  height: number;         // 地图高度 (瓦片数, 对应 bH)
  tileLayer: number[];    // 背景瓦片索引 (对应 B1160)
  flipLayer: number[];    // 瓦片翻转模式 (对应 C1161, 值0-7)
  pathLayer: number[];    // mapsp 装饰瓦片索引 (对应 F1164, 0=无装饰)
  pathFlipLayer?: number[]; // 装饰瓦片翻转模式 (对应 G1165)
  terrainLayer?: number[];  // 属性层 (对应 E1163)
  spawnPoints?: { x: number; y: number; type: number }[];
}

// 属性层 (E1163) 值语义
export const TERRAIN_PATH_MAX = 7;   // <8 为路径格 (偶数值>>1=方向)
export const TERRAIN_BUILDABLE = 8;  // 可建造草地
export const TERRAIN_OBSTACLE = 9;   // 障碍/装饰
export const TERRAIN_ENEMY_CASTLE = 10; // 敌城格 (出生侧)
export const TERRAIN_OUR_CASTLE = 11;   // 我城格 (终点)

/**
 * 原版 m1075 数组: 关卡索引 → map图集索引 (gameData.TILESET_MAP_M1075)
 * bL = m1075[level] + 5 → map图集在 a1013 中的索引
 * H5中直接用 m1075[level] 作为 map0-6.png 的索引
 *
 * 原版 n1076 数组: 关卡索引 → mapsp 装饰图集 (gameData.OVERLAY_ATLAS_N1076)
 * bM = n1076[level] + 33 (原版 E() 行7253-7255), 资源表 a1014:
 *   33=/end 34=/sp0 35=/sp1 36=/sp2 37=/sp3
 *   即 H5 文件名 = sp{n1076[level]-1}_0_*.png (n1076>=1; 关卡0不绘制装饰层)
 */
export class MapData {
  private renderer: Renderer;
  private mapData: LevelMapData | null = null;
  private spriteLoader: SpriteLoader | null = null;

  // 原版 map 图集 (map0.png ~ map6.png)
  private mapAtlases: Map<number, HTMLImageElement> = new Map();
  private currentAtlas: HTMLImageElement | null = null;
  private currentLevel: number = 0;
  private currentMapLevel: number = 0;

  // 运行时属性层 (E1163, 占用标记会直接改在这里, 与原版一致)
  private terrain: number[] = [];

  // 城锚点 (像素坐标 = 瓦片坐标*16, 对应原版 aK/aL(我城) aI/aJ(敌城), N() 行8469-8516)
  private ourCastleX: number = 0;
  private ourCastleY: number = 0;
  private enemyCastleX: number = 0;
  private enemyCastleY: number = 0;

  // 相机系统 (对应原版 bA/bC/bP/bQ)
  private camX: number = 0;     // 当前相机X (像素)
  private camY: number = 0;     // 当前相机Y (像素)
  private targetCamX: number = 0; // 目标相机X (跟随建筑方框)
  private targetCamY: number = 0; // 目标相机Y

  // 建筑方框位置 (对应原版 bN/bO, 像素坐标)
  private boxX: number = 0;
  private boxY: number = 0;
  private cursorRenderFrame: number = 0;

  constructor(renderer: Renderer) {
    this.renderer = renderer;
  }

  setSpriteLoader(loader: SpriteLoader): void {
    this.spriteLoader = loader;
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
    this.currentMapLevel = mapLevel;

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

    // 初始化运行时属性层 (E1163 副本; 敌人占用标记 +1/-1 直接作用于副本)
    const src = this.mapData.terrainLayer;
    const total = this.mapData.width * this.mapData.height;
    if (src && src.length === total) {
      this.terrain = src.slice();
    } else {
      // 无属性层数据时全部视为障碍 (兜底, 正常不会发生)
      this.terrain = new Array(total).fill(TERRAIN_OBSTACLE);
    }

    // 扫描城锚点 (对应原版 N())
    this.scanCastleAnchors();

    // 设置当前关卡对应的 map 图集 (m1075)
    const atlasIdx = TILESET_MAP_M1075[mapLevel] ?? 0;
    this.currentAtlas = this.mapAtlases.get(atlasIdx) ?? null;

    // 初始化建筑方框位置 (对应原版 c1070)
    this.boxX = this.getBuildingBoxInit(mapLevel, 0);
    this.boxY = this.getBuildingBoxInit(mapLevel, 1);

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
    const terrainLayer = new Array(tiles).fill(TERRAIN_OBSTACLE);
    return { level, width: w, height: h, tileLayer, flipLayer, pathLayer, terrainLayer };
  }

  // ============================================================
  // 属性层 (E1163) API
  // ============================================================

  /**
   * 读取属性层原始字节 (含运行时占用标记)
   * 越界返回 9 (障碍)
   */
  getTerrain(tx: number, ty: number): number {
    if (!this.mapData) return TERRAIN_OBSTACLE;
    if (tx < 0 || ty < 0 || tx >= this.mapData.width || ty >= this.mapData.height) {
      return TERRAIN_OBSTACLE;
    }
    return this.terrain[ty * this.mapData.width + tx];
  }

  /**
   * 像素坐标 → 瓦片索引 (对应原版 a(int,int) 行10001: (y>>4)*bG + (x>>4))
   */
  private tileIndexAtPixel(px: number, py: number): number {
    const w = this.mapData?.width ?? 0;
    const h = this.mapData?.height ?? 0;
    let tx = px >> 4;
    let ty = py >> 4;
    // 原版 c(int,int) 行16925 会把像素坐标钳制在地图范围内 (bI/bJ)
    if (tx < 0) tx = 0;
    if (ty < 0) ty = 0;
    if (tx >= w) tx = w - 1;
    if (ty >= h) ty = h - 1;
    return ty * w + tx;
  }

  /**
   * 像素坐标处属性层值 (对应原版 c(int,int) 行16925 的钳制读取, 未>>1)
   */
  getTerrainAtPixel(px: number, py: number): number {
    if (this.terrain.length === 0) return TERRAIN_OBSTACLE;
    return this.terrain[this.tileIndexAtPixel(px, py)];
  }

  /**
   * 像素坐标处路径方向 (对应原版 c(int,int) 行16925: E1163[...] >> 1)
   * 非路径格时返回值 >=4, 调用方自行判断
   */
  getPathDirAtPixel(px: number, py: number): number {
    return this.getTerrainAtPixel(px, py) >> 1;
  }

  /**
   * 瓦片路径方向 (v<8 时返回 0-3, 否则 -1)
   */
  getPathDir(tx: number, ty: number): number {
    const v = this.getTerrain(tx, ty);
    return v < 8 ? v >> 1 : -1;
  }

  /**
   * 瓦片是否为空闲路径 (对应原版 b(int,int) 行16868:
   *   E1163[idx]&1==0 (未被占用) 且 E1163[idx]<8 (路径) 且 D1162[idx]<6)
   * H5简化: 塔只能建在 terrain==8 的草地上, 不会压占路径,
   *         故省略 D1162 塔效果层判断 (注释标注)
   */
  isPathFree(tx: number, ty: number): boolean {
    const v = this.getTerrain(tx, ty);
    return (v & 1) === 0 && v < 8;
  }

  /**
   * 像素坐标处是否为空闲路径 (对应原版 b(int,int) 行16868)
   */
  isPathFreeAtPixel(px: number, py: number): boolean {
    const v = this.getTerrainAtPixel(px, py);
    return (v & 1) === 0 && v < 8;
  }

  /**
   * 像素坐标处是否为我城格 (对应原版 c(int,int) 行17868: E1163==11)
   */
  isOurCastleAtPixel(px: number, py: number): boolean {
    return this.getTerrainAtPixel(px, py) === TERRAIN_OUR_CASTLE;
  }

  isOurCastle(tx: number, ty: number): boolean {
    return this.getTerrain(tx, ty) === TERRAIN_OUR_CASTLE;
  }

  isEnemyCastle(tx: number, ty: number): boolean {
    return this.getTerrain(tx, ty) === TERRAIN_ENEMY_CASTLE;
  }

  /**
   * 占用/释放路径格 (对应原版 a(int,int,boolean) 行11058-11085)
   * occupy=true: 仅当该格可进入(b()为真)才 +1
   * occupy=false: 仅当该格当前不可进入(已被占用)才 -1
   * 防止重复占用/重复释放
   */
  private setOccupiedAtPixel(px: number, py: number, occupy: boolean): void {
    const free = this.isPathFreeAtPixel(px, py);
    if (occupy) {
      if (!free) return;
    } else {
      if (free) return;
    }
    const idx = this.tileIndexAtPixel(px, py);
    this.terrain[idx] += occupy ? 1 : -1;
  }

  occupyTileAtPixel(px: number, py: number): void {
    this.setOccupiedAtPixel(px, py, true);
  }

  releaseTileAtPixel(px: number, py: number): void {
    this.setOccupiedAtPixel(px, py, false);
  }

  /** 标记建筑占用草地格；与敌人对路径格的奇偶占用标记分开处理。 */
  occupyBuildTile(tx: number, ty: number): void {
    if (!this.mapData || tx < 0 || ty < 0 || tx >= this.mapData.width || ty >= this.mapData.height) return;
    const idx = ty * this.mapData.width + tx;
    if (this.terrain[idx] === TERRAIN_BUILDABLE) this.terrain[idx] = 12;
  }

  /** 释放建筑占地，恢复为原版可建造草地值 8。 */
  releaseBuildTile(tx: number, ty: number): void {
    if (!this.mapData || tx < 0 || ty < 0 || tx >= this.mapData.width || ty >= this.mapData.height) return;
    const idx = ty * this.mapData.width + tx;
    if (this.terrain[idx] >= 12) this.terrain[idx] = TERRAIN_BUILDABLE;
  }

  /**
   * 扫描我城/敌城锚点 (对应原版 N() 行8469-8516)
   * 行优先扫描第一个 11(我城)/10(敌城) 格, 锚点 = 瓦片坐标*16 (像素)
   */
  scanCastleAnchors(): void {
    if (!this.mapData) return;
    const w = this.mapData.width;
    const total = this.terrain.length;
    for (let i = 0; i < total; i++) {
      if (this.terrain[i] === TERRAIN_OUR_CASTLE) {
        this.ourCastleX = (i % w) << 4;
        this.ourCastleY = ((i / w) | 0) << 4;
        break;
      }
    }
    for (let i = 0; i < total; i++) {
      if (this.terrain[i] === TERRAIN_ENEMY_CASTLE) {
        this.enemyCastleX = (i % w) << 4;
        this.enemyCastleY = ((i / w) | 0) << 4;
        break;
      }
    }
  }

  /** 我城锚点 (像素, 瓦片左上) */
  get ourCastlePos(): { x: number; y: number } {
    return { x: this.ourCastleX, y: this.ourCastleY };
  }

  /** 敌城锚点 (像素, 瓦片左上) */
  get enemyCastlePos(): { x: number; y: number } {
    return { x: this.enemyCastleX, y: this.enemyCastleY };
  }

  /**
   * 敌人出生点像素坐标 (原版 b1069[mapLevel], 16k+8 = 格中心)
   */
  getSpawnPixel(): { x: number; y: number } {
    const sp = SPAWN_POINTS_B1069[this.currentMapLevel] ?? SPAWN_POINTS_B1069[0];
    return { x: sp[0], y: sp[1] };
  }

  /**
   * 出生空闲检查的像素坐标 (原版 l(int) 行22826: b(b1069[aN][0], b1069[aN][1]+13)
   * 即检查出生点下方13px处的格子是否可进入)
   */
  getSpawnCheckPixel(): { x: number; y: number } {
    const sp = this.getSpawnPixel();
    return { x: sp.x, y: sp.y + 13 };
  }

  /**
   * 当前关卡的 mapsp 装饰图集 (n1076>=1 时为 sp{n1076-1}_0, 否则 null)
   * 关卡0 (aN==0) 原版不绘制装饰层 (w() 行26039: aN!=0 && var15!=0)
   */
  private getOverlayAtlas(): HTMLImageElement | null {
    if (this.currentMapLevel === 0) return null;
    const n = OVERLAY_ATLAS_N1076[this.currentMapLevel] ?? 0;
    if (n < 1 || !this.spriteLoader) return null;
    return this.spriteLoader.getByPrefix(`sp${n - 1}`, 0);
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
  updateCamera(elapsedMs: number = 100): void {
    // 以旧版 60Hz 下每帧 0.15 的手感为基准换算为时间插值，
    // 从而在 60/120/144Hz 上保持相同的镜头跟随速度。
    const factor = 1 - Math.pow(1 - 0.15, Math.max(0, elapsedMs) / (1000 / 60));
    const dx = this.targetCamX - this.camX;
    const dy = this.targetCamY - this.camY;
    if (Math.abs(dx) > 1) {
      this.camX += dx * factor;
    } else {
      this.camX = this.targetCamX;
    }
    if (Math.abs(dy) > 1) {
      this.camY += dy * factor;
    } else {
      this.camY = this.targetCamY;
    }
  }

  /** 注入原版 10Hz 的 a1019 视觉帧，渲染函数本身不再推进计数。 */
  setVisualFrame(frame: number): void {
    this.cursorRenderFrame = frame;
  }

  /**
   * 触屏/鼠标拖动地图：以屏幕像素增量平移相机，并立即限制在地图边界内。
   * 建造方框仍然可以通过方向键控制；拖动只改变观察位置，不会改变选位。
   */
  panCameraBy(dx: number, dy: number): void {
    if (!this.mapData) return;
    const mapWPx = this.mapData.width * TILE_SIZE;
    const mapHPx = this.mapData.height * TILE_SIZE;
    const maxX = Math.max(0, mapWPx - MAP_VIEW_W);
    const maxY = Math.max(0, mapHPx - MAP_VIEW_H);
    this.targetCamX = Math.max(0, Math.min(maxX, this.targetCamX + dx));
    this.targetCamY = Math.max(0, Math.min(maxY, this.targetCamY + dy));
    this.camX = Math.max(0, Math.min(maxX, this.camX + dx));
    this.camY = Math.max(0, Math.min(maxY, this.camY + dy));
  }

  /**
   * 移动建筑方框 (对应原版 al() 方法中的输入处理)
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
   * 对应原版 ak() 方法 (行14159-14453) + w() 方法 (行25959-26143)
   * H5直接按可见区绘制, 不使用原版的 256x304 离屏缓存
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

    // 渲染 mapsp 装饰层 (F1164 + G1165) - 叠加在背景层之上
    // 原版 w(): 仅当 aN!=0 (关卡0无mapsp) 且装饰值非0 时绘制
    // 图集 = sp{n1076[level]-1}_0 (bM = n1076+33, 见 E() 行7253-7255)
    const overlayAtlas = this.getOverlayAtlas();
    if (pathLayer && overlayAtlas) {
      for (let y = startRow; y < endRow; y++) {
        for (let x = startCol; x < endCol; x++) {
          const idx = y * width + x;
          const overlayIdx = pathLayer[idx] & 0xFF;
          if (overlayIdx === 0) continue; // 无装饰不绘制

          const overlayFlip = pathFlipLayer?.[idx] ?? 0;
          const px = x * TILE_SIZE - this.camX;
          const py = y * TILE_SIZE - this.camY + MAP_TOP_BAR_H;

          this.drawTileWithFlip(overlayAtlas, overlayIdx, overlayFlip, px, py, TILES_PER_ROW);
        }
      }
    }

    vctx.restore();
  }

  /**
   * 绘制默认建筑定位框 (原版 i(int×4), a.java:22126)。
   * ui_0 是四个 7×7 粉白角框；ui_1 是框上方上下跳动的红色标记。
   */
  renderBuildingBox(): void {
    const px = this.boxX - this.camX;
    const py = this.boxY - this.camY + MAP_TOP_BAR_H;

    // 只在可见范围内绘制
    if (px < -TILE_SIZE || px > MAP_VIEW_W || py < MAP_TOP_BAR_H - TILE_SIZE || py > MAP_TOP_BAR_H + MAP_VIEW_H) return;

    const corner = this.spriteLoader?.getUISprite(0);
    if (corner) {
      for (let k = 0; k < 4; k++) {
        const cx = px + (TILE_SIZE - 7) * CURSOR_CORNER_O1156[k][0];
        const cy = py + (TILE_SIZE - 7) * CURSOR_CORNER_O1156[k][1];
        this.renderer.drawSpriteTransform(corner, k * 7, 0, 7, 7, cx, cy, 0);
      }
    } else {
      // 资源加载失败时仍保留清晰的定位反馈。
      this.renderer.setColor(0xff6fae);
      this.renderer.drawRect(px, py, TILE_SIZE, TILE_SIZE);
    }

    const marker = this.spriteLoader?.getUISprite(1);
    if (marker) {
      // 原版使用 (a1019 & 1) << 1，每 100ms 在 0/2px 间跳动。
      const bounce = (this.cursorRenderFrame & 1) << 1;
      this.renderer.drawImage(
        marker,
        px + (TILE_SIZE >> 1) - (marker.width >> 1),
        py - TILE_SIZE - bounce,
      );
    }
  }

  /** 当前默认定位格是否属于可造区域。 */
  isBuildingBoxBuildable(): boolean {
    const { tx, ty } = this.getBuildingBoxTile();
    return this.isBuildableAt(tx, ty);
  }

  /**
   * 绘制瓦片 (带翻转/旋转模式)
   * 100%还原原版 a.java 的 a(Image, int, int, int, int, int, int, int) 方法 (行11211)
   * 源瓦片: srcX=(v&3)*16, srcY=(v>>2)*16; flipMode 对应 DirectGraphics 变换 a1001[0-7]
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
   * 改为基于属性层 (E1163): 高亮所有路径格 (v<8)
   */
  renderPathOverlay(): void {
    if (!this.mapData) return;
    const { width, height } = this.mapData;

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
        const val = this.terrain[y * width + x];
        if (val < 8) {
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
   * 原版 b(int n, int n2) 判定基于 E1163/D1162 属性
   * H5实现: 属性层 E1163 == 8 (可建造草地)
   */
  isBuildableAt(x: number, y: number): boolean {
    return this.getTerrain(x, y) === TERRAIN_BUILDABLE;
  }
}
