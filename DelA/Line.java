package DelA;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Line  extends Shape{
	private double x2;
	private double y2;

	public Line(){
		super();
		x2=50;
		y2=50;
	}
	public Line (double x ,double y, double x2, double y2, Color color){
		super(x, y,color);
		this.x2=x2;
		this.y2=y2;
	}
	public double getX2(){
		return x2;
	}
	public double getY2(){
		return y2;
	}
	public void setX2(double x2){
		this.x2=x2;
	}
	public void setY2(double y2){
		this.y2=y2;
	}
	public void move(long elapsedTimeNs) {
		setX(getX()+getDx()*elapsedTimeNs / BILLION);
		setY(getY()+getDy()*elapsedTimeNs / BILLION);
        x2 += getDx() * elapsedTimeNs / BILLION;
        y2 += getDy() * elapsedTimeNs / BILLION;
        //System.out.println("x+y"+ x +y);
    }

	@Override
	public void paint(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setStroke(getColor());
		gc.strokeLine(getX(), getY(), x2, y2);
		
	}
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
	   
	public String toString(){
		String info="";
		 info = super.toString()+ " x2=" +x2 +" y2=" + y2;
		return info;
	}
	
}
