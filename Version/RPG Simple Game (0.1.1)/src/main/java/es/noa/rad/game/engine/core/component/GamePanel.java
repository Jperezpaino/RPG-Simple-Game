package es.noa.rad.game.engine.core.component;

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
    private static final int ORIGINAL_TILE_SIZE = 16;

    /**
     *
     */
    private static final int SCALE = 3;

    /**
     *
     */
    private static final int TILE_SIZE
      = (GamePanel.ORIGINAL_TILE_SIZE * GamePanel.SCALE);

    /**
     *
     */
    private static final int MAX_SCREEN_COLUMNS = 32;

    /**
     *
     */
    private static final int MAX_SCREEN_ROWS = 16;

    /**
     *
     */
    private static final int SCREEN_WIDTH
      = (GamePanel.TILE_SIZE * GamePanel.MAX_SCREEN_COLUMNS);

    /**
     *
     */
    private static final int SCREEN_HEIGHT
      = (GamePanel.TILE_SIZE * GamePanel.MAX_SCREEN_ROWS);

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
        new Dimension(
          GamePanel.SCREEN_WIDTH,
          GamePanel.SCREEN_HEIGHT
        )
      );
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
      System.out.println("Start Game Loop");
    }

  }
