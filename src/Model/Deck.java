package Model;

//constructs the Carcassonne deck

import javax.swing.*;
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

		// 2 crossCityShield in game
        for (i = 0; i < 2; i++) {
            tiles.add(new Tile(
                    // roads
                    null,
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile22.png").getImage(),
                    false,
                    true));
        }

		// 1 crossCity in game
        tiles.add(new Tile(
                // roads
                null,
                // cities
                new ArrayList<ArrayList<FeaturePosition>>() {{
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                    }});
                }},
                // farms
                new ArrayList<ArrayList<FeaturePosition>>() {{
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                    }});
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                    }});
                }},
                new ImageIcon("img/TileImages/tile23.png").getImage(),
                false,
                false));


        // 3 city3Side in game
		for (i = 0; i < 3; i++) {
            tiles.add(new Tile(
                    // roads
                    null,
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile26.png").getImage(),
                    false,
                    false));
        }

		// 1 city3SideShield in game
        tiles.add(new Tile(
                // roads
                null,
                // cities
                new ArrayList<ArrayList<FeaturePosition>>() {{
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                    }});
                }},
                // farms
                new ArrayList<ArrayList<FeaturePosition>>() {{
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                    }});
                }},
                new ImageIcon("img/TileImages/tile10.png").getImage(),
                false,
                true));

		// 1 city3SideRoad in game
        tiles.add(new Tile(
                // roads
                new ArrayList<ArrayList<FeaturePosition>>(){{
                    add(new ArrayList<FeaturePosition>(){{
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                    }});
                }},
                // cities
                new ArrayList<ArrayList<FeaturePosition>>() {{
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                    }});
                }},
                // farms
                new ArrayList<ArrayList<FeaturePosition>>() {{
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                    }});
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                    }});
                }},
                new ImageIcon("img/TileImages/tile4.png").getImage(),
                false,
                false));


		// 2 city3SideRoadShield in game
        for (i = 0; i < 2; i++){
            tiles.add(new Tile(
                    // roads
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                        }});
                    }},
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                        }});
                        add(new ArrayList<FeaturePosition>(){{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile2.png").getImage(),
                    false,
                    true));

        }

		// 1 cityAll in game
        tiles.add(new Tile(
                // roads
                null,
                // cities
                new ArrayList<ArrayList<FeaturePosition>>() {{
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.EAST,  EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.EAST,  EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.EAST,  EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.WEST,  EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.WEST,  EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.WEST,  EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                    }});
                }},
                // farms
                null,
                new ImageIcon("img/TileImages/tile21.png").getImage(),
                false,
                true));


        // 2 cityCornersUnconnected in game
        for (i = 0; i < 2; i++){
            tiles.add(new Tile(
                    // roads
                    null,
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST,  EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST,  EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST,  EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile19.png").getImage(),
                    false,
                    false));
        }

		// 3 cityCornersConnected in game
		for (i = 0; i < 3; i++) {
            tiles.add(new Tile(
                    // roads
                    null,
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile14.png").getImage(),
                    false,
                    false));

		}

		// 2 cityCornersConnectedShield in game
		for (i = 0; i < 2; i++) {
            tiles.add(new Tile(
                    // roads
                    null,
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile17.png").getImage(),
                    false,
                    true));

		}

		// 3 cityCornersConnectedRoad in game
		for (i = 0; i < 3; i++) {
            tiles.add(new Tile(
                    // roads
                    new ArrayList<ArrayList<FeaturePosition>>(){{
                        add(new ArrayList<FeaturePosition>(){{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                        }});
                    }},
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile9.png").getImage(),
                    false,
                    false));

		}

		// 2 cityCornersConnectedRoadShield in game
		for (i = 0; i < 2; i++) {
            tiles.add(new Tile(
                    // roads
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                        }});
                    }},
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile24.png").getImage(),
                    false,
                    true));

		}

		// 5 cityEdge in game
		for (i = 0; i < 5; i++) {
            tiles.add(new Tile(
                    // roads
                    null,
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            }});

                    }},
                    new ImageIcon("img/TileImages/tile15.png").getImage(),
                    false,
                    false));

		}

		// 4 cityEdgeRoad in game
		for (i = 0; i < 4; i++) {
            tiles.add(new Tile(
                    // roads
                    new ArrayList<ArrayList<FeaturePosition>>(){{
                        add(new ArrayList<FeaturePosition>(){{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                        }});
                    }},
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                        }});
                        add(new ArrayList<FeaturePosition>(){{
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile16.png").getImage(),
                    false,
                    false));

		}

		// 3 cityEdgeRoadFork in game
		for (i = 0; i < 3; i++) {
            tiles.add(new Tile(
                    // roads
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                        }});
                    }},
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                        }});
                        add(new ArrayList<FeaturePosition>(){{
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile27.png").getImage(),
                    false,
                    false));

        }

		// 3 cityEdgeRoadBendRight in game
		for (i = 0; i < 3; i++) {
            tiles.add(new Tile(
                    // roads
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                        }});

                    }},
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                        }});

                    }},
                    new ImageIcon("img/TileImages/tile11.png").getImage(),
                    false,
                    false));

		}

		// 3 cityEdgeRoadBendLeft in game
		for (i = 0; i < 3; i++) {
            tiles.add(new Tile(
                    // roads
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                        }});

                    }},
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                        }});

                    }},
                    new ImageIcon("img/TileImages/tile8.png").getImage(),
                    false,
                    false));

		}

		// 3 city2Edge in game
		for (i = 0; i < 3; i++) {
            tiles.add(new Tile(
                    // roads
                    null,
                    // cities
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                        }});
                    }},
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile18.png").getImage(),
                    false,
                    false));

		}

		// 8 roadStraight in game
		for (i = 0; i < 8; i++) {
            tiles.add(new Tile(
                    // roads
                    new ArrayList<ArrayList<FeaturePosition>>(){{
                        add(new ArrayList<FeaturePosition>(){{
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                        }});
                    }},
                    // cities
                   null,
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                        }});
                    }},
                    new ImageIcon("img/TileImages/" + (Math.random() > 0.5 ? "tile6.png" : "tile25.png")).getImage(),
                    false,
                    false));
		}

		// 9 roadBend in game
		for (i = 0; i < 9; i++) {
            tiles.add(new Tile(
                    // roads
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                        }});
                    }},
                    // cities
                    null,
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                        }});
                    }},
                    new ImageIcon("img/TileImages/" + (Math.random() > 0.5 ? "tile13.png" : "tile20.png")).getImage(),
                    false,
                    false));

		}

		// 4 roadFork in game
		for (i = 0; i < 4; i++) {
            tiles.add(new Tile(
                    // roads
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                        }});
                    }},
                    // cities
                    null,
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                        }});
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                        }});
                    }},
                    new ImageIcon("img/TileImages/tile5.png").getImage(),
                    false,
                    false));

		}

		// 1 roadAll in game
        tiles.add(new Tile(
                // roads
                new ArrayList<ArrayList<FeaturePosition>>() {{
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                    }});
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                    }});
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));
                    }});
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                    }});
                }},
                // cities
                null,
                // farms
                new ArrayList<ArrayList<FeaturePosition>>() {{
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                    }});
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                    }});
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                        add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                    }});
                    add(new ArrayList<FeaturePosition>() {{
                        add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                        add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                    }});
                }},
                new ImageIcon("img/TileImages/tile7.png").getImage(),
                false,
                false));

		// 2 cloisterRoad in game
		for (i = 0; i < 2; i++) {
            tiles.add(new Tile(
                    // roads
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                        }});

                    }},
                    // cities
                    null,
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));

                        }});
                    }},
                    new ImageIcon("img/TileImages/tile3.png").getImage(),
                    true,
                    false));
		}

		// 4 cloister in game
		for (i = 0; i < 4; i++) {
            tiles.add(new Tile(
                    // roads
                    null,
                    // cities
                    null,
                    // farms
                    new ArrayList<ArrayList<FeaturePosition>>() {{
                        add(new ArrayList<FeaturePosition>() {{
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.NORTH, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
                            add(new FeaturePosition(Direction.EAST, EdgePosition.CENTER));

                        }});
                    }},
                    new ImageIcon("img/TileImages/tile1.png").getImage(),
                    true,
                    false));

		}

		// Aaaaand shuffle it up!
		Collections.shuffle(this.tiles);
        // TURN DOWN FOR WHAT???
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
        if (count() == 0) return null;
		return tiles.remove(0);
	}

}
