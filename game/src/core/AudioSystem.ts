/**
 * MIDI 音乐播放系统。
 * midi-player-js 负责解析和计时，SoundFont 仅负责加载钢琴采样。
 */

type VoiceSource = AudioBufferSourceNode | OscillatorNode;

interface ActiveVoice {
  key: string;
  source: VoiceSource;
  gain: GainNode;
  released: boolean;
}

export class AudioSystem {
  private static readonly MASTER_OUTPUT_SCALE = 0.7;
  private static readonly NOTE_GAIN_SCALE = 0.28;
  private static readonly FALLBACK_GAIN_SCALE = 0.12;
  private static readonly SOUNDFONT_LOWEST_NOTE = 21;
  private static readonly SOUNDFONT_HIGHEST_NOTE = 108;
  private static readonly PERCUSSION_CHANNEL = 10;
  private static readonly MAX_ACTIVE_VOICES = 32;
  private static readonly MAX_FALLBACK_NOTE_SECONDS = 12;
  private static readonly NOTE_RELEASE_SECONDS = 0.12;
  private static readonly STOP_RELEASE_SECONDS = 0.025;

  private midiPlayer: any = null;
  private soundfontBuffers: Record<number, AudioBuffer> | null = null;
  private audioContext: AudioContext | null = null;
  private masterGain: GainNode | null = null;
  private compressor: DynamicsCompressorNode | null = null;
  private activeVoices = new Set<ActiveVoice>();
  private voicesByKey = new Map<string, ActiveVoice>();
  private currentTrack: string | null = null;
  private isPlaying: boolean = false;
  private volume: number = 0.5;
  private initialized: boolean = false;
  private initPromise: Promise<void> | null = null;
  private playbackGeneration: number = 0;
  private useSoundfontForPlayback: boolean = false;

  private ensureAudioContext(): AudioContext {
    if (!this.audioContext) {
      this.audioContext = new (window.AudioContext || (window as any).webkitAudioContext)();
    }
    this.ensureOutputGraph();
    return this.audioContext;
  }

  /** 所有音符统一经过主增益和压缩器，避免和弦叠加时爆音。 */
  private ensureOutputGraph(): void {
    const context = this.audioContext;
    if (!context || this.masterGain || typeof context.createGain !== 'function') return;

    const masterGain = context.createGain();
    masterGain.gain.value = this.volume * AudioSystem.MASTER_OUTPUT_SCALE;
    this.masterGain = masterGain;

    if (typeof context.createDynamicsCompressor === 'function') {
      const compressor = context.createDynamicsCompressor();
      compressor.threshold.value = -20;
      compressor.knee.value = 10;
      compressor.ratio.value = 12;
      compressor.attack.value = 0.003;
      compressor.release.value = 0.25;
      masterGain.connect(compressor);
      compressor.connect(context.destination);
      this.compressor = compressor;
    } else {
      masterGain.connect(context.destination);
    }
  }

  async init(): Promise<void> {
    if (this.initialized) return;
    if (this.initPromise) return this.initPromise;

    // 这里不能等待 resume()：浏览器可能一直等到首次用户手势才兑现 promise。
    this.ensureAudioContext();
    this.initPromise = (async () => {
      try {
        const { default: MidiPlayer } = await import('midi-player-js');
        this.midiPlayer = new MidiPlayer.Player();
        this.midiPlayer.on('midiEvent', (event: any) => this.handleMidiEvent(event));
        this.midiPlayer.on('endOfFile', () => this.handleEndOfFile());
        this.initialized = true;
        console.log('AudioSystem initialized');

        // 音色来自远程资源。加载期间使用受控振荡器，加载失败也不影响 MIDI 计时。
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
      const context = this.ensureAudioContext();
      const instrument = await Soundfont.instrument(context, 'acoustic_grand_piano', {
        destination: this.masterGain ?? context.destination,
      }) as unknown as {
        buffers?: Record<number, AudioBuffer>;
        out?: { disconnect?: () => void };
      };
      const buffers = instrument.buffers;

      // sample-player 0.5.x 会永久保留每个播放过的节点。这里只取解码后的
      // AudioBuffer，并断开其播放器输出；实际发声和回收由本类负责。
      instrument?.out?.disconnect?.();
      if (!buffers || Object.keys(buffers).length === 0) {
        throw new Error('SoundFont contains no decoded samples');
      }
      this.soundfontBuffers = buffers;
    } catch (e) {
      console.warn('SoundFont loading failed, using WebAudio synth:', e);
      this.soundfontBuffers = null;
    }
  }

  /** 必须由点击或按键处理器同步调用，以解除浏览器的自动播放限制。 */
  unlock(): Promise<void> {
    const context = this.ensureAudioContext();
    return context.state === 'running' ? Promise.resolve() : context.resume();
  }

  private handleMidiEvent(event: any): void {
    const rawNoteNumber = Number(event.noteNumber);
    if (!Number.isFinite(rawNoteNumber)) return;

    const channel = Number.isFinite(Number(event.channel)) ? Number(event.channel) : 0;
    const velocity = Number(event.velocity);
    const isNoteOn = event.name === 'Note on' && velocity > 0;
    const isNoteOff = event.name === 'Note off' || (event.name === 'Note on' && velocity <= 0);
    if (!isNoteOn && !isNoteOff) return;

    const key = this.voiceKey(channel, rawNoteNumber);
    if (isNoteOff) {
      this.releaseVoice(this.voicesByKey.get(key), AudioSystem.NOTE_RELEASE_SECONDS);
      return;
    }

    // General MIDI 的第 10 通道是打击乐。钢琴 SoundFont 无法正确解释这些
    // 音符，之前会把鼓点播放成周期性高音噪声。
    if (channel === AudioSystem.PERCUSSION_CHANNEL || this.volume <= 0) return;
    if (!Number.isFinite(velocity)) return;

    const previous = this.voicesByKey.get(key);
    if (previous) this.releaseVoice(previous, AudioSystem.STOP_RELEASE_SECONDS);
    this.startVoice(key, this.normalizeSoundfontNote(rawNoteNumber), velocity / 127);
  }

  private startVoice(key: string, noteNumber: number, velocity: number): void {
    const context = this.ensureAudioContext();
    if (context.state !== 'running') return;

    while (this.activeVoices.size >= AudioSystem.MAX_ACTIVE_VOICES) {
      const oldest = this.activeVoices.values().next().value as ActiveVoice | undefined;
      if (!oldest) break;
      this.releaseVoice(oldest, AudioSystem.STOP_RELEASE_SECONDS);
      // A released source remains in activeVoices until onended. Remove it from
      // capacity accounting now so a dense chord cannot deadlock this loop.
      this.activeVoices.delete(oldest);
    }

    const now = context.currentTime;
    const gain = context.createGain();
    const sample = this.useSoundfontForPlayback ? this.soundfontBuffers?.[noteNumber] : undefined;
    let source: VoiceSource;
    let level: number;

    if (sample) {
      const bufferSource = context.createBufferSource();
      bufferSource.buffer = sample;
      source = bufferSource;
      level = Math.max(0.0001, Math.min(1, velocity) * AudioSystem.NOTE_GAIN_SCALE);
    } else {
      const oscillator = context.createOscillator();
      oscillator.type = 'triangle';
      oscillator.frequency.value = 440 * Math.pow(2, (noteNumber - 69) / 12);
      source = oscillator;
      level = Math.max(0.0001, Math.min(1, velocity) * AudioSystem.FALLBACK_GAIN_SCALE);
    }

    gain.gain.setValueAtTime(0.0001, now);
    gain.gain.exponentialRampToValueAtTime(level, now + 0.008);
    source.connect(gain);
    gain.connect(this.masterGain ?? context.destination);

    const voice: ActiveVoice = { key, source, gain, released: false };
    this.activeVoices.add(voice);
    this.voicesByKey.set(key, voice);
    source.onended = () => this.cleanupVoice(voice);

    try {
      source.start(now);
      if (!sample) {
        source.stop(now + AudioSystem.MAX_FALLBACK_NOTE_SECONDS);
      }
    } catch {
      this.cleanupVoice(voice);
    }
  }

  private releaseVoice(voice: ActiveVoice | undefined, releaseSeconds: number): void {
    if (!voice || voice.released) return;
    voice.released = true;
    if (this.voicesByKey.get(voice.key) === voice) this.voicesByKey.delete(voice.key);

    const context = this.audioContext;
    if (!context) {
      this.cleanupVoice(voice);
      return;
    }

    const now = context.currentTime;
    const stopAt = now + Math.max(0.005, releaseSeconds);
    try {
      const param = voice.gain.gain;
      if (typeof param.cancelAndHoldAtTime === 'function') {
        param.cancelAndHoldAtTime(now);
      } else {
        const currentValue = Math.max(0.0001, param.value);
        param.cancelScheduledValues(now);
        param.setValueAtTime(currentValue, now);
      }
      param.linearRampToValueAtTime(0.0001, stopAt);
      voice.source.stop(stopAt);
    } catch {
      this.cleanupVoice(voice);
    }
  }

  private cleanupVoice(voice: ActiveVoice): void {
    this.activeVoices.delete(voice);
    if (this.voicesByKey.get(voice.key) === voice) this.voicesByKey.delete(voice.key);
    try { voice.source.disconnect(); } catch { /* already disconnected */ }
    try { voice.gain.disconnect(); } catch { /* already disconnected */ }
  }

  private voiceKey(channel: number, noteNumber: number): string {
    return `${channel}:${Math.round(noteNumber)}`;
  }

  /** 钢琴采样覆盖 21-108；超出的原版音符按八度折回。 */
  private normalizeSoundfontNote(noteNumber: number): number {
    let normalized = Math.round(noteNumber);
    while (normalized > AudioSystem.SOUNDFONT_HIGHEST_NOTE) normalized -= 12;
    while (normalized < AudioSystem.SOUNDFONT_LOWEST_NOTE) normalized += 12;
    return normalized;
  }

  /** 异步重播可避开 midi-player-js 当前调度循环里的重复定时器。 */
  private handleEndOfFile(): void {
    const generation = this.playbackGeneration;
    const track = this.currentTrack;
    if (!this.isPlaying || !track) return;

    setTimeout(() => {
      if (generation !== this.playbackGeneration || !this.isPlaying || this.currentTrack !== track) return;
      try {
        this.stopActiveVoices();
        // 音色若在本轮中途加载完成，只在下一轮统一切换，避免突然改变响度和音色。
        this.useSoundfontForPlayback = this.soundfontBuffers !== null;
        this.midiPlayer?.play();
      } catch (e) {
        console.warn(`Failed to loop MIDI ${track}:`, e);
        this.isPlaying = false;
      }
    }, 0);
  }

  async playMidi(filePath: string): Promise<void> {
    const generation = ++this.playbackGeneration;
    if (!this.initialized) await this.init();

    if (generation !== this.playbackGeneration) return;
    if (!this.midiPlayer) {
      console.warn('MIDI player not available');
      return;
    }

    try {
      await this.unlock();
      if (generation !== this.playbackGeneration) return;
      this.stopPlayback();

      const response = await fetch(filePath);
      if (!response.ok) throw new Error(`HTTP ${response.status}`);
      const arrayBuffer = await response.arrayBuffer();
      if (generation !== this.playbackGeneration) return;
      this.midiPlayer.loadDataUri(this.arrayBufferToDataUri(arrayBuffer));

      this.useSoundfontForPlayback = this.soundfontBuffers !== null;
      this.currentTrack = filePath;
      this.isPlaying = true;
      this.midiPlayer.play();
      console.log(`Playing MIDI: ${filePath}`);
    } catch (e) {
      if (generation !== this.playbackGeneration) return;
      this.stopPlayback();
      console.warn(`Failed to play MIDI ${filePath}:`, e);
    }
  }

  stop(): void {
    this.playbackGeneration++;
    this.stopPlayback();
  }

  private stopPlayback(): void {
    if (this.midiPlayer) {
      try { this.midiPlayer.stop(); } catch { /* already stopped */ }
    }
    this.stopActiveVoices();
    this.isPlaying = false;
    this.currentTrack = null;
    this.useSoundfontForPlayback = false;
  }

  private stopActiveVoices(): void {
    for (const voice of Array.from(this.activeVoices)) {
      this.releaseVoice(voice, AudioSystem.STOP_RELEASE_SECONDS);
    }
  }

  pause(): void {
    if (this.midiPlayer) {
      try { this.midiPlayer.pause(); } catch { /* already paused */ }
    }
    this.stopActiveVoices();
    this.isPlaying = false;
  }

  resume(): void {
    void this.unlock().then(() => {
      if (this.midiPlayer && this.currentTrack) {
        try { this.midiPlayer.play(); } catch { /* already playing */ }
      }
      this.isPlaying = this.currentTrack !== null;
    }).catch(() => {});
  }

  setVolume(vol: number): void {
    this.volume = Math.max(0, Math.min(1, vol));
    if (this.masterGain && this.audioContext) {
      const now = this.audioContext.currentTime;
      const target = this.volume * AudioSystem.MASTER_OUTPUT_SCALE;
      this.masterGain.gain.cancelScheduledValues(now);
      this.masterGain.gain.setTargetAtTime(target, now, 0.015);
    }
  }

  get isAudioPlaying(): boolean {
    return this.isPlaying;
  }

  get currentMusic(): string | null {
    return this.currentTrack;
  }

  private arrayBufferToDataUri(buffer: ArrayBuffer): string {
    const bytes = new Uint8Array(buffer);
    let binary = '';
    for (let i = 0; i < bytes.length; i++) binary += String.fromCharCode(bytes[i]);
    return `data:audio/midi;base64,${btoa(binary)}`;
  }
}
