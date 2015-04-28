import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		gridb = new GridButton[this.gridheight][this.gridwidth];
		
		puzzPanel.setBorder(BorderFactory.createTitledBorder("Grid"));
		for(int i = 0; i < gridheight; i++)
		{
			for(int j = 0; j < this.gridwidth; j++)
			{
				gridb[i][j]=new GridButton(this, grid[i][j], i, j);
				buttonPanel.add(gridb[i][j]);
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

		grid = new int[this.gridheight][this.gridwidth];
		for(int i =0;i<gridheight;i++)
		{
			for(int j=0;j<gridwidth;j++)
				grid[j][i] = -1;
		}
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
					gridb[i][j].invertColors();
				}
			}
		}
		side.solved();
		if(solved) solved = false;
		else solved = true;
	}
	public void save(String filename) throws IOException
	{
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(filename+".fapsolver")));
		out.write(gridheight +" "+gridwidth);
		out.newLine();
		for(int i =0;i<gridheight;i++)
		{
			for(int j = 0;j<gridwidth;j++)
			{
				out.write(Integer.toString(grid[i][j]));
				out.write(" ");
			}
			out.newLine();
		}
		out.flush();
	}
	
	public void load(File file) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader(file));
		boolean nulled = true;
		String size = in.readLine();
		String[] sizing = size.split(" ");
		this.gridheight = Integer.parseInt(sizing[0]);
		this.gridwidth = Integer.parseInt(sizing[1]);
		this.grid = new int[gridheight][gridwidth];
		int n=0;
		while(nulled)
		{
			String grids = in.readLine();
			if(grids !=null)
			{
				String[] line = grids.split(" ");
				for(int i =0;i<line.length;i++ )
					this.grid[n][i] = Integer.parseInt(line[i]);
			}
		
			else nulled = false;
			n++;
		}
		openGUI();
	}
}
