package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu {
	JFrame initFrame = new JFrame("Start");
	JPanel contentPanel = new JPanel();
	JPanel initPanel = new JPanel();
	JPanel titlePanel = new JPanel();
	JButton file = new JButton("Select File");
	JButton grid = new JButton("Input Puzzle");
	GUI gui;
	
	public StartMenu(GUI gui){	
		this.gui = gui;	
		initFrame.setContentPane(contentPanel);

		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
		titlePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(""), BorderFactory.createEmptyBorder(30, 0, 0, 0)));
		JLabel title = new JLabel("Fill-a-Pix Solver");
		JLabel credits = new JLabel("By Samuel Sze");
		title.setAlignmentX(Panel.CENTER_ALIGNMENT);
		credits.setAlignmentX(Panel.CENTER_ALIGNMENT);
		titlePanel.add(title);
		titlePanel.add(credits);
		titlePanel.setPreferredSize(new Dimension(100, 100));
		
		initPanel.setLayout(new BoxLayout(initPanel, BoxLayout.Y_AXIS));
		initPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(""), BorderFactory.createEmptyBorder(15, 5, 15, 5)));
		
		file.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		grid.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		file.setFocusable(false);
		grid.setFocusable(false);
		
		file.setAlignmentX(Panel.CENTER_ALIGNMENT);
		grid.setAlignmentX(Panel.CENTER_ALIGNMENT);
		file.setMargin(new Insets(15, 15, 15, 15));
		grid.setMargin(new Insets(15, 15, 15, 15));
		file.setBackground(new Color(230,230,230));
		grid.setBackground(new Color(230,230,230));
		
		file.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		initPanel.add(file);
		JPanel spacer = new JPanel();
		initPanel.add(spacer);
		initPanel.add(grid);
		
		contentPanel.add(titlePanel);
		contentPanel.add(initPanel);

		initFrame.pack();
		initFrame.setVisible(true);
		initFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void closeScreen(){
		initFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initFrame.removeAll();
		initFrame.dispatchEvent(new WindowEvent(initFrame, WindowEvent.WINDOW_CLOSING));
	}
}
