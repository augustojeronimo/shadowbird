package com.augustojeronimo.tori.graphics;

import com.augustojeronimo.tori.window.MainPanel;
import java.awt.Canvas;

public class UIElement extends Canvas
{
  public int getScaledX()
  {
    return (int) (getX() * MainPanel.getInstance().getScaleX() + MainPanel.getInstance().getOffsetX());
  }

  public int getScaledY()
  {
    return (int) (getY() * MainPanel.getInstance().getScaleY() + MainPanel.getInstance().getOffsetY());
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
