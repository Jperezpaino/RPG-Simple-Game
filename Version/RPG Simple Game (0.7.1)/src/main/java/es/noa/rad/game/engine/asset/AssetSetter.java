package es.noa.rad.game.engine.asset;

import es.noa.rad.game.engine.asset.object.KeyObject;
import es.noa.rad.game.engine.core.component.GamePanel;

  /**
   *
   */
  public class AssetSetter {

    /**
     *
     */
    private GamePanel gamePanel;

    /**
     * @param _gamePanel {@code GamePanel}
     */
    public AssetSetter(
        final GamePanel _gamePanel) {
      this.gamePanel = _gamePanel;
    }

    /**
     *
     */
    public final void setObject() {
      final KeyObject keyObject = new KeyObject();
      keyObject.setWorldX(20 * this.gamePanel.getTileSize());
      keyObject.setWorldY(10 * this.gamePanel.getTileSize());
      this.gamePanel.setObject(0, keyObject);
    }

  }
