#!/usr/bin/env python3
import os
d = r'd:\project\危城无双之三国群英\extracted_game_files\extracted_pngs'
files = sorted(os.listdir(d))
prefixes = set()
for f in files:
    parts = f.split('_')
    if len(parts) > 0:
        prefixes.add(parts[0])

print(f'Total files: {len(files)}')
print(f'Prefixes: {sorted(prefixes)}')
for p in sorted(prefixes):
    count = len([f for f in files if f.startswith(p + '_')])
    examples = [f for f in files if f.startswith(p + '_')][:5]
    print(f'  {p}: {count} files, examples: {examples}')
