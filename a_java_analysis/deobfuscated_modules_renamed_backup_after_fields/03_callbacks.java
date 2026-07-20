/**
 * ============================================================================
 *  模块 03: J2ME 回调方法
 * ============================================================================
 *
 *  原始类: a extends FullCanvas implements Runnable
 *  本模块包含: 6个 J2ME 回调方法
 *
 *  交叉验证: Vineflower 主源, 三工具一致
 *  可靠性: ★★★★★
 *
 *  方法清单:
 *    1. paint(Graphics)      — 渲染回调
 *    2. run()                — 游戏主循环 (Runnable)
 *    3. keyPressed(int)      — 按键处理
 *    4. keyReleased(int)     — 按键释放
 *    5. showNotify()         — Canvas显示通知
 *    6. hideNotify()         — Canvas隐藏通知
 * ============================================================================
 */

// ============================================================================
// 1. paint() — 渲染回调 (VF L27281-27350)
//    public final void paint(Graphics var1)
//
//    流程:
//    1. 保存 Graphics 到 graphicsCtx
//    2. 通过 DirectUtils 获取 DirectGraphics 存入 directGraphics
//    3. 设置字体为 a (gameFont)
//    4. 调用 A() — 主渲染分发器
// ============================================================================
public final void paint(Graphics graphics) {
    try {
        this.graphicsCtx = graphics;
        this.directGraphics = DirectUtils.getDirectGraphics(graphics);
        this.graphicsCtx.setFont(this.a);
        this.A();  // 主渲染分发
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// ============================================================================
// 2. run() — 游戏主循环 (VF L27351-27504, 字节码手动恢复)
//    public final void run()
//
//    状态机流程:
//    1. 检查 threadRunning (已有线程标志), 若!=false 则调用 c() 等待并返回
//    2. 设置 threadRunning=true, 创建同步锁对象 syncLock
//    3. while(true) 主循环:
//       a. 检查 isPaused(暂停标志), 若为false则调用 CMidlet.a() 退出
//       b. 记录帧开始时间
//       c. 调用 G() — 主帧更新逻辑(状态分发)
//       d. 清除按键状态 keyState=0
//       e. 调用 repaint() + serviceRepaints() 触发重绘
//       f. Thread.sleep(10) — 基础帧延时
//       g. Thread.yield() — 让出CPU
//       h. 等待直到满100ms (目标10FPS)
//       i. 若 soundEnabled(音效)开启, 计算帧耗时存入 s
//       j. 帧计数器 totalFrameCount++
//
//    ★ v3 修正: try-catch 范围修正
//      VF 字节码异常表 (L27488-27502) 显示 try-catch 覆盖整个循环体
//      (offsets 41-116), 不只是 Thread.sleep(10)
//      异常处理: printStackTrace() + 继续循环 (goto 36)
//
//    注意: VF L27351 中 threadRunning 是 boolean 类型, 不是 int
//          v1 版本错误地写成了 int 比较
// ============================================================================
public final void run() {
    // 检查是否已有线程在运行
    if (this.threadRunning) {
        // 已有线程:等待并设置状态
        int n = this.c();           // ★ c() 返回 int, 不是 void!
        Object lock = this.syncLock;
        synchronized (lock) {
            this.bV = n;
            return;
        }
    }
    
    // 标记主循环已启动
    this.threadRunning = true;
    this.syncLock = new Object();
    
    // 主循环
    while (true) {
        // ★ v3 修正: try-catch 覆盖整个循环体 (VF 字节码异常表 L27488-27502)
        try {
            // 检查暂停标志
            if (!this.isPaused) {
                CMidlet.a();  // 退出游戏
                return;
            }
            
            long frameStartTime = System.currentTimeMillis();
            
            // 主帧更新 (状态机分发)
            this.G();  // ★ G() 是主帧更新, 不是渲染帮助!
            
            // 清除按键状态并触发重绘
            this.keyState = 0;
            this.repaint();
            this.serviceRepaints();
            
            // 基础帧延时
            Thread.sleep(10);
            Thread.yield();
            
            // 等待达到100ms帧间隔 (目标10FPS)
            while (System.currentTimeMillis() - frameStartTime < 100) {
                Thread.yield();
            }
            
            // 音效帧耗时统计
            if (this.soundEnabled) {
                this.s = (int)(System.currentTimeMillis() - frameStartTime + this.s);
            }
            
            // 帧计数器递增
            this.totalFrameCount += 1;
        } catch (Exception e) {
            // 异常时打印堆栈并继续循环 (VF 字节码 L84-89: printStackTrace + goto 36)
            e.printStackTrace();
        }
    }
}

// ============================================================================
// 3. keyPressed() — 按键处理 (VF L27169-27275)
//    public final void keyPressed(int var1)
//
//    流程:
//    1. 检查 at (防重复触发标志), 若!=0则忽略
//       注意: at 字段在 VF L162 中存在 (private int at)
//    2. 将 keyCode 存入 currentKeyCode 和 keyState
//    3. 清除 keyRepeatCount (连按计数)
//    4. 特殊处理: 若 l==46 且按键为-5(确认)或-7(返回), 设置 o=-1
//    5. 清除 isTouch (触摸标志)
//    6. 调用 ao() — 按键状态机分发
// ============================================================================
public final void keyPressed(int keyCode) {
    // ★ VF L27172: 检查 at (防重复触发标志), 若!=0则忽略
    //   at 字段在 VF L162 中存在 (private int at)
    if (this.at != 0) {
        return;
    }
    try {
        this.currentKeyCode = keyCode;
        this.keyState = keyCode;
        this.keyRepeatCount = 0;
        
        // ★ v8 修正: o=-1 的设置条件 (三方交叉验证)
        //   VF L27216-27254 (label85块):
        //     if (l == 46) {
        //         if (keyState != -5) {
        //             if (keyState != -7) break; // 跳过 o=-1
        //         }
        //     }
        //     o = -1;
        //   即: o=-1 当 l!=46 或 keyState==-5 或 keyState==-7
        //   Procyon确认: if (l != 46 || keyState == -5 || keyState == -7) o = -1;
        //   
        //   语义: 非结局状态(l!=46)任何按键清除塔选中;
        //         结局状态(l==46)仅确认(-5)/返回(-7)触发
        if (this.l != 46 || keyCode == -5 || keyCode == -7) {
            this.o = -1;
        }
        
        this.isTouch = false;
        this.ao();  // 按键状态机分发
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// ============================================================================
// 4. keyReleased() — 按键释放 (VF L27275-27281)
//    public final void keyReleased(int var1)
// ============================================================================
public final void keyReleased(int keyCode) {
    this.keyRepeatCount = -1;  // 标记按键已释放
    this.currentKeyCode = 0;   // 清除当前按键
}

// ============================================================================
// 5. showNotify() — Canvas显示通知 (VF L27505-27524)
//    public final void showNotify()
//
//    根据 cb 值决定恢复模式:
//    - cb==1000: 设置 notifyStatus=2 (完全恢复)
//    - needRestore==true: 设置 notifyStatus=1 (部分恢复)
//    - 其他: 设置 notifyStatus=3 (默认恢复)
//    最后 cb=0
// ============================================================================
public final void showNotify() {
    if (this.cb == 1000) {
        this.notifyStatus = 2;
    } else if (this.needRestore) {
        this.notifyStatus = 1;
    } else {
        this.notifyStatus = 3;
    }
    this.cb = 0;
}

// ============================================================================
// 6. hideNotify() — Canvas隐藏通知 (VF L27115-27166)
//    public final void hideNotify()
//
//    ★ v2 修正: 原版本严重简化, 现按 VF L27115-27166 完整恢复
//    ★ v6 修正: 状态检查条件错误 — l∈{46,48,47}不应执行a(3)
//
//    流程:
//    1. 若 cb==1500: 设置 needRestore=true (标记需要恢复)
//    2. 检查 l(游戏状态), 仅在以下状态处理隐藏:
//       l==2, 12, 13, 22, 23 (执行a(3))
//       l==46, 47, 48 → 不处理, 直接返回
//       (其他状态也直接返回)
//    3. 调用 a(3) — 菜单跳转到状态3
//    4. 若 isPausedInGame(暂停标志): 调用 h(aq) — 恢复音频
//    5. 重置 r=0, at=0 (清除防重复触发标志)
// ============================================================================
public final void hideNotify() {
    // 步骤1: 检查 cb==1500, 标记需要恢复
    if (this.cb == 1500) {
        this.needRestore = true;
    }
    
    // 步骤2: 检查游戏状态, 仅在 l∈{2,12,13,22,23} 时处理隐藏
    // (VF嵌套if结构: l∈{46,48,47}时不进入处理块)
    if (this.l != 2 && this.l != 12 && this.l != 13 
        && this.l != 22 && this.l != 23) {
        return;
    }
    
    // 步骤3: 菜单跳转到状态3
    this.a(3);
    
    // 步骤4: 若暂停标志开启, 恢复音频
    if (this.isPausedInGame) {
        this.h(this.aq);
    }
    
    // 步骤5: 重置计数器和防重复触发标志
    this.r = 0;
    this.at = 0;
}
