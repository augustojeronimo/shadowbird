package com.augustojeronimo.tori.graphics;

import com.augustojeronimo.tori.io.GridLoader;
import com.augustojeronimo.tori.io.SpriteLoader;
import java.awt.image.BufferedImage;

public final class GameAssets
{
  private GameAssets() {}

  public final class Tiles
  {
    private static final String EXTENSION = ".png";

    private static final String BASE_DIR = "sprite/game/world/map/tiles/";

    public static BufferedImage get(String sprite)
    {
      if (sprite == null) return null;
      return SpriteLoader.getImage(BASE_DIR+sprite+EXTENSION);
    }

    public static BufferedImage player()
    {
      return SpriteLoader.getImage(BASE_DIR+"player"+EXTENSION);
    }

    public static BufferedImage grass()
    {
      return SpriteLoader.getImage(BASE_DIR+"grass"+EXTENSION);
    }
  }

  public final class Maps
  {
    private static final String BASE_DIR = "assets/maps/";
    private static final String EXTENSION = ".map";

    public static int[][] tutorial()
    {
      return GridLoader.getMap(BASE_DIR+"tutorial"+EXTENSION);
    }
  }
}
