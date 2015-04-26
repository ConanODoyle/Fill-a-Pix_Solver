

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.filechooser.*;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FilePopup
{
  private JFileChooser filer;
  public File file;
  private JFrame mainFrame;
  private JPanel hold;
  private JTextField irl;
  private JButton open;
  private JButton accept;
  GUI gui;
  
  public FilePopup(GUI gui)
  {
    mainFrame = new JFrame("Enter a file!");
    hold = new JPanel();
    this.gui = gui;
    mainFrame.setContentPane(hold);
    
    hold.setLayout(new BoxLayout (hold,BoxLayout.Y_AXIS));
    irl = new JTextField();
    irl.setEditable(false);
    hold.add(irl);
    
    filer = new JFileChooser();
    open = new JButton("Open");
    accept = new JButton("Yes");
    open.addActionListener((ActionListener) this);
    accept.addActionListener((ActionListener) this);
    hold.add(open);
    hold.add(accept);
    mainFrame.pack();
    mainFrame.setVisible(true);
  }
  public void actionPerformed(ActionEvent event)
  {
    if(event.getSource() == open)
    {
      int returnVal = filer.showOpenDialog(FilePopup.this);
      if(returnVal == JFileChooser.APPROVE_OPTION)
      {
       file = filer.getSelectedFile();
       irl.setText(file.getName());
      }
    }
    else if(event.getSource() == accept)
    {
      if(file!= null)
      {
        gui.setFile(file);
      }
      mainFrame.dispose();
    }
  }
}
