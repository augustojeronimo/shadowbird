package com.augustojeronimo.tori.world;

import com.augustojeronimo.tori.constants.Constants;

public final class Camera
{
  private int centerX, centerY;
  private final int width, height;
  private final int mapWidth, mapHeight;

  public Camera(int centerX, int centerY, int mapWidth, int mapHeight)
  {
    this.mapWidth = mapWidth;
    this.mapHeight = mapHeight;
    this.width = (int) Constants.BASE_WIDTH;
    this.height = (int) Constants.BASE_HEIGHT;
    setPosition(centerX, centerY);
  }

  public int getCenterX() { return centerX; }
  public int getCenterY() { return centerY; }
  public int getWidth() { return width; }
  public int getHeight() { return height; }

  public void setPosition(int centerX, int centerY)
  {
    if (mapWidth <= width) {
      this.centerX = mapWidth / 2;
    }
    else {
      int minX = width / 2;
      int maxX = mapWidth - width / 2;

      if (centerX <= this.centerX) {
        this.centerX = (centerX < minX) ? minX : centerX;
      }
      else {
        this.centerX = (centerX > maxX) ? maxX : centerX;
      }
    }
    
    if (mapHeight <= height) {
      this.centerY = mapHeight / 2;
    }
    else {
      int minY = height / 2;
      int maxY = mapHeight - height / 2;
  
      if (centerY <= this.centerY) {
        this.centerY = (centerY < minY) ? minY : centerY;
      }
      else {
        this.centerY = (centerY > maxY && centerY >= this.centerY) ? maxY : centerY;
      }
    }
  }

  public int getX()
  {
    return centerX - width / 2;
  }

  public int getY()
  {
    return centerY - height / 2;
  }
}
