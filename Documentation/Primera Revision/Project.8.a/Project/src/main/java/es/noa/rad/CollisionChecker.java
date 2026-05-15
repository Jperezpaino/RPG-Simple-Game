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
    	entityBottomRow = ((entityBottomWorldY + entity.speed) / this.gamePanel.tileSize);
      	tileNum1 = this.gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
      	tileNum2 = this.gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
      	if ((this.gamePanel.tileManager.tile[tileNum1]).collision 
      	 || (this.gamePanel.tileManager.tile[tileNum2]).collision) {
      	  entity.collisionOn = true;
      	}
      break; 
      case "left":
        entityLeftCol = ((entityLeftWorldX - entity.speed) / this.gamePanel.tileSize);
      	tileNum1 = this.gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
      	tileNum2 = this.gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
      	if ((this.gamePanel.tileManager.tile[tileNum1]).collision 
      	 || (this.gamePanel.tileManager.tile[tileNum2]).collision) {
      	  entity.collisionOn = true;
      	}
      break; 
      case "right":
        entityRightCol = ((entityRightWorldX + entity.speed) / this.gamePanel.tileSize);
      	tileNum1 = this.gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
      	tileNum2 = this.gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
      	if ((this.gamePanel.tileManager.tile[tileNum1]).collision 
      	 || (this.gamePanel.tileManager.tile[tileNum2]).collision) {
      	  entity.collisionOn = true;
      	}
      break; 
    }    
  }
  
  public final int checkObject(
         final Entity entity,
         final boolean player) {
    int index = 999;

    for (int i = 0; i < this.gamePanel.object.length; i++) {
      if (this.gamePanel.object[i] != null) {
    	/* Get entity's solid area position. */
    	entity.solidArea.x = entity.worldX + entity.solidArea.x;
    	entity.solidArea.y = entity.worldY + entity.solidArea.y;
  
    	/* Get the object´s solid area position. */
    	(this.gamePanel.object[i]).solidArea.x = (this.gamePanel.object[i]).worldX + (this.gamePanel.object[i]).solidArea.x;
    	(this.gamePanel.object[i]).solidArea.y = (this.gamePanel.object[i]).worldY + (this.gamePanel.object[i]).solidArea.y;

        switch (entity.direction) {
        case "up":
          entity.solidArea.y -= entity.speed;
          if (entity.solidArea.intersects((this.gamePanel.object[i]).solidArea)) {
        	System.out.println("Up Collision");
          } 	
          break;
        case "down":
          entity.solidArea.y += entity.speed;
          if (entity.solidArea.intersects((this.gamePanel.object[i]).solidArea)) {
        	System.out.println("Down Collision");
          }  
          break; 
        case "left":
          entity.solidArea.x -= entity.speed;
          if (entity.solidArea.intersects((this.gamePanel.object[i]).solidArea)) {
        	System.out.println("Left Collision");
          }    
          break; 
        case "right":
          entity.solidArea.x += entity.speed;
          if (entity.solidArea.intersects((this.gamePanel.object[i]).solidArea)) {
        	System.out.println("Right Collision");
          } 
          break; 
        }
        
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        (this.gamePanel.object[i]).solidArea.x = (this.gamePanel.object[i]).solidAreaDefaultX;
        (this.gamePanel.object[i]).solidArea.y = (this.gamePanel.object[i]).solidAreaDefaultY;

      }
    }

    return index;
  }

}
