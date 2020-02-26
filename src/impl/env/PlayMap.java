package impl.env;

import interfaces.env.IPlayMap;
import utils.ECellType;

public class PlayMap implements IPlayMap {
	
	private int height, width, difficulty;
	private ECellType[][] mapMatrix = new ECellType[5][5];
	
	public PlayMap(int width, int height, int difficulty, ECellType[][] mapMatrix) {
		this.width = width; 
		this.height = height; 
		this.difficulty = difficulty;
		this.mapMatrix = mapMatrix;
	}
	
	public PlayMap(int width, int height) {
		this.width = width; 
		this.height = height; 
	}
	
	public int getHeight() { return height; }
	public int getWidth() { return width; }
	public int getDifficulty() { return difficulty; }
	public ECellType[][] getMapMatrix() { return mapMatrix; }

	@Override
	public ECellType getCellType(int i, int j) {
		return mapMatrix[i][j];
	}

	@Override
	public void setCellType(int i, int j, ECellType cell) {
		mapMatrix[i][j] = cell;
	}

}
