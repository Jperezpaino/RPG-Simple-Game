/**
 * Package: es.noa.rad.game.rpgs2d.
 */
package es.noa.rad.game.rpgs2d;

import javax.swing.JFrame;

  /**
   *
   */
  public final class Application {

    /**
     *
     */
    private Application() {
    }

    /**
     * @param _arguments {@code String[]}
     */
    public static void main(
        final String... _arguments) {
      final JFrame window = new JFrame();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(false);
      window.setTitle("2D Adventure");

      final GamePanel gamePanel = new GamePanel();
      gamePanel.startGameThread();
      window.add(gamePanel);

      window.setLocationRelativeTo(null);
      window.pack();
      window.setVisible(true);
    }

  }
