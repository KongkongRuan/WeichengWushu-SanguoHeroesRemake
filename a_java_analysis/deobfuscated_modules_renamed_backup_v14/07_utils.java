/**
 * ============================================================================
 *  模块 07: 工具方法 (静态方法 + 带参数重载)
 * ============================================================================
 *
 *  原始类: a extends FullCanvas implements Runnable
 *  本模块包含: 带参数的工具方法、静态方法、渲染辅助方法
 *
 *  交叉验证: Vineflower 主源
 *  可靠性: ★★★★☆
 * ============================================================================
 */

// ============================================================================
// 静态工具方法
// ============================================================================

// a(int[]) — 数组排序/处理 (VF L12007-12049)
//    静态方法, 处理 activeTowerIndices 和 towerSlots 数据
private static void updateTowerArray(int[] var0, int[][] var1, int var2, int var3) {
    // ... (VF L12007)
}

// a(int) — 静态奇偶检查 (VF L13099-13108)
//    ★ v10 修正: 完整恢复 (原为空存根)
//    检查 var0 最低位是否为1 (奇数检查)
private static boolean isOdd(int var0) {
    return (var0 & 1) != 0;
}

// b(int,int,int,int) — ★ 静态距离平方计算 (VF L15913-15921)
//    ★ v10 修正: 完整恢复 (原为空存根)
//    公式: (var2-var0)^2 + (var3-var1)^2
//    用于计算两点之间的距离平方 (避免开方运算)
private static int distanceSq(int var0, int var1, int var2, int var3) {
    int dx = var2 - var0;
    int dx2 = dx * dx;
    int dy = var3 - var1;
    int dy2 = dy * dy;
    return dx2 + dy2;
}

// b(String) — 静态字符串处理 (VF L16351-16410)
private static void handleStringStatic(String var0) {
    // ... (VF L16351)
}

// c(int) — ★ 静态方向计算 (VF L16902-16922)
//    ★ v10 修正: 完整恢复 (原为空存根)
//    根据角度返回方向代码:
//    - 315-359° → 0 (右上)
//    - 45-134° → 2 (右下)
//    - 135-224° → 3 (左下)
//    - 其他 (0-44°, 225-314°) → 1 (左上)
private static int calcDirection(int var0) {
    short var1 = 225;
    short var2 = 135;
    short var3 = 45;
    if (var0 >= var3 && var0 < var2) {
        return 2;   // 45-134°
    } else if (var0 >= var2 && var0 < var1) {
        return 3;   // 135-224°
    } else {
        if (var0 >= var1) {
            int var315 = 315;
            if (var0 < var315) {
                return 0;   // 225-314° (注意: 这里的逻辑, var3被重用为315)
            }
        }
        return 1;   // 其他 (0-44°, 315-359°)
    }
}

// calcBaseHp(int,int,int) — ★★ 静态HP基础计算 (VF L18663-18665)
//    ★ v10 修正: 完整恢复 (原为空存根)
//    这是 a(int,byte[],int) HP计算方法的基础依赖!
//    公式: return var1 * var2 + var0
//    用于从byte[]数组中的hi,lo字节和等级计算基础HP值
private static int calcBaseHp(int var0, int var1, int var2) {
    return var1 * var2 + var0;
}

// e(int) — ★★ 静态hex字符解码 (VF L19228-19255)
//    ★ v10 修正: 完整恢复 (原为空存根)
//    这是 d() HTTP通信方法中hex解码的关键依赖!
//
//    解码规则:
//    - '0'-'9' (48-57) → 0-9
//    - 'a'-'z' (97-122) → 10-35
//    - 'A'-'Z' (65-90) → 10-35
//    - 其他 → 抛出 Exception
private static final int hexCharToInt(int var0) {
    byte var1 = 97;   // 'a'
    byte var2 = 65;   // 'A'
    byte var3 = 48;   // '0'
    if (var0 >= var3) {
        byte var4 = 57;  // '9'
        if (var0 <= var4) {
            return var0 - var3;  // '0'-'9' → 0-9
        }
    }
    if (var0 >= var1) {
        byte var6 = 122;  // 'z'
        if (var0 <= var6) {
            return var0 - var1 + 10;  // 'a'-'z' → 10-35
        }
    }
    if (var0 >= var2) {
        byte var7 = 90;  // 'Z'
        if (var0 <= var7) {
            return var0 - var2 + 10;  // 'A'-'Z' → 10-35
        }
    }
    throw new Exception();  // 非法字符
}

// f(int) — 静态非防御塔类型检查 (VF L20438-20453)
//    ★ v10 修正: 完整恢复 (原为空存根)
//    检查 var0 是否不是常见防御塔类型 (5,6,8,4)
//    返回 true 表示 var0 不是这四种类型
private static boolean isNotCommonTower(int var0) {
    if (var0 != 5 && var0 != 6 && var0 != 8 && var0 != 4) {
        return true;
    }
    return false;
}

// g(int) — 静态类型6检查 (VF L21354-21363)
//    ★ v10 修正: 完整恢复 (原为空存根)
//    检查 var0 是否等于6
private static boolean isType6(int var0) {
    return var0 == 6;
}

// ============================================================================
// 渲染辅助方法
// ============================================================================

// a(String) — 滚动文字渲染 (VF L11087-11092)
//    ★ v2 修正: 补充遗漏的 a(var1, c, 27, 18, 186, 292) 调用
private void renderScrollText(String var1) {
    this.clearScreen();
    this.graphicsCtx.setColor(7438477);
    int var2 = this.cursorX;
    this.a(var1, var2, 27, 18, 186, 292);  // 调用文字面板绘制
}

// a(String,int,int) — (VF L11094-11110)
private void helperA_Str2P(String var1, int var2, int var3) {
    // ... (VF L11094)
}

// a(String,int,int,int,int,int) — 文字面板绘制 (VF L11110-11150)
private final void drawTextPanel(String var1, int var2, int var3, int var4, int var5, int var6) {
    char[] chars = var1.toCharArray();
    int len = chars.length;
    boolean needScroll = false;
    if (this.cursorY != len || (len > 10 && !var1.substring(0, 10).equals(this.scrollTextCache))) {
        needScroll = true;
    }
    if (needScroll && len > 10) {
        this.scrollTextCache = var1.substring(0, 10);
    }
    this.a(chars, len, var2, var3, var4, var5, var6, needScroll);
}

// a(char[],int,int,int,int,int,int,boolean) — 字符渲染 (VF L11784-12007)
//    约223行,核心文字渲染方法
private final void renderChars(char[] var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
    // ... 完整见 VF L11784
}

// a(Image,int,int,int) — 旋转绘制图片 (VF L11150-11156)
//    rotation: 0=正常,1=90°,2=180°,3=270°,4=水平翻转,5=垂直翻转,6=对角1,7=对角2
private void drawImageRotation(Image var1, int var2, int var3, int var4) {
    this.directGraphics.drawImage(var1, var2, var3, 0, ROTATION_PARAMS[var4]);
}

// a(Image,int,int,int,int) — 平铺绘制 (VF L11156-11170)
private void drawImageTiled(Image var1, int var2, int var3, int var4, int var5) {
    this.graphicsCtx.setClip(0, 0, 240, 320);
    int imgW = var1.getWidth();
    int imgH = var1.getHeight();
    this.graphicsCtx.drawImage(var1, var2, var3, 0);
    this.a(var1, var2 + var4 - imgW, var3, 1);           // 水平翻转
    this.a(var1, var2, var3 + var5 - imgH, 2);            // 垂直翻转
    this.a(var1, var2 + var4 - imgW, var3 + var5 - imgH, 3); // 180°
}

// a(Image,int,int,int,int,int) — (VF L11170-11202)
private void drawImageVariant6P(Image var1, int var2, int var3, int var4, int var5, int var6) {
    // ... (VF L11170)
}

// a(Image,int,int,int,int,int,int) — (VF L11202-11211)
private void drawImageVariant7P(Image var1, int var2, int var3, int var4, int var5, int var6, int var7) {
    // ... (VF L11202)
}

// a(Image,int,int,int,int,int,int,int) — (VF L11211-11291)
private void drawImageVariant8P(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
    // ... (VF L11211)
}

// a(Image,...,9参数) — (VF L11291-11334)
private void drawImageVariant9P(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
    // ... (VF L11291)
}

// a(Image,...,10参数) — (VF L11334-11470)
private void drawImageVariant10P(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
    // ... (VF L11334)
}

// a(Image,int,int,int,boolean) — (VF L11470-11485)
private void drawImageVariant5P_bool(Image var1, int var2, int var3, int var4, boolean var5) {
    // ... (VF L11470)
}

// a(Image,Image,int,int,int,int,int) — (VF L11485-11632)
private void drawImage2Imgs7P(Image var1, Image var2, int var3, int var4, int var5, int var6, int var7) {
    // ... (VF L11485)
}

// a(Image,Image,Image,int,int,int,int) — (VF L11632-11675)
private void drawImage3Imgs7P(Image var1, Image var2, Image var3, int var4, int var5, int var6, int var7) {
    // ... (VF L11632)
}

// a(boolean) — 帮助页渲染 (VF L11675-11772)
private void renderHelpPage(boolean var1) {
    // ... (VF L11675)
}

// a(byte[]) — (VF L11772-11784)
private void helperA_byteArr(byte[] var1) {
    // ... (VF L11772)
}

// ============================================================================
// 带参数的状态更新方法
// ============================================================================

// a(int,int) — (VF L10482) [注意: 与精灵图加载a(int,int)不同重载]
// 实际VF中 a(int,int) 只有一个,此处需确认

// a(int,int,int) — (VF L10482-10490)
// 已在上方声明

// b(int,int) — 背景绘制 (VF L15961-15989)
private void drawBg(int var1, int var2) {
    this.graphicsCtx.setClip(0, 0, 240, 320);
    // ... (VF L15961)
}

// b(int,int,int) — (VF L15989-16046)
private final void helperB_3P_void(int var1, int var2, int var3) {
    // ... (VF L15989)
}

// b(Image,int,int,int) — (VF L16410-16447)
private void drawImageVariantB4P(Image var1, int var2, int var3, int var4) {
    // ... (VF L16410)
}

// b(Image,int,int,int,int) — (VF L16447-16479)
private void drawImageVariantB5P(Image var1, int var2, int var3, int var4, int var5) {
    // ... (VF L16447)
}

// b(Image,...,9参数) — (VF L16479-16602)
private void b(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
    // ... (VF L16479)
}

// b(int,int,int,int,boolean) — (VF L16316-16351)
private void helperB_5P_bool(int var1, int var2, int var3, int var4, boolean var5) {
    // ... (VF L16316)
}

// c(int) — (VF L16985) [注意: 与精灵图加载c(int)同]
// c(int,int) — (VF L17192-17241)
private void drawSpriteRow(int var1, int var2) {
    // ... (VF L17192)
}

// c(int,int,int) — (VF L17241-17252)
private void helperC_3P_void(int var1, int var2, int var3) {
    // ... (VF L17241)
}

// c(int,int,int,int) — (VF L17252-17288)
private void helperC_4P(int var1, int var2, int var3, int var4) {
    // ... (VF L17252)
}

// c(int,int,int,int,int) — (VF L17288-17379)
private void helperC_5P(int var1, int var2, int var3, int var4, int var5) {
    // ... (VF L17288)
}

// c(int,int,int,int,int,int) — (VF L17379-17598)
private void helperC_6P(int var1, int var2, int var3, int var4, int var5, int var6) {
    // ... (VF L17379)
}

// c(int,int,int,int,boolean) — (VF L17598-17673)
private final void helperC_5P_bool(int var1, int var2, int var3, int var4, boolean var5) {
    // ... (VF L17598)
}

// c(String) — 设备适配 (VF L17673-17689)
private void adaptDevice(String var1) {
    // ... (VF L17673)
}

// c(Image,int,int,int) — (VF L17689-17696)
private void drawImageVariantC4P(Image var1, int var2, int var3, int var4) {
    // ... (VF L17689)
}

// d(int,int) — (VF L18719-18758)
private void drawSpriteBottom(int var1, int var2) {
    // ... (VF L18719)
}

// calcBaseHp(int,int,int) — (VF L18758-18772)
private void calcBaseHp(int var1, int var2, int var3) {
    // ... (VF L18758)
}

// calcBaseHp(int,int,int,int) — (VF L18772-18876)
private void calcBaseHp(int var1, int var2, int var3, int var4) {
    // ... (VF L18772)
}

// calcBaseHp(int,int,int,int,int) — (VF L18876-18882)
private void calcBaseHp(int var1, int var2, int var3, int var4, int var5) {
    // ... (VF L18876)
}

// calcBaseHp(int,int,int,int,int,int) — (VF L18882-18997)
private void calcBaseHp(int var1, int var2, int var3, int var4, int var5, int var6) {
    // ... (VF L18882)
}

// calcBaseHp(Image,int,int,int) — (VF L18997-19041)
private void calcBaseHp(Image var1, int var2, int var3, int var4) {
    // ... (VF L18997)
}

// e(int) — (VF L19264-19287)
private final void updateLoadingProgress(int var1) {
    while (true) {
        if (this.loadingPercent >= var1) {
            if (this.loadingPercent == 100) {
                this.sceneMode = false;
                this.loadingPercent = 0;
            }
            return;
        }
        this.loadingPercent++;
        // ... (VF L19264)
    }
}

// e(int,int) — (VF L19287-19314)
private void drawSpriteGrid(int var1, int var2) {
    // ... (VF L19287)
}

// e(int,int,int) — (VF L19314-19320)
private void helperE_3P(int var1, int var2, int var3) {
    // ... (VF L19314)
}

// e(int,int,int,int) — (VF L19320-19357)
private void helperE_4P(int var1, int var2, int var3, int var4) {
    // ... (VF L19320)
}

// e(int,int,int,int,int) — (VF L19357-19379)
private void helperE_5P(int var1, int var2, int var3, int var4, int var5) {
    // ... (VF L19357)
}

// e(Image,int,int,int) — (VF L19379-19432)
private void drawImageVariantE4P(Image var1, int var2, int var3, int var4) {
    // ... (VF L19379)
}

// f(int) — (VF L19681-19715)
private void helperF_1P(int var1) {
    // ... (VF L19681)
}

// f(int,int) — (VF L19715-20071)
private void helperF_2P(int var1, int var2) {
    // ... (VF L19715)
}

// f(int,int,int) — (VF L20071-20267)
private void helperF_3P(int var1, int var2, int var3) {
    // ... (VF L20071)
}

// f(int,int,int,int) — (VF L20267-20357)
private void helperF_4P(int var1, int var2, int var3, int var4) {
    // ... (VF L20267)
}

// f(int,int,int,int,int) — (VF L20357-20420)
private final void helperF_5P(int var1, int var2, int var3, int var4, int var5) {
    // ... (VF L20357)
}

// f(Image,int,int,int) — (VF L20420-20430)
private void drawImageVariantF4P(Image var1, int var2, int var3, int var4) {
    // ... (VF L20420)
}

// g(int) — (VF L20518-20808)
private void helperG_1P(int var1) {
    // ... (VF L20518)
}

// g(int,int) — (VF L20808-21002)
private void helperG_2P(int var1, int var2) {
    // ... (VF L20808)
}

// g(int,int,int) — (VF L21002-21008)
private void helperG_3P(int var1, int var2, int var3) {
    // ... (VF L21002)
}

// g(int,int,int,int) — (VF L21008-21087)
private void helperG_4P(int var1, int var2, int var3, int var4) {
    // ... (VF L21008)
}

// g(int,int,int,int,int) — (VF L21087-21114)
private void helperG_5P(int var1, int var2, int var3, int var4, int var5) {
    // ... (VF L21087)
}

// g(int,int) — 布尔返回 (VF L21366-21381)
private boolean helperG_2P_bool(int var1, int var2) {
    // ... (VF L21366)
    return false;
}

// h(int) — (VF L21414-21515)
private void helperH_1P(int var1) {
    // ... (VF L21414)
}

// h(int,int) — (VF L21515-21715)
private void renderGameState22(int var1, int var2) {
    // ... (VF L21515)
}

// h(int,int,int) — (VF L21715-21750)
private void helperH_3P(int var1, int var2, int var3) {
    // ... (VF L21715)
}

// h(int,int,int,int) — (VF L21750-21857)
private void helperH_4P(int var1, int var2, int var3, int var4) {
    // ... (VF L21750)
}

// h(int,int,int,int,int) — (VF L21857-21952)
private void helperH_5P(int var1, int var2, int var3, int var4, int var5) {
    // ... (VF L21857)
}

// h(int) — 布尔返回 (VF L21952-21964)
private boolean randomLessThan(int var1) {
    return (this.randomByte() & 7) > var1;
}

// h(int,int) — 布尔返回 (VF L21964-21989)
private boolean helperH_2P_bool(int var1, int var2) {
    if (var1 > 0) {
        // ... (VF L21964)
    }
    return false;
}

// i(int) — (VF L22009-22068)
private void controlMidiPlayer(int var1) {
    // MIDI播放器控制 (VF L22009)
}

// i(int,int) — (VF L22068-22107)
private void helperI_2P(int var1, int var2) {
    // ... (VF L22068)
}

// i(int,int,int) — (VF L22107-22126)
private void helperI_3P(int var1, int var2, int var3) {
    // ... (VF L22107)
}

// i(int,int,int,int) — (VF L22126-22219)
private void helperI_4P(int var1, int var2, int var3, int var4) {
    // ... (VF L22126)
}

// i(int) — 布尔返回 (VF L22219-22243)
private boolean helperI_1P_bool(int var1) {
    for (int i = 0; i < 5; i++) {
        byte[] var4 = this.levelDataC[var1];
        // ... (VF L22219)
    }
    return true;
}

// i(int,int) — 布尔返回 (VF L22243-22265)
private boolean helperI_2P_bool(int var1, int var2) {
    // ... (VF L22243)
    return false;
}

// j(int) — (VF L22347-22371)
private void helperJ_1P(int var1) {
    // ... (VF L22347)
}

// j(int,int) — (VF L22371-22413)
private void helperJ_2P(int var1, int var2) {
    // ... (VF L22371)
}

// j(int,int,int) — (VF L22413-22439)
private void helperJ_3P(int var1, int var2, int var3) {
    // ... (VF L22413)
}

// j(int) — 布尔返回 (VF L22439-22453)
private boolean helperJ_1P_bool(int var1) {
    // ... (VF L22439)
    return false;
}

// j(int,int) — 布尔返回 (VF L22453-22470)
private boolean helperJ_2P_bool(int var1, int var2) {
    // ... (VF L22453)
    return false;
}

// k(int) — (VF L22492-22538)
private void helperK_1P(int var1) {
    // ... (VF L22492)
}

// k(int,int) — (VF L22538-22570)
private void helperK_2P(int var1, int var2) {
    // ... (VF L22538)
}

// k(int,int,int) — (VF L22570-22585)
private void helperK_3P(int var1, int var2, int var3) {
    // ... (VF L22570)
}

// k(int,int) — 布尔返回 (VF L22585-22601)
private boolean helperK_2P_bool(int var1, int var2) {
    // ... (VF L22585)
    return false;
}

// l(int,int) — (VF L22950-22958)
private void helperL_2P(int var1, int var2) {
    // ... (VF L22950)
}

// l(int,int,int) — (VF L22958-22967)
private void helperL_3P(int var1, int var2, int var3) {
    // ... (VF L22958)
}

// l(int,int) — 布尔返回 (VF L22967-22984)
private boolean helperL_2P_bool(int var1, int var2) {
    // ... (VF L22967)
    return false;
}

// m(int) — (VF L23397-23416)
private void helperM_1P(int var1) {
    // ... (VF L23397)
}

// m(int,int) — (VF L23416-23458)
private void helperM_2P(int var1, int var2) {
    // ... (VF L23416)
}

// m(int,int,int) — (VF L23458-23535)
private void helperM_3P(int var1, int var2, int var3) {
    // ... (VF L23458)
}

// m(int,int) — 布尔返回 (VF L23535-23551)
private boolean helperM_2P_bool(int var1, int var2) {
    // ... (VF L23535)
    return false;
}

// n(int) — (VF L23591-23611)
private final void helperN_1P(int var1) {
    // ... (VF L23591)
}

// n(int,int) — (VF L23611-23640)
private void helperN_2P(int var1, int var2) {
    // ... (VF L23611)
}

// n(int,int,int) — (VF L23640-23685)
private void helperN_3P(int var1, int var2, int var3) {
    // ... (VF L23640)
}

// n(int,int) — 布尔返回 (VF L23685-23702)
private boolean helperN_2P_bool(int var1, int var2) {
    // ... (VF L23685)
    return false;
}

// o(int) — (VF L23725-23768)
private void helperO_1P(int var1) {
    // ... (VF L23725)
}

// o(int,int) — (VF L23768-23806)
private void helperO_2P(int var1, int var2) {
    // ... (VF L23768)
}

// o(int,int,int) — (VF L23806-23832)
private void helperO_3P(int var1, int var2, int var3) {
    // ... (VF L23806)
}

// o(int,int) — 布尔返回 (VF L23832-23848)
private boolean helperO_2P_bool(int var1, int var2) {
    // ... (VF L23832)
    return false;
}

// p(int) — (VF L23859-23898)
private void helperP_1P(int var1) {
    // ... (VF L23859)
}

// p(int,int) — (VF L23898-23940)
private void helperP_2P(int var1, int var2) {
    // ... (VF L23898)
}

// p(int,int,int) — (VF L23940-23964)
private void helperP_3P(int var1, int var2, int var3) {
    // ... (VF L23940)
}

// p(int,int) — 布尔返回 (VF L23964-23981)
private boolean helperP_2P_bool(int var1, int var2) {
    // ... (VF L23964)
    return false;
}

// q(int) — (VF L24149-24225)
private void helperQ_1P(int var1) {
    // ... (VF L24149)
}

// q(int,int) — (VF L24225-24321)
private void helperQ_2P(int var1, int var2) {
    // ... (VF L24225)
}

// q(int,int,int) — (VF L24321-24329)
private void helperQ_3P(int var1, int var2, int var3) {
    // ... (VF L24321)
}

// q(int,int) — 布尔返回 (VF L24329-24345)
private boolean helperQ_2P_bool(int var1, int var2) {
    // ... (VF L24329)
    return false;
}

// r(int) — (VF L24405-24522)
private void helperR_1P(int var1) {
    // ... (VF L24405)
}

// r(int,int,int) — (VF L24522-24545)
private void helperR_3P(int var1, int var2, int var3) {
    // ... (VF L24522)
}

// s(int) — (VF L24631-24703)
private void helperS_1P(int var1) {
    // ... (VF L24631)
}

// s(int,int,int) — (VF L24703-24708)
private void helperS_3P(int var1, int var2, int var3) {
    // ... (VF L24703)
}

// t(int) — (VF L24925-25020)
private void helperT_1P(int var1) {
    // ... (VF L24925)
}

// t(int,int,int) — (VF L25020-25041)
private void helperT_3P(int var1, int var2, int var3) {
    // ... (VF L25020)
}

// u(int) — (VF L25232-25238)
private void helperU_1P(int var1) {
    // ... (VF L25232)
}

// u(int,int,int) — (VF L25238-25285)
private void helperU_3P(int var1, int var2, int var3) {
    // ... (VF L25238)
}

// v(int) — (VF L25469-25478)
private void helperV_1P(int var1) {
    // ... (VF L25469)
}

// v(int,int,int) — (VF L25478-25793)
private void helperV_3P(int var1, int var2, int var3) {
    // ... (VF L25478)
}

// w(int) — (VF L25823-25959)
private void helperW_1P(int var1) {
    // ... (VF L25823)
}

// w(int,int,int) — (VF L25959-26145)
private void helperW_3P(int var1, int var2, int var3) {
    // ... (VF L25959)
}

// x(int) — (VF L26182-26190)
private void helperX_1P(int var1) {
    // ... (VF L26182)
}

// y(int) — (VF L26281-26684)
private void helperY_1P(int var1) {
    // ... (VF L26281)
}

// z(int) — (VF L26859-27115)
private void helperZ_1P(int var1) {
    // ... (VF L26859)
}
