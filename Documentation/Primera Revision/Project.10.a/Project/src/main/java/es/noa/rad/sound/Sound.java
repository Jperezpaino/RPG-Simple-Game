package es.noa.rad.sound;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
  private Clip clip;
  private URL[] soundURL = new URL[30];

  public Sound() {
	this.soundURL[0] = getClass().getResource("/assets/sound/music/BlueBoyAdventure.wav");
	this.soundURL[1] = getClass().getResource("/assets/sound/effects/coin.wav");
	this.soundURL[2] = getClass().getResource("/assets/sound/effects/powerup.wav");
	this.soundURL[3] = getClass().getResource("/assets/sound/effects/unlock.wav");
	this.soundURL[4] = getClass().getResource("/assets/sound/effects/fanfare.wav");
  }

  public final void setFile(int i) {
    try {
      final AudioInputStream audioInputStream
        = AudioSystem.getAudioInputStream(this.soundURL[i]);
      this.clip = AudioSystem.getClip();
      this.clip.open(audioInputStream);
    } catch (final Exception exception) {
      exception.printStackTrace();
    }
  }

  public final void play() {
    this.clip.start();
  }

  public final void loop() {
    this.clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

  public final void stop() {
    this.clip.stop();
  }

}
