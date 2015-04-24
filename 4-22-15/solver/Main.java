package solver;

import gui.GUI;

import java.io.File;

public class Main {
	public static void main(String[] args) throws Exception{
		Board n = new Board(new File("puzzle1"));
		n.runmain();
		
		GUI gui = new GUI();
		gui.init(null);
	}
}
