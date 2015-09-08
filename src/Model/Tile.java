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
import java.util.Map;


public class Tile {

	// Private members to store tile features
	// Edges
	private TileFeature north;
	private TileFeature east;
	private TileFeature south;
	private TileFeature west;
	// Rotation
	private Integer rotation;
	// Image?
	
	// Features:
	// - Road End
	private Boolean roadObstruction;
	// - City Connects
	private Boolean cityConnects;
	// - City Shield
	private Boolean cityShield;
	
	
	/**
	 * Construct a new tile with features
	 *
	 * @param north
	 * @param east
	 * @param south
	 * @param west
	 */
	public void Tile(TileFeature north, TileFeature east, TileFeature south, TileFeature west) {
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
	}
	
	public TileFeature getNorthFeature() {
		return this.north;
	}
	public TileFeature getEastFeature() {
		return this.east;
	}
	public TileFeature getSouthFeature() {
		return this.south;
	}
	public TileFeature getWestFeature() {
		return this.west;
	}

}
