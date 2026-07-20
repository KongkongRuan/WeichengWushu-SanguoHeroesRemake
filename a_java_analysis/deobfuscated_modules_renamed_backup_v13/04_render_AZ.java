/**
 * ============================================================================
 *  模块 04: A-Z 渲染方法
 * ============================================================================
 *
 *  原始类: a extends FullCanvas implements Runnable
 *  本模块包含: 26个无参数 A-Z 方法 + 部分带参数重载
 *
 *  交叉验证: Vineflower 主源 (L4741-9993)
 *  可靠性: ★★★★☆
 *
 *  ★ v1 版本重大错误修正:
 *    - saveRMS_sanGuoTd() 不是渲染方法, 是 RMS 存档保存
 *    - loadRMS_sanGuoTdData() 不是渲染方法, 是 RMS 存档读取
 *    - loadRMS_freeGame() 不是渲染方法, 是 RMS 存档读取
 *    - updateMainFrame() 不是渲染帮助, 是主帧更新逻辑
 *    - updateGameState() 不是渲染结束, 是游戏状态更新
 *    - updateGameFrame() 不是渲染精灵, 是主游戏帧更新
 * ============================================================================
 */

// ============================================================================
// dispatchRender() — 渲染分发器 (VF L4741-4917)
//    private void dispatchRender()
//
//    根据 sceneMode(场景模式) 和 l(游戏状态) 分发到对应渲染方法:
//    sceneMode!=0: 调用 renderSpecialMode() (特殊模式)
//
//    l(状态)分发:
//    - 0/19: 调用 renderMap() (地图加载) 或绘制logo
//    - 1: 调用 drawMap() (主游戏世界渲染)
//    - 2: renderAK_block297()+renderGameWorld()+renderAG_block298()+helperAM()+drawScrollAndBg()+renderOverlay()+c(2,0)
//    - 3: renderAK_block297()+renderGameWorld()+renderAG_block298()+drawScrollAndBg()+renderJ()+c(3,-1)
//    - 4/20: a(gameTexts[1])+c(-1,1) (版权文本)
//    - 5/21: a(gameTexts[0])+c(-1,1) (说明文本)
//    - 8: a(true)+c(3,-1) (帮助页1)
//    - 9: a(false)+c(3,-1) (帮助页2)
//    - 10: drawMainMap()+背景绘制+c(3,-1) (主游戏)
//    - 12: renderAK_block297()+renderGameWorld()+renderAG_block298()+drawScrollAndBg()+c(3,1) (科技树)
//    - 13/14: renderAK_block297()+renderGameWorld()+renderAG_block298()+helperAM()+drawScrollAndBg()+c(3,1) (关卡列表)
//    - 15: renderMenu()+c(3,3) (菜单)
//    - 16: renderFactionSelect()+c(3,3)或c(3,-1) (阵营选择)
//    - 17: renderSavePanel()+c(3,3) (存档面板)
//    - 18: renderEndingText() (结局)
//    - 22: renderAK_block297()+renderGameWorld()+renderAG_block298()+helperAM()+renderGeneralSelect()+drawScrollAndBg()+c(3,-1) (武将选择)
//    - 23: renderAK_block297()+helperAM()+helperAC()+drawScrollAndBg()+c(3,-1) (阵营选择)
//    - 24: renderAK_block297()+renderGameWorld()+renderAG_block298()+drawScrollAndBg()+renderDifficulty()+c(3,1) (难度选择)
//    - 46/47/48: renderEndingAnim() (结局动画)
// ============================================================================
private void dispatchRender() {
    int var2 = 1;
    byte var3 = -1;
    byte var4 = 2;
    int var5 = this.sceneMode;
    if (var5) {
        this.renderSpecialMode();
    } else {
        var5 = this.l;
        switch (var5) {
            case 0:
                // 检查 al==2 则调用 renderMap();否则绘制logo
                var5 = this.al;
                if (var5 == var4) {
                    this.renderMap();
                } else {
                    Image logo = this.logoImage;
                    if (logo != null) {
                        this.graphicsCtx.setClip(0, 0, 240, 320);
                        this.graphicsCtx.setColor(16777215);
                        this.graphicsCtx.fillRect(0, 0, 240, 320);
                        int x = 240 - logo.getWidth() >> 1;
                        int y = 320 - logo.getHeight() >> 1;
                        this.graphicsCtx.drawImage(logo, x, y, 0);
                    }
                }
                break;
            case 19:
                this.renderMap();
                break;
            case 1:
                this.drawMap();
                break;
            case 2:
                this.renderAK_block297(); this.renderGameWorld(); this.renderAG_block298(); this.helperAM();
                this.drawScrollAndBg(); this.renderOverlay(); this.c(var4, 0);
                break;
            case 3:
                this.renderAK_block297(); this.renderGameWorld(); this.renderAG_block298(); this.drawScrollAndBg();
                this.renderJ(); this.c(var4, var3);
                break;
            case 4:
            case 20:
                this.a(this.gameTexts[var2]);
                if (this.l == 20) {
                    int x = 240 - this.spriteImages[4][25].getWidth() >> 1;
                    this.c(5, x, 0);
                }
                this.c(var3, var2);
                break;
            case 5:
            case 21:
                this.a(this.gameTexts[0]);
                if (this.l == 21) {
                    int x = 240 - this.spriteImages[4][25].getWidth() >> 1;
                    this.c(4, x, 0);
                }
                this.c(var3, var2);
                break;
            case 8:
                this.a(true);
                this.c(var4, var3);
                break;
            case 9:
                this.a(false);
                this.c(var4, var3);
                break;
            case 10:
                this.drawMainMap();
                this.a(this.spriteImages[3][3], 0, 0, 13450878, true);
                this.c(var4, var3);
                break;
            case 12:
                this.renderAK_block297(); this.renderGameWorld(); this.renderAG_block298(); this.drawScrollAndBg();
                this.c(var4, var2);
                break;
            case 13:
            case 14:
                this.renderAK_block297(); this.renderGameWorld(); this.renderAG_block298(); this.helperAM(); this.drawScrollAndBg();
                this.c(var4, var2);
                break;
            case 15:
                this.renderMenu();
                this.c(var4, 3);
                break;
            case 16:
                this.renderFactionSelect();
                if (!this.flagT1089) {
                    this.c(var4, 3);
                } else {
                    this.c(var4, var3);
                }
                break;
            case 17:
                this.renderSavePanel();
                this.c(var4, 3);
                break;
            case 18:
                this.renderEndingText();
                break;
            case 22:
                this.renderAK_block297(); this.renderGameWorld(); this.renderAG_block298(); this.helperAM();
                this.renderGeneralSelect(); this.drawScrollAndBg();
                this.c(var4, var3);
                break;
            case 23:
                this.renderAK_block297(); this.helperAM(); this.helperAC(); this.drawScrollAndBg();
                this.c(var4, var3);
                break;
            case 24:
                this.renderAK_block297(); this.renderGameWorld(); this.renderAG_block298(); this.drawScrollAndBg();
                this.renderDifficulty();
                this.c(var4, var2);
                break;
            case 46:
            case 47:
            case 48:
                this.renderEndingAnim();
                break;
        }
    }
}

// ============================================================================
// runLoadProcess() — 加载流程 (VF L5443-5465)
//    private void runLoadProcess()
//    调用 clearScreen()/c() 加载链,非渲染Logo
// ============================================================================
private void runLoadProcess() {
    this.e(0); this.c(); this.e(20); this.c(4);
    this.e(40); this.c(0); this.e(80);
    // ... 完整见 VF L5443
}

// ============================================================================
// saveRMS_sanGuoTd() — ★ RMS 存档保存 (VF L5620-6596)
//    private final void saveRMS_sanGuoTd()
//    存档系统 — 将游戏状态写入 RMS RecordStore "sanGuoTd"
//    非 v1 标注的 renderMainMenu!
// ============================================================================
private final void saveRMS_sanGuoTd() {
    String var3 = "sanGuoTd";
    boolean var4 = false;
    RecordStore var5 = null;
    // ... 存档写入逻辑 (VF L5620-6596, 约976行)
}

// ============================================================================
// loadRMS_sanGuoTdData() — ★ RMS 存档读取 "sanGuoTdData" (VF L6668-6940)
//    private final void loadRMS_sanGuoTdData()
//    非 v1 标注的 renderBuildMenu!
// ============================================================================
private final void loadRMS_sanGuoTdData() {
    String var3 = "sanGuoTdData";
    // ... 存档读取逻辑 (VF L6668-6940)
}

// ============================================================================
// loadRMS_freeGame() — ★ RMS 存档读取 "freeGame" (VF L7035-7243)
//    private void loadRMS_freeGame()
//    非 v1 标注的 renderUpgradePanel!
// ============================================================================
private void loadRMS_freeGame() {
    String var3 = "freeGame";
    // ... 存档读取逻辑 (VF L7035-7243)
}

// ============================================================================
// loopProcess15() — 循环处理 (VF L7270-7292)
//    private void loopProcess15()
//    循环15次执行某操作
// ============================================================================
private void loopProcess15() {
    int var2 = 0;
    while (true) {
        if (var2 >= 15) return;
        // ... 循环体 (VF L7270)
        var2++;
    }
}

// ============================================================================
// updateMainFrame() — ★★★ 主帧更新逻辑 (VF L7309-7748)
//    private void updateMainFrame()
//    非 v1 标注的 renderHelp!
//    这是游戏主循环调用的核心帧更新方法
// ============================================================================
private void updateMainFrame() {
    this.soundEnabled = false;
    int var6 = this.keyRepeatCount;
    if (var6 >= 0) {
        this.keyRepeatCount = var6 + 1;
    }
    
    var6 = this.l;
    switch (var6) {
        case 0:
            // 加载状态
            if (this.al == 2) {
                if (this.ak == 0) {
                    this.isPausedInGame = true;
                    this.loopProcess15();
                }
                this.ak++;
                if (this.ak <= 35) {
                    this.f(0, this.ak);
                }
                // ... 完整见 VF L7309
            }
            break;
        case 1:
            // 主游戏状态 — 调用 updateGameFrame()
            this.updateGameFrame();
            break;
        // ... 其他状态 (完整见 VF L7309-7748)
    }
}

// ============================================================================
// drawScrollAndBg() — 调用 calcScrollPosition()+drawBackground() (VF L7771-7776)
//    private void drawScrollAndBg()
// ============================================================================
private void drawScrollAndBg() {
    this.calcScrollPosition();
    this.drawBackground();
}

// ============================================================================
// drawBackground() — 背景绘制 (VF L7784-7856)
//    private void drawBackground()
// ============================================================================
private void drawBackground() {
    Image var1 = this.spriteImages[3][3];
    this.a(var1, 0, 0, 13450878, true);
    this.graphicsCtx.setColor(15988422);
    // ... 完整见 VF L7784
}

// ============================================================================
// calcScrollPosition() — 滚动计算 (VF L7856-8146)
//    private void calcScrollPosition()
// ============================================================================
private void calcScrollPosition() {
    // 滚动位置计算 (VF L7856)
}

// ============================================================================
// handleLevelSelect() — 关卡选择 (VF L8146-8219)
//    private void handleLevelSelect()
//    根据 aw 状态分发关卡选择逻辑
// ============================================================================
private void handleLevelSelect() {
    int var4 = this.aw;
    switch (var4) {
        case 0:
            // ... (VF L8146)
        // ... 其他case
    }
}

// ============================================================================
// handleLevelInput() — 输入处理 (VF L8219-8273)
//    private void handleLevelInput()
//    根据 keyState(按键码)处理
// ============================================================================
private void handleLevelInput() {
    int var6 = this.keyState;
    switch (var6) {
        // ... (VF L8219)
    }
}

// ============================================================================
// handleTechTree() — 科技树 (VF L8273-8469)
//    private void handleTechTree()
// ============================================================================
private void handleTechTree() {
    // 科技树渲染/更新 (VF L8273)
}

// ============================================================================
// iterateTileProperties() — 遍历 tileProperties 数组 (VF L8469-8518)
//    private void iterateTileProperties()
// ============================================================================
private void iterateTileProperties() {
    int var2 = 0;
    while (true) {
        byte[] var3 = this.tileProperties;
        if (var2 >= var3.length) return;
        // ... (VF L8469)
        var2++;
    }
}

// ============================================================================
// updateGameState() — ★ 游戏状态更新 (VF L8518-8568)
//    private void updateGameState()
//    非 v1 标注的 renderGameOver!
//    更新 aS/aR/aT 等游戏状态, 调用 advanceLevel()
// ============================================================================
private void updateGameState() {
    if (this.victoryFlag) {
        this.victoryFlag = false;
        if ((this.aS & 3) == 3) {
            this.levelAdvanceFlag = true;
        } else {
            this.levelAdvanceFlag = false;
        }
        this.aR = 0;
        this.aT = 0;
        this.aS++;
        this.advanceLevel();
        this.bj = this.aV + 12;
        this.c(this.bj);
        this.aU = this.bj;
        // ... 完整见 VF L8518
    }
}

// ============================================================================
// selectGeneral() — 武将选择 (VF L8568-8592)
//    private void selectGeneral()
//    读取 generalSelectData[X][aO] 设置 aN
// ============================================================================
private void selectGeneral() {
    byte[][] var2 = this.generalSelectData;
    int var3 = this.X;
    byte[] var5 = var2[var3];
    var3 = this.aO;
    this.aN = var5[var3];
}

// ============================================================================
// selectGeneralAlt() — 武将选择 (VF L8592-8633)
//    private void selectGeneralAlt()
//    与 selectGeneral() 类似
// ============================================================================
private void selectGeneralAlt() {
    byte[][] var2 = this.generalSelectData;
    int var3 = this.X;
    byte[] var5 = var2[var3];
    var3 = this.aO;
    this.aN = var5[var3];
}

// ============================================================================
// advanceLevel() — 关卡推进 (VF L8633-8768)
//    private void advanceLevel()
//    根据 levelAdvanceFlag 和 aN 处理关卡推进
// ============================================================================
private void advanceLevel() {
    if (this.levelAdvanceFlag) {
        // ... (VF L8633)
    }
}

// ============================================================================
// renderOverlay() — 渲染 (VF L8768-8868)
//    private void renderOverlay()
//    根据 renderFlag 标志渲染
// ============================================================================
private void renderOverlay() {
    if (this.renderFlag) {
        this.graphicsCtx.setClip(0, 0, 240, 320);
        this.graphicsCtx.setColor(16777215);
        // ... (VF L8768)
    }
}

// ============================================================================
// checkVictory() — 胜利检查 (VF L8868-8903)
//    private void checkVictory()
//    aT==aX 且 aP==0 时设置 renderFlag=true
// ============================================================================
private void checkVictory() {
    if (this.aT == this.aX) {
        if (this.aP == 0) {
            this.renderFlag = true;
            // ... (VF L8868)
        }
    }
}

// ============================================================================
// resetGame() — 初始化 (VF L8903-8955)
//    private void resetGame()
//    重置 aq, aw=0, bg=0 等
// ============================================================================
private void resetGame() {
    this.h(this.aq);
    this.aw = 0;
    this.bg = 0;
    // ... (VF L8903)
}

// ============================================================================
// iteratePaths() — 遍历 bf (VF L8955-9023)
//    private void iteratePaths()
// ============================================================================
private void iteratePaths() {
    int var1 = 0;
    while (true) {
        if (var1 >= this.bf) {
            // ... (VF L8955)
            return;
        }
        // ...
        var1++;
    }
}

// ============================================================================
// drawMainMap() — 地图主绘制 (VF L9023-9224)
//    private void drawMainMap()
//    825行,绘制游戏主世界
// ============================================================================
private void drawMainMap() {
    // 1. 设置裁剪区域 240×320,背景色 13450878
    // 2. 绘制路径线段:遍历 bf 条路径
    // 3. 进度条绘制:若 bg > bh 则显示进度条
    // 4. 调用 updateScrollPos() 绘制进度数值
    // ... 完整见 VF L9023-9224
}

// ============================================================================
// updateGameFrame() — ★★★ 主游戏帧更新 (VF L9224-9590)
//    private final void updateGameFrame()
//    非 v1 标注的 renderSprites!
//    这是游戏运行时的核心帧更新方法
// ============================================================================
private final void updateGameFrame() {
    this.updateGameState();           // 游戏状态更新
    this.l(1);          // 更新塔逻辑
    
    // 胜利条件检查
    if (this.l == 2 && this.aP <= 0 && this.aT == this.aX && this.currentKeyCode == 35) {
        this.victoryFlag = true;
    }
    
    // 塔攻击更新
    int[] var7 = this.activeTowerIndices;
    int[][] var8 = this.towerSlots;
    int var9 = this.aP;
    a(var7, var8, var9, 24);  // 静态方法调用
    
    // ... 敌人更新、特效、金币等 (完整见 VF L9224-9590)
}

// ============================================================================
// renderGameWorld() — 渲染 (VF L9590-9926)
//    private final void renderGameWorld()
//    使用 renderData 和 towerSlots 数据渲染
// ============================================================================
private final void renderGameWorld() {
    int[] var1 = this.renderData;
    int[][] var2 = this.towerSlots;
    int var3 = this.aP;
    a(var1, var2, var3, 1);
    // ... 完整见 VF L9590
}

// ============================================================================
// renderGeneralSelect() — 渲染 (VF L9926-9993)
//    private void renderGeneralSelect()
//    使用 bn 数据渲染
// ============================================================================
private void renderGeneralSelect() {
    this.graphicsCtx.setClip(0, 0, 240, 320);
    this.graphicsCtx.setColor(16580557);
    // ... 完整见 VF L9926
}
