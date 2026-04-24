/**
 * Package: es.noa.rad.game.rpgs2d.
 */
package es.noa.rad.game.rpgs2d;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;
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
    private final int fps = 60;

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
    private KeyHandler keyHandler;

    /* Set player´s default position. */

    /**
     *
     */
    private int playerX = ((this.screenWidth / 2) - (this.tileSize / 2));

    /**
     *
     */
    private int playerY = ((this.screenHeight / 2) - (this.tileSize / 2));

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
        new Dimension(this.screenWidth, this.screenHeight));
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

      /* 0.01666 Seconds. */
      final double drawInterval = (TimeUnit.SECONDS.toNanos(1) / this.fps);
      double deltaTime = 0;
      long lastTime = System.nanoTime();
      long currentTime;

      while (this.gameThread != null) {
        currentTime = System.nanoTime();
        deltaTime += ((currentTime - lastTime) / drawInterval);
        lastTime = currentTime;

        if (deltaTime >= 1) {
          /* 1.- UPDATE: Update information such as character positions. */
          this.update();
          /* 2.- DRAW: Draw the screen with the update information. */
          this.repaint();

          deltaTime--;
        }
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
        this.playerX, this.playerY, this.tileSize, this.tileSize);
      graphics2D.dispose();
    }

  }
