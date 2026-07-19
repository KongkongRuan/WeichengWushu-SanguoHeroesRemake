#!/usr/bin/env python3
"""
Export binary map data to JSON format for the H5 game.
Extracts tile layers, path data, and spawn points from mapdatalv and mapsp files.
"""
import os
import json

GAME_DIR = r'd:\project\危城无双之三国群英\extracted_game_files'
OUTPUT_DIR = r'd:\project\危城无双之三国群英\game\public\maps'

os.makedirs(OUTPUT_DIR, exist_ok=True)

def read_le_short(data, offset):
    b0 = data[offset] & 0xFF
    b1 = data[offset + 1] & 0xFF
    return (b0 | (b1 << 8)) & 0xFFFF

def parse_map_file(filepath):
    """Parse a 4-layer map file (mapdatalv or mapsp).
    Returns: width, height, [layer0, layer1, layer2, layer3]
    """
    data = open(filepath, 'rb').read()
    if len(data) < 4:
        return None
    
    w = read_le_short(data, 0)
    h = read_le_short(data, 2)
    tiles = w * h
    total_data = len(data) - 4
    num_layers = total_data // tiles if tiles > 0 else 0
    
    if num_layers == 0:
        return None
    
    layers = []
    for layer in range(num_layers):
        start = 4 + layer * tiles
        layer_data = list(data[start:start + tiles])
        layers.append(layer_data)
    
    return w, h, layers

def parse_mapdata_file(filepath):
    """Parse a mapdata file (1-byte width, 1-byte height, then tiles).
    """
    data = open(filepath, 'rb').read()
    if len(data) < 2:
        return None
    
    w = data[0]
    h = data[1]
    tiles = w * h
    
    layer = list(data[2:2 + tiles])
    return w, h, [layer]

# Export all mapdatalv files (level tile + path data)
for level in range(9):
    filepath = os.path.join(GAME_DIR, f'mapdatalv{level}')
    if not os.path.exists(filepath):
        continue
    
    result = parse_map_file(filepath)
    if result is None:
        continue
    
    w, h, layers = result
    # Layers 0&2 are tile map, Layers 1&3 are path/buildable map
    tile_layer = layers[0] if len(layers) > 0 else []
    path_layer = layers[1] if len(layers) > 1 else []
    
    level_data = {
        'level': level,
        'width': w,
        'height': h,
        'tileLayer': tile_layer,
        'pathLayer': path_layer,
    }
    
    # Also load corresponding mapdata file for base terrain
    mapdata_path = os.path.join(GAME_DIR, f'mapdata{level}')
    if os.path.exists(mapdata_path):
        md_result = parse_mapdata_file(mapdata_path)
        if md_result:
            md_w, md_h, md_layers = md_result
            level_data['terrainLayer'] = md_layers[0]
    
    output_path = os.path.join(OUTPUT_DIR, f'level{level}.json')
    with open(output_path, 'w', encoding='utf-8') as f:
        json.dump(level_data, f)
    print(f"Exported level{level}.json: {w}x{h}, tiles={len(tile_layer)}, path={len(path_layer)}")

# Export all mapsp files (spawn point data)
for level in range(1, 9):
    filepath = os.path.join(GAME_DIR, f'mapsp{level}')
    if not os.path.exists(filepath):
        continue
    
    result = parse_map_file(filepath)
    if result is None:
        continue
    
    w, h, layers = result
    spawn_layer = layers[0] if len(layers) > 0 else []
    flag_layer = layers[1] if len(layers) > 1 else []
    
    # Extract spawn points (values 1/2 = entry, 5/6 = exit, 3 = waypoint)
    spawn_points = []
    for y in range(h):
        for x in range(w):
            val = spawn_layer[y * w + x]
            if val != 0:
                spawn_points.append({'x': x, 'y': y, 'type': val})
    
    spawn_data = {
        'level': level,
        'width': w,
        'height': h,
        'spawnLayer': spawn_layer,
        'flagLayer': flag_layer,
        'spawnPoints': spawn_points,
    }
    
    output_path = os.path.join(OUTPUT_DIR, f'spawns{level}.json')
    with open(output_path, 'w', encoding='utf-8') as f:
        json.dump(spawn_data, f)
    print(f"Exported spawns{level}.json: {w}x{h}, spawn_points={len(spawn_points)}")

print("\nAll map data exported successfully!")
