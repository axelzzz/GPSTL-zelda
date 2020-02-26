package impl.agent;

import interfaces.agent.IEntity;
import utils.Position;

public class Entity implements IEntity {

	private Position pos;
	
	public Entity(double x, double y) {
		this.pos = new Position(x, y);
	}
	
	public Position getPos() {return pos;}
	public void setPos(double x, double y) { 
		pos.setX(x);
		pos.setY(y);
	}
}
