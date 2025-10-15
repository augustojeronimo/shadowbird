package com.augustojeronimo.tori.io.config;

public final class WindowConfig extends Config
{
  private static WindowConfig instance;

  private boolean fullscreen;

  protected WindowConfig() {
    super(Section.WINDOW);
    loadDefaults();
  }

  public static WindowConfig getInstance()
  {
    if (instance == null) instance = new WindowConfig();
    return instance;
  }

  public static void load() { getInstance(); }

  @Override
  public void loadDefaults() {
    fullscreen = getBoolean("fullscreen", true);
  }

  public boolean isFullscreen() { return fullscreen; }

  public void setFullscreen(boolean value)
  {
    fullscreen = value;
    set("fullscreen", value);
    save();
  }
  
}
