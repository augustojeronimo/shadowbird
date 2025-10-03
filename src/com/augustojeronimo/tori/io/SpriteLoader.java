package com.augustojeronimo.tori.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class SpriteLoader
{
  private static final Map<String, BufferedImage> cache = new HashMap<>();

  private SpriteLoader() {}


  public static BufferedImage getImage(String relativePath)
  {
    String path = AssetFinder.getPath(relativePath);

    if (cache.containsKey(path)) {
        return cache.get(path);
    }

    try {
      if (path == null) throw new IOException("File not found at: "+ relativePath);

      BufferedImage image = ImageIO.read(new File(path));
      cache.put(path, image);
      return image;

    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void clearCache()
  {
    cache.clear();
  }

}
