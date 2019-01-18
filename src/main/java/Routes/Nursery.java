package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;

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
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException {
        SaveGame saveGame = new SaveGame();
        BallRoom ballRoom = new BallRoom();
        ChildrenRoom childrenRoom = new ChildrenRoom();
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
                    correct = true;
                    ballRoom.activities(newPastor, defeated);
                    break;
                case "right":
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "forward":
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "behind":
                    correct = true;
                    childrenRoom.activities(newPastor, defeated);
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
