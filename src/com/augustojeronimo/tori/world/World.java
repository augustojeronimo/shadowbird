package com.augustojeronimo.tori.world;

import com.augustojeronimo.tori.world.entities.Entity;
import com.augustojeronimo.tori.world.entities.Player;
import com.augustojeronimo.tori.world.map.MapRegistry;
import com.augustojeronimo.tori.world.map.WorldLayer;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

public final class World
{
  private final WorldLayer map;
  private final List<Entity> entities;
  private final Camera camera;

  private final Player player;

  public World()
  {
    map = MapRegistry.get("tutorial");
    entities = new ArrayList<>();
    
    player = new Player(this, 0, 0);
    addEntity(player);

    this.camera = player.getCamera();
  }

  public void tick()
  {
    entities.forEach(e -> e.tick());
  }

  public void render(Graphics g)
  {
    map.render(g, camera);
    entities.forEach(e -> e.render(g, camera));
  }

  public void addEntity(Entity e) { entities.add(e); }

  public Camera getCamera() { return camera; }

  public Player getPlayer() { return player; }

  public WorldLayer getMap() { return map; }
}
