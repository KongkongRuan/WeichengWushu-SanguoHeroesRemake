declare module 'virtual:level-maps' {
  const levelMaps: Record<number, import('./core/MapData').LevelMapData>;
  export default levelMaps;
}
