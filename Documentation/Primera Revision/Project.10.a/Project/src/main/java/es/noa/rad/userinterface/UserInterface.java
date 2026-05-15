package es.noa.rad.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import es.noa.rad.GamePanel;

public class UserInterface {
  private GamePanel gamePanel;
  private Font arial40;

  public UserInterface(
         final GamePanel gamePanel) {
    this.gamePanel = gamePanel;
    this.arial40 = new Font("Arial", Font.PLAIN, 40);
  }	

  public final void draw(
         final Graphics2D graphics2D) {
    graphics2D.setFont(this.arial40);
	graphics2D.setColor(Color.white);
	graphics2D.drawString("Key = " + this.gamePanel.player.hasKey, 50, 50);	
  }
  
}
