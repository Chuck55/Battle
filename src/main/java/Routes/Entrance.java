package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Entrance implements BaseRoute {
    private SaveGame saveGame = new SaveGame();

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws IOException {
        Upstairs upstairs = new Upstairs();
        Kitchen kitchen = new Kitchen();
        ParkingLot parkingLot = new ParkingLot();
        String choice = "";
        do {
            printLocation(defeated);
            if(saveGame.getScanner().hasNextLine()) {
                choice = saveGame.getScanner().nextLine();
            }
            System.out.println(choice);
            switch (choice) {
                case "person":
                    if(!defeated.talkedWithMartin)
                    {
                        saveGame.printOrder("DidntTalkToMartin");
                    }
                    else if(!defeated.martinDefeated)
                    {
                        saveGame.printOrder("TalkWithJohn1.txt");
                        defeated.talkedWithJohn = true;
                    }
                    break;
                case "left":
                    kitchen.activities(newPastor, defeated);
                    break;
                case "right":
                    upstairs.activities(newPastor, defeated);
                    break;
                case "forward":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "behind":
                    parkingLot.activities(newPastor, defeated);
                    break;
                case "save" :
                    saveGame.print(newPastor, defeated);
                default:
                    System.out.println("Not a valid entry, Please reenter");
            }
        } while (true);
    }
    @Override
    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are in the Entrance, what would would you like to do?");
        System.out.println(" person : Talk with John");
        System.out.println(" Left : Kitchen");
        System.out.println(" Right : Upstairs");
        System.out.println(" Behind : Parking Lot");
        //  System.out.println(" Forward :" + location.forward.name);
        //}
        System.out.println();
    }
}
