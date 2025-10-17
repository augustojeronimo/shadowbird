package com.augustojeronimo.tori.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.augustojeronimo.tori.window.MainPanel;
import com.augustojeronimo.tori.world.Camera;
import com.augustojeronimo.tori.world.GameObject;

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

  public static void renderGameObject(Graphics graphics, GameObject obj, Camera c)
  {
    if (graphics == null || obj == null) return;

    double scaleX = MainPanel.getInstance().getScaleX();
    double scaleY = MainPanel.getInstance().getScaleY();

    int screenX = (int) ((obj.getWorldX() - c.getX()) * scaleX);
    int screenY = (int) ((obj.getWorldY() - c.getY()) * scaleY);
    int scaledW = (int) (obj.getWidth() * scaleX);
    int scaledH = (int) (obj.getHeight() * scaleY);

    BufferedImage sprite = obj.getSprite();
    if (sprite != null) graphics.drawImage(sprite, screenX, screenY, scaledW, scaledH, null);
  }
}
