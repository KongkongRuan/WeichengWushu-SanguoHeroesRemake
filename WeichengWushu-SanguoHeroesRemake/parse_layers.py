#!/usr/bin/env python3
"""
Deep parse map data files to extract all 4 layers and wave/spawn data.
"""
import os

GAME_DIR = r'd:\project\危城无双之三国群英\extracted_game_files'

def read_le_short(data, offset):
    b0 = data[offset] & 0xFF
    b1 = data[offset + 1] & 0xFF
    return (b0 | (b1 << 8)) & 0xFFFF

def parse_4_layers(filepath, name):
    data = open(filepath, 'rb').read()
    print(f"\n{'='*60}")
    print(f"{name} (size={len(data)})")
    print(f"{'='*60}")
    
    w = read_le_short(data, 0)
    h = read_le_short(data, 2)
    tiles = w * h
    print(f"Dimensions: {w}x{h} = {tiles} tiles")
    
    total_data = len(data) - 4
    num_layers = total_data // tiles
    
    for layer in range(num_layers):
        start = 4 + layer * tiles
        layer_data = list(data[start:start+tiles])
        unique = sorted(set(layer_data))
        print(f"\n  Layer {layer}: offset={start}, size={tiles}")
        print(f"  Unique values: {unique}")
        
        # Print as 2D grid
        print(f"  Grid ({w}x{h}):")
        for row in range(h):
            row_data = layer_data[row*w:(row+1)*w]
            # Print compactly
            line = ''.join(f'{v:2X} ' for v in row_data)
            print(f"    {line}")
    
    return w, h, tiles

# Parse mapdatalv0 (level 0) in detail
parse_4_layers(os.path.join(GAME_DIR, 'mapdatalv0'), 'mapdatalv0')

# Parse mapsp1 (level 1 spawn data)
parse_4_layers(os.path.join(GAME_DIR, 'mapsp1'), 'mapsp1')
