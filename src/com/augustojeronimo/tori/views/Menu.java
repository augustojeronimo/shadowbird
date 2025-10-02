package com.augustojeronimo.tori.views;

import java.awt.Color;


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

  private void configure()
  {
    setBackground(Color.RED.darker());
    // TO DO: configure background image and buttons (need archive read code)
  }
}
