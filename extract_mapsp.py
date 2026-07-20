import os, json

BASE = r'd:\Development\ts\WeichengWushu-SanguoHeroesRemake'

def read_short_le(data, offset):
    lo = data[offset] & 0xFF
    hi = data[offset+1] & 0xFF
    return lo | (hi << 8)

# Extract mapsp data (path overlay layer) for levels 1-8
for lvl in range(1, 9):
    path = os.path.join(BASE, 'a_java_analysis', 'bytecode', 'j2me_extracted', f'mapsp{lvl}')
    if not os.path.exists(path):
        print(f'mapsp{lvl} not found')
        continue
    data = open(path, 'rb').read()
    w = read_short_le(data, 0)
    h = read_short_le(data, 2)
    tile_count = w * h
    
    # 4 layers of w*h bytes each (only first 2 are used by original: F1164 and G1165)
    path_layer = list(data[4:4+tile_count])           # F1164: path tile indices
    flip_layer = list(data[4+tile_count:4+tile_count*2])  # G1165: path flip modes
    
    # Also read mapdatalv to get the matching map dimensions
    map_path = os.path.join(BASE, 'a_java_analysis', 'bytecode', 'j2me_extracted', f'mapdatalv{lvl}')
    map_data = open(map_path, 'rb').read()
    map_w = read_short_le(map_data, 0)
    map_h = read_short_le(map_data, 2)
    
    print(f'mapsp{lvl}: w={w} h={h} map_w={map_w} map_h={map_h} match={w==map_w and h==map_h}')
    
    # Verify dimensions match
    if w != map_w or h != map_h:
        print(f'  WARNING: mapsp dimensions don\'t match mapdatalv!')
    
    # Find spawn/entry points and path tiles
    path_tiles = []
    spawn_points = []
    for i, v in enumerate(path_layer):
        if v != 0:
            px = i % w
            py = i // w
            path_tiles.append((px, py, v, flip_layer[i]))
            # Values 1,2 = entry points, 3 = waypoint, 5,6 = exit points
            if v in (1, 2, 5, 6):
                spawn_points.append({'x': px, 'y': py, 'type': v})
    
    print(f'  Non-zero path tiles: {len(path_tiles)}')
    print(f'  Unique path values: {sorted(set(path_layer))}')
    print(f'  Spawn points: {spawn_points[:10]}')
    
    # Save as JSON
    output = {
        'level': lvl,
        'width': w,
        'height': h,
        'pathLayer': path_layer,
        'flipLayer': flip_layer,
        'spawnPoints': spawn_points,
    }
    
    out_path = os.path.join(BASE, 'game', 'public', 'maps', f'spawns{lvl}.json')
    with open(out_path, 'w') as f:
        json.dump(output, f)
    print(f'  Saved to {out_path}')

# Also fix level0-8.json: rename pathLayer to flipLayer and add pathLayer from mapsp
print('\n--- Fixing level JSON files ---')
for lvl in range(0, 9):
    json_path = os.path.join(BASE, 'game', 'public', 'maps', f'level{lvl}.json')
    with open(json_path) as f:
        j = json.load(f)
    
    # The current 'pathLayer' is actually C1161 (flip modes)
    flip_layer = j.get('pathLayer', [])
    
    # The current 'tileLayer' is B1160 (tile indices) - correct
    tile_layer = j.get('tileLayer', [])
    
    # Rename pathLayer -> flipLayer, and create empty pathLayer
    j['flipLayer'] = flip_layer
    j['pathLayer'] = [0] * len(tile_layer)  # Will be filled from mapsp data
    
    # If mapsp data exists for this level, merge path data
    if lvl >= 1:
        mapsp_path = os.path.join(BASE, 'game', 'public', 'maps', f'spawns{lvl}.json')
        if os.path.exists(mapsp_path):
            with open(mapsp_path) as f:
                ms = json.load(f)
            # The mapsp path layer has the same dimensions as the map
            if ms['width'] == j['width'] and ms['height'] == j['height']:
                j['pathLayer'] = ms['pathLayer']
                j['pathFlipLayer'] = ms['flipLayer']
                j['spawnPoints'] = ms['spawnPoints']
                sp_count = len(ms['spawnPoints'])
                print(f'level{lvl}: merged mapsp data ({sp_count} spawn points)')
            else:
                print(f'level{lvl}: dimension mismatch, skipping mapsp merge')
    
    # Remove terrainLayer (not used)
    if 'terrainLayer' in j:
        del j['terrainLayer']
    
    with open(json_path, 'w') as f:
        json.dump(j, f)
    pl_count = len(j["pathLayer"])
    print(f'level{lvl}: fixed (tileLayer={len(tile_layer)}, flipLayer={len(flip_layer)}, pathLayer={pl_count})')

# Print initial building box positions and spawn points from original code
print('\n--- Original c1070 (building box positions) ---')
c1070 = [
    (336, 64),   # level 0
    (64, 528),   # level 1
    (160, 176),  # level 2
    (560, 432),  # level 3
    (592, 352),  # level 4
    (256, 320),  # level 5
    (320, 336),  # level 6
    (96, 640),   # level 7
    (96, 32),    # level 8
]
for i, (x, y) in enumerate(c1070):
    print(f'  Level {i}: box=({x},{y}) tile=({x//16},{y//16})')

print('\n--- Original b1069 (spawn positions?) ---')
b1069 = [
    (136, 88),   # level 0
    (56, 56),    # level 1
    (408, 104),  # level 2
    (568, 56),   # level 3
    (56, 56),    # level 4
    (88, 88),    # level 5
    (56, 72),    # level 6
    (72, 72),    # level 7
    (456, 56),   # level 8
]
for i, (x, y) in enumerate(b1069):
    print(f'  Level {i}: pos=({x},{y}) tile=({x//16},{y//16})')
