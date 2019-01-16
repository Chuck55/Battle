package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;

public class StorageRoom implements BaseRoute{
    private SaveGame saveGame = new SaveGame();
    private boolean correct;
    private String choice;
    private BallRoom ballRoom;
    private YouthRoom youthRoom;
    @Override
    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are in the Storage Room, what would would you like to do?");
        if (defeated.noOneDefeated) {
            System.out.println("Fight ");
        } else if (defeated.martinDefeated) {
            System.out.println("Fight");
        } else if (defeated.kevinDefeated) {
            System.out.println("Fight");
        }
        System.out.println(" Left : Youth Room");
        System.out.println(" Right : UpStairs");
        System.out.println(" Behind :  BallRoom");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException {
        ballRoom = new BallRoom();
        youthRoom = new YouthRoom();
        do {
            printLocation(defeated);
            choice = saveGame.getScanner().nextLine();
            choice = saveGame.getScanner().nextLine();
            System.out.println(choice);
            switch (choice) {
                case "person":
                    correct = true;
                    break;
                case "left":
                    correct = true;
                    youthRoom.activities(newPastor, defeated);
                    break;
                case "right":
                    correct = true;
                    break;
                case "forward":
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "behind":
                    correct = true;
                    ballRoom.activities(newPastor, defeated);
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
