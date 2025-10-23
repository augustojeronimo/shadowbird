package com.augustojeronimo.tori.views.saveselect;

import com.augustojeronimo.tori.constants.Constants;
import com.augustojeronimo.tori.core.Actions;
import com.augustojeronimo.tori.graphics.Assets;
import com.augustojeronimo.tori.graphics.Renderer;
import com.augustojeronimo.tori.graphics.UIElement;
import com.augustojeronimo.tori.input.KeyAction;
import com.augustojeronimo.tori.io.save.SaveManager;
import com.augustojeronimo.tori.views.View;
import com.augustojeronimo.tori.views.ViewType;
import com.augustojeronimo.tori.views.game.Game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public final class SaveSelect extends View
{
  private static SaveSelect instance;
  private final List<UIElement> components = new ArrayList<>();
  private final List<Slot> slots = new ArrayList<>();
  private int activeIndex = 0;

  private SaveSelect()
  {
    super(ViewType.SAVE_SELECT);
    configure();
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

    Slot slot1 = new Slot(SaveManager.SLOT_1, () -> {
      Game.getInstance().load(SaveManager.SLOT_1);
      View.switchTo(ViewType.GAME);
    });
    Slot slot2 = new Slot(SaveManager.SLOT_2, () -> {
      Game.getInstance().load(SaveManager.SLOT_2);
      View.switchTo(ViewType.GAME);
    });
    Slot slot3 = new Slot(SaveManager.SLOT_3, () -> {
      Game.getInstance().load(SaveManager.SLOT_3);
      View.switchTo(ViewType.GAME);
    });

    slots.add(slot1);
    slots.add(slot2);
    slots.add(slot3);
    
    for (int i = 0; i < totalSlots; i++) {
      Slot s = slots.get(i);
      int x = startX + i * (slotWidth + spacing);

      s.setBounds(x, startY, slotWidth, slotHeight);
      components.add(s);
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
    inputManager.addKeyAction(new KeyAction(() -> slots.get(activeIndex).trigger(), false, KeyEvent.VK_ENTER));
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
    super.gainFocus();
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
}
