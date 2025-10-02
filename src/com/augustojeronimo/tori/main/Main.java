package com.augustojeronimo.tori.main;

import com.augustojeronimo.tori.window.GameFrame;

import java.awt.GraphicsEnvironment;


public class Main
{
  public static void main(String[] args)
  {
    javax.swing.SwingUtilities.invokeLater(() -> {

        GameFrame g = new GameFrame();
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(g);
    });
  }

}