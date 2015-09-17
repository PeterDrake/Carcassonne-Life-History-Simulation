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
import java.util.HashMap;

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
	private ArrayList<ArrayList<FeaturePosition>> roads;
	/** List of connected city edges */
	private ArrayList<ArrayList<FeaturePosition>> cities;
	/** List of connected farm edges */
	private ArrayList<ArrayList<FeaturePosition>> farms;
		
	// for the future
	//	private HashMap<
	//	TileFeature, ArrayList<
	//		ArrayList<
	//			HashMap<Direction, EdgePosition>
	//		>
	//	>
	//> features;

	/** Whether Tile has a cloister */
	private boolean cloister;
	
	/** - Road End */
	private Boolean roadObstruction;
	/** - City Connects */
	private Boolean cityConnects;
	/** - City Shield */
	private Boolean cityShield;


	/**
	 * Create a new Tile.
	 * 
	 * @param roads
	 * 		List of lists of EdgeFeatures which identify connected roads
	 * @param cities
	 * 		List of lists of EdgeFeatures which identify connected cities
	 * @param farms
	 * 		List of lists of EdgeFeatures which identify connected farms
	 * @param image
	 * 		Image for the tile, 256x256 PNG plz
	 * @param cloister
	 * 		Whether the tile has a Cloister
	 * @param cityShield
	 * 		Whether the tile's city (if it has one) has a shield.
	 */
	public Tile(
		ArrayList<ArrayList<FeaturePosition>> roads,
		ArrayList<ArrayList<FeaturePosition>> cities,
		ArrayList<ArrayList<FeaturePosition>> farms,
		Image image,
		boolean cloister,
		boolean cityShield
	) {
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
	public HashMap<EdgePosition, TileFeature> getEdge(Direction absoluteEdge) {
		Direction localEdge = this.translateDirection(absoluteEdge);

		HashMap<EdgePosition, TileFeature> edgeFeatures = new HashMap<EdgePosition, TileFeature>();
		
		// for each kind of edge feature
		//	iterate through the feature maps
		//	if the feature is on the edge we're checking
		//		add the feature to the edge return
		
		for (ArrayList<FeaturePosition> cityGroup : this.cities) {
			for (FeaturePosition cityPosition : cityGroup) {
				if (cityPosition.direction == localEdge) {
					edgeFeatures.put(cityPosition.position, TileFeature.CITY);
				}
			}
		}
		for (ArrayList<FeaturePosition> roadGroup : this.roads) {
			for (FeaturePosition roadPosition : roadGroup) {
				if (roadPosition.direction == localEdge) {
					edgeFeatures.put(roadPosition.position, TileFeature.ROAD);
				}
			}
		}
		for (ArrayList<FeaturePosition> farmGroup : this.farms) {
			for (FeaturePosition farmPosition : farmGroup) {
				if (farmPosition.direction == localEdge) {
					edgeFeatures.put(farmPosition.position, TileFeature.GRASS);					
				}
			}
		}
				
		
		// Note: edges have three features
		
		return edgeFeatures;
	}

}
