package com.augustojeronimo.tori.views;

import java.awt.Color;


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

  private void configure()
  {
    setBackground(Color.BLUE.darker());
    // TO DO: configure background image and buttons (need archive read code)
  }
}
