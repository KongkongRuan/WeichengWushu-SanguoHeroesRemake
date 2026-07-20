# ============================================================================
# 批量重命名脚本 v12
# 作用: 对 deobfuscated_modules_renamed/ 中的所有 .java 文件执行字段名替换
# 策略: 只替换带数字后缀的字段名 (如 a1001, b1015, E1163 等), 这些是安全的
#       单字母字段名 (a, b, c...) 暂不替换 (风险大, 会误匹配局部变量)
# ============================================================================

$targetDir = "d:\Development\ts\WeichengWushu-SanguoHeroesRemake\a_java_analysis\deobfuscated_modules_renamed"
$files = Get-ChildItem -Path $targetDir -File | Where-Object { $_.Name -match '^0[0-9]_' -and $_.Extension -eq '.java' }

# 字段名映射表 (混淆名 -> 语义名)
# 只包含带数字后缀的字段名, 这些可以安全替换
$fieldMap = [ordered]@{
    # 渲染相关
    'a1001'  = 'ROTATION_PARAMS'
    'a1002'  = 'graphicsCtx'
    'a1004'  = 'backBufferImage'
    'a1005'  = 'directGraphics'
    'b1003'  = 'secondGraphics'
    'b1006'  = 'secondDirectGraphics'
    'b1032'  = 'logoImage'
    'a1013'  = 'spriteImages'
    'a1040'  = 'backgroundImages'
    'a1038'  = 'mapLayerCount'
    'a1039'  = 'mapLayerData'
    # 游戏状态
    'a1007'  = 'frameCounter'
    'b1008'  = 'targetFrame'
    'a1019'  = 'totalFrameCount'
    'a1009'  = 'scrollTextCache'
    'a1012'  = 'random'
    'a1016'  = 'isRunning'
    'b1018'  = 'isPaused'
    'c1020'  = 'soundEnabled'
    'd1021'  = 'musicEnabled'
    'e1022'  = 'vibrationEnabled'
    'f1023'  = 'autoSave'
    'j1024'  = 'flagJ1024'
    'k1029'  = 'flagK1029'
    'l1031'  = 'isPausedInGame'
    'm1033'  = 'sceneMode'
    'n1036'  = 'flagN1036'
    's1088'  = 'isLandscape'
    't1089'  = 'flagT1089'
    'u1096'  = 'isTouch'
    'v1097'  = 'flagV1097'
    'w1111'  = 'flagW1111'
    'x1126'  = 'flagX1126'
    'y1155'  = 'flagY1155'
    'z1169'  = 'flagZ1169'
    # 菜单/分数
    'c1010'  = 'scoreHistory'
    # 核心数据数组
    'd1011'  = 'colorConstants'
    'a1014'  = 'resourcePaths'
    'b1015'  = 'gameTexts'
    'c1051'  = 'towerBuildPaths'
    'a1052'  = 'techTreeBranches'
    'd1053'  = 'levelSequence'
    'e1054'  = 'levelConfig'
    'f1055'  = 'towerLevelLimits'
    'g1057'  = 'upgradeCosts'
    'o1098'  = 'levelSpawnPoints'
    'p1099'  = 'multiPathFlags'
    'q1100'  = 'killRewards'
    'r1101'  = 'enemyHpCoeffs'
    's1102'  = 'altHpCoeffs'
    't1103'  = 'towerDamageRange'
    'u1104'  = 'towerAtkSpeed'
    'v1109'  = 'towerInitLevels'
    'w1110'  = 'encryptKey'
    'w1123'  = 'enemyPathAnim'
    'x1124'  = 'xOffsetTable'
    'y1125'  = 'yOffsetTable'
    'x1128'  = 'directionVectors'
    'y1130'  = 'generalSortOrder'
    'j1049'  = 'tangentTable'
    'k1071'  = 'intArrayK1071'
    'l1116'  = 'intArrayL1116'
    'q1158'  = 'intArrayQ1158'
    'r1166'  = 'intArrayR1166'
    's1167'  = 'intArrayS1167'
    't1168'  = 'intArrayT1168'
    'A1151'  = 'byteArrayA1151'
    'b1069'  = 'shortArray2DB1069'
    'c1070'  = 'shortArray2DC1070'
    # 瓦片数据
    'a1027'  = 'tileDataA0'
    'a1028'  = 'tileDataA2D'
    'b1034'  = 'tileDataB0'
    'b1030'  = 'tileDataB2D'
    'c1037'  = 'tileDataC0'
    'd1050'  = 'tileDataD0'
    'h1060'  = 'tileDataH0'
    'i1062'  = 'tileDataI0'
    'j1064'  = 'tileDataJ0'
    'k1068'  = 'tileDataK0'
    'l1072'  = 'tileDataL0'
    'm1075'  = 'tileDataM0'
    'n1076'  = 'tileDataN0'
    'z1148'  = 'tileDataZ0'
    'B1160'  = 'tileDataB'
    'C1161'  = 'tileDataC'
    'D1162'  = 'tileDataD'
    'E1163'  = 'tileProperties'
    'F1164'  = 'tileDataF'
    'G1165'  = 'tileDataG'
    'H1188'  = 'httpPostData'
    'I1189'  = 'httpResponseData'
    # 关卡数据
    'A1132'  = 'levelDataA'
    'B1133'  = 'levelDataB'
    'C1134'  = 'levelDataC'
    'D1135'  = 'levelDataD'
    'E1136'  = 'levelDataE'
    'F1137'  = 'levelDataF'
    'G1138'  = 'levelDataG'
    'H1140'  = 'levelDataH'
    'I1142'  = 'levelDataI'
    'J1144'  = 'levelDataJ'
    'K1145'  = 'levelDataK'
    'L1146'  = 'levelDataL'
    'M1147'  = 'levelDataM'
    'N1149'  = 'levelDataN'
    'O1156'  = 'levelDataO'
    'P1157'  = 'levelDataP'
    'Q1159'  = 'levelDataQ'
    'z1131'  = 'levelDataZ'
    'e1058'  = 'byteArray2DE1058'
    'f1063'  = 'byteArray2DF1063'
    'g1065'  = 'byteArray2DG1065'
    'h1074'  = 'generalSelectData'
    'i1079'  = 'byteArray2DI1079'
    'j1080'  = 'byteArray2DJ1080'
    'k1081'  = 'byteArray2DK1081'
    'l1083'  = 'byteArray2DL1083'
    'n1094'  = 'byteArray2DN1094'
    'o1095'  = 'byteArray2DO1095'
    'p1108'  = 'byteArray2DP1108'
    'q1114'  = 'byteArray2DQ1114'
    'r1115'  = 'byteArray2DR1115'
    's1117'  = 'byteArray2DS1117'
    't1118'  = 'byteArray2DT1118'
    'u1119'  = 'byteArray2DU1119'
    'v1120'  = 'byteArray2DV1120'
    # 地图数据
    'a1067'  = 'mapDataA'
    'b1085'  = 'mapDataB'
    'c1090'  = 'mapDataC'
    'd1091'  = 'mapDataD'
    'e1093'  = 'mapDataE'
    'f1112'  = 'mapDataF'
    'g1113'  = 'mapDataG'
    'h1121'  = 'mapDataH'
    'i1122'  = 'spriteOffsets'
    'j1139'  = 'mapDataJ'
    'k1141'  = 'mapDataK'
    'l1143'  = 'mapDataL'
    'm1150'  = 'mapDataM'
    'a1092'  = 'shortArray4D'
    # 布尔状态标志数组
    'c1061'  = 'unlockFlags'
    'd1073'  = 'levelFlags'
    'e1105'  = 'levelCompleted'
    'f1106'  = 'levelUnlocked'
    'a1056'  = 'techUnlocked'
    'b1059'  = 'generalAwakened'
    'a1127'  = 'buildableFlags'
    'A1170'  = 'flagA1170'
    'B1171'  = 'threadRunning'
    'C1175'  = 'needRestore'
    'D1176'  = 'useProxy'
    'E1179'  = 'initialized'
    'F1180'  = 'hasFactionName'
    'G1182'  = 'hasLevelName'
    # 武将/科技/文本
    'a1087'  = 'techLevels'
    'd1173'  = 'generalNames'
    'b1177'  = 'menuTitle'
    'c1178'  = 'currentGeneralName'
    'd1181'  = 'factionName'
    'e1183'  = 'levelName'
    'f1186'  = 'statusMessage'
    'g1187'  = 'redirectUrl'
    'h1192'  = 'errorMessage'
    # 音频
    'a1042'  = 'midiInputStreams'
    'a1043'  = 'midiPlayers'
    'a1017'  = 'volumeControl'
    'h1041'  = 'midiPlayerState'
    'g1035'  = 'intArrayG1035'
    'i1044'  = 'intArrayI1044'
    # 网络/存档
    'a1193'  = 'httpConnection'
    'a1191'  = 'saveBuffer'
    'a1172'  = 'syncLock'
    'a1184'  = 'saveDate'
    'a1185'  = 'calendar'
    'b1174'  = 'notifyStatus'
    'c1190'  = 'httpMethod'
    'm1129'  = 'intArrayM1129'
    'n1152'  = 'renderData'
    'o1153'  = 'activeTowerIndices'
    'p1154'  = 'intArrayP1154'
    # 敌人/塔槽位
    'c1107'  = 'enemySlots'
    'b1066'  = 'towerSlots'
    'm1084'  = 'directionMatrix'
    'o1077'  = 'levelAdvanceFlag'
    'p1078'  = 'victoryFlag'
    'q1082'  = 'flagQ1082'
    'r1086'  = 'renderFlag'
    # 输入
    'g1046'  = 'currentKeyCode'
    'h1047'  = 'keyState'
    'i1048'  = 'keyRepeatCount'
    'e1025'  = 'publicIntE1025'
    'f1026'  = 'publicIntF1026'
    # 静态字段
    'c1045'  = 'MIDI_FILES'
}

# 按长度降序排序, 避免短名先替换导致长名被破坏
$sortedKeys = $fieldMap.Keys | Sort-Object -Property Length -Descending

$totalReplacements = 0
foreach ($file in $files) {
    $content = Get-Content -Path $file.FullName -Raw -Encoding UTF8
    $fileReplacements = 0

    foreach ($oldName in $sortedKeys) {
        $newName = $fieldMap[$oldName]
        # 使用单词边界确保精确匹配
        $pattern = "\b$([regex]::Escape($oldName))\b"
        $matches = [regex]::Matches($content, $pattern)
        if ($matches.Count -gt 0) {
            $content = [regex]::Replace($content, $pattern, $newName)
            $fileReplacements += $matches.Count
        }
    }

    if ($fileReplacements -gt 0) {
        Set-Content -Path $file.FullName -Value $content -Encoding UTF8 -NoNewline
        Write-Output "$($file.Name): $fileReplacements replacements"
        $totalReplacements += $fileReplacements
    }
}

Write-Output ""
Write-Output "=== Total replacements: $totalReplacements ==="
