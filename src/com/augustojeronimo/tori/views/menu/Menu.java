package com.augustojeronimo.tori.views.menu;

import com.augustojeronimo.tori.constants.Constants;
import com.augustojeronimo.tori.core.Actions;
import com.augustojeronimo.tori.graphics.Assets;
import com.augustojeronimo.tori.graphics.Renderer;
import com.augustojeronimo.tori.input.KeyAction;
import com.augustojeronimo.tori.views.BaseView;
import com.augustojeronimo.tori.views.ViewType;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public final class Menu extends BaseView
{
  private static Menu instance;
  private final List<MenuButton> buttons = new ArrayList<>();
  private int activeIndex = 0;

  private Menu()
  {
    super(ViewType.MENU);
    configure();
    setDefaultKeyActions();
  }

  public static Menu getInstance()
  {
    if (instance == null) {
      instance = new Menu();
    }
    return instance;
  }

  private void configure()
  {
    this.setBounds(0, 0, (int) Constants.BASE_WIDTH, (int) Constants.BASE_HEIGHT);

    int tile = (int) Constants.BASE_WIDTH / 32;
    int w = 8*tile, h = 2*tile;
    int x = (int) Constants.BASE_WIDTH / 2 - w / 2;
    int y = (int) Constants.BASE_HEIGHT / 2;
    int space = h + tile / 2;
    
    buttons.add(new MenuButton(ButtonType.START, x, y, w, h, Actions.Menu::openSaveSelection));
    buttons.add(new MenuButton(ButtonType.SETTINGS, x, (y + space), w, h, Actions.Menu::openSettings));
    buttons.add(new MenuButton(ButtonType.CLOSE, x, (y + 2 * space), w, h, Actions.Menu::closeGame));

    buttons.get(activeIndex).setActive(true);
  }

  @Override
  protected void setDefaultKeyActions()
  {
    super.setDefaultKeyActions();
    
    inputManager.addKeyAction(new KeyAction(this::focusUp, false, KeyEvent.VK_W));
    inputManager.addKeyAction(new KeyAction(this::focusDown, false, KeyEvent.VK_S));
    inputManager.addKeyAction(new KeyAction(this::triggerButton, false, KeyEvent.VK_ENTER));
  }

  private void focusUp()
  {
    buttons.get(activeIndex).setActive(false);
    activeIndex = activeIndex == 0 ? buttons.size() - 1 : activeIndex - 1;
    buttons.get(activeIndex).setActive(true);
  }

  private void focusDown()
  {
    buttons.get(activeIndex).setActive(false);
    activeIndex = (activeIndex + 1) % buttons.size();
    buttons.get(activeIndex).setActive(true);
  }

  private void triggerButton()
  {
    buttons.get(activeIndex).trigger();
  }

  @Override
  public void paint(Graphics g)
  {
    Renderer.renderScaled(g, Assets.Menu.background(), this);
    buttons.forEach((btn) -> btn.paint(g));
  }
}
