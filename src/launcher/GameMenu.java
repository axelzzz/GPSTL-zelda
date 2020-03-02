package launcher;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameMenu extends Parent{	
	
	private Rectangle bg;
	
	public GameMenu(Stage s, Group root) {			
		
		VBox menu0 = new VBox(10);
		VBox menu1 = new VBox(10);
		VBox menu2 = new VBox(10);
		
		menu0.setTranslateX(100);
		menu0.setTranslateY(200);
		
		menu1.setTranslateX(100);
		menu1.setTranslateY(200);
		
		menu2.setTranslateX(100);
		menu2.setTranslateY(200);
		
		final int offset = 400;
		
		menu1.setTranslateX(offset);
		menu2.setTranslateX(offset);		
		
		MenuButton btnStart = new MenuButton("NEW GAME");
		btnStart.setOnMouseClicked(event -> {
			
			getChildren().add(menu1);
			
			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
			tt.setToX(menu0.getTranslateX() - offset);
			
			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
			tt1.setToX(menu0.getTranslateX());
			
			tt.play();
			tt1.play();
			
			tt.setOnFinished(event2 -> {
				getChildren().remove(menu0);
			});
			
			
		});
		
		MenuButton btnOptions = new MenuButton("OPTIONS");
		btnOptions.setOnMouseClicked(event -> {
			getChildren().add(menu2);
			
			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
			tt.setToX(menu0.getTranslateX() - offset);
			
			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
			tt1.setToX(menu0.getTranslateX());
			
			tt.play();
			tt1.play();
			
			tt.setOnFinished(event2 -> {
				getChildren().remove(menu0);
			});
		});
		
		MenuButton btnExit = new MenuButton("EXIT");
		btnExit.setOnMouseClicked(event -> {
			System.exit(0);
		});
		
		
		MenuButton btnBack1 = new MenuButton("BACK");
		btnBack1.setOnMouseClicked(event -> {
			getChildren().add(menu0);
			
			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
			tt.setToX(menu1.getTranslateX() + offset);
			
			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
			tt1.setToX(menu1.getTranslateX());
			
			tt.play();
			tt1.play();
			
			tt.setOnFinished(event2 -> {
				getChildren().remove(menu1);
			});
		});
		
		MenuButton btnBack2 = new MenuButton("BACK");
		btnBack2.setOnMouseClicked(event -> {
			getChildren().add(menu0);
			
			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
			tt.setToX(menu2.getTranslateX() + offset);
			
			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
			tt1.setToX(menu2.getTranslateX());
			
			tt.play();
			tt1.play();
			
			tt.setOnFinished(event2 -> {
				getChildren().remove(menu2);
			});
		});
		
		MenuButton btnMap1 = new MenuButton("EASY");
		
		btnMap1.setOnMouseClicked(event -> {
			
		});
		
		MenuButton btnMap2 = new MenuButton("MEDIUM");
		
		btnMap2.setOnMouseClicked(event -> {
			
		});

		MenuButton btnMap3 = new MenuButton("HARDCORE");
		
		
		
		//MenuButton btnSound = new MenuButton("SOUND");
		//MenuButton btnVideo = new MenuButton("VIDEO");
		
		menu0.getChildren().addAll(btnStart, btnOptions, btnExit);
		menu1.getChildren().addAll(btnMap1, btnMap2, btnMap3, btnBack1);
		menu2.getChildren().addAll(btnBack2); //, btnSound, btnVideo);
		
		bg = new Rectangle(utils.Parameters.WIDTH, utils.Parameters.HEIGHT);
		bg.setFill(Color.GREY);
		bg.setOpacity(0.4);
		
		getChildren().addAll(bg, menu0);
	}
	
	
	public void setHeight(double h) {
		bg.setHeight(h);
	}
	
	public void setWidth(double w) {
		bg.setWidth(w);
	}
	
	
	
}
