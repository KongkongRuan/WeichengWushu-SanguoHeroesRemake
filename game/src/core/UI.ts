/**
 * UI系统 - 触屏友好的建造/升级面板
 * 原版为按键操作，H5版使用现代化触屏UI
 * 美化: 使用原版塔名称、科技树信息、武将觉醒状态
 */
import { Renderer } from './Renderer';
import { LOGICAL_WIDTH, LOGICAL_HEIGHT, COLORS } from '../data/gameData';
import { TOWER_NAMES, TOWER_DESCRIPTIONS, TECH_EFFECTS, HEROES, FACTION_NAMES } from '../data/heroes';
import type { Tower } from './Tower';
import type { TechTreeSystem, BranchState } from './TechTree';

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

// 塔类型配置 (UI显示用)
interface TowerTypeConfig {
  type: number;
  name: string;
  cost: number;
  icon: string;
  color: number;
  description: string;
}

// 原版塔配置 (0-9为可建造, 10-12为装置)
const TOWER_UI_CONFIGS: TowerTypeConfig[] = [
  { type: 0, name: TOWER_NAMES[0]  || '石灰瓶', cost: 50,  icon: '◆', color: 0x8B4513, description: TOWER_DESCRIPTIONS[0] || '' },
  { type: 1, name: TOWER_NAMES[1]  || '断龙闸', cost: 100, icon: '▼', color: 0x696969, description: TOWER_DESCRIPTIONS[1] || '' },
  { type: 2, name: TOWER_NAMES[2]  || '突刺',   cost: 80,  icon: '▲', color: 0x4169E1, description: TOWER_DESCRIPTIONS[2] || '' },
  { type: 3, name: TOWER_NAMES[3]  || '擂木',   cost: 70,  icon: '■', color: 0x00CED1, description: TOWER_DESCRIPTIONS[3] || '' },
  { type: 4, name: TOWER_NAMES[4]  || '烟火',   cost: 120, icon: '✦', color: 0xFF4500, description: TOWER_DESCRIPTIONS[4] || '' },
  { type: 5, name: TOWER_NAMES[5]  || '投石',   cost: 90,  icon: '●', color: 0x8B6914, description: TOWER_DESCRIPTIONS[5] || '' },
  { type: 6, name: TOWER_NAMES[6]  || '麻痹矢', cost: 110, icon: '➤', color: 0x9370DB, description: TOWER_DESCRIPTIONS[6] || '' },
  { type: 7, name: TOWER_NAMES[7]  || '沸水',   cost: 85,  icon: '~', color: 0x1E90FF, description: TOWER_DESCRIPTIONS[7] || '' },
  { type: 8, name: TOWER_NAMES[8]  || '寒冰',   cost: 95,  icon: '❄', color: 0x00CED1, description: TOWER_DESCRIPTIONS[8] || '' },
  { type: 9, name: TOWER_NAMES[9]  || '滚油',   cost: 130, icon: '♨', color: 0xFF6347, description: TOWER_DESCRIPTIONS[9] || '' },
];

export class UISystem {
  private renderer: Renderer;
  private buttons: Button[] = [];
  private buttonCallback: ButtonCallback | null = null;
  private techTree: TechTreeSystem | null = null;

  // 面板状态
  private buildPanelVisible: boolean = false;
  private upgradePanelVisible: boolean = false;
  private techPanelVisible: boolean = false;
  private buildPanelX: number = 0;
  private buildPanelY: number = 0;
  private selectedTower: Tower | null = null;

  // 消息
  private messageText: string = '';
  private messageTimer: number = 0;

  // 武将觉醒提示
  private heroAwakenText: string = '';
  private heroAwakenTimer: number = 0;

  // ====== 新增: 游戏控制状态 (对应原版 isPausedInGame / 速度切换) ======
  // 游戏速度 (1=正常, 2=2倍速, 3=3倍速)
  private gameSpeed: number = 1;
  // 是否暂停
  private paused: boolean = false;
  // 是否显示暂停菜单
  private pauseMenuVisible: boolean = false;

  // ====== 新增: 科技树面板翻页状态 ======
  // 当前科技树页码 (0-based)
  private techPage: number = 0;
  // 每页显示的分支数
  private readonly techPageItems: number = 4;
  // 总页数 (在 renderTechPanel 时动态计算)
  private techPageCount: number = 1;

  constructor(renderer: Renderer) {
    this.renderer = renderer;
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
   * 显示建造面板
   */
  showBuildPanel(tileX: number, tileY: number): void {
    this.buildPanelVisible = true;
    this.buildPanelX = tileX;
    this.buildPanelY = tileY;
    this.upgradePanelVisible = false;
    this.techPanelVisible = false;
    this.updateButtons();
  }

  /**
   * 隐藏建造面板
   */
  hideBuildPanel(): void {
    this.buildPanelVisible = false;
    this.updateButtons();
  }

  /**
   * 显示升级面板
   */
  showUpgradePanel(tileX: number, tileY: number, tower: Tower): void {
    this.upgradePanelVisible = true;
    this.selectedTower = tower;
    this.buildPanelX = tileX;
    this.buildPanelY = tileY;
    this.buildPanelVisible = false;
    this.techPanelVisible = false;
    this.updateButtons();
  }

  /**
   * 隐藏升级面板
   */
  hideUpgradePanel(): void {
    this.upgradePanelVisible = false;
    this.selectedTower = null;
    this.updateButtons();
  }

  /**
   * 显示科技树面板
   */
  showTechPanel(): void {
    this.techPanelVisible = true;
    this.buildPanelVisible = false;
    this.upgradePanelVisible = false;
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
    this.heroAwakenTimer = 180; // 3秒
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
    this.updateButtons();
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

    // ====== 新增: 顶部右侧控制按钮 (暂停/加速/菜单) ======
    // 对应原版 isPausedInGame 切换和音量键处理
    if (!this.buildPanelVisible && !this.upgradePanelVisible) {
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

    // ====== 新增: 暂停菜单按钮 ======
    if (this.pauseMenuVisible) {
      // 暂停菜单覆盖在屏幕中央
      const menuW = 120;
      const menuH = 100;
      const menuX = (LOGICAL_WIDTH - menuW) / 2;
      const menuY = (LOGICAL_HEIGHT - menuH) / 2;
      const itemH = 22;

      // 继续
      this.buttons.push({
        x: menuX, y: menuY, w: menuW, h: itemH,
        label: '继续游戏', icon: '▶', color: 0x4CAF50,
        action: 'resume', visible: true, enabled: true,
      });
      // 重新开始
      this.buttons.push({
        x: menuX, y: menuY + itemH + 2, w: menuW, h: itemH,
        label: '重新开始', icon: '↻', color: 0xFFC107,
        action: 'restart', visible: true, enabled: true,
      });
      // 返回主菜单
      this.buttons.push({
        x: menuX, y: menuY + (itemH + 2) * 2, w: menuW, h: itemH,
        label: '返回主菜单', icon: '☰', color: 0xF44336,
        action: 'back_to_menu', visible: true, enabled: true,
      });
      // 存档
      this.buttons.push({
        x: menuX, y: menuY + (itemH + 2) * 3, w: menuW, h: itemH,
        label: '保存进度', icon: '💾', color: 0x2196F3,
        action: 'save_game', visible: true, enabled: true,
      });
      return;
    }

    // 底部建造栏按钮 (无面板时显示)
    if (!this.buildPanelVisible && !this.upgradePanelVisible) {
      // 显示前5种塔的快捷建造按钮
      const visibleTowers = TOWER_UI_CONFIGS.slice(0, 5);
      const btnW = 42;
      const btnH = 34;
      const gap = 2;
      const totalW = visibleTowers.length * (btnW + gap) - gap;
      const startX = (LOGICAL_WIDTH - totalW - 50) / 2;
      const y = LOGICAL_HEIGHT - btnH - 4;

      for (let i = 0; i < visibleTowers.length; i++) {
        const t = visibleTowers[i];
        this.buttons.push({
          x: startX + i * (btnW + gap),
          y,
          w: btnW,
          h: btnH,
          label: t.name,
          icon: t.icon,
          color: t.color,
          action: 'select_tower',
          data: t.type,
          visible: true,
          enabled: true,
        });
      }

      // 科技树按钮
      this.buttons.push({
        x: startX + totalW + gap,
        y,
        w: 42,
        h: btnH,
        label: '科技',
        icon: '★',
        color: 0xFFD700,
        action: 'show_tech',
        visible: true,
        enabled: true,
      });
    }

    // 建造面板
    if (this.buildPanelVisible) {
      const panelW = 110;
      const visibleTowers = TOWER_UI_CONFIGS;
      const panelH = visibleTowers.length * 22 + 30;
      const panelX = LOGICAL_WIDTH - panelW - 6;
      const panelY = LOGICAL_HEIGHT - panelH - 38;

      // 取消按钮
      this.buttons.push({
        x: panelX, y: panelY - 20, w: panelW, h: 18,
        label: '取消', icon: '✕', color: 0x8B0000,
        action: 'cancel', visible: true, enabled: true,
      });

      for (let i = 0; i < visibleTowers.length; i++) {
        const t = visibleTowers[i];
        this.buttons.push({
          x: panelX, y: panelY + i * 22 + 24, w: panelW, h: 20,
          label: `${t.name} ${t.cost}金`,
          icon: t.icon,
          color: t.color,
          action: 'place',
          data: t.type,
          visible: true,
          enabled: true,
        });
      }
    }

    // 升级面板
    if (this.upgradePanelVisible && this.selectedTower) {
      const tower = this.selectedTower;
      const panelW = 110;
      const panelX = LOGICAL_WIDTH - panelW - 6;
      const panelY = LOGICAL_HEIGHT - 90;

      // 获取升级信息
      const upgradeInfo = this.techTree?.canUpgradeTech(tower);
      const canUpgrade = upgradeInfo?.canUpgrade ?? false;
      const nextEffect = this.techTree?.getNextTechEffect(tower);

      // 升级按钮
      this.buttons.push({
        x: panelX, y: panelY, w: panelW, h: 20,
        label: nextEffect ? `${nextEffect.name} ${nextEffect.cost}金` : '已满级',
        icon: '↑',
        color: canUpgrade ? 0x006400 : 0x444444,
        action: 'upgrade',
        visible: true,
        enabled: canUpgrade,
      });

      // 出售按钮
      this.buttons.push({
        x: panelX, y: panelY + 22, w: panelW, h: 20,
        label: '出售', icon: '$', color: 0x8B0000,
        action: 'sell', visible: true, enabled: true,
      });

      // 关闭按钮
      this.buttons.push({
        x: panelX, y: panelY + 44, w: panelW, h: 20,
        label: '关闭', icon: '✕', color: 0x333333,
        action: 'close', visible: true, enabled: true,
      });
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
    this.messageTimer = duration;
  }

  /**
   * 渲染UI
   */
  render(gold: number, lives: number, level: number, wave: number): void {
    // 顶部信息栏 - 半透明黑色背景
    this.renderer.setColor(0x000000);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, 20);

    // 信息栏文字 (左侧紧凑布局, 右侧留给控制按钮)
    this.renderer.drawText(`金:${gold}`, 2, 4, 0xFFD700, 10);
    this.renderer.drawText(`防:${lives}`, 50, 4, 0xFF4444, 10);
    this.renderer.drawText(`关:${level + 1}`, 92, 4, 0xFCFFCD, 10);
    this.renderer.drawText(`波:${wave}`, 128, 4, 0xFCFFCD, 10);

    // 显示已觉醒武将数量
    if (this.techTree) {
      const heroCount = this.techTree.getAwakenedHeroes().length;
      if (heroCount > 0) {
        this.renderer.drawText(`将:${heroCount}`, 164, 4, 0xFFD700, 10);
      }
    }

    // 底部按钮栏背景
    if (!this.buildPanelVisible && !this.upgradePanelVisible && !this.techPanelVisible) {
      this.renderer.setColor(0x111111);
      this.renderer.fillRect(0, LOGICAL_HEIGHT - 38, LOGICAL_WIDTH, 38);
    }

    // 渲染面板
    if (this.techPanelVisible) {
      this.renderTechPanel();
    }

    if (this.upgradePanelVisible && this.selectedTower) {
      this.renderUpgradeInfo();
    }

    if (this.buildPanelVisible) {
      this.renderBuildInfo();
    }

    // 渲染按钮
    for (const btn of this.buttons) {
      if (!btn.visible) continue;
      this.renderButton(btn);
    }

    // 消息提示
    if (this.messageTimer > 0) {
      this.messageTimer--;
      const tw = this.renderer.virtualContext.measureText(this.messageText).width + 10;
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
      this.heroAwakenTimer--;
      const y = 60;
      this.renderer.setColor(0x000000);
      this.renderer.fillRect(0, y, LOGICAL_WIDTH, 30);
      this.renderer.setColor(0xFFD700);
      const tw = this.renderer.virtualContext.measureText(this.heroAwakenText).width;
      this.renderer.drawText(this.heroAwakenText, (LOGICAL_WIDTH - tw) / 2, y + 8, 0xFFD700, 14);
    }

    // ====== 新增: 暂停菜单遮罩 ======
    if (this.pauseMenuVisible) {
      this.renderPauseMenu();
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
   * 渲染建造面板信息
   */
  private renderBuildInfo(): void {
    const panelW = 110;
    const panelX = LOGICAL_WIDTH - panelW - 6;
    const panelY = LOGICAL_HEIGHT - (TOWER_UI_CONFIGS.length * 22 + 30) - 38;

    // 面板标题
    this.renderer.setColor(0x1a1a2a);
    this.renderer.fillRect(panelX, panelY, panelW, 20);
    this.renderer.setColor(0xFFD700);
    this.renderer.drawRect(panelX, panelY, panelW, 20);
    this.renderer.drawText('选择建筑', panelX + 30, panelY + 4, 0xFFD700, 10);
  }

  /**
   * 渲染升级面板信息
   */
  private renderUpgradeInfo(): void {
    if (!this.selectedTower) return;

    const tower = this.selectedTower;
    const panelW = 110;
    const panelX = LOGICAL_WIDTH - panelW - 6;
    const infoY = 24;

    // 塔信息面板
    this.renderer.setColor(0x0a0a1a);
    this.renderer.fillRect(panelX, infoY, panelW, 80);
    this.renderer.setColor(0x444466);
    this.renderer.drawRect(panelX, infoY, panelW, 80);

    // 塔名称
    const towerName = TOWER_NAMES[tower.type] || `塔${tower.type}`;
    this.renderer.drawText(towerName, panelX + 4, infoY + 4, 0xFCFFCD, 10);

    // 等级
    this.renderer.drawText(`等级: ${tower.level}`, panelX + 4, infoY + 18, 0xFCFFCD, 9);

    // 属性
    this.renderer.drawText(`攻击: ${tower.damage}`, panelX + 4, infoY + 32, 0xFFD700, 9);
    this.renderer.drawText(`范围: ${tower.range}`, panelX + 4, infoY + 44, 0x00FF00, 9);
    this.renderer.drawText(`速度: ${tower.fireRate}`, panelX + 4, infoY + 56, 0x00CED1, 9);

    // 武将状态
    if (tower.heroId >= 0) {
      const hero = HEROES.find(h => h.id === tower.heroId);
      if (hero) {
        this.renderer.drawText(`武将: ${hero.name}`, panelX + 4, infoY + 68, 0xFFD700, 9);
      }
    }

    // 下一个科技效果信息
    if (this.techTree) {
      const nextEffect = this.techTree.getNextTechEffect(tower);
      if (nextEffect) {
        this.renderer.drawText(`下一级:`, panelX + 4, infoY + 82, 0xAAAAFF, 8);
        this.renderer.drawText(nextEffect.name, panelX + 4, infoY + 92, 0xAAAAFF, 8);
      } else {
        this.renderer.drawText('已达最高级', panelX + 4, infoY + 82, 0xFFD700, 8);
      }
    }
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

  update(): void {
    // UI更新逻辑
  }

  // ============================================================
  // 新增: 暂停菜单渲染 (对应原版 isPausedInGame 时叠加层)
  // ============================================================
  private renderPauseMenu(): void {
    // 半透明遮罩
    this.renderer.setColor(0x000000);
    this.renderer.fillRect(0, 0, LOGICAL_WIDTH, LOGICAL_HEIGHT);

    // 菜单边框
    const menuW = 120;
    const menuH = 100;
    const menuX = (LOGICAL_WIDTH - menuW) / 2;
    const menuY = (LOGICAL_HEIGHT - menuH) / 2;

    this.renderer.setColor(0x1a1a2a);
    this.renderer.fillRect(menuX, menuY, menuW, menuH);
    this.renderer.setColor(0xFFD700);
    this.renderer.drawRect(menuX, menuY, menuW, menuH);

    // 标题
    this.renderer.drawText('已暂停', (LOGICAL_WIDTH - 36) / 2, menuY - 14, 0xFFD700, 12);
  }
}
