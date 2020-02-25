package launcher;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
 
public class ZeldaApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
    	Rectangle view = new Rectangle(100, 110, Color.CRIMSON);
        
        StackPane root = new StackPane();
        root.getChildren().add(view);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Zelda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}