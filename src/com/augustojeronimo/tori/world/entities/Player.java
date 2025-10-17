package com.augustojeronimo.tori.world.entities;

import com.augustojeronimo.tori.core.GameClock;
import com.augustojeronimo.tori.graphics.Assets;
import com.augustojeronimo.tori.input.KeyAction;
import com.augustojeronimo.tori.world.Camera;
import com.augustojeronimo.tori.world.World;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity
{
  private World world;
  private double speed = 6.0;
  private Camera camera;

  public Player(World world, int worldX, int worldY) {
    super(worldX, worldY, 64, 64, true,
    new Rectangle[] {
      new Rectangle(16, 16, 32, 32)
    });

    this.world = world;
    this.camera = new Camera(getWorldXCenter(), getWorldYCenter(), world.getMap().getWidth(), world.getMap().getHeight());
  }

  @Override
  public BufferedImage getSprite() {
    return Assets.Tiles.player();
  }

  @Override
  public void tick()
  {
    final int delayX = getWorldXCenter(), delayY = getWorldYCenter();
    GameClock.addEvent(3, () -> world.getCamera().setPosition(delayX, delayY));
  }

  public void moveUp() { worldY -= speed; }
  public void moveDown() { worldY += speed; }
  public void moveLeft() { worldX -= speed; }
  public void moveRight() { worldX += speed; }

  public Camera getCamera() { return camera; }

  public KeyAction[] getKeyActions()
  {
    return new KeyAction[]{
      new KeyAction(this::moveUp, true, KeyEvent.VK_W),
      new KeyAction(this::moveDown, true, KeyEvent.VK_S),
      new KeyAction(this::moveLeft, true, KeyEvent.VK_A),
      new KeyAction(this::moveRight, true, KeyEvent.VK_D),
    };
  }
}
