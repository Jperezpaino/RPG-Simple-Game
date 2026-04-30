package es.noa.rad.game.engine.map.tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import es.noa.rad.game.engine.core.component.GamePanel;

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
    private Tile[] tiles;

    /**
     * @param _gamePanel {@code GamePanel}
     */
    public TileManager(
        final GamePanel _gamePanel) {
      this.gamePanel = _gamePanel;

      this.tiles = new Tile[10];

      this.getTileImage();
    }

    /**
     *
     */
    public final void getTileImage() {
      try {
        this.tiles[0] = new Tile();
        (this.tiles[0]).setImage(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/map/world/tile/grass.png")));
        this.tiles[1] = new Tile();
        (this.tiles[1]).setImage(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/map/world/tile/wall.png")));
        this.tiles[2] = new Tile();
        (this.tiles[2]).setImage(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/map/world/tile/water.png")));
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
      final BufferedImage grass = (this.tiles[0]).getImage();
      final BufferedImage wall = (this.tiles[1]).getImage();
      final BufferedImage water = (this.tiles[2]).getImage();
      final int tileSize = this.gamePanel.getTileSize();
      final int[] cell = {
        (tileSize * 0), /*   0 */
        (tileSize * 1), /*  48 */
        (tileSize * 2), /*  96 */
        (tileSize * 3), /* 144 */
        (tileSize * 4), /* 192 */
        (tileSize * 5), /* 240 */
        (tileSize * 6)  /* 288 */
      };

      _graphics2D.drawImage(water, cell[0], cell[0], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[1], cell[0], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[2], cell[0], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[3], cell[0], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[4], cell[0], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[5], cell[0], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[6], cell[0], tileSize, tileSize, null);

      _graphics2D.drawImage(water, cell[0], cell[1], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[1], cell[1], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[2], cell[1], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[3], cell[1], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[4], cell[1], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[5], cell[1], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[6], cell[1], tileSize, tileSize, null);

      _graphics2D.drawImage(water, cell[0], cell[2], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[1], cell[2], tileSize, tileSize, null);
      _graphics2D.drawImage(grass, cell[2], cell[2], tileSize, tileSize, null);
      _graphics2D.drawImage(grass, cell[3], cell[2], tileSize, tileSize, null);
      _graphics2D.drawImage(grass, cell[4], cell[2], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[5], cell[2], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[6], cell[2], tileSize, tileSize, null);

      _graphics2D.drawImage(water, cell[0], cell[3], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[1], cell[3], tileSize, tileSize, null);
      _graphics2D.drawImage(grass, cell[2], cell[3], tileSize, tileSize, null);
      _graphics2D.drawImage(grass, cell[3], cell[3], tileSize, tileSize, null);
      _graphics2D.drawImage(grass, cell[4], cell[3], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[5], cell[3], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[6], cell[3], tileSize, tileSize, null);

      _graphics2D.drawImage(water, cell[0], cell[4], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[1], cell[4], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[2], cell[4], tileSize, tileSize, null);
      _graphics2D.drawImage(grass, cell[3], cell[4], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[4], cell[4], tileSize, tileSize, null);
      _graphics2D.drawImage(wall, cell[5], cell[4], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[6], cell[4], tileSize, tileSize, null);

      _graphics2D.drawImage(water, cell[0], cell[5], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[1], cell[5], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[2], cell[5], tileSize, tileSize, null);
      _graphics2D.drawImage(grass, cell[3], cell[5], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[4], cell[5], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[5], cell[5], tileSize, tileSize, null);
      _graphics2D.drawImage(water, cell[6], cell[5], tileSize, tileSize, null);

    }

  }
