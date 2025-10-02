package com.augustojeronimo.tori.utils;

import java.awt.Dimension;
import java.awt.Toolkit;


public class Helpers
{
  private Helpers() {}


  public static Dimension getScreenSize()
  {
    return Toolkit.getDefaultToolkit().getScreenSize();
  }
}
