package com.augustojeronimo.tori.world.entities;

import com.augustojeronimo.tori.world.map.WorldMap;
import com.augustojeronimo.tori.world.tiles.Tile;

import java.util.List;


public abstract class CollisionManager
{
  public static void move(Entity movable, int distanceX, int distanceY, WorldMap map)
  {
    if (movable == null || map == null || (distanceX == 0 && distanceY == 0)) return;
    
    int nextX = movable.getXLeft();
    int nextY = movable.getYTop();


    if (distanceX != 0) {
      int signX = Integer.signum(distanceX);
      
      for (int step = 0; step < Math.abs(distanceX); step++) {
        int testX = nextX + signX;

        if (collidesAt(movable, testX, nextY, map)) break;
        if (testX < 0 || testX + movable.getWidth() > map.getWidth()) break;

        nextX = testX;
      }
    }

    if (distanceY != 0) {
      int signY = Integer.signum(distanceY);
      
      for (int step = 0; step < Math.abs(distanceY); step++) {
        int testY = nextY + signY;

        if (collidesAt(movable, nextX, testY, map)) break;
        if (testY < 0 || testY + movable.getHeight() > map.getHeight()) break;

        nextY = testY;
      }
    }

    movable.setPosition(nextX, nextY);
  }

  private static boolean collidesAt(Entity movable, int testX, int testY, WorldMap map)
  {
    int tileSize = Tile.SIZE;
    int leftTile = testX / tileSize;
    int rightTile = (testX + movable.getWidth() - 1) /tileSize;
    int topTile = testY / tileSize;
    int bottomTile = (testY + movable.getHeight() - 1) / tileSize;

    for (int x = leftTile; x <= rightTile; x++) {
      for (int y = topTile; y <= bottomTile; y++) {
        try {
          if (map.isSolidTile(x, y)) return true;
        } catch (IndexOutOfBoundsException e) {
          return true;
        }
      }
    }

    List<Entity> colliders = map.getEntities();
    for (Entity e : colliders) {
      if (movable.willCollideWith(e, testX, testY)) return true;
    }

    return false;
  }
}
