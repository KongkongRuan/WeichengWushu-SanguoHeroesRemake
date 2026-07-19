import os
import zipfile
import struct

apk_path = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'weichengwushuang_itmop.com.apk')

with zipfile.ZipFile(apk_path, 'r') as zf:
    # Parse binary AndroidManifest.xml to extract string pool
    # Android binary XML format: header, string pool, resource IDs, XML tree
    data = zf.read('AndroidManifest.xml')
    
    print(f'AndroidManifest.xml total size: {len(data)} bytes')
    
    # Binary XML header
    # 0: magic (0x00080003)
    # 4: file_size
    magic = struct.unpack('<H', data[0:2])[0]
    header_size = struct.unpack('<H', data[2:4])[0]
    file_size = struct.unpack('<I', data[4:8])[0]
    print(f'Magic: 0x{magic:04x}, Header size: {header_size}, File size: {file_size}')
    
    # String pool chunk
    # starts at offset header_size (8)
    sp_start = 8
    sp_type = struct.unpack('<H', data[sp_start:sp_start+2])[0]
    sp_header = struct.unpack('<H', data[sp_start+2:sp_start+4])[0]
    sp_size = struct.unpack('<I', data[sp_start+4:sp_start+8])[0]
    string_count = struct.unpack('<I', data[sp_start+8:sp_start+12])[0]
    style_count = struct.unpack('<I', data[sp_start+12:sp_start+16])[0]
    flags = struct.unpack('<I', data[sp_start+16:sp_start+20])[0]
    strings_start = struct.unpack('<I', data[sp_start+20:sp_start+24])[0]
    styles_start = struct.unpack('<I', data[sp_start+24:sp_start+28])[0]
    
    print(f'\nString Pool: type=0x{sp_type:04x}, count={string_count}, strings_start={strings_start}')
    print(f'Flags: 0x{flags:08x} (UTF-8: {bool(flags & (1 << 8))})')
    
    # String offsets
    offsets = []
    for i in range(string_count):
        off = struct.unpack('<I', data[sp_start+28+i*4:sp_start+32+i*4])[0]
        offsets.append(off)
    
    # Read strings
    is_utf8 = bool(flags & (1 << 8))
    string_pool_start = sp_start + strings_start
    
    print(f'\n=== Strings in AndroidManifest.xml ({string_count} strings) ===')
    for i, off in enumerate(offsets):
        pos = string_pool_start + off
        if is_utf8:
            # UTF-8: two length bytes (chars, then bytes), then data
            # Simplified: read ULEB128-like
            if pos < len(data):
                # first byte: number of chars (1 or 2 bytes)
                # second byte: number of bytes (1 or 2 bytes)
                n1 = data[pos]
                if n1 & 0x80:
                    char_len = ((n1 & 0x7f) << 8) | data[pos+1]
                    byte_len_byte_pos = pos + 2
                else:
                    char_len = n1
                    byte_len_byte_pos = pos + 1
                
                n2 = data[byte_len_byte_pos]
                if n2 & 0x80:
                    byte_len = ((n2 & 0x7f) << 8) | data[byte_len_byte_pos+1]
                    data_start = byte_len_byte_pos + 2
                else:
                    byte_len = n2
                    data_start = byte_len_byte_pos + 1
                
                s = data[data_start:data_start+byte_len].decode('utf-8', errors='replace')
        else:
            # UTF-16
            n1 = struct.unpack('<H', data[pos:pos+2])[0]
            if n1 & 0x8000:
                char_len = ((n1 & 0x7fff) << 16) | struct.unpack('<H', data[pos+2:pos+4])[0]
                data_start = pos + 4
            else:
                char_len = n1
                data_start = pos + 2
            s = data[data_start:data_start+char_len*2].decode('utf-16-le', errors='replace')
        
        print(f'  [{i}] {s}')
    
    # Also read resources.arsc
    print('\n=== resources.arsc ===')
    arsc = zf.read('resources.arsc')
    print(f'Size: {len(arsc)} bytes')
    # Find package name in arsc - look for readable strings
    import re
    strings = re.findall(b'[\x20-\x7e]{4,}', arsc)
    print('Readable strings in resources.arsc:')
    for s in strings:
        print(f'  {s.decode("ascii", errors="replace")}')
