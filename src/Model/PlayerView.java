package Model;

import javax.swing.*;

import java.awt.*;

public class PlayerView extends JPanel{
	
	private JLabel name;
	private JLabel score;
	private JLabel followerCount;


	int h = 50;
	int w = (Carcassonne.WIDTH / 100);

	/** Constructor of PlayerView;
	 * takes in player name, score, follower count
	 */
	public PlayerView(String playerName, int s, int fc)
	{

		setLayout(new GridLayout(3,1));
		setSize(w, h);
		setBackground(Color.GRAY);
		
		name = new JLabel(playerName);
		add(name, 0,0);
		
		score = new JLabel("Score: " + Integer.toString(s));
		add(score, 0,1);
		
		followerCount = new JLabel("Available meeple: " + Integer.toString(fc));
		add(followerCount, 0,2);
		
		
	}

}
