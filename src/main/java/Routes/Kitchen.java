package Routes;

import BattleStuff.QBattle;
import Characters.LowTier;
import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.IOException;

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
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws IOException {
        QBattle qBattle = new QBattle();
        LowTier lowTier = new LowTier();
        BallRoom ballRoom = new BallRoom();
        SaveGame saveGame = new SaveGame();
        Entrance entrance = new Entrance();
        String choice = "";
        do {
            printLocation(defeated);
            if(saveGame.getScanner().hasNextLine()) {
                choice = saveGame.getScanner().nextLine();
            }
            System.out.println(choice);
            switch (choice) {
                case "person":
                    if (defeated.noOneDefeated) {
                        qBattle.QFight(newPastor, lowTier.getQ(), defeated);
                    } //else if (defeated.martinDefeated) {
                    //} else if (defeated.kevinDefeated) {
                    break;
                case "left":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "right":
                    entrance.activities(newPastor, defeated);
                    break;
                case "forward":
                    ballRoom.activities(newPastor, defeated);
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
