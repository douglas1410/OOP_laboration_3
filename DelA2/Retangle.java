package DelA;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Retangle extends FillableShape {
	private double height;
	private double width;
	public Retangle(){
		super();
		height= 50.0;
		width = 100.0;
	}
	
	public Retangle(double x,double y,Color color,double height, double width){
		super(x, y, color);
		this.height=height;
		this.width=width;
	}
	public double getWidth(){
		return width;
	}
	public double getHeight() {
		return height;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
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
