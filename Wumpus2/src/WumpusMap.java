//import com.sun.org.apache.xml.internal.security.Init;

/**
 *  Creates game map and handles main game
 */

public class WumpusMap {

	public static final int N_ROOMS = 20;
	public static final int NORTH = 1;
	public static final int EAST = 2;
	public static final int SOUTH = 3;
	public static final int WEST = 4;
	public static final int N_DIRECTIONS = 4;
	public static final int Exit = 0;
	public static final int Win = 5;
	public static final int Loose = 6;



	final static String[] DIRECTION_NAMES = {"", "north", "east", "south", "west"};
	final static String[] DIRECTION_SHORT_NAMES = {"", "n", "e", "s", "w"};

	public static WumpusRoom[] rooms;
	public static StartFinishRoom[] exRooms;


	public WumpusMap() {
		//InitMap(); //PROBLEM
		MapFactory.initializeMap();
	}

//	public void InitMap() {
//		rooms = new WumpusRoom[WumpusMap.N_ROOMS + 1];
//		WumpusMap.rooms[1] = new WumpusRoom(1, 0, 5, 6, 2, "Emerald", false, "bb");
//		WumpusMap.rooms[2] = new WumpusRoom(2, 0, 1, 7, 3, "", true, "cg");
//		WumpusMap.rooms[3] = new WumpusRoom(3, 0, 2, 8, 4, "", false, "pit");
//		WumpusMap.rooms[4] = new WumpusRoom(4, 0, 3, 9, 5, "", false, "bat");
//		WumpusMap.rooms[5] = new WumpusRoom(5, 0, 4, 10, 1, "", false, "shroom");
//		WumpusMap.rooms[6] =  new WumpusRoom(6, 1, 15, 0, 11, "Ruby", false, "");
//		WumpusMap.rooms[7] =  new WumpusRoom(7, 2, 11, 0, 12, "", true, "");
//		WumpusMap.rooms[8] =  new WumpusRoom(8, 3, 12, 0, 13, "", false, "");
//		WumpusMap.rooms[9] =  new WumpusRoom(9, 4, 13, 0, 14, "", false, "pit");
//		WumpusMap.rooms[10] =  new WumpusRoom(10, 5, 14, 0, 15, "", false, "");
//		WumpusMap.rooms[11] =  new WumpusRoom(11, 0, 6, 16, 7, "", false, "");
//		WumpusMap.rooms[12] =  new WumpusRoom(12, 0, 7, 17, 8, "Sapphire", true, "");
//		WumpusMap.rooms[13] =  new WumpusRoom(13, 0, 8, 18, 9, "", false, "");
//		WumpusMap.rooms[14] =  new WumpusRoom(14, 0, 9, 19, 10, "Pearl", false, "");
//		WumpusMap.rooms[15] =  new WumpusRoom(15, 0, 10, 20, 6, "", false, "");
//		WumpusMap.rooms[16] =  new WumpusRoom(16, 11, 20, 0, 17, "Jade", false, "pit");
//		WumpusMap.rooms[17] =  new WumpusRoom(17, 12, 16, 0, 18, "", true, "");
//		WumpusMap.rooms[18] =  new WumpusRoom(18, 13, 17, 0, 19, "", false, "");
//		WumpusMap.rooms[19] =  new WumpusRoom(19, 14, 18, 0, 20, "Diamond", false, "");
//		WumpusMap.rooms[20] =  new WumpusRoom(20, 15, 19, 0, 16, "", false, "");
//		WumpusMap.exRooms = new StartFinishRoom[4];
//		WumpusMap.exRooms[1] =  new StartFinishRoom("Home Base");
//		WumpusMap.exRooms[2] =  new StartFinishRoom("Loose");
//		WumpusMap.exRooms[3] =  new StartFinishRoom("Win");
//	}
	
	public static String directionName(int dir) {
		if (dir >= 1 && dir <= 4) 
			return DIRECTION_NAMES[dir];	
		else
			return "ERROR";
	}
	
	public static int directionNumber(String dir) {
		for (int i = 1; i <= N_DIRECTIONS; i++) {
			if (DIRECTION_NAMES[i].equals(dir) ||
				DIRECTION_SHORT_NAMES[i].equals(dir)) {
				return i;
			} 
		}
		return 0;

	}
	
	public WumpusRoom getRoom(int ndx) {
		return rooms[ndx];
	}
	public StartFinishRoom getSpecialRoom(int ndx){ return exRooms[ndx]; }
	
	public int randomEmptyRoom() {
		int r = 0;
		do {
			r = (int) (Math.random() * N_ROOMS + 1);
		}	
		while (rooms[r].getElement() != null);
		return r;
	}

	public int randomEmptyWumpusRoom() {
		int r = 0;
		do {
			r = (int) (Math.random() * N_ROOMS + 1);
		}
		while (rooms[r].getWumpusElement() != null);
		return r;
	}

	public int randomComplEmptyRoom() {
		int r = 0;
		do {
			r = (int) (Math.random() * N_ROOMS + 1);
		}
		while (rooms[r].getWumpusElement() != null && rooms[r].getWumpusElement() != null);
		return r;
	}
	
	public void addElement(RoomElement elem) {
		getRoom(randomEmptyRoom()).setElement(elem);	
	}

	public void addWumpusElement(WRoomElement Welem) {
		getRoom(randomEmptyWumpusRoom()).setWumpusElement(Welem);
	}
	
	public void moveWumpus() {
		for (int i = 1; i <= N_ROOMS; i++) {
			if (rooms[i].getWumpusElement() != null) {
				// switch these two lines to force wumpus to move
				rooms[i].setElement(null);
				addWumpusElement(new WumpusElement());
				return;
			}
		}
	}
}
