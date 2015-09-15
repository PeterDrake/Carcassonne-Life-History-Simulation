package Model;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/* Carcassonne-Life-History-Simulation, 2015 */
public class TileTest {

	private Tile origin;
	protected static Image baseImage = new ImageIcon("img/startingtile.png").getImage();

	protected static Tile baseTile() {
		return new Tile(new Integer[]{TileFeatureOld.CITY, TileFeatureOld.ROAD, TileFeatureOld.GRASS, TileFeatureOld.ROAD},
				baseImage, false, false, false);
	}
	
	@Before
	public void setUp() throws Exception {
		origin = baseTile();
	}

	@Test
	public void testFeatures() throws Exception {
		assertEquals(
			origin.getEdge(Directions.NORTH),
			new ArrayList<TileFeature>() {{
				add(TileFeature.CITY);
				add(TileFeature.CITY);
				add(TileFeature.CITY);
			}}
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

}
