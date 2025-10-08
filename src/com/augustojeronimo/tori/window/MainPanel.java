package com.augustojeronimo.tori.window;

import com.augustojeronimo.tori.constants.Constants;
import com.augustojeronimo.tori.utils.Helpers;
import com.augustojeronimo.tori.views.menu.Menu;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;


public class MainPanel extends JPanel
{
  private static MainPanel instance;
  private int offsetX, offsetY;
  private double scaleX, scaleY;

  private MainPanel()
  {
    configure();
    setViews();
  }

  public static MainPanel getInstance()
  {
    if (instance == null) {
        instance = new MainPanel();
    }

    return instance;
  }

  private void configure()
  {
    this.setLayout(new CardLayout());
    this.setBackground(Color.DARK_GRAY);
    this.setDoubleBuffered(true);
    this.position16by9();

    setScaleRender();
  }

  private void position16by9() {
    int screen_width = (int) Helpers.getScreenSize().getWidth();
    int screen_height = (int) Helpers.getScreenSize().getHeight();

    double aspect = Constants.ASPECT_RATIO;

    int panel_width = screen_width;
    int panel_height = (int) (panel_width / aspect);

    if (panel_height > screen_height) {
        panel_height = screen_height;
        panel_width = (int) (panel_height * aspect);
    }

    offsetX = (screen_width - panel_width) / 2;
    offsetY = (screen_height - panel_height) / 2;

    this.setBounds(offsetX, offsetY, panel_width, panel_height);
  }

  public int getOffsetX()
  {
    return this.offsetX;
  }

  public int getOffsetY()
  {
    return this.offsetY;
  }

  public void setScaleRender()
  {
    this.scaleX = getWidth() / Constants.BASE_WIDTH;
    this.scaleY = getHeight() / Constants.BASE_HEIGHT;
  }

  public double getScaleX()
  {
    return scaleX;
  }

  public double getScaleY()
  {
    return scaleY;
  }

  private void setViews()
  {
    add(Menu.getInstance());
  }
}
