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
  MAX_ENEMIES,
} from '../data/gameData';

// 敌人状态 (对应原版 b1066[n][8], var45[var3=8])
export enum EnemyState {
  WALK = 0,     // 行走
  // 1/2/3: 原版绕行中间态由 BLOCKED+退回格中心的等价流程承接
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
  private faction: number = 0; // X 国家 (0蜀1魏2吴, 暂固定0)
  private detourClockwise: boolean = false; // 对应原版 q1082，绕行方向交替
  private visualFrame: number = 0;

  // 统计
  private totalSpawned: number = 0;
  private totalKilled: number = 0;
  // 原版普通敌兵5金、名将50金；z1169 金手指翻倍在 Game 回调层处理。
  private goldReward: number = 5;

  // 回调
  private onEnemyKilled: ((gold: number) => void) | null = null;
  private onEnemyEscaped: (() => void) | null = null;
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

  /**
   * 标记关卡已开始 (剧情阶段结束后调用)
   */
  startLevel(): void {
    this.levelStarted = true;
  }

  setCallbacks(onKilled: (gold: number) => void, onEscaped: () => void, onBossWave?: (bossType: number, bossId: number) => void): void {
    this.onEnemyKilled = onKilled;
    this.onEnemyEscaped = onEscaped;
    this.onBossWave = onBossWave ?? null;
  }

  /**
   * 重置 (对应原版 aj() 行14081: aT/aX/aP/aQ/aS=0, p1078=false, by=10)
   * 敌人直接清空 (不释放占用格 — 地形副本由 MapData.loadLevel 重建)
   */
  reset(): void {
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
    this.levelStarted = false;
  }

  /** 金手指：立即清除当前画面上的敌人，不产生额外金币。 */
  clearAllEnemies(): void {
    for (const enemy of this.enemies) {
      this.mapData.releaseTileAtPixel(enemy.x, enemy.y);
    }
    this.enemies = [];
  }

  /** 请求首波/下一波；对应原版 g1046==35 ('#') 的条件判断。 */
  requestNextWave(): boolean {
    if (!this.canStartNextWave) return false;
    this.p1078 = true;
    return true;
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
    // 原版 b1066 是 30 个活动敌人槽位；达到上限时只暂停刷怪，
    // 等已有单位离场后再继续当前波次，避免把道路填满后永久互相阻塞。
    if (this.aT >= this.aX || this.enemies.length >= MAX_ENEMIES) return;

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
      x: sp.x,                                // [0] = b1069[aN][0]
      y: sp.y,                                // [1] = b1069[aN][1]
      hp: elite ? this.aW * 10 : this.aW,     // [2] 名将波10倍HP
      defense: this.aY,                       // [3] 原版 aY，攻击时从伤害中扣除
      goldReward: elite ? 50 : 5,             // 原版结算固定奖励，不是波次 aY
      speed: this.aZ,                         // [4]
      baseSpeed: this.aZ,
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
    };
    // 出生方向合法性兜底 (路径格 v<8 才有方向0-3)
    if (enemy.dir < 0 || enemy.dir > 3) enemy.dir = 2;

    this.enemies.push(enemy);
    this.totalSpawned++;
    // 占用出生格 a(x, y, true)
    this.mapData.occupyTileAtPixel(sp.x, sp.y);
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
      this.o1077 = (this.aS & 3) === 3; // 每第4波为名将波
      this.aR = 0;
      this.aT = 0;
      this.aS++;
      this.computeWaveParams(); // R()
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

  /**
   * 逐敌人状态机 (对应原版 X() 的 switch(var45[8]) + label122 + label117)
   */
  private updateEnemy(enemy: Enemy, index: number): void {
    // 死亡检测 (对应原版 i(int,int) 行22068: hp<=0 且状态非5/3/2 → 置死动画)
    // H5无1/2/3绕行态, 故对 WALK/SIEGE/BLOCKED 生效; CHARGE 与原版一致不检测
    if (enemy.hp <= 0 &&
        enemy.state !== EnemyState.DYING &&
        enemy.state !== EnemyState.SETTLE &&
        enemy.state !== EnemyState.CHARGE) {
      enemy.state = EnemyState.DYING;
      enemy.dieTimer = 0;
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
        this.onEnemyKilled?.(enemy.goldReward);
        // 原版: 精英死亡时清空所有敌人[26]及 ba — H5不影响逻辑, 跳过
        this.removeEnemy(index);
        return;
      }

      case EnemyState.BLOCKED: // case 7: 被堵
        this.updateDirection(enemy);
        // 原版 state 7 只暂停一个逻辑帧；位置不会被强行拉回格中心。
        // 拉回中心会把已经贴近墙边的单位推回上一格，随后反复撞墙。
        enemy.state = EnemyState.WALK;
        return;

      case EnemyState.CHARGE: // case 8: 冲城
        enemy.chargeTimer++;
        if (enemy.chargeTimer > 4) {
          // 5逻辑帧后: by(城防)-1, 移除敌人; by<=0 由 Game 判负
          this.onEnemyEscaped?.();
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

    // 状态效果跟随原版 100ms 逻辑帧计时。麻痹停止移动，冰冻/减速仅改变本帧速度。
    const effectActive = enemy.timer > 0;
    if (effectActive) enemy.timer--;
    else {
      enemy.effect = 0;
      enemy.slowScale = 1;
    }
    if (effectActive && enemy.effect === 1) return;

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
    const speedScale = effectActive && enemy.effect === 2 ? 0.5
      : (effectActive && enemy.effect === 5 ? enemy.slowScale : 1);
    const moveSpeed = enemy.baseSpeed * speedScale;
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
        return; // 位置不更新 (原版 break label117)
      }
      // 占用新格 / 释放旧格 (a(int,int,boolean) 行11058)
      this.mapData.occupyTileAtPixel(nx, ny);
      this.mapData.releaseTileAtPixel(enemy.x, enemy.y);
    }

    enemy.x = nx;
    enemy.y = ny;
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
          continue;
        case EnemyState.CHARGE:
          this.renderEffectFrame(enemy, px, py, enemy.chargeTimer);
          continue;
        case EnemyState.SIEGE:
          this.renderSiege(enemy, px, py);
          this.renderEliteMarker(enemy, px, py);
          this.renderHealthBar(enemy, px, py);
          continue;
        default:
          break;
      }

      this.renderWalking(enemy, px, py);
      this.renderHealthBar(enemy, px, py);
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
        vctx.drawImage(img, srcX, 0, srcW, srcH, 0, 0, srcW, srcH);
      } else {
        vctx.drawImage(img, srcX, 0, srcW, srcH, Math.floor(dx), Math.floor(dy), srcW, srcH);
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
      vctx.drawImage(img, srcX, 0, 21, 19, Math.floor(dx), Math.floor(dy), 21, 19);
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
      const vctx = this.renderer.virtualContext;
      vctx.drawImage(img, frame * frameW, 0, frameW, frameH,
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
      this.renderer.virtualContext.drawImage(img, frame * 22, 0, 22, 34,
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

  // ============================================================
  // 查询接口
  // ============================================================

  getActiveEnemies(): Enemy[] {
    return this.enemies;
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
