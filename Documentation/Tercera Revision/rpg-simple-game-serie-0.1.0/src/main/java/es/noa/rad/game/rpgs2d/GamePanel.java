/**
 * Package: es.noa.rad.game.rpgs2d.
 */
package es.noa.rad.game.rpgs2d;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

  /**
   * @see javax.swing.JPanel
   */
  public class GamePanel
      extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private final int originalTileSize = 16;

    /**
     *
     */
    private final int scale = 3;

    /**
     *
     */
    private final int tileSize = this.originalTileSize * this.scale;

    /**
     *
     */
    private final int maxScreenColumns = 16;

    /**
     *
     */
    private final int maxScreenRows = 12;

    /**
     *
     */
    private final int screenWidth = this.tileSize * this.maxScreenColumns;

    /**
     *
     */
    private final int screenHeight = this.tileSize * this.maxScreenRows;

    /**
     *
     */
    public GamePanel() {
      super();
      this.setPreferredSize(
        new Dimension(this.screenWidth, this.screenHeight));
      this.setBackground(Color.black);
      this.setDoubleBuffered(true);
    }

  }
