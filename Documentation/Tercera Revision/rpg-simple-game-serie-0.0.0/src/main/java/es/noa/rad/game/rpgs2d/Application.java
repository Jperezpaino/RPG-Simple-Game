/**
 * Package: es.noa.rad.game.rpgs2d.
 */
package es.noa.rad.game.rpgs2d;

  /**
   *
   */
  public final class Application {

    /**
     *
     */
    private static final String MESSAGE = "Hello World!";

    /**
     *
     */
    private Application() {
    }

    /**
     * @param _arguments {@code String[]}
     */
    public static void main(
        final String... _arguments) {
      System.out.println(
        new Application().getMessage());
    }

    /**
     * @return {@code String}
     */
    public String getMessage() {
      return Application.MESSAGE;
    }

  }
