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
  STORY_LEVEL_SEQUENCE,
  KILL_REWARD,
  ENEMY_COUNT_PER_LEVEL,
  MULTI_PATH_FLAG,
  COLORS,
} from '../data/gameData';
import { Faction, LEVELS, HEROES } from '../data/heroes';

export enum GameState {
  LOADING = 0,
  MENU = 1,
  PLAYING = 2,
  PAUSED = 3,
  GAME_OVER = 4,
  VICTORY = 5,
  LEVEL_COMPLETE = 6,
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

  // 统计
  private totalKills: number = 0;
  private totalGoldEarned: number = 0;
  private playTime: number = 0;

  // 地图偏移 (居中显示)
  private mapOffsetX: number = 0;
  private mapOffsetY: number = 0;

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

    this.uiSystem.setButtonCallback((btn) => this.handleButton(btn));
    this.uiSystem.setTechTree(this.techTree);
  }

  /**
   * 设置输入
   */
  private setupInput(): void {
    this.inputSystem.onTap((x, y) => this.handleTap(x, y));
    this.inputSystem.onMove((x, y) => {
      if (this.towerSystem.isBuildMode) {
        const tile = this.inputSystem.toTile(x, y, this.mapOffsetX, this.mapOffsetY);
        this.towerSystem.setBuildPosition(tile.tx, tile.ty);
      }
    });
  }

  /**
   * 处理点击
   */
  private handleTap(x: number, y: number): void {
    if (this.state !== GameState.PLAYING) return;

    // 先检查UI按钮
    if (this.uiSystem.handleTap(x, y)) return;

    // 检查地图点击
    const tile = this.inputSystem.toTile(x, y, this.mapOffsetX, this.mapOffsetY);

    if (this.towerSystem.isBuildMode) {
      // 建造模式下不处理
      return;
    }

    // 检查是否点击了已有塔
    const tower = this.towerSystem.selectTower(tile.tx, tile.ty);
    if (tower) {
      this.uiSystem.showUpgradePanel(tile.tx, tile.ty, tower);
    } else {
      this.towerSystem.deselectTower();
      this.uiSystem.hideUpgradePanel();
      this.uiSystem.hideBuildPanel();
    }
  }

  /**
   * 处理按钮点击
   */
  private handleButton(btn: Button): void {
    switch (btn.action) {
      case 'select_tower':
        this.towerSystem.enterBuildMode();
        this.uiSystem.showBuildPanel(0, 0);
        break;
      case 'place':
        if (btn.data !== undefined) {
          const buildPos = this.towerSystem.getBuildPosition();
          const success = this.towerSystem.placeTower(
            buildPos.tx,
            buildPos.ty,
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
      case 'close':
      case 'cancel':
        this.towerSystem.exitBuildMode();
        this.uiSystem.hideBuildPanel();
        this.uiSystem.hideUpgradePanel();
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
   * 更新地图偏移 (居中)
   */
  private updateMapOffset(): void {
    const mapW = this.mapData.mapWidthPx;
    const mapH = this.mapData.mapHeightPx;
    this.mapOffsetX = Math.max(0, (LOGICAL_WIDTH - mapW) / 2);
    this.mapOffsetY = 20; // 顶部留出信息栏
  }

  /**
   * 加载关卡
   */
  async loadLevel(level: number): Promise<void> {
    this.currentLevel = level;
    await this.mapData.loadLevel(level);
    this.updateMapOffset();

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

    this.state = GameState.PLAYING;
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
    this.levelIndex++;
    if (this.levelIndex >= STORY_LEVEL_SEQUENCE.length - 1) {
      this.state = GameState.VICTORY;
      return;
    }
    const nextLevel = STORY_LEVEL_SEQUENCE[this.levelIndex];
    if (nextLevel === 21) {
      this.state = GameState.VICTORY;
      return;
    }
    this.gold += 1000; // 通关奖励
    this.totalGoldEarned += 1000;
    await this.loadLevel(nextLevel);
  }

  /**
   * 游戏主循环
   */
  private gameLoop = (timestamp: number): void => {
    const dt = Math.min(33, timestamp - this.lastTime) / 16.67; // 归一化到60fps
    this.lastTime = timestamp;
    this.frameCount++;

    if (this.state === GameState.PLAYING) {
      this.update(dt);
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

    this.enemySystem.update(dt);
    this.towerSystem.update(this.enemySystem.getActiveEnemies(), this.mapOffsetX, this.mapOffsetY);

    // 检查关卡完成
    if (this.enemySystem.killed >= this.getMaxEnemies()) {
      this.state = GameState.LEVEL_COMPLETE;
      this.autoSave();
    }

    this.uiSystem.update();

    // 自动存档
    this.saveSystem.updateAutoSave(dt, () => this.autoSave());
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

    if (this.state === GameState.PLAYING || this.state === GameState.PAUSED) {
      // 渲染地图
      this.mapData.render(this.mapOffsetX, this.mapOffsetY);

      // 渲染路径高亮 (建造模式)
      if (this.towerSystem.isBuildMode) {
        this.mapData.renderPathOverlay(this.mapOffsetX, this.mapOffsetY);
      }

      // 渲染塔
      this.towerSystem.render(this.mapOffsetX, this.mapOffsetY);

      // 渲染敌人
      this.enemySystem.render(this.mapOffsetX, this.mapOffsetY);

      // 渲染UI
      this.uiSystem.render(this.gold, this.lives, this.currentLevel, this.wave);
    } else if (this.state === GameState.MENU) {
      this.renderMenu();
    } else if (this.state === GameState.GAME_OVER) {
      this.renderGameOver();
    } else if (this.state === GameState.VICTORY) {
      this.renderVictory();
    } else if (this.state === GameState.LEVEL_COMPLETE) {
      this.renderLevelComplete();
    }

    this.renderer.present();
  }

  /**
   * 渲染菜单
   */
  private renderMenu(): void {
    this.renderer.setColor(COLORS.TEXT);
    this.renderer.drawText('危城无双之三国群英', LOGICAL_WIDTH / 2 - 60, 100, 0xFFD700, 16);
    this.renderer.drawText('点击开始游戏', LOGICAL_WIDTH / 2 - 40, 180, 0xFCFFCD, 12);

    // 显示存档信息
    if (this.saveSystem.hasSave()) {
      const summary = this.saveSystem.getSaveSummary();
      if (summary) {
        this.renderer.drawText(`存档: ${summary.level} 金币:${summary.gold} 武将:${summary.heroes}`, LOGICAL_WIDTH / 2 - 70, 210, 0xAAAAFF, 9);
        this.renderer.drawText(`存档时间: ${summary.time}`, LOGICAL_WIDTH / 2 - 40, 224, 0x888888, 8);
      }
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
    const tileset = this.spriteLoader.getTileset();
    if (tileset) {
      this.mapData.setTileset(tileset, Math.floor(tileset.width / TILE_SIZE));
    }

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
