package com.augustojeronimo.tori.window;

import com.augustojeronimo.tori.core.GameThread;
import com.augustojeronimo.tori.views.BaseView;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GraphicsEnvironment;


public class GameFrame extends JFrame
{
  private static GameFrame instance;

  private boolean fullscreen = false;

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

    toggleFullscreen();
  }

  public void toggleFullscreen()
  {
    if (! fullscreen) {
      GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
      fullscreen = true;
    }
    else {
      GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
      this.setVisible(true);
      fullscreen = false;
    }
  }

  public void close()
  {
    GameThread.getInstance().stop();
    System.exit(0);
  }

  public static void tick()
  {
      BaseView active = BaseView.getActiveView();

      if (active != null) {
        active.tick();
        active.repaint();
      }
  }
}
