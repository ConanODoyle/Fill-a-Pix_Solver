package gui

import javax.swing.filechooser.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class FilePopup
{
  private JFileChooser filer;
  public File file;
  private JFrame mainFrame;
  private JPanel hold;
  private JTextField irl;
  Gui gui;
  
  public FilePopup(GUI gui)
  {
    this.gui = gui;
    mainFrame.setContentPane(hold);
    
    hold.setlayout(new BoxLayout (hold,BoxLayout.Y_AXIS);
  }
}
