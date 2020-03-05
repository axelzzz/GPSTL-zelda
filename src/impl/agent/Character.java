package impl.agent;

import interfaces.agent.ICharacter;
import utils.Direction;

public class Character extends Entity implements ICharacter {
	
	private Direction direction;
	private boolean isStep;
	
	public Character(double x, double y, Direction direction) {
		super(x, y);
		this.direction = direction;
		this.isStep = true;
	}
	
	public Direction getDirection() { return direction; }
	public void setDirection(Direction direction) { this.direction = direction; }
	public boolean step() { return isStep; }
	public void switchStep() { if (isStep) isStep = false; else isStep = true;}

}
