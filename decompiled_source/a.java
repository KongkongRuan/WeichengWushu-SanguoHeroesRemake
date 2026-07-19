/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.netmite.andme.MIDletThread
 *  com.nokia.mid.ui.DirectGraphics
 *  com.nokia.mid.ui.DirectUtils
 *  com.nokia.mid.ui.FullCanvas
 *  javax.microedition.io.HttpConnection
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Font
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 *  javax.microedition.media.Manager
 *  javax.microedition.media.Player
 *  javax.microedition.media.control.VolumeControl
 *  javax.microedition.rms.RecordStore
 *  javax.microedition.rms.RecordStoreNotFoundException
 */
import com.netmite.andme.MIDletThread;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import com.nokia.mid.ui.FullCanvas;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
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

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class a
extends FullCanvas
implements Runnable {
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
        Object[] objectArray;
        int n = 8;
        int[] nArray = objectArray = new int[n];
        int[] nArray2 = objectArray;
        nArray[0] = 0;
        nArray2[1] = 8192;
        nArray[2] = 16384;
        nArray2[3] = 24576;
        nArray[4] = 8462;
        nArray2[5] = 270;
        nArray[6] = 90;
        nArray2[7] = 8282;
        a1001 = objectArray;
        objectArray = new String[15];
        objectArray[0] = (int)"/0.mid";
        objectArray[1] = (int)"/1.mid";
        objectArray[2] = (int)"/2.mid";
        objectArray[3] = (int)"/3.mid";
        objectArray[4] = (int)"/4.mid";
        objectArray[5] = (int)"/5.mid";
        objectArray[6] = (int)"/6.mid";
        objectArray[7] = (int)"/7.mid";
        objectArray[n] = (int)"/8.mid";
        objectArray[9] = (int)"/9.mid";
        objectArray[10] = (int)"/10.mid";
        objectArray[11] = (int)"/11.mid";
        objectArray[12] = (int)"/12.mid";
        objectArray[13] = (int)"/13.mid";
        objectArray[14] = (int)"/14.mid";
        c1045 = (String[])objectArray;
    }

    /*
     * Opcode count of 20927 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     */
    public a() {
        int n;
        Object object;
        int n2 = 4;
        int n3 = 1;
        int n4 = 3;
        int n5 = 2;
        this.a = Font.getFont((int)32, (int)0, (int)8);
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
        int[] nArray = object = new int[5];
        int[] nArray2 = object;
        nArray[0] = 6305566;
        nArray2[1] = 32260;
        nArray[2] = 255;
        nArray2[3] = 13516032;
        nArray2[4] = 9240762;
        this.d1011 = object;
        this.e = new int[21];
        this.a1013 = new Image[39][];
        int[] nArray3 = object = new int[39];
        int[] nArray4 = object;
        nArray3[0] = 12;
        nArray4[1] = 8;
        nArray3[2] = 2;
        nArray4[3] = 30;
        nArray3[4] = 26;
        nArray4[5] = 1;
        nArray3[6] = 1;
        nArray4[7] = 1;
        nArray3[8] = 1;
        nArray4[9] = 1;
        nArray3[10] = 1;
        nArray4[11] = 1;
        nArray3[12] = 2;
        nArray4[13] = 2;
        nArray3[14] = 2;
        nArray4[15] = 2;
        nArray3[16] = 3;
        nArray4[17] = 2;
        nArray3[18] = 6;
        nArray4[19] = 1;
        nArray3[20] = 2;
        nArray4[21] = 2;
        nArray3[22] = 1;
        nArray4[23] = 3;
        nArray3[24] = 1;
        nArray4[25] = 1;
        nArray3[26] = 3;
        nArray4[27] = 2;
        nArray3[28] = 1;
        nArray4[29] = 48;
        nArray3[30] = 1;
        nArray4[31] = 10;
        nArray3[32] = 48;
        nArray4[33] = 6;
        nArray3[34] = 1;
        nArray4[35] = 1;
        nArray3[36] = 1;
        nArray4[37] = 1;
        nArray4[38] = 7;
        this.f = object;
        object = new String[39];
        object[0] = (int)"/mu";
        object[n3] = (int)"/sflogo";
        object[n5] = (int)"/ld";
        object[n4] = (int)"/ui";
        object[n2] = (int)"/back";
        object[5] = (int)"/map0";
        object[6] = (int)"/map1";
        object[7] = (int)"/map2";
        object[8] = (int)"/map3";
        object[9] = (int)"/map4";
        object[10] = (int)"/map5";
        object[11] = (int)"/map6";
        object[12] = (int)"/e0";
        object[13] = (int)"/e1";
        object[14] = (int)"/e2";
        object[15] = (int)"/e3";
        object[16] = (int)"/e4";
        object[17] = (int)"/e5";
        object[18] = (int)"/t0";
        object[19] = (int)"/t1";
        object[20] = (int)"/t2";
        object[21] = (int)"/t3";
        object[22] = (int)"/t4";
        object[23] = (int)"/t5";
        object[24] = (int)"/t6";
        object[25] = (int)"/t7";
        object[26] = (int)"/t8";
        object[27] = (int)"/t9";
        object[28] = (int)"/t10";
        object[29] = (int)"/bu";
        object[30] = (int)"/s";
        object[31] = (int)"/h";
        object[32] = (int)"/sp";
        object[33] = (int)"/end";
        object[34] = (int)"/sp0";
        object[35] = (int)"/sp1";
        object[36] = (int)"/sp2";
        object[37] = (int)"/sp3";
        object[38] = (int)"/eff";
        this.a1014 = (String[])object;
        object = new String[181];
        object[0] = (int)"\u6e38\u620f\u63cf\u8ff0:\n\u60f3\u8bd5\u8bd5\u770b\u4e09\u56fd\u5b88\u57ce\u662f\u591a\u4e48\u6fc0\u70c8\uff1f\u767e\u540d\u653b\u57ce\u540d\u5c06\u5bf9\u5b88\u57ce\u5fe0\u81e3\uff01\u957f\u5742\uff0c\u8d64\u58c1\uff0c\u5937\u9675\u7b49\u5386\u53f2\u6218\u5f79\u7b49\u60a8\u53c2\u52a0\uff0c\u6b65\u5175\uff0c\u9a91\u5175\uff0c\u91cd\u88c5\u5175\u7b49\u987d\u654c\u5411\u60a8\u51b2\u6765\uff0c\u64c2\u6728\uff0c\u6295\u77f3\uff0c\u65ad\u9f99\u95f8\u7b49\u6b66\u5668\u4f9b\u60a8\u6311\u9009\uff0c\u6d2a\u6c34\uff0c\u653e\u706b\uff0c\u5947\u95e8\u9041\u7532\u7b49\u5999\u8ba1\u4fe1\u624b\u62c8\u6765\uff01\u6211\u65b9\u57ce\u6c60\u906d\u5230\u5730\u65b9\u57ce\u6c60\u4e2d\u8702\u62e5\u800c\u51fa\u654c\u5175\u7684\u4fb5\u6270\uff0c\u4e3a\u4e86\u62b5\u5fa1\u4e0d\u65ad\u7684\u5165\u4fb5\uff0c\u6211\u65b9\u5728\u654c\u5175\u5165\u4fb5\u6211\u65b9\u57ce\u6c60\u7684\u5e76\u7ecf\u4e4b\u8def\u4e0a\u4fee\u5efa\u9632\u5fa1\u706b\u529b\u4e88\u4ee5\u963b\u51fb\uff0c\u6d88\u706d\u4e0d\u65ad\u8d76\u6765\u610f\u56fe\u653b\u9677\u6211\u65b9\u57ce\u6c60\u7684\u654c\u5175\u3002\u6e38\u620f\u4e2d\u4f1a\u51fa\u73b0\u5927\u91cf\u4e09\u56fd\u65f6\u5019\u7684\u5de5\u7a0b\u9632\u5fa1\u6b66\u5668\u4f9b\u73a9\u5bb6\u5efa\u9020\uff0c\u8bf8\u5982\u65ad\u9f99\u95f8\u7b49\u3002\u5982\u4f55\u5145\u5206\u5229\u7528\u6709\u5229\u5730\u5f62\u5efa\u9020\u66f4\u591a\u7684\u9632\u5fa1\u6b66\u5668\u62b5\u5fa1\u6765\u72af\u7684\u654c\u5175\uff0c\u4e00\u573a\u6597\u5fd7\u6597\u52c7\u7684\u57ce\u6c60\u4fdd\u536b\u6218\u5c31\u6b64\u5c55\u5f00\u3002\n\u6e38\u620f\u89c4\u5219\uff1a\n\u654c\u5175\u6309\u56fa\u5b9a\u8def\u7ebf\u524d\u8fdb\uff0c\u73a9\u5bb6\u6cbf\u9014\u5236\u9020\u653b\u51fb\u969c\u788d\u8bbe\u65bd\u963b\u6b62\u5176\u5230\u7ec8\u70b9\uff0d\uff0d\u6211\u65b9\u9547\u5b88\u7684\u57ce\u6c60\uff0c\u4e00\u5b9a\u6570\u91cf\u7684\u654c\u5175\u6d8c\u5165\u6211\u65b9\u57ce\u6c60\uff0c\u73a9\u5bb6\u5931\u8d25\u3002\u654c\u5175\u5206\u6279\u4ece\u654c\u57ce\u51fa\u53d1\uff0c\u73a9\u5bb6\u6bcf\u6d88\u706d\u4e00\u4e2a\u654c\u5175\u83b7\u5f97\u4e00\u4e9b\u91d1\uff0c\u7528\u91d1\u53ef\u4ee5\u5728\u6211\u65b9\u57ce\u6c60\u4e2d\u8425\u5efa\u5404\u5f0f\u5404\u6837\u79d1\u6280\u5efa\u7b51\uff0c\u51ed\u501f\u79d1\u6280\u5efa\u7b51\u53ef\u4ee5\u5728\u654c\u5175\u6765\u72af\u7684\u6cbf\u9014\u4fee\u5efa\u5404\u5f0f\u5404\u6837\u7684\u5de5\u7a0b\u9632\u5fa1\u6b66\u5668\uff0c\u5bf9\u9632\u5fa1\u6b66\u5668\u7684\u5347\u7ea7\u53ef\u4ee5\u589e\u5f3a\u5b83\u4eec\u7684\u5a01\u529b\uff0c\u4ee5\u5e94\u5bf9\u8d8a\u6765\u8d8a\u591a\u654c\u5175\u7684\u5165\u4fb5\u3002\n\u6e38\u620f\u64cd\u4f5c\uff1a\n\u5de6\u529f\u80fd\u952e/\u5bfc\u822a\u952e\u4e2d\uff1a\u786e\u8ba4\u9009\u62e9/\u6e38\u620f\u4e2d\u5efa\u9020\u5355\u4f4d\n\u53f3\u529f\u80fd\u952e\uff1a\u8fd4\u56de/\u6e38\u620f\u4e2d\u8c03\u51fa\u83dc\u5355\n\u6570\u5b57\u952e5\uff1a\u6e38\u620f\u4e2d\u8c03\u51fa\u5355\u4f4d\u5efa\u9020\u83dc\u5355\n\u5bfc\u822a\u952e\u4e0a\u4e0b\u5de6\u53f3/\u6570\u5b57\u952e2\u30014\u30016\u30018\uff1a\u9009\u62e9\u83dc\u5355/\u6e38\u620f\u4e2d\u63a7\u5236\u5efa\u9020\u5355\u4f4d\u5730\u70b9\u3001\u65b9\u5411";
        object[n3] = (int)"\u7248\u6743\u6240\u6709\uff1a\n\u4e0a\u6d77\u96ea\u9ca4\u9c7c\u8ba1\u7b97\u673a\u79d1\u6280\u6709\u9650\u516c\u53f8\n\u7f51\u5740\uff1a\nwww.kgame.com.cn\n\u624b\u673a\u4e0a\u7f51\uff1a\nwap.kgame.com.cn\n\u7248\u672c\uff1aV1.0\n\u5236\u4f5c\u4eba\uff1a\u8bf8\u4e00\u6960\n\u7f8e\u672f\u8bbe\u8ba1\uff1a\u9ec4\u52bc\n\u7a0b\u5e8f\u8bbe\u8ba1\uff1a\u79e6\u7aeb\n\u7a0b\u5e8f\u534f\u52a9\uff1a\u7a0b\u96ea\u5e73\n\u6d4b\u8bd5\uff1a\u738b\u6bc5\uff0c\u9648\u601d\u6e90";
        object[n5] = (int)"\u57fa\u7840\u8fdc\u7a0b\u653b\u51fb\u5355\u4f4d";
        object[n4] = (int)"\u53ef\u4f7f\u654c\u4eba\u4e2d\u6bd2\u3002";
        object[n2] = (int)"\u5730\u5e95\u4f38\u51fa\u5229\u5203\uff0c\u6740\u4f24\u654c\u4eba";
        object[5] = (int)"\u70b9\u71c3\u654c\u4eba";
        object[6] = (int)"\u53ef\u4ee5\u4f7f\u654c\u4eba\u6682\u505c";
        object[7] = (int)"\u53ef\u4ee5\u4f7f\u654c\u4eba\u51b0\u51bb";
        object[8] = (int)"\u76f4\u7ebf\u6c89\u91cd\u6253\u51fb\u654c\u4eba\u7684\u6728\u6869";
        object[9] = (int)"\u8fdc\u7a0b\u6c89\u91cd\u6253\u51fb\u654c\u4eba\u7684\u77f3\u5934";
        object[10] = (int)"\u9020\u6210\u5f88\u5927\u4f24\u5bb3\uff0c\u4f1a\u5c06\u706b\u7184\u706d";
        object[11] = (int)"\u9020\u6210\u5f88\u5927\u4f24\u5bb3\uff0c\u9047\u706b\u4f1a\u70b9\u71c3";
        object[12] = (int)"\u963b\u65ad\u654c\u4eba\u524d\u8fdb\uff0c\u7528\u8fc7\u540e\u5931\u6548";
        object[13] = (int)"\u751f\u4ea7\u77f3\u7070\u74f6\u548c\u65ad\u9f99\u95f8\u7684\u88c5\u7f6e";
        object[14] = (int)"\u751f\u4ea7\u7a81\u523a\u548c\u64c2\u6728\u7684\u88c5\u7f6e";
        object[15] = (int)"\u751f\u4ea7\u70df\u706b\u548c\u6295\u77f3\u7684\u88c5\u7f6e";
        object[16] = (int)"\u751f\u4ea7\u9ebb\u75f9\u77e2\u548c\u6cb8\u6c34\u7684\u88c5\u7f6e";
        object[17] = (int)"\u751f\u4ea7\u5bd2\u51b0\u548c\u6eda\u6cb9\u7684\u88c5\u7f6e";
        object[18] = (int)"\u5347\u7ea7\u5854\uff0c\u5347\u5230\u9876\u53ef\u83b7\u5f97\u82f1\u96c4";
        object[19] = (int)"";
        object[20] = (int)"\u88c5\u586b\u77f3\u5757";
        object[21] = (int)"\u91ca\u653e\u65ad\u9f99\u95f8";
        object[22] = (int)"\u62c6\u9664\u6240\u9009\u5854\uff0c\u56de\u6536\u90e8\u5206\u8d44\u91d1";
        object[23] = (int)"\u53d6\u6d88\u9009\u62e9";
        object[24] = (int)"\u91d1\u624b\u6307";
        object[25] = (int)"\u6210\u90fd";
        object[26] = (int)"\u8bb8\u660c";
        object[27] = (int)"\u5efa\u4e1a";
        object[28] = (int)"\u5218\u5907";
        object[29] = (int)"\u5173\u7fbd";
        object[30] = (int)"\u9a6c\u8d85";
        object[31] = (int)"\u9ec4\u5fe0";
        object[32] = (int)"\u5f20\u98de";
        object[33] = (int)"\u8d75\u4e91";
        object[34] = (int)"\u9b4f\u5ef6";
        object[35] = (int)"\u59dc\u7ef4";
        object[36] = (int)"\u8bf8\u845b\u4eae";
        object[37] = (int)"\u5f90\u5eb6";
        object[38] = (int)"\u5e9e\u7edf";
        object[39] = (int)"\u66f9\u64cd";
        object[40] = (int)"\u5178\u97e6";
        object[41] = (int)"\u5f20\u8fbd";
        object[42] = (int)"\u590f\u4faf\u6e0a";
        object[43] = (int)"\u590f\u4faf\u619e";
        object[44] = (int)"\u8bb8\u891a";
        object[45] = (int)"\u53f8\u9a6c\u61ff";
        object[46] = (int)"\u8340\u6538";
        object[47] = (int)"\u8340\u5f67";
        object[48] = (int)"\u7a0b\u6631";
        object[49] = (int)"\u90ed\u5609";
        object[50] = (int)"\u5b59\u6743";
        object[51] = (int)"\u51cc\u7edf";
        object[52] = (int)"\u7518\u5b81";
        object[53] = (int)"\u9ec4\u76d6";
        object[54] = (int)"\u5468\u6cf0";
        object[55] = (int)"\u592a\u53f2\u6148";
        object[56] = (int)"\u5f20\u662d";
        object[57] = (int)"\u9646\u900a";
        object[58] = (int)"\u5415\u8499";
        object[59] = (int)"\u9c81\u8083";
        object[60] = (int)"\u5468\u745c";
        object[61] = (int)"\u5f20\u6881";
        object[62] = (int)"\u5f20\u5b9d";
        object[63] = (int)"\u5f20\u89d2";
        object[64] = (int)"\u534e\u96c4";
        object[65] = (int)"\u8c82\u8749";
        object[66] = (int)"\u5415\u5e03";
        object[67] = (int)"\u8463\u5353";
        object[68] = (int)"\u5f20\u988c";
        object[69] = (int)"\u66f9\u6d2a";
        object[70] = (int)"\u5f90\u6643";
        object[71] = (int)"\u4e8e\u7981";
        object[72] = (int)"\u4e50\u8fdb";
        object[73] = (int)"\u674e\u5178";
        object[74] = (int)"\u66f9\u4e15";
        object[75] = (int)"\u7a0b\u666e";
        object[76] = (int)"\u5218\u5907\u540c\u65f6\u62e5\u6709\u5367\u9f99\u4e0e\u51e4\u96cf\uff0c\u5c5e\u6027\u4f24\u5bb3\u5f88\u5389\u5bb3\u3002";
        object[77] = (int)"\u7531\u66f9\u64cd\u5e26\u9886\u7684\u80fd\u81e3\u731b\u5c06\uff0c\u64c5\u957f\u963b\u788d\u654c\u4eba\u884c\u8fdb\u3002";
        object[78] = (int)"\u5b59\u5bb6\u7387\u9886\u5434\u56fd\u7684\u4e16\u4ee3\u540d\u5c06\uff0c\u5f13\u7bad\u7684\u597d\u624b\u8f88\u51fa\u3002";
        object[79] = (int)"\u6b66\u7cfb";
        object[80] = (int)"\u6587\u7cfb";
        object[81] = (int)"\u4f18\u5148\u628a\u4e0d\u540c\u7684\u9632\u5fa1\u5854\u5347\u7ea7\u6210\u672c\u56fd\u5bf9\u5e94\u6b66\u5c06";
        object[82] = (int)"\u4f18\u5148\u628a\u4e0d\u540c\u7684\u9632\u5fa1\u5854\u5347\u7ea7\u6210\u672c\u56fd\u5bf9\u5e94\u6587\u81e3";
        object[83] = (int)"\u9ec4\u5dfe\u4e4b\u4e71";
        object[84] = (int)"\u5f20\u6c0f\u8d77\u4e49\u4e0d\u4ec5\u52a8\u6447\u4e86\u6c49\u671d\u7684\u7edf\u6cbb\uff0c\u66f4\u5f15\u5f97\u65e0\u6570\u82f1\u96c4\u8c6a\u6770\u4e71\u4e16\u9010\u9e7f\u3002";
        object[85] = (int)"\u864e\u7262\u5173";
        object[86] = (int)"\u8463\u5353\u65e0\u9053\uff0c\u5341\u516b\u8def\u8bf8\u4faf\u5c3d\u8d77\u800c\u653b\u4e4b\u3002\u4e09\u82f1\u6218\u5415\u5e03\uff0c\u6e29\u9152\u65a9\u534e\u96c4\u3002";
        object[87] = (int)"\u957f\u5742\u5761";
        object[88] = (int)"\u957f\u5742\u5761\u4e2d\u56f0\u9f99\u51fa,\u864e\u5c06\u6000\u4e2d\u5c0f\u9f99\u7720.\u81ea\u53e4\u51b2\u9635\u6276\u5371\u4e3b,\u662f\u6709\u5e38\u5c71\u8d75\u5b50\u9f99\u3002";
        object[89] = (int)"\u8d64\u58c1\u4e4b\u6218";
        object[90] = (int)"\u96c4\u59ff\u82f1\u53d1\uff0c\u7fbd\u6247\u7eb6\u5dfe\uff0c\u8c08\u7b11\u95f4\uff0c\u5f3a\u864f\u7070\u98de\u70df\u706d\u3002 \u516c\u747e\uff1f\u5b54\u660e\uff1f";
        object[91] = (int)"\u6218\u5408\u80a5";
        object[92] = (int)"\u201c\u82e5\u5b59\u6743\u81f3\u8005\uff0c\u5f20\u3001\u674e\u5c06\u519b\u51fa\u6218\uff0c\u4e50\u5c06\u519b\u5b88\uff0c\u62a4\u519b\u52ff\u5f97\u4e0e\u6218\u201d";
        object[93] = (int)"\u5937\u9675\u4e4b\u6218";
        object[94] = (int)"\u5937\u9675\u4e4b\u6218\uff0c\u53c8\u79f0\u5f5d\u9675\u4e4b\u6218\u3001\u7307\u4ead\u4e4b\u6218\u3002\u53cc\u65b9\u6307\u6325\u5b98\uff1a\u9646\u900a\uff0c\u5218\u5907\u3002";
        object[95] = (int)"\u653b\u514b\u6210\u90fd";
        object[96] = (int)"\u6c49\u671d\u51e0\u767e\u5e74\u7684\u57fa\u4e1a\u5230\u4e86\u5c3d\u5934\uff0c\u8c01\u80fd\u53d6\u5f97\u8fd9\u4efd\u8363\u8000\uff1f";
        object[97] = (int)"\u653b\u514b\u8bb8\u660c";
        object[98] = (int)"\u66f9\u64cd\u7684\u8d3c\u5b50\u91ce\u5fc3\u5373\u5c06\u8986\u706d\uff0c\u591a\u5e74\u7684\u52aa\u529b\u4eca\u5929\u7ec8\u4e8e\u6709\u6240\u56de\u62a5\uff01";
        object[99] = (int)"\u653b\u514b\u5efa\u4e1a";
        object[100] = (int)"\u5b59\u6c0f\u5bb6\u65cf\u7684\u660f\u5eb8\u7edf\u6cbb\u5373\u5c06\u7ec8\u7ed3\uff0c\u6253\u8fc7\u957f\u6c5f\u53bb\uff0c\u89e3\u6551\u5357\u65b9\u4eba\u6c11\uff01";
        object[101] = (int)"\u58f0\u97f3";
        object[102] = (int)"\u5f00";
        object[103] = (int)"\u5173";
        object[104] = (int)"\u662f\u5426\u5f00\u542f\u58f0\u97f3";
        object[105] = (int)"\u5f00\u542f";
        object[106] = (int)"\u53d6\u6d88";
        object[107] = (int)"\u7ee7\u7eed\u6e38\u620f";
        object[108] = (int)"\u91d1\u624b\u6307";
        object[109] = (int)"\u8bbe\u7f6e";
        object[110] = (int)"\u5e2e\u52a9";
        object[111] = (int)"\u5173\u4e8e";
        object[112] = (int)"\u9000\u51fa";
        object[113] = (int)"\u91d1\u4e0d\u8db3\uff0c\u6d88\u706d\u654c\u4eba\u53ef\u83b7\u5f97\u91d1\u94b1\uff0c\u4e5f";
        object[114] = (int)"\u9700\u8981\u81f3\u5c11\u4fee\u5efa\u4e00\u4e2a\u5854";
        object[115] = (int)"\u73b0\u5728\u8fd8\u4e0d\u80fd\u5efa\u9020\u8fd9\u4e2a\u5efa\u7b51,\u9700\u8981\u4fee\u5efa\u76f8\u5173\u7684\u57ce\u6c60\uff0c\u4e5f";
        object[116] = (int)"\u8be5\u57ce\u6c60\u5df2\u7ecf\u4fee\u5efa";
        object[117] = (int)"\u8be5\u5854\u5df2\u662f\u6700\u9ad8\u7ea7";
        object[118] = (int)"\u73b0\u5728\u8fd8\u4e0d\u80fd\u5347\u7ea7\u8fd9\u4e2a\u5efa\u7b51\uff0c\u9700\u8981\u5c06\u57ce\u6c60\u5168\u90e8\u5efa\u7b51\u5347\u7ea7\uff0c\u4e5f";
        object[119] = (int)"\u9700\u8981\u5347\u7ea7\u5f13\u5854\u81f3\u541b\u4e3b";
        object[120] = (int)"\u5df2\u7ecf\u8fbe\u5230\u5efa\u7b51\u4e0a\u9650";
        object[121] = (int)"\u60a8\u7684\u57ce\u5e02\u5373\u5c06\u88ab\u653b\u5360\uff01";
        object[122] = (int)"\u4f7f\u6240\u6709\u5854\u653b\u51fb\u589e\u52a0";
        object[123] = (int)"\u65e0\u89c6\u654c\u4eba\u9632\u5fa1";
        object[124] = (int)"\u65e0\u89c6\u654c\u4eba\u9632\u5fa1";
        object[125] = (int)"\u51fb\u4e2d\u654c\u4eba\u540c\u65f6\u51cf\u901f";
        object[126] = (int)"\u653b\u51fb\u8303\u56f4\u589e\u52a0";
        object[127] = (int)"\u653b\u51fb\u8303\u56f4\u589e\u52a0";
        object[128] = (int)"\u4e2d\u6bd2\u654c\u4eba\u540c\u65f6\u51cf\u901f";
        object[129] = (int)"\u65e0\u89c6\u654c\u4eba\u9632\u5fa1";
        object[130] = (int)"\u706b\u7130\u4f24\u5bb3\u52a0\u5f3a";
        object[131] = (int)"\u9ebb\u75f9\u65f6\u95f4\u5ef6\u957f";
        object[132] = (int)"\u51b0\u51bb\u65f6\u95f4\u5ef6\u957f";
        object[133] = (int)"\u4f7f\u6240\u6709\u5854\u653b\u51fb\u589e\u52a0";
        object[134] = (int)"\u77f3\u5757\u66f4\u52a0\u575a\u786c";
        object[135] = (int)"\u52a0\u5f3a\u653b\u51fb\u4f24\u5bb3";
        object[136] = (int)"\u52a0\u5f3a\u653b\u51fb\u4f24\u5bb3";
        object[137] = (int)"\u653b\u51fb\u65f6\u95f4\u5ef6\u957f";
        object[138] = (int)"\u653b\u51fb\u65f6\u95f4\u5ef6\u957f";
        object[139] = (int)"\u52a0\u5f3a\u653b\u51fb\u4f24\u5bb3";
        object[140] = (int)"\u52a0\u5f3a\u653b\u51fb\u4f24\u5bb3";
        object[141] = (int)"\u52a0\u5f3a\u653b\u51fb\u4f24\u5bb3";
        object[142] = (int)"\u8303\u56f4\u9ebb\u75f9";
        object[143] = (int)" \u8303\u56f4\u51b0\u51bb";
        object[144] = (int)"\u4f7f\u6240\u6709\u5854\u653b\u51fb\u589e\u52a0";
        object[145] = (int)"\u88c5\u586b\u77f3\u5934\u534a\u4ef7";
        object[146] = (int)"\u52a0\u5f3a\u653b\u51fb\u9891\u7387";
        object[147] = (int)"\u5468\u56f4\u5854\u653b\u51fb\u589e\u52a0";
        object[148] = (int)"\u8303\u56f4\u5185\u654c\u4eba\u51cf\u901f";
        object[149] = (int)"\u8303\u56f4\u5185\u654c\u4eba\u51cf\u901f";
        object[150] = (int)"\u4e2d\u6bd2\u65f6\u95f4\u5ef6\u957f";
        object[151] = (int)"\u52a0\u5f3a\u653b\u51fb\u9891\u7387";
        object[152] = (int)"\u706b\u7130\u4f24\u5bb3\u65f6\u95f4\u589e\u52a0";
        object[153] = (int)"\u9ebb\u75f9\u6982\u7387\u589e\u52a0";
        object[154] = (int)"\u51b0\u51bb\u6982\u7387\u589e\u52a0";
        object[155] = (int)"\u5927\u5bb6\u8ddf\u6211";
        object[156] = (int)"\u7ec3\u4e86\u8fd9\u4e48\u4e45\uff0c\u8fd9\u70b9\u6253\u51fb\u7b97\u5565\uff1f";
        object[157] = (int)"\u5feb\u70b9\u5feb\u70b9\u5feb\u70b9\uff01\u8ddf\u6211";
        object[158] = (int)"\u51b2\u7834\u654c\u57ce\u6709\u91cd\u8d4f\uff01";
        object[159] = (int)"\u6211\u4e43";
        object[160] = (int)"\uff0c\u6211\u7684\u536b\u961f\u9971\u9910\u800c\u6765\uff0c\u4e0d\u6b7b\u4e0d\u5f52\uff01";
        object[161] = (int)"\u5e08\u5085\u5728\u5929\u6709\u7075\uff0c";
        object[162] = (int)"\u591a\u5e74\u6765\u7684\u6c34\u6218\u4e0d\u767d\u7ec3\uff01";
        object[163] = (int)"\u88ab\u70e7\u4e86\u591a\u6b21\uff0c\u6211";
        object[164] = (int)"\u4eca\u5929\u4e5f\u7b97\u4e0d\u6015\u706b\u4e86\u54c8\u54c8\uff01";
        object[165] = (int)"\u6211";
        object[166] = (int)"\u559d\u4e86\u8fd9\u4e48\u591a\u9ebb\u75f9\u6563\uff0c\u8be5\u4e0d\u6015\u9ebb\u75f9\u4e86\u5427\uff01";
        object[167] = (int)"\u5144\u5f1f\u4eec\u90fd\u7ed9\u6211";
        object[168] = (int)"\u51b2\u554a\uff01\u51b2\u6162\u7684\u519b\u6cd5\u5904\u7f6e\uff01";
        object[169] = (int)"\u4ffa";
        object[170] = (int)"\u5403\u4e86\u8fd9\u4e48\u591a\u89e3\u836f\uff0c\u4e0d\u4f1a\u518d\u4e2d\u6bd2\u4e86\u5427\uff1f";
        object[171] = (int)"\u5efa\u9020\u5404\u79cd\u57ce\u9632\u6b66\u5668\u62b5\u6321\u654c\u57ce\u4e2d\u6d8c\u51fa\u7684\u519b\u961f";
        object[172] = (int)"\u5347\u7ea7\u81ea\u5df1\u7684\u57ce\u6c60\u53ef\u4ee5\u5efa\u9020\u66f4\u591a\u7c7b\u578b\u7684\u6b66\u5668";
        object[173] = (int)"\u8d85\u8fc710\u4e2a\u654c\u4eba\u51b2\u5165\u81ea\u5df1\u7684\u57ce\u6c60\u5219\u6e38\u620f\u5931\u8d25";
        object[174] = (int)"\u7a7a\u5730\u63095\u9020\u5854\uff0c#\u51fa\u654c\u4eba\uff0c\u5854\u6216\u57ce\u4e0a\u63095\u5347\u7ea7";
        object[175] = (int)"\u6d88\u706d\u5f53\u524d\u5168\u90e8\u654c\u4eba";
        object[176] = (int)"\u83b7\u5f97\u5168\u90e8\u79d1\u6280";
        object[177] = (int)"\u83b7\u5f97500\u91d1";
        object[178] = (int)"\u57ce\u9632\u52a010";
        object[179] = (int)"\u6d88\u706d\u654c\u4eba\u91d1\u7ffb\u500d";
        object[180] = (int)"\u73b0\u5728\u8fd8\u4e0d\u80fd\u5347\u7ea7\u8fd9\u4e2a\u5efa\u7b51";
        this.b1015 = (String[])object;
        this.o = -1;
        this.q = 60;
        this.b1018 = n3;
        this.a1019 = 0L;
        this.c1020 = false;
        this.r = 0;
        this.e1025 = 0;
        this.f1026 = 0;
        Object[] objectArray = object = (Object)new byte[6];
        Object[] objectArray2 = object;
        objectArray[0] = -30;
        objectArray2[1] = -1;
        objectArray[2] = 0;
        objectArray2[3] = 1;
        objectArray[4] = 1;
        objectArray2[5] = 0;
        this.a1027 = (byte[])object;
        object = new byte[n4][];
        Object object2 = new byte[n5];
        object2[0] = 27;
        object2[1] = 63;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 79;
        object2[1] = 33;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 113;
        object2[1] = 71;
        object[n5] = (int)object2;
        this.a1028 = (byte[][])object;
        this.V = this.j * 3 + 40;
        this.W = 320 - this.V - 13 - 10;
        this.ad = this.j * 3 + 40;
        this.ah = this.j * 3 + 10 + 30;
        int n6 = this.ai = this.ah + 40;
        this.aj = n = 320 - n6 - 13 - 10;
        object = new byte[9][];
        object2 = new byte[n5];
        object2[0] = 103;
        object2[1] = 41;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 64;
        object2[1] = 38;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 68;
        object2[1] = 65;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 96;
        object2[1] = 77;
        object[n4] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 105;
        object2[1] = 57;
        object[n2] = (int)object2;
        Object object3 = new byte[n5];
        object3[0] = 60;
        object3[1] = 77;
        object[5] = (int)object3;
        object3 = new byte[n5];
        object3[0] = 29;
        object3[1] = 73;
        object[6] = (int)object3;
        object3 = new byte[n5];
        object3[0] = 81;
        object3[1] = 52;
        object[7] = (int)object3;
        object3 = new byte[n5];
        object3[0] = 122;
        object3[1] = 83;
        object[8] = (int)object3;
        this.b1030 = (byte[][])object;
        this.l1031 = n3;
        this.ak = 0;
        Object object4 = object = (Object)new byte[n4];
        object[0] = 87;
        object4[1] = 18;
        object4[2] = 9;
        this.b1034 = (byte[])object;
        this.g1035 = new int[n4];
        Object object5 = object = (Object)new byte[42];
        Object object6 = object;
        object5[0] = 0;
        object6[1] = 5;
        object5[2] = 5;
        object6[3] = 5;
        object5[4] = 10;
        object6[5] = 4;
        object5[6] = 14;
        object6[7] = 7;
        object5[8] = 21;
        object6[9] = 4;
        object5[10] = 25;
        object6[11] = 3;
        object5[12] = 28;
        object6[13] = 3;
        object5[14] = 31;
        object6[15] = 4;
        object5[16] = 35;
        object6[17] = 3;
        object5[18] = 38;
        object6[19] = 4;
        object5[20] = 42;
        object6[21] = 4;
        object5[22] = 46;
        object6[23] = 4;
        object5[24] = 50;
        object6[25] = 4;
        object5[26] = 54;
        object6[27] = 3;
        object5[28] = 57;
        object6[29] = 3;
        object5[30] = 60;
        object6[31] = 4;
        object5[32] = 64;
        object6[33] = 2;
        object5[34] = 66;
        object6[35] = 2;
        object5[36] = 68;
        object6[37] = 4;
        object5[38] = 72;
        object6[39] = 4;
        object5[40] = 76;
        object6[41] = 5;
        this.c1037 = (byte[])object;
        this.a1039 = (int[][])Array.newInstance(Integer.TYPE, 26, 7);
        this.h1041 = new int[15];
        this.a1042 = new InputStream[n3];
        this.a1043 = new Player[n3];
        this.i1044 = new int[n3];
        this.aq = -1;
        this.g1046 = 0;
        this.h1047 = 0;
        this.i1048 = 0;
        object = new int[360];
        object[0] = 0;
        object[n3] = 71;
        object[n5] = 143;
        object[n4] = 214;
        object[n2] = 286;
        object[5] = 357;
        object[6] = 428;
        object[7] = 499;
        object[8] = 570;
        object[9] = 641;
        object[10] = 711;
        object[11] = 782;
        object[12] = 852;
        object[13] = 921;
        object[14] = 991;
        object[15] = 1060;
        object[16] = 1129;
        object[17] = 1198;
        object[18] = 1266;
        object[19] = 1334;
        object[20] = 1401;
        object[21] = 1468;
        object[22] = 1534;
        object[23] = 1600;
        object[24] = 1666;
        object[25] = 1731;
        object[26] = 1796;
        object[27] = 1860;
        object[28] = 1923;
        object[29] = 1986;
        object[30] = 2048;
        object[31] = 2110;
        object[32] = 2171;
        object[33] = 2231;
        object[34] = 2290;
        object[35] = 2349;
        object[36] = 2408;
        object[37] = 2465;
        object[38] = 2522;
        object[39] = 2578;
        object[40] = 2633;
        object[41] = 2687;
        object[42] = 2741;
        object[43] = 2793;
        object[44] = 2845;
        object[45] = 2896;
        object[46] = 2946;
        object[47] = 2996;
        object[48] = 3044;
        object[49] = 3091;
        object[50] = 3138;
        object[51] = 3183;
        object[52] = 3228;
        object[53] = 3271;
        object[54] = 3314;
        object[55] = 3355;
        object[56] = 3396;
        object[57] = 3435;
        object[58] = 3474;
        object[59] = 3511;
        object[60] = 3547;
        object[61] = 3582;
        object[62] = 3617;
        object[63] = 3650;
        object[64] = 3681;
        object[65] = 3712;
        object[66] = 3742;
        object[67] = 3770;
        object[68] = 3798;
        object[69] = 3824;
        object[70] = 3849;
        object[71] = 3873;
        object[72] = 3896;
        object[73] = 3917;
        object[74] = 3937;
        object[75] = 3956;
        object[76] = 3974;
        object[77] = 3991;
        object[78] = 4006;
        object[79] = 4021;
        object[80] = 4034;
        object[81] = 4046;
        object[82] = 4056;
        object[83] = 4065;
        object[84] = 4074;
        object[85] = 4080;
        object[86] = 4086;
        object[87] = 4090;
        object[88] = 4094;
        object[89] = 4095;
        object[90] = 4096;
        object[91] = 4095;
        object[92] = 4094;
        object[93] = 4090;
        object[94] = 4086;
        object[95] = 4080;
        object[96] = 4074;
        object[97] = 4065;
        object[98] = 4056;
        object[99] = 4046;
        object[100] = 4034;
        object[101] = 4021;
        object[102] = 4006;
        object[103] = 3991;
        object[104] = 3974;
        object[105] = 3956;
        object[106] = 3937;
        object[107] = 3917;
        object[108] = 3896;
        object[109] = 3873;
        object[110] = 3849;
        object[111] = 3824;
        object[112] = 3798;
        object[113] = 3770;
        object[114] = 3742;
        object[115] = 3712;
        object[116] = 3681;
        object[117] = 3650;
        object[118] = 3617;
        object[119] = 3582;
        object[120] = 3547;
        object[121] = 3511;
        object[122] = 3474;
        object[123] = 3435;
        object[124] = 3396;
        object[125] = 3355;
        object[126] = 3314;
        object[127] = 3271;
        object[128] = 3228;
        object[129] = 3183;
        object[130] = 3138;
        object[131] = 3091;
        object[132] = 3044;
        object[133] = 2996;
        object[134] = 2946;
        object[135] = 2896;
        object[136] = 2845;
        object[137] = 2793;
        object[138] = 2741;
        object[139] = 2687;
        object[140] = 2633;
        object[141] = 2578;
        object[142] = 2522;
        object[143] = 2465;
        object[144] = 2408;
        object[145] = 2349;
        object[146] = 2290;
        object[147] = 2231;
        object[148] = 2171;
        object[149] = 2110;
        object[150] = 2048;
        object[151] = 1986;
        object[152] = 1923;
        object[153] = 1860;
        object[154] = 1796;
        object[155] = 1731;
        object[156] = 1666;
        object[157] = 1600;
        object[158] = 1534;
        object[159] = 1468;
        object[160] = 1401;
        object[161] = 1334;
        object[162] = 1266;
        object[163] = 1198;
        object[164] = 1129;
        object[165] = 1060;
        object[166] = 991;
        object[167] = 921;
        object[168] = 852;
        object[169] = 782;
        object[170] = 711;
        object[171] = 641;
        object[172] = 570;
        object[173] = 499;
        object[174] = 428;
        object[175] = 357;
        object[176] = 286;
        object[177] = 214;
        object[178] = 143;
        object[179] = 71;
        object[180] = 0;
        object[181] = -71;
        object[182] = -143;
        object[183] = -214;
        object[184] = -286;
        object[185] = -357;
        object[186] = -428;
        object[187] = -499;
        object[188] = -570;
        object[189] = -641;
        object[190] = -711;
        object[191] = -782;
        object[192] = -852;
        object[193] = -921;
        object[194] = -991;
        object[195] = -1060;
        object[196] = -1129;
        object[197] = -1198;
        object[198] = -1266;
        object[199] = -1334;
        object[200] = -1401;
        object[201] = -1468;
        object[202] = -1534;
        object[203] = -1600;
        object[204] = -1666;
        object[205] = -1731;
        object[206] = -1796;
        object[207] = -1860;
        object[208] = -1923;
        object[209] = -1986;
        object[210] = -2048;
        object[211] = -2110;
        object[212] = -2171;
        object[213] = -2231;
        object[214] = -2290;
        object[215] = -2349;
        object[216] = -2408;
        object[217] = -2465;
        object[218] = -2522;
        object[219] = -2578;
        object[220] = -2633;
        object[221] = -2687;
        object[222] = -2741;
        object[223] = -2793;
        object[224] = -2845;
        object[225] = -2896;
        object[226] = -2946;
        object[227] = -2996;
        object[228] = -3044;
        object[229] = -3091;
        object[230] = -3138;
        object[231] = -3183;
        object[232] = -3228;
        object[233] = -3271;
        object[234] = -3314;
        object[235] = -3355;
        object[236] = -3396;
        object[237] = -3435;
        object[238] = -3474;
        object[239] = -3511;
        object[240] = -3547;
        object[241] = -3582;
        object[242] = -3617;
        object[243] = -3650;
        object[244] = -3681;
        object[245] = -3712;
        object[246] = -3742;
        object[247] = -3770;
        object[248] = -3798;
        object[249] = -3824;
        object[250] = -3849;
        object[251] = -3873;
        object[252] = -3896;
        object[253] = -3917;
        object[254] = -3937;
        object[255] = -3956;
        object[256] = -3974;
        object[257] = -3991;
        object[258] = -4006;
        object[259] = -4021;
        object[260] = -4034;
        object[261] = -4046;
        object[262] = -4056;
        object[263] = -4065;
        object[264] = -4074;
        object[265] = -4080;
        object[266] = -4086;
        object[267] = -4090;
        object[268] = -4094;
        object[269] = -4095;
        object[270] = -4096;
        object[271] = -4095;
        object[272] = -4094;
        object[273] = -4090;
        object[274] = -4086;
        object[275] = -4080;
        object[276] = -4074;
        object[277] = -4065;
        object[278] = -4056;
        object[279] = -4046;
        object[280] = -4034;
        object[281] = -4021;
        object[282] = -4006;
        object[283] = -3991;
        object[284] = -3974;
        object[285] = -3956;
        object[286] = -3937;
        object[287] = -3917;
        object[288] = -3896;
        object[289] = -3873;
        object[290] = -3849;
        object[291] = -3824;
        object[292] = -3798;
        object[293] = -3770;
        object[294] = -3742;
        object[295] = -3712;
        object[296] = -3681;
        object[297] = -3650;
        object[298] = -3617;
        object[299] = -3582;
        object[300] = -3547;
        object[301] = -3511;
        object[302] = -3474;
        object[303] = -3435;
        object[304] = -3396;
        object[305] = -3355;
        object[306] = -3314;
        object[307] = -3271;
        object[308] = -3228;
        object[309] = -3183;
        object[310] = -3138;
        object[311] = -3091;
        object[312] = -3044;
        object[313] = -2996;
        object[314] = -2946;
        object[315] = -2896;
        object[316] = -2845;
        object[317] = -2793;
        object[318] = -2741;
        object[319] = -2687;
        object[320] = -2633;
        object[321] = -2578;
        object[322] = -2522;
        object[323] = -2465;
        object[324] = -2408;
        object[325] = -2349;
        object[326] = -2290;
        object[327] = -2231;
        object[328] = -2171;
        object[329] = -2110;
        object[330] = -2048;
        object[331] = -1986;
        object[332] = -1923;
        object[333] = -1860;
        object[334] = -1796;
        object[335] = -1731;
        object[336] = -1666;
        object[337] = -1600;
        object[338] = -1534;
        object[339] = -1468;
        object[340] = -1401;
        object[341] = -1334;
        object[342] = -1266;
        object[343] = -1198;
        object[344] = -1129;
        object[345] = -1060;
        object[346] = -991;
        object[347] = -921;
        object[348] = -852;
        object[349] = -782;
        object[350] = -711;
        object[351] = -641;
        object[352] = -570;
        object[353] = -499;
        object[354] = -428;
        object[355] = -357;
        object[356] = -286;
        object[357] = -214;
        object[358] = -143;
        object[359] = -71;
        Object object7 = object = new int[90];
        Object object8 = object;
        object7[0] = 0;
        object8[1] = 71;
        object7[2] = 143;
        object8[3] = 215;
        object7[4] = 286;
        object8[5] = 358;
        object7[6] = 431;
        object8[7] = 503;
        object7[8] = 576;
        object8[9] = 649;
        object7[10] = 722;
        object8[11] = 796;
        object7[12] = 871;
        object8[13] = 946;
        object7[14] = 1021;
        object8[15] = 1098;
        object7[16] = 1175;
        object8[17] = 1252;
        object7[18] = 1331;
        object8[19] = 1410;
        object7[20] = 1491;
        object8[21] = 1572;
        object7[22] = 1655;
        object8[23] = 1739;
        object7[24] = 1824;
        object8[25] = 1910;
        object7[26] = 1998;
        object8[27] = 2087;
        object7[28] = 2178;
        object8[29] = 2270;
        object7[30] = 2365;
        object8[31] = 2461;
        object7[32] = 2559;
        object8[33] = 2660;
        object7[34] = 2763;
        object8[35] = 2868;
        object7[36] = 2976;
        object8[37] = 3087;
        object7[38] = 3200;
        object8[39] = 3317;
        object7[40] = 3437;
        object8[41] = 3561;
        object7[42] = 3688;
        object8[43] = 3820;
        object7[44] = 3955;
        object8[45] = 4096;
        object7[46] = 4242;
        object8[47] = 4392;
        object7[48] = 4549;
        object8[49] = 4712;
        object7[50] = 4881;
        object8[51] = 5058;
        object7[52] = 5243;
        object8[53] = 5436;
        object7[54] = 5638;
        object8[55] = 5850;
        object7[56] = 6073;
        object8[57] = 6307;
        object7[58] = 6555;
        object8[59] = 6817;
        object7[60] = 7094;
        object8[61] = 7389;
        object7[62] = 7703;
        object8[63] = 8039;
        object7[64] = 8398;
        object8[65] = 8784;
        object7[66] = 9200;
        object8[67] = 9650;
        object7[68] = 10138;
        object8[69] = 10670;
        object7[70] = 11254;
        object8[71] = 11896;
        object7[72] = 12606;
        object8[73] = 13397;
        object7[74] = 14284;
        object8[75] = 15286;
        object7[76] = 16428;
        object8[77] = 17742;
        object7[78] = 19270;
        object8[79] = 21072;
        object7[80] = 23230;
        object8[81] = 25861;
        object7[82] = 29145;
        object8[83] = 33359;
        object7[84] = 38971;
        object8[85] = 46817;
        object7[86] = 58576;
        object8[87] = 78156;
        object7[88] = 117294;
        object8[89] = 234660;
        this.j1049 = object;
        Object object9 = object = (Object)new byte[6];
        Object object10 = object;
        object9[0] = 0;
        object10[1] = 21;
        object9[2] = 21;
        object10[3] = 11;
        object9[4] = 32;
        object10[5] = 11;
        this.d1050 = (byte[])object;
        object = new byte[n2][];
        byte[] byArray = object2 = new byte[5];
        byte[] byArray2 = object2;
        byArray[0] = 0;
        byArray2[1] = 1;
        byArray[2] = 2;
        byArray2[3] = 3;
        byArray2[4] = 4;
        object[0] = (int)object2;
        byte[] byArray3 = object2 = new byte[n2];
        byte[] byArray4 = object2;
        byArray3[0] = 1;
        byArray4[1] = 2;
        byArray3[2] = 3;
        byArray4[3] = 4;
        object[n3] = (int)object2;
        byte[] byArray5 = object2 = new byte[n2];
        byte[] byArray6 = object2;
        byArray5[0] = 6;
        byArray6[1] = 7;
        byArray5[2] = 8;
        byArray6[3] = 9;
        object[n5] = (int)object2;
        byte[] byArray7 = object2 = new byte[n2];
        byte[] byArray8 = object2;
        byArray7[0] = 5;
        byArray8[1] = 7;
        byArray7[2] = 8;
        byArray8[3] = 9;
        object[n4] = (int)object2;
        this.c1051 = (byte[][])object;
        object = new short[7][];
        object2 = new short[n5];
        object2[0] = 0;
        object2[1] = 10;
        object[0] = (int)object2;
        object2 = new short[n5];
        object2[0] = 1;
        object2[1] = 10;
        object[n3] = (int)object2;
        Object[] objectArray3 = object2 = (Object)new short[n2];
        Object[] objectArray4 = object2;
        objectArray3[0] = 2;
        objectArray4[1] = 3;
        objectArray3[2] = 1;
        objectArray4[3] = 10;
        object[n5] = (int)object2;
        object2 = new short[n5];
        object2[0] = 4;
        object2[1] = 10;
        object[n4] = (int)object2;
        Object[] objectArray5 = object2 = (Object)new short[n2];
        Object[] objectArray6 = object2;
        objectArray5[0] = 5;
        objectArray6[1] = 6;
        objectArray5[2] = 1;
        objectArray6[3] = 10;
        object[n2] = (int)object2;
        Object[] objectArray7 = object3 = (Object)new short[n2];
        Object[] objectArray8 = object3;
        objectArray7[0] = 7;
        objectArray8[1] = 8;
        objectArray7[2] = 9;
        objectArray8[3] = 10;
        object[5] = (int)object3;
        object3 = new short[n5];
        object3[0] = 11;
        object3[1] = 12;
        object[6] = (int)object3;
        this.a1052 = (short[][])object;
        object = new byte[8][];
        Object[] objectArray9 = object2 = new byte[12];
        Object[] objectArray10 = object2;
        objectArray9[0] = 0;
        objectArray10[1] = 1;
        objectArray9[2] = 10;
        objectArray10[3] = 2;
        objectArray9[4] = 6;
        objectArray10[5] = 3;
        objectArray9[6] = 7;
        objectArray10[7] = 4;
        objectArray9[8] = 8;
        objectArray10[9] = 5;
        objectArray9[10] = 9;
        objectArray10[11] = 21;
        object[0] = (int)object2;
        Object[] objectArray11 = object2 = new byte[7];
        Object[] objectArray12 = object2;
        objectArray11[0] = 11;
        objectArray12[1] = 12;
        objectArray11[2] = 13;
        objectArray12[3] = 14;
        objectArray11[4] = 15;
        objectArray12[5] = 22;
        objectArray12[6] = 21;
        object[n3] = (int)object2;
        Object[] objectArray13 = object2 = new byte[n4];
        object2[0] = 16;
        objectArray13[1] = 20;
        objectArray13[2] = 21;
        object[n5] = (int)object2;
        Object[] objectArray14 = object2 = new byte[n2];
        Object[] objectArray15 = object2;
        objectArray14[0] = 18;
        objectArray15[1] = 16;
        objectArray14[2] = 20;
        objectArray15[3] = 21;
        object[n4] = (int)object2;
        Object[] objectArray16 = object2 = new byte[n2];
        Object[] objectArray17 = object2;
        objectArray16[0] = 19;
        objectArray17[1] = 16;
        objectArray16[2] = 20;
        objectArray17[3] = 21;
        object[n2] = (int)object2;
        Object[] objectArray18 = object3 = new byte[n4];
        object3[0] = 17;
        objectArray18[1] = 20;
        objectArray18[2] = 21;
        object[5] = (int)object3;
        Object[] objectArray19 = object3 = new byte[n2];
        Object[] objectArray20 = object3;
        objectArray19[0] = 18;
        objectArray20[1] = 17;
        objectArray19[2] = 20;
        objectArray20[3] = 21;
        object[6] = (int)object3;
        Object[] objectArray21 = object3 = new byte[n2];
        Object[] objectArray22 = object3;
        objectArray21[0] = 19;
        objectArray22[1] = 17;
        objectArray21[2] = 20;
        objectArray22[3] = 21;
        object[7] = (int)object3;
        this.d1053 = (byte[][])object;
        Object object11 = object = (Object)new byte[9];
        Object object12 = object;
        object11[0] = 0;
        object12[1] = 8;
        object11[2] = 2;
        object12[3] = 8;
        object11[4] = 10;
        object12[5] = 2;
        object11[6] = 18;
        object12[7] = 15;
        object12[8] = 0;
        this.e1054 = (byte[])object;
        Object object13 = object = (Object)new byte[17];
        Object object14 = object;
        object13[0] = 0;
        object14[1] = 1;
        object13[2] = 2;
        object14[3] = 2;
        object13[4] = 2;
        object14[5] = 2;
        object13[6] = 2;
        object14[7] = 2;
        object13[8] = 2;
        object14[9] = 2;
        object13[10] = 2;
        object14[11] = 2;
        object13[12] = 2;
        object14[13] = 2;
        object13[14] = -1;
        object14[15] = -1;
        object14[16] = -1;
        this.f1055 = (byte[])object;
        this.a1056 = new boolean[5];
        Object object15 = object = (Object)new byte[5];
        Object object16 = object;
        object15[0] = 20;
        object16[1] = 40;
        object15[2] = 60;
        object16[3] = 80;
        object16[4] = 100;
        this.g1057 = (byte[])object;
        object = new byte[10][];
        Object[] objectArray23 = object2 = new byte[n2];
        Object[] objectArray24 = object2;
        objectArray23[0] = 84;
        objectArray24[1] = 0;
        objectArray23[2] = 21;
        objectArray24[3] = 32;
        object[0] = (int)object2;
        Object[] objectArray25 = object2 = new byte[n2];
        Object[] objectArray26 = object2;
        objectArray25[0] = 0;
        objectArray26[1] = 0;
        objectArray25[2] = 44;
        objectArray26[3] = 38;
        object[n3] = (int)object2;
        Object[] objectArray27 = object2 = new byte[n2];
        Object[] objectArray28 = object2;
        objectArray27[0] = 0;
        objectArray28[1] = 38;
        objectArray27[2] = 14;
        objectArray28[3] = 26;
        object[n5] = (int)object2;
        Object[] objectArray29 = object2 = new byte[n2];
        Object[] objectArray30 = object2;
        objectArray29[0] = 91;
        objectArray30[1] = 32;
        objectArray29[2] = 14;
        objectArray30[3] = 31;
        object[n4] = (int)object2;
        Object[] objectArray31 = object2 = new byte[n2];
        Object[] objectArray32 = object2;
        objectArray31[0] = 44;
        objectArray32[1] = 0;
        objectArray31[2] = 40;
        objectArray32[3] = 33;
        object[n2] = (int)object2;
        Object[] objectArray33 = object3 = new byte[n2];
        Object[] objectArray34 = object3;
        objectArray33[0] = 46;
        objectArray34[1] = 33;
        objectArray33[2] = 40;
        objectArray34[3] = 12;
        object[5] = (int)object3;
        Object[] objectArray35 = object3 = new byte[n2];
        Object[] objectArray36 = object3;
        objectArray35[0] = 46;
        objectArray36[1] = 41;
        objectArray35[2] = 15;
        objectArray36[3] = 9;
        object[6] = (int)object3;
        Object[] objectArray37 = object3 = new byte[n2];
        Object[] objectArray38 = object3;
        objectArray37[0] = 46;
        objectArray38[1] = 45;
        objectArray37[2] = 18;
        objectArray38[3] = 16;
        object[7] = (int)object3;
        Object[] objectArray39 = object3 = new byte[n2];
        Object[] objectArray40 = object3;
        objectArray39[0] = 71;
        objectArray40[1] = 45;
        objectArray39[2] = 20;
        objectArray40[3] = 15;
        object[8] = (int)object3;
        Object[] objectArray41 = object3 = new byte[n2];
        Object[] objectArray42 = object3;
        objectArray41[0] = 14;
        objectArray42[1] = 38;
        objectArray41[2] = 32;
        objectArray42[3] = 32;
        object[9] = (int)object3;
        this.e1058 = (byte[][])object;
        this.b1059 = new boolean[10];
        Object object17 = object = (Object)new byte[5];
        Object object18 = object;
        object17[0] = 5;
        object18[1] = 8;
        object17[2] = 0;
        object18[3] = 7;
        object18[4] = 4;
        this.h1060 = (byte[])object;
        Object object19 = object = (Object)new boolean[10];
        Object object20 = object;
        object19[0] = 0;
        object20[1] = 1;
        object19[2] = 1;
        object20[3] = 1;
        object19[4] = 0;
        object20[5] = 0;
        object19[6] = 1;
        object20[7] = 0;
        object19[8] = 0;
        object20[9] = 1;
        this.c1061 = (boolean[])object;
        Object object21 = object = (Object)new byte[20];
        Object object22 = object;
        object21[0] = 1;
        object22[1] = 5;
        object21[2] = 2;
        object22[3] = 10;
        object21[4] = 1;
        object22[5] = 8;
        object21[6] = 12;
        object22[7] = 17;
        object21[8] = -1;
        object22[9] = 0;
        object21[10] = 0;
        object22[11] = 0;
        object21[12] = 3;
        object22[13] = 7;
        object21[14] = -2;
        object22[15] = -8;
        object21[16] = 1;
        object22[17] = 4;
        object21[18] = 2;
        object22[19] = -20;
        this.i1062 = (byte[])object;
        object = new byte[n5][];
        Object[] objectArray43 = object2 = new byte[36];
        Object[] objectArray44 = object2;
        objectArray43[0] = 0;
        objectArray44[1] = 10;
        objectArray43[2] = 0;
        objectArray44[3] = 0;
        objectArray43[4] = 65;
        objectArray44[5] = 0;
        objectArray43[6] = 1;
        objectArray44[7] = 26;
        objectArray43[8] = 36;
        objectArray44[9] = 5;
        objectArray43[10] = 28;
        objectArray44[11] = 46;
        objectArray43[12] = 8;
        objectArray44[13] = 38;
        objectArray43[14] = 53;
        objectArray44[15] = 3;
        objectArray43[16] = 0;
        objectArray44[17] = 40;
        objectArray43[18] = 7;
        objectArray44[19] = -2;
        objectArray43[20] = 32;
        objectArray44[21] = 3;
        objectArray43[22] = 82;
        objectArray44[23] = 40;
        objectArray43[24] = 7;
        objectArray44[25] = 80;
        objectArray43[26] = 32;
        objectArray44[27] = 4;
        objectArray43[28] = 28;
        objectArray44[29] = 16;
        objectArray43[30] = 2;
        objectArray44[31] = 14;
        objectArray43[32] = 44;
        objectArray44[33] = 2;
        objectArray43[34] = 68;
        objectArray44[35] = 43;
        object[0] = (int)object2;
        Object[] objectArray45 = object2 = new byte[30];
        Object[] objectArray46 = object2;
        objectArray45[0] = 3;
        objectArray46[1] = 2;
        objectArray45[2] = 11;
        objectArray46[3] = 7;
        objectArray45[4] = 0;
        objectArray46[5] = 3;
        objectArray45[6] = 3;
        objectArray46[7] = 70;
        objectArray45[8] = 11;
        objectArray46[9] = 7;
        objectArray45[10] = 68;
        objectArray46[11] = 3;
        objectArray45[12] = 3;
        objectArray46[13] = 2;
        objectArray45[14] = 37;
        objectArray46[15] = 7;
        objectArray45[16] = 0;
        objectArray46[17] = 29;
        objectArray45[18] = 3;
        objectArray46[19] = 70;
        objectArray45[20] = 37;
        objectArray46[21] = 7;
        objectArray45[22] = 68;
        objectArray46[23] = 29;
        objectArray45[24] = 1;
        objectArray46[25] = 21;
        objectArray45[26] = 18;
        objectArray46[27] = 9;
        objectArray45[28] = 27;
        objectArray46[29] = 0;
        object[n3] = (int)object2;
        this.f1063 = (byte[][])object;
        object = new byte[n5];
        object[0] = 12;
        object[1] = 10;
        this.j1064 = (byte[])object;
        object = new byte[5][];
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 10;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 2;
        object2[1] = 6;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 3;
        object2[1] = 7;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 4;
        object2[1] = 8;
        object[n4] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 5;
        object2[1] = 9;
        object[n2] = (int)object2;
        this.g1065 = (byte[][])object;
        this.b1066 = (int[][])Array.newInstance(Integer.TYPE, 80, 28);
        object = new byte[9][][];
        object2 = new byte[n4][];
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 1;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 2;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 3;
        object3[1] = 3;
        object2[n5] = (byte)object3;
        object[0] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 3;
        object3[1] = 2;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 11;
        object3[1] = 2;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 7;
        object3[1] = 6;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 5;
        object3[1] = 8;
        object2[n4] = (byte)object3;
        object[n3] = (int)object2;
        object2 = new byte[10][];
        object3 = new byte[n5];
        object3[0] = 3;
        object3[1] = 5;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 5;
        object3[1] = 1;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 3;
        object3[1] = 7;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 7;
        object3[1] = 6;
        object2[n4] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 7;
        object3[1] = 1;
        object2[n2] = (byte)object3;
        Object object23 = new byte[n5];
        object23[0] = 9;
        object23[1] = 3;
        object2[5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 5;
        object2[6] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 1;
        object2[7] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 8;
        object2[8] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 11;
        object23[1] = 2;
        object2[9] = (byte)object23;
        object[n5] = (int)object2;
        object2 = new byte[12][];
        object3 = new byte[n5];
        object3[0] = 7;
        object3[1] = 6;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 3;
        object3[1] = 4;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 7;
        object3[1] = 1;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 5;
        object3[1] = 1;
        object2[n4] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 11;
        object3[1] = 8;
        object2[n2] = (byte)object3;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 7;
        object2[5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 9;
        object23[1] = 3;
        object2[6] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 11;
        object23[1] = 2;
        object2[7] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = 3;
        object2[8] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 9;
        object23[1] = 3;
        object2[9] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 4;
        object2[10] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = 3;
        object2[11] = (byte)object23;
        object[n4] = (int)object2;
        object2 = new byte[12][];
        object3 = new byte[n5];
        object3[0] = 7;
        object3[1] = 1;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 3;
        object3[1] = 7;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 11;
        object3[1] = 8;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 7;
        object3[1] = 6;
        object2[n4] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 3;
        object3[1] = 7;
        object2[n2] = (byte)object3;
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 5;
        object2[5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 3;
        object2[6] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 1;
        object23[1] = 2;
        object2[7] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = 2;
        object2[8] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 1;
        object2[9] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 1;
        object2[10] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 4;
        object2[11] = (byte)object23;
        object[n2] = (int)object2;
        object3 = new byte[12][];
        object23 = new byte[n5];
        object23[0] = 9;
        object23[1] = 3;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 3;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 4;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 11;
        object23[1] = 1;
        object3[n4] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 6;
        object3[n2] = (byte)object23;
        Object[] objectArray47 = new byte[n5];
        objectArray47[0] = 11;
        objectArray47[1] = 2;
        object3[5] = (byte)objectArray47;
        objectArray47 = new byte[n5];
        objectArray47[0] = 7;
        objectArray47[1] = 1;
        object3[6] = (byte)objectArray47;
        objectArray47 = new byte[n5];
        objectArray47[0] = 5;
        objectArray47[1] = 5;
        object3[7] = (byte)objectArray47;
        objectArray47 = new byte[n5];
        objectArray47[0] = 1;
        objectArray47[1] = 2;
        object3[8] = (byte)objectArray47;
        objectArray47 = new byte[n5];
        objectArray47[0] = 9;
        objectArray47[1] = 3;
        object3[9] = (byte)objectArray47;
        objectArray47 = new byte[n5];
        objectArray47[0] = 3;
        objectArray47[1] = 1;
        object3[10] = (byte)objectArray47;
        objectArray47 = new byte[n5];
        objectArray47[0] = 3;
        objectArray47[1] = 3;
        object3[11] = (byte)objectArray47;
        object[5] = (int)object3;
        object3 = new byte[5][];
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 3;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 11;
        object23[1] = 2;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 4;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 8;
        object3[n4] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = 6;
        object3[n2] = (byte)object23;
        object[6] = (int)object3;
        object3 = new byte[5][];
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 1;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 5;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = 1;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 5;
        object3[n4] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = 3;
        object3[n2] = (byte)object23;
        object[7] = (int)object3;
        object3 = new byte[5][];
        object23 = new byte[n5];
        object23[0] = 1;
        object23[1] = 2;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 1;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 4;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = 5;
        object3[n4] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 1;
        object3[n2] = (byte)object23;
        object[8] = (int)object3;
        this.a1067 = (byte[][][])object;
        Object object24 = object = (Object)new byte[9];
        Object object25 = object;
        object24[0] = 0;
        object25[1] = 0;
        object24[2] = 1;
        object25[3] = 2;
        object24[4] = 3;
        object25[5] = 4;
        object24[6] = 6;
        object25[7] = 5;
        object25[8] = 6;
        this.k1068 = (byte[])object;
        object = new short[9][];
        object2 = new short[n5];
        object2[0] = 136;
        object2[1] = 88;
        object[0] = (int)object2;
        object2 = new short[n5];
        object2[0] = 56;
        object2[1] = 56;
        object[n3] = (int)object2;
        object2 = new short[n5];
        object2[0] = 408;
        object2[1] = 104;
        object[n5] = (int)object2;
        object2 = new short[n5];
        object2[0] = 568;
        object2[1] = 56;
        object[n4] = (int)object2;
        object2 = new short[n5];
        object2[0] = 56;
        object2[1] = 56;
        object[n2] = (int)object2;
        object3 = new short[n5];
        object3[0] = 88;
        object3[1] = 88;
        object[5] = (int)object3;
        object3 = new short[n5];
        object3[0] = 56;
        object3[1] = 72;
        object[6] = (int)object3;
        object3 = new short[n5];
        object3[0] = 72;
        object3[1] = 72;
        object[7] = (int)object3;
        object3 = new short[n5];
        object3[0] = 456;
        object3[1] = 56;
        object[8] = (int)object3;
        this.b1069 = (short[][])object;
        object = new short[9][];
        object2 = new short[n5];
        object2[0] = 336;
        object2[1] = 64;
        object[0] = (int)object2;
        object2 = new short[n5];
        object2[0] = 64;
        object2[1] = 528;
        object[n3] = (int)object2;
        object2 = new short[n5];
        object2[0] = 160;
        object2[1] = 176;
        object[n5] = (int)object2;
        object2 = new short[n5];
        object2[0] = 560;
        object2[1] = 432;
        object[n4] = (int)object2;
        object2 = new short[n5];
        object2[0] = 592;
        object2[1] = 352;
        object[n2] = (int)object2;
        object3 = new short[n5];
        object3[0] = 256;
        object3[1] = 320;
        object[5] = (int)object3;
        object3 = new short[n5];
        object3[0] = 320;
        object3[1] = 336;
        object[6] = (int)object3;
        object3 = new short[n5];
        object3[0] = 96;
        object3[1] = 640;
        object[7] = (int)object3;
        object3 = new short[n5];
        object3[0] = 96;
        object3[1] = 32;
        object[8] = (int)object3;
        this.c1070 = (short[][])object;
        Object object26 = object = new int[9];
        Object object27 = object;
        object26[0] = 6981008;
        object27[1] = 8089212;
        object26[2] = 8089212;
        object27[3] = 9659759;
        object26[4] = 11329522;
        object27[5] = 1210262;
        object26[6] = 6981008;
        object27[7] = 11329522;
        object27[8] = 9659759;
        this.k1071 = object;
        Object object28 = object = (Object)new byte[9];
        Object object29 = object;
        object28[0] = 12;
        object29[1] = 16;
        object28[2] = 20;
        object29[3] = 24;
        object28[4] = 24;
        object29[5] = 24;
        object28[6] = 20;
        object29[7] = 20;
        object29[8] = 20;
        this.l1072 = (byte[])object;
        Object object30 = object = (Object)new boolean[9];
        Object object31 = object;
        object30[0] = 1;
        object31[1] = 0;
        object30[2] = 0;
        object31[3] = 0;
        object30[4] = 0;
        object31[5] = 0;
        object30[6] = 0;
        object31[7] = 0;
        object31[8] = 0;
        this.d1073 = (boolean[])object;
        object = new byte[n4][];
        Object object32 = object2 = new byte[7];
        Object object33 = object2;
        object32[0] = 0;
        object33[1] = 1;
        object32[2] = 2;
        object33[3] = 3;
        object32[4] = 5;
        object33[5] = 7;
        object33[6] = 8;
        object[0] = (int)object2;
        Object object34 = object2 = new byte[7];
        Object object35 = object2;
        object34[0] = 0;
        object35[1] = 1;
        object34[2] = 2;
        object35[3] = 3;
        object34[4] = 4;
        object35[5] = 6;
        object35[6] = 8;
        object[n3] = (int)object2;
        Object object36 = object2 = new byte[7];
        Object object37 = object2;
        object36[0] = 0;
        object37[1] = 1;
        object36[2] = 3;
        object37[3] = 4;
        object36[4] = 5;
        object37[5] = 6;
        object37[6] = 7;
        object[n5] = (int)object2;
        this.h1074 = (byte[][])object;
        Object object38 = object = (Object)new byte[9];
        Object object39 = object;
        object38[0] = 0;
        object39[1] = 1;
        object38[2] = 2;
        object39[3] = 3;
        object38[4] = 4;
        object39[5] = 5;
        object38[6] = 6;
        object39[7] = 4;
        object39[8] = 3;
        this.m1075 = (byte[])object;
        Object object40 = object = (Object)new byte[9];
        Object object41 = object;
        object40[0] = 0;
        object41[1] = 1;
        object40[2] = 2;
        object41[3] = 3;
        object40[4] = 4;
        object41[5] = 2;
        object40[6] = 2;
        object41[7] = 4;
        object41[8] = 3;
        this.n1076 = (byte[])object;
        this.aU = 12;
        object = new byte[6][];
        Object object42 = object2 = new byte[6];
        Object object43 = object2;
        object42[0] = 40;
        object43[1] = 4;
        object42[2] = 20;
        object43[3] = 2;
        object42[4] = 1;
        object43[5] = 2;
        object[0] = (int)object2;
        Object object44 = object2 = new byte[6];
        Object object45 = object2;
        object44[0] = 60;
        object45[1] = 6;
        object44[2] = 20;
        object45[3] = 1;
        object44[4] = 2;
        object45[5] = 2;
        object[n3] = (int)object2;
        Object object46 = object2 = new byte[6];
        Object object47 = object2;
        object46[0] = 100;
        object47[1] = 10;
        object46[2] = 15;
        object47[3] = 1;
        object46[4] = 3;
        object47[5] = 1;
        object[n5] = (int)object2;
        Object object48 = object2 = new byte[6];
        Object object49 = object2;
        object48[0] = 80;
        object49[1] = 8;
        object48[2] = 10;
        object49[3] = 1;
        object48[4] = 2;
        object49[5] = 4;
        object[n4] = (int)object2;
        Object object50 = object2 = new byte[6];
        Object object51 = object2;
        object50[0] = 40;
        object51[1] = 4;
        object50[2] = 10;
        object51[3] = 1;
        object50[4] = 1;
        object51[5] = 2;
        object[n2] = (int)object2;
        Object object52 = object3 = new byte[6];
        Object object53 = object3;
        object52[0] = 120;
        object53[1] = 15;
        object52[2] = 20;
        object53[3] = 3;
        object52[4] = 0;
        object53[5] = 2;
        object[5] = (int)object3;
        this.i1079 = (byte[][])object;
        object = new byte[9][];
        Object object54 = object2 = new byte[6];
        Object object55 = object2;
        object54[0] = 9;
        object55[1] = 14;
        object54[2] = 16;
        object55[3] = 17;
        object54[4] = 18;
        object55[5] = 20;
        object[0] = (int)object2;
        Object object56 = object2 = new byte[6];
        Object object57 = object2;
        object56[0] = 4;
        object57[1] = 9;
        object56[2] = 14;
        object57[3] = 17;
        object56[4] = 18;
        object57[5] = 20;
        object[n3] = (int)object2;
        Object object58 = object2 = new byte[6];
        Object object59 = object2;
        object58[0] = 1;
        object59[1] = 8;
        object58[2] = 11;
        object59[3] = 18;
        object58[4] = 19;
        object59[5] = 20;
        object[n5] = (int)object2;
        Object object60 = object2 = new byte[6];
        Object object61 = object2;
        object60[0] = 3;
        object61[1] = 7;
        object60[2] = 11;
        object61[3] = 15;
        object60[4] = 16;
        object61[5] = 20;
        object[n4] = (int)object2;
        Object object62 = object2 = new byte[6];
        Object object63 = object2;
        object62[0] = 1;
        object63[1] = 8;
        object62[2] = 11;
        object63[3] = 16;
        object62[4] = 17;
        object63[5] = 20;
        object[n2] = (int)object2;
        Object object64 = object3 = new byte[6];
        Object object65 = object3;
        object64[0] = 0;
        object65[1] = 5;
        object64[2] = 10;
        object65[3] = 14;
        object64[4] = 15;
        object65[5] = 20;
        object[5] = (int)object3;
        Object object66 = object3 = new byte[6];
        Object object67 = object3;
        object66[0] = 0;
        object67[1] = 3;
        object66[2] = 12;
        object67[3] = 18;
        object66[4] = 19;
        object67[5] = 20;
        object[6] = (int)object3;
        Object object68 = object3 = new byte[6];
        Object object69 = object3;
        object68[0] = 0;
        object69[1] = 1;
        object68[2] = 6;
        object69[3] = 15;
        object68[4] = 16;
        object69[5] = 20;
        object[7] = (int)object3;
        Object object70 = object3 = new byte[6];
        Object object71 = object3;
        object70[0] = 0;
        object71[1] = 2;
        object70[2] = 7;
        object71[3] = 10;
        object70[4] = 11;
        object71[5] = 20;
        object[8] = (int)object3;
        this.j1080 = (byte[][])object;
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = -1;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 0;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = 1;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -1;
        object2[1] = 0;
        object[n4] = (int)object2;
        this.k1081 = (byte[][])object;
        object = new byte[6][];
        Object object72 = object2 = new byte[n2];
        Object object73 = object2;
        object72[0] = 0;
        object73[1] = 1;
        object72[2] = 2;
        object73[3] = 1;
        object[0] = (int)object2;
        Object object74 = object2 = new byte[n2];
        Object object75 = object2;
        object74[0] = 0;
        object75[1] = 1;
        object74[2] = 2;
        object75[3] = 1;
        object[n3] = (int)object2;
        Object object76 = object2 = new byte[8];
        Object object77 = object2;
        object76[0] = 0;
        object77[1] = 0;
        object76[2] = 1;
        object77[3] = 1;
        object76[4] = 2;
        object77[5] = 2;
        object76[6] = 1;
        object77[7] = 1;
        object[n5] = (int)object2;
        Object object78 = object2 = new byte[n4];
        object2[0] = 0;
        object78[1] = 1;
        object78[2] = 2;
        object[n4] = (int)object2;
        Object object79 = object2 = new byte[n2];
        Object object80 = object2;
        object79[0] = 0;
        object80[1] = 1;
        object79[2] = 2;
        object80[3] = 1;
        object[n2] = (int)object2;
        Object object81 = object3 = new byte[n2];
        Object object82 = object3;
        object81[0] = 0;
        object82[1] = 1;
        object81[2] = 2;
        object82[3] = 1;
        object[5] = (int)object3;
        this.l1083 = (byte[][])object;
        object = new byte[n2][];
        Object object83 = object2 = new byte[n2];
        Object object84 = object2;
        object83[0] = 1;
        object84[1] = -1;
        object83[2] = 0;
        object84[3] = -16;
        object[0] = (int)object2;
        Object object85 = object2 = new byte[n2];
        Object object86 = object2;
        object85[0] = 1;
        object86[1] = 1;
        object85[2] = 48;
        object86[3] = 0;
        object[n3] = (int)object2;
        Object object87 = object2 = new byte[n2];
        Object object88 = object2;
        object87[0] = 1;
        object88[1] = 1;
        object87[2] = 0;
        object88[3] = 64;
        object[n5] = (int)object2;
        Object object89 = object2 = new byte[n2];
        Object object90 = object2;
        object89[0] = -1;
        object90[1] = 1;
        object89[2] = -16;
        object90[3] = 0;
        object[n4] = (int)object2;
        this.m1084 = (byte[][])object;
        object = new byte[n4][][];
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 0;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = -1;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 0;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 1;
        object2[n4] = (byte)object3;
        object[0] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 0;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -1;
        object3[1] = 0;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 1;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -1;
        object3[1] = 1;
        object2[n4] = (byte)object3;
        object[n3] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 0;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 1;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -1;
        object3[1] = 0;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -1;
        object3[1] = -1;
        object2[n4] = (byte)object3;
        object[n5] = (int)object2;
        this.b1085 = (byte[][][])object;
        object = new byte[12][][];
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 8;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 8;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 8;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 8;
        object2[n4] = (byte)object3;
        object[0] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 8;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 8;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 8;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 8;
        object2[n4] = (byte)object3;
        object[n3] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 9;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 9;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 9;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 9;
        object2[n4] = (byte)object3;
        object[n5] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 2;
        object3[1] = 9;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 2;
        object3[1] = 9;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 2;
        object3[1] = 9;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 9;
        object2[n4] = (byte)object3;
        object[n4] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 3;
        object3[1] = 8;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 8;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 8;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 3;
        object3[1] = 8;
        object2[n4] = (byte)object3;
        object[n2] = (int)object2;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 9;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 2;
        object23[1] = 9;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 2;
        object23[1] = 9;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 9;
        object3[n4] = (byte)object23;
        object[5] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = 2;
        object23[1] = 16;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 16;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 16;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = 16;
        object3[n4] = (byte)object23;
        object[6] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = 2;
        object23[1] = 16;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 7;
        object23[1] = 16;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 16;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = 16;
        object3[n4] = (byte)object23;
        object[7] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 9;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 9;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = 9;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 2;
        object23[1] = 9;
        object3[n4] = (byte)object23;
        object[8] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 9;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 3;
        object23[1] = 9;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = 9;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 2;
        object23[1] = 9;
        object3[n4] = (byte)object23;
        object[9] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = 2;
        object23[1] = 10;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 2;
        object23[1] = 10;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 0;
        object23[1] = 10;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 2;
        object23[1] = 10;
        object3[n4] = (byte)object23;
        object[10] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = 4;
        object23[1] = 12;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 2;
        object23[1] = 12;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 0;
        object23[1] = 12;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 2;
        object23[1] = 12;
        object3[n4] = (byte)object23;
        object[11] = (int)object3;
        this.c1090 = (byte[][][])object;
        object = new byte[12][][];
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = -7;
        object3[1] = -12;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -7;
        object3[1] = -12;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -7;
        object3[1] = -12;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -6;
        object3[1] = -12;
        object2[n4] = (byte)object3;
        object[0] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = -7;
        object3[1] = -12;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -7;
        object3[1] = -12;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -7;
        object3[1] = -12;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -6;
        object3[1] = -12;
        object2[n4] = (byte)object3;
        object[n3] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = -7;
        object3[1] = -13;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -7;
        object3[1] = -13;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -7;
        object3[1] = -13;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -6;
        object3[1] = -13;
        object2[n4] = (byte)object3;
        object[n5] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = -8;
        object3[1] = -13;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -8;
        object3[1] = -13;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -8;
        object3[1] = -13;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -8;
        object3[1] = -13;
        object2[n4] = (byte)object3;
        object[n4] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = -9;
        object3[1] = -12;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -7;
        object3[1] = -12;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -7;
        object3[1] = -12;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -9;
        object3[1] = -12;
        object2[n4] = (byte)object3;
        object[n2] = (int)object2;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = -9;
        object23[1] = -13;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -13;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -13;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -9;
        object23[1] = -13;
        object3[n4] = (byte)object23;
        object[5] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -20;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -13;
        object23[1] = -20;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -9;
        object23[1] = -20;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -11;
        object23[1] = -20;
        object3[n4] = (byte)object23;
        object[6] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -20;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -13;
        object23[1] = -20;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -9;
        object23[1] = -20;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -11;
        object23[1] = -20;
        object3[n4] = (byte)object23;
        object[7] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = -9;
        object23[1] = -13;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -9;
        object23[1] = -13;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -11;
        object23[1] = -13;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -13;
        object3[n4] = (byte)object23;
        object[8] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = -9;
        object23[1] = -13;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -9;
        object23[1] = -13;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -11;
        object23[1] = -13;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -13;
        object3[n4] = (byte)object23;
        object[9] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -14;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -14;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -6;
        object23[1] = -14;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -14;
        object3[n4] = (byte)object23;
        object[10] = (int)object3;
        object3 = new byte[n2][];
        object23 = new byte[n5];
        object23[0] = -10;
        object23[1] = -16;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -16;
        object3[n3] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -6;
        object23[1] = -16;
        object3[n5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -16;
        object3[n4] = (byte)object23;
        object[11] = (int)object3;
        this.d1091 = (byte[][][])object;
        object = new short[12][][][];
        object2 = new short[n2][][];
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 0;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 13;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 26;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[0] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 39;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 52;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 65;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[n3] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 78;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 91;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 104;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[n5] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 65;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 52;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 39;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[n4] = (byte)object3;
        object[0] = (int)object2;
        object2 = new short[n2][][];
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 0;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 13;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 26;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[0] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 39;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 52;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 65;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[n3] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 78;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 91;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 104;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[n5] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 65;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 52;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 39;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[n4] = (byte)object3;
        object[n3] = (int)object2;
        object2 = new short[n2][][];
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 0;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 13;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 26;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[0] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 39;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 52;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 65;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[n3] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 78;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 91;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 104;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[n5] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 65;
        object23[1] = 13;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 52;
        object23[1] = 13;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 39;
        object23[1] = 13;
        object3[n5] = (byte)object23;
        object2[n4] = (byte)object3;
        object[n5] = (int)object2;
        object2 = new short[n2][][];
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 0;
        object23[1] = 16;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 16;
        object23[1] = 16;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 32;
        object23[1] = 16;
        object3[n5] = (byte)object23;
        object2[0] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 48;
        object23[1] = 16;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 64;
        object23[1] = 16;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 80;
        object23[1] = 16;
        object3[n5] = (byte)object23;
        object2[n3] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 96;
        object23[1] = 16;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 112;
        object23[1] = 16;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 128;
        object23[1] = 16;
        object3[n5] = (byte)object23;
        object2[n5] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 80;
        object23[1] = 16;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 64;
        object23[1] = 16;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 48;
        object23[1] = 16;
        object3[n5] = (byte)object23;
        object2[n4] = (byte)object3;
        object[n4] = (int)object2;
        object2 = new short[n2][][];
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 0;
        object23[1] = 16;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 16;
        object23[1] = 16;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 32;
        object23[1] = 16;
        object3[n5] = (byte)object23;
        object2[0] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 48;
        object23[1] = 16;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 64;
        object23[1] = 16;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 80;
        object23[1] = 16;
        object3[n5] = (byte)object23;
        object2[n3] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 96;
        object23[1] = 16;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 112;
        object23[1] = 16;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 128;
        object23[1] = 16;
        object3[n5] = (byte)object23;
        object2[n5] = (byte)object3;
        object3 = new short[n4][];
        object23 = new short[n5];
        object23[0] = 80;
        object23[1] = 16;
        object3[0] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 64;
        object23[1] = 16;
        object3[n3] = (byte)object23;
        object23 = new short[n5];
        object23[0] = 48;
        object23[1] = 16;
        object3[n5] = (byte)object23;
        object2[n4] = (byte)object3;
        object[n2] = (int)object2;
        object3 = new short[n2][][];
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 0;
        objectArray47[1] = 16;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 16;
        objectArray47[1] = 16;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 32;
        objectArray47[1] = 16;
        object23[n5] = (byte)objectArray47;
        object3[0] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 48;
        objectArray47[1] = 17;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 65;
        objectArray47[1] = 17;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 82;
        objectArray47[1] = 17;
        object23[n5] = (byte)objectArray47;
        object3[n3] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 99;
        objectArray47[1] = 17;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 116;
        objectArray47[1] = 17;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 133;
        objectArray47[1] = 17;
        object23[n5] = (byte)objectArray47;
        object3[n5] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 85;
        objectArray47[1] = 17;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 68;
        objectArray47[1] = 17;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 51;
        objectArray47[1] = 17;
        object23[n5] = (byte)objectArray47;
        object3[n4] = (byte)object23;
        object[5] = (int)object3;
        object3 = new short[n2][][];
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 0;
        objectArray47[1] = 16;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 16;
        objectArray47[1] = 16;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 32;
        objectArray47[1] = 16;
        object23[n5] = (byte)objectArray47;
        object3[0] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 48;
        objectArray47[1] = 24;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 72;
        objectArray47[1] = 24;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 96;
        objectArray47[1] = 24;
        object23[n5] = (byte)objectArray47;
        object3[n3] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 120;
        objectArray47[1] = 17;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 137;
        objectArray47[1] = 17;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 154;
        objectArray47[1] = 17;
        object23[n5] = (byte)objectArray47;
        object3[n5] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 99;
        objectArray47[1] = 24;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 75;
        objectArray47[1] = 24;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 51;
        objectArray47[1] = 24;
        object23[n5] = (byte)objectArray47;
        object3[n4] = (byte)object23;
        object[6] = (int)object3;
        object3 = new short[n2][][];
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 0;
        objectArray47[1] = 16;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 16;
        objectArray47[1] = 16;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 32;
        objectArray47[1] = 16;
        object23[n5] = (byte)objectArray47;
        object3[0] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 48;
        objectArray47[1] = 24;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 72;
        objectArray47[1] = 24;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 96;
        objectArray47[1] = 24;
        object23[n5] = (byte)objectArray47;
        object3[n3] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 120;
        objectArray47[1] = 17;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 137;
        objectArray47[1] = 17;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 154;
        objectArray47[1] = 17;
        object23[n5] = (byte)objectArray47;
        object3[n5] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 99;
        objectArray47[1] = 24;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 75;
        objectArray47[1] = 24;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 51;
        objectArray47[1] = 24;
        object23[n5] = (byte)objectArray47;
        object3[n4] = (byte)object23;
        object[7] = (int)object3;
        object3 = new short[n2][][];
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 0;
        objectArray47[1] = 20;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 20;
        objectArray47[1] = 20;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 40;
        objectArray47[1] = 20;
        object23[n5] = (byte)objectArray47;
        object3[0] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 60;
        objectArray47[1] = 17;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 77;
        objectArray47[1] = 17;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 94;
        objectArray47[1] = 17;
        object23[n5] = (byte)objectArray47;
        object3[n3] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 111;
        objectArray47[1] = 19;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 130;
        objectArray47[1] = 19;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 149;
        objectArray47[1] = 19;
        object23[n5] = (byte)objectArray47;
        object3[n5] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 91;
        objectArray47[1] = 17;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 74;
        objectArray47[1] = 17;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 57;
        objectArray47[1] = 17;
        object23[n5] = (byte)objectArray47;
        object3[n4] = (byte)object23;
        object[8] = (int)object3;
        object3 = new short[n2][][];
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 0;
        objectArray47[1] = 20;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 20;
        objectArray47[1] = 20;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 40;
        objectArray47[1] = 20;
        object23[n5] = (byte)objectArray47;
        object3[0] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 60;
        objectArray47[1] = 17;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 77;
        objectArray47[1] = 17;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 94;
        objectArray47[1] = 17;
        object23[n5] = (byte)objectArray47;
        object3[n3] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 111;
        objectArray47[1] = 19;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 130;
        objectArray47[1] = 19;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 149;
        objectArray47[1] = 19;
        object23[n5] = (byte)objectArray47;
        object3[n5] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 91;
        objectArray47[1] = 17;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 74;
        objectArray47[1] = 17;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 57;
        objectArray47[1] = 17;
        object23[n5] = (byte)objectArray47;
        object3[n4] = (byte)object23;
        object[9] = (int)object3;
        object3 = new short[n2][][];
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 0;
        objectArray47[1] = 14;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 14;
        objectArray47[1] = 14;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 28;
        objectArray47[1] = 14;
        object23[n5] = (byte)objectArray47;
        object3[0] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 42;
        objectArray47[1] = 16;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 58;
        objectArray47[1] = 16;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 74;
        objectArray47[1] = 16;
        object23[n5] = (byte)objectArray47;
        object3[n3] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 90;
        objectArray47[1] = 14;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 104;
        objectArray47[1] = 14;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 118;
        objectArray47[1] = 14;
        object23[n5] = (byte)objectArray47;
        object3[n5] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 74;
        objectArray47[1] = 16;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 58;
        objectArray47[1] = 16;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 42;
        objectArray47[1] = 16;
        object23[n5] = (byte)objectArray47;
        object3[n4] = (byte)object23;
        object[10] = (int)object3;
        object3 = new short[n2][][];
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 0;
        objectArray47[1] = 16;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 16;
        objectArray47[1] = 16;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 32;
        objectArray47[1] = 16;
        object23[n5] = (byte)objectArray47;
        object3[0] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 48;
        objectArray47[1] = 16;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 64;
        objectArray47[1] = 16;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 80;
        objectArray47[1] = 16;
        object23[n5] = (byte)objectArray47;
        object3[n3] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 96;
        objectArray47[1] = 16;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 112;
        objectArray47[1] = 16;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 128;
        objectArray47[1] = 16;
        object23[n5] = (byte)objectArray47;
        object3[n5] = (byte)object23;
        object23 = new short[n4][];
        objectArray47 = new short[n5];
        objectArray47[0] = 80;
        objectArray47[1] = 16;
        object23[0] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 64;
        objectArray47[1] = 16;
        object23[n3] = (byte)objectArray47;
        objectArray47 = new short[n5];
        objectArray47[0] = 48;
        objectArray47[1] = 16;
        object23[n5] = (byte)objectArray47;
        object3[n4] = (byte)object23;
        object[11] = (int)object3;
        this.a1092 = (short[][][][])object;
        object = new byte[n2][][];
        object2 = new byte[7][];
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 2;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 9;
        object3[1] = 4;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 17;
        object3[1] = 1;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 1;
        object3[1] = 14;
        object2[n4] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 12;
        object3[1] = 13;
        object2[n2] = (byte)object3;
        object23 = new byte[n5];
        object23[0] = 19;
        object23[1] = 13;
        object2[5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 8;
        object23[1] = 19;
        object2[6] = (byte)object23;
        object[0] = (int)object2;
        object2 = new byte[7][];
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 1;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 8;
        object3[1] = 3;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 18;
        object3[1] = -1;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 14;
        object2[n4] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 13;
        object3[1] = 15;
        object2[n2] = (byte)object3;
        object23 = new byte[n5];
        object23[0] = 20;
        object23[1] = 13;
        object2[5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 8;
        object23[1] = 20;
        object2[6] = (byte)object23;
        object[n3] = (int)object2;
        object2 = new byte[7][];
        object3 = new byte[n5];
        object3[0] = -1;
        object3[1] = 0;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 8;
        object3[1] = 2;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 18;
        object3[1] = -1;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -1;
        object3[1] = 15;
        object2[n4] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 13;
        object3[1] = 15;
        object2[n2] = (byte)object3;
        object23 = new byte[n5];
        object23[0] = 21;
        object23[1] = 14;
        object2[5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 8;
        object23[1] = 21;
        object2[6] = (byte)object23;
        object[n5] = (int)object2;
        object2 = new byte[7][];
        object3 = new byte[n5];
        object3[0] = -1;
        object3[1] = 0;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 8;
        object3[1] = 2;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 18;
        object3[1] = -1;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -1;
        object3[1] = 15;
        object2[n4] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 13;
        object3[1] = 15;
        object2[n2] = (byte)object3;
        object23 = new byte[n5];
        object23[0] = 21;
        object23[1] = 14;
        object2[5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 8;
        object23[1] = 21;
        object2[6] = (byte)object23;
        object[n4] = (int)object2;
        this.e1093 = (byte[][][])object;
        object = new byte[6][];
        Object object91 = object2 = new byte[6];
        Object object92 = object2;
        object91[0] = 0;
        object92[1] = 0;
        object91[2] = 17;
        object92[3] = 6;
        object91[4] = 0;
        object92[5] = 17;
        object[0] = (int)object2;
        Object object93 = object2 = new byte[6];
        Object object94 = object2;
        object93[0] = 0;
        object94[1] = 6;
        object93[2] = 17;
        object94[3] = 7;
        object93[4] = 0;
        object94[5] = 16;
        object[n3] = (int)object2;
        Object object95 = object2 = new byte[6];
        Object object96 = object2;
        object95[0] = 0;
        object96[1] = 13;
        object95[2] = 17;
        object96[3] = 10;
        object95[4] = 0;
        object96[5] = 12;
        object[n5] = (int)object2;
        Object object97 = object2 = new byte[6];
        Object object98 = object2;
        object97[0] = 0;
        object98[1] = 23;
        object97[2] = 17;
        object98[3] = 12;
        object97[4] = 0;
        object98[5] = 5;
        object[n4] = (int)object2;
        Object object99 = object2 = new byte[6];
        Object object100 = object2;
        object99[0] = 0;
        object100[1] = 34;
        object99[2] = 17;
        object100[3] = 9;
        object99[4] = 0;
        object100[5] = 0;
        object[n2] = (int)object2;
        Object object101 = object3 = new byte[6];
        Object object102 = object3;
        object101[0] = 0;
        object102[1] = 43;
        object101[2] = 17;
        object102[3] = 7;
        object101[4] = 0;
        object102[5] = 0;
        object[5] = (int)object3;
        this.n1094 = (byte[][])object;
        object = new byte[8][];
        Object object103 = object2 = new byte[5];
        Object object104 = object2;
        object103[0] = 19;
        object104[1] = 15;
        object103[2] = 6;
        object104[3] = -9;
        object104[4] = -5;
        object[0] = (int)object2;
        Object object105 = object2 = new byte[5];
        Object object106 = object2;
        object105[0] = 19;
        object106[1] = 15;
        object105[2] = 6;
        object106[3] = -9;
        object106[4] = -5;
        object[n3] = (int)object2;
        Object object107 = object2 = new byte[5];
        Object object108 = object2;
        object107[0] = 19;
        object108[1] = 15;
        object107[2] = 6;
        object108[3] = -9;
        object108[4] = -5;
        object[n5] = (int)object2;
        Object object109 = object2 = new byte[5];
        Object object110 = object2;
        object109[0] = 19;
        object110[1] = 21;
        object109[2] = 4;
        object110[3] = -9;
        object110[4] = -11;
        object[n4] = (int)object2;
        Object object111 = object2 = new byte[5];
        Object object112 = object2;
        object111[0] = 19;
        object112[1] = 21;
        object111[2] = 4;
        object112[3] = -9;
        object112[4] = -11;
        object[n2] = (int)object2;
        Object object113 = object3 = new byte[5];
        Object object114 = object3;
        object113[0] = 20;
        object114[1] = 20;
        object113[2] = 7;
        object114[3] = -11;
        object114[4] = -11;
        object[5] = (int)object3;
        Object object115 = object3 = new byte[5];
        Object object116 = object3;
        object115[0] = 19;
        object116[1] = 15;
        object115[2] = 4;
        object116[3] = -9;
        object116[4] = -5;
        object[6] = (int)object3;
        Object object117 = object3 = new byte[5];
        Object object118 = object3;
        object117[0] = 20;
        object118[1] = 20;
        object117[2] = 7;
        object118[3] = -11;
        object118[4] = -11;
        object[7] = (int)object3;
        this.o1095 = (byte[][])object;
        Object object119 = object = (Object)new byte[11];
        Object object120 = object;
        object119[0] = 2;
        object120[1] = 2;
        object119[2] = 3;
        object120[3] = 2;
        object119[4] = 2;
        object120[5] = 3;
        object119[6] = 3;
        object120[7] = 3;
        object119[8] = 3;
        object120[9] = 3;
        object120[10] = 3;
        this.o1098 = (byte[])object;
        Object object121 = object = (Object)new byte[11];
        Object object122 = object;
        object121[0] = 0;
        object122[1] = 0;
        object121[2] = 1;
        object122[3] = 0;
        object121[4] = 0;
        object122[5] = 0;
        object121[6] = 1;
        object122[7] = 0;
        object121[8] = 1;
        object122[9] = 1;
        object122[10] = 1;
        this.p1099 = (byte[])object;
        Object object123 = object = (Object)new byte[11];
        Object object124 = object;
        object123[0] = 20;
        object124[1] = 30;
        object123[2] = 40;
        object124[3] = 50;
        object123[4] = 40;
        object124[5] = 80;
        object123[6] = 40;
        object124[7] = 50;
        object123[8] = 60;
        object124[9] = 80;
        object124[10] = 30;
        this.q1100 = (byte[])object;
        Object object125 = object = (Object)new byte[22];
        Object object126 = object;
        object125[0] = 10;
        object126[1] = 2;
        object125[2] = 15;
        object126[3] = 3;
        object125[4] = 20;
        object126[5] = 4;
        object125[6] = 20;
        object126[7] = 5;
        object125[8] = 10;
        object126[9] = 5;
        object125[10] = 30;
        object126[11] = 5;
        object125[12] = 10;
        object126[13] = 5;
        object125[14] = 20;
        object126[15] = 5;
        object125[16] = 20;
        object126[17] = 5;
        object125[18] = 30;
        object126[19] = 5;
        object125[20] = 20;
        object126[21] = 5;
        this.r1101 = (byte[])object;
        Object object127 = object = (Object)new byte[22];
        Object object128 = object;
        object127[0] = 15;
        object128[1] = 5;
        object127[2] = 10;
        object128[3] = 3;
        object127[4] = 30;
        object128[5] = 10;
        object127[6] = 15;
        object128[7] = 5;
        object127[8] = 15;
        object128[9] = 5;
        object127[10] = 60;
        object128[11] = 10;
        object127[12] = 20;
        object128[13] = 10;
        object127[14] = 30;
        object128[15] = 10;
        object127[16] = 40;
        object128[17] = 8;
        object127[18] = 60;
        object128[19] = 15;
        object127[20] = 50;
        object128[21] = 10;
        this.s1102 = (byte[])object;
        Object object129 = object = (Object)new byte[22];
        Object object130 = object;
        object129[0] = 64;
        object130[1] = 8;
        object129[2] = 48;
        object130[3] = 4;
        object129[4] = 0;
        object130[5] = 0;
        object129[6] = 64;
        object130[7] = 6;
        object129[8] = 56;
        object130[9] = 6;
        object129[10] = 64;
        object130[11] = 8;
        object129[12] = 0;
        object130[13] = 0;
        object129[14] = 48;
        object130[15] = 8;
        object129[16] = 64;
        object130[17] = 4;
        object129[18] = 64;
        object130[19] = 4;
        object129[20] = 0;
        object130[21] = 0;
        this.t1103 = (byte[])object;
        Object object131 = object = (Object)new byte[22];
        Object object132 = object;
        object131[0] = 20;
        object132[1] = -2;
        object131[2] = 30;
        object132[3] = -3;
        object131[4] = 60;
        object132[5] = -4;
        object131[6] = 25;
        object132[7] = -2;
        object131[8] = 30;
        object132[9] = -2;
        object131[10] = 30;
        object132[11] = -2;
        object131[12] = 60;
        object132[13] = -4;
        object131[14] = 30;
        object132[15] = -2;
        object131[16] = 80;
        object132[17] = -6;
        object131[18] = 100;
        object132[19] = -5;
        object131[20] = 0;
        object132[21] = 0;
        this.u1104 = (byte[])object;
        this.e1105 = new boolean[11];
        this.f1106 = new boolean[11];
        this.c1107 = (int[][])Array.newInstance(Integer.TYPE, 30, 18);
        object = new byte[5][];
        Object object133 = object2 = new byte[14];
        Object object134 = object2;
        object133[0] = -26;
        object134[1] = -25;
        object133[2] = -8;
        object134[3] = -20;
        object133[4] = -26;
        object134[5] = 2;
        object133[6] = 11;
        object134[7] = -29;
        object133[8] = 1;
        object134[9] = 2;
        object133[10] = 17;
        object134[11] = 0;
        object133[12] = -10;
        object134[13] = 14;
        object[0] = (int)object2;
        Object object135 = object2 = new byte[14];
        Object object136 = object2;
        object135[0] = -30;
        object136[1] = -29;
        object135[2] = -9;
        object136[3] = -24;
        object135[4] = -29;
        object136[5] = 4;
        object135[6] = 14;
        object136[7] = -32;
        object135[8] = 2;
        object136[9] = 6;
        object135[10] = 20;
        object136[11] = 2;
        object135[12] = -10;
        object136[13] = 19;
        object[n3] = (int)object2;
        Object object137 = object2 = new byte[14];
        Object object138 = object2;
        object137[0] = -33;
        object138[1] = -31;
        object137[2] = -10;
        object138[3] = -26;
        object137[4] = -32;
        object138[5] = 6;
        object137[6] = 16;
        object138[7] = -34;
        object137[8] = 3;
        object138[9] = 8;
        object137[10] = 22;
        object138[11] = 4;
        object137[12] = -10;
        object138[13] = 22;
        object[n5] = (int)object2;
        Object object139 = object2 = new byte[14];
        Object object140 = object2;
        object139[0] = -34;
        object140[1] = -32;
        object139[2] = -11;
        object140[3] = -27;
        object139[4] = -33;
        object140[5] = 7;
        object139[6] = 17;
        object140[7] = -35;
        object139[8] = 4;
        object140[9] = 9;
        object139[10] = 23;
        object140[11] = 5;
        object139[12] = -10;
        object140[13] = 23;
        object[n4] = (int)object2;
        Object object141 = object2 = new byte[14];
        Object object142 = object2;
        object141[0] = -34;
        object142[1] = -32;
        object141[2] = -11;
        object142[3] = -27;
        object141[4] = -33;
        object142[5] = 7;
        object141[6] = 17;
        object142[7] = -35;
        object141[8] = 4;
        object142[9] = 9;
        object141[10] = 23;
        object142[11] = 5;
        object141[12] = -10;
        object142[13] = 23;
        object[n2] = (int)object2;
        this.p1108 = (byte[][])object;
        Object object143 = object = (Object)new byte[5];
        Object object144 = object;
        object143[0] = 6;
        object144[1] = 4;
        object143[2] = 3;
        object144[3] = 2;
        object144[4] = 1;
        this.v1109 = (byte[])object;
        Object object145 = object = (Object)new byte[8];
        Object object146 = object;
        object145[0] = -13;
        object146[1] = -43;
        object145[2] = -24;
        object146[3] = -32;
        object145[4] = -4;
        object146[5] = -32;
        object145[6] = -13;
        object146[7] = -22;
        this.w1110 = (byte[])object;
        object = new byte[11][][];
        object2 = new byte[n2][];
        Object object147 = object3 = new byte[n2];
        Object object148 = object3;
        object147[0] = 0;
        object148[1] = 0;
        object147[2] = 26;
        object148[3] = 24;
        object2[0] = (byte)object3;
        Object object149 = object3 = new byte[n2];
        Object object150 = object3;
        object149[0] = 26;
        object150[1] = 0;
        object149[2] = 22;
        object150[3] = 16;
        object2[n3] = (byte)object3;
        Object object151 = object3 = new byte[n2];
        Object object152 = object3;
        object151[0] = 0;
        object152[1] = 24;
        object151[2] = 32;
        object152[3] = 26;
        object2[n5] = (byte)object3;
        Object object153 = object3 = new byte[n2];
        Object object154 = object3;
        object153[0] = 32;
        object154[1] = 16;
        object153[2] = 32;
        object154[3] = 34;
        object2[n4] = (byte)object3;
        object[0] = (int)object2;
        object2 = new byte[n2][];
        Object object155 = object3 = new byte[n2];
        Object object156 = object3;
        object155[0] = 0;
        object156[1] = 0;
        object155[2] = 24;
        object156[3] = 24;
        object2[0] = (byte)object3;
        Object object157 = object3 = new byte[n2];
        Object object158 = object3;
        object157[0] = 0;
        object158[1] = 24;
        object157[2] = 30;
        object158[3] = 27;
        object2[n3] = (byte)object3;
        Object object159 = object3 = new byte[n2];
        Object object160 = object3;
        object159[0] = 24;
        object160[1] = 0;
        object159[2] = 22;
        object160[3] = 16;
        object2[n5] = (byte)object3;
        Object object161 = object3 = new byte[n2];
        Object object162 = object3;
        object161[0] = 30;
        object162[1] = 16;
        object161[2] = 32;
        object162[3] = 33;
        object2[n4] = (byte)object3;
        object[n3] = (int)object2;
        object2 = new byte[5][];
        Object object163 = object3 = new byte[n2];
        Object object164 = object3;
        object163[0] = 0;
        object164[1] = 0;
        object163[2] = 28;
        object164[3] = 16;
        object2[0] = (byte)object3;
        Object object165 = object3 = new byte[n2];
        Object object166 = object3;
        object165[0] = 28;
        object166[1] = 0;
        object165[2] = 20;
        object166[3] = 15;
        object2[n3] = (byte)object3;
        Object object167 = object3 = new byte[n2];
        Object object168 = object3;
        object167[0] = 0;
        object168[1] = 16;
        object167[2] = 28;
        object168[3] = 12;
        object2[n5] = (byte)object3;
        Object object169 = object3 = new byte[n2];
        Object object170 = object3;
        object169[0] = 0;
        object170[1] = 28;
        object169[2] = 28;
        object170[3] = 22;
        object2[n4] = (byte)object3;
        Object object171 = object3 = new byte[n2];
        Object object172 = object3;
        object171[0] = 28;
        object172[1] = 26;
        object171[2] = 32;
        object172[3] = 24;
        object2[n2] = (byte)object3;
        object[n5] = (int)object2;
        object2 = new byte[n4][];
        Object object173 = object3 = new byte[n2];
        Object object174 = object3;
        object173[0] = 0;
        object174[1] = 0;
        object173[2] = 22;
        object174[3] = 32;
        object2[0] = (byte)object3;
        Object object175 = object3 = new byte[n2];
        Object object176 = object3;
        object175[0] = 22;
        object176[1] = 0;
        object175[2] = 32;
        object176[3] = 41;
        object2[n3] = (byte)object3;
        Object object177 = object3 = new byte[n2];
        Object object178 = object3;
        object177[0] = 54;
        object178[1] = 0;
        object177[2] = 32;
        object178[3] = 35;
        object2[n5] = (byte)object3;
        object[n4] = (int)object2;
        object2 = new byte[5][];
        Object object179 = object3 = new byte[n2];
        Object object180 = object3;
        object179[0] = 0;
        object180[1] = 0;
        object179[2] = 18;
        object180[3] = 16;
        object2[0] = (byte)object3;
        Object object181 = object3 = new byte[n2];
        Object object182 = object3;
        object181[0] = 0;
        object182[1] = 16;
        object181[2] = 26;
        object182[3] = 20;
        object2[n3] = (byte)object3;
        Object object183 = object3 = new byte[n2];
        Object object184 = object3;
        object183[0] = 0;
        object184[1] = 36;
        object183[2] = 32;
        object184[3] = 11;
        object2[n5] = (byte)object3;
        Object object185 = object3 = new byte[n2];
        Object object186 = object3;
        object185[0] = 0;
        object186[1] = 47;
        object185[2] = 32;
        object186[3] = 13;
        object2[n4] = (byte)object3;
        Object object187 = object3 = new byte[n2];
        Object object188 = object3;
        object187[0] = 0;
        object188[1] = 60;
        object187[2] = 32;
        object188[3] = 24;
        object2[n2] = (byte)object3;
        object[n2] = (int)object2;
        object3 = new byte[n4][];
        Object object189 = object23 = new byte[n2];
        Object object190 = object23;
        object189[0] = 0;
        object190[1] = 0;
        object189[2] = 36;
        object190[3] = 34;
        object3[0] = (byte)object23;
        Object object191 = object23 = new byte[n2];
        Object object192 = object23;
        object191[0] = 36;
        object192[1] = 0;
        object191[2] = 42;
        object192[3] = 39;
        object3[n3] = (byte)object23;
        Object object193 = object23 = new byte[n2];
        Object object194 = object23;
        object193[0] = 78;
        object194[1] = 0;
        object193[2] = 44;
        object194[3] = 41;
        object3[n5] = (byte)object23;
        object[5] = (int)object3;
        object3 = new byte[n2][];
        Object object195 = object23 = new byte[n2];
        Object object196 = object23;
        object195[0] = 0;
        object196[1] = 0;
        object195[2] = 44;
        object196[3] = 44;
        object3[0] = (byte)object23;
        Object object197 = object23 = new byte[n2];
        Object object198 = object23;
        object197[0] = 0;
        object198[1] = 44;
        object197[2] = 44;
        object198[3] = 9;
        object3[n3] = (byte)object23;
        Object object199 = object23 = new byte[n2];
        Object object200 = object23;
        object199[0] = 0;
        object200[1] = 53;
        object199[2] = 44;
        object200[3] = 45;
        object3[n5] = (byte)object23;
        Object object201 = object23 = new byte[n2];
        Object object202 = object23;
        object201[0] = 0;
        object202[1] = 98;
        object201[2] = 44;
        object202[3] = 46;
        object3[n4] = (byte)object23;
        object[6] = (int)object3;
        object3 = new byte[n4][];
        Object object203 = object23 = new byte[n2];
        Object object204 = object23;
        object203[0] = 0;
        object204[1] = 0;
        object203[2] = 35;
        object204[3] = 29;
        object3[0] = (byte)object23;
        Object object205 = object23 = new byte[n2];
        Object object206 = object23;
        object205[0] = 0;
        object206[1] = 29;
        object205[2] = 38;
        object206[3] = 35;
        object3[n3] = (byte)object23;
        Object object207 = object23 = new byte[n2];
        Object object208 = object23;
        object207[0] = 0;
        object208[1] = 64;
        object207[2] = 36;
        object208[3] = 36;
        object3[n5] = (byte)object23;
        object[7] = (int)object3;
        object3 = new byte[n4][];
        Object object209 = object23 = new byte[n2];
        Object object210 = object23;
        object209[0] = 0;
        object210[1] = 0;
        object209[2] = 48;
        object210[3] = 46;
        object3[0] = (byte)object23;
        Object object211 = object23 = new byte[n2];
        Object object212 = object23;
        object211[0] = 0;
        object212[1] = 46;
        object211[2] = 48;
        object212[3] = 48;
        object3[n3] = (byte)object23;
        Object object213 = object23 = new byte[n2];
        Object object214 = object23;
        object213[0] = 0;
        object214[1] = 94;
        object213[2] = 48;
        object214[3] = 51;
        object3[n5] = (byte)object23;
        object[8] = (int)object3;
        object3 = new byte[n4][];
        Object object215 = object23 = new byte[n2];
        Object object216 = object23;
        object215[0] = 0;
        object216[1] = 0;
        object215[2] = 44;
        object216[3] = 44;
        object3[0] = (byte)object23;
        Object object217 = object23 = new byte[n2];
        Object object218 = object23;
        object217[0] = 0;
        object218[1] = 44;
        object217[2] = 48;
        object218[3] = 50;
        object3[n3] = (byte)object23;
        Object object219 = object23 = new byte[n2];
        Object object220 = object23;
        object219[0] = 0;
        object220[1] = 94;
        object219[2] = 48;
        object220[3] = 53;
        object3[n5] = (byte)object23;
        object[9] = (int)object3;
        object3 = new byte[9][];
        Object object221 = object23 = new byte[n2];
        Object object222 = object23;
        object221[0] = 0;
        object222[1] = 0;
        object221[2] = 28;
        object222[3] = 25;
        object3[0] = (byte)object23;
        Object object223 = object23 = new byte[n2];
        Object object224 = object23;
        object223[0] = 0;
        object224[1] = 25;
        object223[2] = 22;
        object224[3] = 16;
        object3[n3] = (byte)object23;
        Object object225 = object23 = new byte[n2];
        Object object226 = object23;
        object225[0] = 28;
        object226[1] = 0;
        object225[2] = 26;
        object226[3] = 25;
        object3[n5] = (byte)object23;
        Object object227 = object23 = new byte[n2];
        Object object228 = object23;
        object227[0] = 22;
        object228[1] = 25;
        object227[2] = 32;
        object228[3] = 27;
        object3[n4] = (byte)object23;
        Object object229 = object23 = new byte[n2];
        Object object230 = object23;
        object229[0] = 0;
        object230[1] = 41;
        object229[2] = 16;
        object230[3] = 16;
        object3[n2] = (byte)object23;
        Object[] objectArray48 = objectArray47 = new byte[n2];
        Object[] objectArray49 = objectArray47;
        objectArray48[0] = 0;
        objectArray49[1] = 57;
        objectArray48[2] = 16;
        objectArray49[3] = 16;
        object3[5] = (byte)objectArray47;
        Object[] objectArray50 = objectArray47 = new byte[n2];
        Object[] objectArray51 = objectArray47;
        objectArray50[0] = 22;
        objectArray51[1] = 52;
        objectArray50[2] = 16;
        objectArray51[3] = 16;
        object3[6] = (byte)objectArray47;
        Object[] objectArray52 = objectArray47 = new byte[n2];
        Object[] objectArray53 = objectArray47;
        objectArray52[0] = 38;
        objectArray53[1] = 52;
        objectArray52[2] = 16;
        objectArray53[3] = 16;
        object3[7] = (byte)objectArray47;
        Object[] objectArray54 = objectArray47 = new byte[n2];
        Object[] objectArray55 = objectArray47;
        objectArray54[0] = 16;
        objectArray55[1] = 68;
        objectArray54[2] = 16;
        objectArray55[3] = 16;
        object3[8] = (byte)objectArray47;
        object[10] = (int)object3;
        this.f1112 = (byte[][][])object;
        object = new byte[11][][];
        object2 = new byte[n4][];
        Object object231 = object3 = new byte[6];
        Object object232 = object3;
        object231[0] = 0;
        object232[1] = -13;
        object231[2] = -15;
        object232[3] = 1;
        object231[4] = -11;
        object232[5] = -20;
        object2[0] = (byte)object3;
        Object object233 = object3 = new byte[6];
        Object object234 = object3;
        object233[0] = 2;
        object234[1] = -16;
        object233[2] = -16;
        object234[3] = 1;
        object233[4] = -11;
        object234[5] = -21;
        object2[n3] = (byte)object3;
        Object object235 = object3 = new byte[6];
        Object object236 = object3;
        object235[0] = 3;
        object236[1] = -16;
        object235[2] = -20;
        object236[3] = 1;
        object235[4] = -11;
        object236[5] = -23;
        object2[n5] = (byte)object3;
        object[0] = (int)object2;
        object2 = new byte[n4][];
        Object object237 = object3 = new byte[6];
        Object object238 = object3;
        object237[0] = 0;
        object238[1] = -12;
        object237[2] = -15;
        object238[3] = 2;
        object237[4] = -11;
        object238[5] = -20;
        object2[0] = (byte)object3;
        Object object239 = object3 = new byte[6];
        Object object240 = object3;
        object239[0] = 1;
        object240[1] = -15;
        object239[2] = -15;
        object240[3] = 2;
        object239[4] = -11;
        object240[5] = -22;
        object2[n3] = (byte)object3;
        Object object241 = object3 = new byte[6];
        Object object242 = object3;
        object241[0] = 3;
        object242[1] = -16;
        object241[2] = -19;
        object242[3] = 2;
        object241[4] = -11;
        object242[5] = -25;
        object2[n5] = (byte)object3;
        object[n3] = (int)object2;
        object2 = new byte[n4][];
        Object object243 = object3 = new byte[9];
        Object object244 = object3;
        object243[0] = 0;
        object244[1] = -14;
        object243[2] = -17;
        object244[3] = 2;
        object243[4] = -14;
        object244[5] = -1;
        object243[6] = 1;
        object244[7] = -10;
        object244[8] = -24;
        object2[0] = (byte)object3;
        Object object245 = object3 = new byte[9];
        Object object246 = object3;
        object245[0] = 3;
        object246[1] = -14;
        object245[2] = -23;
        object246[3] = 2;
        object245[4] = -14;
        object246[5] = -1;
        object245[6] = 1;
        object246[7] = -10;
        object246[8] = -24;
        object2[n3] = (byte)object3;
        Object object247 = object3 = new byte[9];
        Object object248 = object3;
        object247[0] = 4;
        object248[1] = -16;
        object247[2] = -25;
        object248[3] = 2;
        object247[4] = -14;
        object248[5] = -1;
        object247[6] = 1;
        object248[7] = -10;
        object248[8] = -29;
        object2[n5] = (byte)object3;
        object[n5] = (int)object2;
        object2 = new byte[n4][];
        Object object249 = object3 = new byte[n4];
        object3[0] = 0;
        object249[1] = -11;
        object249[2] = -22;
        object2[0] = (byte)object3;
        Object object250 = object3 = new byte[n4];
        object3[0] = 1;
        object250[1] = -17;
        object250[2] = -27;
        object2[n3] = (byte)object3;
        Object object251 = object3 = new byte[n4];
        object3[0] = 2;
        object251[1] = -17;
        object251[2] = -23;
        object2[n5] = (byte)object3;
        object[n4] = (int)object2;
        object2 = new byte[n4][];
        Object object252 = object3 = new byte[6];
        Object object253 = object3;
        object252[0] = 0;
        object253[1] = -9;
        object252[2] = -7;
        object253[3] = 1;
        object252[4] = -13;
        object253[5] = -22;
        object2[0] = (byte)object3;
        Object object254 = object3 = new byte[9];
        Object object255 = object3;
        object254[0] = 2;
        object255[1] = -16;
        object254[2] = -13;
        object255[3] = 3;
        object254[4] = -16;
        object255[5] = -2;
        object254[6] = 1;
        object255[7] = -13;
        object255[8] = -22;
        object2[n3] = (byte)object3;
        Object object256 = object3 = new byte[9];
        Object object257 = object3;
        object256[0] = 4;
        object257[1] = -16;
        object256[2] = -25;
        object257[3] = 3;
        object256[4] = -16;
        object257[5] = -1;
        object256[6] = 1;
        object257[7] = -13;
        object257[8] = -33;
        object2[n5] = (byte)object3;
        object[n2] = (int)object2;
        object3 = new byte[n4][];
        Object object258 = object23 = new byte[n4];
        object23[0] = 0;
        object258[1] = -18;
        object258[2] = -18;
        object3[0] = (byte)object23;
        Object object259 = object23 = new byte[n4];
        object23[0] = 1;
        object259[1] = -21;
        object259[2] = -21;
        object3[n3] = (byte)object23;
        Object object260 = object23 = new byte[n4];
        object23[0] = 2;
        object260[1] = -22;
        object260[2] = -21;
        object3[n5] = (byte)object23;
        object[5] = (int)object3;
        object3 = new byte[n4][];
        Object object261 = object23 = new byte[6];
        Object object262 = object23;
        object261[0] = 0;
        object262[1] = -22;
        object261[2] = -32;
        object262[3] = 1;
        object261[4] = -22;
        object262[5] = 12;
        object3[0] = (byte)object23;
        Object object263 = object23 = new byte[6];
        Object object264 = object23;
        object263[0] = 2;
        object264[1] = -22;
        object263[2] = -33;
        object264[3] = 1;
        object263[4] = -22;
        object264[5] = 12;
        object3[n3] = (byte)object23;
        Object object265 = object23 = new byte[6];
        Object object266 = object23;
        object265[0] = 3;
        object266[1] = -22;
        object265[2] = -34;
        object266[3] = 1;
        object265[4] = -22;
        object266[5] = 12;
        object3[n5] = (byte)object23;
        object[6] = (int)object3;
        object3 = new byte[n4][];
        Object object267 = object23 = new byte[n4];
        object23[0] = 0;
        object267[1] = -18;
        object267[2] = -16;
        object3[0] = (byte)object23;
        Object object268 = object23 = new byte[n4];
        object23[0] = 1;
        object268[1] = -20;
        object268[2] = -20;
        object3[n3] = (byte)object23;
        Object object269 = object23 = new byte[n4];
        object23[0] = 2;
        object269[1] = -17;
        object269[2] = -21;
        object3[n5] = (byte)object23;
        object[7] = (int)object3;
        object3 = new byte[n4][];
        Object object270 = object23 = new byte[n4];
        object23[0] = 0;
        object270[1] = -24;
        object270[2] = -30;
        object3[0] = (byte)object23;
        Object object271 = object23 = new byte[n4];
        object23[0] = 1;
        object271[1] = -24;
        object271[2] = -30;
        object3[n3] = (byte)object23;
        Object object272 = object23 = new byte[n4];
        object23[0] = 2;
        object272[1] = -24;
        object272[2] = -30;
        object3[n5] = (byte)object23;
        object[8] = (int)object3;
        object3 = new byte[n4][];
        Object object273 = object23 = new byte[n4];
        object23[0] = 0;
        object273[1] = -22;
        object273[2] = -28;
        object3[0] = (byte)object23;
        Object object274 = object23 = new byte[n4];
        object23[0] = 1;
        object274[1] = -24;
        object274[2] = -31;
        object3[n3] = (byte)object23;
        Object object275 = object23 = new byte[n4];
        object23[0] = 2;
        object275[1] = -24;
        object275[2] = -31;
        object3[n5] = (byte)object23;
        object[9] = (int)object3;
        object3 = new byte[n4][];
        Object object276 = object23 = new byte[6];
        Object object277 = object23;
        object276[0] = 0;
        object277[1] = -14;
        object276[2] = -17;
        object277[3] = 1;
        object276[4] = -11;
        object277[5] = -29;
        object3[0] = (byte)object23;
        Object object278 = object23 = new byte[6];
        Object object279 = object23;
        object278[0] = 0;
        object279[1] = -14;
        object278[2] = -17;
        object279[3] = 2;
        object278[4] = -13;
        object279[5] = -34;
        object3[n3] = (byte)object23;
        Object object280 = object23 = new byte[6];
        Object object281 = object23;
        object280[0] = 0;
        object281[1] = -14;
        object280[2] = -17;
        object281[3] = 3;
        object280[4] = -16;
        object281[5] = -37;
        object3[n5] = (byte)object23;
        object[10] = (int)object3;
        this.g1113 = (byte[][][])object;
        object = new byte[11][];
        Object object282 = object2 = new byte[n4];
        object2[0] = 2;
        object282[1] = 2;
        object282[2] = 2;
        object[0] = (int)object2;
        Object object283 = object2 = new byte[n4];
        object2[0] = 2;
        object283[1] = 2;
        object283[2] = 2;
        object[n3] = (int)object2;
        Object object284 = object2 = new byte[n4];
        object2[0] = 3;
        object284[1] = 3;
        object284[2] = 3;
        object[n5] = (int)object2;
        Object object285 = object2 = new byte[n4];
        object2[0] = 1;
        object285[1] = 1;
        object285[2] = 1;
        object[n4] = (int)object2;
        Object object286 = object2 = new byte[n4];
        object2[0] = 2;
        object286[1] = 3;
        object286[2] = 3;
        object[n2] = (int)object2;
        Object object287 = object3 = new byte[n4];
        object3[0] = 1;
        object287[1] = 1;
        object287[2] = 1;
        object[5] = (int)object3;
        Object object288 = object3 = new byte[n4];
        object3[0] = 2;
        object288[1] = 2;
        object288[2] = 2;
        object[6] = (int)object3;
        Object object289 = object3 = new byte[n4];
        object3[0] = 1;
        object289[1] = 1;
        object289[2] = 1;
        object[7] = (int)object3;
        Object object290 = object3 = new byte[n4];
        object3[0] = 1;
        object290[1] = 1;
        object290[2] = 1;
        object[8] = (int)object3;
        Object object291 = object3 = new byte[n4];
        object3[0] = 1;
        object291[1] = 1;
        object291[2] = 1;
        object[9] = (int)object3;
        Object object292 = object3 = new byte[n4];
        object3[0] = 2;
        object292[1] = 2;
        object292[2] = 2;
        object[10] = (int)object3;
        this.q1114 = (byte[][])object;
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = 8;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -6;
        object2[1] = 8;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = 0;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 6;
        object2[1] = 8;
        object[n4] = (int)object2;
        this.r1115 = (byte[][])object;
        Object object293 = object = new int[9];
        Object object294 = object;
        object293[0] = 0xFFFFE7;
        object294[1] = 15457227;
        object293[2] = 7730877;
        object294[3] = 15656911;
        object293[4] = 7049925;
        object294[5] = 7730877;
        object293[6] = 7730877;
        object294[7] = 7049925;
        object294[8] = 15656911;
        this.l1116 = object;
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 0;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = 1;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 0;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = 1;
        object[n4] = (int)object2;
        this.s1117 = (byte[][])object;
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 5;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 29;
        object2[1] = -5;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 27;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = -5;
        object[n4] = (int)object2;
        this.t1118 = (byte[][])object;
        object = new byte[n4][];
        object2 = new byte[n5];
        object2[0] = 33;
        object2[1] = -9;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 43;
        object2[1] = -18;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 58;
        object2[1] = -27;
        object[n5] = (int)object2;
        this.u1119 = (byte[][])object;
        object = new byte[n4][];
        object2 = new byte[n5];
        object2[0] = -33;
        object2[1] = -27;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -18;
        object2[1] = -18;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -8;
        object2[1] = -9;
        object[n5] = (int)object2;
        this.v1120 = (byte[][])object;
        object = new byte[n2][][];
        object2 = new byte[n4][];
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 52;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 52;
        object3[1] = 14;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 66;
        object3[1] = 16;
        object2[n5] = (byte)object3;
        object[0] = (int)object2;
        object2 = new byte[n4][];
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 13;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 13;
        object3[1] = 16;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 29;
        object3[1] = 23;
        object2[n5] = (byte)object3;
        object[n3] = (int)object2;
        object2 = new byte[n4][];
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 32;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 32;
        object3[1] = 23;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 55;
        object3[1] = 15;
        object2[n5] = (byte)object3;
        object[n5] = (int)object2;
        object2 = new byte[n4][];
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 23;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 23;
        object3[1] = 16;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 39;
        object3[1] = 13;
        object2[n5] = (byte)object3;
        object[n4] = (int)object2;
        this.h1121 = (byte[][][])object;
        object = new byte[11][][];
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = -5;
        object3[1] = -31;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 6;
        object3[1] = -24;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -5;
        object3[1] = -16;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -14;
        object3[1] = -24;
        object2[n4] = (byte)object3;
        object[0] = (int)object2;
        object2 = new byte[0][];
        object[n3] = (int)object2;
        object2 = new byte[n3][];
        object3 = new byte[n5];
        object3[0] = -3;
        object3[1] = -2;
        object2[0] = (byte)object3;
        object[n5] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = -11;
        object3[1] = -31;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -14;
        object3[1] = -9;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = -7;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 8;
        object3[1] = -21;
        object2[n4] = (byte)object3;
        object[n4] = (int)object2;
        object2 = new byte[n3][];
        object3 = new byte[n5];
        object3[0] = -6;
        object3[1] = -27;
        object2[0] = (byte)object3;
        object[n2] = (int)object2;
        object3 = new byte[n3][];
        object23 = new byte[n5];
        object23[0] = -6;
        object23[1] = -9;
        object3[0] = (byte)object23;
        object[5] = (int)object3;
        object3 = new byte[0][];
        object[6] = (int)object3;
        object3 = new byte[n5][];
        object23 = new byte[n5];
        object23[0] = -18;
        object23[1] = -34;
        object3[0] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 5;
        object23[1] = -34;
        object3[n3] = (byte)object23;
        object[7] = (int)object3;
        object3 = new byte[n3][];
        object23 = new byte[n5];
        object23[0] = -7;
        object23[1] = -19;
        object3[0] = (byte)object23;
        object[8] = (int)object3;
        object3 = new byte[n3][];
        object23 = new byte[n5];
        object23[0] = -8;
        object23[1] = -18;
        object3[0] = (byte)object23;
        object[9] = (int)object3;
        object3 = new byte[0][];
        object[10] = (int)object3;
        this.i1122 = (byte[][][])object;
        object = new byte[11][];
        Object object295 = object2 = new byte[30];
        Object object296 = object2;
        object295[0] = 0;
        object296[1] = 1;
        object295[2] = 1;
        object296[3] = 2;
        object295[4] = 2;
        object296[5] = 1;
        object295[6] = 1;
        object296[7] = 3;
        object295[8] = 3;
        object296[9] = 1;
        object295[10] = 1;
        object296[11] = 2;
        object295[12] = 2;
        object296[13] = 1;
        object295[14] = 1;
        object296[15] = 3;
        object295[16] = 3;
        object296[17] = 1;
        object295[18] = 1;
        object296[19] = 0;
        object295[20] = 4;
        object296[21] = 4;
        object295[22] = 4;
        object296[23] = 4;
        object295[24] = 4;
        object296[25] = 4;
        object295[26] = 4;
        object296[27] = 4;
        object295[28] = 0;
        object296[29] = 0;
        object[0] = (int)object2;
        object2 = new byte[]{};
        object[n3] = (int)object2;
        Object object297 = object2 = new byte[24];
        Object object298 = object2;
        object297[0] = 0;
        object298[1] = 1;
        object297[2] = 2;
        object298[3] = 3;
        object297[4] = 2;
        object298[5] = 3;
        object297[6] = 2;
        object298[7] = 3;
        object297[8] = 2;
        object298[9] = 3;
        object297[10] = 3;
        object298[11] = 2;
        object297[12] = 1;
        object298[13] = 0;
        object297[14] = 4;
        object298[15] = 4;
        object297[16] = 4;
        object298[17] = 4;
        object297[18] = 4;
        object298[19] = 4;
        object297[20] = 4;
        object298[21] = 4;
        object297[22] = 6;
        object298[23] = 12;
        object[n5] = (int)object2;
        Object object299 = object2 = new byte[14];
        Object object300 = object2;
        object299[0] = 0;
        object300[1] = 1;
        object299[2] = 2;
        object300[3] = 3;
        object299[4] = 4;
        object300[5] = 5;
        object299[6] = 6;
        object300[7] = 7;
        object299[8] = 8;
        object300[9] = 9;
        object299[10] = 10;
        object300[11] = 11;
        object299[12] = 5;
        object300[13] = 15;
        object[n4] = (int)object2;
        Object object301 = object2 = new byte[12];
        Object object302 = object2;
        object301[0] = 0;
        object302[1] = 0;
        object301[2] = 0;
        object302[3] = 0;
        object301[4] = 0;
        object302[5] = 0;
        object301[6] = 0;
        object302[7] = 0;
        object301[8] = 0;
        object302[9] = 0;
        object301[10] = 12;
        object302[11] = 17;
        object[n2] = (int)object2;
        Object object303 = object3 = new byte[12];
        Object object304 = object3;
        object303[0] = 0;
        object304[1] = 1;
        object303[2] = 2;
        object304[3] = 3;
        object303[4] = 4;
        object304[5] = 5;
        object303[6] = 6;
        object304[7] = 7;
        object303[8] = 8;
        object304[9] = 9;
        object303[10] = 12;
        object304[11] = 11;
        object[5] = (int)object3;
        object3 = new byte[]{};
        object[6] = (int)object3;
        Object object305 = object3 = new byte[11];
        Object object306 = object3;
        object305[0] = 0;
        object306[1] = 1;
        object305[2] = 2;
        object306[3] = 0;
        object305[4] = 1;
        object306[5] = 2;
        object305[6] = 0;
        object306[7] = 1;
        object305[8] = 2;
        object306[9] = 13;
        object306[10] = 33;
        object[7] = (int)object3;
        Object object307 = object3 = new byte[11];
        Object object308 = object3;
        object307[0] = 0;
        object308[1] = 1;
        object307[2] = 2;
        object308[3] = 3;
        object307[4] = 4;
        object308[5] = 5;
        object307[6] = 6;
        object308[7] = 6;
        object307[8] = 6;
        object308[9] = 14;
        object308[10] = 14;
        object[8] = (int)object3;
        Object object309 = object3 = new byte[13];
        Object object310 = object3;
        object309[0] = 0;
        object310[1] = 1;
        object309[2] = 2;
        object310[3] = 2;
        object309[4] = 2;
        object310[5] = 2;
        object309[6] = 1;
        object310[7] = 0;
        object309[8] = 3;
        object310[9] = 3;
        object309[10] = 3;
        object310[11] = 16;
        object310[12] = 12;
        object[9] = (int)object3;
        object3 = new byte[]{};
        object[10] = (int)object3;
        this.w1123 = (byte[][])object;
        Object object311 = object = (Object)new byte[10];
        Object object312 = object;
        object311[0] = 0;
        object312[1] = 2;
        object311[2] = 3;
        object312[3] = 3;
        object311[4] = 2;
        object312[5] = 1;
        object311[6] = 0;
        object312[7] = -1;
        object311[8] = -2;
        object312[9] = -1;
        this.x1124 = (byte[])object;
        Object object313 = object = (Object)new byte[16];
        Object object314 = object;
        object313[0] = -5;
        object314[1] = -20;
        object313[2] = 10;
        object314[3] = 3;
        object313[4] = 8;
        object314[5] = -15;
        object313[6] = 6;
        object314[7] = 9;
        object313[8] = -5;
        object314[9] = -4;
        object313[10] = 10;
        object314[11] = 6;
        object313[12] = -14;
        object314[13] = -15;
        object313[14] = 6;
        object314[15] = 9;
        this.y1125 = (byte[])object;
        this.a1127 = (boolean[][])Array.newInstance(Boolean.TYPE, n4, n4);
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = -16;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 16;
        object2[1] = 1;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 16;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -16;
        object2[1] = 1;
        object[n4] = (int)object2;
        this.x1128 = (byte[][])object;
        this.m1129 = new int[n2];
        object = new byte[n4][];
        Object object315 = object2 = new byte[11];
        Object object316 = object2;
        object315[0] = 0;
        object316[1] = 6;
        object315[2] = 7;
        object316[3] = 8;
        object315[4] = 9;
        object316[5] = 10;
        object315[6] = 2;
        object316[7] = 3;
        object315[8] = 4;
        object316[9] = 5;
        object316[10] = 1;
        object[0] = (int)object2;
        Object object317 = object2 = new byte[11];
        Object object318 = object2;
        object317[0] = 11;
        object318[1] = 17;
        object317[2] = 18;
        object318[3] = 19;
        object317[4] = 20;
        object318[5] = 21;
        object317[6] = 13;
        object318[7] = 14;
        object317[8] = 15;
        object318[9] = 16;
        object318[10] = 12;
        object[n3] = (int)object2;
        Object object319 = object2 = new byte[11];
        Object object320 = object2;
        object319[0] = 22;
        object320[1] = 28;
        object319[2] = 29;
        object320[3] = 30;
        object319[4] = 31;
        object320[5] = 32;
        object319[6] = 24;
        object320[7] = 25;
        object319[8] = 26;
        object320[9] = 27;
        object320[10] = 23;
        object[n5] = (int)object2;
        this.y1130 = (byte[][])object;
        object = new byte[9][];
        Object object321 = object2 = new byte[n4];
        object2[0] = 33;
        object321[1] = 34;
        object321[2] = 35;
        object[0] = (int)object2;
        Object object322 = object2 = new byte[n2];
        Object object323 = object2;
        object322[0] = 36;
        object323[1] = 37;
        object322[2] = 38;
        object323[3] = 39;
        object[n3] = (int)object2;
        Object object324 = object2 = new byte[10];
        Object object325 = object2;
        object324[0] = 16;
        object325[1] = 40;
        object324[2] = 41;
        object325[3] = 42;
        object324[4] = 13;
        object325[5] = 0;
        object324[6] = 4;
        object325[7] = 5;
        object324[8] = 1;
        object325[9] = 8;
        object[n5] = (int)object2;
        Object object326 = object2 = new byte[12];
        Object object327 = object2;
        object326[0] = 42;
        object327[1] = 43;
        object326[2] = 13;
        object327[3] = 40;
        object326[4] = 44;
        object327[5] = 45;
        object326[6] = 0;
        object327[7] = 8;
        object326[8] = 32;
        object327[9] = 25;
        object326[10] = 47;
        object327[11] = 31;
        object[n4] = (int)object2;
        Object object328 = object2 = new byte[12];
        Object object329 = object2;
        object328[0] = 13;
        object329[1] = 45;
        object328[2] = 44;
        object329[3] = 42;
        object328[4] = 41;
        object329[5] = 46;
        object328[6] = 23;
        object329[7] = 24;
        object328[8] = 30;
        object329[9] = 22;
        object328[10] = 26;
        object329[11] = 47;
        object[n2] = (int)object2;
        Object object330 = object3 = new byte[12];
        Object object331 = object3;
        object330[0] = 0;
        object331[1] = 2;
        object330[2] = 5;
        object331[3] = 6;
        object330[4] = 3;
        object331[5] = 8;
        object330[6] = 22;
        object331[7] = 29;
        object330[8] = 24;
        object331[9] = 25;
        object330[10] = 26;
        object331[11] = 23;
        object[5] = (int)object3;
        Object object332 = object3 = new byte[5];
        Object object333 = object3;
        object332[0] = 2;
        object333[1] = 8;
        object332[2] = 5;
        object333[3] = 3;
        object333[4] = 7;
        object[6] = (int)object3;
        Object object334 = object3 = new byte[5];
        Object object335 = object3;
        object334[0] = 13;
        object335[1] = 16;
        object334[2] = 40;
        object335[3] = 46;
        object335[4] = 17;
        object[7] = (int)object3;
        Object object336 = object3 = new byte[5];
        Object object337 = object3;
        object336[0] = 24;
        object337[1] = 26;
        object336[2] = 28;
        object337[3] = 29;
        object337[4] = 22;
        object[8] = (int)object3;
        this.z1131 = (byte[][])object;
        object = new byte[n4][];
        Object object338 = object2 = new byte[9];
        Object object339 = object2;
        object338[0] = 0;
        object339[1] = 0;
        object338[2] = 0;
        object339[3] = 0;
        object338[4] = 2;
        object339[5] = 1;
        object338[6] = 2;
        object339[7] = 0;
        object339[8] = 0;
        object[0] = (int)object2;
        Object object340 = object2 = new byte[9];
        Object object341 = object2;
        object340[0] = 0;
        object341[1] = 0;
        object340[2] = 1;
        object341[3] = 1;
        object340[4] = 1;
        object341[5] = 2;
        object340[6] = 0;
        object341[7] = 2;
        object341[8] = 0;
        object[n3] = (int)object2;
        Object object342 = object2 = new byte[9];
        Object object343 = object2;
        object342[0] = 0;
        object343[1] = 0;
        object342[2] = 2;
        object343[3] = 0;
        object342[4] = 0;
        object343[5] = 0;
        object342[6] = 0;
        object343[7] = 0;
        object343[8] = 2;
        object[n5] = (int)object2;
        this.A1132 = (byte[][])object;
        object = new byte[5][];
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 0;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 10;
        object2[1] = 10;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 18;
        object2[1] = 3;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 4;
        object2[1] = 9;
        object[n4] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 14;
        object2[1] = 9;
        object[n2] = (int)object2;
        this.B1133 = (byte[][])object;
        this.C1134 = (byte[][])Array.newInstance(Byte.TYPE, 30, 12);
        object = new byte[n4][];
        Object object344 = object2 = new byte[n2];
        Object object345 = object2;
        object344[0] = 0;
        object345[1] = 15;
        object344[2] = 0;
        object345[3] = 0;
        object[0] = (int)object2;
        Object object346 = object2 = new byte[n2];
        Object object347 = object2;
        object346[0] = 15;
        object347[1] = 23;
        object346[2] = -4;
        object347[3] = 1;
        object[n3] = (int)object2;
        Object object348 = object2 = new byte[n2];
        Object object349 = object2;
        object348[0] = 38;
        object349[1] = 21;
        object348[2] = -3;
        object349[3] = 0;
        object[n5] = (int)object2;
        this.D1135 = (byte[][])object;
        object = new byte[9][];
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = -16;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 16;
        object2[1] = -16;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 32;
        object2[1] = -16;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -8;
        object2[1] = -6;
        object[n4] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -8;
        object2[1] = 8;
        object[n2] = (int)object2;
        object3 = new byte[n5];
        object3[0] = -8;
        object3[1] = 22;
        object[5] = (int)object3;
        object3 = new byte[n5];
        object3[0] = 41;
        object3[1] = -6;
        object[6] = (int)object3;
        object3 = new byte[n5];
        object3[0] = 41;
        object3[1] = 8;
        object[7] = (int)object3;
        object3 = new byte[n5];
        object3[0] = 41;
        object3[1] = 22;
        object[8] = (int)object3;
        this.E1136 = (byte[][])object;
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = -48;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 48;
        object2[1] = 0;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = 64;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -48;
        object2[1] = 0;
        object[n4] = (int)object2;
        this.F1137 = (byte[][])object;
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = -10;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 21;
        object2[1] = -10;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = 11;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 21;
        object2[1] = 11;
        object[n4] = (int)object2;
        this.G1138 = (byte[][])object;
        object = new byte[n4][][];
        object2 = new byte[7][];
        object3 = new byte[n5];
        object3[0] = -8;
        object3[1] = -29;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 6;
        object3[1] = -19;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -8;
        object3[1] = -6;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -19;
        object3[1] = -19;
        object2[n4] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 0;
        object2[n2] = (byte)object3;
        object23 = new byte[n5];
        object23[0] = 0;
        object23[1] = -1;
        object2[5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 0;
        object23[1] = -3;
        object2[6] = (byte)object23;
        object[0] = (int)object2;
        object2 = new byte[7][];
        object3 = new byte[n5];
        object3[0] = -8;
        object3[1] = -31;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 7;
        object3[1] = -20;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -8;
        object3[1] = -6;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -21;
        object3[1] = -20;
        object2[n4] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 0;
        object2[n2] = (byte)object3;
        object23 = new byte[n5];
        object23[0] = 0;
        object23[1] = 0;
        object2[5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 0;
        object23[1] = -11;
        object2[6] = (byte)object23;
        object[n3] = (int)object2;
        object2 = new byte[7][];
        object3 = new byte[n5];
        object3[0] = -8;
        object3[1] = -29;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 6;
        object3[1] = -18;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -8;
        object3[1] = -6;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -19;
        object3[1] = -18;
        object2[n4] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 0;
        object3[1] = 0;
        object2[n2] = (byte)object3;
        object23 = new byte[n5];
        object23[0] = 0;
        object23[1] = -2;
        object2[5] = (byte)object23;
        object23 = new byte[n5];
        object23[0] = 0;
        object23[1] = -5;
        object2[6] = (byte)object23;
        object[n5] = (int)object2;
        this.j1139 = (byte[][][])object;
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = -1;
        object2[1] = -1;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = -1;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -1;
        object2[1] = 0;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -2;
        object2[1] = 1;
        object[n4] = (int)object2;
        object = new byte[7][];
        Object object350 = object2 = new byte[n4];
        object2[0] = -19;
        object350[1] = -25;
        object350[2] = 0;
        object[0] = (int)object2;
        Object object351 = object2 = new byte[n4];
        object2[0] = -2;
        object351[1] = -27;
        object351[2] = 0;
        object[n3] = (int)object2;
        Object object352 = object2 = new byte[n4];
        object2[0] = 8;
        object352[1] = -18;
        object352[2] = 2;
        object[n5] = (int)object2;
        Object object353 = object2 = new byte[n4];
        object2[0] = 4;
        object353[1] = -2;
        object353[2] = 1;
        object[n4] = (int)object2;
        Object object354 = object2 = new byte[n4];
        object2[0] = -10;
        object354[1] = 6;
        object354[2] = 2;
        object[n2] = (int)object2;
        Object object355 = object3 = new byte[n4];
        object3[0] = -24;
        object355[1] = 4;
        object355[2] = 0;
        object[5] = (int)object3;
        Object object356 = object3 = new byte[n4];
        object3[0] = -16;
        object356[1] = -9;
        object356[2] = 0;
        object[6] = (int)object3;
        this.H1140 = (byte[][])object;
        object = new byte[n4][][];
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 12;
        object3[1] = -19;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 48;
        object3[1] = 13;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 12;
        object3[1] = 53;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -17;
        object3[1] = 13;
        object2[n4] = (byte)object3;
        object[0] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 12;
        object3[1] = -29;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 64;
        object3[1] = 12;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 12;
        object3[1] = 69;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -33;
        object3[1] = 12;
        object2[n4] = (byte)object3;
        object[n3] = (int)object2;
        object2 = new byte[n2][];
        object3 = new byte[n5];
        object3[0] = 13;
        object3[1] = -46;
        object2[0] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 80;
        object3[1] = 13;
        object2[n3] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = 13;
        object3[1] = 88;
        object2[n5] = (byte)object3;
        object3 = new byte[n5];
        object3[0] = -49;
        object3[1] = 12;
        object2[n4] = (byte)object3;
        object[n5] = (int)object2;
        this.k1141 = (byte[][][])object;
        object = new byte[n2][];
        Object object357 = object2 = new byte[n2];
        Object object358 = object2;
        object357[0] = 9;
        object358[1] = 2;
        object357[2] = 23;
        object358[3] = 20;
        object[0] = (int)object2;
        Object object359 = object2 = new byte[n2];
        Object object360 = object2;
        object359[0] = 10;
        object360[1] = 0;
        object359[2] = 17;
        object360[3] = 23;
        object[n3] = (int)object2;
        Object object361 = object2 = new byte[n2];
        Object object362 = object2;
        object361[0] = 9;
        object362[1] = 0;
        object361[2] = 23;
        object362[3] = 20;
        object[n5] = (int)object2;
        Object object363 = object2 = new byte[n2];
        Object object364 = object2;
        object363[0] = 10;
        object364[1] = 1;
        object363[2] = 17;
        object364[3] = 23;
        object[n4] = (int)object2;
        this.I1142 = (byte[][])object;
        object = new byte[n2][][];
        object2 = new byte[n2][];
        Object object365 = object3 = new byte[6];
        Object object366 = object3;
        object365[0] = 11;
        object366[1] = 7;
        object365[2] = -18;
        object366[3] = 2;
        object365[4] = 13;
        object366[5] = 23;
        object2[0] = (byte)object3;
        Object object367 = object3 = new byte[6];
        Object object368 = object3;
        object367[0] = 12;
        object368[1] = 29;
        object367[2] = -19;
        object368[3] = 0;
        object367[4] = 17;
        object368[5] = 16;
        object2[n3] = (byte)object3;
        Object object369 = object3 = new byte[6];
        Object object370 = object3;
        object369[0] = 11;
        object370[1] = 28;
        object369[2] = -45;
        object370[3] = 2;
        object369[4] = 13;
        object370[5] = 23;
        object2[n5] = (byte)object3;
        Object object371 = object3 = new byte[6];
        Object object372 = object3;
        object371[0] = 12;
        object372[1] = -2;
        object371[2] = -43;
        object372[3] = 0;
        object371[4] = 17;
        object372[5] = 16;
        object2[n4] = (byte)object3;
        object[0] = (int)object2;
        object2 = new byte[n2][];
        Object object373 = object3 = new byte[6];
        Object object374 = object3;
        object373[0] = 13;
        object374[1] = 44;
        object373[2] = -2;
        object374[3] = 1;
        object373[4] = 17;
        object374[5] = 14;
        object2[0] = (byte)object3;
        Object object375 = object3 = new byte[6];
        Object object376 = object3;
        object375[0] = 14;
        object376[1] = 48;
        object375[2] = 23;
        object376[3] = 1;
        object375[4] = 19;
        object376[5] = 13;
        object2[n3] = (byte)object3;
        Object object377 = object3 = new byte[6];
        Object object378 = object3;
        object377[0] = 15;
        object378[1] = 80;
        object377[2] = 11;
        object378[3] = 1;
        object377[4] = 17;
        object378[5] = 9;
        object2[n5] = (byte)object3;
        Object object379 = object3 = new byte[6];
        Object object380 = object3;
        object379[0] = 16;
        object380[1] = 73;
        object379[2] = 33;
        object380[3] = 1;
        object379[4] = 21;
        object380[5] = 10;
        object2[n4] = (byte)object3;
        object[n3] = (int)object2;
        object2 = new byte[n2][];
        Object object381 = object3 = new byte[6];
        Object object382 = object3;
        object381[0] = 11;
        object382[1] = 7;
        object381[2] = 49;
        object382[3] = 0;
        object381[4] = 13;
        object382[5] = 23;
        object2[0] = (byte)object3;
        Object object383 = object3 = new byte[6];
        Object object384 = object3;
        object383[0] = 12;
        object384[1] = 29;
        object383[2] = 59;
        object384[3] = 0;
        object383[4] = 17;
        object384[5] = 16;
        object2[n3] = (byte)object3;
        Object object385 = object3 = new byte[6];
        Object object386 = object3;
        object385[0] = 11;
        object386[1] = 28;
        object385[2] = 84;
        object386[3] = 1;
        object385[4] = 13;
        object386[5] = 23;
        object2[n5] = (byte)object3;
        Object object387 = object3 = new byte[6];
        Object object388 = object3;
        object387[0] = 12;
        object388[1] = 2;
        object387[2] = 94;
        object388[3] = 1;
        object387[4] = 17;
        object388[5] = 16;
        object2[n4] = (byte)object3;
        object[n5] = (int)object2;
        object2 = new byte[n2][];
        Object object389 = object3 = new byte[6];
        Object object390 = object3;
        object389[0] = 13;
        object390[1] = -15;
        object389[2] = -2;
        object390[3] = 0;
        object389[4] = 17;
        object390[5] = 14;
        object2[0] = (byte)object3;
        Object object391 = object3 = new byte[6];
        Object object392 = object3;
        object391[0] = 14;
        object392[1] = -17;
        object391[2] = 23;
        object392[3] = 0;
        object391[4] = 19;
        object392[5] = 13;
        object2[n3] = (byte)object3;
        Object object393 = object3 = new byte[6];
        Object object394 = object3;
        object393[0] = 15;
        object394[1] = -49;
        object393[2] = 11;
        object394[3] = 0;
        object393[4] = 17;
        object394[5] = 9;
        object2[n5] = (byte)object3;
        Object object395 = object3 = new byte[6];
        Object object396 = object3;
        object395[0] = 16;
        object396[1] = -46;
        object395[2] = 33;
        object396[3] = 0;
        object395[4] = 21;
        object396[5] = 10;
        object2[n4] = (byte)object3;
        object[n4] = (int)object2;
        this.l1143 = (byte[][][])object;
        object = new byte[n4][];
        object2 = new byte[n5];
        object2[0] = -14;
        object2[1] = -27;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -14;
        object2[1] = -32;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -14;
        object2[1] = -27;
        object[n5] = (int)object2;
        this.J1144 = (byte[][])object;
        object = new byte[n4][];
        object2 = new byte[n5];
        object2[0] = -14;
        object2[1] = -11;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 4;
        object2[1] = -16;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -14;
        object2[1] = -15;
        object[n5] = (int)object2;
        this.K1145 = (byte[][])object;
        object = new byte[n4][];
        Object object397 = object2 = new byte[n2];
        Object object398 = object2;
        object397[0] = -80;
        object398[1] = 31;
        object397[2] = 16;
        object398[3] = 18;
        object[0] = (int)object2;
        Object object399 = object2 = new byte[n2];
        Object object400 = object2;
        object399[0] = -54;
        object400[1] = 0;
        object399[2] = 16;
        object400[3] = 31;
        object[n3] = (int)object2;
        Object object401 = object2 = new byte[n2];
        Object object402 = object2;
        object401[0] = -10;
        object402[1] = 31;
        object401[2] = 16;
        object402[3] = 18;
        object[n5] = (int)object2;
        this.L1146 = (byte[][])object;
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = 16;
        object2[1] = -39;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 46;
        object2[1] = 14;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 19;
        object2[1] = 48;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -48;
        object2[1] = 14;
        object[n4] = (int)object2;
        this.M1147 = (byte[][])object;
        object = new byte[13];
        object[0] = 0;
        object[n3] = n3;
        object[n5] = n5;
        object[n4] = n5;
        object[n2] = n5;
        object[5] = n5;
        object[6] = n5;
        object[7] = n5;
        object[8] = n5;
        object[9] = n5;
        object[10] = n5;
        object[11] = n3;
        object[12] = 0;
        Object object403 = object = (Object)new byte[5];
        Object object404 = object;
        object403[0] = 0;
        object404[1] = -6;
        object403[2] = -8;
        object404[3] = -12;
        object404[4] = -14;
        this.z1148 = (byte[])object;
        object = new byte[n4][];
        Object object405 = object2 = new byte[6];
        Object object406 = object2;
        object405[0] = 0;
        object406[1] = 0;
        object405[2] = 40;
        object406[3] = 32;
        object405[4] = 9;
        object406[5] = 10;
        object[0] = (int)object2;
        Object object407 = object2 = new byte[6];
        Object object408 = object2;
        object407[0] = 40;
        object408[1] = 0;
        object407[2] = 36;
        object408[3] = 29;
        object407[4] = 11;
        object408[5] = 11;
        object[n3] = (int)object2;
        Object object409 = object2 = new byte[6];
        Object object410 = object2;
        object409[0] = 76;
        object410[1] = 0;
        object409[2] = 28;
        object410[3] = 16;
        object409[4] = 15;
        object410[5] = 17;
        object[n5] = (int)object2;
        this.N1149 = (byte[][])object;
        object = new byte[n5][][];
        object2 = new byte[6][];
        Object object411 = object3 = new byte[6];
        Object object412 = object3;
        object411[0] = 0;
        object412[1] = 0;
        object411[2] = 10;
        object412[3] = 11;
        object411[4] = 9;
        object412[5] = 6;
        object2[0] = (byte)object3;
        Object object413 = object3 = new byte[6];
        Object object414 = object3;
        object413[0] = 0;
        object414[1] = 11;
        object413[2] = 6;
        object414[3] = 7;
        object413[4] = 12;
        object414[5] = 37;
        object2[n3] = (byte)object3;
        Object object415 = object3 = new byte[6];
        Object object416 = object3;
        object415[0] = 6;
        object416[1] = 11;
        object415[2] = 12;
        object416[3] = 5;
        object415[4] = 0;
        object416[5] = 23;
        object2[n5] = (byte)object3;
        Object object417 = object3 = new byte[6];
        Object object418 = object3;
        object417[0] = 23;
        object418[1] = 0;
        object417[2] = 2;
        object418[3] = 13;
        object417[4] = 28;
        object418[5] = 44;
        object2[n4] = (byte)object3;
        Object object419 = object3 = new byte[6];
        Object object420 = object3;
        object419[0] = 18;
        object420[1] = 0;
        object419[2] = 10;
        object420[3] = 11;
        object419[4] = 44;
        object420[5] = 0;
        object2[n2] = (byte)object3;
        Object object421 = object23 = new byte[6];
        Object object422 = object23;
        object421[0] = 22;
        object422[1] = 11;
        object421[2] = 6;
        object422[3] = 7;
        object421[4] = 38;
        object422[5] = 35;
        object2[5] = (byte)object23;
        object[0] = (int)object2;
        object2 = new byte[7][];
        Object object423 = object3 = new byte[6];
        Object object424 = object3;
        object423[0] = 0;
        object424[1] = 11;
        object423[2] = 6;
        object424[3] = 7;
        object423[4] = 18;
        object424[5] = 30;
        object2[0] = (byte)object3;
        Object object425 = object3 = new byte[6];
        Object object426 = object3;
        object425[0] = 11;
        object426[1] = 0;
        object425[2] = 13;
        object426[3] = 11;
        object425[4] = 10;
        object426[5] = 8;
        object2[n3] = (byte)object3;
        Object object427 = object3 = new byte[6];
        Object object428 = object3;
        object427[0] = 6;
        object428[1] = 11;
        object427[2] = 12;
        object428[3] = 5;
        object427[4] = 12;
        object428[5] = 24;
        object2[n5] = (byte)object3;
        Object object429 = object3 = new byte[6];
        Object object430 = object3;
        object429[0] = 23;
        object430[1] = 0;
        object429[2] = 2;
        object430[3] = 13;
        object429[4] = 29;
        object430[5] = 33;
        object2[n4] = (byte)object3;
        Object object431 = object3 = new byte[6];
        Object object432 = object3;
        object431[0] = 25;
        object432[1] = 0;
        object431[2] = 3;
        object432[3] = 13;
        object431[4] = 28;
        object432[5] = 2;
        object2[n2] = (byte)object3;
        Object object433 = object23 = new byte[6];
        Object object434 = object23;
        object433[0] = 5;
        object434[1] = 0;
        object433[2] = 13;
        object434[3] = 11;
        object433[4] = 32;
        object434[5] = 11;
        object2[5] = (byte)object23;
        Object object435 = object23 = new byte[6];
        Object object436 = object23;
        object435[0] = 22;
        object436[1] = 11;
        object435[2] = 6;
        object436[3] = 7;
        object435[4] = 36;
        object436[5] = 34;
        object2[6] = (byte)object23;
        object[n3] = (int)object2;
        this.m1150 = (byte[][][])object;
        Object object437 = object = (Object)new byte[7];
        Object object438 = object;
        object437[0] = 6;
        object438[1] = 6;
        object437[2] = 5;
        object438[3] = 5;
        object437[4] = 4;
        object438[5] = 4;
        object438[6] = 4;
        this.A1151 = (byte[])object;
        this.n1152 = new int[80];
        this.o1153 = new int[80];
        this.p1154 = new int[30];
        this.bA = 0;
        this.bB = 0;
        this.bC = 0;
        this.bD = 0;
        this.y1155 = n3;
        this.bE = 16;
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = 0;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 0;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 1;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = 1;
        object[n4] = (int)object2;
        this.O1156 = (byte[][])object;
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = -1;
        object2[1] = -1;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = -1;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 1;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -1;
        object2[1] = 1;
        object[n4] = (int)object2;
        this.P1157 = (byte[][])object;
        Object object439 = object = new int[8];
        Object object440 = object;
        object439[0] = 13450878;
        object440[1] = 13450878;
        object439[2] = 14567546;
        object440[3] = 14567546;
        object439[4] = 16736642;
        object440[5] = 16736642;
        object439[6] = 14567546;
        object440[7] = 14567546;
        this.q1158 = object;
        object = new byte[n2][];
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = -1;
        object[0] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 1;
        object2[1] = 0;
        object[n3] = (int)object2;
        object2 = new byte[n5];
        object2[0] = 0;
        object2[1] = 1;
        object[n5] = (int)object2;
        object2 = new byte[n5];
        object2[0] = -1;
        object2[1] = 0;
        object[n4] = (int)object2;
        this.Q1159 = (byte[][])object;
        this.bK = 5;
        Object object441 = object = new int[8];
        Object object442 = object;
        object441[0] = 49;
        object442[1] = 57;
        object441[2] = 56;
        object442[3] = 48;
        object441[4] = 49;
        object442[5] = 50;
        object441[6] = 49;
        object442[7] = 53;
        this.r1166 = object;
        Object object443 = object = new int[8];
        Object object444 = object;
        object443[0] = 57;
        object444[1] = 52;
        object443[2] = 52;
        object444[3] = 49;
        object443[4] = 49;
        object444[5] = 52;
        object443[6] = 49;
        object444[7] = 49;
        this.s1167 = object;
        Object object445 = object = new int[8];
        Object object446 = object;
        object445[0] = 49;
        object446[1] = 56;
        object445[2] = 55;
        object446[3] = 56;
        object445[4] = 49;
        object446[5] = 54;
        object445[6] = 56;
        object446[7] = 51;
        this.t1168 = object;
        object = new String[15];
        object[0] = (int)"\u6fc0\u6d3b\u540e\u53ef\u7acb\u5373\u6d88\u706d\u5f53\u524d\u6240\u6709\u654c\u4eba\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        object[n3] = (int)"\u6fc0\u6d3b\u540e\u53ef\u7acb\u5373\u83b7\u5f97\u5168\u90e8\u79d1\u6280\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        object[n5] = (int)"\u6fc0\u6d3b\u540e\u53ef\u7acb\u5373\u83b7\u5f97500\u91d1\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        object[n4] = (int)"\u6fc0\u6d3b\u540e\u53ef\u7acb\u5373\u83b7\u5f9710\u70b9\u57ce\u9632\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        object[n2] = (int)"\u6d88\u706d\u654c\u4eba\u52a0\u94b1\u7ffb\u500d\uff0c\u6fc0\u6d3b\u540e\u53ef\u4eab\u53d7\u6b64\u670d\u52a1\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        object[5] = (int)"\u6b64\u5173\u5361\u4e3a\u6536\u8d39\u5173\u5361\uff0c\u7ee7\u7eed\u6e38\u620f\u9700\u6fc0\u6d3b\u540e\u53ef\u4eab\u53d7\u6b64\u670d\u52a1\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        object[6] = (int)"\u7ee7\u7eed\u4e0a\u6b21\u9000\u51fa\u65f6\u7684\u8ba1\u8d39\u5b58\u6863\uff0c\u6fc0\u6d3b\u540e\u53ef\u4eab\u53d7\u6b64\u670d\u52a1\u3002[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        object[7] = (int)"\u68c0\u67e5\u66f4\u65b0\u4e2d\u2026\u2026";
        object[8] = (int)"\u6fc0\u6d3b\u4e2d\u2026\u2026";
        object[9] = (int)"\u6210\u529f\uff01[\u7531yc\u6fc0\u6d3b\u5206\u4eab]";
        object[10] = (int)"\u8d2d\u4e70\u5931\u8d25\uff01\u662f\u5426\u91cd\u8bd5\uff1f";
        object[11] = (int)"\u53d1\u9001\u77ed\u4fe1\u4e0d\u6210\u529f\uff0c\u53ef\u80fd\u56e0\u4e3a\u60a8\u4f7f\u7528\u7684\u4e0d\u662f\u5b98\u65b9\u7248\u672c\u3002\u4e0b\u8f7d\u5b98\u65b9\u7248\u672c\u8bf7\u624b\u673a\u8bbf\u95eewap.kgame.com.cn";
        object[12] = (int)"\u5546\u5e97";
        object[13] = (int)"\u66f4\u591a\u6e38\u620f";
        object[14] = (int)"\u89c6\u9891\u4e0b\u8f7d";
        this.d1173 = (String[])object;
        this.D1176 = n3;
        this.a1193 = null;
        this.au();
        this.aw();
        this.l = 0;
        this.al = n5;
    }

    /*
     * Unable to fully structure code
     */
    private void A() {
        var1_1 = 3;
        var2_2 = 1;
        var3_3 = -1;
        var4_4 = 2;
        var5_5 = this.m1033;
        if (var5_5 != 0) {
            this.w();
lbl8:
            // 24 sources

            return;
        }
        var5_5 = this.l;
        switch (var5_5) {
            default: {
                ** GOTO lbl8
            }
            case 0: {
                var5_5 = this.al;
                if (var5_5 != var4_4) break;
            }
            case 19: {
                this.y();
                ** GOTO lbl8
            }
            case 24: {
                this.ak();
                this.Y();
                this.ag();
                this.H();
                this.ap();
                this.c(var4_4, var2_2);
                ** GOTO lbl8
            }
            case 46: 
            case 47: 
            case 48: {
                this.ar();
                ** GOTO lbl8
            }
        }
        var6_6 = this.b1032;
        if (var6_6 == null) ** GOTO lbl8
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(0xFFFFFF);
        var6_6 = this.a1002;
        var1_1 = 240;
        var6_6.fillRect(0, 0, var1_1, 320);
        var6_6 = this.a1002;
        var7_10 = this.b1032;
        var8_12 = this.b1032;
        var9_13 = var8_12.getWidth();
        var10_17 = 240 - var9_13 >> 1;
        var11_21 = this.b1032;
        var2_2 = var11_21.getHeight();
        var9_13 = 320 - var2_2 >> 1;
        var6_6.drawImage(var7_10, var10_17, var9_13, 0);
        ** GOTO lbl8
        {
            case 18: {
                this.h();
                ** GOTO lbl8
            }
            case 1: {
                this.l();
                ** GOTO lbl8
            }
            case 15: {
                this.q();
                this.c(var4_4, var1_1);
                ** GOTO lbl8
            }
            case 17: {
                this.s();
                this.c(var4_4, var1_1);
                ** GOTO lbl8
            }
            case 16: {
                this.v();
                var5_5 = (int)this.t1089;
                if (var5_5 != 0) ** GOTO lbl68
                this.c(var4_4, var1_1);
                ** GOTO lbl8
lbl68:
                // 1 sources

                this.c(var4_4, var3_3);
                ** GOTO lbl8
            }
            case 23: {
                this.ak();
                this.am();
                this.ac();
                this.H();
                this.c(var4_4, var3_3);
                ** GOTO lbl8
            }
            case 22: {
                this.ak();
                this.Y();
                this.ag();
                this.am();
                this.Z();
                this.H();
                this.c(var4_4, var3_3);
                ** GOTO lbl8
            }
            case 2: {
                this.ak();
                this.Y();
                this.ag();
                this.am();
                this.H();
                this.S();
                this.c(var4_4, 0);
                ** GOTO lbl8
            }
            case 13: 
            case 14: {
                this.ak();
                this.Y();
                this.ag();
                this.am();
                this.H();
                this.c(var4_4, var2_2);
                ** GOTO lbl8
            }
            case 12: {
                this.ak();
                this.Y();
                this.ag();
                this.H();
                this.c(var4_4, var2_2);
                ** GOTO lbl8
            }
            case 3: {
                this.ak();
                this.Y();
                this.ag();
                this.H();
                this.j();
                this.c(var4_4, var3_3);
                ** GOTO lbl8
            }
            case 4: 
            case 20: {
                var6_7 = this.b1015[var2_2];
                this.a(var6_7);
                var5_5 = this.l;
                var1_1 = 20;
                if (var5_5 == var1_1) {
                    var5_5 = 5;
                    var12_22 = this.a1013[4];
                    var9_14 = 25;
                    var12_22 = var12_22[var9_14];
                    var10_18 = var12_22.getWidth();
                    var1_1 = 240 - var10_18 >> 1;
                    this.c(var5_5, var1_1, 0);
                }
                this.c(var3_3, var2_2);
                ** GOTO lbl8
            }
            case 5: 
            case 21: {
                var6_8 = this.b1015[0];
                this.a(var6_8);
                var5_5 = this.l;
                var1_1 = 21;
                if (var5_5 == var1_1) {
                    var5_5 = 4;
                    var12_23 = this.a1013[4];
                    var9_15 = 25;
                    var12_23 = var12_23[var9_15];
                    var10_19 = var12_23.getWidth();
                    var1_1 = 240 - var10_19 >> 1;
                    this.c(var5_5, var1_1, 0);
                }
                this.c(var3_3, var2_2);
                ** GOTO lbl8
            }
            case 8: {
                this.a((boolean)var2_2);
                this.c(var4_4, var3_3);
                ** GOTO lbl8
            }
            case 9: {
                this.a(false);
                this.c(var4_4, var3_3);
                ** GOTO lbl8
            }
            ** case 10:
        }
lbl157:
        // 1 sources

        this.W();
        var7_11 = this.a1013[var1_1][var1_1];
        var9_16 = 13450878;
        var6_9 = this;
        var10_20 = false;
        var12_24 = null;
        this.a(var7_11, 0, 0, var9_16, (boolean)var2_2);
        this.c(var4_4, var3_3);
        ** while (true)
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void A(int n) {
        int[] nArray = this.c1107[n];
        int[][] nArray2 = this.b1066;
        int n2 = nArray[8];
        int[] nArray3 = nArray2[n2];
        int n3 = nArray[2];
        switch (n3) {
            case 0: 
            case 4: {
                boolean bl;
                void var6_31;
                int n4 = nArray[13];
                n2 = 4;
                if (n4 < n2) {
                    int n5 = 13;
                    nArray[n5] = n2 = nArray[n5] + 1;
                }
                boolean bl2 = false;
                Object var3_4 = null;
                while (var6_31 < (n2 = 5)) {
                    byte[] byArray = this.C1134[n];
                    int n6 = byArray[var6_31];
                    byte by = 1;
                    byArray[var6_31] = n6 = (byte)(n6 - by);
                    n2 = -1;
                    if (n6 < n2) {
                        byte[] byArray2 = this.C1134[n];
                        byArray2[var6_31] = n6 = -1;
                    }
                    ++var6_31;
                }
                int n7 = nArray[13];
                n2 = 1;
                if (n7 == n2) {
                    int n8;
                    int n9 = nArray[2];
                    n2 = 4;
                    if (n9 == n2 && (n8 = nArray3[26]) == (n2 = 6)) {
                        int n10 = 27;
                        nArray3[n10] = n2 = -1;
                    } else {
                        int n11 = nArray[8];
                        n2 = nArray[2];
                        byte[] byArray = this.s1102;
                        int n12 = nArray[3];
                        n2 = this.a(n2, byArray, n12);
                        this.v(n11, n2, n);
                    }
                }
                if (!(bl = this.i(n))) return;
                this.x(n);
                return;
            }
            case 1: {
                int n13;
                Object var3_5 = null;
                int n14 = nArray[0];
                byte[] byArray = this.o1098;
                int n15 = nArray[2];
                n2 = byArray[n15] << 3;
                int n16 = n14 + n2;
                n2 = nArray[11] << 2;
                int n17 = n16 + n2;
                int n18 = nArray[1];
                byte[] byArray3 = this.o1098;
                n15 = nArray[2];
                n2 = byArray3[n15] << 3;
                int n19 = n18 + n2;
                n2 = nArray[12] << 2;
                int n20 = n19 + n2;
                int n21 = 13;
                nArray[n21] = n2 = nArray[n21] + 1;
                int n22 = 12;
                if (n2 > n22) {
                    int n23 = 13;
                    n2 = 0;
                    Object var7_136 = null;
                    nArray[n23] = 0;
                    this.x(n);
                    return;
                }
                int n24 = nArray[13];
                n2 = 4;
                if (n24 != n2) return;
                boolean bl = false;
                Object var3_6 = null;
                int n25 = 0;
                while (n25 < (n13 = this.aP)) {
                    int[] nArray4 = this.b1066[n25];
                    n13 = nArray4[0];
                    int[] nArray5 = this.b1066[n25];
                    n2 = nArray5[1];
                    n15 = n17 - 24;
                    int n26 = n20 - 24;
                    int n27 = 48;
                    int n28 = 48;
                    if ((n13 = (int)(a.a(n13, n2, n15, n26, n27, n28) ? 1 : 0)) != 0 && n25 != (n13 = nArray[8])) {
                        n13 = nArray3[26];
                        n2 = 8;
                        if (n13 == n2) {
                            n13 = 27;
                            nArray3[n13] = n2 = -1;
                        } else {
                            n13 = nArray[2];
                            byte[] byArray4 = this.s1102;
                            n15 = nArray[3] >> 2;
                            n13 = this.a(n13, byArray4, n15);
                            this.v(n25, n13, n);
                        }
                    }
                    n25 = n13 = n25 + 1;
                }
                int n29 = nArray3[26];
                n2 = 8;
                if (n29 == n2) {
                    int n30 = 27;
                    nArray3[n30] = n2 = -1;
                    return;
                }
                int n31 = nArray[8];
                n2 = nArray[2];
                byte[] byArray5 = this.s1102;
                int n32 = nArray[3];
                n2 = this.a(n2, byArray5, n32);
                this.v(n31, n2, n);
                return;
            }
            case 6: {
                int n33;
                int n34 = 13;
                nArray[n34] = n2 = nArray[n34] + 1;
                int n35 = 5;
                if (n2 > n35) {
                    Object var7_141 = null;
                    nArray[13] = 0;
                    n2 = nArray[0];
                    n33 = nArray[1];
                    int n36 = 5;
                    int n37 = nArray[n36];
                    boolean bl = false;
                    boolean bl3 = false;
                    boolean bl4 = true;
                    a a2 = this;
                    this.a(n2, n33, n37, (byte)0, 0, bl4);
                    this.x(n);
                } else {
                    n2 = nArray[0];
                    n33 = nArray[1];
                    int n38 = 5;
                    int n39 = nArray[n38];
                    byte by = 4;
                    boolean bl = false;
                    boolean bl5 = true;
                    a a3 = this;
                    this.a(n2, n33, n39, by, 0, bl5);
                }
                int n40 = nArray[2];
                n2 = nArray[3];
                n33 = nArray[5];
                this.h(n, n40, n2, n33);
                return;
            }
            case 2: {
                int n41;
                int n42 = 13;
                nArray[n42] = n2 = nArray[n42] + 1;
                int n43 = 12;
                if (n2 > n43) {
                    n2 = nArray[0];
                    n41 = nArray[1];
                    int n44 = 5;
                    int n45 = nArray[n44];
                    byte by = 1;
                    boolean bl = false;
                    boolean bl6 = true;
                    a a4 = this;
                    this.a(n2, n41, n45, by, 0, bl6);
                    this.x(n);
                } else {
                    int n46;
                    int n47;
                    int n48;
                    byte by;
                    int n49 = nArray[13] >> 2;
                    n2 = 3;
                    if (n49 < n2) {
                        n2 = nArray[0];
                        n41 = nArray[1];
                        int n50 = nArray[5];
                        by = 5;
                        int n51 = nArray[13] >> 2;
                        n48 = n51 + 1;
                        boolean bl = true;
                        a a5 = this;
                        this.a(n2, n41, n50, by, n48, bl);
                    }
                    if ((n47 = nArray[13]) > (n2 = 6) && (n46 = nArray[13] % 3) == 0) {
                        n2 = nArray[0];
                        n41 = nArray[1];
                        int n52 = nArray[5];
                        by = 1;
                        int n53 = nArray[13] - 6;
                        n48 = (nArray[13] - 6) / 3 + n53;
                        boolean bl = true;
                        a a6 = this;
                        this.a(n2, n41, n52, by, n48, bl);
                    }
                }
                int n54 = nArray[2];
                n2 = nArray[3];
                n41 = nArray[5];
                this.h(n, n54, n2, n41);
                return;
            }
            case 10: {
                int n55 = nArray[10];
                switch (n55) {
                    default: {
                        return;
                    }
                    case 1: {
                        void var6_74;
                        int n56 = 13;
                        nArray[n56] = n2 = nArray[n56] + 1;
                        int n57 = 4;
                        if (n2 <= n57) return;
                        Object var3_14 = null;
                        n2 = nArray[0];
                        int n58 = nArray[1];
                        int n59 = nArray[5];
                        int n60 = nArray[2];
                        byte by = nArray[3];
                        boolean bl = this.k(n60, by);
                        if (bl) {
                            int n61 = 40;
                        } else {
                            int n62 = 10;
                        }
                        by = (byte)(var6_74 + 6);
                        boolean bl7 = false;
                        boolean bl8 = true;
                        a a7 = this;
                        this.a(n2, n58, n59, by, 0, bl8);
                        int n63 = nArray[2];
                        n2 = nArray[3];
                        n58 = nArray[5];
                        this.h(n, n63, n2, n58);
                        Object var7_142 = null;
                        nArray[13] = 0;
                        int n64 = 10;
                        nArray[n64] = n2 = 2;
                        return;
                    }
                    case 2: 
                }
                int n65 = 13;
                nArray[n65] = n2 = nArray[n65] + 1;
                int n66 = 9;
                if (n2 <= n66) return;
                this.x(n);
                return;
            }
            case 8: 
            case 9: {
                int n67;
                int n68 = nArray[10];
                switch (n68) {
                    case 0: {
                        byte by;
                        byte by2;
                        int n69 = 13;
                        nArray[n69] = n2 = nArray[n69] + 1;
                        int n70 = 2;
                        if (n2 <= n70) break;
                        Object var3_16 = null;
                        n2 = nArray[0];
                        n67 = nArray[1];
                        int n71 = nArray[5];
                        byte by3 = nArray[2];
                        byte by4 = 8;
                        by4 = by3 == by4 ? (by2 = 3) : (by = 2);
                        int n72 = nArray[2];
                        int n73 = nArray[3];
                        boolean bl = this.m(n72, n73);
                        if (bl) {
                            boolean bl9 = false;
                            Object var3_17 = null;
                            n73 = 0;
                        } else {
                            int n74;
                            n73 = n74 = 2;
                        }
                        boolean bl10 = false;
                        nArray3 = null;
                        a a8 = this;
                        this.a(n2, n67, n71, by4, n73, false);
                        nArray[10] = 1;
                        int n75 = 13;
                        n2 = 0;
                        Object var7_143 = null;
                        nArray[n75] = 0;
                        break;
                    }
                    case 1: {
                        void var6_99;
                        int n76 = 13;
                        nArray[n76] = n2 = nArray[n76] + 1;
                        int n77 = nArray[2];
                        n67 = nArray[3];
                        boolean bl = this.j(n77, n67);
                        if (bl) {
                            int n78 = 20;
                        } else {
                            int n79 = 10;
                        }
                        if (n2 <= var6_99) break;
                        nArray[10] = 2;
                        int n80 = 13;
                        n2 = 0;
                        Object var7_144 = null;
                        nArray[n80] = 0;
                        break;
                    }
                    case 2: {
                        int n81 = 13;
                        nArray[n81] = n2 = nArray[n81] + 1;
                        int n82 = 1;
                        if (n2 <= n82) break;
                        Object var7_145 = null;
                        nArray[13] = 0;
                        Object var3_19 = null;
                        n2 = nArray[0];
                        n67 = nArray[1];
                        int n83 = nArray[5];
                        byte by = 1;
                        int n84 = nArray[2];
                        int n85 = nArray[3];
                        boolean bl = this.m(n84, n85);
                        if (bl) {
                            boolean bl11 = false;
                            Object var3_20 = null;
                            n85 = 0;
                        } else {
                            int n86;
                            n85 = n86 = 2;
                        }
                        boolean bl12 = false;
                        nArray3 = null;
                        a a9 = this;
                        this.a(n2, n67, n83, by, n85, false);
                        int n87 = nArray[16];
                        if (n87 != 0) {
                            int n88 = 16;
                            n2 = 0;
                            Object var7_146 = null;
                            nArray[n88] = 0;
                        }
                        this.x(n);
                        break;
                    }
                }
                int n89 = nArray[2];
                n2 = nArray[3];
                n67 = nArray[5];
                this.h(n, n89, n2, n67);
                return;
            }
            case 3: 
            case 5: 
            case 7: {
                void var6_129;
                int n90;
                int n91;
                int n92 = nArray[10];
                if (n92 == 0) {
                    int n93 = 13;
                    nArray[n93] = n2 = nArray[n93] + 1;
                    int n94 = 12;
                    if (n2 <= n94) return;
                    boolean bl = this.e(n);
                    if (!bl) return;
                    Object var7_147 = null;
                    nArray[13] = 0;
                    nArray[10] = 1;
                    int n95 = nArray[2];
                    n2 = 5;
                    if (n95 == n2) {
                        int n96 = nArray[8];
                        n2 = nArray[2];
                        byte[] byArray = this.s1102;
                        int n97 = nArray[3];
                        n2 = this.a(n2, byArray, n97);
                        this.v(n96, n2, n);
                        return;
                    }
                    int n98 = nArray[2];
                    n2 = 3;
                    if (n98 != n2) return;
                    int n99 = nArray3[26];
                    n2 = 5;
                    if (n99 == n2) return;
                    int n100 = nArray[8];
                    n2 = nArray[2];
                    byte[] byArray = this.s1102;
                    int n101 = nArray[3];
                    n2 = this.a(n2, byArray, n101);
                    this.v(n100, n2, n);
                    return;
                }
                int n102 = nArray[10];
                n2 = 1;
                if (n102 != n2) return;
                int n103 = nArray[2];
                n2 = 7;
                if (n103 == n2 && (n91 = nArray[13]) == (n2 = 3)) {
                    int n104;
                    int n105;
                    boolean bl = false;
                    Object var3_22 = null;
                    boolean bl13 = false;
                    nArray3 = null;
                    while (n105 < (n104 = this.aP)) {
                        int[] nArray6 = this.b1066[n105];
                        n104 = nArray6[0];
                        int[] nArray7 = this.b1066[n105];
                        n2 = nArray7[1];
                        int[][] nArray8 = this.b1066;
                        int n106 = nArray[8];
                        int[] nArray9 = nArray8[n106];
                        n90 = nArray9[0] - 24;
                        int[][] nArray10 = this.b1066;
                        int n107 = nArray[8];
                        int[] nArray11 = nArray10[n107];
                        n106 = nArray11[1] - 24;
                        int n108 = 48;
                        if ((n104 = (int)(a.a(n104, n2, n90, n106, n107 = 48, n108) ? 1 : 0)) != 0 && n105 != (n104 = nArray[8])) {
                            n104 = nArray[2];
                            byte[] byArray = this.s1102;
                            n90 = nArray[3] >> 2;
                            n104 = this.a(n104, byArray, n90);
                            this.v(n105, n104, n);
                        }
                        n105 = n104 = n105 + true;
                    }
                    int n109 = nArray[8];
                    n2 = nArray[2];
                    byte[] byArray = this.s1102;
                    int n110 = nArray[3];
                    n2 = this.a(n2, byArray, n110);
                    this.v(n109, n2, n);
                }
                int n111 = 13;
                nArray[n111] = n2 = nArray[n111] + 1;
                int n112 = nArray[2];
                n90 = 7;
                if (n112 == n90) {
                    int n113 = 16;
                } else {
                    int n114 = 6;
                }
                if (n2 <= var6_129) return;
                this.x(n);
                return;
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void B(int n) {
        int n2;
        this.getClass();
        Object object = new StringBuffer();
        String string = "/mapdatalv";
        object = Display.getResourceAsStream((String)((StringBuffer)object).append(string).append(n).toString());
        try {
            n2 = a.a((InputStream)object);
        }
        catch (Exception exception) {
            return;
        }
        this.bG = n2;
        n2 = a.a((InputStream)object);
        this.bH = n2;
        n2 = this.bG;
        int n3 = this.bH;
        n2 *= n3;
        n3 = this.bG << 4;
        this.bI = n3;
        n3 = this.bH << 4;
        this.bJ = n3;
        byte[] byArray = new byte[n2];
        this.B1160 = byArray;
        byArray = new byte[n2];
        this.C1161 = byArray;
        byArray = this.B1160;
        ((InputStream)object).read(byArray, 0, n2);
        byArray = this.C1161;
        ((InputStream)object).read(byArray, 0, n2);
        ((InputStream)object).close();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void C() {
        void var5_9;
        boolean[] blArray;
        int n;
        byte[] byArray;
        int n2;
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        int n3;
        int n4 = 11;
        int n5 = 1;
        Object object = "sanGuoTd";
        boolean bl = false;
        Object var5_7 = null;
        try {
            try {
                RecordStore recordStore = RecordStore.openRecordStore((String)object, (boolean)false);
                n3 = 0;
                object = null;
            }
            catch (RecordStoreNotFoundException recordStoreNotFoundException) {
                object = "sanGuoTd";
                bl = true;
                object = RecordStore.openRecordStore((String)object, (boolean)bl);
                String string = object;
                n3 = n5;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            n2 = this.aP;
            dataOutputStream.writeInt(n2);
            byArray = null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        for (n2 = 0; n2 < (n = this.aP); n2 += 1) {
            int n6;
            blArray = null;
            for (n = 0; n < (n6 = 28); ++n) {
                int[][] nArray = this.b1066;
                int[] nArray2 = nArray[n2];
                n6 = nArray2[n];
                dataOutputStream.writeInt(n6);
            }
        }
        n2 = this.bt;
        dataOutputStream.writeInt(n2);
        byArray = null;
        for (n2 = 0; n2 < (n = this.bt); n2 += 1) {
            int n7;
            blArray = null;
            for (n = 0; n < (n7 = 18); ++n) {
                int[][] nArray = this.c1107;
                int[] nArray3 = nArray[n2];
                n7 = nArray3[n];
                dataOutputStream.writeInt(n7);
            }
        }
        byArray = null;
        for (n2 = 0; n2 < (n = 5); n2 += 1) {
            blArray = this.a1056;
            n = blArray[n2];
            if (n == 0) {
                n = 0;
                blArray = null;
            } else {
                n = n5;
            }
            dataOutputStream.writeBoolean(n != 0);
        }
        byArray = null;
        for (n2 = 0; n2 < (n = 10); n2 += 1) {
            blArray = this.b1059;
            n = blArray[n2];
            if (n == 0) {
                n = 0;
                blArray = null;
            } else {
                n = n5;
            }
            dataOutputStream.writeBoolean(n != 0);
        }
        byArray = null;
        for (n2 = 0; n2 < n4; n2 += 1) {
            blArray = this.e1105;
            n = blArray[n2];
            if (n == 0) {
                n = 0;
                blArray = null;
            } else {
                n = n5;
            }
            dataOutputStream.writeBoolean(n != 0);
        }
        byArray = null;
        for (n2 = 0; n2 < n4; n2 += 1) {
            blArray = this.f1106;
            n = blArray[n2];
            if (n == 0) {
                n = 0;
                blArray = null;
            } else {
                n = n5;
            }
            dataOutputStream.writeBoolean(n != 0);
        }
        n2 = this.aq;
        dataOutputStream.writeInt(n2);
        n2 = this.bj;
        dataOutputStream.writeInt(n2);
        n2 = this.bN;
        dataOutputStream.writeInt(n2);
        n2 = this.bO;
        dataOutputStream.writeInt(n2);
        n2 = this.bP;
        dataOutputStream.writeInt(n2);
        n2 = this.bQ;
        dataOutputStream.writeInt(n2);
        n2 = this.T;
        dataOutputStream.writeInt(n2);
        n2 = this.aO;
        dataOutputStream.writeInt(n2);
        n2 = this.aS;
        dataOutputStream.writeInt(n2);
        n2 = this.X;
        dataOutputStream.writeInt(n2);
        n2 = this.bz;
        dataOutputStream.writeInt(n2);
        n2 = this.by;
        dataOutputStream.writeInt(n2);
        n2 = this.aT;
        dataOutputStream.writeInt(n2);
        n2 = this.aQ;
        dataOutputStream.writeInt(n2);
        n2 = this.ay;
        dataOutputStream.writeInt(n2);
        n2 = this.az;
        dataOutputStream.writeInt(n2);
        n2 = this.p1078 ? 1 : 0;
        dataOutputStream.writeBoolean(n2 != 0);
        n2 = this.bL;
        dataOutputStream.writeInt(n2);
        n2 = this.bM;
        dataOutputStream.writeInt(n2);
        n2 = this.ac;
        dataOutputStream.writeInt(n2);
        n2 = this.aV;
        dataOutputStream.writeInt(n2);
        n2 = this.aW;
        dataOutputStream.writeInt(n2);
        n2 = this.aX;
        dataOutputStream.writeInt(n2);
        n2 = this.aY;
        dataOutputStream.writeInt(n2);
        n2 = this.aZ;
        dataOutputStream.writeInt(n2);
        n2 = this.ba;
        dataOutputStream.writeInt(n2);
        n2 = this.bb;
        dataOutputStream.writeInt(n2);
        n2 = this.z1169 ? 1 : 0;
        dataOutputStream.writeBoolean(n2 != 0);
        if (n3 != 0) {
            object = byteArrayOutputStream.toByteArray();
            n2 = 0;
            byArray = null;
            n = byteArrayOutputStream.size();
            var5_9.addRecord((byte[])object, 0, n);
        } else {
            n3 = 1;
            byArray = byteArrayOutputStream.toByteArray();
            n = 0;
            blArray = null;
            int n8 = byteArrayOutputStream.size();
            var5_9.setRecord(n3, byArray, 0, n8);
        }
        dataOutputStream.close();
        byteArrayOutputStream.close();
        var5_9.closeRecordStore();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void C(int n) {
        int n2;
        this.getClass();
        Object object = new StringBuffer();
        String string = "/mapdata";
        object = Display.getResourceAsStream((String)((StringBuffer)object).append(string).append(n).toString());
        try {
            n2 = ((InputStream)object).read();
        }
        catch (Exception exception) {
            return;
        }
        int n3 = ((InputStream)object).read();
        n2 *= n3;
        byte[] byArray = new byte[n2];
        this.E1163 = byArray;
        byArray = new byte[n2];
        this.D1162 = byArray;
        byArray = this.E1163;
        ((InputStream)object).read(byArray, 0, n2);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void D() {
        int n = 1;
        int n2 = 0;
        Object object = "sanGuoTdData";
        boolean bl = false;
        Object var5_7 = null;
        try {
            void var5_9;
            byte[] byArray;
            int n3;
            int n4;
            int n5;
            try {
                RecordStore recordStore = RecordStore.openRecordStore((String)object, (boolean)false);
                n5 = 0;
                object = null;
            }
            catch (RecordStoreNotFoundException recordStoreNotFoundException) {
                object = "sanGuoTdData";
                bl = true;
                object = RecordStore.openRecordStore((String)object, (boolean)bl);
                String string = object;
                n5 = n;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            byte[] byArray2 = null;
            for (n4 = 0; n4 < (n3 = (byArray = this.E1163).length); ++n4) {
                byArray = this.E1163;
                n3 = byArray[n4];
                dataOutputStream.writeByte(n3);
            }
            byArray2 = null;
            for (n4 = 0; n4 < (n3 = (byArray = this.D1162).length); ++n4) {
                byArray = this.D1162;
                n3 = byArray[n4];
                dataOutputStream.writeByte(n3);
            }
            if (n5 != 0) {
                object = byteArrayOutputStream.toByteArray();
                n4 = 0;
                byArray2 = null;
                n3 = byteArrayOutputStream.size();
                var5_9.addRecord((byte[])object, 0, n3);
            } else {
                n5 = 1;
                byArray2 = byteArrayOutputStream.toByteArray();
                n3 = 0;
                byArray = null;
                n2 = byteArrayOutputStream.size();
                var5_9.setRecord(n5, byArray2, 0, n2);
            }
            dataOutputStream.close();
            byteArrayOutputStream.close();
            var5_9.closeRecordStore();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void D(int n) {
        int n2;
        this.getClass();
        Object object = new StringBuffer();
        String string = "/mapsp";
        object = Display.getResourceAsStream((String)((StringBuffer)object).append(string).append(n).toString());
        try {
            n2 = a.a((InputStream)object);
        }
        catch (Exception exception) {
            return;
        }
        short s = a.a((InputStream)object);
        n2 *= s;
        byte[] byArray = new byte[n2];
        this.F1164 = byArray;
        byArray = new byte[n2];
        this.G1165 = byArray;
        byArray = this.F1164;
        ((InputStream)object).read(byArray, 0, n2);
        byArray = this.G1165;
        ((InputStream)object).read(byArray, 0, n2);
        ((InputStream)object).close();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void E() {
        void var5_9;
        boolean[] blArray;
        int n;
        int n2;
        byte[] byArray;
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        int n3;
        int n4 = 1;
        int n5 = 0;
        Object object = "freeGame";
        boolean bl = false;
        Object var5_7 = null;
        try {
            try {
                RecordStore recordStore = RecordStore.openRecordStore((String)object, (boolean)false);
                n3 = 0;
                object = null;
            }
            catch (RecordStoreNotFoundException recordStoreNotFoundException) {
                object = "freeGame";
                bl = true;
                object = RecordStore.openRecordStore((String)object, (boolean)bl);
                String string = object;
                n3 = n4;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            byArray = null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        for (n2 = 0; n2 < (n = 9); ++n2) {
            blArray = this.d1073;
            n = blArray[n2];
            if (n == 0) {
                n = 0;
                blArray = null;
            } else {
                n = n4;
            }
            dataOutputStream.writeBoolean(n != 0);
        }
        if (n3 != 0) {
            object = byteArrayOutputStream.toByteArray();
            n2 = 0;
            byArray = null;
            n = byteArrayOutputStream.size();
            var5_9.addRecord((byte[])object, 0, n);
        } else {
            n3 = 1;
            byArray = byteArrayOutputStream.toByteArray();
            n = 0;
            blArray = null;
            n5 = byteArrayOutputStream.size();
            var5_9.setRecord(n3, byArray, 0, n5);
        }
        dataOutputStream.close();
        byteArrayOutputStream.close();
        var5_9.closeRecordStore();
    }

    private void E(int n) {
        Object object;
        Object object2;
        boolean bl = true;
        int n2 = 304;
        this.a1004 = object2 = Image.createImage((int)256, (int)n2);
        object2 = this.a1004.getGraphics();
        this.b1003 = object2;
        this.y1155 = bl;
        this.bL = object = this.m1075[n] + 5;
        object2 = this.n1076;
        this.bM = object = (Object)(object2[n] + 34 - bl);
        object = this.bL;
        this.c((int)object);
        this.bK = object = this.bL;
        if (n != 0) {
            object = this.bM;
            this.c((int)object);
            this.D(n);
        }
        this.B(n);
        this.C(n);
    }

    private void F() {
        int n;
        int n2 = -1;
        for (int i = 0; i < (n = 15); ++i) {
            int[] nArray = this.h1041;
            nArray[i] = n2;
            n = 1;
            if (i >= n) continue;
            nArray = this.i1044;
            nArray[i] = n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void F(int n) {
        int n2 = n;
        this.bW = n2;
        n2 = this.E1179 ? 1 : 0;
        if (n2 != 0) {
            this.b1174 = 0;
            n2 = 46;
            this.a(n2);
            return;
        }
        n2 = this.f() ? 1 : 0;
        if (n2 == 0) return;
        this.F(n);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void G() {
        block59: {
            var1_1 = -1;
            var2_2 = 5;
            var3_3 = 10;
            var4_4 = 1;
            var5_5 = 0;
            this.c1020 = false;
            var6_6 /* !! */  = this.i1048;
            if (var6_6 /* !! */  >= 0) {
                this.i1048 = var6_6 /* !! */  = this.i1048 + 1;
            }
            var6_6 /* !! */  = this.l;
            switch (var6_6 /* !! */ ) {
                case 24: {
                    this.aq();
                    break block59;
                }
                case 46: {
                    this.as();
                    break block59;
                }
                case 48: {
                    var6_6 /* !! */  = (int)this.g();
                    if (var6_6 /* !! */  == 0) return;
                    this.E1179 = var4_4;
                    this.a();
                    var6_6 /* !! */  = this.bW;
                    this.F(var6_6 /* !! */ );
                    break block59;
                }
                case 0: {
                    var6_6 /* !! */  = this.al;
                    var7_7 = 2;
                    if (var6_6 /* !! */  != var7_7) ** GOTO lbl48
                    var6_6 /* !! */  = this.ak;
                    if (var6_6 /* !! */  == 0) {
                        this.l1031 = var4_4;
                        this.F();
                    }
                    this.ak = var6_6 /* !! */  = this.ak + 1;
                    var7_7 = 35;
                    if (var6_6 /* !! */  <= var7_7) {
                        var6_6 /* !! */  = this.ak;
                        this.f(0, var6_6 /* !! */ );
                        break block59;
                    } else {
                        this.f(var1_1);
                        this.n1036 = false;
                        this.am = 0;
                        this.ak = 0;
                        var6_6 /* !! */  = 2;
                        this.c(var6_6 /* !! */ );
                        this.k();
                    }
                    break block59;
lbl48:
                    // 1 sources

                    var8_14 = this.b1032;
                    if (var8_14 != null) break;
                    var8_14 = new StringBuffer();
                    var9_17 = "/l";
                    var8_14 = var8_14.append(var9_17);
                    var7_7 = this.al;
                    var8_14 = var8_14.append(var7_7);
                    var9_17 = ".png";
                    var8_14 = var8_14.append(var9_17);
                    var8_14 = var8_14.toString();
                    var8_14 = Image.createImage((String)var8_14);
                    this.b1032 = var8_14;
                    break;
                }
                case 19: {
                    this.ak = var6_6 /* !! */  = this.ak + 1;
                    var7_8 = 70;
                    if (var6_6 /* !! */  <= var7_8) {
                        var6_6 /* !! */  = this.ak;
                        this.f(var4_4, var6_6 /* !! */ );
                        break block59;
                    } else {
                        this.b1018 = false;
                    }
                    break block59;
                }
                case 18: {
                    this.i();
                    break block59;
                }
                case 1: {
                    this.m();
                    break block59;
                }
                case 15: {
                    this.r();
                    break block59;
                }
                case 17: {
                    this.t();
                    break block59;
                }
                case 16: {
                    this.u();
                    break block59;
                }
                case 23: {
                    this.ad();
                    this.an();
                    this.al();
                    break block59;
                }
                case 22: {
                    this.aa();
                    this.an();
                    break block59;
                }
                case 2: {
                    var6_6 /* !! */  = (int)this.d();
                    if (var6_6 /* !! */  == 0) ** GOTO lbl101
                    this.U();
                    this.a(var3_3);
                    break block59;
lbl101:
                    // 1 sources

                    var6_6 /* !! */  = (int)this.v1097;
                    if (var6_6 /* !! */  == 0) ** GOTO lbl105
                    this.ae();
                    break block59;
lbl105:
                    // 1 sources

                    var6_6 /* !! */  = this.h1047;
                    var7_9 = -7;
                    if (var6_6 /* !! */  == var7_9) {
                        this.r = 0;
                        var6_6 /* !! */  = this.aq;
                        this.h(var6_6 /* !! */ );
                        var6_6 /* !! */  = 3;
                        this.a(var6_6 /* !! */ );
                    }
                    if ((var6_6 /* !! */  = this.h1047) == (var7_9 = 48)) {
                        this.r = 0;
                        var6_6 /* !! */  = 24;
                        this.a(var6_6 /* !! */ );
                    }
                    if ((var6_6 /* !! */  = this.h1047) == (var7_9 = 42)) {
                        this.y1155 = var4_4;
                        var8_15 /* !! */  = this.c1070;
                        var7_9 = this.aN;
                        this.bN = var6_6 /* !! */  = var8_15 /* !! */ [var7_9][0];
                        var8_15 /* !! */  = this.c1070;
                        var7_9 = this.aN;
                        var8_15 /* !! */  = (short[][])var8_15 /* !! */ [var7_9];
                        this.bO = var6_6 /* !! */  = (int)var8_15 /* !! */ [var4_4];
                    }
                    if ((var6_6 /* !! */  = this.aS) != (var7_9 = (var9_18 = this.l1072)[var5_5 = this.aN]) || (var6_6 /* !! */  = this.aP) > 0 || (var6_6 /* !! */  = this.aT) != (var7_9 = this.aX) || (var6_6 /* !! */  = this.by) <= 0) ** GOTO lbl146
                    var6_6 /* !! */  = this.T;
                    if (var6_6 /* !! */  == 0) {
                        this.aO = var6_6 /* !! */  = this.aO + 1;
                        var8_15 /* !! */  = (short[][])this.d1073;
                        var7_9 = this.aN;
                        var8_15 /* !! */ [var7_9] = (short[])var4_4;
                        this.E();
                        var6_6 /* !! */  = this.aO;
                        var7_9 = 7;
                        if (var6_6 /* !! */  < var7_9) {
                            var8_15 /* !! */  = this.h1074;
                            var7_9 = this.X;
                            var8_15 /* !! */  = (short[][])var8_15 /* !! */ [var7_9];
                            var7_9 = this.aO;
                            this.aN = var6_6 /* !! */  = (int)var8_15 /* !! */ [var7_9];
                        }
                    }
                    this.s1088 = var4_4;
                    this.U();
                    this.a(var3_3);
                    break block59;
lbl146:
                    // 1 sources

                    this.T();
                }
                case 13: {
                    var6_6 /* !! */  = (int)this.d();
                    if (var6_6 /* !! */  != 0) {
                        this.U();
                        this.a(var3_3);
                        break block59;
                    } else {
                        this.an();
                        this.X();
                        this.ah();
                        this.K();
                        this.al();
                    }
                    break block59;
                }
                case 12: {
                    var6_6 /* !! */  = (int)this.d();
                    if (var6_6 /* !! */  != 0) {
                        this.U();
                        this.a(var3_3);
                        break block59;
                    } else {
                        this.an();
                        this.X();
                        this.ah();
                        this.K();
                    }
                    break block59;
                }
                case 14: {
                    var6_6 /* !! */  = (int)this.d();
                    if (var6_6 /* !! */  != 0) {
                        this.U();
                        this.a(var3_3);
                        break block59;
                    } else {
                        this.an();
                        this.X();
                        this.ah();
                        this.L();
                    }
                    break block59;
                }
                case 3: {
                    var6_6 /* !! */  = this.h1047;
                    block23 : switch (var6_6 /* !! */ ) {
                        default: {
                            break;
                        }
                        case -6: 
                        case -5: 
                        case 53: {
                            var6_6 /* !! */  = this.r;
                            switch (var6_6 /* !! */ ) {
                                default: {
                                    break block23;
                                }
                                case 0: {
                                    this.a();
                                    var6_6 /* !! */  = this.ar;
                                    var7_10 = 8;
                                    if (var6_6 /* !! */  < var7_10) return;
                                    var6_6 /* !! */  = this.aP;
                                    if (var6_6 /* !! */  <= 0) return;
                                    var6_6 /* !! */  = this.ar;
                                    this.g(var6_6 /* !! */ , var1_1);
                                    break block23;
                                }
                                case 1: {
                                    this.r = 0;
                                    var6_6 /* !! */  = 24;
                                    this.a(var6_6 /* !! */ );
                                    break block23;
                                }
                                case 2: {
                                    var6_6 /* !! */  = 9;
                                    this.a(var6_6 /* !! */ );
                                    this.r = 0;
                                    break block23;
                                }
                                case 3: {
                                    this.a(var2_2);
                                    this.c = 0;
                                    break block23;
                                }
                                case 4: {
                                    var6_6 /* !! */  = 4;
                                    this.a(var6_6 /* !! */ );
                                    this.c = 0;
                                    break block23;
                                }
                                case 5: 
                            }
                            this.C();
                            this.D();
                            this.B();
                            break;
                        }
                        case -1: 
                        case 50: {
                            this.r = var6_6 /* !! */  = this.r - var4_4;
                            if (var6_6 /* !! */  >= 0) return;
                            this.r = var2_2;
                            break;
                        }
                        case -2: 
                        case 56: {
                            this.r = var6_6 /* !! */  = this.r + 1;
                            if (var6_6 /* !! */  <= var2_2) return;
                            this.r = 0;
                            break;
                        }
                    }
                    break block59;
                }
                case 4: 
                case 5: 
                case 20: 
                case 21: {
                    var6_6 /* !! */  = this.g1046;
                    switch (var6_6 /* !! */ ) {
                        default: {
                            break;
                        }
                        case -7: {
                            this.c = 0;
                            this.a();
                            var6_6 /* !! */  = this.l;
                            var7_11 = 4;
                            if (var6_6 /* !! */  == var7_11) return;
                            var6_6 /* !! */  = this.l;
                            if (var6_6 /* !! */  == var2_2) return;
                            var6_6 /* !! */  = 7;
                            this.g(var6_6 /* !! */ , var1_1);
                            break;
                        }
                        case -1: 
                        case 50: {
                            var6_6 /* !! */  = this.c;
                            if (var6_6 /* !! */  <= 0) return;
                            var6_6 /* !! */  = this.c;
                            var7_12 = this.b1008;
                            this.c = var6_6 /* !! */  -= var7_12;
                            break;
                        }
                        case -2: 
                        case 56: {
                            var6_6 /* !! */  = this.c;
                            var7_13 = this.a1007;
                            var5_5 = this.b1008;
                            if (var6_6 /* !! */  >= (var7_13 -= var5_5)) return;
                            var6_6 /* !! */  = this.c;
                            var7_13 = this.b1008;
                            this.c = var6_6 /* !! */  += var7_13;
                            break;
                        }
                    }
                    break block59;
                }
                case 8: 
                case 9: {
                    this.g();
                    break block59;
                }
                case 10: {
                    this.V();
                    return;
                }
                catch (Exception var8_16) {}
            }
            this.ak = var6_6 /* !! */  = this.ak + 1;
            if (var6_6 /* !! */  <= var3_3) return;
            var6_6 /* !! */  = this.al;
            var7_7 = 2;
            if (var6_6 /* !! */  >= var7_7) return;
            var8_14 = null;
            this.b1032 = null;
            this.al = var6_6 /* !! */  = this.al + 1;
            this.ak = 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void G(int n) {
        int n2 = 2;
        this.c1190 = (byte)n2;
        Object object = new StringBuffer();
        object = ((StringBuffer)object).append("http://service.snowfish.cn/game/sms/server.php");
        CharSequence charSequence = this.h1192;
        if (charSequence == null) {
            charSequence = "";
        } else {
            charSequence = new StringBuffer();
            charSequence = ((StringBuffer)charSequence).append("?");
            String string = this.h1192;
            charSequence = ((StringBuffer)charSequence).append(string).toString();
        }
        object = ((StringBuffer)object).append((String)charSequence).toString();
        this.f1186 = object;
        this.a1191 = null;
        this.a1191 = object = new ByteArrayOutputStream(2048);
        this.a1191.write(n);
    }

    private void H() {
        this.J();
        this.I();
    }

    private void H(int n) {
        char c = (char)-1;
        int n2 = n >> 16 & c;
        this.I(n2);
        n2 = n & c;
        this.I(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void I() {
        Image image = this.a1013[3][3];
        byte[] byArray = null;
        boolean bl = true;
        a a2 = this;
        this.a(image, 0, 0, 13450878, bl);
        this.a1002.setColor(15988422);
        Graphics graphics = this.a1002;
        int n = 0;
        image = null;
        int n2 = 12;
        int n3 = 240;
        int n4 = 12;
        graphics.drawLine(0, n2, n3, n4);
        int n5 = 0;
        Object var4_6 = null;
        int n6 = 0;
        while (true) {
            if (n6 >= (n5 = 3)) {
                this.a1002.setClip(0, 0, 240, 320);
                return;
            }
            Image[] imageArray = this.a1013[3];
            n = 19;
            image = imageArray[n];
            n5 = n6 * 82;
            n2 = n5 + 25;
            n3 = 0;
            byte[] byArray2 = this.d1050;
            int n7 = n6 << 1;
            n7 = byArray2[n7];
            bl = false;
            byte[] byArray3 = this.d1050;
            int n8 = (n6 << 1) + 1;
            n8 = byArray3[n8];
            int n9 = this.a1013[3][19].getHeight();
            a a3 = this;
            this.a(image, n2, 0, n7, 0, n8, n9, 0, 0);
            n5 = n6 == 0 ? this.aS : (n6 == (n5 = 1) ? this.bz : this.by);
            n = n6 * 82 + 25;
            byArray = this.d1050;
            n3 = (n6 << 1) + 1;
            n2 = byArray[n3];
            n = n + n2 + 2;
            n2 = 0;
            byArray = null;
            this.b(n5, n, 0);
            n6 = n5 = n6 + 1;
        }
    }

    private void I(int n) {
        ByteArrayOutputStream byteArrayOutputStream = this.a1191;
        int n2 = n >> 8 & 0xFF;
        byteArrayOutputStream.write(n2);
        byteArrayOutputStream = this.a1191;
        n2 = n & 0xFF;
        byteArrayOutputStream.write(n2);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void J() {
        Graphics graphics;
        block14: {
            int n;
            int n2;
            block15: {
                void var6_151;
                Object object;
                Object object2;
                boolean bl;
                int n3;
                Image image;
                int n4;
                Graphics graphics2;
                int n5;
                block17: {
                    block16: {
                        void var5_131;
                        void var6_149;
                        Graphics graphics3;
                        Image[][] imageArray;
                        Graphics graphics4;
                        Image[][] imageArray2;
                        Image[][] imageArray3;
                        Image[][] imageArray4;
                        Image[][] imageArray5;
                        Graphics graphics5;
                        a a2 = this;
                        int n6 = this.au;
                        int n7 = n5 = this.av;
                        int n8 = n6 + n5;
                        int n9 = 289 - n8 + 1;
                        int n10 = n5 = this.av;
                        int n11 = 289 - n5;
                        Image[][] imageArray6 = this.a1013;
                        graphics2 = imageArray6;
                        int n12 = imageArray6[3][6].getHeight();
                        n2 = n11 + n12 + 1;
                        a a3 = this;
                        Graphics graphics6 = graphics5 = this.a1002;
                        graphics5.setColor(0xFCFFCD);
                        a a4 = this;
                        Graphics graphics7 = this.a1002;
                        a a5 = this;
                        n4 = this.au;
                        int n13 = n5 = this.av;
                        int n14 = 289 - (n4 += n5);
                        n13 = n5 = this.au;
                        n13 = n5 + 21;
                        int n15 = n5 = this.av;
                        graphics7.fillRect(0, n14, 240, n13 += n5);
                        Image[][] imageArray7 = imageArray5 = this.a1013;
                        graphics2 = imageArray5[3][6];
                        a a6 = this;
                        Image[][] imageArray8 = imageArray4 = this.a1013;
                        int n17 = imageArray4[3][6].getWidth();
                        n17 = 120 - n17;
                        a a7 = this;
                        this.a((Image)graphics2, n17, n9, 12010381, true);
                        a a8 = this;
                        Image[][] imageArray9 = imageArray3 = this.a1013;
                        graphics2 = imageArray3[3][7];
                        a a9 = this;
                        this.a((Image)graphics2, 0, n9, 0, false);
                        a a10 = this;
                        Image[][] imageArray10 = imageArray2 = this.a1013;
                        Image image2 = imageArray2[3][5];
                        boolean bl2 = false;
                        image = null;
                        this.a(image2, 0, n2, 0, false);
                        a a11 = this;
                        Graphics graphics8 = graphics4 = this.a1002;
                        graphics4.setColor(15455661);
                        a a12 = this;
                        Image[][] imageArray11 = imageArray = this.a1013;
                        Image[] imageArray12 = imageArray[3];
                        Image image3 = imageArray12[5];
                        int n18 = image3.getWidth();
                        a a13 = this;
                        Image[][] imageArray13 = this.a1013;
                        graphics2 = imageArray13;
                        graphics2 = imageArray13[3];
                        int n19 = 5;
                        graphics2 = graphics2[n19];
                        int n20 = graphics2.getHeight();
                        a a14 = this;
                        Graphics graphics9 = graphics3 = this.a1002;
                        n4 = n2 + 2;
                        n15 = n18 << 1;
                        n13 = 240 - n15;
                        n15 = 9;
                        graphics3.fillRect(n18, n4, n13, n15);
                        a a15 = this;
                        int n21 = n5 = this.aw;
                        if (n5 == 0) break block15;
                        int n22 = n2 + n20;
                        int n23 = n5 = this.av;
                        this.c(57, n22, 183, n5, 0);
                        boolean bl3 = false;
                        image = null;
                        int n24 = n2 + n20;
                        n3 = 57;
                        int n25 = n5 = this.av;
                        int n26 = 3;
                        int n27 = n5 - n26;
                        bl = true;
                        this.c(0, n24, n3, n27, bl ? 1 : 0);
                        int n28 = n5 = this.au;
                        if (n5 != 0) {
                            Image[][] imageArray14;
                            Image[][] imageArray15;
                            Image[][] imageArray16 = imageArray15 = this.a1013;
                            n15 = imageArray15[3][6].getHeight();
                            a a16 = this;
                            Graphics graphics10 = this.a1002;
                            graphics2 = null;
                            int n29 = n9 + n15;
                            a a17 = this;
                            n13 = n5 = this.au;
                            graphics10.setClip(0, n29, 240, n5);
                            Image[][] imageArray17 = imageArray14 = this.a1013;
                            Image[] imageArray18 = imageArray14[3];
                            image = imageArray18[10];
                            boolean bl4 = false;
                            n3 = n9 + n15;
                            int n30 = 14311547;
                            bl = true;
                            this.a(image, 0, n3, n30, bl);
                            a a18 = this;
                            int n31 = this.aG;
                            int n32 = n9 + n15 + 1;
                            int n33 = n5 = this.au;
                            object2 = n32;
                            object = 16;
                            this.a(n31, n32, (int)object, n5);
                            byte[][] byArray = this.d1053;
                            a a19 = this;
                            int n34 = n5 = this.aC;
                            byte[] byArray2 = byArray[n5];
                            int n35 = n5 = this.aD;
                            byte by = byArray2[n5];
                            int n36 = 67;
                            int n37 = n2 + n15 + 15;
                            n4 = 163;
                            n13 = n5 = this.av;
                            a a20 = this;
                            this.e(by, n36, n37, n4, n5);
                            int n38 = n15;
                        } else {
                            int n39 = n20;
                        }
                        a a21 = this;
                        int n40 = n5 = this.av;
                        if (n5 == 0) break block14;
                        void var6_150 = var6_149 + n2;
                        int n42 = n5 = this.av;
                        n42 = n5 >> 1;
                        var6_151 = var6_150 + n42;
                        int n43 = n5 = this.aC;
                        int n44 = 2;
                        if (n5 < n44) break block16;
                        graphics2 = (Graphics)this.c1107;
                        a a22 = this;
                        int n45 = n5 = this.ay;
                        graphics2 = graphics2[n5];
                        byte[][] byArray = this.d1053;
                        a a23 = this;
                        int n46 = n5 = this.aC;
                        byte[] byArray3 = byArray[n5];
                        int n47 = n5 = this.aD;
                        byte by = byArray3[n5];
                        Image[] imageArray19 = graphics2[2];
                        Image[] imageArray20 = graphics2[3];
                        n3 = 28;
                        void var6_152 = var6_151 - 5;
                        Image[] imageArray21 = graphics2[2];
                        n4 = 10;
                        if (imageArray21 == n4) {
                            int n48 = 10;
                        } else {
                            boolean bl5 = false;
                        }
                        void var18_237 = var6_152 + var5_131;
                        bl = false;
                        int n49 = 2;
                        int n50 = 0;
                        this.a((int)imageArray19, (int)imageArray20, n3, (int)var18_237, 0, n49, 0);
                        byte by2 = 21;
                        if (by != by2) {
                            byte by3;
                            Image[][] imageArray22;
                            byte[] byArray4;
                            byte[] byArray5;
                            Image[][] imageArray23;
                            a a24 = this;
                            Image[][] imageArray24 = imageArray23 = this.a1013;
                            image = imageArray23[3][19];
                            int n51 = 210;
                            n3 = n2 + 2;
                            a a25 = this;
                            byte[] byArray6 = byArray5 = this.d1050;
                            byte by4 = byArray5[2];
                            bl = false;
                            a a26 = this;
                            byte[] byArray7 = byArray4 = this.d1050;
                            byte by5 = byArray4[3];
                            a a27 = this;
                            Image[][] imageArray25 = imageArray22 = this.a1013;
                            Image[] imageArray26 = imageArray22[3];
                            int n52 = 19;
                            Image image4 = imageArray26[n52];
                            n50 = image4.getHeight();
                            this.a(image, n51, n3, by4, 0, by5, n50, 0, 0);
                            byte by6 = 16;
                            if (by == by6 || by == (by3 = 18)) {
                                void var6_160;
                                Graphics graphics11 = graphics2[2];
                                Graphics graphics12 = graphics2[3];
                                a a28 = this;
                                object2 = graphics12;
                                boolean bl6 = this.o((int)graphics11, (int)graphics12);
                                if (bl6) {
                                    Graphics graphics13 = graphics2[2];
                                    byte[] byArray8 = this.r1101;
                                    Graphics graphics14 = graphics2[3];
                                    a a29 = this;
                                    object = graphics14;
                                    int n53 = this.a((int)graphics13, byArray8, (int)graphics14) >> 1;
                                } else {
                                    Graphics graphics15 = graphics2[2];
                                    byte[] byArray9 = this.r1101;
                                    Graphics graphics16 = graphics2[3];
                                    a a30 = this;
                                    object = graphics16;
                                    int n54 = this.a((int)graphics15, byArray9, (int)graphics16);
                                }
                                Object object3 = 224;
                                Object object4 = n2 + 2;
                                a a31 = this;
                                object2 = object3;
                                object = object4;
                                this.b((int)var6_160, (int)object3, (int)object4);
                            } else {
                                byte by7 = 20;
                                if (by == by7) {
                                    a a32 = this;
                                    int n56 = n5 = this.ay;
                                    n56 = this.b(n5);
                                    Object object5 = 224;
                                    int n57 = n2 + 2;
                                    object2 = object5;
                                    object = n57;
                                    this.b(n56, (int)object5, n57);
                                }
                            }
                            Graphics graphics17 = graphics2[2];
                            Object object6 = 2;
                            int n58 = n2 + 2;
                            a a33 = this;
                            object2 = object6;
                            object = n58;
                            this.h((int)graphics17, (int)object6, n58);
                        }
                        break block14;
                    }
                    int n59 = n5 = this.aC;
                    if (n5 != 0) break block17;
                    graphics2 = (Graphics)this.d1053;
                    a a34 = this;
                    int n60 = n5 = this.aC;
                    graphics2 = graphics2[n5];
                    int n61 = n5 = this.aD;
                    Image[] imageArray = graphics2[n5];
                    int n62 = 21;
                    if (imageArray != n62) {
                        byte[] byArray;
                        Image[][] imageArray27;
                        byte[] byArray10;
                        byte[] byArray11;
                        Image[][] imageArray28;
                        Image[][] imageArray29 = imageArray28 = this.a1013;
                        image = imageArray28[3][19];
                        n3 = n2 + 2;
                        a a35 = this;
                        byte[] byArray12 = byArray11 = this.d1050;
                        byte by = byArray11[2];
                        a a36 = this;
                        byte[] byArray13 = byArray10 = this.d1050;
                        byte by8 = byArray10[3];
                        a a37 = this;
                        Image[][] imageArray30 = imageArray27 = this.a1013;
                        int n63 = imageArray27[3][19].getHeight();
                        this.a(image, 210, n3, by, 0, by8, n63, 0, 0);
                        a a38 = this;
                        byte[] byArray14 = byArray = this.q1100;
                        byte by9 = byArray[imageArray];
                        int n64 = 224;
                        n4 = n2 + 2;
                        a a39 = this;
                        object2 = n64;
                        object = n4;
                        this.b(by9, n64, n4);
                        boolean bl7 = false;
                        n3 = 28;
                        void var18_240 = var6_151 - 5;
                        bl = false;
                        int n65 = 2;
                        n63 = 0;
                        Image[] imageArray31 = imageArray;
                        this.a((int)imageArray, 0, n3, (int)var18_240, 0, n65, 0);
                        int n66 = 2;
                        int n67 = n2 + 2;
                        object2 = n66;
                        object = n67;
                        this.h((int)imageArray, n66, n67);
                    }
                    break block14;
                }
                int n68 = n5 = this.aC;
                int n69 = 1;
                if (n5 != n69) break block14;
                int n70 = n5 = this.aD;
                int n71 = 5;
                if (n5 < n71) {
                    int n72 = n5 = this.aD;
                    boolean bl8 = true;
                    object2 = 28;
                    object = var6_151;
                    this.a(n5, (int)object2, (int)var6_151, bl8);
                    graphics2 = (Graphics)this.a1056;
                    a a40 = this;
                    int n73 = n5 = this.aD;
                    Image[] imageArray = graphics2[n5];
                    if (imageArray != false) {
                        Image[][] imageArray32;
                        graphics2 = this.a1002;
                        a a41 = this;
                        Image[][] imageArray33 = imageArray32 = this.a1013;
                        Image image5 = imageArray32[3][23];
                        int n74 = 1;
                        n4 = 0;
                        graphics2.drawImage(image5, n74, (int)var6_151, 0);
                        break block14;
                    } else {
                        Image[][] imageArray34;
                        byte[] byArray;
                        byte[] byArray15;
                        Image[][] imageArray35;
                        Image[][] imageArray36 = imageArray35 = this.a1013;
                        image = imageArray35[3][19];
                        int n75 = 210;
                        n3 = n2 + 2;
                        a a42 = this;
                        byte[] byArray16 = byArray15 = this.d1050;
                        byte by = byArray15[2];
                        bl = false;
                        a a43 = this;
                        byte[] byArray17 = byArray = this.d1050;
                        byte by10 = byArray[3];
                        a a44 = this;
                        Image[][] imageArray37 = imageArray34 = this.a1013;
                        int n76 = imageArray34[3][19].getHeight();
                        this.a(image, n75, n3, by, 0, by10, n76, 0, 0);
                        a a45 = this;
                        byte[] byArray18 = this.g1057;
                        a a46 = this;
                        int n77 = n5 = this.aD;
                        byte by11 = byArray18[n5];
                        int n78 = 224;
                        int n79 = n2 + 2;
                        object2 = n78;
                        object = n79;
                        this.b(by11, n78, n79);
                    }
                }
                break block14;
            }
            int n80 = 2;
            int n81 = n = n2 + 1;
            this.h(n80, n);
        }
        a a47 = this;
        Graphics graphics18 = graphics = this.a1002;
        graphics.setClip(0, 0, 240, 320);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void K() {
        int n = 18;
        int n2 = 20;
        int n3 = 0;
        int n4 = this.aw;
        switch (n4) {
            case 0: {
                n4 = this.bN;
                n3 = this.bO;
                this.a(n4, n3);
                return;
            }
            case 1: {
                this.av = n4 = this.av + 20;
                n3 = this.ax;
                if (n4 > n3) {
                    this.av = n4 = this.ax;
                    this.au = n4 = this.au + 20;
                    if (n4 > n) {
                        this.au = n;
                    }
                    this.M();
                }
                n4 = this.h1047;
                switch (n4) {
                    default: {
                        return;
                    }
                    case -7: 
                }
                this.aw = n4 = 2;
                return;
            }
            case 2: {
                this.au = n4 = this.au - n2;
                if (n4 >= 0) return;
                this.au = 0;
                this.av = n4 = this.av - n2;
                if (n4 >= 0) return;
                this.aw = 0;
                this.av = 0;
                this.a();
                return;
            }
            case 3: {
                this.au = n4 = this.au - n2;
                if (n4 >= 0) return;
                this.au = 0;
                this.av = n4 = this.av - n2;
                if (n4 >= 0) return;
                this.aw = 4;
                this.bF = 1;
                this.av = 0;
                n4 = 13;
                this.a(n4);
                return;
            }
            case 4: {
                n4 = this.bN;
                n3 = this.bO;
                this.m(n4, n3);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void L() {
        int n = 3;
        int n2 = 2;
        int n3 = 1;
        int n4 = 0;
        int n5 = -1;
        int n6 = this.h1047;
        switch (n6) {
            case -1: 
            case 50: {
                int[] nArray = this.m1129;
                n6 = nArray[0];
                if (n6 == n5) return;
                this.aA = 0;
                return;
            }
            case -3: 
            case 52: {
                int[] nArray = this.m1129;
                n6 = nArray[n];
                if (n6 == n5) return;
                this.aA = n;
                return;
            }
            case -4: 
            case 54: {
                int[] nArray = this.m1129;
                n6 = nArray[n3];
                if (n6 == n5) return;
                this.aA = n3;
                return;
            }
            case -2: 
            case 56: {
                int[] nArray = this.m1129;
                n6 = nArray[n2];
                if (n6 == n5) return;
                this.aA = n2;
                return;
            }
            case -7: {
                this.a();
                return;
            }
            case -6: 
            case -5: 
            case 53: {
                n6 = this.bN;
                n5 = this.bO;
                n4 = this.bw;
                n3 = this.aA;
                this.c(n6, n5, n4, n3);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void M() {
        Object object;
        int n;
        Object object2;
        int n2 = 4;
        Object object3 = 3;
        int n3 = 1;
        int n4 = 2;
        Object object4 = this.aC;
        if (object4 == 0 || (object4 = this.aC) == n3) {
            object2 = this.f1055;
            this.a((byte[])object2);
        }
        object4 = this.g1046;
        switch (object4) {
            case -3: 
            case 52: {
                this.aH = 0;
                this.aD = object4 = this.aD - n3;
                if (object4 < 0) {
                    object4 = this.aD = (object4 = this.aB);
                    n = this.aF - n3;
                    this.aE = object4 -= n;
                }
                object4 = this.aD;
                n = this.aB;
                object = this.aF - n3;
                if (object4 >= (n -= object) || (object4 = this.aE) <= 0) break;
                object4 = this.aD;
                n = this.aE;
                if ((object4 -= n) >= 0) break;
                this.aE = object4 = this.aE - n3;
                break;
            }
            case -4: 
            case 54: {
                this.aH = 0;
                this.aD = object4 = this.aD + 1;
                n = this.aB;
                if (object4 > n) {
                    this.aD = 0;
                    this.aE = 0;
                }
                if ((object4 = this.aD) <= (n = this.aF - n3)) break;
                object4 = this.aD;
                n = this.aE;
                if ((object4 -= n) <= (n = this.aF - n3)) break;
                this.aE = object4 = this.aE + 1;
                break;
            }
        }
        object4 = this.h1047;
        switch (object4) {
            case -6: 
            case -5: 
            case 53: {
                object2 = this.d1053;
                n = this.aC;
                object2 = object2[n];
                n = this.aD;
                object4 = object2[n];
                n = 21;
                if (object4 == n) {
                    this.aw = n4;
                    return;
                }
                n = this.aC;
                switch (n) {
                    default: {
                        return;
                    }
                    case 0: {
                        n = this.bt;
                        object = 30;
                        if (n >= object) {
                            this.o = object4 = 7;
                            return;
                        }
                        boolean[] blArray = this.e1105;
                        n = blArray[object4];
                        if (n == 0) {
                            this.o = n4;
                            this.F(n3);
                            return;
                        }
                        n = this.bz;
                        byte[] byArray = this.q1100;
                        object = byArray[object4];
                        if (n >= object) {
                            this.bw = object4;
                            this.aw = object3;
                            return;
                        }
                        this.o = 0;
                        this.F(n4);
                        return;
                    }
                    case 2: 
                    case 5: {
                        n = this.ay;
                        this.x(n);
                    }
                    case 3: 
                    case 4: 
                    case 6: 
                    case 7: {
                        Object object5 = this.c1107;
                        object = this.ay;
                        object5 = object5[object];
                        switch (object4) {
                            default: {
                                return;
                            }
                            case 16: {
                                object4 = this.ay;
                                object4 = this.d((int)object4);
                                if (object4 == 0) return;
                                object5[n2] = (int[])n2;
                                this.aw = n4;
                                return;
                            }
                            case 18: {
                                object4 = object5[n4];
                                object = object5[object3];
                                object4 = this.o((int)object4, (int)object);
                                if (object4 != 0) {
                                    object4 = object5[n4];
                                    byte[] byArray = this.r1101;
                                    object3 = object5[object3];
                                    object4 = this.a((int)object4, byArray, (int)object3) >> 1;
                                } else {
                                    object4 = object5[n4];
                                    byte[] byArray = this.r1101;
                                    object3 = object5[object3];
                                    object4 = this.a((int)object4, byArray, (int)object3);
                                }
                                if ((object4 = (Object)this.j((int)object4)) != 0) {
                                    object4 = 15;
                                    object5[object4] = (int[])n3;
                                    this.aw = n4;
                                    return;
                                }
                                this.o = 0;
                                return;
                            }
                            case 19: {
                                object5[15] = (int[])false;
                                object4 = this.ay;
                                this.v((int)object4);
                                this.aw = n4;
                                return;
                            }
                            case 20: 
                        }
                        object4 = 5;
                        object5[n2] = (int[])object4;
                        this.aw = n4;
                        return;
                    }
                    case 1: 
                }
                n = 22;
                if (object4 == n) {
                    this.r = 0;
                    object4 = 24;
                    this.a((int)object4);
                    return;
                }
                object4 = this.aD;
                this.k((int)object4);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void N() {
        int n;
        byte[] byArray;
        int n2;
        int n3 = 1;
        int n4 = 0;
        while (true) {
            if (n4 >= (n2 = (byArray = this.E1163).length)) break;
            byArray = this.E1163;
            n2 = byArray[n4];
            n = 11;
            if (n2 == n) {
                this.aK = n2 = this.b(n4, 0);
                this.aL = n4 = this.b(n4, n3);
                break;
            }
            ++n4;
        }
        n4 = 0;
        while (true) {
            block7: {
                block6: {
                    if (n4 >= (n2 = (byArray = this.E1163).length)) break block6;
                    byArray = this.E1163;
                    n2 = byArray[n4];
                    n = 10;
                    if (n2 != n) break block7;
                    this.aI = n2 = this.b(n4, 0);
                    this.aJ = n4 = this.b(n4, n3);
                }
                return;
            }
            ++n4;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void O() {
        int n = 8;
        int n2 = -1;
        int n3 = this.p1078;
        if (n3 == 0) return;
        this.p1078 = false;
        n3 = this.aS & 3;
        int n4 = 3;
        if (n3 == n4) {
            n3 = 1;
            this.o1077 = n3;
        } else {
            this.o1077 = false;
        }
        this.aR = 0;
        this.aT = 0;
        this.aS = n3 = this.aS + 1;
        this.R();
        n3 = this.bj = (n3 = this.aV + 12);
        this.c(n3);
        this.aU = n3 = this.bj;
        n3 = this.ba;
        if (n3 != 0) {
            byte[] byArray = this.k1068;
            n4 = this.ba;
            this.aM = n3 = byArray[n4];
            n3 = 38;
            n4 = this.aM;
            this.a(n3, n4);
        }
        if ((n3 = (int)(this.o1077 ? 1 : 0)) != 0) {
            this.ar = n;
            this.g(n, n2);
            return;
        }
        this.ar = n3 = this.aV + 9;
        n3 = this.aV + 9;
        this.g(n3, n2);
    }

    private void P() {
        int n = 30;
        Object object = this.h1074;
        int n2 = this.X;
        object = object[n2];
        n2 = this.aO;
        Object object2 = object[n2];
        this.aN = (int)object2;
        this.e(0);
        this.be = -42;
        this.e(20);
        object2 = this.aN;
        this.E((int)object2);
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
        int n = 30;
        Object object = this.h1074;
        Object object2 = this.X;
        object = object[object2];
        object2 = this.aO;
        Object object3 = object[object2];
        this.aN = (int)object3;
        this.e(0);
        this.be = -42;
        this.e(10);
        this.c(31);
        this.e(20);
        this.c(n);
        object3 = this.bj;
        this.c((int)object3);
        this.e(n);
        object3 = this.aN;
        this.E((int)object3);
        this.e(40);
        this.c(29);
        this.e(60);
        object = null;
        for (object3 = (Object)false; object3 < (object2 = 11); object3 = (Object)(object3 + true)) {
            object2 = object3 + 18;
            this.c((int)object2);
        }
        this.e(80);
        this.N();
        this.b();
        this.e(100);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void R() {
        block18: {
            block15: {
                block14: {
                    block16: {
                        block17: {
                            var1_1 = 6;
                            var2_2 = 3;
                            var3_3 = 1;
                            var4_4 /* !! */  = this.o1077;
                            if (var4_4 /* !! */  == 0) break block16;
                            var4_4 /* !! */  = this.aN;
                            if (var4_4 /* !! */  <= var3_3 || (var4_4 /* !! */  = this.aN) >= var1_1) break block17;
                            var5_5 /* !! */  = this.A1132;
                            var6_6 /* !! */  = this.X;
                            var4_4 /* !! */  = (int)(var5_5 /* !! */  = (byte[][])var5_5 /* !! */ [var6_6 /* !! */ ])[var6_6 /* !! */  = this.aN];
                            if (var4_4 /* !! */  == var3_3) {
                                var5_5 /* !! */  = this.z1131;
                                var6_6 /* !! */  = this.aN;
                                var5_5 /* !! */  = (byte[][])var5_5 /* !! */ [var6_6 /* !! */ ];
                                var4_4 /* !! */  = var5_5 /* !! */ .length >> 1;
lbl16:
                                // 3 sources

                                while (true) {
                                    var7_7 /* !! */  = this.z1131;
                                    var8_8 /* !! */  = this.aN;
                                    var7_7 /* !! */  = (byte[][])var7_7 /* !! */ [var8_8 /* !! */ ];
                                    var8_8 /* !! */  = (this.aS >> 2) + var4_4 /* !! */  - var3_3;
                                    this.bb = var6_6 /* !! */  = (int)var7_7 /* !! */ [var8_8 /* !! */ ];
                                    var7_7 /* !! */  = (byte[][])this.a1067;
                                    var8_8 /* !! */  = this.aN;
                                    var7_7 /* !! */  = (byte[][])var7_7 /* !! */ [var8_8 /* !! */ ];
                                    var8_8 /* !! */  = (this.aS >> 2) + var4_4 /* !! */  - var3_3;
                                    this.aV = var6_6 /* !! */  = var7_7 /* !! */ [var8_8 /* !! */ ][0] >> 1;
                                    var7_7 /* !! */  = (byte[][])this.a1067;
                                    var8_8 /* !! */  = this.aN;
                                    var7_7 /* !! */  = (byte[][])var7_7 /* !! */ [var8_8 /* !! */ ];
                                    var8_8 /* !! */  = this.aS >> 2;
                                    var4_4 /* !! */  = var4_4 /* !! */  + var8_8 /* !! */  - var3_3;
                                    var5_5 /* !! */  = (byte[][])var7_7 /* !! */ [var4_4 /* !! */ ];
                                    this.ba = var4_4 /* !! */  = (int)var5_5 /* !! */ [var3_3];
lbl34:
                                    // 2 sources

                                    while (true) {
                                        var5_5 /* !! */  = this.i1079;
                                        var6_6 /* !! */  = this.aV;
                                        var5_5 /* !! */  = (byte[][])var5_5 /* !! */ [var6_6 /* !! */ ];
                                        var4_4 /* !! */  = (int)var5_5 /* !! */ [0];
                                        var7_7 /* !! */  = this.i1079;
                                        var8_8 /* !! */  = this.aV;
                                        var7_7 /* !! */  = (byte[][])var7_7 /* !! */ [var8_8 /* !! */ ];
                                        var6_6 /* !! */  = (int)var7_7 /* !! */ [var3_3];
                                        var8_8 /* !! */  = this.aS;
                                        var4_4 /* !! */  += (var6_6 /* !! */  *= var8_8 /* !! */ );
                                        var6_6 /* !! */  = this.ba;
                                        if (var6_6 /* !! */  != var2_2) break block14;
                                        var6_6 /* !! */  = this.aS * 10;
lbl48:
                                        // 2 sources

                                        while (true) {
                                            this.aW = var4_4 /* !! */  += var6_6 /* !! */ ;
                                            var5_5 /* !! */  = this.i1079;
                                            var6_6 /* !! */  = this.aV;
                                            var4_4 /* !! */  = var5_5 /* !! */ [var6_6 /* !! */ ][2];
                                            var7_7 /* !! */  = this.i1079;
                                            var8_8 /* !! */  = this.aV;
                                            var7_7 /* !! */  = (byte[][])var7_7 /* !! */ [var8_8 /* !! */ ];
                                            var6_6 /* !! */  = (int)var7_7 /* !! */ [var2_2];
                                            var8_8 /* !! */  = this.aS;
                                            this.aX = var4_4 /* !! */  += (var6_6 /* !! */  *= var8_8 /* !! */ );
                                            var5_5 /* !! */  = this.i1079;
                                            var6_6 /* !! */  = this.aV;
                                            var5_5 /* !! */  = (byte[][])var5_5 /* !! */ [var6_6 /* !! */ ];
                                            var4_4 /* !! */  = (int)var5_5 /* !! */ [4];
                                            var6_6 /* !! */  = this.aS;
                                            var4_4 /* !! */  *= var6_6 /* !! */ ;
                                            var6_6 /* !! */  = this.ba;
                                            if (var6_6 /* !! */  == var3_3) {
                                                var6_6 /* !! */  = this.aS;
lbl68:
                                                // 2 sources

                                                while (true) {
                                                    this.aY = var4_4 /* !! */  += var6_6 /* !! */ ;
                                                    var5_5 /* !! */  = this.i1079;
                                                    var6_6 /* !! */  = this.aV;
                                                    var5_5 /* !! */  = (byte[][])var5_5 /* !! */ [var6_6 /* !! */ ];
                                                    this.aZ = var4_4 /* !! */  = (int)var5_5 /* !! */ [5];
                                                    var4_4 /* !! */  = this.aX;
                                                    var6_6 /* !! */  = 80;
                                                    if (var4_4 /* !! */  >= var6_6 /* !! */ ) {
                                                        this.aX = var4_4 /* !! */  = 79;
                                                    }
                                                    return;
                                                }
                                            }
                                            break block15;
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                            }
                            break block18;
                        }
                        var4_4 /* !! */  = 0;
                        var5_5 /* !! */  = null;
                        ** GOTO lbl16
                    }
                    var4_4 /* !! */  = this.a() % 21;
                    var6_6 /* !! */  = 0;
                    var7_7 /* !! */  = null;
                    while (true) {
                        block20: {
                            block19: {
                                if (var6_6 /* !! */  >= var1_1) break block19;
                                var9_9 /* !! */  = this.j1080;
                                var10_10 = this.aN;
                                var8_8 /* !! */  = (int)(var9_9 /* !! */  = (byte[][])var9_9 /* !! */ [var10_10])[var6_6 /* !! */ ];
                                if (var4_4 /* !! */  > var8_8 /* !! */ ) break block20;
                                this.aV = var6_6 /* !! */ ;
                            }
                            this.ba = 0;
                            ** continue;
                        }
                        ++var6_6 /* !! */ ;
                    }
                }
                var6_6 /* !! */  = 0;
                var7_7 /* !! */  = null;
                ** while (true)
            }
            var6_6 /* !! */  = 0;
            var7_7 /* !! */  = null;
            ** while (true)
        }
        var4_4 /* !! */  = 0;
        var5_5 /* !! */  = null;
        ** while (true)
    }

    private void S() {
        int n = this.r1086;
        if (n != 0) {
            int n2;
            int n3;
            Object object = this.a1002;
            Image image = null;
            Object object2 = null;
            object.setClip(0, 0, 240, 320);
            this.a1002.setColor(0xFFFFFF);
            object = this.a1002;
            int n4 = this.be;
            Object object3 = 15;
            Object object4 = 42;
            int n5 = 12;
            object.fillRect(n4, object3, object4, n5);
            n = 0;
            object = null;
            int n6 = 0;
            while (n6 < (n = 3)) {
                object = this.a1013[3];
                n4 = 26;
                image = object[n4];
                n = this.be + 2;
                object3 = n6 * 10;
                n += object3;
                object2 = this.b1085[n6];
                object4 = this.bd;
                object2 = object2[object4];
                object3 = object2[0] + n;
                object = this.b1085[n6];
                object4 = this.bd;
                object4 = object[object4][1] + 16;
                n5 = n6 * 10;
                n3 = 10;
                n2 = 10;
                object = this;
                this.a(image, (int)object3, (int)object4, n5, 0, n3, n2, 0, 0);
                n6 = n = n6 + 1;
            }
            image = this.a1013[3][27];
            object3 = this.be + 2 + 31;
            n3 = 9;
            n2 = 9;
            object = this;
            this.a(image, (int)object3, 17, 0, 0, n3, n2, 0, 0);
            object = this.a1002;
            object3 = this.be;
            n4 = 240 - object3 - 42;
            object3 = 15;
            object4 = 42;
            n5 = 12;
            object.fillRect(n4, object3, object4, n5);
            n = 0;
            object = null;
            n6 = 0;
            while (n6 < (n = 2)) {
                object = this.a1013[3];
                n4 = 26;
                image = object[n4];
                object3 = this.be;
                n = 240 - object3 - 42 + 2;
                object3 = n6 * 15;
                n += object3;
                object2 = this.b1085[n6];
                object4 = this.bd;
                object2 = object2[object4];
                object3 = object2[0] + n;
                object = this.b1085[n6];
                object4 = this.bd;
                object4 = object[object4][1] + 16;
                n5 = (n6 + 3) * 10;
                n3 = 10;
                n2 = 10;
                object = this;
                this.a(image, (int)object3, (int)object4, n5, 0, n3, n2, 0, 0);
                n6 = n = n6 + 1;
            }
            object = this.a1013[3];
            n4 = 27;
            image = object[n4];
            object3 = this.be;
            n = 240 - object3 - 42 + 2;
            object3 = n + 31;
            object4 = 17;
            n5 = 9;
            n3 = 9;
            n2 = 9;
            object = this;
            this.a(image, (int)object3, (int)object4, n5, 0, n3, n2, 0, 0);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void T() {
        int n = -42;
        int n2 = this.aT;
        int n3 = this.aX;
        if (n2 == n3 && (n2 = this.aP) == 0) {
            this.r1086 = true;
            this.bd = n2 = this.bd + 1;
            n3 = 3;
            if (n2 > n3) {
                this.bd = 0;
            }
            this.be = n2 = this.be + 6;
            if (n2 <= 0) return;
            this.be = 0;
            return;
        }
        n2 = this.be;
        n3 = 6;
        this.be = n2 -= n3;
        if (n2 >= n) return;
        this.be = n;
        this.r1086 = false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void U() {
        short[] sArray;
        int n = 0;
        short[] sArray2 = null;
        int n2 = this.aq;
        this.h(n2);
        this.aw = 0;
        this.bg = 0;
        n2 = this.s1088 ? 1 : 0;
        if (n2 != 0) {
            this.bf = 297;
            sArray = new short[this.bf];
            this.a1087 = sArray;
            this.bh = n2 = 4;
        } else {
            this.bf = 240;
            sArray = new short[this.bf];
            this.a1087 = sArray;
            this.bh = n2 = 5;
        }
        n2 = 0;
        sArray = null;
        while (true) {
            int n3;
            if (n2 >= (n = this.bf)) {
                this.bi = 100;
                this.c();
                this.c(33);
                return;
            }
            n = this.s1088 ? 1 : 0;
            if (n != 0) {
                sArray2 = this.a1087;
                sArray2[n2] = n3 = (int)(this.a() % 120 + 210);
            } else {
                sArray2 = this.a1087;
                int n4 = this.a() % 160;
                n3 = 40 - n4;
                n4 = 320;
                sArray2[n2] = n3 = (int)((short)(n3 - n4));
            }
            ++n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void V() {
        int n;
        int n2;
        for (n2 = 0; n2 < (n = this.bf); ++n2) {
            short s;
            short[] sArray;
            n = this.s1088 ? 1 : 0;
            if (n != 0) {
                sArray = this.a1087;
                s = sArray[n2];
                int n3 = 60;
                sArray[n2] = s = (short)(s - n3);
                if (s >= 0) continue;
                sArray = this.a1087;
                sArray[n2] = 0;
                continue;
            }
            sArray = this.a1087;
            sArray[n2] = s = (short)(sArray[n2] + 60);
            if (s <= 0) continue;
            sArray = this.a1087;
            sArray[n2] = 0;
        }
        n2 = this.bg;
        n = 15;
        if (n2 > n) {
            n2 = this.h1047;
            switch (n2) {
                default: {
                    break;
                }
                case -6: 
                case -5: 
                case 53: {
                    n2 = this.s1088 ? 1 : 0;
                    if (n2 != 0) {
                        n2 = this.T;
                        if (n2 == 0) {
                            n2 = 1;
                            this.t1089 = n2;
                        }
                        this.s1088 = false;
                        this.e(0);
                        this.c();
                        this.e(30);
                        this.c(4);
                        this.e(70);
                        this.l = 16;
                        n2 = 100;
                        this.e(n2);
                        this.b();
                        break;
                    }
                    this.B();
                }
            }
        }
        this.bg = n2 = this.bg + 1;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void W() {
        int n;
        short[] sArray;
        int n2;
        Graphics graphics = this.a1002;
        Image image = null;
        int n3 = 0;
        Object var4_25 = null;
        int n4 = 240;
        int n5 = 320;
        graphics.setClip(0, 0, n4, n5);
        Graphics graphics2 = this.a1002;
        int n6 = 13450878;
        graphics2.setColor(n6);
        Object var1_3 = null;
        for (n2 = 0; n2 < (n6 = this.bf); ++n2) {
            n6 = this.s1088 ? 1 : 0;
            if (n6 != 0) {
                image = this.a1002;
                short[] sArray2 = this.a1087;
                n3 = sArray2[n2];
                n4 = n2 + 13;
                sArray = this.a1087;
                n5 = sArray[n2] + 240;
                n = n2 + 13;
                image.drawLine(n3, n4, n5, n);
                continue;
            }
            image = this.a1002;
            short[] sArray3 = this.a1087;
            n3 = sArray3[n2] + 13;
            short[] sArray4 = this.a1087;
            n4 = sArray4[n2] + 320 + 13;
            image.drawLine(n2, n3, n2, n4);
        }
        n2 = this.bg;
        n6 = this.bh;
        if (n2 > n6) {
            int n7;
            Image image2;
            n2 = this.bg;
            n6 = this.bh + 2;
            if (n2 >= n6) {
                n6 = this.a1013[33][2].getWidth();
                int n8 = 240 - n6 >> 1;
                n2 = this.bi;
                image = this.a1013[33];
                n3 = 2;
                image = image[n3];
                n6 = image.getHeight() >> 1;
                int n9 = n2 - n6;
                n2 = this.s1088 ? 1 : 0;
                if (n2 != 0) {
                    int n10;
                    Graphics graphics3 = this.a1002;
                    image = this.a1013[33][2];
                    n3 = 0;
                    Object var4_30 = null;
                    graphics3.drawImage(image, n8, n9, 0);
                    n2 = this.bg;
                    n6 = this.bh + 3;
                    if (n2 >= n6) {
                        Image[] imageArray = this.a1013[33];
                        n6 = 4;
                        image = imageArray[n6];
                        n3 = n8 + 20;
                        n4 = n9 + 4;
                        n5 = 0;
                        sArray = null;
                        n = 0;
                        image2 = null;
                        n7 = 27;
                        n10 = 23;
                        a a2 = this;
                        this.a(image, n3, n4, 0, 0, n7, n10, 0, 0);
                    }
                    if ((n2 = this.bg) >= (n6 = this.bh + 4)) {
                        Image[] imageArray = this.a1013[33];
                        n6 = 4;
                        image = imageArray[n6];
                        n3 = n8 + 59;
                        n4 = n9 + 4;
                        n5 = 27;
                        n = 0;
                        image2 = null;
                        n7 = 27;
                        n10 = 23;
                        a a3 = this;
                        this.a(image, n3, n4, n5, 0, n7, n10, 0, 0);
                    }
                } else {
                    int n11;
                    Graphics graphics4 = this.a1002;
                    image = this.a1013[33][3];
                    n3 = 0;
                    Object var4_36 = null;
                    graphics4.drawImage(image, n8, n9, 0);
                    n2 = this.bg;
                    n6 = this.bh + 3;
                    if (n2 >= n6) {
                        Image[] imageArray = this.a1013[33];
                        n6 = 5;
                        image = imageArray[n6];
                        n3 = n8 + 20;
                        n4 = n9 + 4;
                        n5 = 0;
                        sArray = null;
                        n = 0;
                        image2 = null;
                        n7 = 27;
                        n11 = 23;
                        a a4 = this;
                        this.a(image, n3, n4, 0, 0, n7, n11, 0, 0);
                    }
                    if ((n2 = this.bg) >= (n6 = this.bh + 4)) {
                        Image[] imageArray = this.a1013[33];
                        n6 = 5;
                        image = imageArray[n6];
                        n3 = n8 + 59;
                        n4 = n9 + 4;
                        n5 = 27;
                        n = 0;
                        image2 = null;
                        n7 = 27;
                        n11 = 23;
                        a a5 = this;
                        this.a(image, n3, n4, n5, 0, n7, n11, 0, 0);
                    }
                }
                n2 = n8 + 20;
                n6 = this.bg;
                n3 = this.bh;
                n6 = n6 - n3 - 3;
                this.n(n2, n9, n6);
                n2 = n8 + 75;
                n6 = this.bg;
                n3 = this.bh;
                n6 -= n3;
                n3 = 4;
                this.n(n2, n9, n6 -= n3);
            }
            if ((n2 = this.bg) == (n6 = this.bh + 1)) {
                this.a1002.setColor(0xFFFFFF);
                Graphics graphics5 = this.a1002;
                n6 = 0;
                n3 = this.bi;
                n5 = this.bi;
                graphics5.drawLine(0, n3, 240, n5);
                Graphics graphics6 = this.a1002;
                image = this.a1013[33];
                Object var4_33 = null;
                image = image[0];
                Image image3 = this.a1013[33][0];
                n4 = image3.getWidth();
                n3 = 240 - n4 >> 1;
                n4 = this.bi - 14;
                n5 = 0;
                sArray = null;
                graphics6.drawImage(image, n3, n4, 0);
            }
            if ((n2 = this.bg) == (n6 = this.bh + 2)) {
                this.a1002.setColor(0xFFFFFF);
                Graphics graphics7 = this.a1002;
                Image image4 = this.a1013[33][1];
                n3 = image4.getWidth();
                n6 = 240 - n3 >> 1;
                n3 = this.bi;
                image2 = this.a1013[33];
                n7 = 1;
                image2 = image2[n7];
                n = image2.getWidth();
                n5 = 240 - n >> 1;
                n4 = 240 - n5;
                n5 = this.bi;
                graphics7.drawLine(n6, n3, n4, n5);
                Graphics graphics8 = this.a1002;
                image = this.a1013[33][1];
                Image image5 = this.a1013[33][1];
                n4 = image5.getWidth();
                n3 = 240 - n4 >> 1;
                n4 = this.bi - 4;
                n5 = 0;
                sArray = null;
                graphics8.drawImage(image, n3, n4, 0);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void X() {
        var1_1 = 2;
        var2_2 = 9;
        var3_3 = 8;
        var4_4 = 1;
        this.O();
        this.l(var4_4);
        var5_5 = this.l;
        if (var5_5 == var1_1 && (var5_5 = this.aP) <= 0 && (var5_5 = this.aT) == (var6_6 /* !! */  = this.aX) && (var5_5 = this.g1046) == (var6_6 /* !! */  = 35)) {
            this.p1078 = var4_4;
        }
        var7_7 = this.o1153;
        var8_8 /* !! */  = this.b1066;
        var9_9 /* !! */  = this.aP;
        var10_10 /* !! */  = 24;
        a.a(var7_7, var8_8 /* !! */ , var9_9 /* !! */ , var10_10 /* !! */ );
        var7_7 = null;
        block11: for (var5_5 = 0; var5_5 < (var6_6 /* !! */  = this.aP); ++var5_5) {
            var8_8 /* !! */  = this.b1066;
            var9_9 /* !! */  = this.o1153[var5_5];
            var8_8 /* !! */  = (int[][])var8_8 /* !! */ [var9_9 /* !! */ ];
            var9_9 /* !! */  = this.o1153[var5_5];
            this.z(var9_9 /* !! */ );
            var11_11 = this.o1153;
            var9_9 /* !! */  = var11_11[var5_5];
            this.s(var9_9 /* !! */ );
            var9_9 /* !! */  = (int)var8_8 /* !! */ [var3_3];
            switch (var9_9 /* !! */ ) lbl-1000:
            // 8 sources

            {
                default: lbl-1000:
                // 3 sources

                {
                    continue block11;
                }
                case 4: {
                    var9_9 /* !! */  = 17;
                    var10_10 /* !! */  = (int)(var8_8 /* !! */ [var9_9 /* !! */ ] + true);
                    var8_8 /* !! */ [var9_9 /* !! */ ] = (int[])var10_10 /* !! */ ;
                    var9_9 /* !! */  = 5;
                    if (var10_10 /* !! */  > var9_9 /* !! */ ) {
                        var9_9 /* !! */  = 17;
                        var8_8 /* !! */ [var9_9 /* !! */ ] = (int[])false;
                    }
                    if ((var9_9 /* !! */  = (int)var8_8 /* !! */ [var3_3]) == (var10_10 /* !! */  = 4)) {
                        var9_9 /* !! */  = 25;
                        var10_10 /* !! */  = (int)(var8_8 /* !! */ [var9_9 /* !! */ ] + true);
                        var8_8 /* !! */ [var9_9 /* !! */ ] = (int[])var10_10 /* !! */ ;
                        var9_9 /* !! */  = 100;
                        if (var10_10 /* !! */  > var9_9 /* !! */ ) {
                            var10_10 /* !! */  = 100;
                            var8_8 /* !! */ [25] = (int[])var10_10 /* !! */ ;
                            var9_9 /* !! */  = 17;
                            var8_8 /* !! */ [var9_9 /* !! */ ] = (int[])false;
                            var8_8 /* !! */ [var3_3] = (int[])false;
                        }
                    }
                }
                case 0: {
                    var9_9 /* !! */  = (int)var8_8 /* !! */ [6];
                    if ((var9_9 /* !! */  == var3_3 || (var9_9 /* !! */  = (int)var8_8 /* !! */ [6]) == var2_2) && (var9_9 /* !! */  = (int)var8_8 /* !! */ [var3_3]) == 0) {
                        var9_9 /* !! */  = 25;
                        var10_10 /* !! */  = (int)(var8_8 /* !! */ [var9_9 /* !! */ ] - var4_4);
                        var8_8 /* !! */ [var9_9 /* !! */ ] = (int[])var10_10 /* !! */ ;
                        if (var10_10 /* !! */  < 0) {
                            var8_8 /* !! */ [25] = (int[])false;
                            var9_9 /* !! */  = 4;
                            var8_8 /* !! */ [var3_3] = (int[])var9_9 /* !! */ ;
                        }
                    }
                    var11_11 = this.o1153;
                    var9_9 /* !! */  = var11_11[var5_5];
                    this.o(var9_9 /* !! */ );
                    var9_9 /* !! */  = (int)var8_8 /* !! */ [0];
                    var12_12 /* !! */  = this.k1081;
                    var13_13 /* !! */  = (int)var8_8 /* !! */ [5];
                    var12_12 /* !! */  = (byte[][])var12_12 /* !! */ [var13_13 /* !! */ ];
                    var10_10 /* !! */  = (int)var12_12 /* !! */ [0];
                    var13_13 /* !! */  = (int)var8_8 /* !! */ [4];
                    var9_9 /* !! */  += (var10_10 /* !! */  *= var13_13 /* !! */ );
                    var10_10 /* !! */  = (int)var8_8 /* !! */ [var4_4];
                    var14_14 /* !! */  = this.k1081;
                    var15_15 /* !! */  = var8_8 /* !! */ [5];
                    var13_13 /* !! */  = var14_14 /* !! */ [var15_15 /* !! */ ][var4_4];
                    var15_15 /* !! */  = var8_8 /* !! */ [4];
                    var14_14 /* !! */  = (byte[][])this.o1153;
                    var13_13 /* !! */  = (int)var14_14 /* !! */ [var5_5];
                    this.n(var13_13 /* !! */ );
                    var13_13 /* !! */  = this.a(var9_9 /* !! */ , var10_10 /* !! */  += (var13_13 /* !! */  *= var15_15 /* !! */ ));
                    var15_15 /* !! */  = var8_8 /* !! */ [0];
                    var16_16 = var8_8 /* !! */ [var4_4];
                    var15_15 /* !! */  = (int[])this.a((int)var15_15 /* !! */ , (int)var16_16);
                    if (var13_13 /* !! */  == var15_15 /* !! */ ) ** GOTO lbl88
                    var13_13 /* !! */  = (int)this.b(var9_9 /* !! */ , var10_10 /* !! */ );
                    if (var13_13 /* !! */  == 0) ** GOTO lbl96
                    this.a(var9_9 /* !! */ , var10_10 /* !! */ , (boolean)var4_4);
                    var13_13 /* !! */  = (int)var8_8 /* !! */ [0];
                    var15_15 /* !! */  = var8_8 /* !! */ [var4_4];
                    this.a(var13_13 /* !! */ , (int)var15_15 /* !! */ , false);
lbl88:
                    // 2 sources

                    var8_8 /* !! */ [0] = (int[])var9_9 /* !! */ ;
                    var8_8 /* !! */ [var4_4] = (int[])var10_10 /* !! */ ;
lbl90:
                    // 3 sources

                    while (true) {
                        var11_11 = this.o1153;
                        var9_9 /* !! */  = var11_11[var5_5];
                        var6_6 /* !! */  = (int)var8_8 /* !! */ [var1_1];
                        this.i(var9_9 /* !! */ , var6_6 /* !! */ );
                        ** GOTO lbl-1000
                        break;
                    }
lbl96:
                    // 1 sources

                    if ((var9_9 /* !! */  = (int)this.c(var9_9 /* !! */ , var10_10 /* !! */ )) == 0) ** GOTO lbl101
                    var8_8 /* !! */ [var3_3] = (int[])var3_3;
                    var9_9 /* !! */  = 7;
                    var8_8 /* !! */ [var9_9 /* !! */ ] = (int[])false;
                    ** GOTO lbl90
lbl101:
                    // 1 sources

                    var9_9 /* !! */  = 7;
                    var8_8 /* !! */ [var3_3] = (int[])var9_9 /* !! */ ;
                    ** continue;
                }
                case 1: {
                    var9_9 /* !! */  = var8_8 /* !! */ [var2_2] & 1;
                    var10_10 /* !! */  = var8_8 /* !! */ [5] & 1;
                    if (var9_9 /* !! */  != var10_10 /* !! */ ) ** GOTO lbl138
                    var9_9 /* !! */  = (int)var8_8 /* !! */ [0];
                    var12_12 /* !! */  = this.k1081;
                    var13_13 /* !! */  = (int)var8_8 /* !! */ [var2_2];
                    var12_12 /* !! */  = (byte[][])var12_12 /* !! */ [var13_13 /* !! */ ];
                    var10_10 /* !! */  = (int)(var12_12 /* !! */ [0] << 3);
                    var9_9 /* !! */  += var10_10 /* !! */ ;
                    var10_10 /* !! */  = (int)var8_8 /* !! */ [var4_4];
                    var14_14 /* !! */  = this.k1081;
                    var15_15 /* !! */  = var8_8 /* !! */ [var2_2];
                    var14_14 /* !! */  = (byte[][])var14_14 /* !! */ [var15_15 /* !! */ ];
                    var13_13 /* !! */  = (int)(var14_14 /* !! */ [var4_4] << 3);
                    var17_17 = var10_10 /* !! */  + var13_13 /* !! */ ;
                    var10_10 /* !! */  = var9_9 /* !! */ ;
                    var9_9 /* !! */  = var17_17;
lbl122:
                    // 2 sources

                    while ((var13_13 /* !! */  = (int)this.b(var10_10 /* !! */ , var9_9 /* !! */ )) != 0 && (var13_13 /* !! */  = this.c(var10_10 /* !! */ , var9_9 /* !! */ )) == (var15_15 /* !! */  = var8_8 /* !! */ [5])) {
                        this.a(var10_10 /* !! */ , var9_9 /* !! */ , (boolean)var4_4);
                        var13_13 /* !! */  = (int)var8_8 /* !! */ [0];
                        var15_15 /* !! */  = var8_8 /* !! */ [var4_4];
                        this.a(var13_13 /* !! */ , (int)var15_15 /* !! */ , false);
                        var8_8 /* !! */ [0] = (int[])var10_10 /* !! */ ;
                        var8_8 /* !! */ [var4_4] = (int[])var9_9 /* !! */ ;
                        var9_9 /* !! */  = 7;
                        var8_8 /* !! */ [var3_3] = (int[])var9_9 /* !! */ ;
lbl131:
                        // 2 sources

                        while (true) {
                            var11_11 = this.o1153;
                            var9_9 /* !! */  = var11_11[var5_5];
                            var6_6 /* !! */  = var8_8 /* !! */ [var1_1];
                            this.i(var9_9 /* !! */ , var6_6 /* !! */ );
                            ** GOTO lbl-1000
                            break;
                        }
                    }
                    ** GOTO lbl153
lbl138:
                    // 1 sources

                    var9_9 /* !! */  = (int)var8_8 /* !! */ [0];
                    var12_12 /* !! */  = this.k1081;
                    var13_13 /* !! */  = (int)var8_8 /* !! */ [var2_2];
                    var12_12 /* !! */  = (byte[][])var12_12 /* !! */ [var13_13 /* !! */ ];
                    var10_10 /* !! */  = (int)(var12_12 /* !! */ [0] << 4);
                    var9_9 /* !! */  += var10_10 /* !! */ ;
                    var10_10 /* !! */  = (int)var8_8 /* !! */ [var4_4];
                    var14_14 /* !! */  = this.k1081;
                    var15_15 /* !! */  = var8_8 /* !! */ [var2_2];
                    var14_14 /* !! */  = (byte[][])var14_14 /* !! */ [var15_15 /* !! */ ];
                    var13_13 /* !! */  = (int)(var14_14 /* !! */ [var4_4] << 4);
                    var17_17 = var10_10 /* !! */  + var13_13 /* !! */ ;
                    var10_10 /* !! */  = var9_9 /* !! */ ;
                    var9_9 /* !! */  = var17_17;
                    ** GOTO lbl122
lbl153:
                    // 1 sources

                    var9_9 /* !! */  = (int)var8_8 /* !! */ [0];
                    var12_12 /* !! */  = this.k1081;
                    var13_13 /* !! */  = (int)var8_8 /* !! */ [var2_2];
                    var10_10 /* !! */  = var12_12 /* !! */ [var13_13 /* !! */ ][0] << 2;
                    var8_8 /* !! */ [0] = (int[])(var9_9 /* !! */  += var10_10 /* !! */ );
                    var9_9 /* !! */  = (int)var8_8 /* !! */ [var4_4];
                    var12_12 /* !! */  = this.k1081;
                    var13_13 /* !! */  = (int)var8_8 /* !! */ [var2_2];
                    var12_12 /* !! */  = (byte[][])var12_12 /* !! */ [var13_13 /* !! */ ];
                    var10_10 /* !! */  = (int)(var12_12 /* !! */ [var4_4] << 2);
                    var8_8 /* !! */ [var4_4] = (int[])(var9_9 /* !! */  += var10_10 /* !! */ );
                    var8_8 /* !! */ [var3_3] = (int[])var1_1;
                    ** continue;
                }
                case 2: {
                    var9_9 /* !! */  = (int)var8_8 /* !! */ [0];
                    var12_12 /* !! */  = this.k1081;
                    var13_13 /* !! */  = var8_8 /* !! */ [var2_2] + 2 & 3;
                    var10_10 /* !! */  = var12_12 /* !! */ [var13_13 /* !! */ ][0] << 2;
                    var8_8 /* !! */ [0] = (int[])(var9_9 /* !! */  += var10_10 /* !! */ );
                    var9_9 /* !! */  = (int)var8_8 /* !! */ [var4_4];
                    var12_12 /* !! */  = this.k1081;
                    var13_13 /* !! */  = var8_8 /* !! */ [var2_2] + 2 & 3;
                    var12_12 /* !! */  = (byte[][])var12_12 /* !! */ [var13_13 /* !! */ ];
                    var10_10 /* !! */  = (int)(var12_12 /* !! */ [var4_4] << 2);
                    var8_8 /* !! */ [var4_4] = (int[])(var9_9 /* !! */  += var10_10 /* !! */ );
                    var8_8 /* !! */ [var3_3] = (int[])3;
                    var11_11 = this.o1153;
                    var9_9 /* !! */  = var11_11[var5_5];
                    var6_6 /* !! */  = (int)var8_8 /* !! */ [var1_1];
                    this.i(var9_9 /* !! */ , var6_6 /* !! */ );
                    ** GOTO lbl-1000
                }
                case 3: {
                    var8_8 /* !! */ [var3_3] = (int[])false;
                    var11_11 = this.o1153;
                    var9_9 /* !! */  = var11_11[var5_5];
                    var6_6 /* !! */  = (int)var8_8 /* !! */ [var1_1];
                    this.i(var9_9 /* !! */ , var6_6 /* !! */ );
                    ** GOTO lbl-1000
                }
                case 5: {
                    var9_9 /* !! */  = 7;
                    var10_10 /* !! */  = (int)(var8_8 /* !! */ [var9_9 /* !! */ ] + true);
                    var8_8 /* !! */ [var9_9 /* !! */ ] = (int[])var10_10 /* !! */ ;
                    if (var10_10 /* !! */  > var3_3) {
                        var8_8 /* !! */ [7] = (int[])false;
                        var9_9 /* !! */  = 6;
                        var8_8 /* !! */ [var3_3] = (int[])var9_9 /* !! */ ;
                    }
                    if ((var9_9 /* !! */  = (int)var8_8 /* !! */ [10]) != (var10_10 /* !! */  = -1)) {
                        var9_9 /* !! */  = 10;
                        var10_10 /* !! */  = (int)(var8_8 /* !! */ [var9_9 /* !! */ ] - var4_4);
                        var8_8 /* !! */ [var9_9 /* !! */ ] = (int[])var10_10 /* !! */ ;
                        if (var10_10 /* !! */  < 0) {
                            var9_9 /* !! */  = 10;
                            var10_10 /* !! */  = -1;
                            var8_8 /* !! */ [var9_9 /* !! */ ] = (int[])var10_10 /* !! */ ;
                        }
                    }
                    var9_9 /* !! */  = 15;
                    var8_8 /* !! */ [var9_9 /* !! */ ] = (int[])false;
                    ** GOTO lbl-1000
                }
                case 6: {
                    var9_9 /* !! */  = 6;
                    var6_6 /* !! */  = var8_8 /* !! */ [var9_9 /* !! */ ] & 1;
                    if (var6_6 /* !! */  != var4_4) ** GOTO lbl233
                    var6_6 /* !! */  = (int)this.z1169;
                    if (var6_6 /* !! */  != 0) {
                        this.bz = var6_6 /* !! */  = this.bz + 100;
lbl217:
                        // 2 sources

                        while (true) {
                            var8_8 /* !! */  = null;
                            for (var6_6 /* !! */  = 0; var6_6 /* !! */  < (var9_9 /* !! */  = this.aP); ++var6_6 /* !! */ ) {
                                var11_11 = this.b1066[var6_6 /* !! */ ];
                                var10_10 /* !! */  = 26;
                                var11_11[var10_10 /* !! */ ] = 0;
                            }
                            break;
                        }
                    } else {
                        this.bz = var6_6 /* !! */  = this.bz + 50;
                        ** continue;
                    }
                    this.ba = 0;
lbl228:
                    // 3 sources

                    while (true) {
                        var8_8 /* !! */  = (int[][])this.o1153;
                        var6_6 /* !! */  = (int)var8_8 /* !! */ [var5_5];
                        this.p(var6_6 /* !! */ );
                        ** GOTO lbl-1000
                        break;
                    }
lbl233:
                    // 1 sources

                    var6_6 /* !! */  = (int)this.z1169;
                    if (var6_6 /* !! */  == 0) ** GOTO lbl237
                    this.bz = var6_6 /* !! */  = this.bz + 10;
                    ** GOTO lbl228
lbl237:
                    // 1 sources

                    this.bz = var6_6 /* !! */  = this.bz + 5;
                    ** continue;
                }
                case 7: {
                    var11_11 = this.o1153;
                    var9_9 /* !! */  = var11_11[var5_5];
                    this.o(var9_9 /* !! */ );
                    var9_9 /* !! */  = (int)var8_8 /* !! */ [12];
                    if (var9_9 /* !! */  == 0) {
                        var8_8 /* !! */ [var3_3] = (int[])false;
                    }
                    var11_11 = this.o1153;
                    var9_9 /* !! */  = var11_11[var5_5];
                    var6_6 /* !! */  = (int)var8_8 /* !! */ [var1_1];
                    this.i(var9_9 /* !! */ , var6_6 /* !! */ );
                    ** GOTO lbl-1000
                }
                case 8: 
            }
            var9_9 /* !! */  = 7;
            var10_10 /* !! */  = (int)(var8_8 /* !! */ [var9_9 /* !! */ ] + true);
            var8_8 /* !! */ [var9_9 /* !! */ ] = (int[])var10_10 /* !! */ ;
            var6_6 /* !! */  = 4;
            if (var10_10 /* !! */  > var6_6 /* !! */ ) {
                this.by = var6_6 /* !! */  = this.by - var4_4;
                var8_8 /* !! */  = (int[][])this.o1153;
                var6_6 /* !! */  = (int)var8_8 /* !! */ [var5_5];
                this.p(var6_6 /* !! */ );
            }
            if ((var6_6 /* !! */  = this.by) > 0) ** GOTO lbl-1000
            this.o = var3_3;
            var6_6 /* !! */  = 3;
            this.F(var6_6 /* !! */ );
            ** continue;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void Y() {
        int[] nArray = this.n1152;
        int[][] nArray2 = this.b1066;
        int n = this.aP;
        a.a(nArray, nArray2, n, 1);
        Graphics graphics = this.a1002;
        boolean bl = false;
        Object var2_27 = null;
        boolean bl2 = false;
        Object var5_52 = null;
        int n2 = 240;
        int n3 = 320;
        graphics.setClip(0, 0, n2, n3);
        int n4 = 0;
        Object var1_3 = null;
        int n5 = 0;
        while (n5 < (n4 = this.aP)) {
            block16: {
                int n6;
                int n7;
                int n8;
                int n9;
                int n10;
                int[] nArray3;
                int n11;
                block18: {
                    block17: {
                        int[][] nArray4 = this.b1066;
                        int[] nArray5 = this.n1152;
                        n11 = nArray5[n5];
                        nArray3 = nArray4[n11];
                        Object var1_6 = null;
                        n4 = nArray3[0];
                        n11 = this.bP;
                        n4 -= n11;
                        n11 = nArray3[1];
                        n10 = this.bQ;
                        n11 -= n10;
                        n10 = 0;
                        Object var5_54 = null;
                        n9 = 0;
                        Object var11_73 = null;
                        n3 = 256;
                        n8 = 289;
                        if ((n4 = (int)(a.a(n4, n11, 0, 0, n3, n8) ? 1 : 0)) == 0 || (n4 = nArray3[8]) == (n11 = 6)) break block16;
                        n4 = nArray3[8];
                        n11 = 5;
                        if (n4 == n11 || (n4 = nArray3[8]) == (n11 = 6) || (n4 = nArray3[8]) == (n11 = 8) || (n4 = nArray3[8]) == (n11 = 4)) break block17;
                        n4 = nArray3[13];
                        if (n4 == 0) {
                            n11 = nArray3[26];
                            n4 = nArray3[0];
                            int n10 = this.bP;
                            n10 = n4 - n10;
                            n4 = nArray3[1];
                            int n9 = this.bQ;
                            n9 = n4 - n9 + 13;
                            n3 = nArray3[27];
                            a a2 = this;
                            this.a(n11, n10, n9, n3, true);
                            n11 = nArray3[6];
                            n4 = nArray3[0];
                            int n10 = this.bP;
                            n10 = n4 - n10;
                            n4 = nArray3[1];
                            int n9 = this.bQ;
                            n9 = n4 - n9 + 13;
                            byte[][] byArray = this.l1083;
                            n3 = nArray3[6] >> 1;
                            byte[] byArray2 = byArray[n3];
                            n3 = nArray3[7];
                            n3 = byArray2[n3];
                            n8 = nArray3[5];
                            a a3 = this;
                            this.f(n11, n10, n9, n3, n8);
                            n11 = nArray3[26];
                            n4 = nArray3[0];
                            int n10 = this.bP;
                            n10 = n4 - n10;
                            n4 = nArray3[1];
                            int n9 = this.bQ;
                            n9 = n4 - n9 + 13;
                            n3 = nArray3[27];
                            n8 = 0;
                            this.a(n11, n10, n9, n3, false);
                            n4 = this.u1096 ? 1 : 0;
                            if (n4 != 0) {
                                n4 = nArray3[2];
                                Object var2_30 = null;
                                n11 = nArray3[0];
                                n10 = this.bP;
                                n11 -= n10;
                                n10 = nArray3[1];
                                n9 = this.bQ;
                                n10 = n10 - n9 + 13;
                                n9 = nArray3[6];
                                this.b(n4, n11, n10, n9);
                            }
                        }
                        break block18;
                    }
                    n4 = nArray3[8];
                    n11 = 5;
                    if (n4 == n11) {
                        Image[] imageArray = this.a1013[31];
                        n11 = 1;
                        Image image = imageArray[n11];
                        n4 = nArray3[0] - 8;
                        int n10 = this.bP;
                        n10 = n4 - n10;
                        n4 = nArray3[1] - 24;
                        int n9 = this.bQ;
                        n9 = n4 - n9 + 13;
                        n4 = nArray3[7];
                        n3 = n4 * 15;
                        n8 = 0;
                        n7 = 15;
                        n6 = 30;
                        a a4 = this;
                        this.a(image, n10, n9, n3, 0, n7, n6, 0, 0);
                    } else {
                        n4 = nArray3[8];
                        n11 = 8;
                        if (n4 == n11) {
                            Image[] imageArray = this.a1013[31];
                            n11 = 2;
                            Image image = imageArray[n11];
                            n4 = nArray3[0] - 8;
                            int n10 = this.bP;
                            n10 = n4 - n10;
                            n4 = nArray3[1] - 24;
                            int n9 = this.bQ;
                            n9 = n4 - n9 + 13;
                            n4 = nArray3[7];
                            n3 = n4 * 24;
                            n8 = 0;
                            n7 = 24;
                            n6 = 24;
                            a a5 = this;
                            this.a(image, n10, n9, n3, 0, n7, n6, 0, 0);
                        } else {
                            n4 = nArray3[8];
                            n11 = 4;
                            if (n4 == n11) {
                                Image[][] imageArray = this.a1013;
                                n11 = this.bj;
                                Image image = imageArray[n11][2];
                                n4 = nArray3[0];
                                byte[][][] byArray = this.d1091;
                                n9 = nArray3[6];
                                byte[][] byArray3 = byArray[n9];
                                n9 = nArray3[5];
                                n10 = byArray3[n9][0];
                                n4 += n10;
                                int n10 = this.bP;
                                n10 = n4 - n10;
                                n4 = nArray3[1];
                                byte[][][] byArray4 = this.d1091;
                                n3 = nArray3[6];
                                byte[][] byArray5 = byArray4[n3];
                                n3 = nArray3[5];
                                n9 = byArray5[n3][1];
                                n4 += n9;
                                int n9 = this.bQ;
                                n9 = n4 - n9 + 13;
                                n4 = nArray3[17];
                                n3 = n4 * 21;
                                n6 = 19;
                                a a6 = this;
                                this.a(image, n10, n9, n3, 0, 21, n6, 0, 0);
                                this.a1002.setClip(0, 0, 240, 320);
                                Graphics graphics2 = this.a1002;
                                int[] nArray6 = this.k1071;
                                n10 = this.aN;
                                n11 = nArray6[n10];
                                graphics2.setColor(n11);
                                Graphics graphics3 = this.a1002;
                                Object var2_38 = null;
                                n11 = nArray3[0];
                                byte[][][] byArray6 = this.d1091;
                                n9 = nArray3[6];
                                byte[][] byArray7 = byArray6[n9];
                                n9 = nArray3[5];
                                byte[] byArray8 = byArray7[n9];
                                n10 = byArray8[0];
                                n11 += n10;
                                n10 = this.bP;
                                n11 = n11 - n10 + 8;
                                long l = this.a1019 & 1L;
                                n10 = (int)l;
                                n11 -= n10;
                                n10 = nArray3[1];
                                byte[][][] byArray9 = this.d1091;
                                n3 = nArray3[6];
                                byte[][] byArray10 = byArray9[n3];
                                n3 = nArray3[5];
                                byte[] byArray11 = byArray10[n3];
                                n9 = byArray11[1];
                                n10 += n9;
                                n9 = this.bQ;
                                n10 = n10 - n9 + 13 + 7;
                                n9 = (int)(this.a1019 & 1L);
                                n10 -= n9;
                                long l2 = this.a1019;
                                long l3 = 1L;
                                l2 = (l2 & l3) << 1;
                                n9 = (int)l2 + 6;
                                long l4 = this.a1019;
                                long l5 = 1L;
                                l4 = (l4 & l5) << 1;
                                n3 = (int)l4 + 6;
                                n8 = 0;
                                n7 = 360;
                                graphics3.fillArc(n11, n10, n9, n3, 0, n7);
                            }
                        }
                    }
                }
                if ((n4 = nArray3[2]) > 0 && ((n4 = nArray3[6]) == (n11 = 8) || (n4 = nArray3[6]) == (n11 = 9))) {
                    n4 = nArray3[25];
                    if (n4 >= 0 && (n4 = nArray3[25]) < (n11 = 5)) {
                        Image[] imageArray = this.a1013[31];
                        n11 = 2;
                        Image image = imageArray[n11];
                        n4 = nArray3[0] - 8;
                        int n10 = this.bP;
                        n10 = n4 - n10;
                        n4 = nArray3[1] - 20;
                        int n9 = this.bQ;
                        n9 = n4 - n9 + 13;
                        n4 = nArray3[25];
                        n3 = n4 * 24;
                        n8 = 0;
                        n7 = 24;
                        n6 = 24;
                        a a7 = this;
                        this.a(image, n10, n9, n3, 0, n7, n6, 0, 0);
                    } else {
                        n4 = nArray3[25];
                        n11 = 95;
                        if (n4 >= n11 && (n4 = nArray3[25]) <= (n11 = 100)) {
                            Image[] imageArray = this.a1013[31];
                            n11 = 2;
                            Image image = imageArray[n11];
                            n4 = nArray3[0] - 8;
                            int n10 = this.bP;
                            n10 = n4 - n10;
                            n4 = nArray3[1] - 20;
                            int n9 = this.bQ;
                            n9 = n4 - n9 + 13;
                            n3 = nArray3[25];
                            n4 = 100 - n3;
                            n3 = n4 * 24;
                            n8 = 0;
                            n7 = 24;
                            n6 = 24;
                            a a8 = this;
                            this.a(image, n10, n9, n3, 0, n7, n6, 0, 0);
                        }
                    }
                }
            }
            n5 = n4 = n5 + 1;
        }
        n4 = 0;
        Object var1_25 = null;
        int n12;
        while (n4 < (n12 = this.aP)) {
            int[][] nArray7 = this.b1066;
            int[] nArray8 = this.n1152;
            int n13 = nArray8[n4];
            int[] nArray9 = nArray7[n13];
            int n14 = 5;
            if ((n13 = nArray9[8]) != n14 && (n13 = nArray9[8]) != (n14 = 6) && (n13 = nArray9[8]) != (n14 = 8)) {
                int[] nArray10 = this.n1152;
                n13 = nArray10[n4];
                this.r(n13);
            }
            if ((n12 = nArray9[10]) != (n13 = -1)) {
                int[] nArray11 = this.n1152;
                n12 = nArray11[n4];
                this.q(n12);
            }
            ++n4;
        }
        return;
    }

    private void Z() {
        int n = 240;
        int n2 = 2;
        int n3 = 1;
        this.a1002.setClip(0, 0, n, 320);
        this.a1002.setColor(0xFCFFCD);
        Object object = this.a1002;
        int n4 = this.bn;
        int n5 = this.bo;
        int n6 = this.bp;
        int n7 = this.bq;
        object.fillRect(n4, n5, n6, n7);
        object = this.a1002;
        n4 = this.bn - n3;
        n5 = this.bo + 1;
        n6 = this.bp + 2;
        n7 = this.bq - n2;
        object.fillRect(n4, n5, n6, n7);
        int n8 = this.bb;
        n4 = 18;
        this.q(n8, n4, 293);
        object = this.a1002;
        Object object2 = this.a1013[3][28];
        n5 = 299;
        object.drawImage((Image)object2, 0, n5, 0);
        n8 = this.br;
        if (n8 == n2) {
            object = this.a1002;
            n4 = this.bl + 15;
            n5 = this.bm;
            n6 = this.bk;
            n5 += n6;
            n6 = this.bl + 15 + 8;
            n7 = this.bm;
            n2 = this.bk;
            n7 += n2;
            n2 = this.bl + 15 + 8;
            int n9 = this.bm;
            int n10 = this.bk;
            n9 = n9 + n10 + 8;
            object.fillTriangle(n4, n5, n6, n7, n2, n9);
            object = this.a1002;
            n4 = 5465994;
            object.setColor(n4);
            object = new StringBuffer();
            object2 = this.b1015;
            n5 = (this.ba - n3 << 1) + 155;
            object2 = object2[n5];
            object = ((StringBuffer)object).append((String)object2);
            object2 = this.b1015;
            n5 = this.bb + 28;
            object2 = object2[n5];
            object = ((StringBuffer)object).append((String)object2);
            object2 = this.b1015;
            n5 = (this.ba - n3 << 1) + 155 + 1;
            object2 = object2[n5];
            object2 = ((StringBuffer)object).append((String)object2).toString();
            n6 = this.bl + 10;
            n7 = this.bm + 5;
            n8 = (this.bl + 10) * 2;
            n2 = n - n8;
            n9 = this.bk;
            object = this;
            n5 = 0;
            this.a((String)object2, 0, n6, n7, n2, n9);
        }
    }

    private final int a() {
        return this.a1012.nextInt() & 0xFF;
    }

    private int a(int n) {
        return this.E1163[n] >> 1;
    }

    private int a(int n, int n2) {
        int n3 = n2 >> 4;
        int n4 = this.bG;
        n3 *= n4;
        n4 = n >> 4;
        return n3 + n4;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int a(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        block11: {
            n6 = 360;
            n5 = 180;
            float f = 2.52E-43f;
            int n7 = 0;
            n4 = 45;
            if (n2 == 0 || n3 == 0) {
                if (n2 == 0) {
                    if (n3 <= 0) return 270;
                    return 90;
                }
                if (n2 <= 0) return n5;
                return 0;
            }
            int n8 = Math.abs(n);
            int n9 = 89;
            float f2 = 1.25E-43f;
            int n10 = 0;
            int[] nArray = null;
            n7 = n4;
            n4 = n9;
            while (n4 > n10) {
                int[] nArray2 = this.j1049;
                int n11 = nArray2[n7];
                if (n11 > n8) {
                    n4 = n7 - 1;
                } else {
                    nArray = this.j1049;
                    n10 = nArray[n7];
                    if (n10 >= n8) break;
                    n10 = n7 + 1;
                }
                if (n4 <= n10) {
                    n4 = n10;
                    break block11;
                }
                n7 = n4 + n10 >> 1;
            }
            n4 = n7;
        }
        if (n2 < 0 && n3 > 0) {
            n4 = n5 - n4;
        } else if (n2 < 0 && n3 < 0) {
            n4 += 180;
        } else if (n2 > 0 && n3 < 0) {
            n4 = n6 - n4;
        }
        if (n4 < n6) return n4;
        return n4 += -360;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int a(int n, int n2, int n3, int n4) {
        int n5 = n3 - n;
        int n6 = n4 - n2;
        if (n5 == 0 || n6 == 0) {
            if (n5 == 0) {
                if (n6 <= 0) return 270;
                return 90;
            }
            if (n5 <= 0) return 180;
            return 0;
        }
        int n7 = Math.abs((n6 << 12) / n5);
        return this.a(n7, n5, n6);
    }

    /*
     * Enabled aggressive block sorting
     */
    private int a(int n, byte[] byArray, int n2) {
        int n3;
        int n4;
        int n5 = 0;
        byte[] byArray2 = this.s1102;
        if (byArray == byArray2) {
            boolean[] blArray = this.f1106;
            n4 = blArray[0];
            if (n4 != 0) {
                n4 = 5;
            } else {
                n4 = 0;
                Object var5_9 = null;
            }
            if ((n5 = (int)(this.i(n, n2) ? 1 : 0)) != 0) {
                n5 = n << 1;
                n5 = byArray[n5];
                n3 = (n << 1) + 1;
                n3 = byArray[n3];
                n5 = a.d(n5, n3, n2) >> 2;
                n4 += n5;
            }
        } else {
            byte[] byArray3 = this.u1104;
            if (byArray == byArray3 && (n4 = (int)(this.n(n, n2) ? 1 : 0)) != 0) {
                n4 = -10;
            } else {
                n4 = 0;
                Object var5_8 = null;
            }
        }
        n5 = n << 1;
        n5 = byArray[n5];
        n3 = (n << 1) + 1;
        n3 = byArray[n3];
        n5 = a.d(n5, n3, n2);
        return n4 + n5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String a(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        if (n < 0) {
            IOException iOException = new IOException("nag len");
            throw iOException;
        }
        if (n == 0) {
            return "";
        }
        char[] cArray = new char[n];
        int n2 = 0;
        String string = null;
        while (n2 < n) {
            char c;
            cArray[n2] = c = (char)dataInputStream.readShort();
            ++n2;
        }
        string = new String(cArray, 0, n);
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String a(String string) {
        int n = 7;
        int n2 = string.indexOf(47, n);
        if (n2 >= n) return string.substring(n, n2);
        n2 = string.length();
        return string.substring(n, n2);
    }

    private static short a(InputStream inputStream) {
        int n = inputStream.read() & 0xFF;
        int n2 = inputStream.read() << 8 & 0xFF00;
        return (short)(n | n2);
    }

    private void a() {
        int n;
        this.m = n = this.m - 1;
        int[] nArray = this.b;
        int n2 = this.m;
        this.l = n = nArray[n2];
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(byte by) {
        this.G(by);
        switch (by) {
            default: {
                break;
            }
            case 1: {
                this.H(16);
                int n = 44;
                this.H(n);
                String string = "N73";
                this.c(string);
            }
        }
        this.ay();
        this.av();
    }

    private void a(int n) {
        int n2;
        int n3;
        int[] nArray = this.b;
        int n4 = this.m;
        nArray[n4] = n3 = this.l;
        this.l = n;
        this.m = n2 = this.m + 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n, int n2) {
        short s = 0;
        byte[] byArray = null;
        try {
            int n3;
            Object object = this.a1013;
            object = object[n];
            if (object != null) {
                object = this.a1013;
                object = object[n];
                if ((object = object[n2]) != null) {
                    return;
                }
            }
            object = this.a1013;
            if ((object = object[n]) == null) {
                object = this.a1013;
                int[] nArray = this.f;
                n3 = nArray[n];
                Image[] imageArray = new Image[n3];
                object[n] = imageArray;
            }
            this.getClass();
            object = this.a1014;
            object = object[n];
            object = Display.getResourceAsStream((String)object);
            n3 = 0;
            Object var6_9 = null;
            while (true) {
                if (n3 >= n2) {
                    Image image;
                    n3 = a.a((InputStream)object);
                    byArray = new byte[n3];
                    Image[][] imageArray = null;
                    ((InputStream)object).read(byArray, 0, n3);
                    imageArray = this.a1013;
                    imageArray = imageArray[n];
                    imageArray[n2] = image = Image.createImage((byte[])byArray, (int)0, (int)n3);
                    ((InputStream)object).close();
                    return;
                }
                s = a.a((InputStream)object);
                long l = s;
                ((InputStream)object).skip(l);
                ++n3;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    private void a(int n, int n2, int n3) {
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(13971834);
        Graphics graphics = this.a1002;
        String string = this.b1015[n];
        graphics.drawString(string, n2, n3, 0);
    }

    /*
     * Unable to fully structure code
     */
    private void a(int var1_1, int var2_2, int var3_3, byte var4_4, int var5_5, boolean var6_6) {
        block7: {
            var7_7 = 3;
            var8_8 = 3;
            var9_9 = 4.2E-45f;
            var10_10 = 0;
            var11_11 = 0;
            if (var5_5 <= 0 || var5_5 >= (var12_12 = 4)) ** GOTO lbl-1000
            block0 : switch (var3_3) {
                default: lbl-1000:
                // 2 sources

                {
                    var11_11 = var7_7;
                    var7_7 = 0;
                    var13_13 = var8_8;
                    var8_8 = 0;
                    var9_9 = 0.0f;
                    var10_10 = var13_13;
lbl15:
                    // 5 sources

                    while (var8_8 < var11_11) {
                        for (var12_12 = var7_7; var12_12 < var10_10; ++var12_12) {
                            var14_14 = var8_8 << 4;
                            var15_15 = this.m1084[var3_3][0];
                            var14_14 = var14_14 * var15_15 + var1_1;
                            var15_15 = this.m1084[var3_3][2];
                            var14_14 += var15_15;
                            var15_15 = var12_12 << 4;
                            var16_16 = this.m1084[var3_3][1];
                            var15_15 = var15_15 * var16_16 + var2_2;
                            var17_17 = this.m1084[var3_3];
                            var18_18 = 3;
                            var16_16 = var17_17[var18_18];
                            var14_14 = this.a(var14_14, var15_15 += var16_16);
                            var19_19 = this.D1162;
                            var19_19[var14_14] = var4_4;
                        }
                        break block0;
                    }
                    break block7;
                }
                case 0: 
                case 2: {
                    if (!var6_6) ** GOTO lbl44
                    while (true) {
                        var8_8 = var5_5 - 1;
                        var11_11 = var7_7;
                        var7_7 = var8_8;
                        var8_8 = 0;
                        var9_9 = 0.0f;
                        var10_10 = var5_5;
                        ** GOTO lbl15
                        break;
                    }
lbl44:
                    // 1 sources

                    var7_7 = var5_5 - 1;
                    var10_10 = var8_8;
                    var8_8 = var7_7;
                    var7_7 = 0;
                    var11_11 = var5_5;
                    ** GOTO lbl15
                }
                case 1: 
                case 3: {
                    if (!var6_6) ** continue;
                    var7_7 = var5_5 - 1;
                    var10_10 = var8_8;
                    var8_8 = var7_7;
                    var7_7 = 0;
                    var11_11 = var5_5;
                    ** GOTO lbl15
                }
            }
            ++var8_8;
            ** GOTO lbl15
        }
    }

    private void a(int n, int n2, int n3, int n4) {
        Object object = 0;
        Object object2 = null;
        int n5 = 0;
        while (n5 < (object = this.aF)) {
            byte[] byArray;
            int n6;
            int n7;
            int n8;
            object = n5 * 20;
            int n9 = n + object;
            object = this.aD;
            Object object3 = this.aE;
            if ((object -= object3) == n5) {
                object2 = this.a1002;
                object3 = n9 - 4;
                n8 = n2 - 3;
                n7 = n3 + 8;
                n6 = n4 + 2;
                object2.setClip(object3, n8, n7, n6);
                this.a1002.setColor(0xFCFFCD);
                object2 = this.a1002;
                object3 = n9 - 3;
                n8 = n2 - 3;
                object2.drawRect(object3, n8, 21, 20);
                object2 = this.a1002;
                object3 = n9 - 2;
                n8 = n2 - 2;
                n7 = 19;
                n6 = 19;
                object2.drawRect(object3, n8, n7, n6);
            }
            object2 = this.d1053;
            object3 = this.aC;
            object2 = object2[object3];
            object3 = this.aE + n5;
            object3 = object2[object3];
            object2 = this;
            n8 = n2;
            n7 = n3;
            n6 = n4;
            this.d((int)object3, n9, n2, n3, n4);
            object = this.aC;
            if (object == 0 && (object = this.aE + n5) < (object3 = 11) && (object = (Object)(object2 = (Object)this.e1105)[object3 = (byArray = this.d1053[0])[n8 = this.aE + n5]]) == 0 || (object = this.aC) == (object3 = 1) && (object = this.bt) < (object3 = 1) && (object = this.aE + n5) < (object3 = 5)) {
                object2 = this.f1055;
                object3 = this.aH;
                object = object2[object3];
                if (object != (object3 = -1)) {
                    object = this.aD;
                    object3 = this.aE;
                    if ((object -= object3) == n5) {
                        object = this.aH;
                        this.k(n9, n2, (int)object);
                    }
                }
            }
            n5 = object = n5 + 1;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(int n, int n2, int n3, int n4, int n5) {
        int n6 = this.o;
        int n7 = -1;
        if (n6 == n7) {
            return;
        }
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(13971834);
        String[] stringArray = this.b1015;
        n7 = n + 113;
        String string = stringArray[n7];
        a a2 = this;
        this.a(string, 0, n2, n3, n4, n5);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n6 == 0) {
            int n7 = 2;
            int n8 = n2;
            this.c(n2, n3, n4, n5, n7);
            int n9 = n2 - 5;
            n8 = n3 - 2;
            this.e(n, n9, n8);
            return;
        }
        int n10 = 3;
        int n11 = n2;
        this.c(n2, n3, n4, n5, n10);
        int n12 = n2 + n4 - 15;
        n11 = n3 - 2;
        this.e(n, n12, n11);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8 = 5;
        int n9 = n2 > n8 ? (n8 = 5) : n2;
        n8 = 0;
        Object var10_10 = null;
        int n10 = 0;
        while (true) {
            byte[] byArray;
            int n11;
            int n12;
            int n13;
            int n14;
            byte[] byArray2;
            if (n10 >= (n8 = (byArray2 = this.q1114[n])[n14 = n9 >> 1])) {
                a a2 = this;
                int n15 = n3;
                int n16 = n4;
                int n17 = n;
                n13 = n5;
                n12 = n6;
                n11 = n7;
                this.d(n3, n4, n, n5, n6, n7);
                this.a1002.setClip(0, 0, 240, 320);
                return;
            }
            byte[][] byArray3 = this.g1113[n];
            n14 = n9 >> 1;
            byte[] byArray4 = byArray3[n14];
            n14 = n10 * 3;
            n8 = byArray4[n14];
            byte[][] byArray5 = this.g1113[n];
            int n18 = n9 >> 1;
            byte[] byArray6 = byArray5[n18];
            int n18 = n10 * 3 + 1;
            n18 = byArray6[n18];
            byte[][] byArray7 = this.g1113[n];
            int n19 = n9 >> 1;
            byte[] byArray8 = byArray7[n19];
            int n19 = n10 * 3 + 2;
            n19 = byArray8[n19];
            n14 = 0;
            Object var13_25 = null;
            n13 = 0;
            byte[] byArray9 = null;
            n12 = 10;
            if (n == n12) {
                byte[] byArray10 = this.r1115[n6];
                n14 = byArray10[0];
                byArray9 = this.r1115[n6];
                n13 = byArray9[1];
                n12 = n14;
            } else {
                n12 = 0;
                byArray = null;
            }
            Image[][] imageArray = this.a1013;
            n11 = n + 18;
            Image image = imageArray[n11][0];
            n18 = n18 + n3 + n12;
            n19 = n19 + n4 + n13 + 13;
            byArray9 = this.f1112[n][n8];
            n13 = byArray9[0];
            byArray = this.f1112[n][n8];
            n12 = byArray[1];
            byte[] byArray11 = this.f1112[n][n8];
            n11 = byArray11[2];
            byte[][] byArray12 = this.f1112[n];
            byte by = byArray12[n8][3];
            a a3 = this;
            this.a(image, n18, n19, n13, n12, n11, by, 0, 0);
            n10 = n8 = n10 + 1;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        Object object;
        Image image;
        Image image2;
        Image image3;
        int n9;
        int n10;
        int n11 = 0;
        Image image4 = null;
        int n12 = 0;
        Image image5 = null;
        int n13 = 0;
        Image image6 = null;
        int n14 = 0;
        Image image7 = null;
        Object object2 = 0;
        Object object3 = null;
        Object object4 = 0;
        Object object5 = null;
        int n15 = 5;
        int n16 = n5;
        n15 = n5 > n15 ? 5 : n5;
        switch (n8) {
            default: {
                n10 = 0;
                n9 = 0;
                image3 = null;
                image2 = null;
                image = null;
                n12 = 0;
                image5 = null;
                break;
            }
            case 3: {
                object = this;
                image4 = object = this.a1013;
                image4 = object[29];
                n12 = 22;
                image4 = image4[n12];
                object = this;
                image5 = object = this.a1013;
                image5 = object[29];
                n13 = 19;
                image5 = image5[n13];
                object = this;
                image6 = object = this.a1013;
                image6 = object[29];
                n14 = 21;
                image6 = image6[n14];
                object = this;
                image7 = object = this.a1013;
                image7 = object[29];
                image7 = image7[20];
                object = this;
                object3 = object = (Object)this.J1144;
                object4 = n15 >> 1;
                object3 = object[object4];
                object2 = object3[0];
                object = this;
                object5 = object = (Object)this.J1144;
                object5 = object[n15 >>= 1];
                n15 = 1;
                n10 = object4 = (Object)object5[n15];
                n9 = object2;
                image3 = image7;
                image2 = image6;
                image = image5;
                image5 = image4;
                break;
            }
            case 5: {
                object = this;
                image4 = object = this.a1013;
                image4 = object[29];
                n12 = 26;
                image4 = image4[n12];
                object = this;
                image5 = object = this.a1013;
                image5 = object[29];
                n13 = 23;
                image5 = image5[n13];
                object = this;
                image6 = object = this.a1013;
                image6 = object[29];
                n14 = 25;
                image6 = image6[n14];
                object = this;
                image7 = object = this.a1013;
                image7 = object[29][24];
                object2 = -5;
                n10 = object4 = -26;
                n9 = object2;
                image3 = image7;
                image2 = image6;
                image = image5;
                image5 = image4;
            }
        }
        switch (n7) {
            case 0: {
                n11 = n + n9;
                n13 = n2 + n10;
                object = this;
                super.s(n11, n13, n6);
                n11 = 1;
                n16 = n6;
                if (n6 > n11 && n6 < (n11 = 4)) {
                    switch (n8) {
                        default: {
                            break;
                        }
                        case 3: {
                            n11 = n + n9 + 21;
                            n13 = n16 = this.bP;
                            n13 = n11 - n16;
                            n11 = n2 + n10 + 16;
                            n14 = n16 = this.bQ;
                            n14 = n11 - n16 + 13;
                            n11 = n6 - 2;
                            object2 = n11 << 4;
                            object4 = 0;
                            object5 = null;
                            n15 = 16;
                            int n17 = 16;
                            image4 = this;
                            super.a(image5, n13, n14, (int)object2, 0, n15, n17, 0, 0);
                            break;
                        }
                        case 5: {
                            n11 = n + n9 + 24;
                            n13 = n16 = this.bP;
                            n13 = n11 - n16;
                            n11 = n2 + n10 + 23;
                            n14 = n16 = this.bQ;
                            n14 = n11 - n16 + 13;
                            n11 = n6 - 2;
                            object2 = n11 * 12;
                            object4 = 0;
                            object5 = null;
                            n15 = 12;
                            int n18 = 17;
                            image4 = this;
                            super.a(image5, n13, n14, (int)object2, 0, n15, n18, 0, 0);
                            break;
                        }
                    }
                } else {
                    n11 = 5;
                    n16 = n6;
                    if (n6 <= n11) return;
                    n11 = n + n9 + 26;
                    object = this;
                    n12 = n16 = this.bP;
                    n13 = n11 - n16;
                    n11 = n2 + n10 - 31;
                    n12 = n16 = this.bQ;
                    n14 = n11 - n16 + 13;
                    object2 = (n6 - 6) * 7;
                    object4 = 0;
                    object5 = null;
                    n15 = 7;
                    int n19 = 45;
                    image4 = this;
                    image5 = image;
                    super.a(image, n13, n14, (int)object2, 0, n15, n19, 0, 0);
                    n11 = 6;
                    n16 = n6;
                    if (n6 <= n11) return;
                    n11 = n + n9 + 22;
                    n12 = n16 = this.bP;
                    n13 = n11 - n16;
                    n11 = n2 + n10 - 37 - 15;
                    n12 = n16 = this.bQ;
                    n14 = n11 - n16 + 13;
                    n11 = n6 - 7;
                    object2 = n11 * 15;
                    object4 = 0;
                    object5 = null;
                    n15 = 15;
                    n19 = 15;
                    image5 = image2;
                    super.a(image2, n13, n14, (int)object2, 0, n15, n19, 0, 0);
                }
            }
            default: {
                return;
            }
            case 1: 
        }
        object = this;
        n11 = n16 = this.bP;
        n13 = n3 - n16;
        n11 = n16 = this.bQ;
        n14 = n4 - n16 + 13;
        object2 = n6 * 12;
        image4 = this;
        image5 = image3;
        super.a(image3, n13, n14, (int)object2, 0, 12, 41, 0, 0);
        n11 = n16 = this.bP;
        n13 = n3 - n16;
        n11 = n4 - 15;
        n12 = n16 = this.bQ;
        n14 = (n11 -= n16) + 13;
        object2 = n6 * 15;
        object4 = 0;
        object5 = null;
        n15 = 15;
        int n20 = 15;
        image5 = image2;
        super.a(image2, n13, n14, (int)object2, 0, n15, n20, 0, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(int n, int n2, int n3, int n4, boolean bl) {
        if (bl) {
            int n5 = 1;
            if (n != n5 && n != (n5 = 2) && n != (n5 = 3)) {
                n5 = 7;
                if (n != n5) return;
            }
            this.o(n2, n3, n4);
            return;
        }
        int n6 = 4;
        if (n == n6 || n == (n6 = 5)) {
            this.o(n2, n3, n4);
            return;
        }
        n6 = 8;
        if (n != n6) {
            n6 = 6;
            if (n != n6) return;
        }
        if (n4 == (n6 = -2)) return;
        this.o(n2, n3, n4);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(int n, int n2, int n3, boolean bl) {
        int n4 = 10;
        int n5 = 2;
        int n6 = 0;
        byte[] byArray = this.i1062;
        int n7 = n << 2;
        int n8 = byArray[n7];
        byte[] byArray2 = this.i1062;
        int n9 = (n << 2) + 1;
        n7 = byArray2[n9];
        byte[] byArray3 = this.i1062;
        int n10 = (n << 2) + 2;
        n9 = byArray3[n10];
        byte[] byArray4 = this.i1062;
        int n11 = (n << 2) + 3;
        n10 = byArray4[n11];
        if (bl) {
            if (n == n5) {
                n11 = n4;
            } else {
                byte[] byArray5 = this.e1058[n8];
                n11 = byArray5[n5] >> 1;
            }
            n5 = n < (n5 = 3) ? n4 : 0;
        } else {
            n11 = 0;
            Object var17_18 = null;
            n5 = 0;
        }
        if (n8 != (n6 = -1)) {
            n6 = n2 - n11;
            n4 = n3 - n5;
            this.l(n8, n6, n4);
        }
        n8 = n2 - n11 + n9;
        n9 = n3 - n5 + n10;
        this.l(n7, n8, n9);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void a(int n, int n2, boolean bl) {
        if (bl) {
            boolean bl2 = this.b(n, n2);
            if (!bl2) {
                return;
            }
        } else {
            boolean bl3 = this.b(n, n2);
            if (bl3) return;
        }
        byte[] byArray = this.E1163;
        int n3 = this.a(n, n2);
        byte[] byArray2 = this.E1163;
        int n4 = this.a(n, n2);
        byte by = byArray2[n4];
        n4 = bl ? 1 : -1;
        byArray[n3] = by = (byte)(by + n4);
    }

    private void a(String string) {
        this.e();
        this.a1002.setColor(7438477);
        int n = this.c;
        this.a(string, n, 27, 18, 186, 292);
    }

    private void a(String string, int n, int n2) {
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(0xFCFFCD);
        Graphics graphics = this.a1002;
        int n3 = string.length();
        int n4 = this.k;
        n3 = n3 * n4 + 2;
        n4 = this.j + 1;
        graphics.fillRect(n, n2, n3, n4);
        this.a1002.setColor(14174337);
        graphics = this.a1002;
        n3 = n + 1;
        n4 = n2 + 1;
        graphics.drawString(string, n3, n4, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void a(String string, int n, int n2, int n3, int n4, int n5) {
        String string2;
        Object object;
        int n6 = 10;
        int n7 = this.d;
        char[] cArray = string.toCharArray();
        int n8 = cArray.length;
        int n9 = n7 == n8 && (n8 <= n6 || (n7 = ((String)(object = this.a1009)).compareTo(string2 = string.substring(0, n6))) == 0) ? 0 : (n7 = 1);
        if (n9 != 0 && n8 > n6) {
            this.a1009 = object = string.substring(0, n6);
        }
        object = this;
        n6 = n2;
        this.a(cArray, n8, n, n2, n3, n4, n5, n9 != 0);
    }

    private void a(Image image, int n, int n2, int n3) {
        DirectGraphics directGraphics = this.a1005;
        int n4 = a1001[n3];
        directGraphics.drawImage(image, n, n2, 0, n4);
    }

    private void a(Image image, int n, int n2, int n3, int n4) {
        this.a1002.setClip(0, 0, 240, 320);
        int n5 = image.getWidth();
        int n6 = image.getHeight();
        this.a1002.drawImage(image, n, n2, 0);
        int n7 = n + n3 - n5;
        this.a(image, n7, n2, 1);
        n7 = n2 + n4 - n6;
        this.a(image, n, n7, 2);
        n5 = n + n3 - n5;
        n6 = n2 + n4 - n6;
        this.a(image, n5, n6, 3);
    }

    private void a(Image image, int n, int n2, int n3, int n4, int n5) {
        int n6 = 0;
        Object object = null;
        int n7 = 0;
        while (n7 < (n6 = ((byte[][])(object = this.i1122[n3])).length)) {
            n6 = this.i1122[n3][n7][0];
            int n8 = n + n6;
            int n9 = this.i1122[n3][n7][1] + n2 + 13;
            n6 = this.w1123[n3][n4];
            Object object2 = this.w1123[n3];
            int n10 = n5 - 2;
            int n11 = object2[n10];
            n10 = n6 * n11;
            object = this.w1123[n3];
            n11 = n5 - 2;
            byte[] byArray = object[n11];
            object = this.w1123[n3];
            n11 = n5 - 1;
            byte[] byArray2 = object[n11];
            object = this;
            object2 = image;
            this.a(image, n8, n9, n10, 0, (int)byArray, (int)byArray2, 0, 0);
            n7 = n6 = n7 + 1;
        }
    }

    private void a(Image image, int n, int n2, int n3, int n4, int n5, int n6) {
        this.a1002.setClip(n, n2, n5, n6);
        Graphics graphics = this.a1002;
        int n7 = n - n3;
        int n8 = n2 - n4;
        graphics.drawImage(image, n7, n8, 0);
        this.a1002.setClip(0, 0, 240, 320);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Image image, int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8;
        int n9 = 16;
        int n10 = image.getWidth();
        int n11 = image.getHeight();
        switch (n4) {
            default: {
                n11 = 0;
                n8 = 0;
                break;
            }
            case 0: {
                n10 = (n7 & 3) << 4;
                n11 = n7 >> 2 << 4;
                n8 = n10;
                break;
            }
            case 1: {
                n11 = (n7 & 3) << 4;
                n10 = n10 - n11 - n9;
                n11 = n7 >> 2 << 4;
                n8 = n10;
                break;
            }
            case 2: {
                n10 = (n7 & 3) << 4;
                n8 = n7 >> 2 << 4;
                n11 = n11 - n8 - n9;
                n8 = n10;
                break;
            }
            case 3: {
                n8 = (n7 & 3) << 4;
                n10 = n10 - n8 - n9;
                n8 = n7 >> 2 << 4;
                n11 = n11 - n8 - n9;
                n8 = n10;
                break;
            }
            case 4: {
                n10 = n7 >> 2 << 4;
                n11 = (n7 & 3) << 4;
                n8 = n10;
                break;
            }
            case 5: {
                n10 = n7 >> 2 << 4;
                n10 = n11 - n10 - n9;
                n11 = (n7 & 3) << 4;
                n8 = n10;
                break;
            }
            case 6: {
                n11 = n7 >> 2 << 4;
                n8 = (n7 & 3) << 4;
                n10 = n10 - n8 - n9;
                n8 = n11;
                n11 = n10;
                break;
            }
            case 7: {
                n8 = n7 >> 2 << 4;
                n11 = n11 - n8 - n9;
                n8 = (n7 & 3) << 4;
                n10 = n10 - n8 - n9;
                n8 = n11;
                n11 = n10;
            }
        }
        if (n == (n10 = 1)) {
            DirectGraphics directGraphics;
            this.b1003.setClip(n5, n6, n2, n3);
            directGraphics = this.b1006 = (directGraphics = DirectUtils.getDirectGraphics((Graphics)this.b1003));
            n8 = n5 - n8;
            n9 = n6 - n11;
            int n12 = a1001[n4];
            directGraphics.drawImage(image, n8, n9, 0, n12);
            return;
        }
        DirectGraphics directGraphics = this.a1005;
        n8 = n5 - n8;
        n9 = n6 - n11;
        int n13 = a1001[n4];
        directGraphics.drawImage(image, n8, n9, 0, n13);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Image image, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        int n9;
        int n10;
        int n11 = n8 & 4;
        if (n11 != 0) {
            n11 = n5 >> 1;
            n11 = n - n11;
        } else {
            n11 = n;
        }
        if ((n10 = n8 & 8) != 0) {
            n10 = n6 >> 1;
            n10 = n2 - n10;
        } else {
            n10 = n2;
        }
        if ((n9 = n8 & 1) != 0) {
            n11 -= n5;
        }
        if ((n9 = n8 & 2) != 0) {
            n10 -= n6;
        }
        Graphics graphics = this.a1002;
        graphics.setClip(n11, n10, n5, n6);
        if (n7 == 0) {
            graphics = this.a1002;
            graphics.drawImage(image, n11 -= n3, n10 -= n4, 0);
        } else {
            this.a(image, n11 -= n3, n10 -= n4, n7);
        }
        this.a1002.setClip(0, 0, 240, 320);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Image image, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10;
        int n11;
        Image[] imageArray = this.a1040;
        if (imageArray == null) {
            n11 = 26;
            Image[] imageArray2 = new Image[n11];
            this.a1040 = imageArray2;
        }
        if ((n11 = (int)this.a1038) < (n10 = 26)) {
            int n12;
            int n13;
            int n14;
            int n15;
            int[][] nArray = this.a1039;
            n10 = this.a1038;
            int[] nArray2 = nArray[n10];
            if (n9 >= 0 && n9 < (n10 = (int)this.a1038)) {
                Image image2;
                int[][] nArray3 = this.a1039;
                n15 = this.a1038;
                int[] nArray4 = this.a1039[n9];
                nArray3[n15] = nArray4;
                Image[] imageArray3 = this.a1040;
                n15 = this.a1038;
                imageArray3[n15] = image2 = this.a1040[n9];
                this.a1040[n9] = image;
                int[][] nArray5 = this.a1039;
                nArray5[n9] = nArray2;
                int[] nArray6 = this.a1039[n9];
            } else {
                Image[] imageArray4 = this.a1040;
                n15 = this.a1038;
                imageArray4[n15] = image;
            }
            if (n3 == (n10 = 3)) {
                var11_17[6] = n8;
                n10 = n7;
                n15 = n6;
                n14 = n2;
                n13 = n;
            } else {
                n10 = image.getWidth();
                n15 = image.getHeight();
                n14 = 2;
                if (n3 == n14) {
                    n14 = 6;
                    var11_17[n14] = n10 /= n5;
                }
                n14 = 0;
                Object var16_28 = null;
                n13 = 0;
                n12 = n4 & 1;
                if (n12 != 0) {
                    n14 = 0;
                    Object var16_29 = null;
                    n10 = 0 - n10;
                } else {
                    n12 = n4 & 4;
                    if (n12 != 0) {
                        n14 = 0;
                        Object var16_31 = null;
                        n10 >>= 1;
                        n10 = 0 - n10;
                    } else {
                        n10 = 0;
                        Object var14_24 = null;
                    }
                }
                if ((n14 = n4 & 2) != 0) {
                    n14 = 0;
                    Object var16_30 = null;
                    n13 = 1;
                    n15 -= n13;
                    n15 = 0 - n15;
                } else {
                    n14 = n4 & 8;
                    if (n14 != 0) {
                        n14 = 0;
                        Object var16_32 = null;
                        n15 >>= 1;
                        n13 = 1;
                        n15 -= n13;
                        n15 = 0 - n15;
                    } else {
                        n15 = 0;
                    }
                }
                n14 = n + n10;
                n13 = n2 + n15;
                n12 = 1;
                if (n3 == n12) {
                    int n16 = n15 + n7;
                    n15 = n10 += n6;
                    n10 = n16;
                    int n17 = n13;
                    n13 = n14;
                    n14 = n17;
                } else {
                    n10 = n7;
                    n15 = n6;
                    int n18 = n13;
                    n13 = n14;
                    n14 = n18;
                }
            }
            n12 = 0;
            var11_17[0] = n13;
            n13 = 1;
            var11_17[n13] = n14;
            var11_17[2] = n3;
            var11_17[3] = n5;
            n14 = 4;
            var11_17[n14] = n15;
            n15 = 5;
            var11_17[n15] = n10;
            n11 = (byte)(this.a1038 + 1);
            this.a1038 = (byte)n11;
        }
    }

    private void a(Image image, int n, int n2, int n3, boolean bl) {
        int n4 = 240;
        if (bl) {
            this.a1002.setColor(n3);
            Graphics graphics = this.a1002;
            int n5 = image.getHeight();
            graphics.fillRect(0, n2, n4, n5);
        }
        this.a1002.drawImage(image, n, n2, 0);
        int n6 = image.getWidth();
        n6 = n4 - n6 - n;
        this.a(image, n6, n2, 1);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Image image, Image image2, int n, int n2, int n3, int n4, int n5) {
        int n6;
        int n7;
        int n8;
        int[] nArray = this.c1107[n];
        Object object = null;
        Object object2 = nArray[0];
        Object object3 = this.o1098;
        int n9 = nArray[2];
        int n10 = object3[n9] << 3;
        object2 += n10;
        n10 = nArray[1];
        byte[] byArray = this.o1098;
        Object object4 = nArray[2];
        n9 = byArray[object4] << 3;
        n10 += n9;
        n9 = 0;
        byArray = null;
        object4 = nArray[2];
        switch (object4) {
            case 0: {
                n9 = 0;
                byArray = null;
                break;
            }
            case 4: {
                n9 = 1;
                break;
            }
            case 1: {
                n9 = 2;
                break;
            }
        }
        Object object5 = this.j1139[n9];
        int n11 = nArray[5];
        object4 = object5[n11][0];
        object2 += object4;
        object5 = this.j1139[n9];
        n11 = nArray[3];
        int n12 = 5;
        n11 = n11 > n12 ? 5 : nArray[3];
        n11 = (n11 >> 1) + 4;
        object5 = object5[n11];
        n11 = 0;
        object4 = object5[0];
        int n13 = object2 + object4;
        object = this.j1139[n9];
        object4 = nArray[5];
        object = object[object4];
        object2 = object[1] + n10;
        object3 = this.j1139[n9];
        n9 = nArray[3];
        object4 = 5;
        n9 = n9 > object4 ? 5 : nArray[3];
        n9 = (n9 >> 1) + 4;
        object3 = object3[n9];
        n9 = 1;
        n10 = object3[n9];
        int n14 = object2 + n10 + 13;
        object2 = nArray[5];
        switch (object2) {
            case 0: {
                object2 = n13 + n2;
                n10 = this.bP;
                n9 = object2 - n10;
                object2 = n14 - n3;
                n10 = this.bQ;
                object4 = object2 - n10;
                n12 = 0;
                n8 = 15;
                n7 = 2;
                object = this;
                object3 = image;
                n11 = n4;
                n6 = n5;
                this.a(image, n9, (int)object4, n4, 0, n5, n8, n7, 0);
                break;
            }
            case 1: {
                object2 = n13 + n3;
                n10 = this.bP;
                n9 = object2 - n10;
                object2 = n14 + n2;
                n10 = this.bQ;
                object4 = object2 - n10;
                n11 = 0;
                n6 = 15;
                n7 = 4;
                object = this;
                object3 = image;
                n12 = n4;
                n8 = n5;
                this.a(image, n9, (int)object4, 0, n4, n6, n5, n7, 0);
                break;
            }
            case 2: {
                object2 = n13 + n2;
                n10 = this.bP;
                n9 = object2 - n10;
                object2 = n14 + n3;
                n10 = this.bQ;
                object4 = object2 - n10;
                n12 = 0;
                n8 = 15;
                n7 = 0;
                object = this;
                object3 = image;
                n11 = n4;
                n6 = n5;
                this.a(image, n9, (int)object4, n4, 0, n5, n8, 0, 0);
                break;
            }
            case 3: {
                object2 = n13 - n3;
                n10 = this.bP;
                n9 = object2 - n10;
                object2 = n14 + n2;
                n10 = this.bQ;
                object4 = object2 - n10;
                n11 = 0;
                n6 = 15;
                n7 = 5;
                object = this;
                object3 = image;
                n12 = n4;
                n8 = n5;
                this.a(image, n9, (int)object4, 0, n4, n6, n5, n7, 0);
                break;
            }
        }
        object2 = nArray[2];
        switch (object2) {
            case 0: 
            case 4: {
                object2 = 0;
                object = null;
                Object object6 = 0;
                while (object6 < (object2 = 5)) {
                    object2 = nArray[11] * object6 + n13;
                    n10 = this.bP;
                    n9 = object2 - n10;
                    object2 = nArray[12] * object6 + n14;
                    n10 = this.bQ;
                    object4 = object2 - n10;
                    n11 = this.C1134[n][object6] * 9;
                    n12 = 0;
                    n6 = 9;
                    n8 = 9;
                    n7 = 0;
                    object = this;
                    object3 = image2;
                    this.a(image2, n9, (int)object4, n11, 0, n6, n8, 0, 0);
                    object6 = object2 = object6 + 1;
                }
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Image image, Image image2, Image image3, int n, int n2, int n3, int n4) {
        int n5 = this.M1147[n3][0] + n;
        int n6 = this.bP;
        int n7 = n5 - n6;
        byte[] byArray = this.M1147[n3];
        n5 = byArray[1] + n2;
        n6 = this.bQ;
        int n8 = n5 - n6 + 13;
        n5 = 3;
        if (n4 >= n5) return;
        switch (n3) {
            case 0: {
                int n9 = n4 * 14;
                int n10 = 14;
                int n11 = 33;
                boolean bl = false;
                a a2 = this;
                this.a(image, n7, n8, n9, 0, n10, n11, 0, 0);
                return;
            }
            case 2: {
                int n12 = n4 * 13;
                int n13 = 13;
                int n14 = 52;
                boolean bl = false;
                a a3 = this;
                this.a(image2, n7, n8, n12, 0, n13, n14, 0, 0);
                return;
            }
            case 3: {
                int n15 = n4 * 50;
                int n16 = 50;
                int n17 = 12;
                boolean bl = false;
                a a4 = this;
                this.a(image3, n7, n8, n15, 0, n16, n17, 0, 0);
                return;
            }
            case 1: {
                n5 = 2 - n4;
                int n18 = n5 * 50;
                int n19 = 50;
                int n20 = 12;
                int n21 = 1;
                a a5 = this;
                this.a(image3, n7, n8, n18, 0, n19, n20, n21, 0);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(boolean bl) {
        int n;
        int n2 = 4;
        int n3 = 320;
        int n4 = 10;
        int n5 = 2;
        this.e();
        Graphics graphics = this.a1002;
        graphics.setColor(13450878);
        int n6 = this.k + 120;
        int n7 = this.j;
        n7 = n3 - n7 >> 1;
        Image image = this.a1002;
        Graphics graphics2 = this.b1015[101];
        int n8 = this.k << 1;
        int n9 = 120 - n8 - n2;
        image.drawString((String)graphics2, n9, n7, 0);
        int n10 = this.l1031;
        if (n10 == 0) {
            image = this.a1002;
            graphics2 = this.b1015;
            n9 = this.l1031 ? 1 : 0;
            n9 = n9 != 0 ? 1 : n5;
            graphics2 = graphics2[n9 += 101];
            n6 -= n4;
            n8 = this.k;
            n9 = 38 - n8 >> 1;
            image.drawString((String)graphics2, n6 += n9, n7, 0);
        } else {
            int n11;
            image = this.a1002;
            n = 240;
            image.setClip(0, 0, n, n3);
            image = null;
            for (n10 = 0; n10 < (n = 5); n8 -= n11, ++n10) {
                this.a1002.setColor(16571546);
                graphics2 = this.a1002;
                n9 = n10 * 4 + n6;
                n8 = n7 + 10;
                n11 = n10 * 2;
                n11 = n10 * 2 + 3;
                graphics2.fillRect(n9, n8, n5, n11);
            }
            image = null;
            for (n10 = 0; n10 < (n = this.q / 20); n8 -= n11, ++n10) {
                this.a1002.setColor(15888524);
                graphics2 = this.a1002;
                n9 = n10 * 4 + n6;
                n8 = n7 + 10;
                n11 = n10 * 2;
                n11 = n10 * 2 + 3;
                graphics2.fillRect(n9, n8, n5, n11);
            }
        }
        if (bl) {
            n6 = 3;
            image = this.a1013[n2];
            n = 25;
            image = image[n];
            n10 = image.getWidth();
            n7 = 240 - n10 >> 1;
            this.c(n6, n7, 0);
        }
        n6 = this.k + 120 - n4;
        n7 = this.k + 120 - n4 + 32;
        n10 = this.j;
        n10 = n3 - n10 >> 1;
        n = this.j - 9 >> 1;
        this.d(n6, n7, n10 += n);
    }

    private void a(byte[] byArray) {
        int n;
        this.aH = n = this.aH + 1;
        int n2 = byArray.length;
        int n3 = 1;
        if (n > (n2 -= n3)) {
            n = 0;
            this.aH = 0;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private final void a(char[] cArray, int n, int n2, int n3, int n4, int n5, int n6, boolean bl) {
        int n7;
        void var15_44;
        int n8;
        int n9;
        int[] nArray;
        int n10;
        int n11;
        int[] nArray2;
        int n12;
        int n13;
        int n14;
        if (bl) {
            this.d = n;
            n14 = 0;
            Object var10_10 = null;
            n13 = 0;
            Object var12_22 = null;
        } else {
            int[] nArray3 = this.c1010;
            n14 = n13 = nArray3[n2];
        }
        int n15 = 0;
        Object var14_36 = null;
        int n16 = this.n;
        this.b1008 = n12 = n6 / n16;
        if (bl) {
            boolean bl2 = false;
            Object var17_49 = null;
        } else {
            int n17 = n2;
        }
        if (!bl) {
            nArray2 = this.c1010;
            n11 = this.a1007;
            int n18 = Math.min(this.a1007, n12) + n2;
            n11 = Math.min(n11, n18);
            n10 = Math.min(nArray2[n11], n);
            n11 = 0;
            nArray = null;
            while (true) {
                int[] nArray4;
                int[] nArray5 = this.e;
                int[] nArray6 = this.e;
                n9 = nArray6.length;
                n8 = 1;
                int n19 = nArray5[n9 -= n8];
                if (n11 >= n19 || n14 <= (n19 = (nArray4 = this.e)[n9 = n11 << 1])) break;
                Graphics graphics = this.a1002;
                nArray6 = this.e;
                n8 = (n11 << 1) + 1;
                n9 = nArray6[n8];
                graphics.setColor(n9);
                ++n11;
            }
            n9 = var15_44;
            n8 = n14;
            n7 = n10;
            n15 = n13;
            n13 = 0;
            Object var12_25 = null;
        } else {
            this.c1010[0] = 0;
            nArray2 = this.e;
            nArray = this.e;
            n11 = nArray.length - 1;
            boolean bl3 = false;
            Object var23_72 = null;
            nArray2[n11] = 0;
            n9 = var15_44;
            n8 = n14;
            n7 = n;
            n15 = n13;
            n13 = 0;
            Object var12_30 = null;
        }
        while (n8 < n7) {
            int n20;
            n14 = this.n;
            int n21 = n9 - n2;
            n11 = n4 + (n14 *= n21);
            n14 = cArray[n8];
            n21 = 10;
            if (n14 == n21) {
                if (n9 >= n2 && n9 < (n13 = n2 + n12) && n8 > n15) {
                    Graphics graphics = this.a1002;
                    n21 = n8 - n15;
                    n20 = 0;
                    Object var23_71 = null;
                    char[] cArray2 = cArray;
                    n10 = n3;
                    graphics.drawChars(cArray, n15, n21, n3, n11, 0);
                }
                n13 = n9 + 1;
                n14 = n8 + 1;
                if (bl) {
                    int[] nArray7 = this.c1010;
                    nArray7[n13] = n14;
                }
                Object var14_40 = null;
                n9 = n13;
                n8 = n14;
                n13 = 0;
                Object var12_29 = null;
                n15 = n14;
                continue;
            }
            n21 = 36;
            if (n14 == n21) {
                n14 = n8 + 1;
                Graphics graphics = this.a1002;
                int[] nArray8 = this.d1011;
                n10 = cArray[n14];
                n20 = 97;
                n21 = nArray8[n10 -= n20];
                graphics.setColor(n21);
                n15 = n14 + 1;
                if (bl) {
                    int[] nArray9 = this.e;
                    nArray2 = this.e;
                    n20 = this.e.length - 1;
                    n10 = nArray2[n20] << 1;
                    nArray9[n10] = n14;
                    int[] nArray10 = this.e;
                    nArray2 = this.e;
                    n20 = this.e.length - 1;
                    n10 = (nArray2[n20] << 1) + 1;
                    int[] nArray11 = this.d1011;
                    n8 = cArray[n14];
                    int n22 = 97;
                    nArray10[n10] = n20 = nArray11[n8 -= n22];
                    int[] nArray12 = this.e;
                    nArray2 = this.e;
                    n10 = nArray2.length - 1;
                    nArray12[n10] = n20 = nArray12[n10] + 1;
                    n8 = n14;
                } else {
                    n8 = n14;
                }
            } else {
                Font font = this.a;
                n14 = font.charWidth((char)n14);
                n13 += n14;
            }
            if (n13 > n5) {
                if (n9 >= n2 && n9 < (n13 = n2 + n12)) {
                    Graphics graphics = this.a1002;
                    n21 = n8 - n15;
                    n20 = 0;
                    Object var23_74 = null;
                    char[] cArray3 = cArray;
                    n10 = n3;
                    graphics.drawChars(cArray, n15, n21, n3, n11, 0);
                }
                n13 = n9 + 1;
                if (bl) {
                    int[] nArray13 = this.c1010;
                    nArray13[n13] = n8;
                }
                n14 = 0;
                Object var10_17 = null;
                n9 = n13;
                n15 = n8;
                n13 = 0;
                Object var12_33 = null;
                continue;
            }
            n8 = n14 = n8 + 1;
        }
        if (n8 > n15) {
            if (n9 >= n2 && n9 < (n13 = n2 + n12)) {
                Graphics graphics = this.a1002;
                int n23 = n8 - n15;
                n14 = this.n;
                n10 = n9 - n2;
                n11 = n4 + (n14 *= n10);
                boolean bl4 = false;
                Object var23_75 = null;
                char[] cArray4 = cArray;
                n10 = n3;
                graphics.drawChars(cArray, n15, n23, n3, n11, 0);
            }
            n13 = n9 + 1;
            if (bl) {
                int[] nArray14 = this.c1010;
                nArray14[n13] = n8;
            }
        } else {
            n13 = n9;
        }
        if (bl) {
            this.a1007 = n13;
        }
    }

    private static void a(int[] nArray, int[][] nArray2, int n, int n2) {
        int n3;
        int[] nArray3;
        int n4;
        for (n4 = 0; n4 < n; ++n4) {
            nArray3 = nArray2[n4];
            nArray[n4] = n3 = (nArray3[n2] << 8) + n4;
        }
        block1: for (n4 = 0; n4 < n; ++n4) {
            n3 = 0;
            nArray3 = null;
            while (true) {
                int n5 = n - n4;
                int n6 = 1;
                if (n3 >= (n5 -= n6)) continue block1;
                n5 = nArray[n3];
                n6 = n3 + 1;
                if (n5 >= (n6 = nArray[n6])) {
                    n5 = nArray[n3];
                    n6 = n3 + 1;
                    nArray[n3] = n6 = nArray[n6];
                    n6 = n3 + 1;
                    nArray[n6] = n5;
                }
                ++n3;
            }
        }
        for (n4 = 0; n4 < n; ++n4) {
            nArray[n4] = n3 = nArray[n4] & 0xFF;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean a() {
        int n;
        int n2;
        boolean[] blArray;
        int n3;
        int n4 = 11;
        boolean bl = true;
        boolean bl2 = false;
        RecordStore recordStore = null;
        Object object = "sanGuoTd";
        ByteArrayInputStream byteArrayInputStream = null;
        recordStore = RecordStore.openRecordStore((String)object, (boolean)false);
        int n5 = 1;
        object = recordStore.getRecord(n5);
        byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        object = new DataInputStream(byteArrayInputStream);
        int n6 = ((DataInputStream)object).readInt();
        this.aP = n6;
        n6 = 0;
        while (true) {
            n3 = this.aP;
            if (n6 >= n3) break;
            blArray = null;
            for (n3 = 0; n3 < (n2 = 28); ++n3) {
                int[][] nArray = this.b1066;
                int[] nArray2 = nArray[n6];
                n = ((DataInputStream)object).readInt();
                nArray2[n3] = n;
                continue;
            }
            ++n6;
        }
        n6 = ((DataInputStream)object).readInt();
        this.bt = n6;
        n6 = 0;
        while (true) {
            n3 = this.bt;
            if (n6 >= n3) break;
            blArray = null;
            for (n3 = 0; n3 < (n2 = 18); ++n3) {
                int[][] nArray = this.c1107;
                int[] nArray3 = nArray[n6];
                n = ((DataInputStream)object).readInt();
                nArray3[n3] = n;
                continue;
            }
            ++n6;
        }
        for (n6 = 0; n6 < (n3 = 5); ++n6) {
            blArray = this.a1056;
            n2 = ((DataInputStream)object).readBoolean() ? 1 : 0;
            blArray[n6] = n2;
            continue;
        }
        for (n6 = 0; n6 < (n3 = 10); ++n6) {
            blArray = this.b1059;
            n2 = ((DataInputStream)object).readBoolean() ? 1 : 0;
            blArray[n6] = n2;
            continue;
        }
        for (n6 = 0; n6 < n4; ++n6) {
            blArray = this.e1105;
            n2 = ((DataInputStream)object).readBoolean() ? 1 : 0;
            blArray[n6] = n2;
            continue;
        }
        for (n6 = 0; n6 < n4; ++n6) {
            blArray = this.f1106;
            n2 = ((DataInputStream)object).readBoolean() ? 1 : 0;
            blArray[n6] = n2;
            continue;
        }
        try {
            n6 = ((DataInputStream)object).readInt();
        }
        catch (Exception exception) {
            if (recordStore == null) return false;
            try {
                recordStore.closeRecordStore();
            }
            catch (Exception exception2) {
                return false;
            }
            return false;
        }
        this.aq = n6;
        n6 = ((DataInputStream)object).readInt();
        this.bj = n6;
        n6 = ((DataInputStream)object).readInt();
        this.bN = n6;
        n6 = ((DataInputStream)object).readInt();
        this.bO = n6;
        n6 = ((DataInputStream)object).readInt();
        this.bP = n6;
        n6 = ((DataInputStream)object).readInt();
        this.bQ = n6;
        n6 = ((DataInputStream)object).readInt();
        this.T = n6;
        n6 = ((DataInputStream)object).readInt();
        this.aO = n6;
        n6 = ((DataInputStream)object).readInt();
        this.aS = n6;
        n6 = ((DataInputStream)object).readInt();
        this.X = n6;
        n6 = ((DataInputStream)object).readInt();
        this.bz = n6;
        n6 = ((DataInputStream)object).readInt();
        this.by = n6;
        n6 = ((DataInputStream)object).readInt();
        this.aT = n6;
        n6 = ((DataInputStream)object).readInt();
        this.aQ = n6;
        n6 = ((DataInputStream)object).readInt();
        this.ay = n6;
        n6 = ((DataInputStream)object).readInt();
        this.az = n6;
        n6 = ((DataInputStream)object).readBoolean() ? 1 : 0;
        this.p1078 = n6;
        n6 = ((DataInputStream)object).readInt();
        this.bL = n6;
        n6 = ((DataInputStream)object).readInt();
        this.bM = n6;
        n6 = ((DataInputStream)object).readInt();
        this.ac = n6;
        n6 = ((DataInputStream)object).readInt();
        this.aV = n6;
        n6 = ((DataInputStream)object).readInt();
        this.aW = n6;
        n6 = ((DataInputStream)object).readInt();
        this.aX = n6;
        n6 = ((DataInputStream)object).readInt();
        this.aY = n6;
        n6 = ((DataInputStream)object).readInt();
        this.aZ = n6;
        n6 = ((DataInputStream)object).readInt();
        this.ba = n6;
        n6 = ((DataInputStream)object).readInt();
        this.bb = n6;
        n6 = ((DataInputStream)object).readBoolean() ? 1 : 0;
        this.z1169 = n6;
        ((FilterInputStream)object).close();
        byteArrayInputStream.close();
        recordStore.closeRecordStore();
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(int n) {
        int n2 = n & 1;
        if (n2 != 0) return 1 != 0;
        return 0 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(int n, int n2) {
        int n3;
        int n4 = 16;
        int n5 = 1;
        int n6 = -1;
        byte[] byArray = this.E1163;
        int n7 = this.a(n, n2);
        int n8 = Math.abs(byArray[n7]);
        if (n8 >= (n3 = 12)) {
            this.ay = n7 = this.d(n7);
            if ((n7 = this.ay) == n6) {
                return 0 != 0;
            }
            this.az = n6;
            return n5 != 0;
        }
        byte[] byArray2 = this.E1163;
        n8 = 8;
        if ((n7 = byArray2[n7]) < n8) {
            int n9 = 0;
            while (n9 < (n7 = this.aP)) {
                int[] nArray = this.b1066[n9];
                n7 = nArray[0];
                int[] nArray2 = this.b1066[n9];
                n8 = nArray2[n5];
                n3 = this.bN;
                int n10 = this.bO;
                if ((n7 = (int)(a.a(n7, n8, n3, n10, n4, n4) ? 1 : 0)) != 0) {
                    this.az = n9;
                    return n5 != 0;
                }
                n9 = n7 = n9 + 1;
            }
            this.ay = n6;
            this.az = n6;
            return 0 != 0;
        }
        this.ay = n6;
        this.az = n6;
        return 0 != 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean a(int n, int n2, int n3) {
        int n4;
        int n5 = 1;
        int[] nArray = this.m1129;
        nArray[n3] = n4 = -1;
        int n6 = this.x1126;
        if (n6 == 0) {
            return 0 != 0;
        }
        n6 = 0;
        nArray = null;
        while (true) {
            int n7;
            byte[] byArray;
            if (n6 >= (n4 = (byArray = this.o1098)[n7 = this.bw])) {
                nArray = this.m1129;
                nArray[n3] = n3;
                return n5 != 0;
            }
            byArray = this.x1128[n3];
            n4 = byArray[0];
            if (n4 == n5) {
                n4 = n6 << 4;
            } else {
                byArray = this.x1128[n3];
                n4 = byArray[0];
                if (n4 < 0) {
                    byArray = this.x1128[n3];
                    n4 = byArray[0];
                } else {
                    byArray = this.o1098;
                    n7 = this.bw;
                    n4 = byArray[n7] << 4;
                }
            }
            n4 += n;
            byte[] byArray2 = this.x1128[n3];
            n7 = byArray2[n5];
            if (n7 == n5) {
                n7 = n6 << 4;
            } else {
                byArray2 = this.x1128[n3];
                n7 = byArray2[n5];
                if (n7 < 0) {
                    byArray2 = this.x1128[n3];
                    n7 = byArray2[n5];
                } else {
                    byArray2 = this.o1098;
                    int n8 = this.bw;
                    n7 = (byArray2[n8] << 4) + 16;
                }
            }
            if ((n4 = (int)(this.h(n4, n7 += n2) ? 1 : 0)) == 0) {
                return 0 != 0;
            }
            ++n6;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(int n, int n2, int n3, int n4, int n5) {
        int n6;
        int n7 = a.b(n, n2, n3, n4);
        if (n7 >= (n6 = n5 * n5)) return 0 != 0;
        return 1 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n < n3) return 0 != 0;
        int n7 = n3 + n5;
        if (n > n7) return 0 != 0;
        if (n2 < n4) return 0 != 0;
        n7 = n4 + n6;
        if (n2 > n7) return 0 != 0;
        return 1 != 0;
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(int var1_1, int var2_2, int var3_3, boolean var4_4) {
        block8: {
            block7: {
                var5_5 = 3;
                var6_6 = 3;
                var7_7 = 4.2E-45f;
                var8_8 = 0;
                var9_9 = 0;
                if (!var4_4) ** GOTO lbl-1000
                block0 : switch (var3_3) {
                    default: lbl-1000:
                    // 2 sources

                    {
                        var10_10 = 0;
                        var11_11 = 0.0f;
                        var9_9 = var5_5;
                        var5_5 = 0;
                        var12_12 = var6_6;
                        var6_6 = 0;
                        var7_7 = 0.0f;
                        var8_8 = var12_12;
lbl17:
                        // 4 sources

                        while (var6_6 < var9_9) {
                            var13_13 = var5_5;
lbl19:
                            // 2 sources

                            while (var13_13 < var8_8) {
                                var14_14 = var6_6 << 4;
                                var15_15 = this.m1084[var3_3][0];
                                var14_14 = var14_14 * var15_15 + var1_1;
                                var16_16 = this.m1084[var3_3];
                                var15_15 = var16_16[2];
                                var14_14 += var15_15;
                                var15_15 = var13_13 << 4;
                                var17_17 = this.m1084[var3_3][1];
                                var15_15 = var15_15 * var17_17 + var2_2;
                                var18_18 = this.m1084[var3_3];
                                var19_19 = 3;
                                var17_17 = var18_18[var19_19];
                                if ((var14_14 = (int)this.d(var14_14, var15_15 += var17_17)) != 0) break block0;
                                var5_5 = 1;
lbl34:
                                // 2 sources

                                return (boolean)var5_5;
                            }
                            break block7;
                        }
                        break block8;
                    }
                    case 0: 
                    case 2: {
                        var10_10 = 0;
                        var11_11 = 0.0f;
                        var9_9 = 2;
                        var8_8 = var6_6;
                        var6_6 = 1;
                        var7_7 = 1.4E-45f;
                        var5_5 = 0;
                        ** GOTO lbl17
                    }
                    case 1: 
                    case 3: {
                        var10_10 = 1;
                        var11_11 = 1.4E-45f;
                        var6_6 = 0;
                        var7_7 = 0.0f;
                        var8_8 = 2;
                        var9_9 = var5_5;
                        var5_5 = var10_10;
                        ** GOTO lbl17
                    }
                }
                ++var13_13;
                ** GOTO lbl19
            }
            ++var6_6;
            ** GOTO lbl17
        }
        var5_5 = 0;
        ** while (true)
    }

    /*
     * Enabled aggressive block sorting
     */
    private void aa() {
        int n = 240;
        int n2 = 8;
        int n3 = 1;
        int n4 = this.br;
        switch (n4) {
            case 0: {
                int n5;
                int n6;
                short[][] sArray = this.b1069;
                int n7 = this.aN;
                this.bN = n6 = sArray[n7][0] - n2;
                short[][] sArray2 = this.b1069;
                n7 = this.aN;
                short[] sArray3 = sArray2[n7];
                this.bO = n5 = sArray3[n3] - n2;
                this.y1155 = n3;
                this.br = n3;
                return;
            }
            case 1: {
                int n8;
                int n9;
                int n10;
                this.bn = n10 = this.bn - 32;
                int n11 = this.bl;
                if (n10 < n11) {
                    int n12;
                    int n13;
                    this.bn = n13 = this.bl;
                    int n14 = this.bl << 1;
                    this.bp = n12 = n - n14;
                } else {
                    int n15;
                    this.bp = n15 = this.bp + 64;
                }
                this.bo = n9 = this.bo - 4;
                n11 = this.bm;
                if (n9 < n11) {
                    int n16;
                    int n17;
                    this.bo = n17 = this.bm;
                    this.bq = n16 = this.bk;
                } else {
                    int n18;
                    this.bq = n18 = this.bq + 8;
                }
                int n19 = this.bp;
                n11 = this.bl << 1;
                if (n19 != (n11 = n - n11)) return;
                int n20 = this.bq;
                n11 = this.bk;
                if (n20 != n11) return;
                this.br = n8 = 2;
                return;
            }
            case 2: {
                int n21 = this.h1047;
                switch (n21) {
                    default: {
                        return;
                    }
                    case -6: 
                    case -5: 
                    case 53: 
                }
                this.a();
                return;
            }
        }
    }

    private void ab() {
        int n;
        this.br = 0;
        this.bk = n = this.j * 2 + 10;
        this.bl = 4;
        int n2 = this.bk;
        this.bm = n = 280 - n2;
        this.bn = 120;
        n = this.bm;
        n2 = this.bk >> 1;
        this.bo = n += n2;
        this.bp = 0;
        this.bq = 0;
        this.a(22);
    }

    private void ac() {
        int n = 240;
        int n2 = 2;
        this.a1002.setClip(0, 0, n, 320);
        this.a1002.setColor(0xFCFFCD);
        Object object = this.a1002;
        int n3 = this.bn;
        int n4 = this.bo;
        int n5 = this.bp;
        int n6 = this.bq;
        object.fillRect(n3, n4, n5, n6);
        object = this.a1002;
        n3 = this.bn - 1;
        n4 = this.bo + 1;
        n5 = this.bp + 2;
        n6 = this.bq - n2;
        object.fillRect(n3, n4, n5, n6);
        int n7 = this.br;
        if (n7 == n2) {
            object = this.a1002;
            n3 = this.bl + 15;
            n4 = this.bm;
            n5 = this.bk;
            n4 += n5;
            n5 = this.bl + 15 + 8;
            n6 = this.bm;
            n2 = this.bk;
            n6 += n2;
            n2 = this.bl + 15 + 8;
            int n8 = this.bm;
            int n9 = this.bk;
            n8 = n8 + n9 + 8;
            object.fillTriangle(n3, n4, n5, n6, n2, n8);
            object = this.a1002;
            n3 = 5465994;
            object.setColor(n3);
            object = new StringBuffer();
            Object object2 = this.b1015;
            n4 = this.X * 11 + 28;
            object2 = object2[n4];
            object = ((StringBuffer)object).append((String)object2).append("\uff1a");
            object2 = this.b1015;
            n4 = this.bs + 171;
            object2 = object2[n4];
            object2 = ((StringBuffer)object).append((String)object2).toString();
            n5 = this.bl + 10;
            n6 = this.bm + 5;
            n7 = (this.bl + 10) * 2;
            n2 = n - n7;
            n8 = this.bk;
            object = this;
            n4 = 0;
            this.a((String)object2, 0, n5, n6, n2, n8);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void ad() {
        int n = 240;
        int n2 = this.br;
        switch (n2) {
            case 1: {
                this.bn = n2 = this.bn - 32;
                int n3 = this.bl;
                if (n2 < n3) {
                    this.bn = n2 = this.bl;
                    n2 = this.bl << 1;
                    this.bp = n2 = n - n2;
                } else {
                    this.bp = n2 = this.bp + 64;
                }
                this.bo = n2 = this.bo - 4;
                n3 = this.bm;
                if (n2 < n3) {
                    this.bo = n2 = this.bm;
                    this.bq = n2 = this.bk;
                } else {
                    this.bq = n2 = this.bq + 8;
                }
                n2 = this.bp;
                n3 = this.bl << 1;
                if (n2 != (n3 = n - n3)) return;
                n2 = this.bq;
                n3 = this.bk;
                if (n2 != n3) return;
                this.br = n2 = 2;
            }
            default: {
                return;
            }
            case 2: 
        }
        n2 = this.h1047;
        switch (n2) {
            default: {
                return;
            }
            case -6: 
            case -5: 
            case 53: 
        }
        n2 = this.bs + 1;
        this.bs = n2;
        n2 = this.bs;
        int n4 = 3;
        if (n2 <= n4) return;
        n2 = 0;
        this.v1097 = false;
        this.a();
    }

    private void ae() {
        int n;
        this.br = 1;
        this.bk = n = this.j * 3 + 10;
        this.bl = 4;
        int n2 = this.bk;
        this.bm = n = 280 - n2;
        this.bn = 120;
        n = this.bm;
        n2 = this.bk;
        this.bo = n = n + n2 >> 1;
        this.bp = 0;
        this.bq = 0;
        this.bs = 0;
        this.a(23);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void af() {
        block4: {
            block3: {
                int n = this.w1111;
                if (n == 0) break block3;
                n = this.bu;
                Image image = this.a1013[3];
                int n2 = 20;
                int n3 = (image = image[n2]).getWidth() / 27;
                if (n >= n3) break block4;
                this.bu = n = this.bu + 1;
            }
            return;
        }
        this.bu = 0;
        this.w1111 = false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void ag() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        Object object;
        Object object2;
        Object object3 = this.p1154;
        Object object4 = this.c1107;
        int n6 = this.bt;
        int n7 = 1;
        a.a(object3, object4, n6, n7);
        int n8 = 0;
        object3 = null;
        int n9 = 0;
        while (n9 < (n8 = this.bt)) {
            object3 = this.c1107;
            object4 = this.p1154;
            object2 = object4[n9];
            object = object3[object2];
            object3 = null;
            n8 = object[0];
            object2 = this.bP;
            n8 -= object2;
            object2 = object[1];
            n6 = this.bQ;
            n7 = -48;
            n5 = 336;
            n4 = 320;
            if ((n8 = (int)(a.a(n8, (int)(object2 = (Object)(object2 - n6)), n6 = -48, n7, n5, n4) ? 1 : 0)) != 0) {
                object3 = this.o1098;
                object2 = object[2];
                n3 = object3[object2] << 3;
                n8 = object[2];
                object2 = 10;
                if (n8 == object2 && (n8 = object[5]) == 0) {
                    object2 = object[5];
                    n6 = object[0];
                    n7 = object[1];
                    n5 = object[15];
                    n4 = object[13];
                    n8 = 10;
                    n2 = object[n8];
                    object3 = this;
                    this.c((int)object2, n6, n7, n5, n4, n2);
                }
                if ((n8 = object[4]) != (object2 = (Object)5)) {
                    object2 = object[2];
                    n6 = object[3];
                    n8 = object[0] + n3;
                    n7 = this.bP;
                    n7 = n8 - n7;
                    n8 = object[1] + n3;
                    n5 = this.bQ;
                    n5 = n8 - n5;
                    n4 = object[7];
                    n2 = object[5];
                    n = object[4];
                    object3 = this;
                    this.a((int)object2, n6, n7, n5, n4, n2, n);
                    n8 = object[17];
                    object2 = true;
                    if (n8 == object2) {
                        object3 = null;
                        n8 = object[0] + n3 - 10;
                        object2 = this.bP;
                        n8 -= object2;
                        object2 = object[1];
                        n6 = this.bQ;
                        object2 = object2 - n6 + 13;
                        this.o(n8, (int)object2);
                    }
                    if ((n8 = (int)(a.g((int)object[3]) ? 1 : 0)) != 0) {
                        long l;
                        long l2 = this.a1019;
                        n8 = (int)l2 & 0x1F;
                        object2 = 4;
                        if (n8 < object2) {
                            this.a1002.setClip(0, 0, 240, 320);
                            this.a1002.setColor(0xFFFFFF);
                            object3 = this.a1002;
                            object2 = object[0] + n3;
                            n6 = this.bP;
                            object2 = object2 - n6;
                            n6 = object[1] + n3;
                            n7 = ((int)this.a1019 & 0x1F) << 2;
                            n6 -= n7;
                            n7 = this.bQ;
                            n6 -= n7;
                            n7 = ((int)this.a1019 & 0x1F) << 2;
                            n5 = ((int)this.a1019 & 0x1F) << 2;
                            object3.fillArc((int)object2, n6, n7, n5, 0, 360);
                            this.a1002.setColor(16761600);
                            object3 = this.a1002;
                            object4 = null;
                            object2 = object[0] + n3;
                            n6 = this.bP;
                            object2 = object2 - n6;
                            n6 = object[1] + n3;
                            n7 = ((int)this.a1019 & 0x1F) << 2;
                            n6 -= n7;
                            n7 = this.bQ;
                            n6 -= n7;
                            long l3 = this.a1019;
                            n7 = ((int)l3 & 0x1F) << 2;
                            l = this.a1019;
                            n5 = ((int)l & 0x1F) << 2;
                            n4 = 0;
                            n2 = 360;
                            object3.drawArc((int)object2, n6, n7, n5, 0, n2);
                        } else {
                            l2 = this.a1019;
                            n8 = (int)l2 & 0x1F;
                            object2 = 27;
                            if (n8 > object2 && (n8 = (int)(l2 = this.a1019) & 0x1F) < (object2 = (Object)32)) {
                                this.a1002.setClip(0, 0, 240, 320);
                                this.a1002.setColor(0xFFFFFF);
                                object3 = this.a1002;
                                object2 = object[0] + n3;
                                n6 = this.bP;
                                object2 = object2 - n6;
                                n6 = object[1] + n3;
                                n5 = (int)this.a1019 & 0x1F;
                                n7 = 31 - n5 << 2;
                                n6 -= n7;
                                n7 = this.bQ;
                                n6 -= n7;
                                n5 = (int)this.a1019 & 0x1F;
                                n7 = 31 - n5 << 2;
                                n4 = (int)this.a1019 & 0x1F;
                                n5 = 31 - n4 << 2;
                                object3.fillArc((int)object2, n6, n7, n5, 0, 360);
                                this.a1002.setColor(16761600);
                                object3 = this.a1002;
                                object4 = null;
                                object2 = object[0] + n3;
                                n6 = this.bP;
                                object2 = object2 - n6;
                                n6 = object[1] + n3;
                                n5 = (int)this.a1019 & 0x1F;
                                n7 = 31 - n5 << 2;
                                n6 -= n7;
                                n7 = this.bQ;
                                n6 -= n7;
                                l = this.a1019;
                                n5 = (int)l & 0x1F;
                                n7 = 31 - n5 << 2;
                                long l4 = this.a1019;
                                n4 = (int)l4 & 0x1F;
                                n5 = 31 - n4 << 2;
                                n4 = 0;
                                n2 = 360;
                                object3.drawArc((int)object2, n6, n7, n5, 0, n2);
                            } else {
                                object3 = this.y1130;
                                object2 = this.X;
                                object3 = object3[object2];
                                object2 = object[2];
                                n8 = object3[object2];
                                object4 = null;
                                object2 = object[0] + n3;
                                n6 = this.bP;
                                object2 = object2 - n6;
                                n6 = object[1] + n3 - 16;
                                n7 = this.bQ;
                                this.q(n8, (int)object2, n6 -= n7);
                            }
                        }
                    }
                }
                n8 = object[4];
                switch (n8) {
                    case 3: 
                    case 4: 
                    case 5: {
                        n8 = object[2];
                        object2 = object[4];
                        n6 = object[0];
                        n7 = object[1];
                        this.d(n8, (int)object2, n6, n7);
                        break;
                    }
                }
                n8 = object[2];
                object2 = 10;
                if (n8 == object2 && (n8 = object[5]) != 0) {
                    object2 = object[5];
                    n6 = object[0];
                    n7 = object[1];
                    n5 = object[15];
                    n4 = object[13];
                    n8 = 10;
                    n2 = object[n8];
                    object3 = this;
                    this.c((int)object2, n6, n7, n5, n4, n2);
                }
            }
            n9 = n8 = n9 + 1;
        }
        n8 = 0;
        object3 = null;
        n3 = 0;
        while (n3 < (n8 = this.bt)) {
            object3 = this.c1107;
            object4 = this.p1154;
            object2 = object4[n3];
            int n10 = object3[object2];
            object3 = this.o1098;
            object2 = n10[2];
            n = object3[object2] << 3;
            object3 = null;
            n8 = n10[0];
            object2 = this.bP;
            n8 -= object2;
            object2 = n10[1];
            n6 = this.bQ;
            n7 = -48;
            n5 = 336;
            n4 = 320;
            if ((n8 = (int)(a.a(n8, (int)(object2 = (Object)(object2 - n6)), n6 = -48, n7, n5, n4) ? 1 : 0)) != 0) {
                n8 = n10[4];
                object2 = true;
                if (n8 == object2 && (n8 = n10[10]) != (object2 = (Object)3)) {
                    object3 = this.p1154;
                    n8 = object3[n3];
                    this.y(n8);
                }
                if ((n8 = n10[4]) == (object2 = (Object)6) && (n8 = n10[14]) != (object2 = (Object)10)) {
                    n8 = n10[2];
                    switch (n8) {
                        case 0: 
                        case 4: {
                            object3 = this.a1013[29];
                            object2 = false;
                            object4 = object3[0];
                            n8 = n10[0];
                            n6 = this.bP;
                            n6 = n8 - n6 + n - 10;
                            n8 = n10[1] + n;
                            n7 = this.bQ;
                            n7 = n8 - n7 - 20;
                            n8 = n10[14];
                            n5 = n8 * 18;
                            n4 = 0;
                            n2 = 18;
                            n = 24;
                            n9 = 0;
                            object = null;
                            object3 = this;
                            this.a((Image)object4, n6, n7, n5, 0, n2, n, 0, 0);
                            break;
                        }
                    }
                }
            }
            n3 = n8 = n3 + 1;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void ah() {
        int n = 1;
        int n2 = 6;
        int n3 = 4;
        int n4 = 2;
        int n5 = 0;
        while (true) {
            int n6;
            if (n5 >= (n6 = this.bt)) {
                this.af();
                return;
            }
            int[] nArray = this.c1107[n5];
            int n7 = nArray[7];
            int n8 = nArray[n4];
            nArray[7] = n7 = this.c(n5, n7, n8);
            int n9 = nArray[n4];
            n7 = nArray[3];
            if ((n9 = (int)(this.q(n9, n7) ? 1 : 0)) != 0) {
                n9 = nArray[0];
                byte[] byArray = this.o1098;
                n8 = nArray[n4];
                n7 = byArray[n8] << 3;
                n9 += n7;
                n7 = nArray[n];
                byte[] byArray2 = this.o1098;
                int n10 = nArray[n4];
                n8 = byArray2[n10] << 3;
                this.n(n9, n7 += n8);
            }
            n9 = nArray[n3];
            switch (n9) {
                case 6: {
                    this.e(n5);
                    break;
                }
                case 0: {
                    n9 = this.aP;
                    if (n9 <= 0 && ((n9 = nArray[n4]) == 0 || (n9 = nArray[n4]) == n3)) {
                        nArray[n3] = n2;
                        n9 = 14;
                        nArray[n9] = n7 = -1;
                    }
                    this.e(n5);
                    break;
                }
                case 1: {
                    n9 = 8;
                    n6 = nArray[n9];
                    this.l(n5, n6);
                    break;
                }
                case 2: {
                    nArray[n2] = n9 = nArray[n2] - n;
                    if (n9 >= 0) break;
                    nArray[n2] = 0;
                    nArray[n3] = 0;
                    break;
                }
                case 3: 
                case 4: 
                case 5: {
                    n6 = nArray[n3];
                    this.j(n5, n6);
                    break;
                }
            }
            ++n5;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void ai() {
        int n = 0;
        Object object = null;
        int n2 = 0;
        while (n2 < (n = this.bt)) {
            object = this.c1107;
            int[] nArray = this.p1154;
            int n3 = nArray[n2];
            int[] nArray2 = object[n3];
            object = null;
            n = nArray2[0];
            n3 = this.bP;
            n -= n3;
            n3 = nArray2[1];
            int n4 = this.bQ;
            int n5 = -48;
            int n6 = 336;
            int n7 = 320;
            if ((n = (int)(a.a(n, n3 -= n4, n4 = -48, n5, n6, n7) ? 1 : 0)) != 0 && (n = nArray2[4]) == (n3 = 1) && (n = nArray2[10]) != (n3 = 3)) {
                n = nArray2[2];
                switch (n) {
                    case 8: {
                        object = this.a1013[29];
                        n3 = 31;
                        nArray = object[n3];
                        n4 = nArray2[5];
                        n5 = nArray2[0];
                        n6 = nArray2[1];
                        n7 = nArray2[13];
                        int n8 = nArray2[11];
                        int n9 = nArray2[10];
                        int n10 = nArray2[2];
                        n = 3;
                        int n11 = nArray2[n];
                        object = this;
                        this.b((Image)nArray, n4, n5, n6, n7, n8, n9, n10, n11);
                    }
                    default: {
                        break;
                    }
                    case 9: {
                        object = this.a1013[29];
                        n3 = 35;
                        nArray = object[n3];
                        n4 = nArray2[5];
                        n5 = nArray2[0];
                        n6 = nArray2[1];
                        n7 = nArray2[13];
                        int n8 = nArray2[11];
                        int n9 = nArray2[10];
                        int n10 = nArray2[2];
                        n = 3;
                        int n11 = nArray2[n];
                        object = this;
                        this.b((Image)nArray, n4, n5, n6, n7, n8, n9, n10, n11);
                    }
                }
            }
            object = null;
            n = nArray2[0];
            n3 = this.bP;
            n -= n3;
            n3 = nArray2[1];
            n4 = this.bQ;
            n5 = -102;
            n6 = 358;
            n7 = 438;
            if ((n = (int)(a.a(n, n3 -= n4, n4 = -96, n5, n6, n7) ? 1 : 0)) != 0) {
                n = nArray2[2];
                switch (n) {
                    case 2: {
                        object = this.a1013[29][40];
                        n3 = nArray2[5];
                        n4 = nArray2[0];
                        n5 = nArray2[1];
                        this.d((Image)object, n3, n4, n5);
                    }
                    default: {
                        break;
                    }
                    case 10: {
                        object = this.a1013[29][43];
                        n3 = nArray2[5];
                        n4 = nArray2[0];
                        n5 = nArray2[1];
                        this.e((Image)object, n3, n4, n5);
                    }
                }
            }
            n2 = n = n2 + 1;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void aj() {
        boolean bl;
        boolean[] blArray;
        boolean[] blArray2;
        int n = 11;
        int n2 = 10;
        boolean bl2 = true;
        int n3 = -1;
        int n4 = this.T;
        this.bz = n4 == 0 ? (n4 = 300) : (n4 = 250);
        this.z1169 = false;
        this.by = n2;
        this.aT = 0;
        this.aX = 0;
        this.aP = 0;
        this.aQ = 0;
        this.aS = 0;
        this.bt = 0;
        this.ay = n3;
        this.az = n3;
        this.p1078 = false;
        this.bF = 0;
        this.aw = 0;
        this.bu = 0;
        for (n4 = 0; n4 < (n3 = 5); ++n4) {
            blArray2 = this.a1056;
            blArray2[n4] = false;
        }
        for (n4 = 0; n4 < n2; ++n4) {
            blArray2 = this.b1059;
            blArray = this.c1061;
            bl = blArray[n4];
            if (!bl) {
                bl = false;
                blArray = null;
            } else {
                bl = bl2;
            }
            blArray2[n4] = bl;
        }
        for (n4 = 0; n4 < n; ++n4) {
            blArray2 = this.e1105;
            if (n4 == 0) {
                bl = bl2;
            } else {
                bl = false;
                blArray = null;
            }
            blArray2[n4] = bl;
            blArray2 = this.f1106;
            blArray2[n4] = false;
        }
        this.c(29);
        n4 = 0;
        while (n4 < n) {
            n3 = n4 + 18;
            this.c(n3);
            ++n4;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void ak() {
        Image image;
        int n;
        int n2;
        int n3 = 240;
        int n4 = 304;
        int n5 = 256;
        int n6 = 1;
        Image image2 = this.a1004;
        if (image2 == null) {
            return;
        }
        int n7 = this.y1155;
        if (n7 != 0) {
            this.y1155 = false;
            n7 = this.bQ >> 4;
            n2 = this.bP >> 4;
            this.bA = n = n2 << 4;
            this.bC = n = n7 << 4;
            for (n = n7; n < (n5 = n7 + 19); ++n) {
                this.w(n, n2, 0);
            }
        } else {
            n7 = this.bP;
            n2 = this.bA;
            if (n7 < n2) {
                n7 = this.bA;
                n2 = this.bP;
                n7 = n7 - n2 >> 4;
                n2 = this.bA;
                n = this.bP;
                if ((n2 = n2 - n & 0xF) == 0) {
                    n2 = 0;
                    image = null;
                } else {
                    n2 = n6;
                }
                n7 += n2;
                n2 = this.bB;
                n = n7 << 4;
                this.bB = n2 -= n;
                n2 = this.bA;
                n = n7 << 4;
                this.bA = n2 -= n;
                n2 = this.bB;
                if (n2 < 0) {
                    this.bB = n2 = this.bB + 256;
                }
                if ((n2 = this.bA) < 0) {
                    this.bA = 0;
                }
                image = null;
                for (n2 = 0; n2 < n7; ++n2) {
                    n = this.bC >> 4;
                    n5 = (this.bA >> 4) + n2;
                    this.w(n, n5, n6);
                }
            } else {
                n7 = this.bP + 240;
                n2 = this.bA + 256;
                if (n7 > n2) {
                    n7 = this.bP + 240;
                    n2 = this.bA;
                    n7 = n7 - n2 - n5;
                    n2 = n7 >> 4;
                    if ((n7 &= 0xF) == 0) {
                        n7 = 0;
                        image2 = null;
                    } else {
                        n7 = n6;
                    }
                    n7 += n2;
                    n2 = this.bA;
                    n = n7 << 4;
                    this.bA = n2 += n;
                    n2 = this.bB;
                    n = n7 << 4;
                    n2 += n;
                    this.bB = n2;
                    if ((n2 = this.bB) >= n5) {
                        this.bB = n2 = this.bB - n5;
                    }
                    if ((n2 = this.bA + 256) > (n = this.bI)) {
                        this.bA = n2 = this.bI - n5;
                    }
                    image = null;
                    for (n2 = 0; n2 < n7; ++n2) {
                        n = this.bC >> 4;
                        n5 = (this.bA >> 4) + 16 - n6 - n2;
                        this.w(n, n5, n6);
                    }
                }
            }
            if ((n7 = this.bQ) < (n2 = this.bC)) {
                n7 = this.bC;
                n2 = this.bQ;
                n7 = n7 - n2 >> 4;
                n2 = this.bC;
                n = this.bQ;
                if ((n2 = n2 - n & 0xF) == 0) {
                    n2 = 0;
                    image = null;
                } else {
                    n2 = n6;
                }
                n7 += n2;
                n2 = this.bD;
                n = n7 << 4;
                this.bD = n2 -= n;
                n2 = this.bC;
                n = n7 << 4;
                this.bC = n2 -= n;
                n2 = this.bD;
                if (n2 < 0) {
                    this.bD = n2 = this.bD + 304;
                }
                if ((n2 = this.bC) < 0) {
                    this.bC = 0;
                }
                image = null;
                for (n2 = 0; n2 < n7; ++n2) {
                    n = (this.bC >> 4) + n2;
                    n5 = this.bA >> 4;
                    this.w(n, n5, 0);
                }
            } else {
                n7 = this.bQ + 276;
                n2 = this.bC + 304;
                if (n7 > n2) {
                    n7 = this.bQ + 276;
                    n2 = this.bC;
                    n7 = n7 - n2 - n4;
                    n2 = n7 >> 4;
                    if ((n7 &= 0xF) == 0) {
                        n7 = 0;
                        image2 = null;
                    } else {
                        n7 = n6;
                    }
                    n7 += n2;
                    n2 = this.bC;
                    n = n7 << 4;
                    this.bC = n2 += n;
                    n2 = this.bD;
                    n = n7 << 4;
                    n2 += n;
                    this.bD = n2;
                    if ((n2 = this.bD) >= n4) {
                        this.bD = n2 = this.bD - n4;
                    }
                    if ((n2 = this.bC + 304) > (n = this.bJ)) {
                        this.bC = n2 = this.bJ - n4;
                    }
                    image = null;
                    for (n2 = 0; n2 < n7; ++n2) {
                        n = (this.bC >> 4) + 19 - n6 - n2;
                        n5 = this.bA >> 4;
                        this.w(n, n5, 0);
                    }
                }
            }
        }
        this.a1002.setClip(0, 0, n3, 320);
        image2 = this.a1002;
        image = this.a1004;
        n = this.bB;
        n = 0 - n;
        n5 = this.bA;
        n += n5;
        n5 = this.bP;
        n -= n5;
        n5 = this.bD;
        n5 = 0 - n5;
        n4 = this.bC;
        n5 += n4;
        n4 = this.bQ;
        n5 = n5 - n4 + 13;
        image2.drawImage(image, n, n5, 0);
        image2 = this.a1002;
        image = this.a1004;
        n = this.bB;
        n = 0 - n;
        n5 = this.bA;
        n += n5;
        n5 = this.bP;
        n -= n5;
        n5 = this.bD;
        n5 = 0 - n5;
        n4 = this.bC;
        n5 += n4;
        n4 = this.bQ;
        n5 = n5 - n4 + 304 + 13;
        image2.drawImage(image, n, n5, 0);
        image2 = this.a1002;
        image = this.a1004;
        n = this.bB;
        n = 0 - n;
        n5 = this.bA;
        n += n5;
        n5 = this.bP;
        n = n - n5 + 256;
        n5 = this.bD;
        n5 = 0 - n5;
        n4 = this.bC;
        n5 += n4;
        n4 = this.bQ;
        n5 = n5 - n4 + 13;
        image2.drawImage(image, n, n5, 0);
        image2 = this.a1002;
        image = this.a1004;
        n = this.bB;
        n = 0 - n;
        n5 = this.bA;
        n += n5;
        n5 = this.bP;
        n = n - n5 + 256;
        n5 = this.bD;
        n5 = 0 - n5;
        n4 = this.bC;
        n5 += n4;
        n4 = this.bQ;
        n5 = n5 - n4 + 304 + 13;
        image2.drawImage(image, n, n5, 0);
        n7 = this.aK;
        n2 = this.aL;
        this.m(n7, n2, 0);
        n7 = this.aI;
        n2 = this.aJ;
        this.m(n7, n2, n6);
        this.ai();
        image2 = this.a1002;
        n2 = 320;
        image2.setClip(0, 0, n3, n2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    private void al() {
        block37: {
            block38: {
                var1_1 = -1;
                var2_2 = 2;
                var3_3 = 1;
                var4_4 = 16;
                var5_5 = this.l;
                var6_6 = 13;
                if (var5_5 == var6_6) {
                    var7_7 /* !! */  = this.o1098;
                    var6_6 = this.bw;
                    var5_5 = var7_7 /* !! */ [var6_6];
                    var5_5 = var5_5 == var2_2 ? var4_4 : 32;
                } else {
                    var5_5 = 0;
                    var7_7 /* !! */  = null;
                }
                var6_6 = this.g1046;
                switch (var6_6) {
                    case -1: 
                    case 50: {
                        this.bO = var5_5 = this.bO - var4_4;
                        if (var5_5 < 0) {
                            this.bO = 0;
                            ** break;
                        }
                        ** GOTO lbl35
                    }
                    case -3: 
                    case 52: {
                        this.bN = var5_5 = this.bN - var4_4;
                        if (var5_5 < 0) {
                            this.bN = 0;
                            ** break;
                        }
                        ** GOTO lbl35
                    }
                    case -4: 
                    case 54: {
                        this.bN = var6_6 = this.bN + 16;
                        var8_8 = this.bI - var4_4 - var5_5;
                        if (var6_6 > var8_8) {
                            var6_6 = this.bI - var4_4;
                            this.bN = var5_5 = var6_6 - var5_5;
                        }
                    }
lbl35:
                    // 8 sources

                    default: {
                        break block38;
                    }
                    case -2: 
                    case 56: 
                }
                this.bO = var6_6 = this.bO + 16;
                var8_8 = this.bJ - var4_4 - var5_5;
                if (var6_6 > var8_8) {
                    var6_6 = this.bJ - var4_4;
                    this.bO = var5_5 = var6_6 - var5_5;
                }
            }
            if ((var5_5 = this.l) != var2_2) {
                var5_5 = this.l;
                var6_6 = 13;
                if (var5_5 != var6_6) return;
            }
            var5_5 = this.h1047;
            block6 : switch (var5_5) {
                case -6: 
                case -5: 
                case 53: {
                    var5_5 = this.bu;
                    if (var5_5 != 0) return;
                    var5_5 = this.bF;
                    if (var5_5 == 0) {
                        var5_5 = this.ay;
                        if (var5_5 != var1_1) {
                            var7_7 /* !! */  = (byte[])this.c1107;
                            var6_6 = this.ay;
                            var8_8 = 10;
                            if ((var6_6 = (var7_7 /* !! */  = (byte[])var7_7 /* !! */ [var6_6])[var2_2]) == var8_8) {
                                var6_6 = var7_7 /* !! */ [15];
                                if (var6_6 == 0) {
                                    var6_6 = 3;
                                    var5_5 = (int)a.g(var7_7 /* !! */ [var6_6]);
                                    var5_5 = var5_5 != 0 ? 6 : 3;
                                    this.j(var5_5);
                                    break;
                                }
                                var6_6 = 3;
                                var5_5 = (int)a.g(var7_7 /* !! */ [var6_6]);
                                var5_5 = var5_5 != 0 ? 7 : 4;
                                this.j(var5_5);
                                break;
                            }
                            var6_6 = 3;
                            var5_5 = (int)a.g(var7_7 /* !! */ [var6_6]);
                            var5_5 = var5_5 != 0 ? 5 : var2_2;
                            this.j(var5_5);
                            break;
                        }
                        var5_5 = this.bN;
                        var6_6 = this.bO;
                        if ((var5_5 = (int)this.e(var5_5, var6_6)) != 0) {
                            this.j(0);
                            break;
                        }
                        var5_5 = this.bN;
                        var6_6 = this.bO;
                        if ((var5_5 = (int)this.g(var5_5, var6_6)) != 0) {
                            this.j(var3_3);
                            break;
                        }
                        var5_5 = this.h1047;
                        switch (var5_5) {
                            default: {
                                break block6;
                            }
                            case -6: 
                            case -5: 
                            case 53: 
                        }
                        this.u1096 = var3_3;
                        break;
                    }
                    var5_5 = (int)this.x1126;
                    if (var5_5 == 0) return;
                    var7_7 /* !! */  = this.p1099;
                    var6_6 = this.bw;
                    var5_5 = var7_7 /* !! */ [var6_6];
                    if (var5_5 == var3_3) {
                        var7_7 /* !! */  = null;
                        var6_6 = 0;
                        var9_9 = null;
                        for (var5_5 = 0; var5_5 < (var8_8 = 4); ++var5_5) {
                            var8_8 = this.bN;
                            var4_4 = this.bO;
                            if ((var8_8 = (int)this.a(var8_8, var4_4, var5_5)) == 0 || (var8_8 = (var10_10 = this.m1129)[var5_5]) == var1_1) continue;
                            var9_9 = this.m1129;
                            var6_6 = var9_9[var5_5];
                            this.bx = var8_8 = this.bx + 1;
                        }
                        var5_5 = this.bx;
                        if (var5_5 > var3_3) {
                            var5_5 = 0;
                            var7_7 /* !! */  = null;
                            break block37;
                        } else {
                            var5_5 = this.bx;
                            if (var5_5 != var3_3) return;
                            this.bx = 0;
                            var5_5 = this.bN;
                            var8_8 = this.bO;
                            var4_4 = this.bw;
                            this.c(var5_5, var8_8, var4_4, var6_6);
                            break;
                        }
                    }
                    var5_5 = this.bN;
                    var6_6 = this.bO;
                    var8_8 = this.bw;
                    this.c(var5_5, var6_6, var8_8, var1_1);
                    break;
                }
                case -7: {
                    var5_5 = this.bF;
                    if (var5_5 != var3_3) return;
                    this.bF = 0;
                    this.aw = 0;
                    this.b(var2_2);
                    return;
                }
            }
lbl137:
            // 11 sources

            while (true) {
                ** default:
lbl139:
                // 1 sources

                return;
            }
        }
        while (true) {
            block40: {
                block39: {
                    if (var5_5 >= (var6_6 = 4)) break block39;
                    var9_9 = this.m1129;
                    var6_6 = var9_9[var5_5];
                    if (var6_6 == var1_1) break block40;
                    var9_9 = this.m1129;
                    this.aA = var5_5 = var9_9[var5_5];
                }
                this.bx = 0;
                var5_5 = 14;
                this.a(var5_5);
                ** continue;
            }
            ++var5_5;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void am() {
        int n = 2;
        int n2 = this.bF;
        switch (n2) {
            case 0: {
                int n3 = this.ay;
                int n4 = -1;
                if (n3 != n4) {
                    int[][] nArray = this.c1107;
                    int n5 = this.ay;
                    int[] nArray2 = nArray[n5];
                    int n6 = nArray2[0];
                    int n7 = nArray2[1];
                    byte[] byArray = this.o1098;
                    int n8 = nArray2[n];
                    int n9 = byArray[n8] << 4;
                    byte[] byArray2 = this.o1098;
                    int n11 = nArray2[n];
                    n11 = byArray2[n11] << 4;
                    this.i(n6, n7, n9, n11);
                } else {
                    int n12 = this.bN;
                    int n13 = this.bO;
                    int n14 = this.bE;
                    int n15 = this.bE;
                    this.i(n12, n13, n14, n15);
                }
            }
            default: {
                return;
            }
            case 1: 
        }
        int n16 = this.bN;
        int n17 = this.bO;
        this.p(n16, n17);
        int n18 = this.bN;
        int n19 = this.bO;
        byte[] byArray = this.o1098;
        int n20 = this.bw;
        int n21 = byArray[n20] << 4;
        byte[] byArray3 = this.o1098;
        int n22 = this.bw;
        n20 = byArray3[n22] << 4;
        this.i(n18, n19, n21, n20);
        int n23 = this.bN;
        int n24 = this.bO;
        n21 = this.bw;
        this.e(n23, n24, n21, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void an() {
        int n;
        int n2 = 16;
        int n3 = 130;
        int n4 = this.bN;
        int n5 = 112;
        if (n4 >= n5 && (n4 = this.bN) <= (n = this.bI - n2 - n5)) {
            this.bP = n4 = this.bN - n5;
        } else {
            n4 = this.bN;
            if (n4 < n5) {
                this.bP = 0;
            } else {
                n4 = this.bI;
                n = 240;
                this.bP = n4 -= n;
            }
        }
        if ((n4 = this.bO) >= n3 && (n4 = this.bO) <= (n = this.bJ - n2 - n3)) {
            this.bQ = n4 = this.bO - n3;
            return;
        }
        n4 = this.bO;
        if (n4 < n3) {
            this.bQ = 0;
            return;
        }
        n4 = this.bJ;
        n = 276;
        this.bQ = n4 -= n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void ao() {
        int n;
        int n2;
        int n3;
        block14: {
            block13: {
                n3 = this.l;
                int n4 = 2;
                if (n3 != n4) break block13;
                n3 = this.h1047;
                int[] nArray = this.r1166;
                n2 = this.bU;
                n = nArray[n2];
                if (n3 != n) break block14;
                n3 = this.bU + 1;
                this.bU = n3;
                n3 = this.bU;
                int[] nArray2 = this.r1166;
                n = nArray2.length;
                if (n3 == n) {
                    this.bz = n3 = this.bz + 1000;
                    this.bU = 0;
                }
            }
            return;
        }
        n3 = this.h1047;
        int[] nArray = this.s1167;
        n2 = this.bU;
        n = nArray[n2];
        if (n3 == n) {
            n3 = this.bU + 1;
            this.bU = n3;
            n3 = this.bU;
            int[] nArray3 = this.s1167;
            n = nArray3.length;
            if (n3 != n) return;
            for (n3 = 0; n3 < (n = this.aP); ++n3) {
                int[] nArray4 = this.b1066[n3];
                nArray4[n4] = 0;
            }
            this.bU = 0;
            return;
        }
        n3 = this.h1047;
        int[] nArray5 = this.t1168;
        n2 = this.bU;
        n = nArray5[n2];
        if (n3 == n) {
            n3 = this.bU + 1;
            this.bU = n3;
            n3 = this.bU;
            int[] nArray6 = this.s1167;
            n = nArray6.length;
            if (n3 != n) return;
            for (n3 = 0; n3 < (n = 9); ++n3) {
                boolean[] blArray = this.d1073;
                blArray[n3] = n2 = 1;
            }
            this.bU = 0;
            return;
        }
        this.bU = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void ap() {
        int n = 120;
        int n2 = 90;
        int n3 = 240;
        int n4 = 175;
        this.a1002.setColor(0xFCFFCD);
        Graphics graphics = this.a1002;
        String string = this.b1015[n4];
        int n5 = string.length();
        int n6 = this.k;
        n5 = n5 * n6 + 8;
        n5 = n3 - n5 >> 1;
        Object object = this.b1015[n4];
        n6 = ((String)object).length();
        int n7 = this.k;
        n6 = n6 * n7 + 8;
        graphics.fillRect(n5, n2, n6, n);
        int n8 = this.b1015[n4].length();
        n5 = this.k;
        n8 = n8 * n5 + 8;
        n5 = n3 - n8 >> 1;
        n8 = this.b1015[n4].length();
        n6 = this.k;
        n6 = n8 * n6 + 8;
        n7 = 1;
        a a2 = this;
        this.c(n5, n2, n6, n, n7);
        Graphics graphics2 = this.a1002;
        n5 = 320;
        graphics2.setClip(0, 0, n3, n5);
        n8 = 0;
        Object var5_8 = null;
        while (n8 < (n5 = 5)) {
            n5 = this.r;
            if (n8 == n5) {
                string = this.a1002;
                n2 = 14311547;
                string.setColor(n2);
            } else {
                string = this.a1002;
                n2 = 15455661;
                string.setColor(n2);
            }
            string = this.a1002;
            String[] stringArray = this.b1015;
            n6 = n8 + 175;
            String string2 = stringArray[n6];
            object = this.b1015;
            n = n8 + 175;
            object = object[n];
            n6 = ((String)object).length();
            n = this.k;
            n6 *= n;
            n6 = n3 - n6 >> 1;
            n = n8 * 20 + 100;
            string.drawString(string2, n6, n, 0);
            ++n8;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void aq() {
        int n = 4;
        int n2 = 1;
        int n3 = this.h1047;
        switch (n3) {
            case -1: 
            case 50: {
                this.r = n3 = this.r - n2;
                if (n3 < 0) {
                    this.r = n;
                }
                if ((n3 = (int)(this.e() ? 1 : 0)) != 0 && (n3 = this.r) == n2) {
                    this.r = n3 = this.r - n2;
                }
                if ((n3 = (int)(this.z1169 ? 1 : 0)) == 0) return;
                n3 = this.r;
                if (n3 != n) return;
                this.r = n3 = 3;
                return;
            }
            case -2: 
            case 56: {
                this.r = n3 = this.r + 1;
                if (n3 > n) {
                    this.r = 0;
                }
                if ((n3 = (int)(this.e() ? 1 : 0)) != 0 && (n3 = this.r) == n2) {
                    this.r = n3 = this.r + 1;
                }
                if ((n3 = (int)(this.z1169 ? 1 : 0)) == 0) return;
                n3 = this.r;
                if (n3 != n) return;
                this.r = 0;
                return;
            }
            case -6: 
            case -5: 
            case 53: {
                n3 = this.bW = (n3 = this.r);
                this.F(n3);
                return;
            }
            case -7: {
                this.r = 0;
                this.a();
                return;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void ar() {
        this.e();
        this.a1002.setColor(14311547);
        var1_1 = this.a1002;
        var2_2 = 320;
        var1_1.setClip(0, 0, 240, var2_2);
        var1_1 = "";
        var3_3 = this.l;
        switch (var3_3) {
            default: lbl-1000:
            // 2 sources

            {
                while (true) {
                    var4_4 /* !! */  = var1_1;
lbl12:
                    // 8 sources

                    while (true) {
                        var2_2 = this.c;
                        var1_1 = this;
                        this.a((String)var4_4 /* !! */ , var2_2, 27, 70, 186, 292);
                        this.f();
                        this.c(2, 3);
                        return;
                    }
                    break;
                }
            }
            case 48: {
                var1_1 = this.d1173;
                var3_3 = 7;
                var1_1 = var1_1[var3_3];
                var4_4 /* !! */  = var1_1;
                ** GOTO lbl12
            }
            case 47: {
                var1_1 = this.d1173;
                var3_3 = 8;
                var1_1 = var1_1[var3_3];
                var4_4 /* !! */  = var1_1;
                ** GOTO lbl12
            }
            case 46: 
        }
        var3_3 = this.b1174;
        switch (var3_3) {
            default: {
                ** continue;
            }
            case 0: {
                var5_5 = this.o;
                var3_3 = -1;
                if (var5_5 == var3_3) ** GOTO lbl51
                var1_1 = new StringBuffer();
                var4_4 /* !! */  = this.b1015;
                var2_2 = this.o + 113;
                var4_4 /* !! */  = var4_4 /* !! */ [var2_2];
                var1_1 = var1_1.append((String)var4_4 /* !! */ );
                var4_4 /* !! */  = this.d1173;
                var2_2 = this.bW + 0;
                var4_4 /* !! */  = var4_4 /* !! */ [var2_2];
                var1_1 = var1_1.append((String)var4_4 /* !! */ ).toString();
                var4_4 /* !! */  = var1_1;
                ** GOTO lbl12
lbl51:
                // 1 sources

                var1_1 = this.d1173;
                var3_3 = this.bW + 0;
                var1_1 = var1_1[var3_3];
                var4_4 /* !! */  = var1_1;
                ** GOTO lbl12
            }
            case 1: {
                var1_1 = this.d1173;
                var3_3 = 9;
                var1_1 = var1_1[var3_3];
                var4_4 /* !! */  = var1_1;
                ** GOTO lbl12
            }
            case 2: {
                var1_1 = this.d1173;
                var3_3 = 10;
                var1_1 = var1_1[var3_3];
                var4_4 /* !! */  = var1_1;
                ** GOTO lbl12
            }
            case 3: 
        }
        var1_1 = this.d1173;
        var3_3 = 11;
        var1_1 = var1_1[var3_3];
        var4_4 /* !! */  = var1_1;
        ** while (true)
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void as() {
        int n = 47;
        int n2 = 2;
        int n3 = 1;
        int n4 = this.b1174;
        switch (n4) {
            case 0: {
                n4 = this.h1047;
                switch (n4) {
                    default: {
                        return;
                    }
                    case -7: {
                        this.a();
                        return;
                    }
                    case -1: 
                    case 50: {
                        n4 = this.c;
                        if (n4 <= 0) return;
                        this.c = n4 = this.c - n3;
                        return;
                    }
                    case -2: 
                    case 56: {
                        n4 = this.c;
                        n = this.a1007;
                        int n5 = this.b1008;
                        if (n4 >= (n -= n5)) return;
                        this.c = n4 = this.c + 1;
                        return;
                    }
                    case -6: 
                    case -5: 
                    case 53: 
                }
                this.a(n);
                this.at();
                return;
            }
            case 1: {
                n4 = this.h1047;
                switch (n4) {
                    default: {
                        return;
                    }
                    case -7: 
                    case -6: 
                    case -5: 
                    case 53: 
                }
                this.a();
                n4 = this.bW;
                switch (n4) {
                    default: {
                        return;
                    }
                    case 0: {
                        n4 = 0;
                        Object var6_7 = null;
                        while (n4 < (n = this.aP)) {
                            int[] nArray = this.b1066[n4];
                            nArray[n2] = 0;
                            ++n4;
                        }
                        return;
                    }
                    case 1: {
                        n4 = 0;
                        Object var6_8 = null;
                        while (n4 < (n = 5)) {
                            this.a1056[n4] = n3;
                            boolean[] blArray = this.b1059;
                            byte[] byArray = this.h1060;
                            byte by = byArray[n4];
                            blArray[by] = n3;
                            Object var7_14 = null;
                            for (n = 0; n < n2; ++n) {
                                boolean[] blArray2 = this.e1105;
                                byte[] byArray2 = this.g1065[n4];
                                byte by2 = byArray2[n];
                                blArray2[by2] = n3;
                            }
                            byte[] byArray3 = this.h1060;
                            n = byArray3[n4];
                            this.u(n);
                            ++n4;
                        }
                        return;
                    }
                    case 2: {
                        this.bz = n4 = this.bz + 500;
                        return;
                    }
                    case 3: {
                        this.by = n4 = this.by + 10;
                        return;
                    }
                    case 4: {
                        this.z1169 = n3;
                        return;
                    }
                    case 5: {
                        boolean[] blArray = this.d1073;
                        n = this.aN;
                        blArray[n] = n3;
                        return;
                    }
                    case 6: 
                }
                this.A1170 = n3;
                return;
            }
            case 2: {
                n4 = this.h1047;
                switch (n4) {
                    default: {
                        return;
                    }
                    case -7: {
                        this.a();
                        return;
                    }
                    case -6: 
                    case -5: 
                    case 53: 
                }
                this.a(n);
                this.at();
                return;
            }
            case 3: {
                n4 = this.h1047;
                switch (n4) {
                    default: {
                        return;
                    }
                    case -7: {
                        this.a();
                        return;
                    }
                    case -6: 
                    case -5: 
                    case 53: 
                }
                n4 = this.F1180 ? 1 : 0;
                if (n4 != 0) {
                    String string = this.d1181;
                    a.b(string);
                    return;
                }
                this.a();
                return;
            }
        }
    }

    private void at() {
        this.b1174 = 1;
        this.a();
    }

    private void au() {
        int n;
        Comparable<Calendar> comparable = Calendar.getInstance();
        this.a1185 = comparable;
        comparable = new Comparable<Calendar>();
        this.a1184 = comparable;
        comparable = this.a1184;
        long l = System.currentTimeMillis();
        ((Date)comparable).setTime(l);
        comparable = this.a1185;
        Date date = this.a1184;
        ((Calendar)comparable).setTime(date);
        n = this.bX = (n = this.a1185.get(1) * 10000);
        int n2 = this.a1185.get(2) * 100;
        n += n2;
        n = this.bX = n;
        n2 = this.a1185.get(5);
        this.bX = n += n2;
        this.bX = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void av() {
        Object object = this.a1172;
        synchronized (object) {
            int n;
            this.bV = n = 2;
        }
        object = new MIDletThread((Runnable)this);
        ((Thread)object).start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void aw() {
        String string = "__sfSmsInfo";
        int n = 0;
        Object object = null;
        try {
            try {
                boolean bl;
                String string2;
                string = RecordStore.openRecordStore((String)string, (boolean)false);
                n = 1;
                object = string.getRecord(n);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
                object = new DataInputStream;
                ((DataInputStream)object)(byteArrayInputStream);
                ((DataInputStream)object).readInt();
                this.b1177 = string2 = ((DataInputStream)object).readUTF();
                this.c1178 = string2 = ((DataInputStream)object).readUTF();
                bl = this.F1180 = (bl = ((DataInputStream)object).readBoolean());
                if (bl) {
                    this.d1181 = string2 = ((DataInputStream)object).readUTF();
                }
                if (bl = (this.G1182 = (bl = ((DataInputStream)object).readBoolean()))) {
                    this.e1183 = string2 = ((DataInputStream)object).readUTF();
                }
                ((FilterInputStream)object).close();
                byteArrayInputStream.close();
                string.closeRecordStore();
                return;
            }
            catch (RecordStoreNotFoundException recordStoreNotFoundException) {
                String string3;
                this.c1178 = string3 = "YXBY15 2LD210A10 IF2";
                this.b1177 = string3 = "106633000015";
                this.ax();
                return;
            }
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void ax() {
        int n = 1;
        ByteArrayOutputStream byteArrayOutputStream = null;
        Object object = "__sfSmsInfo";
        boolean bl = false;
        Object var5_7 = null;
        try {
            void var5_9;
            int n2;
            try {
                RecordStore recordStore = RecordStore.openRecordStore((String)object, (boolean)false);
                n2 = 0;
                object = null;
            }
            catch (RecordStoreNotFoundException recordStoreNotFoundException) {
                object = "__sfSmsInfo";
                bl = true;
                object = RecordStore.openRecordStore((String)object, (boolean)bl);
                String string = object;
                n2 = n;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int n3 = this.bX;
            dataOutputStream.writeInt(n3);
            Object object2 = this.b1177;
            dataOutputStream.writeUTF((String)object2);
            object2 = this.c1178;
            dataOutputStream.writeUTF((String)object2);
            boolean bl2 = this.F1180;
            dataOutputStream.writeBoolean(bl2);
            boolean bl3 = this.F1180;
            if (bl3) {
                object2 = this.d1181;
                dataOutputStream.writeUTF((String)object2);
            }
            boolean bl4 = this.G1182;
            dataOutputStream.writeBoolean(bl4);
            boolean bl5 = this.G1182;
            if (bl5) {
                object2 = this.e1183;
                dataOutputStream.writeUTF((String)object2);
            }
            if (n2 != 0) {
                object = byteArrayOutputStream.toByteArray();
                boolean bl6 = false;
                object2 = null;
                int n4 = byteArrayOutputStream.size();
                var5_9.addRecord((byte[])object, 0, n4);
            } else {
                n2 = 1;
                object2 = byteArrayOutputStream.toByteArray();
                boolean bl7 = false;
                int n5 = byteArrayOutputStream.size();
                var5_9.setRecord(n2, (byte[])object2, 0, n5);
            }
            dataOutputStream.close();
            byteArrayOutputStream.close();
            var5_9.closeRecordStore();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void ay() {
        Object object;
        try {
            object = this.a1191;
            ((ByteArrayOutputStream)object).close();
        }
        catch (Exception exception) {}
        object = this.a1191.toByteArray();
        this.H1188 = (byte[])object;
        this.a1191 = null;
        this.g1187 = null;
        this.I1189 = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int b() {
        int n;
        Object object = this.a1172;
        synchronized (object) {
            n = this.bV;
        }
        int n2 = 2;
        if (n != n2) return n;
        long l = 50;
        try {
            Thread.sleep(l);
            return n;
        }
        catch (Exception exception) {
            return n;
        }
    }

    private int b(int n) {
        int n2;
        int n3 = 2;
        byte[] byArray = null;
        int[] nArray = this.c1107[n];
        int n4 = 0;
        for (int i = 0; i < (n2 = nArray[3]); ++i) {
            n2 = nArray[n3];
            byte[] byArray2 = this.r1101;
            n2 = this.a(n2, byArray2, i);
            n4 += n2;
        }
        byArray = this.q1100;
        int n5 = nArray[n3];
        return byArray[n5] + n4 >> 1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int b(int n, int n2) {
        int n3;
        if (n2 == 0) {
            n3 = this.bG;
            return n % n3 << 4;
        }
        n3 = this.bG;
        return n / n3 << 4;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int b(int n, int n2, int n3) {
        byte[] byArray;
        int n4 = 3;
        int n5 = 2;
        int n6 = 1;
        int n7 = this.c(n, n2);
        this.bc = 0;
        int n8 = this.q1082;
        if (n8 == 0) {
            n8 = n6;
        } else {
            n8 = 0;
            byArray = null;
        }
        this.q1082 = n8;
        int n9;
        while ((n8 = this.bc) < (n9 = 4)) {
            byArray = this.k1081[n7];
            n8 = (byArray[0] << 4) + n;
            byte[] byArray2 = this.k1081[n7];
            n9 = (byArray2[n6] << 4) + n2;
            if ((n9 = (int)(this.b(n8 = this.a(n8, n9)) ? 1 : 0)) != 0 && (n9 = Math.abs(this.a(n8) - n7)) != n5 && (n8 = Math.abs(this.a(n8) - n3)) != n5) {
                return n7;
            }
            n8 = this.q1082 ? 1 : 0;
            if (n8 != 0) {
                if (++n7 > n4) {
                    n7 = 0;
                }
            } else if ((n7 += -1) < 0) {
                n7 = n4;
            }
            this.bc = n8 = this.bc + 1;
        }
        return this.c(n, n2);
    }

    private static int b(int n, int n2, int n3, int n4) {
        int n5 = n3 - n;
        int n6 = n3 - n;
        n5 *= n6;
        n6 = n4 - n2;
        int n7 = n4 - n2;
        return n5 + (n6 *= n7);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String b(String string) {
        int n = this.D1176;
        if (n == 0) return string;
        int n2 = 7;
        n = string.indexOf(47, n2);
        String string2 = string.substring(n);
        StringBuffer stringBuffer = new StringBuffer();
        String string3 = "http://10.0.0.172:80";
        stringBuffer = stringBuffer.append(string3);
        return stringBuffer.append(string2).toString();
    }

    private void b() {
        this.m = 0;
    }

    private void b(int n) {
        int n2;
        int[] nArray;
        int n3;
        do {
            this.m = n3 = this.m - 1;
        } while ((n3 = (nArray = this.b)[n2 = this.m]) != n);
        nArray = this.b;
        n2 = this.m;
        this.l = n3 = nArray[n2];
    }

    private void b(int n, int n2) {
        int n3 = 320;
        int n4 = 240;
        int n5 = 0;
        this.a1002.setClip(0, 0, n4, n3);
        this.a1002.setColor(0xFFFFFF);
        this.a1002.fillRect(0, 0, n4, n3);
        int n6 = this.t;
        int n7 = n4 - n;
        this.e(n6, n7);
        this.d(n2);
        for (n6 = 0; n6 < (n7 = 3); ++n6) {
            n7 = this.w;
            n5 = n6 * 176;
            n7 += n5;
            n5 = this.x - n;
            this.d(n7, n5);
        }
    }

    private final void b(int n, int n2, int n3) {
        int n4 = 7;
        int n5 = 5;
        int n6 = 3;
        int n7 = 1;
        int n8 = 1000000;
        int n9 = n3 + 3;
        if (n != 0) {
            int n10;
            int n11 = n8;
            n8 = 0;
            Object var11_11 = null;
            while ((n10 = this.a1016) == 0) {
                n10 = n / n11;
                if (n10 != 0) {
                    this.a1016 = n7;
                    n8 = n11;
                }
                n11 /= 10;
            }
            n11 = this.a1016 ? 1 : 0;
            if (n11 != 0) {
                this.a1016 = false;
                n11 = n2;
                n10 = n;
                while (n8 > 0) {
                    this.a1002.setClip(n11, n9, n5, n4);
                    Graphics graphics = this.a1002;
                    Image image = this.a1013[n6][13];
                    int n12 = n10 / n8 * 5;
                    n12 = n11 - n12;
                    graphics.drawImage(image, n12, n9, 0);
                    int n13 = n10 / n8 * n8;
                    n10 -= n13;
                    n8 /= 10;
                    n11 = n11 + 5 - n7;
                }
            }
        } else {
            this.a1002.setClip(n2, n9, n5, n4);
            Graphics graphics = this.a1002;
            Image image = this.a1013[n6];
            int n14 = 13;
            image = image[n14];
            graphics.drawImage(image, n2, n9, 0);
        }
        this.a1002.setClip(0, 0, 240, 320);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void b(int n, int n2, int n3, int n4) {
        int n5 = 7;
        int n6 = 1;
        int n7 = 15;
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(3291732);
        Graphics graphics = this.a1002;
        int n8 = n2 - 8;
        int n9 = n3 - 16;
        graphics.fillRect(n8, n9, n7, 3);
        this.a1002.setColor(0xFFFFE7);
        graphics = this.a1002;
        n8 = n2 - n5;
        n9 = n3 - n7;
        int n10 = 13;
        graphics.fillRect(n8, n9, n10, n6);
        graphics = this.a1002;
        n8 = 49168;
        graphics.setColor(n8);
        int n11 = n4 & 1;
        if (n11 == 0) {
            graphics = this.a1002;
            n8 = n2 - n5;
            n9 = n3 - n7;
            n10 = n * 13;
            n7 = this.aW;
            graphics.fillRect(n8, n9, n10 /= n7, n6);
            return;
        }
        graphics = this.a1002;
        n8 = n2 - n5;
        n9 = n3 - n7;
        n10 = n * 13;
        n7 = this.aW * 10;
        graphics.fillRect(n8, n9, n10 /= n7, n6);
    }

    private void b(int n, int n2, int n3, int n4, int n5) {
        int n6 = 2;
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(13971834);
        Object object = new StringBuffer();
        Object object2 = this.b1015;
        Object object3 = this.y1130;
        int n7 = this.X;
        object3 = object3[n7];
        n7 = this.c1107[n][n6];
        Object object4 = object3[n7] + 28;
        object2 = object2[object4];
        object = ((StringBuffer)object).append((String)object2).append("\uff1a");
        object2 = this.b1015;
        object3 = this.y1130;
        n7 = this.X;
        object3 = object3[n7];
        n7 = this.c1107[n][n6];
        object4 = object3[n7] + 122;
        object2 = object2[object4];
        object2 = ((StringBuffer)object).append((String)object2).toString();
        object = this;
        object4 = n2;
        n7 = n3;
        n6 = n4;
        this.a((String)object2, 0, n2, n3, n4, n5);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        int n8;
        int n9;
        block8: {
            block9: {
                int n10 = 1;
                byte by = this.a1038;
                if (n >= by) return;
                int[] nArray = this.a1039[n];
                if (n2 != n10) break block9;
                Image image = this.a1040[n];
                n9 = image.getWidth();
                Image image2 = this.a1040[n];
                n8 = image2.getHeight();
                n7 = n3 & 1;
                if (n7 != 0) {
                    n9 = n5 - n9;
                } else {
                    n7 = n3 & 4;
                    if (n7 != 0) {
                        n9 >>= 1;
                        n9 = n5 - n9;
                    } else {
                        n9 = n5;
                    }
                }
                if ((n7 = n3 & 2) != 0) {
                    int n11 = n6 - (n8 -= n10);
                    n8 = n9;
                    n9 = n11;
                    break block8;
                } else {
                    n7 = n3 & 8;
                    if (n7 != 0) {
                        n8 = (n8 >> 1) - n10;
                        int n12 = n6 - n8;
                        n8 = n9;
                        n9 = n12;
                        break block8;
                    } else {
                        n8 = n9;
                        n9 = n6;
                    }
                }
                break block8;
            }
            n9 = n6;
            n8 = n5;
        }
        nArray[2] = n2;
        nArray[3] = n4;
        n7 = 4;
        nArray[n7] = n8;
        n8 = 5;
        nArray[n8] = n9;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void b(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        Image[][] imageArray;
        void var9_11;
        byte[][] byArray;
        int n9 = 5;
        int n10 = n7;
        if (n7 > n9) {
            int n11 = 5;
        } else {
            int n12 = n7;
        }
        a a2 = this;
        Object object = byArray = this.K1145;
        int n13 = var9_11 >> 1;
        object = byArray[n13];
        byte[] byArray2 = object[0];
        a a3 = this;
        byte[][] byArray3 = this.K1145;
        void var9_12 = var9_11 >> 1;
        byte[] byArray4 = byArray3[var9_12];
        byte by = byArray4[1];
        n13 = n + byArray2;
        a a4 = this;
        int n14 = n10 = this.bP;
        int n15 = n13 - n10;
        n13 = n2 + by;
        n14 = n10 = this.bQ;
        int n16 = (n13 -= n10) + 13;
        switch (n8) {
            case 0: {
                int n17;
                reference var14_67 = byArray2 + n;
                int n18 = by + n2;
                this.t((int)var14_67, n18, n6);
                int n19 = 2;
                n10 = n6;
                if (n6 > n19 && n6 < (n17 = 6)) {
                    Image[][] imageArray2;
                    Image[][] imageArray3 = imageArray2 = this.a1013;
                    Image[] imageArray4 = imageArray2[29];
                    int n20 = 22;
                    object = imageArray4[n20];
                    n13 = n15 + 21;
                    n14 = n16 + 15;
                    int n21 = n6 & 1;
                    int n22 = n21 << 4;
                    boolean bl = false;
                    int n23 = 16;
                    int n24 = 16;
                    a a5 = this;
                    this.a((Image)object, n13, n14, n22, 0, n23, n24, 0, 0);
                } else {
                    Image[][] imageArray5;
                    int n25;
                    int n26;
                    int n27 = 6;
                    n10 = n6;
                    if (n6 < n27) return;
                    int n28 = 6;
                    if (n6 == n28) {
                        Image[][] imageArray6;
                        a a6 = this;
                        Image[][] imageArray7 = imageArray6 = this.a1013;
                        Image[] imageArray8 = imageArray6[29];
                        int n29 = 29;
                        object = imageArray8[n29];
                        n13 = n15 + 21;
                        int n30 = 15;
                        n14 = n16 - n30;
                        n26 = 0;
                        int n31 = 18;
                        int n32 = 16;
                        int n33 = 31;
                        a a7 = this;
                        this.a((Image)object, n13, n14, 0, n31, n32, n33, 0, 0);
                    }
                    int n34 = 6;
                    n10 = n6;
                    if (n6 >= n34 && n6 < (n25 = 9)) {
                        Image[][] imageArray9;
                        a a8 = this;
                        Image[][] imageArray10 = imageArray9 = this.a1013;
                        Image[] imageArray11 = imageArray9[29];
                        int n35 = 27;
                        object = imageArray11[n35];
                        n13 = n15 + 21;
                        n14 = n16 + 10;
                        int n36 = n6 - 6;
                        n26 = n36 * 21;
                        boolean bl = false;
                        int n37 = 21;
                        int n38 = 17;
                        a a9 = this;
                        this.a((Image)object, n13, n14, n26, 0, n37, n38, 0, 0);
                    }
                    int n39 = 6;
                    n10 = n6;
                    if (n6 <= n39) return;
                    a a10 = this;
                    Image[][] imageArray12 = imageArray5 = this.a1013;
                    Image[] imageArray13 = imageArray5[29];
                    int n40 = 28;
                    object = imageArray13[n40];
                    n13 = n15 + 14;
                    n14 = n16 - 30;
                    int n41 = n6 - 7;
                    n26 = n41 * 29;
                    boolean bl = false;
                    int n42 = 29;
                    int n43 = 22;
                    a a11 = this;
                    this.a((Image)object, n13, n14, n26, 0, n42, n43, 0, 0);
                }
            }
            default: {
                return;
            }
            case 1: 
        }
        int n44 = 3;
        n10 = n6;
        if (n6 < n44) {
            byte[][] byArray5;
            Image[][] imageArray14;
            byte[][] byArray6;
            byte[][] byArray7;
            byte[][] byArray8;
            byte[][] byArray9;
            Image[][] imageArray15;
            Image[][] imageArray16 = imageArray15 = this.a1013;
            object = imageArray15[29][29];
            a a12 = this;
            int n45 = n10 = this.bP;
            n13 = n3 - n10;
            byte[][] byArray10 = byArray9 = this.L1146;
            int n46 = byArray9[n6][0] + n4;
            a a13 = this;
            n14 = n10 = this.bQ;
            n14 = n46 - n10 + 13;
            byte[][] byArray11 = byArray8 = this.L1146;
            byte by2 = byArray8[n6][1];
            a a14 = this;
            byte[][] byArray12 = byArray7 = this.L1146;
            byte by3 = byArray7[n6][2];
            a a15 = this;
            byte[][] byArray13 = byArray6 = this.L1146;
            byte by4 = byArray6[n6][3];
            a a16 = this;
            this.a((Image)object, n13, n14, 0, by2, by3, by4, 2, 0);
            a a17 = this;
            Image[][] imageArray17 = imageArray14 = this.a1013;
            Image[] imageArray18 = imageArray14[29];
            int n47 = 28;
            object = imageArray18[n47];
            a a18 = this;
            int n48 = n10 = this.bP;
            n13 = n3 - n10;
            byte[][] byArray14 = byArray5 = this.L1146;
            int n49 = byArray5[0][0] + n4;
            a a19 = this;
            n14 = n10 = this.bQ;
            int n50 = n49 - n10;
            n14 = n50 + 13;
            int n51 = n6 * 29;
            boolean bl = false;
            int n52 = 29;
            int n53 = 22;
            a a20 = this;
            this.a((Image)object, n13, n14, n51, 0, n52, n53, 0, 0);
            return;
        }
        Image[][] imageArray19 = imageArray = this.a1013;
        Image[] imageArray20 = imageArray[29];
        int n54 = 30;
        object = imageArray20[n54];
        n14 = n3 + 10;
        int n55 = n4 + 40;
        int n56 = 3;
        int n57 = n6 - n56;
        a a21 = this;
        n13 = n5;
        this.b((Image)object, n5, n14, n55, n57);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(int n, int n2, int n3, int n4, boolean bl) {
        int n5;
        int n6;
        Graphics graphics;
        if (bl) {
            graphics = this.a1002;
            n6 = 5046188;
            graphics.setColor(n6);
        } else {
            graphics = this.a1002;
            int[] nArray = this.q1158;
            long l = this.a1019;
            n5 = (int)l & 3;
            n6 = nArray[n5];
            graphics.setColor(n6);
        }
        int n7 = 0;
        graphics = null;
        while (true) {
            if (n7 >= n3) {
                this.a1002.drawRect(n, n2, n3, n4);
                return;
            }
            Graphics graphics2 = this.a1002;
            n5 = n + n7;
            int n8 = n + n3;
            int n9 = n2 + n4 - n7;
            graphics2.drawLine(n5, n2, n8, n9);
            Graphics graphics3 = this.a1002;
            n5 = n2 + n7;
            n8 = n + n3 - n7;
            n9 = n2 + n4;
            graphics3.drawLine(n, n5, n8, n9);
            n7 += 2;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void b(String string) {
        CMidlet cMidlet;
        try {
            cMidlet = CMidlet.a;
        }
        catch (Exception exception) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String string2 = "http://";
        StringBuffer stringBuffer3 = stringBuffer.append(string2);
        stringBuffer3 = stringBuffer3.append(string);
        String string3 = stringBuffer3.toString();
        cMidlet.platformRequest(string3);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(Image image, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6 = image.getWidth();
        int n7 = image.getHeight();
        int n8 = n3 & 4;
        if (n8 != 0) {
            n8 = n6 >> 1;
            n8 = n - n8;
        } else {
            n8 = n;
        }
        if ((n5 = n3 & 8) != 0) {
            n5 = n7 >> 1;
            n5 = n2 - n5;
        } else {
            n5 = n2;
        }
        n6 = (n4 = n3 & 1) != 0 ? n8 - n6 : n8;
        n8 = n3 & 2;
        n7 = n8 != 0 ? n5 - n7 : n5;
        this.a1002.drawImage(image, n6, n7, 0);
        this.a1002.setClip(0, 0, 240, 320);
    }

    private void b(Image image, int n, int n2, int n3, int n4) {
        int n5;
        int n6 = 0;
        Object object = null;
        int n7 = 0;
        while (n7 < (n6 = ((byte[][])(object = this.H1140)).length)) {
            n6 = this.H1140[n7][0] + n2;
            n5 = this.bP;
            int n8 = n6 - n5;
            n6 = this.H1140[n7][1] + n3;
            n5 = this.bQ;
            int n9 = n6 - n5;
            object = this.H1140[n7];
            n5 = 2;
            reference var12_12 = (object[n5] + n4) * 16;
            int n10 = 16;
            int n11 = 16;
            object = this;
            this.a(image, n8, n9, (int)var12_12, 0, n10, n11, 0, 0);
            n7 = n6 = n7 + 1;
        }
        n6 = n2 - 10;
        n5 = n3 - 25;
        this.p(n6, n5, n4);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    private void b(Image var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6, int var7_7, int var8_8, int var9_9) {
        var10_10 = 3;
        var11_11 = 4.2E-45f;
        var12_12 /* !! */  = 3;
        var13_13 = 4.2E-45f;
        var14_14 = 0;
        var15_15 = 0.0f;
        var16_16 = 0;
        var17_17 = 0.0f;
        var18_18 = this;
        var19_19 = this.m(var8_8, var9_9);
        if (var19_19 != 0) ** GOTO lbl-1000
        switch (var2_2) {
            default: lbl-1000:
            // 2 sources

            {
                var20_20 = 0;
                var21_21 = var12_12 /* !! */ ;
                var22_22 = var10_10;
                var10_10 = 0;
                var11_11 = 0.0f;
                break;
            }
            case 0: 
            case 2: {
                var10_10 = 1;
                var11_11 = 1.4E-45f;
                var14_14 = 2;
                var15_15 = 2.8E-45f;
                var20_20 = 0;
                var21_21 = var12_12 /* !! */ ;
                var22_22 = var14_14;
                break;
            }
            case 1: 
            case 3: {
                var12_12 /* !! */  = 1;
                var13_13 = 1.4E-45f;
                var16_16 = 2;
                var17_17 = 2.8E-45f;
                var20_20 = var12_12 /* !! */ ;
                var21_21 = var16_16;
                var22_22 = var10_10;
                var10_10 = 0;
                var11_11 = 0.0f;
                break;
            }
        }
        var23_23 = var10_10;
        while (true) {
            var24_24 = var23_23;
            if (var23_23 >= var22_22) break;
            var25_25 = var20_20;
            while (true) {
                block15: {
                    var24_24 = var25_25;
                    if (var25_25 >= var21_21) break;
                    var10_10 = var23_23 << 4;
                    var18_18 = this;
                    var26_26 = var18_18 = (Object)this.m1084;
                    var12_12 /* !! */  = (int)var18_18[var2_2][0];
                    var10_10 = var10_10 * var12_12 /* !! */  + var3_3;
                    var18_18 = this;
                    var26_26 = var18_18 = (Object)this.m1084;
                    var26_26 = var18_18[var2_2];
                    var15_15 = 2.8E-45f;
                    var12_12 /* !! */  = (int)var26_26[2];
                    var10_10 += var12_12 /* !! */ ;
                    var18_18 = this;
                    var12_12 /* !! */  = var24_24 = this.bP;
                    var14_14 = var10_10 - var24_24;
                    var10_10 = var25_25 << 4;
                    var26_26 = var18_18 = (Object)this.m1084;
                    var12_12 /* !! */  = (int)var18_18[var2_2][1];
                    var10_10 = var10_10 * var12_12 /* !! */  + var4_4;
                    var18_18 = this;
                    var26_26 = var18_18 = (Object)this.m1084;
                    var26_26 = var18_18[var2_2];
                    var17_17 = 4.2E-45f;
                    var12_12 /* !! */  = (int)var26_26[3];
                    var10_10 += var12_12 /* !! */ ;
                    var18_18 = this;
                    var12_12 /* !! */  = var24_24 = this.bQ;
                    var16_16 = (var10_10 -= var24_24) + 13;
                    switch (var7_7) {
                        case 0: {
                            var19_19 = var5_5 * 16;
                            var27_27 = 16;
                            var28_28 = 16;
                            var26_26 = var1_1;
                            this.a(var1_1, var14_14, var16_16, var19_19, 0, var27_27, var28_28, 0, 0);
                            ** break;
                        }
                        case 1: {
                            var10_10 = 0;
                            var11_11 = 0.0f;
                            switch (var2_2) {
                                case 0: 
                                case 2: {
                                    var10_10 = var25_25;
                                }
                                default: {
                                    break;
                                }
                                case 1: 
                                case 3: {
                                    var10_10 = var23_23;
                                }
                            }
                            var10_10 = (var10_10 + var6_6) % 3 + 2;
                            var19_19 = var10_10 * 16;
                            var27_27 = 16;
                            var28_28 = 16;
                            var26_26 = var1_1;
                            this.a(var1_1, var14_14, var16_16, var19_19, 0, var27_27, var28_28, 0, 0);
                        }
lbl99:
                        // 3 sources

                        default: {
                            break block15;
                        }
                        case 2: 
                    }
                    var11_11 = 1.4E-45f;
                    var10_10 = 1 - var5_5;
                    var19_19 = var10_10 * 16;
                    var27_27 = 16;
                    var28_28 = 16;
                    var26_26 = var1_1;
                    this.a(var1_1, var14_14, var16_16, var19_19, 0, var27_27, var28_28, 0, 0);
                }
                var25_25 = var10_10 = var25_25 + 1;
            }
            var23_23 = var10_10 = var23_23 + 1;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean b() {
        byte[] byArray;
        int n;
        int n2;
        boolean bl = true;
        boolean bl2 = false;
        RecordStore recordStore = null;
        Object object = "sanGuoTdData";
        ByteArrayInputStream byteArrayInputStream = null;
        recordStore = RecordStore.openRecordStore((String)object, (boolean)false);
        int n3 = 1;
        object = recordStore.getRecord(n3);
        byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        object = new DataInputStream(byteArrayInputStream);
        int n4 = 0;
        while (true) {
            n2 = this.bG;
            n = this.bH;
            if (n4 >= (n2 *= n)) break;
            byArray = this.E1163;
            n = ((DataInputStream)object).readByte();
            byArray[n4] = n;
            ++n4;
            continue;
            break;
        }
        n4 = 0;
        while (true) {
            n2 = this.bG;
            n = this.bH;
            if (n4 >= (n2 *= n)) break;
            byArray = this.D1162;
            n = ((DataInputStream)object).readByte();
            byArray[n4] = n;
            ++n4;
            continue;
            break;
        }
        try {
            ((FilterInputStream)object).close();
            byteArrayInputStream.close();
            recordStore.closeRecordStore();
            return bl;
        }
        catch (Exception exception) {
            if (recordStore == null) return false;
            try {
                recordStore.closeRecordStore();
            }
            catch (Exception exception2) {
                return false;
            }
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean b(int n) {
        int n2;
        byte[] byArray;
        int n3 = this.c(n);
        if (n3 != 0 && (n3 = (byArray = this.E1163)[n]) < (n2 = 8) && (n3 = (byArray = this.D1162)[n]) < (n2 = 6)) {
            return 1 != 0;
        }
        this.m(n);
        return 0 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean b(int n, int n2) {
        int n3;
        byte[] byArray;
        int n4 = this.a(n, n2);
        int n5 = this.c(n4);
        if (n5 != 0 && (n5 = (byArray = this.E1163)[n4]) < (n3 = 8) && (n5 = (byArray = this.D1162)[n4]) < (n3 = 6)) {
            return 1 != 0;
        }
        this.m(n4);
        return 0 != 0;
    }

    private int c() {
        int n;
        int n2;
        while ((n2 = this.d()) == (n = 1)) {
            Thread.yield();
        }
        this.g1187 = null;
        return n2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int c(int n) {
        int n2 = 225;
        int n3 = 135;
        int n4 = 45;
        if (n >= n4 && n < n3) {
            return 2;
        }
        if (n >= n3 && n < n2) {
            return 3;
        }
        if (n < n2) return 1;
        n4 = 315;
        if (n >= n4) return 1;
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int c(int n, int n2) {
        int n3 = 8;
        int n4 = this.bI;
        n4 = n > n4 ? this.bI - n3 : n;
        int n5 = this.bJ;
        n5 = n2 > n5 ? this.bJ - n3 : n2;
        byte[] byArray = this.E1163;
        n4 = this.a(n4, n5);
        return byArray[n4] >> 1;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int c(int n, int n2, int n3) {
        int n4;
        int n5 = 4;
        if (n3 == n5) {
            n4 = 0;
            Object var6_6 = null;
        } else {
            n4 = n3;
        }
        int n6 = n2 + 1;
        byte[][] byArray = this.w1123;
        byte[] byArray2 = byArray[n4];
        n4 = byArray2.length;
        int n7 = 3;
        if (n6 <= (n4 -= n7)) {
            return n6;
        }
        if (n3 != 0) {
            if (n3 != n5) return 0;
        }
        int[] nArray = this.c1107[n];
        n6 = 5;
        nArray[n6] = n7 = this.a() & 3;
        return 0;
    }

    private void c() {
        this.aP = 0;
        this.bt = 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void c(int n) {
        byte[] byArray = null;
        Object object = this.a1013[n];
        if (object != null) {
            return;
        }
        object = this.a1013;
        int[] nArray = this.f;
        int n2 = nArray[n];
        Image[] imageArray = new Image[n2];
        object[n] = imageArray;
        this.getClass();
        object = this.a1014;
        object = object[n];
        object = Display.getResourceAsStream((String)object);
        byArray = null;
        n2 = 0;
        Object var4_7 = null;
        while (true) {
            int n3;
            int n4;
            block22: {
                block21: {
                    int[] nArray2 = this.f;
                    n4 = nArray2[n];
                    if (n2 >= n4) break;
                    n4 = a.a((InputStream)object);
                    if (byArray == null) break block21;
                    n3 = byArray.length;
                    if (n3 >= n4) break block22;
                }
                byArray = new byte[n4];
            }
            n3 = 0;
            Image[][] imageArray2 = null;
            ((InputStream)object).read(byArray, 0, n4);
            imageArray2 = this.a1013;
            imageArray2 = imageArray2[n];
            Image image = Image.createImage((byte[])byArray, (int)0, (int)n4);
            imageArray2[n2] = image;
            ++n2;
            continue;
            break;
        }
        try {
            ((InputStream)object).close();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void c(int n, int n2) {
        int n3;
        int n4;
        this.a1002.setColor(6396370);
        this.a1002.fillRect(0, 309, 240, 2);
        Image[] imageArray = this.a1013[3];
        int n5 = 4;
        Image image = imageArray[n5];
        int n6 = 18;
        int n7 = 311;
        int n8 = 6396370;
        int n9 = 1;
        a a2 = this;
        this.a(image, n6, n7, n8, n9 != 0);
        int n10 = -1;
        if (n != n10) {
            Image[] imageArray2 = this.a1013[3];
            n5 = 2;
            image = imageArray2[n5];
            n6 = 1;
            n7 = 310;
            n8 = 0;
            n9 = n * 10;
            n4 = 18;
            n3 = 10;
            a a3 = this;
            this.a(image, n6, n7, 0, n9, n4, n3, 0, 0);
        }
        if (n2 != (n10 = -1)) {
            Image[] imageArray3 = this.a1013[3];
            n5 = 2;
            image = imageArray3[n5];
            n6 = 221;
            n7 = 310;
            n8 = 0;
            n9 = n2 * 10;
            n4 = 18;
            n3 = 10;
            a a4 = this;
            this.a(image, n6, n7, 0, n9, n4, n3, 0, 0);
        }
        n10 = this.l;
        switch (n10) {
            default: {
                return;
            }
            case 4: 
            case 5: 
            case 20: 
            case 21: 
        }
        this.f();
    }

    private void c(int n, int n2, int n3) {
        int n4 = 25;
        int n5 = 4;
        Image image = this.a1013[n5][n4];
        int n6 = this.a1013[n5][n4].getHeight() / 10;
        int n7 = n * n6;
        int n8 = this.a1013[n5][n4].getWidth();
        int n9 = this.a1013[n5][n4].getHeight() / 10;
        n5 = n2;
        n4 = n3;
        this.a(image, n2, n3, 0, n7, n8, n9, 0, 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void c(int n, int n2, int n3, int n4) {
        int n5 = 3;
        int n6 = 2;
        boolean bl = true;
        byte[] byArray = this.q1100;
        int n7 = byArray[n3];
        if ((n7 = (int)(this.j(n7) ? 1 : 0)) == 0) {
            return;
        }
        int[][] nArray = this.c1107;
        int n8 = this.bt;
        int[] nArray2 = nArray[n8];
        nArray2[0] = n;
        nArray2[bl] = n2;
        nArray2[n6] = n3;
        nArray2[5] = n4;
        nArray2[n5] = 0;
        nArray2[6] = 0;
        nArray2[4] = n5;
        nArray2[7] = 0;
        nArray2[8] = 0;
        nArray2[14] = -1;
        nArray2[15] = 0;
        nArray2[13] = 0;
        nArray2[9] = n4;
        nArray2[16] = 0;
        nArray2[17] = 0;
        int n9 = this.bt;
        a a2 = this;
        n8 = n;
        n5 = n2;
        this.c(n, n2, n9, n3, bl);
        this.bt = n7 = this.bt + 1;
        this.bF = 0;
        this.aw = 0;
        this.b(n6);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(int n, int n2, int n3, int n4, int n5) {
        Graphics graphics = this.a1002;
        int n6 = 15455661;
        graphics.setColor(n6);
        switch (n5) {
            case 0: {
                this.a1002.setColor(0xFCFFCD);
                Graphics graphics2 = this.a1002;
                n6 = n3 - 1;
                graphics2.fillRect(n, n2, n6, n4);
                Image image = this.a1013[3][8];
                int n7 = image.getHeight();
                n6 = 0;
                Image image2 = null;
                while (true) {
                    int n8;
                    int n9;
                    if (n6 >= n3) {
                        image2 = this.a1013[3][9];
                        int n10 = n + 1;
                        int n11 = n2 + n7;
                        n9 = n3 - 2;
                        n8 = n4 - (n7 <<= 1);
                        a a2 = this;
                        this.a(image2, n10, n11, n9, n8);
                        return;
                    }
                    this.a1002.setClip(n, n2, n3, n4);
                    Graphics graphics3 = this.a1002;
                    Image image3 = this.a1013[3][8];
                    n9 = n + n6;
                    graphics3.drawImage(image3, n9, n2, 0);
                    graphics3 = this.a1002;
                    image3 = this.a1013[3][8];
                    n9 = n + n6;
                    n8 = n2 + n4 - n7 - 1;
                    graphics3.drawImage(image3, n9, n8, 0);
                    n6 += 50;
                }
            }
            case 1: {
                int n12 = 0;
                Object var6_10 = null;
                while (true) {
                    int n13;
                    int n14;
                    int n15;
                    int n16;
                    Graphics graphics4;
                    if (n12 >= (n6 = 3)) {
                        Image[] imageArray = this.a1013[3];
                        n6 = 9;
                        graphics4 = imageArray[n6];
                        n16 = n + 3;
                        n15 = n2 + 3;
                        n14 = n3 - 6;
                        n12 = 4;
                        n13 = n4 - n12;
                        a a3 = this;
                        this.a((Image)graphics4, n16, n15, n14, n13);
                        return;
                    }
                    graphics4 = this.a1002;
                    n16 = n + n12;
                    n15 = n2 + n12;
                    n14 = n12 << 1;
                    n14 = n3 - n14 - 1;
                    n13 = n12 << 1;
                    n13 = n4 - n13 + 1;
                    graphics4.drawRect(n16, n15, n14, n13);
                    ++n12;
                }
            }
            case 2: {
                Graphics graphics5 = this.a1002;
                n6 = 0xFCFFCD;
                graphics5.setColor(n6);
                this.a1002.fillRect(n, n2, n3, n4);
                Graphics graphics6 = this.a1002;
                Image image = this.a1013[4][9];
                int n17 = n + n3;
                Image[] imageArray = this.a1013[4];
                int n18 = 9;
                int n19 = imageArray[n18].getWidth();
                n17 -= n19;
                n19 = 0;
                imageArray = null;
                graphics6.drawImage(image, n17, n2, 0);
                return;
            }
            case 3: {
                this.a1002.setColor(0xFCFFCD);
                this.a1002.fillRect(n, n2, n3, n4);
                Image image = this.a1013[4][9];
                n6 = 1;
                this.a(image, n, n2, n6);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        byte by;
        int n16;
        byte[] byArray;
        int n17;
        byte[] byArray2;
        Image image;
        int n18;
        int n19;
        int n20 = 1;
        if (n4 == n20) {
            int n21;
            boolean bl = false;
            Object var8_26 = null;
            n19 = 0;
            while (n19 < (n21 = 3)) {
                Image[] imageArray = this.a1013[29];
                n18 = 43;
                image = imageArray[n18];
                n21 = this.t1118[n][0] + n2;
                byArray2 = this.s1117[n];
                n17 = byArray2[0] * n19 * 16;
                n21 += n17;
                n17 = this.bP;
                n17 = n21 - n17;
                n21 = this.t1118[n][1] + n3;
                byArray = this.s1117[n];
                n16 = byArray[1] * n19 * 16;
                n21 += n16;
                n16 = this.bQ;
                n16 = n21 - n16 + 13;
                by = 0;
                n15 = 0;
                n14 = 15;
                n13 = 20;
                n12 = 0;
                a a2 = this;
                this.a(image, n17, n16, 0, 0, n14, n13, 0, 0);
                n19 = n21 = n19 + 1;
            }
        }
        if (n6 == (n11 = 1) && n5 < (n10 = 3)) {
            int n22;
            boolean bl = false;
            Object var8_30 = null;
            n19 = 0;
            while (n19 < (n22 = 3)) {
                Image[] imageArray = this.a1013[29];
                n18 = 43;
                image = imageArray[n18];
                n22 = this.t1118[n][0] + n2;
                byArray2 = this.s1117[n];
                n17 = byArray2[0] * n19 * 16;
                n22 += n17;
                n17 = this.bP;
                n17 = n22 - n17;
                n22 = this.t1118[n][1] + n3 - 22;
                byArray = this.s1117[n];
                n16 = byArray[1] * n19 * 16;
                n22 += n16;
                n16 = this.bQ;
                n16 = n22 - n16 + 13;
                by = 0;
                n15 = 20;
                n14 = 15;
                n13 = 42;
                n12 = 0;
                a a3 = this;
                this.a(image, n17, n16, 0, n15, n14, n13, 0, 0);
                n19 = n22 = n19 + 1;
            }
        }
        if (n5 <= (n9 = 1) || n5 >= (n8 = 5) || n6 != (n7 = 1)) return;
        int n23 = 2;
        n19 = n5 - n23;
        switch (n) {
            case 0: {
                int n24;
                boolean bl = false;
                Object var8_35 = null;
                int n25 = 0;
                while (n25 < (n24 = 3)) {
                    Image[] imageArray = this.a1013[29];
                    n18 = 44;
                    image = imageArray[n18];
                    n24 = n25 * 16 + n2;
                    n17 = this.bP;
                    n17 = n24 - n17;
                    n24 = n3 - 37;
                    n16 = this.bQ;
                    n16 = n24 - n16 + 13;
                    by = 0;
                    n15 = this.h1121[n][n19][0];
                    n14 = 16;
                    n13 = this.h1121[n][n19][1];
                    n12 = 0;
                    a a4 = this;
                    this.a(image, n17, n16, 0, n15, n14, n13, 0, 0);
                    n25 = n24 = n25 + 1;
                }
                return;
            }
            case 1: {
                int n26;
                boolean bl = false;
                Object var8_39 = null;
                int n27 = 0;
                while (n27 < (n26 = 3)) {
                    Image[] imageArray = this.a1013[29];
                    n18 = 45;
                    image = imageArray[n18];
                    byte[] byArray3 = this.u1119[n19];
                    byArray2 = null;
                    n26 = byArray3[0] + n2;
                    n17 = this.bP;
                    n17 = n26 - n17;
                    n26 = this.u1119[n19][1] + n3;
                    n16 = n27 * 16;
                    n26 += n16;
                    n16 = this.bQ;
                    n16 = n26 - n16 + 13;
                    by = this.h1121[n][n19][0];
                    n15 = 0;
                    n14 = this.h1121[n][n19][1];
                    n13 = 18;
                    n12 = 1;
                    a a5 = this;
                    this.a(image, n17, n16, by, 0, n14, n13, n12, 0);
                    n27 = n26 = n27 + 1;
                }
                return;
            }
            case 2: {
                int n28;
                boolean bl = false;
                Object var8_44 = null;
                int n29 = 0;
                while (n29 < (n28 = 3)) {
                    Image[] imageArray = this.a1013[29];
                    n18 = 46;
                    image = imageArray[n18];
                    n28 = n29 * 16 + n2;
                    n17 = this.bP;
                    n17 = n28 - n17;
                    n28 = n3 + 30;
                    n16 = this.bQ;
                    n16 = n28 - n16 + 13;
                    by = 0;
                    n15 = this.h1121[n][n19][0];
                    n14 = 15;
                    n13 = this.h1121[n][n19][1];
                    n12 = 0;
                    a a6 = this;
                    this.a(image, n17, n16, 0, n15, n14, n13, 0, 0);
                    n29 = n28 = n29 + 1;
                }
                return;
            }
            case 3: {
                int n30;
                boolean bl = false;
                Object var8_48 = null;
                int n31 = 0;
                while (n31 < (n30 = 3)) {
                    Image[] imageArray = this.a1013[29];
                    n18 = 45;
                    image = imageArray[n18];
                    byte[] byArray4 = this.v1120[n19];
                    byArray2 = null;
                    n30 = byArray4[0] + n2;
                    n17 = this.bP;
                    n17 = n30 - n17;
                    n30 = this.v1120[n19][1] + n3;
                    n16 = n31 * 16;
                    n30 += n16;
                    n16 = this.bQ;
                    n16 = n30 - n16 + 13;
                    by = this.h1121[n][n19][0];
                    n15 = 0;
                    n14 = this.h1121[n][n19][1];
                    n13 = 18;
                    n12 = 0;
                    a a7 = this;
                    this.a(image, n17, n16, by, 0, n14, n13, 0, 0);
                    n31 = n30 = n31 + 1;
                }
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void c(int n, int n2, int n3, int n4, boolean bl) {
        byte[] byArray;
        int n5;
        if (bl) {
            byte[] byArray2;
            int n6;
            for (int i = 0; i < (n6 = (byArray2 = this.o1098)[n4]); ++i) {
                byte[] byArray3;
                int n7;
                byArray2 = null;
                for (n6 = 0; n6 < (n7 = (byArray3 = this.o1098)[n4]); ++n6) {
                    int n8;
                    int n9;
                    n7 = 110;
                    if (n3 < n7) {
                        byArray3 = this.E1163;
                        n9 = (i << 4) + n;
                        n8 = (n6 << 4) + n2;
                        n9 = this.a(n9, n8);
                        byArray3[n9] = n8 = (int)((byte)(n3 + 12));
                        continue;
                    }
                    byArray3 = this.E1163;
                    n9 = (i << 4) + n;
                    n8 = (n6 << 4) + n2;
                    n9 = this.a(n9, n8);
                    byArray3[n9] = n8 = (int)((byte)(98 - n3));
                }
            }
            return;
        }
        for (int i = 0; i < (n5 = (byArray = this.o1098)[n4]); ++i) {
            byte[] byArray4;
            byte by;
            byArray = null;
            for (n5 = 0; n5 < (by = (byArray4 = this.o1098)[n4]); ++n5) {
                byArray4 = this.E1163;
                int n10 = (i << 4) + n;
                int n11 = (n5 << 4) + n2;
                n10 = this.a(n10, n11);
                byArray4[n10] = n11 = 8;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(String string) {
        if (string == null) {
            this.H(0);
            return;
        } else {
            int n = string.length();
            this.H(n);
            for (int i = 0; i < n; ++i) {
                char c = string.charAt(i);
                this.I(c);
            }
        }
    }

    private void c(Image image, int n, int n2, int n3) {
        int n4 = 11;
        int n5 = n3 * 11;
        this.a(image, n, n2, n5, 0, n4, n4, 0, 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean c() {
        int n;
        boolean bl = true;
        boolean bl2 = false;
        RecordStore recordStore = null;
        Object object = "freeGame";
        ByteArrayInputStream byteArrayInputStream = null;
        recordStore = RecordStore.openRecordStore((String)object, (boolean)false);
        int n2 = 1;
        object = recordStore.getRecord(n2);
        byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        object = new DataInputStream(byteArrayInputStream);
        for (int i = 0; i < (n = 9); ++i) {
            boolean[] blArray = this.d1073;
            boolean bl3 = ((DataInputStream)object).readBoolean();
            blArray[i] = bl3;
            continue;
        }
        try {
            ((FilterInputStream)object).close();
            byteArrayInputStream.close();
            recordStore.closeRecordStore();
            return bl;
        }
        catch (Exception exception) {
            if (recordStore == null) return false;
            try {
                recordStore.closeRecordStore();
            }
            catch (Exception exception2) {
                return false;
            }
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean c(int n) {
        byte[] byArray = this.E1163;
        int n2 = byArray[n] & 1;
        if (n2 != 0) return 0 != 0;
        return 1 != 0;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean c(int n, int n2) {
        void var3_6;
        byte by;
        byte[] byArray = this.E1163;
        int n3 = this.a(n, n2);
        byte by2 = byArray[n3];
        if (by2 != (by = 11)) return (boolean)var3_6;
        return (boolean)var3_6;
    }

    /*
     * Exception decompiling
     */
    private int d() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 13[TRYBLOCK] [26, 27 : 135->139)] java.lang.Exception
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int d(int n) {
        byte[] byArray = this.E1163;
        int n2 = byArray[n];
        int n3 = 12;
        if (n2 >= n3) {
            byArray = this.E1163;
            return byArray[n] - n3;
        }
        byArray = this.E1163;
        n2 = byArray[n];
        n3 = -12;
        if (n2 > n3) return -1;
        byte[] byArray2 = this.E1163;
        n3 = byArray2[n];
        return 98 - n3;
    }

    private static int d(int n, int n2, int n3) {
        return n2 * n3 + n;
    }

    private void d() {
        int n = 25;
        int n2 = 15;
        int n3 = 3;
        this.a1002.setColor(0xFCFFCD);
        Graphics graphics = this.a1002;
        int n4 = 13;
        int n5 = 210;
        int n6 = 297;
        graphics.fillRect(n2, n4, n5, n6);
        graphics = null;
        for (int i = 0; i < (n4 = 10); ++i) {
            Graphics graphics2 = this.a1002;
            Image image = this.a1013[n3][n];
            n6 = (i << 5) + 13;
            graphics2.drawImage(image, n2, n6, 0);
            graphics2 = this.a1013[n3][n];
            n5 = 216;
            n6 = (i << 5) + 13;
            int n7 = 1;
            this.a((Image)graphics2, n5, n6, n7);
        }
    }

    private void d(int n) {
        int n2;
        for (int i = 0; i < (n2 = 3); ++i) {
            Graphics graphics = this.a1002;
            Image image = this.a1013[4][6];
            int n3 = this.u;
            int n4 = i * 176;
            n3 += n4;
            n4 = this.v + n;
            graphics.drawImage(image, n3, n4, 0);
        }
    }

    private void d(int n, int n2) {
        int n3 = 3;
        int n4 = 2;
        int n5 = 1;
        int n6 = 4;
        this.a1002.setClip(0, 0, 240, 320);
        Graphics graphics = this.a1002;
        Image image = this.a1013[n6][n5];
        int n7 = this.a1013[n6][n5].getHeight();
        n7 = n2 - n7;
        graphics.drawImage(image, n, n7, 0);
        graphics = this.a1002;
        image = this.a1013[n6][n4];
        n7 = this.a1013[n6][n5].getWidth() + n;
        int n8 = this.a1013[n6][n4].getHeight();
        n8 = n2 - n8;
        graphics.drawImage(image, n7, n8, 0);
        graphics = this.a1002;
        image = this.a1013[n6][0];
        n7 = this.a1013[n6][n5].getWidth() + n;
        n8 = this.a1013[n6][n4].getWidth();
        n7 += n8;
        n8 = this.a1013[n6][0].getHeight();
        n8 = n2 - n8;
        graphics.drawImage(image, n7, n8, 0);
        graphics = this.a1002;
        image = this.a1013[n6][n3];
        n7 = this.a1013[n6][n5].getWidth() + n;
        n8 = this.a1013[n6][n4].getWidth();
        n7 += n8;
        n8 = this.a1013[n6][0].getWidth();
        n7 = n7 + n8 + 15;
        n8 = this.a1013[n6][n3].getHeight();
        n8 = n2 - n8;
        graphics.drawImage(image, n7, n8, 0);
        this.a1002.setColor(14834304);
        this.a1002.fillRect(0, n2, 240, 20);
    }

    private void d(int n, int n2, int n3) {
        long l = 1L;
        int n4 = 24;
        int n5 = 3;
        Graphics graphics = this.a1002;
        Image image = this.a1013[n5][n4];
        int n6 = ((int)(this.a1019 & l) << 1) + n;
        graphics.drawImage(image, n6, n3, 0);
        graphics = this.a1013[n5][n4];
        int n7 = (int)(this.a1019 & l) << 1;
        n7 = n2 - n7;
        this.a((Image)graphics, n7, n3, 1);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void d(int n, int n2, int n3, int n4) {
        void var10_18;
        int n5;
        int n6;
        int n7;
        int n8;
        void var10_11;
        int n9 = 16382577;
        int n10 = 3;
        int n11 = 4;
        int n12 = 1;
        int n13 = this.o1098[n] << 3;
        boolean bl = false;
        Object var11_20 = null;
        while (var10_11 < n11) {
            n8 = n3 + n13;
            byte[] byArray = this.w1110;
            int n14 = var10_11 << 1;
            n7 = byArray[n14];
            n8 += n7;
            n7 = n4 + n13;
            byte[] byArray2 = this.w1110;
            n6 = (var10_11 << 1) + true;
            n14 = byArray2[n6];
            n7 += n14;
            n14 = this.bu;
            this.p(n8, n7, n14);
            ++var10_11;
        }
        if (n2 != n10) {
            if (n2 != n11) return;
            Image image = this.a1013[n10][21];
            n8 = n3 + n13;
            n7 = this.bP;
            n8 -= n7;
            n7 = n4 + 13;
            int n15 = this.bQ;
            n7 -= n15;
            int n16 = this.bu << 1;
            this.b(image, n8, n7 -= n16, n11);
            return;
        }
        int n17 = this.bu;
        byte[] byArray = this.v1109;
        n8 = byArray.length;
        if (n17 < n8 && (n5 = this.bu) > 0) {
            int n18;
            n11 = 0;
            while (n11 < (n18 = 7)) {
                n18 = n3 + n13;
                byte[][] byArray3 = this.p1108;
                n7 = this.bu - n12;
                byte[] byArray4 = byArray3[n7];
                n7 = n11 << 1;
                n8 = byArray4[n7];
                n18 += n8;
                n8 = this.bP;
                n8 = n18 - n8;
                n18 = n4 + n13;
                byte[][] byArray5 = this.p1108;
                int n19 = this.bu - n12;
                byte[] byArray6 = byArray5[n19];
                n19 = (n11 << 1) + 1;
                n7 = byArray6[n19];
                n18 += n7;
                n7 = this.bQ;
                n7 = n18 - n7 + 13;
                byte[] byArray7 = this.v1109;
                int n19 = this.bu - n12;
                n19 = byArray7[n19] << 1;
                n6 = 16422227;
                a a2 = this;
                this.g(n8, n7, n19, n6, n9);
                n11 = n18 = n11 + 1;
            }
            return;
        }
        int n20 = this.bu;
        if (n20 != 0) return;
        byte[] byArray8 = this.o1098;
        byte by = byArray8[n];
        n8 = 2;
        if (by == n8) {
            int n21 = 19;
        } else {
            int n22 = 25;
        }
        n8 = n3 + n13 - var10_18;
        n7 = this.bP;
        n8 -= n7;
        n7 = n4 + n13 - var10_18;
        int n23 = this.bQ;
        n7 = n7 - n23 + 13;
        void var14_35 = var10_18 << 1;
        n6 = 16422227;
        a a3 = this;
        this.g(n8, n7, (int)var14_35, n6, n9);
    }

    private void d(int n, int n2, int n3, int n4, int n5) {
        Image image = this.a1013[3][15];
        int n6 = n << 4;
        this.a(image, n2, n3, n6, 0, n4, n5);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void d(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        switch (n3) {
            case 2: 
            case 3: 
            case 5: 
            case 8: 
            case 9: {
                void var15_51;
                int n8 = this.w1123[n3].length;
                Image[][] imageArray = this.a1013;
                int n9 = n3 + 18;
                Image[] imageArray2 = imageArray[n9];
                n9 = 1;
                Image image = imageArray2[n9];
                a a2 = this;
                int n10 = n;
                int n11 = n2;
                int n12 = n3;
                int n13 = n4;
                this.a(image, n, n2, n3, n4, n8);
                int n14 = 8;
                if (n3 != n14) {
                    int n15 = 5;
                    if (n3 != n15) return;
                }
                byte[][] byArray = this.w1123;
                n9 = n3 - 1;
                int n16 = byArray[n9].length;
                Image[][] imageArray3 = this.a1013;
                n9 = n3 + 18;
                Image[] imageArray4 = imageArray3[n9];
                n9 = 2;
                image = imageArray4[n9];
                int n17 = 5;
                if (n3 == n17) {
                    byte[] byArray2 = this.x1124;
                    byte by = byArray2[n4];
                } else {
                    boolean bl = false;
                    Object var8_19 = null;
                }
                int n18 = n2 + var15_51;
                int n19 = 1;
                n12 = n3 - n19;
                a a3 = this;
                n10 = n;
                n13 = n4;
                this.a(image, n, n18, n12, n4, n16);
            }
            default: {
                return;
            }
            case 0: 
            case 4: 
        }
        int n20 = 6;
        if (n6 != n20) return;
        if (n5 < 0) return;
        int n21 = 3;
        if (n5 > n21) return;
        Image[] imageArray = this.a1013[18];
        int n22 = n5 + 1;
        Image image = imageArray[n22];
        byte[] byArray = this.y1125;
        int n23 = n5 << 2;
        byte by = byArray[n23];
        n23 = n + by;
        byte[] byArray3 = this.y1125;
        int n25 = (n5 << 2) + 1;
        n25 = byArray3[n25] + n2 + 13;
        byte[][] byArray4 = this.w1123;
        int n26 = 0;
        Object var16_60 = null;
        byte[] byArray5 = byArray4[0];
        byte by2 = byArray5[n4];
        if (n5 == 0) {
            n26 = 0;
            Object var16_61 = null;
        } else {
            byte[] byArray6 = this.y1125;
            n7 = (n5 << 2) + 2;
            n26 = byArray6[n7];
        }
        n26 *= by2;
        n7 = 0;
        byte[] byArray7 = this.y1125;
        int n27 = (n5 << 2) + 2;
        byte by3 = byArray7[n27];
        byte[] byArray8 = this.y1125;
        int n28 = (n5 << 2) + 3;
        byte by4 = byArray8[n28];
        a a4 = this;
        this.a(image, n23, n25, n26, 0, by3, by4, 0, 0);
        int n29 = 2;
        if (n4 <= n29) return;
        int n30 = 10;
        if (n4 >= n30) return;
        Graphics graphics = this.a1002;
        image = this.a1013[18][5];
        byte[] byArray9 = this.y1125;
        int n31 = n5 << 2;
        n23 = byArray9[n31] + n + 2;
        byte[] byArray10 = this.y1125;
        n26 = (n5 << 2) + 1;
        int n32 = byArray10[n26] + n2;
        n26 = this.a1013[18][5].getHeight();
        int n33 = n32 - n26;
        byte[][] byArray11 = this.w1123;
        n7 = 0;
        n26 = byArray11[0][n4];
        int n34 = n33 - n26 + 13;
        n26 = 0;
        Object var16_64 = null;
        graphics.drawImage(image, n23, n34, 0);
    }

    private void d(Image image, int n, int n2, int n3) {
        int n4 = 0;
        int n5 = 0;
        while (n5 < (n4 = 3)) {
            n4 = 0;
            int n6 = 0;
            while (n6 < (n4 = 3)) {
                n4 = n5 << 4;
                int n7 = this.m1084[n][0];
                n4 = n4 * n7 + n2;
                n7 = this.m1084[n][2];
                n4 = n4 + n7 + 3;
                n7 = this.bP;
                int n8 = n4 - n7;
                n4 = n6 << 4;
                n7 = this.m1084[n][1];
                n4 = n4 * n7 + n3;
                n7 = this.m1084[n][3];
                n4 = n4 + n7 + 3;
                n7 = this.bQ;
                int n9 = n4 - n7 + 13;
                int n10 = 9;
                int n11 = 9;
                this.a(image, n8, n9, 0, 0, n10, n11, 0, 0);
                n6 = n4 = n6 + 1;
            }
            n5 = n4 = n5 + 1;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean d() {
        boolean bl = true;
        int n = this.by;
        if (n <= 0) {
            this.s1088 = false;
            return (int)(bl ? 1 : 0) != 0;
        }
        this.s1088 = bl;
        return 0 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean d(int n) {
        int n2;
        int n3;
        int n4;
        int[] nArray;
        int n5;
        int n6;
        int n7;
        block18: {
            block19: {
                boolean[] blArray;
                block20: {
                    block21: {
                        n7 = 5;
                        n6 = 3;
                        n5 = 1;
                        blArray = this.f1106;
                        nArray = this.c1107[n];
                        n4 = 2;
                        int n8 = nArray[n4];
                        n3 = blArray[n8];
                        if (n3 != 0) break block18;
                        n3 = nArray[n6];
                        if (n3 < n7) {
                            n3 = nArray[n4];
                            byte[] byArray = this.r1101;
                            n2 = nArray[n6];
                            n2 = this.a(n3, byArray, n2);
                            if ((n2 = (int)(this.j(n2) ? 1 : 0)) != 0) {
                                return n5 != 0;
                            }
                            this.o = 0;
                            return 0 != 0;
                        }
                        n3 = nArray[n6];
                        if (n3 != n7) break block19;
                        n3 = nArray[n4];
                        if (n3 == 0) {
                            n3 = this.e() ? 1 : 0;
                            if (n3 != 0) {
                                n3 = nArray[n4];
                                byte[] byArray = this.r1101;
                                n6 = nArray[n6];
                                n3 = this.a(n3, byArray, n6);
                                if ((n3 = (int)(this.j(n3) ? 1 : 0)) != 0) {
                                    blArray = this.f1106;
                                    n2 = nArray[n4];
                                    blArray[n2] = n5;
                                    return n5 != 0;
                                }
                                this.o = 0;
                                return 0 != 0;
                            }
                            this.o = n7;
                            return 0 != 0;
                        }
                        n3 = this.ac;
                        switch (n3) {
                            default: {
                                return 0 != 0;
                            }
                            case 0: {
                                n3 = nArray[n4];
                                n8 = 6;
                                if (n3 >= n8) break block20;
                                blArray = this.f1106;
                                n3 = blArray[0];
                                if (n3 != 0) {
                                    n3 = nArray[n4];
                                    byte[] byArray = this.r1101;
                                    n6 = nArray[n6];
                                    n3 = this.a(n3, byArray, n6);
                                    if ((n3 = (int)(this.j(n3) ? 1 : 0)) == 0) break;
                                    blArray = this.f1106;
                                    n2 = nArray[n4];
                                    blArray[n2] = n5;
                                    return n5 != 0;
                                }
                                break block21;
                            }
                            case 1: {
                                n3 = nArray[n4];
                                n8 = 6;
                                if (n3 < n8) {
                                    n3 = nArray[n4];
                                    byte[] byArray = this.r1101;
                                    n6 = nArray[n6];
                                    n3 = this.a(n3, byArray, n6);
                                    if ((n3 = (int)(this.j(n3) ? 1 : 0)) != 0) {
                                        blArray = this.f1106;
                                        n2 = nArray[n4];
                                        blArray[n2] = n5;
                                        return n5 != 0;
                                    }
                                    this.o = 0;
                                    return 0 != 0;
                                }
                                blArray = this.f1106;
                                n3 = blArray[0];
                                if (n3 != 0) {
                                    n3 = nArray[n4];
                                    byte[] byArray = this.r1101;
                                    n6 = nArray[n6];
                                    n3 = this.a(n3, byArray, n6);
                                    if ((n3 = (int)(this.j(n3) ? 1 : 0)) != 0) {
                                        blArray = this.f1106;
                                        n2 = nArray[n4];
                                        blArray[n2] = n5;
                                        return n5 != 0;
                                    }
                                    this.o = 0;
                                    return 0 != 0;
                                }
                                this.o = n2 = 6;
                                return 0 != 0;
                            }
                        }
                        this.o = 0;
                        return 0 != 0;
                    }
                    this.o = n2 = 6;
                    return 0 != 0;
                }
                n3 = nArray[n4];
                byte[] byArray = this.r1101;
                n6 = nArray[n6];
                n3 = this.a(n3, byArray, n6);
                if ((n3 = (int)(this.j(n3) ? 1 : 0)) != 0) {
                    blArray = this.f1106;
                    n2 = nArray[n4];
                    blArray[n2] = n5;
                    return n5 != 0;
                }
                this.o = 0;
                return 0 != 0;
            }
            this.o = n2 = 4;
            return 0 != 0;
        }
        n3 = nArray[n6];
        if (n3 < n7) {
            n3 = nArray[n4];
            byte[] byArray = this.r1101;
            n2 = nArray[n6];
            n2 = this.a(n3, byArray, n2);
            if ((n2 = (int)(this.j(n2) ? 1 : 0)) != 0) {
                return n5 != 0;
            }
            this.o = 0;
            return 0 != 0;
        }
        this.o = n2 = 4;
        return 0 != 0;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean d(int n, int n2) {
        void var3_6;
        byte[] byArray = this.E1163;
        int n4 = this.a(n, n2);
        n4 = byArray[n4] & 1;
        if (n4 != 0) return (boolean)var3_6;
        return (boolean)var3_6;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final int e(int n) {
        int n2;
        int n3 = 97;
        int n4 = 65;
        int n5 = 48;
        if (n >= n5 && n <= (n2 = 57)) {
            return n - n5;
        }
        if (n >= n3 && n <= (n2 = 122)) {
            return n - n3 + 10;
        }
        if (n >= n4 && n <= (n2 = 90)) {
            return n - n4 + 10;
        }
        Exception exception = new Exception();
        throw exception;
    }

    private void e() {
        this.p();
        this.a1002.setColor(12493976);
        this.a1002.fillRect(0, 13, 240, 297);
        this.d();
    }

    private final void e(int n) {
        int n2;
        while ((n2 = this.am) < n) {
            this.am = n2 = this.am + 1;
            n2 = 1;
            this.m1033 = n2;
            this.repaint();
            this.serviceRepaints();
        }
        n2 = this.am;
        int n3 = 100;
        if (n2 == n3) {
            this.m1033 = false;
            this.am = 0;
        }
    }

    private void e(int n, int n2) {
        int n3;
        int n4 = 5;
        int n5 = 4;
        for (int i = 0; i < (n3 = 15); ++i) {
            Graphics graphics = this.a1002;
            Image image = this.a1013[n5][n5];
            int n6 = this.a1013[n5][n5].getWidth() * i + n;
            Image image2 = this.a1013[n5][n5];
            int n7 = image2.getHeight();
            n7 = n2 - n7;
            graphics.drawImage(image, n6, n7, 0);
            graphics = this.a1002;
            image = this.a1013[n5][n4];
            Image image3 = this.a1013[n5][n4];
            n6 = image3.getWidth() * i + n;
            graphics.drawImage(image, n6, n2, 0);
        }
    }

    private void e(int n, int n2, int n3) {
        Image image = this.a1013[4][17];
        int n4 = n * 12;
        this.a(image, n2, n3, 0, n4, 20, 12, 0, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void e(int n, int n2, int n3, int n4) {
        int n5 = 240;
        switch (n3) {
            default: {
                break;
            }
            case 0: 
            case 1: 
            case 3: 
            case 4: 
            case 5: 
            case 7: {
                this.a1002.setClip(0, 13, n5, 276);
                Graphics graphics = this.a1002;
                int[] nArray = this.l1116;
                int n6 = this.aN;
                int n7 = nArray[n6];
                graphics.setColor(n7);
                byte[] byArray = this.t1103;
                int n8 = this.a(n3, byArray, n4);
                Graphics graphics2 = this.a1002;
                byte[] byArray2 = this.o1098;
                n7 = (byArray2[n3] << 3) + n - n8;
                n6 = this.bP;
                n7 -= n6;
                byte[] byArray3 = this.o1098;
                n6 = (byArray3[n3] << 3) + n2 - n8;
                int n9 = this.bQ;
                n6 = n6 - n9 + 13;
                n9 = n8 << 1;
                int n10 = 360;
                graphics2.drawArc(n7, n6, n9, n8 <<= 1, 0, n10);
            }
        }
        this.a1002.setClip(0, 0, n5, 320);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void e(int n, int n2, int n3, int n4, int n5) {
        Graphics graphics = this.a1002;
        graphics.setColor(7438477);
        int n6 = this.o;
        int n7 = -1;
        if (n6 == n7) {
            n6 = 17;
            if (n == n6) {
                n7 = this.ay;
                a a2 = this;
                this.b(n7, n2, n3, n4, n5);
                return;
            }
            String[] stringArray = this.b1015;
            n7 = n + 2;
            String string = stringArray[n7];
            a a3 = this;
            this.a(string, 0, n2, n3, n4, n5);
            return;
        }
        n7 = this.o;
        a a4 = this;
        this.a(n7, n2, n3, n4, n5);
    }

    private void e(Image image, int n, int n2, int n3) {
        int n4 = 0;
        int n5 = 0;
        while (n5 < (n4 = 3)) {
            n4 = 0;
            int n6 = 0;
            while (n6 < (n4 = 3)) {
                n4 = n5 << 4;
                int n7 = this.m1084[n][0];
                n4 = n4 * n7 + n2;
                Object object = this.m1084[n];
                n7 = object[2];
                n4 += n7;
                n7 = n6 << 4;
                int n8 = this.m1084[n][1];
                n7 = n7 * n8 + n3;
                n8 = this.m1084[n][3];
                byte[] byArray = this.D1162;
                int n9 = this.a(n4, n7 += n8);
                n8 = byArray[n9];
                if (n8 >= (n9 = 6)) {
                    n8 = this.bP;
                    n8 = n4 - n8;
                    n4 = this.bQ;
                    n4 = n7 - n4;
                    n9 = n4 + 13;
                    int n10 = 15;
                    int n11 = 16;
                    object = image;
                    this.a(image, n8, n9, 0, 0, n10, n11, 0, 0);
                }
                n6 = n4 = n6 + 1;
            }
            n5 = n4 = n5 + 1;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean e() {
        int n;
        int n2 = 0;
        while (n2 < (n = 5)) {
            boolean[] blArray = this.a1056;
            n = blArray[n2];
            if (n == 0) {
                return 0 != 0;
            }
            ++n2;
        }
        return 1 != 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private boolean e(int var1_1) {
        var2_2 = 6;
        var3_3 = 3;
        var4_4 = 1;
        var5_5 = 2;
        var6_6 /* !! */  = this.c1107;
        var7_7 = var6_6 /* !! */ [var1_1];
        var8_8 = var7_7[0];
        var9_9 /* !! */  = this.o1098;
        var10_10 = var7_7[var5_5];
        var11_11 = var9_9 /* !! */ [var10_10] << 3;
        var12_12 = var8_8 + var11_11;
        var8_8 = var7_7[var4_4];
        var9_9 /* !! */  = this.o1098;
        var10_10 = var7_7[var5_5];
        var11_11 = var9_9 /* !! */ [var10_10] << 3;
        var13_13 = var8_8 + var11_11;
        var8_8 = var7_7[var5_5];
        var9_9 /* !! */  = this.t1103;
        var10_10 = var7_7[var3_3];
        var14_14 = this.a(var8_8, var9_9 /* !! */ , var10_10);
        var8_8 = var7_7[var5_5];
        switch (var8_8) lbl-1000:
        // 5 sources

        {
            default: lbl-1000:
            // 3 sources

            {
                while (true) {
                    var8_8 = 0;
                    var6_6 /* !! */  = null;
lbl27:
                    // 2 sources

                    return (boolean)var8_8;
                }
            }
            case 0: 
            case 1: 
            case 3: 
            case 4: 
            case 5: 
            case 7: {
                var15_15 = 0;
                while (var15_15 < (var8_8 = this.aP)) {
                    var6_6 /* !! */  = this.b1066;
                    var9_9 /* !! */  = (byte[])this.o1153;
                    var11_11 = var9_9 /* !! */ [var15_15];
                    var16_17 = var6_6 /* !! */ [var11_11];
                    var11_11 = var16_17[0];
                    var10_10 = var16_17[var4_4];
                    var6_6 /* !! */  = (int[][])this;
                    var8_8 = (int)this.a(var11_11, var10_10, var12_12, var13_13, var14_14);
                    if (var8_8 == 0 || (var8_8 = (int)a.f(var16_17[8])) == 0) ** GOTO lbl58
                    var8_8 = var7_7[var5_5];
                    var9_9 /* !! */  = this.u1104;
                    var10_10 = var7_7[var3_3];
                    var7_7[var2_2] = var8_8 = this.a(var8_8, var9_9 /* !! */ , var10_10);
                    var8_8 = var7_7[4];
                    if (var8_8 != var2_2) ** GOTO lbl52
                    var8_8 = 14;
                    var7_7[var8_8] = var11_11 = var7_7[var8_8] + 1;
                    if (var11_11 <= var3_3) ** GOTO lbl56
                    var8_8 = 14;
                    var7_7[var8_8] = var11_11 = 10;
lbl52:
                    // 2 sources

                    var8_8 = 8;
                    var9_9 /* !! */  = (byte[])this.o1153;
                    var7_7[var8_8] = var11_11 = var9_9 /* !! */ [var15_15];
                    this.v(var1_1);
lbl56:
                    // 2 sources

                    var8_8 = var4_4;
                    ** continue;
lbl58:
                    // 1 sources

                    var15_15 = var8_8 = var15_15 + 1;
                }
                var8_8 = var7_7[4];
                if (var8_8 != var2_2 || (var8_8 = var7_7[14]) <= 0 || (var8_8 = var7_7[14]) >= (var11_11 = 10)) ** GOTO lbl-1000
                var8_8 = 14;
                var7_7[var8_8] = var11_11 = var7_7[var8_8] + 1;
                ** GOTO lbl-1000
            }
            case 2: 
            case 6: {
                var8_8 = var7_7[0];
                var11_11 = var7_7[var4_4];
                var10_10 = var7_7[5];
                if ((var8_8 = (int)this.a(var8_8, var11_11, var10_10, false)) == 0) ** GOTO lbl-1000
                var8_8 = var7_7[var5_5];
                var9_9 /* !! */  = this.u1104;
                var10_10 = var7_7[var3_3];
                var7_7[var2_2] = var8_8 = this.a(var8_8, var9_9 /* !! */ , var10_10);
                this.v(var1_1);
                ** GOTO lbl-1000
            }
            case 8: 
            case 9: 
        }
        var8_8 = var7_7[var5_5];
        var11_11 = var7_7[var3_3];
        var8_8 = (int)this.p(var8_8, var11_11);
        if (var8_8 != 0) {
            var15_16 = 0;
            while (var15_16 < (var8_8 = this.aP)) {
                var16_18 = this.b1066[var15_16];
                var11_11 = var16_18[0];
                var10_10 = var16_18[var4_4];
                var6_6 /* !! */  = (int[][])this;
                var8_8 = (int)this.a(var11_11, var10_10, var12_12, var13_13, var14_14);
                if (var8_8 != 0 && (var8_8 = (int)a.f(var16_18[8])) != 0) {
                    var8_8 = 15;
                    var16_18[var8_8] = var11_11 = 48;
                }
                var15_16 = var8_8 = var15_16 + 1;
            }
        }
        var8_8 = var7_7[0];
        var11_11 = var7_7[var4_4];
        var10_10 = var7_7[5];
        if ((var8_8 = (int)this.a(var8_8, var11_11, var10_10, (boolean)var4_4)) == 0) ** GOTO lbl-1000
        var8_8 = var7_7[var5_5];
        var9_9 /* !! */  = this.u1104;
        var10_10 = var7_7[var3_3];
        var7_7[var2_2] = var8_8 = this.a(var8_8, var9_9 /* !! */ , var10_10);
        this.v(var1_1);
        ** while (true)
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean e(int n, int n2) {
        void var3_6;
        byte by;
        byte[] byArray = this.E1163;
        int n3 = this.a(n, n2);
        byte by2 = byArray[n3];
        if (by2 != (by = 8)) return (boolean)var3_6;
        return (boolean)var3_6;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void f() {
        int n = 10;
        int n2 = 7;
        int n3 = 3;
        int n4 = 310;
        int n5 = this.a1007;
        int n6 = this.b1008;
        if (n5 <= n6) return;
        n5 = this.a1007;
        n6 = this.b1008;
        this.p = (n5 /= n6) > n ? (n5 = 30) : (n5 = 25);
        n6 = this.p;
        int n7 = 240 - n6 >> 1;
        this.a1002.setColor(0xFCFFCD);
        this.a1002.setClip(0, 0, 240, 320);
        Graphics graphics = this.a1002;
        n6 = this.p;
        graphics.fillRect(n7, n4, n6, n);
        Image image = this.a1013[n3][13];
        int n8 = n7 + 10;
        int n9 = 50;
        a a2 = this;
        this.a(image, n8, 312, n9, 0, n2, n2, 0, 0);
        Image image2 = this.a1013[n3][24];
        n6 = n7 + 8;
        long l = this.a1019;
        long l2 = 1L;
        n8 = ((int)(l &= l2) << 1) + 302;
        n = 6;
        this.a(image2, n6, n8, n);
        n5 = this.c;
        n6 = this.b1008;
        n5 = n5 / n6 + 1;
        n6 = n7 + 2;
        this.b(n5, n6, n4);
        n5 = this.a1007;
        n6 = this.b1008;
        n5 = n5 + n6 - 1;
        n6 = this.b1008;
        n5 /= n6;
        n6 = n7 + 18;
        this.b(n5, n6, n4);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void f(int n) {
        if (n >= 0) {
            byte by = this.a1038;
            if (n < by) {
                Image image;
                int[] nArray = this.a1039[n];
                int[][] nArray2 = this.a1039;
                int[][] nArray3 = this.a1039;
                byte by2 = this.a1038;
                byte by3 = 1;
                this.a1038 = by2 = (byte)(by2 - by3);
                int[] nArray4 = nArray3[by2];
                nArray2[n] = nArray4;
                int[][] nArray5 = this.a1039;
                byte by4 = this.a1038;
                nArray5[by4] = nArray;
                this.a1040[n] = null;
                Image[] imageArray = this.a1040;
                Image[] imageArray2 = this.a1040;
                by4 = this.a1038;
                imageArray[n] = image = imageArray2[by4];
                Image[] imageArray3 = this.a1040;
                byte by5 = this.a1038;
                imageArray3[by5] = null;
            }
            return;
        }
        boolean bl = false;
        Object var3_7 = null;
        this.a1038 = 0;
        this.a1040 = null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void f(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        Object var5_7;
        int n9;
        int n10 = this.n1036;
        if (n10 == 0) {
            this.x();
            n10 = 1;
            this.n1036 = n10;
        }
        this.z();
        if (n == 0 || n2 < (n10 = 18)) {
            byte[] byArray;
            byte[] byArray2;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            int n17;
            int n18;
            int n19;
            Image image;
            int n20;
            switch (n2) {
                case 1: {
                    if (n == 0) {
                        n10 = 0;
                        Object var17_31 = null;
                        n20 = 1;
                        this.g(0, n20);
                    } else {
                        n10 = 1;
                        n20 = 1;
                        this.g(n10, n20);
                    }
                    Image[] imageArray = this.a1013[1];
                    n20 = 1;
                    image = imageArray[n20];
                    n19 = 120;
                    n18 = 0;
                    n17 = 1;
                    n16 = 12;
                    n15 = 4;
                    n14 = 120;
                    n13 = this.g1035[0];
                    n12 = 0;
                    n11 = -1;
                    a a2 = this;
                    this.a(image, n19, 0, n17, n16, n15, n14, n13, 0, n11);
                    break;
                }
                case 5: {
                    n10 = 0;
                    this.f(0);
                    Image[] imageArray = this.a1013[1];
                    n20 = 0;
                    image = imageArray[0];
                    n19 = 120;
                    n18 = this.g1035[0];
                    n17 = 2;
                    n16 = 12;
                    n15 = 4;
                    n14 = 4;
                    n13 = 0;
                    n12 = 0;
                    n11 = -1;
                    a a3 = this;
                    this.a(image, n19, n18, n17, n16, n15, n14, 0, 0, n11);
                    break;
                }
                case 8: {
                    image = this.a1013[1][5];
                    n10 = this.g1035[0];
                    n18 = n10 + 2;
                    byArray2 = null;
                    a a4 = this;
                    this.a(image, 120, n18, 0, 12, 0, 0, 0, 0, 0);
                    image = this.a1013[1][2];
                    n18 = this.g1035[1];
                    a a5 = this;
                    this.a(image, 90, n18, 2, 4, 4, 4, 0, 0, -1);
                    image = this.a1013[1][3];
                    n18 = this.g1035[1];
                    a a6 = this;
                    this.a(image, 120, n18, 2, 4, 4, 4, 0, 0, -1);
                    image = this.a1013[1][4];
                    n18 = this.g1035[1];
                    a a7 = this;
                    this.a(image, 150, n18, 2, 4, 4, 4, 0, 0, -1);
                    Image[] imageArray = this.a1013[1];
                    n20 = 6;
                    image = imageArray[n20];
                    n19 = 15;
                    n18 = this.g1035[1];
                    n17 = 1;
                    n16 = 12;
                    n15 = 3;
                    n14 = this.ao;
                    n13 = this.g1035[2];
                    n12 = 0;
                    n11 = -1;
                    a a8 = this;
                    this.a(image, n19, n18, n17, n16, n15, n14, n13, 0, n11);
                    break;
                }
                case 10: {
                    n10 = 5;
                    this.f(n10);
                    image = null;
                    n19 = this.ao;
                    n18 = this.g1035[2];
                    byArray = null;
                    n14 = 0;
                    byArray2 = null;
                    n13 = 0;
                    n12 = 0;
                    n11 = -1;
                    a a9 = this;
                    this.a(null, n19, n18, 3, 0, 0, 0, 0, 0, n11);
                    n20 = 5;
                    n19 = 4;
                    n18 = 0;
                    n17 = 1;
                    n16 = 2;
                    n15 = 0;
                    this.b(n20, n19, 0, n17, n16, 0);
                    break;
                }
                case 14: {
                    n16 = this.ao - 8;
                    n15 = this.g1035[2];
                    a a10 = this;
                    this.b(5, 3, 0, 3, n16, n15);
                    n20 = 6;
                    n19 = 3;
                    n18 = 0;
                    n17 = 3;
                    n10 = this.ao;
                    byArray = this.c1037;
                    n16 = byArray[2];
                    n10 += n16;
                    n16 = n10 - 4;
                    n15 = this.g1035[2];
                    a a11 = this;
                    this.b(n20, n19, 0, n17, n16, n15);
                    break;
                }
                case 15: {
                    n20 = 7;
                    n19 = 3;
                    n18 = 0;
                    n17 = 2;
                    n10 = this.ao;
                    byArray = this.c1037;
                    n16 = byArray[4];
                    n10 += n16;
                    n16 = n10 - 2;
                    n15 = this.g1035[2];
                    a a12 = this;
                    this.b(n20, n19, 0, n17, n16, n15);
                    break;
                }
                case 17: {
                    n16 = this.ao;
                    n15 = this.g1035[2];
                    a a13 = this;
                    this.b(5, 3, 0, 3, n16, n15);
                    n10 = this.ao;
                    n16 = this.c1037[2] + n10;
                    n15 = this.g1035[2];
                    a a14 = this;
                    this.b(6, 3, 0, 3, n16, n15);
                    n20 = 7;
                    n19 = 3;
                    n18 = 0;
                    n17 = 2;
                    n10 = this.ao;
                    byArray = this.c1037;
                    n16 = byArray[4] + n10;
                    n15 = this.g1035[2];
                    a a15 = this;
                    this.b(n20, n19, 0, n17, n16, n15);
                    break;
                }
            }
            n10 = 10;
            if (n2 >= n10 && n2 < (n10 = 13)) {
                n20 = 0;
                image = null;
                n19 = 240;
                n18 = this.g1035[2];
                n17 = 3;
                n16 = 0;
                byArray = null;
                n15 = 4;
                n10 = this.ao;
                byArray2 = this.c1037;
                n13 = n2 - 9 << 1;
                n14 = byArray2[n13] + n10;
                n13 = this.g1035[2];
                n10 = 9;
                n12 = n2 - n10;
                n11 = -1;
                a a16 = this;
                this.a(null, n19, n18, n17, 0, n15, n14, n13, n12, n11);
                return;
            }
            n10 = 14;
            if (n2 >= n10 && n2 <= (n10 = 17)) {
                n20 = 0;
                image = null;
                n10 = this.ao;
                byte[] byArray3 = this.c1037;
                n18 = n2 - 10 << 1;
                n19 = byArray3[n18] + n10;
                n18 = 320;
                n17 = 3;
                n16 = 0;
                byArray = null;
                n15 = 4;
                n10 = this.ao;
                byArray2 = this.c1037;
                n13 = n2 - 10 << 1;
                n14 = byArray2[n13] + n10;
                n13 = this.g1035[2];
                n10 = 10;
                n12 = n2 - n10;
                n11 = -1;
                a a17 = this;
                this.a(null, n19, n18, n17, 0, n15, n14, n13, n12, n11);
                return;
            }
            n10 = 25;
            if (n2 < n10) return;
            n10 = 31;
            if (n2 > n10) return;
            n12 = (n2 - 25 << 1) + 8;
            n20 = 0;
            image = null;
            n10 = this.ao;
            byte[] byArray4 = this.c1037;
            n18 = n12 << 1;
            n19 = byArray4[n18] + n10;
            n18 = this.g1035[2];
            n17 = 3;
            n16 = 0;
            byArray = null;
            n15 = 0;
            n10 = this.ao;
            byArray2 = this.c1037;
            n13 = n12 << 1;
            n14 = byArray2[n13] + n10;
            n13 = this.g1035[2];
            n11 = -1;
            a a18 = this;
            this.a(null, n19, n18, n17, 0, 0, n14, n13, n12, n11);
            n10 = 31;
            if (n2 >= n10) return;
            n20 = 0;
            image = null;
            n10 = this.ao;
            byArray4 = this.c1037;
            n18 = ++n12 << 1;
            n19 = byArray4[n18] + n10;
            n18 = this.g1035[2];
            n17 = 3;
            n16 = 0;
            byArray = null;
            n15 = 0;
            n10 = this.ao;
            byArray2 = this.c1037;
            n13 = n12 << 1;
            n14 = byArray2[n13] + n10;
            n13 = this.g1035[2];
            n11 = -1;
            a a19 = this;
            this.a(null, n19, n18, n17, 0, 0, n14, n13, n12, n11);
            return;
        }
        n10 = 18;
        if (n2 >= n10 && n2 < (n10 = 31)) {
            n9 = 0;
            var5_7 = null;
            n10 = this.ao;
            byte[] byArray = this.c1037;
            n8 = n2 - 10 << 1;
            n7 = byArray[n8] + n10;
            n8 = 320;
            n6 = 3;
            n5 = 0;
            Object var10_17 = null;
            n4 = 4;
            n10 = this.ao;
            byte[] byArray5 = this.c1037;
            int n21 = n2 - 10 << 1;
            n3 = byArray5[n21] + n10;
            n21 = this.g1035[2];
            n10 = 10;
            int n22 = n2 - n10;
            int n23 = -1;
            a a20 = this;
            this.a(null, n7, n8, n6, 0, n4, n3, n21, n22, n23);
        }
        switch (n2) {
            case 50: {
                n9 = 2;
                n7 = 2;
                n8 = 4;
                n6 = 4;
                n5 = 4;
                n4 = 1;
                a a21 = this;
                this.b(n9, n7, n8, n6, n5, n4);
                break;
            }
            case 51: {
                n9 = 3;
                n7 = 2;
                n8 = 4;
                n6 = 4;
                n5 = 4;
                n4 = 1;
                a a22 = this;
                this.b(n9, n7, n8, n6, n5, n4);
                break;
            }
            case 52: {
                n9 = 4;
                n7 = 2;
                n8 = 4;
                n6 = 4;
                n5 = 4;
                n4 = 1;
                a a23 = this;
                this.b(n9, n7, n8, n6, n5, n4);
                break;
            }
            case 58: {
                var5_7 = null;
                a a24 = this;
                this.b(0, 1, 0, 1, 1000, 1000);
                n9 = 1;
                n7 = 2;
                n8 = 4;
                n6 = 4;
                n5 = 4;
                n4 = 1;
                this.b(n9, n7, n8, n6, n5, n4);
                break;
            }
            case 63: {
                n9 = 15;
                n7 = 3;
                n8 = 0;
                n6 = 4;
                n5 = -10;
                n4 = this.g1035[2];
                a a25 = this;
                this.b(n9, n7, 0, n6, n5, n4);
                break;
            }
        }
        if (n2 <= (n10 = 52)) return;
        n10 = 63;
        if (n2 >= n10) return;
        n3 = n2 - 52;
        n9 = n3 + 4;
        n4 = this.g1035[2];
        a a26 = this;
        this.b(n9, 3, 0, 4, -10, n4);
        n10 = 26;
        n9 = n10 - n3;
        n7 = 3;
        n8 = 0;
        n6 = 4;
        n5 = 240;
        n4 = this.g1035[2];
        a a27 = this;
        this.b(n9, n7, 0, n6, n5, n4);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void f(int var1_1, int var2_2, int var3_3) {
        var4_4 = this;
        var5_5 /* !! */  = var4_4 = this.a1013;
        var6_6 = var4_4[4][21].getWidth() / 9;
        var4_4 = this;
        var5_5 /* !! */  = var4_4 = this.a1013;
        var7_7 = var4_4[4][21].getHeight();
        var4_4 = this;
        var5_5 /* !! */  = var4_4 = this.a1002;
        var8_8 /* !! */  = null;
        var4_4.setClip(0, 0, 240, 320);
        var4_4 = this;
        var5_5 /* !! */  = var4_4 = this.a1002;
        var4_4.setColor(0xFCFFCD);
        var4_4 = this;
        var5_5 /* !! */  = var4_4 = this.a1002;
        var9_9 = var6_6 + 3;
        var11_11 = var10_10 /* !! */  = var7_7 + 3;
        var4_4.drawRect(var2_2, var3_3, var9_9, var10_10 /* !! */ );
        var4_4 = this;
        var5_5 /* !! */  = var4_4 = this.a1013;
        var12_12 /* !! */  = var4_4[4][21];
        var10_10 /* !! */  = var2_2 + 2;
        var13_13 = var3_3 + 2;
        var14_14 = var6_6 * var1_1;
        var15_15 /* !! */  = 0;
        var16_16 /* !! */  = null;
        var17_17 /* !! */  = 0;
        var18_18 /* !! */  = null;
        var19_19 = 0;
        var20_20 = null;
        var5_5 /* !! */  = this;
        super.a((Image)var12_12 /* !! */ , var10_10 /* !! */ , var13_13, var14_14, 0, var6_6, var7_7, 0, 0);
        var4_4 = this;
        var5_5 /* !! */  = this.a1002;
        var4_4 = this;
        var12_12 /* !! */  = var4_4 = this.a1013;
        var12_12 /* !! */  = var4_4[4][22];
        var10_10 /* !! */  = var2_2 - 3;
        var21_21 = null;
        var4_4 = var5_5 /* !! */ ;
        var5_5 /* !! */ .drawImage((Image)var12_12 /* !! */ , var10_10 /* !! */ , var3_3, 0);
        var4_4 = this;
        var5_5 /* !! */  = var4_4 = this.a1013;
        var5_5 /* !! */  = var4_4[4][22];
        var9_9 = var2_2 + var6_6 - 7;
        var4_4 = this;
        var11_11 = 1;
        super.a((Image)var5_5 /* !! */ , var9_9, var3_3, var11_11);
        var5_5 /* !! */  = var4_4 = this.a1013;
        var5_5 /* !! */  = var4_4[4][22];
        var9_9 = var2_2 - 3;
        var10_10 /* !! */  = var3_3 + var7_7 - 11;
        var4_4 = this;
        var11_11 = 2;
        super.a((Image)var5_5 /* !! */ , var9_9, var10_10 /* !! */ , var11_11);
        var5_5 /* !! */  = var4_4 = this.a1013;
        var5_5 /* !! */  = var4_4[4][22];
        var9_9 = var2_2 + var6_6 - 7;
        var10_10 /* !! */  = var3_3 + var7_7 - 11;
        var13_13 = 3;
        var4_4 = this;
        var11_11 = var13_13;
        super.a((Image)var5_5 /* !! */ , var9_9, var10_10 /* !! */ , var13_13);
        var5_5 /* !! */  = null;
        for (var22_22 = 0; var22_22 < (var9_9 = 8); ++var22_22) {
            var9_9 = var2_2 + var6_6 + 10;
            var10_10 /* !! */  = var22_22 & 3;
            var4_4 = this;
            var21_21 = var4_4 = this.a1013;
            var13_13 = var4_4[4][23].getWidth();
            var9_9 += (var10_10 /* !! */  *= var13_13);
            var10_10 /* !! */  = var22_22 >> 2;
            var4_4 = this;
            var21_21 = var4_4 = this.a1013;
            var21_21 = var4_4[4];
            var14_14 = 23;
            var13_13 = var21_21[var14_14].getHeight();
            var10_10 /* !! */  = var10_10 /* !! */  * var13_13 + var3_3;
            var4_4 = this;
            var21_21 = this.a1002;
            var4_4 = this;
            var23_23 = var4_4 = this.a1013;
            var23_23 = var4_4[4][23];
            var15_15 /* !! */  = 0;
            var16_16 /* !! */  = null;
            var21_21.drawImage((Image)var23_23, var9_9, var10_10 /* !! */ , 0);
        }
        var22_22 = 0;
        var5_5 /* !! */  = null;
        var4_4 = this;
        var9_9 = var24_24 = this.aN;
        var10_10 /* !! */  = 1;
        if (var24_24 <= var10_10 /* !! */ ) ** GOTO lbl-1000
        var9_9 = var24_24 = this.aN;
        var10_10 /* !! */  = 6;
        if (var24_24 < var10_10 /* !! */ ) {
            var12_12 /* !! */  = (Graphics)this.z1131;
            var4_4 = this;
            var10_10 /* !! */  = var24_24 = this.aN;
            var12_12 /* !! */  = var12_12 /* !! */ [var24_24];
            var9_9 = ((Image[][])var12_12 /* !! */ ).length >> 1;
            var8_8 /* !! */  = this.A1132;
            var4_4 = this;
            var13_13 = var24_24 = this.X;
            var8_8 /* !! */  = (byte[][])var8_8 /* !! */ [var24_24];
            var13_13 = var24_24 = this.aN;
            var10_10 /* !! */  = (int)var8_8 /* !! */ [var24_24];
            var13_13 = 1;
            if (var10_10 /* !! */  == var13_13) {
                var22_22 = var9_9;
            }
lbl111:
            // 4 sources

            while (true) {
                var8_8 /* !! */  = null;
                for (var10_10 /* !! */  = 0; var10_10 /* !! */  < var9_9; ++var10_10 /* !! */ ) {
                    var13_13 = var2_2 + var6_6 + 10;
                    var14_14 = var10_10 /* !! */  & 3;
                    var4_4 = this;
                    var16_16 /* !! */  = var4_4 = this.a1013;
                    var15_15 /* !! */  = var4_4[4][23].getWidth();
                    var13_13 += (var14_14 *= var15_15 /* !! */ );
                    var14_14 = var10_10 /* !! */  >> 2;
                    var4_4 = this;
                    var16_16 /* !! */  = var4_4 = this.a1013;
                    var15_15 /* !! */  = var4_4[4][23].getHeight();
                    var14_14 = var14_14 * var15_15 /* !! */  + var3_3;
                    var4_4 = this;
                    var16_16 /* !! */  = (Graphics)this.z1131;
                    var4_4 = this;
                    var7_7 = var24_24 = this.aN;
                    var16_16 /* !! */  = var16_16 /* !! */ [var24_24];
                    var7_7 = var10_10 /* !! */  + var22_22;
                    var15_15 /* !! */  = (int)var16_16 /* !! */ [var7_7];
                    super.q(var15_15 /* !! */ , var13_13 += 3, var14_14 += 3);
                }
                break;
            }
        } else lbl-1000:
        // 2 sources

        {
            var4_4 = this;
            var5_5 /* !! */  = (Graphics)this.z1131;
            var4_4 = this;
            var9_9 = var24_24 = this.aN;
            var22_22 = var5_5 /* !! */ [var24_24].length;
            var12_12 /* !! */  = null;
            var9_9 = var22_22;
            var22_22 = 0;
            var5_5 /* !! */  = null;
            ** continue;
        }
        var8_8 /* !! */  = null;
        for (var10_10 /* !! */  = 0; var10_10 /* !! */  < var9_9; ++var10_10 /* !! */ ) {
            var13_13 = var2_2 + var6_6 + 10;
            var14_14 = var10_10 /* !! */  & 3;
            var4_4 = this;
            var16_16 /* !! */  = var4_4 = this.a1013;
            var15_15 /* !! */  = var4_4[4][23].getWidth();
            var13_13 += (var14_14 *= var15_15 /* !! */ );
            var14_14 = var10_10 /* !! */  >> 2;
            var4_4 = this;
            var16_16 /* !! */  = var4_4 = this.a1013;
            var16_16 /* !! */  = var4_4[4];
            var7_7 = 23;
            var16_16 /* !! */  = var16_16 /* !! */ [var7_7];
            var15_15 /* !! */  = var16_16 /* !! */ .getHeight();
            var14_14 = var14_14 * var15_15 /* !! */  + var3_3;
            var4_4 = this;
            var15_15 /* !! */  = var24_24 = this.ag;
            if (var10_10 /* !! */  != var24_24) continue;
            var16_16 /* !! */  = var4_4 = this.a1002;
            var4_4.setClip(0, 0, 240, 320);
            var4_4 = this;
            var16_16 /* !! */  = var4_4 = this.a1002;
            var4_4.setColor(0xFCFFCD);
            var4_4 = this;
            var16_16 /* !! */  = this.a1002;
            var7_7 = var14_14 + 20;
            var4_4 = this;
            var17_17 /* !! */  = this.k;
            var20_20 = this.b1015;
            var4_4 = this;
            var25_25 /* !! */  = this.z1131;
            var4_4 = this;
            var24_24 = this.aN;
            var25_25 /* !! */  = (byte[][])var25_25 /* !! */ [var24_24];
            var26_26 = var25_25 /* !! */ [var10_10 /* !! */ ] + 28;
            var20_20 = var20_20[var26_26];
            var19_19 = var20_20.length();
            var17_17 /* !! */  *= var19_19;
            var19_19 = var24_24 = this.j;
            var16_16 /* !! */ .fillRect(var13_13, var7_7, var17_17 /* !! */ , var24_24);
            var16_16 /* !! */  = var4_4 = this.a1002;
            var7_7 = 5465994;
            var4_4.setColor(var7_7);
            var4_4 = this;
            var16_16 /* !! */  = this.a1002;
            var4_4 = this;
            var27_27 /* !! */  = this.b1015;
            var4_4 = this;
            var18_18 /* !! */  = this.z1131;
            var4_4 = this;
            var19_19 = var24_24 = this.aN;
            var18_18 /* !! */  = (byte[][])var18_18 /* !! */ [var24_24];
            var19_19 = var10_10 /* !! */  + var22_22;
            var17_17 /* !! */  = (int)(var18_18 /* !! */ [var19_19] + 28);
            var27_27 /* !! */  = var27_27 /* !! */ [var17_17 /* !! */ ];
            var17_17 /* !! */  = 0;
            var18_18 /* !! */  = null;
            var16_16 /* !! */ .drawString((String)var27_27 /* !! */ , var13_13, var14_14 += 20, 0);
        }
    }

    private void f(int n, int n2, int n3, int n4) {
        block4: {
            byte by;
            byte by2;
            byte by3;
            int n5;
            int n6;
            int n7;
            Image image;
            byte by4;
            Object object;
            int n8;
            block3: {
                n8 = 3;
                if (n4 < n8) {
                    object = this.a1013[29];
                    by4 = this.I1142[n3][0];
                    image = object[by4];
                    n8 = this.k1141[n4][n3][0] + n;
                    n7 = this.bP;
                    n7 = n8 - n7;
                    n8 = this.k1141[n4][n3][1] + n2;
                    n6 = this.bQ;
                    n6 = n8 - n6 + 13;
                    n8 = this.I1142[n3][2];
                    n5 = n4 * n8;
                    by3 = this.I1142[n3][2];
                    by2 = this.I1142[n3][3];
                    by = this.I1142[n3][1];
                    object = this;
                    this.a(image, n7, n6, n5, 0, by3, by2, by, 0);
                }
                if (n4 <= 0 || n4 >= (n8 = 3)) break block3;
                n8 = 0;
                object = null;
                int n9 = 0;
                while (n9 < (n8 = 2)) {
                    object = this.a1013[29];
                    by4 = this.l1143[n3][n9][0];
                    image = object[by4];
                    n8 = this.l1143[n3][n9][1] + n;
                    n7 = this.bP;
                    n7 = n8 - n7;
                    n8 = this.l1143[n3][n9][2] + n2;
                    n6 = this.bQ;
                    n6 = n8 - n6 + 13;
                    n8 = this.l1143[n3][n9][4];
                    n5 = n4 * n8;
                    by3 = this.l1143[n3][n9][4];
                    by2 = this.l1143[n3][n9][5];
                    by = this.l1143[n3][n9][3];
                    object = this;
                    this.a(image, n7, n6, n5, 0, by3, by2, by, 0);
                    n9 = n8 = n9 + 1;
                }
                break block4;
            }
            n8 = 3;
            if (n4 < n8 || n4 >= (n8 = 6)) break block4;
            int n10 = n8 = 2;
            while (n10 < (n8 = 4)) {
                object = this.a1013[29];
                by4 = this.l1143[n3][n10][0];
                image = object[by4];
                n8 = this.l1143[n3][n10][1] + n;
                n7 = this.bP;
                n7 = n8 - n7;
                n8 = this.l1143[n3][n10][2] + n2;
                n6 = this.bQ;
                n6 = n8 - n6 + 13;
                n8 = n4 - 3;
                byte[] byArray = this.l1143[n3][n10];
                n5 = byArray[4] * n8;
                by3 = this.l1143[n3][n10][4];
                by2 = this.l1143[n3][n10][5];
                by = this.l1143[n3][n10][3];
                object = this;
                this.a(image, n7, n6, n5, 0, by3, by2, by, 0);
                n10 = n8 = n10 + 1;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void f(int n, int n2, int n3, int n4, int n5) {
        int n6;
        int n7 = 3;
        if (n5 == n7) {
            int n8;
            n6 = n8 = 1;
        } else {
            boolean bl = false;
            Object var9_15 = null;
            n6 = 0;
        }
        int n9 = n & 1;
        Graphics graphics = this.a1002;
        int[] nArray = this.k1071;
        int n10 = this.aN;
        int n11 = nArray[n10];
        graphics.setColor(n11);
        Graphics graphics2 = this.a1002;
        n11 = this.c1090[n][n5][0] + n2;
        n10 = this.d1091[n][n5][0];
        n11 += n10;
        n10 = this.c1090[n][n5][1] + n3;
        byte[] byArray = this.d1091[n][n5];
        int n12 = byArray[1];
        graphics2.fillArc(n11, n10 += n12, 12, 12, 0, 360);
        Image[][] imageArray = this.a1013;
        n11 = this.bj;
        Image image = imageArray[n11][n9];
        byte[] byArray2 = this.d1091[n][n5];
        byte by = byArray2[0];
        n10 = n2 + by;
        byte by2 = this.d1091[n][n5][1];
        n12 = n3 + by2;
        int n13 = this.a1092[n][n5][n4][0];
        int n14 = this.a1092[n][n5][n4][1];
        Image[][] imageArray2 = this.a1013;
        int n15 = this.bj;
        n9 = imageArray2[n15][n9].getHeight();
        n15 = 0;
        a a2 = this;
        this.a(image, n10, n12, n13, 0, n14, n9, n6, 0);
        int n16 = n & 1;
        n11 = 1;
        if (n16 != n11) return;
        Image[] imageArray3 = this.a1013[31];
        n11 = 9;
        Image image2 = imageArray3[n11];
        n10 = n2 - 11;
        n12 = n3 - 23;
        long l = this.a1019;
        long l2 = 3;
        int n17 = (int)(l &= l2);
        n13 = n17 * 22;
        n14 = 22;
        n9 = 34;
        n6 = 0;
        n15 = 0;
        a a3 = this;
        this.a(image2, n10, n12, n13, 0, n14, n9, 0, 0);
    }

    private void f(Image image, int n, int n2, int n3) {
        int n4 = 12;
        int n5 = this.bP;
        int n6 = n - n5;
        n5 = this.bQ;
        int n7 = n2 - n5 + 13;
        int n8 = n3 * 10;
        this.a(image, n6, n7, n8, 0, 10, n4, 0, n4);
    }

    private boolean f() {
        boolean bl = true;
        this.aw();
        this.au();
        this.E1179 = bl;
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean f(int n) {
        int n2 = 5;
        if (n == n2) return 0 != 0;
        n2 = 6;
        if (n == n2) return 0 != 0;
        n2 = 8;
        if (n == n2) return 0 != 0;
        n2 = 4;
        if (n == n2) return 0 != 0;
        return 1 != 0;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean f(int n, int n2) {
        void var3_6;
        byte by;
        byte[] byArray = this.E1163;
        int n3 = this.a(n, n2);
        byte by2 = byArray[n3];
        if (by2 != (by = 10)) return (boolean)var3_6;
        return (boolean)var3_6;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void g() {
        int n = 100;
        int n2 = 20;
        int n3 = 1;
        int n4 = 0;
        int n5 = this.h1047;
        switch (n5) {
            case -3: 
            case 52: {
                this.q = n5 = this.q - n2;
                if (n5 < n2) {
                    this.q = 0;
                    this.l1031 = false;
                }
                VolumeControl volumeControl = this.a1017;
                n4 = this.q;
                volumeControl.setLevel(n4);
                return;
            }
            case -4: 
            case 54: {
                this.q = n5 = this.q + 20;
                if (n5 > n) {
                    this.q = n;
                }
                this.l1031 = n3;
                VolumeControl volumeControl = this.a1017;
                n4 = this.q;
                volumeControl.setLevel(n4);
                return;
            }
            case -6: 
            case -5: 
            case 53: {
                this.a();
                n5 = this.l;
                if (n5 != n3) return;
                n5 = 7;
                n4 = -1;
                this.g(n5, n4);
                return;
            }
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void g(int n) {
        int n2;
        block18: {
            Object object;
            Player player;
            int n3;
            block17: {
                int n4;
                block16: {
                    int[] nArray;
                    n4 = 1;
                    n3 = 0;
                    player = null;
                    if (n < 0) {
                        return;
                    }
                    n2 = this.ap;
                    if (n2 >= n4) {
                        nArray = this.h1041;
                        int n5 = this.i1044[0];
                        n2 = nArray[n5];
                        object = this.i1044;
                        Player player2 = object[0];
                        this.i((int)player2);
                    } else {
                        nArray = null;
                        for (n2 = 0; n2 < n4; ++n2) {
                            object = this.a1043[0];
                            if (object != null) continue;
                            n2 = 0;
                            nArray = null;
                            break block16;
                        }
                        n2 = 0;
                        nArray = null;
                    }
                }
                object = this.i1044;
                n3 = this.ap;
                object[n3] = (Player)n;
                object = this.h1041;
                object[n] = (Player)n2;
                object = this.a1042;
                this.getClass();
                player = c1045;
                player = player[n];
                player = Display.getResourceAsStream((String)player);
                object[n2] = player;
                object = this.a1043;
                player = this.a1042;
                player = player[n2];
                Object object2 = c1045;
                object2 = object2[n];
                String string = "wav";
                n4 = ((String)object2).endsWith(string) ? 1 : 0;
                object2 = n4 != 0 ? "audio/x-wav" : "audio/midi";
                player = Manager.createPlayer((InputStream)player, (String)object2);
                object[n2] = player;
                try {
                    object = this.a1043;
                    object = object[n2];
                    object.realize();
                }
                catch (Exception exception) {}
                while (true) {
                    object = this.a1043;
                    object = object[n2];
                    int n6 = object.getState();
                    n3 = 300;
                    if (n6 == n3) break;
                    try {
                        object = this.a1043;
                        object = object[n2];
                        object.prefetch();
                    }
                    catch (Exception exception) {}
                }
                try {
                    object = this.a1042;
                    object = object[n2];
                    ((InputStream)object).close();
                    break block17;
                }
                catch (Exception exception) {}
                catch (Exception exception) {}
                break block18;
            }
            try {
                object = this.a1042;
                n3 = 0;
                player = null;
                object[n2] = null;
            }
            catch (Exception exception) {}
        }
        this.ap = n2 = this.ap + 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void g(int n, int n2) {
        Player player;
        int n3 = 1;
        if (n < 0) return;
        int n4 = this.as;
        int n5 = 8;
        if (n4 < n5 && n == (n4 = this.aq)) {
            return;
        }
        n4 = this.l1031 ? 1 : 0;
        if (n4 == 0) return;
        n4 = this.aq;
        if (n != n4 && (n4 = this.aq) != (n5 = -1)) {
            n4 = this.aq;
            this.h(n4);
        }
        this.g(n);
        n4 = this.aq;
        if (n == n4) {
            for (n4 = this.ap - n3; n4 >= 0; n4 += -1) {
                int[] nArray = this.i1044;
                n5 = nArray[n4];
                if (n5 != n) continue;
                while (n4 > 0) {
                    int n6;
                    int[] nArray2 = this.i1044;
                    int[] nArray3 = this.i1044;
                    int n7 = n4 - n3;
                    nArray2[n4] = n6 = nArray3[n7];
                    n4 += -1;
                }
                player = (Player)this.i1044;
                n5 = 0;
                Object var6_9 = null;
                player[0] = (Player)n;
                break;
            }
            try {
                player = this.a1043;
                int[] nArray = this.h1041;
                n5 = nArray[n];
                n4 = (player = player[n5]).getState();
                if (n4 == (n5 = 400)) return;
            }
            catch (Exception exception) {}
        }
        this.aq = n;
        player = this.a1043;
        n5 = this.h1041[n];
        player = player[n5];
        String string = "VolumeControl";
        player = (VolumeControl)player.getControl(string);
        this.a1017 = player;
        player = this.a1017;
        n5 = this.q;
        player.setLevel(n5);
        try {
            player = this.a1043;
            int[] nArray = this.h1041;
            n5 = nArray[n];
            player = player[n5];
            player.setLoopCount(n2);
        }
        catch (Exception exception) {}
        try {
            player = this.a1043;
            int[] nArray = this.h1041;
            n5 = nArray[n];
            player = player[n5];
            player.start();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void g(int n, int n2, int n3) {
        Image image = this.a1013[3][18];
        int n4 = n * 11;
        this.a(image, n2, n3, 0, n4, 35, 11, 0, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void g(int n, int n2, int n3, int n4) {
        int n5 = 2;
        int n6 = 1;
        int n7 = 6;
        int n8 = 3;
        int n9 = 0;
        while (n9 < n8) {
            block5: for (int i = 0; i < n8; ++i) {
                int n10 = n9 << 4;
                int n11 = this.m1084[n][0];
                n10 = n10 * n11 + n2;
                byte[] byArray = this.m1084[n];
                n11 = byArray[n5];
                n10 += n11;
                n11 = this.bP;
                n10 -= n11;
                n11 = i << 4;
                int n12 = this.m1084[n][n6];
                n11 = n11 * n12 + n3;
                byte[] byArray2 = this.m1084[n];
                n12 = byArray2[n8];
                n11 += n12;
                n12 = this.bQ;
                n11 = n11 - n12 + 13;
                switch (n) {
                    case 0: 
                    case 2: {
                        if (n4 >= 0 && n4 < (n12 = 7) && i == 0) {
                            this.r(n10, n11, n4);
                        }
                        if (n4 > n8 && n4 < (n12 = 10) && i == n6) {
                            n12 = n4 - n8;
                            this.r(n10, n11, n12);
                        }
                        if (n4 > n7 && n4 < (n12 = 12) && i == n5) {
                            n12 = n4 - n7;
                            this.r(n10, n11, n12);
                        }
                    }
                    default: {
                        continue block5;
                    }
                    case 1: 
                    case 3: {
                        if (n4 >= 0 && n4 < (n12 = 7) && n9 == 0) {
                            this.r(n10, n11, n4);
                        }
                        if (n4 > n8 && n4 < (n12 = 10) && n9 == n6) {
                            n12 = n4 - n8;
                            this.r(n10, n11, n12);
                        }
                        if (n4 <= n7 || n4 >= (n12 = 12) || n9 != n5) continue block5;
                        n12 = n4 - n7;
                        this.r(n10, n11, n12);
                    }
                }
            }
            ++n9;
        }
        return;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void g(int n, int n2, int n3, int n4, int n5) {
        int n6 = 360;
        int n7 = 1;
        Graphics graphics = this.a1002;
        int n8 = 240;
        int n9 = 320;
        graphics.setClip(0, 0, n8, n9);
        int n10 = 2;
        if (n3 > n10) {
            this.a1002.setColor(n4);
            graphics = this.a1002;
            n8 = n;
            n9 = n2;
            int n11 = n3;
            int n12 = n3;
            graphics.fillArc(n, n2, n3, n3, 0, n6);
            this.a1002.setColor(n5);
            graphics = this.a1002;
            n8 = n + 1;
            n9 = n2 + 1;
            n11 = n3 - n7;
            n12 = n3 - n7;
            graphics.fillArc(n8, n9, n11, n12, 0, n6);
            return;
        }
        this.a1002.setColor(n5);
        graphics = this.a1002;
        graphics.fillRect(n, n2, n3, n3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean g() {
        int n = 1;
        int n2 = this.b();
        switch (n2) {
            case 1: 
            case 2: {
                this.bY = n2 = this.bY + 1;
            }
            default: {
                return 0 != 0;
            }
            case 0: {
                this.bY = 0;
                try {
                    Object object = this.I1189;
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
                    object = new DataInputStream;
                    ((DataInputStream)object)(byteArrayInputStream);
                    int n3 = this.ca;
                    int n4 = 200;
                    if (n3 == n4 && (n3 = (int)((DataInputStream)object).readByte()) == (n4 = 2) && (n3 = (int)((DataInputStream)object).readByte()) == n) {
                        String string;
                        this.b1177 = string = a.a((DataInputStream)object);
                        this.c1178 = string = a.a((DataInputStream)object);
                        n3 = ((DataInputStream)object).readByte();
                        if (n3 == n) {
                            n3 = n;
                        } else {
                            n3 = 0;
                            string = null;
                        }
                        this.F1180 = n3;
                        this.d1181 = string = a.a((DataInputStream)object);
                        n3 = ((DataInputStream)object).readByte();
                        if (n3 == n) {
                            n3 = n;
                        } else {
                            n3 = 0;
                            string = null;
                        }
                        this.G1182 = n3;
                        this.e1183 = string = a.a((DataInputStream)object);
                        this.ax();
                    }
                    ((FilterInputStream)object).close();
                    byteArrayInputStream.close();
                    return n != 0;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                return n != 0;
            }
            case -1: {
                n2 = this.bZ;
                int n5 = 3;
                if (n2 >= n5) {
                    return n != 0;
                }
                this.a((byte)n);
            }
        }
        return 0 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean g(int n) {
        boolean bl = 6 != 0;
        if (n != bl) return false;
        return true;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean g(int n, int n2) {
        void var3_6;
        byte by;
        byte[] byArray = this.E1163;
        int n3 = this.a(n, n2);
        byte by2 = byArray[n3];
        if (by2 != (by = 11)) return (boolean)var3_6;
        return (boolean)var3_6;
    }

    private void h() {
        int n = 104;
        int n2 = 240;
        int n3 = 320;
        this.a1002.setClip(0, 0, n2, n3);
        this.a1002.setColor(0xFFFFFF);
        this.a1002.fillRect(0, 0, n2, n3);
        int n4 = this.b1015[n].length();
        int n5 = this.k;
        n4 *= n5;
        n4 = n2 - n4 >> 1;
        n5 = this.j;
        n5 = n3 - n5 >> 1;
        this.a1002.setColor(14834304);
        Graphics graphics = this.a1002;
        String string = this.b1015[n];
        graphics.drawString(string, n4, n5, 0);
        this.a1002.setColor(5465994);
        Graphics graphics2 = this.a1002;
        String string2 = this.b1015[105];
        int n6 = this.j;
        n6 = n3 - n6;
        graphics2.drawString(string2, 0, n6, 0);
        graphics2 = this.a1002;
        string2 = this.b1015[106];
        n6 = this.k << 1;
        n6 = n2 - n6;
        int n7 = this.j;
        n7 = n3 - n7;
        graphics2.drawString(string2, n6, n7, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void h(int n) {
        if (n < 0) {
            return;
        }
        int[] nArray = this.h1041;
        int n2 = nArray[n];
        if (n2 < 0) return;
        n2 = 0;
        Object var2_3 = null;
        try {
            this.as = 0;
            Player[] playerArray = this.a1043;
            int[] nArray2 = this.h1041;
            int n3 = nArray2[n];
            Player player = playerArray[n3];
            n2 = player.getState();
            if (n2 != (n3 = 400)) return;
            Player[] playerArray2 = this.a1043;
            nArray2 = this.h1041;
            n3 = nArray2[n];
            Player player2 = playerArray2[n3];
            player2.stop();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void h(int n, int n2) {
        Graphics graphics = this.a1002;
        Object var4_25 = null;
        boolean bl = false;
        Object var6_45 = null;
        int n3 = 240;
        int n4 = 320;
        graphics.setClip(0, 0, n3, n4);
        Image image = this.a1013[3][12];
        int n5 = image.getHeight();
        int n6 = this.l;
        int n7 = 22;
        if (n6 == n7) {
            int n8;
            int n9 = this.bb;
            int n10 = 18;
            this.q(n9, n10, 293);
            Graphics graphics2 = this.a1002;
            Image image2 = this.a1013[3][28];
            boolean bl2 = false;
            Object var6_46 = null;
            int n11 = 299;
            n4 = 0;
            graphics2.drawImage(image2, 0, n11, 0);
            boolean bl3 = false;
            Object var3_6 = null;
            int n12 = 0;
            Object var13_99 = null;
            while (n12 < (n8 = 2)) {
                Image image3 = this.a1013[3][12];
                int n13 = n12 * 60 + 120;
                int n14 = n2 + 1;
                n4 = n12 * 9;
                int n15 = 9;
                a a2 = this;
                this.a(image3, n13, n14, n4, 0, n15, n5, 0, 0);
                int[][] nArray = this.b1066;
                Object var4_29 = null;
                int[] nArray2 = nArray[0];
                int n16 = n12 + 2;
                n8 = nArray2[n16];
                n16 = n12 * 60 + 131;
                this.b(n8, n16, n2);
                n12 = n8 = n12 + 1;
            }
            return;
        }
        int n17 = this.l;
        int n18 = 23;
        if (n17 == n18) {
            int n19 = this.X * 11 + 0;
            int n20 = 18;
            int n21 = 293;
            this.q(n19, n20, n21);
            return;
        }
        int n22 = this.az;
        int n23 = -1;
        if (n22 != n23) {
            int n24;
            int[][] nArray = this.b1066;
            int n25 = this.az;
            int[] nArray3 = nArray[n25];
            int n26 = nArray3[6];
            this.j(n, n2, n26);
            boolean bl4 = false;
            Object var3_12 = null;
            int n27 = 0;
            while (n27 < (n24 = 2)) {
                Image image4 = this.a1013[3][12];
                int n28 = n27 * 60 + 120;
                int n29 = n2 + 1;
                n4 = n27 * 9;
                int n30 = 9;
                a a3 = this;
                this.a(image4, n28, n29, n4, 0, n30, n5, 0, 0);
                int n24 = n27 + 2;
                n24 = nArray3[n24];
                int n31 = n27 * 60 + 131;
                this.b(n24, n31, n2);
                n27 = n24 = n27 + 1;
            }
            return;
        }
        int n32 = this.ay;
        int n33 = -1;
        if (n32 == n33) {
            int n34 = this.bN;
            int n35 = this.bO;
            boolean bl5 = this.e(n34, n35);
            if (bl5) {
                int n36 = 1;
                this.i(n, n2, n36);
                return;
            }
            int n37 = this.bN;
            int n38 = this.bO;
            boolean bl6 = this.f(n37, n38);
            if (bl6) {
                int n39 = 3;
                this.i(n, n2, n39);
                return;
            }
            int n40 = this.bN;
            int n41 = this.bO;
            boolean bl7 = this.g(n40, n41);
            if (bl7) {
                int n42 = 2;
                this.i(n, n2, n42);
                return;
            }
            boolean bl8 = false;
            Object var3_24 = null;
            this.i(n, n2, 0);
            return;
        }
        int[][] nArray = this.c1107;
        int n43 = this.ay;
        int[] nArray4 = nArray[n43];
        int n44 = nArray4[2];
        this.g(n44, n, n2);
        boolean bl9 = false;
        Object var3_16 = null;
        int n45 = 0;
        while (true) {
            int n46;
            if (n45 >= (n46 = 2)) {
                Object var3_23 = null;
                int n47 = nArray4[0];
                int n48 = nArray4[1];
                int n49 = nArray4[2];
                int n50 = nArray4[3];
                this.e(n47, n48, n49, n50);
                return;
            }
            Image[] imageArray = this.a1013[3];
            int n51 = 12;
            Image image5 = imageArray[n51];
            int n52 = n45 * 60 + 120;
            int n53 = n2 + 1;
            n46 = n45 + 2;
            n4 = n46 * 9;
            int n54 = n45 == 0 ? (n46 = 9) : (n46 = 18);
            a a4 = this;
            this.a(image5, n52, n53, n4, 0, n54, n5, 0, 0);
            if (n45 == 0) {
                int[][] nArray5 = this.c1107;
                n51 = this.ay;
                int[] nArray6 = nArray5[n51];
                n46 = nArray6[2];
                byte[] byArray = this.s1102;
                int[][] nArray7 = this.c1107;
                n53 = this.ay;
                int[] nArray8 = nArray7[n53];
                n53 = 3;
                n52 = nArray8[n53];
                n46 = this.a(n46, byArray, n52);
                n51 = nArray4[17];
                n52 = 1;
                if (n51 == n52) {
                    n51 = 10;
                } else {
                    n51 = 0;
                    Object var4_37 = null;
                }
                n46 += n51;
            } else {
                n46 = nArray4[3] + 1;
            }
            n51 = (n45 + 1) * 9 + 120 + 2;
            n52 = n45 * 60;
            this.b(n46, n51 += n52, n2);
            n45 = n46 = n45 + 1;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void h(int n, int n2, int n3) {
        int n4;
        this.g(n, n2, n3);
        if (n > 0 && n < (n4 = 6)) {
            Image[] imageArray = this.a1013[3];
            int n5 = 29;
            Image image = imageArray[n5];
            int n6 = n2 + 36;
            int n7 = n3 + 1;
            int n8 = 17;
            int n9 = 17;
            int n10 = 10;
            a a2 = this;
            this.a(image, n6, n7, n8, 0, n9, n10, 0, 0);
            return;
        }
        n4 = 6;
        if (n < n4) return;
        n4 = 10;
        if (n > n4) return;
        Image[] imageArray = this.a1013[3];
        int n11 = 29;
        Image image = imageArray[n11];
        int n12 = n2 + 36;
        int n13 = n3 + 1;
        boolean bl = false;
        int n14 = 17;
        int n15 = 10;
        a a3 = this;
        this.a(image, n12, n13, 0, 0, n14, n15, 0, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void h(int n, int n2, int n3, int n4) {
        int n5 = 8;
        int n6 = -1;
        int n7 = 10;
        int n8 = 1;
        int n9 = 0;
        int n10;
        while (n9 < (n10 = this.aP)) {
            int[] nArray = this.b1066[n9];
            int n11 = nArray[0];
            int n12 = nArray[n8];
            n11 = this.a(n11, n12);
            byte[] byArray = this.D1162;
            n11 = byArray[n11];
            switch (n11) {
                case 4: {
                    n11 = nArray[n5];
                    if (n11 != 0) break;
                    nArray[n5] = n8;
                    n11 = 9;
                    nArray[n11] = n4;
                    byte[] byArray2 = this.s1102;
                    n10 = this.a(n2, byArray2, n3);
                    this.v(n9, n10, n);
                    break;
                }
                case 3: {
                    nArray[11] = 0;
                    n11 = nArray[n7];
                    if (n11 != n6 || (n10 = nArray[26]) == (n11 = 4)) break;
                    byte[] byArray3 = this.s1102;
                    n10 = this.a(n2, byArray3, n3);
                    this.v(n9, n10, n);
                    break;
                }
                case 2: {
                    int[] nArray2;
                    n11 = nArray[n7];
                    if (n11 != n6) break;
                    n11 = nArray[11];
                    if (n11 > 0) {
                        nArray2 = this.c1107[n];
                        n11 = nArray2[n7];
                        if (n11 == n8) {
                            nArray2 = this.c1107[n];
                            n12 = 13;
                            int n13 = nArray2[n12];
                            int n14 = 2;
                            nArray2[n12] = n13 -= n14;
                            if (n13 < 0) {
                                nArray2 = this.c1107[n];
                                n12 = 13;
                                nArray2[n12] = 0;
                            }
                        }
                        nArray2 = this.c1107[n];
                        n12 = 16;
                        nArray2[n12] = n8;
                    }
                    if ((n11 = (nArray2 = this.c1107[n])[n12 = 16]) == n8) {
                        n11 = 11;
                        nArray[n11] = n12 = 48;
                    }
                    byte[] byArray4 = this.s1102;
                    n10 = this.a(n2, byArray4, n3);
                    this.v(n9, n10, n);
                    break;
                }
                case 5: {
                    n10 = nArray[n7];
                    if (n10 != n6) break;
                    byte[] byArray5 = this.s1102;
                    n10 = this.a(n2, byArray5, n3);
                    this.v(n9, n10, n);
                    break;
                }
                case 16: 
                case 46: {
                    n10 = nArray[n5];
                    n11 = 4;
                    if (n10 == n11) break;
                    byte[] byArray6 = this.s1102;
                    n10 = this.a(n2, byArray6, n3);
                    this.v(n9, n10, n);
                    break;
                }
            }
            ++n9;
        }
        return;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void h(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block8: {
            var6_6 = 3;
            var7_7 = 4.2E-45f;
            var8_8 /* !! */  = 3;
            var9_9 = 4.2E-45f;
            var10_10 = 0;
            var11_11 = 0.0f;
            var12_12 = 0;
            var13_13 = 0.0f;
            var14_14 /* !! */  = this;
            var15_15 = this.m(var4_4, var5_5);
            if (var15_15 != 0) ** GOTO lbl-1000
            block0 : switch (var3_3) {
                default: lbl-1000:
                // 2 sources

                {
                    var16_16 = 0;
                    var17_17 = var8_8 /* !! */ ;
                    var18_18 = var6_6;
                    var6_6 = 0;
                    var7_7 = 0.0f;
lbl19:
                    // 3 sources

                    while (true) {
                        var19_19 = var6_6;
lbl21:
                        // 2 sources

                        while (true) {
                            var20_20 = var19_19;
                            if (var19_19 < var18_18) {
                                var21_21 = var16_16;
                                while (true) {
                                    var20_20 = var21_21;
                                    if (var21_21 >= var17_17) break block0;
                                    var6_6 = var19_19 << 4;
                                    var14_14 /* !! */  = this;
                                    var22_22 = var14_14 /* !! */  = (Image)this.m1084;
                                    var8_8 /* !! */  = (int)var14_14 /* !! */ [var3_3][0];
                                    var6_6 = var6_6 * var8_8 /* !! */  + var1_1;
                                    var14_14 /* !! */  = this;
                                    var22_22 = var14_14 /* !! */  = (Image)this.m1084;
                                    var22_22 = var14_14 /* !! */ [var3_3];
                                    var11_11 = 2.8E-45f;
                                    var8_8 /* !! */  = (int)var22_22[2];
                                    var6_6 += var8_8 /* !! */ ;
                                    var14_14 /* !! */  = this;
                                    var8_8 /* !! */  = var20_20 = this.bP;
                                    var10_10 = var6_6 - var20_20;
                                    var6_6 = var21_21 << 4;
                                    var22_22 = var14_14 /* !! */  = (Image)this.m1084;
                                    var8_8 /* !! */  = (int)var14_14 /* !! */ [var3_3][1];
                                    var6_6 = var6_6 * var8_8 /* !! */  + var2_2;
                                    var14_14 /* !! */  = this;
                                    var22_22 = var14_14 /* !! */  = (Image)this.m1084;
                                    var8_8 /* !! */  = (int)var14_14 /* !! */ [var3_3][3];
                                    var6_6 += var8_8 /* !! */ ;
                                    var14_14 /* !! */  = this;
                                    var8_8 /* !! */  = var20_20 = this.bQ;
                                    var6_6 = var6_6 - var20_20 + 13;
                                    var22_22 = var14_14 /* !! */  = this.a1013;
                                    var22_22 = var14_14 /* !! */ [29][39];
                                    var13_13 = 2.2E-44f;
                                    var12_12 = var6_6 - 16;
                                    var14_14 /* !! */  = this;
                                    var25_24 = var23_23 = this.a1019;
                                    var27_25 = 3;
                                    var25_24 = var23_23 & var27_25;
                                    var15_15 = (int)var25_24 * 15;
                                    var29_26 = 15;
                                    var30_27 = 29;
                                    this.a(var22_22, var10_10, var12_12, var15_15, 0, var29_26, var30_27, 0, 0);
                                    var21_21 = var6_6 = var21_21 + 1;
                                }
                            }
                            break block8;
                            break;
                        }
                        break;
                    }
                }
                case 0: 
                case 2: {
                    var6_6 = 1;
                    var7_7 = 1.4E-45f;
                    var10_10 = 2;
                    var11_11 = 2.8E-45f;
                    var16_16 = 0;
                    var17_17 = var8_8 /* !! */ ;
                    var18_18 = var10_10;
                    ** GOTO lbl19
                }
                case 1: 
                case 3: {
                    var8_8 /* !! */  = 1;
                    var9_9 = 1.4E-45f;
                    var12_12 = 2;
                    var13_13 = 2.8E-45f;
                    var16_16 = var8_8 /* !! */ ;
                    var17_17 = var12_12;
                    var18_18 = var6_6;
                    var6_6 = 0;
                    var7_7 = 0.0f;
                    ** continue;
                }
            }
            var19_19 = var6_6 = var19_19 + 1;
            ** while (true)
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean h(int n) {
        int n2 = this.a() & 7;
        if (n2 <= n) return 0 != 0;
        return 1 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean h(int n, int n2) {
        if (n <= 0) return 0 != 0;
        int n3 = this.bI;
        if (n >= n3) return 0 != 0;
        if (n2 <= 0) return 0 != 0;
        n3 = this.bJ;
        if (n2 >= n3) {
            return 0 != 0;
        }
        n3 = this.a(n, n2);
        byte[] byArray = this.E1163;
        int n4 = 8;
        if ((n3 = byArray[n3]) >= n4) return 0 != 0;
        return 1 != 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void i() {
        int n = 1;
        int n2 = this.h1047;
        switch (n2) {
            case -6: 
            case -5: {
                this.l = n;
                this.l1031 = n;
                this.q = 60;
                n2 = 7;
                n = -1;
                this.g(n2, n);
            }
            default: {
                return;
            }
            case -7: 
        }
        n2 = 0;
        this.l1031 = false;
        this.l = n;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void i(int n) {
        int n2 = -1;
        int n3 = 1;
        if (n < 0) {
            return;
        }
        int[] nArray = this.h1041;
        int n4 = nArray[n];
        if (n4 < 0) return;
        this.h(n);
        Player[] playerArray = this.a1043;
        int n5 = this.h1041[n];
        playerArray[n5].close();
        Player[] playerArray2 = this.a1043;
        int[] nArray2 = this.h1041;
        n5 = nArray2[n];
        int n6 = 0;
        int[] nArray3 = null;
        playerArray2[n5] = null;
        Object var4_7 = null;
        for (n4 = 0; n4 < (n5 = this.ap); ++n4) {
            nArray2 = this.i1044;
            n5 = nArray2[n4];
            if (n5 != n) continue;
            while (n4 < (n5 = this.ap - n3)) {
                nArray2 = this.i1044;
                nArray3 = this.i1044;
                int n7 = n4 + 1;
                nArray2[n4] = n6 = nArray3[n7];
                ++n4;
            }
            break;
        }
        int[] nArray4 = this.i1044;
        n5 = this.ap - n3;
        nArray4[n5] = n2;
        this.ap = n4 = this.ap - n3;
        int[] nArray5 = this.h1041;
        nArray5[n] = n2;
    }

    private void i(int n, int n2) {
        int n3;
        int n4 = 5;
        int n5 = -1;
        int n6 = 10;
        int n7 = 8;
        int[] nArray = this.b1066[n];
        int n8 = nArray[n6];
        if (n8 != n5) {
            n8 = nArray[n6];
            n3 = 1;
            nArray[n6] = n8 -= n3;
            if (n8 < 0) {
                nArray[n6] = n5;
            }
        }
        if (n2 <= 0 && (n8 = nArray[n7]) != n4 && (n8 = nArray[n7]) != (n3 = 3) && (n8 = nArray[n7]) != (n3 = 2)) {
            nArray[7] = 0;
            nArray[11] = 0;
            nArray[12] = 0;
            nArray[13] = 0;
            n8 = 14;
            nArray[n8] = 0;
            nArray[n7] = n4;
        }
    }

    private void i(int n, int n2, int n3) {
        Object object;
        int n4;
        for (int i = 0; i < (n4 = ((byte[])(object = this.c1051[n3])).length); ++i) {
            object = this.a1013[3][11];
            int n5 = i * 14 + n;
            byte[] byArray = this.c1051[n3];
            byte by = byArray[i];
            this.c((Image)object, n5, n2, (int)by);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void i(int n, int n2, int n3, int n4) {
        long l;
        int n5;
        int n6;
        int n7 = 0;
        Object var6_6 = null;
        int n8 = 0;
        while (n8 < (n7 = 4)) {
            n7 = 0;
            Object var6_8 = null;
            int n9 = 0;
            Object var9_18 = null;
            n6 = this.ay;
            n5 = -1;
            if (n6 != n5) {
                byte[] byArray = this.P1157[n8];
                n7 = byArray[0];
                long l2 = this.a1019;
                l = 1L;
                n9 = (int)(l2 &= l) << 1;
                n7 *= n9;
                byte[] byArray2 = this.P1157[n8];
                n9 = byArray2[1];
                long l3 = this.a1019;
                long l4 = 1L;
                n6 = (int)(l3 &= l4) << 1;
                n9 *= n6;
                n6 = n7;
                n7 = n9;
            } else {
                n6 = 0;
                n7 = 0;
                Object var6_12 = null;
            }
            Image image = this.a1013[3][0];
            n6 += n;
            n5 = n3 - 7;
            int n10 = this.O1156[n8][0];
            n6 += (n5 *= n10);
            n5 = this.bP;
            n6 -= n5;
            n7 += n2;
            n5 = n4 - 7;
            byte[] byArray = this.O1156[n8];
            n10 = byArray[1];
            n5 = this.bQ;
            n5 = (n7 += (n5 *= n10)) - n5 + 13;
            n10 = n8 * 7;
            int n11 = 7;
            int n12 = 7;
            a a2 = this;
            this.a(image, n6, n5, n10, 0, n11, n12, 0, 0);
            n8 = n7 = n8 + 1;
        }
        n7 = this.bF;
        int n13 = 1;
        if (n7 != n13) {
            n7 = this.ay;
            int n14 = -1;
            n7 = n7 != n14 ? this.bE : n3;
            Image image = this.a1013[3][1];
            n6 = this.bN;
            n7 = (n7 >> 1) + n6;
            n6 = this.bP;
            n7 -= n6;
            n6 = this.bO - 16;
            n5 = this.bQ;
            n6 -= n5;
            l = this.a1019;
            long l5 = 1L;
            n5 = (int)(l &= l5) << 1;
            n6 = n6 - n5 + 13;
            n5 = 4;
            this.b(image, n7, n6, n5);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean i(int n) {
        int n2;
        int n3 = 0;
        while (n3 < (n2 = 5)) {
            byte[] byArray = this.C1134[n];
            n2 = byArray[n3];
            int n4 = -1;
            if (n2 != n4) {
                return 0 != 0;
            }
            n3 = (byte)(n3 + 1);
        }
        return 1 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean i(int n, int n2) {
        int n3 = this.X;
        int n4 = 1;
        if (n3 != n4) return 0 != 0;
        switch (n) {
            default: {
                return 0 != 0;
            }
            case 1: 
            case 2: 
            case 3: 
            case 6: 
            case 7: 
        }
        n3 = a.g(n2);
        if (n3 == 0) return 0 != 0;
        return n4 != 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void j() {
        var1_1 = 80;
        var2_2 = 1;
        var3_3 = 240;
        var4_4 = 107;
        this.a1002.setColor(0xFCFFCD);
        var5_5 /* !! */  = this.a1002;
        var6_6 = this.b1015[var4_4];
        var7_7 = var6_6.length();
        var8_8 = this.k;
        var7_7 = var7_7 * var8_8 + 8;
        var7_7 = var3_3 - var7_7 >> 1;
        var9_9 = this.b1015[var4_4];
        var8_8 = var9_9.length();
        var10_10 = this.k;
        var8_8 = var8_8 * var10_10 + 8;
        var5_5 /* !! */ .fillRect(var7_7, var1_1, var8_8, 140);
        var11_11 = this.b1015[var4_4].length();
        var7_7 = this.k;
        var11_11 = var11_11 * var7_7 + 8;
        var7_7 = var3_3 - var11_11 >> 1;
        var11_11 = this.b1015[var4_4].length();
        var8_8 = this.k;
        var8_8 = var11_11 * var8_8 + 8;
        var10_10 = 140;
        var5_5 /* !! */  = this;
        this.c(var7_7, var1_1, var8_8, var10_10, var2_2);
        var5_5 /* !! */  = this.a1002;
        var7_7 = 320;
        var5_5 /* !! */ .setClip(0, 0, var3_3, var7_7);
        var5_5 /* !! */  = null;
        block0: for (var11_11 = 0; var11_11 < (var7_7 = 6); ++var11_11) {
            var7_7 = this.r;
            if (var11_11 == var7_7) {
                while (true) {
                    var6_6 = this.a1002;
                    var1_1 = 14311547;
                    var6_6.setColor(var1_1);
lbl38:
                    // 3 sources

                    while (true) {
                        var6_6 = this.a1002;
                        var12_12 /* !! */  = this.b1015;
                        var8_8 = var11_11 + 107;
                        var12_12 /* !! */  = var12_12 /* !! */ [var8_8];
                        var9_9 = this.b1015;
                        var10_10 = var11_11 + 107;
                        var9_9 = var9_9[var10_10];
                        var8_8 = var9_9.length();
                        var10_10 = this.k;
                        var8_8 *= var10_10;
                        var8_8 = var3_3 - var8_8 >> 1;
                        var10_10 = var11_11 * 20 + 90;
                        var6_6.drawString((String)var12_12 /* !! */ , var8_8, var10_10, 0);
                        continue block0;
                        break;
                    }
                    break;
                }
            }
            var6_6 = this.a1002;
            var1_1 = 15455661;
            var6_6.setColor(var1_1);
            if (var11_11 != var2_2) ** GOTO lbl38
            var13_13 = this.a1019;
            if ((var7_7 = (int)(var13_13 &= (var15_14 = 1L))) != 0) ** continue;
            var6_6 = this.a1002;
            var1_1 = 15455661;
            var6_6.setColor(var1_1);
            ** continue;
        }
    }

    private void j(int n) {
        int n2;
        int n3;
        this.aw = n3 = 1;
        this.aF = 8;
        this.aB = n2 = this.d1053[n].length - n3;
        this.aC = n;
        this.aE = 0;
        this.aD = 0;
        this.ax = n2 = (this.j << 1) + 25;
        n2 = this.aB;
        n3 = this.aF;
        if (n2 < n3) {
            this.aF = n2 = this.aB + 1;
        }
        n3 = this.aF * 18;
        this.aG = n2 = 240 - n3 >> 1;
        this.a(12);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void j(int n, int n2) {
        int n3 = 4;
        int n4 = 3;
        int n5 = 2;
        int n6 = this.bu;
        Image image = this.a1013[n4];
        int n7 = 20;
        int n8 = (image = image[n7]).getWidth() / 27;
        if (n6 < n8) {
            n6 = this.bu + 1;
            this.bu = n6;
            n6 = this.bu;
            if (n6 != n5) return;
            if (n2 != n3) return;
            int[] nArray = this.c1107[n];
            nArray[n4] = n8 = nArray[n4] + 1;
            return;
        }
        n6 = 5;
        if (n2 == n6) {
            this.t(n);
        }
        n6 = 0;
        this.bu = 0;
        int[] nArray = this.c1107[n];
        nArray[n3] = n5;
        if (n2 != n4) return;
        nArray = this.c1107[n];
        n6 = nArray[n5];
        switch (n6) {
            default: {
                return;
            }
            case 0: 
            case 4: 
        }
        nArray = this.c1107[n];
        nArray[n3] = n8 = 6;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void j(int n, int n2, int n3) {
        int n4 = 3;
        Image image = null;
        int n5 = n3 >> 1;
        short[] sArray = this.a1052[n5];
        int n6 = sArray.length;
        int n7 = a.a(n3);
        if (n7 != 0) {
            n5 = this.bb;
            n6 = 18;
            this.q(n5, n6, 293);
            Graphics graphics = this.a1002;
            Image image2 = this.a1013[n4][28];
            n7 = 299;
            graphics.drawImage(image2, 0, n7, 0);
            return;
        } else {
            for (n7 = 0; n7 < n6; ++n7) {
                image = this.a1013[n4][14];
                int n8 = n7 * 12 + n;
                short[] sArray2 = this.a1052[n5];
                short s = sArray2[n7];
                this.c(image, n8, n2, (int)s);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean j(int n) {
        int n2 = this.bz;
        if (n > n2) {
            return 0 != 0;
        }
        this.bz = n2 = this.bz - n;
        return 1 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean j(int n, int n2) {
        int n3 = this.X;
        int n4 = 1;
        if (n3 != n4) return 0 != 0;
        switch (n) {
            default: {
                return 0 != 0;
            }
            case 8: 
            case 9: 
        }
        n3 = a.g(n2);
        if (n3 == 0) return 0 != 0;
        return n4 != 0;
    }

    private void k() {
        Random random;
        this.e(0);
        random = this.a1012 = (random = new Random());
        long l = System.currentTimeMillis();
        random.setSeed(l);
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void k(int n) {
        int n2 = 2;
        byte by = 0;
        byte[] byArray = null;
        int n3 = 1;
        int n4 = this.bt;
        if (n4 > 0) {
            boolean[] blArray = this.a1056;
            n4 = blArray[n];
            if (n4 == 0) {
                byte[] byArray2 = this.g1057;
                n4 = byArray2[n];
                if ((n4 = (int)(this.j(n4) ? 1 : 0)) != 0) {
                    this.a1056[n] = n3;
                    boolean[] blArray2 = this.b1059;
                    byte[] byArray3 = this.h1060;
                    byte by2 = byArray3[n];
                    blArray2[by2] = n3;
                    Object var7_10 = null;
                    for (n4 = 0; n4 < n2; ++n4) {
                        boolean[] blArray3 = this.e1105;
                        byArray = this.g1065[n];
                        by = byArray[n4];
                        blArray3[by] = n3;
                    }
                    byte[] byArray4 = this.h1060;
                    n4 = byArray4[n];
                    this.u(n4);
                    this.aw = n2;
                    return;
                }
                this.o = 0;
                return;
            }
            this.o = n4 = 3;
            return;
        }
        this.o = n3;
    }

    private void k(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7 = 4;
        Image image = null;
        for (n6 = 0; n6 < n7; ++n6) {
            byte[] byArray = this.w1110;
            n5 = n6 << 1;
            n4 = byArray[n5] + n;
            byte[] byArray2 = this.w1110;
            n3 = (n6 << 1) + 1;
            n5 = byArray2[n3] + n2;
            n3 = this.bu;
            this.p(n4, n5, n3);
        }
        n6 = this.bu;
        n4 = 1;
        if (n6 > n4) {
            image = this.a1013[3][21];
            n4 = this.bP;
            n4 = n - n4;
            n5 = n2 + 13;
            n3 = this.bQ;
            n5 -= n3;
            n3 = this.bu << 1;
            this.b(image, n4, n5 -= n3, n7);
        }
    }

    private void k(int n, int n2, int n3) {
        Image image = this.a1013[3][22];
        Object object = this.e1054;
        int n4 = this.f1055[n3] * 3 + 2;
        byte by = object[n4];
        n4 = n + by;
        object = this.e1054;
        int n5 = this.f1055[n3] * 3;
        byte by2 = object[n5];
        object = this.e1054;
        n5 = this.f1055[n3] * 3 + 1;
        byte by3 = object[n5];
        object = this;
        n5 = n2;
        this.a(image, n4, n2, by2, 0, by3, 15, 0, 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean k(int n, int n2) {
        int n3 = this.X;
        int n4 = 1;
        if (n3 != n4) return 0 != 0;
        switch (n) {
            default: {
                return 0 != 0;
            }
            case 10: 
        }
        n3 = a.g(n2);
        if (n3 == 0) return 0 != 0;
        return n4 != 0;
    }

    private void l() {
        this.a1002.setClip(0, 0, 240, 320);
        this.a1002.setColor(0xFFFFFF);
        Object object = this.a1002;
        Image image = null;
        int n = 0;
        Image image2 = null;
        int n2 = 240;
        int n3 = 320;
        object.fillRect(0, 0, n2, n3);
        int n4 = this.t;
        int n5 = 240;
        this.e(n4, n5);
        n4 = this.M;
        if (n4 != 0) {
            int n6;
            int n7;
            int n8;
            object = null;
            this.d(0);
            n4 = this.M;
            n5 = 2;
            if (n4 >= n5) {
                object = this.a1002;
                image = this.a1013;
                image2 = null;
                image = image[0][4];
                n = this.y;
                n2 = this.z;
                n3 = 0;
                object.drawImage(image, n, n2, 0);
            }
            object = null;
            for (n4 = 0; n4 < (n5 = 3); ++n4) {
                n5 = this.w;
                n = n4 * 176;
                n5 += n;
                n = this.x;
                this.d(n5, n);
            }
            n4 = this.M;
            n5 = 3;
            if (n4 >= n5) {
                n4 = this.h ? 1 : 0;
                if (n4 != 0) {
                    object = this.a1002;
                    image = this.a1013;
                    image2 = null;
                    image = image[0][5];
                    n = this.G;
                    n2 = this.H;
                    n3 = 0;
                    object.drawImage(image, n, n2, 0);
                }
                if ((n4 = (int)(this.j1024 ? 1 : 0)) != 0) {
                    object = this.a1013[0][0];
                    n5 = this.A;
                    n = this.B;
                    this.a((Image)object, n5, n, 0);
                    object = this.a1013;
                    image = null;
                    object = object[0][1];
                    n5 = this.C;
                    n = this.D;
                    n2 = 0;
                    this.a((Image)object, n5, n, 0);
                }
                if ((n4 = (int)(this.g ? 1 : 0)) != 0) {
                    object = this.a1013[0];
                    n5 = 2;
                    image = object[n5];
                    n = this.E;
                    n2 = this.F;
                    n4 = this.a1013[0][2].getWidth() >> 1;
                    n3 = (this.R - 1) * n4;
                    n8 = 0;
                    n4 = this.a1013[0][2].getWidth();
                    n7 = n4 >> 1;
                    n6 = this.a1013[0][2].getHeight();
                    object = this;
                    this.a(image, n, n2, n3, 0, n7, n6, 0, 0);
                }
                if ((n4 = (int)(this.f1023 ? 1 : 0)) != 0) {
                    int n9 = this.A + 16;
                    n4 = this.B;
                    image = this.a1013[0];
                    n = 0;
                    image2 = null;
                    image = image[0];
                    n5 = image.getHeight();
                    n4 += n5;
                    n5 = 14;
                    int n10 = n4 - n5;
                    object = null;
                    for (n4 = 0; n4 < (n5 = this.S); ++n4) {
                        image = this.a1002;
                        image2 = this.a1013[0];
                        n2 = n4 + 9;
                        image2 = image2[n2];
                        n2 = 0;
                        image.drawImage(image2, n9, n10, 0);
                    }
                    n4 = this.d1021 ? 1 : 0;
                    if (n4 != 0) {
                        object = this.a1013[0];
                        n5 = 7;
                        image = object[n5];
                        object = this.a1013;
                        image2 = null;
                        n = object[0][11].getWidth() + n9 - 6;
                        n2 = n10 + 4;
                        n4 = this.a1013[0][7].getWidth() / 3;
                        n3 = (this.P - 1) * n4;
                        n8 = 0;
                        n4 = this.a1013[0][7].getWidth();
                        n7 = n4 / 3;
                        n6 = this.a1013[0][7].getHeight();
                        object = this;
                        this.a(image, n, n2, n3, 0, n7, n6, 0, 0);
                    }
                    if ((n4 = (int)(this.e1022 ? 1 : 0)) != 0) {
                        object = this.a1013[0];
                        n5 = 8;
                        image = object[n5];
                        n = n9 - 15;
                        n4 = this.a1013[0][11].getHeight();
                        n2 = n10 + n4;
                        n4 = this.a1013[0][8].getWidth() / 3;
                        n3 = (this.Q - 1) * n4;
                        n8 = 0;
                        n4 = this.a1013[0][8].getWidth();
                        n7 = n4 / 3;
                        n6 = this.a1013[0][8].getHeight();
                        object = this;
                        this.a(image, n, n2, n3, 0, n7, n6, 0, 0);
                    }
                }
                if ((n4 = (int)(this.i ? 1 : 0)) != 0) {
                    object = this.a1002;
                    image = this.a1013;
                    image2 = null;
                    image = image[0][6];
                    n = this.I;
                    n2 = this.J;
                    n3 = 0;
                    object.drawImage(image, n, n2, 0);
                }
            }
            if ((n4 = this.M) == (n5 = 5)) {
                object = this.a1002;
                image = this.a1013[0][3];
                n2 = this.L;
                object.drawImage(image, 0, n2, 0);
                object = this.a1013[0][3];
                n = this.a1013[0][3].getWidth();
                n5 = 240 - n;
                n = this.L;
                this.a((Image)object, n5, n, 1);
                n4 = this.r;
                n5 = this.K;
                n = this.L + 1;
                this.c(n4, n5, n);
                n4 = this.K - 20;
                n5 = this.K;
                n = this.a1013[4][25].getWidth();
                n5 = n5 + n + 20;
                image2 = this.a1013[3][24];
                n = image2.getWidth();
                n5 -= n;
                n = this.L + 1;
                this.d(n4, n5, n);
                object = this.a1013[3];
                n5 = 2;
                image = object[n5];
                n = 1;
                n4 = this.L;
                n2 = n4 + 3;
                n3 = 0;
                n8 = 20;
                n7 = 18;
                n6 = 10;
                object = this;
                this.a(image, n, n2, 0, n8, n7, n6, 0, 0);
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private final void l(int n) {
        int n2 = 8;
        int n3 = 6;
        int n4 = 2;
        int n5 = 1;
        int n6 = this.aT;
        int n7 = this.aX;
        if (n6 >= n7) return;
        short[][] sArray = this.b1069;
        int n8 = this.aN;
        short[] sArray2 = sArray[n8];
        short s = sArray2[0];
        short[][] sArray3 = this.b1069;
        int n9 = this.aN;
        short[] sArray4 = sArray3[n9];
        int n10 = sArray4[n5] + 13;
        boolean bl = this.b(s, n10);
        if (bl) {
            int n11;
            this.aR = n11 = this.aR - n5;
            if (n11 < 0) {
                int n12;
                int n13;
                int n14;
                int n15;
                void var6_13;
                int n16;
                boolean bl2 = this.o1077;
                if (bl2 && (n16 = this.aP) == 0) {
                    this.ab();
                    this.o1077 = n5;
                } else {
                    this.o1077 = false;
                }
                int n17 = this.aP;
                while (var6_13 < (n15 = this.aP + n)) {
                    int n18;
                    int[] nArray = this.b1066[var6_13];
                    short[][] sArray5 = this.b1069;
                    int n19 = this.aN;
                    nArray[0] = n18 = sArray5[n19][0];
                    int[] nArray2 = this.b1066[var6_13];
                    short[][] sArray6 = this.b1069;
                    n19 = this.aN;
                    short[] sArray7 = sArray6[n19];
                    nArray2[n5] = n18 = sArray7[n5];
                    int[] nArray3 = this.b1066[var6_13];
                    int n18 = this.o1077 ? 1 : 0;
                    n18 = n18 != 0 ? this.aW * 10 : this.aW;
                    nArray3[n4] = n18;
                    int[] nArray4 = this.b1066[var6_13];
                    nArray4[3] = n19 = this.aY;
                    int[] nArray5 = this.b1066[var6_13];
                    nArray5[4] = n19 = this.aZ;
                    int[] nArray6 = this.b1066[var6_13];
                    int[] nArray7 = this.b1066[var6_13];
                    n19 = nArray7[0];
                    int[] nArray8 = this.b1066[var6_13];
                    int n20 = nArray8[n5];
                    nArray6[5] = n19 = this.c(n19, n20);
                    int[] nArray9 = this.b1066[var6_13];
                    int n18 = this.o1077 ? 1 : 0;
                    n18 = n18 != 0 ? (this.aV << 1) + 1 : this.aV << 1;
                    nArray9[n3] = n18;
                    this.b1066[var6_13][7] = 0;
                    this.b1066[var6_13][n2] = 0;
                    this.b1066[var6_13][9] = 0;
                    int[] nArray10 = this.b1066[var6_13];
                    nArray10[24] = n19 = this.aQ;
                    this.b1066[var6_13][10] = -1;
                    this.b1066[var6_13][11] = 0;
                    this.b1066[var6_13][12] = 0;
                    this.b1066[var6_13][13] = 0;
                    this.b1066[var6_13][14] = 0;
                    this.b1066[var6_13][15] = 0;
                    this.b1066[var6_13][25] = 0;
                    this.b1066[var6_13][23] = 0;
                    int[] nArray11 = this.b1066[var6_13];
                    nArray11[26] = n19 = this.ba;
                    int[] nArray12 = this.b1066[var6_13];
                    n18 = 27;
                    nArray12[n18] = 0;
                    n15 = this.ba;
                    if (n15 == n3 || (n15 = this.ba) == n2) {
                        int[] nArray13 = this.b1066[var6_13];
                        n18 = 27;
                        nArray13[n18] = n19 = -2;
                    }
                    int[] nArray14 = this.b1066[var6_13];
                    n15 = nArray14[0];
                    int[] nArray15 = this.b1066[var6_13];
                    n18 = nArray15[n5];
                    this.a(n15, n18, n5 != 0);
                    ++var6_13;
                }
                this.aP = n14 = this.aP + 1;
                this.aQ = n13 = this.aQ + 1;
                this.aT = n12 = this.aT + 1;
                this.aR = n4;
            }
        }
    }

    private void l(int n, int n2) {
        int n3;
        int[] nArray = this.c1107[n];
        int n4 = 6;
        nArray[n4] = n3 = nArray[n4] - 1;
        this.A(n);
    }

    private void l(int n, int n2, int n3) {
        Image image = this.a1013[30][0];
        byte by = this.e1058[n][0];
        byte by2 = this.e1058[n][1];
        byte by3 = this.e1058[n][2];
        byte by4 = this.e1058[n][3];
        this.a(image, n2, n3, by, by2, by3, by4, 0, 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean l(int n, int n2) {
        int n3 = this.X;
        if (n3 != 0) return 0 != 0;
        switch (n) {
            default: {
                return 0 != 0;
            }
            case 2: 
            case 6: 
            case 10: 
        }
        n3 = a.g(n2);
        if (n3 == 0) return 0 != 0;
        return 1 != 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void m() {
        int n = 6;
        int n2 = 2;
        int n3 = 4;
        int n4 = 1;
        int n5 = this.M;
        switch (n5) {
            case 0: {
                this.S = 0;
                this.N = 0;
                this.v = -26;
                this.x = n5 = 416;
                this.M = n4;
                return;
            }
            case 1: {
                this.n();
                this.N = n5 = this.N + 1;
                int n6 = 20;
                if (n5 <= n6) return;
                this.N = 0;
                n6 = this.a1013[0][n3].getWidth();
                this.y = n5 = 240 - n6 >> 1;
                Image image = this.a1013[0][n3];
                this.z = n5 = image.getHeight() + 320;
                Image image2 = this.a1013[0][n3];
                n6 = image2.getHeight();
                n5 = 320 - n6 >> 1;
                n6 = 10;
                this.O = n5 -= n6;
                this.M = n2;
                return;
            }
            case 2: {
                this.n();
                this.z = n5 = this.z - 60;
                int n7 = this.O;
                if (n5 >= n7) return;
                this.z = n5 = this.O;
                this.N = 0;
                this.U = 0;
                n5 = this.y;
                n7 = this.a1013[0][n3].getWidth();
                n5 = this.e1025 = (n5 = n5 + n7 - 20);
                n7 = this.a1013[0][0].getWidth();
                this.f1026 = n5 = n5 + n7 - n3;
                n5 = this.e1025;
                n7 = this.a1027[0];
                this.A = n5 += n7;
                n5 = this.f1026;
                n7 = this.a1027[0];
                this.C = n5 -= n7;
                this.B = n5 = this.O + 12;
                this.D = n5 = this.B + 8;
                this.E = n5 = this.f1026;
                n5 = this.B;
                Image image = this.a1013[0][0];
                n7 = image.getHeight();
                this.F = n5 += n7;
                this.G = n5 = this.f1026;
                this.M = n3;
                return;
            }
            case 4: {
                this.n();
                this.o();
                n5 = this.N;
                if (n5 > n2) {
                    this.j1024 = n4;
                    this.N = 0;
                    this.M = n5 = 3;
                }
                this.N = n5 = this.N + 1;
                return;
            }
            case 3: {
                int n8;
                Object object;
                this.n();
                this.o();
                Object object2 = this.a1027;
                n5 = ((byte[])object2).length;
                int n9 = this.N;
                if (n9 < n5) {
                    n5 = this.e1025;
                    object = this.a1027;
                    n8 = this.N;
                    n9 = object[n8];
                    this.A = n5 += n9;
                    n5 = this.f1026;
                    object = this.a1027;
                    n8 = this.N;
                    n9 = object[n8];
                    this.C = n5 -= n9;
                } else {
                    n9 = this.N;
                    n8 = n5 + 2;
                    if (n9 == n8) {
                        object2 = this.a1013[0];
                        n9 = 5;
                        object2 = object2[n9];
                        n5 = object2.getHeight();
                        this.H = n5 = 0 - n5;
                        this.h = n4;
                    } else {
                        n9 = this.N;
                        n8 = n5 + 2;
                        if (n9 > n8) {
                            n9 = this.N;
                            n8 = n5 + 3;
                            if (n9 == n8) {
                                n5 = this.H;
                                object = this.a1013[0];
                                n8 = 5;
                                object = object[n8];
                                n9 = object.getHeight() >> 1;
                                this.H = n5 += n9;
                            } else {
                                n9 = this.N;
                                n8 = n5 + 4;
                                if (n9 == n8) {
                                    n5 = this.O;
                                    n9 = 10;
                                    this.H = n5 -= n9;
                                } else {
                                    n9 = this.N;
                                    if (n9 == (n5 += 5)) {
                                        this.H = n5 = this.O - n;
                                        this.f1023 = n4;
                                    }
                                }
                            }
                        }
                    }
                }
                if ((n5 = (int)(this.f1023 ? 1 : 0)) != 0) {
                    n5 = this.S;
                    if (n5 == n4) {
                        this.d1021 = n4;
                    } else {
                        n5 = this.S;
                        if (n5 == n2) {
                            this.e1022 = n4;
                            this.g = n4;
                        }
                    }
                    if ((n5 = this.S) < (n9 = 3)) {
                        this.S = n5 = this.S + 1;
                    }
                }
                if ((n5 = (int)(this.d1021 ? 1 : 0)) != 0) {
                    this.P = n5 = this.P + 1;
                    if (n5 > n3) {
                        this.d1021 = false;
                    }
                }
                if ((n5 = (int)(this.e1022 ? 1 : 0)) != 0) {
                    this.Q = n5 = this.Q + 1;
                    if (n5 > n3) {
                        this.e1022 = false;
                        this.i = n4;
                        object2 = this.a1013[0][n];
                        this.I = n5 = -object2.getWidth();
                        object = this.a1013[0][n];
                        n9 = object.getHeight();
                        this.J = n5 = 320 - n9 >> 1;
                    }
                }
                if ((n5 = (int)(this.g ? 1 : 0)) != 0 && (n5 = this.R) < n2) {
                    this.R = n5 = this.R + 1;
                }
                if ((n5 = (int)(this.i ? 1 : 0)) != 0) {
                    this.I = n5 = this.I + 8;
                    n9 = this.y;
                    Image image = this.a1013[0][n];
                    n8 = image.getWidth();
                    n9 -= n8;
                    n8 = 15;
                    if (n5 > (n9 -= n8)) {
                        n5 = this.y;
                        object = this.a1013[0][n];
                        n9 = object.getWidth();
                        n5 -= n9;
                        n9 = 15;
                        this.I = n5 -= n9;
                    }
                }
                if ((n5 = (this.N = (n5 = this.N + 1))) <= (n9 = 25)) return;
                this.N = 0;
                this.L = 320;
                object = this.a1013[n3];
                n8 = 25;
                object = object[n8];
                n9 = object.getWidth();
                this.K = n5 = 240 - n9 >> 1;
                this.M = n5 = 5;
                return;
            }
            case 5: {
                this.n();
                this.o();
                this.L = n5 = this.L - n2;
                Image image = this.a1013[0];
                n3 = 3;
                image = image[n3];
                int n10 = image.getHeight();
                int n11 = 320 - n10;
                if (n5 < n11) {
                    Image image3 = this.a1013[0];
                    n10 = 3;
                    image3 = image3[n10];
                    n11 = image3.getHeight();
                    this.L = n5 = 320 - n11;
                }
                n5 = this.h1047;
                switch (n5) {
                    default: {
                        return;
                    }
                    case -6: 
                    case -5: 
                    case 53: {
                        n5 = this.r;
                        switch (n5) {
                            default: {
                                return;
                            }
                            case 0: {
                                this.h(7);
                                this.T = 0;
                                this.t1089 = false;
                                this.af = n4;
                                this.c = 0;
                                this.X = 0;
                                this.aO = 0;
                                this.aN = 0;
                                this.v1097 = n4;
                                this.bF = 0;
                                this.ay = -1;
                                this.az = -1;
                                this.aw = 0;
                                this.k1029 = false;
                                this.l = n5 = 15;
                                return;
                            }
                            case 1: {
                                this.h(7);
                                this.t1089 = false;
                                this.X = 0;
                                this.af = 0;
                                this.T = n4;
                                this.aO = 0;
                                this.aN = 0;
                                this.bF = 0;
                                this.ay = -1;
                                this.az = -1;
                                this.aw = 0;
                                this.k1029 = n4;
                                this.v1097 = false;
                                this.l = n5 = 15;
                                return;
                            }
                            case 2: {
                                n5 = this.A1170 ? 1 : 0;
                                if (n5 == 0) {
                                    this.F(n);
                                    return;
                                }
                                this.A1170 = false;
                                this.h(7);
                                this.y1155 = false;
                                this.bF = 0;
                                this.aw = 0;
                                this.a();
                                this.Q();
                                this.v1097 = false;
                                n5 = this.T;
                                this.k1029 = n5 == 0 ? 0 : n4;
                                this.l = n2;
                                n5 = this.aq;
                                n11 = 8;
                                if (n5 < n11) return;
                                n5 = this.aP;
                                if (n5 == 0) return;
                                n5 = this.aq;
                                n11 = -1;
                                this.g(n5, n11);
                                return;
                            }
                            case 3: {
                                this.h(7);
                                n5 = 8;
                                this.a(n5);
                                return;
                            }
                            case 4: {
                                this.h(7);
                                n5 = 21;
                                this.a(n5);
                                this.c = 0;
                                return;
                            }
                            case 5: {
                                this.h(7);
                                n5 = 20;
                                this.a(n5);
                                this.c = 0;
                                return;
                            }
                            case 6: 
                        }
                        this.h(7);
                        this.c(n4);
                        this.l = n5 = 19;
                        return;
                    }
                    case -3: 
                    case 52: {
                        this.r = n5 = this.r - n4;
                        if (n5 < 0) {
                            this.r = n;
                            return;
                        }
                        n5 = this.r;
                        if (n5 != n2) return;
                        n5 = this.a() ? 1 : 0;
                        if (n5 != 0) return;
                        this.r = n5 = this.r - n4;
                        return;
                    }
                    case -4: 
                    case 54: 
                }
                this.r = n5 = this.r + 1;
                if (n5 > n) {
                    this.r = 0;
                    return;
                }
                n5 = this.r;
                if (n5 != n2) return;
                n5 = this.a() ? 1 : 0;
                if (n5 != 0) return;
                this.r = n5 = this.r + 1;
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void m(int n) {
        byte by = 6;
        byte by2 = 1;
        byte[] byArray = this.D1162;
        byte by3 = byArray[n];
        if (by3 > by) {
            byArray = this.D1162;
            byArray[n] = by = (byte)(byArray[n] - by2);
            return;
        }
        byArray = this.D1162;
        by3 = byArray[n];
        if (by3 != by) return;
        byArray = this.D1162;
        byArray[n] = by2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void m(int n, int n2) {
        boolean bl;
        this.x1126 = bl = true;
        int n3 = 0;
        int n4;
        byte[] byArray;
        int n5;
        while (n3 < (n5 = (byArray = this.o1098)[n4 = this.bw])) {
            int n6;
            byte[] byArray2;
            byArray = null;
            for (n5 = 0; n5 < (n4 = (byArray2 = this.o1098)[n6 = this.bw]); ++n5) {
                n4 = (n3 << 4) + n;
                n6 = (n5 << 4) + n2;
                if ((n4 = (int)(this.e(n4, n6) ? 1 : 0)) != 0) {
                    boolean[] blArray = this.a1127[n3];
                    blArray[n5] = bl;
                    continue;
                }
                boolean[] blArray = this.a1127[n3];
                blArray[n5] = false;
                this.x1126 = false;
            }
            ++n3;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void m(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        byte[] byArray;
        int n7;
        int n8;
        for (n8 = 0; n8 < (n7 = (byArray = this.j1064)[n3]); ++n8) {
            boolean[] blArray = this.b1059;
            byte[] byArray2 = this.f1063[n3];
            n6 = n8 * 3;
            n5 = byArray2[n6];
            n7 = blArray[n5];
            if (n7 == 0 && n3 == 0) continue;
            byte[] byArray3 = this.f1063[n3];
            n5 = n8 * 3;
            n7 = byArray3[n5];
            byte[] byArray4 = this.f1063[n3];
            n6 = n8 * 3 + 1;
            n5 = byArray4[n6] + n;
            n6 = this.bP;
            n5 -= n6;
            byte[] byArray5 = this.f1063[n3];
            n4 = n8 * 3 + 2;
            n6 = byArray5[n4] + n2 + 13;
            n4 = this.bQ;
            this.l(n7, n5, n6 -= n4);
        }
        if (n3 == 0) {
            byte[] byArray6;
            for (n8 = 0; n8 < (n7 = (byArray6 = this.j1064)[n3]); ++n8) {
                n7 = this.w1111 ? 1 : 0;
                if (n7 == 0) continue;
                byte[] byArray7 = this.f1063[n3];
                n5 = n8 * 3;
                n7 = byArray7[n5];
                if (n7 != (n5 = this.bv)) continue;
                byte[] byArray8 = this.f1063[n3];
                n5 = n8 * 3 + 1;
                n7 = byArray8[n5] + n;
                byte[][] byArray9 = this.e1058;
                n6 = this.bv;
                n5 = byArray9[n6][2] >> 1;
                n7 += n5;
                byte[] byArray10 = this.f1063[n3];
                n6 = n8 * 3 + 2;
                n5 = byArray10[n6] + n2;
                byte[][] byArray11 = this.e1058;
                n4 = this.bv;
                byte[] byArray12 = byArray11[n4];
                n4 = 3;
                n6 = byArray12[n4] >> 1;
                this.k(n7, n5 += n6);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean m(int n, int n2) {
        int n3 = this.X;
        if (n3 != 0) return 0 != 0;
        switch (n) {
            default: {
                return 0 != 0;
            }
            case 8: 
            case 9: 
        }
        n3 = a.g(n2);
        if (n3 == 0) return 0 != 0;
        return 1 != 0;
    }

    private void n() {
        int n;
        int n2 = 300;
        int n3 = 4;
        int n4 = 2;
        int n5 = -176;
        this.u = n = this.u - n4;
        if (n < n5) {
            this.u = 0;
        }
        this.w = n = this.w - n4;
        if (n < n5) {
            this.w = 0;
        }
        this.v = n = this.v + 4;
        if (n > 0) {
            this.v = 0;
        }
        n = this.x;
        n5 = 16;
        this.x = n -= n5;
        if (n < n2) {
            this.x = n2;
        }
        this.t = n = this.t - 1;
        Image image = this.a1013[n3][n3];
        n5 = -image.getWidth() * 5;
        if (n < n5) {
            this.t = 0;
        }
    }

    private final void n(int n) {
        int n2;
        int n3 = 7;
        Object object = this.b1066[n];
        object[n3] = n2 = object[n3] + 1;
        object = this.l1083;
        int[] nArray = this.b1066[n];
        int n4 = 6;
        int n5 = nArray[n4] >> 1;
        object = object[n5];
        int n6 = ((int[])object).length;
        n5 = 1;
        if (n2 > (n6 -= n5)) {
            object = this.b1066[n];
            n2 = 0;
            object[n3] = 0;
        }
    }

    private void n(int n, int n2) {
        int n3;
        int n4 = 1;
        int n5 = 0;
        while (n5 < (n3 = this.bt)) {
            int[] nArray = this.c1107[n5];
            Object object = this.o1098;
            int n6 = nArray[2];
            n3 = object[n6] << 3;
            n6 = nArray[0] + n3;
            int n7 = nArray[n4] + n3;
            byte[] byArray = this.s1102;
            int n8 = this.a(7, byArray, 6);
            object = this;
            n3 = this.a(n6, n7, n, n2, n8) ? 1 : 0;
            if (n3 != 0) {
                n3 = 17;
                nArray[n3] = n4;
            }
            n5 = n3 = n5 + 1;
        }
    }

    private void n(int n, int n2, int n3) {
        int n4 = 16422227;
        int n5 = 16382577;
        int n6 = 20;
        int n7 = 1;
        Object object = this.v1109;
        int n8 = ((byte[])object).length;
        if (n3 < n8 && n3 > 0) {
            n8 = 0;
            object = null;
            int n9 = 0;
            while (n9 < (n8 = 7)) {
                object = this.p1108;
                int n10 = n3 - n7;
                object = object[n10];
                n10 = n9 << 1;
                n8 = object[n10];
                n10 = n + n8;
                object = this.p1108;
                n6 = n3 - n7;
                object = object[n6];
                n6 = (n9 << 1) + 1;
                n6 = object[n6] + n2 + 13;
                object = this.v1109;
                int n11 = n3 - n7;
                n11 = object[n11] << 1;
                object = this;
                this.g(n10, n6, n11, n4, n5);
                n9 = n8 = n9 + 1;
            }
        } else if (n3 == 0) {
            int n12 = n - n6;
            n8 = n2 - n6;
            n6 = n8 + 13;
            int n13 = 40;
            object = this;
            this.g(n12, n6, n13, n4, n5);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean n(int n, int n2) {
        int n3 = this.X;
        int n4 = 2;
        if (n3 != n4) return 0 != 0;
        switch (n) {
            default: {
                return 0 != 0;
            }
            case 2: 
            case 6: 
        }
        n3 = a.g(n2);
        if (n3 == 0) return 0 != 0;
        return 1 != 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void o() {
        int n = 1;
        int n2 = this.U;
        switch (n2) {
            case 0: {
                this.z = n2 = this.z + 1;
                int n3 = this.O + 5;
                if (n2 <= n3) return;
                this.U = n;
            }
            default: {
                return;
            }
            case 1: 
        }
        this.z = n2 = this.z - n;
        int n4 = this.O;
        if (n2 >= n4) return;
        n2 = 0;
        this.U = 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void o(int n) {
        int n2;
        int[] nArray;
        int n3;
        block4: {
            block3: {
                int n4 = 5;
                n3 = 1;
                nArray = this.b1066[n];
                n2 = nArray[0] & 7;
                if (n2 != 0) return;
                n2 = nArray[0] & 0xF;
                if (n2 == 0 || (n2 = nArray[n3] & 7) != 0 || (n2 = nArray[n3] & 0xF) == 0) break block3;
                n2 = nArray[0];
                byte[][] byArray = this.k1081;
                int n5 = nArray[n4];
                byte[] byArray2 = byArray[n5];
                int n6 = byArray2[0] << 4;
                n2 += n6;
                int n7 = nArray[n3];
                byte[][] byArray3 = this.k1081;
                int n8 = nArray[n4];
                byte[] byArray4 = byArray3[n8];
                int n9 = byArray4[n3] << 4;
                int n10 = n7 + n9;
                if ((n2 = (int)(this.d(n2, n10) ? 1 : 0)) != 0) break block4;
                n2 = nArray[0];
                int n11 = nArray[n3];
                int n12 = nArray[n4];
                nArray[n4] = n2 = this.b(n2, n11, n12);
            }
            return;
        }
        n2 = nArray[0];
        int n13 = nArray[n3];
        nArray[n4] = n2 = this.c(n2, n13);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void o(int n, int n2) {
        int n3 = 0;
        int n4;
        while (n3 < (n4 = 5)) {
            byte[] byArray;
            int n5;
            long l = this.a1019;
            long l2 = n3;
            l += l2;
            l2 = 3;
            n4 = (int)(l &= l2);
            Image image = this.a1013[31][8];
            byte[] byArray2 = this.B1133[n3];
            int n6 = byArray2[0] + n;
            if (n4 == 0) {
                n5 = 4;
            } else {
                n5 = 0;
                byArray = null;
            }
            n6 += n5;
            byArray = this.B1133[n3];
            n5 = byArray[1] + n2;
            int n7 = n4 * 3;
            int n8 = 3;
            int n9 = 17;
            this.a(image, n6, n5, n7, 0, n8, n9, 0, 0);
            n3 = n4 = n3 + 1;
        }
        return;
    }

    private void o(int n, int n2, int n3) {
        int n4 = 1;
        Object object = this.a1013[38];
        int n5 = this.aM;
        Image image = object[n5];
        object = this.o1095;
        int n6 = this.ba - n4;
        Image image2 = object[n6][3];
        n6 = n + image2;
        object = this.o1095;
        int n7 = this.ba - n4;
        image2 = object[n7][4];
        n7 = n2 + image2;
        object = this.o1095;
        int n8 = this.ba - n4;
        image2 = object[n8][0];
        n8 = n3 * image2;
        object = this.o1095;
        Object object2 = this.ba - n4;
        object2 = object[object2][0];
        object = this.o1095;
        Object object3 = this.ba - n4;
        object3 = object[object3][n4];
        object = this;
        this.a(image, n6, n7, n8, 0, (int)object2, (int)object3, 0, 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean o(int n, int n2) {
        int n3 = this.X;
        int n4 = 2;
        if (n3 != n4) return 0 != 0;
        switch (n) {
            default: {
                return 0 != 0;
            }
            case 10: 
        }
        n3 = a.g(n2);
        if (n3 == 0) return 0 != 0;
        return 1 != 0;
    }

    private void p() {
        int n = 320;
        int n2 = 240;
        int n3 = 3;
        this.a1002.setClip(0, 0, n2, n);
        this.a1002.setColor(0xFCFFCD);
        this.a1002.fillRect(0, 0, n2, n);
        Image image = this.a1013[n3][n3];
        this.a(image, 0, 0, 13450878, true);
    }

    private void p(int n) {
        int n2;
        int n3 = 1;
        int[] nArray = this.b1066[n];
        Object object = this.b1066;
        int n4 = this.aP - n3;
        object = object[n4];
        n4 = nArray[0];
        Object object2 = nArray[n3];
        this.a(n4, (int)object2, false);
        for (n4 = 0; n4 < (object2 = 28); ++n4) {
            object2 = 24;
            if (n4 == object2) continue;
            nArray[n4] = object2 = (Object)object[n4];
        }
        this.aP = n2 = this.aP - n3;
        n2 = this.aT;
        int n5 = this.aX;
        if (n2 == n5 && (n2 = this.aP) == 0) {
            n2 = this.aq;
            this.h(n2);
        }
    }

    private void p(int n, int n2) {
        int n3;
        Object object;
        int n4;
        int n5 = 14;
        int n6 = 0;
        while (n6 < (n4 = (object = this.o1098)[n3 = this.bw])) {
            int n7 = 0;
            while (n7 < (n4 = (object = this.o1098)[n3 = this.bw])) {
                n4 = (n6 << 4) + n;
                n3 = n7 << 4;
                int n8 = n2 + n3;
                n3 = n4 + 1;
                int n9 = this.bP;
                n3 -= n9;
                n9 = n8 + 1;
                int n10 = this.bQ;
                n9 = n9 - n10 + 13;
                n10 = this.e(n4, n8) ? 1 : 0;
                object = this;
                n8 = n5;
                this.b(n3, n9, n5, n5, n10 != 0);
                n7 = n4 = n7 + 1;
            }
            n6 = n4 = n6 + 1;
        }
        this.q(n, n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void p(int n, int n2, int n3) {
        int n4;
        int n5 = 20;
        int n6 = 3;
        this.a1013[n6][n5].getWidth();
        int n7 = this.a1013[n6][n5].getHeight();
        Image[] imageArray = this.a1013[n6];
        Image image = imageArray[n5];
        if (n3 == 0) {
            n4 = 0;
            Object var7_8 = null;
        } else {
            n4 = 4;
        }
        n4 = n - n4;
        n5 = this.bP;
        n5 = n4 - n5;
        n4 = this.bQ;
        int n8 = n2 - n4;
        int n9 = n3 * 27;
        a a2 = this;
        this.a(image, n5, n8, n9, 0, 27, n7, 0, 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean p(int n, int n2) {
        int n3 = this.X;
        int n4 = 2;
        if (n3 != n4) return 0 != 0;
        switch (n) {
            default: {
                return 0 != 0;
            }
            case 8: 
            case 9: 
        }
        n3 = a.g(n2);
        if (n3 == 0) return 0 != 0;
        return 1 != 0;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void q() {
        int n = this.V;
        this.b(n, 13);
        Image image = this.a1013[3][3];
        Object var3_32 = null;
        int n2 = 1;
        Image image2 = this;
        this.a(image, 0, 0, 13450878, n2 != 0);
        image2 = this.a1002;
        int n3 = 240;
        int n4 = this.W;
        image2.setClip(0, 13, n3, n4);
        int n5 = this.a1013[4][7].getWidth();
        int n6 = 240 - n5 >> 1;
        int n7 = this.W;
        n5 = this.a1013[4][7].getHeight();
        int n8 = (n7 - n5 >> 1) + 13;
        image2 = this.a1002;
        Image image3 = this.a1013[4][7];
        int n9 = 0;
        byte[] byArray = null;
        image2.drawImage(image3, n6, n8, 0);
        image2 = this.a1013[4];
        n5 = 10;
        int n10 = image2[n5].getWidth() / 3;
        boolean bl = false;
        image2 = null;
        int n11 = 0;
        while (true) {
            void var2_20;
            int n12;
            Image[] imageArray;
            Object object;
            if (n11 >= (object = 3)) {
                int n13;
                int n14;
                int n15;
                image2 = this.a1002;
                Image[] imageArray2 = this.a1013[4];
                n9 = this.X + 14;
                Image image4 = imageArray2[n9];
                n9 = n6 + 176;
                Image[] imageArray3 = this.a1013[4];
                n4 = this.X + 14;
                int n16 = imageArray3[n4].getWidth();
                n9 = n9 - n16 + 20;
                n4 = this.V;
                int n17 = 310 - n4;
                imageArray = this.a1013[4];
                n2 = this.X + 14;
                n4 = imageArray[n2].getHeight();
                int n18 = n17 - n4;
                image2.drawImage(image4, n9, n18, 0);
                this.a1002.setClip(0, 0, 240, 320);
                int n19 = this.W + 13;
                Image image5 = this.a1013[3][6];
                image2 = this;
                super.a(image5, 0, n19, 12010381, true);
                int n20 = this.a1013[3][6].getHeight();
                n6 = n19 + n20;
                this.a1002.setColor(15455661);
                this.a1002.fillRect(0, n6, 240, 25);
                n5 = this.a1013[4][8].getWidth();
                n8 = 240 - n5 >> 1;
                int n21 = this.a1013[4][8].getHeight() >> 1;
                n11 = n6 - n21 - 9;
                image2 = this.a1002;
                Image image6 = this.a1013[4][8];
                image2.drawImage(image6, n8, n11, 0);
                n10 = this.a1013[4][12].getWidth() / 3;
                Image image7 = this.a1013[4][12];
                int n22 = this.a1013[4][8].getWidth() - n10 >> 1;
                n9 = n8 + n22;
                int n23 = this.a1013[4][8].getHeight();
                int n25 = this.a1013[4][12].getHeight();
                n25 = (n23 - n25 >> 1) + n11 + 4;
                int n26 = this.X;
                n4 = n10 * n26;
                n12 = this.a1013[4][12].getHeight();
                image2 = this;
                super.a(image7, n9, n25, n4, 0, n10, n12, 0, 0);
                this.bR = n15 = n8 + 4;
                int n27 = this.a1013[4][8].getWidth() + n8 - 4;
                n5 = this.a1013[3][24].getWidth();
                this.bS = n14 = n27 - n5;
                this.bT = n13 = (this.a1013[4][8].getHeight() >> 1) + n11;
                int n28 = this.bR;
                n5 = this.bS;
                n9 = this.bT;
                super.d(n28, n5, n9);
                n9 = n6 + 25;
                n4 = this.V - 32;
                image2 = this;
                super.c(0, n9, 240, n4, 0);
                int n29 = n6 + 6;
                n2 = this.j + 1;
                super.a(0, 10, n29, 63, n2, 0);
                this.a1002.setColor(13971834);
                image2 = this.a1002;
                String[] stringArray = this.b1015;
                n9 = this.X + 25;
                String string = stringArray[n9];
                int n30 = n6 + 8;
                image2.drawString(string, 28, n30, 0);
                int n31 = n6 + 6;
                n2 = this.j + 1;
                image2 = this;
                super.a(1, 167, n31, 63, n2, 1);
                int n32 = this.X * 11 + 28;
                n9 = n6 + 8;
                super.a(n32, 186, n9);
                this.a1002.setColor(5271185);
                image2 = this.b1015;
                n5 = this.X + 76;
                String string2 = image2[n5];
                n4 = n6 + 35;
                image2 = this;
                super.a(string2, 0, 8, n4, 224, 50);
                n9 = this.a1013[4][25].getWidth();
                n5 = 240 - n9 >> 1;
                super.c(7, n5, 0);
                return;
            }
            object = this.X;
            if (object == n11) {
                image2 = this.a1013[4];
                n5 = 10;
                Image image8 = image2 = image2[n5];
            } else {
                image2 = this.a1013[4];
                n5 = 11;
                Image image9 = image2 = image2[n5];
            }
            image2 = (Image)this.a1028[n11];
            byArray = null;
            object = image2[0];
            n9 = n6 + object;
            object = this.a1028[n11][1];
            int n33 = n8 + object;
            n4 = n10 * n11;
            n2 = 0;
            Image image10 = null;
            n12 = this.a1013[4][10].getHeight();
            image2 = this;
            super.a((Image)var2_20, n9, n33, n4, 0, n10, n12, 0, 0);
            object = this.X;
            if (object == n11) {
                image2 = this.a1002;
                Image image11 = this.a1013[4][13];
                byArray = this.a1028[n11];
                n9 = byArray[0] + n6;
                int n33 = this.a1013[4][13].getWidth();
                n33 = n10 - n33 >> 1;
                n9 += n33;
                byte[] byArray2 = this.a1028[n11];
                n33 = byArray2[1] + n8;
                n4 = this.a1013[4][10].getHeight();
                image10 = this.a1013[4];
                n12 = 13;
                image10 = image10[n12];
                n2 = image10.getHeight();
                n4 = n4 - n2 >> 1;
                n33 += n4;
                n4 = 0;
                imageArray = null;
                image2.drawImage(image11, n9, n33, 0);
            }
            n11 = object = n11 + 1;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void q(int n) {
        Image image;
        int[][] nArray = this.b1066;
        int[] nArray2 = nArray[n];
        int n2 = nArray2[10];
        int n3 = 4;
        if (n2 == n3) {
            Image[] imageArray = this.a1013[29];
            n3 = 22;
            Image image2 = imageArray[n3];
            n2 = nArray2[0] - 8;
            int n5 = this.bP;
            n5 = n2 - n5;
            n2 = nArray2[1] - 8;
            int n7 = this.bQ;
            n7 = (n2 -= n7) + 13;
            int n8 = 16;
            boolean bl = false;
            int n9 = 16;
            int n10 = 16;
            a a2 = this;
            this.a(image2, n5, n7, n8, 0, n9, n10, 0, 0);
            return;
        }
        n2 = 0;
        Object var2_5 = null;
        int n11 = 0;
        while (n11 < (n2 = 7)) {
            Image[] imageArray = this.a1013[31];
            n3 = 0;
            image = imageArray[0];
            n2 = nArray2[0];
            byte[][][] byArray = this.e1093;
            int n12 = nArray2[10];
            int n13 = 3 - n12;
            byte[] byArray2 = byArray[n13][n11];
            int n14 = byArray2[0];
            n2 = n2 + n14 - 16;
            int n14 = this.bP;
            n14 = n2 - n14;
            n2 = nArray2[1];
            byte[][][] byArray3 = this.e1093;
            int n15 = nArray2[10];
            n12 = 3 - n15;
            byte[] byArray4 = byArray3[n12][n11];
            n13 = byArray4[1];
            n2 = n2 + n13 - 16;
            int n13 = this.bQ;
            n13 = n2 - n13 + 13;
            n12 = nArray2[10];
            n12 = (3 - n12) * 5;
            n15 = 0;
            int n16 = 5;
            int n17 = 5;
            a a3 = this;
            this.a(image, n14, n13, n12, 0, n16, n17, 0, 0);
            n11 = n2 = n11 + 1;
        }
        n2 = nArray2[16];
        image = null;
        n3 = nArray2[0];
        int n18 = this.bP;
        n3 = n3 - n18 - 4;
        int n19 = nArray2[1];
        int n20 = this.bQ;
        int n21 = n19 - n20 + 13 - 16;
        int n22 = nArray2[10] << 1;
        int n23 = n21 + n22;
        this.b(n2, n3, n23);
    }

    private void q(int n, int n2) {
        Object object;
        long l;
        int n3;
        int n4;
        byte[] byArray;
        int n5;
        Object object2;
        int n6;
        Object object3;
        int n7;
        int n8;
        int n9 = 3;
        int n10 = 1;
        long l2 = 1L;
        Image image = null;
        for (n8 = 0; n8 < (n7 = 4); ++n8) {
            n7 = this.x1126 ? 1 : 0;
            if (n7 == 0 || (n7 = (object3 = this.p1099)[n6 = this.bw]) != 0 && (n7 = (int)(this.a(n, n2, n8) ? 1 : 0)) == 0) continue;
            object3 = this.a1013[n9][16];
            object2 = this.o1098;
            n5 = this.bw;
            n6 = (object2[n5] << 3) + n;
            n5 = this.Q1159[n8][0];
            byArray = this.o1098;
            n4 = this.bw;
            n3 = (byArray[n4] << 3) + 8;
            l = this.a1019 & l2;
            n4 = (int)l << 1;
            n6 += (n5 *= (n3 += n4));
            object = this.o1098;
            n3 = this.bw;
            n5 = (object[n3] << 3) + n2;
            byArray = this.Q1159[n8];
            n3 = byArray[n10];
            byte[] byArray2 = this.o1098;
            int n11 = this.bw;
            n4 = (byArray2[n11] << 3) + 8;
            long l3 = this.a1019 & l2;
            n11 = (int)l3 << 1;
            this.f((Image)object3, n6, n5 += (n3 *= (n4 += n11)), n8);
        }
        n8 = this.l;
        n7 = 14;
        if (n8 == n7) {
            image = this.a1013[n9][17];
            object3 = this.o1098;
            n6 = this.bw;
            n7 = (object3[n6] << 3) + n;
            object2 = this.Q1159;
            n5 = this.aA;
            n6 = object2[n5][0];
            object = this.o1098;
            n3 = this.bw;
            n5 = (object[n3] << 3) + 8;
            long l4 = this.a1019 & l2;
            n3 = (int)l4 << 1;
            n7 += (n6 *= (n5 += n3));
            object2 = this.o1098;
            n5 = this.bw;
            n6 = (object2[n5] << 3) + n2;
            object = this.Q1159;
            n3 = this.aA;
            object = object[n3];
            n5 = object[n10];
            byArray = this.o1098;
            n4 = this.bw;
            n3 = (byArray[n4] << 3) + 8;
            l = this.a1019 & l2;
            n4 = (int)l << 1;
            n5 = this.aA;
            this.f(image, n7, n6 += (n5 *= (n3 += n4)), n5);
        }
    }

    private void q(int n, int n2, int n3) {
        int n4 = 32;
        this.a(n4, n);
        Graphics graphics = this.a1002;
        Image image = this.a1013[n4][n];
        graphics.drawImage(image, n2, n3, 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean q(int n, int n2) {
        int n3 = this.X;
        int n4 = 2;
        if (n3 != n4) return 0 != 0;
        switch (n) {
            default: {
                return 0 != 0;
            }
            case 7: 
        }
        n3 = a.g(n2);
        if (n3 == 0) return 0 != 0;
        return 1 != 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void r() {
        int n = 18;
        int n2 = 2;
        int n3 = 1;
        int n4 = 0;
        Image image = null;
        int n5 = 4;
        this.n();
        int n6 = this.h1047;
        switch (n6) {
            case -3: 
            case 52: {
                this.X = n6 = this.X + 1;
                if (n6 <= n2) return;
                this.X = 0;
                return;
            }
            case -4: 
            case 54: {
                this.X = n6 = this.X - n3;
                if (n6 >= 0) return;
                this.X = n2;
                return;
            }
            case -6: 
            case -5: 
            case 53: {
                this.l = 17;
                this.ac = 0;
                n4 = this.a1013[n5][n].getWidth();
                this.Y = n6 = 240 - n4 >> 1;
                n4 = this.V;
                n6 = 320 - n4;
                n4 = this.a1013[n5][n].getHeight();
                this.Z = n6 = n6 - n4 >> 1;
                Image image2 = this.a1013[n5][19];
                this.aa = n6 = -image2.getWidth();
                n4 = this.V;
                n6 = 320 - n4;
                image = this.a1013[n5];
                n5 = 19;
                image = image[n5];
                n4 = image.getHeight();
                this.ab = n6 = n6 - n4 >> 1;
                return;
            }
            case -7: {
                this.l = n3;
                this.c(0);
                n6 = 7;
                n4 = -1;
                this.g(n6, n4);
                return;
            }
        }
    }

    private void r(int n) {
        int n2;
        int n3;
        int n4;
        int n5;
        Object object;
        Object object2;
        int[] nArray;
        int n6;
        Object object3 = this.b1066;
        int[] nArray2 = object3[n];
        int n7 = nArray2[13];
        if (n7 > 0) {
            object3 = this.a1013[31];
            n6 = 5;
            nArray = object3[n6];
            n7 = nArray2[0] - 8;
            object2 = this.bP;
            object2 = n7 - object2;
            n7 = nArray2[1] - 16;
            object = this.bQ;
            object = n7 - object + 13;
            n7 = nArray2[20] - 1;
            n5 = n7 * 21;
            n4 = 0;
            n3 = 21;
            n2 = 26;
            object3 = this;
            this.a((Image)nArray, (int)object2, (int)object, n5, 0, n3, n2, 0, 0);
        }
        if ((n7 = nArray2[15]) > 0) {
            object3 = this.a1013[31];
            n6 = 7;
            nArray = object3[n6];
            n7 = nArray2[0] - 8;
            object2 = this.bP;
            object2 = n7 - object2;
            n7 = nArray2[1] - 16;
            object = this.bQ;
            object = n7 - object + 13;
            n7 = nArray2[22];
            n5 = n7 * 14;
            n4 = 0;
            n3 = 14;
            n2 = 11;
            object3 = this;
            this.a((Image)nArray, (int)object2, (int)object, n5, 0, n3, n2, 0, 0);
        }
        if ((n7 = nArray2[14]) > 0) {
            object3 = this.a1013[31];
            n6 = 4;
            nArray = object3[n6];
            n7 = nArray2[0] - 8;
            object2 = this.bP;
            object2 = n7 - object2;
            n7 = nArray2[1] - 16;
            object = this.bQ;
            object = n7 - object + 13;
            n7 = nArray2[21];
            n5 = n7 * 14;
            n4 = 0;
            n3 = 14;
            n2 = 11;
            object3 = this;
            this.a((Image)nArray, (int)object2, (int)object, n5, 0, n3, n2, 0, 0);
        }
        if ((n7 = nArray2[11]) > 0) {
            object3 = this.a1013[31];
            n6 = 6;
            nArray = object3[n6];
            n7 = nArray2[0] - 8;
            Object object4 = this.n1094;
            object = nArray2[18];
            object4 = object4[object];
            object2 = object4[4];
            n7 += object2;
            object2 = this.bP;
            object2 = n7 - object2;
            n7 = nArray2[1] - 16;
            Object object5 = this.n1094;
            n5 = nArray2[18];
            object5 = object5[n5];
            object = object5[5];
            n7 += object;
            object = this.bQ;
            n7 -= object;
            object = n7 + 13;
            object3 = this.n1094;
            n5 = nArray2[18];
            n5 = object3[n5][0];
            object3 = this.n1094;
            n4 = nArray2[18];
            n4 = object3[n4][1];
            object3 = this.n1094;
            n3 = nArray2[18];
            n3 = object3[n3][2];
            object3 = this.n1094;
            n2 = nArray2[18];
            n2 = object3[n2][3];
            object3 = this;
            this.a((Image)nArray, (int)object2, (int)object, n5, n4, n3, n2, 0, 0);
        }
        if ((n7 = nArray2[12]) > 0) {
            object3 = this.a1013[31];
            n6 = 3;
            nArray = object3[n6];
            n7 = nArray2[0] - 16;
            object2 = this.bP;
            object2 = n7 - object2;
            n7 = nArray2[1] - 16;
            object = this.bQ;
            object = n7 - object + 13;
            n7 = nArray2[19];
            n5 = n7 * 28;
            n4 = 0;
            n3 = 28;
            n2 = 23;
            object3 = this;
            this.a((Image)nArray, (int)object2, (int)object, n5, 0, n3, n2, 0, 0);
        }
    }

    private void r(int n, int n2, int n3) {
        int n4 = 29;
        Object object = this.a1002;
        Image image = this.a1013[n4][42];
        int n5 = n + 4;
        int n6 = n2 - 15;
        object.drawImage(image, n5, n6, 0);
        int n7 = 5;
        if (n3 < n7) {
            object = this.a1013[n4];
            int n8 = 41;
            image = object[n8];
            n5 = n + 2;
            n7 = n2 - 18;
            byte[] byArray = this.z1148;
            n6 = byArray[n3] + n7;
            n4 = n3 * 9;
            int n9 = 9;
            int n10 = 26;
            object = this;
            this.a(image, n5, n6, n4, 0, n9, n10, 0, 0);
        }
    }

    private void s() {
        int n = 6;
        int n2 = 4;
        int n3 = 320;
        int n4 = 3;
        int n5 = this.ad;
        this.b(n5, 13);
        Object object = this.a1013[n4][n4];
        String[] stringArray = this;
        this.a((Image)object, 0, 0, 13450878, true);
        stringArray = this.a1002;
        object = this.a1013[n2][18];
        int n6 = this.Y;
        int n7 = this.Z;
        stringArray.drawImage((Image)object, n6, n7, 0);
        stringArray = this.a1002;
        object = this.a1013[n2][19];
        n6 = this.aa;
        n7 = this.ab;
        stringArray.drawImage((Image)object, n6, n7, 0);
        this.a1002.setColor(15455661);
        stringArray = this.a1002;
        int n8 = this.ad;
        n8 = n3 - n8;
        n7 = this.ad;
        stringArray.fillRect(0, n8, 240, n7);
        object = this.a1013[n4][n];
        n5 = this.ad;
        n6 = n3 - n5;
        stringArray = this;
        this.a((Image)object, 0, n6, 12010381, true);
        n5 = this.ad;
        n5 = n3 - n5;
        n8 = this.a1013[n4][n].getHeight();
        n6 = n5 + n8 + 8;
        int n9 = this.ad - 32;
        object = this;
        this.c(0, n6, 240, n9, 0);
        n8 = this.ad;
        n8 = n3 - n8;
        n6 = this.a1013[n4][n].getHeight();
        n8 = n8 + n6 + 6;
        this.e(2, n2, n8);
        object = this.b1015;
        n6 = this.ac + 79;
        n8 = object[n6].length();
        n6 = this.k;
        n5 = 240 - (n8 *= n6) - 2 >> 1;
        n8 = this.ad;
        n8 = n3 - n8 - 2;
        Object object2 = this.b1015;
        n7 = this.ac + 79;
        object2 = object2[n7];
        this.a((String)object2, n5, n8);
        n6 = n5 - n2;
        n7 = this.a1013[n4][24].getWidth();
        this.bR = n6 -= n7;
        object2 = this.b1015;
        n7 = this.ac + 79;
        n6 = object2[n7].length();
        n7 = this.k;
        this.bS = n5 = n5 + (n6 *= n7) + 2 + 4;
        n5 = this.j + 1;
        n6 = this.a1013[n4][24].getHeight();
        this.bT = n5 = (n5 - n6 >> 1) + n8;
        n5 = this.bR;
        n8 = this.bS;
        n6 = this.bT;
        this.d(n5, n8, n6);
        this.a1002.setColor(5271185);
        stringArray = this.b1015;
        n8 = this.ac + 79 + 2;
        object = stringArray[n8];
        n5 = this.ad;
        n5 = n3 - n5;
        n7 = this.a1013[n4][n].getHeight();
        n7 = n5 + n7 + 8 + 12;
        int n10 = this.ad - 32;
        stringArray = this;
        super.a((String)object, 0, 8, n7, 224, n10);
        n6 = this.a1013[n2][25].getWidth();
        n8 = 240 - n6 >> 1;
        super.c(9, n8, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void s(int n) {
        int n2;
        int n3 = 1;
        int n4 = 27;
        int n5 = 26;
        int n6 = 4;
        int[] nArray = this.b1066[n];
        int n7 = nArray[n5];
        if (n7 != 0 && (n7 = nArray[n4]) != (n2 = -2)) {
            nArray[n4] = n7 = nArray[n4] + 1;
            byte[][] byArray = this.o1095;
            int n8 = nArray[n5] - n3;
            byte[] byArray2 = byArray[n8];
            byte by = byArray2[n8 = 2];
            if (n7 >= by) {
                int n9;
                nArray[n4] = 0;
                n7 = nArray[n5];
                int n10 = 8;
                if (n7 == n10 || (n7 = nArray[n5]) == (n9 = 6)) {
                    nArray[n4] = n7 = -2;
                }
            }
        }
        n7 = nArray[n5];
        switch (n7) {
            case 7: {
                n7 = nArray[n6];
                int n11 = this.aZ;
                if (n7 <= n11) return;
                n7 = nArray[0] & 7;
                if (n7 != 0) return;
                n7 = nArray[n3] & 7;
                if (n7 != 0) return;
                nArray[n6] = n7 = this.aZ;
            }
            default: {
                return;
            }
            case 2: 
        }
        n7 = nArray[n6];
        int n12 = this.aZ;
        if (n7 != n12) return;
        n7 = nArray[n6];
        if (n7 >= n6) return;
        n7 = nArray[0] & 7;
        if (n7 != 0) return;
        n7 = nArray[n3] & 7;
        if (n7 != 0) return;
        nArray[n6] = n7 = nArray[n6] << 1;
    }

    private void s(int n, int n2, int n3) {
        this.t(n, n2, n3);
        this.u(n, n2, n3);
    }

    /*
     * Unable to fully structure code
     */
    private void t() {
        block24: {
            block23: {
                block25: {
                    var1_1 = 18;
                    var2_2 = 240;
                    var3_3 = 1;
                    var4_4 = 4;
                    this.n();
                    var5_5 = this.ae;
                    block0 : switch (var5_5) lbl-1000:
                    // 13 sources

                    {
                        default: {
                            return;
                        }
                        case 0: {
                            var5_5 = this.h1047;
                            switch (var5_5) {
                                default: {
                                    ** GOTO lbl-1000
                                }
                                case -7: {
                                    this.l = var5_5 = 15;
                                    ** GOTO lbl-1000
                                }
                                case -3: 
                                case 52: {
                                    this.ac = var5_5 = this.ac - var3_3;
                                    if (var5_5 >= 0) ** GOTO lbl26
                                    this.ac = var3_3;
                                    this.aa = var5_5 = 320;
lbl23:
                                    // 2 sources

                                    while (true) {
                                        this.ae = var3_3;
                                        ** GOTO lbl-1000
                                        break;
                                    }
lbl26:
                                    // 1 sources

                                    this.Y = var5_5 = 320;
                                    ** continue;
                                }
                                case -4: 
                                case 54: {
                                    this.ac = var5_5 = this.ac + 1;
                                    if (var5_5 <= var3_3) ** GOTO lbl37
                                    this.ac = 0;
                                    var6_6 = this.a1013[var4_4][var1_1];
                                    this.Y = var5_5 = -var6_6.getWidth();
lbl34:
                                    // 2 sources

                                    while (true) {
                                        this.ae = var5_5 = 2;
                                        ** GOTO lbl-1000
                                        break;
                                    }
lbl37:
                                    // 1 sources

                                    var6_7 = this.a1013[var4_4];
                                    var7_16 = 19;
                                    var6_7 = var6_7[var7_16];
                                    this.aa = var5_5 = -var6_7.getWidth();
                                    ** continue;
                                }
                                case -6: 
                                case -5: 
                                case 53: 
                            }
                            this.l = var5_5 = 16;
                            ** GOTO lbl-1000
                        }
                        case 1: {
                            var5_5 = this.ac;
                            if (var5_5 != 0) ** GOTO lbl71
                            this.Y = var5_5 = this.Y - 20;
                            var8_21 = this.a1013[var4_4][var1_1];
                            var7_17 = var8_21.getWidth();
                            if (var5_5 >= (var7_17 = var2_2 - var7_17 >> 1)) break block24;
                            var6_8 = this.a1013[var4_4][var1_1];
                            var5_5 = var6_8.getWidth();
                            this.Y = var5_5 = var2_2 - var5_5 >> 1;
                            var5_5 = var3_3;
lbl56:
                            // 2 sources

                            while (true) {
                                this.aa = var7_17 = this.aa - 20;
                                var9_25 = this.a1013[var4_4];
                                var2_2 = 19;
                                var10_27 = -(var9_25 = var9_25[var2_2]).getWidth();
                                if (var7_17 >= var10_27) break block23;
                                var8_21 = this.a1013[var4_4];
                                var10_27 = 19;
                                var8_21 = var8_21[var10_27];
                                this.aa = var7_17 = -var8_21.getWidth();
                                var7_17 = var3_3;
lbl67:
                                // 2 sources

                                while (true) {
                                    if (var5_5 == 0 || var7_17 == 0) ** GOTO lbl-1000
                                    this.ae = 0;
                                    ** GOTO lbl-1000
                                    break;
                                }
                                break;
                            }
lbl71:
                            // 1 sources

                            this.aa = var5_5 = this.aa - 20;
                            var8_22 = this.a1013[var4_4];
                            var10_28 = 19;
                            var8_22 = var8_22[var10_28];
                            var7_18 = var8_22.getWidth();
                            if (var5_5 >= (var7_18 = var2_2 - var7_18 >> 1)) break block25;
                            var6_9 = this.a1013[var4_4];
                            var7_18 = 19;
                            var6_9 = var6_9[var7_18];
                            var5_5 = var6_9.getWidth();
                            this.aa = var5_5 = var2_2 - var5_5 >> 1;
                            var5_5 = var3_3;
lbl83:
                            // 2 sources

                            while (true) {
                                this.Y = var7_18 = this.Y - 20;
                                var9_26 = this.a1013[var4_4][var1_1];
                                var10_28 = -var9_26.getWidth();
                                if (var7_18 >= var10_28) break block0;
                                var8_22 = this.a1013[var4_4][var1_1];
                                this.Y = var7_18 = -var8_22.getWidth();
                                var7_18 = var3_3;
lbl91:
                                // 2 sources

                                while (true) {
                                    if (var5_5 == 0 || var7_18 == 0) ** GOTO lbl-1000
                                    this.ae = 0;
                                    ** GOTO lbl-1000
                                    break;
                                }
                                break;
                            }
                        }
                        case 2: {
                            var5_5 = this.ac;
                            if (var5_5 != 0) ** GOTO lbl115
                            this.Y = var5_5 = this.Y + 20;
                            var8_23 = this.a1013[var4_4][var1_1];
                            var7_19 = var8_23.getWidth();
                            if (var5_5 <= (var7_19 = var2_2 - var7_19 >> 1)) ** GOTO lbl145
                            var6_10 = this.a1013[var4_4][var1_1];
                            var5_5 = var6_10.getWidth();
                            this.Y = var5_5 = var2_2 - var5_5 >> 1;
                            var5_5 = var3_3;
lbl106:
                            // 2 sources

                            while (true) {
                                this.aa = var7_19 = this.aa + 20;
                                if (var7_19 <= var2_2) ** GOTO lbl142
                                this.aa = var2_2;
                                var7_19 = var3_3;
lbl111:
                                // 2 sources

                                while (true) {
                                    if (var5_5 == 0 || var7_19 == 0) ** GOTO lbl-1000
                                    this.ae = 0;
                                    ** GOTO lbl-1000
                                    break;
                                }
                                break;
                            }
lbl115:
                            // 1 sources

                            this.aa = var5_5 = this.aa + 20;
                            var8_24 = this.a1013[var4_4];
                            var10_29 = 19;
                            var8_24 = var8_24[var10_29];
                            var7_20 = var8_24.getWidth();
                            if (var5_5 <= (var7_20 = var2_2 - var7_20 >> 1)) ** GOTO lbl139
                            var6_11 = this.a1013[var4_4];
                            var7_20 = 19;
                            var6_11 = var6_11[var7_20];
                            var5_5 = var6_11.getWidth();
                            this.aa = var5_5 = var2_2 - var5_5 >> 1;
                            var5_5 = var3_3;
lbl127:
                            // 2 sources

                            while (true) {
                                this.Y = var7_20 = this.Y + 20;
                                if (var7_20 <= var2_2) ** GOTO lbl136
                                this.Y = var2_2;
                                var7_20 = var3_3;
lbl132:
                                // 2 sources

                                while (true) {
                                    if (var5_5 != 0 && var7_20 != 0) {
                                        this.ae = 0;
                                    }
                                    ** GOTO lbl-1000
                                    break;
                                }
lbl136:
                                // 1 sources

                                var7_20 = 0;
                                var8_24 = null;
                                ** continue;
                                break;
                            }
lbl139:
                            // 1 sources

                            var5_5 = 0;
                            var6_12 = null;
                            ** continue;
lbl142:
                            // 1 sources

                            var7_19 = 0;
                            var8_23 = null;
                            ** continue;
lbl145:
                            // 1 sources

                            var5_5 = 0;
                            var6_13 = null;
                            ** continue;
                        }
                    }
                    var7_18 = 0;
                    var8_22 = null;
                    ** while (true)
                }
                var5_5 = 0;
                var6_14 = null;
                ** while (true)
            }
            var7_17 = 0;
            var8_21 = null;
            ** while (true)
        }
        var5_5 = 0;
        var6_15 = null;
        ** while (true)
    }

    /*
     * Enabled aggressive block sorting
     */
    private void t(int n) {
        boolean bl;
        int n2;
        int n3;
        int[] nArray;
        int[] nArray2 = this.c1107[n];
        int[][] nArray3 = this.c1107;
        int n4 = this.bt;
        int n5 = 1;
        int[] nArray4 = nArray3[n4 -= n5];
        int n6 = this.bz;
        n4 = this.b(n);
        this.bz = n6 += n4;
        n6 = nArray2[3];
        n4 = 6;
        if (n6 == n4) {
            n6 = nArray2[2];
            n4 = nArray2[3];
            if ((n6 = (int)(this.q(n6, n4) ? 1 : 0)) != 0) {
                Object var3_4 = null;
                for (n6 = 0; n6 < (n4 = this.bt); ++n6) {
                    nArray = this.c1107[n6];
                    n5 = 17;
                    n3 = 0;
                    nArray[n5] = 0;
                }
            }
            boolean[] blArray = this.f1106;
            n4 = nArray2[2];
            n5 = 0;
            blArray[n4] = false;
        }
        n4 = 0;
        nArray = null;
        nArray2[4] = 0;
        n6 = nArray2[2];
        switch (n6) {
            case 2: 
            case 6: 
            case 8: 
            case 9: 
            case 10: {
                n4 = nArray2[0];
                n5 = nArray2[1];
                n6 = 5;
                n3 = nArray2[n6];
                n2 = 0;
                bl = false;
                boolean bl2 = true;
                a a2 = this;
                this.a(n4, n5, n3, (byte)0, 0, bl2);
            }
        }
        n4 = nArray2[0];
        n5 = nArray2[1];
        n2 = nArray2[2];
        bl = false;
        a a3 = this;
        n3 = n;
        this.c(n4, n5, n, n2, false);
        n6 = this.bt;
        n4 = 1;
        if (n != (n6 -= n4)) {
            n4 = nArray4[0];
            n5 = nArray4[1];
            n6 = 2;
            n2 = nArray4[n6];
            bl = true;
            this.c(n4, n5, n, n2, bl);
        }
        Object var3_10 = null;
        for (n6 = 0; n6 < (n4 = 18); ++n6) {
            nArray2[n6] = n4 = nArray4[n6];
        }
        this.bt = n6 = this.bt - 1;
    }

    private void t(int n, int n2, int n3) {
        int n4 = 3;
        if (n3 < n4) {
            Object object = this.a1013[29];
            int n5 = 18;
            Image image = object[n5];
            int n6 = this.N1149[n3][4] + n;
            int n7 = this.bP;
            n7 = n6 - n7;
            n6 = this.N1149[n3][5] + n2;
            int n8 = this.bQ;
            n6 -= n8;
            n8 = n6 + 13;
            byte by = this.N1149[n3][0];
            byte by2 = this.N1149[n3][1];
            byte by3 = this.N1149[n3][2];
            n4 = this.N1149[n3][n4];
            object = this;
            this.a(image, n7, n8, by, by2, by3, n4, 0, 0);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void u() {
        int n;
        Object object;
        int n2 = 5;
        int n3 = 2;
        int n4 = 8;
        int n5 = 1;
        this.n();
        Object object2 = this.h1047;
        switch (object2) {
            case -6: 
            case -5: 
            case 53: {
                object2 = this.T;
                if (object2 == 0) {
                    object2 = this.aN;
                    if (object2 > 0) {
                        this.F(n2);
                        break;
                    }
                    this.ag = 0;
                    object = this.b1069;
                    n = this.aN;
                    this.bN = object2 = object[n][0] - n4;
                    this.bP = object2;
                    object = this.b1069;
                    n = this.aN;
                    object = object[n];
                    this.bO = object2 = (Object)(object[n5] - n4);
                    this.bQ = object2;
                    this.P();
                    this.a(n3);
                    break;
                }
                object = this.d1073;
                n = this.aN;
                object2 = object[n];
                if (object2 == 0) {
                    this.F(n2);
                    break;
                }
                this.ag = 0;
                object = this.b1069;
                n = this.aN;
                this.bN = object2 = object[n][0] - n4;
                this.bP = object2;
                object = this.b1069;
                n = this.aN;
                object = object[n];
                this.bO = object2 = (Object)(object[n5] - n4);
                this.bQ = object2;
                this.P();
                this.a(n3);
                break;
            }
            case -7: {
                object2 = this.t1089;
                if (object2 == 0) {
                    this.aO = 0;
                    this.aN = 0;
                    this.l = object2 = 17;
                    break;
                }
                this.aO = 0;
                this.aN = 0;
                this.B();
                break;
            }
        }
        object2 = this.aN;
        switch (object2) {
            default: {
                object = this.z1131;
                n = this.aN;
                object = object[n];
                object2 = ((byte[][])object).length - n5;
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                object = this.z1131;
                n = this.aN;
                object = object[n];
                object2 = (((byte[][])object).length >> 1) - n5;
                break;
            }
        }
        n = this.k1029 ? 1 : 0;
        if (n != 0) {
            n = this.h1047;
            switch (n) {
                case -2: 
                case 56: {
                    this.af = n = this.af + 1;
                    if (n > n5) {
                        this.af = 0;
                    }
                }
                default: {
                    break;
                }
                case -1: 
                case 50: {
                    this.af = n = this.af - n5;
                    if (n >= 0) break;
                    this.af = n5;
                }
            }
            n = this.af;
            switch (n) {
                case 0: {
                    object2 = this.h1047;
                    switch (object2) {
                        default: {
                            break;
                        }
                        case -4: 
                        case 54: {
                            this.aO = object2 = this.aO + 1;
                            n = 6;
                            if (object2 > n) {
                                this.aO = 0;
                            }
                            object = this.h1074;
                            n = this.X;
                            object = object[n];
                            n = this.aO;
                            this.aN = object2 = (Object)object[n];
                            break;
                        }
                        case -3: 
                        case 52: {
                            this.aO = object2 = this.aO - n5;
                            if (object2 < 0) {
                                this.aO = object2 = 6;
                            }
                            object = this.h1074;
                            n = this.X;
                            object = object[n];
                            n = this.aO;
                            this.aN = object2 = (Object)object[n];
                        }
                    }
                }
                default: {
                    return;
                }
                case 1: 
            }
            n = this.h1047;
            switch (n) {
                default: {
                    return;
                }
                case -4: 
                case 54: {
                    this.ag = n = this.ag + 1;
                    if (n <= object2) return;
                    this.ag = 0;
                    return;
                }
                case -3: 
                case 52: 
            }
            this.ag = n = this.ag - n5;
            if (n >= 0) return;
            this.ag = object2;
            return;
        }
        n = this.h1047;
        switch (n) {
            default: {
                return;
            }
            case -4: 
            case 54: {
                this.ag = n = this.ag + 1;
                if (n <= object2) return;
                this.ag = 0;
                return;
            }
            case -3: 
            case 52: 
        }
        this.ag = n = this.ag - n5;
        if (n >= 0) return;
        this.ag = object2;
    }

    private void u(int n) {
        this.bv = n;
        this.w1111 = true;
        this.bu = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void u(int n, int n2, int n3) {
        int n4 = 2;
        if (n3 < n4) {
            byte[][] byArray;
            n4 = 0;
            Object var5_5 = null;
            int n5 = 0;
            while (n5 < (n4 = (byArray = this.m1150[n3]).length)) {
                Image[] imageArray = this.a1013[29];
                int n6 = 17;
                Image image = imageArray[n6];
                n4 = this.m1150[n3][n5][4] + n;
                int n7 = this.bP;
                n7 = n4 - n7;
                n4 = this.m1150[n3][n5][5] + n2;
                int n8 = this.bQ;
                n8 = n4 - n8 + 13;
                byte by = this.m1150[n3][n5][0];
                byte by2 = this.m1150[n3][n5][1];
                byte by3 = this.m1150[n3][n5][2];
                byte by4 = this.m1150[n3][n5][3];
                byte[][] byArray2 = this.m1150[n3];
                n4 = byArray2.length;
                int n9 = 3;
                if (n5 > (n4 -= n9)) {
                    n9 = n4 = 1;
                } else {
                    n4 = 0;
                    Object var5_12 = null;
                    n9 = 0;
                }
                a a2 = this;
                this.a(image, n7, n8, by, by2, by3, by4, n9, 0);
                n5 = n4 = n5 + 1;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void v() {
        int n;
        int n2;
        Image image;
        Object object;
        int n3 = this.ai;
        this.b(n3, 13);
        Image image2 = this.a1013[3][3];
        Image image3 = null;
        int n4 = 1;
        String[] stringArray = this;
        this.a(image2, 0, 0, 13450878, n4 != 0);
        this.a1002.setColor(15455661);
        stringArray = this.a1002;
        int n5 = this.ai;
        int n6 = 320 - n5 - 10;
        int n7 = this.ai;
        stringArray.fillRect(0, n6, 240, n7);
        stringArray = this.a1002;
        n5 = 240;
        n7 = this.aj;
        stringArray.setClip(0, 13, n5, n7);
        int n8 = this.a1013[4][7].getWidth();
        int n9 = 240 - n8 >> 1;
        int n10 = this.aj;
        n8 = this.a1013[4][7].getHeight();
        int n11 = (n10 - n8 >> 1) + 13;
        stringArray = this.a1002;
        Image image4 = this.a1013[4][7];
        n6 = 0;
        Object object2 = null;
        stringArray.drawImage(image4, n9, n11, 0);
        boolean bl = false;
        stringArray = null;
        int n12 = 0;
        while (n12 < (object = 9)) {
            stringArray = this.a1013[4];
            n8 = 20;
            Image image5 = stringArray[n8];
            stringArray = (String[])this.b1030[n12];
            object2 = null;
            object = stringArray[0];
            n6 = n9 + object;
            object = this.b1030[n12][1];
            n5 = n11 + object;
            n7 = 0;
            image = null;
            n4 = 0;
            n2 = 9;
            n = 9;
            stringArray = this;
            super.a(image5, n6, n5, 0, 0, n2, n, 0, 0);
            n12 = object = n12 + 1;
        }
        long l = this.a1019;
        long l2 = 1L;
        int n13 = (int)(l &= l2);
        if (n13 == 0) {
            stringArray = this.a1013[4];
            n8 = 20;
            Image image6 = stringArray[n8];
            stringArray = (String[])this.b1030;
            n6 = this.aN;
            stringArray = stringArray[n6];
            object2 = null;
            Image image7 = stringArray[0];
            n6 = n9 + image7;
            stringArray = (String[])this.b1030;
            n5 = this.aN;
            Image image8 = stringArray[n5][1];
            n5 = n11 + image8;
            n7 = 9;
            n4 = 0;
            n2 = 9;
            n = 9;
            stringArray = this;
            super.a(image6, n6, n5, n7, 0, n2, n, 0, 0);
        }
        Image image9 = this.a1013[3][6];
        n5 = this.aj + 13;
        stringArray = this;
        super.a(image9, 0, n5, 12010381, true);
        this.a1002.setColor(0xFCFFCD);
        stringArray = this.a1002;
        n6 = this.aj + 10;
        stringArray.fillRect(200, n6, 40, 15);
        Image image10 = this.a1013[4][24];
        object2 = this.a1013[4][24];
        n6 = object2.getWidth() >> 1;
        n6 = 240 - n6;
        n5 = this.aj + 10;
        int n14 = this.af;
        image = this.a1013[4][24];
        n7 = (image.getWidth() >> 1) * n14;
        int n15 = this.a1013[4][24].getWidth();
        n2 = n15 >> 1;
        n = this.a1013[4][24].getHeight();
        stringArray = this;
        super.a(image10, n6, n5, n7, 0, n2, n, 0, 0);
        stringArray = this.a1013[3][24];
        n8 = 200;
        n6 = this.aj + 12;
        long l3 = this.a1019;
        long l4 = 1L;
        l3 &= l4;
        n4 = 1;
        n5 = (int)(l3 <<= n4);
        n6 += n5;
        n5 = this.af;
        n5 = n5 == 0 ? 4 : 6;
        super.a((Image)stringArray, n8, n6, n5);
        String[] stringArray2 = this.b1015;
        n6 = (this.aN << 1) + 83;
        n8 = stringArray2[n6].length();
        n6 = this.k;
        int n16 = 240 - (n8 *= n6) - 2 >> 1;
        n6 = this.ai;
        n = 320 - n6 - 13 - 2;
        String[] stringArray3 = this.b1015;
        n6 = (this.aN << 1) + 83;
        String string = stringArray3[n6];
        super.a(string, n16, n);
        n8 = this.k1029 ? 1 : 0;
        if (n8 != 0) {
            n8 = n16 - 4;
            n6 = this.a1013[3][24].getWidth();
            n8 -= n6;
            object2 = this.b1015;
            n5 = (this.aN << 1) + 83;
            object2 = object2[n5];
            n6 = ((String)object2).length();
            n5 = this.k;
            int n17 = n16 + (n6 *= n5) + 2 + 4;
            n6 = this.j + 1;
            image3 = this.a1013[3];
            n7 = 24;
            image3 = image3[n7];
            n5 = image3.getHeight();
            n6 = (n6 - n5 >> 1) + n;
            super.d(n8, n17, n6);
        }
        n6 = this.ah;
        int n18 = 320 - n6;
        n6 = this.a1013[3][6].getHeight();
        n6 = n18 + n6 + 10;
        n7 = this.ah;
        stringArray = this;
        super.c(0, n6, 240, n7, 0);
        n5 = this.ah;
        n6 = 320 - n5;
        n5 = this.a1013[3][6].getHeight();
        n6 = n6 + n5 + 6;
        super.e(2, 4, n6);
        this.a1002.setColor(5271185);
        stringArray = this.b1015;
        n8 = (this.aN << 1) + 83 + 1;
        String string2 = stringArray[n8];
        n7 = this.ah;
        int n19 = 320 - n7;
        n7 = this.a1013[3][6].getHeight();
        n7 = n19 + n7 + 8 + 12;
        n2 = this.ah - 32;
        stringArray = this;
        super.a(string2, 0, 8, n7, 224, n2);
        n6 = this.a1013[4][25].getWidth();
        n8 = 240 - n6 >> 1;
        super.c(8, n8, 0);
        int n20 = this.aN;
        n6 = this.a1013[4][21].getWidth() / 9;
        n8 = 240 - n6;
        n6 = this.a1013[4][23].getWidth() << 2;
        n8 = n8 - n6 - 10 >> 1;
        n6 = n + 20;
        super.f(n20, n8, n6);
    }

    private void v(int n) {
        int n2 = 1;
        int[] nArray = this.c1107[n];
        nArray[9] = 0;
        nArray[10] = n2;
        nArray[4] = n2;
        this.w(n);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void v(int var1_1, int var2_2, int var3_3) {
        block51: {
            block52: {
                var4_4 = this.b1066[var1_1];
                var5_5 /* !! */  = this.c1107;
                var6_6 = var5_5 /* !! */ [var3_3];
                var7_7 /* !! */  = var4_4[2];
                if (var7_7 /* !! */  <= 0) ** GOTO lbl33
                var7_7 /* !! */  = var6_6[2];
                block0 : switch (var7_7 /* !! */ ) lbl-1000:
                // 9 sources

                {
                    default: {
                        var7_7 /* !! */  = var6_6[17];
                        var8_8 = 1;
                        if (var7_7 /* !! */  != var8_8) break block51;
                        var7_7 /* !! */  = var2_2 + 10;
lbl13:
                        // 2 sources

                        while (true) {
                            var8_8 = var6_6[2];
                            var9_9 = var6_6[3];
                            if ((var8_8 = (int)this.l(var8_8, var9_9)) == 0) break block0;
                            var4_4[16] = var7_7 /* !! */ ;
                            var8_8 = 2;
                            var9_9 = var4_4[var8_8];
                            var4_4[var8_8] = var7_7 /* !! */  = var9_9 - var7_7 /* !! */ ;
lbl21:
                            // 3 sources

                            while (true) {
                                var7_7 /* !! */  = var4_4[10];
                                var8_8 = -1;
                                if (var7_7 /* !! */  == var8_8) {
                                    var7_7 /* !! */  = 10;
                                    var4_4[var7_7 /* !! */ ] = var8_8 = 4;
                                }
                                if ((var7_7 /* !! */  = this.aV) == (var8_8 = 4) && (var7_7 /* !! */  = var4_4[12]) == 0 && (var7_7 /* !! */  = var4_4[13]) == 0) {
                                    var4_4[11] = 0;
                                    var7_7 /* !! */  = 25;
                                    var8_8 = 0;
                                    var10_10 = null;
                                    var4_4[var7_7 /* !! */ ] = 0;
                                }
lbl33:
                                // 4 sources

                                return;
                            }
                            break;
                        }
                    }
                    case 4: {
                        var7_7 /* !! */  = this.X;
                        var8_8 = 2;
                        if (var7_7 /* !! */  != var8_8) ** GOTO lbl54
                        var7_7 /* !! */  = 0;
                        var5_5 /* !! */  = null;
                        block32: while (true) {
                            if ((var7_7 /* !! */  = (int)this.h(var7_7 /* !! */ )) == 0) ** GOTO lbl-1000
                            var7_7 /* !! */  = (int)a.g(var6_6[3]);
                            if (var7_7 /* !! */  == 0) ** GOTO lbl87
                            var7_7 /* !! */  = this.X;
                            switch (var7_7 /* !! */ ) lbl-1000:
                            // 3 sources

                            {
                                default: lbl-1000:
                                // 4 sources

                                {
                                    while (true) {
                                        var7_7 /* !! */  = 19;
                                        var8_8 = 0;
                                        var10_10 = null;
                                        var4_4[var7_7 /* !! */ ] = 0;
                                        ** GOTO lbl-1000
                                        break;
                                    }
                                }
lbl54:
                                // 1 sources

                                var5_5 /* !! */  = (int[][])this.A1151;
                                var8_8 = var6_6[3];
                                var7_7 /* !! */  = (int)var5_5 /* !! */ [var8_8];
                                continue block32;
                                case 1: {
                                    var7_7 /* !! */  = 0;
                                    var5_5 /* !! */  = null;
                                    var11_12 = 0;
                                    while (true) {
                                        if (var11_12 >= (var7_7 /* !! */  = this.aP)) ** GOTO lbl-1000
                                        var5_5 /* !! */  = (int[][])this.b1066[var11_12];
                                        var7_7 /* !! */  = (int)var5_5 /* !! */ [0];
                                        var10_10 = this.b1066[var11_12];
                                        var8_8 = var10_10[1];
                                        var9_9 = var4_4[0] - 24;
                                        var12_11 = var4_4[0] - 24;
                                        var13_14 = 48;
                                        var14_16 = 48;
                                        if ((var7_7 /* !! */  = (int)a.a(var7_7 /* !! */ , var8_8, var9_9, var12_11, var13_14, var14_16)) != 0) {
                                            var5_5 /* !! */  = (int[][])this.b1066[var11_12];
                                            var8_8 = 12;
                                            var9_9 = 48;
                                            var5_5 /* !! */ [var8_8] = (int[])var9_9;
                                        }
                                        var11_12 = var7_7 /* !! */  = var11_12 + 1;
                                    }
                                }
                                case 0: {
                                    var7_7 /* !! */  = 12;
                                    var4_4[var7_7 /* !! */ ] = var8_8 = 96;
                                    ** GOTO lbl-1000
                                }
                                case 2: 
                            }
                            break;
                        }
                        var7_7 /* !! */  = 12;
                        var4_4[var7_7 /* !! */ ] = var8_8 = 48;
                        ** GOTO lbl-1000
lbl87:
                        // 1 sources

                        var7_7 /* !! */  = 12;
                        var4_4[var7_7 /* !! */ ] = var8_8 = 48;
                        ** continue;
                    }
                    case 5: {
                        var7_7 /* !! */  = this.X;
                        var8_8 = 2;
                        if (var7_7 /* !! */  != var8_8) ** GOTO lbl110
                        var7_7 /* !! */  = 0;
                        var5_5 /* !! */  = null;
                        block36: while (true) {
                            if ((var7_7 /* !! */  = (int)this.h(var7_7 /* !! */ )) == 0) ** GOTO lbl-1000
                            var7_7 /* !! */  = (int)a.g(var6_6[3]);
                            if (var7_7 /* !! */  == 0) ** GOTO lbl141
                            var7_7 /* !! */  = this.X;
                            switch (var7_7 /* !! */ ) lbl-1000:
                            // 3 sources

                            {
                                default: lbl-1000:
                                // 4 sources

                                {
                                    while (true) {
                                        var4_4[11] = 0;
                                        var7_7 /* !! */  = 20;
                                        var8_8 = 0;
                                        var10_10 = null;
                                        var4_4[var7_7 /* !! */ ] = 0;
                                        ** GOTO lbl-1000
                                        break;
                                    }
                                }
lbl110:
                                // 1 sources

                                var7_7 /* !! */  = 3;
                                continue block36;
                                case 1: {
                                    var7_7 /* !! */  = 0;
                                    var5_5 /* !! */  = null;
                                    var11_13 = 0;
                                    while (true) {
                                        if (var11_13 >= (var7_7 /* !! */  = this.aP)) ** GOTO lbl-1000
                                        var5_5 /* !! */  = (int[][])this.b1066[var11_13];
                                        var7_7 /* !! */  = (int)var5_5 /* !! */ [0];
                                        var10_10 = this.b1066[var11_13];
                                        var8_8 = var10_10[1];
                                        var9_9 = var4_4[0] - 24;
                                        var12_11 = var4_4[0] - 24;
                                        var13_15 = 48;
                                        var14_17 = 48;
                                        if ((var7_7 /* !! */  = (int)a.a(var7_7 /* !! */ , var8_8, var9_9, var12_11, var13_15, var14_17)) != 0) {
                                            var5_5 /* !! */  = (int[][])this.b1066[var11_13];
                                            var8_8 = 13;
                                            var9_9 = 48;
                                            var5_5 /* !! */ [var8_8] = (int[])var9_9;
                                        }
                                        var11_13 = var7_7 /* !! */  = var11_13 + 1;
                                    }
                                }
                                case 0: {
                                    var7_7 /* !! */  = 13;
                                    var4_4[var7_7 /* !! */ ] = var8_8 = 96;
                                    ** GOTO lbl-1000
                                }
                                case 2: 
                            }
                            break;
                        }
                        var7_7 /* !! */  = 13;
                        var4_4[var7_7 /* !! */ ] = var8_8 = 48;
                        ** GOTO lbl-1000
lbl141:
                        // 1 sources

                        var7_7 /* !! */  = 13;
                        var4_4[var7_7 /* !! */ ] = var8_8 = 48;
                        ** continue;
                    }
                    case 1: {
                        var7_7 /* !! */  = var6_6[3];
                        var8_8 = var4_4[23];
                        var9_9 = 1;
                        if (var7_7 /* !! */  < (var8_8 -= var9_9)) ** GOTO lbl-1000
                        var4_4[23] = var8_8 = var6_6[3] + 1;
                        var7_7 /* !! */  = (int)a.g(var6_6[3]);
                        if (var7_7 /* !! */  == 0) ** GOTO lbl181
                        var7_7 /* !! */  = this.X;
                        switch (var7_7 /* !! */ ) lbl-1000:
                        // 3 sources

                        {
                            default: lbl-1000:
                            // 4 sources

                            {
                                while (true) {
                                    var7_7 /* !! */  = 21;
                                    var8_8 = 0;
                                    var10_10 = null;
                                    var4_4[var7_7 /* !! */ ] = 0;
                                    ** GOTO lbl-1000
                                    break;
                                }
                            }
                            case 0: {
                                var7_7 /* !! */  = var4_4[26];
                                var8_8 = 7;
                                if (var7_7 /* !! */  != var8_8) {
                                    var4_4[15] = 48;
                                    var7_7 /* !! */  = 22;
                                    var8_8 = 0;
                                    var10_10 = null;
                                    var4_4[var7_7 /* !! */ ] = 0;
                                }
                                var7_7 /* !! */  = 14;
                                var4_4[var7_7 /* !! */ ] = var8_8 = 48;
                                ** GOTO lbl-1000
                            }
                            case 2: {
                                var7_7 /* !! */  = 14;
                                var4_4[var7_7 /* !! */ ] = var8_8 = 96;
                                ** GOTO lbl-1000
                            }
                            case 1: 
                        }
                        var7_7 /* !! */  = 14;
                        var4_4[var7_7 /* !! */ ] = var8_8 = 48;
                        ** GOTO lbl-1000
lbl181:
                        // 1 sources

                        var7_7 /* !! */  = 14;
                        var4_4[var7_7 /* !! */ ] = var8_8 = 48;
                        ** continue;
                    }
                    case 3: {
                        var7_7 /* !! */  = (int)a.g(var6_6[3]);
                        if (var7_7 /* !! */  == 0) ** GOTO lbl205
                        var7_7 /* !! */  = this.X;
                        switch (var7_7 /* !! */ ) lbl-1000:
                        // 2 sources

                        {
                            default: lbl-1000:
                            // 3 sources

                            {
                                while (true) {
                                    var4_4[13] = 0;
                                    var7_7 /* !! */  = 18;
                                    var8_8 = 0;
                                    var10_10 = null;
                                    var4_4[var7_7 /* !! */ ] = 0;
                                    ** GOTO lbl-1000
                                    break;
                                }
                            }
                            case 2: {
                                var7_7 /* !! */  = 11;
                                var4_4[var7_7 /* !! */ ] = var8_8 = 96;
                                ** GOTO lbl-1000
                            }
                            case 0: 
                            case 1: 
                        }
                        var7_7 /* !! */  = 11;
                        var4_4[var7_7 /* !! */ ] = var8_8 = 48;
                        ** GOTO lbl-1000
lbl205:
                        // 1 sources

                        var7_7 /* !! */  = 11;
                        var4_4[var7_7 /* !! */ ] = var8_8 = 48;
                        ** continue;
                    }
                    case 7: {
                        var7_7 /* !! */  = (int)a.g(var6_6[3]);
                        if (var7_7 /* !! */  == 0) ** GOTO lbl-1000
                        var7_7 /* !! */  = this.X;
                        switch (var7_7 /* !! */ ) {
                            default: {
                                ** GOTO lbl-1000
                            }
                            case 0: 
                        }
                        var7_7 /* !! */  = var4_4[26];
                        var8_8 = 7;
                        if (var7_7 /* !! */  == var8_8) ** GOTO lbl-1000
                        var4_4[15] = 48;
                        var7_7 /* !! */  = 22;
                        var8_8 = 0;
                        var10_10 = null;
                        var4_4[var7_7 /* !! */ ] = 0;
                        ** GOTO lbl-1000
                    }
                }
                var8_8 = var4_4[3];
                if (var8_8 >= var7_7 /* !! */ ) break block52;
                var9_9 = var4_4[3];
                var4_4[16] = var9_9 = var7_7 /* !! */  - var9_9;
                var8_8 = 2;
                var9_9 = var4_4[var8_8];
                var12_11 = var4_4[3];
                var7_7 /* !! */  -= var12_11;
                var4_4[var8_8] = var7_7 /* !! */  = var9_9 - var7_7 /* !! */ ;
                ** GOTO lbl21
            }
            var4_4[16] = 1;
            var7_7 /* !! */  = 2;
            var8_8 = var4_4[var7_7 /* !! */ ];
            var9_9 = 1;
            var4_4[var7_7 /* !! */ ] = var8_8 -= var9_9;
            ** while (true)
        }
        var7_7 /* !! */  = var2_2;
        ** while (true)
    }

    private final void w() {
        int n = 1;
        int n2 = 320;
        int n3 = 240;
        int n4 = 2;
        this.c(n4);
        int n5 = this.a1013[n4][0].getWidth();
        int n6 = this.a1013[n4][0].getHeight();
        int n7 = this.a1013[n4][n].getWidth();
        int n8 = this.a1013[n4][n].getHeight();
        n5 = n3 - n5 >> 1;
        n6 = n2 - n6 >> 1;
        int n9 = n3 - n7 >> 1;
        int n10 = n2 - n8 >> 1;
        this.a1002.setClip(0, 0, n3, n2);
        this.a1002.setColor(0xFFFFFF);
        this.a1002.fillRect(0, 0, n3, n2);
        Graphics graphics = this.a1002;
        Image image = this.a1013[n4][0];
        graphics.drawImage(image, n5, n6, 0);
        Graphics graphics2 = this.a1002;
        n6 = n8 + 2;
        n8 = this.am;
        n6 = n6 * n8 / 100;
        graphics2.setClip(n9, n10, n7, n6);
        graphics2 = this.a1002;
        Image image2 = this.a1013[n4][n];
        graphics2.drawImage(image2, n9, n10, 0);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void w(int n) {
        int n2 = 9;
        int n3 = 5;
        int n4 = 2;
        int n5 = 1;
        int[] nArray = this.c1107[n];
        int[][] nArray2 = this.b1066;
        int n6 = nArray[8];
        int[] nArray3 = nArray2[n6];
        n6 = nArray[n4];
        switch (n6) {
            case 0: 
            case 4: {
                int n7;
                void var15_64;
                void var10_19;
                int n8;
                int n9;
                byte[] byArray;
                for (n6 = 0; n6 < n3; n6 = (int)((byte)(n6 + 1))) {
                    byArray = this.C1134[n];
                    byArray[n6] = n6;
                }
                n6 = nArray[0];
                byArray = this.o1098;
                int n10 = nArray[n4];
                int n11 = byArray[n10] << 3;
                n6 += n11;
                int n12 = nArray[n5];
                byte[] byArray2 = this.o1098;
                int n13 = nArray[n4];
                int n14 = byArray2[n13] << 3;
                int n15 = n12 + n14;
                int n16 = nArray3[0];
                int n17 = nArray3[n5];
                nArray[n2] = n9 = this.a(n6, n15, n16, n17);
                nArray[n3] = n8 = a.c(nArray[n2]);
                int n18 = nArray[n4];
                if (n18 == 0) {
                    boolean bl = false;
                    Object var12_45 = null;
                } else {
                    int n19 = n5;
                }
                byte[][] byArray3 = this.j1139[var10_19];
                int n20 = nArray[n3];
                byte[] byArray4 = byArray3[n20];
                byte by = byArray4[0];
                byte[][][] byArray5 = this.j1139;
                byte[][] byArray6 = byArray5[var10_19];
                int n21 = nArray[3];
                if (n21 > n3) {
                    int n22 = n3;
                } else {
                    int n23 = nArray[3];
                }
                void var15_65 = (var15_64 >> 1) + 4;
                byte[] byArray7 = byArray6[var15_65];
                int n24 = byArray7[0] + by;
                int n25 = 11;
                int n26 = nArray3[0];
                n6 += n24;
                nArray[n25] = n6 = (n26 - n6) / 5;
                n6 = 12;
                int n27 = nArray3[n5];
                int n28 = n15 + n24;
                nArray[n6] = n7 = (n27 - n28) / 5;
                return;
            }
            case 1: {
                int n29;
                int n30;
                int n31;
                int n32;
                int n33 = nArray3[0];
                int n34 = nArray[0];
                byte[] byArray = this.o1098;
                int n35 = nArray[n4];
                int n36 = byArray[n35] << 3;
                int n37 = n34 + n36;
                nArray[11] = n32 = n33 - n37 >> 2;
                int n38 = nArray3[n5];
                int n39 = nArray[n5];
                byte[] byArray8 = this.o1098;
                int n40 = nArray[n4];
                int n41 = byArray8[n40] << 3;
                int n42 = n39 + n41;
                nArray[12] = n31 = n38 - n42 >> 2;
                n6 = nArray[0];
                byte[] byArray9 = this.o1098;
                int n43 = nArray[n4];
                int n44 = byArray9[n43] << 3;
                n6 += n44;
                int n45 = nArray[n5];
                byte[] byArray10 = this.o1098;
                int n46 = nArray[n4];
                int n47 = byArray10[n46] << 3;
                int n48 = n45 + n47;
                int n49 = nArray3[0];
                int n50 = nArray3[n5];
                nArray[n2] = n30 = this.a(n6, n48, n49, n50);
                nArray[n3] = n29 = a.c(nArray[n2]);
                return;
            }
            case 2: {
                int n51 = 10;
                nArray[n51] = 0;
                return;
            }
            case 8: 
            case 9: {
                nArray[10] = 0;
                int n52 = 11;
                nArray[n52] = n6 = this.a() % 3;
                return;
            }
            case 3: 
            case 5: 
            case 7: {
                int n53;
                int n54;
                int n55 = nArray3[0];
                int n56 = 8;
                nArray[11] = n54 = n55 - n56;
                n6 = 12;
                int n57 = nArray3[n5];
                int n58 = 30;
                nArray[n6] = n53 = n57 - n58;
                int n59 = 10;
                nArray[n59] = 0;
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void w(int n, int n2, int n3) {
        int n4;
        int n5 = n2 << 4;
        int n6 = this.bA;
        n5 -= n6;
        n6 = this.bB;
        n5 += n6;
        n6 = n << 4;
        int n7 = this.bC;
        n6 -= n7;
        n7 = this.bD;
        n6 += n7;
        n7 = 256;
        int n8 = n5 >= n7 ? (n5 += -256) : n5;
        n5 = 304;
        int n9 = n6 >= n5 ? (n5 = n6 + -304) : n6;
        n5 = 0;
        Object var9_9 = null;
        if (n3 != 0) {
            Object var10_39 = null;
            n4 = 0;
            n6 = n9;
        } else {
            Object var10_34 = null;
            int n10 = 0;
            n6 = n8;
            while (n10 < (n7 = 16)) {
                n7 = n10 + n2;
                int n11 = this.bG;
                if (n7 < n11) {
                    int n12;
                    byte[] byArray = this.B1160;
                    n11 = this.bG * n + n2 + n10;
                    int n13 = byArray[n11] & 0xFF;
                    n7 = this.aN;
                    if (n7 != 0) {
                        byte[] byArray2 = this.F1164;
                        n7 = this.bG * n + n2 + n10;
                        n12 = n5 = byArray2[n7] & 0xFF;
                    } else {
                        n12 = n5;
                    }
                    n8 = n6 >= (n5 = 256) ? (n5 = n6 + -256) : n6;
                    Image[][] imageArray = this.a1013;
                    n6 = this.bL;
                    Image[] imageArray2 = imageArray[n6];
                    n6 = 0;
                    Image image = imageArray2[0];
                    n7 = 1;
                    n11 = 16;
                    int n14 = 16;
                    byte[] byArray3 = this.C1161;
                    int n15 = this.bG * n + n2 + n10;
                    n15 = byArray3[n15];
                    a a2 = this;
                    this.a(image, n7, n11, n14, n15, n8, n9, n13);
                    n5 = this.aN;
                    if (n5 != 0 && n12 != 0) {
                        Image[][] imageArray3 = this.a1013;
                        n6 = this.bM;
                        Image[] imageArray4 = imageArray3[n6];
                        n6 = 0;
                        Image image2 = imageArray4[0];
                        n7 = 1;
                        n11 = 16;
                        n14 = 16;
                        byte[] byArray4 = this.G1165;
                        n15 = this.bG * n + n2 + n10;
                        n15 = byArray4[n15];
                        a a3 = this;
                        n13 = n12;
                        this.a(image2, n7, n11, n14, n15, n8, n9, n12);
                    }
                    n5 = n12;
                    n6 = n8;
                }
                n7 = n10 + 1;
                n6 += 16;
                n10 = n7;
            }
            return;
        }
        while (n4 < (n7 = 19)) {
            n7 = n4 + n;
            int n16 = this.bH;
            if (n7 < n16) {
                int n17;
                byte[] byArray = this.B1160;
                n16 = n + n4;
                int n18 = this.bG;
                n16 = n16 * n18 + n2;
                int n19 = byArray[n16] & 0xFF;
                n7 = this.aN;
                if (n7 != 0) {
                    byte[] byArray5 = this.F1164;
                    n7 = n + n4;
                    n16 = this.bG;
                    n7 = n7 * n16 + n2;
                    n17 = n5 = byArray5[n7] & 0xFF;
                } else {
                    n17 = n5;
                }
                n9 = n6 >= (n5 = 304) ? (n5 = n6 + -304) : n6;
                Image[][] imageArray = this.a1013;
                n6 = this.bL;
                Image[] imageArray5 = imageArray[n6];
                n6 = 0;
                Image image = imageArray5[0];
                n7 = 1;
                n16 = 16;
                n18 = 16;
                byte[] byArray6 = this.C1161;
                int n20 = n + n4;
                int n21 = this.bG;
                n20 = n20 * n21 + n2;
                n20 = byArray6[n20];
                a a4 = this;
                this.a(image, n7, n16, n18, n20, n8, n9, n19);
                n5 = this.aN;
                if (n5 != 0 && n17 != 0) {
                    Image[][] imageArray6 = this.a1013;
                    n6 = this.bM;
                    Image[] imageArray7 = imageArray6[n6];
                    n6 = 0;
                    Image image3 = imageArray7[0];
                    n7 = 1;
                    n16 = 16;
                    n18 = 16;
                    byte[] byArray7 = this.G1165;
                    n20 = n + n4;
                    n19 = this.bG;
                    n20 = n20 * n19 + n2;
                    n20 = byArray7[n20];
                    a a5 = this;
                    n19 = n17;
                    this.a(image3, n7, n16, n18, n20, n8, n9, n17);
                }
                n5 = n17;
                n6 = n9;
            }
            n7 = n4 + 1;
            n6 += 16;
            n4 = n7;
        }
    }

    private void x() {
        int n = 320;
        int n2 = 2;
        int n3 = 1;
        this.c(n3);
        int n4 = this.b1034[0];
        int n5 = this.b1034[n3];
        n4 += n5;
        n5 = this.b1034[n2];
        int n6 = Math.abs(n - (n4 += n5) >> 2);
        this.an = n5 = Math.min(15, n6);
        n4 = n - n4;
        n5 = this.an << 1;
        n4 = n4 - n5 >> 1;
        int[] nArray = this.g1035;
        nArray[0] = n6 = (this.b1034[0] >> 1) + n4;
        nArray = this.g1035;
        n6 = this.b1034[0];
        n4 += n6;
        n6 = this.an;
        nArray[n3] = n4 += n6;
        int[] nArray2 = this.g1035;
        n5 = this.g1035[n3];
        n6 = this.b1034[n3];
        n5 += n6;
        n6 = this.an;
        nArray2[n2] = n5 += n6;
        n5 = this.a1013[n3][7].getWidth();
        this.ao = n4 = 240 - n5 >> 1;
    }

    private void x(int n) {
        int[] nArray = this.c1107[n];
        nArray[4] = 2;
        nArray[10] = 3;
        nArray[9] = 0;
        nArray[13] = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void y() {
        int n = 320;
        int n2 = 3;
        int n3 = 6;
        int n4 = 2;
        this.a1002.setColor(0xFFFFFF);
        Graphics graphics = this.a1002;
        int n5 = 240;
        graphics.fillRect(0, 0, n5, n);
        int n6 = 0;
        graphics = null;
        while (n6 < (n5 = (int)this.a1038)) {
            int n7;
            int n8;
            int[] nArray = this.a1039[n6];
            int n9 = nArray[0];
            int n10 = nArray[1];
            int n11 = nArray[n4];
            if (n11 == n2 || (n11 = nArray[n4]) == (n8 = 4)) {
                byte[] byArray = this.c1037;
                n8 = nArray[n3] << 1;
                n11 = byArray[n8];
                Graphics graphics2 = this.a1002;
                byte[] byArray2 = this.c1037;
                n7 = nArray[n3] << 1;
                n8 = byArray2[n7] + (n9 -= n11);
                byte[] byArray3 = this.c1037;
                int n12 = (nArray[n3] << 1) + 1;
                n7 = byArray3[n12];
                graphics2.setClip(n8, n10, n7, n);
                Graphics graphics3 = this.a1002;
                Image[] imageArray = this.a1013[1];
                n7 = 7;
                Image image = imageArray[n7];
                graphics3.drawImage(image, n9, n10, 0);
            } else {
                n11 = nArray[n4];
                if (n11 == n4) {
                    n11 = nArray[n2];
                    n8 = nArray[4];
                    n11 -= n8;
                    n8 = nArray[5];
                    n7 = 1;
                    if (n8 == n7) {
                        n8 = nArray[n2];
                        n11 = n8 - n11 - n4;
                    }
                    n8 = nArray[n3] * n11;
                    Graphics graphics4 = this.a1002;
                    n7 = nArray[n3];
                    n11 = n11 * n7 + (n9 -= n8);
                    n7 = nArray[n3];
                    graphics4.setClip(n11, n10, n7, n);
                }
            }
            if ((n11 = nArray[n4]) != n2 && (n5 = nArray[n4]) != (n11 = 4)) {
                Graphics graphics5 = this.a1002;
                Image image = this.a1040[n6];
                graphics5.drawImage(image, n9, n10, 0);
            }
            Graphics graphics6 = this.a1002;
            n9 = 240;
            graphics6.setClip(0, 0, n9, n);
            ++n6;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void y(int object) {
        byte[] byArray;
        byte[] byArray2;
        int[][] nArray;
        a a2 = this;
        int[][] nArray2 = nArray = this.c1107;
        int[] nArray3 = nArray[object];
        Object var3_101 = null;
        int n = nArray3[0];
        a a3 = this;
        Object object2 = byArray2 = this.o1098;
        int n2 = nArray3[2];
        int n3 = byArray2[n2] << 3;
        int n4 = n + n3;
        n = nArray3[1];
        a a4 = this;
        object2 = byArray = this.o1098;
        n2 = nArray3[2];
        int n5 = byArray[n2] << 3;
        int n6 = n + n5;
        n = nArray3[2];
        switch (n) {
            case 0: {
                byte[][] byArray3;
                byte[][] byArray4;
                byte[][] byArray5;
                byte[][] byArray6;
                Image[][] imageArray;
                Image[][] imageArray2;
                n = nArray3[13];
                int n7 = 3;
                if (n >= n7) return;
                a a5 = this;
                Image[][] imageArray3 = imageArray2 = this.a1013;
                Image[] imageArray4 = imageArray2[29];
                int n8 = 2;
                object2 = imageArray4[n8];
                a a6 = this;
                Image[][] imageArray5 = imageArray = this.a1013;
                Image[] imageArray6 = imageArray[29];
                n2 = 1;
                Image image = imageArray6[n2];
                a a7 = this;
                byte[][] byArray7 = byArray6 = this.D1135;
                int n9 = nArray3[13];
                byte by = byArray6[n9][2];
                a a8 = this;
                byte[][] byArray8 = byArray5 = this.D1135;
                int n10 = nArray3[13];
                byte by2 = byArray5[n10][3];
                a a9 = this;
                byte[][] byArray9 = byArray4 = this.D1135;
                int n11 = nArray3[13];
                byte[] byArray10 = byArray4[n11];
                Object var15_272 = null;
                byte by3 = byArray10[0];
                a a10 = this;
                byte[][] byArray11 = byArray3 = this.D1135;
                int n12 = nArray3[13];
                byte by4 = byArray3[n12][1];
                a a11 = this;
                Object object3 = object;
                this.a((Image)object2, image, (int)object, (int)by, (int)by2, (int)by3, (int)by4);
                return;
            }
            case 4: {
                byte[][] byArray12;
                byte[][] byArray13;
                byte[][] byArray14;
                byte[][] byArray15;
                Image[][] imageArray;
                Image[][] imageArray7;
                n = nArray3[13];
                int n13 = 3;
                if (n >= n13) return;
                a a12 = this;
                Image[][] imageArray8 = imageArray7 = this.a1013;
                Image[] imageArray9 = imageArray7[29];
                int n14 = 4;
                object2 = imageArray9[n14];
                a a13 = this;
                Image[][] imageArray10 = imageArray = this.a1013;
                Image[] imageArray11 = imageArray[29];
                n2 = 3;
                Image image = imageArray11[n2];
                a a14 = this;
                byte[][] byArray16 = byArray15 = this.D1135;
                int n15 = nArray3[13];
                byte by = byArray15[n15][2];
                a a15 = this;
                byte[][] byArray17 = byArray14 = this.D1135;
                int n16 = nArray3[13];
                byte by5 = byArray14[n16][3];
                a a16 = this;
                byte[][] byArray18 = byArray13 = this.D1135;
                int n17 = nArray3[13];
                byte[] byArray19 = byArray13[n17];
                Object var15_273 = null;
                byte by6 = byArray19[0];
                a a17 = this;
                byte[][] byArray20 = byArray12 = this.D1135;
                int n18 = nArray3[13];
                byte by7 = byArray12[n18][1];
                a a18 = this;
                Object object4 = object;
                this.a((Image)object2, image, (int)object, (int)by, (int)by5, (int)by6, (int)by7);
                return;
            }
            case 1: {
                byte[][][] byArray21;
                byte[][][] byArray22;
                a a19 = this;
                byte[][][] byArray23 = byArray22 = this.j1139;
                byte[][] byArray24 = byArray22[2];
                int n19 = nArray3[5];
                byte[] byArray25 = byArray24[n19];
                boolean bl = false;
                n = byArray25[0];
                a a20 = this;
                byte[][][] byArray26 = this.j1139;
                object2 = byArray26;
                object2 = byArray26[2];
                n2 = nArray3[3];
                int n20 = 5;
                n2 = n2 > n20 ? 5 : nArray3[3];
                n2 = (n2 >> 1) + 4;
                object2 = object2[n2];
                Object var11_210 = null;
                byte by = object2[0];
                int n21 = n + by;
                a a21 = this;
                byte[][][] byArray27 = byArray21 = this.j1139;
                byte[][] byArray28 = byArray21[2];
                int n22 = nArray3[5];
                byte[] byArray29 = byArray28[n22];
                int n23 = 1;
                n = byArray29[n23];
                a a22 = this;
                byte[][][] byArray30 = this.j1139;
                object2 = byArray30;
                object2 = byArray30[2];
                n2 = nArray3[3];
                int n24 = 5;
                n2 = n2 > n24 ? 5 : nArray3[3];
                n2 = (n2 >> 1) + 4;
                object2 = object2[n2];
                n2 = 1;
                byte by8 = object2[n2];
                int n25 = n + by8 + 13;
                n = nArray3[13];
                int n26 = 4;
                if (n >= n26) {
                    Image[][] imageArray;
                    a a23 = this;
                    Image[][] imageArray12 = imageArray = this.a1013;
                    Image[] imageArray13 = imageArray[29];
                    int n27 = 8;
                    object2 = imageArray13[n27];
                    n = nArray3[11] * 4;
                    int n28 = n4 + n;
                    n = nArray3[12] * 4;
                    int n29 = n6 + n;
                    n = nArray3[13];
                    int n30 = n - 4;
                    a a24 = this;
                    n2 = object;
                    this.b((Image)object2, (int)object, n28, n29, n30);
                    return;
                }
                n = nArray3[13];
                int n31 = 3;
                if (n < n31) {
                    byte[][] byArray31;
                    byte[][] byArray32;
                    byte[][] byArray33;
                    byte[][] byArray34;
                    Image[][] imageArray;
                    a a25 = this;
                    Image[][] imageArray14 = imageArray = this.a1013;
                    Image[] imageArray15 = imageArray[29];
                    int n32 = 5;
                    object2 = imageArray15[n32];
                    n2 = 0;
                    Object var11_211 = null;
                    a a26 = this;
                    byte[][] byArray35 = byArray34 = this.D1135;
                    int n33 = nArray3[13];
                    byte by9 = byArray34[n33][2];
                    a a27 = this;
                    byte[][] byArray36 = byArray33 = this.D1135;
                    int n34 = nArray3[13];
                    byte by10 = byArray33[n34][3];
                    a a28 = this;
                    byte[][] byArray37 = byArray32 = this.D1135;
                    int n35 = nArray3[13];
                    byte[] byArray38 = byArray32[n35];
                    Object var15_274 = null;
                    byte by11 = byArray38[0];
                    a a29 = this;
                    byte[][] byArray39 = byArray31 = this.D1135;
                    int n36 = nArray3[13];
                    byte by12 = byArray31[n36][1];
                    a a30 = this;
                    Object object5 = object;
                    this.a((Image)object2, null, (int)object, (int)by9, (int)by10, (int)by11, (int)by12);
                }
                n = 0;
                Object var3_137 = null;
                boolean bl2 = false;
                while (true) {
                    boolean bl3;
                    int n37;
                    int n38;
                    boolean bl4;
                    int n39;
                    int n40;
                    int n41;
                    int n42;
                    n = nArray3[13] + 1;
                    int n43 = n42;
                    if (n42 >= n) return;
                    if (n42 > 0) {
                        Image[][] imageArray;
                        a a31 = this;
                        Image[][] imageArray16 = imageArray = this.a1013;
                        Image[] imageArray17 = imageArray[29];
                        n41 = 7;
                        object2 = imageArray17[n41];
                        n = n4 + n21;
                        n2 = nArray3[11] * n42;
                        n += n2;
                        a a32 = this;
                        n2 = n43 = this.bP;
                        n2 = n - n43;
                        n = n6 + n25;
                        n40 = nArray3[12] * n42;
                        n += n40;
                        int n40 = n43 = this.bQ;
                        n40 = n - n43;
                        n39 = n42 * 10;
                        bl4 = false;
                        n38 = 10;
                        n37 = 10;
                        bl3 = false;
                        a a33 = this;
                        this.a((Image)object2, n2, n40, n39, 0, n38, n37, 0, 0);
                    }
                    n = nArray3[13];
                    n43 = n42;
                    if (n42 == n) {
                        Image[][] imageArray;
                        a a34 = this;
                        Image[][] imageArray18 = imageArray = this.a1013;
                        Image[] imageArray19 = imageArray[29];
                        n41 = 6;
                        object2 = imageArray19[n41];
                        n = n4 + n21;
                        n2 = nArray3[11] * n42;
                        n += n2;
                        a a35 = this;
                        n2 = n43 = this.bP;
                        n2 = n - n43;
                        n = n6 + n25;
                        n40 = nArray3[12] * n42;
                        n += n40;
                        int n40 = n43 = this.bQ;
                        n40 = n - n43;
                        n39 = n42 * 12;
                        bl4 = false;
                        n38 = 12;
                        n37 = 12;
                        bl3 = false;
                        a a36 = this;
                        this.a((Image)object2, n2, n40, n39, 0, n38, n37, 0, 0);
                    }
                    n42 = n = n42 + true;
                }
            }
            case 6: {
                Object var3_148 = null;
                n = nArray3[0];
                int n44 = nArray3[1];
                n2 = nArray3[5];
                int n45 = nArray3[13];
                a a37 = this;
                this.f(n, n44, n2, n45);
                return;
            }
            case 3: 
            case 5: {
                int n46 = nArray3[0];
                n2 = nArray3[1];
                int n47 = nArray3[11];
                int n48 = nArray3[12];
                int n49 = nArray3[3];
                int n50 = nArray3[13];
                int n51 = nArray3[10];
                n = 2;
                int n52 = nArray3[n];
                a a38 = this;
                this.a(n46, n2, n47, n48, n49, n50, n51, n52);
                return;
            }
            case 7: {
                int n53 = nArray3[0];
                n2 = nArray3[1];
                int n54 = nArray3[11];
                int n55 = nArray3[12];
                int n56 = nArray3[8];
                int n57 = nArray3[13];
                int n58 = nArray3[3];
                n = 10;
                int n59 = nArray3[n];
                a a39 = this;
                this.b(n53, n2, n54, n55, n56, n57, n58, n59);
                return;
            }
            case 9: {
                n = nArray3[10];
                if (n == 0) {
                    Image[][] imageArray;
                    Image[][] imageArray20;
                    Image[][] imageArray21;
                    a a40 = this;
                    Image[][] imageArray22 = imageArray21 = this.a1013;
                    Image[] imageArray23 = imageArray21[29];
                    int n60 = 36;
                    object2 = imageArray23[n60];
                    a a41 = this;
                    Image[][] imageArray24 = imageArray20 = this.a1013;
                    Image[] imageArray25 = imageArray20[29];
                    n2 = 37;
                    Image image = imageArray25[n2];
                    a a42 = this;
                    Image[][] imageArray26 = imageArray = this.a1013;
                    Image[] imageArray27 = imageArray[29];
                    int n61 = 38;
                    Image image2 = imageArray27[n61];
                    int n62 = nArray3[0];
                    int n63 = nArray3[1];
                    int n64 = nArray3[5];
                    n = 13;
                    int n65 = nArray3[n];
                    a a43 = this;
                    this.a((Image)object2, image, image2, n62, n63, n64, n65);
                    return;
                }
                n = nArray3[16];
                int n66 = 1;
                if (n != n66) return;
                int n67 = nArray3[0];
                n2 = nArray3[1];
                int n68 = nArray3[5];
                int n69 = nArray3[2];
                n = 3;
                int n70 = nArray3[n];
                a a44 = this;
                this.h(n67, n2, n68, n69, n70);
                return;
            }
            case 8: {
                Image[][] imageArray;
                Image[][] imageArray28;
                Image[][] imageArray29;
                n = nArray3[10];
                if (n != 0) return;
                a a45 = this;
                Image[][] imageArray30 = imageArray29 = this.a1013;
                Image[] imageArray31 = imageArray29[29];
                int n71 = 32;
                object2 = imageArray31[n71];
                a a46 = this;
                Image[][] imageArray32 = imageArray28 = this.a1013;
                Image[] imageArray33 = imageArray28[29];
                n2 = 33;
                Image image = imageArray33[n2];
                a a47 = this;
                Image[][] imageArray34 = imageArray = this.a1013;
                Image[] imageArray35 = imageArray[29];
                int n72 = 34;
                Image image3 = imageArray35[n72];
                int n73 = nArray3[0];
                int n74 = nArray3[1];
                int n75 = nArray3[5];
                n = 13;
                int n76 = nArray3[n];
                a a48 = this;
                this.a((Image)object2, image, image3, n73, n74, n75, n76);
                return;
            }
            case 2: {
                n = nArray3[5];
                object2 = null;
                int n77 = nArray3[0];
                n2 = nArray3[1];
                int n78 = nArray3[13];
                a a49 = this;
                this.g(n, n77, n2, n78);
                return;
            }
            case 10: {
                n = nArray3[10];
                int n79 = 2;
                if (n != n79) return;
                n = 0;
                Object var3_166 = null;
                boolean bl = false;
                while (true) {
                    byte[][] byArray40;
                    byte[][] byArray41;
                    int n80;
                    byte[][] byArray42;
                    a a50 = this;
                    byte[][] byArray43 = byArray42 = this.E1136;
                    n = byArray42.length;
                    int n81 = n80;
                    if (n80 >= n) break;
                    a a51 = this;
                    byte[][] byArray44 = byArray41 = this.F1137;
                    int n82 = nArray3[5];
                    n = byArray41[n82][0];
                    n82 = nArray3[0];
                    n += n82;
                    a a52 = this;
                    byte[][] byArray45 = this.E1136;
                    object2 = byArray45;
                    n82 = byArray45[n80][0];
                    n += n82;
                    a a53 = this;
                    byte[][] byArray46 = this.F1137;
                    object2 = byArray46;
                    n2 = nArray3[5];
                    n82 = byArray46[n2][1];
                    n2 = nArray3[1];
                    n82 += n2;
                    a a54 = this;
                    byte[][] byArray47 = byArray40 = this.E1136;
                    byte[] byArray48 = byArray40[n80];
                    n2 = byArray48[1];
                    int n83 = n82 + n2;
                    a a55 = this;
                    Image[][] imageArray = this.a1013;
                    object2 = imageArray;
                    object2 = imageArray[29][47];
                    a a56 = this;
                    n2 = n81 = this.bP;
                    n2 = n - n81;
                    n = n81 = this.bQ;
                    n83 = n83 - n81 + 13;
                    int n84 = nArray3[13] * 14;
                    boolean bl5 = false;
                    int n85 = 14;
                    int n86 = 19;
                    boolean bl6 = false;
                    a a57 = this;
                    this.a((Image)object2, n2, n83, n84, 0, n85, n86, 0, 0);
                    n80 = n = n80 + true;
                }
                n = 0;
                Object var3_171 = null;
                while (true) {
                    byte[][] byArray49;
                    byte[][] byArray50;
                    byte[][] byArray51;
                    a a58 = this;
                    byte[][] byArray52 = this.G1138;
                    object2 = byArray52;
                    int n87 = byArray52.length;
                    if (n >= n87) return;
                    a a59 = this;
                    byte[][] byArray53 = this.F1137;
                    object2 = byArray53;
                    n2 = nArray3[5];
                    object2 = byArray53[n2];
                    n87 = object2[0];
                    n2 = nArray3[0];
                    n87 += n2;
                    a a60 = this;
                    byte[][] byArray54 = byArray51 = this.G1138;
                    n2 = byArray51[n][0];
                    n87 += n2;
                    a a61 = this;
                    byte[][] byArray55 = byArray50 = this.F1137;
                    int n88 = nArray3[5];
                    byte[] byArray56 = byArray50[n88];
                    n2 = byArray56[1];
                    n88 = nArray3[1];
                    n2 += n88;
                    a a62 = this;
                    byte[][] byArray57 = byArray49 = this.G1138;
                    byte[] byArray58 = byArray49[n];
                    int n89 = 1;
                    n88 = byArray58[n89];
                    n2 += n88;
                    n88 = nArray3[13];
                    a a63 = this;
                    this.p(n87, n2, n88);
                    ++n;
                }
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void z() {
        var1_1 = 5;
        var2_2 = 3;
        var3_3 = 1;
        var4_4 = 4;
        block17: for (var5_5 = this.a1038 - var3_3; var5_5 >= 0; var5_5 += -1) {
            var6_6 = this.a1039[var5_5];
            var7_7 = var6_6[2];
            switch (var7_7) lbl-1000:
            // 9 sources

            {
                default: lbl-1000:
                // 4 sources

                {
                    continue block17;
                }
                case 1: {
                    var7_7 = var6_6[var2_2];
                    if (var7_7 <= 0) ** GOTO lbl-1000
                    var7_7 = var6_6[0];
                    var8_8 = var6_6[var4_4];
                    var9_9 = var6_6[0];
                    var8_8 -= var9_9;
                    var9_9 = var6_6[var2_2];
                    var6_6[0] = var7_7 += (var8_8 /= var9_9);
                    var7_7 = var6_6[var3_3];
                    var8_8 = var6_6[var1_1];
                    var9_9 = var6_6[var3_3];
                    var8_8 -= var9_9;
                    var9_9 = var6_6[var2_2];
                    var6_6[var3_3] = var7_7 += (var8_8 /= var9_9);
                    var6_6[var2_2] = var7_7 = var6_6[var2_2] - var3_3;
                    ** GOTO lbl-1000
                }
                case 3: {
                    var7_7 = var6_6[var2_2];
                    if (var7_7 <= 0) ** GOTO lbl65
                    var7_7 = var6_6[var4_4];
                    var8_8 = var6_6[0];
                    var7_7 -= var8_8;
                    var8_8 = var6_6[var2_2];
                    var7_7 /= var8_8;
                    var8_8 = var6_6[var1_1];
                    var9_9 = var6_6[var3_3];
                    var8_8 -= var9_9;
                    var9_9 = var6_6[var2_2];
                    var8_8 /= var9_9;
                    var6_6[0] = var9_9 = var6_6[0] + var7_7;
                    var6_6[var3_3] = var9_9 = var6_6[var3_3] + var8_8;
                    var6_6[var2_2] = var9_9 = var6_6[var2_2] - var3_3;
                    if (var9_9 != 0) ** GOTO lbl-1000
                    if (var7_7 <= 0) ** GOTO lbl55
                    var7_7 = 8;
lbl48:
                    // 3 sources

                    while (true) {
                        var6_6[var4_4] = var7_7;
                        if (var8_8 <= 0) ** GOTO lbl60
                        var7_7 = 8;
lbl52:
                        // 3 sources

                        while (true) {
                            var6_6[var1_1] = var7_7;
                            ** GOTO lbl-1000
                            break;
                        }
                        break;
                    }
lbl55:
                    // 1 sources

                    if (var7_7 >= 0) ** GOTO lbl58
                    var7_7 = -8;
                    ** GOTO lbl48
lbl58:
                    // 1 sources

                    var7_7 = 0;
                    ** continue;
lbl60:
                    // 1 sources

                    if (var8_8 >= 0) ** GOTO lbl63
                    var7_7 = -8;
                    ** GOTO lbl52
lbl63:
                    // 1 sources

                    var7_7 = 0;
                    ** continue;
lbl65:
                    // 1 sources

                    var7_7 = var6_6[var4_4];
                    if (var7_7 != 0) ** GOTO lbl-1000
                    var7_7 = var6_6[var2_2];
                    switch (var7_7) lbl-1000:
                    // 2 sources

                    {
                        default: lbl-1000:
                        // 2 sources

                        {
                            while (true) {
                                var6_6[var2_2] = var7_7 = var6_6[var2_2] - var3_3;
                                ** GOTO lbl-1000
                                break;
                            }
                        }
                        case -3: 
                        case 0: {
                            var7_7 = var6_6[0];
                            var8_8 = var6_6[var4_4];
                            var6_6[0] = var7_7 += var8_8;
                            var7_7 = var6_6[var3_3];
                            var8_8 = var6_6[var1_1];
                            var6_6[var3_3] = var7_7 += var8_8;
                            ** GOTO lbl-1000
                        }
                        case -2: {
                            var6_6[var4_4] = var7_7 = var6_6[var4_4] >> 1;
                            var6_6[var1_1] = var7_7 = var6_6[var1_1] >> 1;
                        }
                        case -1: 
                    }
                    var7_7 = var6_6[0];
                    var8_8 = var6_6[var4_4];
                    var6_6[0] = var7_7 -= var8_8;
                    var7_7 = var6_6[var3_3];
                    var8_8 = var6_6[var1_1];
                    var6_6[var3_3] = var7_7 -= var8_8;
                    ** continue;
                }
                case 2: {
                    var7_7 = var6_6[var4_4];
                    if (var7_7 <= var3_3) ** GOTO lbl-1000
                    var6_6[var4_4] = var7_7 = var6_6[var4_4] - var3_3;
                    ** GOTO lbl-1000
                }
                case 4: 
            }
            var7_7 = var6_6[var2_2];
            if (var7_7 <= 0) ** GOTO lbl-1000
            var7_7 = var6_6[var1_1];
            switch (var7_7) lbl-1000:
            // 4 sources

            {
                default: lbl-1000:
                // 2 sources

                {
                    while (true) {
                        var6_6[var1_1] = var7_7 = var6_6[var1_1] + 1;
                        if (var7_7 < var4_4) ** GOTO lbl-1000
                        var6_6[var1_1] = 0;
                        var6_6[var2_2] = var7_7 = var6_6[var2_2] - var3_3;
                        ** continue;
                        break;
                    }
                }
                case 0: {
                    var7_7 = var6_6[0];
                    var8_8 = var6_6[var4_4];
                    var6_6[0] = var7_7 -= var8_8;
                    var7_7 = var6_6[var3_3];
                    var8_8 = var6_6[var4_4];
                    var6_6[var3_3] = var7_7 += var8_8;
                    ** GOTO lbl-1000
                }
                case 1: {
                    var7_7 = var6_6[0];
                    var8_8 = var6_6[var4_4];
                    var6_6[0] = var7_7 -= var8_8;
                    var7_7 = var6_6[var3_3];
                    var8_8 = var6_6[var4_4];
                    var6_6[var3_3] = var7_7 -= var8_8;
                    ** GOTO lbl-1000
                }
                case 2: {
                    var7_7 = var6_6[0];
                    var8_8 = var6_6[var4_4];
                    var6_6[0] = var7_7 += var8_8;
                    var7_7 = var6_6[var3_3];
                    var8_8 = var6_6[var4_4];
                    var6_6[var3_3] = var7_7 -= var8_8;
                    ** GOTO lbl-1000
                }
                case 3: 
            }
            var7_7 = var6_6[0];
            var8_8 = var6_6[var4_4];
            var6_6[0] = var7_7 += var8_8;
            var7_7 = var6_6[var3_3];
            var8_8 = var6_6[var4_4];
            var6_6[var3_3] = var7_7 += var8_8;
            ** continue;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void z(int n) {
        int n2;
        int n3;
        int n4 = 10;
        int n5 = 13;
        int n6 = 4;
        int n7 = 1;
        int[] nArray = this.b1066[n];
        int n8 = nArray[12];
        if (n8 > 0) {
            n8 = 19;
            nArray[n8] = n3 = nArray[n8] + 1;
            n8 = 2;
            if (n3 > n8) {
                n8 = 19;
                nArray[n8] = 0;
            }
            if ((n8 = nArray[8]) != (n3 = 7)) {
                n8 = 8;
                nArray[n8] = n3 = 7;
            }
            n8 = 12;
            nArray[n8] = n3 = nArray[n8] - n7;
        }
        if ((n8 = nArray[15]) > 0) {
            n8 = 22;
            nArray[n8] = n3 = nArray[n8] + 1;
            n8 = 2;
            if (n3 > n8) {
                n8 = 22;
                nArray[n8] = 0;
            }
            if ((n8 = nArray[n6]) > n7 && (n8 = nArray[0] & 7) == 0 && (n8 = nArray[n7] & 7) == 0) {
                nArray[n6] = n8 = this.aZ >> 1;
            }
            n8 = 15;
            nArray[n8] = n3 = nArray[n8] - n7;
        } else {
            n8 = nArray[15];
            if (n8 == 0 && (n8 = nArray[n5]) == 0 && (n8 = nArray[0] & 7) == 0 && (n8 = nArray[n7] & 7) == 0) {
                nArray[n6] = n8 = this.aZ;
            }
        }
        if ((n8 = nArray[14]) > 0) {
            n8 = 21;
            nArray[n8] = n3 = nArray[n8] + 1;
            n8 = 2;
            if (n3 > n8) {
                n8 = 21;
                nArray[n8] = 0;
            }
            if ((n8 = nArray[14] & 7) == 0) {
                n8 = 2;
                n3 = nArray[n8];
                n2 = nArray[23];
                nArray[n8] = n3 -= n2;
                nArray[16] = n3 = nArray[23];
                n8 = nArray[n4];
                n3 = -1;
                if (n8 == n3) {
                    nArray[n4] = n6;
                }
            }
            n8 = 14;
            nArray[n8] = n3 = nArray[n8] - n7;
        } else {
            n8 = nArray[14];
            if (n8 == 0) {
                n8 = 23;
                nArray[n8] = 0;
            }
        }
        if ((n8 = nArray[11]) > 0) {
            n8 = nArray[11] & 7;
            if (n8 == 0) {
                boolean[] blArray;
                n8 = 8;
                n3 = this.X;
                if (n3 == 0 && (n3 = (blArray = this.f1106)[n2 = 3]) != 0) {
                    n8 = 16;
                }
                n3 = 2;
                nArray[n3] = n2 = nArray[n3] - n8;
                nArray[16] = n8;
                n8 = nArray[n4];
                n3 = -1;
                if (n8 == n3) {
                    nArray[n4] = n6;
                }
            }
            n8 = 18;
            nArray[n8] = n3 = nArray[n8] + 1;
            n8 = 5;
            if (n3 > n8) {
                n8 = 18;
                nArray[n8] = 0;
            }
            n8 = 11;
            nArray[n8] = n3 = nArray[n8] - n7;
        }
        if ((n8 = nArray[n5]) > 0) {
            n8 = nArray[n5];
            n3 = 44;
            if (n8 >= n3) {
                n8 = nArray[20];
                n3 = 3;
                if (n8 < n3) {
                    n8 = 20;
                    nArray[n8] = n3 = nArray[n8] + 1;
                }
            } else {
                n8 = nArray[n5];
                if (n8 <= n6) {
                    n8 = nArray[n5];
                    if (n8 == n6) {
                        n8 = 2;
                        nArray[n8] = n3 = nArray[n8] - n4;
                        nArray[16] = n4;
                        n8 = nArray[n4];
                        n3 = -1;
                        if (n8 == n3) {
                            nArray[n4] = n6;
                        }
                    }
                    if ((n8 = nArray[20]) > 0) {
                        n8 = 20;
                        nArray[n8] = n3 = nArray[n8] - n7;
                    }
                }
            }
            if ((n8 = nArray[8]) != (n3 = 7)) {
                n8 = 8;
                nArray[n8] = n3 = 7;
            }
            nArray[n5] = n8 = nArray[n5] - n7;
        }
        if ((n8 = nArray[n5]) <= 0) {
            n8 = nArray[n5];
            if (n8 != 0) return;
            n8 = nArray[15];
            if (n8 != 0) return;
            n8 = nArray[0] & 7;
            if (n8 != 0) return;
            n8 = nArray[n7] & 7;
            if (n8 != 0) return;
            nArray[n6] = n8 = this.aZ;
            return;
        }
        n8 = nArray[n5];
        n3 = 45;
        if (n8 >= n3) {
            n8 = nArray[20];
            n3 = 2;
            if (n8 < n3) {
                n8 = 20;
                nArray[n8] = n3 = nArray[n8] + 1;
            }
        } else {
            n8 = nArray[n5];
            n3 = 3;
            if (n8 <= n3 && (n8 = nArray[20]) > 0) {
                n8 = 20;
                nArray[n8] = n3 = nArray[n8] - n7;
            }
        }
        if ((n8 = nArray[n6]) > n7 && (n8 = nArray[0] & 7) == 0 && (n8 = nArray[n7] & 7) == 0) {
            nArray[n6] = n7;
        }
        nArray[n5] = n8 = nArray[n5] - n7;
    }

    public final void hideNotify() {
        int n = this.cb;
        int n2 = 1500;
        if (n == n2) {
            n = 1;
            this.C1175 = n;
        }
        if ((n = this.l) != (n2 = 46) && (n = this.l) != (n2 = 48) && (n = this.l) != (n2 = 47) && ((n = this.l) == (n2 = 2) || (n = this.l) == (n2 = 12) || (n = this.l) == (n2 = 13) || (n = this.l) == (n2 = 22) || (n = this.l) == (n2 = 23))) {
            this.a(3);
            n = this.l1031 ? 1 : 0;
            if (n != 0) {
                n = this.aq;
                this.h(n);
            }
            this.r = 0;
            this.at = 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void keyPressed(int n) {
        try {
            int n2 = this.at;
            if (n2 != 0) return;
            this.g1046 = n;
            this.h1047 = n;
            n2 = 0;
            Object var3_3 = null;
            this.i1048 = 0;
            n2 = this.l;
            int n3 = 46;
            if (n2 != n3 || (n2 = this.h1047) == (n3 = -5) || (n2 = this.h1047) == (n3 = -7)) {
                this.o = n2 = -1;
            }
            n2 = 0;
            var3_3 = null;
            this.u1096 = false;
            this.ao();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public final void keyReleased(int n) {
        this.i1048 = -1;
        this.g1046 = 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void paint(Graphics graphics) {
        Graphics graphics2;
        try {
            graphics2 = this.a1002 = graphics;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        graphics2 = DirectUtils.getDirectGraphics((Graphics)graphics2);
        this.a1005 = graphics2;
        graphics2 = this.a1002;
        Font font = this.a;
        graphics2.setFont(font);
        this.A();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object;
        int n = this.B1171;
        if (n != 0) {
            n = this.c();
            Object object2 = this.a1172;
            synchronized (object2) {
                this.bV = n;
                return;
            }
        }
        n = 1;
        this.B1171 = n;
        this.a1172 = object = new Object();
        while (true) {
            long l;
            long l2;
            block11: {
                long l3;
                long l4;
                if ((n = (int)(this.b1018 ? 1 : 0)) == 0) {
                    CMidlet.a();
                    return;
                }
                l2 = System.currentTimeMillis();
                this.G();
                int n2 = 0;
                this.h1047 = 0;
                this.repaint();
                this.serviceRepaints();
                l = 10;
                Thread.sleep(l);
                Thread.yield();
                while ((n2 = (l4 = (l = System.currentTimeMillis() - l2) - (l3 = (long)100)) == 0L ? 0 : (l4 < 0L ? -1 : 1)) < 0) {
                    Thread.yield();
                }
                n2 = this.c1020 ? 1 : 0;
                if (n2 == 0) break block11;
                n2 = this.s;
                l = n2;
                l3 = System.currentTimeMillis();
                l2 = l3 - l2 + l;
                n = (int)l2;
                try {
                    this.s = n;
                    break block11;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                continue;
            }
            l2 = this.a1019;
            l = 1L;
            this.a1019 = l2 += l;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void showNotify() {
        int n = this.cb;
        int n2 = 1000;
        if (n == n2) {
            n = 2;
            this.b1174 = (byte)n;
        } else {
            n = this.C1175 ? 1 : 0;
            if (n != 0) {
                n = 1;
                this.b1174 = (byte)n;
            } else {
                n = 3;
                this.b1174 = (byte)n;
            }
        }
        this.cb = 0;
    }
}

