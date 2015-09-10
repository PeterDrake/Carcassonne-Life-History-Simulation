package Model;

import javax.swing.JPanel;

public class CarcassonneModel extends JPanel {
	
	private int tileCounter = 0; 
	
	public CarcassonneModel(){
	}
	
	public void addTile(){
		//TODO: random select tile from the deck
		//TODO: Keep track of which player is using tile
		
		tileCounter++;
	}
	/**
	 * Searches to detect if all tiles have been used
	 */
	public boolean isOver(){
		if(tileCounter == 72){
			return true;
		}
		else{
			return false; 
		}
	}
}