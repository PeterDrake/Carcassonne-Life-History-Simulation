package Model;
import java.util.List;


public class Tile {
	
	// Private members to store tile features
	// Edges
	private TileFeature north;
	private TileFeature east;
	private TileFeature south;
	private TileFeature west;
	// Rotation
	// Image?
	
	// Features:
	// - Road End
	// - City Connects
	// - City Shield
	
	/**
	 * Construct a new tile with properties
	 * 
	 * @param north
	 * @param east
	 * @param south
	 * @param west
	 */
	public void Tile(TileFeature north, TileFeature east, TileFeature south, TileFeature west) {
		this.north = north;
		this.east = south;
	}
	
	public TileFeature getNorthFeature() {
		return null;
	}
}
