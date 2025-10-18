package com.augustojeronimo.tori.world.tiles;

import java.util.HashMap;
import java.util.Map;


public class TileRegistry
{
  private final static Map<Integer, Tile> types = new HashMap<>();
  
  static {
    Tile none = new Tile(0, 0, "null", false);
    Tile grass = new Tile(0, 0, "grass", false);
    Tile animated = new AnimatedTile(0, 0, "animated_grass_2", false, new int[] {45, 30});
    
    types.put(0, none);
    types.put(2, grass);
    types.put(1, animated);
  }

  public static Tile create(int x, int y, int id)
  {
    return types.get(id).getClone(x, y);
  }

}
