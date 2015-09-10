package Model;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

public class TileTest {

	private Tile origin;

	@Before
	public void setUp() throws Exception {
		origin = new Tile(TileFeature.city, TileFeature.road, TileFeature.grass, TileFeature.road,
				new ImageIcon("src/img/startingtile.png").getImage(), false, false, false);
	}

	@Test
	public void test() {
		assertEquals(origin.getNorthFeature(), TileFeature.city);
	}

}
