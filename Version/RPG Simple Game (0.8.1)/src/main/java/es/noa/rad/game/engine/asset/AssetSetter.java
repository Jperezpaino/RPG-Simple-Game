package es.noa.rad.game.engine.asset;

import es.noa.rad.game.engine.asset.object.DoorObject;
import es.noa.rad.game.engine.asset.object.KeyObject;
import es.noa.rad.game.engine.asset.object.SwordObject;
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
      final KeyObject keyOneObject = new KeyObject();
      keyOneObject.setWorldX(20 * this.gamePanel.getTileSize());
      keyOneObject.setWorldY(10 * this.gamePanel.getTileSize());
      this.gamePanel.setObject(0, keyOneObject);
      final KeyObject keyTwoObject = new KeyObject();
      keyTwoObject.setWorldX(10 * this.gamePanel.getTileSize());
      keyTwoObject.setWorldY(20 * this.gamePanel.getTileSize());
      this.gamePanel.setObject(1, keyTwoObject);
      final SwordObject swordObject = new SwordObject();
      swordObject.setWorldX(15 * this.gamePanel.getTileSize());
      swordObject.setWorldY(25 * this.gamePanel.getTileSize());
      this.gamePanel.setObject(2, swordObject);
      final DoorObject doorOneObject = new DoorObject();
      doorOneObject.setWorldX(24 * this.gamePanel.getTileSize());
      doorOneObject.setWorldY(12 * this.gamePanel.getTileSize());
      this.gamePanel.setObject(3, doorOneObject);
      final DoorObject doorTwoObject = new DoorObject();
      doorTwoObject.setWorldX(15 * this.gamePanel.getTileSize());
      doorTwoObject.setWorldY(19 * this.gamePanel.getTileSize());
      this.gamePanel.setObject(4, doorTwoObject);
    }

  }
