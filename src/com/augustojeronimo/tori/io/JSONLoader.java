package com.augustojeronimo.tori.io;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class JSONLoader
{
  private JSONLoader() {}

  public static JSONObject read(String path)
  {
    if (path == null) return null;

    try {
      String content = new String(Files.readAllBytes(Paths.get(path)));
      return new JSONObject(content);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static boolean write(JSONObject json, String path)
  {
    try {
      Files.write(Paths.get(path), json.toString(2).getBytes());
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}
