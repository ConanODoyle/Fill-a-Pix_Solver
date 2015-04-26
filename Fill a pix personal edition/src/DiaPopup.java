import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.text.NumberFormatter;

public class DiaPopup extends JFrame
{
  private JPanel hold;
  private JFormattedTextField maxX;
  private JFormattedTextField maxY;
  private JButton input;
  private GUI gui;
  
  public DiaPopup(GUI gui)
  {
    super("Enter size!");
    hold = new JPanel();
    this.setContentPane(hold);
    this.gui=gui;
    hold.setLayout(new BoxLayout(hold, BoxLayout.Y_AXIS));
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
    
    input = new JButton("go!");
    input.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
				gui.setDimensions((int)maxX.getValue(),(int)maxY.getValue());
				gui.openGUI();
				
			}

		});
    hold.add(input);
    this.pack();
    this.setVisible(true);
  }
}
    
  
  
