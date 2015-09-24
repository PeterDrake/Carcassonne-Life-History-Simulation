package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
	private Deck deck;
	
	@Before
	public void setUp() throws Exception {
		this.deck = new Deck();
	}

	@Test
	public void test() {
		assertEquals(this.deck.count(), 72);
	}
	
	@Test
	public void testPullTile() {
		assertNotNull(this.deck.pullTile());
		assertNotNull(this.deck.pullTile());
		assertNotNull(this.deck.pullTile());
		assertNotNull(this.deck.pullTile());
		assertNotNull(this.deck.pullTile());
		assertNotNull(this.deck.pullTile());
	}
}
