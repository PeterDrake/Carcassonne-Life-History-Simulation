
package Model;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Gives a start screen, allows selection of the amount of players.

//Solution A: ask for number of players here, then feed that into the Model.
//Solution B: ask for the players within the model itself. This "setup" will be converted to being the actual model
public class Carcassonne_setup {
	private int playerCount;
//This gets fed into the Model. Once the model is running, the appropriate amount of players will be initialized.
	private JPanel initialScreen;
	private static final int DEFAULT_WIDTH=800;
	private static final int DEFAULT_HEIGHT=400;
	//Creates initial screen. We'll probably change the measurements, but this gives us a good starting point.
	public Carcassonne_setup(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public int getPlayerCount(){
		return playerCount;
	}
	

}
