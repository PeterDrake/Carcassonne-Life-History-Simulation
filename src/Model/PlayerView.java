package Model;

import javax.swing.*;

import java.awt.*;

public class PlayerView extends JPanel{
	
//	private JLabel name;
	private JTextField name;
	private JLabel score;
	private JLabel followerCount;
	private JButton saveName;


	int h = 50;
	int w = (Carcassonne.WIDTH / 100);

	/** Constructor of PlayerView;
	 * takes in player name, score, follower count
	 */
	public PlayerView(Player currentPlayer)
	{

		setLayout(new GridLayout(3,2));
		setSize(w, h);
		setBackground(Color.GRAY);
		
		name = new JTextField();		
//		name = new JLabel(playerName);
		add(name, 0,0);
		
		
		score = new JLabel("Score: " + Integer.toString(currentPlayer.getScore()));
		add(score, 0,1);
		
		followerCount = new JLabel("Available meeple: " + Integer.toString(currentPlayer.getFollowers()));
		add(followerCount, 0,2);
		
		
	}

}
