package com.augustojeronimo.tori.io.save;

import com.google.gson.JsonObject;

public final class SaveFile extends Save
{
  public SaveFile(Slot slot) { super(slot); }

  private JsonObject ensureSection(Section section)
  {
    if (! JSON.has(section.get())) JSON.add(section.get(), new JsonObject());
    return JSON.get(section.get()).getAsJsonObject();
  }

  protected boolean  getOrDefault(Section section, String key, boolean  defaultValue)
  {
    if (JSON == null) return defaultValue;

    JsonObject sec = ensureSection(section);

    return (sec.has(key) && sec.get(key).isJsonPrimitive())
      ? sec.get(key).getAsBoolean()
      : defaultValue;
  }

  protected int getOrDefault(Section section, String key, int defaultValue)
  {
    if (JSON == null) return defaultValue;

    JsonObject sec = ensureSection(section);

    return (sec.has(key) && sec.get(key).isJsonPrimitive())
      ? sec.get(key).getAsInt()
      : defaultValue;
  }

  protected double getOrDefault(Section section, String key, double defaultValue)
  {
    if (JSON == null) return defaultValue;

    JsonObject sec = ensureSection(section);

    return (sec.has(key) && sec.get(key).isJsonPrimitive())
      ? sec.get(key).getAsDouble()
      : defaultValue;
  }

  protected String getOrDefault(Section section, String key, String defaultValue)
  {
    if (JSON == null) return defaultValue;

    JsonObject sec = ensureSection(section);

    return (sec.has(key) && sec.get(key).isJsonPrimitive())
      ? sec.get(key).getAsString()
      : defaultValue;
  }

  protected void set(Section section, String key, boolean  value)
  {
    if (JSON == null) return;
    ensureSection(section).addProperty(key, value);
  }

  protected void set(Section section, String key, int  value)
  {
    if (JSON == null) return;
    ensureSection(section).addProperty(key, value);
  }

  protected void set(Section section, String key, double   value)
  {
    if (JSON == null) return;
    ensureSection(section).addProperty(key, value);
  }

  protected void set(Section section, String key, String  value)
  {
    if (JSON == null) return;
    ensureSection(section).addProperty(key, value);
  }

  public enum Section
  {
    GENERAL("general"),
    WORLD("world"),
    PLAYER("player"),
    ;

    private final String name;
    Section(String section) { this.name = section; }
    String get() { return name; }
  }
}
