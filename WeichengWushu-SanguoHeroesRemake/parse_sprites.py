"""
Parse the custom sprite container format used by the game.
Most resource files contain multiple PNG images with custom headers.
"""
import os
import struct
import io
import zipfile

base_dir = os.path.dirname(os.path.abspath(__file__))
game_dir = os.path.join(base_dir, 'extracted_game_files')

PNG_MAGIC = b'\x89PNG\r\n\x1a\n'

def find_all_pngs(data):
    """Find all PNG images embedded in binary data."""
    images = []
    pos = 0
    while True:
        idx = data.find(PNG_MAGIC, pos)
        if idx == -1:
            break
        # Parse PNG to find its end (IEND chunk)
        png_start = idx
        # Read PNG chunks to find IEND
        chunk_pos = idx + 8  # skip PNG signature
        try:
            while chunk_pos < len(data):
                length = struct.unpack('>I', data[chunk_pos:chunk_pos+4])[0]
                chunk_type = data[chunk_pos+4:chunk_pos+8]
                chunk_pos += 12 + length  # 4(length) + 4(type) + data + 4(crc)
                if chunk_type == b'IEND':
                    break
            png_end = chunk_pos
            png_data = data[png_start:png_end]
            
            # Parse dimensions
            if len(png_data) >= 24:
                width = struct.unpack('>I', png_data[16:20])[0]
                height = struct.unpack('>I', png_data[20:24])[0]
            else:
                width = height = 0
            
            # Parse header (bytes before PNG)
            if png_start >= 2:
                header = data[:png_start].hex()
            else:
                header = ''
            
            images.append({
                'offset': png_start,
                'size': len(png_data),
                'width': width,
                'height': height,
                'header': header,
                'data': png_data
            })
        except Exception as e:
            break
        pos = png_end if png_start > 0 else idx + 1
    return images

# Analyze each sprite container file
sprite_files = [
    'back', 'bu', 'eff', 'end', 'h', 'ld', 'mu', 's', 'sflogo', 'sp', 'ui',
    'e0', 'e1', 'e2', 'e3', 'e4', 'e5',
    'sp0', 'sp1', 'sp2', 'sp3',
    't0', 't1', 't2', 't3', 't4', 't5', 't6', 't7', 't8', 't9', 't10',
    'map0', 'map1', 'map2', 'map3', 'map4', 'map5', 'map6',
]

print('=== Sprite Container Analysis ===\n')
total_images = 0
all_dimensions = []

for sf in sprite_files:
    path = os.path.join(game_dir, sf)
    if not os.path.exists(path):
        continue
    
    with open(path, 'rb') as f:
        data = f.read()
    
    images = find_all_pngs(data)
    if images:
        total_images += len(images)
        dims = [(img['width'], img['height']) for img in images]
        all_dimensions.extend(dims)
        
        # Show header info for first image
        header = images[0]['header'] if images[0]['header'] else '(none)'
        
        if len(images) == 1:
            print(f'  {sf:<12} [{len(data):>5}B]  1 image  {dims[0][0]}x{dims[0][1]}  header:{header}')
        else:
            unique_dims = list(set(dims))
            print(f'  {sf:<12} [{len(data):>5}B]  {len(images)} images  dims:{unique_dims[:5]}{"..." if len(unique_dims)>5 else ""}  header:{header}')

print(f'\nTotal embedded PNG images found: {total_images}')

# Unique dimensions across all sprites
unique_dims = sorted(set(all_dimensions))
print(f'\nUnique image dimensions:')
for w, h in unique_dims:
    count = all_dimensions.count((w, h))
    print(f'  {w}x{h}: {count} images')

# Also check map data files
print('\n=== Map Data Files ===')
mapdata_files = [f for f in os.listdir(game_dir) if f.startswith('mapdata') or f.startswith('mapsp') or f.startswith('mapdatalv')]
for mf in sorted(mapdata_files):
    path = os.path.join(game_dir, mf)
    with open(path, 'rb') as f:
        data = f.read(32)
    size = os.path.getsize(path)
    print(f'  {mf:<15} [{size:>5}B]  hex:{data[:16].hex()}')

# Extract all PNG images for HD processing analysis
print('\n=== Extracting sample images for analysis ===')
extract_dir = os.path.join(game_dir, 'extracted_pngs')
os.makedirs(extract_dir, exist_ok=True)

for sf in ['back', 'bu', 'sp', 'ui', 'e0', 't0']:
    path = os.path.join(game_dir, sf)
    if not os.path.exists(path):
        continue
    with open(path, 'rb') as f:
        data = f.read()
    images = find_all_pngs(data)
    for i, img in enumerate(images):
        out_name = f'{sf}_{i}_{img["width"]}x{img["height"]}.png'
        out_path = os.path.join(extract_dir, out_name)
        with open(out_path, 'wb') as f:
            f.write(img['data'])

print(f'  Sample images extracted to: {extract_dir}')
print(f'  Total files: {len(os.listdir(extract_dir))}')
