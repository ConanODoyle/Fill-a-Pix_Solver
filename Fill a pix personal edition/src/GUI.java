import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
	private SidePanel side;
	private JButton solve;
	private int[][] grid;
	private GridButton[][] gridb;
	private boolean solved = false;
	private Square[][] solution;
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
		gridb = new GridButton[this.gridheight][this.gridwidth];
		
		puzzPanel.setBorder(BorderFactory.createTitledBorder("Grid"));
		for(int i = 0; i < gridheight; i++)
		{
			for(int j = 0; j < this.gridwidth; j++)
			{
				gridb[j][i]=new GridButton(this, -1, i, j);
				buttonPanel.add(gridb[j][i]);
				grid[j][i] = -1;
			}
		}
		buttonPanel.setPreferredSize(new Dimension(gridwidth*20, gridheight*20));
		
		puzzPanel.add(buttonPanel);
		side =new SidePanel(this);
		puzzPanel.add(side);
		
		frame.add(puzzPanel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		frame.addComponentListener(new ComponentListener()
		{
			 public void componentResized(ComponentEvent e)
			 {

					buttonPanel.setPreferredSize(new Dimension(frame.getSize().width/3+gridwidth*20, frame.getSize().height/3+gridheight*20));
			 }

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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
		if(!solved)
		{
			board = new Board();
			try {
				board.solveArray(grid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			solution = board.getGrid();
		}
		for(int i=0;i<this.gridheight;i++)
		{
			for(int j=0;j<this.gridwidth;j++)
			{
				if(solution[i][j].isFilled())
				{
					gridb[j][i].invertColors();
				}
			}
		}
		side.solved();
		if(solved) solved = false;
		else solved = true;
	}
}