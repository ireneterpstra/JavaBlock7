import java.util.HashSet;
import java.util.Set;

/**
 * Hero Class
 */

public class Hero {
    private int lives;
    
    //public static String[] myGems = {"", "", "", "", "", ""};
    public static Set<String> myGems = new HashSet<String>();
    public int numberOfGems;
    public static int highTime;
    public static boolean onShrooms = false;
    public static boolean canClimb = false;
    public static boolean cantFly = false;

    Hero(){
        if (numberOfGems == 6){
            System.out.println("You found all 6 gems");
            WumpusGame.specialRoomIndex = 2;
        }
    }

    void addNewGem(String gemName) {
//        for(int i = 0; i < myGems.length; i++){
//            if (!myGems[i].equals("")){
//                myGems[i] = gemName;
//                i = myGems.length;
//
//            }
//        }
    	myGems.add(gemName);
    	
    	
        System.out.println("You found " + gemName);
        numberOfGems = numberOfGems + 1;
    }

    void addNewLives(){

    }

    void printGems(){
        System.out.println("You gems were:");
//        for (int i = 0; i < myGems.length; i++){
//            if (myGems[i].equals("")){
//
//            } else {
//                System.out.print(myGems[i] + " ");
//            }
//        }
        for (String gem : myGems){
        	System.out.print(gem + " ");
        }
        System.out.println();
    }

    public void resetGame(){
//        for(int i = 0; i < myGems.length; i++) {
//            myGems[i] = null;
//        }
    	myGems = new HashSet<String>();
        numberOfGems = 0;
        onShrooms = false;
        canClimb = false;
        cantFly = false;
        WumpusGame.resetGame();
        //WumpusMap w = new WumpusMap();
        //w.InitMap();
    }

}
