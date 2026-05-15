package es.noa.rad.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import es.noa.rad.GamePanel;

public class SuperObject {
  public BufferedImage image;
  public String name;
  public boolean collision = false;
  public int worldX;
  public int worldY;
  
  public void draw(
         final Graphics2D graphics2D,
         final GamePanel gamePanel) {
	  
    int screenX = (worldX - gamePanel.player.worldX + gamePanel.player.screenX);
    int screenY = (worldY - gamePanel.player.worldY + gamePanel.player.screenY);
    
    if ((worldX + gamePanel.tileSize) > (gamePanel.player.worldX - gamePanel.player.screenX)
     && (worldX - gamePanel.tileSize) < (gamePanel.player.worldX + gamePanel.player.screenX)
     && (worldY + gamePanel.tileSize) > (gamePanel.player.worldY - gamePanel.player.screenY)
     && (worldY - gamePanel.tileSize) < (gamePanel.player.worldY + gamePanel.player.screenY)) {
     graphics2D.drawImage(this.image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
  }

}
