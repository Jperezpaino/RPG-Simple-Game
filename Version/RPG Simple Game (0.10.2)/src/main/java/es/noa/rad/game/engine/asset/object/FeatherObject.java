package es.noa.rad.game.engine.asset.object;

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

  /**
   * @see es.noa.rad.game.engine.asset.object.ObjectEntity
   */
  public class FeatherObject
      extends ObjectEntity {

    /**
     *
     */
    public FeatherObject() {
      super();
      super.setName("feather");
      try {
        super.setImage(
          ImageIO.read(
            this.getClass().getResourceAsStream(
              "/assets/object/feather.png"
            )
          )
        );
      } catch (
          final IOException iOException) {
        iOException.printStackTrace();
      }

      final Rectangle solidArea = super.getSolidArea();
      solidArea.x = 12;
      solidArea.y = 3;
      solidArea.width = 24;
      solidArea.height = 45;
      this.setSolidAreaDefaultX(this.getSolidArea().x);
      this.setSolidAreaDefaultY(this.getSolidArea().y);

      super.setCollidable(true);
    }

  }
