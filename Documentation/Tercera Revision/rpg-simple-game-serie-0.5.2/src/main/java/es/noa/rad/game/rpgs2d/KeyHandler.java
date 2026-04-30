/**
 * Package: es.noa.rad.game.rpgs2d.
 */
package es.noa.rad.game.rpgs2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

  /**
   * @see java.awt.event.KeyListener
   */
  public class KeyHandler
      implements KeyListener {

    /**
     *
     */
    private boolean upPressed;

    /**
     *
     */
    private boolean downPressed;

    /**
     *
     */
    private boolean leftPressed;

    /**
     *
     */
    private boolean rightPressed;

    /**
     * @return {@code boolean}
     */
    public final boolean isUpPressed() {
      return this.upPressed;
    }

    /**
     * @return {@code boolean}
     */
    public final boolean isDownPressed() {
      return this.downPressed;
    }

    /**
     * @return {@code boolean}
     */
    public final boolean isLeftPressed() {
      return this.leftPressed;
    }

    /**
     * @return {@code boolean}
     */
    public final boolean isRightPressed() {
      return this.rightPressed;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.awt.event.KeyListener#keyTyped(KeyEvent)
     */
    @Override
    public final void keyTyped(
        final KeyEvent _keyEvent) {
    }

    /**
     * {@inheritDoc}
     *
     * @see java.awt.event.KeyListener#keyPressed(KeyEvent)
     */
    @Override
    public final void keyPressed(
        final KeyEvent _keyEvent) {
      final int code = _keyEvent.getKeyCode();

      if (code == KeyEvent.VK_W) {
        this.upPressed = true;
      }
      if (code == KeyEvent.VK_S) {
        this.downPressed = true;
      }
      if (code == KeyEvent.VK_A) {
        this.leftPressed = true;
      }
      if (code == KeyEvent.VK_D) {
        this.rightPressed = true;
      }
    }

    /**
     * {@inheritDoc}
     *
     * @see java.awt.event.KeyListener#keyReleased(KeyEvent)
     */
    @Override
    public final void keyReleased(
        final KeyEvent _keyEvent) {
      final int code = _keyEvent.getKeyCode();

      if (code == KeyEvent.VK_W) {
        this.upPressed = false;
      }
      if (code == KeyEvent.VK_S) {
        this.downPressed = false;
      }
      if (code == KeyEvent.VK_A) {
        this.leftPressed = false;
      }
      if (code == KeyEvent.VK_D) {
        this.rightPressed = false;
      }
    }

  }
