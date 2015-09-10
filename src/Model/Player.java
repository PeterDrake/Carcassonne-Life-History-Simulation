package Model;

//Currently, this has only been reviewed by one half of the pair--it should be stable, but needs to be checked.
	public class Player {
		private int playerScore=0;
		private int followerCount=0;
		private String name;
		//Gives the player an ID number for their followers to be known by. Might or might not end up used.
		private int ID;

		public void addScore(int score){
			playerScore=playerScore+score;
		}
		
		public void addName(String newName){
			name=newName;
		}
		
		//Conceptual, related to player IDs
		public void addID(int number){
			ID=number;
		}

		public void addFollower(){
			followerCount++;
		}

		//Removes a follower. NOTE: This will not check the amount of followers first. Other functions must check that there are more than zero followers available before
		//calling this function.
		public void removeFollower(){
			followerCount--;
		}

		public int getScore(){
			return playerScore;
		}

		//Gives amount of remaining followers
		public int getFollower(){
			return followerCount;
		}
		
		public String getName(){
			return name;
		}
		
		//Linked to the conceptual player IDs
		public int getID(){
			return ID;
		}

	}