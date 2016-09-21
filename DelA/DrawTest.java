package DelA;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class DrawTest extends Application {	
		private World world;
	    public static void main(String[] args) {
	        launch(args);
	    }
	 
	    @Override
	    public void start(Stage primaryStage) {
	        primaryStage.setTitle("Drawing Operations Test");
	        Group root = new Group();
	        Canvas canvas = new Canvas(300, 400);
	        world = new World(canvas.getWidth(), canvas.getHeight());
	        GraphicsContext gc = canvas.getGraphicsContext2D();
	        draw(gc);
	        root.getChildren().add(canvas);
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
	    }
	    public void draw(GraphicsContext gc){
	    	for (Shape p:world.getShapes()){
	    		p.paint(gc);
	    	}
	    }
	   

}
