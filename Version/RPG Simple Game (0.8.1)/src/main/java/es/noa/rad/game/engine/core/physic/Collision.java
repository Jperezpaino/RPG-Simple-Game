package es.noa.rad.game.engine.core.physic;

import es.noa.rad.game.engine.asset.object.ObjectEntity;
import es.noa.rad.game.engine.core.component.GamePanel;
import es.noa.rad.game.engine.entity.Entity;
import es.noa.rad.game.engine.map.tile.TileManager;

  /**
   *
   */
  public class Collision {

    /**
     *
     */
    private GamePanel gamePanel;

    /**
     * @param _gamePanel {@code GamePanel}
     */
    public Collision(
        final GamePanel _gamePanel) {
      this.gamePanel = _gamePanel;
    }

    /**
     * @param _entity {@code Entity}
     */
    public final void collisionTile(
        final Entity _entity) {

      final TileManager tileManager
        = this.gamePanel.getTileManager();

      /*
       * Calculate in pixels the position of each of the entity's edges.
       */
      final int entityLeftWorldX
        = (_entity.getWorldX()
         + _entity.getSolidArea().x);
      final int entityRightWorldX
        = (_entity.getWorldX()
         + _entity.getSolidArea().x
         + _entity.getSolidArea().width);
      final int entityTopWorldY
        = (_entity.getWorldY()
         + _entity.getSolidArea().y);
      final int entityBottomWorldY
        = (_entity.getWorldY()
         + _entity.getSolidArea().y
         + _entity.getSolidArea().height);

      /*
       * Calculate the position on the map grid where each of the entity's edges
       * is located.
       */
      int entityLeftCol
        = (entityLeftWorldX / this.gamePanel.getTileSize());
      int entityRightCol
        = (entityRightWorldX / this.gamePanel.getTileSize());
      int entityTopRow
        = (entityTopWorldY / this.gamePanel.getTileSize());
      int entityBottomRow
        = (entityBottomWorldY / this.gamePanel.getTileSize());

      switch (_entity.getDirection()) {
        case "up":
          /*
           * Recalculate the position of 'Top' edge of the entity on the map
           * grid, eliminating the displacement made through the entity's
           * 'speed'.
           */
          entityTopRow
            = ((entityTopWorldY - _entity.getSpeed())
             / (this.gamePanel.getTileSize()));
          final int tileTopLeftValue
            = tileManager.getMapTileData(entityLeftCol, entityTopRow);
          final int tileTopRightValue
            = tileManager.getMapTileData(entityRightCol, entityTopRow);
          if ((tileManager.getTile(tileTopLeftValue)).isCollision()
           || (tileManager.getTile(tileTopRightValue)).isCollision()) {
            _entity.setCollision(true);
          }
        break;
        case "down":
          /*
           * Recalculate the position of 'Bottom' edge of the entity on the map
           * grid, eliminating the displacement made through the entity's
           * 'speed'.
           */
          entityBottomRow
            = ((entityBottomWorldY + _entity.getSpeed())
             / (this.gamePanel.getTileSize()));
          final int tileBottomLeftValue
            = tileManager.getMapTileData(entityLeftCol, entityBottomRow);
          final int tileBottomRightValue
            = tileManager.getMapTileData(entityRightCol, entityBottomRow);
          if ((tileManager.getTile(tileBottomLeftValue)).isCollision()
           || (tileManager.getTile(tileBottomRightValue)).isCollision()) {
            _entity.setCollision(true);
          }
        break;
        case "left":
          /*
           * Recalculate the position of 'Left' edge of the entity on the map,
           * grid eliminating the displacement made through the entity's
           * 'speed'.
           */
          entityLeftCol
            = ((entityLeftWorldX - _entity.getSpeed())
             / (this.gamePanel.getTileSize()));
          final int tileLeftTopValue
            = tileManager.getMapTileData(entityLeftCol, entityTopRow);
          final int tileLeftBottomValue
            = tileManager.getMapTileData(entityLeftCol, entityBottomRow);
          if ((tileManager.getTile(tileLeftTopValue)).isCollision()
           || (tileManager.getTile(tileLeftBottomValue)).isCollision()) {
            _entity.setCollision(true);
          }
        break;
        case "right":
          /*
           * Recalculate the position of 'Right' edge of the entity on the map
           * grid, eliminating the displacement made through the entity's
           * 'speed'.
           */
          entityRightCol
            = ((entityRightWorldX + _entity.getSpeed())
             / (this.gamePanel.getTileSize()));
          final int tileRightTopValue
            = tileManager.getMapTileData(entityRightCol, entityTopRow);
          final int tileRightBottomValue
            = tileManager.getMapTileData(entityRightCol, entityBottomRow);
          if ((tileManager.getTile(tileRightTopValue)).isCollision()
           || (tileManager.getTile(tileRightBottomValue)).isCollision()) {
            _entity.setCollision(true);
          }
        break;
        default:
        break;
      }
    }

    /**
     * @param _entity {@code Entity}
     * @param _isPlayer {@code boolean}
     */
    public final int collisionObject(
        final Entity _entity,
        final boolean _isPlayer) {
      int index = -1;

      for (int i = 0; i < this.gamePanel.getObjects().length; i++) {
        if (this.gamePanel.getObject(i) != null) {
          /*
           * Obtain the global position of the solid area of the entity, update
           * the object with the current situation and reset the relative
           * position at the end.
           */
          _entity.getSolidArea().x
            = (_entity.getWorldX()
             + _entity.getSolidArea().x);
          _entity.getSolidArea().y
            = (_entity.getWorldY()
             + _entity.getSolidArea().y);

          final ObjectEntity object
            = this.gamePanel.getObject(i);

          /*
           * Obtain the global position of the solid area of the object, update
           * the object with the current situation and reset the relative
           * position at the end.
           */
          object.getSolidArea().x
            = (object.getWorldX()
             + object.getSolidArea().x);
          object.getSolidArea().y
            = (object.getWorldY()
             + object.getSolidArea().y);

          switch (_entity.getDirection()) {
            case "up":
              _entity.getSolidArea().y -= _entity.getSpeed();
              if (_entity.getSolidArea().intersects(object.getSolidArea())) {
                System.out.println("Up Collision");
              }
            break;
            case "down":
              _entity.getSolidArea().y += _entity.getSpeed();
              if (_entity.getSolidArea().intersects(object.getSolidArea())) {
                System.out.println("Down Collision");
              }
            break;
            case "left":
              _entity.getSolidArea().x -= _entity.getSpeed();
              if (_entity.getSolidArea().intersects(object.getSolidArea())) {
                System.out.println("Left Collision");
              }
            break;
            case "right":
              _entity.getSolidArea().x += _entity.getSpeed();
              if (_entity.getSolidArea().intersects(object.getSolidArea())) {
                System.out.println("Right Collision");
              }
            break;
            default:
            break;
          }

          /* Reset to the relative position. */
          _entity.getSolidArea().x = _entity.getSolidAreaDefaultX();
          _entity.getSolidArea().y = _entity.getSolidAreaDefaultY();
          object.getSolidArea().x = object.getSolidAreaDefaultX();
          object.getSolidArea().y = object.getSolidAreaDefaultY();
        }
      }

      /* Return the index of the object we are colliding with. */
      return index;
    }

  }
