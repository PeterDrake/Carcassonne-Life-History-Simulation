package Model;

import javax.swing.*;

import java.awt.*;

public class PlayerView extends JPanel{
	
	JPanel panel;
	private JLabel name;
	private JLabel score;
	private JLabel followerCount;

	
	private Rectangle size = panel.getBounds();
	double h = size.getHeight();
	double w = size.getWidth();
	
	private double boxWidth = w/6 - 35;
	
	public PlayerView(String playerName)
	{
		setLayout(new GridLayout(3,2));
		
	name = new JButton(playerName);
	name.setEnabled(false); 
	add(name, BorderLayout.NORTH);
		
	}

}
