package es.noa.rad.object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import es.noa.rad.GamePanel;

public class SuperObject {
  public BufferedImage image;
  public String name;
  public boolean collision;
  public int worldX;
  public int worldY;
  public Rectangle solidArea;
  public int solidAreaDefaultX;
  public int solidAreaDefaultY;

  public SuperObject() {
    super();
    this.collision = false;
    this.solidArea = new Rectangle(0, 0, 48, 48);
    this.solidAreaDefaultX = 0;
    this.solidAreaDefaultY = 0;
  }

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
