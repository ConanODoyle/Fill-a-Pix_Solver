package gui;

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
	
	public GridButton(int num){
		super();
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(15, 15));
		this.setForeground(Color.BLACK);
		this.setFocusable(true);
		if (num >= 0){
			buttonText = "" + num;
		}
		this.setText(buttonText);
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
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		isOver = true;		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		isOver = false;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		isClicking = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (isClicking && isOver){
		}
		isClicking = false;
	}
}
