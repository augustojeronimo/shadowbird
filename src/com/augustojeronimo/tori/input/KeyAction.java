package com.augustojeronimo.tori.input;

import javax.swing.JOptionPane;

public class KeyAction
{
  private final boolean holdable;
  private final Runnable action;
  private final int keyCode;

  private boolean wasPressed;


  public KeyAction(int keyCode, Runnable action, boolean holdable)
  {
    this.keyCode = keyCode;
    this.action = action;
    this.holdable = holdable;

    wasPressed = false;
  }

  public boolean active()
  {
    return KeyboardInput.isKeyPressed(keyCode);
  }

  public void tick()
  {
    if (!active()) wasPressed = false;
    if (!holdable && wasPressed) return;
    
    if (active()) {
      action.run();
      wasPressed = true;
    }
  }

}
