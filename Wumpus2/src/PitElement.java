/**
 * Element where you are killed w/o climbing gear
 */
public class PitElement extends RoomElement {

    public void handle() {
        if (!Hero.canClimb) {
            System.out.println("You fell into a pit");
            WumpusGame.specialRoomIndex = 2;
        } else {
            System.out.println("You use your climbing gear to scale to pit");
        }
    }

    public void printSenses()  {
        System.out.println("You feel a breeze");
    }
}
