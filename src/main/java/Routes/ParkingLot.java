package Routes;
import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;
import java.io.IOException;

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
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws IOException {
        SaveGame saveGame = new SaveGame();
        Entrance entrance = new Entrance();
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
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "right":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "forward":
                    entrance.activities(newPastor, defeated);
                    break;
                case "behind":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "save":
                    saveGame.print(newPastor, defeated);
                default:
                    System.out.println("Not a valid entry, Please reenter");
            }
        } while (true);
    }
}
