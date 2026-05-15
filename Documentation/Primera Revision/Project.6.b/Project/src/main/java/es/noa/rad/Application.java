package es.noa.rad;

import javax.swing.JFrame;

/**
  * {Class-Description}.
  */
public class Application {

  /**
    * {Constructor-Description}.
    */
  public Application() {
    super();
  }

  /**
    * {Main-Description}.
    *
    * @param arguments String Array
    *     {Parameter-Description}.
    */
  public static void main(
         final String... arguments) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("2D Adventure");

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);
    
    window.setLocationRelativeTo(null);
    window.pack();
    window.setVisible(true);
    
    gamePanel.startGameThread();
  }

}
