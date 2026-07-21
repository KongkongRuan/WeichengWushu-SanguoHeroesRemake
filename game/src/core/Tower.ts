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
  TOWER_GROUND_FRAME_N1149, TOWER_GROUND_PIECES_M1150,
  TOWER_LOG_BASE_OFF_J1144, TOWER_BOIL_BASE_OFF_K1145, TOWER_BOIL_ANIM_L1146,
  TOWER_FOUNTAIN_OFF_M1147, TOWER_DEVICE_POINTS_H1140,
  TOWER_DEVICE_BODY_E1136, TOWER_DEVICE_ORIENT_F1137, TOWER_DEVICE_FLAG_G1138,
  TOWER_RANGE_T1103, RANGE_CIRCLE_COLORS_L1116, BUILD_BAD_COLORS_Q1158,
  CURSOR_CORNER_O1156, CURSOR_BRACKET_Q1159,
  TOWER_FOOTPRINT_O1098,
  TOWER_DIRECTION_P1099,
} from '../data/gameData';
import { TOWER_NAMES, TOWER_DESCRIPTIONS, HEROES, Hero } from '../data/heroes';
import type { TechTreeSystem } from './TechTree';
import { linearLevelValue } from './Timing';

// 武将ID到武将对象的映射 (避免循环依赖, 在模块加载时构建)
const HEROES_MAP: Record<number, Hero> = {};
HEROES.forEach(h => { HEROES_MAP[h.id] = h; });

// 攻击状态持续逻辑帧数 (10FPS节拍; 原版 c1107[4]==6 攻击态, H5用计时近似)
const TOWER_ATTACK_ANIM_TICKS = 14;

export interface Tower {
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
  // ====== 新增: 建筑血量 (对应原版 b1066 塔HP数据) ======
  hp: number;         // 当前血量
  maxHp: number;      // 最大血量
  // debuff 计时器 (对应原版 var16[15]=48)
  debuffTimer: number;
  // ====== 动画状态 (对应原版实体字段) ======
  frame: number;       // 动画帧 (对应原版 entity[7], 按 w1123[type] 序列推进)
  orientation: number; // 朝向 0=上 1=右 2=下 3=左 (对应原版 entity[5])
  attackAnim: number;  // 攻击状态剩余逻辑帧 (>0 即攻击态, 对应原版 entity[4]==6)
  strikeX: number;      // 原版 entity[11]：最近一次攻击的地图像素 X
  strikeY: number;      // 原版 entity[12]：最近一次攻击的地图像素 Y
  gateLoaded: boolean;   // 断龙闸 entity[15]：是否已经装填石块
  gateState: number;     // 断龙闸 entity[10]：0待命 1释放中 2落闸 3已使用
  gateTimer: number;     // 断龙闸动作计时，对应 entity[13]
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
  // 精灵图缓存 (避免 getByPrefix 每帧线性查找)
  private spriteCache: Map<string, HTMLImageElement | null> = new Map();

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

  /** 方向机关投射到建筑外侧的 3x3 格（原版 m1084）。 */
  private projectedDeviceCells(tileX: number, tileY: number, orientation: number): { tx: number; ty: number }[] {
    const spread = TOWER_DIR_SPREAD_M1084[orientation & 3];
    const result: { tx: number; ty: number }[] = [];
    const seen = new Set<string>();
    for (let i = 0; i < 3; i++) {
      for (let j = 0; j < 3; j++) {
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
    if (TOWER_DIRECTION_P1099[this.spriteType(type)] !== 1) return 0;
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
   * 放置塔
   * 任务B-3: 接入原版科技建筑门禁 (e1105), 未解锁禁止建造 (原版 M() case 0 行8373-8389)
   * 任务A: 建造费改用原版 q1100 (经 buildCostProvider), 与建造栏显示价格一致
   */
  placeTower(tileX: number, tileY: number, type: number): boolean {
    const footprint = TOWER_FOOTPRINT_O1098[this.spriteType(type)] ?? 1;
    // 原版塔按 2x2/3x3 占地，不能只检查锚点一格。
    if (!this.isPlacementAreaClear(tileX, tileY, type)) return false;

    const config = this.towerConfigs[type];
    if (!config) return false;

    // 原版科技建筑解锁门禁 (e1105): 未解锁返回false (提示由 UI 层给 b1015[115])
    if (this.buildUnlockCheck && !this.buildUnlockCheck(type)) return false;

    // 原版建造费 (q1100) 优先, 否则用 towerConfigs; 装填半价科技效果保留
    const baseCost = this.buildCostProvider?.(type) ?? config.cost;
    const actualCost = this.techTree?.isReloadHalf() ? Math.floor(baseCost / 2) : baseCost;
    if (this.gold < actualCost) return false;

    const stats = this.originalStats(type, 1);
    const tower: Tower = {
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
      // 新增: 初始化建筑血量 (基于塔类型和费用)
      hp: 100 + config.cost,
      maxHp: 100 + config.cost,
      debuffTimer: 0,
      // 动画状态初始化 (对应原版 c(int×4) 行17252: entity[7]=0, entity[5]=aA)
      frame: 0,
      orientation: this.resolvePathFacing(tileX, tileY, type),
      attackAnim: 0,
      strikeX: tileX * TILE_SIZE,
      strikeY: tileY * TILE_SIZE,
      gateLoaded: false,
      gateState: 0,
      gateTimer: 0,
    };

    this.towers.push(tower);
    for (let dx = 0; dx < footprint; dx++) {
      for (let dy = 0; dy < footprint; dy++) {
        this.mapData.occupyBuildTile(tileX + dx, tileY + dy);
      }
    }
    this.gold -= actualCost;
    this.onGoldSpent?.(actualCost);
    return true;
  }

  /**
   * 升级塔 - 集成科技树系统
   * 还原原版 j(I I I)V 升级逻辑
   * 所有原版塔都走 TechTree 的 r1101 升级费用公式。
   */
  upgradeTower(tower: Tower): boolean {
    // 使用科技树系统检查是否可升级
    if (this.techTree) {
      const check = this.techTree.canUpgradeTech(tower);
      if (!check.canUpgrade) return false;

      const result = this.techTree.upgradeTech(tower);
      if (!result.success) return false;

      // 原版属性不是乘法成长，而是各自数组的“基础值 + 每级增量”。
      tower.level++;
      this.applyOriginalStats(tower);

      // 检查武将觉醒
      if (result.hero) {
        tower.heroId = result.hero.id;
        this.onHeroAwakened?.(result.hero, tower);
      }
      return true;
    }

    // 无科技树时的备用逻辑
    if (tower.level >= 6) return false;
    const [baseCost, stepCost] = TOWER_UPGRADE_COST_R1101[this.spriteType(tower.type)] ?? [50, 50];
    const cost = baseCost + stepCost * Math.max(0, tower.level - 1);
    if (this.gold < cost) return false;
    tower.level++;
    this.applyOriginalStats(tower);
    this.gold -= cost;
    this.onGoldSpent?.(cost);
    return true;
  }

  /**
   * 出售塔 (原版 b(int) 行15818: (建造费+升级投入)>>1; 经 demolishRefundProvider 注入原版公式)
   * onGoldSpent 以负数回调通知 Game 入账 (与 placeTower 扣费的正数回调对称)
   */
  sellTower(tower: Tower): void {
    const refund = this.demolishRefundProvider?.(tower)
      ?? Math.floor(this.towerConfigs[tower.type].cost * tower.level * 0.7);
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

  /** 检查一个塔的完整占地区域，供实际建造和移动预览共用。 */
  private isPlacementAreaClear(tileX: number, tileY: number, type: number): boolean {
    const footprint = TOWER_FOOTPRINT_O1098[this.spriteType(type)] ?? 1;
    for (let dx = 0; dx < footprint; dx++) {
      for (let dy = 0; dy < footprint; dy++) {
        const tx = tileX + dx;
        const ty = tileY + dy;
        if (!this.mapData.isBuildableAt(tx, ty)) return false;
        if (this.towers.some(t => this.occupiesTile(t, tx, ty))) return false;
      }
    }
    return this.hasPathFacing(tileX, tileY, type);
  }

  /** 断龙闸装填费用与当前等级的升级费用相同；装填减半科技生效时取一半。 */
  getGateLoadCost(tower: Tower): number | null {
    if (tower.type !== 10 || tower.gateLoaded || tower.gateState !== 0) return null;
    const [baseCost, stepCost] = TOWER_UPGRADE_COST_R1101[this.spriteType(tower.type)] ?? [50, 50];
    const fullCost = baseCost + stepCost * Math.max(0, tower.level - 1);
    return this.techTree?.isReloadHalf() ? fullCost >> 1 : fullCost;
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

  /** 原版动作19：断龙闸是手动、一次性机关，不进入通用自动索敌循环。 */
  releaseGate(tower: Tower): boolean {
    if (tower.type !== 10 || !tower.gateLoaded || tower.gateState !== 0) return false;
    tower.gateLoaded = false;
    tower.gateState = 1;
    tower.gateTimer = 0;
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
    // 新增: 更新 debuff 计时器
    this.updateDebuffs();

    // Game 已按原版 100ms 固定逻辑帧调用本方法，动画每次直接推进一次。
    this.tickAnim();

    // 获取全局科技加成
    const globalAtkBonus = this.techTree?.getGlobalAtkBonus() ?? 0;
    const globalFireRateBonus = this.techTree?.getGlobalFireRateBonus() ?? 0;

    for (const tower of this.towers) {
      // 断龙闸只响应底栏“释放断龙闸”，不能以 fireRate=0 进入通用自动攻击。
      if (tower.type === 10) {
        this.updateGate(tower, enemies);
        continue;
      }
      if (tower.cooldown > 0) {
        tower.cooldown--;
        continue;
      }

      // 查找目标。实体坐标是占地左上角，瞄准点与模型一样使用 o1098*8 的中心锚点。
      const renderType = this.spriteType(tower.type);
      const half = (TOWER_ANCHOR_O1098[renderType] ?? 2) << 3;
      const tx = offsetX + tower.x * TILE_SIZE + half;
      const ty = offsetY + tower.y * TILE_SIZE + half;
      // 突刺/擂木/断龙闸等近身机关在原版范围表中为 0，它们靠敌人进入机关
      // 占地附近触发；若直接把 0 交给通用距离索敌，攻击动画永远不会启动。
      const triggerRange = tower.range > 0 ? tower.range : half + TILE_SIZE;
      const directionalAttack = renderType === 2 || renderType === 6 || renderType === 8 || renderType === 9;
      const directionalCells = directionalAttack
        ? new Set(this.projectedDeviceCells(tower.x, tower.y, tower.orientation).map(cell => `${cell.tx},${cell.ty}`))
        : null;
      let closestDist = directionalAttack ? Number.POSITIVE_INFINITY : triggerRange;
      let targetIdx = -1;

      for (let i = 0; i < enemies.length; i++) {
        const enemy = enemies[i];
        // 跳过死亡动画/已结算敌人 (EnemyState.DYING=5 / SETTLE=6)
        if (enemy.state === EnemyState.DYING || enemy.state === EnemyState.SETTLE) continue;
        if (directionalCells && !directionalCells.has(`${enemy.x >> 4},${enemy.y >> 4}`)) continue;
        const ex = offsetX + enemy.x;
        const ey = offsetY + enemy.y;
        const dist = Math.sqrt((ex - tx) ** 2 + (ey - ty) ** 2);
        if (dist < closestDist) {
          closestDist = dist;
          targetIdx = i;
        }
      }

      if (targetIdx >= 0) {
        const target = enemies[targetIdx];
        const ex = offsetX + target.x;
        const ey = offsetY + target.y;
        tower.angle = Math.atan2(ey - ty, ex - tx);
        tower.target = targetIdx;
        tower.strikeX = target.x;
        tower.strikeY = target.y;

        // 计算实际伤害 (全局攻击加成 + 武将加成 + 科技效果)
        // 新增: 使用 TechTree 的 applyEffectsToTowerDamage 方法应用所有伤害相关科技
        let actualDamage = tower.damage;
        if (this.techTree) {
          actualDamage = this.techTree.applyEffectsToTowerDamage(tower, tower.damage);
          // 效果9: 周围塔增益
          const nearbyTowers = this.getNearbyTowers(tower, 64);
          const auraBonus = this.techTree.applyAuraBonus(tower, nearbyTowers);
          actualDamage = Math.floor(actualDamage * (1 + auraBonus));
        } else {
          // 退化方案: 仅使用全局加成
          actualDamage = tower.damage * (1 + globalAtkBonus);
        }
        if (tower.heroId >= 0) {
          actualDamage *= 1.5; // 武将觉醒后额外50%伤害
        }

        // 近身机关和范围装置按原版区域触发，同一逻辑帧可命中范围内多个敌人。
        const victims = directionalCells ? enemies.filter(enemy => {
          if (enemy.state === EnemyState.DYING || enemy.state === EnemyState.SETTLE) return false;
          return directionalCells.has(`${enemy.x >> 4},${enemy.y >> 4}`);
        }) : [target];

        for (const victim of victims) {
          victim.hp -= Math.floor(actualDamage);
          if (tower.effectType > 0) {
            this.applyTowerEffect(victim, tower.effectType, tower.level);
            if (this.techTree) {
              const attackTimeBonus = this.techTree.getAttackTimeBonus();
              if (attackTimeBonus > 0 && victim.timer > 0) {
                victim.timer = Math.floor(victim.timer * (1 + attackTimeBonus));
              }
            }
          }
          if (this.techTree) {
            this.techTree.applyAoeEffectsToEnemy(victim, tower.type, tower.level);
          }
        }

        // 攻速受全局加成影响
        const actualFireRate = Math.max(5, Math.floor(tower.fireRate * (1 - globalFireRateBonus)));
        tower.cooldown = actualFireRate;

        // 进入攻击状态 (对应原版 c1107[4]==6; H5简化: 按固定时长计时)
        tower.attackAnim = TOWER_ATTACK_ANIM_TICKS;
        // 朝向取瞄准方向 (原版 entity[5]; 石灰瓶/烟火会在动画回绕时随机, 见 tickAnim)
        if (TOWER_DIRECTION_P1099[renderType] !== 1) {
          tower.orientation = this.angleToOrientation(tower.angle);
        }
      } else {
        tower.target = -1;
      }
    }

    // 新增: 应用持续伤害效果 (中毒/火焰) 到所有活跃敌人
    if (this.techTree) {
      for (const enemy of enemies) {
        if (enemy.state === EnemyState.DYING || enemy.state === EnemyState.SETTLE) continue;
        this.techTree.applyDamageOverTime(enemy, 1);
      }
    }
  }

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
  private applyTowerEffect(enemy: Enemy, effectType: number, towerLevel: number): void {
    switch (effectType) {
      case 1: // 麻痹
        enemy.effect = 1;
        enemy.timer = Math.max(enemy.timer, towerLevel * 10);
        break;
      case 2: // 冰冻
        enemy.effect = 2;
        enemy.timer = Math.max(enemy.timer, towerLevel * 8);
        break;
      case 3: // 中毒
        enemy.effect = 3;
        enemy.timer = Math.max(enemy.timer, towerLevel * 10);
        enemy.hp -= towerLevel * 2;
        break;
      case 4: // 火焰
        enemy.effect = 4;
        enemy.timer = Math.max(enemy.timer, towerLevel * 8);
        enemy.hp -= towerLevel * 3;
        break;
      case 5: // 减速
        enemy.effect = 5;
        enemy.slowScale = Math.min(enemy.slowScale, 0.7);
        enemy.timer = Math.max(enemy.timer, towerLevel * 10);
        break;
      default:
        break;
    }
  }

  /**
   * 动画帧推进 (对应原版 ah() 行13890 + c(int×3) 行16946)
   * 每100ms逻辑帧: 帧+1 > w1123[type].length-3 时归零;
   * 类型0/4 (石灰瓶/烟火) 归零时朝向随机 (原版: entity[5] = rand & 3)
   */
  private tickAnim(): void {
    for (const tower of this.towers) {
      const st = this.spriteType(tower.type); // 弓手塔19→原版塔0动画序列
      const seq = TOWER_ANIM_W1123[st];
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
      if (tower.attackAnim > 0) {
        tower.attackAnim--;
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

      // 原版两层渲染 (对应 ag() 行13592): bu 基座层 (y(int) 行26281)
      // + t 攻击动画层 (d(int×6) 行18882); 删除原猜测公式 type*8+(level-1)*2
      let spriteDrawn = false;
      if (this.spriteLoader) {
        spriteDrawn = this.renderBase(tower, px, py);
        if (tower.type === 10) {
          spriteDrawn = this.renderGatePathStones(tower, offsetX, offsetY) || spriteDrawn;
        }
        // 原版主模型层：t{type}_0。此前遗漏该层，导致截图中的弓手塔/突刺
        // 只剩 bu 图集的攻击效果，外观完全不像原版。
        spriteDrawn = this.renderModel(tower, px, py) || spriteDrawn;
        spriteDrawn = this.renderAttackAnim(tower, px, py) || spriteDrawn;
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

      // 原版选中框按完整占地放大，范围圆心也位于建筑中心而非左上第一格。
      if (this.selectedTower === tower) {
        this.renderSelectedTowerFrame(tower, px, py);
      }
    }

    // 绘制建造预览 (对应原版 am() case 1 行14719: 范围圈+逐格指示+角标+塔幻影)
    if (this.buildMode) {
      this.renderBuildPreview(offsetX, offsetY);
    }
  }

  // ============================================================
  // 原版塔渲染: 基座层 + 攻击动画层
  // ============================================================

  /**
   * 绘制原版 t0_0..t10_0 主模型。
   * a.java 的 ag() 先画 y() 的 bu 效果层，再按 f1112/g1113/q1114
   * 拼出 t 图集主模型，最后才叠加攻击动画。
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
      this.renderer.drawSpriteTransform(img, rect[0], rect[1], rect[2], rect[3], ax + dx, ay + dy, 0);
      drawn = true;
    }
    return drawn;
  }

  /** 原版 am() case 0：四角框包裹完整占地，并以 10Hz 轻微向外呼吸。 */
  private renderSelectedTowerFrame(tower: Tower, px: number, py: number): void {
    const footprint = TOWER_FOOTPRINT_O1098[this.spriteType(tower.type)] ?? 1;
    const size = footprint << 4;
    const center = footprint << 3;
    if (tower.range > 0) {
      this.renderer.setColor(0xffffff);
      const ctx = this.renderer.virtualContext;
      ctx.beginPath();
      ctx.arc(px + center, py + center, tower.range, 0, Math.PI * 2);
      ctx.stroke();
    }

    const corner = this.spr('ui', 0);
    if (!corner) return;
    const pulse = (this.previewFrame & 1) << 1;
    const pulseDirs: [number, number][] = [[-1, -1], [1, -1], [1, 1], [-1, 1]];
    for (let k = 0; k < 4; k++) {
      const cx = px + (size - 7) * CURSOR_CORNER_O1156[k][0] + pulseDirs[k][0] * pulse;
      const cy = py + (size - 7) * CURSOR_CORNER_O1156[k][1] + pulseDirs[k][1] * pulse;
      this.renderer.drawSpriteTransform(corner, k * 7, 0, 7, 7, cx, cy, 0);
    }
  }

  /**
   * 原版对类型10额外使用 bu_43 绘制路径石块。这里显示装填后的朝向预告；
   * 释放后的持久石块由 MapData 的 D1162 路径机关层统一绘制。
   */
  private renderGatePathStones(tower: Tower, offsetX: number, offsetY: number): boolean {
    const stone = this.spr('bu', 43);
    if (!stone) return false;
    let drawn = false;
    for (const cell of this.projectedDeviceCells(tower.x, tower.y, tower.orientation)) {
      if (this.mapData.getTerrain(cell.tx, cell.ty) >= 8) continue;
      if (!tower.gateLoaded && tower.gateState !== 1) continue;
      this.renderer.drawSpriteTransform(
        stone,
        0, 0, 15, 16,
        offsetX + cell.tx * TILE_SIZE,
        offsetY + cell.ty * TILE_SIZE,
        0,
      );
      drawn = true;
    }
    return drawn;
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
      strikeX: 0, strikeY: 0,
      gateLoaded: false, gateState: 0, gateTimer: 0,
    };
    const half = (TOWER_ANCHOR_O1098[this.spriteType(type)] ?? 2) << 3;
    const px = centerX - half;
    const py = centerY - half;
    this.renderBase(ghost, px, py);
    this.renderModel(ghost, px, py);
  }

  /**
   * 塔基座层 (对应原版 y(int) 行26281, 按实体类型 entity[2] 分派)
   * 实体锚点 = 瓦片左上 + o1098[type]*8 (原版 entity[0]/[1] + o1098<<3)
   * 各 case 移植情况:
   *   0/4 瓶类 → renderBottleBase (a(Image,Image) 行11485)
   *   1 断龙闸 → renderGateBase (基座 bu_5 + 闸段 bu_7/尖端 bu_6, 高级 b(Image) 行16447)
   *   2 突刺   → renderSpikeBase (g(int×4) 行21008 + r(int×3) 行24522)
   *   3/5 擂木/投石 → renderLogStoneBase (a(int×8) 行10775)
   *   6 麻痹矢 → renderStakeBase (f(int×4) 行20267)
   *   7 沸水   → renderBoilBase (b(int×8) 行16166)
   *   8/9 寒冰/滚油 → renderFountainBase (a(Image×3) 行11632); 滚油攻击态 renderOilSpread (h(int×5) 行21857)
   *   10 装置 → renderDeviceBase (y() case 10 行26600)
   * 攻击态判定: 原版 entity[10]==0 为待机; H5 用 attackAnim>0 近似攻击态
   * @returns 是否画出了精灵
   */
  private renderBase(tower: Tower, px: number, py: number): boolean {
    const type = this.spriteType(tower.type); // 弓手塔19→原版塔0渲染路径
    const level0 = tower.level - 1; // 原版等级字段 entity[3] (0起)
    const half = (TOWER_ANCHOR_O1098[type] ?? 2) << 3;
    const ax = px + half;
    const ay = py + half;

    switch (type) {
      case 0: // 石灰瓶
      case 4: // 烟火
        return this.renderBottleBase(tower, ax, ay, level0);
      case 1: // 断龙闸
        return this.renderGateBase(tower, ax, ay, level0);
      case 2: // 突刺
        if (tower.attackAnim <= 0) return false;
        return this.renderSpikeBase(
          tower,
          px,
          py,
          Math.min(12, Math.max(0, TOWER_ATTACK_ANIM_TICKS - tower.attackAnim)),
        );
      case 3: // 擂木
      case 5: // 投石
        return this.renderLogStoneBase(tower, px, py, ax, ay, level0);
      case 6: // 麻痹矢
        return this.renderStakeBase(tower, ax, ay, level0);
      case 7: // 沸水
        return this.renderBoilBase(tower, px, py, ax, ay, level0);
      case 8: // 寒冰 (原版仅待机态 entity[10]==0 绘制, a.java:26543)
        if (tower.attackAnim > 0) return false;
        return this.renderFountainBase(tower, px, py, level0, [32, 33, 34]);
      case 9: // 滚油 (待机=喷泉基座; 攻击态=油渍, a.java:26565)
        if (tower.attackAnim > 0) return this.renderOilSpread(tower, px, py);
        return this.renderFountainBase(tower, px, py, level0, [36, 37, 38]);
      case 10: // 装置
        // 原版仅在断龙闸动作状态 entity[10]==2 时叠加九点闸墙效果。
        return tower.gateState === 2 && this.renderDeviceBase(tower, px, py, level0);
      default:
        return false;
    }
  }

  /**
   * 瓶类基座 (对应原版 a(Image,Image,int×5) 行11485; y() case 0/1/4)
   * 组: 0=石灰瓶(bu_2基座+bu_1球) 1=烟火(bu_4+bu_3球) 2=断龙闸(bu_5, 无球)
   * 原版仅等级 entity[13]<3 时绘制
   */
  private renderBottleBase(tower: Tower, ax: number, ay: number, level0: number): boolean {
    if (level0 < 0 || level0 >= 3) return false;
    const group = this.spriteType(tower.type) === 0 ? 0 : (tower.type === 4 ? 1 : 2);
    const baseImg = this.spr('bu', group === 0 ? 2 : (group === 1 ? 4 : 5));
    if (!baseImg) return false;

    const orient = tower.orientation & 3;
    const j = TOWER_BASE_OFFSETS_J1139[group];
    // 原版: 等级行 = (min(entity[3],5)>>1)+4; entity[3] 用 level0 近似
    const lvlRow = (Math.min(level0, 5) >> 1) + 4;
    const d = TOWER_LEVEL_FRAME_D1135[level0]; // [srcX, 帧宽, 偏移dx, 偏移dy]
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

    // 石灰瓶/烟火: 沿朝向画 5 个瓶球 (bu_1/bu_3, 9x9帧; 断龙闸无球)
    // 原版: 位置 = (bx+entity[11]*i, by+entity[12]*i), 帧 = C1134[entity][i]*9
    // H5简化: entity[11]/[12] 用朝向单位向量近似, 球帧按动画帧滚动
    if (tower.type !== 1) {
      const ballImg = this.spr('bu', tower.type === 0 ? 1 : 3);
      if (ballImg) {
        const dirX = [0, 1, 0, -1][orient];
        const dirY = [-1, 0, 1, 0][orient];
        for (let i = 0; i < 5; i++) {
          const ballFrame = (tower.frame + i) % 5;
          this.renderer.drawSpriteTransform(ballImg, ballFrame * 9, 0, 9, 9, bx + dirX * i, by + dirY * i, 0);
        }
      }
    }
    return true;
  }

  /**
   * 麻痹矢基座 (对应原版 f(int x,int y,int type,int level) 行20267)
   * 朝向外观 = tower.orientation (原版 entity[5]); 三表: I1142/k1141/l1143
   * 主件: 等级<3 时 bu[I1142[app][0]], srcX = 等级*帧宽, 偏移 k1141[等级][app]
   * 装饰件: 等级1-2 → 件0,1 (srcX=等级*帧宽); 等级3-5 → 件2,3 (srcX=(等级-3)*帧宽)
   */
  private renderStakeBase(tower: Tower, ax: number, ay: number, level0: number): boolean {
    const app = tower.orientation & 3;
    let drawn = false;

    if (level0 >= 0 && level0 < 3) {
      const main = TOWER_BASE_I1142[app]; // [bu图, transform, 帧宽, 帧高]
      const img = this.spr('bu', main[0]);
      if (img) {
        const dx = ax + TOWER_BASE_OFF_K1141[level0][app][0];
        const dy = ay + TOWER_BASE_OFF_K1141[level0][app][1];
        this.renderer.drawSpriteTransform(img, level0 * main[2], 0, main[2], main[3], dx, dy, main[1]);
        drawn = true;
      }
    }

    const pieces = level0 >= 1 && level0 <= 2 ? [0, 1] : (level0 >= 3 && level0 <= 5 ? [2, 3] : []);
    for (const pi of pieces) {
      const p = TOWER_DECOR_L1143[app][pi]; // [bu图, dx, dy, transform, 帧宽, 帧高]
      const img = this.spr('bu', p[0]);
      if (!img) continue;
      const srcX = (level0 <= 2 ? level0 : level0 - 3) * p[4];
      this.renderer.drawSpriteTransform(img, srcX, 0, p[4], p[5], ax + p[1], ay + p[2], p[3]);
      drawn = true;
    }
    return drawn;
  }

  /**
   * 断龙闸基座 (对应原版 y() case 1, a.java:26326-26471)
   * 等级<3: bu_5 基座 (a(Image,Image) 行11485, 无球);
   * 等级<4: 沿朝向画 level 段 bu_7 (10x10帧, srcX=段号*10) + 尖端 bu_6 (12x12帧, srcX=段号*12)
   * 等级>=4: b(Image,int×4) 行16447 — bu_8 按 H1140 七点绘制 + p() 旗帜
   * 朝向单位向量近似原版 entity[11]/[12] (与 renderBottleBase 瓶球同一简化)
   */
  private renderGateBase(tower: Tower, ax: number, ay: number, level0: number): boolean {
    const orient = tower.orientation & 3;
    const j = TOWER_BASE_OFFSETS_J1139[2]; // 组2=断龙闸
    const lvlRow = (Math.min(level0, 5) >> 1) + 4; // 原版 (min(entity[3],5)>>1)+4
    const offX = j[orient][0] + j[lvlRow][0]; // 原版 var18 (a.java:26347)
    const offY = j[orient][1] + j[lvlRow][1]; // 原版 var19 (a.java:26368, +13 已并入 ay)
    const dirX = [0, 1, 0, -1][orient];
    const dirY = [-1, 0, 1, 0][orient];
    let drawn = false;

    if (level0 < 4) {
      if (level0 < 3) {
        // bu_5 基座 (a.java:26395 调 a(Image,Image) 行11485, 第二张图为 null → 无球)
        drawn = this.renderBottleBase(tower, ax, ay, level0);
      }
      // 闸段循环 (a.java:26402-26457): i=1..等级 画 bu_7, i==等级 再画尖端 bu_6
      for (let i = 0; i <= level0; i++) {
        const sx = ax + offX + dirX * i;
        const sy = ay + offY + dirY * i;
        if (i > 0) {
          const seg = this.spr('bu', 7);
          if (seg) {
            this.renderer.drawSpriteTransform(seg, i * 10, 0, 10, 10, sx, sy, 0);
            drawn = true;
          }
        }
        if (i === level0) {
          const tip = this.spr('bu', 6);
          if (tip) {
            this.renderer.drawSpriteTransform(tip, i * 12, 0, 12, 12, sx, sy, 0);
            drawn = true;
          }
        }
      }
    } else {
      // 高级断龙闸 (a.java:26458-26469): b(Image,int×4) 行16447
      drawn = this.renderH1140Points(this.spr('bu', 8), ax + dirX * 4, ay + dirY * 4, level0 - 4);
    }
    return drawn;
  }

  /**
   * H1140 七点装饰 + p() 旗帜 (对应原版 b(Image,int×4) 行16447)
   * 各点: srcX = (H1140[i][2] + 等级增量)*16, 16x16 帧
   */
  private renderH1140Points(img: HTMLImageElement | null, x: number, y: number, lvl: number): boolean {
    if (!img) return false;
    for (const p of TOWER_DEVICE_POINTS_H1140) {
      this.renderer.drawSpriteTransform(img, (p[2] + lvl) * 16, 0, 16, 16, x + p[0], y + p[1], 0);
    }
    // p(int×3) 行23940: 旗帜 (a.java:16458, 位置 x-10, y-25)
    this.renderFlag(x - 10, y - 25, lvl);
    return true;
  }

  /**
   * 旗帜绘制 (对应原版 p(int×3) 行23940)
   * ui_20 图集 27x29 帧, srcX=等级*27; 等级0 时 x 不左移 4px
   * 注意: 原版 p() 屏幕 Y 不加 13 (与其他方法不同), 此处 -13 补偿
   */
  private renderFlag(x: number, y: number, lvl: number): void {
    const flag = this.spr('ui', 20);
    if (!flag) return;
    const frame = Math.min(Math.max(lvl, 0), 8); // ui_20 共 9 帧
    this.renderer.drawSpriteTransform(flag, frame * 27, 0, 27, 29, x - (lvl === 0 ? 0 : 4), y - 13, 0);
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
   * 擂木/投石地基 (对应原版 s(int×3) 行24703 = t() 行25020 + u() 行25238)
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
   * 擂木/投石基座 (对应原版 a(int×8) 行10775, y() case 3/5 调用于 a.java:26480)
   * 基座偏移: 擂木 = J1144[min(等级,5)>>1], 投石 = (-5,-26)
   * 待机 (entity[10]==0): s() 地基 + 等级 2-3 中层件 (擂木 bu_22 / 投石 bu_26)
   *   + 等级 6+ 高杆 (bu_19/bu_23, 7x45) + 等级 7+ 顶件 (bu_21/bu_25, 15x15)
   * 攻击态 (entity[10]==1): 打击点立柱 (bu_20/bu_24, 12x41, srcX=等级*12) + 顶部 (15x15, srcX=等级*15)
   */
  private renderLogStoneBase(tower: Tower, px: number, py: number, ax: number, ay: number, level0: number): boolean {
    const type = tower.type;
    const [dx, dy] = type === 3 ? TOWER_LOG_BASE_OFF_J1144[Math.min(level0, 5) >> 1] : [-5, -26] as [number, number];

    if (tower.attackAnim <= 0) {
      // 待机 state 0 (a.java:10868)
      let drawn = this.renderGroundBase(px + dx, py + dy, level0, true);
      if (level0 > 1 && level0 < 4) {
        // 等级 2-3 中层件 (a.java:10873-10911): 擂木 bu_22 (16x16, srcX=(等级-2)*16) @ +21,+16
        //   投石 bu_26 (12x17, srcX=(等级-2)*12) @ +24,+23
        if (type === 3) {
          const img = this.spr('bu', 22);
          if (img) {
            this.renderer.drawSpriteTransform(img, (level0 - 2) * 16, 0, 16, 16, px + dx + 21, py + dy + 16, 0);
            drawn = true;
          }
        } else {
          const img = this.spr('bu', 26);
          if (img) {
            this.renderer.drawSpriteTransform(img, (level0 - 2) * 12, 0, 12, 17, px + dx + 24, py + dy + 23, 0);
            drawn = true;
          }
        }
      }
      if (level0 > 5) {
        // 等级 6+ 高杆 (a.java:10913-10926): bu_19/bu_23 (7x45, srcX=(等级-6)*7) @ +26,-31
        const pole = this.spr('bu', type === 3 ? 19 : 23);
        if (pole) {
          this.renderer.drawSpriteTransform(pole, (level0 - 6) * 7, 0, 7, 45, px + dx + 26, py + dy - 31, 0);
          drawn = true;
        }
        if (level0 > 6) {
          // 等级 7+ 顶件 (a.java:10927-10941): bu_21/bu_25 (15x15, srcX=(等级-7)*15) @ +22,-52
          const top = this.spr('bu', type === 3 ? 21 : 25);
          if (top) {
            this.renderer.drawSpriteTransform(top, (level0 - 7) * 15, 0, 15, 15, px + dx + 22, py + dy - 52, 0);
            drawn = true;
          }
        }
      }
      return drawn;
    }

    // 攻击态 state 1 (a.java:10945-10963): 打击点立柱 + 顶部
    const [sx, sy] = this.strikePoint(tower, ax, ay);
    let drawn = false;
    const pole = this.spr('bu', type === 3 ? 20 : 24);
    if (pole) {
      this.renderer.drawSpriteTransform(pole, level0 * 12, 0, 12, 41, sx, sy, 0);
      drawn = true;
    }
    const top = this.spr('bu', type === 3 ? 21 : 25);
    if (top) {
      this.renderer.drawSpriteTransform(top, level0 * 15, 0, 15, 15, sx, sy - 15, 0);
      drawn = true;
    }
    return drawn;
  }

  /**
   * 沸水基座 (对应原版 b(int×8) 行16166, y() case 7 调用于 a.java:26530)
   * 基座偏移 = K1145[min(等级,5)>>1]
   * 待机 (entity[10]==0): t() 地基 (无 u()) + 等级 3-5 bu_22 (16x16, srcX=(等级&1)*16)
   *   + 等级 6: bu_29 src(0,18,16x31); 等级 6-8: bu_27 (21x17); 等级 7+: bu_28 (29x22)
   * 攻击态 (entity[10]==1): 等级<3 → bu_29 (L1146帧, transform=2) + bu_28;
   *   等级>=3 → b(Image,int×4) 行16447 (bu_30 H1140 七点 + 旗帜)
   */
  private renderBoilBase(tower: Tower, px: number, py: number, ax: number, ay: number, level0: number): boolean {
    const [dx, dy] = TOWER_BOIL_BASE_OFF_K1145[Math.min(level0, 5) >> 1]; // a.java:16174-16181

    if (tower.attackAnim <= 0) {
      // 待机 state 0 (a.java:16190)
      let drawn = this.renderGroundBase(px + dx, py + dy, level0, false);
      if (level0 > 2 && level0 < 6) {
        // a.java:16195-16209: bu_22 (16x16, srcX=(等级&1)<<4) @ +21,+15
        const img = this.spr('bu', 22);
        if (img) {
          this.renderer.drawSpriteTransform(img, (level0 & 1) * 16, 0, 16, 16, px + dx + 21, py + dy + 15, 0);
          drawn = true;
        }
      }
      if (level0 >= 6) {
        if (level0 === 6) {
          // a.java:16217-16229: bu_29 src(0,18) 16x31 @ +21,-15
          const img = this.spr('bu', 29);
          if (img) {
            this.renderer.drawSpriteTransform(img, 0, 18, 16, 31, px + dx + 21, py + dy - 15, 0);
            drawn = true;
          }
        }
        if (level0 < 9) {
          // a.java:16233-16247: bu_27 (21x17, srcX=(等级-6)*21) @ +21,+10
          const img = this.spr('bu', 27);
          if (img) {
            this.renderer.drawSpriteTransform(img, (level0 - 6) * 21, 0, 21, 17, px + dx + 21, py + dy + 10, 0);
            drawn = true;
          }
        }
        if (level0 > 6) {
          // a.java:16251-16264: bu_28 (29x22, srcX=(等级-7)*29) @ +14,-30
          const img = this.spr('bu', 28);
          if (img) {
            this.renderer.drawSpriteTransform(img, (level0 - 7) * 29, 0, 29, 22, px + dx + 14, py + dy - 30, 0);
            drawn = true;
          }
        }
      }
      return drawn;
    }

    // 攻击态 state 1 (a.java:16268)
    const [sx, sy] = this.strikePoint(tower, ax, ay);
    if (level0 < 3) {
      // a.java:16271-16301: bu_29 (L1146[等级]=[dy,srcY,宽,高], transform=2) + bu_28 (srcX=等级*29, dy=L1146[0][0])
      let drawn = false;
      const f = TOWER_BOIL_ANIM_L1146[level0];
      const img29 = this.spr('bu', 29);
      if (img29 && f) {
        this.renderer.drawSpriteTransform(img29, 0, f[1], f[2], f[3], sx, sy + f[0], 2);
        drawn = true;
      }
      const img28 = this.spr('bu', 28);
      if (img28) {
        this.renderer.drawSpriteTransform(img28, level0 * 29, 0, 29, 22, sx, sy + TOWER_BOIL_ANIM_L1146[0][0], 0);
        drawn = true;
      }
      return drawn;
    }
    // 等级>=3: b(Image,int×4) 行16447 (a.java:16302-16311, entity[8] 参数原版未参与定位)
    return this.renderH1140Points(this.spr('bu', 30), sx + 10, sy + 40, level0 - 3);
  }

  /**
   * 寒冰/滚油喷泉基座 (对应原版 a(Image×3,int×4) 行11632, y() case 8/9 调用于 a.java:26542/26565)
   * 仅等级<3 绘制; 偏移 = M1147[朝向]
   * 朝向0: imgs[0] (14x33帧, srcX=等级*14); 朝向1: imgs[2] (50x12帧, srcX=(2-等级)*50, transform=1)
   * 朝向2: imgs[1] (13x52帧, srcX=等级*13); 朝向3: imgs[2] (50x12帧, srcX=等级*50)
   */
  private renderFountainBase(tower: Tower, px: number, py: number, level0: number, imgs: [number, number, number]): boolean {
    if (level0 < 0 || level0 >= 3) return false;
    const o = tower.orientation & 3;
    const dx = px + TOWER_FOUNTAIN_OFF_M1147[o][0]; // a.java:11633
    const dy = py + TOWER_FOUNTAIN_OFF_M1147[o][1]; // a.java:11637 (+13 已并入 py)
    let img: HTMLImageElement | null = null;
    let sx = 0;
    let sw = 0;
    let sh = 0;
    let tr = 0;
    switch (o) {
      case 0: img = this.spr('bu', imgs[0]); sx = level0 * 14; sw = 14; sh = 33; break;
      case 1: img = this.spr('bu', imgs[2]); sx = (2 - level0) * 50; sw = 50; sh = 12; tr = 1; break;
      case 2: img = this.spr('bu', imgs[1]); sx = level0 * 13; sw = 13; sh = 52; break;
      case 3: img = this.spr('bu', imgs[2]); sx = level0 * 50; sw = 50; sh = 12; break;
    }
    if (!img) return false;
    this.renderer.drawSpriteTransform(img, sx, 0, sw, sh, dx, dy, tr);
    return true;
  }

  /**
   * 滚油攻击态油渍 (对应原版 h(int×5) 行21857, y() case 9 的 entity[10]!=0 分支)
   * bu_39 (15x29帧, 帧=(a1019&3), H5 用 tower.frame&3); 格 Y 额外 -16 (a.java:21935)
   * 原版按 m(entity[2],entity[3]) 判定画满 3×3 或单排; H5 简化为单排:
   *   朝向 0/2 → 中间一行 3 格; 朝向 1/3 → 中间一列 3 格 (a.java:21873-21896)
   */
  private renderOilSpread(tower: Tower, px: number, py: number): boolean {
    const orient = tower.orientation & 3;
    const m = TOWER_DIR_SPREAD_M1084[orient];
    const img = this.spr('bu', 39);
    if (!img) return false;
    const frame = (tower.frame & 3) * 15;
    const rows = orient === 0 || orient === 2 ? [1] : [0, 1, 2];
    const cols = orient === 0 || orient === 2 ? [0, 1, 2] : [1];
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
  private renderDeviceBase(tower: Tower, px: number, py: number, level0: number): boolean {
    const o = tower.orientation & 3;
    const [fx, fy] = TOWER_DEVICE_ORIENT_F1137[o];
    let drawn = false;
    const body = this.spr('bu', 47);
    if (body) {
      const frame = Math.min(Math.max(level0, 0), 5); // bu_47 共 6 帧
      for (const e of TOWER_DEVICE_BODY_E1136) {
        this.renderer.drawSpriteTransform(body, frame * 14, 0, 14, 19, px + fx + e[0], py + fy + e[1], 0);
        drawn = true;
      }
    }
    for (const g of TOWER_DEVICE_FLAG_G1138) {
      this.renderFlag(px + fx + g[0], py + fy + g[1], level0);
      drawn = true;
    }
    return drawn;
  }

  /**
   * 塔攻击动画层 (对应原版 d(int x,int y,int type,int frame,int orientation,int state) 行18882)
   * 类型0/4: 仅攻击态 (原版 state==6) 画 t0[朝向+1] (+帧3-9叠画 t0_5)
   * 类型2/3/9: t{type}[1] 常驻多点绘制; 类型5/8: 再叠 t{type}[2] (用 w1123[type-1])
   * 类型1/6/7: 无动画
   */
  private renderAttackAnim(tower: Tower, px: number, py: number): boolean {
    const type = this.spriteType(tower.type); // 弓手塔19→原版塔0 (t0动画)
    const half = (TOWER_ANCHOR_O1098[type] ?? 2) << 3;
    const ax = px + half;
    const ay = py + half;

    switch (type) {
      case 0:
      case 4: {
        // 原版: state==6 且 0<=朝向<=3 才画
        if (tower.attackAnim <= 0) return false;
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
        if (tower.attackAnim <= 0) return false;
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
        // 类型5 drawY 追加 x1124[帧] (投石逐帧Y偏移)
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

    // ---- q(int,int) 行24225: 全部可建 (x1126) 时画 4 个呼吸角标 (ui_16, 10x12帧)
    if (allOk) {
      const bracket = this.spr('ui', 16);
      if (bracket) {
        const bounce = (this.previewFrame & 1) << 1; // 原版 (a1019&1)<<1
        for (let k = 0; k < 4; k++) {
          const cx = bx + (fp << 3) + CURSOR_BRACKET_Q1159[k][0] * ((fp << 3) + 8 + bounce);
          const cy = by + (fp << 3) + CURSOR_BRACKET_Q1159[k][1] * ((fp << 3) + 8 + bounce);
          this.renderer.drawSpriteTransform(bracket, k * 10, 0, 10, 12, cx, cy, 0);
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
      strikeX: this.buildX * TILE_SIZE, strikeY: this.buildY * TILE_SIZE,
      gateLoaded: false, gateState: 0, gateTimer: 0,
    };
    vctx.save();
    vctx.globalAlpha = 0.55;
    this.renderBase(ghost, bx, by);
    this.renderModel(ghost, bx, by);
    vctx.restore();

  }

  /**
   * 获取塔列表
   */
  getTowers(): Tower[] {
    return this.towers;
  }

  /**
   * 选择塔
   */
  selectTower(tileX: number, tileY: number): Tower | null {
    const tower = this.towers.find(t => this.occupiesTile(t, tileX, tileY));
    this.selectedTower = tower ?? null;
    return this.selectedTower;
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
      const level = Math.max(1, Math.min(6, td.level ?? 1));
      const stats = this.originalStats(td.type ?? 0, level);
      const tower: Tower = {
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
        strikeX: (td.x ?? 0) * TILE_SIZE,
        strikeY: (td.y ?? 0) * TILE_SIZE,
        gateLoaded: td.gateLoaded === true,
        gateState: Math.max(0, Math.min(3, td.gateState ?? 0)),
        gateTimer: 0,
      };
      this.towers.push(tower);
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
      if (tower.gateTimer <= 4) return;

      tower.gateState = 2;
      tower.gateTimer = 0;
      tower.attackAnim = 10;
      const cells = this.projectedDeviceCells(tower.x, tower.y, tower.orientation)
        .filter(cell => this.mapData.getTerrain(cell.tx, cell.ty) < 8);
      const cellKeys = new Set(cells.map(cell => `${cell.tx},${cell.ty}`));
      for (const cell of cells) this.mapData.setPathDefense(cell.tx, cell.ty, 16);

      let damage = tower.damage;
      if (this.techTree) damage = this.techTree.applyEffectsToTowerDamage(tower, damage);
      if (tower.heroId >= 0) damage *= 1.5;
      for (const enemy of enemies) {
        if (enemy.state === EnemyState.DYING || enemy.state === EnemyState.SETTLE) continue;
        if (!cellKeys.has(`${enemy.x >> 4},${enemy.y >> 4}`)) continue;
        enemy.hp -= Math.floor(damage);
        this.techTree?.applyAoeEffectsToEnemy(enemy, tower.type, tower.level);
      }
    } else if (tower.gateState === 2) {
      tower.gateTimer++;
      if (tower.gateTimer > 9) {
        tower.gateState = 3;
        tower.gateTimer = 0;
        tower.attackAnim = 0;
      }
    }
  }
}
