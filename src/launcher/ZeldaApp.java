package launcher;
 
import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
 
public class ZeldaApp extends Application {
    
	private GameMenu gameMenu;
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Zelda");
		
		Group root = new Group();
		Scene scene = new Scene( root, utils.Parameters.WIDTH, utils.Parameters.HEIGHT);
		
		ImageView imv = new ImageView(new File("resources/vonguru_images_jeux_video_zelda_botw_cover.jpg").toURI().toString());
		imv.setFitHeight(utils.Parameters.HEIGHT);
		imv.setFitWidth(utils.Parameters.WIDTH);
		
		gameMenu = new GameMenu(primaryStage, root);		
		
		root.getChildren().add(imv);
		root.getChildren().add(gameMenu);
		
		primaryStage.setScene(scene);
        
        primaryStage.show();
	}
	
	
	
    public static void main(String[] args) {
        launch(args);
    }
    
}