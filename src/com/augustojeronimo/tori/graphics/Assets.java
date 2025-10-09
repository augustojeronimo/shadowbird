package com.augustojeronimo.tori.graphics;

import com.augustojeronimo.tori.io.SpriteLoader;

import java.awt.image.BufferedImage;


public final class Assets
{
  private Assets() {}
  private static final String EXTENSION = ".png";

  public final class Menu
  {
    private static final String BASE_DIR = "sprite/menu/"; 
    
    public static BufferedImage background()
    {
      return SpriteLoader.getImage(BASE_DIR+"background_16x9"+EXTENSION);
    }

    public static BufferedImage title()
    {
      return SpriteLoader.getImage(BASE_DIR+"title"+EXTENSION);
    }

    public static BufferedImage buttonStart(boolean active)
    {
      String version = active ? "button_start_active" : "button_start";
      return SpriteLoader.getImage(BASE_DIR+version+EXTENSION);
    }

    public static BufferedImage buttonSettings(boolean active)
    {
      String version = active ? "button_settings_active" : "button_settings";
      return SpriteLoader.getImage(BASE_DIR+version+EXTENSION);
    }

    public static BufferedImage buttonClose(boolean active)
    {
      String version = active ? "button_close_active" : "button_close";
      return SpriteLoader.getImage(BASE_DIR+version+EXTENSION);
    }
  }
  
}
