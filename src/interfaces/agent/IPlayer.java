package interfaces.agent;

import interfaces.IStat;
import interfaces.IWeapon;
import utils.Direction;

public interface IPlayer extends ICharacter {

	public IWeapon getWeapon();
	public IStat getStat();
	
}
