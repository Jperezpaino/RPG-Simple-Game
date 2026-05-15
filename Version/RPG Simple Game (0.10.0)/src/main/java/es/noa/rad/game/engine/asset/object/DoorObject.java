package es.noa.rad.game.engine.asset.object;

import java.io.IOException;

import javax.imageio.ImageIO;

  /**
   * @see es.noa.rad.game.engine.asset.object.ObjectEntity
   */
  public class DoorObject
      extends ObjectEntity {

    /**
     *
     */
    public DoorObject() {
      super();
      super.setName("door");
      try {
        super.setImage(
          ImageIO.read(
            this.getClass().getResourceAsStream(
              "/assets/object/door.png"
            )
          )
        );
      } catch (
          final IOException iOException) {
        iOException.printStackTrace();
      }

      super.setCollidable(true);
    }

  }
