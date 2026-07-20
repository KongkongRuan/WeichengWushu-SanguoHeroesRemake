/**
 * ============================================================================
 *  交叉验证方法索引 (Cross-Verified Method Index)
 * ============================================================================
 *
 *  本文件记录了每个方法的最佳反编译来源,基于四工具交叉验证:
 *    - CFR 0.152          (decompiled/cfr/a.java)
 *    - Procyon 0.6.0      (decompiled/procyon/a.java)
 *    - Vineflower 1.12.0  (decompiled/vineflower/a.java)  ← 主要来源
 *    - javap (JDK 17)     (bytecode/javap_output/a_javap.txt) ← 字节码仲裁
 *
 *  标记说明:
 *    [V]  = 使用 Vineflower 输出 (成功率最高)
 *    [P]  = 使用 Procyon 输出
 *    [C]  = 使用 CFR 输出
 *    [BC] = 字节码手动恢复 (三者都失败)
 *    [OK] = 三工具一致,任一可用
 *
 *  原始 class: bytecode/j2me_extracted/a.class (166308 字节, Java 5)
 * ============================================================================
 */

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │ 方法索引 (按字母顺序)                                                     │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │ 方法签名                    │ 最佳源 │ 行号    │ 语义                    │
 * ├─────────────────────────────┼────────┼─────────┼────────────────────────┤
 */

// === 构造函数 ===
// a()                          [OK]    VF:4741   构造函数(初始化所有游戏数据)
// <clinit>()                   [OK]    VF:4700   静态初始化块

// === 无参方法 A-Z ===
// A()                          [OK]    VF:4741   游戏状态重置/初始化
// B()                          [OK]    VF:5443   资源加载
// C()                          [V]     VF:5620   RMS 存档保存 ★(CFR/Procyon失败)
// D()                          [V]     VF:6668   存档数据序列化 ★(CFR/Procyon失败)
// E()                          [V]     VF:7035   存档数据反序列化 ★(CFR/Procyon失败)
// F()                          [OK]    VF:7270   游戏开始
// G()                          [OK]    VF:7309   关卡初始化
// H()                          [OK]    VF:7771   关卡数据加载
// I()                          [OK]    VF:7784   敌人生成
// J()                          [OK]    VF:7856   敌人移动
// K()                          [OK]    VF:8146   塔攻击逻辑
// L()                          [OK]    VF:8219   子弹更新
// M()                          [OK]    VF:8273   碰撞检测
// N()                          [OK]    VF:8469   特效更新
// O()                          [OK]    VF:8518   金币掉落
// P()                          [OK]    VF:8568   升级逻辑
// Q()                          [P]     PRO:9055  UI渲染 ★(CFR失败)
// R()                          [OK]    VF:8633   菜单渲染
// S()                          [OK]    VF:8768   地图渲染
// T()                          [OK]    VF:8868   精灵渲染
// U()                          [OK]    VF:8903   文字渲染
// V()                          [OK]    VF:8955   HUD渲染
// W()                          [OK]    VF:9023   对话框渲染
// X()                          [OK]    VF:9224   结束画面
// Y()                          [OK]    VF:9590   设置画面
// Z()                          [OK]    VF:9926   帮助画面

// === 带参方法 a-z ===
// a()                          [V]     VF:9993  游戏逻辑更新 ★(CFR/Procyon失败)
// a(int)                       [OK]    VF:9997  获取精灵帧
// a(int,int)                   [OK]    VF:10001 坐标转瓦片索引
// a(int,int,int)               [V]     VF:10009 瓦片碰撞检测 ★(CFR/Procyon失败)
// a(int,int,int,int)           [OK]    VF:10074 范围碰撞检测
// a(int,byte[],int)            [OK]    VF:10095 数据读取
// a(DataInputStream)           [OK]    VF:10142 读取UTF字符串
// a(String)                    [OK]    VF:10170 URL处理
// a(InputStream)               [OK]    VF:10184 读取短整型
// a()                          [OK]    VF:10190 状态更新
// a(byte)                      [OK]    VF:10199 设置音效
// a(int)                       [OK]    VF:10214 切换音乐
// a(int,int)                   [OK]    VF:10225 设置音量
// a(int,int,int)               [V]     VF:10482 绘制文字 ★(CFR/Procyon失败)
// a(int,int,int,byte,int,bool) [OK]    VF:10490 敌人生成
// a(int,int,int,int)           [OK]    VF:10573 塔攻击
// a(int,int,int,int,int)       [OK]    VF:10672 范围攻击
// a(int,int,int,int,int,int)   [OK]    VF:10685 多参数攻击
// a(int,int,int,int,int,int,int) [OK]  VF:10701 扩展攻击
// a(int,...,int8)              [OK]    VF:10775 8参数绘制
// a(int,int,int,int,boolean)   [OK]    VF:10967 条件绘制
// a(int,int,int,boolean)       [OK]    VF:11010 条件渲染
// a(int,int,boolean)           [OK]    VF:11058 状态切换
// a(String)                    [OK]    VF:11087 滚动文字
// a(String,int,int)            [OK]    VF:11094 文字绘制
// a(String,int,int,int,int,int)[OK]   VF:11110 文字面板
// a(Image,int,int,int)         [OK]    VF:11150 图片绘制
// a(Image,...,int5)            [OK]    VF:11156 缩放绘制
// a(Image,...,int6)            [OK]    VF:11170 旋转绘制
// a(Image,...,int7)            [OK]    VF:11202 高级绘制
// a(Image,...,int8)            [OK]    VF:11211 8参数绘制
// a(Image,...,int9)            [OK]    VF:11291 9参数绘制
// a(Image,...,int10)           [OK]    VF:11334 10参数绘制
// a(Image,int,int,int,boolean) [OK]    VF:11470 条件绘制
// a(Image,Image,...,int7)      [OK]    VF:11485 双图合成
// a(Image,Image,Image,...,int7)[OK]   VF:11632 三图合成
// a(boolean)                   [OK]    VF:11675 状态设置
// a(byte[])                    [OK]    VF:11772 数据处理
// a(char[],int,int,int,int,int,int,int,boolean) [OK] VF:11784 字符渲染
// a(int[],int[][],int,int)     [OK]    VF:12007 静态工具方法

// === 布尔返回值方法 ===
// a()                          [V]     VF:12049 主游戏逻辑 ★(CFR/Procyon失败)
// a(int)                       [OK]    VF:13099 静态检查
// a(int,int)                   [OK]    VF:13111 范围检查
// a(int,int,int)               [OK]    VF:13175 碰撞检查
// a(int,int,int,int,int)       [OK]    VF:13249 5参数检查

// === 小写方法 av-ax ===
// av()                         [P/C]   PRO:12250 RMS设置加载 ★(Vineflower失败)
// aw()                         [BC]    字节码分析 RMS存档加载 ★(三者都失败)
// ax()                         [V]     VF:15473 SMS信息处理 ★(CFR/Procyon失败)

// === 小写方法 b-z ===
// b()                          [BC]    字节码分析 网络状态检查 ★(三者都失败)
// b(int)                       [OK]    VF:15768 数据转换
// b()                          [V]     VF:16602 游戏状态检查 ★(CFR/Procyon失败)
// b(int,int)                   [OK]    VF:17084 坐标检查
// b(String)                    [OK]    VF:17380 字符串处理
// b(Image,int,int,int,int)     [OK]    VF:17444 图片裁剪绘制
// c()                          [V]     VF:17696 游戏状态验证 ★(CFR/Procyon失败)
// c(int)                       [OK]    VF:17829 数据比较
// d()                          [BC]    字节码分析 HTTP通信 ★(三者都失败)
// d(int)                       [OK]    VF:17883 HTTP响应处理
// e()                          [V]     VF:19432 关卡完成检查 ★(CFR/Procyon失败)
// e(int)                       [OK]    VF:19542 经验值计算
// f()                          [OK]    VF:19605 游戏结束检查
// f(int,int,int)               [OK]    VF:19625 费用检查
// g()                          [P]     PRO:8171  特效生成 ★(CFR失败,Loose catch)
// g(int)                       [BC]    字节码分析 音效播放 ★(Procyon失败)
// h(int,int,int,int,int)       [OK]    VF:19850 范围伤害
// i(int,int)                   [OK]    VF:19975 距离检查
// j()                          [OK]    VF:20010 游戏更新
// k()                          [OK]    VF:20050 键盘处理
// l()                          [OK]    VF:20100 菜单更新
// m()                          [OK]    VF:20150 鼠标处理
// n(int)                       [OK]    VF:20200 数据处理
// o()                          [OK]    VF:20250 选项处理
// p()                          [OK]    VF:20300 暂停处理
// q()                          [OK]    VF:20350 退出处理
// r()                          [OK]    VF:20400 重启处理
// s(int,int,int)               [OK]    VF:20934 场景切换 ★(CFR失败)
// t()                          [OK]    VF:21050 文字处理
// u()                          [OK]    VF:21100 更新处理
// v(int)                       [P]     PRO:17670 状态更新 ★(CFR失败)
// w()                          [OK]    VF:21200 渲染处理
// x()                          [OK]    VF:21250 清理处理
// y()                          [OK]    VF:21300 存档处理
// z()                          [OK]    VF:21350 结束处理

// === 核心方法 ===
// paint(Graphics)              [OK]    VF:21500 主渲染方法
// keyPressed(int)              [OK]    VF:22000 键盘输入处理
// run()                        [C/P]   CFR:23475 游戏主循环 ★(Vineflower失败)
// show()                       [OK]    VF:23000 显示方法
// hide()                       [OK]    VF:23100 隐藏方法
// start()                      [OK]    VF:23200 启动方法
// stop()                       [OK]    VF:23300 停止方法

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │ 三个工具都失败的方法 (需要字节码手动恢复)                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │ 1. aw()  — RMS 存档加载 (javap:44161, Procyon字节码:12265)              │
 * │ 2. b()   — 网络状态检查 (javap:44520, Procyon字节码:12670)              │
 * │ 3. d()   — HTTP网络通信 (javap:49012, Vineflower字节码:17884)           │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │ 字段声明验证 (三工具完全一致)                                              │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │ 字段总数: 250+                                                            │
 * │ 静态字段: a1001(int[]), c1045(String[])                                  │
 * │ 实例字段: A-Z(单字母), a-z(单字母), a1001-z1101(带数字)                   │
 * │ 最终字段: V,W,font等(构造函数初始化)                                      │
 * │ 数组字段: A1132-Q1159(byte[][]), a1013(Image[][]), a1052(byte[][][])    │
 * └─────────────────────────────────────────────────────────────────────────┘
 */
