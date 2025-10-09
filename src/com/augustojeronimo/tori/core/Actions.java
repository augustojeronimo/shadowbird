package com.augustojeronimo.tori.core;

import com.augustojeronimo.tori.views.BaseView;
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
  }


  public final static class Views
  {
    private Views() {}

    public static void goTo(ViewType type)
    {
      BaseView.switchView(type);
    }
  }


  public static final class Menu
  {
    private Menu() {}

    public static void openSaveSelection()
    {
      Actions.Views.goTo(ViewType.SAVE_SELECT);
    }

    public static void openSettings()
    {
      Actions.Views.goTo(ViewType.SETTINGS);
    }

    public static void closeGame()
    {
      GameFrame.close();
    }
  }
}
