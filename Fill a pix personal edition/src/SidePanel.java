
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SidePanel extends JPanel{
	private JPanel panel;
	private JTextField field;
	private JButton solvebutton;
	private JButton savebutton;
	private JTextField name;
	private boolean solved;
	private GUI gui;
	
	public SidePanel(GUI gui)
	{
		super();
		this.setLayout(new FlowLayout());
		
		field = new JTextField("Fill a pix solver thing WIP");
		this.add(field);
		
		solvebutton = new JButton("Solve!");
		solvebutton.setFont(new Font("sans serif", Font.BOLD, 12));
		solvebutton.setPreferredSize(new Dimension(50,50));
		this.add(solvebutton);
		solvebutton.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
				gui.solve();
			}
		
		
		});
		this.name = new JTextField("enter filename");
		this.name.setEditable(true);
		this.add(this.name);
		savebutton = new JButton("Save!");
		savebutton.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					gui.save(name.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		this.add(savebutton);
	}
	public void solved()
	{
		if(solved)
		{
			this.solvebutton.setText("Solved!");
		}
		else
		{
			this.solvebutton.setText("Reverse!");
		}
	}
}
