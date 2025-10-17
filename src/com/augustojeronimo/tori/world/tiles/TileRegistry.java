package com.augustojeronimo.tori.world.tiles;

import java.util.HashMap;
import java.util.Map;


public class TileRegistry
{
  private final static Map<Integer, TileType> types = new HashMap<>();
  
  static {
    types.put(0, TileType.NONE);
    types.put(1, TileType.GRASS);
  }

  public static TileType getType(int id) { return types.getOrDefault(id, TileType.NONE); }
  public static Tile createTile(int x, int y, int id) { return new Tile(x, y, getType(id)); }
}
