package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Nursery implements BaseRoute {

    @Override
    //nursery = new Location(null, "Nursery", ballRoom, null, childrenRoom, null);

    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are in the Nursery, what would would you like to do?");
        if (defeated.noOneDefeated) {
            System.out.println("Fight ");
        } else if (defeated.martinDefeated) {
            System.out.println("Fight");
        } else if (defeated.kevinDefeated) {
            System.out.println("Fight");
        }
        System.out.println(" Left : BallRoom");
        System.out.println(" Behind : ChildRoom");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws IOException {
        SaveGame saveGame = new SaveGame();
        BallRoom ballRoom = new BallRoom();
        ChildrenRoom childrenRoom = new ChildrenRoom();
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
                    ballRoom.activities(newPastor, defeated);
                    break;
                case "right":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "forward":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "behind":
                    childrenRoom.activities(newPastor, defeated);
                    break;
                case "save":
                    saveGame.print(newPastor, defeated);
                default:
                    System.out.println("Not a valid entry, Please reenter");
            }
        } while (true);
    }
}
