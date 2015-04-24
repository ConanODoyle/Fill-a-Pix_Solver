package solver;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	private Square[][] grid;
	private int totalSquares = 0;
	private File file = null;
	
	public Board(File file){
		this.file = file;
	}
	
	public void runmain() throws Exception{
		int width = 0; //in.nextInt();
		int height = 0; //in.nextInt();
		
		ArrayList<ArrayList<Square>> iarray = new ArrayList<ArrayList<Square>>();
		
		Scanner filescan = new Scanner(file);
		filescan.useDelimiter("!");
		while (filescan.hasNext()){
			ArrayList<Square> temp = new ArrayList<Square>();
			String line = filescan.next();
			Scanner linescan = new Scanner(line);
			while (linescan.hasNextInt()){
				temp.add(new Square(linescan.nextInt(), false));
			}
			linescan.close();
			iarray.add(temp);
			height++;
		}
		filescan.close();
		width = iarray.get(0).size();
		
		grid = new Square[height][width];
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				grid[y][x] = iarray.get(y).get(x).getCopy();
				if (grid[y][x].getNumber() >= 0)
					setTotalSquares(getTotalSquares() + 1);
			}
		}
		System.out.println(height + " " + width);
		
		printGrid(grid);
		Square[][] solved = Solver.solve(grid, totalSquares);
		printGrid(solved);
	}
	
	public Square[][] getGrid() {
		return grid;
	}

	public void setGrid(Square[][] grid) {
		this.grid = grid;
	}
	
	public int getTotalSquares() {
		return totalSquares;
	}

	public void setTotalSquares(int totalsquares) {
		this.totalSquares = totalsquares;
	}

	public static void printGrid(Square[][] grid){
		for (int y = 0; y < grid.length; y++){
			for (int x = 0; x < grid.length; x++){
				if (grid[y][x].isFilled()){
					System.out.print("#");
				} else if (grid[y][x].getNumber() >= 0 && grid[y][x].isIllegal() == false){
					System.out.print(grid[y][x].getNumber());
				} else
					System.out.print("_");
			}
			System.out.println();
		}
	}
}
