export enum GameState {
  TITLE_MENU = 1,       // 原版 l=1: 标题主菜单
  PLAYING = 2,
  PAUSED = 3,
  GAME_OVER = 4,
  VICTORY = 5,
  LEVEL_COMPLETE = 6,   // 原版 l=10 结算 (H5简化版)
  HELP = 8,             // 帮助页 (原版 a(21), 显示 b1015[0])
  LOADING_SCREEN = 10,  // ld 加载进度屏 (原版 k() 中的 e() 进度)
  TECH_TREE_BROWSE = 12,
  COUNTRY_SELECT = 15,  // 原版 l=15: 选择国家
  CAMPAIGN_SELECT = 16, // 原版 l=16: 选择战役
  UPGRADE_SELECT = 17,  // 原版 l=17: 升级模式 (武系/文系)
  SOUND_PROMPT = 18,    // 原版 l=18: 声音询问
  ENDING_ANIM = 19,     // 结局动画 (原版 state 46/47/48 的H5重制版)
  CREDITS = 20,         // 关于页 (原版 a(20), 显示 b1015[1])
  SETTINGS = 22,        // 设置页 (声音开关与音量)
  SAVE_PANEL = 27,      // 存档面板 (新流程无入口, 保留代码)
  LEVEL_INTRO = 40,     // 关卡剧情 (对应原版 state 23)
  COUNCIL = 41,         // 强化规则：波间军议三选一
}

export type NonPlayingAnimationCadence = 'original-ui' | 'cinematic';

/**
 * 非战斗页面必须在这里明确选择节拍：
 * - original-ui: 保留原版每 100ms 推进一次的逐帧位移。
 * - cinematic: H5 重制动画按固定 60FPS 推进。
 */
const NON_PLAYING_ANIMATION_CADENCE: Readonly<Partial<Record<GameState, NonPlayingAnimationCadence>>> = {
  [GameState.TITLE_MENU]: 'original-ui',
  [GameState.COUNTRY_SELECT]: 'original-ui',
  [GameState.UPGRADE_SELECT]: 'original-ui',
  [GameState.CAMPAIGN_SELECT]: 'original-ui',
  [GameState.SETTINGS]: 'original-ui',
  [GameState.COUNCIL]: 'original-ui',
  [GameState.LEVEL_COMPLETE]: 'original-ui',
  [GameState.GAME_OVER]: 'original-ui',
  [GameState.LOADING_SCREEN]: 'cinematic',
  [GameState.LEVEL_INTRO]: 'cinematic',
  [GameState.ENDING_ANIM]: 'cinematic',
};

export function animationCadenceForState(state: GameState): NonPlayingAnimationCadence | null {
  return NON_PLAYING_ANIMATION_CADENCE[state] ?? null;
}
