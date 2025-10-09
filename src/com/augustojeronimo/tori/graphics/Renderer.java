package com.augustojeronimo.tori.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Renderer
{
  private Renderer() {}

  public static void render(Graphics graphics, BufferedImage sprite, int x, int y, int width, int height)
  {
    if (graphics == null || sprite == null) return;
    graphics.drawImage(sprite, x, y, width, height, null);
  }

  public static void renderScaled(Graphics graphics, BufferedImage sprite, UIElement element)
  {
    if (graphics == null || sprite == null) return;
    graphics.drawImage(sprite, element.getScaledX(), element.getScaledY(), element.getScaledWidth(), element.getScaledHeight(), null);
  }
}
