package launcher;

import impl.GameEngine;
import impl.data.Data;
import impl.view.Viewer;
import javafx.animation.AnimationTimer;

import java.io.File;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import utils.Direction;
import utils.User;

public class ZeldaApp extends Application {

	private static GameEngine gameEngine;
	private static Data data;
	private static Viewer viewer;
	private static AnimationTimer timer;
	private GameMenu gameMenu;

	public static void main(String[] args) {
		gameEngine = GameEngine.getInstance();
		data = new Data();
		gameEngine.init(data);
		viewer = new Viewer(data);
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		Scene playScene = new Scene(((Viewer) viewer).getPanel());
		
		primaryStage.setTitle("Zelda");
		primaryStage.setScene(playScene);
		primaryStage.setWidth(utils.Parameters.WIDTHMENU);
		primaryStage.setHeight(utils.Parameters.HEIGHTMENU);

		playScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.LEFT) {
					gameEngine.setPlayerCommand(User.COMMAND.LEFT);
					gameEngine.setPlayerDirection(Direction.WEST);
				}
				if (event.getCode() == KeyCode.RIGHT) {
					gameEngine.setPlayerCommand(User.COMMAND.RIGHT);
					gameEngine.setPlayerDirection(Direction.EAST);
				}
				if (event.getCode() == KeyCode.UP) {
					gameEngine.setPlayerCommand(User.COMMAND.UP);
					gameEngine.setPlayerDirection(Direction.NORTH);
				}
				if (event.getCode() == KeyCode.DOWN) {
					gameEngine.setPlayerCommand(User.COMMAND.DOWN);
					gameEngine.setPlayerDirection(Direction.SOUTH);
				}
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

		// primaryStage.show();

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long l) {
				playScene.setRoot(((Viewer) viewer).getPanel());
			}
		};
		// timer.start();

		primaryStage.setTitle("Zelda");

		Group root = new Group();
		Scene scene = new Scene(root, utils.Parameters.WIDTHMENU, utils.Parameters.HEIGHTMENU);

		ImageView imv = new ImageView(
				new File("resources/vonguru_images_jeux_video_zelda_botw_cover.jpg").toURI().toString());
		imv.setFitHeight(utils.Parameters.HEIGHTMENU);
		imv.setFitWidth(utils.Parameters.WIDTHMENU);

		gameMenu = new GameMenu(primaryStage, root, playScene, timer);

		root.getChildren().add(imv);
		root.getChildren().add(gameMenu);

		primaryStage.setScene(scene);

		primaryStage.show();

		// responsiveness
		SceneSizeChangeListener sizeListener = new SceneSizeChangeListener(scene);
		scene.widthProperty().addListener(sizeListener);
		scene.heightProperty().addListener(sizeListener);

	}

	private static class SceneSizeChangeListener implements ChangeListener<Number> {
		private final Scene scene;
		private final double initHeight;
		private final double initWidth;

		public SceneSizeChangeListener(Scene scene) {
			this.scene = scene;
			this.initHeight = scene.getHeight();
			this.initWidth = scene.getWidth();
		}

		@Override
		public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
			final double newWidth = scene.getWidth();
			final double newHeight = scene.getHeight();

			Scale scale = new Scale(newWidth / initWidth, newHeight / initHeight);
			scene.getRoot().getTransforms().setAll(scale);
		}
	}

}