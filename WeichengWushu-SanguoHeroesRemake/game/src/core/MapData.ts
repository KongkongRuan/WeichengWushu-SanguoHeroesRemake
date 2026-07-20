/**
 * 地图数据系统 - 加载和渲染地图
 * 从 mapdatalv 和 mapsp 文件提取的地图数据
 */
import { Renderer } from './Renderer';
import { TILE_SIZE } from '../data/gameData';

export interface LevelMapData {
  level: number;
  width: number;
  height: number;
  tileLayer: number[];     // 地形瓦片 (Layer 0)
  pathLayer: number[];     // 路径/可建造层 (Layer 1)
  terrainLayer?: number[]; // 基础地形 (mapdata)
}

export interface SpawnData {
  level: number;
  width: number;
  height: number;
  spawnLayer: number[];    // 生成点层
  flagLayer: number[];     // 标记层
  spawnPoints: { x: number; y: number; type: number }[];
}

// 路径层值含义
export const PATH_EMPTY = 0;       // 空地
export const PATH_WALKABLE = 1;   // 敌人可行走路径
export const PATH_BUILDABLE = 2;  // 可建造塔的位置
export const PATH_SPECIAL = 4;    // 特殊位置

// 生成点类型
export const SPAWN_ENTRY_1 = 1;   // 入口标记1
export const SPAWN_ENTRY_2 = 2;   // 入口标记2
export const SPAWN_WAYPOINT = 3;  // 路径点
export const SPAWN_EXIT_1 = 5;    // 出口标记1
export const SPAWN_EXIT_2 = 6;    // 出口标记2

export class MapData {
  private renderer: Renderer;
  private mapData: LevelMapData | null = null;
  private spawnData: SpawnData | null = null;
  private tilesetImage: HTMLImageElement | null = null;
  private tilesPerRow: number = 0;

  constructor(renderer: Renderer) {
    this.renderer = renderer;
  }

  /**
   * 加载关卡地图数据
   */
  async loadLevel(level: number): Promise<void> {
    try {
      const mapResponse = await fetch(`./maps/level${level}.json`);
      this.mapData = await mapResponse.json() as LevelMapData;

      if (level > 0) {
        const spawnResponse = await fetch(`./maps/spawns${level}.json`);
        this.spawnData = await spawnResponse.json() as SpawnData;
      }
    } catch (e) {
      console.error('Failed to load map data:', e);
      // 生成默认地图
      this.mapData = this.createDefaultMap(level);
    }
  }

  /**
   * 创建默认地图 (当JSON文件不存在时)
   */
  private createDefaultMap(level: number): LevelMapData {
    const w = 15;
    const h = 20;
    const tiles = w * h;
    const tileLayer = new Array(tiles).fill(9);
    const pathLayer = new Array(tiles).fill(0);
    // 创建一条简单路径
    for (let y = 0; y < h; y++) {
      pathLayer[y * w + 7] = PATH_WALKABLE;
    }
    return { level, width: w, height: h, tileLayer, pathLayer };
  }

  /**
   * 设置瓦片图集
   */
  setTileset(img: HTMLImageElement, tilesPerRow: number): void {
    this.tilesetImage = img;
    this.tilesPerRow = tilesPerRow;
  }

  /**
   * 获取瓦片类型
   */
  getTile(x: number, y: number): number {
    if (!this.mapData) return 0;
    const idx = y * this.mapData.width + x;
    return this.mapData.tileLayer[idx] ?? 0;
  }

  /**
   * 获取路径类型
   */
  getPathType(x: number, y: number): number {
    if (!this.mapData) return PATH_EMPTY;
    const idx = y * this.mapData.width + x;
    return this.mapData.pathLayer[idx] ?? PATH_EMPTY;
  }

  /**
   * 检查是否可建造
   */
  isBuildable(x: number, y: number): boolean {
    return this.getPathType(x, y) === PATH_BUILDABLE;
  }

  /**
   * 检查是否可行走
   */
  isWalkable(x: number, y: number): boolean {
    const p = this.getPathType(x, y);
    return p === PATH_WALKABLE || p === PATH_SPECIAL;
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

  /**
   * 获取生成点列表
   */
  getSpawnPoints(): { x: number; y: number; type: number }[] {
    return this.spawnData?.spawnPoints ?? [];
  }

  /**
   * 渲染地图
   * offsetX/Y: 地图在屏幕上的偏移
   */
  render(offsetX: number = 0, offsetY: number = 0): void {
    if (!this.mapData) return;

    const { width, height, tileLayer } = this.mapData;

    for (let y = 0; y < height; y++) {
      for (let x = 0; x < width; x++) {
        const tileIdx = tileLayer[y * width + x];
        const px = offsetX + x * TILE_SIZE;
        const py = offsetY + y * TILE_SIZE;

        if (this.tilesetImage && this.tilesPerRow > 0) {
          // 使用瓦片图集渲染
          const sx = (tileIdx % this.tilesPerRow) * TILE_SIZE;
          const sy = Math.floor(tileIdx / this.tilesPerRow) * TILE_SIZE;
          this.renderer.drawImageRegion(
            this.tilesetImage,
            sx, sy, TILE_SIZE, TILE_SIZE,
            px, py, TILE_SIZE, TILE_SIZE,
          );
        } else {
          // 无瓦片图集时使用颜色渲染
          this.renderTileByColor(tileIdx, px, py);
        }
      }
    }
  }

  /**
   * 用颜色渲染瓦片 (无图集时的备用方案)
   */
  private renderTileByColor(tileIdx: number, px: number, py: number): void {
    let color = 0x6396370; // 默认背景色
    switch (tileIdx) {
      case 9: color = 0x4a6a2a; break;   // 草地
      case 8: color = 0x5a7a3a; break;   // 深草地
      case 10: color = 0x8a7a4a; break;  // 泥土
      case 11: color = 0x9a8a5a; break;   // 浅泥土
      case 4: color = 0x3a5a1a; break;    // 树木
      case 12: color = 0x5a4a2a; break;   // 木板
      case 5: color = 0x7a6a4a; break;    // 石头
      case 0: color = 0x2a4a1a; break;    // 深色
      case 2: color = 0x4a5a3a; break;    // 浅草
      default: break;
    }
    this.renderer.setColor(color);
    this.renderer.fillRect(px, py, TILE_SIZE, TILE_SIZE);
  }

  /**
   * 渲染路径高亮 (建造模式)
   */
  renderPathOverlay(offsetX: number = 0, offsetY: number = 0): void {
    if (!this.mapData) return;
    const { width, height, pathLayer } = this.mapData;

    for (let y = 0; y < height; y++) {
      for (let x = 0; x < width; x++) {
        const val = pathLayer[y * width + x];
        const px = offsetX + x * TILE_SIZE;
        const py = offsetY + y * TILE_SIZE;
        if (val === PATH_BUILDABLE) {
          this.renderer.setColor(0xFF0000);
          this.renderer.drawRect(px, py, TILE_SIZE, TILE_SIZE);
        }
      }
    }
  }
}
