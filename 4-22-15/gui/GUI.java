package gui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import solver.Board;

public class GUI {
	private int gridheight;
	private int gridwidth;
	private JFrame frame;
	private JPanel buttonPanel;
	private Board board;
	private String boardState = "e"; //e for edit, s for slow solve
	
	public void init(Board board) throws InterruptedException{
		this.board = board;
		
		StartMenu init = new StartMenu(this);
	}
	
	public void openGrid(){
		
	}
	
	public void setDimensions(){
		
	}
	
	public void setButtonValue(int x, int y, int value){ //called by NumPanel NumButtons
		
	}
}
