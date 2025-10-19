package com.augustojeronimo.tori.world.map;

import com.augustojeronimo.tori.graphics.GameAssets;


public final class WorldMap extends GroundLayer
{
  // TO DO:
  // - Add other components, like scenery objects
  // - This class must receive all the components to assemble the map
  // - Create a Static loader for provide all resources and ensure access to maps

  public WorldMap(/* resources */)
  {
    super(GameAssets.Grid.start());
  }
}
