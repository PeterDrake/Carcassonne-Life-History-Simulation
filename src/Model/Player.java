package Model;

//Currently, this has only been reviewed by one half of the pair--it should be stable, but needs to be checked.
public class Player {

	// We input the player's name and ID when constructing them. Score and
	// follower count are initialized to default values.
	public Player(String name, int ID) {
		this.name = name;
		this.ID = ID;
		playerScore = 0;
		followerCount = 7;
	}

	private int playerScore = 0;
	// Player starts with 7 available followers to place
	private int followerCount = 7;
	private String name;
	// Gives the player an ID number for their followers to be known by. Will
	// also be used for turn order, most likely.
	private int ID;

	public void addScore(int score) {
		playerScore = playerScore + score;
	}

	public void addName(String newName) {
		name = newName;
	}

	// Conceptual, related to player IDs
	public void addID(int number) {
		ID = number;
	}

	public void addFollower() {
		followerCount++;
	}

	// Removes a follower. NOTE: This will not check the amount of followers
	// first. Other functions must check that there are more than zero followers
	// available before
	// calling this function.
	public void removeFollower() {
		followerCount--;
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