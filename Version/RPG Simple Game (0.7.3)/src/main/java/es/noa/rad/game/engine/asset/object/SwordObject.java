package es.noa.rad.game.engine.asset.object;

import java.io.IOException;

import javax.imageio.ImageIO;

  /**
   * @see es.noa.rad.game.engine.asset.object.ObjectEntity
   */
  public class SwordObject
      extends ObjectEntity {

    /**
     *
     */
    public SwordObject() {
      super();
      super.setName("sword");
      try {
        this.setImage(
          ImageIO.read(
            this.getClass().getResourceAsStream(
              "/assets/object/sword.png"
            )
          )
        );
      } catch (
          final IOException iOException) {
        iOException.printStackTrace();
      }
    }

  }
