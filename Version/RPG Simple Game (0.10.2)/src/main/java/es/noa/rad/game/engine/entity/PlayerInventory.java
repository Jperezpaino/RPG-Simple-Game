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
    private boolean feather;

    /**
     *
     */
    public PlayerInventory() {
      super();
      this.key = 0;
      this.feather = false;
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

    /**
     * @return {@code boolean}
     */
    public final boolean isFeather() {
      return this.feather;
    }

    /**
     * @param _feather {@code booelan}
     */
    public final void setFeather(
        final boolean _feather) {
      this.feather = _feather;
    }

  }
