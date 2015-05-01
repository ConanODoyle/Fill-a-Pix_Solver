import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class GridButton extends JButton{
	private static final long serialVersionUID = 1L;
	
	private String buttonText = "";
	public static final Color FILLED_COLOR = new Color(10, 10, 10);
	public boolean isClicking = false;
	public boolean isOver = false;
	private GridButton thisbutton;
	private NumberPopup num;
	private int number;
	private boolean filled;
	private boolean illegal;
	private boolean isComplete;
	
	public GridButton(int num){
		super();
		this.filled=false;
		this.illegal=false;
		this.isComplete=false;
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(20, 20));
		this.setFont(new Font("sans serif", Font.BOLD, 12));
		this.setForeground(Color.BLACK);
		this.setFocusable(true);
		
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createEmptyBorder(0, 0, 0, 0)));
		
		thisbutton = this;
		this.changeNum(num);
		this.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
				NumberPopup num = new NumberPopup(thisbutton);
				
			}

		});
	}
	public GridButton(int num,boolean filled,boolean illegal, boolean complete)
	{
		this(num);
		this.setFilled(filled);
		this.setIllegal(illegal);
		this.setComplete(complete);
	}
	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		
		if(filled != this.filled)
		{
			Color bg = getBackground();
			setBackground(this.getForeground());
			setForeground(bg);
		}
		this.filled = filled;
	}

	public int getNumber() {
		return number;
	}
	
	public void changeNum(int bt){
		if (bt >= 0){
			buttonText = "" + bt;
		} else {
			buttonText = "";
		}
		this.setText(buttonText);
		this.number = bt;
	}
	public boolean isIllegal() {
		return illegal;
	}

	public void setIllegal(boolean illegal) {
		this.illegal = illegal;
	}
	//get copy if needed
	
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public GridButton getCopy() {
		// TODO Auto-generated method stub
		return new GridButton(this.number,this.filled,this.illegal,this.isComplete);
	}
}