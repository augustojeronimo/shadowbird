package com.augustojeronimo.tori.window;

import com.augustojeronimo.tori.screen.MainPanel;

import javax.swing.WindowConstants;
import javax.swing.JFrame;

import java.awt.Color;


public class GameFrame extends JFrame
{
  public MainPanel panel;

  public GameFrame()
  {
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    
    this.setUndecorated(true);
    this.setResizable(false);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    
    this.setTitle("Kage no Tori");
    this.getContentPane().setBackground(Color.BLACK);

    this.setLayout(null);
    panel = new MainPanel();
    this.add(panel);
    
    this.setVisible(true);
  }

}
