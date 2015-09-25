package Model;

import sun.awt.image.BufImgVolatileSurfaceManager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*;


public class CarcassonneView extends JPanel implements MouseListener, MouseMotionListener{

	public CarcassonneModel game;

    /** The point of the first clickdown, for drag tracking */
    private Point clickPoint;

    private Tile queuedTile;
    private Point queuedTilePoint = new Point(-1000, -1000);
    private boolean shouldDisplayQueuedTile = false;


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
        addMouseMotionListener(this);

        this.game = new CarcassonneModel();
        this.gameBoard = new HashMap<Tile, Point>();
        this.gameBoard.put(
        	this.game.startingTile,
			new Point(
				(Carcassonne.WIDTH/2) - (TILE_WIDTH_NOMINAL/2),
				(Carcassonne.HEIGHT/2) - (TILE_WIDTH_NOMINAL/2)
			)
        );

		setBackground(new java.awt.Color(200, 200, 200));
        setSize(Carcassonne.WIDTH, Carcassonne.HEIGHT - 200);
        addButtons();
        setVisible(true);
        //setUndecorated(true); // Get rid of that pesky top bar

//        setLayout(null);

        queuedTile = this.game.deck.pullTile();

        Timer t = new Timer(900, ae -> {    // This is a lamba closure, don't be conufesd here!!
            shouldDisplayQueuedTile = true;
        });
        t.setRepeats(false);
        t.start();

	}

    /**
     * The main draw method for the CarcassonneView. This is called automatically by the runloop in Carcassonne.java
     * PLEASE always paint to g2, which is a casted graphics2D object wrapped around the original g.
     * @param g the Graphics component. Called automatically by Super
     */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

        if (shouldDisplayQueuedTile && queuedTile != null){
            g2.drawImage(queuedTile.getImage(), queuedTilePoint.x, queuedTilePoint.y, (int) (TILE_WIDTH_NOMINAL * scale), (int) (TILE_WIDTH_NOMINAL * scale), null);
        }

		// draw the game board tiles
		for (Map.Entry<Tile, Point> tileSet : this.gameBoard.entrySet()) {
			Tile tile = tileSet.getKey();
			Point position = tileSet.getValue();

			// draw the tile
			g2.drawImage(tile.getImage(), position.x, position.y, (int)(TILE_WIDTH_NOMINAL * scale), (int)(TILE_WIDTH_NOMINAL * scale), null);
		}

		// game over?
		if (this.game.isGameOver()) {
			g2.setColor(java.awt.Color.MAGENTA);
			g2.setFont(new Font("Helvetica", 0, 72));
			g2.drawString("Game Over", 300, 200);
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
	 */
	public class TileDirectionPair {
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

		double closestDelta = 10000;

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
					retPair.setCardinalDirection(dx > dy ? Direction.WEST : Direction.SOUTH);
				}	else {
					retPair.setCardinalDirection(dx > dy ? Direction.EAST : Direction.NORTH);
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

	/**
	 * Returns the adjusted placement point for the new tile adjacent to the TileDirectionPair's Tile and cardinalDirection
	 * @param pair the TileDirectionPair that contains the tile and direction to place a new tile next to
	 * @return the Point where the new tile should be placed
	 * @throws Exception if something has gone horribly, horribly wrong
	 */
	private Point getPlacementPointForTileDirectionPair(TileDirectionPair pair) throws Exception {

		Point tilePoint = this.gameBoard.get(pair.getTile());
		if (tilePoint == null) throw new Exception("Tile Not Found or Null Exception");

		Point point = tilePoint.getLocation(); // make a deep copy


		Direction dir = pair.getCardinalDirection();

		switch (dir) {
			case NORTH:
				point.translate(0, -1 * (int)(TILE_WIDTH_NOMINAL * scale));
				break;
			case SOUTH:
				point.translate(0, (int)(TILE_WIDTH_NOMINAL * scale));
				break;
			case WEST:
				point.translate(-1 * (int) (TILE_WIDTH_NOMINAL * scale), 0);
				break;
			case EAST:
				point.translate((int) (TILE_WIDTH_NOMINAL * scale), 0);
				break;
			case NO_DIRECTION:
				break;

			default:    // Something has gone wrong...
				throw new Exception("Why are you so bad at programming Exception.");

		}

		return point;
	}

    /**
     * Logically connects the tiles together with the correct cardinal relationships. Tile manages rotation automatically.
     *
     * @param originalTile          the Tile which is already placed on the board
     * @param placedTile            the Tile which is to be placed as a neighbor
     * @param directionFromOriginal the cardinal Direction *of the original Tile* to attach the neighbor to
     */
    private void connectTiles(Tile originalTile, Tile placedTile, Direction directionFromOriginal) {
        if (placedTile == null || originalTile == null) {
            System.out.println("Error connecting tiles " + originalTile + " and " + placedTile);
            return;
        }

        switch (directionFromOriginal) {
            case NORTH:
                originalTile.setNorth(placedTile);
                placedTile.setSouth(originalTile);
                break;
            case SOUTH:
                originalTile.setSouth(placedTile);
                placedTile.setNorth(originalTile);
                break;
            case WEST:
                originalTile.setWest(placedTile);
                placedTile.setEast(originalTile);
                break;
            case EAST:
                originalTile.setEast(placedTile);
                placedTile.setWest(originalTile);
                break;
            case NO_DIRECTION:
                break;

            default:    // Something's gone wrong...
                break;

        }

    }
    
    /**
     * Rotates the queued tile (tile currently in play), default CCW
     */
    private void rotateQueuedTile() {
    	if (queuedTile != null) {
    		queuedTile.rotateClockwise();
    	}
    }


    @Override
	public void mouseExited(MouseEvent mouseEvent) {
		//System.out.println("A Mouse exited");
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {
		//System.out.println("A Mouse released");
        Timer t = new Timer(650, ae -> {    // This is a lamba closure, don't be conufesd here!!
            shouldDisplayQueuedTile = true;
        });

        t.setRepeats(false);
        t.start();
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		System.out.println("A Mouse pressed");
        clickPoint = mouseEvent.getPoint();

    }

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		switch (mouseEvent.getButton()) {
		case MouseEvent.BUTTON1:
			// left click to place tile
	        System.out.println("Unplayed tiles remaining: " + this.game.deck.count());

	        shouldDisplayQueuedTile = false;

			//Tile placedTile = this.game.deck.pullTile();
			if (queuedTile != null) {
				TileDirectionPair nearestNeighbor = new TileDirectionPair();
				try {
					nearestNeighbor = getNearestTilePlacementToPoint(mouseEvent.getPoint());
				} catch (Exception e) {
					System.out.println(e);
				}

				//System.out.println(nearestNeighbor.getCardinalDirection() + ", " + nearestNeighbor.getTile());

				if (nearestNeighbor.getTile() == null) return; // Stupid way to check if nearestNeighbor is null, because it won't let me not initialize it

				if (nearestNeighbor.getTile() != null) {
					Point placementPoint = new Point(-1, -1);
					try {
						placementPoint = getPlacementPointForTileDirectionPair(nearestNeighbor);
					} catch (Exception e) {
						System.out.println(e);
					}

					//System.out.println(placementPoint);

					if (placementPoint.x == -1 && placementPoint.y == -1) return;


	                // Place the tile onto the game grid
					this.gameBoard.put(queuedTile, placementPoint);

	                // Connect the tiles together
	                connectTiles(nearestNeighbor.getTile(), queuedTile, nearestNeighbor.getCardinalDirection());

	                // We've done it, lets queue another
	                queuedTile = this.game.deck.pullTile();
				}
				repaint();
			}
			break;
		case MouseEvent.BUTTON3:
			// right click to rotate current tile
			rotateQueuedTile();
			repaint();
			break;
		default:
			// ignore other clicks
			break;
		}

	}


	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		//System.out.println("A Mouse entered");
	}

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        // handle mouse drags
        if (clickPoint == null) return;

        shouldDisplayQueuedTile = false;

        int deltaX = mouseEvent.getX() - clickPoint.x ;
        int deltaY = mouseEvent.getY() - clickPoint.y ;

        // change point of every tile
        for (Map.Entry<Tile, Point> tileSet : this.gameBoard.entrySet()) {
            Point position = tileSet.getValue();
            position.x += deltaX;
            position.y += deltaY;

        }
        clickPoint = mouseEvent.getPoint();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        // handle mouse moves
        queuedTilePoint = mouseEvent.getPoint();

        int translation = -(int)((TILE_WIDTH_NOMINAL * scale) / 2);

        queuedTilePoint.translate(translation, translation);
        repaint();
    }

    /**
     * Adds the buttons for zooming to the display, and sets up their actionlisteners
     */
    private void addButtons(){
        JButton plusButton = new JButton("-");
        plusButton.setLocation(20, 20);
        plusButton.setPreferredSize(new Dimension(30, 30));

        plusButton.addActionListener(ae -> {    // Please don't be confused by lambda closures
                    scale -= 0.05;
                    // change point of every tile
                    for (Map.Entry<Tile, Point> tileSet : this.gameBoard.entrySet()) {
                        Point position = tileSet.getValue();
                        int deltax = (int)(position.x * 0.05);
                        int deltay = (int)(position.y * 0.05);

                        position.x *= 0.95;
                        position.y *= 0.95;

                        //position.x += deltax;
                        //position.y += deltay;

                    }
                    repaint();
                }
        );

        JButton minusButton = new JButton("+");
        minusButton.setLocation(20, 30);
        minusButton.setPreferredSize(new Dimension(30, 30));

        minusButton.addActionListener(ae -> {
                    scale += 0.05;

                    // change point of every tile
                    for (Map.Entry<Tile, Point> tileSet : this.gameBoard.entrySet()) {
                        Point position = tileSet.getValue();

                        int deltax = (int) (position.x * 0.05);
                        int deltay = (int) (position.y * 0.05);

                        position.x *= 1.05;
                        position.y *= 1.05;

                        //position.x -= deltax;
                        //position.y -= deltay;


                    }
                    repaint();
                }
        );

        add(plusButton);
        add(minusButton);

    }

	/**
	 * @return the number of player in Carc model
	 */
	public int getPlayers() {
		return game.players.size();
	}

}
