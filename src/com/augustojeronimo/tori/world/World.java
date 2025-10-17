package com.augustojeronimo.tori.world;

import com.augustojeronimo.tori.world.entities.Entity;
import com.augustojeronimo.tori.world.entities.Player;
import com.augustojeronimo.tori.world.map.TileMap;
import com.augustojeronimo.tori.world.tiles.Tile;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;

public final class World
{
  private final TileMap map;
  private final List<Entity> entities;
  private final Camera camera;

  private final Player player;

  public World(int cols, int rows)
  {
    int centerX = Tile.SIZE*cols/2;
    int centerY = Tile.SIZE*rows/2;

    map = new TileMap(cols, rows);
    entities = new ArrayList<>();
    
    player = new Player(this, centerX - 64, centerY - 64);
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

  public TileMap getMap() { return map; }
}
