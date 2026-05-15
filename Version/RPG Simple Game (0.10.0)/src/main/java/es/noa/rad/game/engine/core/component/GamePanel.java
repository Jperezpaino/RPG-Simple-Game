package es.noa.rad.game.engine.core.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import es.noa.rad.game.engine.asset.AssetSetter;
import es.noa.rad.game.engine.asset.object.ObjectEntity;
import es.noa.rad.game.engine.core.physic.Collision;
import es.noa.rad.game.engine.entity.Player;
import es.noa.rad.game.engine.event.KeyHandler;
import es.noa.rad.game.engine.map.tile.TileManager;
import es.noa.rad.game.engine.sound.Sound;
import es.noa.rad.game.engine.ui.UserInterface;

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
    private static final boolean DEBUG = false;

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
    private static final int MAX_WORLD_COLUMNS = 40;

    /**
     *
     */
    private static final int MAX_SCREEN_ROWS = 16;

    /**
     *
     */
    private static final int MAX_WORLD_ROWS = 32;

    /**
     *
     */
    private static final int SCREEN_WIDTH
      = (GamePanel.TILE_SIZE * GamePanel.MAX_SCREEN_COLUMNS);

    /**
     *
     */
    private static final int WORLD_WIDTH
      = (GamePanel.TILE_SIZE * GamePanel.MAX_WORLD_COLUMNS);

    /**
     *
     */
    private static final int SCREEN_HEIGHT
      = (GamePanel.TILE_SIZE * GamePanel.MAX_SCREEN_ROWS);

    /**
     *
     */
    private static final int WORLD_HEIGHT
      = (GamePanel.TILE_SIZE * GamePanel.MAX_WORLD_ROWS);

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
    private ObjectEntity[] objectManager;

    /**
     *
     */
    private UserInterface userInterface;

    /**
     *
     */
    private Collision collision;

    /**
     *
     */
    private AssetSetter assetSetter;

    /**
     *
     */
    private Sound music;

    /**
     *
     */
    private Sound soundEffect;

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

      this.tileManager = new TileManager(this);
      this.player = new Player(this, this.keyHandler);
      this.objectManager = new ObjectEntity[ObjectEntity.MAX_NUM_OBJECTS];
      this.userInterface = new UserInterface(this);

      this.collision = new Collision(this);
      this.assetSetter = new AssetSetter(this);

      this.music = new Sound();
      this.soundEffect = new Sound();
    }

    /**
     * @return {@code boolean}
     */
    public final boolean isDebug() {
      return GamePanel.DEBUG;
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
    public final int getMaxWorldColumns() {
      return GamePanel.MAX_WORLD_COLUMNS;
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
    public final int getMaxWorldRows() {
      return GamePanel.MAX_WORLD_ROWS;
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
    public final int getWorldWidth() {
      return GamePanel.WORLD_WIDTH;
    }

    /**
     * @return {@code int}
     */
    public final int getScreenHeight() {
      return GamePanel.SCREEN_HEIGHT;
    }

    /**
     * @return {@code int}
     */
    public final int getWorldHeight() {
      return GamePanel.WORLD_HEIGHT;
    }

    /**
     * @return {@code TileManager}
     */
    public final TileManager getTileManager() {
      return this.tileManager;
    }

    /**
     * @return {@code Player}
     */
    public final Player getPlayer() {
      return this.player;
    }

    /**
     * @return {@code ObjectEntity[]}
     */
    public final ObjectEntity[] getObjects() {
      return this.objectManager;
    }

    /**
     * @param _objects {@code ObjectEntity[]}
     */
    public final void setObjects(
        final ObjectEntity[] _objects) {
      this.objectManager = _objects;
    }

    /**
     * @param _index {@code int}
     * @return {@code ObjectEntity}
     */
    public final ObjectEntity getObject(
        final int _index) {
      return this.objectManager[_index];
    }

    /**
     * @param _index {@code int}
     * @param _object {@code ObjectEntity}
     */
    public final void setObject(
        final int _index,
        final ObjectEntity _object) {
      this.objectManager[_index] = _object;
    }

    /**
     * @return {@code Collision}
     */
    public final Collision getCollision() {
      return this.collision;
    }

    /**
     *
     */
    public final void init() {
      this.assetSetter.setObject();

      /* Start music. */
      this.playMusic(0);
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

      /* Draw Tiles. */
      this.tileManager.draw(graphics2D);

      /* Draw Objects. */
      for (int i = 0; i < this.objectManager.length; i++) {
        if (this.objectManager[i] != null) {
          this.objectManager[i].draw(this, graphics2D);
        }
      }

      /* Draw Player. */
      this.player.draw(graphics2D);

      /* Draw User Interface. */
      this.userInterface.draw(graphics2D);

      graphics2D.dispose();
    }

    /**
     * @param _index {@code int}
     */
    public final void playMusic(
        final int _index) {
      this.music.setFile(_index);
      this.music.play();
      this.music.loop();
    }

    /**
     *
     */
    public final void stopMusic() {
      this.music.stop();
    }

    /**
     * @param _index {@code int}
     */
    public final void playSoundEffect(
           final int _index) {
      this.soundEffect.setFile(_index);
      this.soundEffect.play();
    }

  }
