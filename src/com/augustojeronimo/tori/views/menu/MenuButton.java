package com.augustojeronimo.tori.views.menu;

import com.augustojeronimo.tori.graphics.Assets;
import com.augustojeronimo.tori.graphics.Renderer;
import com.augustojeronimo.tori.graphics.UIElement;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public final class MenuButton extends UIElement
{
  private final ButtonType type;
  private final Runnable action;
  private boolean active;

  public MenuButton(ButtonType type, int x, int y, int width, int height, Runnable action)
  {
    this.type = type;
    this.action = action;
    this.setBounds(x, y, width, height);
  }

  public void setActive(boolean active) { this.active = active; }
  public boolean isActive() { return active; }

  public void trigger() {
    if (action != null) action.run();
  }

  @Override
  public void paint(Graphics g)
  {
    BufferedImage sprite = switch (type) {
      case START -> Assets.Menu.buttonStart(active);
      case SETTINGS -> Assets.Menu.buttonSettings(active);
      case CLOSE -> Assets.Menu.buttonClose(active);
    };

    Renderer.render(g, sprite,getScaledX(), getScaledY(), getScaledWidth(), getScaledHeight());
  }
}
