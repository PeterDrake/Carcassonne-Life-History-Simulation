/***
 * (c) 2015 Team Life History Simulation
 * All rights reserved.
 *
 * Carcassonne Project - A Board Game
 * Tile.java - The Carcassonne tile that makes up the board grid
 * Each tile references its cardinal neighbors, as well as followers and players
 */


package Model;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Tile {

	// Private members to store tile features
	// Edges
	private Integer north;
	private Integer east;
	private Integer south;
	private Integer west;
	// Rotation
	private Integer rotation;
	// Image, 256x256 PNG
	private Image image;
	
	// Features:
	// - Road End
	private Boolean roadObstruction;
	// - City Connects
	private Boolean cityConnects;
	// - City Shield
	private Boolean cityShield;
	
	// Neighbors, max 4
	private Tile northNeighbor;
	private Tile eastNeighbor;
	private Tile southNeighbor;
	private Tile westNeighbor;
	
	
	/**
	 * Construct a new tile with features
	 *
	 * @param north
	 * @param east
	 * @param south
	 * @param west
	 */
	public Tile(
			Integer north, 
			Integer east, 
			Integer south, 
			Integer west,
			Image image,
			Boolean roadObstruction,
			Boolean cityConnects,
			Boolean cityShield
			) {
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
	}
	
	public Integer getNorthFeature() {
		return this.north;
	}
	public Integer getEastFeature() {
		return this.east;
	}
	public Integer getSouthFeature() {
		return this.south;
	}
	public Integer getWestFeature() {
		return this.west;
	}

	
	// connect to neighbors
	public void connectNorth(Tile northNeighbor) {
		this.northNeighbor = northNeighbor;
	}
    public void connectEast(Tile eastNeighbor) {
        this.eastNeighbor = eastNeighbor;
    }
    public void connectSouth(Tile southNeighbor) {
        this.southNeighbor = southNeighbor;
    }
    public void connectWest(Tile westNeighbor) {
        this.westNeighbor = westNeighbor;
    }

	

}
