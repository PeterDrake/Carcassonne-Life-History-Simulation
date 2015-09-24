package Model;

import static org.junit.Assert.*;
import Model.TileTest;

import org.junit.Before;
import org.junit.Test;

public class FollowerTest {

	private Follower follower;
	private Tile tile;
	
	@Before
	public void setUp() throws Exception {
		this.follower = new Follower();
		this.tile = TileTest.baseTile();
	}

	@Test
	public void testPlaceOnTile() {
		assertEquals(null, follower.getTile());
		assertEquals(null, follower.getPosition());
		follower.placeOnTile(tile, TileFeatureOld.CITY);
		assertEquals(tile, follower.getTile());
		assertEquals(TileFeatureOld.CITY, follower.getPosition());
	}
	
	@Test
	public void testEighthMeeple(){
		
	}
	
	

}
