package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	private Player testPlayer;
	
	@Before
	public void setUp() throws Exception {
		this.testPlayer = new Player("Anonymous");
	}

	@Test
	public void testScore() {
		assertEquals(testPlayer.getScore(), 0);
		testPlayer.addScore(5);
		assertEquals(testPlayer.getScore(), 5);
	}
	
	@Test
	public void testName() {
		assertEquals(testPlayer.getName(), "Anonymous");
		testPlayer.changeName("Anon");
		assertEquals(testPlayer.getName(), "Anon");
	}

	@Test
	public void testFollower() {
		assertNotNull(testPlayer.availableFollower());
	}
	
}
