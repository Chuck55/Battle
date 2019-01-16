package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;

public class ChildrenRoom implements BaseRoute {
    private SaveGame saveGame;
    private BallRoom ballRoom;
    private ChildrenRoom childrenRoom;
    private Nursery nursery;


    @Override
    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are in the Children Room, what would would you like to do?");
        if (defeated.noOneDefeated) {
            System.out.println("Fight ");
        } else if (defeated.martinDefeated) {
            System.out.println("Fight");
        } else if (defeated.kevinDefeated) {
            System.out.println("Fight");
        }
        System.out.println(" Left : BallRoom");
        System.out.println(" Forward : Nursery");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException {
        SaveGame saveGame = new SaveGame();
        BallRoom ballRoom = new BallRoom();
        Nursery nursery = new Nursery();
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
                    ballRoom.activities(newPastor, defeated);
                    break;
                case "right":
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "forward":
                    correct = true;
                    nursery.activities(newPastor, defeated);
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
