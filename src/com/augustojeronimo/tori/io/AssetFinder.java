package com.augustojeronimo.tori.io;

import java.util.HashMap;

import com.augustojeronimo.tori.constants.Constants;
import java.util.Map;


public class AssetFinder extends Finder
{
  private static  final Map<String, String> cache = new HashMap<>();

  private static final String BASE_DIR = "assets/locales/";
  private static String fallback;

  private AssetFinder() {}

  public static void setFallback(String fallback)
  {
    AssetFinder.fallback = fallback;
    cache.clear();
  }

  public static String getPath(String relativePath)
  {
    if (cache.containsKey(relativePath)) return cache.get(relativePath);

    String result = null;
    if (fallback != null) {
      result = checkPath(BASE_DIR, fallback, relativePath);
    }
    if (result == null) {
      result = checkPath(BASE_DIR, Constants.LOCALE_DEFAULT, relativePath);
    }

    cache.put(relativePath, result);
    return result;
  }
  
}
