package interfaces.env;

import utils.ECellType;

public interface IPlayMap {
	
	public int getHeight();
	public int getWidth();
	public int getDifficulty();
	public ECellType[][] getMapMatrix();
	public ECellType getCellType(int i, int j);
	public void setCellType(int i, int j, ECellType cell);
}
