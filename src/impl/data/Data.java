package impl.data;

import java.util.ArrayList;
import java.util.List;

import impl.agent.Player;
import impl.env.MapBuilder;
import interfaces.agent.IEntity;
import interfaces.agent.IPlayer;
import interfaces.env.IPlayMap;
import utils.ECellType;
import utils.Parameters;
import utils.Position;

public class Data {
	private List<IEntity> entities;	
	private IPlayMap map;
	private IPlayer player;
	private int level = 1;
	
	public Data() {
		entities = new ArrayList<>();
		map = MapBuilder.buildMapLevel(level);
		player = new Player(Parameters.WIDTH/2, Parameters.HEIGHT/2);
	}

	public void setPlayerPos(double x, double y) {
		player.getPos().setX(x);
		player.getPos().setY(y);
	}
	
	public Position getPlayerPos() {
		return player.getPos();
	}
	
	public int getMapWidth() {
		return map.getWidth();
	}
	public int getMapHeight() {
		return map.getHeight();
	}
	public ECellType getCellNature(int i, int j) {
		return map.getCellType(i, j);
	}
	public int getLevel() {
		return level;
	}
}
