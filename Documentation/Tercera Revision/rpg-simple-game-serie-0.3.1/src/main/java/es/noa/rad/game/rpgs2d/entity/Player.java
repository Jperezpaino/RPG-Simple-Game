/**
 * Package: es.noa.rad.game.rpgs2d.entity.
 */
package es.noa.rad.game.rpgs2d.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
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
      this.initSprites();
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
      super.setDirection("down");
    }

    /**
     *
     */
    public final void initSprites() {
      try {
        super.setUp(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkUp.png")));
        super.setDown(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkDown.png")));
        super.setLeft(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkLeft.png")));
        super.setRight(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkRight.png")));
      } catch (
          final IOException iOException) {
        iOException.printStackTrace();
      }
    }

    /**
     *
     */
    public final void update() {
      if (this.keyHandler.isUpPressed()) {
        super.setY(super.getY() - super.getSpeed());
        super.setDirection("up");
      } else if (this.keyHandler.isDownPressed()) {
        super.setY(super.getY() + super.getSpeed());
        super.setDirection("down");
      } else if (this.keyHandler.isLeftPressed()) {
        super.setX(super.getX() - super.getSpeed());
        super.setDirection("left");
      } else if (this.keyHandler.isRightPressed()) {
        super.setX(super.getX() + super.getSpeed());
        super.setDirection("right");
      }
    }

    /**
     * @param _graphics2D {@code Graphics2D}
     */
    public final void draw(
        final Graphics2D _graphics2D) {

      BufferedImage sprite = null;

      switch (super.getDirection()) {
        case "up":
          sprite = super.getUp();
        break;
        case "down":
          sprite = super.getDown();
        break;
        case "left":
          sprite = super.getLeft();
        break;
        case "right":
          sprite = super.getRight();
        break;
        default:
        break;
      }

      _graphics2D.drawImage(
        sprite,
        super.getX(),
        super.getY(),
        this.gamePanel.getTileSize(),
        this.gamePanel.getTileSize(),
        null
      );
    }

  }
