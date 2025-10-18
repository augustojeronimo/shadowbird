package com.augustojeronimo.tori.world.tiles;

import com.augustojeronimo.tori.graphics.GameAssets;
import java.awt.image.BufferedImage;

public class AnimatedTile extends Tile
{
  protected int[] framesDurations;
  protected int tickCounter = 0, currentFrame = 0;


  public AnimatedTile(int xIndex, int yIndex, String name, boolean solid, int[] frameDurations) {
    super(xIndex, yIndex, name, solid);
    if (frameDurations == null || frameDurations.length == 0) throw new IllegalArgumentException("Frame duration cannot be null or empty");
    this.framesDurations = frameDurations;
  }

  @Override
  public Tile getClone(int x, int y){
    return new AnimatedTile(x, y, name, solid, framesDurations);
  }

  @Override
  public BufferedImage getSprite() {
    return GameAssets.Tiles.getAnimated(name, currentFrame, SPRITE_SIZE, SPRITE_SIZE);
  }

  @Override
  public void tick() {
    tickCounter++;

    if (tickCounter >= framesDurations[currentFrame]) {
      tickCounter = 0;
      currentFrame++;

      if (currentFrame >= framesDurations.length) currentFrame = 0;
    }
  }
}
