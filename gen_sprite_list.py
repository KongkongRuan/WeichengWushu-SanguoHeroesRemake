#!/usr/bin/env python3
"""Generate sprite file list JSON for the H5 game."""
import os, json

d = r'd:\project\危城无双之三国群英\game\public\sprites'
files = sorted([f for f in os.listdir(d) if f.endswith('.png')])

# Parse each file name
sprites = []
for f in files:
    parts = f.rsplit('_', 1)  # split at last underscore
    if len(parts) >= 2:
        prefix = parts[0]  # e.g. "sp_0"
        dims = parts[1].replace('.png', '')  # e.g. "18x18"
        prefix_parts = prefix.split('_')
        sp_prefix = prefix_parts[0]
        sp_index = int(prefix_parts[1]) if len(prefix_parts) > 1 and prefix_parts[1].isdigit() else 0
        dim_parts = dims.split('x')
        w = int(dim_parts[0]) if dim_parts[0].isdigit() else 0
        h = int(dim_parts[1]) if len(dim_parts) > 1 and dim_parts[1].isdigit() else 0
        sprites.append({'name': f, 'prefix': sp_prefix, 'index': sp_index, 'width': w, 'height': h})

# Save to public directory
output = os.path.join(d, 'sprite_list.json')
with open(output, 'w', encoding='utf-8') as f:
    json.dump(sprites, f, indent=2)

print(f"Generated sprite_list.json with {len(sprites)} sprites")
# Print summary by prefix
from collections import Counter
prefixes = Counter(s['prefix'] for s in sprites)
for p, c in sorted(prefixes.items()):
    print(f"  {p}: {c} sprites")
