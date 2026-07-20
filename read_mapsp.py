import os

BASE = r'd:\Development\ts\WeichengWushu-SanguoHeroesRemake'

# Read mapdatalv0 in detail
path = os.path.join(BASE, 'a_java_analysis', 'bytecode', 'j2me_extracted', 'mapdatalv0')
data = open(path, 'rb').read()

w = data[0] | (data[1] << 8)  # 30
h = data[2] | (data[3] << 8)  # 34
tile_count = w * h  # 1020

print(f'mapdatalv0: w={w} h={h} tiles={tile_count} total={len(data)}')
print(f'Layers: {(len(data)-4) // tile_count} layers of {tile_count} bytes')

# Extract each layer
for layer_idx in range(4):
    start = 4 + layer_idx * tile_count
    end = start + tile_count
    layer = list(data[start:end])
    unique = sorted(set(layer))
    print(f'\nLayer {layer_idx} (offset {start}-{end}):')
    print(f'  Unique values: {unique}')
    print(f'  First 30: {layer[:30]}')

# Compare with JSON
import json
json_path = os.path.join(BASE, 'game', 'public', 'maps', 'level0.json')
with open(json_path) as f:
    j = json.load(f)

print(f'\nJSON tileLayer first 30: {j["tileLayer"][:30]}')
print(f'JSON pathLayer first 30: {j["pathLayer"][:30]}')
print(f'JSON terrainLayer first 30: {j["terrainLayer"][:30]}')

# Check which binary layer matches which JSON layer
for layer_idx in range(4):
    start = 4 + layer_idx * tile_count
    layer = list(data[start:start+tile_count])
    if layer == j['tileLayer']:
        print(f'Binary layer {layer_idx} = JSON tileLayer')
    if layer == j['pathLayer']:
        print(f'Binary layer {layer_idx} = JSON pathLayer')
    if layer == j['terrainLayer']:
        print(f'Binary layer {layer_idx} = JSON terrainLayer')
