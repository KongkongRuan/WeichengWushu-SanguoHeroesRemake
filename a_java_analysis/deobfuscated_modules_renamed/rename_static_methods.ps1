# ============================================================================
# static 方法批量重命名脚本 v12
# 作用: 替换参数签名唯一的 static 方法
#
# 策略:
#   1. 代码中所有实例方法调用都带 this. 前缀
#   2. static 方法调用不带 this. 前缀
#   3. 因此可以用 (?<!this\.) 负向后顾来区分
#   4. 只替换参数签名完全唯一的 static 方法
# ============================================================================

$targetDir = "d:\Development\ts\WeichengWushu-SanguoHeroesRemake\a_java_analysis\deobfuscated_modules_renamed"
$files = Get-ChildItem -Path $targetDir -File | Where-Object { $_.Name -match '^0[0-9]_' -and $_.Extension -eq '.java' }

# static 方法映射表 (混淆名 -> 语义名)
# 这些方法的参数签名在 static 上下文中是唯一的
$staticMethodMap = [ordered]@{
    # 注意: 这些方法名在调用处不带 this. 前缀
    # 用 (?<!this\.)(?<!\w) 来确保是 static 调用
    # d(int,int,int) [static] -> calcBaseHp (3个int参数, 无同名实例方法)
    'd' = 'calcBaseHp'   # 但 d 有多个版本, 需要按参数数量区分
    'e' = 'hexCharToInt'  # e(int) [static] 
    'f' = 'isNotCommonTower'  # f(int) [static]
    'g' = 'isType6'  # g(int) [static]
    'c' = 'calcDirection'  # c(int) [static]
}

# 但这些方法有同名实例方法, 不能简单替换方法名
# 需要按参数数量和 this. 前缀来区分

# 更安全的策略: 只替换方法定义, 和明确不带 this 的调用
# 对于 d(int,int,int) -> calcBaseHp: 匹配 d( 3个参数 )
# 对于 e(int) -> hexCharToInt: 匹配不带 this. 的 e(

$totalReplacements = 0

foreach ($file in $files) {
    $content = Get-Content -Path $file.FullName -Raw -Encoding UTF8
    $fileReplacements = 0

    # 1. 替换方法定义: private static ... d(int var0, int var1, int var2)
    #    匹配: static ... d( ... 3个int参数)
    $pattern = '(static\s+(?:final\s+)?int\s+)d\((int\s+\w+,\s*int\s+\w+,\s*int\s+\w+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, '$1calcBaseHp(${2})')
        $fileReplacements += $matches.Count
    }

    # 2. 替换方法定义: private static final int e(int var0)
    $pattern = '(static\s+(?:final\s+)?int\s+)e\((int\s+\w+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, '$1hexCharToInt(${2})')
        $fileReplacements += $matches.Count
    }

    # 3. 替换方法定义: private static boolean f(int var0)
    $pattern = '(static\s+boolean\s+)f\((int\s+\w+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, '$1isNotCommonTower(${2})')
        $fileReplacements += $matches.Count
    }

    # 4. 替换方法定义: private static boolean g(int var0)
    $pattern = '(static\s+boolean\s+)g\((int\s+\w+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, '$1isType6(${2})')
        $fileReplacements += $matches.Count
    }

    # 5. 替换方法定义: private static int c(int var0)
    $pattern = '(static\s+int\s+)c\((int\s+\w+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, '$1calcDirection(${2})')
        $fileReplacements += $matches.Count
    }

    # 6. 替换方法定义: private static int b(int var0, int var1, int var2, int var3)
    $pattern = '(static\s+int\s+)b\((int\s+\w+,\s*int\s+\w+,\s*int\s+\w+,\s*int\s+\w+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, '$1distanceSq(${2})')
        $fileReplacements += $matches.Count
    }

    # 7. 替换方法定义: private static boolean a(int var0)
    $pattern = '(static\s+boolean\s+)a\((int\s+\w+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, '$1isOdd(${2})')
        $fileReplacements += $matches.Count
    }

    # 8. 替换方法定义: private static String a(DataInputStream var0)
    $pattern = '(static\s+String\s+)a\((DataInputStream\s+\w+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, '$1readCustomString(${2})')
        $fileReplacements += $matches.Count
    }

    # 9. 替换方法定义: private static String a(String var0)
    $pattern = '(static\s+String\s+)a\((String\s+\w+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, '$1extractHostName(${2})')
        $fileReplacements += $matches.Count
    }

    # 10. 替换方法定义: private static short a(InputStream var0)
    $pattern = '(static\s+short\s+)a\((InputStream\s+\w+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, '$1readShortLE(${2})')
        $fileReplacements += $matches.Count
    }

    # 11. 替换方法定义: private static void a(int[] var0, int[][] var1, int var2, int var3)
    $pattern = '(static\s+void\s+)a\((int\[\]\s+\w+,\s*int\[\]\[\]\s+\w+,\s*int\s+\w+,\s*int\s+\w+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, '$1updateTowerArray(${2})')
        $fileReplacements += $matches.Count
    }

    # ===== 替换调用处 (不带 this. 前缀的调用) =====
    # 注意: 必须在方法定义替换之后执行, 避免重复匹配

    # calcBaseHp: d(3个参数) 不带 this.
    # 匹配模式: (?<!this\.)(?<!\w)d( ... 3个参数, 不含换行)
    # 由于参数可能是复杂表达式, 用 [^)]+ 匹配参数
    # 但要确保是3个参数(2个逗号)
    # 注意: 替换字符串中使用 ${1} 而非 $1, 避免与后面的 ) 混淆
    $pattern = '(?<!this\.)(?<![\w])d\(([^()]+,[^()]+,[^()]+)\)'
    $matches = [regex]::Matches($content, $pattern)
    if ($matches.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern, 'calcBaseHp(${1})')
        $fileReplacements += $matches.Count
    }

    # hexCharToInt: e(1个参数) 不带 this.
    # 注意: e( 可能匹配字符串中的 'e(', 但在代码中不太可能
    # 用 (?<!this\.)(?<!\w) 确保不是 this.e( 或标识符的一部分
    # 同时排除注释行 (以 // 开头)
    # 注意: 这个替换有风险, 因为 e 可能是局部变量
    # 暂时跳过, 只替换方法定义

    # isNotCommonTower: f(1个参数) 不带 this.
    # 同样有风险, 暂时跳过

    if ($fileReplacements -gt 0) {
        Set-Content -Path $file.FullName -Value $content -Encoding UTF8 -NoNewline
        Write-Output "$($file.Name): $fileReplacements static method replacements"
        $totalReplacements += $fileReplacements
    }
}

Write-Output ""
Write-Output "=== Total static method replacements: $totalReplacements ==="
