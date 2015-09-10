package Model;

public class Follower {
	private Tile tile;
	private Integer position;
	
	public Follower() {
		
	}
	
	public void placeOnTile(Tile tile, Integer position) {
		this.tile = tile;
		this.position = position;
	}
	
	public Tile getTile() {
		return this.tile;
	}
	
	public Integer getPosition() {
		return this.position;
	}
}
