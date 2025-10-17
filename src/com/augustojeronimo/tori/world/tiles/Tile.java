package com.augustojeronimo.tori.world.tiles;

import com.augustojeronimo.tori.graphics.GameAssets;
import com.augustojeronimo.tori.world.GameObject;
import java.awt.image.BufferedImage;


public class Tile extends GameObject
{
  public static final int SPRITE_SIZE = 32;
  public static final double SCALE = 2;
  public static final int SIZE = (int) (SPRITE_SIZE * SCALE);

  private final TileType type;

  public Tile(int xIndex, int yIndex, TileType type)
  {
    super(xIndex * SIZE, yIndex * SIZE, SIZE, SIZE, type.isSolid());
    this.type = type;
  }

  @Override
  public BufferedImage getSprite() {
    return GameAssets.Tiles.get(type.getSpriteName());
  }
}
