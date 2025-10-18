package com.augustojeronimo.tori.world.map;

import com.augustojeronimo.tori.world.Camera;
import com.augustojeronimo.tori.world.tiles.Tile;
import com.augustojeronimo.tori.world.tiles.TileRegistry;

import java.awt.Graphics;

public abstract class GroundLayer
{
  private final Tile[][] floor;

  protected GroundLayer(int[][] grid)
  {
    int cols = grid.length;
    int rows = grid[0].length;
    this.floor = new Tile[cols][rows];
    
    for (int x = 0; x < cols; x++) {
      for (int y = 0; y < rows; y++) {
        int id = grid[x][y];
        this.floor[x][y] = TileRegistry.create(x, y, id);
      }
    }
  }

  public void tick()
  {
    for (int x = 0; x < getCols(); x++) {
      for (int y = 0; y < getRows(); y++) {
        this.floor[x][y].tick();
      }
    }
  }

  public void render(Graphics g, Camera c)
  {
    int tileSize = Tile.SIZE;

    int startX = Math.max(0, c.getX() / tileSize);
    int startY = Math.max(0, c.getY() / tileSize);
    int endX = Math.min(getCols(), (c.getX() + c.getWidth()) / tileSize + 1);
    int endY = Math.min(getRows(), (c.getY() + c.getHeight()) / tileSize + 1);

    for (int x = startX; x < endX; x++) {
      for (int y = startY; y < endY; y++) {
        floor[x][y].render(g, c);
      }
    }
  }

  public int getWidth() { return Tile.SIZE * getCols(); }
  public int getHeight() { return Tile.SIZE * getRows(); }
  public int getCols() { return floor.length; }
  public int getRows() { return floor[0].length; }
}
