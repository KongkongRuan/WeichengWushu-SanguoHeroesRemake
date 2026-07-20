#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
v14 完成剩余替换脚本
=====================
完成 v13 未完成的 3 类替换:
  1. 101 个带参方法调用 (this.X(args)) — 基于参数表达式类型推断
  2. 4 个剩余字段引用 (this.ad, this.ai) — v13 FIELD_MAP 遗漏
  3. 4 个剩余字段声明 (ad, ah, ai, aj) — v13 FIELD_MAP 遗漏

核心改进(相比 v13):
  - 跨行参数提取: 在整个文件内容上操作, 用括号平衡找到完整参数列表
  - 参数类型推断: 分析参数表达式(不是变量名), 推断 JVM 类型描述符
  - 歧义解决: 当 (方法名, 参数个数, 返回类型) 有多个候选时,
    通过参数类型(boolean/Image/byte[]/String/char[]) 区分
  - Dry-run 模式: 先分析输出, 确认后再替换

用法:
  python v14_complete_remaining.py --dry-run    # 仅分析, 不修改
  python v14_complete_remaining.py              # 执行替换
"""

import re
import os
import sys
import shutil
from collections import defaultdict

# ============================================================
# 配置
# ============================================================
RENAMED_DIR = r"d:\Development\ts\WeichengWushu-SanguoHeroesRemake\a_java_analysis\deobfuscated_modules_renamed"
BACKUP_DIR = r"d:\Development\ts\WeichengWushu-SanguoHeroesRemake\a_java_analysis\deobfuscated_modules_renamed_backup_v14"

# ============================================================
# 方法映射表 (从 v13 脚本继承, 格式: (原名, 返回类型描述符, 参数描述符) → 语义名)
# ============================================================
METHOD_MAP = {
    # === a() 系列 ===
    ('a', 'I', ''): 'randomByte',
    ('a', 'V', ''): 'menuReturn',
    ('a', 'Z', ''): 'loadRMS_sanGuoTd',
    ('a', 'I', 'I'): 'getTileProperty',
    ('a', 'V', 'I'): 'menuGoto',
    ('a', 'Z', 'I'): 'isOdd',
    ('a', 'I', 'II'): 'calcTileIndex',
    ('a', 'V', 'II'): 'loadSprites',
    ('a', 'Z', 'II'): 'helperA_2P_bool',
    ('a', 'I', 'III'): 'calcAngle',
    ('a', 'V', 'III'): 'drawStringAt',
    ('a', 'Z', 'III'): 'helperA_3P_bool',
    ('a', 'I', 'IIII'): 'calcAngleFromDelta',
    ('a', 'V', 'IIII'): 'helperA_4P',
    ('a', 'V', 'IIIII'): 'renderRangeAttack',
    ('a', 'Z', 'IIIII'): 'helperA_5P_bool2',
    ('a', 'V', 'IIIIII'): 'helperA_6P',
    ('a', 'Z', 'IIIIII'): 'helperA_6P_bool',
    ('a', 'V', 'IIIIIII'): 'helperA_7P',
    ('a', 'V', 'IIIIIIII'): 'helperA_8P',
    ('a', 'V', 'IIIBIZ'): 'fillTile',
    ('a', 'V', 'IIIIZ'): 'helperA_5P_bool',
    ('a', 'V', 'IIIZ'): 'helperA_4P_bool',
    ('a', 'Z', 'IIIZ'): 'helperA_4P_bool2',
    ('a', 'V', 'IIZ'): 'helperA_3P_bool',
    ('a', 'V', 'Z'): 'renderHelpPage',
    ('a', 'V', 'B'): 'setGameMode',
    ('a', 'V', '[B'): 'helperA_byteArr',
    ('a', 'V', '[CIIIIIIZ'): 'renderChars',
    ('a', 'I', 'I[BI'): 'calcHp',
    ('a', 'V', '[I[[III'): 'updateTowerArray',
    ('a', 'V', 'Ljava/lang/String;'): 'renderScrollText',
    ('a', 'Ljava/lang/String;', 'Ljava/lang/String;'): 'extractHostName',
    ('a', 'V', 'Ljava/lang/String;II'): 'helperA_Str2P',
    ('a', 'V', 'Ljava/lang/String;IIIII'): 'drawTextPanel',
    ('a', 'Ljava/lang/String;', 'Ljava/io/DataInputStream;'): 'readCustomString',
    ('a', 'S', 'Ljava/io/InputStream;'): 'readShortLE',
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageRotation',
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIII'): 'drawImageTiled',
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIII'): 'drawImageVariant6P',
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIIII'): 'drawImageVariant7P',
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIIIII'): 'drawImageVariant8P',
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIIIIII'): 'drawImageVariant9P',
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIIIIIII'): 'drawImageVariant10P',
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIZ'): 'drawImageVariant5P_bool',
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;Ljavax/microedition/lcdui/Image;IIIII'): 'drawImage2Imgs7P',
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;Ljavax/microedition/lcdui/Image;Ljavax/microedition/lcdui/Image;IIII'): 'drawImage3Imgs7P',

    # === b() 系列 ===
    ('b', 'I', ''): 'getThreadState',
    ('b', 'V', ''): 'menuReset',
    ('b', 'Z', ''): 'loadRMS_sanGuoTdData',
    ('b', 'I', 'I'): 'calcEnemyHp',
    ('b', 'V', 'I'): 'menuBackTo',
    ('b', 'Z', 'I'): 'canBuildTower',
    ('b', 'I', 'II'): 'tileCoordConvert',
    ('b', 'V', 'II'): 'drawBg',
    ('b', 'Z', 'II'): 'canBuildTowerAt',
    ('b', 'I', 'III'): 'helperB_3P',
    ('b', 'V', 'III'): 'helperB_3P_void',
    ('b', 'I', 'IIII'): 'distanceSq',
    ('b', 'V', 'IIII'): 'helperB_4P',
    ('b', 'V', 'IIIII'): 'helperB_5P',
    ('b', 'V', 'IIIIII'): 'helperB_6P',
    ('b', 'V', 'IIIIIIII'): 'helperB_8P',
    ('b', 'V', 'IIIIZ'): 'helperB_5P_bool',
    ('b', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageVariantB4P',
    ('b', 'V', 'Ljavax/microedition/lcdui/Image;IIII'): 'drawImageVariantB5P',
    ('b', 'V', 'Ljavax/microedition/lcdui/Image;IIIIIIIII'): 'drawImageVariantB9P',
    ('b', 'Ljava/lang/String;', 'Ljava/lang/String;'): 'rewriteUrlProxy',
    ('b', 'V', 'Ljava/lang/String;'): 'handleStringStatic',

    # === c() 系列 ===
    ('c', 'I', ''): 'waitHttpResponse',
    ('c', 'V', ''): 'resetCounters',
    ('c', 'Z', ''): 'loadRMS_freeGame',
    ('c', 'I', 'I'): 'calcDirection',
    ('c', 'V', 'I'): 'loadSprite',
    ('c', 'Z', 'I'): 'isTileEven',
    ('c', 'I', 'II'): 'checkTileBoundary',
    ('c', 'V', 'II'): 'drawSpriteRow',
    ('c', 'Z', 'II'): 'helperC_2P_bool',
    ('c', 'I', 'III'): 'helperC_3P',
    ('c', 'V', 'III'): 'helperC_3P_void',
    ('c', 'V', 'IIII'): 'helperC_4P',
    ('c', 'V', 'IIIII'): 'helperC_5P',
    ('c', 'V', 'IIIIII'): 'helperC_6P',
    ('c', 'V', 'IIIIZ'): 'helperC_5P_bool',
    ('c', 'V', 'Ljava/lang/String;'): 'adaptDevice',
    ('c', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageVariantC4P',

    # === d() 系列 ===
    ('d', 'I', ''): 'doHttpCommunication',
    ('d', 'V', ''): 'drawBuildMenuBg',
    ('d', 'Z', ''): 'checkLandscape',
    ('d', 'I', 'I'): 'convertTileType',
    ('d', 'V', 'I'): 'drawScrollingBg',
    ('d', 'Z', 'I'): 'validateEnemyPath',
    ('d', 'I', 'III'): 'calcBaseHp',
    ('d', 'V', 'II'): 'drawSpriteBottom',
    ('d', 'Z', 'II'): 'helperD_2P_bool',
    ('d', 'V', 'III'): 'helperD_3P',
    ('d', 'V', 'IIII'): 'helperD_4P',
    ('d', 'V', 'IIIII'): 'helperD_5P',
    ('d', 'V', 'IIIIII'): 'helperD_6P',
    ('d', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageVariantD4P',

    # === e() 系列 ===
    ('e', 'V', ''): 'clearScreen',
    ('e', 'Z', ''): 'isTechTreeUnlocked',
    ('e', 'I', 'I'): 'hexCharToInt',
    ('e', 'V', 'I'): 'updateLoadingProgress',
    ('e', 'Z', 'I'): 'checkEnemyAttack',
    ('e', 'V', 'II'): 'drawSpriteGrid',
    ('e', 'Z', 'II'): 'isTileType8',
    ('e', 'V', 'III'): 'helperE_3P',
    ('e', 'V', 'IIII'): 'helperE_4P',
    ('e', 'V', 'IIIII'): 'helperE_5P',
    ('e', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageVariantE4P',

    # === f() 系列 ===
    ('f', 'V', ''): 'drawProgressBar',
    ('f', 'Z', ''): 'initGame',
    ('f', 'V', 'I'): 'helperF_1P',
    ('f', 'Z', 'I'): 'isNotCommonTower',
    ('f', 'V', 'II'): 'helperF_2P',
    ('f', 'Z', 'II'): 'isTileType10',
    ('f', 'V', 'III'): 'helperF_3P',
    ('f', 'V', 'IIII'): 'helperF_4P',
    ('f', 'V', 'IIIII'): 'helperF_5P',
    ('f', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageVariantF4P',

    # === g() 系列 ===
    ('g', 'V', ''): 'handleVolume',
    ('g', 'Z', ''): 'uploadScore',
    ('g', 'V', 'I'): 'helperG_1P',
    ('g', 'Z', 'I'): 'isType6',
    ('g', 'V', 'II'): 'helperG_2P',
    ('g', 'Z', 'II'): 'helperG_2P_bool',
    ('g', 'V', 'III'): 'helperG_3P',
    ('g', 'V', 'IIII'): 'helperG_4P',
    ('g', 'V', 'IIIII'): 'helperG_5P',

    # === h() 系列 ===
    ('h', 'V', 'I'): 'helperH_1P',
    ('h', 'Z', 'I'): 'randomLessThan',
    ('h', 'V', 'II'): 'renderGameState22',
    ('h', 'Z', 'II'): 'helperH_2P_bool',
    ('h', 'V', 'III'): 'helperH_3P',
    ('h', 'V', 'IIII'): 'helperH_4P',
    ('h', 'V', 'IIIII'): 'helperH_5P',

    # === i() 系列 ===
    ('i', 'V', ''): 'handleVolumeInput',
    ('i', 'V', 'I'): 'controlMidiPlayer',
    ('i', 'Z', 'I'): 'helperI_1P_bool',
    ('i', 'V', 'II'): 'helperI_2P',
    ('i', 'Z', 'II'): 'helperI_2P_bool',
    ('i', 'V', 'III'): 'helperI_3P',
    ('i', 'V', 'IIII'): 'helperI_4P',

    # === j() 系列 ===
    ('j', 'V', ''): 'renderJ',
    ('j', 'V', 'I'): 'helperJ_1P',
    ('j', 'Z', 'I'): 'helperJ_1P_bool',
    ('j', 'V', 'II'): 'helperJ_2P',
    ('j', 'Z', 'II'): 'helperJ_2P_bool',
    ('j', 'V', 'III'): 'helperJ_3P',

    # === k() 系列 ===
    ('k', 'V', ''): 'initRandom',
    ('k', 'V', 'I'): 'helperK_1P',
    ('k', 'V', 'II'): 'helperK_2P',
    ('k', 'Z', 'II'): 'helperK_2P_bool',
    ('k', 'V', 'III'): 'helperK_3P',

    # === l() 系列 ===
    ('l', 'V', ''): 'drawMap',
    ('l', 'V', 'I'): 'updateTowerLogic',
    ('l', 'V', 'II'): 'helperL_2P',
    ('l', 'Z', 'II'): 'helperL_2P_bool',
    ('l', 'V', 'III'): 'helperL_3P',

    # === m() 系列 ===
    ('m', 'V', ''): 'handleMainMenu',
    ('m', 'V', 'I'): 'helperM_1P',
    ('m', 'V', 'II'): 'helperM_2P',
    ('m', 'Z', 'II'): 'helperM_2P_bool',
    ('m', 'V', 'III'): 'helperM_3P',

    # === n() 系列 ===
    ('n', 'V', ''): 'updateScrollPos',
    ('n', 'V', 'I'): 'helperN_1P',
    ('n', 'V', 'II'): 'helperN_2P',
    ('n', 'Z', 'II'): 'helperN_2P_bool',
    ('n', 'V', 'III'): 'helperN_3P',

    # === o() 系列 ===
    ('o', 'V', ''): 'stateMachineU',
    ('o', 'V', 'I'): 'helperO_1P',
    ('o', 'V', 'II'): 'helperO_2P',
    ('o', 'Z', 'II'): 'helperO_2P_bool',
    ('o', 'V', 'III'): 'helperO_3P',

    # === p() 系列 ===
    ('p', 'V', ''): 'clearBackground',
    ('p', 'V', 'I'): 'helperP_1P',
    ('p', 'V', 'II'): 'helperP_2P',
    ('p', 'Z', 'II'): 'helperP_2P_bool',
    ('p', 'V', 'III'): 'helperP_3P',

    # === q() 系列 ===
    ('q', 'V', ''): 'renderMenu',
    ('q', 'V', 'I'): 'helperQ_1P',
    ('q', 'V', 'II'): 'helperQ_2P',
    ('q', 'Z', 'II'): 'helperQ_2P_bool',
    ('q', 'V', 'III'): 'helperQ_3P',

    # === r() 系列 ===
    ('r', 'V', ''): 'handleMenuInput',
    ('r', 'V', 'I'): 'helperR_1P',
    ('r', 'V', 'III'): 'helperR_3P',

    # === s() 系列 ===
    ('s', 'V', ''): 'renderSavePanel',
    ('s', 'V', 'I'): 'helperS_1P',
    ('s', 'V', 'III'): 'helperS_3P',

    # === t() 系列 ===
    ('t', 'V', ''): 'handleSaveLoad',
    ('t', 'V', 'I'): 'helperT_1P',
    ('t', 'V', 'III'): 'helperT_3P',

    # === u() 系列 ===
    ('u', 'V', ''): 'handleFactionSelect',
    ('u', 'V', 'I'): 'helperU_1P',
    ('u', 'V', 'III'): 'helperU_3P',

    # === v() 系列 ===
    ('v', 'V', ''): 'renderFactionSelect',
    ('v', 'V', 'I'): 'helperV_1P',
    ('v', 'V', 'III'): 'helperV_3P',

    # === w() 系列 ===
    ('w', 'V', ''): 'renderSpecialMode',
    ('w', 'V', 'I'): 'helperW_1P',
    ('w', 'V', 'III'): 'helperW_3P',

    # === x() 系列 ===
    ('x', 'V', ''): 'helperX',
    ('x', 'V', 'I'): 'helperX_1P',

    # === y() 系列 ===
    ('y', 'V', ''): 'renderMap',
    ('y', 'V', 'I'): 'helperY_1P',

    # === z() 系列 ===
    ('z', 'V', ''): 'updateEnemyMovement',
    ('z', 'V', 'I'): 'helperZ_1P',

    # === 大写带参方法 ===
    ('A', 'V', 'I'): 'helperA_int',
    ('B', 'V', 'I'): 'helperB_int',
    ('C', 'V', 'I'): 'helperC_int',
    ('D', 'V', 'I'): 'helperD_int',
    ('E', 'V', 'I'): 'helperE_int',
    ('F', 'V', 'I'): 'helperF_int',
    ('G', 'V', 'I'): 'helperG_int',
    ('H', 'V', 'I'): 'helperH_int',
    ('I', 'V', 'I'): 'helperI_int',
    ('J', 'V', 'I'): 'helperJ_int',
    ('K', 'V', 'I'): 'helperK_int',
    ('L', 'V', 'I'): 'helperL_int',
    ('M', 'V', 'I'): 'helperM_int',
    ('N', 'V', 'I'): 'helperN_int',
    ('O', 'V', 'I'): 'helperO_int',
    ('P', 'V', 'I'): 'helperP_int',
    ('Q', 'V', 'I'): 'helperQ_int',
    ('R', 'V', 'I'): 'helperR_int',
    ('S', 'V', 'I'): 'helperS_int',
    ('T', 'V', 'I'): 'helperT_int',
    ('U', 'V', 'I'): 'helperU_int',
    ('V', 'V', 'I'): 'helperV_int',
    ('W', 'V', 'I'): 'helperW_int',
    ('X', 'V', 'I'): 'helperX_int',
    ('Y', 'V', 'I'): 'helperY_int',
    ('Z', 'V', 'I'): 'helperZ_int',
}

# ============================================================
# v13 遗漏的字段映射 (ad, ah, ai, aj)
# ============================================================
EXTRA_FIELD_MAP = {
    'ad': 'tileSize',
    'ah': 'mapCols',
    'ai': 'mapRows',
    'aj': 'mapColsExtended',
}

# ============================================================
# 字段名 → JVM 类型描述符 (用于参数类型推断)
# 基于 01_fields.java 的字段声明
# ============================================================
FIELD_TYPE_MAP = {
    # Image 类型
    'spriteImages': 'Ljavax/microedition/lcdui/Image;',  # Image[][], 单元素是 Image
    'backgroundImages': 'Ljavax/microedition/lcdui/Image;',
    'logoImage': 'Ljavax/microedition/lcdui/Image;',
    'backBufferImage': 'Ljavax/microedition/lcdui/Image;',
    # String 类型
    'gameTexts': 'Ljava/lang/String;',  # String[], 单元素是 String
    'scrollTextCache': 'Ljava/lang/String;',
    'resourcePaths': 'Ljava/lang/String;',  # String[]
    # byte[] 类型
    'enemyHpCoeffs': '[B',
    'altHpCoeffs': '[B',
    'tileProperties': '[B',
    'byteArrayA1151': '[B',
    'tileDataB': '[B',
    'tileDataC': '[B',
    'tileDataD': '[B',
    'tileDataF': '[B',
    'tileDataG': '[B',
    'httpPostData': '[B',
    'httpResponseData': '[B',
    # int[] 类型
    'menuHistoryStack': '[I',
    'towerDamageRange': '[I',
    'towerAtkSpeed': '[I',
    'killRewards': '[I',
    'towerInitLevels': '[I',
    'multiPathFlags': '[I',
    'towerSlots': '[I',
    'colorConstants': '[I',
    'tangentTable': '[I',
    # int[][] 类型 (单元素是 int[])
    'levelSpawnPoints': '[I',
    'mapLayerData': '[I',
    'towerBuildPaths': '[I',
    'techTreeBranches': '[I',
    'levelSequence': '[I',
    'levelConfig': '[I',
    'towerLevelLimits': '[I',
    'upgradeCosts': '[I',
    'directionVectors': '[I',
    # char[] 类型
    'scrollTextCache_arr': '[C',  # 假设
    # 其他
    'gameFont': 'Ljava/lang/...Font;',
    'graphicsCtx': 'Ljava/lang/...Graphics;',
}

# 已重命名的 Image 类字段名集合(用于识别 Image 参数)
IMAGE_FIELD_NAMES = {
    'spriteImages', 'backgroundImages', 'logoImage', 'backBufferImage',
}

# 已重命名的 String 类字段名集合
STRING_FIELD_NAMES = {
    'gameTexts', 'scrollTextCache', 'resourcePaths',
}

# 已重命名的 byte[] 字段名集合
BYTE_ARRAY_FIELD_NAMES = {
    'enemyHpCoeffs', 'altHpCoeffs', 'tileProperties',
    'byteArrayA1151', 'tileDataB', 'tileDataC', 'tileDataD',
    'tileDataF', 'tileDataG', 'httpPostData', 'httpResponseData',
}

# 已重命名的 int[] 字段名集合(作为整体传递时类型是 [I)
INT_ARRAY_FIELD_NAMES = {
    'menuHistoryStack', 'towerDamageRange', 'towerAtkSpeed',
    'killRewards', 'towerInitLevels', 'multiPathFlags',
    'towerSlots', 'colorConstants', 'tangentTable',
}

# int[][] 字段名集合(单元素是 int[])
INT_2D_ARRAY_FIELD_NAMES = {
    'levelSpawnPoints', 'mapLayerData', 'towerBuildPaths',
    'techTreeBranches', 'levelSequence', 'levelConfig',
    'towerLevelLimits', 'upgradeCosts', 'directionVectors',
}


def is_comment_line(line):
    """判断是否是注释行"""
    stripped = line.strip()
    return (stripped.startswith('//') or stripped.startswith('*')
            or stripped.startswith('/*') or stripped.startswith('/**'))


def find_matching_paren(content, start_pos):
    """
    从 start_pos 位置的 '(' 开始, 找到匹配的 ')'.
    返回 ')' 的位置+1 (即参数列表结束后的位置).
    支持跨行. 支持字符串字面量和字符字面量.
    """
    depth = 0
    pos = start_pos
    in_string = False
    in_char = False
    in_line_comment = False
    in_block_comment = False

    while pos < len(content):
        ch = content[pos]
        prev_ch = content[pos - 1] if pos > 0 else ''

        # 处理注释
        if in_line_comment:
            if ch == '\n':
                in_line_comment = False
            pos += 1
            continue
        if in_block_comment:
            if prev_ch == '*' and ch == '/':
                in_block_comment = False
            pos += 1
            continue
        if not in_string and not in_char:
            if ch == '/' and pos + 1 < len(content):
                next_ch = content[pos + 1]
                if next_ch == '/':
                    in_line_comment = True
                    pos += 2
                    continue
                elif next_ch == '*':
                    in_block_comment = True
                    pos += 2
                    continue

        # 处理字符串
        if in_string:
            if ch == '\\' and pos + 1 < len(content):
                pos += 2  # 跳过转义
                continue
            if ch == '"':
                in_string = False
            pos += 1
            continue
        if in_char:
            if ch == '\\' and pos + 1 < len(content):
                pos += 2
                continue
            if ch == "'":
                in_char = False
            pos += 1
            continue

        if ch == '"':
            in_string = True
            pos += 1
            continue
        if ch == "'":
            in_char = True
            pos += 1
            continue

        if ch == '(':
            depth += 1
        elif ch == ')':
            depth -= 1
            if depth == 0:
                return pos + 1
        pos += 1

    return -1  # 未找到匹配


def split_params(params_str):
    """
    将参数字符串按逗号分割 (括号深度=0时).
    返回参数列表.
    """
    params = []
    depth = 0
    current = ''
    in_string = False
    in_char = False

    for ch in params_str:
        if in_string:
            current += ch
            if ch == '"':
                in_string = False
            continue
        if in_char:
            current += ch
            if ch == "'":
                in_char = False
            continue

        if ch == '"':
            in_string = True
            current += ch
        elif ch == "'":
            in_char = True
            current += ch
        elif ch == '(' or ch == '[':
            depth += 1
            current += ch
        elif ch == ')' or ch == ']':
            depth -= 1
            current += ch
        elif ch == ',' and depth == 0:
            params.append(current.strip())
            current = ''
        else:
            current += ch

    if current.strip():
        params.append(current.strip())

    return params


def infer_param_type(param_expr, var_types=None):
    """
    推断单个参数表达式的 JVM 类型描述符.

    参数:
      param_expr - 参数表达式字符串
      var_types - 可选的变量名→JVM类型描述符字典 (局部变量和方法参数)

    返回值:
      'I'  - int
      'Z'  - boolean
      'B'  - byte
      'S'  - short
      'C'  - char
      '[B' - byte[]
      '[C' - char[]
      '[I' - int[]
      'Ljava/lang/String;' - String
      'Ljavax/microedition/lcdui/Image;' - Image
      'I'  - 默认(int) — 大多数情况
    """
    expr = param_expr.strip()
    if var_types is None:
        var_types = {}

    # 空表达式
    if not expr:
        return 'I'

    # boolean 字面量
    if expr == 'true' or expr == 'false':
        return 'Z'

    # int 字面量 (十进制, 负数, 十六进制)
    if re.match(r'^-?\d+$', expr) or re.match(r'^0[xX][0-9a-fA-F]+$', expr):
        return 'I'

    # String 字面量
    if expr.startswith('"'):
        return 'Ljava/lang/String;'

    # char 字面量
    if expr.startswith("'"):
        return 'C'

    # new char[...] → char[]
    if re.match(r'^new\s+char\s*\[', expr):
        return '[C'
    # new byte[...] → byte[]
    if re.match(r'^new\s+byte\s*\[', expr):
        return '[B'
    # new int[...] → int[]
    if re.match(r'^new\s+int\s*\[', expr):
        return '[I'

    # this.fieldName 或 this.fieldName[...] 形式
    this_match = re.match(r'^this\.(\w+)', expr)
    if this_match:
        field_name = this_match.group(1)
        # 检查是否有数组索引
        rest = expr[this_match.end():]
        has_index = rest.startswith('[')

        if field_name in IMAGE_FIELD_NAMES:
            return 'Ljavax/microedition/lcdui/Image;'
        if field_name in STRING_FIELD_NAMES:
            if has_index:
                return 'Ljava/lang/String;'
            return '[Ljava/lang/String;'  # String[]
        if field_name in BYTE_ARRAY_FIELD_NAMES:
            if has_index:
                return 'B'  # byte 单元素
            return '[B'
        if field_name in INT_ARRAY_FIELD_NAMES:
            if has_index:
                return 'I'  # int 单元素
            return '[I'
        if field_name in INT_2D_ARRAY_FIELD_NAMES:
            if has_index:
                # 一级索引后是 int[]
                return '[I'
            return '[[I'
        # 已知的 int 字段
        if field_name in ('gameState', 'menuDepth', 'selectedTowerIdx',
                          'progressBarWidth', 'volume', 'enemyCount',
                          'frameTimeStats', 'bgScrollOffset', 'scrollX',
                          'scrollY', 'scrollY2', 'posX', 'posY', 'posZ',
                          'fontHeight', 'charWidth', 'lineHeight',
                          'screenWidth', 'screenHeight',
                          'tileSize', 'mapCols', 'mapRows', 'mapColsExtended',
                          'frameCounter', 'targetFrame',
                          'tmpA', 'tmpB', 'tmpC', 'tmpD', 'tmpE', 'tmpF',
                          'tmpG', 'tmpH', 'tmpI', 'tmpJ', 'tmpK', 'tmpL',
                          'menuState', 'tmpN', 'tmpO', 'tmpP',
                          'tmpQ', 'tmpR', 'tmpS', 'tmpT',
                          'currentGeneralIdx', 'tmpY', 'tmpZ',
                          'cursorX', 'cursorY', 'levelProgress',
                          'factionIdx', 'saveSlot',
                          'loadingProgress', 'loadingState', 'loadingPercent',
                          'currentMidiIdx', 'keyRepeatGuard',
                          'activeTowerCount', 'currentTurn', 'targetTurn',
                          'screenCenterX', 'screenCenterY',
                          'mapColsG', 'mapColsG2', 'pathCount',
                          'progressValue', 'progressMax',
                          'nextTurnTarget', 'counterT', 'enemyCountT',
                          'threadState', 'httpResponseCode', 'notifyState',
                          'stateMachineU'):
            return 'I'
        # 已知的 boolean 字段
        if field_name in ('flagG', 'flagH', 'flagI',
                          'isRunning', 'isPaused', 'soundEnabled',
                          'musicEnabled', 'vibrationEnabled', 'autoSave',
                          'sceneMode', 'isLandscape', 'isTouch',
                          'isPausedInGame'):
            return 'Z'
        # 默认: int (游戏代码中大部分是 int)
        return 'I'

    # 变量引用 (var1, var2, etc.)
    # 先检查 var_types 字典 (局部变量和方法参数的类型)
    bare_name = expr.split('[')[0].split('.')[0].strip()
    if bare_name in var_types:
        # 如果有数组索引, 返回元素类型
        if '[' in expr and bare_name == expr.strip():
            return var_types[bare_name]  # 整个数组
        elif '[' in expr:
            # 数组访问, 返回元素类型
            full_type = var_types[bare_name]
            if full_type.startswith('['):
                return full_type[1:]  # 去掉一个 [ 前缀
            return full_type  # 不是数组, 返回原类型
        return var_types[bare_name]

    # 尝试从变量名推断: 如果变量名包含特定模式
    if re.match(r'^var\d+$', expr):
        return 'I'  # 默认 int, 后续可通过上下文修正

    # 数组访问 var[idx] → int (默认)
    if re.match(r'^\w+\s*\[', expr):
        return 'I'

    # 方法调用结果 this.method() 或 method()
    # 默认 int
    if '(' in expr:
        return 'I'

    # 算术表达式
    if any(op in expr for op in ['+', '-', '*', '/', '%', '<<', '>>', '&', '|', '^']):
        return 'I'

    # Math.abs(...) 等
    if expr.startswith('Math.'):
        return 'I'

    # 默认: int
    return 'I'


def infer_return_type(before, after, content, call_pos):
    """
    根据调用上下文推断返回类型.
    返回 JVM 描述符: 'V', 'I', 'Z', 'Ljava/lang/String;' 等
    
    重要: 使用 before_last_line (before 的最后一行非空内容) 而不是 before_stripped,
    避免 Python 正则 $ 匹配换行符之前位置的 bug.
    """
    # 取 before 的最后一行内容 (避免 $ 匹配换行前位置的 bug)
    before_lines = before.rstrip().split('\n')
    before_last = before_lines[-1].strip() if before_lines else ''
    after_stripped = after.lstrip()

    # 情况1: 赋值 "Type var = this.xxx()" 或 "= this.xxx()"
    # 检查 = 前面的变量声明类型
    assign_match = re.search(r'(\w+(?:\s*\[\s*\])*)\s+\w+\s*=\s*$', before_last)
    if assign_match:
        var_type = assign_match.group(1).strip()
        type_map = {
            'int': 'I', 'boolean': 'Z', 'byte': 'B', 'short': 'S',
            'long': 'J', 'float': 'F', 'double': 'D', 'char': 'C',
            'String': 'Ljava/lang/String;',
            'Image': 'Ljavax/microedition/lcdui/Image;',
        }
        if var_type in type_map:
            return type_map[var_type]
        # 数组类型
        if var_type.endswith('[]'):
            base = var_type[:-2].strip()
            if base in type_map:
                return '[' + type_map[base]
        return 'I'  # 默认

    # 情况1b: 简单赋值 "var = this.xxx()" (var 已声明)
    # 如果 = 前面只有变量名(无类型声明), 无法确定类型, 默认 int
    if re.search(r'\b\w+\s*=\s*$', before_last):
        # 但需要排除 == 的情况
        if not re.search(r'==\s*$', before_last):
            return 'I'

    # 情况2: "return this.xxx()"
    if re.search(r'return\s+$', before_last):
        # 需要从方法定义获取返回类型
        method_def = find_enclosing_method_def(content, call_pos)
        if method_def:
            ret_type = method_def.get('return_type', 'I')
            type_map = {
                'int': 'I', 'boolean': 'Z', 'byte': 'B', 'short': 'S',
                'long': 'J', 'float': 'F', 'double': 'D', 'char': 'C',
                'void': 'V', 'String': 'Ljava/lang/String;',
                'Image': 'Ljavax/microedition/lcdui/Image;',
            }
            return type_map.get(ret_type, 'I')
        return 'I'

    # 情况3: 条件 "if (this.xxx())" 或 "while (this.xxx())"
    if re.search(r'(?:if|while|do)\s*\(\s*!?\s*$', before_last):
        return 'Z'

    # 情况4: 逻辑表达式 "&& this.xxx()" 或 "|| this.xxx()" 或 "!this.xxx()"
    if re.search(r'&&\s*$', before_last) or re.search(r'\|\|\s*$', before_last):
        return 'Z'
    if re.search(r'!\s*$', before_last):
        return 'Z'

    # 情况5: 比较表达式 "this.xxx() ==" 或 "this.xxx() !="
    if re.match(r'==|!=|<=|>=|<|>', after_stripped):
        return 'I'

    # 情况6: 位操作
    if re.match(r'[&|]', after_stripped) or re.search(r'[&|]\s*$', before_last):
        return 'I'

    # 情况7: 算术操作
    if re.match(r'[+\-*/%]', after_stripped) or re.search(r'[+\-*/%]\s*$', before_last):
        return 'I'

    # 情况8: 移位操作
    if re.match(r'<<|>>', after_stripped) or re.search(r'(?:<<|>>)\s*$', before_last):
        return 'I'

    # 情况9: 数组索引 "this.xxx()]"
    if re.match(r'\]', after_stripped):
        return 'I'

    # 情况10: 独立语句 "this.xxx();" → void
    if after_stripped.startswith(';') or after_stripped.startswith('}'):
        return 'V'

    # 情况11: 字符串连接 "this.xxx() +"
    if re.match(r'\+\s*"', after_stripped):
        return 'I'

    # 情况12: 逗号分隔(多个参数中的一个) - 需要看上下文
    if after_stripped.startswith(','):
        return 'I'  # 默认

    # 情况13: 右括号后跟分号 "this.xxx());"
    if after_stripped.startswith(')'):
        return 'I'  # 可能是参数, 默认 int

    # 默认: void (独立语句)
    return 'V'


def find_enclosing_method_def(content, pos):
    """
    从 pos 位置向前搜索, 找到包含此位置的方法定义.
    返回方法信息字典或 None.
    """
    # 向前搜索方法定义模式
    # 方法定义格式: [modifiers] returnType methodName(params) {
    text = content[:pos]
    # 找最后一个方法定义
    pattern = r'(?:public|private|protected)\s+(?:(?:static|final|synchronized)\s+)*(\w+(?:\s*\[\s*\])*)\s+(\w+)\s*\(([^)]*)\)\s*\{'
    matches = list(re.finditer(pattern, text))
    if matches:
        last_match = matches[-1]
        return {
            'return_type': last_match.group(1).strip(),
            'method_name': last_match.group(2),
            'params': last_match.group(3),
        }
    return None


def find_method_calls(content):
    """
    在文件内容中找到所有 this.X( 形式的方法调用.
    返回列表: [(match_obj, method_name, params_str, call_start, call_end), ...]
    其中 call_start/call_end 是整个调用的位置范围.
    """
    results = []
    # 匹配 this.X( 其中 X 是单字母或双字母
    # 但不匹配 this.X( 其中 X 已经是重命名后的(3+字母)
    pattern = re.compile(r'this\.([a-zA-Z]{1,2})\s*\(')

    for match in pattern.finditer(content):
        method_name = match.group(1)

        # 检查是否在注释中
        line_start = content.rfind('\n', 0, match.start()) + 1
        line_prefix = content[line_start:match.start()].strip()
        if line_prefix.startswith('//') or line_prefix.startswith('*'):
            continue

        # 找到匹配的右括号
        paren_open = match.end() - 1  # ( 的位置
        paren_close = find_matching_paren(content, paren_open)
        if paren_close == -1:
            continue

        params_str = content[paren_open + 1:paren_close - 1]

        # 跳过已重命名的方法调用 (方法名是 3+ 字母的 camelCase)
        if len(method_name) >= 3 and method_name[0].islower() and any(c.isupper() for c in method_name):
            continue
        # 跳过全大写方法名但非单字母 (如 IMG, URL 等)
        if len(method_name) >= 3 and method_name.isupper():
            continue

        results.append({
            'match': match,
            'method_name': method_name,
            'params_str': params_str,
            'call_start': match.start(),
            'call_end': paren_close,
            'paren_open': paren_open,
            'paren_close': paren_close,
        })

    return results


def java_type_to_jvm_desc(java_type):
    """将 Java 类型字符串转换为 JVM 描述符"""
    java_type = java_type.strip()
    array_dim = 0
    while java_type.endswith('[]'):
        array_dim += 1
        java_type = java_type[:-2].strip()

    base_map = {
        'int': 'I', 'boolean': 'Z', 'byte': 'B', 'short': 'S',
        'long': 'J', 'float': 'F', 'double': 'D', 'char': 'C',
        'void': 'V',
        'String': 'Ljava/lang/String;',
        'Image': 'Ljavax/microedition/lcdui/Image;',
        'Graphics': 'Ljavax/microedition/lcdui/Graphics;',
        'Font': 'Ljava/lang/Object;',
        'Object': 'Ljava/lang/Object;',
        'Random': 'Ljava/util/Random;',
    }
    if java_type in base_map:
        return '[' * array_dim + base_map[java_type]
    # 未知类型默认 int
    return '[' * array_dim + 'I'


def build_var_types_map(content, call_pos):
    """
    构建局部变量类型映射 (变量名 → JVM 类型描述符).
    扫描包含 call_pos 的方法定义和方法体.
    """
    var_types = {}

    # 找到包含此位置的方法定义
    text_before = content[:call_pos]
    # 找最后一个方法定义
    pattern = r'(?:public|private|protected)\s+(?:(?:static|final|synchronized)\s+)*(\w+(?:\s*\[\s*\])*)\s+(\w+)\s*\(([^)]*)\)\s*\{'
    matches = list(re.finditer(pattern, text_before))
    if not matches:
        return var_types

    last_match = matches[-1]
    method_start = last_match.start()
    method_body_start = last_match.end()

    # 解析方法参数
    params_str = last_match.group(3)
    if params_str.strip():
        for param in split_params(params_str):
            # 格式: Type varName 或 Type[] varName
            parts = param.strip().split()
            if len(parts) >= 2:
                type_str = parts[0]
                var_name = parts[-1]
                # 处理 "int[] varName" 格式
                if len(parts) >= 3 and '[]' in parts[1]:
                    type_str = parts[0] + '[]'
                var_types[var_name] = java_type_to_jvm_desc(type_str)

    # 扫描方法体内的局部变量声明 (从方法体开始到 call_pos)
    body_text = content[method_body_start:call_pos]
    # 匹配局部变量声明: Type varName = ... 或 Type varName;
    # 格式: (缩进)Type varName = 或 Type varName;
    var_pattern = r'(?:^|\n)\s*(\w+(?:\s*\[\s*\])*)\s+(\w+)\s*(?:=|;)'
    for m in re.finditer(var_pattern, body_text):
        type_str = m.group(1).strip()
        var_name = m.group(2)
        # 跳过关键字
        if type_str in ('if', 'while', 'for', 'switch', 'return', 'else', 'case',
                        'break', 'continue', 'new', 'this', 'super', 'try', 'catch',
                        'finally', 'throw', 'throws', 'class', 'interface', 'enum',
                        'extends', 'implements', 'import', 'package', 'public',
                        'private', 'protected', 'static', 'final', 'abstract',
                        'void', 'int', 'boolean', 'byte', 'short', 'long', 'float',
                        'double', 'char', 'String'):
            if type_str in ('int', 'boolean', 'byte', 'short', 'long', 'float',
                            'double', 'char', 'String', 'void'):
                # type_str 本身就是类型, var_name 是变量名
                pass
            else:
                continue
        # 跳过方法定义模式 (Type methodName(...)
        if var_name in ('if', 'while', 'for', 'switch', 'return', 'else', 'case',
                        'break', 'continue', 'new', 'this', 'super', 'try', 'catch'):
            continue
        var_types[var_name] = java_type_to_jvm_desc(type_str)

    return var_types


def build_param_descriptor(params_str, content, call_pos, var_types=None):
    """
    将参数列表转换为 JVM 参数描述符.
    """
    if not params_str.strip():
        return ''

    if var_types is None:
        var_types = {}

    params = split_params(params_str)
    descriptors = []
    for param in params:
        desc = infer_param_type(param, var_types)
        descriptors.append(desc)

    return ''.join(descriptors)


def find_method_candidates(method_name, param_count, return_type):
    """
    在 METHOD_MAP 中查找所有匹配 (方法名, 参数个数, 返回类型) 的候选.
    返回 [(param_desc, semantic_name), ...]
    """
    candidates = []
    for (name, ret, param_desc), semantic_name in METHOD_MAP.items():
        if name != method_name or ret != return_type:
            continue
        # 计算参数个数
        if param_desc == '':
            count = 0
        else:
            # 计算 JVM 描述符中的参数个数
            count = count_jvm_params(param_desc)
        if count == param_count:
            candidates.append((param_desc, semantic_name))

    return candidates


def count_jvm_params(desc):
    """计算 JVM 参数描述符中的参数个数"""
    if not desc:
        return 0
    count = 0
    i = 0
    while i < len(desc):
        if desc[i] == '[':
            i += 1
            continue
        if desc[i] == 'L':
            # 对象类型, 找到 ;
            end = desc.find(';', i)
            if end == -1:
                return count + 1  # 异常, 返回
            i = end + 1
        else:
            i += 1
        count += 1
    return count


def resolve_ambiguity(candidates, params_str, content, call_pos, var_types=None):
    """
    当有多个候选时, 通过参数类型推断解决歧义.
    返回选中的 (param_desc, semantic_name) 或 None.
    """
    if len(candidates) == 1:
        return candidates[0]

    if len(candidates) == 0:
        return None

    if var_types is None:
        var_types = {}

    # 推断实际参数描述符
    actual_desc = build_param_descriptor(params_str, content, call_pos, var_types)

    # 尝试精确匹配
    for param_desc, semantic_name in candidates:
        if param_desc == actual_desc:
            return (param_desc, semantic_name)

    # 尝试模糊匹配: 检查每个参数是否匹配
    params = split_params(params_str)
    actual_param_types = [infer_param_type(p, var_types) for p in params]

    best_match = None
    best_score = -1

    for param_desc, semantic_name in candidates:
        # 解析候选的参数类型列表
        candidate_types = parse_jvm_param_types(param_desc)
        if len(candidate_types) != len(actual_param_types):
            continue

        score = 0
        for actual, candidate in zip(actual_param_types, candidate_types):
            if actual == candidate:
                score += 1
            elif actual == 'I' and candidate in ('B', 'S', 'C'):
                # int 可以兼容 byte/short/char
                score += 0.5

        if score > best_score:
            best_score = score
            best_match = (param_desc, semantic_name)

    return best_match


def parse_jvm_param_types(desc):
    """将 JVM 参数描述符解析为类型列表"""
    types = []
    i = 0
    while i < len(desc):
        if desc[i] == '[':
            # 数组
            j = i + 1
            while j < len(desc) and desc[j] == '[':
                j += 1
            if j < len(desc):
                if desc[j] == 'L':
                    end = desc.find(';', j)
                    if end != -1:
                        types.append(desc[i:end + 1])
                        i = end + 1
                    else:
                        types.append(desc[i:])
                        i = len(desc)
                else:
                    types.append(desc[i:j + 1])
                    i = j + 1
            else:
                i = len(desc)
        elif desc[i] == 'L':
            end = desc.find(';', i)
            if end != -1:
                types.append(desc[i:end + 1])
                i = end + 1
            else:
                types.append(desc[i:])
                i = len(desc)
        else:
            types.append(desc[i])
            i += 1
    return types


def process_method_calls(content, dry_run=False):
    """
    处理所有 this.X( 方法调用.
    返回 (new_content, replacement_count, analysis_results)
    """
    calls = find_method_calls(content)
    analysis_results = []
    replacements = []  # (start, end, new_text) 逆序排列

    for call_info in calls:
        method_name = call_info['method_name']
        params_str = call_info['params_str']
        call_start = call_info['call_start']
        call_end = call_info['call_end']
        paren_open = call_info['paren_open']
        paren_close = call_info['paren_close']

        # 解析参数个数
        params = split_params(params_str)
        param_count = len(params)

        # 推断返回类型
        before = content[:call_start]
        after = content[call_end:]
        return_type = infer_return_type(before, after, content, call_start)

        # 查找候选
        candidates = find_method_candidates(method_name, param_count, return_type)

        # Fallback: 如果推断为 int 但无候选, 尝试 boolean
        # (JVM 中 int 和 boolean 在某些操作中兼容, 反编译器可能误判)
        if not candidates and return_type == 'I':
            candidates = find_method_candidates(method_name, param_count, 'Z')
            if candidates:
                return_type = 'Z'

        # Fallback: 如果推断为 int 但无候选, 尝试 void
        # (独立语句可能被误判为 int)
        if not candidates and return_type == 'I':
            candidates = find_method_candidates(method_name, param_count, 'V')
            if candidates:
                return_type = 'V'

        # 构建局部变量类型映射
        var_types = build_var_types_map(content, call_start)

        # 解决歧义
        resolved = resolve_ambiguity(candidates, params_str, content, call_start, var_types)

        # 获取行号
        line_num = content[:call_start].count('\n') + 1
        # 获取行内容
        line_start = content.rfind('\n', 0, call_start) + 1
        line_end = content.find('\n', call_end)
        if line_end == -1:
            line_end = len(content)
        line_content = content[line_start:line_end].strip()

        if resolved:
            param_desc, semantic_name = resolved
            analysis_results.append({
                'line': line_num,
                'method': method_name,
                'param_count': param_count,
                'return_type': return_type,
                'param_desc': param_desc,
                'semantic_name': semantic_name,
                'status': 'OK',
                'line_content': line_content[:80],
            })
            # 准备替换: 只替换方法名部分
            # this.methodName( → this.semanticName(
            old_text = content[call_start:paren_open + 1]
            new_text = f'this.{semantic_name}('
            replacements.append((call_start, paren_open + 1, new_text))
        else:
            analysis_results.append({
                'line': line_num,
                'method': method_name,
                'param_count': param_count,
                'return_type': return_type,
                'param_desc': '?',
                'semantic_name': '??? (未匹配)',
                'status': 'MISS',
                'line_content': line_content[:80],
                'candidates': [(d, n) for d, n in candidates],
            })

    # 执行替换 (逆序)
    new_content = content
    for start, end, new_text in reversed(replacements):
        new_content = new_content[:start] + new_text + new_content[end:]

    return new_content, len(replacements), analysis_results


def process_field_references(content, dry_run=False):
    """
    替换剩余字段引用 (this.ad, this.ai 等).
    """
    replacements = 0
    new_content = content

    for old_name, new_name in EXTRA_FIELD_MAP.items():
        # 替换 this.oldName (不是方法调用, 后面不跟 ()
        # 格式: this.oldName 后面不是 ( 也不是字母/数字/_
        pattern = re.compile(r'this\.' + re.escape(old_name) + r'(?!\s*\()(?![a-zA-Z0-9_])')

        matches = list(pattern.finditer(new_content))
        # 逆序替换
        for match in reversed(matches):
            # 检查是否在注释中
            line_start = new_content.rfind('\n', 0, match.start()) + 1
            line_prefix = new_content[line_start:match.start()].strip()
            if line_prefix.startswith('//') or line_prefix.startswith('*'):
                continue

            # 替换
            old_text = f'this.{old_name}'
            new_text = f'this.{new_name}'
            new_content = new_content[:match.start()] + new_text + new_content[match.end():]
            replacements += 1

    return new_content, replacements


def process_field_declarations(content, dry_run=False):
    """
    替换剩余字段声明 (ad, ah, ai, aj).
    """
    replacements = 0
    new_content = content

    for old_name, new_name in EXTRA_FIELD_MAP.items():
        # 匹配字段声明: private [final] Type oldName;
        # 格式: [modifiers] Type oldName; 或 [modifiers] Type oldName =
        pattern = re.compile(
            r'((?:private|public|protected)\s+(?:(?:static|final|volatile|transient)\s+)*'
            r'\w+(?:\s*\[\s*\])*\s+)' + re.escape(old_name) + r'(\s*(?:=|;))'
        )

        def replace_decl(m):
            nonlocal replacements
            replacements += 1
            return m.group(1) + new_name + m.group(2)

        new_content = pattern.sub(replace_decl, new_content)

    return new_content, replacements


def main():
    dry_run = '--dry-run' in sys.argv

    print("=" * 60)
    print("v14 完成剩余替换脚本")
    print(f"模式: {'Dry-run (仅分析)' if dry_run else '执行替换'}")
    print("=" * 60)

    # 获取目标文件
    target_files = []
    for f in sorted(os.listdir(RENAMED_DIR)):
        if re.match(r'^0[0-9]_.*\.java$', f):
            target_files.append(f)

    print(f"目标文件: {len(target_files)} 个")

    if not dry_run:
        # 创建备份
        if not os.path.exists(BACKUP_DIR):
            os.makedirs(BACKUP_DIR)
            print(f"创建备份目录: {BACKUP_DIR}")

    total_call_repl = 0
    total_field_ref_repl = 0
    total_field_decl_repl = 0
    all_analysis = []

    for filename in target_files:
        filepath = os.path.join(RENAMED_DIR, filename)
        with open(filepath, 'r', encoding='utf-8') as f:
            content = f.read()

        original_content = content
        print(f"\n处理: {filename}")

        # Part 1: 方法调用替换
        content, call_repl, analysis = process_method_calls(content, dry_run)
        print(f"  方法调用替换: {call_repl}")
        total_call_repl += call_repl
        all_analysis.extend([(filename, a) for a in analysis])

        # Part 2: 字段引用替换
        content, field_ref_repl = process_field_references(content, dry_run)
        print(f"  字段引用替换: {field_ref_repl}")
        total_field_ref_repl += field_ref_repl

        # Part 3: 字段声明替换 (仅 01_fields.java)
        if filename == '01_fields.java':
            content, field_decl_repl = process_field_declarations(content, dry_run)
            print(f"  字段声明替换: {field_decl_repl}")
            total_field_decl_repl += field_decl_repl

        # 写回文件 (非 dry-run 模式)
        if not dry_run and content != original_content:
            if not os.path.exists(BACKUP_DIR):
                os.makedirs(BACKUP_DIR)
            backup_path = os.path.join(BACKUP_DIR, filename)
            shutil.copy2(filepath, backup_path)
            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(content)
            print(f"  [OK] 已更新 (备份在 {BACKUP_DIR})")

    print("\n" + "=" * 60)
    print("总计:")
    print(f"  方法调用替换: {total_call_repl}")
    print(f"  字段引用替换: {total_field_ref_repl}")
    print(f"  字段声明替换: {total_field_decl_repl}")
    print(f"  总替换次数: {total_call_repl + total_field_ref_repl + total_field_decl_repl}")
    print("=" * 60)

    # 输出分析结果
    if dry_run:
        print("\n" + "=" * 60)
        print("Dry-run 分析结果")
        print("=" * 60)

        ok_count = sum(1 for _, a in all_analysis if a['status'] == 'OK')
        miss_count = sum(1 for _, a in all_analysis if a['status'] == 'MISS')
        print(f"成功匹配: {ok_count}")
        print(f"未匹配: {miss_count}")

        if miss_count > 0:
            print("\n--- 未匹配的调用 ---")
            for filename, a in all_analysis:
                if a['status'] == 'MISS':
                    print(f"  {filename}:{a['line']} this.{a['method']}({a['param_count']}P) "
                          f"ret={a['return_type']} | {a['line_content']}")
                    if 'candidates' in a:
                        for desc, name in a['candidates']:
                            print(f"    候选: ({desc}) → {name}")

        # 输出所有匹配的调用
        print("\n--- 成功匹配的调用 ---")
        for filename, a in all_analysis:
            if a['status'] == 'OK':
                print(f"  {filename}:{a['line']} this.{a['method']}({a['param_count']}P) "
                      f"→ this.{a['semantic_name']}({a['param_desc']}) | {a['line_content']}")


if __name__ == '__main__':
    main()
