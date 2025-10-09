package com.augustojeronimo.tori.core;

import com.augustojeronimo.tori.constants.Constants;

import java.util.ArrayList;
import java.util.List;


public final class GameClock
{
  private static int seconds;
  private static int counter;
  private static long frame;
  private static boolean paused;

  private static final List<TimeEvent> timers = new ArrayList<>();
  
  private GameClock() {}

  public static void reset(int startSeconds)
  {
    seconds = startSeconds;
    counter = 0;
    frame = 0;
    timers.clear();
    paused = false;
  }

  public static int getSeconds() { return seconds; }

  public static long getFrame() { return frame; }

  public static boolean isPaused() { return paused; }

  public static void pause() { paused = true; }

  public static void resume() { paused = false; }

  public static void tick()
  {
    if (paused) return;

    frame++;
    counter++;

    if (counter >= Constants.FPS) {
      counter %= Constants.FPS;
      seconds++;
    }
    timers.removeIf(TimeEvent::tick);
  }

  public static void addEvent(int[] frames, Runnable... actions)
  {
    if (frames.length != actions.length) throw new IllegalArgumentException("The number of frames must be equal to the number of actions");

    int sum = 0;
    for (int i = 0; i < frames.length; i++) {
      sum += frames[i];
      timers.add(new TimeEvent(sum, actions[i]));
    }
  }

  public static void addEvent(int frames, Runnable action) {
    timers.add(new TimeEvent(frames, action));
  }


  private static class TimeEvent
  {
    private int framesRemaining;
    private final Runnable action;

    private TimeEvent(int frames, Runnable action)
    {
      this.framesRemaining = frames;
      this.action = action;
    }

    private boolean tick()
    {
      framesRemaining--;
      if (framesRemaining > 0) return false;

      action.run();
      return true;
    }
  }
}
