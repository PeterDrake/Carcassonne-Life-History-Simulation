package Model;

/**
 * Player token representation.
 *
 */
public class Follower {
	private Tile tile;
	private Integer position;
	
	/**
	 * Create new Follower. Has no parameters.
	 */
	public Follower() {
		
	}
	
	/**
	 * Place this follower on a tile
	 * @param tile the tile to place this follower on
	 * @param position the position on Tile to place the follower on
	 */
	public void placeOnTile(Tile tile, Integer position) {
		this.tile = tile;
		this.position = position;
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
