/**
 * ============================================================================
 *  模块 05: aa-az 游戏逻辑方法
 * ============================================================================
 *
 *  原始类: a extends FullCanvas implements Runnable
 *  本模块包含: 26个 aa-az 方法
 *
 *  交叉验证: Vineflower 主源 (L13349-15768)
 *  可靠性: ★★★★☆
 *
 *  ★ 关键方法:
 *    - loadRMS_sfSmsInfo() — RMS读取("__sfSmsInfo"), VF失败, javap恢复
 *    - saveRMS_sfSmsInfo() — RMS写入("__sfSmsInfo")
 *    - processSaveBuffer() — 存档缓冲区处理
 *    - dispatchKeyState() — 按键状态机分发
 * ============================================================================
 */

// ============================================================================
// helperAA() — (VF L13349-13419)
// ============================================================================
private void helperAA() {
    // ... (VF L13349)
}

// ============================================================================
// helperAB() — (VF L13419-13437)
// ============================================================================
private void helperAB() {
    // ... (VF L13419)
}

// ============================================================================
// helperAC() — (VF L13437-13492)
// ============================================================================
private void helperAC() {
    // ... (VF L13437)
}

// ============================================================================
// helperAD() — (VF L13492-13555)
// ============================================================================
private void helperAD() {
    // ... (VF L13492)
}

// ============================================================================
// helperAE() — (VF L13555-13574)
// ============================================================================
private void helperAE() {
    // ... (VF L13555)
}

// ============================================================================
// helperAF() — (VF L13574-13592)
// ============================================================================
private void helperAF() {
    // ... (VF L13574)
}

// ============================================================================
// renderAG_block298() — (VF L13592-13890)
//    约298行
// ============================================================================
private void renderAG_block298() {
    // ... (VF L13592)
}

// ============================================================================
// helperAH() — (VF L13890-13975)
// ============================================================================
private void helperAH() {
    // ... (VF L13890)
}

// ============================================================================
// helperAI() — (VF L13975-14081)
// ============================================================================
private void helperAI() {
    // ... (VF L13975)
}

// ============================================================================
// helperAJ() — (VF L14081-14159)
// ============================================================================
private void helperAJ() {
    // ... (VF L14081)
}

// ============================================================================
// renderAK_block297() — (VF L14159-14456)
//    约297行
// ============================================================================
private void renderAK_block297() {
    // ... (VF L14159)
}

// ============================================================================
// renderAL_block235() — (VF L14456-14691)
//    约235行
// ============================================================================
private void renderAL_block235() {
    // ... (VF L14456)
}

// ============================================================================
// helperAM() — (VF L14691-14739)
// ============================================================================
private void helperAM() {
    // ... (VF L14691)
}

// ============================================================================
// helperAN() — (VF L14739-14790)
// ============================================================================
private void helperAN() {
    // ... (VF L14739)
}

// ============================================================================
// dispatchKeyState() — ★ 按键状态机分发 (VF L14790-14870)
//    private void dispatchKeyState()
//    根据 l(游戏状态) 和 keyState(按键码) 分发
// ============================================================================
private void dispatchKeyState() {
    int var2 = this.l;
    if (var2 == 2) {
        // 关卡选择状态
        var2 = this.keyState;
        int[] var3 = this.intArrayR1166;
        int var4 = this.bU;
        int var5 = var3[var4];
        // ... (VF L14790)
    }
    // ... 其他状态处理
}

// ============================================================================
// renderDifficulty() — 渲染 (VF L14870-14936)
//    private void renderDifficulty()
//    绘制 gameTexts[175] 文本
// ============================================================================
private void renderDifficulty() {
    this.graphicsCtx.setColor(16580557);
    String var6 = this.gameTexts[175];
    // ... (VF L14870)
}

// ============================================================================
// handleInputAQ() — 输入处理 (VF L14936-15006)
//    private void handleInputAQ()
//    根据 keyState 处理
// ============================================================================
private void handleInputAQ() {
    int var3 = this.keyState;
    switch (var3) {
        case -7:
            this.r = 0;
            this.a();
            // ... (VF L14936)
    }
}

// ============================================================================
// renderEndingAnim() — 渲染 (VF L15006-15082)
//    private final void renderEndingAnim()
//    结局动画渲染
// ============================================================================
private final void renderEndingAnim() {
    this.clearScreen();
    this.graphicsCtx.setColor(14311547);
    this.graphicsCtx.setClip(0, 0, 240, 320);
    // ... (VF L15006)
}

// ============================================================================
// stateMachineNotify() — 状态机 (VF L15082-15239)
//    private final void stateMachineNotify()
//    根据 notifyStatus(显示通知状态) 分发
// ============================================================================
private final void stateMachineNotify() {
    int var4 = this.notifyStatus;
    switch (var4) {
        case 0:
            var4 = this.keyState;
            // ... (VF L15082)
    }
}

// ============================================================================
// setNotify1() — 设置b1174=1 (VF L15239-15244)
//    private void setNotify1()
// ============================================================================
private void setNotify1() {
    this.notifyStatus = 1;
    this.a();
}

// ============================================================================
// initCalendar() — 日历初始化 (VF L15244-15268)
//    private void initCalendar()
//    设置 calendar(Calendar) 和 saveDate(Date)
// ============================================================================
private void initCalendar() {
    Calendar var1 = Calendar.getInstance();
    this.calendar = var1;
    Date var7 = new Date();
    this.saveDate = var7;
    long var2 = System.currentTimeMillis();
    var7.setTime(var2);
    // ... (VF L15244)
}

// ============================================================================
// startGameThread() — ★ 启动游戏线程 (VF L15268-15313)
//    private void startGameThread()
//    VF 反编译失败, 通过 javap 字节码恢复 (L44128-44161)
//
//    流程:
//    1. 同步锁 syncLock
//    2. 设置 bV = 2
//    3. 创建 MIDletThread(this) 线程
//    4. 启动线程
// ============================================================================
private void startGameThread() {
    synchronized (this.syncLock) {
        this.bV = 2;
    }
    Thread t = new MIDletThread(this);
    t.start();
}

// ============================================================================
// loadRMS_sfSmsInfo() — ★ RMS读取"__sfSmsInfo" (VF L15313-15473)
//    private final void loadRMS_sfSmsInfo()
//    VF 反编译失败, 通过 javap 字节码恢复 (L44161-44520)
//
//    流程:
//    1. 打开 RMS "__sfSmsInfo"
//    2. 读取 record 1
//    3. 用 DataInputStream 读取:
//       - readInt() (跳过)
//       - readUTF() → menuTitle (菜单标题)
//       - readUTF() → currentGeneralName (当前武将名)
//       - readBoolean() → hasFactionName
//       - 若 hasFactionName: readUTF() → factionName (阵营名)
//       - readBoolean() → hasLevelName
//       - 若 hasLevelName: readUTF() → levelName (关卡名)
//    4. 关闭流和RecordStore
//    5. 异常时设置默认值:
//       - currentGeneralName = "YXBY15 2LD210A10 IF2"
//       - menuTitle = "106633000015"
//       - 调用 saveRMS_sfSmsInfo()
// ============================================================================
private final void loadRMS_sfSmsInfo() {
    try {
        RecordStore rs = RecordStore.openRecordStore("__sfSmsInfo", false);
        byte[] data = rs.getRecord(1);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        
        dis.readInt();                          // 跳过版本号
        this.menuTitle = dis.readUTF();             // 菜单标题
        this.currentGeneralName = dis.readUTF();             // 当前武将名
        
        this.hasFactionName = dis.readBoolean();
        if (this.hasFactionName) {
            this.factionName = dis.readUTF();         // 阵营名
        }
        
        this.hasLevelName = dis.readBoolean();
        if (this.hasLevelName) {
            this.levelName = dis.readUTF();         // 关卡名
        }
        
        dis.close();
        bais.close();
        rs.closeRecordStore();
    } catch (Exception e) {
        // 异常时设置默认值
        this.currentGeneralName = "YXBY15 2LD210A10 IF2";
        this.menuTitle = "106633000015";
        this.saveRMS_sfSmsInfo();  // 写入默认值到RMS
    }
}

// ============================================================================
// saveRMS_sfSmsInfo() — RMS写入"__sfSmsInfo" (VF L15473-15744)
//    private void saveRMS_sfSmsInfo()
//    将 menuTitle, currentGeneralName, hasFactionName, factionName, hasLevelName, levelName 写入 RMS
// ============================================================================
private void saveRMS_sfSmsInfo() {
    String var3 = "__sfSmsInfo";
    // ... RMS写入逻辑 (VF L15473)
}

// ============================================================================
// processSaveBuffer() — 存档缓冲区处理 (VF L15744-15768)
//    private void processSaveBuffer()
//    处理 saveBuffer (ByteArrayOutputStream)
// ============================================================================
private void processSaveBuffer() {
    try {
        ByteArrayOutputStream var10000 = this.saveBuffer;
        // ... (VF L15744)
    } catch (Exception e) {
        // ...
    }
}

// 注意: az() 字段存在 (int az) 但方法 az() 需要进一步确认
// VF 方法列表中未明确找到 void az(), 可能被包含在其他方法中
