/**
 * Package: es.noa.rad.game.rpgs2d.tile.
 */
package es.noa.rad.game.rpgs2d.tile;

import java.awt.image.BufferedImage;

  /**
   *
   */
  public class Tile {

    /**
     *
     */
    private BufferedImage image;

    /**
     * @param _image {@code BufferedImage}
     */
    public Tile(
        final BufferedImage _image) {
      super();
      this.image = _image;
    }

    /**
     *
     */
    public Tile() {
      super();
      this.image = null;
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

  }
