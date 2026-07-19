import os
import zipfile
import re

apk_path = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'weichengwushuang_itmop.com.apk')
out_file = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'strings_output.txt')

with zipfile.ZipFile(apk_path, 'r') as zf:
    dex_data = zf.read('classes.dex')

with open(out_file, 'w', encoding='utf-8') as out:
    strings = re.findall(b'[\x20-\x7e]{6,}', dex_data)
    j2me_keywords = [b'CMidlet', b'MIDlet', b'javax.microedition', b'lcdui', b'game',
                     b'Sprite', b'TiledLayer', b'LayerManager', b'Canvas', b'Graphics',
                     b'wcwszsgqypjb', b'netmite', b'andme', b'launcher']

    found = set()
    for s in strings:
        for kw in j2me_keywords:
            if kw.lower() in s.lower():
                found.add(s.decode('ascii', errors='replace'))

    out.write('=== J2ME/Netmite-related strings found in classes.dex ===\n')
    for s in sorted(found):
        out.write(f'  {s}\n')

    class_names = re.findall(b'L[a-zA-Z0-9_/$]+;', dex_data)
    unique_classes = sorted(set(c.decode() for c in class_names))
    out.write(f'\n=== Class references in classes.dex ({len(unique_classes)} unique) ===\n')
    for c in unique_classes:
        out.write(f'  {c}\n')

print(f'Output written to {out_file}')
