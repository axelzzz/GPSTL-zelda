package launcher;
 
import impl.GameEngine;
import impl.data.Data;
import impl.view.Viewer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import utils.User;
 
public class ZeldaApp extends Application {
    
	private static GameEngine gameEngine;
	private static Data data;
	private static Viewer viewer;
	private static AnimationTimer timer;

	
    public static void main(String[] args) {
    	gameEngine = GameEngine.getInstance();
    	data = new Data();
    	gameEngine.init(data);
        viewer = new Viewer(data);
        launch(args);
    }
	
    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(((Viewer)viewer).getPanel());;
        primaryStage.setTitle("Zelda");
        primaryStage.setScene(scene);
        primaryStage.setWidth(utils.Parameters.visibilityWidth);
        primaryStage.setHeight(utils.Parameters.visibilityHeight);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
        	@Override
        	public void handle(KeyEvent event) {
        		if (event.getCode()==KeyCode.LEFT) gameEngine.setPlayerCommand(User.COMMAND.LEFT);
        		if (event.getCode()==KeyCode.RIGHT) gameEngine.setPlayerCommand(User.COMMAND.RIGHT);
        		if (event.getCode()==KeyCode.UP) gameEngine.setPlayerCommand(User.COMMAND.UP);
        		if (event.getCode()==KeyCode.DOWN) gameEngine.setPlayerCommand(User.COMMAND.DOWN);
        		event.consume();
        	}
        });
        primaryStage.setOnShown(new EventHandler<WindowEvent>() {
        	@Override
        	public void handle(WindowEvent event) {
        		gameEngine.start();
        	}
        });
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        	@Override
        	public void handle(WindowEvent event) {
        		gameEngine.stop();
        	}
        });

        primaryStage.show();

        timer = new AnimationTimer() {
        	@Override
        	public void handle(long l) {
        		scene.setRoot(((Viewer)viewer).getPanel());
        	}
        };
          timer.start();
        
    }
    

    
}