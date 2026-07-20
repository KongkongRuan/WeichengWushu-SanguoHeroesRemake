/**
 * 城墙渲染系统 - 我方/敌方城池部件拼装渲染
 * 100%还原原版 a.java m(int x, int y, int which) 方法 (行23458-23533)
 *
 * 原版逻辑:
 *   - /s 图集 (H5: s_0_105x70.png, 资源表 a1014[30]="/s")
 *   - CASTLE_RECTS_E1058 (e1058): 10个部件矩形 (x,y,w,h)
 *   - CASTLE_PARTS_F1063 (f1063): 每3字节=(部件id, dx, dy)
 *     [0]=我城12件, [1]=敌城10件 (CASTLE_PART_COUNT_J1064 / j1064)
 *   - 我城画在我城锚点(which=0, aK/aL), 敌城画在敌城锚点(which=1, aI/aJ)
 *   - 锚点 = 瓦片坐标*16, 随相机偏移 (与地图瓦片同一坐标变换)
 *
 * H5简化 (注释标注):
 *   - 不绘制我城城门开启动画 (原版行23465-23504: w1111/bv/k(), 为特效)
 *
 * 任务B: 我城部件接 b1059 科技过滤 (原版行23509-23514: b1059[id] || which!=0)
 *   - 初始可见 = c1061 (原版 aj() 行14114-14126)
 *   - 科技建筑建成 → b1059[h1060[i]]=true → 对应部件长出
 */
import { Renderer } from './Renderer';
import { MapData } from './MapData';
import { SpriteLoader } from './SpriteLoader';
import {
  MAP_TOP_BAR_H,
  MAP_VIEW_H,
  MAP_VIEW_W,
  CASTLE_RECTS_E1058,
  CASTLE_PARTS_F1063,
  CASTLE_PART_COUNT_J1064,
} from '../data/gameData';

export class CastleRenderer {
  private renderer: Renderer;
  private mapData: MapData;
  private spriteLoader: SpriteLoader | null = null;
  // 我城部件可见表 (原版 b1059, 由 BuildBarSystem.castlePartFilter() 提供)
  private ourPartFilter: boolean[] | null = null;

  constructor(renderer: Renderer, mapData: MapData) {
    this.renderer = renderer;
    this.mapData = mapData;
  }

  setSpriteLoader(loader: SpriteLoader): void {
    this.spriteLoader = loader;
  }

  /**
   * 设置我城部件可见过滤 (对应原版 m() 行23514: b1059[部件id] 为true才画)
   */
  setOurPartFilter(filter: boolean[] | null): void {
    this.ourPartFilter = filter;
  }

  /**
   * 获取 /s 城墙部件图集
   */
  private getAtlas(): HTMLImageElement | null {
    if (!this.spriteLoader) return null;
    return this.spriteLoader.getByPrefix('s', 0);
  }

  /**
   * 渲染双方城池 (对应原版 ak() 行14443-14448:
   *   m(aK, aL, 0) 我城; m(aI, aJ, 1) 敌城)
   */
  render(): void {
    const our = this.mapData.ourCastlePos;
    const enemy = this.mapData.enemyCastlePos;
    this.renderCastle(our.x, our.y, 0);
    this.renderCastle(enemy.x, enemy.y, 1);
  }

  /**
   * 渲染单个城池 (对应原版 m(int var1, int var2, int var3))
   * @param anchorX 锚点X (像素, 瓦片左上)
   * @param anchorY 锚点Y
   * @param which 0=我城 1=敌城
   */
  private renderCastle(anchorX: number, anchorY: number, which: number): void {
    const camX = this.mapData.cameraX;
    const camY = this.mapData.cameraY;
    const atlas = this.getAtlas();
    const parts = CASTLE_PARTS_F1063[which];
    const count = CASTLE_PART_COUNT_J1064[which] ?? 0;

    const vctx = this.renderer.virtualContext;
    vctx.save();
    vctx.beginPath();
    vctx.rect(0, MAP_TOP_BAR_H, MAP_VIEW_W, MAP_VIEW_H);
    vctx.clip();
    vctx.imageSmoothingEnabled = false;

    for (let i = 0; i < count; i++) {
      const spriteId = parts[i * 3];
      // 原版行23509-23514: 我城(which==0)部件需 b1059[spriteId]==true 才画, 敌城全画
      if (which === 0 && this.ourPartFilter && !this.ourPartFilter[spriteId]) continue;
      const rect = CASTLE_RECTS_E1058[spriteId];
      if (!rect) continue;
      // 原版: dx = f1063[which][i*3+1] + var1 - bP
      //       dy = f1063[which][i*3+2] + var2 + 13 - bQ
      const dx = parts[i * 3 + 1] + anchorX - camX;
      const dy = parts[i * 3 + 2] + anchorY + MAP_TOP_BAR_H - camY;

      if (atlas) {
        vctx.drawImage(
          atlas,
          rect[0], rect[1], rect[2], rect[3],
          Math.floor(dx), Math.floor(dy), rect[2], rect[3],
        );
      } else {
        // 图集缺失时回退: 灰色部件块
        this.renderer.setColor(0x8a8a7a);
        this.renderer.fillRect(dx, dy, rect[2], rect[3]);
        this.renderer.setColor(0x5a5a4a);
        this.renderer.drawRect(dx, dy, rect[2], rect[3]);
      }
    }

    vctx.restore();
  }
}
