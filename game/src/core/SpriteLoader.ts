/**
 * 精灵图加载器 - 加载和管理所有游戏素材
 * 素材来自原版J2ME游戏的PNG文件，通过Scale2x高清化
 */

export interface SpriteInfo {
  name: string;
  prefix: string;
  index: number;
  width: number;
  height: number;
  image: HTMLImageElement;
}

export class SpriteLoader {
  private sprites: Map<string, HTMLImageElement> = new Map();
  private spriteInfos: Map<string, SpriteInfo> = new Map();
  private loaded: boolean = false;
  private loadProgress: number = 0;
  private totalSprites: number = 0;
  private loadedCount: number = 0;
  private onLoadProgress: ((progress: number) => void) | null = null;

  /**
   * 设置加载进度回调
   */
  setProgressCallback(callback: (progress: number) => void): void {
    this.onLoadProgress = callback;
  }

  /**
   * 加载所有精灵图
   */
  async loadAll(basePath: string = './sprites/'): Promise<void> {
    // 从 JSON 文件获取精灵图列表
    let spriteFiles: string[] = [];
    try {
      const response = await fetch(basePath + 'sprite_list.json');
      const spriteList = await response.json();
      spriteFiles = spriteList.map((s: any) => s.name);
    } catch (e) {
      console.warn('Failed to load sprite list, using fallback list:', e);
      spriteFiles = this.getKnownSpriteFiles();
    }

    this.totalSprites = spriteFiles.length;
    this.loadedCount = 0;

    const loadPromises: Promise<void>[] = [];

    for (const file of spriteFiles) {
      loadPromises.push(this.loadSprite(basePath + file, file));
    }

    await Promise.all(loadPromises);
    this.loaded = true;
    console.log(`SpriteLoader: loaded ${this.sprites.size}/${this.totalSprites} sprites`);
  }

  /**
   * 已知的精灵图文件列表
   */
  private getKnownSpriteFiles(): string[] {
    const files: string[] = [];

    // 瓦片图集
    files.push('t0_0_64x50.png');
    files.push('t0_1_10x3.png');
    files.push('t0_2_24x9.png');
    files.push('t0_3_40x6.png');
    files.push('t0_4_24x9.png');
    files.push('t0_5_18x9.png');

    // 敌人精灵 (sp_* 系列, 18x18)
    for (let i = 0; i <= 47; i++) {
      files.push(`sp_${i}_18x18.png`);
    }

    // 建筑精灵 (bu_* 系列)
    for (let i = 0; i <= 47; i++) {
      files.push(`bu_${i}_*.png`);
    }

    // UI元素
    for (let i = 0; i <= 29; i++) {
      files.push(`ui_${i}_*.png`);
    }

    // 背景图
    for (let i = 0; i <= 25; i++) {
      files.push(`back_${i}_*.png`);
    }

    // 敌人图集
    files.push('e0_0_117x18.png');
    files.push('e0_1_117x18.png');

    return files;
  }

  /**
   * 加载单个精灵图
   */
  private async loadSprite(src: string, name: string): Promise<void> {
    return new Promise((resolve, reject) => {
      const img = new Image();
      img.onload = () => {
        // 解析文件名获取信息
        const info = this.parseSpriteName(name, img);
        if (info) {
          this.spriteInfos.set(name, info);
        }
        this.sprites.set(name, img);
        this.loadedCount++;
        this.loadProgress = this.loadedCount / this.totalSprites;
        this.onLoadProgress?.(this.loadProgress);
        resolve();
      };
      img.onerror = () => {
        // 忽略加载失败的文件
        this.loadedCount++;
        this.loadProgress = this.loadedCount / this.totalSprites;
        this.onLoadProgress?.(this.loadProgress);
        resolve();
      };
      img.src = src;
    });
  }

  /**
   * 解析精灵图文件名
   * 格式: prefix_index_WxH.png
   */
  private parseSpriteName(name: string, img: HTMLImageElement): SpriteInfo | null {
    const match = name.match(/^(\w+)_(\d+)_(\d+)x(\d+)\.png$/);
    if (!match) return null;

    return {
      name,
      prefix: match[1],
      index: parseInt(match[2], 10),
      width: parseInt(match[3], 10),
      height: parseInt(match[4], 10),
      image: img,
    };
  }

  /**
   * 获取精灵图
   */
  get(name: string): HTMLImageElement | null {
    return this.sprites.get(name) ?? null;
  }

  /**
   * 通过前缀和索引获取精灵图
   */
  getByPrefix(prefix: string, index: number): HTMLImageElement | null {
    for (const [name, info] of this.spriteInfos) {
      if (info.prefix === prefix && info.index === index) {
        return info.image;
      }
    }
    return null;
  }

  /**
   * 获取某前缀的所有精灵图
   */
  getAllByPrefix(prefix: string): SpriteInfo[] {
    const result: SpriteInfo[] = [];
    for (const info of this.spriteInfos.values()) {
      if (info.prefix === prefix) {
        result.push(info);
      }
    }
    return result.sort((a, b) => a.index - b.index);
  }

  /**
   * 获取瓦片图集
   */
  getTileset(): HTMLImageElement | null {
    // t0_0_64x50.png 是主瓦片图集
    return this.getByPrefix('t0', 0);
  }

  /**
   * 获取敌人精灵
   */
  getEnemySprite(index: number): HTMLImageElement | null {
    // sp_* 系列包含敌人精灵
    return this.getByPrefix('sp', index);
  }

  /**
   * 获取建筑精灵
   */
  getBuildingSprite(index: number): HTMLImageElement | null {
    return this.getByPrefix('bu', index);
  }

  /**
   * 获取UI精灵
   */
  getUISprite(index: number): HTMLImageElement | null {
    return this.getByPrefix('ui', index);
  }

  /**
   * 获取背景图
   */
  getBackground(index: number): HTMLImageElement | null {
    return this.getByPrefix('back', index);
  }

  get isLoaded(): boolean {
    return this.loaded;
  }

  get progress(): number {
    return this.loadProgress;
  }
}
