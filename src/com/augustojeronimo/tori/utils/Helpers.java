package com.augustojeronimo.tori.utils;

import java.awt.Dimension;
import java.awt.Toolkit;


public class Helpers
{
  private Helpers() {}


  public static Dimension get_screen_size()
  {
    return Toolkit.getDefaultToolkit().getScreenSize();
  }
}
