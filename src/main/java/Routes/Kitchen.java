package Routes;

import BattleStuff.QBattle;
import Characters.LowTier;
import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;

public class Kitchen implements BaseRoute {

    @Override
    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are in the Kitchen, what would would you like to do?");
        if (defeated.noOneDefeated) {
            System.out.println("Fight Q?");
        } else if (defeated.martinDefeated) {
            System.out.println("Fight");
        } else if (defeated.kevinDefeated) {
            System.out.println("Fight");
        }
        System.out.println(" Right : Entrance");
        System.out.println(" Forward : BallRoom");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException {
        QBattle qBattle = new QBattle();
        LowTier lowTier = new LowTier();
        boolean correct;
        BallRoom ballRoom = new BallRoom();
        SaveGame saveGame = new SaveGame();
        Entrance entrance = new Entrance();
        String choice;
        do {
            printLocation(defeated);
            choice = saveGame.getScanner().nextLine();
            System.out.println(choice);
            switch (choice) {
                case "person":
                    correct = true;
                    if (defeated.noOneDefeated) {
                        qBattle.QFight(newPastor, lowTier.Q, defeated);
                    } //else if (defeated.martinDefeated) {
                    //} else if (defeated.kevinDefeated) {
                    break;
                case "left":
                    correct = false;
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "right":
                    correct = true;
                    entrance.activities(newPastor, defeated);
                    break;
                case "forward":
                    correct = true;
                    ballRoom.activities(newPastor, defeated);
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
