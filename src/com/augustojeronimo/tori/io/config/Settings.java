package com.augustojeronimo.tori.io.config;

public final class Settings
{
  private Settings() {}

  public static final class Global
  {
    public static void init()
    {
      Config.loadAll();
    }
  }

  public static final class Window
  {
    public static void reset()
    {
      WindowConfig.getInstance().reset();
    }

    public static boolean isFullscreen()
    {
      return WindowConfig.getInstance().isFullscreen();
    }

    public static void setFullscreen(boolean value)
    {
      WindowConfig.getInstance().setFullscreen(value);
    }
  } 
}
