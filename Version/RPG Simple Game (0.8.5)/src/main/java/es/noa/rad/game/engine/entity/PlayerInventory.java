package es.noa.rad.game.engine.entity;

  /**
   *
   */
  public class PlayerInventory {

    /**
     *
     */
    private int key;

    /**
     *
     */
    public PlayerInventory() {
      super();
      this.key = 0;
    }

    /**
     * @return {@code int}
     */
    public final int getKey() {
      return this.key;
    }

    /**
     * @param _key {@code int}
     */
    public final void setKey(
        final int _key) {
      this.key = _key;
    }

  }
