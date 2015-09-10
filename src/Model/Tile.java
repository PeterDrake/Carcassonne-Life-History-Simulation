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

	////// Neighbors /////////

	/** The north neighbor of the tile */
	private Tile north;

	/** The south neighbor of the tile */
	private Tile south;

	/** The east neighbor of the tile */
	private Tile east;

	/** The west neighbor of the tile */
	private Tile west;

	////// END NEIGHBORS //////


	/**Rotation in degrees*/
	private Integer rotation;

	// Features:
	// - Road End
	private Boolean roadObstruction;
	// - City Connects
	private Boolean cityConnects;
	// - City Shield
	private Boolean cityShield;

	/**
	 * Rotates the tile in the clockwise (right) direction.
	 */
	public void rotateClockwise(){
		this.rotation += 90;
	}

	/**
	 * Rotates the tile in the counterclockwise (left) direction.
	 */
	public void rotateCounterclockwise(){
		this.rotation -= 90;
	}


	public Tile getNorth() {
		return north;
	}

	public void setNorth(Tile north) {
		this.north = north;
	}

	public Tile getSouth() {
		return south;
	}

	public void setSouth(Tile south) {
		this.south = south;
	}

	public Tile getEast() {
		return east;
	}

	public void setEast(Tile east) {
		this.east = east;
	}

	public Tile getWest() {
		return west;
	}

	public void setWest(Tile west) {
		this.west = west;
	}


	/**
	 * Returns the rotation in degrees.
	 * @return the rotation, Integer, in degrees
	 */
	public Integer getRotation() {
		return rotation;
	}
}
