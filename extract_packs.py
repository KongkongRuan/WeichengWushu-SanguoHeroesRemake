#!/usr/bin/env python3
"""
Extract J2ME resource packs (2-byte LE length + PNG concatenated format)
into individual PNG files for the H5 game.

Packs already in H5 (e0, t0, sp, bu, ui, back, map0-6) are skipped.
"""
import os
import json
import struct

SRC_DIR = 'extracted_game_files'
OUT_DIR = 'game/public/sprites'
LIST_FILE = os.path.join(OUT_DIR, 'sprite_list.json')

# pack name -> expected image count (from vineflower a.java constructor, per-pack counts)
PACKS = {
    'mu': 12, 'sflogo': 8, 'ld': 2, 's': 1,
    'e1': 2, 'e2': 2, 'e3': 2, 'e4': 2, 'e5': 2,
    'h': 10, 'eff': 7, 'end': 6,
    't1': 1, 't2': 1, 't3': 1, 't4': 1, 't5': 1,
    't6': 1, 't7': 1, 't8': 1, 't9': 1, 't10': 1,
    'sp0': 1, 'sp1': 1, 'sp2': 1, 'sp3': 1,
}

PNG_SIG = b'\x89PNG\r\n\x1a\n'


def extract_pack(name, expected):
    path = os.path.join(SRC_DIR, name)
    if not os.path.exists(path):
        print(f'  SKIP {name}: file not found')
        return []
    data = open(path, 'rb').read()
    out = []
    off = 0
    i = 0
    while off + 2 <= len(data):
        ln = data[off] | (data[off + 1] << 8)
        png = data[off + 2: off + 2 + ln]
        if len(png) != ln or not png.startswith(PNG_SIG):
            print(f'  WARN {name}[{i}]: bad entry at off={off} len={ln}')
            break
        w, h = struct.unpack('>II', png[16:24])
        fname = f'{name}_{i}_{w}x{h}.png'
        with open(os.path.join(OUT_DIR, fname), 'wb') as f:
            f.write(png)
        out.append({'name': fname, 'prefix': name, 'index': i, 'width': w, 'height': h})
        off += 2 + ln
        i += 1
    status = 'OK' if i == expected and off == len(data) else f'COUNT MISMATCH (got {i}, expect {expected}, leftover {len(data) - off})'
    print(f'  {name}: {i} images, {status}')
    return out


def main():
    os.makedirs(OUT_DIR, exist_ok=True)
    new_entries = []
    for name, expected in PACKS.items():
        new_entries.extend(extract_pack(name, expected))

    with open(LIST_FILE, 'r', encoding='utf-8') as f:
        entries = json.load(f)
    existing = {e['name'] for e in entries}
    added = 0
    for e in new_entries:
        if e['name'] not in existing:
            entries.append(e)
            added += 1
    with open(LIST_FILE, 'w', encoding='utf-8') as f:
        json.dump(entries, f, ensure_ascii=False, indent=2)
    print(f'sprite_list.json: {len(entries)} entries total, {added} added')


if __name__ == '__main__':
    main()
