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
import es.noa.rad.game.rpgs2d.entity.Player;
import es.noa.rad.game.rpgs2d.tile.TileManager;

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
    private final int maxWorldColumns = 50;

    /**
     *
     */
    private final int maxScreenRows = 12;

    /**
     *
     */
    private final int maxWorldRows = 50;

    /**
     *
     */
    private final int screenWidth = this.tileSize * this.maxScreenColumns;

    /**
     *
     */
    private final int worldWidth = (this.tileSize * this.maxWorldColumns);

    /**
     *
     */
    private final int screenHeight = this.tileSize * this.maxScreenRows;

    /**
     *
     */
    private final int worldHeight = (this.tileSize * this.maxWorldRows);


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
    private TileManager tileManager;

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
        new Dimension(this.screenWidth, this.screenHeight));
      this.setBackground(Color.black);
      this.setDoubleBuffered(true);
      this.setFocusable(true);

      this.keyHandler = new KeyHandler();
      this.addKeyListener(this.keyHandler);

      this.tileManager = new TileManager(this);
      this.player = new Player(this, this.keyHandler);
    }

    /**
     * @return {@code int}
     */
    public final int getTileSize() {
      return this.tileSize;
    }

    /**
     * @return {@code int}
     */
    public final int getMaxScreenColumns() {
      return this.maxScreenColumns;
    }

    /**
     * @return {@code int}
     */
    public final int getMaxWorldColumns() {
      return this.maxWorldColumns;
    }

    /**
     * @return {@code int}
     */
    public final int getMaxScreenRows() {
      return this.maxScreenRows;
    }

    /**
     * @return {@code int}
     */
    public final int getMaxWorldRows() {
      return this.maxWorldRows;
    }

    /**
     * @return {@code int}
     */
    public final int getScreenWidth() {
      return this.screenWidth;
    }

    /**
     * @return {@code int}
     */
    public final int getWorldWidth() {
      return this.worldWidth;
    }

    /**
     * @return {@code int}
     */
    public final int getScreenHeight() {
        return this.screenHeight;
    }

    /**
     * @return {@code int}
     */
    public final int getWorldHeight() {
        return this.worldHeight;
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
      final double drawInterval = (TimeUnit.SECONDS.toNanos(1) / this.fps);
      double deltaTime = 0;
      long lastTime = System.nanoTime();
      long currentTime;
      long timer = 0;
      long drawCount = 0;

      while (this.gameThread != null) {
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
      this.tileManager.draw(graphics2D);
      this.player.draw(graphics2D);
      graphics2D.dispose();
    }

  }
