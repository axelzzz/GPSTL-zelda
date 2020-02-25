package launcher;
 
import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
 
public class ZeldaApp extends Application {
    
	/*
    @Override
    public void start(Stage primaryStage) {
        
    	Rectangle view = new Rectangle((double)utils.Parameters.HEIGHT, (double)utils.Parameters.WIDTH, Color.BEIGE);
    	//Circle player = new Circl
        
        StackPane root = new StackPane();
        root.getChildren().add(view);

        Scene scene = new Scene(root, 1024, 720);

        primaryStage.setTitle("Zelda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/
    
	
	public void start(Stage theStage) 
	{
	    theStage.setTitle( "Timeline Example" );
	 
	    Group root = new Group();
	    Scene theScene = new Scene( root );
	    theStage.setScene( theScene );
	 
	    Canvas canvas = new Canvas( 512, 512 );
	    root.getChildren().add( canvas );
	 
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	 
	    Image earth = new Image("file::src/lancher/earth.png");
	    Image sun   = new Image("file::src/lancher/sun.png" );
	    Image space = new Image("file::src/lancher/space.png" );
	 
	    final long startNanoTime = System.nanoTime();
	 
	    new AnimationTimer()
	    {
	        public void handle(long currentNanoTime)
	        {
	            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
	 
	            double x = 232 + 128 * Math.cos(t);
	            double y = 232 + 128 * Math.sin(t);
	 
	            // background image clears canvas
	            gc.drawImage( space, 0, 0 );
	            gc.drawImage( earth, x, y );
	            gc.drawImage( sun, 196, 196 );
	        }
	    }.start();
	 
	    theStage.show();
	}
	
    public static void main(String[] args) {
        launch(args);
    }
    
}