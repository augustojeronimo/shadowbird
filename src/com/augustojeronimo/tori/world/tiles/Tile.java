package com.augustojeronimo.tori.world.tiles;

import com.augustojeronimo.tori.graphics.GameAssets;
import com.augustojeronimo.tori.world.GameObject;
import java.awt.image.BufferedImage;


public class Tile extends GameObject
{
  public static final int SPRITE_SIZE = 32;
  public static final double SCALE = 2;
  public static final int SIZE = (int) (SPRITE_SIZE * SCALE);

  protected final String name;

  public Tile(int xIndex, int yIndex, String name, boolean solid)
  {
    super(xIndex * SIZE, yIndex * SIZE, SIZE, SIZE, solid);
    this.name = name;
  }

  @Override
  public BufferedImage getSprite() {
    return GameAssets.Tiles.get(name);
  }

  public Tile getClone(int x, int y)
  {
    return new Tile(x, y, name, solid);
  }
}
