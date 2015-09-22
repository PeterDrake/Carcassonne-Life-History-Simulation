package Model;

/**
 * Player token representation.
 *
 */
public class Follower {
	private Tile tile;


	
	/**
	 * Create new Follower. Has no parameters.
	 */
	public Follower() {
		
	}
	
	/**
	 * Place this follower on a tile
	 * @param tile the tile to place this follower on

	 */
	public void placeOnTile(Tile tile) {
		if(tile.getFollower() == false) {
			this.tile = tile;
			tile.setFollower();
		}
		//TODO: throw exception/error in else statement
	}
	
	/**
	 * Get the Tile that this Follower is placed on, if any.
	 * @return the Tile that this follower is placed on
	 */
	public Tile getTile() {
		return this.tile;
	}
	
	/**
	 * Get the position of this Follower on the tile they're placed on, if any.
	 * @return the tile position of this Follower
	 */
	public Integer getPosition() {
		return this.position;
	}
}
