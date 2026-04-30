/**
 * Package: es.noa.rad.game.rpgs2d.tile.
 */
package es.noa.rad.game.rpgs2d.tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    private Tile[] tiles;

    /**
     *
     */
    private int[][] mapTileData;

    /**
     * @param _gamePanel {@code GamePanel}
     */
    public TileManager(
        final GamePanel _gamePanel) {
      this.gamePanel = _gamePanel;

      this.tiles = new Tile[10];

      final int mapWidth = this.gamePanel.getMaxScreenColumns();
      final int mapHeight = this.gamePanel.getMaxScreenRows();
      this.mapTileData = new int[mapWidth][mapHeight];

      this.getTileImage();
      this.getMapData("/assets/map/map01.txt");
    }

    /**
     *
     */
    public final void getTileImage() {
      try {
        this.tiles[0] = new Tile(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/map/tiles/grass.png")));
        this.tiles[1] = new Tile();
        (this.tiles[1]).setImage(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/map/tiles/wall.png")));
        this.tiles[2] = new Tile();
        (this.tiles[2]).setImage(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/map/tiles/water.png")));
      } catch (
          final IOException iOException) {
        iOException.printStackTrace();
      }
    }

    /**
     * @param _mapFilePath {@code String}
     */
    public final void getMapData(
        final String _mapFilePath) {
      try {
        final InputStream inputStream
          = this.getClass().getResourceAsStream(_mapFilePath);
        final BufferedReader bufferedReader
          = new BufferedReader(new InputStreamReader(inputStream));

        int column = 0;
        int row = 0;

        while ((column < this.gamePanel.getMaxScreenColumns())
            && (row < this.gamePanel.getMaxScreenRows())) {
          final String line = bufferedReader.readLine();
          while (column < this.gamePanel.getMaxScreenColumns()) {
            final String[] numbers = line.split(" ");
            int num = Integer.parseInt(numbers[column]);
            this.mapTileData[column][row] = num;
            column++;
          }
          if (column == this.gamePanel.getMaxScreenColumns()) {
            column = 0;
            row++;
          }
        }
        bufferedReader.close();
      } catch (
          final Exception exception) {
        exception.printStackTrace();
      }
    }

    /**
     * @param _graphics2D {@code Graphics2D}
     */
    public final void draw(
        final Graphics2D _graphics2D) {

      int column = 0;
      int row = 0;
      int x = 0;
      int y = 0;

      while ((column < this.gamePanel.getMaxScreenColumns())
         && (row < this.gamePanel.getMaxScreenRows())) {
        final int tileNum = this.mapTileData[column][row];
        _graphics2D.drawImage(
          (this.tiles[tileNum]).getImage(),
          x, y,
          this.gamePanel.getTileSize(),
          this.gamePanel.getTileSize(),
          null
        );
        column++;
        x += this.gamePanel.getTileSize();
        if (column == this.gamePanel.getMaxScreenColumns()) {
          column = 0;
          x = 0;
          row++;
          y += this.gamePanel.getTileSize();
        }
      }
    }

  }
