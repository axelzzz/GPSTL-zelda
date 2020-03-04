package impl.agent;

import impl.Stat;
import impl.Weapon;
import interfaces.IStat;
import interfaces.IWeapon;
import interfaces.agent.IPlayer;
import utils.Direction;

public class Player extends Character implements IPlayer {

	private IWeapon weapon;
	private IStat stat;
	private Direction direction;
	
	public Player(double x, double y, Direction direction) {
		super(x, y);		
		weapon = new Weapon();
		stat = new Stat();
		this.direction = direction;
	}
	
	public IWeapon getWeapon() { return weapon; }
	public IStat getStat() { return stat; } 
	public Direction getDirection() { return direction; }
	public void setDirection(Direction direction) { this.direction = direction; }
}
