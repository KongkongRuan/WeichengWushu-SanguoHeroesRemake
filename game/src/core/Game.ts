/**
 * 游戏主循环 - 协调所有系统
 */
import { Renderer } from './Renderer';
import { MapData } from './MapData';
import { EnemySystem } from './Enemy';
import { TowerSystem } from './Tower';
import { AudioSystem } from './AudioSystem';
import { InputSystem } from './Input';
import { UISystem, Button } from './UI';
import { SpriteLoader } from './SpriteLoader';
import { TechTreeSystem } from './TechTree';
import { SaveSystem } from './SaveSystem';
import {
  LOGICAL_WIDTH,
  LOGICAL_HEIGHT,
  TILE_SIZE,
  MAP_TOP_BAR_H,
  MAP_VIEW_H,
  MAP_VIEW_W,
  STORY_LEVEL_SEQUENCE,
  FREE_LEVEL_SEQUENCE,
  FACTION_ENDING_SEQUENCES,
  FACTION_ENDING_PATH_INDEX,
  FACTION_ENDINGS,
  KILL_REWARD,
  ENEMY_COUNT_PER_LEVEL,
  MULTI_PATH_FLAG,
  COLORS,
} from '../data/gameData';
import type { FactionEnding } from '../data/gameData';
import { Faction, LEVELS, HEROES } from '../data/heroes';

export enum GameState {
  LOADING = 0,
  MENU = 1,
  PLAYING = 2,
  PAUSED = 3,
  GAME_OVER = 4,
  VICTORY = 5,
  LEVEL_COMPLETE = 6,
  // 补全原版状态机 (对应原版 dispatchRender case)
  HELP = 8,                    // case 8/9: 帮助页面
  LOADING_SCREEN = 10,         // case 10: 加载过渡屏
  TECH_TREE_BROWSE = 12,       // case 12: 科技树浏览
  LEVEL_SELECT = 13,           // case 13/14: 关卡选择
  FREE_PLAY = 15,              // case 15: 自由模式
  FACTION_SELECT = 16,         // case 16: 阵营选择
  SAVE_PANEL = 17,             // case 17: 存档面板
  ENDING_ANIM = 18,            // case 18: 结局动画 (原版 state 46/47/48 的H5重制版)
  CREDITS = 20,                 // case 20/21: 版权/说明
  DIFFICULTY_SELECT = 24,      // case 24: 难度选择
  FREE_PLAY_COMPLETE = 30,     // 自由模式通关结算 (H5新增)
  LEVEL_INTRO = 40,            // 关卡剧情/准备阶段 (对应原版 state 23)
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

export class Game {
  private renderer: Renderer;
  private mapData: MapData;
  private enemySystem: EnemySystem;
  private towerSystem: TowerSystem;
  private audioSystem: AudioSystem;
  private inputSystem: InputSystem;
  private uiSystem: UISystem;
  private spriteLoader: SpriteLoader;
  private techTree: TechTreeSystem;
  private saveSystem: SaveSystem;

  private state: GameState = GameState.LOADING;
  private currentLevel: number = 0;
  private levelIndex: number = 0;
  private gold: number = 300;
  private lives: number = 20;
  private wave: number = 0;
  private maxWaves: number = 10;
  private lastTime: number = 0;
  private frameCount: number = 0;
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

  // ====== 新增: 状态机导航数据 (对应原版 handleLevelSelect/handleFactionSelect 等) ======
  // 菜单项选择索引 (对应原版 r 字段)
  private menuSelectIdx: number = 0;
  // 关卡选择滚动位置 (对应原版 au/av 字段)
  private levelScrollX: number = 0;
  private levelScrollY: number = 0;
  // 阵营选择 (对应原版 t1089 字段, 0=蜀 1=魏 2=吴 3=群)
  private selectedFaction: number = 0;
  // 难度选择 (对应原版 ac 字段, 0=简单 1=普通 2=困难)
  private selectedDifficulty: number = 1;
  // 游戏模式 (0=故事 1=自由)
  private gameMode: number = 0;
  // 存档槽位 (0-3)
  private saveSlot: number = 0;

  // ====== 新增: 结局动画状态 (对应原版 b1174 阶段字段) ======
  // 结局动画当前阶段
  private endingPhase: EndingAnimPhase = EndingAnimPhase.FADE_IN;
  // 结局动画帧计时器 (每帧递增)
  private endingFrame: number = 0;
  // 结局动画阶段持续帧数
  private readonly endingPhaseFrames: number[] = [30, 120, 150, 120, 120, 30];
  // 结局动画淡入淡出 alpha (0-255)
  private endingAlpha: number = 0;
  // 当前阵营结局数据
  private currentEnding: FactionEnding | null = null;
  // 当前使用的阵营结局路径 (来自 FACTION_ENDING_SEQUENCES)
  private currentEndingPath: number[] = STORY_LEVEL_SEQUENCE;
  // 结局路径进度索引
  private endingPathIndex: number = 0;

  constructor(canvas: HTMLCanvasElement) {
    this.renderer = new Renderer(canvas);
    this.mapData = new MapData(this.renderer);
    this.enemySystem = new EnemySystem(this.renderer, this.mapData);
    this.towerSystem = new TowerSystem(this.renderer, this.mapData);
    this.audioSystem = new AudioSystem();
    this.inputSystem = new InputSystem(this.renderer);
    this.uiSystem = new UISystem(this.renderer);
    this.spriteLoader = new SpriteLoader();
    this.techTree = new TechTreeSystem();
    this.saveSystem = SaveSystem.getInstance();

    this.setupCallbacks();
    this.setupInput();
    this.resize();
    window.addEventListener('resize', () => this.resize());
  }

  /**
   * 设置回调
   */
  private setupCallbacks(): void {
    // 科技树初始化
    this.techTree.setFaction(Faction.SHU);

    this.enemySystem.setCallbacks(
      (gold) => {
        const actualGold = this.techTree.isGoldDouble() ? gold * 2 : gold;
        this.gold += actualGold;
        this.totalGoldEarned += actualGold;
      },
      () => { this.lives--; if (this.lives <= 0) this.state = GameState.GAME_OVER; },
    );

    this.towerSystem.setOnGoldSpent((cost) => { this.gold -= cost; });
    this.towerSystem.setTechTree(this.techTree);
    this.towerSystem.setOnHeroAwakened((hero, tower) => {
      this.uiSystem.showHeroAwakened(hero.name);
    });

    // 新增: 设置敌人系统的塔系统引用 (用于敌人攻击塔逻辑)
    this.enemySystem.setTowerSystem(this.towerSystem);

    this.uiSystem.setButtonCallback((btn) => this.handleButton(btn));
    this.uiSystem.setTechTree(this.techTree);
  }

  /**
   * 设置输入
   */
  private setupInput(): void {
    this.inputSystem.onTap((x, y) => this.handleTap(x, y));
    this.inputSystem.onMove((x, y) => {
      // 建造模式下不跟随鼠标, 建筑方框是唯一的建造位置指示器
      // (原版逻辑: bN/bO 建筑方框由方向键控制, 塔只能建在方框位置)
    });

    // 键盘输入: 方向键移动建筑方框
    window.addEventListener('keydown', (e) => this.handleKeyDown(e));
  }

  /**
   * 处理键盘输入 (对应原版 al() 方法中的方向键处理)
   */
  private handleKeyDown(e: KeyboardEvent): void {
    if (this.state !== GameState.PLAYING && this.state !== GameState.LEVEL_INTRO) return;

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
    }
  }

  /**
   * 处理点击
   */
  private handleTap(x: number, y: number): void {
    // 根据当前状态分发点击处理
    switch (this.state) {
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
      case GameState.MENU:
        this.handleMenuTap(x, y);
        return;
      case GameState.LEVEL_SELECT:
        this.handleLevelSelectTap(x, y);
        return;
      case GameState.FACTION_SELECT:
        this.handleFactionSelectTap(x, y);
        return;
      case GameState.DIFFICULTY_SELECT:
        this.handleDifficultySelectTap(x, y);
        return;
      case GameState.SAVE_PANEL:
        this.handleSavePanelTap(x, y);
        return;
      case GameState.HELP:
      case GameState.CREDITS:
        // 任意点击返回菜单
        this.state = GameState.MENU;
        return;
      case GameState.LEVEL_COMPLETE:
        this.nextLevel();
        return;
      case GameState.ENDING_ANIM:
        // 点击可跳过当前阶段
        this.advanceEndingPhase();
        return;
      case GameState.FREE_PLAY_COMPLETE:
        // 点击返回菜单
        this.state = GameState.MENU;
        return;
      case GameState.GAME_OVER:
      case GameState.VICTORY:
        this.state = GameState.MENU;
        return;
      case GameState.PLAYING:
        // 游戏中的点击处理
        break;
      default:
        return;
    }

    // 游戏中: 先检查UI按钮 (暂停菜单时也只能点UI按钮)
    if (this.uiSystem.handleTap(x, y)) return;

    // ====== 新增: 暂停菜单可见时, 不处理地图点击 ======
    if (this.uiSystem.isPauseMenuVisible()) return;

    // 检查地图点击 (使用相机系统转换坐标)
    const tile = this.mapData.screenToTile(x, y);

    // 将建筑方框移动到点击位置 (触屏支持, 对应原版 al() 中的 bN/bO 设置)
    this.mapData.setBuildingBox(tile.tx, tile.ty);

    // 获取建筑方框当前瓦片坐标 (点击后即为点击位置)
    const boxTile = this.mapData.getBuildingBoxTile();

    // 检查是否点击了已有塔 (对应原版 g(bN, bO) 检查)
    const tower = this.towerSystem.selectTower(boxTile.tx, boxTile.ty);
    if (tower) {
      // 点击已有塔: 显示升级面板 (对应原版 j(1))
      this.uiSystem.showUpgradePanel(boxTile.tx, boxTile.ty, tower);
    } else if (this.mapData.isBuildable(boxTile.tx, boxTile.ty)) {
      // 点击可建造位置: 进入建造模式, 显示建造面板 (对应原版 j(0))
      this.towerSystem.enterBuildMode();
      this.towerSystem.setBuildPosition(boxTile.tx, boxTile.ty);
      this.uiSystem.showBuildPanel(boxTile.tx, boxTile.ty);
      this.uiSystem.hideUpgradePanel();
    } else {
      // 不可建造且无塔: 取消选择 (对应原版 u1096=true)
      this.towerSystem.deselectTower();
      this.towerSystem.exitBuildMode();
      this.uiSystem.hideUpgradePanel();
      this.uiSystem.hideBuildPanel();
      this.uiSystem.showMessage('此处不可建造', 60);
    }
  }

  // ====== 新增: 菜单点击处理 (对应原版 handleMainMenu case 5) ======
  private handleMenuTap(x: number, y: number): void {
    // 菜单项布局: 6个选项纵向排列
    const items = [
      { label: '新游戏', action: () => this.startNewGame() },
      { label: '继续游戏', action: () => this.continueGame() },
      { label: '自由模式', action: () => { this.gameMode = 1; this.state = GameState.LEVEL_SELECT; this.menuSelectIdx = 0; } },
      { label: '帮助', action: () => { this.state = GameState.HELP; } },
      { label: '存档', action: () => { this.state = GameState.SAVE_PANEL; this.menuSelectIdx = 0; } },
      { label: '版权', action: () => { this.state = GameState.CREDITS; } },
    ];
    const startY = 130;
    const itemH = 24;
    for (let i = 0; i < items.length; i++) {
      const iy = startY + i * itemH;
      if (x >= 40 && x <= 200 && y >= iy && y <= iy + itemH) {
        items[i].action();
        return;
      }
    }
  }

  // ====== 新增: 关卡选择点击处理 (对应原版 handleLevelSelect K方法) ======
  private handleLevelSelectTap(x: number, y: number): void {
    const levels = this.gameMode === 0 ? STORY_LEVEL_SEQUENCE : FREE_LEVEL_SEQUENCE;
    // 关卡列表纵向排列, 每项22px高
    const startY = 60;
    const itemH = 22;
    for (let i = 0; i < levels.length; i++) {
      const iy = startY + i * itemH;
      if (x >= 20 && x <= 220 && y >= iy && y <= iy + itemH) {
        const lv = levels[i];
        if (lv >= 21) {
          // 结束标记, 返回菜单
          this.state = GameState.MENU;
          return;
        }
        this.levelIndex = i;
        this.startLevel(lv);
        return;
      }
    }
    // 返回按钮
    if (x >= 0 && x <= 60 && y >= 0 && y <= 20) {
      this.state = GameState.MENU;
    }
  }

  // ====== 新增: 阵营选择点击处理 (对应原版 handleFactionSelect u方法) ======
  private handleFactionSelectTap(x: number, y: number): void {
    const factionNames = ['蜀', '魏', '吴', '群'];
    const startY = 100;
    const itemH = 40;
    for (let i = 0; i < 4; i++) {
      const iy = startY + i * itemH;
      if (x >= 60 && x <= 180 && y >= iy && y <= iy + itemH) {
        this.selectedFaction = i;
        this.techTree.setFaction(i as any);
        // 进入难度选择
        this.state = GameState.DIFFICULTY_SELECT;
        this.menuSelectIdx = 1;
        return;
      }
    }
    // 返回按钮
    if (x >= 0 && x <= 60 && y >= 0 && y <= 20) {
      this.state = GameState.LEVEL_SELECT;
    }
  }

  // ====== 新增: 难度选择点击处理 (对应原版 handleInputAQ aq方法) ======
  private handleDifficultySelectTap(x: number, y: number): void {
    const diffNames = ['简单', '普通', '困难'];
    const startY = 120;
    const itemH = 30;
    for (let i = 0; i < 3; i++) {
      const iy = startY + i * itemH;
      if (x >= 60 && x <= 180 && y >= iy && y <= iy + itemH) {
        this.selectedDifficulty = i;
        // 应用难度修正
        this.applyDifficulty(i);
        // 开始第一关
        this.startNewGame();
        return;
      }
    }
    // 返回按钮
    if (x >= 0 && x <= 60 && y >= 0 && y <= 20) {
      this.state = GameState.FACTION_SELECT;
    }
  }

  // ====== 新增: 存档面板点击处理 (对应原版 handleSaveLoad s方法) ======
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
      this.state = GameState.MENU;
    }
  }

  /**
   * 应用难度修正
   * 简单: 金币+50%, 敌人HP-20%
   * 普通: 无修正
   * 困难: 金币-20%, 敌人HP+30%
   */
  private applyDifficulty(diff: number): void {
    switch (diff) {
      case 0: // 简单
        this.gold = Math.floor(this.gold * 1.5);
        break;
      case 2: // 困难
        this.gold = Math.floor(this.gold * 0.8);
        break;
    }
  }

  /**
   * 从存档数据恢复游戏
   */
  private loadFromSaveData(data: any): void {
    if (!data) return;
    this.levelIndex = data.levelIndex ?? 0;
    this.currentLevel = data.level ?? 0;
    this.gold = data.gold ?? 300;
    this.lives = data.lives ?? 20;
    this.totalKills = data.stats?.totalKills ?? 0;
    this.totalGoldEarned = data.stats?.totalGoldEarned ?? 0;
    this.playTime = data.stats?.playTime ?? 0;
    // 恢复科技树
    if (data.tech) {
      this.techTree.restoreFromSave(data.tech);
    }
    // 恢复塔布局
    if (data.towers) {
      this.towerSystem.restoreFromSave(data.towers);
    }
    // 加载关卡
    this.startLevel(this.currentLevel);
  }

  /**
   * 开始指定关卡
   * loadLevel 内部会设置 state = LEVEL_INTRO, 不在此处覆盖
   */
  private async startLevel(level: number): Promise<void> {
    await this.loadLevel(level);
    // 不再覆盖状态, loadLevel 会设置 LEVEL_INTRO
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
    // 无存档, 开始新游戏
    this.startNewGame();
  }

  /**
   * 处理按钮点击
   */
  private handleButton(btn: Button): void {
    switch (btn.action) {
      case 'select_tower':
        // 进入建造模式, 使用建筑方框位置 (对应原版 j(0))
        this.towerSystem.enterBuildMode();
        {
          const bt = this.mapData.getBuildingBoxTile();
          this.towerSystem.setBuildPosition(bt.tx, bt.ty);
          this.uiSystem.showBuildPanel(bt.tx, bt.ty);
        }
        break;
      case 'place':
        if (btn.data !== undefined) {
          // 使用建筑方框位置放置塔 (对应原版 t(var1) 中使用 bN/bO)
          const bt = this.mapData.getBuildingBoxTile();
          const success = this.towerSystem.placeTower(
            bt.tx,
            bt.ty,
            btn.data,
          );
          if (!success) {
            this.uiSystem.showMessage('金币不足或位置不可建造');
          }
        }
        this.towerSystem.exitBuildMode();
        this.uiSystem.hideBuildPanel();
        break;
      case 'upgrade':
        const sel = this.towerSystem.getSelectedTower();
        if (sel) {
          if (!this.towerSystem.upgradeTower(sel)) {
            this.uiSystem.showMessage('金币不足或已满级');
          } else {
            this.uiSystem.showUpgradePanel(sel.x, sel.y, sel);
          }
        }
        break;
      case 'sell':
        const tower = this.towerSystem.getSelectedTower();
        if (tower) {
          this.towerSystem.sellTower(tower);
          this.uiSystem.hideUpgradePanel();
        }
        break;
      case 'show_tech':
        this.uiSystem.showTechPanel();
        break;
      case 'close_tech':
        this.uiSystem.hideTechPanel();
        break;
      // ====== 新增: 科技树翻页按钮处理 ======
      case 'tech_prev_page':
        this.uiSystem.techPrevPage();
        break;
      case 'tech_next_page':
        this.uiSystem.techNextPage();
        break;
      case 'close':
      case 'cancel':
        this.towerSystem.exitBuildMode();
        this.uiSystem.hideBuildPanel();
        this.uiSystem.hideUpgradePanel();
        break;
      // ====== 新增: 游戏控制按钮处理 (对应原版 handleVolumeInput) ======
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
        this.state = GameState.MENU;
        break;
      case 'save_game':
        this.autoSave();
        this.uiSystem.showMessage('已保存', 60);
        break;
    }
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
  async loadLevel(level: number): Promise<void> {
    this.currentLevel = level;
    await this.mapData.loadLevel(level);

    this.enemySystem.setLevel(level);
    this.enemySystem.computePaths();
    this.enemySystem.reset();
    this.towerSystem.setGold(this.gold);
    this.techTree.setGold(this.gold);

    this.wave = 0;
    this.lives = 20;

    // 播放对应关卡的MIDI音乐
    const midiFile = `./mid/${level % 15}.mid`;
    this.audioSystem.playMidi(midiFile).catch(() => {});

    // 进入关卡剧情阶段 (对应原版 state 23)
    this.state = GameState.LEVEL_INTRO;
    this.introTimer = 0;
    this.introPhase = 0;
  }

  /**
   * 开始新游戏
   */
  async startNewGame(): Promise<void> {
    this.levelIndex = 0;
    this.gold = 300;
    await this.loadLevel(STORY_LEVEL_SEQUENCE[0]);
  }

  /**
   * 下一关
   */
  async nextLevel(): Promise<void> {
    // ====== 修改: 接入阵营结局路径 (对应原版 d1053[2..7]) ======
    // 故事模式: 走完 STORY_LEVEL_SEQUENCE 后进入阵营结局路径
    // 自由模式: 走完 FREE_LEVEL_SEQUENCE 后进入 FREE_PLAY_COMPLETE
    if (this.gameMode === 1) {
      // 自由模式
      this.levelIndex++;
      if (this.levelIndex >= FREE_LEVEL_SEQUENCE.length || FREE_LEVEL_SEQUENCE[this.levelIndex] >= 21) {
        this.state = GameState.FREE_PLAY_COMPLETE;
        return;
      }
      const next = FREE_LEVEL_SEQUENCE[this.levelIndex];
      this.gold += 1000;
      this.totalGoldEarned += 1000;
      await this.loadLevel(next);
      return;
    }

    // ====== 新增: 如果当前在阵营结局路径中, 走 nextEndingPathLevel ======
    if (this.endingPathIndex > 0 || this.currentEndingPath !== STORY_LEVEL_SEQUENCE) {
      await this.nextEndingPathLevel();
      return;
    }

    // 故事模式: 先走 STORY_LEVEL_SEQUENCE
    this.levelIndex++;
    if (this.levelIndex >= STORY_LEVEL_SEQUENCE.length) {
      // 故事序列走完, 进入阵营结局路径
      this.startFactionEndingPath();
      return;
    }
    const nextLevel = STORY_LEVEL_SEQUENCE[this.levelIndex];
    if (nextLevel === 21) {
      // 21=结束标记, 进入阵营结局路径
      this.startFactionEndingPath();
      return;
    }
    this.gold += 1000; // 通关奖励
    this.totalGoldEarned += 1000;
    await this.loadLevel(nextLevel);
  }

  // ====== 新增: 开始阵营结局路径 (对应原版 d1053[2..7] 选择逻辑) ======
  // 根据 selectedFaction 选择对应的结局路径
  private startFactionEndingPath(): void {
    const pathIdx = FACTION_ENDING_PATH_INDEX[this.selectedFaction] ?? 0;
    this.currentEndingPath = FACTION_ENDING_SEQUENCES[pathIdx] ?? STORY_LEVEL_SEQUENCE;
    this.endingPathIndex = 0;
    // 启动结局路径第一关
    const firstLevel = this.currentEndingPath[0];
    if (firstLevel === 20 || firstLevel === 21) {
      // 直接是通关/结束关卡, 触发结局动画
      this.triggerEndingAnim();
    } else {
      // 加载阵营结局关卡
      this.loadLevel(firstLevel);
    }
  }

  // ====== 新增: 阵营结局路径下一关 ======
  private async nextEndingPathLevel(): Promise<void> {
    this.endingPathIndex++;
    if (this.endingPathIndex >= this.currentEndingPath.length) {
      this.triggerEndingAnim();
      return;
    }
    const next = this.currentEndingPath[this.endingPathIndex];
    if (next === 20 || next === 21) {
      // 通关/结束标记, 触发结局动画
      this.triggerEndingAnim();
      return;
    }
    await this.loadLevel(next);
  }

  // ====== 新增: 触发结局动画 (对应原版 state 46/47/48) ======
  private triggerEndingAnim(): void {
    this.currentEnding = FACTION_ENDINGS[this.selectedFaction] ?? FACTION_ENDINGS[0];
    this.endingPhase = EndingAnimPhase.FADE_IN;
    this.endingFrame = 0;
    this.endingAlpha = 0;
    this.state = GameState.ENDING_ANIM;
    // 播放胜利音乐
    this.audioSystem.playMidi('./mid/14.mid').catch(() => {});
  }

  // ====== 新增: 推进结局动画到下一阶段 ======
  private advanceEndingPhase(): void {
    this.endingPhase++;
    this.endingFrame = 0;
    if (this.endingPhase >= EndingAnimPhase.DONE) {
      // 结局动画完成, 进入VICTORY状态
      this.state = GameState.VICTORY;
    }
  }

  // ====== 新增: 更新结局动画 (对应原版 renderEndingAnim 的帧逻辑) ======
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

  // ====== 新增: 重新开始当前关卡 ======
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

    this.enemySystem.update(dt);
    this.towerSystem.update(this.enemySystem.getActiveEnemies(), 0, MAP_TOP_BAR_H);

    // 检查关卡完成
    if (this.enemySystem.killed >= this.getMaxEnemies()) {
      this.state = GameState.LEVEL_COMPLETE;
      this.autoSave();
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
   * 获取当前关卡剧情文本 (对应原版 b1015[bs+171])
   * 原版4行文本: 游戏说明、升级说明、失败条件、操作说明
   */
  private getIntroStoryLines(): string[] {
    const levelInfo = LEVELS.find(l => l.levelId === this.currentLevel);
    const levelName = levelInfo?.name ?? `关卡 ${this.currentLevel + 1}`;
    const levelStory = levelInfo?.story ?? '';
    return [
      `${levelName}：${levelStory}`,
      `${levelName}：建造各种城防武器抵挡敌城中涌出的军队`,
      `${levelName}：超过10个敌人冲入城池则游戏失败`,
      `${levelName}：点击空地建造, 方向键移动方框, 点击塔升级`,
    ];
  }

  /**
   * 自动存档
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
    this.saveSystem.save(saveData);
  }

  /**
   * 获取当前关卡最大敌人数
   */
  private getMaxEnemies(): number {
    return (ENEMY_COUNT_PER_LEVEL[this.currentLevel] ?? 3) * 20;
  }

  /**
   * 渲染
   */
  private render(): void {
    this.renderer.clear(COLORS.BACKGROUND);

    switch (this.state) {
      case GameState.LEVEL_INTRO:
        this.renderLevelIntro();
        break;
      case GameState.PLAYING:
      case GameState.PAUSED:
        this.renderPlaying();
        break;
      case GameState.MENU:
        this.renderMenu();
        break;
      case GameState.LEVEL_SELECT:
        this.renderLevelSelect();
        break;
      case GameState.FACTION_SELECT:
        this.renderFactionSelect();
        break;
      case GameState.DIFFICULTY_SELECT:
        this.renderDifficultySelect();
        break;
      case GameState.SAVE_PANEL:
        this.renderSavePanel();
        break;
      case GameState.HELP:
        this.renderHelp();
        break;
      case GameState.CREDITS:
        this.renderCredits();
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
      case GameState.FREE_PLAY_COMPLETE:
        this.renderFreePlayComplete();
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

    // 顶部信息栏
    this.renderTopBar();
    this.renderBottomBar();

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
   * 渲染底部信息栏 (对应原版 J() 方法)
   */
  private renderBottomBar(): void {
    const barY = MAP_TOP_BAR_H + MAP_VIEW_H;
    const barH = LOGICAL_HEIGHT - barY;
    const vctx = this.renderer.virtualContext;
    vctx.fillStyle = '#0B1C19';
    vctx.fillRect(0, barY, LOGICAL_WIDTH, barH);
    vctx.strokeStyle = '#3a5a3a';
    vctx.beginPath();
    vctx.moveTo(0, barY);
    vctx.lineTo(LOGICAL_WIDTH, barY);
    vctx.stroke();

    // 底部按钮提示
    this.renderer.drawText('建造', 4, barY + 4, 0xAAAAFF, 9);
    this.renderer.drawText('暂停', 60, barY + 4, 0xAAAAFF, 9);
    this.renderer.drawText('科技', 110, barY + 4, 0xAAAAFF, 9);
    this.renderer.drawText('加速', 160, barY + 4, 0xAAAAFF, 9);
    this.renderer.drawText('菜单', 200, barY + 4, 0xAAAAFF, 9);
  }

  /**
   * 渲染游戏进行中画面
   */
  private renderPlaying(): void {
    // 渲染地图 (使用相机偏移, 不再使用固定offset)
    this.mapData.render();

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
    this.renderBottomBar();
    this.uiSystem.render(this.gold, this.lives, this.currentLevel, this.wave);
  }

  /**
   * 渲染菜单
   */
  private renderMenu(): void {
    // 背景
    this.renderer.setColor(0x0B1C19);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    // 标题
    this.renderer.drawText('危城无双之三国群英', LOGICAL_WIDTH / 2 - 72, 60, 0xFFD700, 16);
    this.renderer.drawText('H5重制版', LOGICAL_WIDTH / 2 - 28, 82, 0xAAAAFF, 10);

    // 菜单项 (与 handleMenuTap 中的布局完全一致)
    const items = ['新游戏', '继续游戏', '自由模式', '帮助', '存档', '版权'];
    const startY = 130;
    const itemH = 24;
    for (let i = 0; i < items.length; i++) {
      const iy = startY + i * itemH;
      // 条目背景
      this.renderer.setColor(0x1a2a1a);
      this.renderer.fillRect(40, iy, 160, itemH - 2);
      this.renderer.setColor(0x4a6a4a);
      this.renderer.drawRect(40, iy, 160, itemH - 2);
      // 条目文字
      this.renderer.drawText(items[i], 92, iy + 6, 0xFCFFCD, 12);
    }

    // 底部提示
    this.renderer.drawText('点击菜单项进行操作', LOGICAL_WIDTH / 2 - 52, LOGICAL_HEIGHT - 20, 0x888888, 9);

    // 显示存档信息
    if (this.saveSystem.hasSave()) {
      const summary = this.saveSystem.getSaveSummary();
      if (summary) {
        this.renderer.drawText(`存档: 关卡${summary.level} 金币:${summary.gold}`, 60, 110, 0xAAAAFF, 9);
      }
    }
  }

  // ====== 新增: 关卡选择渲染 (对应原版 handleLevelSelect + calcScrollPosition) ======
  private renderLevelSelect(): void {
    // 背景色
    this.renderer.setColor(0x0B1C19);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    // 标题
    this.renderer.drawText(this.gameMode === 0 ? '故事模式' : '自由模式',
      LOGICAL_WIDTH / 2 - 32, 30, 0xFFD700, 14);

    // 返回按钮提示
    this.renderer.drawText('< 返回', 4, 4, 0xAAAAFF, 10);

    const levels = this.gameMode === 0 ? STORY_LEVEL_SEQUENCE : FREE_LEVEL_SEQUENCE;
    const startY = 60;
    const itemH = 22;

    for (let i = 0; i < levels.length; i++) {
      const lv = levels[i];
      const iy = startY + i * itemH;

      if (lv >= 21) {
        // 结束标记
        this.renderer.setColor(0x333333);
        this.renderer.fillRect(20, iy, 200, itemH - 2);
        this.renderer.drawText('返回', 100, iy + 4, 0x888888, 11);
        continue;
      }

      // 关卡条目
      const levelInfo = LEVELS.find(l => l.levelId === lv);
      const name = levelInfo?.name ?? `关卡 ${lv}`;

      this.renderer.setColor(0x1a2a1a);
      this.renderer.fillRect(20, iy, 200, itemH - 2);
      this.renderer.setColor(0x4a6a4a);
      this.renderer.drawRect(20, iy, 200, itemH - 2);
      this.renderer.drawText(`${i + 1}. ${name}`, 28, iy + 4, 0xFCFFCD, 11);
    }
  }

  // ====== 新增: 阵营选择渲染 (对应原版 renderFactionSelect) ======
  private renderFactionSelect(): void {
    this.renderer.setColor(0x0B1C19);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    this.renderer.drawText('选择阵营', LOGICAL_WIDTH / 2 - 28, 30, 0xFFD700, 14);
    this.renderer.drawText('< 返回', 4, 4, 0xAAAAFF, 10);

    const factions = [
      { name: '蜀', desc: '刘备同时拥有卧龙与凤雏', color: 0x4CAF50 },
      { name: '魏', desc: '曹操带领能臣猛将', color: 0x2196F3 },
      { name: '吴', desc: '孙家世代名将弓箭好手', color: 0xFF9800 },
      { name: '群', desc: '群雄逐鹿乱世出英雄', color: 0x9C27B0 },
    ];

    const startY = 100;
    const itemH = 40;

    for (let i = 0; i < factions.length; i++) {
      const iy = startY + i * itemH;
      this.renderer.setColor(0x1a1a2a);
      this.renderer.fillRect(60, iy, 120, itemH - 2);
      this.renderer.setColor(factions[i].color);
      this.renderer.drawRect(60, iy, 120, itemH - 2);

      this.renderer.drawText(factions[i].name, 100, iy + 6, factions[i].color, 16);
      this.renderer.drawText(factions[i].desc, 70, iy + 24, 0xAAAAFF, 8);
    }
  }

  // ====== 新增: 难度选择渲染 (对应原版 renderDifficulty) ======
  private renderDifficultySelect(): void {
    this.renderer.setColor(0x0B1C19);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    this.renderer.drawText('选择难度', LOGICAL_WIDTH / 2 - 28, 30, 0xFFD700, 14);
    this.renderer.drawText('< 返回', 4, 4, 0xAAAAFF, 10);

    const diffs = [
      { name: '简单', desc: '金币+50%, 敌人较弱', color: 0x4CAF50 },
      { name: '普通', desc: '标准游戏体验', color: 0xFFC107 },
      { name: '困难', desc: '金币-20%, 敌人较强', color: 0xF44336 },
    ];

    const startY = 120;
    const itemH = 30;

    for (let i = 0; i < diffs.length; i++) {
      const iy = startY + i * itemH;
      this.renderer.setColor(0x1a1a2a);
      this.renderer.fillRect(60, iy, 120, itemH - 2);
      this.renderer.setColor(diffs[i].color);
      this.renderer.drawRect(60, iy, 120, itemH - 2);

      this.renderer.drawText(diffs[i].name, 100, iy + 4, diffs[i].color, 14);
      this.renderer.drawText(diffs[i].desc, 65, iy + 18, 0xAAAAFF, 8);
    }
  }

  // ====== 新增: 存档面板渲染 (对应原版 renderSavePanel) ======
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

  // ====== 新增: 帮助页面渲染 (对应原版 case 8/9) ======
  private renderHelp(): void {
    this.renderer.setColor(0x0B1C19);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    this.renderer.drawText('游戏帮助', LOGICAL_WIDTH / 2 - 28, 20, 0xFFD700, 14);
    this.renderer.drawText('点击返回', 4, 4, 0xAAAAFF, 10);

    const helpLines = [
      '建造各种城防武器抵挡敌城军队',
      '升级城池可建造更多类型武器',
      '超过10个敌人冲入城池则失败',
      '空地按建造塔,塔上按升级',
      '升到顶可获得英雄武将',
      '科技树解锁特殊效果',
      '阵营决定可获得武将',
    ];

    for (let i = 0; i < helpLines.length; i++) {
      this.renderer.drawText(helpLines[i], 20, 50 + i * 18, 0xFCFFCD, 10);
    }
  }

  // ====== 新增: 版权信息渲染 (对应原版 case 20/21) ======
  private renderCredits(): void {
    this.renderer.setColor(0x0B1C19);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    this.renderer.drawText('版权信息', LOGICAL_WIDTH / 2 - 28, 20, 0xFFD700, 14);
    this.renderer.drawText('点击返回', 4, 4, 0xAAAAFF, 10);

    const lines = [
      '危城无双之三国群英',
      '原版: J2ME 手机游戏',
      'H5重制版',
      '',
      '基于反编译源码还原',
      '保留原版游戏机制',
      '',
      '本作为学习研究用途',
    ];

    for (let i = 0; i < lines.length; i++) {
      this.renderer.drawText(lines[i], 20, 50 + i * 18, 0xFCFFCD, 10);
    }
  }

  private renderGameOver(): void {
    this.renderer.setColor(COLORS.TEXT);
    this.renderer.drawText('游戏结束', LOGICAL_WIDTH / 2 - 30, 140, 0xFF0000, 14);
    this.renderer.drawText('点击重新开始', LOGICAL_WIDTH / 2 - 40, 180, 0xFCFFCD, 10);
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
  // 新增: 结局动画渲染 (对应原版 renderEndingAnim / state 46/47/48)
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
    // 淡入阶段前半段: 全黑; 后半段: 显示内容
    // 淡出阶段前半段: 显示内容; 后半段: 全黑
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

  // ====== 新增: 文字换行绘制工具方法 ======
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

  // ============================================================
  // 新增: 自由模式通关结算 (H5新增状态)
  // ============================================================
  private renderFreePlayComplete(): void {
    this.renderer.setColor(0x0B1C19);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    // 标题
    this.renderer.drawText('自由模式通关', LOGICAL_WIDTH / 2 - 50, 60, 0xFFD700, 14);

    // 统计信息
    const stats = [
      `击杀总数: ${this.totalKills}`,
      `金币总计: ${this.totalGoldEarned}`,
      `游戏时长: ${Math.floor(this.playTime)}秒`,
      `已觉醒武将: ${this.techTree.getAwakenedHeroes().length}`,
    ];
    for (let i = 0; i < stats.length; i++) {
      this.renderer.drawText(stats[i], 40, 100 + i * 22, 0xFCFFCD, 11);
    }

    // 提示
    this.renderer.drawText('点击返回菜单', LOGICAL_WIDTH / 2 - 40, 240, 0xAAAAFF, 10);
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

    // 设置瓦片图集
    // 原版使用 map0-map6.png 作为地图瓦片图集 (不是 t0_0_64x50.png)
    // map图集为 64px宽 × N*16px高, 每16x16一个tile, 4列
    // MapData 内部会根据关卡自动选择对应的 map图集
    await this.mapData.preloadAtlases();

    this.state = GameState.MENU;
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
