package impl.env;

import interfaces.env.IMap;

public class MapImpl implements IMap {
	
	public int height, width, difficulty;
	
	public MapImpl(int height, int width, int difficulty) {
		this.height = height; this.width = width; 
		this.difficulty = difficulty;
	}
	
	public int getHeight() { return height; }
	public int getWidth() { return width; }
	public int getDifficulty() { return difficulty; }

}
