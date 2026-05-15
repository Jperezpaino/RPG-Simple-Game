package es.noa.rad;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import es.noa.rad.game.engine.core.component.GamePanel;

  /**
   * @see javax.swing.JFrame
   */
  public final class Application
      extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private final GamePanel gamePanel = new GamePanel();

    /**
     *
     */
    private Application() {
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.setResizable(false);
      this.setTitle("RPG Simple Game");
      this.add(this.gamePanel);
      this.pack();
      this.setLocationRelativeTo(null);
      this.setVisible(true);
    }

    /**
     *
     */
    public static void launch() {
      new Application();
    }

    /**
     * @param _arguments {@code String...}
     */
    public static void main(
        final String... _arguments) {
      SwingUtilities.invokeLater(
        Application::launch
      );
    }

  }
