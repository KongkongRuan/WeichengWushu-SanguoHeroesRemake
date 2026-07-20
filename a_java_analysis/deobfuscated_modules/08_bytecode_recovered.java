/**
 * ============================================================================
 *  模块 08: Vineflower 反编译失败的方法 (字节码手动恢复)
 * ============================================================================
 *
 *  原始类: a extends FullCanvas implements Runnable
 *  本模块包含: Vineflower 反编译失败的5个方法, 通过 javap 字节码手动恢复
 *
 *  交叉验证: javap (JDK 17) 字节码
 *  可靠性: ★★★★☆ (基于字节码分析, 逻辑可靠)
 *
 *  失败方法清单:
 *    1. int b()   — 同步锁+返回bV (VF L15768, javap L44520)
 *    2. int d()   — HTTP通信 (VF L17883, javap L49012)
 *    3. void av() — 启动游戏线程 (VF L15268, javap L44128)
 *    4. void aw() — RMS读取"__sfSmsInfo" (VF L15313, javap L44161)
 *    5. void ay() — 存档缓冲区处理 (VF L15744, 部分恢复)
 *
 *  注意: 这些方法在模块 05/06 中已有恢复版本
 *        本模块提供详细的字节码分析和恢复说明
 * ============================================================================
 */

// ============================================================================
// 1. int b() — 同步锁+返回bV (javap L44520-44558)
//
//    Vineflower 失败原因:
//      java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
//      at java.util.ArrayList.remove(ArrayList.java:504)
//      at FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
//
//    字节码分析:
//      0: aload_0          // this
//      1: getfield a1172   // 获取锁对象
//      4: astore_1         // 存入局部变量1
//      5: aload_1          // 加载锁对象
//      6: monitorenter     // 进入同步块
//      7: aload_0          // this
//      8: getfield bV      // 获取 bV 值
//     11: istore_2         // 存入局部变量2
//     12: aload_1          // 加载锁对象
//     13: monitorexit      // 退出同步块
//     14: iconst_2         // 常量2
//     15: istore_3         // 存入局部变量3
//     16: iload_2          // 加载bV
//     17: iload_3          // 加载2
//     18: if_icmpne 31     // 若 bV!=2 跳转到31
//     21: bipush 50        // 50ms
//     23: i2l              // 转long
//     24: lstore 4         // 存入局部变量4
//     26: lload 4          // 加载50
//     28: invokestatic Thread.sleep(J)V  // sleep(50)
//     31: iload_2          // 加载bV
//     32: ireturn          // 返回bV
//
//    异常表:
//      7-11 → 33 (any)
//      12-14 → 33 (any)
//      26-31 → 40 (Exception)
//      35-37 → 33 (any)
//
//    恢复后的 Java 代码:
// ============================================================================
private int b() {
    Object lock = this.a1172;
    synchronized (lock) {
        int n = this.bV;
        // monitorexit (隐含)
        if (n == 2) {
            try {
                Thread.sleep(50L);
            } catch (Exception e) {
                // 异常时继续执行
            }
        }
        return n;
    }
}

// ============================================================================
// 2. int d() — HTTP通信 (Procyon字节码 L13750-14334, javap L49012-49832)
//
//    Vineflower/CFR 反编译失败, 通过 Procyon原始字节码恢复
//
//    ★ v8 重大修正 (Procyon字节码三方交叉验证):
//      1. tableswitch { 2: GET, 3: POST } (非1/2!)
//      2. POST数据写入对GET和POST都适用 (共享代码路径 offset 187)
//      3. 响应码存储到 this.ca (offset 345-348)
//      4. 3xx重定向: getHeaderField("Location")→g1187, 返回1 (offset 357-432)
//      5. 响应体读取: 已知长度直接读, 未知用ByteArrayOutputStream (offset 435-831)
//      6. hex解码: 每2字节→1字节, 使用e()函数 (offset 627-722)
//      7. 连接清理: close + a1193=null (offset 895-912)
//      8. 返回值: 0=成功, 1=重试(重定向), -1=错误
//
//    关键字节码 (Procyon确认):
//      46: tableswitch { 2: 143, 3: 255, default: 72 }
//      143: setRequestMethod("GET")  → falls through to 159
//      255: setRequestMethod("POST") → goto 159
//      159: if (D1176) setRequestProperty("X-Online-Host", host)
//      187: if (H1188 != null) write POST data  ← GET和POST共享!
//      332: getResponseCode() → this.ca
//      357: if (ca >= 300 && ca < 400) → 重定向处理, return 1
//      435: 读取响应体 → I1189
//      627: hex解码 I1189
//      895: close a1193
//
//    恢复后的 Java 代码:
// ============================================================================
private int d() {
    String url = this.g1187;
    if (url == null) {
        url = this.f1186;  // g1187为null时使用f1186
    }

    String fullUrl = this.b(url);  // URL重写(代理)
    String host = a(url);          // 主机名提取

    try {
        this.a1193 = (HttpConnection) javax.microedition.io.Connector.open(fullUrl);

        // ★ v8修正: switch值 2=GET, 3=POST (Procyon字节码 offset 46-48 确认)
        switch (this.c1190) {
            case 2:  // GET (offset 143)
                this.a1193.setRequestMethod("GET");
                break;
            case 3:  // POST (offset 255)
                this.a1193.setRequestMethod("POST");
                break;
            default:  // offset 72
                throw new IOException();
        }

        // 代理设置 (GET和POST共享, offset 159)
        if (this.D1176) {
            this.a1193.setRequestProperty("X-Online-Host", host);
        }

        // ★ v8修正: POST数据写入对GET和POST都适用 (offset 187, 共享代码路径)
        if (this.H1188 != null) {
            java.io.OutputStream os = this.a1193.openOutputStream();
            for (int i = 0; i < this.H1188.length; i++) {
                os.write(this.H1188[i]);
            }
            os.close();
        }

        // 获取响应码并存入 this.ca (offset 332-348)
        this.ca = this.a1193.getResponseCode();

        // 3xx 重定向处理 (offset 357-432)
        if (this.ca >= 300 && this.ca < 400) {
            this.g1187 = this.a1193.getHeaderField("Location");
            if (this.a1193 != null) {
                this.a1193.close();
            }
            return 1;  // 重试
        }

        // 读取响应体到 I1189 (offset 435-831)
        java.io.InputStream is = this.a1193.openInputStream();
        long len = this.a1193.getLength();
        int ilen = (int) len;

        if (ilen > 0) {
            // 已知长度: 直接读取 (offset 552-618)
            if ((ilen & 1) != 0) {
                throw new IOException();  // 奇数长度异常 (offset 504)
            }
            this.I1189 = new byte[ilen];
            int offset = 0;
            while (offset < ilen) {
                int read = is.read(this.I1189, offset, ilen - offset);
                if (read < 0) break;
                offset += read;
            }
        } else {
            // 未知长度: 用ByteArrayOutputStream读取 (offset 735-831)
            ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
            byte[] buf = new byte[64];
            int read;
            while ((read = is.read(buf, 0, 64)) >= 0) {
                baos.write(buf, 0, read);
            }
            baos.close();
            this.I1189 = baos.toByteArray();
        }
        is.close();

        // hex解码: 每2字节 → 1字节 (offset 627-722)
        int decodedLen = this.I1189.length >> 1;
        byte[] decoded = new byte[decodedLen];
        for (int i = 0; i < decodedLen; i++) {
            int hi = e(this.I1189[i * 2]) << 4;
            int lo = e(this.I1189[i * 2 + 1]);
            decoded[i] = (byte)(hi | lo);
        }
        this.I1189 = decoded;

        // 关闭连接 (offset 895-912)
        this.a1193.close();
        this.a1193 = null;
        return 0;  // 成功

    } catch (Exception e) {
        // 异常时关闭连接,返回-1 (offset 82-134)
        try {
            if (this.a1193 != null) {
                this.a1193.close();
            }
        } catch (Exception e2) {}
        this.a1193 = null;
        return -1;
    }
}

// ============================================================================
// 3. void av() — 启动游戏线程 (javap L44128-44161)
//
//    Vineflower 失败原因:
//      java.lang.IndexOutOfBoundsException (同 b())
//
//    字节码分析:
//      0: getfield a1172     // 获取锁对象
//      4: astore_1
//      5: aload_1
//      6: monitorenter       // 进入同步块
//      7: iconst_2           // 常量2
//      8: istore_2
//      9: aload_0            // this
//     10: iload_2            // 2
//     11: putfield bV        // this.bV = 2
//     14: aload_1
//     15: monitorexit        // 退出同步块
//     16: new MIDletThread   // 创建线程对象
//     19: astore_1
//     20: aload_1
//     21: aload_0            // this (Runnable)
//     22: invokespecial MIDletThread.<init>(Runnable)  // 构造函数
//     25: aload_1
//     26: invokevirtual Thread.start()  // 启动线程
//     29: return
//
//    异常表:
//      10-14 → 30 (any)
//      14-16 → 30 (any)
//      31-33 → 30 (any)
//
//    恢复后的 Java 代码:
// ============================================================================
private void av() {
    synchronized (this.a1172) {
        this.bV = 2;
    }
    Thread t = new MIDletThread(this);
    t.start();
}

// ============================================================================
// 4. void aw() — RMS读取"__sfSmsInfo" (javap L44161-44520)
//
//    Vineflower 失败原因:
//      java.lang.RuntimeException: parsing failure!
//
//    字节码分析:
//      0: ldc "__sfSmsInfo"     // RMS名称
//      3: astore_1
//      4: iconst_0
//      5: istore_2              // recordId = 0
//      6: aconst_null
//      7: astore_3              // data = null
//      8: aload_1
//      9: iconst_0              // createIfNotExist = false
//     10: invokestatic RecordStore.openRecordStore(String, boolean)
//     13: astore_1              // rs
//     14: iconst_1
//     15: istore_2              // recordId = 1
//     16: aload_1
//     17: iload_2               // 1
//     18: invokevirtual getRecord(int) : byte[]
//     21: astore_3              // data = rs.getRecord(1)
//     22: new ByteArrayInputStream
//     25: astore 4              // bais
//     30: invokespecial <init>(byte[])
//     33: new DataInputStream
//     36: astore_3              // dis
//     37: aload 4               // bais
//     40: invokespecial <init>(InputStream)
//     
//     43: readInt()             // 读取版本号 (跳过)
//     44: invokevirtual readInt()
//     47: pop                  // 丢弃
//     48: readUTF()            // 读取菜单标题
//     49: invokevirtual readUTF()
//     52: astore 5
//     54: putfield b1177        // this.b1177 = readUTF()
//     
//     60: readUTF()            // 读取当前武将名
//     61: invokevirtual readUTF()
//     64: astore 5
//     66: putfield c1178        // this.c1178 = readUTF()
//     
//     72: readBoolean()         // 读取F1180标志
//     73: invokevirtual readBoolean()
//     76: istore 6
//     78: putfield F1180        // this.F1180 = readBoolean()
//     84: getfield F1180        // if (F1180)
//     88: istore 6
//     90: iload 6
//     92: ifeq 107              // 若false跳转
//     95: readUTF()             // 读取阵营名
//     96: invokevirtual readUTF()
//     99: astore 5
//    101: putfield d1181        // this.d1181 = readUTF()
//    
//    107: readBoolean()         // 读取G1182标志
//    108: invokevirtual readBoolean()
//    111: istore 6
//    113: putfield G1182        // this.G1182 = readBoolean()
//    119: getfield G1182        // if (G1182)
//    123: istore 6
//    125: iload 6
//    127: ifeq 142              // 若false跳转
//    130: readUTF()             // 读取关卡名
//    131: invokevirtual readUTF()
//    134: astore 5
//    136: putfield e1183        // this.e1183 = readUTF()
//    
//    142: close()               // dis.close()
//    146: close()               // bais.close()
//    151: closeRecordStore()    // rs.closeRecordStore()
//    155: return
//    
//    异常处理 (offset 156-183):
//    156: astore_1              // 捕获异常
//    157: ldc "YXBY15 2LD210A10 IF2"  // 默认武将名
//    160: astore_1
//    161: putfield c1178        // this.c1178 = "YXBY15 2LD210A10 IF2"
//    166: ldc "106633000015"    // 默认菜单标题
//    169: astore_1
//    170: putfield b1177        // this.b1177 = "106633000015"
//    175: invokespecial ax()    // 调用ax()写入默认值
//    179: goto 155              // 跳转到return
//    182: astore_1              // 其他异常
//    183: goto 155              // 跳转到return
//
//    恢复后的 Java 代码:
// ============================================================================
private final void aw() {
    try {
        RecordStore rs = RecordStore.openRecordStore("__sfSmsInfo", false);
        byte[] data = rs.getRecord(1);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        
        dis.readInt();                          // 版本号 (跳过)
        this.b1177 = dis.readUTF();             // 菜单标题
        this.c1178 = dis.readUTF();             // 当前武将名
        
        this.F1180 = dis.readBoolean();         // 阵营名标志
        if (this.F1180) {
            this.d1181 = dis.readUTF();         // 阵营名
        }
        
        this.G1182 = dis.readBoolean();         // 关卡名标志
        if (this.G1182) {
            this.e1183 = dis.readUTF();         // 关卡名
        }
        
        dis.close();
        bais.close();
        rs.closeRecordStore();
        
    } catch (Exception e) {
        // 异常时设置默认值并写入RMS
        this.c1178 = "YXBY15 2LD210A10 IF2";
        this.b1177 = "106633000015";
        try {
            this.ax();  // 写入默认值
        } catch (Exception e2) {
            // 忽略
        }
    }
}

// ============================================================================
// 5. void ay() — 存档缓冲区处理 (VF L15744, 部分恢复)
//
//    Vineflower 部分成功, 但有 try-catch 结构问题
//    字节码分析 (javap):
//      检查 a1191 (ByteArrayOutputStream) 是否存在
//      若存在则处理存档数据
//
//    恢复后的 Java 代码:
// ============================================================================
private void ay() {
    try {
        ByteArrayOutputStream var10000 = this.a1191;
        if (var10000 != null) {
            // 处理存档缓冲区
            // ... 具体逻辑见 VF L15744
        }
    } catch (Exception e) {
        // 异常处理
    }
}

/**
 * ============================================================================
 * 字节码恢复总结
 * ============================================================================
 *
 * 1. b()  — 同步锁方法, 返回 bV 值, 若 bV==2 则 sleep(50ms)
 *           核心: 线程同步控制, 用于 run() 中的线程等待
 *
 * 2. d()  — HTTP 通信方法, 支持 GET/POST
 *           核心: 上传分数/下载武将语音
 *           使用代理: D1176=true 时添加 "http://10.0.0.172:80" 前缀
 *           POST数据: H1188 (byte[])
 *           返回: HTTP响应码, -1=错误
 *
 * 3. av() — 启动游戏线程
 *           核心: 设置 bV=2, 创建并启动 MIDletThread
 *           被 a(byte) 构造函数调用
 *
 * 4. aw() — 读取 SMS 信息 (RMS "__sfSmsInfo")
 *           核心: 读取付费/授权信息
 *           格式: int(版本) + UTF(标题) + UTF(武将) + bool+UTF(阵营) + bool+UTF(关卡)
 *           异常默认值: c1178="YXBY15 2LD210A10 IF2", b1177="106633000015"
 *
 * 5. ay() — 存档缓冲区处理
 *           核心: 处理 a1191 (ByteArrayOutputStream)
 *           被构造函数和存档方法调用
 * ============================================================================
 */
