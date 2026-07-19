"""
Parse the constant pool of a.class to find the exact method reference
for getResourceAsStream - including the class, method name, and descriptor.
"""
import os
import struct
import zipfile

base_dir = os.path.dirname(os.path.abspath(__file__))
dex_jar = os.path.join(base_dir, 'extracted_game_files', 'game_from_dex.jar')

# Read a.class from the enjarify jar
with zipfile.ZipFile(dex_jar, 'r') as zf:
    class_data = zf.read('a.class')

# Parse Java .class file format
# https://docs.oracle.com/javase/specs/jvms/se21/html/jvms-4.html
pos = 0

# Magic number
magic = struct.unpack('>I', class_data[pos:pos+4])[0]
pos += 4
assert magic == 0xCAFEBABE, f'Not a class file: {hex(magic)}'

# Minor and major version
minor = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
major = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
print(f'Class version: {major}.{minor}')

# Constant pool
cp_count = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
print(f'Constant pool count: {cp_count}')

# Parse constant pool entries
cp = [None]  # cp[0] is unused
i = 1
while i < cp_count:
    tag = class_data[pos]; pos += 1
    
    if tag == 1:  # CONSTANT_Utf8
        length = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        value = class_data[pos:pos+length].decode('utf-8', errors='replace')
        pos += length
        cp.append(('Utf8', value))
    elif tag == 3:  # CONSTANT_Integer
        val = struct.unpack('>i', class_data[pos:pos+4])[0]; pos += 4
        cp.append(('Integer', val))
    elif tag == 4:  # CONSTANT_Float
        val = struct.unpack('>f', class_data[pos:pos+4])[0]; pos += 4
        cp.append(('Float', val))
    elif tag == 5:  # CONSTANT_Long
        val = struct.unpack('>q', class_data[pos:pos+8])[0]; pos += 8
        cp.append(('Long', val))
        cp.append(None)  # Long takes 2 slots
        i += 1
    elif tag == 6:  # CONSTANT_Double
        val = struct.unpack('>d', class_data[pos:pos+8])[0]; pos += 8
        cp.append(('Double', val))
        cp.append(None)  # Double takes 2 slots
        i += 1
    elif tag == 7:  # CONSTANT_Class
        name_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        cp.append(('Class', name_idx))
    elif tag == 8:  # CONSTANT_String
        str_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        cp.append(('String', str_idx))
    elif tag == 9:  # CONSTANT_Fieldref
        class_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        nat_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        cp.append(('Fieldref', class_idx, nat_idx))
    elif tag == 10:  # CONSTANT_Methodref
        class_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        nat_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        cp.append(('Methodref', class_idx, nat_idx))
    elif tag == 11:  # CONSTANT_InterfaceMethodref
        class_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        nat_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        cp.append(('InterfaceMethodref', class_idx, nat_idx))
    elif tag == 12:  # CONSTANT_NameAndType
        name_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        desc_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        cp.append(('NameAndType', name_idx, desc_idx))
    elif tag == 15:  # CONSTANT_MethodHandle
        kind = class_data[pos]; pos += 1
        ref_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        cp.append(('MethodHandle', kind, ref_idx))
    elif tag == 16:  # CONSTANT_MethodType
        desc_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        cp.append(('MethodType', desc_idx))
    elif tag == 17:  # CONSTANT_Dynamic
        nat_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        bsm_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        cp.append(('Dynamic', bsm_idx, nat_idx))
    elif tag == 18:  # CONSTANT_InvokeDynamic
        bsm_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        nat_idx = struct.unpack('>H', class_data[pos:pos+2])[0]; pos += 2
        cp.append(('InvokeDynamic', bsm_idx, nat_idx))
    else:
        print(f'Unknown tag {tag} at index {i}, pos {pos-1}')
        break
    
    i += 1

# Helper to resolve a constant pool entry
def resolve(idx):
    if idx < len(cp) and cp[idx] is not None:
        entry = cp[idx]
        if entry[0] == 'Utf8':
            return entry[1]
        elif entry[0] == 'Class':
            return resolve(entry[1])
        elif entry[0] == 'NameAndType':
            return (resolve(entry[1]), resolve(entry[2]))
    return f'?({idx})'

# Find all method references that include "getResourceAsStream"
print('\n=== Method references containing "getResourceAsStream" ===')
for i, entry in enumerate(cp):
    if entry is None:
        continue
    if entry[0] in ('Methodref', 'InterfaceMethodref'):
        class_name = resolve(entry[1])
        nat = resolve(entry[2])
        if isinstance(nat, tuple):
            method_name, descriptor = nat
            if 'getResource' in method_name or 'getResource' in str(descriptor):
                ref_type = 'InterfaceMethod' if entry[0] == 'InterfaceMethodref' else 'Method'
                print(f'  [{i}] {ref_type}: {class_name}.{method_name} {descriptor}')

# Also find all method references for "Display" class
print('\n=== All method references on Display class ===')
for i, entry in enumerate(cp):
    if entry is None:
        continue
    if entry[0] in ('Methodref', 'InterfaceMethodref'):
        class_name = resolve(entry[1])
        nat = resolve(entry[2])
        if isinstance(nat, tuple):
            method_name, descriptor = nat
            if 'Display' in class_name:
                ref_type = 'InterfaceMethod' if entry[0] == 'InterfaceMethodref' else 'Method'
                print(f'  [{i}] {ref_type}: {class_name}.{method_name} {descriptor}')
