package com.augustojeronimo.tori.world;

import com.augustojeronimo.tori.constants.Constants;

public final class Camera
{
  private int centerX, centerY;
  private final int mapWidth, mapHeight;

  public Camera(int centerX, int centerY, int mapWidth, int mapHeight)
  {
    this.mapWidth = mapWidth;
    this.mapHeight = mapHeight;
    setPosition(centerX, centerY);
  }

  public int getCenterX() { return centerX; }
  public int getCenterY() { return centerY; }

  public void setPosition(int centerX, int centerY)
  {
    if (mapWidth <= Constants.BASE_WIDTH) {
      this.centerX = mapWidth / 2;
    }
    else {
      int minX = (int) (Constants.BASE_WIDTH / 2);
      int maxX = mapWidth - (int) (Constants.BASE_WIDTH / 2);

      if (centerX < this.centerX) {
        this.centerX = (centerX < minX) ? minX : centerX;
      }
      else {
        this.centerX = (centerX > maxX) ? maxX : centerX;
      }
    }
    
    if (mapHeight <= Constants.BASE_HEIGHT) {
      this.centerY = mapHeight / 2;
    }
    else {
      int minY = (int) (Constants.BASE_HEIGHT / 2);
      int maxY = mapHeight - (int) (Constants.BASE_HEIGHT / 2);
  
      if (centerY < this.centerY) {
        this.centerY = (centerY < minY) ? minY : centerY;
      }
      else {
        this.centerY = (centerY > maxY && centerY >= this.centerY) ? maxY : centerY;
      }
    }
  }

  public int getX()
  {
    return centerX - (int) (Constants.BASE_WIDTH / 2);
  }

  public int getY()
  {
    return centerY - (int) (Constants.BASE_HEIGHT / 2);
  }
}
