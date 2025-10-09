package com.augustojeronimo.tori.core;

import com.augustojeronimo.tori.constants.Constants;
import com.augustojeronimo.tori.window.GameFrame;


public final class GameThread implements Runnable
{
  private static final GameThread instance = new GameThread();

  private Thread loop;
  private boolean running;

  private GameThread() {}

  public static GameThread getInstance()
  {
    return instance;
  }

  public void start()
  {
    if (loop == null || ! loop.isAlive()) {
      running = true;
      loop = new Thread(this, "GameLoopThread");
      loop.start();
    }
  }

  public void stop()
  {
    running = false;
    if (loop != null) {
      loop.interrupt();
      loop = null;
    }
  }

  @Override
  public void run()
  {
    final double frameInterval = 1_000_000_000L / Constants.FPS;
    long nextFrame = System.nanoTime();

    while (running) {
      GameClock.tick();
      GameFrame.tick();

      nextFrame += frameInterval;
      long sleepTime = (nextFrame - System.nanoTime()) / 1_000_000;

      if (sleepTime > 0) {
        try {
          Thread.sleep((long) sleepTime);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      else {
        nextFrame = System.nanoTime();
      }
    }
  }
}
