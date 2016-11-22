/**
 * WumpusRoom -- This class represents a single room on the map; a room corresponds to one vertex of a dodecahedron.
 * The class helps in navigating the map and handling encounters when the player moves. 
 */

public class WumpusRoom {

	private int myIndex;		//  the rooms are numbered 1-20; the index refers to that number
	private int[] neighbors;	// index values for neighboring rooms in order: N, E, S, W
		
	private RoomElement myElement;
	private WRoomElement myWumpusElement;
	private Gem myGem;
		
	WumpusRoom(int ndx, int n, int e, int s, int w, String g, boolean hasWumpus, String element) {
		myIndex = ndx;
		neighbors = new int[WumpusMap.N_DIRECTIONS + 3];
		neighbors[WumpusMap.NORTH] = n;
		neighbors[WumpusMap.EAST] = e;
		neighbors[WumpusMap.SOUTH] = s;
		neighbors[WumpusMap.WEST] = w;
		if (!g.equals("")){
			myGem = new Gem();
			myGem.setGemType(g);
		} else {
			myGem = new Gem();
			myGem.setGemType("");
		}
		if (hasWumpus) {
			myWumpusElement = new WumpusElement();
		}
		if (element.equals("bb")) {
			myElement = new BowlingBallElement();
		} else if (element.equals("bat")) {
			myElement = new BatElement();
		} else if (element.equals("pit")) {
			myElement = new PitElement();
		} else if (element.equals("shroom")) {
			myElement = new ShroomElelemt();
		} else if (element.equals("cg")) {
			myElement = new ClimbingGearElement();
		} else if (element.equals("")) {
			myElement = new EmptyElement();
		}

	}
		
	int getIndex() {
			return myIndex;
		}
		
	RoomElement getElement() {
			return myElement;
		}
	WRoomElement getWumpusElement() {
		return myWumpusElement;
	}

	public String getMyGem() {
		return myGem.getGemType();
	}

	public void clearGem() {
		myGem.setGemType("");
	}

	public int moveIsValid(int x) {
		for (int i = 0; i < neighbors.length; i++){
			if (neighbors[i] == x){
				return i;
			}
		}
		return 0;
	}
		
	void setElement(RoomElement elem) {
			myElement = elem;
		}
	void setWumpusElement(WRoomElement Welem) {
		myWumpusElement = Welem;
	}
		
	/**
	 * 
	 * @param dir
	 * @return can be null
	 */
	WumpusRoom roomInDirection(int dir) {
			return WumpusGame.map.getRoom(neighbors[dir]);
		}
		
	void printInfo() {
		System.out.print("You are in room " + String.valueOf(myIndex) +". Exits:");
		for (int i = 1; i <= WumpusMap.N_DIRECTIONS; i++) {
			WumpusRoom room = roomInDirection(i);
			if (room != null) {
				System.out.print(" " + WumpusMap.directionName(i));
			}
		}
		System.out.println();
		for (int i = 1; i <= WumpusMap.N_DIRECTIONS; i++) {
			WumpusRoom room = roomInDirection(i);
			if (room != null && room.myElement != null) {
				room.myElement.printSenses();
			}
			if (room != null && room.myWumpusElement != null) {
				room.myWumpusElement.printSenses();
			}
		}
		System.out.println();
	}
		
	void handleElement() {
		if (myElement != null) {
			myElement.handle();
		}
		if (myWumpusElement != null) {
			myWumpusElement.handle();
		}
	}

	public void setGem(GemEnum gem) {
		this.myGem.setGemType(gem.name());
	}
}
