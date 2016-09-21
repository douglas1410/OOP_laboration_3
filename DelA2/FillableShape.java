package DelA;

import javafx.scene.paint.Color;

public abstract class FillableShape extends Shape{
	private boolean filled;
	public FillableShape() {
		super();
		filled= true;
	}
	public FillableShape(double x, double y, Color color){
		super(x, y, color);
		
	}
	
	

	public boolean isFilled(){
		return filled;
	}
	public void setFilled(boolean filled){
		this.filled=filled;
	}
}
