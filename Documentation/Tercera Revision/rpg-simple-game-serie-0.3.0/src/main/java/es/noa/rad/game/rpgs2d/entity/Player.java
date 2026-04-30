/**
 * Package: es.noa.rad.game.rpgs2d.entity.
 */
package es.noa.rad.game.rpgs2d.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import es.noa.rad.game.rpgs2d.GamePanel;
import es.noa.rad.game.rpgs2d.KeyHandler;

  /**
   * @see es.noa.rad.game.rpgs2d.entity.Entity
   */
  public class Player
      extends Entity {

    /**
     *
     */
    private GamePanel gamePanel;

    /**
     *
     */
    private KeyHandler keyHandler;

    /**
     * @param _gamePanel {@code GamePanel}
     * @param _keyHandler {@code KeyHandler}
     */
    public Player(
        final GamePanel _gamePanel,
        final KeyHandler _keyHandler) {
      super();
      this.gamePanel = _gamePanel;
      this.keyHandler = _keyHandler;
      this.init();
    }

    /**
     *
     */
    public final void init() {
      super.setX(
        ((this.gamePanel.getScreenWidth() / 2)
       - (this.gamePanel.getTileSize() / 2)));
      super.setY(
        ((this.gamePanel.getScreenHeight() / 2)
       - (this.gamePanel.getTileSize() / 2)));
      super.setSpeed(4);
    }

    /**
     *
     */
    public final void update() {
      if (this.keyHandler.isUpPressed()) {
        super.setY(super.getY() - super.getSpeed());
      } else if (this.keyHandler.isDownPressed()) {
        super.setY(super.getY() + super.getSpeed());
      } else if (this.keyHandler.isLeftPressed()) {
        super.setX(super.getX() - super.getSpeed());
      } else if (this.keyHandler.isRightPressed()) {
        super.setX(super.getX() + super.getSpeed());
      }
    }

    /**
     * @param _graphics2D {@code Graphics2D}
     */
    public final void draw(
        final Graphics2D _graphics2D) {
      _graphics2D.setColor(Color.white);
      _graphics2D.fillRect(
        super.getX(),
        super.getY(),
        this.gamePanel.getTileSize(),
        this.gamePanel.getTileSize()
      );
    }

  }
