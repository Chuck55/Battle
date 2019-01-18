package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;


public class Entrance implements BaseRoute {
    private SaveGame saveGame = new SaveGame();

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException {
        Upstairs upstairs = new Upstairs();
        Kitchen kitchen = new Kitchen();
        ParkingLot parkingLot = new ParkingLot();
        String choice;
        boolean correct;
        do {
            printLocation(defeated);
            choice = saveGame.getScanner().nextLine();
            System.out.println(choice);
            switch (choice) {
                case "person":
                    correct = true;
                    break;
                case "left":
                    correct = true;
                    kitchen.activities(newPastor, defeated);
                    break;
                case "right":
                    correct = true;
                    upstairs.activities(newPastor, defeated);
                    break;
                case "forward":
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "behind":
                    correct = true;
                    parkingLot.activities(newPastor, defeated);
                    break;
                case "save" :
                    saveGame.print(newPastor);
                default:
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
            }
        } while (!correct);
    }
    @Override
    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are in the Entrance, what would would you like to do?");
        System.out.println(" Left : Kitchen");
        System.out.println(" Right : Upstairs");
        System.out.println(" Behind : Parking Lot");
        //  System.out.println(" Forward :" + location.forward.name);
        //}
        System.out.println();
    }
}
