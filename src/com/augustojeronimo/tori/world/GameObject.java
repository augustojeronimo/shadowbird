package com.augustojeronimo.tori.world;

import com.augustojeronimo.tori.graphics.Renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public abstract class GameObject
{
  protected int worldX, worldY;
  protected int width, height;
  protected  boolean solid;

  protected GameObject(int worldX, int worldY, int width, int height, boolean solid)
  {
    this.worldX = worldX;
    this.worldY = worldY;
    this.width = width;
    this.height = height;
    this.solid = solid;
  }

  public void render(Graphics g, Camera c)
  {
    Renderer.renderGameObject(g, this, c);
  }

  public int getXLeft() { return worldX; }
  public int getXCenter() { return worldX + width / 2; }
  public int getXRight() { return worldX + width; }

  public int getYTop() { return worldY; }
  public int getYCenter() { return worldY + height / 2; }
  public int getYBottom() { return worldY + height; }

  public int getWidth() { return width; }
  public int getHeight() { return height; }
  public boolean isSolid() { return solid; }

  public abstract BufferedImage getSprite();

  public void tick() {}
}
