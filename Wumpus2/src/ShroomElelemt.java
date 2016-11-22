/**
 * Makes Hero confused for 3 turns
 */
public class ShroomElelemt extends RoomElement {

    public void handle() {
        Hero.onShrooms = true;
        Hero.highTime = 0;
    }

    public void printSenses()   {
        if (Hero.onShrooms){
            System.out.println("You hear an ice cream truck");
        } else {
            System.out.println("You you smell something funny");
        }
    }
}
