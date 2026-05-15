package es.noa.rad.game.engine.map.tile;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import es.noa.rad.game.engine.core.component.GamePanel;

  /**
   *
   */
  public class TileManager {

    /**
     *
     */
    private static final int MAX_NUM_TILES = 82;

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

      this.tiles = new Tile[TileManager.MAX_NUM_TILES];

      final int mapWidth = this.gamePanel.getMaxWorldColumns();
      final int mapHeight = this.gamePanel.getMaxWorldRows();
      this.mapTileData = new int[mapWidth][mapHeight];

      this.getTileImage();
      this.getMapData("/assets/map/world/map-01.txt");
    }

    /**
     *
     */
    public final void getTileImage() {
      try {
        final InputStream inputStream
          = this.getClass().getResourceAsStream("/assets/map/world/tile.info");
        final BufferedReader bufferedReader
          = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
          String[] parts = line.split(",");
          if ((!line.isBlank())
           && (parts.length >= 4)) {
            final int idTile = Integer.parseInt(parts[0].trim());
            /* final String nameTile = parts[1].trim(); */
            final String imagePathTile = parts[2].trim();
            final boolean isCollisionTile = Boolean.parseBoolean(parts[3].trim());
            this.tiles[idTile] = new Tile();
            (this.tiles[idTile]).setImage(
              ImageIO.read(this.getClass().getResourceAsStream(imagePathTile)));
            (this.tiles[idTile]).setCollision(isCollisionTile);
          }
        }
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

        if (((worldX + tileSize) > (playerWorldX - playerScreenX))
         && ((worldX - tileSize) < (playerWorldX + playerScreenX))
         && ((worldY + tileSize) > (playerWorldY - playerScreenY))
         && ((worldY - tileSize) < (playerWorldY + playerScreenY))) {
          _graphics2D.drawImage(
            (this.tiles[tileNum]).getImage(),
            screenX,
            screenY,
            tileSize,
            tileSize,
            null
          );
          if (this.gamePanel.isDebug()) {
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

            /* Draw the tile's collision state. */
            if ((this.tiles[tileNum]).isCollision()) {
              _graphics2D.setColor(Tile.COLOR_COLLISION_ON);
            } else {
              _graphics2D.setColor(Tile.COLOR_COLLISION_OFF);
            }
            _graphics2D.fillRect(
              screenX,
              screenY,
              tileSize,
              tileSize
            );

            /* Draw the tile ID. */
            final Font boldFont = originalFont.deriveFont(Font.BOLD);
            _graphics2D.setFont(boldFont);
            final int positionX = 2;
            final int positionY = (2 + _graphics2D.getFontMetrics().getAscent());
            _graphics2D.setColor(Color.blue);
            _graphics2D.drawString(
              String.valueOf(tileNum),
              (screenX + positionX),
              (screenY + positionY)
            );

            /* Draw the tile's bounding box. */
            _graphics2D.setColor(Color.blue);
            _graphics2D.drawRect(
              screenX,
              screenY,
              tileSize,
              tileSize
            );

            /* Restores the entire graphical state. */
            _graphics2D.setFont(originalFont);
            _graphics2D.setComposite(originalComposite);
            _graphics2D.setColor(originalColor);
          }
        }

        worldColumn++;
        if (worldColumn == this.gamePanel.getMaxWorldColumns()) {
          worldColumn = 0;
          worldRow++;
        }
      }
    }

  }
