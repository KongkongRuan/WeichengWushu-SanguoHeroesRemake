#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
v13 修复脚本: 修复 v12 遗留的同名方法问题
v12 的简单文本替换导致 boolean/int 版本的方法被赋予了 void 版本的名称
本脚本根据返回类型修正这些方法定义
"""

import re
import os

RENAMED_DIR = r"d:\Development\ts\WeichengWushu-SanguoHeroesRemake\a_java_analysis\deobfuscated_modules_renamed"

# v12 错误命名 → 正确命名 (按返回类型)
# 格式: (v12错误名, 错误返回类型) → 正确名
FIX_MAP = {
    # e() 系列
    ('clearScreen', 'boolean'): 'isTechTreeUnlocked',
    # f() 系列
    ('drawProgressBar', 'boolean'): 'initGame',
    # g() 系列
    ('handleVolume', 'boolean'): 'uploadScore',
    # a() 系列
    ('menuReturn', 'boolean'): 'loadRMS_sanGuoTd',
    ('menuReturn', 'int'): 'randomByte',
    # b() 系列
    ('menuReset', 'boolean'): 'loadRMS_sanGuoTdData',
    ('menuReset', 'int'): 'getThreadState',
    # c() 系列
    ('resetCounters', 'boolean'): 'loadRMS_freeGame',
    ('resetCounters', 'int'): 'waitHttpResponse',
    # d() 系列
    ('drawBuildMenuBg', 'boolean'): 'checkLandscape',
    ('drawBuildMenuBg', 'int'): 'doHttpCommunication',
}


def fix_method_definitions(content):
    """修复方法定义中的错误命名"""
    replacements = 0
    lines = content.split('\n')
    new_lines = []

    for line in lines:
        stripped = line.strip()
        # 跳过注释行
        if stripped.startswith('//') or stripped.startswith('*') or stripped.startswith('/*'):
            new_lines.append(line)
            continue

        # 匹配方法定义: [modifiers] return_type methodName() {
        pattern = r'^(\s*(?:private|public|protected)\s+(?:(?:static|final|synchronized)\s+)*)(\S+(?:\s*\[\s*\])*)\s+(\w+)\s*\(\s*\)\s*(\{)'
        match = re.match(pattern, line)
        if not match:
            new_lines.append(line)
            continue

        modifiers = match.group(1)
        return_type = match.group(2)
        method_name = match.group(3)
        ending = match.group(4)

        # 检查是否需要修复
        key = (method_name, return_type)
        if key in FIX_MAP:
            correct_name = FIX_MAP[key]
            new_line = line[:match.start(3)] + correct_name + line[match.end(3):]
            new_lines.append(new_line)
            replacements += 1
        else:
            new_lines.append(line)

    return '\n'.join(new_lines), replacements


def fix_method_calls(content):
    """修复方法调用中的错误命名(仅无参方法)"""
    replacements = 0
    lines = content.split('\n')
    new_lines = []

    for line in lines:
        stripped = line.strip()
        # 跳过注释行和方法定义行
        if stripped.startswith('//') or stripped.startswith('*') or stripped.startswith('/*'):
            new_lines.append(line)
            continue
        if re.match(r'^\s*(?:private|public|protected)\s+', line):
            new_lines.append(line)
            continue

        new_line = line

        # 修复 this.clearScreen() 在 boolean 上下文中
        # 修复 this.drawProgressBar() 在 boolean 上下文中
        # 等
        for wrong_name, fixes in [('clearScreen', {'boolean': 'isTechTreeUnlocked'}),
                                   ('drawProgressBar', {'boolean': 'initGame'}),
                                   ('handleVolume', {'boolean': 'uploadScore'}),
                                   ('menuReturn', {'boolean': 'loadRMS_sanGuoTd', 'int': 'randomByte'}),
                                   ('menuReset', {'boolean': 'loadRMS_sanGuoTdData', 'int': 'getThreadState'}),
                                   ('resetCounters', {'boolean': 'loadRMS_freeGame', 'int': 'waitHttpResponse'}),
                                   ('drawBuildMenuBg', {'boolean': 'checkLandscape', 'int': 'doHttpCommunication'})]:
            pattern = f'this\\.{wrong_name}\\s*\\(\\s*\\)'
            matches = list(re.finditer(pattern, new_line))
            for match in reversed(matches):
                before = new_line[:match.start()].rstrip()
                after = new_line[match.end():].lstrip()

                # 推断返回类型
                return_type = infer_return_type(before, after)

                if return_type in fixes:
                    correct_name = fixes[return_type]
                    replacement = f'this.{correct_name}()'
                    new_line = new_line[:match.start()] + replacement + new_line[match.end():]
                    replacements += 1

        new_lines.append(new_line)

    return '\n'.join(new_lines), replacements


def infer_return_type(before, after):
    """根据调用上下文推断返回类型"""
    before = before.rstrip()
    after = after.lstrip()

    # 赋值
    assign_match = re.search(r'(\w+(?:\s*\[\s*\])*)\s+\w+\s*=\s*$', before)
    if assign_match:
        return assign_match.group(1)

    # return
    if re.search(r'return\s+$', before):
        return 'int'

    # 条件
    if re.search(r'(?:if|while|do)\s*\(\s*!?\s*$', before):
        return 'boolean'

    # 逻辑表达式
    if re.search(r'&&\s*$', before) or re.search(r'\|\|\s*$', before):
        return 'boolean'

    # 比较
    if re.match(r'==|!=|<=|>=|<|>', after):
        return 'int'

    # 位操作
    if re.match(r'[&|]', after) or re.search(r'[&|]\s*$', before):
        return 'int'

    # 算术
    if re.match(r'[+\-*/%]', after) or re.search(r'[+\-*/%]\s*$', before):
        return 'int'

    # 数组索引
    if re.match(r'\]', after):
        return 'int'

    # 独立语句 → void
    if after.startswith(';') or after.startswith('}'):
        return 'void'

    return 'void'


def main():
    print("=" * 60)
    print("v13 修复脚本: 修正 v12 同名方法问题")
    print("=" * 60)

    target_files = []
    for f in os.listdir(RENAMED_DIR):
        if re.match(r'^0[0-9]_.*\.java$', f):
            target_files.append(f)
    target_files.sort()

    total_def_fixes = 0
    total_call_fixes = 0

    for filename in target_files:
        filepath = os.path.join(RENAMED_DIR, filename)
        print(f"\n处理: {filename}")

        with open(filepath, 'r', encoding='utf-8') as f:
            content = f.read()

        original = content

        # 修复方法定义
        content, def_fixes = fix_method_definitions(content)
        print(f"  方法定义修复: {def_fixes}")
        total_def_fixes += def_fixes

        # 修复方法调用
        content, call_fixes = fix_method_calls(content)
        print(f"  方法调用修复: {call_fixes}")
        total_call_fixes += call_fixes

        if content != original:
            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(content)
            print(f"  [OK] 已更新")
        else:
            print(f"  - 无变化")

    print(f"\n总计: 定义修复={total_def_fixes}, 调用修复={total_call_fixes}")


if __name__ == '__main__':
    main()
