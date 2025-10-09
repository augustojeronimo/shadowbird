package com.augustojeronimo.tori.graphics;

import com.augustojeronimo.tori.window.MainPanel;
import java.awt.Canvas;


public class UIElement extends Canvas
{
  public int getScaledX()
  {
    return (int) (getX() * MainPanel.getInstance().getScaleX());
  }

  public int getScaledY()
  {
    return (int) (getY() * MainPanel.getInstance().getScaleY());
  }

  public int getScaledWidth()
  {
    return (int) (MainPanel.getInstance().getScaleX() * this.getWidth());
  }

  public int getScaledHeight()
  {
    return (int) (MainPanel.getInstance().getScaleY() * this.getHeight());
  }
}
