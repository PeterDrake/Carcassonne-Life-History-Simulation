package Model;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public class CarcassonneModel extends JPanel {

	private Deck deck;
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
		setBackground(java.awt.Color.BLACK);
        setSize(Carcassonne.WIDTH, Carcassonne.HEIGHT);
        setVisible(true);
        //setUndecorated(true); // Get rid of that pesky top bar
        setLayout(null);
		// TODO: Set up players?
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Image image = this.startingTile.getImage();
		
		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);

		// draw the image in the upper-left corner

		g.drawImage(image, 0, 0, null);
		// tile the image across the component
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
