package interfaces.agent;

import utils.Direction;

public interface ICharacter extends IEntity {

	public Direction getDirection();
	public void setDirection(Direction direction);
	public boolean step();
	public void switchStep();
}
