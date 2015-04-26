import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GUI {
	private int gridheight;
	private int gridwidth;
	private JFrame frame;
	private JPanel buttonPanel;
	private Board board;
	private int[][] grid;
	private String boardState = "e"; //e for edit, s for slow solve
	
	public GUI()
	{
	}
	public void init() throws InterruptedException{
		StartMenu init = new StartMenu(this);
	}
	
	@SuppressWarnings("null")
	public void openGUI()
	{
		frame = new JFrame("Grids!");
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(gridheight,gridwidth));
		for(int i=0;i<gridheight-1;i++)
		{
			for(int j=0;j<this.gridwidth-1;j++)
			{
				buttonPanel.add(new GridButton(this,10,j,i));
			}
		}
		frame.add(buttonPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setDimensions(int x, int y){
		this.gridwidth = x;
		this.gridheight = y;
	}
	
	public void setButtonValue(int x, int y, int value){ //called by NumPanel NumButtons
		
	}
	public void solve()
	{
		//board class
	}
}
