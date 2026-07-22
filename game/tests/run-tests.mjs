import { readdirSync, rmSync } from 'node:fs';
import { join, resolve } from 'node:path';
import { spawnSync } from 'node:child_process';
import { build } from 'esbuild';

const root = resolve(import.meta.dirname, '..');
const outdir = join(root, '.test-dist');
rmSync(outdir, { recursive: true, force: true });
const entryPoints = readdirSync(join(root, 'tests'))
  .filter(name => name.endsWith('.test.ts'))
  .map(name => join(root, 'tests', name));

await build({
  entryPoints,
  outdir,
  bundle: true,
  platform: 'node',
  format: 'cjs',
  outExtension: { '.js': '.cjs' },
  alias: { 'virtual:level-maps': join(root, 'src', 'data', 'emptyLevelMaps.ts') },
});

const outputFiles = readdirSync(outdir)
  .filter(name => name.endsWith('.test.cjs'))
  .map(name => join(outdir, name));
const result = spawnSync(process.execPath, ['--test', ...outputFiles], { stdio: 'inherit' });
process.exit(result.status ?? 1);
