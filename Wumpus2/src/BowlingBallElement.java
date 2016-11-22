/**
 * Created by block7 on 11/3/16.
 */
public class BowlingBallElement extends RoomElement {

    public void handle() {
        System.out.println("You found a bowling ball");
        Hero.cantFly = true;
    }

    public void printSenses() {
    }
}
