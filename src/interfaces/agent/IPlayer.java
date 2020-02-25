package interfaces.agent;

import interfaces.IStat;
import interfaces.IWeapon;

public interface IPlayer {

	public IWeapon getWeapon();
	public IStat getStat();
}
