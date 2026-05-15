package es.noa.rad.game.engine.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import es.noa.rad.game.engine.core.component.GamePanel;

  /**
   *
   */
  public class UserInterface {

    /**
     *
     */
    private GamePanel gamePanel;

    /**
     *
     */
    private Font arial40;

    /**
     * @param _gamePanel {@code GamePanel}
     */
    public UserInterface(
        final GamePanel _gamePanel) {
      this.gamePanel = _gamePanel;
      this.arial40 = new Font("Arial", Font.PLAIN, 40);
    }

    /**
     * @param _graphics2D {@code Graphics2D}
     */
    public final void draw(
        final Graphics2D _graphics2D) {
      /* Keep original conditions. */
      final Color originalColor = _graphics2D.getColor();
      final Font originalFont = _graphics2D.getFont();

      _graphics2D.setFont(this.arial40);
      _graphics2D.setColor(Color.gray);
      _graphics2D.drawString(
        "Key = " + this.gamePanel.getPlayer().getPlayerInventory().getKey(),
        25, 50
      );

      /* Restores the entire graphical state. */
      _graphics2D.setFont(originalFont);
      _graphics2D.setColor(originalColor);
    }

  }
