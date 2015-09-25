package model;

public interface TileFeatureOld {
	// TODO: Make this some kind of enum
	public Boolean connectsTo(Tile destination);
	public static final Integer CITY  = 0;
	public static final Integer ROAD  = 1;
	public static final Integer GRASS = 2;

	public static final Integer NORTH = 0;
	public static final Integer EAST  = 1;
	public static final Integer SOUTH = 2;
	public static final Integer WEST  = 3;
	
}
