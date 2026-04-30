/**
 * Package: es.noa.rad.game.rpgs2d.entity.
 */
package es.noa.rad.game.rpgs2d.entity;

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
    private BufferedImage upStart;

    /**
     *
     */
    private BufferedImage upEnd;

    /**
     *
     */
    private BufferedImage downStart;

    /**
     *
     */
    private BufferedImage downEnd;

    /**
     *
     */
    private BufferedImage leftStart;

    /**
     *
     */
    private BufferedImage leftEnd;

    /**
     *
     */
    private BufferedImage rightStart;

    /**
     *
     */
    private BufferedImage rightEnd;

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
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getUpStart() {
      return this.upStart;
    }

    /**
     * @param _upStart {@code BufferedImage}
     */
    protected final void setUpStart(
        final BufferedImage _upStart) {
      this.upStart = _upStart;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getUpEnd() {
      return this.upEnd;
    }

    /**
     * @param _upEnd {@code BufferedImage}
     */
    protected final void setUpEnd(
        final BufferedImage _upEnd) {
      this.upEnd = _upEnd;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getDownStart() {
      return this.downStart;
    }

    /**
     * @param _downStart {@code BufferedImage}
     */
    protected final void setDownStart(
        final BufferedImage _downStart) {
      this.downStart = _downStart;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getDownEnd() {
      return this.downEnd;
    }

    /**
     * @param _downEnd {@code BufferedImage}
     */
    protected final void setDownEnd(
        final BufferedImage _downEnd) {
      this.downEnd = _downEnd;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getLeftStart() {
      return this.leftStart;
    }

    /**
     * @param _leftStart {@code BufferedImage}
     */
    protected final void setLeftStart(
        final BufferedImage _leftStart) {
      this.leftStart = _leftStart;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getLeftEnd() {
      return this.leftEnd;
    }

    /**
     * @param _leftEnd {@code BufferedImage}
     */
    protected final void setLeftEnd(
        final BufferedImage _leftEnd) {
      this.leftEnd = _leftEnd;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getRightStart() {
      return this.rightStart;
    }

    /**
     * @param _rightStart {@code BufferedImage}
     */
    protected final void setRightStart(
        final BufferedImage _rightStart) {
      this.rightStart = _rightStart;
    }

    /**
     * @return {@code BufferedImage}
     */
    protected final BufferedImage getRightEnd() {
      return this.rightEnd;
    }

    /**
     * @param _rightEnd {@code BufferedImage}
     */
    protected final void setRightEnd(
        final BufferedImage _rightEnd) {
      this.rightEnd = _rightEnd;
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
