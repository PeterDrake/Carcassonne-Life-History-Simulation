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


public class Tile {

	// Private members to store tile features
	// Edges
	private Integer northFeature;
	private Integer eastFeature;
	private Integer southFeature;
	private Integer westFeature;
	/**Rotation in degrees*/
	private Integer rotation;
	// Image, 256x256 PNG
	private Image image;
	
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

	// Features:
	// - Road End
	private Boolean roadObstruction;
	// - City Connects
	private Boolean cityConnects;
	// - City Shield
	private Boolean cityShield;

	
	public Tile(
			Integer northFeature, 
			Integer eastFeature, 
			Integer southFeature, 
			Integer westFeature,
			Image image,
			Boolean roadObstruction,
			Boolean cityConnects,
			Boolean cityShield
			) {
		this.northFeature = northFeature;
		this.eastFeature = eastFeature;
		this.southFeature = southFeature;
		this.westFeature = westFeature;
		this.image = image;
		this.roadObstruction = roadObstruction;
		this.cityConnects = cityConnects;
		this.cityShield = cityShield;
		this.rotation = 0;
	}
	
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
	 * Get edge features.
	 * @return
	 */
	public Integer getNorthFeature() {
		return this.northFeature;
	}
	public Integer getEastFeature() {
		return this.eastFeature;
	}
	public Integer getSouthFeature() {
		return this.southFeature;
	}
	public Integer getWestFeature() {
		return this.westFeature;
	}

	public Image getImage() {
		return this.image;
	}
	

	/**
	 * Returns the rotation in degrees.
	 * @return the rotation, Integer, in degrees
	 */
	public Integer getRotation() {
		return rotation;
	}
}
