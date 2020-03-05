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
	
	public Player(double x, double y, Direction direction) {
		super(x, y, direction);		
		weapon = new Weapon();
		stat = new Stat();
	}
	
	public IWeapon getWeapon() { return weapon; }
	public IStat getStat() { return stat; } 
}
