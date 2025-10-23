package com.augustojeronimo.tori.views;

import com.augustojeronimo.tori.constants.Constants;
import com.augustojeronimo.tori.core.Actions;
import com.augustojeronimo.tori.graphics.UIElement;
import com.augustojeronimo.tori.input.InputManager;
import com.augustojeronimo.tori.input.KeyAction;
import com.augustojeronimo.tori.input.KeyboardInput;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class View extends UIElement
{

  private static final List<View> list = new ArrayList<>();
  private final ViewType type;

  private static View activeView;
  protected InputManager inputManager = new InputManager();

  protected View(ViewType type)
  {
    this.type = type;
    addView();

    setFocusable(true);
    addKeyListener(KeyboardInput.getInstance());
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
        switchTo(list.get(0).type);
      }
    }
  }

  private void removeView(View view) {
    list.remove(view);
  }

  public static List<View> getViews() {
    return Collections.unmodifiableList(list);
  }

  public static View getActiveView()
  {
    return activeView;
  }

  public static void switchTo(ViewType type)
  {
    View older = activeView;

    for (View view : list) {
      if (view.type == type) {
        activeView = view;
      }
    }

    if (older != null && !older.equals(activeView)) older.setVisible(false);
    activeView.setVisible(true);
    activeView.requestFocus();
    activeView.gainFocus();
  }

  public void tick()
  {
    if (activeView.equals(this)) {
      activeView.setBounds(0, 0, (int) Constants.BASE_WIDTH, (int) Constants.BASE_HEIGHT);
      inputManager.tick();
    }
  }

  protected void setDefaultKeyActions()
  {
    inputManager.addKeyAction(new KeyAction(Actions.Global::toggleFullscreen, false, KeyEvent.VK_F));
  }

  protected void gainFocus()
  {
    inputManager.clearAcitions();
    setDefaultKeyActions();
  }
}
