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
  private initPromise: Promise<void> | null = null;

  private ensureAudioContext(): AudioContext {
    if (!this.audioContext) {
      this.audioContext = new (window.AudioContext || (window as any).webkitAudioContext)();
    }
    return this.audioContext;
  }

  /**
   * 初始化音频系统
   */
  async init(): Promise<void> {
    if (this.initialized) return;
    if (this.initPromise) return this.initPromise;

    // AudioContext 可以在非手势阶段创建，但不能在这里 await resume()：浏览器会让
    // promise 一直等待首次用户手势，后续 MIDI/SoundFont 初始化也就永远到不了。
    this.ensureAudioContext();
    this.initPromise = (async () => {
      try {
        const { default: MidiPlayer } = await import('midi-player-js');
        this.midiPlayer = new MidiPlayer.Player();
        this.midiPlayer.on('midiEvent', (event: any) => this.handleMidiEvent(event));
        this.initialized = true;
        console.log('AudioSystem initialized');

        // SoundFont 来自远端采样，后台加载；加载前和加载失败时用 WebAudio 合成兜底，
        // 不让“开启声音”变成只运行 MIDI 计时器却没有任何可听输出。
        void this.loadSoundfont();
      } catch (e) {
        console.error('Failed to initialize AudioSystem:', e);
        this.initialized = false;
      } finally {
        this.initPromise = null;
      }
    })();
    return this.initPromise;
  }

  private async loadSoundfont(): Promise<void> {
    try {
      const { default: Soundfont } = await import('soundfont-player');
      this.soundfont = await Soundfont.instrument(this.ensureAudioContext(), 'acoustic_grand_piano');
    } catch (e) {
      console.warn('SoundFont loading failed, using WebAudio synth:', e);
      this.soundfont = null;
    }
  }

  /** 必须由点击/按键处理器同步调用，以解除浏览器的自动播放限制。 */
  unlock(): Promise<void> {
    const context = this.ensureAudioContext();
    return context.state === 'running' ? Promise.resolve() : context.resume();
  }

  /**
   * 处理 MIDI 事件
   */
  private handleMidiEvent(event: any): void {
    if (event.name === 'Note on' && event.velocity > 0) {
      // 播放音符 (MIDI note number to frequency)
      const noteNumber = Number(event.noteNumber);
      const velocity = Number(event.velocity) / 127;
      // 某些 MIDI 文件会发出不完整的 Note on 事件；不要把 NaN 传给
      // WebAudio，否则浏览器会抛出 "AudioBufferSourceNode ... non-finite"。
      if (!Number.isFinite(noteNumber) || !Number.isFinite(velocity) || this.volume <= 0) return;
      const context = this.ensureAudioContext();
      try {
        if (this.soundfont) {
          this.soundfont.play(noteNumber, context.currentTime, {
            duration: 0.5,
            gain: Math.max(0, Math.min(1, velocity * this.volume)),
          });
        } else if (context.state === 'running') {
          const oscillator = context.createOscillator();
          const gain = context.createGain();
          oscillator.type = 'triangle';
          oscillator.frequency.value = 440 * Math.pow(2, (noteNumber - 69) / 12);
          gain.gain.setValueAtTime(Math.max(0.001, velocity * this.volume * 0.08), context.currentTime);
          gain.gain.exponentialRampToValueAtTime(0.001, context.currentTime + 0.35);
          oscillator.connect(gain);
          gain.connect(context.destination);
          oscillator.start();
          oscillator.stop(context.currentTime + 0.36);
        }
      } catch {
        // 音频只是可选增强，单个坏事件不应中断游戏循环。
      }
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
      await this.unlock();
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
    void this.unlock().then(() => {
      if (this.midiPlayer) {
        try {
          this.midiPlayer.play();
        } catch (e) {
          // 忽略
        }
      }
      this.isPlaying = true;
    }).catch(() => {});
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
