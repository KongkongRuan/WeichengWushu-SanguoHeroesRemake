import { readFileSync } from 'node:fs';
import { defineConfig, type Plugin } from 'vite';
import path from 'path';

/**
 * 地图 JSON 过去在开战时通过 fetch 加载。在子目录部署、离线壳或 file 环境中，
 * 图片可能正常而 JSON 请求失败，随后游戏会误用全灰兜底地图。
 * 这里把 9 份原始地图数据编进 JS，地图渲染不再依赖运行时 URL。
 */
function embeddedLevelMaps(): Plugin {
  const publicId = 'virtual:level-maps';
  const resolvedId = '\0virtual:level-maps';
  return {
    name: 'embedded-level-maps',
    resolveId(id) {
      return id === publicId ? resolvedId : null;
    },
    load(id) {
      if (id !== resolvedId) return null;
      const maps: Record<number, unknown> = {};
      for (let level = 0; level <= 8; level++) {
        const filename = path.resolve(__dirname, `public/maps/level${level}.json`);
        this.addWatchFile(filename);
        maps[level] = JSON.parse(readFileSync(filename, 'utf8'));
      }
      return `export default ${JSON.stringify(maps)};`;
    },
  };
}

function previewMetadata(): Plugin {
  const preview = process.env.VITE_DEPLOY_CHANNEL === 'preview-build-input-viewport';
  return {
    name: 'preview-metadata',
    transformIndexHtml() {
      if (!preview) return [];
      return [
        {
          tag: 'meta',
          attrs: { name: 'robots', content: 'noindex, nofollow' },
          injectTo: 'head',
        },
        {
          tag: 'div',
          attrs: { id: 'preview-channel', role: 'status' },
          children: '建造、输入与宽屏优化预览版',
          injectTo: 'body-prepend',
        },
      ];
    },
  };
}

export default defineConfig({
  plugins: [embeddedLevelMaps(), previewMetadata()],
  define: {
    __DEPLOY_CHANNEL__: JSON.stringify(process.env.VITE_DEPLOY_CHANNEL ?? 'production'),
  },
  resolve: {
    alias: {
      '@': path.resolve(__dirname, './src'),
    },
  },
  server: {
    port: 3000,
    open: true,
  },
  build: {
    target: 'es2020',
    outDir: 'dist',
    assetsInlineLimit: 0,
  },
  base: './',
});
