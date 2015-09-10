package Model;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/* Carcassonne-Life-History-Simulation, 2015 */
public class TileTest {

	private Tile origin;
	protected static Image baseImage = new ImageIcon("src/img/startingtile.png").getImage();

	protected static Tile baseTile() {
		return new Tile(new Integer[]{TileFeature.CITY, TileFeature.ROAD, TileFeature.GRASS, TileFeature.ROAD},
				baseImage, false, false, false);
	}
	
	@Before
	public void setUp() throws Exception {
		origin = baseTile();
	}

	@Test
	public void testFeatures() throws Exception {
		assertEquals(origin.getNorthFeature(), TileFeature.CITY);
		assertEquals(origin.getEastFeature(), TileFeature.ROAD);
		assertEquals(origin.getSouthFeature(), TileFeature.GRASS);
		assertEquals(origin.getWestFeature(), TileFeature.ROAD);
	}
	
	@Test
	public void testImage() throws Exception {
		assertEquals(origin.getImage(), baseImage);
	}


    @Test
    public void testRotateClockwise() throws Exception {
        Tile tile = baseTile();

        assertEquals(TileFeature.NORTH, tile.getRotation());
        tile.rotateClockwise();
        assertEquals(TileFeature.EAST, tile.getRotation());
        tile.rotateClockwise();
        tile.rotateClockwise();
        tile.rotateClockwise();
        assertEquals(TileFeature.NORTH, tile.getRotation());

    }

    @Test
    public void testRotateCounterclockwise() throws Exception {
        Tile tile = baseTile();

        assertEquals(TileFeature.NORTH, tile.getRotation());
        tile.rotateCounterclockwise();
        assertEquals(TileFeature.WEST, tile.getRotation());
    }
    
    @Test
    public void testGetFeatureRotated() throws Exception {
		assertEquals(origin.getNorthFeature(), TileFeature.CITY);
		origin.rotateClockwise();
		assertEquals(origin.getNorthFeature(), TileFeature.ROAD);
		origin.rotateClockwise();
		assertEquals(origin.getNorthFeature(), TileFeature.GRASS);
		origin.rotateClockwise();
		assertEquals(origin.getNorthFeature(), TileFeature.ROAD);
    }
    
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
