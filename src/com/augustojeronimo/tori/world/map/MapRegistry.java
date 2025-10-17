package com.augustojeronimo.tori.world.map;

import java.util.HashMap;
import java.util.Map;

public class MapRegistry
{
  private final static Map<String, WorldLayer> maps = new HashMap<>();

  static {
    maps.put("tutorial", new TutorialMap());
  }

  public static WorldLayer get(String name) { return maps.get(name); }
}
