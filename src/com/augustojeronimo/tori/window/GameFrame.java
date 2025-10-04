package com.augustojeronimo.tori.window;

import com.augustojeronimo.tori.views.Menu;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import java.awt.Color;


public class GameFrame extends JFrame
{
  private static GameFrame instance;

  private GameFrame()
  {
    configure();
    
    this.setVisible(true);
  }

  public static GameFrame getInstance()
  {
    if (instance == null) {
      instance = new GameFrame();
    }
    return instance;
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

  public static void tick()
  {
      Menu.getInstance().tick();
  }
}
