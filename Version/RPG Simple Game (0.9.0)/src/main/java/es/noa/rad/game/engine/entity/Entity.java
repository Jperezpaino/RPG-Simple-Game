package es.noa.rad.game.engine.entity;

import java.awt.Rectangle;
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
     *
     */
    private Rectangle solidArea;

    /**
     *
     */
    private int solidAreaDefaultX;

    /**
     *
     */
    private int solidAreaDefaultY;

    /**
     *
     */
    private boolean collision;

    /**
     *
     */
    public Entity() {
      super();
      this.collision = false;
    }

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
    public int getSpeed() {
      return this.speed;
    }

    /**
     * @param _speed {@code int}
     */
    public void setSpeed(
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

    /**
     * @return {@code Rectangle}
     */
    public final Rectangle getSolidArea() {
      return this.solidArea;
    }

    /**
     * @param _solidArea {@code Rectangle}
     */
    public final void setSolidArea(
        final Rectangle _solidArea) {
      this.solidArea = _solidArea;
    }

    /**
     * @return {@code int}
     */
    public final int getSolidAreaDefaultX() {
      return this.solidAreaDefaultX;
    }

    /**
     * @param _solidAreaDefaultX {@code int}
     */
    public final void setSolidAreaDefaultX(
        final int _solidAreaDefaultX) {
      this.solidAreaDefaultX = _solidAreaDefaultX;
    }

    /**
     * @return {@code int}
     */
    public final int getSolidAreaDefaultY() {
      return this.solidAreaDefaultY;
    }

    /**
     * @param _solidAreaDefaultY {@code int}
     */
    public final void setSolidAreaDefaultY(
        final int _solidAreaDefaultY) {
      this.solidAreaDefaultY = _solidAreaDefaultY;
    }

    /**
     * @return {@code boolean}
     */
    public final boolean isCollision() {
      return this.collision;
    }

    /**
     * @param _collision {@code boolean}
     */
    public final void setCollision(
        final boolean _collision) {
      this.collision = _collision;
    }

  }
