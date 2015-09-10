package Model;

public interface TileFeature {
	public Boolean connectsTo(Tile destination);
	public static final Integer CITY = 0;
	public static final Integer ROAD = 1;
	public static final Integer GRASS = 2;
}
