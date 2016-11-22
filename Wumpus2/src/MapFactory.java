import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapFactory {
	
	public static void initializeMap(){
		
		
		WumpusMap.rooms = new WumpusRoom[WumpusMap.N_ROOMS + 1];
		
		
		WumpusMap.rooms[1] = new WumpusRoom(1, 0, 5, 6, 2, "", false, "bb");
		WumpusMap.rooms[2] = new WumpusRoom(2, 0, 1, 7, 3, "", true, "cg");
		WumpusMap.rooms[3] = new WumpusRoom(3, 0, 2, 8, 4, "", false, "pit");
		WumpusMap.rooms[4] = new WumpusRoom(4, 0, 3, 9, 5, "", false, "bat");
		WumpusMap.rooms[5] = new WumpusRoom(5, 0, 4, 10, 1, "", false, "shroom");
		WumpusMap.rooms[6] =  new WumpusRoom(6, 1, 15, 0, 11, "", false, "");
		WumpusMap.rooms[7] =  new WumpusRoom(7, 2, 11, 0, 12, "", true, "");
		WumpusMap.rooms[8] =  new WumpusRoom(8, 3, 12, 0, 13, "", false, "");
		WumpusMap.rooms[9] =  new WumpusRoom(9, 4, 13, 0, 14, "", false, "pit");
		WumpusMap.rooms[10] =  new WumpusRoom(10, 5, 14, 0, 15, "", false, "");
		WumpusMap.rooms[11] =  new WumpusRoom(11, 0, 6, 16, 7, "", false, "");
		WumpusMap.rooms[12] =  new WumpusRoom(12, 0, 7, 17, 8, "", true, "");
		WumpusMap.rooms[13] =  new WumpusRoom(13, 0, 8, 18, 9, "", false, "");
		WumpusMap.rooms[14] =  new WumpusRoom(14, 0, 9, 19, 10, "", false, "");
		WumpusMap.rooms[15] =  new WumpusRoom(15, 0, 10, 20, 6, "", false, "");
		WumpusMap.rooms[16] =  new WumpusRoom(16, 11, 20, 0, 17, "", false, "pit");
		WumpusMap.rooms[17] =  new WumpusRoom(17, 12, 16, 0, 18, "", true, "");
		WumpusMap.rooms[18] =  new WumpusRoom(18, 13, 17, 0, 19, "", false, "");
		WumpusMap.rooms[19] =  new WumpusRoom(19, 14, 18, 0, 20, "", false, "");
		WumpusMap.rooms[20] =  new WumpusRoom(20, 15, 19, 0, 16, "", false, "");
		WumpusMap.exRooms = new StartFinishRoom[4];
		WumpusMap.exRooms[1] =  new StartFinishRoom("Home Base");
		WumpusMap.exRooms[2] =  new StartFinishRoom("Loose");
		WumpusMap.exRooms[3] =  new StartFinishRoom("Win");
		
		Map<GemEnum, Integer> map = randomGems(WumpusMap.N_ROOMS);
		for (GemEnum gem : map.keySet()){
			int roomIndex = map.get(gem);
			
			WumpusMap.rooms[roomIndex].setGem(gem);
			
		}
		
	}
	
	public static Map<GemEnum, Integer> randomGems(int numRooms){
		assert numRooms >= 2;
		assert  numRooms >= GemEnum.values().length;
		
		Map<GemEnum, Integer> map = new HashMap<GemEnum, Integer>();
		
		for (GemEnum gem : GemEnum.values()){
			do{
				int randomRoom = (int) Math.round((Math.random() * (numRooms - 1)) + 1);
				if (!map.containsValue(randomRoom)){
					map.put(gem, randomRoom);
					break;
				}
			}
			while (true);
		}
		
		
		

		return map;
	}

}
