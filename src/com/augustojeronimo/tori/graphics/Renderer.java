package com.augustojeronimo.tori.graphics;

import com.augustojeronimo.tori.constants.Constants;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.augustojeronimo.tori.window.MainPanel;
import com.augustojeronimo.tori.world.Camera;
import com.augustojeronimo.tori.world.GameObject;
import com.augustojeronimo.tori.world.entities.Entity;
import java.awt.Rectangle;


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

    int screenX = (int) ((obj.getXLeft() - c.getX()) * scaleX);
    int screenY = (int) ((obj.getYTop() - c.getY()) * scaleY);
    int scaledW = (int) (obj.getWidth() * scaleX);
    int scaledH = (int) (obj.getHeight() * scaleY);

    BufferedImage sprite = obj.getSprite();
    if (sprite != null) graphics.drawImage(sprite, screenX, screenY, scaledW, scaledH, null);


    if (Constants.DEBUG) {
      if (obj instanceof Entity ett) {
        for (Rectangle rect : ett.getCollisionHitbox().get()) {
          graphics.setColor(Color.RED);
          graphics.drawRect(screenX + rect.x, screenY + rect.y, (int) (rect.width * scaleX), (int) (rect.height * scaleY));
        }
        for (Rectangle rect : ett.getTouchHitbox().get()) {
          graphics.setColor(Color.YELLOW);
          graphics.drawRect(screenX + rect.x, screenY + rect.y, (int) (rect.width * scaleX), (int) (rect.height * scaleY));
        }
      }
    }
  }
}
