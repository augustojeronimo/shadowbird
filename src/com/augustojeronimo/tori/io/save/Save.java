package com.augustojeronimo.tori.io.save;

import com.augustojeronimo.tori.io.JSONIO;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public abstract class Save
{
  protected JsonObject JSON;
  protected final Slot slot;

  protected Save(Slot slot) {
    this.slot = slot;
    refresh();
  }

  public final void refresh()
  {
    JSON = JSONIO.read(slot.getPath());
  }

  protected void write()
  {
    JSONIO.write(slot.getPath(), JSON);
  }

  protected void deleteSave()
  {
    JsonObject cleanSave = JSONIO.read(Slot.TEMPLATE.getPath());
    JSONIO.write(slot.getPath(), cleanSave);
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

  public enum Slot
  {
    TEMPLATE("template.json"),
    SLOT1("slot1.json"),
    SLOT2("slot2.json"),
    SLOT3("slot3.json"),
    ;

    private final String dir = "dynamic/saves/";
    private final String path;

    Slot(String file) { this.path = dir+file; }

    String getPath() { return path; }    
  }
}
