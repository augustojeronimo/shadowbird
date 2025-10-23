package com.augustojeronimo.tori.core;

import com.augustojeronimo.tori.io.config.Settings;
import com.augustojeronimo.tori.views.View;
import com.augustojeronimo.tori.views.ViewType;
import com.augustojeronimo.tori.window.GameFrame;


public final class Actions
{
  private Actions() {}


  public static final class Global
  {
    private Global() {}

    public static void closeGame()
    {
      GameFrame.close();
    }

    public static void toggleFullscreen()
    {
      Settings.Window.setFullscreen(! Settings.Window.isFullscreen());
    }
  }


  public final static class Views
  {
    private Views() {}

    public static void goToMenu()
    {
      View.switchTo(ViewType.MENU);
    }

    public static void goToSaveSelection()
    {
      View.switchTo(ViewType.SAVE_SELECT);
    }

    public static void goToSettings()
    {
      View.switchTo(ViewType.SETTINGS);
    }
  }


  public static final class Menu
  {
    private Menu() {}

    public static void openSaveSelection()
    {
      View.switchTo(ViewType.SAVE_SELECT);
    }

    public static void openSettings()
    {
      View.switchTo(ViewType.SETTINGS);
    }

    public static void closeGame()
    {
      Actions.Global.closeGame();
    }
  }


  public static class SaveSelect
  {
    private SaveSelect() {}

    public static void returnToMenu()
    {
      View.switchTo(ViewType.MENU);
    }
  }
}
