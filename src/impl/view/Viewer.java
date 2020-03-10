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
import utils.Direction;

public class Viewer {
	
	String MAP_PATH = "ressources/map";
	String SPRITES_PATH = "resources/sprites";
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
		if (playerX + halfVisibX >= Parameters.WIDTH) {
			xSource = Parameters.WIDTH - Parameters.visibilityWidth;
		}
		if (playerY + halfVisibY >= Parameters.HEIGHT) {
			ySource = Parameters.HEIGHT -Parameters.visibilityHeight;
		}

        canvas.getGraphicsContext2D().drawImage(
              backgroungImage, xSource, ySource, Parameters.visibilityWidth, Parameters.visibilityWidth, 0, 0, Parameters.visibilityWidth, Parameters.visibilityWidth
        );
        
        Image playerImage = getPlayerSprite(data);
        
        canvas.getGraphicsContext2D().drawImage(playerImage, 
        		data.getPlayerPos().getX()-xSource-(playerImage.getWidth()/2), 
        		data.getPlayerPos().getY()-ySource-(playerImage.getHeight()/2)
        );

    	Group panel = new Group();
	    panel.getChildren().addAll(canvas);
	    return panel;    
	}
	
	
	public Image getPlayerSprite(Data data) {
		
		String path = SPRITES_PATH+"/link";
		
		switch(data.getPlayer().getDirection()) {
		
			case EAST :
				if(data.getPlayer().step()) path+="E1"; else path+="E2"; 				
				break;
			case SOUTH :
				if(data.getPlayer().step()) path+="S1"; else path+="S2"; 
				break;
			case WEST :
				if(data.getPlayer().step()) path+="W1"; else path+="W2"; 
				break;
			case NORTH :
				if(data.getPlayer().step()) path+="N1"; else path+="N2"; 
				break;
		
		}
		path+=".png";
		
		return new Image(new File(path).toURI().toString());
	}
}
