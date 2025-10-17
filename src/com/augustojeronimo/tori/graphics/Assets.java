package com.augustojeronimo.tori.graphics;

import com.augustojeronimo.tori.io.GridLoader;
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
      return SpriteLoader.getImage(BASE_DIR+"background"+EXTENSION);
    }

    public static BufferedImage title()
    {
      return SpriteLoader.getImage(BASE_DIR+"title"+EXTENSION);
    }

    public static BufferedImage buttonStart(boolean active)
    {
      String sprite = "button_start" + (active ? "_active" : "");
      return SpriteLoader.getImage(BASE_DIR+sprite+EXTENSION);
    }

    public static BufferedImage buttonSettings(boolean active)
    {
      String sprite = "button_settings" + (active ? "_active" : "");
      return SpriteLoader.getImage(BASE_DIR+sprite+EXTENSION);
    }

    public static BufferedImage buttonClose(boolean active)
    {
      String sprite = "button_close" + (active ? "_active" : "");
      return SpriteLoader.getImage(BASE_DIR+sprite+EXTENSION);
    }
  }


  public final class SaveSelect
  {
    private static final String BASE_DIR = "sprite/save_select/";

    public static BufferedImage background()
    {
      return SpriteLoader.getImage(BASE_DIR+"background"+EXTENSION);
    }

    public static BufferedImage emptySlot(boolean active)
    {
      String sprite = "slot_empty" + (active ? "_active" : "");
      return SpriteLoader.getImage(BASE_DIR+sprite+EXTENSION);
    }

    public static BufferedImage dataSlot(boolean active)
    {
      String sprite = "slot_data" + (active ? "_active" : "");
      return SpriteLoader.getImage(BASE_DIR+sprite+EXTENSION);
    }
  }
}
