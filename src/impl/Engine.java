package impl;

import java.util.ArrayList;
import java.util.List;

import impl.agent.Player;
import impl.env.MapImpl;
import interfaces.IEngine;
import interfaces.agent.IEntity;
import interfaces.agent.IPlayer;
import interfaces.env.IMap;
import utils.Parameters;

public class Engine implements IEngine {
	
	private static Engine engine = null;
	
	private List<IEntity> entities;	
	private IMap map;
	private IPlayer player;
	
	private Engine() {		
		entities = new ArrayList<>();		
		map = new MapImpl(Parameters.HEIGHT, Parameters.WIDTH, 1);
		player = new Player(map.getHeight()/2, map.getWidth()/2);
	}
	
	public static Engine getInstance() {
		if(engine == null)
			engine = new Engine();
		
		return engine;
	}

}
