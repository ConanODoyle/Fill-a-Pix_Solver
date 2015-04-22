package solver;

import gui.GUI;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Exception{
		Board n = new Board();
		n.runmain();
		
		GUI gui = new GUI();
		gui.init(null);
	}
}
