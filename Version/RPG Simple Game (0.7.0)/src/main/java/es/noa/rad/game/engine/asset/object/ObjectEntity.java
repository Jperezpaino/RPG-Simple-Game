package es.noa.rad.game.engine.asset.object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import es.noa.rad.game.engine.core.component.GamePanel;

  /**
   *
   */
  public abstract class ObjectEntity {

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
    private boolean collision;

    /**
     *
     */
    protected ObjectEntity() {
      super();
      this.collision = false;
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
     * @return {@code boolean}
     */
    protected final boolean isCollision() {
      return this.collision;
    }

    /**
     * @param _collision {@code boolean}
     */
    protected final void setCollision(
        final boolean _collision) {
      this.collision = _collision;
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
        _graphics2D.setColor(Color.red);
        _graphics2D.fillRect(
          screenX,
          screenY,
          tileSize,
          tileSize
        );
      }
    }

  }
