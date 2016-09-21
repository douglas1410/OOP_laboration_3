/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author v
 */

import javafx.scene.canvas.*;

public class Line {
    
    double x2;
    double y2;
    
    public Line(double x2, double y2) {
        this.x2 = x2;
        this.y2 = y2;
    } 

    public double getX2(){
        return 0;
    }
    
    public double getY2(){
        return 0;
    }
    
    public void setX2(double x2){
        this.x2 = x2;
    }
    public void setY2(double y2){
        this.y2 = y2;
    }
    public void paint(GraphicsContext gc){
        
    }
    public void constrain(double boxX, double boxY, 
            double boxWidth, double boxHeight) {
        
    }
}



