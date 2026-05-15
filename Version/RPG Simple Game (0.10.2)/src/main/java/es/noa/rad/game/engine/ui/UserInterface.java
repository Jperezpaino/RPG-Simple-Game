package es.noa.rad.game.engine.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import es.noa.rad.game.engine.asset.object.KeyObject;
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
     *
     */
    private BufferedImage keyImage;

    /**
     *
     */
    public boolean messageActive;

    /**
     *
     */
    public String message;

    /**
     * @param _gamePanel {@code GamePanel}
     */
    public UserInterface(
        final GamePanel _gamePanel) {
      this.gamePanel = _gamePanel;
      this.arial40 = new Font("Arial", Font.PLAIN, 40);
      final KeyObject keyObject = new KeyObject();
      this.keyImage = keyObject.getImage();
      this.messageActive = false;
      this.message = "";
    }

    /**
     *
     * @param _message {@code String}
     */
    public final void showMessage(
           final String _message) {
      this.message = _message;
      this.messageActive = true;
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
      _graphics2D.drawImage(
        this.keyImage,
        (this.gamePanel.getTileSize() / 2),
        (this.gamePanel.getTileSize() / 2),
        this.gamePanel.getTileSize(),
        this.gamePanel.getTileSize(),
        null
      );
      _graphics2D.drawString(
        "x " + this.gamePanel.getPlayer().getPlayerInventory().getKey(),
        75, 65
      );

      /* Draw the messages. */
      if (this.messageActive) {
        _graphics2D.setFont(_graphics2D.getFont().deriveFont(30.0F));
        _graphics2D.setColor(Color.black);
        _graphics2D.drawString(
          this.message,
          (this.gamePanel.getMaxScreenRows() / 2),
          (this.gamePanel.getTileSize() * 5)
        );
      }

      /* Restores the entire graphical state. */
      _graphics2D.setFont(originalFont);
      _graphics2D.setColor(originalColor);
    }

  }
