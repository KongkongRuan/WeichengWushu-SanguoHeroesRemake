#!/usr/bin/env python3
"""
Merge mapdata0-8 (tile attribute layer, original E1163) into level JSONs.

mapdata format: 1-byte width, 1-byte height, then w*h bytes.
Values: 0/2/4/6 = path (direction = v>>1, 0=up 1=right 2=down 3=left),
        8 = buildable, 9 = obstacle, 10 = enemy castle, 11 = our castle,
        >=12 = tower-occupied (runtime only, not in files).
"""
import os
import json

SRC_DIR = 'extracted_game_files'
MAPS_DIR = 'game/public/maps'


def parse_mapdata(path):
    data = open(path, 'rb').read()
    w, h = data[0], data[1]
    tiles = list(data[2:2 + w * h])
    assert len(tiles) == w * h, f'{path}: size mismatch'
    return w, h, tiles


def main():
    for level in range(9):
        src = os.path.join(SRC_DIR, f'mapdata{level}')
        dst = os.path.join(MAPS_DIR, f'level{level}.json')
        w, h, tiles = parse_mapdata(src)
        with open(dst, 'r', encoding='utf-8') as f:
            level_json = json.load(f)
        assert level_json['width'] == w and level_json['height'] == h, \
            f'level{level}: json {level_json["width"]}x{level_json["height"]} != mapdata {w}x{h}'
        level_json['terrainLayer'] = tiles
        with open(dst, 'w', encoding='utf-8') as f:
            json.dump(level_json, f, separators=(',', ':'))
        counts = {}
        for v in tiles:
            counts[v] = counts.get(v, 0) + 1
        print(f'level{level}: {w}x{h} terrainLayer added, values={dict(sorted(counts.items()))}')


if __name__ == '__main__':
    main()
