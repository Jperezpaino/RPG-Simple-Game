package es.noa.rad;

import es.noa.rad.entity.Entity;

public class CollisionChecker {

  private GamePanel gamePanel;
  
  public CollisionChecker(
         final GamePanel gamePanel) {
    this.gamePanel = gamePanel;
  }

  public final void checkTile(
		 final Entity entity) {

    int entityLeftWorldX = (entity.worldX + entity.solidArea.x);
    int entityRightWorldX = (entity.worldX + entity.solidArea.x + entity.solidArea.width);
    int entityTopWorldY = (entity.worldY + entity.solidArea.y);
    int entityBottomWorldY = (entity.worldY + entity.solidArea.y + entity.solidArea.height);

    int entityLeftCol = (entityLeftWorldX / this.gamePanel.tileSize);
    int entityRightCol = (entityRightWorldX / this.gamePanel.tileSize);
    int entityTopRow = (entityTopWorldY / this.gamePanel.tileSize);
    int entityBottomRow = (entityBottomWorldY / this.gamePanel.tileSize);

    int tileNum1;
    int tileNum2;
    
    switch (entity.direction) {
      case "up":
        entityTopRow = ((entityTopWorldY - entity.speed) / this.gamePanel.tileSize);
    	tileNum1 = this.gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
    	tileNum2 = this.gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
    	if ((this.gamePanel.tileManager.tile[tileNum1]).collision 
    	 || (this.gamePanel.tileManager.tile[tileNum2]).collision) {
    	  entity.collisionOn = true;
    	}
      break;
      case "down":
      break; 
      case "left":
      break; 
      case "right":
      break; 
    }

    
  }

}
