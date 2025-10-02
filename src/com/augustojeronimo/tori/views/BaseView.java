package com.augustojeronimo.tori.views;

import java.awt.Canvas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class BaseView extends Canvas
{
  
  private static final List<BaseView> list = new ArrayList<>();
  private final ViewType type;

  // TO DO: input (keyhandler)

  protected BaseView(ViewType type)
  {
    this.type = type;

    if (! list.contains(this)) {
      list.add(this);

      if (list.size() == 1) {
        switchView(list.get(0).type);
      }
    }
  }

  public static void removeView(BaseView view) {
    list.remove(view);
  }

  public static List<BaseView> getViews() {
    return Collections.unmodifiableList(list);
  }

  @Override
  public void removeNotify() {
    super.removeNotify();
    removeView(this);
  }

  public static BaseView getView(ViewType type)
  {
    for (BaseView view : list) {
      if (view.type == type) {
        return view;
      }
    }

    return null;
  }

  public static void switchView(ViewType type)
  {
    for (BaseView view : list) {
      if (view.type == type) {
        view.setVisible(true);
        view.requestFocus();
      }
      else {
        view.setVisible(false);
      }
    }
  }

}
