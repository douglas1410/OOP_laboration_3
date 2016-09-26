package DelA;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
* the class defines a circle that can move and change direction
*/
public class Circle extends FillableShape {
	private double diameter;
	/**
	* constuctor without arguments
	*/
	public Circle() {
		super();
		diameter =1;
		
	}
	/**
	* constructor with a start point and diameter in arguments
	*/
	public Circle(double x ,double y ,Color color , double diameter){
		super(x, y, color);
		this.diameter= diameter;
		
	}
	/**
	* return diameter
	*/
	
	 public double getDiameter() {
		return diameter;
	}
	/**
	* set a new diameter value to circle object
	*/
	public void setDiameter(double diameter){
		this.diameter=diameter;
	}
	/**
	* change direction of circle object if it collides with the box's constranins
	*/
	 public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
		if (getX()<boxX) {
			setVelocity(Math.abs(getDx()), getDy());
			
		}else if (getX()>boxWidth-diameter){
			setVelocity(-Math.abs(getDx()), getDy());

		}
		 if (getY()<boxY) {
			 setVelocity(getDx(), Math.abs(getDy()));
			
		}else if(getY()>boxHeight-diameter){
			setVelocity(getDx(), -Math.abs(getDy()));
		}
		

	}
	/**
	* the graphics context 
	*/
	@Override
	public void paint(GraphicsContext gc) {
		gc.setFill(getColor());

		if(isFilled()){
			gc.setFill(getColor());
			gc.fillOval(getX(), getY(), diameter, diameter);
		}else{
			gc.strokeOval(getX(), getY(), diameter, diameter);
		}

	}
	
	
	public String toString(){
		String info ="";
		info = super.toString()+ diameter;
		return info;
	}
	

}
