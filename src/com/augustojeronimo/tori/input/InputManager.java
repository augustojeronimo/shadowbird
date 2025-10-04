package com.augustojeronimo.tori.input;

import java.util.ArrayList;
import java.util.List;

public class InputManager
{
  private final List<KeyAction> actions = new ArrayList<>();

  public void addKeyAction(KeyAction keyAction)
  {
    actions.add(keyAction);
  }

  public void tick()
  {
    for (KeyAction action : actions) {
        action.tick();
    }
  }
}
