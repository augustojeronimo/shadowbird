package com.augustojeronimo.tori.world.tiles;


public enum TileType
{
  NONE(false, null),
  GRASS(false, "grass"),
  ;

  private final boolean solid;
  private final String spriteName;

  TileType(boolean solid, String spriteName)
  {
    this.solid = solid;
    this.spriteName = spriteName;
  }

  public boolean isSolid() { return solid; }
  public String getSpriteName() { return spriteName; }
}
