package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ChildrenRoom implements BaseRoute {
    private BallRoom ballRoom;
    private Nursery nursery;
    SaveGame saveGame;


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
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws IOException {
         saveGame = new SaveGame();
         ballRoom = new BallRoom();
         nursery = new Nursery();
        String choice = "";
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
                    nursery.activities(newPastor, defeated);
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
