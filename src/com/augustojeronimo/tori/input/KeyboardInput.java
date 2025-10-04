package com.augustojeronimo.tori.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

public final class KeyboardInput implements KeyListener
{
  private static KeyboardInput instance;

  private KeyboardInput() {}

  public static KeyboardInput getInstance()
  {
    if (instance == null) {
      instance = new KeyboardInput();
    }
    return instance;
  }


  private static final Set<Integer> pressedKeys = new HashSet<>();

  @Override
  public void keyPressed(KeyEvent e)
  {
    pressedKeys.add(e.getKeyCode());
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    pressedKeys.remove(e.getKeyCode());
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  public static boolean isKeyPressed(int keyCode)
  {
    return pressedKeys.contains(keyCode);
  }
}
