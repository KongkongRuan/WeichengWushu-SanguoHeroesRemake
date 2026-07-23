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
import { CheatProfile, createDefaultCheatProfile, normalizeCheatProfile } from './CheatProgress';
import type { EnhancedRunStateV1 } from '../enhancement/RunState';
import type { RulesetId } from '../enhancement/Ruleset';
import { normalizeRuleset } from '../enhancement/Ruleset';
import { BattleRecordProfile, createBattleRecordProfile } from '../enhancement/BattleRecords';
import type { ViewportPreference } from './Viewport';

export interface StorageKeys {
  save: string;
  settings: string;
  cheatProfile: string;
  enhancementProfile: string;
}

export function createStorageKeys(channel: string): StorageKeys {
  const prefix = channel === 'preview-build-input-viewport'
    ? 'weicheng_preview_build_input_viewport'
    : 'weicheng';
  return {
    save: `${prefix}_save_v1`,
    settings: `${prefix}_settings_v1`,
    cheatProfile: `${prefix}_cheat_profile_v1`,
    enhancementProfile: `${prefix}_enhancement_profile_v1`,
  };
}

const DEPLOY_CHANNEL = typeof __DEPLOY_CHANNEL__ === 'string' ? __DEPLOY_CHANNEL__ : 'production';
export const STORAGE_KEYS = createStorageKeys(DEPLOY_CHANNEL);
const SAVE_KEY = STORAGE_KEYS.save;
const SETTINGS_KEY = STORAGE_KEYS.settings;
const CHEAT_PROFILE_KEY = STORAGE_KEYS.cheatProfile;
const ENHANCEMENT_PROFILE_KEY = STORAGE_KEYS.enhancementProfile;
export const CURRENT_SAVE_VERSION = 2;

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
    orientation?: number; gateLoaded?: boolean; gateState?: number; instanceId?: number; attackSequence?: number;
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

  // ====== 当前战斗的金手指记录（旧存档缺省） ======
  battleCheatsUsed?: string[];
  battleLeaks?: number;
  quickDeployEligible?: boolean;

  // ====== 玩法增强（v2；经典存档不需要 enhancedRun） ======
  rulesetId?: RulesetId;
  enhancedRun?: EnhancedRunStateV1;
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
  rulesetId: RulesetId;
  viewportMode: ViewportPreference;
  vibrationEnabled: boolean;
}

/** 纯函数迁移入口，未知未来版本会安全拒绝，旧 v1 会逐字段保留。 */
export function migrateSaveData(source: unknown): SaveData | null {
  if (!source || typeof source !== 'object') return null;
  const raw = source as Partial<SaveData> & Record<string, unknown>;
  const version = Number(raw.version ?? 1);
  if (version > CURRENT_SAVE_VERSION || version < 1) return null;
  const migrated = { ...raw } as SaveData;
  migrated.version = CURRENT_SAVE_VERSION;
  migrated.timestamp = Number(raw.timestamp) || 0;
  migrated.rulesetId = normalizeRuleset(raw.rulesetId);
  migrated.battleLeaks = Math.max(0, Number(raw.battleLeaks) || 0);
  migrated.quickDeployEligible = raw.quickDeployEligible !== false;
  migrated.battleCheatsUsed = Array.isArray(raw.battleCheatsUsed) ? [...raw.battleCheatsUsed] : [];
  return migrated;
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
      data.version = CURRENT_SAVE_VERSION;
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

      const data = migrateSaveData(JSON.parse(json));
      if (!data) {
        console.warn('Save data version is unsupported');
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
      rulesetId: 'enhanced',
      viewportMode: 'wide',
      vibrationEnabled: true,
    };

    try {
      const json = localStorage.getItem(SETTINGS_KEY);
      if (!json) return defaultSettings;
      const settings = { ...defaultSettings, ...JSON.parse(json) };
      settings.rulesetId = normalizeRuleset(settings.rulesetId);
      settings.viewportMode = settings.viewportMode === 'classic' ? 'classic' : 'wide';
      settings.vibrationEnabled = settings.vibrationEnabled !== false;
      return settings;
    } catch (e) {
      return defaultSettings;
    }
  }

  /** 军令、一次性奖励和沙盒解锁独立于普通战斗存档持久化。 */
  loadCheatProfile(): CheatProfile {
    try {
      const json = localStorage.getItem(CHEAT_PROFILE_KEY);
      if (!json) return createDefaultCheatProfile();
      return normalizeCheatProfile(JSON.parse(json));
    } catch (e) {
      console.error('Failed to load cheat profile:', e);
      return createDefaultCheatProfile();
    }
  }

  saveCheatProfile(profile: CheatProfile): boolean {
    try {
      localStorage.setItem(CHEAT_PROFILE_KEY, JSON.stringify(normalizeCheatProfile(profile)));
      return true;
    } catch (e) {
      console.error('Failed to save cheat profile:', e);
      return false;
    }
  }

  loadEnhancementProfile(): BattleRecordProfile {
    try {
      const json = localStorage.getItem(ENHANCEMENT_PROFILE_KEY);
      return json ? createBattleRecordProfile(JSON.parse(json)) : createBattleRecordProfile();
    } catch (e) {
      console.error('Failed to load enhancement profile:', e);
      return createBattleRecordProfile();
    }
  }

  saveEnhancementProfile(profile: BattleRecordProfile): boolean {
    try {
      localStorage.setItem(ENHANCEMENT_PROFILE_KEY, JSON.stringify(createBattleRecordProfile(profile)));
      return true;
    } catch (e) {
      console.error('Failed to save enhancement profile:', e);
      return false;
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
      version: CURRENT_SAVE_VERSION,
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
        instanceId: t.instanceId,
        attackSequence: t.attackSequence,
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
      attackState: 0,
      attackPhase: 0,
      attackFrame: 0,
      volleyFrames: [],
      liquidPattern: 0,
      liquidIgnited: false,
      buildEffect: 0,
      buildEffectFrame: 0,
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
  getSaveSummary(): { level: string; gold: number; heroes: number; time: string; rulesetId: RulesetId } | null {
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
      rulesetId: normalizeRuleset(data.rulesetId),
    };
  }
}
