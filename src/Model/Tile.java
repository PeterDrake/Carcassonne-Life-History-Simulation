/***
 * (c) 2015 Team Life History Simulation
 * All rights reserved.
 *
 * Carcassonne Project - A Board Game
 * Tile.java - The Carcassonne tile that makes up the board grid
 * Each tile references its cardinal neighbors, as well as followers and players
 */


package Model;
import java.awt.List;


public class Tile {

	// Private members to store tile features
	// Edges
	private TileEdge north;
	private TileEdge east;
	private TileEdge south;
	private TileEdge west;
	// Rotation

	/**
	 * Construct a new tile with properties
	 *
	 * @param north
	 * @param east
	 * @param south
	 * @param west
	 */
	public void Tile(TileEdge north, TileEdge east, TileEdge south, TileEdge west) {

	}

	public TileEdge getNorthFeature() {
		return null;
	}

}
