package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;

public class Upstairs implements BaseRoute {
    private SaveGame saveGame = new SaveGame();
    private FireSideRoom fireSideRoom;
    private Chapel chapel;
    private boolean correct;
    private String choice;
    private Entrance entrance;

    @Override
    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are Upstairs, what would would you like to do?");
        if (defeated.noOneDefeated) {
            System.out.println("Fight ");
        } else if (defeated.martinDefeated) {
            System.out.println("Fight");
        } else if (defeated.kevinDefeated) {
            System.out.println("Fight");
        }
        System.out.println(" Left : Fireside Room");
        System.out.println(" Right : Chapel");
        System.out.println(" Behind :  Entrance");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException {
        entrance = new Entrance();
        chapel = new Chapel();
        fireSideRoom = new FireSideRoom();
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
                    fireSideRoom.activities(newPastor, defeated);
                    break;
                case "right":
                    correct = true;
                    chapel.activities(newPastor, defeated);
                    break;
                case "forward":
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "behind":
                    correct = true;
                    entrance.activities(newPastor, defeated);
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
