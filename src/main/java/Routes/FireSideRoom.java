package Routes;

import BattleStuff.CalvinBattle;
import Characters.LowTier;
import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FireSideRoom implements BaseRoute{
    private SaveGame saveGame = new SaveGame();
    CalvinBattle calvin = new CalvinBattle();
    LowTier lowTier = new LowTier();

    @Override
    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are in the Fireside Room, what would would you like to do?");
        if (defeated.noOneDefeated) {
            System.out.println("Nothing Here ");
        }
        else if(defeated.talkedWithJohn && !defeated.calvinDefeated)
        {
            System.out.println("Talk with Calvin?");
        }
         else if (defeated.martinDefeated) {
            System.out.println("Fight");
        } else if (defeated.kevinDefeated) {
            System.out.println("Fight");
        }
        System.out.println(" Right : UpStairs");
        System.out.println(" Forward :  Chapel");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws IOException {
        Upstairs upstairs = new Upstairs();
        Chapel chapel = new Chapel();
        String choice = "";
        do {
            printLocation(defeated);
            if(saveGame.getScanner().hasNextLine()) {
                choice = saveGame.getScanner().nextLine();
            }
            System.out.println(choice);
            switch (choice) {
                case "person":
                    if(defeated.talkedWithJohn && !defeated.calvinDefeated)
                    {
                        saveGame.printOrder("CalvinConv.txt");
                        calvin.Calvinfight(newPastor, lowTier.getCalvin(),defeated);
                    }
                    break;
                case "left":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "right":
                    upstairs.activities(newPastor, defeated);
                    break;
                case "forward":
                    chapel.activities(newPastor, defeated);
                    break;
                case "behind":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "save" :
                    saveGame.print(newPastor, defeated);
                default:
                    System.out.println("Not a valid entry, Please reenter");
            }
        } while (true);
    }
}
