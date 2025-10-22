package com.augustojeronimo.tori.views.game;

import com.augustojeronimo.tori.core.GameClock;
import com.augustojeronimo.tori.input.KeyAction;
import com.augustojeronimo.tori.io.save.SaveManager;
import com.augustojeronimo.tori.views.BaseView;
import com.augustojeronimo.tori.views.ViewType;
import com.augustojeronimo.tori.world.GameContext;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public final class Game extends BaseView
{
  private static Game instance;

  private GameContext context;

  private Game()
  {
    super(ViewType.GAME);
    setDefaultKeyActions();
  }

  public static Game getInstance()
  {
    if (instance == null) {
      instance = new Game();
    }
    return instance;
  }

  public void load(int slot)
  {
    context = new GameContext(new SaveManager(slot), inputManager);
  }

  public void close()
  {
    context = null;
    switchView(ViewType.MENU);
  }

  @Override
  protected void setDefaultKeyActions()
  {
    inputManager.addKeyAction(new KeyAction(this::close, false, KeyEvent.VK_CONTROL, KeyEvent.VK_ESCAPE));
  }

  @Override
  public void tick()
  {
    super.tick();
    
    if (context != null) context.tick();
  }

  @Override
  public void paint(Graphics g)
  {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());
    
    if (context == null) return;;

    context.render(g);

    if (GameClock.isPaused()) {
      g.setColor(new Color(0, 0, 0, 100));
      g.fillRect(0, 0, getWidth(), getHeight());
    }
  }

  @Override
  protected void gainFocus() {
    if (context == null) throw new IllegalStateException("Uninitialized world.");
    GameClock.resume();
  }
}
