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
 *    - A1151 类型修正: int[] → byte[] (VF L30 正确为 byte[], 模块v1误标)
 *    - 补充遗漏字段: a1038(byte, VF L101), a1039(int[][], VF L102),
 *      e1025(public int, VF L260), f1026(public int, VF L268)
 *      (这些字段在 VF 中存在, 但 v1 模块化时遗漏)
 *
 *  ★ v3 修正 (第二轮交叉验证发现):
 *    - 补充遗漏字段: q1082(boolean, VF L334, 在 b(int,int,int) 方法中使用)
 *    - 修正错误注释: a1038/a1039/e1025/f1026/at 均在 VF 中存在, 非VF遗漏
 *
 *  字段命名说明:
 *    - 保留原始混淆名 (如 a1001, b1015, c1107 等)
 *    - 每个字段附带语义注释
 *    - final 字段在构造函数中初始化
 * ============================================================================
 */

// ============================================================================
// 1. 渲染相关字段
// ============================================================================

private final Font a;                    // a: 游戏字体 Font.getFont(32,0,8)
private Graphics a1002;                  // a1002: J2ME Graphics 上下文
private Image a1004;                     // a1004: 双缓冲后台图像
private DirectGraphics a1005;            // a1005: Nokia DirectGraphics (旋转绘制)
private Graphics b1003;                  // b1003: 第二 Graphics
private DirectGraphics b1006;            // b1006: 第二 DirectGraphics
private Image b1032;                     // b1032: Logo图片
private Image[][] a1013;                 // a1013: 精灵图二维数组 39类×多帧
private Image[] a1040;                   // a1040: 背景图片数组
private byte a1038;                      // a1038: 地图层计数 (VF L101)
private int[][] a1039;                   // a1039: 地图层数据 (VF L102)

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

public int a1007;                        // a1007: 游戏状态/帧计数
public int b1008;                        // b1008: 目标帧/子状态
public long a1019;                       // a1019: 帧计数器
private String a1009;                    // a1009: 滚动文本缓存
private Random a1012;                    // a1012: 随机数生成器
private boolean a1016;                   // a1016: 游戏运行标志
private boolean b1018;                   // b1018: 暂停标志 (false=退出)
private boolean c1020;                   // c1020: 音效开启
private boolean d1021;                   // d1021: 音乐开启
private boolean e1022;                   // e1022: 震动开启
private boolean f1023;                   // f1023: 自动存档
private boolean g, h, i;                 // g,h,i: 布尔标志
private boolean j1024, k1029, l1031;     // j1024,k1029,l1031: 布尔标志
private boolean m1033;                   // m1033: 场景模式标志
private boolean n1036;                   // n1036: 布尔标志
private boolean s1088;                   // s1088: 横屏标志
private boolean t1089;                   // t1089: 布尔标志
private boolean u1096;                   // u1096: 触摸标志
private boolean v1097;                   // v1097: 布尔标志
private boolean w1111;                   // w1111: 布尔标志
private boolean x1126;                   // x1126: 布尔标志
private boolean y1155;                   // y1155: 布尔标志
private boolean z1169;                   // z1169: 布尔标志

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
private int[] c1010;                     // c1010: 分数历史 int[200]

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

private final int[] d1011;               // d1011: 颜色常量 [5]
private final String[] a1014;            // a1014: 资源文件路径 [39]
private String[] b1015;                  // b1015: 游戏文本 [181]
private final byte[][] c1051;            // c1051: 塔建造路径 byte[5][]
private final short[][] a1052;           // a1052: 科技树分支 short[7][]
private final byte[][] d1053;            // d1053: 关卡序列 byte[8][]
private final byte[] e1054;              // e1054: 关卡配置 byte[9]
private final byte[] f1055;              // f1055: 塔等级限制 byte[17]
private final byte[] g1057;              // g1057: 升级费用 byte[5]
private final byte[] o1098;              // o1098: 每关生成点 byte[11]
private final byte[] p1099;              // p1099: 多路径标志 byte[11]
private final byte[] q1100;              // q1100: 击杀奖励 byte[11]
private final byte[] r1101;              // r1101: 敌人HP系数 byte[22]
private final byte[] s1102;              // s1102: 备用HP系数 byte[22]
private final byte[] t1103;              // t1103: 塔伤害/射程 byte[22]
private final byte[] u1104;              // u1104: 塔攻速/效果 byte[22]
private final byte[] v1109;              // v1109: 塔初始等级 byte[5]
private final byte[] w1110;              // w1110: 加密密钥 byte[8]
private final byte[][][] w1123;          // w1123: 敌人路径动画 byte[11][][]
private final byte[] x1124;              // x1124: X偏移表 byte[10]
private final byte[] y1125;              // y1125: Y偏移表 byte[16]
private final byte[][] x1128;            // x1128: 方向向量 byte[4][]
private final byte[][] y1130;            // y1130: 武将排序 byte[3][]
private final int[] f;                   // f: 精灵帧数 int[39]
private final int[] j1049;               // j1049: 正切表 (角度计算用)
private final int[] k1071;               // k1071: int数组
private final int[] l1116;               // l1116: int数组
private final int[] q1158;               // q1158: int数组
private final int[] r1166;               // r1166: int数组
private final int[] s1167;               // s1167: int数组
private final int[] t1168;               // t1168: int数组
private final byte[] A1151;              // A1151: byte数组 (VF L30 正确为 byte[], v1模块误标为 int[])
private final short[][] b1069;           // b1069: short二维数组
private final short[][] c1070;           // c1070: short二维数组

// ============================================================================
// 8. 地图/精灵三维数组 (final, 构造函数初始化)
// ============================================================================

private final byte[] a1027;              // a1027: 瓦片数据A0
private final byte[][] a1028;            // a1028: 瓦片数据A2D
private final byte[] b1034;              // b1034: 瓦片数据B0
private final byte[][] b1030;            // b1030: 瓦片数据B2D
private final byte[] c1037;              // c1037: 瓦片数据C0
private final byte[] d1050;              // d1050: 瓦片数据D0
private final byte[] h1060;              // h1060: 瓦片数据H0
private final byte[] i1062;              // i1062: 瓦片数据I0
private final byte[] j1064;              // j1064: 瓦片数据J0
private final byte[] k1068;              // k1068: 瓦片数据K0
private final byte[] l1072;              // l1072: 瓦片数据L0
private final byte[] m1075;              // m1075: 瓦片数据M0
private final byte[] n1076;              // n1076: 瓦片数据N0
private final byte[] z1148;              // z1148: 瓦片数据Z0
private byte[] B1160;                    // B1160: 瓦片数据B (可变)
private byte[] C1161;                    // C1161: 瓦片数据C (可变)
private byte[] D1162;                    // D1162: 瓦片数据D (可变, 建造时修改)
private byte[] E1163;                    // E1163: 瓦片属性 (可变, 类型检查)
private byte[] F1164;                    // F1164: 瓦片数据F (可变)
private byte[] G1165;                    // G1165: 瓦片数据G (可变)
private byte[] H1188;                    // H1188: HTTP POST数据 (可变)
private byte[] I1189;                    // I1189: HTTP响应数据 (可变)

private final byte[][] A1132;            // A1132: 关卡数据A
private final byte[][] B1133;            // B1133: 关卡数据B
private byte[][] C1134;                  // C1134: 关卡数据C (可变)
private final byte[][] D1135;            // D1135: 关卡数据D
private final byte[][] E1136;            // E1136: 关卡数据E
private final byte[][] F1137;            // F1137: 关卡数据F
private final byte[][] G1138;            // G1138: 关卡数据G
private final byte[][] H1140;            // H1140: 关卡数据H
private final byte[][] I1142;            // I1142: 关卡数据I
private final byte[][] J1144;            // J1144: 关卡数据J
private final byte[][] K1145;            // K1145: 关卡数据K
private final byte[][] L1146;            // L1146: 关卡数据L
private final byte[][] M1147;            // M1147: 关卡数据M
private final byte[][] N1149;            // N1149: 关卡数据N
private final byte[][] O1156;            // O1156: 关卡数据O
private final byte[][] P1157;            // P1157: 关卡数据P
private final byte[][] Q1159;            // Q1159: 关卡数据Q
private final byte[][] z1131;            // z1131: 关卡数据Z
private final byte[][] e1058;            // e1058: byte二维数组
private final byte[][] f1063;            // f1063: byte二维数组
private final byte[][] g1065;            // g1065: byte二维数组
private final byte[][] h1074;            // h1074: 武将选择数据
private final byte[][] i1079;            // i1079: byte二维数组
private final byte[][] j1080;            // j1080: byte二维数组
private final byte[][] k1081;            // k1081: byte二维数组
private final byte[][] l1083;            // l1083: byte二维数组
private final byte[][] n1094;            // n1094: byte二维数组
private final byte[][] o1095;            // o1095: byte二维数组
private final byte[][] p1108;            // p1108: byte二维数组
private final byte[][] q1114;            // q1114: byte二维数组
private final byte[][] r1115;            // r1115: byte二维数组
private final byte[][] s1117;            // s1117: byte二维数组
private final byte[][] t1118;            // t1118: byte二维数组
private final byte[][] u1119;            // u1119: byte二维数组
private final byte[][] v1120;            // v1120: byte二维数组

private final byte[][][] a1067;          // a1067: 地图数据A
private final byte[][][] b1085;          // b1085: 地图数据B
private final byte[][][] c1090;          // c1090: 地图数据C
private final byte[][][] d1091;          // d1091: 地图数据D
private final byte[][][] e1093;          // e1093: 地图数据E
private final byte[][][] f1112;          // f1112: 地图数据F
private final byte[][][] g1113;          // g1113: 地图数据G
private final byte[][][] h1121;          // h1121: 地图数据H
private final byte[][][] i1122;          // i1122: 精灵图偏移
private final byte[][][] j1139;          // j1139: 地图数据J
private final byte[][][] k1141;          // k1141: 地图数据K
private final byte[][][] l1143;          // l1143: 地图数据L
private final byte[][][] m1150;          // m1150: 地图数据M
private final short[][][][] a1092;       // a1092: 四维short数组

// ============================================================================
// 9. 布尔状态标志数组
// ============================================================================

private final boolean[] c1061;           // c1061: 解锁标志 [5]
private boolean[] d1073;                 // d1073: 关卡标志
private boolean[] e1105;                 // e1105: 关卡完成 [11]
private boolean[] f1106;                 // f1106: 关卡解锁 [11]
private boolean[] a1056;                 // a1056: 科技解锁 [5]
private boolean[] b1059;                 // b1059: 武将觉醒
private boolean[][] a1127;               // a1127: 可建造标志 (二维)
private boolean A1170, B1171, C1175, D1176;
private boolean E1179, F1180, G1182;

// ============================================================================
// 10. 武将/科技/文本字段
// ============================================================================

private short[] a1087;                   // a1087: 科技等级
private final String[] d1173;            // d1173: 武将名
private String b1177;                    // b1177: 菜单标题
private String c1178;                    // c1178: 当前武将名
private String d1181;                    // d1181: 阵营名
private String e1183;                    // e1183: 关卡名
private String f1186;                    // f1186: 状态消息/URL
private String g1187;                    // g1187: 武将语音
private String h1192;                    // h1192: 错误消息

// ============================================================================
// 11. 音频字段
// ============================================================================

private InputStream[] a1042;             // a1042: MIDI 输入流
private Player[] a1043;                  // a1043: MIDI 播放器
private VolumeControl a1017;             // a1017: 音量控制
private int[] h1041;                     // h1041: MIDI 播放器状态
private int[] g1035;                     // g1035: int数组
private int[] i1044;                     // i1044: int数组

// ============================================================================
// 12. 网络/存档字段
// ============================================================================

public HttpConnection a1193;             // a1193: HTTP连接 (上传分数)
private ByteArrayOutputStream a1191;     // a1191: 存档缓冲区
private Object a1172;                    // a1172: 同步锁对象
private Date a1184;                      // a1184: 存档日期
private Calendar a1185;                  // a1185: 日历
private byte b1174;                      // b1174: 显示通知状态
private byte c1190;                      // c1190: 游戏模式 (1=GET,2=POST)
private int[] m1129;                     // m1129: int数组
private int[] n1152;                     // n1152: 渲染数据
private int[] o1153;                     // o1153: 塔索引数组
private int[] p1154;                     // p1154: int数组

// ============================================================================
// 13. 敌人/塔槽位 (运行时修改)
// ============================================================================

private int[][] c1107;                   // c1107: 敌人槽位 int[30][18]
private int[][] b1066;                   // b1066: 塔槽位
private byte[][] m1084;                  // m1084: 方向向量矩阵
private boolean o1077;                   // o1077: 关卡推进标志
private boolean p1078;                   // p1078: 胜利标志
private boolean q1082;                   // q1082: 布尔标志 (VF L334, 在 b(int,int,int) 中使用)
private boolean r1086;                   // r1086: 渲染标志

// ============================================================================
// 14. 输入字段
// ============================================================================

public int g1046;                        // g1046: 当前按键码
public int h1047;                        // h1047: 按键状态
public int i1048;                        // i1048: 连按计数 (-1=已释放)
public int e1025;                        // e1025: 公开int字段 (VF L260)
public int f1026;                        // f1026: 公开int字段 (VF L268)
