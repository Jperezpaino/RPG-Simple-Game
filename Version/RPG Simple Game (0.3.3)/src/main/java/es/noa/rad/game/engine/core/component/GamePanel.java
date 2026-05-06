package es.noa.rad.game.engine.core.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import es.noa.rad.game.engine.entity.Player;
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
    private static final int FPS = 60;

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

    /**
     *
     */
    private Player player;

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

      this.player = new Player(this, this.keyHandler);
    }

    /**
     * @return {@code int}
     */
    public final int getTileSize() {
      return GamePanel.TILE_SIZE;
    }

    /**
     * @return {@code int}
     */
    public final int getMaxScreenColumns() {
      return GamePanel.MAX_SCREEN_COLUMNS;
    }

    /**
     * @return {@code int}
     */
    public final int getMaxScreenRows() {
      return GamePanel.MAX_SCREEN_ROWS;
    }

    /**
     * @return {@code int}
     */
    public final int getScreenWidth() {
      return GamePanel.SCREEN_WIDTH;
    }

    /**
     * @return {@code int}
     */
    public final int getScreenHeight() {
        return GamePanel.SCREEN_HEIGHT;
    }

    /**
     * @return {@code Player}
     */
    public final Player getPlayer() {
      return this.player;
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
      final double drawInterval = (TimeUnit.SECONDS.toNanos(1) / GamePanel.FPS);
      double deltaTime = 0;
      long lastTime = System.nanoTime();
      long currentTime;
      long timer = 0;
      long drawCount = 0;

      while (this.gameThread != null) {
        /* Delta / Accumulator method. */
        currentTime = System.nanoTime();
        deltaTime += ((currentTime - lastTime) / drawInterval);
        timer += (currentTime - lastTime);
        lastTime = currentTime;

        if (deltaTime >= 1) {
          /* 1.- UPDATE: Update information such as character positions. */
          this.update();
          /* 2.- DRAW: Draw the screen with the update information. */
          this.repaint();

          deltaTime--;
          drawCount++;
        }

        if (timer >= TimeUnit.SECONDS.toNanos(1)) {
          System.out.println("FPS: " + drawCount);
          drawCount = 0;
          timer = 0;
        }

      }
    }

    /**
     *
     */
    public final void update() {
      this.player.update();
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
      this.player.draw(graphics2D);
      graphics2D.dispose();
    }

  }
