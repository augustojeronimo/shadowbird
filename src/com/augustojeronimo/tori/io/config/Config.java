package com.augustojeronimo.tori.io.config;

import com.augustojeronimo.tori.io.JSONIO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public abstract class Config
{
  private final Section SECTION;
  private final JsonObject JSON;
  private static final String PATH = "dynamic/settings/custom.json";

  protected Config(Section section)
  {
    this.SECTION = section;
    JsonObject root = JSONIO.read(PATH);

    if (root != null && root.has(section.toString())) {
      this.JSON = root.getAsJsonObject(section.toString());
    }
    else {
      this.JSON = new JsonObject();
    }
  }

  public abstract void loadDefaults();

  public void reset()
  {
    loadDefaults();
    save();
  }

  public static void loadAll()
  {
    WindowConfig.load();
  }

  protected boolean getBoolean(String key, boolean defaultValue)
  {
    JsonElement element = JSON.get(key);
    return (element != null && element.isJsonPrimitive()) ? element.getAsBoolean() : defaultValue;
  }

  protected int getInt(String key, int defaultValue)
  {
    JsonElement element = JSON.get(key);
    return (element != null && element.isJsonPrimitive()) ? element.getAsInt() : defaultValue;
  }

  protected double getDouble(String key, double defaultValue)
  {
    JsonElement element = JSON.get(key);
    return (element != null && element.isJsonPrimitive()) ? element.getAsDouble() : defaultValue;
  }
  
  protected String getString(String key, String defaultValue)
  {
    JsonElement element = JSON.get(key);
    return (element != null && element.isJsonPrimitive()) ? element.getAsString() : defaultValue;
  }

  protected void set(String key, Boolean value) { JSON.addProperty(key, value); }
  protected void set(String key, int value) { JSON.addProperty(key, value); }
  protected void set(String key, double value) { JSON.addProperty(key, value); }
  protected void set(String key, String value) { JSON.addProperty(key, value); }


  public void save()
  {
    JsonObject root = JSONIO.read(PATH);
    root.add(SECTION.toString(), JSON);
    JSONIO.write(PATH, root);
  }


  protected static enum Section
  {
    WINDOW("window");

    private final String name;
    
    private Section(String section) { this.name = section; }

    @Override
    public String toString() {
      return name;
    }
  }
}
