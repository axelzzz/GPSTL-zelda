package interfaces.agent;

import interfaces.IStat;
import interfaces.IWeapon;

public interface IPlayer extends ICharacter {

	public IWeapon getWeapon();
	public IStat getStat();
}
