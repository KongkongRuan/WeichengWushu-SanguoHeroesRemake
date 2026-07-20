#!/usr/bin/env python3
"""
Parse map data files from the J2ME game to extract level/wave configurations.
"""
import os
import struct

GAME_DIR = r'd:\project\危城无双之三国群英\extracted_game_files'

def read_le_short(data, offset):
    """Read a little-endian short (as the Java a.a() method does)."""
    b0 = data[offset] & 0xFF
    b1 = data[offset + 1] & 0xFF
    return (b0 | (b1 << 8)) & 0xFFFF

def parse_mapdatalv(filepath):
    """Parse /mapdatalvN files - loaded by B(int n).
    Format: 2-byte LE width, 2-byte LE height, then 2 tile layers of size width*height.
    """
    data = open(filepath, 'rb').read()
    print(f"\n=== {os.path.basename(filepath)} (size={len(data)}) ===")
    
    if len(data) < 4:
        print("  File too small!")
        return
    
    bG = read_le_short(data, 0)  # width
    bH = read_le_short(data, 2)  # height
    n2 = bG * bH  # tile count
    expected = 4 + n2 * 2  # 2 layers
    
    print(f"  Width(bG)={bG}, Height(bH)={bH}, Tiles={n2}")
    print(f"  Expected size: 4 + {n2}*2 = {expected}")
    print(f"  Actual size: {len(data)}")
    print(f"  Extra bytes: {len(data) - expected}")
    
    if expected == len(data):
        layer1 = data[4:4+n2]
        layer2 = data[4+n2:4+2*n2]
        print(f"  Layer1 (B1160): {list(layer1[:50])}...")
        print(f"  Layer2 (C1161): {list(layer2[:50])}...")
        
        # Count unique tile types
        tiles1 = set(layer1)
        tiles2 = set(layer2)
        print(f"  Layer1 unique tiles: {sorted(tiles1)}")
        print(f"  Layer2 unique tiles: {sorted(tiles2)}")
    elif len(data) > expected:
        # Maybe there are 4 layers, or extra data
        print(f"  File has {len(data) - 4} data bytes after header")
        possible_layers = (len(data) - 4) // n2
        remainder = (len(data) - 4) % n2
        print(f"  Possible {possible_layers} layers of size {n2} (remainder={remainder})")
        
        # Try different dimension interpretations
        total_data = len(data) - 4
        print(f"  Trying other dimensions:")
        for w in range(1, 100):
            if total_data % w == 0:
                h = total_data // w
                if w * h == total_data and total_data % 2 == 0:
                    layers = total_data // (w * h)
                    if layers * w * h == total_data and layers <= 4:
                        print(f"    {w}x{h} = {w*h} tiles, {layers} layers")

def parse_mapsp(filepath):
    """Parse /mapspN files - loaded by D(int n).
    Format: 2-byte LE width, 2-byte LE height, then 2 arrays of size width*height.
    """
    data = open(filepath, 'rb').read()
    print(f"\n=== {os.path.basename(filepath)} (size={len(data)}) ===")
    
    if len(data) < 4:
        print("  File too small!")
        return
    
    n2 = read_le_short(data, 0)  # first short
    s = read_le_short(data, 2)   # second short
    total = n2 * s
    expected = 4 + total * 2
    
    print(f"  Short1={n2}, Short2={s}, Product={total}")
    print(f"  Expected size: 4 + {total}*2 = {expected}")
    print(f"  Actual size: {len(data)}")
    print(f"  Extra bytes: {len(data) - expected}")
    
    if expected == len(data):
        layer1 = data[4:4+total]
        layer2 = data[4+total:4+2*total]
        print(f"  Layer1 (F1164): {list(layer1[:80])}")
        print(f"  Layer2 (G1165): {list(layer2[:80])}")
        tiles1 = set(layer1)
        tiles2 = set(layer2)
        print(f"  Layer1 unique values: {sorted(tiles1)}")
        print(f"  Layer2 unique values: {sorted(tiles2)}")
    elif len(data) > expected:
        total_data = len(data) - 4
        print(f"  Data bytes: {total_data}")
        # Try different dimension interpretations
        for w in range(1, 200):
            if total_data % w == 0:
                h = total_data // w
                for nl in [2, 4]:
                    if w * h == total_data and total_data % nl == 0:
                        layers = total_data // (w * h)
                        if layers <= 4 and layers * w * h == total_data:
                            pass  # Too many combinations

def parse_mapdata(filepath):
    """Parse /mapdataN files - loaded by C(int n).
    Format: 1-byte width, 1-byte height, then width*height bytes.
    """
    data = open(filepath, 'rb').read()
    print(f"\n=== {os.path.basename(filepath)} (size={len(data)}) ===")
    
    if len(data) < 2:
        print("  File too small!")
        return
    
    w = data[0]
    h = data[1]
    total = w * h
    expected = 2 + total
    
    print(f"  Width={w}, Height={h}, Tiles={total}")
    print(f"  Expected size: 2 + {total} = {expected}")
    print(f"  Actual size: {len(data)}")
    
    if expected <= len(data):
        layer = data[2:2+total]
        print(f"  Layer (E1163): {list(layer[:80])}")
        tiles = set(layer)
        print(f"  Unique values: {sorted(tiles)}")
        
        # Check for second layer
        remaining = len(data) - expected
        if remaining > 0:
            print(f"  Remaining bytes: {remaining}")
            if remaining == total:
                layer2 = data[2+total:2+2*total]
                print(f"  Layer2 (D1162): {list(layer2[:80])}")

# Parse all mapdatalv files (level tile data)
print("=" * 60)
print("MAP DATA LEVEL FILES (mapdatalv)")
print("=" * 60)
for i in range(9):
    filepath = os.path.join(GAME_DIR, f'mapdatalv{i}')
    if os.path.exists(filepath):
        parse_mapdatalv(filepath)

# Parse all mapsp files (spawn/path data)
print("\n" + "=" * 60)
print("MAP SP FILES (mapsp)")
print("=" * 60)
for i in range(1, 9):
    filepath = os.path.join(GAME_DIR, f'mapsp{i}')
    if os.path.exists(filepath):
        parse_mapsp(filepath)

# Parse all mapdata files
print("\n" + "=" * 60)
print("MAP DATA FILES (mapdata)")
print("=" * 60)
for i in range(7):
    filepath = os.path.join(GAME_DIR, f'mapdata{i}')
    if os.path.exists(filepath):
        parse_mapdata(filepath)
