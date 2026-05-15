package es.noa.rad.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import es.noa.rad.GamePanel;
import es.noa.rad.KeyHandler;

public class Player extends Entity {
  protected GamePanel gamePanel;
  protected KeyHandler keyHandler;
  
  public final int screenX;
  public final int screenY;

  public Player(
         final GamePanel gamePanel,
         final KeyHandler keyHandler) {
    super();
    this.gamePanel = gamePanel;
    this.keyHandler = keyHandler;
    
    this.screenX = ((this.gamePanel.screenWidth / 2) - (this.gamePanel.tileSize / 2));
    this.screenY = ((this.gamePanel.screenHeight / 2) - (this.gamePanel.tileSize / 2));

    super.solidArea = new Rectangle();
    super.solidArea.x = 8;
    super.solidArea.y = 16;
    this.solidAreaDefaultX = this.solidArea.x;
    this.solidAreaDefaultY = this.solidArea.y;
    super.solidArea.width = 32;
    super.solidArea.height = 32;

    this.setDefaultValues();
    this.getPlayerImage();
  }
  
  public final void setDefaultValues() {
    super.worldX = this.gamePanel.tileSize * 23;
    super.worldY = this.gamePanel.tileSize * 21;
    super.speed = 4;
    super.direction = "down";
  }
  
  public void getPlayerImage() {
    try {
      super.up1 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/player/walking/boy_up_1.png"));
      super.up2 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/player/walking/boy_up_2.png"));
      super.down1 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/player/walking/boy_down_1.png"));
      super.down2 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/player/walking/boy_down_2.png"));
      super.left1 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/player/walking/boy_left_1.png"));
      super.left2 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/player/walking/boy_left_2.png"));
      super.right1 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/player/walking/boy_right_1.png"));
      super.right2 = ImageIO.read(getClass().getResourceAsStream("/assets/entity/player/walking/boy_right_2.png"));
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
  }
  
  public final void update() {
	if (this.keyHandler.upPressed
      || this.keyHandler.downPressed
      || this.keyHandler.leftPressed
      || this.keyHandler.rightPressed) {	  
      if(this.keyHandler.upPressed == true) {
        super.direction = "up";
      } else if (this.keyHandler.downPressed == true) {
        super.direction = "down";
      } else if (this.keyHandler.leftPressed == true) {        
        super.direction = "left";
      } else if (this.keyHandler.rightPressed == true) {
        super.direction = "right";
      } 
    
      /* Check the collisions between the player and the destination tile. */
      super.collisionOn = false;
      this.gamePanel.collisionChecker.checkTile(this);

      /* if collision is false, player can move. */
      if (!this.collisionOn) {
   	    switch (direction) {
   	      case "up":
   	    	this.worldY -= this.speed;
   	      break;   	      
   	      case "down":
   	    	this.worldY += this.speed;
   	      break; 
   	      case "left":
   	    	 this.worldX -= this.speed;
   	      break; 
   	      case "right":
   	    	this.worldX += this.speed;
   	      break; 
   	    }
      }
      
      /* Check the collisions between the player and the objects. */
      int objectIndex = this.gamePanel.collisionChecker.checkObject(this, true);

      super.spriteCounter++;
      if (this.spriteCounter > 12) {
        if (this.spriteNum == 1) {
    	  this.spriteNum = 2;
        } else if (this.spriteNum == 2) {
          this.spriteNum = 1;
        } 
        this.spriteCounter = 0;
      }
	}
  }
  
  public final void draw(
         final Graphics2D graphics2D) {
    
    BufferedImage image = null;

    switch (super.direction) {
      case "up":
        if (super.spriteNum == 1) {          
          image = up1;
        } else if (super.spriteNum == 2) {
          image = up2;
        }
      break;
      case "down":
        if (super.spriteNum == 1) {  
          image = down1;
        } else if (super.spriteNum == 2) {
          image = down2;
        }
      break;
      case "left":
        if (super.spriteNum == 1) {  
          image = left1;
        } else if (super.spriteNum == 2) {
          image = left2;
        }
      break;
      case "right":
        if (super.spriteNum == 1) {  
          image = right1;
        } else if (super.spriteNum == 2) {
          image = right2;
        }
      break;
    }

    graphics2D.drawImage(image, this.screenX, this.screenY, this.gamePanel.tileSize, this.gamePanel.tileSize, null);    

  }
}
