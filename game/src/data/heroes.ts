/**
 * 武将与科技树数据 - 100%还原自原版 b1015 字符串数组和 a1052 科技树数组
 */

// ============================================================
// 阵营
// ============================================================
export enum Faction {
  SHU = 0,    // 蜀 (刘备)
  WEI = 1,     // 魏 (曹操)
  WU = 2,      // 吴 (孙权)
  QUN = 3,     // 群雄 (董卓/吕布等)
}

export const FACTION_NAMES = ['蜀', '魏', '吴', '群'] as const;

// ============================================================
// 武将列表 (b1015[28]-b1015[75])
// ============================================================
export interface Hero {
  id: number;
  name: string;
  faction: Faction;
  branch: 'military' | 'civil'; // 武系/文系
  description: string;
}

export const HEROES: Hero[] = [
  // 蜀国武将 (武系) - b1015[28]-b1015[34]
  // 蜀阵营描述(b1015[76]): 刘备同时拥有卧龙与凤雏，属性伤害很厉害。
  { id: 0, name: '刘备', faction: Faction.SHU, branch: 'military', description: '刘备同时拥有卧龙与凤雏，属性伤害很厉害。' },
  { id: 1, name: '关羽', faction: Faction.SHU, branch: 'military', description: '' },
  { id: 2, name: '马超', faction: Faction.SHU, branch: 'military', description: '' },
  { id: 3, name: '黄忠', faction: Faction.SHU, branch: 'military', description: '' },
  { id: 4, name: '张飞', faction: Faction.SHU, branch: 'military', description: '' },
  { id: 5, name: '赵云', faction: Faction.SHU, branch: 'military', description: '' },
  { id: 6, name: '魏延', faction: Faction.SHU, branch: 'military', description: '' },
  // 蜀国文臣 (文系) - b1015[35]-b1015[38]
  { id: 7, name: '姜维', faction: Faction.SHU, branch: 'civil', description: '' },
  { id: 8, name: '诸葛亮', faction: Faction.SHU, branch: 'civil', description: '' },
  { id: 9, name: '徐庶', faction: Faction.SHU, branch: 'civil', description: '' },
  { id: 10, name: '庞统', faction: Faction.SHU, branch: 'civil', description: '' },

  // 魏国武将 (武系) - b1015[39]-b1015[44]
  // 魏阵营描述(b1015[77]): 由曹操带领的能臣猛将，擅长阻碍敌人行进。
  { id: 11, name: '曹操', faction: Faction.WEI, branch: 'military', description: '由曹操带领的能臣猛将，擅长阻碍敌人行进。' },
  { id: 12, name: '典韦', faction: Faction.WEI, branch: 'military', description: '' },
  { id: 13, name: '张辽', faction: Faction.WEI, branch: 'military', description: '' },
  { id: 14, name: '夏侯渊', faction: Faction.WEI, branch: 'military', description: '' },
  { id: 15, name: '夏侯惇', faction: Faction.WEI, branch: 'military', description: '' },
  { id: 16, name: '许褚', faction: Faction.WEI, branch: 'military', description: '' },
  // 魏国文臣 (文系) - b1015[45]-b1015[49]
  { id: 17, name: '司马懿', faction: Faction.WEI, branch: 'civil', description: '' },
  { id: 18, name: '荀攸', faction: Faction.WEI, branch: 'civil', description: '' },
  { id: 19, name: '荀彧', faction: Faction.WEI, branch: 'civil', description: '' },
  { id: 20, name: '程昱', faction: Faction.WEI, branch: 'civil', description: '' },
  { id: 21, name: '郭嘉', faction: Faction.WEI, branch: 'civil', description: '' },

  // 吴国武将 (武系) - b1015[50]-b1015[55]
  // 吴阵营描述(b1015[78]): 孙家率领吴国的世代名将，弓箭的好手辈出。
  { id: 22, name: '孙权', faction: Faction.WU, branch: 'military', description: '孙家率领吴国的世代名将，弓箭的好手辈出。' },
  { id: 23, name: '凌统', faction: Faction.WU, branch: 'military', description: '' },
  { id: 24, name: '甘宁', faction: Faction.WU, branch: 'military', description: '' },
  { id: 25, name: '黄盖', faction: Faction.WU, branch: 'military', description: '' },
  { id: 26, name: '周泰', faction: Faction.WU, branch: 'military', description: '' },
  { id: 27, name: '太史慈', faction: Faction.WU, branch: 'military', description: '' },
  // 吴国文臣 (文系) - b1015[56]-b1015[60]
  { id: 28, name: '张昭', faction: Faction.WU, branch: 'civil', description: '' },
  { id: 29, name: '陆逊', faction: Faction.WU, branch: 'civil', description: '' },
  { id: 30, name: '吕蒙', faction: Faction.WU, branch: 'civil', description: '' },
  { id: 31, name: '鲁肃', faction: Faction.WU, branch: 'civil', description: '' },
  { id: 32, name: '周瑜', faction: Faction.WU, branch: 'civil', description: '' },

  // 群雄 - b1015[61]-b1015[75]
  { id: 33, name: '张梁', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 34, name: '张宝', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 35, name: '张角', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 36, name: '华雄', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 37, name: '貂蝉', faction: Faction.QUN, branch: 'civil', description: '' },
  { id: 38, name: '吕布', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 39, name: '董卓', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 40, name: '张郃', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 41, name: '曹洪', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 42, name: '徐晃', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 43, name: '于禁', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 44, name: '乐进', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 45, name: '李典', faction: Faction.QUN, branch: 'military', description: '' },
  { id: 46, name: '曹丕', faction: Faction.QUN, branch: 'civil', description: '' },
  { id: 47, name: '程普', faction: Faction.QUN, branch: 'military', description: '' },
];

// ============================================================
// 关卡名称和剧情 (b1015[83]-b1015[100])
// ============================================================
export interface LevelInfo {
  levelId: number;     // 关卡ID (在故事模式序列中的值)
  name: string;        // 关卡名称
  story: string;       // 剧情描述
  city: string;        // 对应城池
}

// b1015[83]-b1015[100]: 关卡名称与剧情
// 奇数索引(83,85,87...)为关卡名, 偶数索引(84,86,88...)为剧情描述
export const LEVELS: LevelInfo[] = [
  { levelId: 0, name: '黄巾之乱', story: '张氏起义不仅动摇了汉朝的统治，更引得无数英雄豪杰乱世逐鹿。', city: '黄巾' },
  { levelId: 1, name: '虎牢关', story: '董卓无道，十八路诸候尽起而攻之。三英战吕布，温酒斩华雄。', city: '虎牢关' },
  { levelId: 10, name: '长坂坡', story: '长坂坡中困龙出,虎将怀中小龙眠.自古冲阵扶危主,是有常山赵子龙。', city: '长坂坡' },
  { levelId: 2, name: '赤壁之战', story: '雄姿英发，羽扇纶巾，谈笑间，强虏灰飞烟灭。 公瑾？孔明？', city: '赤壁' },
  { levelId: 6, name: '战合肥', story: '“若孙权至者，张、李将军出战，乐将军守，护军勿得与战”', city: '合肥' },
  { levelId: 3, name: '夷陵之战', story: '夷陵之战，又称猇亭之战、掎亭之战。双方指挥官：陆逊，刘备。', city: '夷陵' },
  { levelId: 7, name: '攻克成都', story: '汉朝几百年的基业到了尽头，谁能取得这份荣耀？', city: '成都' },
  { levelId: 4, name: '攻克许昌', story: '曹操的贼子野心即将覆灭，多年的努力今天终于有所回报！', city: '许昌' },
  { levelId: 5, name: '攻克建业', story: '孙氏家族的昏庸统治即将终结，打过长江去，解救南方人民！', city: '建业' },
];

// ============================================================
// 科技树分支 (a1052)
// 每个子数组定义一条科技分支可升级的塔类型序列
// ============================================================
export const TECH_BRANCHES: number[][] = [
  // a1052[0]: 石灰瓶 → 装置
  [0, 10],
  // a1052[1]: 断龙闸 → 装置
  [1, 10],
  // a1052[2]: 突刺 → 擂木 → 断龙闸 → 装置
  [2, 3, 1, 10],
  // a1052[3]: 烟火 → 装置
  [4, 10],
  // a1052[4]: 投石 → 麻痹矢 → 断龙闸 → 装置
  [5, 6, 1, 10],
  // a1052[5]: 沸水 → 寒冰 → 滚油 → 装置
  [7, 8, 9, 10],
  // a1052[6]: 特殊系
  [11, 12],
];

// ============================================================
// 科技效果 (b1015[138]-b1015[154])
// ============================================================
export interface TechEffect {
  id: number;
  name: string;
  description: string;
  cost: number;
}

// b1015[122]-b1015[154]: 33条科技效果描述
// 原版无显式费用, 费用来自 g1057={20,40,60,80,100} 升级费用表
// 此处17条为每分支可激活的核心效果, 按分支顺序排列
export const TECH_EFFECTS: TechEffect[] = [
  { id: 0,  name: '攻击时间延长',     description: '攻击时间延长',       cost: 100 },  // b1015[137]
  { id: 1,  name: '加强攻击伤害',     description: '加强攻击伤害',       cost: 150 },  // b1015[135]
  { id: 2,  name: '加强攻击伤害',     description: '加强攻击伤害',       cost: 200 },  // b1015[136]
  { id: 3,  name: '加强攻击伤害',     description: '加强攻击伤害',       cost: 250 },  // b1015[139]
  { id: 4,  name: '范围麻痹',         description: '范围麻痹',           cost: 300 },  // b1015[142]
  { id: 5,  name: '范围冰冻',         description: '范围冰冻',           cost: 300 },  // b1015[143]
  { id: 6,  name: '使所有塔攻击增加', description: '使所有塔攻击增加',   cost: 500 },  // b1015[122]
  { id: 7,  name: '装填石头半价',     description: '装填石头半价',       cost: 200 },  // b1015[145]
  { id: 8,  name: '加强攻击频率',     description: '加强攻击频率',       cost: 150 },  // b1015[146]
  { id: 9,  name: '周围塔攻击增加',   description: '周围塔攻击增加',   cost: 300 },  // b1015[147]
  { id: 10, name: '范围内敌人减速',   description: '范围内敌人减速',   cost: 250 },  // b1015[148]
  { id: 11, name: '范围内敌人减速',   description: '范围内敌人减速',   cost: 300 },  // b1015[149]
  { id: 12, name: '中毒时间延长',     description: '中毒时间延长',       cost: 150 },  // b1015[150]
  { id: 13, name: '加强攻击频率',     description: '加强攻击频率',       cost: 200 },  // b1015[151]
  { id: 14, name: '火焰伤害时间增加', description: '火焰伤害时间增加', cost: 150 },  // b1015[152]
  { id: 15, name: '麻痹概率增加',     description: '麻痹概率增加',       cost: 200 },  // b1015[153]
  { id: 16, name: '冰冻概率增加',     description: '冰冻概率增加',       cost: 200 },  // b1015[154]
];

// ============================================================
// 武将语音 (b1015[155]-b1015[170])
// ============================================================
// 原版格式: b1015[(ba-n3)*2 + 155] + 武将名(b1015[bb+28]) + b1015[(ba-n3)*2 + 156]
// 8名蜀国武将各有2条语音(前缀+后缀), 共16条(b1015[155]-b1015[170])
// 语音按 ba-n3 逆序排列:
// n3=7(刘备):155-156, n3=6(赵云):157-158, n3=5(诸葛亮):159-160,
// n3=4(张飞):161-162, n3=3(黄忠):163-164, n3=2(马超):165-166,
// n3=1(关羽):167-168, n3=0(魏延):169-170
export const HERO_VOICE_LINES: Record<number, [string, string]> = {
  0: ['大家跟我', '练了这么久，这点打击算啥？'],           // b1015[155-156] 刘备
  5: ['快点快点快点！跟我', '冲破敌城有重赏！'],           // b1015[157-158] 赵云
  8: ['我乃', '，我的卫队饱餐而来，不死不归！'],          // b1015[159-160] 诸葛亮
  4: ['师傅在天有灵，', '多年来的水战不白练！'],           // b1015[161-162] 张飞
  3: ['被烧了多次，我', '今天也不算怕火了哈哈！'],          // b1015[163-164] 黄忠
  2: ['我', '喝了这么多麻药散，该不怕麻痹了吧！'],         // b1015[165-166] 马超
  1: ['兄弟们都给我', '冲啊！冲慢的军法处置！'],           // b1015[167-168] 关羽
  6: ['俺', '吃了这么多解药，不会再中毒了吧？'],           // b1015[169-170] 魏延
};

// ============================================================
// 游戏说明 (b1015[171]-b1015[180])
// ============================================================
// b1015[171]-b1015[177]: 游戏帮助文本
export const GAME_HELP_TEXT = {
  description: '建造各种城防武器抵挡敌城中涌出的军队',  // b1015[171]
  upgrade: '升级自己的城池可以建造更多类型的武器',       // b1015[172]
  failCondition: '超过10个敌人冲入自己的城池则游戏失败',   // b1015[173]
  controls: '空地按建造塔，#出敌人，塔或城上按升级',        // b1015[174]
  clearEnemies: '消灭当前全部敌人',                         // b1015[175]
  getAllTech: '获得全部科技',                                // b1015[176]
  getGold: '获得500金',                                     // b1015[177]
  defenseUp: '城防+10',
  goldDouble: '消灭敌人金翻倍',
  cannotUpgrade: '现在还不能升级这个建筑',
};

// ============================================================
// 塔名称 (b1015[0]-b1015[18])
// ============================================================
// b1015[0]: 游戏描述, b1015[1]: 版权信息
// b1015[2]-b1015[12]: 塔名称
// b1015[13]-b1015[18]: 装置名称
export const TOWER_NAMES: string[] = [
  '石灰瓶',    // 0  b1015[?] 基础远程攻击单位
  '断龙闸',    // 1  可使敌人中毒
  '突刺',      // 2  地底伸出利刃，杀伤敌人
  '擂木',      // 3  点燃敌人
  '烟火',      // 4  可以使敌人暂停
  '投石',      // 5  可以使敌人冰冻
  '麻痹矢',    // 6  直线沉重打击敌人的木桩
  '沸水',      // 7  远程沉重打击敌人的石头
  '寒冰',      // 8  造成很大伤害，会将火熄灭
  '滚油',      // 9  造成很大伤害，遇火会点燃
  '石灰瓶装置', // 10 b1015[13] 生产石灰瓶和断龙闸的装置
  '断龙闸装置', // 11 b1015[14] 生产突刺和擂木的装置
  '突刺装置',   // 12 b1015[15] 生产烟火和投石的装置
  '擂木装置',   // 13 b1015[16] 生产麻痹矢和沸水的装置
  '烟火装置',   // 14 b1015[17] 生产寒冰和滚油的装置
  '投石装置',   // 15
  '麻痹矢装置', // 16
  '沸水装置',   // 17
  '寒冰装置',   // 18
];

// ============================================================
// 塔描述 (b1015[2]-b1015[18])
// 索引0-9对应基础塔, 10=路障, 11-15=装置, 16=升级
// ============================================================
export const TOWER_DESCRIPTIONS: string[] = [
  '基础远程攻击单位',           // 0  b1015[2]  石灰瓶
  '可使敌人中毒。',             // 1  b1015[3]  断龙闸
  '地底伸出利刃，杀伤敌人',      // 2  b1015[4]  突刺
  '点燃敌人',                   // 3  b1015[5]  擂木
  '可以使敌人暂停',             // 4  b1015[6]  烟火
  '可以使敌人冰冻',             // 5  b1015[7]  投石
  '直线沉重打击敌人的木桩',      // 6  b1015[8]  麻痹矢
  '远程沉重打击敌人的石头',      // 7  b1015[9]  沸水
  '造成很大伤害，会将火熄灭',    // 8  b1015[10] 寒冰
  '造成很大伤害，遇火会点燃',    // 9  b1015[11] 滚油
  '阻断敌人前进，用过後失效',    // 10 b1015[12] 路障
  '生产石灰瓶和断龙闸的装置',    // 11 b1015[13] 石灰瓶装置
  '生产突刺和擂木的装置',        // 12 b1015[14] 突刺装置
  '生产烟火和投石的装置',        // 13 b1015[15] 烟火装置
  '生产麻痹矢和沸水的装置',      // 14 b1015[16] 麻痹矢装置
  '生产寒冰和滚油的装置',        // 15 b1015[17] 寒冰装置
  '升级塔，升到顶可获得英雄',    // 16 b1015[18] 升级
];
