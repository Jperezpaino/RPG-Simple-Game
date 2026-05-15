package es.noa.rad.game.engine.sound;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

  /**
   *
   */
  public class Sound {

    /**
     *
     */
    private Clip clip;

    /**
     *
     */
    private URL[] soundURL = new URL[30];

    /**
     *
     */
    public Sound() {
      this.soundURL[0]
        = this.getClass().getResource("/assets/sound/music/main.wav");
    }

    /**
     * @param _index {@code int}
     */
    public final void setFile(
        final int _index) {
      try {
        final AudioInputStream audioInputStream
          = AudioSystem.getAudioInputStream(this.soundURL[_index]);
        this.clip = AudioSystem.getClip();
        this.clip.open(audioInputStream);
      } catch (
          final Exception exception) {
        exception.printStackTrace();
      }
    }

    /**
     *
     */
    public final void play() {
      this.clip.start();
    }

    /**
     *
     */
    public final void loop() {
      this.clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     *
     */
    public final void stop() {
      this.clip.stop();
    }

  }
