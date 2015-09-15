package Model;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;


public class CarcassonneView extends JPanel implements MouseListener, MouseMotionListener{

	private Deck deck;
	private Tile startingTile;

	public CarcassonneView() {
        addMouseListener(this); // adds a mouseListener to the JPanel

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

	}


	@Override
	public void mouseExited(MouseEvent mouseEvent) {
		System.out.println("A Mouse exited");
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {
		System.out.println("A Mouse released");
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		System.out.println("A Mouse pressed");
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		System.out.println("A Mouse clicked");
	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		System.out.println("A Mouse entered");
	}

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        // handle mouse drags
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        // handle mouse moves
    }
}
