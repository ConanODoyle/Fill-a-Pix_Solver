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
  private JButton open;
  private JButton accept;
  Gui gui;
  
  public FilePopup(GUI gui)
  {
    this.gui = gui;
    mainFrame.setContentPane(hold);
    
    hold.setlayout(new BoxLayout (hold,BoxLayout.Y_AXIS);
    irl = new JTextField();
    irl.setEditable(false);
    hold.add(irl);
    
    filer = new JFileChooser();
    open = new JButton("Open");
    accept = new JButton("Yes");
    open.addActionListener(this);
    accept.addActionLister(this);
    hold.add(open);
    hold.add(accept);
  }
  public void actionPerformed(ActionEvent event)
  {
    if(event.getSource() == open)
    {
      int returnVal = filer.showOpenDialog(FilePopup.this);
      if(returnVal == JFileOpener.APPROVE_OPTION)
      {
       file = filer.getSelectedFile();
       irl.setText(file.getName());
      }
    }
    else if(event.getSource() == accept)
    {
      if(file!= null)
      {
        gui.setFile(file)
      }
      mainFrame.dispose();
    }
  }
}
