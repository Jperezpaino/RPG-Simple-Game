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

      final int mapWidth = this.gamePanel.getMaxWorldColumns();
      final int mapHeight = this.gamePanel.getMaxWorldRows();
      this.mapTileData = new int[mapWidth][mapHeight];

      this.getTileImage();
      this.getMapData("/assets/map/world01.txt");
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
        this.tiles[3] = new Tile();
        (this.tiles[3]).setImage(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/map/tiles/earth.png")));
        this.tiles[4] = new Tile();
        (this.tiles[4]).setImage(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/map/tiles/tree.png")));
        this.tiles[5] = new Tile();
        (this.tiles[5]).setImage(
          ImageIO.read(this.getClass().getResourceAsStream(
            "/assets/map/tiles/sand.png")));
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

        while ((column < this.gamePanel.getMaxWorldColumns())
            && (row < this.gamePanel.getMaxWorldRows())) {
          final String line = bufferedReader.readLine();
          while (column < this.gamePanel.getMaxWorldColumns()) {
            final String[] numbers = line.split(" ");
            int num = Integer.parseInt(numbers[column]);
            this.mapTileData[column][row] = num;
            column++;
          }
          if (column == this.gamePanel.getMaxWorldColumns()) {
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

      int worldColumn = 0;
      int worldRow = 0;

      final int playerWorldX = this.gamePanel.getPlayer().getWorldX();
      final int playerWorldY = this.gamePanel.getPlayer().getWorldY();
      final int playerScreenX = this.gamePanel.getPlayer().getScreenX();
      final int playerScreenY = this.gamePanel.getPlayer().getScreenY();
      final int tileSize = this.gamePanel.getTileSize();

      while ((worldColumn < this.gamePanel.getMaxWorldColumns())
         && (worldRow < this.gamePanel.getMaxWorldRows())) {
        final int tileNum = this.mapTileData[worldColumn][worldRow];

        final int worldX = (worldColumn * this.gamePanel.getTileSize());
        final int worldY = (worldRow * this.gamePanel.getTileSize());

        final int screenX = (worldX - playerWorldX + playerScreenX);
        final int screenY = (worldY - playerWorldY + playerScreenY);

        if (worldX + tileSize > (playerWorldX - playerScreenX)
         && worldX - tileSize < (playerWorldX + playerScreenX)
         && worldY + tileSize > (playerWorldY - playerScreenY)
         && worldY - tileSize < (playerWorldY + playerScreenY)) {
          _graphics2D.drawImage(
            (this.tiles[tileNum]).getImage(),
            screenX, screenY,
            tileSize, tileSize,
            null
          );
        }

        worldColumn++;
        if (worldColumn == this.gamePanel.getMaxWorldColumns()) {
          worldColumn = 0;
          worldRow++;
        }
      }
    }

  }
