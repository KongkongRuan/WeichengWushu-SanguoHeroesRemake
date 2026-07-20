/**
 * ============================================================================
 *  模块 06: a()-updateEnemyMovement() 游戏逻辑方法
 * ============================================================================
 *
 *  原始类: a extends FullCanvas implements Runnable
 *  本模块包含: a-z 系列方法 (含重载, 约50个)
 *
 *  交叉验证: Vineflower 主源 (L9993-27115)
 *  可靠性: ★★★★☆
 *
 *  ★ v1 版本重大错误修正:
 *    - b() 返回 int, 不是 void
 *    - c() 返回 int, 不是 void
 *    - d() 返回 int, 不是 void (HTTP通信)
 *    - b(int) 返回 int (敌人HP), 不是 void
 *    - drawProgressBar() 是进度条渲染, 不是特效更新
 *    - handleVolume() 是音量控制, 不是经济更新
 *    - updateScrollPos() 是滚动位置更新, 不是塔绘制
 *    - clearBackground() 是背景清屏, 不是HUD绘制
 *    - handleFactionSelect() 是阵营选择状态机, 不是网络上传
 *    - renderFactionSelect() 是阵营选择渲染, 不是音频控制
 *    - updateEnemyMovement() 是敌人移动更新, 不是初始化
 * ============================================================================
 */

// ============================================================================
// a() 系列 — int 返回
// ============================================================================

// a() — 随机数 0-255 (VF L9993-9997)
private final int randomByte() {
    return this.random.nextInt() & 0xFF;
}

// a(int) — 瓦片属性 tileProperties[n]>>1 (VF L9997-10001)
private int getTileProperty(int var1) {
    return this.tileProperties[var1] >> 1;
}

// a(int,int) — 瓦片索引 (VF L10001-10009)
//    计算: (var2>>4) * bG + (var1>>4)
private int calcTileIndex(int var1, int var2) {
    int var3 = var2 >> 4;
    int var4 = this.mapColsG2;
    var3 *= var4;
    var4 = var1 >> 4;
    return var3 + var4;
}

// a(int,int,int) — 角度计算 (VF L10009-10072)
//    使用 tangentTable 正切表, 二分查找 0-89 度
//    ★ v5 修正: 修复二分查找逻辑 (lo 被错误赋值为数组值而非索引)
//    ★ v7 修正: 首次迭代应使用预设mid=45, 而非(hi+lo)>>1=44
//               VF for循环更新表达式在循环体之后执行
private int calcAngle(int var1, int var2, int var3) {
    int result = 45;
    if (var2 != 0 && var3 != 0) {
        int absN = Math.abs(var1);
        int hi = 89;
        int lo = 0;
        int mid = 45;  // ★ 预设值, 同 VF var7 = var8 = 45

        // 二分查找 tangentTable 表中 >= absN 的最小角度
        // 注意: mid 更新在循环体末尾, 首次迭代使用预设值45
        while (hi > lo) {
            int val = this.tangentTable[mid];
            if (val > absN) {
                hi = mid - 1;
            } else {
                if (val >= absN) {
                    break;  // 找到精确匹配
                }
                lo = mid + 1;
            }
            if (hi <= lo) {
                mid = lo;
                break;
            }
            mid = (hi + lo) >> 1;  // ★ 在末尾更新, 供下次迭代使用
        }
        result = mid;

        // 象限调整
        if (var2 < 0 && var3 > 0) {
            result = 180 - result;
        } else if (var2 < 0 && var3 < 0) {
            result += 180;
        } else if (var2 > 0 && var3 < 0) {
            result = 360 - result;
        }

        if (result >= 360) {
            result -= 360;
        }
    } else if (var2 == 0) {
        result = var3 > 0 ? 90 : 270;
    } else {
        result = var2 > 0 ? 0 : 180;
    }
    return result;
}

// a(int,int,int,int) — 距离/角度计算 (VF L10074-10095)
private int calcAngleFromDelta(int var1, int var2, int var3, int var4) {
    int var5 = var3 - var1;
    int var6 = var4 - var2;
    if (var5 != 0 && var6 != 0) {
        int var7 = Math.abs((var6 << 12) / var5);
        var5 = this.calcAngle(var7, var5, var6);
    } else if (var5 == 0) {
        var5 = var6 > 0 ? 90 : 270;
    } else {
        var5 = var5 > 0 ? 0 : 180;
    }
    return var5;
}

// a(int,byte[],int) — ★ HP计算 (VF L10095-10142)
//    非 v1 标注的 readByteArray!
//    从 altHpCoeffs/enemyHpCoeffs/towerAtkSpeed 数组计算 HP 值
//    ★ v9 修正: 完整恢复 (原为存根)
//
//    逻辑:
//    1. 若 var2==altHpCoeffs (备用HP数据):
//       - 检查 levelUnlocked[0], true则bonus=5, false则bonus=0
//       - 调用 i(var1,var3), 若返回非0:
//         bonus += d(var2[var1<<1], var2[(var1<<1)+1], var3) >> 2
//    2. 否则若 var2==towerAtkSpeed (塔HP数据):
//       - 调用 n(var1,var3), true则bonus=-10, false则bonus=0
//    3. 否则: bonus=0
//    4. 基础HP = d(var2[var1<<1], var2[(var1<<1)+1], var3)
//    5. 返回 bonus + 基础HP
private int calcHp(int var1, byte[] var2, int var3) {
    int bonus = 0;
    byte[] sData = this.altHpCoeffs;
    int var19;

    if (var2 == sData) {
        // 使用 altHpCoeffs (备用HP数据)
        boolean[] flags = this.levelUnlocked;
        if (flags[0]) {
            var19 = 5;
        } else {
            var19 = 0;
        }

        int check = this.helperI_2P_bool(var1, var3);
        if (check != 0) {
            int idx = var1 << 1;
            int hi = var2[idx];
            int lo = var2[(var1 << 1) + 1];
            int extra = calcBaseHp(hi, lo, var3) >> 2;
            var19 += extra;
        }
    } else {
        // 检查是否为 towerAtkSpeed (塔HP数据)
        byte[] uData = this.towerAtkSpeed;
        if (var2 == uData) {
            boolean isTower = this.helperN_2P_bool(var1, var3);
            if (isTower) {
                var19 = -10;
            } else {
                var19 = 0;
            }
        } else {
            var19 = 0;
        }
    }

    // 基础HP计算
    int idx = var1 << 1;
    int baseHi = var2[idx];
    int baseLo = var2[(var1 << 1) + 1];
    int baseHP = calcBaseHp(baseHi, baseLo, var3);

    return var19 + baseHP;
}

// ============================================================================
// a() 系列 — static 方法
// ============================================================================

// a(DataInputStream) — 读取自定义格式字符串 (VF L10142-10170)
//    格式: int长度 + char[长度](每个char为readShort)
private static String readCustomString(DataInputStream var0) throws IOException {
    int len = var0.readInt();
    if (len < 0) throw new IOException("nag len");
    if (len == 0) return "";
    char[] chars = new char[len];
    for (int i = 0; i < len; i++) {
        chars[i] = (char) var0.readShort();
    }
    return new String(chars, 0, len);
}

// a(String) — URL主机名提取 (VF L10170-10184)
//    跳过前7个字符(http://),截取到下一个'/'
private static String extractHostName(String var0) {
    int start = 7;
    int end = var0.indexOf('/', start);
    if (end < start) end = var0.length();
    return var0.substring(start, end);
}

// a(InputStream) — 读取2字节小端序short (VF L10184-10190)
private static short readShortLE(InputStream var0) throws IOException {
    int low = var0.read() & 0xFF;
    int high = (var0.read() << 8) & 0xFF00;
    return (short)(low | high);
}

// ============================================================================
// a() 系列 — void 方法
// ============================================================================

// a() — ★ 菜单返回 (VF L10190-10199)
//    m--, l = b[m]
private void menuReturn() {
    this.menuDepth--;
    this.gameState = this.menuHistoryStack[this.menuDepth];
}

// a(byte) — 游戏模式设置 (VF L10199-10214)
//    1. 调用 G(var1)
//    2. var1==1: H(16), H(44), c("N73")
//    3. 调用 processSaveBuffer() 和 startGameThread()
private void setGameMode(byte var1) {
    this.helperG_int(var1);
    switch (var1) {
        case 1:
            this.helperH_int(16);
            this.helperH_int(44);
            this.adaptDevice("N73");
        default:
            this.processSaveBuffer();
            this.startGameThread();
    }
}

// a(int) — ★ 菜单跳转 (VF L10214-10225)
//    b[m] = l, l = var1, m++
private void menuGoto(int var1) {
    this.menuHistoryStack[this.menuDepth] = this.gameState;
    this.gameState = var1;
    this.menuDepth++;
}

// a(int,int) — 精灵图加载 (VF L10225-10482)
//    约257行,加载指定类型的精灵图
private void loadSprites(int var1, int var2) {
    // ... 完整见 VF L10225
}

// a(int,int,int) — (VF L10482-10490)
private void drawStringAt(int var1, int var2, int var3) {
    // ... (VF L10482)
}

// a(int,int,int,byte,int,boolean) — 瓦片填充 (VF L10490-10573)
//    建造/拆除塔时使用
private void fillTile(int var1, int var2, int var3, byte var4, int var5, boolean var6) {
    // ... 完整见 VF L10490
}

// a(int,int,int,int) — (VF L10573-10672)
private void helperA_4P(int var1, int var2, int var3, int var4) {
    // ... (VF L10573)
}

// a(int,int,int,int,int) — 范围攻击渲染 (VF L10672-10685)
private void renderRangeAttack(int var1, int var2, int var3, int var4, int var5) {
    if (this.selectedTowerIdx != -1) {
        this.graphicsCtx.setClip(0, 0, 240, 320);
        this.graphicsCtx.setColor(13971834);
        String text = this.gameTexts[var1 + 113];
        // ... 绘制文字面板
    }
}

// ============================================================================
// a() 系列 — boolean 返回
// ============================================================================

// boolean a() — ★ RMS 存档读取 (VF L12049-13099)
//    读取 "sanGuoTd" 存档
private final boolean loadRMS_sanGuoTd() {
    String var5 = "sanGuoTd";
    // ... 完整见 VF L12049-13099 (约1050行)
    return true;
}

// ============================================================================
// b() 系列
// ============================================================================

// int b() — ★ 同步锁+返回bV (VF L15768-15818)
//    VF 反编译失败, 通过 javap 恢复 (L44520-44558)
//    非 v1 标注的 void!
private int getThreadState() {
    synchronized (this.syncLock) {
        int n = this.threadState;
        if (n == 2) {
            try { Thread.sleep(50); } catch (Exception e) {}
        }
        return n;
    }
}

// int b(int) — ★ 敌人HP计算 (VF L15818-15841)
//    非 v1 标注的 void!
private int calcEnemyHp(int var1) {
    int[] var5 = this.enemySlots[var1];
    int var6 = 0;
    int var3 = 0;
    while (var3 < var5[3]) {
        int var7 = var5[2];
        byte[] var8 = this.enemyHpCoeffs;
        var7 = this.calcHp(var7, var8, var3);
        var6 += var7;
        var3++;
    }
    return this.killRewards[var5[2]] + var6 >> 1;
}

// int b(int,int) — 瓦片坐标转换 (VF L15841-15854)
private int tileCoordConvert(int var1, int var2) {
    if (var2 == 0) {
        return var1 % this.mapColsG2 << 4;
    } else {
        return var1 / this.mapColsG2 << 4;
    }
}

// String b(String) — URL重写(代理) (VF L15923-15941)
//    若 useProxy=true, 添加代理前缀 "http://10.0.0.172:80"
private String rewriteUrlProxy(String var1) {
    if (this.useProxy) {
        int idx = var1.indexOf('/', 7);
        String path = var1.substring(idx);
        return new StringBuffer("http://10.0.0.172:80").append(path).toString();
    }
    return var1;
}

// void b() — 菜单重置 (VF L15941-15945)
private void menuReset() {
    this.menuDepth = 0;
}

// void b(int) — 菜单回退到指定状态 (VF L15945-15961)
private void menuBackTo(int var1) {
    do {
        this.menuDepth--;
    } while (this.menuHistoryStack[this.menuDepth] != var1);
    this.gameState = this.menuHistoryStack[this.menuDepth];
}

// boolean b() — RMS 存档读取 "sanGuoTdData" (VF L16602-16845)
private final boolean loadRMS_sanGuoTdData() {
    String var4 = "sanGuoTdData";
    // ... 完整见 VF L16602
    return true;
}

// boolean b(int) — 瓦片可建造检查 (VF L16845-16868)
//    ★ v5 修正: 补充漏掉的 this.m(var1) 调用 (不可建造时调用)
//    ★ v5 修正: c(int) 返回 boolean, 变量类型改为 boolean
private boolean canBuildTower(int var1) {
    boolean var2 = this.isTileEven(var1);
    if (var2) {
        if (this.tileProperties[var1] < 8) {
            if (this.tileDataD[var1] < 6) {
                return true;
            }
        }
    }
    this.helperM_1P(var1);  // ★ 不可建造时调用 m(var1) (VF L16862)
    return false;
}

// boolean b(int,int) — 瓦片可建造检查(带坐标) (VF L16868-16889)
//    ★ v5 新增: 之前遗漏的方法重载
//    通过 a(var1,var2) 计算瓦片索引, 然后检查可建造性
private boolean canBuildTowerAt(int var1, int var2) {
    int var3 = this.calcTileIndex(var1, var2);
    boolean var4 = this.isTileEven(var3);
    if (var4) {
        if (this.tileProperties[var3] < 8) {
            if (this.tileDataD[var3] < 6) {
                return true;
            }
        }
    }
    this.helperM_1P(var3);  // 不可建造时调用 m(var3) (VF L16885)
    return false;
}

// ============================================================================
// c() 系列
// ============================================================================

// int c() — ★ 循环调用d() (VF L16889-16902)
//    非 v1 标注的 void!
private int waitHttpResponse() {
    while (true) {
        int var1 = this.doHttpCommunication();
        if (var1 != 1) {
            this.redirectUrl = null;
            return var1;
        }
        Thread.yield();
    }
}

// int c(int,int) — 坐标边界检查 (VF L16925-16944)
//    ★ v9 修正: 完整恢复 (原缺少瓦片属性返回)
//    1. 将坐标限制在屏幕边界内 (bI-8, bJ-8)
//    2. 计算瓦片索引 a(x,y)
//    3. 返回 tileProperties[索引] >> 1
private int checkTileBoundary(int var1, int var2) {
    byte var3 = 8;
    int var4 = this.screenCenterX;
    if (var1 > var4) {
        var4 = this.screenCenterX - var3;
    } else {
        var4 = var1;
    }
    int var5 = this.screenCenterY;
    if (var2 > var5) {
        var5 = this.screenCenterY - var3;
    } else {
        var5 = var2;
    }
    byte[] var6 = this.tileProperties;
    var4 = this.calcTileIndex(var4, var5);  // ★ 计算瓦片索引
    return var6[var4] >> 1;      // ★ 返回瓦片属性
}

// void c() — 重置计数器 (VF L16979-16985)
private void resetCounters() {
    this.activeTowerCount = 0;
    this.counterT = 0;
}

// void c(int) — ★ 精灵图加载 (VF L16985-17192)
//    非 v1 标注的 spawnEnemy!
private void loadSprite(int var1) {
    if (this.spriteImages[var1] == null) {
        // 从 resourcePaths[var1] 路径加载精灵图
        // ... 完整见 VF L16985
    }
}

// boolean c() — RMS 存档读取 "freeGame" (VF L17696-17854)
private final boolean loadRMS_freeGame() {
    String var4 = "freeGame";
    // ... 完整见 VF L17696
    return true;
}

// boolean c(int) — 瓦片奇偶检查 (VF L17854-17868)
private boolean isTileEven(int var1) {
    return (this.tileProperties[var1] & 1) == 0;
}

// ============================================================================
// d() 系列
// ============================================================================

// int d() — ★★★ HTTP通信 (VF L17883-18640)
//    VF/CFR 反编译失败, 通过 Procyon 字节码 + javap 恢复
//    非 v1 标注的 void updateTowers!
//
//    ★ v8 重大修正 (Procyon 字节码三方交叉验证):
//      1. switch值: 2=GET, 3=POST (非1/2!)
//      2. POST数据写入对GET和POST都适用 (共享代码路径)
//      3. 响应码存储到 this.ca
//      4. 3xx重定向: 读取Location头存入g1187, 返回1重试
//      5. 响应体读取并hex解码到 httpResponseData
//      6. 连接清理: close + httpConnection=null
//      7. 返回值: 0=成功, 1=重试(重定向), -1=错误
private int doHttpCommunication() {
    String url = this.redirectUrl;
    if (url == null) {
        url = this.statusMessage;
    }

    String fullUrl = this.rewriteUrlProxy(url);       // URL重写(代理)
    String host = a(url);               // 主机名提取

    try {
        this.httpConnection = (HttpConnection) javax.microedition.io.Connector.open(fullUrl);

        // ★ v8修正: switch值 2=GET, 3=POST (Procyon字节码确认)
        switch (this.httpMethod) {
            case 2:  // GET
                this.httpConnection.setRequestMethod("GET");
                break;
            case 3:  // POST
                this.httpConnection.setRequestMethod("POST");
                break;
            default:
                throw new IOException();
        }

        // 代理设置 (GET和POST共享)
        if (this.useProxy) {
            this.httpConnection.setRequestProperty("X-Online-Host", host);
        }

        // ★ v8修正: POST数据写入对GET和POST都适用 (共享代码路径)
        if (this.httpPostData != null) {
            java.io.OutputStream os = this.httpConnection.openOutputStream();
            for (int i = 0; i < this.httpPostData.length; i++) {
                os.write(this.httpPostData[i]);
            }
            os.close();
        }

        // 获取响应码并存入 this.ca
        this.httpResponseCode = this.httpConnection.getResponseCode();

        // 3xx 重定向处理
        if (this.httpResponseCode >= 300 && this.httpResponseCode < 400) {
            this.redirectUrl = this.httpConnection.getHeaderField("Location");
            if (this.httpConnection != null) {
                this.httpConnection.close();
            }
            return 1;  // 重试
        }

        // 读取响应体到 httpResponseData
        java.io.InputStream is = this.httpConnection.openInputStream();
        long len = this.httpConnection.getLength();
        int ilen = (int) len;

        if (ilen > 0) {
            // 已知长度: 直接读取
            if ((ilen & 1) != 0) {
                throw new IOException();  // 奇数长度异常
            }
            this.httpResponseData = new byte[ilen];
            int offset = 0;
            while (offset < ilen) {
                int read = is.read(this.httpResponseData, offset, ilen - offset);
                if (read < 0) break;
                offset += read;
            }
        } else {
            // 未知长度: 用ByteArrayOutputStream读取
            ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
            byte[] buf = new byte[64];
            int read;
            while ((read = is.read(buf, 0, 64)) >= 0) {
                baos.write(buf, 0, read);
            }
            baos.close();
            this.httpResponseData = baos.toByteArray();
        }
        is.close();

        // hex解码: 每2字节 → 1字节 (使用 clearScreen() 函数)
        int decodedLen = this.httpResponseData.length >> 1;
        byte[] decoded = new byte[decodedLen];
        for (int i = 0; i < decodedLen; i++) {
            int hi = hexCharToInt(this.httpResponseData[i * 2]) << 4;
            int lo = hexCharToInt(this.httpResponseData[i * 2 + 1]);
            decoded[i] = (byte)(hi | lo);
        }
        this.httpResponseData = decoded;

        // 关闭连接
        this.httpConnection.close();
        this.httpConnection = null;
        return 0;  // 成功

    } catch (Exception e) {
        // 异常时关闭连接,返回-1
        try {
            if (this.httpConnection != null) {
                this.httpConnection.close();
            }
        } catch (Exception e2) {}
        this.httpConnection = null;
        return -1;
    }
}

// int d(int) — 瓦片类型转换 (VF L18640-18663)
private int convertTileType(int var1) {
    int var4 = this.tileProperties[var1];
    if (var4 >= 12) {
        var4 = this.tileProperties[var1] - 12;
    } else if (var4 <= -12) {
        var4 = 98 - this.tileProperties[var1];
    } else {
        var4 = -1;
    }
    return var4;
}

// void d() — 建造菜单背景 (VF L18667-18699)
private void drawBuildMenuBg() {
    this.graphicsCtx.setColor(16580557);
    this.graphicsCtx.fillRect(15, 13, 210, 297);
    for (int i = 0; i < 10; i++) {
        this.graphicsCtx.drawImage(this.spriteImages[3][25], 15, (i << 5) + 13, 0);
        this.drawImageRotation(this.spriteImages[3][25], 216, (i << 5) + 13, 1);
    }
}

// void d(int) — 背景卷轴绘制 (VF L18699-18719)
private void drawScrollingBg(int var1) {
    for (int i = 0; i < 3; i++) {
        this.graphicsCtx.drawImage(this.spriteImages[4][6], this.scrollX + i * 176, this.scrollY + var1, 0);
    }
}

// boolean d() — 横屏标志检查 (VF L19041-19056)
private boolean checkLandscape() {
    if (this.stateBy <= 0) {
        this.isLandscape = false;
        return true;
    } else {
        this.isLandscape = true;
        return false;
    }
}

// boolean d(int) — ★★★ 敌人路径验证 (VF L19056-19212)
//    ★ v11 修正: 完整恢复 (原为存根)
//    约156行,敌人路径可达性验证核心方法
//
//    数据结构:
//    - enemySlots[var1] = 敌人数据: [2]=路径ID, [3]=敌人等级
//    - levelUnlocked[路径ID] = 路径是否已验证标志
//    - enemyHpCoeffs = 敌人HP数据
//    - this.ac = 阵营选择 (0或1)
//    - this.o = 失败原因代码 (0=HP验证失败, 4=等级过高, 5=科技树未解锁, 6=阵营路径未解锁)
//
//    验证逻辑:
//    1. 路径已验证 (levelUnlocked[路径ID]==true):
//       - 等级<5: 验证HP j(a(路径ID,enemyHpCoeffs,等级)), 通过返回true, 失败o=0
//       - 等级>=5: o=4, 返回false
//    2. 路径未验证:
//       - 等级<5: 验证HP (不设置f1106), 通过返回true, 失败o=0
//       - 等级==5:
//         * 路径ID==0: 检查科技树clearScreen(), 通过则验证HP并设置f1106, 失败o=0; 科技树未通过o=5
//         * 路径ID!=0: 根据阵营ac分支:
//           - 阵营0: 路径ID<6需f1106[0]验证, 路径ID>=6直接验证
//           - 阵营1: 路径ID<6直接验证, 路径ID>=6需f1106[0]验证
//       - 等级>5: o=4, 返回false
private boolean validateEnemyPath(int var1) {
    byte LEVEL_5 = 5;
    int IDX_LEVEL = 3;
    boolean TRUE = true;
    byte IDX_PATH = 2;
    int[] var6 = this.enemySlots[var1];
    boolean[] var7 = this.levelUnlocked;
    int pathId = var6[IDX_PATH];
    boolean pathVerified = var7[pathId];

    if (!pathVerified) {
        // ========== 路径未验证 ==========
        int level = var6[IDX_LEVEL];
        if (level < LEVEL_5) {
            // 等级 < 5: 直接验证HP (不设置f1106)
            int hp = this.calcHp(var6[IDX_PATH], this.enemyHpCoeffs, var6[IDX_LEVEL]);
            if (this.helperJ_1P_bool(hp)) {
                return true;
            }
            this.selectedTowerIdx = 0;
        } else {
            // 等级 >= 5
            if (level == LEVEL_5) {
                // 等级 == 5
                if (var6[IDX_PATH] == 0) {
                    // 路径ID == 0: 需科技树全解锁
                    if (this.isTechTreeUnlocked()) {
                        // 科技树全解锁, 验证HP并设置f1106
                        int hp = this.calcHp(var6[IDX_PATH], this.enemyHpCoeffs, var6[IDX_LEVEL]);
                        if (this.helperJ_1P_bool(hp)) {
                            this.levelUnlocked[var6[IDX_PATH]] = true;
                            return true;
                        }
                        this.selectedTowerIdx = 0;
                    } else {
                        this.selectedTowerIdx = LEVEL_5;  // o=5, 科技树未解锁
                    }
                } else {
                    // 路径ID != 0: 根据阵营分支
                    switch (this.factionIdx) {
                        case 0:
                            // 阵营0
                            if (var6[IDX_PATH] < 6) {
                                // 路径ID < 6: 需f1106[0]验证
                                if (this.levelUnlocked[0]) {
                                    int hp = this.calcHp(var6[IDX_PATH], this.enemyHpCoeffs, var6[IDX_LEVEL]);
                                    if (this.helperJ_1P_bool(hp)) {
                                        this.levelUnlocked[var6[IDX_PATH]] = true;
                                        return true;
                                    }
                                    this.selectedTowerIdx = 0;
                                } else {
                                    this.selectedTowerIdx = 6;  // 阵营路径未解锁
                                }
                            } else {
                                // 路径ID >= 6: 直接验证
                                int hp = this.calcHp(var6[IDX_PATH], this.enemyHpCoeffs, var6[IDX_LEVEL]);
                                if (this.helperJ_1P_bool(hp)) {
                                    this.levelUnlocked[var6[IDX_PATH]] = true;
                                    return true;
                                }
                                this.selectedTowerIdx = 0;
                            }
                            break;
                        case 1:
                            // 阵营1
                            if (var6[IDX_PATH] < 6) {
                                // 路径ID < 6: 直接验证
                                int hp = this.calcHp(var6[IDX_PATH], this.enemyHpCoeffs, var6[IDX_LEVEL]);
                                if (this.helperJ_1P_bool(hp)) {
                                    this.levelUnlocked[var6[IDX_PATH]] = true;
                                    return true;
                                }
                                this.selectedTowerIdx = 0;
                            } else {
                                // 路径ID >= 6: 需f1106[0]验证
                                if (this.levelUnlocked[0]) {
                                    int hp = this.calcHp(var6[IDX_PATH], this.enemyHpCoeffs, var6[IDX_LEVEL]);
                                    if (this.helperJ_1P_bool(hp)) {
                                        this.levelUnlocked[var6[IDX_PATH]] = true;
                                        return true;
                                    }
                                    this.selectedTowerIdx = 0;
                                } else {
                                    this.selectedTowerIdx = 6;  // 阵营路径未解锁
                                }
                            }
                            break;
                    }
                }
            } else {
                // 等级 > 5
                this.selectedTowerIdx = 4;
            }
        }
    } else {
        // ========== 路径已验证 ==========
        int level = var6[IDX_LEVEL];
        if (level < LEVEL_5) {
            // 等级 < 5: 验证HP
            int hp = this.calcHp(var6[IDX_PATH], this.enemyHpCoeffs, var6[IDX_LEVEL]);
            if (this.helperJ_1P_bool(hp)) {
                return true;
            }
            this.selectedTowerIdx = 0;
        } else {
            // 等级 >= 5
            this.selectedTowerIdx = 4;
        }
    }

    return false;
}

// ============================================================================
// clearScreen() drawProgressBar() handleVolume() 系列
// ============================================================================

// void clearScreen() — 清屏 (VF L19257-19264)
private void clearScreen() {
    this.clearBackground();
    this.graphicsCtx.setColor(12493976);
    this.graphicsCtx.fillRect(0, 13, 240, 297);
    this.drawBuildMenuBg();
}

// boolean clearScreen() — 科技树全解锁检查 (VF L19432-19455)
private boolean isTechTreeUnlocked() {
    for (int i = 0; i < 5; i++) {
        if (!this.techUnlocked[i]) return false;
    }
    return true;
}

// boolean e(int) — ★★ 敌人攻击检查 (VF L19455-19611)
//    ★ v11 修正: 完整恢复 (原为存根)
//    ★ v11b 修正: 补充case 0,1,3,4,5,7循环结束后的计数器递增逻辑
//    约156行,敌人攻击塔的核心逻辑
//
//    数据结构:
//    - enemySlots[var1] = 敌人数据: [0]=x, [1]=y, [2]=路径ID, [3]=等级, [4]=状态, [6]=HP, [8]=目标, [14]=攻击计数
//    - levelSpawnPoints[路径ID] = 路径偏移量 (<<3 用于坐标计算)
//    - towerDamageRange = 路径数据
//    - towerSlots = 塔数据数组
//    - activeTowerIndices = 活跃塔索引数组
//    - towerAtkSpeed = 塔HP数据
//    - aP = 活跃塔数量
//
//    攻击模式 (按路径ID分类):
//    - case 0,1,3,4,5,7: 范围攻击 - 遍历所有活跃塔, 检查碰撞, 攻击匹配的塔
//      ★ 循环结束后: 若敌人处于攻击状态(state==6)且有攻击计数, 递增计数器(上限10)
//    - case 2,6: 直接攻击 - 直接检查前方是否有塔
//    - case 8,9: 范围攻击+debuff - 先对范围内塔施加debuff(设var16[15]=48), 再直接攻击
private boolean checkEnemyAttack(int var1) {
    byte TOWER_HP = 6;
    byte IDX_LEVEL = 3;
    byte TRUE = 1;
    byte IDX_PATH = 2;
    int[][] enemies = this.enemySlots;
    int[] var7 = enemies[var1];

    // 计算敌人当前坐标 (含路径偏移)
    int x = var7[0] + (this.levelSpawnPoints[var7[IDX_PATH]] << 3);
    int y = var7[TRUE] + (this.levelSpawnPoints[var7[IDX_PATH]] << 3);
    int attackRange = this.calcAngle(var7[IDX_PATH], this.towerDamageRange, var7[IDX_LEVEL]);

    switch (var7[IDX_PATH]) {
        case 0:
        case 1:
        case 3:
        case 4:
        case 5:
        case 7:
            // ========== 范围攻击 ==========
            for (int i = 0; i < this.activeTowerCount; i++) {
                int[] tower = this.towerSlots[this.activeTowerIndices[i]];
                // 检查塔是否在攻击范围内
                if (this.helperA_5P_bool2(tower[0], tower[TRUE], x, y, attackRange)) {
                    // 检查塔类型
                    if (isNotCommonTower(tower[8])) {
                        // 计算对塔的伤害
                        int dmg = this.calcAngle(var7[IDX_PATH], this.towerAtkSpeed, var7[IDX_LEVEL]);
                        var7[TOWER_HP] = dmg;  // 存储伤害到敌人数据

                        // 检查塔状态
                        if (var7[4] == TOWER_HP) {
                            // 攻击计数逻辑
                            var7[14]++;
                            if (var7[14] <= IDX_LEVEL) {
                                return true;
                            }
                            var7[14] = 10;  // 重置攻击计数
                        }

                        var7[8] = this.activeTowerIndices[i];  // 设置目标塔索引
                        this.helperV_1P(var1);  // 执行攻击
                        return true;
                    }
                }
            }
            // ★ v11b 修正: 循环结束后 (没有找到目标塔)
            // 若敌人处于攻击状态(state==6)且有攻击计数, 递增计数器(上限10)
            // 语义: 敌人在攻击状态但找不到目标时, 仍递增攻击计数
            if (var7[4] == TOWER_HP) {
                if (var7[14] > 0) {
                    if (var7[14] < 10) {
                        var7[14]++;
                    }
                }
            }
            break;
        case 2:
        case 6:
            // ========== 直接攻击 ==========
            if (this.helperA_4P_bool2(var7[0], var7[TRUE], var7[5], false)) {
                int dmg = this.calcAngle(var7[IDX_PATH], this.towerAtkSpeed, var7[IDX_LEVEL]);
                var7[TOWER_HP] = dmg;
                this.helperV_1P(var1);
            }
            break;
        case 8:
        case 9:
            // ========== 范围攻击+debuff ==========
            if (this.helperP_2P_bool(var7[IDX_PATH], var7[IDX_LEVEL])) {
                // 对范围内所有塔施加debuff
                for (int i = 0; i < this.activeTowerCount; i++) {
                    int[] tower = this.towerSlots[i];
                    if (this.helperA_5P_bool2(tower[0], tower[TRUE], x, y, attackRange)) {
                        if (isNotCommonTower(tower[8])) {
                            tower[15] = 48;  // 施加debuff
                        }
                    }
                }
            }
            // 然后直接攻击
            if (this.helperA_4P_bool2(var7[0], var7[TRUE], var7[5], true)) {
                int dmg = this.calcAngle(var7[IDX_PATH], this.towerAtkSpeed, var7[IDX_LEVEL]);
                var7[TOWER_HP] = dmg;
                this.helperV_1P(var1);
            }
            break;
    }

    return false;
}

// boolean e(int,int) — 瓦片==8检查 (VF L19613-19628)
private boolean isTileType8(int var1, int var2) {
    int var3 = this.calcTileIndex(var1, var2);
    return this.tileProperties[var3] == 8;
}

// void drawProgressBar() — ★ 进度条渲染 (VF L19628-19681)
//    非 v1 标注的 updateEffects!
private void drawProgressBar() {
    if (this.frameCounter > this.targetFrame) {
        int ratio = this.frameCounter / this.targetFrame;
        this.progressBarWidth = ratio > 10 ? 30 : 25;
        int x = 240 - this.progressBarWidth >> 1;
        this.graphicsCtx.setColor(16580557);
        this.graphicsCtx.setClip(0, 0, 240, 320);
        this.graphicsCtx.fillRect(x, 310, this.progressBarWidth, 10);
        // ... 进度条图标绘制 (VF L19628)
    }
}

// boolean drawProgressBar() — 初始化 (VF L20430-20438)
private boolean initGame() {
    this.loadRMS_sfSmsInfo();
    this.initCalendar();
    this.initialized = true;
    return true;
}

// boolean f(int,int) — 瓦片==10检查 (VF L20456-20471)
private boolean isTileType10(int var1, int var2) {
    int var3 = this.calcTileIndex(var1, var2);
    return this.tileProperties[var3] == 10;
}

// void handleVolume() — ★ 音量控制 (VF L20471-20518)
//    非 v1 标注的 updateEconomy!
private void handleVolume() {
    switch (this.keyState) {
        case -6:
        case -5:
        case 53:
            this.menuReturn();
            if (this.gameState == 1) {
                this.helperG_2P(7, -1);
            }
            break;
        case -4:
        case 54:
            this.volume += 20;
            if (this.volume > 100) this.volume = 100;
            this.isPausedInGame = true;
            this.volumeControl.setLevel(this.volume);
            break;
        // ... (VF L20471)
    }
}

// boolean handleVolume() — 网络上传 (VF L21114-21354)
private boolean uploadScore() {
    int var2 = this.getThreadState();
    switch (var2) {
        case -1:
            // ... (VF L21114)
        case 0:
            // ... 网络上传逻辑
    }
    return true;
}

// ============================================================================
// renderEndingText() handleVolumeInput() renderJ() initRandom() drawMap() handleMainMenu() updateScrollPos() 系列
// ============================================================================

// void renderEndingText() — 结局文字渲染 (VF L21381-21414)
private void renderEndingText() {
    this.graphicsCtx.setClip(0, 0, 240, 320);
    this.graphicsCtx.setColor(16777215);
    this.graphicsCtx.fillRect(0, 0, 240, 320);
    int var4 = this.gameTexts[104].length();
    var4 *= this.charWidth;
    var4 = 240 - var4 >> 1;
    int var5 = 320 - this.fontHeight >> 1;
    this.graphicsCtx.setColor(14834304);
    this.graphicsCtx.drawString(this.gameTexts[104], var4, var5, 0);
    // ... (VF L21381)
}

// void handleVolumeInput() — 输入处理 (VF L21989-22009)
private void handleVolumeInput() {
    switch (this.keyState) {
        case -7:
            this.isPausedInGame = false;
            this.gameState = 1;
            break;
        case -6:
        case -5:
            this.gameState = 1;
            this.isPausedInGame = true;
            this.volume = 60;
            this.helperG_2P(7, -1);
            break;
    }
}

// void renderJ() — 渲染 (VF L22265-22347)
private void renderJ() {
    this.graphicsCtx.setColor(16580557);
    // ... (VF L22265)
}

// void initRandom() — 初始化随机数 (VF L22470-22492)
private void initRandom() {
    this.updateLoadingProgress(0);
    this.random = new Random();
    this.random.setSeed(System.currentTimeMillis());
    this.isPaused = true;
    this.updateLoadingProgress(5);
    this.frameTimeStats = 0;
    this.soundEnabled = false;
    // ... (VF L22470)
}

// void drawMap() — 地图绘制 (VF L22601-22811)
//    约210行
private void drawMap() {
    this.graphicsCtx.setClip(0, 0, 240, 320);
    this.graphicsCtx.setColor(16777215);
    this.graphicsCtx.fillRect(0, 0, 240, 320);
    this.drawSpriteGrid(this.bgScrollOffset, 240);
    if (this.menuState != 0) {
        // ... 地图绘制逻辑 (VF L22601)
    }
}

// void l(int) — 更新塔逻辑 (VF L22811-22950)
private final void updateTowerLogic(int var1) {
    // ... (VF L22811)
}

// void handleMainMenu() — ★ 主菜单状态机 (VF L22984-23395)
//    ★ v11 修正: 更正标注 (原误标为"敌人移动状态机")
//    约411行,主菜单的初始化、动画和输入处理
//
//    状态(this.M):
//    - case 0: 初始化 (S=0, N=0, v=-26, x=416, M=1)
//    - case 1: 滚动等待 (N计数到20进入状态2, 计算图片位置)
//    - case 2: 图片滚动动画 (z递减, 到达O时进入状态3)
//    - case 3: 菜单动画 (复杂的菜单项位置计算和动画)
//    - case 4: 过渡 (N>2时进入状态3)
//    - case 5: 主菜单交互 (处理按键选择菜单项0-6)
//      * 菜单项: 0=新游戏, 1=继续, 2=设置, 3=读取, 4=?, 5=?, 6=?
//      * 左右键切换菜单项, 确认键执行
private void handleMainMenu() {
    switch (this.menuState) {
        case 0:
            this.tmpS = 0;
            this.tmpN = 0;
            this.scrollY = -26;
            this.posX = 416;
            this.menuState = 1;
            break;
        case 1:
            // ... (VF L22999-23019)
        // ... 其他case见 VF L22984-23395
    }
}

// void updateScrollPos() — ★ 滚动位置更新 (VF L23551-23591)
//    非 v1 标注的 drawTowers!
private void updateScrollPos() {
    this.scrollX -= 2;
    if (this.scrollX < -176) this.scrollX = 0;
    this.scrollY2 -= 2;
    if (this.scrollY2 < -176) this.scrollY2 = 0;
    // ... (VF L23551)
}

// ============================================================================
// stateMachineU() clearBackground() renderMenu() handleMenuInput() renderSavePanel() handleSaveLoad() handleFactionSelect() renderFactionSelect() renderSpecialMode() helperX() renderMap() updateEnemyMovement()
// ============================================================================

// void stateMachineU() — 状态机 (VF L23702-23725)
private void stateMachineU() {
    switch (this.stateMachineU) {
        case 0:
            this.posZ++;
            if (this.posZ > this.tmpO + 5) {
                this.stateMachineU = 1;
            }
            break;
        // ... (VF L23702)
    }
}

// void clearBackground() — ★ 背景清屏 (VF L23848-23859)
//    非 v1 标注的 drawHUD!
private void clearBackground() {
    this.graphicsCtx.setClip(0, 0, 240, 320);
    this.graphicsCtx.setColor(16580557);
    this.graphicsCtx.fillRect(0, 0, 240, 320);
    this.drawImageVariant5P_bool(this.spriteImages[3][3], 0, 0, 13450878, true);
}

// void renderMenu() — 菜单渲染 (VF L23981-24149)
private void renderMenu() {
    this.drawBg(this.screenWidth, 13);
    this.drawImageVariant5P_bool(this.spriteImages[3][3], 0, 0, 13450878, true);
    // ... (VF L23981)
}

// void handleMenuInput() — 输入处理 (VF L24345-24405)
private void handleMenuInput() {
    this.updateScrollPos();
    switch (this.keyState) {
        case -7:
            // ... (VF L24345)
    }
}

// void renderSavePanel() — 存档面板 (VF L24545-24631)
private void renderSavePanel() {
    this.drawBg(this.tileSize, 13);
    this.drawImageVariant5P_bool(this.spriteImages[3][4], 0, 0, 13450878, true);
    // ... (VF L24545)
}

// void handleSaveLoad() — 存档加载 (VF L24708-24925)
private void handleSaveLoad() {
    this.updateScrollPos();
    switch (this.saveSlot) {
        case 0:
            switch (this.keyState) {
                case -7:
                    this.gameState = 15;
                    return;
                // ... (VF L24708)
            }
    }
}

// void handleFactionSelect() — ★ 阵营选择状态机 (VF L25041-25232)
//    非 v1 标注的 uploadScore!
private void handleFactionSelect() {
    this.updateScrollPos();
    switch (this.keyState) {
        case -7:
            if (!this.flagT1089) {
                this.generalIdxO = 0;
                this.generalIdxN = 0;
                this.gameState = 17;
            }
            break;
        // ... (VF L25041)
    }
}

// void renderFactionSelect() — ★ 阵营选择渲染 (VF L25285-25469)
//    非 v1 标注的 controlAudio!
private void renderFactionSelect() {
    this.drawBg(this.mapRows, 13);
    this.drawImageVariant5P_bool(this.spriteImages[3][3], 0, 0, 13450878, true);
    this.graphicsCtx.setColor(15455661);
    this.graphicsCtx.fillRect(0, 320 - this.mapRows - 10, 240, this.mapRows);
    // ... (VF L25285)
}

// void renderSpecialMode() — 特殊模式渲染 (VF L25793-25959)
private final void renderSpecialMode() {
    this.loadSprite(2);
    // ... (VF L25793)
}

// void helperX() — (VF L26145-26182)
private void helperX() {
    this.loadSprite(1);
    // ... (VF L26145)
}

// void renderMap() — 地图渲染 (VF L26190-26281)
private void renderMap() {
    this.graphicsCtx.setColor(16777215);
    this.graphicsCtx.fillRect(0, 0, 240, 320);
    int var7 = 0;
    while (var7 < this.mapLayerCount) {
        // ... 遍历地图层渲染 (VF L26190)
        var7++;
    }
}

// void updateEnemyMovement() — ★★ 敌人移动更新 (VF L26684-26857)
//    ★ v11 修正: 完整恢复 (原为部分实现)
//    约173行,敌人移动核心逻辑
//
//    数据结构 mapLayerData[i]:
//    - [0] = x坐标
//    - [1] = y坐标
//    - [2] = 移动模式 (1-4) / 剩余步数
//    - [3] = 步数 (case 1,3) / 移动模式相关
//    - [4] = x速度/目标x
//    - [5] = y速度/目标y/方向
//
//    移动模式:
//    - case 1: 直线插值 — 从当前位置插值移动到目标位置
//    - case 2: 倒计时 — 递减计数器
//    - case 3: 路径移动 — 插值移动+方向计算+步数完成后设置速度
//    - case 4: 方向移动 — 4方向循环移动 (0=左下,1=左上,2=右上,3=右下)
private void updateEnemyMovement() {
    byte IDX_Y_SPD = 5;
    byte IDX_STEPS = 3;
    byte IDX_Y = 1;
    byte IDX_X_SPD = 4;

    for (int i = this.mapLayerCount - 1; i >= 0; i--) {
        int[] var6 = this.mapLayerData[i];
        int mode = var6[2];
        switch (mode) {
            case 1:
                // ========== 直线插值移动 ==========
                if (var6[IDX_STEPS] > 0) {
                    // x += (目标x - x) / 步数
                    int dx = (var6[IDX_X_SPD] - var6[0]) / var6[IDX_STEPS];
                    var6[0] += dx;
                    // y += (目标y - y) / 步数
                    int dy = (var6[IDX_Y_SPD] - var6[IDX_Y]) / var6[IDX_STEPS];
                    var6[IDX_Y] += dy;
                    var6[IDX_STEPS]--;  // 步数-1
                }
                break;
            case 2:
                // ========== 倒计时 ==========
                if (var6[IDX_X_SPD] > 1) {
                    var6[IDX_X_SPD]--;
                }
                break;
            case 3:
                // ========== 路径移动 (插值+方向) ==========
                if (var6[IDX_STEPS] > 0) {
                    // 计算x速度: (目标x - x) / 步数
                    int vx = (var6[IDX_X_SPD] - var6[0]) / var6[IDX_STEPS];
                    // 计算y速度: (目标y - y) / 步数
                    int vy = (var6[IDX_Y_SPD] - var6[IDX_Y]) / var6[IDX_STEPS];
                    var6[0] += vx;
                    var6[IDX_Y] += vy;
                    var6[IDX_STEPS]--;
                    // 步数用完时,设置剩余速度方向
                    if (var6[IDX_STEPS] == 0) {
                        // 设置x方向速度 (8/-8/0)
                        var6[IDX_X_SPD] = vx > 0 ? 8 : (vx < 0 ? -8 : 0);
                        // 设置y方向速度 (8/-8/0)
                        var6[IDX_Y_SPD] = vy > 0 ? 8 : (vy < 0 ? -8 : 0);
                    }
                } else {
                    // 步数<=0: 使用速度移动
                    if (var6[IDX_X_SPD] == 0) {
                        // x速度为0,根据步数状态移动
                        switch (var6[IDX_STEPS]) {
                            case -3:
                            case 0:
                                // 正向移动
                                var6[0] += var6[IDX_X_SPD];
                                var6[IDX_Y] += var6[IDX_Y_SPD];
                                break;
                            case -2:
                                // 速度减半 (fall through to -1)
                                var6[IDX_X_SPD] >>= 1;
                                var6[IDX_Y_SPD] >>= 1;
                                // fall through!
                            case -1:
                                // 反向移动
                                var6[0] -= var6[IDX_X_SPD];
                                var6[IDX_Y] -= var6[IDX_Y_SPD];
                                break;
                        }
                        var6[IDX_STEPS]--;
                    }
                }
                break;
            case 4:
                // ========== 方向移动 (4方向循环) ==========
                if (var6[IDX_STEPS] > 0) {
                    // 根据方向(var6[5])进行4方向移动
                    switch (var6[IDX_Y_SPD]) {
                        case 0:  // 左下
                            var6[0] -= var6[IDX_X_SPD];
                            var6[IDX_Y] += var6[IDX_X_SPD];
                            break;
                        case 1:  // 左上
                            var6[0] -= var6[IDX_X_SPD];
                            var6[IDX_Y] -= var6[IDX_X_SPD];
                            break;
                        case 2:  // 右上
                            var6[0] += var6[IDX_X_SPD];
                            var6[IDX_Y] -= var6[IDX_X_SPD];
                            break;
                        case 3:  // 右下
                            var6[0] += var6[IDX_X_SPD];
                            var6[IDX_Y] += var6[IDX_X_SPD];
                            break;
                    }
                    // 方向+1
                    var6[IDX_Y_SPD]++;
                    // 方向循环: >=4时重置为0,步数-1
                    if (var6[IDX_Y_SPD] >= 4) {
                        var6[IDX_Y_SPD] = 0;
                        var6[IDX_STEPS]--;
                    }
                }
                break;
        }
    }
}
