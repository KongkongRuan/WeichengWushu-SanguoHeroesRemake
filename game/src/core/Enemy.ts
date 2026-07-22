/**
 * 敌人系统 - 敌人波次刷怪、沿属性层方向链移动、冲城
 * 100%还原原版 a.java 的战场核心逻辑:
 *
 *   逻辑节拍: 10FPS (100ms/逻辑帧, 原版 run() 字节码: G() 每100ms执行一次)
 *   每逻辑帧 = 原版 X() (行9224-9588):
 *     1. O()  波次推进 (行8518-8566, 消耗 p1078)
 *     2. l(1) 刷怪   (行22811-22948)
 *     3. 逐敌人状态机更新 (state 0走/4架炮/5死动画/6结算/7被堵/8冲城)
 *
 *   移动 (label117 + o(int) 行23725-23766):
 *     - 每逻辑帧 x += DIRECTIONS_K1081[dir][0]*speed; y += ...
 *     - 在格中心 (x%16==8 && y%16==8) 时按当前格 E1163>>1 换向
 *     - 跨入新格: 新格空闲路径 → 占用新格(+1)/释放旧格(-1)
 *                 新格==11(我城) → 冲城状态(8)
 *                 否则 → 被堵状态(7), 原地等待下帧重试
 *   占用标记: a(int,int,boolean) 行11058-11085 (E1163 奇偶位)
 *
 * H5与原版差异 (均已注释标注):
 *   - 原版 p1078 需按'#'键(g1046==35)出下一波; H5同时提供触屏“出兵”按钮
 *   - 4向绕行搜索 b(x,y,dir) 在路径格被占用时交替顺/逆时针执行
 *   - 麻痹、冰冻和减速按固定逻辑帧计时，不再永久修改敌人速度
 *   - 死亡/冲城分别使用 h_1/h_2，精英头顶使用 h_9 四帧特效
 */
import { Renderer } from './Renderer';
import { MapData } from './MapData';
import { SpriteLoader } from './SpriteLoader';
import { canStartWave as canRequestWave } from './Timing';
import { HEROES } from '../data/heroes';
import type { RulesetId } from '../enhancement/Ruleset';
import { FeatureContext } from '../enhancement/Ruleset';
import { SeededRng } from '../enhancement/SeededRng';
import type { WavePlan } from '../enhancement/WaveIntel';
import type { CombatEvents, CombatStatusId, StatusRemovalReason } from '../enhancement/CombatEvents';
import type { ModifierResolver } from '../enhancement/ModifierResolver';
import {
  TILE_SIZE,
  MAP_TOP_BAR_H,
  MAP_VIEW_H,
  MAP_VIEW_W,
  DIRECTIONS_K1081,
  UNIT_STATS_I1079,
  WAVE_PROB_J1080,
  WAVE_COUNT_L1072,
  BOSS_TABLE_A1067,
  BOSS_LIST_Z1131,
  FACTION_OFFSET_A1132,
  ENEMY_ANIM_L1083,
  ENEMY_DRAW_OFFSETS_D1091,
  ENEMY_SRC_RECTS_A1092,
} from '../data/gameData';

// 敌人状态 (对应原版 b1066[n][8], var45[var3=8])
export enum EnemyState {
  WALK = 0,     // 行走
  HIT_PUSH = 1, // 擂木命中后的推出阶段
  HIT_BACK = 2, // 擂木命中后的回弹阶段
  HIT_RECOVER = 3, // 擂木命中后的恢复阶段
  SIEGE = 4,    // 架炮 (仅兵种4, variant 8/9; 移动照常, 渲染换攻击动画)
  DYING = 5,    // 死亡动画 (9逻辑帧)
  SETTLE = 6,   // 死亡结算 (发金币并移除)
  BLOCKED = 7,  // 被堵 (前方格被占用, 下帧重试)
  CHARGE = 8,   // 冲城 (5逻辑帧后扣城防并移除)
}

/**
 * 敌人结构 (字段注释标注原版 b1066[n][idx] 对应索引)
 */
export interface Enemy {
  instanceId?: number;  // 强化战报使用的稳定局内 ID
  x: number;           // [0]  X坐标 (地图像素)
  y: number;           // [1]  Y坐标 (地图像素)
  hp: number;          // [2]  当前HP
  defense: number;     // [3] aY 敌人防御力/减伤值
  goldReward: number;  // H5结算字段；原版普通/名将固定为5/50
  speed: number;       // [4]  速度 px/逻辑帧 (aZ)
  baseSpeed: number;   // 未受状态效果影响的原始速度
  slowScale: number;   // 当前减速倍率，效果结束后恢复为 1
  dir: number;         // [5]  方向 0上1右2下3左
  variant: number;     // [6]  变体 = unitType*2 + elite
  animFrame: number;   // [7]  动画序列索引 (ENEMY_ANIM_L1083 下标)
  state: EnemyState;   // [8]  状态
  maxHp: number;       // 最大HP (H5血条用)
  unitType: number;    // 兵种 aV (0-5)
  elite: boolean;      // 精英(名将) o1077
  spawnIndex: number;  // [24] 出生序号 aQ
  bossType: number;    // [26] 名将类型 ba
  siegeAnim: number;   // [17] 架炮动画帧 (0-5)
  siegeTimer: number;  // [25] 架炮周期计时
  chargeTimer: number; // 冲城计时 (原版复用[7], H5独立)
  dieTimer: number;    // 死亡动画计时 (原版复用[7], H5独立)
  effect: number;      // 塔特殊效果 (H5 Tower/TechTree 兼容: 0无 1麻痹 2冰冻 3中毒 4火焰 5减速)
  timer: number;       // 塔效果计时 (H5兼容)
  dotScale: number;    // 持续伤害倍率（终阶火焰英雄为2，其余为1）
  fireTimer: number;     // [11] 火焰计时
  paralyzeTimer: number; // [12] 麻痹计时
  freezeTimer: number;   // [13] 寒冰计时
  poisonTimer: number;   // [14] 中毒计时
  slowTimer: number;     // [15] 减速计时
  fireFrame: number;     // [18] 火焰动画帧 (0-5)
  paralyzeFrame: number; // [19] 麻痹动画帧 (0-2)
  freezeFrame: number;   // [20] 寒冰动画帧 (0-3)
  poisonFrame: number;   // [21] 中毒动画帧 (0-2)
  slowFrame: number;     // [22] 减速动画帧 (0-2)
  poisonPower: number;   // [23] 中毒每次伤害，等于命中过它的最高石灰瓶等级
  firePower: number;     // 火焰每 8 帧伤害（普通 8、蜀国终阶烟火 16）
  hitTimer: number;      // [10] 受击动画计时，-1 表示空闲
  lastDamage: number;    // [16] 最近一次显示的伤害
  impactDir: number;     // [9] 擂木推出方向
  fireSourceTowerId?: number;
  poisonSourceTowerId?: number;
  freezeSourceTowerId?: number;
  paralyzeSourceTowerId?: number;
  slowSourceTowerId?: number;
  lastDamageSourceId?: number;
  killCredited?: boolean;
  armorBreakTimer?: number;
  armorBreakAmount?: number;
  armorBreakSourceTowerId?: number;
}

export interface SerializedEnemySystem {
  currentWave: number;
  spawnedInWave: number;
  waveSize: number;
  spawnTimer: number;
  enemyType: number;
  waveHp: number;
  waveDefense: number;
  waveSpeed: number;
  totalSpawnIndex: number;
  bossType: number;
  bossId: number;
  bossPending: boolean;
  wavePending: boolean;
  totalSpawned: number;
  totalKilled: number;
  nextEnemyInstanceId: number;
  currentWavePlan: WavePlan | null;
  enemies: Enemy[];
}

export class EnemySystem {
  private renderer: Renderer;
  private mapData: MapData;
  private spriteLoader: SpriteLoader | null = null;

  // 敌人密集数组 (对应原版 b1066[aP], swap-remove 对应 p() 行23859)
  private enemies: Enemy[] = [];

  // ====== 波次状态 (全部对应原版字段) ======
  private aN: number = 0;      // 当前地图关卡 (0-8)
  private aS: number = 0;      // 当前波号 (从1计, O() 中先++再R())
  private aT: number = 0;      // 本波已刷数量
  private aX: number = 0;      // 本波应刷数量
  private aR: number = 0;      // 刷怪间隔倒计时 (最小间隔3逻辑帧: 2→1→0→-1)
  private aV: number = 0;      // 本波兵种 (0-5)
  private aW: number = 0;      // 本波HP
  private aY: number = 0;      // 本波金币系数
  private aZ: number = 0;      // 本波速度
  private aQ: number = 0;      // 总刷怪计数 (spawnIndex)
  private ba: number = 0;      // 名将类型 (0=非名将波)
  private bb: number = 0;      // 名将头像/名单索引 (z1131查得)
  private o1077: boolean = false; // 名将波标志
  private p1078: boolean = false; // 开下一波标志 (原版按'#')
  private faction: number = 0; // X 国家 (0蜀1魏2吴)
  private fireDamage: number = 8; // 原版 z(int)：由蜀国七级烟火是否仍在场动态决定
  private detourClockwise: boolean = false; // 对应原版 q1082，绕行方向交替
  private visualFrame: number = 0;
  private features = new FeatureContext('classic');
  private rng: SeededRng | null = null;
  private events: CombatEvents | null = null;
  private modifiers: ModifierResolver | null = null;
  private currentWavePlan: WavePlan | null = null;
  private nextEnemyInstanceId = 1;

  // 统计
  private totalSpawned: number = 0;
  private totalKilled: number = 0;
  // 原版普通敌兵5金、名将50金；z1169 金手指翻倍在 Game 回调层处理。
  private goldReward: number = 5;

  // 回调
  private onEnemyKilled: ((gold: number, enemy: Enemy) => void) | null = null;
  private onEnemyEscaped: ((enemy: Enemy) => void) | null = null;
  private onBossWave: ((bossType: number, bossId: number) => void) | null = null;

  // 关卡是否已开始 (剧情阶段不生成敌人)
  private levelStarted: boolean = false;

  constructor(renderer: Renderer, mapData: MapData) {
    this.renderer = renderer;
    this.mapData = mapData;
  }

  setSpriteLoader(loader: SpriteLoader): void {
    this.spriteLoader = loader;
  }

  setVisualFrame(frame: number): void {
    this.visualFrame = frame;
  }

  setLevel(level: number): void {
    this.aN = level <= 8 ? level : level % 9;
    this.goldReward = 5;
    this.levelStarted = false;
  }

  /** 原版 X：阵营会影响敌将波次偏移，必须与塔和科技树使用同一选择。 */
  setFaction(faction: number): void {
    this.faction = Math.max(0, Math.min(2, faction | 0));
  }

  setFireDamage(damage: number): void {
    this.fireDamage = Math.max(0, Math.floor(damage));
  }

  setEnhancementContext(
    rulesetId: RulesetId,
    rng: SeededRng | null,
    events: CombatEvents | null,
    modifiers: ModifierResolver | null,
  ): void {
    this.features = new FeatureContext(rulesetId);
    this.rng = rng;
    this.events = events;
    this.modifiers = modifiers;
    if (!this.features.waveIntel) this.currentWavePlan = null;
  }

  /**
   * 标记关卡已开始 (剧情阶段结束后调用)
   */
  startLevel(): void {
    this.levelStarted = true;
  }

  setCallbacks(onKilled: (gold: number, enemy: Enemy) => void, onEscaped: (enemy: Enemy) => void, onBossWave?: (bossType: number, bossId: number) => void): void {
    this.onEnemyKilled = onKilled;
    this.onEnemyEscaped = onEscaped;
    this.onBossWave = onBossWave ?? null;
  }

  /**
   * 重置 (对应原版 aj() 行14081: aT/aX/aP/aQ/aS=0, p1078=false, by=10)
   * 敌人直接清空 (不释放占用格 — 地形副本由 MapData.loadLevel 重建)
   */
  reset(): void {
    for (const enemy of this.enemies) this.emitRemainingStatusRemovals(enemy);
    this.enemies = [];
    this.aS = 0;
    this.aT = 0;
    this.aX = 0;
    this.aR = 0;
    this.aQ = 0;
    this.ba = 0;
    this.bb = 0;
    this.o1077 = false;
    this.p1078 = false;
    this.detourClockwise = false;
    this.totalSpawned = 0;
    this.totalKilled = 0;
    this.currentWavePlan = null;
    this.nextEnemyInstanceId = 1;
    this.levelStarted = false;
  }

  /** 金手指：立即清除当前画面上的敌人，不产生额外金币。 */
  clearAllEnemies(): void {
    for (const enemy of this.enemies) {
      this.emitRemainingStatusRemovals(enemy);
      this.mapData.releaseTileAtPixel(enemy.x, enemy.y);
    }
    this.enemies = [];
  }

  /** 请求首波/下一波；对应原版 g1046==35 ('#') 的条件判断。 */
  requestNextWave(): boolean {
    if (!this.canStartNextWave) return false;
    if (this.features.waveIntel) this.prepareNextWavePlan();
    this.p1078 = true;
    return true;
  }

  prepareNextWavePlan(): WavePlan | null {
    if (!this.features.waveIntel || !this.canStartNextWave) return null;
    const wave = this.aS + 1;
    if (this.currentWavePlan?.wave === wave) return this.currentWavePlan;
    this.currentWavePlan = this.calculateWavePlan(wave);
    this.events?.emit('wavePlanned', {
      wave, enemyType: this.currentWavePlan.enemyType, count: this.currentWavePlan.count,
      bossId: this.currentWavePlan.bossId,
    });
    return this.currentWavePlan;
  }

  private calculateWavePlan(wave: number): WavePlan {
    const elite = wave % 4 === 0;
    let enemyType = 0;
    let bossType = 0;
    let bossId = 0;
    if (elite) {
      let off = 0;
      if (this.aN > 1 && this.aN < 6 && (FACTION_OFFSET_A1132[this.faction]?.[this.aN] ?? 0) === 1) {
        off = (BOSS_LIST_Z1131[this.aN]?.length ?? 0) >> 1;
      }
      const idx = (wave >> 2) + off - 1;
      const entry = BOSS_TABLE_A1067[this.aN]?.[idx] ?? [1, 1];
      bossId = BOSS_LIST_Z1131[this.aN]?.[idx] ?? 0;
      enemyType = entry[0] >> 1;
      bossType = entry[1];
    } else {
      const roll = this.rng?.nextInt(21) ?? 0;
      const prob = WAVE_PROB_J1080[this.aN] ?? WAVE_PROB_J1080[0];
      enemyType = prob.length - 1;
      for (let i = 0; i < prob.length; i++) {
        if (roll <= prob[i]) { enemyType = i; break; }
      }
    }
    const stats = UNIT_STATS_I1079[enemyType] ?? UNIT_STATS_I1079[0];
    return {
      wave,
      enemyType,
      count: Math.min(79, stats[2] + stats[3] * wave),
      spawnLane: null,
      bossType,
      bossId,
      elite,
    };
  }

  private applyWavePlan(plan: WavePlan): void {
    this.aS = plan.wave;
    this.aV = plan.enemyType;
    this.aX = plan.count;
    this.ba = plan.bossType;
    this.bb = plan.bossId;
    this.o1077 = plan.elite;
    const stats = UNIT_STATS_I1079[this.aV] ?? UNIT_STATS_I1079[0];
    this.aW = stats[0] + stats[1] * this.aS + (this.ba === 3 ? this.aS * 10 : 0);
    this.aY = stats[4] * this.aS + (this.ba === 1 ? this.aS : 0);
    this.aZ = stats[5];
  }

  // ============================================================
  // 波次参数计算 (对应原版 R() 行8633-8766)
  // ============================================================
  private computeWaveParams(): void {
    if (this.o1077) {
      // 名将波: 查 BOSS_TABLE_A1067[aN][(aS>>2)+off-1]
      // off: 仅当 1<aN<6 且 A1132[X][aN]==1 时为 z1131[aN].length>>1, 否则0
      //      (已经 vineflower 行8639-8664 与 CFR 双重验证; 注意并非直接取 A1132 值)
      let off = 0;
      if (this.aN > 1 && this.aN < 6) {
        if ((FACTION_OFFSET_A1132[this.faction]?.[this.aN] ?? 0) === 1) {
          off = (BOSS_LIST_Z1131[this.aN]?.length ?? 0) >> 1;
        }
      }
      const idx = (this.aS >> 2) + off - 1;
      const entry = BOSS_TABLE_A1067[this.aN]?.[idx] ?? [1, 1];
      this.bb = BOSS_LIST_Z1131[this.aN]?.[idx] ?? 0;
      this.aV = entry[0] >> 1;
      this.ba = entry[1];
    } else {
      // 普通波: roll=rand%21, 按 WAVE_PROB_J1080[aN] 累积表选兵种
      const roll = Math.floor(Math.random() * 21);
      const prob = WAVE_PROB_J1080[this.aN] ?? WAVE_PROB_J1080[0];
      this.aV = prob.length - 1;
      for (let i = 0; i < prob.length; i++) {
        if (roll <= prob[i]) {
          this.aV = i;
          break;
        }
      }
      this.ba = 0;
    }

    const stats = UNIT_STATS_I1079[this.aV] ?? UNIT_STATS_I1079[0];
    // aW = stats[0] + stats[1]*aS + (ba==3 ? aS*10 : 0)
    this.aW = stats[0] + stats[1] * this.aS + (this.ba === 3 ? this.aS * 10 : 0);
    // aX = stats[2] + stats[3]*aS (封顶79)
    this.aX = Math.min(79, stats[2] + stats[3] * this.aS);
    // aY = stats[4]*aS + (ba==1 ? aS : 0)
    this.aY = stats[4] * this.aS + (this.ba === 1 ? this.aS : 0);
    // aZ = stats[5]
    this.aZ = stats[5];
  }

  // ============================================================
  // 刷怪 (对应原版 l(int) 行22811-22948, 固定 l(1))
  // ============================================================
  private spawnTick(): void {
    // 原版 b1066 是 80×28 的敌人池，且 aX 已在 computeWaveParams() 封顶 79。
    // l(int) 这里只检查本波是否已经刷完，不存在 30 个活动敌人时暂停刷怪的规则。
    if (this.aT >= this.aX) return;

    // 出生空闲检查: b(b1069[aN][0], b1069[aN][1]+13) — 出生点下方13px的格子可进入才刷
    // (两个反编译器一致确认 +13 偏移; 效果: 敌人成串而出, 约0.8-1.1s/个, 无全局匀速定时器)
    const chk = this.mapData.getSpawnCheckPixel();
    if (!this.mapData.isPathFreeAtPixel(chk.x, chk.y)) return;

    this.aR--;
    if (this.aR >= 0) return;

    // 名将标志: 名将波且场上无敌(aP==0) → 首个敌人为精英(10倍HP), 并触发名将登场提示(ab())
    // 否则 o1077 复位 (同波其余敌人为普通兵)
    if (this.o1077 && this.enemies.length === 0) {
      this.onBossWave?.(this.ba, this.bb);
      // o1077 保持 true (原版行22838)
    } else {
      this.o1077 = false;
    }

    this.spawnEnemy();

    this.aQ++;
    this.aT++;
    this.aR = 2; // 最小间隔3逻辑帧
  }

  /**
   * 生成单个敌人 (对应原版 l(int) 的初始化块 行22861-22943)
   */
  private spawnEnemy(): void {
    const sp = this.mapData.getSpawnPixel();
    const elite = this.o1077;
    const enemy: Enemy = {
      instanceId: this.nextEnemyInstanceId++,
      x: sp.x,                                // [0] = b1069[aN][0]
      y: sp.y,                                // [1] = b1069[aN][1]
      hp: elite ? this.aW * 10 : this.aW,     // [2] 名将波10倍HP
      defense: this.aY,                       // [3] 原版 aY，攻击时从伤害中扣除
      goldReward: elite ? 50 : 5,             // 原版结算固定奖励，不是波次 aY
      speed: this.modifiers?.enemySpeed(this.aZ, elite) ?? this.aZ, // [4]
      baseSpeed: this.modifiers?.enemySpeed(this.aZ, elite) ?? this.aZ,
      slowScale: 1,
      dir: this.mapData.getPathDirAtPixel(sp.x, sp.y), // [5] = c(x,y) 出生格方向
      variant: elite ? (this.aV << 1) + 1 : this.aV << 1, // [6]
      animFrame: 0,                           // [7]
      state: EnemyState.WALK,                 // [8]
      maxHp: elite ? this.aW * 10 : this.aW,
      unitType: this.aV,
      elite,
      spawnIndex: this.aQ,                    // [24]
      bossType: this.ba,                      // [26]
      siegeAnim: 0,                           // [17]
      siegeTimer: 0,                          // [25]
      chargeTimer: 0,
      dieTimer: 0,
      effect: 0,
      timer: 0,
      dotScale: 1,
      fireTimer: 0,
      paralyzeTimer: 0,
      freezeTimer: 0,
      poisonTimer: 0,
      slowTimer: 0,
      fireFrame: 0,
      paralyzeFrame: 0,
      freezeFrame: 0,
      poisonFrame: 0,
      slowFrame: 0,
      poisonPower: 0,
      firePower: 8,
      hitTimer: -1,
      lastDamage: 0,
      impactDir: 0,
    };
    // 出生方向合法性兜底 (路径格 v<8 才有方向0-3)
    if (enemy.dir < 0 || enemy.dir > 3) enemy.dir = 2;

    this.enemies.push(enemy);
    this.totalSpawned++;
    // 占用出生格 a(x, y, true)
    this.mapData.occupyTileAtPixel(sp.x, sp.y);
    this.events?.emit('enemySpawned', {
      enemyId: enemy.instanceId ?? 0, wave: this.aS, enemyType: enemy.unitType, elite: enemy.elite,
    });
  }

  // ============================================================
  // 主更新：由 Game 的固定 100ms 时钟调用一次
  // ============================================================
  update(): void {
    if (!this.levelStarted) return;
    this.logicFrame();
  }

  /**
   * 单个逻辑帧 (对应原版 X() 行9224-9588)
   */
  private logicFrame(): void {
    // 1. O() 波次推进 (行8518-8566)
    if (this.p1078) {
      this.p1078 = false;
      this.aR = 0;
      this.aT = 0;
      if (this.features.waveIntel) {
        const plan = this.currentWavePlan?.wave === this.aS + 1
          ? this.currentWavePlan
          : this.calculateWavePlan(this.aS + 1);
        this.currentWavePlan = plan;
        this.applyWavePlan(plan);
      } else {
        this.o1077 = (this.aS & 3) === 3; // 每第4波为名将波
        this.aS++;
        this.computeWaveParams(); // R()
      }
      this.events?.emit('waveStarted', { wave: this.aS });
      // 名将音乐和横幅在首个名将实体实际生成时通过回调触发。
    }

    // 2. l(1) 刷怪
    this.spawnTick();

    // 3. 原版先按出生序 o1153 升序更新，让队首先离开当前格。
    // 后方单位先绕行会把多车道地图逐格填死，形成永久堵塞。
    this.enemies.sort((a, b) => a.spawnIndex - b.spawnIndex);
    for (let i = 0; i < this.enemies.length;) {
      const enemy = this.enemies[i];
      this.updateEnemy(enemy, i);
      // removeEnemy() 使用 splice 时，当前位置已换成下一个敌人；否则才前进。
      if (this.enemies[i] === enemy) i++;
    }
  }

  /**
   * 方向更新 (对应原版 o(int) 行23725-23766)
   * 仅在格中心 (x%16==8 && y%16==8) 触发:
   *   前方一格被占用(d()==false) → 原版调用 b(x,y,dir) 4向绕行搜索
   *   否则 → dir = 当前格 E1163>>1
   */
  private updateDirection(enemy: Enemy): void {
    if ((enemy.x & 7) !== 0 || (enemy.x & 15) === 0) return;
    if ((enemy.y & 7) !== 0 || (enemy.y & 15) === 0) return;

    const nx = enemy.x + (DIRECTIONS_K1081[enemy.dir][0] << 4);
    const ny = enemy.y + (DIRECTIONS_K1081[enemy.dir][1] << 4);
    // 原版 o() 使用 d() 只查看 E1163 占用位；D1162 是否可破坏留给跨格
    // 的 b() 判定，不能在这里提前削弱断龙闸或把机关误判成绕行墙。
    const nextUnoccupied = this.mapData.isPathUnoccupiedAtPixel(nx, ny);
    if (!nextUnoccupied) {
      enemy.dir = this.findDetourDirection(enemy.x, enemy.y, enemy.dir);
      return;
    }
    const nd = this.mapData.getPathDirAtPixel(enemy.x, enemy.y); // c() 行16925
    // 兜底: 仅在读到合法路径方向(0-3)时换向 (敌人正常总在路径格上)
    if (nd >= 0 && nd < 4) {
      enemy.dir = nd;
    }
  }

  /** 还原原版 b(x,y,dir) 的四方向绕行搜索，并交替顺/逆时针尝试。 */
  private findDetourDirection(x: number, y: number, previousDir: number): number {
    const pathDir = this.mapData.getPathDirAtPixel(x, y);
    let candidate = pathDir >= 0 && pathDir < 4 ? pathDir : previousDir;
    this.detourClockwise = !this.detourClockwise;
    const step = this.detourClockwise ? 1 : -1;

    for (let i = 0; i < 4; i++) {
      const nx = x + (DIRECTIONS_K1081[candidate][0] << 4);
      const ny = y + (DIRECTIONS_K1081[candidate][1] << 4);
      if (this.mapData.isPathFreeAtPixel(nx, ny)) {
        const nextPathDir = this.mapData.getPathDirAtPixel(nx, ny);
        // 原版 b(x,y,dir) 比较的是候选方向与目标格方向。若误用当前格方向，
        // 拥堵绕行时会放行“进入后立刻掉头”的反向格，形成死循环。
        const reversesPath = nextPathDir >= 0 && nextPathDir < 4 && Math.abs(nextPathDir - candidate) === 2;
        const reversesPrevious = nextPathDir >= 0 && nextPathDir < 4 && Math.abs(nextPathDir - previousDir) === 2;
        if (!reversesPath && !reversesPrevious) return candidate;
      }
      candidate = (candidate + step + 4) & 3;
    }
    return pathDir >= 0 && pathDir < 4 ? pathDir : previousDir;
  }

  /**
   * 动画帧推进 (对应原版 n(int) 行23591:
   *   [7]++, 超过 ENEMY_ANIM_L1083[unitType].length-1 时归0)
   */
  private advanceAnim(enemy: Enemy): void {
    const seq = ENEMY_ANIM_L1083[enemy.unitType] ?? ENEMY_ANIM_L1083[0];
    enemy.animFrame++;
    if (enemy.animFrame > seq.length - 1) {
      enemy.animFrame = 0;
    }
  }

  /** 旧存档和测试对象缺少新增字段时，按原版出生值补齐。 */
  private ensureCombatFields(enemy: Enemy): void {
    enemy.instanceId ??= this.nextEnemyInstanceId++;
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
    enemy.impactDir ??= enemy.dir;
    enemy.speed ??= enemy.baseSpeed ?? 1;
    enemy.baseSpeed ??= enemy.speed;
    enemy.fireSourceTowerId ??= 0;
    enemy.poisonSourceTowerId ??= 0;
    enemy.freezeSourceTowerId ??= 0;
    enemy.paralyzeSourceTowerId ??= 0;
    enemy.slowSourceTowerId ??= 0;
    enemy.lastDamageSourceId ??= 0;
    enemy.armorBreakTimer ??= 0;
    enemy.armorBreakAmount ??= 0;
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

  private clearStatusSource(enemy: Enemy, status: CombatStatusId): void {
    switch (status) {
      case 'paralyze': enemy.paralyzeSourceTowerId = 0; break;
      case 'freeze': enemy.freezeSourceTowerId = 0; break;
      case 'poison': enemy.poisonSourceTowerId = 0; break;
      case 'fire': enemy.fireSourceTowerId = 0; break;
      case 'slow': enemy.slowSourceTowerId = 0; break;
      case 'armor_break': enemy.armorBreakSourceTowerId = 0; break;
    }
  }

  private emitStatusRemoved(
    enemy: Enemy,
    status: CombatStatusId,
    reason: StatusRemovalReason,
  ): void {
    this.events?.emit('statusRemoved', {
      enemyId: enemy.instanceId ?? 0,
      towerId: this.statusSource(enemy, status),
      status,
      reason,
    });
    this.clearStatusSource(enemy, status);
  }

  private emitExpiredStatus(enemy: Enemy, status: CombatStatusId, previousDuration: number): void {
    if (previousDuration > 0 && this.statusDuration(enemy, status) <= 0) {
      this.emitStatusRemoved(enemy, status, 'expired');
    }
  }

  private emitRemainingStatusRemovals(enemy: Enemy): void {
    const statuses: CombatStatusId[] = ['paralyze', 'freeze', 'poison', 'fire', 'slow', 'armor_break'];
    for (const status of statuses) {
      if (this.statusDuration(enemy, status) > 0) this.emitStatusRemoved(enemy, status, 'enemy_removed');
    }
  }

  private recordStatusDamage(enemy: Enemy, amount: number, towerId: number = 0): void {
    const damage = Math.max(0, Math.floor(amount));
    if (damage <= 0) return;
    enemy.hp -= damage;
    enemy.lastDamageSourceId = towerId;
    enemy.lastDamage = damage;
    if (enemy.hitTimer < 0) enemy.hitTimer = 4;
    this.events?.emit('enemyDamaged', { enemyId: enemy.instanceId ?? 0, towerId, damage, category: 'dot' });
  }

  /**
   * 原版 z(int)：五种异常拥有彼此独立的计时、动画和伤害节拍。
   * 返回值表示本帧是否因麻痹/寒冰而完全停止移动。
   */
  private updateStatusEffects(enemy: Enemy): boolean {
    let immobilized = false;
    const aligned = (enemy.x & 7) === 0 && (enemy.y & 7) === 0;
    const previous = {
      paralyze: enemy.paralyzeTimer,
      freeze: enemy.freezeTimer,
      poison: enemy.poisonTimer,
      fire: enemy.fireTimer,
      slow: enemy.slowTimer,
      armorBreak: enemy.armorBreakTimer ?? 0,
    };

    if (enemy.hp > 0 && enemy.state !== EnemyState.DYING && enemy.state !== EnemyState.SETTLE) {
      const control = previous.paralyze > 0
        ? { status: 'paralyze' as const, towerId: enemy.paralyzeSourceTowerId ?? 0 }
        : previous.freeze > 0
          ? { status: 'freeze' as const, towerId: enemy.freezeSourceTowerId ?? 0 }
          : previous.slow > 0 && enemy.baseSpeed > 1
            ? { status: 'slow' as const, towerId: enemy.slowSourceTowerId ?? 0 }
            : null;
      if (control && control.towerId > 0) {
        this.events?.emit('enemyControlled', {
          enemyId: enemy.instanceId ?? 0,
          towerId: control.towerId,
          status: control.status,
          frames: 1,
        });
      }
    }

    if (enemy.paralyzeTimer > 0) {
      enemy.paralyzeFrame = (enemy.paralyzeFrame + 1) % 3;
      immobilized = true;
      enemy.paralyzeTimer--;
    }

    if (enemy.slowTimer > 0) {
      enemy.slowFrame = (enemy.slowFrame + 1) % 3;
      if (enemy.speed > 1 && aligned) enemy.speed = enemy.baseSpeed >> 1;
      enemy.slowTimer--;
    } else if (enemy.freezeTimer === 0 && aligned) {
      enemy.speed = enemy.baseSpeed;
    }

    if (enemy.poisonTimer > 0) {
      enemy.poisonFrame = (enemy.poisonFrame + 1) % 3;
      if ((enemy.poisonTimer & 7) === 0) {
        this.recordStatusDamage(enemy, this.modifiers?.poisonDamage(enemy.poisonPower) ?? enemy.poisonPower, enemy.poisonSourceTowerId);
      }
      enemy.poisonTimer--;
    } else {
      enemy.poisonTimer = 0;
      enemy.poisonPower = 0;
    }

    if (enemy.fireTimer > 0) {
      if ((enemy.fireTimer & 7) === 0) {
        enemy.firePower = this.fireDamage;
        this.recordStatusDamage(enemy, this.fireDamage, enemy.fireSourceTowerId);
      }
      enemy.fireFrame = (enemy.fireFrame + 1) % 6;
      enemy.fireTimer--;
    }

    // 原版有连续两段 [13] 更新，因此寒冰每逻辑帧递减两次，并在结束前造成 10 点碎冰伤害。
    if (enemy.freezeTimer > 0) {
      immobilized = true;
      if (enemy.freezeTimer >= 44) {
        if (enemy.freezeFrame < 3) enemy.freezeFrame++;
      } else if (enemy.freezeTimer <= 4) {
        if (enemy.freezeTimer === 4) {
          this.recordStatusDamage(enemy, this.modifiers?.freezeShatterDamage(10) ?? 10, enemy.freezeSourceTowerId);
        }
        if (enemy.freezeFrame > 0) enemy.freezeFrame--;
      }
      enemy.freezeTimer--;
    }
    if (enemy.freezeTimer > 0) {
      if (enemy.freezeTimer >= 45) {
        if (enemy.freezeFrame < 2) enemy.freezeFrame++;
      } else if (enemy.freezeTimer <= 3 && enemy.freezeFrame > 0) {
        enemy.freezeFrame--;
      }
      if (enemy.speed > 1 && aligned) enemy.speed = 1;
      enemy.freezeTimer--;
    } else if (enemy.slowTimer === 0 && aligned) {
      enemy.freezeTimer = 0;
      enemy.speed = enemy.baseSpeed;
    }

    // 兼容仍读取旧 H5 effect/timer 字段的 UI/存档，但战斗逻辑不再依赖这两个共享字段。
    if (enemy.paralyzeTimer > 0) enemy.effect = 1;
    else if (enemy.freezeTimer > 0) enemy.effect = 2;
    else if (enemy.poisonTimer > 0) enemy.effect = 3;
    else if (enemy.fireTimer > 0) enemy.effect = 4;
    else if (enemy.slowTimer > 0) enemy.effect = 5;
    else enemy.effect = 0;
    enemy.timer = Math.max(
      enemy.fireTimer,
      enemy.paralyzeTimer,
      enemy.freezeTimer,
      enemy.poisonTimer,
      enemy.slowTimer,
    );
    enemy.slowScale = enemy.baseSpeed > 0 ? enemy.speed / enemy.baseSpeed : 1;
    enemy.dotScale = enemy.firePower >= 16 ? 2 : 1;
    if ((enemy.armorBreakTimer ?? 0) > 0) {
      enemy.armorBreakTimer = Math.max(0, (enemy.armorBreakTimer ?? 0) - 1);
      if (enemy.armorBreakTimer === 0) enemy.armorBreakAmount = 0;
    }
    this.emitExpiredStatus(enemy, 'paralyze', previous.paralyze);
    this.emitExpiredStatus(enemy, 'freeze', previous.freeze);
    this.emitExpiredStatus(enemy, 'poison', previous.poison);
    this.emitExpiredStatus(enemy, 'fire', previous.fire);
    this.emitExpiredStatus(enemy, 'slow', previous.slow);
    this.emitExpiredStatus(enemy, 'armor_break', previous.armorBreak);
    return immobilized;
  }

  private tickHitTimer(enemy: Enemy): void {
    if (enemy.hitTimer < 0) return;
    enemy.hitTimer--;
    if (enemy.hitTimer < 0) enemy.hitTimer = -1;
  }

  private startDeathIfEligible(enemy: Enemy): void {
    if (enemy.hp > 0
        || enemy.state === EnemyState.DYING
        || enemy.state === EnemyState.SETTLE
        || enemy.state === EnemyState.HIT_BACK
        || enemy.state === EnemyState.HIT_RECOVER) return;
    enemy.state = EnemyState.DYING;
    enemy.dieTimer = 0;
  }

  /**
   * 逐敌人状态机 (对应原版 X() 的 switch(var45[8]) + label122 + label117)
   */
  private updateEnemy(enemy: Enemy, index: number): void {
    this.ensureCombatFields(enemy);
    const immobilized = this.updateStatusEffects(enemy);
    this.tickHitTimer(enemy);

    // 死亡检测 (对应原版 i(int,int)：状态2/3在完成受击位移前不切死亡动画)
    if (immobilized && enemy.state !== EnemyState.DYING && enemy.state !== EnemyState.SETTLE) {
      this.updateDirection(enemy);
      enemy.state = EnemyState.WALK;
      this.startDeathIfEligible(enemy);
      return;
    }

    switch (enemy.state) {
      case EnemyState.DYING: // case 5
        enemy.dieTimer++;
        if (enemy.dieTimer > 8) {
          enemy.dieTimer = 0;
          enemy.state = EnemyState.SETTLE;
        }
        return;

      case EnemyState.SETTLE: { // case 6: 死亡结算
        // 原版结算: 精英 bz+=50、普通 bz+=5；金手指 z1169 翻倍由 Game 回调层处理。
        this.totalKilled++;
        this.onEnemyKilled?.(enemy.goldReward, enemy);
        this.events?.emit('enemyDied', { enemyId: enemy.instanceId ?? 0, towerId: enemy.lastDamageSourceId || null });
        this.emitRemainingStatusRemovals(enemy);
        // 原版: 精英死亡时清空所有敌人[26]及 ba — H5不影响逻辑, 跳过
        this.removeEnemy(index);
        return;
      }

      case EnemyState.HIT_PUSH: { // case 1: 擂木推出
        const impactDir = enemy.impactDir & 3;
        const sameAxis = (impactDir & 1) === (enemy.dir & 1);
        const distance = sameAxis ? 8 : 16;
        const tx = enemy.x + DIRECTIONS_K1081[impactDir][0] * distance;
        const ty = enemy.y + DIRECTIONS_K1081[impactDir][1] * distance;
        if (this.mapData.isPathFreeAtPixel(tx, ty)
            && this.mapData.getPathDirAtPixel(tx, ty) === enemy.dir) {
          this.mapData.occupyTileAtPixel(tx, ty);
          this.mapData.releaseTileAtPixel(enemy.x, enemy.y);
          enemy.x = tx;
          enemy.y = ty;
          enemy.state = EnemyState.BLOCKED;
        } else {
          enemy.x += DIRECTIONS_K1081[impactDir][0] * 4;
          enemy.y += DIRECTIONS_K1081[impactDir][1] * 4;
          enemy.state = EnemyState.HIT_BACK;
        }
        this.startDeathIfEligible(enemy);
        return;
      }

      case EnemyState.HIT_BACK: { // case 2: 回弹 4px
        const reverse = (enemy.impactDir + 2) & 3;
        enemy.x += DIRECTIONS_K1081[reverse][0] * 4;
        enemy.y += DIRECTIONS_K1081[reverse][1] * 4;
        enemy.state = EnemyState.HIT_RECOVER;
        this.startDeathIfEligible(enemy);
        return;
      }

      case EnemyState.HIT_RECOVER: // case 3: 恢复行走
        enemy.state = EnemyState.WALK;
        this.startDeathIfEligible(enemy);
        return;

      case EnemyState.BLOCKED: // case 7: 被堵
        this.updateDirection(enemy);
        // 原版 state 7 只暂停一个逻辑帧；位置不会被强行拉回格中心。
        // 拉回中心会把已经贴近墙边的单位推回上一格，随后反复撞墙。
        enemy.state = EnemyState.WALK;
        this.startDeathIfEligible(enemy);
        return;

      case EnemyState.CHARGE: // case 8: 冲城
        enemy.chargeTimer++;
        if (enemy.chargeTimer > 4) {
          // 5逻辑帧后: by(城防)-1, 移除敌人; by<=0 由 Game 判负
          this.onEnemyEscaped?.(enemy);
          this.events?.emit('enemyEntered', { enemyId: enemy.instanceId ?? 0 });
          this.emitRemainingStatusRemovals(enemy);
          this.removeEnemy(index);
        }
        return;

      case EnemyState.SIEGE: // case 4: 架炮 (仅兵种4)
        enemy.siegeAnim++;
        if (enemy.siegeAnim > 5) enemy.siegeAnim = 0;
        enemy.siegeTimer++;
        if (enemy.siegeTimer > 100) {
          enemy.siegeTimer = 100;
          enemy.siegeAnim = 0;
          enemy.state = EnemyState.WALK;
        }
        break; // 落到 label122/label117 (移动照常)

      case EnemyState.WALK:
      default:
        break;
    }

    // label122: 兵种4 (variant 8/9) 架炮周期: 行走时 siegeTimer--, 到0进入架炮
    if (enemy.variant === 8 || enemy.variant === 9) {
      if (enemy.state === EnemyState.WALK) {
        enemy.siegeTimer--;
        if (enemy.siegeTimer < 0) {
          enemy.siegeTimer = 0;
          enemy.state = EnemyState.SIEGE;
        }
      }
    }

    // label117: 移动
    this.updateDirection(enemy); // o()
    const moveSpeed = enemy.speed;
    const nx = enemy.x + DIRECTIONS_K1081[enemy.dir][0] * moveSpeed;
    const ny = enemy.y + DIRECTIONS_K1081[enemy.dir][1] * moveSpeed;
    this.advanceAnim(enemy); // n()

    // 跨入新格检测 (a(nx,ny) != a(x,y))
    const curTile = this.tileIndexOf(enemy.x, enemy.y);
    const newTile = this.tileIndexOf(nx, ny);
    if (newTile !== curTile) {
      if (!this.mapData.isPathFreeAtPixel(nx, ny)) { // b() 行16868
        if (this.mapData.isOurCastleAtPixel(nx, ny)) { // c() 行17868
          enemy.state = EnemyState.CHARGE;
          enemy.chargeTimer = 0;
        } else {
          enemy.state = EnemyState.BLOCKED;
        }
        this.startDeathIfEligible(enemy);
        return; // 位置不更新 (原版 break label117)
      }
      // 占用新格 / 释放旧格 (a(int,int,boolean) 行11058)
      this.mapData.occupyTileAtPixel(nx, ny);
      this.mapData.releaseTileAtPixel(enemy.x, enemy.y);
    }

    enemy.x = nx;
    enemy.y = ny;
    // 原版 i(int,int) 位于各移动状态处理末尾，致命一击仍会完成本帧方向/位移。
    this.startDeathIfEligible(enemy);
  }

  /**
   * 像素坐标 → 瓦片索引 (对应原版 a(int,int) 行10001)
   */
  private tileIndexOf(px: number, py: number): number {
    const w = this.mapData.width;
    return (py >> 4) * w + (px >> 4);
  }

  /**
   * 移除敌人 (对应原版 p() 行23859: 释放占用格 + swap-remove)
   */
  private removeEnemy(index: number): void {
    const enemy = this.enemies[index];
    if (enemy) {
      // 原版 p() 会 a(x,y,false) 释放敌人当前格
      this.mapData.releaseTileAtPixel(enemy.x, enemy.y);
    }
    // 保持出生序顺序，避免 swap-remove 把后方敌人挪到队首破坏更新顺序。
    this.enemies.splice(index, 1);
    // 原版: aT==aX && aP==0 时播清场音效 h(aq) — H5跳过(注释标注)
  }

  // ============================================================
  // 渲染 (对应原版 f(int,int,int,int,int) 行20357 及调用点 行9650-9850)
  // ============================================================
  render(): void {
    const camX = this.mapData.cameraX;
    const camY = this.mapData.cameraY;

    const vctx = this.renderer.virtualContext;
    vctx.save();
    vctx.beginPath();
    vctx.rect(0, MAP_TOP_BAR_H, MAP_VIEW_W, MAP_VIEW_H);
    vctx.clip();
    vctx.imageSmoothingEnabled = false;

    for (const enemy of this.enemies) {
      // 屏幕坐标 = 地图坐标 - 相机 + 顶栏偏移
      const px = enemy.x - camX;
      const py = enemy.y - camY + MAP_TOP_BAR_H;

      if (px < -24 || px > MAP_VIEW_W + 8 || py < MAP_TOP_BAR_H - 32 || py > MAP_TOP_BAR_H + MAP_VIEW_H + 8) continue;

      switch (enemy.state) {
        case EnemyState.SETTLE:
          continue; // state 6 不绘制 (原版行9668)
        case EnemyState.DYING:
          this.renderEffectFrame(enemy, px, py, enemy.dieTimer);
          // 原版 Y() 的第二遍仍会为死亡态绘制 q(int)，致命一击不能吞掉受击粒子/数字。
          this.renderHitEffect(enemy, px, py);
          continue;
        case EnemyState.CHARGE:
          this.renderEffectFrame(enemy, px, py, enemy.chargeTimer);
          this.renderHitEffect(enemy, px, py);
          continue;
        case EnemyState.SIEGE:
          this.renderSiege(enemy, px, py);
          this.renderEliteMarker(enemy, px, py);
          this.renderHealthBar(enemy, px, py);
          this.renderStatusEffect(enemy, px, py);
          this.renderHitEffect(enemy, px, py);
          continue;
        default:
          break;
      }

      this.renderWalking(enemy, px, py);
      this.renderHealthBar(enemy, px, py);
      this.renderStatusEffect(enemy, px, py);
      this.renderHitEffect(enemy, px, py);
    }

    vctx.restore();
  }

  /**
   * 行走敌人渲染 (对应原版 f() 行20357)
   * variant 选变体, dir 选方向组, ENEMY_ANIM_L1083 帧序列选帧
   * dir==3 时水平镜像 (原版 var7=1)
   */
  private renderWalking(enemy: Enemy, px: number, py: number): void {
    const img = this.spriteLoader?.getByPrefix(`e${enemy.unitType}`, enemy.elite ? 1 : 0) ?? null;
    const offsets = ENEMY_DRAW_OFFSETS_D1091[enemy.variant];
    const rects = ENEMY_SRC_RECTS_A1092[enemy.variant];
    const seq = ENEMY_ANIM_L1083[enemy.unitType] ?? ENEMY_ANIM_L1083[0];
    const frame = seq[enemy.animFrame % seq.length];

    if (img && offsets && rects) {
      const dirGroup = rects[enemy.dir] ?? rects[0];
      const rect = dirGroup[Math.min(frame, dirGroup.length - 1)];
      const off = offsets[enemy.dir] ?? offsets[0];
      const dx = px + off[0];
      const dy = py + off[1];
      const srcX = rect[0];
      const srcW = rect[1];
      const srcH = img.height; // 图集高即帧高 (原版 getHeight())

      const vctx = this.renderer.virtualContext;
      vctx.save();
      if (enemy.dir === 3) {
        // 水平镜像 (原版 f() var7=1)
        vctx.translate(Math.floor(dx) + srcW, Math.floor(dy));
        vctx.scale(-1, 1);
        this.renderer.drawImageRegion(img, srcX, 0, srcW, srcH, 0, 0, srcW, srcH);
      } else {
        this.renderer.drawImageRegion(img, srcX, 0, srcW, srcH, Math.floor(dx), Math.floor(dy), srcW, srcH);
      }
      vctx.restore();

      if (enemy.elite) {
        this.renderEliteMarker(enemy, px, py);
      }
      return;
    }

    // 精灵缺失时回退色块
    const colors = [0xFF4444, 0x44FF44, 0x4444FF, 0xFFFF44, 0xFF44FF, 0x44FFFF];
    this.renderer.setColor(colors[enemy.unitType % colors.length]);
    this.renderer.fillRect(px - 7, py - 14, TILE_SIZE - 2, TILE_SIZE - 2);
    if (enemy.elite) {
      this.renderer.setColor(0xFFD700);
      this.renderer.drawRect(px - 8, py - 15, TILE_SIZE, TILE_SIZE);
    }
  }

  /**
   * 架炮渲染 (对应原版 state 4 分支 行9781-9850:
   *   a1013[bj][2] (e4_2), srcX=[17]*21, 21x19, 绘制点=d1091偏移)
   * 同时绘制原版脚下阴影。
   */
  private renderSiege(enemy: Enemy, px: number, py: number): void {
    const img = this.spriteLoader?.getByPrefix(`e${enemy.unitType}`, 2) ?? null;
    const offsets = ENEMY_DRAW_OFFSETS_D1091[enemy.variant];
    if (img && offsets) {
      const off = offsets[enemy.dir] ?? offsets[0];
      const dx = px + off[0];
      const dy = py + off[1];
      const srcX = enemy.siegeAnim * 21;
      const vctx = this.renderer.virtualContext;
      // 原版架炮状态先绘制脚下阴影。
      vctx.save();
      vctx.globalAlpha = 0.35;
      vctx.fillStyle = '#000000';
      vctx.beginPath();
      vctx.ellipse(Math.floor(px), Math.floor(py - 1), 8, 3, 0, 0, Math.PI * 2);
      vctx.fill();
      vctx.restore();
      this.renderer.drawImageRegion(img, srcX, 0, 21, 19, Math.floor(dx), Math.floor(dy), 21, 19);
      return;
    }
    // 回退
    this.renderWalking(enemy, px, py);
  }

  /**
   * 死亡/冲城特效帧 (原版: 死亡=h_1 15x30帧, 冲城=h_2 24x24帧, 均画在 (x-8, y-24))
   * 死亡使用 h_1 的 15x30 帧，冲城使用 h_2 的 24x24 帧。
   */
  private renderEffectFrame(enemy: Enemy, px: number, py: number, timer: number): void {
    const dying = enemy.state === EnemyState.DYING;
    const spriteIndex = dying ? 1 : 2;
    const frameW = dying ? 15 : 24;
    const frameH = dying ? 30 : 24;
    const frameCount = dying ? 8 : 5;
    const img = this.spriteLoader?.getByPrefix('h', spriteIndex) ?? null;
    if (img) {
      const frame = Math.min(Math.max(timer, 0), frameCount - 1);
      this.renderer.drawImageRegion(img, frame * frameW, 0, frameW, frameH,
        Math.floor(px - 8), Math.floor(py - 24), frameW, frameH);
      return;
    }
    this.renderer.setColor(0xFF8800);
    this.renderer.fillRect(px - 8, py - 24, 16, 16);
  }

  /** 精英/名将头顶 h_9 四帧特效，对应原版 (a1019&3)*22。 */
  private renderEliteMarker(enemy: Enemy, px: number, py: number): void {
    if (!enemy.elite) return;
    const img = this.spriteLoader?.getByPrefix('h', 9) ?? null;
    if (img) {
      const frame = this.visualFrame & 3;
      this.renderer.drawImageRegion(img, frame * 22, 0, 22, 34,
        Math.floor(px - 11), Math.floor(py - 23), 22, 34);
      return;
    }
    this.renderer.setColor(0xFFD700);
    this.renderer.fillRect(px - 2, py - 18, 4, 4);
  }

  /**
   * 血条 (保留现有样式)
   */
  private renderHealthBar(enemy: Enemy, px: number, py: number): void {
    if (enemy.hp >= enemy.maxHp) return;
    const barW = TILE_SIZE;
    const barH = 2;
    const hpRatio = Math.max(0, enemy.hp / enemy.maxHp);
    this.renderer.setColor(0x000000);
    this.renderer.fillRect(px - 8, py - 18, barW, barH);
    this.renderer.setColor(0xFF0000);
    this.renderer.fillRect(px - 8, py - 18, barW * hpRatio, barH);
  }

  /** 原版 r(int)：冻结、减速、中毒、火焰、麻痹按固定顺序叠加绘制。 */
  private renderStatusEffect(enemy: Enemy, px: number, py: number): void {
    this.ensureCombatFields(enemy);
    const drawStrip = (
      active: boolean,
      sprite: number,
      frame: number,
      frameW: number,
      frameH: number,
      dx: number,
      dy: number,
      fallback: number,
    ) => {
      if (!active) return;
      const img = this.spriteLoader?.getByPrefix('h', sprite) ?? null;
      if (img) {
        this.renderer.drawImageRegion(img, frame * frameW, 0, frameW, frameH,
          Math.floor(px + dx), Math.floor(py + dy), frameW, frameH);
      } else {
        this.renderer.setColor(fallback);
        this.renderer.fillRect(px + dx, py + dy, frameW, frameH);
      }
    };

    drawStrip(enemy.freezeTimer > 0, 5, Math.max(0, enemy.freezeFrame - 1) % 3,
      21, 26, -8, -16, 0x80E8FF);
    drawStrip(enemy.slowTimer > 0, 7, enemy.slowFrame % 3,
      14, 11, -8, -16, 0x70A0FF);
    drawStrip(enemy.poisonTimer > 0, 4, enemy.poisonFrame % 3,
      14, 11, -8, -16, 0x20E090);

    if (enemy.fireTimer > 0) {
      const fireRects = [
        [0, 0, 17, 6, 0, 17],
        [0, 6, 17, 7, 0, 16],
        [0, 13, 17, 10, 0, 12],
        [0, 23, 17, 12, 0, 5],
        [0, 34, 17, 9, 0, 0],
        [0, 43, 17, 7, 0, 0],
      ] as const;
      const [sx, sy, sw, sh, ox, oy] = fireRects[enemy.fireFrame % fireRects.length];
      const img = this.spriteLoader?.getByPrefix('h', 6) ?? null;
      if (img) {
        this.renderer.drawImageRegion(img, sx, sy, sw, sh,
          Math.floor(px - 8 + ox), Math.floor(py - 16 + oy), sw, sh);
      } else {
        this.renderer.setColor(0xFF7020);
        this.renderer.fillRect(px - 8 + ox, py - 16 + oy, sw, sh);
      }
    }

    drawStrip(enemy.paralyzeTimer > 0, 3, enemy.paralyzeFrame % 3,
      28, 23, -16, -16, 0xFFE040);
  }

  /** 原版 q(int)：五帧受击粒子与最近一次伤害数字。 */
  private renderHitEffect(enemy: Enemy, px: number, py: number): void {
    if (enemy.hitTimer < 0) return;
    if (enemy.hitTimer === 4) {
      const burst = this.spriteLoader?.getByPrefix('bu', 22) ?? null;
      if (burst) {
        this.renderer.drawImageRegion(burst, 16, 0, 16, 16,
          Math.floor(px - 8), Math.floor(py - 8), 16, 16);
      }
      return;
    }

    const particles = [
      [[1, 2], [9, 4], [17, 1], [1, 14], [12, 13], [19, 13], [8, 19]],
      [[0, 1], [8, 3], [18, -1], [0, 14], [13, 15], [20, 13], [8, 20]],
      [[-1, 0], [8, 2], [18, -1], [-1, 15], [13, 15], [21, 14], [8, 21]],
      [[-1, 0], [8, 2], [18, -1], [-1, 15], [13, 15], [21, 14], [8, 21]],
    ] as const;
    const phase = Math.max(0, Math.min(3, 3 - enemy.hitTimer));
    const img = this.spriteLoader?.getByPrefix('h', 0) ?? null;
    if (img) {
      for (const [ox, oy] of particles[phase]) {
        this.renderer.drawImageRegion(img, phase * 5, 0, 5, 5,
          Math.floor(px + ox - 16), Math.floor(py + oy - 16), 5, 5);
      }
    }
    this.renderer.drawText(String(enemy.lastDamage), Math.floor(px - 4),
      Math.floor(py - 16 + enemy.hitTimer * 2), 0xFCFFCD, 8);
  }

  // ============================================================
  // 查询接口
  // ============================================================

  getActiveEnemies(): Enemy[] {
    return this.enemies;
  }

  /** 原版 K()→a(bN,bO)：解析建筑方框覆盖的首个活动敌人。 */
  getEnemyAtTile(tileX: number, tileY: number): Enemy | null {
    const left = tileX * TILE_SIZE;
    const top = tileY * TILE_SIZE;
    return this.enemies.find(enemy =>
      enemy.hp > 0
      && enemy.state !== EnemyState.DYING
      && enemy.state !== EnemyState.SETTLE
      && enemy.x >= left && enemy.x <= left + TILE_SIZE
      && enemy.y >= top && enemy.y <= top + TILE_SIZE
    ) ?? null;
  }

  getEnemyName(enemy: Enemy): string {
    if (enemy.elite) return HEROES[this.bb]?.name ?? '名将';
    return ['散兵', '步兵', '重装步兵', '骑兵', '弓弩步兵', '投石车兵'][enemy.unitType] ?? '敌兵';
  }

  get count(): number { return this.enemies.length; }
  get killed(): number { return this.totalKilled; }

  /** 当前是否满足原版按 # 出下一波的条件。 */
  get canStartNextWave(): boolean {
    return canRequestWave({
      levelStarted: this.levelStarted,
      wavePending: this.p1078,
      enemyCount: this.enemies.length,
      spawnedInWave: this.aT,
      waveSize: this.aX,
      currentWave: this.aS,
      totalWaves: this.totalWaves,
    });
  }

  /** 当前波号 (aS, 从1计) */
  get currentWave(): number { return this.aS; }

  /** 总波数 (l1072[aN]) */
  get totalWaves(): number { return WAVE_COUNT_L1072[this.aN] ?? 0; }

  /** 本波是否名将波 */
  get isBossWave(): boolean { return this.ba !== 0; }

  /** 名将名单索引 (bb, z1131查得) */
  get bossId(): number { return this.bb; }

  get wavePlan(): WavePlan | null { return this.currentWavePlan ? { ...this.currentWavePlan } : null; }

  exportState(): SerializedEnemySystem {
    return {
      currentWave: this.aS, spawnedInWave: this.aT, waveSize: this.aX, spawnTimer: this.aR,
      enemyType: this.aV, waveHp: this.aW, waveDefense: this.aY, waveSpeed: this.aZ,
      totalSpawnIndex: this.aQ, bossType: this.ba, bossId: this.bb, bossPending: this.o1077,
      wavePending: this.p1078, totalSpawned: this.totalSpawned, totalKilled: this.totalKilled,
      nextEnemyInstanceId: this.nextEnemyInstanceId,
      currentWavePlan: this.currentWavePlan ? { ...this.currentWavePlan } : null,
      enemies: this.enemies.map(enemy => ({ ...enemy })),
    };
  }

  restoreState(state: SerializedEnemySystem): void {
    if (!state || !Array.isArray(state.enemies)) return;
    for (const enemy of this.enemies) this.mapData.releaseTileAtPixel(enemy.x, enemy.y);
    this.aS = Math.max(0, state.currentWave | 0);
    this.aT = Math.max(0, state.spawnedInWave | 0);
    this.aX = Math.max(0, state.waveSize | 0);
    this.aR = state.spawnTimer | 0;
    this.aV = state.enemyType | 0;
    this.aW = Math.max(0, state.waveHp | 0);
    this.aY = Math.max(0, state.waveDefense | 0);
    this.aZ = Math.max(0, state.waveSpeed | 0);
    this.aQ = Math.max(0, state.totalSpawnIndex | 0);
    this.ba = state.bossType | 0;
    this.bb = state.bossId | 0;
    this.o1077 = state.bossPending === true;
    this.p1078 = state.wavePending === true;
    this.totalSpawned = Math.max(0, state.totalSpawned | 0);
    this.totalKilled = Math.max(0, state.totalKilled | 0);
    this.nextEnemyInstanceId = Math.max(1, state.nextEnemyInstanceId | 0);
    this.currentWavePlan = state.currentWavePlan ? { ...state.currentWavePlan } : null;
    this.enemies = state.enemies.map(enemy => ({ ...enemy }));
    for (const enemy of this.enemies) {
      this.ensureCombatFields(enemy);
      this.mapData.occupyTileAtPixel(enemy.x, enemy.y);
    }
    this.levelStarted = true;
  }

  /**
   * 过关判定 (对应原版 G() case2 行7492-7527:
   *   aS==l1072[aN] 且 场上无敌(aP<=0) 且 本波已刷完(aT==aX);
   *   城防>0 由 Game 另行判断)
   */
  get isLevelComplete(): boolean {
    return this.aS >= this.totalWaves &&
           this.enemies.length <= 0 &&
           this.aT === this.aX;
  }
}
