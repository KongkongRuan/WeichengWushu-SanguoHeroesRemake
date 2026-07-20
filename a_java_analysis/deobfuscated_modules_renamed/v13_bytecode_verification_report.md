# v13 字节码核对与剩余重命名报告

## 一、执行概要

本报告记录了基于 `javap` 字节码精确签名,对 `deobfuscated_modules_renamed/` 中剩余未重命名部分进行核对和替换的完整过程。

### 核对基础
- **字节码文件**: `a_java_analysis/bytecode/javap_output/a_javap.txt` (74477行,UTF-16编码)
- **内容**: 包含完整的字节码指令,每条 `invokevirtual`/`invokestatic`/`getfield`/`putfield` 指令都带有完整的方法/字段引用(含返回类型和参数类型)
- **方法签名**: 从字节码提取了 276 个方法定义签名和 209 个唯一调用签名

### 字节码核对的关键发现

字节码中每个方法调用都有精确的签名格式: `Method <name>:(<params>)<returntype>`
- `a:()V` — void a()
- `a:()I` — int a()
- `a:()Z` — boolean a()
- `c:(II)V` — void c(int,int)

这使得我们可以**精确区分所有重载方法**,包括之前无法用正则区分的同名同参不同返回类型的方法。

## 二、字节码核对结果

### 核心的带参方法字节码验证

| 混淆签名 | 语义名 | 字节码逻辑 | 状态 |
|---------|--------|-----------|------|
| `a(int):int` | `getTileProperty` | `return E1163[param] >> 1` | ✅ 一致 |
| `a(int,int):int` | `calcTileIndex` | `(var2>>4) * bG + (var1>>4)` | ✅ 一致 |
| `b():int` | `getThreadState` | `synchronized(syncLock) { return bV; }` | ✅ 一致 |
| `b(int):int` | `calcEnemyHp` | 遍历c1107, 调用calcHp, 加killRewards | ✅ 一致 |
| `c():int` | `waitHttpResponse` | `while(d()==1) Thread.yield();` | ✅ 一致 |
| `c(int):int [static]` | `calcDirection` | 角度比较 225/135/45/315 → 0/1/2/3 | ✅ 一致 |
| `d():int` | `doHttpCommunication` | Connector.open, HttpConnection, GET/POST | ✅ 一致 |
| `d(int):int` | `convertTileType` | E1163[param] >= 12 ? -12 : +98 : -1 | ✅ 一致 |
| `d(int,int,int):int [static]` | `calcBaseHp` | `return param1 * param2 + param0` | ✅ 一致 |
| `e(int):int [static]` | `hexCharToInt` | '0'-'9'→-48, 'a'-'z'→-87, 'A'-'Z'→-55 | ✅ 一致 |
| `e(int):boolean` | `checkEnemyAttack` | c1107+o1098+t1103, 调用calcHp | ✅ 一致 |

### 字节码确认的 TODO 方法功能

| 混淆签名 | 原标注 | 字节码确认功能 | 更新后语义名 |
|---------|--------|--------------|------------|
| `a(int,int,int):void` | helperA_3P TODO | setClip + drawString(gameTexts[]) | `drawStringAt` |
| `c(int,int):void` | helperC_2P TODO | fillRect + drawImage(spriteImages[]) | `drawSpriteRow` |
| `d(int,int):void` | helperD_2P TODO | setClip + drawImage底部对齐 | `drawSpriteBottom` |
| `e(int,int):void` | helperE_2P TODO | 循环15次drawImage网格 | `drawSpriteGrid` |
| `f(int,int):void` | helperF_2P TODO | lookupswitch 7分支状态机 | `handleGameInput` |
| `h(int,int):void` | helperH_2P TODO | setClip + 状态22渲染 | `renderGameState22` |

## 三、v13 替换统计

| 替换类型 | 替换次数 | 说明 |
|---------|---------|------|
| 字段声明替换 | **19** | 01_fields.java 中单字母字段声明 |
| 字段引用替换 | **172** | `this.xxx` 字段引用(单字母+双字母) |
| 方法定义替换 | **151** | 带参方法+无参非void方法 |
| 方法调用替换 | **9** | 上下文分析推断返回类型 |
| v12同名修复 | **4** | boolean版本方法定义+调用修复 |
| **总计** | **355** | |

## 四、已替换的字段名示例

### 单字母字段 (this.xxx 引用)

| 混淆名 | 语义名 | 说明 | 替换数 |
|--------|--------|------|--------|
| `this.l` | `this.gameState` | 核心状态机变量 | ~30处 |
| `this.m` | `this.menuDepth` | 菜单栈深度 | ~25处 |
| `this.o` | `this.selectedTowerIdx` | 选中塔索引 | ~10处 |
| `this.b` | `this.menuHistoryStack` | 菜单历史栈 | ~15处 |
| `this.r` | `this.enemyCount` | 敌人数量 | ~8处 |
| `this.q` | `this.volume` | 音量值 | ~5处 |
| `this.j` | `this.fontHeight` | 字体高度 | ~3处 |
| `this.k` | `this.charWidth` | 字符宽度 | ~3处 |
| `this.n` | `this.lineHeight` | 行高 | ~2处 |

### 双字母字段 (this.xxx 引用)

| 混淆名 | 语义名 | 说明 |
|--------|--------|------|
| `this.bV` | `this.threadState` | 线程状态(2=运行) |
| `this.bf` | `this.pathCount` | 路径数量 |
| `this.aP` | `this.activeTowerCount` | 活跃塔数量 |
| `this.aT` | `this.currentTurn` | 当前回合 |
| `this.bI` | `this.screenCenterX` | 屏幕中心X |
| `this.bJ` | `this.screenCenterY` | 屏幕中心Y |

## 五、已替换的方法名示例

### 带参方法定义 (151个)

| 混淆签名 | 语义名 | 说明 |
|---------|--------|------|
| `a(int):int` | `getTileProperty` | 瓦片属性获取 |
| `a(int,int):int` | `calcTileIndex` | 瓦片索引计算 |
| `a(int,int,int):int` | `calcAngle` | 角度计算(正切表) |
| `a(int,byte[],int):int` | `calcHp` | HP计算 |
| `b(int):int` | `calcEnemyHp` | 敌人HP计算 |
| `b(int,int):int` | `tileCoordConvert` | 瓦片坐标转换 |
| `c(int,int):int` | `checkTileBoundary` | 坐标边界检查 |
| `d(int):int` | `convertTileType` | 瓦片类型转换 |
| `e(int):boolean` | `checkEnemyAttack` | 敌人攻击检查 |
| `e(int,int):boolean` | `isTileType8` | 瓦片类型8检查 |
| `f(int,int):boolean` | `isTileType10` | 瓦片类型10检查 |
| `h(int):boolean` | `randomLessThan` | 随机数比较 |
| `a(int,int,int,byte,int,boolean):void` | `fillTile` | 瓦片填充(建造/拆除) |
| `a(int,int,int,int,int):void` | `renderRangeAttack` | 范围攻击渲染 |
| `a(char[],int,int,int,int,int,int,boolean):void` | `renderChars` | 字符渲染 |
| `a(Image,int,int,int):void` | `drawImageRotation` | 旋转绘制图片 |
| `a(Image,int,int,int,int):void` | `drawImageTiled` | 平铺绘制 |
| `a(String,int,int,int,int,int):void` | `drawTextPanel` | 文字面板绘制 |
| ... | ... | 共 151 个 |

### v12 同名方法修复 (4个)

| 原错误名 | 返回类型 | 修正后名 | 说明 |
|---------|---------|---------|------|
| `clearScreen` | boolean | `isTechTreeUnlocked` | e():boolean 修复 |
| `drawProgressBar` | boolean | `initGame` | f():boolean 修复 |
| `handleVolume` | boolean | `uploadScore` | g():boolean 修复 |

## 六、验证结果

### 括号配对平衡检查

| 文件 | 圆括号差 | 花括号差 | 状态 |
|------|---------|---------|------|
| 00_constants.java | 0 | 0 | ✅ |
| 01_fields.java | 0 | 0 | ✅ |
| 02_constructor.java | 0 | 0 | ✅ |
| 03_callbacks.java | 0 | 0 | ✅ |
| 04_render_AZ.java | 0 | 0 | ✅ |
| 05_logic_aa_az.java | 0 | 0 | ✅ |
| 06_logic_a_z.java | 0 | 0 | ✅ |
| 07_utils.java | 0 | 0 | ✅ |
| 08_bytecode_recovered.java | 0 | 0 | ✅ |
| 09_method_index.java | 0 | 0 | ✅ |

### 无损坏验证
- `gameFont(` 作为方法名: **0 处** ✅
- `menuHistoryStack(` 作为方法名: **0 处** ✅
- `cursorX(` 作为方法名: **0 处** ✅
- `gameState(` 作为方法名: **0 处** ✅

## 七、代码可读性提升示例

### 替换前 (06_logic_a_z.java):
```java
private int b() {
    Object lock = this.a1172;
    synchronized (lock) {
        int n = this.bV;
        ...
```

### 替换后:
```java
private int getThreadState() {
    Object lock = this.syncLock;
    synchronized (lock) {
        int n = this.threadState;
        ...
```

### 替换前 (06_logic_a_z.java):
```java
private int c() {
    while (true) {
        int var1 = this.d();
        if (var1 != 1) {
```

### 替换后:
```java
private int waitHttpResponse() {
    while (true) {
        int var1 = this.doHttpCommunication();
        if (var1 != 1) {
```

### 替换前 (方法定义区分重载):
```java
private final int a() { return this.a1012.nextInt() & 0xFF; }
private void a() { this.m--; this.l = this.b[this.m]; }
private final boolean a() { String var5 = "sanGuoTd"; ... }
```

### 替换后:
```java
private final int randomByte() { return this.random.nextInt() & 0xFF; }
private void menuReturn() { this.menuDepth--; this.gameState = this.menuHistoryStack[this.menuDepth]; }
private final boolean loadRMS_sanGuoTd() { String var5 = "sanGuoTd"; ... }
```

## 八、v12 + v13 累计重命名统计

| 版本 | 替换类型 | 替换次数 |
|------|---------|---------|
| v12 | 字段名替换(带数字后缀) | 877 |
| v12 | 无参方法名替换(A-Z, aa-ay, e-z) | 456 |
| v12 | static 方法定义替换 | 30 |
| v12 | static 方法调用替换 | 6 |
| v13 | 字段声明替换(单字母) | 19 |
| v13 | 字段引用替换(单字母+双字母) | 172 |
| v13 | 方法定义替换(带参+无参非void) | 151 |
| v13 | 方法调用替换(上下文分析) | 9 |
| v13 | v12同名方法修复 | 4 |
| **总计** | | **1724** |

## 九、脚本文件清单

```
deobfuscated_modules_renamed/
├── v13_rename_remaining.py      # v13 主替换脚本
├── v13_fix_v12_issues.py        # v12同名方法修复脚本
├── v13_bytecode_verification_report.md  # 本报告
├── rename.ps1                   # v12 字段名替换脚本
├── rename_methods.ps1           # v12 方法名替换脚本
├── rename_static_methods.ps1    # v12 static方法替换脚本
├── rename_static_calls.ps1      # v12 static调用替换脚本
└── v12_rename_report.md         # v12 报告
```

## 十、后续建议

1. **方法调用替换覆盖率**: 当前方法调用替换(9处)覆盖率较低,因为大部分调用已在 v12 中替换。剩余的单字母方法调用可通过 IDE 重构功能完成。

2. **字段声明覆盖率**: 01_fields.java 中的 19 个单字母字段声明已替换。但部分字段声明可能因格式特殊(如 `private int a, b, c;`)未被匹配,建议在 IDE 中检查。

3. **TypeScript/H5 重制**: 
   - 所有关键方法已重命名,核心逻辑可读
   - 重命名后的代码可直接作为 H5 重制的参考
   - 字段映射表(10_rename_map.java)提供了完整的混淆名→语义名映射

**v13 累计完成 355 处替换,v12+v13 总计 1724 处替换,全部通过括号平衡验证。**
