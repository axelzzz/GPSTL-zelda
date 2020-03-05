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
	private boolean isStep;
	
	public Player(double x, double y, Direction direction) {
		super(x, y);		
		weapon = new Weapon();
		stat = new Stat();
		this.direction = direction;
		this.isStep = true;
	}
	
	public IWeapon getWeapon() { return weapon; }
	public IStat getStat() { return stat; } 
	public Direction getDirection() { return direction; }
	public void setDirection(Direction direction) { this.direction = direction; }
	public boolean step() { return isStep; }
	public void switchStep() { if (isStep) isStep = false; else isStep = true;}
}
