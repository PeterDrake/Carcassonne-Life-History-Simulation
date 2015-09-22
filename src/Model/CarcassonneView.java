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

    /**
     * Instantiates a CarcassonneView object, creates a new Deck, and sets up the principle view window.
     */
	public CarcassonneView() {
        addMouseListener(this); // adds a mouseListener to the JPanel

		this.deck = new Deck();
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

		setBackground(java.awt.Color.BLACK);

        setSize(Carcassonne.WIDTH, Carcassonne.HEIGHT-200);

        setVisible(true);
        //setUndecorated(true); // Get rid of that pesky top bar
//        setLayout(null);
		// TODO: Set up players?
        
	}

    /**
     * The main draw method for the CarcassonneView. This is called automatically by the runloop in Carcassonne.java
     * @param g the Graphics component. Called automatically by Super
     */
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
