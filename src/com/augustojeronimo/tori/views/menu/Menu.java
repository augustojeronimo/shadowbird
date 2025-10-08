package com.augustojeronimo.tori.views.menu;

import com.augustojeronimo.tori.constants.Constants;
import com.augustojeronimo.tori.graphics.Assets;
import com.augustojeronimo.tori.graphics.Renderer;
import com.augustojeronimo.tori.views.BaseView;
import com.augustojeronimo.tori.views.ViewType;

import java.awt.Graphics;


public final class Menu extends BaseView
{
  private static Menu instance;

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

  @Override
  protected void setDefaultKeyActions()
  {
    super.setDefaultKeyActions();
    
    // TO DO: Add Menu keyActions
  }

  @Override
  public void paint(Graphics g)
  {
    Renderer.render(g, Assets.Menu.background(), getScaledX(), getScaledY(), getScaledWidth(), getScaledHeight());

    for (MenuButton btn : MenuButton.getButtons()) {
        btn.paint(g);
    }
  }

  private void configure()
  {
    this.setBounds(0, 0, (int) Constants.BASE_WIDTH, (int) Constants.BASE_HEIGHT);
  }
}
