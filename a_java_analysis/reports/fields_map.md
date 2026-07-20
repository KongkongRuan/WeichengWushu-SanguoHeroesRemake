# 字段映射表 (a.java 混淆名 → 语义名)

> 本表基于字段类型、初始化代码、使用上下文进行的语义推断。
> 可靠性标注: ★★★★★(确定) / ★★★★☆(高可信) / ★★★☆☆(推测)

---

## 1. 静态字段

| 混淆名 | 类型 | 语义名 | 可靠性 | 说明 |
|--------|------|--------|--------|------|
| `a1001` | `public static final int[]` | `DIRECT_GRAPHICS_FLAGS` | ★★★★★ | DirectGraphics.drawImage 的旋转参数(8个: 0,8192,16384,24576,8462,270,90,8282) |
| `c1045` | `private static String[]` | `MIDI_FILE_NAMES` | ★★★★★ | MIDI 音乐路径: "/0.mid" ~ "/14.mid" (15首) |

## 2. 核心游戏数据数组 (final, 构造函数初始化)

| 混淆名 | 类型 | 语义名 | 可靠性 | 说明 |
|--------|------|--------|--------|------|
| `d1011` | `final int[]` | `COLORS` | ★★★★★ | 颜色常量(5个), 用于 setColor() |
| `a1014` | `final String[]` | `RESOURCE_PATHS` | ★★★★★ | 资源文件路径(39个: /mu, /sflogo, /ld, /ui, /back, /map0-6, /e0-5, /t0-10, /bu, /s, /h, /sp, /end, /sp0-3, /eff) |
| `b1015` | `final String[]` | `GAME_TEXTS` | ★★★★★ | 游戏文本数组(181条), 包含所有中文文本 |
| `c1051` | `final byte[][]` | `TOWER_BUILD_PATHS` | ★★★★☆ | 塔建造路径(5条), 每条4个元素 |
| `a1052` | `final short[][]` | `TECH_BRANCHES` | ★★★★★ | 科技树分支(7条), 分支顶点=武将觉醒 |
| `d1053` | `final byte[][]` | `LEVEL_SEQUENCES` | ★★★★★ | 关卡序列(8条: 故事/自由/4阵营结局路径) |
| `e1054` | `final byte[]` | `LEVEL_CONFIG` | ★★★★☆ | 关卡配置(9个参数) |
| `f1055` | `final byte[]` | `TOWER_LEVEL_LIMITS` | ★★★★★ | 塔等级限制(17个), -1=不可升级 |
| `g1057` | `final byte[]` | `UPGRADE_COSTS` | ★★★★★ | 升级费用(5级: 20,40,60,80,100) |
| `o1098` | `final byte[]` | `ENEMY_COUNT_PER_LEVEL` | ★★★★★ | 每关生成点数量(11关) |
| `p1099` | `final byte[]` | `MULTI_PATH_FLAG` | ★★★★★ | 多路径标志(11关, 0=单路径, 1=多路径) |
| `q1100` | `final byte[]` | `KILL_REWARD` | ★★★★★ | 击杀奖励金币(11关) |
| `r1101` | `final byte[]` | `ENEMY_HP_DATA` | ★★★★★ | 敌人HP系数(22字节=11对 base/slope) |
| `s1102` | `final byte[]` | `ALT_HP_DATA` | ★★★★☆ | 备用HP系数(22字节), 用途待确认 |
| `t1103` | `final byte[]` | `TOWER_DAMAGE_DATA` | ★★★★★ | 塔伤害/射程数据(22字节=11对 damage/range) |
| `u1104` | `final byte[]` | `TOWER_SPEED_DATA` | ★★★★★ | 塔攻速/效果数据(22字节=11对 speed/effect) |
| `v1109` | `final byte[]` | `TOWER_LEVELS_INIT` | ★★★★☆ | 塔初始等级(5个: 6,4,3,2,1) |
| `w1110` | `final byte[]` | `ENCRYPT_KEY` | ★★★☆☆ | 加密密钥?(8字节负数), 用途待确认 |
| `w1123` | `final byte[][]` | `ENEMY_PATH_SEQUENCES` | ★★★★☆ | 敌人路径动画序列(三维数组, 11关×多段×4字节) |
| `x1124` | `final byte[]` | `X_OFFSETS` | ★★★☆☆ | X偏移表(10个), 用于精灵图绘制偏移 |
| `y1125` | `final byte[]` | `Y_OFFSETS` | ★★★☆☆ | Y偏移表(16个), 用于精灵图绘制偏移 |
| `x1128` | `final byte[][]` | `DIRECTION_VECTORS` | ★★★★☆ | 方向向量(4×2: 上下左右) |
| `y1130` | `final byte[][]` | `HERO_SORT_ORDER` | ★★★★☆ | 武将排序(3阵营×11人) |
| `c1107` | `int[][]` | `ENEMY_SLOTS` | ★★★★★ | 敌人槽位数组(30×18), 非final,运行时修改 |

## 3. 三维字节数组 (疑似地图/精灵数据)

| 混淆名 | 类型 | 语义名 | 可靠性 | 说明 |
|--------|------|--------|--------|------|
| `a1067` | `final byte[][][]` | `MAP_DATA_A` | ★★★☆☆ | 地图数据组A |
| `b1085` | `final byte[][][]` | `MAP_DATA_B` | ★★★☆☆ | 地图数据组B |
| `c1090` | `final byte[][][]` | `MAP_DATA_C` | ★★★☆☆ | 地图数据组C |
| `d1091` | `final byte[][][]` | `MAP_DATA_D` | ★★★☆☆ | 地图数据组D |
| `e1093` | `final byte[][][]` | `MAP_DATA_E` | ★★★☆☆ | 地图数据组E |
| `f1112` | `final byte[][][]` | `MAP_DATA_F` | ★★★☆☆ | 地图数据组F |
| `g1113` | `final byte[][][]` | `MAP_DATA_G` | ★★★☆☆ | 地图数据组G |
| `h1121` | `final byte[][][]` | `MAP_DATA_H` | ★★★☆☆ | 地图数据组H |
| `i1122` | `final byte[][][]` | `SPRITE_OFFSETS` | ★★★★☆ | 精灵图偏移数据(在 a(Image,...) 中使用) |
| `j1139` | `final byte[][][]` | `MAP_DATA_J` | ★★★☆☆ | 地图数据组J |
| `k1141` | `final byte[][][]` | `MAP_DATA_K` | ★★★☆☆ | 地图数据组K |
| `l1143` | `final byte[][][]` | `MAP_DATA_L` | ★★★☆☆ | 地图数据组L |
| `m1150` | `final byte[][][]` | `MAP_DATA_M` | ★★★☆☆ | 地图数据组M |
| `a1092` | `final short[][][][]` | `MAP_DATA_SHORT` | ★★★☆☆ | 四维short数组(地图?) |

## 4. 二维字节数组 (疑似关卡/路径数据)

| 混淆名 | 类型 | 语义名 | 可靠性 | 说明 |
|--------|------|--------|--------|------|
| `A1132` | `final byte[][]` | `LEVEL_DATA_A` | ★★★☆☆ | 关卡数据组A |
| `B1133` | `final byte[][]` | `LEVEL_DATA_B` | ★★★☆☆ | 关卡数据组B |
| `C1134` | `byte[][]` | `LEVEL_DATA_C` | ★★★☆☆ | 关卡数据组C |
| `D1135` | `final byte[][]` | `LEVEL_DATA_D` | ★★★☆☆ | 关卡数据组D |
| `E1136` | `final byte[][]` | `LEVEL_DATA_E` | ★★★☆☆ | 关卡数据组E |
| `F1137` | `final byte[][]` | `LEVEL_DATA_F` | ★★★☆☆ | 关卡数据组F |
| `G1138` | `final byte[][]` | `LEVEL_DATA_G` | ★★★☆☆ | 关卡数据组G |
| `H1140` | `final byte[][]` | `LEVEL_DATA_H` | ★★★☆☆ | 关卡数据组H |
| `I1142` | `final byte[][]` | `LEVEL_DATA_I` | ★★★☆☆ | 关卡数据组I |
| `J1144` | `final byte[][]` | `LEVEL_DATA_J` | ★★★☆☆ | 关卡数据组J |
| `K1145` | `final byte[][]` | `LEVEL_DATA_K` | ★★★☆☆ | 关卡数据组K |
| `L1146` | `final byte[][]` | `LEVEL_DATA_L` | ★★★☆☆ | 关卡数据组L |
| `M1147` | `final byte[][]` | `LEVEL_DATA_M` | ★★★☆☆ | 关卡数据组M |
| `N1149` | `final byte[][]` | `LEVEL_DATA_N` | ★★★☆☆ | 关卡数据组N |
| `O1156` | `final byte[][]` | `LEVEL_DATA_O` | ★★★☆☆ | 关卡数据组O |
| `P1157` | `final byte[][]` | `LEVEL_DATA_P` | ★★★☆☆ | 关卡数据组P |
| `Q1159` | `final byte[][]` | `LEVEL_DATA_Q` | ★★★☆☆ | 关卡数据组Q |
| `z1131` | `final byte[][]` | `LEVEL_DATA_Z` | ★★★☆☆ | 关卡数据组Z |

## 5. 一维字节数组 (疑似瓦片/属性数据)

| 混淆名 | 类型 | 语义名 | 可靠性 | 说明 |
|--------|------|--------|--------|------|
| `A1151` | `final byte[]` | `TILE_DATA_A` | ★★★☆☆ | 瓦片数据A |
| `B1160` | `byte[]` | `TILE_DATA_B` | ★★★☆☆ | 瓦片数据B |
| `C1161` | `byte[]` | `TILE_DATA_C` | ★★★☆☆ | 瓦片数据C |
| `D1162` | `byte[]` | `TILE_DATA_D` | ★★★☆☆ | 瓦片数据D |
| `E1163` | `byte[]` | `TILE_DATA_E` | ★★★☆☆ | 瓦片数据E (在 a(int,int,int,boolean) 中修改) |
| `F1164` | `byte[]` | `TILE_DATA_F` | ★★★☆☆ | 瓦片数据F |
| `G1165` | `byte[]` | `TILE_DATA_G` | ★★★☆☆ | 瓦片数据G |
| `H1188` | `byte[]` | `TILE_DATA_H` | ★★★☆☆ | 瓦片数据H |
| `I1189` | `byte[]` | `TILE_DATA_I` | ★★★☆☆ | 瓦片数据I |
| `d1050` | `final byte[]` | `TILE_DATA_D0` | ★★★☆☆ | 瓦片数据D0 |
| `c1037` | `final byte[]` | `TILE_DATA_C0` | ★★★☆☆ | 瓦片数据C0 |
| `a1027` | `final byte[]` | `TILE_DATA_A0` | ★★★☆☆ | 瓦片数据A0 |
| `b1034` | `final byte[]` | `TILE_DATA_B0` | ★★★☆☆ | 瓦片数据B0 |
| `l1072` | `final byte[]` | `TILE_DATA_L0` | ★★★☆☆ | 瓦片数据L0 |
| `m1075` | `final byte[]` | `TILE_DATA_M0` | ★★★☆☆ | 瓦片数据M0 |
| `n1076` | `final byte[]` | `TILE_DATA_N0` | ★★★☆☆ | 瓦片数据N0 |
| `k1068` | `final byte[]` | `TILE_DATA_K0` | ★★★☆☆ | 瓦片数据K0 |
| `i1062` | `final byte[]` | `TILE_DATA_I0` | ★★★☆☆ | 瓦片数据I0 |
| `j1064` | `final byte[]` | `TILE_DATA_J0` | ★★★☆☆ | 瓦片数据J0 |
| `h1060` | `final byte[]` | `TILE_DATA_H0` | ★★★☆☆ | 瓦片数据H0 |
| `z1148` | `final byte[]` | `TILE_DATA_Z0` | ★★★☆☆ | 瓦片数据Z0 |

## 6. 渲染相关字段

| 混淆名 | 类型 | 语义名 | 可靠性 | 说明 |
|--------|------|--------|--------|------|
| `a` | `final Font` | `gameFont` | ★★★★★ | Font.getFont(32, 0, 8) — SIZE_SMALL, STYLE_PLAIN |
| `a1002` | `Graphics` | `graphics` | ★★★★★ | J2ME Graphics 上下文 |
| `a1004` | `Image` | `backbuffer` | ★★★★☆ | 后台缓冲图像(双缓冲) |
| `a1005` | `DirectGraphics` | `directGraphics` | ★★★★★ | Nokia DirectGraphics(旋转绘制) |
| `b1003` | `Graphics` | `graphicsB` | ★★★★☆ | 第二 Graphics 上下文 |
| `b1006` | `DirectGraphics` | `directGraphicsB` | ★★★★☆ | 第二 DirectGraphics |
| `a1013` | `Image[][]` | `spriteImages` | ★★★★★ | 精灵图二维数组(39类×多帧) |
| `a1040` | `Image[]` | `backgroundImages` | ★★★★☆ | 背景图片数组 |
| `b1032` | `Image` | `logoImage` | ★★★☆☆ | Logo图片 |
| `j` | `final int` | `fontHeight` | ★★★★★ | 字体高度 = gameFont.getHeight() |
| `k` | `final int` | `charWidth` | ★★★★★ | 字符宽度 = gameFont.charWidth('口') |
| `n` | `int` | `lineHeight` | ★★★★★ | 行高 = fontHeight + 2 |
| `V` | `final int` | `SCREEN_WIDTH` | ★★★★★ | 屏幕宽度 (240) |
| `W` | `final int` | `SCREEN_HEIGHT` | ★★★★★ | 屏幕高度 (320) |
| `ad` | `final int` | `TILE_SIZE` | ★★★★☆ | 瓦片大小 |
| `ah` | `final int` | `MAP_COLS` | ★★★★☆ | 地图列数 |
| `ai` | `final int` | `MAP_ROWS` | ★★★★☆ | 地图行数 |
| `aj` | `final int` | `MAP_TILE_COUNT` | ★★★★☆ | 地图瓦片总数 |

## 7. 游戏状态字段

| 混淆名 | 类型 | 语义名 | 可靠性 | 说明 |
|--------|------|--------|--------|------|
| `a1007` | `public int` | `gameState` | ★★★★★ | 游戏状态(0=加载, 1=菜单, 2=游戏中...) |
| `b1008` | `public int` | `subState` | ★★★★☆ | 子状态 |
| `c` | `public int` | `cursorX` | ★★★★☆ | 光标X位置 |
| `d` | `public int` | `cursorY` | ★★★★☆ | 光标Y位置 |
| `a1019` | `public long` | `frameCounter` | ★★★★★ | 帧计数器(游戏主循环用) |
| `a1012` | `Random` | `random` | ★★★★★ | 随机数生成器 |
| `a1009` | `String` | `scrollingText` | ★★★★☆ | 滚动文本缓存 |
| `a1038` | `byte` | `currentLevel` | ★★★★☆ | 当前关卡索引 |
| `b1174` | `byte` | `currentFaction` | ★★★★☆ | 当前阵营(0=蜀,1=魏,2=吴,3=群) |
| `c1190` | `byte` | `gameMode` | ★★★★☆ | 游戏模式(故事/自由) |
| `a1016` | `boolean` | `isRunning` | ★★★★☆ | 游戏运行标志 |
| `b1018` | `boolean` | `isPaused` | ★★★★☆ | 暂停标志 |
| `e1025` | `public int` | `gold` | ★★★★★ | 金币 |
| `f1026` | `public int` | `cityDefense` | ★★★★★ | 城防值(HP) |
| `g1046` | `public int` | `levelIndex` | ★★★★☆ | 关卡序列索引 |
| `h1047` | `public int` | `waveNumber` | ★★★★☆ | 波次号 |
| `i1048` | `public int` | `killCount` | ★★★★☆ | 击杀计数 |
| `l` | `int` | `menuIndex` | ★★★★☆ | 菜单选中项 |
| `m` | `int` | `buildMenuIndex` | ★★★★☆ | 建造菜单选中项 |
| `c1010` | `int[]` | `scoreHistory` | ★★★☆☆ | 分数历史(200个) |
| `e` | `int[]` | `levelData` | ★★★☆☆ | 关卡数据(21个) |
| `b` | `int[]` | `tempData` | ★★★☆☆ | 临时数据(10个) |

## 8. 布尔状态标志

| 混淆名 | 类型 | 语义名 | 可靠性 | 说明 |
|--------|------|--------|--------|------|
| `a1016` | `boolean` | `isRunning` | ★★★★☆ | 游戏运行中 |
| `b1018` | `boolean` | `isPaused` | ★★★★☆ | 已暂停 |
| `c1020` | `boolean` | `soundEnabled` | ★★★★☆ | 音效开启 |
| `d1021` | `boolean` | `musicEnabled` | ★★★★☆ | 音乐开启 |
| `e1022` | `boolean` | `vibrationEnabled` | ★★★☆☆ | 震动开启 |
| `f1023` | `boolean` | `autoSaveEnabled` | ★★★☆☆ | 自动存档 |
| `g` | `boolean` | `flagG` | ★★☆☆☆ | 未知标志 |
| `h` | `boolean` | `flagH` | ★★☆☆☆ | 未知标志 |
| `i` | `boolean` | `flagI` | ★★☆☆☆ | 未知标志 |
| `A1170` | `boolean` | `flagA1170` | ★★☆☆☆ | 未知标志 |
| `B1171` | `boolean` | `flagB1171` | ★★☆☆☆ | 未知标志 |
| `C1175` | `boolean` | `flagC1175` | ★★☆☆☆ | 未知标志 |
| `D1176` | `boolean` | `flagD1176` | ★★☆☆☆ | 未知标志 |
| `E1179` | `boolean` | `flagE1179` | ★★☆☆☆ | 未知标志 |
| `F1180` | `boolean` | `flagF1180` | ★★☆☆☆ | 未知标志 |
| `G1182` | `boolean` | `flagG1182` | ★★☆☆☆ | 未知标志 |
| `y1155` | `boolean` | `flagY1155` | ★★☆☆☆ | 未知标志 |
| `z1169` | `boolean` | `flagZ1169` | ★★☆☆☆ | 未知标志 |
| `w1111` | `boolean` | `flagW1111` | ★★☆☆☆ | 未知标志 |
| `x1126` | `boolean` | `flagX1126` | ★★☆☆☆ | 未知标志 |
| `c1061` | `final boolean[]` | `UNLOCK_FLAGS` | ★★★☆☆ | 解锁标志(5个) |
| `d1073` | `boolean[]` | `levelFlags` | ★★★☆☆ | 关卡标志 |
| `e1105` | `boolean[]` | `levelComplete` | ★★★☆☆ | 关卡完成标志(11个) |
| `f1106` | `boolean[]` | `levelUnlocked` | ★★★☆☆ | 关卡解锁标志(11个) |
| `a1056` | `boolean[]` | `techUnlocked` | ★★★☆☆ | 科技解锁标志(5个) |
| `b1059` | `boolean[]` | `heroAwakened` | ★★★☆☆ | 武将觉醒标志 |
| `a1127` | `boolean[][]` | `buildableFlags` | ★★★☆☆ | 可建造标志(二维) |

## 9. 音频字段

| 混淆名 | 类型 | 语义名 | 可靠性 | 说明 |
|--------|------|--------|--------|------|
| `a1043` | `Player[]` | `midiPlayers` | ★★★★★ | MIDI 播放器数组 |
| `a1017` | `VolumeControl` | `volumeControl` | ★★★★★ | 音量控制 |
| `a1042` | `InputStream[]` | `midiStreams` | ★★★★☆ | MIDI 输入流数组 |

## 10. 网络/存档字段

| 混淆名 | 类型 | 语义名 | 可靠性 | 说明 |
|--------|------|--------|--------|------|
| `a1193` | `public HttpConnection` | `httpConnection` | ★★★★★ | HTTP连接(上传分数) |
| `a1191` | `ByteArrayOutputStream` | `saveBuffer` | ★★★★★ | 存档缓冲区 |
| `a1172` | `Object` | `saveData` | ★★★☆☆ | 存档数据对象 |
| `a1184` | `Date` | `saveDate` | ★★★☆☆ | 存档日期 |
| `a1185` | `Calendar` | `calendar` | ★★★☆☆ | 日历实例 |

## 11. 武将/科技相关字段

| 混淆名 | 类型 | 语义名 | 可靠性 | 说明 |
|--------|------|--------|--------|------|
| `a1087` | `short[]` | `techLevels` | ★★★★☆ | 科技等级数组 |
| `d1173` | `final String[]` | `heroNames` | ★★★☆☆ | 武将名数组 |
| `c1178` | `String` | `currentHeroName` | ★★★☆☆ | 当前武将名 |
| `d1181` | `String` | `factionName` | ★★★☆☆ | 阵营名 |
| `e1183` | `String` | `levelName` | ★★★☆☆ | 关卡名 |
| `f1186` | `String` | `statusMessage` | ★★★☆☆ | 状态消息 |
| `g1187` | `String` | `heroVoice` | ★★★☆☆ | 武将语音文本 |
| `h1192` | `String` | `errorMessage` | ★★★☆☆ | 错误消息 |
| `b1177` | `String` | `menuTitle` | ★★★☆☆ | 菜单标题 |

## 12. 单字母 int 字段 (游戏状态变量)

以下字段为游戏运行时状态变量,类型均为 `int`:

### 12.1 基础状态 (a-z)

| 混淆名 | 语义名 | 可靠性 | 说明 |
|--------|--------|--------|------|
| `c` | `cursorX` | ★★★★☆ | 光标/选中X坐标 |
| `d` | `cursorY` | ★★★★☆ | 光标/选中Y坐标 |
| `e[]` | `levelProgress` | ★★★☆☆ | 关卡进度数组(21个) |
| `l` | `menuIndex` | ★★★★☆ | 菜单索引 |
| `m` | `buildMenuIndex` | ★★★★☆ | 建造菜单索引 |
| `o` | `selectedTower` | ★★★☆☆ | 选中塔索引 |
| `p` | `selectedTile` | ★★★☆☆ | 选中瓦片 |
| `q` | `goldTemp` | ★★★☆☆ | 临时金币 |
| `r` | `enemyCount` | ★★★☆☆ | 敌人数量 |
| `s` | `spawnedCount` | ★★★☆☆ | 已生成数量 |
| `t` | `killedCount` | ★★★☆☆ | 已击杀数量 |
| `u` | `escapedCount` | ★★★☆☆ | 逃脱数量 |
| `v` | `waveTotal` | ★★★☆☆ | 波次总数 |
| `w` | `waveCurrent` | ★★★☆☆ | 当前波次 |
| `x` | `tileX` | ★★★☆☆ | 瓦片X |
| `y` | `tileY` | ★★★☆☆ | 瓦片Y |
| `z` | `zoomLevel` | ★★★☆☆ | 缩放级别 |

### 12.2 扩展状态 (aA-aZ, bA-bZ, ...)

约 78 个单字母扩展字段(`aA`-`aZ`, `bA`-`bZ`, `ca`, `cb`),具体语义需要通过方法体分析逐一确认。
这些字段大多为临时计算变量或游戏子状态。

---

## 附注

1. **可靠性说明**:
   - ★★★★★: 从初始化代码或使用模式中直接确认
   - ★★★★☆: 通过多处使用上下文高度可信推断
   - ★★★☆☆: 基于类型和位置推测,需进一步验证
   - ★★☆☆☆: 仅知类型,语义完全未知

2. **三维数组说明**: `a1067`-`m1150` 系列三维字节数组可能是不同关卡的地图数据,每个数组对应一种地图层级(地形层、碰撞层、装饰层等)。具体对应关系需要通过 `y()` 方法(资源加载)分析确认。

3. **更新策略**: 随着对方法体的深入分析,字段语义名会持续更新。建议在确认某字段语义后,更新本表并提升可靠性评级。
