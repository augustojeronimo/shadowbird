package com.augustojeronimo.tori.world.map;

import java.util.HashMap;
import java.util.Map;

public class MapRegistry
{
  private final static Map<String, GroundLayer> maps = new HashMap<>();

  static {
    maps.put("tutorial", new TutorialMap());
  }

  public static GroundLayer get(String name) { return maps.get(name); }
}
