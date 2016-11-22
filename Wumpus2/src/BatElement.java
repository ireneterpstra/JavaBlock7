/**
 * Created by block7 on 11/2/16.
 */
public class BatElement extends RoomElement {

    public void handle() {
        if (!Hero.cantFly) {
            int newRoom = WumpusGame.map.randomEmptyRoom();
            System.out.println("Bats carry you away");
        } else {
            System.out.println("Bats try to lift you but you are too heavy");
        }
    }

    public void printSenses()  {
        System.out.println("You hear fluttering");
    }

}
