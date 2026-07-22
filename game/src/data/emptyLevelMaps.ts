import type { LevelMapData } from '../core/MapData';

// Node 单测不会调用 MapData.loadLevel；该空实现只供 esbuild 测试入口解析虚拟模块。
const emptyLevelMaps: Record<number, LevelMapData> = {};
export default emptyLevelMaps;
