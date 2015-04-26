
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class GridButton extends JButton implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	private String buttonText = "";
	public static final Color FILLED_COLOR = new Color(10, 10, 10);
	public boolean isClicking = false;
	public boolean isOver = false;
	int x;
	int y;
	GUI gui;
	
	public GridButton(GUI gui,int num,int x, int y){
		super();
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(15, 15));
		this.setForeground(Color.BLACK);
		this.setFocusable(true);
		this.x = x;
		this.y = y;
		this.gui = gui;
		if (num >= 0 && num<10){
			buttonText = "" + num;
		}
		else
		{
			this.changeText(-1);
		}
		this.setText(buttonText);
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
				NumberPopup num = new NumberPopup(gui,x,y);
				
			}

		});
	}
	
	public void changeText(int bt){
		if (bt >= 0){
			buttonText = "" + bt;
		} else {
			buttonText = "";
		}
		this.setText(buttonText);
	}
	
	public void invertColors(){
		Color bg = getBackground();
		setBackground(this.getForeground());
		setForeground(bg);
	}
	
	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
		isOver = true;		
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
			NumberPopup num = new NumberPopup(gui,this.x,this.y);
}
}