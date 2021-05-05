package jasper.core.audio;

import jasper.core.Server;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

import static jasper.util.StringToObject.INTEGER;

public class Audio extends Server {
    protected int
        playback_channels    =     2,
        playback_sample_rate = 44100,
        playback_sample_size =    16;
    protected AudioFormat
        playback_format;
    
    protected SourceDataLine
        sdl;
    
    public Audio() {
        // do nothing
    }
    
    @Override
    public void onInit() throws Exception {
        playback_channels    = getPropertyAs(PLAYBACK_CHANNELS   , INTEGER, playback_channels   );
        playback_sample_rate = getPropertyAs(PLAYBACK_SAMPLE_RATE, INTEGER, playback_sample_rate);
        playback_sample_size = getPropertyAs(PLAYBACK_SAMPLE_SIZE, INTEGER, playback_sample_size);
        
        playback_format = new AudioFormat(
            playback_sample_rate,
            playback_sample_size,
            playback_channels,
            true ,
            false
        );
    
        sdl = AudioSystem.getSourceDataLine(playback_format);
        sdl.open(playback_format, 4096);
        sdl.start();
    }
    
    @Override
    public void onStep() throws Exception {
    
    }
    
    public static final String
        PLAYBACK_CHANNELS    = "playback-channels",
        PLAYBACK_DEVICE      = "playback-device",
        PLAYBACK_SAMPLE_RATE = "playback-sample-rate",
        PLAYBACK_SAMPLE_SIZE = "playback-sample-size";
}
