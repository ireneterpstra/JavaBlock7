/**
 * Created by block7 on 11/3/16.
 */
public class ClimbingGearElement extends RoomElement {

    public void handle() {
        System.out.println("You found climbing gear");
        Hero.canClimb = true;
    }

    public void printSenses() {
    }
}
