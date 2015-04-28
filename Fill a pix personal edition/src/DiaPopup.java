import java.awt.Dimension;
import java.awt.Toolkit;
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
    private StartMenu startmenu;
    
    public DiaPopup(GUI gui,StartMenu startmenu)
    {
        super("Enter size!");
        
        this.gui=gui;
        this.startmenu = startmenu;
        
        hold = new JPanel();
        hold.setLayout(new BoxLayout(hold, BoxLayout.Y_AXIS));
        
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        
        maxX = new JFormattedTextField(formatter);
        maxY = new JFormattedTextField(formatter);
        
        JLabel textX = new JLabel("Grid Length");
        hold.add(textX);
        hold.add(maxX);
        
        JLabel textY = new JLabel("Grid Height");
        hold.add(textY);
        hold.add(maxY);
        
        //TODO: Visual button keypress
        //TODO: Add "Enter" key KeyboardListener
        
        input = new JButton("Done");
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
				startmenu.initFrame.dispose();
				dispose();
				
			}

		});
        hold.add(input);
        
        this.setContentPane(hold);
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
    }
}