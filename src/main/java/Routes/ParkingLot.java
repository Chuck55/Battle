package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;

public class ParkingLot implements BaseRoute {

    @Override
    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are in the Parking Lot, what would would you like to do?");
        if (defeated.noOneDefeated) {
            System.out.println("Fight ");
        } else if (defeated.martinDefeated) {
            System.out.println("Fight");
        } else if (defeated.kevinDefeated) {
            System.out.println("Fight");
        }
        System.out.println(" Forward : Entrance");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException {
        SaveGame saveGame = new SaveGame();
        Entrance entrance = new Entrance();
        boolean correct;
        String choice;
        do {
            printLocation(defeated);
            choice = saveGame.getScanner().nextLine();
            System.out.println(choice);
            switch (choice) {
                case "person":
                    correct = true;
                    break;
                case "left":
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "right":
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "forward":
                    correct = true;
                    entrance.activities(newPastor, defeated);
                    break;
                case "behind":
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "save":
                    saveGame.print(newPastor);
                default:
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
            }
        } while (!correct);
    }
}
