package es.noa.rad.game.engine.asset.object;

import java.awt.Rectangle;
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
        super.setImage(
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

      final Rectangle solidArea = super.getSolidArea();
      solidArea.x = 12;
      solidArea.y = 0;
      solidArea.width = 24;
      solidArea.height = 48;
      this.setSolidAreaDefaultX(this.getSolidArea().x);
      this.setSolidAreaDefaultY(this.getSolidArea().y);
    }

  }
