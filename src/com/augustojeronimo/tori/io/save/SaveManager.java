package com.augustojeronimo.tori.io.save;

import java.util.HashMap;
import java.util.Map;

public class SaveManager
{
  private static final Map<Integer, SaveFile> slots = new HashMap<>();
  private static SaveFile currentSlot;

  public static final int SLOT_1 = 1;
  public static final int SLOT_2 = 2;
  public static final int SLOT_3 = 3;
  
  static {
    slots.put(SLOT_1, new SaveFile(Save.Slot.SLOT1));
    slots.put(SLOT_2, new SaveFile(Save.Slot.SLOT2));
    slots.put(SLOT_3, new SaveFile(Save.Slot.SLOT3));
  }

  public static void selectSlot(int key)
  {
    if (! slots.containsKey(key)) throw new IllegalArgumentException("Invalid slot key. Only defined values are allowed.");
    currentSlot = slots.get(key);
  }

  private static void ensureSlotSelected() { if (currentSlot == null) throw new IllegalStateException("No save slot selected."); }


  public static void write()
  {
    ensureSlotSelected();
    currentSlot.write();
  }

  public static void refresh()
  {
    ensureSlotSelected();
    currentSlot.refresh();
  }

  public static void delete()
  {
    ensureSlotSelected();
    currentSlot.deleteSave();
  }


  public static final class General
  {
    public static int getGameTime()
    {
      ensureSlotSelected();
      return currentSlot.getOrDefault(SaveFile.Section.GENERAL, "game_time", 0);
    }

    public static void setGameTime(int seconds)
    {
      ensureSlotSelected();
      currentSlot.set(SaveFile.Section.GENERAL, "game_time", seconds);
    }
  }

  public static final class World
  {
    public static String getMap()
    {
      ensureSlotSelected();
      return currentSlot.getOrDefault(SaveFile.Section.WORLD, "map", "start");
    }

    public static void setMap(String mapName)
    {
      ensureSlotSelected();
      currentSlot.getOrDefault(SaveFile.Section.WORLD, "map", mapName);
    }

    public static int getSpawnX()
    {
      ensureSlotSelected();
      return currentSlot.getOrDefault(SaveFile.Section.WORLD, "spawn_x", 0);
    }

    public static int getSpawnY()
    {
      ensureSlotSelected();
      return currentSlot.getOrDefault(SaveFile.Section.WORLD, "spawn_y", 0);
    }

    public static void setSpawn(int x, int y)
    {
      ensureSlotSelected();
      currentSlot.set(SaveFile.Section.WORLD, "spawn_x", x);
      currentSlot.set(SaveFile.Section.WORLD, "spawn_y", y);
    }
  }
}
