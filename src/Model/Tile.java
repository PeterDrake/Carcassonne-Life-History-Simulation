/***
 * (c) 2015 Team Life History Simulation
 * All rights reserved.
 *
 * Carcassonne Project - A Board Game
 * Tile.java - The Carcassonne tile that makes up the board grid
 * Each tile references its cardinal neighbors, as well as followers and players
 */


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
