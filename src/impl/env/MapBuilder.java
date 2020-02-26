package impl.env;

import java.util.HashMap;

import interfaces.env.IPlayMap;
import utils.ECellType;
import utils.Parameters;

public class MapBuilder {
	
	public static IPlayMap buildMapLevel(int level) {
		HashMap<Integer, ECellType> mapCellType = new HashMap<Integer, ECellType>();
		
		IPlayMap playMap = new PlayMap(Parameters.WIDTH, Parameters.HEIGHT);
		
		return playMap;
	}

}
