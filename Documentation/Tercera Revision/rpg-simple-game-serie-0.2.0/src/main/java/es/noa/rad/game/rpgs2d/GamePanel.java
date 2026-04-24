/**
 * Package: es.noa.rad.game.rpgs2d.
 */
package es.noa.rad.game.rpgs2d;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

  /**
   * @see javax.swing.JPanel
   * @see java.lang.Runnable
   */
  public class GamePanel
      extends JPanel
      implements Runnable {

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
    private Thread gameThread;

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

    /**
     *
     */
    public final void startGameThread() {
      this.gameThread = new Thread(this);
      this.gameThread.start();
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public final void run() {
      while (this.gameThread != null) {
        System.out.println("The game loop is running");
        /* 1.- UPDATE: Update information such as character positions. */
        /* 2.- DRAW: Draw the screen with the update information. */
      }
    }

  }
