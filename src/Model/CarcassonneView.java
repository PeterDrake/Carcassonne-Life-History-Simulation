package Model;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*;


public class CarcassonneView extends JPanel implements MouseListener, MouseMotionListener{

	public CarcassonneModel game;

	/**
	 * a HashMap of Tile and Point objects used for tracking location and mouseEvents
	 */
	public HashMap<Tile, Point> gameBoard = new HashMap<Tile, Point>();


    /**
     * Instantiates a CarcassonneView object, creates a new Deck, and sets up the principle view window.
     */
	public CarcassonneView() {
        addMouseListener(this); // adds a mouseListener to the JPanel

        this.game = new CarcassonneModel();
        this.gameBoard = new HashMap<Tile, Point>();
        this.gameBoard.put(
        	this.game.startingTile,
			new Point(
				(Carcassonne.WIDTH/2) - (Carcassonne.TILE_WIDTH_NOMINAL/2),
				(Carcassonne.HEIGHT/2) - (Carcassonne.TILE_WIDTH_NOMINAL/2)
			)
        );

		setBackground(java.awt.Color.BLACK);
        setSize(Carcassonne.WIDTH, Carcassonne.HEIGHT - 200);
        setVisible(true);
        //setUndecorated(true); // Get rid of that pesky top bar

//        setLayout(null);

	}

    /**
     * The main draw method for the CarcassonneView. This is called automatically by the runloop in Carcassonne.java
     * PLEASE always paint to g2, which is a casted graphics2D object wrapped around the original g.
     * @param g the Graphics component. Called automatically by Super
     */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// draw the game board tiles
		for (Map.Entry<Tile, Point> tileSet : this.gameBoard.entrySet()) {
			Tile tile = tileSet.getKey();
			Point position = tileSet.getValue();

			// draw the tile
			g2.drawImage(tile.getImage(), position.x, position.y, TILE_WIDTH_NOMINAL, TILE_WIDTH_NOMINAL, null);
		}
	}

    public Tile getTileAtPoint(Point point){
        Iterator<Map.Entry<Tile, Point>> it = this.gameBoard.entrySet().iterator();
        while (it.hasNext()){

        }

        return null;
    }

    private boolean pointInTileRect(Point testPoint, Point rectCorner){
        int dx = rectCorner.x + (int)(TILE_WIDTH_NOMINAL * scale);
        int dy = rectCorner.y + (int)(TILE_WIDTH_NOMINAL * scale);

        if (testPoint.x >= rectCorner.x && testPoint.x <= dx){
            if (testPoint.y >= rectCorner.y && testPoint.y <= dy) {
                return true; // The point is indeed inside the tested rectangle
            }
        }

        return false;
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

        System.out.println("A Mouse clicked at " + mouseEvent.getX() + ", " + mouseEvent.getY());
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
