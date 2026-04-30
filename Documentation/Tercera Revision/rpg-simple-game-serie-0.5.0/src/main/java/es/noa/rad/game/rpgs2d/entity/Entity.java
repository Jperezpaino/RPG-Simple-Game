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
    private int worldX;

    /**
     *
     */
    private int worldY;

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
    public final int getWorldX() {
      return this.worldX;
    }

    /**
     * @param _worldX {@code int}
     */
    public final void setWorldX(
        final int _worldX) {
      this.worldX = _worldX;
    }

    /**
     * @return {@code int}
     */
    public final int getWorldY() {
      return this.worldY;
    }

    /**
     * @param _worldY {@code int}
     */
    public final void setWorldY(
        final int _worldY) {
      this.worldY = _worldY;
    }

    /**
     * @return {@code int}
     */
    public final int getSpeed() {
      return this.speed;
    }

    /**
     * @param _speed {@code int}
     */
    public final void setSpeed(
        final int _speed) {
      this.speed = _speed;
    }

    /**
     * @return {@code BufferedImage}
     */
    public final BufferedImage getUpStart() {
      return this.upStart;
    }

    /**
     * @param _upStart {@code BufferedImage}
     */
    public final void setUpStart(
        final BufferedImage _upStart) {
      this.upStart = _upStart;
    }

    /**
     * @return {@code BufferedImage}
     */
    public final BufferedImage getUpEnd() {
      return this.upEnd;
    }

    /**
     * @param _upEnd {@code BufferedImage}
     */
    public final void setUpEnd(
        final BufferedImage _upEnd) {
      this.upEnd = _upEnd;
    }

    /**
     * @return {@code BufferedImage}
     */
    public final BufferedImage getDownStart() {
      return this.downStart;
    }

    /**
     * @param _downStart {@code BufferedImage}
     */
    public final void setDownStart(
        final BufferedImage _downStart) {
      this.downStart = _downStart;
    }

    /**
     * @return {@code BufferedImage}
     */
    public final BufferedImage getDownEnd() {
      return this.downEnd;
    }

    /**
     * @param _downEnd {@code BufferedImage}
     */
    public final void setDownEnd(
        final BufferedImage _downEnd) {
      this.downEnd = _downEnd;
    }

    /**
     * @return {@code BufferedImage}
     */
    public final BufferedImage getLeftStart() {
      return this.leftStart;
    }

    /**
     * @param _leftStart {@code BufferedImage}
     */
    public final void setLeftStart(
        final BufferedImage _leftStart) {
      this.leftStart = _leftStart;
    }

    /**
     * @return {@code BufferedImage}
     */
    public final BufferedImage getLeftEnd() {
      return this.leftEnd;
    }

    /**
     * @param _leftEnd {@code BufferedImage}
     */
    public final void setLeftEnd(
        final BufferedImage _leftEnd) {
      this.leftEnd = _leftEnd;
    }

    /**
     * @return {@code BufferedImage}
     */
    public final BufferedImage getRightStart() {
      return this.rightStart;
    }

    /**
     * @param _rightStart {@code BufferedImage}
     */
    public final void setRightStart(
        final BufferedImage _rightStart) {
      this.rightStart = _rightStart;
    }

    /**
     * @return {@code BufferedImage}
     */
    public final BufferedImage getRightEnd() {
      return this.rightEnd;
    }

    /**
     * @param _rightEnd {@code BufferedImage}
     */
    public final void setRightEnd(
        final BufferedImage _rightEnd) {
      this.rightEnd = _rightEnd;
    }

    /**
     * @return {@code String}
     */
    public final String getDirection() {
      return this.direction;
    }

    /**
     * @param _direction {@code String}
     */
    public final void setDirection(
        final String _direction) {
      this.direction = _direction;
    }

    /**
     * @return {@code int}
     */
    public final int getSpriteCounter() {
      return this.spriteCounter;
    }

    /**
     * @param _spriteCounter {@code int}
     */
    public final void setSpriteCounter(
        final int _spriteCounter) {
      this.spriteCounter = _spriteCounter;
    }

    /**
     * @return {@code int}
     */
    public final int getSpriteNum() {
      return this.spriteNum;
    }

    /**
     * @param _spriteNum {@code int}
     */
    public final void setSpriteNum(
        final int _spriteNum) {
      this.spriteNum = _spriteNum;
    }

  }
