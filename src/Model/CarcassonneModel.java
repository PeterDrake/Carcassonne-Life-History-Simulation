package Model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class CarcassonneModel {
	
	/** deck of unused tiles (random order) */
	public Deck deck;
	/** the game initial tile */
	public Tile startingTile;
	/** game players */
	public ArrayList<Player> players;

	/**
	 * New game of Carcassone
	 */
	public CarcassonneModel() {
		// default five players
		this(5);
	}
	public CarcassonneModel(int numPlayers) {
		// add players
		this.players = new ArrayList<Player>(numPlayers);
		for (int i = 0; i < numPlayers; i++) {
			this.players.add(new Player());
		}
		// init Deck
		this.deck = new Deck();
		// add starting tile
		this.startingTile = new Tile(
			// roads
			new ArrayList<ArrayList<FeaturePosition>>() {{
				add(new ArrayList<FeaturePosition>() {{
					add(new FeaturePosition(Direction.WEST, EdgePosition.CENTER));
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
					add(new FeaturePosition(Direction.WEST, EdgePosition.RIGHT));
					add(new FeaturePosition(Direction.EAST, EdgePosition.LEFT));
				}});
				add(new ArrayList<FeaturePosition>() {{
					add(new FeaturePosition(Direction.EAST, EdgePosition.RIGHT));
					add(new FeaturePosition(Direction.SOUTH, EdgePosition.LEFT));
					add(new FeaturePosition(Direction.SOUTH, EdgePosition.CENTER));
					add(new FeaturePosition(Direction.SOUTH, EdgePosition.RIGHT));
					add(new FeaturePosition(Direction.WEST, EdgePosition.LEFT));
				}});
			}},
			new ImageIcon("img/startingtile.png").getImage(),
			false,
			false
		);
		// TODO: What's left?
		
	}
	
	/**
	 * 
	 * @return whether the game is over (the Deck is empty)
	 */
	public Boolean isGameOver() {
		return this.deck.count() == 0;
	}
}
