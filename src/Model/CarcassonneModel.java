package Model;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CarcassonneModel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5890392028083477707L;

	private Deck<Tile> deck;
	private Tile startingTile;

	private int tileCounter = 0;

	public CarcassonneModel() {
		this.deck = new Deck();
		this.startingTile = new Tile(
			new Integer[] { TileFeature.CITY, TileFeature.ROAD, TileFeature.GRASS, TileFeature.ROAD },
			new ImageIcon("src/img/startingtile.png").getImage(),
			false,
			false,
			false
		);
		// TODO: Set up players?
	}

	public void addTile() {
		// TODO: random select tile from the deck
		// TODO: Keep track of which player is using tile

		tileCounter++;
	}

	/**
	 * Searches to detect if all tiles have been used
	 */
	public boolean isOver() {
		if (tileCounter == 72) {
			return true;
		} else {
			return false;
		}
	}
}