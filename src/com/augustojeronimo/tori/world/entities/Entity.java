package com.augustojeronimo.tori.world.entities;

import com.augustojeronimo.tori.world.GameObject;
import java.awt.Rectangle;


public abstract class Entity extends GameObject
{
  protected Entity(int worldX, int worldY, int width, int height, boolean solid)
  {
    super(worldX, worldY, width, height, solid);
  }

  public Hitbox getCollisionHitbox() { return new Hitbox(); }
  public Hitbox getTouchHitbox() { return new Hitbox(); }

  public boolean collidesWith(Entity other)
  {
    if (other.equals(this) || !other.isSolid()) return false;

    return this.getCollisionHitbox().checkColision(
      other.getCollisionHitbox(),
      this.worldX, this.worldY,
      other.worldX, other.worldY
    );
  }

  public boolean willCollideWith(Entity other, int nextX, int nextY)
  {
    if (other.equals(this) || !other.isSolid()) return false;

    return this.getCollisionHitbox().checkColision(
      other.getCollisionHitbox(),
      nextX, nextY,
      other.worldX, other.worldY
    );
  }

  public boolean touches(Entity other)
  {
    if (other.equals(this)) return false;

    return this.getTouchHitbox().checkColision(
      other.getTouchHitbox(),
      this.worldX, this.worldY,
      other.worldX, other.worldY
    );
  }

  public boolean willTouch(Entity other, int nextX, int nextY)
  {
    if (other.equals(this)) return false;

    return this.getTouchHitbox().checkColision(
      other.getTouchHitbox(),
      nextX, nextY,
      other.worldX, other.worldY
    );
  }


  public class Hitbox
  {
    private final Rectangle[] boxes;

    public Hitbox(Rectangle... boxes)
    {
      this.boxes = boxes != null ? boxes : new Rectangle[0];
    }

    public Rectangle[] get() { return boxes; }

    public boolean checkColision(Hitbox other, int ax, int ay, int bx, int by)
    {
      for (Rectangle a : this.get()) {
        Rectangle ra = new Rectangle(a);
        ra.translate(ax, ay);

        for (Rectangle b : other.get()) {
          Rectangle rb = new Rectangle(b);
          rb.translate(bx, by);

          if (ra.intersects(rb)) return true;
        }
      }
      return false;
    }
  }
}
