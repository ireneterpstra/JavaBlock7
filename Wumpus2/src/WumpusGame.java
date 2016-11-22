/**
 *  main game class; provides main loop and some utilities.
 */

import java.io.*;

public class WumpusGame {
	public static WumpusMap map = new WumpusMap();
	public static Hero hero = new Hero();
	public static boolean gameActive = true;

	
	public static int currentRoomIndex = 0;
	public static int specialRoomIndex = 1;


	// special i/o method required because Eclipse does not provide a Console object
	private static String readLine(String prompt) {
	        String line = null;
	        Console c = System.console();
	        if (c != null) {
	             line = c.readLine(prompt);
	        } else {
	            System.out.print(prompt);
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	            try {
	                 line = bufferedReader.readLine();
	            } catch (IOException e) { 
	                //Ignore    
	            }
	        }
	        return line;
	 }

	
	public static void shootArrow(String input) {
		if(input.length() < 7){
			System.out.println("Huh?");
			return;
		}
		String direction = input.substring(6);  // direction should be input after "shoot " part
		int dirNum = WumpusMap.directionNumber(direction);
		if (dirNum == 0) {
			System.out.println("Huh?");   // bad shoot direction
		} else {
			WumpusRoom room = currentRoom();
			WumpusRoom targetRoom = room.roomInDirection(dirNum); 
			if (targetRoom != null) {
				if (targetRoom.getWumpusElement() != null && (targetRoom.getWumpusElement() instanceof WumpusElement)) {
					System.out.println("You shoot the wumpus.  Victory!!");
					gameActive = false;
				} else {
					System.out.println("You missed and scared the wumpus.");
					map.moveWumpus();
				}
			} else {
				System.out.println("Can't fire that way.");
			}
		}
	}
	
	public static WumpusRoom currentRoom() {
		return map.getRoom(currentRoomIndex);
	}
	
	public static void main(String[] args) {
		
		do  {
			if (!(currentRoomIndex == 0) && specialRoomIndex == 0) {
				map.getRoom(currentRoomIndex).printInfo();

				String userInput = readLine("You have found " + hero.numberOfGems + " gems > ");
				System.out.println();
				Hero.highTime++;
				if (userInput.startsWith("shoot")) {
					shootArrow(userInput);
				} else if (Hero.onShrooms) {
					if (hero.highTime > 3) {
						hero.onShrooms = false;
					}
					int tempIput = (int) (Math.random() * 4 + 1);
					if (tempIput == 1) {
						userInput = "s";
					} else if (tempIput == 2) {
						userInput = "n";
					} else if (tempIput == 3) {
						userInput = "e";
					} else if (tempIput == 4) {
						userInput = "w";
					}
				}
				int direction = 0;
				if ((direction = WumpusMap.directionNumber(userInput)) != 0) {
					if (!userInput.equals("q")) {
						WumpusRoom nowRoom = map.getRoom(currentRoomIndex);
						WumpusRoom targetRoom = nowRoom.roomInDirection(direction);
						//assert targetRoom != null : "Target room should not have been null";
						if (targetRoom != null){
							
							if (!targetRoom.getMyGem().equals("")){
								hero.addNewGem(targetRoom.getMyGem());
								targetRoom.clearGem();
							}
							if (targetRoom.getWumpusElement() != null || targetRoom.getElement() != null) {
								currentRoomIndex = targetRoom.getIndex();
								targetRoom.handleElement();
							}

						}
						else {
							System.out.println("You can't move in that direction.");
						}
					}
				} else if (userInput.equals("q")) {
					currentRoomIndex = 0;
					specialRoomIndex = 1;
					//gameActive = false;
				} else if (userInput.equals("done")) {
					gameActive = false;
				} else {
					System.out.println("Command not understood.");
				}
			} else if (specialRoomIndex > 0) {
				if (specialRoomIndex == 1) {
					hero.resetGame();
					map.getSpecialRoom(specialRoomIndex).printInfo();
					String userInput = readLine("Press any key to start game > ");
					if (!(userInput == null)) {
						specialRoomIndex = 0;
						currentRoomIndex = map.randomComplEmptyRoom();
					}
				} else if (specialRoomIndex == 2) {
					map.getSpecialRoom(specialRoomIndex).printInfo();
					System.out.println();
					System.out.println("You found " + hero.numberOfGems + " gems \n");
					hero.printGems();
					String userInput = readLine("You lost: Press anny key to return to start");
					System.out.println("Press any key to restart >");
					if (!(userInput == null)) {
						specialRoomIndex = 1;
					}
				} else if (specialRoomIndex == 3) {
					map.getSpecialRoom(specialRoomIndex).printInfo();
					String userInput = readLine("You won: Press anny key to return to start");
					if (!(userInput == null)) {
						specialRoomIndex = 1;
					}
				}
			}
		} while (gameActive);
		System.out.println("GAME OVER");
	}
	
	public static void resetGame(){
		WumpusGame.map = new WumpusMap();
	}

}
