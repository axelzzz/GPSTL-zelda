package launcher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class testAnimation extends Application {

	@Override
	public void start(Stage theStage) {
		try {
			theStage.setTitle("Timeline Example");

			Pane root = new Pane();
			Scene theScene = new Scene(new Group(root));
			theStage.setScene(theScene);

			Canvas canvas = new Canvas(512, 512);
			root.getChildren().add(canvas);

			GraphicsContext gc = canvas.getGraphicsContext2D();

			Image earth = new Image(new FileInputStream("resources/earth.png"));
			Image sun = new Image(new FileInputStream("resources/sun.png"));
			Image space = new Image(new FileInputStream("resources/space.png"));

			final long startNanoTime = System.nanoTime();
			new AnimationTimer() {
				public void handle(long currentNanoTime) {
					double t = (currentNanoTime - startNanoTime) / 1000000000.0;

					double x = 232 + 128 * Math.cos(t);
					double y = 232 + 128 * Math.sin(t);

					// background image clears canvas
					gc.drawImage(space, 0, 0);
					gc.drawImage(earth, x, y);
					gc.drawImage(sun, 196, 196);
				}
			}.start();
			theStage.show();

			final double initWidth = theScene.getWidth();
			final double initHeight = theScene.getHeight();
			final double ratio = initWidth / initHeight;

//			System.out.println("W=" + initWidth + " H=" + initHeight + " ratio=" + ratio);
			SceneSizeChangeListener sizeListener = new SceneSizeChangeListener(theScene, ratio, initHeight, initWidth,
					root);
			theScene.widthProperty().addListener(sizeListener);
			theScene.heightProperty().addListener(sizeListener);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static class SceneSizeChangeListener implements ChangeListener<Number> {
		private final Scene scene;
		private final double ratio;
		private final double initHeight;
		private final double initWidth;
		private final Pane contentPane;

		public SceneSizeChangeListener(Scene scene, double ratio, double initHeight, double initWidth,
				Pane contentPane) {
			this.scene = scene;
			this.ratio = ratio;
			this.initHeight = initHeight;
			this.initWidth = initWidth;
			this.contentPane = contentPane;
		}

		@Override
		public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
			final double newWidth = scene.getWidth();
			final double newHeight = scene.getHeight();
//			System.out.println(" oldX=" + initWidth+ " oldY=" + initHeight + " newX=" + newWidth+ "newY=" + newHeight);

			// proportionnellement
			double scaleFactor = newWidth / newHeight > ratio ? newHeight / initHeight : newWidth / initWidth;
			Scale scale = new Scale(scaleFactor, scaleFactor);
			scene.getRoot().getTransforms().setAll(scale);

			// etendre
//			Scale scale = new Scale(newWidth/initWidth, newHeight/initHeight);
//			scene.getRoot().getTransforms().setAll(scale);

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
