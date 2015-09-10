package Model;

import java.util.ArrayList;
import java.util.Stack;

//Currently, this has only been reviewed by one half of the pair--it should be stable, but needs to be checked.
public class Player {

	/**
	 * Constructor
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
	 * @return The next unallocated Follower (not on a tile), otherwise null.
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

	public void addScore(int score) {
		playerScore = playerScore + score;
	}

	public void changeName(String newName) {
		name = newName;
	}

	// Conceptual, related to player IDs
	public void changeID(int number) {
		ID = number;
	}


	public int getScore() {
		return playerScore;
	}

	// Gives amount of remaining followers
	public int getFollowers() {
		return followerCount;
	}

	public String getName() {
		return name;
	}

	// Linked to the conceptual player IDs
	public int getID() {
		return ID;
	}

}