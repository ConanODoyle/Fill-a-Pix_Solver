import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GUI {
	private int gridheight;
	private int gridwidth;
	private JFrame frame;
	private JPanel puzzPanel;
		private JPanel buttonPanel;
	private Board board;
	private int[][] grid;
	private String boardState = "e"; //e for edit, s for slow solve
	
	public void init() throws InterruptedException{
		StartMenu init = new StartMenu(this);
	}
	
	@SuppressWarnings("null")
	public void openGUI()
	{
		frame = new JFrame("Fill-a-Pix Solver");
		
		
		buttonPanel = new JPanel();
		puzzPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(gridheight,gridwidth));
		grid = new int[this.gridheight][this.gridwidth];
		
		puzzPanel.setBorder(BorderFactory.createTitledBorder("Grid"));
		for(int i = 0; i < gridheight; i++)
		{
			for(int j = 0; j < this.gridwidth; j++)
			{
				buttonPanel.add(new GridButton(this, -1, j, i));
				grid[i][j] = -1;
			}
		}
		buttonPanel.setPreferredSize(new Dimension(gridwidth*20, gridheight*20));
		
		puzzPanel.add(buttonPanel);
		frame.add(puzzPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setDimensions(int x, int y){
		this.gridwidth = x;
		this.gridheight = y;
	}
	
	public void setButtonValue(int x, int y, int value){ //called by NumPanel NumButtons
		this.grid[y][x] = value;
	}
	public void solve()
	{
		//board class
	}
}