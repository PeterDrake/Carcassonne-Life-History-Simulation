package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
	Player testPlayer=new Player("Anonymous", 1);
	assertEquals(testPlayer.getScore(), 0);
	assertEquals(testPlayer.getFollowers(), 7);
	assertTrue(testPlayer.getName().equals("Anonymous"));
	assertEquals(testPlayer.getID(), 1);
	}

}
