package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Upstairs implements BaseRoute {
    private SaveGame saveGame = new SaveGame();

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
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws IOException {
        Entrance entrance = new Entrance();
        Chapel chapel = new Chapel();
        FireSideRoom fireSideRoom = new FireSideRoom();
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
                    fireSideRoom.activities(newPastor, defeated);
                    break;
                case "right":
                    chapel.activities(newPastor, defeated);
                    break;
                case "forward":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "behind":
                    entrance.activities(newPastor, defeated);
                    break;
                case "save":
                    saveGame.print(newPastor, defeated);
                default:
                    System.out.println("Not a valid entry, Please reenter");
            }
        } while (true);
    }
}
