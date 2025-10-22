package com.augustojeronimo.tori.world;

import com.augustojeronimo.tori.core.GameClock;
import com.augustojeronimo.tori.input.InputManager;
import com.augustojeronimo.tori.input.KeyAction;
import com.augustojeronimo.tori.io.save.SaveManager;
import com.augustojeronimo.tori.world.entities.Player;
import com.augustojeronimo.tori.world.map.MapRegistry;
import com.augustojeronimo.tori.world.map.WorldMap;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public final class GameContext
{
  private final SaveManager save;
  private final InputManager input;
  
  private WorldMap map;
  private Player player;
  private Camera camera;

  public GameContext(SaveManager save, InputManager input)
  {
    this.save = save;
    this.input = input;
    load();
  }

  public void load()
  {
    GameClock.reset(save.general.getGameTime());

    this.map = MapRegistry.create(save.world.getMap(), this);
    this.player = new Player(this, save.world.getSpawnX(), save.world.getSpawnY());
    this.camera = player.getCamera();

    map.addEntity(player);

    map.addEntity(new Player(this, 128, 128));

    for (KeyAction ka : player.getKeyActions()) {
      input.addKeyAction(ka);
    }

    input.addKeyAction(new KeyAction(GameClock::togglePause, false, KeyEvent.VK_ESCAPE));
  }
  
  public void tick()
  {
    if (GameClock.isPaused()) return;
    map.tick();
  }
  
  public void render(Graphics g)
  {
    map.render(g, camera);
  }
  
  public SaveManager getSave() { return save; }
  public InputManager getInput() { return input; }
  
  public WorldMap getMap() { return map; }
  public Player getPlayer() { return player; }
  public Camera getCamera() { return camera; }
  public void setCamera(Camera camera) { this.camera = camera; }
  
  public void save() { save.write();}
}
