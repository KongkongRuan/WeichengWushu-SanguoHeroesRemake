import javax.microedition.media.Controllable;
import javax.microedition.lcdui.Canvas;
import java.io.ByteArrayInputStream;
import com.netmite.andme.MIDletThread;
import com.nokia.mid.ui.DirectUtils;
import java.io.IOException;
import java.io.DataInputStream;
import javax.microedition.lcdui.Display;
import java.lang.reflect.Array;
import javax.microedition.io.HttpConnection;
import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.Date;
import javax.microedition.media.Player;
import java.io.InputStream;
import javax.microedition.media.control.VolumeControl;
import java.util.Random;
import com.nokia.mid.ui.DirectGraphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Font;
import com.nokia.mid.ui.FullCanvas;

// 
// Decompiled by Procyon v0.6.0
// 

public final class a extends FullCanvas implements Runnable
{
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
        final int n = 8;
        final int[] array;
        final int[] a1002 = array = new int[n];
        array[0] = 0;
        array[1] = 8192;
        array[2] = 16384;
        array[3] = 24576;
        array[4] = 8462;
        array[5] = 270;
        array[6] = 90;
        array[7] = 8282;
        a1001 = a1002;
        final String[] c1045 = { "/0.mid", "/1.mid", "/2.mid", "/3.mid", "/4.mid", "/5.mid", "/6.mid", "/7.mid", null, null, null, null, null, null, null };
        c1045[n] = "/8.mid";
        c1045[9] = "/9.mid";
        c1045[10] = "/10.mid";
        c1045[11] = "/11.mid";
        c1045[12] = "/12.mid";
        c1045[13] = "/13.mid";
        c1045[14] = "/14.mid";
        a.c1045 = c1045;
    }
    
    public a() {
        final int n = 4;
        final byte b = 1;
        final int n2 = 3;
        final byte al = 2;
        this.a = Font.getFont(32, 0, 8);
        this.j = this.a.getHeight();
        this.k = this.a.charWidth('\u53e3');
        this.l = 0;
        this.b = new int[10];
        this.m = 0;
        this.a1007 = 0;
        this.c = 0;
        this.n = this.j + 2;
        this.a1009 = "";
        this.c1010 = new int[200];
        final int[] array;
        final int[] d1011 = array = new int[5];
        array[0] = 6305566;
        array[1] = 32260;
        array[2] = 255;
        array[3] = 13516032;
        array[4] = 9240762;
        this.d1011 = d1011;
        this.e = new int[21];
        this.a1013 = new Image[39][];
        final int[] array2;
        final int[] f = array2 = new int[39];
        array2[0] = 12;
        array2[1] = 8;
        array2[2] = 2;
        array2[3] = 30;
        array2[4] = 26;
        array2[5] = 1;
        array2[7] = (array2[6] = 1);
        array2[9] = (array2[8] = 1);
        array2[11] = (array2[10] = 1);
        array2[13] = (array2[12] = 2);
        array2[15] = (array2[14] = 2);
        array2[16] = 3;
        array2[17] = 2;
        array2[18] = 6;
        array2[19] = 1;
        array2[21] = (array2[20] = 2);
        array2[22] = 1;
        array2[23] = 3;
        array2[25] = (array2[24] = 1);
        array2[26] = 3;
        array2[27] = 2;
        array2[28] = 1;
        array2[29] = 48;
        array2[30] = 1;
        array2[31] = 10;
        array2[32] = 48;
        array2[33] = 6;
        array2[35] = (array2[34] = 1);
        array2[37] = (array2[36] = 1);
        array2[38] = 7;
        this.f = f;
        final String[] a1014 = new String[39];
        a1014[0] = "/mu";
        a1014[b] = "/sflogo";
        a1014[al] = "/ld";
        a1014[n2] = "/ui";
        a1014[n] = "/back";
        a1014[5] = "/map0";
        a1014[6] = "/map1";
        a1014[7] = "/map2";
        a1014[8] = "/map3";
        a1014[9] = "/map4";
        a1014[10] = "/map5";
        a1014[11] = "/map6";
        a1014[12] = "/e0";
        a1014[13] = "/e1";
        a1014[14] = "/e2";
        a1014[15] = "/e3";
        a1014[16] = "/e4";
        a1014[17] = "/e5";
        a1014[18] = "/t0";
        a1014[19] = "/t1";
        a1014[20] = "/t2";
        a1014[21] = "/t3";
        a1014[22] = "/t4";
        a1014[23] = "/t5";
        a1014[24] = "/t6";
        a1014[25] = "/t7";
        a1014[26] = "/t8";
        a1014[27] = "/t9";
        a1014[28] = "/t10";
        a1014[29] = "/bu";
        a1014[30] = "/s";
        a1014[31] = "/h";
        a1014[32] = "/sp";
        a1014[33] = "/end";
        a1014[34] = "/sp0";
        a1014[35] = "/sp1";
        a1014[36] = "/sp2";
        a1014[37] = "/sp3";
        a1014[38] = "/eff";
        this.a1014 = a1014;
        final String[] b2 = new String[181];
        b2[0] = "\u6e38\u620f\u63cf\u8ff0:\n\u60f3\u8bd5\u8bd5\u770b\u4e09\u56fd\u5b88\u57ce\u662f\u591a\u4e48\u6fc0\u70c8\uff1f\u767e\u540d\u653b\u57ce\u540d\u5c06\u5bf9\u5b88\u57ce\u5fe0\u81e3\uff01\u957f\u5742\uff0c\u8d64\u58c1\uff0c\u5937\u9675\u7b49\u5386\u53f2\u6218\u5f79\u7b49\u60a8\u53c2\u52a0\uff0c\u6b65\u5175\uff0c\u9a91\u5175\uff0c\u91cd\u88c5\u5175\u7b49\u987d\u654c\u5411\u60a8\u51b2\u6765\uff0c\u64c2\u6728\uff0c\u6295\u77f3\uff0c\u65ad\u9f99\u95f8\u7b49\u6b66\u5668\u4f9b\u60a8\u6311\u9009\uff0c\u6d2a\u6c34\uff0c\u653e\u706b\uff0c\u5947\u95e8\u9041\u7532\u7b49\u5999\u8ba1\u4fe1\u624b\u62c8\u6765\uff01\u6211\u65b9\u57ce\u6c60\u906d\u5230\u5730\u65b9\u57ce\u6c60\u4e2d\u8702\u62e5\u800c\u51fa\u654c\u5175\u7684\u4fb5\u6270\uff0c\u4e3a\u4e86\u62b5\u5fa1\u4e0d\u65ad\u7684\u5165\u4fb5\uff0c\u6211\u65b9\u5728\u654c\u5175\u5165\u4fb5\u6211\u65b9\u57ce\u6c60\u7684\u5e76\u7ecf\u4e4b\u8def\u4e0a\u4fee\u5efa\u9632\u5fa1\u706b\u529b\u4e88\u4ee5\u963b\u51fb\uff0c\u6d88\u706d\u4e0d\u65ad\u8d76\u6765\u610f\u56fe\u653b\u9677\u6211\u65b9\u57ce\u6c60\u7684\u654c\u5175\u3002\u6e38\u620f\u4e2d\u4f1a\u51fa\u73b0\u5927\u91cf\u4e09\u56fd\u65f6\u5019\u7684\u5de5\u7a0b\u9632\u5fa1\u6b66\u5668\u4f9b\u73a9\u5bb6\u5efa\u9020\uff0c\u8bf8\u5982\u65ad\u9f99\u95f8\u7b49\u3002\u5982\u4f55\u5145\u5206\u5229\u7528\u6709\u5229\u5730\u5f62\u5efa\u9020\u66f4\u591a\u7684\u9632\u5fa1\u6b66\u5668\u62b5\u5fa1\u6765\u72af\u7684\u654c\u5175\uff0c\u4e00\u573a\u6597\u5fd7\u6597\u52c7\u7684\u57ce\u6c60\u4fdd\u536b\u6218\u5c31\u6b64\u5c55\u5f00\u3002\n\u6e38\u620f\u89c4\u5219\uff1a\n\u654c\u5175\u6309\u56fa\u5b9a\u8def\u7ebf\u524d\u8fdb\uff0c\u73a9\u5bb6\u6cbf\u9014\u5236\u9020\u653b\u51fb\u969c\u788d\u8bbe\u65bd\u963b\u6b62\u5176\u5230\u7ec8\u70b9\uff0d\uff0d\u6211\u65b9\u9547\u5b88\u7684\u57ce\u6c60\uff0c\u4e00\u5b9a\u6570\u91cf\u7684\u654c\u5175\u6d8c\u5165\u6211\u65b9\u57ce\u6c60\uff0c\u73a9\u5bb6\u5931\u8d25\u3002\u654c\u5175\u5206\u6279\u4ece\u654c\u57ce\u51fa\u53d1\uff0c\u73a9\u5bb6\u6bcf\u6d88\u706d\u4e00\u4e2a\u654c\u5175\u83b7\u5f97\u4e00\u4e9b\u91d1\uff0c\u7528\u91d1\u53ef\u4ee5\u5728\u6211\u65b9\u57ce\u6c60\u4e2d\u8425\u5efa\u5404\u5f0f\u5404\u6837\u79d1\u6280\u5efa\u7b51\uff0c\u51ed\u501f\u79d1\u6280\u5efa\u7b51\u53ef\u4ee5\u5728\u654c\u5175\u6765\u72af\u7684\u6cbf\u9014\u4fee\u5efa\u5404\u5f0f\u5404\u6837\u7684\u5de5\u7a0b\u9632\u5fa1\u6b66\u5668\uff0c\u5bf9\u9632\u5fa1\u6b66\u5668\u7684\u5347\u7ea7\u53ef\u4ee5\u589e\u5f3a\u5b83\u4eec\u7684\u5a01\u529b\uff0c\u4ee5\u5e94\u5bf9\u8d8a\u6765\u8d8a\u591a\u654c\u5175\u7684\u5165\u4fb5\u3002\n\u6e38\u620f\u64cd\u4f5c\uff1a\n\u5de6\u529f\u80fd\u952e/\u5bfc\u822a\u952e\u4e2d\uff1a\u786e\u8ba4\u9009\u62e9/\u6e38\u620f\u4e2d\u5efa\u9020\u5355\u4f4d\n\u53f3\u529f\u80fd\u952e\uff1a\u8fd4\u56de/\u6e38\u620f\u4e2d\u8c03\u51fa\u83dc\u5355\n\u6570\u5b57\u952e5\uff1a\u6e38\u620f\u4e2d\u8c03\u51fa\u5355\u4f4d\u5efa\u9020\u83dc\u5355\n\u5bfc\u822a\u952e\u4e0a\u4e0b\u5de6\u53f3/\u6570\u5b57\u952e2\u30014\u30016\u30018\uff1a\u9009\u62e9\u83dc\u5355/\u6e38\u620f\u4e2d\u63a7\u5236\u5efa\u9020\u5355\u4f4d\u5730\u70b9\u3001\u65b9\u5411";
        b2[b] = "\u7248\u6743\u6240\u6709\uff1a\n\u4e0a\u6d77\u96ea\u9ca4\u9c7c\u8ba1\u7b97\u673a\u79d1\u6280\u6709\u9650\u516c\u53f8\n\u7f51\u5740\uff1a\nwww.kgame.com.cn\n\u624b\u673a\u4e0a\u7f51\uff1a\nwap.kgame.com.cn\n\u7248\u672c\uff1aV1.0\n\u5236\u4f5c\u4eba\uff1a\u8bf8\u4e00\u6960\n\u7f8e\u672f\u8bbe\u8ba1\uff1a\u9ec4\u52bc\n\u7a0b\u5e8f\u8bbe\u8ba1\uff1a\u79e6\u7aeb\n\u7a0b\u5e8f\u534f\u52a9\uff1a\u7a0b\u96ea\u5e73\n\u6d4b\u8bd5\uff1a\u738b\u6bc5\uff0c\u9648\u601d\u6e90";
        b2[al] = "\u57fa\u7840\u8fdc\u7a0b\u653b\u51fb\u5355\u4f4d";
        b2[n2] = "\u53ef\u4f7f\u654c\u4eba\u4e2d\u6bd2\u3002";
        b2[n] = "\u5730\u5e95\u4f38\u51fa\u5229\u5203\uff0c\u6740\u4f24\u654c\u4eba";
        b2[5] = "\u70b9\u71c3\u654c\u4eba";
        b2[6] = "\u53ef\u4ee5\u4f7f\u654c\u4eba\u6682\u505c";
        b2[7] = "\u53ef\u4ee5\u4f7f\u654c\u4eba\u51b0\u51bb";
        b2[8] = "\u76f4\u7ebf\u6c89\u91cd\u6253\u51fb\u654c\u4eba\u7684\u6728\u6869";
        b2[9] = "\u8fdc\u7a0b\u6c89\u91cd\u6253\u51fb\u654c\u4eba\u7684\u77f3\u5934";
        b2[10] = "\u9020\u6210\u5f88\u5927\u4f24\u5bb3\uff0c\u4f1a\u5c06\u706b\u7184\u706d";
        b2[11] = "\u9020\u6210\u5f88\u5927\u4f24\u5bb3\uff0c\u9047\u706b\u4f1a\u70b9\u71c3";
        b2[12] = "\u963b\u65ad\u654c\u4eba\u524d\u8fdb\uff0c\u7528\u8fc7\u540e\u5931\u6548";
        b2[13] = "\u751f\u4ea7\u77f3\u7070\u74f6\u548c\u65ad\u9f99\u95f8\u7684\u88c5\u7f6e";
        b2[14] = "\u751f\u4ea7\u7a81\u523a\u548c\u64c2\u6728\u7684\u88c5\u7f6e";
        b2[15] = "\u751f\u4ea7\u70df\u706b\u548c\u6295\u77f3\u7684\u88c5\u7f6e";
        b2[16] = "\u751f\u4ea7\u9ebb\u75f9\u77e2\u548c\u6cb8\u6c34\u7684\u88c5\u7f6e";
        b2[17] = "\u751f\u4ea7\u5bd2\u51b0\u548c\u6eda\u6cb9\u7684\u88c5\u7f6e";
        b2[18] = "\u5347\u7ea7\u5854\uff0c\u5347\u5230\u9876\u53ef\u83b7\u5f97\u82f1\u96c4";
        b2[19] = "";
        b2[20] = "\u88c5\u586b\u77f3\u5757";
        b2[21] = "\u91ca\u653e\u65ad\u9f99\u95f8";
        b2[22] = "\u62c6\u9664\u6240\u9009\u5854\uff0c\u56de\u6536\u90e8\u5206\u8d44\u91d1";
        b2[23] = "\u53d6\u6d88\u9009\u62e9";
        b2[24] = "\u91d1\u624b\u6307";
        b2[25] = "\u6210\u90fd";
        b2[26] = "\u8bb8\u660c";
        b2[27] = "\u5efa\u4e1a";
        b2[28] = "\u5218\u5907";
        b2[29] = "\u5173\u7fbd";
        b2[30] = "\u9a6c\u8d85";
        b2[31] = "\u9ec4\u5fe0";
        b2[32] = "\u5f20\u98de";
        b2[33] = "\u8d75\u4e91";
        b2[34] = "\u9b4f\u5ef6";
        b2[35] = "\u59dc\u7ef4";
        b2[36] = "\u8bf8\u845b\u4eae";
        b2[37] = "\u5f90\u5eb6";
        b2[38] = "\u5e9e\u7edf";
        b2[39] = "\u66f9\u64cd";
        b2[40] = "\u5178\u97e6";
        b2[41] = "\u5f20\u8fbd";
        b2[42] = "\u590f\u4faf\u6e0a";
        b2[43] = "\u590f\u4faf\u619e";
        b2[44] = "\u8bb8\u891a";
        b2[45] = "\u53f8\u9a6c\u61ff";
        b2[46] = "\u8340\u6538";
        b2[47] = "\u8340\u5f67";
        b2[48] = "\u7a0b\u6631";
        b2[49] = "\u90ed\u5609";
        b2[50] = "\u5b59\u6743";
        b2[51] = "\u51cc\u7edf";
        b2[52] = "\u7518\u5b81";
        b2[53] = "\u9ec4\u76d6";
        b2[54] = "\u5468\u6cf0";
        b2[55] = "\u592a\u53f2\u6148";
        b2[56] = "\u5f20\u662d";
        b2[57] = "\u9646\u900a";
        b2[58] = "\u5415\u8499";
        b2[59] = "\u9c81\u8083";
        b2[60] = "\u5468\u745c";
        b2[61] = "\u5f20\u6881";
        b2[62] = "\u5f20\u5b9d";
        b2[63] = "\u5f20\u89d2";
        b2[64] = "\u534e\u96c4";
        b2[65] = "\u8c82\u8749";
        b2[66] = "\u5415\u5e03";
        b2[67] = "\u8463\u5353";
        b2[68] = "\u5f20\u988c";
        b2[69] = "\u66f9\u6d2a";
        b2[70] = "\u5f90\u6643";
        b2[71] = "\u4e8e\u7981";
        b2[72] = "\u4e50\u8fdb";
        b2[73] = "\u674e\u5178";
        b2[74] = "\u66f9\u4e15";
        b2[75] = "\u7a0b\u666e";
        b2[76] = "\u5218\u5907\u540c\u65f6\u62e5\u6709\u5367\u9f99\u4e0e\u51e4\u96cf\uff0c\u5c5e\u6027\u4f24\u5bb3\u5f88\u5389\u5bb3\u3002";
        b2[77] = "\u7531\u66f9\u64cd\u5e26\u9886\u7684\u80fd\u81e3\u731b\u5c06\uff0c\u64c5\u957f\u963b\u788d\u654c\u4eba\u884c\u8fdb\u3002";
        b2[78] = "\u5b59\u5bb6\u7387\u9886\u5434\u56fd\u7684\u4e16\u4ee3\u540d\u5c06\uff0c\u5f13\u7bad\u7684\u597d\u624b\u8f88\u51fa\u3002";
        b2[79] = "\u6b66\u7cfb";
        b2[80] = "\u6587\u7cfb";
        b2[81] = "\u4f18\u5148\u628a\u4e0d\u540c\u7684\u9632\u5fa1\u5854\u5347\u7ea7\u6210\u672c\u56fd\u5bf9\u5e94\u6b66\u5c06";
        b2[82] = "\u4f18\u5148\u628a\u4e0d\u540c\u7684\u9632\u5fa1\u5854\u5347\u7ea7\u6210\u672c\u56fd\u5bf9\u5e94\u6587\u81e3";
        b2[83] = "\u9ec4\u5dfe\u4e4b\u4e71";
        b2[84] = "\u5f20\u6c0f\u8d77\u4e49\u4e0d\u4ec5\u52a8\u6447\u4e86\u6c49\u671d\u7684\u7edf\u6cbb\uff0c\u66f4\u5f15\u5f97\u65e0\u6570\u82f1\u96c4\u8c6a\u6770\u4e71\u4e16\u9010\u9e7f\u3002";
        b2[85] = "\u864e\u7262\u5173";
        b2[86] = "\u8463\u5353\u65e0\u9053\uff0c\u5341\u516b\u8def\u8bf8\u4faf\u5c3d\u8d77\u800c\u653b\u4e4b\u3002\u4e09\u82f1\u6218\u5415\u5e03\uff0c\u6e29\u9152\u65a9\u534e\u96c4\u3002";
        b2[87] = "\u957f\u5742\u5761";
        b2[88] = "\u957f\u5742\u5761\u4e2d\u56f0\u9f99\u51fa,\u864e\u5c06\u6000\u4e2d\u5c0f\u9f99\u7720.\u81ea\u53e4\u51b2\u9635\u6276\u5371\u4e3b,\u662f\u6709\u5e38\u5c71\u8d75\u5b50\u9f99\u3002";
        b2[89] = "\u8d64\u58c1\u4e4b\u6218";
        b2[90] = "\u96c4\u59ff\u82f1\u53d1\uff0c\u7fbd\u6247\u7eb6\u5dfe\uff0c\u8c08\u7b11\u95f4\uff0c\u5f3a\u864f\u7070\u98de\u70df\u706d\u3002 \u516c\u747e\uff1f\u5b54\u660e\uff1f";
        b2[91] = "\u6218\u5408\u80a5";
        b2[92] = "\u201c\u82e5\u5b59\u6743\u81f3\u8005\uff0c\u5f20\u3001\u674e\u5c06\u519b\u51fa\u6218\uff0c\u4e50\u5c06\u519b\u5b88\uff0c\u62a4\u519b\u52ff\u5f97\u4e0e\u6218\u201d";
        b2[93] = "\u5937\u9675\u4e4b\u6218";
        b2[94] = "\u5937\u9675\u4e4b\u6218\uff0c\u53c8\u79f0\u5f5d\u9675\u4e4b\u6218\u3001\u7307\u4ead\u4e4b\u6218\u3002\u53cc\u65b9\u6307\u6325\u5b98\uff1a\u9646\u900a\uff0c\u5218\u5907\u3002";
        b2[95] = "\u653b\u514b\u6210\u90fd";
        b2[96] = "\u6c49\u671d\u51e0\u767e\u5e74\u7684\u57fa\u4e1a\u5230\u4e86\u5c3d\u5934\uff0c\u8c01\u80fd\u53d6\u5f97\u8fd9\u4efd\u8363\u8000\uff1f";
        b2[97] = "\u653b\u514b\u8bb8\u660c";
        b2[98] = "\u66f9\u64cd\u7684\u8d3c\u5b50\u91ce\u5fc3\u5373\u5c06\u8986\u706d\uff0c\u591a\u5e74\u7684\u52aa\u529b\u4eca\u5929\u7ec8\u4e8e\u6709\u6240\u56de\u62a5\uff01";
        b2[99] = "\u653b\u514b\u5efa\u4e1a";
        b2[100] = "\u5b59\u6c0f\u5bb6\u65cf\u7684\u660f\u5eb8\u7edf\u6cbb\u5373\u5c06\u7ec8\u7ed3\uff0c\u6253\u8fc7\u957f\u6c5f\u53bb\uff0c\u89e3\u6551\u5357\u65b9\u4eba\u6c11\uff01";
        b2[101] = "\u58f0\u97f3";
        b2[102] = "\u5f00";
        b2[103] = "\u5173";
        b2[104] = "\u662f\u5426\u5f00\u542f\u58f0\u97f3";
        b2[105] = "\u5f00\u542f";
        b2[106] = "\u53d6\u6d88";
        b2[107] = "\u7ee7\u7eed\u6e38\u620f";
        b2[108] = "\u91d1\u624b\u6307";
        b2[109] = "\u8bbe\u7f6e";
        b2[110] = "\u5e2e\u52a9";
        b2[111] = "\u5173\u4e8e";
        b2[112] = "\u9000\u51fa";
        b2[113] = "\u91d1\u4e0d\u8db3\uff0c\u6d88\u706d\u654c\u4eba\u53ef\u83b7\u5f97\u91d1\u94b1\uff0c\u4e5f";
        b2[114] = "\u9700\u8981\u81f3\u5c11\u4fee\u5efa\u4e00\u4e2a\u5854";
        b2[115] = "\u73b0\u5728\u8fd8\u4e0d\u80fd\u5efa\u9020\u8fd9\u4e2a\u5efa\u7b51,\u9700\u8981\u4fee\u5efa\u76f8\u5173\u7684\u57ce\u6c60\uff0c\u4e5f";
        b2[116] = "\u8be5\u57ce\u6c60\u5df2\u7ecf\u4fee\u5efa";
        b2[117] = "\u8be5\u5854\u5df2\u662f\u6700\u9ad8\u7ea7";
        b2[118] = "\u73b0\u5728\u8fd8\u4e0d\u80fd\u5347\u7ea7\u8fd9\u4e2a\u5efa\u7b51\uff0c\u9700\u8981\u5c06\u57ce\u6c60\u5168\u90e8\u5efa\u7b51\u5347\u7ea7\uff0c\u4e5f";
        b2[119] = "\u9700\u8981\u5347\u7ea7\u5f13\u5854\u81f3\u541b\u4e3b";
        b2[120] = "\u5df2\u7ecf\u8fbe\u5230\u5efa\u7b51\u4e0a\u9650";
        b2[121] = "\u60a8\u7684\u57ce\u5e02\u5373\u5c06\u88ab\u653b\u5360\uff01";
        b2[122] = "\u4f7f\u6240\u6709\u5854\u653b\u51fb\u589e\u52a0";
        b2[124] = (b2[123] = "\u65e0\u89c6\u654c\u4eba\u9632\u5fa1");
        b2[125] = "\u51fb\u4e2d\u654c\u4eba\u540c\u65f6\u51cf\u901f";
        b2[127] = (b2[126] = "\u653b\u51fb\u8303\u56f4\u589e\u52a0");
        b2[128] = "\u4e2d\u6bd2\u654c\u4eba\u540c\u65f6\u51cf\u901f";
        b2[129] = "\u65e0\u89c6\u654c\u4eba\u9632\u5fa1";
        b2[130] = "\u706b\u7130\u4f24\u5bb3\u52a0\u5f3a";
        b2[131] = "\u9ebb\u75f9\u65f6\u95f4\u5ef6\u957f";
        b2[132] = "\u51b0\u51bb\u65f6\u95f4\u5ef6\u957f";
        b2[133] = "\u4f7f\u6240\u6709\u5854\u653b\u51fb\u589e\u52a0";
        b2[134] = "\u77f3\u5757\u66f4\u52a0\u575a\u786c";
        b2[136] = (b2[135] = "\u52a0\u5f3a\u653b\u51fb\u4f24\u5bb3");
        b2[138] = (b2[137] = "\u653b\u51fb\u65f6\u95f4\u5ef6\u957f");
        b2[139] = "\u52a0\u5f3a\u653b\u51fb\u4f24\u5bb3";
        b2[141] = (b2[140] = "\u52a0\u5f3a\u653b\u51fb\u4f24\u5bb3");
        b2[142] = "\u8303\u56f4\u9ebb\u75f9";
        b2[143] = " \u8303\u56f4\u51b0\u51bb";
        b2[144] = "\u4f7f\u6240\u6709\u5854\u653b\u51fb\u589e\u52a0";
        b2[145] = "\u88c5\u586b\u77f3\u5934\u534a\u4ef7";
        b2[146] = "\u52a0\u5f3a\u653b\u51fb\u9891\u7387";
        b2[147] = "\u5468\u56f4\u5854\u653b\u51fb\u589e\u52a0";
        b2[149] = (b2[148] = "\u8303\u56f4\u5185\u654c\u4eba\u51cf\u901f");
        b2[150] = "\u4e2d\u6bd2\u65f6\u95f4\u5ef6\u957f";
        b2[151] = "\u52a0\u5f3a\u653b\u51fb\u9891\u7387";
        b2[152] = "\u706b\u7130\u4f24\u5bb3\u65f6\u95f4\u589e\u52a0";
        b2[153] = "\u9ebb\u75f9\u6982\u7387\u589e\u52a0";
        b2[154] = "\u51b0\u51bb\u6982\u7387\u589e\u52a0";
        b2[155] = "\u5927\u5bb6\u8ddf\u6211";
        b2[156] = "\u7ec3\u4e86\u8fd9\u4e48\u4e45\uff0c\u8fd9\u70b9\u6253\u51fb\u7b97\u5565\uff1f";
        b2[157] = "\u5feb\u70b9\u5feb\u70b9\u5feb\u70b9\uff01\u8ddf\u6211";
        b2[158] = "\u51b2\u7834\u654c\u57ce\u6709\u91cd\u8d4f\uff01";
        b2[159] = "\u6211\u4e43";
        b2[160] = "\uff0c\u6211\u7684\u536b\u961f\u9971\u9910\u800c\u6765\uff0c\u4e0d\u6b7b\u4e0d\u5f52\uff01";
        b2[161] = "\u5e08\u5085\u5728\u5929\u6709\u7075\uff0c";
        b2[162] = "\u591a\u5e74\u6765\u7684\u6c34\u6218\u4e0d\u767d\u7ec3\uff01";
        b2[163] = "\u88ab\u70e7\u4e86\u591a\u6b21\uff0c\u6211";
        b2[164] = "\u4eca\u5929\u4e5f\u7b97\u4e0d\u6015\u706b\u4e86\u54c8\u54c8\uff01";
        b2[165] = "\u6211";
        b2[166] = "\u559d\u4e86\u8fd9\u4e48\u591a\u9ebb\u75f9\u6563\uff0c\u8be5\u4e0d\u6015\u9ebb\u75f9\u4e86\u5427\uff01";
        b2[167] = "\u5144\u5f1f\u4eec\u90fd\u7ed9\u6211";
        b2[168] = "\u51b2\u554a\uff01\u51b2\u6162\u7684\u519b\u6cd5\u5904\u7f6e\uff01";
        b2[169] = "\u4ffa";
        b2[170] = "\u5403\u4e86\u8fd9\u4e48\u591a\u89e3\u836f\uff0c\u4e0d\u4f1a\u518d\u4e2d\u6bd2\u4e86\u5427\uff1f";
        b2[171] = "\u5efa\u9020\u5404\u79cd\u57ce\u9632\u6b66\u5668\u62b5\u6321\u654c\u57ce\u4e2d\u6d8c\u51fa\u7684\u519b\u961f";
        b2[172] = "\u5347\u7ea7\u81ea\u5df1\u7684\u57ce\u6c60\u53ef\u4ee5\u5efa\u9020\u66f4\u591a\u7c7b\u578b\u7684\u6b66\u5668";
        b2[173] = "\u8d85\u8fc710\u4e2a\u654c\u4eba\u51b2\u5165\u81ea\u5df1\u7684\u57ce\u6c60\u5219\u6e38\u620f\u5931\u8d25";
        b2[174] = "\u7a7a\u5730\u63095\u9020\u5854\uff0c#\u51fa\u654c\u4eba\uff0c\u5854\u6216\u57ce\u4e0a\u63095\u5347\u7ea7";
        b2[175] = "\u6d88\u706d\u5f53\u524d\u5168\u90e8\u654c\u4eba";
        b2[176] = "\u83b7\u5f97\u5168\u90e8\u79d1\u6280";
        b2[177] = "\u83b7\u5f97500\u91d1";
        b2[178] = "\u57ce\u9632\u52a010";
        b2[179] = "\u6d88\u706d\u654c\u4eba\u91d1\u7ffb\u500d";
        b2[180] = "\u73b0\u5728\u8fd8\u4e0d\u80fd\u5347\u7ea7\u8fd9\u4e2a\u5efa\u7b51";
        this.b1015 = b2;
        this.o = -1;
        this.q = 60;
        this.b1018 = (b != 0);
        this.a1019 = 0L;
        this.c1020 = false;
        this.r = 0;
        this.e1025 = 0;
        this.f1026 = 0;
        final byte[] array3;
        final byte[] a1015 = array3 = new byte[6];
        array3[0] = -30;
        array3[1] = -1;
        array3[2] = 0;
        array3[4] = (array3[3] = 1);
        array3[5] = 0;
        this.a1027 = a1015;
        final byte[][] a1016 = new byte[n2][];
        final byte[] array5;
        final byte[] array4 = array5 = new byte[al];
        array5[0] = 27;
        array5[1] = 63;
        a1016[0] = array4;
        final byte[] array7;
        final byte[] array6 = array7 = new byte[al];
        array7[0] = 79;
        array7[1] = 33;
        a1016[b] = array6;
        final byte[] array9;
        final byte[] array8 = array9 = new byte[al];
        array9[0] = 113;
        array9[1] = 71;
        a1016[al] = array8;
        this.a1028 = a1016;
        this.V = this.j * 3 + 40;
        this.W = 320 - this.V - 13 - 10;
        this.ad = this.j * 3 + 40;
        this.ah = this.j * 3 + 10 + 30;
        this.ai = this.ah + 40;
        this.aj = 320 - this.ai - 13 - 10;
        final byte[][] b3 = new byte[9][];
        final byte[] array11;
        final byte[] array10 = array11 = new byte[al];
        array11[0] = 103;
        array11[1] = 41;
        b3[0] = array10;
        final byte[] array13;
        final byte[] array12 = array13 = new byte[al];
        array13[0] = 64;
        array13[1] = 38;
        b3[b] = array12;
        final byte[] array15;
        final byte[] array14 = array15 = new byte[al];
        array15[0] = 68;
        array15[1] = 65;
        b3[al] = array14;
        final byte[] array17;
        final byte[] array16 = array17 = new byte[al];
        array17[0] = 96;
        array17[1] = 77;
        b3[n2] = array16;
        final byte[] array19;
        final byte[] array18 = array19 = new byte[al];
        array19[0] = 105;
        array19[1] = 57;
        b3[n] = array18;
        final byte[] array21;
        final byte[] array20 = array21 = new byte[al];
        array21[0] = 60;
        array21[1] = 77;
        b3[5] = array20;
        final byte[] array23;
        final byte[] array22 = array23 = new byte[al];
        array23[0] = 29;
        array23[1] = 73;
        b3[6] = array22;
        final byte[] array25;
        final byte[] array24 = array25 = new byte[al];
        array25[0] = 81;
        array25[1] = 52;
        b3[7] = array24;
        final byte[] array27;
        final byte[] array26 = array27 = new byte[al];
        array27[0] = 122;
        array27[1] = 83;
        b3[8] = array26;
        this.b1030 = b3;
        this.l1031 = (b != 0);
        this.ak = 0;
        final byte[] array28;
        final byte[] b4 = array28 = new byte[n2];
        array28[0] = 87;
        array28[1] = 18;
        array28[2] = 9;
        this.b1034 = b4;
        this.g1035 = new int[n2];
        final byte[] array29;
        final byte[] c1037 = array29 = new byte[42];
        array29[0] = 0;
        array29[1] = 5;
        array29[3] = (array29[2] = 5);
        array29[4] = 10;
        array29[5] = 4;
        array29[6] = 14;
        array29[7] = 7;
        array29[8] = 21;
        array29[9] = 4;
        array29[10] = 25;
        array29[11] = 3;
        array29[12] = 28;
        array29[13] = 3;
        array29[14] = 31;
        array29[15] = 4;
        array29[16] = 35;
        array29[17] = 3;
        array29[18] = 38;
        array29[19] = 4;
        array29[20] = 42;
        array29[21] = 4;
        array29[22] = 46;
        array29[23] = 4;
        array29[24] = 50;
        array29[25] = 4;
        array29[26] = 54;
        array29[27] = 3;
        array29[28] = 57;
        array29[29] = 3;
        array29[30] = 60;
        array29[31] = 4;
        array29[32] = 64;
        array29[33] = 2;
        array29[34] = 66;
        array29[35] = 2;
        array29[36] = 68;
        array29[37] = 4;
        array29[38] = 72;
        array29[39] = 4;
        array29[40] = 76;
        array29[41] = 5;
        this.c1037 = c1037;
        this.a1039 = (int[][])Array.newInstance(Integer.TYPE, 26, 7);
        this.h1041 = new int[15];
        this.a1042 = new InputStream[b];
        this.a1043 = new Player[b];
        this.i1044 = new int[b];
        this.aq = -1;
        this.g1046 = 0;
        this.h1047 = 0;
        this.i1048 = 0;
        final int[] array30 = new int[360];
        array30[0] = 0;
        array30[b] = 71;
        array30[al] = 143;
        array30[n2] = 214;
        array30[n] = 286;
        array30[5] = 357;
        array30[6] = 428;
        array30[7] = 499;
        array30[8] = 570;
        array30[9] = 641;
        array30[10] = 711;
        array30[11] = 782;
        array30[12] = 852;
        array30[13] = 921;
        array30[14] = 991;
        array30[15] = 1060;
        array30[16] = 1129;
        array30[17] = 1198;
        array30[18] = 1266;
        array30[19] = 1334;
        array30[20] = 1401;
        array30[21] = 1468;
        array30[22] = 1534;
        array30[23] = 1600;
        array30[24] = 1666;
        array30[25] = 1731;
        array30[26] = 1796;
        array30[27] = 1860;
        array30[28] = 1923;
        array30[29] = 1986;
        array30[30] = 2048;
        array30[31] = 2110;
        array30[32] = 2171;
        array30[33] = 2231;
        array30[34] = 2290;
        array30[35] = 2349;
        array30[36] = 2408;
        array30[37] = 2465;
        array30[38] = 2522;
        array30[39] = 2578;
        array30[40] = 2633;
        array30[41] = 2687;
        array30[42] = 2741;
        array30[43] = 2793;
        array30[44] = 2845;
        array30[45] = 2896;
        array30[46] = 2946;
        array30[47] = 2996;
        array30[48] = 3044;
        array30[49] = 3091;
        array30[50] = 3138;
        array30[51] = 3183;
        array30[52] = 3228;
        array30[53] = 3271;
        array30[54] = 3314;
        array30[55] = 3355;
        array30[56] = 3396;
        array30[57] = 3435;
        array30[58] = 3474;
        array30[59] = 3511;
        array30[60] = 3547;
        array30[61] = 3582;
        array30[62] = 3617;
        array30[63] = 3650;
        array30[64] = 3681;
        array30[65] = 3712;
        array30[66] = 3742;
        array30[67] = 3770;
        array30[68] = 3798;
        array30[69] = 3824;
        array30[70] = 3849;
        array30[71] = 3873;
        array30[72] = 3896;
        array30[73] = 3917;
        array30[74] = 3937;
        array30[75] = 3956;
        array30[76] = 3974;
        array30[77] = 3991;
        array30[78] = 4006;
        array30[79] = 4021;
        array30[80] = 4034;
        array30[81] = 4046;
        array30[82] = 4056;
        array30[83] = 4065;
        array30[84] = 4074;
        array30[85] = 4080;
        array30[86] = 4086;
        array30[87] = 4090;
        array30[88] = 4094;
        array30[89] = 4095;
        array30[90] = 4096;
        array30[91] = 4095;
        array30[92] = 4094;
        array30[93] = 4090;
        array30[94] = 4086;
        array30[95] = 4080;
        array30[96] = 4074;
        array30[97] = 4065;
        array30[98] = 4056;
        array30[99] = 4046;
        array30[100] = 4034;
        array30[101] = 4021;
        array30[102] = 4006;
        array30[103] = 3991;
        array30[104] = 3974;
        array30[105] = 3956;
        array30[106] = 3937;
        array30[107] = 3917;
        array30[108] = 3896;
        array30[109] = 3873;
        array30[110] = 3849;
        array30[111] = 3824;
        array30[112] = 3798;
        array30[113] = 3770;
        array30[114] = 3742;
        array30[115] = 3712;
        array30[116] = 3681;
        array30[117] = 3650;
        array30[118] = 3617;
        array30[119] = 3582;
        array30[120] = 3547;
        array30[121] = 3511;
        array30[122] = 3474;
        array30[123] = 3435;
        array30[124] = 3396;
        array30[125] = 3355;
        array30[126] = 3314;
        array30[127] = 3271;
        array30[128] = 3228;
        array30[129] = 3183;
        array30[130] = 3138;
        array30[131] = 3091;
        array30[132] = 3044;
        array30[133] = 2996;
        array30[134] = 2946;
        array30[135] = 2896;
        array30[136] = 2845;
        array30[137] = 2793;
        array30[138] = 2741;
        array30[139] = 2687;
        array30[140] = 2633;
        array30[141] = 2578;
        array30[142] = 2522;
        array30[143] = 2465;
        array30[144] = 2408;
        array30[145] = 2349;
        array30[146] = 2290;
        array30[147] = 2231;
        array30[148] = 2171;
        array30[149] = 2110;
        array30[150] = 2048;
        array30[151] = 1986;
        array30[152] = 1923;
        array30[153] = 1860;
        array30[154] = 1796;
        array30[155] = 1731;
        array30[156] = 1666;
        array30[157] = 1600;
        array30[158] = 1534;
        array30[159] = 1468;
        array30[160] = 1401;
        array30[161] = 1334;
        array30[162] = 1266;
        array30[163] = 1198;
        array30[164] = 1129;
        array30[165] = 1060;
        array30[166] = 991;
        array30[167] = 921;
        array30[168] = 852;
        array30[169] = 782;
        array30[170] = 711;
        array30[171] = 641;
        array30[172] = 570;
        array30[173] = 499;
        array30[174] = 428;
        array30[175] = 357;
        array30[176] = 286;
        array30[177] = 214;
        array30[178] = 143;
        array30[179] = 71;
        array30[180] = 0;
        array30[181] = -71;
        array30[182] = -143;
        array30[183] = -214;
        array30[184] = -286;
        array30[185] = -357;
        array30[186] = -428;
        array30[187] = -499;
        array30[188] = -570;
        array30[189] = -641;
        array30[190] = -711;
        array30[191] = -782;
        array30[192] = -852;
        array30[193] = -921;
        array30[194] = -991;
        array30[195] = -1060;
        array30[196] = -1129;
        array30[197] = -1198;
        array30[198] = -1266;
        array30[199] = -1334;
        array30[200] = -1401;
        array30[201] = -1468;
        array30[202] = -1534;
        array30[203] = -1600;
        array30[204] = -1666;
        array30[205] = -1731;
        array30[206] = -1796;
        array30[207] = -1860;
        array30[208] = -1923;
        array30[209] = -1986;
        array30[210] = -2048;
        array30[211] = -2110;
        array30[212] = -2171;
        array30[213] = -2231;
        array30[214] = -2290;
        array30[215] = -2349;
        array30[216] = -2408;
        array30[217] = -2465;
        array30[218] = -2522;
        array30[219] = -2578;
        array30[220] = -2633;
        array30[221] = -2687;
        array30[222] = -2741;
        array30[223] = -2793;
        array30[224] = -2845;
        array30[225] = -2896;
        array30[226] = -2946;
        array30[227] = -2996;
        array30[228] = -3044;
        array30[229] = -3091;
        array30[230] = -3138;
        array30[231] = -3183;
        array30[232] = -3228;
        array30[233] = -3271;
        array30[234] = -3314;
        array30[235] = -3355;
        array30[236] = -3396;
        array30[237] = -3435;
        array30[238] = -3474;
        array30[239] = -3511;
        array30[240] = -3547;
        array30[241] = -3582;
        array30[242] = -3617;
        array30[243] = -3650;
        array30[244] = -3681;
        array30[245] = -3712;
        array30[246] = -3742;
        array30[247] = -3770;
        array30[248] = -3798;
        array30[249] = -3824;
        array30[250] = -3849;
        array30[251] = -3873;
        array30[252] = -3896;
        array30[253] = -3917;
        array30[254] = -3937;
        array30[255] = -3956;
        array30[256] = -3974;
        array30[257] = -3991;
        array30[258] = -4006;
        array30[259] = -4021;
        array30[260] = -4034;
        array30[261] = -4046;
        array30[262] = -4056;
        array30[263] = -4065;
        array30[264] = -4074;
        array30[265] = -4080;
        array30[266] = -4086;
        array30[267] = -4090;
        array30[268] = -4094;
        array30[269] = -4095;
        array30[270] = -4096;
        array30[271] = -4095;
        array30[272] = -4094;
        array30[273] = -4090;
        array30[274] = -4086;
        array30[275] = -4080;
        array30[276] = -4074;
        array30[277] = -4065;
        array30[278] = -4056;
        array30[279] = -4046;
        array30[280] = -4034;
        array30[281] = -4021;
        array30[282] = -4006;
        array30[283] = -3991;
        array30[284] = -3974;
        array30[285] = -3956;
        array30[286] = -3937;
        array30[287] = -3917;
        array30[288] = -3896;
        array30[289] = -3873;
        array30[290] = -3849;
        array30[291] = -3824;
        array30[292] = -3798;
        array30[293] = -3770;
        array30[294] = -3742;
        array30[295] = -3712;
        array30[296] = -3681;
        array30[297] = -3650;
        array30[298] = -3617;
        array30[299] = -3582;
        array30[300] = -3547;
        array30[301] = -3511;
        array30[302] = -3474;
        array30[303] = -3435;
        array30[304] = -3396;
        array30[305] = -3355;
        array30[306] = -3314;
        array30[307] = -3271;
        array30[308] = -3228;
        array30[309] = -3183;
        array30[310] = -3138;
        array30[311] = -3091;
        array30[312] = -3044;
        array30[313] = -2996;
        array30[314] = -2946;
        array30[315] = -2896;
        array30[316] = -2845;
        array30[317] = -2793;
        array30[318] = -2741;
        array30[319] = -2687;
        array30[320] = -2633;
        array30[321] = -2578;
        array30[322] = -2522;
        array30[323] = -2465;
        array30[324] = -2408;
        array30[325] = -2349;
        array30[326] = -2290;
        array30[327] = -2231;
        array30[328] = -2171;
        array30[329] = -2110;
        array30[330] = -2048;
        array30[331] = -1986;
        array30[332] = -1923;
        array30[333] = -1860;
        array30[334] = -1796;
        array30[335] = -1731;
        array30[336] = -1666;
        array30[337] = -1600;
        array30[338] = -1534;
        array30[339] = -1468;
        array30[340] = -1401;
        array30[341] = -1334;
        array30[342] = -1266;
        array30[343] = -1198;
        array30[344] = -1129;
        array30[345] = -1060;
        array30[346] = -991;
        array30[347] = -921;
        array30[348] = -852;
        array30[349] = -782;
        array30[350] = -711;
        array30[351] = -641;
        array30[352] = -570;
        array30[353] = -499;
        array30[354] = -428;
        array30[355] = -357;
        array30[356] = -286;
        array30[357] = -214;
        array30[358] = -143;
        array30[359] = -71;
        final int[] array31;
        final int[] j1049 = array31 = new int[90];
        array31[0] = 0;
        array31[1] = 71;
        array31[2] = 143;
        array31[3] = 215;
        array31[4] = 286;
        array31[5] = 358;
        array31[6] = 431;
        array31[7] = 503;
        array31[8] = 576;
        array31[9] = 649;
        array31[10] = 722;
        array31[11] = 796;
        array31[12] = 871;
        array31[13] = 946;
        array31[14] = 1021;
        array31[15] = 1098;
        array31[16] = 1175;
        array31[17] = 1252;
        array31[18] = 1331;
        array31[19] = 1410;
        array31[20] = 1491;
        array31[21] = 1572;
        array31[22] = 1655;
        array31[23] = 1739;
        array31[24] = 1824;
        array31[25] = 1910;
        array31[26] = 1998;
        array31[27] = 2087;
        array31[28] = 2178;
        array31[29] = 2270;
        array31[30] = 2365;
        array31[31] = 2461;
        array31[32] = 2559;
        array31[33] = 2660;
        array31[34] = 2763;
        array31[35] = 2868;
        array31[36] = 2976;
        array31[37] = 3087;
        array31[38] = 3200;
        array31[39] = 3317;
        array31[40] = 3437;
        array31[41] = 3561;
        array31[42] = 3688;
        array31[43] = 3820;
        array31[44] = 3955;
        array31[45] = 4096;
        array31[46] = 4242;
        array31[47] = 4392;
        array31[48] = 4549;
        array31[49] = 4712;
        array31[50] = 4881;
        array31[51] = 5058;
        array31[52] = 5243;
        array31[53] = 5436;
        array31[54] = 5638;
        array31[55] = 5850;
        array31[56] = 6073;
        array31[57] = 6307;
        array31[58] = 6555;
        array31[59] = 6817;
        array31[60] = 7094;
        array31[61] = 7389;
        array31[62] = 7703;
        array31[63] = 8039;
        array31[64] = 8398;
        array31[65] = 8784;
        array31[66] = 9200;
        array31[67] = 9650;
        array31[68] = 10138;
        array31[69] = 10670;
        array31[70] = 11254;
        array31[71] = 11896;
        array31[72] = 12606;
        array31[73] = 13397;
        array31[74] = 14284;
        array31[75] = 15286;
        array31[76] = 16428;
        array31[77] = 17742;
        array31[78] = 19270;
        array31[79] = 21072;
        array31[80] = 23230;
        array31[81] = 25861;
        array31[82] = 29145;
        array31[83] = 33359;
        array31[84] = 38971;
        array31[85] = 46817;
        array31[86] = 58576;
        array31[87] = 78156;
        array31[88] = 117294;
        array31[89] = 234660;
        this.j1049 = j1049;
        final byte[] array32;
        final byte[] d1012 = array32 = new byte[6];
        array32[0] = 0;
        array32[2] = (array32[1] = 21);
        array32[3] = 11;
        array32[4] = 32;
        array32[5] = 11;
        this.d1050 = d1012;
        final byte[][] c1038 = new byte[n][];
        final byte[] array34;
        final byte[] array33 = array34 = new byte[5];
        array34[0] = 0;
        array34[1] = 1;
        array34[2] = 2;
        array34[3] = 3;
        array34[4] = 4;
        c1038[0] = array33;
        final byte[] array36;
        final byte[] array35 = array36 = new byte[n];
        array36[0] = 1;
        array36[1] = 2;
        array36[2] = 3;
        array36[3] = 4;
        c1038[b] = array35;
        final byte[] array38;
        final byte[] array37 = array38 = new byte[n];
        array38[0] = 6;
        array38[1] = 7;
        array38[2] = 8;
        array38[3] = 9;
        c1038[al] = array37;
        final byte[] array40;
        final byte[] array39 = array40 = new byte[n];
        array40[0] = 5;
        array40[1] = 7;
        array40[2] = 8;
        array40[3] = 9;
        c1038[n2] = array39;
        this.c1051 = c1038;
        final short[][] a1017 = new short[7][];
        final short[] array42;
        final short[] array41 = array42 = new short[al];
        array42[0] = 0;
        array42[1] = 10;
        a1017[0] = array41;
        final short[] array44;
        final short[] array43 = array44 = new short[al];
        array44[0] = 1;
        array44[1] = 10;
        a1017[b] = array43;
        final short[] array46;
        final short[] array45 = array46 = new short[n];
        array46[0] = 2;
        array46[1] = 3;
        array46[2] = 1;
        array46[3] = 10;
        a1017[al] = array45;
        final short[] array48;
        final short[] array47 = array48 = new short[al];
        array48[0] = 4;
        array48[1] = 10;
        a1017[n2] = array47;
        final short[] array50;
        final short[] array49 = array50 = new short[n];
        array50[0] = 5;
        array50[1] = 6;
        array50[2] = 1;
        array50[3] = 10;
        a1017[n] = array49;
        final short[] array52;
        final short[] array51 = array52 = new short[n];
        array52[0] = 7;
        array52[1] = 8;
        array52[2] = 9;
        array52[3] = 10;
        a1017[5] = array51;
        final short[] array54;
        final short[] array53 = array54 = new short[al];
        array54[0] = 11;
        array54[1] = 12;
        a1017[6] = array53;
        this.a1052 = a1017;
        final byte[][] d1013 = new byte[8][];
        final byte[] array56;
        final byte[] array55 = array56 = new byte[12];
        array56[0] = 0;
        array56[1] = 1;
        array56[2] = 10;
        array56[3] = 2;
        array56[4] = 6;
        array56[5] = 3;
        array56[6] = 7;
        array56[7] = 4;
        array56[8] = 8;
        array56[9] = 5;
        array56[10] = 9;
        array56[11] = 21;
        d1013[0] = array55;
        final byte[] array58;
        final byte[] array57 = array58 = new byte[7];
        array58[0] = 11;
        array58[1] = 12;
        array58[2] = 13;
        array58[3] = 14;
        array58[4] = 15;
        array58[5] = 22;
        array58[6] = 21;
        d1013[b] = array57;
        final byte[] array60;
        final byte[] array59 = array60 = new byte[n2];
        array60[0] = 16;
        array60[1] = 20;
        array60[2] = 21;
        d1013[al] = array59;
        final byte[] array62;
        final byte[] array61 = array62 = new byte[n];
        array62[0] = 18;
        array62[1] = 16;
        array62[2] = 20;
        array62[3] = 21;
        d1013[n2] = array61;
        final byte[] array64;
        final byte[] array63 = array64 = new byte[n];
        array64[0] = 19;
        array64[1] = 16;
        array64[2] = 20;
        array64[3] = 21;
        d1013[n] = array63;
        final byte[] array66;
        final byte[] array65 = array66 = new byte[n2];
        array66[0] = 17;
        array66[1] = 20;
        array66[2] = 21;
        d1013[5] = array65;
        final byte[] array68;
        final byte[] array67 = array68 = new byte[n];
        array68[0] = 18;
        array68[1] = 17;
        array68[2] = 20;
        array68[3] = 21;
        d1013[6] = array67;
        final byte[] array70;
        final byte[] array69 = array70 = new byte[n];
        array70[0] = 19;
        array70[1] = 17;
        array70[2] = 20;
        array70[3] = 21;
        d1013[7] = array69;
        this.d1053 = d1013;
        final byte[] array71;
        final byte[] e1054 = array71 = new byte[9];
        array71[0] = 0;
        array71[1] = 8;
        array71[2] = 2;
        array71[3] = 8;
        array71[4] = 10;
        array71[5] = 2;
        array71[6] = 18;
        array71[7] = 15;
        array71[8] = 0;
        this.e1054 = e1054;
        final byte[] array72;
        final byte[] f2 = array72 = new byte[17];
        array72[0] = 0;
        array72[1] = 1;
        array72[3] = (array72[2] = 2);
        array72[5] = (array72[4] = 2);
        array72[7] = (array72[6] = 2);
        array72[9] = (array72[8] = 2);
        array72[11] = (array72[10] = 2);
        array72[13] = (array72[12] = 2);
        array72[14] = -1;
        array72[16] = (array72[15] = -1);
        this.f1055 = f2;
        this.a1056 = new boolean[5];
        final byte[] array73;
        final byte[] g1057 = array73 = new byte[5];
        array73[0] = 20;
        array73[1] = 40;
        array73[2] = 60;
        array73[3] = 80;
        array73[4] = 100;
        this.g1057 = g1057;
        final byte[][] e1055 = new byte[10][];
        final byte[] array75;
        final byte[] array74 = array75 = new byte[n];
        array75[0] = 84;
        array75[1] = 0;
        array75[2] = 21;
        array75[3] = 32;
        e1055[0] = array74;
        final byte[] array77;
        final byte[] array76 = array77 = new byte[n];
        array77[1] = (array77[0] = 0);
        array77[2] = 44;
        array77[3] = 38;
        e1055[b] = array76;
        final byte[] array79;
        final byte[] array78 = array79 = new byte[n];
        array79[0] = 0;
        array79[1] = 38;
        array79[2] = 14;
        array79[3] = 26;
        e1055[al] = array78;
        final byte[] array81;
        final byte[] array80 = array81 = new byte[n];
        array81[0] = 91;
        array81[1] = 32;
        array81[2] = 14;
        array81[3] = 31;
        e1055[n2] = array80;
        final byte[] array83;
        final byte[] array82 = array83 = new byte[n];
        array83[0] = 44;
        array83[1] = 0;
        array83[2] = 40;
        array83[3] = 33;
        e1055[n] = array82;
        final byte[] array85;
        final byte[] array84 = array85 = new byte[n];
        array85[0] = 46;
        array85[1] = 33;
        array85[2] = 40;
        array85[3] = 12;
        e1055[5] = array84;
        final byte[] array87;
        final byte[] array86 = array87 = new byte[n];
        array87[0] = 46;
        array87[1] = 41;
        array87[2] = 15;
        array87[3] = 9;
        e1055[6] = array86;
        final byte[] array89;
        final byte[] array88 = array89 = new byte[n];
        array89[0] = 46;
        array89[1] = 45;
        array89[2] = 18;
        array89[3] = 16;
        e1055[7] = array88;
        final byte[] array91;
        final byte[] array90 = array91 = new byte[n];
        array91[0] = 71;
        array91[1] = 45;
        array91[2] = 20;
        array91[3] = 15;
        e1055[8] = array90;
        final byte[] array93;
        final byte[] array92 = array93 = new byte[n];
        array93[0] = 14;
        array93[1] = 38;
        array93[3] = (array93[2] = 32);
        e1055[9] = array92;
        this.e1058 = e1055;
        this.b1059 = new boolean[10];
        final byte[] array94;
        final byte[] h1060 = array94 = new byte[5];
        array94[0] = 5;
        array94[1] = 8;
        array94[2] = 0;
        array94[3] = 7;
        array94[4] = 4;
        this.h1060 = h1060;
        final boolean[] array95;
        final boolean[] c1039 = array95 = new boolean[10];
        array95[0] = false;
        array95[1] = true;
        array95[3] = (array95[2] = true);
        array95[5] = (array95[4] = false);
        array95[6] = true;
        array95[8] = (array95[7] = false);
        array95[9] = true;
        this.c1061 = c1039;
        final byte[] array96;
        final byte[] i1062 = array96 = new byte[20];
        array96[0] = 1;
        array96[1] = 5;
        array96[2] = 2;
        array96[3] = 10;
        array96[4] = 1;
        array96[5] = 8;
        array96[6] = 12;
        array96[7] = 17;
        array96[8] = -1;
        array96[9] = 0;
        array96[11] = (array96[10] = 0);
        array96[12] = 3;
        array96[13] = 7;
        array96[14] = -2;
        array96[15] = -8;
        array96[16] = 1;
        array96[17] = 4;
        array96[18] = 2;
        array96[19] = -20;
        this.i1062 = i1062;
        final byte[][] f3 = new byte[al][];
        final byte[] array98;
        final byte[] array97 = array98 = new byte[36];
        array98[0] = 0;
        array98[1] = 10;
        array98[3] = (array98[2] = 0);
        array98[4] = 65;
        array98[5] = 0;
        array98[6] = 1;
        array98[7] = 26;
        array98[8] = 36;
        array98[9] = 5;
        array98[10] = 28;
        array98[11] = 46;
        array98[12] = 8;
        array98[13] = 38;
        array98[14] = 53;
        array98[15] = 3;
        array98[16] = 0;
        array98[17] = 40;
        array98[18] = 7;
        array98[19] = -2;
        array98[20] = 32;
        array98[21] = 3;
        array98[22] = 82;
        array98[23] = 40;
        array98[24] = 7;
        array98[25] = 80;
        array98[26] = 32;
        array98[27] = 4;
        array98[28] = 28;
        array98[29] = 16;
        array98[30] = 2;
        array98[31] = 14;
        array98[32] = 44;
        array98[33] = 2;
        array98[34] = 68;
        array98[35] = 43;
        f3[0] = array97;
        final byte[] array100;
        final byte[] array99 = array100 = new byte[30];
        array100[0] = 3;
        array100[1] = 2;
        array100[2] = 11;
        array100[3] = 7;
        array100[4] = 0;
        array100[6] = (array100[5] = 3);
        array100[7] = 70;
        array100[8] = 11;
        array100[9] = 7;
        array100[10] = 68;
        array100[12] = (array100[11] = 3);
        array100[13] = 2;
        array100[14] = 37;
        array100[15] = 7;
        array100[16] = 0;
        array100[17] = 29;
        array100[18] = 3;
        array100[19] = 70;
        array100[20] = 37;
        array100[21] = 7;
        array100[22] = 68;
        array100[23] = 29;
        array100[24] = 1;
        array100[25] = 21;
        array100[26] = 18;
        array100[27] = 9;
        array100[28] = 27;
        array100[29] = 0;
        f3[b] = array99;
        this.f1063 = f3;
        final byte[] array101;
        final byte[] j1050 = array101 = new byte[al];
        array101[0] = 12;
        array101[1] = 10;
        this.j1064 = j1050;
        final byte[][] g1058 = new byte[5][];
        final byte[] array103;
        final byte[] array102 = array103 = new byte[al];
        array103[0] = 1;
        array103[1] = 10;
        g1058[0] = array102;
        final byte[] array105;
        final byte[] array104 = array105 = new byte[al];
        array105[0] = 2;
        array105[1] = 6;
        g1058[b] = array104;
        final byte[] array107;
        final byte[] array106 = array107 = new byte[al];
        array107[0] = 3;
        array107[1] = 7;
        g1058[al] = array106;
        final byte[] array109;
        final byte[] array108 = array109 = new byte[al];
        array109[0] = 4;
        array109[1] = 8;
        g1058[n2] = array108;
        final byte[] array111;
        final byte[] array110 = array111 = new byte[al];
        array111[0] = 5;
        array111[1] = 9;
        g1058[n] = array110;
        this.g1065 = g1058;
        this.b1066 = (int[][])Array.newInstance(Integer.TYPE, 80, 28);
        final byte[][][] a1018 = new byte[9][][];
        final byte[][] array112 = new byte[n2][];
        final byte[] array114;
        final byte[] array113 = array114 = new byte[al];
        array114[1] = (array114[0] = 1);
        array112[0] = array113;
        final byte[] array116;
        final byte[] array115 = array116 = new byte[al];
        array116[0] = 1;
        array116[1] = 2;
        array112[b] = array115;
        final byte[] array118;
        final byte[] array117 = array118 = new byte[al];
        array118[1] = (array118[0] = 3);
        array112[al] = array117;
        a1018[0] = array112;
        final byte[][] array119 = new byte[n][];
        final byte[] array121;
        final byte[] array120 = array121 = new byte[al];
        array121[0] = 3;
        array121[1] = 2;
        array119[0] = array120;
        final byte[] array123;
        final byte[] array122 = array123 = new byte[al];
        array123[0] = 11;
        array123[1] = 2;
        array119[b] = array122;
        final byte[] array125;
        final byte[] array124 = array125 = new byte[al];
        array125[0] = 7;
        array125[1] = 6;
        array119[al] = array124;
        final byte[] array127;
        final byte[] array126 = array127 = new byte[al];
        array127[0] = 5;
        array127[1] = 8;
        array119[n2] = array126;
        a1018[b] = array119;
        final byte[][] array128 = new byte[10][];
        final byte[] array130;
        final byte[] array129 = array130 = new byte[al];
        array130[0] = 3;
        array130[1] = 5;
        array128[0] = array129;
        final byte[] array132;
        final byte[] array131 = array132 = new byte[al];
        array132[0] = 5;
        array132[1] = 1;
        array128[b] = array131;
        final byte[] array134;
        final byte[] array133 = array134 = new byte[al];
        array134[0] = 3;
        array134[1] = 7;
        array128[al] = array133;
        final byte[] array136;
        final byte[] array135 = array136 = new byte[al];
        array136[0] = 7;
        array136[1] = 6;
        array128[n2] = array135;
        final byte[] array138;
        final byte[] array137 = array138 = new byte[al];
        array138[0] = 7;
        array138[1] = 1;
        array128[n] = array137;
        final byte[] array140;
        final byte[] array139 = array140 = new byte[al];
        array140[0] = 9;
        array140[1] = 3;
        array128[5] = array139;
        final byte[] array142;
        final byte[] array141 = array142 = new byte[al];
        array142[0] = 3;
        array142[1] = 5;
        array128[6] = array141;
        final byte[] array144;
        final byte[] array143 = array144 = new byte[al];
        array144[0] = 7;
        array144[1] = 1;
        array128[7] = array143;
        final byte[] array146;
        final byte[] array145 = array146 = new byte[al];
        array146[0] = 7;
        array146[1] = 8;
        array128[8] = array145;
        final byte[] array148;
        final byte[] array147 = array148 = new byte[al];
        array148[0] = 11;
        array148[1] = 2;
        array128[9] = array147;
        a1018[al] = array128;
        final byte[][] array149 = new byte[12][];
        final byte[] array151;
        final byte[] array150 = array151 = new byte[al];
        array151[0] = 7;
        array151[1] = 6;
        array149[0] = array150;
        final byte[] array153;
        final byte[] array152 = array153 = new byte[al];
        array153[0] = 3;
        array153[1] = 4;
        array149[b] = array152;
        final byte[] array155;
        final byte[] array154 = array155 = new byte[al];
        array155[0] = 7;
        array155[1] = 1;
        array149[al] = array154;
        final byte[] array157;
        final byte[] array156 = array157 = new byte[al];
        array157[0] = 5;
        array157[1] = 1;
        array149[n2] = array156;
        final byte[] array159;
        final byte[] array158 = array159 = new byte[al];
        array159[0] = 11;
        array159[1] = 8;
        array149[n] = array158;
        final byte[] array161;
        final byte[] array160 = array161 = new byte[al];
        array161[0] = 3;
        array161[1] = 7;
        array149[5] = array160;
        final byte[] array163;
        final byte[] array162 = array163 = new byte[al];
        array163[0] = 9;
        array163[1] = 3;
        array149[6] = array162;
        final byte[] array165;
        final byte[] array164 = array165 = new byte[al];
        array165[0] = 11;
        array165[1] = 2;
        array149[7] = array164;
        final byte[] array167;
        final byte[] array166 = array167 = new byte[al];
        array167[0] = 5;
        array167[1] = 3;
        array149[8] = array166;
        final byte[] array169;
        final byte[] array168 = array169 = new byte[al];
        array169[0] = 9;
        array169[1] = 3;
        array149[9] = array168;
        final byte[] array171;
        final byte[] array170 = array171 = new byte[al];
        array171[0] = 3;
        array171[1] = 4;
        array149[10] = array170;
        final byte[] array173;
        final byte[] array172 = array173 = new byte[al];
        array173[0] = 5;
        array173[1] = 3;
        array149[11] = array172;
        a1018[n2] = array149;
        final byte[][] array174 = new byte[12][];
        final byte[] array176;
        final byte[] array175 = array176 = new byte[al];
        array176[0] = 7;
        array176[1] = 1;
        array174[0] = array175;
        final byte[] array178;
        final byte[] array177 = array178 = new byte[al];
        array178[0] = 3;
        array178[1] = 7;
        array174[b] = array177;
        final byte[] array180;
        final byte[] array179 = array180 = new byte[al];
        array180[0] = 11;
        array180[1] = 8;
        array174[al] = array179;
        final byte[] array182;
        final byte[] array181 = array182 = new byte[al];
        array182[0] = 7;
        array182[1] = 6;
        array174[n2] = array181;
        final byte[] array184;
        final byte[] array183 = array184 = new byte[al];
        array184[0] = 3;
        array184[1] = 7;
        array174[n] = array183;
        final byte[] array186;
        final byte[] array185 = array186 = new byte[al];
        array186[0] = 7;
        array186[1] = 5;
        array174[5] = array185;
        final byte[] array188;
        final byte[] array187 = array188 = new byte[al];
        array188[1] = (array188[0] = 3);
        array174[6] = array187;
        final byte[] array190;
        final byte[] array189 = array190 = new byte[al];
        array190[0] = 1;
        array190[1] = 2;
        array174[7] = array189;
        final byte[] array192;
        final byte[] array191 = array192 = new byte[al];
        array192[0] = 5;
        array192[1] = 2;
        array174[8] = array191;
        final byte[] array194;
        final byte[] array193 = array194 = new byte[al];
        array194[0] = 7;
        array194[1] = 1;
        array174[9] = array193;
        final byte[] array196;
        final byte[] array195 = array196 = new byte[al];
        array196[0] = 3;
        array196[1] = 1;
        array174[10] = array195;
        final byte[] array198;
        final byte[] array197 = array198 = new byte[al];
        array198[0] = 3;
        array198[1] = 4;
        array174[11] = array197;
        a1018[n] = array174;
        final byte[][] array199 = new byte[12][];
        final byte[] array201;
        final byte[] array200 = array201 = new byte[al];
        array201[0] = 9;
        array201[1] = 3;
        array199[0] = array200;
        final byte[] array203;
        final byte[] array202 = array203 = new byte[al];
        array203[0] = 7;
        array203[1] = 3;
        array199[b] = array202;
        final byte[] array205;
        final byte[] array204 = array205 = new byte[al];
        array205[0] = 7;
        array205[1] = 4;
        array199[al] = array204;
        final byte[] array207;
        final byte[] array206 = array207 = new byte[al];
        array207[0] = 11;
        array207[1] = 1;
        array199[n2] = array206;
        final byte[] array209;
        final byte[] array208 = array209 = new byte[al];
        array209[0] = 3;
        array209[1] = 6;
        array199[n] = array208;
        final byte[] array211;
        final byte[] array210 = array211 = new byte[al];
        array211[0] = 11;
        array211[1] = 2;
        array199[5] = array210;
        final byte[] array213;
        final byte[] array212 = array213 = new byte[al];
        array213[0] = 7;
        array213[1] = 1;
        array199[6] = array212;
        final byte[] array215;
        final byte[] array214 = array215 = new byte[al];
        array215[1] = (array215[0] = 5);
        array199[7] = array214;
        final byte[] array217;
        final byte[] array216 = array217 = new byte[al];
        array217[0] = 1;
        array217[1] = 2;
        array199[8] = array216;
        final byte[] array219;
        final byte[] array218 = array219 = new byte[al];
        array219[0] = 9;
        array219[1] = 3;
        array199[9] = array218;
        final byte[] array221;
        final byte[] array220 = array221 = new byte[al];
        array221[0] = 3;
        array221[1] = 1;
        array199[10] = array220;
        final byte[] array223;
        final byte[] array222 = array223 = new byte[al];
        array223[1] = (array223[0] = 3);
        array199[11] = array222;
        a1018[5] = array199;
        final byte[][] array224 = new byte[5][];
        final byte[] array226;
        final byte[] array225 = array226 = new byte[al];
        array226[0] = 7;
        array226[1] = 3;
        array224[0] = array225;
        final byte[] array228;
        final byte[] array227 = array228 = new byte[al];
        array228[0] = 11;
        array228[1] = 2;
        array224[b] = array227;
        final byte[] array230;
        final byte[] array229 = array230 = new byte[al];
        array230[0] = 7;
        array230[1] = 4;
        array224[al] = array229;
        final byte[] array232;
        final byte[] array231 = array232 = new byte[al];
        array232[0] = 3;
        array232[1] = 8;
        array224[n2] = array231;
        final byte[] array234;
        final byte[] array233 = array234 = new byte[al];
        array234[0] = 5;
        array234[1] = 6;
        array224[n] = array233;
        a1018[6] = array224;
        final byte[][] array235 = new byte[5][];
        final byte[] array237;
        final byte[] array236 = array237 = new byte[al];
        array237[0] = 7;
        array237[1] = 1;
        array235[0] = array236;
        final byte[] array239;
        final byte[] array238 = array239 = new byte[al];
        array239[0] = 3;
        array239[1] = 5;
        array235[b] = array238;
        final byte[] array241;
        final byte[] array240 = array241 = new byte[al];
        array241[0] = 5;
        array241[1] = 1;
        array235[al] = array240;
        final byte[] array243;
        final byte[] array242 = array243 = new byte[al];
        array243[0] = 7;
        array243[1] = 5;
        array235[n2] = array242;
        final byte[] array245;
        final byte[] array244 = array245 = new byte[al];
        array245[0] = 5;
        array245[1] = 3;
        array235[n] = array244;
        a1018[7] = array235;
        final byte[][] array246 = new byte[5][];
        final byte[] array248;
        final byte[] array247 = array248 = new byte[al];
        array248[0] = 1;
        array248[1] = 2;
        array246[0] = array247;
        final byte[] array250;
        final byte[] array249 = array250 = new byte[al];
        array250[0] = 3;
        array250[1] = 1;
        array246[b] = array249;
        final byte[] array252;
        final byte[] array251 = array252 = new byte[al];
        array252[0] = 3;
        array252[1] = 4;
        array246[al] = array251;
        final byte[] array254;
        final byte[] array253 = array254 = new byte[al];
        array254[1] = (array254[0] = 5);
        array246[n2] = array253;
        final byte[] array256;
        final byte[] array255 = array256 = new byte[al];
        array256[0] = 7;
        array256[1] = 1;
        array246[n] = array255;
        a1018[8] = array246;
        this.a1067 = a1018;
        final byte[] array257;
        final byte[] k1068 = array257 = new byte[9];
        array257[1] = (array257[0] = 0);
        array257[2] = 1;
        array257[3] = 2;
        array257[4] = 3;
        array257[5] = 4;
        array257[6] = 6;
        array257[7] = 5;
        array257[8] = 6;
        this.k1068 = k1068;
        final short[][] b5 = new short[9][];
        final short[] array259;
        final short[] array258 = array259 = new short[al];
        array259[0] = 136;
        array259[1] = 88;
        b5[0] = array258;
        final short[] array261;
        final short[] array260 = array261 = new short[al];
        array261[1] = (array261[0] = 56);
        b5[b] = array260;
        final short[] array263;
        final short[] array262 = array263 = new short[al];
        array263[0] = 408;
        array263[1] = 104;
        b5[al] = array262;
        final short[] array265;
        final short[] array264 = array265 = new short[al];
        array265[0] = 568;
        array265[1] = 56;
        b5[n2] = array264;
        final short[] array267;
        final short[] array266 = array267 = new short[al];
        array267[1] = (array267[0] = 56);
        b5[n] = array266;
        final short[] array269;
        final short[] array268 = array269 = new short[al];
        array269[1] = (array269[0] = 88);
        b5[5] = array268;
        final short[] array271;
        final short[] array270 = array271 = new short[al];
        array271[0] = 56;
        array271[1] = 72;
        b5[6] = array270;
        final short[] array273;
        final short[] array272 = array273 = new short[al];
        array273[1] = (array273[0] = 72);
        b5[7] = array272;
        final short[] array275;
        final short[] array274 = array275 = new short[al];
        array275[0] = 456;
        array275[1] = 56;
        b5[8] = array274;
        this.b1069 = b5;
        final short[][] c1040 = new short[9][];
        final short[] array277;
        final short[] array276 = array277 = new short[al];
        array277[0] = 336;
        array277[1] = 64;
        c1040[0] = array276;
        final short[] array279;
        final short[] array278 = array279 = new short[al];
        array279[0] = 64;
        array279[1] = 528;
        c1040[b] = array278;
        final short[] array281;
        final short[] array280 = array281 = new short[al];
        array281[0] = 160;
        array281[1] = 176;
        c1040[al] = array280;
        final short[] array283;
        final short[] array282 = array283 = new short[al];
        array283[0] = 560;
        array283[1] = 432;
        c1040[n2] = array282;
        final short[] array285;
        final short[] array284 = array285 = new short[al];
        array285[0] = 592;
        array285[1] = 352;
        c1040[n] = array284;
        final short[] array287;
        final short[] array286 = array287 = new short[al];
        array287[0] = 256;
        array287[1] = 320;
        c1040[5] = array286;
        final short[] array289;
        final short[] array288 = array289 = new short[al];
        array289[0] = 320;
        array289[1] = 336;
        c1040[6] = array288;
        final short[] array291;
        final short[] array290 = array291 = new short[al];
        array291[0] = 96;
        array291[1] = 640;
        c1040[7] = array290;
        final short[] array293;
        final short[] array292 = array293 = new short[al];
        array293[0] = 96;
        array293[1] = 32;
        c1040[8] = array292;
        this.c1070 = c1040;
        final int[] array294;
        final int[] k1069 = array294 = new int[9];
        array294[0] = 6981008;
        array294[2] = (array294[1] = 8089212);
        array294[3] = 9659759;
        array294[4] = 11329522;
        array294[5] = 1210262;
        array294[6] = 6981008;
        array294[7] = 11329522;
        array294[8] = 9659759;
        this.k1071 = k1069;
        final byte[] array295;
        final byte[] l1072 = array295 = new byte[9];
        array295[0] = 12;
        array295[1] = 16;
        array295[2] = 20;
        array295[3] = 24;
        array295[5] = (array295[4] = 24);
        array295[6] = 20;
        array295[8] = (array295[7] = 20);
        this.l1072 = l1072;
        final boolean[] array296;
        final boolean[] d1014 = array296 = new boolean[9];
        array296[0] = true;
        array296[2] = (array296[1] = false);
        array296[4] = (array296[3] = false);
        array296[6] = (array296[5] = false);
        array296[8] = (array296[7] = false);
        this.d1073 = d1014;
        final byte[][] h1061 = new byte[n2][];
        final byte[] array298;
        final byte[] array297 = array298 = new byte[7];
        array298[0] = 0;
        array298[1] = 1;
        array298[2] = 2;
        array298[3] = 3;
        array298[4] = 5;
        array298[5] = 7;
        array298[6] = 8;
        h1061[0] = array297;
        final byte[] array300;
        final byte[] array299 = array300 = new byte[7];
        array300[0] = 0;
        array300[1] = 1;
        array300[2] = 2;
        array300[3] = 3;
        array300[4] = 4;
        array300[5] = 6;
        array300[6] = 8;
        h1061[b] = array299;
        final byte[] array302;
        final byte[] array301 = array302 = new byte[7];
        array302[0] = 0;
        array302[1] = 1;
        array302[2] = 3;
        array302[3] = 4;
        array302[4] = 5;
        array302[5] = 6;
        array302[6] = 7;
        h1061[al] = array301;
        this.h1074 = h1061;
        final byte[] array303;
        final byte[] m1075 = array303 = new byte[9];
        array303[0] = 0;
        array303[1] = 1;
        array303[2] = 2;
        array303[3] = 3;
        array303[4] = 4;
        array303[5] = 5;
        array303[6] = 6;
        array303[7] = 4;
        array303[8] = 3;
        this.m1075 = m1075;
        final byte[] array304;
        final byte[] n3 = array304 = new byte[9];
        array304[0] = 0;
        array304[1] = 1;
        array304[2] = 2;
        array304[3] = 3;
        array304[4] = 4;
        array304[6] = (array304[5] = 2);
        array304[7] = 4;
        array304[8] = 3;
        this.n1076 = n3;
        this.aU = 12;
        final byte[][] i1063 = new byte[6][];
        final byte[] array306;
        final byte[] array305 = array306 = new byte[6];
        array306[0] = 40;
        array306[1] = 4;
        array306[2] = 20;
        array306[3] = 2;
        array306[4] = 1;
        array306[5] = 2;
        i1063[0] = array305;
        final byte[] array308;
        final byte[] array307 = array308 = new byte[6];
        array308[0] = 60;
        array308[1] = 6;
        array308[2] = 20;
        array308[3] = 1;
        array308[5] = (array308[4] = 2);
        i1063[b] = array307;
        final byte[] array310;
        final byte[] array309 = array310 = new byte[6];
        array310[0] = 100;
        array310[1] = 10;
        array310[2] = 15;
        array310[3] = 1;
        array310[4] = 3;
        array310[5] = 1;
        i1063[al] = array309;
        final byte[] array312;
        final byte[] array311 = array312 = new byte[6];
        array312[0] = 80;
        array312[1] = 8;
        array312[2] = 10;
        array312[3] = 1;
        array312[4] = 2;
        array312[5] = 4;
        i1063[n2] = array311;
        final byte[] array314;
        final byte[] array313 = array314 = new byte[6];
        array314[0] = 40;
        array314[1] = 4;
        array314[2] = 10;
        array314[4] = (array314[3] = 1);
        array314[5] = 2;
        i1063[n] = array313;
        final byte[] array316;
        final byte[] array315 = array316 = new byte[6];
        array316[0] = 120;
        array316[1] = 15;
        array316[2] = 20;
        array316[3] = 3;
        array316[4] = 0;
        array316[5] = 2;
        i1063[5] = array315;
        this.i1079 = i1063;
        final byte[][] j1051 = new byte[9][];
        final byte[] array318;
        final byte[] array317 = array318 = new byte[6];
        array318[0] = 9;
        array318[1] = 14;
        array318[2] = 16;
        array318[3] = 17;
        array318[4] = 18;
        array318[5] = 20;
        j1051[0] = array317;
        final byte[] array320;
        final byte[] array319 = array320 = new byte[6];
        array320[0] = 4;
        array320[1] = 9;
        array320[2] = 14;
        array320[3] = 17;
        array320[4] = 18;
        array320[5] = 20;
        j1051[b] = array319;
        final byte[] array322;
        final byte[] array321 = array322 = new byte[6];
        array322[0] = 1;
        array322[1] = 8;
        array322[2] = 11;
        array322[3] = 18;
        array322[4] = 19;
        array322[5] = 20;
        j1051[al] = array321;
        final byte[] array324;
        final byte[] array323 = array324 = new byte[6];
        array324[0] = 3;
        array324[1] = 7;
        array324[2] = 11;
        array324[3] = 15;
        array324[4] = 16;
        array324[5] = 20;
        j1051[n2] = array323;
        final byte[] array326;
        final byte[] array325 = array326 = new byte[6];
        array326[0] = 1;
        array326[1] = 8;
        array326[2] = 11;
        array326[3] = 16;
        array326[4] = 17;
        array326[5] = 20;
        j1051[n] = array325;
        final byte[] array328;
        final byte[] array327 = array328 = new byte[6];
        array328[0] = 0;
        array328[1] = 5;
        array328[2] = 10;
        array328[3] = 14;
        array328[4] = 15;
        array328[5] = 20;
        j1051[5] = array327;
        final byte[] array330;
        final byte[] array329 = array330 = new byte[6];
        array330[0] = 0;
        array330[1] = 3;
        array330[2] = 12;
        array330[3] = 18;
        array330[4] = 19;
        array330[5] = 20;
        j1051[6] = array329;
        final byte[] array332;
        final byte[] array331 = array332 = new byte[6];
        array332[0] = 0;
        array332[1] = 1;
        array332[2] = 6;
        array332[3] = 15;
        array332[4] = 16;
        array332[5] = 20;
        j1051[7] = array331;
        final byte[] array334;
        final byte[] array333 = array334 = new byte[6];
        array334[0] = 0;
        array334[1] = 2;
        array334[2] = 7;
        array334[3] = 10;
        array334[4] = 11;
        array334[5] = 20;
        j1051[8] = array333;
        this.j1080 = j1051;
        final byte[][] k1070 = new byte[n][];
        final byte[] array336;
        final byte[] array335 = array336 = new byte[al];
        array336[0] = 0;
        array336[1] = -1;
        k1070[0] = array335;
        final byte[] array338;
        final byte[] array337 = array338 = new byte[al];
        array338[0] = 1;
        array338[1] = 0;
        k1070[b] = array337;
        final byte[] array340;
        final byte[] array339 = array340 = new byte[al];
        array340[0] = 0;
        array340[1] = 1;
        k1070[al] = array339;
        final byte[] array342;
        final byte[] array341 = array342 = new byte[al];
        array342[0] = -1;
        array342[1] = 0;
        k1070[n2] = array341;
        this.k1081 = k1070;
        final byte[][] l1073 = new byte[6][];
        final byte[] array344;
        final byte[] array343 = array344 = new byte[n];
        array344[0] = 0;
        array344[1] = 1;
        array344[2] = 2;
        array344[3] = 1;
        l1073[0] = array343;
        final byte[] array346;
        final byte[] array345 = array346 = new byte[n];
        array346[0] = 0;
        array346[1] = 1;
        array346[2] = 2;
        array346[3] = 1;
        l1073[b] = array345;
        final byte[] array348;
        final byte[] array347 = array348 = new byte[8];
        array348[1] = (array348[0] = 0);
        array348[3] = (array348[2] = 1);
        array348[5] = (array348[4] = 2);
        array348[7] = (array348[6] = 1);
        l1073[al] = array347;
        final byte[] array350;
        final byte[] array349 = array350 = new byte[n2];
        array350[0] = 0;
        array350[1] = 1;
        array350[2] = 2;
        l1073[n2] = array349;
        final byte[] array352;
        final byte[] array351 = array352 = new byte[n];
        array352[0] = 0;
        array352[1] = 1;
        array352[2] = 2;
        array352[3] = 1;
        l1073[n] = array351;
        final byte[] array354;
        final byte[] array353 = array354 = new byte[n];
        array354[0] = 0;
        array354[1] = 1;
        array354[2] = 2;
        array354[3] = 1;
        l1073[5] = array353;
        this.l1083 = l1073;
        final byte[][] m1076 = new byte[n][];
        final byte[] array356;
        final byte[] array355 = array356 = new byte[n];
        array356[0] = 1;
        array356[1] = -1;
        array356[2] = 0;
        array356[3] = -16;
        m1076[0] = array355;
        final byte[] array358;
        final byte[] array357 = array358 = new byte[n];
        array358[1] = (array358[0] = 1);
        array358[2] = 48;
        array358[3] = 0;
        m1076[b] = array357;
        final byte[] array360;
        final byte[] array359 = array360 = new byte[n];
        array360[1] = (array360[0] = 1);
        array360[2] = 0;
        array360[3] = 64;
        m1076[al] = array359;
        final byte[] array362;
        final byte[] array361 = array362 = new byte[n];
        array362[0] = -1;
        array362[1] = 1;
        array362[2] = -16;
        array362[3] = 0;
        m1076[n2] = array361;
        this.m1084 = m1076;
        final byte[][][] b6 = new byte[n2][][];
        final byte[][] array363 = new byte[n][];
        final byte[] array365;
        final byte[] array364 = array365 = new byte[al];
        array365[1] = (array365[0] = 0);
        array363[0] = array364;
        final byte[] array367;
        final byte[] array366 = array367 = new byte[al];
        array367[0] = 0;
        array367[1] = -1;
        array363[b] = array366;
        final byte[] array369;
        final byte[] array368 = array369 = new byte[al];
        array369[0] = 1;
        array369[1] = 0;
        array363[al] = array368;
        final byte[] array371;
        final byte[] array370 = array371 = new byte[al];
        array371[1] = (array371[0] = 1);
        array363[n2] = array370;
        b6[0] = array363;
        final byte[][] array372 = new byte[n][];
        final byte[] array374;
        final byte[] array373 = array374 = new byte[al];
        array374[1] = (array374[0] = 0);
        array372[0] = array373;
        final byte[] array376;
        final byte[] array375 = array376 = new byte[al];
        array376[0] = -1;
        array376[1] = 0;
        array372[b] = array375;
        final byte[] array378;
        final byte[] array377 = array378 = new byte[al];
        array378[0] = 0;
        array378[1] = 1;
        array372[al] = array377;
        final byte[] array380;
        final byte[] array379 = array380 = new byte[al];
        array380[0] = -1;
        array380[1] = 1;
        array372[n2] = array379;
        b6[b] = array372;
        final byte[][] array381 = new byte[n][];
        final byte[] array383;
        final byte[] array382 = array383 = new byte[al];
        array383[1] = (array383[0] = 0);
        array381[0] = array382;
        final byte[] array385;
        final byte[] array384 = array385 = new byte[al];
        array385[0] = 0;
        array385[1] = 1;
        array381[b] = array384;
        final byte[] array387;
        final byte[] array386 = array387 = new byte[al];
        array387[0] = -1;
        array387[1] = 0;
        array381[al] = array386;
        final byte[] array389;
        final byte[] array388 = array389 = new byte[al];
        array389[1] = (array389[0] = -1);
        array381[n2] = array388;
        b6[al] = array381;
        this.b1085 = b6;
        final byte[][][] c1041 = new byte[12][][];
        final byte[][] array390 = new byte[n][];
        final byte[] array392;
        final byte[] array391 = array392 = new byte[al];
        array392[0] = 1;
        array392[1] = 8;
        array390[0] = array391;
        final byte[] array394;
        final byte[] array393 = array394 = new byte[al];
        array394[0] = 1;
        array394[1] = 8;
        array390[b] = array393;
        final byte[] array396;
        final byte[] array395 = array396 = new byte[al];
        array396[0] = 1;
        array396[1] = 8;
        array390[al] = array395;
        final byte[] array398;
        final byte[] array397 = array398 = new byte[al];
        array398[0] = 0;
        array398[1] = 8;
        array390[n2] = array397;
        c1041[0] = array390;
        final byte[][] array399 = new byte[n][];
        final byte[] array401;
        final byte[] array400 = array401 = new byte[al];
        array401[0] = 1;
        array401[1] = 8;
        array399[0] = array400;
        final byte[] array403;
        final byte[] array402 = array403 = new byte[al];
        array403[0] = 1;
        array403[1] = 8;
        array399[b] = array402;
        final byte[] array405;
        final byte[] array404 = array405 = new byte[al];
        array405[0] = 1;
        array405[1] = 8;
        array399[al] = array404;
        final byte[] array407;
        final byte[] array406 = array407 = new byte[al];
        array407[0] = 0;
        array407[1] = 8;
        array399[n2] = array406;
        c1041[b] = array399;
        final byte[][] array408 = new byte[n][];
        final byte[] array410;
        final byte[] array409 = array410 = new byte[al];
        array410[0] = 1;
        array410[1] = 9;
        array408[0] = array409;
        final byte[] array412;
        final byte[] array411 = array412 = new byte[al];
        array412[0] = 1;
        array412[1] = 9;
        array408[b] = array411;
        final byte[] array414;
        final byte[] array413 = array414 = new byte[al];
        array414[0] = 1;
        array414[1] = 9;
        array408[al] = array413;
        final byte[] array416;
        final byte[] array415 = array416 = new byte[al];
        array416[0] = 0;
        array416[1] = 9;
        array408[n2] = array415;
        c1041[al] = array408;
        final byte[][] array417 = new byte[n][];
        final byte[] array419;
        final byte[] array418 = array419 = new byte[al];
        array419[0] = 2;
        array419[1] = 9;
        array417[0] = array418;
        final byte[] array421;
        final byte[] array420 = array421 = new byte[al];
        array421[0] = 2;
        array421[1] = 9;
        array417[b] = array420;
        final byte[] array423;
        final byte[] array422 = array423 = new byte[al];
        array423[0] = 2;
        array423[1] = 9;
        array417[al] = array422;
        final byte[] array425;
        final byte[] array424 = array425 = new byte[al];
        array425[0] = 1;
        array425[1] = 9;
        array417[n2] = array424;
        c1041[n2] = array417;
        final byte[][] array426 = new byte[n][];
        final byte[] array428;
        final byte[] array427 = array428 = new byte[al];
        array428[0] = 3;
        array428[1] = 8;
        array426[0] = array427;
        final byte[] array430;
        final byte[] array429 = array430 = new byte[al];
        array430[0] = 1;
        array430[1] = 8;
        array426[b] = array429;
        final byte[] array432;
        final byte[] array431 = array432 = new byte[al];
        array432[0] = 1;
        array432[1] = 8;
        array426[al] = array431;
        final byte[] array434;
        final byte[] array433 = array434 = new byte[al];
        array434[0] = 3;
        array434[1] = 8;
        array426[n2] = array433;
        c1041[n] = array426;
        final byte[][] array435 = new byte[n][];
        final byte[] array437;
        final byte[] array436 = array437 = new byte[al];
        array437[0] = 3;
        array437[1] = 9;
        array435[0] = array436;
        final byte[] array439;
        final byte[] array438 = array439 = new byte[al];
        array439[0] = 2;
        array439[1] = 9;
        array435[b] = array438;
        final byte[] array441;
        final byte[] array440 = array441 = new byte[al];
        array441[0] = 2;
        array441[1] = 9;
        array435[al] = array440;
        final byte[] array443;
        final byte[] array442 = array443 = new byte[al];
        array443[0] = 3;
        array443[1] = 9;
        array435[n2] = array442;
        c1041[5] = array435;
        final byte[][] array444 = new byte[n][];
        final byte[] array446;
        final byte[] array445 = array446 = new byte[al];
        array446[0] = 2;
        array446[1] = 16;
        array444[0] = array445;
        final byte[] array448;
        final byte[] array447 = array448 = new byte[al];
        array448[0] = 7;
        array448[1] = 16;
        array444[b] = array447;
        final byte[] array450;
        final byte[] array449 = array450 = new byte[al];
        array450[0] = 3;
        array450[1] = 16;
        array444[al] = array449;
        final byte[] array452;
        final byte[] array451 = array452 = new byte[al];
        array452[0] = 5;
        array452[1] = 16;
        array444[n2] = array451;
        c1041[6] = array444;
        final byte[][] array453 = new byte[n][];
        final byte[] array455;
        final byte[] array454 = array455 = new byte[al];
        array455[0] = 2;
        array455[1] = 16;
        array453[0] = array454;
        final byte[] array457;
        final byte[] array456 = array457 = new byte[al];
        array457[0] = 7;
        array457[1] = 16;
        array453[b] = array456;
        final byte[] array459;
        final byte[] array458 = array459 = new byte[al];
        array459[0] = 3;
        array459[1] = 16;
        array453[al] = array458;
        final byte[] array461;
        final byte[] array460 = array461 = new byte[al];
        array461[0] = 5;
        array461[1] = 16;
        array453[n2] = array460;
        c1041[7] = array453;
        final byte[][] array462 = new byte[n][];
        final byte[] array464;
        final byte[] array463 = array464 = new byte[al];
        array464[0] = 3;
        array464[1] = 9;
        array462[0] = array463;
        final byte[] array466;
        final byte[] array465 = array466 = new byte[al];
        array466[0] = 3;
        array466[1] = 9;
        array462[b] = array465;
        final byte[] array468;
        final byte[] array467 = array468 = new byte[al];
        array468[0] = 5;
        array468[1] = 9;
        array462[al] = array467;
        final byte[] array470;
        final byte[] array469 = array470 = new byte[al];
        array470[0] = 2;
        array470[1] = 9;
        array462[n2] = array469;
        c1041[8] = array462;
        final byte[][] array471 = new byte[n][];
        final byte[] array473;
        final byte[] array472 = array473 = new byte[al];
        array473[0] = 3;
        array473[1] = 9;
        array471[0] = array472;
        final byte[] array475;
        final byte[] array474 = array475 = new byte[al];
        array475[0] = 3;
        array475[1] = 9;
        array471[b] = array474;
        final byte[] array477;
        final byte[] array476 = array477 = new byte[al];
        array477[0] = 5;
        array477[1] = 9;
        array471[al] = array476;
        final byte[] array479;
        final byte[] array478 = array479 = new byte[al];
        array479[0] = 2;
        array479[1] = 9;
        array471[n2] = array478;
        c1041[9] = array471;
        final byte[][] array480 = new byte[n][];
        final byte[] array482;
        final byte[] array481 = array482 = new byte[al];
        array482[0] = 2;
        array482[1] = 10;
        array480[0] = array481;
        final byte[] array484;
        final byte[] array483 = array484 = new byte[al];
        array484[0] = 2;
        array484[1] = 10;
        array480[b] = array483;
        final byte[] array486;
        final byte[] array485 = array486 = new byte[al];
        array486[0] = 0;
        array486[1] = 10;
        array480[al] = array485;
        final byte[] array488;
        final byte[] array487 = array488 = new byte[al];
        array488[0] = 2;
        array488[1] = 10;
        array480[n2] = array487;
        c1041[10] = array480;
        final byte[][] array489 = new byte[n][];
        final byte[] array491;
        final byte[] array490 = array491 = new byte[al];
        array491[0] = 4;
        array491[1] = 12;
        array489[0] = array490;
        final byte[] array493;
        final byte[] array492 = array493 = new byte[al];
        array493[0] = 2;
        array493[1] = 12;
        array489[b] = array492;
        final byte[] array495;
        final byte[] array494 = array495 = new byte[al];
        array495[0] = 0;
        array495[1] = 12;
        array489[al] = array494;
        final byte[] array497;
        final byte[] array496 = array497 = new byte[al];
        array497[0] = 2;
        array497[1] = 12;
        array489[n2] = array496;
        c1041[11] = array489;
        this.c1090 = c1041;
        final byte[][][] d1015 = new byte[12][][];
        final byte[][] array498 = new byte[n][];
        final byte[] array500;
        final byte[] array499 = array500 = new byte[al];
        array500[0] = -7;
        array500[1] = -12;
        array498[0] = array499;
        final byte[] array502;
        final byte[] array501 = array502 = new byte[al];
        array502[0] = -7;
        array502[1] = -12;
        array498[b] = array501;
        final byte[] array504;
        final byte[] array503 = array504 = new byte[al];
        array504[0] = -7;
        array504[1] = -12;
        array498[al] = array503;
        final byte[] array506;
        final byte[] array505 = array506 = new byte[al];
        array506[0] = -6;
        array506[1] = -12;
        array498[n2] = array505;
        d1015[0] = array498;
        final byte[][] array507 = new byte[n][];
        final byte[] array509;
        final byte[] array508 = array509 = new byte[al];
        array509[0] = -7;
        array509[1] = -12;
        array507[0] = array508;
        final byte[] array511;
        final byte[] array510 = array511 = new byte[al];
        array511[0] = -7;
        array511[1] = -12;
        array507[b] = array510;
        final byte[] array513;
        final byte[] array512 = array513 = new byte[al];
        array513[0] = -7;
        array513[1] = -12;
        array507[al] = array512;
        final byte[] array515;
        final byte[] array514 = array515 = new byte[al];
        array515[0] = -6;
        array515[1] = -12;
        array507[n2] = array514;
        d1015[b] = array507;
        final byte[][] array516 = new byte[n][];
        final byte[] array518;
        final byte[] array517 = array518 = new byte[al];
        array518[0] = -7;
        array518[1] = -13;
        array516[0] = array517;
        final byte[] array520;
        final byte[] array519 = array520 = new byte[al];
        array520[0] = -7;
        array520[1] = -13;
        array516[b] = array519;
        final byte[] array522;
        final byte[] array521 = array522 = new byte[al];
        array522[0] = -7;
        array522[1] = -13;
        array516[al] = array521;
        final byte[] array524;
        final byte[] array523 = array524 = new byte[al];
        array524[0] = -6;
        array524[1] = -13;
        array516[n2] = array523;
        d1015[al] = array516;
        final byte[][] array525 = new byte[n][];
        final byte[] array527;
        final byte[] array526 = array527 = new byte[al];
        array527[0] = -8;
        array527[1] = -13;
        array525[0] = array526;
        final byte[] array529;
        final byte[] array528 = array529 = new byte[al];
        array529[0] = -8;
        array529[1] = -13;
        array525[b] = array528;
        final byte[] array531;
        final byte[] array530 = array531 = new byte[al];
        array531[0] = -8;
        array531[1] = -13;
        array525[al] = array530;
        final byte[] array533;
        final byte[] array532 = array533 = new byte[al];
        array533[0] = -8;
        array533[1] = -13;
        array525[n2] = array532;
        d1015[n2] = array525;
        final byte[][] array534 = new byte[n][];
        final byte[] array536;
        final byte[] array535 = array536 = new byte[al];
        array536[0] = -9;
        array536[1] = -12;
        array534[0] = array535;
        final byte[] array538;
        final byte[] array537 = array538 = new byte[al];
        array538[0] = -7;
        array538[1] = -12;
        array534[b] = array537;
        final byte[] array540;
        final byte[] array539 = array540 = new byte[al];
        array540[0] = -7;
        array540[1] = -12;
        array534[al] = array539;
        final byte[] array542;
        final byte[] array541 = array542 = new byte[al];
        array542[0] = -9;
        array542[1] = -12;
        array534[n2] = array541;
        d1015[n] = array534;
        final byte[][] array543 = new byte[n][];
        final byte[] array545;
        final byte[] array544 = array545 = new byte[al];
        array545[0] = -9;
        array545[1] = -13;
        array543[0] = array544;
        final byte[] array547;
        final byte[] array546 = array547 = new byte[al];
        array547[0] = -8;
        array547[1] = -13;
        array543[b] = array546;
        final byte[] array549;
        final byte[] array548 = array549 = new byte[al];
        array549[0] = -8;
        array549[1] = -13;
        array543[al] = array548;
        final byte[] array551;
        final byte[] array550 = array551 = new byte[al];
        array551[0] = -9;
        array551[1] = -13;
        array543[n2] = array550;
        d1015[5] = array543;
        final byte[][] array552 = new byte[n][];
        final byte[] array554;
        final byte[] array553 = array554 = new byte[al];
        array554[0] = -8;
        array554[1] = -20;
        array552[0] = array553;
        final byte[] array556;
        final byte[] array555 = array556 = new byte[al];
        array556[0] = -13;
        array556[1] = -20;
        array552[b] = array555;
        final byte[] array558;
        final byte[] array557 = array558 = new byte[al];
        array558[0] = -9;
        array558[1] = -20;
        array552[al] = array557;
        final byte[] array560;
        final byte[] array559 = array560 = new byte[al];
        array560[0] = -11;
        array560[1] = -20;
        array552[n2] = array559;
        d1015[6] = array552;
        final byte[][] array561 = new byte[n][];
        final byte[] array563;
        final byte[] array562 = array563 = new byte[al];
        array563[0] = -8;
        array563[1] = -20;
        array561[0] = array562;
        final byte[] array565;
        final byte[] array564 = array565 = new byte[al];
        array565[0] = -13;
        array565[1] = -20;
        array561[b] = array564;
        final byte[] array567;
        final byte[] array566 = array567 = new byte[al];
        array567[0] = -9;
        array567[1] = -20;
        array561[al] = array566;
        final byte[] array569;
        final byte[] array568 = array569 = new byte[al];
        array569[0] = -11;
        array569[1] = -20;
        array561[n2] = array568;
        d1015[7] = array561;
        final byte[][] array570 = new byte[n][];
        final byte[] array572;
        final byte[] array571 = array572 = new byte[al];
        array572[0] = -9;
        array572[1] = -13;
        array570[0] = array571;
        final byte[] array574;
        final byte[] array573 = array574 = new byte[al];
        array574[0] = -9;
        array574[1] = -13;
        array570[b] = array573;
        final byte[] array576;
        final byte[] array575 = array576 = new byte[al];
        array576[0] = -11;
        array576[1] = -13;
        array570[al] = array575;
        final byte[] array578;
        final byte[] array577 = array578 = new byte[al];
        array578[0] = -8;
        array578[1] = -13;
        array570[n2] = array577;
        d1015[8] = array570;
        final byte[][] array579 = new byte[n][];
        final byte[] array581;
        final byte[] array580 = array581 = new byte[al];
        array581[0] = -9;
        array581[1] = -13;
        array579[0] = array580;
        final byte[] array583;
        final byte[] array582 = array583 = new byte[al];
        array583[0] = -9;
        array583[1] = -13;
        array579[b] = array582;
        final byte[] array585;
        final byte[] array584 = array585 = new byte[al];
        array585[0] = -11;
        array585[1] = -13;
        array579[al] = array584;
        final byte[] array587;
        final byte[] array586 = array587 = new byte[al];
        array587[0] = -8;
        array587[1] = -13;
        array579[n2] = array586;
        d1015[9] = array579;
        final byte[][] array588 = new byte[n][];
        final byte[] array590;
        final byte[] array589 = array590 = new byte[al];
        array590[0] = -8;
        array590[1] = -14;
        array588[0] = array589;
        final byte[] array592;
        final byte[] array591 = array592 = new byte[al];
        array592[0] = -8;
        array592[1] = -14;
        array588[b] = array591;
        final byte[] array594;
        final byte[] array593 = array594 = new byte[al];
        array594[0] = -6;
        array594[1] = -14;
        array588[al] = array593;
        final byte[] array596;
        final byte[] array595 = array596 = new byte[al];
        array596[0] = -8;
        array596[1] = -14;
        array588[n2] = array595;
        d1015[10] = array588;
        final byte[][] array597 = new byte[n][];
        final byte[] array599;
        final byte[] array598 = array599 = new byte[al];
        array599[0] = -10;
        array599[1] = -16;
        array597[0] = array598;
        final byte[] array601;
        final byte[] array600 = array601 = new byte[al];
        array601[0] = -8;
        array601[1] = -16;
        array597[b] = array600;
        final byte[] array603;
        final byte[] array602 = array603 = new byte[al];
        array603[0] = -6;
        array603[1] = -16;
        array597[al] = array602;
        final byte[] array605;
        final byte[] array604 = array605 = new byte[al];
        array605[0] = -8;
        array605[1] = -16;
        array597[n2] = array604;
        d1015[11] = array597;
        this.d1091 = d1015;
        final short[][][][] a1019 = new short[12][][][];
        final short[][][] array606 = new short[n][][];
        final short[][] array607 = new short[n2][];
        final short[] array609;
        final short[] array608 = array609 = new short[al];
        array609[0] = 0;
        array609[1] = 13;
        array607[0] = array608;
        final short[] array611;
        final short[] array610 = array611 = new short[al];
        array611[1] = (array611[0] = 13);
        array607[b] = array610;
        final short[] array613;
        final short[] array612 = array613 = new short[al];
        array613[0] = 26;
        array613[1] = 13;
        array607[al] = array612;
        array606[0] = array607;
        final short[][] array614 = new short[n2][];
        final short[] array616;
        final short[] array615 = array616 = new short[al];
        array616[0] = 39;
        array616[1] = 13;
        array614[0] = array615;
        final short[] array618;
        final short[] array617 = array618 = new short[al];
        array618[0] = 52;
        array618[1] = 13;
        array614[b] = array617;
        final short[] array620;
        final short[] array619 = array620 = new short[al];
        array620[0] = 65;
        array620[1] = 13;
        array614[al] = array619;
        array606[b] = array614;
        final short[][] array621 = new short[n2][];
        final short[] array623;
        final short[] array622 = array623 = new short[al];
        array623[0] = 78;
        array623[1] = 13;
        array621[0] = array622;
        final short[] array625;
        final short[] array624 = array625 = new short[al];
        array625[0] = 91;
        array625[1] = 13;
        array621[b] = array624;
        final short[] array627;
        final short[] array626 = array627 = new short[al];
        array627[0] = 104;
        array627[1] = 13;
        array621[al] = array626;
        array606[al] = array621;
        final short[][] array628 = new short[n2][];
        final short[] array630;
        final short[] array629 = array630 = new short[al];
        array630[0] = 65;
        array630[1] = 13;
        array628[0] = array629;
        final short[] array632;
        final short[] array631 = array632 = new short[al];
        array632[0] = 52;
        array632[1] = 13;
        array628[b] = array631;
        final short[] array634;
        final short[] array633 = array634 = new short[al];
        array634[0] = 39;
        array634[1] = 13;
        array628[al] = array633;
        array606[n2] = array628;
        a1019[0] = array606;
        final short[][][] array635 = new short[n][][];
        final short[][] array636 = new short[n2][];
        final short[] array638;
        final short[] array637 = array638 = new short[al];
        array638[0] = 0;
        array638[1] = 13;
        array636[0] = array637;
        final short[] array640;
        final short[] array639 = array640 = new short[al];
        array640[1] = (array640[0] = 13);
        array636[b] = array639;
        final short[] array642;
        final short[] array641 = array642 = new short[al];
        array642[0] = 26;
        array642[1] = 13;
        array636[al] = array641;
        array635[0] = array636;
        final short[][] array643 = new short[n2][];
        final short[] array645;
        final short[] array644 = array645 = new short[al];
        array645[0] = 39;
        array645[1] = 13;
        array643[0] = array644;
        final short[] array647;
        final short[] array646 = array647 = new short[al];
        array647[0] = 52;
        array647[1] = 13;
        array643[b] = array646;
        final short[] array649;
        final short[] array648 = array649 = new short[al];
        array649[0] = 65;
        array649[1] = 13;
        array643[al] = array648;
        array635[b] = array643;
        final short[][] array650 = new short[n2][];
        final short[] array652;
        final short[] array651 = array652 = new short[al];
        array652[0] = 78;
        array652[1] = 13;
        array650[0] = array651;
        final short[] array654;
        final short[] array653 = array654 = new short[al];
        array654[0] = 91;
        array654[1] = 13;
        array650[b] = array653;
        final short[] array656;
        final short[] array655 = array656 = new short[al];
        array656[0] = 104;
        array656[1] = 13;
        array650[al] = array655;
        array635[al] = array650;
        final short[][] array657 = new short[n2][];
        final short[] array659;
        final short[] array658 = array659 = new short[al];
        array659[0] = 65;
        array659[1] = 13;
        array657[0] = array658;
        final short[] array661;
        final short[] array660 = array661 = new short[al];
        array661[0] = 52;
        array661[1] = 13;
        array657[b] = array660;
        final short[] array663;
        final short[] array662 = array663 = new short[al];
        array663[0] = 39;
        array663[1] = 13;
        array657[al] = array662;
        array635[n2] = array657;
        a1019[b] = array635;
        final short[][][] array664 = new short[n][][];
        final short[][] array665 = new short[n2][];
        final short[] array667;
        final short[] array666 = array667 = new short[al];
        array667[0] = 0;
        array667[1] = 13;
        array665[0] = array666;
        final short[] array669;
        final short[] array668 = array669 = new short[al];
        array669[1] = (array669[0] = 13);
        array665[b] = array668;
        final short[] array671;
        final short[] array670 = array671 = new short[al];
        array671[0] = 26;
        array671[1] = 13;
        array665[al] = array670;
        array664[0] = array665;
        final short[][] array672 = new short[n2][];
        final short[] array674;
        final short[] array673 = array674 = new short[al];
        array674[0] = 39;
        array674[1] = 13;
        array672[0] = array673;
        final short[] array676;
        final short[] array675 = array676 = new short[al];
        array676[0] = 52;
        array676[1] = 13;
        array672[b] = array675;
        final short[] array678;
        final short[] array677 = array678 = new short[al];
        array678[0] = 65;
        array678[1] = 13;
        array672[al] = array677;
        array664[b] = array672;
        final short[][] array679 = new short[n2][];
        final short[] array681;
        final short[] array680 = array681 = new short[al];
        array681[0] = 78;
        array681[1] = 13;
        array679[0] = array680;
        final short[] array683;
        final short[] array682 = array683 = new short[al];
        array683[0] = 91;
        array683[1] = 13;
        array679[b] = array682;
        final short[] array685;
        final short[] array684 = array685 = new short[al];
        array685[0] = 104;
        array685[1] = 13;
        array679[al] = array684;
        array664[al] = array679;
        final short[][] array686 = new short[n2][];
        final short[] array688;
        final short[] array687 = array688 = new short[al];
        array688[0] = 65;
        array688[1] = 13;
        array686[0] = array687;
        final short[] array690;
        final short[] array689 = array690 = new short[al];
        array690[0] = 52;
        array690[1] = 13;
        array686[b] = array689;
        final short[] array692;
        final short[] array691 = array692 = new short[al];
        array692[0] = 39;
        array692[1] = 13;
        array686[al] = array691;
        array664[n2] = array686;
        a1019[al] = array664;
        final short[][][] array693 = new short[n][][];
        final short[][] array694 = new short[n2][];
        final short[] array696;
        final short[] array695 = array696 = new short[al];
        array696[0] = 0;
        array696[1] = 16;
        array694[0] = array695;
        final short[] array698;
        final short[] array697 = array698 = new short[al];
        array698[1] = (array698[0] = 16);
        array694[b] = array697;
        final short[] array700;
        final short[] array699 = array700 = new short[al];
        array700[0] = 32;
        array700[1] = 16;
        array694[al] = array699;
        array693[0] = array694;
        final short[][] array701 = new short[n2][];
        final short[] array703;
        final short[] array702 = array703 = new short[al];
        array703[0] = 48;
        array703[1] = 16;
        array701[0] = array702;
        final short[] array705;
        final short[] array704 = array705 = new short[al];
        array705[0] = 64;
        array705[1] = 16;
        array701[b] = array704;
        final short[] array707;
        final short[] array706 = array707 = new short[al];
        array707[0] = 80;
        array707[1] = 16;
        array701[al] = array706;
        array693[b] = array701;
        final short[][] array708 = new short[n2][];
        final short[] array710;
        final short[] array709 = array710 = new short[al];
        array710[0] = 96;
        array710[1] = 16;
        array708[0] = array709;
        final short[] array712;
        final short[] array711 = array712 = new short[al];
        array712[0] = 112;
        array712[1] = 16;
        array708[b] = array711;
        final short[] array714;
        final short[] array713 = array714 = new short[al];
        array714[0] = 128;
        array714[1] = 16;
        array708[al] = array713;
        array693[al] = array708;
        final short[][] array715 = new short[n2][];
        final short[] array717;
        final short[] array716 = array717 = new short[al];
        array717[0] = 80;
        array717[1] = 16;
        array715[0] = array716;
        final short[] array719;
        final short[] array718 = array719 = new short[al];
        array719[0] = 64;
        array719[1] = 16;
        array715[b] = array718;
        final short[] array721;
        final short[] array720 = array721 = new short[al];
        array721[0] = 48;
        array721[1] = 16;
        array715[al] = array720;
        array693[n2] = array715;
        a1019[n2] = array693;
        final short[][][] array722 = new short[n][][];
        final short[][] array723 = new short[n2][];
        final short[] array725;
        final short[] array724 = array725 = new short[al];
        array725[0] = 0;
        array725[1] = 16;
        array723[0] = array724;
        final short[] array727;
        final short[] array726 = array727 = new short[al];
        array727[1] = (array727[0] = 16);
        array723[b] = array726;
        final short[] array729;
        final short[] array728 = array729 = new short[al];
        array729[0] = 32;
        array729[1] = 16;
        array723[al] = array728;
        array722[0] = array723;
        final short[][] array730 = new short[n2][];
        final short[] array732;
        final short[] array731 = array732 = new short[al];
        array732[0] = 48;
        array732[1] = 16;
        array730[0] = array731;
        final short[] array734;
        final short[] array733 = array734 = new short[al];
        array734[0] = 64;
        array734[1] = 16;
        array730[b] = array733;
        final short[] array736;
        final short[] array735 = array736 = new short[al];
        array736[0] = 80;
        array736[1] = 16;
        array730[al] = array735;
        array722[b] = array730;
        final short[][] array737 = new short[n2][];
        final short[] array739;
        final short[] array738 = array739 = new short[al];
        array739[0] = 96;
        array739[1] = 16;
        array737[0] = array738;
        final short[] array741;
        final short[] array740 = array741 = new short[al];
        array741[0] = 112;
        array741[1] = 16;
        array737[b] = array740;
        final short[] array743;
        final short[] array742 = array743 = new short[al];
        array743[0] = 128;
        array743[1] = 16;
        array737[al] = array742;
        array722[al] = array737;
        final short[][] array744 = new short[n2][];
        final short[] array746;
        final short[] array745 = array746 = new short[al];
        array746[0] = 80;
        array746[1] = 16;
        array744[0] = array745;
        final short[] array748;
        final short[] array747 = array748 = new short[al];
        array748[0] = 64;
        array748[1] = 16;
        array744[b] = array747;
        final short[] array750;
        final short[] array749 = array750 = new short[al];
        array750[0] = 48;
        array750[1] = 16;
        array744[al] = array749;
        array722[n2] = array744;
        a1019[n] = array722;
        final short[][][] array751 = new short[n][][];
        final short[][] array752 = new short[n2][];
        final short[] array754;
        final short[] array753 = array754 = new short[al];
        array754[0] = 0;
        array754[1] = 16;
        array752[0] = array753;
        final short[] array756;
        final short[] array755 = array756 = new short[al];
        array756[1] = (array756[0] = 16);
        array752[b] = array755;
        final short[] array758;
        final short[] array757 = array758 = new short[al];
        array758[0] = 32;
        array758[1] = 16;
        array752[al] = array757;
        array751[0] = array752;
        final short[][] array759 = new short[n2][];
        final short[] array761;
        final short[] array760 = array761 = new short[al];
        array761[0] = 48;
        array761[1] = 17;
        array759[0] = array760;
        final short[] array763;
        final short[] array762 = array763 = new short[al];
        array763[0] = 65;
        array763[1] = 17;
        array759[b] = array762;
        final short[] array765;
        final short[] array764 = array765 = new short[al];
        array765[0] = 82;
        array765[1] = 17;
        array759[al] = array764;
        array751[b] = array759;
        final short[][] array766 = new short[n2][];
        final short[] array768;
        final short[] array767 = array768 = new short[al];
        array768[0] = 99;
        array768[1] = 17;
        array766[0] = array767;
        final short[] array770;
        final short[] array769 = array770 = new short[al];
        array770[0] = 116;
        array770[1] = 17;
        array766[b] = array769;
        final short[] array772;
        final short[] array771 = array772 = new short[al];
        array772[0] = 133;
        array772[1] = 17;
        array766[al] = array771;
        array751[al] = array766;
        final short[][] array773 = new short[n2][];
        final short[] array775;
        final short[] array774 = array775 = new short[al];
        array775[0] = 85;
        array775[1] = 17;
        array773[0] = array774;
        final short[] array777;
        final short[] array776 = array777 = new short[al];
        array777[0] = 68;
        array777[1] = 17;
        array773[b] = array776;
        final short[] array779;
        final short[] array778 = array779 = new short[al];
        array779[0] = 51;
        array779[1] = 17;
        array773[al] = array778;
        array751[n2] = array773;
        a1019[5] = array751;
        final short[][][] array780 = new short[n][][];
        final short[][] array781 = new short[n2][];
        final short[] array783;
        final short[] array782 = array783 = new short[al];
        array783[0] = 0;
        array783[1] = 16;
        array781[0] = array782;
        final short[] array785;
        final short[] array784 = array785 = new short[al];
        array785[1] = (array785[0] = 16);
        array781[b] = array784;
        final short[] array787;
        final short[] array786 = array787 = new short[al];
        array787[0] = 32;
        array787[1] = 16;
        array781[al] = array786;
        array780[0] = array781;
        final short[][] array788 = new short[n2][];
        final short[] array790;
        final short[] array789 = array790 = new short[al];
        array790[0] = 48;
        array790[1] = 24;
        array788[0] = array789;
        final short[] array792;
        final short[] array791 = array792 = new short[al];
        array792[0] = 72;
        array792[1] = 24;
        array788[b] = array791;
        final short[] array794;
        final short[] array793 = array794 = new short[al];
        array794[0] = 96;
        array794[1] = 24;
        array788[al] = array793;
        array780[b] = array788;
        final short[][] array795 = new short[n2][];
        final short[] array797;
        final short[] array796 = array797 = new short[al];
        array797[0] = 120;
        array797[1] = 17;
        array795[0] = array796;
        final short[] array799;
        final short[] array798 = array799 = new short[al];
        array799[0] = 137;
        array799[1] = 17;
        array795[b] = array798;
        final short[] array801;
        final short[] array800 = array801 = new short[al];
        array801[0] = 154;
        array801[1] = 17;
        array795[al] = array800;
        array780[al] = array795;
        final short[][] array802 = new short[n2][];
        final short[] array804;
        final short[] array803 = array804 = new short[al];
        array804[0] = 99;
        array804[1] = 24;
        array802[0] = array803;
        final short[] array806;
        final short[] array805 = array806 = new short[al];
        array806[0] = 75;
        array806[1] = 24;
        array802[b] = array805;
        final short[] array808;
        final short[] array807 = array808 = new short[al];
        array808[0] = 51;
        array808[1] = 24;
        array802[al] = array807;
        array780[n2] = array802;
        a1019[6] = array780;
        final short[][][] array809 = new short[n][][];
        final short[][] array810 = new short[n2][];
        final short[] array812;
        final short[] array811 = array812 = new short[al];
        array812[0] = 0;
        array812[1] = 16;
        array810[0] = array811;
        final short[] array814;
        final short[] array813 = array814 = new short[al];
        array814[1] = (array814[0] = 16);
        array810[b] = array813;
        final short[] array816;
        final short[] array815 = array816 = new short[al];
        array816[0] = 32;
        array816[1] = 16;
        array810[al] = array815;
        array809[0] = array810;
        final short[][] array817 = new short[n2][];
        final short[] array819;
        final short[] array818 = array819 = new short[al];
        array819[0] = 48;
        array819[1] = 24;
        array817[0] = array818;
        final short[] array821;
        final short[] array820 = array821 = new short[al];
        array821[0] = 72;
        array821[1] = 24;
        array817[b] = array820;
        final short[] array823;
        final short[] array822 = array823 = new short[al];
        array823[0] = 96;
        array823[1] = 24;
        array817[al] = array822;
        array809[b] = array817;
        final short[][] array824 = new short[n2][];
        final short[] array826;
        final short[] array825 = array826 = new short[al];
        array826[0] = 120;
        array826[1] = 17;
        array824[0] = array825;
        final short[] array828;
        final short[] array827 = array828 = new short[al];
        array828[0] = 137;
        array828[1] = 17;
        array824[b] = array827;
        final short[] array830;
        final short[] array829 = array830 = new short[al];
        array830[0] = 154;
        array830[1] = 17;
        array824[al] = array829;
        array809[al] = array824;
        final short[][] array831 = new short[n2][];
        final short[] array833;
        final short[] array832 = array833 = new short[al];
        array833[0] = 99;
        array833[1] = 24;
        array831[0] = array832;
        final short[] array835;
        final short[] array834 = array835 = new short[al];
        array835[0] = 75;
        array835[1] = 24;
        array831[b] = array834;
        final short[] array837;
        final short[] array836 = array837 = new short[al];
        array837[0] = 51;
        array837[1] = 24;
        array831[al] = array836;
        array809[n2] = array831;
        a1019[7] = array809;
        final short[][][] array838 = new short[n][][];
        final short[][] array839 = new short[n2][];
        final short[] array841;
        final short[] array840 = array841 = new short[al];
        array841[0] = 0;
        array841[1] = 20;
        array839[0] = array840;
        final short[] array843;
        final short[] array842 = array843 = new short[al];
        array843[1] = (array843[0] = 20);
        array839[b] = array842;
        final short[] array845;
        final short[] array844 = array845 = new short[al];
        array845[0] = 40;
        array845[1] = 20;
        array839[al] = array844;
        array838[0] = array839;
        final short[][] array846 = new short[n2][];
        final short[] array848;
        final short[] array847 = array848 = new short[al];
        array848[0] = 60;
        array848[1] = 17;
        array846[0] = array847;
        final short[] array850;
        final short[] array849 = array850 = new short[al];
        array850[0] = 77;
        array850[1] = 17;
        array846[b] = array849;
        final short[] array852;
        final short[] array851 = array852 = new short[al];
        array852[0] = 94;
        array852[1] = 17;
        array846[al] = array851;
        array838[b] = array846;
        final short[][] array853 = new short[n2][];
        final short[] array855;
        final short[] array854 = array855 = new short[al];
        array855[0] = 111;
        array855[1] = 19;
        array853[0] = array854;
        final short[] array857;
        final short[] array856 = array857 = new short[al];
        array857[0] = 130;
        array857[1] = 19;
        array853[b] = array856;
        final short[] array859;
        final short[] array858 = array859 = new short[al];
        array859[0] = 149;
        array859[1] = 19;
        array853[al] = array858;
        array838[al] = array853;
        final short[][] array860 = new short[n2][];
        final short[] array862;
        final short[] array861 = array862 = new short[al];
        array862[0] = 91;
        array862[1] = 17;
        array860[0] = array861;
        final short[] array864;
        final short[] array863 = array864 = new short[al];
        array864[0] = 74;
        array864[1] = 17;
        array860[b] = array863;
        final short[] array866;
        final short[] array865 = array866 = new short[al];
        array866[0] = 57;
        array866[1] = 17;
        array860[al] = array865;
        array838[n2] = array860;
        a1019[8] = array838;
        final short[][][] array867 = new short[n][][];
        final short[][] array868 = new short[n2][];
        final short[] array870;
        final short[] array869 = array870 = new short[al];
        array870[0] = 0;
        array870[1] = 20;
        array868[0] = array869;
        final short[] array872;
        final short[] array871 = array872 = new short[al];
        array872[1] = (array872[0] = 20);
        array868[b] = array871;
        final short[] array874;
        final short[] array873 = array874 = new short[al];
        array874[0] = 40;
        array874[1] = 20;
        array868[al] = array873;
        array867[0] = array868;
        final short[][] array875 = new short[n2][];
        final short[] array877;
        final short[] array876 = array877 = new short[al];
        array877[0] = 60;
        array877[1] = 17;
        array875[0] = array876;
        final short[] array879;
        final short[] array878 = array879 = new short[al];
        array879[0] = 77;
        array879[1] = 17;
        array875[b] = array878;
        final short[] array881;
        final short[] array880 = array881 = new short[al];
        array881[0] = 94;
        array881[1] = 17;
        array875[al] = array880;
        array867[b] = array875;
        final short[][] array882 = new short[n2][];
        final short[] array884;
        final short[] array883 = array884 = new short[al];
        array884[0] = 111;
        array884[1] = 19;
        array882[0] = array883;
        final short[] array886;
        final short[] array885 = array886 = new short[al];
        array886[0] = 130;
        array886[1] = 19;
        array882[b] = array885;
        final short[] array888;
        final short[] array887 = array888 = new short[al];
        array888[0] = 149;
        array888[1] = 19;
        array882[al] = array887;
        array867[al] = array882;
        final short[][] array889 = new short[n2][];
        final short[] array891;
        final short[] array890 = array891 = new short[al];
        array891[0] = 91;
        array891[1] = 17;
        array889[0] = array890;
        final short[] array893;
        final short[] array892 = array893 = new short[al];
        array893[0] = 74;
        array893[1] = 17;
        array889[b] = array892;
        final short[] array895;
        final short[] array894 = array895 = new short[al];
        array895[0] = 57;
        array895[1] = 17;
        array889[al] = array894;
        array867[n2] = array889;
        a1019[9] = array867;
        final short[][][] array896 = new short[n][][];
        final short[][] array897 = new short[n2][];
        final short[] array899;
        final short[] array898 = array899 = new short[al];
        array899[0] = 0;
        array899[1] = 14;
        array897[0] = array898;
        final short[] array901;
        final short[] array900 = array901 = new short[al];
        array901[1] = (array901[0] = 14);
        array897[b] = array900;
        final short[] array903;
        final short[] array902 = array903 = new short[al];
        array903[0] = 28;
        array903[1] = 14;
        array897[al] = array902;
        array896[0] = array897;
        final short[][] array904 = new short[n2][];
        final short[] array906;
        final short[] array905 = array906 = new short[al];
        array906[0] = 42;
        array906[1] = 16;
        array904[0] = array905;
        final short[] array908;
        final short[] array907 = array908 = new short[al];
        array908[0] = 58;
        array908[1] = 16;
        array904[b] = array907;
        final short[] array910;
        final short[] array909 = array910 = new short[al];
        array910[0] = 74;
        array910[1] = 16;
        array904[al] = array909;
        array896[b] = array904;
        final short[][] array911 = new short[n2][];
        final short[] array913;
        final short[] array912 = array913 = new short[al];
        array913[0] = 90;
        array913[1] = 14;
        array911[0] = array912;
        final short[] array915;
        final short[] array914 = array915 = new short[al];
        array915[0] = 104;
        array915[1] = 14;
        array911[b] = array914;
        final short[] array917;
        final short[] array916 = array917 = new short[al];
        array917[0] = 118;
        array917[1] = 14;
        array911[al] = array916;
        array896[al] = array911;
        final short[][] array918 = new short[n2][];
        final short[] array920;
        final short[] array919 = array920 = new short[al];
        array920[0] = 74;
        array920[1] = 16;
        array918[0] = array919;
        final short[] array922;
        final short[] array921 = array922 = new short[al];
        array922[0] = 58;
        array922[1] = 16;
        array918[b] = array921;
        final short[] array924;
        final short[] array923 = array924 = new short[al];
        array924[0] = 42;
        array924[1] = 16;
        array918[al] = array923;
        array896[n2] = array918;
        a1019[10] = array896;
        final short[][][] array925 = new short[n][][];
        final short[][] array926 = new short[n2][];
        final short[] array928;
        final short[] array927 = array928 = new short[al];
        array928[0] = 0;
        array928[1] = 16;
        array926[0] = array927;
        final short[] array930;
        final short[] array929 = array930 = new short[al];
        array930[1] = (array930[0] = 16);
        array926[b] = array929;
        final short[] array932;
        final short[] array931 = array932 = new short[al];
        array932[0] = 32;
        array932[1] = 16;
        array926[al] = array931;
        array925[0] = array926;
        final short[][] array933 = new short[n2][];
        final short[] array935;
        final short[] array934 = array935 = new short[al];
        array935[0] = 48;
        array935[1] = 16;
        array933[0] = array934;
        final short[] array937;
        final short[] array936 = array937 = new short[al];
        array937[0] = 64;
        array937[1] = 16;
        array933[b] = array936;
        final short[] array939;
        final short[] array938 = array939 = new short[al];
        array939[0] = 80;
        array939[1] = 16;
        array933[al] = array938;
        array925[b] = array933;
        final short[][] array940 = new short[n2][];
        final short[] array942;
        final short[] array941 = array942 = new short[al];
        array942[0] = 96;
        array942[1] = 16;
        array940[0] = array941;
        final short[] array944;
        final short[] array943 = array944 = new short[al];
        array944[0] = 112;
        array944[1] = 16;
        array940[b] = array943;
        final short[] array946;
        final short[] array945 = array946 = new short[al];
        array946[0] = 128;
        array946[1] = 16;
        array940[al] = array945;
        array925[al] = array940;
        final short[][] array947 = new short[n2][];
        final short[] array949;
        final short[] array948 = array949 = new short[al];
        array949[0] = 80;
        array949[1] = 16;
        array947[0] = array948;
        final short[] array951;
        final short[] array950 = array951 = new short[al];
        array951[0] = 64;
        array951[1] = 16;
        array947[b] = array950;
        final short[] array953;
        final short[] array952 = array953 = new short[al];
        array953[0] = 48;
        array953[1] = 16;
        array947[al] = array952;
        array925[n2] = array947;
        a1019[11] = array925;
        this.a1092 = a1019;
        final byte[][][] e1056 = new byte[n][][];
        final byte[][] array954 = new byte[7][];
        final byte[] array956;
        final byte[] array955 = array956 = new byte[al];
        array956[0] = 1;
        array956[1] = 2;
        array954[0] = array955;
        final byte[] array958;
        final byte[] array957 = array958 = new byte[al];
        array958[0] = 9;
        array958[1] = 4;
        array954[b] = array957;
        final byte[] array960;
        final byte[] array959 = array960 = new byte[al];
        array960[0] = 17;
        array960[1] = 1;
        array954[al] = array959;
        final byte[] array962;
        final byte[] array961 = array962 = new byte[al];
        array962[0] = 1;
        array962[1] = 14;
        array954[n2] = array961;
        final byte[] array964;
        final byte[] array963 = array964 = new byte[al];
        array964[0] = 12;
        array964[1] = 13;
        array954[n] = array963;
        final byte[] array966;
        final byte[] array965 = array966 = new byte[al];
        array966[0] = 19;
        array966[1] = 13;
        array954[5] = array965;
        final byte[] array968;
        final byte[] array967 = array968 = new byte[al];
        array968[0] = 8;
        array968[1] = 19;
        array954[6] = array967;
        e1056[0] = array954;
        final byte[][] array969 = new byte[7][];
        final byte[] array971;
        final byte[] array970 = array971 = new byte[al];
        array971[0] = 0;
        array971[1] = 1;
        array969[0] = array970;
        final byte[] array973;
        final byte[] array972 = array973 = new byte[al];
        array973[0] = 8;
        array973[1] = 3;
        array969[b] = array972;
        final byte[] array975;
        final byte[] array974 = array975 = new byte[al];
        array975[0] = 18;
        array975[1] = -1;
        array969[al] = array974;
        final byte[] array977;
        final byte[] array976 = array977 = new byte[al];
        array977[0] = 0;
        array977[1] = 14;
        array969[n2] = array976;
        final byte[] array979;
        final byte[] array978 = array979 = new byte[al];
        array979[0] = 13;
        array979[1] = 15;
        array969[n] = array978;
        final byte[] array981;
        final byte[] array980 = array981 = new byte[al];
        array981[0] = 20;
        array981[1] = 13;
        array969[5] = array980;
        final byte[] array983;
        final byte[] array982 = array983 = new byte[al];
        array983[0] = 8;
        array983[1] = 20;
        array969[6] = array982;
        e1056[b] = array969;
        final byte[][] array984 = new byte[7][];
        final byte[] array986;
        final byte[] array985 = array986 = new byte[al];
        array986[0] = -1;
        array986[1] = 0;
        array984[0] = array985;
        final byte[] array988;
        final byte[] array987 = array988 = new byte[al];
        array988[0] = 8;
        array988[1] = 2;
        array984[b] = array987;
        final byte[] array990;
        final byte[] array989 = array990 = new byte[al];
        array990[0] = 18;
        array990[1] = -1;
        array984[al] = array989;
        final byte[] array992;
        final byte[] array991 = array992 = new byte[al];
        array992[0] = -1;
        array992[1] = 15;
        array984[n2] = array991;
        final byte[] array994;
        final byte[] array993 = array994 = new byte[al];
        array994[0] = 13;
        array994[1] = 15;
        array984[n] = array993;
        final byte[] array996;
        final byte[] array995 = array996 = new byte[al];
        array996[0] = 21;
        array996[1] = 14;
        array984[5] = array995;
        final byte[] array998;
        final byte[] array997 = array998 = new byte[al];
        array998[0] = 8;
        array998[1] = 21;
        array984[6] = array997;
        e1056[al] = array984;
        final byte[][] array999 = new byte[7][];
        final byte[] array1001;
        final byte[] array1000 = array1001 = new byte[al];
        array1001[0] = -1;
        array1001[1] = 0;
        array999[0] = array1000;
        final byte[] array1003;
        final byte[] array1002 = array1003 = new byte[al];
        array1003[0] = 8;
        array1003[1] = 2;
        array999[b] = array1002;
        final byte[] array1005;
        final byte[] array1004 = array1005 = new byte[al];
        array1005[0] = 18;
        array1005[1] = -1;
        array999[al] = array1004;
        final byte[] array1007;
        final byte[] array1006 = array1007 = new byte[al];
        array1007[0] = -1;
        array1007[1] = 15;
        array999[n2] = array1006;
        final byte[] array1009;
        final byte[] array1008 = array1009 = new byte[al];
        array1009[0] = 13;
        array1009[1] = 15;
        array999[n] = array1008;
        final byte[] array1011;
        final byte[] array1010 = array1011 = new byte[al];
        array1011[0] = 21;
        array1011[1] = 14;
        array999[5] = array1010;
        final byte[] array1013;
        final byte[] array1012 = array1013 = new byte[al];
        array1013[0] = 8;
        array1013[1] = 21;
        array999[6] = array1012;
        e1056[n2] = array999;
        this.e1093 = e1056;
        final byte[][] n4 = new byte[6][];
        final byte[] array1015;
        final byte[] array1014 = array1015 = new byte[6];
        array1015[1] = (array1015[0] = 0);
        array1015[2] = 17;
        array1015[3] = 6;
        array1015[4] = 0;
        array1015[5] = 17;
        n4[0] = array1014;
        final byte[] array1017;
        final byte[] array1016 = array1017 = new byte[6];
        array1017[0] = 0;
        array1017[1] = 6;
        array1017[2] = 17;
        array1017[3] = 7;
        array1017[4] = 0;
        array1017[5] = 16;
        n4[b] = array1016;
        final byte[] array1019;
        final byte[] array1018 = array1019 = new byte[6];
        array1019[0] = 0;
        array1019[1] = 13;
        array1019[2] = 17;
        array1019[3] = 10;
        array1019[4] = 0;
        array1019[5] = 12;
        n4[al] = array1018;
        final byte[] array1021;
        final byte[] array1020 = array1021 = new byte[6];
        array1021[0] = 0;
        array1021[1] = 23;
        array1021[2] = 17;
        array1021[3] = 12;
        array1021[4] = 0;
        array1021[5] = 5;
        n4[n2] = array1020;
        final byte[] array1023;
        final byte[] array1022 = array1023 = new byte[6];
        array1023[0] = 0;
        array1023[1] = 34;
        array1023[2] = 17;
        array1023[3] = 9;
        array1023[5] = (array1023[4] = 0);
        n4[n] = array1022;
        final byte[] array1025;
        final byte[] array1024 = array1025 = new byte[6];
        array1025[0] = 0;
        array1025[1] = 43;
        array1025[2] = 17;
        array1025[3] = 7;
        array1025[5] = (array1025[4] = 0);
        n4[5] = array1024;
        this.n1094 = n4;
        final byte[][] o1095 = new byte[8][];
        final byte[] array1027;
        final byte[] array1026 = array1027 = new byte[5];
        array1027[0] = 19;
        array1027[1] = 15;
        array1027[2] = 6;
        array1027[3] = -9;
        array1027[4] = -5;
        o1095[0] = array1026;
        final byte[] array1029;
        final byte[] array1028 = array1029 = new byte[5];
        array1029[0] = 19;
        array1029[1] = 15;
        array1029[2] = 6;
        array1029[3] = -9;
        array1029[4] = -5;
        o1095[b] = array1028;
        final byte[] array1031;
        final byte[] array1030 = array1031 = new byte[5];
        array1031[0] = 19;
        array1031[1] = 15;
        array1031[2] = 6;
        array1031[3] = -9;
        array1031[4] = -5;
        o1095[al] = array1030;
        final byte[] array1033;
        final byte[] array1032 = array1033 = new byte[5];
        array1033[0] = 19;
        array1033[1] = 21;
        array1033[2] = 4;
        array1033[3] = -9;
        array1033[4] = -11;
        o1095[n2] = array1032;
        final byte[] array1035;
        final byte[] array1034 = array1035 = new byte[5];
        array1035[0] = 19;
        array1035[1] = 21;
        array1035[2] = 4;
        array1035[3] = -9;
        array1035[4] = -11;
        o1095[n] = array1034;
        final byte[] array1037;
        final byte[] array1036 = array1037 = new byte[5];
        array1037[1] = (array1037[0] = 20);
        array1037[2] = 7;
        array1037[4] = (array1037[3] = -11);
        o1095[5] = array1036;
        final byte[] array1039;
        final byte[] array1038 = array1039 = new byte[5];
        array1039[0] = 19;
        array1039[1] = 15;
        array1039[2] = 4;
        array1039[3] = -9;
        array1039[4] = -5;
        o1095[6] = array1038;
        final byte[] array1041;
        final byte[] array1040 = array1041 = new byte[5];
        array1041[1] = (array1041[0] = 20);
        array1041[2] = 7;
        array1041[4] = (array1041[3] = -11);
        o1095[7] = array1040;
        this.o1095 = o1095;
        final byte[] array1042;
        final byte[] o1096 = array1042 = new byte[11];
        array1042[1] = (array1042[0] = 2);
        array1042[2] = 3;
        array1042[4] = (array1042[3] = 2);
        array1042[6] = (array1042[5] = 3);
        array1042[8] = (array1042[7] = 3);
        array1042[10] = (array1042[9] = 3);
        this.o1098 = o1096;
        final byte[] array1043;
        final byte[] p1099 = array1043 = new byte[11];
        array1043[1] = (array1043[0] = 0);
        array1043[2] = 1;
        array1043[3] = 0;
        array1043[5] = (array1043[4] = 0);
        array1043[6] = 1;
        array1043[7] = 0;
        array1043[8] = 1;
        array1043[10] = (array1043[9] = 1);
        this.p1099 = p1099;
        final byte[] array1044;
        final byte[] q1100 = array1044 = new byte[11];
        array1044[0] = 20;
        array1044[1] = 30;
        array1044[2] = 40;
        array1044[3] = 50;
        array1044[4] = 40;
        array1044[5] = 80;
        array1044[6] = 40;
        array1044[7] = 50;
        array1044[8] = 60;
        array1044[9] = 80;
        array1044[10] = 30;
        this.q1100 = q1100;
        final byte[] array1045;
        final byte[] r1101 = array1045 = new byte[22];
        array1045[0] = 10;
        array1045[1] = 2;
        array1045[2] = 15;
        array1045[3] = 3;
        array1045[4] = 20;
        array1045[5] = 4;
        array1045[6] = 20;
        array1045[7] = 5;
        array1045[8] = 10;
        array1045[9] = 5;
        array1045[10] = 30;
        array1045[11] = 5;
        array1045[12] = 10;
        array1045[13] = 5;
        array1045[14] = 20;
        array1045[15] = 5;
        array1045[16] = 20;
        array1045[17] = 5;
        array1045[18] = 30;
        array1045[19] = 5;
        array1045[20] = 20;
        array1045[21] = 5;
        this.r1101 = r1101;
        final byte[] array1046;
        final byte[] s1102 = array1046 = new byte[22];
        array1046[0] = 15;
        array1046[1] = 5;
        array1046[2] = 10;
        array1046[3] = 3;
        array1046[4] = 30;
        array1046[5] = 10;
        array1046[6] = 15;
        array1046[7] = 5;
        array1046[8] = 15;
        array1046[9] = 5;
        array1046[10] = 60;
        array1046[11] = 10;
        array1046[12] = 20;
        array1046[13] = 10;
        array1046[14] = 30;
        array1046[15] = 10;
        array1046[16] = 40;
        array1046[17] = 8;
        array1046[18] = 60;
        array1046[19] = 15;
        array1046[20] = 50;
        array1046[21] = 10;
        this.s1102 = s1102;
        final byte[] array1047;
        final byte[] t1103 = array1047 = new byte[22];
        array1047[0] = 64;
        array1047[1] = 8;
        array1047[2] = 48;
        array1047[3] = 4;
        array1047[5] = (array1047[4] = 0);
        array1047[6] = 64;
        array1047[7] = 6;
        array1047[8] = 56;
        array1047[9] = 6;
        array1047[10] = 64;
        array1047[11] = 8;
        array1047[13] = (array1047[12] = 0);
        array1047[14] = 48;
        array1047[15] = 8;
        array1047[16] = 64;
        array1047[17] = 4;
        array1047[18] = 64;
        array1047[19] = 4;
        array1047[21] = (array1047[20] = 0);
        this.t1103 = t1103;
        final byte[] array1048;
        final byte[] u1104 = array1048 = new byte[22];
        array1048[0] = 20;
        array1048[1] = -2;
        array1048[2] = 30;
        array1048[3] = -3;
        array1048[4] = 60;
        array1048[5] = -4;
        array1048[6] = 25;
        array1048[7] = -2;
        array1048[8] = 30;
        array1048[9] = -2;
        array1048[10] = 30;
        array1048[11] = -2;
        array1048[12] = 60;
        array1048[13] = -4;
        array1048[14] = 30;
        array1048[15] = -2;
        array1048[16] = 80;
        array1048[17] = -6;
        array1048[18] = 100;
        array1048[19] = -5;
        array1048[21] = (array1048[20] = 0);
        this.u1104 = u1104;
        this.e1105 = new boolean[11];
        this.f1106 = new boolean[11];
        this.c1107 = (int[][])Array.newInstance(Integer.TYPE, 30, 18);
        final byte[][] p1100 = new byte[5][];
        final byte[] array1050;
        final byte[] array1049 = array1050 = new byte[14];
        array1050[0] = -26;
        array1050[1] = -25;
        array1050[2] = -8;
        array1050[3] = -20;
        array1050[4] = -26;
        array1050[5] = 2;
        array1050[6] = 11;
        array1050[7] = -29;
        array1050[8] = 1;
        array1050[9] = 2;
        array1050[10] = 17;
        array1050[11] = 0;
        array1050[12] = -10;
        array1050[13] = 14;
        p1100[0] = array1049;
        final byte[] array1052;
        final byte[] array1051 = array1052 = new byte[14];
        array1052[0] = -30;
        array1052[1] = -29;
        array1052[2] = -9;
        array1052[3] = -24;
        array1052[4] = -29;
        array1052[5] = 4;
        array1052[6] = 14;
        array1052[7] = -32;
        array1052[8] = 2;
        array1052[9] = 6;
        array1052[10] = 20;
        array1052[11] = 2;
        array1052[12] = -10;
        array1052[13] = 19;
        p1100[b] = array1051;
        final byte[] array1054;
        final byte[] array1053 = array1054 = new byte[14];
        array1054[0] = -33;
        array1054[1] = -31;
        array1054[2] = -10;
        array1054[3] = -26;
        array1054[4] = -32;
        array1054[5] = 6;
        array1054[6] = 16;
        array1054[7] = -34;
        array1054[8] = 3;
        array1054[9] = 8;
        array1054[10] = 22;
        array1054[11] = 4;
        array1054[12] = -10;
        array1054[13] = 22;
        p1100[al] = array1053;
        final byte[] array1056;
        final byte[] array1055 = array1056 = new byte[14];
        array1056[0] = -34;
        array1056[1] = -32;
        array1056[2] = -11;
        array1056[3] = -27;
        array1056[4] = -33;
        array1056[5] = 7;
        array1056[6] = 17;
        array1056[7] = -35;
        array1056[8] = 4;
        array1056[9] = 9;
        array1056[10] = 23;
        array1056[11] = 5;
        array1056[12] = -10;
        array1056[13] = 23;
        p1100[n2] = array1055;
        final byte[] array1058;
        final byte[] array1057 = array1058 = new byte[14];
        array1058[0] = -34;
        array1058[1] = -32;
        array1058[2] = -11;
        array1058[3] = -27;
        array1058[4] = -33;
        array1058[5] = 7;
        array1058[6] = 17;
        array1058[7] = -35;
        array1058[8] = 4;
        array1058[9] = 9;
        array1058[10] = 23;
        array1058[11] = 5;
        array1058[12] = -10;
        array1058[13] = 23;
        p1100[n] = array1057;
        this.p1108 = p1100;
        final byte[] array1059;
        final byte[] v1109 = array1059 = new byte[5];
        array1059[0] = 6;
        array1059[1] = 4;
        array1059[2] = 3;
        array1059[3] = 2;
        array1059[4] = 1;
        this.v1109 = v1109;
        final byte[] array1060;
        final byte[] w1110 = array1060 = new byte[8];
        array1060[0] = -13;
        array1060[1] = -43;
        array1060[2] = -24;
        array1060[3] = -32;
        array1060[4] = -4;
        array1060[5] = -32;
        array1060[6] = -13;
        array1060[7] = -22;
        this.w1110 = w1110;
        final byte[][][] f4 = new byte[11][][];
        final byte[][] array1061 = new byte[n][];
        final byte[] array1063;
        final byte[] array1062 = array1063 = new byte[n];
        array1063[1] = (array1063[0] = 0);
        array1063[2] = 26;
        array1063[3] = 24;
        array1061[0] = array1062;
        final byte[] array1065;
        final byte[] array1064 = array1065 = new byte[n];
        array1065[0] = 26;
        array1065[1] = 0;
        array1065[2] = 22;
        array1065[3] = 16;
        array1061[b] = array1064;
        final byte[] array1067;
        final byte[] array1066 = array1067 = new byte[n];
        array1067[0] = 0;
        array1067[1] = 24;
        array1067[2] = 32;
        array1067[3] = 26;
        array1061[al] = array1066;
        final byte[] array1069;
        final byte[] array1068 = array1069 = new byte[n];
        array1069[0] = 32;
        array1069[1] = 16;
        array1069[2] = 32;
        array1069[3] = 34;
        array1061[n2] = array1068;
        f4[0] = array1061;
        final byte[][] array1070 = new byte[n][];
        final byte[] array1072;
        final byte[] array1071 = array1072 = new byte[n];
        array1072[1] = (array1072[0] = 0);
        array1072[3] = (array1072[2] = 24);
        array1070[0] = array1071;
        final byte[] array1074;
        final byte[] array1073 = array1074 = new byte[n];
        array1074[0] = 0;
        array1074[1] = 24;
        array1074[2] = 30;
        array1074[3] = 27;
        array1070[b] = array1073;
        final byte[] array1076;
        final byte[] array1075 = array1076 = new byte[n];
        array1076[0] = 24;
        array1076[1] = 0;
        array1076[2] = 22;
        array1076[3] = 16;
        array1070[al] = array1075;
        final byte[] array1078;
        final byte[] array1077 = array1078 = new byte[n];
        array1078[0] = 30;
        array1078[1] = 16;
        array1078[2] = 32;
        array1078[3] = 33;
        array1070[n2] = array1077;
        f4[b] = array1070;
        final byte[][] array1079 = new byte[5][];
        final byte[] array1081;
        final byte[] array1080 = array1081 = new byte[n];
        array1081[1] = (array1081[0] = 0);
        array1081[2] = 28;
        array1081[3] = 16;
        array1079[0] = array1080;
        final byte[] array1083;
        final byte[] array1082 = array1083 = new byte[n];
        array1083[0] = 28;
        array1083[1] = 0;
        array1083[2] = 20;
        array1083[3] = 15;
        array1079[b] = array1082;
        final byte[] array1085;
        final byte[] array1084 = array1085 = new byte[n];
        array1085[0] = 0;
        array1085[1] = 16;
        array1085[2] = 28;
        array1085[3] = 12;
        array1079[al] = array1084;
        final byte[] array1087;
        final byte[] array1086 = array1087 = new byte[n];
        array1087[0] = 0;
        array1087[2] = (array1087[1] = 28);
        array1087[3] = 22;
        array1079[n2] = array1086;
        final byte[] array1089;
        final byte[] array1088 = array1089 = new byte[n];
        array1089[0] = 28;
        array1089[1] = 26;
        array1089[2] = 32;
        array1089[3] = 24;
        array1079[n] = array1088;
        f4[al] = array1079;
        final byte[][] array1090 = new byte[n2][];
        final byte[] array1092;
        final byte[] array1091 = array1092 = new byte[n];
        array1092[1] = (array1092[0] = 0);
        array1092[2] = 22;
        array1092[3] = 32;
        array1090[0] = array1091;
        final byte[] array1094;
        final byte[] array1093 = array1094 = new byte[n];
        array1094[0] = 22;
        array1094[1] = 0;
        array1094[2] = 32;
        array1094[3] = 41;
        array1090[b] = array1093;
        final byte[] array1096;
        final byte[] array1095 = array1096 = new byte[n];
        array1096[0] = 54;
        array1096[1] = 0;
        array1096[2] = 32;
        array1096[3] = 35;
        array1090[al] = array1095;
        f4[n2] = array1090;
        final byte[][] array1097 = new byte[5][];
        final byte[] array1099;
        final byte[] array1098 = array1099 = new byte[n];
        array1099[1] = (array1099[0] = 0);
        array1099[2] = 18;
        array1099[3] = 16;
        array1097[0] = array1098;
        final byte[] array1101;
        final byte[] array1100 = array1101 = new byte[n];
        array1101[0] = 0;
        array1101[1] = 16;
        array1101[2] = 26;
        array1101[3] = 20;
        array1097[b] = array1100;
        final byte[] array1103;
        final byte[] array1102 = array1103 = new byte[n];
        array1103[0] = 0;
        array1103[1] = 36;
        array1103[2] = 32;
        array1103[3] = 11;
        array1097[al] = array1102;
        final byte[] array1105;
        final byte[] array1104 = array1105 = new byte[n];
        array1105[0] = 0;
        array1105[1] = 47;
        array1105[2] = 32;
        array1105[3] = 13;
        array1097[n2] = array1104;
        final byte[] array1107;
        final byte[] array1106 = array1107 = new byte[n];
        array1107[0] = 0;
        array1107[1] = 60;
        array1107[2] = 32;
        array1107[3] = 24;
        array1097[n] = array1106;
        f4[n] = array1097;
        final byte[][] array1108 = new byte[n2][];
        final byte[] array1110;
        final byte[] array1109 = array1110 = new byte[n];
        array1110[1] = (array1110[0] = 0);
        array1110[2] = 36;
        array1110[3] = 34;
        array1108[0] = array1109;
        final byte[] array1112;
        final byte[] array1111 = array1112 = new byte[n];
        array1112[0] = 36;
        array1112[1] = 0;
        array1112[2] = 42;
        array1112[3] = 39;
        array1108[b] = array1111;
        final byte[] array1114;
        final byte[] array1113 = array1114 = new byte[n];
        array1114[0] = 78;
        array1114[1] = 0;
        array1114[2] = 44;
        array1114[3] = 41;
        array1108[al] = array1113;
        f4[5] = array1108;
        final byte[][] array1115 = new byte[n][];
        final byte[] array1117;
        final byte[] array1116 = array1117 = new byte[n];
        array1117[1] = (array1117[0] = 0);
        array1117[3] = (array1117[2] = 44);
        array1115[0] = array1116;
        final byte[] array1119;
        final byte[] array1118 = array1119 = new byte[n];
        array1119[0] = 0;
        array1119[2] = (array1119[1] = 44);
        array1119[3] = 9;
        array1115[b] = array1118;
        final byte[] array1121;
        final byte[] array1120 = array1121 = new byte[n];
        array1121[0] = 0;
        array1121[1] = 53;
        array1121[2] = 44;
        array1121[3] = 45;
        array1115[al] = array1120;
        final byte[] array1123;
        final byte[] array1122 = array1123 = new byte[n];
        array1123[0] = 0;
        array1123[1] = 98;
        array1123[2] = 44;
        array1123[3] = 46;
        array1115[n2] = array1122;
        f4[6] = array1115;
        final byte[][] array1124 = new byte[n2][];
        final byte[] array1126;
        final byte[] array1125 = array1126 = new byte[n];
        array1126[1] = (array1126[0] = 0);
        array1126[2] = 35;
        array1126[3] = 29;
        array1124[0] = array1125;
        final byte[] array1128;
        final byte[] array1127 = array1128 = new byte[n];
        array1128[0] = 0;
        array1128[1] = 29;
        array1128[2] = 38;
        array1128[3] = 35;
        array1124[b] = array1127;
        final byte[] array1130;
        final byte[] array1129 = array1130 = new byte[n];
        array1130[0] = 0;
        array1130[1] = 64;
        array1130[3] = (array1130[2] = 36);
        array1124[al] = array1129;
        f4[7] = array1124;
        final byte[][] array1131 = new byte[n2][];
        final byte[] array1133;
        final byte[] array1132 = array1133 = new byte[n];
        array1133[1] = (array1133[0] = 0);
        array1133[2] = 48;
        array1133[3] = 46;
        array1131[0] = array1132;
        final byte[] array1135;
        final byte[] array1134 = array1135 = new byte[n];
        array1135[0] = 0;
        array1135[1] = 46;
        array1135[3] = (array1135[2] = 48);
        array1131[b] = array1134;
        final byte[] array1137;
        final byte[] array1136 = array1137 = new byte[n];
        array1137[0] = 0;
        array1137[1] = 94;
        array1137[2] = 48;
        array1137[3] = 51;
        array1131[al] = array1136;
        f4[8] = array1131;
        final byte[][] array1138 = new byte[n2][];
        final byte[] array1140;
        final byte[] array1139 = array1140 = new byte[n];
        array1140[1] = (array1140[0] = 0);
        array1140[3] = (array1140[2] = 44);
        array1138[0] = array1139;
        final byte[] array1142;
        final byte[] array1141 = array1142 = new byte[n];
        array1142[0] = 0;
        array1142[1] = 44;
        array1142[2] = 48;
        array1142[3] = 50;
        array1138[b] = array1141;
        final byte[] array1144;
        final byte[] array1143 = array1144 = new byte[n];
        array1144[0] = 0;
        array1144[1] = 94;
        array1144[2] = 48;
        array1144[3] = 53;
        array1138[al] = array1143;
        f4[9] = array1138;
        final byte[][] array1145 = new byte[9][];
        final byte[] array1147;
        final byte[] array1146 = array1147 = new byte[n];
        array1147[1] = (array1147[0] = 0);
        array1147[2] = 28;
        array1147[3] = 25;
        array1145[0] = array1146;
        final byte[] array1149;
        final byte[] array1148 = array1149 = new byte[n];
        array1149[0] = 0;
        array1149[1] = 25;
        array1149[2] = 22;
        array1149[3] = 16;
        array1145[b] = array1148;
        final byte[] array1151;
        final byte[] array1150 = array1151 = new byte[n];
        array1151[0] = 28;
        array1151[1] = 0;
        array1151[2] = 26;
        array1151[3] = 25;
        array1145[al] = array1150;
        final byte[] array1153;
        final byte[] array1152 = array1153 = new byte[n];
        array1153[0] = 22;
        array1153[1] = 25;
        array1153[2] = 32;
        array1153[3] = 27;
        array1145[n2] = array1152;
        final byte[] array1155;
        final byte[] array1154 = array1155 = new byte[n];
        array1155[0] = 0;
        array1155[1] = 41;
        array1155[3] = (array1155[2] = 16);
        array1145[n] = array1154;
        final byte[] array1157;
        final byte[] array1156 = array1157 = new byte[n];
        array1157[0] = 0;
        array1157[1] = 57;
        array1157[3] = (array1157[2] = 16);
        array1145[5] = array1156;
        final byte[] array1159;
        final byte[] array1158 = array1159 = new byte[n];
        array1159[0] = 22;
        array1159[1] = 52;
        array1159[3] = (array1159[2] = 16);
        array1145[6] = array1158;
        final byte[] array1161;
        final byte[] array1160 = array1161 = new byte[n];
        array1161[0] = 38;
        array1161[1] = 52;
        array1161[3] = (array1161[2] = 16);
        array1145[7] = array1160;
        final byte[] array1163;
        final byte[] array1162 = array1163 = new byte[n];
        array1163[0] = 16;
        array1163[1] = 68;
        array1163[3] = (array1163[2] = 16);
        array1145[8] = array1162;
        f4[10] = array1145;
        this.f1112 = f4;
        final byte[][][] g1059 = new byte[11][][];
        final byte[][] array1164 = new byte[n2][];
        final byte[] array1166;
        final byte[] array1165 = array1166 = new byte[6];
        array1166[0] = 0;
        array1166[1] = -13;
        array1166[2] = -15;
        array1166[3] = 1;
        array1166[4] = -11;
        array1166[5] = -20;
        array1164[0] = array1165;
        final byte[] array1168;
        final byte[] array1167 = array1168 = new byte[6];
        array1168[0] = 2;
        array1168[2] = (array1168[1] = -16);
        array1168[3] = 1;
        array1168[4] = -11;
        array1168[5] = -21;
        array1164[b] = array1167;
        final byte[] array1170;
        final byte[] array1169 = array1170 = new byte[6];
        array1170[0] = 3;
        array1170[1] = -16;
        array1170[2] = -20;
        array1170[3] = 1;
        array1170[4] = -11;
        array1170[5] = -23;
        array1164[al] = array1169;
        g1059[0] = array1164;
        final byte[][] array1171 = new byte[n2][];
        final byte[] array1173;
        final byte[] array1172 = array1173 = new byte[6];
        array1173[0] = 0;
        array1173[1] = -12;
        array1173[2] = -15;
        array1173[3] = 2;
        array1173[4] = -11;
        array1173[5] = -20;
        array1171[0] = array1172;
        final byte[] array1175;
        final byte[] array1174 = array1175 = new byte[6];
        array1175[0] = 1;
        array1175[2] = (array1175[1] = -15);
        array1175[3] = 2;
        array1175[4] = -11;
        array1175[5] = -22;
        array1171[b] = array1174;
        final byte[] array1177;
        final byte[] array1176 = array1177 = new byte[6];
        array1177[0] = 3;
        array1177[1] = -16;
        array1177[2] = -19;
        array1177[3] = 2;
        array1177[4] = -11;
        array1177[5] = -25;
        array1171[al] = array1176;
        g1059[b] = array1171;
        final byte[][] array1178 = new byte[n2][];
        final byte[] array1180;
        final byte[] array1179 = array1180 = new byte[9];
        array1180[0] = 0;
        array1180[1] = -14;
        array1180[2] = -17;
        array1180[3] = 2;
        array1180[4] = -14;
        array1180[5] = -1;
        array1180[6] = 1;
        array1180[7] = -10;
        array1180[8] = -24;
        array1178[0] = array1179;
        final byte[] array1182;
        final byte[] array1181 = array1182 = new byte[9];
        array1182[0] = 3;
        array1182[1] = -14;
        array1182[2] = -23;
        array1182[3] = 2;
        array1182[4] = -14;
        array1182[5] = -1;
        array1182[6] = 1;
        array1182[7] = -10;
        array1182[8] = -24;
        array1178[b] = array1181;
        final byte[] array1184;
        final byte[] array1183 = array1184 = new byte[9];
        array1184[0] = 4;
        array1184[1] = -16;
        array1184[2] = -25;
        array1184[3] = 2;
        array1184[4] = -14;
        array1184[5] = -1;
        array1184[6] = 1;
        array1184[7] = -10;
        array1184[8] = -29;
        array1178[al] = array1183;
        g1059[al] = array1178;
        final byte[][] array1185 = new byte[n2][];
        final byte[] array1187;
        final byte[] array1186 = array1187 = new byte[n2];
        array1187[0] = 0;
        array1187[1] = -11;
        array1187[2] = -22;
        array1185[0] = array1186;
        final byte[] array1189;
        final byte[] array1188 = array1189 = new byte[n2];
        array1189[0] = 1;
        array1189[1] = -17;
        array1189[2] = -27;
        array1185[b] = array1188;
        final byte[] array1191;
        final byte[] array1190 = array1191 = new byte[n2];
        array1191[0] = 2;
        array1191[1] = -17;
        array1191[2] = -23;
        array1185[al] = array1190;
        g1059[n2] = array1185;
        final byte[][] array1192 = new byte[n2][];
        final byte[] array1194;
        final byte[] array1193 = array1194 = new byte[6];
        array1194[0] = 0;
        array1194[1] = -9;
        array1194[2] = -7;
        array1194[3] = 1;
        array1194[4] = -13;
        array1194[5] = -22;
        array1192[0] = array1193;
        final byte[] array1196;
        final byte[] array1195 = array1196 = new byte[9];
        array1196[0] = 2;
        array1196[1] = -16;
        array1196[2] = -13;
        array1196[3] = 3;
        array1196[4] = -16;
        array1196[5] = -2;
        array1196[6] = 1;
        array1196[7] = -13;
        array1196[8] = -22;
        array1192[b] = array1195;
        final byte[] array1198;
        final byte[] array1197 = array1198 = new byte[9];
        array1198[0] = 4;
        array1198[1] = -16;
        array1198[2] = -25;
        array1198[3] = 3;
        array1198[4] = -16;
        array1198[5] = -1;
        array1198[6] = 1;
        array1198[7] = -13;
        array1198[8] = -33;
        array1192[al] = array1197;
        g1059[n] = array1192;
        final byte[][] array1199 = new byte[n2][];
        final byte[] array1201;
        final byte[] array1200 = array1201 = new byte[n2];
        array1201[0] = 0;
        array1201[2] = (array1201[1] = -18);
        array1199[0] = array1200;
        final byte[] array1203;
        final byte[] array1202 = array1203 = new byte[n2];
        array1203[0] = 1;
        array1203[2] = (array1203[1] = -21);
        array1199[b] = array1202;
        final byte[] array1205;
        final byte[] array1204 = array1205 = new byte[n2];
        array1205[0] = 2;
        array1205[1] = -22;
        array1205[2] = -21;
        array1199[al] = array1204;
        g1059[5] = array1199;
        final byte[][] array1206 = new byte[n2][];
        final byte[] array1208;
        final byte[] array1207 = array1208 = new byte[6];
        array1208[0] = 0;
        array1208[1] = -22;
        array1208[2] = -32;
        array1208[3] = 1;
        array1208[4] = -22;
        array1208[5] = 12;
        array1206[0] = array1207;
        final byte[] array1210;
        final byte[] array1209 = array1210 = new byte[6];
        array1210[0] = 2;
        array1210[1] = -22;
        array1210[2] = -33;
        array1210[3] = 1;
        array1210[4] = -22;
        array1210[5] = 12;
        array1206[b] = array1209;
        final byte[] array1212;
        final byte[] array1211 = array1212 = new byte[6];
        array1212[0] = 3;
        array1212[1] = -22;
        array1212[2] = -34;
        array1212[3] = 1;
        array1212[4] = -22;
        array1212[5] = 12;
        array1206[al] = array1211;
        g1059[6] = array1206;
        final byte[][] array1213 = new byte[n2][];
        final byte[] array1215;
        final byte[] array1214 = array1215 = new byte[n2];
        array1215[0] = 0;
        array1215[1] = -18;
        array1215[2] = -16;
        array1213[0] = array1214;
        final byte[] array1217;
        final byte[] array1216 = array1217 = new byte[n2];
        array1217[0] = 1;
        array1217[2] = (array1217[1] = -20);
        array1213[b] = array1216;
        final byte[] array1219;
        final byte[] array1218 = array1219 = new byte[n2];
        array1219[0] = 2;
        array1219[1] = -17;
        array1219[2] = -21;
        array1213[al] = array1218;
        g1059[7] = array1213;
        final byte[][] array1220 = new byte[n2][];
        final byte[] array1222;
        final byte[] array1221 = array1222 = new byte[n2];
        array1222[0] = 0;
        array1222[1] = -24;
        array1222[2] = -30;
        array1220[0] = array1221;
        final byte[] array1224;
        final byte[] array1223 = array1224 = new byte[n2];
        array1224[0] = 1;
        array1224[1] = -24;
        array1224[2] = -30;
        array1220[b] = array1223;
        final byte[] array1226;
        final byte[] array1225 = array1226 = new byte[n2];
        array1226[0] = 2;
        array1226[1] = -24;
        array1226[2] = -30;
        array1220[al] = array1225;
        g1059[8] = array1220;
        final byte[][] array1227 = new byte[n2][];
        final byte[] array1229;
        final byte[] array1228 = array1229 = new byte[n2];
        array1229[0] = 0;
        array1229[1] = -22;
        array1229[2] = -28;
        array1227[0] = array1228;
        final byte[] array1231;
        final byte[] array1230 = array1231 = new byte[n2];
        array1231[0] = 1;
        array1231[1] = -24;
        array1231[2] = -31;
        array1227[b] = array1230;
        final byte[] array1233;
        final byte[] array1232 = array1233 = new byte[n2];
        array1233[0] = 2;
        array1233[1] = -24;
        array1233[2] = -31;
        array1227[al] = array1232;
        g1059[9] = array1227;
        final byte[][] array1234 = new byte[n2][];
        final byte[] array1236;
        final byte[] array1235 = array1236 = new byte[6];
        array1236[0] = 0;
        array1236[1] = -14;
        array1236[2] = -17;
        array1236[3] = 1;
        array1236[4] = -11;
        array1236[5] = -29;
        array1234[0] = array1235;
        final byte[] array1238;
        final byte[] array1237 = array1238 = new byte[6];
        array1238[0] = 0;
        array1238[1] = -14;
        array1238[2] = -17;
        array1238[3] = 2;
        array1238[4] = -13;
        array1238[5] = -34;
        array1234[b] = array1237;
        final byte[] array1240;
        final byte[] array1239 = array1240 = new byte[6];
        array1240[0] = 0;
        array1240[1] = -14;
        array1240[2] = -17;
        array1240[3] = 3;
        array1240[4] = -16;
        array1240[5] = -37;
        array1234[al] = array1239;
        g1059[10] = array1234;
        this.g1113 = g1059;
        final byte[][] q1101 = new byte[11][];
        final byte[] array1242;
        final byte[] array1241 = array1242 = new byte[n2];
        array1242[0] = 2;
        array1242[2] = (array1242[1] = 2);
        q1101[0] = array1241;
        final byte[] array1244;
        final byte[] array1243 = array1244 = new byte[n2];
        array1244[0] = 2;
        array1244[2] = (array1244[1] = 2);
        q1101[b] = array1243;
        final byte[] array1246;
        final byte[] array1245 = array1246 = new byte[n2];
        array1246[0] = 3;
        array1246[2] = (array1246[1] = 3);
        q1101[al] = array1245;
        final byte[] array1248;
        final byte[] array1247 = array1248 = new byte[n2];
        array1248[0] = 1;
        array1248[2] = (array1248[1] = 1);
        q1101[n2] = array1247;
        final byte[] array1250;
        final byte[] array1249 = array1250 = new byte[n2];
        array1250[0] = 2;
        array1250[2] = (array1250[1] = 3);
        q1101[n] = array1249;
        final byte[] array1252;
        final byte[] array1251 = array1252 = new byte[n2];
        array1252[0] = 1;
        array1252[2] = (array1252[1] = 1);
        q1101[5] = array1251;
        final byte[] array1254;
        final byte[] array1253 = array1254 = new byte[n2];
        array1254[0] = 2;
        array1254[2] = (array1254[1] = 2);
        q1101[6] = array1253;
        final byte[] array1256;
        final byte[] array1255 = array1256 = new byte[n2];
        array1256[0] = 1;
        array1256[2] = (array1256[1] = 1);
        q1101[7] = array1255;
        final byte[] array1258;
        final byte[] array1257 = array1258 = new byte[n2];
        array1258[0] = 1;
        array1258[2] = (array1258[1] = 1);
        q1101[8] = array1257;
        final byte[] array1260;
        final byte[] array1259 = array1260 = new byte[n2];
        array1260[0] = 1;
        array1260[2] = (array1260[1] = 1);
        q1101[9] = array1259;
        final byte[] array1262;
        final byte[] array1261 = array1262 = new byte[n2];
        array1262[0] = 2;
        array1262[2] = (array1262[1] = 2);
        q1101[10] = array1261;
        this.q1114 = q1101;
        final byte[][] r1102 = new byte[n][];
        final byte[] array1264;
        final byte[] array1263 = array1264 = new byte[al];
        array1264[0] = 0;
        array1264[1] = 8;
        r1102[0] = array1263;
        final byte[] array1266;
        final byte[] array1265 = array1266 = new byte[al];
        array1266[0] = -6;
        array1266[1] = 8;
        r1102[b] = array1265;
        final byte[] array1268;
        final byte[] array1267 = array1268 = new byte[al];
        array1268[1] = (array1268[0] = 0);
        r1102[al] = array1267;
        final byte[] array1270;
        final byte[] array1269 = array1270 = new byte[al];
        array1270[0] = 6;
        array1270[1] = 8;
        r1102[n2] = array1269;
        this.r1115 = r1102;
        final int[] array1271;
        final int[] l1074 = array1271 = new int[9];
        array1271[0] = 16777191;
        array1271[1] = 15457227;
        array1271[2] = 7730877;
        array1271[3] = 15656911;
        array1271[4] = 7049925;
        array1271[6] = (array1271[5] = 7730877);
        array1271[7] = 7049925;
        array1271[8] = 15656911;
        this.l1116 = l1074;
        final byte[][] s1103 = new byte[n][];
        final byte[] array1273;
        final byte[] array1272 = array1273 = new byte[al];
        array1273[0] = 1;
        array1273[1] = 0;
        s1103[0] = array1272;
        final byte[] array1275;
        final byte[] array1274 = array1275 = new byte[al];
        array1275[0] = 0;
        array1275[1] = 1;
        s1103[b] = array1274;
        final byte[] array1277;
        final byte[] array1276 = array1277 = new byte[al];
        array1277[0] = 1;
        array1277[1] = 0;
        s1103[al] = array1276;
        final byte[] array1279;
        final byte[] array1278 = array1279 = new byte[al];
        array1279[0] = 0;
        array1279[1] = 1;
        s1103[n2] = array1278;
        this.s1117 = s1103;
        final byte[][] t1104 = new byte[n][];
        final byte[] array1281;
        final byte[] array1280 = array1281 = new byte[al];
        array1281[0] = 1;
        array1281[1] = 5;
        t1104[0] = array1280;
        final byte[] array1283;
        final byte[] array1282 = array1283 = new byte[al];
        array1283[0] = 29;
        array1283[1] = -5;
        t1104[b] = array1282;
        final byte[] array1285;
        final byte[] array1284 = array1285 = new byte[al];
        array1285[0] = 1;
        array1285[1] = 27;
        t1104[al] = array1284;
        final byte[] array1287;
        final byte[] array1286 = array1287 = new byte[al];
        array1287[0] = 1;
        array1287[1] = -5;
        t1104[n2] = array1286;
        this.t1118 = t1104;
        final byte[][] u1105 = new byte[n2][];
        final byte[] array1289;
        final byte[] array1288 = array1289 = new byte[al];
        array1289[0] = 33;
        array1289[1] = -9;
        u1105[0] = array1288;
        final byte[] array1291;
        final byte[] array1290 = array1291 = new byte[al];
        array1291[0] = 43;
        array1291[1] = -18;
        u1105[b] = array1290;
        final byte[] array1293;
        final byte[] array1292 = array1293 = new byte[al];
        array1293[0] = 58;
        array1293[1] = -27;
        u1105[al] = array1292;
        this.u1119 = u1105;
        final byte[][] v1110 = new byte[n2][];
        final byte[] array1295;
        final byte[] array1294 = array1295 = new byte[al];
        array1295[0] = -33;
        array1295[1] = -27;
        v1110[0] = array1294;
        final byte[] array1297;
        final byte[] array1296 = array1297 = new byte[al];
        array1297[1] = (array1297[0] = -18);
        v1110[b] = array1296;
        final byte[] array1299;
        final byte[] array1298 = array1299 = new byte[al];
        array1299[0] = -8;
        array1299[1] = -9;
        v1110[al] = array1298;
        this.v1120 = v1110;
        final byte[][][] h1062 = new byte[n][][];
        final byte[][] array1300 = new byte[n2][];
        final byte[] array1302;
        final byte[] array1301 = array1302 = new byte[al];
        array1302[0] = 0;
        array1302[1] = 52;
        array1300[0] = array1301;
        final byte[] array1304;
        final byte[] array1303 = array1304 = new byte[al];
        array1304[0] = 52;
        array1304[1] = 14;
        array1300[b] = array1303;
        final byte[] array1306;
        final byte[] array1305 = array1306 = new byte[al];
        array1306[0] = 66;
        array1306[1] = 16;
        array1300[al] = array1305;
        h1062[0] = array1300;
        final byte[][] array1307 = new byte[n2][];
        final byte[] array1309;
        final byte[] array1308 = array1309 = new byte[al];
        array1309[0] = 0;
        array1309[1] = 13;
        array1307[0] = array1308;
        final byte[] array1311;
        final byte[] array1310 = array1311 = new byte[al];
        array1311[0] = 13;
        array1311[1] = 16;
        array1307[b] = array1310;
        final byte[] array1313;
        final byte[] array1312 = array1313 = new byte[al];
        array1313[0] = 29;
        array1313[1] = 23;
        array1307[al] = array1312;
        h1062[b] = array1307;
        final byte[][] array1314 = new byte[n2][];
        final byte[] array1316;
        final byte[] array1315 = array1316 = new byte[al];
        array1316[0] = 0;
        array1316[1] = 32;
        array1314[0] = array1315;
        final byte[] array1318;
        final byte[] array1317 = array1318 = new byte[al];
        array1318[0] = 32;
        array1318[1] = 23;
        array1314[b] = array1317;
        final byte[] array1320;
        final byte[] array1319 = array1320 = new byte[al];
        array1320[0] = 55;
        array1320[1] = 15;
        array1314[al] = array1319;
        h1062[al] = array1314;
        final byte[][] array1321 = new byte[n2][];
        final byte[] array1323;
        final byte[] array1322 = array1323 = new byte[al];
        array1323[0] = 0;
        array1323[1] = 23;
        array1321[0] = array1322;
        final byte[] array1325;
        final byte[] array1324 = array1325 = new byte[al];
        array1325[0] = 23;
        array1325[1] = 16;
        array1321[b] = array1324;
        final byte[] array1327;
        final byte[] array1326 = array1327 = new byte[al];
        array1327[0] = 39;
        array1327[1] = 13;
        array1321[al] = array1326;
        h1062[n2] = array1321;
        this.h1121 = h1062;
        final byte[][][] i1064 = new byte[11][][];
        final byte[][] array1328 = new byte[n][];
        final byte[] array1330;
        final byte[] array1329 = array1330 = new byte[al];
        array1330[0] = -5;
        array1330[1] = -31;
        array1328[0] = array1329;
        final byte[] array1332;
        final byte[] array1331 = array1332 = new byte[al];
        array1332[0] = 6;
        array1332[1] = -24;
        array1328[b] = array1331;
        final byte[] array1334;
        final byte[] array1333 = array1334 = new byte[al];
        array1334[0] = -5;
        array1334[1] = -16;
        array1328[al] = array1333;
        final byte[] array1336;
        final byte[] array1335 = array1336 = new byte[al];
        array1336[0] = -14;
        array1336[1] = -24;
        array1328[n2] = array1335;
        i1064[0] = array1328;
        i1064[b] = new byte[0][];
        final byte[][] array1337 = new byte[b][];
        final byte[] array1339;
        final byte[] array1338 = array1339 = new byte[al];
        array1339[0] = -3;
        array1339[1] = -2;
        array1337[0] = array1338;
        i1064[al] = array1337;
        final byte[][] array1340 = new byte[n][];
        final byte[] array1342;
        final byte[] array1341 = array1342 = new byte[al];
        array1342[0] = -11;
        array1342[1] = -31;
        array1340[0] = array1341;
        final byte[] array1344;
        final byte[] array1343 = array1344 = new byte[al];
        array1344[0] = -14;
        array1344[1] = -9;
        array1340[b] = array1343;
        final byte[] array1346;
        final byte[] array1345 = array1346 = new byte[al];
        array1346[0] = 0;
        array1346[1] = -7;
        array1340[al] = array1345;
        final byte[] array1348;
        final byte[] array1347 = array1348 = new byte[al];
        array1348[0] = 8;
        array1348[1] = -21;
        array1340[n2] = array1347;
        i1064[n2] = array1340;
        final byte[][] array1349 = new byte[b][];
        final byte[] array1351;
        final byte[] array1350 = array1351 = new byte[al];
        array1351[0] = -6;
        array1351[1] = -27;
        array1349[0] = array1350;
        i1064[n] = array1349;
        final byte[][] array1352 = new byte[b][];
        final byte[] array1354;
        final byte[] array1353 = array1354 = new byte[al];
        array1354[0] = -6;
        array1354[1] = -9;
        array1352[0] = array1353;
        i1064[5] = array1352;
        i1064[6] = new byte[0][];
        final byte[][] array1355 = new byte[al][];
        final byte[] array1357;
        final byte[] array1356 = array1357 = new byte[al];
        array1357[0] = -18;
        array1357[1] = -34;
        array1355[0] = array1356;
        final byte[] array1359;
        final byte[] array1358 = array1359 = new byte[al];
        array1359[0] = 5;
        array1359[1] = -34;
        array1355[b] = array1358;
        i1064[7] = array1355;
        final byte[][] array1360 = new byte[b][];
        final byte[] array1362;
        final byte[] array1361 = array1362 = new byte[al];
        array1362[0] = -7;
        array1362[1] = -19;
        array1360[0] = array1361;
        i1064[8] = array1360;
        final byte[][] array1363 = new byte[b][];
        final byte[] array1365;
        final byte[] array1364 = array1365 = new byte[al];
        array1365[0] = -8;
        array1365[1] = -18;
        array1363[0] = array1364;
        i1064[9] = array1363;
        i1064[10] = new byte[0][];
        this.i1122 = i1064;
        final byte[][] w1111 = new byte[11][];
        final byte[] array1367;
        final byte[] array1366 = array1367 = new byte[30];
        array1367[0] = 0;
        array1367[2] = (array1367[1] = 1);
        array1367[4] = (array1367[3] = 2);
        array1367[6] = (array1367[5] = 1);
        array1367[8] = (array1367[7] = 3);
        array1367[10] = (array1367[9] = 1);
        array1367[12] = (array1367[11] = 2);
        array1367[14] = (array1367[13] = 1);
        array1367[16] = (array1367[15] = 3);
        array1367[18] = (array1367[17] = 1);
        array1367[19] = 0;
        array1367[21] = (array1367[20] = 4);
        array1367[23] = (array1367[22] = 4);
        array1367[25] = (array1367[24] = 4);
        array1367[27] = (array1367[26] = 4);
        array1367[29] = (array1367[28] = 0);
        w1111[0] = array1366;
        w1111[b] = new byte[0];
        final byte[] array1369;
        final byte[] array1368 = array1369 = new byte[24];
        array1369[0] = 0;
        array1369[1] = 1;
        array1369[2] = 2;
        array1369[3] = 3;
        array1369[4] = 2;
        array1369[5] = 3;
        array1369[6] = 2;
        array1369[7] = 3;
        array1369[8] = 2;
        array1369[10] = (array1369[9] = 3);
        array1369[11] = 2;
        array1369[12] = 1;
        array1369[13] = 0;
        array1369[15] = (array1369[14] = 4);
        array1369[17] = (array1369[16] = 4);
        array1369[19] = (array1369[18] = 4);
        array1369[21] = (array1369[20] = 4);
        array1369[22] = 6;
        array1369[23] = 12;
        w1111[al] = array1368;
        final byte[] array1371;
        final byte[] array1370 = array1371 = new byte[14];
        array1371[0] = 0;
        array1371[1] = 1;
        array1371[2] = 2;
        array1371[3] = 3;
        array1371[4] = 4;
        array1371[5] = 5;
        array1371[6] = 6;
        array1371[7] = 7;
        array1371[8] = 8;
        array1371[9] = 9;
        array1371[10] = 10;
        array1371[11] = 11;
        array1371[12] = 5;
        array1371[13] = 15;
        w1111[n2] = array1370;
        final byte[] array1373;
        final byte[] array1372 = array1373 = new byte[12];
        array1373[1] = (array1373[0] = 0);
        array1373[3] = (array1373[2] = 0);
        array1373[5] = (array1373[4] = 0);
        array1373[7] = (array1373[6] = 0);
        array1373[9] = (array1373[8] = 0);
        array1373[10] = 12;
        array1373[11] = 17;
        w1111[n] = array1372;
        final byte[] array1375;
        final byte[] array1374 = array1375 = new byte[12];
        array1375[0] = 0;
        array1375[1] = 1;
        array1375[2] = 2;
        array1375[3] = 3;
        array1375[4] = 4;
        array1375[5] = 5;
        array1375[6] = 6;
        array1375[7] = 7;
        array1375[8] = 8;
        array1375[9] = 9;
        array1375[10] = 12;
        array1375[11] = 11;
        w1111[5] = array1374;
        w1111[6] = new byte[0];
        final byte[] array1377;
        final byte[] array1376 = array1377 = new byte[11];
        array1377[0] = 0;
        array1377[1] = 1;
        array1377[2] = 2;
        array1377[3] = 0;
        array1377[4] = 1;
        array1377[5] = 2;
        array1377[6] = 0;
        array1377[7] = 1;
        array1377[8] = 2;
        array1377[9] = 13;
        array1377[10] = 33;
        w1111[7] = array1376;
        final byte[] array1379;
        final byte[] array1378 = array1379 = new byte[11];
        array1379[0] = 0;
        array1379[1] = 1;
        array1379[2] = 2;
        array1379[3] = 3;
        array1379[4] = 4;
        array1379[5] = 5;
        array1379[6] = 6;
        array1379[8] = (array1379[7] = 6);
        array1379[10] = (array1379[9] = 14);
        w1111[8] = array1378;
        final byte[] array1381;
        final byte[] array1380 = array1381 = new byte[13];
        array1381[0] = 0;
        array1381[1] = 1;
        array1381[3] = (array1381[2] = 2);
        array1381[5] = (array1381[4] = 2);
        array1381[6] = 1;
        array1381[7] = 0;
        array1381[8] = 3;
        array1381[10] = (array1381[9] = 3);
        array1381[11] = 16;
        array1381[12] = 12;
        w1111[9] = array1380;
        w1111[10] = new byte[0];
        this.w1123 = w1111;
        final byte[] array1382;
        final byte[] x1124 = array1382 = new byte[10];
        array1382[0] = 0;
        array1382[1] = 2;
        array1382[3] = (array1382[2] = 3);
        array1382[4] = 2;
        array1382[5] = 1;
        array1382[6] = 0;
        array1382[7] = -1;
        array1382[8] = -2;
        array1382[9] = -1;
        this.x1124 = x1124;
        final byte[] array1383;
        final byte[] y1125 = array1383 = new byte[16];
        array1383[0] = -5;
        array1383[1] = -20;
        array1383[2] = 10;
        array1383[3] = 3;
        array1383[4] = 8;
        array1383[5] = -15;
        array1383[6] = 6;
        array1383[7] = 9;
        array1383[8] = -5;
        array1383[9] = -4;
        array1383[10] = 10;
        array1383[11] = 6;
        array1383[12] = -14;
        array1383[13] = -15;
        array1383[14] = 6;
        array1383[15] = 9;
        this.y1125 = y1125;
        this.a1127 = (boolean[][])Array.newInstance(Boolean.TYPE, n2, n2);
        final byte[][] x1125 = new byte[n][];
        final byte[] array1385;
        final byte[] array1384 = array1385 = new byte[al];
        array1385[0] = 1;
        array1385[1] = -16;
        x1125[0] = array1384;
        final byte[] array1387;
        final byte[] array1386 = array1387 = new byte[al];
        array1387[0] = 16;
        array1387[1] = 1;
        x1125[b] = array1386;
        final byte[] array1389;
        final byte[] array1388 = array1389 = new byte[al];
        array1389[0] = 1;
        array1389[1] = 16;
        x1125[al] = array1388;
        final byte[] array1391;
        final byte[] array1390 = array1391 = new byte[al];
        array1391[0] = -16;
        array1391[1] = 1;
        x1125[n2] = array1390;
        this.x1128 = x1125;
        this.m1129 = new int[n];
        final byte[][] y1126 = new byte[n2][];
        final byte[] array1393;
        final byte[] array1392 = array1393 = new byte[11];
        array1393[0] = 0;
        array1393[1] = 6;
        array1393[2] = 7;
        array1393[3] = 8;
        array1393[4] = 9;
        array1393[5] = 10;
        array1393[6] = 2;
        array1393[7] = 3;
        array1393[8] = 4;
        array1393[9] = 5;
        array1393[10] = 1;
        y1126[0] = array1392;
        final byte[] array1395;
        final byte[] array1394 = array1395 = new byte[11];
        array1395[0] = 11;
        array1395[1] = 17;
        array1395[2] = 18;
        array1395[3] = 19;
        array1395[4] = 20;
        array1395[5] = 21;
        array1395[6] = 13;
        array1395[7] = 14;
        array1395[8] = 15;
        array1395[9] = 16;
        array1395[10] = 12;
        y1126[b] = array1394;
        final byte[] array1397;
        final byte[] array1396 = array1397 = new byte[11];
        array1397[0] = 22;
        array1397[1] = 28;
        array1397[2] = 29;
        array1397[3] = 30;
        array1397[4] = 31;
        array1397[5] = 32;
        array1397[6] = 24;
        array1397[7] = 25;
        array1397[8] = 26;
        array1397[9] = 27;
        array1397[10] = 23;
        y1126[al] = array1396;
        this.y1130 = y1126;
        final byte[][] z1131 = new byte[9][];
        final byte[] array1399;
        final byte[] array1398 = array1399 = new byte[n2];
        array1399[0] = 33;
        array1399[1] = 34;
        array1399[2] = 35;
        z1131[0] = array1398;
        final byte[] array1401;
        final byte[] array1400 = array1401 = new byte[n];
        array1401[0] = 36;
        array1401[1] = 37;
        array1401[2] = 38;
        array1401[3] = 39;
        z1131[b] = array1400;
        final byte[] array1403;
        final byte[] array1402 = array1403 = new byte[10];
        array1403[0] = 16;
        array1403[1] = 40;
        array1403[2] = 41;
        array1403[3] = 42;
        array1403[4] = 13;
        array1403[5] = 0;
        array1403[6] = 4;
        array1403[7] = 5;
        array1403[8] = 1;
        array1403[9] = 8;
        z1131[al] = array1402;
        final byte[] array1405;
        final byte[] array1404 = array1405 = new byte[12];
        array1405[0] = 42;
        array1405[1] = 43;
        array1405[2] = 13;
        array1405[3] = 40;
        array1405[4] = 44;
        array1405[5] = 45;
        array1405[6] = 0;
        array1405[7] = 8;
        array1405[8] = 32;
        array1405[9] = 25;
        array1405[10] = 47;
        array1405[11] = 31;
        z1131[n2] = array1404;
        final byte[] array1407;
        final byte[] array1406 = array1407 = new byte[12];
        array1407[0] = 13;
        array1407[1] = 45;
        array1407[2] = 44;
        array1407[3] = 42;
        array1407[4] = 41;
        array1407[5] = 46;
        array1407[6] = 23;
        array1407[7] = 24;
        array1407[8] = 30;
        array1407[9] = 22;
        array1407[10] = 26;
        array1407[11] = 47;
        z1131[n] = array1406;
        final byte[] array1409;
        final byte[] array1408 = array1409 = new byte[12];
        array1409[0] = 0;
        array1409[1] = 2;
        array1409[2] = 5;
        array1409[3] = 6;
        array1409[4] = 3;
        array1409[5] = 8;
        array1409[6] = 22;
        array1409[7] = 29;
        array1409[8] = 24;
        array1409[9] = 25;
        array1409[10] = 26;
        array1409[11] = 23;
        z1131[5] = array1408;
        final byte[] array1411;
        final byte[] array1410 = array1411 = new byte[5];
        array1411[0] = 2;
        array1411[1] = 8;
        array1411[2] = 5;
        array1411[3] = 3;
        array1411[4] = 7;
        z1131[6] = array1410;
        final byte[] array1413;
        final byte[] array1412 = array1413 = new byte[5];
        array1413[0] = 13;
        array1413[1] = 16;
        array1413[2] = 40;
        array1413[3] = 46;
        array1413[4] = 17;
        z1131[7] = array1412;
        final byte[] array1415;
        final byte[] array1414 = array1415 = new byte[5];
        array1415[0] = 24;
        array1415[1] = 26;
        array1415[2] = 28;
        array1415[3] = 29;
        array1415[4] = 22;
        z1131[8] = array1414;
        this.z1131 = z1131;
        final byte[][] a1020 = new byte[n2][];
        final byte[] array1417;
        final byte[] array1416 = array1417 = new byte[9];
        array1417[1] = (array1417[0] = 0);
        array1417[3] = (array1417[2] = 0);
        array1417[4] = 2;
        array1417[5] = 1;
        array1417[6] = 2;
        array1417[8] = (array1417[7] = 0);
        a1020[0] = array1416;
        final byte[] array1419;
        final byte[] array1418 = array1419 = new byte[9];
        array1419[1] = (array1419[0] = 0);
        array1419[2] = 1;
        array1419[4] = (array1419[3] = 1);
        array1419[5] = 2;
        array1419[6] = 0;
        array1419[7] = 2;
        array1419[8] = 0;
        a1020[b] = array1418;
        final byte[] array1421;
        final byte[] array1420 = array1421 = new byte[9];
        array1421[1] = (array1421[0] = 0);
        array1421[2] = 2;
        array1421[3] = 0;
        array1421[5] = (array1421[4] = 0);
        array1421[7] = (array1421[6] = 0);
        array1421[8] = 2;
        a1020[al] = array1420;
        this.A1132 = a1020;
        final byte[][] b7 = new byte[5][];
        final byte[] array1423;
        final byte[] array1422 = array1423 = new byte[al];
        array1423[0] = 1;
        array1423[1] = 0;
        b7[0] = array1422;
        final byte[] array1425;
        final byte[] array1424 = array1425 = new byte[al];
        array1425[1] = (array1425[0] = 10);
        b7[b] = array1424;
        final byte[] array1427;
        final byte[] array1426 = array1427 = new byte[al];
        array1427[0] = 18;
        array1427[1] = 3;
        b7[al] = array1426;
        final byte[] array1429;
        final byte[] array1428 = array1429 = new byte[al];
        array1429[0] = 4;
        array1429[1] = 9;
        b7[n2] = array1428;
        final byte[] array1431;
        final byte[] array1430 = array1431 = new byte[al];
        array1431[0] = 14;
        array1431[1] = 9;
        b7[n] = array1430;
        this.B1133 = b7;
        this.C1134 = (byte[][])Array.newInstance(Byte.TYPE, 30, 12);
        final byte[][] d1016 = new byte[n2][];
        final byte[] array1433;
        final byte[] array1432 = array1433 = new byte[n];
        array1433[0] = 0;
        array1433[1] = 15;
        array1433[3] = (array1433[2] = 0);
        d1016[0] = array1432;
        final byte[] array1435;
        final byte[] array1434 = array1435 = new byte[n];
        array1435[0] = 15;
        array1435[1] = 23;
        array1435[2] = -4;
        array1435[3] = 1;
        d1016[b] = array1434;
        final byte[] array1437;
        final byte[] array1436 = array1437 = new byte[n];
        array1437[0] = 38;
        array1437[1] = 21;
        array1437[2] = -3;
        array1437[3] = 0;
        d1016[al] = array1436;
        this.D1135 = d1016;
        final byte[][] e1057 = new byte[9][];
        final byte[] array1439;
        final byte[] array1438 = array1439 = new byte[al];
        array1439[0] = 0;
        array1439[1] = -16;
        e1057[0] = array1438;
        final byte[] array1441;
        final byte[] array1440 = array1441 = new byte[al];
        array1441[0] = 16;
        array1441[1] = -16;
        e1057[b] = array1440;
        final byte[] array1443;
        final byte[] array1442 = array1443 = new byte[al];
        array1443[0] = 32;
        array1443[1] = -16;
        e1057[al] = array1442;
        final byte[] array1445;
        final byte[] array1444 = array1445 = new byte[al];
        array1445[0] = -8;
        array1445[1] = -6;
        e1057[n2] = array1444;
        final byte[] array1447;
        final byte[] array1446 = array1447 = new byte[al];
        array1447[0] = -8;
        array1447[1] = 8;
        e1057[n] = array1446;
        final byte[] array1449;
        final byte[] array1448 = array1449 = new byte[al];
        array1449[0] = -8;
        array1449[1] = 22;
        e1057[5] = array1448;
        final byte[] array1451;
        final byte[] array1450 = array1451 = new byte[al];
        array1451[0] = 41;
        array1451[1] = -6;
        e1057[6] = array1450;
        final byte[] array1453;
        final byte[] array1452 = array1453 = new byte[al];
        array1453[0] = 41;
        array1453[1] = 8;
        e1057[7] = array1452;
        final byte[] array1455;
        final byte[] array1454 = array1455 = new byte[al];
        array1455[0] = 41;
        array1455[1] = 22;
        e1057[8] = array1454;
        this.E1136 = e1057;
        final byte[][] f5 = new byte[n][];
        final byte[] array1457;
        final byte[] array1456 = array1457 = new byte[al];
        array1457[0] = 0;
        array1457[1] = -48;
        f5[0] = array1456;
        final byte[] array1459;
        final byte[] array1458 = array1459 = new byte[al];
        array1459[0] = 48;
        array1459[1] = 0;
        f5[b] = array1458;
        final byte[] array1461;
        final byte[] array1460 = array1461 = new byte[al];
        array1461[0] = 0;
        array1461[1] = 64;
        f5[al] = array1460;
        final byte[] array1463;
        final byte[] array1462 = array1463 = new byte[al];
        array1463[0] = -48;
        array1463[1] = 0;
        f5[n2] = array1462;
        this.F1137 = f5;
        final byte[][] g1060 = new byte[n][];
        final byte[] array1465;
        final byte[] array1464 = array1465 = new byte[al];
        array1465[0] = 0;
        array1465[1] = -10;
        g1060[0] = array1464;
        final byte[] array1467;
        final byte[] array1466 = array1467 = new byte[al];
        array1467[0] = 21;
        array1467[1] = -10;
        g1060[b] = array1466;
        final byte[] array1469;
        final byte[] array1468 = array1469 = new byte[al];
        array1469[0] = 0;
        array1469[1] = 11;
        g1060[al] = array1468;
        final byte[] array1471;
        final byte[] array1470 = array1471 = new byte[al];
        array1471[0] = 21;
        array1471[1] = 11;
        g1060[n2] = array1470;
        this.G1138 = g1060;
        final byte[][][] j1052 = new byte[n2][][];
        final byte[][] array1472 = new byte[7][];
        final byte[] array1474;
        final byte[] array1473 = array1474 = new byte[al];
        array1474[0] = -8;
        array1474[1] = -29;
        array1472[0] = array1473;
        final byte[] array1476;
        final byte[] array1475 = array1476 = new byte[al];
        array1476[0] = 6;
        array1476[1] = -19;
        array1472[b] = array1475;
        final byte[] array1478;
        final byte[] array1477 = array1478 = new byte[al];
        array1478[0] = -8;
        array1478[1] = -6;
        array1472[al] = array1477;
        final byte[] array1480;
        final byte[] array1479 = array1480 = new byte[al];
        array1480[1] = (array1480[0] = -19);
        array1472[n2] = array1479;
        final byte[] array1482;
        final byte[] array1481 = array1482 = new byte[al];
        array1482[1] = (array1482[0] = 0);
        array1472[n] = array1481;
        final byte[] array1484;
        final byte[] array1483 = array1484 = new byte[al];
        array1484[0] = 0;
        array1484[1] = -1;
        array1472[5] = array1483;
        final byte[] array1486;
        final byte[] array1485 = array1486 = new byte[al];
        array1486[0] = 0;
        array1486[1] = -3;
        array1472[6] = array1485;
        j1052[0] = array1472;
        final byte[][] array1487 = new byte[7][];
        final byte[] array1489;
        final byte[] array1488 = array1489 = new byte[al];
        array1489[0] = -8;
        array1489[1] = -31;
        array1487[0] = array1488;
        final byte[] array1491;
        final byte[] array1490 = array1491 = new byte[al];
        array1491[0] = 7;
        array1491[1] = -20;
        array1487[b] = array1490;
        final byte[] array1493;
        final byte[] array1492 = array1493 = new byte[al];
        array1493[0] = -8;
        array1493[1] = -6;
        array1487[al] = array1492;
        final byte[] array1495;
        final byte[] array1494 = array1495 = new byte[al];
        array1495[0] = -21;
        array1495[1] = -20;
        array1487[n2] = array1494;
        final byte[] array1497;
        final byte[] array1496 = array1497 = new byte[al];
        array1497[1] = (array1497[0] = 0);
        array1487[n] = array1496;
        final byte[] array1499;
        final byte[] array1498 = array1499 = new byte[al];
        array1499[1] = (array1499[0] = 0);
        array1487[5] = array1498;
        final byte[] array1501;
        final byte[] array1500 = array1501 = new byte[al];
        array1501[0] = 0;
        array1501[1] = -11;
        array1487[6] = array1500;
        j1052[b] = array1487;
        final byte[][] array1502 = new byte[7][];
        final byte[] array1504;
        final byte[] array1503 = array1504 = new byte[al];
        array1504[0] = -8;
        array1504[1] = -29;
        array1502[0] = array1503;
        final byte[] array1506;
        final byte[] array1505 = array1506 = new byte[al];
        array1506[0] = 6;
        array1506[1] = -18;
        array1502[b] = array1505;
        final byte[] array1508;
        final byte[] array1507 = array1508 = new byte[al];
        array1508[0] = -8;
        array1508[1] = -6;
        array1502[al] = array1507;
        final byte[] array1510;
        final byte[] array1509 = array1510 = new byte[al];
        array1510[0] = -19;
        array1510[1] = -18;
        array1502[n2] = array1509;
        final byte[] array1512;
        final byte[] array1511 = array1512 = new byte[al];
        array1512[1] = (array1512[0] = 0);
        array1502[n] = array1511;
        final byte[] array1514;
        final byte[] array1513 = array1514 = new byte[al];
        array1514[0] = 0;
        array1514[1] = -2;
        array1502[5] = array1513;
        final byte[] array1516;
        final byte[] array1515 = array1516 = new byte[al];
        array1516[0] = 0;
        array1516[1] = -5;
        array1502[6] = array1515;
        j1052[al] = array1502;
        this.j1139 = j1052;
        final byte[][] array1517 = new byte[n][];
        final byte[] array1519;
        final byte[] array1518 = array1519 = new byte[al];
        array1519[1] = (array1519[0] = -1);
        array1517[0] = array1518;
        final byte[] array1521;
        final byte[] array1520 = array1521 = new byte[al];
        array1521[0] = 0;
        array1521[1] = -1;
        array1517[b] = array1520;
        final byte[] array1523;
        final byte[] array1522 = array1523 = new byte[al];
        array1523[0] = -1;
        array1523[1] = 0;
        array1517[al] = array1522;
        final byte[] array1525;
        final byte[] array1524 = array1525 = new byte[al];
        array1525[0] = -2;
        array1525[1] = 1;
        array1517[n2] = array1524;
        final byte[][] h1063 = new byte[7][];
        final byte[] array1527;
        final byte[] array1526 = array1527 = new byte[n2];
        array1527[0] = -19;
        array1527[1] = -25;
        array1527[2] = 0;
        h1063[0] = array1526;
        final byte[] array1529;
        final byte[] array1528 = array1529 = new byte[n2];
        array1529[0] = -2;
        array1529[1] = -27;
        array1529[2] = 0;
        h1063[b] = array1528;
        final byte[] array1531;
        final byte[] array1530 = array1531 = new byte[n2];
        array1531[0] = 8;
        array1531[1] = -18;
        array1531[2] = 2;
        h1063[al] = array1530;
        final byte[] array1533;
        final byte[] array1532 = array1533 = new byte[n2];
        array1533[0] = 4;
        array1533[1] = -2;
        array1533[2] = 1;
        h1063[n2] = array1532;
        final byte[] array1535;
        final byte[] array1534 = array1535 = new byte[n2];
        array1535[0] = -10;
        array1535[1] = 6;
        array1535[2] = 2;
        h1063[n] = array1534;
        final byte[] array1537;
        final byte[] array1536 = array1537 = new byte[n2];
        array1537[0] = -24;
        array1537[1] = 4;
        array1537[2] = 0;
        h1063[5] = array1536;
        final byte[] array1539;
        final byte[] array1538 = array1539 = new byte[n2];
        array1539[0] = -16;
        array1539[1] = -9;
        array1539[2] = 0;
        h1063[6] = array1538;
        this.H1140 = h1063;
        final byte[][][] k1071 = new byte[n2][][];
        final byte[][] array1540 = new byte[n][];
        final byte[] array1542;
        final byte[] array1541 = array1542 = new byte[al];
        array1542[0] = 12;
        array1542[1] = -19;
        array1540[0] = array1541;
        final byte[] array1544;
        final byte[] array1543 = array1544 = new byte[al];
        array1544[0] = 48;
        array1544[1] = 13;
        array1540[b] = array1543;
        final byte[] array1546;
        final byte[] array1545 = array1546 = new byte[al];
        array1546[0] = 12;
        array1546[1] = 53;
        array1540[al] = array1545;
        final byte[] array1548;
        final byte[] array1547 = array1548 = new byte[al];
        array1548[0] = -17;
        array1548[1] = 13;
        array1540[n2] = array1547;
        k1071[0] = array1540;
        final byte[][] array1549 = new byte[n][];
        final byte[] array1551;
        final byte[] array1550 = array1551 = new byte[al];
        array1551[0] = 12;
        array1551[1] = -29;
        array1549[0] = array1550;
        final byte[] array1553;
        final byte[] array1552 = array1553 = new byte[al];
        array1553[0] = 64;
        array1553[1] = 12;
        array1549[b] = array1552;
        final byte[] array1555;
        final byte[] array1554 = array1555 = new byte[al];
        array1555[0] = 12;
        array1555[1] = 69;
        array1549[al] = array1554;
        final byte[] array1557;
        final byte[] array1556 = array1557 = new byte[al];
        array1557[0] = -33;
        array1557[1] = 12;
        array1549[n2] = array1556;
        k1071[b] = array1549;
        final byte[][] array1558 = new byte[n][];
        final byte[] array1560;
        final byte[] array1559 = array1560 = new byte[al];
        array1560[0] = 13;
        array1560[1] = -46;
        array1558[0] = array1559;
        final byte[] array1562;
        final byte[] array1561 = array1562 = new byte[al];
        array1562[0] = 80;
        array1562[1] = 13;
        array1558[b] = array1561;
        final byte[] array1564;
        final byte[] array1563 = array1564 = new byte[al];
        array1564[0] = 13;
        array1564[1] = 88;
        array1558[al] = array1563;
        final byte[] array1566;
        final byte[] array1565 = array1566 = new byte[al];
        array1566[0] = -49;
        array1566[1] = 12;
        array1558[n2] = array1565;
        k1071[al] = array1558;
        this.k1141 = k1071;
        final byte[][] i1065 = new byte[n][];
        final byte[] array1568;
        final byte[] array1567 = array1568 = new byte[n];
        array1568[0] = 9;
        array1568[1] = 2;
        array1568[2] = 23;
        array1568[3] = 20;
        i1065[0] = array1567;
        final byte[] array1570;
        final byte[] array1569 = array1570 = new byte[n];
        array1570[0] = 10;
        array1570[1] = 0;
        array1570[2] = 17;
        array1570[3] = 23;
        i1065[b] = array1569;
        final byte[] array1572;
        final byte[] array1571 = array1572 = new byte[n];
        array1572[0] = 9;
        array1572[1] = 0;
        array1572[2] = 23;
        array1572[3] = 20;
        i1065[al] = array1571;
        final byte[] array1574;
        final byte[] array1573 = array1574 = new byte[n];
        array1574[0] = 10;
        array1574[1] = 1;
        array1574[2] = 17;
        array1574[3] = 23;
        i1065[n2] = array1573;
        this.I1142 = i1065;
        final byte[][][] l1075 = new byte[n][][];
        final byte[][] array1575 = new byte[n][];
        final byte[] array1577;
        final byte[] array1576 = array1577 = new byte[6];
        array1577[0] = 11;
        array1577[1] = 7;
        array1577[2] = -18;
        array1577[3] = 2;
        array1577[4] = 13;
        array1577[5] = 23;
        array1575[0] = array1576;
        final byte[] array1579;
        final byte[] array1578 = array1579 = new byte[6];
        array1579[0] = 12;
        array1579[1] = 29;
        array1579[2] = -19;
        array1579[3] = 0;
        array1579[4] = 17;
        array1579[5] = 16;
        array1575[b] = array1578;
        final byte[] array1581;
        final byte[] array1580 = array1581 = new byte[6];
        array1581[0] = 11;
        array1581[1] = 28;
        array1581[2] = -45;
        array1581[3] = 2;
        array1581[4] = 13;
        array1581[5] = 23;
        array1575[al] = array1580;
        final byte[] array1583;
        final byte[] array1582 = array1583 = new byte[6];
        array1583[0] = 12;
        array1583[1] = -2;
        array1583[2] = -43;
        array1583[3] = 0;
        array1583[4] = 17;
        array1583[5] = 16;
        array1575[n2] = array1582;
        l1075[0] = array1575;
        final byte[][] array1584 = new byte[n][];
        final byte[] array1586;
        final byte[] array1585 = array1586 = new byte[6];
        array1586[0] = 13;
        array1586[1] = 44;
        array1586[2] = -2;
        array1586[3] = 1;
        array1586[4] = 17;
        array1586[5] = 14;
        array1584[0] = array1585;
        final byte[] array1588;
        final byte[] array1587 = array1588 = new byte[6];
        array1588[0] = 14;
        array1588[1] = 48;
        array1588[2] = 23;
        array1588[3] = 1;
        array1588[4] = 19;
        array1588[5] = 13;
        array1584[b] = array1587;
        final byte[] array1590;
        final byte[] array1589 = array1590 = new byte[6];
        array1590[0] = 15;
        array1590[1] = 80;
        array1590[2] = 11;
        array1590[3] = 1;
        array1590[4] = 17;
        array1590[5] = 9;
        array1584[al] = array1589;
        final byte[] array1592;
        final byte[] array1591 = array1592 = new byte[6];
        array1592[0] = 16;
        array1592[1] = 73;
        array1592[2] = 33;
        array1592[3] = 1;
        array1592[4] = 21;
        array1592[5] = 10;
        array1584[n2] = array1591;
        l1075[b] = array1584;
        final byte[][] array1593 = new byte[n][];
        final byte[] array1595;
        final byte[] array1594 = array1595 = new byte[6];
        array1595[0] = 11;
        array1595[1] = 7;
        array1595[2] = 49;
        array1595[3] = 0;
        array1595[4] = 13;
        array1595[5] = 23;
        array1593[0] = array1594;
        final byte[] array1597;
        final byte[] array1596 = array1597 = new byte[6];
        array1597[0] = 12;
        array1597[1] = 29;
        array1597[2] = 59;
        array1597[3] = 0;
        array1597[4] = 17;
        array1597[5] = 16;
        array1593[b] = array1596;
        final byte[] array1599;
        final byte[] array1598 = array1599 = new byte[6];
        array1599[0] = 11;
        array1599[1] = 28;
        array1599[2] = 84;
        array1599[3] = 1;
        array1599[4] = 13;
        array1599[5] = 23;
        array1593[al] = array1598;
        final byte[] array1601;
        final byte[] array1600 = array1601 = new byte[6];
        array1601[0] = 12;
        array1601[1] = 2;
        array1601[2] = 94;
        array1601[3] = 1;
        array1601[4] = 17;
        array1601[5] = 16;
        array1593[n2] = array1600;
        l1075[al] = array1593;
        final byte[][] array1602 = new byte[n][];
        final byte[] array1604;
        final byte[] array1603 = array1604 = new byte[6];
        array1604[0] = 13;
        array1604[1] = -15;
        array1604[2] = -2;
        array1604[3] = 0;
        array1604[4] = 17;
        array1604[5] = 14;
        array1602[0] = array1603;
        final byte[] array1606;
        final byte[] array1605 = array1606 = new byte[6];
        array1606[0] = 14;
        array1606[1] = -17;
        array1606[2] = 23;
        array1606[3] = 0;
        array1606[4] = 19;
        array1606[5] = 13;
        array1602[b] = array1605;
        final byte[] array1608;
        final byte[] array1607 = array1608 = new byte[6];
        array1608[0] = 15;
        array1608[1] = -49;
        array1608[2] = 11;
        array1608[3] = 0;
        array1608[4] = 17;
        array1608[5] = 9;
        array1602[al] = array1607;
        final byte[] array1610;
        final byte[] array1609 = array1610 = new byte[6];
        array1610[0] = 16;
        array1610[1] = -46;
        array1610[2] = 33;
        array1610[3] = 0;
        array1610[4] = 21;
        array1610[5] = 10;
        array1602[n2] = array1609;
        l1075[n2] = array1602;
        this.l1143 = l1075;
        final byte[][] j1053 = new byte[n2][];
        final byte[] array1612;
        final byte[] array1611 = array1612 = new byte[al];
        array1612[0] = -14;
        array1612[1] = -27;
        j1053[0] = array1611;
        final byte[] array1614;
        final byte[] array1613 = array1614 = new byte[al];
        array1614[0] = -14;
        array1614[1] = -32;
        j1053[b] = array1613;
        final byte[] array1616;
        final byte[] array1615 = array1616 = new byte[al];
        array1616[0] = -14;
        array1616[1] = -27;
        j1053[al] = array1615;
        this.J1144 = j1053;
        final byte[][] k1072 = new byte[n2][];
        final byte[] array1618;
        final byte[] array1617 = array1618 = new byte[al];
        array1618[0] = -14;
        array1618[1] = -11;
        k1072[0] = array1617;
        final byte[] array1620;
        final byte[] array1619 = array1620 = new byte[al];
        array1620[0] = 4;
        array1620[1] = -16;
        k1072[b] = array1619;
        final byte[] array1622;
        final byte[] array1621 = array1622 = new byte[al];
        array1622[0] = -14;
        array1622[1] = -15;
        k1072[al] = array1621;
        this.K1145 = k1072;
        final byte[][] l1076 = new byte[n2][];
        final byte[] array1624;
        final byte[] array1623 = array1624 = new byte[n];
        array1624[0] = -80;
        array1624[1] = 31;
        array1624[2] = 16;
        array1624[3] = 18;
        l1076[0] = array1623;
        final byte[] array1626;
        final byte[] array1625 = array1626 = new byte[n];
        array1626[0] = -54;
        array1626[1] = 0;
        array1626[2] = 16;
        array1626[3] = 31;
        l1076[b] = array1625;
        final byte[] array1628;
        final byte[] array1627 = array1628 = new byte[n];
        array1628[0] = -10;
        array1628[1] = 31;
        array1628[2] = 16;
        array1628[3] = 18;
        l1076[al] = array1627;
        this.L1146 = l1076;
        final byte[][] m1077 = new byte[n][];
        final byte[] array1630;
        final byte[] array1629 = array1630 = new byte[al];
        array1630[0] = 16;
        array1630[1] = -39;
        m1077[0] = array1629;
        final byte[] array1632;
        final byte[] array1631 = array1632 = new byte[al];
        array1632[0] = 46;
        array1632[1] = 14;
        m1077[b] = array1631;
        final byte[] array1634;
        final byte[] array1633 = array1634 = new byte[al];
        array1634[0] = 19;
        array1634[1] = 48;
        m1077[al] = array1633;
        final byte[] array1636;
        final byte[] array1635 = array1636 = new byte[al];
        array1636[0] = -48;
        array1636[1] = 14;
        m1077[n2] = array1635;
        this.M1147 = m1077;
        final byte[] array1637 = new byte[13];
        array1637[0] = 0;
        array1637[b] = b;
        array1637[al] = al;
        array1637[n] = (array1637[n2] = al);
        array1637[6] = (array1637[5] = al);
        array1637[8] = (array1637[7] = al);
        array1637[10] = (array1637[9] = al);
        array1637[11] = b;
        array1637[12] = 0;
        final byte[] array1638;
        final byte[] z1132 = array1638 = new byte[5];
        array1638[0] = 0;
        array1638[1] = -6;
        array1638[2] = -8;
        array1638[3] = -12;
        array1638[4] = -14;
        this.z1148 = z1132;
        final byte[][] n5 = new byte[n2][];
        final byte[] array1640;
        final byte[] array1639 = array1640 = new byte[6];
        array1640[1] = (array1640[0] = 0);
        array1640[2] = 40;
        array1640[3] = 32;
        array1640[4] = 9;
        array1640[5] = 10;
        n5[0] = array1639;
        final byte[] array1642;
        final byte[] array1641 = array1642 = new byte[6];
        array1642[0] = 40;
        array1642[1] = 0;
        array1642[2] = 36;
        array1642[3] = 29;
        array1642[5] = (array1642[4] = 11);
        n5[b] = array1641;
        final byte[] array1644;
        final byte[] array1643 = array1644 = new byte[6];
        array1644[0] = 76;
        array1644[1] = 0;
        array1644[2] = 28;
        array1644[3] = 16;
        array1644[4] = 15;
        array1644[5] = 17;
        n5[al] = array1643;
        this.N1149 = n5;
        final byte[][][] m1078 = new byte[al][][];
        final byte[][] array1645 = new byte[6][];
        final byte[] array1647;
        final byte[] array1646 = array1647 = new byte[6];
        array1647[1] = (array1647[0] = 0);
        array1647[2] = 10;
        array1647[3] = 11;
        array1647[4] = 9;
        array1647[5] = 6;
        array1645[0] = array1646;
        final byte[] array1649;
        final byte[] array1648 = array1649 = new byte[6];
        array1649[0] = 0;
        array1649[1] = 11;
        array1649[2] = 6;
        array1649[3] = 7;
        array1649[4] = 12;
        array1649[5] = 37;
        array1645[b] = array1648;
        final byte[] array1651;
        final byte[] array1650 = array1651 = new byte[6];
        array1651[0] = 6;
        array1651[1] = 11;
        array1651[2] = 12;
        array1651[3] = 5;
        array1651[4] = 0;
        array1651[5] = 23;
        array1645[al] = array1650;
        final byte[] array1653;
        final byte[] array1652 = array1653 = new byte[6];
        array1653[0] = 23;
        array1653[1] = 0;
        array1653[2] = 2;
        array1653[3] = 13;
        array1653[4] = 28;
        array1653[5] = 44;
        array1645[n2] = array1652;
        final byte[] array1655;
        final byte[] array1654 = array1655 = new byte[6];
        array1655[0] = 18;
        array1655[1] = 0;
        array1655[2] = 10;
        array1655[3] = 11;
        array1655[4] = 44;
        array1655[5] = 0;
        array1645[n] = array1654;
        final byte[] array1657;
        final byte[] array1656 = array1657 = new byte[6];
        array1657[0] = 22;
        array1657[1] = 11;
        array1657[2] = 6;
        array1657[3] = 7;
        array1657[4] = 38;
        array1657[5] = 35;
        array1645[5] = array1656;
        m1078[0] = array1645;
        final byte[][] array1658 = new byte[7][];
        final byte[] array1660;
        final byte[] array1659 = array1660 = new byte[6];
        array1660[0] = 0;
        array1660[1] = 11;
        array1660[2] = 6;
        array1660[3] = 7;
        array1660[4] = 18;
        array1660[5] = 30;
        array1658[0] = array1659;
        final byte[] array1662;
        final byte[] array1661 = array1662 = new byte[6];
        array1662[0] = 11;
        array1662[1] = 0;
        array1662[2] = 13;
        array1662[3] = 11;
        array1662[4] = 10;
        array1662[5] = 8;
        array1658[b] = array1661;
        final byte[] array1664;
        final byte[] array1663 = array1664 = new byte[6];
        array1664[0] = 6;
        array1664[1] = 11;
        array1664[2] = 12;
        array1664[3] = 5;
        array1664[4] = 12;
        array1664[5] = 24;
        array1658[al] = array1663;
        final byte[] array1666;
        final byte[] array1665 = array1666 = new byte[6];
        array1666[0] = 23;
        array1666[1] = 0;
        array1666[2] = 2;
        array1666[3] = 13;
        array1666[4] = 29;
        array1666[5] = 33;
        array1658[n2] = array1665;
        final byte[] array1668;
        final byte[] array1667 = array1668 = new byte[6];
        array1668[0] = 25;
        array1668[1] = 0;
        array1668[2] = 3;
        array1668[3] = 13;
        array1668[4] = 28;
        array1668[5] = 2;
        array1658[n] = array1667;
        final byte[] array1670;
        final byte[] array1669 = array1670 = new byte[6];
        array1670[0] = 5;
        array1670[1] = 0;
        array1670[2] = 13;
        array1670[3] = 11;
        array1670[4] = 32;
        array1670[5] = 11;
        array1658[5] = array1669;
        final byte[] array1672;
        final byte[] array1671 = array1672 = new byte[6];
        array1672[0] = 22;
        array1672[1] = 11;
        array1672[2] = 6;
        array1672[3] = 7;
        array1672[4] = 36;
        array1672[5] = 34;
        array1658[6] = array1671;
        m1078[b] = array1658;
        this.m1150 = m1078;
        final byte[] array1673;
        final byte[] a1021 = array1673 = new byte[7];
        array1673[1] = (array1673[0] = 6);
        array1673[3] = (array1673[2] = 5);
        array1673[4] = 4;
        array1673[6] = (array1673[5] = 4);
        this.A1151 = a1021;
        this.n1152 = new int[80];
        this.o1153 = new int[80];
        this.p1154 = new int[30];
        this.bA = 0;
        this.bB = 0;
        this.bC = 0;
        this.bD = 0;
        this.y1155 = (b != 0);
        this.bE = 16;
        final byte[][] o1097 = new byte[n][];
        final byte[] array1675;
        final byte[] array1674 = array1675 = new byte[al];
        array1675[1] = (array1675[0] = 0);
        o1097[0] = array1674;
        final byte[] array1677;
        final byte[] array1676 = array1677 = new byte[al];
        array1677[0] = 1;
        array1677[1] = 0;
        o1097[b] = array1676;
        final byte[] array1679;
        final byte[] array1678 = array1679 = new byte[al];
        array1679[1] = (array1679[0] = 1);
        o1097[al] = array1678;
        final byte[] array1681;
        final byte[] array1680 = array1681 = new byte[al];
        array1681[0] = 0;
        array1681[1] = 1;
        o1097[n2] = array1680;
        this.O1156 = o1097;
        final byte[][] p1101 = new byte[n][];
        final byte[] array1683;
        final byte[] array1682 = array1683 = new byte[al];
        array1683[1] = (array1683[0] = -1);
        p1101[0] = array1682;
        final byte[] array1685;
        final byte[] array1684 = array1685 = new byte[al];
        array1685[0] = 1;
        array1685[1] = -1;
        p1101[b] = array1684;
        final byte[] array1687;
        final byte[] array1686 = array1687 = new byte[al];
        array1687[1] = (array1687[0] = 1);
        p1101[al] = array1686;
        final byte[] array1689;
        final byte[] array1688 = array1689 = new byte[al];
        array1689[0] = -1;
        array1689[1] = 1;
        p1101[n2] = array1688;
        this.P1157 = p1101;
        final int[] array1690;
        final int[] q1102 = array1690 = new int[8];
        array1690[1] = (array1690[0] = 13450878);
        array1690[3] = (array1690[2] = 14567546);
        array1690[5] = (array1690[4] = 16736642);
        array1690[7] = (array1690[6] = 14567546);
        this.q1158 = q1102;
        final byte[][] q1103 = new byte[n][];
        final byte[] array1692;
        final byte[] array1691 = array1692 = new byte[al];
        array1692[0] = 0;
        array1692[1] = -1;
        q1103[0] = array1691;
        final byte[] array1694;
        final byte[] array1693 = array1694 = new byte[al];
        array1694[0] = 1;
        array1694[1] = 0;
        q1103[b] = array1693;
        final byte[] array1696;
        final byte[] array1695 = array1696 = new byte[al];
        array1696[0] = 0;
        array1696[1] = 1;
        q1103[al] = array1695;
        final byte[] array1698;
        final byte[] array1697 = array1698 = new byte[al];
        array1698[0] = -1;
        array1698[1] = 0;
        q1103[n2] = array1697;
        this.Q1159 = q1103;
        this.bK = 5;
        final int[] array1699;
        final int[] r1103 = array1699 = new int[8];
        array1699[0] = 49;
        array1699[1] = 57;
        array1699[2] = 56;
        array1699[3] = 48;
        array1699[4] = 49;
        array1699[5] = 50;
        array1699[6] = 49;
        array1699[7] = 53;
        this.r1166 = r1103;
        final int[] array1700;
        final int[] s1104 = array1700 = new int[8];
        array1700[0] = 57;
        array1700[2] = (array1700[1] = 52);
        array1700[4] = (array1700[3] = 49);
        array1700[5] = 52;
        array1700[7] = (array1700[6] = 49);
        this.s1167 = s1104;
        final int[] array1701;
        final int[] t1105 = array1701 = new int[8];
        array1701[0] = 49;
        array1701[1] = 56;
        array1701[2] = 55;
        array1701[3] = 56;
        array1701[4] = 49;
        array1701[5] = 54;
        array1701[6] = 56;
        array1701[7] = 51;
        this.t1168 = t1105;
        final String[] d1017 = new String[15];
        d1017[0] = "\u6fc0\u6d3b\u540e\u53ef\u7acb\u5373\u6d88\u706d\u5f53\u524d\u6240\u6709\u654c\u4eba\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        d1017[b] = "\u6fc0\u6d3b\u540e\u53ef\u7acb\u5373\u83b7\u5f97\u5168\u90e8\u79d1\u6280\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        d1017[al] = "\u6fc0\u6d3b\u540e\u53ef\u7acb\u5373\u83b7\u5f97500\u91d1\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        d1017[n2] = "\u6fc0\u6d3b\u540e\u53ef\u7acb\u5373\u83b7\u5f9710\u70b9\u57ce\u9632\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        d1017[n] = "\u6d88\u706d\u654c\u4eba\u52a0\u94b1\u7ffb\u500d\uff0c\u6fc0\u6d3b\u540e\u53ef\u4eab\u53d7\u6b64\u670d\u52a1\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        d1017[5] = "\u6b64\u5173\u5361\u4e3a\u6536\u8d39\u5173\u5361\uff0c\u7ee7\u7eed\u6e38\u620f\u9700\u6fc0\u6d3b\u540e\u53ef\u4eab\u53d7\u6b64\u670d\u52a1\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        d1017[6] = "\u7ee7\u7eed\u4e0a\u6b21\u9000\u51fa\u65f6\u7684\u8ba1\u8d39\u5b58\u6863\uff0c\u6fc0\u6d3b\u540e\u53ef\u4eab\u53d7\u6b64\u670d\u52a1\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        d1017[7] = "\u68c0\u67e5\u66f4\u65b0\u4e2d\u2026\u2026";
        d1017[8] = "\u6fc0\u6d3b\u4e2d\u2026\u2026";
        d1017[9] = "\u6210\u529f\uff01[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        d1017[10] = "\u8d2d\u4e70\u5931\u8d25\uff01\u662f\u5426\u91cd\u8bd5\uff1f";
        d1017[11] = "\u53d1\u9001\u77ed\u4fe1\u4e0d\u6210\u529f\uff0c\u53ef\u80fd\u56e0\u4e3a\u60a8\u4f7f\u7528\u7684\u4e0d\u662f\u5b98\u65b9\u7248\u672c\u3002\u4e0b\u8f7d\u5b98\u65b9\u7248\u672c\u8bf7\u624b\u673a\u8bbf\u95eewap.kgame.com.cn";
        d1017[12] = "\u5546\u5e97";
        d1017[13] = "\u66f4\u591a\u6e38\u620f";
        d1017[14] = "\u89c6\u9891\u4e0b\u8f7d";
        this.d1173 = d1017;
        this.D1176 = (b != 0);
        this.a1193 = null;
        this.au();
        this.aw();
        this.l = 0;
        this.al = al;
    }
    
    private void A() {
        final int n = 3;
        final int n2 = 1;
        final int n3 = -1;
        final int n4 = 2;
        if (this.m1033) {
            this.w();
        }
        else {
            switch (this.l) {
                case 0: {
                    if (this.al == n4)
                    if (this.b1032 != null) {
                        this.a1002.setClip(0, 0, 240, 320);
                        this.a1002.setColor(16777215);
                        this.a1002.fillRect(0, 0, 240, 320);
                        this.a1002.drawImage(this.b1032, 240 - this.b1032.getWidth() >> 1, 320 - this.b1032.getHeight() >> 1, 0);
                        break;
                    }
                    break;
                }
                case 19: {
                    this.y();
                    break;
                }
                case 24: {
                    this.ak();
                    this.Y();
                    this.ag();
                    this.H();
                    this.ap();
                    this.c(n4, n2);
                    break;
                }
                case 46:
                case 47:
                case 48: {
                    this.ar();
                    break;
                }
                case 18: {
                    this.h();
                    break;
                }
                case 1: {
                    this.l();
                    break;
                }
                case 15: {
                    this.q();
                    this.c(n4, n);
                    break;
                }
                case 17: {
                    this.s();
                    this.c(n4, n);
                    break;
                }
                case 16: {
                    this.v();
                    if (!this.t1089) {
                        this.c(n4, n);
                        break;
                    }
                    this.c(n4, n3);
                    break;
                }
                case 23: {
                    this.ak();
                    this.am();
                    this.ac();
                    this.H();
                    this.c(n4, n3);
                    break;
                }
                case 22: {
                    this.ak();
                    this.Y();
                    this.ag();
                    this.am();
                    this.Z();
                    this.H();
                    this.c(n4, n3);
                    break;
                }
                case 2: {
                    this.ak();
                    this.Y();
                    this.ag();
                    this.am();
                    this.H();
                    this.S();
                    this.c(n4, 0);
                    break;
                }
                case 13:
                case 14: {
                    this.ak();
                    this.Y();
                    this.ag();
                    this.am();
                    this.H();
                    this.c(n4, n2);
                    break;
                }
                case 12: {
                    this.ak();
                    this.Y();
                    this.ag();
                    this.H();
                    this.c(n4, n2);
                    break;
                }
                case 3: {
                    this.ak();
                    this.Y();
                    this.ag();
                    this.H();
                    this.j();
                    this.c(n4, n3);
                    break;
                }
                case 4:
                case 20: {
                    this.a(this.b1015[n2]);
                    if (this.l == 20) {
                        this.c(5, 240 - this.a1013[4][25].getWidth() >> 1, 0);
                    }
                    this.c(n3, n2);
                    break;
                }
                case 5:
                case 21: {
                    this.a(this.b1015[0]);
                    if (this.l == 21) {
                        this.c(4, 240 - this.a1013[4][25].getWidth() >> 1, 0);
                    }
                    this.c(n3, n2);
                    break;
                }
                case 8: {
                    this.a((boolean)(n2 != 0));
                    this.c(n4, n3);
                    break;
                }
                case 9: {
                    this.a(false);
                    this.c(n4, n3);
                    break;
                }
                case 10: {
                    this.W();
                    this.a(this.a1013[n][n], 0, 0, 13450878, (boolean)(n2 != 0));
                    this.c(n4, n3);
                    break;
                }
            }
        }
    }
    
    private void A(final int n) {
        final int[] array = this.c1107[n];
        final int[] array2 = this.b1066[array[8]];
        Label_0088: {
            switch (array[2]) {
                case 0:
                case 4: {
                    if (array[13] < 4) {
                        final int n2 = 13;
                        ++array[n2];
                    }
                    for (int i = 0; i < 5; ++i) {
                        final byte[] array3 = this.C1134[n];
                        if (--array3[i] < -1) {
                            this.C1134[n][i] = -1;
                        }
                    }
                    if (array[13] == 1) {
                        if (array[2] == 4 && array2[26] == 6) {
                            array2[27] = -1;
                        }
                        else {
                            this.v(array[8], this.a(array[2], this.s1102, array[3]), n);
                        }
                    }
                    if (this.i(n)) {
                        this.x(n);
                        break;
                    }
                    break;
                }
                case 1: {
                    final int n3 = array[0] + (this.o1098[array[2]] << 3) + (array[11] << 2);
                    final int n4 = array[1] + (this.o1098[array[2]] << 3) + (array[12] << 2);
                    final int n5 = 13;
                    final int n6 = array[n5] + 1;
                    array[n5] = n6;
                    if (n6 > 12) {
                        array[13] = 0;
                        this.x(n);
                        break;
                    }
                    if (array[13] != 4) {
                        break;
                    }
                    for (int j = 0; j < this.aP; ++j) {
                        if (a(this.b1066[j][0], this.b1066[j][1], n3 - 24, n4 - 24, 48, 48) && j != array[8]) {
                            if (array2[26] == 8) {
                                array2[27] = -1;
                            }
                            else {
                                this.v(j, this.a(array[2], this.s1102, array[3] >> 2), n);
                            }
                        }
                    }
                    if (array2[26] == 8) {
                        array2[27] = -1;
                        break;
                    }
                    this.v(array[8], this.a(array[2], this.s1102, array[3]), n);
                    break;
                }
                case 6: {
                    final int n7 = 13;
                    final int n8 = array[n7] + 1;
                    array[n7] = n8;
                    if (n8 > 5) {
                        array[13] = 0;
                        this.a(array[0], array[1], array[5], (byte)0, 0, true);
                        this.x(n);
                    }
                    else {
                        this.a(array[0], array[1], array[5], (byte)4, 0, true);
                    }
                    this.h(n, array[2], array[3], array[5]);
                    break;
                }
                case 2: {
                    final int n9 = 13;
                    final int n10 = array[n9] + 1;
                    array[n9] = n10;
                    if (n10 > 12) {
                        this.a(array[0], array[1], array[5], (byte)1, 0, true);
                        this.x(n);
                    }
                    else {
                        if (array[13] >> 2 < 3) {
                            this.a(array[0], array[1], array[5], (byte)5, (array[13] >> 2) + 1, true);
                        }
                        if (array[13] > 6 && array[13] % 3 == 0) {
                            this.a(array[0], array[1], array[5], (byte)1, (array[13] - 6) / 3 + (array[13] - 6), true);
                        }
                    }
                    this.h(n, array[2], array[3], array[5]);
                    break;
                }
                case 10: {
                    switch (array[10]) {
                        default: {
                            break Label_0088;
                        }
                        case 1: {
                            final int n11 = 13;
                            final int n12 = array[n11] + 1;
                            array[n11] = n12;
                            if (n12 > 4) {
                                final int n13 = array[0];
                                final int n14 = array[1];
                                final int n15 = array[5];
                                int n16;
                                if (this.k(array[2], array[3])) {
                                    n16 = 40;
                                }
                                else {
                                    n16 = 10;
                                }
                                this.a(n13, n14, n15, (byte)(n16 + 6), 0, true);
                                this.h(n, array[2], array[3], array[5]);
                                array[13] = 0;
                                array[10] = 2;
                                break Label_0088;
                            }
                            break Label_0088;
                        }
                        case 2: {
                            final int n17 = 13;
                            final int n18 = array[n17] + 1;
                            array[n17] = n18;
                            if (n18 > 9) {
                                this.x(n);
                                break Label_0088;
                            }
                            break Label_0088;
                        }
                    }
                    break;
                }
                case 8:
                case 9: {
                    switch (array[10]) {
                        case 0: {
                            final int n19 = 13;
                            final int n20 = array[n19] + 1;
                            array[n19] = n20;
                            if (n20 > 2) {
                                final int n21 = array[0];
                                final int n22 = array[1];
                                final int n23 = array[5];
                                byte b;
                                if (array[2] == 8) {
                                    b = 3;
                                }
                                else {
                                    b = 2;
                                }
                                int n24;
                                if (this.m(array[2], array[3])) {
                                    n24 = 0;
                                }
                                else {
                                    n24 = 2;
                                }
                                this.a(n21, n22, n23, b, n24, false);
                                array[10] = 1;
                                array[13] = 0;
                                break;
                            }
                            break;
                        }
                        case 1: {
                            final int n25 = 13;
                            final int n26 = array[n25] + 1;
                            array[n25] = n26;
                            int n27;
                            if (this.j(array[2], array[3])) {
                                n27 = 20;
                            }
                            else {
                                n27 = 10;
                            }
                            if (n26 > n27) {
                                array[10] = 2;
                                array[13] = 0;
                                break;
                            }
                            break;
                        }
                        case 2: {
                            final int n28 = 13;
                            final int n29 = array[n28] + 1;
                            array[n28] = n29;
                            if (n29 > 1) {
                                array[13] = 0;
                                final int n30 = array[0];
                                final int n31 = array[1];
                                final int n32 = array[5];
                                final byte b2 = 1;
                                int n33;
                                if (this.m(array[2], array[3])) {
                                    n33 = 0;
                                }
                                else {
                                    n33 = 2;
                                }
                                this.a(n30, n31, n32, b2, n33, false);
                                if (array[16] != 0) {
                                    array[16] = 0;
                                }
                                this.x(n);
                                break;
                            }
                            break;
                        }
                    }
                    this.h(n, array[2], array[3], array[5]);
                    break;
                }
                case 3:
                case 5:
                case 7: {
                    if (array[10] == 0) {
                        final int n34 = 13;
                        if (++array[n34] <= 12 || !this.e(n)) {
                            break;
                        }
                        array[13] = 0;
                        array[10] = 1;
                        if (array[2] == 5) {
                            this.v(array[8], this.a(array[2], this.s1102, array[3]), n);
                            break;
                        }
                        if (array[2] == 3 && array2[26] != 5) {
                            this.v(array[8], this.a(array[2], this.s1102, array[3]), n);
                            break;
                        }
                        break;
                    }
                    else {
                        if (array[10] != 1) {
                            break;
                        }
                        if (array[2] == 7 && array[13] == 3) {
                            for (int k = 0; k < this.aP; ++k) {
                                if (a(this.b1066[k][0], this.b1066[k][1], this.b1066[array[8]][0] - 24, this.b1066[array[8]][1] - 24, 48, 48) && k != array[8]) {
                                    this.v(k, this.a(array[2], this.s1102, array[3] >> 2), n);
                                }
                            }
                            this.v(array[8], this.a(array[2], this.s1102, array[3]), n);
                        }
                        final int n35 = 13;
                        final int n36 = array[n35] + 1;
                        array[n35] = n36;
                        int n37;
                        if (array[2] == 7) {
                            n37 = 16;
                        }
                        else {
                            n37 = 6;
                        }
                        if (n36 > n37) {
                            this.x(n);
                            break;
                        }
                        break;
                    }
                    break;
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
    
    private void B(final int i) {
        this.getClass();
        final InputStream resourceAsStream = Display.getResourceAsStream(new StringBuffer().append("/mapdatalv").append(i).toString());
        try {
            this.bG = a(resourceAsStream);
            this.bH = a(resourceAsStream);
            final int bg = this.bG;
            try {
                final int n = bg * this.bH;
                this.bI = this.bG << 4;
                this.bJ = this.bH << 4;
                this.B1160 = new byte[n];
                this.C1161 = new byte[n];
                resourceAsStream.read(this.B1160, 0, n);
                resourceAsStream.read(this.C1161, 0, n);
                resourceAsStream.close();
            }
            catch (final Exception ex) {}
        }
        catch (final Exception ex2) {}
    }
    
    private final void C() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: istore_1       
        //     3: iconst_1       
        //     4: istore_2       
        //     5: ldc_w           "sanGuoTd"
        //     8: astore_3       
        //     9: iconst_0       
        //    10: istore          4
        //    12: aconst_null    
        //    13: astore          5
        //    15: aload_3        
        //    16: iconst_0       
        //    17: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //    20: astore          5
        //    22: iconst_0       
        //    23: istore          6
        //    25: aconst_null    
        //    26: astore_3       
        //    27: new             Ljava/io/ByteArrayOutputStream;
        //    30: astore          7
        //    32: aload           7
        //    34: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    37: new             Ljava/io/DataOutputStream;
        //    40: astore          8
        //    42: aload           8
        //    44: aload           7
        //    46: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    49: aload_0        
        //    50: getfield        a.aP:I
        //    53: istore          9
        //    55: aload           8
        //    57: iload           9
        //    59: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //    62: iconst_0       
        //    63: istore          9
        //    65: aconst_null    
        //    66: astore          10
        //    68: aload_0        
        //    69: getfield        a.aP:I
        //    72: istore          11
        //    74: iload           9
        //    76: iload           11
        //    78: if_icmpge       167
        //    81: iconst_0       
        //    82: istore          11
        //    84: aconst_null    
        //    85: astore          12
        //    87: bipush          28
        //    89: istore          13
        //    91: iload           11
        //    93: iload           13
        //    95: if_icmpge       158
        //    98: aload_0        
        //    99: getfield        a.b1066:[[I
        //   102: astore          14
        //   104: aload           14
        //   106: iload           9
        //   108: aaload         
        //   109: astore          14
        //   111: aload           14
        //   113: iload           11
        //   115: iaload         
        //   116: istore          13
        //   118: aload           8
        //   120: iload           13
        //   122: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   125: iload           11
        //   127: iconst_1       
        //   128: iadd           
        //   129: istore          11
        //   131: goto            87
        //   134: astore_3       
        //   135: ldc_w           "sanGuoTd"
        //   138: astore_3       
        //   139: iconst_1       
        //   140: istore          4
        //   142: aload_3        
        //   143: iload           4
        //   145: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //   148: astore_3       
        //   149: aload_3        
        //   150: astore          5
        //   152: iload_2        
        //   153: istore          6
        //   155: goto            27
        //   158: iload           9
        //   160: iconst_1       
        //   161: iadd           
        //   162: istore          9
        //   164: goto            68
        //   167: aload_0        
        //   168: getfield        a.bt:I
        //   171: istore          9
        //   173: aload           8
        //   175: iload           9
        //   177: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   180: iconst_0       
        //   181: istore          9
        //   183: aconst_null    
        //   184: astore          10
        //   186: aload_0        
        //   187: getfield        a.bt:I
        //   190: istore          11
        //   192: iload           9
        //   194: iload           11
        //   196: if_icmpge       261
        //   199: iconst_0       
        //   200: istore          11
        //   202: aconst_null    
        //   203: astore          12
        //   205: bipush          18
        //   207: istore          13
        //   209: iload           11
        //   211: iload           13
        //   213: if_icmpge       252
        //   216: aload_0        
        //   217: getfield        a.c1107:[[I
        //   220: astore          14
        //   222: aload           14
        //   224: iload           9
        //   226: aaload         
        //   227: astore          14
        //   229: aload           14
        //   231: iload           11
        //   233: iaload         
        //   234: istore          13
        //   236: aload           8
        //   238: iload           13
        //   240: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   243: iload           11
        //   245: iconst_1       
        //   246: iadd           
        //   247: istore          11
        //   249: goto            205
        //   252: iload           9
        //   254: iconst_1       
        //   255: iadd           
        //   256: istore          9
        //   258: goto            186
        //   261: iconst_0       
        //   262: istore          9
        //   264: aconst_null    
        //   265: astore          10
        //   267: iconst_5       
        //   268: istore          11
        //   270: iload           9
        //   272: iload           11
        //   274: if_icmpge       323
        //   277: aload_0        
        //   278: getfield        a.a1056:[Z
        //   281: astore          12
        //   283: aload           12
        //   285: iload           9
        //   287: baload         
        //   288: istore          11
        //   290: iload           11
        //   292: ifne            317
        //   295: iconst_0       
        //   296: istore          11
        //   298: aconst_null    
        //   299: astore          12
        //   301: aload           8
        //   303: iload           11
        //   305: invokevirtual   java/io/DataOutputStream.writeBoolean:(Z)V
        //   308: iload           9
        //   310: iconst_1       
        //   311: iadd           
        //   312: istore          9
        //   314: goto            267
        //   317: iload_2        
        //   318: istore          11
        //   320: goto            301
        //   323: iconst_0       
        //   324: istore          9
        //   326: aconst_null    
        //   327: astore          10
        //   329: bipush          10
        //   331: istore          11
        //   333: iload           9
        //   335: iload           11
        //   337: if_icmpge       386
        //   340: aload_0        
        //   341: getfield        a.b1059:[Z
        //   344: astore          12
        //   346: aload           12
        //   348: iload           9
        //   350: baload         
        //   351: istore          11
        //   353: iload           11
        //   355: ifne            380
        //   358: iconst_0       
        //   359: istore          11
        //   361: aconst_null    
        //   362: astore          12
        //   364: aload           8
        //   366: iload           11
        //   368: invokevirtual   java/io/DataOutputStream.writeBoolean:(Z)V
        //   371: iload           9
        //   373: iconst_1       
        //   374: iadd           
        //   375: istore          9
        //   377: goto            329
        //   380: iload_2        
        //   381: istore          11
        //   383: goto            364
        //   386: iconst_0       
        //   387: istore          9
        //   389: aconst_null    
        //   390: astore          10
        //   392: iload           9
        //   394: iload_1        
        //   395: if_icmpge       444
        //   398: aload_0        
        //   399: getfield        a.e1105:[Z
        //   402: astore          12
        //   404: aload           12
        //   406: iload           9
        //   408: baload         
        //   409: istore          11
        //   411: iload           11
        //   413: ifne            438
        //   416: iconst_0       
        //   417: istore          11
        //   419: aconst_null    
        //   420: astore          12
        //   422: aload           8
        //   424: iload           11
        //   426: invokevirtual   java/io/DataOutputStream.writeBoolean:(Z)V
        //   429: iload           9
        //   431: iconst_1       
        //   432: iadd           
        //   433: istore          9
        //   435: goto            392
        //   438: iload_2        
        //   439: istore          11
        //   441: goto            422
        //   444: iconst_0       
        //   445: istore          9
        //   447: aconst_null    
        //   448: astore          10
        //   450: iload           9
        //   452: iload_1        
        //   453: if_icmpge       502
        //   456: aload_0        
        //   457: getfield        a.f1106:[Z
        //   460: astore          12
        //   462: aload           12
        //   464: iload           9
        //   466: baload         
        //   467: istore          11
        //   469: iload           11
        //   471: ifne            496
        //   474: iconst_0       
        //   475: istore          11
        //   477: aconst_null    
        //   478: astore          12
        //   480: aload           8
        //   482: iload           11
        //   484: invokevirtual   java/io/DataOutputStream.writeBoolean:(Z)V
        //   487: iload           9
        //   489: iconst_1       
        //   490: iadd           
        //   491: istore          9
        //   493: goto            450
        //   496: iload_2        
        //   497: istore          11
        //   499: goto            480
        //   502: aload_0        
        //   503: getfield        a.aq:I
        //   506: istore          9
        //   508: aload           8
        //   510: iload           9
        //   512: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   515: aload_0        
        //   516: getfield        a.bj:I
        //   519: istore          9
        //   521: aload           8
        //   523: iload           9
        //   525: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   528: aload_0        
        //   529: getfield        a.bN:I
        //   532: istore          9
        //   534: aload           8
        //   536: iload           9
        //   538: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   541: aload_0        
        //   542: getfield        a.bO:I
        //   545: istore          9
        //   547: aload           8
        //   549: iload           9
        //   551: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   554: aload_0        
        //   555: getfield        a.bP:I
        //   558: istore          9
        //   560: aload           8
        //   562: iload           9
        //   564: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   567: aload_0        
        //   568: getfield        a.bQ:I
        //   571: istore          9
        //   573: aload           8
        //   575: iload           9
        //   577: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   580: aload_0        
        //   581: getfield        a.T:I
        //   584: istore          9
        //   586: aload           8
        //   588: iload           9
        //   590: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   593: aload_0        
        //   594: getfield        a.aO:I
        //   597: istore          9
        //   599: aload           8
        //   601: iload           9
        //   603: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   606: aload_0        
        //   607: getfield        a.aS:I
        //   610: istore          9
        //   612: aload           8
        //   614: iload           9
        //   616: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   619: aload_0        
        //   620: getfield        a.X:I
        //   623: istore          9
        //   625: aload           8
        //   627: iload           9
        //   629: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   632: aload_0        
        //   633: getfield        a.bz:I
        //   636: istore          9
        //   638: aload           8
        //   640: iload           9
        //   642: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   645: aload_0        
        //   646: getfield        a.by:I
        //   649: istore          9
        //   651: aload           8
        //   653: iload           9
        //   655: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   658: aload_0        
        //   659: getfield        a.aT:I
        //   662: istore          9
        //   664: aload           8
        //   666: iload           9
        //   668: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   671: aload_0        
        //   672: getfield        a.aQ:I
        //   675: istore          9
        //   677: aload           8
        //   679: iload           9
        //   681: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   684: aload_0        
        //   685: getfield        a.ay:I
        //   688: istore          9
        //   690: aload           8
        //   692: iload           9
        //   694: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   697: aload_0        
        //   698: getfield        a.az:I
        //   701: istore          9
        //   703: aload           8
        //   705: iload           9
        //   707: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   710: aload_0        
        //   711: getfield        a.p1078:Z
        //   714: istore          9
        //   716: aload           8
        //   718: iload           9
        //   720: invokevirtual   java/io/DataOutputStream.writeBoolean:(Z)V
        //   723: aload_0        
        //   724: getfield        a.bL:I
        //   727: istore          9
        //   729: aload           8
        //   731: iload           9
        //   733: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   736: aload_0        
        //   737: getfield        a.bM:I
        //   740: istore          9
        //   742: aload           8
        //   744: iload           9
        //   746: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   749: aload_0        
        //   750: getfield        a.ac:I
        //   753: istore          9
        //   755: aload           8
        //   757: iload           9
        //   759: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   762: aload_0        
        //   763: getfield        a.aV:I
        //   766: istore          9
        //   768: aload           8
        //   770: iload           9
        //   772: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   775: aload_0        
        //   776: getfield        a.aW:I
        //   779: istore          9
        //   781: aload           8
        //   783: iload           9
        //   785: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   788: aload_0        
        //   789: getfield        a.aX:I
        //   792: istore          9
        //   794: aload           8
        //   796: iload           9
        //   798: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   801: aload_0        
        //   802: getfield        a.aY:I
        //   805: istore          9
        //   807: aload           8
        //   809: iload           9
        //   811: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   814: aload_0        
        //   815: getfield        a.aZ:I
        //   818: istore          9
        //   820: aload           8
        //   822: iload           9
        //   824: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   827: aload_0        
        //   828: getfield        a.ba:I
        //   831: istore          9
        //   833: aload           8
        //   835: iload           9
        //   837: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   840: aload_0        
        //   841: getfield        a.bb:I
        //   844: istore          9
        //   846: aload           8
        //   848: iload           9
        //   850: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   853: aload_0        
        //   854: getfield        a.z1169:Z
        //   857: istore          9
        //   859: aload           8
        //   861: iload           9
        //   863: invokevirtual   java/io/DataOutputStream.writeBoolean:(Z)V
        //   866: iload           6
        //   868: ifeq            916
        //   871: aload           7
        //   873: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   876: astore_3       
        //   877: iconst_0       
        //   878: istore          9
        //   880: aconst_null    
        //   881: astore          10
        //   883: aload           7
        //   885: invokevirtual   java/io/ByteArrayOutputStream.size:()I
        //   888: istore          11
        //   890: aload           5
        //   892: aload_3        
        //   893: iconst_0       
        //   894: iload           11
        //   896: invokevirtual   javax/microedition/rms/RecordStore.addRecord:([BII)I
        //   899: pop            
        //   900: aload           8
        //   902: invokevirtual   java/io/DataOutputStream.close:()V
        //   905: aload           7
        //   907: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //   910: aload           5
        //   912: invokevirtual   javax/microedition/rms/RecordStore.closeRecordStore:()V
        //   915: return         
        //   916: iconst_1       
        //   917: istore          6
        //   919: aload           7
        //   921: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   924: astore          10
        //   926: iconst_0       
        //   927: istore          11
        //   929: aconst_null    
        //   930: astore          12
        //   932: aload           7
        //   934: invokevirtual   java/io/ByteArrayOutputStream.size:()I
        //   937: istore          13
        //   939: aload           5
        //   941: iload           6
        //   943: aload           10
        //   945: iconst_0       
        //   946: iload           13
        //   948: invokevirtual   javax/microedition/rms/RecordStore.setRecord:(I[BII)V
        //   951: goto            900
        //   954: astore_3       
        //   955: aload_3        
        //   956: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   959: goto            915
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                 
        //  -----  -----  -----  -----  -----------------------------------------------------
        //  16     20     134    158    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  16     20     954    962    Ljava/lang/Exception;
        //  27     30     954    962    Ljava/lang/Exception;
        //  32     37     954    962    Ljava/lang/Exception;
        //  37     40     954    962    Ljava/lang/Exception;
        //  44     49     954    962    Ljava/lang/Exception;
        //  49     53     954    962    Ljava/lang/Exception;
        //  57     62     954    962    Ljava/lang/Exception;
        //  68     72     954    962    Ljava/lang/Exception;
        //  98     102    954    962    Ljava/lang/Exception;
        //  106    109    954    962    Ljava/lang/Exception;
        //  113    116    954    962    Ljava/lang/Exception;
        //  120    125    954    962    Ljava/lang/Exception;
        //  143    148    954    962    Ljava/lang/Exception;
        //  167    171    954    962    Ljava/lang/Exception;
        //  175    180    954    962    Ljava/lang/Exception;
        //  186    190    954    962    Ljava/lang/Exception;
        //  216    220    954    962    Ljava/lang/Exception;
        //  224    227    954    962    Ljava/lang/Exception;
        //  231    234    954    962    Ljava/lang/Exception;
        //  238    243    954    962    Ljava/lang/Exception;
        //  277    281    954    962    Ljava/lang/Exception;
        //  285    288    954    962    Ljava/lang/Exception;
        //  303    308    954    962    Ljava/lang/Exception;
        //  340    344    954    962    Ljava/lang/Exception;
        //  348    351    954    962    Ljava/lang/Exception;
        //  366    371    954    962    Ljava/lang/Exception;
        //  398    402    954    962    Ljava/lang/Exception;
        //  406    409    954    962    Ljava/lang/Exception;
        //  424    429    954    962    Ljava/lang/Exception;
        //  456    460    954    962    Ljava/lang/Exception;
        //  464    467    954    962    Ljava/lang/Exception;
        //  482    487    954    962    Ljava/lang/Exception;
        //  502    506    954    962    Ljava/lang/Exception;
        //  510    515    954    962    Ljava/lang/Exception;
        //  515    519    954    962    Ljava/lang/Exception;
        //  523    528    954    962    Ljava/lang/Exception;
        //  528    532    954    962    Ljava/lang/Exception;
        //  536    541    954    962    Ljava/lang/Exception;
        //  541    545    954    962    Ljava/lang/Exception;
        //  549    554    954    962    Ljava/lang/Exception;
        //  554    558    954    962    Ljava/lang/Exception;
        //  562    567    954    962    Ljava/lang/Exception;
        //  567    571    954    962    Ljava/lang/Exception;
        //  575    580    954    962    Ljava/lang/Exception;
        //  580    584    954    962    Ljava/lang/Exception;
        //  588    593    954    962    Ljava/lang/Exception;
        //  593    597    954    962    Ljava/lang/Exception;
        //  601    606    954    962    Ljava/lang/Exception;
        //  606    610    954    962    Ljava/lang/Exception;
        //  614    619    954    962    Ljava/lang/Exception;
        //  619    623    954    962    Ljava/lang/Exception;
        //  627    632    954    962    Ljava/lang/Exception;
        //  632    636    954    962    Ljava/lang/Exception;
        //  640    645    954    962    Ljava/lang/Exception;
        //  645    649    954    962    Ljava/lang/Exception;
        //  653    658    954    962    Ljava/lang/Exception;
        //  658    662    954    962    Ljava/lang/Exception;
        //  666    671    954    962    Ljava/lang/Exception;
        //  671    675    954    962    Ljava/lang/Exception;
        //  679    684    954    962    Ljava/lang/Exception;
        //  684    688    954    962    Ljava/lang/Exception;
        //  692    697    954    962    Ljava/lang/Exception;
        //  697    701    954    962    Ljava/lang/Exception;
        //  705    710    954    962    Ljava/lang/Exception;
        //  710    714    954    962    Ljava/lang/Exception;
        //  718    723    954    962    Ljava/lang/Exception;
        //  723    727    954    962    Ljava/lang/Exception;
        //  731    736    954    962    Ljava/lang/Exception;
        //  736    740    954    962    Ljava/lang/Exception;
        //  744    749    954    962    Ljava/lang/Exception;
        //  749    753    954    962    Ljava/lang/Exception;
        //  757    762    954    962    Ljava/lang/Exception;
        //  762    766    954    962    Ljava/lang/Exception;
        //  770    775    954    962    Ljava/lang/Exception;
        //  775    779    954    962    Ljava/lang/Exception;
        //  783    788    954    962    Ljava/lang/Exception;
        //  788    792    954    962    Ljava/lang/Exception;
        //  796    801    954    962    Ljava/lang/Exception;
        //  801    805    954    962    Ljava/lang/Exception;
        //  809    814    954    962    Ljava/lang/Exception;
        //  814    818    954    962    Ljava/lang/Exception;
        //  822    827    954    962    Ljava/lang/Exception;
        //  827    831    954    962    Ljava/lang/Exception;
        //  835    840    954    962    Ljava/lang/Exception;
        //  840    844    954    962    Ljava/lang/Exception;
        //  848    853    954    962    Ljava/lang/Exception;
        //  853    857    954    962    Ljava/lang/Exception;
        //  861    866    954    962    Ljava/lang/Exception;
        //  871    876    954    962    Ljava/lang/Exception;
        //  883    888    954    962    Ljava/lang/Exception;
        //  894    900    954    962    Ljava/lang/Exception;
        //  900    905    954    962    Ljava/lang/Exception;
        //  905    910    954    962    Ljava/lang/Exception;
        //  910    915    954    962    Ljava/lang/Exception;
        //  919    924    954    962    Ljava/lang/Exception;
        //  932    937    954    962    Ljava/lang/Exception;
        //  946    951    954    962    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0068:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void C(final int i) {
        this.getClass();
        final InputStream resourceAsStream = Display.getResourceAsStream(new StringBuffer().append("/mapdata").append(i).toString());
        try {
            final int read = resourceAsStream.read();
            try {
                final int len = read * resourceAsStream.read();
                this.E1163 = new byte[len];
                this.D1162 = new byte[len];
                resourceAsStream.read(this.E1163, 0, len);
            }
            catch (final Exception ex) {}
        }
        catch (final Exception ex2) {}
    }
    
    private final void D() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_1       
        //     2: iconst_0       
        //     3: istore_2       
        //     4: ldc_w           "sanGuoTdData"
        //     7: astore_3       
        //     8: iconst_0       
        //     9: istore          4
        //    11: aconst_null    
        //    12: astore          5
        //    14: aload_3        
        //    15: iconst_0       
        //    16: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //    19: astore          5
        //    21: iconst_0       
        //    22: istore          6
        //    24: aconst_null    
        //    25: astore_3       
        //    26: new             Ljava/io/ByteArrayOutputStream;
        //    29: astore          7
        //    31: aload           7
        //    33: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    36: new             Ljava/io/DataOutputStream;
        //    39: astore          8
        //    41: aload           8
        //    43: aload           7
        //    45: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    48: iconst_0       
        //    49: istore          9
        //    51: aconst_null    
        //    52: astore          10
        //    54: aload_0        
        //    55: getfield        a.E1163:[B
        //    58: astore          11
        //    60: aload           11
        //    62: arraylength    
        //    63: istore          12
        //    65: iload           9
        //    67: iload           12
        //    69: if_icmpge       125
        //    72: aload_0        
        //    73: getfield        a.E1163:[B
        //    76: astore          11
        //    78: aload           11
        //    80: iload           9
        //    82: baload         
        //    83: istore          12
        //    85: aload           8
        //    87: iload           12
        //    89: invokevirtual   java/io/DataOutputStream.writeByte:(I)V
        //    92: iload           9
        //    94: iconst_1       
        //    95: iadd           
        //    96: istore          9
        //    98: goto            54
        //   101: astore_3       
        //   102: ldc_w           "sanGuoTdData"
        //   105: astore_3       
        //   106: iconst_1       
        //   107: istore          4
        //   109: aload_3        
        //   110: iload           4
        //   112: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //   115: astore_3       
        //   116: aload_3        
        //   117: astore          5
        //   119: iload_1        
        //   120: istore          6
        //   122: goto            26
        //   125: iconst_0       
        //   126: istore          9
        //   128: aconst_null    
        //   129: astore          10
        //   131: aload_0        
        //   132: getfield        a.D1162:[B
        //   135: astore          11
        //   137: aload           11
        //   139: arraylength    
        //   140: istore          12
        //   142: iload           9
        //   144: iload           12
        //   146: if_icmpge       178
        //   149: aload_0        
        //   150: getfield        a.D1162:[B
        //   153: astore          11
        //   155: aload           11
        //   157: iload           9
        //   159: baload         
        //   160: istore          12
        //   162: aload           8
        //   164: iload           12
        //   166: invokevirtual   java/io/DataOutputStream.writeByte:(I)V
        //   169: iload           9
        //   171: iconst_1       
        //   172: iadd           
        //   173: istore          9
        //   175: goto            131
        //   178: iload           6
        //   180: ifeq            228
        //   183: aload           7
        //   185: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   188: astore_3       
        //   189: iconst_0       
        //   190: istore          9
        //   192: aconst_null    
        //   193: astore          10
        //   195: aload           7
        //   197: invokevirtual   java/io/ByteArrayOutputStream.size:()I
        //   200: istore          12
        //   202: aload           5
        //   204: aload_3        
        //   205: iconst_0       
        //   206: iload           12
        //   208: invokevirtual   javax/microedition/rms/RecordStore.addRecord:([BII)I
        //   211: pop            
        //   212: aload           8
        //   214: invokevirtual   java/io/DataOutputStream.close:()V
        //   217: aload           7
        //   219: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //   222: aload           5
        //   224: invokevirtual   javax/microedition/rms/RecordStore.closeRecordStore:()V
        //   227: return         
        //   228: iconst_1       
        //   229: istore          6
        //   231: aload           7
        //   233: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   236: astore          10
        //   238: iconst_0       
        //   239: istore          12
        //   241: aconst_null    
        //   242: astore          11
        //   244: aload           7
        //   246: invokevirtual   java/io/ByteArrayOutputStream.size:()I
        //   249: istore_2       
        //   250: aload           5
        //   252: iload           6
        //   254: aload           10
        //   256: iconst_0       
        //   257: iload_2        
        //   258: invokevirtual   javax/microedition/rms/RecordStore.setRecord:(I[BII)V
        //   261: goto            212
        //   264: astore_3       
        //   265: aload_3        
        //   266: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   269: goto            227
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                 
        //  -----  -----  -----  -----  -----------------------------------------------------
        //  15     19     101    125    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  15     19     264    272    Ljava/lang/Exception;
        //  26     29     264    272    Ljava/lang/Exception;
        //  31     36     264    272    Ljava/lang/Exception;
        //  36     39     264    272    Ljava/lang/Exception;
        //  43     48     264    272    Ljava/lang/Exception;
        //  54     58     264    272    Ljava/lang/Exception;
        //  60     63     264    272    Ljava/lang/Exception;
        //  72     76     264    272    Ljava/lang/Exception;
        //  80     83     264    272    Ljava/lang/Exception;
        //  87     92     264    272    Ljava/lang/Exception;
        //  110    115    264    272    Ljava/lang/Exception;
        //  131    135    264    272    Ljava/lang/Exception;
        //  137    140    264    272    Ljava/lang/Exception;
        //  149    153    264    272    Ljava/lang/Exception;
        //  157    160    264    272    Ljava/lang/Exception;
        //  164    169    264    272    Ljava/lang/Exception;
        //  183    188    264    272    Ljava/lang/Exception;
        //  195    200    264    272    Ljava/lang/Exception;
        //  206    212    264    272    Ljava/lang/Exception;
        //  212    217    264    272    Ljava/lang/Exception;
        //  217    222    264    272    Ljava/lang/Exception;
        //  222    227    264    272    Ljava/lang/Exception;
        //  231    236    264    272    Ljava/lang/Exception;
        //  244    249    264    272    Ljava/lang/Exception;
        //  257    261    264    272    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0054:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void D(final int i) {
        this.getClass();
        final InputStream resourceAsStream = Display.getResourceAsStream(new StringBuffer().append("/mapsp").append(i).toString());
        try {
            final short a = a(resourceAsStream);
            try {
                final int n = a * a(resourceAsStream);
                this.F1164 = new byte[n];
                this.G1165 = new byte[n];
                resourceAsStream.read(this.F1164, 0, n);
                resourceAsStream.read(this.G1165, 0, n);
                resourceAsStream.close();
            }
            catch (final Exception ex) {}
        }
        catch (final Exception ex2) {}
    }
    
    private void E() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_1       
        //     2: iconst_0       
        //     3: istore_2       
        //     4: ldc_w           "freeGame"
        //     7: astore_3       
        //     8: iconst_0       
        //     9: istore          4
        //    11: aconst_null    
        //    12: astore          5
        //    14: aload_3        
        //    15: iconst_0       
        //    16: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //    19: astore          5
        //    21: iconst_0       
        //    22: istore          6
        //    24: aconst_null    
        //    25: astore_3       
        //    26: new             Ljava/io/ByteArrayOutputStream;
        //    29: astore          7
        //    31: aload           7
        //    33: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    36: new             Ljava/io/DataOutputStream;
        //    39: astore          8
        //    41: aload           8
        //    43: aload           7
        //    45: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    48: iconst_0       
        //    49: istore          9
        //    51: aconst_null    
        //    52: astore          10
        //    54: bipush          9
        //    56: istore          11
        //    58: iload           9
        //    60: iload           11
        //    62: if_icmpge       135
        //    65: aload_0        
        //    66: getfield        a.d1073:[Z
        //    69: astore          12
        //    71: aload           12
        //    73: iload           9
        //    75: baload         
        //    76: istore          11
        //    78: iload           11
        //    80: ifne            129
        //    83: iconst_0       
        //    84: istore          11
        //    86: aconst_null    
        //    87: astore          12
        //    89: aload           8
        //    91: iload           11
        //    93: invokevirtual   java/io/DataOutputStream.writeBoolean:(Z)V
        //    96: iload           9
        //    98: iconst_1       
        //    99: iadd           
        //   100: istore          9
        //   102: goto            54
        //   105: astore_3       
        //   106: ldc_w           "freeGame"
        //   109: astore_3       
        //   110: iconst_1       
        //   111: istore          4
        //   113: aload_3        
        //   114: iload           4
        //   116: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //   119: astore_3       
        //   120: aload_3        
        //   121: astore          5
        //   123: iload_1        
        //   124: istore          6
        //   126: goto            26
        //   129: iload_1        
        //   130: istore          11
        //   132: goto            89
        //   135: iload           6
        //   137: ifeq            185
        //   140: aload           7
        //   142: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   145: astore_3       
        //   146: iconst_0       
        //   147: istore          9
        //   149: aconst_null    
        //   150: astore          10
        //   152: aload           7
        //   154: invokevirtual   java/io/ByteArrayOutputStream.size:()I
        //   157: istore          11
        //   159: aload           5
        //   161: aload_3        
        //   162: iconst_0       
        //   163: iload           11
        //   165: invokevirtual   javax/microedition/rms/RecordStore.addRecord:([BII)I
        //   168: pop            
        //   169: aload           8
        //   171: invokevirtual   java/io/DataOutputStream.close:()V
        //   174: aload           7
        //   176: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //   179: aload           5
        //   181: invokevirtual   javax/microedition/rms/RecordStore.closeRecordStore:()V
        //   184: return         
        //   185: iconst_1       
        //   186: istore          6
        //   188: aload           7
        //   190: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   193: astore          10
        //   195: iconst_0       
        //   196: istore          11
        //   198: aconst_null    
        //   199: astore          12
        //   201: aload           7
        //   203: invokevirtual   java/io/ByteArrayOutputStream.size:()I
        //   206: istore_2       
        //   207: aload           5
        //   209: iload           6
        //   211: aload           10
        //   213: iconst_0       
        //   214: iload_2        
        //   215: invokevirtual   javax/microedition/rms/RecordStore.setRecord:(I[BII)V
        //   218: goto            169
        //   221: astore_3       
        //   222: aload_3        
        //   223: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //   226: goto            184
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                 
        //  -----  -----  -----  -----  -----------------------------------------------------
        //  15     19     105    129    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  15     19     221    229    Ljava/lang/Exception;
        //  26     29     221    229    Ljava/lang/Exception;
        //  31     36     221    229    Ljava/lang/Exception;
        //  36     39     221    229    Ljava/lang/Exception;
        //  43     48     221    229    Ljava/lang/Exception;
        //  65     69     221    229    Ljava/lang/Exception;
        //  73     76     221    229    Ljava/lang/Exception;
        //  91     96     221    229    Ljava/lang/Exception;
        //  114    119    221    229    Ljava/lang/Exception;
        //  140    145    221    229    Ljava/lang/Exception;
        //  152    157    221    229    Ljava/lang/Exception;
        //  163    169    221    229    Ljava/lang/Exception;
        //  169    174    221    229    Ljava/lang/Exception;
        //  174    179    221    229    Ljava/lang/Exception;
        //  179    184    221    229    Ljava/lang/Exception;
        //  188    193    221    229    Ljava/lang/Exception;
        //  201    206    221    229    Ljava/lang/Exception;
        //  214    218    221    229    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0054:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void E(final int n) {
        final int y1155 = 1;
        this.a1004 = Image.createImage(256, 304);
        this.b1003 = this.a1004.getGraphics();
        this.y1155 = (y1155 != 0);
        this.bL = this.m1075[n] + 5;
        this.bM = this.n1076[n] + 34 - y1155;
        this.c(this.bL);
        this.bK = this.bL;
        if (n != 0) {
            this.c(this.bM);
            this.D(n);
        }
        this.B(n);
        this.C(n);
    }
    
    private void F() {
        final int n = -1;
        for (int i = 0; i < 15; ++i) {
            this.h1041[i] = n;
            if (i < 1) {
                this.i1044[i] = n;
            }
        }
    }
    
    private void F(final int n) {
        this.bW = (byte)n;
        if (this.E1179) {
            this.b1174 = 0;
            this.a(46);
        }
        else if (this.f()) {
            this.F(n);
        }
    }
    
    private void G() {
        final int n = -1;
        final int r = 5;
        final int n2 = 10;
        final int n3 = 1;
        this.c1020 = false;
        if (this.i1048 >= 0) {
            ++this.i1048;
        }
        StringBuffer append;
        StringBuffer append2;
        String string;
        int ak;
        int r2;
        int r3;
        Block_35_Outer:Label_1162_Outer:
        while (true) {
        Label_1120_Outer:
            while (true) {
            Label_0638_Outer:
                while (true) {
                Label_0652_Outer:
                    while (true) {
                    Label_1074_Outer:
                        while (true) {
                        Label_1074:
                            while (true) {
                            Label_1736_Outer:
                                while (true) {
                                Label_1516_Outer:
                                    while (true) {
                                    Label_0678_Outer:
                                        while (true) {
                                        Label_1204_Outer:
                                            while (true) {
                                            Label_0667_Outer:
                                                while (true) {
                                                Label_1729_Outer:
                                                    while (true) {
                                                        while (true) {
                                                            switch (this.l) {
                                                                case 24: {
                                                                    this.aq();
                                                                    break;
                                                                }
                                                                case 46: {
                                                                    this.as();
                                                                    break;
                                                                }
                                                                case 48: {
                                                                    if (this.g()) {
                                                                        this.E1179 = (n3 != 0);
                                                                        this.a();
                                                                        this.F(this.bW);
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                                case 19: {
                                                                    break Block_35_Outer;
                                                                }
                                                                case 18: {
                                                                    break Block_35_Outer;
                                                                }
                                                                case 0: {
                                                                    if (this.al == 2) {
                                                                        if (this.ak == 0) {
                                                                            this.l1031 = (n3 != 0);
                                                                            this.F();
                                                                        }
                                                                        if (++this.ak <= 35) {
                                                                            this.f(0, this.ak);
                                                                            break;
                                                                        }
                                                                        this.f(n);
                                                                        this.n1036 = false;
                                                                        this.am = 0;
                                                                        this.ak = 0;
                                                                        this.c(2);
                                                                        this.k();
                                                                        break;
                                                                    }
                                                                    else {
                                                                        if (this.b1032 == null)
                                                                        break Block_35_Outer;
                                                                    }
                                                                    break;
                                                                }
                                                                case 1: {
                                                                    Label_0624: {
                                                                        break Label_0624;
                                                                        try {
                                                                            try {
                                                                                append = new StringBuffer().append("/l");
                                                                                try {
                                                                                    append2 = append.append(this.al).append(".png");
                                                                                    try {
                                                                                        string = append2.toString();
                                                                                        try {
                                                                                            this.b1032 = Image.createImage(string);
                                                                                            if (++this.ak > n2 && this.al < 2) {
                                                                                                this.b1032 = null;
                                                                                                ++this.al;
                                                                                                this.ak = 0;
                                                                                                break;
                                                                                            }
                                                                                            break;
                                                                                            Block_21: {
                                                                                                Block_30: {
                                                                                                    Block_38: {
                                                                                                        Block_40: {
                                                                                                            while (true) {
                                                                                                                Block_28: {
                                                                                                                    while (true) {
                                                                                                                        while (true) {
                                                                                                                            Block_32: {
                                                                                                                                Block_27_Outer:Label_0794_Outer:
                                                                                                                                while (true) {
                                                                                                                                    Block_39: {
                                                                                                                                        while (true) {
                                                                                                                                            while (true) {
                                                                                                                                                while (true) {
                                                                                                                                                    while (true) {
                                                                                                                                                        Label_0876: {
                                                                                                                                                            Block_23_Outer:Block_31_Outer:
                                                                                                                                                            while (true) {
                                                                                                                                                                this.s1088 = (n3 != 0);
                                                                                                                                                                this.U();
                                                                                                                                                                this.a(n2);
                                                                                                                                                                break;
                                                                                                                                                                Label_1453: {
                                                                                                                                                                    this.a(9);
                                                                                                                                                                }
                                                                                                                                                                this.r = 0;
                                                                                                                                                                break;
                                                                                                                                                                Label_1630:
                                                                                                                                                                iftrue(Label_0252:)(this.c <= 0);
                                                                                                                                                                break Block_39;
                                                                                                                                                                this.f(n3, this.ak);
                                                                                                                                                                break;
                                                                                                                                                                this.r();
                                                                                                                                                                break;
                                                                                                                                                                Label_0701:
                                                                                                                                                                iftrue(Label_0719:)(!this.v1097);
                                                                                                                                                                this.ae();
                                                                                                                                                                Label_1328:
                                                                                                                                                                break;
                                                                                                                                                                while (true) {
                                                                                                                                                                    while (true) {
                                                                                                                                                                        this.y1155 = (n3 != 0);
                                                                                                                                                                        this.bN = this.c1070[this.aN][0];
                                                                                                                                                                        this.bO = this.c1070[this.aN][n3];
                                                                                                                                                                        break Label_0876;
                                                                                                                                                                        this.U();
                                                                                                                                                                        this.a(n2);
                                                                                                                                                                        break;
                                                                                                                                                                        iftrue(Label_1052:)(this.T != 0);
                                                                                                                                                                        break Block_28;
                                                                                                                                                                        iftrue(Label_0876:)(this.h1047 != 42);
                                                                                                                                                                        continue Block_31_Outer;
                                                                                                                                                                    }
                                                                                                                                                                    this.r = r;
                                                                                                                                                                    break;
                                                                                                                                                                    Label_1435:
                                                                                                                                                                    this.r = 0;
                                                                                                                                                                    this.a(24);
                                                                                                                                                                    break;
                                                                                                                                                                    iftrue(Label_1185:)(!this.d());
                                                                                                                                                                    break Block_32;
                                                                                                                                                                    iftrue(Label_1143:)(!this.d());
                                                                                                                                                                    continue Block_27_Outer;
                                                                                                                                                                }
                                                                                                                                                                this.aN = this.h1074[this.X][this.aO];
                                                                                                                                                                continue Block_23_Outer;
                                                                                                                                                            }
                                                                                                                                                            Label_0719: {
                                                                                                                                                                iftrue(Label_0762:)(this.h1047 != -7);
                                                                                                                                                            }
                                                                                                                                                            break Block_21;
                                                                                                                                                            Label_1143:
                                                                                                                                                            this.an();
                                                                                                                                                            this.X();
                                                                                                                                                            this.ah();
                                                                                                                                                            this.K();
                                                                                                                                                            break;
                                                                                                                                                            Label_1484:
                                                                                                                                                            this.a(4);
                                                                                                                                                            this.c = 0;
                                                                                                                                                            break;
                                                                                                                                                            Label_1283:
                                                                                                                                                            switch([Lcom.strobel.decompiler.ast.Label;@487213ad)(this.r);
                                                                                                                                                            Label_1471:
                                                                                                                                                            this.a(r);
                                                                                                                                                            this.c = 0;
                                                                                                                                                            break;
                                                                                                                                                            this.g(this.ar, n);
                                                                                                                                                            break;
                                                                                                                                                            this.t();
                                                                                                                                                            break;
                                                                                                                                                            this.m();
                                                                                                                                                            break;
                                                                                                                                                            this.ad();
                                                                                                                                                            this.an();
                                                                                                                                                            this.al();
                                                                                                                                                            break;
                                                                                                                                                        }
                                                                                                                                                        iftrue(Label_1070:)(this.aS != this.l1072[this.aN] || this.aP > 0 || this.aT != this.aX || this.by <= 0);
                                                                                                                                                        continue Label_0794_Outer;
                                                                                                                                                    }
                                                                                                                                                    iftrue(Label_1097:)(!this.d());
                                                                                                                                                    break Block_30;
                                                                                                                                                    Label_1331: {
                                                                                                                                                        this.a();
                                                                                                                                                    }
                                                                                                                                                    iftrue(Label_0252:)(this.ar < 8 || this.aP <= 0);
                                                                                                                                                    continue Label_0638_Outer;
                                                                                                                                                }
                                                                                                                                                Label_1280: {
                                                                                                                                                    break;
                                                                                                                                                }
                                                                                                                                                this.u();
                                                                                                                                                break;
                                                                                                                                                this.r = 0;
                                                                                                                                                break;
                                                                                                                                                this.r = 0;
                                                                                                                                                this.a(24);
                                                                                                                                                continue Block_35_Outer;
                                                                                                                                            }
                                                                                                                                            Label_0762: {
                                                                                                                                                iftrue(Label_0794:)(this.h1047 != 48);
                                                                                                                                            }
                                                                                                                                            continue Label_1736_Outer;
                                                                                                                                        }
                                                                                                                                        Label_0609: {
                                                                                                                                            this.b1018 = false;
                                                                                                                                        }
                                                                                                                                        break;
                                                                                                                                    }
                                                                                                                                    this.c -= this.b1008;
                                                                                                                                    break;
                                                                                                                                    ak = this.ak + 1;
                                                                                                                                    this.ak = ak;
                                                                                                                                    iftrue(Label_0609:)(ak > 70);
                                                                                                                                    continue Block_35_Outer;
                                                                                                                                }
                                                                                                                                Label_1579: {
                                                                                                                                    this.c = 0;
                                                                                                                                }
                                                                                                                                this.a();
                                                                                                                                iftrue(Label_0252:)(this.l == 4 || this.l == r);
                                                                                                                                break Block_38;
                                                                                                                                this.V();
                                                                                                                                break;
                                                                                                                                Label_1669:
                                                                                                                                iftrue(Label_0252:)(this.c >= this.a1007 - this.b1008);
                                                                                                                                break Block_40;
                                                                                                                            }
                                                                                                                            this.U();
                                                                                                                            this.a(n2);
                                                                                                                            break;
                                                                                                                            Label_1379: {
                                                                                                                                r2 = this.r - n3;
                                                                                                                            }
                                                                                                                            this.r = r2;
                                                                                                                            iftrue(Label_0252:)(r2 >= 0);
                                                                                                                            continue Label_1162_Outer;
                                                                                                                        }
                                                                                                                        Label_1070: {
                                                                                                                            this.T();
                                                                                                                        }
                                                                                                                        continue Label_1074;
                                                                                                                        Label_1407:
                                                                                                                        r3 = this.r + 1;
                                                                                                                        this.r = r3;
                                                                                                                        iftrue(Label_0252:)(r3 <= r);
                                                                                                                        continue Label_1736_Outer;
                                                                                                                    }
                                                                                                                    switch([Lcom.strobel.decompiler.ast.Label;@29ded038)(this.g1046);
                                                                                                                }
                                                                                                                ++this.aO;
                                                                                                                this.d1073[this.aN] = (n3 != 0);
                                                                                                                this.E();
                                                                                                                iftrue(Label_1052:)(this.aO >= 7);
                                                                                                                continue Label_0638_Outer;
                                                                                                            }
                                                                                                            iftrue(Label_0701:)(!this.d());
                                                                                                            this.U();
                                                                                                            this.a(n2);
                                                                                                            break;
                                                                                                        }
                                                                                                        this.c += this.b1008;
                                                                                                        break;
                                                                                                        switch([Lcom.strobel.decompiler.ast.Label;@1c0c4746)(this.h1047);
                                                                                                        Label_1501: {
                                                                                                            this.C();
                                                                                                        }
                                                                                                        this.D();
                                                                                                        this.B();
                                                                                                        break;
                                                                                                        this.i();
                                                                                                        break;
                                                                                                        Label_1097:
                                                                                                        this.an();
                                                                                                        this.X();
                                                                                                        this.ah();
                                                                                                        this.K();
                                                                                                        this.al();
                                                                                                        break;
                                                                                                        Label_1185:
                                                                                                        this.an();
                                                                                                        this.X();
                                                                                                        this.ah();
                                                                                                        this.L();
                                                                                                        break;
                                                                                                        this.aa();
                                                                                                        this.an();
                                                                                                        Label_1576:
                                                                                                        break;
                                                                                                    }
                                                                                                    this.g(7, n);
                                                                                                    break;
                                                                                                }
                                                                                                this.U();
                                                                                                this.a(n2);
                                                                                                break;
                                                                                                this.g();
                                                                                                break;
                                                                                            }
                                                                                            this.r = 0;
                                                                                            this.h(this.aq);
                                                                                            this.a(3);
                                                                                        }
                                                                                        catch (final Exception ex) {}
                                                                                    }
                                                                                    catch (final Exception ex2) {}
                                                                                }
                                                                                catch (final Exception ex3) {}
                                                                            }
                                                                            catch (final Exception ex4) {}
                                                                        }
                                                                        catch (final Exception ex5) {}
                                                                    }
                                                                    break;
                                                                }
                                                                case 15: {
                                                                    continue Label_1162_Outer;
                                                                }
                                                                case 17: {
                                                                    continue Label_0652_Outer;
                                                                }
                                                                case 16: {
                                                                    continue Label_1736_Outer;
                                                                }
                                                                case 23: {
                                                                    continue Label_1074_Outer;
                                                                }
                                                                case 22: {
                                                                    continue Label_1729_Outer;
                                                                }
                                                                case 2: {
                                                                    continue Label_1204_Outer;
                                                                }
                                                                case 13: {
                                                                    continue Label_1074;
                                                                }
                                                                case 12: {
                                                                    continue Label_0638_Outer;
                                                                }
                                                                case 14: {
                                                                    continue Label_1120_Outer;
                                                                }
                                                                case 3: {
                                                                    continue Label_0667_Outer;
                                                                }
                                                                case 4:
                                                                case 5:
                                                                case 20:
                                                                case 21: {
                                                                    continue Label_0678_Outer;
                                                                }
                                                                case 8:
                                                                case 9: {
                                                                    continue;
                                                                }
                                                                case 10: {
                                                                    continue Label_1516_Outer;
                                                                }
                                                            }
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                    break;
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    break;
                }
                break;
            }
            break;
        }
        Label_0252:;
    }
    
    private void G(final int b) {
        this.c1190 = 2;
        final StringBuffer append = new StringBuffer().append("http://service.snowfish.cn/game/sms/server.php");
        String string;
        if (this.h1192 == null) {
            string = "";
        }
        else {
            string = new StringBuffer().append("?").append(this.h1192).toString();
        }
        this.f1186 = append.append(string).toString();
        this.a1191 = null;
        (this.a1191 = new ByteArrayOutputStream(2048)).write(b);
    }
    
    private void H() {
        this.J();
        this.I();
    }
    
    private void H(final int n) {
        final char c = (char)(-1);
        this.I(n >> 16 & c);
        this.I(n & c);
    }
    
    private void I() {
        this.a(this.a1013[3][3], 0, 0, 13450878, true);
        this.a1002.setColor(15988422);
        this.a1002.drawLine(0, 12, 240, 12);
        for (int i = 0; i < 3; ++i) {
            this.a(this.a1013[3][19], i * 82 + 25, 0, this.d1050[i << 1], 0, this.d1050[(i << 1) + 1], this.a1013[3][19].getHeight(), 0, 0);
            int n;
            if (i == 0) {
                n = this.aS;
            }
            else if (i == 1) {
                n = this.bz;
            }
            else {
                n = this.by;
            }
            this.b(n, i * 82 + 25 + this.d1050[(i << 1) + 1] + 2, 0);
        }
        this.a1002.setClip(0, 0, 240, 320);
    }
    
    private void I(final int n) {
        this.a1191.write(n >> 8 & 0xFF);
        this.a1191.write(n & 0xFF);
    }
    
    private void J() {
        final int n = 289 - (this.au + this.av) + 1;
        final int n2 = 289 - this.av + this.a1013[3][6].getHeight() + 1;
        this.a1002.setColor(16580557);
        this.a1002.fillRect(0, 289 - (this.au + this.av), 240, this.au + 21 + this.av);
        this.a(this.a1013[3][6], 120 - this.a1013[3][6].getWidth(), n, 12010381, true);
        this.a(this.a1013[3][7], 0, n, 0, false);
        this.a(this.a1013[3][5], 0, n2, 0, false);
        this.a1002.setColor(15455661);
        final int width = this.a1013[3][5].getWidth();
        final int height = this.a1013[3][5].getHeight();
        this.a1002.fillRect(width, n2 + 2, 240 - (width << 1), 9);
        if (this.aw != 0) {
            this.c(57, n2 + height, 183, this.av, 0);
            this.c(0, n2 + height, 57, this.av - 3, 1);
            int n3;
            if (this.au != 0) {
                final int height2 = this.a1013[3][6].getHeight();
                this.a1002.setClip(0, n + height2, 240, this.au);
                this.a(this.a1013[3][10], 0, n + height2, 14311547, true);
                this.a(this.aG, n + height2 + 1, 16, this.au);
                this.e(this.d1053[this.aC][this.aD], 67, n2 + height2 + 15, 163, this.av);
                n3 = height2;
            }
            else {
                n3 = height;
            }
            if (this.av != 0) {
                final int n4 = n3 + n2 + (this.av >> 1);
                if (this.aC >= 2) {
                    final int[] array = this.c1107[this.ay];
                    final byte b = this.d1053[this.aC][this.aD];
                    final int n5 = array[2];
                    final int n6 = array[3];
                    final int n7 = 28;
                    final int n8 = n4 - 5;
                    int n9;
                    if (array[2] == 10) {
                        n9 = 10;
                    }
                    else {
                        n9 = 0;
                    }
                    this.a(n5, n6, n7, n8 + n9, 0, 2, 0);
                    if (b != 21) {
                        this.a(this.a1013[3][19], 210, n2 + 2, this.d1050[2], 0, this.d1050[3], this.a1013[3][19].getHeight(), 0, 0);
                        if (b == 16 || b == 18) {
                            int a;
                            if (this.o(array[2], array[3])) {
                                a = this.a(array[2], this.r1101, array[3]) >> 1;
                            }
                            else {
                                a = this.a(array[2], this.r1101, array[3]);
                            }
                            this.b(a, 224, n2 + 2);
                        }
                        else if (b == 20) {
                            this.b(this.b(this.ay), 224, n2 + 2);
                        }
                        this.h(array[2], 2, n2 + 2);
                    }
                }
                else if (this.aC == 0) {
                    final byte b2 = this.d1053[this.aC][this.aD];
                    if (b2 != 21) {
                        this.a(this.a1013[3][19], 210, n2 + 2, this.d1050[2], 0, this.d1050[3], this.a1013[3][19].getHeight(), 0, 0);
                        this.b((int)this.q1100[b2], 224, n2 + 2);
                        this.a(b2, 0, 28, n4 - 5, 0, 2, 0);
                        this.h(b2, 2, n2 + 2);
                    }
                }
                else if (this.aC == 1 && this.aD < 5) {
                    this.a(this.aD, 28, n4, true);
                    if (this.a1056[this.aD]) {
                        this.a1002.drawImage(this.a1013[3][23], 1, n4, 0);
                    }
                    else {
                        this.a(this.a1013[3][19], 210, n2 + 2, this.d1050[2], 0, this.d1050[3], this.a1013[3][19].getHeight(), 0, 0);
                        this.b((int)this.g1057[this.aD], 224, n2 + 2);
                    }
                }
            }
        }
        else {
            this.h(2, n2 + 1);
        }
        this.a1002.setClip(0, 0, 240, 320);
    }
    
    private void K() {
        final int au = 18;
        final int n = 20;
        Label_0052: {
            switch (this.aw) {
                case 0: {
                    this.a(this.bN, this.bO);
                    break;
                }
                case 1: {
                    final int av = this.av + 20;
                    this.av = av;
                    if (av > this.ax) {
                        this.av = this.ax;
                        if ((this.au += 20) > au) {
                            this.au = au;
                        }
                        this.M();
                    }
                    switch (this.h1047) {
                        default: {
                            break Label_0052;
                        }
                        case -7: {
                            this.aw = 2;
                            break Label_0052;
                        }
                    }
                    break;
                }
                case 2: {
                    final int au2 = this.au - n;
                    this.au = au2;
                    if (au2 >= 0) {
                        break;
                    }
                    this.au = 0;
                    if ((this.av -= n) < 0) {
                        this.aw = 0;
                        this.av = 0;
                        this.a();
                        break;
                    }
                    break;
                }
                case 3: {
                    final int au3 = this.au - n;
                    this.au = au3;
                    if (au3 >= 0) {
                        break;
                    }
                    this.au = 0;
                    if ((this.av -= n) < 0) {
                        this.aw = 4;
                        this.bF = 1;
                        this.av = 0;
                        this.a(13);
                        break;
                    }
                    break;
                }
                case 4: {
                    this.m(this.bN, this.bO);
                    break;
                }
            }
        }
    }
    
    private void L() {
        final int aa = 3;
        final int aa2 = 2;
        final int aa3 = 1;
        final int n = -1;
        switch (this.h1047) {
            case -1:
            case 50: {
                if (this.m1129[0] != n) {
                    this.aA = 0;
                    break;
                }
                break;
            }
            case -3:
            case 52: {
                if (this.m1129[aa] != n) {
                    this.aA = aa;
                    break;
                }
                break;
            }
            case -4:
            case 54: {
                if (this.m1129[aa3] != n) {
                    this.aA = aa3;
                    break;
                }
                break;
            }
            case -2:
            case 56: {
                if (this.m1129[aa2] != n) {
                    this.aA = aa2;
                    break;
                }
                break;
            }
            case -7: {
                this.a();
                break;
            }
            case -6:
            case -5:
            case 53: {
                this.c(this.bN, this.bO, this.bw, this.aA);
                break;
            }
        }
    }
    
    private void M() {
        final int n = 4;
        final int aw = 3;
        final int n2 = 1;
        final int n3 = 2;
        if (this.aC == 0 || this.aC == n2) {
            this.a(this.f1055);
        }
        switch (this.g1046) {
            case -3:
            case 52: {
                this.aH = 0;
                final int ad = this.aD - n2;
                this.aD = ad;
                if (ad < 0) {
                    this.aD = this.aB;
                    this.aE = this.aD - (this.aF - n2);
                }
                if (this.aD < this.aB - (this.aF - n2) && this.aE > 0 && this.aD - this.aE < 0) {
                    this.aE -= n2;
                    break;
                }
                break;
            }
            case -4:
            case 54: {
                this.aH = 0;
                final int ad2 = this.aD + 1;
                this.aD = ad2;
                if (ad2 > this.aB) {
                    this.aD = 0;
                    this.aE = 0;
                }
                if (this.aD > this.aF - n2 && this.aD - this.aE > this.aF - n2) {
                    ++this.aE;
                    break;
                }
                break;
            }
        }
        Label_0140: {
            switch (this.h1047) {
                case -6:
                case -5:
                case 53: {
                    final byte bw = this.d1053[this.aC][this.aD];
                    if (bw == 21) {
                        this.aw = n3;
                        break;
                    }
                    switch (this.aC) {
                        default: {
                            break Label_0140;
                        }
                        case 0: {
                            if (this.bt >= 30) {
                                this.o = 7;
                                break Label_0140;
                            }
                            if (!this.e1105[bw]) {
                                this.o = n3;
                                this.F(n2);
                                break Label_0140;
                            }
                            if (this.bz >= this.q1100[bw]) {
                                this.bw = bw;
                                this.aw = aw;
                                break Label_0140;
                            }
                            this.o = 0;
                            this.F(n3);
                            break Label_0140;
                        }
                        case 2:
                        case 5: {
                            this.x(this.ay);
                        }
                        case 3:
                        case 4:
                        case 6:
                        case 7: {
                            final int[] array = this.c1107[this.ay];
                            switch (bw) {
                                default: {
                                    break Label_0140;
                                }
                                case 16: {
                                    if (this.d(this.ay)) {
                                        array[n] = n;
                                        this.aw = n3;
                                        break Label_0140;
                                    }
                                    break Label_0140;
                                }
                                case 18: {
                                    int a;
                                    if (this.o(array[n3], array[aw])) {
                                        a = this.a(array[n3], this.r1101, array[aw]) >> 1;
                                    }
                                    else {
                                        a = this.a(array[n3], this.r1101, array[aw]);
                                    }
                                    if (this.j(a)) {
                                        array[15] = n2;
                                        this.aw = n3;
                                        break Label_0140;
                                    }
                                    this.o = 0;
                                    break Label_0140;
                                }
                                case 19: {
                                    array[15] = 0;
                                    this.v(this.ay);
                                    this.aw = n3;
                                    break Label_0140;
                                }
                                case 20: {
                                    array[n] = 5;
                                    this.aw = n3;
                                    break Label_0140;
                                }
                            }
                            break;
                        }
                        case 1: {
                            if (bw == 22) {
                                this.r = 0;
                                this.a(24);
                                break Label_0140;
                            }
                            this.k(this.aD);
                            break Label_0140;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    private void N() {
        final int n = 1;
        for (int i = 0; i < this.E1163.length; ++i) {
            if (this.E1163[i] == 11) {
                this.aK = this.b(i, 0);
                this.aL = this.b(i, n);
                break;
            }
        }
        for (int j = 0; j < this.E1163.length; ++j) {
            if (this.E1163[j] == 10) {
                this.aI = this.b(j, 0);
                this.aJ = this.b(j, n);
                break;
            }
        }
    }
    
    private void O() {
        final int ar = 8;
        final int n = -1;
        if (this.p1078) {
            this.p1078 = false;
            if ((this.aS & 0x3) == 0x3) {
                this.o1077 = true;
            }
            else {
                this.o1077 = false;
            }
            this.aR = 0;
            this.aT = 0;
            ++this.aS;
            this.R();
            this.c(this.bj = this.aV + 12);
            this.aU = this.bj;
            if (this.ba != 0) {
                this.a(38, this.aM = this.k1068[this.ba]);
            }
            if (this.o1077) {
                this.g(this.ar = ar, n);
            }
            else {
                this.ar = this.aV + 9;
                this.g(this.aV + 9, n);
            }
        }
    }
    
    private void P() {
        final int n = 30;
        this.aN = this.h1074[this.X][this.aO];
        this.e(0);
        this.be = -42;
        this.e(20);
        this.E(this.aN);
        this.e(n);
        this.aj();
        this.e(50);
        this.c(n);
        this.e(60);
        this.c(31);
        this.e(80);
        this.N();
        this.e(100);
    }
    
    private void Q() {
        final int n = 30;
        this.aN = this.h1074[this.X][this.aO];
        this.e(0);
        this.be = -42;
        this.e(10);
        this.c(31);
        this.e(20);
        this.c(n);
        this.c(this.bj);
        this.e(n);
        this.E(this.aN);
        this.e(40);
        this.c(29);
        this.e(60);
        for (int i = 0; i < 11; ++i) {
            this.c(i + 18);
        }
        this.e(80);
        this.N();
        this.b();
        this.e(100);
    }
    
    private void R() {
        final int n = 6;
        final int n2 = 3;
        final byte b = 1;
        if (this.o1077) {
            int n3;
            if (this.aN > b && this.aN < n) {
                if (this.A1132[this.X][this.aN] == b) {
                    n3 = this.z1131[this.aN].length >> 1;
                }
                else {
                    n3 = 0;
                }
            }
            else {
                n3 = 0;
            }
            this.bb = this.z1131[this.aN][(this.aS >> 2) + n3 - b];
            this.aV = this.a1067[this.aN][(this.aS >> 2) + n3 - b][0] >> 1;
            this.ba = this.a1067[this.aN][n3 + (this.aS >> 2) - b][b];
        }
        else {
            final int n4 = this.a() % 21;
            for (int i = 0; i < n; ++i) {
                if (n4 <= this.j1080[this.aN][i]) {
                    this.aV = i;
                    break;
                }
            }
            this.ba = 0;
        }
        final int n5 = this.i1079[this.aV][0] + this.i1079[this.aV][b] * this.aS;
        int n6;
        if (this.ba == n2) {
            n6 = this.aS * 10;
        }
        else {
            n6 = 0;
        }
        this.aW = n5 + n6;
        this.aX = this.i1079[this.aV][2] + this.i1079[this.aV][n2] * this.aS;
        final int n7 = this.i1079[this.aV][4] * this.aS;
        int as;
        if (this.ba == b) {
            as = this.aS;
        }
        else {
            as = 0;
        }
        this.aY = n7 + as;
        this.aZ = this.i1079[this.aV][5];
        if (this.aX >= 80) {
            this.aX = 79;
        }
    }
    
    private void S() {
        if (this.r1086) {
            this.a1002.setClip(0, 0, 240, 320);
            this.a1002.setColor(16777215);
            this.a1002.fillRect(this.be, 15, 42, 12);
            for (int i = 0; i < 3; ++i) {
                this.a(this.a1013[3][26], this.b1085[i][this.bd][0] + (this.be + 2 + i * 10), this.b1085[i][this.bd][1] + 16, i * 10, 0, 10, 10, 0, 0);
            }
            this.a(this.a1013[3][27], this.be + 2 + 31, 17, 0, 0, 9, 9, 0, 0);
            this.a1002.fillRect(240 - this.be - 42, 15, 42, 12);
            for (int j = 0; j < 2; ++j) {
                this.a(this.a1013[3][26], this.b1085[j][this.bd][0] + (240 - this.be - 42 + 2 + j * 15), this.b1085[j][this.bd][1] + 16, (j + 3) * 10, 0, 10, 10, 0, 0);
            }
            this.a(this.a1013[3][27], 240 - this.be - 42 + 2 + 31, 17, 9, 0, 9, 9, 0, 0);
        }
    }
    
    private void T() {
        final int be = -42;
        if (this.aT == this.aX && this.aP == 0) {
            this.r1086 = true;
            if (++this.bd > 3) {
                this.bd = 0;
            }
            if ((this.be += 6) > 0) {
                this.be = 0;
            }
        }
        else if ((this.be -= 6) < be) {
            this.be = be;
            this.r1086 = false;
        }
    }
    
    private void U() {
        this.h(this.aq);
        this.aw = 0;
        this.bg = 0;
        if (this.s1088) {
            this.bf = 297;
            this.a1087 = new short[this.bf];
            this.bh = 4;
        }
        else {
            this.bf = 240;
            this.a1087 = new short[this.bf];
            this.bh = 5;
        }
        for (int i = 0; i < this.bf; ++i) {
            if (this.s1088) {
                this.a1087[i] = (short)(this.a() % 120 + 210);
            }
            else {
                this.a1087[i] = (short)(40 - this.a() % 160 - 320);
            }
        }
        this.bi = 100;
        this.c();
        this.c(33);
    }
    
    private void V() {
        for (int i = 0; i < this.bf; ++i) {
            if (this.s1088) {
                final short[] a1087 = this.a1087;
                if ((a1087[i] -= 60) < 0) {
                    this.a1087[i] = 0;
                }
            }
            else {
                final short[] a1088 = this.a1087;
                if ((a1088[i] += 60) > 0) {
                    this.a1087[i] = 0;
                }
            }
        }
        if (this.bg > 15) {
            switch (this.h1047) {
                case -6:
                case -5:
                case 53: {
                    if (this.s1088) {
                        if (this.T == 0) {
                            this.t1089 = true;
                        }
                        this.s1088 = false;
                        this.e(0);
                        this.c();
                        this.e(30);
                        this.c(4);
                        this.e(70);
                        this.l = 16;
                        this.e(100);
                        this.b();
                        break;
                    }
                    this.B();
                    break;
                }
            }
        }
        ++this.bg;
    }
    
    private void W() {
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(13450878);
        for (int i = 0; i < this.bf; ++i) {
            if (this.s1088) {
                this.a1002.drawLine((int)this.a1087[i], i + 13, this.a1087[i] + 240, i + 13);
            }
            else {
                this.a1002.drawLine(i, this.a1087[i] + 13, i, this.a1087[i] + 320 + 13);
            }
        }
        if (this.bg > this.bh) {
            if (this.bg >= this.bh + 2) {
                final int n = 240 - this.a1013[33][2].getWidth() >> 1;
                final int n2 = this.bi - (this.a1013[33][2].getHeight() >> 1);
                if (this.s1088) {
                    this.a1002.drawImage(this.a1013[33][2], n, n2, 0);
                    if (this.bg >= this.bh + 3) {
                        this.a(this.a1013[33][4], n + 20, n2 + 4, 0, 0, 27, 23, 0, 0);
                    }
                    if (this.bg >= this.bh + 4) {
                        this.a(this.a1013[33][4], n + 59, n2 + 4, 27, 0, 27, 23, 0, 0);
                    }
                }
                else {
                    this.a1002.drawImage(this.a1013[33][3], n, n2, 0);
                    if (this.bg >= this.bh + 3) {
                        this.a(this.a1013[33][5], n + 20, n2 + 4, 0, 0, 27, 23, 0, 0);
                    }
                    if (this.bg >= this.bh + 4) {
                        this.a(this.a1013[33][5], n + 59, n2 + 4, 27, 0, 27, 23, 0, 0);
                    }
                }
                this.n(n + 20, n2, this.bg - this.bh - 3);
                this.n(n + 75, n2, this.bg - this.bh - 4);
            }
            if (this.bg == this.bh + 1) {
                this.a1002.setColor(16777215);
                this.a1002.drawLine(0, this.bi, 240, this.bi);
                this.a1002.drawImage(this.a1013[33][0], 240 - this.a1013[33][0].getWidth() >> 1, this.bi - 14, 0);
            }
            if (this.bg == this.bh + 2) {
                this.a1002.setColor(16777215);
                this.a1002.drawLine(240 - this.a1013[33][1].getWidth() >> 1, this.bi, 240 - (240 - this.a1013[33][1].getWidth() >> 1), this.bi);
                this.a1002.drawImage(this.a1013[33][1], 240 - this.a1013[33][1].getWidth() >> 1, this.bi - 4, 0);
            }
        }
    }
    
    private final void X() {
        final int n = 2;
        final int n2 = 9;
        final int o = 8;
        final int p1078 = 1;
        this.O();
        this.l(p1078);
        if (this.l == n && this.aP <= 0 && this.aT == this.aX && this.g1046 == 35) {
            this.p1078 = (p1078 != 0);
        }
        a(this.o1153, this.b1066, this.aP, 24);
        for (int i = 0; i < this.aP; ++i) {
            final int[] array = this.b1066[this.o1153[i]];
            this.z(this.o1153[i]);
            this.s(this.o1153[i]);
            final int n3;
            final int n4;
            final int n5;
            switch (array[o]) {
                case 4:
                    Label_0374: {
                        n3 = 17;
                        n4 = array[n3] + 1;
                        array[n3] = n4;
                        if (n4 > 5) {
                            array[17] = 0;
                        }
                        if (array[o] != 4) {
                            break Label_0374;
                        }
                        n5 = 25;
                        if (++array[n5] > 100) {
                            array[25] = 100;
                            array[o] = (array[17] = 0);
                        }
                        break Label_0374;
                    }
                case 0: {
                    if ((array[6] == o || array[6] == n2) && array[o] == 0) {
                        final int n6 = 25;
                        if ((array[n6] -= p1078) < 0) {
                            array[25] = 0;
                            array[o] = 4;
                        }
                    }
                    this.o(this.o1153[i]);
                    final int n7 = array[0] + this.k1081[array[5]][0] * array[4];
                    final int n8 = array[p1078] + this.k1081[array[5]][p1078] * array[4];
                    this.n(this.o1153[i]);
                    Label_0690: {
                        if (this.a(n7, n8) != this.a(array[0], array[p1078])) {
                            if (this.b(n7, n8)) {
                                this.a(n7, n8, (boolean)(p1078 != 0));
                                this.a(array[0], array[p1078], false);
                            }
                            else {
                                if (this.c(n7, n8)) {
                                    array[o] = o;
                                    array[7] = 0;
                                    break Label_0690;
                                }
                                array[o] = 7;
                                break Label_0690;
                            }
                        }
                        array[0] = n7;
                        array[p1078] = n8;
                    }
                    this.i(this.o1153[i], array[n]);
                    break;
                }
                case 1: {
                    int n11;
                    int n12;
                    if ((array[n2] & 0x1) == (array[5] & 0x1)) {
                        final int n9 = array[0] + (this.k1081[array[n2]][0] << 3);
                        final int n10 = array[p1078] + (this.k1081[array[n2]][p1078] << 3);
                        n11 = n9;
                        n12 = n10;
                    }
                    else {
                        final int n13 = array[0] + (this.k1081[array[n2]][0] << 4);
                        final int n14 = array[p1078] + (this.k1081[array[n2]][p1078] << 4);
                        n11 = n13;
                        n12 = n14;
                    }
                    if (this.b(n11, n12) && this.c(n11, n12) == array[5]) {
                        this.a(n11, n12, (boolean)(p1078 != 0));
                        this.a(array[0], array[p1078], false);
                        array[0] = n11;
                        array[p1078] = n12;
                        array[o] = 7;
                    }
                    else {
                        array[0] += this.k1081[array[n2]][0] << 2;
                        array[p1078] += this.k1081[array[n2]][p1078] << 2;
                        array[o] = n;
                    }
                    this.i(this.o1153[i], array[n]);
                    break;
                }
                case 2: {
                    array[0] += this.k1081[array[n2] + 2 & 0x3][0] << 2;
                    array[p1078] += this.k1081[array[n2] + 2 & 0x3][p1078] << 2;
                    array[o] = 3;
                    this.i(this.o1153[i], array[n]);
                    break;
                }
                case 3: {
                    array[o] = 0;
                    this.i(this.o1153[i], array[n]);
                    break;
                }
                case 5: {
                    final int n15 = 7;
                    final int n16 = array[n15] + 1;
                    array[n15] = n16;
                    if (n16 > o) {
                        array[7] = 0;
                        array[o] = 6;
                    }
                    if (array[10] != -1) {
                        final int n17 = 10;
                        if ((array[n17] -= p1078) < 0) {
                            array[10] = -1;
                        }
                    }
                    array[15] = 0;
                    break;
                }
                case 6: {
                    if ((array[6] & 0x1) == p1078) {
                        if (this.z1169) {
                            this.bz += 100;
                        }
                        else {
                            this.bz += 50;
                        }
                        for (int j = 0; j < this.aP; ++j) {
                            this.b1066[j][26] = 0;
                        }
                        this.ba = 0;
                    }
                    else if (this.z1169) {
                        this.bz += 10;
                    }
                    else {
                        this.bz += 5;
                    }
                    this.p(this.o1153[i]);
                    break;
                }
                case 7: {
                    this.o(this.o1153[i]);
                    if (array[12] == 0) {
                        array[o] = 0;
                    }
                    this.i(this.o1153[i], array[n]);
                    break;
                }
                case 8: {
                    final int n18 = 7;
                    final int n19 = array[n18] + 1;
                    array[n18] = n19;
                    if (n19 > 4) {
                        this.by -= p1078;
                        this.p(this.o1153[i]);
                    }
                    if (this.by <= 0) {
                        this.o = o;
                        this.F(3);
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private final void Y() {
        a(this.n1152, this.b1066, this.aP, 1);
        this.a1002.setClip(0, 0, 240, 320);
        for (int i = 0; i < this.aP; ++i) {
            final int[] array = this.b1066[this.n1152[i]];
            if (a(array[0] - this.bP, array[1] - this.bQ, 0, 0, 256, 289) && array[8] != 6) {
                if (array[8] != 5 && array[8] != 6 && array[8] != 8 && array[8] != 4) {
                    if (array[13] == 0) {
                        this.a(array[26], array[0] - this.bP, array[1] - this.bQ + 13, array[27], true);
                        this.f(array[6], array[0] - this.bP, array[1] - this.bQ + 13, this.l1083[array[6] >> 1][array[7]], array[5]);
                        this.a(array[26], array[0] - this.bP, array[1] - this.bQ + 13, array[27], false);
                        if (this.u1096) {
                            this.b(array[2], array[0] - this.bP, array[1] - this.bQ + 13, array[6]);
                        }
                    }
                }
                else if (array[8] == 5) {
                    this.a(this.a1013[31][1], array[0] - 8 - this.bP, array[1] - 24 - this.bQ + 13, array[7] * 15, 0, 15, 30, 0, 0);
                }
                else if (array[8] == 8) {
                    this.a(this.a1013[31][2], array[0] - 8 - this.bP, array[1] - 24 - this.bQ + 13, array[7] * 24, 0, 24, 24, 0, 0);
                }
                else if (array[8] == 4) {
                    this.a(this.a1013[this.bj][2], array[0] + this.d1091[array[6]][array[5]][0] - this.bP, array[1] + this.d1091[array[6]][array[5]][1] - this.bQ + 13, array[17] * 21, 0, 21, 19, 0, 0);
                    this.a1002.setClip(0, 0, 240, 320);
                    this.a1002.setColor(this.k1071[this.aN]);
                    this.a1002.fillArc(array[0] + this.d1091[array[6]][array[5]][0] - this.bP + 8 - (int)(this.a1019 & 0x1L), array[1] + this.d1091[array[6]][array[5]][1] - this.bQ + 13 + 7 - (int)(this.a1019 & 0x1L), (int)((this.a1019 & 0x1L) << 1) + 6, (int)((this.a1019 & 0x1L) << 1) + 6, 0, 360);
                }
                if (array[2] > 0 && (array[6] == 8 || array[6] == 9)) {
                    if (array[25] >= 0 && array[25] < 5) {
                        this.a(this.a1013[31][2], array[0] - 8 - this.bP, array[1] - 20 - this.bQ + 13, array[25] * 24, 0, 24, 24, 0, 0);
                    }
                    else if (array[25] >= 95 && array[25] <= 100) {
                        this.a(this.a1013[31][2], array[0] - 8 - this.bP, array[1] - 20 - this.bQ + 13, (100 - array[25]) * 24, 0, 24, 24, 0, 0);
                    }
                }
            }
        }
        for (int j = 0; j < this.aP; ++j) {
            final int[] array2 = this.b1066[this.n1152[j]];
            if (array2[8] != 5 && array2[8] != 6 && array2[8] != 8) {
                this.r(this.n1152[j]);
            }
            if (array2[10] != -1) {
                this.q(this.n1152[j]);
            }
        }
    }
    
    private void Z() {
        final int n = 240;
        final int n2 = 2;
        final int n3 = 1;
        this.a1002.setClip(0, 0, n, 320);
        this.a1002.setColor(16580557);
        this.a1002.fillRect(this.bn, this.bo, this.bp, this.bq);
        this.a1002.fillRect(this.bn - n3, this.bo + 1, this.bp + 2, this.bq - n2);
        this.q(this.bb, 18, 293);
        this.a1002.drawImage(this.a1013[3][28], 0, 299, 0);
        if (this.br == n2) {
            this.a1002.fillTriangle(this.bl + 15, this.bm + this.bk, this.bl + 15 + 8, this.bm + this.bk, this.bl + 15 + 8, this.bm + this.bk + 8);
            this.a1002.setColor(5465994);
            this.a(new StringBuffer().append(this.b1015[(this.ba - n3 << 1) + 155]).append(this.b1015[this.bb + 28]).append(this.b1015[(this.ba - n3 << 1) + 155 + 1]).toString(), 0, this.bl + 10, this.bm + 5, n - (this.bl + 10) * 2, this.bk);
        }
    }
    
    private final int a() {
        return this.a1012.nextInt() & 0xFF;
    }
    
    private int a(final int n) {
        return this.E1163[n] >> 1;
    }
    
    private int a(final int n, final int n2) {
        return (n2 >> 4) * this.bG + (n >> 4);
    }
    
    private int a(final int a, final int n, final int n2) {
        final int n3 = 360;
        final int n4 = 180;
        final int n5 = 45;
        if (n != 0 && n2 != 0) {
            final int abs = Math.abs(a);
            final int n6 = 89;
            int n7 = 0;
            int n8 = n5;
            int i = n6;
            while (true) {
                while (i > n7) {
                    if (this.j1049[n8] > abs) {
                        i = n8 - 1;
                    }
                    else {
                        if (this.j1049[n8] >= abs) {
                            break;
                        }
                        n7 = n8 + 1;
                    }
                    if (i <= n7) {
                        int n9 = n7;
                        if (n < 0 && n2 > 0) {
                            n9 = n4 - n9;
                        }
                        else if (n < 0 && n2 < 0) {
                            n9 += 180;
                        }
                        else if (n > 0 && n2 < 0) {
                            n9 = n3 - n9;
                        }
                        if (n9 >= n3) {
                            n9 -= 360;
                            return n9;
                        }
                        return n9;
                    }
                    else {
                        n8 = i + n7 >> 1;
                    }
                }
                int n9 = n8;
                continue;
            }
        }
        int n9;
        if (n == 0) {
            if (n2 > 0) {
                n9 = 90;
            }
            else {
                n9 = 270;
            }
        }
        else if (n > 0) {
            n9 = 0;
        }
        else {
            n9 = n4;
        }
        return n9;
    }
    
    private int a(final int n, final int n2, final int n3, final int n4) {
        final int n5 = n3 - n;
        final int n6 = n4 - n2;
        int a;
        if (n5 == 0 || n6 == 0) {
            if (n5 == 0) {
                if (n6 > 0) {
                    a = 90;
                }
                else {
                    a = 270;
                }
            }
            else if (n5 > 0) {
                a = 0;
            }
            else {
                a = 180;
            }
        }
        else {
            a = this.a(Math.abs((n6 << 12) / n5), n5, n6);
        }
        return a;
    }
    
    private int a(final int n, final byte[] array, final int n2) {
        int n3;
        if (array == this.s1102) {
            if (this.f1106[0]) {
                n3 = 5;
            }
            else {
                n3 = 0;
            }
            if (this.i(n, n2)) {
                n3 += d((int)array[n << 1], (int)array[(n << 1) + 1], n2) >> 2;
            }
        }
        else if (array == this.u1104 && this.n(n, n2)) {
            n3 = -10;
        }
        else {
            n3 = 0;
        }
        return n3 + d((int)array[n << 1], (int)array[(n << 1) + 1], n2);
    }
    
    private static String a(final DataInputStream dataInputStream) {
        final int int1 = dataInputStream.readInt();
        if (int1 < 0) {
            throw new IOException("nag len");
        }
        String s;
        if (int1 == 0) {
            s = "";
        }
        else {
            final char[] value = new char[int1];
            for (int i = 0; i < int1; ++i) {
                value[i] = (char)dataInputStream.readShort();
            }
            s = new String(value, 0, int1);
        }
        return s;
    }
    
    private static String a(final String s) {
        final int beginIndex = 7;
        final int index = s.indexOf(47, beginIndex);
        String s2;
        if (index < beginIndex) {
            s2 = s.substring(beginIndex, s.length());
        }
        else {
            s2 = s.substring(beginIndex, index);
        }
        return s2;
    }
    
    private static short a(final InputStream inputStream) {
        return (short)((inputStream.read() & 0xFF) | (inputStream.read() << 8 & 0xFF00));
    }
    
    private void a() {
        --this.m;
        this.l = this.b[this.m];
    }
    
    private void a(final byte b) {
        this.G(b);
        switch (b) {
            case 1: {
                this.H(16);
                this.H(44);
                this.c("N73");
                break;
            }
        }
        this.ay();
        this.av();
    }
    
    private void a(final int l) {
        this.b[this.m] = this.l;
        this.l = l;
        ++this.m;
    }
    
    private void a(final int n, final int n2) {
        try {
            if (this.a1013[n] == null || this.a1013[n][n2] == null) {
                Label_0094: {
                    if (this.a1013[n] != null) {
                        break Label_0094;
                    }
                    final Image[][] a1013 = this.a1013;
                    try {
                        final int n3 = this.f[n];
                        try {
                            a1013[n] = new Image[n3];
                            this.getClass();
                            final String s = this.a1014[n];
                            try {
                                final InputStream resourceAsStream = Display.getResourceAsStream(s);
                                for (int i = 0; i < n2; ++i) {
                                    resourceAsStream.skip(a(resourceAsStream));
                                }
                                final short a1014 = a(resourceAsStream);
                                try {
                                    final byte[] b = new byte[a1014];
                                    resourceAsStream.read(b, 0, a1014);
                                    this.a1013[n][n2] = Image.createImage(b, 0, (int)a1014);
                                    resourceAsStream.close();
                                }
                                catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                            catch (final Exception ex2) {}
                        }
                        catch (final Exception ex3) {}
                    }
                    catch (final Exception ex4) {}
                }
            }
        }
        catch (final Exception ex5) {}
    }
    
    private void a(final int n, final int n2, final int n3) {
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(13971834);
        this.a1002.drawString(this.b1015[n], n2, n3, 0);
    }
    
    private void a(final int n, final int n2, final int n3, final byte b, final int n4, final boolean b2) {
        final int n5 = 3;
        final int n6 = 3;
        while (true) {
            Label_0064: {
                if (n4 <= 0 || n4 >= 4) {
                    break Label_0064;
                }
                switch (n3) {
                    default: {
                        break Label_0064;
                    }
                    case 0:
                    case 2: {
                        if (b2) {
                            break;
                        }
                        final int n7 = n4 - 1;
                        final int n8 = n6;
                        final int i = n7;
                        final int n9 = 0;
                        final int n10 = n4;
                        break Label_0085;
                    }
                    case 1:
                    case 3: {
                        if (b2) {
                            final int n11 = n4 - 1;
                            final int n8 = n6;
                            final int i = n11;
                            final int n9 = 0;
                            final int n10 = n4;
                            break Label_0085;
                        }
                        break;
                    }
                }
                final int n12 = n4 - 1;
                final int n10 = n5;
                final int n9 = n12;
                int i = 0;
                final int n8 = n4;
                while (i < n10) {
                    for (int j = n9; j < n8; ++j) {
                        this.D1162[this.a((i << 4) * this.m1084[n3][0] + n + this.m1084[n3][2], (j << 4) * this.m1084[n3][1] + n2 + this.m1084[n3][3])] = b;
                    }
                    ++i;
                }
                return;
            }
            final int n10 = n5;
            final int n9 = 0;
            final int n13 = n6;
            int i = 0;
            final int n8 = n13;
            continue;
        }
    }
    
    private void a(final int n, final int n2, final int n3, final int n4) {
        for (int i = 0; i < this.aF; ++i) {
            final int n5 = n + i * 20;
            if (this.aD - this.aE == i) {
                this.a1002.setClip(n5 - 4, n2 - 3, n3 + 8, n4 + 2);
                this.a1002.setColor(16580557);
                this.a1002.drawRect(n5 - 3, n2 - 3, 21, 20);
                this.a1002.drawRect(n5 - 2, n2 - 2, 19, 19);
            }
            this.d(this.d1053[this.aC][this.aE + i], n5, n2, n3, n4);
            if (((this.aC == 0 && this.aE + i < 11 && !this.e1105[this.d1053[0][this.aE + i]]) || (this.aC == 1 && this.bt < 1 && this.aE + i < 5)) && this.f1055[this.aH] != -1 && this.aD - this.aE == i) {
                this.k(n5, n2, this.aH);
            }
        }
    }
    
    private void a(final int n, final int n2, final int n3, final int n4, final int n5) {
        if (this.o != -1) {
            this.a1002.setClip(0, 0, 240, 320);
            this.a1002.setColor(13971834);
            this.a(this.b1015[n + 113], 0, n2, n3, n4, n5);
        }
    }
    
    private void a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        if (n6 == 0) {
            this.c(n2, n3, n4, n5, 2);
            this.e(n, n2 - 5, n3 - 2);
        }
        else {
            this.c(n2, n3, n4, n5, 3);
            this.e(n, n2 + n4 - 15, n3 - 2);
        }
    }
    
    private void a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        int n8;
        if (n2 > 5) {
            n8 = 5;
        }
        else {
            n8 = n2;
        }
        for (int i = 0; i < this.q1114[n][n8 >> 1]; ++i) {
            final byte b = this.g1113[n][n8 >> 1][i * 3];
            final byte b2 = this.g1113[n][n8 >> 1][i * 3 + 1];
            final byte b3 = this.g1113[n][n8 >> 1][i * 3 + 2];
            int n9 = 0;
            int n10;
            if (n == 10) {
                final byte b4 = this.r1115[n6][0];
                n9 = this.r1115[n6][1];
                n10 = b4;
            }
            else {
                n10 = 0;
            }
            this.a(this.a1013[n + 18][0], b2 + n3 + n10, b3 + n4 + n9 + 13, this.f1112[n][b][0], this.f1112[n][b][1], this.f1112[n][b][2], this.f1112[n][b][3], 0, 0);
        }
        this.d(n3, n4, n, n5, n6, n7);
        this.a1002.setClip(0, 0, 240, 320);
    }
    
    private void a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        int n9;
        if (n5 > 5) {
            n9 = 5;
        }
        else {
            n9 = n5;
        }
        int n10 = 0;
        int n11 = 0;
        Image image = null;
        Image image2 = null;
        Image image3 = null;
        Image image4 = null;
        switch (n8) {
            default: {
                n10 = 0;
                n11 = 0;
                image = null;
                image2 = null;
                image3 = null;
                image4 = null;
                break;
            }
            case 3: {
                final Image image5 = this.a1013[29][22];
                final Image image6 = this.a1013[29][19];
                final Image image7 = this.a1013[29][21];
                final Image image8 = this.a1013[29][20];
                final byte b = this.J1144[n9 >> 1][0];
                n10 = this.J1144[n9 >> 1][1];
                n11 = b;
                image = image8;
                image2 = image7;
                image3 = image6;
                image4 = image5;
                break;
            }
            case 5: {
                final Image image9 = this.a1013[29][26];
                final Image image10 = this.a1013[29][23];
                final Image image11 = this.a1013[29][25];
                final Image image12 = this.a1013[29][24];
                final int n12 = -5;
                n10 = -26;
                n11 = n12;
                image = image12;
                image2 = image11;
                image3 = image10;
                image4 = image9;
                break;
            }
        }
        Label_0124: {
            switch (n7) {
                case 0: {
                    this.s(n + n11, n2 + n10, n6);
                    if (n6 > 1 && n6 < 4) {
                        switch (n8) {
                            default: {
                                break Label_0124;
                            }
                            case 3: {
                                this.a(image4, n + n11 + 21 - this.bP, n2 + n10 + 16 - this.bQ + 13, n6 - 2 << 4, 0, 16, 16, 0, 0);
                                break Label_0124;
                            }
                            case 5: {
                                this.a(image4, n + n11 + 24 - this.bP, n2 + n10 + 23 - this.bQ + 13, (n6 - 2) * 12, 0, 12, 17, 0, 0);
                                break Label_0124;
                            }
                        }
                    }
                    else {
                        if (n6 <= 5) {
                            break;
                        }
                        this.a(image3, n + n11 + 26 - this.bP, n2 + n10 - 31 - this.bQ + 13, (n6 - 6) * 7, 0, 7, 45, 0, 0);
                        if (n6 > 6) {
                            this.a(image2, n + n11 + 22 - this.bP, n2 + n10 - 37 - 15 - this.bQ + 13, (n6 - 7) * 15, 0, 15, 15, 0, 0);
                            break;
                        }
                        break;
                    }
                    break;
                }
                case 1: {
                    this.a(image, n3 - this.bP, n4 - this.bQ + 13, n6 * 12, 0, 12, 41, 0, 0);
                    this.a(image2, n3 - this.bP, n4 - 15 - this.bQ + 13, n6 * 15, 0, 15, 15, 0, 0);
                    break;
                }
            }
        }
    }
    
    private void a(final int n, final int n2, final int n3, final int n4, final boolean b) {
        if (b) {
            if (n == 1 || n == 2 || n == 3 || n == 7) {
                this.o(n2, n3, n4);
            }
        }
        else if (n == 4 || n == 5) {
            this.o(n2, n3, n4);
        }
        else if ((n == 8 || n == 6) && n4 != -2) {
            this.o(n2, n3, n4);
        }
    }
    
    private void a(final int n, final int n2, final int n3, final boolean b) {
        final int n4 = 10;
        final int n5 = 2;
        final byte b2 = this.i1062[n << 2];
        final byte b3 = this.i1062[(n << 2) + 1];
        final byte b4 = this.i1062[(n << 2) + 2];
        final byte b5 = this.i1062[(n << 2) + 3];
        int n6;
        int n7;
        if (b) {
            if (n == n5) {
                n6 = n4;
            }
            else {
                n6 = this.e1058[b2][n5] >> 1;
            }
            if (n < 3) {
                n7 = n4;
            }
            else {
                n7 = 0;
            }
        }
        else {
            n6 = 0;
            n7 = 0;
        }
        if (b2 != -1) {
            this.l(b2, n2 - n6, n3 - n7);
        }
        this.l(b3, n2 - n6 + b4, n3 - n7 + b5);
    }
    
    private final void a(final int n, final int n2, final boolean b) {
        Label_0031: {
            if (b) {
                if (this.b(n, n2)) {
                    break Label_0031;
                }
            }
            else if (!this.b(n, n2)) {
                break Label_0031;
            }
            return;
        }
        final byte[] e1163 = this.E1163;
        final int a = this.a(n, n2);
        final byte b2 = this.E1163[this.a(n, n2)];
        byte b3;
        if (b) {
            b3 = 1;
        }
        else {
            b3 = -1;
        }
        e1163[a] = (byte)(b2 + b3);
    }
    
    private void a(final String s) {
        this.e();
        this.a1002.setColor(7438477);
        this.a(s, this.c, 27, 18, 186, 292);
    }
    
    private void a(final String s, final int n, final int n2) {
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(16580557);
        this.a1002.fillRect(n, n2, s.length() * this.k + 2, this.j + 1);
        this.a1002.setColor(14174337);
        this.a1002.drawString(s, n + 1, n2 + 1, 0);
    }
    
    private final void a(final String s, final int n, final int n2, final int n3, final int n4, final int n5) {
        final int n6 = 10;
        final char[] charArray = s.toCharArray();
        final int length = charArray.length;
        final boolean b = this.d != length || (length > n6 && this.a1009.compareTo(s.substring(0, n6)) != 0);
        if (b && length > n6) {
            this.a1009 = s.substring(0, n6);
        }
        this.a(charArray, length, n, n2, n3, n4, n5, b);
    }
    
    private void a(final Image image, final int n, final int n2, final int n3) {
        this.a1005.drawImage(image, n, n2, 0, a.a1001[n3]);
    }
    
    private void a(final Image image, final int n, final int n2, final int n3, final int n4) {
        this.a1002.setClip(0, 0, 240, 320);
        final int width = image.getWidth();
        final int height = image.getHeight();
        this.a1002.drawImage(image, n, n2, 0);
        this.a(image, n + n3 - width, n2, 1);
        this.a(image, n, n2 + n4 - height, 2);
        this.a(image, n + n3 - width, n2 + n4 - height, 3);
    }
    
    private void a(final Image image, final int n, final int n2, final int n3, final int n4, final int n5) {
        for (int i = 0; i < this.i1122[n3].length; ++i) {
            this.a(image, n + this.i1122[n3][i][0], this.i1122[n3][i][1] + n2 + 13, this.w1123[n3][n4] * this.w1123[n3][n5 - 2], 0, this.w1123[n3][n5 - 2], this.w1123[n3][n5 - 1], 0, 0);
        }
    }
    
    private void a(final Image image, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        this.a1002.setClip(n, n2, n5, n6);
        this.a1002.drawImage(image, n - n3, n2 - n4, 0);
        this.a1002.setClip(0, 0, 240, 320);
    }
    
    private void a(final Image image, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        final int n8 = 16;
        final int width = image.getWidth();
        final int height = image.getHeight();
        int n9 = 0;
        int n10 = 0;
        switch (n4) {
            default: {
                n9 = 0;
                n10 = 0;
                break;
            }
            case 0: {
                final int n11 = (n7 & 0x3) << 4;
                n9 = n7 >> 2 << 4;
                n10 = n11;
                break;
            }
            case 1: {
                final int n12 = width - ((n7 & 0x3) << 4) - n8;
                n9 = n7 >> 2 << 4;
                n10 = n12;
                break;
            }
            case 2: {
                final int n13 = (n7 & 0x3) << 4;
                n9 = height - (n7 >> 2 << 4) - n8;
                n10 = n13;
                break;
            }
            case 3: {
                final int n14 = width - ((n7 & 0x3) << 4) - n8;
                n9 = height - (n7 >> 2 << 4) - n8;
                n10 = n14;
                break;
            }
            case 4: {
                final int n15 = n7 >> 2 << 4;
                n9 = (n7 & 0x3) << 4;
                n10 = n15;
                break;
            }
            case 5: {
                final int n16 = height - (n7 >> 2 << 4) - n8;
                n9 = (n7 & 0x3) << 4;
                n10 = n16;
                break;
            }
            case 6: {
                final int n17 = n7 >> 2 << 4;
                final int n18 = width - ((n7 & 0x3) << 4) - n8;
                n10 = n17;
                n9 = n18;
                break;
            }
            case 7: {
                final int n19 = height - (n7 >> 2 << 4) - n8;
                final int n20 = width - ((n7 & 0x3) << 4) - n8;
                n10 = n19;
                n9 = n20;
                break;
            }
        }
        if (n == 1) {
            this.b1003.setClip(n5, n6, n2, n3);
            (this.b1006 = DirectUtils.getDirectGraphics(this.b1003)).drawImage(image, n5 - n10, n6 - n9, 0, a.a1001[n4]);
        }
        else {
            this.a1005.drawImage(image, n5 - n10, n6 - n9, 0, a.a1001[n4]);
        }
    }
    
    private void a(final Image image, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        int n9;
        if ((n8 & 0x4) != 0x0) {
            n9 = n - (n5 >> 1);
        }
        else {
            n9 = n;
        }
        int n10;
        if ((n8 & 0x8) != 0x0) {
            n10 = n2 - (n6 >> 1);
        }
        else {
            n10 = n2;
        }
        if ((n8 & 0x1) != 0x0) {
            n9 -= n5;
        }
        if ((n8 & 0x2) != 0x0) {
            n10 -= n6;
        }
        this.a1002.setClip(n9, n10, n5, n6);
        if (n7 == 0) {
            this.a1002.drawImage(image, n9 - n3, n10 - n4, 0);
        }
        else {
            this.a(image, n9 - n3, n10 - n4, n7);
        }
        this.a1002.setClip(0, 0, 240, 320);
    }
    
    private void a(final Image image, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9) {
        if (this.a1040 == null) {
            this.a1040 = new Image[26];
        }
        if (this.a1038 < 26) {
            int[] array = this.a1039[this.a1038];
            if (n9 >= 0 && n9 < this.a1038) {
                this.a1039[this.a1038] = this.a1039[n9];
                this.a1040[this.a1038] = this.a1040[n9];
                this.a1040[n9] = image;
                this.a1039[n9] = array;
                array = this.a1039[n9];
            }
            else {
                this.a1040[this.a1038] = image;
            }
            int n10;
            int n11;
            int n12;
            int n13;
            if (n3 == 3) {
                array[6] = n8;
                n10 = n7;
                n11 = n6;
                n12 = n2;
                n13 = n;
            }
            else {
                int width = image.getWidth();
                final int height = image.getHeight();
                if (n3 == 2) {
                    width /= n5;
                    array[6] = width;
                }
                int n14;
                if ((n4 & 0x1) != 0x0) {
                    n14 = 0 - width;
                }
                else if ((n4 & 0x4) != 0x0) {
                    n14 = 0 - (width >> 1);
                }
                else {
                    n14 = 0;
                }
                int n15;
                if ((n4 & 0x2) != 0x0) {
                    n15 = 0 - (height - 1);
                }
                else if ((n4 & 0x8) != 0x0) {
                    n15 = 0 - ((height >> 1) - 1);
                }
                else {
                    n15 = 0;
                }
                final int n16 = n + n14;
                final int n17 = n2 + n15;
                if (n3 == 1) {
                    final int n18 = n14 + n6;
                    final int n19 = n15 + n7;
                    n11 = n18;
                    n10 = n19;
                    final int n20 = n17;
                    n13 = n16;
                    n12 = n20;
                }
                else {
                    n10 = n7;
                    n11 = n6;
                    final int n21 = n17;
                    n13 = n16;
                    n12 = n21;
                }
            }
            array[0] = n13;
            array[1] = n12;
            array[2] = n3;
            array[3] = n5;
            array[4] = n11;
            array[5] = n10;
            ++this.a1038;
        }
    }
    
    private void a(final Image image, final int n, final int n2, final int color, final boolean b) {
        final int n3 = 240;
        if (b) {
            this.a1002.setColor(color);
            this.a1002.fillRect(0, n2, n3, image.getHeight());
        }
        this.a1002.drawImage(image, n, n2, 0);
        this.a(image, n3 - image.getWidth() - n, n2, 1);
    }
    
    private void a(final Image image, final Image image2, final int n, final int n2, final int n3, final int n4, final int n5) {
        final int[] array = this.c1107[n];
        final int n6 = array[0] + (this.o1098[array[2]] << 3);
        final int n7 = array[1] + (this.o1098[array[2]] << 3);
        int n8 = 0;
        switch (array[2]) {
            case 0: {
                n8 = 0;
                break;
            }
            case 4: {
                n8 = 1;
                break;
            }
            case 1: {
                n8 = 2;
                break;
            }
        }
        final int n9 = n6 + this.j1139[n8][array[5]][0];
        final byte[][] array2 = this.j1139[n8];
        int n10;
        if (array[3] > 5) {
            n10 = 5;
        }
        else {
            n10 = array[3];
        }
        final int n11 = n9 + array2[(n10 >> 1) + 4][0];
        final int n12 = this.j1139[n8][array[5]][1] + n7;
        final byte[][] array3 = this.j1139[n8];
        int n13;
        if (array[3] > 5) {
            n13 = 5;
        }
        else {
            n13 = array[3];
        }
        final int n14 = n12 + array3[(n13 >> 1) + 4][1] + 13;
        switch (array[5]) {
            case 0: {
                this.a(image, n11 + n2 - this.bP, n14 - n3 - this.bQ, n4, 0, n5, 15, 2, 0);
                break;
            }
            case 1: {
                this.a(image, n11 + n3 - this.bP, n14 + n2 - this.bQ, 0, n4, 15, n5, 4, 0);
                break;
            }
            case 2: {
                this.a(image, n11 + n2 - this.bP, n14 + n3 - this.bQ, n4, 0, n5, 15, 0, 0);
                break;
            }
            case 3: {
                this.a(image, n11 - n3 - this.bP, n14 + n2 - this.bQ, 0, n4, 15, n5, 5, 0);
                break;
            }
        }
        switch (array[2]) {
            case 0:
            case 4: {
                for (int i = 0; i < 5; ++i) {
                    this.a(image2, array[11] * i + n11 - this.bP, array[12] * i + n14 - this.bQ, this.C1134[n][i] * 9, 0, 9, 9, 0, 0);
                }
                break;
            }
        }
    }
    
    private void a(final Image image, final Image image2, final Image image3, final int n, final int n2, final int n3, final int n4) {
        final int n5 = this.M1147[n3][0] + n - this.bP;
        final int n6 = this.M1147[n3][1] + n2 - this.bQ + 13;
        if (n4 < 3) {
            switch (n3) {
                case 0: {
                    this.a(image, n5, n6, n4 * 14, 0, 14, 33, 0, 0);
                    break;
                }
                case 2: {
                    this.a(image2, n5, n6, n4 * 13, 0, 13, 52, 0, 0);
                    break;
                }
                case 3: {
                    this.a(image3, n5, n6, n4 * 50, 0, 50, 12, 0, 0);
                    break;
                }
                case 1: {
                    this.a(image3, n5, n6, (2 - n4) * 50, 0, 50, 12, 1, 0);
                    break;
                }
            }
        }
    }
    
    private void a(final boolean b) {
        final int n = 4;
        final int n2 = 320;
        final int n3 = 10;
        final int n4 = 2;
        this.e();
        this.a1002.setColor(13450878);
        final int n5 = this.k + 120;
        final int n6 = n2 - this.j >> 1;
        this.a1002.drawString(this.b1015[101], 120 - (this.k << 1) - n, n6, 0);
        if (!this.l1031) {
            final Graphics a1002 = this.a1002;
            final String[] b2 = this.b1015;
            int n7;
            if (this.l1031) {
                n7 = 1;
            }
            else {
                n7 = n4;
            }
            a1002.drawString(b2[n7 + 101], n5 - n3 + (38 - this.k >> 1), n6, 0);
        }
        else {
            this.a1002.setClip(0, 0, 240, n2);
            for (int i = 0; i < 5; ++i) {
                this.a1002.setColor(16571546);
                this.a1002.fillRect(i * 4 + n5, n6 + 10 - i * 2, n4, i * 2 + 3);
            }
            for (int j = 0; j < this.q / 20; ++j) {
                this.a1002.setColor(15888524);
                this.a1002.fillRect(j * 4 + n5, n6 + 10 - j * 2, n4, j * 2 + 3);
            }
        }
        if (b) {
            this.c(3, 240 - this.a1013[n][25].getWidth() >> 1, 0);
        }
        this.d(this.k + 120 - n3, this.k + 120 - n3 + 32, (n2 - this.j >> 1) + (this.j - 9 >> 1));
    }
    
    private void a(final byte[] array) {
        final int ah = this.aH + 1;
        this.aH = ah;
        if (ah > array.length - 1) {
            this.aH = 0;
        }
    }
    
    private final void a(final char[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final boolean b) {
        int n7;
        int n8;
        if (b) {
            this.d = n;
            n7 = 0;
            n8 = 0;
        }
        else {
            n8 = (n7 = this.c1010[n2]);
        }
        final int n9 = n6 / this.n;
        this.b1008 = n9;
        int n10;
        if (b) {
            n10 = 0;
        }
        else {
            n10 = n2;
        }
        int n12;
        int i;
        int n13;
        int n14;
        int n15;
        if (!b) {
            final int min = Math.min(this.c1010[Math.min(this.a1007, Math.min(this.a1007, n9) + n2)], n);
            for (int n11 = 0; n11 < this.e[this.e.length - 1] && n7 > this.e[n11 << 1]; ++n11) {
                this.a1002.setColor(this.e[(n11 << 1) + 1]);
            }
            n12 = n10;
            i = n7;
            n13 = min;
            n14 = n8;
            n15 = 0;
        }
        else {
            this.c1010[0] = 0;
            this.e[this.e.length - 1] = 0;
            n12 = n10;
            i = n7;
            n13 = n;
            n14 = n8;
            n15 = 0;
        }
        while (i < n13) {
            final int n16 = n4 + this.n * (n12 - n2);
            final char c = array[i];
            if (c == '\n') {
                if (n12 >= n2 && n12 < n2 + n9 && i > n14) {
                    this.a1002.drawChars(array, n14, i - n14, n3, n16, 0);
                }
                final int n17 = n12 + 1;
                final int n18 = i + 1;
                if (b) {
                    this.c1010[n17] = n18;
                }
                n12 = n17;
                i = n18;
                n15 = 0;
                n14 = n18;
            }
            else {
                if (c == '$') {
                    final int n19 = i + 1;
                    this.a1002.setColor(this.d1011[array[n19] - 'a']);
                    n14 = n19 + 1;
                    if (b) {
                        this.e[this.e[this.e.length - 1] << 1] = n19;
                        this.e[(this.e[this.e.length - 1] << 1) + 1] = this.d1011[array[n19] - 'a'];
                        final int[] e = this.e;
                        final int n20 = this.e.length - 1;
                        ++e[n20];
                        i = n19;
                    }
                    else {
                        i = n19;
                    }
                }
                else {
                    n15 += this.a.charWidth(c);
                }
                if (n15 > n5) {
                    if (n12 >= n2 && n12 < n2 + n9) {
                        this.a1002.drawChars(array, n14, i - n14, n3, n16, 0);
                    }
                    final int n21 = n12 + 1;
                    if (b) {
                        this.c1010[n21] = i;
                    }
                    n12 = n21;
                    n14 = i;
                    n15 = 0;
                }
                else {
                    ++i;
                }
            }
        }
        int a1007;
        if (i > n14) {
            if (n12 >= n2 && n12 < n2 + n9) {
                this.a1002.drawChars(array, n14, i - n14, n3, n4 + this.n * (n12 - n2), 0);
            }
            a1007 = n12 + 1;
            if (b) {
                this.c1010[a1007] = i;
            }
        }
        else {
            a1007 = n12;
        }
        if (b) {
            this.a1007 = a1007;
        }
    }
    
    private static void a(final int[] array, final int[][] array2, final int n, final int n2) {
        for (int i = 0; i < n; ++i) {
            array[i] = (array2[i][n2] << 8) + i;
        }
        for (int j = 0; j < n; ++j) {
            for (int k = 0; k < n - j - 1; ++k) {
                if (array[k] >= array[k + 1]) {
                    final int n3 = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = n3;
                }
            }
        }
        for (int l = 0; l < n; ++l) {
            array[l] &= 0xFF;
        }
    }
    
    private final boolean a() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: istore_1       
        //     3: iconst_1       
        //     4: istore_2       
        //     5: iconst_0       
        //     6: istore_3       
        //     7: aconst_null    
        //     8: astore          4
        //    10: ldc_w           "sanGuoTd"
        //    13: astore          5
        //    15: aconst_null    
        //    16: astore          6
        //    18: aload           5
        //    20: iconst_0       
        //    21: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //    24: astore          4
        //    26: iconst_1       
        //    27: istore          7
        //    29: aload           4
        //    31: iload           7
        //    33: invokevirtual   javax/microedition/rms/RecordStore.getRecord:(I)[B
        //    36: astore          5
        //    38: new             Ljava/io/ByteArrayInputStream;
        //    41: astore          6
        //    43: aload           6
        //    45: aload           5
        //    47: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //    50: new             Ljava/io/DataInputStream;
        //    53: astore          5
        //    55: aload           5
        //    57: aload           6
        //    59: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    62: aload           5
        //    64: invokevirtual   java/io/DataInputStream.readInt:()I
        //    67: istore          8
        //    69: aload_0        
        //    70: iload           8
        //    72: putfield        a.aP:I
        //    75: iconst_0       
        //    76: istore          8
        //    78: aload_0        
        //    79: getfield        a.aP:I
        //    82: istore          9
        //    84: iload           8
        //    86: iload           9
        //    88: if_icmpge       153
        //    91: iconst_0       
        //    92: istore          9
        //    94: aconst_null    
        //    95: astore          10
        //    97: bipush          28
        //    99: istore          11
        //   101: iload           9
        //   103: iload           11
        //   105: if_icmpge       144
        //   108: aload_0        
        //   109: getfield        a.b1066:[[I
        //   112: astore          12
        //   114: aload           12
        //   116: iload           8
        //   118: aaload         
        //   119: astore          12
        //   121: aload           5
        //   123: invokevirtual   java/io/DataInputStream.readInt:()I
        //   126: istore          13
        //   128: aload           12
        //   130: iload           9
        //   132: iload           13
        //   134: iastore        
        //   135: iload           9
        //   137: iconst_1       
        //   138: iadd           
        //   139: istore          9
        //   141: goto            97
        //   144: iload           8
        //   146: iconst_1       
        //   147: iadd           
        //   148: istore          8
        //   150: goto            78
        //   153: aload           5
        //   155: invokevirtual   java/io/DataInputStream.readInt:()I
        //   158: istore          8
        //   160: aload_0        
        //   161: iload           8
        //   163: putfield        a.bt:I
        //   166: iconst_0       
        //   167: istore          8
        //   169: aload_0        
        //   170: getfield        a.bt:I
        //   173: istore          9
        //   175: iload           8
        //   177: iload           9
        //   179: if_icmpge       244
        //   182: iconst_0       
        //   183: istore          9
        //   185: aconst_null    
        //   186: astore          10
        //   188: bipush          18
        //   190: istore          11
        //   192: iload           9
        //   194: iload           11
        //   196: if_icmpge       235
        //   199: aload_0        
        //   200: getfield        a.c1107:[[I
        //   203: astore          12
        //   205: aload           12
        //   207: iload           8
        //   209: aaload         
        //   210: astore          12
        //   212: aload           5
        //   214: invokevirtual   java/io/DataInputStream.readInt:()I
        //   217: istore          13
        //   219: aload           12
        //   221: iload           9
        //   223: iload           13
        //   225: iastore        
        //   226: iload           9
        //   228: iconst_1       
        //   229: iadd           
        //   230: istore          9
        //   232: goto            188
        //   235: iload           8
        //   237: iconst_1       
        //   238: iadd           
        //   239: istore          8
        //   241: goto            169
        //   244: iconst_0       
        //   245: istore          8
        //   247: iconst_5       
        //   248: istore          9
        //   250: iload           8
        //   252: iload           9
        //   254: if_icmpge       286
        //   257: aload_0        
        //   258: getfield        a.a1056:[Z
        //   261: astore          10
        //   263: aload           5
        //   265: invokevirtual   java/io/DataInputStream.readBoolean:()Z
        //   268: istore          11
        //   270: aload           10
        //   272: iload           8
        //   274: iload           11
        //   276: bastore        
        //   277: iload           8
        //   279: iconst_1       
        //   280: iadd           
        //   281: istore          8
        //   283: goto            247
        //   286: iconst_0       
        //   287: istore          8
        //   289: bipush          10
        //   291: istore          9
        //   293: iload           8
        //   295: iload           9
        //   297: if_icmpge       329
        //   300: aload_0        
        //   301: getfield        a.b1059:[Z
        //   304: astore          10
        //   306: aload           5
        //   308: invokevirtual   java/io/DataInputStream.readBoolean:()Z
        //   311: istore          11
        //   313: aload           10
        //   315: iload           8
        //   317: iload           11
        //   319: bastore        
        //   320: iload           8
        //   322: iconst_1       
        //   323: iadd           
        //   324: istore          8
        //   326: goto            289
        //   329: iconst_0       
        //   330: istore          8
        //   332: iload           8
        //   334: iload_1        
        //   335: if_icmpge       367
        //   338: aload_0        
        //   339: getfield        a.e1105:[Z
        //   342: astore          10
        //   344: aload           5
        //   346: invokevirtual   java/io/DataInputStream.readBoolean:()Z
        //   349: istore          11
        //   351: aload           10
        //   353: iload           8
        //   355: iload           11
        //   357: bastore        
        //   358: iload           8
        //   360: iconst_1       
        //   361: iadd           
        //   362: istore          8
        //   364: goto            332
        //   367: iconst_0       
        //   368: istore          8
        //   370: iload           8
        //   372: iload_1        
        //   373: if_icmpge       405
        //   376: aload_0        
        //   377: getfield        a.f1106:[Z
        //   380: astore          10
        //   382: aload           5
        //   384: invokevirtual   java/io/DataInputStream.readBoolean:()Z
        //   387: istore          11
        //   389: aload           10
        //   391: iload           8
        //   393: iload           11
        //   395: bastore        
        //   396: iload           8
        //   398: iconst_1       
        //   399: iadd           
        //   400: istore          8
        //   402: goto            370
        //   405: aload           5
        //   407: invokevirtual   java/io/DataInputStream.readInt:()I
        //   410: istore          8
        //   412: aload_0        
        //   413: iload           8
        //   415: putfield        a.aq:I
        //   418: aload           5
        //   420: invokevirtual   java/io/DataInputStream.readInt:()I
        //   423: istore          8
        //   425: aload_0        
        //   426: iload           8
        //   428: putfield        a.bj:I
        //   431: aload           5
        //   433: invokevirtual   java/io/DataInputStream.readInt:()I
        //   436: istore          8
        //   438: aload_0        
        //   439: iload           8
        //   441: putfield        a.bN:I
        //   444: aload           5
        //   446: invokevirtual   java/io/DataInputStream.readInt:()I
        //   449: istore          8
        //   451: aload_0        
        //   452: iload           8
        //   454: putfield        a.bO:I
        //   457: aload           5
        //   459: invokevirtual   java/io/DataInputStream.readInt:()I
        //   462: istore          8
        //   464: aload_0        
        //   465: iload           8
        //   467: putfield        a.bP:I
        //   470: aload           5
        //   472: invokevirtual   java/io/DataInputStream.readInt:()I
        //   475: istore          8
        //   477: aload_0        
        //   478: iload           8
        //   480: putfield        a.bQ:I
        //   483: aload           5
        //   485: invokevirtual   java/io/DataInputStream.readInt:()I
        //   488: istore          8
        //   490: aload_0        
        //   491: iload           8
        //   493: putfield        a.T:I
        //   496: aload           5
        //   498: invokevirtual   java/io/DataInputStream.readInt:()I
        //   501: istore          8
        //   503: aload_0        
        //   504: iload           8
        //   506: putfield        a.aO:I
        //   509: aload           5
        //   511: invokevirtual   java/io/DataInputStream.readInt:()I
        //   514: istore          8
        //   516: aload_0        
        //   517: iload           8
        //   519: putfield        a.aS:I
        //   522: aload           5
        //   524: invokevirtual   java/io/DataInputStream.readInt:()I
        //   527: istore          8
        //   529: aload_0        
        //   530: iload           8
        //   532: putfield        a.X:I
        //   535: aload           5
        //   537: invokevirtual   java/io/DataInputStream.readInt:()I
        //   540: istore          8
        //   542: aload_0        
        //   543: iload           8
        //   545: putfield        a.bz:I
        //   548: aload           5
        //   550: invokevirtual   java/io/DataInputStream.readInt:()I
        //   553: istore          8
        //   555: aload_0        
        //   556: iload           8
        //   558: putfield        a.by:I
        //   561: aload           5
        //   563: invokevirtual   java/io/DataInputStream.readInt:()I
        //   566: istore          8
        //   568: aload_0        
        //   569: iload           8
        //   571: putfield        a.aT:I
        //   574: aload           5
        //   576: invokevirtual   java/io/DataInputStream.readInt:()I
        //   579: istore          8
        //   581: aload_0        
        //   582: iload           8
        //   584: putfield        a.aQ:I
        //   587: aload           5
        //   589: invokevirtual   java/io/DataInputStream.readInt:()I
        //   592: istore          8
        //   594: aload_0        
        //   595: iload           8
        //   597: putfield        a.ay:I
        //   600: aload           5
        //   602: invokevirtual   java/io/DataInputStream.readInt:()I
        //   605: istore          8
        //   607: aload_0        
        //   608: iload           8
        //   610: putfield        a.az:I
        //   613: aload           5
        //   615: invokevirtual   java/io/DataInputStream.readBoolean:()Z
        //   618: istore          8
        //   620: aload_0        
        //   621: iload           8
        //   623: putfield        a.p1078:Z
        //   626: aload           5
        //   628: invokevirtual   java/io/DataInputStream.readInt:()I
        //   631: istore          8
        //   633: aload_0        
        //   634: iload           8
        //   636: putfield        a.bL:I
        //   639: aload           5
        //   641: invokevirtual   java/io/DataInputStream.readInt:()I
        //   644: istore          8
        //   646: aload_0        
        //   647: iload           8
        //   649: putfield        a.bM:I
        //   652: aload           5
        //   654: invokevirtual   java/io/DataInputStream.readInt:()I
        //   657: istore          8
        //   659: aload_0        
        //   660: iload           8
        //   662: putfield        a.ac:I
        //   665: aload           5
        //   667: invokevirtual   java/io/DataInputStream.readInt:()I
        //   670: istore          8
        //   672: aload_0        
        //   673: iload           8
        //   675: putfield        a.aV:I
        //   678: aload           5
        //   680: invokevirtual   java/io/DataInputStream.readInt:()I
        //   683: istore          8
        //   685: aload_0        
        //   686: iload           8
        //   688: putfield        a.aW:I
        //   691: aload           5
        //   693: invokevirtual   java/io/DataInputStream.readInt:()I
        //   696: istore          8
        //   698: aload_0        
        //   699: iload           8
        //   701: putfield        a.aX:I
        //   704: aload           5
        //   706: invokevirtual   java/io/DataInputStream.readInt:()I
        //   709: istore          8
        //   711: aload_0        
        //   712: iload           8
        //   714: putfield        a.aY:I
        //   717: aload           5
        //   719: invokevirtual   java/io/DataInputStream.readInt:()I
        //   722: istore          8
        //   724: aload_0        
        //   725: iload           8
        //   727: putfield        a.aZ:I
        //   730: aload           5
        //   732: invokevirtual   java/io/DataInputStream.readInt:()I
        //   735: istore          8
        //   737: aload_0        
        //   738: iload           8
        //   740: putfield        a.ba:I
        //   743: aload           5
        //   745: invokevirtual   java/io/DataInputStream.readInt:()I
        //   748: istore          8
        //   750: aload_0        
        //   751: iload           8
        //   753: putfield        a.bb:I
        //   756: aload           5
        //   758: invokevirtual   java/io/DataInputStream.readBoolean:()Z
        //   761: istore          8
        //   763: aload_0        
        //   764: iload           8
        //   766: putfield        a.z1169:Z
        //   769: aload           5
        //   771: invokevirtual   java/io/DataInputStream.close:()V
        //   774: aload           6
        //   776: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //   779: aload           4
        //   781: invokevirtual   javax/microedition/rms/RecordStore.closeRecordStore:()V
        //   784: iload_2        
        //   785: istore_3       
        //   786: iload_3        
        //   787: ireturn        
        //   788: astore          5
        //   790: aload           4
        //   792: ifnull          800
        //   795: aload           4
        //   797: invokevirtual   javax/microedition/rms/RecordStore.closeRecordStore:()V
        //   800: iconst_0       
        //   801: istore_3       
        //   802: aconst_null    
        //   803: astore          4
        //   805: goto            786
        //   808: astore          4
        //   810: goto            800
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  20     24     788    813    Ljava/lang/Exception;
        //  31     36     788    813    Ljava/lang/Exception;
        //  38     41     788    813    Ljava/lang/Exception;
        //  45     50     788    813    Ljava/lang/Exception;
        //  50     53     788    813    Ljava/lang/Exception;
        //  57     62     788    813    Ljava/lang/Exception;
        //  62     67     788    813    Ljava/lang/Exception;
        //  70     75     788    813    Ljava/lang/Exception;
        //  78     82     788    813    Ljava/lang/Exception;
        //  108    112    788    813    Ljava/lang/Exception;
        //  116    119    788    813    Ljava/lang/Exception;
        //  121    126    788    813    Ljava/lang/Exception;
        //  132    135    788    813    Ljava/lang/Exception;
        //  153    158    788    813    Ljava/lang/Exception;
        //  161    166    788    813    Ljava/lang/Exception;
        //  169    173    788    813    Ljava/lang/Exception;
        //  199    203    788    813    Ljava/lang/Exception;
        //  207    210    788    813    Ljava/lang/Exception;
        //  212    217    788    813    Ljava/lang/Exception;
        //  223    226    788    813    Ljava/lang/Exception;
        //  257    261    788    813    Ljava/lang/Exception;
        //  263    268    788    813    Ljava/lang/Exception;
        //  274    277    788    813    Ljava/lang/Exception;
        //  300    304    788    813    Ljava/lang/Exception;
        //  306    311    788    813    Ljava/lang/Exception;
        //  317    320    788    813    Ljava/lang/Exception;
        //  338    342    788    813    Ljava/lang/Exception;
        //  344    349    788    813    Ljava/lang/Exception;
        //  355    358    788    813    Ljava/lang/Exception;
        //  376    380    788    813    Ljava/lang/Exception;
        //  382    387    788    813    Ljava/lang/Exception;
        //  393    396    788    813    Ljava/lang/Exception;
        //  405    410    788    813    Ljava/lang/Exception;
        //  413    418    788    813    Ljava/lang/Exception;
        //  418    423    788    813    Ljava/lang/Exception;
        //  426    431    788    813    Ljava/lang/Exception;
        //  431    436    788    813    Ljava/lang/Exception;
        //  439    444    788    813    Ljava/lang/Exception;
        //  444    449    788    813    Ljava/lang/Exception;
        //  452    457    788    813    Ljava/lang/Exception;
        //  457    462    788    813    Ljava/lang/Exception;
        //  465    470    788    813    Ljava/lang/Exception;
        //  470    475    788    813    Ljava/lang/Exception;
        //  478    483    788    813    Ljava/lang/Exception;
        //  483    488    788    813    Ljava/lang/Exception;
        //  491    496    788    813    Ljava/lang/Exception;
        //  496    501    788    813    Ljava/lang/Exception;
        //  504    509    788    813    Ljava/lang/Exception;
        //  509    514    788    813    Ljava/lang/Exception;
        //  517    522    788    813    Ljava/lang/Exception;
        //  522    527    788    813    Ljava/lang/Exception;
        //  530    535    788    813    Ljava/lang/Exception;
        //  535    540    788    813    Ljava/lang/Exception;
        //  543    548    788    813    Ljava/lang/Exception;
        //  548    553    788    813    Ljava/lang/Exception;
        //  556    561    788    813    Ljava/lang/Exception;
        //  561    566    788    813    Ljava/lang/Exception;
        //  569    574    788    813    Ljava/lang/Exception;
        //  574    579    788    813    Ljava/lang/Exception;
        //  582    587    788    813    Ljava/lang/Exception;
        //  587    592    788    813    Ljava/lang/Exception;
        //  595    600    788    813    Ljava/lang/Exception;
        //  600    605    788    813    Ljava/lang/Exception;
        //  608    613    788    813    Ljava/lang/Exception;
        //  613    618    788    813    Ljava/lang/Exception;
        //  621    626    788    813    Ljava/lang/Exception;
        //  626    631    788    813    Ljava/lang/Exception;
        //  634    639    788    813    Ljava/lang/Exception;
        //  639    644    788    813    Ljava/lang/Exception;
        //  647    652    788    813    Ljava/lang/Exception;
        //  652    657    788    813    Ljava/lang/Exception;
        //  660    665    788    813    Ljava/lang/Exception;
        //  665    670    788    813    Ljava/lang/Exception;
        //  673    678    788    813    Ljava/lang/Exception;
        //  678    683    788    813    Ljava/lang/Exception;
        //  686    691    788    813    Ljava/lang/Exception;
        //  691    696    788    813    Ljava/lang/Exception;
        //  699    704    788    813    Ljava/lang/Exception;
        //  704    709    788    813    Ljava/lang/Exception;
        //  712    717    788    813    Ljava/lang/Exception;
        //  717    722    788    813    Ljava/lang/Exception;
        //  725    730    788    813    Ljava/lang/Exception;
        //  730    735    788    813    Ljava/lang/Exception;
        //  738    743    788    813    Ljava/lang/Exception;
        //  743    748    788    813    Ljava/lang/Exception;
        //  751    756    788    813    Ljava/lang/Exception;
        //  756    761    788    813    Ljava/lang/Exception;
        //  764    769    788    813    Ljava/lang/Exception;
        //  769    774    788    813    Ljava/lang/Exception;
        //  774    779    788    813    Ljava/lang/Exception;
        //  779    784    788    813    Ljava/lang/Exception;
        //  795    800    808    813    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 400 out of bounds for length 400
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:359)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:427)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3362)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3611)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:112)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static boolean a(final int n) {
        return (n & 0x1) != 0x0;
    }
    
    private boolean a(final int n, final int n2) {
        final int n3 = 16;
        final int n4 = 1;
        final int az = -1;
        final int a = this.a(n, n2);
        int n5;
        if (Math.abs(this.E1163[a]) >= 12) {
            this.ay = this.d(a);
            if (this.ay == az) {
                n5 = 0;
            }
            else {
                this.az = az;
                n5 = n4;
            }
        }
        else if (this.E1163[a] < 8) {
            for (int i = 0; i < this.aP; ++i) {
                if (a(this.b1066[i][0], this.b1066[i][n4], this.bN, this.bO, n3, n3)) {
                    this.az = i;
                    n5 = n4;
                    return n5 != 0;
                }
            }
            this.ay = az;
            this.az = az;
            n5 = 0;
        }
        else {
            this.ay = az;
            this.az = az;
            n5 = 0;
        }
        return n5 != 0;
    }
    
    private boolean a(final int n, final int n2, final int n3) {
        final int n4 = 1;
        this.m1129[n3] = -1;
        byte b;
        if (this.x1126) {
            for (int i = 0; i < this.o1098[this.bw]; ++i) {
                int n5;
                if (this.x1128[n3][0] == n4) {
                    n5 = i << 4;
                }
                else if (this.x1128[n3][0] < 0) {
                    n5 = this.x1128[n3][0];
                }
                else {
                    n5 = this.o1098[this.bw] << 4;
                }
                final int n6 = n5 + n;
                int n7;
                if (this.x1128[n3][n4] == n4) {
                    n7 = i << 4;
                }
                else if (this.x1128[n3][n4] < 0) {
                    n7 = this.x1128[n3][n4];
                }
                else {
                    n7 = (this.o1098[this.bw] << 4) + 16;
                }
                if (!this.h(n6, n7 + n2)) {
                    b = 0;
                    return b != 0;
                }
            }
            this.m1129[n3] = n3;
            b = (byte)n4;
        }
        else {
            b = 0;
        }
        return b != 0;
    }
    
    private boolean a(final int n, final int n2, final int n3, final int n4, final int n5) {
        return b(n, n2, n3, n4) < n5 * n5;
    }
    
    private static boolean a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        return n >= n3 && n <= n3 + n5 && n2 >= n4 && n2 <= n4 + n6;
    }
    
    private boolean a(final int n, final int n2, final int n3, final boolean b) {
        final int n4 = 3;
        final int n5 = 3;
        while (true) {
            Label_0052: {
                if (!b) {
                    break Label_0052;
                }
                int n6 = 0;
                int n7 = 0;
                int i = 0;
                int n8 = 0;
                switch (n3) {
                    default: {
                        break Label_0052;
                    }
                    case 0:
                    case 2: {
                        n6 = 2;
                        n7 = n5;
                        i = 1;
                        n8 = 0;
                        break;
                    }
                    case 1:
                    case 3: {
                        final int n9 = 1;
                        i = 0;
                        n7 = 2;
                        n6 = n4;
                        n8 = n9;
                        break;
                    }
                }
                while (i < n6) {
                    for (int j = n8; j < n7; ++j) {
                        if (!this.d((i << 4) * this.m1084[n3][0] + n + this.m1084[n3][2], (j << 4) * this.m1084[n3][1] + n2 + this.m1084[n3][3])) {
                            return true;
                        }
                    }
                    ++i;
                }
                return false;
            }
            int n6 = n4;
            int n8 = 0;
            final int n10 = n5;
            int i = 0;
            int n7 = n10;
            continue;
        }
    }
    
    private void aa() {
        final int n = 240;
        final short n2 = 8;
        final int n3 = 1;
        Label_0044: {
            switch (this.br) {
                case 0: {
                    this.bN = this.b1069[this.aN][0] - n2;
                    this.bO = this.b1069[this.aN][n3] - n2;
                    this.y1155 = (n3 != 0);
                    this.br = n3;
                    break;
                }
                case 1: {
                    final int bn = this.bn - 32;
                    this.bn = bn;
                    if (bn < this.bl) {
                        this.bn = this.bl;
                        this.bp = n - (this.bl << 1);
                    }
                    else {
                        this.bp += 64;
                    }
                    final int bo = this.bo - 4;
                    this.bo = bo;
                    if (bo < this.bm) {
                        this.bo = this.bm;
                        this.bq = this.bk;
                    }
                    else {
                        this.bq += 8;
                    }
                    if (this.bp == n - (this.bl << 1) && this.bq == this.bk) {
                        this.br = 2;
                        break;
                    }
                    break;
                }
                case 2: {
                    switch (this.h1047) {
                        default: {
                            break Label_0044;
                        }
                        case -6:
                        case -5:
                        case 53: {
                            this.a();
                            break Label_0044;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    private void ab() {
        this.br = 0;
        this.bk = this.j * 2 + 10;
        this.bl = 4;
        this.bm = 280 - this.bk;
        this.bn = 120;
        this.bo = this.bm + (this.bk >> 1);
        this.bp = 0;
        this.bq = 0;
        this.a(22);
    }
    
    private void ac() {
        final int n = 240;
        final int n2 = 2;
        this.a1002.setClip(0, 0, n, 320);
        this.a1002.setColor(16580557);
        this.a1002.fillRect(this.bn, this.bo, this.bp, this.bq);
        this.a1002.fillRect(this.bn - 1, this.bo + 1, this.bp + 2, this.bq - n2);
        if (this.br == n2) {
            this.a1002.fillTriangle(this.bl + 15, this.bm + this.bk, this.bl + 15 + 8, this.bm + this.bk, this.bl + 15 + 8, this.bm + this.bk + 8);
            this.a1002.setColor(5465994);
            this.a(new StringBuffer().append(this.b1015[this.X * 11 + 28]).append("\uff1a").append(this.b1015[this.bs + 171]).toString(), 0, this.bl + 10, this.bm + 5, n - (this.bl + 10) * 2, this.bk);
        }
    }
    
    private void ad() {
        final int n = 240;
        Label_0032: {
            switch (this.br) {
                case 1: {
                    final int bn = this.bn - 32;
                    this.bn = bn;
                    if (bn < this.bl) {
                        this.bn = this.bl;
                        this.bp = n - (this.bl << 1);
                    }
                    else {
                        this.bp += 64;
                    }
                    final int bo = this.bo - 4;
                    this.bo = bo;
                    if (bo < this.bm) {
                        this.bo = this.bm;
                        this.bq = this.bk;
                    }
                    else {
                        this.bq += 8;
                    }
                    if (this.bp == n - (this.bl << 1) && this.bq == this.bk) {
                        this.br = 2;
                        break;
                    }
                    break;
                }
                case 2: {
                    switch (this.h1047) {
                        default: {
                            break Label_0032;
                        }
                        case -6:
                        case -5:
                        case 53: {
                            ++this.bs;
                            if (this.bs > 3) {
                                this.v1097 = false;
                                this.a();
                                break Label_0032;
                            }
                            break Label_0032;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    private void ae() {
        this.br = 1;
        this.bk = this.j * 3 + 10;
        this.bl = 4;
        this.bm = 280 - this.bk;
        this.bn = 120;
        this.bo = this.bm + this.bk >> 1;
        this.bp = 0;
        this.bq = 0;
        this.bs = 0;
        this.a(23);
    }
    
    private void af() {
        if (this.w1111) {
            if (this.bu < this.a1013[3][20].getWidth() / 27) {
                ++this.bu;
            }
            else {
                this.bu = 0;
                this.w1111 = false;
            }
        }
    }
    
    private void ag() {
        a(this.p1154, this.c1107, this.bt, 1);
        for (int i = 0; i < this.bt; ++i) {
            final int[] array = this.c1107[this.p1154[i]];
            if (a(array[0] - this.bP, array[1] - this.bQ, -48, -48, 336, 320)) {
                final int n = this.o1098[array[2]] << 3;
                if (array[2] == 10 && array[5] == 0) {
                    this.c(array[5], array[0], array[1], array[15], array[13], array[10]);
                }
                if (array[4] != 5) {
                    this.a(array[2], array[3], array[0] + n - this.bP, array[1] + n - this.bQ, array[7], array[5], array[4]);
                    if (array[17] == 1) {
                        this.o(array[0] + n - 10 - this.bP, array[1] - this.bQ + 13);
                    }
                    if (g(array[3])) {
                        if (((int)this.a1019 & 0x1F) < 4) {
                            this.a1002.setClip(0, 0, 240, 320);
                            this.a1002.setColor(16777215);
                            this.a1002.fillArc(array[0] + n - this.bP, array[1] + n - (((int)this.a1019 & 0x1F) << 2) - this.bQ, ((int)this.a1019 & 0x1F) << 2, ((int)this.a1019 & 0x1F) << 2, 0, 360);
                            this.a1002.setColor(16761600);
                            this.a1002.drawArc(array[0] + n - this.bP, array[1] + n - (((int)this.a1019 & 0x1F) << 2) - this.bQ, ((int)this.a1019 & 0x1F) << 2, ((int)this.a1019 & 0x1F) << 2, 0, 360);
                        }
                        else if (((int)this.a1019 & 0x1F) > 27 && ((int)this.a1019 & 0x1F) < 32) {
                            this.a1002.setClip(0, 0, 240, 320);
                            this.a1002.setColor(16777215);
                            this.a1002.fillArc(array[0] + n - this.bP, array[1] + n - (31 - ((int)this.a1019 & 0x1F) << 2) - this.bQ, 31 - ((int)this.a1019 & 0x1F) << 2, 31 - ((int)this.a1019 & 0x1F) << 2, 0, 360);
                            this.a1002.setColor(16761600);
                            this.a1002.drawArc(array[0] + n - this.bP, array[1] + n - (31 - ((int)this.a1019 & 0x1F) << 2) - this.bQ, 31 - ((int)this.a1019 & 0x1F) << 2, 31 - ((int)this.a1019 & 0x1F) << 2, 0, 360);
                        }
                        else {
                            this.q(this.y1130[this.X][array[2]], array[0] + n - this.bP, array[1] + n - 16 - this.bQ);
                        }
                    }
                }
                switch (array[4]) {
                    case 3:
                    case 4:
                    case 5: {
                        this.d(array[2], array[4], array[0], array[1]);
                        break;
                    }
                }
                if (array[2] == 10 && array[5] != 0) {
                    this.c(array[5], array[0], array[1], array[15], array[13], array[10]);
                }
            }
        }
        for (int j = 0; j < this.bt; ++j) {
            final int[] array2 = this.c1107[this.p1154[j]];
            final int n2 = this.o1098[array2[2]] << 3;
            if (a(array2[0] - this.bP, array2[1] - this.bQ, -48, -48, 336, 320)) {
                if (array2[4] == 1 && array2[10] != 3) {
                    this.y(this.p1154[j]);
                }
                if (array2[4] == 6 && array2[14] != 10) {
                    switch (array2[2]) {
                        case 0:
                        case 4: {
                            this.a(this.a1013[29][0], array2[0] - this.bP + n2 - 10, array2[1] + n2 - this.bQ - 20, array2[14] * 18, 0, 18, 24, 0, 0);
                            break;
                        }
                    }
                }
            }
        }
    }
    
    private void ah() {
        final int n = 1;
        final int n2 = 6;
        final int n3 = 4;
        final int n4 = 2;
        for (int i = 0; i < this.bt; ++i) {
            final int[] array = this.c1107[i];
            array[7] = this.c(i, array[7], array[n4]);
            if (this.q(array[n4], array[3])) {
                this.n(array[0] + (this.o1098[array[n4]] << 3), array[n] + (this.o1098[array[n4]] << 3));
            }
            switch (array[n3]) {
                case 6: {
                    this.e(i);
                    break;
                }
                case 0: {
                    if (this.aP <= 0 && (array[n4] == 0 || array[n4] == n3)) {
                        array[n3] = n2;
                        array[14] = -1;
                    }
                    this.e(i);
                    break;
                }
                case 1: {
                    this.l(i, array[8]);
                    break;
                }
                case 2: {
                    final int n5 = array[n2] - n;
                    array[n2] = n5;
                    if (n5 < 0) {
                        array[n3] = (array[n2] = 0);
                        break;
                    }
                    break;
                }
                case 3:
                case 4:
                case 5: {
                    this.j(i, array[n3]);
                    break;
                }
            }
        }
        this.af();
    }
    
    private void ai() {
        for (int i = 0; i < this.bt; ++i) {
            final int[] array = this.c1107[this.p1154[i]];
            if (a(array[0] - this.bP, array[1] - this.bQ, -48, -48, 336, 320) && array[4] == 1 && array[10] != 3) {
                switch (array[2]) {
                    case 8: {
                        this.b(this.a1013[29][31], array[5], array[0], array[1], array[13], array[11], array[10], array[2], array[3]);
                        break;
                    }
                    case 9: {
                        this.b(this.a1013[29][35], array[5], array[0], array[1], array[13], array[11], array[10], array[2], array[3]);
                        break;
                    }
                }
            }
            if (a(array[0] - this.bP, array[1] - this.bQ, -96, -102, 358, 438)) {
                switch (array[2]) {
                    case 2: {
                        this.d(this.a1013[29][40], array[5], array[0], array[1]);
                        break;
                    }
                    case 10: {
                        this.e(this.a1013[29][43], array[5], array[0], array[1]);
                        break;
                    }
                }
            }
        }
    }
    
    private void aj() {
        final int n = 11;
        final int by = 10;
        final boolean b = true;
        final int n2 = -1;
        if (this.T == 0) {
            this.bz = 300;
        }
        else {
            this.bz = 250;
        }
        this.z1169 = false;
        this.by = by;
        this.aT = 0;
        this.aX = 0;
        this.aP = 0;
        this.aQ = 0;
        this.aS = 0;
        this.bt = 0;
        this.ay = n2;
        this.az = n2;
        this.p1078 = false;
        this.bF = 0;
        this.aw = 0;
        this.bu = 0;
        for (int i = 0; i < 5; ++i) {
            this.a1056[i] = false;
        }
        for (int j = 0; j < by; ++j) {
            this.b1059[j] = (this.c1061[j] && b);
        }
        for (int k = 0; k < n; ++k) {
            this.e1105[k] = (k == 0 && b);
            this.f1106[k] = false;
        }
        this.c(29);
        for (int l = 0; l < n; ++l) {
            this.c(l + 18);
        }
    }
    
    private void ak() {
        final int n = 240;
        final int n2 = 304;
        final int n3 = 256;
        final int n4 = 1;
        if (this.a1004 != null) {
            if (this.y1155) {
                this.y1155 = false;
                final int n5 = this.bQ >> 4;
                final int n6 = this.bP >> 4;
                this.bA = n6 << 4;
                this.bC = n5 << 4;
                for (int i = n5; i < n5 + 19; ++i) {
                    this.w(i, n6, 0);
                }
            }
            else {
                if (this.bP < this.bA) {
                    final int n7 = this.bA - this.bP >> 4;
                    int n8;
                    if ((this.bA - this.bP & 0xF) == 0x0) {
                        n8 = 0;
                    }
                    else {
                        n8 = n4;
                    }
                    final int n9 = n7 + n8;
                    this.bB -= n9 << 4;
                    this.bA -= n9 << 4;
                    if (this.bB < 0) {
                        this.bB += 256;
                    }
                    if (this.bA < 0) {
                        this.bA = 0;
                    }
                    for (int j = 0; j < n9; ++j) {
                        this.w(this.bC >> 4, (this.bA >> 4) + j, n4);
                    }
                }
                else if (this.bP + 240 > this.bA + 256) {
                    final int n10 = this.bP + 240 - this.bA - n3;
                    final int n11 = n10 >> 4;
                    int n12;
                    if ((n10 & 0xF) == 0x0) {
                        n12 = 0;
                    }
                    else {
                        n12 = n4;
                    }
                    final int n13 = n12 + n11;
                    this.bA += n13 << 4;
                    this.bB += n13 << 4;
                    if (this.bB >= n3) {
                        this.bB -= n3;
                    }
                    if (this.bA + 256 > this.bI) {
                        this.bA = this.bI - n3;
                    }
                    for (int k = 0; k < n13; ++k) {
                        this.w(this.bC >> 4, (this.bA >> 4) + 16 - n4 - k, n4);
                    }
                }
                if (this.bQ < this.bC) {
                    final int n14 = this.bC - this.bQ >> 4;
                    int n15;
                    if ((this.bC - this.bQ & 0xF) == 0x0) {
                        n15 = 0;
                    }
                    else {
                        n15 = n4;
                    }
                    final int n16 = n14 + n15;
                    this.bD -= n16 << 4;
                    this.bC -= n16 << 4;
                    if (this.bD < 0) {
                        this.bD += 304;
                    }
                    if (this.bC < 0) {
                        this.bC = 0;
                    }
                    for (int l = 0; l < n16; ++l) {
                        this.w((this.bC >> 4) + l, this.bA >> 4, 0);
                    }
                }
                else if (this.bQ + 276 > this.bC + 304) {
                    final int n17 = this.bQ + 276 - this.bC - n2;
                    final int n18 = n17 >> 4;
                    int n19;
                    if ((n17 & 0xF) == 0x0) {
                        n19 = 0;
                    }
                    else {
                        n19 = n4;
                    }
                    final int n20 = n19 + n18;
                    this.bC += n20 << 4;
                    this.bD += n20 << 4;
                    if (this.bD >= n2) {
                        this.bD -= n2;
                    }
                    if (this.bC + 304 > this.bJ) {
                        this.bC = this.bJ - n2;
                    }
                    for (int n21 = 0; n21 < n20; ++n21) {
                        this.w((this.bC >> 4) + 19 - n4 - n21, this.bA >> 4, 0);
                    }
                }
            }
            this.a1002.setClip(0, 0, n, 320);
            this.a1002.drawImage(this.a1004, 0 - this.bB + this.bA - this.bP, 0 - this.bD + this.bC - this.bQ + 13, 0);
            this.a1002.drawImage(this.a1004, 0 - this.bB + this.bA - this.bP, 0 - this.bD + this.bC - this.bQ + 304 + 13, 0);
            this.a1002.drawImage(this.a1004, 0 - this.bB + this.bA - this.bP + 256, 0 - this.bD + this.bC - this.bQ + 13, 0);
            this.a1002.drawImage(this.a1004, 0 - this.bB + this.bA - this.bP + 256, 0 - this.bD + this.bC - this.bQ + 304 + 13, 0);
            this.m(this.aK, this.aL, 0);
            this.m(this.aI, this.aJ, n4);
            this.ai();
            this.a1002.setClip(0, 0, n, 320);
        }
    }
    
    private void al() {
        final int n = -1;
        final byte b = 2;
        final int u1096 = 1;
        final int n2 = 16;
        int n3;
        if (this.l == 13) {
            if (this.o1098[this.bw] == b) {
                n3 = n2;
            }
            else {
                n3 = 32;
            }
        }
        else {
            n3 = 0;
        }
        switch (this.g1046) {
            case -1:
            case 50: {
                final int bo = this.bO - n2;
                this.bO = bo;
                if (bo < 0) {
                    this.bO = 0;
                    break;
                }
                break;
            }
            case -3:
            case 52: {
                final int bn = this.bN - n2;
                this.bN = bn;
                if (bn < 0) {
                    this.bN = 0;
                    break;
                }
                break;
            }
            case -4:
            case 54: {
                final int bn2 = this.bN + 16;
                this.bN = bn2;
                if (bn2 > this.bI - n2 - n3) {
                    this.bN = this.bI - n2 - n3;
                    break;
                }
                break;
            }
            case -2:
            case 56: {
                final int bo2 = this.bO + 16;
                this.bO = bo2;
                if (bo2 > this.bJ - n2 - n3) {
                    this.bO = this.bJ - n2 - n3;
                    break;
                }
                break;
            }
        }
        Label_0220: {
            if (this.l == b || this.l == 13) {
                switch (this.h1047) {
                    case -6:
                    case -5:
                    case 53: {
                        if (this.bu != 0) {
                            break;
                        }
                        if (this.bF == 0) {
                            if (this.ay != n) {
                                final int[] array = this.c1107[this.ay];
                                if (array[b] != 10) {
                                    int n4;
                                    if (g(array[3])) {
                                        n4 = 5;
                                    }
                                    else {
                                        n4 = b;
                                    }
                                    this.j(n4);
                                    break;
                                }
                                if (array[15] == 0) {
                                    int n5;
                                    if (g(array[3])) {
                                        n5 = 6;
                                    }
                                    else {
                                        n5 = 3;
                                    }
                                    this.j(n5);
                                    break;
                                }
                                int n6;
                                if (g(array[3])) {
                                    n6 = 7;
                                }
                                else {
                                    n6 = 4;
                                }
                                this.j(n6);
                                break;
                            }
                            else {
                                if (this.e(this.bN, this.bO)) {
                                    this.j(0);
                                    break;
                                }
                                if (this.g(this.bN, this.bO)) {
                                    this.j(u1096);
                                    break;
                                }
                                switch (this.h1047) {
                                    default: {
                                        break Label_0220;
                                    }
                                    case -6:
                                    case -5:
                                    case 53: {
                                        this.u1096 = (u1096 != 0);
                                        break Label_0220;
                                    }
                                }
                            }
                        }
                        else {
                            if (!this.x1126) {
                                break;
                            }
                            if (this.p1099[this.bw] != u1096) {
                                this.c(this.bN, this.bO, this.bw, n);
                                break;
                            }
                            int i = 0;
                            int n7 = 0;
                            while (i < 4) {
                                if (this.a(this.bN, this.bO, i) && this.m1129[i] != n) {
                                    n7 = this.m1129[i];
                                    ++this.bx;
                                }
                                ++i;
                            }
                            if (this.bx > u1096) {
                                for (int j = 0; j < 4; ++j) {
                                    if (this.m1129[j] != n) {
                                        this.aA = this.m1129[j];
                                        break;
                                    }
                                }
                                this.bx = 0;
                                this.a(14);
                                break;
                            }
                            if (this.bx == u1096) {
                                this.bx = 0;
                                this.c(this.bN, this.bO, this.bw, n7);
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    case -7: {
                        if (this.bF == u1096) {
                            this.bF = 0;
                            this.aw = 0;
                            this.b((int)b);
                            break;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    private void am() {
        final int n = 2;
        switch (this.bF) {
            case 0: {
                if (this.ay != -1) {
                    final int[] array = this.c1107[this.ay];
                    this.i(array[0], array[1], this.o1098[array[n]] << 4, this.o1098[array[n]] << 4);
                    break;
                }
                this.i(this.bN, this.bO, this.bE, this.bE);
                break;
            }
            case 1: {
                this.p(this.bN, this.bO);
                this.i(this.bN, this.bO, this.o1098[this.bw] << 4, this.o1098[this.bw] << 4);
                this.e(this.bN, this.bO, this.bw, 0);
                break;
            }
        }
    }
    
    private void an() {
        final int n = 16;
        final int n2 = 130;
        final int n3 = 112;
        if (this.bN >= n3 && this.bN <= this.bI - n - n3) {
            this.bP = this.bN - n3;
        }
        else if (this.bN < n3) {
            this.bP = 0;
        }
        else {
            this.bP = this.bI - 240;
        }
        if (this.bO >= n2 && this.bO <= this.bJ - n - n2) {
            this.bQ = this.bO - n2;
        }
        else if (this.bO < n2) {
            this.bQ = 0;
        }
        else {
            this.bQ = this.bJ - 276;
        }
    }
    
    private void ao() {
        final int n = 2;
        if (this.l == n) {
            if (this.h1047 == this.r1166[this.bU]) {
                ++this.bU;
                if (this.bU == this.r1166.length) {
                    this.bz += 1000;
                    this.bU = 0;
                }
            }
            else if (this.h1047 == this.s1167[this.bU]) {
                ++this.bU;
                if (this.bU == this.s1167.length) {
                    for (int i = 0; i < this.aP; ++i) {
                        this.b1066[i][n] = 0;
                    }
                    this.bU = 0;
                }
            }
            else if (this.h1047 == this.t1168[this.bU]) {
                ++this.bU;
                if (this.bU == this.s1167.length) {
                    for (int j = 0; j < 9; ++j) {
                        this.d1073[j] = true;
                    }
                    this.bU = 0;
                }
            }
            else {
                this.bU = 0;
            }
        }
    }
    
    private void ap() {
        final int n = 120;
        final int n2 = 90;
        final int n3 = 240;
        final int n4 = 175;
        this.a1002.setColor(16580557);
        this.a1002.fillRect(n3 - (this.b1015[n4].length() * this.k + 8) >> 1, n2, this.b1015[n4].length() * this.k + 8, n);
        this.c(n3 - (this.b1015[n4].length() * this.k + 8) >> 1, n2, this.b1015[n4].length() * this.k + 8, n, 1);
        this.a1002.setClip(0, 0, n3, 320);
        for (int i = 0; i < 5; ++i) {
            if (i == this.r) {
                this.a1002.setColor(14311547);
            }
            else {
                this.a1002.setColor(15455661);
            }
            this.a1002.drawString(this.b1015[i + 175], n3 - this.b1015[i + 175].length() * this.k >> 1, i * 20 + 100, 0);
        }
    }
    
    private void aq() {
        final int r = 4;
        final int n = 1;
        switch (this.h1047) {
            case -1:
            case 50: {
                final int r2 = this.r - n;
                this.r = r2;
                if (r2 < 0) {
                    this.r = r;
                }
                if (this.e() && this.r == n) {
                    this.r -= n;
                }
                if (this.z1169 && this.r == r) {
                    this.r = 3;
                    break;
                }
                break;
            }
            case -2:
            case 56: {
                final int r3 = this.r + 1;
                this.r = r3;
                if (r3 > r) {
                    this.r = 0;
                }
                if (this.e() && this.r == n) {
                    ++this.r;
                }
                if (this.z1169 && this.r == r) {
                    this.r = 0;
                    break;
                }
                break;
            }
            case -6:
            case -5:
            case 53: {
                this.F(this.bW = this.r);
                break;
            }
            case -7: {
                this.r = 0;
                this.a();
                break;
            }
        }
    }
    
    private final void ar() {
        this.e();
        this.a1002.setColor(14311547);
        this.a1002.setClip(0, 0, 240, 320);
        final String s = "";
        String string = null;
        Label_0071: {
            Label_0068: {
                switch (this.l) {
                    case 48: {
                        string = this.d1173[7];
                        break Label_0071;
                    }
                    case 47: {
                        string = this.d1173[8];
                        break Label_0071;
                    }
                    case 46: {
                        switch (this.b1174) {
                            default: {
                                break Label_0068;
                            }
                            case 0: {
                                if (this.o != -1) {
                                    string = new StringBuffer().append(this.b1015[this.o + 113]).append(this.d1173[this.bW + 0]).toString();
                                    break Label_0071;
                                }
                                string = this.d1173[this.bW + 0];
                                break Label_0071;
                            }
                            case 1: {
                                string = this.d1173[9];
                                break Label_0071;
                            }
                            case 2: {
                                string = this.d1173[10];
                                break Label_0071;
                            }
                            case 3: {
                                string = this.d1173[11];
                                break Label_0071;
                            }
                        }
                        break;
                    }
                }
            }
            string = s;
        }
        this.a(string, this.c, 27, 70, 186, 292);
        this.f();
        this.c(2, 3);
    }
    
    private final void as() {
        final int n = 47;
        final int n2 = 2;
        final int n3 = 1;
        Label_0044: {
            switch (this.b1174) {
                case 0: {
                    switch (this.h1047) {
                        default: {
                            break Label_0044;
                        }
                        case -7: {
                            this.a();
                            break Label_0044;
                        }
                        case -1:
                        case 50: {
                            if (this.c > 0) {
                                this.c -= n3;
                                break Label_0044;
                            }
                            break Label_0044;
                        }
                        case -2:
                        case 56: {
                            if (this.c < this.a1007 - this.b1008) {
                                ++this.c;
                                break Label_0044;
                            }
                            break Label_0044;
                        }
                        case -6:
                        case -5:
                        case 53: {
                            this.a(n);
                            this.at();
                            break Label_0044;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (this.h1047) {
                        default: {
                            break Label_0044;
                        }
                        case -7:
                        case -6:
                        case -5:
                        case 53: {
                            this.a();
                            switch (this.bW) {
                                default: {
                                    break Label_0044;
                                }
                                case 0: {
                                    for (int i = 0; i < this.aP; ++i) {
                                        this.b1066[i][n2] = 0;
                                    }
                                    break Label_0044;
                                }
                                case 1: {
                                    for (int j = 0; j < 5; ++j) {
                                        this.a1056[j] = (n3 != 0);
                                        this.b1059[this.h1060[j]] = (n3 != 0);
                                        for (int k = 0; k < n2; ++k) {
                                            this.e1105[this.g1065[j][k]] = (n3 != 0);
                                        }
                                        this.u(this.h1060[j]);
                                    }
                                    break Label_0044;
                                }
                                case 2: {
                                    this.bz += 500;
                                    break Label_0044;
                                }
                                case 3: {
                                    this.by += 10;
                                    break Label_0044;
                                }
                                case 4: {
                                    this.z1169 = (n3 != 0);
                                    break Label_0044;
                                }
                                case 5: {
                                    this.d1073[this.aN] = (n3 != 0);
                                    break Label_0044;
                                }
                                case 6: {
                                    this.A1170 = (n3 != 0);
                                    break Label_0044;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (this.h1047) {
                        default: {
                            break Label_0044;
                        }
                        case -7: {
                            this.a();
                            break Label_0044;
                        }
                        case -6:
                        case -5:
                        case 53: {
                            this.a(n);
                            this.at();
                            break Label_0044;
                        }
                    }
                    break;
                }
                case 3: {
                    switch (this.h1047) {
                        default: {
                            break Label_0044;
                        }
                        case -7: {
                            this.a();
                            break Label_0044;
                        }
                        case -6:
                        case -5:
                        case 53: {
                            if (this.F1180) {
                                b(this.d1181);
                                break Label_0044;
                            }
                            this.a();
                            break Label_0044;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    private void at() {
        this.b1174 = 1;
        this.a();
    }
    
    private void au() {
        this.a1185 = Calendar.getInstance();
        (this.a1184 = new Date()).setTime(System.currentTimeMillis());
        this.a1185.setTime(this.a1184);
        this.bX = this.a1185.get(1) * 10000;
        this.bX += this.a1185.get(2) * 100;
        this.bX += this.a1185.get(5);
        this.bX = 0;
    }
    
    private void av() {
        Object a1172 = this.a1172;
        monitorenter(a1172);
        final int bv = 2;
        try {
            this.bV = bv;
            monitorexit(a1172);
            a1172 = new MIDletThread(this);
            ((Thread)a1172).start();
        }
        finally {
            monitorexit(a1172);
        }
    }
    
    private final void aw() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_1       
        //     4: iconst_0       
        //     5: istore_2       
        //     6: aconst_null    
        //     7: astore_3       
        //     8: aload_1        
        //     9: iconst_0       
        //    10: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //    13: astore_1       
        //    14: iconst_1       
        //    15: istore_2       
        //    16: aload_1        
        //    17: iload_2        
        //    18: invokevirtual   javax/microedition/rms/RecordStore.getRecord:(I)[B
        //    21: astore_3       
        //    22: new             Ljava/io/ByteArrayInputStream;
        //    25: astore          4
        //    27: aload           4
        //    29: aload_3        
        //    30: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //    33: new             Ljava/io/DataInputStream;
        //    36: astore_3       
        //    37: aload_3        
        //    38: aload           4
        //    40: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    43: aload_3        
        //    44: invokevirtual   java/io/DataInputStream.readInt:()I
        //    47: pop            
        //    48: aload_3        
        //    49: invokevirtual   java/io/DataInputStream.readUTF:()Ljava/lang/String;
        //    52: astore          5
        //    54: aload_0        
        //    55: aload           5
        //    57: putfield        a.b1177:Ljava/lang/String;
        //    60: aload_3        
        //    61: invokevirtual   java/io/DataInputStream.readUTF:()Ljava/lang/String;
        //    64: astore          5
        //    66: aload_0        
        //    67: aload           5
        //    69: putfield        a.c1178:Ljava/lang/String;
        //    72: aload_3        
        //    73: invokevirtual   java/io/DataInputStream.readBoolean:()Z
        //    76: istore          6
        //    78: aload_0        
        //    79: iload           6
        //    81: putfield        a.F1180:Z
        //    84: aload_0        
        //    85: getfield        a.F1180:Z
        //    88: istore          6
        //    90: iload           6
        //    92: ifeq            107
        //    95: aload_3        
        //    96: invokevirtual   java/io/DataInputStream.readUTF:()Ljava/lang/String;
        //    99: astore          5
        //   101: aload_0        
        //   102: aload           5
        //   104: putfield        a.d1181:Ljava/lang/String;
        //   107: aload_3        
        //   108: invokevirtual   java/io/DataInputStream.readBoolean:()Z
        //   111: istore          6
        //   113: aload_0        
        //   114: iload           6
        //   116: putfield        a.G1182:Z
        //   119: aload_0        
        //   120: getfield        a.G1182:Z
        //   123: istore          6
        //   125: iload           6
        //   127: ifeq            142
        //   130: aload_3        
        //   131: invokevirtual   java/io/DataInputStream.readUTF:()Ljava/lang/String;
        //   134: astore          5
        //   136: aload_0        
        //   137: aload           5
        //   139: putfield        a.e1183:Ljava/lang/String;
        //   142: aload_3        
        //   143: invokevirtual   java/io/DataInputStream.close:()V
        //   146: aload           4
        //   148: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //   151: aload_1        
        //   152: invokevirtual   javax/microedition/rms/RecordStore.closeRecordStore:()V
        //   155: return         
        //   156: astore_1       
        //   157: ldc_w           "YXBY15 2LD210A10 IF2"
        //   160: astore_1       
        //   161: aload_0        
        //   162: aload_1        
        //   163: putfield        a.c1178:Ljava/lang/String;
        //   166: ldc_w           "106633000015"
        //   169: astore_1       
        //   170: aload_0        
        //   171: aload_1        
        //   172: putfield        a.b1177:Ljava/lang/String;
        //   175: aload_0        
        //   176: invokespecial   a.ax:()V
        //   179: goto            155
        //   182: astore_1       
        //   183: goto            155
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                 
        //  -----  -----  -----  -----  -----------------------------------------------------
        //  9      13     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  9      13     182    186    Ljava/lang/Exception;
        //  17     21     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  17     21     182    186    Ljava/lang/Exception;
        //  22     25     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  22     25     182    186    Ljava/lang/Exception;
        //  29     33     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  29     33     182    186    Ljava/lang/Exception;
        //  33     36     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  33     36     182    186    Ljava/lang/Exception;
        //  38     43     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  38     43     182    186    Ljava/lang/Exception;
        //  43     48     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  43     48     182    186    Ljava/lang/Exception;
        //  48     52     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  48     52     182    186    Ljava/lang/Exception;
        //  55     60     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  55     60     182    186    Ljava/lang/Exception;
        //  60     64     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  60     64     182    186    Ljava/lang/Exception;
        //  67     72     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  67     72     182    186    Ljava/lang/Exception;
        //  72     76     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  72     76     182    186    Ljava/lang/Exception;
        //  79     84     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  79     84     182    186    Ljava/lang/Exception;
        //  84     88     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  84     88     182    186    Ljava/lang/Exception;
        //  95     99     156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  95     99     182    186    Ljava/lang/Exception;
        //  102    107    156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  102    107    182    186    Ljava/lang/Exception;
        //  107    111    156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  107    111    182    186    Ljava/lang/Exception;
        //  114    119    156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  114    119    182    186    Ljava/lang/Exception;
        //  119    123    156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  119    123    182    186    Ljava/lang/Exception;
        //  130    134    156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  130    134    182    186    Ljava/lang/Exception;
        //  137    142    156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  137    142    182    186    Ljava/lang/Exception;
        //  142    146    156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  142    146    182    186    Ljava/lang/Exception;
        //  146    151    156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  146    151    182    186    Ljava/lang/Exception;
        //  151    155    156    182    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  151    155    182    186    Ljava/lang/Exception;
        //  162    166    182    186    Ljava/lang/Exception;
        //  171    175    182    186    Ljava/lang/Exception;
        //  175    179    182    186    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0107:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void ax() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_1       
        //     2: aconst_null    
        //     3: astore_2       
        //     4: ldc_w           "__sfSmsInfo"
        //     7: astore_3       
        //     8: iconst_0       
        //     9: istore          4
        //    11: aconst_null    
        //    12: astore          5
        //    14: aload_3        
        //    15: iconst_0       
        //    16: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //    19: astore          5
        //    21: iconst_0       
        //    22: istore          6
        //    24: aconst_null    
        //    25: astore_3       
        //    26: new             Ljava/io/ByteArrayOutputStream;
        //    29: astore_2       
        //    30: aload_2        
        //    31: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    34: new             Ljava/io/DataOutputStream;
        //    37: astore          7
        //    39: aload           7
        //    41: aload_2        
        //    42: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    45: aload_0        
        //    46: getfield        a.bX:I
        //    49: istore          8
        //    51: aload           7
        //    53: iload           8
        //    55: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //    58: aload_0        
        //    59: getfield        a.b1177:Ljava/lang/String;
        //    62: astore          9
        //    64: aload           7
        //    66: aload           9
        //    68: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //    71: aload_0        
        //    72: getfield        a.c1178:Ljava/lang/String;
        //    75: astore          9
        //    77: aload           7
        //    79: aload           9
        //    81: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //    84: aload_0        
        //    85: getfield        a.F1180:Z
        //    88: istore          8
        //    90: aload           7
        //    92: iload           8
        //    94: invokevirtual   java/io/DataOutputStream.writeBoolean:(Z)V
        //    97: aload_0        
        //    98: getfield        a.F1180:Z
        //   101: istore          8
        //   103: iload           8
        //   105: ifeq            121
        //   108: aload_0        
        //   109: getfield        a.d1181:Ljava/lang/String;
        //   112: astore          9
        //   114: aload           7
        //   116: aload           9
        //   118: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   121: aload_0        
        //   122: getfield        a.G1182:Z
        //   125: istore          8
        //   127: aload           7
        //   129: iload           8
        //   131: invokevirtual   java/io/DataOutputStream.writeBoolean:(Z)V
        //   134: aload_0        
        //   135: getfield        a.G1182:Z
        //   138: istore          8
        //   140: iload           8
        //   142: ifeq            158
        //   145: aload_0        
        //   146: getfield        a.e1183:Ljava/lang/String;
        //   149: astore          9
        //   151: aload           7
        //   153: aload           9
        //   155: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   158: iload           6
        //   160: ifeq            229
        //   163: aload_2        
        //   164: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   167: astore_3       
        //   168: iconst_0       
        //   169: istore          8
        //   171: aconst_null    
        //   172: astore          9
        //   174: aload_2        
        //   175: invokevirtual   java/io/ByteArrayOutputStream.size:()I
        //   178: istore          10
        //   180: aload           5
        //   182: aload_3        
        //   183: iconst_0       
        //   184: iload           10
        //   186: invokevirtual   javax/microedition/rms/RecordStore.addRecord:([BII)I
        //   189: pop            
        //   190: aload           7
        //   192: invokevirtual   java/io/DataOutputStream.close:()V
        //   195: aload_2        
        //   196: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //   199: aload           5
        //   201: invokevirtual   javax/microedition/rms/RecordStore.closeRecordStore:()V
        //   204: return         
        //   205: astore_3       
        //   206: ldc_w           "__sfSmsInfo"
        //   209: astore_3       
        //   210: iconst_1       
        //   211: istore          4
        //   213: aload_3        
        //   214: iload           4
        //   216: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //   219: astore_3       
        //   220: aload_3        
        //   221: astore          5
        //   223: iload_1        
        //   224: istore          6
        //   226: goto            26
        //   229: iconst_1       
        //   230: istore          6
        //   232: aload_2        
        //   233: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   236: astore          9
        //   238: iconst_0       
        //   239: istore          10
        //   241: aload_2        
        //   242: invokevirtual   java/io/ByteArrayOutputStream.size:()I
        //   245: istore          11
        //   247: aload           5
        //   249: iload           6
        //   251: aload           9
        //   253: iconst_0       
        //   254: iload           11
        //   256: invokevirtual   javax/microedition/rms/RecordStore.setRecord:(I[BII)V
        //   259: goto            190
        //   262: astore_3       
        //   263: goto            204
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                 
        //  -----  -----  -----  -----  -----------------------------------------------------
        //  15     19     205    229    Ljavax/microedition/rms/RecordStoreNotFoundException;
        //  15     19     262    266    Ljava/lang/Exception;
        //  26     29     262    266    Ljava/lang/Exception;
        //  30     34     262    266    Ljava/lang/Exception;
        //  34     37     262    266    Ljava/lang/Exception;
        //  41     45     262    266    Ljava/lang/Exception;
        //  45     49     262    266    Ljava/lang/Exception;
        //  53     58     262    266    Ljava/lang/Exception;
        //  58     62     262    266    Ljava/lang/Exception;
        //  66     71     262    266    Ljava/lang/Exception;
        //  71     75     262    266    Ljava/lang/Exception;
        //  79     84     262    266    Ljava/lang/Exception;
        //  84     88     262    266    Ljava/lang/Exception;
        //  92     97     262    266    Ljava/lang/Exception;
        //  97     101    262    266    Ljava/lang/Exception;
        //  108    112    262    266    Ljava/lang/Exception;
        //  116    121    262    266    Ljava/lang/Exception;
        //  121    125    262    266    Ljava/lang/Exception;
        //  129    134    262    266    Ljava/lang/Exception;
        //  134    138    262    266    Ljava/lang/Exception;
        //  145    149    262    266    Ljava/lang/Exception;
        //  153    158    262    266    Ljava/lang/Exception;
        //  163    167    262    266    Ljava/lang/Exception;
        //  174    178    262    266    Ljava/lang/Exception;
        //  184    190    262    266    Ljava/lang/Exception;
        //  190    195    262    266    Ljava/lang/Exception;
        //  195    199    262    266    Ljava/lang/Exception;
        //  199    204    262    266    Ljava/lang/Exception;
        //  214    219    262    266    Ljava/lang/Exception;
        //  232    236    262    266    Ljava/lang/Exception;
        //  241    245    262    266    Ljava/lang/Exception;
        //  254    259    262    266    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0121:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void ay() {
        try {
            final ByteArrayOutputStream a1191 = this.a1191;
            try {
                a1191.close();
                this.H1188 = this.a1191.toByteArray();
                this.a1191 = null;
                this.g1187 = null;
                this.I1189 = null;
            }
            catch (final Exception ex) {}
        }
        catch (final Exception ex2) {}
    }
    
    private int b() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        a.a1172:Ljava/lang/Object;
        //     4: astore_1       
        //     5: aload_1        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: getfield        a.bV:I
        //    11: istore_2       
        //    12: aload_1        
        //    13: monitorexit    
        //    14: iconst_2       
        //    15: istore_3       
        //    16: iload_2        
        //    17: iload_3        
        //    18: if_icmpne       31
        //    21: bipush          50
        //    23: i2l            
        //    24: lstore          4
        //    26: lload           4
        //    28: invokestatic    java/lang/Thread.sleep:(J)V
        //    31: iload_2        
        //    32: ireturn        
        //    33: astore          6
        //    35: aload_1        
        //    36: monitorexit    
        //    37: aload           6
        //    39: athrow         
        //    40: astore_1       
        //    41: goto            31
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  7      11     33     40     Any
        //  12     14     33     40     Any
        //  26     31     40     44     Ljava/lang/Exception;
        //  35     37     33     40     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0031:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private int b(final int n) {
        final int n2 = 2;
        int i = 0;
        final int[] array = this.c1107[n];
        int n3 = 0;
        while (i < array[3]) {
            n3 += this.a(array[n2], this.r1101, i);
            ++i;
        }
        return this.q1100[array[n2]] + n3 >> 1;
    }
    
    private int b(final int n, final int n2) {
        int n3;
        if (n2 == 0) {
            n3 = n % this.bG << 4;
        }
        else {
            n3 = n / this.bG << 4;
        }
        return n3;
    }
    
    private int b(final int n, final int n2, final int n3) {
        final int n4 = 3;
        final int n5 = 2;
        final int n6 = 1;
        int n7 = this.c(n, n2);
        this.bc = 0;
        boolean q1082;
        if (!this.q1082) {
            q1082 = (n6 != 0);
        }
        else {
            q1082 = false;
        }
        this.q1082 = q1082;
        while (this.bc < 4) {
            final int a = this.a((this.k1081[n7][0] << 4) + n, (this.k1081[n7][n6] << 4) + n2);
            if (this.b(a) && Math.abs(this.a(a) - n7) != n5 && Math.abs(this.a(a) - n3) != n5) {
                return n7;
            }
            if (this.q1082) {
                ++n7;
                if (n7 > n4) {
                    n7 = 0;
                }
            }
            else {
                --n7;
                if (n7 < 0) {
                    n7 = n4;
                }
            }
            ++this.bc;
        }
        n7 = this.c(n, n2);
        return n7;
    }
    
    private static int b(final int n, final int n2, final int n3, final int n4) {
        return (n3 - n) * (n3 - n) + (n4 - n2) * (n4 - n2);
    }
    
    private String b(final String s) {
        String string;
        if (this.D1176) {
            string = new StringBuffer().append("http://10.0.0.172:80").append(s.substring(s.indexOf(47, 7))).toString();
        }
        else {
            string = s;
        }
        return string;
    }
    
    private void b() {
        this.m = 0;
    }
    
    private void b(final int n) {
        do {
            --this.m;
        } while (this.b[this.m] != n);
        this.l = this.b[this.m];
    }
    
    private void b(final int n, final int n2) {
        final int n3 = 320;
        final int n4 = 240;
        this.a1002.setClip(0, 0, n4, n3);
        this.a1002.setColor(16777215);
        this.a1002.fillRect(0, 0, n4, n3);
        this.e(this.t, n4 - n);
        this.d(n2);
        for (int i = 0; i < 3; ++i) {
            this.d(this.w + i * 176, this.x - n);
        }
    }
    
    private final void b(final int n, final int n2, final int n3) {
        final int n4 = 7;
        final int n5 = 5;
        final int n6 = 3;
        final int a1016 = 1;
        final int n7 = 1000000;
        final int n8 = n3 + 3;
        if (n != 0) {
            int n9 = n7;
            int i = 0;
            while (!this.a1016) {
                if (n / n9 != 0) {
                    this.a1016 = (a1016 != 0);
                    i = n9;
                }
                n9 /= 10;
            }
            if (this.a1016) {
                this.a1016 = false;
                int n10 = n2;
                int n11 = n;
                while (i > 0) {
                    this.a1002.setClip(n10, n8, n5, n4);
                    this.a1002.drawImage(this.a1013[n6][13], n10 - n11 / i * 5, n8, 0);
                    n11 -= n11 / i * i;
                    i /= 10;
                    n10 = n10 + 5 - a1016;
                }
            }
        }
        else {
            this.a1002.setClip(n2, n8, n5, n4);
            this.a1002.drawImage(this.a1013[n6][13], n2, n8, 0);
        }
        this.a1002.setClip(0, 0, 240, 320);
    }
    
    private void b(final int n, final int n2, final int n3, final int n4) {
        final int n5 = 7;
        final int n6 = 1;
        final int n7 = 15;
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(3291732);
        this.a1002.fillRect(n2 - 8, n3 - 16, n7, 3);
        this.a1002.setColor(16777191);
        this.a1002.fillRect(n2 - n5, n3 - n7, 13, n6);
        this.a1002.setColor(49168);
        if ((n4 & 0x1) == 0x0) {
            this.a1002.fillRect(n2 - n5, n3 - n7, n * 13 / this.aW, n6);
        }
        else {
            this.a1002.fillRect(n2 - n5, n3 - n7, n * 13 / (this.aW * 10), n6);
        }
    }
    
    private void b(final int n, final int n2, final int n3, final int n4, final int n5) {
        final int n6 = 2;
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(13971834);
        this.a(new StringBuffer().append(this.b1015[this.y1130[this.X][this.c1107[n][n6]] + 28]).append("\uff1a").append(this.b1015[this.y1130[this.X][this.c1107[n][n6]] + 122]).toString(), 0, n2, n3, n4, n5);
    }
    
    private void b(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        final int n7 = 1;
        if (n < this.a1038) {
            final int[] array = this.a1039[n];
            int n10;
            int n11;
            if (n2 == n7) {
                final int width = this.a1040[n].getWidth();
                final int height = this.a1040[n].getHeight();
                int n8;
                if ((n3 & 0x1) != 0x0) {
                    n8 = n5 - width;
                }
                else if ((n3 & 0x4) != 0x0) {
                    n8 = n5 - (width >> 1);
                }
                else {
                    n8 = n5;
                }
                if ((n3 & 0x2) != 0x0) {
                    final int n9 = n6 - (height - n7);
                    n10 = n8;
                    n11 = n9;
                }
                else if ((n3 & 0x8) != 0x0) {
                    final int n12 = n6 - ((height >> 1) - n7);
                    n10 = n8;
                    n11 = n12;
                }
                else {
                    n10 = n8;
                    n11 = n6;
                }
            }
            else {
                n11 = n6;
                n10 = n5;
            }
            array[2] = n2;
            array[3] = n4;
            array[4] = n10;
            array[5] = n11;
        }
    }
    
    private void b(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        int n9;
        if (n7 > 5) {
            n9 = 5;
        }
        else {
            n9 = n7;
        }
        final byte b = this.K1145[n9 >> 1][0];
        final byte b2 = this.K1145[n9 >> 1][1];
        final int n10 = n + b - this.bP;
        final int n11 = n2 + b2 - this.bQ + 13;
        switch (n8) {
            case 0: {
                this.t(b + n, b2 + n2, n6);
                if (n6 > 2 && n6 < 6) {
                    this.a(this.a1013[29][22], n10 + 21, n11 + 15, (n6 & 0x1) << 4, 0, 16, 16, 0, 0);
                    break;
                }
                if (n6 < 6) {
                    break;
                }
                if (n6 == 6) {
                    this.a(this.a1013[29][29], n10 + 21, n11 - 15, 0, 18, 16, 31, 0, 0);
                }
                if (n6 >= 6 && n6 < 9) {
                    this.a(this.a1013[29][27], n10 + 21, n11 + 10, (n6 - 6) * 21, 0, 21, 17, 0, 0);
                }
                if (n6 > 6) {
                    this.a(this.a1013[29][28], n10 + 14, n11 - 30, (n6 - 7) * 29, 0, 29, 22, 0, 0);
                    break;
                }
                break;
            }
            case 1: {
                if (n6 < 3) {
                    this.a(this.a1013[29][29], n3 - this.bP, this.L1146[n6][0] + n4 - this.bQ + 13, 0, this.L1146[n6][1], this.L1146[n6][2], this.L1146[n6][3], 2, 0);
                    this.a(this.a1013[29][28], n3 - this.bP, this.L1146[0][0] + n4 - this.bQ + 13, n6 * 29, 0, 29, 22, 0, 0);
                    break;
                }
                this.b(this.a1013[29][30], n5, n3 + 10, n4 + 40, n6 - 3);
                break;
            }
        }
    }
    
    private void b(final int n, final int n2, final int n3, final int n4, final boolean b) {
        if (b) {
            this.a1002.setColor(5046188);
        }
        else {
            this.a1002.setColor(this.q1158[(int)this.a1019 & 0x3]);
        }
        for (int i = 0; i < n3; i += 2) {
            this.a1002.drawLine(n + i, n2, n + n3, n2 + n4 - i);
            this.a1002.drawLine(n, n2 + i, n + n3 - i, n2 + n4);
        }
        this.a1002.drawRect(n, n2, n3, n4);
    }
    
    private static void b(final String str) {
        try {
            final CMidlet a = CMidlet.a;
            try {
                try {
                    final StringBuffer append = new StringBuffer().append("http://").append(str);
                    try {
                        a.platformRequest(append.toString());
                    }
                    catch (final Exception ex) {}
                }
                catch (final Exception ex2) {}
            }
            catch (final Exception ex3) {}
        }
        catch (final Exception ex4) {}
    }
    
    private void b(final Image image, final int n, final int n2, final int n3) {
        final int width = image.getWidth();
        final int height = image.getHeight();
        int n4;
        if ((n3 & 0x4) != 0x0) {
            n4 = n - (width >> 1);
        }
        else {
            n4 = n;
        }
        int n5;
        if ((n3 & 0x8) != 0x0) {
            n5 = n2 - (height >> 1);
        }
        else {
            n5 = n2;
        }
        int n6;
        if ((n3 & 0x1) != 0x0) {
            n6 = n4 - width;
        }
        else {
            n6 = n4;
        }
        int n7;
        if ((n3 & 0x2) != 0x0) {
            n7 = n5 - height;
        }
        else {
            n7 = n5;
        }
        this.a1002.drawImage(image, n6, n7, 0);
        this.a1002.setClip(0, 0, 240, 320);
    }
    
    private void b(final Image image, final int n, final int n2, final int n3, final int n4) {
        for (int i = 0; i < this.H1140.length; ++i) {
            this.a(image, this.H1140[i][0] + n2 - this.bP, this.H1140[i][1] + n3 - this.bQ, (this.H1140[i][2] + n4) * 16, 0, 16, 16, 0, 0);
        }
        this.p(n2 - 10, n3 - 25, n4);
    }
    
    private void b(final Image image, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        final int n9 = 3;
        final int n10 = 3;
        int n11 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        Label_0093: {
            if (!this.m(n7, n8)) {
                switch (n) {
                    case 0:
                    case 2: {
                        n11 = 1;
                        final int n12 = 2;
                        n13 = 0;
                        n14 = n10;
                        n15 = n12;
                        break Label_0093;
                    }
                    case 1:
                    case 3: {
                        final int n16 = 1;
                        final int n17 = 2;
                        n13 = n16;
                        n14 = n17;
                        n15 = n9;
                        n11 = 0;
                        break Label_0093;
                    }
                }
            }
            n13 = 0;
            n14 = n10;
            n15 = n9;
            n11 = 0;
        }
        for (int i = n11; i < n15; ++i) {
            for (int j = n13; j < n14; ++j) {
                final int n18 = (i << 4) * this.m1084[n][0] + n2 + this.m1084[n][2] - this.bP;
                final int n19 = (j << 4) * this.m1084[n][1] + n3 + this.m1084[n][3] - this.bQ + 13;
                switch (n6) {
                    case 0: {
                        this.a(image, n18, n19, n4 * 16, 0, 16, 16, 0, 0);
                        break;
                    }
                    case 1: {
                        int n20 = 0;
                        switch (n) {
                            case 0:
                            case 2: {
                                n20 = j;
                                break;
                            }
                            case 1:
                            case 3: {
                                n20 = i;
                                break;
                            }
                        }
                        this.a(image, n18, n19, ((n20 + n5) % 3 + 2) * 16, 0, 16, 16, 0, 0);
                        break;
                    }
                    case 2: {
                        this.a(image, n18, n19, (1 - n4) * 16, 0, 16, 16, 0, 0);
                        break;
                    }
                }
            }
        }
    }
    
    private final boolean b() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_1       
        //     2: iconst_0       
        //     3: istore_2       
        //     4: aconst_null    
        //     5: astore_3       
        //     6: ldc_w           "sanGuoTdData"
        //     9: astore          4
        //    11: aconst_null    
        //    12: astore          5
        //    14: aload           4
        //    16: iconst_0       
        //    17: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //    20: astore_3       
        //    21: iconst_1       
        //    22: istore          6
        //    24: aload_3        
        //    25: iload           6
        //    27: invokevirtual   javax/microedition/rms/RecordStore.getRecord:(I)[B
        //    30: astore          4
        //    32: new             Ljava/io/ByteArrayInputStream;
        //    35: astore          5
        //    37: aload           5
        //    39: aload           4
        //    41: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //    44: new             Ljava/io/DataInputStream;
        //    47: astore          4
        //    49: aload           4
        //    51: aload           5
        //    53: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    56: iconst_0       
        //    57: istore          7
        //    59: aload_0        
        //    60: getfield        a.bG:I
        //    63: istore          8
        //    65: aload_0        
        //    66: getfield        a.bH:I
        //    69: istore          9
        //    71: iload           8
        //    73: iload           9
        //    75: imul           
        //    76: istore          8
        //    78: iload           7
        //    80: iload           8
        //    82: if_icmpge       114
        //    85: aload_0        
        //    86: getfield        a.E1163:[B
        //    89: astore          10
        //    91: aload           4
        //    93: invokevirtual   java/io/DataInputStream.readByte:()B
        //    96: istore          9
        //    98: aload           10
        //   100: iload           7
        //   102: iload           9
        //   104: bastore        
        //   105: iload           7
        //   107: iconst_1       
        //   108: iadd           
        //   109: istore          7
        //   111: goto            59
        //   114: iconst_0       
        //   115: istore          7
        //   117: aload_0        
        //   118: getfield        a.bG:I
        //   121: istore          8
        //   123: aload_0        
        //   124: getfield        a.bH:I
        //   127: istore          9
        //   129: iload           8
        //   131: iload           9
        //   133: imul           
        //   134: istore          8
        //   136: iload           7
        //   138: iload           8
        //   140: if_icmpge       172
        //   143: aload_0        
        //   144: getfield        a.D1162:[B
        //   147: astore          10
        //   149: aload           4
        //   151: invokevirtual   java/io/DataInputStream.readByte:()B
        //   154: istore          9
        //   156: aload           10
        //   158: iload           7
        //   160: iload           9
        //   162: bastore        
        //   163: iload           7
        //   165: iconst_1       
        //   166: iadd           
        //   167: istore          7
        //   169: goto            117
        //   172: aload           4
        //   174: invokevirtual   java/io/DataInputStream.close:()V
        //   177: aload           5
        //   179: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //   182: aload_3        
        //   183: invokevirtual   javax/microedition/rms/RecordStore.closeRecordStore:()V
        //   186: iload_1        
        //   187: istore_2       
        //   188: iload_2        
        //   189: ireturn        
        //   190: astore          4
        //   192: aload_3        
        //   193: ifnull          200
        //   196: aload_3        
        //   197: invokevirtual   javax/microedition/rms/RecordStore.closeRecordStore:()V
        //   200: iconst_0       
        //   201: istore_2       
        //   202: aconst_null    
        //   203: astore_3       
        //   204: goto            188
        //   207: astore_3       
        //   208: goto            200
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  16     20     190    211    Ljava/lang/Exception;
        //  25     30     190    211    Ljava/lang/Exception;
        //  32     35     190    211    Ljava/lang/Exception;
        //  39     44     190    211    Ljava/lang/Exception;
        //  44     47     190    211    Ljava/lang/Exception;
        //  51     56     190    211    Ljava/lang/Exception;
        //  59     63     190    211    Ljava/lang/Exception;
        //  65     69     190    211    Ljava/lang/Exception;
        //  85     89     190    211    Ljava/lang/Exception;
        //  91     96     190    211    Ljava/lang/Exception;
        //  102    105    190    211    Ljava/lang/Exception;
        //  117    121    190    211    Ljava/lang/Exception;
        //  123    127    190    211    Ljava/lang/Exception;
        //  143    147    190    211    Ljava/lang/Exception;
        //  149    154    190    211    Ljava/lang/Exception;
        //  160    163    190    211    Ljava/lang/Exception;
        //  172    177    190    211    Ljava/lang/Exception;
        //  177    182    190    211    Ljava/lang/Exception;
        //  182    186    190    211    Ljava/lang/Exception;
        //  196    200    207    211    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 112 out of bounds for length 112
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:359)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:427)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3362)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3611)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:112)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private boolean b(final int n) {
        boolean b;
        if (this.c(n) && this.E1163[n] < 8 && this.D1162[n] < 6) {
            b = true;
        }
        else {
            this.m(n);
            b = false;
        }
        return b;
    }
    
    private boolean b(final int n, final int n2) {
        final int a = this.a(n, n2);
        boolean b;
        if (this.c(a) && this.E1163[a] < 8 && this.D1162[a] < 6) {
            b = true;
        }
        else {
            this.m(a);
            b = false;
        }
        return b;
    }
    
    private int c() {
        int d;
        while (true) {
            d = this.d();
            if (d != 1) {
                break;
            }
            Thread.yield();
        }
        this.g1187 = null;
        return d;
    }
    
    private static int c(final int n) {
        final int n2 = 225;
        final int n3 = 135;
        int n4;
        if (n >= 45 && n < n3) {
            n4 = 2;
        }
        else if (n >= n3 && n < n2) {
            n4 = 3;
        }
        else if (n >= n2 && n < 315) {
            n4 = 0;
        }
        else {
            n4 = 1;
        }
        return n4;
    }
    
    private int c(final int n, final int n2) {
        final int n3 = 8;
        int n4;
        if (n > this.bI) {
            n4 = this.bI - n3;
        }
        else {
            n4 = n;
        }
        int n5;
        if (n2 > this.bJ) {
            n5 = this.bJ - n3;
        }
        else {
            n5 = n2;
        }
        return this.E1163[this.a(n4, n5)] >> 1;
    }
    
    private int c(final int n, final int n2, final int n3) {
        final int n4 = 4;
        int n5;
        if (n3 == n4) {
            n5 = 0;
        }
        else {
            n5 = n3;
        }
        final int n6 = n2 + 1;
        int n7;
        if (n6 > this.w1123[n5].length - 3) {
            if (n3 == 0 || n3 == n4) {
                this.c1107[n][5] = (this.a() & 0x3);
            }
            n7 = 0;
        }
        else {
            n7 = n6;
        }
        return n7;
    }
    
    private void c() {
        this.aP = 0;
        this.bt = 0;
    }
    
    private void c(final int n) {
        if (this.a1013[n] == null) {
            try {
                final Image[][] a1013 = this.a1013;
                try {
                    final int n2 = this.f[n];
                    try {
                        a1013[n] = new Image[n2];
                        this.getClass();
                        final String s = this.a1014[n];
                        try {
                            final InputStream resourceAsStream = Display.getResourceAsStream(s);
                            byte[] b = null;
                            for (int i = 0; i < this.f[n]; ++i) {
                                final short a1014 = a(resourceAsStream);
                                if (b == null || b.length < a1014) {
                                    b = new byte[a1014];
                                }
                                resourceAsStream.read(b, 0, a1014);
                                this.a1013[n][i] = Image.createImage(b, 0, (int)a1014);
                            }
                            resourceAsStream.close();
                        }
                        catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    catch (final Exception ex2) {}
                }
                catch (final Exception ex3) {}
            }
            catch (final Exception ex4) {}
        }
    }
    
    private void c(final int n, final int n2) {
        this.a1002.setColor(6396370);
        this.a1002.fillRect(0, 309, 240, 2);
        this.a(this.a1013[3][4], 18, 311, 6396370, true);
        if (n != -1) {
            this.a(this.a1013[3][2], 1, 310, 0, n * 10, 18, 10, 0, 0);
        }
        if (n2 != -1) {
            this.a(this.a1013[3][2], 221, 310, 0, n2 * 10, 18, 10, 0, 0);
        }
        switch (this.l) {
            case 4:
            case 5:
            case 20:
            case 21: {
                this.f();
                break;
            }
        }
    }
    
    private void c(final int n, final int n2, final int n3) {
        final int n4 = 25;
        final int n5 = 4;
        this.a(this.a1013[n5][n4], n2, n3, 0, n * (this.a1013[n5][n4].getHeight() / 10), this.a1013[n5][n4].getWidth(), this.a1013[n5][n4].getHeight() / 10, 0, 0);
    }
    
    private void c(final int n, final int n2, final int n3, final int n4) {
        final int n5 = 3;
        final int n6 = 2;
        final int n7 = 1;
        if (this.j((int)this.q1100[n3])) {
            final int[] array = this.c1107[this.bt];
            array[0] = n;
            array[n7] = n2;
            array[n6] = n3;
            array[5] = n4;
            array[6] = (array[n5] = 0);
            array[4] = n5;
            array[8] = (array[7] = 0);
            array[14] = -1;
            array[13] = (array[15] = 0);
            array[9] = n4;
            array[17] = (array[16] = 0);
            this.c(n, n2, this.bt, n3, (boolean)(n7 != 0));
            ++this.bt;
            this.bF = 0;
            this.aw = 0;
            this.b(n6);
        }
    }
    
    private void c(final int n, final int n2, final int n3, final int n4, final int n5) {
        this.a1002.setColor(15455661);
        switch (n5) {
            case 0: {
                this.a1002.setColor(16580557);
                this.a1002.fillRect(n, n2, n3 - 1, n4);
                final int height = this.a1013[3][8].getHeight();
                for (int i = 0; i < n3; i += 50) {
                    this.a1002.setClip(n, n2, n3, n4);
                    this.a1002.drawImage(this.a1013[3][8], n + i, n2, 0);
                    this.a1002.drawImage(this.a1013[3][8], n + i, n2 + n4 - height - 1, 0);
                }
                this.a(this.a1013[3][9], n + 1, n2 + height, n3 - 2, n4 - (height << 1));
                break;
            }
            case 1: {
                for (int j = 0; j < 3; ++j) {
                    this.a1002.drawRect(n + j, n2 + j, n3 - (j << 1) - 1, n4 - (j << 1) + 1);
                }
                this.a(this.a1013[3][9], n + 3, n2 + 3, n3 - 6, n4 - 4);
                break;
            }
            case 2: {
                this.a1002.setColor(16580557);
                this.a1002.fillRect(n, n2, n3, n4);
                this.a1002.drawImage(this.a1013[4][9], n + n3 - this.a1013[4][9].getWidth(), n2, 0);
                break;
            }
            case 3: {
                this.a1002.setColor(16580557);
                this.a1002.fillRect(n, n2, n3, n4);
                this.a(this.a1013[4][9], n, n2, 1);
                break;
            }
        }
    }
    
    private void c(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        if (n4 == 1) {
            for (int i = 0; i < 3; ++i) {
                this.a(this.a1013[29][43], this.t1118[n][0] + n2 + this.s1117[n][0] * i * 16 - this.bP, this.t1118[n][1] + n3 + this.s1117[n][1] * i * 16 - this.bQ + 13, 0, 0, 15, 20, 0, 0);
            }
        }
        if (n6 == 1 && n5 < 3) {
            for (int j = 0; j < 3; ++j) {
                this.a(this.a1013[29][43], this.t1118[n][0] + n2 + this.s1117[n][0] * j * 16 - this.bP, this.t1118[n][1] + n3 - 22 + this.s1117[n][1] * j * 16 - this.bQ + 13, 0, 20, 15, 42, 0, 0);
            }
        }
        if (n5 > 1 && n5 < 5 && n6 == 1) {
            final int n7 = n5 - 2;
            switch (n) {
                case 0: {
                    for (int k = 0; k < 3; ++k) {
                        this.a(this.a1013[29][44], k * 16 + n2 - this.bP, n3 - 37 - this.bQ + 13, 0, this.h1121[n][n7][0], 16, this.h1121[n][n7][1], 0, 0);
                    }
                    break;
                }
                case 1: {
                    for (int l = 0; l < 3; ++l) {
                        this.a(this.a1013[29][45], this.u1119[n7][0] + n2 - this.bP, this.u1119[n7][1] + n3 + l * 16 - this.bQ + 13, this.h1121[n][n7][0], 0, this.h1121[n][n7][1], 18, 1, 0);
                    }
                    break;
                }
                case 2: {
                    for (int n8 = 0; n8 < 3; ++n8) {
                        this.a(this.a1013[29][46], n8 * 16 + n2 - this.bP, n3 + 30 - this.bQ + 13, 0, this.h1121[n][n7][0], 15, this.h1121[n][n7][1], 0, 0);
                    }
                    break;
                }
                case 3: {
                    for (int n9 = 0; n9 < 3; ++n9) {
                        this.a(this.a1013[29][45], this.v1120[n7][0] + n2 - this.bP, this.v1120[n7][1] + n3 + n9 * 16 - this.bQ + 13, this.h1121[n][n7][0], 0, this.h1121[n][n7][1], 18, 0, 0);
                    }
                    break;
                }
            }
        }
    }
    
    private final void c(final int n, final int n2, final int n3, final int n4, final boolean b) {
        if (b) {
            for (int i = 0; i < this.o1098[n4]; ++i) {
                for (int j = 0; j < this.o1098[n4]; ++j) {
                    if (n3 < 110) {
                        this.E1163[this.a((i << 4) + n, (j << 4) + n2)] = (byte)(n3 + 12);
                    }
                    else {
                        this.E1163[this.a((i << 4) + n, (j << 4) + n2)] = (byte)(98 - n3);
                    }
                }
            }
        }
        else {
            for (int k = 0; k < this.o1098[n4]; ++k) {
                for (int l = 0; l < this.o1098[n4]; ++l) {
                    this.E1163[this.a((k << 4) + n, (l << 4) + n2)] = 8;
                }
            }
        }
    }
    
    private void c(final String s) {
        int i = 0;
        if (s == null) {
            this.H(0);
        }
        else {
            final int length = s.length();
            this.H(length);
            while (i < length) {
                this.I(s.charAt(i));
                ++i;
            }
        }
    }
    
    private void c(final Image image, final int n, final int n2, final int n3) {
        final int n4 = 11;
        this.a(image, n, n2, n3 * 11, 0, n4, n4, 0, 0);
    }
    
    private final boolean c() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_1       
        //     2: iconst_0       
        //     3: istore_2       
        //     4: aconst_null    
        //     5: astore_3       
        //     6: ldc_w           "freeGame"
        //     9: astore          4
        //    11: aconst_null    
        //    12: astore          5
        //    14: aload           4
        //    16: iconst_0       
        //    17: invokestatic    javax/microedition/rms/RecordStore.openRecordStore:(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
        //    20: astore_3       
        //    21: iconst_1       
        //    22: istore          6
        //    24: aload_3        
        //    25: iload           6
        //    27: invokevirtual   javax/microedition/rms/RecordStore.getRecord:(I)[B
        //    30: astore          4
        //    32: new             Ljava/io/ByteArrayInputStream;
        //    35: astore          5
        //    37: aload           5
        //    39: aload           4
        //    41: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //    44: new             Ljava/io/DataInputStream;
        //    47: astore          4
        //    49: aload           4
        //    51: aload           5
        //    53: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    56: iconst_0       
        //    57: istore          7
        //    59: bipush          9
        //    61: istore          8
        //    63: iload           7
        //    65: iload           8
        //    67: if_icmpge       99
        //    70: aload_0        
        //    71: getfield        a.d1073:[Z
        //    74: astore          9
        //    76: aload           4
        //    78: invokevirtual   java/io/DataInputStream.readBoolean:()Z
        //    81: istore          10
        //    83: aload           9
        //    85: iload           7
        //    87: iload           10
        //    89: bastore        
        //    90: iload           7
        //    92: iconst_1       
        //    93: iadd           
        //    94: istore          7
        //    96: goto            59
        //    99: aload           4
        //   101: invokevirtual   java/io/DataInputStream.close:()V
        //   104: aload           5
        //   106: invokevirtual   java/io/ByteArrayInputStream.close:()V
        //   109: aload_3        
        //   110: invokevirtual   javax/microedition/rms/RecordStore.closeRecordStore:()V
        //   113: iload_1        
        //   114: istore_2       
        //   115: iload_2        
        //   116: ireturn        
        //   117: astore          4
        //   119: aload_3        
        //   120: ifnull          127
        //   123: aload_3        
        //   124: invokevirtual   javax/microedition/rms/RecordStore.closeRecordStore:()V
        //   127: iconst_0       
        //   128: istore_2       
        //   129: aconst_null    
        //   130: astore_3       
        //   131: goto            115
        //   134: astore_3       
        //   135: goto            127
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  16     20     117    138    Ljava/lang/Exception;
        //  25     30     117    138    Ljava/lang/Exception;
        //  32     35     117    138    Ljava/lang/Exception;
        //  39     44     117    138    Ljava/lang/Exception;
        //  44     47     117    138    Ljava/lang/Exception;
        //  51     56     117    138    Ljava/lang/Exception;
        //  70     74     117    138    Ljava/lang/Exception;
        //  76     81     117    138    Ljava/lang/Exception;
        //  87     90     117    138    Ljava/lang/Exception;
        //  99     104    117    138    Ljava/lang/Exception;
        //  104    109    117    138    Ljava/lang/Exception;
        //  109    113    117    138    Ljava/lang/Exception;
        //  123    127    134    138    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 74 out of bounds for length 74
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:359)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:427)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3362)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3611)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:112)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private boolean c(final int n) {
        return (this.E1163[n] & 0x1) == 0x0;
    }
    
    private boolean c(final int n, final int n2) {
        return this.E1163[this.a(n, n2)] == 11;
    }
    
    private int d() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        a.g1187:Ljava/lang/String;
        //     4: astore_1       
        //     5: aload_1        
        //     6: ifnonnull       135
        //     9: aload_0        
        //    10: getfield        a.f1186:Ljava/lang/String;
        //    13: astore_1       
        //    14: aload_0        
        //    15: aload_1        
        //    16: invokespecial   a.b:(Ljava/lang/String;)Ljava/lang/String;
        //    19: astore_2       
        //    20: aload_1        
        //    21: invokestatic    a.a:(Ljava/lang/String;)Ljava/lang/String;
        //    24: astore_3       
        //    25: aload_2        
        //    26: invokestatic    javax/microedition/io/Connector.open:(Ljava/lang/String;)Ljavax/microedition/io/Connection;
        //    29: astore_1       
        //    30: aload_1        
        //    31: checkcast       Ljavax/microedition/io/HttpConnection;
        //    34: astore_1       
        //    35: aload_0        
        //    36: aload_1        
        //    37: putfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //    40: aload_0        
        //    41: getfield        a.c1190:B
        //    44: istore          4
        //    46: iload           4
        //    48: tableswitch {
        //                2: 143
        //                3: 255
        //          default: 72
        //        }
        //    72: new             Ljava/io/IOException;
        //    75: astore_1       
        //    76: aload_1        
        //    77: invokespecial   java/io/IOException.<init>:()V
        //    80: aload_1        
        //    81: athrow         
        //    82: astore_1       
        //    83: iconst_0       
        //    84: istore          4
        //    86: aconst_null    
        //    87: astore_1       
        //    88: iconst_0       
        //    89: istore          5
        //    91: aconst_null    
        //    92: astore_2       
        //    93: aload_2        
        //    94: ifnull          101
        //    97: aload_2        
        //    98: invokevirtual   java/io/OutputStream.close:()V
        //   101: aload_1        
        //   102: ifnull          109
        //   105: aload_1        
        //   106: invokevirtual   java/io/InputStream.close:()V
        //   109: aload_0        
        //   110: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   113: astore_1       
        //   114: aload_1        
        //   115: ifnull          129
        //   118: aload_0        
        //   119: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   122: astore_1       
        //   123: aload_1        
        //   124: invokeinterface javax/microedition/io/Connection.close:()V
        //   129: iconst_m1      
        //   130: istore          4
        //   132: iload           4
        //   134: ireturn        
        //   135: aload_0        
        //   136: getfield        a.g1187:Ljava/lang/String;
        //   139: astore_1       
        //   140: goto            14
        //   143: aload_0        
        //   144: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   147: astore_1       
        //   148: ldc_w           "GET"
        //   151: astore_2       
        //   152: aload_1        
        //   153: aload_2        
        //   154: invokeinterface javax/microedition/io/HttpConnection.setRequestMethod:(Ljava/lang/String;)V
        //   159: aload_0        
        //   160: getfield        a.D1176:Z
        //   163: istore          4
        //   165: iload           4
        //   167: ifeq            187
        //   170: aload_0        
        //   171: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   174: astore_1       
        //   175: ldc_w           "X-Online-Host"
        //   178: astore_2       
        //   179: aload_1        
        //   180: aload_2        
        //   181: aload_3        
        //   182: invokeinterface javax/microedition/io/HttpConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   187: aload_0        
        //   188: getfield        a.H1188:[B
        //   191: astore_1       
        //   192: aload_1        
        //   193: ifnull          1029
        //   196: aload_0        
        //   197: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   200: astore_1       
        //   201: aload_1        
        //   202: invokeinterface javax/microedition/io/OutputConnection.openOutputStream:()Ljava/io/OutputStream;
        //   207: astore_1       
        //   208: iconst_0       
        //   209: istore          5
        //   211: aconst_null    
        //   212: astore_2       
        //   213: aload_0        
        //   214: getfield        a.H1188:[B
        //   217: astore_3       
        //   218: aload_3        
        //   219: arraylength    
        //   220: istore          6
        //   222: iload           5
        //   224: iload           6
        //   226: if_icmpge       323
        //   229: aload_0        
        //   230: getfield        a.H1188:[B
        //   233: astore_3       
        //   234: aload_3        
        //   235: iload           5
        //   237: baload         
        //   238: istore          6
        //   240: aload_1        
        //   241: iload           6
        //   243: invokevirtual   java/io/OutputStream.write:(I)V
        //   246: iload           5
        //   248: iconst_1       
        //   249: iadd           
        //   250: istore          5
        //   252: goto            213
        //   255: aload_0        
        //   256: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   259: astore_1       
        //   260: ldc_w           "POST"
        //   263: astore_2       
        //   264: aload_1        
        //   265: aload_2        
        //   266: invokeinterface javax/microedition/io/HttpConnection.setRequestMethod:(Ljava/lang/String;)V
        //   271: goto            159
        //   274: astore_1       
        //   275: iconst_0       
        //   276: istore          5
        //   278: aconst_null    
        //   279: astore_2       
        //   280: iconst_0       
        //   281: istore          6
        //   283: aconst_null    
        //   284: astore_3       
        //   285: aload_3        
        //   286: ifnull          293
        //   289: aload_3        
        //   290: invokevirtual   java/io/OutputStream.close:()V
        //   293: aload_2        
        //   294: ifnull          301
        //   297: aload_2        
        //   298: invokevirtual   java/io/InputStream.close:()V
        //   301: aload_0        
        //   302: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   305: astore_2       
        //   306: aload_2        
        //   307: ifnull          321
        //   310: aload_0        
        //   311: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   314: astore_2       
        //   315: aload_2        
        //   316: invokeinterface javax/microedition/io/Connection.close:()V
        //   321: aload_1        
        //   322: athrow         
        //   323: aload_1        
        //   324: invokevirtual   java/io/OutputStream.close:()V
        //   327: iconst_0       
        //   328: istore          4
        //   330: aconst_null    
        //   331: astore_1       
        //   332: aload_0        
        //   333: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   336: astore_2       
        //   337: aload_2        
        //   338: invokeinterface javax/microedition/io/HttpConnection.getResponseCode:()I
        //   343: istore          5
        //   345: aload_0        
        //   346: iload           5
        //   348: putfield        a.ca:I
        //   351: aload_0        
        //   352: getfield        a.ca:I
        //   355: istore          5
        //   357: sipush          300
        //   360: istore          6
        //   362: iload           5
        //   364: iload           6
        //   366: if_icmplt       435
        //   369: aload_0        
        //   370: getfield        a.ca:I
        //   373: istore          5
        //   375: sipush          400
        //   378: istore          6
        //   380: iload           5
        //   382: iload           6
        //   384: if_icmpge       435
        //   387: aload_0        
        //   388: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   391: astore_2       
        //   392: ldc_w           "Location"
        //   395: astore_3       
        //   396: aload_2        
        //   397: aload_3        
        //   398: invokeinterface javax/microedition/io/HttpConnection.getHeaderField:(Ljava/lang/String;)Ljava/lang/String;
        //   403: astore_2       
        //   404: aload_0        
        //   405: aload_2        
        //   406: putfield        a.g1187:Ljava/lang/String;
        //   409: aload_0        
        //   410: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   413: astore_1       
        //   414: aload_1        
        //   415: ifnull          429
        //   418: aload_0        
        //   419: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   422: astore_1       
        //   423: aload_1        
        //   424: invokeinterface javax/microedition/io/Connection.close:()V
        //   429: iconst_1       
        //   430: istore          4
        //   432: goto            132
        //   435: iconst_0       
        //   436: istore          5
        //   438: aconst_null    
        //   439: astore_2       
        //   440: aload_0        
        //   441: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   444: astore_3       
        //   445: aload_3        
        //   446: iload           5
        //   448: invokeinterface javax/microedition/io/HttpConnection.getHeaderFieldKey:(I)Ljava/lang/String;
        //   453: astore_3       
        //   454: aload_3        
        //   455: ifnonnull       529
        //   458: aload_0        
        //   459: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   462: astore_2       
        //   463: aload_2        
        //   464: invokeinterface javax/microedition/io/InputConnection.openInputStream:()Ljava/io/InputStream;
        //   469: astore_2       
        //   470: aload_0        
        //   471: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   474: astore_3       
        //   475: aload_3        
        //   476: invokeinterface javax/microedition/io/ContentConnection.getLength:()J
        //   481: lstore          7
        //   483: lload           7
        //   485: l2i            
        //   486: istore          6
        //   488: iload           6
        //   490: ifle            735
        //   493: iload           6
        //   495: iconst_1       
        //   496: iand           
        //   497: istore          9
        //   499: iload           9
        //   501: ifeq            552
        //   504: new             Ljava/io/IOException;
        //   507: astore_3       
        //   508: aload_3        
        //   509: invokespecial   java/io/IOException.<init>:()V
        //   512: aload_3        
        //   513: athrow         
        //   514: astore_3       
        //   515: aload_2        
        //   516: astore          10
        //   518: iconst_0       
        //   519: istore          5
        //   521: aconst_null    
        //   522: astore_2       
        //   523: aload           10
        //   525: astore_1       
        //   526: goto            93
        //   529: aload_0        
        //   530: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   533: astore_3       
        //   534: aload_3        
        //   535: iload           5
        //   537: invokeinterface javax/microedition/io/HttpConnection.getHeaderField:(I)Ljava/lang/String;
        //   542: pop            
        //   543: iload           5
        //   545: iconst_1       
        //   546: iadd           
        //   547: istore          5
        //   549: goto            440
        //   552: iconst_0       
        //   553: istore          9
        //   555: aconst_null    
        //   556: astore          11
        //   558: aload_0        
        //   559: aconst_null    
        //   560: putfield        a.I1189:[B
        //   563: iload           6
        //   565: newarray        B
        //   567: astore          11
        //   569: aload_0        
        //   570: aload           11
        //   572: putfield        a.I1189:[B
        //   575: iconst_0       
        //   576: istore          9
        //   578: aconst_null    
        //   579: astore          11
        //   581: iload           9
        //   583: iload           6
        //   585: if_icmpge       618
        //   588: aload_0        
        //   589: getfield        a.I1189:[B
        //   592: astore          12
        //   594: iload           6
        //   596: iload           9
        //   598: isub           
        //   599: istore          13
        //   601: aload_2        
        //   602: aload           12
        //   604: iload           9
        //   606: iload           13
        //   608: invokevirtual   java/io/InputStream.read:([BII)I
        //   611: istore          14
        //   613: iload           14
        //   615: ifge            725
        //   618: aload_2        
        //   619: invokevirtual   java/io/InputStream.close:()V
        //   622: iconst_0       
        //   623: istore          5
        //   625: aconst_null    
        //   626: astore_2       
        //   627: aload_0        
        //   628: getfield        a.I1189:[B
        //   631: astore_3       
        //   632: aload_3        
        //   633: arraylength    
        //   634: istore          6
        //   636: iload           5
        //   638: iload           6
        //   640: if_icmpge       834
        //   643: aload_0        
        //   644: getfield        a.I1189:[B
        //   647: astore_3       
        //   648: iload           5
        //   650: iconst_1       
        //   651: ishr           
        //   652: istore          9
        //   654: aload_0        
        //   655: getfield        a.I1189:[B
        //   658: astore          12
        //   660: aload           12
        //   662: iload           5
        //   664: baload         
        //   665: istore          14
        //   667: iload           14
        //   669: invokestatic    a.e:(I)I
        //   672: iconst_4       
        //   673: ishl           
        //   674: istore          14
        //   676: aload_0        
        //   677: getfield        a.I1189:[B
        //   680: astore          15
        //   682: iload           5
        //   684: iconst_1       
        //   685: iadd           
        //   686: istore          16
        //   688: aload           15
        //   690: iload           16
        //   692: baload         
        //   693: istore          13
        //   695: iload           13
        //   697: invokestatic    a.e:(I)I
        //   700: istore          13
        //   702: iload           14
        //   704: iload           13
        //   706: ior            
        //   707: i2b            
        //   708: istore          14
        //   710: aload_3        
        //   711: iload           9
        //   713: iload           14
        //   715: bastore        
        //   716: iload           5
        //   718: iconst_2       
        //   719: iadd           
        //   720: istore          5
        //   722: goto            627
        //   725: iload           9
        //   727: iload           14
        //   729: iadd           
        //   730: istore          9
        //   732: goto            581
        //   735: new             Ljava/io/ByteArrayOutputStream;
        //   738: astore_3       
        //   739: sipush          2048
        //   742: istore          9
        //   744: aload_3        
        //   745: iload           9
        //   747: invokespecial   java/io/ByteArrayOutputStream.<init>:(I)V
        //   750: bipush          64
        //   752: istore          9
        //   754: iload           9
        //   756: newarray        B
        //   758: astore          11
        //   760: iconst_0       
        //   761: istore          14
        //   763: aconst_null    
        //   764: astore          12
        //   766: bipush          64
        //   768: istore          13
        //   770: aload_2        
        //   771: aload           11
        //   773: iconst_0       
        //   774: iload           13
        //   776: invokevirtual   java/io/InputStream.read:([BII)I
        //   779: istore          14
        //   781: iload           14
        //   783: ifge            816
        //   786: aload_3        
        //   787: invokevirtual   java/io/ByteArrayOutputStream.close:()V
        //   790: aload_3        
        //   791: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   794: astore_3       
        //   795: aload_0        
        //   796: aload_3        
        //   797: putfield        a.I1189:[B
        //   800: goto            618
        //   803: astore          10
        //   805: iconst_0       
        //   806: istore          6
        //   808: aconst_null    
        //   809: astore_3       
        //   810: aload           10
        //   812: astore_1       
        //   813: goto            285
        //   816: iconst_0       
        //   817: istore          13
        //   819: aconst_null    
        //   820: astore          15
        //   822: aload_3        
        //   823: aload           11
        //   825: iconst_0       
        //   826: iload           14
        //   828: invokevirtual   java/io/ByteArrayOutputStream.write:([BII)V
        //   831: goto            760
        //   834: aload_0        
        //   835: getfield        a.I1189:[B
        //   838: astore_2       
        //   839: aload_2        
        //   840: arraylength    
        //   841: iconst_1       
        //   842: ishr           
        //   843: istore          5
        //   845: iload           5
        //   847: newarray        B
        //   849: astore_2       
        //   850: aload_0        
        //   851: getfield        a.I1189:[B
        //   854: astore_3       
        //   855: iconst_0       
        //   856: istore          9
        //   858: aconst_null    
        //   859: astore          11
        //   861: iconst_0       
        //   862: istore          14
        //   864: aconst_null    
        //   865: astore          12
        //   867: aload_0        
        //   868: getfield        a.I1189:[B
        //   871: astore          15
        //   873: aload           15
        //   875: arraylength    
        //   876: iconst_1       
        //   877: ishr           
        //   878: istore          13
        //   880: aload_3        
        //   881: iconst_0       
        //   882: aload_2        
        //   883: iconst_0       
        //   884: iload           13
        //   886: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   889: aload_0        
        //   890: aload_2        
        //   891: putfield        a.I1189:[B
        //   894: aload_0        
        //   895: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   898: astore_2       
        //   899: aload_2        
        //   900: invokeinterface javax/microedition/io/Connection.close:()V
        //   905: iconst_0       
        //   906: istore          5
        //   908: aconst_null    
        //   909: astore_2       
        //   910: aload_0        
        //   911: aconst_null    
        //   912: putfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   915: aload_0        
        //   916: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   919: astore_1       
        //   920: aload_1        
        //   921: ifnull          935
        //   924: aload_0        
        //   925: getfield        a.a1193:Ljavax/microedition/io/HttpConnection;
        //   928: astore_1       
        //   929: aload_1        
        //   930: invokeinterface javax/microedition/io/Connection.close:()V
        //   935: iconst_0       
        //   936: istore          4
        //   938: aconst_null    
        //   939: astore_1       
        //   940: goto            132
        //   943: astore_2       
        //   944: goto            101
        //   947: astore_1       
        //   948: goto            109
        //   951: astore_3       
        //   952: goto            293
        //   955: astore_2       
        //   956: goto            301
        //   959: astore_2       
        //   960: goto            321
        //   963: astore_2       
        //   964: aload_1        
        //   965: astore_3       
        //   966: aload_2        
        //   967: astore_1       
        //   968: iconst_0       
        //   969: istore          5
        //   971: aconst_null    
        //   972: astore_2       
        //   973: goto            285
        //   976: astore_2       
        //   977: iconst_0       
        //   978: istore          6
        //   980: aconst_null    
        //   981: astore_3       
        //   982: aload_2        
        //   983: astore_1       
        //   984: iconst_0       
        //   985: istore          5
        //   987: aconst_null    
        //   988: astore_2       
        //   989: goto            285
        //   992: astore_1       
        //   993: goto            129
        //   996: astore_2       
        //   997: aload_1        
        //   998: astore_2       
        //   999: iconst_0       
        //  1000: istore          4
        //  1002: aconst_null    
        //  1003: astore_1       
        //  1004: goto            93
        //  1007: astore_2       
        //  1008: iconst_0       
        //  1009: istore          5
        //  1011: aconst_null    
        //  1012: astore_2       
        //  1013: iconst_0       
        //  1014: istore          4
        //  1016: aconst_null    
        //  1017: astore_1       
        //  1018: goto            93
        //  1021: astore_1       
        //  1022: goto            935
        //  1025: astore_1       
        //  1026: goto            429
        //  1029: iconst_0       
        //  1030: istore          4
        //  1032: aconst_null    
        //  1033: astore_1       
        //  1034: goto            332
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      4      82     93     Ljava/lang/Exception;
        //  0      4      274    285    Any
        //  9      13     82     93     Ljava/lang/Exception;
        //  9      13     274    285    Any
        //  15     19     82     93     Ljava/lang/Exception;
        //  15     19     274    285    Any
        //  20     24     82     93     Ljava/lang/Exception;
        //  20     24     274    285    Any
        //  25     29     82     93     Ljava/lang/Exception;
        //  25     29     274    285    Any
        //  30     34     82     93     Ljava/lang/Exception;
        //  30     34     274    285    Any
        //  36     40     82     93     Ljava/lang/Exception;
        //  36     40     274    285    Any
        //  40     44     82     93     Ljava/lang/Exception;
        //  40     44     274    285    Any
        //  72     75     82     93     Ljava/lang/Exception;
        //  72     75     274    285    Any
        //  76     80     82     93     Ljava/lang/Exception;
        //  76     80     274    285    Any
        //  80     82     82     93     Ljava/lang/Exception;
        //  80     82     274    285    Any
        //  97     101    943    947    Ljava/io/IOException;
        //  105    109    947    951    Ljava/io/IOException;
        //  118    122    992    996    Ljava/io/IOException;
        //  123    129    992    996    Ljava/io/IOException;
        //  135    139    82     93     Ljava/lang/Exception;
        //  135    139    274    285    Any
        //  143    147    82     93     Ljava/lang/Exception;
        //  143    147    274    285    Any
        //  153    159    82     93     Ljava/lang/Exception;
        //  153    159    274    285    Any
        //  159    163    82     93     Ljava/lang/Exception;
        //  159    163    274    285    Any
        //  170    174    82     93     Ljava/lang/Exception;
        //  170    174    274    285    Any
        //  181    187    82     93     Ljava/lang/Exception;
        //  181    187    274    285    Any
        //  187    191    82     93     Ljava/lang/Exception;
        //  187    191    274    285    Any
        //  196    200    82     93     Ljava/lang/Exception;
        //  196    200    274    285    Any
        //  201    207    82     93     Ljava/lang/Exception;
        //  201    207    274    285    Any
        //  213    217    996    1007   Ljava/lang/Exception;
        //  213    217    963    976    Any
        //  218    220    996    1007   Ljava/lang/Exception;
        //  218    220    963    976    Any
        //  229    233    996    1007   Ljava/lang/Exception;
        //  229    233    963    976    Any
        //  235    238    996    1007   Ljava/lang/Exception;
        //  235    238    963    976    Any
        //  241    246    996    1007   Ljava/lang/Exception;
        //  241    246    963    976    Any
        //  255    259    82     93     Ljava/lang/Exception;
        //  255    259    274    285    Any
        //  265    271    82     93     Ljava/lang/Exception;
        //  265    271    274    285    Any
        //  289    293    951    955    Ljava/io/IOException;
        //  297    301    955    959    Ljava/io/IOException;
        //  310    314    959    963    Ljava/io/IOException;
        //  315    321    959    963    Ljava/io/IOException;
        //  323    327    996    1007   Ljava/lang/Exception;
        //  323    327    963    976    Any
        //  332    336    1007   1021   Ljava/lang/Exception;
        //  332    336    976    992    Any
        //  337    343    1007   1021   Ljava/lang/Exception;
        //  337    343    976    992    Any
        //  346    351    1007   1021   Ljava/lang/Exception;
        //  346    351    976    992    Any
        //  351    355    1007   1021   Ljava/lang/Exception;
        //  351    355    976    992    Any
        //  369    373    1007   1021   Ljava/lang/Exception;
        //  369    373    976    992    Any
        //  387    391    1007   1021   Ljava/lang/Exception;
        //  387    391    976    992    Any
        //  397    403    1007   1021   Ljava/lang/Exception;
        //  397    403    976    992    Any
        //  405    409    1007   1021   Ljava/lang/Exception;
        //  405    409    976    992    Any
        //  418    422    1025   1029   Ljava/io/IOException;
        //  423    429    1025   1029   Ljava/io/IOException;
        //  440    444    1007   1021   Ljava/lang/Exception;
        //  440    444    976    992    Any
        //  446    453    1007   1021   Ljava/lang/Exception;
        //  446    453    976    992    Any
        //  458    462    1007   1021   Ljava/lang/Exception;
        //  458    462    976    992    Any
        //  463    469    1007   1021   Ljava/lang/Exception;
        //  463    469    976    992    Any
        //  470    474    514    529    Ljava/lang/Exception;
        //  470    474    803    816    Any
        //  475    481    514    529    Ljava/lang/Exception;
        //  475    481    803    816    Any
        //  504    507    514    529    Ljava/lang/Exception;
        //  504    507    803    816    Any
        //  508    512    514    529    Ljava/lang/Exception;
        //  508    512    803    816    Any
        //  512    514    514    529    Ljava/lang/Exception;
        //  512    514    803    816    Any
        //  529    533    1007   1021   Ljava/lang/Exception;
        //  529    533    976    992    Any
        //  535    543    1007   1021   Ljava/lang/Exception;
        //  535    543    976    992    Any
        //  559    563    514    529    Ljava/lang/Exception;
        //  559    563    803    816    Any
        //  563    567    514    529    Ljava/lang/Exception;
        //  563    567    803    816    Any
        //  570    575    514    529    Ljava/lang/Exception;
        //  570    575    803    816    Any
        //  588    592    514    529    Ljava/lang/Exception;
        //  588    592    803    816    Any
        //  606    611    514    529    Ljava/lang/Exception;
        //  606    611    803    816    Any
        //  618    622    514    529    Ljava/lang/Exception;
        //  618    622    803    816    Any
        //  627    631    1007   1021   Ljava/lang/Exception;
        //  627    631    976    992    Any
        //  632    634    1007   1021   Ljava/lang/Exception;
        //  632    634    976    992    Any
        //  643    647    1007   1021   Ljava/lang/Exception;
        //  643    647    976    992    Any
        //  654    658    1007   1021   Ljava/lang/Exception;
        //  654    658    976    992    Any
        //  662    665    1007   1021   Ljava/lang/Exception;
        //  662    665    976    992    Any
        //  667    672    1007   1021   Ljava/lang/Exception;
        //  667    672    976    992    Any
        //  676    680    1007   1021   Ljava/lang/Exception;
        //  676    680    976    992    Any
        //  690    693    1007   1021   Ljava/lang/Exception;
        //  690    693    976    992    Any
        //  695    700    1007   1021   Ljava/lang/Exception;
        //  695    700    976    992    Any
        //  713    716    1007   1021   Ljava/lang/Exception;
        //  713    716    976    992    Any
        //  735    738    514    529    Ljava/lang/Exception;
        //  735    738    803    816    Any
        //  745    750    514    529    Ljava/lang/Exception;
        //  745    750    803    816    Any
        //  754    758    514    529    Ljava/lang/Exception;
        //  754    758    803    816    Any
        //  774    779    514    529    Ljava/lang/Exception;
        //  774    779    803    816    Any
        //  786    790    514    529    Ljava/lang/Exception;
        //  786    790    803    816    Any
        //  790    794    514    529    Ljava/lang/Exception;
        //  790    794    803    816    Any
        //  796    800    514    529    Ljava/lang/Exception;
        //  796    800    803    816    Any
        //  826    831    514    529    Ljava/lang/Exception;
        //  826    831    803    816    Any
        //  834    838    1007   1021   Ljava/lang/Exception;
        //  834    838    976    992    Any
        //  839    841    1007   1021   Ljava/lang/Exception;
        //  839    841    976    992    Any
        //  845    849    1007   1021   Ljava/lang/Exception;
        //  845    849    976    992    Any
        //  850    854    1007   1021   Ljava/lang/Exception;
        //  850    854    976    992    Any
        //  867    871    1007   1021   Ljava/lang/Exception;
        //  867    871    976    992    Any
        //  873    876    1007   1021   Ljava/lang/Exception;
        //  873    876    976    992    Any
        //  884    889    1007   1021   Ljava/lang/Exception;
        //  884    889    976    992    Any
        //  890    894    1007   1021   Ljava/lang/Exception;
        //  890    894    976    992    Any
        //  894    898    1007   1021   Ljava/lang/Exception;
        //  894    898    976    992    Any
        //  899    905    1007   1021   Ljava/lang/Exception;
        //  899    905    976    992    Any
        //  911    915    1007   1021   Ljava/lang/Exception;
        //  911    915    976    992    Any
        //  924    928    1021   1025   Ljava/io/IOException;
        //  929    935    1021   1025   Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 571 out of bounds for length 571
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:359)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:427)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3362)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:112)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private int d(final int n) {
        final byte b = 12;
        int n2;
        if (this.E1163[n] >= b) {
            n2 = this.E1163[n] - b;
        }
        else if (this.E1163[n] <= -12) {
            n2 = 98 - this.E1163[n];
        }
        else {
            n2 = -1;
        }
        return n2;
    }
    
    private static int d(final int n, final int n2, final int n3) {
        return n2 * n3 + n;
    }
    
    private void d() {
        final int n = 25;
        final int n2 = 15;
        final int n3 = 3;
        this.a1002.setColor(16580557);
        this.a1002.fillRect(n2, 13, 210, 297);
        for (int i = 0; i < 10; ++i) {
            this.a1002.drawImage(this.a1013[n3][n], n2, (i << 5) + 13, 0);
            this.a(this.a1013[n3][n], 216, (i << 5) + 13, 1);
        }
    }
    
    private void d(final int n) {
        for (int i = 0; i < 3; ++i) {
            this.a1002.drawImage(this.a1013[4][6], this.u + i * 176, this.v + n, 0);
        }
    }
    
    private void d(final int n, final int n2) {
        final int n3 = 3;
        final int n4 = 2;
        final int n5 = 1;
        final int n6 = 4;
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.drawImage(this.a1013[n6][n5], n, n2 - this.a1013[n6][n5].getHeight(), 0);
        this.a1002.drawImage(this.a1013[n6][n4], this.a1013[n6][n5].getWidth() + n, n2 - this.a1013[n6][n4].getHeight(), 0);
        this.a1002.drawImage(this.a1013[n6][0], this.a1013[n6][n5].getWidth() + n + this.a1013[n6][n4].getWidth(), n2 - this.a1013[n6][0].getHeight(), 0);
        this.a1002.drawImage(this.a1013[n6][n3], this.a1013[n6][n5].getWidth() + n + this.a1013[n6][n4].getWidth() + this.a1013[n6][0].getWidth() + 15, n2 - this.a1013[n6][n3].getHeight(), 0);
        this.a1002.setColor(14834304);
        this.a1002.fillRect(0, n2, 240, 20);
    }
    
    private void d(final int n, final int n2, final int n3) {
        final long n4 = 1L;
        final int n5 = 24;
        final int n6 = 3;
        this.a1002.drawImage(this.a1013[n6][n5], ((int)(this.a1019 & n4) << 1) + n, n3, 0);
        this.a(this.a1013[n6][n5], n2 - ((int)(this.a1019 & n4) << 1), n3, 1);
    }
    
    private void d(final int n, final int n2, final int n3, final int n4) {
        final int n5 = 16382577;
        final int n6 = 3;
        final int n7 = 4;
        final int n8 = 1;
        final int n9 = this.o1098[n] << 3;
        for (int i = 0; i < n7; ++i) {
            this.p(n3 + n9 + this.w1110[i << 1], n4 + n9 + this.w1110[(i << 1) + 1], this.bu);
        }
        if (n2 == n6) {
            if (this.bu < this.v1109.length && this.bu > 0) {
                for (int j = 0; j < 7; ++j) {
                    this.g(n3 + n9 + this.p1108[this.bu - n8][j << 1] - this.bP, n4 + n9 + this.p1108[this.bu - n8][(j << 1) + 1] - this.bQ + 13, this.v1109[this.bu - n8] << 1, 16422227, n5);
                }
            }
            else if (this.bu == 0) {
                int n10;
                if (this.o1098[n] == 2) {
                    n10 = 19;
                }
                else {
                    n10 = 25;
                }
                this.g(n3 + n9 - n10 - this.bP, n4 + n9 - n10 - this.bQ + 13, n10 << 1, 16422227, n5);
            }
        }
        else if (n2 == n7) {
            this.b(this.a1013[n6][21], n3 + n9 - this.bP, n4 + 13 - this.bQ - (this.bu << 1), n7);
        }
    }
    
    private void d(final int n, final int n2, final int n3, final int n4, final int n5) {
        this.a(this.a1013[3][15], n2, n3, n << 4, 0, n4, n5);
    }
    
    private void d(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        switch (n3) {
            case 2:
            case 3:
            case 5:
            case 8:
            case 9: {
                this.a(this.a1013[n3 + 18][1], n, n2, n3, n4, this.w1123[n3].length);
                if (n3 == 8 || n3 == 5) {
                    final int length = this.w1123[n3 - 1].length;
                    final Image image = this.a1013[n3 + 18][2];
                    byte b;
                    if (n3 == 5) {
                        b = this.x1124[n4];
                    }
                    else {
                        b = 0;
                    }
                    this.a(image, n, n2 + b, n3 - 1, n4, length);
                    break;
                }
                break;
            }
            case 0:
            case 4: {
                if (n6 != 6 || n5 < 0 || n5 > 3) {
                    break;
                }
                final Image image2 = this.a1013[18][n5 + 1];
                final int n7 = n + this.y1125[n5 << 2];
                final int n8 = this.y1125[(n5 << 2) + 1] + n2 + 13;
                final byte b2 = this.w1123[0][n4];
                byte b3;
                if (n5 == 0) {
                    b3 = 0;
                }
                else {
                    b3 = this.y1125[(n5 << 2) + 2];
                }
                this.a(image2, n7, n8, b3 * b2, 0, this.y1125[(n5 << 2) + 2], this.y1125[(n5 << 2) + 3], 0, 0);
                if (n4 > 2 && n4 < 10) {
                    this.a1002.drawImage(this.a1013[18][5], this.y1125[n5 << 2] + n + 2, this.y1125[(n5 << 2) + 1] + n2 - this.a1013[18][5].getHeight() - this.w1123[0][n4] + 13, 0);
                    break;
                }
                break;
            }
        }
    }
    
    private void d(final Image image, final int n, final int n2, final int n3) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.a(image, (i << 4) * this.m1084[n][0] + n2 + this.m1084[n][2] + 3 - this.bP, (j << 4) * this.m1084[n][1] + n3 + this.m1084[n][3] + 3 - this.bQ + 13, 0, 0, 9, 9, 0, 0);
            }
        }
    }
    
    private boolean d() {
        final boolean s1088 = true;
        boolean b;
        if (this.by <= 0) {
            this.s1088 = false;
            b = s1088;
        }
        else {
            this.s1088 = s1088;
            b = false;
        }
        return b;
    }
    
    private boolean d(final int n) {
        final int o = 5;
        final int n2 = 3;
        final boolean b = true;
        final int n3 = 2;
        final int[] array = this.c1107[n];
        boolean b2;
        if (!this.f1106[array[n3]]) {
            if (array[n2] < o) {
                if (!this.j(this.a(array[n3], this.r1101, array[n2]))) {
                    this.o = 0;
                    return false;
                }
                b2 = b;
            }
            else {
                if (array[n2] != o) {
                    this.o = 4;
                    return false;
                }
                if (array[n3] == 0) {
                    if (!this.e()) {
                        this.o = o;
                        return false;
                    }
                    if (!this.j(this.a(array[n3], this.r1101, array[n2]))) {
                        this.o = 0;
                        return false;
                    }
                    this.f1106[array[n3]] = b;
                    b2 = b;
                }
                else {
                    switch (this.ac) {
                        default: {
                            return false;
                        }
                        case 0: {
                            if (array[n3] < 6) {
                                if (!this.f1106[0]) {
                                    this.o = 6;
                                    return false;
                                }
                                if (this.j(this.a(array[n3], this.r1101, array[n2]))) {
                                    this.f1106[array[n3]] = b;
                                    b2 = b;
                                    break;
                                }
                                this.o = 0;
                                return false;
                            }
                            else {
                                if (this.j(this.a(array[n3], this.r1101, array[n2]))) {
                                    this.f1106[array[n3]] = b;
                                    b2 = b;
                                    break;
                                }
                                this.o = 0;
                                return false;
                            }
                            break;
                        }
                        case 1: {
                            if (array[n3] < 6) {
                                if (this.j(this.a(array[n3], this.r1101, array[n2]))) {
                                    this.f1106[array[n3]] = b;
                                    b2 = b;
                                    break;
                                }
                                this.o = 0;
                                return false;
                            }
                            else {
                                if (!this.f1106[0]) {
                                    this.o = 6;
                                    return false;
                                }
                                if (this.j(this.a(array[n3], this.r1101, array[n2]))) {
                                    this.f1106[array[n3]] = b;
                                    b2 = b;
                                    break;
                                }
                                this.o = 0;
                                return false;
                            }
                            break;
                        }
                    }
                }
            }
        }
        else {
            if (array[n2] >= o) {
                this.o = 4;
                return false;
            }
            if (!this.j(this.a(array[n3], this.r1101, array[n2]))) {
                this.o = 0;
                return false;
            }
            b2 = b;
        }
        return b2;
        b2 = false;
        return b2;
    }
    
    private boolean d(final int n, final int n2) {
        return (this.E1163[this.a(n, n2)] & 0x1) == 0x0;
    }
    
    private static final int e(final int n) {
        final int n2 = 97;
        final int n3 = 65;
        final int n4 = 48;
        int n5;
        if (n >= n4 && n <= 57) {
            n5 = n - n4;
        }
        else if (n >= n2 && n <= 122) {
            n5 = n - n2 + 10;
        }
        else {
            if (n < n3 || n > 90) {
                throw new Exception();
            }
            n5 = n - n3 + 10;
        }
        return n5;
    }
    
    private void e() {
        this.p();
        this.a1002.setColor(12493976);
        this.a1002.fillRect(0, 13, 240, 297);
        this.d();
    }
    
    private final void e(final int n) {
        while (this.am < n) {
            ++this.am;
            this.m1033 = true;
            ((Canvas)this).repaint();
            ((Canvas)this).serviceRepaints();
        }
        if (this.am == 100) {
            this.m1033 = false;
            this.am = 0;
        }
    }
    
    private void e(final int n, final int n2) {
        final int n3 = 5;
        final int n4 = 4;
        for (int i = 0; i < 15; ++i) {
            this.a1002.drawImage(this.a1013[n4][n4], this.a1013[n4][n4].getWidth() * i + n, n2 - this.a1013[n4][n4].getHeight(), 0);
            this.a1002.drawImage(this.a1013[n4][n3], this.a1013[n4][n3].getWidth() * i + n, n2, 0);
        }
    }
    
    private void e(final int n, final int n2, final int n3) {
        this.a(this.a1013[4][17], n2, n3, 0, n * 12, 20, 12, 0, 0);
    }
    
    private void e(final int n, final int n2, final int n3, final int n4) {
        final int n5 = 240;
        switch (n3) {
            case 0:
            case 1:
            case 3:
            case 4:
            case 5:
            case 7: {
                this.a1002.setClip(0, 13, n5, 276);
                this.a1002.setColor(this.l1116[this.aN]);
                final int a = this.a(n3, this.t1103, n4);
                this.a1002.drawArc((this.o1098[n3] << 3) + n - a - this.bP, (this.o1098[n3] << 3) + n2 - a - this.bQ + 13, a << 1, a << 1, 0, 360);
                break;
            }
        }
        this.a1002.setClip(0, 0, n5, 320);
    }
    
    private void e(final int n, final int n2, final int n3, final int n4, final int n5) {
        this.a1002.setColor(7438477);
        if (this.o == -1) {
            if (n == 17) {
                this.b(this.ay, n2, n3, n4, n5);
            }
            else {
                this.a(this.b1015[n + 2], 0, n2, n3, n4, n5);
            }
        }
        else {
            this.a(this.o, n2, n3, n4, n5);
        }
    }
    
    private void e(final Image image, final int n, final int n2, final int n3) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                final int n4 = (i << 4) * this.m1084[n][0] + n2 + this.m1084[n][2];
                final int n5 = (j << 4) * this.m1084[n][1] + n3 + this.m1084[n][3];
                if (this.D1162[this.a(n4, n5)] >= 6) {
                    this.a(image, n4 - this.bP, n5 - this.bQ + 13, 0, 0, 15, 16, 0, 0);
                }
            }
        }
    }
    
    private boolean e() {
        for (int i = 0; i < 5; ++i) {
            if (!this.a1056[i]) {
                return false;
            }
        }
        return true;
    }
    
    private boolean e(final int n) {
        final int n2 = 6;
        final int n3 = 3;
        final int n4 = 1;
        final int n5 = 2;
        final int[] array = this.c1107[n];
        final int n6 = array[0] + (this.o1098[array[n5]] << 3);
        final int n7 = array[n4] + (this.o1098[array[n5]] << 3);
        final int a = this.a(array[n5], this.t1103, array[n3]);
        switch (array[n5]) {
            case 0:
            case 1:
            case 3:
            case 4:
            case 5:
            case 7: {
                for (int i = 0; i < this.aP; ++i) {
                    final int[] array2 = this.b1066[this.o1153[i]];
                    if (this.a(array2[0], array2[n4], n6, n7, a) && f(array2[8])) {
                        array[n2] = this.a(array[n5], this.u1104, array[n3]);
                        if (array[4] == n2) {
                            final int n8 = 14;
                            if (++array[n8] <= n3) {
                                return n4 != 0;
                            }
                            array[14] = 10;
                        }
                        array[8] = this.o1153[i];
                        this.v(n);
                        final int n9 = n4;
                        return n9 != 0;
                    }
                }
                if (array[4] == n2 && array[14] > 0 && array[14] < 10) {
                    final int n10 = 14;
                    ++array[n10];
                    break;
                }
                break;
            }
            case 2:
            case 6: {
                if (this.a(array[0], array[n4], array[5], false)) {
                    array[n2] = this.a(array[n5], this.u1104, array[n3]);
                    this.v(n);
                    break;
                }
                break;
            }
            case 8:
            case 9: {
                if (this.p(array[n5], array[n3])) {
                    for (int j = 0; j < this.aP; ++j) {
                        final int[] array3 = this.b1066[j];
                        if (this.a(array3[0], array3[n4], n6, n7, a) && f(array3[8])) {
                            array3[15] = 48;
                        }
                    }
                }
                if (this.a(array[0], array[n4], array[5], (boolean)(n4 != 0))) {
                    array[n2] = this.a(array[n5], this.u1104, array[n3]);
                    this.v(n);
                    break;
                }
                break;
            }
        }
        final int n9 = 0;
        return n9 != 0;
    }
    
    private boolean e(final int n, final int n2) {
        return this.E1163[this.a(n, n2)] == 8;
    }
    
    private void f() {
        final int n = 10;
        final int n2 = 7;
        final int n3 = 3;
        final int n4 = 310;
        if (this.a1007 > this.b1008) {
            if (this.a1007 / this.b1008 > n) {
                this.p = 30;
            }
            else {
                this.p = 25;
            }
            final int n5 = 240 - this.p >> 1;
            this.a1002.setColor(16580557);
            this.a1002.setClip(0, 0, 240, 320);
            this.a1002.fillRect(n5, n4, this.p, n);
            this.a(this.a1013[n3][13], n5 + 10, 312, 50, 0, n2, n2, 0, 0);
            this.a(this.a1013[n3][24], n5 + 8, ((int)(this.a1019 & 0x1L) << 1) + 302, 6);
            this.b(this.c / this.b1008 + 1, n5 + 2, n4);
            this.b((this.a1007 + this.b1008 - 1) / this.b1008, n5 + 18, n4);
        }
    }
    
    private void f(final int n) {
        if (n >= 0) {
            if (n < this.a1038) {
                final int[] array = this.a1039[n];
                final int[][] a1039 = this.a1039;
                final int[][] a1040 = this.a1039;
                final byte a1041 = (byte)(this.a1038 - 1);
                this.a1038 = a1041;
                a1039[n] = a1040[a1041];
                this.a1039[this.a1038] = array;
                this.a1040[n] = null;
                this.a1040[n] = this.a1040[this.a1038];
                this.a1040[this.a1038] = null;
            }
        }
        else {
            this.a1038 = 0;
            this.a1040 = null;
        }
    }
    
    private void f(final int n, final int n2) {
        if (!this.n1036) {
            this.x();
            this.n1036 = true;
        }
        this.z();
        if (n == 0 || n2 < 18) {
            switch (n2) {
                case 1: {
                    if (n == 0) {
                        this.g(0, 1);
                    }
                    else {
                        this.g(1, 1);
                    }
                    this.a(this.a1013[1][1], 120, 0, 1, 12, 4, 120, this.g1035[0], 0, -1);
                    break;
                }
                case 5: {
                    this.f(0);
                    this.a(this.a1013[1][0], 120, this.g1035[0], 2, 12, 4, 4, 0, 0, -1);
                    break;
                }
                case 8: {
                    this.a(this.a1013[1][5], 120, this.g1035[0] + 2, 0, 12, 0, 0, 0, 0, 0);
                    this.a(this.a1013[1][2], 90, this.g1035[1], 2, 4, 4, 4, 0, 0, -1);
                    this.a(this.a1013[1][3], 120, this.g1035[1], 2, 4, 4, 4, 0, 0, -1);
                    this.a(this.a1013[1][4], 150, this.g1035[1], 2, 4, 4, 4, 0, 0, -1);
                    this.a(this.a1013[1][6], 15, this.g1035[1], 1, 12, 3, this.ao, this.g1035[2], 0, -1);
                    break;
                }
                case 10: {
                    this.f(5);
                    this.a(null, this.ao, this.g1035[2], 3, 0, 0, 0, 0, 0, -1);
                    this.b(5, 4, 0, 1, 2, 0);
                    break;
                }
                case 14: {
                    this.b(5, 3, 0, 3, this.ao - 8, this.g1035[2]);
                    this.b(6, 3, 0, 3, this.ao + this.c1037[2] - 4, this.g1035[2]);
                    break;
                }
                case 15: {
                    this.b(7, 3, 0, 2, this.ao + this.c1037[4] - 2, this.g1035[2]);
                    break;
                }
                case 17: {
                    this.b(5, 3, 0, 3, this.ao, this.g1035[2]);
                    this.b(6, 3, 0, 3, this.c1037[2] + this.ao, this.g1035[2]);
                    this.b(7, 3, 0, 2, this.c1037[4] + this.ao, this.g1035[2]);
                    break;
                }
            }
            if (n2 >= 10 && n2 < 13) {
                this.a(null, 240, this.g1035[2], 3, 0, 4, this.c1037[n2 - 9 << 1] + this.ao, this.g1035[2], n2 - 9, -1);
            }
            else if (n2 >= 14 && n2 <= 17) {
                this.a(null, this.c1037[n2 - 10 << 1] + this.ao, 320, 3, 0, 4, this.c1037[n2 - 10 << 1] + this.ao, this.g1035[2], n2 - 10, -1);
            }
            else if (n2 >= 25 && n2 <= 31) {
                final int n3 = (n2 - 25 << 1) + 8;
                this.a(null, this.c1037[n3 << 1] + this.ao, this.g1035[2], 3, 0, 0, this.c1037[n3 << 1] + this.ao, this.g1035[2], n3, -1);
                if (n2 < 31) {
                    final int n4 = n3 + 1;
                    this.a(null, this.c1037[n4 << 1] + this.ao, this.g1035[2], 3, 0, 0, this.c1037[n4 << 1] + this.ao, this.g1035[2], n4, -1);
                }
            }
        }
        else {
            if (n2 >= 18 && n2 < 31) {
                this.a(null, this.c1037[n2 - 10 << 1] + this.ao, 320, 3, 0, 4, this.c1037[n2 - 10 << 1] + this.ao, this.g1035[2], n2 - 10, -1);
            }
            switch (n2) {
                case 50: {
                    this.b(2, 2, 4, 4, 4, 1);
                    break;
                }
                case 51: {
                    this.b(3, 2, 4, 4, 4, 1);
                    break;
                }
                case 52: {
                    this.b(4, 2, 4, 4, 4, 1);
                    break;
                }
                case 58: {
                    this.b(0, 1, 0, 1, 1000, 1000);
                    this.b(1, 2, 4, 4, 4, 1);
                    break;
                }
                case 63: {
                    this.b(15, 3, 0, 4, -10, this.g1035[2]);
                    break;
                }
            }
            if (n2 > 52 && n2 < 63) {
                final int n5 = n2 - 52;
                this.b(n5 + 4, 3, 0, 4, -10, this.g1035[2]);
                this.b(26 - n5, 3, 0, 4, 240, this.g1035[2]);
            }
        }
    }
    
    private void f(final int n, final int n2, final int n3) {
        final int n4 = this.a1013[4][21].getWidth() / 9;
        final int height = this.a1013[4][21].getHeight();
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(16580557);
        this.a1002.drawRect(n2, n3, n4 + 3, height + 3);
        this.a(this.a1013[4][21], n2 + 2, n3 + 2, n4 * n, 0, n4, height, 0, 0);
        this.a1002.drawImage(this.a1013[4][22], n2 - 3, n3, 0);
        this.a(this.a1013[4][22], n2 + n4 - 7, n3, 1);
        this.a(this.a1013[4][22], n2 - 3, n3 + height - 11, 2);
        this.a(this.a1013[4][22], n2 + n4 - 7, n3 + height - 11, 3);
        for (int i = 0; i < 8; ++i) {
            this.a1002.drawImage(this.a1013[4][23], n2 + n4 + 10 + (i & 0x3) * this.a1013[4][23].getWidth(), (i >> 2) * this.a1013[4][23].getHeight() + n3, 0);
        }
        int n5 = 0;
        int length;
        if (this.aN > 1 && this.aN < 6) {
            length = this.z1131[this.aN].length >> 1;
            if (this.A1132[this.X][this.aN] == 1) {
                n5 = length;
            }
        }
        else {
            length = this.z1131[this.aN].length;
            n5 = 0;
        }
        for (int j = 0; j < length; ++j) {
            this.q(this.z1131[this.aN][j + n5], n2 + n4 + 10 + (j & 0x3) * this.a1013[4][23].getWidth() + 3, (j >> 2) * this.a1013[4][23].getHeight() + n3 + 3);
        }
        for (int k = 0; k < length; ++k) {
            final int n6 = n2 + n4 + 10 + (k & 0x3) * this.a1013[4][23].getWidth();
            final int n7 = (k >> 2) * this.a1013[4][23].getHeight() + n3;
            if (k == this.ag) {
                this.a1002.setClip(0, 0, 240, 320);
                this.a1002.setColor(16580557);
                this.a1002.fillRect(n6, n7 + 20, this.k * this.b1015[this.z1131[this.aN][k] + 28].length(), this.j);
                this.a1002.setColor(5465994);
                this.a1002.drawString(this.b1015[this.z1131[this.aN][k + n5] + 28], n6, n7 + 20, 0);
            }
        }
    }
    
    private void f(final int n, final int n2, final int n3, final int n4) {
        if (n4 < 3) {
            this.a(this.a1013[29][this.I1142[n3][0]], this.k1141[n4][n3][0] + n - this.bP, this.k1141[n4][n3][1] + n2 - this.bQ + 13, n4 * this.I1142[n3][2], 0, this.I1142[n3][2], this.I1142[n3][3], this.I1142[n3][1], 0);
        }
        if (n4 > 0 && n4 < 3) {
            for (int i = 0; i < 2; ++i) {
                this.a(this.a1013[29][this.l1143[n3][i][0]], this.l1143[n3][i][1] + n - this.bP, this.l1143[n3][i][2] + n2 - this.bQ + 13, n4 * this.l1143[n3][i][4], 0, this.l1143[n3][i][4], this.l1143[n3][i][5], this.l1143[n3][i][3], 0);
            }
        }
        else if (n4 >= 3 && n4 < 6) {
            for (int j = 2; j < 4; ++j) {
                this.a(this.a1013[29][this.l1143[n3][j][0]], this.l1143[n3][j][1] + n - this.bP, this.l1143[n3][j][2] + n2 - this.bQ + 13, this.l1143[n3][j][4] * (n4 - 3), 0, this.l1143[n3][j][4], this.l1143[n3][j][5], this.l1143[n3][j][3], 0);
            }
        }
    }
    
    private final void f(final int n, final int n2, final int n3, final int n4, final int n5) {
        int n6;
        if (n5 == 3) {
            n6 = 1;
        }
        else {
            n6 = 0;
        }
        final int n7 = n & 0x1;
        this.a1002.setColor(this.k1071[this.aN]);
        this.a1002.fillArc(this.c1090[n][n5][0] + n2 + this.d1091[n][n5][0], this.c1090[n][n5][1] + n3 + this.d1091[n][n5][1], 12, 12, 0, 360);
        this.a(this.a1013[this.bj][n7], n2 + this.d1091[n][n5][0], n3 + this.d1091[n][n5][1], this.a1092[n][n5][n4][0], 0, this.a1092[n][n5][n4][1], this.a1013[this.bj][n7].getHeight(), n6, 0);
        if ((n & 0x1) == 0x1) {
            this.a(this.a1013[31][9], n2 - 11, n3 - 23, (int)(this.a1019 & (long)3) * 22, 0, 22, 34, 0, 0);
        }
    }
    
    private void f(final Image image, final int n, final int n2, final int n3) {
        final int n4 = 12;
        this.a(image, n - this.bP, n2 - this.bQ + 13, n3 * 10, 0, 10, n4, 0, n4);
    }
    
    private boolean f() {
        final boolean e1179 = true;
        this.aw();
        this.au();
        return this.E1179 = e1179;
    }
    
    private static boolean f(final int n) {
        return n != 5 && n != 6 && n != 8 && n != 4;
    }
    
    private boolean f(final int n, final int n2) {
        return this.E1163[this.a(n, n2)] == 10;
    }
    
    private void g() {
        final int q = 100;
        final int n = 20;
        final boolean l1031 = true;
        switch (this.h1047) {
            case -3:
            case 52: {
                final int q2 = this.q - n;
                this.q = q2;
                if (q2 < n) {
                    this.q = 0;
                    this.l1031 = false;
                }
                this.a1017.setLevel(this.q);
                break;
            }
            case -4:
            case 54: {
                final int q3 = this.q + 20;
                this.q = q3;
                if (q3 > q) {
                    this.q = q;
                }
                this.l1031 = l1031;
                this.a1017.setLevel(this.q);
                break;
            }
            case -6:
            case -5:
            case 53: {
                this.a();
                if (this.l == (l1031 ? 1 : 0)) {
                    this.g(7, -1);
                    break;
                }
                break;
            }
        }
    }
    
    private void g(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_2       
        //     2: iconst_0       
        //     3: istore_3       
        //     4: aconst_null    
        //     5: astore          4
        //     7: iload_1        
        //     8: ifge            12
        //    11: return         
        //    12: aload_0        
        //    13: getfield        a.ap:I
        //    16: istore          5
        //    18: iload           5
        //    20: iload_2        
        //    21: if_icmpge       285
        //    24: iconst_0       
        //    25: istore          5
        //    27: aconst_null    
        //    28: astore          6
        //    30: iload           5
        //    32: iload_2        
        //    33: if_icmpge       276
        //    36: aload_0        
        //    37: getfield        a.a1043:[Ljavax/microedition/media/Player;
        //    40: iconst_0       
        //    41: aaload         
        //    42: astore          7
        //    44: aload           7
        //    46: ifnonnull       267
        //    49: iconst_0       
        //    50: istore          5
        //    52: aconst_null    
        //    53: astore          6
        //    55: aload_0        
        //    56: getfield        a.i1044:[I
        //    59: astore          7
        //    61: aload_0        
        //    62: getfield        a.ap:I
        //    65: istore_3       
        //    66: aload           7
        //    68: iload_3        
        //    69: iload_1        
        //    70: iastore        
        //    71: aload_0        
        //    72: getfield        a.h1041:[I
        //    75: astore          7
        //    77: aload           7
        //    79: iload_1        
        //    80: iload           5
        //    82: iastore        
        //    83: aload_0        
        //    84: getfield        a.a1042:[Ljava/io/InputStream;
        //    87: astore          7
        //    89: aload_0        
        //    90: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //    93: pop            
        //    94: getstatic       a.c1045:[Ljava/lang/String;
        //    97: astore          4
        //    99: aload           4
        //   101: iload_1        
        //   102: aaload         
        //   103: astore          4
        //   105: aload           4
        //   107: invokestatic    javax/microedition/lcdui/Display.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //   110: astore          4
        //   112: aload           7
        //   114: iload           5
        //   116: aload           4
        //   118: aastore        
        //   119: aload_0        
        //   120: getfield        a.a1043:[Ljavax/microedition/media/Player;
        //   123: astore          7
        //   125: aload_0        
        //   126: getfield        a.a1042:[Ljava/io/InputStream;
        //   129: astore          4
        //   131: aload           4
        //   133: iload           5
        //   135: aaload         
        //   136: astore          4
        //   138: getstatic       a.c1045:[Ljava/lang/String;
        //   141: astore          8
        //   143: aload           8
        //   145: iload_1        
        //   146: aaload         
        //   147: astore          8
        //   149: ldc_w           "wav"
        //   152: astore          9
        //   154: aload           8
        //   156: aload           9
        //   158: invokevirtual   java/lang/String.endsWith:(Ljava/lang/String;)Z
        //   161: istore_2       
        //   162: iload_2        
        //   163: ifeq            327
        //   166: ldc_w           "audio/x-wav"
        //   169: astore          8
        //   171: aload           4
        //   173: aload           8
        //   175: invokestatic    javax/microedition/media/Manager.createPlayer:(Ljava/io/InputStream;Ljava/lang/String;)Ljavax/microedition/media/Player;
        //   178: astore          4
        //   180: aload           7
        //   182: iload           5
        //   184: aload           4
        //   186: aastore        
        //   187: aload_0        
        //   188: getfield        a.a1043:[Ljavax/microedition/media/Player;
        //   191: astore          7
        //   193: aload           7
        //   195: iload           5
        //   197: aaload         
        //   198: astore          7
        //   200: aload           7
        //   202: invokeinterface javax/microedition/media/Player.realize:()V
        //   207: aload_0        
        //   208: getfield        a.a1043:[Ljavax/microedition/media/Player;
        //   211: astore          7
        //   213: aload           7
        //   215: iload           5
        //   217: aaload         
        //   218: astore          7
        //   220: aload           7
        //   222: invokeinterface javax/microedition/media/Player.getState:()I
        //   227: istore          10
        //   229: sipush          300
        //   232: istore_3       
        //   233: iload           10
        //   235: iload_3        
        //   236: if_icmpeq       335
        //   239: aload_0        
        //   240: getfield        a.a1043:[Ljavax/microedition/media/Player;
        //   243: astore          7
        //   245: aload           7
        //   247: iload           5
        //   249: aaload         
        //   250: astore          7
        //   252: aload           7
        //   254: invokeinterface javax/microedition/media/Player.prefetch:()V
        //   259: goto            207
        //   262: astore          7
        //   264: goto            207
        //   267: iload           5
        //   269: iconst_1       
        //   270: iadd           
        //   271: istore          5
        //   273: goto            30
        //   276: iconst_0       
        //   277: istore          5
        //   279: aconst_null    
        //   280: astore          6
        //   282: goto            55
        //   285: aload_0        
        //   286: getfield        a.h1041:[I
        //   289: astore          6
        //   291: aload_0        
        //   292: getfield        a.i1044:[I
        //   295: iconst_0       
        //   296: iaload         
        //   297: istore          10
        //   299: aload           6
        //   301: iload           10
        //   303: iaload         
        //   304: istore          5
        //   306: aload_0        
        //   307: getfield        a.i1044:[I
        //   310: astore          7
        //   312: aload           7
        //   314: iconst_0       
        //   315: iaload         
        //   316: istore          10
        //   318: aload_0        
        //   319: iload           10
        //   321: invokespecial   a.i:(I)V
        //   324: goto            55
        //   327: ldc_w           "audio/midi"
        //   330: astore          8
        //   332: goto            171
        //   335: aload_0        
        //   336: getfield        a.a1042:[Ljava/io/InputStream;
        //   339: astore          7
        //   341: aload           7
        //   343: iload           5
        //   345: aaload         
        //   346: astore          7
        //   348: aload           7
        //   350: invokevirtual   java/io/InputStream.close:()V
        //   353: aload_0        
        //   354: getfield        a.a1042:[Ljava/io/InputStream;
        //   357: astore          7
        //   359: iconst_0       
        //   360: istore_3       
        //   361: aconst_null    
        //   362: astore          4
        //   364: aload           7
        //   366: iload           5
        //   368: aconst_null    
        //   369: aastore        
        //   370: aload_0        
        //   371: getfield        a.ap:I
        //   374: iconst_1       
        //   375: iadd           
        //   376: istore          5
        //   378: aload_0        
        //   379: iload           5
        //   381: putfield        a.ap:I
        //   384: goto            11
        //   387: astore          6
        //   389: goto            370
        //   392: astore          6
        //   394: goto            370
        //   397: astore          7
        //   399: goto            353
        //   402: astore          7
        //   404: goto            207
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  83     87     387    392    Ljava/lang/Exception;
        //  89     94     387    392    Ljava/lang/Exception;
        //  94     97     387    392    Ljava/lang/Exception;
        //  101    103    387    392    Ljava/lang/Exception;
        //  105    110    387    392    Ljava/lang/Exception;
        //  116    119    387    392    Ljava/lang/Exception;
        //  119    123    387    392    Ljava/lang/Exception;
        //  125    129    387    392    Ljava/lang/Exception;
        //  133    136    387    392    Ljava/lang/Exception;
        //  138    141    387    392    Ljava/lang/Exception;
        //  145    147    387    392    Ljava/lang/Exception;
        //  156    161    387    392    Ljava/lang/Exception;
        //  173    178    387    392    Ljava/lang/Exception;
        //  184    187    387    392    Ljava/lang/Exception;
        //  187    191    402    407    Ljava/lang/Exception;
        //  195    198    402    407    Ljava/lang/Exception;
        //  200    207    402    407    Ljava/lang/Exception;
        //  207    211    387    392    Ljava/lang/Exception;
        //  215    218    387    392    Ljava/lang/Exception;
        //  220    227    387    392    Ljava/lang/Exception;
        //  239    243    262    267    Ljava/lang/Exception;
        //  247    250    262    267    Ljava/lang/Exception;
        //  252    259    262    267    Ljava/lang/Exception;
        //  335    339    397    402    Ljava/lang/Exception;
        //  343    346    397    402    Ljava/lang/Exception;
        //  348    353    397    402    Ljava/lang/Exception;
        //  353    357    392    397    Ljava/lang/Exception;
        //  368    370    392    397    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0207:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void g(final int aq, final int loopCount) {
        final int n = 1;
        if (aq >= 0 && (this.as >= 8 || aq != this.aq) && this.l1031) {
            if (aq != this.aq && this.aq != -1) {
                this.h(this.aq);
            }
            this.g(aq);
            Label_0245: {
                if (aq != this.aq) {
                    break Label_0245;
                }
                int i = this.ap - n;
                Label_0391: {
                    if (i >= 0) {
                        if (this.i1044[i] != aq) {
                            break Label_0391;
                        }
                        while (i > 0) {
                            this.i1044[i] = this.i1044[i - n];
                            --i;
                        }
                        this.i1044[0] = aq;
                    }
                    try {
                        final Player[] a1043 = this.a1043;
                        try {
                            final Player player = a1043[this.h1041[aq]];
                            try {
                                if (player.getState() == 400) {
                                    return;
                                }
                                this.aq = aq;
                                (this.a1017 = (VolumeControl)((Controllable)this.a1043[this.h1041[aq]]).getControl("VolumeControl")).setLevel(this.q);
                                try {
                                    final Player[] a1044 = this.a1043;
                                    try {
                                        a1044[this.h1041[aq]].setLoopCount(loopCount);
                                        try {
                                            final Player[] a1045 = this.a1043;
                                            try {
                                                final Player player2 = a1045[this.h1041[aq]];
                                                try {
                                                    player2.start();
                                                    return;
                                                }
                                                catch (final Exception ex) {
                                                    return;
                                                }
                                            }
                                            catch (final Exception ex2) {}
                                        }
                                        catch (final Exception ex3) {}
                                        --i;
                                    }
                                    catch (final Exception ex4) {}
                                }
                                catch (final Exception ex5) {}
                            }
                            catch (final Exception ex6) {}
                        }
                        catch (final Exception ex7) {}
                    }
                    catch (final Exception ex8) {}
                }
            }
        }
    }
    
    private void g(final int n, final int n2, final int n3) {
        this.a(this.a1013[3][18], n2, n3, 0, n * 11, 35, 11, 0, 0);
    }
    
    private void g(final int n, final int n2, final int n3, final int n4) {
        final int n5 = 2;
        final int n6 = 1;
        final int n7 = 6;
        for (int n8 = 3, i = 0; i < n8; ++i) {
            for (int j = 0; j < n8; ++j) {
                final int n9 = (i << 4) * this.m1084[n][0] + n2 + this.m1084[n][n5] - this.bP;
                final int n10 = (j << 4) * this.m1084[n][n6] + n3 + this.m1084[n][n8] - this.bQ + 13;
                switch (n) {
                    case 0:
                    case 2: {
                        if (n4 >= 0 && n4 < 7 && j == 0) {
                            this.r(n9, n10, n4);
                        }
                        if (n4 > n8 && n4 < 10 && j == n6) {
                            this.r(n9, n10, n4 - n8);
                        }
                        if (n4 > n7 && n4 < 12 && j == n5) {
                            this.r(n9, n10, n4 - n7);
                            break;
                        }
                        break;
                    }
                    case 1:
                    case 3: {
                        if (n4 >= 0 && n4 < 7 && i == 0) {
                            this.r(n9, n10, n4);
                        }
                        if (n4 > n8 && n4 < 10 && i == n6) {
                            this.r(n9, n10, n4 - n8);
                        }
                        if (n4 > n7 && n4 < 12 && i == n5) {
                            this.r(n9, n10, n4 - n7);
                            break;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    private void g(final int n, final int n2, final int n3, final int color, final int n4) {
        final int n5 = 360;
        final int n6 = 1;
        this.a1002.setClip(0, 0, 240, 320);
        if (n3 > 2) {
            this.a1002.setColor(color);
            this.a1002.fillArc(n, n2, n3, n3, 0, n5);
            this.a1002.setColor(n4);
            this.a1002.fillArc(n + 1, n2 + 1, n3 - n6, n3 - n6, 0, n5);
        }
        else {
            this.a1002.setColor(n4);
            this.a1002.fillRect(n, n2, n3, n3);
        }
    }
    
    private boolean g() {
        final int n = 1;
        switch (this.b()) {
            case 1:
            case 2: {
                ++this.bY;
                break;
            }
            case 0: {
                this.bY = 0;
                try {
                    try {
                        final ByteArrayInputStream in = new ByteArrayInputStream(this.I1189);
                        final DataInputStream dataInputStream = new DataInputStream(in);
                        if (this.ca == 200 && dataInputStream.readByte() == 2 && dataInputStream.readByte() == n) {
                            this.b1177 = a(dataInputStream);
                            this.c1178 = a(dataInputStream);
                            byte f1180;
                            if (dataInputStream.readByte() == n) {
                                f1180 = (byte)n;
                            }
                            else {
                                f1180 = 0;
                            }
                            this.F1180 = (f1180 != 0);
                            this.d1181 = a(dataInputStream);
                            byte g1182;
                            if (dataInputStream.readByte() == n) {
                                g1182 = (byte)n;
                            }
                            else {
                                g1182 = 0;
                            }
                            this.G1182 = (g1182 != 0);
                            this.e1183 = a(dataInputStream);
                            this.ax();
                        }
                        dataInputStream.close();
                        in.close();
                        final byte b = (byte)n;
                    }
                    catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                }
                catch (final Exception ex2) {}
            }
            case -1: {
                if (this.bZ < 3) {
                    this.a((byte)n);
                    break;
                }
                final byte b = (byte)n;
                return b != 0;
            }
        }
        final byte b = (byte)(false ? 1 : 0);
        return b != 0;
    }
    
    private static boolean g(final int n) {
        return n == 6;
    }
    
    private boolean g(final int n, final int n2) {
        return this.E1163[this.a(n, n2)] == 11;
    }
    
    private void h() {
        final int n = 104;
        final int n2 = 240;
        final int n3 = 320;
        this.a1002.setClip(0, 0, n2, n3);
        this.a1002.setColor(16777215);
        this.a1002.fillRect(0, 0, n2, n3);
        final int n4 = n2 - this.b1015[n].length() * this.k >> 1;
        final int n5 = n3 - this.j >> 1;
        this.a1002.setColor(14834304);
        this.a1002.drawString(this.b1015[n], n4, n5, 0);
        this.a1002.setColor(5465994);
        this.a1002.drawString(this.b1015[105], 0, n3 - this.j, 0);
        this.a1002.drawString(this.b1015[106], n2 - (this.k << 1), n3 - this.j, 0);
    }
    
    private void h(final int n) {
        if (n >= 0 && this.h1041[n] >= 0) {
            try {
                this.as = 0;
                final Player[] a1043 = this.a1043;
                try {
                    final Player player = a1043[this.h1041[n]];
                    try {
                        if (player.getState() != 400) {
                            return;
                        }
                        final Player[] a1044 = this.a1043;
                        try {
                            final Player player2 = a1044[this.h1041[n]];
                            try {
                                player2.stop();
                            }
                            catch (final Exception ex) {}
                        }
                        catch (final Exception ex2) {}
                    }
                    catch (final Exception ex3) {}
                }
                catch (final Exception ex4) {}
            }
            catch (final Exception ex5) {}
        }
    }
    
    private void h(final int n, final int n2) {
        this.a1002.setClip(0, 0, 240, 320);
        final int height = this.a1013[3][12].getHeight();
        if (this.l == 22) {
            this.q(this.bb, 18, 293);
            this.a1002.drawImage(this.a1013[3][28], 0, 299, 0);
            for (int i = 0; i < 2; ++i) {
                this.a(this.a1013[3][12], i * 60 + 120, n2 + 1, i * 9, 0, 9, height, 0, 0);
                this.b(this.b1066[0][i + 2], i * 60 + 131, n2);
            }
        }
        else if (this.l == 23) {
            this.q(this.X * 11 + 0, 18, 293);
        }
        else if (this.az != -1) {
            final int[] array = this.b1066[this.az];
            this.j(n, n2, array[6]);
            for (int j = 0; j < 2; ++j) {
                this.a(this.a1013[3][12], j * 60 + 120, n2 + 1, j * 9, 0, 9, height, 0, 0);
                this.b(array[j + 2], j * 60 + 131, n2);
            }
        }
        else if (this.ay != -1) {
            final int[] array2 = this.c1107[this.ay];
            this.g(array2[2], n, n2);
            for (int k = 0; k < 2; ++k) {
                final Image image = this.a1013[3][12];
                final int n3 = k * 60 + 120;
                final int n4 = n2 + 1;
                final int n5 = (k + 2) * 9;
                int n6;
                if (k == 0) {
                    n6 = 9;
                }
                else {
                    n6 = 18;
                }
                this.a(image, n3, n4, n5, 0, n6, height, 0, 0);
                int n8;
                if (k == 0) {
                    final int a = this.a(this.c1107[this.ay][2], this.s1102, this.c1107[this.ay][3]);
                    int n7;
                    if (array2[17] == 1) {
                        n7 = 10;
                    }
                    else {
                        n7 = 0;
                    }
                    n8 = a + n7;
                }
                else {
                    n8 = array2[3] + 1;
                }
                this.b(n8, (k + 1) * 9 + 120 + 2 + k * 60, n2);
            }
            this.e(array2[0], array2[1], array2[2], array2[3]);
        }
        else if (this.e(this.bN, this.bO)) {
            this.i(n, n2, 1);
        }
        else if (this.f(this.bN, this.bO)) {
            this.i(n, n2, 3);
        }
        else if (this.g(this.bN, this.bO)) {
            this.i(n, n2, 2);
        }
        else {
            this.i(n, n2, 0);
        }
    }
    
    private void h(final int n, final int n2, final int n3) {
        this.g(n, n2, n3);
        if (n > 0 && n < 6) {
            this.a(this.a1013[3][29], n2 + 36, n3 + 1, 17, 0, 17, 10, 0, 0);
        }
        else if (n >= 6 && n <= 10) {
            this.a(this.a1013[3][29], n2 + 36, n3 + 1, 0, 0, 17, 10, 0, 0);
        }
    }
    
    private void h(final int n, final int n2, final int n3, final int n4) {
        final int n5 = 8;
        final int n6 = -1;
        final int n7 = 10;
        final int n8 = 1;
        for (int i = 0; i < this.aP; ++i) {
            final int[] array = this.b1066[i];
            switch (this.D1162[this.a(array[0], array[n8])]) {
                case 4: {
                    if (array[n5] == 0) {
                        array[n5] = n8;
                        array[9] = n4;
                        this.v(i, this.a(n2, this.s1102, n3), n);
                        break;
                    }
                    break;
                }
                case 3: {
                    array[11] = 0;
                    if (array[n7] == n6 && array[26] != 4) {
                        this.v(i, this.a(n2, this.s1102, n3), n);
                        break;
                    }
                    break;
                }
                case 2: {
                    if (array[n7] == n6) {
                        if (array[11] > 0) {
                            if (this.c1107[n][n7] == n8) {
                                final int[] array2 = this.c1107[n];
                                final int n9 = 13;
                                if ((array2[n9] -= 2) < 0) {
                                    this.c1107[n][13] = 0;
                                }
                            }
                            this.c1107[n][16] = n8;
                        }
                        if (this.c1107[n][16] == n8) {
                            array[11] = 48;
                        }
                        this.v(i, this.a(n2, this.s1102, n3), n);
                        break;
                    }
                    break;
                }
                case 5: {
                    if (array[n7] == n6) {
                        this.v(i, this.a(n2, this.s1102, n3), n);
                        break;
                    }
                    break;
                }
                case 16:
                case 46: {
                    if (array[n5] != 4) {
                        this.v(i, this.a(n2, this.s1102, n3), n);
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private void h(final int n, final int n2, final int n3, final int n4, final int n5) {
        final int n6 = 3;
        final int n7 = 3;
        int n8 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        Label_0093: {
            if (!this.m(n4, n5)) {
                switch (n3) {
                    case 0:
                    case 2: {
                        n8 = 1;
                        final int n9 = 2;
                        n10 = 0;
                        n11 = n7;
                        n12 = n9;
                        break Label_0093;
                    }
                    case 1:
                    case 3: {
                        final int n13 = 1;
                        final int n14 = 2;
                        n10 = n13;
                        n11 = n14;
                        n12 = n6;
                        n8 = 0;
                        break Label_0093;
                    }
                }
            }
            n10 = 0;
            n11 = n7;
            n12 = n6;
            n8 = 0;
        }
        for (int i = n8; i < n12; ++i) {
            for (int j = n10; j < n11; ++j) {
                this.a(this.a1013[29][39], (i << 4) * this.m1084[n3][0] + n + this.m1084[n3][2] - this.bP, (j << 4) * this.m1084[n3][1] + n2 + this.m1084[n3][3] - this.bQ + 13 - 16, (int)(this.a1019 & (long)3) * 15, 0, 15, 29, 0, 0);
            }
        }
    }
    
    private boolean h(final int n) {
        return (this.a() & 0x7) > n;
    }
    
    private boolean h(final int n, final int n2) {
        return n > 0 && (n < this.bI && n2 > 0) && n2 < this.bJ && this.E1163[this.a(n, n2)] < 8;
    }
    
    private void i() {
        final boolean l = true;
        switch (this.h1047) {
            case -6:
            case -5: {
                this.l = (l ? 1 : 0);
                this.l1031 = l;
                this.q = 60;
                this.g(7, -1);
                break;
            }
            case -7: {
                this.l1031 = false;
                this.l = (l ? 1 : 0);
                break;
            }
        }
    }
    
    private void i(final int n) {
        final int n2 = -1;
        final int n3 = 1;
        if (n >= 0 && this.h1041[n] >= 0) {
            this.h(n);
            this.a1043[this.h1041[n]].close();
            this.a1043[this.h1041[n]] = null;
            for (int i = 0; i < this.ap; ++i) {
                if (this.i1044[i] == n) {
                    while (i < this.ap - n3) {
                        this.i1044[i] = this.i1044[i + 1];
                        ++i;
                    }
                    break;
                }
            }
            this.i1044[this.ap - n3] = n2;
            this.ap -= n3;
            this.h1041[n] = n2;
        }
    }
    
    private void i(final int n, final int n2) {
        final int n3 = 5;
        final int n4 = -1;
        final int n5 = 10;
        final int n6 = 8;
        final int[] array = this.b1066[n];
        if (array[n5] != n4 && --array[n5] < 0) {
            array[n5] = n4;
        }
        if (n2 <= 0 && array[n6] != n3 && array[n6] != 3 && array[n6] != 2) {
            array[7] = 0;
            array[12] = (array[11] = 0);
            array[14] = (array[13] = 0);
            array[n6] = n3;
        }
    }
    
    private void i(final int n, final int n2, final int n3) {
        for (int i = 0; i < this.c1051[n3].length; ++i) {
            this.c(this.a1013[3][11], i * 14 + n, n2, this.c1051[n3][i]);
        }
    }
    
    private void i(final int n, final int n2, final int n3, final int n4) {
        for (int i = 0; i < 4; ++i) {
            int n7;
            int n8;
            if (this.ay != -1) {
                final int n5 = this.P1157[i][0] * ((int)(this.a1019 & 0x1L) << 1);
                final int n6 = this.P1157[i][1] * ((int)(this.a1019 & 0x1L) << 1);
                n7 = n5;
                n8 = n6;
            }
            else {
                n7 = 0;
                n8 = 0;
            }
            this.a(this.a1013[3][0], n7 + n + (n3 - 7) * this.O1156[i][0] - this.bP, n8 + n2 + (n4 - 7) * this.O1156[i][1] - this.bQ + 13, i * 7, 0, 7, 7, 0, 0);
        }
        if (this.bF != 1) {
            int be;
            if (this.ay != -1) {
                be = this.bE;
            }
            else {
                be = n3;
            }
            this.b(this.a1013[3][1], (be >> 1) + this.bN - this.bP, this.bO - 16 - this.bQ - ((int)(this.a1019 & 0x1L) << 1) + 13, 4);
        }
    }
    
    private boolean i(final int n) {
        for (int i = 0; i < 5; i = (byte)(i + 1)) {
            if (this.C1134[n][i] != -1) {
                return false;
            }
        }
        return true;
    }
    
    private boolean i(final int n, final int n2) {
        final boolean b = true;
        if (this.X == (b ? 1 : 0)) {
            switch (n) {
                case 1:
                case 2:
                case 3:
                case 6:
                case 7: {
                    if (g(n2)) {
                        return b;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private void j() {
        final int n = 80;
        final int n2 = 1;
        final int n3 = 240;
        final int n4 = 107;
        this.a1002.setColor(16580557);
        this.a1002.fillRect(n3 - (this.b1015[n4].length() * this.k + 8) >> 1, n, this.b1015[n4].length() * this.k + 8, 140);
        this.c(n3 - (this.b1015[n4].length() * this.k + 8) >> 1, n, this.b1015[n4].length() * this.k + 8, 140, n2);
        this.a1002.setClip(0, 0, n3, 320);
        for (int i = 0; i < 6; ++i) {
            Label_0265: {
                if (i != this.r) {
                    this.a1002.setColor(15455661);
                    if (i != n2) {
                        break Label_0265;
                    }
                    if ((int)(this.a1019 & 0x1L) == 0) {
                        this.a1002.setColor(15455661);
                        break Label_0265;
                    }
                }
                this.a1002.setColor(14311547);
            }
            this.a1002.drawString(this.b1015[i + 107], n3 - this.b1015[i + 107].length() * this.k >> 1, i * 20 + 90, 0);
        }
    }
    
    private void j(final int ac) {
        final int aw = 1;
        this.aw = aw;
        this.aF = 8;
        this.aB = this.d1053[ac].length - aw;
        this.aC = ac;
        this.aE = 0;
        this.aD = 0;
        this.ax = (this.j << 1) + 25;
        if (this.aB < this.aF) {
            this.aF = this.aB + 1;
        }
        this.aG = 240 - this.aF * 18 >> 1;
        this.a(12);
    }
    
    private void j(final int n, final int n2) {
        final int n3 = 4;
        final int n4 = 3;
        final int n5 = 2;
        if (this.bu < this.a1013[n4][20].getWidth() / 27) {
            ++this.bu;
            if (this.bu == n5 && n2 == n3) {
                final int[] array = this.c1107[n];
                ++array[n4];
            }
        }
        else {
            if (n2 == 5) {
                this.t(n);
            }
            this.bu = 0;
            this.c1107[n][n3] = n5;
            if (n2 == n4) {
                switch (this.c1107[n][n5]) {
                    case 0:
                    case 4: {
                        this.c1107[n][n3] = 6;
                        break;
                    }
                }
            }
        }
    }
    
    private void j(final int n, final int n2, final int n3) {
        final int n4 = 3;
        final int n5 = n3 >> 1;
        final int length = this.a1052[n5].length;
        if (a(n3)) {
            this.q(this.bb, 18, 293);
            this.a1002.drawImage(this.a1013[n4][28], 0, 299, 0);
        }
        else {
            for (int i = 0; i < length; ++i) {
                this.c(this.a1013[n4][14], i * 12 + n, n2, this.a1052[n5][i]);
            }
        }
    }
    
    private boolean j(final int n) {
        boolean b;
        if (n > this.bz) {
            b = false;
        }
        else {
            this.bz -= n;
            b = true;
        }
        return b;
    }
    
    private boolean j(final int n, final int n2) {
        final boolean b = true;
        if (this.X == (b ? 1 : 0)) {
            switch (n) {
                case 8:
                case 9: {
                    if (g(n2)) {
                        return b;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private void k() {
        this.e(0);
        (this.a1012 = new Random()).setSeed(System.currentTimeMillis());
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
    
    private void k(final int n) {
        final int aw = 2;
        final boolean o = true;
        if (this.bt > 0) {
            if (!this.a1056[n]) {
                if (this.j((int)this.g1057[n])) {
                    this.a1056[n] = o;
                    this.b1059[this.h1060[n]] = o;
                    for (int i = 0; i < aw; ++i) {
                        this.e1105[this.g1065[n][i]] = o;
                    }
                    this.u(this.h1060[n]);
                    this.aw = aw;
                }
                else {
                    this.o = 0;
                }
            }
            else {
                this.o = 3;
            }
        }
        else {
            this.o = (o ? 1 : 0);
        }
    }
    
    private void k(final int n, final int n2) {
        final int n3 = 4;
        for (int i = 0; i < n3; ++i) {
            this.p(this.w1110[i << 1] + n, this.w1110[(i << 1) + 1] + n2, this.bu);
        }
        if (this.bu > 1) {
            this.b(this.a1013[3][21], n - this.bP, n2 + 13 - this.bQ - (this.bu << 1), n3);
        }
    }
    
    private void k(final int n, final int n2, final int n3) {
        this.a(this.a1013[3][22], n + this.e1054[this.f1055[n3] * 3 + 2], n2, this.e1054[this.f1055[n3] * 3], 0, this.e1054[this.f1055[n3] * 3 + 1], 15, 0, 0);
    }
    
    private boolean k(final int n, final int n2) {
        final boolean b = true;
        if (this.X == (b ? 1 : 0)) {
            switch (n) {
                case 10: {
                    if (g(n2)) {
                        return b;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private void l() {
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(16777215);
        this.a1002.fillRect(0, 0, 240, 320);
        this.e(this.t, 240);
        if (this.M != 0) {
            this.d(0);
            if (this.M >= 2) {
                this.a1002.drawImage(this.a1013[0][4], this.y, this.z, 0);
            }
            for (int i = 0; i < 3; ++i) {
                this.d(this.w + i * 176, this.x);
            }
            if (this.M >= 3) {
                if (this.h) {
                    this.a1002.drawImage(this.a1013[0][5], this.G, this.H, 0);
                }
                if (this.j1024) {
                    this.a(this.a1013[0][0], this.A, this.B, 0);
                    this.a(this.a1013[0][1], this.C, this.D, 0);
                }
                if (this.g) {
                    this.a(this.a1013[0][2], this.E, this.F, (this.R - 1) * (this.a1013[0][2].getWidth() >> 1), 0, this.a1013[0][2].getWidth() >> 1, this.a1013[0][2].getHeight(), 0, 0);
                }
                if (this.f1023) {
                    final int n = this.A + 16;
                    final int n2 = this.B + this.a1013[0][0].getHeight() - 14;
                    for (int j = 0; j < this.S; ++j) {
                        this.a1002.drawImage(this.a1013[0][j + 9], n, n2, 0);
                    }
                    if (this.d1021) {
                        this.a(this.a1013[0][7], this.a1013[0][11].getWidth() + n - 6, n2 + 4, (this.P - 1) * (this.a1013[0][7].getWidth() / 3), 0, this.a1013[0][7].getWidth() / 3, this.a1013[0][7].getHeight(), 0, 0);
                    }
                    if (this.e1022) {
                        this.a(this.a1013[0][8], n - 15, n2 + this.a1013[0][11].getHeight(), (this.Q - 1) * (this.a1013[0][8].getWidth() / 3), 0, this.a1013[0][8].getWidth() / 3, this.a1013[0][8].getHeight(), 0, 0);
                    }
                }
                if (this.i) {
                    this.a1002.drawImage(this.a1013[0][6], this.I, this.J, 0);
                }
            }
            if (this.M == 5) {
                this.a1002.drawImage(this.a1013[0][3], 0, this.L, 0);
                this.a(this.a1013[0][3], 240 - this.a1013[0][3].getWidth(), this.L, 1);
                this.c(this.r, this.K, this.L + 1);
                this.d(this.K - 20, this.K + this.a1013[4][25].getWidth() + 20 - this.a1013[3][24].getWidth(), this.L + 1);
                this.a(this.a1013[3][2], 1, this.L + 3, 0, 20, 18, 10, 0, 0);
            }
        }
    }
    
    private final void l(final int n) {
        final int n2 = 8;
        final int n3 = 6;
        final int ar = 2;
        final int o1077 = 1;
        if (this.aT < this.aX && this.b((int)this.b1069[this.aN][0], this.b1069[this.aN][o1077] + 13) && (this.aR -= o1077) < 0) {
            if (this.o1077 && this.aP == 0) {
                this.ab();
                this.o1077 = (o1077 != 0);
            }
            else {
                this.o1077 = false;
            }
            for (int i = this.aP; i < this.aP + n; ++i) {
                this.b1066[i][0] = this.b1069[this.aN][0];
                this.b1066[i][o1077] = this.b1069[this.aN][o1077];
                final int[] array = this.b1066[i];
                int aw;
                if (this.o1077) {
                    aw = this.aW * 10;
                }
                else {
                    aw = this.aW;
                }
                array[ar] = aw;
                this.b1066[i][3] = this.aY;
                this.b1066[i][4] = this.aZ;
                this.b1066[i][5] = this.c(this.b1066[i][0], this.b1066[i][o1077]);
                final int[] array2 = this.b1066[i];
                int n4;
                if (this.o1077) {
                    n4 = (this.aV << 1) + 1;
                }
                else {
                    n4 = this.aV << 1;
                }
                array2[n3] = n4;
                this.b1066[i][7] = 0;
                this.b1066[i][n2] = 0;
                this.b1066[i][9] = 0;
                this.b1066[i][24] = this.aQ;
                this.b1066[i][10] = -1;
                this.b1066[i][11] = 0;
                this.b1066[i][12] = 0;
                this.b1066[i][13] = 0;
                this.b1066[i][14] = 0;
                this.b1066[i][15] = 0;
                this.b1066[i][25] = 0;
                this.b1066[i][23] = 0;
                this.b1066[i][26] = this.ba;
                this.b1066[i][27] = 0;
                if (this.ba == n3 || this.ba == n2) {
                    this.b1066[i][27] = -2;
                }
                this.a(this.b1066[i][0], this.b1066[i][o1077], (boolean)(o1077 != 0));
            }
            ++this.aP;
            ++this.aQ;
            ++this.aT;
            this.aR = ar;
        }
    }
    
    private void l(final int n, final int n2) {
        final int[] array = this.c1107[n];
        final int n3 = 6;
        --array[n3];
        this.A(n);
    }
    
    private void l(final int n, final int n2, final int n3) {
        this.a(this.a1013[30][0], n2, n3, this.e1058[n][0], this.e1058[n][1], this.e1058[n][2], this.e1058[n][3], 0, 0);
    }
    
    private boolean l(final int n, final int n2) {
        if (this.X == 0) {
            switch (n) {
                case 2:
                case 6:
                case 10: {
                    if (g(n2)) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private void m() {
        final int r = 6;
        final int n = 2;
        final int m = 4;
        final int k1029 = 1;
        Label_0056: {
            switch (this.M) {
                case 0: {
                    this.S = 0;
                    this.N = 0;
                    this.v = -26;
                    this.x = 416;
                    this.M = k1029;
                    break;
                }
                case 1: {
                    this.n();
                    final int n2 = this.N + 1;
                    this.N = n2;
                    if (n2 > 20) {
                        this.N = 0;
                        this.y = 240 - this.a1013[0][m].getWidth() >> 1;
                        this.z = this.a1013[0][m].getHeight() + 320;
                        this.O = (320 - this.a1013[0][m].getHeight() >> 1) - 10;
                        this.M = n;
                        break;
                    }
                    break;
                }
                case 2: {
                    this.n();
                    final int z = this.z - 60;
                    this.z = z;
                    if (z < this.O) {
                        this.z = this.O;
                        this.N = 0;
                        this.U = 0;
                        this.e1025 = this.y + this.a1013[0][m].getWidth() - 20;
                        this.f1026 = this.e1025 + this.a1013[0][0].getWidth() - m;
                        this.A = this.e1025 + this.a1027[0];
                        this.C = this.f1026 - this.a1027[0];
                        this.B = this.O + 12;
                        this.D = this.B + 8;
                        this.E = this.f1026;
                        this.F = this.B + this.a1013[0][0].getHeight();
                        this.G = this.f1026;
                        this.M = m;
                        break;
                    }
                    break;
                }
                case 4: {
                    this.n();
                    this.o();
                    if (this.N > n) {
                        this.j1024 = (k1029 != 0);
                        this.N = 0;
                        this.M = 3;
                    }
                    ++this.N;
                    break;
                }
                case 3: {
                    this.n();
                    this.o();
                    final int length = this.a1027.length;
                    if (this.N < length) {
                        this.A = this.e1025 + this.a1027[this.N];
                        this.C = this.f1026 - this.a1027[this.N];
                    }
                    else if (this.N == length + 2) {
                        this.H = 0 - this.a1013[0][5].getHeight();
                        this.h = (k1029 != 0);
                    }
                    else if (this.N > length + 2) {
                        if (this.N == length + 3) {
                            this.H += this.a1013[0][5].getHeight() >> 1;
                        }
                        else if (this.N == length + 4) {
                            this.H = this.O - 10;
                        }
                        else if (this.N == length + 5) {
                            this.H = this.O - r;
                            this.f1023 = (k1029 != 0);
                        }
                    }
                    if (this.f1023) {
                        if (this.S == k1029) {
                            this.d1021 = (k1029 != 0);
                        }
                        else if (this.S == n) {
                            this.e1022 = (k1029 != 0);
                            this.g = (k1029 != 0);
                        }
                        if (this.S < 3) {
                            ++this.S;
                        }
                    }
                    if (this.d1021 && ++this.P > m) {
                        this.d1021 = false;
                    }
                    if (this.e1022 && ++this.Q > m) {
                        this.e1022 = false;
                        this.i = (k1029 != 0);
                        this.I = -this.a1013[0][r].getWidth();
                        this.J = 320 - this.a1013[0][r].getHeight() >> 1;
                    }
                    if (this.g && this.R < n) {
                        ++this.R;
                    }
                    if (this.i && (this.I += 8) > this.y - this.a1013[0][r].getWidth() - 15) {
                        this.I = this.y - this.a1013[0][r].getWidth() - 15;
                    }
                    ++this.N;
                    if (this.N > 25) {
                        this.N = 0;
                        this.L = 320;
                        this.K = 240 - this.a1013[m][25].getWidth() >> 1;
                        this.M = 5;
                        break;
                    }
                    break;
                }
                case 5: {
                    this.n();
                    this.o();
                    final int l = this.L - n;
                    this.L = l;
                    if (l < 320 - this.a1013[0][3].getHeight()) {
                        this.L = 320 - this.a1013[0][3].getHeight();
                    }
                    switch (this.h1047) {
                        default: {
                            break Label_0056;
                        }
                        case -6:
                        case -5:
                        case 53: {
                            switch (this.r) {
                                default: {
                                    break Label_0056;
                                }
                                case 0: {
                                    this.h(7);
                                    this.T = 0;
                                    this.t1089 = false;
                                    this.af = k1029;
                                    this.c = 0;
                                    this.X = 0;
                                    this.aO = 0;
                                    this.aN = 0;
                                    this.v1097 = (k1029 != 0);
                                    this.bF = 0;
                                    this.ay = -1;
                                    this.az = -1;
                                    this.aw = 0;
                                    this.k1029 = false;
                                    this.l = 15;
                                    break Label_0056;
                                }
                                case 1: {
                                    this.h(7);
                                    this.t1089 = false;
                                    this.X = 0;
                                    this.af = 0;
                                    this.T = k1029;
                                    this.aO = 0;
                                    this.aN = 0;
                                    this.bF = 0;
                                    this.ay = -1;
                                    this.az = -1;
                                    this.aw = 0;
                                    this.k1029 = (k1029 != 0);
                                    this.v1097 = false;
                                    this.l = 15;
                                    break Label_0056;
                                }
                                case 2: {
                                    if (!this.A1170) {
                                        this.F(r);
                                        break Label_0056;
                                    }
                                    this.A1170 = false;
                                    this.h(7);
                                    this.y1155 = false;
                                    this.bF = 0;
                                    this.aw = 0;
                                    this.a();
                                    this.Q();
                                    this.v1097 = false;
                                    if (this.T == 0) {
                                        this.k1029 = false;
                                    }
                                    else {
                                        this.k1029 = (k1029 != 0);
                                    }
                                    this.l = n;
                                    if (this.aq >= 8 && this.aP != 0) {
                                        this.g(this.aq, -1);
                                        break Label_0056;
                                    }
                                    break Label_0056;
                                }
                                case 3: {
                                    this.h(7);
                                    this.a(8);
                                    break Label_0056;
                                }
                                case 4: {
                                    this.h(7);
                                    this.a(21);
                                    this.c = 0;
                                    break Label_0056;
                                }
                                case 5: {
                                    this.h(7);
                                    this.a(20);
                                    this.c = 0;
                                    break Label_0056;
                                }
                                case 6: {
                                    this.h(7);
                                    this.c(k1029);
                                    this.l = 19;
                                    break Label_0056;
                                }
                            }
                            break;
                        }
                        case -3:
                        case 52: {
                            final int r2 = this.r - k1029;
                            this.r = r2;
                            if (r2 < 0) {
                                this.r = r;
                                break Label_0056;
                            }
                            if (this.r == n && !this.a()) {
                                this.r -= k1029;
                                break Label_0056;
                            }
                            break Label_0056;
                        }
                        case -4:
                        case 54: {
                            final int r3 = this.r + 1;
                            this.r = r3;
                            if (r3 > r) {
                                this.r = 0;
                                break Label_0056;
                            }
                            if (this.r == n && !this.a()) {
                                ++this.r;
                                break Label_0056;
                            }
                            break Label_0056;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    private void m(final int n) {
        final byte b = 6;
        final byte b2 = 1;
        if (this.D1162[n] > b) {
            final byte[] d1162 = this.D1162;
            d1162[n] -= b2;
        }
        else if (this.D1162[n] == b) {
            this.D1162[n] = b2;
        }
    }
    
    private void m(final int n, final int n2) {
        final boolean x1126 = true;
        this.x1126 = x1126;
        for (int i = 0; i < this.o1098[this.bw]; ++i) {
            for (int j = 0; j < this.o1098[this.bw]; ++j) {
                if (this.e((i << 4) + n, (j << 4) + n2)) {
                    this.a1127[i][j] = x1126;
                }
                else {
                    this.a1127[i][j] = false;
                    this.x1126 = false;
                }
            }
        }
    }
    
    private void m(final int n, final int n2, final int n3) {
        for (int i = 0; i < this.j1064[n3]; ++i) {
            if (this.b1059[this.f1063[n3][i * 3]] || n3 != 0) {
                this.l(this.f1063[n3][i * 3], this.f1063[n3][i * 3 + 1] + n - this.bP, this.f1063[n3][i * 3 + 2] + n2 + 13 - this.bQ);
            }
        }
        if (n3 == 0) {
            for (int j = 0; j < this.j1064[n3]; ++j) {
                if (this.w1111 && this.f1063[n3][j * 3] == this.bv) {
                    this.k(this.f1063[n3][j * 3 + 1] + n + (this.e1058[this.bv][2] >> 1), this.f1063[n3][j * 3 + 2] + n2 + (this.e1058[this.bv][3] >> 1));
                }
            }
        }
    }
    
    private boolean m(final int n, final int n2) {
        if (this.X == 0) {
            switch (n) {
                case 8:
                case 9: {
                    if (g(n2)) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private void n() {
        final int x = 300;
        final int n = 4;
        final int n2 = 2;
        final int n3 = -176;
        final int u = this.u - n2;
        this.u = u;
        if (u < n3) {
            this.u = 0;
        }
        if ((this.w -= n2) < n3) {
            this.w = 0;
        }
        if ((this.v += 4) > 0) {
            this.v = 0;
        }
        if ((this.x -= 16) < x) {
            this.x = x;
        }
        if (--this.t < -this.a1013[n][n].getWidth() * 5) {
            this.t = 0;
        }
    }
    
    private final void n(final int n) {
        final int n2 = 7;
        final int[] array = this.b1066[n];
        final int n3 = array[n2] + 1;
        array[n2] = n3;
        if (n3 > this.l1083[this.b1066[n][6] >> 1].length - 1) {
            this.b1066[n][n2] = 0;
        }
    }
    
    private void n(final int n, final int n2) {
        final int n3 = 1;
        for (int i = 0; i < this.bt; ++i) {
            final int[] array = this.c1107[i];
            final int n4 = this.o1098[array[2]] << 3;
            if (this.a(array[0] + n4, array[n3] + n4, n, n2, this.a(7, this.s1102, 6))) {
                array[17] = n3;
            }
        }
    }
    
    private void n(final int n, final int n2, final int n3) {
        final int n4 = 16422227;
        final int n5 = 16382577;
        final int n6 = 20;
        final int n7 = 1;
        if (n3 < this.v1109.length && n3 > 0) {
            for (int i = 0; i < 7; ++i) {
                this.g(n + this.p1108[n3 - n7][i << 1], this.p1108[n3 - n7][(i << 1) + 1] + n2 + 13, this.v1109[n3 - n7] << 1, n4, n5);
            }
        }
        else if (n3 == 0) {
            this.g(n - n6, n2 - n6 + 13, 40, n4, n5);
        }
    }
    
    private boolean n(final int n, final int n2) {
        if (this.X == 2) {
            switch (n) {
                case 2:
                case 6: {
                    if (g(n2)) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private void o() {
        final int u = 1;
        switch (this.U) {
            case 0: {
                final int z = this.z + 1;
                this.z = z;
                if (z > this.O + 5) {
                    this.U = u;
                    break;
                }
                break;
            }
            case 1: {
                final int z2 = this.z - u;
                this.z = z2;
                if (z2 < this.O) {
                    this.U = 0;
                    break;
                }
                break;
            }
        }
    }
    
    private void o(final int n) {
        final int n2 = 5;
        final int n3 = 1;
        final int[] array = this.b1066[n];
        if ((array[0] & 0x7) == 0x0 && (array[0] & 0xF) != 0x0 && (array[n3] & 0x7) == 0x0 && (array[n3] & 0xF) != 0x0) {
            if (!this.d(array[0] + (this.k1081[array[n2]][0] << 4), array[n3] + (this.k1081[array[n2]][n3] << 4))) {
                array[n2] = this.b(array[0], array[n3], array[n2]);
            }
            else {
                array[n2] = this.c(array[0], array[n3]);
            }
        }
    }
    
    private void o(final int n, final int n2) {
        for (int i = 0; i < 5; ++i) {
            final int n3 = (int)(this.a1019 + i & (long)3);
            final Image image = this.a1013[31][8];
            final int n4 = this.B1133[i][0] + n;
            int n5;
            if (n3 == 0) {
                n5 = 4;
            }
            else {
                n5 = 0;
            }
            this.a(image, n4 + n5, this.B1133[i][1] + n2, n3 * 3, 0, 3, 17, 0, 0);
        }
    }
    
    private void o(final int n, final int n2, final int n3) {
        final int n4 = 1;
        this.a(this.a1013[38][this.aM], n + this.o1095[this.ba - n4][3], n2 + this.o1095[this.ba - n4][4], n3 * this.o1095[this.ba - n4][0], 0, this.o1095[this.ba - n4][0], this.o1095[this.ba - n4][n4], 0, 0);
    }
    
    private boolean o(final int n, final int n2) {
        if (this.X == 2) {
            switch (n) {
                case 10: {
                    if (g(n2)) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private void p() {
        final int n = 320;
        final int n2 = 240;
        final int n3 = 3;
        this.a1002.setClip(0, 0, n2, n);
        this.a1002.setColor(16580557);
        this.a1002.fillRect(0, 0, n2, n);
        this.a(this.a1013[n3][n3], 0, 0, 13450878, true);
    }
    
    private void p(final int n) {
        final int n2 = 1;
        final int[] array = this.b1066[n];
        final int[] array2 = this.b1066[this.aP - n2];
        this.a(array[0], array[n2], false);
        for (int i = 0; i < 28; ++i) {
            if (i != 24) {
                array[i] = array2[i];
            }
        }
        this.aP -= n2;
        if (this.aT == this.aX && this.aP == 0) {
            this.h(this.aq);
        }
    }
    
    private void p(final int n, final int n2) {
        final int n3 = 14;
        for (int i = 0; i < this.o1098[this.bw]; ++i) {
            for (int j = 0; j < this.o1098[this.bw]; ++j) {
                final int n4 = (i << 4) + n;
                final int n5 = n2 + (j << 4);
                this.b(n4 + 1 - this.bP, n5 + 1 - this.bQ + 13, n3, n3, this.e(n4, n5));
            }
        }
        this.q(n, n2);
    }
    
    private void p(final int n, final int n2, final int n3) {
        final int n4 = 20;
        final int n5 = 3;
        this.a1013[n5][n4].getWidth();
        final int height = this.a1013[n5][n4].getHeight();
        final Image image = this.a1013[n5][n4];
        int n6;
        if (n3 == 0) {
            n6 = 0;
        }
        else {
            n6 = 4;
        }
        this.a(image, n - n6 - this.bP, n2 - this.bQ, n3 * 27, 0, 27, height, 0, 0);
    }
    
    private boolean p(final int n, final int n2) {
        if (this.X == 2) {
            switch (n) {
                case 8:
                case 9: {
                    if (g(n2)) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private void q() {
        this.b(this.V, 13);
        this.a(this.a1013[3][3], 0, 0, 13450878, true);
        this.a1002.setClip(0, 13, 240, this.W);
        final int n = 240 - this.a1013[4][7].getWidth() >> 1;
        final int n2 = (this.W - this.a1013[4][7].getHeight() >> 1) + 13;
        this.a1002.drawImage(this.a1013[4][7], n, n2, 0);
        final int n3 = this.a1013[4][10].getWidth() / 3;
        for (int i = 0; i < 3; ++i) {
            Image image;
            if (this.X == i) {
                image = this.a1013[4][10];
            }
            else {
                image = this.a1013[4][11];
            }
            this.a(image, n + this.a1028[i][0], n2 + this.a1028[i][1], n3 * i, 0, n3, this.a1013[4][10].getHeight(), 0, 0);
            if (this.X == i) {
                this.a1002.drawImage(this.a1013[4][13], this.a1028[i][0] + n + (n3 - this.a1013[4][13].getWidth() >> 1), this.a1028[i][1] + n2 + (this.a1013[4][10].getHeight() - this.a1013[4][13].getHeight() >> 1), 0);
            }
        }
        this.a1002.drawImage(this.a1013[4][this.X + 14], n + 176 - this.a1013[4][this.X + 14].getWidth() + 20, 310 - this.V - this.a1013[4][this.X + 14].getHeight(), 0);
        this.a1002.setClip(0, 0, 240, 320);
        final int n4 = this.W + 13;
        this.a(this.a1013[3][6], 0, n4, 12010381, true);
        final int n5 = n4 + this.a1013[3][6].getHeight();
        this.a1002.setColor(15455661);
        this.a1002.fillRect(0, n5, 240, 25);
        final int n6 = 240 - this.a1013[4][8].getWidth() >> 1;
        final int n7 = n5 - (this.a1013[4][8].getHeight() >> 1) - 9;
        this.a1002.drawImage(this.a1013[4][8], n6, n7, 0);
        final int n8 = this.a1013[4][12].getWidth() / 3;
        this.a(this.a1013[4][12], n6 + (this.a1013[4][8].getWidth() - n8 >> 1), (this.a1013[4][8].getHeight() - this.a1013[4][12].getHeight() >> 1) + n7 + 4, n8 * this.X, 0, n8, this.a1013[4][12].getHeight(), 0, 0);
        this.bR = n6 + 4;
        this.bS = this.a1013[4][8].getWidth() + n6 - 4 - this.a1013[3][24].getWidth();
        this.bT = (this.a1013[4][8].getHeight() >> 1) + n7;
        this.d(this.bR, this.bS, this.bT);
        this.c(0, n5 + 25, 240, this.V - 32, 0);
        this.a(0, 10, n5 + 6, 63, this.j + 1, 0);
        this.a1002.setColor(13971834);
        this.a1002.drawString(this.b1015[this.X + 25], 28, n5 + 8, 0);
        this.a(1, 167, n5 + 6, 63, this.j + 1, 1);
        this.a(this.X * 11 + 28, 186, n5 + 8);
        this.a1002.setColor(5271185);
        this.a(this.b1015[this.X + 76], 0, 8, n5 + 35, 224, 50);
        this.c(7, 240 - this.a1013[4][25].getWidth() >> 1, 0);
    }
    
    private void q(final int n) {
        final int[] array = this.b1066[n];
        if (array[10] == 4) {
            this.a(this.a1013[29][22], array[0] - 8 - this.bP, array[1] - 8 - this.bQ + 13, 16, 0, 16, 16, 0, 0);
        }
        else {
            for (int i = 0; i < 7; ++i) {
                this.a(this.a1013[31][0], array[0] + this.e1093[3 - array[10]][i][0] - 16 - this.bP, array[1] + this.e1093[3 - array[10]][i][1] - 16 - this.bQ + 13, (3 - array[10]) * 5, 0, 5, 5, 0, 0);
            }
            this.b(array[16], array[0] - this.bP - 4, array[1] - this.bQ + 13 - 16 + (array[10] << 1));
        }
    }
    
    private void q(final int n, final int n2) {
        final int n3 = 3;
        final int n4 = 1;
        final long n5 = 1L;
        for (int i = 0; i < 4; ++i) {
            if (this.x1126 && (this.p1099[this.bw] == 0 || this.a(n, n2, i))) {
                this.f(this.a1013[n3][16], (this.o1098[this.bw] << 3) + n + this.Q1159[i][0] * ((this.o1098[this.bw] << 3) + 8 + ((int)(this.a1019 & n5) << 1)), (this.o1098[this.bw] << 3) + n2 + this.Q1159[i][n4] * ((this.o1098[this.bw] << 3) + 8 + ((int)(this.a1019 & n5) << 1)), i);
            }
        }
        if (this.l == 14) {
            this.f(this.a1013[n3][17], (this.o1098[this.bw] << 3) + n + this.Q1159[this.aA][0] * ((this.o1098[this.bw] << 3) + 8 + ((int)(this.a1019 & n5) << 1)), (this.o1098[this.bw] << 3) + n2 + this.Q1159[this.aA][n4] * ((this.o1098[this.bw] << 3) + 8 + ((int)(this.a1019 & n5) << 1)), this.aA);
        }
    }
    
    private void q(final int n, final int n2, final int n3) {
        final int n4 = 32;
        this.a(n4, n);
        this.a1002.drawImage(this.a1013[n4][n], n2, n3, 0);
    }
    
    private boolean q(final int n, final int n2) {
        if (this.X == 2) {
            switch (n) {
                case 7: {
                    if (g(n2)) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private void r() {
        final int n = 18;
        final int x = 2;
        final int l = 1;
        final int n2 = 4;
        this.n();
        switch (this.h1047) {
            case -3:
            case 52: {
                final int x2 = this.X + 1;
                this.X = x2;
                if (x2 > x) {
                    this.X = 0;
                    break;
                }
                break;
            }
            case -4:
            case 54: {
                final int x3 = this.X - l;
                this.X = x3;
                if (x3 < 0) {
                    this.X = x;
                    break;
                }
                break;
            }
            case -6:
            case -5:
            case 53: {
                this.l = 17;
                this.ac = 0;
                this.Y = 240 - this.a1013[n2][n].getWidth() >> 1;
                this.Z = 320 - this.V - this.a1013[n2][n].getHeight() >> 1;
                this.aa = -this.a1013[n2][19].getWidth();
                this.ab = 320 - this.V - this.a1013[n2][19].getHeight() >> 1;
                break;
            }
            case -7: {
                this.l = l;
                this.c(0);
                this.g(7, -1);
                break;
            }
        }
    }
    
    private void r(final int n) {
        final int[] array = this.b1066[n];
        if (array[13] > 0) {
            this.a(this.a1013[31][5], array[0] - 8 - this.bP, array[1] - 16 - this.bQ + 13, (array[20] - 1) * 21, 0, 21, 26, 0, 0);
        }
        if (array[15] > 0) {
            this.a(this.a1013[31][7], array[0] - 8 - this.bP, array[1] - 16 - this.bQ + 13, array[22] * 14, 0, 14, 11, 0, 0);
        }
        if (array[14] > 0) {
            this.a(this.a1013[31][4], array[0] - 8 - this.bP, array[1] - 16 - this.bQ + 13, array[21] * 14, 0, 14, 11, 0, 0);
        }
        if (array[11] > 0) {
            this.a(this.a1013[31][6], array[0] - 8 + this.n1094[array[18]][4] - this.bP, array[1] - 16 + this.n1094[array[18]][5] - this.bQ + 13, this.n1094[array[18]][0], this.n1094[array[18]][1], this.n1094[array[18]][2], this.n1094[array[18]][3], 0, 0);
        }
        if (array[12] > 0) {
            this.a(this.a1013[31][3], array[0] - 16 - this.bP, array[1] - 16 - this.bQ + 13, array[19] * 28, 0, 28, 23, 0, 0);
        }
    }
    
    private void r(final int n, final int n2, final int n3) {
        final int n4 = 29;
        this.a1002.drawImage(this.a1013[n4][42], n + 4, n2 - 15, 0);
        if (n3 < 5) {
            this.a(this.a1013[n4][41], n + 2, this.z1148[n3] + (n2 - 18), n3 * 9, 0, 9, 26, 0, 0);
        }
    }
    
    private void s() {
        final int n = 6;
        final int n2 = 4;
        final int n3 = 320;
        final int n4 = 3;
        this.b(this.ad, 13);
        this.a(this.a1013[n4][n4], 0, 0, 13450878, true);
        this.a1002.drawImage(this.a1013[n2][18], this.Y, this.Z, 0);
        this.a1002.drawImage(this.a1013[n2][19], this.aa, this.ab, 0);
        this.a1002.setColor(15455661);
        this.a1002.fillRect(0, n3 - this.ad, 240, this.ad);
        this.a(this.a1013[n4][n], 0, n3 - this.ad, 12010381, true);
        this.c(0, n3 - this.ad + this.a1013[n4][n].getHeight() + 8, 240, this.ad - 32, 0);
        this.e(2, n2, n3 - this.ad + this.a1013[n4][n].getHeight() + 6);
        final int n5 = 240 - this.b1015[this.ac + 79].length() * this.k - 2 >> 1;
        final int n6 = n3 - this.ad - 2;
        this.a(this.b1015[this.ac + 79], n5, n6);
        this.bR = n5 - n2 - this.a1013[n4][24].getWidth();
        this.bS = n5 + this.b1015[this.ac + 79].length() * this.k + 2 + 4;
        this.bT = (this.j + 1 - this.a1013[n4][24].getHeight() >> 1) + n6;
        this.d(this.bR, this.bS, this.bT);
        this.a1002.setColor(5271185);
        this.a(this.b1015[this.ac + 79 + 2], 0, 8, n3 - this.ad + this.a1013[n4][n].getHeight() + 8 + 12, 224, this.ad - 32);
        this.c(9, 240 - this.a1013[n2][25].getWidth() >> 1, 0);
    }
    
    private void s(final int n) {
        final int n2 = 1;
        final int n3 = 27;
        final int n4 = 26;
        final int n5 = 4;
        final int[] array = this.b1066[n];
        if (array[n4] != 0 && array[n3] != -2 && ++array[n3] >= this.o1095[array[n4] - n2][2]) {
            array[n3] = 0;
            if (array[n4] == 8 || array[n4] == 6) {
                array[n3] = -2;
            }
        }
        switch (array[n4]) {
            case 7: {
                if (array[n5] > this.aZ && (array[0] & 0x7) == 0x0 && (array[n2] & 0x7) == 0x0) {
                    array[n5] = this.aZ;
                    break;
                }
                break;
            }
            case 2: {
                if (array[n5] == this.aZ && array[n5] < n5 && (array[0] & 0x7) == 0x0 && (array[n2] & 0x7) == 0x0) {
                    array[n5] <<= 1;
                    break;
                }
                break;
            }
        }
    }
    
    private void s(final int n, final int n2, final int n3) {
        this.t(n, n2, n3);
        this.u(n, n2, n3);
    }
    
    private void t() {
        final int n = 18;
        final int n2 = 240;
        final int n3 = 1;
        final int n4 = 4;
        this.n();
        Label_0052: {
            switch (this.ae) {
                case 0: {
                    switch (this.h1047) {
                        default: {
                            break Label_0052;
                        }
                        case -7: {
                            this.l = 15;
                            break Label_0052;
                        }
                        case -3:
                        case 52: {
                            final int ac = this.ac - n3;
                            this.ac = ac;
                            if (ac < 0) {
                                this.ac = n3;
                                this.aa = 320;
                            }
                            else {
                                this.Y = 320;
                            }
                            this.ae = n3;
                            break Label_0052;
                        }
                        case -4:
                        case 54: {
                            final int ac2 = this.ac + 1;
                            this.ac = ac2;
                            if (ac2 > n3) {
                                this.ac = 0;
                                this.Y = -this.a1013[n4][n].getWidth();
                            }
                            else {
                                this.aa = -this.a1013[n4][19].getWidth();
                            }
                            this.ae = 2;
                            break Label_0052;
                        }
                        case -6:
                        case -5:
                        case 53: {
                            this.l = 16;
                            break Label_0052;
                        }
                    }
                    break;
                }
                case 1: {
                    if (this.ac == 0) {
                        int n5;
                        if ((this.Y -= 20) < n2 - this.a1013[n4][n].getWidth() >> 1) {
                            this.Y = n2 - this.a1013[n4][n].getWidth() >> 1;
                            n5 = n3;
                        }
                        else {
                            n5 = 0;
                        }
                        final int aa = this.aa - 20;
                        this.aa = aa;
                        int n6;
                        if (aa < -this.a1013[n4][19].getWidth()) {
                            this.aa = -this.a1013[n4][19].getWidth();
                            n6 = n3;
                        }
                        else {
                            n6 = 0;
                        }
                        if (n5 != 0 && n6 != 0) {
                            this.ae = 0;
                            break;
                        }
                        break;
                    }
                    else {
                        int n7;
                        if ((this.aa -= 20) < n2 - this.a1013[n4][19].getWidth() >> 1) {
                            this.aa = n2 - this.a1013[n4][19].getWidth() >> 1;
                            n7 = n3;
                        }
                        else {
                            n7 = 0;
                        }
                        final int y = this.Y - 20;
                        this.Y = y;
                        int n8;
                        if (y < -this.a1013[n4][n].getWidth()) {
                            this.Y = -this.a1013[n4][n].getWidth();
                            n8 = n3;
                        }
                        else {
                            n8 = 0;
                        }
                        if (n7 != 0 && n8 != 0) {
                            this.ae = 0;
                            break;
                        }
                        break;
                    }
                    break;
                }
                case 2: {
                    if (this.ac == 0) {
                        int n9;
                        if ((this.Y += 20) > n2 - this.a1013[n4][n].getWidth() >> 1) {
                            this.Y = n2 - this.a1013[n4][n].getWidth() >> 1;
                            n9 = n3;
                        }
                        else {
                            n9 = 0;
                        }
                        final int aa2 = this.aa + 20;
                        this.aa = aa2;
                        int n10;
                        if (aa2 > n2) {
                            this.aa = n2;
                            n10 = n3;
                        }
                        else {
                            n10 = 0;
                        }
                        if (n9 != 0 && n10 != 0) {
                            this.ae = 0;
                            break;
                        }
                        break;
                    }
                    else {
                        int n11;
                        if ((this.aa += 20) > n2 - this.a1013[n4][19].getWidth() >> 1) {
                            this.aa = n2 - this.a1013[n4][19].getWidth() >> 1;
                            n11 = n3;
                        }
                        else {
                            n11 = 0;
                        }
                        final int y2 = this.Y + 20;
                        this.Y = y2;
                        int n12;
                        if (y2 > n2) {
                            this.Y = n2;
                            n12 = n3;
                        }
                        else {
                            n12 = 0;
                        }
                        if (n11 != 0 && n12 != 0) {
                            this.ae = 0;
                            break;
                        }
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private void t(final int n) {
        final int[] array = this.c1107[n];
        final int[] array2 = this.c1107[this.bt - 1];
        this.bz += this.b(n);
        if (array[3] == 6) {
            if (this.q(array[2], array[3])) {
                for (int i = 0; i < this.bt; ++i) {
                    this.c1107[i][17] = 0;
                }
            }
            this.f1106[array[2]] = false;
        }
        array[4] = 0;
        switch (array[2]) {
            case 2:
            case 6:
            case 8:
            case 9:
            case 10: {
                this.a(array[0], array[1], array[5], (byte)0, 0, true);
                break;
            }
        }
        this.c(array[0], array[1], n, array[2], false);
        if (n != this.bt - 1) {
            this.c(array2[0], array2[1], n, array2[2], true);
        }
        for (int j = 0; j < 18; ++j) {
            array[j] = array2[j];
        }
        --this.bt;
    }
    
    private void t(final int n, final int n2, final int n3) {
        final int n4 = 3;
        if (n3 < n4) {
            this.a(this.a1013[29][18], this.N1149[n3][4] + n - this.bP, this.N1149[n3][5] + n2 - this.bQ + 13, this.N1149[n3][0], this.N1149[n3][1], this.N1149[n3][2], this.N1149[n3][n4], 0, 0);
        }
    }
    
    private void u() {
        final int n = 5;
        final int n2 = 2;
        final short n3 = 8;
        final int af = 1;
        this.n();
        switch (this.h1047) {
            case -6:
            case -5:
            case 53: {
                if (this.T == 0) {
                    if (this.aN > 0) {
                        this.F(n);
                        break;
                    }
                    this.ag = 0;
                    final int n4 = this.b1069[this.aN][0] - n3;
                    this.bN = n4;
                    this.bP = n4;
                    final int n5 = this.b1069[this.aN][af] - n3;
                    this.bO = n5;
                    this.bQ = n5;
                    this.P();
                    this.a(n2);
                    break;
                }
                else {
                    if (!this.d1073[this.aN]) {
                        this.F(n);
                        break;
                    }
                    this.ag = 0;
                    final int n6 = this.b1069[this.aN][0] - n3;
                    this.bN = n6;
                    this.bP = n6;
                    final int n7 = this.b1069[this.aN][af] - n3;
                    this.bO = n7;
                    this.bQ = n7;
                    this.P();
                    this.a(n2);
                    break;
                }
                break;
            }
            case -7: {
                if (!this.t1089) {
                    this.aO = 0;
                    this.aN = 0;
                    this.l = 17;
                    break;
                }
                this.aO = 0;
                this.aN = 0;
                this.B();
                break;
            }
        }
        int n8 = 0;
        switch (this.aN) {
            default: {
                n8 = this.z1131[this.aN].length - af;
                break;
            }
            case 2:
            case 3:
            case 4:
            case 5: {
                n8 = (this.z1131[this.aN].length >> 1) - af;
                break;
            }
        }
        Label_0224: {
            if (this.k1029) {
                switch (this.h1047) {
                    case -2:
                    case 56: {
                        final int af2 = this.af + 1;
                        this.af = af2;
                        if (af2 > af) {
                            this.af = 0;
                            break;
                        }
                        break;
                    }
                    case -1:
                    case 50: {
                        final int af3 = this.af - af;
                        this.af = af3;
                        if (af3 < 0) {
                            this.af = af;
                            break;
                        }
                        break;
                    }
                }
                switch (this.af) {
                    case 0: {
                        switch (this.h1047) {
                            default: {
                                break Label_0224;
                            }
                            case -4:
                            case 54: {
                                final int ao = this.aO + 1;
                                this.aO = ao;
                                if (ao > 6) {
                                    this.aO = 0;
                                }
                                this.aN = this.h1074[this.X][this.aO];
                                break Label_0224;
                            }
                            case -3:
                            case 52: {
                                final int ao2 = this.aO - af;
                                this.aO = ao2;
                                if (ao2 < 0) {
                                    this.aO = 6;
                                }
                                this.aN = this.h1074[this.X][this.aO];
                                break Label_0224;
                            }
                        }
                        break;
                    }
                    case 1: {
                        switch (this.h1047) {
                            default: {
                                break Label_0224;
                            }
                            case -4:
                            case 54: {
                                final int ag = this.ag + 1;
                                this.ag = ag;
                                if (ag > n8) {
                                    this.ag = 0;
                                    break Label_0224;
                                }
                                break Label_0224;
                            }
                            case -3:
                            case 52: {
                                final int ag2 = this.ag - af;
                                this.ag = ag2;
                                if (ag2 < 0) {
                                    this.ag = n8;
                                    break Label_0224;
                                }
                                break Label_0224;
                            }
                        }
                        break;
                    }
                }
            }
            else {
                switch (this.h1047) {
                    case -4:
                    case 54: {
                        final int ag3 = this.ag + 1;
                        this.ag = ag3;
                        if (ag3 > n8) {
                            this.ag = 0;
                            break;
                        }
                        break;
                    }
                    case -3:
                    case 52: {
                        final int ag4 = this.ag - af;
                        this.ag = ag4;
                        if (ag4 < 0) {
                            this.ag = n8;
                            break;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    private void u(final int bv) {
        this.bv = bv;
        this.w1111 = true;
        this.bu = 0;
    }
    
    private void u(final int n, final int n2, final int n3) {
        if (n3 < 2) {
            for (int i = 0; i < this.m1150[n3].length; ++i) {
                final Image image = this.a1013[29][17];
                final int n4 = this.m1150[n3][i][4] + n - this.bP;
                final int n5 = this.m1150[n3][i][5] + n2 - this.bQ + 13;
                final byte b = this.m1150[n3][i][0];
                final byte b2 = this.m1150[n3][i][1];
                final byte b3 = this.m1150[n3][i][2];
                final byte b4 = this.m1150[n3][i][3];
                int n6;
                if (i > this.m1150[n3].length - 3) {
                    n6 = 1;
                }
                else {
                    n6 = 0;
                }
                this.a(image, n4, n5, b, b2, b3, b4, n6, 0);
            }
        }
    }
    
    private void v() {
        this.b(this.ai, 13);
        this.a(this.a1013[3][3], 0, 0, 13450878, true);
        this.a1002.setColor(15455661);
        this.a1002.fillRect(0, 320 - this.ai - 10, 240, this.ai);
        this.a1002.setClip(0, 13, 240, this.aj);
        final int n = 240 - this.a1013[4][7].getWidth() >> 1;
        final int n2 = (this.aj - this.a1013[4][7].getHeight() >> 1) + 13;
        this.a1002.drawImage(this.a1013[4][7], n, n2, 0);
        for (int i = 0; i < 9; ++i) {
            this.a(this.a1013[4][20], n + this.b1030[i][0], n2 + this.b1030[i][1], 0, 0, 9, 9, 0, 0);
        }
        if ((int)(this.a1019 & 0x1L) == 0) {
            this.a(this.a1013[4][20], n + this.b1030[this.aN][0], n2 + this.b1030[this.aN][1], 9, 0, 9, 9, 0, 0);
        }
        this.a(this.a1013[3][6], 0, this.aj + 13, 12010381, true);
        this.a1002.setColor(16580557);
        this.a1002.fillRect(200, this.aj + 10, 40, 15);
        this.a(this.a1013[4][24], 240 - (this.a1013[4][24].getWidth() >> 1), this.aj + 10, (this.a1013[4][24].getWidth() >> 1) * this.af, 0, this.a1013[4][24].getWidth() >> 1, this.a1013[4][24].getHeight(), 0, 0);
        final Image image = this.a1013[3][24];
        final int n3 = 200;
        final int n4 = this.aj + 12 + (int)((this.a1019 & 0x1L) << 1);
        int n5;
        if (this.af == 0) {
            n5 = 4;
        }
        else {
            n5 = 6;
        }
        this.a(image, n3, n4, n5);
        final int n6 = 240 - this.b1015[(this.aN << 1) + 83].length() * this.k - 2 >> 1;
        final int n7 = 320 - this.ai - 13 - 2;
        this.a(this.b1015[(this.aN << 1) + 83], n6, n7);
        if (this.k1029) {
            this.d(n6 - 4 - this.a1013[3][24].getWidth(), n6 + this.b1015[(this.aN << 1) + 83].length() * this.k + 2 + 4, (this.j + 1 - this.a1013[3][24].getHeight() >> 1) + n7);
        }
        this.c(0, 320 - this.ah + this.a1013[3][6].getHeight() + 10, 240, this.ah, 0);
        this.e(2, 4, 320 - this.ah + this.a1013[3][6].getHeight() + 6);
        this.a1002.setColor(5271185);
        this.a(this.b1015[(this.aN << 1) + 83 + 1], 0, 8, 320 - this.ah + this.a1013[3][6].getHeight() + 8 + 12, 224, this.ah - 32);
        this.c(8, 240 - this.a1013[4][25].getWidth() >> 1, 0);
        this.f(this.aN, 240 - this.a1013[4][21].getWidth() / 9 - (this.a1013[4][23].getWidth() << 2) - 10 >> 1, n7 + 20);
    }
    
    private void v(final int n) {
        final int n2 = 1;
        final int[] array = this.c1107[n];
        array[9] = 0;
        array[4] = (array[10] = n2);
        this.w(n);
    }
    
    private void v(final int n, final int n2, final int n3) {
        final int[] array = this.b1066[n];
        final int[] array2 = this.c1107[n3];
        if (array[2] > 0) {
            Label_0080: {
                switch (array2[2]) {
                    case 4: {
                        int n4;
                        if (this.X == 2) {
                            n4 = 0;
                        }
                        else {
                            n4 = this.A1151[array2[3]];
                        }
                        if (this.h(n4)) {
                            if (g(array2[3])) {
                                switch (this.X) {
                                    case 1: {
                                        for (int i = 0; i < this.aP; ++i) {
                                            if (a(this.b1066[i][0], this.b1066[i][1], array[0] - 24, array[0] - 24, 48, 48)) {
                                                this.b1066[i][12] = 48;
                                            }
                                        }
                                        break;
                                    }
                                    case 0: {
                                        array[12] = 96;
                                        break;
                                    }
                                    case 2: {
                                        array[12] = 48;
                                        break;
                                    }
                                }
                            }
                            else {
                                array[12] = 48;
                            }
                        }
                        array[19] = 0;
                        break;
                    }
                    case 5: {
                        int n5;
                        if (this.X == 2) {
                            n5 = 0;
                        }
                        else {
                            n5 = 3;
                        }
                        if (this.h(n5)) {
                            if (g(array2[3])) {
                                switch (this.X) {
                                    case 1: {
                                        for (int j = 0; j < this.aP; ++j) {
                                            if (a(this.b1066[j][0], this.b1066[j][1], array[0] - 24, array[0] - 24, 48, 48)) {
                                                this.b1066[j][13] = 48;
                                            }
                                        }
                                        break;
                                    }
                                    case 0: {
                                        array[13] = 96;
                                        break;
                                    }
                                    case 2: {
                                        array[13] = 48;
                                        break;
                                    }
                                }
                            }
                            else {
                                array[13] = 48;
                            }
                        }
                        array[20] = (array[11] = 0);
                        break;
                    }
                    case 1: {
                        if (array2[3] >= array[23] - 1) {
                            array[23] = array2[3] + 1;
                            if (g(array2[3])) {
                                switch (this.X) {
                                    case 0: {
                                        if (array[26] != 7) {
                                            array[15] = 48;
                                            array[22] = 0;
                                        }
                                        array[14] = 48;
                                        break;
                                    }
                                    case 2: {
                                        array[14] = 96;
                                        break;
                                    }
                                    case 1: {
                                        array[14] = 48;
                                        break;
                                    }
                                }
                            }
                            else {
                                array[14] = 48;
                            }
                        }
                        array[21] = 0;
                        break;
                    }
                    case 3: {
                        if (g(array2[3])) {
                            switch (this.X) {
                                case 2: {
                                    array[11] = 96;
                                    break;
                                }
                                case 0:
                                case 1: {
                                    array[11] = 48;
                                    break;
                                }
                            }
                        }
                        else {
                            array[11] = 48;
                        }
                        array[18] = (array[13] = 0);
                        break;
                    }
                    case 7: {
                        if (!g(array2[3])) {
                            break;
                        }
                        switch (this.X) {
                            default: {
                                break Label_0080;
                            }
                            case 0: {
                                if (array[26] != 7) {
                                    array[15] = 48;
                                    array[22] = 0;
                                    break Label_0080;
                                }
                                break Label_0080;
                            }
                        }
                        break;
                    }
                }
            }
            int n6;
            if (array2[17] == 1) {
                n6 = n2 + 10;
            }
            else {
                n6 = n2;
            }
            if (this.l(array2[2], array2[3])) {
                array[16] = n6;
                final int n7 = 2;
                array[n7] -= n6;
            }
            else if (array[3] < n6) {
                array[16] = n6 - array[3];
                final int n8 = 2;
                array[n8] -= n6 - array[3];
            }
            else {
                array[16] = 1;
                final int n9 = 2;
                --array[n9];
            }
            if (array[10] == -1) {
                array[10] = 4;
            }
            if (this.aV == 4 && array[12] == 0 && array[13] == 0) {
                array[25] = (array[11] = 0);
            }
        }
    }
    
    private final void w() {
        final int n = 1;
        final int n2 = 320;
        final int n3 = 240;
        final int n4 = 2;
        this.c(n4);
        final int width = this.a1013[n4][0].getWidth();
        final int height = this.a1013[n4][0].getHeight();
        final int width2 = this.a1013[n4][n].getWidth();
        final int height2 = this.a1013[n4][n].getHeight();
        final int n5 = n3 - width >> 1;
        final int n6 = n2 - height >> 1;
        final int n7 = n3 - width2 >> 1;
        final int n8 = n2 - height2 >> 1;
        this.a1002.setClip(0, 0, n3, n2);
        this.a1002.setColor(16777215);
        this.a1002.fillRect(0, 0, n3, n2);
        this.a1002.drawImage(this.a1013[n4][0], n5, n6, 0);
        this.a1002.setClip(n7, n8, width2, (height2 + 2) * this.am / 100);
        this.a1002.drawImage(this.a1013[n4][n], n7, n8, 0);
    }
    
    private void w(final int n) {
        final int n2 = 9;
        final byte b = 5;
        final int n3 = 2;
        final int n4 = 1;
        final int[] array = this.c1107[n];
        final int[] array2 = this.b1066[array[8]];
        switch (array[n3]) {
            case 0:
            case 4: {
                for (byte b2 = 0; b2 < b; ++b2) {
                    this.C1134[n][b2] = b2;
                }
                final int n5 = array[0] + (this.o1098[array[n3]] << 3);
                final int n6 = array[n4] + (this.o1098[array[n3]] << 3);
                array[n2] = this.a(n5, n6, array2[0], array2[n4]);
                array[b] = c(array[n2]);
                int n7;
                if (array[n3] == 0) {
                    n7 = 0;
                }
                else {
                    n7 = n4;
                }
                final byte b3 = this.j1139[n7][array[b]][0];
                final byte[][] array3 = this.j1139[n7];
                int n8;
                if (array[3] > b) {
                    n8 = b;
                }
                else {
                    n8 = array[3];
                }
                final int n9 = array3[(n8 >> 1) + 4][0] + b3;
                array[11] = (array2[0] - (n5 + n9)) / 5;
                array[12] = (array2[n4] - (n6 + n9)) / 5;
                break;
            }
            case 1: {
                array[11] = array2[0] - (array[0] + (this.o1098[array[n3]] << 3)) >> 2;
                array[12] = array2[n4] - (array[n4] + (this.o1098[array[n3]] << 3)) >> 2;
                array[n2] = this.a(array[0] + (this.o1098[array[n3]] << 3), array[n4] + (this.o1098[array[n3]] << 3), array2[0], array2[n4]);
                array[b] = c(array[n2]);
                break;
            }
            case 2: {
                array[10] = 0;
                break;
            }
            case 8:
            case 9: {
                array[10] = 0;
                array[11] = this.a() % 3;
                break;
            }
            case 3:
            case 5:
            case 7: {
                array[11] = array2[0] - 8;
                array[12] = array2[n4] - 30;
                array[10] = 0;
                break;
            }
        }
    }
    
    private void w(final int n, final int n2, final int n3) {
        final int n4 = (n2 << 4) - this.bA + this.bB;
        final int n5 = (n << 4) - this.bC + this.bD;
        int n6;
        if (n4 >= 256) {
            n6 = n4 - 256;
        }
        else {
            n6 = n4;
        }
        int n7;
        if (n5 >= 304) {
            n7 = n5 - 304;
        }
        else {
            n7 = n5;
        }
        int n8 = 0;
        if (n3 == 0) {
            int i = 0;
            int n9 = n6;
            while (i < 16) {
                if (i + n2 < this.bG) {
                    final int n10 = this.B1160[this.bG * n + n2 + i] & 0xFF;
                    int n11;
                    if (this.aN != 0) {
                        n11 = (this.F1164[this.bG * n + n2 + i] & 0xFF);
                    }
                    else {
                        n11 = n8;
                    }
                    int n12;
                    if (n9 >= 256) {
                        n12 = n9 - 256;
                    }
                    else {
                        n12 = n9;
                    }
                    this.a(this.a1013[this.bL][0], 1, 16, 16, this.C1161[this.bG * n + n2 + i], n12, n7, n10);
                    if (this.aN != 0 && n11 != 0) {
                        this.a(this.a1013[this.bM][0], 1, 16, 16, this.G1165[this.bG * n + n2 + i], n12, n7, n11);
                    }
                    n8 = n11;
                    n9 = n12;
                }
                final int n13 = i + 1;
                n9 += 16;
                i = n13;
            }
        }
        else {
            int j = 0;
            int n14 = n7;
            while (j < 19) {
                if (j + n < this.bH) {
                    final int n15 = this.B1160[(n + j) * this.bG + n2] & 0xFF;
                    int n16;
                    if (this.aN != 0) {
                        n16 = (this.F1164[(n + j) * this.bG + n2] & 0xFF);
                    }
                    else {
                        n16 = n8;
                    }
                    int n17;
                    if (n14 >= 304) {
                        n17 = n14 - 304;
                    }
                    else {
                        n17 = n14;
                    }
                    this.a(this.a1013[this.bL][0], 1, 16, 16, this.C1161[(n + j) * this.bG + n2], n6, n17, n15);
                    if (this.aN != 0 && n16 != 0) {
                        this.a(this.a1013[this.bM][0], 1, 16, 16, this.G1165[(n + j) * this.bG + n2], n6, n17, n16);
                    }
                    n8 = n16;
                    n14 = n17;
                }
                final int n18 = j + 1;
                n14 += 16;
                j = n18;
            }
        }
    }
    
    private void x() {
        final int n = 320;
        final int n2 = 2;
        final int n3 = 1;
        this.c(n3);
        final int n4 = this.b1034[0] + this.b1034[n3] + this.b1034[n2];
        this.an = Math.min(15, Math.abs(n - n4 >> 2));
        final int n5 = n - n4 - (this.an << 1) >> 1;
        this.g1035[0] = (this.b1034[0] >> 1) + n5;
        this.g1035[n3] = n5 + this.b1034[0] + this.an;
        this.g1035[n2] = this.g1035[n3] + this.b1034[n3] + this.an;
        this.ao = 240 - this.a1013[n3][7].getWidth() >> 1;
    }
    
    private void x(final int n) {
        final int[] array = this.c1107[n];
        array[4] = 2;
        array[10] = 3;
        array[13] = (array[9] = 0);
    }
    
    private void y() {
        final int n = 320;
        final int n2 = 3;
        final int n3 = 6;
        final int n4 = 2;
        this.a1002.setColor(16777215);
        this.a1002.fillRect(0, 0, 240, n);
        for (int i = 0; i < this.a1038; ++i) {
            final int[] array = this.a1039[i];
            int n5 = array[0];
            final int n6 = array[1];
            if (array[n4] == n2 || array[n4] == 4) {
                n5 -= this.c1037[array[n3] << 1];
                this.a1002.setClip(this.c1037[array[n3] << 1] + n5, n6, (int)this.c1037[(array[n3] << 1) + 1], n);
                this.a1002.drawImage(this.a1013[1][7], n5, n6, 0);
            }
            else if (array[n4] == n4) {
                int n7 = array[n2] - array[4];
                if (array[5] == 1) {
                    n7 = array[n2] - n7 - n4;
                }
                n5 -= array[n3] * n7;
                this.a1002.setClip(n7 * array[n3] + n5, n6, array[n3], n);
            }
            if (array[n4] != n2 && array[n4] != 4) {
                this.a1002.drawImage(this.a1040[i], n5, n6, 0);
            }
            this.a1002.setClip(0, 0, 240, n);
        }
    }
    
    private void y(final int n) {
        final int[] array = this.c1107[n];
        final int n2 = array[0] + (this.o1098[array[2]] << 3);
        final int n3 = array[1] + (this.o1098[array[2]] << 3);
        switch (array[2]) {
            case 0: {
                if (array[13] < 3) {
                    this.a(this.a1013[29][2], this.a1013[29][1], n, this.D1135[array[13]][2], this.D1135[array[13]][3], this.D1135[array[13]][0], this.D1135[array[13]][1]);
                    break;
                }
                break;
            }
            case 4: {
                if (array[13] < 3) {
                    this.a(this.a1013[29][4], this.a1013[29][3], n, this.D1135[array[13]][2], this.D1135[array[13]][3], this.D1135[array[13]][0], this.D1135[array[13]][1]);
                    break;
                }
                break;
            }
            case 1: {
                final byte b = this.j1139[2][array[5]][0];
                final byte[][] array2 = this.j1139[2];
                int n4;
                if (array[3] > 5) {
                    n4 = 5;
                }
                else {
                    n4 = array[3];
                }
                final int n5 = b + array2[(n4 >> 1) + 4][0];
                final byte b2 = this.j1139[2][array[5]][1];
                final byte[][] array3 = this.j1139[2];
                int n6;
                if (array[3] > 5) {
                    n6 = 5;
                }
                else {
                    n6 = array[3];
                }
                final int n7 = b2 + array3[(n6 >> 1) + 4][1] + 13;
                if (array[13] < 4) {
                    if (array[13] < 3) {
                        this.a(this.a1013[29][5], null, n, this.D1135[array[13]][2], this.D1135[array[13]][3], this.D1135[array[13]][0], this.D1135[array[13]][1]);
                    }
                    for (int i = 0; i < array[13] + 1; ++i) {
                        if (i > 0) {
                            this.a(this.a1013[29][7], n2 + n5 + array[11] * i - this.bP, n3 + n7 + array[12] * i - this.bQ, i * 10, 0, 10, 10, 0, 0);
                        }
                        if (i == array[13]) {
                            this.a(this.a1013[29][6], n2 + n5 + array[11] * i - this.bP, n3 + n7 + array[12] * i - this.bQ, i * 12, 0, 12, 12, 0, 0);
                        }
                    }
                    break;
                }
                this.b(this.a1013[29][8], n, n2 + array[11] * 4, n3 + array[12] * 4, array[13] - 4);
                break;
            }
            case 6: {
                this.f(array[0], array[1], array[5], array[13]);
                break;
            }
            case 3:
            case 5: {
                this.a(array[0], array[1], array[11], array[12], array[3], array[13], array[10], array[2]);
                break;
            }
            case 7: {
                this.b(array[0], array[1], array[11], array[12], array[8], array[13], array[3], array[10]);
                break;
            }
            case 9: {
                if (array[10] == 0) {
                    this.a(this.a1013[29][36], this.a1013[29][37], this.a1013[29][38], array[0], array[1], array[5], array[13]);
                    break;
                }
                if (array[16] == 1) {
                    this.h(array[0], array[1], array[5], array[2], array[3]);
                    break;
                }
                break;
            }
            case 8: {
                if (array[10] == 0) {
                    this.a(this.a1013[29][32], this.a1013[29][33], this.a1013[29][34], array[0], array[1], array[5], array[13]);
                    break;
                }
                break;
            }
            case 2: {
                this.g(array[5], array[0], array[1], array[13]);
                break;
            }
            case 10: {
                if (array[10] == 2) {
                    for (int j = 0; j < this.E1136.length; ++j) {
                        this.a(this.a1013[29][47], this.F1137[array[5]][0] + array[0] + this.E1136[j][0] - this.bP, this.F1137[array[5]][1] + array[1] + this.E1136[j][1] - this.bQ + 13, array[13] * 14, 0, 14, 19, 0, 0);
                    }
                    for (int k = 0; k < this.G1138.length; ++k) {
                        this.p(this.F1137[array[5]][0] + array[0] + this.G1138[k][0], this.F1137[array[5]][1] + array[1] + this.G1138[k][1], array[13]);
                    }
                    break;
                }
                break;
            }
        }
    }
    
    private void z() {
        final int n = 5;
        final int n2 = 3;
        final byte b = 1;
        final int n3 = 4;
        for (int i = this.a1038 - b; i >= 0; --i) {
            final int[] array = this.a1039[i];
            switch (array[2]) {
                case 1: {
                    if (array[n2] > 0) {
                        array[0] += (array[n3] - array[0]) / array[n2];
                        array[b] += (array[n] - array[b]) / array[n2];
                        array[n2] -= b;
                        break;
                    }
                    break;
                }
                case 3: {
                    if (array[n2] > 0) {
                        final int n4 = (array[n3] - array[0]) / array[n2];
                        final int n5 = (array[n] - array[b]) / array[n2];
                        array[0] += n4;
                        array[b] += n5;
                        if ((array[n2] -= b) == 0) {
                            int n6;
                            if (n4 > 0) {
                                n6 = 8;
                            }
                            else if (n4 < 0) {
                                n6 = -8;
                            }
                            else {
                                n6 = 0;
                            }
                            array[n3] = n6;
                            int n7;
                            if (n5 > 0) {
                                n7 = 8;
                            }
                            else if (n5 < 0) {
                                n7 = -8;
                            }
                            else {
                                n7 = 0;
                            }
                            array[n] = n7;
                            break;
                        }
                        break;
                    }
                    else {
                        if (array[n3] == 0) {
                            switch (array[n2]) {
                                case -3:
                                case 0: {
                                    array[0] += array[n3];
                                    array[b] += array[n];
                                    break;
                                }
                                case -2: {
                                    array[n3] >>= 1;
                                    array[n] >>= 1;
                                }
                                case -1: {
                                    array[0] -= array[n3];
                                    array[b] -= array[n];
                                    break;
                                }
                            }
                            array[n2] -= b;
                            break;
                        }
                        break;
                    }
                    break;
                }
                case 2: {
                    if (array[n3] > b) {
                        array[n3] -= b;
                        break;
                    }
                    break;
                }
                case 4: {
                    if (array[n2] <= 0) {
                        break;
                    }
                    switch (array[n]) {
                        case 0: {
                            array[0] -= array[n3];
                            array[b] += array[n3];
                            break;
                        }
                        case 1: {
                            array[0] -= array[n3];
                            array[b] -= array[n3];
                            break;
                        }
                        case 2: {
                            array[0] += array[n3];
                            array[b] -= array[n3];
                            break;
                        }
                        case 3: {
                            array[0] += array[n3];
                            array[b] += array[n3];
                            break;
                        }
                    }
                    final int n8 = array[n] + 1;
                    array[n] = n8;
                    if (n8 >= n3) {
                        array[n] = 0;
                        array[n2] -= b;
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private void z(final int n) {
        final int n2 = 10;
        final int n3 = 13;
        final int n4 = 4;
        final int n5 = 1;
        final int[] array = this.b1066[n];
        if (array[12] > 0) {
            final int n6 = 19;
            if (++array[n6] > 2) {
                array[19] = 0;
            }
            if (array[8] != 7) {
                array[8] = 7;
            }
            final int n7 = 12;
            array[n7] -= n5;
        }
        if (array[15] > 0) {
            final int n8 = 22;
            if (++array[n8] > 2) {
                array[22] = 0;
            }
            if (array[n4] > n5 && (array[0] & 0x7) == 0x0 && (array[n5] & 0x7) == 0x0) {
                array[n4] = this.aZ >> 1;
            }
            final int n9 = 15;
            array[n9] -= n5;
        }
        else if (array[15] == 0 && array[n3] == 0 && (array[0] & 0x7) == 0x0 && (array[n5] & 0x7) == 0x0) {
            array[n4] = this.aZ;
        }
        if (array[14] > 0) {
            final int n10 = 21;
            if (++array[n10] > 2) {
                array[21] = 0;
            }
            if ((array[14] & 0x7) == 0x0) {
                final int n11 = 2;
                array[n11] -= array[23];
                array[16] = array[23];
                if (array[n2] == -1) {
                    array[n2] = n4;
                }
            }
            final int n12 = 14;
            array[n12] -= n5;
        }
        else if (array[14] == 0) {
            array[23] = 0;
        }
        if (array[11] > 0) {
            if ((array[11] & 0x7) == 0x0) {
                int n13 = 8;
                if (this.X == 0 && this.f1106[3]) {
                    n13 = 16;
                }
                final int n14 = 2;
                array[n14] -= n13;
                array[16] = n13;
                if (array[n2] == -1) {
                    array[n2] = n4;
                }
            }
            final int n15 = 18;
            if (++array[n15] > 5) {
                array[18] = 0;
            }
            final int n16 = 11;
            array[n16] -= n5;
        }
        if (array[n3] > 0) {
            if (array[n3] >= 44) {
                if (array[20] < 3) {
                    final int n17 = 20;
                    ++array[n17];
                }
            }
            else if (array[n3] <= n4) {
                if (array[n3] == n4) {
                    final int n18 = 2;
                    array[n18] -= n2;
                    array[16] = n2;
                    if (array[n2] == -1) {
                        array[n2] = n4;
                    }
                }
                if (array[20] > 0) {
                    final int n19 = 20;
                    array[n19] -= n5;
                }
            }
            if (array[8] != 7) {
                array[8] = 7;
            }
            array[n3] -= n5;
        }
        if (array[n3] > 0) {
            if (array[n3] >= 45) {
                if (array[20] < 2) {
                    final int n20 = 20;
                    ++array[n20];
                }
            }
            else if (array[n3] <= 3 && array[20] > 0) {
                final int n21 = 20;
                array[n21] -= n5;
            }
            if (array[n4] > n5 && (array[0] & 0x7) == 0x0 && (array[n5] & 0x7) == 0x0) {
                array[n4] = n5;
            }
            array[n3] -= n5;
        }
        else if (array[n3] == 0 && array[15] == 0 && (array[0] & 0x7) == 0x0 && (array[n5] & 0x7) == 0x0) {
            array[n4] = this.aZ;
        }
    }
    
    public final void hideNotify() {
        if (this.cb == 1500) {
            this.C1175 = true;
        }
        if (this.l != 46 && this.l != 48 && this.l != 47 && (this.l == 2 || this.l == 12 || this.l == 13 || this.l == 22 || this.l == 23)) {
            this.a(3);
            if (this.l1031) {
                this.h(this.aq);
            }
            this.r = 0;
            this.at = 0;
        }
    }
    
    public final void keyPressed(final int n) {
        try {
            if (this.at != 0) {
                return;
            }
            this.g1046 = n;
            try {
                this.h1047 = n;
                this.i1048 = 0;
                if (this.l != 46 || this.h1047 == -5 || this.h1047 == -7) {
                    this.o = -1;
                }
                this.u1096 = false;
                this.ao();
            }
            catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        catch (final Exception ex2) {}
    }
    
    public final void keyReleased(final int n) {
        this.i1048 = -1;
        this.g1046 = 0;
    }
    
    public final void paint(final Graphics a1002) {
        try {
            this.a1002 = a1002;
            final Graphics a1003 = this.a1002;
            try {
                this.a1005 = DirectUtils.getDirectGraphics(a1003);
                final Graphics a1004 = this.a1002;
                try {
                    a1004.setFont(this.a);
                    this.A();
                }
                catch (final Exception ex) {
                    ex.printStackTrace();
                }
            }
            catch (final Exception ex2) {}
        }
        catch (final Exception ex3) {}
    }
    
    public final void run() {
        Label_0034: {
            if (!this.B1171) {
                break Label_0034;
            }
            final int c = this.c();
            synchronized (this.a1172) {
                this.bV = c;
                return;
            }
        }
        this.B1171 = true;
        this.a1172 = new Object();
        while (this.b1018) {
            long currentTimeMillis = 0L;
            try {
                currentTimeMillis = System.currentTimeMillis();
                try {
                    this.G();
                    this.h1047 = 0;
                    ((Canvas)this).repaint();
                    ((Canvas)this).serviceRepaints();
                    Thread.sleep(10);
                    Thread.yield();
                    while (System.currentTimeMillis() - currentTimeMillis < 100) {
                        Thread.yield();
                    }
                }
                catch (final Exception ex) {
                    ex.printStackTrace();
                }
            }
            catch (final Exception ex2) {}
            if (this.c1020) {
                this.s += (int)(System.currentTimeMillis() - currentTimeMillis);
            }
            ++this.a1019;
        }
        CMidlet.a();
    }
    
    public final void showNotify() {
        if (this.cb == 1000) {
            this.b1174 = 2;
        }
        else if (this.C1175) {
            this.b1174 = 1;
        }
        else {
            this.b1174 = 3;
        }
        this.cb = 0;
    }
}
