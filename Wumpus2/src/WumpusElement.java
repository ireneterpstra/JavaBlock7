/**
 *  Wumpus Class; handels main enemy
 */

public class WumpusElement extends WRoomElement {

	public void handle() {
		System.out.println("You are eaten by the wumpus!");
		WumpusGame.specialRoomIndex = 2;
		//WumpusGame.gameActive = false;
	}
	
	public void printSenses() {
		System.out.println("You smell a wumpus.");
	}
}
