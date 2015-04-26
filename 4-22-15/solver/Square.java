package solver;

public class Square {
	private int number;
	private boolean filled;
	private boolean illegal;
	private boolean isComplete = false;
	
	public Square(int n, boolean f){
		this(n, f, false, false);
	}
	public Square()
	{
		
	}
	public Square(int n, boolean f, boolean i, boolean c){
		setNumber(n);
		setFilled(f);
		setIllegal(i);
		setComplete(c);
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isIllegal() {
		return illegal;
	}

	public void setIllegal(boolean illegal) {
		this.illegal = illegal;
	}
	
	public Square getCopy(){
		return new Square(this.number, this.filled, this.illegal, this.isComplete);
	}
	
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
}
