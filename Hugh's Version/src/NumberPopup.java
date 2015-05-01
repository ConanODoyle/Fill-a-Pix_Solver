import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class NumberPopup extends JFrame
{
    private JPanel content = new JPanel();
    private GridButton gridbutton;
    
    public NumberPopup(GridButton button)
    {
        super("Pick One!");
        this.setContentPane(content);
        content.setLayout(new GridLayout(0,3));
        this.gridbutton = button;
        
        //TODO: Reformat into a nicer box.
        //TODO: Add KeyboardListeners to listen for number presses.
        for(int i = 0; i < 10; i++)
        {
            content.add(new NumButton(i, this));
        }
        content.add(new NumButton(-1, this));
        
        this.addKeyListener(new KeyListener(){
	    	@Override
	    	public void keyPressed(KeyEvent arg0) {	
	    	}
	
	    	@Override
	    	public void keyReleased(KeyEvent arg0) {
	    	}
	
	    	@Override
	    	public void keyTyped(KeyEvent arg0) {
	    		int a = Integer.parseInt(Character.toString(arg0.getKeyChar()));
	    		numInput(a);
	    	}
    	});
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
    }
    
    void numInput(int n)
    {
        this.gridbutton.changeNum(n);
        this.dispose();
    }
}