package com.augustojeronimo.tori.input;


public class KeyAction
{
  private final boolean holdable;
  private final Runnable action;
  private final int[] keyCode;

  private boolean wasPressed;


  public KeyAction(Runnable action, boolean holdable, int... keyCode)
  {
    this.keyCode = keyCode;
    this.action = action;
    this.holdable = holdable;

    wasPressed = false;
  }

  public boolean active()
  {
    for (int key : keyCode) {
      if (! KeyboardInput.isKeyPressed(key)) return false;
    }
    return true;
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
