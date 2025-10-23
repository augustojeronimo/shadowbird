package com.augustojeronimo.tori.world.entities;

import com.augustojeronimo.tori.core.GameClock;
import com.augustojeronimo.tori.graphics.GameAssets;
import com.augustojeronimo.tori.input.KeyAction;
import com.augustojeronimo.tori.world.Camera;
import com.augustojeronimo.tori.world.GameContext;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class Player extends Entity
{
  private final GameContext context;
  private final int speed = 8, dashSpeed = 16;
  private final Camera camera;

  private boolean up, down, left, right, dash;

  private final int frameDelay = 5;

  public Player(GameContext context, int worldX, int worldY) {
    super(worldX, worldY, 64, 64, true);
    this.context = context;
    
    camera = new Camera(this.getXCenter(), this.getYCenter(), context.getMap());
  }

  public Camera getCamera() { return camera; }

  @Override
  public Hitbox getCollisionHitbox() {
    return new Hitbox(new Rectangle(width/4, height/4, width/2, height/2));
  }

  @Override
  public Hitbox getTouchHitbox() {
    return new Hitbox(new Rectangle(0, 0, width, height));
  }

  @Override
  public BufferedImage getSprite() {
    return GameAssets.Tile.player();
  }

  @Override
  public void tick()
  {
    final int delayX = getXCenter(), delayY = getYCenter();
    GameClock.addEvent(frameDelay, () -> camera.setPosition(delayX, delayY));

    move();
  }

  public void moveUp() { if (! dash && ! GameClock.isPaused()) up = true; }
  public void moveDown() { if (! dash && ! GameClock.isPaused()) down = true; }
  public void moveLeft() { if (! dash && ! GameClock.isPaused()) left = true; }
  public void moveRight() { if (! dash && ! GameClock.isPaused()) right = true; }
  public void dash()
  {
    dash = true;
    GameClock.addEvent(10, () -> { this.dash = false; });
  }

  public KeyAction[] getKeyActions()
  {
    return new KeyAction[]{
      new KeyAction(this::moveUp, true, KeyEvent.VK_W),
      new KeyAction(this::moveDown, true, KeyEvent.VK_S),
      new KeyAction(this::moveLeft, true, KeyEvent.VK_A),
      new KeyAction(this::moveRight, true, KeyEvent.VK_D),
      new KeyAction(this::dash, false, KeyEvent.VK_SPACE),
    };
  }

  private void move()
  {
    if (up && down) up = down = false;
    if (left && right) left = right = false;

    int curSpeed = dash ? dashSpeed : speed;
    if ((up || down) && (left || right)) curSpeed = (int) ((double) curSpeed / Math.sqrt(2));

    int dx = 0, dy = 0;
    if (up) dy = -curSpeed;
    if (down) dy = curSpeed;
    if (left) dx = -curSpeed;
    if (right) dx = curSpeed;

    CollisionManager.move(this, dx, dy, context.getMap());

    if (! dash) up = down = left = right = false;
  }
}
