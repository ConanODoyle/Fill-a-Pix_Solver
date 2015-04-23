package gui;

import javax.swing.JButton:

public class NumButton extends JButton implements MouseListener
{
  int number;
  GUI gui;
  NumberPopup numberPopup;
  public NumButton(int num,NumberPopup numberPopup, GUI gui)
  {
  	super();
  	this.number = num;
  	this.setBackground(Color.WHITE);
  	this.setPreferredSize(new Dimension(15, 15));
  	this.setForeground(Color.BLACK);
  	this.setText(num)
  	this.gui = gui;
  	this.numberPopup = numberPopup;
  }
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
  	//check if needed 
  	
  }
  @Override
  public void mousePressed(MouseEvent arg0) {
  	// check if needed
  	
  }
  @Override
  public void mouseReleased(MouseEvent arg0) {
	numberPopup.numInput(this.num);
  }
}
