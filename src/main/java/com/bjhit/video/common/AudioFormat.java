package com.bjhit.video.common;

/**
 * 
 * @description 音频格式
 * @project bjhit-video
 * @author guanxianchun
 * @Create 2015-2-11 下午2:22:20
 * @version 1.0
 */
public class AudioFormat {

    private int sampleRate;
    private int sampleSizeInBits;
    private int channelCount;
    private boolean signed;
    private boolean bigEndian;

    // Common audio formats
    public static AudioFormat STEREO_48K_S16_BE = new AudioFormat(48000, 16, 2, true, true);
    public static AudioFormat STEREO_48K_S16_LE = new AudioFormat(48000, 16, 2, true, false);

    public static AudioFormat STEREO_48K_S24_BE = new AudioFormat(48000, 24, 2, true, true);
    public static AudioFormat STEREO_48K_S24_LE = new AudioFormat(48000, 24, 2, true, false);

    public static AudioFormat MONO_48K_S16_BE = new AudioFormat(48000, 16, 1, true, true);
    public static AudioFormat MONO_48K_S16_LE = new AudioFormat(48000, 16, 1, true, false);

    public static AudioFormat MONO_48K_S24_BE = new AudioFormat(48000, 24, 1, true, true);
    public static AudioFormat MONO_48K_S24_LE = new AudioFormat(48000, 24, 1, true, false);

    public static AudioFormat STEREO_44K_S16_BE = new AudioFormat(44100, 16, 2, true, true);
    public static AudioFormat STEREO_44K_S16_LE = new AudioFormat(44100, 16, 2, true, false);

    public static AudioFormat STEREO_44K_S24_BE = new AudioFormat(44100, 24, 2, true, true);
    public static AudioFormat STEREO_44K_S24_LE = new AudioFormat(44100, 24, 2, true, false);

    public static AudioFormat MONO_44K_S16_BE = new AudioFormat(44100, 16, 1, true, true);
    public static AudioFormat MONO_44K_S16_LE = new AudioFormat(44100, 16, 1, true, false);

    public static AudioFormat MONO_44K_S24_BE = new AudioFormat(44100, 24, 1, true, true);
    public static AudioFormat MONO_44K_S24_LE = new AudioFormat(44100, 24, 1, true, false);

    public static AudioFormat STEREO_S16_BE(int rate) {
        return new AudioFormat(rate, 16, 2, true, true);
    }

    public static AudioFormat STEREO_S16_LE(int rate) {
        return new AudioFormat(rate, 16, 2, true, false);
    }

    public static AudioFormat STEREO_S24_BE(int rate) {
        return new AudioFormat(rate, 24, 2, true, true);
    }

    public static AudioFormat STEREO_S24_LE(int rate) {
        return new AudioFormat(rate, 24, 2, true, false);
    }

    public static AudioFormat MONO_S16_BE(int rate) {
        return new AudioFormat(rate, 16, 1, true, true);
    }

    public static AudioFormat MONO_S16_LE(int rate) {
        return new AudioFormat(rate, 16, 1, true, false);
    }

    public static AudioFormat MONO_S24_BE(int rate) {
        return new AudioFormat(rate, 24, 1, true, true);
    }

    public static AudioFormat MONO_S24_LE(int rate) {
        return new AudioFormat(rate, 24, 1, true, false);
    }

    public static AudioFormat NCH_48K_S16_BE(int n) {
        return new AudioFormat(48000, 16, n, true, true);
    }

    public static AudioFormat NCH_48K_S16_LE(int n) {
        return new AudioFormat(48000, 16, n, true, false);
    }

    public static AudioFormat NCH_48K_S24_BE(int n) {
        return new AudioFormat(48000, 24, n, true, true);
    }

    public static AudioFormat NCH_48K_S24_LE(int n) {
        return new AudioFormat(48000, 24, n, true, false);
    }

    public static AudioFormat NCH_44K_S16_BE(int n) {
        return new AudioFormat(44100, 16, n, true, true);
    }

    public static AudioFormat NCH_44K_S16_LE(int n) {
        return new AudioFormat(44100, 16, n, true, false);
    }

    public static AudioFormat NCH_44K_S24_BE(int n) {
        return new AudioFormat(44100, 24, n, true, true);
    }

    public static AudioFormat NCH_44K_S24_LE(int n) {
        return new AudioFormat(44100, 24, n, true, false);
    }

    public AudioFormat(int sampleRate, int sampleSizeInBits, int channelCount, boolean signed, boolean bigEndian) {
        this.sampleRate = sampleRate;
        this.sampleSizeInBits = sampleSizeInBits;
        this.channelCount = channelCount;
        this.signed = signed;
        this.bigEndian = bigEndian;
    }

    public AudioFormat(AudioFormat format, int newSampleRate) {
        this(format);
        this.sampleRate = newSampleRate;
    }

    public AudioFormat(AudioFormat format) {
        this(format.sampleRate, format.sampleSizeInBits, format.channelCount, format.signed, format.bigEndian);
    }

    public int getChannels() {
        return channelCount;
    }

    public int getSampleSizeInBits() {
        return sampleSizeInBits;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public short getFrameSize() {
        return (short) ((sampleSizeInBits >> 3) * channelCount);
    }

    public int getFrameRate() {
        return sampleRate;
    }

    public boolean isBigEndian() {
        return bigEndian;
    }

    public boolean isSigned() {
        return signed;
    }

    public int bytesToFrames(int bytes) {
        return bytes / (channelCount * sampleSizeInBits >> 3);
    }

    public int framesToBytes(int samples) {
        return samples * (channelCount * sampleSizeInBits >> 3);
    }

    public int bytesToSamples(int bytes) {
        return bytes / (sampleSizeInBits >> 3);
    }

    public int samplesToBytes(int samples) {
        return samples * (sampleSizeInBits >> 3);
    }
}