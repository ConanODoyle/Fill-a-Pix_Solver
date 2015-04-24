package gui;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DiaPopup extends JFrame
{
  private JPanel hold;
  private JFormattedTextField maxX;
  private JFormattedTextField maxY;
  private JButton input;
  
  Public DiaPopup(GUI gui)
  {
    super("Enter size!");
    hold = new JPanel();
    this.setContentPane(hold);
    
    hold.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);
    formatter.setValueClass(Integer.class);
    formatter.setMinimum(0);
    formatter.setMaximum(Integer.MAX_VALUE);
    formatter.setAllowsInvalid(false);
    maxX = new JFormattedTextField(formatter);
    maxY = new JFormattedTextField(formatter);
    JLabel textX = new JLabel("length of grid in squares");
    hold.add(textX);
    hold.add(maxX);
    JLabel textY = new JLabel("height of grid in squares");
    hold.add(textY);
    hold.add(maxY);
  }
}
    
  
  
