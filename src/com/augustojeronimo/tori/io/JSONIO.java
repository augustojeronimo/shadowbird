package com.augustojeronimo.tori.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public final class JSONIO
{
  private static Map<String, JsonObject> cache = new HashMap<>();
  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  private JSONIO() {}

  public static void clearCache() { cache.clear(); }

  public static JsonObject read(String path)
  {
    if (path == null) return new JsonObject();

    String nPath = normalize(path);

    if (cache.containsKey(nPath)) return cache.get(nPath);

    try {
      
      if (!Files.exists(Paths.get(nPath))) {
        return empty(nPath);
      }

      String content = Files.readString(Paths.get(nPath));
      JsonObject obj = JsonParser.parseString(content).getAsJsonObject();
      
      cache.put(nPath, obj);
      return obj;

    } catch (IOException e) {
      e.printStackTrace();
      return empty(nPath);
    }
  }

  public static boolean write(String path, JsonElement json)
  {
    try {
      if (path == null || json == null) return false;

      String nPath = normalize(path);

      Files.writeString(Paths.get(nPath), GSON.toJson(json));

      if (json.isJsonObject()) cache.put(nPath, json.getAsJsonObject());

      return true;

    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static String normalize(String path)
  {
    return Paths.get(path).normalize().toAbsolutePath().toString();
  }

  private static JsonObject empty(String normalizedPath)
  {
    JsonObject empty = new JsonObject();
    cache.put(normalizedPath, empty);
    return empty;
  }
}
