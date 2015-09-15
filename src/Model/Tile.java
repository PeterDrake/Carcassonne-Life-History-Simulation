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
import java.awt.List;
import java.util.ArrayList;

/**
 * Represents an individual game Tile
 *
 */
public class Tile {

	/** Private members to store tile features */
	/** Edges */
	private Integer[] edgeFeatures;
	/** Rotation in counts of 90 degrees */
	private Integer rotation;
	/** Image, 256x256 PNG */
	private Image image;

	// //// Neighbors /////////

	/** The north neighbor of the tile */
	private Tile north;

	/** The south neighbor of the tile */
	private Tile south;

	/** The east neighbor of the tile */
	private Tile east;

	/** The west neighbor of the tile */
	private Tile west;

	// //// END NEIGHBORS //////

	/** Features: */
	/** List of connected road edges */
	private ArrayList<ArrayList<Direction>> roads;
	/** List of connected city edges */
	private ArrayList<ArrayList<Direction>> cities;
	/** List of connected farm edges */
	private ArrayList<ArrayList<Direction>> farms;
	/** Whether Tile has a cloister */
	private boolean cloister;

	/** - Road End */
	private Boolean roadObstruction;
	/** - City Connects */
	private Boolean cityConnects;
	/** - City Shield */
	private Boolean cityShield;

	/**
	 * Create a new tile
	 * 
	 * @param edgeFeatures
	 *            list of tile Features
	 * @param image
	 *            graphic representation of the tile
	 * @param roadObstruction
	 *            whether the road on the tile (if any) "ends"
	 * @param cityConnects
	 *            whether the city on the tile (if any) connects across edges
	 * @param cityShield
	 *            whether the city on the tile (if any) has a Shield
	 */
	public Tile(Integer[] edgeFeatures, Image image, Boolean roadObstruction,
			Boolean cityConnects, Boolean cityShield) {
		this.edgeFeatures = new Integer[4];
		System.arraycopy(edgeFeatures, 0, this.edgeFeatures, 0,
				edgeFeatures.length);
		;
		this.image = image;
		this.roadObstruction = roadObstruction;
		this.cityConnects = cityConnects;
		this.cityShield = cityShield;
		this.rotation = TileFeatureOld.NORTH;
	}

	public Tile(ArrayList<ArrayList<Direction>> roads,
			ArrayList<ArrayList<Direction>> cities,
			ArrayList<ArrayList<Direction>> farms, Image image,
			boolean cloister, boolean cityShield) {
		this.roads = roads;
		this.cities = cities;
		this.farms = farms;
		this.image = image;
		this.cloister = cloister;
		this.cityShield = cityShield;
		this.rotation = 0;
	}

	/**
	 * Rotates the tile in the clockwise (right) direction.
	 */
	public void rotateClockwise() {
		if (this.rotation == 3) {
			this.rotation = 0;
		} else {
			this.rotation += 1;
		}
	}

	/**
	 * Rotates the tile in the counterclockwise (left) direction.
	 */
	public void rotateCounterclockwise() {
		if (this.rotation == 0) {
			this.rotation = 3;
		} else {
			this.rotation -= 1;
		}
	}

	/**
	 * Gets the Tile's north neighbor
	 * 
	 * @return the Tile's north neighbor
	 */
	public Tile getNorth() {
		return north;
	}

	public void setNorth(Tile north) {
		this.north = north;
	}

	/**
	 * Gets the Tile's south neighbor
	 * 
	 * @return the Tile's south neighbor
	 */
	public Tile getSouth() {
		return south;
	}

	public void setSouth(Tile south) {
		this.south = south;
	}

	/**
	 * Gets the Tile's east neighbor
	 * 
	 * @return the Tile's east neighbor
	 */
	public Tile getEast() {
		return east;
	}

	public void setEast(Tile east) {
		this.east = east;
	}

	/**
	 * Gets the Tile's west neighbor
	 * 
	 * @return the Tile's west neighbor
	 */
	public Tile getWest() {
		return west;
	}

	public void setWest(Tile west) {
		this.west = west;
	}

	/**
	 * Get edge features.
	 * 
	 * @return
	 */
	public Integer getNorthFeature() {
		return this.edgeFeatures[TileFeatureOld.NORTH + this.rotation];
	}

	public Integer getEastFeature() {
		return this.edgeFeatures[TileFeatureOld.EAST + this.rotation];
	}

	public Integer getSouthFeature() {
		return this.edgeFeatures[TileFeatureOld.SOUTH + this.rotation];
	}

	public Integer getWestFeature() {
		return this.edgeFeatures[TileFeatureOld.WEST + this.rotation];
	}

	/**
	 * 
	 * @return this Tile's image representation
	 */
	public Image getImage() {
		return this.image;
	}

	/**
	 * Returns the rotation in degrees.
	 * 
	 * @return the rotation, Integer, in degrees
	 */
	public Integer getRotation() {
		return rotation;
	}

	/**
	 * Translates an absolute cardinal direction into a local relative direction
	 * for the Tile's current rotation.
	 * 
	 * @param originalDirection
	 * @return
	 */
	private Direction translateDirection(Direction originalDirection) {
		Direction translatedDirection = originalDirection;
		for (int i = 0; i < this.rotation; i++) {
			switch (translatedDirection) {
			case NORTH:
				translatedDirection = Direction.WEST;
				break;
			case EAST:
				translatedDirection = Direction.NORTH;
				break;
			case SOUTH:
				translatedDirection = Direction.EAST;
				break;
			case WEST:
				translatedDirection = Direction.SOUTH;
				break;
			default:
				// wat
				translatedDirection = Direction.NORTH;
				break;
			}
		}
		return translatedDirection;
	}

	/**
	 * 
	 * @param edge
	 *            cardinal Direction of edge to return
	 * @return list of features along edge
	 */
	public ArrayList<TileFeature> getEdge(Direction absoluteEdge) {
		Direction localEdge = this.translateDirection(absoluteEdge);

		// TODO Auto-generated method stub
		return new ArrayList<TileFeature>() {
			{
				add(TileFeature.CITY);
				add(TileFeature.CITY);
				add(TileFeature.CITY);
			}
		};
	}

}
