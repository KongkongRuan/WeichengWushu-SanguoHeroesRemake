import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import com.nokia.mid.ui.FullCanvas;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreNotFoundException;

public final class a extends FullCanvas implements Runnable {
   public static final int[] a1001;
   private static String[] c1045;
   private int A;
   private final byte[][] A1132;
   private final byte[] A1151;
   private boolean A1170;
   private int B;
   private final byte[][] B1133;
   private byte[] B1160;
   private boolean B1171;
   private int C;
   private byte[][] C1134;
   private byte[] C1161;
   private boolean C1175;
   private int D;
   private final byte[][] D1135;
   private byte[] D1162;
   private boolean D1176;
   private int E;
   private final byte[][] E1136;
   private byte[] E1163;
   private boolean E1179;
   private int F;
   private final byte[][] F1137;
   private byte[] F1164;
   private boolean F1180;
   private int G;
   private final byte[][] G1138;
   private byte[] G1165;
   private boolean G1182;
   private int H;
   private final byte[][] H1140;
   private byte[] H1188;
   private int I;
   private final byte[][] I1142;
   private byte[] I1189;
   private int J;
   private final byte[][] J1144;
   private int K;
   private final byte[][] K1145;
   private int L;
   private final byte[][] L1146;
   private int M;
   private final byte[][] M1147;
   private int N;
   private final byte[][] N1149;
   private int O;
   private final byte[][] O1156;
   private int P;
   private final byte[][] P1157;
   private int Q;
   private final byte[][] Q1159;
   private int R;
   private int S;
   private int T;
   private int U;
   private final int V;
   private final int W;
   private int X;
   private int Y;
   private int Z;
   private final Font a;
   private Graphics a1002;
   private Image a1004;
   private DirectGraphics a1005;
   public int a1007;
   private String a1009;
   private Random a1012;
   private Image[][] a1013;
   private final String[] a1014;
   private boolean a1016;
   private VolumeControl a1017;
   public long a1019;
   private final byte[] a1027;
   private final byte[][] a1028;
   private byte a1038;
   private int[][] a1039;
   private Image[] a1040;
   private InputStream[] a1042;
   private Player[] a1043;
   private final short[][] a1052;
   private boolean[] a1056;
   private final byte[][][] a1067;
   private short[] a1087;
   private final short[][][][] a1092;
   private boolean[][] a1127;
   private Object a1172;
   private Date a1184;
   private Calendar a1185;
   private ByteArrayOutputStream a1191;
   public HttpConnection a1193;
   private int aA;
   private int aB;
   private int aC;
   private int aD;
   private int aE;
   private int aF;
   private int aG;
   private int aH;
   private int aI;
   private int aJ;
   private int aK;
   private int aL;
   private int aM;
   private int aN;
   private int aO;
   private int aP;
   private int aQ;
   private int aR;
   private int aS;
   private int aT;
   private int aU;
   private int aV;
   private int aW;
   private int aX;
   private int aY;
   private int aZ;
   private int aa;
   private int ab;
   private int ac;
   private final int ad;
   private int ae;
   private int af;
   private int ag;
   private final int ah;
   private final int ai;
   private final int aj;
   private int ak;
   private int al;
   private int am;
   private int an;
   private int ao;
   private int ap;
   private int aq;
   private int ar;
   private int as;
   private int at;
   private int au;
   private int av;
   private int aw;
   private int ax;
   private int ay;
   private int az;
   private int[] b;
   private Graphics b1003;
   private DirectGraphics b1006;
   public int b1008;
   private String[] b1015;
   private boolean b1018;
   private final byte[][] b1030;
   private Image b1032;
   private final byte[] b1034;
   private boolean[] b1059;
   private int[][] b1066;
   private final short[][] b1069;
   private final byte[][][] b1085;
   private byte b1174;
   private String b1177;
   private int bA;
   private int bB;
   private int bC;
   private int bD;
   private int bE;
   private int bF;
   private int bG;
   private int bH;
   private int bI;
   private int bJ;
   private int bK;
   private int bL;
   private int bM;
   private int bN;
   private int bO;
   private int bP;
   private int bQ;
   private int bR;
   private int bS;
   private int bT;
   private int bU;
   private int bV;
   private int bW;
   private int bX;
   private int bY;
   private int bZ;
   private int ba;
   private int bb;
   private int bc;
   private int bd;
   private int be;
   private int bf;
   private int bg;
   private int bh;
   private int bi;
   private int bj;
   private int bk;
   private int bl;
   private int bm;
   private int bn;
   private int bo;
   private int bp;
   private int bq;
   private int br;
   private int bs;
   private int bt;
   private int bu;
   private int bv;
   private int bw;
   private int bx;
   private int by;
   private int bz;
   public int c;
   private int[] c1010;
   private boolean c1020;
   private final byte[] c1037;
   private final byte[][] c1051;
   private final boolean[] c1061;
   private final short[][] c1070;
   private final byte[][][] c1090;
   private int[][] c1107;
   private String c1178;
   private byte c1190;
   private int ca;
   private int cb;
   public int d;
   private final int[] d1011;
   private boolean d1021;
   private final byte[] d1050;
   private final byte[][] d1053;
   private boolean[] d1073;
   private final byte[][][] d1091;
   private final String[] d1173;
   private String d1181;
   private int[] e;
   private boolean e1022;
   public int e1025;
   private final byte[] e1054;
   private final byte[][] e1058;
   private final byte[][][] e1093;
   private boolean[] e1105;
   private String e1183;
   private final int[] f;
   private boolean f1023;
   public int f1026;
   private final byte[] f1055;
   private final byte[][] f1063;
   private boolean[] f1106;
   private final byte[][][] f1112;
   private String f1186;
   private boolean g;
   private int[] g1035;
   public int g1046;
   private final byte[] g1057;
   private final byte[][] g1065;
   private final byte[][][] g1113;
   private String g1187;
   private boolean h;
   private int[] h1041;
   public int h1047;
   private final byte[] h1060;
   private final byte[][] h1074;
   private final byte[][][] h1121;
   private String h1192;
   private boolean i;
   private int[] i1044;
   public int i1048;
   private final byte[] i1062;
   private final byte[][] i1079;
   private final byte[][][] i1122;
   private final int j;
   private boolean j1024;
   private final int[] j1049;
   private final byte[] j1064;
   private final byte[][] j1080;
   private final byte[][][] j1139;
   private final int k;
   private boolean k1029;
   private final byte[] k1068;
   private final int[] k1071;
   private final byte[][] k1081;
   private final byte[][][] k1141;
   private int l;
   private boolean l1031;
   private final byte[] l1072;
   private final byte[][] l1083;
   private final int[] l1116;
   private final byte[][][] l1143;
   private int m;
   private boolean m1033;
   private final byte[] m1075;
   private byte[][] m1084;
   private int[] m1129;
   private final byte[][][] m1150;
   private final int n;
   private boolean n1036;
   private final byte[] n1076;
   private final byte[][] n1094;
   private int[] n1152;
   private int o;
   private boolean o1077;
   private final byte[][] o1095;
   private final byte[] o1098;
   private int[] o1153;
   private int p;
   private boolean p1078;
   private final byte[] p1099;
   private final byte[][] p1108;
   private int[] p1154;
   private int q;
   private boolean q1082;
   private final byte[] q1100;
   private final byte[][] q1114;
   private final int[] q1158;
   private int r;
   private boolean r1086;
   private final byte[] r1101;
   private final byte[][] r1115;
   private final int[] r1166;
   private int s;
   private boolean s1088;
   private final byte[] s1102;
   private final byte[][] s1117;
   private final int[] s1167;
   private int t;
   private boolean t1089;
   private final byte[] t1103;
   private final byte[][] t1118;
   private final int[] t1168;
   private int u;
   private boolean u1096;
   private final byte[] u1104;
   private final byte[][] u1119;
   private int v;
   private boolean v1097;
   private final byte[] v1109;
   private final byte[][] v1120;
   private int w;
   private final byte[] w1110;
   private boolean w1111;
   private final byte[][] w1123;
   private int x;
   private final byte[] x1124;
   private boolean x1126;
   private final byte[][] x1128;
   private int y;
   private final byte[] y1125;
   private final byte[][] y1130;
   private boolean y1155;
   private int z;
   private final byte[][] z1131;
   private final byte[] z1148;
   private boolean z1169;

   static {
      byte var0 = 8;
      int[] var1 = new int[var0];
      var1[0] = 0;
      var1[1] = 8192;
      var1[2] = 16384;
      var1[3] = 24576;
      var1[4] = 8462;
      var1[5] = 270;
      var1[6] = 90;
      var1[7] = 8282;
      a1001 = var1;
      String[] var2 = new String[15];
      var2[0] = "/0.mid";
      var2[1] = "/1.mid";
      var2[2] = "/2.mid";
      var2[3] = "/3.mid";
      var2[4] = "/4.mid";
      var2[5] = "/5.mid";
      var2[6] = "/6.mid";
      var2[7] = "/7.mid";
      var2[var0] = "/8.mid";
      var2[9] = "/9.mid";
      var2[10] = "/10.mid";
      var2[11] = "/11.mid";
      var2[12] = "/12.mid";
      var2[13] = "/13.mid";
      var2[14] = "/14.mid";
      c1045 = var2;
   }

   public a() {
      byte var1 = 4;
      byte var2 = 1;
      byte var3 = 3;
      byte var4 = 2;
      super();
      Font var5 = Font.getFont(32, 0, 8);
      this.a = var5;
      int var6 = this.a.getHeight();
      this.j = var6;
      var6 = this.a.charWidth('口');
      this.k = var6;
      this.l = 0;
      int[] var12 = new int[10];
      this.b = var12;
      this.m = 0;
      this.a1007 = 0;
      this.c = 0;
      var6 = this.j + 2;
      this.n = var6;
      this.a1009 = "";
      int[] var13 = new int[200];
      this.c1010 = var13;
      int[] var14 = new int[]{6305566, 32260, 255, 13516032, 9240762};
      this.d1011 = var14;
      int[] var15 = new int[21];
      this.e = var15;
      Image[][] var16 = new Image[39][];
      this.a1013 = var16;
      int[] var17 = new int[]{12, 8, 2, 30, 26, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 2, 6, 1, 2, 2, 1, 3, 1, 1, 3, 2, 1, 48, 1, 10, 48, 6, 1, 1, 1, 1, 7};
      this.f = var17;
      String[] var18 = new String[39];
      var18[0] = "/mu";
      var18[var2] = "/sflogo";
      var18[var4] = "/ld";
      var18[var3] = "/ui";
      var18[var1] = "/back";
      var18[5] = "/map0";
      var18[6] = "/map1";
      var18[7] = "/map2";
      var18[8] = "/map3";
      var18[9] = "/map4";
      var18[10] = "/map5";
      var18[11] = "/map6";
      var18[12] = "/e0";
      var18[13] = "/e1";
      var18[14] = "/e2";
      var18[15] = "/e3";
      var18[16] = "/e4";
      var18[17] = "/e5";
      var18[18] = "/t0";
      var18[19] = "/t1";
      var18[20] = "/t2";
      var18[21] = "/t3";
      var18[22] = "/t4";
      var18[23] = "/t5";
      var18[24] = "/t6";
      var18[25] = "/t7";
      var18[26] = "/t8";
      var18[27] = "/t9";
      var18[28] = "/t10";
      var18[29] = "/bu";
      var18[30] = "/s";
      var18[31] = "/h";
      var18[32] = "/sp";
      var18[33] = "/end";
      var18[34] = "/sp0";
      var18[35] = "/sp1";
      var18[36] = "/sp2";
      var18[37] = "/sp3";
      var18[38] = "/eff";
      this.a1014 = var18;
      String[] var19 = new String[181];
      var19[0] = "游戏描述:\n想试试看三国守城是多么激烈？百名攻城名将对守城忠臣！长坂，赤壁，夷陵等历史战役等您参加，步兵，骑兵，重装兵等顽敌向您冲来，擂木，投石，断龙闸等武器供您挑选，洪水，放火，奇门遁甲等妙计信手拈来！我方城池遭到地方城池中蜂拥而出敌兵的侵扰，为了抵御不断的入侵，我方在敌兵入侵我方城池的并经之路上修建防御火力予以阻击，消灭不断赶来意图攻陷我方城池的敌兵。游戏中会出现大量三国时候的工程防御武器供玩家建造，诸如断龙闸等。如何充分利用有利地形建造更多的防御武器抵御来犯的敌兵，一场斗志斗勇的城池保卫战就此展开。\n游戏规则：\n敌兵按固定路线前进，玩家沿途制造攻击障碍设施阻止其到终点－－我方镇守的城池，一定数量的敌兵涌入我方城池，玩家失败。敌兵分批从敌城出发，玩家每消灭一个敌兵获得一些金，用金可以在我方城池中营建各式各样科技建筑，凭借科技建筑可以在敌兵来犯的沿途修建各式各样的工程防御武器，对防御武器的升级可以增强它们的威力，以应对越来越多敌兵的入侵。\n游戏操作：\n左功能键/导航键中：确认选择/游戏中建造单位\n右功能键：返回/游戏中调出菜单\n数字键5：游戏中调出单位建造菜单\n导航键上下左右/数字键2、4、6、8：选择菜单/游戏中控制建造单位地点、方向";
      var19[var2] = "版权所有：\n上海雪鲤鱼计算机科技有限公司\n网址：\nwww.kgame.com.cn\n手机上网：\nwap.kgame.com.cn\n版本：V1.0\n制作人：诸一楠\n美术设计：黄劼\n程序设计：秦竫\n程序协助：程雪平\n测试：王毅，陈思源";
      var19[var4] = "基础远程攻击单位";
      var19[var3] = "可使敌人中毒。";
      var19[var1] = "地底伸出利刃，杀伤敌人";
      var19[5] = "点燃敌人";
      var19[6] = "可以使敌人暂停";
      var19[7] = "可以使敌人冰冻";
      var19[8] = "直线沉重打击敌人的木桩";
      var19[9] = "远程沉重打击敌人的石头";
      var19[10] = "造成很大伤害，会将火熄灭";
      var19[11] = "造成很大伤害，遇火会点燃";
      var19[12] = "阻断敌人前进，用过后失效";
      var19[13] = "生产石灰瓶和断龙闸的装置";
      var19[14] = "生产突刺和擂木的装置";
      var19[15] = "生产烟火和投石的装置";
      var19[16] = "生产麻痹矢和沸水的装置";
      var19[17] = "生产寒冰和滚油的装置";
      var19[18] = "升级塔，升到顶可获得英雄";
      var19[19] = "";
      var19[20] = "装填石块";
      var19[21] = "释放断龙闸";
      var19[22] = "拆除所选塔，回收部分资金";
      var19[23] = "取消选择";
      var19[24] = "金手指";
      var19[25] = "成都";
      var19[26] = "许昌";
      var19[27] = "建业";
      var19[28] = "刘备";
      var19[29] = "关羽";
      var19[30] = "马超";
      var19[31] = "黄忠";
      var19[32] = "张飞";
      var19[33] = "赵云";
      var19[34] = "魏延";
      var19[35] = "姜维";
      var19[36] = "诸葛亮";
      var19[37] = "徐庶";
      var19[38] = "庞统";
      var19[39] = "曹操";
      var19[40] = "典韦";
      var19[41] = "张辽";
      var19[42] = "夏侯渊";
      var19[43] = "夏侯憞";
      var19[44] = "许褚";
      var19[45] = "司马懿";
      var19[46] = "荀攸";
      var19[47] = "荀彧";
      var19[48] = "程昱";
      var19[49] = "郭嘉";
      var19[50] = "孙权";
      var19[51] = "凌统";
      var19[52] = "甘宁";
      var19[53] = "黄盖";
      var19[54] = "周泰";
      var19[55] = "太史慈";
      var19[56] = "张昭";
      var19[57] = "陆逊";
      var19[58] = "吕蒙";
      var19[59] = "鲁肃";
      var19[60] = "周瑜";
      var19[61] = "张梁";
      var19[62] = "张宝";
      var19[63] = "张角";
      var19[64] = "华雄";
      var19[65] = "貂蝉";
      var19[66] = "吕布";
      var19[67] = "董卓";
      var19[68] = "张颌";
      var19[69] = "曹洪";
      var19[70] = "徐晃";
      var19[71] = "于禁";
      var19[72] = "乐进";
      var19[73] = "李典";
      var19[74] = "曹丕";
      var19[75] = "程普";
      var19[76] = "刘备同时拥有卧龙与凤雏，属性伤害很厉害。";
      var19[77] = "由曹操带领的能臣猛将，擅长阻碍敌人行进。";
      var19[78] = "孙家率领吴国的世代名将，弓箭的好手辈出。";
      var19[79] = "武系";
      var19[80] = "文系";
      var19[81] = "优先把不同的防御塔升级成本国对应武将";
      var19[82] = "优先把不同的防御塔升级成本国对应文臣";
      var19[83] = "黄巾之乱";
      var19[84] = "张氏起义不仅动摇了汉朝的统治，更引得无数英雄豪杰乱世逐鹿。";
      var19[85] = "虎牢关";
      var19[86] = "董卓无道，十八路诸侯尽起而攻之。三英战吕布，温酒斩华雄。";
      var19[87] = "长坂坡";
      var19[88] = "长坂坡中困龙出,虎将怀中小龙眠.自古冲阵扶危主,是有常山赵子龙。";
      var19[89] = "赤壁之战";
      var19[90] = "雄姿英发，羽扇纶巾，谈笑间，强虏灰飞烟灭。 公瑾？孔明？";
      var19[91] = "战合肥";
      var19[92] = "“若孙权至者，张、李将军出战，乐将军守，护军勿得与战”";
      var19[93] = "夷陵之战";
      var19[94] = "夷陵之战，又称彝陵之战、猇亭之战。双方指挥官：陆逊，刘备。";
      var19[95] = "攻克成都";
      var19[96] = "汉朝几百年的基业到了尽头，谁能取得这份荣耀？";
      var19[97] = "攻克许昌";
      var19[98] = "曹操的贼子野心即将覆灭，多年的努力今天终于有所回报！";
      var19[99] = "攻克建业";
      var19[100] = "孙氏家族的昏庸统治即将终结，打过长江去，解救南方人民！";
      var19[101] = "声音";
      var19[102] = "开";
      var19[103] = "关";
      var19[104] = "是否开启声音";
      var19[105] = "开启";
      var19[106] = "取消";
      var19[107] = "继续游戏";
      var19[108] = "金手指";
      var19[109] = "设置";
      var19[110] = "帮助";
      var19[111] = "关于";
      var19[112] = "退出";
      var19[113] = "金不足，消灭敌人可获得金钱，也";
      var19[114] = "需要至少修建一个塔";
      var19[115] = "现在还不能建造这个建筑,需要修建相关的城池，也";
      var19[116] = "该城池已经修建";
      var19[117] = "该塔已是最高级";
      var19[118] = "现在还不能升级这个建筑，需要将城池全部建筑升级，也";
      var19[119] = "需要升级弓塔至君主";
      var19[120] = "已经达到建筑上限";
      var19[121] = "您的城市即将被攻占！";
      var19[122] = "使所有塔攻击增加";
      var19[123] = "无视敌人防御";
      var19[124] = "无视敌人防御";
      var19[125] = "击中敌人同时减速";
      var19[126] = "攻击范围增加";
      var19[127] = "攻击范围增加";
      var19[128] = "中毒敌人同时减速";
      var19[129] = "无视敌人防御";
      var19[130] = "火焰伤害加强";
      var19[131] = "麻痹时间延长";
      var19[132] = "冰冻时间延长";
      var19[133] = "使所有塔攻击增加";
      var19[134] = "石块更加坚硬";
      var19[135] = "加强攻击伤害";
      var19[136] = "加强攻击伤害";
      var19[137] = "攻击时间延长";
      var19[138] = "攻击时间延长";
      var19[139] = "加强攻击伤害";
      var19[140] = "加强攻击伤害";
      var19[141] = "加强攻击伤害";
      var19[142] = "范围麻痹";
      var19[143] = " 范围冰冻";
      var19[144] = "使所有塔攻击增加";
      var19[145] = "装填石头半价";
      var19[146] = "加强攻击频率";
      var19[147] = "周围塔攻击增加";
      var19[148] = "范围内敌人减速";
      var19[149] = "范围内敌人减速";
      var19[150] = "中毒时间延长";
      var19[151] = "加强攻击频率";
      var19[152] = "火焰伤害时间增加";
      var19[153] = "麻痹概率增加";
      var19[154] = "冰冻概率增加";
      var19[155] = "大家跟我";
      var19[156] = "练了这么久，这点打击算啥？";
      var19[157] = "快点快点快点！跟我";
      var19[158] = "冲破敌城有重赏！";
      var19[159] = "我乃";
      var19[160] = "，我的卫队饱餐而来，不死不归！";
      var19[161] = "师傅在天有灵，";
      var19[162] = "多年来的水战不白练！";
      var19[163] = "被烧了多次，我";
      var19[164] = "今天也算不怕火了哈哈！";
      var19[165] = "我";
      var19[166] = "喝了这么多麻痹散，该不怕麻痹了吧！";
      var19[167] = "兄弟们都给我";
      var19[168] = "冲啊！冲慢的军法处置！";
      var19[169] = "俺";
      var19[170] = "吃了这么多解药，不会再中毒了吧？";
      var19[171] = "建造各种城防武器抵挡敌城中涌出的军队";
      var19[172] = "升级自己的城池可以建造更多类型的武器";
      var19[173] = "超过10个敌人冲入自己的城池则游戏失败";
      var19[174] = "空地按5造塔，#出敌人，塔或城上按5升级";
      var19[175] = "消灭当前全部敌人";
      var19[176] = "获得全部科技";
      var19[177] = "获得500金";
      var19[178] = "城防加10";
      var19[179] = "消灭敌人金翻倍";
      var19[180] = "现在还不能升级这个建筑";
      this.b1015 = var19;
      this.o = -1;
      this.q = 60;
      this.b1018 = (boolean)var2;
      this.a1019 = 0L;
      this.c1020 = false;
      this.r = 0;
      this.e1025 = 0;
      this.f1026 = 0;
      byte[] var20 = new byte[]{-30, -1, 0, 1, 1, 0};
      this.a1027 = var20;
      byte[][] var21 = new byte[var3][];
      short[] var7 = new byte[var4];
      var7[0] = 27;
      var7[1] = 63;
      var21[0] = (byte[])var7;
      var7 = new byte[var4];
      var7[0] = 79;
      var7[1] = 33;
      var21[var2] = var7;
      var7 = new byte[var4];
      var7[0] = 113;
      var7[1] = 71;
      var21[var4] = var7;
      this.a1028 = var21;
      var6 = this.j * 3 + 40;
      this.V = var6;
      int var8 = this.V;
      var6 = 320 - var8 - 13 - 10;
      this.W = var6;
      var6 = this.j * 3 + 40;
      this.ad = var6;
      var6 = this.j * 3 + 10 + 30;
      this.ah = var6;
      var6 = this.ah + 40;
      this.ai = var6;
      var8 = this.ai;
      var6 = 320 - var8 - 13 - 10;
      this.aj = var6;
      byte[][] var22 = new byte[9][];
      var7 = new byte[var4];
      var7[0] = 103;
      var7[1] = 41;
      var22[0] = var7;
      var7 = new byte[var4];
      var7[0] = 64;
      var7[1] = 38;
      var22[var2] = var7;
      var7 = new byte[var4];
      var7[0] = 68;
      var7[1] = 65;
      var22[var4] = var7;
      var7 = new byte[var4];
      var7[0] = 96;
      var7[1] = 77;
      var22[var3] = var7;
      var7 = new byte[var4];
      var7[0] = 105;
      var7[1] = 57;
      var22[var1] = var7;
      short[] var9 = new byte[var4];
      var9[0] = 60;
      var9[1] = 77;
      var22[5] = (byte[])var9;
      var9 = new byte[var4];
      var9[0] = 29;
      var9[1] = 73;
      var22[6] = var9;
      var9 = new byte[var4];
      var9[0] = 81;
      var9[1] = 52;
      var22[7] = var9;
      var9 = new byte[var4];
      var9[0] = 122;
      var9[1] = 83;
      var22[8] = var9;
      this.b1030 = var22;
      this.l1031 = (boolean)var2;
      this.ak = 0;
      byte[] var23 = new byte[var3];
      var23[0] = 87;
      var23[1] = 18;
      var23[2] = 9;
      this.b1034 = var23;
      int[] var24 = new int[var3];
      this.g1035 = var24;
      byte[] var25 = new byte[]{
         0, 5, 5, 5, 10, 4, 14, 7, 21, 4, 25, 3, 28, 3, 31, 4, 35, 3, 38, 4, 42, 4, 46, 4, 50, 4, 54, 3, 57, 3, 60, 4, 64, 2, 66, 2, 68, 4, 72, 4, 76, 5
      };
      this.c1037 = var25;
      int[] var26 = new int[]{26, 7};
      int[][] var27 = (int[][])Array.newInstance(int.class, var26);
      this.a1039 = var27;
      int[] var28 = new int[15];
      this.h1041 = var28;
      InputStream[] var29 = new InputStream[var2];
      this.a1042 = var29;
      Player[] var30 = new Player[var2];
      this.a1043 = var30;
      int[] var31 = new int[var2];
      this.i1044 = var31;
      this.aq = -1;
      this.g1046 = 0;
      this.h1047 = 0;
      this.i1048 = 0;
      int[] var32 = new int[360];
      var32[0] = 0;
      var32[var2] = 71;
      var32[var4] = 143;
      var32[var3] = 214;
      var32[var1] = 286;
      var32[5] = 357;
      var32[6] = 428;
      var32[7] = 499;
      var32[8] = 570;
      var32[9] = 641;
      var32[10] = 711;
      var32[11] = 782;
      var32[12] = 852;
      var32[13] = 921;
      var32[14] = 991;
      var32[15] = 1060;
      var32[16] = 1129;
      var32[17] = 1198;
      var32[18] = 1266;
      var32[19] = 1334;
      var32[20] = 1401;
      var32[21] = 1468;
      var32[22] = 1534;
      var32[23] = 1600;
      var32[24] = 1666;
      var32[25] = 1731;
      var32[26] = 1796;
      var32[27] = 1860;
      var32[28] = 1923;
      var32[29] = 1986;
      var32[30] = 2048;
      var32[31] = 2110;
      var32[32] = 2171;
      var32[33] = 2231;
      var32[34] = 2290;
      var32[35] = 2349;
      var32[36] = 2408;
      var32[37] = 2465;
      var32[38] = 2522;
      var32[39] = 2578;
      var32[40] = 2633;
      var32[41] = 2687;
      var32[42] = 2741;
      var32[43] = 2793;
      var32[44] = 2845;
      var32[45] = 2896;
      var32[46] = 2946;
      var32[47] = 2996;
      var32[48] = 3044;
      var32[49] = 3091;
      var32[50] = 3138;
      var32[51] = 3183;
      var32[52] = 3228;
      var32[53] = 3271;
      var32[54] = 3314;
      var32[55] = 3355;
      var32[56] = 3396;
      var32[57] = 3435;
      var32[58] = 3474;
      var32[59] = 3511;
      var32[60] = 3547;
      var32[61] = 3582;
      var32[62] = 3617;
      var32[63] = 3650;
      var32[64] = 3681;
      var32[65] = 3712;
      var32[66] = 3742;
      var32[67] = 3770;
      var32[68] = 3798;
      var32[69] = 3824;
      var32[70] = 3849;
      var32[71] = 3873;
      var32[72] = 3896;
      var32[73] = 3917;
      var32[74] = 3937;
      var32[75] = 3956;
      var32[76] = 3974;
      var32[77] = 3991;
      var32[78] = 4006;
      var32[79] = 4021;
      var32[80] = 4034;
      var32[81] = 4046;
      var32[82] = 4056;
      var32[83] = 4065;
      var32[84] = 4074;
      var32[85] = 4080;
      var32[86] = 4086;
      var32[87] = 4090;
      var32[88] = 4094;
      var32[89] = 4095;
      var32[90] = 4096;
      var32[91] = 4095;
      var32[92] = 4094;
      var32[93] = 4090;
      var32[94] = 4086;
      var32[95] = 4080;
      var32[96] = 4074;
      var32[97] = 4065;
      var32[98] = 4056;
      var32[99] = 4046;
      var32[100] = 4034;
      var32[101] = 4021;
      var32[102] = 4006;
      var32[103] = 3991;
      var32[104] = 3974;
      var32[105] = 3956;
      var32[106] = 3937;
      var32[107] = 3917;
      var32[108] = 3896;
      var32[109] = 3873;
      var32[110] = 3849;
      var32[111] = 3824;
      var32[112] = 3798;
      var32[113] = 3770;
      var32[114] = 3742;
      var32[115] = 3712;
      var32[116] = 3681;
      var32[117] = 3650;
      var32[118] = 3617;
      var32[119] = 3582;
      var32[120] = 3547;
      var32[121] = 3511;
      var32[122] = 3474;
      var32[123] = 3435;
      var32[124] = 3396;
      var32[125] = 3355;
      var32[126] = 3314;
      var32[127] = 3271;
      var32[128] = 3228;
      var32[129] = 3183;
      var32[130] = 3138;
      var32[131] = 3091;
      var32[132] = 3044;
      var32[133] = 2996;
      var32[134] = 2946;
      var32[135] = 2896;
      var32[136] = 2845;
      var32[137] = 2793;
      var32[138] = 2741;
      var32[139] = 2687;
      var32[140] = 2633;
      var32[141] = 2578;
      var32[142] = 2522;
      var32[143] = 2465;
      var32[144] = 2408;
      var32[145] = 2349;
      var32[146] = 2290;
      var32[147] = 2231;
      var32[148] = 2171;
      var32[149] = 2110;
      var32[150] = 2048;
      var32[151] = 1986;
      var32[152] = 1923;
      var32[153] = 1860;
      var32[154] = 1796;
      var32[155] = 1731;
      var32[156] = 1666;
      var32[157] = 1600;
      var32[158] = 1534;
      var32[159] = 1468;
      var32[160] = 1401;
      var32[161] = 1334;
      var32[162] = 1266;
      var32[163] = 1198;
      var32[164] = 1129;
      var32[165] = 1060;
      var32[166] = 991;
      var32[167] = 921;
      var32[168] = 852;
      var32[169] = 782;
      var32[170] = 711;
      var32[171] = 641;
      var32[172] = 570;
      var32[173] = 499;
      var32[174] = 428;
      var32[175] = 357;
      var32[176] = 286;
      var32[177] = 214;
      var32[178] = 143;
      var32[179] = 71;
      var32[180] = 0;
      var32[181] = -71;
      var32[182] = -143;
      var32[183] = -214;
      var32[184] = -286;
      var32[185] = -357;
      var32[186] = -428;
      var32[187] = -499;
      var32[188] = -570;
      var32[189] = -641;
      var32[190] = -711;
      var32[191] = -782;
      var32[192] = -852;
      var32[193] = -921;
      var32[194] = -991;
      var32[195] = -1060;
      var32[196] = -1129;
      var32[197] = -1198;
      var32[198] = -1266;
      var32[199] = -1334;
      var32[200] = -1401;
      var32[201] = -1468;
      var32[202] = -1534;
      var32[203] = -1600;
      var32[204] = -1666;
      var32[205] = -1731;
      var32[206] = -1796;
      var32[207] = -1860;
      var32[208] = -1923;
      var32[209] = -1986;
      var32[210] = -2048;
      var32[211] = -2110;
      var32[212] = -2171;
      var32[213] = -2231;
      var32[214] = -2290;
      var32[215] = -2349;
      var32[216] = -2408;
      var32[217] = -2465;
      var32[218] = -2522;
      var32[219] = -2578;
      var32[220] = -2633;
      var32[221] = -2687;
      var32[222] = -2741;
      var32[223] = -2793;
      var32[224] = -2845;
      var32[225] = -2896;
      var32[226] = -2946;
      var32[227] = -2996;
      var32[228] = -3044;
      var32[229] = -3091;
      var32[230] = -3138;
      var32[231] = -3183;
      var32[232] = -3228;
      var32[233] = -3271;
      var32[234] = -3314;
      var32[235] = -3355;
      var32[236] = -3396;
      var32[237] = -3435;
      var32[238] = -3474;
      var32[239] = -3511;
      var32[240] = -3547;
      var32[241] = -3582;
      var32[242] = -3617;
      var32[243] = -3650;
      var32[244] = -3681;
      var32[245] = -3712;
      var32[246] = -3742;
      var32[247] = -3770;
      var32[248] = -3798;
      var32[249] = -3824;
      var32[250] = -3849;
      var32[251] = -3873;
      var32[252] = -3896;
      var32[253] = -3917;
      var32[254] = -3937;
      var32[255] = -3956;
      var32[256] = -3974;
      var32[257] = -3991;
      var32[258] = -4006;
      var32[259] = -4021;
      var32[260] = -4034;
      var32[261] = -4046;
      var32[262] = -4056;
      var32[263] = -4065;
      var32[264] = -4074;
      var32[265] = -4080;
      var32[266] = -4086;
      var32[267] = -4090;
      var32[268] = -4094;
      var32[269] = -4095;
      var32[270] = -4096;
      var32[271] = -4095;
      var32[272] = -4094;
      var32[273] = -4090;
      var32[274] = -4086;
      var32[275] = -4080;
      var32[276] = -4074;
      var32[277] = -4065;
      var32[278] = -4056;
      var32[279] = -4046;
      var32[280] = -4034;
      var32[281] = -4021;
      var32[282] = -4006;
      var32[283] = -3991;
      var32[284] = -3974;
      var32[285] = -3956;
      var32[286] = -3937;
      var32[287] = -3917;
      var32[288] = -3896;
      var32[289] = -3873;
      var32[290] = -3849;
      var32[291] = -3824;
      var32[292] = -3798;
      var32[293] = -3770;
      var32[294] = -3742;
      var32[295] = -3712;
      var32[296] = -3681;
      var32[297] = -3650;
      var32[298] = -3617;
      var32[299] = -3582;
      var32[300] = -3547;
      var32[301] = -3511;
      var32[302] = -3474;
      var32[303] = -3435;
      var32[304] = -3396;
      var32[305] = -3355;
      var32[306] = -3314;
      var32[307] = -3271;
      var32[308] = -3228;
      var32[309] = -3183;
      var32[310] = -3138;
      var32[311] = -3091;
      var32[312] = -3044;
      var32[313] = -2996;
      var32[314] = -2946;
      var32[315] = -2896;
      var32[316] = -2845;
      var32[317] = -2793;
      var32[318] = -2741;
      var32[319] = -2687;
      var32[320] = -2633;
      var32[321] = -2578;
      var32[322] = -2522;
      var32[323] = -2465;
      var32[324] = -2408;
      var32[325] = -2349;
      var32[326] = -2290;
      var32[327] = -2231;
      var32[328] = -2171;
      var32[329] = -2110;
      var32[330] = -2048;
      var32[331] = -1986;
      var32[332] = -1923;
      var32[333] = -1860;
      var32[334] = -1796;
      var32[335] = -1731;
      var32[336] = -1666;
      var32[337] = -1600;
      var32[338] = -1534;
      var32[339] = -1468;
      var32[340] = -1401;
      var32[341] = -1334;
      var32[342] = -1266;
      var32[343] = -1198;
      var32[344] = -1129;
      var32[345] = -1060;
      var32[346] = -991;
      var32[347] = -921;
      var32[348] = -852;
      var32[349] = -782;
      var32[350] = -711;
      var32[351] = -641;
      var32[352] = -570;
      var32[353] = -499;
      var32[354] = -428;
      var32[355] = -357;
      var32[356] = -286;
      var32[357] = -214;
      var32[358] = -143;
      var32[359] = -71;
      int[] var33 = new int[]{
         0,
         71,
         143,
         215,
         286,
         358,
         431,
         503,
         576,
         649,
         722,
         796,
         871,
         946,
         1021,
         1098,
         1175,
         1252,
         1331,
         1410,
         1491,
         1572,
         1655,
         1739,
         1824,
         1910,
         1998,
         2087,
         2178,
         2270,
         2365,
         2461,
         2559,
         2660,
         2763,
         2868,
         2976,
         3087,
         3200,
         3317,
         3437,
         3561,
         3688,
         3820,
         3955,
         4096,
         4242,
         4392,
         4549,
         4712,
         4881,
         5058,
         5243,
         5436,
         5638,
         5850,
         6073,
         6307,
         6555,
         6817,
         7094,
         7389,
         7703,
         8039,
         8398,
         8784,
         9200,
         9650,
         10138,
         10670,
         11254,
         11896,
         12606,
         13397,
         14284,
         15286,
         16428,
         17742,
         19270,
         21072,
         23230,
         25861,
         29145,
         33359,
         38971,
         46817,
         58576,
         78156,
         117294,
         234660
      };
      this.j1049 = var33;
      byte[] var34 = new byte[]{0, 21, 21, 11, 32, 11};
      this.d1050 = var34;
      byte[][] var35 = new byte[var1][];
      var7 = new byte[]{0, 1, 2, 3, 4};
      var35[0] = var7;
      var7 = new byte[var1];
      var7[0] = 1;
      var7[1] = 2;
      var7[2] = 3;
      var7[3] = 4;
      var35[var2] = var7;
      var7 = new byte[var1];
      var7[0] = 6;
      var7[1] = 7;
      var7[2] = 8;
      var7[3] = 9;
      var35[var4] = var7;
      var7 = new byte[var1];
      var7[0] = 5;
      var7[1] = 7;
      var7[2] = 8;
      var7[3] = 9;
      var35[var3] = var7;
      this.c1051 = var35;
      short[][] var36 = new short[7][];
      var7 = new short[var4];
      var7[0] = 0;
      var7[1] = 10;
      var36[0] = var7;
      var7 = new short[var4];
      var7[0] = 1;
      var7[1] = 10;
      var36[var2] = var7;
      var7 = new short[var1];
      var7[0] = 2;
      var7[1] = 3;
      var7[2] = 1;
      var7[3] = 10;
      var36[var4] = var7;
      var7 = new short[var4];
      var7[0] = 4;
      var7[1] = 10;
      var36[var3] = var7;
      var7 = new short[var1];
      var7[0] = 5;
      var7[1] = 6;
      var7[2] = 1;
      var7[3] = 10;
      var36[var1] = var7;
      var9 = new short[var1];
      var9[0] = 7;
      var9[1] = 8;
      var9[2] = 9;
      var9[3] = 10;
      var36[5] = var9;
      var9 = new short[var4];
      var9[0] = 11;
      var9[1] = 12;
      var36[6] = var9;
      this.a1052 = var36;
      byte[][] var37 = new byte[8][];
      short[] var166 = new byte[]{0, 1, 10, 2, 6, 3, 7, 4, 8, 5, 9, 21};
      var37[0] = (byte[])var166;
      var166 = new byte[]{11, 12, 13, 14, 15, 22, 21};
      var37[var2] = var166;
      var166 = new byte[var3];
      var166[0] = 16;
      var166[1] = 20;
      var166[2] = 21;
      var37[var4] = var166;
      var166 = new byte[var1];
      var166[0] = 18;
      var166[1] = 16;
      var166[2] = 20;
      var166[3] = 21;
      var37[var3] = var166;
      var166 = new byte[var1];
      var166[0] = 19;
      var166[1] = 16;
      var166[2] = 20;
      var166[3] = 21;
      var37[var1] = var166;
      short[] var403 = new byte[var3];
      var403[0] = 17;
      var403[1] = 20;
      var403[2] = 21;
      var37[5] = (byte[])var403;
      var403 = new byte[var1];
      var403[0] = 18;
      var403[1] = 17;
      var403[2] = 20;
      var403[3] = 21;
      var37[6] = var403;
      var403 = new byte[var1];
      var403[0] = 19;
      var403[1] = 17;
      var403[2] = 20;
      var403[3] = 21;
      var37[7] = var403;
      this.d1053 = var37;
      byte[] var38 = new byte[]{0, 8, 2, 8, 10, 2, 18, 15, 0};
      this.e1054 = var38;
      byte[] var39 = new byte[]{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, -1, -1, -1};
      this.f1055 = var39;
      boolean[] var40 = new boolean[5];
      this.a1056 = var40;
      byte[] var41 = new byte[]{20, 40, 60, 80, 100};
      this.g1057 = var41;
      byte[][] var42 = new byte[10][];
      var166 = new byte[var1];
      var166[0] = 84;
      var166[1] = 0;
      var166[2] = 21;
      var166[3] = 32;
      var42[0] = var166;
      var166 = new byte[var1];
      var166[0] = 0;
      var166[1] = 0;
      var166[2] = 44;
      var166[3] = 38;
      var42[var2] = var166;
      var166 = new byte[var1];
      var166[0] = 0;
      var166[1] = 38;
      var166[2] = 14;
      var166[3] = 26;
      var42[var4] = var166;
      var166 = new byte[var1];
      var166[0] = 91;
      var166[1] = 32;
      var166[2] = 14;
      var166[3] = 31;
      var42[var3] = var166;
      var166 = new byte[var1];
      var166[0] = 44;
      var166[1] = 0;
      var166[2] = 40;
      var166[3] = 33;
      var42[var1] = var166;
      var403 = new byte[var1];
      var403[0] = 46;
      var403[1] = 33;
      var403[2] = 40;
      var403[3] = 12;
      var42[5] = var403;
      var403 = new byte[var1];
      var403[0] = 46;
      var403[1] = 41;
      var403[2] = 15;
      var403[3] = 9;
      var42[6] = var403;
      var403 = new byte[var1];
      var403[0] = 46;
      var403[1] = 45;
      var403[2] = 18;
      var403[3] = 16;
      var42[7] = var403;
      var403 = new byte[var1];
      var403[0] = 71;
      var403[1] = 45;
      var403[2] = 20;
      var403[3] = 15;
      var42[8] = var403;
      var403 = new byte[var1];
      var403[0] = 14;
      var403[1] = 38;
      var403[2] = 32;
      var403[3] = 32;
      var42[9] = var403;
      this.e1058 = var42;
      boolean[] var43 = new boolean[10];
      this.b1059 = var43;
      byte[] var44 = new byte[]{5, 8, 0, 7, 4};
      this.h1060 = var44;
      boolean[] var45 = new boolean[]{false, true, true, true, false, false, true, false, false, true};
      this.c1061 = var45;
      byte[] var46 = new byte[]{1, 5, 2, 10, 1, 8, 12, 17, -1, 0, 0, 0, 3, 7, -2, -8, 1, 4, 2, -20};
      this.i1062 = var46;
      byte[][] var47 = new byte[var4][];
      var166 = new byte[]{0, 10, 0, 0, 65, 0, 1, 26, 36, 5, 28, 46, 8, 38, 53, 3, 0, 40, 7, -2, 32, 3, 82, 40, 7, 80, 32, 4, 28, 16, 2, 14, 44, 2, 68, 43};
      var47[0] = var166;
      var166 = new byte[]{3, 2, 11, 7, 0, 3, 3, 70, 11, 7, 68, 3, 3, 2, 37, 7, 0, 29, 3, 70, 37, 7, 68, 29, 1, 21, 18, 9, 27, 0};
      var47[var2] = var166;
      this.f1063 = var47;
      byte[] var48 = new byte[var4];
      var48[0] = 12;
      var48[1] = 10;
      this.j1064 = var48;
      byte[][] var49 = new byte[5][];
      var166 = new byte[var4];
      var166[0] = 1;
      var166[1] = 10;
      var49[0] = var166;
      var166 = new byte[var4];
      var166[0] = 2;
      var166[1] = 6;
      var49[var2] = var166;
      var166 = new byte[var4];
      var166[0] = 3;
      var166[1] = 7;
      var49[var4] = var166;
      var166 = new byte[var4];
      var166[0] = 4;
      var166[1] = 8;
      var49[var3] = var166;
      var166 = new byte[var4];
      var166[0] = 5;
      var166[1] = 9;
      var49[var1] = var166;
      this.g1065 = var49;
      int[] var50 = new int[]{80, 28};
      int[][] var51 = (int[][])Array.newInstance(int.class, var50);
      this.b1066 = var51;
      byte[][][] var52 = new byte[9][][];
      byte[][] var183 = new byte[var3][];
      var403 = new byte[var4];
      var403[0] = 1;
      var403[1] = 1;
      var183[0] = var403;
      var403 = new byte[var4];
      var403[0] = 1;
      var403[1] = 2;
      var183[var2] = var403;
      var403 = new byte[var4];
      var403[0] = 3;
      var403[1] = 3;
      var183[var4] = var403;
      var52[0] = var183;
      byte[][] var184 = new byte[var1][];
      var403 = new byte[var4];
      var403[0] = 3;
      var403[1] = 2;
      var184[0] = var403;
      var403 = new byte[var4];
      var403[0] = 11;
      var403[1] = 2;
      var184[var2] = var403;
      var403 = new byte[var4];
      var403[0] = 7;
      var403[1] = 6;
      var184[var4] = var403;
      var403 = new byte[var4];
      var403[0] = 5;
      var403[1] = 8;
      var184[var3] = var403;
      var52[var2] = var184;
      byte[][] var185 = new byte[10][];
      var403 = new byte[var4];
      var403[0] = 3;
      var403[1] = 5;
      var185[0] = var403;
      var403 = new byte[var4];
      var403[0] = 5;
      var403[1] = 1;
      var185[var2] = var403;
      var403 = new byte[var4];
      var403[0] = 3;
      var403[1] = 7;
      var185[var4] = var403;
      var403 = new byte[var4];
      var403[0] = 7;
      var403[1] = 6;
      var185[var3] = var403;
      var403 = new byte[var4];
      var403[0] = 7;
      var403[1] = 1;
      var185[var1] = var403;
      short[] var10 = new byte[var4];
      var10[0] = 9;
      var10[1] = 3;
      var185[5] = (byte[])var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 5;
      var185[6] = var10;
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 1;
      var185[7] = var10;
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 8;
      var185[8] = var10;
      var10 = new byte[var4];
      var10[0] = 11;
      var10[1] = 2;
      var185[9] = var10;
      var52[var4] = var185;
      byte[][] var186 = new byte[12][];
      var403 = new byte[var4];
      var403[0] = 7;
      var403[1] = 6;
      var186[0] = var403;
      var403 = new byte[var4];
      var403[0] = 3;
      var403[1] = 4;
      var186[var2] = var403;
      var403 = new byte[var4];
      var403[0] = 7;
      var403[1] = 1;
      var186[var4] = var403;
      var403 = new byte[var4];
      var403[0] = 5;
      var403[1] = 1;
      var186[var3] = var403;
      var403 = new byte[var4];
      var403[0] = 11;
      var403[1] = 8;
      var186[var1] = var403;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 7;
      var186[5] = var10;
      var10 = new byte[var4];
      var10[0] = 9;
      var10[1] = 3;
      var186[6] = var10;
      var10 = new byte[var4];
      var10[0] = 11;
      var10[1] = 2;
      var186[7] = var10;
      var10 = new byte[var4];
      var10[0] = 5;
      var10[1] = 3;
      var186[8] = var10;
      var10 = new byte[var4];
      var10[0] = 9;
      var10[1] = 3;
      var186[9] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 4;
      var186[10] = var10;
      var10 = new byte[var4];
      var10[0] = 5;
      var10[1] = 3;
      var186[11] = var10;
      var52[var3] = var186;
      byte[][] var187 = new byte[12][];
      var403 = new byte[var4];
      var403[0] = 7;
      var403[1] = 1;
      var187[0] = var403;
      var403 = new byte[var4];
      var403[0] = 3;
      var403[1] = 7;
      var187[var2] = var403;
      var403 = new byte[var4];
      var403[0] = 11;
      var403[1] = 8;
      var187[var4] = var403;
      var403 = new byte[var4];
      var403[0] = 7;
      var403[1] = 6;
      var187[var3] = var403;
      var403 = new byte[var4];
      var403[0] = 3;
      var403[1] = 7;
      var187[var1] = var403;
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 5;
      var187[5] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 3;
      var187[6] = var10;
      var10 = new byte[var4];
      var10[0] = 1;
      var10[1] = 2;
      var187[7] = var10;
      var10 = new byte[var4];
      var10[0] = 5;
      var10[1] = 2;
      var187[8] = var10;
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 1;
      var187[9] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 1;
      var187[10] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 4;
      var187[11] = var10;
      var52[var1] = var187;
      byte[][] var433 = new byte[12][];
      var10 = new byte[var4];
      var10[0] = 9;
      var10[1] = 3;
      var433[0] = var10;
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 3;
      var433[var2] = var10;
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 4;
      var433[var4] = var10;
      var10 = new byte[var4];
      var10[0] = 11;
      var10[1] = 1;
      var433[var3] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 6;
      var433[var1] = var10;
      short[] var11 = new byte[var4];
      var11[0] = 11;
      var11[1] = 2;
      var433[5] = (byte[])var11;
      var11 = new byte[var4];
      var11[0] = 7;
      var11[1] = 1;
      var433[6] = var11;
      var11 = new byte[var4];
      var11[0] = 5;
      var11[1] = 5;
      var433[7] = var11;
      var11 = new byte[var4];
      var11[0] = 1;
      var11[1] = 2;
      var433[8] = var11;
      var11 = new byte[var4];
      var11[0] = 9;
      var11[1] = 3;
      var433[9] = var11;
      var11 = new byte[var4];
      var11[0] = 3;
      var11[1] = 1;
      var433[10] = var11;
      var11 = new byte[var4];
      var11[0] = 3;
      var11[1] = 3;
      var433[11] = var11;
      var52[5] = var433;
      byte[][] var434 = new byte[5][];
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 3;
      var434[0] = var10;
      var10 = new byte[var4];
      var10[0] = 11;
      var10[1] = 2;
      var434[var2] = var10;
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 4;
      var434[var4] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 8;
      var434[var3] = var10;
      var10 = new byte[var4];
      var10[0] = 5;
      var10[1] = 6;
      var434[var1] = var10;
      var52[6] = var434;
      byte[][] var435 = new byte[5][];
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 1;
      var435[0] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 5;
      var435[var2] = var10;
      var10 = new byte[var4];
      var10[0] = 5;
      var10[1] = 1;
      var435[var4] = var10;
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 5;
      var435[var3] = var10;
      var10 = new byte[var4];
      var10[0] = 5;
      var10[1] = 3;
      var435[var1] = var10;
      var52[7] = var435;
      byte[][] var436 = new byte[5][];
      var10 = new byte[var4];
      var10[0] = 1;
      var10[1] = 2;
      var436[0] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 1;
      var436[var2] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 4;
      var436[var4] = var10;
      var10 = new byte[var4];
      var10[0] = 5;
      var10[1] = 5;
      var436[var3] = var10;
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 1;
      var436[var1] = var10;
      var52[8] = var436;
      this.a1067 = var52;
      byte[] var53 = new byte[]{0, 0, 1, 2, 3, 4, 6, 5, 6};
      this.k1068 = var53;
      short[][] var54 = new short[9][];
      var166 = new short[var4];
      var166[0] = 136;
      var166[1] = 88;
      var54[0] = var166;
      var166 = new short[var4];
      var166[0] = 56;
      var166[1] = 56;
      var54[var2] = var166;
      var166 = new short[var4];
      var166[0] = 408;
      var166[1] = 104;
      var54[var4] = var166;
      var166 = new short[var4];
      var166[0] = 568;
      var166[1] = 56;
      var54[var3] = var166;
      var166 = new short[var4];
      var166[0] = 56;
      var166[1] = 56;
      var54[var1] = var166;
      var403 = new short[var4];
      var403[0] = 88;
      var403[1] = 88;
      var54[5] = var403;
      var403 = new short[var4];
      var403[0] = 56;
      var403[1] = 72;
      var54[6] = var403;
      var403 = new short[var4];
      var403[0] = 72;
      var403[1] = 72;
      var54[7] = var403;
      var403 = new short[var4];
      var403[0] = 456;
      var403[1] = 56;
      var54[8] = var403;
      this.b1069 = var54;
      short[][] var55 = new short[9][];
      var166 = new short[var4];
      var166[0] = 336;
      var166[1] = 64;
      var55[0] = var166;
      var166 = new short[var4];
      var166[0] = 64;
      var166[1] = 528;
      var55[var2] = var166;
      var166 = new short[var4];
      var166[0] = 160;
      var166[1] = 176;
      var55[var4] = var166;
      var166 = new short[var4];
      var166[0] = 560;
      var166[1] = 432;
      var55[var3] = var166;
      var166 = new short[var4];
      var166[0] = 592;
      var166[1] = 352;
      var55[var1] = var166;
      var403 = new short[var4];
      var403[0] = 256;
      var403[1] = 320;
      var55[5] = var403;
      var403 = new short[var4];
      var403[0] = 320;
      var403[1] = 336;
      var55[6] = var403;
      var403 = new short[var4];
      var403[0] = 96;
      var403[1] = 640;
      var55[7] = var403;
      var403 = new short[var4];
      var403[0] = 96;
      var403[1] = 32;
      var55[8] = var403;
      this.c1070 = var55;
      int[] var56 = new int[]{6981008, 8089212, 8089212, 9659759, 11329522, 1210262, 6981008, 11329522, 9659759};
      this.k1071 = var56;
      byte[] var57 = new byte[]{12, 16, 20, 24, 24, 24, 20, 20, 20};
      this.l1072 = var57;
      boolean[] var58 = new boolean[]{true, false, false, false, false, false, false, false, false};
      this.d1073 = var58;
      byte[][] var59 = new byte[var3][];
      byte[] var198 = new byte[]{0, 1, 2, 3, 5, 7, 8};
      var59[0] = var198;
      var198 = new byte[]{0, 1, 2, 3, 4, 6, 8};
      var59[var2] = var198;
      var198 = new byte[]{0, 1, 3, 4, 5, 6, 7};
      var59[var4] = var198;
      this.h1074 = var59;
      byte[] var60 = new byte[]{0, 1, 2, 3, 4, 5, 6, 4, 3};
      this.m1075 = var60;
      byte[] var61 = new byte[]{0, 1, 2, 3, 4, 2, 2, 4, 3};
      this.n1076 = var61;
      this.aU = 12;
      byte[][] var62 = new byte[6][];
      var198 = new byte[]{40, 4, 20, 2, 1, 2};
      var62[0] = var198;
      var198 = new byte[]{60, 6, 20, 1, 2, 2};
      var62[var2] = var198;
      var198 = new byte[]{100, 10, 15, 1, 3, 1};
      var62[var4] = var198;
      var198 = new byte[]{80, 8, 10, 1, 2, 4};
      var62[var3] = var198;
      var198 = new byte[]{40, 4, 10, 1, 1, 2};
      var62[var1] = var198;
      byte[] var445 = new byte[]{120, 15, 20, 3, 0, 2};
      var62[5] = var445;
      this.i1079 = var62;
      byte[][] var63 = new byte[9][];
      var198 = new byte[]{9, 14, 16, 17, 18, 20};
      var63[0] = var198;
      var198 = new byte[]{4, 9, 14, 17, 18, 20};
      var63[var2] = var198;
      var198 = new byte[]{1, 8, 11, 18, 19, 20};
      var63[var4] = var198;
      var198 = new byte[]{3, 7, 11, 15, 16, 20};
      var63[var3] = var198;
      var198 = new byte[]{1, 8, 11, 16, 17, 20};
      var63[var1] = var198;
      var445 = new byte[]{0, 5, 10, 14, 15, 20};
      var63[5] = var445;
      var445 = new byte[]{0, 3, 12, 18, 19, 20};
      var63[6] = var445;
      var445 = new byte[]{0, 1, 6, 15, 16, 20};
      var63[7] = var445;
      var445 = new byte[]{0, 2, 7, 10, 11, 20};
      var63[8] = var445;
      this.j1080 = var63;
      byte[][] var64 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = -1;
      var64[0] = var198;
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = 0;
      var64[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = 1;
      var64[var4] = var198;
      var198 = new byte[var4];
      var198[0] = -1;
      var198[1] = 0;
      var64[var3] = var198;
      this.k1081 = var64;
      byte[][] var65 = new byte[6][];
      var198 = new byte[var1];
      var198[0] = 0;
      var198[1] = 1;
      var198[2] = 2;
      var198[3] = 1;
      var65[0] = var198;
      var198 = new byte[var1];
      var198[0] = 0;
      var198[1] = 1;
      var198[2] = 2;
      var198[3] = 1;
      var65[var2] = var198;
      var198 = new byte[]{0, 0, 1, 1, 2, 2, 1, 1};
      var65[var4] = var198;
      var198 = new byte[var3];
      var198[0] = 0;
      var198[1] = 1;
      var198[2] = 2;
      var65[var3] = var198;
      var198 = new byte[var1];
      var198[0] = 0;
      var198[1] = 1;
      var198[2] = 2;
      var198[3] = 1;
      var65[var1] = var198;
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 1;
      var445[2] = 2;
      var445[3] = 1;
      var65[5] = var445;
      this.l1083 = var65;
      byte[][] var66 = new byte[var1][];
      var198 = new byte[var1];
      var198[0] = 1;
      var198[1] = -1;
      var198[2] = 0;
      var198[3] = -16;
      var66[0] = var198;
      var198 = new byte[var1];
      var198[0] = 1;
      var198[1] = 1;
      var198[2] = 48;
      var198[3] = 0;
      var66[var2] = var198;
      var198 = new byte[var1];
      var198[0] = 1;
      var198[1] = 1;
      var198[2] = 0;
      var198[3] = 64;
      var66[var4] = var198;
      var198 = new byte[var1];
      var198[0] = -1;
      var198[1] = 1;
      var198[2] = -16;
      var198[3] = 0;
      var66[var3] = var198;
      this.m1084 = var66;
      byte[][][] var67 = new byte[var3][][];
      byte[][] var224 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 0;
      var224[0] = var445;
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = -1;
      var224[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 0;
      var224[var4] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 1;
      var224[var3] = var445;
      var67[0] = var224;
      byte[][] var225 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 0;
      var225[0] = var445;
      var445 = new byte[var4];
      var445[0] = -1;
      var445[1] = 0;
      var225[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 1;
      var225[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -1;
      var445[1] = 1;
      var225[var3] = var445;
      var67[var2] = var225;
      byte[][] var226 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 0;
      var226[0] = var445;
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 1;
      var226[var2] = var445;
      var445 = new byte[var4];
      var445[0] = -1;
      var445[1] = 0;
      var226[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -1;
      var445[1] = -1;
      var226[var3] = var445;
      var67[var4] = var226;
      this.b1085 = var67;
      byte[][][] var68 = new byte[12][][];
      byte[][] var227 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 8;
      var227[0] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 8;
      var227[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 8;
      var227[var4] = var445;
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 8;
      var227[var3] = var445;
      var68[0] = var227;
      byte[][] var228 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 8;
      var228[0] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 8;
      var228[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 8;
      var228[var4] = var445;
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 8;
      var228[var3] = var445;
      var68[var2] = var228;
      byte[][] var229 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 9;
      var229[0] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 9;
      var229[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 9;
      var229[var4] = var445;
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 9;
      var229[var3] = var445;
      var68[var4] = var229;
      byte[][] var230 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = 2;
      var445[1] = 9;
      var230[0] = var445;
      var445 = new byte[var4];
      var445[0] = 2;
      var445[1] = 9;
      var230[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 2;
      var445[1] = 9;
      var230[var4] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 9;
      var230[var3] = var445;
      var68[var3] = var230;
      byte[][] var231 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = 3;
      var445[1] = 8;
      var231[0] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 8;
      var231[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 8;
      var231[var4] = var445;
      var445 = new byte[var4];
      var445[0] = 3;
      var445[1] = 8;
      var231[var3] = var445;
      var68[var1] = var231;
      byte[][] var483 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 9;
      var483[0] = var10;
      var10 = new byte[var4];
      var10[0] = 2;
      var10[1] = 9;
      var483[var2] = var10;
      var10 = new byte[var4];
      var10[0] = 2;
      var10[1] = 9;
      var483[var4] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 9;
      var483[var3] = var10;
      var68[5] = var483;
      byte[][] var484 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = 2;
      var10[1] = 16;
      var484[0] = var10;
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 16;
      var484[var2] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 16;
      var484[var4] = var10;
      var10 = new byte[var4];
      var10[0] = 5;
      var10[1] = 16;
      var484[var3] = var10;
      var68[6] = var484;
      byte[][] var485 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = 2;
      var10[1] = 16;
      var485[0] = var10;
      var10 = new byte[var4];
      var10[0] = 7;
      var10[1] = 16;
      var485[var2] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 16;
      var485[var4] = var10;
      var10 = new byte[var4];
      var10[0] = 5;
      var10[1] = 16;
      var485[var3] = var10;
      var68[7] = var485;
      byte[][] var486 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 9;
      var486[0] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 9;
      var486[var2] = var10;
      var10 = new byte[var4];
      var10[0] = 5;
      var10[1] = 9;
      var486[var4] = var10;
      var10 = new byte[var4];
      var10[0] = 2;
      var10[1] = 9;
      var486[var3] = var10;
      var68[8] = var486;
      byte[][] var487 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 9;
      var487[0] = var10;
      var10 = new byte[var4];
      var10[0] = 3;
      var10[1] = 9;
      var487[var2] = var10;
      var10 = new byte[var4];
      var10[0] = 5;
      var10[1] = 9;
      var487[var4] = var10;
      var10 = new byte[var4];
      var10[0] = 2;
      var10[1] = 9;
      var487[var3] = var10;
      var68[9] = var487;
      byte[][] var488 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = 2;
      var10[1] = 10;
      var488[0] = var10;
      var10 = new byte[var4];
      var10[0] = 2;
      var10[1] = 10;
      var488[var2] = var10;
      var10 = new byte[var4];
      var10[0] = 0;
      var10[1] = 10;
      var488[var4] = var10;
      var10 = new byte[var4];
      var10[0] = 2;
      var10[1] = 10;
      var488[var3] = var10;
      var68[10] = var488;
      byte[][] var489 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = 4;
      var10[1] = 12;
      var489[0] = var10;
      var10 = new byte[var4];
      var10[0] = 2;
      var10[1] = 12;
      var489[var2] = var10;
      var10 = new byte[var4];
      var10[0] = 0;
      var10[1] = 12;
      var489[var4] = var10;
      var10 = new byte[var4];
      var10[0] = 2;
      var10[1] = 12;
      var489[var3] = var10;
      var68[11] = var489;
      this.c1090 = var68;
      byte[][][] var69 = new byte[12][][];
      byte[][] var232 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = -7;
      var445[1] = -12;
      var232[0] = var445;
      var445 = new byte[var4];
      var445[0] = -7;
      var445[1] = -12;
      var232[var2] = var445;
      var445 = new byte[var4];
      var445[0] = -7;
      var445[1] = -12;
      var232[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -6;
      var445[1] = -12;
      var232[var3] = var445;
      var69[0] = var232;
      byte[][] var233 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = -7;
      var445[1] = -12;
      var233[0] = var445;
      var445 = new byte[var4];
      var445[0] = -7;
      var445[1] = -12;
      var233[var2] = var445;
      var445 = new byte[var4];
      var445[0] = -7;
      var445[1] = -12;
      var233[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -6;
      var445[1] = -12;
      var233[var3] = var445;
      var69[var2] = var233;
      byte[][] var234 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = -7;
      var445[1] = -13;
      var234[0] = var445;
      var445 = new byte[var4];
      var445[0] = -7;
      var445[1] = -13;
      var234[var2] = var445;
      var445 = new byte[var4];
      var445[0] = -7;
      var445[1] = -13;
      var234[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -6;
      var445[1] = -13;
      var234[var3] = var445;
      var69[var4] = var234;
      byte[][] var235 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = -8;
      var445[1] = -13;
      var235[0] = var445;
      var445 = new byte[var4];
      var445[0] = -8;
      var445[1] = -13;
      var235[var2] = var445;
      var445 = new byte[var4];
      var445[0] = -8;
      var445[1] = -13;
      var235[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -8;
      var445[1] = -13;
      var235[var3] = var445;
      var69[var3] = var235;
      byte[][] var236 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = -9;
      var445[1] = -12;
      var236[0] = var445;
      var445 = new byte[var4];
      var445[0] = -7;
      var445[1] = -12;
      var236[var2] = var445;
      var445 = new byte[var4];
      var445[0] = -7;
      var445[1] = -12;
      var236[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -9;
      var445[1] = -12;
      var236[var3] = var445;
      var69[var1] = var236;
      byte[][] var510 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = -9;
      var10[1] = -13;
      var510[0] = var10;
      var10 = new byte[var4];
      var10[0] = -8;
      var10[1] = -13;
      var510[var2] = var10;
      var10 = new byte[var4];
      var10[0] = -8;
      var10[1] = -13;
      var510[var4] = var10;
      var10 = new byte[var4];
      var10[0] = -9;
      var10[1] = -13;
      var510[var3] = var10;
      var69[5] = var510;
      byte[][] var511 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = -8;
      var10[1] = -20;
      var511[0] = var10;
      var10 = new byte[var4];
      var10[0] = -13;
      var10[1] = -20;
      var511[var2] = var10;
      var10 = new byte[var4];
      var10[0] = -9;
      var10[1] = -20;
      var511[var4] = var10;
      var10 = new byte[var4];
      var10[0] = -11;
      var10[1] = -20;
      var511[var3] = var10;
      var69[6] = var511;
      byte[][] var512 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = -8;
      var10[1] = -20;
      var512[0] = var10;
      var10 = new byte[var4];
      var10[0] = -13;
      var10[1] = -20;
      var512[var2] = var10;
      var10 = new byte[var4];
      var10[0] = -9;
      var10[1] = -20;
      var512[var4] = var10;
      var10 = new byte[var4];
      var10[0] = -11;
      var10[1] = -20;
      var512[var3] = var10;
      var69[7] = var512;
      byte[][] var513 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = -9;
      var10[1] = -13;
      var513[0] = var10;
      var10 = new byte[var4];
      var10[0] = -9;
      var10[1] = -13;
      var513[var2] = var10;
      var10 = new byte[var4];
      var10[0] = -11;
      var10[1] = -13;
      var513[var4] = var10;
      var10 = new byte[var4];
      var10[0] = -8;
      var10[1] = -13;
      var513[var3] = var10;
      var69[8] = var513;
      byte[][] var514 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = -9;
      var10[1] = -13;
      var514[0] = var10;
      var10 = new byte[var4];
      var10[0] = -9;
      var10[1] = -13;
      var514[var2] = var10;
      var10 = new byte[var4];
      var10[0] = -11;
      var10[1] = -13;
      var514[var4] = var10;
      var10 = new byte[var4];
      var10[0] = -8;
      var10[1] = -13;
      var514[var3] = var10;
      var69[9] = var514;
      byte[][] var515 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = -8;
      var10[1] = -14;
      var515[0] = var10;
      var10 = new byte[var4];
      var10[0] = -8;
      var10[1] = -14;
      var515[var2] = var10;
      var10 = new byte[var4];
      var10[0] = -6;
      var10[1] = -14;
      var515[var4] = var10;
      var10 = new byte[var4];
      var10[0] = -8;
      var10[1] = -14;
      var515[var3] = var10;
      var69[10] = var515;
      byte[][] var516 = new byte[var1][];
      var10 = new byte[var4];
      var10[0] = -10;
      var10[1] = -16;
      var516[0] = var10;
      var10 = new byte[var4];
      var10[0] = -8;
      var10[1] = -16;
      var516[var2] = var10;
      var10 = new byte[var4];
      var10[0] = -6;
      var10[1] = -16;
      var516[var4] = var10;
      var10 = new byte[var4];
      var10[0] = -8;
      var10[1] = -16;
      var516[var3] = var10;
      var69[11] = var516;
      this.d1091 = var69;
      short[][][][] var70 = new short[12][][][];
      short[][][] var237 = new short[var1][][];
      short[][] var517 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 0;
      var10[1] = 13;
      var517[0] = var10;
      var10 = new short[var4];
      var10[0] = 13;
      var10[1] = 13;
      var517[var2] = var10;
      var10 = new short[var4];
      var10[0] = 26;
      var10[1] = 13;
      var517[var4] = var10;
      var237[0] = var517;
      short[][] var518 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 39;
      var10[1] = 13;
      var518[0] = var10;
      var10 = new short[var4];
      var10[0] = 52;
      var10[1] = 13;
      var518[var2] = var10;
      var10 = new short[var4];
      var10[0] = 65;
      var10[1] = 13;
      var518[var4] = var10;
      var237[var2] = var518;
      short[][] var519 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 78;
      var10[1] = 13;
      var519[0] = var10;
      var10 = new short[var4];
      var10[0] = 91;
      var10[1] = 13;
      var519[var2] = var10;
      var10 = new short[var4];
      var10[0] = 104;
      var10[1] = 13;
      var519[var4] = var10;
      var237[var4] = var519;
      short[][] var520 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 65;
      var10[1] = 13;
      var520[0] = var10;
      var10 = new short[var4];
      var10[0] = 52;
      var10[1] = 13;
      var520[var2] = var10;
      var10 = new short[var4];
      var10[0] = 39;
      var10[1] = 13;
      var520[var4] = var10;
      var237[var3] = var520;
      var70[0] = var237;
      short[][][] var238 = new short[var1][][];
      short[][] var521 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 0;
      var10[1] = 13;
      var521[0] = var10;
      var10 = new short[var4];
      var10[0] = 13;
      var10[1] = 13;
      var521[var2] = var10;
      var10 = new short[var4];
      var10[0] = 26;
      var10[1] = 13;
      var521[var4] = var10;
      var238[0] = var521;
      short[][] var522 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 39;
      var10[1] = 13;
      var522[0] = var10;
      var10 = new short[var4];
      var10[0] = 52;
      var10[1] = 13;
      var522[var2] = var10;
      var10 = new short[var4];
      var10[0] = 65;
      var10[1] = 13;
      var522[var4] = var10;
      var238[var2] = var522;
      short[][] var523 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 78;
      var10[1] = 13;
      var523[0] = var10;
      var10 = new short[var4];
      var10[0] = 91;
      var10[1] = 13;
      var523[var2] = var10;
      var10 = new short[var4];
      var10[0] = 104;
      var10[1] = 13;
      var523[var4] = var10;
      var238[var4] = var523;
      short[][] var524 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 65;
      var10[1] = 13;
      var524[0] = var10;
      var10 = new short[var4];
      var10[0] = 52;
      var10[1] = 13;
      var524[var2] = var10;
      var10 = new short[var4];
      var10[0] = 39;
      var10[1] = 13;
      var524[var4] = var10;
      var238[var3] = var524;
      var70[var2] = var238;
      short[][][] var239 = new short[var1][][];
      short[][] var525 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 0;
      var10[1] = 13;
      var525[0] = var10;
      var10 = new short[var4];
      var10[0] = 13;
      var10[1] = 13;
      var525[var2] = var10;
      var10 = new short[var4];
      var10[0] = 26;
      var10[1] = 13;
      var525[var4] = var10;
      var239[0] = var525;
      short[][] var526 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 39;
      var10[1] = 13;
      var526[0] = var10;
      var10 = new short[var4];
      var10[0] = 52;
      var10[1] = 13;
      var526[var2] = var10;
      var10 = new short[var4];
      var10[0] = 65;
      var10[1] = 13;
      var526[var4] = var10;
      var239[var2] = var526;
      short[][] var527 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 78;
      var10[1] = 13;
      var527[0] = var10;
      var10 = new short[var4];
      var10[0] = 91;
      var10[1] = 13;
      var527[var2] = var10;
      var10 = new short[var4];
      var10[0] = 104;
      var10[1] = 13;
      var527[var4] = var10;
      var239[var4] = var527;
      short[][] var528 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 65;
      var10[1] = 13;
      var528[0] = var10;
      var10 = new short[var4];
      var10[0] = 52;
      var10[1] = 13;
      var528[var2] = var10;
      var10 = new short[var4];
      var10[0] = 39;
      var10[1] = 13;
      var528[var4] = var10;
      var239[var3] = var528;
      var70[var4] = var239;
      short[][][] var240 = new short[var1][][];
      short[][] var529 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 0;
      var10[1] = 16;
      var529[0] = var10;
      var10 = new short[var4];
      var10[0] = 16;
      var10[1] = 16;
      var529[var2] = var10;
      var10 = new short[var4];
      var10[0] = 32;
      var10[1] = 16;
      var529[var4] = var10;
      var240[0] = var529;
      short[][] var530 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 48;
      var10[1] = 16;
      var530[0] = var10;
      var10 = new short[var4];
      var10[0] = 64;
      var10[1] = 16;
      var530[var2] = var10;
      var10 = new short[var4];
      var10[0] = 80;
      var10[1] = 16;
      var530[var4] = var10;
      var240[var2] = var530;
      short[][] var531 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 96;
      var10[1] = 16;
      var531[0] = var10;
      var10 = new short[var4];
      var10[0] = 112;
      var10[1] = 16;
      var531[var2] = var10;
      var10 = new short[var4];
      var10[0] = 128;
      var10[1] = 16;
      var531[var4] = var10;
      var240[var4] = var531;
      short[][] var532 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 80;
      var10[1] = 16;
      var532[0] = var10;
      var10 = new short[var4];
      var10[0] = 64;
      var10[1] = 16;
      var532[var2] = var10;
      var10 = new short[var4];
      var10[0] = 48;
      var10[1] = 16;
      var532[var4] = var10;
      var240[var3] = var532;
      var70[var3] = var240;
      short[][][] var241 = new short[var1][][];
      short[][] var533 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 0;
      var10[1] = 16;
      var533[0] = var10;
      var10 = new short[var4];
      var10[0] = 16;
      var10[1] = 16;
      var533[var2] = var10;
      var10 = new short[var4];
      var10[0] = 32;
      var10[1] = 16;
      var533[var4] = var10;
      var241[0] = var533;
      short[][] var534 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 48;
      var10[1] = 16;
      var534[0] = var10;
      var10 = new short[var4];
      var10[0] = 64;
      var10[1] = 16;
      var534[var2] = var10;
      var10 = new short[var4];
      var10[0] = 80;
      var10[1] = 16;
      var534[var4] = var10;
      var241[var2] = var534;
      short[][] var535 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 96;
      var10[1] = 16;
      var535[0] = var10;
      var10 = new short[var4];
      var10[0] = 112;
      var10[1] = 16;
      var535[var2] = var10;
      var10 = new short[var4];
      var10[0] = 128;
      var10[1] = 16;
      var535[var4] = var10;
      var241[var4] = var535;
      short[][] var536 = new short[var3][];
      var10 = new short[var4];
      var10[0] = 80;
      var10[1] = 16;
      var536[0] = var10;
      var10 = new short[var4];
      var10[0] = 64;
      var10[1] = 16;
      var536[var2] = var10;
      var10 = new short[var4];
      var10[0] = 48;
      var10[1] = 16;
      var536[var4] = var10;
      var241[var3] = var536;
      var70[var1] = var241;
      short[][][] var537 = new short[var1][][];
      short[][] var873 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 0;
      var11[1] = 16;
      var873[0] = var11;
      var11 = new short[var4];
      var11[0] = 16;
      var11[1] = 16;
      var873[var2] = var11;
      var11 = new short[var4];
      var11[0] = 32;
      var11[1] = 16;
      var873[var4] = var11;
      var537[0] = var873;
      short[][] var874 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 48;
      var11[1] = 17;
      var874[0] = var11;
      var11 = new short[var4];
      var11[0] = 65;
      var11[1] = 17;
      var874[var2] = var11;
      var11 = new short[var4];
      var11[0] = 82;
      var11[1] = 17;
      var874[var4] = var11;
      var537[var2] = var874;
      short[][] var875 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 99;
      var11[1] = 17;
      var875[0] = var11;
      var11 = new short[var4];
      var11[0] = 116;
      var11[1] = 17;
      var875[var2] = var11;
      var11 = new short[var4];
      var11[0] = 133;
      var11[1] = 17;
      var875[var4] = var11;
      var537[var4] = var875;
      short[][] var876 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 85;
      var11[1] = 17;
      var876[0] = var11;
      var11 = new short[var4];
      var11[0] = 68;
      var11[1] = 17;
      var876[var2] = var11;
      var11 = new short[var4];
      var11[0] = 51;
      var11[1] = 17;
      var876[var4] = var11;
      var537[var3] = var876;
      var70[5] = var537;
      short[][][] var538 = new short[var1][][];
      short[][] var877 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 0;
      var11[1] = 16;
      var877[0] = var11;
      var11 = new short[var4];
      var11[0] = 16;
      var11[1] = 16;
      var877[var2] = var11;
      var11 = new short[var4];
      var11[0] = 32;
      var11[1] = 16;
      var877[var4] = var11;
      var538[0] = var877;
      short[][] var878 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 48;
      var11[1] = 24;
      var878[0] = var11;
      var11 = new short[var4];
      var11[0] = 72;
      var11[1] = 24;
      var878[var2] = var11;
      var11 = new short[var4];
      var11[0] = 96;
      var11[1] = 24;
      var878[var4] = var11;
      var538[var2] = var878;
      short[][] var879 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 120;
      var11[1] = 17;
      var879[0] = var11;
      var11 = new short[var4];
      var11[0] = 137;
      var11[1] = 17;
      var879[var2] = var11;
      var11 = new short[var4];
      var11[0] = 154;
      var11[1] = 17;
      var879[var4] = var11;
      var538[var4] = var879;
      short[][] var880 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 99;
      var11[1] = 24;
      var880[0] = var11;
      var11 = new short[var4];
      var11[0] = 75;
      var11[1] = 24;
      var880[var2] = var11;
      var11 = new short[var4];
      var11[0] = 51;
      var11[1] = 24;
      var880[var4] = var11;
      var538[var3] = var880;
      var70[6] = var538;
      short[][][] var539 = new short[var1][][];
      short[][] var881 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 0;
      var11[1] = 16;
      var881[0] = var11;
      var11 = new short[var4];
      var11[0] = 16;
      var11[1] = 16;
      var881[var2] = var11;
      var11 = new short[var4];
      var11[0] = 32;
      var11[1] = 16;
      var881[var4] = var11;
      var539[0] = var881;
      short[][] var882 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 48;
      var11[1] = 24;
      var882[0] = var11;
      var11 = new short[var4];
      var11[0] = 72;
      var11[1] = 24;
      var882[var2] = var11;
      var11 = new short[var4];
      var11[0] = 96;
      var11[1] = 24;
      var882[var4] = var11;
      var539[var2] = var882;
      short[][] var883 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 120;
      var11[1] = 17;
      var883[0] = var11;
      var11 = new short[var4];
      var11[0] = 137;
      var11[1] = 17;
      var883[var2] = var11;
      var11 = new short[var4];
      var11[0] = 154;
      var11[1] = 17;
      var883[var4] = var11;
      var539[var4] = var883;
      short[][] var884 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 99;
      var11[1] = 24;
      var884[0] = var11;
      var11 = new short[var4];
      var11[0] = 75;
      var11[1] = 24;
      var884[var2] = var11;
      var11 = new short[var4];
      var11[0] = 51;
      var11[1] = 24;
      var884[var4] = var11;
      var539[var3] = var884;
      var70[7] = var539;
      short[][][] var540 = new short[var1][][];
      short[][] var885 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 0;
      var11[1] = 20;
      var885[0] = var11;
      var11 = new short[var4];
      var11[0] = 20;
      var11[1] = 20;
      var885[var2] = var11;
      var11 = new short[var4];
      var11[0] = 40;
      var11[1] = 20;
      var885[var4] = var11;
      var540[0] = var885;
      short[][] var886 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 60;
      var11[1] = 17;
      var886[0] = var11;
      var11 = new short[var4];
      var11[0] = 77;
      var11[1] = 17;
      var886[var2] = var11;
      var11 = new short[var4];
      var11[0] = 94;
      var11[1] = 17;
      var886[var4] = var11;
      var540[var2] = var886;
      short[][] var887 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 111;
      var11[1] = 19;
      var887[0] = var11;
      var11 = new short[var4];
      var11[0] = 130;
      var11[1] = 19;
      var887[var2] = var11;
      var11 = new short[var4];
      var11[0] = 149;
      var11[1] = 19;
      var887[var4] = var11;
      var540[var4] = var887;
      short[][] var888 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 91;
      var11[1] = 17;
      var888[0] = var11;
      var11 = new short[var4];
      var11[0] = 74;
      var11[1] = 17;
      var888[var2] = var11;
      var11 = new short[var4];
      var11[0] = 57;
      var11[1] = 17;
      var888[var4] = var11;
      var540[var3] = var888;
      var70[8] = var540;
      short[][][] var541 = new short[var1][][];
      short[][] var889 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 0;
      var11[1] = 20;
      var889[0] = var11;
      var11 = new short[var4];
      var11[0] = 20;
      var11[1] = 20;
      var889[var2] = var11;
      var11 = new short[var4];
      var11[0] = 40;
      var11[1] = 20;
      var889[var4] = var11;
      var541[0] = var889;
      short[][] var890 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 60;
      var11[1] = 17;
      var890[0] = var11;
      var11 = new short[var4];
      var11[0] = 77;
      var11[1] = 17;
      var890[var2] = var11;
      var11 = new short[var4];
      var11[0] = 94;
      var11[1] = 17;
      var890[var4] = var11;
      var541[var2] = var890;
      short[][] var891 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 111;
      var11[1] = 19;
      var891[0] = var11;
      var11 = new short[var4];
      var11[0] = 130;
      var11[1] = 19;
      var891[var2] = var11;
      var11 = new short[var4];
      var11[0] = 149;
      var11[1] = 19;
      var891[var4] = var11;
      var541[var4] = var891;
      short[][] var892 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 91;
      var11[1] = 17;
      var892[0] = var11;
      var11 = new short[var4];
      var11[0] = 74;
      var11[1] = 17;
      var892[var2] = var11;
      var11 = new short[var4];
      var11[0] = 57;
      var11[1] = 17;
      var892[var4] = var11;
      var541[var3] = var892;
      var70[9] = var541;
      short[][][] var542 = new short[var1][][];
      short[][] var893 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 0;
      var11[1] = 14;
      var893[0] = var11;
      var11 = new short[var4];
      var11[0] = 14;
      var11[1] = 14;
      var893[var2] = var11;
      var11 = new short[var4];
      var11[0] = 28;
      var11[1] = 14;
      var893[var4] = var11;
      var542[0] = var893;
      short[][] var894 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 42;
      var11[1] = 16;
      var894[0] = var11;
      var11 = new short[var4];
      var11[0] = 58;
      var11[1] = 16;
      var894[var2] = var11;
      var11 = new short[var4];
      var11[0] = 74;
      var11[1] = 16;
      var894[var4] = var11;
      var542[var2] = var894;
      short[][] var895 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 90;
      var11[1] = 14;
      var895[0] = var11;
      var11 = new short[var4];
      var11[0] = 104;
      var11[1] = 14;
      var895[var2] = var11;
      var11 = new short[var4];
      var11[0] = 118;
      var11[1] = 14;
      var895[var4] = var11;
      var542[var4] = var895;
      short[][] var896 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 74;
      var11[1] = 16;
      var896[0] = var11;
      var11 = new short[var4];
      var11[0] = 58;
      var11[1] = 16;
      var896[var2] = var11;
      var11 = new short[var4];
      var11[0] = 42;
      var11[1] = 16;
      var896[var4] = var11;
      var542[var3] = var896;
      var70[10] = var542;
      short[][][] var543 = new short[var1][][];
      short[][] var897 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 0;
      var11[1] = 16;
      var897[0] = var11;
      var11 = new short[var4];
      var11[0] = 16;
      var11[1] = 16;
      var897[var2] = var11;
      var11 = new short[var4];
      var11[0] = 32;
      var11[1] = 16;
      var897[var4] = var11;
      var543[0] = var897;
      short[][] var898 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 48;
      var11[1] = 16;
      var898[0] = var11;
      var11 = new short[var4];
      var11[0] = 64;
      var11[1] = 16;
      var898[var2] = var11;
      var11 = new short[var4];
      var11[0] = 80;
      var11[1] = 16;
      var898[var4] = var11;
      var543[var2] = var898;
      short[][] var899 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 96;
      var11[1] = 16;
      var899[0] = var11;
      var11 = new short[var4];
      var11[0] = 112;
      var11[1] = 16;
      var899[var2] = var11;
      var11 = new short[var4];
      var11[0] = 128;
      var11[1] = 16;
      var899[var4] = var11;
      var543[var4] = var899;
      short[][] var900 = new short[var3][];
      var11 = new short[var4];
      var11[0] = 80;
      var11[1] = 16;
      var900[0] = var11;
      var11 = new short[var4];
      var11[0] = 64;
      var11[1] = 16;
      var900[var2] = var11;
      var11 = new short[var4];
      var11[0] = 48;
      var11[1] = 16;
      var900[var4] = var11;
      var543[var3] = var900;
      var70[11] = var543;
      this.a1092 = var70;
      byte[][][] var71 = new byte[var1][][];
      byte[][] var242 = new byte[7][];
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 2;
      var242[0] = var445;
      var445 = new byte[var4];
      var445[0] = 9;
      var445[1] = 4;
      var242[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 17;
      var445[1] = 1;
      var242[var4] = var445;
      var445 = new byte[var4];
      var445[0] = 1;
      var445[1] = 14;
      var242[var3] = var445;
      var445 = new byte[var4];
      var445[0] = 12;
      var445[1] = 13;
      var242[var1] = var445;
      byte[] var901 = new byte[var4];
      var901[0] = 19;
      var901[1] = 13;
      var242[5] = var901;
      var901 = new byte[var4];
      var901[0] = 8;
      var901[1] = 19;
      var242[6] = var901;
      var71[0] = var242;
      byte[][] var243 = new byte[7][];
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 1;
      var243[0] = var445;
      var445 = new byte[var4];
      var445[0] = 8;
      var445[1] = 3;
      var243[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 18;
      var445[1] = -1;
      var243[var4] = var445;
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 14;
      var243[var3] = var445;
      var445 = new byte[var4];
      var445[0] = 13;
      var445[1] = 15;
      var243[var1] = var445;
      var901 = new byte[var4];
      var901[0] = 20;
      var901[1] = 13;
      var243[5] = var901;
      var901 = new byte[var4];
      var901[0] = 8;
      var901[1] = 20;
      var243[6] = var901;
      var71[var2] = var243;
      byte[][] var244 = new byte[7][];
      var445 = new byte[var4];
      var445[0] = -1;
      var445[1] = 0;
      var244[0] = var445;
      var445 = new byte[var4];
      var445[0] = 8;
      var445[1] = 2;
      var244[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 18;
      var445[1] = -1;
      var244[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -1;
      var445[1] = 15;
      var244[var3] = var445;
      var445 = new byte[var4];
      var445[0] = 13;
      var445[1] = 15;
      var244[var1] = var445;
      var901 = new byte[var4];
      var901[0] = 21;
      var901[1] = 14;
      var244[5] = var901;
      var901 = new byte[var4];
      var901[0] = 8;
      var901[1] = 21;
      var244[6] = var901;
      var71[var4] = var244;
      byte[][] var245 = new byte[7][];
      var445 = new byte[var4];
      var445[0] = -1;
      var445[1] = 0;
      var245[0] = var445;
      var445 = new byte[var4];
      var445[0] = 8;
      var445[1] = 2;
      var245[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 18;
      var445[1] = -1;
      var245[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -1;
      var445[1] = 15;
      var245[var3] = var445;
      var445 = new byte[var4];
      var445[0] = 13;
      var445[1] = 15;
      var245[var1] = var445;
      var901 = new byte[var4];
      var901[0] = 21;
      var901[1] = 14;
      var245[5] = var901;
      var901 = new byte[var4];
      var901[0] = 8;
      var901[1] = 21;
      var245[6] = var901;
      var71[var3] = var245;
      this.e1093 = var71;
      byte[][] var72 = new byte[6][];
      var198 = new byte[]{0, 0, 17, 6, 0, 17};
      var72[0] = var198;
      var198 = new byte[]{0, 6, 17, 7, 0, 16};
      var72[var2] = var198;
      var198 = new byte[]{0, 13, 17, 10, 0, 12};
      var72[var4] = var198;
      var198 = new byte[]{0, 23, 17, 12, 0, 5};
      var72[var3] = var198;
      var198 = new byte[]{0, 34, 17, 9, 0, 0};
      var72[var1] = var198;
      var445 = new byte[]{0, 43, 17, 7, 0, 0};
      var72[5] = var445;
      this.n1094 = var72;
      byte[][] var73 = new byte[8][];
      var198 = new byte[]{19, 15, 6, -9, -5};
      var73[0] = var198;
      var198 = new byte[]{19, 15, 6, -9, -5};
      var73[var2] = var198;
      var198 = new byte[]{19, 15, 6, -9, -5};
      var73[var4] = var198;
      var198 = new byte[]{19, 21, 4, -9, -11};
      var73[var3] = var198;
      var198 = new byte[]{19, 21, 4, -9, -11};
      var73[var1] = var198;
      var445 = new byte[]{20, 20, 7, -11, -11};
      var73[5] = var445;
      var445 = new byte[]{19, 15, 4, -9, -5};
      var73[6] = var445;
      var445 = new byte[]{20, 20, 7, -11, -11};
      var73[7] = var445;
      this.o1095 = var73;
      byte[] var74 = new byte[]{2, 2, 3, 2, 2, 3, 3, 3, 3, 3, 3};
      this.o1098 = var74;
      byte[] var75 = new byte[]{0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1};
      this.p1099 = var75;
      byte[] var76 = new byte[]{20, 30, 40, 50, 40, 80, 40, 50, 60, 80, 30};
      this.q1100 = var76;
      byte[] var77 = new byte[]{10, 2, 15, 3, 20, 4, 20, 5, 10, 5, 30, 5, 10, 5, 20, 5, 20, 5, 30, 5, 20, 5};
      this.r1101 = var77;
      byte[] var78 = new byte[]{15, 5, 10, 3, 30, 10, 15, 5, 15, 5, 60, 10, 20, 10, 30, 10, 40, 8, 60, 15, 50, 10};
      this.s1102 = var78;
      byte[] var79 = new byte[]{64, 8, 48, 4, 0, 0, 64, 6, 56, 6, 64, 8, 0, 0, 48, 8, 64, 4, 64, 4, 0, 0};
      this.t1103 = var79;
      byte[] var80 = new byte[]{20, -2, 30, -3, 60, -4, 25, -2, 30, -2, 30, -2, 60, -4, 30, -2, 80, -6, 100, -5, 0, 0};
      this.u1104 = var80;
      boolean[] var81 = new boolean[11];
      this.e1105 = var81;
      boolean[] var82 = new boolean[11];
      this.f1106 = var82;
      int[] var83 = new int[]{30, 18};
      int[][] var84 = (int[][])Array.newInstance(int.class, var83);
      this.c1107 = var84;
      byte[][] var85 = new byte[5][];
      var198 = new byte[]{-26, -25, -8, -20, -26, 2, 11, -29, 1, 2, 17, 0, -10, 14};
      var85[0] = var198;
      var198 = new byte[]{-30, -29, -9, -24, -29, 4, 14, -32, 2, 6, 20, 2, -10, 19};
      var85[var2] = var198;
      var198 = new byte[]{-33, -31, -10, -26, -32, 6, 16, -34, 3, 8, 22, 4, -10, 22};
      var85[var4] = var198;
      var198 = new byte[]{-34, -32, -11, -27, -33, 7, 17, -35, 4, 9, 23, 5, -10, 23};
      var85[var3] = var198;
      var198 = new byte[]{-34, -32, -11, -27, -33, 7, 17, -35, 4, 9, 23, 5, -10, 23};
      var85[var1] = var198;
      this.p1108 = var85;
      byte[] var86 = new byte[]{6, 4, 3, 2, 1};
      this.v1109 = var86;
      byte[] var87 = new byte[]{-13, -43, -24, -32, -4, -32, -13, -22};
      this.w1110 = var87;
      byte[][][] var88 = new byte[11][][];
      byte[][] var261 = new byte[var1][];
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 0;
      var445[2] = 26;
      var445[3] = 24;
      var261[0] = var445;
      var445 = new byte[var1];
      var445[0] = 26;
      var445[1] = 0;
      var445[2] = 22;
      var445[3] = 16;
      var261[var2] = var445;
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 24;
      var445[2] = 32;
      var445[3] = 26;
      var261[var4] = var445;
      var445 = new byte[var1];
      var445[0] = 32;
      var445[1] = 16;
      var445[2] = 32;
      var445[3] = 34;
      var261[var3] = var445;
      var88[0] = var261;
      byte[][] var262 = new byte[var1][];
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 0;
      var445[2] = 24;
      var445[3] = 24;
      var262[0] = var445;
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 24;
      var445[2] = 30;
      var445[3] = 27;
      var262[var2] = var445;
      var445 = new byte[var1];
      var445[0] = 24;
      var445[1] = 0;
      var445[2] = 22;
      var445[3] = 16;
      var262[var4] = var445;
      var445 = new byte[var1];
      var445[0] = 30;
      var445[1] = 16;
      var445[2] = 32;
      var445[3] = 33;
      var262[var3] = var445;
      var88[var2] = var262;
      byte[][] var263 = new byte[5][];
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 0;
      var445[2] = 28;
      var445[3] = 16;
      var263[0] = var445;
      var445 = new byte[var1];
      var445[0] = 28;
      var445[1] = 0;
      var445[2] = 20;
      var445[3] = 15;
      var263[var2] = var445;
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 16;
      var445[2] = 28;
      var445[3] = 12;
      var263[var4] = var445;
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 28;
      var445[2] = 28;
      var445[3] = 22;
      var263[var3] = var445;
      var445 = new byte[var1];
      var445[0] = 28;
      var445[1] = 26;
      var445[2] = 32;
      var445[3] = 24;
      var263[var1] = var445;
      var88[var4] = var263;
      byte[][] var264 = new byte[var3][];
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 0;
      var445[2] = 22;
      var445[3] = 32;
      var264[0] = var445;
      var445 = new byte[var1];
      var445[0] = 22;
      var445[1] = 0;
      var445[2] = 32;
      var445[3] = 41;
      var264[var2] = var445;
      var445 = new byte[var1];
      var445[0] = 54;
      var445[1] = 0;
      var445[2] = 32;
      var445[3] = 35;
      var264[var4] = var445;
      var88[var3] = var264;
      byte[][] var265 = new byte[5][];
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 0;
      var445[2] = 18;
      var445[3] = 16;
      var265[0] = var445;
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 16;
      var445[2] = 26;
      var445[3] = 20;
      var265[var2] = var445;
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 36;
      var445[2] = 32;
      var445[3] = 11;
      var265[var4] = var445;
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 47;
      var445[2] = 32;
      var445[3] = 13;
      var265[var3] = var445;
      var445 = new byte[var1];
      var445[0] = 0;
      var445[1] = 60;
      var445[2] = 32;
      var445[3] = 24;
      var265[var1] = var445;
      var88[var1] = var265;
      byte[][] var589 = new byte[var3][];
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 0;
      var901[2] = 36;
      var901[3] = 34;
      var589[0] = var901;
      var901 = new byte[var1];
      var901[0] = 36;
      var901[1] = 0;
      var901[2] = 42;
      var901[3] = 39;
      var589[var2] = var901;
      var901 = new byte[var1];
      var901[0] = 78;
      var901[1] = 0;
      var901[2] = 44;
      var901[3] = 41;
      var589[var4] = var901;
      var88[5] = var589;
      byte[][] var590 = new byte[var1][];
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 0;
      var901[2] = 44;
      var901[3] = 44;
      var590[0] = var901;
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 44;
      var901[2] = 44;
      var901[3] = 9;
      var590[var2] = var901;
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 53;
      var901[2] = 44;
      var901[3] = 45;
      var590[var4] = var901;
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 98;
      var901[2] = 44;
      var901[3] = 46;
      var590[var3] = var901;
      var88[6] = var590;
      byte[][] var591 = new byte[var3][];
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 0;
      var901[2] = 35;
      var901[3] = 29;
      var591[0] = var901;
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 29;
      var901[2] = 38;
      var901[3] = 35;
      var591[var2] = var901;
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 64;
      var901[2] = 36;
      var901[3] = 36;
      var591[var4] = var901;
      var88[7] = var591;
      byte[][] var592 = new byte[var3][];
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 0;
      var901[2] = 48;
      var901[3] = 46;
      var592[0] = var901;
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 46;
      var901[2] = 48;
      var901[3] = 48;
      var592[var2] = var901;
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 94;
      var901[2] = 48;
      var901[3] = 51;
      var592[var4] = var901;
      var88[8] = var592;
      byte[][] var593 = new byte[var3][];
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 0;
      var901[2] = 44;
      var901[3] = 44;
      var593[0] = var901;
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 44;
      var901[2] = 48;
      var901[3] = 50;
      var593[var2] = var901;
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 94;
      var901[2] = 48;
      var901[3] = 53;
      var593[var4] = var901;
      var88[9] = var593;
      byte[][] var594 = new byte[9][];
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 0;
      var901[2] = 28;
      var901[3] = 25;
      var594[0] = var901;
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 25;
      var901[2] = 22;
      var901[3] = 16;
      var594[var2] = var901;
      var901 = new byte[var1];
      var901[0] = 28;
      var901[1] = 0;
      var901[2] = 26;
      var901[3] = 25;
      var594[var4] = var901;
      var901 = new byte[var1];
      var901[0] = 22;
      var901[1] = 25;
      var901[2] = 32;
      var901[3] = 27;
      var594[var3] = var901;
      var901 = new byte[var1];
      var901[0] = 0;
      var901[1] = 41;
      var901[2] = 16;
      var901[3] = 16;
      var594[var1] = var901;
      byte[] var1052 = new byte[var1];
      var1052[0] = 0;
      var1052[1] = 57;
      var1052[2] = 16;
      var1052[3] = 16;
      var594[5] = var1052;
      var1052 = new byte[var1];
      var1052[0] = 22;
      var1052[1] = 52;
      var1052[2] = 16;
      var1052[3] = 16;
      var594[6] = var1052;
      var1052 = new byte[var1];
      var1052[0] = 38;
      var1052[1] = 52;
      var1052[2] = 16;
      var1052[3] = 16;
      var594[7] = var1052;
      var1052 = new byte[var1];
      var1052[0] = 16;
      var1052[1] = 68;
      var1052[2] = 16;
      var1052[3] = 16;
      var594[8] = var1052;
      var88[10] = var594;
      this.f1112 = var88;
      byte[][][] var89 = new byte[11][][];
      byte[][] var266 = new byte[var3][];
      var445 = new byte[]{0, -13, -15, 1, -11, -20};
      var266[0] = var445;
      var445 = new byte[]{2, -16, -16, 1, -11, -21};
      var266[var2] = var445;
      var445 = new byte[]{3, -16, -20, 1, -11, -23};
      var266[var4] = var445;
      var89[0] = var266;
      byte[][] var267 = new byte[var3][];
      var445 = new byte[]{0, -12, -15, 2, -11, -20};
      var267[0] = var445;
      var445 = new byte[]{1, -15, -15, 2, -11, -22};
      var267[var2] = var445;
      var445 = new byte[]{3, -16, -19, 2, -11, -25};
      var267[var4] = var445;
      var89[var2] = var267;
      byte[][] var268 = new byte[var3][];
      var445 = new byte[]{0, -14, -17, 2, -14, -1, 1, -10, -24};
      var268[0] = var445;
      var445 = new byte[]{3, -14, -23, 2, -14, -1, 1, -10, -24};
      var268[var2] = var445;
      var445 = new byte[]{4, -16, -25, 2, -14, -1, 1, -10, -29};
      var268[var4] = var445;
      var89[var4] = var268;
      byte[][] var269 = new byte[var3][];
      var445 = new byte[var3];
      var445[0] = 0;
      var445[1] = -11;
      var445[2] = -22;
      var269[0] = var445;
      var445 = new byte[var3];
      var445[0] = 1;
      var445[1] = -17;
      var445[2] = -27;
      var269[var2] = var445;
      var445 = new byte[var3];
      var445[0] = 2;
      var445[1] = -17;
      var445[2] = -23;
      var269[var4] = var445;
      var89[var3] = var269;
      byte[][] var270 = new byte[var3][];
      var445 = new byte[]{0, -9, -7, 1, -13, -22};
      var270[0] = var445;
      var445 = new byte[]{2, -16, -13, 3, -16, -2, 1, -13, -22};
      var270[var2] = var445;
      var445 = new byte[]{4, -16, -25, 3, -16, -1, 1, -13, -33};
      var270[var4] = var445;
      var89[var1] = var270;
      byte[][] var610 = new byte[var3][];
      var901 = new byte[var3];
      var901[0] = 0;
      var901[1] = -18;
      var901[2] = -18;
      var610[0] = var901;
      var901 = new byte[var3];
      var901[0] = 1;
      var901[1] = -21;
      var901[2] = -21;
      var610[var2] = var901;
      var901 = new byte[var3];
      var901[0] = 2;
      var901[1] = -22;
      var901[2] = -21;
      var610[var4] = var901;
      var89[5] = var610;
      byte[][] var611 = new byte[var3][];
      var901 = new byte[]{0, -22, -32, 1, -22, 12};
      var611[0] = var901;
      var901 = new byte[]{2, -22, -33, 1, -22, 12};
      var611[var2] = var901;
      var901 = new byte[]{3, -22, -34, 1, -22, 12};
      var611[var4] = var901;
      var89[6] = var611;
      byte[][] var612 = new byte[var3][];
      var901 = new byte[var3];
      var901[0] = 0;
      var901[1] = -18;
      var901[2] = -16;
      var612[0] = var901;
      var901 = new byte[var3];
      var901[0] = 1;
      var901[1] = -20;
      var901[2] = -20;
      var612[var2] = var901;
      var901 = new byte[var3];
      var901[0] = 2;
      var901[1] = -17;
      var901[2] = -21;
      var612[var4] = var901;
      var89[7] = var612;
      byte[][] var613 = new byte[var3][];
      var901 = new byte[var3];
      var901[0] = 0;
      var901[1] = -24;
      var901[2] = -30;
      var613[0] = var901;
      var901 = new byte[var3];
      var901[0] = 1;
      var901[1] = -24;
      var901[2] = -30;
      var613[var2] = var901;
      var901 = new byte[var3];
      var901[0] = 2;
      var901[1] = -24;
      var901[2] = -30;
      var613[var4] = var901;
      var89[8] = var613;
      byte[][] var614 = new byte[var3][];
      var901 = new byte[var3];
      var901[0] = 0;
      var901[1] = -22;
      var901[2] = -28;
      var614[0] = var901;
      var901 = new byte[var3];
      var901[0] = 1;
      var901[1] = -24;
      var901[2] = -31;
      var614[var2] = var901;
      var901 = new byte[var3];
      var901[0] = 2;
      var901[1] = -24;
      var901[2] = -31;
      var614[var4] = var901;
      var89[9] = var614;
      byte[][] var615 = new byte[var3][];
      var901 = new byte[]{0, -14, -17, 1, -11, -29};
      var615[0] = var901;
      var901 = new byte[]{0, -14, -17, 2, -13, -34};
      var615[var2] = var901;
      var901 = new byte[]{0, -14, -17, 3, -16, -37};
      var615[var4] = var901;
      var89[10] = var615;
      this.g1113 = var89;
      byte[][] var90 = new byte[11][];
      var198 = new byte[var3];
      var198[0] = 2;
      var198[1] = 2;
      var198[2] = 2;
      var90[0] = var198;
      var198 = new byte[var3];
      var198[0] = 2;
      var198[1] = 2;
      var198[2] = 2;
      var90[var2] = var198;
      var198 = new byte[var3];
      var198[0] = 3;
      var198[1] = 3;
      var198[2] = 3;
      var90[var4] = var198;
      var198 = new byte[var3];
      var198[0] = 1;
      var198[1] = 1;
      var198[2] = 1;
      var90[var3] = var198;
      var198 = new byte[var3];
      var198[0] = 2;
      var198[1] = 3;
      var198[2] = 3;
      var90[var1] = var198;
      var445 = new byte[var3];
      var445[0] = 1;
      var445[1] = 1;
      var445[2] = 1;
      var90[5] = var445;
      var445 = new byte[var3];
      var445[0] = 2;
      var445[1] = 2;
      var445[2] = 2;
      var90[6] = var445;
      var445 = new byte[var3];
      var445[0] = 1;
      var445[1] = 1;
      var445[2] = 1;
      var90[7] = var445;
      var445 = new byte[var3];
      var445[0] = 1;
      var445[1] = 1;
      var445[2] = 1;
      var90[8] = var445;
      var445 = new byte[var3];
      var445[0] = 1;
      var445[1] = 1;
      var445[2] = 1;
      var90[9] = var445;
      var445 = new byte[var3];
      var445[0] = 2;
      var445[1] = 2;
      var445[2] = 2;
      var90[10] = var445;
      this.q1114 = var90;
      byte[][] var91 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = 8;
      var91[0] = var198;
      var198 = new byte[var4];
      var198[0] = -6;
      var198[1] = 8;
      var91[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = 0;
      var91[var4] = var198;
      var198 = new byte[var4];
      var198[0] = 6;
      var198[1] = 8;
      var91[var3] = var198;
      this.r1115 = var91;
      int[] var92 = new int[]{16777191, 15457227, 7730877, 15656911, 7049925, 7730877, 7730877, 7049925, 15656911};
      this.l1116 = var92;
      byte[][] var93 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = 0;
      var93[0] = var198;
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = 1;
      var93[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = 0;
      var93[var4] = var198;
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = 1;
      var93[var3] = var198;
      this.s1117 = var93;
      byte[][] var94 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = 5;
      var94[0] = var198;
      var198 = new byte[var4];
      var198[0] = 29;
      var198[1] = -5;
      var94[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = 27;
      var94[var4] = var198;
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = -5;
      var94[var3] = var198;
      this.t1118 = var94;
      byte[][] var95 = new byte[var3][];
      var198 = new byte[var4];
      var198[0] = 33;
      var198[1] = -9;
      var95[0] = var198;
      var198 = new byte[var4];
      var198[0] = 43;
      var198[1] = -18;
      var95[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 58;
      var198[1] = -27;
      var95[var4] = var198;
      this.u1119 = var95;
      byte[][] var96 = new byte[var3][];
      var198 = new byte[var4];
      var198[0] = -33;
      var198[1] = -27;
      var96[0] = var198;
      var198 = new byte[var4];
      var198[0] = -18;
      var198[1] = -18;
      var96[var2] = var198;
      var198 = new byte[var4];
      var198[0] = -8;
      var198[1] = -9;
      var96[var4] = var198;
      this.v1120 = var96;
      byte[][][] var97 = new byte[var1][][];
      byte[][] var294 = new byte[var3][];
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 52;
      var294[0] = var445;
      var445 = new byte[var4];
      var445[0] = 52;
      var445[1] = 14;
      var294[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 66;
      var445[1] = 16;
      var294[var4] = var445;
      var97[0] = var294;
      byte[][] var295 = new byte[var3][];
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 13;
      var295[0] = var445;
      var445 = new byte[var4];
      var445[0] = 13;
      var445[1] = 16;
      var295[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 29;
      var445[1] = 23;
      var295[var4] = var445;
      var97[var2] = var295;
      byte[][] var296 = new byte[var3][];
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 32;
      var296[0] = var445;
      var445 = new byte[var4];
      var445[0] = 32;
      var445[1] = 23;
      var296[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 55;
      var445[1] = 15;
      var296[var4] = var445;
      var97[var4] = var296;
      byte[][] var297 = new byte[var3][];
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 23;
      var297[0] = var445;
      var445 = new byte[var4];
      var445[0] = 23;
      var445[1] = 16;
      var297[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 39;
      var445[1] = 13;
      var297[var4] = var445;
      var97[var3] = var297;
      this.h1121 = var97;
      byte[][][] var98 = new byte[11][][];
      byte[][] var298 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = -5;
      var445[1] = -31;
      var298[0] = var445;
      var445 = new byte[var4];
      var445[0] = 6;
      var445[1] = -24;
      var298[var2] = var445;
      var445 = new byte[var4];
      var445[0] = -5;
      var445[1] = -16;
      var298[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -14;
      var445[1] = -24;
      var298[var3] = var445;
      var98[0] = var298;
      byte[][] var299 = new byte[0][];
      var98[var2] = var299;
      byte[][] var300 = new byte[var2][];
      var445 = new byte[var4];
      var445[0] = -3;
      var445[1] = -2;
      var300[0] = var445;
      var98[var4] = var300;
      byte[][] var301 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = -11;
      var445[1] = -31;
      var301[0] = var445;
      var445 = new byte[var4];
      var445[0] = -14;
      var445[1] = -9;
      var301[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = -7;
      var301[var4] = var445;
      var445 = new byte[var4];
      var445[0] = 8;
      var445[1] = -21;
      var301[var3] = var445;
      var98[var3] = var301;
      byte[][] var302 = new byte[var2][];
      var445 = new byte[var4];
      var445[0] = -6;
      var445[1] = -27;
      var302[0] = var445;
      var98[var1] = var302;
      byte[][] var644 = new byte[var2][];
      var901 = new byte[var4];
      var901[0] = -6;
      var901[1] = -9;
      var644[0] = var901;
      var98[5] = var644;
      byte[][] var645 = new byte[0][];
      var98[6] = var645;
      byte[][] var646 = new byte[var4][];
      var901 = new byte[var4];
      var901[0] = -18;
      var901[1] = -34;
      var646[0] = var901;
      var901 = new byte[var4];
      var901[0] = 5;
      var901[1] = -34;
      var646[var2] = var901;
      var98[7] = var646;
      byte[][] var647 = new byte[var2][];
      var901 = new byte[var4];
      var901[0] = -7;
      var901[1] = -19;
      var647[0] = var901;
      var98[8] = var647;
      byte[][] var648 = new byte[var2][];
      var901 = new byte[var4];
      var901[0] = -8;
      var901[1] = -18;
      var648[0] = var901;
      var98[9] = var648;
      byte[][] var649 = new byte[0][];
      var98[10] = var649;
      this.i1122 = var98;
      byte[][] var99 = new byte[11][];
      var198 = new byte[]{0, 1, 1, 2, 2, 1, 1, 3, 3, 1, 1, 2, 2, 1, 1, 3, 3, 1, 1, 0, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0};
      var99[0] = var198;
      var198 = new byte[0];
      var99[var2] = var198;
      var198 = new byte[]{0, 1, 2, 3, 2, 3, 2, 3, 2, 3, 3, 2, 1, 0, 4, 4, 4, 4, 4, 4, 4, 4, 6, 12};
      var99[var4] = var198;
      var198 = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 5, 15};
      var99[var3] = var198;
      var198 = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 17};
      var99[var1] = var198;
      var445 = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 11};
      var99[5] = var445;
      var445 = new byte[0];
      var99[6] = var445;
      var445 = new byte[]{0, 1, 2, 0, 1, 2, 0, 1, 2, 13, 33};
      var99[7] = var445;
      var445 = new byte[]{0, 1, 2, 3, 4, 5, 6, 6, 6, 14, 14};
      var99[8] = var445;
      var445 = new byte[]{0, 1, 2, 2, 2, 2, 1, 0, 3, 3, 3, 16, 12};
      var99[9] = var445;
      var445 = new byte[0];
      var99[10] = var445;
      this.w1123 = var99;
      byte[] var100 = new byte[]{0, 2, 3, 3, 2, 1, 0, -1, -2, -1};
      this.x1124 = var100;
      byte[] var101 = new byte[]{-5, -20, 10, 3, 8, -15, 6, 9, -5, -4, 10, 6, -14, -15, 6, 9};
      this.y1125 = var101;
      int[] var102 = new int[]{var3, var3};
      boolean[][] var103 = (boolean[][])Array.newInstance(boolean.class, var102);
      this.a1127 = var103;
      byte[][] var104 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = -16;
      var104[0] = var198;
      var198 = new byte[var4];
      var198[0] = 16;
      var198[1] = 1;
      var104[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = 16;
      var104[var4] = var198;
      var198 = new byte[var4];
      var198[0] = -16;
      var198[1] = 1;
      var104[var3] = var198;
      this.x1128 = var104;
      int[] var105 = new int[var1];
      this.m1129 = var105;
      byte[][] var106 = new byte[var3][];
      var198 = new byte[]{0, 6, 7, 8, 9, 10, 2, 3, 4, 5, 1};
      var106[0] = var198;
      var198 = new byte[]{11, 17, 18, 19, 20, 21, 13, 14, 15, 16, 12};
      var106[var2] = var198;
      var198 = new byte[]{22, 28, 29, 30, 31, 32, 24, 25, 26, 27, 23};
      var106[var4] = var198;
      this.y1130 = var106;
      byte[][] var107 = new byte[9][];
      var198 = new byte[var3];
      var198[0] = 33;
      var198[1] = 34;
      var198[2] = 35;
      var107[0] = var198;
      var198 = new byte[var1];
      var198[0] = 36;
      var198[1] = 37;
      var198[2] = 38;
      var198[3] = 39;
      var107[var2] = var198;
      var198 = new byte[]{16, 40, 41, 42, 13, 0, 4, 5, 1, 8};
      var107[var4] = var198;
      var198 = new byte[]{42, 43, 13, 40, 44, 45, 0, 8, 32, 25, 47, 31};
      var107[var3] = var198;
      var198 = new byte[]{13, 45, 44, 42, 41, 46, 23, 24, 30, 22, 26, 47};
      var107[var1] = var198;
      var445 = new byte[]{0, 2, 5, 6, 3, 8, 22, 29, 24, 25, 26, 23};
      var107[5] = var445;
      var445 = new byte[]{2, 8, 5, 3, 7};
      var107[6] = var445;
      var445 = new byte[]{13, 16, 40, 46, 17};
      var107[7] = var445;
      var445 = new byte[]{24, 26, 28, 29, 22};
      var107[8] = var445;
      this.z1131 = var107;
      byte[][] var108 = new byte[var3][];
      var198 = new byte[]{0, 0, 0, 0, 2, 1, 2, 0, 0};
      var108[0] = var198;
      var198 = new byte[]{0, 0, 1, 1, 1, 2, 0, 2, 0};
      var108[var2] = var198;
      var198 = new byte[]{0, 0, 2, 0, 0, 0, 0, 0, 2};
      var108[var4] = var198;
      this.A1132 = var108;
      byte[][] var109 = new byte[5][];
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = 0;
      var109[0] = var198;
      var198 = new byte[var4];
      var198[0] = 10;
      var198[1] = 10;
      var109[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 18;
      var198[1] = 3;
      var109[var4] = var198;
      var198 = new byte[var4];
      var198[0] = 4;
      var198[1] = 9;
      var109[var3] = var198;
      var198 = new byte[var4];
      var198[0] = 14;
      var198[1] = 9;
      var109[var1] = var198;
      this.B1133 = var109;
      int[] var110 = new int[]{30, 12};
      byte[][] var111 = (byte[][])Array.newInstance(byte.class, var110);
      this.C1134 = var111;
      byte[][] var112 = new byte[var3][];
      var198 = new byte[var1];
      var198[0] = 0;
      var198[1] = 15;
      var198[2] = 0;
      var198[3] = 0;
      var112[0] = var198;
      var198 = new byte[var1];
      var198[0] = 15;
      var198[1] = 23;
      var198[2] = -4;
      var198[3] = 1;
      var112[var2] = var198;
      var198 = new byte[var1];
      var198[0] = 38;
      var198[1] = 21;
      var198[2] = -3;
      var198[3] = 0;
      var112[var4] = var198;
      this.D1135 = var112;
      byte[][] var113 = new byte[9][];
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = -16;
      var113[0] = var198;
      var198 = new byte[var4];
      var198[0] = 16;
      var198[1] = -16;
      var113[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 32;
      var198[1] = -16;
      var113[var4] = var198;
      var198 = new byte[var4];
      var198[0] = -8;
      var198[1] = -6;
      var113[var3] = var198;
      var198 = new byte[var4];
      var198[0] = -8;
      var198[1] = 8;
      var113[var1] = var198;
      var445 = new byte[var4];
      var445[0] = -8;
      var445[1] = 22;
      var113[5] = var445;
      var445 = new byte[var4];
      var445[0] = 41;
      var445[1] = -6;
      var113[6] = var445;
      var445 = new byte[var4];
      var445[0] = 41;
      var445[1] = 8;
      var113[7] = var445;
      var445 = new byte[var4];
      var445[0] = 41;
      var445[1] = 22;
      var113[8] = var445;
      this.E1136 = var113;
      byte[][] var114 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = -48;
      var114[0] = var198;
      var198 = new byte[var4];
      var198[0] = 48;
      var198[1] = 0;
      var114[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = 64;
      var114[var4] = var198;
      var198 = new byte[var4];
      var198[0] = -48;
      var198[1] = 0;
      var114[var3] = var198;
      this.F1137 = var114;
      byte[][] var115 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = -10;
      var115[0] = var198;
      var198 = new byte[var4];
      var198[0] = 21;
      var198[1] = -10;
      var115[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = 11;
      var115[var4] = var198;
      var198 = new byte[var4];
      var198[0] = 21;
      var198[1] = 11;
      var115[var3] = var198;
      this.G1138 = var115;
      byte[][][] var116 = new byte[var3][][];
      byte[][] var344 = new byte[7][];
      var445 = new byte[var4];
      var445[0] = -8;
      var445[1] = -29;
      var344[0] = var445;
      var445 = new byte[var4];
      var445[0] = 6;
      var445[1] = -19;
      var344[var2] = var445;
      var445 = new byte[var4];
      var445[0] = -8;
      var445[1] = -6;
      var344[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -19;
      var445[1] = -19;
      var344[var3] = var445;
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 0;
      var344[var1] = var445;
      var901 = new byte[var4];
      var901[0] = 0;
      var901[1] = -1;
      var344[5] = var901;
      var901 = new byte[var4];
      var901[0] = 0;
      var901[1] = -3;
      var344[6] = var901;
      var116[0] = var344;
      byte[][] var345 = new byte[7][];
      var445 = new byte[var4];
      var445[0] = -8;
      var445[1] = -31;
      var345[0] = var445;
      var445 = new byte[var4];
      var445[0] = 7;
      var445[1] = -20;
      var345[var2] = var445;
      var445 = new byte[var4];
      var445[0] = -8;
      var445[1] = -6;
      var345[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -21;
      var445[1] = -20;
      var345[var3] = var445;
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 0;
      var345[var1] = var445;
      var901 = new byte[var4];
      var901[0] = 0;
      var901[1] = 0;
      var345[5] = var901;
      var901 = new byte[var4];
      var901[0] = 0;
      var901[1] = -11;
      var345[6] = var901;
      var116[var2] = var345;
      byte[][] var346 = new byte[7][];
      var445 = new byte[var4];
      var445[0] = -8;
      var445[1] = -29;
      var346[0] = var445;
      var445 = new byte[var4];
      var445[0] = 6;
      var445[1] = -18;
      var346[var2] = var445;
      var445 = new byte[var4];
      var445[0] = -8;
      var445[1] = -6;
      var346[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -19;
      var445[1] = -18;
      var346[var3] = var445;
      var445 = new byte[var4];
      var445[0] = 0;
      var445[1] = 0;
      var346[var1] = var445;
      var901 = new byte[var4];
      var901[0] = 0;
      var901[1] = -2;
      var346[5] = var901;
      var901 = new byte[var4];
      var901[0] = 0;
      var901[1] = -5;
      var346[6] = var901;
      var116[var4] = var346;
      this.j1139 = var116;
      byte[][] var117 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = -1;
      var198[1] = -1;
      var117[0] = var198;
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = -1;
      var117[var2] = var198;
      var198 = new byte[var4];
      var198[0] = -1;
      var198[1] = 0;
      var117[var4] = var198;
      var198 = new byte[var4];
      var198[0] = -2;
      var198[1] = 1;
      var117[var3] = var198;
      byte[][] var118 = new byte[7][];
      var198 = new byte[var3];
      var198[0] = -19;
      var198[1] = -25;
      var198[2] = 0;
      var118[0] = var198;
      var198 = new byte[var3];
      var198[0] = -2;
      var198[1] = -27;
      var198[2] = 0;
      var118[var2] = var198;
      var198 = new byte[var3];
      var198[0] = 8;
      var198[1] = -18;
      var198[2] = 2;
      var118[var4] = var198;
      var198 = new byte[var3];
      var198[0] = 4;
      var198[1] = -2;
      var198[2] = 1;
      var118[var3] = var198;
      var198 = new byte[var3];
      var198[0] = -10;
      var198[1] = 6;
      var198[2] = 2;
      var118[var1] = var198;
      var445 = new byte[var3];
      var445[0] = -24;
      var445[1] = 4;
      var445[2] = 0;
      var118[5] = var445;
      var445 = new byte[var3];
      var445[0] = -16;
      var445[1] = -9;
      var445[2] = 0;
      var118[6] = var445;
      this.H1140 = var118;
      byte[][][] var119 = new byte[var3][][];
      byte[][] var356 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = 12;
      var445[1] = -19;
      var356[0] = var445;
      var445 = new byte[var4];
      var445[0] = 48;
      var445[1] = 13;
      var356[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 12;
      var445[1] = 53;
      var356[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -17;
      var445[1] = 13;
      var356[var3] = var445;
      var119[0] = var356;
      byte[][] var357 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = 12;
      var445[1] = -29;
      var357[0] = var445;
      var445 = new byte[var4];
      var445[0] = 64;
      var445[1] = 12;
      var357[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 12;
      var445[1] = 69;
      var357[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -33;
      var445[1] = 12;
      var357[var3] = var445;
      var119[var2] = var357;
      byte[][] var358 = new byte[var1][];
      var445 = new byte[var4];
      var445[0] = 13;
      var445[1] = -46;
      var358[0] = var445;
      var445 = new byte[var4];
      var445[0] = 80;
      var445[1] = 13;
      var358[var2] = var445;
      var445 = new byte[var4];
      var445[0] = 13;
      var445[1] = 88;
      var358[var4] = var445;
      var445 = new byte[var4];
      var445[0] = -49;
      var445[1] = 12;
      var358[var3] = var445;
      var119[var4] = var358;
      this.k1141 = var119;
      byte[][] var120 = new byte[var1][];
      var198 = new byte[var1];
      var198[0] = 9;
      var198[1] = 2;
      var198[2] = 23;
      var198[3] = 20;
      var120[0] = var198;
      var198 = new byte[var1];
      var198[0] = 10;
      var198[1] = 0;
      var198[2] = 17;
      var198[3] = 23;
      var120[var2] = var198;
      var198 = new byte[var1];
      var198[0] = 9;
      var198[1] = 0;
      var198[2] = 23;
      var198[3] = 20;
      var120[var4] = var198;
      var198 = new byte[var1];
      var198[0] = 10;
      var198[1] = 1;
      var198[2] = 17;
      var198[3] = 23;
      var120[var3] = var198;
      this.I1142 = var120;
      byte[][][] var121 = new byte[var1][][];
      byte[][] var363 = new byte[var1][];
      var445 = new byte[]{11, 7, -18, 2, 13, 23};
      var363[0] = var445;
      var445 = new byte[]{12, 29, -19, 0, 17, 16};
      var363[var2] = var445;
      var445 = new byte[]{11, 28, -45, 2, 13, 23};
      var363[var4] = var445;
      var445 = new byte[]{12, -2, -43, 0, 17, 16};
      var363[var3] = var445;
      var121[0] = var363;
      byte[][] var364 = new byte[var1][];
      var445 = new byte[]{13, 44, -2, 1, 17, 14};
      var364[0] = var445;
      var445 = new byte[]{14, 48, 23, 1, 19, 13};
      var364[var2] = var445;
      var445 = new byte[]{15, 80, 11, 1, 17, 9};
      var364[var4] = var445;
      var445 = new byte[]{16, 73, 33, 1, 21, 10};
      var364[var3] = var445;
      var121[var2] = var364;
      byte[][] var365 = new byte[var1][];
      var445 = new byte[]{11, 7, 49, 0, 13, 23};
      var365[0] = var445;
      var445 = new byte[]{12, 29, 59, 0, 17, 16};
      var365[var2] = var445;
      var445 = new byte[]{11, 28, 84, 1, 13, 23};
      var365[var4] = var445;
      var445 = new byte[]{12, 2, 94, 1, 17, 16};
      var365[var3] = var445;
      var121[var4] = var365;
      byte[][] var366 = new byte[var1][];
      var445 = new byte[]{13, -15, -2, 0, 17, 14};
      var366[0] = var445;
      var445 = new byte[]{14, -17, 23, 0, 19, 13};
      var366[var2] = var445;
      var445 = new byte[]{15, -49, 11, 0, 17, 9};
      var366[var4] = var445;
      var445 = new byte[]{16, -46, 33, 0, 21, 10};
      var366[var3] = var445;
      var121[var3] = var366;
      this.l1143 = var121;
      byte[][] var122 = new byte[var3][];
      var198 = new byte[var4];
      var198[0] = -14;
      var198[1] = -27;
      var122[0] = var198;
      var198 = new byte[var4];
      var198[0] = -14;
      var198[1] = -32;
      var122[var2] = var198;
      var198 = new byte[var4];
      var198[0] = -14;
      var198[1] = -27;
      var122[var4] = var198;
      this.J1144 = var122;
      byte[][] var123 = new byte[var3][];
      var198 = new byte[var4];
      var198[0] = -14;
      var198[1] = -11;
      var123[0] = var198;
      var198 = new byte[var4];
      var198[0] = 4;
      var198[1] = -16;
      var123[var2] = var198;
      var198 = new byte[var4];
      var198[0] = -14;
      var198[1] = -15;
      var123[var4] = var198;
      this.K1145 = var123;
      byte[][] var124 = new byte[var3][];
      var198 = new byte[var1];
      var198[0] = -80;
      var198[1] = 31;
      var198[2] = 16;
      var198[3] = 18;
      var124[0] = var198;
      var198 = new byte[var1];
      var198[0] = -54;
      var198[1] = 0;
      var198[2] = 16;
      var198[3] = 31;
      var124[var2] = var198;
      var198 = new byte[var1];
      var198[0] = -10;
      var198[1] = 31;
      var198[2] = 16;
      var198[3] = 18;
      var124[var4] = var198;
      this.L1146 = var124;
      byte[][] var125 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = 16;
      var198[1] = -39;
      var125[0] = var198;
      var198 = new byte[var4];
      var198[0] = 46;
      var198[1] = 14;
      var125[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 19;
      var198[1] = 48;
      var125[var4] = var198;
      var198 = new byte[var4];
      var198[0] = -48;
      var198[1] = 14;
      var125[var3] = var198;
      this.M1147 = var125;
      byte[] var126 = new byte[13];
      var126[0] = 0;
      var126[var2] = var2;
      var126[var4] = var4;
      var126[var3] = var4;
      var126[var1] = var4;
      var126[5] = var4;
      var126[6] = var4;
      var126[7] = var4;
      var126[8] = var4;
      var126[9] = var4;
      var126[10] = var4;
      var126[11] = var2;
      var126[12] = 0;
      byte[] var127 = new byte[]{0, -6, -8, -12, -14};
      this.z1148 = var127;
      byte[][] var128 = new byte[var3][];
      var198 = new byte[]{0, 0, 40, 32, 9, 10};
      var128[0] = var198;
      var198 = new byte[]{40, 0, 36, 29, 11, 11};
      var128[var2] = var198;
      var198 = new byte[]{76, 0, 28, 16, 15, 17};
      var128[var4] = var198;
      this.N1149 = var128;
      byte[][][] var129 = new byte[var4][][];
      byte[][] var383 = new byte[6][];
      var445 = new byte[]{0, 0, 10, 11, 9, 6};
      var383[0] = var445;
      var445 = new byte[]{0, 11, 6, 7, 12, 37};
      var383[var2] = var445;
      var445 = new byte[]{6, 11, 12, 5, 0, 23};
      var383[var4] = var445;
      var445 = new byte[]{23, 0, 2, 13, 28, 44};
      var383[var3] = var445;
      var445 = new byte[]{18, 0, 10, 11, 44, 0};
      var383[var1] = var445;
      var901 = new byte[]{22, 11, 6, 7, 38, 35};
      var383[5] = var901;
      var129[0] = var383;
      byte[][] var384 = new byte[7][];
      var445 = new byte[]{0, 11, 6, 7, 18, 30};
      var384[0] = var445;
      var445 = new byte[]{11, 0, 13, 11, 10, 8};
      var384[var2] = var445;
      var445 = new byte[]{6, 11, 12, 5, 12, 24};
      var384[var4] = var445;
      var445 = new byte[]{23, 0, 2, 13, 29, 33};
      var384[var3] = var445;
      var445 = new byte[]{25, 0, 3, 13, 28, 2};
      var384[var1] = var445;
      var901 = new byte[]{5, 0, 13, 11, 32, 11};
      var384[5] = var901;
      var901 = new byte[]{22, 11, 6, 7, 36, 34};
      var384[6] = var901;
      var129[var2] = var384;
      this.m1150 = var129;
      byte[] var130 = new byte[]{6, 6, 5, 5, 4, 4, 4};
      this.A1151 = var130;
      int[] var131 = new int[80];
      this.n1152 = var131;
      int[] var132 = new int[80];
      this.o1153 = var132;
      int[] var133 = new int[30];
      this.p1154 = var133;
      this.bA = 0;
      this.bB = 0;
      this.bC = 0;
      this.bD = 0;
      this.y1155 = (boolean)var2;
      this.bE = 16;
      byte[][] var134 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = 0;
      var134[0] = var198;
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = 0;
      var134[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = 1;
      var134[var4] = var198;
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = 1;
      var134[var3] = var198;
      this.O1156 = var134;
      byte[][] var135 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = -1;
      var198[1] = -1;
      var135[0] = var198;
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = -1;
      var135[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = 1;
      var135[var4] = var198;
      var198 = new byte[var4];
      var198[0] = -1;
      var198[1] = 1;
      var135[var3] = var198;
      this.P1157 = var135;
      int[] var136 = new int[]{13450878, 13450878, 14567546, 14567546, 16736642, 16736642, 14567546, 14567546};
      this.q1158 = var136;
      byte[][] var137 = new byte[var1][];
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = -1;
      var137[0] = var198;
      var198 = new byte[var4];
      var198[0] = 1;
      var198[1] = 0;
      var137[var2] = var198;
      var198 = new byte[var4];
      var198[0] = 0;
      var198[1] = 1;
      var137[var4] = var198;
      var198 = new byte[var4];
      var198[0] = -1;
      var198[1] = 0;
      var137[var3] = var198;
      this.Q1159 = var137;
      this.bK = 5;
      int[] var138 = new int[]{49, 57, 56, 48, 49, 50, 49, 53};
      this.r1166 = var138;
      int[] var139 = new int[]{57, 52, 52, 49, 49, 52, 49, 49};
      this.s1167 = var139;
      int[] var140 = new int[]{49, 56, 55, 56, 49, 54, 56, 51};
      this.t1168 = var140;
      String[] var141 = new String[15];
      var141[0] = "激活后可立即消灭当前所有敌人。[由yc激活分享]";
      var141[var2] = "激活后可立即获得全部科技。[由yc激活分享]";
      var141[var4] = "激活后可立即获得500金。[由yc激活分享]";
      var141[var3] = "激活后可立即获得10点城防。[由yc激活分享]";
      var141[var1] = "消灭敌人加钱翻倍，激活后可享受此服务。[由yc激活分享]";
      var141[5] = "此关卡为收费关卡，继续游戏需激活后可享受此服务。[由yc激活分享]";
      var141[6] = "继续上次退出时的计费存档，激活后可享受此服务。[由yc激活分享]";
      var141[7] = "检查更新中……";
      var141[8] = "激活中……";
      var141[9] = "成功！[由yc激活分享]";
      var141[10] = "购买失败！是否重试？";
      var141[11] = "发送短信不成功，可能因为您使用的不是官方版本。下载官方版本请手机访问wap.kgame.com.cn";
      var141[12] = "商店";
      var141[13] = "更多游戏";
      var141[14] = "视频下载";
      this.d1173 = var141;
      this.D1176 = (boolean)var2;
      this.a1193 = null;
      this.au();
      this.aw();
      this.l = 0;
      this.al = var4;
   }

   private void A() {
      int var1 = 3;
      int var2 = 1;
      byte var3 = -1;
      byte var4 = 2;
      int var5 = this.m1033;
      if (var5) {
         this.w();
      } else {
         var5 = this.l;
         switch (var5) {
            case 0:
               var5 = this.al;
               if (var5 != var4) {
                  Image var27 = this.b1032;
                  if (var27 != null) {
                     this.a1002.setClip(0, 0, 240, 320);
                     this.a1002.setColor(16777215);
                     Graphics var28 = this.a1002;
                     short var17 = 240;
                     var28.fillRect(0, 0, var17, 320);
                     Graphics var29 = this.a1002;
                     Image var30 = this.b1032;
                     Image var8 = this.b1032;
                     int var33 = var8.getWidth();
                     int var37 = 240 - var33 >> 1;
                     Image var11 = this.b1032;
                     var2 = var11.getHeight();
                     var33 = 320 - var2 >> 1;
                     var29.drawImage(var30, var37, var33, 0);
                  }
                  break;
               }
            case 19:
               this.y();
               break;
            case 1:
               this.l();
               break;
            case 2:
               this.ak();
               this.Y();
               this.ag();
               this.am();
               this.H();
               this.S();
               this.c(var4, 0);
               break;
            case 3:
               this.ak();
               this.Y();
               this.ag();
               this.H();
               this.j();
               this.c(var4, var3);
               break;
            case 4:
            case 20:
               String var26 = this.b1015[var2];
               this.a(var26);
               var5 = this.l;
               int var15 = 20;
               if (var5 == var15) {
                  byte var24 = 5;
                  Image[] var40 = this.a1013[4];
                  byte var32 = 25;
                  Image var41 = var40[var32];
                  int var36 = var41.getWidth();
                  var15 = 240 - var36 >> 1;
                  this.c(var24, var15, 0);
               }

               this.c(var3, var2);
               break;
            case 5:
            case 21:
               String var6 = this.b1015[0];
               this.a(var6);
               var5 = this.l;
               var1 = (byte)21;
               if (var5 == var1) {
                  byte var22 = 4;
                  Image[] var38 = this.a1013[4];
                  byte var31 = 25;
                  Image var39 = var38[var31];
                  int var35 = var39.getWidth();
                  var1 = 240 - var35 >> 1;
                  this.c(var22, var1, 0);
               }

               this.c(var3, var2);
               break;
            case 8:
               this.a((boolean)var2);
               this.c(var4, var3);
               break;
            case 9:
               this.a(false);
               this.c(var4, var3);
               break;
            case 10:
               this.W();
               Image var7 = this.a1013[var1][var1];
               int var9 = 13450878;
               boolean var10 = false;
               Object var12 = null;
               this.a(var7, 0, 0, var9, (boolean)var2);
               this.c(var4, var3);
               break;
            case 12:
               this.ak();
               this.Y();
               this.ag();
               this.H();
               this.c(var4, var2);
               break;
            case 13:
            case 14:
               this.ak();
               this.Y();
               this.ag();
               this.am();
               this.H();
               this.c(var4, var2);
               break;
            case 15:
               this.q();
               this.c(var4, var1);
               break;
            case 16:
               this.v();
               boolean var20 = this.t1089;
               if (!var20) {
                  this.c(var4, var1);
               } else {
                  this.c(var4, var3);
               }
               break;
            case 17:
               this.s();
               this.c(var4, var1);
               break;
            case 18:
               this.h();
               break;
            case 22:
               this.ak();
               this.Y();
               this.ag();
               this.am();
               this.Z();
               this.H();
               this.c(var4, var3);
               break;
            case 23:
               this.ak();
               this.am();
               this.ac();
               this.H();
               this.c(var4, var3);
               break;
            case 24:
               this.ak();
               this.Y();
               this.ag();
               this.H();
               this.ap();
               this.c(var4, var2);
               break;
            case 46:
            case 47:
            case 48:
               this.ar();
         }
      }
   }

   private void A(int var1) {
      int[] var2 = this.c1107[var1];
      int[][] var3 = this.b1066;
      int var4 = var2[8];
      int[] var5 = var3[var4];
      int var6 = var2[2];
      switch (var6) {
         case 0:
         case 4:
            var6 = var2[13];
            int var83 = 4;
            if (var6 < var83) {
               byte var191 = 13;
               var83 = var2[var191] + 1;
               var2[var191] = var83;
            }

            var6 = 0;
            var3 = null;

            while (true) {
               int var85 = 5;
               if (var6 >= var85) {
                  var6 = var2[13];
                  var85 = (byte)1;
                  label155:
                  if (var6 == var85) {
                     var6 = var2[2];
                     var85 = (byte)4;
                     if (var6 == var85) {
                        var6 = var5[26];
                        var85 = (byte)6;
                        if (var6 == var85) {
                           byte var197 = 27;
                           var85 = (byte)-1;
                           var5[var197] = var85;
                           break label155;
                        }
                     }

                     var6 = var2[8];
                     var85 = var2[2];
                     byte[] var257 = this.s1102;
                     int var251 = var2[3];
                     var85 = this.a(var85, var257, var251);
                     this.v(var6, var85, var1);
                  }

                  boolean var198 = this.i(var1);
                  if (var198) {
                     this.x(var1);
                  }

                  return;
               }

               byte[] var212 = this.C1134[var1];
               byte var233 = var212[var6];
               byte var250 = 1;
               var233 = (byte)(var233 - var250);
               var212[var6] = var233;
               byte var86 = -1;
               if (var233 < var86) {
                  var212 = this.C1134[var1];
                  var233 = -1;
                  var212[var6] = var233;
               }

               var6++;
            }
         case 1:
            var3 = null;
            var6 = var2[0];
            int[] var207 = this.o1098;
            int var229 = var2[2];
            var4 = var207[var229] << 3;
            var6 += var4;
            var4 = var2[11] << 2;
            int var11 = var6 + var4;
            var6 = var2[1];
            var207 = this.o1098;
            var229 = var2[2];
            var4 = var207[var229] << 3;
            var6 += var4;
            var4 = var2[12] << 2;
            int var12 = var6 + var4;
            int var173 = 13;
            var4 = var2[var173] + 1;
            var2[var173] = var4;
            var173 = (byte)12;
            if (var4 > var173) {
               var173 = (byte)13;
               boolean var74 = false;
               var207 = null;
               var2[var173] = 0;
               this.x(var1);
            } else {
               var173 = var2[13];
               int var75 = 4;
               if (var173 == var75) {
                  int var177 = 0;
                  var3 = null;
                  int var13 = 0;

                  while (true) {
                     var177 = this.aP;
                     if (var13 >= var177) {
                        var177 = var5[26];
                        var75 = (byte)8;
                        if (var177 == var75) {
                           byte var188 = 27;
                           var75 = (byte)-1;
                           var5[var188] = var75;
                        } else {
                           var177 = var2[8];
                           var75 = var2[2];
                           byte[] var256 = this.s1102;
                           int var249 = var2[3];
                           var75 = this.a(var75, var256, var249);
                           this.v(var177, var75, var1);
                        }

                        return;
                     }

                     int[] var27 = this.b1066[var13];
                     var177 = var27[0];
                     var207 = this.b1066[var13];
                     var75 = var207[1];
                     var229 = var11 - 24;
                     int var248 = var12 - 24;
                     byte var269 = 48;
                     byte var280 = 48;
                     int var180 = a(var177, var75, var229, var248, var269, var280);
                     if (var180) {
                        var180 = var2[8];
                        if (var13 != var180) {
                           var180 = var5[26];
                           byte var77 = 8;
                           if (var180 == var77) {
                              byte var183 = 27;
                              var77 = -1;
                              var5[var183] = var77;
                           } else {
                              var180 = var2[2];
                              byte[] var211 = this.s1102;
                              var229 = var2[3] >> 2;
                              var180 = this.a(var180, var211, var229);
                              this.v(var13, var180, var1);
                           }
                        }
                     }

                     var180 = var13 + 1;
                     var13 = var180;
                  }
               }
            }
            break;
         case 2:
            int var160 = 13;
            var4 = var2[var160] + 1;
            var2[var160] = var4;
            var160 = (byte)12;
            if (var4 > var160) {
               var4 = var2[0];
               int var225 = var2[1];
               var160 = (byte)5;
               int var245 = var2[var160];
               byte var266 = 1;
               boolean var277 = false;
               boolean var286 = true;
               this.a(var4, var225, var245, var266, 0, var286);
               this.x(var1);
            } else {
               var160 = var2[13] >> 2;
               int var64 = 3;
               if (var160 < var64) {
                  var64 = var2[0];
                  int var226 = var2[1];
                  int var246 = var2[5];
                  byte var267 = 5;
                  var160 = var2[13] >> 2;
                  int var278 = var160 + 1;
                  boolean var287 = true;
                  this.a(var64, var226, var246, var267, var278, var287);
               }

               var160 = var2[13];
               int var66 = 6;
               if (var160 > var66) {
                  var160 = var2[13] % 3;
                  if (var160 == 0) {
                     var66 = var2[0];
                     int var227 = var2[1];
                     int var247 = var2[5];
                     byte var268 = 1;
                     var160 = var2[13] - 6;
                     int var279 = (var2[13] - 6) / 3 + var160;
                     boolean var288 = true;
                     this.a(var66, var227, var247, var268, var279, var288);
                  }
               }
            }

            var160 = var2[2];
            var4 = var2[3];
            int var228 = var2[5];
            this.h(var1, var160, var4, var228);
            break;
         case 3:
         case 5:
         case 7:
            var6 = var2[10];
            if (var6 == 0) {
               byte var137 = 13;
               var4 = var2[var137] + 1;
               var2[var137] = var4;
               var137 = 12;
               if (var4 > var137) {
                  int var139 = this.e(var1);
                  if (var139) {
                     Object var204 = null;
                     var2[13] = 0;
                     var2[10] = 1;
                     var139 = var2[2];
                     int var48 = 5;
                     if (var139 == var48) {
                        var139 = var2[8];
                        var48 = var2[2];
                        byte[] var10 = this.s1102;
                        int var240 = var2[3];
                        var48 = this.a(var48, var10, var240);
                        this.v(var139, var48, var1);
                     } else {
                        var139 = var2[2];
                        int var51 = 3;
                        if (var139 == var51) {
                           var139 = var5[26];
                           var51 = (byte)5;
                           if (var139 != var51) {
                              var139 = var2[8];
                              var51 = var2[2];
                              byte[] var252 = this.s1102;
                              int var241 = var2[3];
                              var51 = this.a(var51, var252, var241);
                              this.v(var139, var51, var1);
                           }
                        }
                     }
                  }
               }
            } else {
               var6 = var2[10];
               int var55 = 1;
               if (var6 == var55) {
                  var6 = var2[2];
                  var55 = (byte)7;
                  if (var6 == var55) {
                     var6 = var2[13];
                     var55 = (byte)3;
                     if (var6 == var55) {
                        int var148 = 0;
                        var3 = null;
                        int var285 = 0;
                        var5 = null;

                        while (true) {
                           var148 = this.aP;
                           if (var285 >= var148) {
                              var148 = var2[8];
                              var55 = var2[2];
                              byte[] var255 = this.s1102;
                              int var244 = var2[3];
                              var55 = this.a(var55, var255, var244);
                              this.v(var148, var55, var1);
                              break;
                           }

                           int[] var24 = this.b1066[var285];
                           var148 = var24[0];
                           int[] var205 = this.b1066[var285];
                           var55 = var205[1];
                           int[][] var253 = this.b1066;
                           int var242 = var2[8];
                           int[] var254 = var253[var242];
                           int var222 = var254[0] - 24;
                           int[][] var17 = this.b1066;
                           int var264 = var2[8];
                           int[] var289 = var17[var264];
                           var242 = var289[1] - 24;
                           byte var265 = 48;
                           byte var276 = 48;
                           int var151 = a(var148, var55, var222, var242, var265, var276);
                           if (var151) {
                              var151 = var2[8];
                              if (var285 != var151) {
                                 var151 = var2[2];
                                 byte[] var206 = this.s1102;
                                 var222 = var2[3] >> 2;
                                 var151 = this.a(var151, var206, var222);
                                 this.v(var285, var151, var1);
                              }
                           }

                           var151 = var285 + 1;
                           var285 = var151;
                        }
                     }
                  }

                  int var157 = 13;
                  var55 = var2[var157] + 1;
                  var2[var157] = var55;
                  var157 = var2[2];
                  byte var224 = 7;
                  byte var159;
                  if (var157 == var224) {
                     var159 = 16;
                  } else {
                     var159 = 6;
                  }

                  if (var55 > var159) {
                     this.x(var1);
                  }
               }
            }
            break;
         case 6:
            int var131 = 13;
            var4 = var2[var131] + 1;
            var2[var131] = var4;
            var131 = (byte)5;
            if (var4 > var131) {
               Object var203 = null;
               var2[13] = 0;
               var4 = var2[0];
               int var219 = var2[1];
               var131 = (byte)5;
               int var238 = var2[var131];
               boolean var262 = false;
               boolean var274 = false;
               boolean var283 = true;
               this.a(var4, var219, var238, (byte)0, 0, var283);
               this.x(var1);
            } else {
               var4 = var2[0];
               int var220 = var2[1];
               var131 = (byte)5;
               int var239 = var2[var131];
               byte var263 = 4;
               boolean var275 = false;
               boolean var284 = true;
               this.a(var4, var220, var239, var263, 0, var284);
            }

            var131 = var2[2];
            var4 = var2[3];
            int var221 = var2[5];
            this.h(var1, var131, var4, var221);
            break;
         case 8:
         case 9:
            var6 = var2[10];
            switch (var6) {
               case 0:
                  int var120 = 13;
                  var4 = var2[var120] + 1;
                  var2[var120] = var4;
                  var120 = (byte)2;
                  if (var4 > var120) {
                     var3 = null;
                     var4 = var2[0];
                     int var217 = var2[1];
                     int var237 = var2[5];
                     var120 = var2[2];
                     byte var260 = 8;
                     if (var120 == var260) {
                        byte var123 = 3;
                        var260 = var123;
                     } else {
                        byte var124 = 2;
                        var260 = var124;
                     }

                     var120 = var2[2];
                     int var272 = var2[3];
                     byte var126 = this.m(var120, var272);
                     byte var273;
                     if (var126) {
                        var126 = (boolean)0;
                        var3 = null;
                        var273 = 0;
                     } else {
                        var126 = 2;
                        var273 = var126;
                     }

                     boolean var282 = false;
                     var5 = null;
                     this.a(var4, var217, var237, var260, var273, false);
                     var2[10] = 1;
                     var126 = 13;
                     boolean var41 = false;
                     Object var202 = null;
                     var2[var126] = 0;
                  }
                  break;
               case 1:
                  int var115 = 13;
                  var4 = var2[var115] + 1;
                  var2[var115] = var4;
                  var115 = var2[2];
                  int var216 = var2[3];
                  byte var117 = this.j(var115, var216);
                  if (var117) {
                     var117 = 20;
                  } else {
                     var117 = 10;
                  }

                  if (var4 > var117) {
                     var2[10] = 2;
                     var117 = 13;
                     boolean var38 = false;
                     Object var201 = null;
                     var2[var117] = 0;
                  }
                  break;
               case 2:
                  int var107 = 13;
                  var4 = var2[var107] + 1;
                  var2[var107] = var4;
                  var107 = (byte)1;
                  if (var4 > var107) {
                     Object var199 = null;
                     var2[13] = 0;
                     var3 = null;
                     var4 = var2[0];
                     int var215 = var2[1];
                     int var236 = var2[5];
                     byte var259 = 1;
                     var107 = var2[2];
                     int var270 = var2[3];
                     int var110 = this.m(var107, var270);
                     byte var271;
                     if (var110) {
                        var110 = (boolean)0;
                        var3 = null;
                        var271 = 0;
                     } else {
                        var110 = (byte)2;
                        var271 = var110;
                     }

                     boolean var281 = false;
                     var5 = null;
                     this.a(var4, var215, var236, var259, var271, false);
                     var110 = var2[16];
                     if (var110 != 0) {
                        byte var114 = 16;
                        boolean var36 = false;
                        var199 = null;
                        var2[var114] = 0;
                     }

                     this.x(var1);
                  }
            }

            var6 = var2[2];
            var4 = var2[3];
            int var218 = var2[5];
            this.h(var1, var6, var4, var218);
            break;
         case 10:
            var6 = var2[10];
            switch (var6) {
               case 1:
                  int var99 = 13;
                  var4 = var2[var99] + 1;
                  var2[var99] = var4;
                  var99 = (byte)4;
                  if (var4 > var99) {
                     var3 = null;
                     var4 = var2[0];
                     int var8 = var2[1];
                     int var9 = var2[5];
                     var99 = var2[2];
                     int var14 = var2[3];
                     int var102 = this.k(var99, var14);
                     if (var102) {
                        var102 = (byte)40;
                     } else {
                        var102 = (byte)10;
                     }

                     byte var258 = (byte)(var102 + 6);
                     boolean var15 = false;
                     boolean var16 = true;
                     this.a(var4, var8, var9, var258, 0, var16);
                     var102 = var2[2];
                     var4 = var2[3];
                     var8 = var2[5];
                     this.h(var1, var102, var4, var8);
                     Object var7 = null;
                     var2[13] = 0;
                     byte var105 = 10;
                     byte var33 = 2;
                     var2[var105] = var33;
                  }
                  break;
               case 2:
                  byte var97 = 13;
                  var4 = var2[var97] + 1;
                  var2[var97] = var4;
                  var97 = 9;
                  if (var4 > var97) {
                     this.x(var1);
                  }
            }
      }
   }

   private void B() {
      this.e(0);
      this.c();
      this.e(20);
      this.c(4);
      this.e(40);
      this.c(0);
      this.e(80);
      this.l = 1;
      this.bu = 0;
      this.r = 0;
      this.aO = 0;
      this.aw = 0;
      this.bF = 0;
      this.av = 0;
      this.au = 0;
      this.b();
      this.e(100);
      this.g(7, -1);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void B(int var1) {
      this.getClass();
      StringBuffer var2 = new StringBuffer();
      String var3 = "/mapdatalv";
      InputStream var26 = Display.getResourceAsStream(var2.append(var3).append(var1).toString());

      short var10000;
      try {
         var10000 = a(var26);
      } catch (Exception var25) {
         return;
      }

      int var4 = var10000;
      a var35 = this;

      try {
         var35.bG = var4;
      } catch (Exception var24) {
         return;
      }

      try {
         var10000 = a(var26);
      } catch (Exception var23) {
         return;
      }

      var4 = var10000;
      a var37 = this;

      try {
         var37.bH = var4;
      } catch (Exception var22) {
         return;
      }

      try {
         var10000 = this.bG;
      } catch (Exception var21) {
         return;
      }

      var4 = var10000;

      try {
         var10000 = this.bH;
      } catch (Exception var20) {
         return;
      }

      int var5 = var10000;
      var4 *= var5;

      try {
         var10000 = this.bG;
      } catch (Exception var19) {
         return;
      }

      var5 = var10000 << 4;
      a var41 = this;

      try {
         var41.bI = var5;
      } catch (Exception var18) {
         return;
      }

      try {
         var10000 = this.bH;
      } catch (Exception var17) {
         return;
      }

      var5 = var10000 << 4;
      a var43 = this;

      try {
         var43.bJ = var5;
      } catch (Exception var16) {
         return;
      }

      try {
         var44 = new byte[var4];
      } catch (Exception var15) {
         return;
      }

      byte[] var6 = var44;
      a var45 = this;

      try {
         var45.B1160 = var6;
      } catch (Exception var14) {
         return;
      }

      try {
         var46 = new byte[var4];
      } catch (Exception var13) {
         return;
      }

      var6 = var46;
      a var47 = this;

      try {
         var47.C1161 = var6;
      } catch (Exception var12) {
         return;
      }

      try {
         var48 = this.B1160;
      } catch (Exception var11) {
         return;
      }

      var6 = var48;
      InputStream var49 = var26;
      byte[] var10001 = var6;
      byte var10002 = 0;

      try {
         var49.read(var10001, var10002, var4);
      } catch (Exception var10) {
         return;
      }

      try {
         var50 = this.C1161;
      } catch (Exception var9) {
         return;
      }

      var6 = var50;
      InputStream var51 = var26;
      var10001 = var6;
      var10002 = 0;

      try {
         var51.read(var10001, var10002, var4);
      } catch (Exception var8) {
         return;
      }

      try {
         var26.close();
      } catch (Exception var7) {
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final void C() {
      byte var1 = 11;
      boolean var2 = true;
      String var3 = "sanGuoTd";
      boolean var4 = false;
      RecordStore var5 = null;
      String var10000 = var3;

      boolean var6;
      label768: {
         label774: {
            try {
               try {
                  var197 = RecordStore.openRecordStore(var10000, false);
                  break label774;
               } catch (RecordStoreNotFoundException var111) {
               }
            } catch (Exception var112) {
               var112.printStackTrace();
               return;
            }

            var3 = "sanGuoTd";
            var4 = true;
            var10000 = var3;

            try {
               var196 = RecordStore.openRecordStore(var10000, var4);
            } catch (Exception var110) {
               var110.printStackTrace();
               return;
            }

            RecordStore var114 = var196;
            var5 = var114;
            var6 = var2;
            break label768;
         }

         var5 = var197;
         var6 = 0;
         var3 = null;
      }

      try {
         var198 = new ByteArrayOutputStream;
      } catch (Exception var109) {
         var109.printStackTrace();
         return;
      }

      ByteArrayOutputStream var7 = var198;

      try {
         var7./* $VF: Unable to resugar constructor */<init>();
      } catch (Exception var108) {
         var108.printStackTrace();
         return;
      }

      try {
         var199 = new DataOutputStream;
      } catch (Exception var107) {
         var107.printStackTrace();
         return;
      }

      DataOutputStream var8 = var199;
      DataOutputStream var200 = var8;

      try {
         var200./* $VF: Unable to resugar constructor */<init>(var7);
      } catch (Exception var106) {
         var106.printStackTrace();
         return;
      }

      try {
         var201 = this.aP;
      } catch (Exception var105) {
         var105.printStackTrace();
         return;
      }

      int var9 = var201;
      DataOutputStream var202 = var8;

      try {
         var202.writeInt(var9);
      } catch (Exception var104) {
         var104.printStackTrace();
         return;
      }

      var9 = 0;
      Object var10 = null;

      while (true) {
         try {
            var203 = this.aP;
         } catch (Exception var103) {
            var103.printStackTrace();
            break;
         }

         int var11 = var203;
         if (var9 >= var11) {
            try {
               var210 = this.bt;
            } catch (Exception var98) {
               var98.printStackTrace();
               break;
            }

            var9 = var210;
            DataOutputStream var211 = var8;

            try {
               var211.writeInt(var9);
            } catch (Exception var97) {
               var97.printStackTrace();
               break;
            }

            var9 = 0;
            var10 = null;

            while (true) {
               try {
                  var212 = this.bt;
               } catch (Exception var96) {
                  var96.printStackTrace();
                  return;
               }

               var11 = var212;
               if (var9 >= var11) {
                  var9 = 0;
                  var10 = null;

                  while (true) {
                     int var166 = 5;
                     if (var9 >= var166) {
                        var9 = 0;
                        var10 = null;

                        while (true) {
                           var166 = (byte)10;
                           if (var9 >= var166) {
                              var9 = 0;
                              var10 = null;

                              while (var9 < var1) {
                                 try {
                                    var227 = this.e1105;
                                 } catch (Exception var85) {
                                    var85.printStackTrace();
                                    return;
                                 }

                                 boolean[] var183 = var227;
                                 boolean[] var228 = var183;

                                 try {
                                    var229 = var228[var9];
                                 } catch (Exception var84) {
                                    var84.printStackTrace();
                                    return;
                                 }

                                 boolean var172 = var229;
                                 if (!var172) {
                                    var172 = false;
                                    var183 = null;
                                 } else {
                                    var172 = var2;
                                 }

                                 DataOutputStream var230 = var8;

                                 try {
                                    var230.writeBoolean(var172);
                                 } catch (Exception var83) {
                                    var83.printStackTrace();
                                    return;
                                 }

                                 var9++;
                              }

                              var9 = 0;
                              var10 = null;

                              while (var9 < var1) {
                                 try {
                                    var231 = this.f1106;
                                 } catch (Exception var82) {
                                    var82.printStackTrace();
                                    return;
                                 }

                                 boolean[] var185 = var231;
                                 boolean[] var232 = var185;

                                 try {
                                    var233 = var232[var9];
                                 } catch (Exception var81) {
                                    var81.printStackTrace();
                                    return;
                                 }

                                 boolean var174 = var233;
                                 if (!var174) {
                                    var174 = false;
                                    var185 = null;
                                 } else {
                                    var174 = var2;
                                 }

                                 DataOutputStream var234 = var8;

                                 try {
                                    var234.writeBoolean(var174);
                                 } catch (Exception var80) {
                                    var80.printStackTrace();
                                    return;
                                 }

                                 var9++;
                              }

                              try {
                                 var235 = this.aq;
                              } catch (Exception var79) {
                                 var79.printStackTrace();
                                 return;
                              }

                              var9 = var235;
                              DataOutputStream var236 = var8;

                              try {
                                 var236.writeInt(var9);
                              } catch (Exception var78) {
                                 var78.printStackTrace();
                                 return;
                              }

                              try {
                                 var237 = this.bj;
                              } catch (Exception var77) {
                                 var77.printStackTrace();
                                 return;
                              }

                              var9 = var237;
                              DataOutputStream var238 = var8;

                              try {
                                 var238.writeInt(var9);
                              } catch (Exception var76) {
                                 var76.printStackTrace();
                                 return;
                              }

                              try {
                                 var239 = this.bN;
                              } catch (Exception var75) {
                                 var75.printStackTrace();
                                 return;
                              }

                              var9 = var239;
                              DataOutputStream var240 = var8;

                              try {
                                 var240.writeInt(var9);
                              } catch (Exception var74) {
                                 var74.printStackTrace();
                                 return;
                              }

                              try {
                                 var241 = this.bO;
                              } catch (Exception var73) {
                                 var73.printStackTrace();
                                 return;
                              }

                              var9 = var241;
                              DataOutputStream var242 = var8;

                              try {
                                 var242.writeInt(var9);
                              } catch (Exception var72) {
                                 var72.printStackTrace();
                                 return;
                              }

                              try {
                                 var243 = this.bP;
                              } catch (Exception var71) {
                                 var71.printStackTrace();
                                 return;
                              }

                              var9 = var243;
                              DataOutputStream var244 = var8;

                              try {
                                 var244.writeInt(var9);
                              } catch (Exception var70) {
                                 var70.printStackTrace();
                                 return;
                              }

                              try {
                                 var245 = this.bQ;
                              } catch (Exception var69) {
                                 var69.printStackTrace();
                                 return;
                              }

                              var9 = var245;
                              DataOutputStream var246 = var8;

                              try {
                                 var246.writeInt(var9);
                              } catch (Exception var68) {
                                 var68.printStackTrace();
                                 return;
                              }

                              try {
                                 var247 = this.T;
                              } catch (Exception var67) {
                                 var67.printStackTrace();
                                 return;
                              }

                              var9 = var247;
                              DataOutputStream var248 = var8;

                              try {
                                 var248.writeInt(var9);
                              } catch (Exception var66) {
                                 var66.printStackTrace();
                                 return;
                              }

                              try {
                                 var249 = this.aO;
                              } catch (Exception var65) {
                                 var65.printStackTrace();
                                 return;
                              }

                              var9 = var249;
                              DataOutputStream var250 = var8;

                              try {
                                 var250.writeInt(var9);
                              } catch (Exception var64) {
                                 var64.printStackTrace();
                                 return;
                              }

                              try {
                                 var251 = this.aS;
                              } catch (Exception var63) {
                                 var63.printStackTrace();
                                 return;
                              }

                              var9 = var251;
                              DataOutputStream var252 = var8;

                              try {
                                 var252.writeInt(var9);
                              } catch (Exception var62) {
                                 var62.printStackTrace();
                                 return;
                              }

                              try {
                                 var253 = this.X;
                              } catch (Exception var61) {
                                 var61.printStackTrace();
                                 return;
                              }

                              var9 = var253;
                              DataOutputStream var254 = var8;

                              try {
                                 var254.writeInt(var9);
                              } catch (Exception var60) {
                                 var60.printStackTrace();
                                 return;
                              }

                              try {
                                 var255 = this.bz;
                              } catch (Exception var59) {
                                 var59.printStackTrace();
                                 return;
                              }

                              var9 = var255;
                              DataOutputStream var256 = var8;

                              try {
                                 var256.writeInt(var9);
                              } catch (Exception var58) {
                                 var58.printStackTrace();
                                 return;
                              }

                              try {
                                 var257 = this.by;
                              } catch (Exception var57) {
                                 var57.printStackTrace();
                                 return;
                              }

                              var9 = var257;
                              DataOutputStream var258 = var8;

                              try {
                                 var258.writeInt(var9);
                              } catch (Exception var56) {
                                 var56.printStackTrace();
                                 return;
                              }

                              try {
                                 var259 = this.aT;
                              } catch (Exception var55) {
                                 var55.printStackTrace();
                                 return;
                              }

                              var9 = var259;
                              DataOutputStream var260 = var8;

                              try {
                                 var260.writeInt(var9);
                              } catch (Exception var54) {
                                 var54.printStackTrace();
                                 return;
                              }

                              try {
                                 var261 = this.aQ;
                              } catch (Exception var53) {
                                 var53.printStackTrace();
                                 return;
                              }

                              var9 = var261;
                              DataOutputStream var262 = var8;

                              try {
                                 var262.writeInt(var9);
                              } catch (Exception var52) {
                                 var52.printStackTrace();
                                 return;
                              }

                              try {
                                 var263 = this.ay;
                              } catch (Exception var51) {
                                 var51.printStackTrace();
                                 return;
                              }

                              var9 = var263;
                              DataOutputStream var264 = var8;

                              try {
                                 var264.writeInt(var9);
                              } catch (Exception var50) {
                                 var50.printStackTrace();
                                 return;
                              }

                              try {
                                 var265 = this.az;
                              } catch (Exception var49) {
                                 var49.printStackTrace();
                                 return;
                              }

                              var9 = var265;
                              DataOutputStream var266 = var8;

                              try {
                                 var266.writeInt(var9);
                              } catch (Exception var48) {
                                 var48.printStackTrace();
                                 return;
                              }

                              try {
                                 var267 = this.p1078;
                              } catch (Exception var47) {
                                 var47.printStackTrace();
                                 return;
                              }

                              int var143 = var267;
                              DataOutputStream var268 = var8;

                              try {
                                 var268.writeBoolean((boolean)var143);
                              } catch (Exception var46) {
                                 var46.printStackTrace();
                                 return;
                              }

                              try {
                                 var269 = this.bL;
                              } catch (Exception var45) {
                                 var45.printStackTrace();
                                 return;
                              }

                              var143 = var269;
                              DataOutputStream var270 = var8;

                              try {
                                 var270.writeInt(var143);
                              } catch (Exception var44) {
                                 var44.printStackTrace();
                                 return;
                              }

                              try {
                                 var271 = this.bM;
                              } catch (Exception var43) {
                                 var43.printStackTrace();
                                 return;
                              }

                              var143 = var271;
                              DataOutputStream var272 = var8;

                              try {
                                 var272.writeInt(var143);
                              } catch (Exception var42) {
                                 var42.printStackTrace();
                                 return;
                              }

                              try {
                                 var273 = this.ac;
                              } catch (Exception var41) {
                                 var41.printStackTrace();
                                 return;
                              }

                              var143 = var273;
                              DataOutputStream var274 = var8;

                              try {
                                 var274.writeInt(var143);
                              } catch (Exception var40) {
                                 var40.printStackTrace();
                                 return;
                              }

                              try {
                                 var275 = this.aV;
                              } catch (Exception var39) {
                                 var39.printStackTrace();
                                 return;
                              }

                              var143 = var275;
                              DataOutputStream var276 = var8;

                              try {
                                 var276.writeInt(var143);
                              } catch (Exception var38) {
                                 var38.printStackTrace();
                                 return;
                              }

                              try {
                                 var277 = this.aW;
                              } catch (Exception var37) {
                                 var37.printStackTrace();
                                 return;
                              }

                              var143 = var277;
                              DataOutputStream var278 = var8;

                              try {
                                 var278.writeInt(var143);
                              } catch (Exception var36) {
                                 var36.printStackTrace();
                                 return;
                              }

                              try {
                                 var279 = this.aX;
                              } catch (Exception var35) {
                                 var35.printStackTrace();
                                 return;
                              }

                              var143 = var279;
                              DataOutputStream var280 = var8;

                              try {
                                 var280.writeInt(var143);
                              } catch (Exception var34) {
                                 var34.printStackTrace();
                                 return;
                              }

                              try {
                                 var281 = this.aY;
                              } catch (Exception var33) {
                                 var33.printStackTrace();
                                 return;
                              }

                              var143 = var281;
                              DataOutputStream var282 = var8;

                              try {
                                 var282.writeInt(var143);
                              } catch (Exception var32) {
                                 var32.printStackTrace();
                                 return;
                              }

                              try {
                                 var283 = this.aZ;
                              } catch (Exception var31) {
                                 var31.printStackTrace();
                                 return;
                              }

                              var143 = var283;
                              DataOutputStream var284 = var8;

                              try {
                                 var284.writeInt(var143);
                              } catch (Exception var30) {
                                 var30.printStackTrace();
                                 return;
                              }

                              try {
                                 var285 = this.ba;
                              } catch (Exception var29) {
                                 var29.printStackTrace();
                                 return;
                              }

                              var143 = var285;
                              DataOutputStream var286 = var8;

                              try {
                                 var286.writeInt(var143);
                              } catch (Exception var28) {
                                 var28.printStackTrace();
                                 return;
                              }

                              try {
                                 var287 = this.bb;
                              } catch (Exception var27) {
                                 var27.printStackTrace();
                                 return;
                              }

                              var143 = var287;
                              DataOutputStream var288 = var8;

                              try {
                                 var288.writeInt(var143);
                              } catch (Exception var26) {
                                 var26.printStackTrace();
                                 return;
                              }

                              try {
                                 var289 = this.z1169;
                              } catch (Exception var25) {
                                 var25.printStackTrace();
                                 return;
                              }

                              boolean var154 = var289;
                              DataOutputStream var290 = var8;

                              try {
                                 var290.writeBoolean(var154);
                              } catch (Exception var24) {
                                 var24.printStackTrace();
                                 return;
                              }

                              if (var6) {
                                 try {
                                    var291 = var7.toByteArray();
                                 } catch (Exception var23) {
                                    var23.printStackTrace();
                                    return;
                                 }

                                 byte[] var116 = var291;
                                 var154 = false;
                                 var10 = null;

                                 try {
                                    var292 = var7.size();
                                 } catch (Exception var22) {
                                    var22.printStackTrace();
                                    return;
                                 }

                                 var166 = var292;
                                 RecordStore var293 = var5;
                                 byte[] var10001 = var116;
                                 byte var10002 = 0;

                                 try {
                                    var293.addRecord(var10001, var10002, var166);
                                 } catch (Exception var21) {
                                    var21.printStackTrace();
                                    return;
                                 }
                              } else {
                                 var6 = 1;

                                 try {
                                    var294 = var7.toByteArray();
                                 } catch (Exception var20) {
                                    var20.printStackTrace();
                                    return;
                                 }

                                 var10 = var294;
                                 boolean var177 = false;
                                 Object var187 = null;

                                 try {
                                    var295 = var7.size();
                                 } catch (Exception var19) {
                                    var19.printStackTrace();
                                    return;
                                 }

                                 int var191 = var295;
                                 RecordStore var296 = var5;
                                 byte var297 = var6;
                                 byte[] var298 = (byte[])var10;
                                 byte var10003 = 0;

                                 try {
                                    var296.setRecord(var297, var298, var10003, var191);
                                 } catch (Exception var18) {
                                    var18.printStackTrace();
                                    return;
                                 }
                              }

                              try {
                                 var8.close();
                              } catch (Exception var17) {
                                 var17.printStackTrace();
                                 return;
                              }

                              try {
                                 var7.close();
                              } catch (Exception var16) {
                                 var16.printStackTrace();
                                 return;
                              }

                              try {
                                 var5.closeRecordStore();
                              } catch (Exception var15) {
                                 var15.printStackTrace();
                              }

                              return;
                           }

                           try {
                              var223 = this.b1059;
                           } catch (Exception var88) {
                              var88.printStackTrace();
                              return;
                           }

                           boolean[] var181 = var223;
                           boolean[] var224 = var181;

                           try {
                              var225 = var224[var9];
                           } catch (Exception var87) {
                              var87.printStackTrace();
                              return;
                           }

                           boolean var170 = var225;
                           if (!var170) {
                              var170 = false;
                              var181 = null;
                           } else {
                              var170 = var2;
                           }

                           DataOutputStream var226 = var8;

                           try {
                              var226.writeBoolean(var170);
                           } catch (Exception var86) {
                              var86.printStackTrace();
                              return;
                           }

                           var9++;
                        }
                     }

                     try {
                        var219 = this.a1056;
                     } catch (Exception var91) {
                        var91.printStackTrace();
                        return;
                     }

                     boolean[] var179 = var219;
                     boolean[] var220 = var179;

                     try {
                        var221 = var220[var9];
                     } catch (Exception var90) {
                        var90.printStackTrace();
                        return;
                     }

                     boolean var167 = var221;
                     if (!var167) {
                        var167 = false;
                        var179 = null;
                     } else {
                        var167 = var2;
                     }

                     DataOutputStream var222 = var8;

                     try {
                        var222.writeBoolean(var167);
                     } catch (Exception var89) {
                        var89.printStackTrace();
                        return;
                     }

                     var9++;
                  }
               }

               var11 = 0;
               Object var178 = null;

               while (true) {
                  int var189 = 18;
                  if (var11 >= var189) {
                     var9++;
                     break;
                  }

                  try {
                     var213 = this.c1107;
                  } catch (Exception var95) {
                     var95.printStackTrace();
                     return;
                  }

                  int[][] var193 = var213;
                  int[][] var214 = var193;

                  try {
                     var215 = var214[var9];
                  } catch (Exception var94) {
                     var94.printStackTrace();
                     return;
                  }

                  int[] var194 = var215;
                  int[] var216 = var194;

                  try {
                     var217 = var216[var11];
                  } catch (Exception var93) {
                     var93.printStackTrace();
                     return;
                  }

                  var189 = var217;
                  DataOutputStream var218 = var8;

                  try {
                     var218.writeInt(var189);
                  } catch (Exception var92) {
                     var92.printStackTrace();
                     return;
                  }

                  var11++;
               }
            }
         }

         var11 = 0;
         Object var12 = null;

         while (true) {
            int var13 = 28;
            if (var11 >= var13) {
               var9++;
               break;
            }

            try {
               var204 = this.b1066;
            } catch (Exception var102) {
               var102.printStackTrace();
               return;
            }

            int[][] var14 = var204;
            int[][] var205 = var14;

            try {
               var206 = var205[var9];
            } catch (Exception var101) {
               var101.printStackTrace();
               return;
            }

            int[] var192 = var206;
            int[] var207 = var192;

            try {
               var208 = var207[var11];
            } catch (Exception var100) {
               var100.printStackTrace();
               return;
            }

            var13 = var208;
            DataOutputStream var209 = var8;

            try {
               var209.writeInt(var13);
            } catch (Exception var99) {
               var99.printStackTrace();
               return;
            }

            var11++;
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void C(int var1) {
      this.getClass();
      StringBuffer var2 = new StringBuffer();
      String var3 = "/mapdata";
      InputStream var15 = Display.getResourceAsStream(var2.append(var3).append(var1).toString());

      int var10000;
      try {
         var10000 = var15.read();
      } catch (Exception var14) {
         return;
      }

      int var4 = var10000;

      try {
         var10000 = var15.read();
      } catch (Exception var13) {
         return;
      }

      int var5 = var10000;
      var4 *= var5;

      try {
         var20 = new byte[var4];
      } catch (Exception var12) {
         return;
      }

      byte[] var6 = var20;
      a var21 = this;

      try {
         var21.E1163 = var6;
      } catch (Exception var11) {
         return;
      }

      try {
         var22 = new byte[var4];
      } catch (Exception var10) {
         return;
      }

      var6 = var22;
      a var23 = this;

      try {
         var23.D1162 = var6;
      } catch (Exception var9) {
         return;
      }

      try {
         var24 = this.E1163;
      } catch (Exception var8) {
         return;
      }

      var6 = var24;
      InputStream var25 = var15;
      byte[] var10001 = var6;
      byte var10002 = 0;

      try {
         var25.read(var10001, var10002, var4);
      } catch (Exception var7) {
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final void D() {
      boolean var1 = true;
      int var2 = 0;
      String var3 = "sanGuoTdData";
      boolean var4 = false;
      RecordStore var5 = null;
      String var10000 = var3;

      boolean var6;
      label194: {
         label200: {
            try {
               try {
                  var63 = RecordStore.openRecordStore(var10000, false);
                  break label200;
               } catch (RecordStoreNotFoundException var37) {
               }
            } catch (Exception var38) {
               var38.printStackTrace();
               return;
            }

            var3 = "sanGuoTdData";
            var4 = true;
            var10000 = var3;

            try {
               var62 = RecordStore.openRecordStore(var10000, var4);
            } catch (Exception var36) {
               var36.printStackTrace();
               return;
            }

            RecordStore var41 = var62;
            var5 = var41;
            var6 = var1;
            break label194;
         }

         var5 = var63;
         var6 = 0;
         var3 = null;
      }

      try {
         var64 = new ByteArrayOutputStream;
      } catch (Exception var35) {
         var35.printStackTrace();
         return;
      }

      ByteArrayOutputStream var7 = var64;

      try {
         var7./* $VF: Unable to resugar constructor */<init>();
      } catch (Exception var34) {
         var34.printStackTrace();
         return;
      }

      try {
         var65 = new DataOutputStream;
      } catch (Exception var33) {
         var33.printStackTrace();
         return;
      }

      DataOutputStream var8 = var65;
      DataOutputStream var66 = var8;

      try {
         var66./* $VF: Unable to resugar constructor */<init>(var7);
      } catch (Exception var32) {
         var32.printStackTrace();
         return;
      }

      int var9 = 0;
      Object var10 = null;

      while (true) {
         try {
            var67 = this.E1163;
         } catch (Exception var28) {
            var28.printStackTrace();
            break;
         }

         byte[] var11 = var67;

         try {
            var68 = var11.length;
         } catch (Exception var27) {
            var27.printStackTrace();
            break;
         }

         int var12 = var68;
         if (var9 >= var12) {
            var9 = 0;
            var10 = null;

            while (true) {
               try {
                  var73 = this.D1162;
               } catch (Exception var23) {
                  var23.printStackTrace();
                  return;
               }

               var11 = var73;

               try {
                  var74 = var11.length;
               } catch (Exception var22) {
                  var22.printStackTrace();
                  return;
               }

               var12 = var74;
               if (var9 >= var12) {
                  if (var6) {
                     try {
                        var79 = var7.toByteArray();
                     } catch (Exception var21) {
                        var21.printStackTrace();
                        return;
                     }

                     byte[] var43 = var79;
                     boolean var48 = false;
                     var10 = null;

                     try {
                        var80 = var7.size();
                     } catch (Exception var20) {
                        var20.printStackTrace();
                        return;
                     }

                     var12 = var80;
                     RecordStore var81 = var5;
                     byte[] var10001 = var43;
                     byte var10002 = 0;

                     try {
                        var81.addRecord(var10001, var10002, var12);
                     } catch (Exception var19) {
                        var19.printStackTrace();
                        return;
                     }
                  } else {
                     var6 = 1;

                     try {
                        var82 = var7.toByteArray();
                     } catch (Exception var18) {
                        var18.printStackTrace();
                        return;
                     }

                     var10 = var82;
                     boolean var60 = false;
                     var11 = null;

                     try {
                        var83 = var7.size();
                     } catch (Exception var17) {
                        var17.printStackTrace();
                        return;
                     }

                     var2 = var83;
                     RecordStore var84 = var5;
                     byte var85 = var6;
                     byte[] var86 = (byte[])var10;
                     byte var10003 = 0;

                     try {
                        var84.setRecord(var85, var86, var10003, var2);
                     } catch (Exception var16) {
                        var16.printStackTrace();
                        return;
                     }
                  }

                  try {
                     var8.close();
                  } catch (Exception var15) {
                     var15.printStackTrace();
                     return;
                  }

                  try {
                     var7.close();
                  } catch (Exception var14) {
                     var14.printStackTrace();
                     return;
                  }

                  try {
                     var5.closeRecordStore();
                  } catch (Exception var13) {
                     var13.printStackTrace();
                  }

                  return;
               }

               try {
                  var75 = this.D1162;
               } catch (Exception var26) {
                  var26.printStackTrace();
                  return;
               }

               var11 = var75;
               byte[] var76 = var11;

               try {
                  var77 = var76[var9];
               } catch (Exception var25) {
                  var25.printStackTrace();
                  return;
               }

               byte var58 = var77;
               DataOutputStream var78 = var8;

               try {
                  var78.writeByte(var58);
               } catch (Exception var24) {
                  var24.printStackTrace();
                  return;
               }

               var9++;
            }
         }

         try {
            var69 = this.E1163;
         } catch (Exception var31) {
            var31.printStackTrace();
            break;
         }

         var11 = var69;
         byte[] var70 = var11;

         try {
            var71 = var70[var9];
         } catch (Exception var30) {
            var30.printStackTrace();
            break;
         }

         byte var56 = var71;
         DataOutputStream var72 = var8;

         try {
            var72.writeByte(var56);
         } catch (Exception var29) {
            var29.printStackTrace();
            break;
         }

         var9++;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void D(int var1) {
      this.getClass();
      StringBuffer var2 = new StringBuffer();
      String var3 = "/mapsp";
      InputStream var18 = Display.getResourceAsStream(var2.append(var3).append(var1).toString());

      short var10000;
      try {
         var10000 = a(var18);
      } catch (Exception var17) {
         return;
      }

      int var4 = var10000;

      try {
         var10000 = a(var18);
      } catch (Exception var16) {
         return;
      }

      short var5 = var10000;
      var4 *= var5;

      try {
         var24 = new byte[var4];
      } catch (Exception var15) {
         return;
      }

      byte[] var6 = var24;
      a var25 = this;

      try {
         var25.F1164 = var6;
      } catch (Exception var14) {
         return;
      }

      try {
         var26 = new byte[var4];
      } catch (Exception var13) {
         return;
      }

      var6 = var26;
      a var27 = this;

      try {
         var27.G1165 = var6;
      } catch (Exception var12) {
         return;
      }

      try {
         var28 = this.F1164;
      } catch (Exception var11) {
         return;
      }

      var6 = var28;
      InputStream var29 = var18;
      byte[] var10001 = var6;
      byte var10002 = 0;

      try {
         var29.read(var10001, var10002, var4);
      } catch (Exception var10) {
         return;
      }

      try {
         var30 = this.G1165;
      } catch (Exception var9) {
         return;
      }

      var6 = var30;
      InputStream var31 = var18;
      var10001 = var6;
      var10002 = 0;

      try {
         var31.read(var10001, var10002, var4);
      } catch (Exception var8) {
         return;
      }

      try {
         var18.close();
      } catch (Exception var7) {
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void E() {
      boolean var1 = true;
      int var2 = 0;
      String var3 = "freeGame";
      boolean var4 = false;
      RecordStore var5 = null;
      String var10000 = var3;

      boolean var6;
      label150: {
         label156: {
            try {
               try {
                  var51 = RecordStore.openRecordStore(var10000, false);
                  break label156;
               } catch (RecordStoreNotFoundException var30) {
               }
            } catch (Exception var31) {
               var31.printStackTrace();
               return;
            }

            var3 = "freeGame";
            var4 = true;
            var10000 = var3;

            try {
               var50 = RecordStore.openRecordStore(var10000, var4);
            } catch (Exception var29) {
               var29.printStackTrace();
               return;
            }

            RecordStore var34 = var50;
            var5 = var34;
            var6 = var1;
            break label150;
         }

         var5 = var51;
         var6 = 0;
         var3 = null;
      }

      try {
         var52 = new ByteArrayOutputStream;
      } catch (Exception var28) {
         var28.printStackTrace();
         return;
      }

      ByteArrayOutputStream var7 = var52;

      try {
         var7./* $VF: Unable to resugar constructor */<init>();
      } catch (Exception var27) {
         var27.printStackTrace();
         return;
      }

      try {
         var53 = new DataOutputStream;
      } catch (Exception var26) {
         var26.printStackTrace();
         return;
      }

      DataOutputStream var8 = var53;
      DataOutputStream var54 = var8;

      try {
         var54./* $VF: Unable to resugar constructor */<init>(var7);
      } catch (Exception var25) {
         var25.printStackTrace();
         return;
      }

      int var9 = 0;
      Object var10 = null;

      while (true) {
         int var11 = 9;
         if (var9 >= var11) {
            if (var6) {
               try {
                  var59 = var7.toByteArray();
               } catch (Exception var21) {
                  var21.printStackTrace();
                  break;
               }

               byte[] var36 = var59;
               boolean var40 = false;
               var10 = null;

               try {
                  var60 = var7.size();
               } catch (Exception var20) {
                  var20.printStackTrace();
                  break;
               }

               var11 = var60;
               RecordStore var61 = var5;
               byte[] var10001 = var36;
               byte var10002 = 0;

               try {
                  var61.addRecord(var10001, var10002, var11);
               } catch (Exception var19) {
                  var19.printStackTrace();
                  break;
               }
            } else {
               var6 = 1;

               try {
                  var62 = var7.toByteArray();
               } catch (Exception var18) {
                  var18.printStackTrace();
                  break;
               }

               var10 = var62;
               boolean var46 = false;
               Object var48 = null;

               try {
                  var63 = var7.size();
               } catch (Exception var17) {
                  var17.printStackTrace();
                  break;
               }

               var2 = var63;
               RecordStore var64 = var5;
               byte var65 = var6;
               byte[] var66 = (byte[])var10;
               byte var10003 = 0;

               try {
                  var64.setRecord(var65, var66, var10003, var2);
               } catch (Exception var16) {
                  var16.printStackTrace();
                  break;
               }
            }

            try {
               var8.close();
            } catch (Exception var15) {
               var15.printStackTrace();
               break;
            }

            try {
               var7.close();
            } catch (Exception var14) {
               var14.printStackTrace();
               break;
            }

            try {
               var5.closeRecordStore();
            } catch (Exception var13) {
               var13.printStackTrace();
            }
            break;
         }

         try {
            var55 = this.d1073;
         } catch (Exception var24) {
            var24.printStackTrace();
            break;
         }

         boolean[] var12 = var55;
         boolean[] var56 = var12;

         try {
            var57 = var56[var9];
         } catch (Exception var23) {
            var23.printStackTrace();
            break;
         }

         boolean var43 = var57;
         if (!var43) {
            var43 = false;
            var12 = null;
         } else {
            var43 = var1;
         }

         DataOutputStream var58 = var8;

         try {
            var58.writeBoolean(var43);
         } catch (Exception var22) {
            var22.printStackTrace();
            break;
         }

         var9++;
      }
   }

   private void E(int var1) {
      byte var2 = 1;
      short var3 = 304;
      Image var4 = Image.createImage(256, var3);
      this.a1004 = var4;
      Graphics var6 = this.a1004.getGraphics();
      this.b1003 = var6;
      this.y1155 = (boolean)var2;
      int var5 = this.m1075[var1] + 5;
      this.bL = var5;
      byte[] var7 = this.n1076;
      var5 = var7[var1] + 34 - var2;
      this.bM = var5;
      var5 = this.bL;
      this.c(var5);
      var5 = this.bL;
      this.bK = var5;
      if (var1 != 0) {
         var5 = this.bM;
         this.c(var5);
         this.D(var1);
      }

      this.B(var1);
      this.C(var1);
   }

   private void F() {
      byte var1 = -1;
      int var2 = 0;

      while (true) {
         byte var3 = 15;
         if (var2 >= var3) {
            return;
         }

         int[] var4 = this.h1041;
         var4[var2] = var1;
         var3 = 1;
         if (var2 < var3) {
            var4 = this.i1044;
            var4[var2] = var1;
         }

         var2++;
      }
   }

   private void F(int var1) {
      byte var2 = (byte)var1;
      this.bW = var2;
      byte var3 = this.E1179;
      if (var3) {
         this.b1174 = 0;
         var3 = 46;
         this.a((int)var3);
      } else {
         boolean var5 = this.f();
         if (var5) {
            this.F(var1);
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void G() {
      byte var1 = -1;
      byte var2 = 5;
      byte var3 = 10;
      byte var4 = 1;
      int var5 = 0;
      this.c1020 = false;
      int var6 = this.i1048;
      if (var6 >= 0) {
         var6 = this.i1048 + 1;
         this.i1048 = var6;
      }

      var6 = this.l;
      switch (var6) {
         case 0:
            var6 = this.al;
            int var93 = 2;
            if (var6 == var93) {
               var6 = this.ak;
               if (var6 == 0) {
                  this.l1031 = (boolean)var4;
                  this.F();
               }

               var6 = this.ak + 1;
               this.ak = var6;
               var93 = (byte)35;
               if (var6 <= var93) {
                  var6 = this.ak;
                  this.f(0, var6);
               } else {
                  this.f(var1);
                  this.n1036 = false;
                  this.am = 0;
                  this.ak = 0;
                  byte var72 = 2;
                  this.c(var72);
                  this.k();
               }
            } else {
               Image var102 = this.b1032;
               label179:
               if (var102 == null) {
                  StringBuffer var10000;
                  try {
                     var10000 = new StringBuffer;
                  } catch (Exception var18) {
                     break label179;
                  }

                  StringBuffer var103 = var10000;

                  try {
                     var103./* $VF: Unable to resugar constructor */<init>();
                  } catch (Exception var17) {
                     break label179;
                  }

                  String var110 = "/l";
                  var10000 = var103;

                  try {
                     var10000 = var10000.append(var110);
                  } catch (Exception var16) {
                     break label179;
                  }

                  StringBuffer var104 = var10000;

                  try {
                     var114 = this.al;
                  } catch (Exception var15) {
                     break label179;
                  }

                  var93 = var114;
                  var10000 = var104;

                  try {
                     var10000 = var10000.append(var93);
                  } catch (Exception var14) {
                     break label179;
                  }

                  StringBuffer var105 = var10000;
                  var110 = ".png";
                  var10000 = var105;

                  try {
                     var10000 = var10000.append(var110);
                  } catch (Exception var13) {
                     break label179;
                  }

                  StringBuffer var106 = var10000;

                  try {
                     var119 = var106.toString();
                  } catch (Exception var12) {
                     break label179;
                  }

                  String var107 = var119;

                  try {
                     var120 = Image.createImage(var107);
                  } catch (Exception var11) {
                     break label179;
                  }

                  var102 = var120;
                  a var121 = this;

                  try {
                     var121.b1032 = var102;
                  } catch (Exception var10) {
                  }
               }

               var6 = this.ak + 1;
               this.ak = var6;
               if (var6 > var3) {
                  var6 = this.al;
                  byte var96 = 2;
                  if (var6 < var96) {
                     var102 = null;
                     this.b1032 = null;
                     var6 = this.al + 1;
                     this.al = var6;
                     this.ak = 0;
                  }
               }
            }
            break;
         case 1:
            this.m();
            break;
         case 2:
            int var49 = this.d();
            if (var49) {
               this.U();
               this.a((int)var3);
               break;
            } else {
               var49 = this.v1097;
               if (var49) {
                  this.ae();
                  break;
               } else {
                  var49 = this.h1047;
                  int var82 = -7;
                  if (var49 == var82) {
                     this.r = 0;
                     var49 = this.aq;
                     this.h(var49);
                     byte var53 = 3;
                     this.a((int)var53);
                  }

                  var49 = this.h1047;
                  var82 = (byte)48;
                  if (var49 == var82) {
                     this.r = 0;
                     byte var55 = 24;
                     this.a((int)var55);
                  }

                  var49 = this.h1047;
                  var82 = (byte)42;
                  if (var49 == var82) {
                     this.y1155 = (boolean)var4;
                     short[][] var8 = this.c1070;
                     var82 = this.aN;
                     short var57 = var8[var82][0];
                     this.bN = var57;
                     var8 = this.c1070;
                     var82 = this.aN;
                     short[] var98 = var8[var82];
                     var57 = var98[var4];
                     this.bO = var57;
                  }

                  var49 = this.aS;
                  byte[] var9 = this.l1072;
                  var5 = this.aN;
                  int var87 = var9[var5];
                  if (var49 == var87) {
                     var49 = this.aP;
                     if (var49 <= 0) {
                        var49 = this.aT;
                        var87 = this.aX;
                        if (var49 == var87) {
                           var49 = this.by;
                           if (var49 > 0) {
                              var49 = this.T;
                              if (var49 == 0) {
                                 var49 = this.aO + 1;
                                 this.aO = var49;
                                 byte[] var99 = this.d1073;
                                 var87 = this.aN;
                                 var99[var87] = var4;
                                 this.E();
                                 var49 = this.aO;
                                 int var90 = 7;
                                 if (var49 < var90) {
                                    byte[][] var100 = this.h1074;
                                    var90 = this.X;
                                    var99 = var100[var90];
                                    var90 = this.aO;
                                    byte var67 = var99[var90];
                                    this.aN = var67;
                                 }
                              }

                              this.s1088 = (boolean)var4;
                              this.U();
                              this.a((int)var3);
                              break;
                           }
                        }
                     }
                  }

                  this.T();
               }
            }
         case 13:
            boolean var63 = this.d();
            if (var63) {
               this.U();
               this.a((int)var3);
            } else {
               this.an();
               this.X();
               this.ah();
               this.K();
               this.al();
            }
            break;
         case 3:
            var6 = this.h1047;
            switch (var6) {
               case -6:
               case -5:
               case 53:
                  var6 = this.r;
                  switch (var6) {
                     case 0:
                        this.a();
                        var6 = this.ar;
                        byte var81 = 8;
                        if (var6 >= var81) {
                           var6 = this.aP;
                           if (var6 > 0) {
                              var6 = this.ar;
                              this.g(var6, var1);
                              return;
                           }
                        }

                        return;
                     case 1:
                        this.r = 0;
                        byte var45 = 24;
                        this.a((int)var45);
                        return;
                     case 2:
                        byte var44 = 9;
                        this.a((int)var44);
                        this.r = 0;
                        return;
                     case 3:
                        this.a((int)var2);
                        this.c = 0;
                        return;
                     case 4:
                        byte var43 = 4;
                        this.a((int)var43);
                        this.c = 0;
                        return;
                     case 5:
                        this.C();
                        this.D();
                        this.B();
                        return;
                     default:
                        return;
                  }
               case -2:
               case 56:
                  var6 = this.r + 1;
                  this.r = var6;
                  if (var6 > var2) {
                     this.r = 0;
                  }

                  return;
               case -1:
               case 50:
                  var6 = this.r - var4;
                  this.r = var6;
                  if (var6 < 0) {
                     this.r = var2;
                  }

                  return;
               default:
                  return;
            }
         case 4:
         case 5:
         case 20:
         case 21:
            var6 = this.g1046;
            switch (var6) {
               case -7:
                  this.c = 0;
                  this.a();
                  var6 = this.l;
                  byte var80 = 4;
                  if (var6 != var80) {
                     var6 = this.l;
                     if (var6 != var2) {
                        byte var38 = 7;
                        this.g(var38, var1);
                        return;
                     }
                  }

                  return;
               case -2:
               case 56:
                  var6 = this.c;
                  int var77 = this.a1007;
                  var5 = this.b1008;
                  var77 -= var5;
                  if (var6 < var77) {
                     var6 = this.c;
                     var77 = this.b1008;
                     var6 += var77;
                     this.c = var6;
                  }

                  return;
               case -1:
               case 50:
                  var6 = this.c;
                  if (var6 > 0) {
                     var6 = this.c;
                     int var76 = this.b1008;
                     var6 -= var76;
                     this.c = var6;
                  }

                  return;
               default:
                  return;
            }
         case 8:
         case 9:
            this.g();
            break;
         case 10:
            this.V();
            break;
         case 12:
            boolean var28 = this.d();
            if (var28) {
               this.U();
               this.a((int)var3);
            } else {
               this.an();
               this.X();
               this.ah();
               this.K();
            }
            break;
         case 14:
            boolean var27 = this.d();
            if (var27) {
               this.U();
               this.a((int)var3);
            } else {
               this.an();
               this.X();
               this.ah();
               this.L();
            }
            break;
         case 15:
            this.r();
            break;
         case 16:
            this.u();
            break;
         case 17:
            this.t();
            break;
         case 18:
            this.i();
            break;
         case 19:
            var6 = this.ak + 1;
            this.ak = var6;
            byte var7 = 70;
            if (var6 <= var7) {
               var6 = this.ak;
               this.f(var4, var6);
            } else {
               this.b1018 = false;
            }
            break;
         case 22:
            this.aa();
            this.an();
            break;
         case 23:
            this.ad();
            this.an();
            this.al();
            break;
         case 24:
            this.aq();
            break;
         case 46:
            this.as();
            break;
         case 48:
            int var23 = this.g();
            if (var23) {
               this.E1179 = (boolean)var4;
               this.a();
               var23 = this.bW;
               this.F(var23);
            }
      }
   }

   private void G(int var1) {
      byte var2 = 2;
      this.c1190 = var2;
      StringBuffer var3 = new StringBuffer();
      var3 = var3.append("http://service.snowfish.cn/game/sms/server.php");
      String var4 = this.h1192;
      if (var4 == null) {
         var4 = "";
      } else {
         StringBuffer var10 = new StringBuffer();
         StringBuffer var11 = var10.append("?");
         String var5 = this.h1192;
         var4 = var11.append(var5).toString();
      }

      String var7 = var3.append(var4).toString();
      this.f1186 = var7;
      this.a1191 = null;
      ByteArrayOutputStream var8 = new ByteArrayOutputStream(2048);
      this.a1191 = var8;
      this.a1191.write(var1);
   }

   private void H() {
      this.J();
      this.I();
   }

   private void H(int var1) {
      char var2 = (char)-1;
      int var3 = var1 >> 16 & var2;
      this.I(var3);
      var3 = var1 & var2;
      this.I(var3);
   }

   private void I() {
      Image var1 = this.a1013[3][3];
      Object var2 = null;
      boolean var3 = true;
      this.a(var1, 0, 0, 13450878, var3);
      this.a1002.setColor(15988422);
      Graphics var4 = this.a1002;
      int var5 = 0;
      Image var13 = null;
      int var6 = 12;
      short var7 = 240;
      int var8 = 12;
      var4.drawLine(0, var6, var7, var8);
      int var9 = 0;
      Object var18 = null;
      int var10 = 0;

      while (true) {
         var9 = (byte)3;
         if (var10 >= var9) {
            this.a1002.setClip(0, 0, 240, 320);
            return;
         }

         var18 = this.a1013[3];
         var5 = (byte)19;
         var13 = (Image)((Object[])var18)[var5];
         var9 = var10 * 82;
         var6 = var9 + 25;
         int var28 = 0;
         var18 = this.d1050;
         var8 = var10 << 1;
         byte var31 = (byte)((Object[])var18)[var8];
         var3 = false;
         var18 = this.d1050;
         int var11 = (var10 << 1) + 1;
         byte var37 = (byte)((Object[])var18)[var11];
         int var12 = this.a1013[3][19].getHeight();
         this.a(var13, var6, 0, var31, 0, var37, var12, 0, 0);
         if (var10 == 0) {
            var9 = this.aS;
         } else {
            byte var35 = 1;
            if (var10 == var35) {
               var9 = this.bz;
            } else {
               var9 = this.by;
            }
         }

         var5 = var10 * 82 + 25;
         var2 = this.d1050;
         var28 = (var10 << 1) + 1;
         byte var26 = (byte)((Object[])var2)[var28];
         var5 = var5 + var26 + 2;
         boolean var27 = false;
         var2 = null;
         this.b(var9, var5, 0);
         var9 = var10 + 1;
         var10 = var9;
      }
   }

   private void I(int var1) {
      ByteArrayOutputStream var2 = this.a1191;
      int var3 = var1 >> 8 & 0xFF;
      var2.write(var3);
      var2 = this.a1191;
      var3 = var1 & 0xFF;
      var2.write(var3);
   }

   private void J() {
      int var2 = this.au;
      int var3 = this.av;
      var2 += var3;
      int var5 = 289 - var2 + 1;
      var3 = this.av;
      int var6 = 289 - var3;
      Image[][] var1 = this.a1013;
      var2 = var1[3][6].getHeight();
      int var8 = var6 + var2 + 1;
      Graphics var25 = this.a1002;
      var25.setColor(16580557);
      Graphics var9 = this.a1002;
      int var10 = this.au;
      var3 = this.av;
      var10 += var3;
      int var4 = 289 - var10;
      var3 = this.au;
      int var11 = var3 + 21;
      var3 = this.av;
      var11 += var3;
      var9.fillRect(0, var4, 240, var11);
      var1 = this.a1013;
      Image var7 = var1[3][6];
      var1 = this.a1013;
      var4 = var1[3][6].getWidth();
      var4 = 120 - var4;
      this.a(var7, var4, var5, 12010381, true);
      var1 = this.a1013;
      var7 = var1[3][7];
      this.a(var7, 0, var5, 0, false);
      var1 = this.a1013;
      Image var14 = var1[3][5];
      int var15 = 0;
      Image var16 = null;
      this.a(var14, 0, var8, 0, false);
      Graphics var30 = this.a1002;
      var30.setColor(15455661);
      var1 = this.a1013;
      Image[] var149 = var1[3];
      Image var150 = var149[5];
      var6 = var150.getWidth();
      var1 = this.a1013;
      Image[] var140 = var1[3];
      int var92 = 5;
      var7 = var140[var92];
      var2 = var7.getHeight();
      Graphics var33 = this.a1002;
      var10 = var8 + 2;
      int var12 = var6 << 1;
      var11 = 240 - var12;
      int var166 = 9;
      var33.fillRect(var6, var10, var11, var166);
      var3 = this.aw;
      if (var3 != 0) {
         int var17 = var8 + var2;
         var3 = this.av;
         this.c(57, var17, 183, var3, 0);
         var15 = (boolean)0;
         var16 = null;
         var17 = var8 + var2;
         int var19 = 57;
         var3 = this.av;
         var92 = (byte)3;
         int var18 = var3 - var92;
         byte var20 = 1;
         this.c(0, var17, var19, var18, var20);
         var3 = this.au;
         if (var3 != 0) {
            var1 = this.a1013;
            var166 = var1[3][6].getHeight();
            var9 = this.a1002;
            Object var142 = null;
            var92 = var5 + var166;
            var3 = this.au;
            var9.setClip(0, var92, 240, var3);
            var1 = this.a1013;
            Image[] var152 = var1[3];
            var16 = var152[10];
            boolean var180 = false;
            var19 = var5 + var166;
            var18 = 14311547;
            boolean var197 = true;
            this.a(var16, 0, var19, var18, var197);
            var6 = this.aG;
            var2 = var5 + var166 + 1;
            var3 = this.au;
            byte var22 = 16;
            this.a(var6, var2, var22, var3);
            byte[][] var153 = this.d1053;
            var3 = this.aC;
            byte[] var154 = var153[var3];
            var3 = this.aD;
            byte var55 = var154[var3];
            byte var95 = 67;
            var5 = var8 + var166 + 15;
            short var160 = 163;
            var3 = this.av;
            this.e(var55, var95, var5, var160, var3);
            var6 = var166;
         } else {
            var6 = var2;
         }

         var3 = this.av;
         if (var3 != 0) {
            var6 += var8;
            var3 = this.av;
            var2 = var3 >> 1;
            var6 += var2;
            var3 = this.aC;
            int var96 = 2;
            if (var3 >= var96) {
               int[][] var143 = this.c1107;
               var3 = this.ay;
               int[] var144 = var143[var3];
               byte[][] var13 = this.d1053;
               var3 = this.aC;
               byte[] var168 = var13[var3];
               var3 = this.aD;
               var96 = var168[var3];
               var15 = var144[2];
               var17 = var144[3];
               int var192 = 28;
               var6 -= 5;
               var5 = var144[2];
               byte var161 = 10;
               byte var110;
               if (var5 == var161) {
                  var110 = 10;
               } else {
                  var110 = 0;
               }

               var18 = var6 + var110;
               boolean var198 = false;
               byte var23 = 2;
               int var24 = 0;
               this.a(var15, var17, var192, var18, 0, var23, 0);
               int var125 = 21;
               if (var96 != var125) {
                  label55: {
                     var1 = this.a1013;
                     var16 = var1[3][19];
                     short var182 = 210;
                     var192 = var8 + 2;
                     byte[] var37 = this.d1050;
                     byte var187 = var37[2];
                     var198 = false;
                     byte[] var38 = this.d1050;
                     var23 = var38[3];
                     var1 = this.a1013;
                     Image[] var155 = var1[3];
                     var110 = (byte)19;
                     Image var156 = var155[var110];
                     var24 = var156.getHeight();
                     this.a(var16, var182, var192, var187, 0, var23, var24, 0, 0);
                     var125 = (byte)16;
                     if (var96 != var125) {
                        var125 = (byte)18;
                        if (var96 != var125) {
                           var125 = (byte)20;
                           if (var96 == var125) {
                              var3 = this.ay;
                              var125 = this.b(var3);
                              var96 = (short)224;
                              var110 = var8 + 2;
                              this.b(var125, var96, var110);
                           }
                           break label55;
                        }
                     }

                     var125 = var144[2];
                     var96 = var144[3];
                     int var129 = this.o(var125, var96);
                     if (var129) {
                        var129 = var144[2];
                        byte[] var169 = this.r1101;
                        var110 = var144[3];
                        var129 = this.a(var129, var169, var110) >> 1;
                     } else {
                        var129 = var144[2];
                        byte[] var170 = this.r1101;
                        var110 = var144[3];
                        var129 = this.a(var129, var170, var110);
                     }

                     short var99 = 224;
                     var110 = var8 + 2;
                     this.b(var129, var99, var110);
                  }

                  var125 = var144[2];
                  byte var57 = 2;
                  var96 = var8 + 2;
                  this.h(var125, var57, var96);
               }
            } else {
               var3 = this.aC;
               if (var3 == 0) {
                  byte[][] var145 = this.d1053;
                  var3 = this.aC;
                  byte[] var146 = var145[var3];
                  var3 = this.aD;
                  byte var58 = var146[var3];
                  int var102 = 21;
                  if (var58 != var102) {
                     var1 = this.a1013;
                     var16 = var1[3][19];
                     var19 = var8 + 2;
                     byte[] var41 = this.d1050;
                     int var188 = var41[2];
                     byte[] var42 = this.d1050;
                     byte var203 = var42[3];
                     var1 = this.a1013;
                     int var207 = var1[3][19].getHeight();
                     this.a(var16, 210, var19, var188, 0, var203, var207, 0, 0);
                     byte[] var44 = this.q1100;
                     var102 = var44[var58];
                     short var116 = 224;
                     var10 = var8 + 2;
                     this.b(var102, var116, var10);
                     boolean var183 = false;
                     byte var195 = 28;
                     var188 = var6 - 5;
                     boolean var200 = false;
                     var203 = 2;
                     boolean var208 = false;
                     this.a(var58, 0, var195, var188, 0, var203, 0);
                     byte var136 = 2;
                     var102 = var8 + 2;
                     this.h(var58, var136, var102);
                  }
               } else {
                  var3 = this.aC;
                  int var105 = 1;
                  if (var3 == var105) {
                     var3 = this.aD;
                     var105 = (byte)5;
                     if (var3 < var105) {
                        var3 = this.aD;
                        byte var117 = 1;
                        byte var21 = 28;
                        this.a(var3, var21, var6, (boolean)var117);
                        boolean[] var147 = this.a1056;
                        var3 = this.aD;
                        short var59 = var147[var3];
                        if (var59) {
                           Graphics var148 = this.a1002;
                           var1 = this.a1013;
                           Image var171 = var1[3][23];
                           var117 = 1;
                           boolean var163 = false;
                           var148.drawImage(var171, var117, var6, 0);
                        } else {
                           var1 = this.a1013;
                           var16 = var1[3][19];
                           short var184 = 210;
                           var19 = var8 + 2;
                           byte[] var47 = this.d1050;
                           byte var190 = var47[2];
                           boolean var201 = false;
                           byte[] var48 = this.d1050;
                           byte var205 = var48[3];
                           var1 = this.a1013;
                           int var209 = var1[3][19].getHeight();
                           this.a(var16, var184, var19, var190, 0, var205, var209, 0, 0);
                           byte[] var157 = this.g1057;
                           var3 = this.aD;
                           byte var137 = var157[var3];
                           var59 = 224;
                           var105 = var8 + 2;
                           this.b(var137, var59, var105);
                        }
                     }
                  }
               }
            }
         }
      } else {
         byte var138 = 2;
         var2 = var8 + 1;
         this.h(var138, var2);
      }

      Graphics var50 = this.a1002;
      var50.setClip(0, 0, 240, 320);
   }

   private void K() {
      byte var1 = 18;
      byte var2 = 20;
      int var3 = 0;
      int var4 = this.aw;
      switch (var4) {
         case 0:
            var4 = this.bN;
            var3 = this.bO;
            this.a(var4, var3);
            break;
         case 1:
            var4 = this.av + 20;
            this.av = var4;
            var3 = this.ax;
            if (var4 > var3) {
               var4 = this.ax;
               this.av = var4;
               var4 = this.au + 20;
               this.au = var4;
               if (var4 > var1) {
                  this.au = var1;
               }

               this.M();
            }

            var4 = this.h1047;
            switch (var4) {
               case -7:
                  byte var18 = 2;
                  this.aw = var18;
                  return;
               default:
                  return;
            }
         case 2:
            var4 = this.au - var2;
            this.au = var4;
            if (var4 < 0) {
               this.au = 0;
               var4 = this.av - var2;
               this.av = var4;
               if (var4 < 0) {
                  this.aw = 0;
                  this.av = 0;
                  this.a();
               }
            }
            break;
         case 3:
            var4 = this.au - var2;
            this.au = var4;
            if (var4 < 0) {
               this.au = 0;
               var4 = this.av - var2;
               this.av = var4;
               if (var4 < 0) {
                  this.aw = 4;
                  this.bF = 1;
                  this.av = 0;
                  byte var11 = 13;
                  this.a((int)var11);
               }
            }
            break;
         case 4:
            var4 = this.bN;
            var3 = this.bO;
            this.m(var4, var3);
      }
   }

   private void L() {
      byte var1 = 3;
      byte var2 = 2;
      int var3 = 1;
      int var4 = 0;
      int var5 = -1;
      int var6 = this.h1047;
      switch (var6) {
         case -7:
            this.a();
            break;
         case -6:
         case -5:
         case 53:
            var6 = this.bN;
            var5 = this.bO;
            var4 = this.bw;
            var3 = this.aA;
            this.c(var6, var5, var4, var3);
            break;
         case -4:
         case 54:
            int[] var18 = this.m1129;
            var6 = var18[var3];
            if (var6 != var5) {
               this.aA = var3;
            }
            break;
         case -3:
         case 52:
            int[] var17 = this.m1129;
            var6 = var17[var1];
            if (var6 != var5) {
               this.aA = var1;
            }
            break;
         case -2:
         case 56:
            int[] var16 = this.m1129;
            var6 = var16[var2];
            if (var6 != var5) {
               this.aA = var2;
            }
            break;
         case -1:
         case 50:
            int[] var7 = this.m1129;
            var6 = var7[0];
            if (var6 != var5) {
               this.aA = 0;
            }
      }
   }

   private void M() {
      byte var1;
      byte var2;
      byte var3;
      byte var4;
      label77: {
         var1 = 4;
         var2 = 3;
         var3 = 1;
         var4 = 2;
         int var5 = this.aC;
         if (var5 != 0) {
            var5 = this.aC;
            if (var5 != var3) {
               break label77;
            }
         }

         byte[] var6 = this.f1055;
         this.a(var6);
      }

      int var14 = this.g1046;
      switch (var14) {
         case -4:
         case 54:
            this.aH = 0;
            var14 = this.aD + 1;
            this.aD = var14;
            int var50 = this.aB;
            if (var14 > var50) {
               this.aD = 0;
               this.aE = 0;
            }

            var14 = this.aD;
            var50 = this.aF - var3;
            if (var14 > var50) {
               var14 = this.aD;
               var50 = this.aE;
               var14 -= var50;
               var50 = this.aF - var3;
               if (var14 > var50) {
                  var14 = this.aE + 1;
                  this.aE = var14;
               }
            }
            break;
         case -3:
         case 52:
            this.aH = 0;
            var14 = this.aD - var3;
            this.aD = var14;
            if (var14 < 0) {
               var14 = this.aB;
               this.aD = var14;
               var14 = this.aD;
               int var7 = this.aF - var3;
               var14 -= var7;
               this.aE = var14;
            }

            var14 = this.aD;
            int var47 = this.aB;
            int var8 = this.aF - var3;
            var47 -= var8;
            if (var14 < var47) {
               var14 = this.aE;
               if (var14 > 0) {
                  var14 = this.aD;
                  var47 = this.aE;
                  var14 -= var47;
                  if (var14 < 0) {
                     var14 = this.aE - var3;
                     this.aE = var14;
                  }
               }
            }
      }

      var14 = this.h1047;
      switch (var14) {
         case -6:
         case -5:
         case 53:
            byte[][] var45 = this.d1053;
            int var54 = this.aC;
            byte[] var46 = var45[var54];
            var54 = this.aD;
            int var30 = var46[var54];
            int var56 = 21;
            if (var30 == var56) {
               this.aw = var4;
            } else {
               var56 = this.aC;
               switch (var56) {
                  case 0:
                     var56 = this.bt;
                     byte var65 = 30;
                     if (var56 < var65) {
                        boolean[] var68 = this.e1105;
                        int var61 = var68[var30];
                        if (var61) {
                           var61 = this.bz;
                           byte[] var70 = this.q1100;
                           var65 = var70[var30];
                           if (var61 >= var65) {
                              this.bw = var30;
                              this.aw = var2;
                           } else {
                              this.o = 0;
                              this.F(var4);
                           }
                        } else {
                           this.o = var4;
                           this.F(var3);
                        }
                     } else {
                        byte var44 = 7;
                        this.o = var44;
                     }
                     break;
                  case 1:
                     byte var59 = 22;
                     if (var30 == var59) {
                        this.r = 0;
                        var30 = (byte)24;
                        this.a((int)var30);
                     } else {
                        var30 = this.aD;
                        this.k(var30);
                     }
                     break;
                  case 2:
                  case 5:
                     var56 = this.ay;
                     this.x(var56);
                  case 3:
                  case 4:
                  case 6:
                  case 7:
                     int[][] var9 = this.c1107;
                     int var63 = this.ay;
                     int[] var67 = var9[var63];
                     switch (var30) {
                        case 16:
                           var30 = this.ay;
                           boolean var41 = this.d(var30);
                           if (var41) {
                              var67[var1] = var1;
                              this.aw = var4;
                           }
                        case 17:
                        default:
                           break;
                        case 18:
                           var30 = var67[var4];
                           var63 = var67[var2];
                           int var34 = this.o(var30, var63);
                           if (var34) {
                              var34 = var67[var4];
                              byte[] var10 = this.r1101;
                              var2 = var67[var2];
                              var34 = this.a(var34, var10, var2) >> 1;
                           } else {
                              var34 = var67[var4];
                              byte[] var69 = this.r1101;
                              var2 = var67[var2];
                              var34 = this.a(var34, var69, var2);
                           }

                           byte var38 = this.j(var34);
                           if (var38) {
                              var38 = 15;
                              var67[var38] = var3;
                              this.aw = var4;
                           } else {
                              this.o = 0;
                           }
                           break;
                        case 19:
                           var67[15] = 0;
                           var30 = this.ay;
                           this.v(var30);
                           this.aw = var4;
                           break;
                        case 20:
                           byte var31 = 5;
                           var67[var1] = var31;
                           this.aw = var4;
                     }
               }
            }
      }
   }

   private void N() {
      byte var1 = 1;
      int var2 = 0;

      while (true) {
         byte[] var3 = this.E1163;
         int var4 = var3.length;
         if (var2 >= var4) {
            break;
         }

         var3 = this.E1163;
         int var12 = var3[var2];
         byte var5 = 11;
         if (var12 == var5) {
            var12 = this.b(var2, 0);
            this.aK = var12;
            var2 = this.b(var2, var1);
            this.aL = var2;
            break;
         }

         var2++;
      }

      var2 = 0;

      while (true) {
         byte[] var10 = this.E1163;
         int var14 = var10.length;
         if (var2 >= var14) {
            break;
         }

         var10 = this.E1163;
         int var15 = var10[var2];
         byte var17 = 10;
         if (var15 == var17) {
            var15 = this.b(var2, 0);
            this.aI = var15;
            var2 = this.b(var2, var1);
            this.aJ = var2;
            break;
         }

         var2++;
      }
   }

   private void O() {
      byte var1 = 8;
      byte var2 = -1;
      int var3 = this.p1078;
      if (var3) {
         this.p1078 = false;
         var3 = this.aS & 3;
         int var4 = 3;
         if (var3 == var4) {
            boolean var7 = true;
            this.o1077 = var7;
         } else {
            this.o1077 = false;
         }

         this.aR = 0;
         this.aT = 0;
         var3 = this.aS + 1;
         this.aS = var3;
         this.R();
         var3 = this.aV + 12;
         this.bj = var3;
         var3 = this.bj;
         this.c(var3);
         var3 = this.bj;
         this.aU = var3;
         var3 = this.ba;
         if (var3 != 0) {
            byte[] var5 = this.k1068;
            var4 = this.ba;
            byte var13 = var5[var4];
            this.aM = var13;
            var13 = 38;
            var4 = this.aM;
            this.a(var13, var4);
         }

         int var15 = this.o1077;
         if (var15) {
            this.ar = var1;
            this.g(var1, var2);
         } else {
            var15 = this.aV + 9;
            this.ar = var15;
            var15 = this.aV + 9;
            this.g(var15, var2);
         }
      }
   }

   private void P() {
      byte var1 = 30;
      byte[][] var2 = this.h1074;
      int var3 = this.X;
      byte[] var5 = var2[var3];
      var3 = this.aO;
      int var4 = var5[var3];
      this.aN = var4;
      this.e(0);
      this.be = -42;
      this.e(20);
      var4 = this.aN;
      this.E(var4);
      this.e(var1);
      this.aj();
      this.e(50);
      this.c(var1);
      this.e(60);
      this.c(31);
      this.e(80);
      this.N();
      this.e(100);
   }

   private void Q() {
      byte var1 = 30;
      byte[][] var2 = this.h1074;
      int var3 = this.X;
      byte[] var5 = var2[var3];
      var3 = this.aO;
      int var4 = var5[var3];
      this.aN = var4;
      this.e(0);
      this.be = -42;
      this.e(10);
      this.c(31);
      this.e(20);
      this.c(var1);
      var4 = this.bj;
      this.c(var4);
      this.e(var1);
      var4 = this.aN;
      this.E(var4);
      this.e(40);
      this.c(29);
      this.e(60);
      var4 = 0;
      var2 = null;

      while (true) {
         int var8 = 11;
         if (var4 >= var8) {
            this.e(80);
            this.N();
            this.b();
            this.e(100);
            return;
         }

         var8 = var4 + 18;
         this.c(var8);
         var4++;
      }
   }

   private void R() {
      byte var1 = 6;
      byte var2 = 3;
      byte var3 = 1;
      int var4 = this.o1077;
      if (var4) {
         label45: {
            var4 = this.aN;
            if (var4 > var3) {
               var4 = this.aN;
               if (var4 < var1) {
                  byte[][] var29 = this.A1132;
                  int var6 = this.X;
                  byte[] var30 = var29[var6];
                  var6 = this.aN;
                  byte var14 = var30[var6];
                  if (var14 == var3) {
                     var29 = this.z1131;
                     var6 = this.aN;
                     byte[] var32 = var29[var6];
                     var4 = var32.length >> 1;
                  } else {
                     var4 = 0;
                     var29 = null;
                  }
                  break label45;
               }
            }

            var4 = 0;
            Object var5 = null;
         }

         byte[][] var7 = this.z1131;
         int var8 = this.aN;
         byte[] var61 = var7[var8];
         var8 = (this.aS >> 2) + var4 - var3;
         int var44 = var61[var8];
         this.bb = var44;
         byte[][][] var62 = this.a1067;
         var8 = this.aN;
         var7 = var62[var8];
         var8 = (this.aS >> 2) + var4 - var3;
         var44 = var7[var8][0] >> 1;
         this.aV = var44;
         byte[][][] var64 = this.a1067;
         var8 = this.aN;
         var7 = var64[var8];
         var8 = this.aS >> 2;
         var4 = var4 + var8 - var3;
         byte[] var34 = var7[var4];
         byte var16 = var34[var3];
         this.ba = var16;
      } else {
         var4 = this.a() % 21;
         int var46 = 0;
         Object var66 = null;

         while (var46 < var1) {
            byte[][] var9 = this.j1080;
            int var10 = this.aN;
            byte[] var83 = var9[var10];
            byte var78 = var83[var46];
            if (var4 <= var78) {
               this.aV = var46;
               break;
            }

            var46++;
         }

         this.ba = 0;
      }

      byte[][] var35 = this.i1079;
      int var47 = this.aV;
      byte[] var36 = var35[var47];
      int var18 = var36[0];
      byte[][] var67 = this.i1079;
      int var79 = this.aV;
      byte[] var68 = var67[var79];
      int var48 = var68[var3];
      var79 = this.aS;
      var48 *= var79;
      var18 += var48;
      var48 = this.ba;
      if (var48 == var2) {
         var48 = this.aS * 10;
      } else {
         var48 = 0;
         var67 = null;
      }

      var18 += var48;
      this.aW = var18;
      var35 = this.i1079;
      var48 = this.aV;
      int var21 = var35[var48][2];
      var67 = this.i1079;
      var79 = this.aV;
      byte[] var71 = var67[var79];
      int var53 = var71[var2];
      var79 = this.aS;
      var53 *= var79;
      var21 += var53;
      this.aX = var21;
      var35 = this.i1079;
      var53 = this.aV;
      byte[] var39 = var35[var53];
      int var23 = var39[4];
      var53 = this.aS;
      var23 *= var53;
      var53 = this.ba;
      if (var53 == var3) {
         var53 = this.aS;
      } else {
         var53 = 0;
         var67 = null;
      }

      var23 += var53;
      this.aY = var23;
      var35 = this.i1079;
      var53 = this.aV;
      byte[] var41 = var35[var53];
      int var26 = var41[5];
      this.aZ = var26;
      var26 = this.aX;
      byte var60 = 80;
      if (var26 >= var60) {
         byte var28 = 79;
         this.aX = var28;
      }
   }

   private void S() {
      int var1 = this.r1086;
      if (var1) {
         Graphics var2 = this.a1002;
         Image var3 = null;
         Object var4 = null;
         var2.setClip(0, 0, 240, 320);
         this.a1002.setColor(16777215);
         var2 = this.a1002;
         int var5 = this.be;
         int var6 = 15;
         int var7 = 42;
         int var8 = 12;
         var2.fillRect(var5, var6, var7, var8);
         var1 = (boolean)0;
         Graphics var24 = null;
         int var9 = 0;

         while (true) {
            var1 = (byte)3;
            if (var9 >= var1) {
               var3 = this.a1013[3][27];
               var6 = this.be + 2 + 31;
               byte var67 = 9;
               byte var70 = 9;
               this.a(var3, var6, 17, 0, 0, var67, var70, 0, 0);
               var24 = this.a1002;
               var6 = this.be;
               var5 = 240 - var6 - 42;
               int var48 = 15;
               var7 = (byte)42;
               var8 = (byte)12;
               var24.fillRect(var5, var48, var7, var8);
               int var17 = 0;
               var24 = null;
               var9 = 0;

               while (true) {
                  var17 = (byte)2;
                  if (var9 >= var17) {
                     Image[] var31 = this.a1013[3];
                     byte var43 = 27;
                     var3 = var31[var43];
                     var48 = this.be;
                     var17 = 240 - var48 - 42 + 2;
                     var48 = var17 + 31;
                     var7 = (byte)17;
                     var8 = (byte)9;
                     var67 = 9;
                     var70 = 9;
                     this.a(var3, var48, var7, var8, 0, var67, var70, 0, 0);
                     return;
                  }

                  Image[] var29 = this.a1013[3];
                  byte var42 = 26;
                  var3 = var29[var42];
                  var48 = this.be;
                  var17 = 240 - var48 - 42 + 2;
                  var48 = var9 * 15;
                  var17 += var48;
                  var4 = this.b1085[var9];
                  var7 = this.bd;
                  var4 = ((Object[])var4)[var7];
                  var48 = ((Object[])var4)[0] + var17;
                  byte[][] var30 = this.b1085[var9];
                  var7 = this.bd;
                  var7 = var30[var7][1] + 16;
                  var8 = (var9 + 3) * 10;
                  var67 = 10;
                  var70 = 10;
                  this.a(var3, var48, var7, var8, 0, var67, var70, 0, 0);
                  var17 = var9 + 1;
                  var9 = var17;
               }
            }

            Image[] var25 = this.a1013[3];
            byte var40 = 26;
            var3 = var25[var40];
            var1 = this.be + 2;
            var6 = var9 * 10;
            var1 += var6;
            var4 = this.b1085[var9];
            var7 = this.bd;
            var4 = ((Object[])var4)[var7];
            var6 = ((Object[])var4)[0] + var1;
            byte[][] var26 = this.b1085[var9];
            var7 = this.bd;
            var7 = var26[var7][1] + 16;
            var8 = var9 * 10;
            byte var10 = 10;
            byte var11 = 10;
            this.a(var3, var6, var7, var8, 0, var10, var11, 0, 0);
            var1 = var9 + 1;
            var9 = var1;
         }
      }
   }

   private void T() {
      byte var1 = -42;
      int var2 = this.aT;
      int var3 = this.aX;
      if (var2 == var3) {
         var2 = this.aP;
         if (var2 == 0) {
            this.r1086 = true;
            var2 = this.bd + 1;
            this.bd = var2;
            byte var10 = 3;
            if (var2 > var10) {
               this.bd = 0;
            }

            var2 = this.be + 6;
            this.be = var2;
            if (var2 > 0) {
               this.be = 0;
            }

            return;
         }
      }

      var2 = this.be;
      byte var9 = 6;
      var2 -= var9;
      this.be = var2;
      if (var2 < var1) {
         this.be = var1;
         this.r1086 = false;
      }
   }

   private void U() {
      int var1 = 0;
      Object var2 = null;
      int var3 = this.aq;
      this.h(var3);
      this.aw = 0;
      this.bg = 0;
      int var11 = this.s1088;
      if (var11) {
         this.bf = 297;
         short[] var4 = new short[this.bf];
         this.a1087 = var4;
         var11 = (byte)4;
         this.bh = var11;
      } else {
         this.bf = 240;
         short[] var15 = new short[this.bf];
         this.a1087 = var15;
         var11 = (byte)5;
         this.bh = var11;
      }

      var11 = 0;
      Object var16 = null;

      while (true) {
         var1 = this.bf;
         if (var11 >= var1) {
            this.bi = 100;
            this.c();
            this.c(33);
            return;
         }

         boolean var8 = this.s1088;
         if (var8) {
            var2 = this.a1087;
            short var5 = (short)(this.a() % 120 + 210);
            ((Object[])var2)[var11] = var5;
         } else {
            var2 = this.a1087;
            int var6 = this.a() % 160;
            int var17 = 40 - var6;
            short var19 = 320;
            short var18 = (short)(var17 - var19);
            ((Object[])var2)[var11] = var18;
         }

         var11++;
      }
   }

   private void V() {
      int var1 = 0;

      while (true) {
         int var2 = this.bf;
         if (var1 >= var2) {
            var1 = this.bg;
            byte var14 = 15;
            if (var1 > var14) {
               var1 = this.h1047;
               switch (var1) {
                  case -6:
                  case -5:
                  case 53:
                     int var8 = this.s1088;
                     if (var8) {
                        var8 = this.T;
                        if (var8 == 0) {
                           boolean var10 = true;
                           this.t1089 = var10;
                        }

                        this.s1088 = false;
                        this.e(0);
                        this.c();
                        this.e(30);
                        this.c(4);
                        this.e(70);
                        this.l = 16;
                        byte var11 = 100;
                        this.e(var11);
                        this.b();
                     } else {
                        this.B();
                     }
               }
            }

            var1 = this.bg + 1;
            this.bg = var1;
            return;
         }

         boolean var13 = this.s1088;
         if (var13) {
            short[] var3 = this.a1087;
            short var4 = var3[var1];
            byte var5 = 60;
            var4 = (short)(var4 - var5);
            var3[var1] = var4;
            if (var4 < 0) {
               var3 = this.a1087;
               var3[var1] = 0;
            }
         } else {
            short[] var16 = this.a1087;
            short var19 = (short)(var16[var1] + 60);
            var16[var1] = var19;
            if (var19 > 0) {
               var16 = this.a1087;
               var16[var1] = 0;
            }
         }

         var1++;
      }
   }

   private void W() {
      Graphics var1 = this.a1002;
      Image var2 = null;
      int var3 = 0;
      Image var4 = null;
      int var5 = 240;
      int var6 = 320;
      var1.setClip(0, 0, var5, var6);
      var1 = this.a1002;
      int var7 = 13450878;
      var1.setColor(var7);
      int var8 = 0;
      Graphics var18 = null;

      while (true) {
         var7 = this.bf;
         if (var8 >= var7) {
            var8 = this.bg;
            var7 = this.bh;
            if (var8 > var7) {
               var8 = this.bg;
               var7 = this.bh + 2;
               if (var8 >= var7) {
                  var7 = this.a1013[33][2].getWidth();
                  int var12 = 240 - var7 >> 1;
                  var8 = this.bi;
                  var2 = this.a1013[33];
                  var3 = (byte)2;
                  var2 = (Image)((Object[])var2)[var3];
                  var7 = var2.getHeight() >> 1;
                  int var13 = var8 - var7;
                  int var112 = this.s1088;
                  if (var112) {
                     var18 = this.a1002;
                     var2 = this.a1013[33][2];
                     int var45 = 0;
                     var4 = null;
                     var18.drawImage(var2, var12, var13, 0);
                     var112 = this.bg;
                     var7 = this.bh + 3;
                     if (var112 >= var7) {
                        Image[] var20 = this.a1013[33];
                        byte var93 = 4;
                        var2 = var20[var93];
                        var45 = var12 + 20;
                        var5 = var13 + 4;
                        boolean var77 = false;
                        Object var121 = null;
                        boolean var125 = false;
                        Object var14 = null;
                        byte var15 = 27;
                        byte var16 = 23;
                        this.a(var2, var45, var5, 0, 0, var15, var16, 0, 0);
                     }

                     var112 = this.bg;
                     var7 = this.bh + 4;
                     if (var112 >= var7) {
                        Image[] var21 = this.a1013[33];
                        byte var95 = 4;
                        var2 = var21[var95];
                        var45 = var12 + 59;
                        var5 = var13 + 4;
                        byte var78 = 27;
                        boolean var126 = false;
                        Object var132 = null;
                        byte var137 = 27;
                        byte var141 = 23;
                        this.a(var2, var45, var5, var78, 0, var137, var141, 0, 0);
                     }
                  } else {
                     var18 = this.a1002;
                     var2 = this.a1013[33][3];
                     int var48 = 0;
                     var4 = null;
                     var18.drawImage(var2, var12, var13, 0);
                     var112 = this.bg;
                     var7 = this.bh + 3;
                     if (var112 >= var7) {
                        Image[] var23 = this.a1013[33];
                        byte var97 = 5;
                        var2 = var23[var97];
                        var48 = var12 + 20;
                        var5 = var13 + 4;
                        boolean var79 = false;
                        Object var122 = null;
                        boolean var127 = false;
                        Object var133 = null;
                        byte var138 = 27;
                        byte var142 = 23;
                        this.a(var2, var48, var5, 0, 0, var138, var142, 0, 0);
                     }

                     var112 = this.bg;
                     var7 = this.bh + 4;
                     if (var112 >= var7) {
                        Image[] var24 = this.a1013[33];
                        byte var99 = 5;
                        var2 = var24[var99];
                        var48 = var12 + 59;
                        var5 = var13 + 4;
                        byte var80 = 27;
                        boolean var128 = false;
                        Object var134 = null;
                        byte var139 = 27;
                        byte var143 = 23;
                        this.a(var2, var48, var5, var80, 0, var139, var143, 0, 0);
                     }
                  }

                  var112 = var12 + 20;
                  var7 = this.bg;
                  var3 = this.bh;
                  var7 = var7 - var3 - 3;
                  this.n(var112, var13, var7);
                  var112 = var12 + 75;
                  var7 = this.bg;
                  var3 = this.bh;
                  var7 -= var3;
                  byte var53 = 4;
                  var7 -= var53;
                  this.n(var112, var13, var7);
               }

               var8 = this.bg;
               var7 = this.bh + 1;
               if (var8 == var7) {
                  this.a1002.setColor(16777215);
                  var18 = this.a1002;
                  boolean var106 = false;
                  var3 = this.bi;
                  var6 = this.bi;
                  var18.drawLine(0, var3, 240, var6);
                  var18 = this.a1002;
                  Image[] var39 = this.a1013[33];
                  var4 = null;
                  var2 = var39[0];
                  Image var130 = this.a1013[33][0];
                  var5 = var130.getWidth();
                  var3 = 240 - var5 >> 1;
                  var5 = this.bi - 14;
                  boolean var82 = false;
                  Object var123 = null;
                  var18.drawImage(var2, var3, var5, 0);
               }

               var8 = this.bg;
               var7 = this.bh + 2;
               if (var8 == var7) {
                  this.a1002.setColor(16777215);
                  var18 = this.a1002;
                  var4 = this.a1013[33][1];
                  var3 = var4.getWidth();
                  var7 = 240 - var3 >> 1;
                  var3 = this.bi;
                  Image[] var135 = this.a1013[33];
                  byte var140 = 1;
                  Image var136 = var135[var140];
                  int var129 = var136.getWidth();
                  var6 = 240 - var129 >> 1;
                  var5 = 240 - var6;
                  var6 = this.bi;
                  var18.drawLine(var7, var3, var5, var6);
                  var18 = this.a1002;
                  var2 = this.a1013[33][1];
                  Image var131 = this.a1013[33][1];
                  var5 = var131.getWidth();
                  var3 = 240 - var5 >> 1;
                  var5 = this.bi - 4;
                  boolean var85 = false;
                  Object var124 = null;
                  var18.drawImage(var2, var3, var5, 0);
               }
            }

            return;
         }

         boolean var87 = this.s1088;
         if (var87) {
            Graphics var29 = this.a1002;
            short[] var59 = this.a1087;
            short var42 = var59[var8];
            var5 = var8 + 13;
            short[] var9 = this.a1087;
            var6 = var9[var8] + 240;
            int var10 = var8 + 13;
            var29.drawLine(var42, var5, var6, var10);
         } else {
            Graphics var30 = this.a1002;
            short[] var60 = this.a1087;
            var3 = var60[var8] + 13;
            short[] var11 = this.a1087;
            var5 = var11[var8] + 320 + 13;
            var30.drawLine(var8, var3, var8, var5);
         }

         var8++;
      }
   }

   private final void X() {
      byte var1 = 2;
      byte var2 = 9;
      byte var3 = 8;
      byte var4 = 1;
      this.O();
      this.l(var4);
      int var5 = this.l;
      if (var5 == var1) {
         var5 = this.aP;
         if (var5 <= 0) {
            var5 = this.aT;
            int var6 = this.aX;
            if (var5 == var6) {
               var5 = this.g1046;
               byte var22 = 35;
               if (var5 == var22) {
                  this.p1078 = (boolean)var4;
               }
            }
         }
      }

      int[] var7 = this.o1153;
      int[][] var8 = this.b1066;
      int var9 = this.aP;
      int var10 = 24;
      a(var7, var8, var9, var10);
      var5 = 0;
      Object var43 = null;

      while (true) {
         label129: {
            int var23 = this.aP;
            if (var5 >= var23) {
               return;
            }

            var8 = this.b1066;
            var9 = this.o1153[var5];
            int[] var45 = var8[var9];
            var9 = this.o1153[var5];
            this.z(var9);
            int[] var11 = this.o1153;
            var9 = var11[var5];
            this.s(var9);
            var9 = var45[var3];
            switch (var9) {
               case 0:
                  break;
               case 1:
                  var9 = var45[var2] & 1;
                  var10 = var45[5] & 1;
                  if (var9 == var10) {
                     var9 = var45[0];
                     byte[][] var137 = this.k1081;
                     int var147 = var45[var2];
                     byte[] var138 = var137[var147];
                     var10 = var138[0] << 3;
                     var9 += var10;
                     var10 = var45[var4];
                     byte[][] var14 = this.k1081;
                     int var15 = var45[var2];
                     byte[] var164 = var14[var15];
                     var147 = var164[var4] << 3;
                     int var17 = var10 + var147;
                     var10 = var9;
                     var9 = var17;
                  } else {
                     var9 = var45[0];
                     byte[][] var139 = this.k1081;
                     int var149 = var45[var2];
                     byte[] var140 = var139[var149];
                     var10 = var140[0] << 4;
                     var9 += var10;
                     var10 = var45[var4];
                     byte[][] var165 = this.k1081;
                     int var169 = var45[var2];
                     byte[] var166 = var165[var169];
                     var149 = var166[var4] << 4;
                     int var177 = var10 + var149;
                     var10 = var9;
                     var9 = var177;
                  }

                  label106: {
                     int var151 = this.b(var10, var9);
                     if (var151) {
                        var151 = this.c(var10, var9);
                        int var170 = var45[5];
                        if (var151 == var170) {
                           this.a(var10, var9, (boolean)var4);
                           var151 = var45[0];
                           var170 = var45[var4];
                           this.a(var151, var170, false);
                           var45[0] = var10;
                           var45[var4] = var9;
                           byte var88 = 7;
                           var45[var3] = var88;
                           break label106;
                        }
                     }

                     var9 = var45[0];
                     byte[][] var141 = this.k1081;
                     var151 = var45[var2];
                     var10 = var141[var151][0] << 2;
                     var9 += var10;
                     var45[0] = var9;
                     var9 = var45[var4];
                     var141 = this.k1081;
                     var151 = var45[var2];
                     byte[] var143 = var141[var151];
                     var10 = var143[var4] << 2;
                     var9 += var10;
                     var45[var4] = var9;
                     var45[var3] = var1;
                  }

                  var11 = this.o1153;
                  var9 = var11[var5];
                  var23 = var45[var1];
                  this.i(var9, var23);
                  break label129;
               case 2:
                  var9 = var45[0];
                  byte[][] var12 = this.k1081;
                  int var13 = var45[var2] + 2 & 3;
                  var10 = var12[var13][0] << 2;
                  var9 += var10;
                  var45[0] = var9;
                  var9 = var45[var4];
                  var12 = this.k1081;
                  var13 = var45[var2] + 2 & 3;
                  byte[] var136 = var12[var13];
                  var10 = var136[var4] << 2;
                  var9 += var10;
                  var45[var4] = var9;
                  var45[var3] = 3;
                  var11 = this.o1153;
                  var9 = var11[var5];
                  var23 = var45[var1];
                  this.i(var9, var23);
                  break label129;
               case 3:
                  var45[var3] = 0;
                  var11 = this.o1153;
                  var9 = var11[var5];
                  var23 = var45[var1];
                  this.i(var9, var23);
                  break label129;
               case 4:
                  int var65 = 17;
                  var10 = var45[var65] + 1;
                  var45[var65] = var10;
                  var65 = (byte)5;
                  if (var10 > var65) {
                     var65 = (byte)17;
                     var45[var65] = 0;
                  }

                  var65 = var45[var3];
                  int var109 = 4;
                  if (var65 == var109) {
                     byte var69 = 25;
                     var109 = var45[var69] + 1;
                     var45[var69] = var109;
                     var69 = 100;
                     if (var109 > var69) {
                        byte var111 = 100;
                        var45[25] = var111;
                        var69 = 17;
                        var45[var69] = 0;
                        var45[var3] = 0;
                     }
                  }
                  break;
               case 5:
                  int var59 = 7;
                  var10 = var45[var59] + 1;
                  var45[var59] = var10;
                  if (var10 > var3) {
                     var45[7] = 0;
                     var59 = (byte)6;
                     var45[var3] = var59;
                  }

                  var59 = var45[10];
                  int var105 = -1;
                  if (var59 != var105) {
                     byte var62 = 10;
                     var105 = var45[var62] - var4;
                     var45[var62] = var105;
                     if (var105 < 0) {
                        var62 = 10;
                        byte var107 = -1;
                        var45[var62] = var107;
                     }
                  }

                  byte var64 = 15;
                  var45[var64] = 0;
                  break label129;
               case 6:
                  int var57 = 6;
                  var23 = var45[var57] & 1;
                  if (var23 == var4) {
                     int var31 = this.z1169;
                     if (var31) {
                        var31 = this.bz + 100;
                        this.bz = var31;
                     } else {
                        var31 = this.bz + 50;
                        this.bz = var31;
                     }

                     var31 = 0;
                     Object var47 = null;

                     while (true) {
                        var57 = this.aP;
                        if (var31 >= var57) {
                           this.ba = 0;
                           break;
                        }

                        var11 = this.b1066[var31];
                        byte var103 = 26;
                        var11[var103] = 0;
                        var31++;
                     }
                  } else {
                     int var35 = this.z1169;
                     if (var35) {
                        var35 = this.bz + 10;
                        this.bz = var35;
                     } else {
                        var35 = this.bz + 5;
                        this.bz = var35;
                     }
                  }

                  int[] var48 = this.o1153;
                  var23 = var48[var5];
                  this.p(var23);
                  break label129;
               case 7:
                  var11 = this.o1153;
                  var9 = var11[var5];
                  this.o(var9);
                  var9 = var45[12];
                  if (var9 == 0) {
                     var45[var3] = 0;
                  }

                  var11 = this.o1153;
                  var9 = var11[var5];
                  var23 = var45[var1];
                  this.i(var9, var23);
                  break label129;
               case 8:
                  byte var53 = 7;
                  var10 = var45[var53] + 1;
                  var45[var53] = var10;
                  int var24 = 4;
                  if (var10 > var24) {
                     var24 = this.by - var4;
                     this.by = var24;
                     int[] var46 = this.o1153;
                     var24 = var46[var5];
                     this.p(var24);
                  }

                  var24 = this.by;
                  if (var24 <= 0) {
                     this.o = var3;
                     byte var28 = 3;
                     this.F(var28);
                  }
               default:
                  break label129;
            }

            label122: {
               var9 = var45[6];
               if (var9 != var3) {
                  var9 = var45[6];
                  if (var9 != var2) {
                     break label122;
                  }
               }

               var9 = var45[var3];
               if (var9 == 0) {
                  byte var93 = 25;
                  var10 = var45[var93] - var4;
                  var45[var93] = var10;
                  if (var10 < 0) {
                     var45[25] = 0;
                     var93 = 4;
                     var45[var3] = var93;
                  }
               }
            }

            label117: {
               var11 = this.o1153;
               var9 = var11[var5];
               this.o(var9);
               var9 = var45[0];
               byte[][] var144 = this.k1081;
               int var156 = var45[5];
               byte[] var145 = var144[var156];
               int var123 = var145[0];
               var156 = var45[4];
               var123 *= var156;
               var9 += var123;
               var123 = var45[var4];
               byte[][] var167 = this.k1081;
               int var172 = var45[5];
               int var158 = var167[var172][var4];
               var172 = var45[4];
               var158 *= var172;
               var123 += var158;
               int[] var168 = this.o1153;
               var158 = var168[var5];
               this.n(var158);
               var158 = this.a(var9, var123);
               var172 = var45[0];
               int var16 = var45[var4];
               var172 = this.a(var172, var16);
               if (var158 != var172) {
                  int var162 = this.b(var9, var123);
                  if (!var162) {
                     byte var98 = this.c(var9, var123);
                     if (var98) {
                        var45[var3] = var3;
                        var98 = 7;
                        var45[var98] = 0;
                     } else {
                        var98 = 7;
                        var45[var3] = var98;
                     }
                     break label117;
                  }

                  this.a(var9, var123, (boolean)var4);
                  var162 = var45[0];
                  var172 = var45[var4];
                  this.a(var162, var172, false);
               }

               var45[0] = var9;
               var45[var4] = var123;
            }

            var11 = this.o1153;
            var9 = var11[var5];
            var23 = var45[var1];
            this.i(var9, var23);
         }

         var5++;
      }
   }

   private final void Y() {
      int[] var1 = this.n1152;
      int[][] var2 = this.b1066;
      int var3 = this.aP;
      a(var1, var2, var3, 1);
      Graphics var25 = this.a1002;
      int var4 = 0;
      Image var39 = null;
      int var52 = 0;
      Object var5 = null;
      short var6 = 240;
      int var7 = 320;
      var25.setClip(0, 0, var6, var7);
      int var8 = 0;
      Graphics var26 = null;
      int var9 = 0;

      while (true) {
         var8 = this.aP;
         if (var9 >= var8) {
            var8 = 0;
            var26 = null;

            while (true) {
               var4 = this.aP;
               if (var8 >= var4) {
                  return;
               }

               var39 = this.b1066;
               var5 = this.n1152;
               var52 = (int)((Object[])var5)[var8];
               var39 = ((Object[])var39)[var52];
               var52 = (int)((Object[])var39)[8];
               byte var160 = 5;
               if (var52 != var160) {
                  var52 = (int)((Object[])var39)[8];
                  var160 = 6;
                  if (var52 != var160) {
                     var52 = (int)((Object[])var39)[8];
                     var160 = 8;
                     if (var52 != var160) {
                        var5 = this.n1152;
                        var52 = (int)((Object[])var5)[var8];
                        this.r(var52);
                     }
                  }
               }

               var4 = (int)((Object[])var39)[10];
               byte var88 = -1;
               if (var4 != var88) {
                  var39 = this.n1152;
                  var4 = (int)((Object[])var39)[var8];
                  this.q(var4);
               }

               var8++;
            }
         }

         var26 = this.b1066;
         var39 = this.n1152;
         var4 = (int)((Object[])var39)[var9];
         int[] var10 = (int[])((Object[])var26)[var4];
         var26 = null;
         var8 = var10[0];
         var4 = this.bP;
         var8 -= var4;
         var4 = var10[1];
         var52 = this.bQ;
         var4 -= var52;
         int var54 = 0;
         var5 = null;
         int var132 = 0;
         Object var11 = null;
         var7 = (short)256;
         int var12 = 289;
         int var183 = a(var8, var4, 0, 0, var7, var12);
         if (var183) {
            var183 = var10[8];
            int var93 = 6;
            if (var183 != var93) {
               label74: {
                  var183 = var10[8];
                  var93 = (byte)5;
                  if (var183 != var93) {
                     var183 = var10[8];
                     var93 = (byte)6;
                     if (var183 != var93) {
                        var183 = var10[8];
                        var93 = (byte)8;
                        if (var183 != var93) {
                           var183 = var10[8];
                           var93 = (byte)4;
                           if (var183 != var93) {
                              var183 = var10[13];
                              if (var183 == 0) {
                                 var93 = var10[26];
                                 var183 = var10[0];
                                 var54 = this.bP;
                                 var54 = var183 - var54;
                                 var183 = var10[1];
                                 var132 = this.bQ;
                                 var132 = var183 - var132 + 13;
                                 var7 = var10[27];
                                 this.a(var93, var54, var132, var7, true);
                                 var93 = var10[6];
                                 var183 = var10[0];
                                 var54 = this.bP;
                                 var54 = var183 - var54;
                                 var183 = var10[1];
                                 var132 = this.bQ;
                                 var132 = var183 - var132 + 13;
                                 var26 = this.l1083;
                                 var7 = var10[6] >> 1;
                                 var26 = ((Object[])var26)[var7];
                                 var7 = var10[7];
                                 int var175 = (int)((Object[])var26)[var7];
                                 var12 = var10[5];
                                 this.f(var93, var54, var132, var175, var12);
                                 var93 = var10[26];
                                 var183 = var10[0];
                                 var54 = this.bP;
                                 var54 = var183 - var54;
                                 var183 = var10[1];
                                 var132 = this.bQ;
                                 var132 = var183 - var132 + 13;
                                 var175 = var10[27];
                                 boolean var236 = false;
                                 this.a(var93, var54, var132, var175, false);
                                 int var210 = this.u1096;
                                 if (var210) {
                                    var210 = var10[2];
                                    var39 = null;
                                    var93 = var10[0];
                                    var54 = this.bP;
                                    var93 -= var54;
                                    var54 = var10[1];
                                    var132 = this.bQ;
                                    var54 = var54 - var132 + 13;
                                    var132 = var10[6];
                                    this.b(var210, var93, var54, var132);
                                 }
                              }
                              break label74;
                           }
                        }
                     }
                  }

                  var183 = var10[8];
                  int var98 = 5;
                  if (var183 == var98) {
                     var26 = this.a1013[31];
                     var98 = (byte)1;
                     var39 = (Image)((Object[])var26)[var98];
                     var183 = var10[0] - 8;
                     var54 = this.bP;
                     var54 = var183 - var54;
                     var183 = var10[1] - 24;
                     var132 = this.bQ;
                     var132 = var183 - var132 + 13;
                     var183 = var10[7];
                     var7 = var183 * 15;
                     boolean var232 = false;
                     byte var13 = 15;
                     byte var14 = 30;
                     this.a(var39, var54, var132, var7, 0, var13, var14, 0, 0);
                  } else {
                     var183 = var10[8];
                     var98 = (byte)8;
                     if (var183 == var98) {
                        var26 = this.a1013[31];
                        var98 = (byte)2;
                        var39 = (Image)((Object[])var26)[var98];
                        var183 = var10[0] - 8;
                        var54 = this.bP;
                        var54 = var183 - var54;
                        var183 = var10[1] - 24;
                        var132 = this.bQ;
                        var132 = var183 - var132 + 13;
                        var183 = var10[7];
                        var7 = var183 * 24;
                        boolean var233 = false;
                        byte var239 = 24;
                        byte var243 = 24;
                        this.a(var39, var54, var132, var7, 0, var239, var243, 0, 0);
                     } else {
                        var183 = var10[8];
                        var98 = (byte)4;
                        if (var183 == var98) {
                           var26 = this.a1013;
                           var98 = this.bj;
                           var39 = (Image)((Object[])((Object[])var26)[var98])[2];
                           var183 = var10[0];
                           var5 = this.d1091;
                           var132 = var10[6];
                           var5 = ((Object[])var5)[var132];
                           var132 = var10[5];
                           int var59 = (int)((Object[])((Object[])var5)[var132])[0];
                           var183 += var59;
                           var59 = this.bP;
                           var59 = var183 - var59;
                           var183 = var10[1];
                           var11 = this.d1091;
                           var7 = var10[6];
                           var11 = ((Object[])var11)[var7];
                           var7 = var10[5];
                           int var139 = (int)((Object[])((Object[])var11)[var7])[1];
                           var183 += var139;
                           var139 = this.bQ;
                           var139 = var183 - var139 + 13;
                           var183 = var10[17];
                           var7 = var183 * 21;
                           byte var244 = 19;
                           this.a(var39, var59, var139, var7, 0, 21, var244, 0, 0);
                           this.a1002.setClip(0, 0, 240, 320);
                           var26 = this.a1002;
                           int[] var44 = this.k1071;
                           var59 = this.aN;
                           var98 = var44[var59];
                           var26.setColor(var98);
                           var26 = this.a1002;
                           var39 = null;
                           var98 = var10[0];
                           var5 = this.d1091;
                           var139 = var10[6];
                           var5 = ((Object[])var5)[var139];
                           var139 = var10[5];
                           var5 = ((Object[])var5)[var139];
                           int var63 = (int)((Object[])var5)[0];
                           var98 += var63;
                           var63 = this.bP;
                           var98 = var98 - var63 + 8;
                           long var15 = this.a1019 & 1L;
                           var63 = (int)var15;
                           var98 -= var63;
                           var63 = var10[1];
                           var11 = this.d1091;
                           var7 = var10[6];
                           var11 = ((Object[])var11)[var7];
                           var7 = var10[5];
                           var11 = ((Object[])var11)[var7];
                           int var144 = (int)((Object[])var11)[1];
                           var63 += var144;
                           var144 = this.bQ;
                           var63 = var63 - var144 + 13 + 7;
                           var144 = (int)(this.a1019 & 1L);
                           var63 -= var144;
                           long var17 = this.a1019;
                           long var19 = 1L;
                           var17 = (var17 & var19) << 1;
                           var144 = (int)var17 + 6;
                           long var21 = this.a1019;
                           long var23 = 1L;
                           var21 = (var21 & var23) << 1;
                           var7 = (int)var21 + 6;
                           boolean var234 = false;
                           short var240 = 360;
                           var26.fillArc(var98, var63, var144, var7, 0, var240);
                        }
                     }
                  }
               }

               var183 = var10[2];
               label68:
               if (var183 > 0) {
                  var183 = var10[6];
                  byte var114 = 8;
                  if (var183 != var114) {
                     var183 = var10[6];
                     var114 = 9;
                     if (var183 != var114) {
                        break label68;
                     }
                  }

                  var183 = var10[25];
                  if (var183 >= 0) {
                     var183 = var10[25];
                     var114 = 5;
                     if (var183 < var114) {
                        Image[] var37 = this.a1013[31];
                        var114 = 2;
                        var39 = var37[var114];
                        var183 = var10[0] - 8;
                        var54 = this.bP;
                        var54 = var183 - var54;
                        var183 = var10[1] - 20;
                        var132 = this.bQ;
                        var132 = var183 - var132 + 13;
                        var183 = var10[25];
                        var7 = var183 * 24;
                        boolean var238 = false;
                        byte var242 = 24;
                        byte var246 = 24;
                        this.a(var39, var54, var132, var7, 0, var242, var246, 0, 0);
                        break label68;
                     }
                  }

                  var183 = var10[25];
                  var114 = 95;
                  if (var183 >= var114) {
                     var183 = var10[25];
                     var114 = 100;
                     if (var183 <= var114) {
                        Image[] var36 = this.a1013[31];
                        var114 = 2;
                        var39 = var36[var114];
                        var183 = var10[0] - 8;
                        var54 = this.bP;
                        var54 = var183 - var54;
                        var183 = var10[1] - 20;
                        var132 = this.bQ;
                        var132 = var183 - var132 + 13;
                        var7 = var10[25];
                        var183 = 100 - var7;
                        var7 = var183 * 24;
                        boolean var237 = false;
                        byte var241 = 24;
                        byte var245 = 24;
                        this.a(var39, var54, var132, var7, 0, var241, var245, 0, 0);
                     }
                  }
               }
            }
         }

         var183 = var9 + 1;
         var9 = var183;
      }
   }

   private void Z() {
      short var1 = 240;
      int var2 = 2;
      byte var3 = 1;
      this.a1002.setClip(0, 0, var1, 320);
      this.a1002.setColor(16580557);
      Graphics var4 = this.a1002;
      int var5 = this.bn;
      int var6 = this.bo;
      int var7 = this.bp;
      int var8 = this.bq;
      var4.fillRect(var5, var6, var7, var8);
      var4 = this.a1002;
      var5 = this.bn - var3;
      var6 = this.bo + 1;
      var7 = this.bp + 2;
      var8 = this.bq - var2;
      var4.fillRect(var5, var6, var7, var8);
      int var9 = this.bb;
      int var24 = 18;
      this.q(var9, var24, 293);
      var4 = this.a1002;
      Image var10 = this.a1013[3][28];
      int var28 = 299;
      var4.drawImage(var10, 0, var28, 0);
      var9 = this.br;
      if (var9 == var2) {
         var4 = this.a1002;
         var24 = this.bl + 15;
         var28 = this.bm;
         var7 = this.bk;
         var28 += var7;
         var7 = this.bl + 15 + 8;
         var8 = this.bm;
         var2 = this.bk;
         var8 += var2;
         var2 = this.bl + 15 + 8;
         int var11 = this.bm;
         int var12 = this.bk;
         var11 = var11 + var12 + 8;
         var4.fillTriangle(var24, var28, var7, var8, var2, var11);
         var4 = this.a1002;
         var24 = 5465994;
         var4.setColor(var24);
         StringBuffer var20 = new StringBuffer();
         String[] var45 = this.b1015;
         var28 = (this.ba - var3 << 1) + 155;
         String var46 = var45[var28];
         StringBuffer var21 = var20.append(var46);
         String[] var47 = this.b1015;
         var28 = this.bb + 28;
         String var48 = var47[var28];
         StringBuffer var22 = var21.append(var48);
         String[] var49 = this.b1015;
         var28 = (this.ba - var3 << 1) + 155 + 1;
         String var50 = var49[var28];
         String var51 = var22.append(var50).toString();
         var7 = this.bl + 10;
         var8 = this.bm + 5;
         var9 = (this.bl + 10) * 2;
         var2 = var1 - var9;
         var11 = this.bk;
         boolean var34 = false;
         this.a(var51, 0, var7, var8, var2, var11);
      }
   }

   private final int a() {
      return this.a1012.nextInt() & 0xFF;
   }

   private int a(int var1) {
      return this.E1163[var1] >> 1;
   }

   private int a(int var1, int var2) {
      int var3 = var2 >> 4;
      int var4 = this.bG;
      var3 *= var4;
      var4 = var1 >> 4;
      return var3 + var4;
   }

   private int a(int var1, int var2, int var3) {
      short var4 = 360;
      short var5 = 180;
      float var6 = 2.52E-43F;
      int var7 = 0;
      int var8 = 45;
      if (var2 != 0 && var3 != 0) {
         int var9 = Math.abs(var1);
         byte var10 = 89;
         float var11 = 1.25E-43F;
         int var12 = 0;
         Object var13 = null;
         var7 = var8;

         label60: {
            for (int var18 = var10; var18 > var12; var7 = var18 + var12 >> 1) {
               int[] var14 = this.j1049;
               int var15 = var14[var7];
               if (var15 > var9) {
                  var18 = var7 - 1;
               } else {
                  var13 = this.j1049;
                  var12 = (int)((Object[])var13)[var7];
                  if (var12 >= var9) {
                     break;
                  }

                  var12 = var7 + 1;
               }

               if (var18 <= var12) {
                  var8 = var12;
                  break label60;
               }
            }

            var8 = var7;
         }

         if (var2 < 0 && var3 > 0) {
            var8 = var5 - var8;
         } else if (var2 < 0 && var3 < 0) {
            var8 += 180;
         } else if (var2 > 0 && var3 < 0) {
            var8 = var4 - var8;
         }

         if (var8 >= var4) {
            var8 += -360;
         }
      } else if (var2 == 0) {
         if (var3 > 0) {
            var8 = 90;
         } else {
            var8 = 270;
         }
      } else if (var2 > 0) {
         var8 = 0;
      } else {
         var8 = var5;
      }

      return var8;
   }

   private int a(int var1, int var2, int var3, int var4) {
      int var5 = var3 - var1;
      int var6 = var4 - var2;
      if (var5 != 0 && var6 != 0) {
         int var7 = Math.abs((var6 << 12) / var5);
         var5 = this.a(var7, var5, var6);
      } else if (var5 == 0) {
         if (var6 > 0) {
            var5 = 90;
         } else {
            var5 = 270;
         }
      } else if (var5 > 0) {
         var5 = 0;
      } else {
         var5 = 180;
      }

      return var5;
   }

   private int a(int var1, byte[] var2, int var3) {
      int var4 = 0;
      byte[] var5 = this.s1102;
      int var19;
      if (var2 == var5) {
         boolean[] var15 = this.f1106;
         boolean var6 = var15[0];
         if (var6) {
            var19 = 5;
         } else {
            var19 = 0;
            var15 = null;
         }

         var4 = this.i(var1, var3);
         if (var4) {
            var4 = var1 << 1;
            int var10 = var2[var4];
            int var7 = (var1 << 1) + 1;
            byte var21 = var2[var7];
            var10 = d(var10, var21, var3) >> 2;
            var19 += var10;
         }
      } else {
         label21: {
            var5 = this.u1104;
            if (var2 == var5) {
               boolean var20 = this.n(var1, var3);
               if (var20) {
                  var19 = -10;
                  break label21;
               }
            }

            var19 = 0;
            var5 = null;
         }
      }

      var4 = var1 << 1;
      int var13 = var2[var4];
      int var22 = (var1 << 1) + 1;
      byte var23 = var2[var22];
      var13 = d(var13, var23, var3);
      return var19 + var13;
   }

   private static String a(DataInputStream var0) {
      int var1 = var0.readInt();
      if (var1 < 0) {
         IOException var7 = new IOException("nag len");
         throw var7;
      }

      String var2;
      if (var1 == 0) {
         var2 = "";
      } else {
         char[] var3 = new char[var1];
         int var4 = 0;
         Object var5 = null;

         while (var4 < var1) {
            char var6 = (char)var0.readShort();
            var3[var4] = var6;
            var4++;
         }

         var5 = new String(var3, 0, var1);
         var2 = (String)var5;
      }

      return var2;
   }

   private static String a(String var0) {
      byte var1 = 7;
      int var2 = var0.indexOf(47, var1);
      String var3;
      if (var2 < var1) {
         var2 = var0.length();
         var3 = var0.substring(var1, var2);
      } else {
         var3 = var0.substring(var1, var2);
      }

      return var3;
   }

   private static short a(InputStream var0) {
      int var1 = var0.read() & 0xFF;
      int var2 = var0.read() << 8 & 0xFF00;
      return (short)(var1 | var2);
   }

   private void a() {
      int var1 = this.m - 1;
      this.m = var1;
      int[] var2 = this.b;
      int var3 = this.m;
      var1 = var2[var3];
      this.l = var1;
   }

   private void a(byte var1) {
      this.G(var1);
      switch (var1) {
         case 1:
            this.H(16);
            byte var2 = 44;
            this.H(var2);
            String var3 = "N73";
            this.c(var3);
         default:
            this.ay();
            this.av();
      }
   }

   private void a(int var1) {
      int[] var2 = this.b;
      int var3 = this.m;
      int var4 = this.l;
      var2[var3] = var4;
      this.l = var1;
      int var5 = this.m + 1;
      this.m = var5;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void a(int var1, int var2) {
      short var3 = 0;
      Object var4 = null;

      Image[][] var10000;
      try {
         var10000 = this.a1013;
      } catch (Exception var36) {
         var36.printStackTrace();
         return;
      }

      Image[][] var5 = var10000;
      var10000 = var5;

      try {
         var10000 = var10000[var1];
      } catch (Exception var35) {
         var35.printStackTrace();
         return;
      }

      Image[] var39 = var10000;
      if (var39 != null) {
         try {
            var10000 = this.a1013;
         } catch (Exception var34) {
            var34.printStackTrace();
            return;
         }

         var5 = var10000;
         var10000 = var5;

         try {
            var10000 = var10000[var1];
         } catch (Exception var33) {
            var33.printStackTrace();
            return;
         }

         Image[] var41 = var10000;
         Image[] var61 = var41;

         try {
            var10000 = var61[var2];
         } catch (Exception var32) {
            var32.printStackTrace();
            return;
         }

         Image var42 = var10000;
         if (var42 != null) {
            return;
         }
      }

      try {
         var10000 = this.a1013;
      } catch (Exception var31) {
         var31.printStackTrace();
         return;
      }

      var5 = var10000;
      var10000 = var5;

      try {
         var10000 = var10000[var1];
      } catch (Exception var30) {
         var30.printStackTrace();
         return;
      }

      Image[] var44 = var10000;
      if (var44 == null) {
         try {
            var10000 = this.a1013;
         } catch (Exception var29) {
            var29.printStackTrace();
            return;
         }

         var5 = var10000;

         try {
            var67 = this.f;
         } catch (Exception var28) {
            var28.printStackTrace();
            return;
         }

         int[] var6 = var67;
         int[] var68 = var6;

         try {
            var69 = var68[var1];
         } catch (Exception var27) {
            var27.printStackTrace();
            return;
         }

         int var7 = var69;

         try {
            var10000 = new Image[var7];
         } catch (Exception var26) {
            var26.printStackTrace();
            return;
         }

         Image[] var49 = var10000;
         var10000 = var5;
         int var10001 = var1;

         try {
            var10000[var10001] = var49;
         } catch (Exception var25) {
            var25.printStackTrace();
            return;
         }
      }

      try {
         this.getClass();
      } catch (Exception var24) {
         var24.printStackTrace();
         return;
      }

      try {
         var72 = this.a1014;
      } catch (Exception var23) {
         var23.printStackTrace();
         return;
      }

      String[] var46 = var72;
      String[] var73 = var46;

      try {
         var74 = var73[var1];
      } catch (Exception var22) {
         var22.printStackTrace();
         return;
      }

      String var47 = var74;

      try {
         var75 = Display.getResourceAsStream(var47);
      } catch (Exception var21) {
         var21.printStackTrace();
         return;
      }

      InputStream var48 = var75;
      int var52 = 0;
      Object var50 = null;

      while (var52 < var2) {
         try {
            var76 = a(var48);
         } catch (Exception var20) {
            var20.printStackTrace();
            return;
         }

         var3 = var76;
         long var8 = var3;
         InputStream var77 = var48;

         try {
            var77.skip(var8);
         } catch (Exception var19) {
            var19.printStackTrace();
            return;
         }

         var52++;
      }

      try {
         var78 = a(var48);
      } catch (Exception var18) {
         var18.printStackTrace();
         return;
      }

      short var53 = var78;

      try {
         var79 = new byte[var53];
      } catch (Exception var17) {
         var17.printStackTrace();
         return;
      }

      var4 = var79;
      Object var10 = null;
      InputStream var80 = var48;
      byte[] var87 = (byte[])var4;
      byte var10002 = 0;

      try {
         var80.read(var87, var10002, var53);
      } catch (Exception var16) {
         var16.printStackTrace();
         return;
      }

      try {
         var10000 = this.a1013;
      } catch (Exception var15) {
         var15.printStackTrace();
         return;
      }

      var10 = var10000;
      var10000 = (Image[][])var10;

      try {
         var10000 = var10000[var1];
      } catch (Exception var14) {
         var14.printStackTrace();
         return;
      }

      var10 = var10000;
      byte[] var84 = (byte[])var4;
      byte var88 = 0;

      try {
         var10000 = Image.createImage(var84, var88, var53);
      } catch (Exception var13) {
         var13.printStackTrace();
         return;
      }

      var50 = var10000;
      Image[] var86 = (Image[])var10;
      int var89 = var2;

      try {
         var86[var89] = (Image)var50;
      } catch (Exception var12) {
         var12.printStackTrace();
         return;
      }

      try {
         var48.close();
      } catch (Exception var11) {
         var11.printStackTrace();
      }
   }

   private void a(int var1, int var2, int var3) {
      this.a1002.setClip(0, 0, 240, 320);
      this.a1002.setColor(13971834);
      Graphics var4 = this.a1002;
      String var5 = this.b1015[var1];
      var4.drawString(var5, var2, var3, 0);
   }

   private void a(int var1, int var2, int var3, byte var4, int var5, boolean var6) {
      int var20;
      int var23;
      int var27;
      int var28;
      label45: {
         int var7 = 3;
         int var8 = 3;
         float var9 = 4.0E-45F;
         boolean var10 = false;
         boolean var11 = false;
         if (var5 > 0) {
            byte var12 = 4;
            label35:
            if (var5 < var12) {
               switch (var3) {
                  case 0:
                  case 2:
                     if (!var6) {
                        var7 = var5 - 1;
                        var27 = var8;
                        var23 = var7;
                        var20 = 0;
                        var28 = var5;
                        break label45;
                     }
                     break;
                  case 1:
                  case 3:
                     if (var6) {
                        var7 = var5 - 1;
                        var27 = var8;
                        var23 = var7;
                        var20 = 0;
                        var28 = var5;
                        break label45;
                     }
                     break;
                  default:
                     break label35;
               }

               var8 = var5 - 1;
               var28 = var7;
               var20 = var8;
               var23 = 0;
               var9 = 0.0F;
               var27 = var5;
               break label45;
            }
         }

         var28 = var7;
         var20 = 0;
         byte var13 = (byte)var8;
         var23 = 0;
         var9 = 0.0F;
         var27 = var13;
      }

      while (var23 < var28) {
         for (int var29 = var20; var29 < var27; var29++) {
            int var14 = var23 << 4;
            int var15 = this.m1084[var3][0];
            var14 = var14 * var15 + var1;
            var15 = this.m1084[var3][2];
            var14 += var15;
            var15 = var29 << 4;
            byte var16 = this.m1084[var3][1];
            var15 = var15 * var16 + var2;
            byte[] var17 = this.m1084[var3];
            byte var18 = 3;
            var16 = var17[var18];
            var15 += var16;
            var14 = this.a(var14, var15);
            byte[] var19 = this.D1162;
            var19[var14] = var4;
         }

         var23++;
      }
   }

   private void a(int var1, int var2, int var3, int var4) {
      int var5 = 0;
      Graphics var6 = null;
      int var7 = 0;

      while (true) {
         var5 = this.aF;
         if (var7 >= var5) {
            return;
         }

         var5 = var7 * 20;
         int var8 = var1 + var5;
         var5 = this.aD;
         int var9 = this.aE;
         var5 -= var9;
         if (var5 == var7) {
            var6 = this.a1002;
            var9 = var8 - 4;
            int var10 = var2 - 3;
            int var11 = var3 + 8;
            int var12 = var4 + 2;
            var6.setClip(var9, var10, var11, var12);
            this.a1002.setColor(16580557);
            var6 = this.a1002;
            var9 = var8 - 3;
            var10 = var2 - 3;
            var6.drawRect(var9, var10, 21, 20);
            var6 = this.a1002;
            var9 = var8 - 2;
            var10 = var2 - 2;
            byte var53 = 19;
            byte var54 = 19;
            var6.drawRect(var9, var10, var53, var54);
         }

         label36: {
            label42: {
               byte[][] var32 = this.d1053;
               var9 = this.aC;
               byte[] var33 = var32[var9];
               var9 = this.aE + var7;
               byte var41 = var33[var9];
               this.d(var41, var8, var2, var3, var4);
               var5 = this.aC;
               if (var5 == 0) {
                  var5 = this.aE + var7;
                  var41 = 11;
                  if (var5 < var41) {
                     boolean[] var34 = this.e1105;
                     byte[] var13 = this.d1053[0];
                     int var52 = this.aE + var7;
                     var41 = var13[var52];
                     boolean var20 = var34[var41];
                     if (!var20) {
                        break label42;
                     }
                  }
               }

               var5 = this.aC;
               var41 = 1;
               if (var5 != var41) {
                  break label36;
               }

               var5 = this.bt;
               var41 = 1;
               if (var5 >= var41) {
                  break label36;
               }

               var5 = this.aE + var7;
               var41 = 5;
               if (var5 >= var41) {
                  break label36;
               }
            }

            byte[] var35 = this.f1055;
            var9 = this.aH;
            int var24 = var35[var9];
            int var48 = -1;
            if (var24 != var48) {
               var24 = this.aD;
               var48 = this.aE;
               var24 -= var48;
               if (var24 == var7) {
                  var24 = this.aH;
                  this.k(var8, var2, var24);
               }
            }
         }

         var5 = var7 + 1;
         var7 = var5;
      }
   }

   private void a(int var1, int var2, int var3, int var4, int var5) {
      int var6 = this.o;
      int var7 = -1;
      if (var6 != var7) {
         this.a1002.setClip(0, 0, 240, 320);
         this.a1002.setColor(13971834);
         String[] var8 = this.b1015;
         var7 = var1 + 113;
         String var9 = var8[var7];
         this.a(var9, 0, var2, var3, var4, var5);
      }
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      if (var6 == 0) {
         byte var7 = 2;
         this.c(var2, var3, var4, var5, var7);
         int var9 = var2 - 5;
         int var8 = var3 - 2;
         this.e(var1, var9, var8);
      } else {
         byte var10 = 3;
         this.c(var2, var3, var4, var5, var10);
         int var12 = var2 + var4 - 15;
         int var11 = var3 - 2;
         this.e(var1, var12, var11);
      }
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      byte var8 = 5;
      int var9;
      if (var2 > var8) {
         var8 = 5;
         var9 = var8;
      } else {
         var9 = var2;
      }

      int var25 = 0;
      Object var10 = null;
      int var11 = 0;

      while (true) {
         var10 = this.q1114[var1];
         int var12 = var9 >> 1;
         var25 = (byte)((Object[])var10)[var12];
         if (var11 >= var25) {
            this.d(var3, var4, var1, var5, var6, var7);
            this.a1002.setClip(0, 0, 240, 320);
            return;
         }

         var10 = this.g1113[var1];
         var12 = var9 >> 1;
         var10 = ((Object[])var10)[var12];
         var12 = var11 * 3;
         var25 = (byte)((Object[])var10)[var12];
         byte[][] var13 = this.g1113[var1];
         int var14 = var9 >> 1;
         byte[] var36 = var13[var14];
         var14 = var11 * 3 + 1;
         int var44 = var36[var14];
         var13 = this.g1113[var1];
         int var15 = var9 >> 1;
         byte[] var38 = var13[var15];
         var15 = var11 * 3 + 2;
         int var47 = var38[var15];
         byte var34 = 0;
         var13 = null;
         byte var16 = 0;
         Object var17 = null;
         byte var18 = 10;
         if (var1 == var18) {
            byte[] var40 = this.r1115[var6];
            var34 = var40[0];
            var17 = this.r1115[var6];
            var16 = (byte)((Object[])var17)[1];
            var18 = var34;
         } else {
            var18 = 0;
            Object var20 = null;
         }

         Image[][] var41 = this.a1013;
         int var19 = var1 + 18;
         Image var42 = var41[var19][0];
         var44 = var44 + var3 + var18;
         var47 = var47 + var4 + var16 + 13;
         var17 = this.f1112[var1][var25];
         var16 = (byte)((Object[])var17)[0];
         byte[] var55 = this.f1112[var1][var25];
         var18 = var55[1];
         byte[] var21 = this.f1112[var1][var25];
         byte var54 = var21[2];
         byte[][] var22 = this.f1112[var1];
         byte var23 = var22[var25][3];
         this.a(var42, var44, var47, var16, var18, var54, var23, 0, 0);
         var25 = var11 + 1;
         var11 = var25;
      }
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = 0;
      Object var10 = null;
      byte var11 = 0;
      Image var12 = null;
      int var13 = 0;
      Object var14 = null;
      int var15 = 0;
      Object var16 = null;
      int var17 = 0;
      Object var18 = null;
      int var19 = 0;
      Object var20 = null;
      int var21 = 5;
      if (var5 > var21) {
         var21 = 5;
      } else {
         var21 = var5;
      }

      byte var23;
      byte var24;
      Image var25;
      Image var26;
      Image var27;
      switch (var8) {
         case 3:
            Image[][] var129 = this.a1013;
            var10 = var129[29];
            var11 = 22;
            var10 = ((Object[])var10)[var11];
            var129 = this.a1013;
            Image[] var58 = var129[29];
            var13 = (byte)19;
            var12 = var58[var13];
            var129 = this.a1013;
            var14 = var129[29];
            var15 = (byte)21;
            var14 = ((Object[])var14)[var15];
            var129 = this.a1013;
            var16 = var129[29];
            var16 = ((Object[])var16)[20];
            byte[][] var133 = this.J1144;
            var19 = var21 >> 1;
            var18 = var133[var19];
            var17 = (byte)((Object[])var18)[0];
            byte[][] var134 = this.J1144;
            var21 >>= 1;
            var20 = var134[var21];
            byte var109 = 1;
            byte var95 = (byte)((Object[])var20)[var109];
            var23 = var95;
            var24 = var17;
            var25 = (Image)var16;
            var26 = (Image)var14;
            var27 = var12;
            var12 = (Image)var10;
            break;
         case 5:
            Image[][] var28 = this.a1013;
            var10 = var28[29];
            var11 = 26;
            var10 = ((Object[])var10)[var11];
            var28 = this.a1013;
            Image[] var56 = var28[29];
            var13 = (byte)23;
            var12 = var56[var13];
            var28 = this.a1013;
            var14 = var28[29];
            var15 = (byte)25;
            var14 = ((Object[])var14)[var15];
            var28 = this.a1013;
            var16 = var28[29][24];
            var17 = (byte)-5;
            byte var93 = -26;
            var23 = var93;
            var24 = var17;
            var25 = (Image)var16;
            var26 = (Image)var14;
            var27 = var12;
            var12 = (Image)var10;
            break;
         default:
            var23 = 0;
            var24 = 0;
            var25 = null;
            var26 = null;
            var27 = null;
            var11 = (boolean)0;
            var12 = null;
      }

      switch (var7) {
         case 0:
            var9 = var1 + var24;
            var13 = var2 + var23;
            this.s(var9, var13, var6);
            int var33 = 1;
            if (var6 > var33) {
               var33 = (byte)4;
               if (var6 < var33) {
                  switch (var8) {
                     case 3:
                        var33 = var1 + var24 + 21;
                        int var124 = this.bP;
                        var13 = var33 - var124;
                        var33 = var2 + var23 + 16;
                        var124 = this.bQ;
                        var15 = var33 - var124 + 13;
                        var33 = var6 - 2;
                        var17 = var33 << 4;
                        boolean var100 = false;
                        var20 = null;
                        byte var114 = 16;
                        byte var138 = 16;
                        this.a(var12, var13, var15, var17, 0, var114, var138, 0, 0);
                        return;
                     case 5:
                        var33 = var1 + var24 + 24;
                        int var122 = this.bP;
                        var13 = var33 - var122;
                        var33 = var2 + var23 + 23;
                        var122 = this.bQ;
                        var15 = var33 - var122 + 13;
                        var33 = var6 - 2;
                        var17 = var33 * 12;
                        boolean var99 = false;
                        var20 = null;
                        byte var113 = 12;
                        byte var137 = 17;
                        this.a(var12, var13, var15, var17, 0, var113, var137, 0, 0);
                        return;
                     default:
                        return;
                  }
               }
            }

            int var35 = 5;
            if (var6 > var35) {
               var35 = var1 + var24 + 26;
               int var118 = this.bP;
               var13 = var35 - var118;
               var35 = var2 + var23 - 31;
               var118 = this.bQ;
               var15 = var35 - var118 + 13;
               var17 = (var6 - 6) * 7;
               boolean var97 = false;
               var20 = null;
               byte var111 = 7;
               byte var135 = 45;
               this.a(var27, var13, var15, var17, 0, var111, var135, 0, 0);
               int var38 = 6;
               if (var6 > var38) {
                  var38 = var1 + var24 + 22;
                  var118 = this.bP;
                  var13 = var38 - var118;
                  var38 = var2 + var23 - 37 - 15;
                  var118 = this.bQ;
                  var15 = var38 - var118 + 13;
                  var38 = var6 - 7;
                  var17 = var38 * 15;
                  var97 = false;
                  var20 = null;
                  var111 = 15;
                  var135 = 15;
                  this.a(var26, var13, var15, var17, 0, var111, var135, 0, 0);
               }
            }
            break;
         case 1:
            int var22 = this.bP;
            var13 = var3 - var22;
            var22 = this.bQ;
            var15 = var4 - var22 + 13;
            var17 = var6 * 12;
            this.a(var25, var13, var15, var17, 0, 12, 41, 0, 0);
            var22 = this.bP;
            var13 = var3 - var22;
            var9 = var4 - 15;
            var22 = this.bQ;
            var9 -= var22;
            var15 = var9 + 13;
            var17 = var6 * 15;
            boolean var96 = false;
            var20 = null;
            byte var110 = 15;
            byte var29 = 15;
            this.a(var26, var13, var15, var17, 0, var110, var29, 0, 0);
      }
   }

   private void a(int var1, int var2, int var3, int var4, boolean var5) {
      if (var5) {
         byte var6 = 1;
         if (var1 != var6) {
            var6 = 2;
            if (var1 != var6) {
               var6 = 3;
               if (var1 != var6) {
                  var6 = 7;
                  if (var1 != var6) {
                     return;
                  }
               }
            }
         }

         this.o(var2, var3, var4);
      } else {
         byte var10 = 4;
         if (var1 != var10) {
            var10 = 5;
            if (var1 != var10) {
               var10 = 8;
               if (var1 != var10) {
                  var10 = 6;
                  if (var1 != var10) {
                     return;
                  }
               }

               var10 = -2;
               if (var4 != var10) {
                  this.o(var2, var3, var4);
               }

               return;
            }
         }

         this.o(var2, var3, var4);
      }
   }

   private void a(int var1, int var2, int var3, boolean var4) {
      int var5 = 10;
      byte var6 = 2;
      int var7 = 0;
      byte[] var8 = this.i1062;
      int var9 = var1 << 2;
      int var10 = var8[var9];
      byte[] var11 = this.i1062;
      int var12 = (var1 << 2) + 1;
      byte var23 = var11[var12];
      byte[] var13 = this.i1062;
      int var14 = (var1 << 2) + 2;
      int var25 = var13[var14];
      byte[] var15 = this.i1062;
      int var16 = (var1 << 2) + 3;
      byte var27 = var15[var16];
      if (var4) {
         if (var1 == var6) {
            var16 = var5;
         } else {
            byte[] var17 = this.e1058[var10];
            var16 = var17[var6] >> 1;
         }

         var6 = 3;
         if (var1 < var6) {
            var6 = (byte)var5;
         } else {
            var6 = 0;
         }
      } else {
         var16 = 0;
         Object var29 = null;
         var6 = 0;
      }

      var7 = (byte)-1;
      if (var10 != var7) {
         var7 = var2 - var16;
         var5 = var3 - var6;
         this.l(var10, var7, var5);
      }

      var10 = var2 - var16 + var25;
      var25 = var3 - var6 + var27;
      this.l(var23, var10, var25);
   }

   private final void a(int var1, int var2, boolean var3) {
      if (var3) {
         boolean var4 = this.b(var1, var2);
         if (!var4) {
            return;
         }
      } else {
         boolean var10 = this.b(var1, var2);
         if (var10) {
            return;
         }
      }

      byte[] var5 = this.E1163;
      int var6 = this.a(var1, var2);
      byte[] var7 = this.E1163;
      int var8 = this.a(var1, var2);
      byte var9 = var7[var8];
      byte var11;
      if (var3) {
         var11 = 1;
      } else {
         var11 = -1;
      }

      var9 = (byte)(var9 + var11);
      var5[var6] = var9;
   }

   private void a(String var1) {
      this.e();
      this.a1002.setColor(7438477);
      int var2 = this.c;
      this.a(var1, var2, 27, 18, 186, 292);
   }

   private void a(String var1, int var2, int var3) {
      this.a1002.setClip(0, 0, 240, 320);
      this.a1002.setColor(16580557);
      Graphics var4 = this.a1002;
      int var5 = var1.length();
      int var6 = this.k;
      var5 = var5 * var6 + 2;
      var6 = this.j + 1;
      var4.fillRect(var2, var3, var5, var6);
      this.a1002.setColor(14174337);
      var4 = this.a1002;
      var5 = var2 + 1;
      var6 = var3 + 1;
      var4.drawString(var1, var5, var6, 0);
   }

   private final void a(String var1, int var2, int var3, int var4, int var5, int var6) {
      byte var7;
      char[] var8;
      int var9;
      boolean var13;
      label23: {
         label22: {
            var7 = 10;
            var8 = var1.toCharArray();
            var9 = var8.length;
            int var10 = this.d;
            if (var10 == var9) {
               if (var9 <= var7) {
                  break label22;
               }

               String var11 = this.a1009;
               String var12 = var1.substring(0, var7);
               var10 = var11.compareTo(var12);
               if (var10 == 0) {
                  break label22;
               }
            }

            boolean var15 = true;
            var13 = var15;
            break label23;
         }

         var13 = false;
      }

      if (var13 && var9 > var7) {
         String var16 = var1.substring(0, var7);
         this.a1009 = var16;
      }

      this.a(var8, var9, var2, var3, var4, var5, var6, var13);
   }

   private void a(Image var1, int var2, int var3, int var4) {
      DirectGraphics var5 = this.a1005;
      int var6 = a1001[var4];
      var5.drawImage(var1, var2, var3, 0, var6);
   }

   private void a(Image var1, int var2, int var3, int var4, int var5) {
      this.a1002.setClip(0, 0, 240, 320);
      int var6 = var1.getWidth();
      int var7 = var1.getHeight();
      this.a1002.drawImage(var1, var2, var3, 0);
      int var8 = var2 + var4 - var6;
      this.a(var1, var8, var3, 1);
      var8 = var3 + var5 - var7;
      this.a(var1, var2, var8, 2);
      var6 = var2 + var4 - var6;
      var7 = var3 + var5 - var7;
      this.a(var1, var6, var7, 3);
   }

   private void a(Image var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = 0;
      Object var8 = null;
      int var9 = 0;

      while (true) {
         var8 = this.i1122[var4];
         var7 = ((Object[])var8).length;
         if (var9 >= var7) {
            return;
         }

         int var18 = this.i1122[var4][var9][0];
         int var10 = var2 + var18;
         int var11 = this.i1122[var4][var9][1] + var3 + 13;
         var18 = this.w1123[var4][var5];
         byte[] var12 = this.w1123[var4];
         int var13 = var6 - 2;
         int var14 = var12[var13];
         var13 = var18 * var14;
         var8 = this.w1123[var4];
         var14 = var6 - 2;
         byte var15 = (byte)((Object[])var8)[var14];
         var8 = this.w1123[var4];
         var14 = var6 - 1;
         byte var16 = (byte)((Object[])var8)[var14];
         this.a(var1, var10, var11, var13, 0, var15, var16, 0, 0);
         var18 = var9 + 1;
         var9 = var18;
      }
   }

   private void a(Image var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.a1002.setClip(var2, var3, var6, var7);
      Graphics var8 = this.a1002;
      int var9 = var2 - var4;
      int var10 = var3 - var5;
      var8.drawImage(var1, var9, var10, 0);
      this.a1002.setClip(0, 0, 240, 320);
   }

   private void a(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = 16;
      int var10 = var1.getWidth();
      int var11 = var1.getHeight();
      int var12;
      switch (var5) {
         case 0:
            var10 = (var8 & 3) << 4;
            var11 = var8 >> 2 << 4;
            var12 = var10;
            break;
         case 1:
            var11 = (var8 & 3) << 4;
            var10 = var10 - var11 - var9;
            var11 = var8 >> 2 << 4;
            var12 = var10;
            break;
         case 2:
            var10 = (var8 & 3) << 4;
            var12 = var8 >> 2 << 4;
            var11 = var11 - var12 - var9;
            var12 = var10;
            break;
         case 3:
            var12 = (var8 & 3) << 4;
            var10 = var10 - var12 - var9;
            var12 = var8 >> 2 << 4;
            var11 = var11 - var12 - var9;
            var12 = var10;
            break;
         case 4:
            var10 = var8 >> 2 << 4;
            var11 = (var8 & 3) << 4;
            var12 = var10;
            break;
         case 5:
            var10 = var8 >> 2 << 4;
            var10 = var11 - var10 - var9;
            var11 = (var8 & 3) << 4;
            var12 = var10;
            break;
         case 6:
            var11 = var8 >> 2 << 4;
            var12 = (var8 & 3) << 4;
            var10 = var10 - var12 - var9;
            var12 = var11;
            var11 = var10;
            break;
         case 7:
            var12 = var8 >> 2 << 4;
            var11 = var11 - var12 - var9;
            var12 = (var8 & 3) << 4;
            var10 = var10 - var12 - var9;
            var12 = var11;
            var11 = var10;
            break;
         default:
            var11 = 0;
            var12 = 0;
      }

      byte var26 = 1;
      if (var2 == var26) {
         this.b1003.setClip(var6, var7, var3, var4);
         DirectGraphics var13 = DirectUtils.getDirectGraphics(this.b1003);
         this.b1006 = var13;
         var13 = this.b1006;
         var12 = var6 - var12;
         var9 = var7 - var11;
         int var14 = a1001[var5];
         var13.drawImage(var1, var12, var9, 0, var14);
      } else {
         DirectGraphics var40 = this.a1005;
         var12 = var6 - var12;
         var9 = var7 - var11;
         int var41 = a1001[var5];
         var40.drawImage(var1, var12, var9, 0, var41);
      }
   }

   private void a(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      int var10 = var9 & 4;
      if (var10 != 0) {
         var10 = var6 >> 1;
         var10 = var2 - var10;
      } else {
         var10 = var2;
      }

      int var11 = var9 & 8;
      if (var11 != 0) {
         var11 = var7 >> 1;
         var11 = var3 - var11;
      } else {
         var11 = var3;
      }

      int var12 = var9 & 1;
      if (var12 != 0) {
         var10 -= var6;
      }

      var12 = var9 & 2;
      if (var12 != 0) {
         var11 -= var7;
      }

      Graphics var13 = this.a1002;
      var13.setClip(var10, var11, var6, var7);
      if (var8 == 0) {
         var13 = this.a1002;
         var10 -= var4;
         var11 -= var5;
         var13.drawImage(var1, var10, var11, 0);
      } else {
         var10 -= var4;
         var11 -= var5;
         this.a(var1, var10, var11, var8);
      }

      this.a1002.setClip(0, 0, 240, 320);
   }

   private void a(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      Image[] var11 = this.a1040;
      if (var11 == null) {
         byte var12 = 26;
         var11 = new Image[var12];
         this.a1040 = var11;
      }

      byte var25 = this.a1038;
      int var13 = 26;
      if (var25 < var13) {
         label45: {
            int[][] var23 = this.a1039;
            var13 = this.a1038;
            var24 = var23[var13];
            if (var10 >= 0) {
               var13 = this.a1038;
               if (var10 < var13) {
                  int[][] var35 = this.a1039;
                  byte var39 = this.a1038;
                  int[] var16 = this.a1039[var10];
                  var35[var39] = var16;
                  Image[] var36 = this.a1040;
                  var39 = this.a1038;
                  Image var48 = this.a1040[var10];
                  var36[var39] = var48;
                  this.a1040[var10] = var1;
                  var35 = this.a1039;
                  var35[var10] = var24;
                  var24 = this.a1039[var10];
                  break label45;
               }
            }

            Image[] var14 = this.a1040;
            byte var15 = this.a1038;
            var14[var15] = var1;
         }

         var13 = (byte)3;
         int var17;
         int var18;
         int var41;
         if (var4 == var13) {
            var24[6] = var9;
            var13 = var8;
            var41 = var7;
            var17 = var3;
            var18 = var2;
         } else {
            var13 = var1.getWidth();
            var41 = var1.getHeight();
            byte var54 = 2;
            if (var4 == var54) {
               var13 /= var6;
               var54 = 6;
               var24[var54] = var13;
            }

            int var56 = 0;
            Object var49 = null;
            int var65 = 0;
            int var19 = var5 & 1;
            if (var19 != 0) {
               var56 = (boolean)0;
               var49 = null;
               var13 = 0 - var13;
            } else {
               var19 = var5 & 4;
               if (var19 != 0) {
                  var56 = (boolean)0;
                  var49 = null;
                  var13 >>= 1;
                  var13 = 0 - var13;
               } else {
                  var13 = 0;
                  Object var38 = null;
               }
            }

            var56 = var5 & 2;
            if (var56 != 0) {
               boolean var60 = false;
               var49 = null;
               var65 = (byte)1;
               var41 -= var65;
               var41 = 0 - var41;
            } else {
               var56 = var5 & 8;
               if (var56 != 0) {
                  boolean var62 = false;
                  var49 = null;
                  var41 >>= 1;
                  var65 = (byte)1;
                  var41 -= var65;
                  var41 = 0 - var41;
               } else {
                  var41 = 0;
               }
            }

            var56 = var2 + var13;
            var65 = var3 + var41;
            byte var71 = 1;
            if (var4 == var71) {
               var13 += var7;
               int var20 = var41 + var8;
               var41 = var13;
               var13 = var20;
               int var21 = var65;
               var18 = var56;
               var17 = var21;
            } else {
               var13 = var8;
               var41 = var7;
               int var73 = var65;
               var18 = var56;
               var17 = var73;
            }
         }

         boolean var72 = false;
         var24[0] = var18;
         byte var69 = 1;
         var24[var69] = var17;
         var24[2] = var4;
         var24[3] = var6;
         byte var64 = 4;
         var24[var64] = var41;
         byte var47 = 5;
         var24[var47] = var13;
         var25 = (byte)(this.a1038 + 1);
         this.a1038 = var25;
      }
   }

   private void a(Image var1, int var2, int var3, int var4, boolean var5) {
      short var6 = 240;
      if (var5) {
         this.a1002.setColor(var4);
         Graphics var7 = this.a1002;
         int var8 = var1.getHeight();
         var7.fillRect(0, var3, var6, var8);
      }

      this.a1002.drawImage(var1, var2, var3, 0);
      int var9 = var1.getWidth();
      var9 = var6 - var9 - var2;
      this.a(var1, var9, var3, 1);
   }

   private void a(Image var1, Image var2, int var3, int var4, int var5, int var6, int var7) {
      int[] var8 = this.c1107[var3];
      Object var9 = null;
      int var10 = var8[0];
      byte[] var11 = this.o1098;
      int var12 = var8[2];
      int var13 = var11[var12] << 3;
      var10 += var13;
      var13 = var8[1];
      byte[] var14 = this.o1098;
      int var15 = var8[2];
      var12 = var14[var15] << 3;
      var13 += var12;
      int var49 = 0;
      var14 = null;
      var15 = var8[2];
      switch (var15) {
         case 0:
            var49 = 0;
            var14 = null;
            break;
         case 1:
            var49 = 2;
            break;
         case 4:
            var49 = 1;
      }

      byte[][] var16 = this.j1139[var49];
      int var17 = var8[5];
      int var75 = var16[var17][0];
      var10 += var75;
      var16 = this.j1139[var49];
      var17 = var8[3];
      byte var18 = 5;
      if (var17 > var18) {
         var17 = 5;
      } else {
         var17 = var8[3];
      }

      var17 = (var17 >> 1) + 4;
      byte[] var85 = var16[var17];
      int var89 = 0;
      var75 = var85[0];
      int var19 = var10 + var75;
      var9 = this.j1139[var49];
      var75 = var8[5];
      var9 = ((Object[])var9)[var75];
      var10 = ((Object[])var9)[1] + var13;
      byte[][] var46 = this.j1139[var49];
      var49 = var8[3];
      int var78 = 5;
      if (var49 > var78) {
         var49 = 5;
      } else {
         var49 = var8[3];
      }

      var49 = (var49 >> 1) + 4;
      var11 = var46[var49];
      int var53 = 1;
      int var61 = var11[var53];
      int var20 = var10 + var61 + 13;
      var10 = var8[5];
      switch (var10) {
         case 0:
            var10 = var19 + var4;
            var61 = this.bP;
            var53 = var10 - var61;
            var10 = var20 - var5;
            var61 = this.bQ;
            var78 = var10 - var61;
            boolean var94 = false;
            byte var96 = 15;
            byte var100 = 2;
            this.a(var1, var53, var78, var6, 0, var7, var96, var100, 0);
            break;
         case 1:
            var10 = var19 + var5;
            var61 = this.bP;
            var53 = var10 - var61;
            var10 = var20 + var4;
            var61 = this.bQ;
            var78 = var10 - var61;
            var89 = (boolean)0;
            byte var102 = 15;
            byte var99 = 4;
            this.a(var1, var53, var78, 0, var6, var102, var7, var99, 0);
            break;
         case 2:
            var10 = var19 + var4;
            var61 = this.bP;
            var53 = var10 - var61;
            var10 = var20 + var5;
            var61 = this.bQ;
            var78 = var10 - var61;
            boolean var93 = false;
            byte var21 = 15;
            boolean var98 = false;
            this.a(var1, var53, var78, var6, 0, var7, var21, 0, 0);
            break;
         case 3:
            var10 = var19 - var5;
            var61 = this.bP;
            var53 = var10 - var61;
            var10 = var20 + var4;
            var61 = this.bQ;
            var78 = var10 - var61;
            var89 = (boolean)0;
            byte var23 = 15;
            byte var22 = 5;
            this.a(var1, var53, var78, 0, var6, var23, var7, var22, 0);
      }

      var10 = var8[2];
      switch (var10) {
         case 0:
         case 4:
            int var41 = 0;
            var9 = null;
            int var24 = 0;

            while (true) {
               var41 = (byte)5;
               if (var24 >= var41) {
                  break;
               }

               var41 = var8[11] * var24 + var19;
               var61 = this.bP;
               var53 = var41 - var61;
               var41 = var8[12] * var24 + var20;
               var61 = this.bQ;
               var78 = var41 - var61;
               var89 = this.C1134[var3][var24] * 9;
               boolean var95 = false;
               byte var103 = 9;
               byte var97 = 9;
               boolean var101 = false;
               this.a(var2, var53, var78, var89, 0, var103, var97, 0, 0);
               var41 = var24 + 1;
               var24 = var41;
            }
      }
   }

   private void a(Image var1, Image var2, Image var3, int var4, int var5, int var6, int var7) {
      int var8 = this.M1147[var6][0] + var4;
      int var9 = this.bP;
      int var10 = var8 - var9;
      byte[] var11 = this.M1147[var6];
      var8 = var11[1] + var5;
      var9 = this.bQ;
      int var12 = var8 - var9 + 13;
      int var18 = 3;
      if (var7 < var18) {
         switch (var6) {
            case 0:
               int var23 = var7 * 14;
               byte var26 = 14;
               byte var29 = 33;
               boolean var32 = false;
               this.a(var1, var10, var12, var23, 0, var26, var29, 0, 0);
               break;
            case 1:
               var18 = 2 - var7;
               int var22 = var18 * 50;
               byte var25 = 50;
               byte var28 = 12;
               byte var31 = 1;
               this.a(var3, var10, var12, var22, 0, var25, var28, var31, 0);
               break;
            case 2:
               int var21 = var7 * 13;
               byte var24 = 13;
               byte var27 = 52;
               boolean var30 = false;
               this.a(var2, var10, var12, var21, 0, var24, var27, 0, 0);
               break;
            case 3:
               int var13 = var7 * 50;
               byte var14 = 50;
               byte var15 = 12;
               boolean var16 = false;
               this.a(var3, var10, var12, var13, 0, var14, var15, 0, 0);
         }
      }
   }

   private void a(boolean var1) {
      byte var2 = 4;
      short var3 = 320;
      byte var4 = 10;
      byte var5 = 2;
      this.e();
      Graphics var6 = this.a1002;
      var6.setColor(13450878);
      int var7 = this.k + 120;
      int var8 = this.j;
      var8 = var3 - var8 >> 1;
      Graphics var9 = this.a1002;
      String var10 = this.b1015[101];
      int var11 = this.k << 1;
      int var12 = 120 - var11 - var2;
      var9.drawString(var10, var12, var8, 0);
      int var13 = this.l1031;
      if (!var13) {
         var9 = this.a1002;
         String[] var29 = this.b1015;
         int var38 = this.l1031;
         if (var38) {
            var38 = (byte)1;
         } else {
            var38 = var5;
         }

         var38 += 101;
         var10 = var29[var38];
         var7 -= var4;
         var11 = this.k;
         var38 = 38 - var11 >> 1;
         var7 += var38;
         var9.drawString(var10, var7, var8, 0);
      } else {
         var9 = this.a1002;
         short var14 = 240;
         var9.setClip(0, 0, var14, var3);
         var13 = 0;
         Object var25 = null;

         label30:
         while (true) {
            int var50 = 5;
            if (var13 >= var50) {
               var13 = 0;
               var25 = null;

               while (true) {
                  var50 = this.q / 20;
                  if (var13 >= var50) {
                     break label30;
                  }

                  this.a1002.setColor(15888524);
                  Graphics var32 = this.a1002;
                  var12 = var13 * 4 + var7;
                  var11 = var8 + 10;
                  int var55 = var13 * 2;
                  var11 -= var55;
                  var55 = var13 * 2 + 3;
                  var32.fillRect(var12, var11, var5, var55);
                  var13++;
               }
            }

            this.a1002.setColor(16571546);
            Graphics var31 = this.a1002;
            var12 = var13 * 4 + var7;
            var11 = var8 + 10;
            int var15 = var13 * 2;
            var11 -= var15;
            var15 = var13 * 2 + 3;
            var31.fillRect(var12, var11, var5, var15);
            var13++;
         }
      }

      if (var1) {
         byte var18 = 3;
         Image[] var27 = this.a1013[var2];
         byte var52 = 25;
         Image var28 = var27[var52];
         var13 = var28.getWidth();
         var8 = 240 - var13 >> 1;
         this.c(var18, var8, 0);
      }

      var7 = this.k + 120 - var4;
      var8 = this.k + 120 - var4 + 32;
      var13 = this.j;
      var13 = var3 - var13 >> 1;
      int var53 = this.j - 9 >> 1;
      var13 += var53;
      this.d(var7, var8, var13);
   }

   private void a(byte[] var1) {
      int var2 = this.aH + 1;
      this.aH = var2;
      int var3 = var1.length;
      byte var4 = 1;
      var3 -= var4;
      if (var2 > var3) {
         boolean var5 = false;
         this.aH = 0;
      }
   }

   private final void a(char[] var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      int var9;
      int var11;
      if (var8) {
         this.d = var2;
         var9 = 0;
         Object var10 = null;
         var11 = 0;
         Object var12 = null;
      } else {
         int[] var49 = this.c1010;
         var11 = var49[var3];
         var9 = var11;
      }

      int var13 = 0;
      Graphics var14 = null;
      int var15 = this.n;
      int var16 = var7 / var15;
      this.b1008 = var16;
      if (var8) {
         var15 = 0;
         Object var17 = null;
      } else {
         var15 = var3;
      }

      int var27;
      int var112;
      int var114;
      if (!var8) {
         int[] var18 = this.c1010;
         int var19 = this.a1007;
         int var20 = Math.min(this.a1007, var16) + var3;
         var19 = Math.min(var19, var20);
         int var21 = Math.min(var18[var19], var2);
         var19 = 0;
         Object var22 = null;

         while (true) {
            int[] var23 = this.e;
            int[] var24 = this.e;
            var112 = var24.length;
            int var26 = 1;
            var112 -= var26;
            var20 = var23[var112];
            if (var19 >= var20) {
               break;
            }

            var23 = this.e;
            var112 = var19 << 1;
            var20 = var23[var112];
            if (var9 <= var20) {
               break;
            }

            Graphics var102 = this.a1002;
            var24 = this.e;
            var26 = (var19 << 1) + 1;
            var112 = var24[var26];
            var102.setColor(var112);
            var19++;
         }

         var112 = var15;
         var114 = var9;
         var27 = var21;
         var13 = var11;
         var11 = 0;
         Object var50 = null;
      } else {
         this.c1010[0] = 0;
         int[] var74 = this.e;
         int[] var100 = this.e;
         int var80 = var100.length - 1;
         boolean var85 = false;
         Object var103 = null;
         var74[var80] = 0;
         var112 = var15;
         var114 = var9;
         var27 = var2;
         var13 = var11;
         var11 = 0;
         Object var51 = null;
      }

      while (var114 < var27) {
         var9 = this.n;
         var15 = var112 - var3;
         var9 *= var15;
         int var81 = var5 + var9;
         int var31 = var1[var114];
         int var63 = 10;
         if (var31 == var63) {
            if (var112 >= var3) {
               var11 = var3 + var16;
               if (var112 < var11 && var114 > var13) {
                  Graphics var52 = this.a1002;
                  var63 = var114 - var13;
                  boolean var86 = false;
                  Object var104 = null;
                  var52.drawChars(var1, var13, var63, var4, var81, 0);
               }
            }

            var11 = var112 + 1;
            var31 = var114 + 1;
            if (var8) {
               var14 = this.c1010;
               ((Object[])var14)[var11] = var31;
            }

            var14 = null;
            var112 = var11;
            var114 = var31;
            var11 = 0;
            Object var53 = null;
            var13 = var31;
         } else {
            int var65 = 36;
            if (var31 == var65) {
               var31 = var114 + 1;
               var14 = this.a1002;
               int[] var69 = this.d1011;
               int var94 = var1[var31];
               int var87 = 97;
               var94 -= var87;
               var65 = var69[var94];
               var14.setColor(var65);
               var13 = var31 + 1;
               if (var8) {
                  var69 = this.e;
                  int[] var75 = this.e;
                  var87 = this.e.length - 1;
                  var94 = var75[var87] << 1;
                  var69[var94] = var31;
                  var69 = this.e;
                  var75 = this.e;
                  var87 = this.e.length - 1;
                  var94 = (var75[var87] << 1) + 1;
                  int[] var105 = this.d1011;
                  int var115 = var1[var31];
                  byte var28 = 97;
                  var115 -= var28;
                  var87 = var105[var115];
                  var69[var94] = var87;
                  var69 = this.e;
                  var75 = this.e;
                  var94 = var75.length - 1;
                  var87 = var69[var94] + 1;
                  var69[var94] = var87;
                  var114 = var31;
               } else {
                  var114 = var31;
               }
            } else {
               Font var73 = this.a;
               var31 = var73.charWidth((char)var31);
               var11 += var31;
            }

            if (var11 > var6) {
               if (var112 >= var3) {
                  var11 = var3 + var16;
                  if (var112 < var11) {
                     Graphics var54 = this.a1002;
                     var65 = var114 - var13;
                     boolean var92 = false;
                     Object var106 = null;
                     var54.drawChars(var1, var13, var65, var4, var81, 0);
                  }
               }

               var11 = var112 + 1;
               if (var8) {
                  int[] var39 = this.c1010;
                  var39[var11] = var114;
               }

               boolean var35 = false;
               Object var40 = null;
               var112 = var11;
               var13 = var114;
               var11 = 0;
               Object var55 = null;
            } else {
               var31 = var114 + 1;
               var114 = var31;
            }
         }
      }

      if (var114 > var13) {
         if (var112 >= var3) {
            var11 = var3 + var16;
            if (var112 < var11) {
               Graphics var56 = this.a1002;
               var15 = var114 - var13;
               var9 = this.n;
               int var99 = var112 - var3;
               var9 *= var99;
               int var82 = var5 + var9;
               boolean var93 = false;
               Object var107 = null;
               var56.drawChars(var1, var13, var15, var4, var82, 0);
            }
         }

         var11 = var112 + 1;
         if (var8) {
            int[] var41 = this.c1010;
            var41[var11] = var114;
         }
      } else {
         var11 = var112;
      }

      if (var8) {
         this.a1007 = var11;
      }
   }

   private static void a(int[] var0, int[][] var1, int var2, int var3) {
      for (int var4 = 0; var4 < var2; var4++) {
         int[] var5 = var1[var4];
         int var6 = (var5[var3] << 8) + var4;
         var0[var4] = var6;
      }

      for (int var9 = 0; var9 < var2; var9++) {
         int var12 = 0;
         Object var11 = null;

         while (true) {
            int var7 = var2 - var9;
            int var8 = 1;
            var7 -= var8;
            if (var12 >= var7) {
               break;
            }

            var7 = var0[var12];
            var8 = var12 + 1;
            var8 = var0[var8];
            if (var7 >= var8) {
               var7 = var0[var12];
               var8 = var12 + 1;
               var8 = var0[var8];
               var0[var12] = var8;
               var8 = var12 + 1;
               var0[var8] = var7;
            }

            var12++;
         }
      }

      for (int var10 = 0; var10 < var2; var10++) {
         int var13 = var0[var10] & 0xFF;
         var0[var10] = var13;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final boolean a() {
      byte var1 = 11;
      boolean var2 = true;
      boolean var3 = false;
      RecordStore var4 = null;
      String var5 = "sanGuoTd";
      ByteArrayInputStream var6 = null;
      String var10000 = var5;

      label800: {
         label806: {
            try {
               var165 = RecordStore.openRecordStore(var10000, false);
            } catch (Exception var105) {
               if (var4 == null) {
                  break label800;
               }
               break label806;
            }

            var4 = var165;
            byte var7 = 1;
            RecordStore var166 = var4;

            try {
               var167 = var166.getRecord(var7);
            } catch (Exception var104) {
               if (var4 == null) {
                  break label800;
               }
               break label806;
            }

            byte[] var108 = var167;

            try {
               var168 = new ByteArrayInputStream;
            } catch (Exception var103) {
               if (var4 == null) {
                  break label800;
               }
               break label806;
            }

            var6 = var168;
            ByteArrayInputStream var169 = var6;

            try {
               var169./* $VF: Unable to resugar constructor */<init>(var108);
            } catch (Exception var102) {
               if (var4 == null) {
                  break label800;
               }
               break label806;
            }

            try {
               var170 = new DataInputStream;
            } catch (Exception var101) {
               if (var4 == null) {
                  break label800;
               }
               break label806;
            }

            DataInputStream var109 = var170;
            DataInputStream var171 = var109;

            try {
               var171./* $VF: Unable to resugar constructor */<init>(var6);
            } catch (Exception var100) {
               if (var4 == null) {
                  break label800;
               }
               break label806;
            }

            try {
               var172 = var109.readInt();
            } catch (Exception var99) {
               if (var4 == null) {
                  break label800;
               }
               break label806;
            }

            int var8 = var172;
            a var173 = this;

            try {
               var173.aP = var8;
            } catch (Exception var98) {
               if (var4 == null) {
                  break label800;
               }
               break label806;
            }

            var8 = 0;

            label769:
            while (true) {
               try {
                  var174 = this.aP;
               } catch (Exception var97) {
                  if (var4 == null) {
                     break label800;
                  }
                  break;
               }

               int var9 = var174;
               if (var8 >= var9) {
                  try {
                     var180 = var109.readInt();
                  } catch (Exception var92) {
                     if (var4 == null) {
                        break label800;
                     }
                     break;
                  }

                  var8 = var180;
                  a var181 = this;

                  try {
                     var181.bt = var8;
                  } catch (Exception var91) {
                     if (var4 == null) {
                        break label800;
                     }
                     break;
                  }

                  var8 = 0;

                  while (true) {
                     try {
                        var182 = this.bt;
                     } catch (Exception var90) {
                        if (var4 == null) {
                           break label800;
                        }
                        break label769;
                     }

                     var9 = var182;
                     if (var8 >= var9) {
                        var8 = 0;

                        while (true) {
                           byte var149 = 5;
                           if (var8 >= var149) {
                              var8 = 0;

                              while (true) {
                                 var149 = 10;
                                 if (var8 >= var149) {
                                    for (int var116 = 0; var116 < var1; var116++) {
                                       try {
                                          var194 = this.e1105;
                                       } catch (Exception var79) {
                                          if (var4 == null) {
                                             break label800;
                                          }
                                          break label769;
                                       }

                                       boolean[] var154 = var194;

                                       try {
                                          var195 = var109.readBoolean();
                                       } catch (Exception var78) {
                                          if (var4 == null) {
                                             break label800;
                                          }
                                          break label769;
                                       }

                                       boolean var159 = var195;
                                       boolean[] var196 = var154;
                                       int var259 = var116;

                                       try {
                                          var196[var259] = var159;
                                       } catch (Exception var77) {
                                          if (var4 == null) {
                                             break label800;
                                          }
                                          break label769;
                                       }
                                    }

                                    for (int var117 = 0; var117 < var1; var117++) {
                                       try {
                                          var197 = this.f1106;
                                       } catch (Exception var76) {
                                          if (var4 == null) {
                                             break label800;
                                          }
                                          break label769;
                                       }

                                       boolean[] var155 = var197;

                                       try {
                                          var198 = var109.readBoolean();
                                       } catch (Exception var75) {
                                          if (var4 == null) {
                                             break label800;
                                          }
                                          break label769;
                                       }

                                       boolean var160 = var198;
                                       boolean[] var199 = var155;
                                       int var260 = var117;

                                       try {
                                          var199[var260] = var160;
                                       } catch (Exception var74) {
                                          if (var4 == null) {
                                             break label800;
                                          }
                                          break label769;
                                       }
                                    }

                                    try {
                                       var200 = var109.readInt();
                                    } catch (Exception var73) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var200;
                                    a var201 = this;

                                    try {
                                       var201.aq = var8;
                                    } catch (Exception var72) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var202 = var109.readInt();
                                    } catch (Exception var71) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var202;
                                    a var203 = this;

                                    try {
                                       var203.bj = var8;
                                    } catch (Exception var70) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var204 = var109.readInt();
                                    } catch (Exception var69) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var204;
                                    a var205 = this;

                                    try {
                                       var205.bN = var8;
                                    } catch (Exception var68) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var206 = var109.readInt();
                                    } catch (Exception var67) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var206;
                                    a var207 = this;

                                    try {
                                       var207.bO = var8;
                                    } catch (Exception var66) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var208 = var109.readInt();
                                    } catch (Exception var65) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var208;
                                    a var209 = this;

                                    try {
                                       var209.bP = var8;
                                    } catch (Exception var64) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var210 = var109.readInt();
                                    } catch (Exception var63) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var210;
                                    a var211 = this;

                                    try {
                                       var211.bQ = var8;
                                    } catch (Exception var62) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var212 = var109.readInt();
                                    } catch (Exception var61) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var212;
                                    a var213 = this;

                                    try {
                                       var213.T = var8;
                                    } catch (Exception var60) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var214 = var109.readInt();
                                    } catch (Exception var59) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var214;
                                    a var215 = this;

                                    try {
                                       var215.aO = var8;
                                    } catch (Exception var58) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var216 = var109.readInt();
                                    } catch (Exception var57) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var216;
                                    a var217 = this;

                                    try {
                                       var217.aS = var8;
                                    } catch (Exception var56) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var218 = var109.readInt();
                                    } catch (Exception var55) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var218;
                                    a var219 = this;

                                    try {
                                       var219.X = var8;
                                    } catch (Exception var54) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var220 = var109.readInt();
                                    } catch (Exception var53) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var220;
                                    a var221 = this;

                                    try {
                                       var221.bz = var8;
                                    } catch (Exception var52) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var222 = var109.readInt();
                                    } catch (Exception var51) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var222;
                                    a var223 = this;

                                    try {
                                       var223.by = var8;
                                    } catch (Exception var50) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var224 = var109.readInt();
                                    } catch (Exception var49) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var224;
                                    a var225 = this;

                                    try {
                                       var225.aT = var8;
                                    } catch (Exception var48) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var226 = var109.readInt();
                                    } catch (Exception var47) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var226;
                                    a var227 = this;

                                    try {
                                       var227.aQ = var8;
                                    } catch (Exception var46) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var228 = var109.readInt();
                                    } catch (Exception var45) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var228;
                                    a var229 = this;

                                    try {
                                       var229.ay = var8;
                                    } catch (Exception var44) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var230 = var109.readInt();
                                    } catch (Exception var43) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var8 = var230;
                                    a var231 = this;

                                    try {
                                       var231.az = var8;
                                    } catch (Exception var42) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var232 = var109.readBoolean();
                                    } catch (Exception var41) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    int var134 = var232;
                                    a var233 = this;

                                    try {
                                       var233.p1078 = (boolean)var134;
                                    } catch (Exception var40) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var234 = var109.readInt();
                                    } catch (Exception var39) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var134 = var234;
                                    a var235 = this;

                                    try {
                                       var235.bL = var134;
                                    } catch (Exception var38) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var236 = var109.readInt();
                                    } catch (Exception var37) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var134 = var236;
                                    a var237 = this;

                                    try {
                                       var237.bM = var134;
                                    } catch (Exception var36) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var238 = var109.readInt();
                                    } catch (Exception var35) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var134 = var238;
                                    a var239 = this;

                                    try {
                                       var239.ac = var134;
                                    } catch (Exception var34) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var240 = var109.readInt();
                                    } catch (Exception var33) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var134 = var240;
                                    a var241 = this;

                                    try {
                                       var241.aV = var134;
                                    } catch (Exception var32) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var242 = var109.readInt();
                                    } catch (Exception var31) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var134 = var242;
                                    a var243 = this;

                                    try {
                                       var243.aW = var134;
                                    } catch (Exception var30) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var244 = var109.readInt();
                                    } catch (Exception var29) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var134 = var244;
                                    a var245 = this;

                                    try {
                                       var245.aX = var134;
                                    } catch (Exception var28) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var246 = var109.readInt();
                                    } catch (Exception var27) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var134 = var246;
                                    a var247 = this;

                                    try {
                                       var247.aY = var134;
                                    } catch (Exception var26) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var248 = var109.readInt();
                                    } catch (Exception var25) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var134 = var248;
                                    a var249 = this;

                                    try {
                                       var249.aZ = var134;
                                    } catch (Exception var24) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var250 = var109.readInt();
                                    } catch (Exception var23) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var134 = var250;
                                    a var251 = this;

                                    try {
                                       var251.ba = var134;
                                    } catch (Exception var22) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var252 = var109.readInt();
                                    } catch (Exception var21) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    var134 = var252;
                                    a var253 = this;

                                    try {
                                       var253.bb = var134;
                                    } catch (Exception var20) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var254 = var109.readBoolean();
                                    } catch (Exception var19) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    boolean var145 = var254;
                                    a var255 = this;

                                    try {
                                       var255.z1169 = var145;
                                    } catch (Exception var18) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var109.close();
                                    } catch (Exception var17) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var6.close();
                                    } catch (Exception var16) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }

                                    try {
                                       var4.closeRecordStore();
                                       return var2;
                                    } catch (Exception var15) {
                                       if (var4 == null) {
                                          break label800;
                                       }
                                       break label769;
                                    }
                                 }

                                 try {
                                    var191 = this.b1059;
                                 } catch (Exception var82) {
                                    if (var4 == null) {
                                       break label800;
                                    }
                                    break label769;
                                 }

                                 boolean[] var153 = var191;

                                 try {
                                    var192 = var109.readBoolean();
                                 } catch (Exception var81) {
                                    if (var4 == null) {
                                       break label800;
                                    }
                                    break label769;
                                 }

                                 boolean var158 = var192;
                                 boolean[] var193 = var153;
                                 int var258 = var8;

                                 try {
                                    var193[var258] = var158;
                                 } catch (Exception var80) {
                                    if (var4 == null) {
                                       break label800;
                                    }
                                    break label769;
                                 }

                                 var8++;
                              }
                           }

                           try {
                              var188 = this.a1056;
                           } catch (Exception var85) {
                              if (var4 == null) {
                                 break label800;
                              }
                              break label769;
                           }

                           boolean[] var152 = var188;

                           try {
                              var189 = var109.readBoolean();
                           } catch (Exception var84) {
                              if (var4 == null) {
                                 break label800;
                              }
                              break label769;
                           }

                           boolean var157 = var189;
                           boolean[] var190 = var152;
                           int var257 = var8;

                           try {
                              var190[var257] = var157;
                           } catch (Exception var83) {
                              if (var4 == null) {
                                 break label800;
                              }
                              break label769;
                           }

                           var8++;
                        }
                     }

                     var9 = 0;
                     Object var151 = null;

                     while (true) {
                        byte var156 = 18;
                        if (var9 >= var156) {
                           var8++;
                           break;
                        }

                        try {
                           var183 = this.c1107;
                        } catch (Exception var89) {
                           if (var4 == null) {
                              break label800;
                           }
                           break label769;
                        }

                        int[][] var162 = var183;
                        int[][] var184 = var162;

                        try {
                           var185 = var184[var8];
                        } catch (Exception var88) {
                           if (var4 == null) {
                              break label800;
                           }
                           break label769;
                        }

                        int[] var163 = var185;

                        try {
                           var186 = var109.readInt();
                        } catch (Exception var87) {
                           if (var4 == null) {
                              break label800;
                           }
                           break label769;
                        }

                        int var164 = var186;
                        int[] var187 = var163;
                        int var256 = var9;

                        try {
                           var187[var256] = var164;
                        } catch (Exception var86) {
                           if (var4 == null) {
                              break label800;
                           }
                           break label769;
                        }

                        var9++;
                     }
                  }
               }

               var9 = 0;
               Object var10 = null;

               while (true) {
                  byte var11 = 28;
                  if (var9 >= var11) {
                     var8++;
                     break;
                  }

                  try {
                     var175 = this.b1066;
                  } catch (Exception var96) {
                     if (var4 == null) {
                        break label800;
                     }
                     break label769;
                  }

                  int[][] var12 = var175;
                  int[][] var176 = var12;

                  try {
                     var177 = var176[var8];
                  } catch (Exception var95) {
                     if (var4 == null) {
                        break label800;
                     }
                     break label769;
                  }

                  int[] var161 = var177;

                  try {
                     var178 = var109.readInt();
                  } catch (Exception var94) {
                     if (var4 == null) {
                        break label800;
                     }
                     break label769;
                  }

                  int var13 = var178;
                  int[] var179 = var161;
                  int var10001 = var9;

                  try {
                     var179[var10001] = var13;
                  } catch (Exception var93) {
                     if (var4 == null) {
                        break label800;
                     }
                     break label769;
                  }

                  var9++;
               }
            }
         }

         try {
            var4.closeRecordStore();
         } catch (Exception var14) {
         }
      }

      var3 = false;
      Object var107 = null;
      return var3;
   }

   private static boolean a(int var0) {
      int var1 = var0 & 1;
      boolean var2;
      if (var1 == 0) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private boolean a(int var1, int var2) {
      byte var3 = 16;
      byte var4 = 1;
      byte var5 = -1;
      int var6 = this.a(var1, var2);
      int[] var7 = this.E1163;
      int var8 = Math.abs(var7[var6]);
      int var9 = 12;
      byte var15;
      if (var8 >= var9) {
         var15 = this.d(var6);
         this.ay = var15;
         var15 = this.ay;
         if (var15 == var5) {
            var15 = 0;
            Object var10 = null;
         } else {
            this.az = var5;
            var15 = var4;
         }
      } else {
         var7 = this.E1163;
         int var16 = var7[var6];
         int var23 = 8;
         if (var16 < var23) {
            int var11 = 0;

            while (true) {
               var16 = this.aP;
               if (var11 >= var16) {
                  this.ay = var5;
                  this.az = var5;
                  var15 = 0;
                  Object var27 = null;
                  break;
               }

               int[] var26 = this.b1066[var11];
               var16 = var26[0];
               var7 = this.b1066[var11];
               var23 = var7[var4];
               var9 = this.bN;
               int var12 = this.bO;
               int var19 = a(var16, var23, var9, var12, var3, var3);
               if (var19) {
                  this.az = var11;
                  var15 = var4;
                  break;
               }

               var19 = var11 + 1;
               var11 = var19;
            }
         } else {
            this.ay = var5;
            this.az = var5;
            var15 = 0;
            Object var28 = null;
         }
      }

      return (boolean)var15;
   }

   private boolean a(int var1, int var2, int var3) {
      byte var4 = 1;
      int[] var5 = this.m1129;
      int var6 = -1;
      var5[var3] = var6;
      int var7 = this.x1126;
      if (var7) {
         var7 = 0;
         var5 = null;

         while (true) {
            byte[] var8 = this.o1098;
            int var9 = this.bw;
            var6 = var8[var9];
            if (var7 >= var6) {
               var5 = this.m1129;
               var5[var3] = var3;
               var7 = var4;
               break;
            }

            var8 = this.x1128[var3];
            var6 = var8[0];
            if (var6 == var4) {
               var6 = var7 << 4;
            } else {
               var8 = this.x1128[var3];
               byte var19 = var8[0];
               if (var19 < 0) {
                  var8 = this.x1128[var3];
                  var6 = var8[0];
               } else {
                  var8 = this.o1098;
                  var9 = this.bw;
                  var6 = var8[var9] << 4;
               }
            }

            var6 += var1;
            byte[] var10 = this.x1128[var3];
            int var29 = var10[var4];
            if (var29 == var4) {
               var29 = var7 << 4;
            } else {
               var10 = this.x1128[var3];
               byte var31 = var10[var4];
               if (var31 < 0) {
                  var10 = this.x1128[var3];
                  var29 = var10[var4];
               } else {
                  var10 = this.o1098;
                  int var11 = this.bw;
                  var29 = (var10[var11] << 4) + 16;
               }
            }

            var29 += var2;
            boolean var21 = this.h(var6, var29);
            if (!var21) {
               var7 = (byte)0;
               var5 = null;
               break;
            }

            var7++;
         }
      } else {
         var7 = (byte)0;
         var5 = null;
      }

      return (boolean)var7;
   }

   private boolean a(int var1, int var2, int var3, int var4, int var5) {
      int var6 = b(var1, var2, var3, var4);
      int var7 = var5 * var5;
      boolean var8;
      if (var6 < var7) {
         var8 = true;
      } else {
         var8 = false;
      }

      return var8;
   }

   private static boolean a(int var0, int var1, int var2, int var3, int var4, int var5) {
      if (var0 >= var2) {
         int var6 = var2 + var4;
         if (var0 <= var6 && var1 >= var3) {
            var6 = var3 + var5;
            if (var1 <= var6) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean a(int var1, int var2, int var3, boolean var4) {
      byte var20;
      int var22;
      byte var26;
      byte var27;
      label33: {
         var20 = 3;
         byte var6 = 3;
         float var7 = 4.0E-45F;
         boolean var8 = false;
         boolean var9 = false;
         if (var4) {
            switch (var3) {
               case 0:
               case 2:
                  boolean var29 = false;
                  float var31 = 0.0F;
                  var27 = 2;
                  var26 = var6;
                  var22 = 1;
                  var7 = Float.MIN_VALUE;
                  var20 = 0;
                  break label33;
               case 1:
               case 3:
                  byte var28 = 1;
                  float var30 = Float.MIN_VALUE;
                  var22 = 0;
                  var7 = 0.0F;
                  var26 = 2;
                  var27 = var20;
                  var20 = var28;
                  break label33;
            }
         }

         boolean var10 = false;
         float var11 = 0.0F;
         var27 = var20;
         var20 = 0;
         byte var12 = var6;
         var22 = 0;
         var7 = 0.0F;
         var26 = var12;
      }

      while (var22 < var27) {
         for (int var13 = var20; var13 < var26; var13++) {
            int var14 = var22 << 4;
            int var15 = this.m1084[var3][0];
            var14 = var14 * var15 + var1;
            byte[] var16 = this.m1084[var3];
            var15 = var16[2];
            var14 += var15;
            var15 = var13 << 4;
            byte var17 = this.m1084[var3][1];
            var15 = var15 * var17 + var2;
            byte[] var18 = this.m1084[var3];
            byte var19 = 3;
            var17 = var18[var19];
            var15 += var17;
            boolean var34 = this.d(var14, var15);
            if (!var34) {
               return true;
            }
         }

         var22++;
      }

      return false;
   }

   private void aa() {
      short var1 = 240;
      byte var2 = 8;
      byte var3 = 1;
      int var4 = this.br;
      switch (var4) {
         case 0:
            short[][] var5 = this.b1069;
            int var28 = this.aN;
            var4 = var5[var28][0] - var2;
            this.bN = var4;
            var5 = this.b1069;
            var28 = this.aN;
            short[] var23 = var5[var28];
            var4 = var23[var3] - var2;
            this.bO = var4;
            this.y1155 = (boolean)var3;
            this.br = var3;
            break;
         case 1:
            var4 = this.bn - 32;
            this.bn = var4;
            int var6 = this.bl;
            if (var4 < var6) {
               var4 = this.bl;
               this.bn = var4;
               var4 = this.bl << 1;
               var4 = var1 - var4;
               this.bp = var4;
            } else {
               var4 = this.bp + 64;
               this.bp = var4;
            }

            var4 = this.bo - 4;
            this.bo = var4;
            var6 = this.bm;
            if (var4 < var6) {
               var4 = this.bm;
               this.bo = var4;
               var4 = this.bk;
               this.bq = var4;
            } else {
               var4 = this.bq + 8;
               this.bq = var4;
            }

            var4 = this.bp;
            var6 = this.bl << 1;
            var6 = var1 - var6;
            if (var4 == var6) {
               var4 = this.bq;
               var6 = this.bk;
               if (var4 == var6) {
                  byte var19 = 2;
                  this.br = var19;
               }
            }
            break;
         case 2:
            var4 = this.h1047;
            switch (var4) {
               case -6:
               case -5:
               case 53:
                  this.a();
            }
      }
   }

   private void ab() {
      this.br = 0;
      int var1 = this.j * 2 + 10;
      this.bk = var1;
      this.bl = 4;
      int var2 = this.bk;
      var1 = 280 - var2;
      this.bm = var1;
      this.bn = 120;
      var1 = this.bm;
      var2 = this.bk >> 1;
      var1 += var2;
      this.bo = var1;
      this.bp = 0;
      this.bq = 0;
      this.a(22);
   }

   private void ac() {
      short var1 = 240;
      int var2 = 2;
      this.a1002.setClip(0, 0, var1, 320);
      this.a1002.setColor(16580557);
      Graphics var3 = this.a1002;
      int var4 = this.bn;
      int var5 = this.bo;
      int var6 = this.bp;
      int var7 = this.bq;
      var3.fillRect(var4, var5, var6, var7);
      var3 = this.a1002;
      var4 = this.bn - 1;
      var5 = this.bo + 1;
      var6 = this.bp + 2;
      var7 = this.bq - var2;
      var3.fillRect(var4, var5, var6, var7);
      int var8 = this.br;
      if (var8 == var2) {
         var3 = this.a1002;
         var4 = this.bl + 15;
         var5 = this.bm;
         var6 = this.bk;
         var5 += var6;
         var6 = this.bl + 15 + 8;
         var7 = this.bm;
         var2 = this.bk;
         var7 += var2;
         var2 = this.bl + 15 + 8;
         int var9 = this.bm;
         int var10 = this.bk;
         var9 = var9 + var10 + 8;
         var3.fillTriangle(var4, var5, var6, var7, var2, var9);
         var3 = this.a1002;
         var4 = 5465994;
         var3.setColor(var4);
         StringBuffer var18 = new StringBuffer();
         String[] var11 = this.b1015;
         var5 = this.X * 11 + 28;
         String var40 = var11[var5];
         StringBuffer var19 = var18.append(var40).append("：");
         var11 = this.b1015;
         var5 = this.bs + 171;
         String var42 = var11[var5];
         String var43 = var19.append(var42).toString();
         var6 = this.bl + 10;
         var7 = this.bm + 5;
         var8 = (this.bl + 10) * 2;
         var2 = var1 - var8;
         var9 = this.bk;
         boolean var28 = false;
         this.a(var43, 0, var6, var7, var2, var9);
      }
   }

   private void ad() {
      short var1 = 240;
      int var2 = this.br;
      switch (var2) {
         case 1:
            var2 = this.bn - 32;
            this.bn = var2;
            int var20 = this.bl;
            if (var2 < var20) {
               var2 = this.bl;
               this.bn = var2;
               var2 = this.bl << 1;
               var2 = var1 - var2;
               this.bp = var2;
            } else {
               var2 = this.bp + 64;
               this.bp = var2;
            }

            var2 = this.bo - 4;
            this.bo = var2;
            var20 = this.bm;
            if (var2 < var20) {
               var2 = this.bm;
               this.bo = var2;
               var2 = this.bk;
               this.bq = var2;
            } else {
               var2 = this.bq + 8;
               this.bq = var2;
            }

            var2 = this.bp;
            var20 = this.bl << 1;
            var20 = var1 - var20;
            if (var2 == var20) {
               var2 = this.bq;
               var20 = this.bk;
               if (var2 == var20) {
                  byte var19 = 2;
                  this.br = var19;
               }
            }
            break;
         case 2:
            var2 = this.h1047;
            switch (var2) {
               case -6:
               case -5:
               case 53:
                  var2 = this.bs + 1;
                  this.bs = var2;
                  var2 = this.bs;
                  byte var3 = 3;
                  if (var2 > var3) {
                     boolean var7 = false;
                     this.v1097 = false;
                     this.a();
                  }
            }
      }
   }

   private void ae() {
      this.br = 1;
      int var1 = this.j * 3 + 10;
      this.bk = var1;
      this.bl = 4;
      int var2 = this.bk;
      var1 = 280 - var2;
      this.bm = var1;
      this.bn = 120;
      var1 = this.bm;
      var2 = this.bk;
      var1 = var1 + var2 >> 1;
      this.bo = var1;
      this.bp = 0;
      this.bq = 0;
      this.bs = 0;
      this.a(23);
   }

   private void af() {
      int var1 = this.w1111;
      if (var1) {
         var1 = this.bu;
         Image[] var2 = this.a1013[3];
         byte var3 = 20;
         Image var7 = var2[var3];
         int var4 = var7.getWidth() / 27;
         if (var1 < var4) {
            var1 = this.bu + 1;
            this.bu = var1;
         } else {
            this.bu = 0;
            this.w1111 = false;
         }
      }
   }

   private void ag() {
      int[] var1 = this.p1154;
      int[][] var2 = this.c1107;
      int var3 = this.bt;
      int var4 = 1;
      a(var1, var2, var3, var4);
      int var5 = 0;
      Graphics var23 = null;
      int var6 = 0;

      while (true) {
         var5 = this.bt;
         if (var6 >= var5) {
            int var122 = 0;
            var23 = null;
            int var202 = 0;

            while (true) {
               var122 = this.bt;
               if (var202 >= var122) {
                  return;
               }

               var23 = this.c1107;
               int[] var44 = this.p1154;
               int var168 = var44[var202];
               int[] var22 = (int[])((Object[])var23)[var168];
               var23 = this.o1098;
               var168 = var22[2];
               int var208 = ((Object[])var23)[var168] << 3;
               var23 = null;
               var122 = var22[0];
               var168 = this.bP;
               var122 -= var168;
               var168 = var22[1];
               var3 = this.bQ;
               var168 -= var3;
               int var73 = -48;
               var4 = (byte)-48;
               int var191 = 336;
               short var200 = 320;
               int var126 = a(var122, var168, var73, var4, var191, var200);
               if (var126) {
                  var126 = var22[4];
                  byte var173 = 1;
                  if (var126 == var173) {
                     var126 = var22[10];
                     var173 = 3;
                     if (var126 != var173) {
                        var23 = this.p1154;
                        var126 = (int)((Object[])var23)[var202];
                        this.y(var126);
                     }
                  }

                  var126 = var22[4];
                  var173 = 6;
                  if (var126 == var173) {
                     var126 = var22[14];
                     var173 = 10;
                     if (var126 != var173) {
                        var126 = var22[2];
                        switch (var126) {
                           case 0:
                           case 4:
                              var23 = this.a1013[29];
                              boolean var177 = false;
                              Image var45 = (Image)((Object[])var23)[0];
                              var126 = var22[0];
                              var73 = this.bP;
                              var73 = var126 - var73 + var208 - 10;
                              var126 = var22[1] + var208;
                              var4 = this.bQ;
                              var4 = var126 - var4 - 20;
                              var126 = var22[14];
                              var191 = var126 * 18;
                              boolean var201 = false;
                              byte var207 = 18;
                              byte var209 = 24;
                              boolean var137 = false;
                              Object var178 = null;
                              this.a(var45, var73, var4, var191, 0, var207, var209, 0, 0);
                        }
                     }
                  }
               }

               var126 = var202 + 1;
               var202 = var126;
            }
         }

         var23 = this.c1107;
         int[] var40 = this.p1154;
         int var7 = var40[var6];
         int[] var8 = (int[])((Object[])var23)[var7];
         var23 = null;
         var5 = var8[0];
         var7 = this.bP;
         var5 -= var7;
         var7 = var8[1];
         var3 = this.bQ;
         var7 -= var3;
         int var47 = -48;
         int var76 = -48;
         int var9 = 336;
         int var10 = 320;
         int var101 = a(var5, var7, var47, var76, var9, var10);
         if (var101) {
            var23 = this.o1098;
            var7 = var8[2];
            int var11 = ((Object[])var23)[var7] << 3;
            var101 = var8[2];
            int var142 = 10;
            if (var101 == var142) {
               var101 = var8[5];
               if (var101 == 0) {
                  var142 = var8[5];
                  var47 = var8[0];
                  var76 = var8[1];
                  var9 = var8[15];
                  var10 = var8[13];
                  byte var104 = 10;
                  int var12 = var8[var104];
                  this.c(var142, var47, var76, var9, var10, var12);
               }
            }

            var101 = var8[4];
            int var144 = 5;
            if (var101 != var144) {
               var144 = var8[2];
               var47 = var8[3];
               var101 = var8[0] + var11;
               var76 = this.bP;
               var76 = var101 - var76;
               var101 = var8[1] + var11;
               var9 = this.bQ;
               var9 = var101 - var9;
               var10 = var8[7];
               int var203 = var8[5];
               int var13 = var8[4];
               this.a(var144, var47, var76, var9, var10, var203, var13);
               var101 = var8[17];
               int var146 = 1;
               if (var101 == var146) {
                  var23 = null;
                  var101 = var8[0] + var11 - 10;
                  var146 = this.bP;
                  var101 -= var146;
                  var146 = var8[1];
                  var47 = this.bQ;
                  var146 = var146 - var47 + 13;
                  this.o(var101, var146);
               }

               int var111 = g(var8[3]);
               if (var111) {
                  long var14 = this.a1019;
                  var111 = (int)var14 & 31;
                  int var150 = 4;
                  if (var111 < var150) {
                     this.a1002.setClip(0, 0, 240, 320);
                     this.a1002.setColor(16777215);
                     var23 = this.a1002;
                     var150 = var8[0] + var11;
                     var47 = this.bP;
                     var150 -= var47;
                     var47 = var8[1] + var11;
                     var76 = ((int)this.a1019 & 31) << 2;
                     var47 -= var76;
                     var76 = this.bQ;
                     var47 -= var76;
                     var76 = ((int)this.a1019 & 31) << 2;
                     var9 = ((int)this.a1019 & 31) << 2;
                     var23.fillArc(var150, var47, var76, var9, 0, 360);
                     this.a1002.setColor(16761600);
                     var23 = this.a1002;
                     Object var43 = null;
                     var150 = var8[0] + var11;
                     var47 = this.bP;
                     var150 -= var47;
                     var47 = var8[1] + var11;
                     var76 = ((int)this.a1019 & 31) << 2;
                     var47 -= var76;
                     var76 = this.bQ;
                     var47 -= var76;
                     long var16 = this.a1019;
                     var76 = ((int)var16 & 31) << 2;
                     long var212 = this.a1019;
                     var9 = ((int)var212 & 31) << 2;
                     boolean var198 = false;
                     short var205 = 360;
                     var23.drawArc(var150, var47, var76, var9, 0, var205);
                  } else {
                     label83: {
                        var14 = this.a1019;
                        var111 = (int)var14 & 31;
                        int var151 = 27;
                        if (var111 > var151) {
                           var14 = this.a1019;
                           var111 = (int)var14 & 31;
                           var151 = (byte)32;
                           if (var111 < var151) {
                              this.a1002.setClip(0, 0, 240, 320);
                              this.a1002.setColor(16777215);
                              var23 = this.a1002;
                              var151 = var8[0] + var11;
                              var47 = this.bP;
                              var151 -= var47;
                              var47 = var8[1] + var11;
                              var9 = (int)this.a1019 & 31;
                              var76 = 31 - var9 << 2;
                              var47 -= var76;
                              var76 = this.bQ;
                              var47 -= var76;
                              var9 = (int)this.a1019 & 31;
                              var76 = 31 - var9 << 2;
                              var10 = (int)this.a1019 & 31;
                              var9 = 31 - var10 << 2;
                              var23.fillArc(var151, var47, var76, var9, 0, 360);
                              this.a1002.setColor(16761600);
                              var23 = this.a1002;
                              Object var42 = null;
                              var151 = var8[0] + var11;
                              var47 = this.bP;
                              var151 -= var47;
                              var47 = var8[1] + var11;
                              var9 = (int)this.a1019 & 31;
                              var76 = 31 - var9 << 2;
                              var47 -= var76;
                              var76 = this.bQ;
                              var47 -= var76;
                              long var18 = this.a1019;
                              var9 = (int)var18 & 31;
                              var76 = 31 - var9 << 2;
                              long var20 = this.a1019;
                              var10 = (int)var20 & 31;
                              var9 = 31 - var10 << 2;
                              boolean var197 = false;
                              short var204 = 360;
                              var23.drawArc(var151, var47, var76, var9, 0, var204);
                              break label83;
                           }
                        }

                        byte[][] var28 = this.y1130;
                        var151 = this.X;
                        byte[] var29 = var28[var151];
                        var151 = var8[2];
                        byte var115 = var29[var151];
                        Object var41 = null;
                        var151 = var8[0] + var11;
                        var47 = this.bP;
                        var151 -= var47;
                        var47 = var8[1] + var11 - 16;
                        var76 = this.bQ;
                        var47 -= var76;
                        this.q(var115, var151, var47);
                     }
                  }
               }
            }

            var101 = var8[4];
            switch (var101) {
               case 3:
               case 4:
               case 5:
                  var101 = var8[2];
                  var144 = var8[4];
                  var47 = var8[0];
                  var76 = var8[1];
                  this.d(var101, var144, var47, var76);
               default:
                  var101 = var8[2];
                  int var166 = 10;
                  if (var101 == var166) {
                     var101 = var8[5];
                     if (var101 != 0) {
                        var166 = var8[5];
                        var47 = var8[0];
                        var76 = var8[1];
                        var9 = var8[15];
                        var10 = var8[13];
                        byte var120 = 10;
                        int var206 = var8[var120];
                        this.c(var166, var47, var76, var9, var10, var206);
                     }
                  }
            }
         }

         var101 = var6 + 1;
         var6 = var101;
      }
   }

   private void ah() {
      byte var1 = 1;
      byte var2 = 6;
      byte var3 = 4;
      byte var4 = 2;
      int var5 = 0;

      while (true) {
         int var6 = this.bt;
         if (var5 >= var6) {
            this.af();
            return;
         }

         int[] var7 = this.c1107[var5];
         int var8 = var7[7];
         int var9 = var7[var4];
         var8 = this.c(var5, var8, var9);
         var7[7] = var8;
         int var10 = var7[var4];
         var8 = var7[3];
         int var24 = this.q(var10, var8);
         if (var24) {
            var24 = var7[0];
            byte[] var11 = this.o1098;
            var9 = var7[var4];
            var8 = var11[var9] << 3;
            var24 += var8;
            var8 = var7[var1];
            byte[] var12 = this.o1098;
            int var13 = var7[var4];
            var9 = var12[var13] << 3;
            var8 += var9;
            this.n(var24, var8);
         }

         var24 = var7[var3];
         switch (var24) {
            case 0:
               var24 = this.aP;
               label30:
               if (var24 <= 0) {
                  var24 = var7[var4];
                  if (var24 != 0) {
                     var24 = var7[var4];
                     if (var24 != var3) {
                        break label30;
                     }
                  }

                  var7[var3] = var2;
                  byte var33 = 14;
                  byte var21 = -1;
                  var7[var33] = var21;
               }

               this.e(var5);
               break;
            case 1:
               byte var29 = 8;
               var6 = var7[var29];
               this.l(var5, var6);
               break;
            case 2:
               var24 = var7[var2] - var1;
               var7[var2] = var24;
               if (var24 < 0) {
                  var7[var2] = 0;
                  var7[var3] = 0;
               }
               break;
            case 3:
            case 4:
            case 5:
               var6 = var7[var3];
               this.j(var5, var6);
               break;
            case 6:
               this.e(var5);
         }

         var5++;
      }
   }

   private void ai() {
      int var1 = 0;
      Image var2 = null;
      int var3 = 0;

      while (true) {
         var1 = this.bt;
         if (var3 >= var1) {
            return;
         }

         var2 = this.c1107;
         int[] var4 = this.p1154;
         int var5 = var4[var3];
         int[] var6 = (int[])((Object[])var2)[var5];
         var2 = null;
         var1 = var6[0];
         var5 = this.bP;
         var1 -= var5;
         var5 = var6[1];
         int var7 = this.bQ;
         var5 -= var7;
         int var50 = -48;
         int var8 = -48;
         int var9 = 336;
         int var10 = 320;
         int var18 = a(var1, var5, var50, var8, var9, var10);
         if (var18) {
            var18 = var6[4];
            byte var41 = 1;
            if (var18 == var41) {
               var18 = var6[10];
               var41 = 3;
               if (var18 != var41) {
                  var18 = var6[2];
                  switch (var18) {
                     case 8:
                        var2 = this.a1013[29];
                        var41 = 31;
                        Image var37 = (Image)((Object[])var2)[var41];
                        var50 = var6[5];
                        var8 = var6[0];
                        var9 = var6[1];
                        var10 = var6[13];
                        int var68 = var6[11];
                        int var69 = var6[10];
                        int var70 = var6[2];
                        byte var23 = 3;
                        int var71 = var6[var23];
                        this.b(var37, var50, var8, var9, var10, var68, var69, var70, var71);
                        break;
                     case 9:
                        var2 = this.a1013[29];
                        var41 = 35;
                        Image var36 = (Image)((Object[])var2)[var41];
                        var50 = var6[5];
                        var8 = var6[0];
                        var9 = var6[1];
                        var10 = var6[13];
                        int var11 = var6[11];
                        int var12 = var6[10];
                        int var13 = var6[2];
                        byte var22 = 3;
                        int var14 = var6[var22];
                        this.b(var36, var50, var8, var9, var10, var11, var12, var13, var14);
                  }
               }
            }
         }

         var2 = null;
         var18 = var6[0];
         var5 = this.bP;
         var18 -= var5;
         var5 = var6[1];
         var50 = this.bQ;
         var5 -= var50;
         int var54 = -96;
         int var59 = -102;
         short var64 = 358;
         short var67 = 438;
         int var26 = a(var18, var5, var54, var59, var64, var67);
         if (var26) {
            var26 = var6[2];
            switch (var26) {
               case 2:
                  var2 = this.a1013[29][40];
                  var5 = var6[5];
                  var54 = var6[0];
                  var59 = var6[1];
                  this.d(var2, var5, var54, var59);
                  break;
               case 10:
                  var2 = this.a1013[29][43];
                  var5 = var6[5];
                  var54 = var6[0];
                  var59 = var6[1];
                  this.e(var2, var5, var54, var59);
            }
         }

         var26 = var3 + 1;
         var3 = var26;
      }
   }

   private void aj() {
      byte var1 = 11;
      byte var2 = 10;
      boolean var3 = true;
      int var4 = -1;
      int var5 = this.T;
      if (var5 == 0) {
         short var11 = 300;
         this.bz = var11;
      } else {
         short var12 = 250;
         this.bz = var12;
      }

      this.z1169 = false;
      this.by = var2;
      this.aT = 0;
      this.aX = 0;
      this.aP = 0;
      this.aQ = 0;
      this.aS = 0;
      this.bt = 0;
      this.ay = var4;
      this.az = var4;
      this.p1078 = false;
      this.bF = 0;
      this.aw = 0;
      this.bu = 0;
      var5 = 0;

      while (true) {
         var4 = (byte)5;
         if (var5 >= var4) {
            for (int var14 = 0; var14 < var2; var14++) {
               boolean[] var17 = this.b1059;
               boolean[] var7 = this.c1061;
               boolean var8 = var7[var14];
               if (!var8) {
                  var8 = false;
                  var7 = null;
               } else {
                  var8 = var3;
               }

               var17[var14] = var8;
            }

            for (int var15 = 0; var15 < var1; var15++) {
               boolean[] var18 = this.e1105;
               boolean var23;
               if (var15 == 0) {
                  var23 = var3;
               } else {
                  var23 = false;
                  Object var21 = null;
               }

               var18[var15] = var23;
               var18 = this.f1106;
               var18[var15] = false;
            }

            this.c(29);

            for (int var16 = 0; var16 < var1; var16++) {
               var4 = var16 + 18;
               this.c(var4);
            }

            return;
         }

         boolean[] var6 = this.a1056;
         var6[var5] = false;
         var5++;
      }
   }

   private void ak() {
      short var1 = 240;
      int var2 = 304;
      int var3 = 256;
      byte var4 = 1;
      Image var5 = this.a1004;
      if (var5 != null) {
         int var6 = this.y1155;
         if (var6) {
            this.y1155 = false;
            var6 = this.bQ >> 4;
            int var126 = this.bP >> 4;
            int var145 = var126 << 4;
            this.bA = var145;
            var145 = var6 << 4;
            this.bC = var145;
            var145 = var6;

            while (true) {
               var3 = var6 + 19;
               if (var145 >= var3) {
                  break;
               }

               this.w(var145, var126, 0);
               var145++;
            }
         } else {
            var6 = this.bP;
            int var7 = this.bA;
            if (var6 < var7) {
               var6 = this.bA;
               var7 = this.bP;
               var6 = var6 - var7 >> 4;
               var7 = this.bA;
               int var8 = this.bP;
               var7 = var7 - var8 & 15;
               byte var80;
               if (var7 == 0) {
                  var80 = 0;
                  Object var9 = null;
               } else {
                  var80 = var4;
               }

               var6 += var80;
               var80 = this.bB;
               var8 = var6 << 4;
               var80 -= var8;
               this.bB = var80;
               var80 = this.bA;
               var8 = var6 << 4;
               var80 -= var8;
               this.bA = var80;
               var80 = this.bB;
               if (var80 < 0) {
                  var80 = this.bB + 256;
                  this.bB = var80;
               }

               var80 = this.bA;
               if (var80 < 0) {
                  this.bA = 0;
               }

               var80 = 0;
               Object var164 = null;

               while (var80 < var6) {
                  var8 = this.bC >> 4;
                  var3 = (this.bA >> 4) + var80;
                  this.w(var8, var3, var4);
                  var80++;
               }
            } else {
               var6 = this.bP + 240;
               var7 = this.bA + 256;
               if (var6 > var7) {
                  var6 = this.bP + 240;
                  var7 = this.bA;
                  var6 = var6 - var7 - var3;
                  var7 = var6 >> 4;
                  var6 &= 15;
                  byte var62;
                  if (var6 == 0) {
                     var62 = 0;
                     var5 = null;
                  } else {
                     var62 = var4;
                  }

                  var62 += var7;
                  var7 = this.bA;
                  int var133 = var62 << 4;
                  var7 += var133;
                  this.bA = var7;
                  var7 = this.bB;
                  var133 = var62 << 4;
                  var7 += var133;
                  this.bB = var7;
                  var7 = this.bB;
                  if (var7 >= var3) {
                     var7 = this.bB - var3;
                     this.bB = var7;
                  }

                  var7 = this.bA + 256;
                  var133 = this.bI;
                  if (var7 > var133) {
                     var7 = this.bI - var3;
                     this.bA = var7;
                  }

                  var7 = 0;
                  Object var165 = null;

                  while (var7 < var62) {
                     var133 = this.bC >> 4;
                     var3 = (this.bA >> 4) + 16 - var4 - var7;
                     this.w(var133, var3, var4);
                     var7++;
                  }
               }
            }

            var6 = this.bQ;
            var7 = this.bC;
            if (var6 < var7) {
               var6 = this.bC;
               var7 = this.bQ;
               var6 = var6 - var7 >> 4;
               var7 = this.bC;
               int var141 = this.bQ;
               var7 = var7 - var141 & 15;
               byte var117;
               if (var7 == 0) {
                  var117 = 0;
                  Object var167 = null;
               } else {
                  var117 = var4;
               }

               var6 += var117;
               var117 = this.bD;
               var141 = var6 << 4;
               var117 -= var141;
               this.bD = var117;
               var117 = this.bC;
               var141 = var6 << 4;
               var117 -= var141;
               this.bC = var117;
               var117 = this.bD;
               if (var117 < 0) {
                  var117 = this.bD + 304;
                  this.bD = var117;
               }

               var117 = this.bC;
               if (var117 < 0) {
                  this.bC = 0;
               }

               var117 = 0;
               Object var168 = null;

               while (var117 < var6) {
                  var141 = (this.bC >> 4) + var117;
                  var3 = this.bA >> 4;
                  this.w(var141, var3, 0);
                  var117++;
               }
            } else {
               var6 = this.bQ + 276;
               var7 = this.bC + 304;
               if (var6 > var7) {
                  var6 = this.bQ + 276;
                  var7 = this.bC;
                  var6 = var6 - var7 - var2;
                  var7 = var6 >> 4;
                  var6 &= 15;
                  byte var69;
                  if (var6 == 0) {
                     var69 = 0;
                     var5 = null;
                  } else {
                     var69 = var4;
                  }

                  var69 += var7;
                  var7 = this.bC;
                  int var137 = var69 << 4;
                  var7 += var137;
                  this.bC = var7;
                  var7 = this.bD;
                  var137 = var69 << 4;
                  var7 += var137;
                  this.bD = var7;
                  var7 = this.bD;
                  if (var7 >= var2) {
                     var7 = this.bD - var2;
                     this.bD = var7;
                  }

                  var7 = this.bC + 304;
                  var137 = this.bJ;
                  if (var7 > var137) {
                     var7 = this.bJ - var2;
                     this.bC = var7;
                  }

                  var7 = 0;
                  Object var166 = null;

                  while (var7 < var69) {
                     var137 = (this.bC >> 4) + 19 - var4 - var7;
                     var3 = this.bA >> 4;
                     this.w(var137, var3, 0);
                     var7++;
                  }
               }
            }
         }

         this.a1002.setClip(0, 0, var1, 320);
         Graphics var49 = this.a1002;
         Image var169 = this.a1004;
         int var148 = this.bB;
         var148 = 0 - var148;
         var3 = this.bA;
         var148 += var3;
         var3 = this.bP;
         var148 -= var3;
         var3 = this.bD;
         var3 = 0 - var3;
         var2 = this.bC;
         var3 += var2;
         var2 = this.bQ;
         var3 = var3 - var2 + 13;
         var49.drawImage(var169, var148, var3, 0);
         Graphics var50 = this.a1002;
         var169 = this.a1004;
         var148 = this.bB;
         var148 = 0 - var148;
         var3 = this.bA;
         var148 += var3;
         var3 = this.bP;
         var148 -= var3;
         var3 = this.bD;
         var3 = 0 - var3;
         var2 = this.bC;
         var3 += var2;
         var2 = this.bQ;
         var3 = var3 - var2 + 304 + 13;
         var50.drawImage(var169, var148, var3, 0);
         Graphics var51 = this.a1002;
         var169 = this.a1004;
         var148 = this.bB;
         var148 = 0 - var148;
         var3 = this.bA;
         var148 += var3;
         var3 = this.bP;
         var148 = var148 - var3 + 256;
         var3 = this.bD;
         var3 = 0 - var3;
         var2 = this.bC;
         var3 += var2;
         var2 = this.bQ;
         var3 = var3 - var2 + 13;
         var51.drawImage(var169, var148, var3, 0);
         Graphics var52 = this.a1002;
         var169 = this.a1004;
         var148 = this.bB;
         var148 = 0 - var148;
         var3 = this.bA;
         var148 += var3;
         var3 = this.bP;
         var148 = var148 - var3 + 256;
         var3 = this.bD;
         var3 = 0 - var3;
         var2 = this.bC;
         var3 += var2;
         var2 = this.bQ;
         var3 = var3 - var2 + 304 + 13;
         var52.drawImage(var169, var148, var3, 0);
         var6 = this.aK;
         int var127 = this.aL;
         this.m(var6, var127, 0);
         var6 = this.aI;
         var127 = this.aJ;
         this.m(var6, var127, var4);
         this.ai();
         Graphics var53 = this.a1002;
         short var129 = 320;
         var53.setClip(0, 0, var1, var129);
      }
   }

   private void al() {
      byte var1 = -1;
      byte var2 = 2;
      byte var3 = 1;
      int var4 = 16;
      int var5 = this.l;
      int var6 = 13;
      byte var14;
      if (var5 == var6) {
         byte[] var7 = this.o1098;
         var6 = this.bw;
         var14 = var7[var6];
         if (var14 == var2) {
            var14 = var4;
         } else {
            var14 = 32;
         }
      } else {
         var14 = 0;
         Object var67 = null;
      }

      var6 = this.g1046;
      switch (var6) {
         case -4:
         case 54:
            var6 = this.bN + 16;
            this.bN = var6;
            int var73 = this.bI - var4 - var14;
            if (var6 > var73) {
               var6 = this.bI - var4;
               var14 = var6 - var14;
               this.bN = var14;
            }
            break;
         case -3:
         case 52:
            var14 = this.bN - var4;
            this.bN = var14;
            if (var14 < 0) {
               this.bN = 0;
            }
            break;
         case -2:
         case 56:
            var6 = this.bO + 16;
            this.bO = var6;
            int var8 = this.bJ - var4 - var14;
            if (var6 > var8) {
               var6 = this.bJ - var4;
               var14 = var6 - var14;
               this.bO = var14;
            }
            break;
         case -1:
         case 50:
            var14 = this.bO - var4;
            this.bO = var14;
            if (var14 < 0) {
               this.bO = 0;
            }
      }

      var14 = this.l;
      if (var14 != var2) {
         var14 = this.l;
         byte var53 = 13;
         if (var14 != var53) {
            return;
         }
      }

      var14 = this.h1047;
      switch (var14) {
         case -7:
            var14 = this.bF;
            if (var14 == var3) {
               this.bF = 0;
               this.aw = 0;
               this.b(var2);
            }
            break;
         case -6:
         case -5:
         case 53:
            var14 = this.bu;
            if (var14 == 0) {
               var14 = this.bF;
               if (var14 == 0) {
                  var14 = this.ay;
                  if (var14 != var1) {
                     int[][] var68 = this.c1107;
                     var6 = this.ay;
                     int[] var69 = var68[var6];
                     var6 = var69[var2];
                     byte var74 = 10;
                     if (var6 == var74) {
                        var6 = var69[15];
                        if (var6 == 0) {
                           byte var57 = 3;
                           byte var25 = g(var69[var57]);
                           if (var25) {
                              var25 = 6;
                           } else {
                              var25 = 3;
                           }

                           this.j(var25);
                        } else {
                           byte var58 = 3;
                           byte var27 = g(var69[var58]);
                           if (var27) {
                              var27 = 7;
                           } else {
                              var27 = 4;
                           }

                           this.j(var27);
                        }
                     } else {
                        byte var59 = 3;
                        byte var29 = g(var69[var59]);
                        if (var29) {
                           var29 = 5;
                        } else {
                           var29 = var2;
                        }

                        this.j(var29);
                     }
                  } else {
                     var14 = this.bN;
                     var6 = this.bO;
                     int var32 = this.e(var14, var6);
                     if (var32) {
                        this.j(0);
                     } else {
                        var32 = this.bN;
                        var6 = this.bO;
                        int var34 = this.g(var32, var6);
                        if (var34) {
                           this.j(var3);
                        } else {
                           var34 = this.h1047;
                           switch (var34) {
                              case -6:
                              case -5:
                              case 53:
                                 this.u1096 = (boolean)var3;
                           }
                        }
                     }
                  }
               } else {
                  int var36 = this.x1126;
                  if (var36) {
                     byte[] var70 = this.p1099;
                     var6 = this.bw;
                     var36 = var70[var6];
                     if (var36 == var3) {
                        var36 = 0;
                        var70 = null;
                        var6 = 0;
                        Object var9 = null;

                        while (true) {
                           int var75 = 4;
                           if (var36 >= var75) {
                              var36 = this.bx;
                              if (var36 > var3) {
                                 var36 = 0;
                                 var70 = null;

                                 while (true) {
                                    int var64 = 4;
                                    if (var36 >= var64) {
                                       break;
                                    }

                                    var9 = this.m1129;
                                    var64 = (int)((Object[])var9)[var36];
                                    if (var64 != var1) {
                                       var9 = this.m1129;
                                       var36 = (int)((Object[])var9)[var36];
                                       this.aA = var36;
                                       break;
                                    }

                                    var36++;
                                 }

                                 this.bx = 0;
                                 byte var42 = 14;
                                 this.a((int)var42);
                              } else {
                                 var36 = this.bx;
                                 if (var36 == var3) {
                                    this.bx = 0;
                                    var36 = this.bN;
                                    var75 = this.bO;
                                    var4 = this.bw;
                                    this.c(var36, var75, var4, var6);
                                 }
                              }
                              break;
                           }

                           var75 = this.bN;
                           var4 = this.bO;
                           int var77 = this.a(var75, var4, var36);
                           if (var77) {
                              int[] var10 = this.m1129;
                              var77 = var10[var36];
                              if (var77 != var1) {
                                 var9 = this.m1129;
                                 var6 = (int)((Object[])var9)[var36];
                                 var77 = this.bx + 1;
                                 this.bx = var77;
                              }
                           }

                           var36++;
                        }
                     } else {
                        var36 = this.bN;
                        var6 = this.bO;
                        int var81 = this.bw;
                        this.c(var36, var6, var81, var1);
                     }
                  }
               }
            }
      }
   }

   private void am() {
      byte var1 = 2;
      int var2 = this.bF;
      switch (var2) {
         case 0:
            var2 = this.ay;
            int var20 = -1;
            if (var2 != var20) {
               int[][] var4 = this.c1107;
               var20 = this.ay;
               int[] var24 = var4[var20];
               var20 = var24[0];
               int var26 = var24[1];
               byte[] var28 = this.o1098;
               int var29 = var24[var1];
               int var31 = var28[var29] << 4;
               byte[] var9 = this.o1098;
               var2 = var24[var1];
               var2 = var9[var2] << 4;
               this.i(var20, var26, var31, var2);
            } else {
               var2 = this.bN;
               var20 = this.bO;
               int var27 = this.bE;
               int var32 = this.bE;
               this.i(var2, var20, var27, var32);
            }
            break;
         case 1:
            var2 = this.bN;
            int var3 = this.bO;
            this.p(var2, var3);
            var2 = this.bN;
            var3 = this.bO;
            byte[] var10 = this.o1098;
            int var8 = this.bw;
            int var5 = var10[var8] << 4;
            byte[] var6 = this.o1098;
            int var7 = this.bw;
            var8 = var6[var7] << 4;
            this.i(var2, var3, var5, var8);
            var2 = this.bN;
            var3 = this.bO;
            var5 = this.bw;
            this.e(var2, var3, var5, 0);
      }
   }

   private void an() {
      byte var1;
      short var2;
      label27: {
         var1 = 16;
         var2 = 130;
         byte var3 = 112;
         int var4 = this.bN;
         if (var4 >= var3) {
            var4 = this.bN;
            int var5 = this.bI - var1 - var3;
            if (var4 <= var5) {
               var4 = this.bN - var3;
               this.bP = var4;
               break label27;
            }
         }

         var4 = this.bN;
         if (var4 < var3) {
            this.bP = 0;
         } else {
            var4 = this.bI;
            short var17 = 240;
            var4 -= var17;
            this.bP = var4;
         }
      }

      int var11 = this.bO;
      if (var11 >= var2) {
         var11 = this.bO;
         int var18 = this.bJ - var1 - var2;
         if (var11 <= var18) {
            var11 = this.bO - var2;
            this.bQ = var11;
            return;
         }
      }

      var11 = this.bO;
      if (var11 < var2) {
         this.bQ = 0;
      } else {
         var11 = this.bJ;
         short var19 = 276;
         var11 -= var19;
         this.bQ = var11;
      }
   }

   private void ao() {
      byte var1 = 2;
      int var2 = this.l;
      if (var2 == var1) {
         var2 = this.h1047;
         int[] var3 = this.r1166;
         int var4 = this.bU;
         int var5 = var3[var4];
         if (var2 == var5) {
            var2 = this.bU + 1;
            this.bU = var2;
            var2 = this.bU;
            var3 = this.r1166;
            var5 = var3.length;
            if (var2 == var5) {
               var2 = this.bz + 1000;
               this.bz = var2;
               this.bU = 0;
            }
         } else {
            var2 = this.h1047;
            var3 = this.s1167;
            var4 = this.bU;
            var5 = var3[var4];
            if (var2 == var5) {
               var2 = this.bU + 1;
               this.bU = var2;
               var2 = this.bU;
               var3 = this.s1167;
               var5 = var3.length;
               if (var2 == var5) {
                  var2 = 0;

                  while (true) {
                     var5 = this.aP;
                     if (var2 >= var5) {
                        this.bU = 0;
                        break;
                     }

                     var3 = this.b1066[var2];
                     var3[var1] = 0;
                     var2++;
                  }
               }
            } else {
               var2 = this.h1047;
               var3 = this.t1168;
               var4 = this.bU;
               var5 = var3[var4];
               if (var2 == var5) {
                  var2 = this.bU + 1;
                  this.bU = var2;
                  var2 = this.bU;
                  var3 = this.s1167;
                  var5 = var3.length;
                  if (var2 == var5) {
                     var2 = 0;

                     while (true) {
                        byte var34 = 9;
                        if (var2 >= var34) {
                           this.bU = 0;
                           break;
                        }

                        boolean[] var24 = this.d1073;
                        boolean var27 = true;
                        var24[var2] = var27;
                        var2++;
                     }
                  }
               } else {
                  this.bU = 0;
               }
            }
         }
      }
   }

   private void ap() {
      int var1 = 120;
      int var2 = 90;
      short var3 = 240;
      short var4 = 175;
      this.a1002.setColor(16580557);
      Graphics var5 = this.a1002;
      String var6 = this.b1015[var4];
      int var7 = var6.length();
      int var8 = this.k;
      var7 = var7 * var8 + 8;
      var7 = var3 - var7 >> 1;
      String var9 = this.b1015[var4];
      var8 = var9.length();
      int var10 = this.k;
      var8 = var8 * var10 + 8;
      var5.fillRect(var7, var2, var8, var1);
      int var11 = this.b1015[var4].length();
      var7 = this.k;
      var11 = var11 * var7 + 8;
      var7 = var3 - var11 >> 1;
      var11 = this.b1015[var4].length();
      var8 = this.k;
      var8 = var11 * var8 + 8;
      byte var40 = 1;
      this.c(var7, var2, var8, var1, var40);
      var5 = this.a1002;
      short var27 = 320;
      var5.setClip(0, 0, var3, var27);
      var11 = 0;
      Object var19 = null;

      while (true) {
         int var28 = 5;
         if (var11 >= var28) {
            return;
         }

         var28 = this.r;
         if (var11 == var28) {
            Graphics var20 = this.a1002;
            var2 = 14311547;
            var20.setColor(var2);
         } else {
            Graphics var21 = this.a1002;
            var2 = 15455661;
            var21.setColor(var2);
         }

         Graphics var22 = this.a1002;
         String[] var12 = this.b1015;
         var8 = var11 + 175;
         String var44 = var12[var8];
         String[] var38 = this.b1015;
         var1 = var11 + 175;
         var9 = var38[var1];
         var8 = var9.length();
         var1 = this.k;
         var8 *= var1;
         var8 = var3 - var8 >> 1;
         var1 = var11 * 20 + 100;
         var22.drawString(var44, var8, var1, 0);
         var11++;
      }
   }

   private void aq() {
      byte var1 = 4;
      byte var2 = 1;
      int var3 = this.h1047;
      switch (var3) {
         case -7:
            this.r = 0;
            this.a();
            break;
         case -6:
         case -5:
         case 53:
            var3 = this.r;
            this.bW = var3;
            var3 = this.bW;
            this.F(var3);
            break;
         case -2:
         case 56:
            var3 = this.r + 1;
            this.r = var3;
            if (var3 > var1) {
               this.r = 0;
            }

            int var12 = this.e();
            if (var12) {
               var12 = this.r;
               if (var12 == var2) {
                  var12 = this.r + 1;
                  this.r = var12;
               }
            }

            int var15 = this.z1169;
            if (var15) {
               var15 = this.r;
               if (var15 == var1) {
                  this.r = 0;
               }
            }
            break;
         case -1:
         case 50:
            var3 = this.r - var2;
            this.r = var3;
            if (var3 < 0) {
               this.r = var1;
            }

            int var5 = this.e();
            if (var5) {
               var5 = this.r;
               if (var5 == var2) {
                  var5 = this.r - var2;
                  this.r = var5;
               }
            }

            int var8 = this.z1169;
            if (var8) {
               var8 = this.r;
               if (var8 == var1) {
                  byte var10 = 3;
                  this.r = var10;
               }
            }
      }
   }

   private final void ar() {
      String var4;
      this.e();
      this.a1002.setColor(14311547);
      Graphics var1 = this.a1002;
      int var2 = 320;
      var1.setClip(0, 0, 240, var2);
      String var6 = "";
      int var3 = this.l;
      label21:
      switch (var3) {
         case 46:
            int var27 = this.b1174;
            switch (var27) {
               case 0:
                  int var5 = this.o;
                  var27 = (byte)-1;
                  if (var5 != var27) {
                     StringBuffer var17 = new StringBuffer();
                     String[] var33 = this.b1015;
                     var2 = this.o + 113;
                     var4 = var33[var2];
                     StringBuffer var18 = var17.append(var4);
                     String[] var35 = this.d1173;
                     var2 = this.bW + 0;
                     var4 = var35[var2];
                     String var19 = var18.append(var4).toString();
                     var4 = var19;
                  } else {
                     String[] var20 = this.d1173;
                     var27 = this.bW + 0;
                     String var21 = var20[var27];
                     var4 = var21;
                  }
                  break label21;
               case 1:
                  String[] var15 = this.d1173;
                  var27 = (byte)9;
                  String var16 = var15[var27];
                  var4 = var16;
                  break label21;
               case 2:
                  String[] var13 = this.d1173;
                  var27 = (byte)10;
                  String var14 = var13[var27];
                  var4 = var14;
                  break label21;
               case 3:
                  String[] var11 = this.d1173;
                  var27 = (byte)11;
                  String var12 = var11[var27];
                  var4 = var12;
                  break label21;
            }
         default:
            var4 = var6;
            break;
         case 47:
            String[] var9 = this.d1173;
            byte var26 = 8;
            String var10 = var9[var26];
            var4 = var10;
            break;
         case 48:
            String[] var7 = this.d1173;
            byte var25 = 7;
            String var8 = var7[var25];
            var4 = var8;
      }

      var2 = this.c;
      this.a(var4, var2, 27, 70, 186, 292);
      this.f();
      this.c(2, 3);
   }

   private final void as() {
      int var1 = 47;
      byte var2 = 2;
      byte var3 = 1;
      int var4 = this.b1174;
      switch (var4) {
         case 0:
            var4 = this.h1047;
            switch (var4) {
               case -7:
                  this.a();
                  return;
               case -6:
               case -5:
               case 53:
                  this.a(var1);
                  this.at();
                  return;
               case -2:
               case 56:
                  var4 = this.c;
                  var1 = this.a1007;
                  int var32 = this.b1008;
                  var1 -= var32;
                  if (var4 < var1) {
                     var4 = this.c + 1;
                     this.c = var4;
                  }

                  return;
               case -1:
               case 50:
                  var4 = this.c;
                  if (var4 > 0) {
                     var4 = this.c - var3;
                     this.c = var4;
                  }

                  return;
               default:
                  return;
            }
         case 1:
            var4 = this.h1047;
            switch (var4) {
               case -7:
               case -6:
               case -5:
               case 53:
                  this.a();
                  var4 = this.bW;
                  switch (var4) {
                     case 0:
                        var4 = 0;
                        Object var35 = null;

                        while (true) {
                           var1 = this.aP;
                           if (var4 >= var1) {
                              return;
                           }

                           int[] var38 = this.b1066[var4];
                           var38[var2] = 0;
                           var4++;
                        }
                     case 1:
                        var4 = 0;
                        Object var34 = null;

                        while (true) {
                           int var12 = 5;
                           if (var4 >= var12) {
                              return;
                           }

                           this.a1056[var4] = (boolean)var3;
                           byte[] var7 = this.b1059;
                           byte[] var8 = this.h1060;
                           byte var5 = var8[var4];
                           var7[var5] = var3;
                           var12 = 0;
                           var7 = null;

                           while (var12 < var2) {
                              boolean[] var39 = this.e1105;
                              byte[] var9 = this.g1065[var4];
                              byte var10 = var9[var12];
                              var39[var10] = (boolean)var3;
                              var12++;
                           }

                           var7 = this.h1060;
                           byte var14 = var7[var4];
                           this.u(var14);
                           var4++;
                        }
                     case 2:
                        var4 = this.bz + 500;
                        this.bz = var4;
                        return;
                     case 3:
                        var4 = this.by + 10;
                        this.by = var4;
                        return;
                     case 4:
                        this.z1169 = (boolean)var3;
                        return;
                     case 5:
                        boolean[] var33 = this.d1073;
                        var1 = this.aN;
                        var33[var1] = (boolean)var3;
                        return;
                     case 6:
                        this.A1170 = (boolean)var3;
                        return;
                     default:
                        return;
                  }
               default:
                  return;
            }
         case 2:
            var4 = this.h1047;
            switch (var4) {
               case -7:
                  this.a();
                  return;
               case -6:
               case -5:
               case 53:
                  this.a(var1);
                  this.at();
                  return;
               default:
                  return;
            }
         case 3:
            var4 = this.h1047;
            switch (var4) {
               case -7:
                  this.a();
                  break;
               case -6:
               case -5:
               case 53:
                  boolean var19 = this.F1180;
                  if (var19) {
                     String var6 = this.d1181;
                     b(var6);
                  } else {
                     this.a();
                  }
            }
      }
   }

   private void at() {
      this.b1174 = 1;
      this.a();
   }

   private void au() {
      Calendar var1 = Calendar.getInstance();
      this.a1185 = var1;
      Date var7 = new Date();
      this.a1184 = var7;
      Date var8 = this.a1184;
      long var2 = System.currentTimeMillis();
      var8.setTime(var2);
      var1 = this.a1185;
      Date var4 = this.a1184;
      var1.setTime(var4);
      int var5 = this.a1185.get(1) * 10000;
      this.bX = var5;
      var5 = this.bX;
      int var6 = this.a1185.get(2) * 100;
      var5 += var6;
      this.bX = var5;
      var5 = this.bX;
      var6 = this.a1185.get(5);
      var5 += var6;
      this.bX = var5;
      this.bX = 0;
   }

   private void av() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:359)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield a.a1172 Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: bipush 2
      // 08: istore 2
      // 09: aload 0
      // 0a: iload 2
      // 0b: putfield a.bV I
      // 0e: aload 1
      // 0f: monitorexit
      // 10: new com/netmite/andme/MIDletThread
      // 13: astore 1
      // 14: aload 1
      // 15: aload 0
      // 16: invokespecial com/netmite/andme/MIDletThread.<init> (Ljava/lang/Runnable;)V
      // 19: aload 1
      // 1a: invokevirtual java/lang/Thread.start ()V
      // 1d: return
      // 1e: astore 3
      // 1f: aload 1
      // 20: monitorexit
      // 21: aload 3
      // 22: athrow
      // try (8 -> 10): 20 null
      // try (10 -> 12): 20 null
      // try (21 -> 23): 20 null
   }

   private final void aw() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc_w "__sfSmsInfo"
      // 03: astore 1
      // 04: bipush 0
      // 05: istore 2
      // 06: aconst_null
      // 07: astore 3
      // 08: aload 1
      // 09: bipush 0
      // 0a: invokestatic javax/microedition/rms/RecordStore.openRecordStore (Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
      // 0d: astore 1
      // 0e: bipush 1
      // 0f: istore 2
      // 10: aload 1
      // 11: iload 2
      // 12: invokevirtual javax/microedition/rms/RecordStore.getRecord (I)[B
      // 15: astore 3
      // 16: new java/io/ByteArrayInputStream
      // 19: astore 4
      // 1b: aload 4
      // 1d: aload 3
      // 1e: invokespecial java/io/ByteArrayInputStream.<init> ([B)V
      // 21: new java/io/DataInputStream
      // 24: astore 3
      // 25: aload 3
      // 26: aload 4
      // 28: invokespecial java/io/DataInputStream.<init> (Ljava/io/InputStream;)V
      // 2b: aload 3
      // 2c: invokevirtual java/io/DataInputStream.readInt ()I
      // 2f: pop
      // 30: aload 3
      // 31: invokevirtual java/io/DataInputStream.readUTF ()Ljava/lang/String;
      // 34: astore 5
      // 36: aload 0
      // 37: aload 5
      // 39: putfield a.b1177 Ljava/lang/String;
      // 3c: aload 3
      // 3d: invokevirtual java/io/DataInputStream.readUTF ()Ljava/lang/String;
      // 40: astore 5
      // 42: aload 0
      // 43: aload 5
      // 45: putfield a.c1178 Ljava/lang/String;
      // 48: aload 3
      // 49: invokevirtual java/io/DataInputStream.readBoolean ()Z
      // 4c: istore 6
      // 4e: aload 0
      // 4f: iload 6
      // 51: putfield a.F1180 Z
      // 54: aload 0
      // 55: getfield a.F1180 Z
      // 58: istore 6
      // 5a: iload 6
      // 5c: ifeq 6b
      // 5f: aload 3
      // 60: invokevirtual java/io/DataInputStream.readUTF ()Ljava/lang/String;
      // 63: astore 5
      // 65: aload 0
      // 66: aload 5
      // 68: putfield a.d1181 Ljava/lang/String;
      // 6b: aload 3
      // 6c: invokevirtual java/io/DataInputStream.readBoolean ()Z
      // 6f: istore 6
      // 71: aload 0
      // 72: iload 6
      // 74: putfield a.G1182 Z
      // 77: aload 0
      // 78: getfield a.G1182 Z
      // 7b: istore 6
      // 7d: iload 6
      // 7f: ifeq 8e
      // 82: aload 3
      // 83: invokevirtual java/io/DataInputStream.readUTF ()Ljava/lang/String;
      // 86: astore 5
      // 88: aload 0
      // 89: aload 5
      // 8b: putfield a.e1183 Ljava/lang/String;
      // 8e: aload 3
      // 8f: invokevirtual java/io/DataInputStream.close ()V
      // 92: aload 4
      // 94: invokevirtual java/io/ByteArrayInputStream.close ()V
      // 97: aload 1
      // 98: invokevirtual javax/microedition/rms/RecordStore.closeRecordStore ()V
      // 9b: return
      // 9c: astore 1
      // 9d: ldc_w "YXBY15 2LD210A10 IF2"
      // a0: astore 1
      // a1: aload 0
      // a2: aload 1
      // a3: putfield a.c1178 Ljava/lang/String;
      // a6: ldc_w "106633000015"
      // a9: astore 1
      // aa: aload 0
      // ab: aload 1
      // ac: putfield a.b1177 Ljava/lang/String;
      // af: aload 0
      // b0: invokespecial a.ax ()V
      // b3: goto 9b
      // b6: astore 1
      // b7: goto 9b
      // try (7 -> 9): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (7 -> 9): 96 java/lang/Exception
      // try (13 -> 15): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (13 -> 15): 96 java/lang/Exception
      // try (16 -> 17): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (16 -> 17): 96 java/lang/Exception
      // try (19 -> 21): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (19 -> 21): 96 java/lang/Exception
      // try (21 -> 22): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (21 -> 22): 96 java/lang/Exception
      // try (24 -> 26): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (24 -> 26): 96 java/lang/Exception
      // try (26 -> 29): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (26 -> 29): 96 java/lang/Exception
      // try (29 -> 31): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (29 -> 31): 96 java/lang/Exception
      // try (33 -> 35): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (33 -> 35): 96 java/lang/Exception
      // try (35 -> 37): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (35 -> 37): 96 java/lang/Exception
      // try (39 -> 41): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (39 -> 41): 96 java/lang/Exception
      // try (41 -> 43): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (41 -> 43): 96 java/lang/Exception
      // try (45 -> 47): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (45 -> 47): 96 java/lang/Exception
      // try (47 -> 49): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (47 -> 49): 96 java/lang/Exception
      // try (52 -> 54): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (52 -> 54): 96 java/lang/Exception
      // try (56 -> 58): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (56 -> 58): 96 java/lang/Exception
      // try (58 -> 60): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (58 -> 60): 96 java/lang/Exception
      // try (62 -> 64): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (62 -> 64): 96 java/lang/Exception
      // try (64 -> 66): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (64 -> 66): 96 java/lang/Exception
      // try (69 -> 71): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (69 -> 71): 96 java/lang/Exception
      // try (73 -> 75): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (73 -> 75): 96 java/lang/Exception
      // try (75 -> 77): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (75 -> 77): 96 java/lang/Exception
      // try (77 -> 79): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (77 -> 79): 96 java/lang/Exception
      // try (79 -> 81): 82 javax/microedition/rms/RecordStoreNotFoundException
      // try (79 -> 81): 96 java/lang/Exception
      // try (86 -> 88): 96 java/lang/Exception
      // try (91 -> 93): 96 java/lang/Exception
      // try (93 -> 95): 96 java/lang/Exception
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void ax() {
      boolean var1 = true;
      ByteArrayOutputStream var2 = null;
      String var3 = "__sfSmsInfo";
      boolean var4 = false;
      RecordStore var5 = null;
      String var10000 = var3;

      boolean var6;
      label228: {
         label234: {
            try {
               try {
                  var65 = RecordStore.openRecordStore(var10000, false);
                  break label234;
               } catch (RecordStoreNotFoundException var42) {
               }
            } catch (Exception var43) {
               return;
            }

            var3 = "__sfSmsInfo";
            var4 = true;
            var10000 = var3;

            try {
               var64 = RecordStore.openRecordStore(var10000, var4);
            } catch (Exception var41) {
               return;
            }

            RecordStore var46 = var64;
            var5 = var46;
            var6 = var1;
            break label228;
         }

         var5 = var65;
         var6 = 0;
         var3 = null;
      }

      try {
         var66 = new ByteArrayOutputStream;
      } catch (Exception var40) {
         return;
      }

      var2 = var66;

      try {
         var2./* $VF: Unable to resugar constructor */<init>();
      } catch (Exception var39) {
         return;
      }

      try {
         var67 = new DataOutputStream;
      } catch (Exception var38) {
         return;
      }

      DataOutputStream var7 = var67;
      DataOutputStream var68 = var7;

      try {
         var68./* $VF: Unable to resugar constructor */<init>(var2);
      } catch (Exception var37) {
         return;
      }

      try {
         var69 = this.bX;
      } catch (Exception var36) {
         return;
      }

      int var8 = var69;
      DataOutputStream var70 = var7;

      try {
         var70.writeInt(var8);
      } catch (Exception var35) {
         return;
      }

      try {
         var10000 = this.b1177;
      } catch (Exception var34) {
         return;
      }

      String var9 = var10000;
      DataOutputStream var72 = var7;

      try {
         var72.writeUTF(var9);
      } catch (Exception var33) {
         return;
      }

      try {
         var10000 = this.c1178;
      } catch (Exception var32) {
         return;
      }

      var9 = var10000;
      DataOutputStream var74 = var7;

      try {
         var74.writeUTF(var9);
      } catch (Exception var31) {
         return;
      }

      try {
         var75 = this.F1180;
      } catch (Exception var30) {
         return;
      }

      boolean var52 = var75;
      DataOutputStream var76 = var7;

      try {
         var76.writeBoolean(var52);
      } catch (Exception var29) {
         return;
      }

      try {
         var77 = this.F1180;
      } catch (Exception var28) {
         return;
      }

      var52 = var77;
      if (var52) {
         try {
            var10000 = this.d1181;
         } catch (Exception var27) {
            return;
         }

         var9 = var10000;
         DataOutputStream var79 = var7;

         try {
            var79.writeUTF(var9);
         } catch (Exception var26) {
            return;
         }
      }

      try {
         var80 = this.G1182;
      } catch (Exception var25) {
         return;
      }

      var52 = var80;
      DataOutputStream var81 = var7;

      try {
         var81.writeBoolean(var52);
      } catch (Exception var24) {
         return;
      }

      try {
         var82 = this.G1182;
      } catch (Exception var23) {
         return;
      }

      var52 = var82;
      if (var52) {
         try {
            var10000 = this.e1183;
         } catch (Exception var22) {
            return;
         }

         var9 = var10000;
         DataOutputStream var84 = var7;

         try {
            var84.writeUTF(var9);
         } catch (Exception var21) {
            return;
         }
      }

      if (var6) {
         try {
            var85 = var2.toByteArray();
         } catch (Exception var20) {
            return;
         }

         byte[] var48 = var85;
         var52 = false;
         Object var60 = null;

         try {
            var86 = var2.size();
         } catch (Exception var19) {
            return;
         }

         int var10 = var86;
         RecordStore var87 = var5;
         byte[] var10001 = var48;
         byte var10002 = 0;

         try {
            var87.addRecord(var10001, var10002, var10);
         } catch (Exception var18) {
            return;
         }
      } else {
         var6 = 1;

         try {
            var88 = var2.toByteArray();
         } catch (Exception var17) {
            return;
         }

         byte[] var61 = var88;
         boolean var62 = false;

         try {
            var89 = var2.size();
         } catch (Exception var16) {
            return;
         }

         int var11 = var89;
         RecordStore var90 = var5;
         byte var91 = var6;
         byte[] var92 = var61;
         byte var10003 = 0;

         try {
            var90.setRecord(var91, var92, var10003, var11);
         } catch (Exception var15) {
            return;
         }
      }

      try {
         var7.close();
      } catch (Exception var14) {
         return;
      }

      try {
         var2.close();
      } catch (Exception var13) {
         return;
      }

      try {
         var5.closeRecordStore();
      } catch (Exception var12) {
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void ay() {
      label19: {
         ByteArrayOutputStream var10000;
         try {
            var10000 = this.a1191;
         } catch (Exception var3) {
            break label19;
         }

         ByteArrayOutputStream var1 = var10000;

         try {
            var1.close();
         } catch (Exception var2) {
         }
      }

      byte[] var4 = this.a1191.toByteArray();
      this.H1188 = var4;
      this.a1191 = null;
      this.g1187 = null;
      this.I1189 = null;
   }

   private int b() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:359)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield a.a1172 Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield a.bV I
      // 0b: istore 2
      // 0c: aload 1
      // 0d: monitorexit
      // 0e: bipush 2
      // 0f: istore 3
      // 10: iload 2
      // 11: iload 3
      // 12: if_icmpne 1f
      // 15: bipush 50
      // 17: i2l
      // 18: lstore 4
      // 1a: lload 4
      // 1c: invokestatic java/lang/Thread.sleep (J)V
      // 1f: iload 2
      // 20: ireturn
      // 21: astore 6
      // 23: aload 1
      // 24: monitorexit
      // 25: aload 6
      // 27: athrow
      // 28: astore 1
      // 29: goto 1f
      // try (5 -> 7): 22 null
      // try (8 -> 10): 22 null
      // try (18 -> 20): 27 java/lang/Exception
      // try (23 -> 25): 22 null
   }

   private int b(int var1) {
      byte var2 = 2;
      int var3 = 0;
      Object var4 = null;
      int[] var5 = this.c1107[var1];
      int var6 = 0;

      while (true) {
         int var7 = var5[3];
         if (var3 >= var7) {
            var4 = this.q1100;
            int var9 = var5[var2];
            return ((Object[])var4)[var9] + var6 >> 1;
         }

         var7 = var5[var2];
         byte[] var8 = this.r1101;
         var7 = this.a(var7, var8, var3);
         var6 += var7;
         var3++;
      }
   }

   private int b(int var1, int var2) {
      int var4;
      if (var2 == 0) {
         var4 = this.bG;
         var4 = var1 % var4 << 4;
      } else {
         var4 = this.bG;
         var4 = var1 / var4 << 4;
      }

      return var4;
   }

   private int b(int var1, int var2, int var3) {
      byte var4 = 3;
      byte var5 = 2;
      byte var6 = 1;
      int var7 = this.c(var1, var2);
      this.bc = 0;
      int var8 = this.q1082;
      if (!var8) {
         var8 = var6;
      } else {
         var8 = (byte)0;
         Object var10 = null;
      }

      this.q1082 = (boolean)var8;

      while (true) {
         var8 = this.bc;
         int var9 = 4;
         if (var8 >= var9) {
            var7 = this.c(var1, var2);
            break;
         }

         byte[] var22 = this.k1081[var7];
         var8 = (var22[0] << 4) + var1;
         byte[] var11 = this.k1081[var7];
         var9 = (var11[var6] << 4) + var2;
         var8 = this.a(var8, var9);
         int var20 = this.b(var8);
         if (var20) {
            var20 = Math.abs(this.a(var8) - var7);
            if (var20 != var5) {
               var8 = Math.abs(this.a(var8) - var3);
               if (var8 != var5) {
                  break;
               }
            }
         }

         int var17 = this.q1082;
         if (var17) {
            if (++var7 > var4) {
               var7 = 0;
            }
         } else {
            var7 += -1;
            if (var7 < 0) {
               var7 = var4;
            }
         }

         var17 = this.bc + 1;
         this.bc = var17;
      }

      return var7;
   }

   private static int b(int var0, int var1, int var2, int var3) {
      int var4 = var2 - var0;
      int var5 = var2 - var0;
      var4 *= var5;
      var5 = var3 - var1;
      int var6 = var3 - var1;
      var5 *= var6;
      return var4 + var5;
   }

   private String b(String var1) {
      int var2 = this.D1176;
      String var8;
      if (var2) {
         byte var3 = 7;
         var2 = var1.indexOf(47, var3);
         var8 = var1.substring(var2);
         StringBuffer var5 = new StringBuffer();
         String var6 = "http://10.0.0.172:80";
         var5 = var5.append(var6);
         var8 = var5.append(var8).toString();
      } else {
         var8 = var1;
      }

      return var8;
   }

   private void b() {
      this.m = 0;
   }

   private void b(int var1) {
      int var5;
      do {
         var5 = this.m - 1;
         this.m = var5;
         int[] var3 = this.b;
         int var4 = this.m;
         var5 = var3[var4];
      } while (var5 != var1);

      int[] var7 = this.b;
      int var8 = this.m;
      var5 = var7[var8];
      this.l = var5;
   }

   private void b(int var1, int var2) {
      short var3 = 320;
      short var4 = 240;
      int var5 = 0;
      this.a1002.setClip(0, 0, var4, var3);
      this.a1002.setColor(16777215);
      this.a1002.fillRect(0, 0, var4, var3);
      int var6 = this.t;
      int var7 = var4 - var1;
      this.e(var6, var7);
      this.d(var2);
      var6 = 0;

      while (true) {
         int var11 = 3;
         if (var6 >= var11) {
            return;
         }

         var11 = this.w;
         var5 = var6 * 176;
         var11 += var5;
         var5 = this.x - var1;
         this.d(var11, var5);
         var6++;
      }
   }

   private final void b(int var1, int var2, int var3) {
      byte var4 = 7;
      byte var5 = 5;
      byte var6 = 3;
      byte var7 = 1;
      int var8 = 1000000;
      int var9 = var3 + 3;
      if (var1 != 0) {
         int var10 = var8;
         var8 = 0;
         Object var11 = null;

         while (true) {
            int var12 = this.a1016;
            if (var12) {
               int var19 = this.a1016;
               if (var19) {
                  this.a1016 = false;
                  var19 = var2;
                  var12 = var1;

                  while (var8 > 0) {
                     this.a1002.setClip(var19, var9, var5, var4);
                     Graphics var13 = this.a1002;
                     Image var14 = this.a1013[var6][13];
                     int var15 = var12 / var8 * 5;
                     var15 = var19 - var15;
                     var13.drawImage(var14, var15, var9, 0);
                     int var16 = var12 / var8 * var8;
                     var12 -= var16;
                     var8 /= 10;
                     var19 = var19 + 5 - var7;
                  }
               }
               break;
            }

            var12 = var1 / var10;
            if (var12 != 0) {
               this.a1016 = (boolean)var7;
               var8 = var10;
            }

            var10 /= 10;
         }
      } else {
         this.a1002.setClip(var2, var9, var5, var4);
         Graphics var21 = this.a1002;
         Image[] var17 = this.a1013[var6];
         byte var24 = 13;
         Image var26 = var17[var24];
         var21.drawImage(var26, var2, var9, 0);
      }

      this.a1002.setClip(0, 0, 240, 320);
   }

   private void b(int var1, int var2, int var3, int var4) {
      byte var5 = 7;
      byte var6 = 1;
      int var7 = 15;
      this.a1002.setClip(0, 0, 240, 320);
      this.a1002.setColor(3291732);
      Graphics var8 = this.a1002;
      int var9 = var2 - 8;
      int var10 = var3 - 16;
      var8.fillRect(var9, var10, var7, 3);
      this.a1002.setColor(16777191);
      var8 = this.a1002;
      var9 = var2 - var5;
      var10 = var3 - var7;
      int var11 = 13;
      var8.fillRect(var9, var10, var11, var6);
      var8 = this.a1002;
      int var20 = 49168;
      var8.setColor(var20);
      int var12 = var4 & 1;
      if (var12 == 0) {
         var8 = this.a1002;
         var20 = var2 - var5;
         var10 = var3 - var7;
         var11 = var1 * 13;
         var7 = this.aW;
         var11 /= var7;
         var8.fillRect(var20, var10, var11, var6);
      } else {
         var8 = this.a1002;
         var20 = var2 - var5;
         var10 = var3 - var7;
         var11 = var1 * 13;
         var7 = this.aW * 10;
         var11 /= var7;
         var8.fillRect(var20, var10, var11, var6);
      }
   }

   private void b(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = 2;
      this.a1002.setClip(0, 0, 240, 320);
      this.a1002.setColor(13971834);
      StringBuffer var7 = new StringBuffer();
      String[] var8 = this.b1015;
      byte[][] var9 = this.y1130;
      int var10 = this.X;
      byte[] var17 = var9[var10];
      var10 = this.c1107[var1][var6];
      int var11 = var17[var10] + 28;
      String var13 = var8[var11];
      var7 = var7.append(var13).append("：");
      var8 = this.b1015;
      var9 = this.y1130;
      var10 = this.X;
      byte[] var19 = var9[var10];
      var10 = this.c1107[var1][var6];
      var11 = var19[var10] + 122;
      String var15 = var8[var11];
      String var16 = var7.append(var15).toString();
      this.a(var16, 0, var2, var3, var4, var5);
   }

   private void b(int var1, int var2, int var3, int var4, int var5, int var6) {
      byte var7 = 1;
      byte var8 = this.a1038;
      if (var1 < var8) {
         int[] var9 = this.a1039[var1];
         int var18;
         int var20;
         if (var2 == var7) {
            Image var10 = this.a1040[var1];
            var18 = var10.getWidth();
            Image var12 = this.a1040[var1];
            var20 = var12.getHeight();
            int var14 = var3 & 1;
            if (var14 != 0) {
               var18 = var5 - var18;
            } else {
               var14 = var3 & 4;
               if (var14 != 0) {
                  var18 >>= 1;
                  var18 = var5 - var18;
               } else {
                  var18 = var5;
               }
            }

            var14 = var3 & 2;
            if (var14 != 0) {
               var20 -= var7;
               int var15 = var6 - var20;
               var20 = var18;
               var18 = var15;
            } else {
               var14 = var3 & 8;
               if (var14 != 0) {
                  var20 = (var20 >> 1) - var7;
                  int var27 = var6 - var20;
                  var20 = var18;
                  var18 = var27;
               } else {
                  var20 = var18;
                  var18 = var6;
               }
            }
         } else {
            var18 = var6;
            var20 = var5;
         }

         var9[2] = var2;
         var9[3] = var4;
         byte var26 = 4;
         var9[var26] = var20;
         byte var22 = 5;
         var9[var22] = var18;
      }
   }

   private void b(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = 5;
      if (var7 > var9) {
         var9 = 5;
      } else {
         var9 = var7;
      }

      byte[][] var11 = this.K1145;
      int var13 = var9 >> 1;
      byte[] var12 = var11[var13];
      int var14 = var12[0];
      var11 = this.K1145;
      var9 >>= 1;
      byte[] var15 = var11[var9];
      int var25 = var15[1];
      var13 = var1 + var14;
      int var10 = this.bP;
      int var17 = var13 - var10;
      var13 = var2 + var25;
      var10 = this.bQ;
      var13 -= var10;
      int var18 = var13 + 13;
      switch (var8) {
         case 0:
            var14 += var1;
            var25 += var2;
            this.t(var14, var25, var6);
            int var32 = 2;
            if (var6 > var32) {
               var32 = (byte)6;
               if (var6 < var32) {
                  Image[][] var60 = this.a1013;
                  Image[] var89 = var60[29];
                  byte var83 = 22;
                  Image var67 = var89[var83];
                  var13 = var17 + 21;
                  int var95 = var18 + 15;
                  var32 = var6 & 1;
                  int var100 = var32 << 4;
                  boolean var106 = false;
                  byte var111 = 16;
                  byte var116 = 16;
                  this.a(var67, var13, var95, var100, 0, var111, var116, 0, 0);
                  break;
               }
            }

            int var34 = 6;
            if (var6 >= var34) {
               var34 = (byte)6;
               if (var6 == var34) {
                  Image[][] var57 = this.a1013;
                  Image[] var86 = var57[29];
                  byte var80 = 29;
                  Image var64 = var86[var80];
                  var13 = var17 + 21;
                  var34 = (byte)15;
                  int var92 = var18 - var34;
                  boolean var97 = false;
                  byte var103 = 18;
                  byte var108 = 16;
                  byte var113 = 31;
                  this.a(var64, var13, var92, 0, var103, var108, var113, 0, 0);
               }

               var34 = (byte)6;
               if (var6 >= var34) {
                  var34 = (byte)9;
                  if (var6 < var34) {
                     Image[][] var58 = this.a1013;
                     Image[] var87 = var58[29];
                     byte var81 = 27;
                     Image var65 = var87[var81];
                     var13 = var17 + 21;
                     int var93 = var18 + 10;
                     var34 = var6 - 6;
                     int var98 = var34 * 21;
                     boolean var104 = false;
                     byte var109 = 21;
                     byte var114 = 17;
                     this.a(var65, var13, var93, var98, 0, var109, var114, 0, 0);
                  }
               }

               int var40 = 6;
               if (var6 > var40) {
                  Image[][] var59 = this.a1013;
                  Image[] var88 = var59[29];
                  byte var82 = 28;
                  Image var66 = var88[var82];
                  var13 = var17 + 14;
                  int var94 = var18 - 30;
                  var40 = var6 - 7;
                  int var99 = var40 * 29;
                  boolean var105 = false;
                  byte var110 = 29;
                  byte var115 = 22;
                  this.a(var66, var13, var94, var99, 0, var110, var115, 0, 0);
               }
            }
            break;
         case 1:
            var25 = (byte)3;
            if (var6 < var25) {
               Image[][] var49 = this.a1013;
               Image var61 = var49[29][29];
               var10 = this.bP;
               var13 = var3 - var10;
               var11 = this.L1146;
               var25 = var11[var6][0] + var4;
               var10 = this.bQ;
               int var16 = var25 - var10 + 13;
               var11 = this.L1146;
               byte var20 = var11[var6][1];
               var11 = this.L1146;
               byte var21 = var11[var6][2];
               var11 = this.L1146;
               byte var22 = var11[var6][3];
               this.a(var61, var13, var16, 0, var20, var21, var22, 2, 0);
               Image[][] var54 = this.a1013;
               Image[] var84 = var54[29];
               var14 = (byte)28;
               Image var62 = var84[var14];
               var10 = this.bP;
               var13 = var3 - var10;
               var11 = this.L1146;
               var25 = var11[0][0] + var4;
               var10 = this.bQ;
               var25 -= var10;
               var16 = var25 + 13;
               int var19 = var6 * 29;
               boolean var101 = false;
               var21 = 29;
               var22 = 22;
               this.a(var62, var13, var16, var19, 0, var21, var22, 0, 0);
            } else {
               Image[][] var56 = this.a1013;
               Image[] var85 = var56[29];
               var14 = (byte)30;
               Image var63 = var85[var14];
               int var91 = var3 + 10;
               int var96 = var4 + 40;
               byte var30 = 3;
               int var102 = var6 - var30;
               this.b(var63, var5, var91, var96, var102);
            }
      }
   }

   private void b(int var1, int var2, int var3, int var4, boolean var5) {
      if (var5) {
         Graphics var6 = this.a1002;
         int var7 = 5046188;
         var6.setColor(var7);
      } else {
         Graphics var15 = this.a1002;
         int[] var9 = this.q1158;
         long var13 = this.a1019;
         int var10 = (int)var13 & 3;
         int var17 = var9[var10];
         var15.setColor(var17);
      }

      byte var8 = 0;
      Object var16 = null;

      while (var8 < var3) {
         Graphics var18 = this.a1002;
         int var20 = var1 + var8;
         int var11 = var1 + var3;
         int var12 = var2 + var4 - var8;
         var18.drawLine(var20, var2, var11, var12);
         var18 = this.a1002;
         var20 = var2 + var8;
         var11 = var1 + var3 - var8;
         var12 = var2 + var4;
         var18.drawLine(var1, var20, var11, var12);
         var8 += 2;
      }

      this.a1002.drawRect(var1, var2, var3, var4);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void b(String var0) {
      CMidlet var10000;
      try {
         var10000 = CMidlet.a;
      } catch (Exception var10) {
         return;
      }

      CMidlet var1 = var10000;

      try {
         var14 = new StringBuffer;
      } catch (Exception var9) {
         return;
      }

      StringBuffer var2 = var14;

      try {
         var2./* $VF: Unable to resugar constructor */<init>();
      } catch (Exception var8) {
         return;
      }

      String var3 = "http://";
      StringBuffer var15 = var2;

      try {
         var16 = var15.append(var3);
      } catch (Exception var7) {
         return;
      }

      var2 = var16;
      StringBuffer var17 = var2;

      try {
         var18 = var17.append(var0);
      } catch (Exception var6) {
         return;
      }

      var2 = var18;

      try {
         var19 = var2.toString();
      } catch (Exception var5) {
         return;
      }

      String var13 = var19;
      var10000 = var1;

      try {
         var10000.platformRequest(var13);
      } catch (Exception var4) {
      }
   }

   private void b(Image var1, int var2, int var3, int var4) {
      int var5 = var1.getWidth();
      int var6 = var1.getHeight();
      int var7 = var4 & 4;
      if (var7 != 0) {
         var7 = var5 >> 1;
         var7 = var2 - var7;
      } else {
         var7 = var2;
      }

      int var8 = var4 & 8;
      if (var8 != 0) {
         var8 = var6 >> 1;
         var8 = var3 - var8;
      } else {
         var8 = var3;
      }

      int var9 = var4 & 1;
      if (var9 != 0) {
         var5 = var7 - var5;
      } else {
         var5 = var7;
      }

      var7 = var4 & 2;
      if (var7 != 0) {
         var6 = var8 - var6;
      } else {
         var6 = var8;
      }

      this.a1002.drawImage(var1, var5, var6, 0);
      this.a1002.setClip(0, 0, 240, 320);
   }

   private void b(Image var1, int var2, int var3, int var4, int var5) {
      int var6 = 0;
      Object var7 = null;
      int var8 = 0;

      while (true) {
         var7 = this.H1140;
         var6 = ((Object[])var7).length;
         if (var8 >= var6) {
            var6 = var3 - 10;
            int var24 = var4 - 25;
            this.p(var6, var24, var5);
            return;
         }

         var6 = this.H1140[var8][0] + var3;
         int var9 = this.bP;
         int var10 = var6 - var9;
         var6 = this.H1140[var8][1] + var4;
         var9 = this.bQ;
         int var11 = var6 - var9;
         var7 = this.H1140[var8];
         byte var23 = 2;
         int var12 = (((Object[])var7)[var23] + var5) * 16;
         byte var13 = 16;
         byte var14 = 16;
         this.a(var1, var10, var11, var12, 0, var13, var14, 0, 0);
         var6 = var8 + 1;
         var8 = var6;
      }
   }

   private void b(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      byte var20;
      byte var21;
      byte var22;
      byte var29;
      label43: {
         var29 = (byte)3;
         float var11 = 4.0E-45F;
         byte var12 = 3;
         float var13 = 4.0E-45F;
         byte var14 = 0;
         float var15 = 0.0F;
         byte var16 = 0;
         float var17 = 0.0F;
         boolean var19 = this.m(var8, var9);
         if (!var19) {
            switch (var2) {
               case 0:
               case 2:
                  var29 = 1;
                  var11 = Float.MIN_VALUE;
                  var14 = 2;
                  var15 = 3.0E-45F;
                  var20 = 0;
                  var21 = var12;
                  var22 = var14;
                  break label43;
               case 1:
               case 3:
                  var12 = 1;
                  var13 = Float.MIN_VALUE;
                  var16 = 2;
                  var17 = 3.0E-45F;
                  var20 = var12;
                  var21 = var16;
                  var22 = var29;
                  var29 = 0;
                  var11 = 0.0F;
                  break label43;
            }
         }

         var20 = 0;
         var21 = var12;
         var22 = var29;
         var29 = 0;
         var11 = 0.0F;
      }

      int var23 = var29;

      while (var23 < var22) {
         int var25 = var20;

         while (var25 < var21) {
            var29 = var23 << 4;
            byte[][] var18 = this.m1084;
            byte var48 = var18[var2][0];
            var29 = var29 * var48 + var3;
            var18 = this.m1084;
            byte[] var26 = var18[var2];
            float var56 = 3.0E-45F;
            var48 = var26[2];
            var29 += var48;
            int var24 = this.bP;
            int var54 = var29 - var24;
            var29 = var25 << 4;
            var18 = this.m1084;
            var48 = var18[var2][1];
            var29 = var29 * var48 + var4;
            var18 = this.m1084;
            var26 = var18[var2];
            float var60 = 4.0E-45F;
            var48 = var26[3];
            var29 += var48;
            var24 = this.bQ;
            var29 -= var24;
            int var58 = var29 + 13;
            switch (var7) {
               case 0:
                  int var66 = var5 * 16;
                  byte var70 = 16;
                  byte var72 = 16;
                  this.a(var1, var54, var58, var66, 0, var70, var72, 0, 0);
                  break;
               case 1:
                  var29 = 0;
                  float var46 = 0.0F;
                  switch (var2) {
                     case 0:
                     case 2:
                        var29 = var25;
                        break;
                     case 1:
                     case 3:
                        var29 = var23;
                  }

                  var29 = (var29 + var6) % 3 + 2;
                  int var65 = var29 * 16;
                  byte var69 = 16;
                  byte var71 = 16;
                  this.a(var1, var54, var58, var65, 0, var69, var71, 0, 0);
                  break;
               case 2:
                  float var45 = Float.MIN_VALUE;
                  var29 = 1 - var5;
                  int var64 = var29 * 16;
                  byte var27 = 16;
                  byte var28 = 16;
                  this.a(var1, var54, var58, var64, 0, var27, var28, 0, 0);
            }

            var29 = var25 + 1;
            var25 = var29;
         }

         var29 = var23 + 1;
         var23 = var29;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final boolean b() {
      boolean var1 = true;
      boolean var2 = false;
      RecordStore var3 = null;
      String var4 = "sanGuoTdData";
      ByteArrayInputStream var5 = null;
      String var10000 = var4;

      label174: {
         label180: {
            try {
               var44 = RecordStore.openRecordStore(var10000, false);
            } catch (Exception var30) {
               if (var3 == null) {
                  break label174;
               }
               break label180;
            }

            var3 = var44;
            byte var6 = 1;
            RecordStore var45 = var3;

            try {
               var46 = var45.getRecord(var6);
            } catch (Exception var29) {
               if (var3 == null) {
                  break label174;
               }
               break label180;
            }

            byte[] var33 = var46;

            try {
               var47 = new ByteArrayInputStream;
            } catch (Exception var28) {
               if (var3 == null) {
                  break label174;
               }
               break label180;
            }

            var5 = var47;
            ByteArrayInputStream var48 = var5;

            try {
               var48./* $VF: Unable to resugar constructor */<init>(var33);
            } catch (Exception var27) {
               if (var3 == null) {
                  break label174;
               }
               break label180;
            }

            try {
               var49 = new DataInputStream;
            } catch (Exception var26) {
               if (var3 == null) {
                  break label174;
               }
               break label180;
            }

            DataInputStream var34 = var49;
            DataInputStream var50 = var34;

            try {
               var50./* $VF: Unable to resugar constructor */<init>(var5);
            } catch (Exception var25) {
               if (var3 == null) {
                  break label174;
               }
               break label180;
            }

            int var7 = 0;

            label150:
            while (true) {
               try {
                  var51 = this.bG;
               } catch (Exception var21) {
                  if (var3 == null) {
                     break label174;
                  }
                  break;
               }

               int var8 = var51;

               try {
                  var52 = this.bH;
               } catch (Exception var20) {
                  if (var3 == null) {
                     break label174;
                  }
                  break;
               }

               int var9 = var52;
               var8 *= var9;
               if (var7 >= var8) {
                  var7 = 0;

                  while (true) {
                     try {
                        var56 = this.bG;
                     } catch (Exception var16) {
                        if (var3 == null) {
                           break label174;
                        }
                        break label150;
                     }

                     var8 = var56;

                     try {
                        var57 = this.bH;
                     } catch (Exception var15) {
                        if (var3 == null) {
                           break label174;
                        }
                        break label150;
                     }

                     var9 = var57;
                     var8 *= var9;
                     if (var7 >= var8) {
                        try {
                           var34.close();
                        } catch (Exception var14) {
                           if (var3 == null) {
                              break label174;
                           }
                           break label150;
                        }

                        try {
                           var5.close();
                        } catch (Exception var13) {
                           if (var3 == null) {
                              break label174;
                           }
                           break label150;
                        }

                        try {
                           var3.closeRecordStore();
                           return var1;
                        } catch (Exception var12) {
                           if (var3 == null) {
                              break label174;
                           }
                           break label150;
                        }
                     }

                     try {
                        var58 = this.D1162;
                     } catch (Exception var19) {
                        if (var3 == null) {
                           break label174;
                        }
                        break label150;
                     }

                     byte[] var43 = var58;

                     try {
                        var59 = var34.readByte();
                     } catch (Exception var18) {
                        if (var3 == null) {
                           break label174;
                        }
                        break label150;
                     }

                     byte var42 = var59;
                     byte[] var60 = var43;
                     int var61 = var7;

                     try {
                        var60[var61] = var42;
                     } catch (Exception var17) {
                        if (var3 == null) {
                           break label174;
                        }
                        break label150;
                     }

                     var7++;
                  }
               }

               try {
                  var53 = this.E1163;
               } catch (Exception var24) {
                  if (var3 == null) {
                     break label174;
                  }
                  break;
               }

               byte[] var10 = var53;

               try {
                  var54 = var34.readByte();
               } catch (Exception var23) {
                  if (var3 == null) {
                     break label174;
                  }
                  break;
               }

               byte var40 = var54;
               byte[] var55 = var10;
               int var10001 = var7;

               try {
                  var55[var10001] = var40;
               } catch (Exception var22) {
                  if (var3 == null) {
                     break label174;
                  }
                  break;
               }

               var7++;
            }
         }

         try {
            var3.closeRecordStore();
         } catch (Exception var11) {
         }
      }

      var2 = false;
      Object var32 = null;
      return var2;
   }

   private boolean b(int var1) {
      byte var2 = this.c(var1);
      if (var2) {
         byte[] var3 = this.E1163;
         var2 = var3[var1];
         byte var4 = 8;
         if (var2 < var4) {
            var3 = this.D1162;
            var2 = var3[var1];
            var4 = 6;
            if (var2 < var4) {
               boolean var11 = true;
               return var11;
            }
         }
      }

      this.m(var1);
      boolean var7 = false;
      Object var9 = null;
      return var7;
   }

   private boolean b(int var1, int var2) {
      int var3 = this.a(var1, var2);
      byte var4 = this.c(var3);
      if (var4) {
         byte[] var5 = this.E1163;
         var4 = var5[var3];
         byte var6 = 8;
         if (var4 < var6) {
            var5 = this.D1162;
            var4 = var5[var3];
            var6 = 6;
            if (var4 < var6) {
               return true;
            }
         }
      }

      this.m(var3);
      return false;
   }

   private int c() {
      while (true) {
         int var1 = this.d();
         byte var2 = 1;
         if (var1 != var2) {
            this.g1187 = null;
            return var1;
         }

         Thread.yield();
      }
   }

   private static int c(int var0) {
      short var1 = 225;
      short var2 = 135;
      short var3 = 45;
      if (var0 >= var3 && var0 < var2) {
         var3 = (byte)2;
      } else if (var0 >= var2 && var0 < var1) {
         var3 = (byte)3;
      } else {
         if (var0 >= var1) {
            var3 = 315;
            if (var0 < var3) {
               byte var6 = 0;
               return var6;
            }
         }

         var3 = (byte)1;
      }

      return var3;
   }

   private int c(int var1, int var2) {
      byte var3 = 8;
      int var4 = this.bI;
      if (var1 > var4) {
         var4 = this.bI - var3;
      } else {
         var4 = var1;
      }

      int var5 = this.bJ;
      if (var2 > var5) {
         var5 = this.bJ - var3;
      } else {
         var5 = var2;
      }

      byte[] var6 = this.E1163;
      var4 = this.a(var4, var5);
      return var6[var4] >> 1;
   }

   private int c(int var1, int var2, int var3) {
      byte var4 = 4;
      int var5;
      if (var3 == var4) {
         var5 = 0;
         Object var6 = null;
      } else {
         var5 = var3;
      }

      int var7 = var2 + 1;
      byte[][] var8 = this.w1123;
      int[] var13 = var8[var5];
      var5 = var13.length;
      int var9 = 3;
      var5 -= var9;
      if (var7 > var5) {
         if (var3 == 0 || var3 == var4) {
            var13 = this.c1107[var1];
            byte var16 = 5;
            var9 = this.a() & 3;
            var13[var16] = var9;
         }

         var5 = 0;
         var13 = null;
      } else {
         var5 = var7;
      }

      return var5;
   }

   private void c() {
      this.aP = 0;
      this.bt = 0;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void c(int var1) {
      Object var2 = null;
      Image[] var3 = this.a1013[var1];
      if (var3 == null) {
         Image[][] var10000;
         try {
            var10000 = this.a1013;
         } catch (Exception var29) {
            var29.printStackTrace();
            return;
         }

         Image[][] var31 = var10000;

         try {
            var43 = this.f;
         } catch (Exception var28) {
            var28.printStackTrace();
            return;
         }

         int[] var4 = var43;
         int[] var44 = var4;

         try {
            var45 = var44[var1];
         } catch (Exception var27) {
            var27.printStackTrace();
            return;
         }

         int var5 = var45;

         try {
            var10000 = new Image[var5];
         } catch (Exception var26) {
            var26.printStackTrace();
            return;
         }

         Image[] var35 = var10000;
         var10000 = var31;
         int var10001 = var1;

         try {
            var10000[var10001] = var35;
         } catch (Exception var25) {
            var25.printStackTrace();
            return;
         }

         try {
            this.getClass();
         } catch (Exception var24) {
            var24.printStackTrace();
            return;
         }

         try {
            var48 = this.a1014;
         } catch (Exception var23) {
            var23.printStackTrace();
            return;
         }

         String[] var32 = var48;
         String[] var49 = var32;

         try {
            var50 = var49[var1];
         } catch (Exception var22) {
            var22.printStackTrace();
            return;
         }

         String var33 = var50;

         try {
            var51 = Display.getResourceAsStream(var33);
         } catch (Exception var21) {
            var21.printStackTrace();
            return;
         }

         InputStream var34 = var51;
         var2 = null;
         var5 = 0;
         var4 = null;

         while (true) {
            try {
               var52 = this.f;
            } catch (Exception var12) {
               var12.printStackTrace();
               break;
            }

            int[] var6 = var52;
            int[] var53 = var6;

            try {
               var54 = var53[var1];
            } catch (Exception var11) {
               var11.printStackTrace();
               break;
            }

            int var7 = var54;
            if (var5 >= var7) {
               try {
                  var34.close();
               } catch (Exception var10) {
                  var10.printStackTrace();
               }
               break;
            }

            try {
               var55 = a(var34);
            } catch (Exception var20) {
               var20.printStackTrace();
               break;
            }

            label160: {
               var39 = var55;
               if (var2 != null) {
                  try {
                     var56 = ((Object[])var2).length;
                  } catch (Exception var19) {
                     var19.printStackTrace();
                     break;
                  }

                  int var8 = var56;
                  if (var8 >= var39) {
                     break label160;
                  }
               }

               try {
                  var57 = new byte[var39];
               } catch (Exception var18) {
                  var18.printStackTrace();
                  break;
               }

               var2 = var57;
            }

            boolean var40 = false;
            Object var9 = null;
            InputStream var58 = var34;
            byte[] var65 = (byte[])var2;
            byte var10002 = 0;

            try {
               var58.read(var65, var10002, var39);
            } catch (Exception var17) {
               var17.printStackTrace();
               break;
            }

            try {
               var10000 = this.a1013;
            } catch (Exception var16) {
               var16.printStackTrace();
               break;
            }

            var9 = var10000;
            var10000 = (Image[][])var9;

            try {
               var10000 = var10000[var1];
            } catch (Exception var15) {
               var15.printStackTrace();
               break;
            }

            var9 = var10000;
            byte[] var62 = (byte[])var2;
            int var66 = 0;

            try {
               var10000 = Image.createImage(var62, var66, var39);
            } catch (Exception var14) {
               var14.printStackTrace();
               break;
            }

            Image var38 = var10000;
            Image[] var64 = (Image[])var9;
            var66 = var5;

            try {
               var64[var66] = var38;
            } catch (Exception var13) {
               var13.printStackTrace();
               break;
            }

            var5++;
         }
      }
   }

   private void c(int var1, int var2) {
      this.a1002.setColor(6396370);
      this.a1002.fillRect(0, 309, 240, 2);
      Image[] var3 = this.a1013[3];
      byte var4 = 4;
      Image var5 = var3[var4];
      short var6 = 18;
      short var7 = 311;
      int var8 = 6396370;
      int var9 = 1;
      this.a(var5, var6, var7, var8, (boolean)var9);
      int var10 = -1;
      if (var1 != var10) {
         var3 = this.a1013[3];
         var4 = 2;
         var5 = var3[var4];
         var6 = (byte)1;
         var7 = 310;
         boolean var23 = false;
         var9 = var1 * 10;
         byte var11 = 18;
         byte var12 = 10;
         this.a(var5, var6, var7, 0, var9, var11, var12, 0, 0);
      }

      var10 = (byte)-1;
      if (var2 != var10) {
         var3 = this.a1013[3];
         var4 = 2;
         var5 = var3[var4];
         var6 = 221;
         var7 = 310;
         boolean var24 = false;
         var9 = var2 * 10;
         byte var29 = 18;
         byte var30 = 10;
         this.a(var5, var6, var7, 0, var9, var29, var30, 0, 0);
      }

      var10 = this.l;
      switch (var10) {
         case 4:
         case 5:
         case 20:
         case 21:
            this.f();
      }
   }

   private void c(int var1, int var2, int var3) {
      byte var4 = 25;
      byte var5 = 4;
      Image var6 = this.a1013[var5][var4];
      int var7 = this.a1013[var5][var4].getHeight() / 10;
      int var8 = var1 * var7;
      int var9 = this.a1013[var5][var4].getWidth();
      int var10 = this.a1013[var5][var4].getHeight() / 10;
      this.a(var6, var2, var3, 0, var8, var9, var10, 0, 0);
   }

   private void c(int var1, int var2, int var3, int var4) {
      byte var5 = 3;
      byte var6 = 2;
      byte var7 = 1;
      int[] var8 = this.q1100;
      byte var9 = (byte)var8[var3];
      int var14 = this.j(var9);
      if (var14) {
         int[][] var12 = this.c1107;
         int var10 = this.bt;
         var8 = var12[var10];
         var8[0] = var1;
         var8[var7] = var2;
         var8[var6] = var3;
         var8[5] = var4;
         var8[var5] = 0;
         var8[6] = 0;
         var8[4] = var5;
         var8[7] = 0;
         var8[8] = 0;
         var8[14] = -1;
         var8[15] = 0;
         var8[13] = 0;
         var8[9] = var4;
         var8[16] = 0;
         var8[17] = 0;
         int var11 = this.bt;
         this.c(var1, var2, var11, var3, (boolean)var7);
         var14 = this.bt + 1;
         this.bt = var14;
         this.bF = 0;
         this.aw = 0;
         this.b(var6);
      }
   }

   private void c(int var1, int var2, int var3, int var4, int var5) {
      Graphics var6 = this.a1002;
      int var7 = 15455661;
      var6.setColor(var7);
      switch (var5) {
         case 0:
            this.a1002.setColor(16580557);
            var6 = this.a1002;
            var7 = var3 - 1;
            var6.fillRect(var1, var2, var7, var4);
            Image var22 = this.a1013[3][8];
            int var30 = var22.getHeight();
            byte var28 = 0;
            Image var34 = null;

            while (var28 < var3) {
               this.a1002.setClip(var1, var2, var3, var4);
               Graphics var10 = this.a1002;
               Image var38 = this.a1013[3][8];
               int var43 = var1 + var28;
               var10.drawImage(var38, var43, var2, 0);
               var10 = this.a1002;
               var38 = this.a1013[3][8];
               var43 = var1 + var28;
               int var48 = var2 + var4 - var30 - 1;
               var10.drawImage(var38, var43, var48, 0);
               var28 += 50;
            }

            var34 = this.a1013[3][9];
            int var53 = var1 + 1;
            int var57 = var2 + var30;
            int var45 = var3 - 2;
            var30 <<= 1;
            int var49 = var4 - var30;
            this.a(var34, var53, var57, var45, var49);
            break;
         case 1:
            int var8 = 0;
            Object var19 = null;

            while (true) {
               byte var25 = 3;
               if (var8 >= var25) {
                  var19 = this.a1013[3];
                  var25 = 9;
                  Image var33 = (Image)((Object[])var19)[var25];
                  int var52 = var1 + 3;
                  int var56 = var2 + 3;
                  int var42 = var3 - 6;
                  byte var29 = 4;
                  int var47 = var4 - var29;
                  this.a(var33, var52, var56, var42, var47);
                  return;
               }

               Graphics var32 = this.a1002;
               int var51 = var1 + var8;
               int var55 = var2 + var8;
               int var40 = var8 << 1;
               var40 = var3 - var40 - 1;
               int var13 = var8 << 1;
               var13 = var4 - var13 + 1;
               var32.drawRect(var51, var55, var40, var13);
               var8++;
            }
         case 2:
            var6 = this.a1002;
            var7 = 16580557;
            var6.setColor(var7);
            this.a1002.fillRect(var1, var2, var3, var4);
            var6 = this.a1002;
            Image var9 = this.a1013[4][9];
            int var14 = var1 + var3;
            Image[] var11 = this.a1013[4];
            byte var12 = 9;
            int var15 = var11[var12].getWidth();
            var14 -= var15;
            boolean var54 = false;
            var11 = null;
            var6.drawImage(var9, var14, var2, 0);
            break;
         case 3:
            this.a1002.setColor(16580557);
            this.a1002.fillRect(var1, var2, var3, var4);
            Image var16 = this.a1013[4][9];
            byte var23 = 1;
            this.a(var16, var1, var2, var23);
      }
   }

   private void c(int var1, int var2, int var3, int var4, int var5, int var6) {
      byte var7 = 1;
      if (var4 == var7) {
         int var22 = 0;
         Object var8 = null;
         int var9 = 0;

         while (true) {
            var22 = (byte)3;
            if (var9 >= var22) {
               break;
            }

            var8 = this.a1013[29];
            byte var10 = 43;
            Image var11 = (Image)((Object[])var8)[var10];
            var22 = this.t1118[var1][0] + var2;
            byte[] var12 = this.s1117[var1];
            int var13 = var12[0] * var9 * 16;
            var22 += var13;
            var13 = this.bP;
            var13 = var22 - var13;
            var22 = this.t1118[var1][1] + var3;
            byte[] var14 = this.s1117[var1];
            int var15 = var14[1] * var9 * 16;
            var22 += var15;
            var15 = this.bQ;
            var15 = var22 - var15 + 13;
            boolean var16 = false;
            boolean var17 = false;
            byte var18 = 15;
            byte var19 = 20;
            boolean var20 = false;
            this.a(var11, var13, var15, 0, 0, var18, var19, 0, 0);
            var22 = var9 + 1;
            var9 = var22;
         }
      }

      var7 = 1;
      if (var6 == var7) {
         var7 = 3;
         if (var5 < var7) {
            int var31 = 0;
            Object var65 = null;
            int var77 = 0;

            while (true) {
               var31 = (byte)3;
               if (var77 >= var31) {
                  break;
               }

               var65 = this.a1013[29];
               byte var79 = 43;
               Image var84 = (Image)((Object[])var65)[var79];
               var31 = this.t1118[var1][0] + var2;
               byte[] var89 = this.s1117[var1];
               int var94 = var89[0] * var77 * 16;
               var31 += var94;
               var94 = this.bP;
               var94 = var31 - var94;
               var31 = this.t1118[var1][1] + var3 - 22;
               byte[] var105 = this.s1117[var1];
               int var108 = var105[1] * var77 * 16;
               var31 += var108;
               var108 = this.bQ;
               var108 = var31 - var108 + 13;
               boolean var121 = false;
               byte var126 = 20;
               byte var131 = 15;
               byte var136 = 42;
               boolean var141 = false;
               this.a(var84, var94, var108, 0, var126, var131, var136, 0, 0);
               var31 = var77 + 1;
               var77 = var31;
            }
         }
      }

      var7 = 1;
      if (var5 > var7) {
         var7 = 5;
         if (var5 < var7) {
            var7 = 1;
            if (var6 == var7) {
               var7 = 2;
               int var78 = var5 - var7;
               switch (var1) {
                  case 0:
                     int var59 = 0;
                     Object var75 = null;
                     int var148 = 0;

                     while (true) {
                        var59 = (byte)3;
                        if (var148 >= var59) {
                           return;
                        }

                        var75 = this.a1013[29];
                        byte var83 = 44;
                        Image var88 = (Image)((Object[])var75)[var83];
                        var59 = var148 * 16 + var2;
                        int var103 = this.bP;
                        var103 = var59 - var103;
                        var59 = var3 - 37;
                        int var119 = this.bQ;
                        var119 = var59 - var119 + 13;
                        boolean var125 = false;
                        byte var130 = this.h1121[var1][var78][0];
                        byte var135 = 16;
                        byte var140 = this.h1121[var1][var78][1];
                        boolean var145 = false;
                        this.a(var88, var103, var119, 0, var130, var135, var140, 0, 0);
                        var59 = var148 + 1;
                        var148 = var59;
                     }
                  case 1:
                     int var53 = 0;
                     Object var72 = null;
                     int var147 = 0;

                     while (true) {
                        var53 = (byte)3;
                        if (var147 >= var53) {
                           return;
                        }

                        var72 = this.a1013[29];
                        byte var82 = 45;
                        Image var87 = (Image)((Object[])var72)[var82];
                        var72 = this.u1119[var78];
                        Object var91 = null;
                        var53 = ((Object[])var72)[0] + var2;
                        int var101 = this.bP;
                        var101 = var53 - var101;
                        var53 = this.u1119[var78][1] + var3;
                        int var116 = var147 * 16;
                        var53 += var116;
                        var116 = this.bQ;
                        var116 = var53 - var116 + 13;
                        byte var124 = this.h1121[var1][var78][0];
                        boolean var129 = false;
                        byte var134 = this.h1121[var1][var78][1];
                        byte var139 = 18;
                        byte var144 = 1;
                        this.a(var87, var101, var116, var124, 0, var134, var139, var144, 0);
                        var53 = var147 + 1;
                        var147 = var53;
                     }
                  case 2:
                     int var48 = 0;
                     Object var70 = null;
                     int var146 = 0;

                     while (true) {
                        var48 = (byte)3;
                        if (var146 >= var48) {
                           return;
                        }

                        var70 = this.a1013[29];
                        byte var81 = 46;
                        Image var86 = (Image)((Object[])var70)[var81];
                        var48 = var146 * 16 + var2;
                        int var99 = this.bP;
                        var99 = var48 - var99;
                        var48 = var3 + 30;
                        int var114 = this.bQ;
                        var114 = var48 - var114 + 13;
                        boolean var123 = false;
                        byte var128 = this.h1121[var1][var78][0];
                        byte var133 = 15;
                        byte var138 = this.h1121[var1][var78][1];
                        boolean var143 = false;
                        this.a(var86, var99, var114, 0, var128, var133, var138, 0, 0);
                        var48 = var146 + 1;
                        var146 = var48;
                     }
                  case 3:
                     int var42 = 0;
                     Object var67 = null;
                     int var21 = 0;

                     while (true) {
                        var42 = (byte)3;
                        if (var21 >= var42) {
                           break;
                        }

                        var67 = this.a1013[29];
                        byte var80 = 45;
                        Image var85 = (Image)((Object[])var67)[var80];
                        var67 = this.v1120[var78];
                        Object var90 = null;
                        var42 = ((Object[])var67)[0] + var2;
                        int var97 = this.bP;
                        var97 = var42 - var97;
                        var42 = this.v1120[var78][1] + var3;
                        int var111 = var21 * 16;
                        var42 += var111;
                        var111 = this.bQ;
                        var111 = var42 - var111 + 13;
                        byte var122 = this.h1121[var1][var78][0];
                        boolean var127 = false;
                        byte var132 = this.h1121[var1][var78][1];
                        byte var137 = 18;
                        boolean var142 = false;
                        this.a(var85, var97, var111, var122, 0, var132, var137, 0, 0);
                        var42 = var21 + 1;
                        var21 = var42;
                     }
               }
            }
         }
      }
   }

   private final void c(int var1, int var2, int var3, int var4, boolean var5) {
      if (var5) {
         int var6 = 0;

         while (true) {
            byte[] var7 = this.o1098;
            int var8 = var7[var4];
            if (var6 >= var8) {
               break;
            }

            var8 = 0;
            var7 = null;

            while (true) {
               byte[] var9 = this.o1098;
               byte var10 = var9[var4];
               if (var8 >= var10) {
                  var6++;
                  break;
               }

               var10 = 110;
               if (var3 < var10) {
                  var9 = this.E1163;
                  int var11 = (var6 << 4) + var1;
                  int var12 = (var8 << 4) + var2;
                  var11 = this.a(var11, var12);
                  byte var31 = (byte)(var3 + 12);
                  var9[var11] = var31;
               } else {
                  var9 = this.E1163;
                  int var27 = (var6 << 4) + var1;
                  int var32 = (var8 << 4) + var2;
                  var27 = this.a(var27, var32);
                  byte var33 = (byte)(98 - var3);
                  var9[var27] = var33;
               }

               var8++;
            }
         }
      } else {
         int var13 = 0;

         while (true) {
            byte[] var15 = this.o1098;
            int var18 = var15[var4];
            if (var13 >= var18) {
               break;
            }

            var18 = 0;
            var15 = null;

            while (true) {
               byte[] var22 = this.o1098;
               byte var25 = var22[var4];
               if (var18 >= var25) {
                  var13++;
                  break;
               }

               var22 = this.E1163;
               int var29 = (var13 << 4) + var1;
               int var34 = (var18 << 4) + var2;
               var29 = this.a(var29, var34);
               byte var35 = 8;
               var22[var29] = var35;
               var18++;
            }
         }
      }
   }

   private void c(String var1) {
      int var2 = 0;
      if (var1 == null) {
         this.H(0);
      } else {
         int var3 = var1.length();
         this.H(var3);

         while (var2 < var3) {
            char var4 = var1.charAt(var2);
            this.I(var4);
            var2++;
         }
      }
   }

   private void c(Image var1, int var2, int var3, int var4) {
      byte var5 = 11;
      int var6 = var4 * 11;
      this.a(var1, var2, var3, var6, 0, var5, var5, 0, 0);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final boolean c() {
      boolean var1 = true;
      boolean var2 = false;
      RecordStore var3 = null;
      String var4 = "freeGame";
      ByteArrayInputStream var5 = null;
      String var10000 = var4;

      label118: {
         label124: {
            try {
               var29 = RecordStore.openRecordStore(var10000, false);
            } catch (Exception var23) {
               if (var3 == null) {
                  break label118;
               }
               break label124;
            }

            var3 = var29;
            byte var6 = 1;
            RecordStore var30 = var3;

            try {
               var31 = var30.getRecord(var6);
            } catch (Exception var22) {
               if (var3 == null) {
                  break label118;
               }
               break label124;
            }

            byte[] var26 = var31;

            try {
               var32 = new ByteArrayInputStream;
            } catch (Exception var21) {
               if (var3 == null) {
                  break label118;
               }
               break label124;
            }

            var5 = var32;
            ByteArrayInputStream var33 = var5;

            try {
               var33./* $VF: Unable to resugar constructor */<init>(var26);
            } catch (Exception var20) {
               if (var3 == null) {
                  break label118;
               }
               break label124;
            }

            try {
               var34 = new DataInputStream;
            } catch (Exception var19) {
               if (var3 == null) {
                  break label118;
               }
               break label124;
            }

            DataInputStream var27 = var34;
            DataInputStream var35 = var27;

            try {
               var35./* $VF: Unable to resugar constructor */<init>(var5);
            } catch (Exception var18) {
               if (var3 == null) {
                  break label118;
               }
               break label124;
            }

            int var7 = 0;

            while (true) {
               byte var8 = 9;
               if (var7 >= var8) {
                  try {
                     var27.close();
                  } catch (Exception var14) {
                     if (var3 == null) {
                        break label118;
                     }
                     break;
                  }

                  try {
                     var5.close();
                  } catch (Exception var13) {
                     if (var3 == null) {
                        break label118;
                     }
                     break;
                  }

                  try {
                     var3.closeRecordStore();
                     return var1;
                  } catch (Exception var12) {
                     if (var3 == null) {
                        break label118;
                     }
                     break;
                  }
               }

               try {
                  var36 = this.d1073;
               } catch (Exception var17) {
                  if (var3 == null) {
                     break label118;
                  }
                  break;
               }

               boolean[] var9 = var36;

               try {
                  var37 = var27.readBoolean();
               } catch (Exception var16) {
                  if (var3 == null) {
                     break label118;
                  }
                  break;
               }

               boolean var10 = var37;
               boolean[] var38 = var9;
               int var10001 = var7;

               try {
                  var38[var10001] = var10;
               } catch (Exception var15) {
                  if (var3 == null) {
                     break label118;
                  }
                  break;
               }

               var7++;
            }
         }

         try {
            var3.closeRecordStore();
         } catch (Exception var11) {
         }
      }

      var2 = false;
      Object var25 = null;
      return var2;
   }

   private boolean c(int var1) {
      byte[] var2 = this.E1163;
      int var3 = var2[var1] & 1;
      boolean var5;
      if (var3 == 0) {
         var5 = true;
      } else {
         var5 = false;
         var2 = null;
      }

      return var5;
   }

   private boolean c(int var1, int var2) {
      int var3 = this.a(var1, var2);
      byte[] var4 = this.E1163;
      byte var6 = var4[var3];
      byte var5 = 11;
      boolean var7;
      if (var6 == var5) {
         var7 = true;
      } else {
         var7 = false;
      }

      return var7;
   }

   private int d() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield a.g1187 Ljava/lang/String;
      // 004: astore 1
      // 005: aload 1
      // 006: ifnonnull 087
      // 009: aload 0
      // 00a: getfield a.f1186 Ljava/lang/String;
      // 00d: astore 1
      // 00e: aload 0
      // 00f: aload 1
      // 010: invokespecial a.b (Ljava/lang/String;)Ljava/lang/String;
      // 013: astore 2
      // 014: aload 1
      // 015: invokestatic a.a (Ljava/lang/String;)Ljava/lang/String;
      // 018: astore 3
      // 019: aload 2
      // 01a: invokestatic javax/microedition/io/Connector.open (Ljava/lang/String;)Ljavax/microedition/io/Connection;
      // 01d: astore 1
      // 01e: aload 1
      // 01f: checkcast javax/microedition/io/HttpConnection
      // 022: astore 1
      // 023: aload 0
      // 024: aload 1
      // 025: putfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 028: aload 0
      // 029: getfield a.c1190 B
      // 02c: istore 4
      // 02e: iload 4
      // 030: tableswitch 24 1 2 95 207
      // 048: new java/io/IOException
      // 04b: astore 1
      // 04c: aload 1
      // 04d: invokespecial java/io/IOException.<init> ()V
      // 050: aload 1
      // 051: athrow
      // 052: astore 1
      // 053: bipush 0
      // 054: istore 4
      // 056: aconst_null
      // 057: astore 1
      // 058: bipush 0
      // 059: istore 5
      // 05b: aconst_null
      // 05c: astore 2
      // 05d: aload 2
      // 05e: ifnull 065
      // 061: aload 2
      // 062: invokevirtual java/io/OutputStream.close ()V
      // 065: aload 1
      // 066: ifnull 06d
      // 069: aload 1
      // 06a: invokevirtual java/io/InputStream.close ()V
      // 06d: aload 0
      // 06e: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 071: astore 1
      // 072: aload 1
      // 073: ifnull 081
      // 076: aload 0
      // 077: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 07a: astore 1
      // 07b: aload 1
      // 07c: invokeinterface javax/microedition/io/Connection.close ()V 1
      // 081: bipush -1
      // 082: istore 4
      // 084: iload 4
      // 086: ireturn
      // 087: aload 0
      // 088: getfield a.g1187 Ljava/lang/String;
      // 08b: astore 1
      // 08c: goto 00e
      // 08f: aload 0
      // 090: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 093: astore 1
      // 094: ldc_w "GET"
      // 097: astore 2
      // 098: aload 1
      // 099: aload 2
      // 09a: invokeinterface javax/microedition/io/HttpConnection.setRequestMethod (Ljava/lang/String;)V 2
      // 09f: aload 0
      // 0a0: getfield a.D1176 Z
      // 0a3: istore 4
      // 0a5: iload 4
      // 0a7: ifeq 0bb
      // 0aa: aload 0
      // 0ab: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 0ae: astore 1
      // 0af: ldc_w "X-Online-Host"
      // 0b2: astore 2
      // 0b3: aload 1
      // 0b4: aload 2
      // 0b5: aload 3
      // 0b6: invokeinterface javax/microedition/io/HttpConnection.setRequestProperty (Ljava/lang/String;Ljava/lang/String;)V 3
      // 0bb: aload 0
      // 0bc: getfield a.H1188 [B
      // 0bf: astore 1
      // 0c0: aload 1
      // 0c1: ifnull 405
      // 0c4: aload 0
      // 0c5: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 0c8: astore 1
      // 0c9: aload 1
      // 0ca: invokeinterface javax/microedition/io/OutputConnection.openOutputStream ()Ljava/io/OutputStream; 1
      // 0cf: astore 1
      // 0d0: bipush 0
      // 0d1: istore 5
      // 0d3: aconst_null
      // 0d4: astore 2
      // 0d5: aload 0
      // 0d6: getfield a.H1188 [B
      // 0d9: astore 3
      // 0da: aload 3
      // 0db: arraylength
      // 0dc: istore 6
      // 0de: iload 5
      // 0e0: iload 6
      // 0e2: if_icmpge 143
      // 0e5: aload 0
      // 0e6: getfield a.H1188 [B
      // 0e9: astore 3
      // 0ea: aload 3
      // 0eb: iload 5
      // 0ed: baload
      // 0ee: istore 6
      // 0f0: aload 1
      // 0f1: iload 6
      // 0f3: invokevirtual java/io/OutputStream.write (I)V
      // 0f6: iload 5
      // 0f8: bipush 1
      // 0f9: iadd
      // 0fa: istore 5
      // 0fc: goto 0d5
      // 0ff: aload 0
      // 100: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 103: astore 1
      // 104: ldc_w "POST"
      // 107: astore 2
      // 108: aload 1
      // 109: aload 2
      // 10a: invokeinterface javax/microedition/io/HttpConnection.setRequestMethod (Ljava/lang/String;)V 2
      // 10f: goto 09f
      // 112: astore 1
      // 113: bipush 0
      // 114: istore 5
      // 116: aconst_null
      // 117: astore 2
      // 118: bipush 0
      // 119: istore 6
      // 11b: aconst_null
      // 11c: astore 3
      // 11d: aload 3
      // 11e: ifnull 125
      // 121: aload 3
      // 122: invokevirtual java/io/OutputStream.close ()V
      // 125: aload 2
      // 126: ifnull 12d
      // 129: aload 2
      // 12a: invokevirtual java/io/InputStream.close ()V
      // 12d: aload 0
      // 12e: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 131: astore 2
      // 132: aload 2
      // 133: ifnull 141
      // 136: aload 0
      // 137: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 13a: astore 2
      // 13b: aload 2
      // 13c: invokeinterface javax/microedition/io/Connection.close ()V 1
      // 141: aload 1
      // 142: athrow
      // 143: aload 1
      // 144: invokevirtual java/io/OutputStream.close ()V
      // 147: bipush 0
      // 148: istore 4
      // 14a: aconst_null
      // 14b: astore 1
      // 14c: aload 0
      // 14d: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 150: astore 2
      // 151: aload 2
      // 152: invokeinterface javax/microedition/io/HttpConnection.getResponseCode ()I 1
      // 157: istore 5
      // 159: aload 0
      // 15a: iload 5
      // 15c: putfield a.ca I
      // 15f: aload 0
      // 160: getfield a.ca I
      // 163: istore 5
      // 165: sipush 300
      // 168: istore 6
      // 16a: iload 5
      // 16c: iload 6
      // 16e: if_icmplt 1b3
      // 171: aload 0
      // 172: getfield a.ca I
      // 175: istore 5
      // 177: sipush 400
      // 17a: istore 6
      // 17c: iload 5
      // 17e: iload 6
      // 180: if_icmpge 1b3
      // 183: aload 0
      // 184: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 187: astore 2
      // 188: ldc_w "Location"
      // 18b: astore 3
      // 18c: aload 2
      // 18d: aload 3
      // 18e: invokeinterface javax/microedition/io/HttpConnection.getHeaderField (Ljava/lang/String;)Ljava/lang/String; 2
      // 193: astore 2
      // 194: aload 0
      // 195: aload 2
      // 196: putfield a.g1187 Ljava/lang/String;
      // 199: aload 0
      // 19a: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 19d: astore 1
      // 19e: aload 1
      // 19f: ifnull 1ad
      // 1a2: aload 0
      // 1a3: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 1a6: astore 1
      // 1a7: aload 1
      // 1a8: invokeinterface javax/microedition/io/Connection.close ()V 1
      // 1ad: bipush 1
      // 1ae: istore 4
      // 1b0: goto 084
      // 1b3: bipush 0
      // 1b4: istore 5
      // 1b6: aconst_null
      // 1b7: astore 2
      // 1b8: aload 0
      // 1b9: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 1bc: astore 3
      // 1bd: aload 3
      // 1be: iload 5
      // 1c0: invokeinterface javax/microedition/io/HttpConnection.getHeaderFieldKey (I)Ljava/lang/String; 2
      // 1c5: astore 3
      // 1c6: aload 3
      // 1c7: ifnonnull 211
      // 1ca: aload 0
      // 1cb: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 1ce: astore 2
      // 1cf: aload 2
      // 1d0: invokeinterface javax/microedition/io/InputConnection.openInputStream ()Ljava/io/InputStream; 1
      // 1d5: astore 2
      // 1d6: aload 0
      // 1d7: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 1da: astore 3
      // 1db: aload 3
      // 1dc: invokeinterface javax/microedition/io/ContentConnection.getLength ()J 1
      // 1e1: lstore 7
      // 1e3: lload 7
      // 1e5: l2i
      // 1e6: istore 6
      // 1e8: iload 6
      // 1ea: ifle 2df
      // 1ed: iload 6
      // 1ef: bipush 1
      // 1f0: iand
      // 1f1: istore 9
      // 1f3: iload 9
      // 1f5: ifeq 228
      // 1f8: new java/io/IOException
      // 1fb: astore 3
      // 1fc: aload 3
      // 1fd: invokespecial java/io/IOException.<init> ()V
      // 200: aload 3
      // 201: athrow
      // 202: astore 3
      // 203: aload 2
      // 204: astore 10
      // 206: bipush 0
      // 207: istore 5
      // 209: aconst_null
      // 20a: astore 2
      // 20b: aload 10
      // 20d: astore 1
      // 20e: goto 05d
      // 211: aload 0
      // 212: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 215: astore 3
      // 216: aload 3
      // 217: iload 5
      // 219: invokeinterface javax/microedition/io/HttpConnection.getHeaderField (I)Ljava/lang/String; 2
      // 21e: pop
      // 21f: iload 5
      // 221: bipush 1
      // 222: iadd
      // 223: istore 5
      // 225: goto 1b8
      // 228: bipush 0
      // 229: istore 9
      // 22b: aconst_null
      // 22c: astore 11
      // 22e: aload 0
      // 22f: aconst_null
      // 230: putfield a.I1189 [B
      // 233: iload 6
      // 235: newarray 8
      // 237: astore 11
      // 239: aload 0
      // 23a: aload 11
      // 23c: putfield a.I1189 [B
      // 23f: bipush 0
      // 240: istore 9
      // 242: aconst_null
      // 243: astore 11
      // 245: iload 9
      // 247: iload 6
      // 249: if_icmpge 26a
      // 24c: aload 0
      // 24d: getfield a.I1189 [B
      // 250: astore 12
      // 252: iload 6
      // 254: iload 9
      // 256: isub
      // 257: istore 13
      // 259: aload 2
      // 25a: aload 12
      // 25c: iload 9
      // 25e: iload 13
      // 260: invokevirtual java/io/InputStream.read ([BII)I
      // 263: istore 14
      // 265: iload 14
      // 267: ifge 2d5
      // 26a: aload 2
      // 26b: invokevirtual java/io/InputStream.close ()V
      // 26e: bipush 0
      // 26f: istore 5
      // 271: aconst_null
      // 272: astore 2
      // 273: aload 0
      // 274: getfield a.I1189 [B
      // 277: astore 3
      // 278: aload 3
      // 279: arraylength
      // 27a: istore 6
      // 27c: iload 5
      // 27e: iload 6
      // 280: if_icmpge 342
      // 283: aload 0
      // 284: getfield a.I1189 [B
      // 287: astore 3
      // 288: iload 5
      // 28a: bipush 1
      // 28b: ishr
      // 28c: istore 9
      // 28e: aload 0
      // 28f: getfield a.I1189 [B
      // 292: astore 12
      // 294: aload 12
      // 296: iload 5
      // 298: baload
      // 299: istore 14
      // 29b: iload 14
      // 29d: invokestatic a.e (I)I
      // 2a0: bipush 4
      // 2a1: ishl
      // 2a2: istore 14
      // 2a4: aload 0
      // 2a5: getfield a.I1189 [B
      // 2a8: astore 15
      // 2aa: iload 5
      // 2ac: bipush 1
      // 2ad: iadd
      // 2ae: istore 16
      // 2b0: aload 15
      // 2b2: iload 16
      // 2b4: baload
      // 2b5: istore 13
      // 2b7: iload 13
      // 2b9: invokestatic a.e (I)I
      // 2bc: istore 13
      // 2be: iload 14
      // 2c0: iload 13
      // 2c2: ior
      // 2c3: i2b
      // 2c4: istore 14
      // 2c6: aload 3
      // 2c7: iload 9
      // 2c9: iload 14
      // 2cb: bastore
      // 2cc: iload 5
      // 2ce: bipush 2
      // 2cf: iadd
      // 2d0: istore 5
      // 2d2: goto 273
      // 2d5: iload 9
      // 2d7: iload 14
      // 2d9: iadd
      // 2da: istore 9
      // 2dc: goto 245
      // 2df: new java/io/ByteArrayOutputStream
      // 2e2: astore 3
      // 2e3: sipush 2048
      // 2e6: istore 9
      // 2e8: aload 3
      // 2e9: iload 9
      // 2eb: invokespecial java/io/ByteArrayOutputStream.<init> (I)V
      // 2ee: bipush 64
      // 2f0: istore 9
      // 2f2: iload 9
      // 2f4: newarray 8
      // 2f6: astore 11
      // 2f8: bipush 0
      // 2f9: istore 14
      // 2fb: aconst_null
      // 2fc: astore 12
      // 2fe: bipush 64
      // 300: istore 13
      // 302: aload 2
      // 303: aload 11
      // 305: bipush 0
      // 306: iload 13
      // 308: invokevirtual java/io/InputStream.read ([BII)I
      // 30b: istore 14
      // 30d: iload 14
      // 30f: ifge 330
      // 312: aload 3
      // 313: invokevirtual java/io/ByteArrayOutputStream.close ()V
      // 316: aload 3
      // 317: invokevirtual java/io/ByteArrayOutputStream.toByteArray ()[B
      // 31a: astore 3
      // 31b: aload 0
      // 31c: aload 3
      // 31d: putfield a.I1189 [B
      // 320: goto 26a
      // 323: astore 10
      // 325: bipush 0
      // 326: istore 6
      // 328: aconst_null
      // 329: astore 3
      // 32a: aload 10
      // 32c: astore 1
      // 32d: goto 11d
      // 330: bipush 0
      // 331: istore 13
      // 333: aconst_null
      // 334: astore 15
      // 336: aload 3
      // 337: aload 11
      // 339: bipush 0
      // 33a: iload 14
      // 33c: invokevirtual java/io/ByteArrayOutputStream.write ([BII)V
      // 33f: goto 2f8
      // 342: aload 0
      // 343: getfield a.I1189 [B
      // 346: astore 2
      // 347: aload 2
      // 348: arraylength
      // 349: bipush 1
      // 34a: ishr
      // 34b: istore 5
      // 34d: iload 5
      // 34f: newarray 8
      // 351: astore 2
      // 352: aload 0
      // 353: getfield a.I1189 [B
      // 356: astore 3
      // 357: bipush 0
      // 358: istore 9
      // 35a: aconst_null
      // 35b: astore 11
      // 35d: bipush 0
      // 35e: istore 14
      // 360: aconst_null
      // 361: astore 12
      // 363: aload 0
      // 364: getfield a.I1189 [B
      // 367: astore 15
      // 369: aload 15
      // 36b: arraylength
      // 36c: bipush 1
      // 36d: ishr
      // 36e: istore 13
      // 370: aload 3
      // 371: bipush 0
      // 372: aload 2
      // 373: bipush 0
      // 374: iload 13
      // 376: invokestatic java/lang/System.arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V
      // 379: aload 0
      // 37a: aload 2
      // 37b: putfield a.I1189 [B
      // 37e: aload 0
      // 37f: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 382: astore 2
      // 383: aload 2
      // 384: invokeinterface javax/microedition/io/Connection.close ()V 1
      // 389: bipush 0
      // 38a: istore 5
      // 38c: aconst_null
      // 38d: astore 2
      // 38e: aload 0
      // 38f: aconst_null
      // 390: putfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 393: aload 0
      // 394: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 397: astore 1
      // 398: aload 1
      // 399: ifnull 3a7
      // 39c: aload 0
      // 39d: getfield a.a1193 Ljavax/microedition/io/HttpConnection;
      // 3a0: astore 1
      // 3a1: aload 1
      // 3a2: invokeinterface javax/microedition/io/Connection.close ()V 1
      // 3a7: bipush 0
      // 3a8: istore 4
      // 3aa: aconst_null
      // 3ab: astore 1
      // 3ac: goto 084
      // 3af: astore 2
      // 3b0: goto 065
      // 3b3: astore 1
      // 3b4: goto 06d
      // 3b7: astore 3
      // 3b8: goto 125
      // 3bb: astore 2
      // 3bc: goto 12d
      // 3bf: astore 2
      // 3c0: goto 141
      // 3c3: astore 2
      // 3c4: aload 1
      // 3c5: astore 3
      // 3c6: aload 2
      // 3c7: astore 1
      // 3c8: bipush 0
      // 3c9: istore 5
      // 3cb: aconst_null
      // 3cc: astore 2
      // 3cd: goto 11d
      // 3d0: astore 2
      // 3d1: bipush 0
      // 3d2: istore 6
      // 3d4: aconst_null
      // 3d5: astore 3
      // 3d6: aload 2
      // 3d7: astore 1
      // 3d8: bipush 0
      // 3d9: istore 5
      // 3db: aconst_null
      // 3dc: astore 2
      // 3dd: goto 11d
      // 3e0: astore 1
      // 3e1: goto 081
      // 3e4: astore 2
      // 3e5: aload 1
      // 3e6: astore 2
      // 3e7: bipush 0
      // 3e8: istore 4
      // 3ea: aconst_null
      // 3eb: astore 1
      // 3ec: goto 05d
      // 3ef: astore 2
      // 3f0: bipush 0
      // 3f1: istore 5
      // 3f3: aconst_null
      // 3f4: astore 2
      // 3f5: bipush 0
      // 3f6: istore 4
      // 3f8: aconst_null
      // 3f9: astore 1
      // 3fa: goto 05d
      // 3fd: astore 1
      // 3fe: goto 3a7
      // 401: astore 1
      // 402: goto 1ad
      // 405: bipush 0
      // 406: istore 4
      // 408: aconst_null
      // 409: astore 1
      // 40a: goto 14c
      // try (0 -> 2): 35 java/lang/Exception
      // try (0 -> 2): 140 null
      // try (5 -> 7): 35 java/lang/Exception
      // try (5 -> 7): 140 null
      // try (9 -> 11): 35 java/lang/Exception
      // try (9 -> 11): 140 null
      // try (12 -> 14): 35 java/lang/Exception
      // try (12 -> 14): 140 null
      // try (15 -> 17): 35 java/lang/Exception
      // try (15 -> 17): 140 null
      // try (18 -> 20): 35 java/lang/Exception
      // try (18 -> 20): 140 null
      // try (22 -> 24): 35 java/lang/Exception
      // try (22 -> 24): 140 null
      // try (24 -> 26): 35 java/lang/Exception
      // try (24 -> 26): 140 null
      // try (29 -> 30): 35 java/lang/Exception
      // try (29 -> 30): 140 null
      // try (31 -> 33): 35 java/lang/Exception
      // try (31 -> 33): 140 null
      // try (33 -> 35): 35 java/lang/Exception
      // try (33 -> 35): 140 null
      // try (46 -> 48): 510 java/io/IOException
      // try (50 -> 52): 512 java/io/IOException
      // try (57 -> 59): 542 java/io/IOException
      // try (60 -> 62): 542 java/io/IOException
      // try (66 -> 68): 35 java/lang/Exception
      // try (66 -> 68): 140 null
      // try (70 -> 72): 35 java/lang/Exception
      // try (70 -> 72): 140 null
      // try (76 -> 78): 35 java/lang/Exception
      // try (76 -> 78): 140 null
      // try (78 -> 80): 35 java/lang/Exception
      // try (78 -> 80): 140 null
      // try (83 -> 85): 35 java/lang/Exception
      // try (83 -> 85): 140 null
      // try (90 -> 92): 35 java/lang/Exception
      // try (90 -> 92): 140 null
      // try (92 -> 94): 35 java/lang/Exception
      // try (92 -> 94): 140 null
      // try (97 -> 99): 35 java/lang/Exception
      // try (97 -> 99): 140 null
      // try (100 -> 102): 35 java/lang/Exception
      // try (100 -> 102): 140 null
      // try (107 -> 109): 544 java/lang/Exception
      // try (107 -> 109): 520 null
      // try (110 -> 112): 544 java/lang/Exception
      // try (110 -> 112): 520 null
      // try (116 -> 118): 544 java/lang/Exception
      // try (116 -> 118): 520 null
      // try (120 -> 122): 544 java/lang/Exception
      // try (120 -> 122): 520 null
      // try (124 -> 126): 544 java/lang/Exception
      // try (124 -> 126): 520 null
      // try (131 -> 133): 35 java/lang/Exception
      // try (131 -> 133): 140 null
      // try (137 -> 139): 35 java/lang/Exception
      // try (137 -> 139): 140 null
      // try (151 -> 153): 514 java/io/IOException
      // try (155 -> 157): 516 java/io/IOException
      // try (162 -> 164): 518 java/io/IOException
      // try (165 -> 167): 518 java/io/IOException
      // try (169 -> 171): 544 java/lang/Exception
      // try (169 -> 171): 520 null
      // try (175 -> 177): 552 java/lang/Exception
      // try (175 -> 177): 530 null
      // try (178 -> 180): 552 java/lang/Exception
      // try (178 -> 180): 530 null
      // try (182 -> 184): 552 java/lang/Exception
      // try (182 -> 184): 530 null
      // try (184 -> 186): 552 java/lang/Exception
      // try (184 -> 186): 530 null
      // try (192 -> 194): 552 java/lang/Exception
      // try (192 -> 194): 530 null
      // try (200 -> 202): 552 java/lang/Exception
      // try (200 -> 202): 530 null
      // try (206 -> 208): 552 java/lang/Exception
      // try (206 -> 208): 530 null
      // try (210 -> 212): 552 java/lang/Exception
      // try (210 -> 212): 530 null
      // try (217 -> 219): 564 java/io/IOException
      // try (220 -> 222): 564 java/io/IOException
      // try (229 -> 231): 552 java/lang/Exception
      // try (229 -> 231): 530 null
      // try (233 -> 235): 552 java/lang/Exception
      // try (233 -> 235): 530 null
      // try (238 -> 240): 552 java/lang/Exception
      // try (238 -> 240): 530 null
      // try (241 -> 243): 552 java/lang/Exception
      // try (241 -> 243): 530 null
      // try (244 -> 246): 267 java/lang/Exception
      // try (244 -> 246): 426 null
      // try (247 -> 249): 267 java/lang/Exception
      // try (247 -> 249): 426 null
      // try (261 -> 262): 267 java/lang/Exception
      // try (261 -> 262): 426 null
      // try (263 -> 265): 267 java/lang/Exception
      // try (263 -> 265): 426 null
      // try (265 -> 267): 267 java/lang/Exception
      // try (265 -> 267): 426 null
      // try (277 -> 279): 552 java/lang/Exception
      // try (277 -> 279): 530 null
      // try (281 -> 284): 552 java/lang/Exception
      // try (281 -> 284): 530 null
      // try (294 -> 296): 267 java/lang/Exception
      // try (294 -> 296): 426 null
      // try (296 -> 298): 267 java/lang/Exception
      // try (296 -> 298): 426 null
      // try (300 -> 302): 267 java/lang/Exception
      // try (300 -> 302): 426 null
      // try (309 -> 311): 267 java/lang/Exception
      // try (309 -> 311): 426 null
      // try (319 -> 321): 267 java/lang/Exception
      // try (319 -> 321): 426 null
      // try (324 -> 326): 267 java/lang/Exception
      // try (324 -> 326): 426 null
      // try (330 -> 332): 552 java/lang/Exception
      // try (330 -> 332): 530 null
      // try (333 -> 335): 552 java/lang/Exception
      // try (333 -> 335): 530 null
      // try (339 -> 341): 552 java/lang/Exception
      // try (339 -> 341): 530 null
      // try (346 -> 348): 552 java/lang/Exception
      // try (346 -> 348): 530 null
      // try (350 -> 352): 552 java/lang/Exception
      // try (350 -> 352): 530 null
      // try (353 -> 355): 552 java/lang/Exception
      // try (353 -> 355): 530 null
      // try (358 -> 360): 552 java/lang/Exception
      // try (358 -> 360): 530 null
      // try (366 -> 368): 552 java/lang/Exception
      // try (366 -> 368): 530 null
      // try (369 -> 371): 552 java/lang/Exception
      // try (369 -> 371): 530 null
      // try (379 -> 381): 552 java/lang/Exception
      // try (379 -> 381): 530 null
      // try (391 -> 392): 267 java/lang/Exception
      // try (391 -> 392): 426 null
      // try (396 -> 398): 267 java/lang/Exception
      // try (396 -> 398): 426 null
      // try (400 -> 402): 267 java/lang/Exception
      // try (400 -> 402): 426 null
      // try (412 -> 414): 267 java/lang/Exception
      // try (412 -> 414): 426 null
      // try (417 -> 419): 267 java/lang/Exception
      // try (417 -> 419): 426 null
      // try (419 -> 421): 267 java/lang/Exception
      // try (419 -> 421): 426 null
      // try (423 -> 425): 267 java/lang/Exception
      // try (423 -> 425): 426 null
      // try (441 -> 443): 267 java/lang/Exception
      // try (441 -> 443): 426 null
      // try (444 -> 446): 552 java/lang/Exception
      // try (444 -> 446): 530 null
      // try (447 -> 449): 552 java/lang/Exception
      // try (447 -> 449): 530 null
      // try (452 -> 454): 552 java/lang/Exception
      // try (452 -> 454): 530 null
      // try (455 -> 457): 552 java/lang/Exception
      // try (455 -> 457): 530 null
      // try (466 -> 468): 552 java/lang/Exception
      // try (466 -> 468): 530 null
      // try (469 -> 471): 552 java/lang/Exception
      // try (469 -> 471): 530 null
      // try (478 -> 480): 552 java/lang/Exception
      // try (478 -> 480): 530 null
      // try (481 -> 483): 552 java/lang/Exception
      // try (481 -> 483): 530 null
      // try (483 -> 485): 552 java/lang/Exception
      // try (483 -> 485): 530 null
      // try (486 -> 488): 552 java/lang/Exception
      // try (486 -> 488): 530 null
      // try (493 -> 495): 552 java/lang/Exception
      // try (493 -> 495): 530 null
      // try (500 -> 502): 562 java/io/IOException
      // try (503 -> 505): 562 java/io/IOException
   }

   private int d(int var1) {
      byte var2 = 12;
      byte[] var3 = this.E1163;
      int var4 = var3[var1];
      if (var4 >= var2) {
         var3 = this.E1163;
         var4 = var3[var1] - var2;
      } else {
         var3 = this.E1163;
         byte var11 = var3[var1];
         var2 = -12;
         if (var11 <= var2) {
            byte[] var5 = this.E1163;
            var2 = var5[var1];
            var4 = 98 - var2;
         } else {
            var4 = -1;
         }
      }

      return var4;
   }

   private static int d(int var0, int var1, int var2) {
      return var1 * var2 + var0;
   }

   private void d() {
      byte var1 = 25;
      byte var2 = 15;
      byte var3 = 3;
      this.a1002.setColor(16580557);
      Graphics var4 = this.a1002;
      byte var5 = 13;
      short var6 = 210;
      int var7 = 297;
      var4.fillRect(var2, var5, var6, var7);
      int var8 = 0;
      Object var12 = null;

      while (true) {
         var5 = 10;
         if (var8 >= var5) {
            return;
         }

         Graphics var9 = this.a1002;
         Image var10 = this.a1013[var3][var1];
         var7 = (var8 << 5) + 13;
         var9.drawImage(var10, var2, var7, 0);
         Image var17 = this.a1013[var3][var1];
         var6 = 216;
         var7 = (var8 << 5) + 13;
         byte var11 = 1;
         this.a(var17, var6, var7, var11);
         var8++;
      }
   }

   private void d(int var1) {
      int var2 = 0;

      while (true) {
         byte var3 = 3;
         if (var2 >= var3) {
            return;
         }

         Graphics var4 = this.a1002;
         Image var5 = this.a1013[4][6];
         int var6 = this.u;
         int var7 = var2 * 176;
         var6 += var7;
         var7 = this.v + var1;
         var4.drawImage(var5, var6, var7, 0);
         var2++;
      }
   }

   private void d(int var1, int var2) {
      byte var3 = 3;
      byte var4 = 2;
      byte var5 = 1;
      byte var6 = 4;
      this.a1002.setClip(0, 0, 240, 320);
      Graphics var7 = this.a1002;
      Image var8 = this.a1013[var6][var5];
      int var9 = this.a1013[var6][var5].getHeight();
      var9 = var2 - var9;
      var7.drawImage(var8, var1, var9, 0);
      var7 = this.a1002;
      var8 = this.a1013[var6][var4];
      var9 = this.a1013[var6][var5].getWidth() + var1;
      int var10 = this.a1013[var6][var4].getHeight();
      var10 = var2 - var10;
      var7.drawImage(var8, var9, var10, 0);
      var7 = this.a1002;
      var8 = this.a1013[var6][0];
      var9 = this.a1013[var6][var5].getWidth() + var1;
      var10 = this.a1013[var6][var4].getWidth();
      var9 += var10;
      var10 = this.a1013[var6][0].getHeight();
      var10 = var2 - var10;
      var7.drawImage(var8, var9, var10, 0);
      var7 = this.a1002;
      var8 = this.a1013[var6][var3];
      var9 = this.a1013[var6][var5].getWidth() + var1;
      var10 = this.a1013[var6][var4].getWidth();
      var9 += var10;
      var10 = this.a1013[var6][0].getWidth();
      var9 = var9 + var10 + 15;
      var10 = this.a1013[var6][var3].getHeight();
      var10 = var2 - var10;
      var7.drawImage(var8, var9, var10, 0);
      this.a1002.setColor(14834304);
      this.a1002.fillRect(0, var2, 240, 20);
   }

   private void d(int var1, int var2, int var3) {
      long var4 = 1L;
      byte var6 = 24;
      byte var7 = 3;
      Graphics var8 = this.a1002;
      Image var9 = this.a1013[var7][var6];
      int var10 = ((int)(this.a1019 & var4) << 1) + var1;
      var8.drawImage(var9, var10, var3, 0);
      Image var12 = this.a1013[var7][var6];
      int var11 = (int)(this.a1019 & var4) << 1;
      var11 = var2 - var11;
      this.a(var12, var11, var3, 1);
   }

   private void d(int var1, int var2, int var3, int var4) {
      int var5 = 16382577;
      byte var6 = 3;
      int var7 = 4;
      byte var8 = 1;
      int var9 = this.o1098[var1] << 3;
      int var10 = 0;
      Image var11 = null;

      while (var10 < var7) {
         int var12 = var3 + var9;
         byte[] var13 = this.w1110;
         int var14 = var10 << 1;
         int var15 = var13[var14];
         var12 += var15;
         var15 = var4 + var9;
         byte[] var16 = this.w1110;
         int var17 = (var10 << 1) + 1;
         int var46 = var16[var17];
         var15 += var46;
         var46 = this.bu;
         this.p(var12, var15, var46);
         var10++;
      }

      if (var2 == var6) {
         var10 = this.bu;
         byte[] var18 = this.v1109;
         int var35 = var18.length;
         if (var10 < var35) {
            var10 = this.bu;
            if (var10 > 0) {
               var7 = 0;

               while (true) {
                  int var25 = 7;
                  if (var7 >= var25) {
                     return;
                  }

                  var25 = var3 + var9;
                  byte[][] var72 = this.p1108;
                  int var61 = this.bu - var8;
                  var18 = var72[var61];
                  var61 = var7 << 1;
                  int var39 = var18[var61];
                  var25 += var39;
                  var39 = this.bP;
                  var39 = var25 - var39;
                  var25 = var4 + var9;
                  byte[][] var44 = this.p1108;
                  int var50 = this.bu - var8;
                  byte[] var45 = var44[var50];
                  var50 = (var7 << 1) + 1;
                  int var63 = var45[var50];
                  var25 += var63;
                  var63 = this.bQ;
                  var63 = var25 - var63 + 13;
                  var11 = this.v1109;
                  var50 = this.bu - var8;
                  var50 = ((Object[])var11)[var50] << 1;
                  int var71 = 16422227;
                  this.g(var39, var63, var50, var71, var5);
                  var25 = var7 + 1;
                  var7 = var25;
               }
            }
         }

         var10 = this.bu;
         if (var10 == 0) {
            var11 = this.o1098;
            byte var23 = (byte)((Object[])var11)[var1];
            int var36 = 2;
            if (var23 == var36) {
               var23 = 19;
            } else {
               var23 = 25;
            }

            var36 = var3 + var9 - var23;
            int var58 = this.bP;
            var36 -= var58;
            var58 = var4 + var9 - var23;
            int var48 = this.bQ;
            var58 = var58 - var48 + 13;
            var48 = var23 << 1;
            int var70 = 16422227;
            this.g(var36, var58, var48, var70, var5);
         }
      } else if (var2 == var7) {
         var11 = this.a1013[var6][21];
         int var42 = var3 + var9;
         int var66 = this.bP;
         var42 -= var66;
         var66 = var4 + 13;
         int var54 = this.bQ;
         var66 -= var54;
         var54 = this.bu << 1;
         var66 -= var54;
         this.b(var11, var42, var66, var7);
      }
   }

   private void d(int var1, int var2, int var3, int var4, int var5) {
      Image var6 = this.a1013[3][15];
      int var7 = var1 << 4;
      this.a(var6, var2, var3, var7, 0, var4, var5);
   }

   private void d(int var1, int var2, int var3, int var4, int var5, int var6) {
      switch (var3) {
         case 0:
         case 4:
            byte var66 = 6;
            if (var6 == var66 && var5 >= 0) {
               var66 = 3;
               if (var5 <= var66) {
                  Image[] var29 = this.a1013[18];
                  int var41 = var5 + 1;
                  Image var43 = var29[var41];
                  byte[] var30 = this.y1125;
                  int var11 = var5 << 2;
                  var66 = var30[var11];
                  var11 = var1 + var66;
                  byte[] var31 = this.y1125;
                  int var47 = (var5 << 2) + 1;
                  var47 = var31[var47] + var2 + 13;
                  byte[][] var32 = this.w1123;
                  int var53 = 0;
                  Object var16 = null;
                  byte[] var33 = var32[0];
                  var66 = var33[var4];
                  if (var5 == 0) {
                     var53 = (byte)0;
                     var16 = null;
                  } else {
                     var16 = this.y1125;
                     int var14 = (var5 << 2) + 2;
                     var53 = (byte)((Object[])var16)[var14];
                  }

                  var53 *= var66;
                  boolean var60 = false;
                  byte[] var34 = this.y1125;
                  int var21 = (var5 << 2) + 2;
                  byte var22 = var34[var21];
                  byte[] var35 = this.y1125;
                  int var17 = (var5 << 2) + 3;
                  byte var76 = var35[var17];
                  this.a(var43, var11, var47, var53, 0, var22, var76, 0, 0);
                  var66 = 2;
                  if (var4 > var66) {
                     var66 = 10;
                     if (var4 < var66) {
                        Graphics var36 = this.a1002;
                        var43 = this.a1013[18][5];
                        byte[] var18 = this.y1125;
                        var47 = var5 << 2;
                        var11 = var18[var47] + var1 + 2;
                        byte[] var19 = this.y1125;
                        var53 = (var5 << 2) + 1;
                        var47 = var19[var53] + var2;
                        var53 = this.a1013[18][5].getHeight();
                        var47 -= var53;
                        var16 = this.w1123;
                        var60 = false;
                        byte var58 = (byte)((Object[])((Object[])var16)[0])[var4];
                        var47 = var47 - var58 + 13;
                        boolean var59 = false;
                        var16 = null;
                        var36.drawImage(var43, var11, var47, 0);
                     }
                  }
               }
            }
         case 1:
         case 6:
         case 7:
         default:
            break;
         case 2:
         case 3:
         case 5:
         case 8:
         case 9:
            int var7 = this.w1123[var3].length;
            Image[][] var8 = this.a1013;
            int var9 = var3 + 18;
            Image[] var23 = var8[var9];
            int var37 = 1;
            Image var10 = var23[var37];
            this.a(var10, var1, var2, var3, var4, var7);
            byte var15 = 8;
            if (var3 != var15) {
               var15 = 5;
               if (var3 != var15) {
                  return;
               }
            }

            byte[][] var24 = this.w1123;
            var37 = var3 - 1;
            var7 = var24[var37].length;
            var8 = this.a1013;
            var37 = var3 + 18;
            Image[] var26 = var8[var37];
            byte var40 = 2;
            var10 = var26[var40];
            var15 = 5;
            if (var3 == var15) {
               byte[] var27 = this.x1124;
               var15 = var27[var4];
            } else {
               var15 = 0;
               var8 = null;
            }

            int var12 = var2 + var15;
            var15 = 1;
            int var13 = var3 - var15;
            this.a(var10, var1, var12, var13, var4, var7);
      }
   }

   private void d(Image var1, int var2, int var3, int var4) {
      byte var5 = 0;
      int var6 = 0;

      while (true) {
         var5 = 3;
         if (var6 >= var5) {
            return;
         }

         int var14 = 0;
         int var7 = 0;

         while (true) {
            var14 = (byte)3;
            if (var7 >= var14) {
               var14 = var6 + 1;
               var6 = var14;
               break;
            }

            var14 = var6 << 4;
            int var8 = this.m1084[var2][0];
            var14 = var14 * var8 + var3;
            var8 = this.m1084[var2][2];
            var14 = var14 + var8 + 3;
            var8 = this.bP;
            int var9 = var14 - var8;
            var14 = var7 << 4;
            int var26 = this.m1084[var2][1];
            var14 = var14 * var26 + var4;
            var26 = this.m1084[var2][3];
            var14 = var14 + var26 + 3;
            var26 = this.bQ;
            int var10 = var14 - var26 + 13;
            byte var11 = 9;
            byte var12 = 9;
            this.a(var1, var9, var10, 0, 0, var11, var12, 0, 0);
            var14 = var7 + 1;
            var7 = var14;
         }
      }
   }

   private boolean d() {
      boolean var1 = true;
      int var2 = this.by;
      boolean var3;
      if (var2 <= 0) {
         this.s1088 = false;
         var3 = var1;
      } else {
         this.s1088 = var1;
         var3 = false;
      }

      return var3;
   }

   private boolean d(int var1) {
      byte var2 = 5;
      int var3 = 3;
      boolean var4 = true;
      byte var5 = 2;
      int[] var6 = this.c1107[var1];
      boolean[] var7 = this.f1106;
      int var8 = var6[var5];
      int var9 = var7[var8];
      if (!var9) {
         var9 = var6[var3];
         if (var9 < var2) {
            var9 = var6[var5];
            byte[] var10 = this.r1101;
            int var11 = var6[var3];
            var11 = this.a(var9, var10, var11);
            boolean var61 = this.j(var11);
            if (var61) {
               return var4;
            }

            this.o = 0;
         } else {
            var9 = var6[var3];
            if (var9 == var2) {
               var9 = var6[var5];
               if (var9 == 0) {
                  int var31 = this.e();
                  if (var31) {
                     var31 = var6[var5];
                     byte[] var54 = this.r1101;
                     var3 = var6[var3];
                     var31 = this.a(var31, var54, var3);
                     boolean var34 = this.j(var31);
                     if (var34) {
                        var7 = this.f1106;
                        int var63 = var6[var5];
                        var7[var63] = var4;
                        return var4;
                     }

                     this.o = 0;
                  } else {
                     this.o = var2;
                  }
               } else {
                  var9 = this.ac;
                  switch (var9) {
                     case 0:
                        var9 = var6[var5];
                        byte var26 = 6;
                        if (var9 < var26) {
                           var7 = this.f1106;
                           int var45 = var7[0];
                           if (var45) {
                              var45 = var6[var5];
                              byte[] var57 = this.r1101;
                              var3 = var6[var3];
                              var45 = this.a(var45, var57, var3);
                              boolean var48 = this.j(var45);
                              if (var48) {
                                 var7 = this.f1106;
                                 int var67 = var6[var5];
                                 var7[var67] = var4;
                                 return var4;
                              }

                              this.o = 0;
                           } else {
                              byte var68 = 6;
                              this.o = var68;
                           }
                        } else {
                           var9 = var6[var5];
                           byte[] var58 = this.r1101;
                           var3 = var6[var3];
                           var9 = this.a(var9, var58, var3);
                           boolean var51 = this.j(var9);
                           if (var51) {
                              var7 = this.f1106;
                              int var69 = var6[var5];
                              var7[var69] = var4;
                              return var4;
                           }

                           this.o = 0;
                        }
                        break;
                     case 1:
                        var9 = var6[var5];
                        byte var25 = 6;
                        if (var9 < var25) {
                           var9 = var6[var5];
                           byte[] var55 = this.r1101;
                           var3 = var6[var3];
                           var9 = this.a(var9, var55, var3);
                           boolean var39 = this.j(var9);
                           if (var39) {
                              var7 = this.f1106;
                              int var64 = var6[var5];
                              var7[var64] = var4;
                              return var4;
                           }

                           this.o = 0;
                        } else {
                           var7 = this.f1106;
                           int var40 = var7[0];
                           if (var40) {
                              var40 = var6[var5];
                              byte[] var56 = this.r1101;
                              var3 = var6[var3];
                              var40 = this.a(var40, var56, var3);
                              boolean var43 = this.j(var40);
                              if (var43) {
                                 var7 = this.f1106;
                                 int var65 = var6[var5];
                                 var7[var65] = var4;
                                 return var4;
                              }

                              this.o = 0;
                           } else {
                              byte var66 = 6;
                              this.o = var66;
                           }
                        }
                  }
               }
            } else {
               byte var70 = 4;
               this.o = var70;
            }
         }
      } else {
         var9 = var6[var3];
         if (var9 < var2) {
            var9 = var6[var5];
            byte[] var59 = this.r1101;
            int var71 = var6[var3];
            var71 = this.a(var9, var59, var71);
            boolean var73 = this.j(var71);
            if (var73) {
               return var4;
            }

            this.o = 0;
         } else {
            byte var74 = 4;
            this.o = var74;
         }
      }

      boolean var62 = false;
      var6 = null;
      return var62;
   }

   private boolean d(int var1, int var2) {
      int var3 = this.a(var1, var2);
      byte[] var4 = this.E1163;
      var3 = var4[var3] & 1;
      boolean var6;
      if (var3 == 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      return var6;
   }

   private static final int e(int var0) {
      byte var1 = 97;
      byte var2 = 65;
      byte var3 = 48;
      if (var0 >= var3) {
         byte var4 = 57;
         if (var0 <= var4) {
            return var0 - var3;
         }
      }

      if (var0 >= var1) {
         byte var6 = 122;
         if (var0 <= var6) {
            return var0 - var1 + 10;
         }
      }

      if (var0 >= var2) {
         byte var7 = 90;
         if (var0 <= var7) {
            return var0 - var2 + 10;
         }
      }

      Exception var5 = new Exception();
      throw var5;
   }

   private void e() {
      this.p();
      this.a1002.setColor(12493976);
      this.a1002.fillRect(0, 13, 240, 297);
      this.d();
   }

   private final void e(int var1) {
      while (true) {
         int var2 = this.am;
         if (var2 >= var1) {
            var2 = this.am;
            byte var3 = 100;
            if (var2 == var3) {
               this.m1033 = false;
               this.am = 0;
            }

            return;
         }

         var2 = this.am + 1;
         this.am = var2;
         boolean var5 = true;
         this.m1033 = var5;
         this.repaint();
         this.serviceRepaints();
      }
   }

   private void e(int var1, int var2) {
      byte var3 = 5;
      byte var4 = 4;
      int var5 = 0;

      while (true) {
         byte var6 = 15;
         if (var5 >= var6) {
            return;
         }

         Graphics var7 = this.a1002;
         Image var8 = this.a1013[var4][var4];
         int var9 = this.a1013[var4][var4].getWidth() * var5 + var1;
         Image var10 = this.a1013[var4][var4];
         int var11 = var10.getHeight();
         var11 = var2 - var11;
         var7.drawImage(var8, var9, var11, 0);
         var7 = this.a1002;
         var8 = this.a1013[var4][var3];
         Image var12 = this.a1013[var4][var3];
         var9 = var12.getWidth() * var5 + var1;
         var7.drawImage(var8, var9, var2, 0);
         var5++;
      }
   }

   private void e(int var1, int var2, int var3) {
      Image var4 = this.a1013[4][17];
      int var5 = var1 * 12;
      this.a(var4, var2, var3, 0, var5, 20, 12, 0, 0);
   }

   private void e(int var1, int var2, int var3, int var4) {
      short var5 = 240;
      switch (var3) {
         case 0:
         case 1:
         case 3:
         case 4:
         case 5:
         case 7:
            this.a1002.setClip(0, 13, var5, 276);
            Graphics var6 = this.a1002;
            int[] var7 = this.l1116;
            int var8 = this.aN;
            int var9 = var7[var8];
            var6.setColor(var9);
            byte[] var14 = this.t1103;
            int var10 = this.a(var3, var14, var4);
            var6 = this.a1002;
            byte[] var16 = this.o1098;
            var9 = (var16[var3] << 3) + var1 - var10;
            var8 = this.bP;
            var9 -= var8;
            byte[] var11 = this.o1098;
            var8 = (var11[var3] << 3) + var2 - var10;
            int var12 = this.bQ;
            var8 = var8 - var12 + 13;
            var12 = var10 << 1;
            var10 <<= 1;
            short var13 = 360;
            var6.drawArc(var9, var8, var12, var10, 0, var13);
         case 2:
         case 6:
         default:
            this.a1002.setClip(0, 0, var5, 320);
      }
   }

   private void e(int var1, int var2, int var3, int var4, int var5) {
      Graphics var6 = this.a1002;
      var6.setColor(7438477);
      int var7 = this.o;
      int var8 = -1;
      if (var7 == var8) {
         byte var11 = 17;
         if (var1 == var11) {
            var8 = this.ay;
            this.b(var8, var2, var3, var4, var5);
         } else {
            String[] var10 = this.b1015;
            var8 = var1 + 2;
            String var9 = var10[var8];
            this.a(var9, 0, var2, var3, var4, var5);
         }
      } else {
         var8 = this.o;
         this.a(var8, var2, var3, var4, var5);
      }
   }

   private void e(Image var1, int var2, int var3, int var4) {
      byte var5 = 0;
      int var6 = 0;

      while (true) {
         var5 = 3;
         if (var6 >= var5) {
            return;
         }

         int var16 = 0;
         int var7 = 0;

         while (true) {
            var16 = (byte)3;
            if (var7 >= var16) {
               var16 = var6 + 1;
               var6 = var16;
               break;
            }

            var16 = var6 << 4;
            int var8 = this.m1084[var2][0];
            var16 = var16 * var8 + var3;
            byte[] var9 = this.m1084[var2];
            var8 = var9[2];
            var16 += var8;
            var8 = var7 << 4;
            int var10 = this.m1084[var2][1];
            var8 = var8 * var10 + var4;
            var10 = this.m1084[var2][3];
            var8 += var10;
            byte[] var11 = this.D1162;
            int var12 = this.a(var16, var8);
            var10 = var11[var12];
            int var33 = 6;
            if (var10 >= var33) {
               var10 = this.bP;
               var10 = var16 - var10;
               var16 = this.bQ;
               var16 = var8 - var16;
               var33 = var16 + 13;
               byte var13 = 15;
               byte var14 = 16;
               this.a(var1, var10, var33, 0, 0, var13, var14, 0, 0);
            }

            var16 = var7 + 1;
            var7 = var16;
         }
      }
   }

   private boolean e() {
      int var1 = 0;

      while (true) {
         byte var2 = 5;
         if (var1 >= var2) {
            var4 = true;
            break;
         }

         boolean[] var3 = this.a1056;
         boolean var5 = var3[var1];
         if (!var5) {
            var4 = false;
            break;
         }

         var1++;
      }

      return var4;
   }

   private boolean e(int var1) {
      byte var2 = 6;
      byte var3 = 3;
      byte var4 = 1;
      byte var5 = 2;
      int[][] var6 = this.c1107;
      int[] var7 = var6[var1];
      int var8 = var7[0];
      int[] var9 = this.o1098;
      int var10 = var7[var5];
      int var11 = var9[var10] << 3;
      int var12 = var8 + var11;
      var8 = var7[var4];
      var9 = this.o1098;
      var10 = var7[var5];
      var11 = var9[var10] << 3;
      int var13 = var8 + var11;
      var8 = var7[var5];
      var9 = this.t1103;
      var10 = var7[var3];
      int var14 = this.a(var8, var9, var10);
      var8 = var7[var5];
      label64:
      switch (var8) {
         case 0:
         case 1:
         case 3:
         case 4:
         case 5:
         case 7:
            int var81 = 0;

            while (true) {
               var8 = this.aP;
               if (var81 >= var8) {
                  var8 = var7[4];
                  if (var8 == var2) {
                     var8 = var7[14];
                     if (var8 > 0) {
                        var8 = var7[14];
                        int var79 = 10;
                        if (var8 < var79) {
                           byte var51 = 14;
                           var79 = var7[var51] + 1;
                           var7[var51] = var79;
                        }
                     }
                  }
                  break label64;
               }

               var6 = this.b1066;
               var9 = this.o1153;
               var11 = var9[var81];
               int[] var82 = var6[var11];
               var11 = var82[0];
               var10 = var82[var4];
               int var38 = this.a(var11, var10, var12, var13, var14);
               if (var38) {
                  var38 = f(var82[8]);
                  if (var38) {
                     var38 = var7[var5];
                     int[] var57 = this.u1104;
                     var10 = var7[var3];
                     var38 = this.a(var38, (byte[])var57, var10);
                     var7[var2] = var38;
                     var38 = var7[4];
                     if (var38 == var2) {
                        byte var44 = 14;
                        var11 = var7[var44] + 1;
                        var7[var44] = var11;
                        if (var11 <= var3) {
                           return (boolean)var4;
                        }

                        var44 = 14;
                        byte var77 = 10;
                        var7[var44] = var77;
                     }

                     byte var46 = 8;
                     var57 = this.o1153;
                     var11 = var57[var81];
                     var7[var46] = var11;
                     this.v(var1);
                     return (boolean)var4;
                  }
               }

               var38 = var81 + 1;
               var81 = var38;
            }
         case 2:
         case 6:
            var8 = var7[0];
            var11 = var7[var4];
            var10 = var7[5];
            int var34 = this.a(var8, var11, var10, false);
            if (var34) {
               var34 = var7[var5];
               var9 = this.u1104;
               var10 = var7[var3];
               var34 = this.a(var34, var9, var10);
               var7[var2] = var34;
               this.v(var1);
            }
            break;
         case 8:
         case 9:
            var8 = var7[var5];
            var11 = var7[var3];
            int var23 = this.p(var8, var11);
            if (var23) {
               int var15 = 0;

               while (true) {
                  var23 = this.aP;
                  if (var15 >= var23) {
                     break;
                  }

                  int[] var16 = this.b1066[var15];
                  var11 = var16[0];
                  var10 = var16[var4];
                  int var25 = this.a(var11, var10, var12, var13, var14);
                  if (var25) {
                     var25 = f(var16[8]);
                     if (var25) {
                        var25 = (byte)15;
                        byte var71 = 48;
                        var16[var25] = var71;
                     }
                  }

                  var25 = var15 + 1;
                  var15 = var25;
               }
            }

            var23 = var7[0];
            var11 = var7[var4];
            var10 = var7[5];
            int var30 = this.a(var23, var11, var10, (boolean)var4);
            if (var30) {
               var30 = var7[var5];
               byte[] var54 = this.u1104;
               var10 = var7[var3];
               var30 = this.a(var30, var54, var10);
               var7[var2] = var30;
               this.v(var1);
            }
      }

      byte var47 = 0;
      var6 = null;
      return (boolean)var47;
   }

   private boolean e(int var1, int var2) {
      int var3 = this.a(var1, var2);
      byte[] var4 = this.E1163;
      byte var6 = var4[var3];
      byte var5 = 8;
      boolean var7;
      if (var6 == var5) {
         var7 = true;
      } else {
         var7 = false;
      }

      return var7;
   }

   private void f() {
      byte var1 = 10;
      byte var2 = 7;
      byte var3 = 3;
      short var4 = 310;
      int var5 = this.a1007;
      int var6 = this.b1008;
      if (var5 > var6) {
         var5 = this.a1007;
         var6 = this.b1008;
         var5 /= var6;
         if (var5 > var1) {
            byte var19 = 30;
            this.p = var19;
         } else {
            byte var20 = 25;
            this.p = var20;
         }

         var6 = this.p;
         int var7 = 240 - var6 >> 1;
         this.a1002.setColor(16580557);
         this.a1002.setClip(0, 0, 240, 320);
         Graphics var8 = this.a1002;
         var6 = this.p;
         var8.fillRect(var7, var4, var6, var1);
         Image var9 = this.a1013[var3][13];
         int var10 = var7 + 10;
         byte var11 = 50;
         this.a(var9, var10, 312, var11, 0, var2, var2, 0, 0);
         Image var35 = this.a1013[var3][24];
         var6 = var7 + 8;
         long var12 = this.a1019;
         long var14 = 1L;
         var12 &= var14;
         var10 = ((int)var12 << 1) + 302;
         var1 = 6;
         this.a(var35, var6, var10, var1);
         var5 = this.c;
         var6 = this.b1008;
         var5 = var5 / var6 + 1;
         var6 = var7 + 2;
         this.b(var5, var6, var4);
         var5 = this.a1007;
         var6 = this.b1008;
         var5 = var5 + var6 - 1;
         var6 = this.b1008;
         var5 /= var6;
         var6 = var7 + 18;
         this.b(var5, var6, var4);
      }
   }

   private void f(int var1) {
      if (var1 >= 0) {
         byte var2 = this.a1038;
         if (var1 < var2) {
            int[] var3 = this.a1039[var1];
            int[][] var4 = this.a1039;
            int[][] var5 = this.a1039;
            byte var6 = this.a1038;
            byte var7 = 1;
            var6 = (byte)(var6 - var7);
            this.a1038 = var6;
            int[] var17 = var5[var6];
            var4[var1] = var17;
            var4 = this.a1039;
            byte var8 = this.a1038;
            var4[var8] = var3;
            this.a1040[var1] = null;
            Image[] var11 = this.a1040;
            Image[] var15 = this.a1040;
            var8 = this.a1038;
            Image var16 = var15[var8];
            var11[var1] = var16;
            Image[] var12 = this.a1040;
            byte var9 = this.a1038;
            var12[var9] = null;
         }
      } else {
         boolean var10 = false;
         Object var13 = null;
         this.a1038 = 0;
         this.a1040 = null;
      }
   }

   private void f(int var1, int var2) {
      int var3 = this.n1036;
      if (!var3) {
         this.x();
         var3 = (boolean)1;
         this.n1036 = var3;
      }

      this.z();
      if (var1 != 0) {
         var3 = (byte)18;
         if (var2 >= var3) {
            var3 = (byte)18;
            if (var2 >= var3) {
               var3 = (byte)31;
               if (var2 < var3) {
                  boolean var68 = false;
                  Object var87 = null;
                  var3 = this.ao;
                  byte[] var250 = this.c1037;
                  int var125 = var2 - 10 << 1;
                  int var100 = var250[var125] + var3;
                  short var126 = 320;
                  byte var143 = 3;
                  boolean var165 = false;
                  Object var179 = null;
                  byte var193 = 4;
                  var3 = this.ao;
                  byte[] var206 = this.c1037;
                  int var218 = var2 - 10 << 1;
                  int var227 = var206[var218] + var3;
                  var218 = this.g1035[2];
                  byte var52 = 10;
                  int var236 = var2 - var52;
                  byte var244 = -1;
                  this.a(null, var100, var126, var143, 0, var193, var227, var218, var236, var244);
               }
            }

            switch (var2) {
               case 50:
                  byte var73 = 2;
                  byte var105 = 2;
                  byte var131 = 4;
                  byte var148 = 4;
                  byte var170 = 4;
                  byte var198 = 1;
                  this.b(var73, var105, var131, var148, var170, var198);
                  break;
               case 51:
                  byte var72 = 3;
                  byte var104 = 2;
                  byte var130 = 4;
                  byte var147 = 4;
                  byte var169 = 4;
                  byte var197 = 1;
                  this.b(var72, var104, var130, var147, var169, var197);
                  break;
               case 52:
                  byte var71 = 4;
                  byte var103 = 2;
                  byte var129 = 4;
                  byte var146 = 4;
                  byte var168 = 4;
                  byte var196 = 1;
                  this.b(var71, var103, var129, var146, var168, var196);
                  break;
               case 58:
                  Object var88 = null;
                  this.b(0, 1, 0, 1, 1000, 1000);
                  byte var70 = 1;
                  byte var102 = 2;
                  byte var128 = 4;
                  byte var145 = 4;
                  byte var167 = 4;
                  byte var195 = 1;
                  this.b(var70, var102, var128, var145, var167, var195);
                  break;
               case 63:
                  byte var69 = 15;
                  byte var101 = 3;
                  boolean var127 = false;
                  byte var144 = 4;
                  byte var166 = -10;
                  int var194 = this.g1035[2];
                  this.b(var69, var101, 0, var144, var166, var194);
            }

            byte var53 = 52;
            if (var2 > var53) {
               var53 = 63;
               if (var2 < var53) {
                  int var228 = var2 - 52;
                  int var74 = var228 + 4;
                  int var199 = this.g1035[2];
                  this.b(var74, 3, 0, 4, -10, var199);
                  var53 = 26;
                  var74 = var53 - var228;
                  byte var106 = 3;
                  boolean var132 = false;
                  byte var149 = 4;
                  short var171 = 240;
                  var199 = this.g1035[2];
                  this.b(var74, var106, 0, var149, var171, var199);
                  return;
               }
            }

            return;
         }
      }

      switch (var2) {
         case 1:
            if (var1 == 0) {
               boolean var30 = false;
               Object var246 = null;
               byte var61 = 1;
               this.g(0, var61);
            } else {
               byte var31 = 1;
               byte var62 = 1;
               this.g(var31, var62);
            }

            Image[] var247 = this.a1013[1];
            byte var63 = 1;
            Image var82 = var247[var63];
            byte var95 = 120;
            boolean var117 = false;
            byte var138 = 1;
            byte var160 = 12;
            byte var188 = 4;
            byte var222 = 120;
            int var209 = this.g1035[0];
            boolean var231 = false;
            byte var239 = -1;
            this.a(var82, var95, 0, var138, var160, var188, var222, var209, 0, var239);
            break;
         case 5:
            boolean var29 = false;
            this.f(0);
            Image[] var245 = this.a1013[1];
            boolean var60 = false;
            Image var81 = var245[0];
            byte var94 = 120;
            int var116 = this.g1035[0];
            byte var137 = 2;
            byte var159 = 12;
            byte var187 = 4;
            byte var221 = 4;
            boolean var208 = false;
            boolean var230 = false;
            byte var238 = -1;
            this.a(var81, var94, var116, var137, var159, var187, var221, 0, 0, var238);
            break;
         case 8:
            Image var76 = this.a1013[1][5];
            var3 = this.g1035[0];
            int var111 = var3 + 2;
            Object var201 = null;
            this.a(var76, 120, var111, 0, 12, 0, 0, 0, 0, 0);
            var76 = this.a1013[1][2];
            var111 = this.g1035[1];
            this.a(var76, 90, var111, 2, 4, 4, 4, 0, 0, -1);
            var76 = this.a1013[1][3];
            var111 = this.g1035[1];
            this.a(var76, 120, var111, 2, 4, 4, 4, 0, 0, -1);
            var76 = this.a1013[1][4];
            var111 = this.g1035[1];
            this.a(var76, 150, var111, 2, 4, 4, 4, 0, 0, -1);
            Image[] var17 = this.a1013[1];
            byte var59 = 6;
            var76 = var17[var59];
            byte var93 = 15;
            var111 = this.g1035[1];
            byte var136 = 1;
            byte var158 = 12;
            byte var186 = 3;
            int var220 = this.ao;
            int var207 = this.g1035[2];
            boolean var229 = false;
            byte var237 = -1;
            this.a(var76, var93, var111, var136, var158, var186, var220, var207, 0, var237);
            break;
         case 10:
            byte var27 = 5;
            this.f(var27);
            Object var5 = null;
            int var91 = this.ao;
            int var109 = this.g1035[2];
            Object var174 = null;
            boolean var14 = false;
            Object var12 = null;
            boolean var13 = false;
            boolean var15 = false;
            byte var16 = -1;
            this.a(null, var91, var109, 3, 0, 0, 0, 0, 0, var16);
            byte var58 = 5;
            byte var92 = 4;
            boolean var110 = false;
            byte var135 = 1;
            byte var157 = 2;
            boolean var185 = false;
            this.b(var58, var92, 0, var135, var157, 0);
            break;
         case 14:
            int var154 = this.ao - 8;
            int var183 = this.g1035[2];
            this.b(5, 3, 0, 3, var154, var183);
            byte var57 = 6;
            byte var90 = 3;
            boolean var108 = false;
            byte var134 = 3;
            var3 = this.ao;
            byte[] var173 = this.c1037;
            int var155 = var173[2];
            var3 += var155;
            var155 = var3 - 4;
            var183 = this.g1035[2];
            this.b(var57, var90, 0, var134, var155, var183);
            break;
         case 15:
            byte var56 = 7;
            byte var89 = 3;
            boolean var107 = false;
            byte var133 = 2;
            var3 = this.ao;
            byte[] var172 = this.c1037;
            int var152 = var172[4];
            var3 += var152;
            var152 = var3 - 2;
            int var182 = this.g1035[2];
            this.b(var56, var89, 0, var133, var152, var182);
            break;
         case 17:
            int var9 = this.ao;
            int var11 = this.g1035[2];
            this.b(5, 3, 0, 3, var9, var11);
            var3 = this.ao;
            var9 = this.c1037[2] + var3;
            var11 = this.g1035[2];
            this.b(6, 3, 0, 3, var9, var11);
            byte var4 = 7;
            byte var6 = 3;
            boolean var7 = false;
            byte var8 = 2;
            var3 = this.ao;
            byte[] var10 = this.c1037;
            var9 = var10[4] + var3;
            var11 = this.g1035[2];
            this.b(var4, var6, 0, var8, var9, var11);
      }

      int var32 = 10;
      if (var2 >= var32) {
         var32 = (byte)13;
         if (var2 < var32) {
            boolean var67 = false;
            Object var86 = null;
            short var99 = 240;
            int var124 = this.g1035[2];
            byte var142 = 3;
            boolean var164 = false;
            Object var178 = null;
            byte var192 = 4;
            var32 = this.ao;
            byte[] var205 = this.c1037;
            int var216 = var2 - 9 << 1;
            int var226 = var205[var216] + var32;
            var216 = this.g1035[2];
            byte var47 = 9;
            int var235 = var2 - var47;
            byte var243 = -1;
            this.a(null, var99, var124, var142, 0, var192, var226, var216, var235, var243);
            return;
         }
      }

      int var34 = 14;
      if (var2 >= var34) {
         var34 = (byte)17;
         if (var2 <= var34) {
            boolean var66 = false;
            Object var85 = null;
            var34 = this.ao;
            byte[] var249 = this.c1037;
            int var122 = var2 - 10 << 1;
            int var98 = var249[var122] + var34;
            short var123 = 320;
            byte var141 = 3;
            boolean var163 = false;
            Object var177 = null;
            byte var191 = 4;
            var34 = this.ao;
            byte[] var204 = this.c1037;
            int var214 = var2 - 10 << 1;
            int var225 = var204[var214] + var34;
            var214 = this.g1035[2];
            byte var45 = 10;
            int var234 = var2 - var45;
            byte var242 = -1;
            this.a(null, var98, var123, var141, 0, var191, var225, var214, var234, var242);
            return;
         }
      }

      int var36 = 25;
      if (var2 >= var36) {
         var36 = (byte)31;
         if (var2 <= var36) {
            int var232 = (var2 - 25 << 1) + 8;
            boolean var64 = false;
            Object var83 = null;
            var36 = this.ao;
            byte[] var18 = this.c1037;
            int var118 = var232 << 1;
            int var96 = var18[var118] + var36;
            var118 = this.g1035[2];
            byte var139 = 3;
            boolean var161 = false;
            Object var175 = null;
            boolean var189 = false;
            var36 = this.ao;
            byte[] var202 = this.c1037;
            int var210 = var232 << 1;
            int var223 = var202[var210] + var36;
            var210 = this.g1035[2];
            byte var240 = -1;
            this.a(null, var96, var118, var139, 0, 0, var223, var210, var232, var240);
            int var40 = 31;
            if (var2 < var40) {
               var232++;
               var64 = false;
               var83 = null;
               var40 = this.ao;
               var18 = this.c1037;
               var118 = var232 << 1;
               var96 = var18[var118] + var40;
               var118 = this.g1035[2];
               var139 = 3;
               var161 = false;
               var175 = null;
               var189 = false;
               var40 = this.ao;
               var202 = this.c1037;
               var210 = var232 << 1;
               var223 = var202[var210] + var40;
               var210 = this.g1035[2];
               var240 = -1;
               this.a(null, var96, var118, var139, 0, 0, var223, var210, var232, var240);
            }
         }
      }
   }

   private void f(int var1, int var2, int var3) {
      Image[][] var4 = this.a1013;
      int var6 = var4[4][21].getWidth() / 9;
      var4 = this.a1013;
      int var7 = var4[4][21].getHeight();
      Graphics var29 = this.a1002;
      Object var8 = null;
      var29.setClip(0, 0, 240, 320);
      Graphics var30 = this.a1002;
      var30.setColor(16580557);
      Graphics var31 = this.a1002;
      int var9 = var6 + 3;
      int var10 = var7 + 3;
      var31.drawRect(var2, var3, var9, var10);
      var4 = this.a1013;
      Image var12 = var4[4][21];
      var10 = var2 + 2;
      int var13 = var3 + 2;
      int var14 = var6 * var1;
      int var15 = 0;
      Image var16 = null;
      int var17 = 0;
      Object var18 = null;
      int var19 = 0;
      String var20 = null;
      this.a(var12, var10, var13, var14, 0, var6, var7, 0, 0);
      Graphics var5 = this.a1002;
      var4 = this.a1013;
      var12 = var4[4][22];
      var10 = var2 - 3;
      Graphics var21 = null;
      var5.drawImage(var12, var10, var3, 0);
      var4 = this.a1013;
      Image var47 = var4[4][22];
      var9 = var2 + var6 - 7;
      byte var11 = 1;
      this.a(var47, var9, var3, var11);
      var4 = this.a1013;
      Image var48 = var4[4][22];
      var9 = var2 - 3;
      var10 = var3 + var7 - 11;
      var11 = 2;
      this.a(var48, var9, var10, var11);
      var4 = this.a1013;
      Image var49 = var4[4][22];
      var9 = var2 + var6 - 7;
      var10 = var3 + var7 - 11;
      int var87 = 3;
      this.a(var49, var9, var10, var87);
      int var22 = 0;
      Object var50 = null;

      while (true) {
         int var65 = 8;
         if (var22 >= var65) {
            label37: {
               var22 = 0;
               var50 = null;
               int var24 = this.aN;
               byte var77 = 1;
               if (var24 > var77) {
                  var24 = this.aN;
                  var77 = 6;
                  if (var24 < var77) {
                     byte[][] var85 = this.z1131;
                     var24 = this.aN;
                     byte[] var86 = var85[var24];
                     var65 = var86.length >> 1;
                     var8 = this.A1132;
                     var24 = this.X;
                     var8 = ((Object[])var8)[var24];
                     var24 = this.aN;
                     var77 = (byte)((Object[])var8)[var24];
                     var87 = (byte)1;
                     if (var77 == var87) {
                        var22 = var65;
                     }
                     break label37;
                  }
               }

               var50 = this.z1131;
               var24 = this.aN;
               var22 = ((Object[])((Object[])var50)[var24]).length;
               Object var84 = null;
               var65 = var22;
               var22 = 0;
               var50 = null;
            }

            var10 = 0;
            var8 = null;

            while (var10 < var65) {
               var87 = var2 + var6 + 10;
               var14 = var10 & 3;
               var4 = this.a1013;
               var15 = var4[4][23].getWidth();
               var14 *= var15;
               var87 += var14;
               var14 = var10 >> 2;
               var4 = this.a1013;
               var15 = var4[4][23].getHeight();
               var14 = var14 * var15 + var3;
               var16 = this.z1131;
               int var140 = this.aN;
               var16 = ((Object[])var16)[var140];
               var7 = var10 + var22;
               byte var110 = (byte)((Object[])var16)[var7];
               var87 += 3;
               var14 += 3;
               this.q(var110, var87, var14);
               var10++;
            }

            var10 = 0;
            var8 = null;

            while (var10 < var65) {
               var87 = var2 + var6 + 10;
               var14 = var10 & 3;
               var4 = this.a1013;
               var15 = var4[4][23].getWidth();
               var14 *= var15;
               var87 += var14;
               var14 = var10 >> 2;
               var4 = this.a1013;
               var16 = var4[4];
               int var55 = 23;
               var16 = (Image)((Object[])var16)[var55];
               var15 = var16.getHeight();
               var14 = var14 * var15 + var3;
               int var141 = this.ag;
               if (var10 == var141) {
                  Graphics var44 = this.a1002;
                  var44.setClip(0, 0, 240, 320);
                  Graphics var45 = this.a1002;
                  var45.setColor(16580557);
                  Graphics var118 = this.a1002;
                  var55 = var14 + 20;
                  var17 = this.k;
                  var20 = this.b1015;
                  byte[][] var25 = this.z1131;
                  var141 = this.aN;
                  byte[] var145 = var25[var141];
                  int var26 = var145[var10] + 28;
                  var20 = (String)((Object[])var20)[var26];
                  var19 = var20.length();
                  var17 *= var19;
                  var141 = this.j;
                  var118.fillRect(var87, var55, var17, var141);
                  Graphics var46 = this.a1002;
                  var55 = 5465994;
                  var46.setColor(var55);
                  Graphics var119 = this.a1002;
                  String[] var27 = this.b1015;
                  var18 = this.z1131;
                  var141 = this.aN;
                  var18 = ((Object[])var18)[var141];
                  var19 = var10 + var22;
                  var17 = ((Object[])var18)[var19] + 28;
                  String var146 = var27[var17];
                  var14 += 20;
                  boolean var123 = false;
                  var18 = null;
                  var119.drawString(var146, var87, var14, 0);
               }

               var10++;
            }

            return;
         }

         var65 = var2 + var6 + 10;
         var10 = var22 & 3;
         var4 = this.a1013;
         var87 = var4[4][23].getWidth();
         var10 *= var87;
         var65 += var10;
         var10 = var22 >> 2;
         var4 = this.a1013;
         var21 = var4[4];
         byte var96 = 23;
         var87 = ((Object[])var21)[var96].getHeight();
         var10 = var10 * var87 + var3;
         var21 = this.a1002;
         var4 = this.a1013;
         Image var23 = var4[4][23];
         boolean var107 = false;
         var16 = null;
         var21.drawImage(var23, var65, var10, 0);
         var22++;
      }
   }

   private void f(int var1, int var2, int var3, int var4) {
      int var5 = 3;
      if (var4 < var5) {
         Image[] var6 = this.a1013[29];
         byte var7 = this.I1142[var3][0];
         Image var8 = var6[var7];
         var5 = this.k1141[var4][var3][0] + var1;
         int var9 = this.bP;
         var9 = var5 - var9;
         var5 = this.k1141[var4][var3][1] + var2;
         int var10 = this.bQ;
         var10 = var5 - var10 + 13;
         byte var19 = this.I1142[var3][2];
         int var11 = var4 * var19;
         byte var12 = this.I1142[var3][2];
         byte var13 = this.I1142[var3][3];
         byte var14 = this.I1142[var3][1];
         this.a(var8, var9, var10, var11, 0, var12, var13, var14, 0);
      }

      if (var4 > 0) {
         byte var20 = 3;
         if (var4 < var20) {
            int var29 = 0;
            Object var36 = null;
            int var60 = 0;

            while (true) {
               var29 = (byte)2;
               if (var60 >= var29) {
                  return;
               }

               var36 = this.a1013[29];
               byte var39 = this.l1143[var3][var60][0];
               Image var41 = (Image)((Object[])var36)[var39];
               var29 = this.l1143[var3][var60][1] + var1;
               int var45 = this.bP;
               var45 = var29 - var45;
               var29 = this.l1143[var3][var60][2] + var2;
               int var50 = this.bQ;
               var50 = var29 - var50 + 13;
               int var33 = this.l1143[var3][var60][4];
               int var53 = var4 * var33;
               byte var55 = this.l1143[var3][var60][4];
               byte var57 = this.l1143[var3][var60][5];
               byte var59 = this.l1143[var3][var60][3];
               this.a(var41, var45, var50, var53, 0, var55, var57, var59, 0);
               var33 = var60 + 1;
               var60 = var33;
            }
         }
      }

      int var21 = 3;
      if (var4 >= var21) {
         var21 = (byte)6;
         if (var4 < var21) {
            var21 = (byte)2;
            int var15 = var21;

            while (true) {
               var21 = (byte)4;
               if (var15 >= var21) {
                  break;
               }

               Image[] var35 = this.a1013[29];
               byte var38 = this.l1143[var3][var15][0];
               Image var40 = var35[var38];
               var21 = this.l1143[var3][var15][1] + var1;
               int var43 = this.bP;
               var43 = var21 - var43;
               var21 = this.l1143[var3][var15][2] + var2;
               int var48 = this.bQ;
               var48 = var21 - var48 + 13;
               var21 = var4 - 3;
               byte[] var16 = this.l1143[var3][var15];
               int var52 = var16[4] * var21;
               byte var54 = this.l1143[var3][var15][4];
               byte var56 = this.l1143[var3][var15][5];
               byte var58 = this.l1143[var3][var15][3];
               this.a(var40, var43, var48, var52, 0, var54, var56, var58, 0);
               var21 = var15 + 1;
               var15 = var21;
            }
         }
      }
   }

   private final void f(int var1, int var2, int var3, int var4, int var5) {
      int var6 = 3;
      byte var7;
      if (var5 == var6) {
         var6 = (byte)1;
         var7 = var6;
      } else {
         boolean var23 = false;
         Object var9 = null;
         var7 = 0;
      }

      int var8 = var1 & 1;
      Graphics var31 = this.a1002;
      int[] var10 = this.k1071;
      int var11 = this.aN;
      int var12 = var10[var11];
      var31.setColor(var12);
      var31 = this.a1002;
      var12 = this.c1090[var1][var5][0] + var2;
      int var39 = this.d1091[var1][var5][0];
      var12 += var39;
      var39 = this.c1090[var1][var5][1] + var3;
      byte[] var13 = this.d1091[var1][var5];
      int var14 = var13[1];
      var39 += var14;
      var31.fillArc(var12, var39, 12, 12, 0, 360);
      Image[][] var33 = this.a1013;
      var12 = this.bj;
      Image var37 = var33[var12][var8];
      byte[] var34 = this.d1091[var1][var5];
      var6 = var34[0];
      var39 = var2 + var6;
      var6 = this.d1091[var1][var5][1];
      var14 = var3 + var6;
      int var15 = this.a1092[var1][var5][var4][0];
      short var16 = this.a1092[var1][var5][var4][1];
      Image[][] var35 = this.a1013;
      int var17 = this.bj;
      var8 = var35[var17][var8].getHeight();
      boolean var53 = false;
      this.a(var37, var39, var14, var15, 0, var16, var8, var7, 0);
      var6 = var1 & 1;
      byte var47 = 1;
      if (var6 == var47) {
         Image[] var36 = this.a1013[31];
         var47 = 9;
         Image var38 = var36[var47];
         var39 = var2 - 11;
         var14 = var3 - 23;
         long var18 = this.a1019;
         long var20 = 3;
         var18 &= var20;
         var6 = (int)var18;
         var15 = var6 * 22;
         byte var52 = 22;
         byte var30 = 34;
         boolean var28 = false;
         var53 = false;
         this.a(var38, var39, var14, var15, 0, var52, var30, 0, 0);
      }
   }

   private void f(Image var1, int var2, int var3, int var4) {
      byte var5 = 12;
      int var6 = this.bP;
      int var7 = var2 - var6;
      var6 = this.bQ;
      int var8 = var3 - var6 + 13;
      int var9 = var4 * 10;
      this.a(var1, var7, var8, var9, 0, 10, var5, 0, var5);
   }

   private boolean f() {
      boolean var1 = true;
      this.aw();
      this.au();
      this.E1179 = var1;
      return var1;
   }

   private static boolean f(int var0) {
      byte var1 = 5;
      if (var0 != var1) {
         var1 = 6;
         if (var0 != var1) {
            var1 = 8;
            if (var0 != var1) {
               var1 = 4;
               if (var0 != var1) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private boolean f(int var1, int var2) {
      int var3 = this.a(var1, var2);
      byte[] var4 = this.E1163;
      byte var6 = var4[var3];
      byte var5 = 10;
      boolean var7;
      if (var6 == var5) {
         var7 = true;
      } else {
         var7 = false;
      }

      return var7;
   }

   private void g() {
      byte var1 = 100;
      byte var2 = 20;
      byte var3 = 1;
      int var4 = 0;
      int var5 = this.h1047;
      switch (var5) {
         case -6:
         case -5:
         case 53:
            this.a();
            var5 = this.l;
            if (var5 == var3) {
               byte var13 = 7;
               var4 = (byte)-1;
               this.g(var13, var4);
            }
            break;
         case -4:
         case 54:
            var5 = this.q + 20;
            this.q = var5;
            if (var5 > var1) {
               this.q = var1;
            }

            this.l1031 = (boolean)var3;
            VolumeControl var14 = this.a1017;
            var4 = this.q;
            var14.setLevel(var4);
            break;
         case -3:
         case 52:
            var5 = this.q - var2;
            this.q = var5;
            if (var5 < var2) {
               this.q = 0;
               this.l1031 = false;
            }

            VolumeControl var6 = this.a1017;
            var4 = this.q;
            var6.setLevel(var4);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void g(int var1) {
      byte var2 = 1;
      int var3 = 0;
      String var4 = null;
      if (var1 >= 0) {
         int var5 = this.ap;
         if (var5 < var2) {
            var5 = 0;
            Object var53 = null;

            while (true) {
               if (var5 >= var2) {
                  var5 = 0;
                  var53 = null;
                  break;
               }

               Player var56 = this.a1043[0];
               if (var56 == null) {
                  var5 = 0;
                  var53 = null;
                  break;
               }

               var5++;
            }
         } else {
            int[] var6 = this.h1041;
            int var10 = this.i1044[0];
            var5 = var6[var10];
            int[] var7 = this.i1044;
            var10 = var7[0];
            this.i(var10);
         }

         int[] var57 = this.i1044;
         var3 = this.ap;
         var57[var3] = var1;
         var57 = this.h1041;
         var57[var1] = var5;

         label228: {
            InputStream[] var10000;
            try {
               var10000 = this.a1042;
            } catch (Exception var32) {
               break label228;
            }

            InputStream[] var59 = var10000;

            try {
               this.getClass();
            } catch (Exception var31) {
               break label228;
            }

            try {
               var74 = c1045;
            } catch (Exception var30) {
               break label228;
            }

            var4 = var74;
            String[] var75 = (String[])var4;

            try {
               var76 = var75[var1];
            } catch (Exception var29) {
               break label228;
            }

            var4 = var76;

            try {
               var10000 = Display.getResourceAsStream(var4);
            } catch (Exception var28) {
               break label228;
            }

            InputStream var45 = var10000;
            var10000 = var59;
            int var10001 = var5;

            try {
               var10000[var10001] = var45;
            } catch (Exception var27) {
               break label228;
            }

            try {
               var79 = this.a1043;
            } catch (Exception var26) {
               break label228;
            }

            Player[] var60 = var79;

            try {
               var10000 = this.a1042;
            } catch (Exception var25) {
               break label228;
            }

            InputStream[] var46 = var10000;
            var10000 = var46;

            try {
               var10000 = var10000[var5];
            } catch (Exception var24) {
               break label228;
            }

            InputStream var47 = var10000;

            try {
               var83 = c1045;
            } catch (Exception var23) {
               break label228;
            }

            String[] var8 = var83;
            String[] var84 = var8;

            try {
               var85 = var84[var1];
            } catch (Exception var22) {
               break label228;
            }

            String var70 = var85;
            String var9 = "wav";
            String var86 = var70;

            try {
               var87 = var86.endsWith(var9);
            } catch (Exception var21) {
               break label228;
            }

            boolean var39 = var87;
            String var71;
            if (var39) {
               var71 = "audio/x-wav";
            } else {
               var71 = "audio/midi";
            }

            InputStream var88 = var47;

            try {
               var89 = Manager.createPlayer(var88, var71);
            } catch (Exception var20) {
               break label228;
            }

            Player var48 = var89;
            Player[] var90 = var60;
            var10001 = var5;

            try {
               var90[var10001] = var48;
            } catch (Exception var19) {
               break label228;
            }

            label229: {
               try {
                  var91 = this.a1043;
               } catch (Exception var38) {
                  break label229;
               }

               Player[] var61 = var91;
               Player[] var92 = var61;

               try {
                  var93 = var92[var5];
               } catch (Exception var37) {
                  break label229;
               }

               Player var62 = var93;

               try {
                  var62.realize();
               } catch (Exception var14) {
               }
            }

            while (true) {
               try {
                  var94 = this.a1043;
               } catch (Exception var18) {
                  break;
               }

               Player[] var63 = var94;
               Player[] var95 = var63;

               try {
                  var96 = var95[var5];
               } catch (Exception var17) {
                  break;
               }

               Player var64 = var96;

               try {
                  var97 = var64.getState();
               } catch (Exception var16) {
                  break;
               }

               int var73 = var97;
               short var41 = 300;
               if (var73 == var41) {
                  label231: {
                     try {
                        var10000 = this.a1042;
                     } catch (Exception var34) {
                        break label231;
                     }

                     InputStream[] var67 = var10000;
                     var10000 = var67;

                     try {
                        var10000 = var10000[var5];
                     } catch (Exception var33) {
                        break label231;
                     }

                     InputStream var68 = var10000;

                     try {
                        var68.close();
                     } catch (Exception var12) {
                     }
                  }

                  try {
                     var10000 = this.a1042;
                  } catch (Exception var15) {
                     break;
                  }

                  InputStream[] var69 = var10000;
                  boolean var42 = false;
                  var4 = null;
                  var10000 = var69;
                  var10001 = var5;

                  try {
                     var10000[var10001] = null;
                  } catch (Exception var11) {
                  }
                  break;
               }

               try {
                  var98 = this.a1043;
               } catch (Exception var36) {
                  continue;
               }

               Player[] var65 = var98;
               Player[] var99 = var65;

               try {
                  var100 = var99[var5];
               } catch (Exception var35) {
                  continue;
               }

               Player var66 = var100;

               try {
                  var66.prefetch();
               } catch (Exception var13) {
               }
            }
         }

         var5 = this.ap + 1;
         this.ap = var5;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void g(int var1, int var2) {
      byte var3 = 1;
      if (var1 >= 0) {
         int var4 = this.as;
         int var5 = 8;
         if (var4 < var5) {
            var4 = this.aq;
            if (var1 == var4) {
               return;
            }
         }

         int var27 = this.l1031;
         if (var27) {
            var27 = this.aq;
            if (var1 != var27) {
               var27 = this.aq;
               var5 = (byte)-1;
               if (var27 != var5) {
                  var27 = this.aq;
                  this.h(var27);
               }
            }

            this.g(var1);
            var27 = this.aq;
            label150:
            if (var1 == var27) {
               for (int var32 = this.ap - var3; var32 >= 0; var32 += -1) {
                  int[] var6 = this.i1044;
                  var5 = var6[var32];
                  if (var5 == var1) {
                     while (var32 > 0) {
                        var6 = this.i1044;
                        int[] var7 = this.i1044;
                        int var8 = var32 - var3;
                        int var9 = var7[var8];
                        var6[var32] = var9;
                        var32 += -1;
                     }

                     int[] var10 = this.i1044;
                     boolean var36 = false;
                     var6 = null;
                     var10[0] = var1;
                     break;
                  }
               }

               Player[] var10000;
               try {
                  var10000 = this.a1043;
               } catch (Exception var25) {
                  break label150;
               }

               Player[] var49 = var10000;

               try {
                  var59 = this.h1041;
               } catch (Exception var24) {
                  break label150;
               }

               int[] var45 = var59;
               int[] var60 = var45;

               try {
                  var61 = var60[var1];
               } catch (Exception var23) {
                  break label150;
               }

               var5 = var61;
               var10000 = var49;

               try {
                  var10000 = var10000[var5];
               } catch (Exception var22) {
                  break label150;
               }

               Player var50 = var10000;

               try {
                  var64 = var50.getState();
               } catch (Exception var21) {
                  break label150;
               }

               var27 = var64;
               short var38 = 400;
               if (var27 == var38) {
                  return;
               }
            }

            this.aq = var1;
            Player[] var51 = this.a1043;
            var5 = this.h1041[var1];
            Player var52 = var51[var5];
            String var46 = "VolumeControl";
            VolumeControl var53 = (VolumeControl)var52.getControl(var46);
            this.a1017 = var53;
            VolumeControl var54 = this.a1017;
            var5 = this.q;
            var54.setLevel(var5);

            label163: {
               Player[] var65;
               try {
                  var65 = this.a1043;
               } catch (Exception var20) {
                  break label163;
               }

               var51 = var65;

               try {
                  var66 = this.h1041;
               } catch (Exception var19) {
                  break label163;
               }

               int[] var47 = var66;
               int[] var67 = var47;

               try {
                  var68 = var67[var1];
               } catch (Exception var18) {
                  break label163;
               }

               var5 = var68;
               var65 = var51;

               try {
                  var65 = var65[var5];
               } catch (Exception var17) {
                  break label163;
               }

               Player var56 = var65;
               Player var71 = var56;

               try {
                  var71.setLoopCount(var2);
               } catch (Exception var12) {
               }
            }

            Player[] var72;
            try {
               var72 = this.a1043;
            } catch (Exception var16) {
               return;
            }

            var51 = var72;

            try {
               var73 = this.h1041;
            } catch (Exception var15) {
               return;
            }

            int[] var48 = var73;
            int[] var74 = var48;

            try {
               var75 = var74[var1];
            } catch (Exception var14) {
               return;
            }

            var5 = var75;
            var72 = var51;

            try {
               var72 = var72[var5];
            } catch (Exception var13) {
               return;
            }

            Player var58 = var72;

            try {
               var58.start();
            } catch (Exception var11) {
            }
         }
      }
   }

   private void g(int var1, int var2, int var3) {
      Image var4 = this.a1013[3][18];
      int var5 = var1 * 11;
      this.a(var4, var2, var3, 0, var5, 35, 11, 0, 0);
   }

   private void g(int var1, int var2, int var3, int var4) {
      byte var5 = 2;
      byte var6 = 1;
      byte var7 = 6;
      byte var8 = 3;

      for (int var9 = 0; var9 < var8; var9++) {
         for (int var10 = 0; var10 < var8; var10++) {
            int var11 = var9 << 4;
            int var12 = this.m1084[var1][0];
            var11 = var11 * var12 + var2;
            byte[] var13 = this.m1084[var1];
            var12 = var13[var5];
            var11 += var12;
            var12 = this.bP;
            var11 -= var12;
            var12 = var10 << 4;
            int var14 = this.m1084[var1][var6];
            var12 = var12 * var14 + var3;
            byte[] var15 = this.m1084[var1];
            var14 = var15[var8];
            var12 += var14;
            var14 = this.bQ;
            var12 = var12 - var14 + 13;
            switch (var1) {
               case 0:
               case 2:
                  if (var4 >= 0) {
                     byte var32 = 7;
                     if (var4 < var32 && var10 == 0) {
                        this.r(var11, var12, var4);
                     }
                  }

                  if (var4 > var8) {
                     int var33 = 10;
                     if (var4 < var33 && var10 == var6) {
                        var33 = var4 - var8;
                        this.r(var11, var12, var33);
                     }
                  }

                  if (var4 > var7) {
                     int var35 = 12;
                     if (var4 < var35 && var10 == var5) {
                        var35 = var4 - var7;
                        this.r(var11, var12, var35);
                     }
                  }
                  break;
               case 1:
               case 3:
                  if (var4 >= 0) {
                     byte var27 = 7;
                     if (var4 < var27 && var9 == 0) {
                        this.r(var11, var12, var4);
                     }
                  }

                  if (var4 > var8) {
                     int var28 = 10;
                     if (var4 < var28 && var9 == var6) {
                        var28 = var4 - var8;
                        this.r(var11, var12, var28);
                     }
                  }

                  if (var4 > var7) {
                     int var30 = 12;
                     if (var4 < var30 && var9 == var5) {
                        var30 = var4 - var7;
                        this.r(var11, var12, var30);
                     }
                  }
            }
         }
      }
   }

   private void g(int var1, int var2, int var3, int var4, int var5) {
      short var6 = 360;
      byte var7 = 1;
      Graphics var8 = this.a1002;
      int var9 = 240;
      int var10 = 320;
      var8.setClip(0, 0, var9, var10);
      byte var11 = 2;
      if (var3 > var11) {
         this.a1002.setColor(var4);
         var8 = this.a1002;
         var8.fillArc(var1, var2, var3, var3, 0, var6);
         this.a1002.setColor(var5);
         var8 = this.a1002;
         var9 = var1 + 1;
         var10 = var2 + 1;
         int var12 = var3 - var7;
         int var13 = var3 - var7;
         var8.fillArc(var9, var10, var12, var13, 0, var6);
      } else {
         this.a1002.setColor(var5);
         var8 = this.a1002;
         var8.fillRect(var1, var2, var3, var3);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private boolean g() {
      byte var1 = 1;
      int var2 = this.b();
      switch (var2) {
         case -1:
            var2 = this.bZ;
            byte var8 = 3;
            if (var2 >= var8) {
               return (boolean)var1;
            }

            this.a(var1);
            break;
         case 0:
            this.bY = 0;

            ByteArrayInputStream var10000;
            try {
               var10000 = new ByteArrayInputStream;
            } catch (Exception var31) {
               var31.printStackTrace();
               return (boolean)var1;
            }

            ByteArrayInputStream var3 = var10000;

            try {
               var49 = this.I1189;
            } catch (Exception var30) {
               var30.printStackTrace();
               return (boolean)var1;
            }

            byte[] var4 = var49;
            var10000 = var3;

            try {
               var10000./* $VF: Unable to resugar constructor */<init>(var4);
            } catch (Exception var29) {
               var29.printStackTrace();
               return (boolean)var1;
            }

            try {
               var51 = new DataInputStream;
            } catch (Exception var28) {
               var28.printStackTrace();
               return (boolean)var1;
            }

            DataInputStream var36 = var51;
            DataInputStream var52 = var36;

            try {
               var52./* $VF: Unable to resugar constructor */<init>(var3);
            } catch (Exception var27) {
               var27.printStackTrace();
               return (boolean)var1;
            }

            try {
               var53 = this.ca;
            } catch (Exception var26) {
               var26.printStackTrace();
               return (boolean)var1;
            }

            int var5 = var53;
            short var6 = 200;
            if (var5 == var6) {
               try {
                  var54 = var36.readByte();
               } catch (Exception var25) {
                  var25.printStackTrace();
                  return (boolean)var1;
               }

               byte var37 = var54;
               byte var43 = 2;
               if (var37 == var43) {
                  try {
                     var55 = var36.readByte();
                  } catch (Exception var24) {
                     var24.printStackTrace();
                     return (boolean)var1;
                  }

                  var37 = var55;
                  if (var37 == var1) {
                     try {
                        var56 = a(var36);
                     } catch (Exception var23) {
                        var23.printStackTrace();
                        return (boolean)var1;
                     }

                     String var7 = var56;
                     a var57 = this;

                     try {
                        var57.b1177 = var7;
                     } catch (Exception var22) {
                        var22.printStackTrace();
                        return (boolean)var1;
                     }

                     try {
                        var58 = a(var36);
                     } catch (Exception var21) {
                        var21.printStackTrace();
                        return (boolean)var1;
                     }

                     var7 = var58;
                     a var59 = this;

                     try {
                        var59.c1178 = var7;
                     } catch (Exception var20) {
                        var20.printStackTrace();
                        return (boolean)var1;
                     }

                     try {
                        var60 = var36.readByte();
                     } catch (Exception var19) {
                        var19.printStackTrace();
                        return (boolean)var1;
                     }

                     var37 = var60;
                     if (var37 == var1) {
                        var37 = var1;
                     } else {
                        var37 = 0;
                        var7 = null;
                     }

                     a var61 = this;

                     try {
                        var61.F1180 = (boolean)var37;
                     } catch (Exception var18) {
                        var18.printStackTrace();
                        return (boolean)var1;
                     }

                     try {
                        var62 = a(var36);
                     } catch (Exception var17) {
                        var17.printStackTrace();
                        return (boolean)var1;
                     }

                     var7 = var62;
                     a var63 = this;

                     try {
                        var63.d1181 = var7;
                     } catch (Exception var16) {
                        var16.printStackTrace();
                        return (boolean)var1;
                     }

                     try {
                        var64 = var36.readByte();
                     } catch (Exception var15) {
                        var15.printStackTrace();
                        return (boolean)var1;
                     }

                     var37 = var64;
                     if (var37 == var1) {
                        var37 = var1;
                     } else {
                        var37 = 0;
                        var7 = null;
                     }

                     a var65 = this;

                     try {
                        var65.G1182 = (boolean)var37;
                     } catch (Exception var14) {
                        var14.printStackTrace();
                        return (boolean)var1;
                     }

                     try {
                        var66 = a(var36);
                     } catch (Exception var13) {
                        var13.printStackTrace();
                        return (boolean)var1;
                     }

                     var7 = var66;
                     a var67 = this;

                     try {
                        var67.e1183 = var7;
                     } catch (Exception var12) {
                        var12.printStackTrace();
                        return (boolean)var1;
                     }

                     try {
                        this.ax();
                     } catch (Exception var11) {
                        var11.printStackTrace();
                        return (boolean)var1;
                     }
                  }
               }
            }

            try {
               var36.close();
            } catch (Exception var10) {
               var10.printStackTrace();
               return (boolean)var1;
            }

            try {
               var3.close();
            } catch (Exception var9) {
               var9.printStackTrace();
            }

            return (boolean)var1;
         case 1:
         case 2:
            var2 = this.bY + 1;
            this.bY = var2;
      }

      byte var33 = 0;
      Object var35 = null;
      return (boolean)var33;
   }

   private static boolean g(int var0) {
      byte var1 = 6;
      boolean var2;
      if (var0 == var1) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private boolean g(int var1, int var2) {
      int var3 = this.a(var1, var2);
      byte[] var4 = this.E1163;
      byte var6 = var4[var3];
      byte var5 = 11;
      boolean var7;
      if (var6 == var5) {
         var7 = true;
      } else {
         var7 = false;
      }

      return var7;
   }

   private void h() {
      byte var1 = 104;
      short var2 = 240;
      short var3 = 320;
      this.a1002.setClip(0, 0, var2, var3);
      this.a1002.setColor(16777215);
      this.a1002.fillRect(0, 0, var2, var3);
      int var4 = this.b1015[var1].length();
      int var5 = this.k;
      var4 *= var5;
      var4 = var2 - var4 >> 1;
      var5 = this.j;
      var5 = var3 - var5 >> 1;
      this.a1002.setColor(14834304);
      Graphics var6 = this.a1002;
      String var7 = this.b1015[var1];
      var6.drawString(var7, var4, var5, 0);
      this.a1002.setColor(5465994);
      Graphics var8 = this.a1002;
      String var9 = this.b1015[105];
      int var10 = this.j;
      var10 = var3 - var10;
      var8.drawString(var9, 0, var10, 0);
      var8 = this.a1002;
      var9 = this.b1015[106];
      var10 = this.k << 1;
      var10 = var2 - var10;
      int var11 = this.j;
      var11 = var3 - var11;
      var8.drawString(var9, var10, var11, 0);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void h(int var1) {
      if (var1 >= 0) {
         int[] var2 = this.h1041;
         int var3 = var2[var1];
         if (var3 >= 0) {
            int var22 = 0;
            var2 = null;
            a var10000 = this;

            try {
               var10000.as = 0;
            } catch (Exception var16) {
               return;
            }

            try {
               var27 = this.a1043;
            } catch (Exception var15) {
               return;
            }

            Player[] var18 = var27;

            try {
               var28 = this.h1041;
            } catch (Exception var14) {
               return;
            }

            int[] var4 = var28;
            int[] var29 = var4;

            try {
               var30 = var29[var1];
            } catch (Exception var13) {
               return;
            }

            int var5 = var30;
            Player[] var31 = var18;

            try {
               var32 = var31[var5];
            } catch (Exception var12) {
               return;
            }

            Player var19 = var32;

            try {
               var33 = var19.getState();
            } catch (Exception var11) {
               return;
            }

            var22 = var33;
            int var25 = 400;
            if (var22 == var25) {
               try {
                  var34 = this.a1043;
               } catch (Exception var10) {
                  return;
               }

               Player[] var20 = var34;

               try {
                  var35 = this.h1041;
               } catch (Exception var9) {
                  return;
               }

               var4 = var35;
               int[] var36 = var4;

               try {
                  var37 = var36[var1];
               } catch (Exception var8) {
                  return;
               }

               var25 = var37;
               Player[] var38 = var20;

               try {
                  var39 = var38[var25];
               } catch (Exception var7) {
                  return;
               }

               Player var21 = var39;

               try {
                  var21.stop();
               } catch (Exception var6) {
               }
            }
         }
      }
   }

   private void h(int var1, int var2) {
      Graphics var3 = this.a1002;
      Image var4 = null;
      int var5 = 0;
      Object var6 = null;
      int var7 = 240;
      int var8 = 320;
      var3.setClip(0, 0, var7, var8);
      Image var16 = this.a1013[3][12];
      int var9 = var16.getHeight();
      int var10 = this.l;
      int var11 = 22;
      if (var10 == var11) {
         var10 = this.bb;
         var11 = (byte)18;
         this.q(var10, var11, 293);
         var3 = this.a1002;
         var4 = this.a1013[3][28];
         var5 = (boolean)0;
         var6 = null;
         var7 = (short)299;
         int var56 = 0;
         var3.drawImage(var4, 0, var7, 0);
         int var61 = 0;
         Object var18 = null;
         int var12 = 0;
         Object var13 = null;

         while (true) {
            var61 = (byte)2;
            if (var12 >= var61) {
               break;
            }

            var4 = this.a1013[3][12];
            var5 = var12 * 60 + 120;
            var7 = var2 + 1;
            var56 = var12 * 9;
            byte var14 = 9;
            this.a(var4, var5, var7, var56, 0, var14, var9, 0, 0);
            var18 = this.b1066;
            var4 = null;
            var18 = ((Object[])var18)[0];
            var11 = var12 + 2;
            var61 = (int)((Object[])var18)[var11];
            var11 = var12 * 60 + 131;
            this.b(var61, var11, var2);
            var61 = var12 + 1;
            var12 = var61;
         }
      } else {
         var10 = this.l;
         int var99 = 23;
         if (var10 == var99) {
            var10 = this.X * 11 + 0;
            var99 = (byte)18;
            short var39 = 293;
            this.q(var10, var99, var39);
         } else {
            var10 = this.az;
            var99 = (byte)-1;
            if (var10 != var99) {
               int[][] var21 = this.b1066;
               var99 = this.az;
               int[] var116 = var21[var99];
               var10 = var116[6];
               this.j(var1, var2, var10);
               int var69 = 0;
               Object var22 = null;
               int var15 = 0;

               while (true) {
                  var69 = (byte)2;
                  if (var15 >= var69) {
                     break;
                  }

                  var4 = this.a1013[3][12];
                  var5 = var15 * 60 + 120;
                  var7 = var2 + 1;
                  var8 = var15 * 9;
                  byte var118 = 9;
                  this.a(var4, var5, var7, var8, 0, var118, var9, 0, 0);
                  var69 = var15 + 2;
                  var69 = var116[var69];
                  var99 = var15 * 60 + 131;
                  this.b(var69, var99, var2);
                  var69 = var15 + 1;
                  var15 = var69;
               }
            } else {
               var10 = this.ay;
               int var104 = -1;
               if (var10 != var104) {
                  int[][] var23 = this.c1107;
                  var104 = this.ay;
                  int[] var117 = var23[var104];
                  var10 = var117[2];
                  this.g(var10, var1, var2);
                  int var76 = 0;
                  Object var24 = null;
                  int var120 = 0;

                  while (true) {
                     var76 = (byte)2;
                     if (var120 >= var76) {
                        var24 = null;
                        var76 = var117[0];
                        var104 = var117[1];
                        var5 = var117[2];
                        var7 = var117[3];
                        this.e(var76, var104, var5, var7);
                        break;
                     }

                     var24 = this.a1013[3];
                     int var106 = 12;
                     var4 = (Image)((Object[])var24)[var106];
                     var5 = var120 * 60 + 120;
                     var7 = var2 + 1;
                     var76 = var120 + 2;
                     var8 = var76 * 9;
                     byte var119;
                     if (var120 == 0) {
                        byte var79 = 9;
                        var119 = var79;
                     } else {
                        byte var80 = 18;
                        var119 = var80;
                     }

                     this.a(var4, var5, var7, var8, 0, var119, var9, 0, 0);
                     if (var120 == 0) {
                        var24 = this.c1107;
                        var106 = this.ay;
                        var24 = ((Object[])var24)[var106];
                        var76 = (int)((Object[])var24)[2];
                        byte[] var35 = this.s1102;
                        var6 = this.c1107;
                        var7 = this.ay;
                        var6 = ((Object[])var6)[var7];
                        byte var54 = 3;
                        var5 = (int)((Object[])var6)[var54];
                        var76 = this.a(var76, var35, var5);
                        var106 = var117[17];
                        byte var43 = 1;
                        byte var109;
                        if (var106 == var43) {
                           var109 = 10;
                        } else {
                           var109 = 0;
                           var4 = null;
                        }

                        var76 += var109;
                     } else {
                        var76 = var117[3] + 1;
                     }

                     var106 = (var120 + 1) * 9 + 120 + 2;
                     var5 = var120 * 60;
                     var106 += var5;
                     this.b(var76, var106, var2);
                     var76 = var120 + 1;
                     var120 = var76;
                  }
               } else {
                  var10 = this.bN;
                  var104 = this.bO;
                  int var87 = this.e(var10, var104);
                  if (var87) {
                     var87 = (byte)1;
                     this.i(var1, var2, var87);
                  } else {
                     var87 = this.bN;
                     var104 = this.bO;
                     int var90 = this.f(var87, var104);
                     if (var90) {
                        var90 = (byte)3;
                        this.i(var1, var2, var90);
                     } else {
                        var90 = this.bN;
                        var104 = this.bO;
                        byte var93 = this.g(var90, var104);
                        if (var93) {
                           var93 = 2;
                           this.i(var1, var2, var93);
                        } else {
                           boolean var95 = false;
                           Object var29 = null;
                           this.i(var1, var2, 0);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private void h(int var1, int var2, int var3) {
      this.g(var1, var2, var3);
      if (var1 > 0) {
         byte var4 = 6;
         if (var1 < var4) {
            Image[] var15 = this.a1013[3];
            byte var16 = 29;
            Image var17 = var15[var16];
            int var18 = var2 + 36;
            int var19 = var3 + 1;
            byte var20 = 17;
            byte var21 = 17;
            byte var22 = 10;
            this.a(var17, var18, var19, var20, 0, var21, var22, 0, 0);
            return;
         }
      }

      byte var13 = 6;
      if (var1 >= var13) {
         var13 = 10;
         if (var1 <= var13) {
            Image[] var5 = this.a1013[3];
            byte var6 = 29;
            Image var7 = var5[var6];
            int var8 = var2 + 36;
            int var9 = var3 + 1;
            boolean var10 = false;
            byte var11 = 17;
            byte var12 = 10;
            this.a(var7, var8, var9, 0, 0, var11, var12, 0, 0);
         }
      }
   }

   private void h(int var1, int var2, int var3, int var4) {
      byte var5 = 8;
      byte var6 = -1;
      byte var7 = 10;
      byte var8 = 1;
      int var9 = 0;

      while (true) {
         int var10 = this.aP;
         if (var9 >= var10) {
            return;
         }

         int[] var11 = this.b1066[var9];
         int var12 = var11[0];
         int var13 = var11[var8];
         var12 = this.a(var12, var13);
         byte[] var14 = this.D1162;
         int var32 = var14[var12];
         switch (var32) {
            case 2:
               var32 = var11[var7];
               if (var32 == var6) {
                  var32 = var11[11];
                  if (var32 > 0) {
                     int[] var15 = this.c1107[var1];
                     var32 = var15[var7];
                     if (var32 == var8) {
                        var15 = this.c1107[var1];
                        byte var43 = 13;
                        int var16 = var15[var43];
                        byte var17 = 2;
                        var16 -= var17;
                        var15[var43] = var16;
                        if (var16 < 0) {
                           var15 = this.c1107[var1];
                           var43 = 13;
                           var15[var43] = 0;
                        }
                     }

                     var15 = this.c1107[var1];
                     byte var45 = 16;
                     var15[var45] = var8;
                  }

                  int[] var51 = this.c1107[var1];
                  byte var46 = 16;
                  var32 = var51[var46];
                  if (var32 == var8) {
                     byte var42 = 11;
                     var46 = 48;
                     var11[var42] = var46;
                  }

                  byte[] var30 = this.s1102;
                  var10 = this.a(var2, var30, var3);
                  this.v(var9, var10, var1);
               }
               break;
            case 3:
               var11[11] = 0;
               var32 = var11[var7];
               if (var32 == var6) {
                  var10 = var11[26];
                  byte var37 = 4;
                  if (var10 != var37) {
                     byte[] var29 = this.s1102;
                     var10 = this.a(var2, var29, var3);
                     this.v(var9, var10, var1);
                  }
               }
               break;
            case 4:
               var32 = var11[var5];
               if (var32 == 0) {
                  var11[var5] = var8;
                  byte var35 = 9;
                  var11[var35] = var4;
                  byte[] var28 = this.s1102;
                  var10 = this.a(var2, var28, var3);
                  this.v(var9, var10, var1);
               }
               break;
            case 5:
               var10 = var11[var7];
               if (var10 == var6) {
                  byte[] var27 = this.s1102;
                  var10 = this.a(var2, var27, var3);
                  this.v(var9, var10, var1);
               }
               break;
            case 16:
            case 46:
               var10 = var11[var5];
               var32 = (byte)4;
               if (var10 != var32) {
                  byte[] var26 = this.s1102;
                  var10 = this.a(var2, var26, var3);
                  this.v(var9, var10, var1);
               }
         }

         var9++;
      }
   }

   private void h(int var1, int var2, int var3, int var4, int var5) {
      byte var16;
      byte var17;
      byte var18;
      byte var31;
      label30: {
         var31 = (byte)3;
         float var7 = 4.0E-45F;
         byte var8 = 3;
         float var9 = 4.0E-45F;
         byte var10 = 0;
         float var11 = 0.0F;
         byte var12 = 0;
         float var13 = 0.0F;
         boolean var15 = this.m(var4, var5);
         if (!var15) {
            switch (var3) {
               case 0:
               case 2:
                  var31 = 1;
                  var7 = Float.MIN_VALUE;
                  var10 = 2;
                  var11 = 3.0E-45F;
                  var16 = 0;
                  var17 = var8;
                  var18 = var10;
                  break label30;
               case 1:
               case 3:
                  var8 = 1;
                  var9 = Float.MIN_VALUE;
                  var12 = 2;
                  var13 = 3.0E-45F;
                  var16 = var8;
                  var17 = var12;
                  var18 = var31;
                  var31 = 0;
                  var7 = 0.0F;
                  break label30;
            }
         }

         var16 = 0;
         var17 = var8;
         var18 = var31;
         var31 = 0;
         var7 = 0.0F;
      }

      int var19 = var31;

      while (var19 < var18) {
         int var21 = var16;

         while (var21 < var17) {
            var31 = var19 << 4;
            byte[][] var14 = this.m1084;
            byte var45 = var14[var3][0];
            var31 = var31 * var45 + var1;
            var14 = this.m1084;
            byte[] var22 = var14[var3];
            float var53 = 3.0E-45F;
            var45 = var22[2];
            var31 += var45;
            int var20 = this.bP;
            int var51 = var31 - var20;
            var31 = var21 << 4;
            var14 = this.m1084;
            var45 = var14[var3][1];
            var31 = var31 * var45 + var2;
            var14 = this.m1084;
            var45 = var14[var3][3];
            var31 += var45;
            var20 = this.bQ;
            var31 = var31 - var20 + 13;
            Image[][] var61 = this.a1013;
            Image var64 = var61[29][39];
            float var57 = 2.2E-44F;
            int var55 = var31 - 16;
            long var23 = this.a1019;
            long var27 = 3;
            long var25 = var23 & var27;
            int var62 = (int)var25 * 15;
            byte var29 = 15;
            byte var30 = 29;
            this.a(var64, var51, var55, var62, 0, var29, var30, 0, 0);
            var31 = var21 + 1;
            var21 = var31;
         }

         var31 = var19 + 1;
         var19 = var31;
      }
   }

   private boolean h(int var1) {
      int var2 = this.a() & 7;
      boolean var3;
      if (var2 > var1) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private boolean h(int var1, int var2) {
      if (var1 > 0) {
         int var3 = this.bI;
         if (var1 < var3 && var2 > 0) {
            var3 = this.bJ;
            if (var2 < var3) {
               var3 = this.a(var1, var2);
               byte[] var4 = this.E1163;
               byte var9 = var4[var3];
               byte var5 = 8;
               boolean var7;
               if (var9 < var5) {
                  var7 = true;
               } else {
                  var7 = false;
               }

               return var7;
            }
         }
      }

      return false;
   }

   private void i() {
      byte var1 = 1;
      int var2 = this.h1047;
      switch (var2) {
         case -7:
            boolean var5 = false;
            this.l1031 = false;
            this.l = var1;
            break;
         case -6:
         case -5:
            this.l = var1;
            this.l1031 = (boolean)var1;
            this.q = 60;
            byte var4 = 7;
            var1 = -1;
            this.g(var4, var1);
      }
   }

   private void i(int var1) {
      byte var2 = -1;
      byte var3 = 1;
      if (var1 >= 0) {
         int[] var4 = this.h1041;
         int var5 = var4[var1];
         if (var5 >= 0) {
            this.h(var1);
            Player[] var11 = this.a1043;
            int var6 = this.h1041[var1];
            var11[var6].close();
            Player[] var12 = this.a1043;
            int[] var7 = this.h1041;
            var6 = var7[var1];
            int var8 = 0;
            Object var9 = null;
            var12[var6] = null;
            var5 = 0;
            var4 = null;

            label22:
            while (true) {
               var6 = this.ap;
               if (var5 >= var6) {
                  break;
               }

               var7 = this.i1044;
               var6 = var7[var5];
               if (var6 == var1) {
                  while (true) {
                     var6 = this.ap - var3;
                     if (var5 >= var6) {
                        break label22;
                     }

                     var7 = this.i1044;
                     var9 = this.i1044;
                     int var10 = var5 + 1;
                     var8 = (int)((Object[])var9)[var10];
                     var7[var5] = var8;
                     var5++;
                  }
               }

               var5++;
            }

            var4 = this.i1044;
            var6 = this.ap - var3;
            var4[var6] = var2;
            var5 = this.ap - var3;
            this.ap = var5;
            var4 = this.h1041;
            var4[var1] = var2;
         }
      }
   }

   private void i(int var1, int var2) {
      byte var3 = 5;
      byte var4 = -1;
      byte var5 = 10;
      byte var6 = 8;
      int[] var7 = this.b1066[var1];
      int var8 = var7[var5];
      if (var8 != var4) {
         var8 = var7[var5];
         byte var9 = 1;
         var8 -= var9;
         var7[var5] = var8;
         if (var8 < 0) {
            var7[var5] = var4;
         }
      }

      if (var2 <= 0) {
         var8 = var7[var6];
         if (var8 != var3) {
            var8 = var7[var6];
            byte var16 = 3;
            if (var8 != var16) {
               var8 = var7[var6];
               var16 = 2;
               if (var8 != var16) {
                  var7[7] = 0;
                  var7[11] = 0;
                  var7[12] = 0;
                  var7[13] = 0;
                  byte var15 = 14;
                  var7[var15] = 0;
                  var7[var6] = var3;
               }
            }
         }
      }
   }

   private void i(int var1, int var2, int var3) {
      int var4 = 0;

      while (true) {
         byte[] var5 = this.c1051[var3];
         int var6 = var5.length;
         if (var4 >= var6) {
            return;
         }

         Image var10 = this.a1013[3][11];
         int var7 = var4 * 14 + var1;
         byte[] var8 = this.c1051[var3];
         byte var9 = var8[var4];
         this.c(var10, var7, var2, var9);
         var4++;
      }
   }

   private void i(int var1, int var2, int var3, int var4) {
      int var5 = 0;
      Object var6 = null;
      int var7 = 0;

      while (true) {
         var5 = (byte)4;
         if (var7 >= var5) {
            var5 = this.bF;
            byte var45 = 1;
            if (var5 != var45) {
               var5 = this.ay;
               var45 = -1;
               if (var5 != var45) {
                  var5 = this.bE;
               } else {
                  var5 = var3;
               }

               Image var49 = this.a1013[3][1];
               int var55 = this.bN;
               var5 = (var5 >> 1) + var55;
               var55 = this.bP;
               var5 -= var55;
               var55 = this.bO - 16;
               int var67 = this.bQ;
               var55 -= var67;
               long var71 = this.a1019;
               long var24 = 1L;
               var71 &= var24;
               var67 = (int)var71 << 1;
               var55 = var55 - var67 + 13;
               byte var69 = 4;
               this.b(var49, var5, var55, var69);
            }

            return;
         }

         int var27 = 0;
         var6 = null;
         int var8 = 0;
         Image var9 = null;
         int var10 = this.ay;
         int var11 = -1;
         if (var10 != var11) {
            var6 = this.P1157[var7];
            int var28 = (int)((Object[])var6)[0];
            long var12 = this.a1019;
            long var14 = 1L;
            var12 &= var14;
            var8 = (int)var12 << 1;
            var28 *= var8;
            var9 = this.P1157[var7];
            int var43 = (int)((Object[])var9)[1];
            long var16 = this.a1019;
            long var18 = 1L;
            var16 &= var18;
            var10 = (int)var16 << 1;
            var43 *= var10;
            var10 = var28;
            var27 = var43;
         } else {
            var10 = 0;
            var27 = 0;
            var6 = null;
         }

         var9 = this.a1013[3][0];
         var10 += var1;
         var11 = var3 - 7;
         int var20 = this.O1156[var7][0];
         var11 *= var20;
         var10 += var11;
         var11 = this.bP;
         var10 -= var11;
         var27 += var2;
         var11 = var4 - 7;
         byte[] var21 = this.O1156[var7];
         var20 = var21[1];
         var11 *= var20;
         var27 += var11;
         var11 = this.bQ;
         var11 = var27 - var11 + 13;
         var20 = var7 * 7;
         byte var22 = 7;
         byte var23 = 7;
         this.a(var9, var10, var11, var20, 0, var22, var23, 0, 0);
         var27 = var7 + 1;
         var7 = var27;
      }
   }

   private boolean i(int var1) {
      byte var2 = 0;

      while (true) {
         byte var3 = 5;
         if (var2 >= var3) {
            var6 = true;
            break;
         }

         byte[] var4 = this.C1134[var1];
         var3 = var4[var2];
         byte var5 = -1;
         if (var3 != var5) {
            var6 = false;
            break;
         }

         var2++;
      }

      return var6;
   }

   private boolean i(int var1, int var2) {
      byte var3 = 1;
      int var4 = this.X;
      if (var4 == var3) {
         switch (var1) {
            case 1:
            case 2:
            case 3:
            case 6:
            case 7:
               boolean var5 = g(var2);
               if (var5) {
                  return (boolean)var3;
               }
            case 4:
            case 5:
         }
      }

      return false;
   }

   private void j() {
      int var1 = 80;
      byte var2 = 1;
      short var3 = 240;
      byte var4 = 107;
      this.a1002.setColor(16580557);
      Graphics var5 = this.a1002;
      String var6 = this.b1015[var4];
      int var7 = var6.length();
      int var8 = this.k;
      var7 = var7 * var8 + 8;
      var7 = var3 - var7 >> 1;
      String var9 = this.b1015[var4];
      var8 = var9.length();
      int var10 = this.k;
      var8 = var8 * var10 + 8;
      var5.fillRect(var7, var1, var8, 140);
      int var11 = this.b1015[var4].length();
      var7 = this.k;
      var11 = var11 * var7 + 8;
      var7 = var3 - var11 >> 1;
      var11 = this.b1015[var4].length();
      var8 = this.k;
      var8 = var11 * var8 + 8;
      int var44 = 140;
      this.c(var7, var1, var8, var44, var2);
      var5 = this.a1002;
      short var30 = 320;
      var5.setClip(0, 0, var3, var30);
      var11 = 0;
      Object var21 = null;

      while (true) {
         int var31 = 6;
         if (var11 >= var31) {
            return;
         }

         label20: {
            var31 = this.r;
            if (var11 != var31) {
               Graphics var22 = this.a1002;
               var1 = 15455661;
               var22.setColor(var1);
               if (var11 != var2) {
                  break label20;
               }

               long var13 = this.a1019;
               long var15 = 1L;
               var13 &= var15;
               var31 = (int)var13;
               if (var31 == 0) {
                  Graphics var24 = this.a1002;
                  var1 = 15455661;
                  var24.setColor(var1);
                  break label20;
               }
            }

            Graphics var23 = this.a1002;
            var1 = 14311547;
            var23.setColor(var1);
         }

         Graphics var25 = this.a1002;
         String[] var12 = this.b1015;
         var8 = var11 + 107;
         String var51 = var12[var8];
         String[] var42 = this.b1015;
         var44 = var11 + 107;
         var9 = var42[var44];
         var8 = var9.length();
         var44 = this.k;
         var8 *= var44;
         var8 = var3 - var8 >> 1;
         var44 = var11 * 20 + 90;
         var25.drawString(var51, var8, var44, 0);
         var11++;
      }
   }

   private void j(int var1) {
      int var2 = 1;
      this.aw = var2;
      this.aF = 8;
      int var3 = this.d1053[var1].length - var2;
      this.aB = var3;
      this.aC = var1;
      this.aE = 0;
      this.aD = 0;
      var3 = (this.j << 1) + 25;
      this.ax = var3;
      var3 = this.aB;
      var2 = this.aF;
      if (var3 < var2) {
         var3 = this.aB + 1;
         this.aF = var3;
      }

      var2 = this.aF * 18;
      var3 = 240 - var2 >> 1;
      this.aG = var3;
      this.a(12);
   }

   private void j(int var1, int var2) {
      byte var3 = 4;
      byte var4 = 3;
      byte var5 = 2;
      int var6 = this.bu;
      Image[] var7 = this.a1013[var4];
      byte var8 = 20;
      Image var16 = var7[var8];
      int var9 = var16.getWidth() / 27;
      if (var6 < var9) {
         var6 = this.bu + 1;
         this.bu = var6;
         var6 = this.bu;
         if (var6 == var5 && var2 == var3) {
            int[] var10 = this.c1107[var1];
            var9 = var10[var4] + 1;
            var10[var4] = var9;
         }
      } else {
         byte var13 = 5;
         if (var2 == var13) {
            this.t(var1);
         }

         int var14 = 0;
         this.bu = 0;
         int[] var19 = this.c1107[var1];
         var19[var3] = var5;
         if (var2 == var4) {
            var19 = this.c1107[var1];
            var14 = var19[var5];
            switch (var14) {
               case 0:
               case 4:
                  var19 = this.c1107[var1];
                  byte var18 = 6;
                  var19[var3] = var18;
            }
         }
      }
   }

   private void j(int var1, int var2, int var3) {
      byte var4 = 3;
      Image var5 = null;
      int var6 = var3 >> 1;
      short[] var7 = this.a1052[var6];
      int var8 = var7.length;
      short var9 = a(var3);
      if (var9) {
         var6 = this.bb;
         byte var17 = 18;
         this.q(var6, var17, 293);
         Graphics var10 = this.a1002;
         Image var16 = this.a1013[var4][28];
         var9 = 299;
         var10.drawImage(var16, 0, var9, 0);
      } else {
         for (int var19 = 0; var19 < var8; var19++) {
            var5 = this.a1013[var4][14];
            int var11 = var19 * 12 + var1;
            short[] var12 = this.a1052[var6];
            short var13 = var12[var19];
            this.c(var5, var11, var2, var13);
         }
      }
   }

   private boolean j(int var1) {
      int var2 = this.bz;
      boolean var3;
      if (var1 > var2) {
         var3 = 0;
      } else {
         var3 = this.bz - var1;
         this.bz = var3;
         var3 = 1;
      }

      return (boolean)var3;
   }

   private boolean j(int var1, int var2) {
      byte var3 = 1;
      int var4 = this.X;
      if (var4 == var3) {
         switch (var1) {
            case 8:
            case 9:
               boolean var5 = g(var2);
               if (var5) {
                  return (boolean)var3;
               }
         }
      }

      return false;
   }

   private void k() {
      this.e(0);
      Random var1 = new Random();
      this.a1012 = var1;
      var1 = this.a1012;
      long var2 = System.currentTimeMillis();
      var1.setSeed(var2);
      this.b1018 = true;
      this.e(5);
      this.s = 0;
      this.c1020 = false;
      this.c(3);
      this.e(20);
      this.c(0);
      this.e(40);
      this.c(4);
      this.e(70);
      this.c();
      this.e(100);
      this.l = 18;
   }

   private void k(int var1) {
      byte var2 = 2;
      byte var3 = 0;
      Object var4 = null;
      byte var5 = 1;
      int var6 = this.bt;
      if (var6 > 0) {
         byte[] var7 = this.a1056;
         byte var12 = var7[var1];
         if (!var12) {
            var7 = this.g1057;
            var12 = var7[var1];
            int var14 = this.j(var12);
            if (var14) {
               this.a1056[var1] = (boolean)var5;
               byte[] var19 = this.b1059;
               byte[] var8 = this.h1060;
               byte var9 = var8[var1];
               var19[var9] = var5;
               var14 = 0;
               var19 = null;

               while (var14 < var2) {
                  boolean[] var22 = this.e1105;
                  var4 = this.g1065[var1];
                  var3 = (byte)((Object[])var4)[var14];
                  var22[var3] = (boolean)var5;
                  var14++;
               }

               var19 = this.h1060;
               byte var16 = var19[var1];
               this.u(var16);
               this.aw = var2;
            } else {
               this.o = 0;
            }
         } else {
            var12 = 3;
            this.o = var12;
         }
      } else {
         this.o = var5;
      }
   }

   private void k(int var1, int var2) {
      byte var3 = 4;
      int var4 = 0;
      Image var5 = null;

      while (var4 < var3) {
         byte[] var6 = this.w1110;
         int var7 = var4 << 1;
         int var8 = var6[var7] + var1;
         byte[] var9 = this.w1110;
         int var10 = (var4 << 1) + 1;
         var7 = var9[var10] + var2;
         var10 = this.bu;
         this.p(var8, var7, var10);
         var4++;
      }

      var4 = this.bu;
      int var17 = 1;
      if (var4 > var17) {
         var5 = this.a1013[3][21];
         var17 = this.bP;
         var17 = var1 - var17;
         int var14 = var2 + 13;
         int var21 = this.bQ;
         var14 -= var21;
         var21 = this.bu << 1;
         var14 -= var21;
         this.b(var5, var17, var14, var3);
      }
   }

   private void k(int var1, int var2, int var3) {
      Image var4 = this.a1013[3][22];
      byte[] var5 = this.e1054;
      int var6 = this.f1055[var3] * 3 + 2;
      byte var7 = var5[var6];
      var6 = var1 + var7;
      var5 = this.e1054;
      int var8 = this.f1055[var3] * 3;
      byte var9 = var5[var8];
      var5 = this.e1054;
      var8 = this.f1055[var3] * 3 + 1;
      byte var10 = var5[var8];
      this.a(var4, var6, var2, var9, 0, var10, 15, 0, 0);
   }

   private boolean k(int var1, int var2) {
      byte var3 = 1;
      int var4 = this.X;
      if (var4 == var3) {
         switch (var1) {
            case 10:
               boolean var5 = g(var2);
               if (var5) {
                  return (boolean)var3;
               }
         }
      }

      return false;
   }

   private void l() {
      this.a1002.setClip(0, 0, 240, 320);
      this.a1002.setColor(16777215);
      Graphics var1 = this.a1002;
      Image var2 = null;
      int var3 = 0;
      Image var4 = null;
      int var5 = 240;
      int var6 = 320;
      var1.fillRect(0, 0, var5, var6);
      int var7 = this.t;
      short var8 = 240;
      this.e(var7, var8);
      var7 = this.M;
      if (var7 != 0) {
         Graphics var14 = null;
         this.d(0);
         var7 = this.M;
         int var114 = 2;
         if (var7 >= var114) {
            var14 = this.a1002;
            var2 = this.a1013;
            var4 = null;
            var2 = (Image)((Object[])((Object[])var2)[0])[4];
            var3 = this.y;
            var5 = this.z;
            boolean var82 = false;
            var14.drawImage(var2, var3, var5, 0);
         }

         var7 = 0;
         var14 = null;

         while (true) {
            var114 = (byte)3;
            if (var7 >= var114) {
               var7 = this.M;
               var114 = (byte)3;
               if (var7 >= var114) {
                  int var93 = this.h;
                  if (var93) {
                     var14 = this.a1002;
                     Image[][] var32 = this.a1013;
                     var4 = null;
                     var2 = var32[0][5];
                     var3 = this.G;
                     var5 = this.H;
                     boolean var83 = false;
                     var14.drawImage(var2, var3, var5, 0);
                  }

                  var93 = this.j1024;
                  if (var93) {
                     Image var18 = this.a1013[0][0];
                     var114 = this.A;
                     var3 = this.B;
                     this.a(var18, var114, var3, 0);
                     Image[][] var19 = this.a1013;
                     var2 = null;
                     Image var20 = var19[0][1];
                     var114 = this.C;
                     var3 = this.D;
                     boolean var73 = false;
                     this.a(var20, var114, var3, 0);
                  }

                  var93 = this.g;
                  if (var93) {
                     Image[] var21 = this.a1013[0];
                     byte var121 = 2;
                     var2 = var21[var121];
                     var3 = this.E;
                     var5 = this.F;
                     var93 = this.a1013[0][2].getWidth() >> 1;
                     var6 = (this.R - 1) * var93;
                     boolean var9 = false;
                     var93 = this.a1013[0][2].getWidth();
                     int var10 = var93 >> 1;
                     int var11 = this.a1013[0][2].getHeight();
                     this.a(var2, var3, var5, var6, 0, var10, var11, 0, 0);
                  }

                  int var98 = this.f1023;
                  if (var98) {
                     int var12 = this.A + 16;
                     var98 = this.B;
                     Image[] var36 = this.a1013[0];
                     int var52 = 0;
                     var4 = null;
                     var2 = var36[0];
                     var114 = var2.getHeight();
                     var98 += var114;
                     int var123 = 14;
                     int var13 = var98 - var123;
                     var98 = 0;
                     var14 = null;

                     while (true) {
                        var123 = this.S;
                        if (var98 >= var123) {
                           int var102 = this.d1021;
                           if (var102) {
                              Image[] var23 = this.a1013[0];
                              byte var125 = 7;
                              var2 = var23[var125];
                              Image[][] var24 = this.a1013;
                              var4 = null;
                              var52 = var24[0][11].getWidth() + var12 - 6;
                              var5 = var13 + 4;
                              var102 = this.a1013[0][7].getWidth() / 3;
                              var6 = (this.P - 1) * var102;
                              boolean var134 = false;
                              var102 = this.a1013[0][7].getWidth();
                              int var137 = var102 / 3;
                              int var140 = this.a1013[0][7].getHeight();
                              this.a(var2, var52, var5, var6, 0, var137, var140, 0, 0);
                           }

                           int var105 = this.e1022;
                           if (var105) {
                              Image[] var25 = this.a1013[0];
                              byte var126 = 8;
                              var2 = var25[var126];
                              var52 = var12 - 15;
                              var105 = this.a1013[0][11].getHeight();
                              var5 = var13 + var105;
                              var105 = this.a1013[0][8].getWidth() / 3;
                              var6 = (this.Q - 1) * var105;
                              boolean var135 = false;
                              var105 = this.a1013[0][8].getWidth();
                              int var138 = var105 / 3;
                              int var141 = this.a1013[0][8].getHeight();
                              this.a(var2, var52, var5, var6, 0, var138, var141, 0, 0);
                           }
                           break;
                        }

                        Graphics var38 = this.a1002;
                        var4 = this.a1013[0];
                        var5 = var98 + 9;
                        var4 = (Image)((Object[])var4)[var5];
                        boolean var76 = false;
                        var38.drawImage(var4, var12, var13, 0);
                        var98++;
                     }
                  }

                  boolean var109 = this.i;
                  if (var109) {
                     var14 = this.a1002;
                     Image[][] var41 = this.a1013;
                     var4 = null;
                     var2 = var41[0][6];
                     var3 = this.I;
                     var5 = this.J;
                     boolean var87 = false;
                     var14.drawImage(var2, var3, var5, 0);
                  }
               }

               var7 = this.M;
               int var127 = 5;
               if (var7 == var127) {
                  var14 = this.a1002;
                  var2 = this.a1013[0][3];
                  var5 = this.L;
                  var14.drawImage(var2, 0, var5, 0);
                  Image var28 = this.a1013[0][3];
                  var3 = this.a1013[0][3].getWidth();
                  var127 = 240 - var3;
                  var3 = this.L;
                  this.a(var28, var127, var3, 1);
                  var7 = this.r;
                  var127 = this.K;
                  var3 = this.L + 1;
                  this.c(var7, var127, var3);
                  var7 = this.K - 20;
                  var127 = this.K;
                  var3 = this.a1013[4][25].getWidth();
                  var127 = var127 + var3 + 20;
                  var4 = this.a1013[3][24];
                  var3 = var4.getWidth();
                  var127 -= var3;
                  var3 = this.L + 1;
                  this.d(var7, var127, var3);
                  Image[] var29 = this.a1013[3];
                  byte var133 = 2;
                  var2 = var29[var133];
                  byte var62 = 1;
                  var7 = this.L;
                  var5 = var7 + 3;
                  boolean var88 = false;
                  byte var136 = 20;
                  byte var139 = 18;
                  byte var142 = 10;
                  this.a(var2, var62, var5, 0, var136, var139, var142, 0, 0);
               }
               break;
            }

            var114 = this.w;
            var3 = var7 * 176;
            var114 += var3;
            var3 = this.x;
            this.d(var114, var3);
            var7++;
         }
      }
   }

   private final void l(int var1) {
      byte var2 = 8;
      byte var3 = 6;
      byte var4 = 2;
      byte var5 = 1;
      int var6 = this.aT;
      int var7 = this.aX;
      if (var6 < var7) {
         short[][] var8 = this.b1069;
         var7 = this.aN;
         short[] var31 = var8[var7];
         short var16 = var31[0];
         short[][] var9 = this.b1069;
         int var10 = this.aN;
         short[] var32 = var9[var10];
         var7 = var32[var5] + 13;
         int var17 = this.b(var16, var7);
         if (var17) {
            var17 = this.aR - var5;
            this.aR = var17;
            if (var17 < 0) {
               label44: {
                  int var19 = this.o1077;
                  if (var19) {
                     var19 = this.aP;
                     if (var19 == 0) {
                        this.ab();
                        this.o1077 = (boolean)var5;
                        break label44;
                     }
                  }

                  this.o1077 = false;
               }

               var17 = this.aP;

               while (true) {
                  var7 = this.aP + var1;
                  if (var17 >= var7) {
                     var17 = this.aP + 1;
                     this.aP = var17;
                     var17 = this.aQ + 1;
                     this.aQ = var17;
                     var17 = this.aT + 1;
                     this.aT = var17;
                     this.aR = var4;
                     break;
                  }

                  int[] var33 = this.b1066[var17];
                  short[][] var11 = this.b1069;
                  int var12 = this.aN;
                  short var45 = var11[var12][0];
                  var33[0] = var45;
                  int[] var34 = this.b1066[var17];
                  var11 = this.b1069;
                  var12 = this.aN;
                  short[] var55 = var11[var12];
                  var45 = var55[var5];
                  var34[var5] = var45;
                  int[] var35 = this.b1066[var17];
                  int var47 = this.o1077;
                  if (var47) {
                     var47 = this.aW * 10;
                  } else {
                     var47 = this.aW;
                  }

                  var35[var4] = var47;
                  int[] var36 = this.b1066[var17];
                  var12 = this.aY;
                  var36[3] = var12;
                  int[] var37 = this.b1066[var17];
                  var12 = this.aZ;
                  var37[4] = var12;
                  int[] var38 = this.b1066[var17];
                  int[] var13 = this.b1066[var17];
                  var12 = var13[0];
                  int[] var14 = this.b1066[var17];
                  int var15 = var14[var5];
                  var12 = this.c(var12, var15);
                  var38[5] = var12;
                  int[] var39 = this.b1066[var17];
                  int var49 = this.o1077;
                  if (var49) {
                     var49 = (this.aV << 1) + 1;
                  } else {
                     var49 = this.aV << 1;
                  }

                  label32: {
                     var39[var3] = var49;
                     this.b1066[var17][7] = 0;
                     this.b1066[var17][var2] = 0;
                     this.b1066[var17][9] = 0;
                     int[] var40 = this.b1066[var17];
                     var12 = this.aQ;
                     var40[24] = var12;
                     this.b1066[var17][10] = -1;
                     this.b1066[var17][11] = 0;
                     this.b1066[var17][12] = 0;
                     this.b1066[var17][13] = 0;
                     this.b1066[var17][14] = 0;
                     this.b1066[var17][15] = 0;
                     this.b1066[var17][25] = 0;
                     this.b1066[var17][23] = 0;
                     int[] var41 = this.b1066[var17];
                     var12 = this.ba;
                     var41[26] = var12;
                     int[] var42 = this.b1066[var17];
                     byte var51 = 27;
                     var42[var51] = 0;
                     var7 = this.ba;
                     if (var7 != var3) {
                        var7 = this.ba;
                        if (var7 != var2) {
                           break label32;
                        }
                     }

                     int[] var43 = this.b1066[var17];
                     var51 = 27;
                     byte var64 = -2;
                     var43[var51] = var64;
                  }

                  int[] var44 = this.b1066[var17];
                  var7 = var44[0];
                  int[] var56 = this.b1066[var17];
                  var49 = var56[var5];
                  this.a(var7, var49, (boolean)var5);
                  var17++;
               }
            }
         }
      }
   }

   private void l(int var1, int var2) {
      int[] var3 = this.c1107[var1];
      byte var4 = 6;
      int var5 = var3[var4] - 1;
      var3[var4] = var5;
      this.A(var1);
   }

   private void l(int var1, int var2, int var3) {
      Image var4 = this.a1013[30][0];
      byte var5 = this.e1058[var1][0];
      byte var6 = this.e1058[var1][1];
      byte var7 = this.e1058[var1][2];
      byte var8 = this.e1058[var1][3];
      this.a(var4, var2, var3, var5, var6, var7, var8, 0, 0);
   }

   private boolean l(int var1, int var2) {
      int var3 = this.X;
      if (var3 == 0) {
         switch (var1) {
            case 2:
            case 6:
            case 10:
               boolean var4 = g(var2);
               if (var4) {
                  return true;
               }
         }
      }

      return false;
   }

   private void m() {
      byte var1 = 6;
      byte var2 = 2;
      byte var3 = 4;
      byte var4 = 1;
      int var5 = this.M;
      switch (var5) {
         case 0:
            this.S = 0;
            this.N = 0;
            this.v = -26;
            short var95 = 416;
            this.x = var95;
            this.M = var4;
            break;
         case 1:
            this.n();
            var5 = this.N + 1;
            this.N = var5;
            int var125 = 20;
            if (var5 > var125) {
               this.N = 0;
               var125 = this.a1013[0][var3].getWidth();
               var5 = 240 - var125 >> 1;
               this.y = var5;
               Image var132 = this.a1013[0][var3];
               var5 = var132.getHeight() + 320;
               this.z = var5;
               Image var143 = this.a1013[0][var3];
               var125 = var143.getHeight();
               var5 = 320 - var125 >> 1;
               byte var128 = 10;
               var5 -= var128;
               this.O = var5;
               this.M = var2;
            }
            break;
         case 2:
            this.n();
            var5 = this.z - 60;
            this.z = var5;
            int var119 = this.O;
            if (var5 < var119) {
               var5 = this.O;
               this.z = var5;
               this.N = 0;
               this.U = 0;
               var5 = this.y;
               var119 = this.a1013[0][var3].getWidth();
               var5 = var5 + var119 - 20;
               this.e1025 = var5;
               var5 = this.e1025;
               var119 = this.a1013[0][0].getWidth();
               var5 = var5 + var119 - var3;
               this.f1026 = var5;
               var5 = this.e1025;
               int var122 = this.a1027[0];
               var5 += var122;
               this.A = var5;
               var5 = this.f1026;
               var122 = this.a1027[0];
               var5 -= var122;
               this.C = var5;
               var5 = this.O + 12;
               this.B = var5;
               var5 = this.B + 8;
               this.D = var5;
               var5 = this.f1026;
               this.E = var5;
               var5 = this.B;
               Image var142 = this.a1013[0][0];
               var122 = var142.getHeight();
               var5 += var122;
               this.F = var5;
               var5 = this.f1026;
               this.G = var5;
               this.M = var3;
            }
            break;
         case 3:
            this.n();
            this.o();
            byte[] var7 = this.a1027;
            var5 = var7.length;
            int var99 = this.N;
            if (var99 < var5) {
               var5 = this.e1025;
               byte[] var134 = this.a1027;
               int var145 = this.N;
               byte var100 = var134[var145];
               var5 += var100;
               this.A = var5;
               var5 = this.f1026;
               var134 = this.a1027;
               var145 = this.N;
               var100 = var134[var145];
               var5 -= var100;
               this.C = var5;
            } else {
               var99 = this.N;
               int var147 = var5 + 2;
               if (var99 == var147) {
                  Image[] var129 = this.a1013[0];
                  byte var103 = 5;
                  Image var130 = var129[var103];
                  var5 = var130.getHeight();
                  var5 = 0 - var5;
                  this.H = var5;
                  this.h = (boolean)var4;
               } else {
                  var99 = this.N;
                  var147 = var5 + 2;
                  if (var99 > var147) {
                     var99 = this.N;
                     var147 = var5 + 3;
                     if (var99 == var147) {
                        var5 = this.H;
                        Image[] var136 = this.a1013[0];
                        byte var150 = 5;
                        Image var137 = var136[var150];
                        var99 = var137.getHeight() >> 1;
                        var5 += var99;
                        this.H = var5;
                     } else {
                        var99 = this.N;
                        var147 = var5 + 4;
                        if (var99 == var147) {
                           var5 = this.O;
                           byte var108 = 10;
                           var5 -= var108;
                           this.H = var5;
                        } else {
                           var99 = this.N;
                           var5 += 5;
                           if (var99 == var5) {
                              var5 = this.O - var1;
                              this.H = var5;
                              this.f1023 = (boolean)var4;
                           }
                        }
                     }
                  }
               }
            }

            int var51 = this.f1023;
            if (var51) {
               var51 = this.S;
               if (var51 == var4) {
                  this.d1021 = (boolean)var4;
               } else {
                  var51 = this.S;
                  if (var51 == var2) {
                     this.e1022 = (boolean)var4;
                     this.g = (boolean)var4;
                  }
               }

               var51 = this.S;
               byte var110 = 3;
               if (var51 < var110) {
                  var51 = this.S + 1;
                  this.S = var51;
               }
            }

            int var56 = this.d1021;
            if (var56) {
               var56 = this.P + 1;
               this.P = var56;
               if (var56 > var3) {
                  this.d1021 = false;
               }
            }

            int var58 = this.e1022;
            if (var58) {
               var58 = this.Q + 1;
               this.Q = var58;
               if (var58 > var3) {
                  this.e1022 = false;
                  this.i = (boolean)var4;
                  Image var131 = this.a1013[0][var1];
                  var58 = -var131.getWidth();
                  this.I = var58;
                  Image var138 = this.a1013[0][var1];
                  var99 = var138.getHeight();
                  var58 = 320 - var99 >> 1;
                  this.J = var58;
               }
            }

            int var62 = this.g;
            if (var62) {
               var62 = this.R;
               if (var62 < var2) {
                  var62 = this.R + 1;
                  this.R = var62;
               }
            }

            int var65 = this.i;
            if (var65) {
               var65 = this.I + 8;
               this.I = var65;
               var99 = this.y;
               Image var156 = this.a1013[0][var1];
               int var152 = var156.getWidth();
               var99 -= var152;
               byte var153 = 15;
               var99 -= var153;
               if (var65 > var99) {
                  var65 = this.y;
                  Image var139 = this.a1013[0][var1];
                  var99 = var139.getWidth();
                  var65 -= var99;
                  byte var116 = 15;
                  var65 -= var116;
                  this.I = var65;
               }
            }

            var65 = this.N + 1;
            this.N = var65;
            var65 = this.N;
            int var117 = 25;
            if (var65 > var117) {
               this.N = 0;
               this.L = 320;
               Image[] var140 = this.a1013[var3];
               byte var154 = 25;
               Image var141 = var140[var154];
               var117 = var141.getWidth();
               var65 = 240 - var117 >> 1;
               this.K = var65;
               byte var73 = 5;
               this.M = var73;
            }
            break;
         case 4:
            this.n();
            this.o();
            var5 = this.N;
            if (var5 > var2) {
               this.j1024 = (boolean)var4;
               this.N = 0;
               byte var36 = 3;
               this.M = var36;
            }

            var5 = this.N + 1;
            this.N = var5;
            break;
         case 5:
            this.n();
            this.o();
            var5 = this.L - var2;
            this.L = var5;
            Image[] var10 = this.a1013[0];
            var3 = 3;
            Image var155 = var10[var3];
            int var9 = var155.getHeight();
            int var6 = 320 - var9;
            if (var5 < var6) {
               Image[] var8 = this.a1013[0];
               byte var144 = 3;
               Image var133 = var8[var144];
               var6 = var133.getHeight();
               var5 = 320 - var6;
               this.L = var5;
            }

            var5 = this.h1047;
            switch (var5) {
               case -6:
               case -5:
               case 53:
                  var5 = this.r;
                  switch (var5) {
                     case 0:
                        this.h(7);
                        this.T = 0;
                        this.t1089 = false;
                        this.af = var4;
                        this.c = 0;
                        this.X = 0;
                        this.aO = 0;
                        this.aN = 0;
                        this.v1097 = (boolean)var4;
                        this.bF = 0;
                        this.ay = -1;
                        this.az = -1;
                        this.aw = 0;
                        this.k1029 = false;
                        byte var34 = 15;
                        this.l = var34;
                        return;
                     case 1:
                        this.h(7);
                        this.t1089 = false;
                        this.X = 0;
                        this.af = 0;
                        this.T = var4;
                        this.aO = 0;
                        this.aN = 0;
                        this.bF = 0;
                        this.ay = -1;
                        this.az = -1;
                        this.aw = 0;
                        this.k1029 = (boolean)var4;
                        this.v1097 = false;
                        byte var33 = 15;
                        this.l = var33;
                        return;
                     case 2:
                        int var28 = this.A1170;
                        if (var28) {
                           this.A1170 = false;
                           this.h(7);
                           this.y1155 = false;
                           this.bF = 0;
                           this.aw = 0;
                           this.a();
                           this.Q();
                           this.v1097 = false;
                           var28 = this.T;
                           if (var28 == 0) {
                              this.k1029 = false;
                           } else {
                              this.k1029 = (boolean)var4;
                           }

                           this.l = var2;
                           var28 = this.aq;
                           byte var97 = 8;
                           if (var28 >= var97) {
                              var28 = this.aP;
                              if (var28 != 0) {
                                 var28 = this.aq;
                                 var97 = -1;
                                 this.g(var28, var97);
                              }

                              return;
                           }
                        } else {
                           this.F(var1);
                        }

                        return;
                     case 3:
                        this.h(7);
                        byte var27 = 8;
                        this.a((int)var27);
                        return;
                     case 4:
                        this.h(7);
                        byte var26 = 21;
                        this.a((int)var26);
                        this.c = 0;
                        return;
                     case 5:
                        this.h(7);
                        byte var25 = 20;
                        this.a((int)var25);
                        this.c = 0;
                        return;
                     case 6:
                        this.h(7);
                        this.c(var4);
                        byte var24 = 19;
                        this.l = var24;
                        return;
                     default:
                        return;
                  }
               case -4:
               case 54:
                  var5 = this.r + 1;
                  this.r = var5;
                  if (var5 > var1) {
                     this.r = 0;
                  } else {
                     var5 = this.r;
                     if (var5 == var2) {
                        int var21 = this.a();
                        if (!var21) {
                           var21 = this.r + 1;
                           this.r = var21;
                        }
                     }
                  }
                  break;
               case -3:
               case 52:
                  var5 = this.r - var4;
                  this.r = var5;
                  if (var5 < 0) {
                     this.r = var1;
                  } else {
                     var5 = this.r;
                     if (var5 == var2) {
                        int var17 = this.a();
                        if (!var17) {
                           var17 = this.r - var4;
                           this.r = var17;
                        }
                     }
                  }
            }
      }
   }

   private void m(int var1) {
      byte var2 = 6;
      byte var3 = 1;
      byte[] var4 = this.D1162;
      byte var5 = var4[var1];
      if (var5 > var2) {
         var4 = this.D1162;
         var2 = (byte)(var4[var1] - var3);
         var4[var1] = var2;
      } else {
         var4 = this.D1162;
         var5 = var4[var1];
         if (var5 == var2) {
            var4 = this.D1162;
            var4[var1] = var3;
         }
      }
   }

   private void m(int var1, int var2) {
      boolean var3 = true;
      this.x1126 = var3;
      int var4 = 0;

      while (true) {
         byte[] var5 = this.o1098;
         int var6 = this.bw;
         int var7 = var5[var6];
         if (var4 >= var7) {
            return;
         }

         var7 = 0;
         var5 = null;

         while (true) {
            byte[] var8 = this.o1098;
            int var9 = this.bw;
            int var11 = var8[var9];
            if (var7 >= var11) {
               var4++;
               break;
            }

            var11 = (var4 << 4) + var1;
            var9 = (var7 << 4) + var2;
            boolean var13 = this.e(var11, var9);
            if (var13) {
               boolean[] var15 = this.a1127[var4];
               var15[var7] = var3;
            } else {
               boolean[] var16 = this.a1127[var4];
               var16[var7] = false;
               this.x1126 = false;
            }

            var7++;
         }
      }
   }

   private void m(int var1, int var2, int var3) {
      int var4 = 0;

      while (true) {
         byte[] var5 = this.j1064;
         byte var6 = var5[var3];
         if (var4 >= var6) {
            if (var3 == 0) {
               var4 = 0;

               while (true) {
                  var5 = this.j1064;
                  var6 = var5[var3];
                  if (var4 >= var6) {
                     break;
                  }

                  int var21 = this.w1111;
                  if (var21) {
                     var5 = this.f1063[var3];
                     int var38 = var4 * 3;
                     var21 = var5[var38];
                     var38 = this.bv;
                     if (var21 == var38) {
                        var5 = this.f1063[var3];
                        var38 = var4 * 3 + 1;
                        var21 = var5[var38] + var1;
                        byte[][] var26 = this.e1058;
                        int var32 = this.bv;
                        var38 = var26[var32][2] >> 1;
                        var21 += var38;
                        byte[] var27 = this.f1063[var3];
                        var32 = var4 * 3 + 2;
                        var38 = var27[var32] + var2;
                        byte[][] var44 = this.e1058;
                        int var47 = this.bv;
                        byte[] var45 = var44[var47];
                        byte var48 = 3;
                        var32 = var45[var48] >> 1;
                        var38 += var32;
                        this.k(var21, var38);
                     }
                  }

                  var4++;
               }
            }

            return;
         }

         byte[] var13 = this.b1059;
         byte[] var7 = this.f1063[var3];
         int var8 = var4 * 3;
         int var9 = var7[var8];
         byte var18 = var13[var9];
         if (var18 || var3 != 0) {
            var13 = this.f1063[var3];
            var9 = var4 * 3;
            var18 = var13[var9];
            var7 = this.f1063[var3];
            var8 = var4 * 3 + 1;
            var9 = var7[var8] + var1;
            var8 = this.bP;
            var9 -= var8;
            byte[] var10 = this.f1063[var3];
            int var11 = var4 * 3 + 2;
            var8 = var10[var11] + var2 + 13;
            var11 = this.bQ;
            var8 -= var11;
            this.l(var18, var9, var8);
         }

         var4++;
      }
   }

   private boolean m(int var1, int var2) {
      int var3 = this.X;
      if (var3 == 0) {
         switch (var1) {
            case 8:
            case 9:
               boolean var4 = g(var2);
               if (var4) {
                  return true;
               }
         }
      }

      return false;
   }

   private void n() {
      short var1 = 300;
      byte var2 = 4;
      byte var3 = 2;
      short var4 = -176;
      int var5 = this.u - var3;
      this.u = var5;
      if (var5 < var4) {
         this.u = 0;
      }

      var5 = this.w - var3;
      this.w = var5;
      if (var5 < var4) {
         this.w = 0;
      }

      var5 = this.v + 4;
      this.v = var5;
      if (var5 > 0) {
         this.v = 0;
      }

      var5 = this.x;
      int var7 = 16;
      var5 -= var7;
      this.x = var5;
      if (var5 < var1) {
         this.x = var1;
      }

      var5 = this.t - 1;
      this.t = var5;
      Image var6 = this.a1013[var2][var2];
      var7 = -var6.getWidth() * 5;
      if (var5 < var7) {
         this.t = 0;
      }
   }

   private final void n(int var1) {
      byte var2 = 7;
      int[] var3 = this.b1066[var1];
      int var4 = var3[var2] + 1;
      var3[var2] = var4;
      byte[][] var9 = this.l1083;
      int[] var5 = this.b1066[var1];
      byte var6 = 6;
      int var7 = var5[var6] >> 1;
      int[] var10 = var9[var7];
      int var8 = var10.length;
      byte var13 = 1;
      var8 -= var13;
      if (var4 > var8) {
         var10 = this.b1066[var1];
         boolean var12 = false;
         var10[var2] = 0;
      }
   }

   private void n(int var1, int var2) {
      byte var3 = 1;
      int var4 = 0;

      while (true) {
         int var5 = this.bt;
         if (var4 >= var5) {
            return;
         }

         int[] var6 = this.c1107[var4];
         byte[] var7 = this.o1098;
         int var8 = var6[2];
         var5 = var7[var8] << 3;
         var8 = var6[0] + var5;
         int var9 = var6[var3] + var5;
         byte[] var10 = this.s1102;
         int var11 = this.a(7, var10, 6);
         int var13 = this.a(var8, var9, var1, var2, var11);
         if (var13) {
            var13 = (byte)17;
            var6[var13] = var3;
         }

         var13 = var4 + 1;
         var4 = var13;
      }
   }

   private void n(int var1, int var2, int var3) {
      int var4 = 16422227;
      int var5 = 16382577;
      int var6 = 20;
      byte var7 = 1;
      byte[] var8 = this.v1109;
      int var9 = var8.length;
      if (var3 < var9 && var3 > 0) {
         int var24 = 0;
         var8 = null;
         int var10 = 0;

         while (true) {
            var24 = (byte)7;
            if (var10 >= var24) {
               break;
            }

            byte[][] var18 = this.p1108;
            int var28 = var3 - var7;
            var8 = var18[var28];
            var28 = var10 << 1;
            var24 = var8[var28];
            var28 = var1 + var24;
            byte[][] var20 = this.p1108;
            var6 = var3 - var7;
            var8 = var20[var6];
            var6 = (var10 << 1) + 1;
            var6 = var8[var6] + var2 + 13;
            var8 = this.v1109;
            int var31 = var3 - var7;
            var31 = var8[var31] << 1;
            this.g(var28, var6, var31, var4, var5);
            var24 = var10 + 1;
            var10 = var24;
         }
      } else if (var3 == 0) {
         int var11 = var1 - var6;
         var9 = var2 - var6;
         var6 = var9 + 13;
         byte var12 = 40;
         this.g(var11, var6, var12, var4, var5);
      }
   }

   private boolean n(int var1, int var2) {
      int var3 = this.X;
      byte var4 = 2;
      if (var3 == var4) {
         switch (var1) {
            case 2:
            case 6:
               boolean var5 = g(var2);
               if (var5) {
                  return true;
               }
         }
      }

      return false;
   }

   private void o() {
      byte var1 = 1;
      int var2 = this.U;
      switch (var2) {
         case 0:
            var2 = this.z + 1;
            this.z = var2;
            int var7 = this.O + 5;
            if (var2 > var7) {
               this.U = var1;
            }
            break;
         case 1:
            var2 = this.z - var1;
            this.z = var2;
            int var3 = this.O;
            if (var2 < var3) {
               boolean var5 = false;
               this.U = 0;
            }
      }
   }

   private void o(int var1) {
      byte var2 = 5;
      byte var3 = 1;
      int[] var4 = this.b1066[var1];
      int var5 = var4[0] & 7;
      if (var5 == 0) {
         var5 = var4[0] & 15;
         if (var5 != 0) {
            var5 = var4[var3] & 7;
            if (var5 == 0) {
               var5 = var4[var3] & 15;
               if (var5 != 0) {
                  var5 = var4[0];
                  byte[][] var6 = this.k1081;
                  int var7 = var4[var2];
                  byte[] var21 = var6[var7];
                  int var8 = var21[0] << 4;
                  var5 += var8;
                  var8 = var4[var3];
                  byte[][] var9 = this.k1081;
                  int var10 = var4[var2];
                  byte[] var28 = var9[var10];
                  var7 = var28[var3] << 4;
                  var8 += var7;
                  int var16 = this.d(var5, var8);
                  if (!var16) {
                     var16 = var4[0];
                     var8 = var4[var3];
                     var7 = var4[var2];
                     var16 = this.b(var16, var8, var7);
                     var4[var2] = var16;
                  } else {
                     var16 = var4[0];
                     var8 = var4[var3];
                     var16 = this.c(var16, var8);
                     var4[var2] = var16;
                  }
               }
            }
         }
      }
   }

   private void o(int var1, int var2) {
      int var3 = 0;

      while (true) {
         int var4 = 5;
         if (var3 >= var4) {
            return;
         }

         long var5 = this.a1019;
         long var7 = var3;
         var5 += var7;
         var7 = 3;
         var5 &= var7;
         var4 = (int)var5;
         Image var9 = this.a1013[31][8];
         byte[] var10 = this.B1133[var3];
         int var11 = var10[0] + var1;
         byte var12;
         if (var4 == 0) {
            var12 = 4;
         } else {
            var12 = 0;
            Object var13 = null;
         }

         var11 += var12;
         byte[] var24 = this.B1133[var3];
         var12 = var24[1] + var2;
         int var14 = var4 * 3;
         byte var15 = 3;
         byte var16 = 17;
         this.a(var9, var11, var12, var14, 0, var15, var16, 0, 0);
         var4 = var3 + 1;
         var3 = var4;
      }
   }

   private void o(int var1, int var2, int var3) {
      byte var4 = 1;
      Image[] var5 = this.a1013[38];
      int var6 = this.aM;
      Image var7 = var5[var6];
      byte[][] var14 = this.o1095;
      int var8 = this.ba - var4;
      byte var9 = var14[var8][3];
      var8 = var1 + var9;
      byte[][] var15 = this.o1095;
      int var10 = this.ba - var4;
      var9 = var15[var10][4];
      var10 = var2 + var9;
      byte[][] var16 = this.o1095;
      int var11 = this.ba - var4;
      var9 = var16[var11][0];
      var11 = var3 * var9;
      byte[][] var17 = this.o1095;
      int var12 = this.ba - var4;
      byte var24 = var17[var12][0];
      byte[][] var18 = this.o1095;
      int var13 = this.ba - var4;
      byte var25 = var18[var13][var4];
      this.a(var7, var8, var10, var11, 0, var24, var25, 0, 0);
   }

   private boolean o(int var1, int var2) {
      int var3 = this.X;
      byte var4 = 2;
      if (var3 == var4) {
         switch (var1) {
            case 10:
               boolean var5 = g(var2);
               if (var5) {
                  return true;
               }
         }
      }

      return false;
   }

   private void p() {
      short var1 = 320;
      short var2 = 240;
      byte var3 = 3;
      this.a1002.setClip(0, 0, var2, var1);
      this.a1002.setColor(16580557);
      this.a1002.fillRect(0, 0, var2, var1);
      Image var4 = this.a1013[var3][var3];
      this.a(var4, 0, 0, 13450878, true);
   }

   private void p(int var1) {
      byte var2 = 1;
      int[] var3 = this.b1066[var1];
      int[][] var4 = this.b1066;
      int var5 = this.aP - var2;
      int[] var9 = var4[var5];
      var5 = var3[0];
      int var6 = var3[var2];
      this.a(var5, var6, false);
      var5 = 0;

      while (true) {
         int var12 = 28;
         if (var5 >= var12) {
            int var7 = this.aP - var2;
            this.aP = var7;
            var7 = this.aT;
            int var8 = this.aX;
            if (var7 == var8) {
               var7 = this.aP;
               if (var7 == 0) {
                  var7 = this.aq;
                  this.h(var7);
               }
            }

            return;
         }

         var12 = (byte)24;
         if (var5 != var12) {
            var12 = var9[var5];
            var3[var5] = var12;
         }

         var5++;
      }
   }

   private void p(int var1, int var2) {
      byte var3 = 14;
      int var4 = 0;

      while (true) {
         byte[] var5 = this.o1098;
         int var6 = this.bw;
         int var7 = var5[var6];
         if (var4 >= var7) {
            this.q(var1, var2);
            return;
         }

         int var8 = 0;

         while (true) {
            var5 = this.o1098;
            var6 = this.bw;
            var7 = var5[var6];
            if (var8 >= var7) {
               var7 = var4 + 1;
               var4 = var7;
               break;
            }

            var7 = (var4 << 4) + var1;
            var6 = var8 << 4;
            int var9 = var2 + var6;
            var6 = var7 + 1;
            int var10 = this.bP;
            var6 -= var10;
            var10 = var9 + 1;
            int var11 = this.bQ;
            var10 = var10 - var11 + 13;
            boolean var23 = this.e(var7, var9);
            this.b(var6, var10, var3, var3, var23);
            var7 = var8 + 1;
            var8 = var7;
         }
      }
   }

   private void p(int var1, int var2, int var3) {
      int var4 = 20;
      byte var5 = 3;
      this.a1013[var5][var4].getWidth();
      int var6 = this.a1013[var5][var4].getHeight();
      Image[] var7 = this.a1013[var5];
      Image var8 = var7[var4];
      byte var9;
      if (var3 == 0) {
         var9 = 0;
         var7 = null;
      } else {
         var9 = 4;
      }

      var9 = var1 - var9;
      var4 = this.bP;
      var4 = var9 - var4;
      var9 = this.bQ;
      int var10 = var2 - var9;
      int var11 = var3 * 27;
      this.a(var8, var4, var10, var11, 0, 27, var6, 0, 0);
   }

   private boolean p(int var1, int var2) {
      int var3 = this.X;
      byte var4 = 2;
      if (var3 == var4) {
         switch (var1) {
            case 8:
            case 9:
               boolean var5 = g(var2);
               if (var5) {
                  return true;
               }
         }
      }

      return false;
   }

   private void q() {
      int var1 = this.V;
      this.b(var1, 13);
      Image var2 = this.a1013[3][3];
      Object var3 = null;
      int var4 = 1;
      this.a(var2, 0, 0, 13450878, (boolean)var4);
      Graphics var5 = this.a1002;
      int var6 = 240;
      int var7 = this.W;
      var5.setClip(0, 13, var6, var7);
      int var8 = this.a1013[4][7].getWidth();
      int var9 = 240 - var8 >> 1;
      var1 = this.W;
      var8 = this.a1013[4][7].getHeight();
      int var10 = (var1 - var8 >> 1) + 13;
      var5 = this.a1002;
      var2 = this.a1013[4][7];
      int var11 = 0;
      Object var12 = null;
      var5.drawImage(var2, var9, var10, 0);
      Image[] var56 = this.a1013[4];
      int var93 = 10;
      int var13 = var56[var93].getWidth() / 3;
      int var19 = 0;
      Graphics var57 = null;
      int var14 = 0;

      while (true) {
         var19 = (byte)3;
         if (var14 >= var19) {
            var57 = this.a1002;
            Image[] var40 = this.a1013[4];
            var11 = this.X + 14;
            var2 = var40[var11];
            var11 = var9 + 176;
            var3 = this.a1013[4];
            var7 = this.X + 14;
            var6 = ((Object[])var3)[var7].getWidth();
            var11 = var11 - var6 + 20;
            var7 = this.V;
            var6 = 310 - var7;
            Image[] var123 = this.a1013[4];
            var4 = this.X + 14;
            var7 = var123[var4].getHeight();
            var6 -= var7;
            var57.drawImage(var2, var11, var6, 0);
            this.a1002.setClip(0, 0, 240, 320);
            var6 = this.W + 13;
            var2 = this.a1013[3][6];
            this.a(var2, 0, var6, 12010381, true);
            var19 = this.a1013[3][6].getHeight();
            var9 = var6 + var19;
            this.a1002.setColor(15455661);
            this.a1002.fillRect(0, var9, 240, 25);
            var93 = this.a1013[4][8].getWidth();
            var10 = 240 - var93 >> 1;
            var19 = this.a1013[4][8].getHeight() >> 1;
            var14 = var9 - var19 - 9;
            var57 = this.a1002;
            var2 = this.a1013[4][8];
            var57.drawImage(var2, var10, var14, 0);
            var13 = this.a1013[4][12].getWidth() / 3;
            var2 = this.a1013[4][12];
            var19 = this.a1013[4][8].getWidth() - var13 >> 1;
            var11 = var10 + var19;
            var19 = this.a1013[4][8].getHeight();
            var6 = this.a1013[4][12].getHeight();
            var6 = (var19 - var6 >> 1) + var14 + 4;
            var19 = this.X;
            var7 = var13 * var19;
            int var122 = this.a1013[4][12].getHeight();
            this.a(var2, var11, var6, var7, 0, var13, var122, 0, 0);
            var19 = var10 + 4;
            this.bR = var19;
            var19 = this.a1013[4][8].getWidth() + var10 - 4;
            var93 = this.a1013[3][24].getWidth();
            var19 -= var93;
            this.bS = var19;
            var19 = (this.a1013[4][8].getHeight() >> 1) + var14;
            this.bT = var19;
            var19 = this.bR;
            var93 = this.bS;
            var11 = this.bT;
            this.d(var19, var93, var11);
            var11 = var9 + 25;
            var7 = this.V - 32;
            this.c(0, var11, 240, var7, 0);
            var6 = var9 + 6;
            var4 = this.j + 1;
            this.a(0, 10, var6, 63, var4, 0);
            this.a1002.setColor(13971834);
            var57 = this.a1002;
            String[] var45 = this.b1015;
            var11 = this.X + 25;
            String var46 = var45[var11];
            var6 = var9 + 8;
            var57.drawString(var46, 28, var6, 0);
            var6 = var9 + 6;
            var4 = this.j + 1;
            this.a(1, 167, var6, 63, var4, 1);
            var19 = this.X * 11 + 28;
            var11 = var9 + 8;
            this.a(var19, 186, var11);
            this.a1002.setColor(5271185);
            String[] var67 = this.b1015;
            var93 = this.X + 76;
            String var47 = var67[var93];
            var7 = var9 + 35;
            this.a(var47, 0, 8, var7, 224, 50);
            var11 = this.a1013[4][25].getWidth();
            var93 = 240 - var11 >> 1;
            this.c(7, var93, 0);
            return;
         }

         var19 = this.X;
         if (var19 == var14) {
            Image[] var58 = this.a1013[4];
            byte var94 = 10;
            Image var59 = var58[var94];
            var2 = var59;
         } else {
            Image[] var60 = this.a1013[4];
            byte var95 = 11;
            Image var61 = var60[var95];
            var2 = var61;
         }

         byte[] var62 = this.a1028[var14];
         var12 = null;
         int var22 = var62[0];
         var11 = var9 + var22;
         var22 = this.a1028[var14][1];
         var6 = var10 + var22;
         var7 = var13 * var14;
         int var50 = 0;
         Image var15 = null;
         int var16 = this.a1013[4][10].getHeight();
         this.a(var2, var11, var6, var7, 0, var13, var16, 0, 0);
         var22 = this.X;
         if (var22 == var14) {
            var57 = this.a1002;
            var2 = this.a1013[4][13];
            var12 = this.a1028[var14];
            var11 = ((Object[])var12)[0] + var9;
            var6 = this.a1013[4][13].getWidth();
            var6 = var13 - var6 >> 1;
            var11 += var6;
            var3 = this.a1028[var14];
            var6 = ((Object[])var3)[1] + var10;
            var7 = this.a1013[4][10].getHeight();
            var15 = this.a1013[4];
            byte var121 = 13;
            var15 = (Image)((Object[])var15)[var121];
            var50 = var15.getHeight();
            var7 = var7 - var50 >> 1;
            var6 += var7;
            boolean var85 = false;
            Object var17 = null;
            var57.drawImage(var2, var11, var6, 0);
         }

         var22 = var14 + 1;
         var14 = var22;
      }
   }

   private void q(int var1) {
      int[][] var2 = this.b1066;
      int[] var3 = var2[var1];
      int var4 = var3[10];
      int var5 = 4;
      if (var4 == var5) {
         Image[] var16 = this.a1013[29];
         var5 = (byte)22;
         Image var6 = var16[var5];
         var4 = var3[0] - 8;
         int var7 = this.bP;
         var7 = var4 - var7;
         var4 = var3[1] - 8;
         int var8 = this.bQ;
         var4 -= var8;
         var8 = var4 + 13;
         byte var9 = 16;
         boolean var10 = false;
         byte var11 = 16;
         byte var12 = 16;
         this.a(var6, var7, var8, var9, 0, var11, var12, 0, 0);
      } else {
         int var22 = 0;
         var2 = null;
         int var13 = 0;

         while (true) {
            var22 = (byte)7;
            if (var13 >= var22) {
               var22 = var3[16];
               Object var35 = null;
               var5 = var3[0];
               int var40 = this.bP;
               var5 = var5 - var40 - 4;
               var40 = var3[1];
               int var49 = this.bQ;
               var40 = var40 - var49 + 13 - 16;
               var49 = var3[10] << 1;
               var40 += var49;
               this.b(var22, var5, var40);
               break;
            }

            Image[] var18 = this.a1013[31];
            boolean var31 = false;
            Image var34 = var18[0];
            var22 = var3[0];
            byte[][][] var14 = this.e1093;
            int var51 = var3[10];
            int var45 = 3 - var51;
            byte[] var59 = var14[var45][var13];
            int var37 = var59[0];
            var22 = var22 + var37 - 16;
            var37 = this.bP;
            var37 = var22 - var37;
            var22 = var3[1];
            byte[][][] var15 = this.e1093;
            int var55 = var3[10];
            var51 = 3 - var55;
            byte[] var60 = var15[var51][var13];
            int var46 = var60[1];
            var22 = var22 + var46 - 16;
            var46 = this.bQ;
            var46 = var22 - var46 + 13;
            var51 = var3[10];
            var51 = (3 - var51) * 5;
            boolean var56 = false;
            byte var57 = 5;
            byte var58 = 5;
            this.a(var34, var37, var46, var51, 0, var57, var58, 0, 0);
            var22 = var13 + 1;
            var13 = var22;
         }
      }
   }

   private void q(int var1, int var2) {
      byte var3 = 3;
      byte var4 = 1;
      long var5 = 1L;
      int var7 = 0;
      Image var8 = null;

      while (true) {
         int var9 = 4;
         if (var7 >= var9) {
            var7 = this.l;
            var9 = (byte)14;
            if (var7 == var9) {
               var8 = this.a1013[var3][17];
               byte[] var35 = this.o1098;
               int var38 = this.bw;
               var9 = (var35[var38] << 3) + var1;
               byte[][] var43 = this.Q1159;
               int var49 = this.aA;
               int var39 = var43[var49][0];
               byte[] var73 = this.o1098;
               int var67 = this.bw;
               var49 = (var73[var67] << 3) + 8;
               long var24 = this.a1019 & var5;
               var67 = (int)var24 << 1;
               var49 += var67;
               var39 *= var49;
               var9 += var39;
               byte[] var44 = this.o1098;
               var49 = this.bw;
               var39 = (var44[var49] << 3) + var2;
               byte[][] var74 = this.Q1159;
               var67 = this.aA;
               var73 = var74[var67];
               int var53 = var73[var4];
               byte[] var57 = this.o1098;
               int var61 = this.bw;
               var67 = (var57[var61] << 3) + 8;
               long var72 = this.a1019 & var5;
               var61 = (int)var72 << 1;
               var67 += var61;
               var53 *= var67;
               var39 += var53;
               var53 = this.aA;
               this.f(var8, var9, var39, var53);
            }

            return;
         }

         byte var28 = this.x1126;
         label22:
         if (var28) {
            byte[] var10 = this.p1099;
            int var11 = this.bw;
            var28 = var10[var11];
            if (var28 != 0) {
               boolean var30 = this.a(var1, var2, var7);
               if (!var30) {
                  break label22;
               }
            }

            Image var34 = this.a1013[var3][16];
            byte[] var12 = this.o1098;
            int var13 = this.bw;
            var11 = (var12[var13] << 3) + var1;
            int var45 = this.Q1159[var7][0];
            byte[] var14 = this.o1098;
            int var15 = this.bw;
            int var16 = (var14[var15] << 3) + 8;
            long var17 = this.a1019 & var5;
            var15 = (int)var17 << 1;
            var16 += var15;
            var45 *= var16;
            var11 += var45;
            byte[] var19 = this.o1098;
            var16 = this.bw;
            var45 = (var19[var16] << 3) + var2;
            var14 = this.Q1159[var7];
            int var65 = var14[var4];
            byte[] var20 = this.o1098;
            int var21 = this.bw;
            var15 = (var20[var21] << 3) + 8;
            long var22 = this.a1019 & var5;
            var21 = (int)var22 << 1;
            var15 += var21;
            var65 *= var15;
            var45 += var65;
            this.f(var34, var11, var45, var7);
         }

         var7++;
      }
   }

   private void q(int var1, int var2, int var3) {
      byte var4 = 32;
      this.a(var4, var1);
      Graphics var5 = this.a1002;
      Image var6 = this.a1013[var4][var1];
      var5.drawImage(var6, var2, var3, 0);
   }

   private boolean q(int var1, int var2) {
      int var3 = this.X;
      byte var4 = 2;
      if (var3 == var4) {
         switch (var1) {
            case 7:
               boolean var5 = g(var2);
               if (var5) {
                  return true;
               }
         }
      }

      return false;
   }

   private void r() {
      byte var1 = 18;
      byte var2 = 2;
      byte var3 = 1;
      int var4 = 0;
      Image var5 = null;
      byte var6 = 4;
      this.n();
      int var7 = this.h1047;
      switch (var7) {
         case -7:
            this.l = var3;
            this.c(0);
            byte var26 = 7;
            byte var14 = -1;
            this.g(var26, var14);
            break;
         case -6:
         case -5:
         case 53:
            this.l = 17;
            this.ac = 0;
            var4 = this.a1013[var6][var1].getWidth();
            var7 = 240 - var4 >> 1;
            this.Y = var7;
            var4 = this.V;
            var7 = 320 - var4;
            var4 = this.a1013[var6][var1].getHeight();
            var7 = var7 - var4 >> 1;
            this.Z = var7;
            Image var8 = this.a1013[var6][19];
            var7 = -var8.getWidth();
            this.aa = var7;
            var4 = this.V;
            var7 = 320 - var4;
            var5 = this.a1013[var6];
            var6 = 19;
            var5 = (Image)((Object[])var5)[var6];
            var4 = var5.getHeight();
            var7 = var7 - var4 >> 1;
            this.ab = var7;
            break;
         case -4:
         case 54:
            var7 = this.X - var3;
            this.X = var7;
            if (var7 < 0) {
               this.X = var2;
            }
            break;
         case -3:
         case 52:
            var7 = this.X + 1;
            this.X = var7;
            if (var7 > var2) {
               this.X = 0;
            }
      }
   }

   private void r(int var1) {
      int[][] var2 = this.b1066;
      int[] var3 = var2[var1];
      int var4 = var3[13];
      if (var4 > 0) {
         Image[] var15 = this.a1013[31];
         byte var5 = 5;
         Image var6 = var15[var5];
         var4 = var3[0] - 8;
         int var7 = this.bP;
         var7 = var4 - var7;
         var4 = var3[1] - 16;
         int var8 = this.bQ;
         var8 = var4 - var8 + 13;
         var4 = var3[20] - 1;
         int var9 = var4 * 21;
         boolean var10 = false;
         byte var11 = 21;
         byte var12 = 26;
         this.a(var6, var7, var8, var9, 0, var11, var12, 0, 0);
      }

      var4 = var3[15];
      if (var4 > 0) {
         Image[] var16 = this.a1013[31];
         byte var45 = 7;
         Image var49 = var16[var45];
         var4 = var3[0] - 8;
         int var54 = this.bP;
         var54 = var4 - var54;
         var4 = var3[1] - 16;
         int var64 = this.bQ;
         var64 = var4 - var64 + 13;
         var4 = var3[22];
         int var74 = var4 * 14;
         boolean var80 = false;
         byte var85 = 14;
         byte var90 = 11;
         this.a(var49, var54, var64, var74, 0, var85, var90, 0, 0);
      }

      var4 = var3[14];
      if (var4 > 0) {
         Image[] var17 = this.a1013[31];
         byte var46 = 4;
         Image var50 = var17[var46];
         var4 = var3[0] - 8;
         int var56 = this.bP;
         var56 = var4 - var56;
         var4 = var3[1] - 16;
         int var66 = this.bQ;
         var66 = var4 - var66 + 13;
         var4 = var3[21];
         int var75 = var4 * 14;
         boolean var81 = false;
         byte var86 = 14;
         byte var91 = 11;
         this.a(var50, var56, var66, var75, 0, var86, var91, 0, 0);
      }

      var4 = var3[11];
      if (var4 > 0) {
         Image[] var18 = this.a1013[31];
         byte var47 = 6;
         Image var51 = var18[var47];
         var4 = var3[0] - 8;
         byte[][] var13 = this.n1094;
         int var68 = var3[18];
         byte[] var95 = var13[var68];
         int var58 = var95[4];
         var4 += var58;
         var58 = this.bP;
         var58 = var4 - var58;
         var4 = var3[1] - 16;
         byte[][] var14 = this.n1094;
         int var76 = var3[18];
         byte[] var96 = var14[var76];
         int var69 = var96[5];
         var4 += var69;
         var69 = this.bQ;
         var4 -= var69;
         var69 = var4 + 13;
         byte[][] var19 = this.n1094;
         var76 = var3[18];
         byte var78 = var19[var76][0];
         var19 = this.n1094;
         int var82 = var3[18];
         byte var83 = var19[var82][1];
         var19 = this.n1094;
         int var87 = var3[18];
         byte var88 = var19[var87][2];
         var19 = this.n1094;
         int var92 = var3[18];
         byte var93 = var19[var92][3];
         this.a(var51, var58, var69, var78, var83, var88, var93, 0, 0);
      }

      var4 = var3[12];
      if (var4 > 0) {
         Image[] var23 = this.a1013[31];
         byte var48 = 3;
         Image var52 = var23[var48];
         var4 = var3[0] - 16;
         int var61 = this.bP;
         var61 = var4 - var61;
         var4 = var3[1] - 16;
         int var72 = this.bQ;
         var72 = var4 - var72 + 13;
         var4 = var3[19];
         int var79 = var4 * 28;
         boolean var84 = false;
         byte var89 = 28;
         byte var94 = 23;
         this.a(var52, var61, var72, var79, 0, var89, var94, 0, 0);
      }
   }

   private void r(int var1, int var2, int var3) {
      int var4 = 29;
      Graphics var5 = this.a1002;
      Image var6 = this.a1013[var4][42];
      int var7 = var1 + 4;
      int var8 = var2 - 15;
      var5.drawImage(var6, var7, var8, 0);
      int var9 = 5;
      if (var3 < var9) {
         Image[] var15 = this.a1013[var4];
         byte var10 = 41;
         var6 = var15[var10];
         var7 = var1 + 2;
         var9 = var2 - 18;
         byte[] var11 = this.z1148;
         var8 = var11[var3] + var9;
         var4 = var3 * 9;
         byte var12 = 9;
         byte var13 = 26;
         this.a(var6, var7, var8, var4, 0, var12, var13, 0, 0);
      }
   }

   private void s() {
      byte var1 = 6;
      byte var2 = 4;
      short var3 = 320;
      byte var4 = 3;
      int var5 = this.ad;
      this.b(var5, 13);
      Image var6 = this.a1013[var4][var4];
      this.a(var6, 0, 0, 13450878, true);
      Graphics var7 = this.a1002;
      var6 = this.a1013[var2][18];
      int var8 = this.Y;
      int var9 = this.Z;
      var7.drawImage(var6, var8, var9, 0);
      var7 = this.a1002;
      var6 = this.a1013[var2][19];
      var8 = this.aa;
      var9 = this.ab;
      var7.drawImage(var6, var8, var9, 0);
      this.a1002.setColor(15455661);
      var7 = this.a1002;
      int var10 = this.ad;
      var10 = var3 - var10;
      var9 = this.ad;
      var7.fillRect(0, var10, 240, var9);
      var6 = this.a1013[var4][var1];
      var5 = this.ad;
      var8 = var3 - var5;
      this.a(var6, 0, var8, 12010381, true);
      var5 = this.ad;
      var5 = var3 - var5;
      var10 = this.a1013[var4][var1].getHeight();
      var8 = var5 + var10 + 8;
      int var11 = this.ad - 32;
      this.c(0, var8, 240, var11, 0);
      var10 = this.ad;
      var10 = var3 - var10;
      var8 = this.a1013[var4][var1].getHeight();
      var10 = var10 + var8 + 6;
      this.e(2, var2, var10);
      String[] var27 = this.b1015;
      var8 = this.ac + 79;
      var10 = var27[var8].length();
      var8 = this.k;
      var10 *= var8;
      var5 = 240 - var10 - 2 >> 1;
      var10 = this.ad;
      var10 = var3 - var10 - 2;
      String[] var12 = this.b1015;
      var9 = this.ac + 79;
      String var65 = var12[var9];
      this.a(var65, var5, var10);
      var8 = var5 - var2;
      var9 = this.a1013[var4][24].getWidth();
      var8 -= var9;
      this.bR = var8;
      var12 = this.b1015;
      var9 = this.ac + 79;
      var8 = var12[var9].length();
      var9 = this.k;
      var8 *= var9;
      var5 = var5 + var8 + 2 + 4;
      this.bS = var5;
      var5 = this.j + 1;
      var8 = this.a1013[var4][24].getHeight();
      var5 = (var5 - var8 >> 1) + var10;
      this.bT = var5;
      var5 = this.bR;
      var10 = this.bS;
      var8 = this.bT;
      this.d(var5, var10, var8);
      this.a1002.setColor(5271185);
      String[] var31 = this.b1015;
      var10 = this.ac + 79 + 2;
      String var28 = var31[var10];
      var5 = this.ad;
      var5 = var3 - var5;
      var9 = this.a1013[var4][var1].getHeight();
      var9 = var5 + var9 + 8 + 12;
      int var13 = this.ad - 32;
      this.a(var28, 0, 8, var9, 224, var13);
      var8 = this.a1013[var2][25].getWidth();
      var10 = 240 - var8 >> 1;
      this.c(9, var10, 0);
   }

   private void s(int var1) {
      byte var2 = 1;
      byte var3 = 27;
      byte var4 = 26;
      byte var5 = 4;
      int[] var6 = this.b1066[var1];
      int var7 = var6[var4];
      if (var7 != 0) {
         var7 = var6[var3];
         byte var8 = -2;
         if (var7 != var8) {
            var7 = var6[var3] + 1;
            var6[var3] = var7;
            byte[][] var9 = this.o1095;
            int var10 = var6[var4] - var2;
            byte[] var31 = var9[var10];
            byte var32 = 2;
            var8 = var31[var32];
            label35:
            if (var7 >= var8) {
               var6[var3] = 0;
               var7 = var6[var4];
               var8 = 8;
               if (var7 != var8) {
                  var7 = var6[var4];
                  var8 = 6;
                  if (var7 != var8) {
                     break label35;
                  }
               }

               byte var15 = -2;
               var6[var3] = var15;
            }
         }
      }

      var7 = var6[var4];
      switch (var7) {
         case 2:
            var7 = var6[var5];
            int var30 = this.aZ;
            if (var7 == var30) {
               var7 = var6[var5];
               if (var7 < var5) {
                  var7 = var6[0] & 7;
                  if (var7 == 0) {
                     var7 = var6[var2] & 7;
                     if (var7 == 0) {
                        var7 = var6[var5] << 1;
                        var6[var5] = var7;
                     }
                  }
               }
            }
            break;
         case 7:
            var7 = var6[var5];
            int var29 = this.aZ;
            if (var7 > var29) {
               var7 = var6[0] & 7;
               if (var7 == 0) {
                  var7 = var6[var2] & 7;
                  if (var7 == 0) {
                     var7 = this.aZ;
                     var6[var5] = var7;
                  }
               }
            }
      }
   }

   private void s(int var1, int var2, int var3) {
      this.t(var1, var2, var3);
      this.u(var1, var2, var3);
   }

   private void t() {
      byte var1 = 18;
      short var2 = 240;
      byte var3 = 1;
      byte var4 = 4;
      this.n();
      int var5 = this.ae;
      switch (var5) {
         case 0:
            var5 = this.h1047;
            switch (var5) {
               case -7:
                  byte var39 = 15;
                  this.l = var39;
                  return;
               case -6:
               case -5:
               case 53:
                  byte var38 = 16;
                  this.l = var38;
                  return;
               case -4:
               case 54:
                  var5 = this.ac + 1;
                  this.ac = var5;
                  if (var5 > var3) {
                     this.ac = 0;
                     Image var49 = this.a1013[var4][var1];
                     var5 = -var49.getWidth();
                     this.Y = var5;
                  } else {
                     Image[] var50 = this.a1013[var4];
                     byte var71 = 19;
                     Image var51 = var50[var71];
                     var5 = -var51.getWidth();
                     this.aa = var5;
                  }

                  byte var37 = 2;
                  this.ae = var37;
                  return;
               case -3:
               case 52:
                  var5 = this.ac - var3;
                  this.ac = var5;
                  if (var5 < 0) {
                     this.ac = var3;
                     short var32 = 320;
                     this.aa = var32;
                  } else {
                     short var33 = 320;
                     this.Y = var33;
                  }

                  this.ae = var3;
                  return;
               default:
                  return;
            }
         case 1:
            var5 = this.ac;
            if (var5 == 0) {
               var5 = this.Y - 20;
               this.Y = var5;
               Image var76 = this.a1013[var4][var1];
               int var60 = var76.getWidth();
               var60 = var2 - var60 >> 1;
               byte var25;
               if (var5 < var60) {
                  Image var44 = this.a1013[var4][var1];
                  var25 = var44.getWidth();
                  var25 = var2 - var25 >> 1;
                  this.Y = var25;
                  var25 = var3;
               } else {
                  var25 = 0;
                  Object var45 = null;
               }

               var60 = this.aa - 20;
               this.aa = var60;
               Image[] var9 = this.a1013[var4];
               byte var11 = 19;
               Image var84 = var9[var11];
               int var86 = -var84.getWidth();
               byte var64;
               if (var60 < var86) {
                  Image[] var77 = this.a1013[var4];
                  byte var87 = 19;
                  var76 = var77[var87];
                  var64 = -var76.getWidth();
                  this.aa = var64;
                  var64 = var3;
               } else {
                  var64 = 0;
                  Object var79 = null;
               }

               if (var25 != 0 && var64 != 0) {
                  this.ae = 0;
               }
            } else {
               var5 = this.aa - 20;
               this.aa = var5;
               Image[] var80 = this.a1013[var4];
               int var88 = 19;
               Image var81 = var80[var88];
               int var65 = var81.getWidth();
               var65 = var2 - var65 >> 1;
               byte var29;
               if (var5 < var65) {
                  Image[] var46 = this.a1013[var4];
                  byte var67 = 19;
                  Image var47 = var46[var67];
                  var29 = var47.getWidth();
                  var29 = var2 - var29 >> 1;
                  this.aa = var29;
                  var29 = var3;
               } else {
                  var29 = 0;
                  Object var48 = null;
               }

               var65 = this.Y - 20;
               this.Y = var65;
               Image var85 = this.a1013[var4][var1];
               var88 = -var85.getWidth();
               byte var70;
               if (var65 < var88) {
                  Image var82 = this.a1013[var4][var1];
                  var70 = -var82.getWidth();
                  this.Y = var70;
                  var70 = var3;
               } else {
                  var70 = 0;
                  var80 = null;
               }

               if (var29 != 0 && var70 != 0) {
                  this.ae = 0;
               }
            }
            break;
         case 2:
            var5 = this.ac;
            if (var5 == 0) {
               var5 = this.Y + 20;
               this.Y = var5;
               Image var8 = this.a1013[var4][var1];
               int var7 = var8.getWidth();
               var7 = var2 - var7 >> 1;
               byte var16;
               if (var5 > var7) {
                  Image var6 = this.a1013[var4][var1];
                  var16 = var6.getWidth();
                  var16 = var2 - var16 >> 1;
                  this.Y = var16;
                  var16 = var3;
               } else {
                  var16 = 0;
                  Object var40 = null;
               }

               var7 = this.aa + 20;
               this.aa = var7;
               byte var54;
               if (var7 > var2) {
                  this.aa = var2;
                  var54 = var3;
               } else {
                  var54 = 0;
                  Object var72 = null;
               }

               if (var16 != 0 && var54 != 0) {
                  this.ae = 0;
               }
            } else {
               var5 = this.aa + 20;
               this.aa = var5;
               Image[] var73 = this.a1013[var4];
               byte var10 = 19;
               Image var74 = var73[var10];
               int var55 = var74.getWidth();
               var55 = var2 - var55 >> 1;
               byte var20;
               if (var5 > var55) {
                  Image[] var41 = this.a1013[var4];
                  byte var57 = 19;
                  Image var42 = var41[var57];
                  var20 = var42.getWidth();
                  var20 = var2 - var20 >> 1;
                  this.aa = var20;
                  var20 = var3;
               } else {
                  var20 = 0;
                  Object var43 = null;
               }

               var55 = this.Y + 20;
               this.Y = var55;
               byte var59;
               if (var55 > var2) {
                  this.Y = var2;
                  var59 = var3;
               } else {
                  var59 = 0;
                  var73 = null;
               }

               if (var20 != 0 && var59 != 0) {
                  this.ae = 0;
               }
            }
      }
   }

   private void t(int var1) {
      int[] var2 = this.c1107[var1];
      int[][] var3 = this.c1107;
      int var4 = this.bt;
      int var5 = 1;
      var4 -= var5;
      int[] var6 = var3[var4];
      int var7 = this.bz;
      var4 = this.b(var1);
      var7 += var4;
      this.bz = var7;
      var7 = var2[3];
      int var18 = 6;
      if (var7 == var18) {
         var7 = var2[2];
         var18 = var2[3];
         int var37 = this.q(var7, var18);
         if (var37) {
            var37 = 0;
            var3 = null;

            while (true) {
               var18 = this.bt;
               if (var37 >= var18) {
                  break;
               }

               int[] var8 = this.c1107[var37];
               var5 = (byte)17;
               boolean var9 = false;
               var8[var5] = 0;
               var37++;
            }
         }

         boolean[] var14 = this.f1106;
         var18 = var2[2];
         boolean var30 = false;
         var14[var18] = false;
      }

      int var22 = 0;
      Object var46 = null;
      var2[4] = 0;
      var7 = var2[2];
      switch (var7) {
         case 2:
         case 6:
         case 8:
         case 9:
         case 10:
            var22 = var2[0];
            var5 = var2[1];
            byte var40 = 5;
            int var47 = var2[var40];
            boolean var10 = false;
            boolean var11 = false;
            boolean var12 = true;
            this.a(var22, var5, var47, (byte)0, 0, var12);
         default:
            var22 = var2[0];
            var5 = var2[1];
            int var48 = var2[2];
            boolean var50 = false;
            this.c(var22, var5, var1, var48, false);
            var7 = this.bt;
            int var25 = 1;
            var7 -= var25;
            if (var1 != var7) {
               var25 = var6[0];
               var5 = var6[1];
               byte var43 = 2;
               var48 = var6[var43];
               var50 = true;
               this.c(var25, var5, var1, var48, var50);
            }

            var7 = 0;
            var3 = null;

            while (true) {
               int var27 = 18;
               if (var7 >= var27) {
                  var7 = this.bt - 1;
                  this.bt = var7;
                  return;
               }

               var27 = var6[var7];
               var2[var7] = var27;
               var7++;
            }
      }
   }

   private void t(int var1, int var2, int var3) {
      byte var4 = 3;
      if (var3 < var4) {
         Image[] var5 = this.a1013[29];
         byte var6 = 18;
         Image var7 = var5[var6];
         int var8 = this.N1149[var3][4] + var1;
         int var9 = this.bP;
         var9 = var8 - var9;
         var8 = this.N1149[var3][5] + var2;
         int var10 = this.bQ;
         var8 -= var10;
         var10 = var8 + 13;
         byte var11 = this.N1149[var3][0];
         byte var12 = this.N1149[var3][1];
         byte var13 = this.N1149[var3][2];
         var4 = this.N1149[var3][var4];
         this.a(var7, var9, var10, var11, var12, var13, var4, 0, 0);
      }
   }

   private void u() {
      byte var1 = 5;
      byte var2 = 2;
      byte var3 = 8;
      byte var4 = 1;
      this.n();
      int var5 = this.h1047;
      switch (var5) {
         case -7:
            byte var15 = this.t1089;
            if (!var15) {
               this.aO = 0;
               this.aN = 0;
               var15 = 17;
               this.l = var15;
            } else {
               this.aO = 0;
               this.aN = 0;
               this.B();
            }
            break;
         case -6:
         case -5:
         case 53:
            var5 = this.T;
            if (var5 == 0) {
               var5 = this.aN;
               if (var5 > 0) {
                  this.F(var1);
               } else {
                  this.ag = 0;
                  short[][] var6 = this.b1069;
                  int var7 = this.aN;
                  var5 = var6[var7][0] - var3;
                  this.bN = var5;
                  this.bP = var5;
                  var6 = this.b1069;
                  var7 = this.aN;
                  short[] var26 = var6[var7];
                  var5 = var26[var4] - var3;
                  this.bO = var5;
                  this.bQ = var5;
                  this.P();
                  this.a((int)var2);
               }
            } else {
               short[] var27 = this.d1073;
               int var40 = this.aN;
               int var12 = var27[var40];
               if (!var12) {
                  this.F(var1);
               } else {
                  this.ag = 0;
                  short[][] var28 = this.b1069;
                  var40 = this.aN;
                  var12 = var28[var40][0] - var3;
                  this.bN = var12;
                  this.bP = var12;
                  short[][] var29 = this.b1069;
                  var40 = this.aN;
                  var27 = var29[var40];
                  var12 = var27[var4] - var3;
                  this.bO = var12;
                  this.bQ = var12;
                  this.P();
                  this.a((int)var2);
               }
            }
      }

      var5 = this.aN;
      switch (var5) {
         case 2:
         case 3:
         case 4:
         case 5:
            byte[][] var33 = this.z1131;
            int var44 = this.aN;
            byte[] var34 = var33[var44];
            var5 = (var34.length >> 1) - var4;
            break;
         default:
            byte[][] var31 = this.z1131;
            int var43 = this.aN;
            byte[] var32 = var31[var43];
            var5 = var32.length - var4;
      }

      int var45 = this.k1029;
      if (var45) {
         var45 = this.h1047;
         switch (var45) {
            case -2:
            case 56:
               var45 = this.af + 1;
               this.af = var45;
               if (var45 > var4) {
                  this.af = 0;
               }
               break;
            case -1:
            case 50:
               var45 = this.af - var4;
               this.af = var45;
               if (var45 < 0) {
                  this.af = var4;
               }
         }

         var45 = this.af;
         switch (var45) {
            case 0:
               var5 = this.h1047;
               switch (var5) {
                  case -4:
                  case 54:
                     var5 = this.aO + 1;
                     this.aO = var5;
                     int var55 = 6;
                     if (var5 > var55) {
                        this.aO = 0;
                     }

                     byte[][] var37 = this.h1074;
                     var55 = this.X;
                     byte[] var38 = var37[var55];
                     var55 = this.aO;
                     byte var24 = var38[var55];
                     this.aN = var24;
                     return;
                  case -3:
                  case 52:
                     var5 = this.aO - var4;
                     this.aO = var5;
                     if (var5 < 0) {
                        byte var21 = 6;
                        this.aO = var21;
                     }

                     byte[][] var35 = this.h1074;
                     var45 = this.X;
                     byte[] var36 = var35[var45];
                     var45 = this.aO;
                     byte var22 = var36[var45];
                     this.aN = var22;
                     return;
                  default:
                     return;
               }
            case 1:
               var45 = this.h1047;
               switch (var45) {
                  case -4:
                  case 54:
                     var45 = this.ag + 1;
                     this.ag = var45;
                     if (var45 > var5) {
                        this.ag = 0;
                     }
                     break;
                  case -3:
                  case 52:
                     var45 = this.ag - var4;
                     this.ag = var45;
                     if (var45 < 0) {
                        this.ag = var5;
                     }
               }
         }
      } else {
         var45 = this.h1047;
         switch (var45) {
            case -4:
            case 54:
               var45 = this.ag + 1;
               this.ag = var45;
               if (var45 > var5) {
                  this.ag = 0;
               }
               break;
            case -3:
            case 52:
               var45 = this.ag - var4;
               this.ag = var45;
               if (var45 < 0) {
                  this.ag = var5;
               }
         }
      }
   }

   private void u(int var1) {
      this.bv = var1;
      this.w1111 = true;
      this.bu = 0;
   }

   private void u(int var1, int var2, int var3) {
      byte var4 = 2;
      if (var3 < var4) {
         int var16 = 0;
         Object var5 = null;
         int var6 = 0;

         while (true) {
            var5 = this.m1150[var3];
            var16 = ((Object[])var5).length;
            if (var6 >= var16) {
               break;
            }

            var5 = this.a1013[29];
            byte var7 = 17;
            Image var8 = (Image)((Object[])var5)[var7];
            var16 = this.m1150[var3][var6][4] + var1;
            int var9 = this.bP;
            var9 = var16 - var9;
            var16 = this.m1150[var3][var6][5] + var2;
            int var10 = this.bQ;
            var10 = var16 - var10 + 13;
            byte var11 = this.m1150[var3][var6][0];
            byte var12 = this.m1150[var3][var6][1];
            byte var13 = this.m1150[var3][var6][2];
            byte var14 = this.m1150[var3][var6][3];
            var5 = this.m1150[var3];
            var16 = ((Object[])var5).length;
            byte var15 = 3;
            var16 -= var15;
            if (var6 > var16) {
               byte var22 = 1;
               var15 = var22;
            } else {
               boolean var23 = false;
               var5 = null;
               var15 = 0;
            }

            this.a(var8, var9, var10, var11, var12, var13, var14, var15, 0);
            var16 = var6 + 1;
            var6 = var16;
         }
      }
   }

   private void v() {
      int var1 = this.ai;
      this.b(var1, 13);
      Image var2 = this.a1013[3][3];
      Image var3 = null;
      byte var4 = 1;
      this.a(var2, 0, 0, 13450878, (boolean)var4);
      this.a1002.setColor(15455661);
      Graphics var5 = this.a1002;
      int var6 = this.ai;
      int var7 = 320 - var6 - 10;
      int var8 = this.ai;
      var5.fillRect(0, var7, 240, var8);
      var5 = this.a1002;
      int var67 = 240;
      var8 = this.aj;
      var5.setClip(0, 13, var67, var8);
      int var9 = this.a1013[4][7].getWidth();
      int var10 = 240 - var9 >> 1;
      var1 = this.aj;
      var9 = this.a1013[4][7].getHeight();
      int var11 = (var1 - var9 >> 1) + 13;
      var5 = this.a1002;
      var2 = this.a1013[4][7];
      int var81 = 0;
      Image var12 = null;
      var5.drawImage(var2, var10, var11, 0);
      int var26 = 0;
      Graphics var57 = null;
      int var13 = 0;

      while (true) {
         var26 = (byte)9;
         if (var13 >= var26) {
            long var17 = this.a1019;
            long var19 = 1L;
            var17 &= var19;
            var26 = (int)var17;
            if (var26 == 0) {
               var57 = this.a1013[4];
               byte var119 = 20;
               var2 = (Image)((Object[])var57)[var119];
               var57 = this.b1030;
               var81 = this.aN;
               var57 = ((Object[])var57)[var81];
               var12 = null;
               byte var32 = (byte)((Object[])var57)[0];
               var81 = var10 + var32;
               var57 = this.b1030;
               var67 = this.aN;
               var32 = (byte)((Object[])((Object[])var57)[var67])[1];
               var67 = var11 + var32;
               byte var110 = 9;
               var4 = (boolean)0;
               byte var136 = 9;
               byte var139 = 9;
               this.a(var2, var81, var67, var110, 0, var136, var139, 0, 0);
            }

            var2 = this.a1013[3][6];
            var67 = this.aj + 13;
            this.a(var2, 0, var67, 12010381, true);
            this.a1002.setColor(16580557);
            var57 = this.a1002;
            var81 = this.aj + 10;
            var57.fillRect(200, var81, 40, 15);
            var2 = this.a1013[4][24];
            var12 = this.a1013[4][24];
            var81 = var12.getWidth() >> 1;
            var81 = 240 - var81;
            var67 = this.aj + 10;
            var26 = this.af;
            Image var135 = this.a1013[4][24];
            var8 = (var135.getWidth() >> 1) * var26;
            var26 = this.a1013[4][24].getWidth();
            int var137 = var26 >> 1;
            int var140 = this.a1013[4][24].getHeight();
            this.a(var2, var81, var67, var8, 0, var137, var140, 0, 0);
            Image var65 = this.a1013[3][24];
            int var120 = 200;
            var81 = this.aj + 12;
            long var21 = this.a1019;
            long var23 = 1L;
            var21 &= var23;
            var4 = 1;
            var21 <<= var4;
            var67 = (int)var21;
            var81 += var67;
            var67 = this.af;
            byte var75;
            if (var67 == 0) {
               var75 = 4;
            } else {
               var75 = 6;
            }

            this.a(var65, var120, var81, var75);
            String[] var46 = this.b1015;
            var81 = (this.aN << 1) + 83;
            var120 = var46[var81].length();
            var81 = this.k;
            var120 *= var81;
            var26 = 240 - var120 - 2 >> 1;
            var81 = this.ai;
            var140 = 320 - var81 - 13 - 2;
            String[] var47 = this.b1015;
            var81 = (this.aN << 1) + 83;
            String var48 = var47[var81];
            this.a(var48, var26, var140);
            int var123 = this.k1029;
            if (var123) {
               var123 = var26 - 4;
               var81 = this.a1013[3][24].getWidth();
               var123 -= var81;
               String[] var133 = this.b1015;
               var75 = (this.aN << 1) + 83;
               String var134 = var133[var75];
               var81 = var134.length();
               var75 = this.k;
               var81 *= var75;
               var26 = var26 + var81 + 2 + 4;
               var81 = this.j + 1;
               var3 = this.a1013[3];
               byte var112 = 24;
               var3 = (Image)((Object[])var3)[var112];
               var75 = var3.getHeight();
               var81 = (var81 - var75 >> 1) + var140;
               this.d(var123, var26, var81);
            }

            var81 = this.ah;
            var26 = 320 - var81;
            var81 = this.a1013[3][6].getHeight();
            var81 = var26 + var81 + 10;
            var8 = this.ah;
            this.c(0, var81, 240, var8, 0);
            var75 = this.ah;
            var81 = 320 - var75;
            var75 = this.a1013[3][6].getHeight();
            var81 = var81 + var75 + 6;
            this.e(2, 4, var81);
            this.a1002.setColor(5271185);
            String[] var66 = this.b1015;
            var123 = (this.aN << 1) + 83 + 1;
            String var49 = var66[var123];
            var8 = this.ah;
            var26 = 320 - var8;
            var8 = this.a1013[3][6].getHeight();
            var8 = var26 + var8 + 8 + 12;
            var137 = this.ah - 32;
            this.a(var49, 0, 8, var8, 224, var137);
            var81 = this.a1013[4][25].getWidth();
            var123 = 240 - var81 >> 1;
            this.c(8, var123, 0);
            var26 = this.aN;
            var81 = this.a1013[4][21].getWidth() / 9;
            var123 = 240 - var81;
            var81 = this.a1013[4][23].getWidth() << 2;
            var123 = var123 - var81 - 10 >> 1;
            var81 = var140 + 20;
            this.f(var26, var123, var81);
            return;
         }

         Image[] var58 = this.a1013[4];
         byte var118 = 20;
         var2 = var58[var118];
         byte[] var59 = this.b1030[var13];
         var12 = null;
         int var28 = var59[0];
         var81 = var10 + var28;
         var28 = this.b1030[var13][1];
         var67 = var11 + var28;
         boolean var109 = false;
         Object var14 = null;
         boolean var52 = false;
         byte var15 = 9;
         byte var16 = 9;
         this.a(var2, var81, var67, 0, 0, var15, var16, 0, 0);
         var28 = var13 + 1;
         var13 = var28;
      }
   }

   private void v(int var1) {
      byte var2 = 1;
      int[] var3 = this.c1107[var1];
      var3[9] = 0;
      var3[10] = var2;
      var3[4] = var2;
      this.w(var1);
   }

   private void v(int var1, int var2, int var3) {
      int[] var4 = this.b1066[var1];
      int[][] var5 = this.c1107;
      int[] var6 = var5[var3];
      int var7 = var4[2];
      if (var7 > 0) {
         var7 = var6[2];
         switch (var7) {
            case 1:
               var7 = var6[3];
               int var105 = var4[23];
               byte var130 = 1;
               var105 -= var130;
               if (var7 >= var105) {
                  var105 = var6[3] + 1;
                  var4[23] = var105;
                  int var64 = g(var6[3]);
                  if (var64) {
                     var64 = this.X;
                     switch (var64) {
                        case 0:
                           var64 = var4[26];
                           byte var110 = 7;
                           if (var64 != var110) {
                              var4[15] = 48;
                              byte var69 = 22;
                              boolean var111 = false;
                              Object var142 = null;
                              var4[var69] = 0;
                           }

                           byte var70 = 14;
                           var110 = 48;
                           var4[var70] = var110;
                           break;
                        case 1:
                           byte var67 = 14;
                           byte var109 = 48;
                           var4[var67] = var109;
                           break;
                        case 2:
                           byte var66 = 14;
                           byte var108 = 96;
                           var4[var66] = var108;
                     }
                  } else {
                     byte var71 = 14;
                     byte var113 = 48;
                     var4[var71] = var113;
                  }
               }

               byte var72 = 21;
               boolean var114 = false;
               Object var143 = null;
               var4[var72] = 0;
            case 2:
            case 6:
            default:
               break;
            case 3:
               int var57 = g(var6[3]);
               if (var57) {
                  var57 = this.X;
                  switch (var57) {
                     case 0:
                     case 1:
                        byte var60 = 11;
                        byte var102 = 48;
                        var4[var60] = var102;
                        break;
                     case 2:
                        byte var59 = 11;
                        byte var101 = 96;
                        var4[var59] = var101;
                  }
               } else {
                  byte var61 = 11;
                  byte var103 = 48;
                  var4[var61] = var103;
               }

               var4[13] = 0;
               byte var62 = 18;
               boolean var104 = false;
               Object var141 = null;
               var4[var62] = 0;
               break;
            case 4:
               var7 = this.X;
               int var93 = 2;
               byte var44;
               if (var7 == var93) {
                  var44 = 0;
                  var5 = null;
               } else {
                  byte[] var20 = this.A1151;
                  var93 = var6[3];
                  var44 = var20[var93];
               }

               int var45 = this.h(var44);
               if (var45) {
                  var45 = g(var6[3]);
                  if (var45) {
                     var45 = this.X;
                     label120:
                     switch (var45) {
                        case 0:
                           byte var54 = 12;
                           byte var98 = 96;
                           var4[var54] = var98;
                           break;
                        case 1:
                           int var49 = 0;
                           var5 = null;
                           int var145 = 0;

                           while (true) {
                              var49 = this.aP;
                              if (var145 >= var49) {
                                 break label120;
                              }

                              int[] var22 = this.b1066[var145];
                              var49 = var22[0];
                              int[] var139 = this.b1066[var145];
                              var93 = var139[1];
                              int var128 = var4[0] - 24;
                              int var146 = var4[0] - 24;
                              byte var148 = 48;
                              byte var149 = 48;
                              int var52 = a(var49, var93, var128, var146, var148, var149);
                              if (var52) {
                                 int[] var23 = this.b1066[var145];
                                 byte var97 = 12;
                                 byte var129 = 48;
                                 var23[var97] = var129;
                              }

                              var52 = var145 + 1;
                              var145 = var52;
                           }
                        case 2:
                           byte var48 = 12;
                           byte var95 = 48;
                           var4[var48] = var95;
                     }
                  } else {
                     byte var55 = 12;
                     byte var99 = 48;
                     var4[var55] = var99;
                  }
               }

               byte var56 = 19;
               boolean var100 = false;
               Object var140 = null;
               var4[var56] = 0;
               break;
            case 5:
               var7 = this.X;
               int var86 = 2;
               byte var30;
               if (var7 == var86) {
                  var30 = 0;
                  var5 = null;
               } else {
                  var30 = 3;
               }

               int var31 = this.h(var30);
               if (var31) {
                  var31 = g(var6[3]);
                  if (var31) {
                     var31 = this.X;
                     label109:
                     switch (var31) {
                        case 0:
                           byte var40 = 13;
                           var86 = (byte)96;
                           var4[var40] = var86;
                           break;
                        case 1:
                           int var35 = 0;
                           var5 = null;
                           int var11 = 0;

                           while (true) {
                              var35 = this.aP;
                              if (var11 >= var35) {
                                 break label109;
                              }

                              int[] var17 = this.b1066[var11];
                              var35 = var17[0];
                              int[] var137 = this.b1066[var11];
                              var86 = var137[1];
                              int var9 = var4[0] - 24;
                              int var12 = var4[0] - 24;
                              byte var13 = 48;
                              byte var14 = 48;
                              int var38 = a(var35, var86, var9, var12, var13, var14);
                              if (var38) {
                                 int[] var18 = this.b1066[var11];
                                 byte var89 = 13;
                                 byte var127 = 48;
                                 var18[var89] = var127;
                              }

                              var38 = var11 + 1;
                              var11 = var38;
                           }
                        case 2:
                           byte var34 = 13;
                           var86 = (byte)48;
                           var4[var34] = var86;
                     }
                  } else {
                     byte var41 = 13;
                     byte var91 = 48;
                     var4[var41] = var91;
                  }
               }

               var4[11] = 0;
               byte var42 = 20;
               boolean var92 = false;
               Object var138 = null;
               var4[var42] = 0;
               break;
            case 7:
               int var25 = g(var6[3]);
               if (var25) {
                  var25 = this.X;
                  switch (var25) {
                     case 0:
                        var25 = var4[26];
                        byte var8 = 7;
                        if (var25 != var8) {
                           var4[15] = 48;
                           byte var28 = 22;
                           boolean var85 = false;
                           Object var10 = null;
                           var4[var28] = 0;
                        }
                  }
               }
         }

         var7 = var6[17];
         int var115 = 1;
         if (var7 == var115) {
            var7 = var2 + 10;
         } else {
            var7 = var2;
         }

         var115 = var6[2];
         int var131 = var6[3];
         int var117 = this.l(var115, var131);
         if (var117) {
            var4[16] = var7;
            var117 = (byte)2;
            var131 = var4[var117];
            var7 = var131 - var7;
            var4[var117] = var7;
         } else {
            var117 = var4[3];
            if (var117 < var7) {
               var131 = var4[3];
               var131 = var7 - var131;
               var4[16] = var131;
               byte var120 = 2;
               var131 = var4[var120];
               int var147 = var4[3];
               var7 -= var147;
               var7 = var131 - var7;
               var4[var120] = var7;
            } else {
               var4[16] = 1;
               byte var78 = 2;
               var117 = var4[var78];
               byte var136 = 1;
               var117 -= var136;
               var4[var78] = var117;
            }
         }

         var7 = var4[10];
         byte var123 = -1;
         if (var7 == var123) {
            byte var80 = 10;
            var123 = 4;
            var4[var80] = var123;
         }

         var7 = this.aV;
         var123 = 4;
         if (var7 == var123) {
            var7 = var4[12];
            if (var7 == 0) {
               var7 = var4[13];
               if (var7 == 0) {
                  var4[11] = 0;
                  byte var84 = 25;
                  boolean var126 = false;
                  Object var144 = null;
                  var4[var84] = 0;
               }
            }
         }
      }
   }

   private final void w() {
      byte var1 = 1;
      short var2 = 320;
      short var3 = 240;
      byte var4 = 2;
      this.c(var4);
      int var5 = this.a1013[var4][0].getWidth();
      int var6 = this.a1013[var4][0].getHeight();
      int var7 = this.a1013[var4][var1].getWidth();
      int var8 = this.a1013[var4][var1].getHeight();
      var5 = var3 - var5 >> 1;
      var6 = var2 - var6 >> 1;
      int var9 = var3 - var7 >> 1;
      int var10 = var2 - var8 >> 1;
      this.a1002.setClip(0, 0, var3, var2);
      this.a1002.setColor(16777215);
      this.a1002.fillRect(0, 0, var3, var2);
      Graphics var11 = this.a1002;
      Image var12 = this.a1013[var4][0];
      var11.drawImage(var12, var5, var6, 0);
      Graphics var13 = this.a1002;
      var6 = var8 + 2;
      var8 = this.am;
      var6 = var6 * var8 / 100;
      var13.setClip(var9, var10, var7, var6);
      var13 = this.a1002;
      Image var14 = this.a1013[var4][var1];
      var13.drawImage(var14, var9, var10, 0);
   }

   private void w(int var1) {
      byte var2 = 9;
      byte var3 = 5;
      byte var4 = 2;
      byte var5 = 1;
      int[] var6 = this.c1107[var1];
      int[][] var7 = this.b1066;
      int var8 = var6[8];
      int[] var18 = var7[var8];
      var8 = var6[var4];
      switch (var8) {
         case 0:
         case 4:
            int var24 = 0;

            while (var24 < var3) {
               byte[] var30 = this.C1134[var1];
               var30[var24] = var24++;
            }

            var24 = var6[0];
            byte[] var31 = this.o1098;
            int var39 = var6[var4];
            int var56 = var31[var39] << 3;
            var24 += var56;
            var56 = var6[var5];
            byte[] var60 = this.o1098;
            int var66 = var6[var4];
            var39 = var60[var66] << 3;
            var56 += var39;
            var39 = var18[0];
            var66 = var18[var5];
            var39 = this.a(var24, var56, var39, var66);
            var6[var2] = var39;
            var39 = c(var6[var2]);
            var6[var3] = var39;
            var39 = var6[var4];
            byte var45;
            if (var39 == 0) {
               var45 = 0;
               var60 = null;
            } else {
               var45 = var5;
            }

            byte[][] var71 = this.j1139[var45];
            int var74 = var6[var3];
            byte[] var72 = var71[var74];
            byte var68 = var72[0];
            byte[][][] var16 = this.j1139;
            byte[][] var62 = var16[var45];
            var74 = var6[3];
            if (var74 > var3) {
               var74 = var3;
            } else {
               var74 = var6[3];
            }

            var74 = (var74 >> 1) + 4;
            var60 = var62[var74];
            var45 = var60[0] + var68;
            var68 = 11;
            var74 = var18[0];
            var24 += var45;
            var24 = (var74 - var24) / 5;
            var6[var68] = var24;
            byte var29 = 12;
            int var86 = var18[var5];
            var56 += var45;
            var86 = (var86 - var56) / 5;
            var6[var29] = var86;
            break;
         case 1:
            int var49 = var18[0];
            int var32 = var6[0];
            byte[] var14 = this.o1098;
            int var15 = var6[var4];
            int var13 = var14[var15] << 3;
            var32 += var13;
            var49 = var49 - var32 >> 2;
            var6[11] = var49;
            var49 = var18[var5];
            var32 = var6[var5];
            var14 = this.o1098;
            var15 = var6[var4];
            var13 = var14[var15] << 3;
            var32 += var13;
            var49 = var49 - var32 >> 2;
            var6[12] = var49;
            var8 = var6[0];
            byte[] var9 = this.o1098;
            var32 = var6[var4];
            var49 = var9[var32] << 3;
            var8 += var49;
            var49 = var6[var5];
            byte[] var12 = this.o1098;
            var13 = var6[var4];
            var32 = var12[var13] << 3;
            var49 += var32;
            var32 = var18[0];
            int var83 = var18[var5];
            var83 = this.a(var8, var49, var32, var83);
            var6[var2] = var83;
            var83 = c(var6[var2]);
            var6[var3] = var83;
            break;
         case 2:
            byte var82 = 10;
            var6[var82] = 0;
            break;
         case 3:
         case 5:
         case 7:
            int var11 = var18[0];
            byte var10 = 8;
            var11 -= var10;
            var6[11] = var11;
            byte var21 = 12;
            int var79 = var18[var5];
            byte var48 = 30;
            var79 -= var48;
            var6[var21] = var79;
            byte var81 = 10;
            var6[var81] = 0;
         case 6:
         default:
            break;
         case 8:
         case 9:
            var6[10] = 0;
            byte var17 = 11;
            var8 = this.a() % 3;
            var6[var17] = var8;
      }
   }

   private void w(int var1, int var2, int var3) {
      int var4 = var2 << 4;
      int var5 = this.bA;
      var4 -= var5;
      var5 = this.bB;
      var4 += var5;
      var5 = var1 << 4;
      int var6 = this.bC;
      var5 -= var6;
      var6 = this.bD;
      var5 += var6;
      short var48 = 256;
      int var7;
      if (var4 >= var48) {
         var4 += -256;
         var7 = var4;
      } else {
         var7 = var4;
      }

      int var22 = 304;
      int var8;
      if (var5 >= var22) {
         var22 = var5 + -304;
         var8 = var22;
      } else {
         var8 = var5;
      }

      var22 = 0;
      Object var9 = null;
      if (var3 == 0) {
         Image var10 = null;
         int var11 = 0;
         var5 = var7;

         while (true) {
            int var49 = 16;
            if (var11 >= var49) {
               break;
            }

            var49 = var11 + var2;
            int var12 = this.bG;
            if (var49 < var12) {
               byte[] var13 = this.B1160;
               var12 = this.bG * var1 + var2 + var11;
               int var14 = var13[var12] & 255;
               var49 = this.aN;
               int var15;
               if (var49 != 0) {
                  var9 = this.F1164;
                  var49 = this.bG * var1 + var2 + var11;
                  var22 = ((Object[])var9)[var49] & 255;
                  var15 = var22;
               } else {
                  var15 = var22;
               }

               int var26 = 256;
               if (var5 >= var26) {
                  var26 = var5 + -256;
                  var7 = var26;
               } else {
                  var7 = var5;
               }

               var9 = this.a1013;
               var5 = this.bL;
               var9 = ((Object[])var9)[var5];
               int var39 = 0;
               var10 = (Image)((Object[])var9)[0];
               byte var53 = 1;
               byte var87 = 16;
               byte var16 = 16;
               var9 = this.C1161;
               int var17 = this.bG * var1 + var2 + var11;
               int var103 = (int)((Object[])var9)[var17];
               this.a(var10, var53, var87, var16, var103, var7, var8, var14);
               var26 = this.aN;
               if (var26 != 0 && var15 != 0) {
                  var9 = this.a1013;
                  var39 = this.bM;
                  var9 = ((Object[])var9)[var39];
                  boolean var41 = false;
                  var10 = (Image)((Object[])var9)[0];
                  var53 = 1;
                  var87 = 16;
                  var16 = 16;
                  var9 = this.G1165;
                  var103 = this.bG * var1 + var2 + var11;
                  byte var105 = (byte)((Object[])var9)[var103];
                  this.a(var10, var53, var87, var16, var105, var7, var8, var15);
               }

               var22 = var15;
               var5 = var7;
            }

            var49 = var11 + 1;
            var5 += 16;
            var11 = var49;
         }
      } else {
         Image var82 = null;
         int var85 = 0;
         var5 = var8;

         while (true) {
            int var56 = 19;
            if (var85 >= var56) {
               break;
            }

            var56 = var85 + var1;
            int var89 = this.bH;
            if (var56 < var89) {
               byte[] var95 = this.B1160;
               var89 = var1 + var85;
               int var100 = this.bG;
               var89 = var89 * var100 + var2;
               int var96 = var95[var89] & 255;
               var56 = this.aN;
               int var98;
               if (var56 != 0) {
                  var9 = this.F1164;
                  var56 = var1 + var85;
                  var89 = this.bG;
                  var56 = var56 * var89 + var2;
                  var22 = ((Object[])var9)[var56] & 255;
                  var98 = var22;
               } else {
                  var98 = var22;
               }

               int var30 = 304;
               if (var5 >= var30) {
                  var30 = var5 + -304;
                  var8 = var30;
               } else {
                  var8 = var5;
               }

               var9 = this.a1013;
               var5 = this.bL;
               var9 = ((Object[])var9)[var5];
               int var44 = 0;
               var82 = (Image)((Object[])var9)[0];
               byte var61 = 1;
               byte var93 = 16;
               byte var101 = 16;
               var9 = this.C1161;
               int var106 = var1 + var85;
               int var18 = this.bG;
               var106 = var106 * var18 + var2;
               int var108 = (int)((Object[])var9)[var106];
               this.a(var82, var61, var93, var101, var108, var7, var8, var96);
               var30 = this.aN;
               if (var30 != 0 && var98 != 0) {
                  var9 = this.a1013;
                  var44 = this.bM;
                  var9 = ((Object[])var9)[var44];
                  boolean var46 = false;
                  var82 = (Image)((Object[])var9)[0];
                  var61 = 1;
                  var93 = 16;
                  var101 = 16;
                  var9 = this.G1165;
                  var108 = var1 + var85;
                  var96 = this.bG;
                  var108 = var108 * var96 + var2;
                  byte var111 = (byte)((Object[])var9)[var108];
                  this.a(var82, var61, var93, var101, var111, var7, var8, var98);
               }

               var22 = var98;
               var5 = var8;
            }

            var56 = var85 + 1;
            var5 += 16;
            var85 = var56;
         }
      }
   }

   private void x() {
      short var1 = 320;
      byte var2 = 2;
      byte var3 = 1;
      this.c(var3);
      int var4 = this.b1034[0];
      int var5 = this.b1034[var3];
      var4 += var5;
      var5 = this.b1034[var2];
      var4 += var5;
      int var6 = Math.abs(var1 - var4 >> 2);
      var5 = Math.min(15, var6);
      this.an = var5;
      var4 = var1 - var4;
      var5 = this.an << 1;
      var4 = var4 - var5 >> 1;
      int[] var7 = this.g1035;
      var6 = (this.b1034[0] >> 1) + var4;
      var7[0] = var6;
      var7 = this.g1035;
      int var24 = this.b1034[0];
      var4 += var24;
      var24 = this.an;
      var4 += var24;
      var7[var3] = var4;
      int[] var8 = this.g1035;
      var5 = this.g1035[var3];
      int var26 = this.b1034[var3];
      var5 += var26;
      var26 = this.an;
      var5 += var26;
      var8[var2] = var5;
      var5 = this.a1013[var3][7].getWidth();
      var4 = 240 - var5 >> 1;
      this.ao = var4;
   }

   private void x(int var1) {
      int[] var2 = this.c1107[var1];
      var2[4] = 2;
      var2[10] = 3;
      var2[9] = 0;
      var2[13] = 0;
   }

   private void y() {
      short var1 = 320;
      byte var2 = 3;
      byte var3 = 6;
      byte var4 = 2;
      this.a1002.setColor(16777215);
      Graphics var5 = this.a1002;
      short var6 = 240;
      var5.fillRect(0, 0, var6, var1);
      int var7 = 0;
      Object var18 = null;

      while (true) {
         int var19 = this.a1038;
         if (var7 >= var19) {
            return;
         }

         int[] var8;
         int var9;
         int var10;
         label29: {
            var8 = this.a1039[var7];
            var9 = var8[0];
            var10 = var8[1];
            int var11 = var8[var4];
            if (var11 != var2) {
               var11 = var8[var4];
               int var12 = 4;
               if (var11 != var12) {
                  var11 = var8[var4];
                  if (var11 == var4) {
                     var11 = var8[var2];
                     var12 = var8[4];
                     var11 -= var12;
                     var12 = var8[5];
                     int var46 = 1;
                     if (var12 == var46) {
                        var12 = var8[var2];
                        var11 = var12 - var11 - var4;
                     }

                     var12 = var8[var3] * var11;
                     var9 -= var12;
                     Graphics var43 = this.a1002;
                     var46 = var8[var3];
                     var11 = var11 * var46 + var9;
                     var46 = var8[var3];
                     var43.setClip(var11, var10, var46, var1);
                  }
                  break label29;
               }
            }

            byte[] var13 = this.c1037;
            int var32 = var8[var3] << 1;
            byte var25 = var13[var32];
            var9 -= var25;
            Graphics var38 = this.a1002;
            byte[] var14 = this.c1037;
            int var15 = var8[var3] << 1;
            var32 = var14[var15] + var9;
            byte[] var16 = this.c1037;
            int var17 = (var8[var3] << 1) + 1;
            byte var44 = var16[var17];
            var38.setClip(var32, var10, var44, var1);
            Graphics var39 = this.a1002;
            Image[] var41 = this.a1013[1];
            var44 = 7;
            Image var42 = var41[var44];
            var39.drawImage(var42, var9, var10, 0);
         }

         int var30 = var8[var4];
         if (var30 != var2) {
            var19 = var8[var4];
            byte var31 = 4;
            if (var19 != var31) {
               Graphics var21 = this.a1002;
               Image var40 = this.a1040[var7];
               var21.drawImage(var40, var9, var10, 0);
            }
         }

         Graphics var22 = this.a1002;
         short var23 = 240;
         var22.setClip(0, 0, var23, var1);
         var7++;
      }
   }

   private void y(int var1) {
      int[][] var2 = this.c1107;
      int[] var4 = var2[var1];
      Object var3 = null;
      int var5 = var4[0];
      byte[] var23 = this.o1098;
      int var7 = var4[2];
      int var8 = var23[var7] << 3;
      int var9 = var5 + var8;
      var5 = var4[1];
      byte[] var24 = this.o1098;
      var7 = var4[2];
      var8 = var24[var7] << 3;
      int var10 = var5 + var8;
      var5 = var4[2];
      switch (var5) {
         case 0:
            var5 = var4[13];
            byte var211 = 3;
            if (var5 < var211) {
               Image[][] var60 = this.a1013;
               var3 = var60[29];
               var211 = 2;
               Image var145 = (Image)((Object[])var3)[var211];
               Image[][] var61 = this.a1013;
               var3 = var61[29];
               byte var177 = 1;
               Image var220 = (Image)((Object[])var3)[var177];
               byte[][] var62 = this.D1135;
               int var248 = var4[13];
               byte var263 = var62[var248][2];
               var62 = this.D1135;
               var248 = var4[13];
               byte var274 = var62[var248][3];
               var62 = this.D1135;
               var248 = var4[13];
               var3 = var62[var248];
               Object var279 = null;
               byte var288 = (byte)((Object[])var3)[0];
               var62 = this.D1135;
               var248 = var4[13];
               byte var297 = var62[var248][1];
               this.a(var145, var220, var1, var263, var274, var288, var297);
            }
            break;
         case 1:
            byte[][][] var48 = this.j1139;
            var3 = var48[2];
            var8 = var4[5];
            var3 = ((Object[])var3)[var8];
            int var200 = 0;
            int var112 = (int)((Object[])var3)[0];
            byte[][][] var49 = this.j1139;
            byte[][] var137 = var49[2];
            var7 = var4[3];
            int var237 = 5;
            if (var7 > var237) {
               var7 = 5;
            } else {
               var7 = var4[3];
            }

            var7 = (var7 >> 1) + 4;
            byte[] var138 = var137[var7];
            Object var218 = null;
            var200 = var138[0];
            int var18 = var112 + var200;
            byte[][][] var50 = this.j1139;
            var3 = var50[2];
            var200 = var4[5];
            var3 = ((Object[])var3)[var200];
            byte var203 = 1;
            var112 = (byte)((Object[])var3)[var203];
            byte[][][] var51 = this.j1139;
            var137 = var51[2];
            var7 = var4[3];
            var237 = (byte)5;
            if (var7 > var237) {
               var7 = 5;
            } else {
               var7 = var4[3];
            }

            var7 = (var7 >> 1) + 4;
            byte[] var140 = var137[var7];
            int var171 = 1;
            var203 = var140[var171];
            int var19 = var112 + var203 + 13;
            var112 = var4[13];
            var203 = 4;
            if (var112 < var203) {
               var112 = var4[13];
               var203 = 3;
               if (var112 < var203) {
                  Image[][] var52 = this.a1013;
                  var3 = var52[29];
                  var203 = 5;
                  Image var141 = (Image)((Object[])var3)[var203];
                  boolean var172 = false;
                  var218 = null;
                  byte[][] var53 = this.D1135;
                  var237 = var4[13];
                  byte var259 = var53[var237][2];
                  var53 = this.D1135;
                  var237 = var4[13];
                  byte var270 = var53[var237][3];
                  var53 = this.D1135;
                  var237 = var4[13];
                  var3 = var53[var237];
                  Object var278 = null;
                  byte var285 = (byte)((Object[])var3)[0];
                  var53 = this.D1135;
                  var237 = var4[13];
                  byte var294 = var53[var237][1];
                  this.a(var141, null, var1, var259, var270, var285, var294);
               }

               int var116 = 0;
               var3 = null;
               int var20 = 0;

               while (true) {
                  var116 = var4[13] + 1;
                  if (var20 >= var116) {
                     return;
                  }

                  if (var20 > 0) {
                     Image[][] var57 = this.a1013;
                     var3 = var57[29];
                     var203 = 7;
                     Image var142 = (Image)((Object[])var3)[var203];
                     var116 = var9 + var18;
                     var171 = var4[11] * var20;
                     var116 += var171;
                     int var299 = this.bP;
                     var171 = var116 - var299;
                     var116 = var10 + var19;
                     var237 = var4[12] * var20;
                     var116 += var237;
                     var299 = this.bQ;
                     var237 = var116 - var299;
                     int var260 = var20 * 10;
                     boolean var271 = false;
                     byte var286 = 10;
                     byte var295 = 10;
                     boolean var305 = false;
                     this.a(var142, var171, var237, var260, 0, var286, var295, 0, 0);
                  }

                  var116 = var4[13];
                  if (var20 == var116) {
                     Image[][] var58 = this.a1013;
                     var3 = var58[29];
                     var203 = 6;
                     Image var143 = (Image)((Object[])var3)[var203];
                     var116 = var9 + var18;
                     var171 = var4[11] * var20;
                     var116 += var171;
                     int var301 = this.bP;
                     var171 = var116 - var301;
                     var116 = var10 + var19;
                     var237 = var4[12] * var20;
                     var116 += var237;
                     var301 = this.bQ;
                     var237 = var116 - var301;
                     int var261 = var20 * 12;
                     boolean var272 = false;
                     byte var287 = 12;
                     byte var296 = 12;
                     boolean var306 = false;
                     this.a(var143, var171, var237, var261, 0, var287, var296, 0, 0);
                  }

                  var116 = var20 + 1;
                  var20 = var116;
               }
            } else {
               Image[][] var59 = this.a1013;
               var3 = var59[29];
               var203 = 8;
               Image var144 = (Image)((Object[])var3)[var203];
               var112 = var4[11] * 4;
               var237 = var9 + var112;
               var112 = var4[12] * 4;
               int var262 = var10 + var112;
               var112 = var4[13];
               int var273 = var112 - 4;
               this.b(var144, var1, var237, var262, var273);
               break;
            }
         case 2:
            var5 = var4[5];
            Object var136 = null;
            var8 = var4[0];
            var7 = var4[1];
            int var236 = var4[13];
            this.g(var5, var8, var7, var236);
            break;
         case 3:
         case 5:
            var8 = var4[0];
            var7 = var4[1];
            int var235 = var4[11];
            int var258 = var4[12];
            int var269 = var4[3];
            int var284 = var4[13];
            int var293 = var4[10];
            byte var110 = 2;
            int var304 = var4[var110];
            this.a(var8, var7, var235, var258, var269, var284, var293, var304);
            break;
         case 4:
            var5 = var4[13];
            byte var195 = 3;
            if (var5 < var195) {
               Image[][] var42 = this.a1013;
               var3 = var42[29];
               var195 = 4;
               Image var135 = (Image)((Object[])var3)[var195];
               Image[][] var43 = this.a1013;
               var3 = var43[29];
               byte var162 = 3;
               Image var217 = (Image)((Object[])var3)[var162];
               byte[][] var44 = this.D1135;
               int var231 = var4[13];
               byte var257 = var44[var231][2];
               var44 = this.D1135;
               var231 = var4[13];
               byte var268 = var44[var231][3];
               var44 = this.D1135;
               var231 = var4[13];
               var3 = var44[var231];
               Object var277 = null;
               byte var283 = (byte)((Object[])var3)[0];
               var44 = this.D1135;
               var231 = var4[13];
               byte var292 = var44[var231][1];
               this.a(var135, var217, var1, var257, var268, var283, var292);
            }
            break;
         case 6:
            var3 = null;
            var5 = var4[0];
            var8 = var4[1];
            var7 = var4[5];
            int var230 = var4[13];
            this.f(var5, var8, var7, var230);
            break;
         case 7:
            var8 = var4[0];
            var7 = var4[1];
            int var229 = var4[11];
            int var256 = var4[12];
            int var267 = var4[8];
            int var282 = var4[13];
            int var291 = var4[3];
            byte var107 = 10;
            int var303 = var4[var107];
            this.b(var8, var7, var229, var256, var267, var282, var291, var303);
            break;
         case 8:
            var5 = var4[10];
            if (var5 == 0) {
               Image[][] var39 = this.a1013;
               var3 = var39[29];
               byte var192 = 32;
               Image var134 = (Image)((Object[])var3)[var192];
               Image[][] var40 = this.a1013;
               var3 = var40[29];
               byte var159 = 33;
               Image var216 = (Image)((Object[])var3)[var159];
               Image[][] var41 = this.a1013;
               var3 = var41[29];
               byte var228 = 34;
               Image var276 = (Image)((Object[])var3)[var228];
               int var255 = var4[0];
               int var266 = var4[1];
               int var281 = var4[5];
               byte var106 = 13;
               int var290 = var4[var106];
               this.a(var134, var216, var276, var255, var266, var281, var290);
            }
            break;
         case 9:
            var5 = var4[10];
            if (var5 == 0) {
               Image[][] var36 = this.a1013;
               var3 = var36[29];
               byte var189 = 36;
               Image var133 = (Image)((Object[])var3)[var189];
               Image[][] var37 = this.a1013;
               var3 = var37[29];
               byte var157 = 37;
               Image var215 = (Image)((Object[])var3)[var157];
               Image[][] var38 = this.a1013;
               var3 = var38[29];
               byte var226 = 38;
               Image var275 = (Image)((Object[])var3)[var226];
               int var253 = var4[0];
               int var264 = var4[1];
               int var280 = var4[5];
               byte var102 = 13;
               int var289 = var4[var102];
               this.a(var133, var215, var275, var253, var264, var280, var289);
            } else {
               var5 = var4[16];
               int var190 = 1;
               if (var5 == var190) {
                  var190 = var4[0];
                  var7 = var4[1];
                  int var227 = var4[5];
                  int var254 = var4[2];
                  byte var104 = 3;
                  int var265 = var4[var104];
                  this.h(var190, var7, var227, var254, var265);
               }
            }
            break;
         case 10:
            var5 = var4[10];
            int var179 = 2;
            if (var5 == var179) {
               int var94 = 0;
               var3 = null;
               var9 = 0;

               while (true) {
                  byte[][] var25 = this.E1136;
                  var94 = var25.length;
                  if (var9 >= var94) {
                     var94 = 0;
                     var3 = null;

                     while (true) {
                        var25 = this.G1138;
                        var179 = var25.length;
                        if (var94 >= var179) {
                           return;
                        }

                        var25 = this.F1137;
                        var7 = var4[5];
                        byte[] var132 = var25[var7];
                        int var186 = var132[0];
                        var7 = var4[0];
                        var186 += var7;
                        var25 = this.G1138;
                        int var153 = var25[var94][0];
                        var186 += var153;
                        var25 = this.F1137;
                        int var222 = var4[5];
                        byte[] var214 = var25[var222];
                        var153 = var214[1];
                        var222 = var4[1];
                        var153 += var222;
                        var25 = this.G1138;
                        byte[] var15 = var25[var94];
                        byte var252 = 1;
                        int var224 = var15[var252];
                        var153 += var224;
                        var224 = var4[13];
                        this.p(var186, var153, var224);
                        var94++;
                     }
                  }

                  var25 = this.F1137;
                  var179 = var4[5];
                  int var96 = var25[var179][0];
                  var179 = var4[0];
                  var96 += var179;
                  var25 = this.E1136;
                  int var182 = var25[var9][0];
                  var96 += var182;
                  var25 = this.F1137;
                  var7 = var4[5];
                  var182 = var25[var7][1];
                  var7 = var4[1];
                  var182 += var7;
                  var25 = this.E1136;
                  byte[] var11 = var25[var9];
                  int var149 = var11[1];
                  int var12 = var182 + var149;
                  Image[][] var30 = this.a1013;
                  Image var6 = var30[29][47];
                  int var21 = this.bP;
                  var149 = var96 - var21;
                  var21 = this.bQ;
                  var12 = var12 - var21 + 13;
                  int var13 = var4[13] * 14;
                  boolean var14 = false;
                  byte var16 = 14;
                  byte var17 = 19;
                  boolean var22 = false;
                  this.a(var6, var149, var12, var13, 0, var16, var17, 0, 0);
                  var96 = var9 + 1;
                  var9 = var96;
               }
            }
      }
   }

   private void z() {
      byte var1 = 5;
      byte var2 = 3;
      byte var3 = 1;
      byte var4 = 4;

      for (int var5 = this.a1038 - var3; var5 >= 0; var5 += -1) {
         int[] var6 = this.a1039[var5];
         int var7 = var6[2];
         switch (var7) {
            case 1:
               var7 = var6[var2];
               if (var7 > 0) {
                  var7 = var6[0];
                  int var73 = var6[var4];
                  int var83 = var6[0];
                  var73 -= var83;
                  var83 = var6[var2];
                  var73 /= var83;
                  var7 += var73;
                  var6[0] = var7;
                  var7 = var6[var3];
                  var73 = var6[var1];
                  var83 = var6[var3];
                  var73 -= var83;
                  var83 = var6[var2];
                  var73 /= var83;
                  var7 += var73;
                  var6[var3] = var7;
                  var7 = var6[var2] - var3;
                  var6[var2] = var7;
               }
               break;
            case 2:
               var7 = var6[var4];
               if (var7 > var3) {
                  var7 = var6[var4] - var3;
                  var6[var4] = var7;
               }
               break;
            case 3:
               var7 = var6[var2];
               if (var7 > 0) {
                  var7 = var6[var4];
                  int var64 = var6[0];
                  var7 -= var64;
                  var64 = var6[var2];
                  var7 /= var64;
                  var64 = var6[var1];
                  int var9 = var6[var3];
                  var64 -= var9;
                  var9 = var6[var2];
                  var64 /= var9;
                  var9 = var6[0] + var7;
                  var6[0] = var9;
                  var9 = var6[var3] + var64;
                  var6[var3] = var9;
                  var9 = var6[var2] - var3;
                  var6[var2] = var9;
                  if (var9 == 0) {
                     byte var34;
                     if (var7 > 0) {
                        var34 = 8;
                     } else if (var7 < 0) {
                        var34 = -8;
                     } else {
                        var34 = 0;
                     }

                     var6[var4] = var34;
                     if (var64 > 0) {
                        var34 = 8;
                     } else if (var64 < 0) {
                        var34 = -8;
                     } else {
                        var34 = 0;
                     }

                     var6[var1] = var34;
                  }
               } else {
                  var7 = var6[var4];
                  if (var7 == 0) {
                     var7 = var6[var2];
                     switch (var7) {
                        case -3:
                        case 0:
                           var7 = var6[0];
                           int var71 = var6[var4];
                           var7 += var71;
                           var6[0] = var7;
                           var7 = var6[var3];
                           var71 = var6[var1];
                           var7 += var71;
                           var6[var3] = var7;
                           break;
                        case -2:
                           var7 = var6[var4] >> 1;
                           var6[var4] = var7;
                           var7 = var6[var1] >> 1;
                           var6[var1] = var7;
                        case -1:
                           var7 = var6[0];
                           int var69 = var6[var4];
                           var7 -= var69;
                           var6[0] = var7;
                           var7 = var6[var3];
                           var69 = var6[var1];
                           var7 -= var69;
                           var6[var3] = var7;
                     }

                     var7 = var6[var2] - var3;
                     var6[var2] = var7;
                  }
               }
               break;
            case 4:
               var7 = var6[var2];
               if (var7 > 0) {
                  var7 = var6[var1];
                  switch (var7) {
                     case 0:
                        var7 = var6[0];
                        int var62 = var6[var4];
                        var7 -= var62;
                        var6[0] = var7;
                        var7 = var6[var3];
                        var62 = var6[var4];
                        var7 += var62;
                        var6[var3] = var7;
                        break;
                     case 1:
                        var7 = var6[0];
                        int var60 = var6[var4];
                        var7 -= var60;
                        var6[0] = var7;
                        var7 = var6[var3];
                        var60 = var6[var4];
                        var7 -= var60;
                        var6[var3] = var7;
                        break;
                     case 2:
                        var7 = var6[0];
                        int var58 = var6[var4];
                        var7 += var58;
                        var6[0] = var7;
                        var7 = var6[var3];
                        var58 = var6[var4];
                        var7 -= var58;
                        var6[var3] = var7;
                        break;
                     case 3:
                        var7 = var6[0];
                        int var8 = var6[var4];
                        var7 += var8;
                        var6[0] = var7;
                        var7 = var6[var3];
                        var8 = var6[var4];
                        var7 += var8;
                        var6[var3] = var7;
                  }

                  var7 = var6[var1] + 1;
                  var6[var1] = var7;
                  if (var7 >= var4) {
                     var6[var1] = 0;
                     var7 = var6[var2] - var3;
                     var6[var2] = var7;
                  }
               }
         }
      }
   }

   private void z(int var1) {
      byte var2 = 10;
      byte var3 = 13;
      byte var4 = 4;
      byte var5 = 1;
      int[] var6 = this.b1066[var1];
      int var7 = var6[12];
      if (var7 > 0) {
         int var11 = 19;
         int var8 = var6[var11] + 1;
         var6[var11] = var8;
         var11 = (byte)2;
         if (var8 > var11) {
            var11 = (byte)19;
            var6[var11] = 0;
         }

         var11 = var6[8];
         int var78 = 7;
         if (var11 != var78) {
            byte var15 = 8;
            var78 = (byte)7;
            var6[var15] = var78;
         }

         byte var16 = 12;
         var78 = var6[var16] - var5;
         var6[var16] = var78;
      }

      var7 = var6[15];
      if (var7 > 0) {
         int var18 = 22;
         int var81 = var6[var18] + 1;
         var6[var18] = var81;
         var18 = (byte)2;
         if (var81 > var18) {
            var18 = (byte)22;
            var6[var18] = 0;
         }

         var18 = var6[var4];
         if (var18 > var5) {
            var18 = var6[0] & 7;
            if (var18 == 0) {
               var18 = var6[var5] & 7;
               if (var18 == 0) {
                  var18 = this.aZ >> 1;
                  var6[var4] = var18;
               }
            }
         }

         byte var25 = 15;
         var81 = var6[var25] - var5;
         var6[var25] = var81;
      } else {
         var7 = var6[15];
         if (var7 == 0) {
            var7 = var6[var3];
            if (var7 == 0) {
               var7 = var6[0] & 7;
               if (var7 == 0) {
                  var7 = var6[var5] & 7;
                  if (var7 == 0) {
                     var7 = this.aZ;
                     var6[var4] = var7;
                  }
               }
            }
         }
      }

      var7 = var6[14];
      if (var7 > 0) {
         int var32 = 21;
         int var83 = var6[var32] + 1;
         var6[var32] = var83;
         var32 = (byte)2;
         if (var83 > var32) {
            var32 = (byte)21;
            var6[var32] = 0;
         }

         var32 = var6[14] & 7;
         if (var32 == 0) {
            int var36 = 2;
            var83 = var6[var36];
            int var9 = var6[23];
            var83 -= var9;
            var6[var36] = var83;
            var83 = var6[23];
            var6[16] = var83;
            var36 = var6[var2];
            byte var87 = -1;
            if (var36 == var87) {
               var6[var2] = var4;
            }
         }

         byte var38 = 14;
         var83 = var6[var38] - var5;
         var6[var38] = var83;
      } else {
         var7 = var6[14];
         if (var7 == 0) {
            byte var40 = 23;
            var6[var40] = 0;
         }
      }

      var7 = var6[11];
      if (var7 > 0) {
         var7 = var6[11] & 7;
         if (var7 == 0) {
            int var43 = 8;
            int var89 = this.X;
            if (var89 == 0) {
               boolean[] var10 = this.f1106;
               byte var108 = 3;
               boolean var90 = var10[var108];
               if (var90) {
                  var43 = 16;
               }
            }

            byte var91 = 2;
            int var109 = var6[var91] - var43;
            var6[var91] = var109;
            var6[16] = var43;
            var43 = var6[var2];
            var91 = -1;
            if (var43 == var91) {
               var6[var2] = var4;
            }
         }

         byte var45 = 18;
         int var93 = var6[var45] + 1;
         var6[var45] = var93;
         var45 = 5;
         if (var93 > var45) {
            var45 = 18;
            var6[var45] = 0;
         }

         var45 = 11;
         var93 = var6[var45] - var5;
         var6[var45] = var93;
      }

      var7 = var6[var3];
      if (var7 > 0) {
         var7 = var6[var3];
         int var95 = 44;
         if (var7 >= var95) {
            var7 = var6[20];
            var95 = (byte)3;
            if (var7 < var95) {
               byte var52 = 20;
               var95 = var6[var52] + 1;
               var6[var52] = var95;
            }
         } else {
            var7 = var6[var3];
            if (var7 <= var4) {
               var7 = var6[var3];
               if (var7 == var4) {
                  int var55 = 2;
                  var95 = var6[var55] - var2;
                  var6[var55] = var95;
                  var6[16] = var2;
                  var55 = var6[var2];
                  byte var99 = -1;
                  if (var55 == var99) {
                     var6[var2] = var4;
                  }
               }

               var7 = var6[20];
               if (var7 > 0) {
                  byte var58 = 20;
                  var95 = var6[var58] - var5;
                  var6[var58] = var95;
               }
            }
         }

         var7 = var6[8];
         byte var101 = 7;
         if (var7 != var101) {
            byte var60 = 8;
            var101 = 7;
            var6[var60] = var101;
         }

         var7 = var6[var3] - var5;
         var6[var3] = var7;
      }

      var7 = var6[var3];
      if (var7 > 0) {
         var7 = var6[var3];
         int var103 = 45;
         if (var7 >= var103) {
            var7 = var6[20];
            var103 = (byte)2;
            if (var7 < var103) {
               byte var65 = 20;
               var103 = var6[var65] + 1;
               var6[var65] = var103;
            }
         } else {
            var7 = var6[var3];
            int var106 = 3;
            if (var7 <= var106) {
               var7 = var6[20];
               if (var7 > 0) {
                  byte var68 = 20;
                  var106 = var6[var68] - var5;
                  var6[var68] = var106;
               }
            }
         }

         var7 = var6[var4];
         if (var7 > var5) {
            var7 = var6[0] & 7;
            if (var7 == 0) {
               var7 = var6[var5] & 7;
               if (var7 == 0) {
                  var6[var4] = var5;
               }
            }
         }

         var7 = var6[var3] - var5;
         var6[var3] = var7;
      } else {
         var7 = var6[var3];
         if (var7 == 0) {
            var7 = var6[15];
            if (var7 == 0) {
               var7 = var6[0] & 7;
               if (var7 == 0) {
                  var7 = var6[var5] & 7;
                  if (var7 == 0) {
                     var7 = this.aZ;
                     var6[var4] = var7;
                  }
               }
            }
         }
      }
   }

   public final void hideNotify() {
      int var1 = this.cb;
      short var2 = 1500;
      if (var1 == var2) {
         boolean var3 = true;
         this.C1175 = var3;
      }

      var1 = this.l;
      byte var14 = 46;
      if (var1 != var14) {
         var1 = this.l;
         var14 = 48;
         if (var1 != var14) {
            var1 = this.l;
            var14 = 47;
            if (var1 != var14) {
               var1 = this.l;
               var14 = 2;
               if (var1 != var14) {
                  var1 = this.l;
                  var14 = 12;
                  if (var1 != var14) {
                     var1 = this.l;
                     var14 = 13;
                     if (var1 != var14) {
                        var1 = this.l;
                        var14 = 22;
                        if (var1 != var14) {
                           var1 = this.l;
                           var14 = 23;
                           if (var1 != var14) {
                              return;
                           }
                        }
                     }
                  }
               }

               this.a(3);
               int var12 = this.l1031;
               if (var12) {
                  var12 = this.aq;
                  this.h(var12);
               }

               this.r = 0;
               this.at = 0;
            }
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public final void keyPressed(int var1) {
      int var10000;
      try {
         var10000 = this.at;
      } catch (Exception var14) {
         var14.printStackTrace();
         return;
      }

      int var2 = var10000;
      if (var2 == 0) {
         a var24 = this;

         try {
            var24.g1046 = var1;
         } catch (Exception var13) {
            var13.printStackTrace();
            return;
         }

         a var25 = this;

         try {
            var25.h1047 = var1;
         } catch (Exception var12) {
            var12.printStackTrace();
            return;
         }

         int var15 = 0;
         Object var3 = null;
         a var26 = this;

         try {
            var26.i1048 = 0;
         } catch (Exception var11) {
            var11.printStackTrace();
            return;
         }

         try {
            var10000 = this.l;
         } catch (Exception var10) {
            var10.printStackTrace();
            return;
         }

         label85: {
            var15 = var10000;
            byte var4 = 46;
            if (var15 == var4) {
               try {
                  var10000 = this.h1047;
               } catch (Exception var9) {
                  var9.printStackTrace();
                  return;
               }

               var15 = var10000;
               var4 = -5;
               if (var15 != var4) {
                  try {
                     var10000 = this.h1047;
                  } catch (Exception var8) {
                     var8.printStackTrace();
                     return;
                  }

                  var15 = var10000;
                  var4 = -7;
                  if (var15 != var4) {
                     break label85;
                  }
               }
            }

            byte var19 = -1;
            a var30 = this;

            try {
               var30.o = var19;
            } catch (Exception var7) {
               var7.printStackTrace();
               return;
            }
         }

         boolean var20 = false;
         var3 = null;
         a var31 = this;

         try {
            var31.u1096 = false;
         } catch (Exception var6) {
            var6.printStackTrace();
            return;
         }

         try {
            this.ao();
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }
   }

   public final void keyReleased(int var1) {
      this.i1048 = -1;
      this.g1046 = 0;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public final void paint(Graphics var1) {
      a var10000 = this;

      try {
         var10000.a1002 = var1;
      } catch (Exception var11) {
         var11.printStackTrace();
         return;
      }

      try {
         var14 = this.a1002;
      } catch (Exception var10) {
         var10.printStackTrace();
         return;
      }

      Graphics var2 = var14;

      try {
         var15 = DirectUtils.getDirectGraphics(var2);
      } catch (Exception var9) {
         var9.printStackTrace();
         return;
      }

      DirectGraphics var12 = var15;
      var10000 = this;

      try {
         var10000.a1005 = var12;
      } catch (Exception var8) {
         var8.printStackTrace();
         return;
      }

      try {
         var17 = this.a1002;
      } catch (Exception var7) {
         var7.printStackTrace();
         return;
      }

      var2 = var17;

      try {
         var18 = this.a;
      } catch (Exception var6) {
         var6.printStackTrace();
         return;
      }

      Font var3 = var18;
      Graphics var19 = var2;

      try {
         var19.setFont(var3);
      } catch (Exception var5) {
         var5.printStackTrace();
         return;
      }

      try {
         this.A();
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   @Override
   public final void run() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:359)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield a.B1171 Z
      // 04: istore 1
      // 05: iload 1
      // 06: ifeq 22
      // 09: aload 0
      // 0a: invokespecial a.c ()I
      // 0d: istore 1
      // 0e: aload 0
      // 0f: getfield a.a1172 Ljava/lang/Object;
      // 12: astore 2
      // 13: aload 2
      // 14: monitorenter
      // 15: aload 0
      // 16: iload 1
      // 17: putfield a.bV I
      // 1a: aload 2
      // 1b: monitorexit
      // 1c: return
      // 1d: astore 3
      // 1e: aload 2
      // 1f: monitorexit
      // 20: aload 3
      // 21: athrow
      // 22: bipush 1
      // 23: istore 1
      // 24: aload 0
      // 25: iload 1
      // 26: putfield a.B1171 Z
      // 29: new java/lang/Object
      // 2c: astore 3
      // 2d: aload 3
      // 2e: invokespecial java/lang/Object.<init> ()V
      // 31: aload 0
      // 32: aload 3
      // 33: putfield a.a1172 Ljava/lang/Object;
      // 36: aload 0
      // 37: getfield a.b1018 Z
      // 3a: istore 1
      // 3b: iload 1
      // 3c: ifeq d3
      // 3f: invokestatic java/lang/System.currentTimeMillis ()J
      // 42: lstore 4
      // 44: aload 0
      // 45: invokespecial a.G ()V
      // 48: bipush 0
      // 49: istore 6
      // 4b: aload 0
      // 4c: bipush 0
      // 4d: putfield a.h1047 I
      // 50: aload 0
      // 51: invokevirtual javax/microedition/lcdui/Canvas.repaint ()V
      // 54: aload 0
      // 55: invokevirtual javax/microedition/lcdui/Canvas.serviceRepaints ()V
      // 58: bipush 10
      // 5a: i2l
      // 5b: lstore 7
      // 5d: lload 7
      // 5f: invokestatic java/lang/Thread.sleep (J)V
      // 62: invokestatic java/lang/Thread.yield ()V
      // 65: invokestatic java/lang/System.currentTimeMillis ()J
      // 68: lload 4
      // 6a: lsub
      // 6b: lstore 7
      // 6d: bipush 100
      // 6f: i2l
      // 70: lstore 9
      // 72: lload 7
      // 74: lload 9
      // 76: lcmp
      // 77: istore 6
      // 79: iload 6
      // 7b: ifge 8c
      // 7e: invokestatic java/lang/Thread.yield ()V
      // 81: goto 65
      // 84: astore 3
      // 85: aload 3
      // 86: invokevirtual java/lang/Throwable.printStackTrace ()V
      // 89: goto 36
      // 8c: aload 0
      // 8d: getfield a.c1020 Z
      // 90: istore 6
      // 92: iload 6
      // 94: ifeq ba
      // 97: aload 0
      // 98: getfield a.s I
      // 9b: istore 6
      // 9d: iload 6
      // 9f: i2l
      // a0: lstore 7
      // a2: invokestatic java/lang/System.currentTimeMillis ()J
      // a5: lstore 9
      // a7: lload 9
      // a9: lload 4
      // ab: lsub
      // ac: lload 7
      // ae: ladd
      // af: lstore 4
      // b1: lload 4
      // b3: l2i
      // b4: istore 1
      // b5: aload 0
      // b6: iload 1
      // b7: putfield a.s I
      // ba: aload 0
      // bb: getfield a.a1019 J
      // be: lstore 4
      // c0: lconst_1
      // c1: lstore 7
      // c3: lload 4
      // c5: lload 7
      // c7: ladd
      // c8: lstore 4
      // ca: aload 0
      // cb: lload 4
      // cd: putfield a.a1019 J
      // d0: goto 36
      // d3: invokestatic CMidlet.a ()V
      // d6: goto 1c
      // try (14 -> 16): 19 null
      // try (16 -> 18): 19 null
      // try (20 -> 22): 19 null
      // try (41 -> 42): 75 java/lang/Exception
      // try (43 -> 45): 75 java/lang/Exception
      // try (48 -> 50): 75 java/lang/Exception
      // try (50 -> 52): 75 java/lang/Exception
      // try (52 -> 54): 75 java/lang/Exception
      // try (57 -> 59): 75 java/lang/Exception
      // try (59 -> 60): 75 java/lang/Exception
      // try (60 -> 61): 75 java/lang/Exception
      // try (73 -> 74): 75 java/lang/Exception
      // try (79 -> 81): 75 java/lang/Exception
      // try (84 -> 86): 75 java/lang/Exception
      // try (90 -> 91): 75 java/lang/Exception
      // try (102 -> 104): 75 java/lang/Exception
      // try (104 -> 106): 75 java/lang/Exception
      // try (114 -> 116): 75 java/lang/Exception
   }

   public final void showNotify() {
      int var1 = this.cb;
      short var2 = 1000;
      if (var1 == var2) {
         byte var3 = 2;
         this.b1174 = var3;
      } else {
         byte var4 = this.C1175;
         if (var4) {
            var4 = 1;
            this.b1174 = var4;
         } else {
            var4 = 3;
            this.b1174 = var4;
         }
      }

      this.cb = 0;
   }
}
