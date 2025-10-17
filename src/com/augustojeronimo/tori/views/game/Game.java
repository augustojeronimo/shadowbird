package com.augustojeronimo.tori.views.game;

import com.augustojeronimo.tori.input.KeyAction;
import com.augustojeronimo.tori.views.BaseView;
import com.augustojeronimo.tori.views.ViewType;
import com.augustojeronimo.tori.world.World;

import java.awt.Color;
import java.awt.Graphics;


public final class Game extends BaseView
{
  private static Game instance;

  private World world;

  private Game()
  {
    super(ViewType.GAME);
    configure();
    setDefaultKeyActions();
  }

  public static Game getInstance()
  {
    if (instance == null) {
      instance = new Game();
    }
    return instance;
  }

  public void configure()
  {
    world = new World();
  }

  @Override
  protected void setDefaultKeyActions() {
    for (KeyAction keyAct : world.getPlayer().getKeyActions()) {
      inputManager.addKeyAction(keyAct);
    }
  }

  @Override
  public void tick()
  {
    super.tick();
    world.tick();
  }

  @Override
  public void paint(Graphics g)
  {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());
    world.render(g);
  }
}
