package impl.env;

import interfaces.env.IMap;

public class MapImpl implements IMap {
	
	public double height, width;
	int difficulty;
	
	public MapImpl(double height, double width, int difficulty) {
		this.height = height; this.width = width; 
		this.difficulty = difficulty;
	}
	
	public double getHeight() { return height; }
	public double getWidth() { return width; }
	public int getDifficulty() { return difficulty; }

}
