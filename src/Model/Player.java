package Model;

import java.util.ArrayList;
import java.util.Stack;

//Currently, this has only been reviewed by one half of the pair--it should be stable, but needs to be checked.
public class Player {

	/**
	 * Create new player.
	 */
	public Player() {
		this("NewPlayer");
	}
	
	/**
	 * Create a new Player with Name
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
		playerScore = 0;
		// initialize followers
		this.followers = new ArrayList<Follower>();
		for (int i = 0; i < FOLLOWER_COUNT; i++) {
			this.followers.add(new Follower());
		}
	}

	/**
	 * Fields
	 */
	/** player's score */
	private Integer playerScore;
	
	/** How many followers each player gets (not incl. the scoring token) */
	public static final Integer FOLLOWER_COUNT = 7;
	
	/** Player's followers */
	private ArrayList<Follower> followers;
	
	/** Player's name */
	private String name;
	
	/**
	 * Follower Methods
	 */
	
	/**
	 * availableFollower()
	 * 
	 * @return The player's next unallocated Follower (not on a tile), otherwise null.
	 */
	public Follower availableFollower() {
		Follower availableFollower;
		for (int i = 0; i < this.followers.size(); i++) {
			availableFollower = this.followers.get(i);
			if (availableFollower.getTile() == null) {
				return availableFollower;
			}
		}
		return null;
	}
	
	/**
	 * Wraps Follower.placeOnTile() to place a Follower on a tile
	 * @param tile
	 * @param position
	 * @return the Follower that was placed, otherwise null
	 */
	public Follower placeFollower(Tile tile, Integer position) {
		Follower follower = this.availableFollower();
		if (follower != null) {
			follower.placeOnTile(tile, position);
		}
		return follower;
	}
	
	/**
	 * Getters/Setters
	 */

	/**
	 * Increments Player's score
	 * @param score
	 */
	public void addScore(int score) {
		playerScore = playerScore + score;
	}

	/**
	 * Changes Player's name.
	 * @param newName
	 */
	public void changeName(String newName) {
		name = newName;
	}

	/**
	 * Get Player's current score
	 * @return the player's numeric score
	 */
	public int getScore() {
		return playerScore;
	}

	/**
	 * Get Player's name.
	 * @return the player's name
	 */
	public String getName() {
		return name;
	}
	
}