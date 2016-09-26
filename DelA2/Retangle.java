package DelA;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
*An instace of Retangle with height 50 and width = 100
*/
public class Retangle extends FillableShape {
	private double height;
	private double width;
	public Retangle(){
		super();
		height= 50.0;
		width = 100.0;
	}
	/**
	*Constructor without arguments initiate height = 50, width =100
	*
	*/
	public Retangle(double x,double y,Color color,double height, double width){
		super(x, y, color);
		this.height=height;
		this.width=width;
	}
	/**
	* return rectangles width
	*/
	public double getWidth(){
		return width;
	}
	/**
	*return retangles height
	*/
	public double getHeight() {
		return height;
	}
	/**
	* set a width value to the object rectangle
	*/
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	* set a Height value to the object rectangle
	*/
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	* the graphics context
	*/
	@Override
	public void paint(GraphicsContext gc) {
		gc.setFill(getColor());
		

		if(isFilled()){
			gc.setFill(getColor());
			gc.fillRect(getX(), getY(), width, height);
		}else{
			gc.strokeRect(getX(), getY(), width, height);
		}
		
	}
	/**
	* change direction of object retangle if it collides with the box's constrains
	*/
	@Override
	public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
		if (getX()<boxX) {
			setVelocity(Math.abs(getDx()), getDy());
		}else if (getX()>boxWidth-width){
			setVelocity(-Math.abs(getDx()), getDy());

		}
		 if (getY()<boxY) {
			 setVelocity(getDx(), Math.abs(getDy()));
			
		}else if(getY()>boxHeight-height){
			setVelocity(getDx(), -Math.abs(getDy()));
		}
	}
	public String toString(){
		String info="";
		return info;
	}

}
