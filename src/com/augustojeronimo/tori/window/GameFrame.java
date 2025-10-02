package com.augustojeronimo.tori.window;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import java.awt.Color;


public class GameFrame extends JFrame
{
  public MainPanel panel;

  public GameFrame()
  {
    configure();
    
    this.setVisible(true);
  }

  private void configure()
  {
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setUndecorated(true);
    this.setResizable(false);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.getContentPane().setBackground(Color.BLACK);
    
    this.setTitle("Kage no Tori");

    this.setLayout(null);
    this.add(MainPanel.getInstance());
  }
}
