import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
	private SidePanel side;
	protected GridButton[][] gridb;
	private int totalSquares = 0;
	private File file = null;
	private String boardState = "e"; //e for edit, s for slow solve
	
	@SuppressWarnings("unused")
	public void init() throws InterruptedException{
		StartMenu init = new StartMenu(this);
	}
	
	public void openGUI()
	{
		frame = new JFrame("Fill-a-Pix Solver");
		
		buttonPanel = new JPanel();
		puzzPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(gridheight,gridwidth));
		
		puzzPanel.setBorder(BorderFactory.createTitledBorder("Grid"));
		buttonPanel.setPreferredSize(new Dimension(gridwidth*20, gridheight*20));
		for(int i=0;i<this.gridheight;i++)
		{
			for(int j=0;j<this.gridwidth;j++)
			{
				buttonPanel.add(gridb[i][j]);
			}
		}
		
		
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

		gridb = new GridButton[this.gridheight][this.gridwidth];
		for(int i =0;i<gridheight;i++)
		{
			for(int j=0;j<gridwidth;j++)
				gridb[i][j] =new GridButton(-1);
		}
		openGUI();
	}
	public void clean()
	{
		for(int i=0;i<this.gridheight;i++)
		{
			for(int j=0;j<this.gridwidth;j++)
			{
				gridb[i][j].setFilled(false);
				gridb[i][j].setComplete(false);
				gridb[i][j].setIllegal(false);
			}
		}
	}
	
	public void solve() throws Exception
	{
		int totalSquares=0;
		for(int i=0;i<this.gridheight;i++)
		{
			for(int j=0;j<this.gridwidth;j++)
			{
				if(gridb[i][j].getNumber()>=0)
					totalSquares++;
			}
		}
		solve(gridb,totalSquares);
		side.solved();
	}
	public void save(String filename) throws IOException
	{
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(filename+".fppuz")));
		for(int i =0;i<gridheight;i++)
		{
			for(int j = 0;j<gridwidth;j++)
			{
				out.write(Integer.toString(gridb[i][j].getNumber()));
				out.write(" ");
			}
			out.write("!");
			out.newLine();
		}
		out.flush();
	}
	public void setFile(File file)
	{
		this.file=file;
	}
	public void readFile() throws Exception{
		int width = 0; //in.nextInt();
		int height = 0; //in.nextInt();
		
		ArrayList<ArrayList<GridButton>> iarray = new ArrayList<ArrayList<GridButton>>();
		
		Scanner filescan = new Scanner(file);
		filescan.useDelimiter("!");
		while (filescan.hasNext()){
			ArrayList<GridButton> temp = new ArrayList<GridButton>();
			String line = filescan.next();
			Scanner linescan = new Scanner(line);
			while (linescan.hasNextInt()){
				temp.add(new GridButton(linescan.nextInt()));
			}
			linescan.close();
			iarray.add(temp);
			height++;
		}
		height--;
		filescan.close();
		width = iarray.get(0).size();
		System.out.println(width+" "+height);
		
		gridb = new GridButton[height][width];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				gridb[y][x] = iarray.get(y).get(x).getCopy();
			}
		}
		this.gridwidth = width;
		this.gridheight = height;
		openGUI();
	}
	public void solve(GridButton[][] answer, int totalSquares) throws Exception{
		//System.out.println("\n\n" + answer.length + " " + answer[0].length);
		
		int numSquaresCompleted = 0;
		int lastNumSquaresCompleted = 0;
		for (int i = 0; i < totalSquares; i++){
			for (int y = 0; y < answer.length; y++){
				for (int x = 0; x < answer[y].length; x++){
					if (answer[y][x].getNumber() == 0 && answer[y][x].isComplete() == false){
							completeZero(x, y, answer);
						answer[y][x].setComplete(true);
						numSquaresCompleted ++;
					} else if (answer[y][x].getNumber() > 0 && answer[y][x].isComplete() == false){
						boolean complete = completeNumber(x, y, answer);
						if (complete){
							answer[y][x].setComplete(true);
							numSquaresCompleted ++; 
						}
					}
				}
			}
			System.out.println("Total squares completed: " + numSquaresCompleted + " numsq" + totalSquares);
			if (numSquaresCompleted == totalSquares){
				break;
			}
			else if (numSquaresCompleted > totalSquares){
				throw new Exception("wtf");
			}
			
			
			if (lastNumSquaresCompleted == numSquaresCompleted){
				System.out.println("Ambiguous puzzle");
			}
			lastNumSquaresCompleted = numSquaresCompleted;
		}
		
	}
	
	private String checkNumberAmbiguous(int x, int y, GridButton[][] grid) throws Exception{
		if (grid[y][x].getNumber() < 0)
			throw new Exception("Square (" + x + ", " + y + ") has no number");
		int[] ymod = {1, 1, 1, 0, -1, -1, -1, 0, 0};
		int[] xmod = {1, 0 ,-1, -1, -1, 0, 1, 1, 0};
		int fcounter = 0;
		int icounter = 0;
		int ocounter = 0;
		int totalsquares = 9;
		
		for (int i = 0; i < 9; i++){
			int x1 = x + xmod[i];
			int y1 = y + ymod[i];
			if (x1 >= 0 && y1 >= 0 && x1 < grid[0].length && y1 < grid.length){
				if (grid[y1][x1].isFilled())
					fcounter++;
				else if (grid[y1][x1].isIllegal() || grid[y1][x1].isFilled())
					icounter++;
				else
					ocounter++;
			} else {
				totalsquares--;
			}
		}
		//System.out.println("(" + x + "," + y + ") : O(" + ocounter + ") F(" + fcounter + ") I/T(" + icounter + "," + tpsquares + ")");
		if (fcounter == grid[y][x].getNumber())
			return "y1";
		if (ocounter + fcounter == grid[y][x].getNumber())
			return "y";
		if (totalsquares-icounter == grid[y][x].getNumber())
			return "y";
		return "n";
	}
	
	private boolean completeNumber(int x, int y, GridButton[][] grid) throws Exception{
		String s = checkNumberAmbiguous(x, y, grid);
		if (s.equals("y")){
			int[] ymod = {1, 1, 1, 0, -1, -1, -1, 0, 0};
			int[] xmod = {1, 0 ,-1, -1, -1, 0, 1, 1, 0};
			int countcheck = 0;
			int snumber = grid[y][x].getNumber();
			
			for (int i = 0; i < 9; i++){
				int x1 = x + xmod[i];
				int y1 = y + ymod[i];
				if (x1 >= 0 && y1 >= 0 && x1 < grid[0].length && y1 < grid.length){
					if (grid[y1][x1].isFilled() == false && grid[y1][x1].isIllegal() == false){
						grid[y1][x1].setFilled(true);
						countcheck++;
					} else if (grid[y1][x1].isFilled()){
						countcheck++;
					}
				}
			}
			
			if (countcheck != snumber)
				throw new Exception("Squares filled in do not match center number! (" + x + ", " + y + ")");
			return true;
		} else if (s.equals("y1")){
			int[] ymod = {1, 1, 1, 0, -1, -1, -1, 0, 0};
			int[] xmod = {1, 0 ,-1, -1, -1, 0, 1, 1, 0};
			
			for (int i = 0; i < 9; i++){
				int x1 = x + xmod[i];
				int y1 = y + ymod[i];
				if (x1 >= 0 && y1 >= 0 && x1 < grid[0].length && y1 < grid.length){
					if (grid[y1][x1].isFilled() == false){
						grid[y1][x1].setIllegal(true);
					}
				}
			}
			return true;
		}
		return false;
	}

	private void completeZero(int x, int y, GridButton[][] grid) throws Exception{
		if (grid[y][x].getNumber() < 0)
			throw new Exception("Square (" + x + ", " + y + ") is not zero");
		
		int[] ymod = {1, 1, 1, 0, -1, -1, -1, 0, 0};
		int[] xmod = {1, 0 ,-1, -1, -1, 0, 1, 1, 0};
		
		for (int i = 0; i < 9; i++){
			int x1 = x + xmod[i];
			int y1 = y + ymod[i];
			if (x1 >= 0 && y1 >= 0 && x1 < grid[0].length && y1 < grid.length){
				if (grid[y1][x1].isFilled() == false){
					grid[y1][x1].setIllegal(true);
				} else {
					throw new Exception("Square #0 (" + x + ", " + y +") has a filled square");
				}
			}
		}
	}
}