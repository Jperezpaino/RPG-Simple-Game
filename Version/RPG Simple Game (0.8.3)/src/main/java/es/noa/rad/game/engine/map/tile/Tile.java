package es.noa.rad.game.engine.map.tile;

import java.awt.Color;
import java.awt.image.BufferedImage;

  /**
   *
   */
  public class Tile {

    /**
     *
     */
    public static final Color COLOR_COLLISION_ON
      = new Color(255, 0, 0, 64);

    /**
     *
     */
    public static final Color COLOR_COLLISION_OFF
      = new Color(0, 255, 0, 64);

    /**
     *
     */
    private BufferedImage image;

    /**
     *
     */
    private boolean collision;

    /**
     * @param _image {@code BufferedImage}
     * @param _collision {@code boolean}
     */
    public Tile(
        final BufferedImage _image,
        final boolean _collision) {
      super();
      this.image = _image;
      this.collision = _collision;
    }

    /**
     *
     */
    public Tile() {
      super();
      this.image = null;
      this.collision = false;
    }

    /**
     * @return {@code BufferedImage}
     */
    public final BufferedImage getImage() {
      return this.image;
    }

    /**
     * @param _image {@code BufferedImage}
     */
    public final void setImage(
        final BufferedImage _image) {
      this.image = _image;
    }

    /**
     * @return {@code boolean}
     */
    public final boolean isCollision() {
      return this.collision;
    }

    /**
     * @param _collision {@code boolean}
     */
    public final void setCollision(
        final boolean _collision) {
      this.collision = _collision;
    }

  }
