import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.filechooser.*;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FilePopup
{
    private JFileChooser filer;
    public File file;
    private JFrame mainFrame;
    private JPanel hold;
    private JTextField irl;
    private JButton open;
    private JButton accept;
    GUI gui;
    
    public FilePopup(GUI gui)
    {
        mainFrame = new JFrame("Enter a file!");
        hold = new JPanel();
        this.gui = gui;
        mainFrame.add(hold);
        
        hold.setLayout(new BoxLayout (hold,BoxLayout.Y_AXIS));
        irl = new JTextField();
        irl.setEditable(false);
        hold.add(irl);
        
        filer = new JFileChooser();
        open = new JButton("Open");
        accept = new JButton("Yes");
        open.addMouseListener(new MouseListener(){

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
				int returnVal = filer.showOpenDialog(mainFrame);
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
             file = filer.getSelectedFile();
             irl.setText(file.getName());
            }
			}});
        accept.addMouseListener(new MouseListener(){

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
				  if(file!= null)
            {
            	try {
					gui.load(file);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            mainFrame.dispose();
			}});
        hold.add(open);
        hold.add(accept);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}