package es.noa.rad.game.engine.entity;

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

  }
