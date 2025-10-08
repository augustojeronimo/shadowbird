package com.augustojeronimo.tori.views.menu;

import com.augustojeronimo.tori.constants.Constants;
import com.augustojeronimo.tori.graphics.Assets;
import com.augustojeronimo.tori.graphics.Renderer;
import com.augustojeronimo.tori.graphics.UIElement;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public final class MenuButton extends UIElement
{
  private static List<MenuButton> buttons;
  private final ButtonType type;
  private boolean active;
  private Runnable action;

  private MenuButton(ButtonType type, int offsetX, int offsetY, int sizeX, int sizeY, Runnable action)
  {
    this.type = type;
    this.action = action;
    this.setBounds(offsetX, offsetY, sizeX, sizeY);
  }

  public static List<MenuButton> getButtons()
  {
    if (buttons == null) {
      buttons = new ArrayList<>();
      createButtons();
    }
    return buttons;
  }

  @Override
  public void paint(Graphics g)
  {
    BufferedImage sprite = null;
    
    switch (type) {
        case START -> {
          sprite = Assets.Menu.buttonStart(active);
        }
        case SETTINGS -> {
          sprite = Assets.Menu.buttonSettings(active);
        }
        case CLOSE -> {
          sprite = Assets.Menu.buttonClose(active);
        }
        default -> {}
    }

    Renderer.render(g, sprite,getScaledX(), getScaledY(), getScaledWidth(), getScaledHeight());
  }

  private static void createButtons()
  {
    int sizeX = 512, sizeY = 144;
    int offsetX = (int) Constants.BASE_WIDTH / 2 - sizeX / 2;
    int offsetY = (int) Constants.BASE_HEIGHT / 2 - sizeY / 2;
    int spaceY = sizeY + 32;
    
    buttons.add(new MenuButton(ButtonType.START, offsetX, offsetY, sizeX, sizeY, () -> {}));
    offsetY += spaceY;
    buttons.add(new MenuButton(ButtonType.SETTINGS, offsetX, offsetY, sizeX, sizeY, () -> {}));
    offsetY += spaceY;
    buttons.add(new MenuButton(ButtonType.CLOSE, offsetX, offsetY, sizeX, sizeY, () -> {}));

    buttons.get(0).active = true;
  }
}
