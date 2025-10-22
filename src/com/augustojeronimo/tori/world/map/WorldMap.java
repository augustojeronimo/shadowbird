package com.augustojeronimo.tori.world.map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.augustojeronimo.tori.world.Camera;
import com.augustojeronimo.tori.world.GameContext;
import com.augustojeronimo.tori.world.entities.Entity;

import java.util.Comparator;


public final class WorldMap extends GroundLayer
{
  // TO DO:
  // - Add other components, like scenery objects
  // - This class must receive all the components to assemble the map
  // - Create a Static loader for provide all resources and ensure access to maps

  private final List<Entity> entities = new ArrayList<>();
  private final GameContext context;
  
  public WorldMap(GameContext context, int[][] grid)
  {
    super(grid);
    this.context = context;
  }

  public void addEntity(Entity e) { entities.add(e); }
  public List<Entity> getEntities() { return entities; }
  
  @Override
  public void tick() {
    super.tick();
    
    entities.forEach(e -> e.tick());
  }

  @Override
  public void render(Graphics g, Camera c) {
    super.render(g, c);

    List<Entity> order = new ArrayList<>(entities);
    order.sort(Comparator.comparingInt(Entity::getYBottom));

    order.forEach(e -> e.render(g, c));
  }
}
