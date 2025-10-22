package com.augustojeronimo.tori.io.save;

import java.util.HashMap;
import java.util.Map;

public final class SaveManager
{
  private static final Map<Integer, SaveFile> slots = new HashMap<>();
  private SaveFile currentSlot;

  public static final int SLOT_1 = 1;
  public static final int SLOT_2 = 2;
  public static final int SLOT_3 = 3;
  
  static {
    slots.put(SLOT_1, new SaveFile(Save.Slot.SLOT1));
    slots.put(SLOT_2, new SaveFile(Save.Slot.SLOT2));
    slots.put(SLOT_3, new SaveFile(Save.Slot.SLOT3));
  }

  public final General general;
  public final World world;

  public SaveManager(int slot)
  {
    selectSlot(slot);
    general = new General();
    world = new World();
  }

  private void selectSlot(int key)
  {
    if (! slots.containsKey(key)) throw new IllegalArgumentException("Invalid slot key. Only defined values are allowed.");
    currentSlot = slots.get(key);
  }

  private void ensureSlotSelected() { if (currentSlot == null) throw new IllegalStateException("No save slot selected."); }


  public void write()
  {
    ensureSlotSelected();
    currentSlot.write();
  }

  public void refresh()
  {
    ensureSlotSelected();
    currentSlot.refresh();
  }

  public void delete()
  {
    ensureSlotSelected();
    currentSlot.deleteSave();
  }


  public final class General
  {
    public int getGameTime()
    {
      ensureSlotSelected();
      return currentSlot.getOrDefault(SaveFile.Section.GENERAL, "game_time", 0);
    }

    public void setGameTime(int seconds)
    {
      ensureSlotSelected();
      currentSlot.set(SaveFile.Section.GENERAL, "game_time", seconds);
    }
  }

  public final class World
  {
    public String getMap()
    {
      ensureSlotSelected();
      return currentSlot.getOrDefault(SaveFile.Section.WORLD, "map", "start");
    }

    public void setMap(String mapName)
    {
      ensureSlotSelected();
      currentSlot.getOrDefault(SaveFile.Section.WORLD, "map", mapName);
    }

    public int getSpawnX()
    {
      ensureSlotSelected();
      return currentSlot.getOrDefault(SaveFile.Section.WORLD, "spawn_x", 0);
    }

    public int getSpawnY()
    {
      ensureSlotSelected();
      return currentSlot.getOrDefault(SaveFile.Section.WORLD, "spawn_y", 0);
    }

    public void setSpawn(int x, int y)
    {
      ensureSlotSelected();
      currentSlot.set(SaveFile.Section.WORLD, "spawn_x", x);
      currentSlot.set(SaveFile.Section.WORLD, "spawn_y", y);
    }
  }
}
