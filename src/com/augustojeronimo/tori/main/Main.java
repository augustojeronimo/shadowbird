package com.augustojeronimo.tori.main;

import com.augustojeronimo.tori.core.GameThread;
import com.augustojeronimo.tori.window.GameFrame;


public class Main
{
  public static void main(String[] args)
  {
    javax.swing.SwingUtilities.invokeLater(() -> {
      GameFrame g = GameFrame.getInstance();
    });

    GameThread loop = GameThread.getInstance();
    loop.start();
  }
}