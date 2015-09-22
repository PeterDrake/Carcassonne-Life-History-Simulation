package Model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/* Carcassonne-Life-History-Simulation, 2015 */
public class TileTest {

	private Tile origin;
	protected static Image baseImage = new ImageIcon("img/startingtile.png").getImage();

	protected static Tile baseTile() {
		return new Tile(
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
			baseImage,
			false,
			false);
	}
	
	@Before
	public void setUp() throws Exception {
		origin = baseTile();
	}

	@Test
	public void testFeatures() throws Exception {
		assertEquals(
			new HashMap<EdgePosition, TileFeature>() {{
				put(EdgePosition.LEFT, TileFeature.CITY);
				put(EdgePosition.CENTER, TileFeature.CITY);
				put(EdgePosition.RIGHT, TileFeature.CITY);
			}},
			origin.getEdge(Direction.NORTH)
		);
	}
	
	@Test
	public void testRotatedFeatures() throws Exception {
		origin.rotateClockwise();
		assertEquals(
				new HashMap<EdgePosition, TileFeature>() {{
					put(EdgePosition.LEFT, TileFeature.CITY);
					put(EdgePosition.CENTER, TileFeature.CITY);
					put(EdgePosition.RIGHT, TileFeature.CITY);
				}},
				origin.getEdge(Direction.EAST)
			);
		origin.rotateCounterclockwise();
		origin.rotateCounterclockwise();
		assertEquals(
				new HashMap<EdgePosition, TileFeature>() {{
					put(EdgePosition.LEFT, TileFeature.CITY);
					put(EdgePosition.CENTER, TileFeature.CITY);
					put(EdgePosition.RIGHT, TileFeature.CITY);
				}},
				origin.getEdge(Direction.WEST)
			);
	}
	
	@Test
	public void testImage() throws Exception {
		assertEquals(origin.getImage(), baseImage);
	}


//    @Test
//    public void testRotateClockwise() throws Exception {
//        Tile tile = baseTile();
//
//        assertEquals(TileFeatureOld.NORTH, tile.getRotation());
//        tile.rotateClockwise();
//        assertEquals(TileFeatureOld.EAST, tile.getRotation());
//        tile.rotateClockwise();
//        tile.rotateClockwise();
//        tile.rotateClockwise();
//        assertEquals(TileFeatureOld.NORTH, tile.getRotation());
//
//    }

//    @Test
//    public void testRotateCounterclockwise() throws Exception {
//        Tile tile = baseTile();
//
//        assertEquals(TileFeatureOld.NORTH, tile.getRotation());
//        tile.rotateCounterclockwise();
//        assertEquals(TileFeatureOld.WEST, tile.getRotation());
//    }
    
//    @Test
//    public void testGetFeatureRotated() throws Exception {
//		assertEquals(origin.getNorthFeature(), TileFeatureOld.CITY);
//		origin.rotateClockwise();
//		assertEquals(origin.getNorthFeature(), TileFeatureOld.ROAD);
//		origin.rotateClockwise();
//		assertEquals(origin.getNorthFeature(), TileFeatureOld.GRASS);
//		origin.rotateClockwise();
//		assertEquals(origin.getNorthFeature(), TileFeatureOld.ROAD);
//    }
    
    @Test
    public void testNeighbor() throws Exception {
        Tile centerTile = baseTile();
        Tile northTile = baseTile();

        centerTile.setNorth(northTile);
        northTile.setSouth(centerTile);
        assertEquals(northTile, centerTile.getNorth());
        assertEquals(centerTile, northTile.getSouth());
    }


	private Tile tester;
	protected static Image baseImage = new ImageIcon("img/startingtile.png").getImage();
	protected static Tile testerTile() {
		return new Tile(
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
				baseImage,
				false,
				false);
	}


}
