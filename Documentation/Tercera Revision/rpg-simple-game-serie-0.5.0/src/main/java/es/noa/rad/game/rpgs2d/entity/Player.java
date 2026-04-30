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
    private final int screenX;

    /**
     *
     */
    private final int screenY;

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

      this.screenX = (
        ((this.gamePanel.getScreenWidth() / 2)
       - (this.gamePanel.getTileSize() / 2)));
      this.screenY = (
        ((this.gamePanel.getScreenHeight() / 2)
       - (this.gamePanel.getTileSize() / 2)));

      this.init();
      this.initSprites();
    }

    /**
     *
     */
    public final void init() {
      super.setWorldX(
        ((this.gamePanel.getScreenWidth() / 2)
       - (this.gamePanel.getTileSize() / 2)));
      super.setWorldY(
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
        super.setUpStart(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkUpStart.png")));
        super.setUpEnd(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkUpEnd.png")));
        super.setDownStart(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkDownStart.png")));
        super.setDownEnd(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkDownEnd.png")));
        super.setLeftStart(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkLeftStart.png")));
        super.setLeftEnd(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkLeftEnd.png")));
        super.setRightStart(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkRightStart.png")));
        super.setRightEnd(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/entity/player/walking/linkRightEnd.png")));
      } catch (
          final IOException iOException) {
        iOException.printStackTrace();
      }
    }

    /**
     * @return {@code int}
     */
    public final int getScreenX() {
      return this.screenX;
    }

    /**
     * @return {@code int}
     */
    public final int getScreenY() {
      return this.screenY;
    }

    /**
     *
     */
    public final void update() {
      if (this.keyHandler.isUpPressed()
       || this.keyHandler.isDownPressed()
       || this.keyHandler.isLeftPressed()
       || this.keyHandler.isRightPressed()) {
        if (this.keyHandler.isUpPressed()) {
          super.setWorldY(super.getWorldY() - super.getSpeed());
          super.setDirection("up");
        } else if (this.keyHandler.isDownPressed()) {
          super.setWorldY(super.getWorldY() + super.getSpeed());
          super.setDirection("down");
        } else if (this.keyHandler.isLeftPressed()) {
          super.setWorldX(super.getWorldX() - super.getSpeed());
          super.setDirection("left");
        } else if (this.keyHandler.isRightPressed()) {
          super.setWorldX(super.getWorldX() + super.getSpeed());
          super.setDirection("right");
        }

        super.setSpriteCounter(super.getSpriteCounter() + 1);
        if (super.getSpriteCounter() > 12) {
          if (super.getSpriteNum() == 1) {
            super.setSpriteNum(2);
          } else {
            super.setSpriteNum(1);
          }
          super.setSpriteCounter(0);
        }
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
          if (super.getSpriteNum() == 1) {
            sprite = super.getUpStart();
          } else {
            sprite = super.getUpEnd();
          }
        break;
        case "down":
          if (super.getSpriteNum() == 1) {
            sprite = super.getDownStart();
          } else {
            sprite = super.getDownEnd();
          }
        break;
        case "left":
          if (super.getSpriteNum() == 1) {
            sprite = super.getLeftStart();
          } else {
            sprite = super.getLeftEnd();
          }
        break;
        case "right":
          if (super.getSpriteNum() == 1) {
            sprite = super.getRightStart();
          } else {
            sprite = super.getRightEnd();
          }
        break;
        default:
        break;
      }

      _graphics2D.drawImage(
        sprite,
        this.screenX,
        this.screenY,
        this.gamePanel.getTileSize(),
        this.gamePanel.getTileSize(),
        null
      );
    }

  }
