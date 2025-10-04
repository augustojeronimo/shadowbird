package com.augustojeronimo.tori.main;

import com.augustojeronimo.tori.window.GameFrame;

import java.awt.GraphicsEnvironment;


public class Main
{
  public static void main(String[] args)
  {
    // javax.swing.SwingUtilities.invokeLater(() -> {
      GameFrame g = GameFrame.getInstance();
      GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(g);
    // });
    
    while (true) {
      try {
        g.getInstance().tick();
        Thread.sleep(1000/60);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}