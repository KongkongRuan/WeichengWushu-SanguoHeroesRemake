/**
 * ============================================================================
 *  模块 10: 重命名映射表 (v12)
 * ============================================================================
 *
 *  本文件记录了所有混淆名 → 语义名的映射关系
 *  用于批量重命名 deobfuscated_modules/ → deobfuscated_modules_renamed/
 *
 *  命名规范:
 *    - 字段: camelCase, 基于已恢复的语义注释
 *    - 方法: camelCase, 基于已恢复的功能
 *    - 重载方法: 名字后加参数数量后缀(如 _4P 表示4参数),或用语义区分
 *    - 未知功能方法: 用 helper/render/draw 等通用前缀 + TODO 注释
 *
 *  原始文件保留在 deobfuscated_modules/ 不修改
 *  重命名后的文件在 deobfuscated_modules_renamed/
 * ============================================================================
 */

/**
 * ============================================================================
 * A. 字段映射表 (共 ~155 个)
 * ============================================================================
 *
 * ┌──────────────┬───────────────────────────────┬─────────────────────────────┐
 * │ 混淆名        │ 语义名                          │ 说明                         │
 * ├──────────────┼───────────────────────────────┼─────────────────────────────┤
 * │ a            │ gameFont                       │ 游戏字体                     │
 * │ a1002        │ graphicsCtx                    │ J2ME Graphics 上下文         │
 * │ a1004        │ backBufferImage                │ 双缓冲后台图像               │
 * │ a1005        │ directGraphics                 │ Nokia DirectGraphics         │
 * │ b1003        │ secondGraphics                 │ 第二 Graphics                │
 * │ b1006        │ secondDirectGraphics           │ 第二 DirectGraphics          │
 * │ b1032        │ logoImage                      │ Logo 图片                    │
 * │ a1013        │ spriteImages                   │ 精灵图二维数组 39类×多帧     │
 * │ a1040        │ backgroundImages               │ 背景图片数组                 │
 * │ a1038        │ mapLayerCount                  │ 地图层计数                   │
 * │ a1039        │ mapLayerData                   │ 地图层数据                   │
 * │ j            │ fontHeight                     │ 字体高度                     │
 * │ k            │ charWidth                      │ 字符宽度                     │
 * │ n            │ lineHeight                     │ 行高                         │
 * │ V            │ screenWidth                    │ 屏幕宽度                     │
 * │ W            │ screenHeight                   │ 屏幕高度                     │
 * │ ad           │ tileSize                       │ 瓦片大小                     │
 * │ ah           │ mapCols                        │ 地图列数                     │
 * │ ai           │ mapRows                        │ 地图行数                     │
 * │ aj           │ mapColsExtended                │ 扩展列数                     │
 * │ a1007        │ frameCounter                   │ 帧计数/游戏状态              │
 * │ b1008        │ targetFrame                    │ 目标帧/子状态                │
 * │ a1019        │ totalFrameCount                │ 总帧计数器                   │
 * │ a1009        │ scrollTextCache                │ 滚动文本缓存                 │
 * │ a1012        │ random                         │ 随机数生成器                 │
 * │ a1016        │ isRunning                      │ 游戏运行标志                 │
 * │ b1018        │ isPaused                       │ 暂停标志                     │
 * │ c1020        │ soundEnabled                   │ 音效开启                     │
 * │ d1021        │ musicEnabled                   │ 音乐开启                     │
 * │ e1022        │ vibrationEnabled               │ 震动开启                     │
 * │ f1023        │ autoSave                       │ 自动存档                     │
 * │ g            │ flagG                          │ 布尔标志G                    │
 * │ h            │ flagH                          │ 布尔标志H                    │
 * │ i            │ flagI                          │ 布尔标志I                    │
 * │ j1024        │ flagJ1024                      │ 布尔标志                     │
 * │ k1029        │ flagK1029                      │ 布尔标志                     │
 * │ l1031        │ isPausedInGame                 │ 游戏内暂停                   │
 * │ m1033        │ sceneMode                      │ 场景模式标志                 │
 * │ n1036        │ flagN1036                      │ 布尔标志                     │
 * │ s1088        │ isLandscape                    │ 横屏标志                     │
 * │ t1089        │ flagT1089                      │ 布尔标志                     │
 * │ u1096        │ isTouch                        │ 触摸标志                     │
 * │ v1097        │ flagV1097                      │ 布尔标志                     │
 * │ w1111        │ flagW1111                      │ 布尔标志                     │
 * │ x1126        │ flagX1126                      │ 布尔标志                     │
 * │ y1155        │ flagY1155                      │ 布尔标志                     │
 * │ z1169        │ flagZ1169                      │ 布尔标志                     │
 * │ l            │ gameState                      │ 当前游戏状态(核心状态机)     │
 * │ m            │ menuDepth                      │ 菜单栈深度                   │
 * │ b            │ menuHistoryStack               │ 菜单历史栈                   │
 * │ o            │ selectedTowerIdx               │ 选中塔索引(-1=未选中)        │
 * │ p            │ progressBarWidth               │ 进度条宽度                   │
 * │ q            │ volume                         │ 音量值                       │
 * │ r            │ enemyCount                     │ 敌人数量                     │
 * │ s            │ frameTimeStats                 │ 帧耗时统计                   │
 * │ t            │ bgScrollOffset                 │ 背景偏移                     │
 * │ u            │ scrollX                        │ 滚动位置X                    │
 * │ v            │ scrollY                        │ 滚动位置Y                    │
 * │ w            │ scrollY2                       │ 滚动位置Y2                   │
 * │ x            │ posX                           │ 位置X                        │
 * │ y            │ posY                           │ 位置Y                        │
 * │ z            │ posZ                           │ 位置/状态Z                   │
 * │ A            │ tmpA                           │ 临时状态A                    │
 * │ B            │ tmpB                           │ 临时状态B                    │
 * │ C            │ tmpC                           │ 临时状态C                    │
 * │ D            │ tmpD                           │ 临时状态D                    │
 * │ E            │ tmpE                           │ 临时状态E                    │
 * │ F            │ tmpF                           │ 临时状态F                    │
 * │ G            │ tmpG                           │ 临时状态G                    │
 * │ H            │ tmpH                           │ 临时状态H                    │
 * │ I            │ tmpI                           │ 临时状态I                    │
 * │ J            │ tmpJ                           │ 临时状态J                    │
 * │ K            │ tmpK                           │ 临时状态K                    │
 * │ L            │ tmpL                           │ 临时状态L                    │
 * │ M            │ menuState                      │ 菜单状态                     │
 * │ N            │ tmpN                           │ 临时状态N                    │
 * │ O            │ tmpO                           │ 临时状态O                    │
 * │ P            │ tmpP                           │ 临时状态P                    │
 * │ Q            │ tmpQ                           │ 临时状态Q                    │
 * │ R            │ tmpR                           │ 临时状态R                    │
 * │ S            │ tmpS                           │ 临时状态S                    │
 * │ T            │ tmpT                           │ 临时状态T                    │
 * │ U            │ stateMachineU                  │ 状态机U                      │
 * │ X            │ currentGeneralIdx              │ 当前武将索引                 │
 * │ Y            │ tmpY                           │ 临时状态Y                    │
 * │ Z            │ tmpZ                           │ 临时状态Z                    │
 * │ c            │ cursorX                        │ 光标X                        │
 * │ d            │ cursorY                        │ 光标Y                        │
 * │ e            │ levelProgress                  │ 关卡进度                     │
 * │ c1010        │ scoreHistory                   │ 分数历史                     │
 * │ aA           │ stateA                         │ 状态aA                       │
 * │ aB           │ stateB                         │ 状态aB                       │
 * │ aC           │ stateC                         │ 状态aC                       │
 * │ aD           │ stateD                         │ 状态aD                       │
 * │ aE           │ stateE                         │ 状态aE                       │
 * │ aF           │ stateF                         │ 状态aF                       │
 * │ aG           │ mapColsG                       │ 地图列数(bG)                 │
 * │ aH           │ stateH                         │ 状态aH                       │
 * │ aI           │ stateI                         │ 状态aI                       │
 * │ aJ           │ stateJ                         │ 状态aJ                       │
 * │ aK           │ stateK                         │ 状态aK                       │
 * │ aL           │ stateL                         │ 状态aL                       │
 * │ aM           │ stateM                         │ 状态aM                       │
 * │ aN           │ generalIdxN                    │ 武将索引N                    │
 * │ aO           │ generalIdxO                    │ 武将索引O                    │
 * │ aP           │ activeTowerCount               │ 活跃塔数量                   │
 * │ aQ           │ stateQ                         │ 状态aQ                       │
 * │ aR           │ stateR                         │ 状态aR                       │
 * │ aS           │ stateS                         │ 状态aS                       │
 * │ aT           │ currentTurn                    │ 当前回合                     │
 * │ aU           │ stateU                         │ 状态aU                       │
 * │ aV           │ stateV                         │ 状态aV                       │
 * │ aW           │ stateW                         │ 状态aW                       │
 * │ aX           │ targetTurn                     │ 目标回合                     │
 * │ aY           │ stateY                         │ 状态aY                       │
 * │ aZ           │ stateZ                         │ 状态aZ                       │
 * │ aa           │ stateAA                        │ 状态aa                       │
 * │ ab           │ stateAB                        │ 状态ab                       │
 * │ ac           │ factionIdx                     │ 阵营选择索引                 │
 * │ ae           │ saveSlot                       │ 存档槽位                     │
 * │ af           │ stateAF                        │ 状态af                       │
 * │ ag           │ stateAG                        │ 状态ag                       │
 * │ ak           │ loadingProgress                │ 加载进度                     │
 * │ al           │ loadingState                   │ 加载状态                     │
 * │ am           │ loadingPercent                 │ 加载百分比                   │
 * │ an           │ stateAN                        │ 状态an                       │
 * │ ao           │ stateAO                        │ 状态ao                       │
 * │ ap           │ stateAP                        │ 状态ap                       │
 * │ aq           │ currentMidiIdx                 │ 当前MIDI索引                 │
 * │ ar           │ stateAR                        │ 状态ar                       │
 * │ as           │ stateAS                        │ 状态as                       │
 * │ at           │ keyRepeatGuard                 │ 防重复触发标志               │
 * │ au           │ stateAU                        │ 状态au                       │
 * │ av           │ stateAV                        │ 状态av                       │
 * │ aw           │ stateAW                        │ 状态aw                       │
 * │ ax           │ stateAX                        │ 状态ax                       │
 * │ ay           │ stateAY                        │ 状态ay                       │
 * │ az           │ stateAZ                        │ 状态az                       │
 * │ bA           │ stateBA                        │ 状态bA                       │
 * │ bB           │ stateBB                        │ 状态bB                       │
 * │ bC           │ stateBC                        │ 状态bC                       │
 * │ bD           │ stateBD                        │ 状态bD                       │
 * │ bE           │ stateBE                        │ 状态bE                       │
 * │ bF           │ stateBF                        │ 状态bF                       │
 * │ bG           │ mapColsG2                      │ 地图列数(bG)                 │
 * │ bH           │ stateBH                        │ 状态bH                       │
 * │ bI           │ screenCenterX                  │ 屏幕中心X                    │
 * │ bJ           │ screenCenterY                  │ 屏幕中心Y                    │
 * │ bK           │ stateBK                        │ 状态bK                       │
 * │ bL           │ stateBL                        │ 状态bL                       │
 * │ bM           │ stateBM                        │ 状态bM                       │
 * │ bN           │ stateBN                        │ 状态bN                       │
 * │ bO           │ stateBO                        │ 状态bO                       │
 * │ bP           │ stateBP                        │ 状态bP                       │
 * │ bQ           │ stateBQ                        │ 状态bQ                       │
 * │ bR           │ stateBR                        │ 状态bR                       │
 * │ bS           │ stateBS                        │ 状态bS                       │
 * │ bT           │ enemyCountT                    │ 敌人计数T                    │
 * │ bU           │ stateBU                        │ 状态bU                       │
 * │ bV           │ threadState                    │ 线程状态(2=运行)             │
 * │ bW           │ stateBW                        │ 状态bW                       │
 * │ bX           │ stateBX                        │ 状态bX                       │
 * │ bY           │ stateBY                        │ 状态bY                       │
 * │ bZ           │ stateBZ                        │ 状态bZ                       │
 * │ ba           │ stateBa                        │ 状态ba                       │
 * │ bb           │ stateBb                        │ 状态bb                       │
 * │ bc           │ stateBc                        │ 状态bc                       │
 * │ bd           │ stateBd                        │ 状态bd                       │
 * │ be           │ stateBe                        │ 状态be                       │
 * │ bf           │ pathCount                      │ 路径数量                     │
 * │ bg           │ progressValue                  │ 进度值                       │
 * │ bh           │ progressMax                    │ 进度最大值                   │
 * │ bi           │ stateBi                        │ 状态bi                       │
 * │ bj           │ nextTurnTarget                 │ 下一回合目标                 │
 * │ bk           │ stateBk                        │ 状态bk                       │
 * │ bl           │ stateBl                        │ 状态bl                       │
 * │ bm           │ stateBm                        │ 状态bm                       │
 * │ bn           │ stateBn                        │ 状态bn                       │
 * │ bo           │ stateBo                        │ 状态bo                       │
 * │ bp           │ stateBp                        │ 状态bp                       │
 * │ bq           │ stateBq                        │ 状态bq                       │
 * │ br           │ stateBr                        │ 状态br                       │
 * │ bs           │ stateBs                        │ 状态bs                       │
 * │ bt           │ counterT                       │ 计数器T                      │
 * │ bu           │ stateBu                        │ 状态bu                       │
 * │ bv           │ stateBv                        │ 状态bv                       │
 * │ bw           │ stateBw                        │ 状态bw                       │
 * │ bx           │ stateBx                        │ 状态bx                       │
 * │ by           │ stateBy                        │ 状态by                       │
 * │ bz           │ stateBz                        │ 状态bz                       │
 * │ ca           │ httpResponseCode               │ HTTP响应码                   │
 * │ cb           │ notifyState                    │ 显示通知状态                 │
 * │ d1011        │ colorConstants                 │ 颜色常量                     │
 * │ a1014        │ resourcePaths                  │ 资源文件路径                 │
 * │ b1015        │ gameTexts                      │ 游戏文本                     │
 * │ c1051        │ towerBuildPaths                │ 塔建造路径                   │
 * │ a1052        │ techTreeBranches               │ 科技树分支                   │
 * │ d1053        │ levelSequence                  │ 关卡序列                     │
 * │ e1054        │ levelConfig                    │ 关卡配置                     │
 * │ f1055        │ towerLevelLimits               │ 塔等级限制                   │
 * │ g1057        │ upgradeCosts                   │ 升级费用                     │
 * │ o1098        │ levelSpawnPoints               │ 每关生成点                   │
 * │ p1099        │ multiPathFlags                 │ 多路径标志                   │
 * │ q1100        │ killRewards                    │ 击杀奖励                     │
 * │ r1101        │ enemyHpCoeffs                  │ 敌人HP系数                   │
 * │ s1102        │ altHpCoeffs                    │ 备用HP系数                   │
 * │ t1103        │ towerDamageRange               │ 塔伤害/射程                   │
 * │ u1104        │ towerAtkSpeed                  │ 塔攻速/效果                  │
 * │ v1109        │ towerInitLevels                │ 塔初始等级                   │
 * │ w1110        │ encryptKey                     │ 加密密钥                     │
 * │ w1123        │ enemyPathAnim                  │ 敌人路径动画                 │
 * │ x1124        │ xOffsetTable                   │ X偏移表                      │
 * │ y1125        │ yOffsetTable                   │ Y偏移表                      │
 * │ x1128        │ directionVectors               │ 方向向量                     │
 * │ y1130        │ generalSortOrder               │ 武将排序                     │
 * │ f            │ spriteFrameCounts              │ 精灵帧数                     │
 * │ j1049        │ tangentTable                   │ 正切表(角度计算)            │
 * │ k1071        │ intArrayK1071                  │ int数组                      │
 * │ l1116        │ intArrayL1116                  │ int数组                      │
 * │ q1158        │ intArrayQ1158                  │ int数组                      │
 * │ r1166        │ intArrayR1166                  │ int数组                      │
 * │ s1167        │ intArrayS1167                  │ int数组                      │
 * │ t1168        │ intArrayT1168                  │ int数组                      │
 * │ A1151        │ byteArrayA1151                 │ byte数组                     │
 * │ b1069        │ shortArray2DB1069              │ short二维数组                │
 * │ c1070        │ shortArray2DC1070              │ short二维数组                │
 * │ a1027        │ tileDataA0                     │ 瓦片数据A0                   │
 * │ a1028        │ tileDataA2D                    │ 瓦片数据A2D                  │
 * │ b1034        │ tileDataB0                     │ 瓦片数据B0                   │
 * │ b1030        │ tileDataB2D                    │ 瓦片数据B2D                  │
 * │ c1037        │ tileDataC0                     │ 瓦片数据C0                   │
 * │ d1050        │ tileDataD0                     │ 瓦片数据D0                   │
 * │ h1060        │ tileDataH0                     │ 瓦片数据H0                   │
 * │ i1062        │ tileDataI0                     │ 瓦片数据I0                   │
 * │ j1064        │ tileDataJ0                     │ 瓦片数据J0                   │
 * │ k1068        │ tileDataK0                     │ 瓦片数据K0                   │
 * │ l1072        │ tileDataL0                     │ 瓦片数据L0                   │
 * │ m1075        │ tileDataM0                     │ 瓦片数据M0                   │
 * │ n1076        │ tileDataN0                     │ 瓦片数据N0                   │
 * │ z1148        │ tileDataZ0                     │ 瓦片数据Z0                   │
 * │ B1160        │ tileDataB                      │ 瓦片数据B(可变)              │
 * │ C1161        │ tileDataC                      │ 瓦片数据C(可变)              │
 * │ D1162        │ tileDataD                      │ 瓦片数据D(可变,建造时修改)   │
 * │ E1163        │ tileProperties                 │ 瓦片属性(可变,类型检查)     │
 * │ F1164        │ tileDataF                      │ 瓦片数据F(可变)              │
 * │ G1165        │ tileDataG                      │ 瓦片数据G(可变)              │
 * │ H1188        │ httpPostData                   │ HTTP POST数据                │
 * │ I1189        │ httpResponseData               │ HTTP响应数据                 │
 * │ A1132        │ levelDataA                     │ 关卡数据A                    │
 * │ B1133        │ levelDataB                     │ 关卡数据B                    │
 * │ C1134        │ levelDataC                     │ 关卡数据C(可变)              │
 * │ D1135        │ levelDataD                     │ 关卡数据D                    │
 * │ E1136        │ levelDataE                     │ 关卡数据E                    │
 * │ F1137        │ levelDataF                     │ 关卡数据F                    │
 * │ G1138        │ levelDataG                     │ 关卡数据G                    │
 * │ H1140        │ levelDataH                     │ 关卡数据H                    │
 * │ I1142        │ levelDataI                     │ 关卡数据I                    │
 * │ J1144        │ levelDataJ                     │ 关卡数据J                    │
 * │ K1145        │ levelDataK                     │ 关卡数据K                    │
 * │ L1146        │ levelDataL                     │ 关卡数据L                    │
 * │ M1147        │ levelDataM                     │ 关卡数据M                    │
 * │ N1149        │ levelDataN                     │ 关卡数据N                    │
 * │ O1156        │ levelDataO                     │ 关卡数据O                    │
 * │ P1157        │ levelDataP                     │ 关卡数据P                    │
 * │ Q1159        │ levelDataQ                     │ 关卡数据Q                    │
 * │ z1131        │ levelDataZ                     │ 关卡数据Z                    │
 * │ e1058        │ byteArray2DE1058               │ byte二维数组                 │
 * │ f1063        │ byteArray2DF1063               │ byte二维数组                 │
 * │ g1065        │ byteArray2DG1065               │ byte二维数组                 │
 * │ h1074        │ generalSelectData              │ 武将选择数据                 │
 * │ i1079        │ byteArray2DI1079               │ byte二维数组                 │
 * │ j1080        │ byteArray2DJ1080               │ byte二维数组                 │
 * │ k1081        │ byteArray2DK1081               │ byte二维数组                 │
 * │ l1083        │ byteArray2DL1083               │ byte二维数组                 │
 * │ n1094        │ byteArray2DN1094               │ byte二维数组                 │
 * │ o1095        │ byteArray2DO1095               │ byte二维数组                 │
 * │ p1108        │ byteArray2DP1108               │ byte二维数组                 │
 * │ q1114        │ byteArray2DQ1114               │ byte二维数组                 │
 * │ r1115        │ byteArray2DR1115               │ byte二维数组                 │
 * │ s1117        │ byteArray2DS1117               │ byte二维数组                 │
 * │ t1118        │ byteArray2DT1118               │ byte二维数组                 │
 * │ u1119        │ byteArray2DU1119               │ byte二维数组                 │
 * │ v1120        │ byteArray2DV1120               │ byte二维数组                 │
 * │ a1067        │ mapDataA                       │ 地图数据A                    │
 * │ b1085        │ mapDataB                       │ 地图数据B                    │
 * │ c1090        │ mapDataC                       │ 地图数据C                    │
 * │ d1091        │ mapDataD                       │ 地图数据D                    │
 * │ e1093        │ mapDataE                       │ 地图数据E                    │
 * │ f1112        │ mapDataF                       │ 地图数据F                    │
 * │ g1113        │ mapDataG                       │ 地图数据G                    │
 * │ h1121        │ mapDataH                       │ 地图数据H                    │
 * │ i1122        │ spriteOffsets                  │ 精灵图偏移                   │
 * │ j1139        │ mapDataJ                       │ 地图数据J                    │
 * │ k1141        │ mapDataK                       │ 地图数据K                    │
 * │ l1143        │ mapDataL                       │ 地图数据L                    │
 * │ m1150        │ mapDataM                       │ 地图数据M                    │
 * │ a1092        │ shortArray4D                   │ 四维short数组                │
 * │ c1061        │ unlockFlags                    │ 解锁标志                     │
 * │ d1073        │ levelFlags                     │ 关卡标志                     │
 * │ e1105        │ levelCompleted                 │ 关卡完成                     │
 * │ f1106        │ levelUnlocked                  │ 关卡解锁                     │
 * │ a1056        │ techUnlocked                   │ 科技解锁                     │
 * │ b1059        │ generalAwakened                │ 武将觉醒                     │
 * │ a1127        │ buildableFlags                 │ 可建造标志(二维)             │
 * │ A1170        │ flagA1170                      │ 布尔标志                     │
 * │ B1171        │ threadRunning                  │ 线程已运行标志               │
 * │ C1175        │ needRestore                    │ 需要恢复                     │
 * │ D1176        │ useProxy                       │ 使用代理                     │
 * │ E1179        │ initialized                    │ 已初始化                     │
 * │ F1180        │ hasFactionName                 │ 有阵营名                     │
 * │ G1182        │ hasLevelName                   │ 有关卡名                     │
 * │ a1087        │ techLevels                     │ 科技等级                     │
 * │ d1173        │ generalNames                   │ 武将名                       │
 * │ b1177        │ menuTitle                      │ 菜单标题                     │
 * │ c1178        │ currentGeneralName             │ 当前武将名                   │
 * │ d1181        │ factionName                    │ 阵营名                       │
 * │ e1183        │ levelName                      │ 关卡名                       │
 * │ f1186        │ statusMessage                  │ 状态消息/URL                 │
 * │ g1187        │ redirectUrl                    │ 武将语音/重定向URL           │
 * │ h1192        │ errorMessage                   │ 错误消息                     │
 * │ a1042        │ midiInputStreams               │ MIDI 输入流                  │
 * │ a1043        │ midiPlayers                    │ MIDI 播放器                  │
 * │ a1017        │ volumeControl                  │ 音量控制                     │
 * │ h1041        │ midiPlayerState                │ MIDI 播放器状态              │
 * │ g1035        │ intArrayG1035                  │ int数组                      │
 * │ i1044        │ intArrayI1044                  │ int数组                      │
 * │ a1193        │ httpConnection                 │ HTTP连接                     │
 * │ a1191        │ saveBuffer                     │ 存档缓冲区                   │
 * │ a1172        │ syncLock                       │ 同步锁对象                   │
 * │ a1184        │ saveDate                       │ 存档日期                     │
 * │ a1185        │ calendar                       │ 日历                         │
 * │ b1174        │ notifyStatus                   │ 显示通知状态                 │
 * │ c1190        │ httpMethod                     │ 游戏模式(1=GET,2=POST)       │
 * │ m1129        │ intArrayM1129                  │ int数组                      │
 * │ n1152        │ renderData                     │ 渲染数据                     │
 * │ o1153        │ activeTowerIndices             │ 塔索引数组                   │
 * │ p1154        │ intArrayP1154                  │ int数组                      │
 * │ c1107        │ enemySlots                     │ 敌人槽位                     │
 * │ b1066        │ towerSlots                     │ 塔槽位                       │
 * │ m1084        │ directionMatrix                │ 方向向量矩阵                 │
 * │ o1077        │ levelAdvanceFlag               │ 关卡推进标志                 │
 * │ p1078        │ victoryFlag                    │ 胜利标志                     │
 * │ q1082        │ flagQ1082                      │ 布尔标志                     │
 * │ r1086        │ renderFlag                     │ 渲染标志                     │
 * │ g1046        │ currentKeyCode                 │ 当前按键码                   │
 * │ h1047        │ keyState                       │ 按键状态                     │
 * │ i1048        │ keyRepeatCount                 │ 连按计数(-1=已释放)          │
 * │ e1025        │ publicIntE1025                 │ 公开int字段                  │
 * │ f1026        │ publicIntF1026                 │ 公开int字段                  │
 * │ a1001        │ ROTATION_PARAMS                │ DirectGraphics旋转参数(静态) │
 * │ c1045        │ MIDI_FILES                     │ MIDI音乐文件名(静态)         │
 * └──────────────┴───────────────────────────────┴─────────────────────────────┘
 */

/**
 * ============================================================================
 * B. 方法映射表 (共 ~250+ 个)
 * ============================================================================
 *
 * ┌─────────────────────────────────────────┬────────────────────────────────────────────────┬──────────────────────────────────────┐
 * │ 混淆签名                                 │ 语义名                                          │ 说明                                  │
 * ├─────────────────────────────────────────┼────────────────────────────────────────────────┼──────────────────────────────────────┤
 * │                                         │                                                │                                      │
 * │ ─── J2ME 回调方法 (6个, 模块03) ─────────────────────────────────────────────────────────                                       │
 * │ paint(Graphics)                         │ paint(Graphics)                                │ 渲染回调(已是正常名)                  │
 * │ run()                                   │ run()                                          │ 游戏主循环(已是正常名)                │
 * │ keyPressed(int)                         │ keyPressed(int)                                │ 按键处理(已是正常名)                  │
 * │ keyReleased(int)                        │ keyReleased(int)                               │ 按键释放(已是正常名)                  │
 * │ showNotify()                            │ showNotify()                                   │ Canvas显示通知(已是正常名)            │
 * │ hideNotify()                            │ hideNotify()                                   │ Canvas隐藏通知(已是正常名)            │
 * │                                         │                                                │                                      │
 * │ ─── A-Z 无参数方法 (26个, 模块04) ───────────────────────────────────────────────────────                                       │
 * │ A()                                     │ dispatchRender                                 │ 渲染分发器                            │
 * │ B()                                     │ runLoadProcess                                 │ 加载流程                              │
 * │ C()                                     │ saveRMS_sanGuoTd                               │ RMS存档保存                           │
 * │ D()                                     │ loadRMS_sanGuoTdData                           │ RMS存档读取                           │
 * │ E()                                     │ loadRMS_freeGame                               │ RMS存档读取                           │
 * │ F()                                     │ loopProcess15                                  │ 循环处理15次                          │
 * │ G()                                     │ updateMainFrame                                │ ★主帧更新逻辑(状态机分发)             │
 * │ H()                                     │ drawScrollAndBg                                │ 调用J()+I()                           │
 * │ I()                                     │ drawBackground                                 │ 背景绘制                              │
 * │ J()                                     │ calcScrollPosition                             │ 滚动计算                              │
 * │ K()                                     │ handleLevelSelect                              │ 关卡选择                              │
 * │ L()                                     │ handleLevelInput                               │ 输入处理                              │
 * │ M()                                     │ handleTechTree                                 │ 科技树                                │
 * │ N()                                     │ iterateTileProperties                          │ 遍历E1163数组                         │
 * │ O()                                     │ updateGameState                                │ ★游戏状态更新                         │
 * │ P()                                     │ selectGeneral                                  │ 武将选择                              │
 * │ Q()                                     │ selectGeneralAlt                               │ 武将选择(同P)                         │
 * │ R()                                     │ advanceLevel                                   │ 关卡推进                              │
 * │ S()                                     │ renderOverlay                                  │ 渲染(覆盖层)                          │
 * │ T()                                     │ checkVictory                                   │ 胜利检查                              │
 * │ U()                                     │ resetGame                                      │ 初始化                                │
 * │ V()                                     │ iteratePaths                                   │ 遍历bf                                │
 * │ W()                                     │ drawMainMap                                    │ ★地图主绘制(825行)                    │
 * │ X()                                     │ updateGameFrame                                │ ★★主游戏帧更新                        │
 * │ Y()                                     │ renderGameWorld                                │ 渲染(n1152,b1066)                     │
 * │ Z()                                     │ renderGeneralSelect                            │ 渲染(bn)                              │
 * │                                         │                                                │                                      │
 * │ ─── aa-ay 方法 (25个, 模块05) ───────────────────────────────────────────────────────────                                       │
 * │ aa()                                    │ helperAA                                       │ TODO: 未确认功能                      │
 * │ ab()                                    │ helperAB                                       │ TODO: 未确认功能                      │
 * │ ac()                                    │ helperAC                                       │ TODO: 未确认功能                      │
 * │ ad()                                    │ helperAD                                       │ TODO: 未确认功能                      │
 * │ ae()                                    │ helperAE                                       │ TODO: 未确认功能                      │
 * │ af()                                    │ helperAF                                       │ TODO: 未确认功能                      │
 * │ ag()                                    │ renderAG_block298                             │ 渲染辅助(298行)                       │
 * │ ah()                                    │ helperAH                                       │ TODO: 未确认功能                      │
 * │ ai()                                    │ helperAI                                       │ TODO: 未确认功能                      │
 * │ aj()                                    │ helperAJ                                       │ TODO: 未确认功能                      │
 * │ ak()                                    │ renderAK_block297                             │ 渲染辅助(297行)                       │
 * │ al()                                    │ renderAL_block235                             │ 渲染辅助(235行)                       │
 * │ am()                                    │ helperAM                                       │ TODO: 未确认功能                      │
 * │ an()                                    │ helperAN                                       │ TODO: 未确认功能                      │
 * │ ao()                                    │ dispatchKeyState                               │ ★按键状态机分发                       │
 * │ ap()                                    │ renderDifficulty                               │ 渲染(b1015[175])                      │
 * │ aq()                                    │ handleInputAQ                                  │ 输入处理                              │
 * │ ar()                                    │ renderEndingAnim                               │ 结局动画渲染                          │
 * │ as()                                    │ stateMachineNotify                             │ 状态机(b1174)                         │
 * │ at()                                    │ setNotify1                                     │ 设置b1174=1                           │
 * │ au()                                    │ initCalendar                                   │ 日历初始化                            │
 * │ av()                                    │ startGameThread                                │ ★启动游戏线程                         │
 * │ aw()                                    │ loadRMS_sfSmsInfo                              │ ★RMS读取"__sfSmsInfo"                 │
 * │ ax()                                    │ saveRMS_sfSmsInfo                              │ RMS写入"__sfSmsInfo"                  │
 * │ ay()                                    │ processSaveBuffer                              │ 存档缓冲区处理                        │
 * │                                         │                                                │                                      │
 * │ ─── a() 系列方法 (47个, 模块06/07) ────────────────────────────────────────────────────────                                    │
 * │ a() : int                               │ randomByte                                     │ 随机数 0-255                          │
 * │ a(int) : int                            │ getTileProperty                                │ 瓦片属性 E1163[n]>>1                  │
 * │ a(int,int) : int                        │ calcTileIndex                                  │ 瓦片索引                              │
 * │ a(int,int,int) : int                    │ calcAngle                                      │ 角度计算(正切表)                      │
 * │ a(int,int,int,int) : int                │ calcAngleFromDelta                             │ 距离/角度计算                         │
 * │ a(int,byte[],int) : int                 │ calcHp                                         │ HP计算                                │
 * │ a(DataInputStream) : String [static]    │ readCustomString [static]                      │ 读取自定义格式字符串                  │
 * │ a(String) : String [static]             │ extractHostName [static]                       │ URL主机名提取                         │
 * │ a(InputStream) : short [static]          │ readShortLE [static]                           │ 读取2字节小端序short                  │
 * │ a() : void                              │ menuReturn                                     │ 菜单返回(m--,l=b[m])                  │
 * │ a(byte) : void                          │ setGameMode                                    │ 游戏模式设置                          │
 * │ a(int) : void                           │ menuGoto                                       │ 菜单跳转(b[m]=l,l=n,m++)              │
 * │ a(int,int) : void                       │ loadSprites                                    │ 精灵图加载                            │
 * │ a(int,int,int) : void                   │ helperA_3P                                     │ TODO: 未确认功能                      │
 * │ a(int,int,int,byte,int,boolean) : void  │ fillTile                                       │ 瓦片填充(建造/拆除)                   │
 * │ a(int,int,int,int) : void               │ helperA_4P                                     │ TODO: 未确认功能                      │
 * │ a(int,int,int,int,int) : void           │ renderRangeAttack                              │ 范围攻击渲染                          │
 * │ a(int,int,int,int,int,int) : void       │ helperA_6P                                     │ TODO: 未确认功能                      │
 * │ a(int,int,int,int,int,int,int) : void   │ helperA_7P                                     │ TODO: 未确认功能                      │
 * │ a(int,...,8参数) : void                 │ helperA_8P                                     │ TODO: 未确认功能                      │
 * │ a(int,int,int,int,boolean) : void       │ helperA_5P_bool                                │ TODO: 未确认功能                      │
 * │ a(int,int,int,boolean) : void           │ helperA_4P_bool                                │ TODO: 未确认功能                      │
 * │ a(int,int,boolean) : void               │ helperA_3P_bool                                │ TODO: 未确认功能                      │
 * │ a(String) : void                        │ renderScrollText                               │ 滚动文字渲染                          │
 * │ a(String,int,int) : void                │ helperA_Str2P                                  │ TODO: 未确认功能                      │
 * │ a(String,int,int,int,int,int) : void    │ drawTextPanel                                  │ 文字面板绘制                          │
 * │ a(Image,int,int,int) : void             │ drawImageRotation                              │ 旋转绘制图片                          │
 * │ a(Image,int,int,int,int) : void         │ drawImageTiled                                 │ 平铺绘制                              │
 * │ a(Image,...,6参数) : void               │ drawImageVariant6P                             │ TODO: 未确认功能                      │
 * │ a(Image,...,7参数) : void               │ drawImageVariant7P                             │ TODO: 未确认功能                      │
 * │ a(Image,...,8参数) : void               │ drawImageVariant8P                             │ TODO: 未确认功能                      │
 * │ a(Image,...,9参数) : void               │ drawImageVariant9P                             │ TODO: 未确认功能                      │
 * │ a(Image,...,10参数) : void              │ drawImageVariant10P                            │ TODO: 未确认功能                      │
 * │ a(Image,int,int,int,boolean) : void     │ drawImageVariant5P_bool                        │ TODO: 未确认功能                      │
 * │ a(Image,Image,...,7参数) : void         │ drawImage2Imgs7P                               │ TODO: 未确认功能                      │
 * │ a(Image,Image,Image,...,7参数) : void   │ drawImage3Imgs7P                               │ TODO: 未确认功能                      │
 * │ a(boolean) : void                       │ renderHelpPage                                 │ 帮助页渲染                            │
 * │ a(byte[]) : void                        │ helperA_byteArr                                │ TODO: 未确认功能                      │
 * │ a(char[],int,int,int,int,int,int,boolean) : void │ renderChars                            │ 字符渲染                              │
 * │ a(int[],int[][],int,int) : void [static]│ updateTowerArray [static]                      │ 静态-数组处理                         │
 * │ a() : boolean                           │ loadRMS_sanGuoTd                               │ ★RMS存档读取 "sanGuoTd"               │
 * │ a(int) : boolean [static]               │ isOdd [static]                                 │ 静态-奇偶检查                         │
 * │ a(int,int) : boolean                    │ helperA_2P_bool                                │ TODO: 未确认功能                      │
 * │ a(int,int,int) : boolean                │ helperA_3P_bool                                │ TODO: 未确认功能                      │
 * │ a(int,int,int,int,int) : boolean        │ helperA_5P_bool2                               │ TODO: 未确认功能                      │
 * │ a(int,int,int,int,int,int) : boolean [static] │ helperA_6P_bool [static]               │ 静态-布尔检查                         │
 * │ a(int,int,int,boolean) : boolean        │ helperA_4P_bool2                               │ TODO: 未确认功能                      │
 * │                                         │                                                │                                      │
 * │ ─── b() 系列方法 (21个, 模块06/07) ────────────────────────────────────────────────────────                                    │
 * │ b() : int                               │ getThreadState                                 │ ★同步锁+返回bV                        │
 * │ b(int) : int                            │ calcEnemyHp                                    │ ★敌人HP计算                           │
 * │ b(int,int) : int                        │ tileCoordConvert                               │ 瓦片坐标转换                          │
 * │ b(int,int,int,int) : int [static]       │ distanceSq [static]                            │ 静态-距离平方计算                     │
 * │ b(String) : String                      │ rewriteUrlProxy                                │ URL重写(代理)                         │
 * │ b() : void                              │ menuReset                                      │ 菜单重置(m=0)                         │
 * │ b(int) : void                           │ menuBackTo                                     │ 菜单回退到指定状态                    │
 * │ b(int,int) : void                       │ drawBg                                         │ 背景绘制                              │
 * │ b(int,int,int) : void                   │ helperB_3P                                     │ TODO: 未确认功能                      │
 * │ b(int,int,int,int) : void               │ helperB_4P                                     │ TODO: 未确认功能                      │
 * │ b(int,int,int,int,int) : void           │ helperB_5P                                     │ TODO: 未确认功能                      │
 * │ b(int,...,6参数) : void                 │ helperB_6P                                     │ TODO: 未确认功能                      │
 * │ b(int,...,8参数) : void                 │ helperB_8P                                     │ TODO: 未确认功能                      │
 * │ b(int,int,int,int,boolean) : void       │ helperB_5P_bool                                │ TODO: 未确认功能                      │
 * │ b(String) : void [static]               │ handleStringStatic [static]                    │ 静态-字符串处理                       │
 * │ b(Image,int,int,int) : void             │ drawImageVariantB4P                            │ TODO: 未确认功能                      │
 * │ b(Image,int,int,int,int) : void         │ drawImageVariantB5P                            │ TODO: 未确认功能                      │
 * │ b(Image,...,9参数) : void               │ drawImageVariantB9P                            │ TODO: 未确认功能                      │
 * │ b() : boolean                           │ loadRMS_sanGuoTdData                           │ RMS存档读取 "sanGuoTdData"            │
 * │ b(int) : boolean                        │ canBuildTower                                  │ 瓦片可建造检查                        │
 * │ b(int,int) : boolean                    │ canBuildTowerAt                                │ 瓦片可建造检查(带坐标)                │
 * │                                         │                                                │                                      │
 * │ ─── c() 系列方法 (17个, 模块06/07) ────────────────────────────────────────────────────────                                    │
 * │ c() : int                               │ waitHttpResponse                               │ ★循环调用d()                          │
 * │ c(int) : int [static]                   │ calcDirection [static]                         │ 静态-方向计算                         │
 * │ c(int,int) : int                        │ checkTileBoundary                              │ 坐标边界检查                          │
 * │ c(int,int,int) : int                    │ helperC_3P                                     │ TODO: 未确认功能                      │
 * │ c() : void                              │ resetCounters                                  │ 重置计数器(aP=0,bt=0)                 │
 * │ c(int) : void                           │ loadSprite                                     │ ★精灵图加载                           │
 * │ c(int,int) : void                       │ helperC_2P                                     │ TODO: 未确认功能                      │
 * │ c(int,int,int) : void                   │ helperC_3P                                     │ TODO: 未确认功能                      │
 * │ c(int,int,int,int) : void               │ helperC_4P                                     │ TODO: 未确认功能                      │
 * │ c(int,int,int,int,int) : void           │ helperC_5P                                     │ TODO: 未确认功能                      │
 * │ c(int,...,6参数) : void                 │ helperC_6P                                     │ TODO: 未确认功能                      │
 * │ c(int,int,int,int,boolean) : void       │ helperC_5P_bool                                │ TODO: 未确认功能                      │
 * │ c(String) : void                        │ adaptDevice                                    │ 设备适配                              │
 * │ c(Image,int,int,int) : void             │ drawImageVariantC4P                            │ TODO: 未确认功能                      │
 * │ c() : boolean                           │ loadRMS_freeGame                               │ RMS存档读取 "freeGame"                │
 * │ c(int) : boolean                        │ isTileEven                                     │ 瓦片奇偶检查                          │
 * │ c(int,int) : boolean                    │ helperC_2P_bool                                │ TODO: 未确认功能                      │
 * │                                         │                                                │                                      │
 * │ ─── d() 系列方法 (14个, 模块06/07) ────────────────────────────────────────────────────────                                    │
 * │ d() : int                               │ doHttpCommunication                            │ ★★★HTTP通信                          │
 * │ d(int) : int                            │ convertTileType                                │ 瓦片类型转换                          │
 * │ d(int,int,int) : int [static]           │ calcBaseHp [static]                            │ 静态-HP基础计算                       │
 * │ d() : void                              │ drawBuildMenuBg                                │ 建造菜单背景                          │
 * │ d(int) : void                           │ drawScrollingBg                                │ 背景卷轴绘制                          │
 * │ d(int,int) : void                       │ helperD_2P                                     │ TODO: 未确认功能                      │
 * │ d(int,int,int) : void                   │ helperD_3P                                     │ TODO: 未确认功能                      │
 * │ d(int,int,int,int) : void               │ helperD_4P                                     │ TODO: 未确认功能                      │
 * │ d(int,int,int,int,int) : void           │ helperD_5P                                     │ TODO: 未确认功能                      │
 * │ d(int,...,6参数) : void                 │ helperD_6P                                     │ TODO: 未确认功能                      │
 * │ d(Image,int,int,int) : void             │ drawImageVariantD4P                            │ TODO: 未确认功能                      │
 * │ d() : boolean                           │ checkLandscape                                 │ 横屏标志检查                          │
 * │ d(int) : boolean                        │ validateEnemyPath                              │ ★★★敌人路径验证                       │
 * │ d(int,int) : boolean                    │ helperD_2P_bool                                │ TODO: 未确认功能                      │
 * │                                         │                                                │                                      │
 * │ ─── e()-z() 方法 (~100个, 模块06/07) ───────────────────────────────────────────────────────                                  │
 * │ e(int) : int [static]                   │ hexCharToInt [static]                          │ 静态-hex字符解码                      │
 * │ e() : void                              │ clearScreen                                    │ 清屏                                  │
 * │ e(int) : void                           │ updateLoadingProgress                          │ 加载进度控制                          │
 * │ e(int,int) : void                       │ helperE_2P                                     │ TODO: 未确认功能                      │
 * │ e(int,int,int) : void                   │ helperE_3P                                     │ TODO: 未确认功能                      │
 * │ e(int,int,int,int) : void               │ helperE_4P                                     │ TODO: 未确认功能                      │
 * │ e(int,int,int,int,int) : void           │ helperE_5P                                     │ TODO: 未确认功能                      │
 * │ e(Image,int,int,int) : void             │ drawImageVariantE4P                            │ TODO: 未确认功能                      │
 * │ e() : boolean                           │ isTechTreeUnlocked                             │ 科技树全解锁检查                      │
 * │ e(int) : boolean                        │ checkEnemyAttack                               │ ★★敌人攻击检查                       │
 * │ e(int,int) : boolean                    │ isTileType8                                    │ 瓦片==8检查                           │
 * │ f() : void                              │ drawProgressBar                                │ ★进度条渲染                           │
 * │ f(int) : void                           │ helperF_1P                                     │ TODO: 未确认功能                      │
 * │ f(int,int) : void                       │ helperF_2P                                     │ TODO: 未确认功能                      │
 * │ f(int,int,int) : void                   │ helperF_3P                                     │ TODO: 未确认功能                      │
 * │ f(int,int,int,int) : void               │ helperF_4P                                     │ TODO: 未确认功能                      │
 * │ f(int,int,int,int,int) : void           │ helperF_5P                                     │ TODO: 未确认功能                      │
 * │ f(Image,int,int,int) : void             │ drawImageVariantF4P                            │ TODO: 未确认功能                      │
 * │ f() : boolean                           │ initGame                                       │ 初始化                                │
 * │ f(int) : boolean [static]               │ isNotCommonTower [static]                      │ 静态-非防御塔检查                     │
 * │ f(int,int) : boolean                    │ isTileType10                                   │ 瓦片==10检查                          │
 * │ g() : void                              │ handleVolume                                   │ ★音量控制                             │
 * │ g(int) : void                           │ helperG_1P                                     │ TODO: 未确认功能                      │
 * │ g(int,int) : void                       │ helperG_2P                                     │ TODO: 未确认功能                      │
 * │ g(int,int,int) : void                   │ helperG_3P                                     │ TODO: 未确认功能                      │
 * │ g(int,int,int,int) : void               │ helperG_4P                                     │ TODO: 未确认功能                      │
 * │ g(int,int,int,int,int) : void           │ helperG_5P                                     │ TODO: 未确认功能                      │
 * │ g() : boolean                           │ uploadScore                                    │ 网络上传                              │
 * │ g(int) : boolean [static]               │ isType6 [static]                               │ 静态-类型6检查                        │
 * │ g(int,int) : boolean                    │ helperG_2P_bool                                │ TODO: 未确认功能                      │
 * │ h() : void                              │ renderEndingText                               │ 结局文字渲染                          │
 * │ h(int) : void                           │ helperH_1P                                     │ TODO: 未确认功能                      │
 * │ h(int,int) : void                       │ helperH_2P                                     │ TODO: 未确认功能                      │
 * │ h(int,int,int) : void                   │ helperH_3P                                     │ TODO: 未确认功能                      │
 * │ h(int,int,int,int) : void               │ helperH_4P                                     │ TODO: 未确认功能                      │
 * │ h(int,int,int,int,int) : void           │ helperH_5P                                     │ TODO: 未确认功能                      │
 * │ h(int) : boolean                        │ randomLessThan                                 │ 随机数比较                            │
 * │ h(int,int) : boolean                    │ helperH_2P_bool                                │ TODO: 未确认功能                      │
 * │ i() : void                              │ handleVolumeInput                              │ 输入处理                              │
 * │ i(int) : void                           │ controlMidiPlayer                              │ MIDI播放器控制                        │
 * │ i(int,int) : void                       │ helperI_2P                                     │ TODO: 未确认功能                      │
 * │ i(int,int,int) : void                   │ helperI_3P                                     │ TODO: 未确认功能                      │
 * │ i(int,int,int,int) : void               │ helperI_4P                                     │ TODO: 未确认功能                      │
 * │ i(int) : boolean                        │ helperI_1P_bool                                │ TODO: 未确认功能                      │
 * │ i(int,int) : boolean                    │ helperI_2P_bool                                │ TODO: 未确认功能                      │
 * │ j() : void                              │ renderJ                                        │ 渲染                                  │
 * │ j(int) : void                           │ helperJ_1P                                     │ TODO: 未确认功能                      │
 * │ j(int,int) : void                       │ helperJ_2P                                     │ TODO: 未确认功能                      │
 * │ j(int,int,int) : void                   │ helperJ_3P                                     │ TODO: 未确认功能                      │
 * │ j(int) : boolean                        │ helperJ_1P_bool                                │ TODO: 未确认功能                      │
 * │ j(int,int) : boolean                    │ helperJ_2P_bool                                │ TODO: 未确认功能                      │
 * │ k() : void                              │ initRandom                                     │ 初始化随机数                          │
 * │ k(int) : void                           │ helperK_1P                                     │ TODO: 未确认功能                      │
 * │ k(int,int) : void                       │ helperK_2P                                     │ TODO: 未确认功能                      │
 * │ k(int,int,int) : void                   │ helperK_3P                                     │ TODO: 未确认功能                      │
 * │ k(int,int) : boolean                    │ helperK_2P_bool                                │ TODO: 未确认功能                      │
 * │ l() : void                              │ drawMap                                        │ 地图绘制                              │
 * │ l(int) : void                           │ updateTowerLogic                               │ 更新塔逻辑                            │
 * │ l(int,int) : void                       │ helperL_2P                                     │ TODO: 未确认功能                      │
 * │ l(int,int,int) : void                   │ helperL_3P                                     │ TODO: 未确认功能                      │
 * │ l(int,int) : boolean                    │ helperL_2P_bool                                │ TODO: 未确认功能                      │
 * │ m() : void                              │ handleMainMenu                                 │ ★主菜单状态机                         │
 * │ m(int) : void                           │ helperM_1P                                     │ TODO: 未确认功能                      │
 * │ m(int,int) : void                       │ helperM_2P                                     │ TODO: 未确认功能                      │
 * │ m(int,int,int) : void                   │ helperM_3P                                     │ TODO: 未确认功能                      │
 * │ m(int,int) : boolean                    │ helperM_2P_bool                                │ TODO: 未确认功能                      │
 * │ n() : void                              │ updateScrollPos                                │ ★滚动位置更新                         │
 * │ n(int) : void                           │ helperN_1P                                     │ TODO: 未确认功能                      │
 * │ n(int,int) : void                       │ helperN_2P                                     │ TODO: 未确认功能                      │
 * │ n(int,int,int) : void                   │ helperN_3P                                     │ TODO: 未确认功能                      │
 * │ n(int,int) : boolean                    │ helperN_2P_bool                                │ TODO: 未确认功能                      │
 * │ o() : void                              │ stateMachineU                                  │ 状态机(switch U)                      │
 * │ o(int) : void                           │ helperO_1P                                     │ TODO: 未确认功能                      │
 * │ o(int,int) : void                       │ helperO_2P                                     │ TODO: 未确认功能                      │
 * │ o(int,int,int) : void                   │ helperO_3P                                     │ TODO: 未确认功能                      │
 * │ o(int,int) : boolean                    │ helperO_2P_bool                                │ TODO: 未确认功能                      │
 * │ p() : void                              │ clearBackground                                │ ★背景清屏                             │
 * │ p(int) : void                           │ helperP_1P                                     │ TODO: 未确认功能                      │
 * │ p(int,int) : void                       │ helperP_2P                                     │ TODO: 未确认功能                      │
 * │ p(int,int,int) : void                   │ helperP_3P                                     │ TODO: 未确认功能                      │
 * │ p(int,int) : boolean                    │ helperP_2P_bool                                │ TODO: 未确认功能                      │
 * │ q() : void                              │ renderMenu                                     │ 菜单渲染                              │
 * │ q(int) : void                           │ helperQ_1P                                     │ TODO: 未确认功能                      │
 * │ q(int,int) : void                       │ helperQ_2P                                     │ TODO: 未确认功能                      │
 * │ q(int,int,int) : void                   │ helperQ_3P                                     │ TODO: 未确认功能                      │
 * │ q(int,int) : boolean                    │ helperQ_2P_bool                                │ TODO: 未确认功能                      │
 * │ r() : void                              │ handleMenuInput                                │ 输入处理                              │
 * │ r(int) : void                           │ helperR_1P                                     │ TODO: 未确认功能                      │
 * │ r(int,int,int) : void                   │ helperR_3P                                     │ TODO: 未确认功能                      │
 * │ s() : void                              │ renderSavePanel                                │ 存档面板                              │
 * │ s(int) : void                           │ helperS_1P                                     │ TODO: 未确认功能                      │
 * │ s(int,int,int) : void                   │ helperS_3P                                     │ TODO: 未确认功能                      │
 * │ t() : void                              │ handleSaveLoad                                 │ 存档加载                              │
 * │ t(int) : void                           │ helperT_1P                                     │ TODO: 未确认功能                      │
 * │ t(int,int,int) : void                   │ helperT_3P                                     │ TODO: 未确认功能                      │
 * │ u() : void                              │ handleFactionSelect                            │ ★阵营选择状态机                       │
 * │ u(int) : void                           │ helperU_1P                                     │ TODO: 未确认功能                      │
 * │ u(int,int,int) : void                   │ helperU_3P                                     │ TODO: 未确认功能                      │
 * │ v() : void                              │ renderFactionSelect                            │ ★阵营选择渲染                         │
 * │ v(int) : void                           │ helperV_1P                                     │ TODO: 未确认功能                      │
 * │ v(int,int,int) : void                   │ helperV_3P                                     │ TODO: 未确认功能                      │
 * │ w() : void                              │ renderSpecialMode                              │ 特殊模式渲染                          │
 * │ w(int) : void                           │ helperW_1P                                     │ TODO: 未确认功能                      │
 * │ w(int,int,int) : void                   │ helperW_3P                                     │ TODO: 未确认功能                      │
 * │ x() : void                              │ helperX                                        │ TODO: 未确认功能                      │
 * │ x(int) : void                           │ helperX_1P                                     │ TODO: 未确认功能                      │
 * │ y() : void                              │ renderMap                                      │ 地图渲染                              │
 * │ y(int) : void                           │ helperY_1P                                     │ TODO: 未确认功能                      │
 * │ z() : void                              │ updateEnemyMovement                            │ ★★敌人移动更新                        │
 * │ z(int) : void                           │ helperZ_1P                                     │ TODO: 未确认功能                      │
 * └─────────────────────────────────────────┴────────────────────────────────────────────────┴──────────────────────────────────────┘
 */

/**
 * ============================================================================
 * C. 命名策略说明
 * ============================================================================
 *
 * 1. 核心方法 (有明确语义): 使用完整语义名
 *    例: G() → updateMainFrame, d() → doHttpCommunication, z() → updateEnemyMovement
 *
 * 2. 辅助方法 (有部分语义): 使用 renderXxx/drawXxx/handleXxx 前缀 + 描述
 *    例: h() → renderEndingText, q() → renderMenu, r() → handleMenuInput
 *
 * 3. 未知功能方法: 使用 helper + 原名 + 参数信息 + TODO 注释
 *    例: aa() → helperAA, d(int,int) → helperD_2P
 *    这样保留可追溯性, 后续分析时可继续重命名
 *
 * 4. 重载方法区分: 在名字后加参数数量后缀 (_2P, _3P 等)
 *    例: a(int,int) → calcTileIndex, a(int,int,int) → calcAngle
 *        但未知功能的: a(int,int,int) → helperA_3P
 *
 * 5. 静态方法: 保持 [static] 标记
 *    例: a(int) [static] → isOdd [static]
 *
 * 6. 字段: 直接使用语义名, 不加前缀
 *    例: a1002 → graphicsCtx, b1015 → gameTexts, E1163 → tileProperties
 *
 * ============================================================================
 * D. 重命名后的代码结构
 * ============================================================================
 *
 * deobfuscated_modules_renamed/
 * ├── 00_constants.java          (常量, 字段名替换)
 * ├── 01_fields.java             (字段声明, 字段名替换)
 * ├── 02_constructor.java        (构造函数, 字段名+方法名替换)
 * ├── 03_callbacks.java          (J2ME回调, 方法名已是正常)
 * ├── 04_render_AZ.java          (A-Z方法, 方法名+字段名替换)
 * ├── 05_logic_aa_az.java        (aa-ay方法, 方法名+字段名替换)
 * ├── 06_logic_a_z.java          (a-z方法, 方法名+字段名替换)
 * ├── 07_utils.java              (工具方法, 方法名+字段名替换)
 * ├── 08_bytecode_recovered.java (字节码恢复方法, 方法名+字段名替换)
 * ├── 09_method_index.java       (方法索引, 仅更新注释)
 * └── 10_rename_map.java         (本文件 - 映射表)
 * ============================================================================
 */
