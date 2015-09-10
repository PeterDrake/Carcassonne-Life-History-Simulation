package Model;


public class Carcassonne {
	private Tile[] deck=new Tile[1000];
    // Tiles may be placed on the table
public void deckSetup(){
Tile crossCity=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY}, null, false, true, false );
//1 crossCity in game
Tile crossCityShield=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY}, null, false, true, true );
//2 crossCityShield in game
Tile city3Side=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY}, null, false, true, false );
//3 city3Side in game
Tile city3SideShield=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY}, null, false, true, true );
//1 city3SideShield in game
Tile city3SideRoad=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.ROAD, TileFeature.CITY}, null, true, true, false );
//1 city3SideRoad in game
Tile city3SideRoadShield=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.ROAD, TileFeature.CITY}, null, true, true, true );
//2 city3SideRoad in game
Tile cityAll=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.CITY, TileFeature.CITY}, null, false, true, true );
//1 cityAll in game
Tile cityCornersUnconnected=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.GRASS, TileFeature.GRASS}, null, false, false, false );
//2 cityCornersUnconnected in game
Tile cityCornersConnected=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.GRASS, TileFeature.GRASS}, null, false, true, false );
//3 cityCornersConnected in game
Tile cityCornersConnectedShield=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.GRASS, TileFeature.GRASS}, null, false, true, true );
//2 cityCornersConnectedShield in game
Tile cityCornersConnectedRoad=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.ROAD, TileFeature.ROAD}, null, false, true, false );
//3 cityCornersConnectedRoad in game
Tile cityCornersConnectedRoadShield=new Tile(new Integer[]{TileFeature.CITY, TileFeature.CITY, TileFeature.ROAD, TileFeature.ROAD}, null, false, true, true );
//2 cityCornersConnectedRoadShield in game
Tile cityEdge=new Tile(new Integer[]{TileFeature.CITY, TileFeature.GRASS, TileFeature.GRASS, TileFeature.GRASS}, null, false, false, false );
//5 cityEdge in game
Tile cityEdgeRoad=new Tile(new Integer[]{TileFeature.CITY, TileFeature.ROAD, TileFeature.GRASS, TileFeature.ROAD}, null, false, false, false );
//4 cityEdgeRoad in game
Tile cityEdgeRoadFork=new Tile(new Integer[]{TileFeature.CITY, TileFeature.ROAD, TileFeature.ROAD, TileFeature.ROAD}, null, true, false, false );
//3 cityEdgeRoadFork in game
Tile cityEdgeRoadBendRight=new Tile(new Integer[]{TileFeature.CITY, TileFeature.ROAD, TileFeature.ROAD, TileFeature.GRASS}, null, false, false, false );
//3 cityEdgeRoadBendRight in game
Tile cityEdgeRoadBendLeft=new Tile(new Integer[]{TileFeature.CITY, TileFeature.GRASS, TileFeature.ROAD, TileFeature.ROAD}, null, false, false, false );
//3 cityEdgeRoadBendLeft in game
Tile city2Edge=new Tile(new Integer[]{TileFeature.CITY, TileFeature.GRASS, TileFeature.CITY, TileFeature.GRASS}, null, false, false, false );
//3 city2Edge in game
Tile roadStraight=new Tile(new Integer[]{TileFeature.ROAD, TileFeature.GRASS, TileFeature.ROAD, TileFeature.GRASS}, null, false, false, false );
//8 roadStraight in game
Tile roadBend=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.GRASS, TileFeature.ROAD, TileFeature.ROAD}, null, false, false, false );
//9 roadBend in game
Tile roadFork=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.ROAD, TileFeature.ROAD, TileFeature.ROAD}, null, true, false, false );
//4 roadFork in game
Tile roadAll=new Tile(new Integer[]{TileFeature.ROAD, TileFeature.ROAD, TileFeature.ROAD, TileFeature.ROAD}, null, true, false, false );
//1 roadAll in game
Tile cloisterRoad=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.GRASS, TileFeature.ROAD, TileFeature.GRASS}, null, true, false, false );
//2 cloisterRoad in game
Tile cloister=new Tile(new Integer[]{TileFeature.GRASS, TileFeature.GRASS, TileFeature.GRASS, TileFeature.GRASS}, null, false, false, false );
//4 cloister in game
}

}