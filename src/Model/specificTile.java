package Model;

import java.awt.Image;

//Gives specific versions of tiles. Denotes the features on the tile, as well as amount of that type in the game.
public class specificTile extends Tile{

	public specificTile(Integer northFeature, Integer eastFeature,
			Integer southFeature, Integer westFeature, Image image,
			Boolean roadObstruction, Boolean cityConnects, Boolean cityShield) {
		super(northFeature, eastFeature, southFeature, westFeature, image,
				roadObstruction, cityConnects, cityShield);
		// TODO Auto-generated constructor stub
	}
	private int quantity;
	
	public void setQuantity(int q){
		quantity=q;
	}
	//Sets quantity of the given tile to be available.

}
