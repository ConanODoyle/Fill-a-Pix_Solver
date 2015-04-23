package gui;
import javax.swing.filechooser.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import solver.Board;

public class GUI {
	private int height;
	private int width;
	private JFrame frame;
	private JPanel buttonPanel;
	private Board board;
	private JFileChooser file;
	private String boardState = "e"; //e for edit, s for slow solve
	
	public void init(Board board) throws InterruptedException{
		this.board = board;
		
		StartMenu init = new StartMenu(this);
	}
	
	public void openFile(){
		FileNameExtensionFilter filter = new FileNameExtensionFilter("gif","jpg","png");
		file.setFileFilter(filter);
		int val = file.showOpenDialog(GUI.this);
		if(val == JFileChooser.APPROVE_OPTION)
		{
			filer=file.getSelectedFile()
		}
	}
	
	public void openGrid(){
		
	}
	
	public void setDimensions(){
		
	}
}
