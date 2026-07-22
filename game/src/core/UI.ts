/**
 * UI系统 - 顶部信息栏/控制按钮/暂停菜单/消息
 * 任务A: 旧"选择建筑"大字列表弹窗与底部快捷建造栏已移除,
 *        建造/升级改为原版底部图标栏 (BuildBarSystem, 见 BuildBar.ts)
 */
import { Renderer } from './Renderer';
import { LOGICAL_WIDTH, LOGICAL_HEIGHT, COLORS } from '../data/gameData';
import { TOWER_NAMES, FACTION_NAMES, GAME_HELP_TEXT, GAME_DESCRIPTION_TEXT, COPYRIGHT_TEXT } from '../data/heroes';
import type { TechTreeSystem, BranchState } from './TechTree';
import type { SpriteLoader } from './SpriteLoader';

export interface Button {
  x: number;
  y: number;
  w: number;
  h: number;
  label: string;
  icon: string;
  color: number;
  action: string;
  data?: any;
  visible: boolean;
  enabled: boolean;
}

type ButtonCallback = (button: Button) => void;
type PausePage = 'main' | 'cheats' | 'cheat_rules' | 'settings' | 'help' | 'about';

const CHEAT_RULES_TEXT = [
  '常驻军令最多5枚。',
  '获得方式：',
  '·新关卡首次通关 +1',
  '·正攻首次无人入城 +1',
  '·正攻从第2波起，准备就绪后5秒内出兵 +1',
  '·同关连续失败2次：救援军令×1',
  '救援军令仅限本关，通关后清除。',
  '每项锦囊每关限用一次。',
  '使用后记为“奇谋”；未使用记为“正攻”并留下★。',
  '通关王者之路后解锁沙盒，无限使用金手指。',
].join('\n');

export class UISystem {
  private renderer: Renderer;
  private buttons: Button[] = [];
  private buttonCallback: ButtonCallback | null = null;
  private techTree: TechTreeSystem | null = null;
  private spriteLoader: SpriteLoader | null = null;

  // 面板状态
  private techPanelVisible: boolean = false;

  // 消息
  private messageText: string = '';
  private messageTimer: number = 0;

  // 武将觉醒提示
  private heroAwakenText: string = '';
  private heroAwakenTimer: number = 0;

  private bossBannerName: string = '';
  private bossBannerPortrait: number = -1;
  private bossBannerTimer: number = 0;

  // 原版 # 键的触屏入口：只有清场且本波刷完时才显示。
  private waveReady: boolean = false;

  // ====== 新增: 游戏控制状态 (对应原版 isPausedInGame / 速度切换) ======
  // 游戏速度 (1=正常, 2=2倍速, 3=3倍速)
  private gameSpeed: number = 1;
  // 是否暂停
  private paused: boolean = false;
  // 是否显示暂停菜单
  private pauseMenuVisible: boolean = false;
  // 原版暂停菜单：主菜单/金手指/帮助/关于页
  private pausePage: PausePage = 'main';
  private audioEnabled: boolean = true;
  private audioVolume: number = 0.5;
  private graphicsQuality: 1 | 2 = 2;
  private cheatCommandPoints: number = 0;
  private cheatCommandMax: number = 5;
  private cheatRescuePoints: number = 0;
  private cheatSandboxMode: boolean = false;
  private cheatUsedActions: Set<string> = new Set();

  // ====== 新增: 科技树面板翻页状态 ======
  // 当前科技树页码 (0-based)
  private techPage: number = 0;
  // 每页显示的分支数
  private readonly techPageItems: number = 4;
  // 总页数 (在 renderTechPanel 时动态计算)
  private techPageCount: number = 1;

  constructor(renderer: Renderer) {
    this.renderer = renderer;
    this.updateButtons();
  }

  /**
   * 设置按钮回调
   */
  setButtonCallback(callback: ButtonCallback): void {
    this.buttonCallback = callback;
  }

  /**
   * 设置科技树引用
   */
  setTechTree(techTree: TechTreeSystem): void {
    this.techTree = techTree;
  }

  /**
   * 设置精灵图加载器 (软键条等原版UI素材)
   */
  setSpriteLoader(loader: SpriteLoader): void {
    this.spriteLoader = loader;
  }

  // ============================================================
  // 原版软键条 (对应原版 c(int,int) 行17192)
  // 底部灰条(y=309) + ui[4]底图(18,311,右侧镜像) + ui[2]帧:
  //   左键=帧leftFrame@(1,310), 右键=帧rightFrame@(221,310)
  // ui[2]四帧: 0菜单/1返回/2确定/3取消; 传-1则该侧不绘制
  // ============================================================
  renderSoftkeyBar(leftFrame: number, rightFrame: number): void {
    const r = this.renderer;
    // 底部灰条 + 底色
    r.setColor(0x6199D2);
    r.fillRect(0, 309, LOGICAL_WIDTH, 2);
    r.fillRect(0, 311, LOGICAL_WIDTH, 9);
    // ui[4] 底图 (左18px处 + 右侧镜像)
    const ui4 = this.spriteLoader?.getUISprite(4);
    if (ui4) {
      r.drawImage(ui4, 18, 311);
      r.drawImageFlipped(ui4, LOGICAL_WIDTH - 70 - 18, 311, true);
    }
    // ui[2] 软键文字帧
    const ui2 = this.spriteLoader?.getUISprite(2);
    if (ui2) {
      if (leftFrame >= 0) {
        r.drawImageRegion(ui2, 0, leftFrame * 10, 18, 10, 1, 310, 18, 10);
      }
      if (rightFrame >= 0) {
        r.drawImageRegion(ui2, 0, rightFrame * 10, 18, 10, 221, 310, 18, 10);
      }
    }
  }

  /**
   * 显示/隐藏科技树面板 (TechTree 增益层; 建造栏科技面板见 BuildBarSystem)
   */
  showTechPanel(): void {
    this.techPanelVisible = true;
    this.techPage = 0; // 重置到第一页
    this.updateButtons();
  }

  /**
   * 隐藏科技树面板
   */
  hideTechPanel(): void {
    this.techPanelVisible = false;
    this.updateButtons();
  }

  /**
   * 显示武将觉醒提示
   */
  showHeroAwakened(heroName: string): void {
    this.heroAwakenText = `武将觉醒: ${heroName}!`;
    this.heroAwakenTimer = 3000;
  }

  showBossBanner(name: string, portraitId: number): void {
    this.bossBannerName = name;
    this.bossBannerPortrait = portraitId;
    this.bossBannerTimer = 3000;
  }

  setWaveReady(ready: boolean): void {
    if (this.waveReady === ready) return;
    this.waveReady = ready;
    this.updateButtons();
  }

  // ============================================================
  // 新增: 游戏控制接口 (对应原版 handleVolumeInput / isPausedInGame)
  // ============================================================

  /**
   * 获取当前游戏速度
   */
  getGameSpeed(): number {
    return this.gameSpeed;
  }

  /**
   * 设置游戏速度
   */
  setGameSpeed(speed: number): void {
    this.gameSpeed = Math.max(1, Math.min(3, speed));
  }

  /**
   * 切换游戏速度 (1 -> 2 -> 3 -> 1)
   */
  cycleGameSpeed(): void {
    this.gameSpeed = (this.gameSpeed % 3) + 1;
  }

  /**
   * 是否暂停
   */
  isPaused(): boolean {
    return this.paused;
  }

  /**
   * 设置暂停状态
   */
  setPaused(paused: boolean): void {
    this.paused = paused;
    this.pauseMenuVisible = paused;
    if (paused) this.pausePage = 'main';
    this.updateButtons();
  }

  get pauseMenuPage(): PausePage {
    return this.pausePage;
  }

  openPausePage(page: PausePage): void {
    this.pausePage = page;
    this.pauseMenuVisible = true;
    this.paused = true;
    this.updateButtons();
  }

  setAudioSettings(enabled: boolean, volume: number, graphicsQuality: 1 | 2 = this.graphicsQuality): void {
    this.audioEnabled = enabled;
    this.audioVolume = Math.max(0, Math.min(1, volume));
    this.graphicsQuality = graphicsQuality;
    if (this.pausePage === 'settings') this.updateButtons();
  }

  setCheatStatus(status: {
    commandPoints: number;
    maxCommandPoints: number;
    rescuePoints: number;
    sandboxMode: boolean;
    usedActions: string[];
  }): void {
    this.cheatCommandPoints = Math.max(0, status.commandPoints | 0);
    this.cheatCommandMax = Math.max(1, status.maxCommandPoints | 0);
    this.cheatRescuePoints = Math.max(0, status.rescuePoints | 0);
    this.cheatSandboxMode = status.sandboxMode;
    this.cheatUsedActions = new Set(status.usedActions);
    if (this.pausePage === 'cheats') this.updateButtons();
  }

  /**
   * 切换暂停
   */
  togglePause(): void {
    this.setPaused(!this.paused);
  }

  /**
   * 是否显示暂停菜单
   */
  isPauseMenuVisible(): boolean {
    return this.pauseMenuVisible;
  }

  /**
   * 上一页科技树
   */
  techPrevPage(): void {
    if (this.techPage > 0) {
      this.techPage--;
      this.updateButtons();
    }
  }

  /**
   * 下一页科技树
   */
  techNextPage(): void {
    if (this.techPage < this.techPageCount - 1) {
      this.techPage++;
      this.updateButtons();
    }
  }

  /**
   * 设置当前科技树页码
   */
  setTechPage(page: number): void {
    this.techPage = Math.max(0, Math.min(this.techPageCount - 1, page));
    this.updateButtons();
  }

  /**
   * 获取当前科技树页码
   */
  getTechPage(): number {
    return this.techPage;
  }

  /**
   * 获取科技树总页数
   */
  getTechPageCount(): number {
    return this.techPageCount;
  }

  /**
   * 更新按钮列表
   */
  private updateButtons(): void {
    this.buttons = [];

    if (this.techPanelVisible) {
      // 科技树面板 - 显示关闭按钮 + 翻页按钮
      const panelW = 200;
      const panelX = (LOGICAL_WIDTH - panelW) / 2;
      const panelY = 30;

      // 关闭按钮 (右上角)
      this.buttons.push({
        x: panelX + panelW - 30, y: panelY, w: 28, h: 18,
        label: '关闭', icon: '✕', color: 0x8B0000,
        action: 'close_tech', visible: true, enabled: true,
      });

      // ====== 新增: 翻页按钮 ======
      // 上一页按钮 (左下角)
      const navY = panelY + 260 + 4;
      this.buttons.push({
        x: panelX + 10, y: navY, w: 50, h: 18,
        label: '◀ 上一页', icon: '◀', color: 0x555566,
        action: 'tech_prev_page', visible: true, enabled: this.techPage > 0,
      });
      // 下一页按钮 (右下角)
      this.buttons.push({
        x: panelX + panelW - 60, y: navY, w: 50, h: 18,
        label: '下一页 ▶', icon: '▶', color: 0x555566,
        action: 'tech_next_page', visible: true, enabled: this.techPage < this.techPageCount - 1,
      });
      return;
    }

    // ====== 顶部右侧控制按钮 (暂停/加速/菜单) ======
    // 对应原版 isPausedInGame 切换和音量键处理
    {
      // 三个控制按钮在顶部信息栏右侧
      const ctrlY = 2;
      const ctrlH = 16;
      const ctrlW = 22;
      const ctrlGap = 1;
      // 从右到左: 菜单 > 暂停 > 速度
      let ctrlX = LOGICAL_WIDTH - ctrlW - 2;

      // 菜单按钮
      this.buttons.push({
        x: ctrlX, y: ctrlY, w: ctrlW, h: ctrlH,
        label: '☰', icon: '☰', color: 0x555566,
        action: 'menu', visible: true, enabled: true,
      });
      ctrlX -= (ctrlW + ctrlGap);

      // 暂停按钮
      this.buttons.push({
        x: ctrlX, y: ctrlY, w: ctrlW, h: ctrlH,
        label: this.paused ? '▶' : 'II',
        icon: this.paused ? '▶' : 'II',
        color: this.paused ? 0x4CAF50 : 0xFFC107,
        action: 'pause', visible: true, enabled: true,
      });
      ctrlX -= (ctrlW + ctrlGap);

      // 速度按钮
      this.buttons.push({
        x: ctrlX, y: ctrlY, w: ctrlW, h: ctrlH,
        label: `${this.gameSpeed}x`, icon: '⚡', color: 0x00CED1,
        action: 'speed_up', visible: true, enabled: true,
      });
    }

    // 浮在战场右上角的大触控按钮，恢复原版手动出兵节奏。
    if (this.waveReady && !this.paused) {
      this.buttons.push({
        x: LOGICAL_WIDTH - 66, y: 23, w: 62, h: 24,
        label: '出兵 ▶', icon: '▶', color: 0x2F7A5A,
        action: 'start_wave', visible: true, enabled: true,
      });
    }
    // ====== 暂停菜单按钮 ======
    if (this.pauseMenuVisible) {
      // 原版菜单文字为 b1015[107..112]：继续、金手指、设置、帮助、关于、退出。
      // 金手指页对应 b1015[175..179] 的五项作弊功能。
      if (this.pausePage === 'cheat_rules') {
        const menuW = 196;
        const menuH = 230;
        const menuX = (LOGICAL_WIDTH - menuW) / 2;
        const menuY = (LOGICAL_HEIGHT - menuH) / 2;
        this.buttons.push({
          x: menuX + 8, y: menuY + menuH - 30, w: menuW - 16, h: 22,
          label: '返回金手指', icon: '', color: 0xDAB043,
          action: 'open_cheats', visible: true, enabled: true,
        });
        return;
      }
      const menuW = 164;
      const itemH = 24;
      const cheatAvailable = this.cheatCommandPoints + this.cheatRescuePoints;
      const cheatLabel = (label: string, action: string, cost: number): [string, string, boolean] => {
        if (this.cheatSandboxMode) return [`${label} [∞]`, action, true];
        if (this.cheatUsedActions.has(action)) return [`${label} [已用]`, action, false];
        return [`${label} [${cost}令]`, action, cheatAvailable >= cost];
      };
      const labels: [string, string, boolean?][] = this.pausePage === 'main'
        ? [
            ['继续游戏', 'resume'], ['金手指', 'open_cheats'],
            ['设置', 'pause_settings'], ['帮助', 'pause_help'],
            ['关于', 'pause_about'], ['退出', 'back_to_menu'],
          ] : (this.pausePage === 'cheats' ? [
            cheatLabel('获得500金', 'cheat_gold', 1),
            cheatLabel('城防加10', 'cheat_defense', 2),
            cheatLabel('消灭当前全部敌人', 'cheat_clear_enemies', 2),
            cheatLabel('消灭敌人金币翻倍', 'cheat_gold_double', 3),
            cheatLabel('获得全部科技', 'cheat_all_tech', 5),
            ['军令规则', 'open_cheat_rules'],
            ['返回上级', 'cheat_back'],
          ] : (this.pausePage === 'settings' ? [
            [`声音：${this.audioEnabled ? '开' : '关'}`, 'toggle_sound'],
            [`音量：${Math.round(this.audioVolume * 100)}%`, 'volume_up'],
            ['降低音量', 'volume_down'],
            [`画面：${this.graphicsQuality === 2 ? '高清重制' : '原版像素'}`, 'toggle_graphics'],
            ['返回上级', 'cheat_back'],
          ] : [['返回上级', 'cheat_back']]));
      const menuH = labels.length * itemH + 20;
      const menuX = (LOGICAL_WIDTH - menuW) / 2;
      const menuY = (LOGICAL_HEIGHT - menuH) / 2;
      labels.forEach(([label, action, enabled = true], index) => {
        this.buttons.push({
          x: menuX + 4, y: menuY + 10 + index * itemH, w: menuW - 8, h: itemH - 2,
          label, icon: '', color: index === labels.length - 1 ? 0xDAB043 : 0x5B7FA3,
          action, visible: true, enabled,
        });
      });
      return;
    }
  }

  /**
   * 检查点击位置是否命中按钮
   */
  handleTap(x: number, y: number): boolean {
    for (const btn of this.buttons) {
      if (!btn.visible || !btn.enabled) continue;
      if (x >= btn.x && x <= btn.x + btn.w && y >= btn.y && y <= btn.y + btn.h) {
        this.buttonCallback?.(btn);
        return true;
      }
    }
    return false;
  }

  /**
   * 显示消息
   */
  showMessage(text: string, duration: number = 120): void {
    this.messageText = text;
    // 对外仍兼容旧的 60FPS 帧数参数，内部统一换算成真实毫秒。
    this.messageTimer = duration * (1000 / 60);
  }

  /**
   * 渲染UI
   * @param wave 当前波 (aS)
   * @param totalWaves 总波数 (l1072[aN])
   */
  render(gold: number, lives: number, level: number, wave: number, totalWaves: number = 0): void {
    // 顶部信息栏 - 半透明黑色背景
    this.renderer.setColor(0x000000);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, 20);

    // 信息栏文字 (左侧紧凑布局, 右侧留给控制按钮)
    this.renderer.drawText(`金:${gold}`, 2, 4, 0xFFD700, 10);
    this.renderer.drawText(`防:${lives}`, 50, 4, 0xFF4444, 10);
    this.renderer.drawText(`关:${level + 1}`, 92, 4, 0xFCFFCD, 10);
    // 波次: 当前波/总波
    this.renderer.drawText(totalWaves > 0 ? `波:${wave}/${totalWaves}` : `波:${wave}`, 128, 4, 0xFCFFCD, 10);

    // 显示已觉醒武将数量
    if (this.techTree) {
      const heroCount = this.techTree.getAwakenedHeroes().length;
      if (heroCount > 0) {
        this.renderer.drawText(`将:${heroCount}`, 164, 4, 0xFFD700, 10);
      }
    }

    // 渲染面板
    if (this.techPanelVisible) {
      this.renderTechPanel();
    }

    // 暂停遮罩必须先画，按钮再画在遮罩上方；旧实现顺序相反，
    // 结果是按钮全部被黑色面板盖住，只剩“已暂停”（截图问题）。
    if (this.pauseMenuVisible) {
      this.renderPauseMenu();
    }

    // 渲染按钮
    for (const btn of this.buttons) {
      if (!btn.visible) continue;
      this.renderButton(btn);
    }

    if (this.bossBannerTimer > 0) {
      const x = 18;
      const y = 54;
      const w = LOGICAL_WIDTH - 36;
      const h = 42;
      this.renderer.setColor(0x2A1410);
      this.renderer.fillRect(x, y, w, h);
      this.renderer.setColor(0xFFD36A);
      this.renderer.drawRect(x, y, w, h);
      const portrait = this.spriteLoader?.getByPrefix('sp', this.bossBannerPortrait) ?? null;
      if (portrait) {
        this.renderer.drawImageRegion(portrait, 0, 0, portrait.width, portrait.height,
          x + 4, y + 3, 36, 36);
      }
      this.renderer.drawText('名将来袭', x + 47, y + 7, 0xFFCC66, 12);
      this.renderer.drawText(this.bossBannerName, x + 47, y + 23, 0xFCFFCD, 11);
    }

    // 消息提示
    if (this.messageTimer > 0) {
      const tw = this.renderer.measureText(this.messageText, 10).width + 10;
      const mx = (LOGICAL_WIDTH - tw) / 2;
      const my = 100;
      this.renderer.setColor(0x000000);
      this.renderer.fillRect(mx, my, tw, 18);
      this.renderer.setColor(0x333333);
      this.renderer.drawRect(mx, my, tw, 18);
      this.renderer.drawText(this.messageText, mx + 5, my + 4, 0xFCFFCD, 10);
    }

    // 武将觉醒提示
    if (this.heroAwakenTimer > 0) {
      const y = 60;
      this.renderer.setColor(0x000000);
      this.renderer.fillRect(0, y, LOGICAL_WIDTH, 30);
      this.renderer.setColor(0xFFD700);
      const tw = this.renderer.measureText(this.heroAwakenText, 14).width;
      this.renderer.drawText(this.heroAwakenText, (LOGICAL_WIDTH - tw) / 2, y + 8, 0xFFD700, 14);
    }

  }

  /**
   * 渲染按钮 (美化版)
   */
  private renderButton(btn: Button): void {
    // 按钮背景渐变
    const bgColor = btn.enabled ? 0x2a2a3a : 0x1a1a1a;
    this.renderer.setColor(bgColor);
    this.renderer.fillRect(btn.x, btn.y, btn.w, btn.h);

    // 按钮高光 (顶部)
    this.renderer.setColor(0x3a3a4a);
    this.renderer.fillRect(btn.x, btn.y, btn.w, 2);

    // 按钮边框
    this.renderer.setColor(btn.color);
    this.renderer.drawRect(btn.x, btn.y, btn.w, btn.h);

    // 按钮文字
    const textColor = btn.enabled ? 0xFCFFCD : 0x666666;
    this.renderer.drawText(btn.label, btn.x + 4, btn.y + (btn.h - 10) / 2, textColor, 8);
  }

  /**
   * 渲染科技树面板
   */
  private renderTechPanel(): void {
    if (!this.techTree) return;

    const panelW = 200;
    const panelH = 260;
    const panelX = (LOGICAL_WIDTH - panelW) / 2;
    const panelY = 30;

    // 面板背景
    this.renderer.setColor(0x0a0a1a);
    this.renderer.fillRect(panelX, panelY, panelW, panelH);
    this.renderer.setColor(0xFFD700);
    this.renderer.drawRect(panelX, panelY, panelW, panelH);

    // 标题 + 页码
    this.renderer.drawText('科技树', panelX + 70, panelY + 4, 0xFFD700, 12);

    // 分支列表 - 分页显示
    const branches = this.techTree.getBranches();
    this.techPageCount = Math.max(1, Math.ceil(branches.length / this.techPageItems));
    if (this.techPage >= this.techPageCount) this.techPage = this.techPageCount - 1;

    const startIdx = this.techPage * this.techPageItems;
    const endIdx = Math.min(startIdx + this.techPageItems, branches.length);

    // 页码指示器
    this.renderer.drawText(
      `第 ${this.techPage + 1}/${this.techPageCount} 页`,
      panelX + panelW - 70, panelY + 4, 0xAAAAFF, 9,
    );

    let y = panelY + 26;
    for (let i = startIdx; i < endIdx; i++) {
      const branch = branches[i];
      const branchName = this.getBranchName(branch.branchIndex);

      // 分支背景
      const bgColor = branch.unlocked ? 0x1a2a1a : 0x2a1a1a;
      this.renderer.setColor(bgColor);
      this.renderer.fillRect(panelX + 4, y, panelW - 8, 20);
      this.renderer.setColor(branch.unlocked ? 0x00FF00 : 0x666666);
      this.renderer.drawRect(panelX + 4, y, panelW - 8, 20);

      // 分支名称和进度
      const progress = `${branchName} ${branch.currentLevel}/${branch.maxLevel}`;
      this.renderer.drawText(progress, panelX + 8, y + 4, branch.unlocked ? 0xFCFFCD : 0x888888, 9);

      // 显示塔类型序列
      let typeStr = '';
      for (const t of branch.towerTypes) {
        typeStr += `${TOWER_NAMES[t] || '?'} `;
      }
      this.renderer.drawText(typeStr, panelX + 8, y + 12, 0xAAAAAA, 7);

      y += 24;
    }

    // 已觉醒武将 (仅在最后一页显示)
    if (this.techPage === this.techPageCount - 1) {
      const heroes = this.techTree.getAwakenedHeroes();
      if (heroes.length > 0 && y < panelY + panelH - 20) {
        this.renderer.drawText('已觉醒武将:', panelX + 4, y + 4, 0xFFD700, 9);
        y += 16;
        for (const hs of heroes) {
          if (y >= panelY + panelH - 12) break;
          this.renderer.drawText(`★ ${hs.hero.name} (${FACTION_NAMES[hs.faction]})`, panelX + 8, y, 0xFFD700, 9);
          y += 12;
        }
      }
    }

    // 翻页提示
    if (this.techPageCount > 1) {
      this.renderer.drawText(
        this.techPage > 0 ? '◀ 上页' : '',
        panelX + 4, panelY + panelH - 14, 0x888888, 8,
      );
      this.renderer.drawText(
        this.techPage < this.techPageCount - 1 ? '下页 ▶' : '',
        panelX + panelW - 60, panelY + panelH - 14, 0x888888, 8,
      );
    }
  }

  /**
   * 获取分支名称
   */
  private getBranchName(index: number): string {
    const names = [
      '基础塔系',
      '箭塔系',
      '炮塔系',
      '法塔系',
      '冰塔系',
      '火塔系',
      '特殊系',
    ];
    return names[index] || `分支${index}`;
  }

  update(elapsedMs: number = 0): void {
    const dt = Math.max(0, elapsedMs);
    this.messageTimer = Math.max(0, this.messageTimer - dt);
    this.heroAwakenTimer = Math.max(0, this.heroAwakenTimer - dt);
    this.bossBannerTimer = Math.max(0, this.bossBannerTimer - dt);
  }

  // ============================================================
  // 新增: 暂停菜单渲染 (对应原版 isPausedInGame 时叠加层)
  // ============================================================
  private renderPauseMenu(): void {
    // 半透明遮罩
    this.renderer.setColor(0x000000);
    this.renderer.virtualContext.globalAlpha = 0.72;
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);
    this.renderer.virtualContext.globalAlpha = 1;

    const rulesPage = this.pausePage === 'cheat_rules';
    const menuW = rulesPage ? 196 : 164;
    const itemH = 24;
    const count = this.pausePage === 'cheats' ? 7
      : this.pausePage === 'settings' ? 5
      : (this.pausePage === 'help' || this.pausePage === 'about' ? 1 : 6);
    const menuH = rulesPage ? 230 : count * itemH + 20;
    const menuX = (LOGICAL_WIDTH - menuW) / 2;
    const menuY = (LOGICAL_HEIGHT - menuH) / 2;

    this.renderer.setColor(0x1a1a2a);
    this.renderer.fillRect(menuX, menuY, menuW, menuH);
    this.renderer.setColor(0xFFD700);
    this.renderer.drawRect(menuX, menuY, menuW, menuH);

    // 标题和页说明
    const cheatTitle = this.cheatSandboxMode
      ? '金手指 · 沙盒无限'
      : `金手指 · 军令${this.cheatCommandPoints}/${this.cheatCommandMax}${this.cheatRescuePoints ? '+救援1' : ''}`;
    const title = this.pausePage === 'main' ? '已暂停'
      : this.pausePage === 'cheats' ? cheatTitle
      : this.pausePage === 'cheat_rules' ? '军令规则'
      : this.pausePage === 'settings' ? '设置'
      : this.pausePage === 'help' ? '游戏帮助' : '关于';
    this.renderer.drawText(title, (LOGICAL_WIDTH - title.length * 6) / 2, menuY - 14, 0xFFD700, 12);
    if (rulesPage) {
      this.renderer.setColor(0x11111D);
      this.renderer.fillRect(menuX + 6, menuY + 8, menuW - 12, menuH - 44);
      this.drawWrapped(CHEAT_RULES_TEXT, menuX + 10, menuY + 13, menuW - 20, 0xFCFFCD, 8, 11);
    } else if (this.pausePage === 'help' || this.pausePage === 'about') {
      this.renderer.setColor(0x11111D);
      this.renderer.fillRect(menuX + 6, menuY + 8, menuW - 12, menuH - 16);
      const text = this.pausePage === 'help' ? GAME_DESCRIPTION_TEXT : COPYRIGHT_TEXT;
      this.drawWrapped(text, menuX + 10, menuY + 12, menuW - 20, 0xFCFFCD, 8, 11);
    }
  }

  /** 在暂停说明页中绘制换行文本。 */
  private drawWrapped(text: string, x: number, y: number, maxW: number, color: number, size: number, lineH: number): void {
    const lines: string[] = [];
    for (const paragraph of text.split('\n')) {
      let line = '';
      for (const ch of paragraph) {
        const next = line + ch;
        if (this.renderer.measureText(next, size).width > maxW && line) {
          lines.push(line);
          line = ch;
        } else {
          line = next;
        }
      }
      lines.push(line);
    }
    const maxLines = Math.max(1, Math.floor((LOGICAL_HEIGHT - y - 30) / lineH));
    lines.slice(0, maxLines).forEach((line, i) => this.renderer.drawText(line, x, y + i * lineH, color, size));
  }
}
