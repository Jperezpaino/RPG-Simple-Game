package es.noa.rad.game.engine.entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import es.noa.rad.game.engine.core.component.GamePanel;
import es.noa.rad.game.engine.event.KeyHandler;

  /**
   * @see es.noa.rad.game.engine.entity.Entity
   */
  public class Player
      extends Entity {

    /**
     *
     */
    public static final Color COLOR_COLLISION_STATE
      = new Color(255, 0, 255, 128);

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

      this.screenX = 
        ((this.gamePanel.getScreenWidth() / 2)
       - (this.gamePanel.getTileSize() / 2));
      this.screenY = 
        ((this.gamePanel.getScreenHeight() / 2)
       - (this.gamePanel.getTileSize() / 2));

      final Rectangle solidArea = new Rectangle();
      solidArea.x = 8;
      solidArea.y = 16;
      solidArea.width = 32;
      solidArea.height = 32;
      super.setSolidArea(solidArea);

      this.init();
      this.initSprites();
    }

    /**
     *
     */
    public final void init() {
      super.setWorldX(
        ((this.gamePanel.getWorldWidth() / 2)
       - (this.gamePanel.getTileSize() / 2)));
      super.setWorldY(
        ((this.gamePanel.getWorldHeight() / 2)
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
          super.setDirection("up");
        } else if (this.keyHandler.isDownPressed()) {
          super.setDirection("down");
        } else if (this.keyHandler.isLeftPressed()) {
          super.setDirection("left");
        } else if (this.keyHandler.isRightPressed()) {
          super.setDirection("right");
        }

        /* Check the collisions between the player and the destination tile. */
        super.setCollision(false);
        this.gamePanel.getCollision().collisionTile(this);

        /* if collision is false, player can move. */
        if (!super.isCollision()) {
          switch (super.getDirection()) {
            case "up":
              super.setWorldY(super.getWorldY() - super.getSpeed());
            break;
            case "down":
              super.setWorldY(super.getWorldY() + super.getSpeed());
            break;
            case "left":
              super.setWorldX(super.getWorldX() - super.getSpeed());
            break;
            case "right":
              super.setWorldX(super.getWorldX() + super.getSpeed());
            break;
            default:
            break;
          }
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
        this.screenX,
        this.screenY,
        this.gamePanel.getTileSize(),
        this.gamePanel.getTileSize(),
        null
      );

      if (this.gamePanel.isDebug()) {
        /* Keep original conditions. */
        final Composite originalComposite = _graphics2D.getComposite();
        final Color originalColor = _graphics2D.getColor();

        /*
         * Establishes the explicit composition for colors with
         * transparency.
         */
        _graphics2D.setComposite(
          AlphaComposite.getInstance(AlphaComposite.SRC_OVER)
        );

        /* Draw the player's bounding box. */
        _graphics2D.setColor(Color.black);
        _graphics2D.drawRect(
          this.screenX,
          this.screenY,
          this.gamePanel.getTileSize(),
          this.gamePanel.getTileSize()
        );
        /* Draw the player's collision state. */
        _graphics2D.setColor(Player.COLOR_COLLISION_STATE);
        _graphics2D.fillRect(
          ((int) (this.screenX + super.getSolidArea().getX())),
          ((int) (this.screenY + super.getSolidArea().getY())),
          ((int) (super.getSolidArea().getWidth())),
          ((int) (super.getSolidArea().getHeight()))
        );

        /* Restores the entire graphical state. */
        _graphics2D.setComposite(originalComposite);
        _graphics2D.setColor(originalColor);
      }

    }

  }
