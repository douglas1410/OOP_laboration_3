package DelA;

import javafx.scene.paint.Color;

/**
 * FillableShape is a Shape with a color fill
 * @author Vilhelm Edwall & Douglas Pham
 */
public abstract class FillableShape extends Shape{
	
	private boolean filled;
	
	/**
     	 * Constructor without arguments, initiate filled to false.
     	 */
	public FillableShape() {
		super();
		filled = false;
	}
	
	/**
     	 * Constructor with arguments.
     	 * @param x X-coordinate.
     	 * @param y Y-coordinate.
     	 * @param color Color of the shape.
     	 * @param filled Set to <CODE>true</CODE> if shape should be filled, otherwise <CODE>false</CODE>.
         */
	public FillableShape(double x, double y, Color color, boolean filled){
		super(x, y, color);
		this.filled = filled;
	}
	
	
	/**
         * Tell whether the shape is filled or not.
	 * @return <CODE>true</CODE> if shape is filled, otherwise <CODE>false</CODE>.
	 */
	public boolean isFilled(){
		return filled;
	}
	/**
	 * Set the shape to filled or not filled.
	 * @param filled <CODE>true</CODE> if filled, otherwise <CODE>false</CODE>
	 */
	public void setFilled(boolean filled){
		this.filled=filled;
	}
}
