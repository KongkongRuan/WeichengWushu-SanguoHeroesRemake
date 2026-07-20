#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
v13 剩余重命名脚本
基于 javap 字节码精确签名,完成以下替换:
  1. 带参数的方法定义和调用
  2. a()/b()/c()/d() 无参方法(通过上下文区分返回类型)
  3. 单字母/双字母字段名
"""

import re
import os
import sys
from collections import defaultdict

# ============================================================
# 配置
# ============================================================
RENAMED_DIR = r"d:\Development\ts\WeichengWushu-SanguoHeroesRemake\a_java_analysis\deobfuscated_modules_renamed"
BACKUP_DIR = r"d:\Development\ts\WeichengWushu-SanguoHeroesRemake\a_java_analysis\deobfuscated_modules_renamed_backup_v13"
TARGET_FILES = [f"{i:02d}_*.java" for i in range(10)]

# ============================================================
# 方法映射表
# 格式: (混淆名, 返回类型, 参数数量) → 语义名
# 返回类型: 'V'=void, 'I'=int, 'Z'=boolean, 'S'=short, 'Ljava/lang/String;'=String
# 参数数量: -1=无参, 0=未知, 1+=具体参数数量
# ============================================================

# 基于 10_rename_map.java 和字节码核对的完整映射
# 参数描述用简写: I=int, Z=boolean, B=byte, J=long, Ljavax/microedition/lcdui/Image;=Image
# 格式: (原名, 返回类型JVM描述符, 参数JVM描述符列表) → 语义名
METHOD_MAP = {
    # === a() 系列 ===
    # a() 无参
    ('a', 'I', ''): 'randomByte',              # private final int a()
    ('a', 'V', ''): 'menuReturn',              # private void a()
    ('a', 'Z', ''): 'loadRMS_sanGuoTd',        # private final boolean a()

    # a(int) 单参
    ('a', 'I', 'I'): 'getTileProperty',        # private int a(int)
    ('a', 'V', 'I'): 'menuGoto',               # private void a(int)
    ('a', 'Z', 'I'): 'isOdd_static',           # private static boolean a(int) [static]

    # a(int,int) 双参
    ('a', 'I', 'II'): 'calcTileIndex',         # private int a(int,int)
    ('a', 'V', 'II'): 'loadSprites',           # private void a(int,int)
    ('a', 'Z', 'II'): 'helperA_2P_bool',       # private boolean a(int,int)

    # a(int,int,int) 三参
    ('a', 'I', 'III'): 'calcAngle',            # private int a(int,int,int)
    ('a', 'V', 'III'): 'drawStringAt',         # private void a(int,int,int) - 字节码确认:drawString
    ('a', 'Z', 'III'): 'helperA_3P_bool',      # private boolean a(int,int,int)

    # a(int,int,int,int) 四参
    ('a', 'I', 'IIII'): 'calcAngleFromDelta',  # private int a(int,int,int,int)
    ('a', 'V', 'IIII'): 'helperA_4P',          # private void a(int,int,int,int)

    # a(int,int,int,int,int) 五参
    ('a', 'V', 'IIIII'): 'renderRangeAttack',  # private void a(int,int,int,int,int)
    ('a', 'Z', 'IIIII'): 'helperA_5P_bool2',   # private boolean a(int,int,int,int,int)

    # a(int,int,int,int,int,int) 六参
    ('a', 'V', 'IIIIII'): 'helperA_6P',        # private void a(int,int,int,int,int,int)
    ('a', 'Z', 'IIIIII'): 'helperA_6P_bool_static', # private static boolean a(int,int,int,int,int,int)

    # a(int,int,int,int,int,int,int) 七参
    ('a', 'V', 'IIIIIII'): 'helperA_7P',       # private void a(int,int,int,int,int,int,int)

    # a(int,int,int,int,int,int,int,int) 八参
    ('a', 'V', 'IIIIIIII'): 'helperA_8P',      # private void a(int,int,int,int,int,int,int,int)

    # a(int,int,int,byte,int,boolean) 六参特殊
    ('a', 'V', 'IIIBIZ'): 'fillTile',          # private void a(int,int,int,byte,int,boolean)

    # a(int,int,int,int,boolean) 五参bool
    ('a', 'V', 'IIIIZ'): 'helperA_5P_bool',    # private void a(int,int,int,int,boolean)

    # a(int,int,int,boolean) 四参bool
    ('a', 'V', 'IIIZ'): 'helperA_4P_bool',     # private void a(int,int,int,boolean)
    ('a', 'Z', 'IIIZ'): 'helperA_4P_bool2',    # private boolean a(int,int,int,boolean)

    # a(int,int,boolean) 三参bool
    ('a', 'V', 'IIZ'): 'helperA_3P_bool',      # private void a(int,int,boolean)

    # a(boolean) 单参bool
    ('a', 'V', 'Z'): 'renderHelpPage',         # private void a(boolean)

    # a(byte) 单参byte
    ('a', 'V', 'B'): 'setGameMode',            # private void a(byte)

    # a(byte[]) 单参byte[]
    ('a', 'V', '[B'): 'helperA_byteArr',       # private void a(byte[])

    # a(char[],int,int,int,int,int,int,boolean) 八参特殊
    ('a', 'V', '[CIIIIIIZ'): 'renderChars',    # private void a(char[],int,int,int,int,int,int,boolean)

    # a(int,byte[],int) 三参
    ('a', 'I', 'I[BI'): 'calcHp',              # private int a(int,byte[],int)

    # a(int[],int[][],int,int) 四参 [static]
    ('a', 'V', '[I[[III'): 'updateTowerArray_static', # private static void a(int[],int[][],int,int)

    # a(String) 单参String
    ('a', 'V', 'Ljava/lang/String;'): 'renderScrollText', # private void a(String)
    ('a', 'Ljava/lang/String;', 'Ljava/lang/String;'): 'extractHostName_static', # static

    # a(String,int,int) 三参String
    ('a', 'V', 'Ljava/lang/String;II'): 'helperA_Str2P',  # private void a(String,int,int)

    # a(String,int,int,int,int,int) 六参String
    ('a', 'V', 'Ljava/lang/String;IIIII'): 'drawTextPanel', # private void a(String,int,int,int,int,int)

    # a(DataInputStream) [static]
    ('a', 'Ljava/lang/String;', 'Ljava/io/DataInputStream;'): 'readCustomString_static',

    # a(InputStream) [static]
    ('a', 'S', 'Ljava/io/InputStream;'): 'readShortLE_static',

    # a(Image,int,int,int) 四参Image
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageRotation',

    # a(Image,int,int,int,int) 五参Image
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIII'): 'drawImageTiled',

    # a(Image,...,6参数)
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIII'): 'drawImageVariant6P',

    # a(Image,...,7参数)
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIIII'): 'drawImageVariant7P',

    # a(Image,...,8参数)
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIIIII'): 'drawImageVariant8P',

    # a(Image,...,9参数)
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIIIIII'): 'drawImageVariant9P',

    # a(Image,...,10参数)
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIIIIIII'): 'drawImageVariant10P',

    # a(Image,int,int,int,boolean)
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;IIIZ'): 'drawImageVariant5P_bool',

    # a(Image,Image,...,7参数)
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;Ljavax/microedition/lcdui/Image;IIIII'): 'drawImage2Imgs7P',

    # a(Image,Image,Image,...,7参数)
    ('a', 'V', 'Ljavax/microedition/lcdui/Image;Ljavax/microedition/lcdui/Image;Ljavax/microedition/lcdui/Image;IIII'): 'drawImage3Imgs7P',

    # === b() 系列 ===
    ('b', 'I', ''): 'getThreadState',          # private int b()
    ('b', 'V', ''): 'menuReset',               # private void b()
    ('b', 'Z', ''): 'loadRMS_sanGuoTdData',    # private final boolean b()

    ('b', 'I', 'I'): 'calcEnemyHp',            # private int b(int)
    ('b', 'V', 'I'): 'menuBackTo',             # private void b(int)
    ('b', 'Z', 'I'): 'canBuildTower',          # private boolean b(int)

    ('b', 'I', 'II'): 'tileCoordConvert',      # private int b(int,int)
    ('b', 'V', 'II'): 'drawBg',                # private void b(int,int)
    ('b', 'Z', 'II'): 'canBuildTowerAt',       # private boolean b(int,int)

    ('b', 'I', 'III'): 'helperB_3P',           # private int b(int,int,int)
    ('b', 'V', 'III'): 'helperB_3P_void',      # private void b(int,int,int) - 字节码确认:drawSpriteRow
    ('b', 'I', 'IIII'): 'distanceSq_static',   # private static int b(int,int,int,int)
    ('b', 'V', 'IIII'): 'helperB_4P',          # private void b(int,int,int,int)
    ('b', 'V', 'IIIII'): 'helperB_5P',         # private void b(int,int,int,int,int)
    ('b', 'V', 'IIIIII'): 'helperB_6P',        # private void b(int,int,int,int,int,int)
    ('b', 'V', 'IIIIIIII'): 'helperB_8P',      # private void b(int,int,int,int,int,int,int,int)
    ('b', 'V', 'IIIIZ'): 'helperB_5P_bool',    # private void b(int,int,int,int,boolean)
    ('b', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageVariantB4P',
    ('b', 'V', 'Ljavax/microedition/lcdui/Image;IIII'): 'drawImageVariantB5P',
    ('b', 'V', 'Ljavax/microedition/lcdui/Image;IIIIIIIII'): 'drawImageVariantB9P',
    ('b', 'Ljava/lang/String;', 'Ljava/lang/String;'): 'rewriteUrlProxy', # private String b(String)
    ('b', 'V', 'Ljava/lang/String;'): 'handleStringStatic_static', # private static void b(String)

    # === c() 系列 ===
    ('c', 'I', ''): 'waitHttpResponse',        # private int c()
    ('c', 'V', ''): 'resetCounters',           # private void c()
    ('c', 'Z', ''): 'loadRMS_freeGame',        # private final boolean c()

    ('c', 'I', 'I'): 'calcDirection_static',   # private static int c(int)
    ('c', 'V', 'I'): 'loadSprite',             # private void c(int)
    ('c', 'Z', 'I'): 'isTileEven',             # private boolean c(int)

    ('c', 'I', 'II'): 'checkTileBoundary',     # private int c(int,int)
    ('c', 'V', 'II'): 'drawSpriteRow',         # private void c(int,int) - 字节码确认
    ('c', 'Z', 'II'): 'helperC_2P_bool',       # private boolean c(int,int)

    ('c', 'I', 'III'): 'helperC_3P',           # private int c(int,int,int)
    ('c', 'V', 'III'): 'helperC_3P_void',      # private void c(int,int,int)
    ('c', 'V', 'IIII'): 'helperC_4P',          # private void c(int,int,int,int)
    ('c', 'V', 'IIIII'): 'helperC_5P',         # private void c(int,int,int,int,int)
    ('c', 'V', 'IIIIII'): 'helperC_6P',        # private void c(int,int,int,int,int,int)
    ('c', 'V', 'IIIIZ'): 'helperC_5P_bool',    # private void c(int,int,int,int,boolean)
    ('c', 'V', 'Ljava/lang/String;'): 'adaptDevice', # private void c(String)
    ('c', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageVariantC4P',

    # === d() 系列 ===
    ('d', 'I', ''): 'doHttpCommunication',     # private int d()
    ('d', 'V', ''): 'drawBuildMenuBg',         # private void d()
    ('d', 'Z', ''): 'checkLandscape',          # private boolean d()

    ('d', 'I', 'I'): 'convertTileType',        # private int d(int)
    ('d', 'V', 'I'): 'drawScrollingBg',        # private void d(int)
    ('d', 'Z', 'I'): 'validateEnemyPath',      # private boolean d(int)

    ('d', 'I', 'III'): 'calcBaseHp_static',    # private static int d(int,int,int)
    ('d', 'V', 'II'): 'drawSpriteBottom',      # private void d(int,int) - 字节码确认
    ('d', 'Z', 'II'): 'helperD_2P_bool',       # private boolean d(int,int)
    ('d', 'V', 'III'): 'helperD_3P',           # private void d(int,int,int)
    ('d', 'V', 'IIII'): 'helperD_4P',          # private void d(int,int,int,int)
    ('d', 'V', 'IIIII'): 'helperD_5P',         # private void d(int,int,int,int,int)
    ('d', 'V', 'IIIIII'): 'helperD_6P',        # private void d(int,int,int,int,int,int)
    ('d', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageVariantD4P',

    # === e() 系列 ===
    ('e', 'V', ''): 'clearScreen',             # private void e()
    ('e', 'Z', ''): 'isTechTreeUnlocked',      # private boolean e()

    ('e', 'I', 'I'): 'hexCharToInt_static',    # private static final int e(int)
    ('e', 'V', 'I'): 'updateLoadingProgress',  # private void e(int)
    ('e', 'Z', 'I'): 'checkEnemyAttack',       # private boolean e(int)

    ('e', 'V', 'II'): 'drawSpriteGrid',        # private void e(int,int) - 字节码确认
    ('e', 'Z', 'II'): 'isTileType8',           # private boolean e(int,int)
    ('e', 'V', 'III'): 'helperE_3P',           # private void e(int,int,int)
    ('e', 'V', 'IIII'): 'helperE_4P',          # private void e(int,int,int,int)
    ('e', 'V', 'IIIII'): 'helperE_5P',         # private void e(int,int,int,int,int)
    ('e', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageVariantE4P',

    # === f() 系列 ===
    ('f', 'V', ''): 'drawProgressBar',         # private void f()
    ('f', 'Z', ''): 'initGame',                # private boolean f()

    ('f', 'V', 'I'): 'helperF_1P',             # private void f(int)
    ('f', 'Z', 'I'): 'isNotCommonTower_static', # private static boolean f(int)
    ('f', 'V', 'II'): 'helperF_2P',            # private void f(int,int) - 字节码确认:handleGameInput
    ('f', 'Z', 'II'): 'isTileType10',          # private boolean f(int,int)
    ('f', 'V', 'III'): 'helperF_3P',           # private void f(int,int,int)
    ('f', 'V', 'IIII'): 'helperF_4P',          # private void f(int,int,int,int)
    ('f', 'V', 'IIIII'): 'helperF_5P',         # private void f(int,int,int,int,int)
    ('f', 'V', 'Ljavax/microedition/lcdui/Image;III'): 'drawImageVariantF4P',

    # === g() 系列 ===
    ('g', 'V', ''): 'handleVolume',            # private void g()
    ('g', 'Z', ''): 'uploadScore',             # private boolean g()

    ('g', 'V', 'I'): 'helperG_1P',             # private void g(int)
    ('g', 'Z', 'I'): 'isType6_static',         # private static boolean g(int)
    ('g', 'V', 'II'): 'helperG_2P',            # private void g(int,int)
    ('g', 'Z', 'II'): 'helperG_2P_bool',       # private boolean g(int,int)
    ('g', 'V', 'III'): 'helperG_3P',           # private void g(int,int,int)
    ('g', 'V', 'IIII'): 'helperG_4P',          # private void g(int,int,int,int)
    ('g', 'V', 'IIIII'): 'helperG_5P',         # private void g(int,int,int,int,int)

    # === h() 系列 ===
    ('h', 'V', 'I'): 'helperH_1P',             # private void h(int)
    ('h', 'Z', 'I'): 'randomLessThan',         # private boolean h(int)
    ('h', 'V', 'II'): 'renderGameState22',     # private void h(int,int) - 字节码确认
    ('h', 'Z', 'II'): 'helperH_2P_bool',       # private boolean h(int,int)
    ('h', 'V', 'III'): 'helperH_3P',           # private void h(int,int,int)
    ('h', 'V', 'IIII'): 'helperH_4P',          # private void h(int,int,int,int)
    ('h', 'V', 'IIIII'): 'helperH_5P',         # private void h(int,int,int,int,int)

    # === i() 系列 ===
    ('i', 'V', ''): 'handleVolumeInput',       # private void i()
    ('i', 'V', 'I'): 'controlMidiPlayer',      # private void i(int)
    ('i', 'Z', 'I'): 'helperI_1P_bool',        # private boolean i(int)
    ('i', 'V', 'II'): 'helperI_2P',            # private void i(int,int)
    ('i', 'Z', 'II'): 'helperI_2P_bool',       # private boolean i(int,int)
    ('i', 'V', 'III'): 'helperI_3P',           # private void i(int,int,int)
    ('i', 'V', 'IIII'): 'helperI_4P',          # private void i(int,int,int,int)

    # === j() 系列 ===
    ('j', 'V', ''): 'renderJ',                 # private void j()
    ('j', 'V', 'I'): 'helperJ_1P',             # private void j(int)
    ('j', 'Z', 'I'): 'helperJ_1P_bool',        # private boolean j(int)
    ('j', 'V', 'II'): 'helperJ_2P',            # private void j(int,int)
    ('j', 'Z', 'II'): 'helperJ_2P_bool',       # private boolean j(int,int)
    ('j', 'V', 'III'): 'helperJ_3P',           # private void j(int,int,int)

    # === k() 系列 ===
    ('k', 'V', ''): 'initRandom',              # private void k()
    ('k', 'V', 'I'): 'helperK_1P',             # private void k(int)
    ('k', 'V', 'II'): 'helperK_2P',            # private void k(int,int)
    ('k', 'Z', 'II'): 'helperK_2P_bool',       # private boolean k(int,int)
    ('k', 'V', 'III'): 'helperK_3P',           # private void k(int,int,int)

    # === l() 系列 ===
    ('l', 'V', ''): 'drawMap',                 # private void l()
    ('l', 'V', 'I'): 'updateTowerLogic',       # private void l(int)
    ('l', 'V', 'II'): 'helperL_2P',            # private void l(int,int)
    ('l', 'Z', 'II'): 'helperL_2P_bool',       # private boolean l(int,int)
    ('l', 'V', 'III'): 'helperL_3P',           # private void l(int,int,int)

    # === m() 系列 ===
    ('m', 'V', ''): 'handleMainMenu',          # private void m()
    ('m', 'V', 'I'): 'helperM_1P',             # private void m(int)
    ('m', 'V', 'II'): 'helperM_2P',            # private void m(int,int)
    ('m', 'Z', 'II'): 'helperM_2P_bool',       # private boolean m(int,int)
    ('m', 'V', 'III'): 'helperM_3P',           # private void m(int,int,int)

    # === n() 系列 ===
    ('n', 'V', ''): 'updateScrollPos',         # private void n()
    ('n', 'V', 'I'): 'helperN_1P',             # private void n(int)
    ('n', 'V', 'II'): 'helperN_2P',            # private void n(int,int)
    ('n', 'Z', 'II'): 'helperN_2P_bool',       # private boolean n(int,int)
    ('n', 'V', 'III'): 'helperN_3P',           # private void n(int,int,int)

    # === o() 系列 ===
    ('o', 'V', ''): 'stateMachineU',           # private void o()
    ('o', 'V', 'I'): 'helperO_1P',             # private void o(int)
    ('o', 'V', 'II'): 'helperO_2P',            # private void o(int,int)
    ('o', 'Z', 'II'): 'helperO_2P_bool',       # private boolean o(int,int)
    ('o', 'V', 'III'): 'helperO_3P',           # private void o(int,int,int)

    # === p() 系列 ===
    ('p', 'V', ''): 'clearBackground',         # private void p()
    ('p', 'V', 'I'): 'helperP_1P',             # private void p(int)
    ('p', 'V', 'II'): 'helperP_2P',            # private void p(int,int)
    ('p', 'Z', 'II'): 'helperP_2P_bool',       # private boolean p(int,int)
    ('p', 'V', 'III'): 'helperP_3P',           # private void p(int,int,int)

    # === q() 系列 ===
    ('q', 'V', ''): 'renderMenu',              # private void q()
    ('q', 'V', 'I'): 'helperQ_1P',             # private void q(int)
    ('q', 'V', 'II'): 'helperQ_2P',            # private void q(int,int)
    ('q', 'Z', 'II'): 'helperQ_2P_bool',       # private boolean q(int,int)
    ('q', 'V', 'III'): 'helperQ_3P',           # private void q(int,int,int)

    # === r() 系列 ===
    ('r', 'V', ''): 'handleMenuInput',         # private void r()
    ('r', 'V', 'I'): 'helperR_1P',             # private void r(int)
    ('r', 'V', 'III'): 'helperR_3P',           # private void r(int,int,int)

    # === s() 系列 ===
    ('s', 'V', ''): 'renderSavePanel',         # private void s()
    ('s', 'V', 'I'): 'helperS_1P',             # private void s(int)
    ('s', 'V', 'III'): 'helperS_3P',           # private void s(int,int,int)

    # === t() 系列 ===
    ('t', 'V', ''): 'handleSaveLoad',          # private void t()
    ('t', 'V', 'I'): 'helperT_1P',             # private void t(int)
    ('t', 'V', 'III'): 'helperT_3P',           # private void t(int,int,int)

    # === u() 系列 ===
    ('u', 'V', ''): 'handleFactionSelect',     # private void u()
    ('u', 'V', 'I'): 'helperU_1P',             # private void u(int)
    ('u', 'V', 'III'): 'helperU_3P',           # private void u(int,int,int)

    # === v() 系列 ===
    ('v', 'V', ''): 'renderFactionSelect',     # private void v()
    ('v', 'V', 'I'): 'helperV_1P',             # private void v(int)
    ('v', 'V', 'III'): 'helperV_3P',           # private void v(int,int,int)

    # === w() 系列 ===
    ('w', 'V', ''): 'renderSpecialMode',       # private void w()
    ('w', 'V', 'I'): 'helperW_1P',             # private void w(int)
    ('w', 'V', 'III'): 'helperW_3P',           # private void w(int,int,int)

    # === x() 系列 ===
    ('x', 'V', ''): 'helperX',                 # private void x()
    ('x', 'V', 'I'): 'helperX_1P',             # private void x(int)

    # === y() 系列 ===
    ('y', 'V', ''): 'renderMap',               # private void y()
    ('y', 'V', 'I'): 'helperY_1P',             # private void y(int)

    # === z() 系列 ===
    ('z', 'V', ''): 'updateEnemyMovement',     # private void z()
    ('z', 'V', 'I'): 'helperZ_1P',             # private void z(int)

    # === 大写带参方法 ===
    ('A', 'V', 'I'): 'helperA_int',            # private void A(int)
    ('B', 'V', 'I'): 'helperB_int',            # private void B(int)
    ('C', 'V', 'I'): 'helperC_int',            # private void C(int)
    ('D', 'V', 'I'): 'helperD_int',            # private void D(int)
    ('E', 'V', 'I'): 'helperE_int',            # private void E(int)
    ('F', 'V', 'I'): 'helperF_int',            # private void F(int)
    ('G', 'V', 'I'): 'helperG_int',            # private void G(int)
    ('H', 'V', 'I'): 'helperH_int',            # private void H(int)
    ('I', 'V', 'I'): 'helperI_int',            # private void I(int)
    ('e', 'V', 'I'): 'updateLoadingProgress',  # already mapped above

    # === final void 方法带参 ===
    ('b', 'V', 'III'): 'helperB_3P_void',      # private final void b(int,int,int)
    ('c', 'V', 'III'): 'helperC_3P_void',      # private final void c(int,int,int,int,boolean) - already above
    ('e', 'V', 'I'): 'updateLoadingProgress',  # private final void e(int)
    ('f', 'V', 'IIIII'): 'helperF_5P',         # private final void f(int,int,int,int,int)
    ('l', 'V', 'I'): 'updateTowerLogic',       # private final void l(int)
    ('n', 'V', 'I'): 'helperN_1P',             # private final void n(int)
}

# ============================================================
# 字段映射表 (单字母/双字母字段)
# 基于 10_rename_map.java 的字段映射
# ============================================================
FIELD_MAP = {
    # 单字母字段
    'a': 'gameFont',
    'b': 'menuHistoryStack',
    'c': 'cursorX',
    'd': 'cursorY',
    'e': 'levelProgress',
    'f': 'spriteFrameCounts',
    'g': 'flagG',
    'h': 'flagH',
    'i': 'flagI',
    'j': 'fontHeight',
    'k': 'charWidth',
    'l': 'gameState',
    'm': 'menuDepth',
    'n': 'lineHeight',
    'o': 'selectedTowerIdx',
    'p': 'progressBarWidth',
    'q': 'volume',
    'r': 'enemyCount',
    's': 'frameTimeStats',
    't': 'bgScrollOffset',
    'u': 'scrollX',
    'v': 'scrollY',
    'w': 'scrollY2',
    'x': 'posX',
    'y': 'posY',
    'z': 'posZ',
    # 大写单字母 (临时状态)
    'A': 'tmpA', 'B': 'tmpB', 'C': 'tmpC', 'D': 'tmpD',
    'E': 'tmpE', 'F': 'tmpF', 'G': 'tmpG', 'H': 'tmpH',
    'I': 'tmpI', 'J': 'tmpJ', 'K': 'tmpK', 'L': 'tmpL',
    'M': 'menuState', 'N': 'tmpN', 'O': 'tmpO', 'P': 'tmpP',
    'Q': 'tmpQ', 'R': 'tmpR', 'S': 'tmpS', 'T': 'tmpT',
    'U': 'stateMachineU', 'V': 'screenWidth', 'W': 'screenHeight',
    'X': 'currentGeneralIdx', 'Y': 'tmpY', 'Z': 'tmpZ',
    # 双字母字段
    'aA': 'stateA', 'aB': 'stateB', 'aC': 'factionIdx', 'aD': 'stateD',
    'aE': 'stateE', 'aF': 'stateF', 'aG': 'mapColsG', 'aH': 'stateH',
    'aI': 'stateI', 'aJ': 'stateJ', 'aK': 'stateK', 'aL': 'stateL',
    'aM': 'stateM', 'aN': 'generalIdxN', 'aO': 'generalIdxO', 'aP': 'activeTowerCount',
    'aQ': 'stateQ', 'aR': 'stateR', 'aS': 'stateS', 'aT': 'currentTurn',
    'aU': 'stateU', 'aV': 'stateV', 'aW': 'stateW', 'aX': 'targetTurn',
    'aY': 'stateY', 'aZ': 'stateZ',
    'aa': 'stateAA', 'ab': 'stateAB', 'ac': 'factionIdx', 'ae': 'saveSlot',
    'af': 'stateAF', 'ag': 'stateAG', 'ak': 'loadingProgress', 'al': 'loadingState',
    'am': 'loadingPercent', 'an': 'stateAN', 'ao': 'stateAO', 'ap': 'stateAP',
    'aq': 'currentMidiIdx', 'ar': 'stateAR', 'as': 'stateAS', 'at': 'keyRepeatGuard',
    'au': 'stateAU', 'av': 'stateAV', 'aw': 'stateAW', 'ax': 'stateAX',
    'ay': 'stateAY', 'az': 'stateAZ',
    'bA': 'stateBA', 'bB': 'stateBB', 'bC': 'stateBC', 'bD': 'stateBD',
    'bE': 'stateBE', 'bF': 'stateBF', 'bG': 'mapColsG2', 'bH': 'stateBH',
    'bI': 'screenCenterX', 'bJ': 'screenCenterY', 'bK': 'stateBK', 'bL': 'stateBL',
    'bM': 'stateBM', 'bN': 'stateBN', 'bO': 'stateBO', 'bP': 'stateBP',
    'bQ': 'stateBQ', 'bR': 'stateBR', 'bS': 'stateBS', 'bT': 'enemyCountT',
    'bU': 'stateBU', 'bV': 'threadState', 'bW': 'stateBW', 'bX': 'stateBX',
    'bY': 'stateBY', 'bZ': 'stateBZ',
    'ba': 'stateBa', 'bb': 'stateBb', 'bc': 'stateBc', 'bd': 'stateBd',
    'be': 'stateBe', 'bf': 'pathCount', 'bg': 'progressValue', 'bh': 'progressMax',
    'bi': 'stateBi', 'bj': 'nextTurnTarget', 'bk': 'stateBk', 'bl': 'stateBl',
    'bm': 'stateBm', 'bn': 'stateBn', 'bo': 'stateBo', 'bp': 'stateBp',
    'bq': 'stateBq', 'br': 'stateBr', 'bs': 'stateBs', 'bt': 'counterT',
    'bu': 'stateBu', 'bv': 'stateBv', 'bw': 'stateBw', 'bx': 'stateBx',
    'by': 'stateBy', 'bz': 'stateBz',
    'ca': 'httpResponseCode', 'cb': 'notifyState',
    # ad = tileSize (特殊:也是方法名,需谨慎)
}

# 这些单字母名同时也是方法名,需要特别处理
# 字段替换只在 this.xxx 和 this.xxx = 和声明中出现
SINGLE_LETTER_FIELDS = {
    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
}

# 这些双字母名需要字段替换
DOUBLE_LETTER_FIELDS = set(FIELD_MAP.keys()) - SINGLE_LETTER_FIELDS


def get_param_descriptor(params_str):
    """将Java参数列表转换为JVM描述符"""
    if not params_str.strip():
        return ''
    # 分割参数
    params = []
    # 简单分割:按逗号,但注意泛型
    depth = 0
    current = ''
    for ch in params_str:
        if ch == '<':
            depth += 1
        elif ch == '>':
            depth -= 1
        elif ch == ',' and depth == 0:
            params.append(current.strip())
            current = ''
            continue
        current += ch
    if current.strip():
        params.append(current.strip())

    descriptors = []
    for p in params:
        # 去掉参数名,只保留类型
        parts = p.split()
        if len(parts) < 2:
            # 可能只有类型没有名字
            type_str = parts[0] if parts else ''
        else:
            type_str = parts[0]
            # 处理 "int[] var1" 的情况
            for part in parts[1:]:
                if '[]' in part:
                    type_str += '[]'

        # 转换为JVM描述符
        desc = java_type_to_jvm(type_str)
        descriptors.append(desc)

    return ''.join(descriptors)


def java_type_to_jvm(type_str):
    """将Java类型字符串转换为JVM描述符"""
    type_str = type_str.strip()
    # 处理数组
    array_dim = 0
    while type_str.endswith('[]'):
        array_dim += 1
        type_str = type_str[:-2]

    base = {
        'int': 'I',
        'boolean': 'Z',
        'byte': 'B',
        'short': 'S',
        'long': 'J',
        'float': 'F',
        'double': 'D',
        'char': 'C',
        'void': 'V',
    }

    if type_str in base:
        desc = base[type_str]
    elif type_str == 'String' or type_str == 'java.lang.String':
        desc = 'Ljava/lang/String;'
    elif type_str == 'Image' or type_str == 'javax.microedition.lcdui.Image':
        desc = 'Ljavax/microedition/lcdui/Image;'
    elif type_str == 'DataInputStream' or type_str == 'java.io.DataInputStream':
        desc = 'Ljava/io/DataInputStream;'
    elif type_str == 'InputStream' or type_str == 'java.io.InputStream':
        desc = 'Ljava/io/InputStream;'
    elif type_str == 'Graphics' or type_str == 'javax.microedition.lcdui.Graphics':
        desc = 'Ljavax/microedition/lcdui/Graphics;'
    elif type_str == 'Object' or type_str == 'java.lang.Object':
        desc = 'Ljava/lang/Object;'
    elif '.' in type_str:
        desc = 'L' + type_str.replace('.', '/') + ';'
    else:
        # 未知类型,用通配
        desc = 'L' + type_str.replace('.', '/') + ';'

    return '[' * array_dim + desc


def get_return_descriptor(return_type):
    """将Java返回类型转换为JVM描述符"""
    return java_type_to_jvm(return_type)


def parse_method_definition(line):
    """
    解析方法定义行,返回 (access_flags, is_static, is_final, return_type, method_name, params_str)
    如果不是方法定义,返回 None
    """
    # 跳过注释行
    stripped = line.strip()
    if stripped.startswith('//') or stripped.startswith('*') or stripped.startswith('/*'):
        return None
    if not stripped:
        return None

    # 匹配方法定义
    # 格式: [public|private|protected] [static] [final] [synchronized] return_type method_name(params) {
    pattern = r'^((?:public|private|protected)\s+)?((?:static\s+)?(?:final\s+)?(?:synchronized\s+)?)?(\S+(?:\s*\[\s*\])*)\s+(\w+)\s*\(([^)]*)\)\s*(?:\{|$|;)'
    match = re.match(pattern, stripped)
    if not match:
        return None

    access = match.group(1) or ''
    modifiers = match.group(2) or ''
    return_type = match.group(3) or ''
    method_name = match.group(4)
    params = match.group(5) or ''

    is_static = 'static' in modifiers
    is_final = 'final' in modifiers

    # 过滤掉构造函数和已知方法
    if method_name in ('paint', 'run', 'keyPressed', 'keyReleased', 'showNotify', 'hideNotify'):
        return None
    # 过滤掉已经重命名的方法(包含字母+大写)
    if re.match(r'^[a-z][a-zA-Z]+$', method_name) and len(method_name) > 2:
        return None
    # 过滤掉全大写方法名(已替换的 A-Z)
    if re.match(r'^[A-Z][a-z]+', method_name) and len(method_name) > 2:
        return None

    return (access.strip(), is_static, is_final, return_type.strip(), method_name, params.strip())


def find_method_semantic_name(method_name, return_type, params_str, is_static=False):
    """根据方法签名查找语义名"""
    ret_desc = get_return_descriptor(return_type)
    param_desc = get_param_descriptor(params_str)

    key = (method_name, ret_desc, param_desc)
    if key in METHOD_MAP:
        name = METHOD_MAP[key]
        # 去掉 _static 后缀(因为源码中已有 static 修饰符)
        if name.endswith('_static'):
            name = name[:-7]
        return name

    return None


def replace_method_definitions(content):
    """替换方法定义中的方法名"""
    lines = content.split('\n')
    new_lines = []
    replacements = 0

    for line in lines:
        stripped = line.strip()
        # 跳过注释行
        if stripped.startswith('//') or stripped.startswith('*') or stripped.startswith('/*'):
            new_lines.append(line)
            continue

        # 尝试匹配方法定义
        # 格式: [modifiers] return_type method_name(params) {
        pattern = r'^(\s*(?:public|private|protected)\s+(?:(?:static|final|synchronized)\s+)*)(\S+(?:\s*\[\s*\])*)\s+(\w+)\s*\(([^)]*)\)\s*(\{|$|;)'
        match = re.match(pattern, line)
        if not match:
            new_lines.append(line)
            continue

        modifiers_str = match.group(1)
        return_type = match.group(2)
        method_name = match.group(3)
        params_str = match.group(4)
        ending = match.group(5)

        # 跳过已重命名的方法
        if re.match(r'^[a-z][a-zA-Z]{2,}$', method_name):
            new_lines.append(line)
            continue
        if method_name in ('paint', 'run', 'keyPressed', 'keyReleased', 'showNotify', 'hideNotify'):
            new_lines.append(line)
            continue

        is_static = 'static' in modifiers_str

        semantic_name = find_method_semantic_name(method_name, return_type, params_str, is_static)
        if semantic_name and semantic_name != method_name:
            # 执行替换
            new_line = line[:match.start(3)] + semantic_name + line[match.end(3):]
            new_lines.append(new_line)
            replacements += 1
        else:
            new_lines.append(line)

    return '\n'.join(new_lines), replacements


def replace_method_calls(content):
    """替换方法调用中的方法名"""
    replacements = 0

    # 策略:按方法名分组,对每个方法名的调用进行上下文分析
    # 1. 先找出所有未被替换的方法调用
    # 2. 对每个调用,分析上下文确定返回类型
    # 3. 查找语义名并替换

    lines = content.split('\n')
    new_lines = []

    for line in lines:
        stripped = line.strip()
        # 跳过注释行
        if stripped.startswith('//') or stripped.startswith('*') or stripped.startswith('/*'):
            new_lines.append(line)
            continue

        # 跳过方法定义行(已在 replace_method_definitions 中处理)
        if re.match(r'^\s*(?:public|private|protected)\s+', line):
            new_lines.append(line)
            continue

        new_line = line

        # 替换 this.xxx( 调用
        # 匹配 this.methodName( 模式,其中 methodName 是单字母或双字母
        # 不替换已经重命名的(this.xxx 其中 xxx 是多字母)
        pattern = r'this\.([a-zA-Z]{1,2})\s*\('
        matches = list(re.finditer(pattern, new_line))
        # 逆序替换以保持索引
        for match in reversed(matches):
            method_name = match.group(1)
            # 跳过已重命名的(如果方法名在 FIELD_MAP 中说明是字段,不是方法)
            if method_name not in [k[0] for k in METHOD_MAP.keys()]:
                continue

            # 获取调用上下文
            start = match.start()
            end = match.end()  # 包含 this. 和 ( 

            # 需要找到完整的参数列表
            # 从 ( 开始,找到匹配的 )
            paren_start = match.end() - 1  # 位置 of (
            depth = 1
            pos = paren_start + 1
            while pos < len(new_line) and depth > 0:
                if new_line[pos] == '(':
                    depth += 1
                elif new_line[pos] == ')':
                    depth -= 1
                pos += 1
            if depth != 0:
                continue
            paren_end = pos  # 位置 after )

            params_str = new_line[paren_start + 1:paren_end - 1]

            # 分析上下文确定返回类型
            # 看调用前后的字符
            before = new_line[:match.start()]
            after = new_line[paren_end:]

            return_type = infer_return_type(before, after, params_str)

            if return_type:
                param_desc = get_param_descriptor(params_str)
                ret_desc = get_return_descriptor(return_type)
                key = (method_name, ret_desc, param_desc)
                if key in METHOD_MAP:
                    semantic_name = METHOD_MAP[key]
                    if semantic_name.endswith('_static'):
                        semantic_name = semantic_name[:-7]
                    # 执行替换:只替换方法名部分
                    replacement = f'this.{semantic_name}('
                    new_line = new_line[:match.start()] + replacement + new_line[paren_start + 1:]
                    replacements += 1

        new_lines.append(new_line)

    return '\n'.join(new_lines), replacements


def infer_return_type(before, after, params_str):
    """根据调用上下文推断返回类型"""
    before = before.rstrip()
    after = after.lstrip()

    # 情况1: 赋值 "int x = this.xxx()" 或 "= this.xxx()"
    # 检查 = 前面的类型
    assign_match = re.search(r'(\w+(?:\s*\[\s*\])*)\s+\w+\s*=\s*$', before)
    if assign_match:
        var_type = assign_match.group(1)
        return var_type

    # 检查 "return this.xxx()"
    if re.search(r'return\s+$', before):
        # 需要从方法定义中获取返回类型,但这里我们暂时返回 'I' (int)
        # 因为大多数 return this.xxx() 的情况是 int
        # 更精确的判断需要分析包含此调用的方法定义
        return 'int'  # 默认

    # 情况2: 条件 "if (this.xxx())" 或 "while (this.xxx())"
    if re.search(r'(?:if|while|do)\s*\(\s*!?\s*$', before):
        return 'boolean'

    # 情况3: 逻辑表达式 "&& this.xxx()" 或 "|| this.xxx()"
    if re.search(r'&&\s*$', before) or re.search(r'\|\|\s*$', before):
        return 'boolean'

    # 情况4: 比较表达式 "this.xxx() =="
    if re.match(r'==|!=|<=|>=|<|>', after):
        return 'int'

    # 情况5: 位操作 "this.xxx() &" 或 "|"
    if re.match(r'[&|]', after) or re.search(r'[&|]\s*$', before):
        return 'int'

    # 情况6: 算术操作 "this.xxx() +"
    if re.match(r'[+\-*/%]', after) or re.search(r'[+\-*/%]\s*$', before):
        return 'int'

    # 情况7: 数组索引 "this.xxx()]"
    if re.match(r'\]', after):
        return 'int'

    # 情况8: 独立语句 "this.xxx();" → void
    if after.startswith(';') or after.startswith('}'):
        return 'void'

    # 情况9: 字符串连接 "this.xxx() +"
    if re.match(r'\+\s*"', after):
        return 'int'  # 可能是 int 被转为字符串

    # 默认: 如果有参数,可能是 void;如果无参,可能是 void
    return 'void'


def replace_single_letter_fields(content):
    """替换单字母/双字母字段名"""
    replacements = 0

    # 策略: 只替换 this.xxx 和 this.xxx = 模式中的字段名
    # 不替换局部变量(局部变量没有 this. 前缀)

    lines = content.split('\n')
    new_lines = []

    for line in lines:
        stripped = line.strip()
        # 跳过注释行
        if stripped.startswith('//') or stripped.startswith('*') or stripped.startswith('/*'):
            new_lines.append(line)
            continue

        new_line = line

        # 替换 this.xxx 模式中的字段名
        # this.X 其中 X 是单字母或双字母
        # 注意: 不替换 this.xxx( 方法调用
        pattern = r'this\.([a-zA-Z]{1,2})(?!\s*\()'
        matches = list(re.finditer(pattern, new_line))
        for match in reversed(matches):
            field_name = match.group(1)
            if field_name in FIELD_MAP:
                semantic_name = FIELD_MAP[field_name]
                # 检查后面不是 ( (方法调用)
                after_pos = match.end()
                if after_pos < len(new_line) and new_line[after_pos] == '(':
                    continue  # 是方法调用,跳过
                # 检查后面不是 [ (数组访问) 或其他字母
                if after_pos < len(new_line) and (new_line[after_pos].isalnum() or new_line[after_pos] == '_'):
                    continue
                # 执行替换
                new_line = new_line[:match.start(1)] + semantic_name + new_line[match.end(1):]
                replacements += 1

        new_lines.append(new_line)

    return '\n'.join(new_lines), replacements


def replace_field_declarations(content):
    """替换字段声明中的字段名"""
    replacements = 0
    lines = content.split('\n')
    new_lines = []

    for line in lines:
        stripped = line.strip()
        # 跳过注释行
        if stripped.startswith('//') or stripped.startswith('*') or stripped.startswith('/*'):
            new_lines.append(line)
            continue

        # 匹配字段声明: [modifiers] type fieldName [= value];
        # 只处理 private/public/protected 开头的声明
        # 关键: (?!\s*\() 确保不是方法定义, (?:=|;) 要求以 = 或 ; 结尾
        pattern = r'(\s*(?:private|public|protected)\s+(?:(?:static|final|volatile|transient)\s+)*)(\S+(?:\s*\[\s*\])*)\s+([a-zA-Z]{1,2})(?!\s*\()\s*(?:=|;)'
        match = re.match(pattern, line)
        if not match:
            new_lines.append(line)
            continue

        modifiers_str = match.group(1)
        field_type = match.group(2)
        field_name = match.group(3)

        if field_name in FIELD_MAP:
            semantic_name = FIELD_MAP[field_name]
            new_line = line[:match.start(3)] + semantic_name + line[match.end(3):]
            new_lines.append(new_line)
            replacements += 1
        else:
            new_lines.append(line)
            # 调试: 打印未匹配的字段名
            # print(f"  DEBUG field decl not in map: {field_name} in: {stripped[:60]}")

    return '\n'.join(new_lines), replacements


def main():
    print("=" * 60)
    print("v13 剩余重命名脚本")
    print("基于 javap 字节码精确签名")
    print("=" * 60)

    # 创建备份
    import shutil
    if not os.path.exists(BACKUP_DIR):
        os.makedirs(BACKUP_DIR)
        print(f"\n创建备份目录: {BACKUP_DIR}")

    # 获取目标文件
    target_files = []
    for f in os.listdir(RENAMED_DIR):
        if re.match(r'^0[0-9]_.*\.java$', f):
            target_files.append(f)
    target_files.sort()

    print(f"目标文件: {len(target_files)} 个")

    total_method_def_replacements = 0
    total_method_call_replacements = 0
    total_field_decl_replacements = 0
    total_field_ref_replacements = 0

    for filename in target_files:
        filepath = os.path.join(RENAMED_DIR, filename)
        print(f"\n处理: {filename}")

        # 备份
        backup_path = os.path.join(BACKUP_DIR, filename)
        shutil.copy2(filepath, backup_path)

        # 读取文件
        with open(filepath, 'r', encoding='utf-8') as f:
            content = f.read()

        original_content = content

        # 步骤1: 替换字段声明
        content, field_decl_repl = replace_field_declarations(content)
        print(f"  字段声明替换: {field_decl_repl}")
        total_field_decl_replacements += field_decl_repl

        # 步骤2: 替换字段引用 (this.xxx)
        content, field_ref_repl = replace_single_letter_fields(content)
        print(f"  字段引用替换: {field_ref_repl}")
        total_field_ref_replacements += field_ref_repl

        # 步骤3: 替换方法定义
        content, method_def_repl = replace_method_definitions(content)
        print(f"  方法定义替换: {method_def_repl}")
        total_method_def_replacements += method_def_repl

        # 步骤4: 替换方法调用
        content, method_call_repl = replace_method_calls(content)
        print(f"  方法调用替换: {method_call_repl}")
        total_method_call_replacements += method_call_repl

        # 写回文件
        if content != original_content:
            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(content)
            print(f"  [OK] 已更新")
        else:
            print(f"  - 无变化")

    print("\n" + "=" * 60)
    print("总计:")
    print(f"  字段声明替换: {total_field_decl_replacements}")
    print(f"  字段引用替换: {total_field_ref_replacements}")
    print(f"  方法定义替换: {total_method_def_replacements}")
    print(f"  方法调用替换: {total_method_call_replacements}")
    print(f"  总替换次数: {total_field_decl_replacements + total_field_ref_replacements + total_method_def_replacements + total_method_call_replacements}")
    print("=" * 60)


if __name__ == '__main__':
    main()
