package com.augustojeronimo.tori.views;

import java.awt.Graphics;


public class Settings extends BaseView
{
  private static Settings instance;

  private Settings()
  {
    super(ViewType.SETTINGS);

    configure();
  }

  public static Settings getInstance()
  {
    if (instance == null) {
      instance = new Settings();
    }

    return instance;
  }

  @Override
  protected void setDefaultKeyActions()
  {
    super.setDefaultKeyActions();

    // TO DO: Add Settings KeyActions
  }

  @Override
  public void paint(Graphics g)
  {
    super.paint(g);
    
    // TO DO: Render components
    //Renderer.render(g, SpriteLoader.getImage("path/settings_background.png"), 0, 0, getWidth(), getHeight());
  }

  private void configure()
  {
    // TO DO: configure elements
  }
}
