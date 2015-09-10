package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*Carcassonne-Life-History-Simulation, 2015

Created Sep 10, 2015 by Esteban Valle

Copyright © 2015  Esteban Valle. All rights reserved.

+1-775-351-4427
esteban@thevalledesign.com
http://facebook.com/SeniorShizzle
*/
public class TileTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testRotateClockwise() throws Exception {
        Tile tile = new Tile();


        assertEquals(0, (long)tile.getRotation());
        tile.rotateClockwise();
        assertEquals(90, (long)tile.getRotation());

    }

    @Test
    public void testRotateCounterclockwise() throws Exception {
        Tile tile = new Tile();

        assertEquals(0, (long)tile.getRotation());
        tile.rotateCounterclockwise();
        assertEquals(-90, (long) tile.getRotation());
    }

    @Test
    public void testNeighbor() throws Exception {
        Tile centerTile = new Tile();
        Tile northTile = new Tile();

        centerTile.setNorth(northTile);
        assertEquals(northTile, centerTile.getNorth());
        assertEquals(centerTile, northTile.getSouth());
    }

}