/**
 * 原版底部建造栏 + 城池科技面板 (任务A/B 核心)
 * 移植自原版 a.java:
 *   栏渲染   J() 行7856-8144 (经 H() 行7771 调用)
 *   图标行   a(int,int,int,int) 行10573-10670 (选中双框/锁定跳过徽标)
 *   条目图标 d(int×5) 行18876-18880 (ui_15 16x16帧, 帧号=条目id)
 *   塔名     g(int×3) 行21002-21006 (ui_18 35x11 图条, 按 塔id*11 取帧 —— 塔名是图片!)
 *   武系/文系 h(int×3) 行21715-21748 (ui_29 区域: 塔1-5=(17,0,17,10)文系, 6-10=(0,0,17,10)武系)
 *   描述文本 e(int×5) 行19357-19377 (b1015[id+2]); 提示消息 o → b1015[o+113] (a(int×5) 行10672-10682)
 *   打开栏   j(int) 行22347-22369; 输入 M() 行8273-8467; 滑入滑出 K() 行8146-8217
 *   科技购买 k(int) 行22492-22536 (a1056/b1059/e1105/g1057/g1065/h1060)
 *   打开入口 战斗确认键处理 行14538-14607 (塔→j(2..7), 可建格→j(0), 我城格→j(1))
 *
 * H5触屏适配 (注释标注的简化点):
 *   - 点击图标=选中, 再点同一图标=确认; 点明细区=确认; 点地图=关栏
 *   - 未解锁塔图标置灰 (原版不置灰, 仅选中时提示 b1015[115]; 按任务要求置灰)
 *   - 科技面板保留原版的建筑解锁和城堡部件状态
 *   - 明细区通过 TowerSystem 合成完整塔模型，与原版 a(type,level,...) 一致
 */
import { Renderer } from './Renderer';
import { SpriteLoader } from './SpriteLoader';
import type { Tower } from './Tower';
import {
  LOGICAL_WIDTH,
  BUILD_BAR_TOWER_ITEMS,
  BUILD_BAR_TECH_ITEMS,
  TOWER_COST_Q1100,
  TECH_COST_G1057,
  TECH_UNLOCK_G1065,
  TECH_CASTLE_PART_H1060,
  CASTLE_PART_INIT_C1061,
  TECH_ICON_I1062,
  ORIG_TOWER_DESC,
  ORIG_TECH_DESC,
  ORIG_ACTION_DESC,
  BAR_MESSAGES,
  CASTLE_RECTS_E1058,
  UI19_GOLD_SX,
  UI19_GOLD_W,
} from '../data/gameData';

/** 栏类别 (原版 aC): 0=建塔 1=科技装置 2=塔操作 */
export const BAR_CAT_BUILD = 0;
export const BAR_CAT_TECH = 1;
export const BAR_CAT_TOWER = 2;

/** 动作条目id (原版 d1053 项) */
const ACTION_UPGRADE = 16;
const ACTION_RESERVED = 17;
const ACTION_LOAD_GATE = 18;
const ACTION_RELEASE_GATE = 19;
const ACTION_DEMOLISH = 20;
const ACTION_CANCEL = 21;

/** 原版配色 (J() 中的十进制 setColor 值换算) */
const COLOR_BAR_BG = 0xfcffcd;    // 16580557 栏底米色
const COLOR_PLATE = 0xebd5ad;     // 15455661 名称条/面板线条
const COLOR_STRIP_BG = 0xda607b;  // 14311547 图标条底色
const COLOR_TEXT = 0x53678a;      // 描述/价格文字 (近原版 7438477 灰蓝, 在米色上可读)

/** 布局常量 (J() 行7856-7865: 栏底=289, au≤18, ax=(j<<1)+25=49) */
const BAR_BOTTOM = 289;
const AU_MAX = 18;   // 顶部图标条高 (原版 au 上限 18, K() case 1 行8164-8168)
const AV_MAX = 49;   // 主栏高 (原版 ax=(12<<1)+25, j(int) 行22356)
const BAR_SPEED = 9; // 滑出速度 (原版每逻辑帧+20@10FPS, H5@60fps 等比)

/** Game 侧宿主接口 (避免循环依赖, 全部回调注入) */
export interface BuildBarHost {
  /** 当前金币 (原版 bz) */
  getGold(): number;
  /** 尝试扣金 (原版 j(int) 行22439: 不足返回false) */
  trySpendGold(cost: number): boolean;
  /** 已建塔数 (原版 bt, k(int) 要求>0 才能建装置) */
  getTowerCount(): number;
  /** 选塔完成, 进入选位模式 (原版 aw=3 滑出收尾 → bF=1, K() case 3 行8204-8208) */
  enterPlacement(origTowerId: number): void;
  /** 升级选中塔 (动作16) */
  upgradeTower(tower: Tower): void;
  /** 拆除选中塔 (动作20) */
  demolishTower(tower: Tower): void;
  /** 断龙闸动作18/19。 */
  loadGate(tower: Tower): boolean;
  releaseGate(tower: Tower): boolean;
  getGateLoadCost(tower: Tower): number | null;
  /** 升级费用 (null=不可升级) */
  getUpgradeCost(tower: Tower): number | null;
  /** 拆除返还 (原版 b(int) 行15818: (建造费+升级投入)>>1) */
  getDemolishRefund(tower: Tower): number;
  /** 在明细区按原版素材层合成完整塔模型。 */
  renderTowerPreview(type: number, level: number, centerX: number, centerY: number): void;
  /** 装置建成回调 (提示/存档等) */
  onTechBuilt(techIndex: number): void;
}

export class BuildBarSystem {
  private renderer: Renderer;
  private spriteLoader: SpriteLoader | null = null;
  private host: BuildBarHost | null = null;

  // ===== 栏状态 (原版 aw/au/av/aC/aD/aE/aF/aB/aG/bw) =====
  private aw = 0;   // 0关闭 1打开中 2关闭中 3关闭中→选位
  private au = 0;   // 图标条当前高
  private av = 0;   // 主栏当前高
  private aC = 0;   // 类别
  private aD = 0;   // 选中项下标
  private aE = 0;   // 滚动窗口起点
  private aF = 8;   // 可见图标数 (原版 aF=min(8,项数), j(int) 行22350-22363)
  private aB = 0;   // 末项下标
  private aG = 0;   // 图标行起始X
  private bw = 0;   // 待建原版塔id
  private ay: Tower | null = null; // 选中的已建塔 (类别2)
  private o = -1;   // 提示消息id (-1=无, 原版 o 字段)

  // ===== 科技层状态 (原版 a1056/b1059/e1105) =====
  private techBuilt: boolean[] = new Array(5).fill(false);   // a1056: 装置已建
  private castleParts: boolean[] = [...CASTLE_PART_INIT_C1061]; // b1059: 城堡部件可见
  private towerUnlocked: boolean[] = [true, false, false, false, false, false, false, false, false, false, false]; // e1105: 塔解锁 (初始仅0=弓手塔, a.java:14128-14138)

  constructor(renderer: Renderer) {
    this.renderer = renderer;
  }

  setSpriteLoader(loader: SpriteLoader): void {
    this.spriteLoader = loader;
  }

  setHost(host: BuildBarHost): void {
    this.host = host;
  }

  // ============================================================
  // 状态查询
  // ============================================================

  /** 栏是否打开 (含滑入滑出动画中) */
  get isOpen(): boolean {
    return this.aw !== 0;
  }

  get category(): number {
    return this.aC;
  }

  /** 城堡部件可见过滤表 (原版 b1059, CastleRenderer 用) */
  castlePartFilter(): boolean[] {
    return this.castleParts;
  }

  /** 原版塔类型是否已解锁 (建塔门禁: 以原版科技建筑为准) */
  isTowerUnlocked(origType: number): boolean {
    if (origType < 0 || origType >= this.towerUnlocked.length) return true;
    return this.towerUnlocked[origType];
  }

  /** 原版塔类型的建造费 (q1100) */
  towerCost(origType: number): number {
    return TOWER_COST_Q1100[origType] ?? 0;
  }

  // ============================================================
  // 存档 (任务B-4: b1059/装置/塔解锁纳入存档)
  // ============================================================

  getSaveState(): { techBuilt: boolean[]; castleParts: boolean[]; towerUnlocked: boolean[] } {
    return {
      techBuilt: [...this.techBuilt],
      castleParts: [...this.castleParts],
      towerUnlocked: [...this.towerUnlocked],
    };
  }

  restoreSaveState(s: { techBuilt?: boolean[]; castleParts?: boolean[]; towerUnlocked?: boolean[] } | null | undefined): void {
    if (Array.isArray(s?.techBuilt) && s!.techBuilt!.length === 5) {
      this.techBuilt = [...s!.techBuilt!];
    }
    if (Array.isArray(s?.castleParts) && s!.castleParts!.length === 10) {
      this.castleParts = [...s!.castleParts!];
    }
    if (Array.isArray(s?.towerUnlocked) && s!.towerUnlocked!.length === 11) {
      this.towerUnlocked = [...s!.towerUnlocked!];
    }
  }

  /** 新战斗重置 (原版 aj() 行14095-14141: a1056全false, b1059=c1061, e1105仅[0]) */
  reset(): void {
    this.techBuilt = new Array(5).fill(false);
    this.castleParts = [...CASTLE_PART_INIT_C1061];
    this.towerUnlocked = [true, false, false, false, false, false, false, false, false, false, false];
    this.aw = 0;
    this.au = 0;
    this.av = 0;
    this.o = -1;
    this.ay = null;
  }

  /**
   * 原版金手指“获得全部科技”：五座科技建筑、城堡部件和全部塔一次解锁。
   * 由暂停菜单调用，保持与正常购买相同的状态层，避免只改 UI 不改门禁。
   */
  cheatUnlockAll(): void {
    this.techBuilt = new Array(5).fill(true);
    this.castleParts = new Array(10).fill(true);
    this.towerUnlocked = new Array(11).fill(true);
  }

  // ============================================================
  // 打开/关闭 (原版 j(int) 行22347 + K() 行8146)
  // ============================================================

  /**
   * 打开栏 (对应原版 j(int var1))
   * @param category 0建塔/1科技/2塔操作
   * @param tower 类别2时选中的塔 (原版 ay)
   */
  open(category: number, tower: Tower | null = null): void {
    this.aC = category;
    this.ay = tower;
    this.aD = 0;
    this.aE = 0;
    this.o = -1;
    const items = this.items();
    this.aB = items.length - 1;
    this.aF = 8;
    if (this.aB < this.aF) this.aF = this.aB + 1;
    // 原版: aG = (240 - aF*18)>>1 (注意绘制间距实为20, 原版即如此, 行22365-22367)
    this.aG = (LOGICAL_WIDTH - this.aF * 18) >> 1;
    this.aw = 1;
  }

  /** 请求关闭 (原版 aw=2 滑出) */
  close(): void {
    if (this.aw !== 0) this.aw = 2;
  }

  /** 栏条目表 (原版 d1053[aC]; 末位21=取消选择) */
  private items(): number[] {
    switch (this.aC) {
      case BAR_CAT_BUILD: return [...BUILD_BAR_TOWER_ITEMS, ACTION_CANCEL];
      case BAR_CAT_TECH: return [...BUILD_BAR_TECH_ITEMS, ACTION_CANCEL];
      default: {
        const tower = this.ay;
        if (!tower) return [ACTION_CANCEL];
        const levelAction = tower.level >= 6 ? ACTION_RESERVED : ACTION_UPGRADE;
        if (tower.type === 10 && tower.gateState === 0) {
          const gateAction = tower.gateLoaded ? ACTION_RELEASE_GATE : ACTION_LOAD_GATE;
          return [gateAction, levelAction, ACTION_DEMOLISH, ACTION_CANCEL];
        }
        if (tower.type === 10 && tower.gateState !== 0) {
          return [ACTION_DEMOLISH, ACTION_CANCEL];
        }
        return [levelAction, ACTION_DEMOLISH, ACTION_CANCEL];
      }
    }
  }

  /**
   * 滑入滑出动画 (原版 K() 行8146-8217)。
   * 原版每 100ms 推进一次；这里按真实时间插值，兼顾原版时长和现代屏幕的平滑度。
   */
  update(elapsedMs: number = 100): void {
    const scale = Math.max(0, elapsedMs) / 100;
    if (this.aw === 1) {
      // 打开: av→ax, au→18 (原版 case 1: av+=20/au+=20)
      this.av = Math.min(AV_MAX, this.av + BAR_SPEED * scale);
      this.au = Math.min(AU_MAX, this.au + 4 * scale);
    } else if (this.aw === 2 || this.aw === 3) {
      // 关闭: au/av→0 (原版 case 2/3: au-=20, av-=20)
      this.au = Math.max(0, this.au - 4 * scale);
      this.av = Math.max(0, this.av - BAR_SPEED * scale);
      if (this.au === 0 && this.av === 0) {
        const enterPlacement = this.aw === 3;
        this.aw = 0;
        if (enterPlacement) {
          // 原版 K() case 3: bF=1 + a(13) 进入建造选位
          this.host?.enterPlacement(this.bw);
        }
      }
    }
  }

  // ============================================================
  // 输入 (原版 M() 行8273-8467)
  // ============================================================

  /** 左移选择 (原版 M() 右键 aD+1, 方向相反无碍) */
  navigate(dir: number): void {
    if (this.aw === 0) return;
    this.o = -1; // 换项清除提示
    if (dir > 0) {
      this.aD++;
      if (this.aD > this.aB) {
        this.aD = 0;
        this.aE = 0;
      }
      // 原版行8308-8319: 超过窗口右端则滚动
      if (this.aD > this.aF - 1 && this.aD - this.aE > this.aF - 1) {
        this.aE++;
      }
    } else {
      this.aD--;
      if (this.aD < 0) {
        this.aD = this.aB;
        this.aE = Math.max(0, this.aD - (this.aF - 1));
      }
      if (this.aD < this.aB - (this.aF - 1) && this.aE > 0 && this.aD - this.aE < 0) {
        this.aE--;
      }
    }
  }

  /** 确认选中 (原版 M() 开火键处理 行8353-8466) */
  confirm(): void {
    if (this.aw === 0 || !this.host) return;
    const item = this.items()[this.aD];
    if (item === ACTION_CANCEL) {
      // 21=取消选择 (原版行8363-8365)
      this.aw = 2;
      return;
    }
    switch (this.aC) {
      case BAR_CAT_BUILD: {
        // 原版行8369-8393
        if (this.host.getTowerCount() >= 30) {
          this.o = 7; // 已经达到建筑上限
          return;
        }
        if (!this.towerUnlocked[item]) {
          this.o = 2; // 现在还不能建造这个建筑,需要修建相关的城池 (b1015[115])
          return;
        }
        if (this.host.getGold() < TOWER_COST_Q1100[item]) {
          this.o = 0; // 金不足
          return;
        }
        this.bw = item;
        this.aw = 3; // 滑出后进入选位
        break;
      }
      case BAR_CAT_TECH:
        this.purchaseTech(item - 11);
        break;
      case BAR_CAT_TOWER: {
        const tower = this.ay;
        if (!tower) {
          this.aw = 2;
          return;
        }
        if (item === ACTION_UPGRADE) {
          this.host.upgradeTower(tower);
          this.aw = 2;
        } else if (item === ACTION_LOAD_GATE) {
          if (this.host.loadGate(tower)) this.aw = 2;
          else this.o = 0;
        } else if (item === ACTION_RELEASE_GATE) {
          if (this.host.releaseGate(tower)) this.aw = 2;
        } else if (item === ACTION_DEMOLISH) {
          this.host.demolishTower(tower);
          this.aw = 2;
        }
        break;
      }
    }
  }

  /**
   * 科技建筑购买 (原版 k(int) 行22492-22536)
   * bt>0 才能建 → 未建 → 扣金成功 → a1056[i]=true, b1059[h1060[i]]=true,
   * e1105[g1065[i][0/1]]=true, u(h1060[i]) 城堡部件生长标记
   */
  private purchaseTech(i: number): void {
    if (!this.host) return;
    if (this.host.getTowerCount() < 1) {
      this.o = 1; // 需要至少修建一个塔 (b1015[114])
      return;
    }
    if (this.techBuilt[i]) {
      this.o = 3; // 该城池已经修建 (b1015[116])
      return;
    }
    if (!this.host.trySpendGold(TECH_COST_G1057[i])) {
      this.o = 0; // 金不足 (b1015[113])
      return;
    }
    this.techBuilt[i] = true;
    this.castleParts[TECH_CASTLE_PART_H1060[i]] = true;
    for (const t of TECH_UNLOCK_G1065[i]) {
      this.towerUnlocked[t] = true;
    }
    this.aw = 2; // 原版: 购买成功关栏
    this.host.onTechBuilt(i);
  }

  /**
   * 触屏点击 (H5适配; 返回是否消费了该点击)
   * 点图标=选中(再次点击=确认); 点明细区=确认; 点栏外地图=关栏
   */
  handleTap(x: number, y: number): boolean {
    if (this.aw === 0) return false;

    // 动画中也允许点击 (手感优先)
    const stripY = BAR_BOTTOM - this.au - this.av + 1 + 7; // 图标条Y (J(): var5+var166)
    const barTop = BAR_BOTTOM - this.au - this.av;

    if (y >= barTop && y < BAR_BOTTOM + 21) {
      // 图标条区域
      if (y >= stripY && y <= stripY + Math.max(this.au, 16) + 2) {
        for (let i = 0; i < this.aF; i++) {
          const ix = this.aG + i * 20 - 4;
          if (x >= ix && x <= ix + 24) {
            const idx = this.aE + i;
            if (idx > this.aB) return true;
            if (idx === this.aD) {
              this.confirm(); // 再点同一图标=确认
            } else {
              this.aD = idx;
              this.o = -1;
            }
            return true;
          }
        }
        return true;
      }
      // 明细区=确认
      this.confirm();
      return true;
    }

    // 点栏外地图: 关栏 (消费点击, 避免误选地图)
    this.close();
    return true;
  }

  // ============================================================
  // 渲染 (原版 J() 行7856-8144)
  // ============================================================

  render(): void {
    const r = this.renderer;
    const ui = (i: number) => this.spriteLoader?.getUISprite(i) ?? null;
    const vctx = r.virtualContext;

    const barTopY = BAR_BOTTOM - this.au - this.av; // 栏顶 (含图标条)
    // ---- 栏底米色底 (J() 行7866-7877: fillRect(0,289-au-av,240,au+21+av) 色16580557)
    // 原版 aw=0 时同样绘制 (底条常驻: au=av=0 → 289..310 米色条)
    r.setColor(COLOR_BAR_BG);
    r.fillRect(0, barTopY, LOGICAL_WIDTH, this.au + 21 + this.av);

    // ---- 顶边装饰: ui_6 居中 + ui_7 左端 (J() 行7878-7886, aw=0 也画)
    const ui6 = ui(6);
    if (ui6) r.drawImage(ui6, 120 - ui6.width, barTopY + 1);
    const ui7 = ui(7);
    if (ui7) r.drawImage(ui7, 0, barTopY + 1);

    // ---- 名称条底板 (aw=0 时也画: J() 行7887-7908 在 aw 判断之外)
    const var8 = BAR_BOTTOM - this.av + 8; // 名称条行Y (J(): var8=289-av+ui_6高+1)
    const ui5 = ui(5);
    if (ui5) r.drawImage(ui5, 0, var8);
    r.setColor(COLOR_PLATE);
    r.fillRect(86, var8 + 2, LOGICAL_WIDTH - 172, 9);

    if (this.aw === 0 || (this.au === 0 && this.av === 0)) return;

    // ---- 图标条 (au>0, J() 行7923-7955: 粉底 + ui_10 左右端 + 图标行)
    if (this.au > 0) {
      const stripY = barTopY + 1 + 7; // var5+var166 (var166=ui_6高7)
      vctx.save();
      vctx.beginPath();
      vctx.rect(0, stripY, LOGICAL_WIDTH, this.au);
      vctx.clip();
      r.setColor(COLOR_STRIP_BG);
      r.fillRect(0, stripY, LOGICAL_WIDTH, 18);
      const ui10 = ui(10);
      if (ui10) {
        // 原版 a(Image,int,int,int,boolean) 行11470: 左端 + 右端镜像
        r.drawImage(ui10, 0, stripY);
        r.drawImageFlipped(ui10, LOGICAL_WIDTH - ui10.width, stripY, true);
      }
      this.renderIconRow(stripY);
      vctx.restore();
    }

    // ---- 主栏 (av>0, J() 行7910-8135)
    if (this.av > 0) {
      // 左右面板 (J() 行7910-7922: c(57,y,183,av,0) 右面板 + c(0,y,57,av-3,1) 左面板)
      const panelY = var8 + 13;
      this.renderPanel(57, panelY, 183, this.av);
      this.renderPanel(0, panelY, 57, Math.max(0, this.av - 3));
      // 选中项明细
      this.renderDetail(var8, panelY);
    }
  }

  /** 图标行 (原版 a(int,int,int,int) 行10573-10670) */
  private renderIconRow(stripY: number): void {
    const r = this.renderer;
    const ui15 = this.spriteLoader?.getUISprite(15);
    if (!ui15) return;
    const items = this.items();
    const iconY = stripY + 1;

    for (let i = 0; i < this.aF; i++) {
      const idx = this.aE + i;
      if (idx > this.aB) break;
      const item = items[idx];
      const x = this.aG + i * 20;

      // 选中双框高亮 (原版行10589-10607: 色16580557 双drawRect)
      if (idx === this.aD) {
        r.setColor(COLOR_BAR_BG);
        r.drawRect(x - 3, iconY - 3, 21, 20);
        r.drawRect(x - 2, iconY - 2, 19, 19);
      }

      // 未解锁塔置灰 (任务要求; 原版行10618-10631 仅跳过徽标不置灰, 此处按任务增强)
      const locked = this.aC === BAR_CAT_BUILD && item < 11 && !this.towerUnlocked[item];
      const vctx = r.virtualContext;
      if (locked) {
        vctx.save();
        vctx.globalAlpha = 0.35;
      }
      // 条目图标: ui_15 帧 (原版 d(int×5) 行18876: 区域(id*16,0,16,16))
      r.drawImageRegion(ui15, item * 16, 0, 16, 16, x, iconY, 16, 16);
      if (locked) vctx.restore();
    }
  }

  /** 面板 (原版 c(int×5) 行17288 case 0: 米色底 + ui_8 上下边条) */
  private renderPanel(x: number, y: number, w: number, h: number): void {
    const r = this.renderer;
    r.setColor(COLOR_BAR_BG);
    r.fillRect(x, y, w - 1, h);
    const ui8 = this.spriteLoader?.getUISprite(8);
    if (ui8 && h > 0) {
      const vctx = r.virtualContext;
      vctx.save();
      vctx.beginPath();
      vctx.rect(x, y, w, h);
      vctx.clip();
      for (let dx = 0; dx < w; dx += 50) {
        r.drawImage(ui8, x + dx, y);
        r.drawImage(ui8, x + dx, y + h - ui8.height - 1);
      }
      vctx.restore();
    }
  }

  /** 选中项明细: 名称/价格/大图标/描述 (J() 行7960-8135) */
  private renderDetail(var8: number, panelY: number): void {
    const r = this.renderer;
    const items = this.items();
    const item = items[this.aD];
    const ui18 = this.spriteLoader?.getUISprite(18);
    const ui19 = this.spriteLoader?.getUISprite(19);
    const ui29 = this.spriteLoader?.getUISprite(29);
    const stripTextY = var8 + 3;

    // 大图标区中心 (左面板 0..57)
    const iconCX = 28;
    const iconCY = panelY + Math.max(10, (BAR_BOTTOM + 21 - panelY) >> 1) - 6;

    if (this.aC === BAR_CAT_BUILD && item < 11) {
      // ===== 建塔项 (J() 行8055-8089: aC==0 分支) =====
      // 塔名图条 (原版 g(int×3) 行21002: ui_18 区域(0,id*11,35,11))
      if (ui18) r.drawImageRegion(ui18, 0, item * 11, 35, 11, 2, var8 + 2, 35, 11);
      // 武系/文系小标 (原版 h(int×3) 行21715: 1-5→(17,0,17,10), 6-10→(0,0,17,10))
      if (ui29 && item > 0) {
        const sx = item < 6 ? 17 : 0;
        r.drawImageRegion(ui29, sx, 0, 17, 10, 2 + 36, var8 + 2 + 1, 17, 10);
      }
      // 价格: 金图标 + q1100 (J() 行8064-8078)
      if (ui19) r.drawImageRegion(ui19, UI19_GOLD_SX, 0, UI19_GOLD_W, 12, 210, var8 + 2, UI19_GOLD_W, 12);
      r.drawText(`${TOWER_COST_Q1100[item]}`, 224, stripTextY, COLOR_TEXT, 8);
      this.renderTowerPreview(item, 1, iconCX, iconCY, panelY);
    } else if (this.aC === BAR_CAT_TECH && item >= 11 && item <= 15) {
      // ===== 科技装置项 (J() 行8091-8131: aC==1 分支) =====
      const techIdx = item - 11;
      this.renderTechIcon(techIdx, iconCX, iconCY);
      if (this.techBuilt[techIdx]) {
        // 已建造印记 (J() 行8101-8110: ui_23 53x14)
        const ui23 = this.spriteLoader?.getUISprite(23);
        if (ui23) r.drawImage(ui23, 1, iconCY - 7);
      } else {
        // 价格: 金图标 + g1057 (J() 行8112-8129)
        if (ui19) r.drawImageRegion(ui19, UI19_GOLD_SX, 0, UI19_GOLD_W, 12, 210, var8 + 2, UI19_GOLD_W, 12);
        r.drawText(`${TECH_COST_G1057[techIdx]}`, 224, stripTextY, COLOR_TEXT, 8);
      }
    } else if (this.aC === BAR_CAT_TOWER && this.ay) {
      // ===== 塔操作项 (J() 行7966-8053: aC>=2 分支) =====
      const origId = this.ay.type;
      this.renderTowerPreview(origId, this.ay.level, iconCX, iconCY, panelY);
      // 塔名图条
      if (ui18) r.drawImageRegion(ui18, 0, origId * 11, 35, 11, 2, var8 + 2, 35, 11);
      // 价格: 升级费用 / 拆除返还 (J() 行7996-8046)
      if (item === ACTION_UPGRADE) {
        const cost = this.host?.getUpgradeCost(this.ay);
        if (cost != null) {
          if (ui19) r.drawImageRegion(ui19, UI19_GOLD_SX, 0, UI19_GOLD_W, 12, 210, var8 + 2, UI19_GOLD_W, 12);
          r.drawText(`${cost}`, 224, stripTextY, COLOR_TEXT, 8);
        }
      } else if (item === ACTION_LOAD_GATE) {
        const cost = this.host?.getGateLoadCost(this.ay);
        if (cost != null) {
          if (ui19) r.drawImageRegion(ui19, UI19_GOLD_SX, 0, UI19_GOLD_W, 12, 210, var8 + 2, UI19_GOLD_W, 12);
          r.drawText(`${cost}`, 224, stripTextY, COLOR_TEXT, 8);
        }
      } else if (item === ACTION_DEMOLISH) {
        const refund = this.host?.getDemolishRefund(this.ay) ?? 0;
        if (ui19) r.drawImageRegion(ui19, UI19_GOLD_SX, 0, UI19_GOLD_W, 12, 210, var8 + 2, UI19_GOLD_W, 12);
        r.drawText(`${refund}`, 224, stripTextY, COLOR_TEXT, 8);
      }
    }

    // ---- 描述/提示文本行 (J() 行7945-7954: e(item,67,y,163,av))
    const descY = var8 + 22;
    let desc = '';
    if (this.o >= 0) {
      desc = BAR_MESSAGES[this.o] ?? ''; // 提示消息 b1015[o+113] (a(int×5) 行10672)
    } else if (item === ACTION_CANCEL) {
      desc = ORIG_ACTION_DESC[5]; // 取消选择 b1015[23]
    } else if (this.aC === BAR_CAT_BUILD && item < 11) {
      desc = ORIG_TOWER_DESC[item]; // b1015[item+2]
    } else if (this.aC === BAR_CAT_TECH && item >= 11 && item <= 15) {
      desc = ORIG_TECH_DESC[item - 11]; // b1015[13+i]
    } else if (this.aC === BAR_CAT_TOWER && item >= 16) {
      desc = ORIG_ACTION_DESC[item - 16] ?? '';
    }
    this.drawWrapped(desc, 67, descY, 163, COLOR_TEXT, 8, 10);
  }

  private renderTowerPreview(type: number, level: number, centerX: number, centerY: number, panelY: number): void {
    if (!this.host) return;
    const vctx = this.renderer.virtualContext;
    vctx.save();
    vctx.beginPath();
    vctx.rect(0, panelY, 57, Math.max(0, BAR_BOTTOM + 21 - panelY));
    vctx.clip();
    this.host.renderTowerPreview(type, level, centerX, centerY);
    vctx.restore();
  }

  /**
   * 科技装置图标 (原版 a(int,int,int,boolean) 行11010: i1062 两件 /s 图集 e1058 矩形合成)
   * 原版定位: var16 = (techIdx==2 ? 10 : e1058[f1][2]>>1), var6 = techIdx<3 ? 10 : 0
   *   f1 画在 (x-var16, y-var6), f2 画在 (x-var16+dx2, y-var6+dy2); f1=-1 不画
   */
  private renderTechIcon(techIdx: number, iconCX: number, iconCY: number): void {
    const atlas = this.spriteLoader?.getByPrefix('s', 0);
    if (!atlas) return;
    const r = this.renderer;
    const [f1, f2, dx2, dy2] = TECH_ICON_I1062[techIdx];
    const half = techIdx === 2 ? 10 : (f1 >= 0 ? CASTLE_RECTS_E1058[f1][2] >> 1 : 0);
    const yOff = techIdx < 3 ? 10 : 0;
    if (f1 >= 0) {
      const rect = CASTLE_RECTS_E1058[f1];
      r.drawImageRegion(atlas, rect[0], rect[1], rect[2], rect[3], iconCX - half, iconCY - yOff, rect[2], rect[3]);
    }
    if (f2 >= 0) {
      const rect = CASTLE_RECTS_E1058[f2];
      r.drawImageRegion(atlas, rect[0], rect[1], rect[2], rect[3], iconCX - half + dx2, iconCY - yOff + dy2, rect[2], rect[3]);
    }
  }

  /** 换行文本绘制 (原版 a(String,int×5) 行11094 的换行变体, 8px字/10px行距) */
  private drawWrapped(text: string, x: number, y: number, maxW: number, color: number, size: number, lineH: number): void {
    if (!text) return;
    const r = this.renderer;
    let line = '';
    let curY = y;
    for (const ch of text) {
      const test = line + ch;
      if (r.virtualContext.measureText(test).width > maxW && line.length > 0) {
        r.drawText(line, x, curY, color, size);
        line = ch;
        curY += lineH;
      } else {
        line = test;
      }
    }
    if (line) r.drawText(line, x, curY, color, size);
  }
}
