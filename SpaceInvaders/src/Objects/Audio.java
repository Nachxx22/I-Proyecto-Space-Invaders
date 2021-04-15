package Objects;
import javax.sound.sampled.*;
import java.io.File;

public class Audio {
    private Clip clip;
    //clip method
    public Audio(String path) {
        try
        {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(path)));
            clip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }
    public void Stop() {
        clip.stop();
    }
}