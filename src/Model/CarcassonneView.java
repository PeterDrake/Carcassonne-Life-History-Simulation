package Model;

import sun.awt.image.BufImgVolatileSurfaceManager;

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

	public static final int TILE_WIDTH_NOMINAL = 100;

	public double scale = 1.0;


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
				(Carcassonne.WIDTH/2) - (TILE_WIDTH_NOMINAL/2),
				(Carcassonne.HEIGHT/2) - (TILE_WIDTH_NOMINAL/2)
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

	/**
	 * Gets and returns the Tile object which is under the Point point. Returns NULL if no tile is under the point.
	 * @param point the Point to check against all tiles on the game board
	 * @return the Tile object if point is contained within a Tile, otherwise null
	 */
    public Tile getTileAtPoint(Point point){
        Iterator<Map.Entry<Tile, Point>> it = this.gameBoard.entrySet().iterator();
        while (it.hasNext()){
			Map.Entry<Tile, Point> testEntry = it.next();
			if (pointInTileRect(point, testEntry.getValue())){
				System.out.println("Clicked Tile " + testEntry.getKey());
				return testEntry.getKey();
			}
        }

        return null;
    }

	/**
	 * A class for grouping a Tile and a Direction, for tile placement
	 * @param <Tile> the Tile object to place next to
	 * @param <Direction> the Direction for next tile placement
	 */
	public class TileDirectionPair<Tile, Direction> {
		public  Tile tile;
		public  Direction cardinalDirection;

		public TileDirectionPair() {

		}

		public TileDirectionPair(Tile tile, Direction cardinalDirection) {
			this.tile = tile;
			this.cardinalDirection = cardinalDirection;
		}

		public Tile getTile() {
			return tile;
		}

		public void setTile(Tile tile) {
			this.tile = tile;
		}

		public Direction getCardinalDirection() {
			return cardinalDirection;
		}

		public void setCardinalDirection(Direction cardinalDirection) {
			this.cardinalDirection = cardinalDirection;
		}
	}

	/**
	 * Gets and returns a TileDirectionPair object containing the closest Tile and the Direction to attach the new tile to
	 * @param point the test Point
	 * @return a TileDirectionPair object containing the closest Tile and Direction to attach new tile to
	 * @throws Exception if there is an issue
	 */
	public TileDirectionPair getNearestTilePlacementToPoint(Point point) throws Exception {

		TileDirectionPair retPair = new TileDirectionPair();

		double closestDelta = 0;

		Iterator<Map.Entry<Tile, Point>> it = this.gameBoard.entrySet().iterator();
		while (it.hasNext()) {

			// The Map Entry object for this iteration
			Map.Entry<Tile, Point> testEntry = it.next();

			if (pointInTileRect(point, testEntry.getValue())) {
				// We're actually inside a tile! Lets find out what corner they want it on
				int dx = point.x - testEntry.getValue().x;
				int dy = point.y - testEntry.getValue().y;

				// We've found the differences
				int minDiff = dx < dy ? dx : dy;

				if (minDiff > (TILE_WIDTH_NOMINAL * scale) / 2) {	// The point is closer to either the SOUTH or WEST sides
					retPair.setCardinalDirection(dx < dy ? Direction.WEST : Direction.SOUTH);
				}	else {
					retPair.setCardinalDirection(dx < dy ? Direction.EAST : Direction.NORTH);
				}
				retPair.setTile(testEntry.getKey());

				return retPair;
			}

			Direction dir = pointInColumn(point, testEntry.getValue());
			if (dir == Direction.NO_DIRECTION) continue;


			// Track the closest one
			double delta = Math.abs(point.distance(testEntry.getValue()));
			if (delta < closestDelta) {
				closestDelta = delta;
				retPair.setCardinalDirection(dir);
				retPair.setTile(testEntry.getKey());
			}

		}

		return retPair;

	}

	/**
	 * Returns the cardinal Direction if the point is paralell to one of the sides of the tile
	 * @param testPoint the test point
	 * @param rectCorner the upper-left hand corner of the test rectangle or tile to test against
	 * @return the Direction value, or NO_DIRECTION
	 */
	private Direction pointInColumn(Point testPoint, Point rectCorner) {
		// We'll assume we're not in the actual rectangle

		if (testPoint.x >= rectCorner.x && testPoint.x <= rectCorner.x + (TILE_WIDTH_NOMINAL * scale)){
			// We're in the vertical column. Lets determine if we're NORTH or SOUTH
			return testPoint.y < rectCorner.y ? Direction.NORTH : Direction.SOUTH;
		}

		if (testPoint.y >= rectCorner.y && testPoint.y <= rectCorner.y + (TILE_WIDTH_NOMINAL * scale)) {
			// We're in the horizontal column. Lets determine if we're EAST or WEST
			return testPoint.x < rectCorner.x ? Direction.WEST : Direction.EAST;
		}


		return Direction.NO_DIRECTION;
	}

	/**
	 * Tests whether the testPoint is in the tile rectangle defined by rectCorner and TILE_WIDTH_NOMINAL * size
	 * @param testPoint the Point for testing
	 * @param rectCorner the upper-left hand corner of the rectangle to hit test
	 * @return	TRUE if testPoint is within the rectangle. FALSE otherwise
	 */
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
		getTileAtPoint(mouseEvent.getPoint());
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
