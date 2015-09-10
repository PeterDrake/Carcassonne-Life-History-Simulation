package Model;

public interface TileFeature {
	public Boolean connectsTo(Tile destination);
	public static final Integer city = 0;
	public static final Integer road = 1;
	public static final Integer grass = 2;
}
