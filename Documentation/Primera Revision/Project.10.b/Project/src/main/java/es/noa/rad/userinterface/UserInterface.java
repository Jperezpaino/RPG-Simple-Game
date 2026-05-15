package es.noa.rad.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import es.noa.rad.GamePanel;
import es.noa.rad.object.ObjectKey;

public class UserInterface {
  private GamePanel gamePanel;
  private Font arial40;
  private BufferedImage keyImage;

  public UserInterface(
         final GamePanel gamePanel) {
    this.gamePanel = gamePanel;
    this.arial40 = new Font("Arial", Font.PLAIN, 40);
    final ObjectKey key = new ObjectKey();
    this.keyImage = key.image;
  }	

  public final void draw(
         final Graphics2D graphics2D) {
    graphics2D.setFont(this.arial40);
	graphics2D.setColor(Color.white);
	graphics2D.drawImage(this.keyImage, (this.gamePanel.tileSize / 2), (this.gamePanel.tileSize / 2), this.gamePanel.tileSize, this.gamePanel.tileSize, null);
	graphics2D.drawString("x " + this.gamePanel.player.hasKey, 75, 65);	
  }
  
}
