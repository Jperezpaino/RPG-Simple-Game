package es.noa.rad.game.engine.core.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import es.noa.rad.game.engine.event.KeyHandler;

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
    private KeyHandler keyHandler;

    /* Set player´s default position. */

    /**
     *
     */
    private int playerX
      = ((GamePanel.SCREEN_WIDTH / 2) - (GamePanel.TILE_SIZE  / 2));

    /**
     *
     */
    private int playerY
      = ((GamePanel.SCREEN_HEIGHT / 2) - (GamePanel.TILE_SIZE  / 2));

    /**
     *
     */
    private int playerSpeed = 4;

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
      this.setFocusable(true);

      this.keyHandler = new KeyHandler();
      this.addKeyListener(this.keyHandler);
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
        System.out.println(
          "Player Position: (" + this.playerX + ", "+ this.playerY +")");
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
      if (this.keyHandler.isUpPressed()) {
        this.playerY -= this.playerSpeed;
        /* this.playerY = this.playerY - this.playerSpeed; */
      } else if (this.keyHandler.isDownPressed()) {
        this.playerY += this.playerSpeed;
        /* this.playerY = this.playerY + this.playerSpeed; */
      } else if (this.keyHandler.isLeftPressed()) {
        this.playerX -= this.playerSpeed;
        /* this.playerX = this.playerX - this.playerSpeed; */
      } else if (this.keyHandler.isRightPressed()) {
        this.playerX += this.playerSpeed;
        /* this.playerX = this.playerX + this.playerSpeed; */
      }
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
        this.playerX,
        this.playerY,
        GamePanel.TILE_SIZE,
        GamePanel.TILE_SIZE
      );
      graphics2D.dispose();
    }

  }
