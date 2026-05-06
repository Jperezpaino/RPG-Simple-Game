package es.noa.rad.game.engine.asset.object;

import java.io.IOException;

import javax.imageio.ImageIO;

  /**
   * @see es.noa.rad.game.engine.asset.object.ObjectEntity
   */
  public class KeyObject
      extends ObjectEntity {

    /**
     *
     */
    public KeyObject() {
      super.setName("key");
      try {
        this.setImage(
          ImageIO.read(
            this.getClass().getResourceAsStream(
              "/assets/object/key.png"
            )
          )
        );
      } catch (
          final IOException iOException) {
        iOException.printStackTrace();
      }
    }

  }