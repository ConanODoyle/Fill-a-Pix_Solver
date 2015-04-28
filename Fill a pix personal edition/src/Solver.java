public class Solver {
	public static Square[][] solve(Square[][] grid, int totalSquares) throws Exception{
		Square[][] answer = copyArray(grid);
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
		
		return answer;
	}
	
	private static Square[][] copyArray(Square[][] grid) {
		Square[][] result = new Square[grid.length][grid[0].length];
		for (int y = 0; y < grid.length; y++){
			for (int x = 0; x < grid[y].length; x++){
				result[y][x] = grid[y][x].getCopy();
			}
		}
		return result;
	}
	
	private static String checkNumberAmbiguous(int x, int y, Square[][] grid) throws Exception{
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
	
	private static boolean completeNumber(int x, int y, Square[][] grid) throws Exception{
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

	private static void completeZero(int x, int y, Square[][] grid) throws Exception{
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