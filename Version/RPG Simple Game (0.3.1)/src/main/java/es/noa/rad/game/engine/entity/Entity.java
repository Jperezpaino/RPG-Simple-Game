package es.noa.rad.game.engine.entity;

import java.awt.image.BufferedImage;

  /**
   *
   */
  public class Entity {

    /**
     *
     */
    private int x;

    /**
     *
     */
    private int y;

    /**
     *
     */
    private int speed;

    /**
     *
     */
    private BufferedImage up;

    /**
     *
     */
    private BufferedImage down;

    /**
     *
     */
    private BufferedImage left;

    /**
     *
     */
    private BufferedImage right;

    /**
     *
     */
    private String direction;

    /**
     * @return {@code int}
     */
    protected final int getX() {
      return this.x;
    }

    /**
     * @param _x {@code int}
     */
    protected final void setX(
        final int _x) {
      this.x = _x;
    }

    /**
     * @return {@code int}
     */
    protected final int getY() {
      return this.y;
    }

    /**
     * @param _y {@code int}
     */
    protected final void setY(
        final int _y) {
      this.y = _y;
    }

    /**
     * @return {@code int}
     */
    protected final int getSpeed() {
      return this.speed;
    }

    /**
     * @param _speed {@code int}
     */
    protected final void setSpeed(
        final int _speed) {
      this.speed = _speed;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getUp() {
      return this.up;
    }

    /**
     * @param _up {@code BufferedImage}
     */
    protected final void setUp(
        final BufferedImage _up) {
      this.up = _up;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getDown() {
      return this.down;
    }

    /**
     * @param _down {@code BufferedImage}
     */
    protected final void setDown(
        final BufferedImage _down) {
      this.down = _down;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getLeft() {
      return this.left;
    }

    /**
     * @param _left {@code BufferedImage}
     */
    protected final void setLeft(
        final BufferedImage _left) {
      this.left = _left;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getRight() {
      return this.right;
    }

    /**
     * @param _right {@code BufferedImage}
     */
    protected final void setRight(
        final BufferedImage _right) {
      this.right = _right;
    }

    /**
     * @return {@code String}
     */
    protected final String getDirection() {
      return this.direction;
    }

    /**
     * @param _direction {@code String}
     */
    protected final void setDirection(
        final String _direction) {
      this.direction = _direction;
    }

  }
