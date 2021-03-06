import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StartMenu{
	protected JFrame initFrame = new JFrame("Start");
	private JPanel contentPanel = new JPanel();
	private JPanel initPanel = new JPanel();
	private JPanel titlePanel = new JPanel();
	private JButton file = new JButton("Select File");
	private JButton grid = new JButton("Input Puzzle");
	private GUI gui;
	private int isClicking = 0;
	private int isOverButton = 0;
	private StartMenu thisthing = this;

	private static final Border FUNSELECTED = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createEmptyBorder(5, 10, 5, 10));
	private static final Border FSELECTED = BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createEmptyBorder(5, 10, 5, 10));
	
	private static final Border GUNSELECTED = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5));
	private static final Border GSELECTED = BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5));
	
	
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
		
		file.setBorder(FUNSELECTED);
		file.setFocusable(false);
		file.setAlignmentX(Panel.CENTER_ALIGNMENT);
		file.setMargin(new Insets(15, 15, 15, 15));
		file.setBackground(new Color(230,230,230));

		grid.setBorder(GUNSELECTED);
		grid.setFocusable(false);
		grid.setAlignmentX(Panel.CENTER_ALIGNMENT);
		grid.setMargin(new Insets(15, 15, 15, 15));
		grid.setBackground(new Color(230,230,230));
		
		file.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				isOverButton = 1;
				if (isClicking == 1){
					file.setBorder(FSELECTED);
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				isOverButton = 0;
				file.setBorder(FUNSELECTED);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				isClicking = 1;
				file.setBorder(FSELECTED);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (isClicking == 1 && isOverButton == 1){
					System.out.println("file");
					FilePopup fp = new FilePopup(gui);
					System.out.println("tried");
				}
				isClicking = 0;	
				file.setBorder(FUNSELECTED);
			}
		});
		grid.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				isOverButton = 2;
				if (isClicking == 2){
					grid.setBorder(GSELECTED);
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				isOverButton = 0;
				grid.setBorder(GUNSELECTED);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				isClicking = 2;
				grid.setBorder(GSELECTED);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (isClicking == 2 && isOverButton == 2){
					System.out.println("grid");
					DiaPopup popup = new DiaPopup(gui,thisthing);
				}
				isClicking = 0;	
				grid.setBorder(GUNSELECTED);
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
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		initFrame.setLocation(dim.width/2-initFrame.getSize().width/2, dim.height/2-initFrame.getSize().height/2);
	}
	
	public void closeScreen(){
		initFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initFrame.removeAll();
		initFrame.dispatchEvent(new WindowEvent(initFrame, WindowEvent.WINDOW_CLOSING));
	}
}