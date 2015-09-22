package Model;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;


public class CarcassonneView extends JPanel implements MouseListener, MouseMotionListener{

	public static final int TILE_SIZE_NOMINAL = 100;

	public CarcassonneModel game;

    /**
     * The starting tile, used for continuously redrawing the board.
     */
    private static Tile startingTile;

    /** The scaling of the images. Used for zooming */
    private double scale = 0.93;


    /**
     * Instantiates a CarcassonneView object, creates a new Deck, and sets up the principle view window.
     */
	public CarcassonneView() {
        addMouseListener(this); // adds a mouseListener to the JPanel


        this.game = new CarcassonneModel();

        startingTile = this.game.deck.pullTile();
        Tile tile = startingTile;

        int i = 0;
        while (true) {
            try {
                Tile atile = this.game.deck.pullTile();
                if (atile == null) break;

                tile.setWest(atile);
                tile = atile;

                i++;

            } catch (Exception exception) {
                System.out.println(exception.getLocalizedMessage());
                break;

            }
        }



		setBackground(java.awt.Color.BLACK);

        setSize(Carcassonne.WIDTH, Carcassonne.HEIGHT - 200);


        setVisible(true);
        //setUndecorated(true); // Get rid of that pesky top bar
        setLayout(null);
	}

    /**
     * The main draw method for the CarcassonneView. This is called automatically by the runloop in Carcassonne.java
     * PLEASE always paint to g2, which is a casted graphics2D object wrapped around the original g.
     * @param g the Graphics component. Called automatically by Super
     */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

        //SETUP
		int lastTileX = 0;
		int lastTileY = 0;
        Tile currentTile = startingTile;

        int imageSize = (int)(TILE_SIZE_NOMINAL * scale);

        int i = 0;

        while (true) {
            if (lastTileX + imageSize > Carcassonne.WIDTH) {
                lastTileX = 0;
                lastTileY += imageSize;
            }
            g2.drawImage(currentTile.getImage(), lastTileX, lastTileY, imageSize, imageSize, null);
            lastTileX += imageSize;
            //lastTileY += imageSize;

            if (currentTile.getImage() == null){
                System.out.printf("FUCK THIS TILE: "+currentTile);
            }

            currentTile = currentTile.getWest();

            i++;

            if (currentTile == null) break;
        }

        System.out.println("We've broken " + i);


        // draw the image in the upper-left corner

		//g2.drawImage(image, 0, 0, null);
		// tile the image across the component
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

	/**
	 * @return the number of player in Carc model
	 */
	public int getPlayers() {
		return game.players.size();
	}

}
