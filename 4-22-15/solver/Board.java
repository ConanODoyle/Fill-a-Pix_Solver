package solver;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Board {
	private Square[][] grid;
	private int totalSquares = 0;
	
	public void runmain() throws Exception{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the file to process: ");
		//String f = in.nextLine();
		
		//replace with autoscanner
		System.out.print("Enter the grid dimensions (width, height): \n");
		int width = 15; //in.nextInt();
		int height = 15; //in.nextInt();
		grid = new Square[height][width];
		
		Scanner file = new Scanner(new File("puzzle1"));
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				grid[y][x] = new Square(file.nextInt(), false);
				if (grid[y][x].getNumber() >= 0)
					setTotalSquares(getTotalSquares() + 1);
			}
		}
		file.close();
		
		printGrid(grid);
		Square[][] solved = Solver.solve(grid, totalSquares);
		printGrid(solved);
		
		in.close();
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
