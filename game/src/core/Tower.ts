/**
 * 塔系统 - 塔放置、攻击、升级
 * 还原原版 bu_* 精灵图和塔数值
 * 塔类型直接使用原版编号（不再经过旧 H5 重排）:
 *   0=弓手塔 1=石灰瓶 2=突刺 3=烟火 4=麻痹矢
 *   5=寒冰 6=擂木 7=投石 8=沸水 9=滚油 10=断龙闸
 */
import { Renderer } from './Renderer';
import { MapData } from './MapData';
import { Enemy, EnemyState } from './Enemy';
import { SpriteLoader } from './SpriteLoader';
import {
  TILE_SIZE, TOWER_DATA_T, TOWER_DATA_U,
  TOWER_UPGRADE_COST_R1101, TOWER_DAMAGE_S1102,
  TOWER_ANIM_W1123, TOWER_DRAW_POINTS_I1122, TOWER_ORIENT_Y1125,
  TOWER_MODEL_RECTS_F1112, TOWER_MODEL_POINTS_G1113, TOWER_MODEL_PART_COUNTS_Q1114,
  TOWER_DEVICE_MODEL_OFF_R1115,
  TOWER5_FRAME_YOFF_X1124, TOWER_BASE_I1142, TOWER_BASE_OFF_K1141,
  TOWER_DECOR_L1143, TOWER_BASE_OFFSETS_J1139, TOWER_LEVEL_FRAME_D1135,
  TOWER_ANCHOR_O1098,
  TOWER_DIR_SPREAD_M1084, TOWER_SPIKE_YOFF_Z1148,
  TOWER_GATE_LOAD_DIR_S1117, TOWER_GATE_LOAD_OFF_T1118,
  TOWER_GATE_FALL_OFF_U1119, TOWER_GATE_FALL_OFF_V1120, TOWER_GATE_FALL_RECTS_H1121,
  TOWER_GROUND_FRAME_N1149, TOWER_GROUND_PIECES_M1150,
  TOWER_LOG_BASE_OFF_J1144, TOWER_BOIL_BASE_OFF_K1145, TOWER_BOIL_ANIM_L1146,
  TOWER_FOUNTAIN_OFF_M1147, TOWER_DEVICE_POINTS_H1140,
  TOWER_DEVICE_BODY_E1136, TOWER_DEVICE_ORIENT_F1137, TOWER_DEVICE_FLAG_G1138,
  TOWER_RANGE_T1103, RANGE_CIRCLE_COLORS_L1116, BUILD_BAD_COLORS_Q1158,
  CURSOR_CORNER_O1156, CURSOR_BRACKET_Q1159,
  TOWER_FOOTPRINT_O1098,
  TOWER_DIRECTION_P1099,
  TOWER_PATH_FACING_TYPES, TOWER_ATTACK_DURATION_TICKS,
  TOWER_AUX_LAYER_BY_TYPE, TOWER_AMBIENT_LAYER_TYPES, TOWER_PROJECTILE_RANGE_TYPES,
  AWAKEN_ORDER_Y1130,
} from '../data/gameData';
import { TOWER_NAMES, TOWER_DESCRIPTIONS, HEROES, Hero, HERO_EFFECT_DESCRIPTIONS } from '../data/heroes';
import type { TechTreeSystem } from './TechTree';
import { linearLevelValue } from './Timing';
import type { RulesetId } from '../enhancement/Ruleset';
import { FeatureContext } from '../enhancement/Ruleset';
import type {
  CombatEvents,
  CombatStatusId,
  StatusRemovalReason,
} from '../enhancement/CombatEvents';
import type { ModifierResolver } from '../enhancement/ModifierResolver';
import type { ReactionResult, ReactionSystem } from '../enhancement/ReactionSystem';
import { duplicateTowerSurcharge, formatPercent } from '../enhancement/BalanceRules';

export type PlacementFailureCode =
  | 'unknown-tower'
  | 'locked'
  | 'out-of-bounds'
  | 'occupied'
  | 'terrain'
  | 'road-facing'
  | 'insufficient-gold';

export interface PlacementFailure {
  code: PlacementFailureCode;
  message: string;
}

// 武将ID到武将对象的映射 (避免循环依赖, 在模块加载时构建)
const HEROES_MAP: Record<number, Hero> = {};
HEROES.forEach(h => { HEROES_MAP[h.id] = h; });

const BUILD_EFFECT_FRAME_COUNT = 9;

export interface Tower {
  instanceId?: number; // 强化战报使用的稳定局内 ID
  x: number;          // 瓦片X坐标
  y: number;          // 瓦片Y坐标
  type: number;       // 原版塔类型 (0-10)
  level: number;      // 塔等级
  damage: number;     // 攻击力
  range: number;      // 攻击范围
  fireRate: number;   // 攻击速度
  cooldown: number;   // 冷却计时器
  target: number;     // 目标敌人索引
  angle: number;      // 朝向角度
  heroId: number;     // 绑定武将ID (-1=无)
  effectType: number; // 特殊效果类型 (0=无 1=麻痹 2=冰冻 3=中毒 4=火焰 5=减速)
  buildCostPaid?: number; // 强化规则的同类递增造价必须按实际投入保存，供战报和回收使用。
  // ====== 新增: 建筑血量 (对应原版 b1066 塔HP数据) ======
  hp: number;         // 当前血量
  maxHp: number;      // 最大血量
  // debuff 计时器 (对应原版 var16[15]=48)
  debuffTimer: number;
  // ====== 动画状态 (对应原版实体字段) ======
  frame: number;       // 动画帧 (对应原版 entity[7], 按 w1123[type] 序列推进)
  orientation: number; // 朝向 0=上 1=右 2=下 3=左 (对应原版 entity[5])
  attackAnim: number;  // 当前攻击剩余逻辑帧；仅用于兼容/UI，状态以 attackState 为准
  attackState: number; // 原版 entity[4]：0索敌/1攻击/2冷却/6无敌人待机
  attackPhase: number; // 原版 entity[10]：各建筑的蓄力/释放/收尾子阶段
  attackFrame: number; // 原版 entity[13]：当前子阶段动作帧
  volleyFrames: number[]; // 原版 C1134：弓手塔/麻痹矢五枚投射物帧
  liquidPattern: number; // 原版 entity[11]：沸水/滚油每次启动时随机的三格液体纹理偏移
  liquidIgnited: boolean; // 原版 entity[16]：本轮滚油是否已被燃烧敌人引燃
  liquidIgnitionSourceTowerId?: number; // 强化规则：本轮引燃滚油的火焰来源
  buildEffect: number;  // 0=无，1=建造成功，2=升级成功（对应原版 entity[4] 的 3/4 状态）
  buildEffectFrame: number; // ui_20 白烟帧（0..8）
  strikeX: number;      // 原版 entity[11]：最近一次攻击的地图像素 X
  strikeY: number;      // 原版 entity[12]：最近一次攻击的地图像素 Y
  gateLoaded: boolean;   // 断龙闸 entity[15]：是否已经装填石块
  gateState: number;     // 断龙闸 entity[10]：0待命 1释放中 2落闸
  gateTimer: number;     // 断龙闸动作计时，对应 entity[13]
  attackSequence?: number;
}

export interface BuildCostDetail {
  baseCost: number;
  councilAdjustedCost: number;
  prototypeDiscount: number;
  existingSameType: number;
  duplicateSurcharge: number;
  finalCost: number;
  explanations: string[];
}

export class TowerSystem {
  private renderer: Renderer;
  private mapData: MapData;
  private spriteLoader: SpriteLoader | null = null;
  private techTree: TechTreeSystem | null = null;
  private towers: Tower[] = [];
  private selectedTower: Tower | null = null;
  private buildMode: boolean = false;
  private buildX: number = 0;
  private buildY: number = 0;
  // bw: 待建塔类型 (原版 bw, 建造选位模式 am() case 1 行14719 使用)
  private pendingBuildType: number = 0;
  // aN: 当前关卡号 (原版范围圈颜色 l1116[aN] 取色用)
  private mapLevel: number = 0;
  // X: 国家 0蜀/1魏/2吴；类型8/9的终阶机关效果会按国家分支变化。
  private faction: number = 0;
  // ac: 开局升级模式，0武系/1文系；决定哪一组建筑可直接升至终阶武将。
  private upgradeMode: number = 0;
  // 预览动画帧计数 (对应原版 a1019, 角标呼吸/不可建格闪烁)
  private previewFrame: number = 0;
  private onGoldSpent: ((gold: number) => void) | null = null;
  private onHeroAwakened: ((hero: Hero, tower: Tower) => void) | null = null;
  private gold: number = 300;
  // ====== 原版科技建筑门禁 (任务B-3, 由 Game 注入 BuildBar 查询) =====
  // 建塔解锁校验 (原版 e1105; 未解锁时禁止建造并提示 b1015[115], M() 行8386-8389)
  private buildUnlockCheck: ((h5Type: number) => boolean) | null = null;
  // 原版建造费 (q1100; 返回null=用 towerConfigs 价格)
  private buildCostProvider: ((h5Type: number) => number | null) | null = null;
  // 拆除返还 (原版 b(int) 行15818; 返回null=用默认公式)
  private demolishRefundProvider: ((tower: Tower) => number | null) | null = null;
  private leaderUpgradeCheck: (() => boolean) | null = null;
  private lastUpgradeFailure = '';
  // 精灵图缓存 (避免 getByPrefix 每帧线性查找)
  private spriteCache: Map<string, HTMLImageElement | null> = new Map();
  private features = new FeatureContext('classic');
  private events: CombatEvents | null = null;
  private modifiers: ModifierResolver | null = null;
  private reactions: ReactionSystem | null = null;
  private getLives: () => number = () => 10;
  private nextTowerInstanceId = 1;
  private activeEnemies: Enemy[] = [];

  // 塔配置直接按原版 type 0-10 编号。伤害/范围/攻击间隔的初值分别来自
  // s1102/t1103/u1104；建造费运行时由 q1100 provider 注入。
  private towerConfigs: Record<number, { name: string; cost: number; damage: number; range: number; fireRate: number; color: number; effect: number }> = {
    0:  { name: '弓手塔', cost: 20, damage: 15, range: 64, fireRate: 20, color: 0xC8D8E8, effect: 0 },
    1:  { name: '石灰瓶', cost: 30, damage: 10, range: 48, fireRate: 30, color: 0x78C878, effect: 3 },
    2:  { name: '突刺',   cost: 40, damage: 30, range: 0,  fireRate: 60, color: 0xD8D8D8, effect: 0 },
    3:  { name: '烟火',   cost: 50, damage: 15, range: 64, fireRate: 25, color: 0xFF7040, effect: 4 },
    4:  { name: '麻痹矢', cost: 40, damage: 15, range: 56, fireRate: 30, color: 0xD0B050, effect: 1 },
    5:  { name: '寒冰',   cost: 80, damage: 60, range: 64, fireRate: 30, color: 0x70D8F0, effect: 2 },
    6:  { name: '擂木',   cost: 40, damage: 20, range: 0,  fireRate: 60, color: 0x986838, effect: 0 },
    7:  { name: '投石',   cost: 50, damage: 30, range: 48, fireRate: 30, color: 0xA08060, effect: 0 },
    8:  { name: '沸水',   cost: 60, damage: 40, range: 64, fireRate: 80, color: 0x50A8E0, effect: 0 },
    9:  { name: '滚油',   cost: 80, damage: 60, range: 64, fireRate: 100, color: 0x604020, effect: 4 },
    10: { name: '断龙闸', cost: 30, damage: 50, range: 0,  fireRate: 0,  color: 0x90A0A8, effect: 0 },
  };

  constructor(renderer: Renderer, mapData: MapData) {
    this.renderer = renderer;
    this.mapData = mapData;
  }

  /**
   * 设置金币
   */
  setGold(gold: number): void {
    this.gold = gold;
  }

  setOnGoldSpent(callback: (gold: number) => void): void {
    this.onGoldSpent = callback;
  }

  /**
   * 设置科技树系统引用
   */
  setTechTree(techTree: TechTreeSystem): void {
    this.techTree = techTree;
  }

  /**
   * 设置武将觉醒回调
   */
  setOnHeroAwakened(callback: (hero: Hero, tower: Tower) => void): void {
    this.onHeroAwakened = callback;
  }

  /**
   * 设置建塔解锁校验 (原版 e1105 塔解锁表, 任务B-3)
   */
  setBuildUnlockCheck(fn: (h5Type: number) => boolean): void {
    this.buildUnlockCheck = fn;
  }

  /**
   * 设置原版建造费查询 (q1100, 任务A)
   */
  setBuildCostProvider(fn: (h5Type: number) => number | null): void {
    this.buildCostProvider = fn;
  }

  /**
   * 设置拆除返还查询 (原版 b(int) 行15818, 任务A)
   */
  setDemolishRefundProvider(fn: (tower: Tower) => number | null): void {
    this.demolishRefundProvider = fn;
  }

  setLeaderUpgradeCheck(fn: () => boolean): void {
    this.leaderUpgradeCheck = fn;
  }

  /**
   * 设置精灵图加载器
   */
  setSpriteLoader(loader: SpriteLoader): void {
    this.spriteLoader = loader;
  }

  /**
   * 进入建造模式
   */
  enterBuildMode(): void {
    this.buildMode = true;
  }

  exitBuildMode(): void {
    this.buildMode = false;
  }

  get isBuildMode(): boolean {
    return this.buildMode;
  }

  /**
   * 设置建造位置
   */
  setBuildPosition(x: number, y: number): void {
    this.buildX = x;
    this.buildY = y;
  }

  /**
   * 设置待建塔类型 (对应原版 bw, 底部建造栏选塔时调用)
   */
  setBuildType(type: number): void {
    this.pendingBuildType = type;
  }

  get buildType(): number {
    return this.pendingBuildType;
  }

  /**
   * 设置当前关卡号 (范围圈颜色 l1116[aN] 用, 原版 aN)
   */
  setMapLevel(level: number): void {
    this.mapLevel = level;
  }

  setEnhancementContext(
    rulesetId: RulesetId,
    events: CombatEvents | null,
    modifiers: ModifierResolver | null,
    reactions: ReactionSystem | null,
    getLives: () => number,
  ): void {
    this.features = new FeatureContext(rulesetId);
    this.events = events;
    this.modifiers = modifiers;
    this.reactions = reactions;
    this.getLives = getLives;
  }

  setFaction(faction: number): void {
    this.faction = Math.max(0, Math.min(2, faction | 0));
  }

  setUpgradeMode(mode: number): void {
    this.upgradeMode = mode === 1 ? 1 : 0;
  }

  /** 注入原版 10Hz 的 a1019 视觉帧，渲染本身不再推进计数。 */
  setVisualFrame(frame: number): void {
    this.previewFrame = frame;
  }

  /** s1102/t1103/u1104 的基础值 + 每级增量公式（H5 level 为 1 起）。 */
  private originalStats(type: number, level: number): { damage: number; range: number; fireRate: number } {
    const originalType = this.spriteType(type);
    const [damageBase, damageStep] = TOWER_DAMAGE_S1102[originalType] ?? [0, 0];
    const [rangeBase, rangeStep] = TOWER_DATA_T[originalType] ?? [0, 0];
    const [rateBase, rateStep] = TOWER_DATA_U[originalType] ?? [0, 0];
    return {
      damage: Math.max(0, linearLevelValue([damageBase, damageStep], level)),
      range: Math.max(0, linearLevelValue([rangeBase, rangeStep], level)),
      fireRate: Math.max(0, linearLevelValue([rateBase, rateStep], level)),
    };
  }

  private applyOriginalStats(tower: Tower): void {
    const stats = this.originalStats(tower.type, tower.level);
    tower.damage = stats.damage;
    tower.range = stats.range;
    tower.fireRate = stats.fireRate;
  }

  /**
   * 方向机关投射到建筑外侧的格子（原版 m1084）。沸水/滚油的常规命中区域只取
   * 中间一排/列；突刺、擂木和断龙闸使用完整 3×3。
   */
  private projectedDeviceCells(
    tileX: number,
    tileY: number,
    orientation: number,
    centerStrip: boolean = false,
  ): { tx: number; ty: number }[] {
    const spread = TOWER_DIR_SPREAD_M1084[orientation & 3];
    const result: { tx: number; ty: number }[] = [];
    const seen = new Set<string>();
    for (let i = 0; i < 3; i++) {
      for (let j = 0; j < 3; j++) {
        if (centerStrip) {
          const horizontal = (orientation & 3) === 0 || (orientation & 3) === 2;
          if ((horizontal && i !== 1) || (!horizontal && j !== 1)) continue;
        }
        const px = tileX * TILE_SIZE + (i << 4) * spread[0] + spread[2];
        const py = tileY * TILE_SIZE + (j << 4) * spread[1] + spread[3];
        const tx = px >> 4;
        const ty = py >> 4;
        const key = `${tx},${ty}`;
        if (!seen.has(key)) {
          seen.add(key);
          result.push({ tx, ty });
        }
      }
    }
    return result;
  }

  /**
   * 原版方向机关在建造时只允许朝向相邻道路。触屏版自动选择覆盖道路最多的一侧，
   * 避免突刺/擂木/沸水/滚油/断龙闸在索敌时反复转向。
   */
  private resolvePathFacing(tileX: number, tileY: number, type: number): number {
    const renderType = this.spriteType(type);
    if (TOWER_DIRECTION_P1099[renderType] !== 1) return 0;
    let bestOrientation = 0;
    let bestScore = -1;
    for (let orientation = 0; orientation < 4; orientation++) {
      const score = this.pathFacingScore(tileX, tileY, type, orientation);
      if (score > bestScore) {
        bestScore = score;
        bestOrientation = orientation;
      }
    }
    return bestOrientation;
  }

  private pathFacingScore(tileX: number, tileY: number, type: number, orientation: number): number {
    const fp = TOWER_FOOTPRINT_O1098[this.spriteType(type)] ?? 1;
    let score = this.projectedDeviceCells(tileX, tileY, orientation)
      .filter(cell => this.mapData.getTerrain(cell.tx, cell.ty) < 8).length * 10;
    // 紧贴建筑边缘的道路优先，用于原版向下偏移表留有一格间隙的情况。
    for (let i = 0; i < fp; i++) {
      const tx = orientation === 1 ? tileX + fp : orientation === 3 ? tileX - 1 : tileX + i;
      const ty = orientation === 2 ? tileY + fp : orientation === 0 ? tileY - 1 : tileY + i;
      if (this.mapData.getTerrain(tx, ty) < 8) score++;
    }
    return score;
  }

  private hasPathFacing(tileX: number, tileY: number, type: number): boolean {
    if (TOWER_DIRECTION_P1099[this.spriteType(type)] !== 1) return true;
    return [0, 1, 2, 3].some(orientation => this.pathFacingScore(tileX, tileY, type, orientation) > 0);
  }

  /**
   * 建造预览的绿色攻击方向箭头。
   * 原版 p1099=0 的弓手塔等六类建筑可向四周攻击；p1099=1 的突刺、擂木、
   * 沸水、滚油和断龙闸只朝建造时解析出的道路方向攻击。
   */
  private buildPreviewArrowOrientations(tileX: number, tileY: number, type: number): number[] {
    if (TOWER_DIRECTION_P1099[this.spriteType(type)] !== 1) return [0, 1, 2, 3];
    return [this.resolvePathFacing(tileX, tileY, type)];
  }

  /**
   * 放置塔
   * 任务B-3: 接入原版科技建筑门禁 (e1105), 未解锁禁止建造 (原版 M() case 0 行8373-8389)
   * 任务A: 建造费改用原版 q1100 (经 buildCostProvider), 与建造栏显示价格一致
   */
  placeTower(tileX: number, tileY: number, type: number): boolean {
    const footprint = TOWER_FOOTPRINT_O1098[this.spriteType(type)] ?? 1;
    // 原版塔按 2x2/3x3 占地，不能只检查锚点一格。
    if (this.getPlacementFailure(tileX, tileY, type)) return false;

    const config = this.towerConfigs[type];
    if (!config) return false;

    // 原版科技建筑解锁门禁 (e1105): 未解锁返回false (提示由 UI 层给 b1015[115])
    if (this.buildUnlockCheck && !this.buildUnlockCheck(type)) return false;

    // 原版建造费 (q1100) 优先, 否则用 towerConfigs。装填半价只影响断龙闸装填，
    // 不能把所有新建建筑的 q1100 都减半。
    const costDetail = this.getBuildCostDetail(type);
    const actualCost = costDetail.finalCost;
    if (this.gold < actualCost) return false;

    const stats = this.originalStats(type, 1);
    const tower: Tower = {
      instanceId: this.nextTowerInstanceId++,
      x: tileX,
      y: tileY,
      type,
      level: 1,
      damage: stats.damage,
      range: stats.range,
      fireRate: stats.fireRate,
      cooldown: 0,
      target: -1,
      angle: 0,
      heroId: -1,
      effectType: config.effect,
      buildCostPaid: actualCost,
      // 新增: 初始化建筑血量 (基于塔类型和费用)
      hp: 100 + config.cost,
      maxHp: 100 + config.cost,
      debuffTimer: 0,
      // 动画状态初始化 (对应原版 c(int×4) 行17252: entity[7]=0, entity[5]=aA)
      frame: 0,
      orientation: this.resolvePathFacing(tileX, tileY, type),
      attackAnim: 0,
      attackState: 0,
      attackPhase: 0,
      attackFrame: 0,
      volleyFrames: [],
      liquidPattern: 0,
      liquidIgnited: false,
      buildEffect: 1,
      buildEffectFrame: 0,
      strikeX: tileX * TILE_SIZE,
      strikeY: tileY * TILE_SIZE,
      gateLoaded: false,
      gateState: 0,
      gateTimer: 0,
      attackSequence: 0,
    };

    this.towers.push(tower);
    for (let dx = 0; dx < footprint; dx++) {
      for (let dy = 0; dy < footprint; dy++) {
        this.mapData.occupyBuildTile(tileX + dx, tileY + dy);
      }
    }
    this.gold -= actualCost;
    this.onGoldSpent?.(actualCost);
    this.events?.emit('towerBuilt', { towerId: tower.instanceId ?? 0, type, cost: actualCost });
    return true;
  }

  /** 原版动作16显示的逐级升级费用；塔升级不等于购买科技建筑。 */
  getBuildCost(type: number): number {
    return this.getBuildCostDetail(type).finalCost;
  }

  getBuildCostDetail(type: number): BuildCostDetail {
    const base = this.buildCostProvider?.(type) ?? this.towerConfigs[type]?.cost ?? 0;
    const councilAdjustedCost = this.modifiers?.buildCostBeforePrototype(base, type) ?? base;
    const prototypeDiscount = this.modifiers?.prototypeTowerDiscount(type) ?? 0;
    const prototypeAdjustedCost = councilAdjustedCost * (1 - prototypeDiscount);
    const existingSameType = this.towers.filter(tower => this.spriteType(tower.type) === this.spriteType(type)).length;
    const duplicateSurcharge = this.features.enhanced ? duplicateTowerSurcharge(existingSameType) : 0;
    const finalCost = Math.max(1, Math.round(prototypeAdjustedCost * (1 + duplicateSurcharge)));
    const explanations: string[] = [];
    if (councilAdjustedCost !== base && base > 0) {
      const adjustment = councilAdjustedCost / base - 1;
      explanations.push(`军议修正 ${adjustment >= 0 ? '+' : '-'}${formatPercent(Math.abs(adjustment))}`);
    }
    if (prototypeDiscount > 0) {
      explanations.push(`首座样机 -${formatPercent(prototypeDiscount)}`);
    }
    if (duplicateSurcharge > 0) {
      explanations.push(`同类第${existingSameType + 1}座 +${formatPercent(duplicateSurcharge)}`);
    }
    return {
      baseCost: base,
      councilAdjustedCost,
      prototypeDiscount,
      existingSameType,
      duplicateSurcharge,
      finalCost,
      explanations,
    };
  }

  /** 原版动作16显示的逐级升级费用；塔升级不等于购买科技建筑。 */
  getUpgradeCost(tower: Tower): number | null {
    if (tower.level >= 7) return null;
    const [baseCost, stepCost] = TOWER_UPGRADE_COST_R1101[this.spriteType(tower.type)] ?? [50, 50];
    const base = baseCost + stepCost * Math.max(0, tower.level - 1);
    return this.modifiers?.upgradeCost(base) ?? base;
  }

  /**
   * 原版动作16：只支付 r1101 当前等级费用并提升建筑等级。
   * 普通塔升级不会创建全局科技效果；科技效果只由底部科技建筑/作弊入口管理。
   */
  upgradeTower(tower: Tower): boolean {
    this.lastUpgradeFailure = '';
    const cost = this.getUpgradeCost(tower);
    if (cost == null) {
      this.lastUpgradeFailure = '该塔已是最高级';
      return false;
    }
    if (tower.level === 6 && !this.canAwakenHero(tower)) return false;
    if (this.gold < cost) {
      this.lastUpgradeFailure = '金币不足，消灭敌人可获得金钱';
      return false;
    }
    tower.level++;
    this.applyOriginalStats(tower);
    if (tower.level === 7) this.awakenHero(tower);
    this.beginUpgradeEffect(tower);
    this.gold -= cost;
    this.onGoldSpent?.(cost);
    this.events?.emit('towerUpgraded', { towerId: tower.instanceId ?? 0, level: tower.level, cost });
    return true;
  }

  private canAwakenHero(tower: Tower): boolean {
    const type = this.spriteType(tower.type);
    if (type === 0) {
      if (this.leaderUpgradeCheck?.() === true) return true;
      this.lastUpgradeFailure = '现在还不能升级这个建筑，需要将城池全部建筑升级';
      return false;
    }

    // 开局路线严格限定七级觉醒：文系为1-5，武系为6-10。
    const towerMode = type < 6 ? 1 : 0;
    if (towerMode !== this.upgradeMode) {
      const selectedMode = this.upgradeMode === 1 ? '文系' : '武系';
      this.lastUpgradeFailure = `开局选择的${selectedMode}模式只能觉醒${selectedMode}建筑`;
      return false;
    }
    return true;
  }

  private awakenHero(tower: Tower): void {
    const type = this.spriteType(tower.type);
    const heroId = AWAKEN_ORDER_Y1130[this.faction]?.[type] ?? -1;
    const hero = HEROES_MAP[heroId];
    if (!hero) return;
    tower.heroId = heroId;
    this.techTree?.registerAwakenedHero(tower, hero);
    this.onHeroAwakened?.(hero, tower);
    this.events?.emit('towerAwakened', { towerId: tower.instanceId ?? 0, heroId });
  }

  getUpgradeFailureMessage(): string {
    return this.lastUpgradeFailure;
  }

  /**
   * 出售塔 (原版 b(int) 行15818: (建造费+升级投入)>>1; 经 demolishRefundProvider 注入原版公式)
   * onGoldSpent 以负数回调通知 Game 入账 (与 placeTower 扣费的正数回调对称)
   */
  sellTower(tower: Tower): void {
    const refund = this.getDemolishRefund(tower);
    this.gold += refund;
    this.onGoldSpent?.(-refund);
    const footprint = TOWER_FOOTPRINT_O1098[this.spriteType(tower.type)] ?? 1;
    for (let dx = 0; dx < footprint; dx++) {
      for (let dy = 0; dy < footprint; dy++) {
        this.mapData.releaseBuildTile(tower.x + dx, tower.y + dy);
      }
    }
    this.towers = this.towers.filter(t => t !== tower);
    this.selectedTower = null;
    this.events?.emit('towerSold', { towerId: tower.instanceId ?? 0, refund });
  }

  getDemolishRefund(tower: Tower): number {
    const baseRefund = this.demolishRefundProvider?.(tower)
      ?? Math.floor(this.towerConfigs[tower.type].cost * tower.level * 0.7);
    return this.modifiers?.demolishRefund(baseRefund, this.investedGold(tower)) ?? baseRefund;
  }

  private investedGold(tower: Tower): number {
    let total = tower.buildCostPaid
      ?? this.buildCostProvider?.(tower.type)
      ?? this.towerConfigs[tower.type]?.cost
      ?? 0;
    const [base, step] = TOWER_UPGRADE_COST_R1101[this.spriteType(tower.type)] ?? [0, 0];
    for (let level = 1; level < tower.level; level++) total += base + step * Math.max(0, level - 1);
    return total;
  }

  /**
   * 精灵渲染类型映射。19 仅作为旧存档中弓手塔的兼容别名，正常运行时直接使用原版 0-10。
   */
  private spriteType(type: number): number {
    // 新存档直接使用原版编号；19 仅作为旧版本存档的兼容别名。
    return type === 19 ? 0 : type;
  }

  /** 判断某塔是否覆盖指定地图格。 */
  private occupiesTile(tower: Tower, tx: number, ty: number): boolean {
    const fp = TOWER_FOOTPRINT_O1098[this.spriteType(tower.type)] ?? 1;
    return tx >= tower.x && tx < tower.x + fp && ty >= tower.y && ty < tower.y + fp;
  }

  /** 返回放置失败的精确原因；预览、松手结算与实际建造共用同一入口。 */
  getPlacementFailure(tileX: number, tileY: number, type: number): PlacementFailure | null {
    const config = this.towerConfigs[type];
    if (!config) return { code: 'unknown-tower', message: '未知建筑类型' };
    if (this.buildUnlockCheck && !this.buildUnlockCheck(type)) {
      return { code: 'locked', message: '建筑尚未解锁，需要先修建相关城池' };
    }
    const footprint = TOWER_FOOTPRINT_O1098[this.spriteType(type)] ?? 1;
    if (tileX < 0 || tileY < 0 || tileX + footprint > this.mapData.width || tileY + footprint > this.mapData.height) {
      return { code: 'out-of-bounds', message: '空间不足：建筑超出地图边界' };
    }
    for (let dx = 0; dx < footprint; dx++) {
      for (let dy = 0; dy < footprint; dy++) {
        const tx = tileX + dx;
        const ty = tileY + dy;
        if (this.towers.some(t => this.occupiesTile(t, tx, ty))) {
          return { code: 'occupied', message: '与已有建筑重叠' };
        }
        if (!this.mapData.isBuildableAt(tx, ty)) {
          return { code: 'terrain', message: '此处地形不可建造' };
        }
      }
    }
    if (!this.hasPathFacing(tileX, tileY, type)) {
      return { code: 'road-facing', message: '建筑必须朝向道路' };
    }
    const cost = this.getBuildCostDetail(type).finalCost;
    if (this.gold < cost) {
      return { code: 'insufficient-gold', message: `金币不足：需要 ${cost} 金` };
    }
    return null;
  }

  /** 检查一个塔的完整占地区域，供实际建造和移动预览共用。 */
  private isPlacementAreaClear(tileX: number, tileY: number, type: number): boolean {
    return this.getPlacementFailure(tileX, tileY, type) === null;
  }

  /** 断龙闸装填费用与当前等级的升级费用相同；装填减半科技生效时取一半。 */
  getGateLoadCost(tower: Tower): number | null {
    if (tower.type !== 10 || tower.gateLoaded || tower.gateState !== 0) return null;
    const [baseCost, stepCost] = TOWER_UPGRADE_COST_R1101[this.spriteType(tower.type)] ?? [50, 50];
    const fullCost = baseCost + stepCost * Math.max(0, tower.level - 1);
    return this.techTree?.isReloadHalf() || tower.heroId === 23 ? fullCost >> 1 : fullCost;
  }

  /** 原版动作18：付费装填石块，之后菜单切换为“释放断龙闸”。 */
  loadGate(tower: Tower): boolean {
    const cost = this.getGateLoadCost(tower);
    if (cost == null || this.gold < cost) return false;
    this.gold -= cost;
    this.onGoldSpent?.(cost);
    tower.gateLoaded = true;
    return true;
  }

  private beginUpgradeEffect(tower: Tower): void {
    tower.buildEffect = 2;
    tower.buildEffectFrame = 0;
    tower.attackAnim = 0;
    tower.attackState = 2;
    tower.attackPhase = 3;
    tower.attackFrame = 0;
    tower.volleyFrames = [];
    tower.liquidPattern = 0;
    tower.target = -1;
  }

  /** 原版动作19：断龙闸是手动、一次性机关，不进入通用自动索敌循环。 */
  releaseGate(tower: Tower): boolean {
    if (tower.type !== 10 || !tower.gateLoaded || tower.gateState !== 0) return false;
    tower.gateLoaded = false;
    tower.gateState = 1;
    tower.gateTimer = 0;
    tower.attackState = 1;
    tower.attackPhase = 1;
    tower.attackFrame = 0;
    tower.target = -1;
    return true;
  }

  /** 当前建造幻影覆盖的完整区域是否可放置。 */
  canBuildAtCurrentPosition(): boolean {
    return this.isPlacementAreaClear(this.buildX, this.buildY, this.pendingBuildType);
  }

  /**
   * 更新所有塔 - 应用全局科技加成
   */
  update(enemies: Enemy[], offsetX: number, offsetY: number): void {
    this.activeEnemies = enemies;
    if (this.features.reactions && this.reactions) {
      this.reactions.tickZones(enemies, (enemy, damage, towerId) => {
        const tower = this.towers.find(item => item.instanceId === towerId);
        this.recordRawDamage(tower, enemy as Enemy, damage, 'reaction', towerId);
      });
    }
    this.updateDebuffs();
    this.tickAnim();
    for (const tower of this.towers) {
      if (tower.buildEffect !== 0) continue;
      if (tower.type === 10) {
        this.updateGate(tower, enemies);
        continue;
      }

      if (tower.attackState === 1) {
        // 原版 state=1 每帧先递减 [6] 冷却，再推进攻击动作；两者始终重叠。
        tower.cooldown--;
        this.advanceAttack(tower, enemies, offsetX, offsetY);
        continue;
      }

      if (tower.attackState === 2) {
        tower.cooldown--;
        if (tower.cooldown < 0) {
          tower.cooldown = 0;
          tower.attackState = 0;
        }
        continue;
      }

      tower.attackState = 0;
      const targetIdx = this.findTargetIndex(tower, enemies, offsetX, offsetY);
      if (targetIdx < 0) {
        tower.target = -1;
        if (enemies.length === 0) tower.attackState = 6;
        continue;
      }

      this.updateStrikeTarget(tower, targetIdx, enemies[targetIdx], offsetX, offsetY);
      tower.cooldown = Math.max(0, Math.floor(this.effectiveFireRate(tower)));
      this.startAttack(tower);
    }
  }

  private isActiveEnemy(enemy: Enemy | undefined): enemy is Enemy {
    return !!enemy
      && enemy.hp > 0
      && enemy.state !== EnemyState.DYING
      && enemy.state !== EnemyState.SETTLE
      && enemy.state !== EnemyState.SIEGE
      && enemy.state !== EnemyState.CHARGE;
  }

  private isLivingEnemy(enemy: Enemy | undefined): enemy is Enemy {
    return !!enemy && enemy.hp > 0
      && enemy.state !== EnemyState.DYING
      && enemy.state !== EnemyState.SETTLE;
  }

  private findTargetIndex(tower: Tower, enemies: Enemy[], offsetX: number, offsetY: number): number {
    const type = this.spriteType(tower.type);
    const half = (TOWER_ANCHOR_O1098[type] ?? 2) << 3;
    const tx = offsetX + tower.x * TILE_SIZE + half;
    const ty = offsetY + tower.y * TILE_SIZE + half;
    const directional = type === 2 || type === 6 || type === 8 || type === 9;
    if ((type === 8 || type === 9) && this.faction === 2 && tower.level === 7) {
      for (const enemy of enemies) {
        if (!this.isActiveEnemy(enemy)) continue;
        if (Math.hypot(offsetX + enemy.x - tx, offsetY + enemy.y - ty) < tower.range) {
          // 原版 p(type,level) 只刷新 [15]，不会把正在播放的 [22] 减速帧重置为 0。
          this.setSlow(enemy, 48, false, tower.instanceId ?? 0);
        }
      }
    }
    const cells = directional
      ? new Set(this.projectedDeviceCells(
        tower.x,
        tower.y,
        tower.orientation,
        type === 8 || type === 9,
      ).map(cell => `${cell.tx},${cell.ty}`))
      : null;
    for (let i = 0; i < enemies.length; i++) {
      const enemy = enemies[i];
      if (!this.isActiveEnemy(enemy)) continue;
      if (cells) {
        if (cells.has(`${enemy.x >> 4},${enemy.y >> 4}`)) return i;
        continue;
      }
      const distance = Math.hypot(offsetX + enemy.x - tx, offsetY + enemy.y - ty);
      if (distance < tower.range) return i;
    }
    return -1;
  }

  private updateStrikeTarget(
    tower: Tower,
    targetIdx: number,
    target: Enemy,
    offsetX: number,
    offsetY: number,
  ): void {
    const type = this.spriteType(tower.type);
    const half = (TOWER_ANCHOR_O1098[type] ?? 2) << 3;
    const tx = offsetX + tower.x * TILE_SIZE + half;
    const ty = offsetY + tower.y * TILE_SIZE + half;
    tower.target = targetIdx;
    tower.strikeX = target.x;
    tower.strikeY = target.y;
    tower.angle = Math.atan2(offsetY + target.y - ty, offsetX + target.x - tx);
    if (!TOWER_PATH_FACING_TYPES.includes(type)) {
      tower.orientation = this.angleToOrientation(tower.angle);
    }
  }

  private startAttack(tower: Tower): void {
    const type = this.spriteType(tower.type);
    tower.attackState = 1;
    tower.attackPhase = type === 0 || type === 1 || type === 4 || type === 6 ? 1 : 0;
    tower.attackFrame = 0;
    tower.attackSequence = (tower.attackSequence ?? 0) + 1;
    tower.volleyFrames = type === 0 || type === 4 ? [0, 1, 2, 3, 4] : [];
    if (type === 8 || type === 9) {
      tower.liquidPattern = (Math.random() * 3) | 0;
      tower.liquidIgnited = false;
      tower.liquidIgnitionSourceTowerId = 0;
    }
    const extendedLiquid = (type === 8 || type === 9)
      && this.faction === 1
      && tower.level - 1 === 6;
    tower.attackAnim = extendedLiquid ? 26 : (TOWER_ATTACK_DURATION_TICKS[type] ?? 10);
  }

  private finishAttack(tower: Tower): void {
    tower.attackAnim = 0;
    tower.attackPhase = 0;
    tower.attackFrame = 0;
    tower.volleyFrames = [];
    tower.target = -1;
    tower.attackState = 2;
  }

  private advanceAttack(tower: Tower, enemies: Enemy[], offsetX: number, offsetY: number): void {
    const type = this.spriteType(tower.type);
    if (tower.attackAnim > 0) tower.attackAnim--;
    switch (type) {
      case 0:
      case 4:
        tower.attackFrame = Math.min(4, tower.attackFrame + 1);
        tower.volleyFrames = tower.volleyFrames.map(frame => Math.max(-1, frame - 1));
        if (tower.attackFrame === 1) {
          const target = enemies[tower.target];
          // 原版麻痹矢对 6 号 Boss 完全无效（A(int) 4944-4964），不能只免疫麻痹而仍扣血。
          if (type !== 4 || target?.bossType !== 6) this.damageTarget(tower, enemies);
        }
        if (tower.volleyFrames.every(frame => frame < 0)) this.finishAttack(tower);
        break;
      case 1:
        tower.attackFrame++;
        if (tower.attackFrame === 4) {
          this.damageLimeImpact(tower, enemies);
        }
        if (tower.attackFrame > 12) this.finishAttack(tower);
        break;
      case 2:
        tower.attackFrame++;
        if (tower.attackFrame > 12) {
          this.finishAttack(tower);
        } else {
          this.damageEnemiesInCells(tower, enemies, this.spikeActiveCells(tower, tower.attackFrame));
        }
        break;
      case 3:
      case 5:
      case 7:
        if (tower.attackPhase === 0) {
          tower.attackFrame++;
          if (tower.attackFrame > 12) {
            const targetIdx = this.findTargetIndex(tower, enemies, offsetX, offsetY);
            if (targetIdx < 0) {
              tower.attackFrame = 12;
              break;
            }
            this.updateStrikeTarget(tower, targetIdx, enemies[targetIdx], offsetX, offsetY);
            // 原版在蓄力结束重新调用 e(int)，会重新写入完整冷却值。
            tower.cooldown = Math.max(0, Math.floor(this.effectiveFireRate(tower)));
            tower.attackPhase = 1;
            tower.attackFrame = 0;
            const target = enemies[tower.target];
            if (type === 5 || (type === 3 && target?.bossType !== 5)) {
              this.damageTarget(tower, enemies);
            }
          }
          break;
        }
        tower.attackFrame++;
        if (type === 7 && tower.attackFrame === 3) {
          const primary = enemies[tower.target];
          if (this.isLivingEnemy(primary)) {
            for (const enemy of enemies) {
              if (enemy === primary || !this.isLivingEnemy(enemy)) continue;
              if (Math.abs(enemy.x - tower.strikeX) <= 24
                && Math.abs(enemy.y - tower.strikeY) <= 24) {
                this.damageEnemy(tower, enemy, 1, true, this.splashTowerDamage(tower));
              }
            }
            this.damageEnemy(tower, primary);
          }
        }
        if (tower.attackFrame > (type === 7 ? 16 : 6)) this.finishAttack(tower);
        break;
      case 6:
        tower.attackFrame++;
        if (tower.attackFrame > 5) {
          // 第6帧先把 D1162 清回0再调用 h(...)，因此不会产生第6次有效命中。
          this.finishAttack(tower);
        } else {
          this.damageEnemiesInCells(
            tower,
            enemies,
            this.projectedDeviceCells(tower.x, tower.y, tower.orientation),
          );
        }
        break;
      case 8:
      case 9: {
        let liquidActive = tower.attackPhase !== 0;
        tower.attackFrame++;
        if (tower.attackPhase === 0 && tower.attackFrame > 2) {
          tower.attackPhase = 1;
          tower.attackFrame = 0;
          liquidActive = true;
        } else if (tower.attackPhase === 1) {
          const extended = this.faction === 1 && tower.level - 1 === 6;
          if (tower.attackFrame > (extended ? 20 : 10)) {
            tower.attackPhase = 2;
            tower.attackFrame = 0;
          }
        } else if (tower.attackPhase === 2 && tower.attackFrame > 1) {
          // 关闭帧先把道路机关层写为1，随后 h(...) 不再结算液体伤害。
          liquidActive = false;
          this.finishAttack(tower);
        }
        // 开启的前三帧只移动阀门；原版在切到阶段 1、液体真正出现后才调用 h(...) 命中。
        if (liquidActive) {
          const fullSpread = this.faction === 0 && tower.level - 1 === 6;
          this.damageEnemiesInCells(
            tower,
            enemies,
            this.projectedDeviceCells(tower.x, tower.y, tower.orientation, !fullSpread),
          );
        }
        break;
      }
      default:
        this.finishAttack(tower);
    }
  }

  private towerDamage(tower: Tower): number {
    const baseDamage = tower.damage;
    let damage = baseDamage;
    // 魏国终阶的“加强攻击伤害”是基础伤害的 1/4，先于君主 +5 结算。
    if ([13, 14, 17, 18, 19].includes(tower.heroId)) damage += baseDamage >> 2;
    // y1130 的每国0号武将（君主）使所有塔攻击+5，对应原版 a(type,s1102,level)。
    if (this.towers.some(t => t.heroId === 0 || t.heroId === 11 || t.heroId === 22)) damage += 5;
    // 吴国投石终阶以自身七级伤害 90 为半径，给其他塔 +10 攻击。
    if (this.towers.some(t => t !== tower && t.heroId === 25
      && Math.hypot((t.x - tower.x) * TILE_SIZE, (t.y - tower.y) * TILE_SIZE) < 90)) damage += 10;
    damage = this.modifiers?.directDamage(damage, this.spriteType(tower.type), this.getLives()) ?? damage;
    return Math.max(0, Math.floor(damage));
  }

  /** 石灰瓶/投石范围目标使用 level0 >> 2 后重新套 s1102，而不是主伤害乘 1/4。 */
  private splashTowerDamage(tower: Tower): number {
    const type = this.spriteType(tower.type);
    const [base, step] = TOWER_DAMAGE_S1102[type] ?? [0, 0];
    let damage = base + step * ((Math.max(1, tower.level) - 1) >> 2);
    if (this.towers.some(t => t.heroId === 0 || t.heroId === 11 || t.heroId === 22)) damage += 5;
    if (this.towers.some(t => t !== tower && t.heroId === 25
      && Math.hypot((t.x - tower.x) * TILE_SIZE, (t.y - tower.y) * TILE_SIZE) < 90)) damage += 10;
    return Math.max(0, damage);
  }

  private effectiveFireRate(tower: Tower): number {
    const base = [24, 29].includes(tower.heroId) ? tower.fireRate - 10 : tower.fireRate;
    return this.modifiers?.fireRate(base, this.spriteType(tower.type)) ?? base;
  }

  private ensureEnemyCombatFields(enemy: Enemy): void {
    enemy.fireTimer ??= 0;
    enemy.paralyzeTimer ??= 0;
    enemy.freezeTimer ??= 0;
    enemy.poisonTimer ??= 0;
    enemy.slowTimer ??= 0;
    enemy.fireFrame ??= 0;
    enemy.paralyzeFrame ??= 0;
    enemy.freezeFrame ??= 0;
    enemy.poisonFrame ??= 0;
    enemy.slowFrame ??= 0;
    enemy.poisonPower ??= 0;
    enemy.firePower ??= 8;
    enemy.hitTimer ??= -1;
    enemy.lastDamage ??= 0;
    enemy.impactDir ??= enemy.dir ?? 0;
    enemy.instanceId ??= 0;
    enemy.armorBreakTimer ??= 0;
    enemy.armorBreakAmount ??= 0;
    enemy.lastDamageSourceId ??= 0;
    enemy.fireSourceTowerId ??= 0;
    enemy.poisonSourceTowerId ??= 0;
    enemy.freezeSourceTowerId ??= 0;
    enemy.paralyzeSourceTowerId ??= 0;
    enemy.slowSourceTowerId ??= 0;
    enemy.armorBreakSourceTowerId ??= 0;
  }

  private statusDuration(enemy: Enemy, status: CombatStatusId): number {
    switch (status) {
      case 'paralyze': return enemy.paralyzeTimer;
      case 'freeze': return enemy.freezeTimer;
      case 'poison': return enemy.poisonTimer;
      case 'fire': return enemy.fireTimer;
      case 'slow': return enemy.slowTimer;
      case 'armor_break': return enemy.armorBreakTimer ?? 0;
    }
  }

  private statusSource(enemy: Enemy, status: CombatStatusId): number {
    switch (status) {
      case 'paralyze': return enemy.paralyzeSourceTowerId ?? 0;
      case 'freeze': return enemy.freezeSourceTowerId ?? 0;
      case 'poison': return enemy.poisonSourceTowerId ?? 0;
      case 'fire': return enemy.fireSourceTowerId ?? 0;
      case 'slow': return enemy.slowSourceTowerId ?? 0;
      case 'armor_break': return enemy.armorBreakSourceTowerId ?? 0;
    }
  }

  private setStatusSource(enemy: Enemy, status: CombatStatusId, towerId: number): void {
    switch (status) {
      case 'paralyze': enemy.paralyzeSourceTowerId = towerId; break;
      case 'freeze': enemy.freezeSourceTowerId = towerId; break;
      case 'poison': enemy.poisonSourceTowerId = towerId; break;
      case 'fire': enemy.fireSourceTowerId = towerId; break;
      case 'slow': enemy.slowSourceTowerId = towerId; break;
      case 'armor_break': enemy.armorBreakSourceTowerId = towerId; break;
    }
  }

  private emitStatusSet(
    enemy: Enemy,
    status: CombatStatusId,
    previousDuration: number,
    duration: number,
    towerId: number,
  ): void {
    if (duration <= previousDuration) return;
    const payload = { enemyId: enemy.instanceId ?? 0, towerId, status, duration };
    if (previousDuration > 0) {
      this.events?.emit('statusRefreshed', { ...payload, previousDuration });
    } else {
      this.events?.emit('statusApplied', payload);
    }
  }

  private emitStatusDurationChange(
    enemy: Enemy,
    status: CombatStatusId,
    previousDuration: number,
    reason: StatusRemovalReason,
  ): void {
    const duration = this.statusDuration(enemy, status);
    if (previousDuration <= 0 || duration === previousDuration) return;
    const towerId = this.statusSource(enemy, status);
    if (duration > 0) return;
    this.events?.emit('statusRemoved', { enemyId: enemy.instanceId ?? 0, towerId, status, reason });
    this.setStatusSource(enemy, status, 0);
  }

  private clearEnemyStatus(enemy: Enemy, status: CombatStatusId, reason: StatusRemovalReason): void {
    const previousDuration = this.statusDuration(enemy, status);
    if (previousDuration <= 0) return;
    switch (status) {
      case 'paralyze': enemy.paralyzeTimer = 0; break;
      case 'freeze': enemy.freezeTimer = 0; enemy.freezeFrame = 0; break;
      case 'poison': enemy.poisonTimer = 0; enemy.poisonPower = 0; break;
      case 'fire': enemy.fireTimer = 0; enemy.fireFrame = 0; break;
      case 'slow': enemy.slowTimer = 0; break;
      case 'armor_break': enemy.armorBreakTimer = 0; enemy.armorBreakAmount = 0; break;
    }
    this.emitStatusDurationChange(enemy, status, previousDuration, reason);
  }

  private recordDamage(tower: Tower, enemy: Enemy, damage: number, category: 'direct' | 'dot' | 'reaction' = 'direct'): void {
    const amount = Math.min(Math.max(0, enemy.hp), Math.max(0, Math.floor(damage)));
    enemy.hp -= amount;
    enemy.lastDamageSourceId = tower.instanceId ?? 0;
    enemy.lastDamage = amount;
    if (enemy.hitTimer < 0) enemy.hitTimer = 4;
    this.events?.emit('enemyDamaged', {
      enemyId: enemy.instanceId ?? 0, towerId: tower.instanceId ?? 0, damage: amount, category,
    });
  }

  private recordRawDamage(
    tower: Tower | undefined,
    enemy: Enemy,
    rawDamage: number,
    category: 'direct' | 'dot' | 'reaction',
    fallbackTowerId: number = 0,
  ): number {
    this.ensureEnemyCombatFields(enemy);
    const defense = Math.max(0, (enemy.defense ?? 0) - (enemy.armorBreakAmount ?? 0));
    const amount = Math.min(Math.max(0, enemy.hp), Math.max(1, Math.floor(rawDamage) - defense));
    if (tower) this.recordDamage(tower, enemy, amount, category);
    else {
      enemy.hp -= amount;
      enemy.lastDamageSourceId = fallbackTowerId;
      enemy.lastDamage = amount;
      if (enemy.hitTimer < 0) enemy.hitTimer = 4;
      this.events?.emit('enemyDamaged', {
        enemyId: enemy.instanceId ?? 0, towerId: fallbackTowerId, damage: amount, category,
      });
    }
    return amount;
  }

  private handleReaction(tower: Tower, enemy: Enemy): ReactionResult | null {
    if (!this.features.reactions || !this.reactions) return null;
    const eventId = `${tower.instanceId ?? 0}:${tower.attackSequence ?? 0}`;
    const consumedStatuses: CombatStatusId[] = ['paralyze', 'freeze', 'poison', 'fire'];
    const before = new Map(consumedStatuses.map(status => [status, this.statusDuration(enemy, status)]));
    const previousArmorBreak = this.statusDuration(enemy, 'armor_break');
    const result = this.reactions.resolveBeforeHit(eventId, tower, enemy);
    if (!result) return null;
    for (const status of consumedStatuses) {
      this.emitStatusDurationChange(enemy, status, before.get(status) ?? 0, 'consumed');
    }
    const armorBreakDuration = this.statusDuration(enemy, 'armor_break');
    if (armorBreakDuration > 0 && armorBreakDuration !== previousArmorBreak) {
      const towerId = tower.instanceId ?? 0;
      this.setStatusSource(enemy, 'armor_break', towerId);
      this.emitStatusSet(enemy, 'armor_break', previousArmorBreak, armorBreakDuration, towerId);
    }
    if (result.damage > 0) {
      for (const target of this.activeEnemies) {
        if (!this.isLivingEnemy(target)) continue;
        if (Math.abs(target.x - enemy.x) > 24 || Math.abs(target.y - enemy.y) > 24) continue;
        if ((this.spriteType(tower.type) === 3 || this.spriteType(tower.type) === 9)
          && target.bossType === 5) continue;
        this.recordRawDamage(tower, target, result.damage, 'reaction');
      }
    }
    this.events?.emit('reactionTriggered', {
      reactionId: result.reactionId, towerId: tower.instanceId ?? 0,
      assistTowerId: result.assistTowerId,
      enemyId: enemy.instanceId ?? 0, damage: result.damage, visualCue: result.visualCue,
    });
    return result;
  }

  private damageEnemy(
    tower: Tower,
    enemy: Enemy,
    scale: number = 1,
    applyEffect: boolean = true,
    rawOverride?: number,
  ): boolean {
    this.ensureEnemyCombatFields(enemy);
    const type = this.spriteType(tower.type);
    const reaction = (applyEffect || type === 8 || (type === 9 && tower.liquidIgnited))
      ? this.handleReaction(tower, enemy)
      : null;
    let effectApplied = false;
    if (applyEffect && tower.effectType > 0 && reaction?.reactionId !== 'ice_fire_burst') {
      effectApplied = this.applyTowerEffect(enemy, tower);
    } else if (applyEffect) {
      effectApplied = this.applyHeroSlow(enemy, tower);
    }
    const reactionMultiplier = reaction?.multiplier ?? 1;
    if (enemy.hp <= 0) return effectApplied;
    const rawDamage = Math.max(1, Math.floor((rawOverride ?? (this.towerDamage(tower) * scale)) * reactionMultiplier));
    // 原版 b1066[3]=aY 是敌人防御力；每次受击至少扣1点。
    const ignoresDefense = [1, 2, 7].includes(tower.heroId);
    const defense = Math.max(0, (enemy.defense ?? 0) - (enemy.armorBreakAmount ?? 0));
    this.recordDamage(tower, enemy,
      Math.max(1, rawDamage - (ignoresDefense ? 0 : defense)));
    // 原版兵种4在未被麻痹/寒冰控制时会立即熄灭火焰并重置架炮周期。
    if (enemy.unitType === 4 && enemy.paralyzeTimer === 0 && enemy.freezeTimer === 0) {
      this.clearEnemyStatus(enemy, 'fire', 'cleared');
      enemy.siegeTimer = 0;
    }
    return effectApplied;
  }

  private damageTarget(tower: Tower, enemies: Enemy[]): void {
    const target = enemies[tower.target];
    if (!this.isLivingEnemy(target)) return;
    const effectApplied = this.damageEnemy(tower, target);
    if (effectApplied) this.applyHeroAreaEffect(tower, target, enemies);
  }

  private applyHeroAreaEffect(tower: Tower, target: Enemy, enemies: Enemy[]): void {
    const effect = tower.heroId === 20 ? 1 : (tower.heroId === 21 ? 2 : 0);
    if (effect === 0) return;
    for (const enemy of enemies) {
      if (enemy === target || !this.isLivingEnemy(enemy)) continue;
      if (Math.abs(enemy.x - target.x) > 24 || Math.abs(enemy.y - target.y) > 24) continue;
      // 魏国范围效果只刷新附近敌人的计时；动画归零和冰火互斥只作用于主目标。
      if (effect === 1) this.setParalyze(enemy, 48, false, tower.instanceId ?? 0);
      else this.setFreeze(enemy, 48, false, false, tower.instanceId ?? 0);
    }
  }

  private damageLimeImpact(tower: Tower, enemies: Enemy[]): void {
    const primary = enemies[tower.target];
    if (this.isLivingEnemy(primary) && primary.bossType !== 8) {
      this.damageEnemy(tower, primary);
    }
    for (const enemy of enemies) {
      if (enemy === primary || !this.isLivingEnemy(enemy) || enemy.bossType === 8) continue;
      if (Math.abs(enemy.x - tower.strikeX) <= 24 && Math.abs(enemy.y - tower.strikeY) <= 24) {
        this.damageEnemy(tower, enemy, 1, true, this.splashTowerDamage(tower));
      }
    }
  }

  private damageEnemiesInCells(
    tower: Tower,
    enemies: Enemy[],
    cells: { tx: number; ty: number }[],
  ): void {
    const keys = new Set(cells.map(cell => `${cell.tx},${cell.ty}`));
    for (const enemy of enemies) {
      if (!this.isLivingEnemy(enemy) || !keys.has(`${enemy.x >> 4},${enemy.y >> 4}`)) continue;
      this.ensureEnemyCombatFields(enemy);
      switch (this.spriteType(tower.type)) {
        case 2: // 突刺：受击动画结束前不会重复结算同一个敌人
          if (enemy.hitTimer < 0) this.damageEnemy(tower, enemy);
          break;
        case 6: // 擂木：只命中正常行走态，并进入原版 1→2→3 推出/回弹状态
          if (enemy.state === EnemyState.WALK) {
            enemy.state = EnemyState.HIT_PUSH;
            enemy.impactDir = tower.orientation & 3;
            this.damageEnemy(tower, enemy);
          }
          break;
        case 8: // 沸水先熄灭火焰；4号 Boss 完全免疫沸水伤害
          this.clearEnemyStatus(enemy, 'fire', 'cleared');
          if (enemy.hitTimer < 0 && enemy.bossType !== 4) this.damageEnemy(tower, enemy, 1, false);
          break;
        case 9: // 滚油遇到正在燃烧的敌人后，本轮液体会继续点燃后续目标
          if (enemy.hitTimer < 0) {
            if (enemy.fireTimer > 0) {
              if (tower.attackPhase === 1) tower.attackFrame = Math.max(0, tower.attackFrame - 2);
              if (!tower.liquidIgnited) {
                tower.liquidIgnitionSourceTowerId = enemy.fireSourceTowerId ?? 0;
              }
              tower.liquidIgnited = true;
            }
            // 滚油直接写 [11]=48：不重置火焰帧，也不解除同时存在的寒冰。
            if (tower.liquidIgnited) {
              this.setFire(enemy, this.modifiers?.fireDuration(48) ?? 48, false, false, tower.instanceId ?? 0);
            }
            if (tower.liquidIgnited && this.features.reactions && this.reactions) {
              const eventId = `${tower.instanceId ?? 0}:${tower.attackSequence ?? 0}`;
              const result = this.reactions.igniteGround(
                eventId,
                tower,
                enemy.x >> 4,
                enemy.y >> 4,
                tower.liquidIgnitionSourceTowerId,
              );
              if (result) {
                this.events?.emit('reactionTriggered', {
                  reactionId: result.reactionId, towerId: tower.instanceId ?? 0,
                  assistTowerId: result.assistTowerId,
                  enemyId: enemy.instanceId ?? 0, damage: 0, visualCue: result.visualCue,
                });
              }
            }
            this.damageEnemy(tower, enemy, 1, false);
          }
          break;
        default:
          this.damageEnemy(tower, enemy);
      }
    }
  }

  private spikeActiveCells(tower: Tower, phase: number): { tx: number; ty: number }[] {
    const orientation = tower.orientation & 3;
    const spread = TOWER_DIR_SPREAD_M1084[orientation];
    const cells: { tx: number; ty: number }[] = [];
    // 原版攻击帧先把对应带写为 D1162=5，并在 9/12 帧以 n4>=4
    // 把完整 3×3 写回 1。这个命中时序与 g(...) 的视觉伸缩时序并不相同。
    let activeLines: readonly number[];
    if (phase >= 1 && phase <= 3) activeLines = [0];
    else if (phase >= 4 && phase <= 7) activeLines = [0, 1];
    else if (phase === 8) activeLines = [0, 1, 2];
    else if (phase >= 10 && phase <= 11) activeLines = [2];
    else activeLines = [];
    for (let i = 0; i < 3; i++) {
      for (let j = 0; j < 3; j++) {
        const line = orientation === 0 || orientation === 2 ? j : i;
        if (!activeLines.includes(line)) continue;
        const px = tower.x * TILE_SIZE + (i << 4) * spread[0] + spread[2];
        const py = tower.y * TILE_SIZE + (j << 4) * spread[1] + spread[3];
        cells.push({ tx: px >> 4, ty: py >> 4 });
      }
    }
    return cells;
  }

  /** 旧版统一倒计时实现，仅保留到本轮状态机迁移完成。 */
  /**
   * 获取指定塔周围的塔列表 (新增方法)
   * 用于效果9 (auraAtkUp) 周围塔攻击增加
   * @param tower 中心塔
   * @param radius 搜索半径 (像素)
   */
  private getNearbyTowers(tower: Tower, radius: number): Tower[] {
    const result: Tower[] = [];
    const cx = tower.x;
    const cy = tower.y;
    const tileRadius = Math.ceil(radius / 16); // 16 = TILE_SIZE
    for (const t of this.towers) {
      if (t === tower) continue;
      const dx = Math.abs(t.x - cx);
      const dy = Math.abs(t.y - cy);
      if (dx <= tileRadius && dy <= tileRadius) {
        result.push(t);
      }
    }
    return result;
  }

  /**
   * 应用塔特殊效果到敌人
   */
  private applyTowerEffect(enemy: Enemy, tower: Tower): boolean {
    this.ensureEnemyCombatFields(enemy);
    switch (tower.effectType) {
      case 1: // 麻痹
        if (!this.rollStatusEffect(tower, false)) return false;
        this.setParalyze(enemy, this.modifiers?.paralyzeDuration(tower.level === 7 && this.faction === 0 ? 96 : 48) ?? (tower.level === 7 && this.faction === 0 ? 96 : 48), true, tower.instanceId ?? 0);
        break;
      case 2: // 冰冻
        if (!this.rollStatusEffect(tower, true)) return false;
        this.setFreeze(enemy, this.modifiers?.freezeDuration(tower.level === 7 && this.faction === 0 ? 96 : 48) ?? (tower.level === 7 && this.faction === 0 ? 96 : 48), true, true, tower.instanceId ?? 0);
        break;
      case 3: // 中毒
        this.setPoison(
          enemy,
          tower.level === 7 && this.faction === 2 ? 96 : 48,
          tower.level,
          tower.instanceId ?? 0,
        );
        this.applyHeroSlow(enemy, tower);
        enemy.effect = 3;
        enemy.timer = Math.max(enemy.timer ?? 0, enemy.poisonTimer);
        break;
      case 4: // 火焰
        // 类型9滚油由道路交互决定是否点燃，普通命中本身不直接附火。
        if (this.spriteType(tower.type) === 9) return false;
        this.setFire(enemy, this.modifiers?.fireDuration(tower.level === 7 && this.faction === 2 ? 96 : 48) ?? (tower.level === 7 && this.faction === 2 ? 96 : 48), true, true, tower.instanceId ?? 0);
        break;
      case 5: // 减速
        this.setSlow(enemy, 48, true, tower.instanceId ?? 0);
        break;
      default:
        return this.applyHeroSlow(enemy, tower);
    }
    return true;
  }

  private rollStatusEffect(tower: Tower, freeze: boolean): boolean {
    // 麻痹使用 A1151 等级阈值；寒冰在非吴国固定阈值3。吴国两者均降为0（7/8概率）。
    const threshold = this.faction === 2
      ? 0
      : freeze
        ? 3
        : ([6, 6, 5, 5, 4, 4, 4][Math.max(0, Math.min(6, tower.level - 1))] ?? 4);
    return ((Math.random() * 8) | 0) > threshold;
  }

  private applyHeroSlow(enemy: Enemy, tower: Tower): boolean {
    if (![3, 6].includes(tower.heroId) || enemy.bossType === 7) return false;
    this.setSlow(enemy, 48, true, tower.instanceId ?? 0);
    return true;
  }

  private setParalyze(enemy: Enemy, duration: number, resetFrame: boolean = true, towerId: number = 0): void {
    this.ensureEnemyCombatFields(enemy);
    const previousDuration = enemy.paralyzeTimer;
    enemy.paralyzeTimer = Math.max(enemy.paralyzeTimer, duration);
    if (duration >= previousDuration) enemy.paralyzeSourceTowerId = towerId;
    if (resetFrame) enemy.paralyzeFrame = 0;
    enemy.effect = 1;
    enemy.timer = Math.max(enemy.timer ?? 0, enemy.paralyzeTimer);
    this.emitStatusSet(enemy, 'paralyze', previousDuration, enemy.paralyzeTimer, enemy.paralyzeSourceTowerId ?? 0);
  }

  private setFreeze(
    enemy: Enemy,
    duration: number,
    resetFrame: boolean = true,
    extinguishFire: boolean = true,
    towerId: number = 0,
  ): void {
    this.ensureEnemyCombatFields(enemy);
    const previousDuration = enemy.freezeTimer;
    enemy.freezeTimer = Math.max(enemy.freezeTimer, duration);
    if (duration >= previousDuration) enemy.freezeSourceTowerId = towerId;
    if (resetFrame) enemy.freezeFrame = 0;
    // 原版只有寒冰塔的主目标会立即熄灭火焰；魏国范围冰冻只写计时。
    if (extinguishFire) this.clearEnemyStatus(enemy, 'fire', 'replaced');
    enemy.effect = 2;
    enemy.timer = Math.max(enemy.timer ?? 0, enemy.freezeTimer);
    this.emitStatusSet(enemy, 'freeze', previousDuration, enemy.freezeTimer, enemy.freezeSourceTowerId ?? 0);
  }

  private currentFirePower(): number {
    return this.getFireDamageOverTime();
  }

  /** 原版 z(int) 每次火焰跳伤都读取 f1106[3]，出售七级烟火后立即恢复为 8。 */
  getFireDamageOverTime(): number {
    return this.towers.some(tower => tower.heroId === 8) ? 16 : 8;
  }

  private setFire(
    enemy: Enemy,
    duration: number,
    resetFrame: boolean = true,
    clearFreeze: boolean = true,
    towerId: number = 0,
  ): void {
    this.ensureEnemyCombatFields(enemy);
    const previousDuration = enemy.fireTimer;
    enemy.fireTimer = Math.max(enemy.fireTimer, duration);
    if (duration >= previousDuration) enemy.fireSourceTowerId = towerId;
    if (resetFrame) enemy.fireFrame = 0;
    enemy.firePower = this.currentFirePower();
    // 原版只有烟火主命中会解除寒冰；滚油直接刷新火焰计时，可与寒冰共存。
    if (clearFreeze) this.clearEnemyStatus(enemy, 'freeze', 'replaced');
    enemy.effect = 4;
    enemy.timer = Math.max(enemy.timer ?? 0, enemy.fireTimer);
    this.emitStatusSet(enemy, 'fire', previousDuration, enemy.fireTimer, enemy.fireSourceTowerId ?? 0);
  }

  private setPoison(enemy: Enemy, duration: number, power: number, towerId: number): void {
    this.ensureEnemyCombatFields(enemy);
    const previousDuration = enemy.poisonTimer;
    if (power < enemy.poisonPower) return;
    enemy.poisonPower = power;
    enemy.poisonTimer = Math.max(enemy.poisonTimer, duration);
    if (duration >= previousDuration) enemy.poisonSourceTowerId = towerId;
    enemy.poisonFrame = 0;
    this.emitStatusSet(enemy, 'poison', previousDuration, enemy.poisonTimer, enemy.poisonSourceTowerId ?? 0);
  }

  private setSlow(enemy: Enemy, duration: number, resetFrame: boolean = true, towerId: number = 0): void {
    this.ensureEnemyCombatFields(enemy);
    const previousDuration = enemy.slowTimer;
    enemy.slowTimer = Math.max(enemy.slowTimer, duration);
    if (duration >= previousDuration) enemy.slowSourceTowerId = towerId;
    if (resetFrame) enemy.slowFrame = 0;
    if ((enemy.effect ?? 0) === 0) enemy.effect = 5;
    enemy.timer = Math.max(enemy.timer ?? 0, enemy.slowTimer);
    this.emitStatusSet(enemy, 'slow', previousDuration, enemy.slowTimer, enemy.slowSourceTowerId ?? 0);
  }

  /**
   * 动画帧推进 (对应原版 ah() 行13890 + c(int×3) 行16946)
   * 每100ms逻辑帧: 帧+1 > w1123[type].length-3 时归零;
   * 类型0/4 (弓手塔/麻痹矢) 归零时朝向随机 (原版: entity[5] = rand & 3)
   */
  private tickAnim(): void {
    for (const tower of this.towers) {
      const st = this.spriteType(tower.type); // 弓手塔19→原版塔0动画序列
      const seq = TOWER_ANIM_W1123[st === 4 ? 0 : st];
      if (seq && seq.length > 2) {
        const next = tower.frame + 1;
        if (next > seq.length - 3) {
          tower.frame = 0;
          if (st === 0 || st === 4) {
            tower.orientation = (Math.random() * 4) | 0;
          }
        } else {
          tower.frame = next;
        }
      }
      if (tower.buildEffect !== 0) {
        tower.buildEffectFrame++;
        if (tower.buildEffectFrame >= BUILD_EFFECT_FRAME_COUNT) {
          tower.buildEffect = 0;
          tower.buildEffectFrame = 0;
        }
      }
    }
  }

  /**
   * 瞄准角度 → 原版朝向 (0=上 1=右 2=下 3=左, 由 k1141 偏移表佐证)
   */
  private angleToOrientation(angle: number): number {
    if (angle >= -Math.PI / 4 && angle < Math.PI / 4) return 1;
    if (angle >= Math.PI / 4 && angle < (3 * Math.PI) / 4) return 2;
    if (angle >= (-3 * Math.PI) / 4 && angle < -Math.PI / 4) return 0;
    return 3;
  }

  /**
   * 按前缀+下标取精灵图 (带缓存)
   */
  private spr(prefix: string, index: number): HTMLImageElement | null {
    if (!this.spriteLoader) return null;
    const key = `${prefix}_${index}`;
    if (!this.spriteCache.has(key)) {
      this.spriteCache.set(key, this.spriteLoader.getByPrefix(prefix, index));
    }
    return this.spriteCache.get(key) ?? null;
  }

  /**
   * 渲染所有塔
   */
  render(offsetX: number = 0, offsetY: number = 0): void {
    for (const tower of this.towers) {
      const px = offsetX + tower.x * TILE_SIZE;
      const py = offsetY + tower.y * TILE_SIZE;
      const config = this.towerConfigs[tower.type];

      // 原版第一遍先绘制建筑本体与常驻机件层；攻击过程由循环结束后的第二遍统一叠加。
      // 不能在这里先画 bu 攻击层，否则随后的建筑本体会遮住箭矢、擂木和投石等动作。
      let spriteDrawn = false;
      if (this.spriteLoader) {
        if (this.spriteType(tower.type) === 2) {
          spriteDrawn = this.renderSpikeBase(tower, px, py, -1) || spriteDrawn;
        }
        if (tower.type === 10) {
          spriteDrawn = this.renderGatePathStones(tower, offsetX, offsetY) || spriteDrawn;
        }
        // 原版主模型层：t{type}_0。此前遗漏该层，导致截图中的弓手塔/突刺
        // 只剩 bu 图集的攻击效果，外观完全不像原版。
        spriteDrawn = this.renderModel(tower, px, py) || spriteDrawn;
        spriteDrawn = this.renderAmbientAnim(tower, px, py) || spriteDrawn;
        this.renderBuildEffect(tower, px, py);
      }

      if (!spriteDrawn) {
        // 绘制塔基座
        this.renderer.setColor(0x3a2a1a);
        this.renderer.fillRect(px, py, TILE_SIZE, TILE_SIZE);

        // 绘制塔身
        this.renderer.setColor(config.color);
        this.renderer.fillRect(px + 2, py + 2, TILE_SIZE - 4, TILE_SIZE - 4);
      }

      // 绘制等级
      this.renderer.setColor(0xFCFFCD);
      for (let i = 0; i < tower.level; i++) {
        this.renderer.fillRect(px + 2 + i * 3, py + TILE_SIZE - 4, 2, 2);
      }

      // ====== 新增: 绘制塔血条 (当血量不满时) ======
      if (tower.hp < tower.maxHp) {
        const barW = TILE_SIZE;
        const barH = 2;
        const hpRatio = Math.max(0, tower.hp / tower.maxHp);
        this.renderer.setColor(0x000000);
        this.renderer.fillRect(px, py - 4, barW, barH);
        // 血量颜色: >50% 绿, >25% 黄, <25% 红
        const hpColor = hpRatio > 0.5 ? 0x00FF00 : (hpRatio > 0.25 ? 0xFFC107 : 0xFF0000);
        this.renderer.setColor(hpColor);
        this.renderer.fillRect(px, py - 4, barW * hpRatio, barH);
      }

      // 绘制 debuff 状态 (被敌人施加 debuff 时闪烁)
      if (tower.debuffTimer > 0) {
        this.renderer.setColor(0x9370DB);
        this.renderer.drawRect(px - 1, py - 1, TILE_SIZE + 2, TILE_SIZE + 2);
      }

      // 绘制武将名称 (已觉醒时)
      if (tower.heroId >= 0) {
        const heroName = this.getHeroName(tower.heroId);
        if (heroName) {
          this.renderer.setColor(0xFFD700);
          this.renderer.drawText(heroName, px - 4, py - 10, 0xFFD700, 7);
        }
      }

    }

    // 原版 ag() 在所有建筑本体完成后另起一遍循环调用 y(int)，确保攻击过程位于建筑层之上。
    if (this.spriteLoader) {
      for (const tower of this.towers) {
        const px = offsetX + tower.x * TILE_SIZE;
        const py = offsetY + tower.y * TILE_SIZE;
        this.renderAttackProcess(tower, px, py);
      }
    }

    // 绘制建造预览 (对应原版 am() case 1 行14719: 范围圈+逐格指示+角标+塔幻影)
    if (this.buildMode) {
      this.renderBuildPreview(offsetX, offsetY);
    }
  }

  // ============================================================
  // 原版塔渲染: 主模型/常驻层 + 顶层攻击过程
  // ============================================================

  /**
   * 绘制原版 t0_0..t10_0 主模型。
   * a.java 的 ag() 第一遍按 f1112/g1113/q1114 拼出 t 图集主模型，
   * 第二遍才调用 y() 叠加 bu 攻击过程。
   */
  private renderModel(tower: Tower, px: number, py: number): boolean {
    const type = this.spriteType(tower.type);
    const img = this.spr(`t${type}`, 0);
    const rects = TOWER_MODEL_RECTS_F1112[type];
    const groups = TOWER_MODEL_POINTS_G1113[type];
    if (!img || !rects || !groups) return false;

    const level0 = Math.max(0, Math.min(5, tower.level - 1));
    const groupIndex = Math.min(groups.length - 1, level0 >> 1);
    const points = groups[groupIndex] ?? [];
    const count = TOWER_MODEL_PART_COUNTS_Q1114[type]?.[groupIndex] ?? Math.floor(points.length / 3);
    const [deviceDx, deviceDy] = type === 10
      ? (TOWER_DEVICE_MODEL_OFF_R1115[tower.orientation & 3] ?? [0, 0])
      : [0, 0];
    // g1113 的 dx/dy 均以实体中心为原点；塔坐标自身是占地区域左上角。
    const half = (TOWER_ANCHOR_O1098[type] ?? 2) << 3;
    const ax = px + half;
    const ay = py + half;

    let drawn = false;
    for (let i = 0; i < count; i++) {
      const base = i * 3;
      const rectIndex = points[base] ?? -1;
      const rect = rects[rectIndex];
      if (!rect) continue;
      const dx = (points[base + 1] ?? 0) + deviceDx;
      const dy = (points[base + 2] ?? 0) + deviceDy;
      // 原版主模型对 0-9 号建筑始终使用 transform=0；投石图集的三张
      // 等级外观本身已经包含姿态，不能再按道路方向旋转整张裁剪图。
      this.renderer.drawSpriteTransform(
        img, rect[0], rect[1], rect[2], rect[3], ax + dx, ay + dy, 0,
      );
      drawn = true;
    }
    return drawn;
  }

  /** 原版 d(type,state,x,y)：在建筑四角播放 ui_20 的 9 帧白烟。 */
  private renderBuildEffect(tower: Tower, px: number, py: number): boolean {
    if (tower.buildEffect === 0) return false;
    const smoke = this.spr('ui', 20);
    if (!smoke) return false;
    const type = this.spriteType(tower.type);
    const half = (TOWER_ANCHOR_O1098[type] ?? 2) << 3;
    const frame = Math.max(0, Math.min(BUILD_EFFECT_FRAME_COUNT - 1, tower.buildEffectFrame));
    const frameX = frame * 27;
    const frameShiftX = frame === 0 ? 0 : 4;
    const offsets: readonly [number, number][] = [
      [-13, -43], [-24, -32], [-4, -32], [-13, -22],
    ];
    for (const [dx, dy] of offsets) {
      this.renderer.drawSpriteTransform(
        smoke, frameX, 0, 27, 29,
        px + half + dx - frameShiftX,
        py + half + dy,
        0,
      );
    }
    return true;
  }

  /** 原版 am() case 0：四角框包裹完整占地；确认选中后才向外呼吸并显示范围。 */
  private renderSelectedTowerFrame(tower: Tower, px: number, py: number, selected: boolean): void {
    const footprint = TOWER_FOOTPRINT_O1098[this.spriteType(tower.type)] ?? 1;
    const size = footprint << 4;
    const center = footprint << 3;
    const showRange = selected || TOWER_PROJECTILE_RANGE_TYPES.includes(this.spriteType(tower.type));
    if (showRange && tower.range > 0) {
      const ctx = this.renderer.virtualContext;
      ctx.save();
      ctx.strokeStyle = selected ? 'rgba(255, 255, 255, 0.92)' : 'rgba(255, 102, 102, 0.86)';
      ctx.lineWidth = selected ? 1.5 : 1;
      ctx.beginPath();
      ctx.arc(px + center, py + center, tower.range, 0, Math.PI * 2);
      ctx.stroke();
      ctx.restore();
    }

    const corner = this.spr('ui', 0);
    if (!corner) return;
    const pulse = selected ? (this.previewFrame & 1) << 1 : 0;
    const pulseDirs: [number, number][] = [[-1, -1], [1, -1], [1, 1], [-1, 1]];
    for (let k = 0; k < 4; k++) {
      const cx = px + (size - 7) * CURSOR_CORNER_O1156[k][0] + pulseDirs[k][0] * pulse;
      const cy = py + (size - 7) * CURSOR_CORNER_O1156[k][1] + pulseDirs[k][1] * pulse;
      this.renderer.drawSpriteTransform(corner, k * 7, 0, 7, 7, cx, cy, 0);
    }

    // ui_1 红色定位标记始终跟随建筑左上边缘，并以完整占地宽度居中。
    const marker = this.spr('ui', 1);
    if (marker) {
      const bounce = (this.previewFrame & 1) << 1;
      this.renderer.drawImage(marker, px + center - (marker.width >> 1), py - TILE_SIZE - bounce);
    }
  }

  /**
   * 原版 c(int×6)：装填时使用 bu_43 只画一排 3 块；释放前两帧抬起石排，
   * 第 2..4 帧使用 bu_44/45/46 播放落闸。释放后的完整 3×3 石阵由 D1162 持久绘制。
   */
  private renderGatePathStones(tower: Tower, offsetX: number, offsetY: number): boolean {
    const stone = this.spr('bu', 43);
    if (!stone) return false;
    const orientation = tower.orientation & 3;
    const [dirX, dirY] = TOWER_GATE_LOAD_DIR_S1117[orientation];
    const [startX, startY] = TOWER_GATE_LOAD_OFF_T1118[orientation];
    const baseX = offsetX + tower.x * TILE_SIZE;
    const baseY = offsetY + tower.y * TILE_SIZE;
    let drawn = false;

    if (tower.gateLoaded) {
      for (let i = 0; i < 3; i++) {
        this.renderer.drawSpriteTransform(
          stone, 0, 0, 15, 20,
          baseX + startX + dirX * i * TILE_SIZE,
          baseY + startY + dirY * i * TILE_SIZE,
          0,
        );
      }
      drawn = true;
    }

    if (tower.gateState === 1 && tower.gateTimer < 3) {
      for (let i = 0; i < 3; i++) {
        this.renderer.drawSpriteTransform(
          stone, 0, 20, 15, 42,
          baseX + startX + dirX * i * TILE_SIZE,
          baseY + startY - 22 + dirY * i * TILE_SIZE,
          0,
        );
      }
      drawn = true;
    }

    if (tower.gateState === 1 && tower.gateTimer > 1 && tower.gateTimer < 5) {
      drawn = this.renderGateFallFrame(tower, baseX, baseY, tower.gateTimer - 2) || drawn;
    }
    return drawn;
  }

  /** bu_44/45/46 的三方向裁切帧，逐像素对应原版 c(int×6) 的 timer=2..4。 */
  private renderGateFallFrame(tower: Tower, baseX: number, baseY: number, frame: number): boolean {
    const orientation = tower.orientation & 3;
    const rect = TOWER_GATE_FALL_RECTS_H1121[orientation]?.[frame];
    if (!rect) return false;
    const [src, length] = rect;
    let img: HTMLImageElement | null = null;
    for (let i = 0; i < 3; i++) {
      switch (orientation) {
        case 0:
          img = this.spr('bu', 44);
          if (img) this.renderer.drawSpriteTransform(img, 0, src, 16, length, baseX + i * TILE_SIZE, baseY - 37, 0);
          break;
        case 1: {
          img = this.spr('bu', 45);
          const [dx, dy] = TOWER_GATE_FALL_OFF_U1119[frame];
          if (img) this.renderer.drawSpriteTransform(img, src, 0, length, 18, baseX + dx, baseY + dy + i * TILE_SIZE, 1);
          break;
        }
        case 2:
          img = this.spr('bu', 46);
          if (img) this.renderer.drawSpriteTransform(img, 0, src, 15, length, baseX + i * TILE_SIZE, baseY + 30, 0);
          break;
        case 3: {
          img = this.spr('bu', 45);
          const [dx, dy] = TOWER_GATE_FALL_OFF_V1120[frame];
          if (img) this.renderer.drawSpriteTransform(img, src, 0, length, 18, baseX + dx, baseY + dy + i * TILE_SIZE, 0);
          break;
        }
      }
    }
    return img !== null;
  }

  /** 底部明细区使用的完整塔模型预览，复用战场的原版素材合成路径。 */
  renderTowerPreview(type: number, level: number, centerX: number, centerY: number): void {
    const stats = this.originalStats(type, level);
    const ghost: Tower = {
      x: 0, y: 0, type, level,
      damage: stats.damage, range: stats.range, fireRate: stats.fireRate,
      cooldown: 0, target: -1, angle: 0, heroId: -1,
      effectType: this.towerConfigs[type]?.effect ?? 0,
      hp: 1, maxHp: 1, debuffTimer: 0,
      frame: 0, orientation: 0, attackAnim: 0,
      attackState: 0, attackPhase: 0, attackFrame: 0, volleyFrames: [], liquidPattern: 0,
      liquidIgnited: false,
      buildEffect: 0, buildEffectFrame: 0,
      strikeX: 0, strikeY: 0,
      gateLoaded: false, gateState: 0, gateTimer: 0,
    };
    const half = (TOWER_ANCHOR_O1098[this.spriteType(type)] ?? 2) << 3;
    const px = centerX - half;
    const py = centerY - half;
    this.renderModel(ghost, px, py);
  }

  /**
   * 塔辅助结构层 (对应原版 y(int) 行26281, 按实体类型 entity[2] 分派)。
   *
   * 注意：这里的 bu 图集分组并不按建筑名称顺排。例如 0/4 共用箭矢架，
   * 3/5 共用火/冰装置，6 才使用擂木结构。主模型 t{type}_0、攻击层和这里
   * 必须始终使用同一个原版 type，不能按视觉猜测重新编号。
   * 实体锚点 = 瓦片左上 + o1098[type]*8 (原版 entity[0]/[1] + o1098<<3)
   * 唯一分派表见 TOWER_AUX_LAYER_BY_TYPE；不要在这里另建一套编号。
   * 仅在 attackState==1 时绘制，并直接使用原版 attackPhase/entity[10]
   * 与 attackFrame/entity[13]，不能再以建筑等级代替动作帧。
   * @returns 是否画出了精灵
   */
  private renderAttackProcess(tower: Tower, px: number, py: number): boolean {
    const type = this.spriteType(tower.type);
    if (type === 10) {
      return tower.gateState === 2 && this.renderGateActiveLayer(tower, px, py, tower.gateTimer);
    }
    if (tower.attackState !== 1) return false;

    const level0 = tower.level - 1;
    const half = (TOWER_ANCHOR_O1098[type] ?? 2) << 3;
    const ax = px + half;
    const ay = py + half;
    switch (TOWER_AUX_LAYER_BY_TYPE[type]) {
      case 'arrow':
        return this.renderStripBase(tower, ax, ay, level0, tower.attackFrame);
      case 'lime':
        return this.renderLimeBottleBase(tower, ax, ay, level0, tower.attackFrame);
      case 'spike':
        return this.renderSpikeBase(tower, px, py, tower.attackFrame);
      case 'fire-ice':
        return this.renderFireIceBase(
          tower, px, py, ax, ay, level0, tower.attackPhase, tower.attackFrame,
        );
      case 'log':
        return this.renderLogBase(tower, px, py, tower.attackFrame);
      case 'catapult':
        return this.renderCatapultBase(
          tower, px, py, ax, ay, level0, tower.attackPhase, tower.attackFrame,
        );
      case 'liquid':
        let liquidDrawn = false;
        if (tower.attackPhase === 0) {
          liquidDrawn = this.renderLiquidBase(
            tower,
            px,
            py,
            tower.attackFrame,
            type === 8 ? [32, 33, 34] : [36, 37, 38],
          );
        }
        // 原版 ai() 还会在道路格上绘制 bu_31/bu_35；此前完全漏掉了这层，
        // 导致沸水和滚油只有阀门动作、看不到真正流出的液体。
        liquidDrawn = this.renderLiquidAttackSpread(tower, px, py) || liquidDrawn;
        // 原版只有本轮滚油遇到燃烧敌人、entity[16] 置 1 后才绘制 bu_39 引燃层。
        if (type === 9 && tower.attackPhase !== 0 && tower.liquidIgnited) {
          liquidDrawn = this.renderOilSpread(tower, px, py) || liquidDrawn;
        }
        return liquidDrawn;
      default:
        return false;
    }
  }

  /**
   * 条状辅助结构 (对应原版 a(Image,Image,int×5) 行11485; y() case 0/1/4)
   * 组: 0=弓手塔(bu_2+bu_1箭矢) 1=麻痹矢(bu_4+bu_3箭矢) 2=石灰瓶(bu_5, 无箭矢)
   * 原版仅等级 entity[13]<3 时绘制
   */
  private renderStripBase(
    tower: Tower,
    ax: number,
    ay: number,
    level0: number,
    actionFrame: number,
  ): boolean {
    if (actionFrame < 0 || actionFrame >= 3) return false;
    const type = this.spriteType(tower.type);
    const group = type === 0 ? 0 : (type === 4 ? 1 : 2);
    const baseImg = this.spr('bu', group === 0 ? 2 : (group === 1 ? 4 : 5));
    if (!baseImg) return false;

    const orient = tower.orientation & 3;
    const j = TOWER_BASE_OFFSETS_J1139[group];
    // 原版: 等级行 = (min(entity[3],5)>>1)+4; entity[3] 用 level0 近似
    const lvlRow = (Math.min(level0, 5) >> 1) + 4;
    const d = TOWER_LEVEL_FRAME_D1135[actionFrame]; // entity[13] 对应的装填/发射帧
    const bx = ax + j[orient][0] + j[lvlRow][0]; // 原版 var19
    const by = ay + j[orient][1] + j[lvlRow][1]; // 原版 var20 (+13已并入渲染偏移)

    // 原版按朝向 switch(entity[5]) 定绘制偏移/源矩形/transform (a.java:11550-11597)
    // 朝向0/2: 源=(d[0], 0, d[1], 15); 朝向1/3: 源=(0, d[0], 15, d[1]) (竖条经旋转变横条)
    let dx = 0;
    let dy = 0;
    let sx = 0;
    let sy = 0;
    let sw = 0;
    let sh = 0;
    let transform = 0;
    switch (orient) {
      case 0: dx = bx + d[2]; dy = by - d[3]; sx = d[0]; sy = 0; sw = d[1]; sh = 15; transform = 2; break;
      case 1: dx = bx + d[3]; dy = by + d[2]; sx = 0; sy = d[0]; sw = 15; sh = d[1]; transform = 4; break;
      case 2: dx = bx + d[2]; dy = by + d[3]; sx = d[0]; sy = 0; sw = d[1]; sh = 15; transform = 0; break;
      case 3: dx = bx - d[3]; dy = by + d[2]; sx = 0; sy = d[0]; sw = 15; sh = d[1]; transform = 5; break;
    }
    this.renderer.drawSpriteTransform(baseImg, sx, sy, sw, sh, dx, dy, transform);

    // 弓手塔/麻痹矢: 沿朝向画 5 个箭矢帧 (bu_1/bu_3, 9x9帧；石灰瓶无此层)
    // 原版: 位置 = (bx+entity[11]*i, by+entity[12]*i), 帧 = C1134[entity][i]*9
    // H5简化: entity[11]/[12] 用朝向单位向量近似, 球帧按动画帧滚动
    if (group !== 2) {
      const ballImg = this.spr('bu', group === 0 ? 1 : 3);
      if (ballImg) {
        const [targetX, targetY] = this.strikePoint(tower, ax, ay);
        const stepX = Math.trunc((targetX - bx) / 5);
        const stepY = Math.trunc((targetY - by) / 5);
        for (let i = 0; i < 5; i++) {
          const ballFrame = tower.volleyFrames[i] ?? -1;
          if (ballFrame < 0 || ballFrame * 9 >= ballImg.width) continue;
          this.renderer.drawSpriteTransform(
            ballImg,
            ballFrame * 9,
            0,
            9,
            9,
            bx + stepX * i,
            by + stepY * i,
            0,
          );
        }
      }
    }
    return true;
  }

  /**
   * 擂木辅助结构 (对应原版 f(int x,int y,int type,int level) 行20267)
   * 朝向外观 = tower.orientation (原版 entity[5]); 三表: I1142/k1141/l1143
   * 主件: 等级<3 时 bu[I1142[app][0]], srcX = 等级*帧宽, 偏移 k1141[等级][app]
   * 装饰件: 等级1-2 → 件0,1 (srcX=等级*帧宽); 等级3-5 → 件2,3 (srcX=(等级-3)*帧宽)
   */
  private renderLogBase(tower: Tower, x: number, y: number, actionFrame: number): boolean {
    const app = tower.orientation & 3;
    let drawn = false;

    if (actionFrame >= 0 && actionFrame < 3) {
      const main = TOWER_BASE_I1142[app]; // [bu图, transform, 帧宽, 帧高]
      const img = this.spr('bu', main[0]);
      if (img) {
        const dx = x + TOWER_BASE_OFF_K1141[actionFrame][app][0];
        const dy = y + TOWER_BASE_OFF_K1141[actionFrame][app][1];
        this.renderer.drawSpriteTransform(
          img, actionFrame * main[2], 0, main[2], main[3], dx, dy, main[1],
        );
        drawn = true;
      }
    }

    const pieces = actionFrame >= 1 && actionFrame <= 2
      ? [0, 1]
      : (actionFrame >= 3 && actionFrame <= 5 ? [2, 3] : []);
    for (const pi of pieces) {
      const p = TOWER_DECOR_L1143[app][pi]; // [bu图, dx, dy, transform, 帧宽, 帧高]
      const img = this.spr('bu', p[0]);
      if (!img) continue;
      const srcX = (actionFrame <= 2 ? actionFrame : actionFrame - 3) * p[4];
      this.renderer.drawSpriteTransform(img, srcX, 0, p[4], p[5], x + p[1], y + p[2], p[3]);
      drawn = true;
    }
    return drawn;
  }

  /**
   * 石灰瓶辅助结构 (对应原版 y() case 1, a.java:26326-26471)
   * 等级<3: bu_5 基座 (a(Image,Image) 行11485, 无球);
   * 等级<4: 沿朝向画 level 段 bu_7 (10x10帧, srcX=段号*10) + 尖端 bu_6 (12x12帧, srcX=段号*12)
   * 等级>=4: b(Image,int×4) 行16447 — bu_8 按 H1140 七点绘制 + p() 旗帜
   * 朝向单位向量近似原版 entity[11]/[12] (与 renderStripBase 的条状部件同一简化)
   */
  private renderLimeBottleBase(
    tower: Tower,
    ax: number,
    ay: number,
    level0: number,
    actionFrame: number,
  ): boolean {
    const orient = tower.orientation & 3;
    const j = TOWER_BASE_OFFSETS_J1139[2]; // 组2=石灰瓶
    const lvlRow = (Math.min(level0, 5) >> 1) + 4; // 原版 (min(entity[3],5)>>1)+4
    const offX = j[orient][0] + j[lvlRow][0]; // 原版 var18 (a.java:26347)
    const offY = j[orient][1] + j[lvlRow][1]; // 原版 var19 (a.java:26368, +13 已并入 ay)
    let drawn = false;
    const originX = ax + offX;
    const originY = ay + offY;
    const [targetX, targetY] = this.strikePoint(tower, ax, ay);
    const stepX = Math.trunc((targetX - originX) / 4);
    const stepY = Math.trunc((targetY - originY) / 4);

    if (actionFrame < 4) {
      if (actionFrame < 3) {
        // bu_5 基座 (a.java:26395 调 a(Image,Image) 行11485, 第二张图为 null → 无球)
        drawn = this.renderStripBase(tower, ax, ay, level0, actionFrame);
      }
      for (let i = 0; i <= actionFrame; i++) {
        const sx = originX + stepX * i;
        const sy = originY + stepY * i;
        if (i > 0) {
          const seg = this.spr('bu', 7);
          if (seg && i * 10 < seg.width) {
            this.renderer.drawSpriteTransform(seg, i * 10, 0, 10, 10, sx, sy, 0);
            drawn = true;
          }
        }
        if (i === actionFrame) {
          const tip = this.spr('bu', 6);
          if (tip && i * 12 < tip.width) {
            this.renderer.drawSpriteTransform(tip, i * 12, 0, 12, 12, sx, sy, 0);
            drawn = true;
          }
        }
      }
    } else {
      drawn = this.renderH1140Points(this.spr('bu', 8), targetX, targetY, actionFrame - 4);
    }
    return drawn;
  }

  /**
   * H1140 七点装饰 + p() 旗帜 (对应原版 b(Image,int×4) 行16447)
   * 各点: srcX = (H1140[i][2] + 等级增量)*16, 16x16 帧
   */
  private renderH1140Points(img: HTMLImageElement | null, x: number, y: number, lvl: number): boolean {
    if (!img) return false;
    let drawn = false;
    for (const p of TOWER_DEVICE_POINTS_H1140) {
      const srcX = (p[2] + lvl) * 16;
      if (srcX < 0 || srcX + 16 > img.width) continue;
      this.renderer.drawSpriteTransform(img, srcX, 0, 16, 16, x + p[0], y + p[1], 0);
      drawn = true;
    }
    this.renderFlag(x - 10, y - 25, lvl);
    return drawn;
  }

  /**
   * 旗帜绘制 (对应原版 p(int×3) 行23940)
   * ui_20 图集 27x29 帧, srcX=等级*27; 等级0 时 x 不左移 4px
   * 注意: 原版 p() 屏幕 Y 不加 13 (与其他方法不同), 此处 -13 补偿
   */
  private renderFlag(x: number, y: number, lvl: number): void {
    const flag = this.spr('ui', 20);
    if (!flag) return;
    if (lvl < 0 || lvl >= 9) return;
    this.renderer.drawSpriteTransform(flag, lvl * 27, 0, 27, 29, x - (lvl === 0 ? 0 : 4), y - 13, 0);
  }

  /**
   * 突刺攻击地刺 (对应原版 g(int 朝向,int x,int y,int 攻击阶段) 行21008 + r(int×3) 行24522)
   * 3×3 地格沿朝向展开 (m1084 表); 阶段 0-6 长第 1 排, 4-9 第 2 排(帧=阶段-3), 7-11 第 3 排(帧=阶段-6)
   * 朝向 0/2 按行(y) 展开, 朝向 1/3 按列(x) 展开
   * r(): 每格先画 bu_42 底座(7x23), 帧<5 时画 bu_41 刺帧 (9x26, srcX=帧*9, Y 偏移 z1148[帧])
   */
  private renderSpikeBase(tower: Tower, px: number, py: number, phase: number): boolean {
    const orient = tower.orientation & 3;
    const m = TOWER_DIR_SPREAD_M1084[orient];
    const holes = this.spr('bu', 40);
    const img41 = this.spr('bu', 41);
    const img42 = this.spr('bu', 42);
    if (!img42) return false;
    let drawn = false;
    for (let i = 0; i < 3; i++) {
      for (let j = 0; j < 3; j++) {
        // 格屏幕坐标 (a.java:21016-21031, +13 已并入 py)
        const cx = px + (i << 4) * m[0] + m[2];
        const cy = py + (j << 4) * m[1] + m[3];
        const line = orient === 0 || orient === 2 ? j : i;
        // 待机时原版保留的是 bu_40 的 9×9 地刺孔，bu_42 只属于攻击中的尖刺底层。
        if (phase < 0) {
          if (holes) {
            this.renderer.drawSpriteTransform(holes, 0, 0, 9, 9, cx + 3, cy + 3, 0);
            drawn = true;
          }
          continue;
        }

        // 排与帧判定 (a.java:21032-21082)
        let frame = -1;
        if (line === 0 && phase >= 0 && phase < 7) frame = phase;
        else if (line === 1 && phase > 3 && phase < 10) frame = phase - 3;
        else if (line === 2 && phase > 6 && phase < 12) frame = phase - 6;
        if (frame < 0) continue;
        // r() a.java:24522: bu_42 底座 @ (cx+4, cy-15)
        this.renderer.drawSpriteTransform(img42, 0, 0, 7, 23, cx + 4, cy - 15, 0);
        drawn = true;
        if (frame < 5 && img41) {
          // bu_41 刺帧 @ (cx+2, cy-18+z1148[帧])
          this.renderer.drawSpriteTransform(img41, frame * 9, 0, 9, 26, cx + 2, cy - 18 + TOWER_SPIKE_YOFF_Z1148[frame], 0);
        }
      }
    }
    return drawn;
  }

  /**
   * 烟火/寒冰/投石地基 (对应原版 s(int×3) 行24703 = t() 行25020 + u() 行25238)
   * t(): 等级<3 画 bu_18 地基帧 (N1149[等级] = [srcX,srcY,宽,高,dx,dy])
   * u(): 等级<2 画 bu_17 碎块 (m1150[等级] 表), 块索引 > 块数-3 时 transform=1 (水平翻转)
   */
  private renderGroundBase(x: number, y: number, level0: number, withPieces: boolean): boolean {
    let drawn = false;
    if (level0 >= 0 && level0 < 3) {
      const img = this.spr('bu', 18);
      const f = TOWER_GROUND_FRAME_N1149[level0];
      if (img && f) {
        this.renderer.drawSpriteTransform(img, f[0], f[1], f[2], f[3], x + f[4], y + f[5], 0);
        drawn = true;
      }
    }
    if (withPieces && level0 >= 0 && level0 < 2) {
      const img = this.spr('bu', 17);
      const pieces = TOWER_GROUND_PIECES_M1150[level0];
      if (img && pieces) {
        for (let pi = 0; pi < pieces.length; pi++) {
          const p = pieces[pi]; // [srcX,srcY,宽,高,dx,dy]
          const tr = pi > pieces.length - 3 ? 1 : 0;
          this.renderer.drawSpriteTransform(img, p[0], p[1], p[2], p[3], x + p[4], y + p[5], tr);
          drawn = true;
        }
      }
    }
    return drawn;
  }

  /**
   * 攻击打击点：使用攻击发生时记录的原版 entity[11]/[12] 世界坐标。
   */
  private strikePoint(tower: Tower, ax: number, ay: number): [number, number] {
    const type = this.spriteType(tower.type);
    const half = (TOWER_ANCHOR_O1098[type] ?? 2) << 3;
    const mapAnchorX = tower.x * TILE_SIZE + half;
    const mapAnchorY = tower.y * TILE_SIZE + half;
    return [tower.strikeX + (ax - mapAnchorX), tower.strikeY + (ay - mapAnchorY)];
  }

  /**
   * 烟火/寒冰辅助结构 (对应原版 a(int×8) 行10775, y() case 3/5 调用于 a.java:26480)
   * 基座偏移: 烟火 = J1144[min(等级,5)>>1], 寒冰 = (-5,-26)
   * 待机 (entity[10]==0): s() 地基 + 等级 2-3 中层件 (烟火 bu_22 / 寒冰 bu_26)
   *   + 等级 6+ 高杆 (bu_19/bu_23, 7x45) + 等级 7+ 顶件 (bu_21/bu_25, 15x15)
   * 攻击态 (entity[10]==1): 打击点立柱 (bu_20/bu_24, 12x41, srcX=等级*12) + 顶部 (15x15, srcX=等级*15)
   */
  private renderFireIceBase(
    tower: Tower,
    px: number,
    py: number,
    ax: number,
    ay: number,
    level0: number,
    phase: number,
    actionFrame: number,
  ): boolean {
    const type = this.spriteType(tower.type);
    const isWarmVariant = type === 3;
    const [dx, dy] = isWarmVariant ? TOWER_LOG_BASE_OFF_J1144[Math.min(level0, 5) >> 1] : [-5, -26] as [number, number];

    if (phase === 0) {
      let drawn = this.renderGroundBase(px + dx, py + dy, actionFrame, true);
      if (actionFrame > 1 && actionFrame < 4) {
        if (isWarmVariant) {
          const img = this.spr('bu', 22);
          if (img) {
            this.renderer.drawSpriteTransform(
              img, (actionFrame - 2) * 16, 0, 16, 16, px + dx + 21, py + dy + 16, 0,
            );
            drawn = true;
          }
        } else {
          const img = this.spr('bu', 26);
          if (img) {
            this.renderer.drawSpriteTransform(
              img, (actionFrame - 2) * 12, 0, 12, 17, px + dx + 24, py + dy + 23, 0,
            );
            drawn = true;
          }
        }
      }
      if (actionFrame > 5) {
        const pole = this.spr('bu', isWarmVariant ? 19 : 23);
        if (pole && (actionFrame - 6) * 7 < pole.width) {
          this.renderer.drawSpriteTransform(
            pole, (actionFrame - 6) * 7, 0, 7, 45, px + dx + 26, py + dy - 31, 0,
          );
          drawn = true;
        }
        if (actionFrame > 6) {
          const top = this.spr('bu', isWarmVariant ? 21 : 25);
          if (top && (actionFrame - 7) * 15 < top.width) {
            this.renderer.drawSpriteTransform(
              top, (actionFrame - 7) * 15, 0, 15, 15, px + dx + 22, py + dy - 52, 0,
            );
            drawn = true;
          }
        }
      }
      return drawn;
    }

    const [sx, sy] = this.strikePoint(tower, ax, ay);
    let drawn = false;
    const pole = this.spr('bu', isWarmVariant ? 20 : 24);
    if (pole && actionFrame * 12 < pole.width) {
      this.renderer.drawSpriteTransform(pole, actionFrame * 12, 0, 12, 41, sx, sy, 0);
      drawn = true;
    }
    const top = this.spr('bu', isWarmVariant ? 21 : 25);
    if (top && actionFrame * 15 < top.width) {
      this.renderer.drawSpriteTransform(top, actionFrame * 15, 0, 15, 15, sx, sy - 15, 0);
      drawn = true;
    }
    return drawn;
  }

  /**
   * 投石辅助结构 (对应原版 b(int×8) 行16166, y() case 7 调用于 a.java:26530)
   * 基座偏移 = K1145[min(等级,5)>>1]
   * 待机 (entity[10]==0): t() 地基 (无 u()) + 等级 3-5 bu_22 (16x16, srcX=(等级&1)*16)
   *   + 等级 6: bu_29 src(0,18,16x31); 等级 6-8: bu_27 (21x17); 等级 7+: bu_28 (29x22)
   * 攻击态 (entity[10]==1): 等级<3 → bu_29 (L1146帧, transform=2) + bu_28;
   *   等级>=3 → b(Image,int×4) 行16447 (bu_30 H1140 七点 + 旗帜)
   */
  private renderCatapultBase(
    tower: Tower,
    px: number,
    py: number,
    ax: number,
    ay: number,
    level0: number,
    phase: number,
    actionFrame: number,
  ): boolean {
    const [dx, dy] = TOWER_BOIL_BASE_OFF_K1145[Math.min(level0, 5) >> 1]; // a.java:16174-16181

    if (phase === 0) {
      let drawn = this.renderGroundBase(px + dx, py + dy, actionFrame, false);
      if (actionFrame > 2 && actionFrame < 6) {
        const img = this.spr('bu', 22);
        if (img) {
          this.renderer.drawSpriteTransform(
            img, (actionFrame & 1) * 16, 0, 16, 16, px + dx + 21, py + dy + 15, 0,
          );
          drawn = true;
        }
      }
      if (actionFrame >= 6) {
        if (actionFrame === 6) {
          const img = this.spr('bu', 29);
          if (img) {
            this.renderer.drawSpriteTransform(img, 0, 18, 16, 31, px + dx + 21, py + dy - 15, 0);
            drawn = true;
          }
        }
        if (actionFrame < 9) {
          const img = this.spr('bu', 27);
          if (img) {
            this.renderer.drawSpriteTransform(
              img, (actionFrame - 6) * 21, 0, 21, 17, px + dx + 21, py + dy + 10, 0,
            );
            drawn = true;
          }
        }
        if (actionFrame > 6) {
          const img = this.spr('bu', 28);
          if (img && (actionFrame - 7) * 29 < img.width) {
            this.renderer.drawSpriteTransform(
              img, (actionFrame - 7) * 29, 0, 29, 22, px + dx + 14, py + dy - 30, 0,
            );
            drawn = true;
          }
        }
      }
      return drawn;
    }

    const [sx, sy] = this.strikePoint(tower, ax, ay);
    if (actionFrame < 3) {
      let drawn = false;
      const f = TOWER_BOIL_ANIM_L1146[actionFrame];
      const img29 = this.spr('bu', 29);
      if (img29 && f) {
        this.renderer.drawSpriteTransform(img29, 0, f[1], f[2], f[3], sx, sy + f[0], 2);
        drawn = true;
      }
      const img28 = this.spr('bu', 28);
      if (img28 && actionFrame * 29 < img28.width) {
        this.renderer.drawSpriteTransform(
          img28, actionFrame * 29, 0, 29, 22, sx, sy + TOWER_BOIL_ANIM_L1146[0][0], 0,
        );
        drawn = true;
      }
      return drawn;
    }
    return this.renderH1140Points(this.spr('bu', 30), sx + 10, sy + 40, actionFrame - 3);
  }

  /**
   * 沸水/滚油液体装置基座 (对应原版 a(Image×3,int×4) 行11632, y() case 8/9 调用于 a.java:26542/26565)
   * 仅等级<3 绘制; 偏移 = M1147[朝向]
   * 朝向0: imgs[0] (14x33帧, srcX=等级*14); 朝向1: imgs[2] (50x12帧, srcX=(2-等级)*50, transform=1)
   * 朝向2: imgs[1] (13x52帧, srcX=等级*13); 朝向3: imgs[2] (50x12帧, srcX=等级*50)
   */
  private renderLiquidBase(tower: Tower, px: number, py: number, actionFrame: number, imgs: [number, number, number]): boolean {
    if (actionFrame < 0 || actionFrame >= 3) return false;
    const o = tower.orientation & 3;
    const dx = px + TOWER_FOUNTAIN_OFF_M1147[o][0]; // a.java:11633
    const dy = py + TOWER_FOUNTAIN_OFF_M1147[o][1]; // a.java:11637 (+13 已并入 py)
    let img: HTMLImageElement | null = null;
    let sx = 0;
    let sw = 0;
    let sh = 0;
    let tr = 0;
    switch (o) {
      case 0: img = this.spr('bu', imgs[0]); sx = actionFrame * 14; sw = 14; sh = 33; break;
      case 1: img = this.spr('bu', imgs[2]); sx = (2 - actionFrame) * 50; sw = 50; sh = 12; tr = 1; break;
      case 2: img = this.spr('bu', imgs[1]); sx = actionFrame * 13; sw = 13; sh = 52; break;
      case 3: img = this.spr('bu', imgs[2]); sx = actionFrame * 50; sw = 50; sh = 12; break;
    }
    if (!img) return false;
    this.renderer.drawSpriteTransform(img, sx, 0, sw, sh, dx, dy, tr);
    return true;
  }

  /**
   * 滚油攻击态油渍 (对应原版 h(int×5) 行21857, y() case 9 的 entity[10]!=0 分支)
   * bu_39 (15x29帧, 帧=(a1019&3), H5 用 tower.frame&3); 格 Y 额外 -16 (a.java:21935)
   * 原版按 m(entity[2],entity[3]) 判定画满 3×3 或单排：蜀国终阶（原版等级6）
   * 为完整 3×3，其余朝向 0/2 → 中间一行，朝向 1/3 → 中间一列。
   */
  private renderOilSpread(tower: Tower, px: number, py: number): boolean {
    const orient = tower.orientation & 3;
    const m = TOWER_DIR_SPREAD_M1084[orient];
    const img = this.spr('bu', 39);
    if (!img) return false;
    const frame = (tower.frame & 3) * 15;
    const originalLevel = tower.level - 1;
    const fullSpread = this.faction === 0 && originalLevel === 6;
    const rows = fullSpread || orient === 1 || orient === 3 ? [0, 1, 2] : [1];
    const cols = fullSpread || orient === 0 || orient === 2 ? [0, 1, 2] : [1];
    let drawn = false;
    for (const r of rows) {
      for (const c of cols) {
        const cx = px + (r << 4) * m[0] + m[2];
        const cy = py + (c << 4) * m[1] + m[3] - 16;
        this.renderer.drawSpriteTransform(img, frame, 0, 15, 29, cx, cy, 0);
        drawn = true;
      }
    }
    return drawn;
  }

  /**
   * 装置基座 (对应原版 y() case 10, a.java:26600-26681)
   * 原版仅 entity[10]==2 时绘制；H5以 attackAnim>0 对应动作状态。
   * 基准 = F1137[朝向] + 实体坐标:
   *   塔身 E1136 九点 bu_47 (14x19帧, srcX=等级*14)
   *   旗帜 G1138 四点 p(int×3) (ui_20, 27x29帧)
   */
  private renderGateActiveLayer(tower: Tower, px: number, py: number, actionFrame: number): boolean {
    const o = tower.orientation & 3;
    const [fx, fy] = TOWER_DEVICE_ORIENT_F1137[o];
    let drawn = false;
    const body = this.spr('bu', 47);
    if (body && actionFrame >= 0 && actionFrame < 6) {
      for (const e of TOWER_DEVICE_BODY_E1136) {
        this.renderer.drawSpriteTransform(
          body, actionFrame * 14, 0, 14, 19, px + fx + e[0], py + fy + e[1], 0,
        );
        drawn = true;
      }
    }
    if (actionFrame >= 0 && actionFrame < 9) {
      for (const g of TOWER_DEVICE_FLAG_G1138) {
        this.renderFlag(px + fx + g[0], py + fy + g[1], actionFrame);
        drawn = true;
      }
    }
    return drawn;
  }

  /**
   * 原版 d(int×6) 的常驻机件/环境层，与 y(int) 的攻击过程层相互独立。
   * 类型2/3/5/8/9持续绘制；类型0/4仅在原版 state==6（无敌人待机）时绘制。
   */
  private renderAmbientAnim(tower: Tower, px: number, py: number): boolean {
    const type = this.spriteType(tower.type); // 弓手塔19→原版塔0 (t0动画)
    const arrowDormantLayer = (type === 0 || type === 4) && tower.attackState === 6;
    if (!arrowDormantLayer && !TOWER_AMBIENT_LAYER_TYPES.includes(type)) return false;
    const half = (TOWER_ANCHOR_O1098[type] ?? 2) << 3;
    const ax = px + half;
    const ay = py + half;

    switch (type) {
      case 0:
      case 4: {
        // 原版: state==6 且 0<=朝向<=3 才画
        const o = tower.orientation;
        const img = this.spr('t0', o + 1);
        if (!img) return false;
        const w = TOWER_ORIENT_Y1125[o * 4 + 2];
        const h = TOWER_ORIENT_Y1125[o * 4 + 3];
        // 注意: 原版此处序列硬编码用 w1123[0] (类型4 同样适用)
        const anim = TOWER_ANIM_W1123[0][tower.frame] ?? 0;
        // 原版: 朝向0时 srcX=0, 否则 srcX = 帧宽 * 序列值
        const srcX = o === 0 ? 0 : w * anim;
        const dx = ax + TOWER_ORIENT_Y1125[o * 4];
        const dy = ay + TOWER_ORIENT_Y1125[o * 4 + 1];
        this.renderer.drawSpriteTransform(img, srcX, 0, w, h, dx, dy, 0);
        // 原版: 3<=帧<10 时叠画 t0_5
        if (tower.frame >= 3 && tower.frame < 10) {
          const overlay = this.spr('t0', 5);
          if (overlay) {
            const oy = ay + TOWER_ORIENT_Y1125[o * 4 + 1] - overlay.height - anim;
            this.renderer.drawSpriteTransform(overlay, 0, 0, overlay.width, overlay.height, dx + 2, oy, 0);
          }
        }
        return true;
      }
      case 2: {
        const img = this.spr('t2', 1);
        if (!img) return false;
        return this.renderMultiPoint(img, TOWER_ANIM_W1123[type], tower.frame, type, ax, ay);
      }
      case 3:
      case 9: {
        const img = this.spr(`t${type}`, 1);
        if (!img) return false;
        return this.renderMultiPoint(img, TOWER_ANIM_W1123[type], tower.frame, type, ax, ay);
      }
      case 5:
      case 8: {
        let drawn = false;
        const img1 = this.spr(`t${type}`, 1);
        if (img1) {
          drawn = this.renderMultiPoint(img1, TOWER_ANIM_W1123[type], tower.frame, type, ax, ay);
        }
        // 第二层: t{type}[2], 用 w1123[type-1] 序列与 i1122[type-1] 绘制点
        // 类型5 drawY 追加 x1124[帧] (寒冰逐帧Y偏移)
        const img2 = this.spr(`t${type}`, 2);
        if (img2) {
          const dyExtra = type === 5 ? (TOWER5_FRAME_YOFF_X1124[tower.frame] ?? 0) : 0;
          drawn = this.renderMultiPoint(img2, TOWER_ANIM_W1123[type - 1], tower.frame, type - 1, ax, ay + dyExtra) || drawn;
        }
        return drawn;
      }
      default:
        return false;
    }
  }

  /**
   * 多点绘制 (对应原版 a(Image,x,y,type,frame,len) 行11170)
   * srcX = w1123[pointType][帧] * 帧宽, 末2字节 = 帧宽/帧高; 各绘制点 (ax+dx, ay+dy)
   */
  private renderMultiPoint(
    img: HTMLImageElement,
    seq: number[],
    frame: number,
    pointType: number,
    ax: number,
    ay: number,
  ): boolean {
    if (!seq || seq.length < 3) return false;
    const fw = seq[seq.length - 2];
    const fh = seq[seq.length - 1];
    const srcX = (seq[frame] ?? 0) * fw;
    let drawn = false;
    for (const [dx, dy] of TOWER_DRAW_POINTS_I1122[pointType] ?? []) {
      this.renderer.drawSpriteTransform(img, srcX, 0, fw, fh, ax + dx, ay + dy, 0);
      drawn = true;
    }
    return drawn;
  }

  /**
   * 建造模式预览 (对应原版 am() case 1 行14719-14735, bF==1 建造选位)
   * 依次移植: e(bN,bO,bw,0) 范围圈 (行19320) → p(bN,bO) 逐格指示+角标 (行23898/24225)
   *   → i(bN,bO,fp,fp) 四角块 (行22126)
   * 另加 H5 增补: 塔幻影 (半透明基座)。可造状态统一绘制到底部信息条。
   */
  private renderBuildPreview(offsetX: number, offsetY: number): void {
    const type = this.spriteType(this.pendingBuildType); // 弓手塔19→原版塔0预览
    const fp = TOWER_ANCHOR_O1098[type] ?? 2; // o1098[bw], 占地边长(格)
    const bx = offsetX + this.buildX * TILE_SIZE; // 屏幕坐标 (含 +13, 对应 bN-bP / bO-bQ+13)
    const by = offsetY + this.buildY * TILE_SIZE;
    const vctx = this.renderer.virtualContext;

    // ---- e(int×4) 行19320: 攻击范围圈, 类型 0/1/3/4/5/7 画圆, 类型 2/6 不画
    if (type === 0 || type === 1 || type === 3 || type === 4 || type === 5 || type === 7) {
      // 范围 = t1103[type*2] + t1103[type*2+1]*等级 (a(int,byte[],int) 行10095), 待建等级=0
      const range = TOWER_RANGE_T1103[type * 2] ?? 0;
      const color = RANGE_CIRCLE_COLORS_L1116[this.mapLevel] ?? RANGE_CIRCLE_COLORS_L1116[0];
      vctx.save();
      this.renderer.setColor(color);
      vctx.beginPath();
      vctx.arc(bx + (fp << 3), by + (fp << 3), range, 0, Math.PI * 2);
      vctx.stroke();
      vctx.restore();
    }

    // ---- p(int,int) 行23898: 逐格 14x14 斜线格 (b(int×4,boolean) 行16316)
    // 可建 = 0x4CFFAC(5046188); 不可建 = q1158[帧&3] 闪烁; 占用格按不可建显示
    const directionOk = this.hasPathFacing(this.buildX, this.buildY, type);
    let allOk = directionOk;
    for (let i = 0; i < fp; i++) {
      for (let j = 0; j < fp; j++) {
        const tx = this.buildX + i;
        const ty = this.buildY + j;
        const ok = directionOk && this.mapData.isBuildableAt(tx, ty) && !this.towers.some(t => this.occupiesTile(t, tx, ty));
        if (!ok) allOk = false;
        const color = ok ? 0x4cffac : BUILD_BAD_COLORS_Q1158[this.previewFrame & 3];
        this.renderer.setColor(color);
        const rx = bx + (i << 4) + 1;
        const ry = by + (j << 4) + 1;
        vctx.save();
        vctx.beginPath();
        for (let k = 0; k < 14; k += 2) {
          vctx.moveTo(rx + k, ry);
          vctx.lineTo(rx + 14, ry + 14 - k);
          vctx.moveTo(rx, ry + k);
          vctx.lineTo(rx + 14 - k, ry + 14);
        }
        vctx.stroke();
        vctx.strokeRect(rx, ry, 14, 14);
        vctx.restore();
      }
    }

    // ---- q(int,int) 行24225: 全部可建 (x1126) 时画呼吸方向箭头 (ui_16, 10x12帧)
    // 四向建筑画满四边；单向机关只画实际建成后采用的道路朝向。
    if (allOk) {
      const arrow = this.spr('ui', 16);
      if (arrow) {
        const bounce = (this.previewFrame & 1) << 1; // 原版 (a1019&1)<<1
        const orientations = this.buildPreviewArrowOrientations(
          this.buildX,
          this.buildY,
          this.pendingBuildType,
        );
        for (const orientation of orientations) {
          const cx = bx + (fp << 3) + CURSOR_BRACKET_Q1159[orientation][0] * ((fp << 3) + 8 + bounce);
          const cy = by + (fp << 3) + CURSOR_BRACKET_Q1159[orientation][1] * ((fp << 3) + 8 + bounce);
          this.renderer.drawSpriteTransform(arrow, orientation * 10, 0, 10, 12, cx, cy, 0);
        }
      }
    }

    // ---- i(int×4) 行22126: 四角 7x7 角块 (ui_0 帧 k*7); 建造模式 (bF==1) 无箭头
    const corner = this.spr('ui', 0);
    if (corner) {
      for (let k = 0; k < 4; k++) {
        const cx = bx + ((fp << 4) - 7) * CURSOR_CORNER_O1156[k][0];
        const cy = by + ((fp << 4) - 7) * CURSOR_CORNER_O1156[k][1];
        this.renderer.drawSpriteTransform(corner, k * 7, 0, 7, 7, cx, cy, 0);
      }
    }

    // ---- 塔幻影 (H5 增补, 原版无): 半透明绘制待建塔基座
    const ghost: Tower = {
      x: this.buildX, y: this.buildY, type, level: 1,
      damage: 0, range: 0, fireRate: 0, cooldown: 0, target: -1, angle: 0,
      heroId: -1, effectType: 0, hp: 0, maxHp: 0, debuffTimer: 0,
      frame: 0, orientation: this.resolvePathFacing(this.buildX, this.buildY, type), attackAnim: 0,
      attackState: 0, attackPhase: 0, attackFrame: 0, volleyFrames: [], liquidPattern: 0,
      liquidIgnited: false,
      buildEffect: 0, buildEffectFrame: 0,
      strikeX: this.buildX * TILE_SIZE, strikeY: this.buildY * TILE_SIZE,
      gateLoaded: false, gateState: 0, gateTimer: 0,
    };
    vctx.save();
    vctx.globalAlpha = 0.55;
    this.renderModel(ghost, bx, by);
    vctx.restore();

  }

  /**
   * 获取塔列表
   */
  getTowers(): Tower[] {
    return this.towers;
  }

  getTowerByInstanceId(instanceId: number): Tower | undefined {
    return this.towers.find(tower => tower.instanceId === instanceId);
  }

  /**
   * 选择塔
   */
  selectTower(tileX: number, tileY: number): Tower | null {
    const tower = this.getTowerAt(tileX, tileY);
    this.selectedTower = tower ?? null;
    return this.selectedTower;
  }

  renderEnhancementEffects(offsetX: number = 0, offsetY: number = 0): void {
    if (!this.features.reactions || !this.reactions) return;
    const ctx = this.renderer.virtualContext;
    ctx.save();
    ctx.globalAlpha = 0.35;
    for (const zone of this.reactions.zones) {
      const x = offsetX + zone.tx * TILE_SIZE;
      const y = offsetY + zone.ty * TILE_SIZE;
      ctx.fillStyle = (this.previewFrame & 1) === 0 ? '#ff7a18' : '#ffc23d';
      ctx.fillRect(x, y, TILE_SIZE, TILE_SIZE);
      ctx.strokeStyle = '#ffef9a';
      ctx.strokeRect(x + 1, y + 1, TILE_SIZE - 2, TILE_SIZE - 2);
    }
    ctx.restore();
  }

  /** 查找光标覆盖的塔，但不改变确认选择状态。 */
  getTowerAt(tileX: number, tileY: number): Tower | null {
    return this.towers.find(t => this.occupiesTile(t, tileX, tileY)) ?? null;
  }

  /**
   * 在所有战场实体之后绘制建筑定位框。返回 false 表示该格没有塔，调用方应画普通 1 格框。
   */
  renderBuildingCursor(
    tileX: number,
    tileY: number,
    offsetX: number,
    offsetY: number,
    selected: boolean,
  ): boolean {
    const tower = this.getTowerAt(tileX, tileY);
    if (!tower) return false;
    const px = offsetX + tower.x * TILE_SIZE;
    const py = offsetY + tower.y * TILE_SIZE;
    this.renderSelectedTowerFrame(tower, px, py, selected && this.selectedTower === tower);
    return true;
  }

  /**
   * 沸水/滚油的道路液体层（原版 ai() 行14003 + b(Image,int×8) 行16479）。
   * 阶段0使用开启帧0..2，阶段1按道路格与随机偏移选择循环纹理2..4，阶段2使用关闭帧1..0。
   */
  private renderLiquidAttackSpread(tower: Tower, px: number, py: number): boolean {
    const type = this.spriteType(tower.type);
    const img = this.spr('bu', type === 8 ? 31 : 35);
    if (!img) return false;

    const orient = tower.orientation & 3;
    const spread = TOWER_DIR_SPREAD_M1084[orient];
    const fullSpread = this.faction === 0 && tower.level - 1 === 6;
    const rows = fullSpread || orient === 1 || orient === 3 ? [0, 1, 2] : [1];
    const cols = fullSpread || orient === 0 || orient === 2 ? [0, 1, 2] : [1];
    for (const row of rows) {
      for (const col of cols) {
        let frame: number;
        if (tower.attackPhase === 0) {
          frame = Math.min(2, tower.attackFrame);
        } else if (tower.attackPhase === 1) {
          const axisIndex = orient === 0 || orient === 2 ? col : row;
          frame = (axisIndex + tower.liquidPattern) % 3 + 2;
        } else {
          frame = Math.max(0, 1 - tower.attackFrame);
        }
        const dx = px + (row << 4) * spread[0] + spread[2];
        const dy = py + (col << 4) * spread[1] + spread[3];
        this.renderer.drawSpriteTransform(img, frame * 16, 0, 16, 16, dx, dy, 0);
      }
    }
    return true;
  }

  /**
   * 获取建造位置
   */
  getBuildPosition(): { tx: number; ty: number } {
    return { tx: this.buildX, ty: this.buildY };
  }

  /**
   * 获取选中塔
   */
  getSelectedTower(): Tower | null {
    return this.selectedTower;
  }

  get hasSelectedTower(): boolean {
    return this.selectedTower !== null;
  }

  /**
   * 取消选择
   */
  deselectTower(): void {
    this.selectedTower = null;
  }

  /**
   * 获取塔配置
   */
  getTowerConfig(type: number) {
    return this.towerConfigs[type];
  }

  getTowerName(tower: Tower): string {
    return this.towerConfigs[this.spriteType(tower.type)]?.name ?? '建筑';
  }

  getTowerDisplayDamage(tower: Tower): number {
    return this.towerDamage(tower);
  }

  getHeroEffectDescription(tower: Tower): string {
    return tower.heroId >= 0 ? (HERO_EFFECT_DESCRIPTIONS[tower.heroId] ?? '') : '';
  }

  /**
   * 获取所有可建造的原版塔类型（0-10；装置升级链仍由科技解锁门禁控制）。
   */
  getBuildableTowerTypes(): number[] {
    return Object.keys(this.towerConfigs).map(Number).filter(t => t >= 0 && t <= 10);
  }

  /**
   * 根据ID获取武将名称
   */
  private getHeroName(heroId: number): string | null {
    // 从HEROES数组查找
    // 延迟导入避免循环依赖
    const hero = HEROES_MAP[heroId];
    return hero?.name ?? null;
  }

  /**
   * 重置塔系统 (新增方法)
   * 清空所有塔, 用于重新开始关卡
   */
  reset(): void {
    this.towers = [];
    this.selectedTower = null;
    this.buildMode = false;
    this.buildX = 0;
    this.buildY = 0;
    this.nextTowerInstanceId = 1;
  }

  // ============================================================
  // 新增: 敌人攻击塔接口 (对应原版 checkEnemyAttack / helperV_1P)
  // ============================================================

  /**
   * 对塔造成伤害 (新增方法)
   * 对应原版 helperV_1P 中塔HP递减逻辑
   * @param tower 目标塔
   * @param damage 伤害值
   * @returns 塔是否被摧毁
   */
  damageTower(tower: Tower, damage: number): boolean {
    // debuff 期间受到双倍伤害 (对应原版 var16[15]=48)
    const actualDamage = tower.debuffTimer > 0 ? damage * 2 : damage;
    tower.hp -= actualDamage;
    if (tower.hp <= 0) {
      // 塔被摧毁
      const footprint = TOWER_FOOTPRINT_O1098[this.spriteType(tower.type)] ?? 1;
      for (let dx = 0; dx < footprint; dx++) {
        for (let dy = 0; dy < footprint; dy++) {
          this.mapData.releaseBuildTile(tower.x + dx, tower.y + dy);
        }
      }
      this.towers = this.towers.filter(t => t !== tower);
      if (this.selectedTower === tower) {
        this.selectedTower = null;
      }
      return true;
    }
    return false;
  }

  /**
   * 对塔施加 debuff (新增方法)
   * 对应原版 case 8,9 的 tower[15] = 48
   * @param tower 目标塔
   * @param duration debuff 持续时间 (帧)
   */
  applyDebuff(tower: Tower, duration: number = 48): void {
    tower.debuffTimer = Math.max(tower.debuffTimer, duration);
  }

  /**
   * 更新塔的 debuff 计时器 (新增方法)
   * 每帧调用
   */
  updateDebuffs(): void {
    for (const tower of this.towers) {
      if (tower.debuffTimer > 0) {
        tower.debuffTimer--;
      }
    }
  }

  /**
   * 获取指定位置附近的塔 (新增方法)
   * 用于敌人范围攻击
   * @param cx 中心X (像素)
   * @param cy 中心Y (像素)
   * @param range 搜索半径 (像素)
   * @returns 范围内的塔列表
   */
  getTowersInRange(cx: number, cy: number, range: number): Tower[] {
    const result: Tower[] = [];
    for (const tower of this.towers) {
      const fp = TOWER_FOOTPRINT_O1098[this.spriteType(tower.type)] ?? 1;
      const tx = tower.x * TILE_SIZE + (fp << 3);
      const ty = tower.y * TILE_SIZE + (fp << 3);
      const dist = Math.sqrt((tx - cx) ** 2 + (ty - cy) ** 2);
      if (dist <= range) {
        result.push(tower);
      }
    }
    return result;
  }

  /**
   * 从存档数据恢复塔布局 (新增方法)
   * 对应原版 RMS 读取 sanGuoTdData 后的塔状态恢复
   */
  restoreFromSave(towersData: any[]): void {
    this.towers = [];
    if (!Array.isArray(towersData)) return;
    for (const td of towersData) {
      const config = this.towerConfigs[td.type];
      if (!config) continue;
      const maxHp = td.maxHp ?? (100 + config.cost);
      const level = Math.max(1, Math.min(7, td.level ?? 1));
      const stats = this.originalStats(td.type ?? 0, level);
      const tower: Tower = {
        instanceId: Number.isFinite(td.instanceId) ? Math.max(1, td.instanceId | 0) : this.nextTowerInstanceId++,
        x: td.x ?? 0,
        y: td.y ?? 0,
        type: td.type ?? 0,
        level,
        // 旧存档可能保存过乘法成长后的错误属性；读取时按原版公式重新计算。
        damage: stats.damage,
        range: stats.range,
        fireRate: stats.fireRate,
        cooldown: 0,
        target: -1,
        angle: 0,
        heroId: td.heroId ?? -1,
        effectType: td.effectType ?? config.effect,
        buildCostPaid: Number.isFinite(td.buildCostPaid) ? Math.max(0, Math.floor(td.buildCostPaid)) : undefined,
        // 新增: 恢复建筑血量
        hp: td.hp ?? maxHp,
        maxHp,
        debuffTimer: 0,
        // 动画状态 (不存档, 按初始值)
        frame: 0,
        orientation: Number.isInteger(td.orientation)
          ? (td.orientation & 3)
          : this.resolvePathFacing(td.x ?? 0, td.y ?? 0, td.type ?? 0),
        attackAnim: 0,
        attackState: 0,
        attackPhase: 0,
        attackFrame: 0,
        volleyFrames: [],
        liquidPattern: 0,
        liquidIgnited: false,
        buildEffect: 0,
        buildEffectFrame: 0,
        strikeX: (td.x ?? 0) * TILE_SIZE,
        strikeY: (td.y ?? 0) * TILE_SIZE,
        gateLoaded: td.gateLoaded === true,
        // 旧版曾把释放完成错误地保存为 3（永久“已使用”）；原版完成后会回到待命，可再次装填。
        gateState: td.gateState === 3 ? 0 : Math.max(0, Math.min(2, td.gateState ?? 0)),
        gateTimer: 0,
        attackSequence: Math.max(0, td.attackSequence ?? 0),
      };
      this.towers.push(tower);
      this.nextTowerInstanceId = Math.max(this.nextTowerInstanceId, (tower.instanceId ?? 0) + 1);
      const footprint = TOWER_FOOTPRINT_O1098[this.spriteType(tower.type)] ?? 1;
      for (let dx = 0; dx < footprint; dx++) {
        for (let dy = 0; dy < footprint; dy++) {
          this.mapData.occupyBuildTile(tower.x + dx, tower.y + dy);
        }
      }
    }
  }

  /** 断龙闸原版状态1持续5帧、状态2持续10帧，落闸时写入 D1162 并结算一次伤害。 */
  private updateGate(tower: Tower, enemies: Enemy[]): void {
    if (tower.gateState === 1) {
      tower.gateTimer++;
      tower.attackFrame = tower.gateTimer;
      if (tower.gateTimer <= 4) return;

      tower.gateState = 2;
      tower.gateTimer = 0;
      tower.attackPhase = 2;
      tower.attackFrame = 0;
      tower.attackAnim = 10;
      const cells = this.projectedDeviceCells(tower.x, tower.y, tower.orientation)
        .filter(cell => this.mapData.getTerrain(cell.tx, cell.ty) < 8);
      const cellKeys = new Set(cells.map(cell => `${cell.tx},${cell.ty}`));
      // 原版 k(type, level)：魏国终阶断龙闸写入 46，其余写入 16，决定石阵可阻挡多久。
      const defenseStrength = this.faction === 1 && tower.level - 1 === 6 ? 46 : 16;
      for (const cell of cells) this.mapData.setPathDefense(cell.tx, cell.ty, defenseStrength);

      for (const enemy of enemies) {
        if (!this.isLivingEnemy(enemy) || enemy.state === EnemyState.SIEGE) continue;
        if (!cellKeys.has(`${enemy.x >> 4},${enemy.y >> 4}`)) continue;
        this.damageEnemy(tower, enemy);
      }
    } else if (tower.gateState === 2) {
      tower.gateTimer++;
      tower.attackFrame = tower.gateTimer;
      if (tower.gateTimer > 9) {
        // 原版 ah() 会把动作状态恢复为 0；道路上的 3×3 石阵由 D1162 独立保留。
        tower.gateState = 0;
        tower.gateTimer = 0;
        tower.attackAnim = 0;
        tower.attackState = 0;
        tower.attackPhase = 0;
        tower.attackFrame = 0;
      }
    }
  }
}
