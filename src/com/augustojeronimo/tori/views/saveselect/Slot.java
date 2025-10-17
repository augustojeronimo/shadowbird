package com.augustojeronimo.tori.views.saveselect;

import com.augustojeronimo.tori.constants.Constants;
import com.augustojeronimo.tori.graphics.Assets;
import com.augustojeronimo.tori.graphics.Renderer;
import com.augustojeronimo.tori.graphics.UIElement;

import java.awt.Graphics;


public final class Slot extends UIElement
{
  private boolean active;
  private int number;
  private Runnable action;

  public Slot(int number, Runnable action)
  {
    if (number < 1 || number > Constants.SAVE_SLOTS) throw new IllegalArgumentException("Slot number must be between 1 and "+Constants.SAVE_SLOTS+". Received: "+ number);

    this.number = number;
    this.active = false;
    this.action = action;

    verifyData();
  }

  public int getNumber() { return number; }

  public boolean isActive() { return active; }
  
  public void setActive(boolean active) { this.active = active; }

  @Override
  public void paint(Graphics g)
  {
    // TO DO: render slot appearance dynamically
    Renderer.renderScaled(g, Assets.SaveSelect.emptySlot(active), this);
  }

  public void verifyData()
  {
    // TO DO: verify data from save
  }

  public void trigger()
  {
    action.run();
  }
}
