package com.augustojeronimo.tori.views;

import com.augustojeronimo.tori.input.InputManager;
import com.augustojeronimo.tori.input.KeyboardInput;

import java.awt.Canvas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class BaseView extends Canvas
{

  private static final List<BaseView> list = new ArrayList<>();
  private final ViewType type;

  private static BaseView activeView;
  protected final InputManager inputManager = new InputManager();

  protected BaseView(ViewType type)
  {
    this.type = type;
    addView();

    setFocusable(true);
    addKeyListener(KeyboardInput.getInstance());

    setDefaultKeyActions();
  }

  @Override
  public void removeNotify() {
    super.removeNotify();
    removeView(this);
  }

  private void addView() {
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

  public static BaseView getActiveView()
  {
    return activeView;
  }

  public static void switchView(ViewType type)
  {
    for (BaseView view : list) {
      if (view.type == type) {
        activeView = view;
        activeView.setVisible(true);
        activeView.requestFocus();
      }
      else {
        view.setVisible(false);
      }
    }
  }

  public void tick()
  {
    if (activeView.equals(this)) {
      inputManager.tick();
    }
  }

  protected void setDefaultKeyActions()
  {
    // TO DO: Global KeyActions
  }
}
