package Model;

import java.util.ArrayList;
import java.util.Stack;

//Currently, this has only been reviewed by one half of the pair--it should be stable, but needs to be checked.
public class Player {

	/**
	 * Create a new Player
	 * @param name
	 * @param ID
	 */
	public Player(String name, int ID) {
		this.name = name;
		this.ID = ID;
		playerScore = 0;
		// initialize followers
		this.followers = new ArrayList<Follower>();
		for (int i = 0; i < followerCount; i++) {
			this.followers.add(new Follower());
		}
	}

	/**
	 * Fields
	 */
	private Integer playerScore;
	
	// Player starts with 7 available followers to place
	private static final Integer followerCount = 7;
	
	// Our followers
	private ArrayList<Follower> followers;
	
	private String name;
	// Gives the player an ID number for their followers to be known by. Will
	// also be used for turn order, most likely.
	private Integer ID;

	
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
	 * Change Player's UID. Shouldn't ever be used?
	 * @param number
	 */
	public void changeID(int number) {
		ID = number;
	}

	/**
	 * Get Player's current score
	 * @return the player's numeric score
	 */
	public int getScore() {
		return playerScore;
	}

	/**
	 * Get count of Player's Followers.
	 * @return 
	 */
	public int getFollowers() {
		return followerCount;
	}

	/**
	 * Get Player's name.
	 * @return the player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Linked to the conceptual player IDs. Note: what are these even for?
	 * @return
	 */
	public int getID() {
		return ID;
	}

}