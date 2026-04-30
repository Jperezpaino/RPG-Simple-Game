package es.noa.rad.game.engine.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import es.noa.rad.game.engine.core.component.GamePanel;
import es.noa.rad.game.engine.event.KeyHandler;

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
      super.setSpriteCounter(0);
      super.setSpriteNum(1);
    }

    /**
     *
     */
    public final void initSprites() {
      try {
        final BufferedImage[] up = new BufferedImage[2];
        up[0] = ImageIO.read(this.getClass().getResourceAsStream(
          "/assets/entity/player/link/walk/up-0.png"));
        up[1] = ImageIO.read(this.getClass().getResourceAsStream(
          "/assets/entity/player/link/walk/up-1.png"));
        super.setUp(up);

        final BufferedImage[] down = new BufferedImage[2];
        down[0] = ImageIO.read(this.getClass().getResourceAsStream(
          "/assets/entity/player/link/walk/down-0.png"));
        down[1] = ImageIO.read(this.getClass().getResourceAsStream(
          "/assets/entity/player/link/walk/down-1.png"));
        super.setDown(down);

        final BufferedImage[] left = new BufferedImage[2];
        left[0] = ImageIO.read(this.getClass().getResourceAsStream(
          "/assets/entity/player/link/walk/left-0.png"));
        left[1] = ImageIO.read(this.getClass().getResourceAsStream(
          "/assets/entity/player/link/walk/left-1.png"));
        super.setLeft(left);

        final BufferedImage[] right = new BufferedImage[2];
        right[0] = ImageIO.read(this.getClass().getResourceAsStream(
          "/assets/entity/player/link/walk/right-0.png"));
        right[1] = ImageIO.read(this.getClass().getResourceAsStream(
          "/assets/entity/player/link/walk/right-1.png"));
        super.setRight(right);

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

      super.setSpriteCounter(super.getSpriteCounter() + 1);
      if (super.getSpriteCounter() > 12) {
        if (super.getSpriteNum() == 0) {
          super.setSpriteNum(1);
        } else {
          super.setSpriteNum(0);
        }
        super.setSpriteCounter(0);
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
          if (super.getSpriteNum() == 0) {
            sprite = super.getUp(0);
          } else {
            sprite = super.getUp(1);
          }
        break;
        case "down":
          if (super.getSpriteNum() == 0) {
            sprite = super.getDown(0);
          } else {
            sprite = super.getDown(1);
          }
        break;
        case "left":
          if (super.getSpriteNum() == 0) {
            sprite = super.getLeft(0);
          } else {
            sprite = super.getLeft(1);
          }
        break;
        case "right":
          if (super.getSpriteNum() == 0) {
            sprite = super.getRight(0);
          } else {
            sprite = super.getRight(1);
          }
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
