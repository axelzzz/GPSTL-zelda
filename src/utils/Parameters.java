package utils;

import java.util.HashMap;

public class Parameters {
	
	public Parameters() {}
	/*dimensions de la map*/
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 1024;
	public static int TILESIZE = 32;
	/*dimensions de la fenêtre de jeu*/
	public static int visibilityWidth = 15*TILESIZE;
	public static int visibilityHeight = 15*TILESIZE;	
	public static String baseDirectory = "ressources";
	public static HashMap<Integer, ECellType> mapCellType = new HashMap<Integer, ECellType>();
	public static int[][] MAP1 = new int[][]{ //plutot construction en lecture après
		{0,0,0,0,0},
		{0,1,1,0,0},
		{0,1,0,0,0},
		{0,0,0,0,0},
		{0,1,1,1,0} }; 

	public static final double HEIGHTMENU = 720;
	public static final double WIDTHMENU = 1280;
}
