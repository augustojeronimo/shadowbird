package com.augustojeronimo.tori.world;

import com.augustojeronimo.tori.world.entities.Entity;
import com.augustojeronimo.tori.world.entities.Player;
import com.augustojeronimo.tori.world.map.MapRegistry;
import com.augustojeronimo.tori.world.map.GroundLayer;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

public final class World
{
  private boolean initialized;
  
  private GroundLayer map;
  private List<Entity> entities;
  private Camera camera;

  private Player player;

  public void load(/* save data */)
  {
    initialized = false;

    map = MapRegistry.get("tutorial");
    entities = new ArrayList<>();
    
    player = new Player(this, 0, 0);
    addEntity(player);

    this.camera = player.getCamera();

    initialized = true;
  }

  public void save() {}

  public void tick()
  {
    if (! initialized) return;
    map.tick();
    entities.forEach(e -> e.tick());
  }

  public void render(Graphics g)
  {
    if (! initialized) return;
    map.render(g, camera);
    entities.forEach(e -> e.render(g, camera));
  }

  public void addEntity(Entity e) { entities.add(e); }

  public Camera getCamera() { return camera; }

  public Player getPlayer() { return player; }

  public GroundLayer getMap() { return map; }
}
