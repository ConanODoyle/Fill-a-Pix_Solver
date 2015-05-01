import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class NumButton extends JButton
{
	int number;
	NumberPopup numberPopup;
	public NumButton(int num,NumberPopup numberPopup)
	{
		super();
		this.number = num;
		this.numberPopup = numberPopup;
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(15, 15));
		this.setForeground(Color.BLACK);
		this.setText(Integer.toString(num));
		this.setFocusable(false);
		this.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
			}
	
			public void mouseEntered(MouseEvent arg0) {
			}
	
			public void mouseExited(MouseEvent arg0) {
			}
	
			public void mousePressed(MouseEvent arg0) {
			}
	
			public void mouseReleased(MouseEvent arg0) {
				numberPopup.numInput(number);
				
			}
	});
	}
}