/**
 * 存档系统 - 使用 localStorage 持久化游戏进度
 * 还原原版J2ME RMS (Record Management System) 存档机制
 *
 * 存档内容:
 * - 游戏进度: 当前关卡、金币、城防
 * - 科技树状态: 已解锁效果、分支进度
 * - 武将觉醒状态
 * - 游戏设置: 音量等
 * - 战役进度: factionX/upgradeAc/gameModeT/campaignAO/unlockedBattles
 * - 科技建筑层 (任务B): techBuildings(a1056)/castleParts(b1059)/unlockedTowers(e1105)
 */
import { STORY_LEVEL_SEQUENCE } from '../data/gameData';
import { HEROES, Faction } from '../data/heroes';
import type { TechTreeSystem, TechEffectInstance, HeroState } from './TechTree';
import type { Tower } from './Tower';

const SAVE_KEY = 'weicheng_save_v1';
const SETTINGS_KEY = 'weicheng_settings_v1';

// ============================================================
// 存档数据结构
// ============================================================
export interface SaveData {
  version: number;
  timestamp: number;

  // 游戏进度
  levelIndex: number;        // 关卡序列索引
  currentLevel: number;     // 当前关卡ID
  gold: number;             // 金币
  lives: number;            // 城防值

  // 科技树状态
  unlockedEffects: number[];  // 已解锁科技效果ID列表
  branchProgress: { branchIndex: number; currentLevel: number; unlocked: boolean }[];
  globalAtkBonus: number;
  globalFireRateBonus: number;
  reloadHalf: boolean;
  goldDouble: boolean;

  // 武将觉醒
  awakenedHeroes: { heroId: number; faction: number; towerId: number }[];
  currentFaction: number;

  // 塔布局 (可选保存)
  towers: {
    x: number; y: number; type: number; level: number; damage: number; range: number; fireRate: number;
    heroId: number; effectType: number; hp: number; maxHp: number;
    orientation?: number; gateLoaded?: boolean; gateState?: number;
  }[];

  // 统计
  totalKills: number;
  totalGoldEarned: number;
  playTime: number; // 秒

  // ====== 战役进度 (对应原版 X/ac/T/aO/d1073, 新增字段, 旧存档缺省) ======
  factionX?: number;          // X: 选择的国家 0蜀/1魏/2吴
  upgradeAc?: number;         // ac: 升级模式 0武系/1文系
  gameModeT?: number;         // T: 游戏模式 0王者之路/1自由模式
  campaignAO?: number;        // aO: 王者之路已通关战役数 (0-7)
  unlockedBattles?: boolean[]; // d1073: 9个战役的解锁表

  // ====== 科技建筑层 (对应原版 a1056/b1059/e1105, 任务B-4, 旧存档缺省) ======
  techBuildings?: boolean[];   // a1056[5]: 5种科技建筑已建
  castleParts?: boolean[];     // b1059[10]: 我城部件可见 (城堡外观)
  unlockedTowers?: boolean[];  // e1105[11]: 塔解锁表
}

// ============================================================
// 游戏设置
// ============================================================
export interface GameSettings {
  volume: number;
  musicEnabled: boolean;
  sfxEnabled: boolean;
  showFps: boolean;
  scale: number;
}

// ============================================================
// 存档系统
// ============================================================
export class SaveSystem {
  private static instance: SaveSystem | null = null;
  private autoSaveInterval: number = 30000; // 30秒自动存档
  private autoSaveTimer: number = 0;
  private lastSaveTime: number = 0;

  private constructor() {}

  /**
   * 获取单例实例
   */
  static getInstance(): SaveSystem {
    if (!SaveSystem.instance) {
      SaveSystem.instance = new SaveSystem();
    }
    return SaveSystem.instance;
  }

  /**
   * 保存游戏进度
   */
  save(data: SaveData): boolean {
    try {
      data.version = 1;
      data.timestamp = Date.now();
      const json = JSON.stringify(data);
      localStorage.setItem(SAVE_KEY, json);
      this.lastSaveTime = Date.now();
      console.log('Game saved successfully');
      return true;
    } catch (e) {
      console.error('Failed to save game:', e);
      return false;
    }
  }

  /**
   * 加载游戏进度
   */
  load(): SaveData | null {
    try {
      const json = localStorage.getItem(SAVE_KEY);
      if (!json) return null;

      const data = JSON.parse(json) as SaveData;
      if (data.version !== 1) {
        console.warn('Save data version mismatch, ignoring old save');
        return null;
      }
      return data;
    } catch (e) {
      console.error('Failed to load save:', e);
      return null;
    }
  }

  /**
   * 删除存档
   */
  deleteSave(): void {
    try {
      localStorage.removeItem(SAVE_KEY);
      console.log('Save deleted');
    } catch (e) {
      console.error('Failed to delete save:', e);
    }
  }

  /**
   * 检查是否有存档
   */
  hasSave(): boolean {
    try {
      return localStorage.getItem(SAVE_KEY) !== null;
    } catch (e) {
      return false;
    }
  }

  /**
   * 保存游戏设置
   */
  saveSettings(settings: GameSettings): boolean {
    try {
      localStorage.setItem(SETTINGS_KEY, JSON.stringify(settings));
      return true;
    } catch (e) {
      console.error('Failed to save settings:', e);
      return false;
    }
  }

  /**
   * 加载游戏设置
   */
  loadSettings(): GameSettings {
    const defaultSettings: GameSettings = {
      volume: 0.5,
      musicEnabled: true,
      sfxEnabled: true,
      showFps: false,
      scale: 2,
    };

    try {
      const json = localStorage.getItem(SETTINGS_KEY);
      if (!json) return defaultSettings;
      const settings = { ...defaultSettings, ...JSON.parse(json) };
      return settings;
    } catch (e) {
      return defaultSettings;
    }
  }

  /**
   * 从游戏状态创建存档数据
   */
  createSaveData(
    levelIndex: number,
    currentLevel: number,
    gold: number,
    lives: number,
    techTree: TechTreeSystem,
    towers: Tower[],
    stats: { totalKills: number; totalGoldEarned: number; playTime: number },
  ): SaveData {
    const unlockedEffects = Array.from(techTree.getUnlockedEffects().map(e => e.id));
    const branches = techTree.getBranches();
    const awakenedHeroes = techTree.getAwakenedHeroes();

    return {
      version: 1,
      timestamp: Date.now(),
      levelIndex,
      currentLevel,
      gold,
      lives,
      unlockedEffects,
      branchProgress: branches.map(b => ({
        branchIndex: b.branchIndex,
        currentLevel: b.currentLevel,
        unlocked: b.unlocked,
      })),
      globalAtkBonus: techTree.getGlobalAtkBonus(),
      globalFireRateBonus: techTree.getGlobalFireRateBonus(),
      reloadHalf: techTree.isReloadHalf(),
      goldDouble: techTree.isGoldDouble(),
      awakenedHeroes: awakenedHeroes.map(h => ({
        heroId: h.hero.id,
        faction: h.faction,
        towerId: h.towerId,
      })),
      currentFaction: 0, // 由Game设置
      towers: towers.map(t => ({
        x: t.x,
        y: t.y,
        type: t.type,
        level: t.level,
        damage: t.damage,
        range: t.range,
        fireRate: t.fireRate,
        heroId: t.heroId,
        effectType: t.effectType,
        // 新增: 保存建筑血量
        hp: t.hp,
        maxHp: t.maxHp,
        orientation: t.orientation,
        gateLoaded: t.gateLoaded,
        gateState: t.gateState,
      })),
      totalKills: stats.totalKills,
      totalGoldEarned: stats.totalGoldEarned,
      playTime: stats.playTime,
    };
  }

  /**
   * 将存档数据恢复到科技树系统
   */
  restoreTechTree(saveData: SaveData, techTree: TechTreeSystem): void {
    techTree.reset();

    // 恢复分支状态
    for (const bp of saveData.branchProgress) {
      if (bp.unlocked) {
        techTree.unlockBranch(bp.branchIndex);
      }
    }

    // 恢复科技效果 (通过金手指方式批量解锁)
    for (const effectId of saveData.unlockedEffects) {
      // 这些效果通过techTree.upgradeTech时自动解锁
      // 这里需要手动恢复
    }

    // 恢复全局加成
    // techTree内部会在upgradeTech时自动累积
    // 这里设置一个恢复方法
    if (saveData.goldDouble) {
      techTree.setGoldDouble(true);
    }
  }

  /**
   * 将存档数据恢复到塔系统
   */
  restoreTowers(saveData: SaveData): Tower[] {
    return saveData.towers.map(t => ({
      x: t.x,
      y: t.y,
      type: t.type,
      level: t.level,
      damage: t.damage,
      range: t.range,
      fireRate: t.fireRate,
      cooldown: 0,
      target: -1,
      angle: 0,
      heroId: t.heroId,
      effectType: t.effectType,
      // 新增: 恢复建筑血量
      hp: t.hp,
      maxHp: t.maxHp,
      debuffTimer: 0,
      // 动画状态 (不存档, 按初始值)
      frame: 0,
      orientation: t.orientation ?? 0,
      attackAnim: 0,
      strikeX: t.x * 16,
      strikeY: t.y * 16,
      gateLoaded: t.gateLoaded === true,
      gateState: t.gateState ?? 0,
      gateTimer: 0,
    }));
  }

  /**
   * 自动存档更新
   */
  updateAutoSave(dt: number, saveFn: () => void): void {
    this.autoSaveTimer += dt * 16.67;
    if (this.autoSaveTimer >= this.autoSaveInterval) {
      this.autoSaveTimer = 0;
      saveFn();
    }
  }

  /**
   * 获取最后存档时间
   */
  get lastSaveTimestamp(): number {
    return this.lastSaveTime;
  }

  /**
   * 格式化存档时间
   */
  getFormattedSaveTime(): string {
    if (this.lastSaveTime === 0) return '未保存';
    const date = new Date(this.lastSaveTime);
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');
    return `${month}/${day} ${hours}:${minutes}`;
  }

  /**
   * 获取存档摘要信息 (用于存档选择界面)
   */
  getSaveSummary(): { level: string; gold: number; heroes: number; time: string } | null {
    const data = this.load();
    if (!data) return null;

    const levelName = STORY_LEVEL_SEQUENCE[data.levelIndex] !== undefined
      ? `第${data.levelIndex + 1}关`
      : '未知';

    return {
      level: levelName,
      gold: data.gold,
      heroes: data.awakenedHeroes.length,
      time: this.getFormattedSaveTime(),
    };
  }
}
