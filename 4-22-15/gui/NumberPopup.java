package gui;

import javax.swing.Jpanel;
import javax.swing.Jbutton;

public class NumberPopup extends JFrame
{
  JPanel content = new JPanel()
  int posX;
  int posY;
  GUI gui;
  public NumberPopup(GUI gui,int x, int y)
  {
    super("Pick One!")
    this.gui = gui;
    this.setContentPane(content);
    content.setLayout(new GridLayout(0,3));
    
    for(int i=0;i<10;i++)
    {
      content.add(new NumButton(i,this,gui));
    }
    content.add(new NumButton(null,this,gui);
  }
  
  void numInput(int n)
  {
    gui.grid[this.y][this.x] = n;
    this.dispose();
  }
}
