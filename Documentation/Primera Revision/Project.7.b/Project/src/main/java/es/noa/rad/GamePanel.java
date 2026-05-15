package es.noa.rad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import es.noa.rad.entity.Player;
import es.noa.rad.object.SuperObject;
import es.noa.rad.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

  /**
    * 
    */
  private static final long serialVersionUID = 1L;
  
  /* Screen settings. */
  private final int originalTileSize = 16;
  private final int scale = 3;
  
  public final int tileSize = this.originalTileSize * this.scale;
  public final int maxScreenCol = 16;
  public final int maxScreenRow = 12;
  public final int screenWidth = this.tileSize * this.maxScreenCol;
  public final int screenHeight = this.tileSize * this.maxScreenRow;
  
  /* World Settings. */
  public final int maxWorldCol = 50;
  public final int maxWorldRow = 50;
  public final int worldWidth = (this.tileSize * this.maxWorldCol);
  public final int worldHeight = (this.tileSize * this.maxWorldRow);

  /* Maximum Frames Per Second. */
  final int fps = 60;
  
  protected TileManager tileManager;
  protected KeyHandler keyHandler;
  public CollisionChecker collisionChecker;
  public AssetSetter assetSetter;
  protected Thread gameThread;
  public Player player;
  public SuperObject[] object;

  
  /* Set player´s default position */
  int playerX = 100;
  int playerY = 100;
  int playerSpeed = 4;
  
  public GamePanel() {
    super();
    this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
        
    this.keyHandler = new KeyHandler();
    this.addKeyListener(this.keyHandler);    
    this.setFocusable(true);
    
    this.collisionChecker = new CollisionChecker(this);
    this.assetSetter = new AssetSetter(this);
    this.tileManager = new TileManager(this);
    this.player = new Player(this, this.keyHandler);
    this.object = new SuperObject[10];
  }
  
  public final void setupGame() {
    this.assetSetter.setObject();
  }
  
  public final void startGameThread() {
    this.gameThread = new Thread(this);  
    this.gameThread.start();
  }

  @Override
  public final void run() {

    double drawInterval = (1000000000/this.fps); /* 0.01666 Seconds. */
    double deltaTime = 0.0D;
    long lastTime = System.nanoTime();
    long timer = 0;
    long drawCount = 0;

    while(this.gameThread != null) {
      final long currentTime = System.nanoTime();
      deltaTime += ((currentTime - lastTime) / drawInterval);
      timer += (currentTime - lastTime);
      lastTime = currentTime;
    
      if(deltaTime >= 1.0D) {
        /* 1 UPDATE: Update information such as character positions. */
        this.update();

        /* 2 DRAW: Draw the screen with the update information. */
        this.repaint();
        
        deltaTime--;
        drawCount++;
      }
      
      if(timer >= 1000000000L) {
    	System.out.println("FPS: " + drawCount);
    	drawCount = 0;
    	timer = 0L;
      }
    }

  }
  
  public final void update() {
    this.player.update();
  }

  @Override
  public final void paintComponent(
         final Graphics graphics) {
    super.paintComponent(graphics);
    
    Graphics2D graphics2D = (Graphics2D) graphics;
    this.tileManager.draw(graphics2D);
    
    for (int i = 0; i < this.object.length; i++) {
      if (this.object[i] != null) {
        this.object[i].draw(graphics2D, this);
      }
    } 
    
    this.player.draw(graphics2D);    
    graphics2D.dispose();
  }

}
