/**
 * ============================================================================
 *  模块 01: 实例字段声明
 * ============================================================================
 *
 *  原始类: a extends FullCanvas implements Runnable
 *  本模块包含: 所有实例字段声明 (约 150+ 个)
 *
 *  交叉验证: Vineflower L26-376 + javap 字段声明
 *  可靠性: ★★★★★ (三工具完全一致, javap 补充 VF 遗漏字段)
 *
 *  ★ v2 修正 (交叉验证发现):
 *    - byteArrayA1151 类型修正: int[] → byte[] (VF L30 正确为 byte[], 模块v1误标)
 *    - 补充遗漏字段: mapLayerCount(byte, VF L101), mapLayerData(int[][], VF L102),
 *      publicIntE1025(public int, VF L260), publicIntF1026(public int, VF L268)
 *      (这些字段在 VF 中存在, 但 v1 模块化时遗漏)
 *
 *  ★ v3 修正 (第二轮交叉验证发现):
 *    - 补充遗漏字段: flagQ1082(boolean, VF L334, 在 b(int,int,int) 方法中使用)
 *    - 修正错误注释: mapLayerCount/mapLayerData/publicIntE1025/publicIntF1026/at 均在 VF 中存在, 非VF遗漏
 *
 *  字段命名说明:
 *    - 保留原始混淆名 (如 ROTATION_PARAMS, gameTexts, enemySlots 等)
 *    - 每个字段附带语义注释
 *    - final 字段在构造函数中初始化
 * ============================================================================
 */

// ============================================================================
// 1. 渲染相关字段
// ============================================================================

private final Font a;                    // a: 游戏字体 Font.getFont(32,0,8)
private Graphics graphicsCtx;                  // graphicsCtx: J2ME Graphics 上下文
private Image backBufferImage;                     // backBufferImage: 双缓冲后台图像
private DirectGraphics directGraphics;            // directGraphics: Nokia DirectGraphics (旋转绘制)
private Graphics secondGraphics;                  // secondGraphics: 第二 Graphics
private DirectGraphics secondDirectGraphics;            // secondDirectGraphics: 第二 DirectGraphics
private Image logoImage;                     // logoImage: Logo图片
private Image[][] spriteImages;                 // spriteImages: 精灵图二维数组 39类×多帧
private Image[] backgroundImages;                   // backgroundImages: 背景图片数组
private byte mapLayerCount;                      // mapLayerCount: 地图层计数 (VF L101)
private int[][] mapLayerData;                   // mapLayerData: 地图层数据 (VF L102)

// ============================================================================
// 2. 字体尺寸 (final, 构造函数初始化)
// ============================================================================

private final int j;                     // j: 字体高度 gameFont.getHeight()
private final int k;                     // k: 字符宽度 gameFont.charWidth('口')
private final int n;                     // n: 行高 fontHeight + 2

// ============================================================================
// 3. 屏幕尺寸 (final, 构造函数计算)
// ============================================================================

private final int V;                     // V: 屏幕宽度 (字体高度×3+40 ≈240)
private final int W;                     // W: 屏幕高度相关
private final int ad;                    // ad: 瓦片大小 字体高度×3+40
private final int ah;                    // ah: 地图列数 字体高度×3+10+30
private final int ai;                    // ai: 地图行数 ah+40
private final int aj;                    // aj: MAP_COLS+13+10

// ============================================================================
// 4. 游戏状态字段
// ============================================================================

public int frameCounter;                        // frameCounter: 游戏状态/帧计数
public int targetFrame;                        // targetFrame: 目标帧/子状态
public long totalFrameCount;                       // totalFrameCount: 帧计数器
private String scrollTextCache;                    // scrollTextCache: 滚动文本缓存
private Random random;                    // random: 随机数生成器
private boolean isRunning;                   // isRunning: 游戏运行标志
private boolean isPaused;                   // isPaused: 暂停标志 (false=退出)
private boolean soundEnabled;                   // soundEnabled: 音效开启
private boolean musicEnabled;                   // musicEnabled: 音乐开启
private boolean vibrationEnabled;                   // vibrationEnabled: 震动开启
private boolean autoSave;                   // autoSave: 自动存档
private boolean g, h, i;                 // g,h,i: 布尔标志
private boolean flagJ1024, flagK1029, isPausedInGame;     // flagJ1024,flagK1029,isPausedInGame: 布尔标志
private boolean sceneMode;                   // sceneMode: 场景模式标志
private boolean flagN1036;                   // flagN1036: 布尔标志
private boolean isLandscape;                   // isLandscape: 横屏标志
private boolean flagT1089;                   // flagT1089: 布尔标志
private boolean isTouch;                   // isTouch: 触摸标志
private boolean flagV1097;                   // flagV1097: 布尔标志
private boolean flagW1111;                   // flagW1111: 布尔标志
private boolean flagX1126;                   // flagX1126: 布尔标志
private boolean flagY1155;                   // flagY1155: 布尔标志
private boolean flagZ1169;                   // flagZ1169: 布尔标志

// ============================================================================
// 5. 菜单/导航状态
// ============================================================================

private int l;                           // l: 当前游戏状态 (核心状态机变量)
private int m;                           // m: 菜单栈深度
private int[] b;                         // b: 菜单历史栈 int[10]
private int o;                           // o: 选中塔索引 (-1=未选中)
private int p;                           // p: 进度条宽度
private int q;                           // q: 音量值
private int r;                           // r: 敌人数量
private int s;                           // s: 帧耗时统计
private int t;                           // t: 背景偏移
private int u, v, w;                     // u,v,w: 滚动位置
private int x, y, z;                     // x,y,z: 位置/状态
private int A, B, C, D, E, F, G, H;      // A-H: 临时状态
private int I, J, K, L, M, N, O, P, Q;   // I-Q: 临时状态
private int R, S, T, U, X, Y, Z;         // R-Z: 临时状态 (注意无 V,W)

public int c;                            // c: 光标X
public int d;                            // d: 光标Y
private int[] e;                         // e: 关卡进度 int[21]
private int[] scoreHistory;                     // scoreHistory: 分数历史 int[200]

// ============================================================================
// 6. aA-cb 扩展状态变量 (约78个 int)
// ============================================================================

private int aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM, aN, aO, aP;
private int aQ, aR, aS, aT, aU, aV, aW, aX, aY, aZ;
private int aa, ab, ac, ae, af, ag, ak, al, am, an, ao, ap, aq, ar;
private int as, at, au, av, aw, ax, ay, az;
private int bA, bB, bC, bD, bE, bF, bG, bH, bI, bJ, bK, bL, bM, bN, bO, bP;
private int bQ, bR, bS, bT, bU, bV, bW, bX, bY, bZ;
private int ba, bb, bc, bd, be, bf, bg, bh, bi, bj, bk, bl, bm, bn;
private int bo, bp, bq, br, bs, bt, bu, bv, bw, bx, by, bz;
private int ca, cb;

// ============================================================================
// 7. 核心游戏数据数组 (final, 构造函数初始化)
// ============================================================================

private final int[] colorConstants;               // colorConstants: 颜色常量 [5]
private final String[] resourcePaths;            // resourcePaths: 资源文件路径 [39]
private String[] gameTexts;                  // gameTexts: 游戏文本 [181]
private final byte[][] towerBuildPaths;            // towerBuildPaths: 塔建造路径 byte[5][]
private final short[][] techTreeBranches;           // techTreeBranches: 科技树分支 short[7][]
private final byte[][] levelSequence;            // levelSequence: 关卡序列 byte[8][]
private final byte[] levelConfig;              // levelConfig: 关卡配置 byte[9]
private final byte[] towerLevelLimits;              // towerLevelLimits: 塔等级限制 byte[17]
private final byte[] upgradeCosts;              // upgradeCosts: 升级费用 byte[5]
private final byte[] levelSpawnPoints;              // levelSpawnPoints: 每关生成点 byte[11]
private final byte[] multiPathFlags;              // multiPathFlags: 多路径标志 byte[11]
private final byte[] killRewards;              // killRewards: 击杀奖励 byte[11]
private final byte[] enemyHpCoeffs;              // enemyHpCoeffs: 敌人HP系数 byte[22]
private final byte[] altHpCoeffs;              // altHpCoeffs: 备用HP系数 byte[22]
private final byte[] towerDamageRange;              // towerDamageRange: 塔伤害/射程 byte[22]
private final byte[] towerAtkSpeed;              // towerAtkSpeed: 塔攻速/效果 byte[22]
private final byte[] towerInitLevels;              // towerInitLevels: 塔初始等级 byte[5]
private final byte[] encryptKey;              // encryptKey: 加密密钥 byte[8]
private final byte[][][] enemyPathAnim;          // enemyPathAnim: 敌人路径动画 byte[11][][]
private final byte[] xOffsetTable;              // xOffsetTable: X偏移表 byte[10]
private final byte[] yOffsetTable;              // yOffsetTable: Y偏移表 byte[16]
private final byte[][] directionVectors;            // directionVectors: 方向向量 byte[4][]
private final byte[][] generalSortOrder;            // generalSortOrder: 武将排序 byte[3][]
private final int[] f;                   // f: 精灵帧数 int[39]
private final int[] tangentTable;               // tangentTable: 正切表 (角度计算用)
private final int[] intArrayK1071;               // intArrayK1071: int数组
private final int[] intArrayL1116;               // intArrayL1116: int数组
private final int[] intArrayQ1158;               // intArrayQ1158: int数组
private final int[] intArrayR1166;               // intArrayR1166: int数组
private final int[] intArrayS1167;               // intArrayS1167: int数组
private final int[] intArrayT1168;               // intArrayT1168: int数组
private final byte[] byteArrayA1151;              // byteArrayA1151: byte数组 (VF L30 正确为 byte[], v1模块误标为 int[])
private final short[][] shortArray2DB1069;           // shortArray2DB1069: short二维数组
private final short[][] shortArray2DC1070;           // shortArray2DC1070: short二维数组

// ============================================================================
// 8. 地图/精灵三维数组 (final, 构造函数初始化)
// ============================================================================

private final byte[] tileDataA0;              // tileDataA0: 瓦片数据A0
private final byte[][] tileDataA2D;            // tileDataA2D: 瓦片数据A2D
private final byte[] tileDataB0;              // tileDataB0: 瓦片数据B0
private final byte[][] tileDataB2D;            // tileDataB2D: 瓦片数据B2D
private final byte[] tileDataC0;              // tileDataC0: 瓦片数据C0
private final byte[] tileDataD0;              // tileDataD0: 瓦片数据D0
private final byte[] tileDataH0;              // tileDataH0: 瓦片数据H0
private final byte[] tileDataI0;              // tileDataI0: 瓦片数据I0
private final byte[] tileDataJ0;              // tileDataJ0: 瓦片数据J0
private final byte[] tileDataK0;              // tileDataK0: 瓦片数据K0
private final byte[] tileDataL0;              // tileDataL0: 瓦片数据L0
private final byte[] tileDataM0;              // tileDataM0: 瓦片数据M0
private final byte[] tileDataN0;              // tileDataN0: 瓦片数据N0
private final byte[] tileDataZ0;              // tileDataZ0: 瓦片数据Z0
private byte[] tileDataB;                    // tileDataB: 瓦片数据B (可变)
private byte[] tileDataC;                    // tileDataC: 瓦片数据C (可变)
private byte[] tileDataD;                    // tileDataD: 瓦片数据D (可变, 建造时修改)
private byte[] tileProperties;                    // tileProperties: 瓦片属性 (可变, 类型检查)
private byte[] tileDataF;                    // tileDataF: 瓦片数据F (可变)
private byte[] tileDataG;                    // tileDataG: 瓦片数据G (可变)
private byte[] httpPostData;                    // httpPostData: HTTP POST数据 (可变)
private byte[] httpResponseData;                    // httpResponseData: HTTP响应数据 (可变)

private final byte[][] levelDataA;            // levelDataA: 关卡数据A
private final byte[][] levelDataB;            // levelDataB: 关卡数据B
private byte[][] levelDataC;                  // levelDataC: 关卡数据C (可变)
private final byte[][] levelDataD;            // levelDataD: 关卡数据D
private final byte[][] levelDataE;            // levelDataE: 关卡数据E
private final byte[][] levelDataF;            // levelDataF: 关卡数据F
private final byte[][] levelDataG;            // levelDataG: 关卡数据G
private final byte[][] levelDataH;            // levelDataH: 关卡数据H
private final byte[][] levelDataI;            // levelDataI: 关卡数据I
private final byte[][] levelDataJ;            // levelDataJ: 关卡数据J
private final byte[][] levelDataK;            // levelDataK: 关卡数据K
private final byte[][] levelDataL;            // levelDataL: 关卡数据L
private final byte[][] levelDataM;            // levelDataM: 关卡数据M
private final byte[][] levelDataN;            // levelDataN: 关卡数据N
private final byte[][] levelDataO;            // levelDataO: 关卡数据O
private final byte[][] levelDataP;            // levelDataP: 关卡数据P
private final byte[][] levelDataQ;            // levelDataQ: 关卡数据Q
private final byte[][] levelDataZ;            // levelDataZ: 关卡数据Z
private final byte[][] byteArray2DE1058;            // byteArray2DE1058: byte二维数组
private final byte[][] byteArray2DF1063;            // byteArray2DF1063: byte二维数组
private final byte[][] byteArray2DG1065;            // byteArray2DG1065: byte二维数组
private final byte[][] generalSelectData;            // generalSelectData: 武将选择数据
private final byte[][] byteArray2DI1079;            // byteArray2DI1079: byte二维数组
private final byte[][] byteArray2DJ1080;            // byteArray2DJ1080: byte二维数组
private final byte[][] byteArray2DK1081;            // byteArray2DK1081: byte二维数组
private final byte[][] byteArray2DL1083;            // byteArray2DL1083: byte二维数组
private final byte[][] byteArray2DN1094;            // byteArray2DN1094: byte二维数组
private final byte[][] byteArray2DO1095;            // byteArray2DO1095: byte二维数组
private final byte[][] byteArray2DP1108;            // byteArray2DP1108: byte二维数组
private final byte[][] byteArray2DQ1114;            // byteArray2DQ1114: byte二维数组
private final byte[][] byteArray2DR1115;            // byteArray2DR1115: byte二维数组
private final byte[][] byteArray2DS1117;            // byteArray2DS1117: byte二维数组
private final byte[][] byteArray2DT1118;            // byteArray2DT1118: byte二维数组
private final byte[][] byteArray2DU1119;            // byteArray2DU1119: byte二维数组
private final byte[][] byteArray2DV1120;            // byteArray2DV1120: byte二维数组

private final byte[][][] mapDataA;          // mapDataA: 地图数据A
private final byte[][][] mapDataB;          // mapDataB: 地图数据B
private final byte[][][] mapDataC;          // mapDataC: 地图数据C
private final byte[][][] mapDataD;          // mapDataD: 地图数据D
private final byte[][][] mapDataE;          // mapDataE: 地图数据E
private final byte[][][] mapDataF;          // mapDataF: 地图数据F
private final byte[][][] mapDataG;          // mapDataG: 地图数据G
private final byte[][][] mapDataH;          // mapDataH: 地图数据H
private final byte[][][] spriteOffsets;          // spriteOffsets: 精灵图偏移
private final byte[][][] mapDataJ;          // mapDataJ: 地图数据J
private final byte[][][] mapDataK;          // mapDataK: 地图数据K
private final byte[][][] mapDataL;          // mapDataL: 地图数据L
private final byte[][][] mapDataM;          // mapDataM: 地图数据M
private final short[][][][] shortArray4D;       // shortArray4D: 四维short数组

// ============================================================================
// 9. 布尔状态标志数组
// ============================================================================

private final boolean[] unlockFlags;           // unlockFlags: 解锁标志 [5]
private boolean[] levelFlags;                 // levelFlags: 关卡标志
private boolean[] levelCompleted;                 // levelCompleted: 关卡完成 [11]
private boolean[] levelUnlocked;                 // levelUnlocked: 关卡解锁 [11]
private boolean[] techUnlocked;                 // techUnlocked: 科技解锁 [5]
private boolean[] generalAwakened;                 // generalAwakened: 武将觉醒
private boolean[][] buildableFlags;               // buildableFlags: 可建造标志 (二维)
private boolean flagA1170, threadRunning, needRestore, useProxy;
private boolean initialized, hasFactionName, hasLevelName;

// ============================================================================
// 10. 武将/科技/文本字段
// ============================================================================

private short[] techLevels;                   // techLevels: 科技等级
private final String[] generalNames;            // generalNames: 武将名
private String menuTitle;                    // menuTitle: 菜单标题
private String currentGeneralName;                    // currentGeneralName: 当前武将名
private String factionName;                    // factionName: 阵营名
private String levelName;                    // levelName: 关卡名
private String statusMessage;                    // statusMessage: 状态消息/URL
private String redirectUrl;                    // redirectUrl: 武将语音
private String errorMessage;                    // errorMessage: 错误消息

// ============================================================================
// 11. 音频字段
// ============================================================================

private InputStream[] midiInputStreams;             // midiInputStreams: MIDI 输入流
private Player[] midiPlayers;                  // midiPlayers: MIDI 播放器
private VolumeControl volumeControl;             // volumeControl: 音量控制
private int[] midiPlayerState;                     // midiPlayerState: MIDI 播放器状态
private int[] intArrayG1035;                     // intArrayG1035: int数组
private int[] intArrayI1044;                     // intArrayI1044: int数组

// ============================================================================
// 12. 网络/存档字段
// ============================================================================

public HttpConnection httpConnection;             // httpConnection: HTTP连接 (上传分数)
private ByteArrayOutputStream saveBuffer;     // saveBuffer: 存档缓冲区
private Object syncLock;                    // syncLock: 同步锁对象
private Date saveDate;                      // saveDate: 存档日期
private Calendar calendar;                  // calendar: 日历
private byte notifyStatus;                      // notifyStatus: 显示通知状态
private byte httpMethod;                      // httpMethod: 游戏模式 (1=GET,2=POST)
private int[] intArrayM1129;                     // intArrayM1129: int数组
private int[] renderData;                     // renderData: 渲染数据
private int[] activeTowerIndices;                     // activeTowerIndices: 塔索引数组
private int[] intArrayP1154;                     // intArrayP1154: int数组

// ============================================================================
// 13. 敌人/塔槽位 (运行时修改)
// ============================================================================

private int[][] enemySlots;                   // enemySlots: 敌人槽位 int[30][18]
private int[][] towerSlots;                   // towerSlots: 塔槽位
private byte[][] directionMatrix;                  // directionMatrix: 方向向量矩阵
private boolean levelAdvanceFlag;                   // levelAdvanceFlag: 关卡推进标志
private boolean victoryFlag;                   // victoryFlag: 胜利标志
private boolean flagQ1082;                   // flagQ1082: 布尔标志 (VF L334, 在 b(int,int,int) 中使用)
private boolean renderFlag;                   // renderFlag: 渲染标志

// ============================================================================
// 14. 输入字段
// ============================================================================

public int currentKeyCode;                        // currentKeyCode: 当前按键码
public int keyState;                        // keyState: 按键状态
public int keyRepeatCount;                        // keyRepeatCount: 连按计数 (-1=已释放)
public int publicIntE1025;                        // publicIntE1025: 公开int字段 (VF L260)
public int publicIntF1026;                        // publicIntF1026: 公开int字段 (VF L268)
