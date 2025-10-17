package com.augustojeronimo.tori.world.tiles;

import com.augustojeronimo.tori.graphics.Assets;
import com.augustojeronimo.tori.world.GameObject;
import java.awt.image.BufferedImage;


public class Tile extends GameObject
{
  public static final int SPRITE_SIZE = 32;
  public static final double SCALE = 2;
  public static final int SIZE = (int) (SPRITE_SIZE * SCALE);

  public Tile(int xIndex, int yIndex, boolean solid)
  {
    super(xIndex * SIZE, yIndex * SIZE, SIZE, SIZE, solid);
  }

  @Override
  public BufferedImage getSprite() {
    return Assets.Tiles.test();
  }
}
