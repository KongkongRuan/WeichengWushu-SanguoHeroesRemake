# 替换 e(int) 和 f(int) 的 static 方法调用
$targetDir = "d:\Development\ts\WeichengWushu-SanguoHeroesRemake\a_java_analysis\deobfuscated_modules_renamed"
$files = @("06_logic_a_z.java", "08_bytecode_recovered.java")
$totalReplacements = 0

foreach ($fileName in $files) {
    $filePath = Join-Path $targetDir $fileName
    $content = Get-Content -Path $filePath -Raw -Encoding UTF8
    $count = 0

    # 替换 e(this.httpResponseData[ -> hexCharToInt(this.httpResponseData[
    # 只匹配不带 this. 前缀的 e(
    $pattern1 = '(?<!this\.)(?<![\w])e\((this\.httpResponseData)'
    $matches1 = [regex]::Matches($content, $pattern1)
    if ($matches1.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern1, 'hexCharToInt(${1}')
        $count += $matches1.Count
    }

    # 替换 f(tower[8]) -> isNotCommonTower(tower[8])
    $pattern2 = '(?<!this\.)(?<![\w])f\((tower\[8\])\)'
    $matches2 = [regex]::Matches($content, $pattern2)
    if ($matches2.Count -gt 0) {
        $content = [regex]::Replace($content, $pattern2, 'isNotCommonTower(${1})')
        $count += $matches2.Count
    }

    if ($count -gt 0) {
        Set-Content -Path $filePath -Value $content -Encoding UTF8 -NoNewline
        Write-Output "$fileName : $count replacements"
        $totalReplacements += $count
    }
}

Write-Output "=== Total: $totalReplacements ==="
