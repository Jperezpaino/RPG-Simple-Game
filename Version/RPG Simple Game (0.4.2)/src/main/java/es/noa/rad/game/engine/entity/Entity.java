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
    private BufferedImage[] up;

    /**
     *
     */
    private BufferedImage[] down;

    /**
     *
     */
    private BufferedImage[] left;

    /**
     *
     */
    private BufferedImage[] right;

    /**
     *
     */
    private String direction;

    /**
     *
     */
    private int spriteCounter;

    /**
     *
     */
    private int spriteNum;

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
     * @param _index {@code int}
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getUp(
        final int _index) {
      return this.up[_index];
    }

    /**
     * @param _up {@code BufferedImage[]}
     */
    protected final void setUp(
        final BufferedImage[] _up) {
      this.up = _up;
    }

    /**
     * @param _index {@code int}
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getDown(
        final int _index) {
      return this.down[_index];
    }

    /**
     * @param _down {@code BufferedImage[]}
     */
    protected final void setDown(
        final BufferedImage[] _down) {
      this.down = _down;
    }

    /**
     * @param _index {@code int}
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getLeft(
        final int _index) {
      return this.left[_index];
    }

    /**
     * @param _left {@code BufferedImage[]}
     */
    protected final void setLeft(
        final BufferedImage[] _left) {
      this.left = _left;
    }

    /**
     * @param _index {@code int}
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getRight(
        final int _index) {
      return this.right[_index];
    }

    /**
     * @param _right {@code BufferedImage[]}
     */
    protected final void setRight(
        final BufferedImage[] _right) {
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

    /**
     * @return {@code int}
     */
    protected final int getSpriteCounter() {
      return this.spriteCounter;
    }

    /**
     * @param _spriteCounter {@code int}
     */
    protected final void setSpriteCounter(
        final int _spriteCounter) {
      this.spriteCounter = _spriteCounter;
    }

    /**
     * @return {@code int}
     */
    protected final int getSpriteNum() {
      return this.spriteNum;
    }

    /**
     * @param _spriteNum {@code int}
     */
    protected final void setSpriteNum(
        final int _spriteNum) {
      this.spriteNum = _spriteNum;
    }

  }
