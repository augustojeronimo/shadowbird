package com.augustojeronimo.tori.screen;

import com.augustojeronimo.tori.constants.Constants;
import com.augustojeronimo.tori.utils.Helpers;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;

import java.util.ArrayList;

public class MainPanel extends JPanel
{
  
  private ArrayList<JPanel> views;

  public MainPanel()
  {
    this.setLayout(new CardLayout());
    this.setBackground(Color.DARK_GRAY);
    
    this.setDoubleBuffered(true);
    
    this.position16by9();
  }

  public void switch_panel(JPanel target)
  {
    if (! this.views.contains(target)) {
      return;
    }

    views.forEach(p -> p.setVisible(p.equals(target)));
  }

  private void position16by9() {
    int screen_width = (int) Helpers.get_screen_size().getWidth();
    int screen_height = (int) Helpers.get_screen_size().getHeight();

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

}
