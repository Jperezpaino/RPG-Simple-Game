package es.noa.rad.game.engine.core.physic;

import es.noa.rad.game.engine.core.component.GamePanel;
import es.noa.rad.game.engine.entity.Entity;

  /**
   *
   */
  public class Collision {

    /**
     *
     */
    private GamePanel gamePanel;

    /**
     * @param _gamePanel {@code GamePanel}
     */
    public Collision(
        final GamePanel _gamePanel) {
      this.gamePanel = _gamePanel;
    }

    /**
     * @param _entity {@code Entity}
     */
    public final void collisionTile(
        final Entity _entity) {
      System.out.println("Collision Check Entity / Tiles");
    }

  }
