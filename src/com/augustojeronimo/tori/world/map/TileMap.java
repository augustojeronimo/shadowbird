package com.augustojeronimo.tori.world.map;

import com.augustojeronimo.tori.world.Camera;
import com.augustojeronimo.tori.world.tiles.Tile;
import java.awt.Graphics;

public final class TileMap
{
  private final Tile[][] map;

  private final int cols, rows;

  public TileMap(int cols, int rows)
  {
    this.cols = cols;
    this.rows = rows;
    map = new Tile[cols][rows];
    init();
  }

  public void init()
  {
    for (int x = 0; x < cols; x++) {
      for (int y = 0; y < rows; y++) {
        map[x][y] = new Tile(x, y, false);
      }
    }
  }

  public void render(Graphics g, Camera c)
  {
    for (int x = 0; x < cols; x++) {
      for (int y = 0; y < rows; y++) {
        map[x][y].render(g, c);
      }
    }
  }

  public int getWidth() { return Tile.SIZE * cols; }
  public int getHeight() { return Tile.SIZE * rows; }
}
