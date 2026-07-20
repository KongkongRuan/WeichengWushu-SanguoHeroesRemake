/**
 * MIDI音乐播放系统
 * 使用 midi-player-js + soundfont-player 在浏览器中播放原版.mid文件
 */
export class AudioSystem {
  private midiPlayer: any = null;
  private soundfont: any = null;
  private audioContext: AudioContext | null = null;
  private currentTrack: string | null = null;
  private isPlaying: boolean = false;
  private volume: number = 0.5;
  private initialized: boolean = false;

  /**
   * 初始化音频系统
   */
  async init(): Promise<void> {
    if (this.initialized) return;

    try {
      // 动态导入 MIDI 播放库
      const { default: MidiPlayer } = await import('midi-player-js');
      this.midiPlayer = new MidiPlayer.Player();

      // 创建 AudioContext
      this.audioContext = new (window.AudioContext || (window as any).webkitAudioContext)();
      await this.audioContext.resume();

      // 加载 SoundFont
      try {
        const { default: Soundfont } = await import('soundfont-player');
        this.soundfont = await Soundfont.instrument(this.audioContext, 'acoustic_grand_piano');
      } catch (e) {
        console.warn('SoundFont loading failed, using fallback:', e);
        this.soundfont = null;
      }

      // 设置 MIDI 事件回调
      if (this.midiPlayer && this.soundfont) {
        this.midiPlayer.on('midiEvent', (event: any) => {
          this.handleMidiEvent(event);
        });
      }

      this.initialized = true;
      console.log('AudioSystem initialized');
    } catch (e) {
      console.error('Failed to initialize AudioSystem:', e);
      this.initialized = false;
    }
  }

  /**
   * 处理 MIDI 事件
   */
  private handleMidiEvent(event: any): void {
    if (!this.soundfont) return;

    if (event.name === 'Note on' && event.velocity > 0) {
      // 播放音符 (MIDI note number to frequency)
      const noteNumber = event.noteNumber;
      const velocity = event.velocity / 127;
      this.soundfont.play(noteNumber, this.audioContext, {
        duration: 0.5,
        gain: velocity * this.volume,
      });
    }
  }

  /**
   * 加载并播放 MIDI 文件
   */
  async playMidi(filePath: string): Promise<void> {
    if (!this.initialized) {
      await this.init();
    }

    if (!this.midiPlayer) {
      console.warn('MIDI player not available');
      return;
    }

    try {
      // 停止当前播放
      this.stop();

      // 加载 MIDI 文件
      const response = await fetch(filePath);
      const arrayBuffer = await response.arrayBuffer();
      this.midiPlayer.loadDataUri(this.arrayBufferToDataUri(arrayBuffer));

      // 开始播放
      this.midiPlayer.play();
      this.currentTrack = filePath;
      this.isPlaying = true;
      console.log(`Playing MIDI: ${filePath}`);
    } catch (e) {
      console.warn(`Failed to play MIDI ${filePath}:`, e);
      // MIDI 播放失败时静默处理, 不播放噪音
      // 原来的 playFallbackMusic() 会创建永不停止的 440Hz 振荡器造成噪音
    }
  }

  /**
   * 备用背景音乐 (当 MIDI 播放失败时)
   * 已禁用: 原实现创建永不停止的振荡器会造成持续噪音
   */
  // private playFallbackMusic(): void { ... }

  /**
   * 停止播放
   */
  stop(): void {
    if (this.midiPlayer) {
      try {
        this.midiPlayer.stop();
      } catch (e) {
        // 忽略
      }
    }
    this.isPlaying = false;
    this.currentTrack = null;
  }

  /**
   * 暂停
   */
  pause(): void {
    if (this.midiPlayer) {
      try {
        this.midiPlayer.pause();
      } catch (e) {
        // 忽略
      }
    }
    this.isPlaying = false;
  }

  /**
   * 恢复
   */
  resume(): void {
    if (this.midiPlayer) {
      try {
        this.midiPlayer.play();
      } catch (e) {
        // 忽略
      }
    }
    this.isPlaying = true;
  }

  /**
   * 设置音量
   */
  setVolume(vol: number): void {
    this.volume = Math.max(0, Math.min(1, vol));
  }

  get isAudioPlaying(): boolean {
    return this.isPlaying;
  }

  get currentMusic(): string | null {
    return this.currentTrack;
  }

  /**
   * ArrayBuffer 转 Data URI
   */
  private arrayBufferToDataUri(buffer: ArrayBuffer): string {
    const bytes = new Uint8Array(buffer);
    let binary = '';
    for (let i = 0; i < bytes.length; i++) {
      binary += String.fromCharCode(bytes[i]);
    }
    return `data:audio/midi;base64,${btoa(binary)}`;
  }
}
