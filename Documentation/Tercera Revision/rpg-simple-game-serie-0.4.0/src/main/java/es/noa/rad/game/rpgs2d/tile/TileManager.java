/**
 * Package: es.noa.rad.game.rpgs2d.tile.
 */
package es.noa.rad.game.rpgs2d.tile;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import es.noa.rad.game.rpgs2d.GamePanel;

  /**
   *
   */
  public class TileManager {

    /**
     *
     */
    private GamePanel gamePanel;

    /**
     *
     */
    private Tile tile;

    /**
     * @param _gamePanel {@code GamePanel}
     */
    public TileManager(
        final GamePanel _gamePanel) {
      this.gamePanel = _gamePanel;

      this.getTileImage();
    }

    /**
     *
     */
    public final void getTileImage() {
      try {
        this.tile = new Tile(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/map/tiles/grass.png")));
      } catch (
          final IOException iOException) {
        iOException.printStackTrace();
      }
    }

    /**
     * @param _graphics2D {@code Graphics2D}
     */
    public final void draw(
        final Graphics2D _graphics2D) {
      _graphics2D.drawImage(
        this.tile.getImage(),
        0, 0,
        this.gamePanel.getTileSize(),
        this.gamePanel.getTileSize(),
        null
      );
    }

  }
