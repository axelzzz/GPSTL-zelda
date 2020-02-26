package impl.view;

import java.io.File;

import impl.data.Data;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import utils.Parameters;

public class Viewer {
	
	String MAP_PATH = "ressources/map";
	Data data;
	
	public Viewer(Data data) {
		this.data = data;
	}
	
	public Parent getPanel(){
		Image backgroungImage = new Image(new File(MAP_PATH + data.getLevel() +".png").toURI().toString());
		double w = backgroungImage.getWidth();
		double h = backgroungImage.getHeight();
		double halfVisibX = Parameters.visibilityWidth/2;
		double halfVisibY = Parameters.visibilityHeight/2;
		Canvas canvas = new Canvas(w, h);
		double playerX = data.getPlayerPos().getX();
		double playerY = data.getPlayerPos().getY();
		double xSource = playerX-halfVisibX < 0 ? 0 : playerX-halfVisibX;
		double ySource = playerY-halfVisibY < 0 ? 0 : playerY-halfVisibY;

        canvas.getGraphicsContext2D().drawImage(
              backgroungImage, xSource, ySource, Parameters.visibilityWidth, Parameters.visibilityWidth, 0, 0, Parameters.visibilityWidth, Parameters.visibilityWidth
        );
        double playerViewX = data.getPlayerPos().getX();
        double playerViewY = data.getPlayerPos().getY();
    	Circle player = new Circle(data.getPlayerPos().getX()-xSource,data.getPlayerPos().getY()-ySource,20);
    	player.setFill(Color.RED);
//        StackPane root = new StackPane();
//        root.getChildren().add(view);
//        root.getChildren().add(player);
    	Group panel = new Group();
	    panel.getChildren().addAll(canvas,player);
	    return panel;    
	}
}
