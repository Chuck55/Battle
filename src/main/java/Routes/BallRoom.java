package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;
import utility.ItemClass;
import utility.Weapons;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BallRoom implements BaseRoute {
    private SaveGame saveGame;
    private ItemClass itemClass;
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
        System.out.println(" FartherLeft : A Mysterious Room?");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws IOException {
        saveGame = new SaveGame();
        childrenRoom = new ChildrenRoom();
        parkingLot = new ParkingLot();
        kitchen = new Kitchen();
        storageRoom = new StorageRoom();
        itemClass = new ItemClass();
        String choice = "   ";
        do {
            printLocation(defeated);
            if(saveGame.getScanner().hasNextLine()) {
                choice = saveGame.getScanner().nextLine();
            }
            System.out.println(choice);
            switch (choice) {
                case "person":
                    break;
                case "left":
                    parkingLot.activities(newPastor, defeated);
                    break;
                case "right":
                    childrenRoom.activities(newPastor, defeated);
                    break;
                case "forward":
                    storageRoom.activities(newPastor, defeated);
                    break;
                case "behind":
                    kitchen.activities(newPastor, defeated);
                case "FartherLeft":
                    //saveGame.printOrder("MysteriousRoom.txt");
                    //newPastor.getBigBag().obtainedWeapon(itemClass.getTableLeg());
                    saveGame.print(newPastor, defeated);
                    break;
                case "save" :
                    saveGame.print(newPastor, defeated);
                default:
                    System.out.println("Not a valid entry, Please reenter");
            }
        } while (true);
    }
}
