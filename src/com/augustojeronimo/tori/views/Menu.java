package com.augustojeronimo.tori.views;

import java.awt.Graphics;


public class Menu extends BaseView
{
  private static Menu instance;

  private Menu()
  {
    super(ViewType.MENU);

    configure();
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
    super.paint(g);
    
    // TO DO: Render components
    //Renderer.render(g, SpriteLoader.getImage("path/menu_background.png"), 0, 0, getWidth(), getHeight());
  }

  private void configure()
  {
    // TO DO: Configure elements
  }
}
