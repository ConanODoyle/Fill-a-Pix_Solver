package gui;

import javax.swing.Jpanel;
import javax.swing.Jbutton;

public class NumberPopup
{
  JFrame mainFrame = new JFrame("Pick one!");
  JPanel content = new JPanel()
  int posX;
  int posY;
  GUI gui;
  public NumberPopup(GUI gui,int x, int y)
  {
    this.gui = gui;
    mainFrame.setContentPane(content);
    
    for(int i=0;i<10;i++)
    {
      content.add(new NumButton(i,gui));
    }
  }
}
