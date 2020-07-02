package Routes;

import BattleStuff.MartinBattle;
import Characters.Boss;
import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.io.FileNotFoundException;
import java.io.IOException;

public class YouthRoom implements BaseRoute {
    MartinBattle martinBattle = new MartinBattle();
    Boss boss = new Boss();
    @Override
    public void printLocation(ParentVariable defeated) {
        SaveGame saveGame = new SaveGame();
        System.out.println(" Currently you are in the Youth Room, what would would you like to do?");
        if (defeated.noOneDefeated) {
            if (!defeated.martinDefeated && defeated.calvinDefeated)
            {
                System.out.println(" Talk to Martin? Beware, this will result in a fight. ");
            }
            else if(!defeated.martinDefeated && !defeated.calvinDefeated)
            {
                System.out.println("Try to talk with figure at piano?");
            }
        } else if (defeated.martinDefeated) {
            System.out.println("Fight");
        } else if (defeated.kevinDefeated) {
            System.out.println("Fight");
        }
        System.out.println(" Right : Storage Room");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws IOException {
        SaveGame saveGame = new SaveGame();
        BallRoom ballRoom = new BallRoom();
        String choice = "   ";
        do {
            printLocation(defeated);
            if(saveGame.getScanner().hasNextLine()) {
                choice = saveGame.getScanner().nextLine();
            }
            System.out.println(choice);
            switch (choice) {
                case "person":
                    if (!defeated.martinDefeated && defeated.calvinDefeated)
                    {
                        saveGame.printOrder("MartinConversation.txt");
                        martinBattle.MartinFight(newPastor, boss.Martin , defeated);
                    }
                    else if(!defeated.martinDefeated && !defeated.calvinDefeated)
                    {
                        saveGame.printOrder("AttemptToTalk.txt");
                        defeated.talkedWithMartin = true;
                    }
                    break;
                case "left":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "right":
                    ballRoom.activities(newPastor, defeated);
                    break;
                case "forward":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "behind":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "save":
                    saveGame.print(newPastor,defeated);
                default:
                    System.out.println("Not a valid entry, Please reenter");
            }
        } while (true);
    }
}
