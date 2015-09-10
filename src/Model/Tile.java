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
	private Integer[] edgeFeatures;
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
			Integer[] edgeFeatures, 
			Image image,
			Boolean roadObstruction,
			Boolean cityConnects,
			Boolean cityShield
			) {
		this.edgeFeatures = new Integer[4];
		System.arraycopy( edgeFeatures, 0, this.edgeFeatures, 0, edgeFeatures.length );;
		this.image = image;
		this.roadObstruction = roadObstruction;
		this.cityConnects = cityConnects;
		this.cityShield = cityShield;
		this.rotation = TileFeature.NORTH;
	}
	
	/**
	 * Rotates the tile in the clockwise (right) direction.
	 */
	public void rotateClockwise(){
		if (this.rotation == 3) {
			this.rotation = 0;
		} else {
			this.rotation += 1;
		}
	}

	/**
	 * Rotates the tile in the counterclockwise (left) direction.
	 */
	public void rotateCounterclockwise(){
		if (this.rotation == 0) {
			this.rotation = 3;
		} else {
			this.rotation -= 1;
		}
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
		return this.edgeFeatures[TileFeature.NORTH + this.rotation];
	}
	public Integer getEastFeature() {
		return this.edgeFeatures[TileFeature.EAST + this.rotation];
	}
	public Integer getSouthFeature() {
		return this.edgeFeatures[TileFeature.SOUTH + this.rotation];
	}
	public Integer getWestFeature() {
		return this.edgeFeatures[TileFeature.WEST + this.rotation];
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
