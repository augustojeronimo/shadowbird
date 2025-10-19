package com.augustojeronimo.tori.world.map;

import java.util.HashMap;
import java.util.Map;

public class MapRegistry
{
  private final static Map<Integer, WorldMap> maps = new HashMap<>();

  // TO DO:
  // - Modify map logic to be similar to SaveManager (map<String, WorldMap> and static constants for access)

  static {
    maps.put(0, new WorldMap());
  }

  public static WorldMap get(int id) { return maps.get(id); }
}
