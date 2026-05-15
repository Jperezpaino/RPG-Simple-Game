package es.noa.rad.game.engine.asset.object;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import es.noa.rad.game.engine.core.component.GamePanel;

  /**
   *
   */
  public abstract class ObjectEntity {

    /**
     *
     */
    public static final Color COLOR_COLLISION_STATE
      = new Color(255, 0, 0, 128);

    /**
     *
     */
    public static final int MAX_NUM_OBJECTS = 10;

    /**
     *
     */
    private BufferedImage image;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private int worldX;

    /**
     *
     */
    private int worldY;

    /**
     *
     */
    private Rectangle solidArea;

    /**
     *
     */
    private int solidAreaDefaultX;

    /**
     *
     */
    private int solidAreaDefaultY;

    /**
     *
     */
    private boolean collidable;

    /**
     *
     */
    protected ObjectEntity() {
      super();
      this.collidable = false;
      this.solidArea = new Rectangle(0, 0, 48, 48);
      this.solidAreaDefaultX = 0;
      this.solidAreaDefaultY = 0;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getImage() {
      return this.image;
    }

    /**
     * @param _image {@code BufferedImage}
     */
    protected final void setImage(
        final BufferedImage _image) {
      this.image = _image;
    }

    /**
     * @return {@code String}
     */
    protected final String getName() {
      return this.name;
    }

    /**
     * @param _name {@code String}
     */
    protected final void setName(
        final String _name) {
      this.name = _name;
    }

    /**
     * @return {@code int}
     */
    public final int getWorldX() {
      return this.worldX;
    }

    /**
     * @param _worldX {@code int}
     */
    public final void setWorldX(
        final int _worldX) {
      this.worldX = _worldX;
    }

    /**
     * @return {@code int}
     */
    public final int getWorldY() {
      return this.worldY;
    }

    /**
     * @param _worldY {@code int}
     */
    public final void setWorldY(
        final int _worldY) {
      this.worldY = _worldY;
    }

    /**
     * @return {@code Rectangle}
     */
    protected final Rectangle getSolidArea() {
      return this.solidArea;
    }

    /**
     * @param _solidArea {@code Rectangle}
     */
    protected final void setSolidArea(
        final Rectangle _solidArea) {
      this.solidArea = _solidArea;
    }

    /**
     * @return {@code int}
     */
    protected final int getSolidAreaDefaultX() {
      return this.solidAreaDefaultX;
    }

    /**
     * @param _solidAreaDefaultX {@code int}
     */
    protected final void setSolidAreaDefaultX(
        final int _solidAreaDefaultX) {
      this.solidAreaDefaultX = _solidAreaDefaultX;
    }

    /**
     * @return {@code int}
     */
    protected final int getSolidAreaDefaultY() {
      return this.solidAreaDefaultY;
    }

    /**
     * @param _solidAreaDefaultY {@code int}
     */
    protected final void setSolidAreaDefaultY(
        final int _solidAreaDefaultY) {
      this.solidAreaDefaultY = _solidAreaDefaultY;
    }

    /**
     * @return {@code boolean}
     */
    protected final boolean isCollidable() {
      return this.collidable;
    }

    /**
     * @param _collidable {@code boolean}
     */
    protected final void setCollidable(
        final boolean _collidable) {
      this.collidable = _collidable;
    }

    /**
     * @param _gamePanel {@code GamePanel}
     * @param _graphics2D {@code Graphics2D}
     */
    public final void draw(
        final GamePanel _gamePanel,
        final Graphics2D _graphics2D) {

      final int playerWorldX = _gamePanel.getPlayer().getWorldX();
      final int playerWorldY = _gamePanel.getPlayer().getWorldY();
      final int playerScreenX = _gamePanel.getPlayer().getScreenX();
      final int playerScreenY = _gamePanel.getPlayer().getScreenY();

      final int screenX = (this.worldX - playerWorldX + playerScreenX);
      final int screenY = (this.worldY - playerWorldY + playerScreenY);

      final int tileSize = _gamePanel.getTileSize();

      if (((this.worldX + tileSize) > (playerWorldX - playerScreenX))
       && ((this.worldX - tileSize) < (playerWorldX + playerScreenX))
       && ((this.worldY + tileSize) > (playerWorldY - playerScreenY))
       && ((this.worldY - tileSize) < (playerWorldY + playerScreenY))) {
        _graphics2D.drawImage(
          this.image,
          screenX,
          screenY,
          tileSize,
          tileSize,
          null
        );
        if (_gamePanel.isDebug()) {
          /* Keep original conditions. */
          final Composite originalComposite = _graphics2D.getComposite();
          final Color originalColor = _graphics2D.getColor();
          final Font originalFont = _graphics2D.getFont();

          /*
           * Establishes the explicit composition for colors with
           * transparency.
           */
          _graphics2D.setComposite(
            AlphaComposite.getInstance(AlphaComposite.SRC_OVER)
          );

          /* Draw the object's bounding box. */
          _graphics2D.setColor(Color.red);
          _graphics2D.drawRect(
            screenX,
            screenY,
            tileSize,
            tileSize
          );

          /* Draw the object's position. */
          final Font boldFont = originalFont.deriveFont(Font.BOLD);
          _graphics2D.setFont(boldFont);
          final int positionX = (4 + _gamePanel.getTileSize());
          final int positionY = _graphics2D.getFontMetrics().getHeight();
          _graphics2D.setColor(Color.red);
          _graphics2D.drawString(
            ("Screen X: " + screenX
           + " Screen Y: " + screenY),
            (screenX + positionX),
            (screenY + positionY)
          );
          _graphics2D.drawString(
            ("World X: " + this.getWorldX()
           + " World Y: " + this.getWorldY()),
            (screenX + positionX),
            (screenY + (positionY * 2))
          );

          /* Draw the object's collision state. */
          _graphics2D.setColor(ObjectEntity.COLOR_COLLISION_STATE);
          _graphics2D.fillRect(
            ((int) (screenX + this.getSolidArea().getX())),
            ((int) (screenY + this.getSolidArea().getY())),
            ((int) (this.getSolidArea().getWidth())),
            ((int) (this.getSolidArea().getHeight()))
          );

          /* Restores the entire graphical state. */
          _graphics2D.setFont(originalFont);
          _graphics2D.setComposite(originalComposite);
          _graphics2D.setColor(originalColor);
        }
      }
    }

  }
