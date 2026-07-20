# a_deobfuscated.java v1 问题报告与方法映射表

> 生成时间: 2026-07-19
> 基于: Vineflower 1.12.0 + javap (JDK 17) 字节码交叉验证

## 一、严重问题汇总

### 问题 1: 方法返回类型错误 (3处)

| 方法 | v1 标注 | 实际返回类型 | 证据 |
|------|---------|-------------|------|
| `b()` | `void updateGame()` | **`int`** | Vineflower L15768, javap L44520 |
| `c()` | `void checkLevelProgress()` | **`int`** | Vineflower L16889 |
| `d()` | `void updateTowers()` | **`int`** | Vineflower L17883, javap L49012 |

### 问题 2: 方法名与功能完全不匹配 (15+处)

| 方法 | v1 命名 | 实际功能 | 证据 |
|------|---------|---------|------|
| `C()` | renderMainMenu() | **RMS 存档保存** ("sanGuoTd") | VF L5620: `RecordStore.openRecordStore("sanGuoTd")` |
| `G()` | renderHelp() | **主帧更新逻辑** (状态机分发) | VF L7309: `switch(this.l)` + `c1020=false` |
| `O()` | renderGameOver() | **游戏状态更新** (aS/aR/aT) | VF L8518: `this.aS+1`, `this.R()` |
| `X()` | renderSprites() | **主游戏帧更新** | VF L9224: `this.O()`, `this.l(1)`, 胜利检查 |
| `f()` | updateEffects() | **进度条渲染** | VF L19628: `a1007>b1008`, `fillRect` |
| `g()` | updateEconomy() | **音量控制** | VF L20471: `h1047 switch`, `a1017.setLevel` |
| `n()` | drawTowers() | **滚动位置更新** | VF L23551: `u-=2`, `w-=2` |
| `p()` | drawHUD() | **背景清屏** | VF L23848: `setClip`, `fillRect`, `a1013[3][3]` |
| `u()` | uploadScore() | **阵营/武将选择状态机** | VF L25041: `n()`, `switch h1047` |
| `v()` | controlAudio() | **阵营选择渲染** | VF L25285: `b(ai,13)`, `a1013[3][3]` |
| `z()` | initGame() | **敌人移动更新** | VF L26684: `for(a1039)`, `switch [2]` |
| `d()` | updateTowers() | **HTTP通信** (int返回) | javap L49012: `HttpConnection`, `Connector.open` |
| `d(int)` | updateTower() | **背景卷轴绘制** | VF L18699: `a1013[4][6]`, `drawImage` |
| `c(int)` | spawnEnemy() | **精灵图加载** | VF L16985: `a1013[var1]`, `Image.createImage` |
| `b(int)` | updateEnemy() void | **敌人HP计算** (int返回) | VF L15818: `c1107[var1]`, `r1101` |

### 问题 3: 缺失的方法 (20+个)

以下方法在 v1 中完全未定义:

#### a() 系列
- `void a()` — 菜单返回 (m--, l=b[m])
- `void a(int)` — 菜单跳转 (b[m]=l, l=n, m++)
- `void a(int,int)` — 精灵图加载
- `int a(int,int,int,int)` — 距离/角度计算
- `boolean a()` — RMS 存档读取

#### b() 系列
- `int b(int,int)` — 瓦片坐标转换
- `String b(String)` — URL重写(代理)
- `void b()` — 菜单重置 (m=0)
- `void b(int)` — 菜单回退到指定状态
- `boolean b()` — RMS 存档读取("sanGuoTdData")
- `boolean b(int)` — 瓦片可建造检查

#### c() 系列
- `int c(int,int)` — 坐标边界检查
- `void c()` — 重置计数器 (aP=0, bt=0)
- `boolean c()` — RMS 存档读取("freeGame")
- `boolean c(int)` — 瓦片奇偶检查

#### d() 系列
- `int d(int)` — 瓦片类型转换
- `boolean d()` — 横屏标志检查
- `boolean d(int)` — 敌人路径检查

#### 其他
- `boolean e(int)` — 敌人检查
- `boolean f()` — 初始化
- `boolean f(int,int)` — 瓦片==10检查
- `boolean g()` — 网络上传
- `void h()` — 结局文字渲染
- `B() D() E() F() H() I() J() K() L() M() N() P() Q() R() S() T() U() V() Z()` 等渲染方法

### 问题 4: 方法体错误

| 方法 | v1 方法体问题 |
|------|---------------|
| `b()` | 标注为 void，实际应返回 int (bV值) |
| `c()` | 标注为 void，实际应返回 int (加载状态) |
| `d()` | 标注为 void + 建造菜单绘制，实际是 int + HTTP通信 |
| `b(int)` | 标注为 void，实际应返回 int (HP值) |
| `isGameOver()` f() | 标注为 boolean + return false，实际是 void + 进度条渲染 |
| `canAfford()` | 标注为 `f(int,int)`，实际是 `e(int,int)` |
| `readByteArray()` | 标注为 `a(int,byte[],int)` return 0，实际是 HP计算 |

### 问题 5: 方法重名冲突

v1 中有两个 `spawnEnemy` 方法:
- `spawnEnemy(int type)` — c(int) 精灵图加载
- `spawnEnemy(int x, int y, ...)` — a(int,int,int,byte,int,boolean) 瓦片填充

功能完全不同但名字相同，容易混淆。

### 问题 6: 字段引用错误

方法体中引用了 `this.B1171`, `this.c()`, `this.a1172`, `this.bV`, `this.b1018` 等，
但字段声明中使用的是语义名 (如 `isPaused`, `frameCounter`)，导致引用不存在的字段。

---

## 二、完整方法功能映射表

### J2ME 回调方法 (6个)

| 方法 | 功能 | v1 正确? |
|------|------|---------|
| `paint(Graphics)` | 渲染回调 | ✓ |
| `run()` | 游戏主循环 | ✓ |
| `keyPressed(int)` | 按键处理 | ✓ |
| `keyReleased(int)` | 按键释放 | ✓ |
| `showNotify()` | 显示通知 | ✓ |
| `hideNotify()` | 隐藏通知 | ✓ |

### A-Z 无参数方法 (26个)

| 方法 | 功能 | VF行号 | v1 命名 | v1 正确? |
|------|------|--------|---------|---------|
| `A()` | 渲染分发器 (switch l) | L4741 | renderLoading | ✓ |
| `B()` | 加载流程 (e/c调用链) | L5443 | renderLogo | ❌ |
| `C()` | **RMS 存档保存** | L5620 | renderMainMenu | ❌ |
| `D()` | **RMS 存档读取("sanGuoTdData")** | L6668 | renderBuildMenu | ❌ |
| `E()` | **RMS 存档读取("freeGame")** | L7035 | renderUpgradePanel | ❌ |
| `F()` | 循环处理(15次) | L7270 | renderSettings | ❌ |
| `G()` | **主帧更新逻辑** | L7309 | renderHelp | ❌ |
| `H()` | 调用 J()+I() | L7771 | (缺失) | ❌ |
| `I()` | 背景绘制 | L7784 | (缺失) | ❌ |
| `J()` | 滚动计算 | L7856 | renderLevelSelect | ❌ |
| `K()` | 关卡选择(switch aw) | L8146 | (缺失) | ❌ |
| `L()` | 输入处理(switch h1047) | L8219 | (缺失) | ❌ |
| `M()` | 科技树相关 | L8273 | renderTechTree | ❌ |
| `N()` | 遍历 E1163 数组 | L8469 | (缺失) | ❌ |
| `O()` | **游戏状态更新** | L8518 | renderGameOver | ❌ |
| `P()` | 武将选择(h1074) | L8568 | renderLevelComplete | ❌ |
| `Q()` | 武将选择(同P) | L8592 | renderVictory | ❌ |
| `R()` | 关卡推进(o1077) | L8633 | (缺失) | ❌ |
| `S()` | 渲染(r1086) | L8768 | (缺失) | ❌ |
| `T()` | 胜利检查(aT==aX) | L8868 | (缺失) | ❌ |
| `U()` | 初始化(aq,aw=0) | L8903 | (缺失) | ❌ |
| `V()` | 遍历 bf | L8955 | (缺失) | ❌ |
| `W()` | 地图主绘制 | L9023 | renderGameWorld | ✓ |
| `X()` | **主游戏帧更新** | L9224 | renderSprites | ❌ |
| `Y()` | 渲染(n1152,b1066) | L9590 | renderText | ❌ |
| `Z()` | 渲染(bn) | L9926 | (缺失) | ❌ |

### aa-az 方法 (26个)

| 方法 | 功能 | VF行号 | v1 命名 | v1 正确? |
|------|------|--------|---------|---------|
| `aa()` | ? | L13349 | (缺失) | ❌ |
| `ab()` | ? | L13419 | (缺失) | ❌ |
| `ac()` | ? | L13437 | (缺失) | ❌ |
| `ad()` | ? | L13492 | (缺失) | ❌ |
| `ae()` | ? | L13555 | (缺失) | ❌ |
| `af()` | ? | L13574 | (缺失) | ❌ |
| `ag()` | ? | L13592 | (缺失) | ❌ |
| `ah()` | ? | L13890 | (缺失) | ❌ |
| `ai()` | ? | L13975 | (缺失) | ❌ |
| `aj()` | ? | L14081 | (缺失) | ❌ |
| `ak()` | ? | L14159 | (缺失) | ❌ |
| `al()` | ? | L14456 | (缺失) | ❌ |
| `am()` | ? | L14691 | (缺失) | ❌ |
| `an()` | ? | L14739 | (缺失) | ❌ |
| `ao()` | 按键状态机(switch l) | L14790 | (缺失) | ❌ |
| `ap()` | 渲染(b1015[175]) | L14870 | (缺失) | ❌ |
| `aq()` | 输入处理(switch h1047) | L14936 | (缺失) | ❌ |
| `ar()` | 渲染(e(),setColor) | L15006 | (缺失) | ❌ |
| `as()` | 状态机(switch b1174) | L15082 | (缺失) | ❌ |
| `at()` | 设置b1174=1 | L15239 | (缺失) | ❌ |
| `au()` | 日历初始化 | L15244 | (缺失) | ❌ |
| `av()` | **VF失败** | L15268 | (缺失) | ❌ |
| `aw()` | **RMS读取("__sfSmsInfo")** | L15313 | (缺失) | ❌ |
| `ax()` | RMS写入("__sfSmsInfo") | L15473 | (缺失) | ❌ |
| `ay()` | 存档缓冲区处理 | L15744 | (缺失) | ❌ |
| `az()` | ? | (未确认) | (缺失) | ❌ |

### a() 系列方法 (20+个)

| 方法 | 功能 | VF行号 | v1 命名 | v1 正确? |
|------|------|--------|---------|---------|
| `int a()` | 随机数 0-255 | L9993 | nextRandom | ✓ |
| `int a(int)` | 瓦片属性 E1163[n]>>1 | L9997 | tileToScreenX | ✓ |
| `int a(int,int)` | 瓦片索引 | L10001 | tileToScreenY | ✓ |
| `int a(int,int,int)` | 角度计算(正切表) | L10009 | findPath | ✓ |
| `int a(int,int,int,int)` | 距离/角度 | L10074 | (缺失) | ❌ |
| `int a(int,byte[],int)` | **HP计算** | L10095 | readByteArray | ❌ |
| `String a(DataInputStream)` | 读取字符串 | L10142 | readString | ✓ |
| `String a(String)` | URL主机名提取 | L10170 | decodeString | ✓ |
| `short a(InputStream)` | 读取short | L10184 | readShort | ✓ |
| `void a()` | **菜单返回** | L10190 | (缺失) | ❌ |
| `void a(byte)` | setGameMode | L10199 | setGameMode | ✓ |
| `void a(int)` | **菜单跳转** | L10214 | (缺失) | ❌ |
| `void a(int,int)` | **精灵图加载** | L10225 | (缺失) | ❌ |
| `void a(int,int,int)` | ? | L10482 | (缺失) | ❌ |
| `void a(int,int,int,byte,int,boolean)` | 瓦片填充 | L10490 | spawnEnemy(6参) | ⚠️ |
| `void a(int,int,int,int)` | ? | L10573 | towerAttack | ? |
| `void a(int,int,int,int,int)` | 范围攻击渲染 | L10672 | areaAttack | ✓ |
| `boolean a()` | **RMS存档读取** | L12049 | (缺失) | ❌ |

### b() 系列方法 (8个)

| 方法 | 功能 | VF行号 | v1 命名 | v1 正确? |
|------|------|--------|---------|---------|
| `int b()` | 同步锁+返回bV | L15768 | updateGame(void) | ❌ |
| `int b(int)` | **敌人HP计算** | L15818 | updateEnemy(void) | ❌ |
| `int b(int,int)` | 瓦片坐标转换 | L15841 | (缺失) | ❌ |
| `String b(String)` | URL重写(代理) | L15923 | (缺失) | ❌ |
| `void b()` | 菜单重置(m=0) | L15941 | (缺失) | ❌ |
| `void b(int)` | 菜单回退 | L15945 | (缺失) | ❌ |
| `boolean b()` | RMS存档读取 | L16602 | (缺失) | ❌ |
| `boolean b(int)` | 瓦片可建造检查 | L16845 | (缺失) | ❌ |

### c() 系列方法 (6个)

| 方法 | 功能 | VF行号 | v1 命名 | v1 正确? |
|------|------|--------|---------|---------|
| `int c()` | 循环调用d() | L16889 | checkLevelProgress(void) | ❌ |
| `int c(int,int)` | 坐标边界检查 | L16925 | (缺失) | ❌ |
| `void c()` | 重置计数器 | L16979 | (缺失) | ❌ |
| `void c(int)` | **精灵图加载** | L16985 | spawnEnemy | ⚠️ |
| `boolean c()` | RMS存档读取 | L17696 | (缺失) | ❌ |
| `boolean c(int)` | 瓦片奇偶检查 | L17854 | (缺失) | ❌ |

### d() 系列方法 (6个)

| 方法 | 功能 | VF行号 | v1 命名 | v1 正确? |
|------|------|--------|---------|---------|
| `int d()` | **HTTP通信** | L17883 | updateTowers(void) | ❌ |
| `int d(int)` | 瓦片类型转换 | L18640 | (缺失) | ❌ |
| `void d()` | 建造菜单背景 | L18667 | (混入updateTowers) | ❌ |
| `void d(int)` | 背景卷轴绘制 | L18699 | updateTower | ❌ |
| `boolean d()` | 横屏标志检查 | L19041 | (缺失) | ❌ |
| `boolean d(int)` | 敌人路径检查 | L19056 | (缺失) | ❌ |

### e() f() g() 系列

| 方法 | 功能 | VF行号 | v1 命名 | v1 正确? |
|------|------|--------|---------|---------|
| `void e()` | 清屏 | L19257 | clearScreen | ✓ |
| `boolean e()` | 科技树全解锁 | L19432 | isLevelComplete | ✓ |
| `boolean e(int)` | 敌人检查 | L19455 | (缺失) | ❌ |
| `boolean e(int,int)` | 瓦片==8检查 | L19613 | canAfford | ⚠️ |
| `void f()` | **进度条渲染** | L19628 | updateEffects | ❌ |
| `boolean f()` | 初始化 | L20430 | isGameOver | ❌ |
| `boolean f(int,int)` | 瓦片==10检查 | L20456 | (缺失) | ❌ |
| `void g()` | **音量控制** | L20471 | updateEconomy | ❌ |
| `boolean g()` | 网络上传 | L21114 | (缺失) | ❌ |

### h-z 方法

| 方法 | 功能 | VF行号 | v1 命名 | v1 正确? |
|------|------|--------|---------|---------|
| `void h()` | 结局文字渲染 | L21381 | (缺失) | ❌ |
| `void i()` | 输入处理 | L21989 | handleInput | ✓ |
| `void l()` | 地图绘制 | L22601 | drawMap | ✓ |
| `void m()` | 敌人移动状态机 | L22984 | drawEnemies | ⚠️ |
| `void n()` | **滚动位置更新** | L23551 | drawTowers | ❌ |
| `void p()` | **背景清屏** | L23848 | drawHUD | ❌ |
| `void q()` | 渲染 | L23981 | drawMenu | ✓ |
| `void s()` | 存档面板 | L24545 | saveGame | ✓ |
| `void t()` | 存档加载 | L24708 | loadGame | ✓ |
| `void u()` | **阵营选择状态机** | L25041 | uploadScore | ❌ |
| `void v()` | **阵营选择渲染** | L25285 | controlAudio | ❌ |
| `void y()` | 地图渲染 | L26190 | loadMap | ✓ |
| `void z()` | **敌人移动更新** | L26684 | initGame | ❌ |

---

## 三、统计

- **总方法数**: ~120+ (含重载)
- **v1 正确的方法**: ~15个 (12%)
- **v1 错误的方法**: ~45个 (37%)
- **v1 缺失的方法**: ~60个 (50%)
- **Vineflower 失败的方法**: 5个 (b/d/av/aw + 1个)

## 四、结论

v1 版本的 a_deobfuscated.java 存在**系统性错误**:
1. 方法名语义化推断不准确，导致大量命名错误
2. 返回类型错误 (b/c/d 系列)
3. 缺失方法过多 (60+个)
4. 方法体来源不可靠

**建议**: 完全重写为 v2 版本，保留原始方法名，基于 Vineflower 准确输出。
