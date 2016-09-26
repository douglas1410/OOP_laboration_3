package DelA;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * An instance of Line is a line that stretches from (x,y) to (x2,y2).
 */
public class Line  extends Shape{
	private double x2;
	private double y2;
	
	/**
	 * Constructor without arguments. Initiate x2, y2 to 50.
	 */
	public Line(){
		super();
		x2=50;
		y2=50;
	}
	/**
    	* Constructor with arguments.
    	* @param x X-coordinate for start point.
    	* @param y Y-coordinate for start point.
    	* @param x2 X-coordinate for end point.
    	* @param y2 Y-coordinate for end point.
    	* @param color Color of the line.
    	*/
	public Line (double x ,double y, double x2, double y2, Color color){
		super(x, y,color);
		this.x2=x2;
		this.y2=y2;
	}
	/**
	 * Get x-coordinate of end point.
	 * @return X-coordinate of end point.
	 */
	public double getX2(){
		return x2;
	}
	/**
	 * Get y-coordinate of end point.
	 * @return y-coordinate of end point.
	 */
	public double getY2(){
		return y2;
	}
	/**
	 * Set x-coordinate of end point.
	 */
	public void setX2(double x2){
		this.x2=x2;
	}
	/**
	 * Get y-coordinate of end point.
	 */
	public void setY2(double y2){
		this.y2=y2;
	}
	/**
	 * Move the line.
	 * @param elapsedTimeNs 
	 */
	public void move(long elapsedTimeNs) {
		setX(getX()+getDx()*elapsedTimeNs / BILLION);
		setY(getY()+getDy()*elapsedTimeNs / BILLION);
        	x2 += getDx() * elapsedTimeNs / BILLION;
        	y2 += getDy() * elapsedTimeNs / BILLION;
        	//System.out.println("x+y"+ x +y);
    }
	/**
	 * @param gc The graphics context.
	 */
	@Override
	public void paint(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setStroke(getColor());
		gc.strokeLine(getX(), getY(), x2, y2);
		
	}
	/**
	 * Change direction of a moving line if it collides with the box's constrains.
	 * @param boxX X-coordinate for the box's start point.
	 * @param boxY Y-coordinate for the box's start point.
	 * @param boxWidth The box's width.
	 * @param boxHeight The box's height.
	 */
	@Override
	public void constrain(
        	double boxX, double boxY, 
       		double boxWidth, double boxHeight) {
        // If the line object outside the box - calculate new dx and dy
		if (getX() < boxX || x2<boxX) {
			setVelocity(Math.abs(getDx()), getDy());
		} else if (getX() > boxWidth || x2>boxWidth) {
        		setVelocity(-Math.abs(getDx()), getDy());
		}
        	if (getY() < boxY|| y2 <boxY) {
        		setVelocity(getDx(), Math.abs(getDy()));
        	} else if (getY() > boxHeight || y2>boxHeight) {
        		setVelocity(getDx(), -Math.abs(getDy()));
        	}
   	}
   	
	@Override  
	public String toString(){
		String info="";
		 info = super.toString()+ " x2=" +x2 +" y2=" + y2;
		return info;
	}
	
}
