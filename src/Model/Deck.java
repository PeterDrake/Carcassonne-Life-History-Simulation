package Model;
//constructs the Carcassonne deck

import javax.swing.*;
import java.awt.*;
import java.util.*
;
public class Deck {
		private ArrayList<Tile> tiles=new ArrayList<Tile>();
		int i=0;
	    // Tiles may be placed on the table
	public void deckSetup(){
	Tile crossCity=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY}, null, false, true, false );
	//1 crossCity in game
tiles.add(crossCity);
	Tile crossCityShield=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY}, null, false, true, true );
	//2 crossCityShield in game
	for(i=0;i<2;i++){
		tiles.add(crossCityShield);
	}
	Tile city3Side=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY}, null, false, true, false );
	//3 city3Side in game
	for(i=0;i<3;i++){
		tiles.add(city3Side);
	}
	Tile city3SideShield=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY}, null, false, true, true );
	//1 city3SideShield in game
	tiles.add(city3SideShield);
	Tile city3SideRoad=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.ROAD, TileFeature.CITY}, null, true, true, false );
	//1 city3SideRoad in game
	tiles.add(city3SideRoad);
	Tile city3SideRoadShield=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.ROAD, TileFeature.CITY}, null, true, true, true );
	//2 city3SideRoadShield in game
	for(i=0;i<2;i++){
		tiles.add(city3SideRoadShield);
	}
	Tile cityAll=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.CITY, TileFeature.CITY}, null, false, true, true );
	//1 cityAll in game
	tiles.add(cityAll);
	Tile cityCornersUnconnected=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.GRASS, TileFeature.GRASS}, null, false, false, false );
	//2 cityCornersUnconnected in game
	for(i=0;i<2;i++){
		tiles.add(cityCornersUnconnected);
	}
	Tile cityCornersConnected=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.GRASS, TileFeature.GRASS}, null, false, true, false );
	//3 cityCornersConnected in game
	for(i=0;i<3;i++){
		tiles.add(cityCornersConnected);
	}
	Tile cityCornersConnectedShield=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.GRASS, TileFeature.GRASS}, null, false, true, true );
	//2 cityCornersConnectedShield in game
	for(i=0;i<2;i++){
		tiles.add(cityCornersConnectedShield);
	}
	Tile cityCornersConnectedRoad=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.ROAD, TileFeature.ROAD}, null, false, true, false );
	//3 cityCornersConnectedRoad in game
	for(i=0;i<3;i++){
		tiles.add(cityCornersConnectedRoad);
	}
	Tile cityCornersConnectedRoadShield=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.ROAD, TileFeature.ROAD}, null, false, true, true );
	//2 cityCornersConnectedRoadShield in game
	for(i=0;i<2;i++){
		tiles.add(cityCornersConnectedRoadShield);
	}
	Tile cityEdge=new Tile(new Integer[]{TileFeature.CITY, TileFeature.GRASS, TileFeature.GRASS, TileFeature.GRASS}, null, false, false, false );
	//5 cityEdge in game
	for(i=0;i<5;i++){
		tiles.add(cityEdge);
	}
	Tile cityEdgeRoad=new Tile(new Integer[]{TileFeature.CITY, TileFeature.ROAD, TileFeature.GRASS, TileFeature.ROAD}, null, false, false, false );
	//4 cityEdgeRoad in game
	for(i=0;i<4;i++){
		tiles.add(cityEdgeRoad);
	}
	Tile cityEdgeRoadFork=new Tile(new Integer[]{TileFeature.CITY, TileFeature.ROAD, TileFeature.ROAD, TileFeature.ROAD}, null, true, false, false );
	//3 cityEdgeRoadFork in game
	for(i=0;i<3;i++){
		tiles.add(cityEdgeRoadFork);
	}
	Tile cityEdgeRoadBendRight=new Tile(new Integer[]{TileFeature.CITY, TileFeature.ROAD, TileFeature.ROAD, TileFeature.GRASS}, null, false, false, false );
	//3 cityEdgeRoadBendRight in game
	for(i=0;i<3;i++){
		tiles.add(cityEdgeRoadBendRight);
	}
	Tile cityEdgeRoadBendLeft=new Tile(new Integer[]{TileFeature.CITY, TileFeature.GRASS, TileFeature.ROAD, TileFeature.ROAD}, null, false, false, false );
	//3 cityEdgeRoadBendLeft in game
	for(i=0;i<3;i++){
		tiles.add(cityEdgeRoadBendLeft);
	}
	Tile city2Edge=new Tile(new Integer[]{TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY, TileFeature.GRASS}, null, false, false, false );
	//3 city2Edge in game
	for(i=0;i<3;i++){
		tiles.add(city2Edge);
	}
	Tile roadStraight=new Tile(new Integer[]{TileFeature.ROAD, TileFeature.GRASS, TileFeature.ROAD, TileFeature.GRASS}, null, false, false, false );
	//8 roadStraight in game
	for(i=0;i<8;i++){
		tiles.add(roadStraight);
	}
	Tile roadBend=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.GRASS, TileFeature.ROAD, TileFeature.ROAD}, null, false, false, false );
	//9 roadBend in game
	for(i=0;i<9;i++){
		tiles.add(roadBend);
	}
	Tile roadFork=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.ROAD, TileFeature.ROAD, TileFeature.ROAD}, null, true, false, false );
	//4 roadFork in game
	for(i=0;i<4;i++){
		tiles.add(roadFork);
	}
	Tile roadAll=new Tile(new Integer[]{TileFeature.ROAD, TileFeature.ROAD, TileFeature.ROAD, TileFeature.ROAD}, null, true, false, false );
	//1 roadAll in game
	tiles.add(roadAll);
	Tile cloisterRoad=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.GRASS, TileFeature.ROAD, TileFeature.GRASS}, null, true, false, false );
	//2 cloisterRoad in game
	for(i=0;i<2;i++){
		tiles.add(cloisterRoad);
	}
	Tile cloister=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.GRASS, TileFeature.GRASS, TileFeature.GRASS}, null, false, false, false );
	//4 cloister in game
	for(i=0;i<4;i++){
		tiles.add(cloister);
	}
	
}

}
