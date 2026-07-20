"""
提取 J2ME 原版地图图集 map0-map6 为标准 PNG 文件
原版 map 文件格式: 2字节大端长度前缀 + 标准PNG数据
"""
import struct
import os
import shutil

BASE = r'd:\Development\ts\WeichengWushu-SanguoHeroesRemake'
SRC_DIR = os.path.join(BASE, 'extracted_game_files')
DST_DIR = os.path.join(BASE, 'game', 'public', 'sprites')

def extract_map(src_path, dst_path):
    """提取单个 map 文件为 PNG
    原版格式: 2字节前缀(非长度, 可能是J2ME资源标记) + 标准PNG数据
    PNG签名 89 50 4E 47 从偏移2开始
    """
    with open(src_path, 'rb') as f:
        data = f.read()

    # 查找 PNG 签名位置
    png_sig = b'\x89PNG'
    idx = data.find(png_sig)
    if idx < 0:
        print(f"  [跳过] {os.path.basename(src_path)}: 未找到PNG签名")
        return False

    png_data = data[idx:]

    # 写入标准 PNG
    with open(dst_path, 'wb') as f:
        f.write(png_data)

    # 读取尺寸信息
    # PNG IHDR chunk: 偏移8(签名) +4(长度) +4(类型IHDR) = 16开始是宽, 20开始是高
    w = struct.unpack('>I', png_data[16:20])[0]
    h = struct.unpack('>I', png_data[20:24])[0]
    print(f"  [OK] {os.path.basename(src_path)} -> {os.path.basename(dst_path)}: {w}x{h}, {len(png_data)} bytes")
    return True

def main():
    print("提取原版地图图集 map0-map6...")
    count = 0
    for i in range(7):
        src = os.path.join(SRC_DIR, f'map{i}')
        dst = os.path.join(DST_DIR, f'map{i}.png')
        if not os.path.exists(src):
            print(f"  [跳过] map{i}: 源文件不存在")
            continue
        if extract_map(src, dst):
            count += 1

    print(f"\n完成: 提取了 {count} 个地图图集")

    # 同时复制 l0.png 和 l1.png (UI/字体图集)
    for name in ['l0.png', 'l1.png', 'i64x64.png']:
        src = os.path.join(SRC_DIR, name)
        dst = os.path.join(DST_DIR, name)
        if os.path.exists(src):
            shutil.copy2(src, dst)
            print(f"  复制 {name}")

if __name__ == '__main__':
    main()
