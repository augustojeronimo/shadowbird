package com.augustojeronimo.tori.window;

import com.augustojeronimo.tori.constants.Constants;
import com.augustojeronimo.tori.utils.Helpers;
import com.augustojeronimo.tori.views.Menu;
import com.augustojeronimo.tori.views.Settings;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;


public class MainPanel extends JPanel
{
  private static MainPanel instance;

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

    int offset_x = (screen_width - panel_width) / 2;
    int offset_y = (screen_height - panel_height) / 2;

    this.setBounds(offset_x, offset_y, panel_width, panel_height);
  }

  private void setViews()
  {
    add(Menu.getInstance());
    add(Settings.getInstance());
  }
}
