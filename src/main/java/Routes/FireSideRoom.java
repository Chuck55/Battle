package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;

public class FireSideRoom implements BaseRoute{
    private SaveGame saveGame = new SaveGame();

    @Override
    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are in the Fireside Room, what would would you like to do?");
        if (defeated.noOneDefeated) {
            System.out.println("Fight ");
        } else if (defeated.martinDefeated) {
            System.out.println("Fight");
        } else if (defeated.kevinDefeated) {
            System.out.println("Fight");
        }
        System.out.println(" Right : UpStairs");
        System.out.println(" Forward :  Chapel");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException {
        Upstairs upstairs = new Upstairs();
        Chapel chapel = new Chapel();
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
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "right":
                    correct = true;
                    upstairs.activities(newPastor, defeated);
                    break;
                case "forward":
                    correct = true;
                    chapel.activities(newPastor, defeated);
                    break;
                case "behind":
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
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
