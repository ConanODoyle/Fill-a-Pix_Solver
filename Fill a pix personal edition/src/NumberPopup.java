
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class NumberPopup extends JFrame
{
  JPanel content = new JPanel();
  int posX;
  int posY;
  GUI gui;
  GridButton gridbutton;
  public NumberPopup(GUI gui, GridButton button, int x, int y)
  {
    super("Pick One!");
    this.gui = gui;
    this.setContentPane(content);
    content.setLayout(new GridLayout(0,3));
    this.gridbutton = gridbutton;
    
    for(int i=0;i<10;i++)
    {
      content.add(new NumButton(i,this,gui));
    }
    content.add(new NumButton(-1,this,gui));
    this.pack();
    this.setVisible(true);
  }
  
  void numInput(int n)
  {
    gui.setButtonValue(this.posY,this.posX,n);
    gridbutton.changeText(n);
    this.dispose();
  }
}
