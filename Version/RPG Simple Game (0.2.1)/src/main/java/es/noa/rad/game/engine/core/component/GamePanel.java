package es.noa.rad.game.engine.core.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
      while (this.gameThread != null) {
        System.out.println("The game loop is running");
        /* 1.- UPDATE: Update information such as character positions. */
        this.update();
        /* 2.- DRAW: Draw the screen with the update information. */
        this.repaint();
      }
    }

    /**
     *
     */
    public final void update() {
    }

    /**
     * {@inheritDoc}
     *
     * @see javax.swing.JPanel#paintComponents(java.awt.Graphics)
     */
    @Override
    public final void paintComponent(
        final Graphics _graphics) {
      super.paintComponent(_graphics);

      final Graphics2D graphics2D = ((Graphics2D) _graphics);
      graphics2D.setColor(Color.white);
      graphics2D.fillRect(
        ((GamePanel.SCREEN_WIDTH / 2) - (GamePanel.TILE_SIZE / 2)),
        ((GamePanel.SCREEN_HEIGHT / 2) - (GamePanel.TILE_SIZE / 2)),
        GamePanel.TILE_SIZE,
        GamePanel.TILE_SIZE
      );
      graphics2D.dispose();
    }

  }
