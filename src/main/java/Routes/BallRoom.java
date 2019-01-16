package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;

public class BallRoom implements BaseRoute {
    private SaveGame saveGame;
    private ChildrenRoom childrenRoom;
    private ParkingLot parkingLot;
    private Kitchen kitchen;
    private StorageRoom storageRoom;

    @Override
    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are in the Ballroom, what would would you like to do?");
        if (defeated.noOneDefeated) {
            System.out.println("Fight ");
        } else if (defeated.martinDefeated) {
            System.out.println("Fight");
        } else if (defeated.kevinDefeated) {
            System.out.println("Fight");
        }
        System.out.println(" Left : Outside");
        System.out.println(" Right : Children Room");
        System.out.println(" Behind : Kitchen");
        System.out.println(" Forward : Storage");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException {
        saveGame = new SaveGame();
        childrenRoom = new ChildrenRoom();
        parkingLot = new ParkingLot();
        kitchen = new Kitchen();
        storageRoom = new StorageRoom();
        boolean correct;
        do {
            printLocation(defeated);
            String choice = saveGame.getScanner().nextLine();
            choice = saveGame.getScanner().nextLine();
            System.out.println(choice);
            switch (choice) {
                case "person":
                    correct = true;
                    break;
                case "left":
                    correct = true;
                    parkingLot.activities(newPastor, defeated);
                    break;
                case "right":
                    correct = true;
                    childrenRoom.activities(newPastor, defeated);
                    break;
                case "forward":
                    correct = true;
                    storageRoom.activities(newPastor, defeated);
                    break;
                case "behind":
                    correct = true;
                    kitchen.activities(newPastor, defeated);
                    break;
                case "save" :
                    saveGame.print(newPastor);
                default:
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
            }
        } while (!correct);
    }
}
