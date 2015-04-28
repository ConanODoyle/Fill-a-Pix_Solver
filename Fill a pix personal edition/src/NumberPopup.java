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
    private int posX;
    private int posY;
    private GUI gui;
    private GridButton gridbutton;
    
    public NumberPopup(GUI gui, GridButton button, int x, int y)
    {
        super("Pick One!");
        this.gui = gui;
        this.setContentPane(content);
        content.setLayout(new GridLayout(0,3));
        this.posX = x;
        this.posY = y;
        this.gridbutton = button;
        
        //TODO: Reformat into a nicer box.
        //TODO: Add KeyboardListeners to listen for number presses.
        for(int i = 0; i < 10; i++)
        {
            content.add(new NumButton(i, this, gui));
        }
        content.add(new NumButton(-1, this, gui));
        
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
        gui.setButtonValue(this.posY,this.posX,n);
        this.gridbutton.changeText(n);
        this.dispose();
    }
}