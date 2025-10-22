package com.augustojeronimo.tori.world.map;

import com.augustojeronimo.tori.graphics.GameAssets;
import com.augustojeronimo.tori.world.GameContext;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapRegistry
{
  private final static Map<String, Function<GameContext, WorldMap>> maps = new HashMap<>();

  public static final String START = "start";

  static {
    maps.put(START, world -> new WorldMap(world, GameAssets.Grid.start()));
  }

  public static WorldMap create(String name, GameContext context)
  {
    Function<GameContext, WorldMap> factory = maps.get(name);
    if (factory == null) throw new IllegalArgumentException("Unknow map: "+name);
    return factory.apply(context);
  }
}
