package es.noa.rad;

import es.noa.rad.object.ObjectBoots;
import es.noa.rad.object.ObjectChest;
import es.noa.rad.object.ObjectDoor;
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
     
     this.gamePanel.object[2] = new ObjectKey();
     (this.gamePanel.object[2]).worldX = 38 * this.gamePanel.tileSize;
     (this.gamePanel.object[2]).worldY = 8 * this.gamePanel.tileSize; 
     
     this.gamePanel.object[3] = new ObjectDoor();
     (this.gamePanel.object[3]).worldX = 10 * this.gamePanel.tileSize;
     (this.gamePanel.object[3]).worldY = 11 * this.gamePanel.tileSize;  
     
     this.gamePanel.object[4] = new ObjectDoor();
     (this.gamePanel.object[4]).worldX = 8 * this.gamePanel.tileSize;
     (this.gamePanel.object[4]).worldY = 28 * this.gamePanel.tileSize;  
     
     this.gamePanel.object[5] = new ObjectDoor();
     (this.gamePanel.object[5]).worldX = 12 * this.gamePanel.tileSize;
     (this.gamePanel.object[5]).worldY = 22 * this.gamePanel.tileSize;  
     
     this.gamePanel.object[6] = new ObjectChest();
     (this.gamePanel.object[6]).worldX = 10 * this.gamePanel.tileSize;
     (this.gamePanel.object[6]).worldY = 7 * this.gamePanel.tileSize;
    
     this.gamePanel.object[7] = new ObjectBoots();
     (this.gamePanel.object[7]).worldX = 37 * this.gamePanel.tileSize;
     (this.gamePanel.object[7]).worldY = 42 * this.gamePanel.tileSize;
   }
   
  }
