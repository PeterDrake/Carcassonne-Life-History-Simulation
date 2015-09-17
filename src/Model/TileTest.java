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

	protected static Tile oldBaseTile() {
		return new Tile(new Integer[]{TileFeatureOld.CITY, TileFeatureOld.ROAD, TileFeatureOld.GRASS, TileFeatureOld.ROAD},
				baseImage, false, false, false);
	}
	
	protected static Tile baseTile() {
		return new Tile(
			new ArrayList<ArrayList<OldDirection>>() {{
				add(new ArrayList<OldDirection>() {{
					add(OldDirection.WEST);
					add(OldDirection.EAST);
				}});
			}},
			new ArrayList<ArrayList<OldDirection>>() {{
				add(new ArrayList<OldDirection>() {{
					add(OldDirection.NORTH_NORTH_EAST);
					add(OldDirection.NORTH);
					add(OldDirection.NORTH_NORTH_WEST);
				}});
			}},
			new ArrayList<ArrayList<OldDirection>>() {{
				add(new ArrayList<OldDirection>() {{
					add(OldDirection.EAST_NORTH_EAST);
					add(OldDirection.WEST_NORTH_WEST);
				}});
				add(new ArrayList<OldDirection>() {{
					add(OldDirection.EAST_SOUTH_EAST);
					add(OldDirection.SOUTH_SOUTH_EAST);
					add(OldDirection.SOUTH);
					add(OldDirection.SOUTH_SOUTH_WEST);
					add(OldDirection.WEST_SOUTH_WEST);
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
			origin.getEdge(OldDirection.NORTH),
			new HashMap<EdgePosition, TileFeature>() {{
				put(EdgePosition.LEFT, TileFeature.CITY);
				put(EdgePosition.CENTER, TileFeature.CITY);
				put(EdgePosition.RIGHT, TileFeature.CITY);
			}}
		);
	}
	
	@Test
	public void testRotatedFeatures() throws Exception {
		origin.rotateClockwise();
		assertEquals(
				origin.getEdge(OldDirection.EAST),
				new HashMap<EdgePosition, TileFeature>() {{
					put(EdgePosition.LEFT, TileFeature.CITY);
					put(EdgePosition.CENTER, TileFeature.CITY);
					put(EdgePosition.RIGHT, TileFeature.CITY);
				}}
			);
		origin.rotateCounterclockwise();
		origin.rotateCounterclockwise();
		assertEquals(
				origin.getEdge(OldDirection.WEST),
				new HashMap<EdgePosition, TileFeature>() {{
					put(EdgePosition.LEFT, TileFeature.CITY);
					put(EdgePosition.CENTER, TileFeature.CITY);
					put(EdgePosition.RIGHT, TileFeature.CITY);
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
