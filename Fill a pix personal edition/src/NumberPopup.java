import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class NumberPopup extends JFrame
{
<<<<<<< HEAD
    private JPanel content = new JPanel();
    private int posX;
    private int posY;
    private GUI gui;
    private GridButton gridbutton;
    
=======
    JPanel content = new JPanel();
    int posX;
    int posY;
    GUI gui;
    GridButton gridbutton;
>>>>>>> origin/master
    public NumberPopup(GUI gui, GridButton button, int x, int y)
    {
        super("Pick One!");
        this.gui = gui;
        this.setContentPane(content);
        content.setLayout(new GridLayout(0,3));
<<<<<<< HEAD
        this.gridbutton = button;
=======
        this.gridbutton = gridbutton;
>>>>>>> origin/master
        
        //TODO: Reformat into a nicer box.
        //TODO: Add KeyboardListeners to listen for number presses.
        for(int i = 0; i < 10; i++)
        {
            content.add(new NumButton(i, this, gui));
        }
        content.add(new NumButton(-1, this, gui));
        this.pack();
        this.setVisible(true);
    }
    
    void numInput(int n)
    {
        gui.setButtonValue(this.posY,this.posX,n);
<<<<<<< HEAD
        this.gridbutton.changeText(n);
        this.dispose();
    }
}
=======
        gridbutton.changeText(n);
        this.dispose();
    }
}
>>>>>>> origin/master
