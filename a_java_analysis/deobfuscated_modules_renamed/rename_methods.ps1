# ============================================================================
# 方法名批量重命名脚本 v12
# 作用: 对 deobfuscated_modules_renamed/ 中的所有 .java 文件执行方法名替换
#
# 策略:
#   1. 无参方法 (A-Z, aa-ay): 用 \bX\(\) 模式精确匹配, 安全
#   2. 小写单字母无参方法 a() b() c() d() e() f() g() h() i() j() k() l() m() n() o() p() q() r() s() t() u() v() w() x() y() z()
#      风险: 可能匹配到 this.a() 这种调用, 但这正是我们想替换的
#      注意: 不匹配 a(int) 这种带参数的, 因为后面不是直接 ()
#   3. 带参数方法: 按签名精确匹配, 较复杂
# ============================================================================

$targetDir = "d:\Development\ts\WeichengWushu-SanguoHeroesRemake\a_java_analysis\deobfuscated_modules_renamed"
$files = Get-ChildItem -Path $targetDir -File | Where-Object { $_.Name -match '^0[0-9]_' -and $_.Extension -eq '.java' }

# ============================================================================
# 第一部分: 无参方法替换 (A-Z 大写 + aa-ay 双字母)
# 这些方法没有重载, 可以安全替换
# 模式: \b方法名\(\)  (确保后面是空括号)
# ============================================================================
$noArgMethodMap = [ordered]@{
    # A-Z 大写无参方法 (模块04)
    'A'  = 'dispatchRender'
    'B'  = 'runLoadProcess'
    'C'  = 'saveRMS_sanGuoTd'
    'D'  = 'loadRMS_sanGuoTdData'
    'E'  = 'loadRMS_freeGame'
    'F'  = 'loopProcess15'
    'G'  = 'updateMainFrame'
    'H'  = 'drawScrollAndBg'
    'I'  = 'drawBackground'
    'J'  = 'calcScrollPosition'
    'K'  = 'handleLevelSelect'
    'L'  = 'handleLevelInput'
    'M'  = 'handleTechTree'
    'N'  = 'iterateTileProperties'
    'O'  = 'updateGameState'
    'P'  = 'selectGeneral'
    'Q'  = 'selectGeneralAlt'
    'R'  = 'advanceLevel'
    'S'  = 'renderOverlay'
    'T'  = 'checkVictory'
    'U'  = 'resetGame'
    'V'  = 'iteratePaths'
    'W'  = 'drawMainMap'
    'X'  = 'updateGameFrame'
    'Y'  = 'renderGameWorld'
    'Z'  = 'renderGeneralSelect'
    # aa-ay 双字母无参方法 (模块05)
    'aa' = 'helperAA'
    'ab' = 'helperAB'
    'ac' = 'helperAC'
    'ad' = 'helperAD'
    'ae' = 'helperAE'
    'af' = 'helperAF'
    'ag' = 'renderAG_block298'
    'ah' = 'helperAH'
    'ai' = 'helperAI'
    'aj' = 'helperAJ'
    'ak' = 'renderAK_block297'
    'al' = 'renderAL_block235'
    'am' = 'helperAM'
    'an' = 'helperAN'
    'ao' = 'dispatchKeyState'
    'ap' = 'renderDifficulty'
    'aq' = 'handleInputAQ'
    'ar' = 'renderEndingAnim'
    'as' = 'stateMachineNotify'
    'at' = 'setNotify1'
    'au' = 'initCalendar'
    'av' = 'startGameThread'
    'aw' = 'loadRMS_sfSmsInfo'
    'ax' = 'saveRMS_sfSmsInfo'
    'ay' = 'processSaveBuffer'
}

# 小写单字母无参方法 (模块06)
# 这些方法有无参版本和带参版本, 只替换 \bX\(\) 模式
$lowerNoArgMethodMap = [ordered]@{
    'e' = 'clearScreen'
    'f' = 'drawProgressBar'
    'g' = 'handleVolume'
    'h' = 'renderEndingText'
    'i' = 'handleVolumeInput'
    'j' = 'renderJ'
    'k' = 'initRandom'
    'l' = 'drawMap'
    'm' = 'handleMainMenu'
    'n' = 'updateScrollPos'
    'o' = 'stateMachineU'
    'p' = 'clearBackground'
    'q' = 'renderMenu'
    'r' = 'handleMenuInput'
    's' = 'renderSavePanel'
    't' = 'handleSaveLoad'
    'u' = 'handleFactionSelect'
    'v' = 'renderFactionSelect'
    'w' = 'renderSpecialMode'
    'x' = 'helperX'
    'y' = 'renderMap'
    'z' = 'updateEnemyMovement'
}

# 注意: a() b() c() d() 这几个方法有多个返回类型重载, 不能简单替换
# a() 有 int 版本和 void 版本和 boolean 版本
# b() 有 int 版本和 void 版本和 boolean 版本
# c() 有 int 版本和 void 版本和 boolean 版本
# d() 有 int 版本和 void 版本和 boolean 版本
# 这些需要手动处理或保留

# ============================================================================
# 执行替换
# ============================================================================

$totalReplacements = 0

foreach ($file in $files) {
    $content = Get-Content -Path $file.FullName -Raw -Encoding UTF8
    $fileReplacements = 0

    # 第一批: A-Z 大写无参方法 (按长度降序)
    $sortedKeys = $noArgMethodMap.Keys | Sort-Object -Property Length -Descending
    foreach ($oldName in $sortedKeys) {
        $newName = $noArgMethodMap[$oldName]
        # 精确匹配 \b名字\(\) - 确保是空括号调用
        $pattern = "\b$([regex]::Escape($oldName))\(\)"
        $matches = [regex]::Matches($content, $pattern)
        if ($matches.Count -gt 0) {
            $content = [regex]::Replace($content, $pattern, "$newName()")
            $fileReplacements += $matches.Count
        }
    }

    # 第二批: 小写单字母无参方法
    # 注意: 必须在带数字字段名替换之后执行(已在前一脚本完成)
    # 这些方法只匹配 \bX\(\) 模式, 不匹配 X( 带参数的
    $sortedKeys2 = $lowerNoArgMethodMap.Keys | Sort-Object -Property Length -Descending
    foreach ($oldName in $sortedKeys2) {
        $newName = $lowerNoArgMethodMap[$oldName]
        # 精确匹配 \b名字\(\) - 注意小写字母需要更小心
        # 使用 (?<![a-zA-Z0-9_]) 确保前面不是标识符字符
        $pattern = "(?<![a-zA-Z0-9_])$([regex]::Escape($oldName))\(\)"
        $matches = [regex]::Matches($content, $pattern)
        if ($matches.Count -gt 0) {
            $content = [regex]::Replace($content, $pattern, "$newName()")
            $fileReplacements += $matches.Count
        }
    }

    if ($fileReplacements -gt 0) {
        Set-Content -Path $file.FullName -Value $content -Encoding UTF8 -NoNewline
        Write-Output "$($file.Name): $fileReplacements method replacements"
        $totalReplacements += $fileReplacements
    }
}

Write-Output ""
Write-Output "=== Total method replacements: $totalReplacements ==="
