#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
a.java 反编译源码综合解析器
==========================
功能:
  1. 提取所有字段声明(混淆名、类型、修饰符)
  2. 提取所有方法签名(方法名、参数、返回类型)
  3. 提取构造函数中的数值数组初始化代码
  4. 提取 b1015 字符串数组(含中文解码)
  5. 统计类结构信息

输出:
  - output/fields.json       字段列表
  - output/methods.json      方法列表
  - output/data_arrays.json  数值数组(解析后)
  - output/strings.json      字符串数组(中文解码)
  - output/summary.json      统计摘要
"""
import os
import re
import json
import sys

# 解决 Windows 控制台中文输出
if sys.platform == 'win32':
    sys.stdout.reconfigure(encoding='utf-8')

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
ROOT_DIR = os.path.abspath(os.path.join(BASE_DIR, '..', '..'))
SRC_FILE = os.path.join(ROOT_DIR, 'decompiled_source', 'a.java')
OUT_DIR = os.path.join(BASE_DIR, '..', 'output')
os.makedirs(OUT_DIR, exist_ok=True)


def read_source():
    with open(SRC_FILE, 'r', encoding='utf-8') as f:
        return f.read()


# ============================================================
# 1. 字段提取
# ============================================================
FIELD_PATTERN = re.compile(
    r'^\s*(public|private|protected)?\s+'
    r'(static\s+)?'
    r'(final\s+)?'
    r'([a-zA-Z_][\w\[\]\.<>]*)\s+'
    r'([a-zA-Z_]\w*)\s*'
    r'(?:=\s*[^;]+)?;',
    re.MULTILINE
)

# 仅匹配类成员声明(以 private/public/protected 开头)
MEMBER_FIELD_PATTERN = re.compile(
    r'^\s+(private|public|protected)\s+'
    r'(static\s+)?'
    r'(final\s+)?'
    r'([a-zA-Z_][\w\[\]\.<>]*)\s+'
    r'([a-zA-Z_]\w*)\s*;',
    re.MULTILINE
)


def extract_fields(source):
    """提取类成员字段声明"""
    fields = []
    for m in MEMBER_FIELD_PATTERN.finditer(source):
        modifier = m.group(1)
        is_static = bool(m.group(2))
        is_final = bool(m.group(3))
        field_type = m.group(4)
        field_name = m.group(5)
        line_no = source[:m.start()].count('\n') + 1
        fields.append({
            'name': field_name,
            'type': field_type,
            'modifier': modifier,
            'static': is_static,
            'final': is_final,
            'line': line_no,
            'full_decl': m.group(0).strip(),
        })
    return fields


# ============================================================
# 2. 方法签名提取
# ============================================================
METHOD_PATTERN = re.compile(
    r'^\s*(public|private|protected)\s+'
    r'((?:static|final|synchronized|abstract)\s+)*'
    r'([a-zA-Z_][\w\[\]\.<>]*)\s+'
    r'([a-zA-Z_]\w*)\s*\(([^)]*)\)\s*\{',
    re.MULTILINE
)


def extract_methods(source):
    """提取方法签名"""
    methods = []
    for m in METHOD_PATTERN.finditer(source):
        modifier = m.group(1)
        modifiers_extra = m.group(2) or ''
        return_type = m.group(3)
        method_name = m.group(4)
        params = m.group(5).strip()
        line_no = source[:m.start()].count('\n') + 1

        # 解析参数
        param_list = []
        if params:
            for p in params.split(','):
                p = p.strip()
                if not p:
                    continue
                # 例如 "int n" 或 "byte[] byArray"
                parts = p.rsplit(None, 1)
                if len(parts) == 2:
                    ptype, pname = parts
                else:
                    ptype, pname = p, ''
                # 去除 var 前缀(如 var1_1)
                param_list.append({'type': ptype, 'name': pname})

        methods.append({
            'name': method_name,
            'return_type': return_type,
            'modifier': modifier,
            'modifiers_extra': modifiers_extra.strip(),
            'params': param_list,
            'params_raw': params,
            'line': line_no,
            'signature': f"{return_type} {method_name}({params})",
        })
    return methods


# ============================================================
# 3. 数值数组提取(从构造函数)
# ============================================================

def extract_array_assignments(source):
    """提取 this.xxx = (Type)object; 模式的数组赋值"""
    # 匹配 this.xxx = (Type)object;  后面紧跟数组初始化
    pattern = re.compile(
        r'this\.(\w+)\s*=\s*\(([\w\[\]]+)\)\s*object\s*;',
        re.MULTILINE
    )
    assignments = []
    for m in pattern.finditer(source):
        name = m.group(1)
        cast_type = m.group(2)
        line_no = source[:m.start()].count('\n') + 1
        assignments.append({
            'field': name,
            'cast_type': cast_type,
            'line': line_no,
        })
    return assignments


def extract_array_new(source):
    """提取 new Type[n] 数组创建语句"""
    pattern = re.compile(
        r'object\s*=\s*new\s+([\w\[\]]+)\s*\[(\d+)\]',
        re.MULTILINE
    )
    news = []
    for m in pattern.finditer(source):
        type_name = m.group(1)
        size = int(m.group(2))
        line_no = source[:m.start()].count('\n') + 1
        news.append({
            'type': type_name,
            'size': size,
            'line': line_no,
        })
    return news


def extract_numeric_initializers(source, field_name, max_range=100):
    """
    提取特定字段的数值初始化,模式如:
      nArray[0] = 6305566;
      nArray2[1] = 32260;
    返回该字段初始化区段内的索引→值映射
    """
    # 在 this.<field> = (Type)object; 之前找 object = new Type[n];
    # 然后收集其后的索引赋值
    pattern = re.compile(
        r'this\.' + re.escape(field_name) + r'\s*=\s*\([\w\[\]]+\)\s*object\s*;'
    )
    m = pattern.search(source)
    if not m:
        return None
    assign_line = m.start()

    # 向前找 object = new Type[n];
    before = source[:assign_line]
    new_pattern = re.compile(
        r'object\s*=\s*new\s+([\w\[\]]+)\s*\[(\d+)\]\s*;'
    )
    new_matches = list(new_pattern.finditer(before))
    if not new_matches:
        return None
    last_new = new_matches[-1]
    array_type = last_new.group(1)
    array_size = int(last_new.group(2))
    new_start = last_new.start()

    # 收集 new_start 到 assign_line 之间的索引赋值
    segment = source[new_start:assign_line + 100]
    idx_pattern = re.compile(
        r'(?:nArray\d*|nArray2|objectArray\d*|byArray\d*|nArray3|nArray4)'
        r'\s*\[(\d+)\]\s*=\s*([^;]+);'
    )
    values = {}
    for im in idx_pattern.finditer(segment):
        idx = int(im.group(1))
        val_str = im.group(2).strip()
        # 尝试解析为整数
        try:
            if val_str.startswith('(int)'):
                val_str = val_str[5:].strip()
            if val_str.startswith('(byte)'):
                val_str = val_str[6:].strip()
            val = int(val_str)
            values[idx] = val
        except ValueError:
            values[idx] = val_str  # 保留原始字符串

    return {
        'field': field_name,
        'type': array_type,
        'size': array_size,
        'values': values,
        'new_line': source[:new_start].count('\n') + 1,
        'assign_line': source[:assign_line].count('\n') + 1,
    }


# ============================================================
# 4. 字符串数组 b1015 提取
# ============================================================

def decode_java_string(s):
    """解码 Java 字符串字面量中的 Unicode 转义"""
    def replace_unicode(m):
        return chr(int(m.group(1), 16))
    s = re.sub(r'\\u([0-9a-fA-F]{4})', replace_unicode, s)
    s = s.replace('\\n', '\n').replace('\\t', '\t').replace('\\"', '"').replace("\\'", "'")
    return s


def extract_b1015_strings(source):
    """提取 b1015 字符串数组的所有元素"""
    # 找到 this.b1015 = (String[])object;
    pattern = re.compile(r'this\.b1015\s*=\s*\(String\[\]\)\s*object\s*;')
    m = pattern.search(source)
    if not m:
        return []
    assign_pos = m.start()

    # 向前找 object = new String[N];
    before = source[:assign_pos]
    new_pattern = re.compile(r'object\s*=\s*new\s+String\[(\d+)\]\s*;')
    new_matches = list(new_pattern.finditer(before))
    if not new_matches:
        return []
    last_new = new_matches[-1]
    array_size = int(last_new.group(1))
    new_start = last_new.start()

    segment = source[new_start:assign_pos]
    # 匹配 object[idx] = (int)"..."; 或 objectArray[idx] = (int)"...";
    str_pattern = re.compile(
        r'object\s*\[(\d+)\]\s*=\s*\(int\)"((?:[^"\\]|\\.)*)"\s*;'
    )
    strings = {}
    for sm in str_pattern.finditer(segment):
        idx = int(sm.group(1))
        raw = sm.group(2)
        decoded = decode_java_string(raw)
        strings[idx] = decoded

    return {
        'size': array_size,
        'values': strings,
    }


# ============================================================
# 5. 主流程
# ============================================================

def main():
    print(f'读取源文件: {SRC_FILE}')
    source = read_source()
    line_count = source.count('\n') + 1
    print(f'源文件行数: {line_count}')

    summary = {'total_lines': line_count}

    # 1. 字段
    print('\n[1/5] 提取字段声明...')
    fields = extract_fields(source)
    print(f'  找到 {len(fields)} 个字段')
    with open(os.path.join(OUT_DIR, 'fields.json'), 'w', encoding='utf-8') as f:
        json.dump(fields, f, ensure_ascii=False, indent=2)

    # 字段分类统计
    field_types = {}
    for fld in fields:
        t = fld['type']
        field_types[t] = field_types.get(t, 0) + 1
    summary['field_count'] = len(fields)
    summary['field_types'] = field_types

    # 2. 方法
    print('[2/5] 提取方法签名...')
    methods = extract_methods(source)
    print(f'  找到 {len(methods)} 个方法')
    with open(os.path.join(OUT_DIR, 'methods.json'), 'w', encoding='utf-8') as f:
        json.dump(methods, f, ensure_ascii=False, indent=2)

    # 方法名统计(重载)
    method_names = {}
    for m in methods:
        method_names[m['name']] = method_names.get(m['name'], 0) + 1
    summary['method_count'] = len(methods)
    summary['unique_method_names'] = len(method_names)
    summary['method_overloads'] = {
        k: v for k, v in sorted(method_names.items(), key=lambda x: -x[1])[:20]
    }

    # 3. 数组赋值
    print('[3/5] 提取数组赋值...')
    array_assigns = extract_array_assignments(source)
    print(f'  找到 {len(array_assigns)} 个 this.xxx = (Type)object 赋值')
    with open(os.path.join(OUT_DIR, 'array_assignments.json'), 'w', encoding='utf-8') as f:
        json.dump(array_assigns, f, ensure_ascii=False, indent=2)

    # 4. 关键数值数组提取
    print('[4/5] 提取关键数值数组...')
    key_arrays = [
        'd1011', 'f', 'a1014', 'b1015', 'c1051', 'a1052', 'd1053',
        'e1054', 'f1055', 'g1057', 'o1098', 'p1099', 'q1100',
        'r1101', 's1102', 't1103', 'u1104', 'v1109', 'w1123',
        'x1124', 'y1125',
    ]
    arrays_data = {}
    for fname in key_arrays:
        result = extract_numeric_initializers(source, fname)
        if result:
            arrays_data[fname] = result
            print(f'  {fname}: type={result["type"]}, size={result["size"]}, values={len(result["values"])}')
        else:
            print(f'  {fname}: 未找到')
    with open(os.path.join(OUT_DIR, 'data_arrays.json'), 'w', encoding='utf-8') as f:
        json.dump(arrays_data, f, ensure_ascii=False, indent=2)
    summary['key_arrays_extracted'] = list(arrays_data.keys())

    # 5. 字符串数组 b1015
    print('[5/5] 提取 b1015 字符串数组...')
    b1015 = extract_b1015_strings(source)
    print(f'  size={b1015["size"]}, values={len(b1015["values"])}')
    with open(os.path.join(OUT_DIR, 'strings_b1015.json'), 'w', encoding='utf-8') as f:
        json.dump(b1015, f, ensure_ascii=False, indent=2)
    summary['b1015_size'] = b1015['size']
    summary['b1015_extracted'] = len(b1015['values'])

    # 保存摘要
    with open(os.path.join(OUT_DIR, 'summary.json'), 'w', encoding='utf-8') as f:
        json.dump(summary, f, ensure_ascii=False, indent=2)

    print(f'\n完成! 输出目录: {OUT_DIR}')
    print('生成文件:')
    for fn in ['fields.json', 'methods.json', 'array_assignments.json',
               'data_arrays.json', 'strings_b1015.json', 'summary.json']:
        fp = os.path.join(OUT_DIR, fn)
        if os.path.exists(fp):
            print(f'  - {fn} ({os.path.getsize(fp)} bytes)')


if __name__ == '__main__':
    main()
