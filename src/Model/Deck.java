package Model;

//constructs the Carcassonne deck

import java.util.*;

/**
 * The Deck represents the pile of un-played game tiles. Self-populates with a full standard game's tiles.
 *
 */
public class Deck {
	private ArrayList<Tile> tiles = new ArrayList<Tile>();

	/**
	 * Create a new Deck (pile of unplayed tiles).
	 * Has no parameters, self-populates with a standard game's tile distribution.
	 * Note: this will not handle game expansion packs cleanly.
	 */
	public Deck() {
		int i = 0;

		// 1 crossCity in game
		tiles.add(new Tile(new Integer[] { TileFeature.GRASS, TileFeature.CITY,
				TileFeature.GRASS, TileFeature.CITY }, null, false, true, false));

		// 2 crossCityShield in game
		for (i = 0; i < 2; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.GRASS,
					TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY },
					null, false, true, true));
		}

		// 3 city3Side in game
		for (i = 0; i < 3; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY },
					null, false, true, false));
		}

		// 1 city3SideShield in game
		tiles.add(new Tile(new Integer[] { TileFeature.CITY, TileFeature.CITY,
				TileFeature.GRASS, TileFeature.CITY }, null, false, true, true));

		// 1 city3SideRoad in game
		tiles.add(new Tile(new Integer[] { TileFeature.CITY, TileFeature.CITY,
				TileFeature.ROAD, TileFeature.CITY }, null, true, true, false));

		// 2 city3SideRoadShield in game
		for (i = 0; i < 2; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.CITY, TileFeature.ROAD, TileFeature.CITY },
					null, true, true, true));
		}

		// 1 cityAll in game
		tiles.add(new Tile(new Integer[] { TileFeature.CITY, TileFeature.CITY,
				TileFeature.CITY, TileFeature.CITY }, null, false, true, true));

		// 2 cityCornersUnconnected in game
		for (i = 0; i < 2; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.CITY, TileFeature.GRASS, TileFeature.GRASS },
					null, false, false, false));
		}

		// 3 cityCornersConnected in game
		for (i = 0; i < 3; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.CITY, TileFeature.GRASS, TileFeature.GRASS },
					null, false, true, false));
		}

		// 2 cityCornersConnectedShield in game
		for (i = 0; i < 2; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.CITY, TileFeature.GRASS, TileFeature.GRASS },
					null, false, true, true));
		}

		// 3 cityCornersConnectedRoad in game
		for (i = 0; i < 3; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.CITY, TileFeature.ROAD, TileFeature.ROAD },
					null, false, true, false));
		}

		// 2 cityCornersConnectedRoadShield in game
		for (i = 0; i < 2; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.CITY, TileFeature.ROAD, TileFeature.ROAD },
					null, false, true, true));
		}

		// 5 cityEdge in game
		for (i = 0; i < 5; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.GRASS, TileFeature.GRASS, TileFeature.GRASS },
					null, false, false, false));
		}

		// 4 cityEdgeRoad in game
		for (i = 0; i < 4; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.ROAD, TileFeature.GRASS, TileFeature.ROAD },
					null, false, false, false));
		}

		// 3 cityEdgeRoadFork in game
		for (i = 0; i < 3; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.ROAD, TileFeature.ROAD, TileFeature.ROAD },
					null, true, false, false));
		}

		// 3 cityEdgeRoadBendRight in game
		for (i = 0; i < 3; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.ROAD, TileFeature.ROAD, TileFeature.GRASS },
					null, false, false, false));
		}

		// 3 cityEdgeRoadBendLeft in game
		for (i = 0; i < 3; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.GRASS, TileFeature.ROAD, TileFeature.ROAD },
					null, false, false, false));
		}

		// 3 city2Edge in game
		for (i = 0; i < 3; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.CITY,
					TileFeature.GRASS, TileFeature.CITY, TileFeature.GRASS },
					null, false, false, false));
		}

		// 8 roadStraight in game
		for (i = 0; i < 8; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.ROAD,
					TileFeature.GRASS, TileFeature.ROAD, TileFeature.GRASS },
					null, false, false, false));
		}

		// 9 roadBend in game
		for (i = 0; i < 9; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.GRASS,
					TileFeature.GRASS, TileFeature.ROAD, TileFeature.ROAD },
					null, false, false, false));
		}

		// 4 roadFork in game
		for (i = 0; i < 4; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.GRASS,
					TileFeature.ROAD, TileFeature.ROAD, TileFeature.ROAD },
					null, true, false, false));
		}

		// 1 roadAll in game
		tiles.add(new Tile(new Integer[] { TileFeature.ROAD, TileFeature.ROAD,
				TileFeature.ROAD, TileFeature.ROAD }, null, true, false, false));

		// 2 cloisterRoad in game
		for (i = 0; i < 2; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.GRASS,
					TileFeature.GRASS, TileFeature.ROAD, TileFeature.GRASS },
					null, true, false, false));
		}

		// 4 cloister in game
		for (i = 0; i < 4; i++) {
			tiles.add(new Tile(new Integer[] { TileFeature.GRASS,
					TileFeature.GRASS, TileFeature.GRASS, TileFeature.GRASS },
					null, false, false, false));
		}
		
		// Aaaaand shuffle it up!
		Collections.shuffle(this.tiles);
	}

	/**
	 * 
	 * @return Returns number of tiles remaining in the Deck
	 */
	public int count() {
		return tiles.size();
	}

	/**
	 * Removes the tile at the bottom of the pile.
	 * @return a random Tile
	 */
	public Tile pullTile() {
		return tiles.remove(0);
	}

}
