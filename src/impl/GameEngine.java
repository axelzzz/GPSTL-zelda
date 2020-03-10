package impl;

import java.util.Timer;
import java.util.TimerTask;

import impl.data.Data;
import interfaces.IEngine;
import utils.Direction;
import utils.User;
import utils.User.COMMAND;

public class GameEngine implements IEngine {
	
	private static GameEngine engine = null;
	private Data data;
	private Timer engineClock;
	private User.COMMAND command;
	
	public static GameEngine getInstance() {
		if(engine == null)
			engine = new GameEngine();
		
		return engine;
	}
	
	public void init(Data data) {
		engineClock = new Timer();
		this.data = data;
		command = COMMAND.NONE;
	}

	public void start(){
		engineClock.schedule(new TimerTask(){
			public void run() {								
				switch (command) {
				case RIGHT:
					moveRight();
					data.switchStep();
					break;
				case LEFT:
					moveLeft();
					data.switchStep();
					break;
				case UP:
					moveUp();
					data.switchStep();
					break;
				case DOWN:
					moveDown();
					data.switchStep();
					break;
				default:
				}
				command = COMMAND.NONE;
			}
		},0,100);
	}

	public void stop(){
		engineClock.cancel();
	}

	public void setPlayerCommand(User.COMMAND c){
		command = c;
	}
	
	public void setPlayerDirection(Direction direction) {
		data.setPlayerDirection(direction);
	}

	private void moveLeft(){
		if (data.getPlayerPos().getX() > 0+10)
			data.setPlayerPos(data.getPlayerPos().getX()-10, data.getPlayerPos().getY());
	}

	private void moveRight(){
		if (data.getPlayerPos().getX() < data.getMapWidth()-10)
			data.setPlayerPos(data.getPlayerPos().getX()+10, data.getPlayerPos().getY());
	}

	private void moveUp(){
		if (data.getPlayerPos().getY() > 0+10)
			data.setPlayerPos(data.getPlayerPos().getX(), data.getPlayerPos().getY()-10);
	}

	private void moveDown(){
		if (data.getPlayerPos().getY() < data.getMapHeight()-10)
			data.setPlayerPos(data.getPlayerPos().getX(), data.getPlayerPos().getY()+10);
	}
}
