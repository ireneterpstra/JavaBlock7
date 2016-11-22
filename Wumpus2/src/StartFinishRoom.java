/**
 *  class for special floating rooms that you are sent to when you begin the game and end it
 */

public class StartFinishRoom{
    private String whatRoom;		//  the rooms are numbered 1-20; the index refers to that number


    StartFinishRoom(String ndx) {
        whatRoom = ndx;

    }

    void printInfo() {
        System.out.print(String.valueOf(whatRoom));

        System.out.println();
        if (whatRoom.equals("Home Base")) {
            System.out.println("GAME INFO:\n" +
                    "Collect all 6 gems to win game\n" +
                    "Be aware of wumpuses hiding in the rooms\n" +
                    "Dont fall into the pits\n" +
                    "Bats will carry you to a random room\n" +
                    "Fing bowling balls to weigh you down and climbing gear to escape pits\n" +
                    "Dont fall into the pits\n" +
                    "Press q to return to Home Base\n" +
                    "Type done to end game\n");
        }

        System.out.println();
    }


}
