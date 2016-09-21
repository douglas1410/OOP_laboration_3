/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * FillableShape is a Shape with a color fill
 * @author Vilhelm
 */
public abstract class FillableShape extends Shape {
    
    private boolean filled;
    
    
    /**
     * Constructor, initiates filled to false.
     */
    public FillableShape() {
        filled = false;
    }
    
    /**
     * Tell whether the shape is filled or not.
     * @return <CODE>true</CODE> if shape is filled, otherwise <CODE>false</CODE>.
     */
    public boolean isFilled() {
        return filled;
    }
    
    /**
     * Set the shape to filled or not filled.
     * @param filled <CODE>true</CODE> if filled, otherwise <CODE>false</CODE>
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
