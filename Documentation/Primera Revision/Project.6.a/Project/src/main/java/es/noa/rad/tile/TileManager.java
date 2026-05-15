package es.noa.rad.tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import es.noa.rad.GamePanel;

public class TileManager {
  GamePanel gamePanel;
  public Tile[] tile;
  public int[][] mapTileNum;

  public TileManager(
         final GamePanel gamePanel) {
    this.gamePanel = gamePanel;
  
    this.tile = new Tile[10];
    this.mapTileNum = new int[this.gamePanel.maxWorldCol][this.gamePanel.maxWorldRow];

    this.getTileImage();
    this.loadMap("/assets/map/world01.txt");
  }
  
  public final void getTileImage() {
    try {

      this.tile[0] = new Tile();
      (this.tile[0]).image = ImageIO.read(getClass().getResourceAsStream("/assets/map/tiles/grass.png"));
      (this.tile[0]).collision = false;
      
      this.tile[1] = new Tile();
      (this.tile[1]).image = ImageIO.read(getClass().getResourceAsStream("/assets/map/tiles/wall.png"));
      (this.tile[1]).collision = true;
      
      this.tile[2] = new Tile();
      (this.tile[2]).image = ImageIO.read(getClass().getResourceAsStream("/assets/map/tiles/water.png"));
      (this.tile[2]).collision = true;
      
      this.tile[3] = new Tile();
      (this.tile[3]).image = ImageIO.read(getClass().getResourceAsStream("/assets/map/tiles/earth.png"));
      (this.tile[3]).collision = false;
      
      this.tile[4] = new Tile();
      (this.tile[4]).image = ImageIO.read(getClass().getResourceAsStream("/assets/map/tiles/tree.png"));
      (this.tile[4]).collision = true;
      
      this.tile[5] = new Tile();
      (this.tile[5]).image = ImageIO.read(getClass().getResourceAsStream("/assets/map/tiles/sand.png"));
      (this.tile[5]).collision = false;
      
    } catch (IOException iOException) {
      iOException.printStackTrace();
    }
  }

  public final void loadMap(
         final String filePath) {
    try {
      final InputStream inputStream
        = this.getClass().getResourceAsStream(filePath);
      final BufferedReader bufferedReader
        = new BufferedReader(new InputStreamReader(inputStream));
    
      int col = 0;
      int row = 0;

      while (col < this.gamePanel.maxWorldCol && row < this.gamePanel.maxWorldRow) {
        String line = bufferedReader.readLine();
        while (col < this.gamePanel.maxWorldCol) {
          String[] numbers = line.split(" ");
          int num = Integer.parseInt(numbers[col]);
          this.mapTileNum[col][row] = num;
          col++;
        }
        if (col == this.gamePanel.maxWorldCol) {
          col = 0;
          row++;
        } 
      }
      bufferedReader.close();
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
  
  public final void draw(
         final Graphics2D g2) {      
	int worldCol = 0;
	int worldRow = 0;

    while(worldCol < this.gamePanel.maxWorldCol && worldRow < this.gamePanel.maxWorldRow) {
      
      int tileNum = this.mapTileNum[worldCol][worldRow];
      
      int worldX = (worldCol * this.gamePanel.tileSize);
      int worldY = (worldRow * this.gamePanel.tileSize);
      int screenX = (worldX - this.gamePanel.player.worldX + this.gamePanel.player.screenX);
      int screenY = (worldY - this.gamePanel.player.worldY + this.gamePanel.player.screenY);
      
      if ((worldX + this.gamePanel.tileSize) > (this.gamePanel.player.worldX - this.gamePanel.player.screenX)
        && (worldX - this.gamePanel.tileSize) < (this.gamePanel.player.worldX + this.gamePanel.player.screenX)
        && (worldY + this.gamePanel.tileSize) > (this.gamePanel.player.worldY - this.gamePanel.player.screenY)
        && (worldY - this.gamePanel.tileSize) < (this.gamePanel.player.worldY + this.gamePanel.player.screenY)) {
      
        g2.drawImage((this.tile[tileNum]).image, screenX, screenY, this.gamePanel.tileSize, this.gamePanel.tileSize, null);
      }

      worldCol++;

      if(worldCol == this.gamePanel.maxWorldCol) {
    	worldCol = 0;
        worldRow++;
      }
    }

  }

}
