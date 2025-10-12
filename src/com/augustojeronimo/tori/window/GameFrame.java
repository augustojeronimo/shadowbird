package com.augustojeronimo.tori.window;

import com.augustojeronimo.tori.core.GameThread;
import com.augustojeronimo.tori.io.AssetFinder;
import com.augustojeronimo.tori.views.BaseView;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;


public class GameFrame
{
  private static JFrame frame;
  private static boolean fullscreen = false;

  private GameFrame() {}

  public static void init()
  {
    if (frame != null) return;

    frame = new JFrame("Kage no Tori");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setUndecorated(true);
    frame.setResizable(false);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.getContentPane().setBackground(Color.BLACK);
    frame.setLayout(null);

    frame.add(MainPanel.getInstance());

    frame.setVisible(true);
    toggleFullscreen();

    GameThread.getInstance().start();
  }

  public static JFrame getInstance()
  {
    if (frame == null) throw new IllegalStateException("Uninitialized frame");
    return frame;
  }

  public static void toggleFullscreen()
  {
    if (frame == null) return;

    GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    
    if (! fullscreen) {
      device.setFullScreenWindow(frame);
      fullscreen = true;
    }
    else {
      device.setFullScreenWindow(null);
      fullscreen = false;
    }
  }

  public static void close()
  {
    GameThread.getInstance().stop();
    System.exit(0);
  }

  public static void tick()
  {
    if (frame == null) return;

    MainPanel.tick();
    BaseView active = BaseView.getActiveView();

    if (active != null) {
      active.tick();
      active.repaint();
    }
  }
}
