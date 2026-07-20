/**
 * 游戏主循环 - 协调所有系统
 * 游戏流程/菜单系统按原版 a.java 状态机 (字段 l) 重写:
 *   l=0 LOGO动画 → ld加载屏 → l=18 声音询问 → l=1 标题主菜单
 *   → l=15 选择国家 → l=17 升级模式 → l=16 选择战役 → l=2 战斗 → 结算 → 回 l=16
 */
import { Renderer } from './Renderer';
import { MapData } from './MapData';
import { EnemySystem } from './Enemy';
import { TowerSystem } from './Tower';
import { CastleRenderer } from './Castle';
import { AudioSystem } from './AudioSystem';
import { InputSystem } from './Input';
import { UISystem, Button } from './UI';
import { SpriteLoader } from './SpriteLoader';
import { TechTreeSystem } from './TechTree';
import { SaveSystem } from './SaveSystem';
import { BuildBarSystem, BAR_CAT_BUILD, BAR_CAT_TECH, BAR_CAT_TOWER } from './BuildBar';
import {
  LOGICAL_WIDTH,
  LOGICAL_HEIGHT,
  MAP_TOP_BAR_H,
  MAP_VIEW_H,
  LEVEL_MUSIC_K1068,
  COUNTRY_POS_A1028,
  BATTLE_POS_B1030,
  CAMPAIGN_ORDER_H1074,
  BOSS_LIST_Z1131,
  FACTION_OFFSET_A1132,
  COLORS,
  ORIG_TO_H5_TOWER,
  H5_TO_ORIG_TOWER,
  TOWER_COST_Q1100,
  ARCHER_TOWER_TYPE,
  BAR_MESSAGES,
  ORIG_TECH_DESC,
} from '../data/gameData';
import type { FactionEnding } from '../data/gameData';
import { FACTION_ENDINGS } from '../data/gameData';
import {
  Faction,
  HEROES,
  CAPITAL_NAMES,
  FACTION_DESCRIPTIONS,
  BRANCH_NAMES,
  BRANCH_DESCRIPTIONS,
  BATTLE_NAMES,
  BATTLE_STORIES,
  GAME_HELP_TEXT,
  GAME_DESCRIPTION_TEXT,
  COPYRIGHT_TEXT,
} from '../data/heroes';

export enum GameState {
  LOGO_ANIM = 0,        // 原版 l=0: sflogo 开场动画
  TITLE_MENU = 1,       // 原版 l=1: 标题主菜单
  PLAYING = 2,
  PAUSED = 3,
  GAME_OVER = 4,
  VICTORY = 5,
  LEVEL_COMPLETE = 6,   // 原版 l=10 结算 (H5简化版)
  HELP = 8,             // 帮助页 (原版 a(21), 显示 b1015[0])
  LOADING_SCREEN = 10,  // ld 加载进度屏 (原版 k() 中的 e() 进度)
  TECH_TREE_BROWSE = 12,
  COUNTRY_SELECT = 15,  // 原版 l=15: 选择国家
  CAMPAIGN_SELECT = 16, // 原版 l=16: 选择战役
  UPGRADE_SELECT = 17,  // 原版 l=17: 升级模式 (武系/文系)
  SOUND_PROMPT = 18,    // 原版 l=18: 声音询问
  ENDING_ANIM = 19,     // 结局动画 (原版 state 46/47/48 的H5重制版)
  CREDITS = 20,         // 关于页 (原版 a(20), 显示 b1015[1])
  SETTINGS = 22,        // 设置页 (原版 a(8) 音量设置的H5简化版)
  SAVE_PANEL = 27,      // 存档面板 (新流程无入口, 保留代码)
  LEVEL_INTRO = 40,     // 关卡剧情 (对应原版 state 23)
}

// 结局动画阶段 (对应原版 state 46/47/48)
enum EndingAnimPhase {
  FADE_IN = 0,       // 淡入: 阵营结局标题
  TITLE = 1,         // 阵营结局标题停留
  DESCRIPTION = 2,   // 阵营结局描述
  VICTORY = 3,       // 统一胜利文字
  FINAL = 4,         // 最终结局文字
  FADE_OUT = 5,      // 淡出
  DONE = 6,          // 完成, 进入VICTORY状态
}

// ============================================================
// 原版界面布局常量 (a.java 构造函数 行688-701, j=字体高度≈12)
// ============================================================
const MENU_FONT_H = 12;                                    // 原版 j (Font.getHeight)
const COUNTRY_PANEL_H = MENU_FONT_H * 3 + 40;              // 原版 V=76: 国家屏底部面板高
const COUNTRY_MAP_H = 320 - COUNTRY_PANEL_H - 13 - 10;     // 原版 W=221: 国家屏地图区高
const UPGRADE_PANEL_H = COUNTRY_PANEL_H;                   // 原版 ad=76: 升级屏底部面板高
const BOSS_PANEL_H = MENU_FONT_H * 3 + 10 + 30;            // 原版 ah=82: 战役屏敌将区高
const CAMPAIGN_BOTTOM_H = BOSS_PANEL_H + 40;               // 原版 ai=122: 战役屏底部区高
const CAMPAIGN_MAP_H = 320 - CAMPAIGN_BOTTOM_H - 13 - 10;  // 原版 aj=175: 战役屏地图区高

// 标题动画摇摆表 (原版 a1027 行672)
const SWAY_A1027: number[] = [-30, -1, 0, 1, 1, 0];

// 软键帧 (ui[2]): 0菜单/1返回/2确定/3取消
const SOFTKEY_BACK = 1;
const SOFTKEY_OK = 2;
const SOFTKEY_CANCEL = 3;
const SOFTKEY_MENU = 0;

// 标题菜单项 (back[25] 帧号): 0王者之路/1自由模式/2继续游戏/3设置/4帮助/5关于/6退出
const MENU_ITEM_COUNT = 7;
const MENU_ITEM_CONTINUE = 2;

export class Game {
  private renderer: Renderer;
  private mapData: MapData;
  private enemySystem: EnemySystem;
  private towerSystem: TowerSystem;
  private castleRenderer: CastleRenderer;
  private audioSystem: AudioSystem;
  private inputSystem: InputSystem;
  private uiSystem: UISystem;
  private spriteLoader: SpriteLoader;
  private techTree: TechTreeSystem;
  private saveSystem: SaveSystem;
  private buildBar: BuildBarSystem; // 原版底部建造栏/科技面板 (任务A/B)

  private state: GameState = GameState.LOGO_ANIM;
  private currentLevel: number = 0;
  private levelIndex: number = 0;
  private gold: number = 300;
  // 城防 (对应原版 by, aj() 行14096 初始化为10; 冲入10个敌人则失败)
  private lives: number = 10;
  private lastTime: number = 0;
  private frameCount: number = 0;   // 对应原版 a1019 (闪烁计数)
  private cameraX: number = 0;
  private cameraY: number = 0;

  // 关卡剧情阶段计时器
  private introTimer: number = 0;
  // introPhase: 0=滚动动画, 1-4=显示第1-4行剧情文本(点击翻页), 5=准备开始
  private introPhase: number = 0;
  // 滚动动画进度 (0-1)
  private introAnimProgress: number = 0;

  // 统计
  private totalKills: number = 0;
  private totalGoldEarned: number = 0;
  private playTime: number = 0;

  // 地图偏移 (居中显示)
  private mapOffsetX: number = 0;
  private mapOffsetY: number = 0;

  // ====== 原版流程字段 (a.java) ======
  private factionX: number = 0;        // X: 国家 0蜀/1魏/2吴
  private upgradeAc: number = 0;       // ac: 升级模式 0武系/1文系 (原版 d(int) 行19056 决定英雄升级路线受限; 本次仅存值)
  private gameModeT: number = 0;       // T: 模式 0王者之路/1自由模式
  private campaignAO: number = 0;      // aO: 王者之路已通关战役数 (0-7)
  private battleAN: number = 0;        // aN: 当前战役 (地图/关卡索引 0-8)
  private focusAf: number = 0;         // af: 战役屏焦点 0战役点/1敌将面板
  private bossSlotAg: number = 0;      // ag: 敌将面板选中槽
  private unlockedD1073: boolean[] = new Array(9).fill(false);  // d1073: 战役解锁表
  private afterVictoryT1089: boolean = false;  // t1089: 胜利后返回标记 (战役屏取消→标题)
  private k1029: boolean = false;      // k1029: 自由模式标记 (战役名旁显示◀▶)
  private soundEnabled: boolean = true; // 原版 l1031/q (声音开关)

  // ====== 标题动画字段 (原版 m()/l()) ======
  private titleM: number = 0;          // M: 入场阶段 0..5
  private titleN: number = 0;          // N: 阶段帧计数
  private titleS: number = 0;          // S: 装饰出现计数
  private menuR: number = 0;           // r: 菜单项索引 0..6
  private posY: number = 0;            // y: 龙logo X
  private posZ: number = 0;            // z: 龙logo Y
  private posO: number = 0;            // O: 龙logo 目标Y
  private posA: number = 0;            // A: mu[0] X (摇摆)
  private posB: number = 0;            // B: mu[0] Y
  private posC: number = 0;            // C: mu[1] X (摇摆)
  private posD: number = 0;            // D: mu[1] Y
  private posE: number = 0;            // E: mu[2] X
  private posF: number = 0;            // F: mu[2] Y
  private posG: number = 0;            // G: mu[5] X
  private posH: number = 0;            // H: mu[5] Y (落下)
  private posI: number = 0;            // I: mu[6] X (滑入)
  private posJ: number = 0;            // J: mu[6] Y
  private posK: number = 0;            // K: 菜单项 X
  private posL: number = 320;          // L: 底条 Y
  private e1025: number = 0;           // 装饰基准X1
  private f1026: number = 0;           // 装饰基准X2
  private flagH: boolean = false;      // h: mu[5] 可见
  private flagJ: boolean = false;      // j1024: mu[0]/mu[1] 可见
  private flagG: boolean = false;      // g: mu[2] 可见
  private flagF: boolean = false;      // f1023: 花装饰可见
  private flagD: boolean = false;      // d1021: mu[7] 动画中
  private flagE2: boolean = false;     // e1022: mu[8] 动画中
  private flagI: boolean = false;      // i: mu[6] 可见
  private animP: number = 0;           // P: mu[7] 帧
  private animQ: number = 0;           // Q: mu[8] 帧
  private animR: number = 0;           // R: mu[2] 半帧
  private animU: number = 0;           // U: logo 弹跳方向
  private exitThanks: boolean = false; // 退出→"感谢游玩"覆盖层

  // ====== 共用背景滚动字段 (原版 n() 行23551) ======
  private bgT: number = 0;             // t: back[4]/back[5] 平铺滚动
  private bgU: number = 0;             // u: back[6] 云带滚动
  private bgV: number = -26;           // v: 云带下落
  private bgW: number = 0;             // w: 底部装饰带滚动
  private bgX: number = 416;           // x: 底部装饰带上升

  // ====== 升级模式滑卡字段 (原版 t()) ======
  private upgradeAe: number = 0;       // ae: 0输入/1左滑/2右滑
  private cardY: number = 0;           // Y: 武系卡X
  private cardZ: number = 0;           // Z: 武系卡Y
  private cardAa: number = 0;          // aa: 文系卡X
  private cardAb: number = 0;          // ab: 文系卡Y

  // ====== 开场/加载字段 ======
  private logoFrame: number = 0;       // ak: LOGO动画帧计数
  private loadingProgress: number = 0; // am→progress: 加载进度 0..1
  private atlasesReady: boolean = false;
  private atlasesPromise: Promise<void> | null = null;

  // ====== 文本页滚动 (帮助/关于) ======
  private textScroll: number = 0;
  private dragLastY: number = -1;

  // 存档槽位 (0-3) — SAVE_PANEL 保留
  private saveSlot: number = 0;

  // ====== 结局动画状态 (对应原版 b1174 阶段字段) ======
  private endingPhase: EndingAnimPhase = EndingAnimPhase.FADE_IN;
  private endingFrame: number = 0;
  private readonly endingPhaseFrames: number[] = [30, 120, 150, 120, 120, 30];
  private endingAlpha: number = 0;
  private currentEnding: FactionEnding | null = null;

  constructor(canvas: HTMLCanvasElement) {
    this.renderer = new Renderer(canvas);
    this.mapData = new MapData(this.renderer);
    this.enemySystem = new EnemySystem(this.renderer, this.mapData);
    this.towerSystem = new TowerSystem(this.renderer, this.mapData);
    this.castleRenderer = new CastleRenderer(this.renderer, this.mapData);
    this.audioSystem = new AudioSystem();
    this.inputSystem = new InputSystem(this.renderer);
    this.uiSystem = new UISystem(this.renderer);
    this.spriteLoader = new SpriteLoader();
    this.techTree = new TechTreeSystem();
    this.saveSystem = SaveSystem.getInstance();
    this.buildBar = new BuildBarSystem(this.renderer);

    this.setupCallbacks();
    this.setupInput();
    this.resize();
    window.addEventListener('resize', () => this.resize());
  }

  /**
   * 设置回调
   */
  private setupCallbacks(): void {
    // 科技树初始化 (默认蜀, 国家确认时更新)
    this.techTree.setFaction(Faction.SHU);

    this.enemySystem.setCallbacks(
      (gold) => {
        const actualGold = this.techTree.isGoldDouble() ? gold * 2 : gold;
        this.gold += actualGold;
        this.totalGoldEarned += actualGold;
        this.syncGold(); // 击杀金同步到塔/科技树池 (修复旧版三池脱节)
      },
      () => { this.lives--; if (this.lives <= 0) this.state = GameState.GAME_OVER; },
      // 名将波登场提示 (对应原版 ab() 横幅, H5简化为消息)
      (bossType) => { this.uiSystem.showMessage(`敌将来袭！ (名将${bossType}型)`, 90); },
    );

    this.towerSystem.setOnGoldSpent((cost) => { this.gold -= cost; this.syncGold(); });
    this.towerSystem.setTechTree(this.techTree);
    this.towerSystem.setOnHeroAwakened((hero, tower) => {
      this.uiSystem.showHeroAwakened(hero.name);
    });
    // TechTree 升级扣费同步 (旧版未接, 升级不扣显示金的bug)
    this.techTree.setOnGoldSpent((cost) => { this.gold -= cost; this.syncGold(); });

    // 任务B-3: 建塔解锁门禁 (原版 e1105) + 原版建造费 (q1100) + 原版拆除返还 (b(int) 行15818)
    this.towerSystem.setBuildUnlockCheck((h5Type) => this.buildBar.isTowerUnlocked(h5Type));
    this.towerSystem.setBuildCostProvider((h5Type) => {
      const orig = H5_TO_ORIG_TOWER[h5Type] ?? -1;
      return orig >= 0 ? TOWER_COST_Q1100[orig] : null;
    });
    this.towerSystem.setDemolishRefundProvider((tower) => {
      const orig = H5_TO_ORIG_TOWER[tower.type] ?? -1;
      if (orig < 0) return null; // 非原版塔用默认公式
      // 原版返还 = (建造费+升级投入)>>1, 升级投入以 建造费*(等级-1) 近似
      return (TOWER_COST_Q1100[orig] * tower.level) >> 1;
    });

    // 原版底部建造栏宿主 (任务A/B, 对应原版 M()/k(int) 的上下文)
    this.buildBar.setHost({
      getGold: () => this.gold,
      // 原版 j(int) 行22439: 金够则扣返回true
      trySpendGold: (cost) => {
        if (this.gold < cost) return false;
        this.gold -= cost;
        this.syncGold();
        return true;
      },
      getTowerCount: () => this.towerSystem.getTowers().length,
      // 选塔完成→选位 (原版 K() case 3: bF=1)
      enterPlacement: (origTowerId) => {
        const h5Type = ORIG_TO_H5_TOWER[origTowerId];
        this.towerSystem.setBuildType(h5Type);
        this.towerSystem.enterBuildMode();
        const bt = this.mapData.getBuildingBoxTile();
        this.towerSystem.setBuildPosition(bt.tx, bt.ty);
      },
      upgradeTower: (tower) => {
        if (!this.towerSystem.upgradeTower(tower)) {
          this.uiSystem.showMessage(BAR_MESSAGES[0], 90); // 金不足 (近似, 原版升级失败提示亦为 o=0/满级)
        } else {
          this.syncGold();
        }
      },
      demolishTower: (tower) => {
        this.towerSystem.sellTower(tower); // 返还公式经 demolishRefundProvider = 原版 b(int)
        this.syncGold();
      },
      getUpgradeCost: (tower) => {
        if (tower.type === ARCHER_TOWER_TYPE) {
          // 弓手塔备用公式 (原版 r1101[0]=(10,2); 上限5级)
          return tower.level < 5 ? 10 + 2 * (tower.level - 1) : null;
        }
        const info = this.techTree.canUpgradeTech(tower);
        return info.canUpgrade ? (info.cost ?? null) : null;
      },
      getDemolishRefund: (tower) => {
        const orig = H5_TO_ORIG_TOWER[tower.type] ?? -1;
        if (orig < 0) return Math.floor((this.towerSystem.getTowerConfig(tower.type)?.cost ?? 0) * tower.level * 0.7);
        return (TOWER_COST_Q1100[orig] * tower.level) >> 1;
      },
      onTechBuilt: (techIndex) => {
        // 原版: 装置建成即 e1105 解锁两塔 + b1059 城堡部件长出
        this.uiSystem.showMessage(`装置建成: ${ORIG_TECH_DESC[techIndex]}`, 120);
        this.autoSave();
      },
    });

    this.uiSystem.setButtonCallback((btn) => this.handleButton(btn));
    this.uiSystem.setTechTree(this.techTree);
  }

  /**
   * 金币三池同步: Game.gold(显示/主) → towerSystem / techTree
   * (旧版三池各自为政: 击杀金不进塔池、TechTree升级不扣显示金)
   */
  private syncGold(): void {
    this.towerSystem.setGold(this.gold);
    this.techTree.setGold(this.gold);
  }

  /**
   * 设置输入
   */
  private setupInput(): void {
    this.inputSystem.onTap((x, y) => this.handleTap(x, y));
    this.inputSystem.onMove((x, y) => {
      // 文本页 (帮助/关于/设置) 拖动滚动
      if (this.state === GameState.HELP || this.state === GameState.CREDITS) {
        if (this.dragLastY >= 0) {
          this.textScroll = Math.max(0, this.textScroll - (y - this.dragLastY));
        }
        this.dragLastY = y;
      }
      // 建造模式下不跟随鼠标, 建筑方框是唯一的建造位置指示器
      // (原版逻辑: bN/bO 建筑方框由方向键控制, 塔只能建在方框位置)
    });
    this.inputSystem.onRelease(() => { this.dragLastY = -1; });

    // 键盘输入: 方向键移动建筑方框 / 菜单导航
    window.addEventListener('keydown', (e) => this.handleKeyDown(e));
  }

  /**
   * 处理键盘输入 (对应原版 al() 方法中的方向键处理 + 菜单键处理)
   * 任务A: 建造栏打开时 ←→=选项 Enter=确认 Esc=关栏 (原版 M() 行8295-8351);
   *        选位模式 ←→↑↓=移幻影 Enter=放塔 Esc=取消
   */
  private handleKeyDown(e: KeyboardEvent): void {
    if (this.state === GameState.PLAYING || this.state === GameState.LEVEL_INTRO) {
      // 建造栏打开: 栏内导航 (原版 M() 方向键)
      if (this.buildBar.isOpen) {
        switch (e.key) {
          case 'ArrowLeft': case 'a': case 'A':
            this.buildBar.navigate(-1);
            break;
          case 'ArrowRight': case 'd': case 'D':
            this.buildBar.navigate(1);
            break;
          case 'Enter': case ' ':
            this.buildBar.confirm();
            break;
          case 'Escape':
            this.buildBar.close();
            break;
        }
        e.preventDefault();
        return;
      }
      // 选位模式: 方向键移幻影, Enter放塔, Esc取消 (原版 bF==1 输入)
      if (this.towerSystem.isBuildMode) {
        switch (e.key) {
          case 'ArrowUp': case 'w': case 'W':
            this.moveBoxAndGhost(0, -1);
            break;
          case 'ArrowDown': case 's': case 'S':
            this.moveBoxAndGhost(0, 1);
            break;
          case 'ArrowLeft': case 'a': case 'A':
            this.moveBoxAndGhost(-1, 0);
            break;
          case 'ArrowRight': case 'd': case 'D':
            this.moveBoxAndGhost(1, 0);
            break;
          case 'Enter': case ' ':
            this.tryPlacePendingTower();
            break;
          case 'Escape':
            this.towerSystem.exitBuildMode();
            break;
        }
        e.preventDefault();
        return;
      }
      switch (e.key) {
        case 'ArrowUp':
        case 'w':
        case 'W':
          this.mapData.moveBox(0, -1);
          e.preventDefault();
          break;
        case 'ArrowDown':
        case 's':
        case 'S':
          this.mapData.moveBox(0, 1);
          e.preventDefault();
          break;
        case 'ArrowLeft':
        case 'a':
        case 'A':
          this.mapData.moveBox(-1, 0);
          e.preventDefault();
          break;
        case 'ArrowRight':
        case 'd':
        case 'D':
          this.mapData.moveBox(1, 0);
          e.preventDefault();
          break;
        case 'Enter':
        case ' ':
          // 导航键中=确定 (原版: 游戏中调出单位建造菜单)
          this.openBarForBoxTile();
          e.preventDefault();
          break;
      }
      return;
    }

    // 菜单/界面键盘导航: ←→=切换, Enter=确定, Esc=取消, ↑↓=焦点/滚动
    const k = e.key;
    let handled = true;
    switch (this.state) {
      case GameState.LOGO_ANIM:
        if (k === 'Enter' || k === ' ') this.startLoadingScreen();
        break;
      case GameState.TITLE_MENU:
        if (k === 'ArrowLeft') this.titleAction('left');
        else if (k === 'ArrowRight') this.titleAction('right');
        else if (k === 'Enter' || k === ' ') this.titleAction('ok');
        else handled = false;
        break;
      case GameState.SOUND_PROMPT:
        if (k === 'Enter' || k === ' ') this.soundPromptAction(true);
        else if (k === 'Escape') this.soundPromptAction(false);
        else handled = false;
        break;
      case GameState.COUNTRY_SELECT:
        if (k === 'ArrowLeft') this.countryAction('left');
        else if (k === 'ArrowRight') this.countryAction('right');
        else if (k === 'Enter' || k === ' ') this.countryAction('ok');
        else if (k === 'Escape') this.countryAction('cancel');
        else handled = false;
        break;
      case GameState.UPGRADE_SELECT:
        if (k === 'ArrowLeft') this.upgradeAction('left');
        else if (k === 'ArrowRight') this.upgradeAction('right');
        else if (k === 'Enter' || k === ' ') this.upgradeAction('ok');
        else if (k === 'Escape') this.upgradeAction('cancel');
        else handled = false;
        break;
      case GameState.CAMPAIGN_SELECT:
        if (k === 'ArrowLeft') this.campaignAction('left');
        else if (k === 'ArrowRight') this.campaignAction('right');
        else if (k === 'ArrowUp') this.campaignAction('up');
        else if (k === 'ArrowDown') this.campaignAction('down');
        else if (k === 'Enter' || k === ' ') this.campaignAction('ok');
        else if (k === 'Escape') this.campaignAction('cancel');
        else handled = false;
        break;
      case GameState.SETTINGS:
        if (k === 'ArrowLeft' || k === 'ArrowRight') this.settingsAction('toggle');
        else if (k === 'Enter' || k === ' ') this.settingsAction('ok');
        else if (k === 'Escape') this.settingsAction('cancel');
        else handled = false;
        break;
      case GameState.HELP:
      case GameState.CREDITS:
        if (k === 'ArrowUp') this.textScroll = Math.max(0, this.textScroll - 12);
        else if (k === 'ArrowDown') this.textScroll += 12;
        else if (k === 'Escape' || k === 'Enter') this.gotoTitle();
        else handled = false;
        break;
      default:
        handled = false;
        break;
    }
    if (handled) e.preventDefault();
  }

  // ============================================================
  // 精灵图快捷访问
  // ============================================================
  private spr(prefix: string, index: number): HTMLImageElement | null {
    return this.spriteLoader.getByPrefix(prefix, index);
  }

  /**
   * 播放音乐 (声音关闭时静默; 对应原版 g(int,int) 播放 /N.mid)
   */
  private playMusic(path: string): void {
    if (!this.soundEnabled) return;
    this.audioSystem.playMidi(path).catch(() => {});
  }

  /**
   * 回标题主菜单 (重置入场动画并播放菜单音乐 /7.mid)
   */
  private gotoTitle(): void {
    this.state = GameState.TITLE_MENU;
    this.titleM = 0;
    this.titleN = 0;
    this.menuR = 0;
    this.exitThanks = false;
    this.playMusic('./mid/7.mid');
  }

  /**
   * 处理点击
   */
  private handleTap(x: number, y: number): void {
    // 软键区域 (底部 y>=305): 左半=左软键, 右半=右软键
    const softLeft = y >= 305 && x < 110;
    const softRight = y >= 305 && x >= 130;

    // 根据当前状态分发点击处理
    switch (this.state) {
      case GameState.LOGO_ANIM:
        // 点击跳过LOGO动画
        this.startLoadingScreen();
        return;
      case GameState.LOADING_SCREEN:
        return;
      case GameState.SOUND_PROMPT:
        // 左下=开启, 右下=取消 (原版 h()/i(): 左软键开启, 右软键取消)
        if (softLeft || (y >= 280 && x < 120)) this.soundPromptAction(true);
        else if (softRight || (y >= 280 && x >= 120)) this.soundPromptAction(false);
        return;
      case GameState.TITLE_MENU:
        this.handleTitleTap(x, y);
        return;
      case GameState.COUNTRY_SELECT:
        this.handleCountryTap(x, y, softLeft, softRight);
        return;
      case GameState.UPGRADE_SELECT:
        this.handleUpgradeTap(x, y, softLeft, softRight);
        return;
      case GameState.CAMPAIGN_SELECT:
        this.handleCampaignTap(x, y, softLeft, softRight);
        return;
      case GameState.SETTINGS:
        this.handleSettingsTap(x, y, softLeft, softRight);
        return;
      case GameState.HELP:
      case GameState.CREDITS:
        // 仅返回软键 (原版: 帮助/关于=仅返回)
        if (softRight || softLeft) this.gotoTitle();
        return;
      case GameState.LEVEL_INTRO:
        // 剧情阶段: 点击翻页或开始游戏 (对应原版 ad() case 2 中 bs++)
        if (this.introPhase === 0) {
          // 跳过动画
          this.introPhase = 1;
          this.introAnimProgress = 1;
        } else if (this.introPhase < 4) {
          // 翻到下一页剧情文本
          this.introPhase++;
        } else {
          // 读完所有剧情, 开始游戏
          this.endLevelIntro();
        }
        return;
      case GameState.SAVE_PANEL:
        this.handleSavePanelTap(x, y);
        return;
      case GameState.LEVEL_COMPLETE:
        this.handleLevelCompleteTap();
        return;
      case GameState.ENDING_ANIM:
        // 点击可跳过当前阶段
        this.advanceEndingPhase();
        return;
      case GameState.GAME_OVER:
        // 原版 V(): 失败 → B() 回标题
        this.gotoTitle();
        return;
      case GameState.VICTORY:
        this.gotoTitle();
        return;
      case GameState.PLAYING:
        // 游戏中的点击处理
        break;
      default:
        return;
    }

    // 游戏中: 先检查UI按钮 (暂停菜单时也只能点UI按钮)
    if (this.uiSystem.handleTap(x, y)) return;

    // ====== 暂停菜单可见时, 不处理地图点击 ======
    if (this.uiSystem.isPauseMenuVisible()) return;

    // ====== 原版底部建造栏打开时: 点击全部由栏处理 (任务A) ======
    // (点图标=选中/确认, 点明细=确认, 点栏外地图=关栏; 原版 M() 行8273)
    if (this.buildBar.isOpen) {
      // 软键优先: 左=确定 (原版左功能键), 右=取消关栏 (原版 -7 键)
      if (softLeft) {
        this.buildBar.confirm();
        return;
      }
      if (softRight) {
        this.buildBar.close();
        return;
      }
      this.buildBar.handleTap(x, y);
      return;
    }

    // ====== 建造选位模式 (原版 bF==1, state 13/14) ======
    if (this.towerSystem.isBuildMode) {
      if (softRight) {
        // 右软键=取消选位 (原版 -7 键: bF=0, 行14530-14537)
        this.towerSystem.exitBuildMode();
        return;
      }
      if (y >= 305) {
        // 左软键/中部=在幻影处放塔 (原版开火键 c(bN,bO,bw,aA) 行14680-14683)
        this.tryPlacePendingTower();
        return;
      }
      // 地图点击: 点幻影同格=放塔, 点其他格=移动幻影 (触屏适配)
      const tapTile = this.mapData.screenToTile(x, y);
      const cur = this.towerSystem.getBuildPosition();
      if (tapTile.tx === cur.tx && tapTile.ty === cur.ty) {
        this.tryPlacePendingTower();
      } else {
        this.mapData.setBuildingBox(tapTile.tx, tapTile.ty);
        this.towerSystem.setBuildPosition(tapTile.tx, tapTile.ty);
      }
      return;
    }

    // ====== 普通战斗点击 (原版战斗确认键处理 行14538-14607) ======
    if (softLeft) {
      // 左软键=确定: 对当前建筑方框格开火 (原版左软键/导航键中)
      this.openBarForBoxTile();
      return;
    }
    if (softRight) {
      // 右软键=菜单 (原版右功能键)
      this.uiSystem.setPaused(true);
      return;
    }
    if (y >= 305) return;

    // 检查地图点击 (使用相机系统转换坐标)
    const tile = this.mapData.screenToTile(x, y);

    // 将建筑方框移动到点击位置 (触屏支持, 对应原版 al() 中的 bN/bO 设置)
    this.mapData.setBuildingBox(tile.tx, tile.ty);

    // 获取建筑方框当前瓦片坐标 (点击后即为点击位置)
    const boxTile = this.mapData.getBuildingBoxTile();

    // 原版行14545-14607:
    //   有塔(ay!=-1) → 塔操作栏 (j(2..7)); 可建格 e(bN,bO) → 建造栏 j(0);
    //   我城格 g(bN,bO) → 科技栏 j(1); 否则 u1096=true (取消选择)
    const tower = this.towerSystem.selectTower(boxTile.tx, boxTile.ty);
    if (tower) {
      // 点击已有塔: 底部塔操作栏 (升级/拆除/取消, 原版类别2)
      this.buildBar.open(BAR_CAT_TOWER, tower);
    } else if (this.mapData.isBuildableAt(boxTile.tx, boxTile.ty)) {
      // 点击可建造位置: 底部建造栏 (原版类别0)
      this.towerSystem.deselectTower();
      this.buildBar.open(BAR_CAT_BUILD);
    } else if (this.mapData.isOurCastle(boxTile.tx, boxTile.ty)) {
      // 点击我方城池: 底部科技面板 (原版类别1, 任务B)
      this.towerSystem.deselectTower();
      this.buildBar.open(BAR_CAT_TECH);
    } else {
      // 不可建造且无塔: 取消选择 (对应原版 u1096=true)
      this.towerSystem.deselectTower();
    }
  }

  /**
   * 对建筑方框当前格执行"开火" (原版左软键/导航键中, 行14538-14607)
   * 塔→操作栏; 可建格→建造栏; 我城→科技栏
   */
  private openBarForBoxTile(): void {
    const boxTile = this.mapData.getBuildingBoxTile();
    const tower = this.towerSystem.selectTower(boxTile.tx, boxTile.ty);
    if (tower) {
      this.buildBar.open(BAR_CAT_TOWER, tower);
    } else if (this.mapData.isBuildableAt(boxTile.tx, boxTile.ty)) {
      this.buildBar.open(BAR_CAT_BUILD);
    } else if (this.mapData.isOurCastle(boxTile.tx, boxTile.ty)) {
      this.buildBar.open(BAR_CAT_TECH);
    }
  }

  /**
   * 在选位幻影处放塔 (原版 c(int,int,int,int) 行17252: 扣q1100, bt++, bF=0)
   * 放塔失败(位置不可建/金不足)时留在选位模式
   */
  private tryPlacePendingTower(): void {
    const cur = this.towerSystem.getBuildPosition();
    const type = this.towerSystem.buildType;
    // 原版科技建筑门禁 (e1105, M() case 0 行8386-8389; 正常流程在栏内已拦截, 此处双保险)
    if (!this.buildBar.isTowerUnlocked(type)) {
      this.uiSystem.showMessage(BAR_MESSAGES[2], 90); // b1015[115] 需要修建相关的城池
      this.towerSystem.exitBuildMode();
      return;
    }
    if (this.towerSystem.placeTower(cur.tx, cur.ty, type)) {
      this.syncGold();
      this.towerSystem.exitBuildMode();
    } else {
      this.uiSystem.showMessage('此处不可建造', 60);
    }
  }

  // ============================================================
  // 标题主菜单 (原版 l() 行22601 渲染 / m() 行22984 逻辑)
  // ============================================================

  /** 标题屏点击: 左右箭头区切换菜单项, 点菜单项=确定 */
  private handleTitleTap(x: number, y: number): void {
    if (this.exitThanks) {
      this.exitThanks = false;
      return;
    }
    if (this.titleM < 5) {
      // 点击跳过入场动画
      this.skipTitleAnim();
      return;
    }
    // 菜单项与箭头都在底条 (L, L+13) 一带, 放宽触屏热区
    if (y >= this.posL - 12) {
      const arrowL = this.posK - 20;
      const arrowR = this.posK + 47 + 20;
      if (x >= arrowL - 14 && x <= arrowL + 14) {
        this.titleAction('left');
        return;
      }
      if (x >= arrowR - 14 && x <= arrowR + 14) {
        this.titleAction('right');
        return;
      }
      if (x >= this.posK - 16 && x <= this.posK + 63) {
        this.titleAction('ok');
        return;
      }
      // 左下软键区 ui[2]帧(确定) 热区
      if (x <= 40 && y >= 305) {
        this.titleAction('ok');
        return;
      }
    }
  }

  /** 标题菜单操作 (对应原版 m() case 5 的按键处理) */
  private titleAction(act: 'left' | 'right' | 'ok'): void {
    if (this.titleM < 5) {
      if (act === 'ok') this.skipTitleAnim();
      return;
    }
    switch (act) {
      // 原版: 右键 r+1 循环, 左键 r-1 循环; 无存档时跳过"继续游戏"(r=2)
      case 'right':
        this.menuR++;
        if (this.menuR >= MENU_ITEM_COUNT) this.menuR = 0;
        if (this.menuR === MENU_ITEM_CONTINUE && !this.saveSystem.hasSave()) this.menuR++;
        break;
      case 'left':
        this.menuR--;
        if (this.menuR < 0) this.menuR = MENU_ITEM_COUNT - 1;
        if (this.menuR === MENU_ITEM_CONTINUE && !this.saveSystem.hasSave()) this.menuR--;
        break;
      case 'ok':
        this.selectTitleItem();
        break;
    }
  }

  /** 菜单项确定 (对应原版 m() case 5 中 switch(r)) */
  private selectTitleItem(): void {
    switch (this.menuR) {
      case 0: // 王者之路 → l=15 (原版: T=0, X=0, aO=0, aN=0, af=1)
        this.gameModeT = 0;
        this.factionX = 0;
        this.campaignAO = 0;
        this.battleAN = 0;
        this.focusAf = 1;
        this.bossSlotAg = 0;
        this.k1029 = false;
        this.afterVictoryT1089 = false;
        this.gold = 300;
        this.state = GameState.COUNTRY_SELECT;
        break;
      case 1: // 自由模式 → l=15 (原版: T=1, af=0, k1029=true)
        this.gameModeT = 1;
        this.factionX = 0;
        this.campaignAO = 0;
        this.battleAN = 0;
        this.focusAf = 0;
        this.bossSlotAg = 0;
        this.k1029 = true;
        this.afterVictoryT1089 = false;
        this.gold = 300;
        this.state = GameState.COUNTRY_SELECT;
        break;
      case 2: // 继续游戏 → 读档 → 战斗
        this.continueGame();
        break;
      case 3: // 设置 → 声音开关 (原版 a(8) 的H5简化)
        this.state = GameState.SETTINGS;
        break;
      case 4: // 帮助 → b1015[0] 文本页 (原版 a(21))
        this.textScroll = 0;
        this.state = GameState.HELP;
        break;
      case 5: // 关于 → b1015[1] 版权页 (原版 a(20))
        this.textScroll = 0;
        this.state = GameState.CREDITS;
        break;
      case 6: // 退出 (浏览器环境: 显示"感谢游玩")
        this.exitThanks = true;
        break;
    }
  }

  /** 跳过标题入场动画 (直接到 M=5 交互态) */
  private skipTitleAnim(): void {
    this.computeTitleDecorPositions();
    this.flagH = true;
    this.flagJ = true;
    this.flagF = true;
    this.flagG = true;
    this.flagI = true;
    this.flagD = false;
    this.flagE2 = false;
    this.titleS = 3;
    this.animR = 2;
    this.posH = this.posO - 6;
    this.posI = this.posY - 18 - 15;
    this.posZ = this.posO;
    this.posL = 320 - 13;
    this.posK = (240 - 47) >> 1;
    this.titleM = 5;
  }

  /** 计算标题装饰最终位置 (原版 m() case 2 落点计算) */
  private computeTitleDecorPositions(): void {
    this.posY = (240 - 86) >> 1;            // mu[4] 居中X
    this.posO = ((320 - 172) >> 1) - 10;    // mu[4] 目标Y
    this.e1025 = this.posY + 86 - 20;
    this.f1026 = this.e1025 + 31 - 4;
    this.posA = this.e1025 + SWAY_A1027[0];
    this.posC = this.f1026 - SWAY_A1027[0];
    this.posB = this.posO + 12;
    this.posD = this.posB + 8;
    this.posE = this.f1026;
    this.posF = this.posB + 44;
    this.posG = this.f1026;
    this.posJ = (320 - 111) >> 1;
  }

  /**
   * 标题入场动画更新 (对应原版 m() 行22984: M=0..5 分阶段)
   */
  private updateTitleMenu(_dt: number): void {
    switch (this.titleM) {
      case 0:
        this.titleS = 0;
        this.titleN = 0;
        this.bgV = -26;
        this.bgX = 416;
        this.titleM = 1;
        break;
      case 1:
        this.updateMenuBackground();
        this.titleN++;
        if (this.titleN > 20) {
          this.titleN = 0;
          this.posY = (240 - 86) >> 1;
          this.posZ = 320 + 172;
          this.posO = ((320 - 172) >> 1) - 10;
          this.titleM = 2;
        }
        break;
      case 2:
        this.updateMenuBackground();
        this.posZ -= 60;  // 龙logo以60px/帧滑上
        if (this.posZ < this.posO) {
          this.posZ = this.posO;
          this.titleN = 0;
          this.animU = 0;
          this.computeTitleDecorPositions();
          this.titleM = 4;
        }
        break;
      case 4:
        this.updateMenuBackground();
        this.updateLogoBounce();
        if (this.titleN > 2) {
          this.flagJ = true;
          this.titleN = 0;
          this.titleM = 3;
        }
        this.titleN++;
        break;
      case 3:
        this.updateTitleStage3();
        break;
      case 5:
        this.updateMenuBackground();
        this.updateLogoBounce();
        this.posL -= 2;  // 底条升上
        if (this.posL < 320 - 13) this.posL = 320 - 13;
        break;
    }
  }

  /** M=3 阶段: 装饰依次入场 (原版 m() case 3) */
  private updateTitleStage3(): void {
    this.updateMenuBackground();
    this.updateLogoBounce();
    const n = this.titleN;
    if (n < SWAY_A1027.length) {
      // mu[0]/mu[1] 按 a1027 摇摆
      this.posA = this.e1025 + SWAY_A1027[n];
      this.posC = this.f1026 - SWAY_A1027[n];
    } else if (n === SWAY_A1027.length + 2) {
      this.posH = -112;  // mu[5] 从顶落下
      this.flagH = true;
    } else if (n === SWAY_A1027.length + 3) {
      this.posH += 56;
    } else if (n === SWAY_A1027.length + 4) {
      this.posH = this.posO - 10;
    } else if (n === SWAY_A1027.length + 5) {
      this.posH = this.posO - 6;
      this.flagF = true;
    }

    if (this.flagF) {
      if (this.titleS === 1) {
        this.flagD = true;
      } else if (this.titleS === 2) {
        this.flagE2 = true;
        this.flagG = true;
      }
      if (this.titleS < 3) this.titleS++;
    }
    if (this.flagD) {
      this.animP++;
      if (this.animP > 4) this.flagD = false;
    }
    if (this.flagE2) {
      this.animQ++;
      if (this.animQ > 4) {
        this.flagE2 = false;
        this.flagI = true;
        this.posI = -18;  // mu[6] 从左滑入
        this.posJ = (320 - 111) >> 1;
      }
    }
    if (this.flagG) {
      if (this.animR < 2) this.animR++;
    }
    if (this.flagI) {
      this.posI += 8;
      if (this.posI > this.posY - 18 - 15) this.posI = this.posY - 18 - 15;
    }

    this.titleN++;
    if (this.titleN > 25) {
      this.titleN = 0;
      this.posL = 320;
      this.posK = (240 - 47) >> 1;
      this.titleM = 5;
    }
  }

  /** 龙logo落点弹跳 (原版 o() 行23702) */
  private updateLogoBounce(): void {
    if (this.animU === 0) {
      this.posZ += 1;
      if (this.posZ > this.posO + 5) this.animU = 1;
    } else {
      this.posZ -= 1;
      if (this.posZ < this.posO) this.animU = 0;
    }
  }

  /** 共用背景滚动 (原版 n() 行23551) */
  private updateMenuBackground(): void {
    this.bgU -= 2;
    if (this.bgU < -176) this.bgU = 0;
    this.bgW -= 2;
    if (this.bgW < -176) this.bgW = 0;
    this.bgV += 4;
    if (this.bgV > 0) this.bgV = 0;
    this.bgX -= 16;
    if (this.bgX < 300) this.bgX = 300;
    this.bgT -= 1;
    if (this.bgT < -83 * 5) this.bgT = 0;
  }

  // ============================================================
  // 声音询问 (原版 l=18: h() 行21381 渲染 / i() 行21989 逻辑)
  // ============================================================
  private soundPromptAction(yes: boolean): void {
    this.soundEnabled = yes;
    this.persistSoundSetting();
    if (yes) {
      // 原版 i(): 开启 → l=1 + 播放 /7.mid
      this.gotoTitle();
    } else {
      this.state = GameState.TITLE_MENU;
      this.titleM = 0;
      this.titleN = 0;
      this.menuR = 0;
    }
  }

  /** 声音设置持久化 (存入 SaveSystem 设置) */
  private persistSoundSetting(): void {
    const settings = this.saveSystem.loadSettings();
    settings.musicEnabled = this.soundEnabled;
    this.saveSystem.saveSettings(settings);
  }

  // ============================================================
  // 选择国家 (原版 l=15: q() 行23981 渲染 / r() 行24345 逻辑)
  // ============================================================

  /** 国家屏布局 (与渲染共用坐标计算) */
  private countryLayout() {
    const mapX = (240 - 190) >> 1;                          // back[7] 地图原点
    const mapY = ((COUNTRY_MAP_H - 126) >> 1) + 13;
    const stripY = COUNTRY_MAP_H + 13;                      // ui[6] 分割条Y
    const beigeY = stripY + 7;                              // 米色区起点
    const barX = (240 - 52) >> 1;                           // back[8] 选择条
    const barY = beigeY - 22 - 9;
    const bR = barX + 4;                                    // 左箭头X
    const bS = barX + 52 - 4 - 6;                           // 右箭头X
    const bT = (52 >> 1) + barY;                            // 箭头Y
    return { mapX, mapY, stripY, beigeY, barX, barY, bR, bS, bT };
  }

  /** 国家屏点击 */
  private handleCountryTap(x: number, y: number, softLeft: boolean, softRight: boolean): void {
    if (softLeft) { this.countryAction('ok'); return; }
    if (softRight) { this.countryAction('cancel'); return; }
    const lay = this.countryLayout();
    // 左右箭头区
    if (y >= lay.bT - 14 && y <= lay.bT + 14) {
      if (x >= lay.bR - 12 && x <= lay.bR + 12) { this.countryAction('left'); return; }
      if (x >= lay.bS - 12 && x <= lay.bS + 12) { this.countryAction('right'); return; }
    }
    // 国家标记直接点选
    for (let i = 0; i < 3; i++) {
      const mx = lay.mapX + COUNTRY_POS_A1028[i][0] + 9;
      const my = lay.mapY + COUNTRY_POS_A1028[i][1] + 9;
      if (Math.abs(x - mx) <= 12 && Math.abs(y - my) <= 12) {
        this.factionX = i;
        return;
      }
    }
  }

  /** 国家屏操作 (对应原版 r() 行24345) */
  private countryAction(act: 'left' | 'right' | 'ok' | 'cancel'): void {
    switch (act) {
      // 原版方向相反: 左键 X+1, 右键 X-1
      case 'left':
        this.factionX++;
        if (this.factionX > 2) this.factionX = 0;
        break;
      case 'right':
        this.factionX--;
        if (this.factionX < 0) this.factionX = 2;
        break;
      case 'ok':
        // → l=17 升级模式 (原版: ac=0, 初始化卡片位置)
        this.upgradeAc = 0;
        this.upgradeAe = 0;
        this.cardY = (240 - 56) >> 1;
        this.cardZ = (320 - COUNTRY_PANEL_H - 70) >> 1;
        this.cardAa = -59;
        this.cardAb = (320 - COUNTRY_PANEL_H - 56) >> 1;
        // 国家落到实处: 传入 TechTree (蜀0/魏1/吴2 与 Faction 枚举一致)
        this.techTree.setFaction(this.factionX as Faction);
        this.state = GameState.UPGRADE_SELECT;
        break;
      case 'cancel':
        // → l=1 标题 (原版: c(0) + g(7,-1))
        this.gotoTitle();
        break;
    }
  }

  // ============================================================
  // 升级模式 (原版 l=17: s() 行24545 渲染 / t() 行24708 逻辑)
  // ============================================================

  /** 升级屏点击 */
  private handleUpgradeTap(x: number, y: number, softLeft: boolean, softRight: boolean): void {
    if (softLeft) { this.upgradeAction('ok'); return; }
    if (softRight) { this.upgradeAction('cancel'); return; }
    if (this.upgradeAe !== 0) return;
    // 名称区左右箭头 (y≈320-ad-13)
    const nameY = 320 - UPGRADE_PANEL_H - 13;
    if (y >= nameY - 12 && y <= nameY + 24) {
      const nameW = BRANCH_NAMES[this.upgradeAc].length * 11;
      const nameX = (240 - nameW - 2) >> 1;
      const bR = nameX - 4 - 6;
      const bS = nameX + nameW + 2 + 4;
      if (x >= bR - 12 && x <= bR + 12) { this.upgradeAction('left'); return; }
      if (x >= bS - 12 && x <= bS + 12) { this.upgradeAction('right'); return; }
    }
    // 卡片点选: 点武系卡='left'方向切到0, 点文系卡='right'方向切到1
    const cardHit = (cx: number, cy: number, w: number, h: number) =>
      x >= cx && x <= cx + w && y >= cy && y <= cy + h;
    if (this.upgradeAc === 0 && cardHit(this.cardAa, this.cardAb, 59, 56)) {
      this.upgradeAction('right');
    } else if (this.upgradeAc === 1 && cardHit(this.cardY, this.cardZ, 56, 70)) {
      this.upgradeAction('left');
    }
  }

  /** 升级屏操作 (对应原版 t() 行24708 ae=0 分支) */
  private upgradeAction(act: 'left' | 'right' | 'ok' | 'cancel'): void {
    if (this.upgradeAe !== 0 && act !== 'cancel') return;
    switch (act) {
      case 'right':
        // 右键 ac+1: 新卡从左滑入 (ae=2)
        this.upgradeAc++;
        if (this.upgradeAc > 1) {
          this.upgradeAc = 0;
          this.cardY = -56;
        } else {
          this.cardAa = -59;
        }
        this.upgradeAe = 2;
        break;
      case 'left':
        // 左键 ac-1: 新卡从右滑入 (ae=1)
        this.upgradeAc--;
        if (this.upgradeAc < 0) {
          this.upgradeAc = 1;
          this.cardAa = 320;
        } else {
          this.cardY = 320;
        }
        this.upgradeAe = 1;
        break;
      case 'ok':
        // → l=16 选择战役
        this.battleAN = this.gameModeT === 0
          ? CAMPAIGN_ORDER_H1074[this.factionX][this.campaignAO]
          : this.battleAN;
        this.bossSlotAg = 0;
        this.state = GameState.CAMPAIGN_SELECT;
        break;
      case 'cancel':
        // → l=15 选择国家
        this.state = GameState.COUNTRY_SELECT;
        break;
    }
  }

  /** 升级屏滑卡动画 (原版 t() 行24708 ae=1/2 分支, 20px/帧) */
  private updateUpgradeSelect(): void {
    const centerY = (240 - 56) >> 1;   // 武系卡中心X
    const centerAa = (240 - 59) >> 1;  // 文系卡中心X
    if (this.upgradeAe === 1) {
      // 向左滑: 新卡从右(320)滑入, 旧卡从左滑出
      let done1 = false;
      let done2 = false;
      if (this.upgradeAc === 0) {
        this.cardY -= 20;
        if (this.cardY < centerY) { this.cardY = centerY; done1 = true; }
        this.cardAa -= 20;
        if (this.cardAa < -59) { this.cardAa = -59; done2 = true; }
      } else {
        this.cardAa -= 20;
        if (this.cardAa < centerAa) { this.cardAa = centerAa; done1 = true; }
        this.cardY -= 20;
        if (this.cardY < -56) { this.cardY = -56; done2 = true; }
      }
      if (done1 && done2) this.upgradeAe = 0;
    } else if (this.upgradeAe === 2) {
      // 向右滑: 新卡从左(-w)滑入, 旧卡从右滑出
      let done1 = false;
      let done2 = false;
      if (this.upgradeAc === 0) {
        this.cardY += 20;
        if (this.cardY > centerY) { this.cardY = centerY; done1 = true; }
        this.cardAa += 20;
        if (this.cardAa > 240) { this.cardAa = 240; done2 = true; }
      } else {
        this.cardAa += 20;
        if (this.cardAa > centerAa) { this.cardAa = centerAa; done1 = true; }
        this.cardY += 20;
        if (this.cardY > 240) { this.cardY = 240; done2 = true; }
      }
      if (done1 && done2) this.upgradeAe = 0;
    }
  }

  // ============================================================
  // 选择战役 (原版 l=16: v() 行25285 渲染 / u() 行25041 逻辑 / f() 行20071 敌将面板)
  // ============================================================

  /** 战役屏布局 (与渲染共用坐标计算) */
  private campaignLayout() {
    const mapX = (240 - 190) >> 1;
    const mapY = ((CAMPAIGN_MAP_H - 126) >> 1) + 13;
    const stripY = CAMPAIGN_MAP_H + 13;                    // ui[6] 分割条Y (=188)
    const nameY = 320 - CAMPAIGN_BOTTOM_H - 13 - 2;        // 战役名Y (文字顶≈-11)
    const bossX = (240 - 48 - 24 * 4 - 10) >> 1;           // 敌将面板X (=43)
    const bossY = nameY + 20;                              // 敌将面板Y
    return { mapX, mapY, stripY, nameY, bossX, bossY };
  }

  /** 敌将名单 (对应原版 f() label37: 战役2-5按国家取半) */
  private getBossRange(aN: number): { offset: number; count: number } {
    const list = BOSS_LIST_Z1131[aN] ?? [];
    if (aN > 1 && aN < 6) {
      const half = list.length >> 1;
      const offset = FACTION_OFFSET_A1132[this.factionX][aN] === 1 ? half : 0;
      return { offset, count: half };
    }
    return { offset: 0, count: Math.min(8, list.length) };
  }

  /** 战役是否可选 (已解锁 d1073 的+下一个; 王者之路当前战役恒可选) */
  private isBattleSelectable(aN: number): boolean {
    if (this.gameModeT === 0) return aN === CAMPAIGN_ORDER_H1074[this.factionX][this.campaignAO];
    if (this.unlockedD1073[aN]) return true;
    // "下一个": 之前的战役全部解锁
    for (let i = 0; i < aN; i++) {
      if (!this.unlockedD1073[i]) return false;
    }
    return true;
  }

  /** 战役屏点击 */
  private handleCampaignTap(x: number, y: number, softLeft: boolean, softRight: boolean): void {
    if (softLeft) { this.campaignAction('ok'); return; }
    if (softRight) { this.campaignAction('cancel'); return; }
    const lay = this.campaignLayout();
    // "敌将"按钮区 (原版: 右上 200,aj+10 40x15)
    if (x >= 196 && y >= lay.stripY + 6 && y <= lay.stripY + 30) {
      if (this.gameModeT === 1) this.campaignAction('down');
      return;
    }
    // 敌将槽位点选 (4列网格)
    const { count } = this.getBossRange(this.battleAN);
    for (let i = 0; i < count; i++) {
      const sx = lay.bossX + 48 + 10 + (i & 3) * 24;
      const sy = lay.bossY + (i >> 2) * 24;
      if (x >= sx && x <= sx + 24 && y >= sy && y <= sy + 24) {
        this.bossSlotAg = i;
        this.focusAf = 1;
        return;
      }
    }
    // 战役名旁箭头 (自由模式)
    if (this.gameModeT === 1 && y >= lay.nameY - 16 && y <= lay.nameY + 16) {
      const nameW = (BATTLE_NAMES[this.battleAN] ?? '').length * 11;
      const nameX = (240 - nameW - 2) >> 1;
      if (x >= nameX - 22 && x <= nameX + 2) { this.campaignAction('left'); return; }
      if (x >= nameX + nameW - 2 && x <= nameX + nameW + 22) { this.campaignAction('right'); return; }
    }
    // 战役点直接点选 (自由模式)
    if (this.gameModeT === 1) {
      for (let i = 0; i < 9; i++) {
        const px = lay.mapX + BATTLE_POS_B1030[i][0] + 4;
        const py = lay.mapY + BATTLE_POS_B1030[i][1] + 4;
        if (Math.abs(x - px) <= 10 && Math.abs(y - py) <= 10 && this.isBattleSelectable(i)) {
          this.battleAN = i;
          this.bossSlotAg = 0;
          this.focusAf = 0;
          return;
        }
      }
    }
  }

  /** 战役屏操作 (对应原版 u() 行25041) */
  private campaignAction(act: 'left' | 'right' | 'up' | 'down' | 'ok' | 'cancel'): void {
    const { count } = this.getBossRange(this.battleAN);
    switch (act) {
      case 'up':
      case 'down':
        // 自由模式: 上下切换焦点 (af 0战役点/1敌将面板)
        if (this.gameModeT === 1) {
          this.focusAf = this.focusAf === 0 ? 1 : 0;
        }
        break;
      case 'right':
        if (this.gameModeT === 1 && this.focusAf === 0) {
          this.stepBattle(1);
        } else {
          this.bossSlotAg++;
          if (this.bossSlotAg >= count) this.bossSlotAg = 0;
        }
        break;
      case 'left':
        if (this.gameModeT === 1 && this.focusAf === 0) {
          this.stepBattle(-1);
        } else {
          this.bossSlotAg--;
          if (this.bossSlotAg < 0) this.bossSlotAg = count - 1;
        }
        break;
      case 'ok':
        // 确定软键即开始 (原版: 无"开始游戏"文字)
        if (this.gameModeT === 1 && !this.isBattleSelectable(this.battleAN)) {
          this.uiSystem.showMessage('该战役尚未解锁', 60);
          return;
        }
        this.startBattle(this.battleAN);
        break;
      case 'cancel':
        // 原版 u() -7: aO=0, aN=0; t1089(胜利后)→B()回标题, 否则→l=17
        this.campaignAO = 0;
        this.battleAN = 0;
        if (this.afterVictoryT1089) {
          this.afterVictoryT1089 = false;
          this.gotoTitle();
        } else {
          this.state = GameState.UPGRADE_SELECT;
        }
        break;
    }
  }

  /** 自由模式战役切换: 只停在可选 (已解锁+下一个) 的战役上 */
  private stepBattle(dir: number): void {
    let next = this.battleAN;
    for (let i = 0; i < 9; i++) {
      next += dir;
      if (next > 8) next = 0;
      if (next < 0) next = 8;
      if (this.isBattleSelectable(next)) {
        this.battleAN = next;
        this.bossSlotAg = 0;
        return;
      }
    }
  }

  // ============================================================
  // 设置页 (原版 a(8) 音量设置的H5简化版: 声音开/关)
  // ============================================================
  private handleSettingsTap(x: number, y: number, softLeft: boolean, softRight: boolean): void {
    if (softLeft) { this.settingsAction('ok'); return; }
    if (softRight) { this.settingsAction('cancel'); return; }
    // 声音行区域: 点击切换
    if (y >= 118 && y <= 146) {
      this.settingsAction('toggle');
    }
  }

  private settingsAction(act: 'toggle' | 'ok' | 'cancel'): void {
    switch (act) {
      case 'toggle':
        this.soundEnabled = !this.soundEnabled;
        if (!this.soundEnabled) this.audioSystem.stop();
        else this.playMusic('./mid/7.mid');
        break;
      case 'ok':
        this.persistSoundSetting();
        this.gotoTitle();
        break;
      case 'cancel':
        this.persistSoundSetting();
        this.gotoTitle();
        break;
    }
  }

  // ====== 存档面板点击处理 (新流程无入口, 保留) ======
  private handleSavePanelTap(x: number, y: number): void {
    // 4个存档槽纵向排列
    const startY = 60;
    const itemH = 40;
    for (let i = 0; i < 4; i++) {
      const iy = startY + i * itemH;
      if (x >= 20 && x <= 220 && y >= iy && y <= iy + itemH) {
        this.saveSlot = i;
        // 尝试读取该槽位存档
        const data = this.saveSystem.load();
        if (data) {
          this.loadFromSaveData(data);
        } else {
          this.uiSystem.showMessage(`存档槽 ${i + 1} 为空`);
        }
        return;
      }
    }
    // 返回按钮
    if (x >= 0 && x <= 60 && y >= 0 && y <= 20) {
      this.gotoTitle();
    }
  }

  /**
   * 从存档数据恢复游戏 (含战役进度 X/ac/T/aO/d1073)
   */
  private loadFromSaveData(data: any): void {
    if (!data) return;
    this.levelIndex = data.levelIndex ?? 0;
    this.currentLevel = data.level ?? 0;
    this.gold = data.gold ?? 300;
    this.lives = data.lives ?? 10;
    this.totalKills = data.stats?.totalKills ?? 0;
    this.totalGoldEarned = data.stats?.totalGoldEarned ?? 0;
    this.playTime = data.stats?.playTime ?? 0;
    // 恢复战役进度 (新增字段, 旧存档缺省)
    this.factionX = data.factionX ?? 0;
    this.upgradeAc = data.upgradeAc ?? 0;
    this.gameModeT = data.gameModeT ?? 0;
    this.campaignAO = data.campaignAO ?? 0;
    this.unlockedD1073 = Array.isArray(data.unlockedBattles)
      ? [...data.unlockedBattles]
      : new Array(9).fill(false);
    this.battleAN = this.currentLevel >= 0 && this.currentLevel <= 8 ? this.currentLevel : 0;
    this.k1029 = this.gameModeT === 1;
    this.techTree.setFaction(this.factionX as Faction);
    // 恢复科技树
    if (data.tech) {
      this.techTree.restoreFromSave(data.tech);
    }
    // 恢复塔布局
    if (data.towers) {
      this.towerSystem.restoreFromSave(data.towers);
    }
    // 任务B-4: 恢复科技建筑层 (原版 a1056/b1059/e1105, 旧存档缺省)
    this.buildBar.restoreSaveState({
      techBuilt: data.techBuildings,
      castleParts: data.castleParts,
      towerUnlocked: data.unlockedTowers,
    });
    this.castleRenderer.setOurPartFilter(this.buildBar.castlePartFilter());
    // 加载关卡 (resetTech=false: 保留刚恢复的科技建筑层)
    this.startLevel(this.currentLevel, false);
  }

  /**
   * 开始指定关卡
   * loadLevel 内部会设置 state = LEVEL_INTRO, 不在此处覆盖
   * @param resetTech 是否重置科技建筑层 (读档恢复时为false, 避免覆盖刚恢复的 a1056/b1059/e1105)
   */
  private async startLevel(level: number, resetTech: boolean = true): Promise<void> {
    await this.loadLevel(level, resetTech);
    // 不再覆盖状态, loadLevel 会设置 LEVEL_INTRO
  }

  /**
   * 开始战役 (原版 u() 确定: P() 加载 → a(2) 战斗; H5经剧情卷轴 LEVEL_INTRO 进入)
   */
  private startBattle(aN: number): void {
    this.battleAN = aN;
    this.levelIndex = this.campaignAO;
    this.startLevel(aN);
  }

  /**
   * 继续游戏 (从存档)
   */
  private continueGame(): void {
    const summary = this.saveSystem.getSaveSummary();
    if (summary) {
      const data = this.saveSystem.load();
      if (data) {
        this.loadFromSaveData(data);
        return;
      }
    }
    // 无存档, 回标题
    this.gotoTitle();
  }

  /**
   * 结算点击 (原版 V() 行8955: 胜利→l=16, 失败→B()标题)
   */
  private handleLevelCompleteTap(): void {
    if (this.gameModeT === 0) {
      // 王者之路: 7战全部通关 → 结局动画; 否则回选择战役 (下一战役)
      if (this.campaignAO >= CAMPAIGN_ORDER_H1074[this.factionX].length) {
        this.triggerEndingAnim();
        return;
      }
      this.battleAN = CAMPAIGN_ORDER_H1074[this.factionX][this.campaignAO];
      this.bossSlotAg = 0;
      this.afterVictoryT1089 = true;
      this.state = GameState.CAMPAIGN_SELECT;
    } else {
      // 自由模式: 打完回选择战役
      this.afterVictoryT1089 = true;
      this.state = GameState.CAMPAIGN_SELECT;
    }
  }

  /**
   * 处理按钮点击
   * 任务A: 旧快捷建造/面板按钮已移除, 建造/升级走 BuildBarSystem (原版底部栏)
   */
  private handleButton(btn: Button): void {
    switch (btn.action) {
      case 'show_tech':
        this.uiSystem.showTechPanel();
        break;
      case 'close_tech':
        this.uiSystem.hideTechPanel();
        break;
      // ====== 科技树翻页按钮处理 ======
      case 'tech_prev_page':
        this.uiSystem.techPrevPage();
        break;
      case 'tech_next_page':
        this.uiSystem.techNextPage();
        break;
      case 'close':
      case 'cancel':
        this.towerSystem.exitBuildMode();
        this.buildBar.close();
        break;
      // ====== 游戏控制按钮处理 (对应原版 handleVolumeInput) ======
      case 'pause':
        this.uiSystem.togglePause();
        break;
      case 'speed_up':
        this.uiSystem.cycleGameSpeed();
        this.uiSystem.showMessage(`速度: ${this.uiSystem.getGameSpeed()}x`, 30);
        break;
      case 'menu':
        // 打开暂停菜单
        this.uiSystem.setPaused(true);
        break;
      case 'resume':
        this.uiSystem.setPaused(false);
        break;
      case 'restart':
        this.uiSystem.setPaused(false);
        this.restartLevel();
        break;
      case 'back_to_menu':
        this.uiSystem.setPaused(false);
        this.gotoTitle();
        break;
      case 'save_game':
        this.autoSave();
        this.uiSystem.showMessage('已保存', 60);
        break;
    }
  }

  /**
   * 选位模式下方向键移动建筑方框并同步幻影 (原版 bN/bO + am() 预览同步)
   */
  private moveBoxAndGhost(dx: number, dy: number): void {
    this.mapData.moveBox(dx, dy);
    const bt = this.mapData.getBuildingBoxTile();
    this.towerSystem.setBuildPosition(bt.tx, bt.ty);
  }

  /**
   * 调整大小
   */
  resize(): void {
    this.renderer.resize();
    this.updateMapOffset();
  }

  /**
   * 更新地图偏移 (相机系统)
   * 原版中地图不是居中显示, 而是通过相机滚动查看大地图
   */
  private updateMapOffset(): void {
    // 相机系统接管, 不再使用固定偏移
    // mapOffsetX/Y 保留用于兼容性, 但实际渲染使用 MapData.cameraX/Y
    this.mapOffsetX = 0;
    this.mapOffsetY = MAP_TOP_BAR_H;
  }

  /**
   * 加载关卡
   */
  /**
   * 加载关卡
   * @param resetTech 是否重置科技建筑层 (新战斗=true 对应原版 aj(); 读档=false)
   */
  async loadLevel(level: number, resetTech: boolean = true): Promise<void> {
    this.currentLevel = level;
    await this.mapData.loadLevel(level);

    this.enemySystem.setLevel(level);
    this.enemySystem.reset();
    this.towerSystem.setGold(this.gold);
    this.towerSystem.setMapLevel(level); // 原版 aN, 建造范围圈颜色 l1116[aN] 用
    this.techTree.setGold(this.gold);

    // 任务B: 新战斗重置科技建筑层 (原版 aj() 行14095-14141:
    //   a1056全false, b1059=c1061初始部件, e1105仅弓手塔解锁)
    if (resetTech) {
      this.buildBar.reset();
    }
    this.towerSystem.exitBuildMode();
    // 我城部件过滤接 b1059 (原版 m() 行23514)
    this.castleRenderer.setOurPartFilter(this.buildBar.castlePartFilter());

    // 城防 (对应原版 by, aj() 初始化为10)
    this.lives = 10;

    // 播放对应关卡的MIDI音乐 (k1068[mapLevel], 每关音乐索引 — 推断)
    const mapLevel = level <= 8 ? level : level % 9;
    const midiFile = `./mid/${LEVEL_MUSIC_K1068[mapLevel] ?? 0}.mid`;
    this.playMusic(midiFile);

    // 进入关卡剧情阶段 (对应原版 state 23)
    this.state = GameState.LEVEL_INTRO;
    this.introTimer = 0;
    this.introPhase = 0;
  }

  // ====== 触发结局动画 (对应原版 state 46/47/48) ======
  private triggerEndingAnim(): void {
    this.currentEnding = FACTION_ENDINGS[this.factionX] ?? FACTION_ENDINGS[0];
    this.endingPhase = EndingAnimPhase.FADE_IN;
    this.endingFrame = 0;
    this.endingAlpha = 0;
    this.state = GameState.ENDING_ANIM;
    // 播放胜利音乐
    this.playMusic('./mid/14.mid');
  }

  // ====== 推进结局动画到下一阶段 ======
  private advanceEndingPhase(): void {
    this.endingPhase++;
    this.endingFrame = 0;
    if (this.endingPhase >= EndingAnimPhase.DONE) {
      // 结局动画完成, 进入VICTORY状态
      this.state = GameState.VICTORY;
    }
  }

  // ====== 更新结局动画 (对应原版 renderEndingAnim 的帧逻辑) ======
  private updateEndingAnim(dt: number): void {
    this.endingFrame += dt;
    const phaseIdx = this.endingPhase;
    const phaseDuration = this.endingPhaseFrames[phaseIdx] ?? 60;

    // 淡入淡出 alpha 计算
    if (this.endingPhase === EndingAnimPhase.FADE_IN) {
      this.endingAlpha = Math.min(255, Math.floor((this.endingFrame / phaseDuration) * 255));
    } else if (this.endingPhase === EndingAnimPhase.FADE_OUT) {
      this.endingAlpha = Math.max(0, 255 - Math.floor((this.endingFrame / phaseDuration) * 255));
    } else {
      this.endingAlpha = 255;
    }

    // 阶段超时自动推进
    if (this.endingFrame >= phaseDuration) {
      this.advanceEndingPhase();
    }
  }

  // ====== 重新开始当前关卡 ======
  private async restartLevel(): Promise<void> {
    // 保留科技树和金币 (仅重置当前关卡布局)
    this.towerSystem.reset();
    await this.loadLevel(this.currentLevel);
  }

  /**
   * 游戏主循环
   */
  private gameLoop = (timestamp: number): void => {
    const dt = Math.min(33, timestamp - this.lastTime) / 16.67; // 归一化到60fps
    this.lastTime = timestamp;
    this.frameCount++;

    if (this.state === GameState.PLAYING && !this.uiSystem.isPaused()) {
      const speed = this.uiSystem.getGameSpeed();
      for (let i = 0; i < speed; i++) {
        this.update(dt);
      }
    } else if (this.state === GameState.LEVEL_INTRO) {
      this.updateLevelIntro(dt);
    } else if (this.state === GameState.ENDING_ANIM) {
      this.updateEndingAnim(dt);
    } else if (this.state === GameState.LOGO_ANIM) {
      this.updateLogoAnim(dt);
    } else if (this.state === GameState.LOADING_SCREEN) {
      this.updateLoadingScreen(dt);
    } else if (this.state === GameState.TITLE_MENU) {
      this.updateTitleMenu(dt);
    } else if (this.state === GameState.COUNTRY_SELECT) {
      this.updateMenuBackground();
    } else if (this.state === GameState.UPGRADE_SELECT) {
      this.updateMenuBackground();
      this.updateUpgradeSelect();
    } else if (this.state === GameState.CAMPAIGN_SELECT) {
      this.updateMenuBackground();
    } else if (this.state === GameState.SETTINGS) {
      this.updateMenuBackground();
    }
    this.render();

    requestAnimationFrame(this.gameLoop);
  };

  /**
   * 更新游戏状态
   */
  private update(dt: number): void {
    this.playTime += dt * 16.67 / 1000;
    this.totalKills = this.enemySystem.killed;

    // 更新相机 (平滑滚动到目标位置)
    this.mapData.updateCamera();

    // 原版底部建造栏滑入滑出 (原版 K() 行8146)
    this.buildBar.update();

    this.enemySystem.update(dt);
    this.towerSystem.update(this.enemySystem.getActiveEnemies(), 0, MAP_TOP_BAR_H);

    // 过关判定 (对应原版 G() case2 行7492-7527:
    //   aS==l1072[aN] 且 场上无敌 且 本波已刷完 且 城防>0)
    if (this.enemySystem.isLevelComplete && this.lives > 0) {
      // 原版: 王者之路(T=0) aO+1 且 d1073[aN]=true; 自由模式仅解锁
      this.unlockedD1073[this.battleAN] = true;
      if (this.gameModeT === 0) {
        this.campaignAO++;
      }
      this.gold += 1000; // 通关奖励
      this.totalGoldEarned += 1000;
      // 先存档再切状态 (autoSave 仅在 PLAYING 生效)
      this.autoSave();
      this.state = GameState.LEVEL_COMPLETE;
    }

    this.uiSystem.update();
    this.saveSystem.updateAutoSave(dt, () => this.autoSave());
  }

  /**
   * 更新关卡剧情阶段 (对应原版 state 23 的 ad() 方法)
   * 原版流程:
   *   Phase 1 (br=1): 滚动动画, 文字面板从中心展开
   *   Phase 2 (br=2): 等待玩家确认, 每次确认显示下一行文本 (bs 0→3)
   *   bs > 3 时开始游戏
   */
  private updateLevelIntro(dt: number): void {
    this.introTimer += dt;
    this.mapData.updateCamera();

    // 阶段0: 滚动展开动画 (约1秒)
    if (this.introPhase === 0) {
      this.introAnimProgress = Math.min(1, this.introTimer / 60);
      if (this.introAnimProgress >= 1) {
        this.introPhase = 1;
        this.introTimer = 0;
      }
    }
  }

  /**
   * 结束剧情阶段, 开始游戏
   */
  private endLevelIntro(): void {
    this.state = GameState.PLAYING;
    this.enemySystem.startLevel();
  }

  /**
   * 获取当前关卡剧情文本 (对应原版 b1015[bs+171], 每页前缀君主名)
   * 原版4行文本: 游戏说明、升级说明、失败条件、操作说明
   * 君主名: 刘备/曹操/孙权 按 X (b1015[28/39/50] = HEROES[X*11])
   */
  private getIntroStoryLines(): string[] {
    const monarch = HEROES[this.factionX * 11]?.name ?? '刘备';
    return [
      `${monarch}：${GAME_HELP_TEXT.description}`,
      `${monarch}：${GAME_HELP_TEXT.upgrade}`,
      `${monarch}：${GAME_HELP_TEXT.failCondition}`,
      `${monarch}：${GAME_HELP_TEXT.controls}`,
    ];
  }

  /**
   * 自动存档 (含战役进度 X/ac/T/aO/d1073 新字段)
   */
  private autoSave(): void {
    if (this.state !== GameState.PLAYING) return;
    const saveData = this.saveSystem.createSaveData(
      this.levelIndex,
      this.currentLevel,
      this.gold,
      this.lives,
      this.techTree,
      this.towerSystem.getTowers(),
      { totalKills: this.totalKills, totalGoldEarned: this.totalGoldEarned, playTime: this.playTime },
    );
    // 战役进度新字段 (不动旧字段)
    saveData.factionX = this.factionX;
    saveData.upgradeAc = this.upgradeAc;
    saveData.gameModeT = this.gameModeT;
    saveData.campaignAO = this.campaignAO;
    saveData.unlockedBattles = [...this.unlockedD1073];
    // 任务B-4: 科技建筑层存档 (原版 a1056/b1059/e1105)
    const barState = this.buildBar.getSaveState();
    saveData.techBuildings = barState.techBuilt;
    saveData.castleParts = barState.castleParts;
    saveData.unlockedTowers = barState.towerUnlocked;
    this.saveSystem.save(saveData);
  }

  // ============================================================
  // 开场 LOGO 动画 (原版 l=0: x() 行26145 布局 / y() 行26190 渲染, 35帧)
  // H5简化: sflogo_0 主标帧动画 + sflogo_2/3/4 三行字依次淡入, 1.5秒或可点击跳过
  // ============================================================
  private updateLogoAnim(_dt: number): void {
    this.logoFrame++;
    if (this.logoFrame >= 90) {
      this.startLoadingScreen();
    }
  }

  /** 进入加载进度屏 (原版 k(): 资源加载 + e() 进度 → l=18) */
  private startLoadingScreen(): void {
    if (this.state === GameState.LOADING_SCREEN) return;
    this.state = GameState.LOADING_SCREEN;
    this.loadingProgress = 0;
    // 地图图集在此阶段加载 (对应原版 c(int) 加载图集包)
    if (!this.atlasesPromise) {
      this.atlasesPromise = this.mapData.preloadAtlases().then(() => {
        this.atlasesReady = true;
      });
    }
  }

  /** 加载进度屏更新: 进度满且图集就绪 → l=18 声音询问 */
  private updateLoadingScreen(dt: number): void {
    this.loadingProgress = Math.min(1, this.loadingProgress + dt / 60);
    if (this.loadingProgress >= 1 && this.atlasesReady) {
      this.state = GameState.SOUND_PROMPT;
    }
  }

  /**
   * 渲染
   */
  private render(): void {
    this.renderer.clear(COLORS.BACKGROUND);

    switch (this.state) {
      case GameState.LOGO_ANIM:
        this.renderLogoAnim();
        break;
      case GameState.LOADING_SCREEN:
        this.renderLoadingScreen();
        break;
      case GameState.SOUND_PROMPT:
        this.renderSoundPrompt();
        break;
      case GameState.TITLE_MENU:
        this.renderTitleMenu();
        break;
      case GameState.COUNTRY_SELECT:
        this.renderCountrySelect();
        break;
      case GameState.UPGRADE_SELECT:
        this.renderUpgradeSelect();
        break;
      case GameState.CAMPAIGN_SELECT:
        this.renderCampaignSelect();
        break;
      case GameState.SETTINGS:
        this.renderSettings();
        break;
      case GameState.HELP:
        this.renderTextPage('游戏帮助', GAME_DESCRIPTION_TEXT);
        break;
      case GameState.CREDITS:
        this.renderTextPage('关于', COPYRIGHT_TEXT);
        break;
      case GameState.LEVEL_INTRO:
        this.renderLevelIntro();
        break;
      case GameState.PLAYING:
      case GameState.PAUSED:
        this.renderPlaying();
        break;
      case GameState.SAVE_PANEL:
        this.renderSavePanel();
        break;
      case GameState.GAME_OVER:
        this.renderGameOver();
        break;
      case GameState.VICTORY:
        this.renderVictory();
        break;
      case GameState.LEVEL_COMPLETE:
        this.renderLevelComplete();
        break;
      case GameState.ENDING_ANIM:
        this.renderEndingAnim();
        break;
      case GameState.TECH_TREE_BROWSE:
        // 科技树浏览叠加在游戏画面上
        this.renderPlaying();
        break;
      default:
        break;
    }

    this.renderer.present();
  }

  // ============================================================
  // 开场 LOGO 渲染 (原版 y() 行26190 的H5简化版)
  // ============================================================
  private renderLogoAnim(): void {
    const r = this.renderer;
    r.setColor(0xFFFFFF);
    r.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    // 主标 sflogo_0 (228x51 = 4帧57x51) 帧动画居中
    const logo = this.spr('sflogo', 0);
    if (logo) {
      const frame = (this.logoFrame >> 3) % 4;
      r.drawImageRegion(logo, frame * 57, 0, 57, 51, (240 - 57) >> 1, 96, 57, 51);
    }
    // 三行字 sflogo_2/3/4 (68x18) 依次淡入
    for (let i = 0; i < 3; i++) {
      const img = this.spr('sflogo', 2 + i);
      if (!img) continue;
      const appear = (this.logoFrame - (20 + i * 18)) / 16;
      if (appear <= 0) continue;
      r.setAlpha(Math.min(1, appear));
      r.drawImage(img, (240 - 68) >> 1, 164 + i * 26);
      r.setAlpha(1);
    }
    // 跳过提示
    if ((this.frameCount & 31) < 20) {
      r.drawText('点击跳过', 102, 292, 0x999999, 9);
    }
  }

  // ============================================================
  // 加载进度屏 (原版 k() 中 e() 进度: 白底 + ld_0框 + ld_1裁剪填充)
  // ============================================================
  private renderLoadingScreen(): void {
    const r = this.renderer;
    r.setColor(0xFFFFFF);
    r.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    // ld_1(28x44) 按进度从下往上裁剪填充
    const ld1 = this.spr('ld', 1);
    if (ld1) {
      const h = Math.floor(44 * this.loadingProgress);
      if (h > 0) {
        r.drawImageRegion(ld1, 0, 44 - h, 28, h,
          (240 - 28) >> 1, ((320 - 44) >> 1) + 44 - h, 28, h);
      }
    }
    // ld_0(48x48) 居中框
    const ld0 = this.spr('ld', 0);
    if (ld0) r.drawImage(ld0, (240 - 48) >> 1, (320 - 48) >> 1);
  }

  // ============================================================
  // 声音询问 (原版 h() 行21381)
  // ============================================================
  private renderSoundPrompt(): void {
    const r = this.renderer;
    r.setColor(0xFFFFFF);
    r.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    // b1015[104] "是否开启声音" 居中
    const question = '是否开启声音';
    r.drawText(question, (240 - question.length * 12) >> 1, (320 - 12) >> 1, 0xE25A80, 12);
    // b1015[105] 开启 (左下) / b1015[106] 取消 (右下)
    r.drawText('开启', 8, 290, 0x53678A, 11);
    r.drawText('取消', 240 - 8 - 22, 290, 0x53678A, 11);
    this.uiSystem.renderSoftkeyBar(SOFTKEY_OK, SOFTKEY_CANCEL);
  }

  // ============================================================
  // 共用菜单背景 (对应原版 b(int,int) 行15961)
  // 白底 + back[4]/back[5] 底部平铺 + back[6] 云带 + back[0..3] 底部装饰带
  // ============================================================
  private renderCommonBackground(off: number, cloudY: number): void {
    const r = this.renderer;
    r.setColor(0xFFFFFF);
    r.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);
    this.renderBgTiles(240 - off);
    this.renderBgClouds(cloudY);
    for (let i = 0; i < 3; i++) {
      this.renderBgStrip(this.bgW + i * 176, this.bgX - off);
    }
  }

  /** back[4]/back[5] 平铺 (对应原版 e(int,int) 行19287, 15列) */
  private renderBgTiles(y: number): void {
    const r = this.renderer;
    const back4 = this.spr('back', 4);
    const back5 = this.spr('back', 5);
    for (let i = 0; i < 15; i++) {
      if (back4) r.drawImage(back4, this.bgT + i * 83, y - 38);
      if (back5) r.drawImage(back5, this.bgT + i * 83, y);
    }
  }

  /** back[6] 云带 (对应原版 d(int) 行18699, 3列) */
  private renderBgClouds(y: number): void {
    const back6 = this.spr('back', 6);
    if (!back6) return;
    for (let i = 0; i < 3; i++) {
      this.renderer.drawImage(back6, this.bgU + i * 176, this.bgV + y);
    }
  }

  /** back[1]/back[2]/back[0]/back[3] 组合底边 (对应原版 d(int,int) 行18719) */
  private renderBgStrip(x: number, y: number): void {
    const r = this.renderer;
    const back1 = this.spr('back', 1);
    const back2 = this.spr('back', 2);
    const back0 = this.spr('back', 0);
    const back3 = this.spr('back', 3);
    if (back1) r.drawImage(back1, x, y - 19);
    if (back2) r.drawImage(back2, x + 32, y - 77);
    if (back0) r.drawImage(back0, x + 51, y - 30);
    if (back3) r.drawImage(back3, x + 51 + 18 + 15, y - 26);
    r.setColor(0xE25A80);
    r.fillRect(0, y, 240, 20);
  }

  /** 面板横条 (对应原版 a(Image,int,int,int,boolean) 行11470: 底色 + 左图 + 右镜像) */
  private renderPanelStrip(img: HTMLImageElement | null, y: number, color: number): void {
    if (!img) return;
    const r = this.renderer;
    r.setColor(color);
    r.fillRect(0, y, LOGICAL_WIDTH, img.height);
    r.drawImage(img, 0, y);
    r.drawImageFlipped(img, LOGICAL_WIDTH - img.width, y, true);
  }

  /** ◀▶ 闪烁箭头 (对应原版 d(int,int,int) 行18758) */
  private renderArrows(xL: number, xR: number, y: number): void {
    const ui24 = this.spr('ui', 24);
    if (!ui24) return;
    const blink = (Math.floor(this.frameCount / 12) & 1) << 1; // 原版 a1019&1 (10FPS→200ms一闪)
    this.renderer.drawImage(ui24, xL + blink, y);
    this.renderer.drawImageFlipped(ui24, xR - blink, y, true);
  }

  /** 顶部标题 back[25] 帧 (47x11, 对应原版 c(int,int,int) 行17241) */
  private renderTitleFrame(frame: number): void {
    const back25 = this.spr('back', 25);
    if (back25) {
      this.renderer.drawImageRegion(back25, 0, frame * 11, 47, 11, (240 - 47) >> 1, 0, 47, 11);
    }
  }

  /** 标签盒 + back[17] 帧标签 (对应原版 a(int×6) 行10685) */
  private renderLabelBox(x: number, y: number, w: number, frame: number): void {
    const r = this.renderer;
    r.setColor(0xFCFFCD);
    r.fillRect(x, y, w, MENU_FONT_H + 1);
    r.setColor(0x53678A);
    r.drawRect(x, y, w, MENU_FONT_H + 1);
    const label = this.spr('back', 17);
    if (label) r.drawImageRegion(label, 0, frame * 12, 20, 12, x - 5, y - 2, 20, 12);
  }

  // ============================================================
  // 标题主菜单渲染 (原版 l() 行22601)
  // ============================================================
  private renderTitleMenu(): void {
    const r = this.renderer;
    r.setColor(0xFFFFFF);
    r.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);
    this.renderBgTiles(240);
    if (this.titleM === 0) {
      this.renderExitThanks();
      return;
    }
    this.renderBgClouds(0);

    const mu = (i: number) => this.spr('mu', i);
    // 龙logo mu[4] (M>=2)
    if (this.titleM >= 2) {
      const logo = mu(4);
      if (logo) r.drawImage(logo, this.posY, this.posZ);
    }
    // 底部装饰带
    for (let i = 0; i < 3; i++) {
      this.renderBgStrip(this.bgW + i * 176, this.bgX);
    }

    if (this.titleM >= 3) {
      // mu[5] 竖幅 (从顶落下)
      if (this.flagH) {
        const img = mu(5);
        if (img) r.drawImage(img, this.posG, this.posH);
      }
      // mu[0]/mu[1] (摇摆)
      if (this.flagJ) {
        const m0 = mu(0);
        if (m0) r.drawImage(m0, this.posA, this.posB);
        const m1 = mu(1);
        if (m1) r.drawImage(m1, this.posC, this.posD);
      }
      // mu[2] (38x36, 半帧动画)
      if (this.flagG) {
        const m2 = mu(2);
        if (m2) r.drawImageRegion(m2, (this.animR - 1) * 19, 0, 19, 36, this.posE, this.posF, 19, 36);
      }
      // 花装饰 mu[9/10/11] + mu[7]/mu[8] 动画
      if (this.flagF) {
        const bx = this.posA + 16;
        const by = this.posB + 44 - 14;
        for (let i = 0; i < this.titleS; i++) {
          const img = mu(9 + i);
          if (img) r.drawImage(img, bx, by);
        }
        if (this.flagD) {
          const m7 = mu(7);
          if (m7) r.drawImageRegion(m7, (this.animP - 1) * 19, 0, 19, 35, bx + 36 - 6, by + 4, 19, 35);
        }
        if (this.flagE2) {
          const m8 = mu(8);
          if (m8) r.drawImageRegion(m8, (this.animQ - 1) * 26, 0, 26, 8, bx - 15, by + 50, 26, 8);
        }
      }
      // mu[6] "三国群英"竖幅 (从左滑入)
      if (this.flagI) {
        const m6 = mu(6);
        if (m6) r.drawImage(m6, this.posI, this.posJ);
      }
    }

    if (this.titleM === 5) {
      // 底条 mu[3] (88x13, 左侧 + 右侧镜像)
      const m3 = mu(3);
      if (m3) {
        r.drawImage(m3, 0, this.posL);
        r.drawImageFlipped(m3, 240 - 88, this.posL, true);
      }
      // 菜单项 back[25] 第 r 帧 (47x11) 居中于底条
      const back25 = this.spr('back', 25);
      if (back25) {
        r.drawImageRegion(back25, 0, this.menuR * 11, 47, 11, this.posK, this.posL + 1, 47, 11);
      }
      // 左右 ui[24] ◀▶ 闪烁
      const ui24 = this.spr('ui', 24);
      if (ui24) {
        const blink = (Math.floor(this.frameCount / 12) & 1) << 1; // 原版 a1019&1 (10FPS→200ms一闪)
        r.drawImage(ui24, this.posK - 20 + blink, this.posL + 1);
        r.drawImageFlipped(ui24, this.posK + 47 + 20 - 6 - blink, this.posL + 1, true);
      }
      // 软键区: ui[2] 帧2 (确定)
      const ui2 = this.spr('ui', 2);
      if (ui2) r.drawImageRegion(ui2, 0, 20, 18, 10, 1, this.posL + 3, 18, 10);
    }

    this.renderExitThanks();
  }

  /** "感谢游玩"覆盖层 (退出选项, 浏览器环境) */
  private renderExitThanks(): void {
    if (!this.exitThanks) return;
    const r = this.renderer;
    r.setColor(0x000000);
    r.fillRect(30, 130, 180, 60);
    r.setColor(0xFCFFCD);
    r.drawRect(30, 130, 180, 60);
    r.drawText('感谢游玩', 96, 146, 0xFCFFCD, 14);
    r.drawText('点击返回', 100, 168, 0xAAAAAA, 9);
  }

  // ============================================================
  // 选择国家渲染 (原版 q() 行23981)
  // ============================================================
  private renderCountrySelect(): void {
    const r = this.renderer;
    this.renderCommonBackground(COUNTRY_PANEL_H, 13);
    const lay = this.countryLayout();
    // 顶部 ui[3] 面板条 (先画横条, 标题帧后画覆盖其上)
    this.renderPanelStrip(this.spr('ui', 3), 0, 0xCD3E7E);
    // 顶部标题 back[25] 帧7
    this.renderTitleFrame(7);
    // 中国地图 back[7] (190x126) 居中
    const map = this.spr('back', 7);
    r.setClip(0, 13, 240, COUNTRY_MAP_H);
    if (map) r.drawImage(map, lay.mapX, lay.mapY);
    r.resetClip();
    // 三国标记: 选中 back[10] / 未选 back[11] (各3帧19x19, 帧=国序)
    for (let i = 0; i < 3; i++) {
      const marker = this.spr('back', this.factionX === i ? 10 : 11);
      const mx = lay.mapX + COUNTRY_POS_A1028[i][0];
      const my = lay.mapY + COUNTRY_POS_A1028[i][1];
      if (marker) r.drawImageRegion(marker, i * 19, 0, 19, 19, mx, my, 19, 19);
      // 选中国加圈 back[13] (25x25)
      if (this.factionX === i) {
        const circle = this.spr('back', 13);
        if (circle) r.drawImage(circle, mx + ((19 - 25) >> 1), my + ((19 - 25) >> 1));
      }
    }
    // 右下君主画像 back[14+X]
    const ruler = this.spr('back', 14 + this.factionX);
    if (ruler) {
      r.drawImage(ruler, lay.mapX + 176 - ruler.width + 20, 310 - COUNTRY_PANEL_H - ruler.height);
    }
    // ui[6] 分割条 + 米色区
    this.renderPanelStrip(this.spr('ui', 6), lay.stripY, 0xB7438D);
    r.setColor(0xEBD5AD);
    r.fillRect(0, lay.beigeY, 240, 25);
    // 中部选择条 back[8] (52x44) + back[12] 国名竖字 (3帧18x36) + ◀▶
    const bar = this.spr('back', 8);
    if (bar) r.drawImage(bar, lay.barX, lay.barY);
    const nameImg = this.spr('back', 12);
    if (nameImg) {
      r.drawImageRegion(nameImg, this.factionX * 18, 0, 18, 36,
        lay.barX + ((52 - 18) >> 1), lay.barY + ((52 - 36) >> 1) + 4, 18, 36);
    }
    this.renderArrows(lay.bR, lay.bS, lay.bT);
    // 说明面板
    r.setColor(0xFCFFCD);
    r.fillRect(0, lay.beigeY + 25, 240, COUNTRY_PANEL_H - 32);
    // 都城/君主 标签盒 (back[17] 帧0/帧1)
    this.renderLabelBox(10, lay.beigeY + 6, 63, 0);
    this.renderLabelBox(167, lay.beigeY + 6, 63, 1);
    // 都城名 CAPITAL_NAMES[X] / 君主名 (刘备/曹操/孙权, b1015[X*11+28])
    r.drawText(CAPITAL_NAMES[this.factionX], 28, lay.beigeY + 8, 0xD5317A, 11);
    r.drawText(HEROES[this.factionX * 11]?.name ?? '', 186, lay.beigeY + 8, 0xD5317A, 11);
    // 国家说明 FACTION_DESCRIPTIONS[X] (b1015[76+X])
    this.drawWrappedText(FACTION_DESCRIPTIONS[this.factionX], 8, lay.beigeY + 35, 224, 11, 0x506E91, 10);
    // 软键: 确定(左)+取消(右)
    this.uiSystem.renderSoftkeyBar(SOFTKEY_OK, SOFTKEY_CANCEL);
  }

  // ============================================================
  // 升级模式渲染 (原版 s() 行24545)
  // ============================================================
  private renderUpgradeSelect(): void {
    const r = this.renderer;
    this.renderCommonBackground(UPGRADE_PANEL_H, 13);
    // 顶部 ui[3] 面板条 (先画横条, 标题帧后画覆盖其上)
    this.renderPanelStrip(this.spr('ui', 3), 0, 0xCD3E7E);
    // 标题 back[25] 帧9
    this.renderTitleFrame(9);
    // 卡片 back[18] (56x70 武系) / back[19] (59x56 文系)
    const cardWu = this.spr('back', 18);
    if (cardWu) r.drawImage(cardWu, this.cardY, this.cardZ);
    const cardWen = this.spr('back', 19);
    if (cardWen) r.drawImage(cardWen, this.cardAa, this.cardAb);
    // 底部米色区 + ui[6] 分割条
    const bottomY = 320 - UPGRADE_PANEL_H;
    r.setColor(0xEBD5AD);
    r.fillRect(0, bottomY, 240, UPGRADE_PANEL_H);
    this.renderPanelStrip(this.spr('ui', 6), bottomY, 0xB7438D);
    // 说明面板
    r.setColor(0xFCFFCD);
    r.fillRect(0, bottomY + 15, 240, UPGRADE_PANEL_H - 32);
    // back[17] 帧2 "说明"标签
    const label = this.spr('back', 17);
    if (label) r.drawImageRegion(label, 0, 24, 20, 12, 4, bottomY + 13, 20, 12);
    // 名称 BRANCH_NAMES[ac] 居中 + ◀▶
    const name = BRANCH_NAMES[this.upgradeAc];
    const nameW = name.length * 11;
    const nameX = (240 - nameW - 2) >> 1;
    const nameY = 320 - UPGRADE_PANEL_H - 13;
    r.drawText(name, nameX, nameY, 0x53678A, 11);
    this.renderArrows(nameX - 4 - 6, nameX + nameW + 2 + 4, nameY + 1);
    // 说明 BRANCH_DESCRIPTIONS[ac] (b1015[ac+81])
    this.drawWrappedText(BRANCH_DESCRIPTIONS[this.upgradeAc], 8, bottomY + 27, 224, 11, 0x506E91, 10);
    // 软键: 确定(左)+取消(右)
    this.uiSystem.renderSoftkeyBar(SOFTKEY_OK, SOFTKEY_CANCEL);
  }

  // ============================================================
  // 选择战役渲染 (原版 v() 行25285)
  // ============================================================
  private renderCampaignSelect(): void {
    const r = this.renderer;
    this.renderCommonBackground(CAMPAIGN_BOTTOM_H, 13);
    const lay = this.campaignLayout();
    // 顶部 ui[3] 面板条 (先画横条, 标题帧后画覆盖其上, 与原版绘制顺序一致)
    this.renderPanelStrip(this.spr('ui', 3), 0, 0xCD3E7E);
    // 标题 back[25] 帧8
    this.renderTitleFrame(8);
    // 底部米色区
    r.setColor(0xEBD5AD);
    r.fillRect(0, 320 - CAMPAIGN_BOTTOM_H - 10, 240, CAMPAIGN_BOTTOM_H + 10);
    // 同一张 back[7] 地图
    const map = this.spr('back', 7);
    r.setClip(0, 13, 240, CAMPAIGN_MAP_H);
    if (map) r.drawImage(map, lay.mapX, lay.mapY);
    r.resetClip();
    // 9个战役点 back[20] (18x9=2帧9x9); 王者之路只显示当前国7战序列位置
    const points = this.spr('back', 20);
    const order = CAMPAIGN_ORDER_H1074[this.factionX];
    for (let i = 0; i < 9; i++) {
      if (this.gameModeT === 0 && !order.includes(i)) continue;
      if (!points) break;
      const px = lay.mapX + BATTLE_POS_B1030[i][0];
      const py = lay.mapY + BATTLE_POS_B1030[i][1];
      const selectable = this.isBattleSelectable(i);
      if (!selectable) r.setAlpha(0.35);
      r.drawImageRegion(points, 0, 0, 9, 9, px, py, 9, 9);
      if (!selectable) r.setAlpha(1);
    }
    // 当前选中点用第2帧闪烁
    if (points && (this.frameCount & 1) === 0) {
      r.drawImageRegion(points, 9, 0, 9, 9,
        lay.mapX + BATTLE_POS_B1030[this.battleAN][0],
        lay.mapY + BATTLE_POS_B1030[this.battleAN][1], 9, 9);
    }
    // ui[6] 分割条
    this.renderPanelStrip(this.spr('ui', 6), lay.stripY, 0xB7438D);
    // 右上"敌将"按钮 back[24] (58x15=2帧29x15, 帧=af) + ui[24]箭头
    const btnY = CAMPAIGN_MAP_H + 10;
    r.setColor(0xFCFFCD);
    r.fillRect(200, btnY, 40, 15);
    const btn = this.spr('back', 24);
    if (btn) r.drawImageRegion(btn, this.focusAf * 29, 0, 29, 15, 211, btnY, 29, 15);
    const ui24 = this.spr('ui', 24);
    if (ui24) {
      const blink = (Math.floor(this.frameCount / 12) & 1) << 1; // 原版 a1019&1 (10FPS→200ms一闪)
      // 原版: af=0 变换4 / af=1 变换6 (旋转箭头); H5近似: 下指/上指
      r.drawImageRotated(ui24, 202, btnY + 2 + blink, this.focusAf === 0 ? 1 : -1);
    }
    // 战役名 b1015[(aN<<1)+83] 居中
    const name = BATTLE_NAMES[this.battleAN] ?? '';
    const nameW = name.length * 11;
    const nameX = (240 - nameW - 2) >> 1;
    r.drawText(name, nameX, lay.nameY - 11, 0x53678A, 11);
    // 自由模式 (k1029): 战役名旁 ◀▶
    if (this.gameModeT === 1) {
      this.renderArrows(nameX - 4 - 6, nameX + nameW + 2 + 4, lay.nameY - 10);
    }
    // 说明面板 + back[17] 帧2 "说明"标签 + 战役说明 b1015[(aN<<1)+84]
    const panelY = 320 - BOSS_PANEL_H + 7 + 10;
    r.setColor(0xFCFFCD);
    r.fillRect(0, panelY, 240, BOSS_PANEL_H - 32);
    const label = this.spr('back', 17);
    if (label) r.drawImageRegion(label, 0, 24, 20, 12, 4, panelY - 4, 20, 12);
    this.drawWrappedText(BATTLE_STORIES[this.battleAN] ?? '', 8, panelY + 10, 224, 11, 0x506E91, 10);
    // 敌将面板 f(aN, x, y)
    this.renderBossPanel(lay.bossX, lay.bossY);
    // 软键: 确定(左)+取消(右)
    this.uiSystem.renderSoftkeyBar(SOFTKEY_OK, SOFTKEY_CANCEL);
  }

  // ============================================================
  // 敌将面板 (原版 f(int,int,int) 行20071)
  // ============================================================
  private renderBossPanel(bx: number, by: number): void {
    const r = this.renderer;
    // 场景缩略图 back[21] (432x41=9帧48x41, 帧=aN) + 边框
    r.setColor(0xFCFFCD);
    r.drawRect(bx, by, 48 + 3, 41 + 3);
    const thumb = this.spr('back', 21);
    if (thumb) r.drawImageRegion(thumb, this.battleAN * 48, 0, 48, 41, bx + 2, by + 2, 48, 41);
    // 四角 back[22] (13x15)
    const corner = this.spr('back', 22);
    if (corner) {
      r.drawImage(corner, bx - 3, by);
      r.drawImageFlipped(corner, bx + 48 - 7, by, true);
      r.drawImageFlipped(corner, bx - 3, by + 41 - 11, false, true);
      r.drawImageFlipped(corner, bx + 48 - 7, by + 41 - 11, true, true);
    }
    // 8个24x24槽 back[23] (4列网格)
    const slot = this.spr('back', 23);
    const { offset, count } = this.getBossRange(this.battleAN);
    const list = BOSS_LIST_Z1131[this.battleAN] ?? [];
    for (let i = 0; i < count; i++) {
      const sx = bx + 48 + 10 + (i & 3) * 24;
      const sy = by + (i >> 2) * 24;
      if (slot) r.drawImage(slot, sx, sy);
      // boss头像 = sp[z1131[aN][i+offset]]
      const face = this.spr('sp', list[i + offset]);
      if (face) r.drawImage(face, sx + 3, sy + 3);
    }
    // 选中槽 ag: 显示名字 b1015[hero+28] (=HEROES表)
    if (this.bossSlotAg < count) {
      const i = this.bossSlotAg;
      const sx = bx + 48 + 10 + (i & 3) * 24;
      const sy = by + (i >> 2) * 24;
      const name = HEROES[list[i + offset]]?.name ?? '';
      r.setColor(0xFCFFCD);
      r.fillRect(sx, sy + 20, name.length * 11, MENU_FONT_H);
      r.drawText(name, sx, sy + 20, 0x53678A, 11);
    }
  }

  // ============================================================
  // 设置页 (原版 a(8) 音量设置的H5简化版)
  // ============================================================
  private renderSettings(): void {
    const r = this.renderer;
    this.renderCommonBackground(COUNTRY_PANEL_H, 13);
    this.renderPanelStrip(this.spr('ui', 3), 0, 0xCD3E7E);
    r.drawText('设置', 108, 32, 0x53678A, 14);
    // 面板
    r.setColor(0xFCFFCD);
    r.fillRect(20, 100, 200, 60);
    r.setColor(0x53678A);
    r.drawRect(20, 100, 200, 60);
    // 声音开关 (b1015[101] 声音 / [102]开 / [103]关)
    r.drawText('声音', 48, 122, 0x53678A, 12);
    r.drawText(this.soundEnabled ? '开' : '关', 156, 122, this.soundEnabled ? 0xD5317A : 0x506E91, 12);
    this.renderArrows(136, 182, 124);
    r.drawText('点击切换', 98, 142, 0x506E91, 9);
    // 软键: 确定(左)+返回(右)
    this.uiSystem.renderSoftkeyBar(SOFTKEY_OK, SOFTKEY_BACK);
  }

  // ============================================================
  // 文本页 (帮助=b1015[0] / 关于=b1015[1], 对应原版 state 21/20)
  // 软键: 仅返回; 支持拖动/方向键滚动
  // ============================================================
  private renderTextPage(title: string, text: string): void {
    const r = this.renderer;
    r.setColor(0xFFFFFF);
    r.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);
    this.renderPanelStrip(this.spr('ui', 3), 0, 0xCD3E7E);
    r.drawText(title, (240 - title.length * 12) >> 1, 16, 0x53678A, 12);

    const lines = this.wrapText(text, 220, 10);
    const lineH = 13;
    const viewY = 36;
    const viewH = 252;
    const maxScroll = Math.max(0, lines.length * lineH - viewH);
    this.textScroll = Math.max(0, Math.min(this.textScroll, maxScroll));
    r.setClip(0, viewY, LOGICAL_WIDTH, viewH);
    for (let i = 0; i < lines.length; i++) {
      const ly = viewY + i * lineH - this.textScroll;
      if (ly < viewY - lineH || ly > viewY + viewH) continue;
      r.drawText(lines[i], 10, ly, 0x53678A, 10);
    }
    r.resetClip();
    if (maxScroll > 0) {
      r.drawText('拖动滚动', 100, 292, 0xAAAAAA, 8);
    }
    // 软键: 仅返回 (原版: 帮助/关于=仅返回)
    this.uiSystem.renderSoftkeyBar(-1, SOFTKEY_BACK);
  }

  /** 文本换行 (中文按字符) */
  private wrapText(text: string, maxW: number, size: number): string[] {
    const lines: string[] = [];
    const ctx = this.renderer.virtualContext;
    ctx.font = `${size}px monospace`;
    for (const para of text.split('\n')) {
      let line = '';
      for (const ch of para) {
        if (line.length > 0 && ctx.measureText(line + ch).width > maxW) {
          lines.push(line);
          line = ch;
        } else {
          line += ch;
        }
      }
      lines.push(line);
    }
    return lines;
  }

  /**
   * 渲染关卡剧情阶段 (对应原版 state 23 的 ac() 方法)
   * 原版流程:
   *   Phase 1: 黄色矩形从中心展开 (滚动动画)
   *   Phase 2: 显示关卡名+剧情文本, 点击翻页 (共4页)
   * H5还原: 简化动画但保留多页文本交互
   */
  private renderLevelIntro(): void {
    // 先渲染地图背景
    this.mapData.render();
    this.mapData.renderBuildingBox();

    // 顶部信息栏 + 原版底条 (J() 常驻米色条)
    this.renderTopBar();
    this.buildBar.render();

    const vctx = this.renderer.virtualContext;
    const storyLines = this.getIntroStoryLines();

    if (this.introPhase === 0) {
      // 阶段0: 滚动展开动画 (对应原版 br=1)
      // 矩形从中心向两侧展开
      const progress = this.introAnimProgress;
      const panelW = Math.floor((LOGICAL_WIDTH - 16) * progress);
      const panelH = Math.floor(80 * progress);
      const panelX = (LOGICAL_WIDTH - panelW) / 2;
      const panelY = (LOGICAL_HEIGHT - panelH) / 2;

      if (panelW > 0 && panelH > 0) {
        vctx.save();
        // 原版颜色: 0xFCFCAD (浅黄)
        vctx.fillStyle = '#FCFCAD';
        vctx.fillRect(panelX, panelY, panelW, panelH);
        vctx.fillStyle = '#53581A';
        vctx.fillRect(panelX - 1, panelY + 1, panelW + 2, Math.max(0, panelH - 2));
        vctx.restore();
      }
    } else {
      // 阶段1-4: 显示剧情文本面板 (对应原版 br=2)
      const panelW = LOGICAL_WIDTH - 16;
      const panelH = 80;
      const panelX = 8;
      const panelY = (LOGICAL_HEIGHT - panelH) / 2;

      vctx.save();
      // 面板背景 (原版颜色: 0xFCFCAD 浅黄 + 0x53581A 深色边框)
      vctx.fillStyle = '#FCFCAD';
      vctx.fillRect(panelX, panelY, panelW, panelH);
      vctx.fillStyle = '#53581A';
      vctx.fillRect(panelX + 2, panelY + 2, panelW - 4, panelH - 4);

      // 当前剧情文本
      const currentLine = storyLines[Math.min(this.introPhase - 1, storyLines.length - 1)] ?? '';

      // 绘制文本 (换行)
      vctx.fillStyle = '#FCFFCD';
      this.drawWrappedText(currentLine, panelX + 8, panelY + 12, panelW - 16, 16, 0xFCFFCD, 11);

      // 翻页提示和进度指示
      const pageIndicator = `${this.introPhase}/${storyLines.length}`;
      this.renderer.drawText(pageIndicator, panelX + panelW - 24, panelY + panelH - 14, 0xAAAAFF, 9);

      // 下拉箭头提示 (对应原版 fillTriangle)
      if (this.introPhase < storyLines.length) {
        const arrowX = panelX + panelW / 2;
        const arrowY = panelY + panelH - 6;
        vctx.fillStyle = '#FCFCAD';
        vctx.beginPath();
        vctx.moveTo(arrowX - 4, arrowY);
        vctx.lineTo(arrowX + 4, arrowY);
        vctx.lineTo(arrowX, arrowY + 4);
        vctx.closePath();
        vctx.fill();
      }

      // 最后一页: 显示开始提示
      if (this.introPhase >= storyLines.length) {
        this.renderer.drawText('点击开始战斗', LOGICAL_WIDTH / 2 - 36, panelY + panelH + 8, 0xAAAAFF, 10);
      } else {
        this.renderer.drawText('点击继续', LOGICAL_WIDTH / 2 - 24, panelY + panelH + 8, 0x888888, 9);
      }

      vctx.restore();
    }
  }

  /**
   * 渲染顶部信息栏 (对应原版 I() 方法)
   */
  private renderTopBar(): void {
    const vctx = this.renderer.virtualContext;
    vctx.fillStyle = '#0B1C19';
    vctx.fillRect(0, 0, LOGICAL_WIDTH, MAP_TOP_BAR_H);
    vctx.strokeStyle = '#3a5a3a';
    vctx.beginPath();
    vctx.moveTo(0, MAP_TOP_BAR_H);
    vctx.lineTo(LOGICAL_WIDTH, MAP_TOP_BAR_H);
    vctx.stroke();

    // 金币
    this.renderer.drawText(`金:${this.gold}`, 4, 3, 0xFFD700, 10);
    // 生命
    this.renderer.drawText(`命:${this.lives}`, 80, 3, 0xFF4444, 10);
    // 关卡
    this.renderer.drawText(`关:${this.currentLevel + 1}`, 140, 3, 0xFCFFCD, 10);
    // 击杀
    this.renderer.drawText(`杀:${this.totalKills}`, 190, 3, 0xAAAAFF, 10);
  }

  /**
   * 渲染游戏进行中画面
   */
  private renderPlaying(): void {
    // 渲染地图 (使用相机偏移, 不再使用固定offset)
    this.mapData.render();

    // 渲染双方城池 (对应原版 ak() 行14443-14448: m(aK,aL,0) 我城, m(aI,aJ,1) 敌城)
    this.castleRenderer.render();

    // 渲染建筑方框
    this.mapData.renderBuildingBox();

    // 渲染路径高亮 (建造模式)
    if (this.towerSystem.isBuildMode) {
      this.mapData.renderPathOverlay();
    }

    // 渲染塔 (应用相机偏移)
    this.towerSystem.render(-this.mapData.cameraX, -this.mapData.cameraY + MAP_TOP_BAR_H);

    // 渲染敌人 (EnemySystem 内部应用相机偏移)
    this.enemySystem.render();

    // 渲染UI
    this.renderTopBar();
    // 原版底部: J() 底条常驻 (aw=0时亦为米色条, 行7866-7908)
    // 栏打开/选位时软键=确定/取消; 平时=确定/菜单 (原版左功能键确认, 右功能键菜单)
    this.buildBar.render();
    if (this.buildBar.isOpen || this.towerSystem.isBuildMode) {
      this.uiSystem.renderSoftkeyBar(SOFTKEY_OK, SOFTKEY_CANCEL);
    } else {
      this.uiSystem.renderSoftkeyBar(SOFTKEY_OK, SOFTKEY_MENU);
    }
    this.uiSystem.render(this.gold, this.lives, this.currentLevel,
      this.enemySystem.currentWave, this.enemySystem.totalWaves);
  }

  // ====== 存档面板渲染 (新流程无入口, 保留) ======
  private renderSavePanel(): void {
    this.renderer.setColor(0x0B1C19);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    this.renderer.drawText('存档管理', LOGICAL_WIDTH / 2 - 28, 30, 0xFFD700, 14);
    this.renderer.drawText('< 返回', 4, 4, 0xAAAAFF, 10);

    const startY = 60;
    const itemH = 40;

    for (let i = 0; i < 4; i++) {
      const iy = startY + i * itemH;
      this.renderer.setColor(0x1a1a2a);
      this.renderer.fillRect(20, iy, 200, itemH - 2);
      this.renderer.setColor(0x4a6a8a);
      this.renderer.drawRect(20, iy, 200, itemH - 2);

      this.renderer.drawText(`存档 ${i + 1}`, 28, iy + 4, 0xFCFFCD, 12);

      // 显示存档摘要
      const data = this.saveSystem.load();
      if (data) {
        this.renderer.drawText(
          `关卡:${data.currentLevel ?? '?'} 金币:${data.gold ?? '?'} 武将:${data.awakenedHeroes?.length ?? 0}`,
          28, iy + 20, 0xAAAAFF, 9,
        );
      } else {
        this.renderer.drawText('空', 28, iy + 20, 0x666666, 9);
      }
    }
  }

  private renderGameOver(): void {
    this.renderer.setColor(COLORS.TEXT);
    this.renderer.drawText('游戏结束', LOGICAL_WIDTH / 2 - 30, 140, 0xFF0000, 14);
    this.renderer.drawText('点击返回标题', LOGICAL_WIDTH / 2 - 40, 180, 0xFCFFCD, 10);
  }

  private renderVictory(): void {
    this.renderer.setColor(COLORS.TEXT);
    this.renderer.drawText('通关胜利!', LOGICAL_WIDTH / 2 - 30, 140, 0xFCFFCD, 14);
    this.renderer.drawText('感谢游玩', LOGICAL_WIDTH / 2 - 25, 180, 0xFCFFCD, 10);
  }

  private renderLevelComplete(): void {
    this.renderer.setColor(COLORS.TEXT);
    this.renderer.drawText('关卡完成!', LOGICAL_WIDTH / 2 - 30, 140, 0xFCFFCD, 14);
    this.renderer.drawText('点击继续', LOGICAL_WIDTH / 2 - 20, 180, 0xFCFFCD, 10);
  }

  // ============================================================
  // 结局动画渲染 (对应原版 renderEndingAnim / state 46/47/48)
  // 根据阵营显示不同结局文字, 分阶段淡入淡出
  // ============================================================
  private renderEndingAnim(): void {
    if (!this.currentEnding) {
      this.state = GameState.VICTORY;
      return;
    }
    const ending = this.currentEnding;

    // 背景: 深色背景
    this.renderer.setColor(0x000000);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    // 根据阶段选择文字内容
    let title = '';
    let body = '';
    switch (this.endingPhase) {
      case EndingAnimPhase.FADE_IN:
      case EndingAnimPhase.TITLE:
        title = ending.title;
        body = `${ending.factionName}阵营结局`;
        break;
      case EndingAnimPhase.DESCRIPTION:
        title = ending.title;
        body = ending.description;
        break;
      case EndingAnimPhase.VICTORY:
        title = '天下一统';
        body = ending.victory;
        break;
      case EndingAnimPhase.FINAL:
      case EndingAnimPhase.FADE_OUT:
        title = '剧终';
        body = ending.final;
        break;
      default:
        title = '剧终';
        body = '';
        break;
    }

    // 绘制阵营标志色边框 (顶底装饰条)
    const bandH = 24;
    this.renderer.setColor(ending.color);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, bandH);
    this.renderer.fillRect(0, LOGICAL_HEIGHT - bandH, LOGICAL_WIDTH, bandH);

    // 顶部: 阵营名
    this.renderer.drawText(`${ending.factionName}·结局`, 8, 6, 0xFCFFCD, 12);
    // 底部: 阶段进度提示
    const phaseLabels = ['淡入', '标题', '描述', '胜利', '终章', '淡出'];
    const phaseLabel = phaseLabels[this.endingPhase] ?? '';
    this.renderer.drawText(`点击跳过 · ${phaseLabel}`, 8, LOGICAL_HEIGHT - bandH + 6, 0xFCFFCD, 9);

    // 标题文字 (居中大号)
    const titleY = LOGICAL_HEIGHT / 2 - 30;
    const titleW = this.renderer.virtualContext.measureText(title).width;
    this.renderer.drawText(title, (LOGICAL_WIDTH - titleW) / 2, titleY, 0xFFD700, 18);

    // 正文文字 (居中换行)
    this.drawWrappedText(body, 20, LOGICAL_HEIGHT / 2 + 10, LOGICAL_WIDTH - 40, 16, 0xFCFFCD, 12);

    // 淡入淡出效果: alpha:false 画布无法用 globalAlpha, 改用全黑覆盖模拟
    if (this.endingPhase === EndingAnimPhase.FADE_IN) {
      const phaseDuration = this.endingPhaseFrames[EndingAnimPhase.FADE_IN] ?? 30;
      const progress = this.endingFrame / phaseDuration;
      // 前 70% 时间全黑, 后 30% 显示
      if (progress < 0.7) {
        this.renderer.setColor(0x000000);
        this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);
        // 仅显示阵营色边框提示
        this.renderer.setColor(ending.color);
        this.renderer.fillRect(0, 0, LOGICAL_WIDTH, 4);
        this.renderer.fillRect(0, LOGICAL_HEIGHT - 4, LOGICAL_WIDTH, 4);
      }
    } else if (this.endingPhase === EndingAnimPhase.FADE_OUT) {
      const phaseDuration = this.endingPhaseFrames[EndingAnimPhase.FADE_OUT] ?? 30;
      const progress = this.endingFrame / phaseDuration;
      // 前 30% 显示, 后 70% 全黑
      if (progress > 0.3) {
        this.renderer.setColor(0x000000);
        this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);
      }
    }
  }

  // ====== 文字换行绘制工具方法 ======
  private drawWrappedText(text: string, x: number, y: number, maxW: number, lineH: number, color: number, size: number): void {
    if (!text) return;
    // 按字符拆分 (中文文本)
    let line = '';
    let curY = y;
    for (let i = 0; i < text.length; i++) {
      const ch = text[i];
      const testLine = line + ch;
      const w = this.renderer.virtualContext.measureText(testLine).width;
      if (w > maxW && line.length > 0) {
        this.renderer.drawText(line, x, curY, color, size);
        line = ch;
        curY += lineH;
      } else {
        line = testLine;
      }
    }
    if (line) {
      this.renderer.drawText(line, x, curY, color, size);
    }
  }

  /**
   * 启动游戏
   */
  async start(): Promise<void> {
    // 加载精灵图素材
    this.spriteLoader.setProgressCallback((progress) => {
      const fill = document.getElementById('loading-fill');
      if (fill) {
        fill.style.width = `${progress * 100}%`;
      }
    });

    await this.spriteLoader.loadAll();

    // 将精灵图加载器传递给各系统
    this.enemySystem.setSpriteLoader(this.spriteLoader);
    this.towerSystem.setSpriteLoader(this.spriteLoader);
    this.mapData.setSpriteLoader(this.spriteLoader);
    this.castleRenderer.setSpriteLoader(this.spriteLoader);
    this.uiSystem.setSpriteLoader(this.spriteLoader);
    this.buildBar.setSpriteLoader(this.spriteLoader);

    // 读取声音设置
    const settings = this.saveSystem.loadSettings();
    this.soundEnabled = settings.musicEnabled;

    // 地图图集推迟到 LOADING_SCREEN 阶段加载 (对应原版 k() 的 e() 进度)
    // 启动后先播放 LOGO 动画 (原版 l=0)
    this.state = GameState.LOGO_ANIM;
    this.lastTime = performance.now();
    requestAnimationFrame(this.gameLoop);

    // 隐藏加载画面
    const loading = document.getElementById('loading');
    if (loading) loading.style.display = 'none';

    // 初始化音频
    await this.audioSystem.init();
  }

  get currentState(): GameState {
    return this.state;
  }
}
