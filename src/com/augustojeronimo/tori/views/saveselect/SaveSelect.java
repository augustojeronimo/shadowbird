package com.augustojeronimo.tori.views.saveselect;

import com.augustojeronimo.tori.constants.Constants;
import com.augustojeronimo.tori.core.Actions;
import com.augustojeronimo.tori.graphics.Assets;
import com.augustojeronimo.tori.graphics.Renderer;
import com.augustojeronimo.tori.graphics.UIElement;
import com.augustojeronimo.tori.input.KeyAction;
import com.augustojeronimo.tori.views.BaseView;
import com.augustojeronimo.tori.views.ViewType;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public final class SaveSelect extends BaseView
{
  private static SaveSelect instance;
  private final List<UIElement> components = new ArrayList<>();
  private final List<Slot> slots = new ArrayList<>();
  private int activeIndex = 0;

  private SaveSelect()
  {
    super(ViewType.SAVE_SELECT);
    configure();
    setDefaultKeyActions();
  }

  public static SaveSelect getInstance()
  {
    if (instance == null) {
      instance = new SaveSelect();
    }
    return instance;
  }

  private void configure()
  {
    setBounds(0, 0, (int) Constants.BASE_WIDTH, (int) Constants.BASE_HEIGHT);

    int tile = (int) (Constants.BASE_WIDTH / 32);
    int slotWidth = 9 * tile;
    int slotHeight = 14 * tile;

    int spacing = tile;
    int totalSlots = Constants.SAVE_SLOTS;

    int totalWidthSlots = totalSlots * slotWidth + (totalSlots - 1) * spacing;
    
    int startX = ((int) Constants.BASE_WIDTH - totalWidthSlots) / 2;
    int startY = 2 * tile;

    for (int i = 0; i < totalSlots; i++) {
      Slot slot = new Slot(i + 1);

      int x = startX + i * (slotWidth + spacing);

      slot.setBounds(x, startY, slotWidth, slotHeight);
      slots.add(slot);
      components.add(slot);
    }

    slots.get(0).setActive(true);
  }

  @Override
  protected void setDefaultKeyActions()
  {
    super.setDefaultKeyActions();

    inputManager.addKeyAction(new KeyAction(Actions.SaveSelect::returnToMenu, false, KeyEvent.VK_ESCAPE));
    inputManager.addKeyAction(new KeyAction(this::focusLeft, false, KeyEvent.VK_A));
    inputManager.addKeyAction(new KeyAction(this::focusRight, false, KeyEvent.VK_D));
    inputManager.addKeyAction(new KeyAction(this::triggerSlot, false, KeyEvent.VK_ENTER));
  }

  @Override
  public void paint(Graphics g)
  {
    Renderer.renderScaled(g, Assets.SaveSelect.background(), this);

    components.forEach(comp -> comp.paint(g));
  }

  @Override
  protected void gainFocus()
  {
    for (Slot slot : slots) {
      slot.verifyData();
    }
  }

  public void focusLeft()
  {
    slots.get(activeIndex).setActive(false);
    activeIndex = activeIndex == 0 ? slots.size() - 1 : activeIndex - 1;
    slots.get(activeIndex).setActive(true);
  }

  public void focusRight()
  {
    slots.get(activeIndex).setActive(false);
    activeIndex = (activeIndex + 1) % slots.size();
    slots.get(activeIndex).setActive(true);
  }

  public void triggerSlot()
  {
    slots.get(activeIndex).trigger();
  }
}
