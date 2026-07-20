# a.java 反混淆模块化文件说明

> 生成时间: 2026-07-19
> 基于: Vineflower 1.12.0 + javap (JDK 17) 字节码交叉验证

## 目录结构

```
deobfuscated_modules/
├── 00_constants.java          — 静态常量与配置数据
├── 01_fields.java             — 实例字段声明 (150+个)
├── 02_constructor.java        — 构造函数 (4333行精简版)
├── 03_callbacks.java          — J2ME回调方法 (6个)
├── 04_render_AZ.java          — A-Z渲染分发方法 (26个)
├── 05_logic_aa_az.java        — aa-az游戏逻辑方法 (25个)
├── 06_logic_a_z.java          — a-z游戏逻辑方法 (含重载, 50+个)
├── 07_utils.java              — 工具方法 (带参数重载, 100+个)
├── 08_bytecode_recovered.java — Vineflower失败方法的字节码恢复 (5个)
├── 09_method_index.java       — 完整方法索引
└── README.md                  — 本文件
```

## 模块说明

### 00_constants.java
静态常量: DirectGraphics旋转参数 (a1001[8]) 和 MIDI文件名 (c1045[15])
可靠性: ★★★★★

### 01_fields.java
所有实例字段声明,约150+个,按功能分组:
- 渲染字段 (Graphics, Image, DirectGraphics)
- 字体尺寸 (final)
- 屏幕尺寸 (final)
- 游戏状态字段
- 菜单/导航状态
- aA-cb扩展状态变量 (78个int)
- 核心游戏数据数组 (final)
- 地图/精灵三维数组
- 布尔状态标志
- 武将/科技/文本字段
- 音频字段
- 网络/存档字段
- 敌人/塔槽位
- 输入字段

可靠性: ★★★★★ (三工具完全一致)

### 02_constructor.java
构造函数精简版,展示初始化顺序和关键数据:
1. 字体设置
2. 屏幕尺寸计算
3. 颜色常量
4. 资源路径 [39]
5. 游戏文本 [181]
6. 精灵帧数 [39]
7. 塔建造路径
8. 科技树
9. 关卡序列
10. 敌人HP/塔属性数据
11. 地图数据数组
12. 敌人槽位 int[30][18]

可靠性: ★★★★★

### 03_callbacks.java
J2ME回调方法 (6个):
- `paint(Graphics)` — 渲染回调
- `run()` — 游戏主循环 (10FPS)
- `keyPressed(int)` — 按键处理
- `keyReleased(int)` — 按键释放
- `showNotify()` — 显示通知
- `hideNotify()` — 隐藏通知

可靠性: ★★★★★

### 04_render_AZ.java
A-Z无参数方法 (26个),核心方法:
- `A()` — 渲染分发器 (switch l)
- `G()` — ★主帧更新逻辑 (非v1标注的renderHelp!)
- `O()` — ★游戏状态更新 (非v1标注的renderGameOver!)
- `W()` — 地图主绘制 (825行)
- `X()` — ★★主游戏帧更新 (非v1标注的renderSprites!)
- `C()` — ★RMS存档保存 (非v1标注的renderMainMenu!)
- `D()` — ★RMS存档读取 (非v1标注的renderBuildMenu!)
- `E()` — ★RMS存档读取 (非v1标注的renderUpgradePanel!)

可靠性: ★★★★☆

### 05_logic_aa_az.java
aa-ay方法 (25个),核心方法:
- `ao()` — 按键状态机分发
- `av()` — ★启动游戏线程 (字节码恢复)
- `aw()` — ★RMS读取"__sfSmsInfo" (字节码恢复)
- `ax()` — RMS写入"__sfSmsInfo"
- `ay()` — 存档缓冲区处理

可靠性: ★★★★☆

### 06_logic_a_z.java
a-z系列方法,含重载约50个,核心方法:
- `int b()` — ★同步锁+返回bV (非v1标注的void!)
- `int c()` — ★循环调用d() (非v1标注的void!)
- `int d()` — ★★★HTTP通信 (非v1标注的void updateTowers!)
- `int b(int)` — ★敌人HP计算 (非v1标注的void!)
- `void f()` — ★进度条渲染 (非v1标注的updateEffects!)
- `void g()` — ★音量控制 (非v1标注的updateEconomy!)
- `void n()` — ★滚动位置更新 (非v1标注的drawTowers!)
- `void p()` — ★背景清屏 (非v1标注的drawHUD!)
- `void u()` — ★阵营选择状态机 (非v1标注的uploadScore!)
- `void v()` — ★阵营选择渲染 (非v1标注的controlAudio!)
- `void z()` — ★敌人移动更新 (非v1标注的initGame!)

可靠性: ★★★★☆

### 07_utils.java
带参数的工具方法,约100+个重载:
- 静态方法 (a/b/c/d/e/f/g 开头)
- 渲染辅助方法 (Image/String/char[] 参数)
- 带参数的状态更新方法

可靠性: ★★★★☆

### 08_bytecode_recovered.java
Vineflower反编译失败的5个方法,通过javap字节码手动恢复:
1. `int b()` — 同步锁+返回bV (线程同步控制)
2. `int d()` — HTTP通信 (GET/POST, 代理支持)
3. `void av()` — 启动游戏线程 (MIDletThread)
4. `void aw()` — RMS读取付费信息 ("__sfSmsInfo")
5. `void ay()` — 存档缓冲区处理

每个方法附带详细的字节码分析和恢复说明。

可靠性: ★★★★☆ (基于字节码分析)

### 09_method_index.java
完整方法索引,按字母顺序排列,标注:
- 方法签名
- 返回类型
- 功能描述
- Vineflower行号
- 来源标记 ([VF]/[BC])

## v1 版本问题修正

v1版本的 a_deobfuscated.java 存在系统性错误:
- 方法名语义化推断不准确 (15+处命名错误)
- 返回类型错误 (b/c/d 系列)
- 缺失方法过多 (60+个)
- 字段引用与声明不匹配

v2版本(模块化)修正了所有已知问题:
- 保留原始混淆名
- 准确的返回类型
- 完整的方法覆盖 (150+个)
- 基于Vineflower输出的准确方法体
- 字节码恢复5个失败方法

## 交叉验证来源

| 工具 | 版本 | 输出 | 方法成功率 |
|------|------|------|-----------|
| Vineflower | 1.12.0 | decompiled/vineflower/a.java (27524行) | 97% (145/150) |
| javap | JDK 17 | bytecode/javap_output/a_javap.txt (74477行) | 100% (字节码) |
| CFR | 0.152 | decompiled/cfr/a.java (23555行) | 92% (参考) |
| Procyon | 0.6.0 | decompiled/procyon/a.java (18542行) | 93% (参考) |

## 使用建议

1. **H5重制参考**: 以 03_callbacks.java 和 04_render_AZ.java 为核心架构参考
2. **游戏逻辑**: 重点研究 06_logic_a_z.java 中的 G()/X()/O()/z() 方法
3. **数据结构**: 参考 01_fields.java 和 02_constructor.java
4. **网络通信**: 参考 08_bytecode_recovered.java 中的 d() 方法
5. **存档系统**: 参考 04_render_AZ.java 中的 C()/D()/E() 方法
