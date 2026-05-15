package es.noa.rad;

import es.noa.rad.object.ObjectKey;

public class AssetSetter {

   private GamePanel gamePanel;

   public AssetSetter(
          final GamePanel gamePanel) {
     this.gamePanel = gamePanel;
   }

   public final void setObject() {
     this.gamePanel.object[0] = new ObjectKey();
     (this.gamePanel.object[0]).worldX = 23 * this.gamePanel.tileSize;
     (this.gamePanel.object[0]).worldY = 7 * this.gamePanel.tileSize;
     
     this.gamePanel.object[1] = new ObjectKey();
     (this.gamePanel.object[1]).worldX = 23 * this.gamePanel.tileSize;
     (this.gamePanel.object[1]).worldY = 40 * this.gamePanel.tileSize;     
   }
   
  }
