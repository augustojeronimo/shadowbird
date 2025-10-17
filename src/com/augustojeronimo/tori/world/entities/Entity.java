package com.augustojeronimo.tori.world.entities;

import com.augustojeronimo.tori.world.GameObject;
import java.awt.Rectangle;


public abstract class Entity extends GameObject
{
  protected Rectangle[] hitbox;

  protected Entity(int worldX, int worldY, int width, int height, boolean solid, Rectangle[] hitbox)
  {
    super(worldX, worldY, width, height, solid);
    this.hitbox = hitbox;
  }
}
