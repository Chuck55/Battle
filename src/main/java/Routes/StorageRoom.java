package Routes;

import com.rpg.MainCharacter;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;
import utility.ItemClass;
import utility.Items;
import utility.Weapons;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StorageRoom implements BaseRoute{
    private SaveGame saveGame = new SaveGame();
    private ItemClass itemClass = new ItemClass();

    @Override
    public void printLocation(ParentVariable defeated) {
        System.out.println(" Currently you are in the Storage Room, what would would you like to do?");
        System.out.println(" Buy    :  Buy Items");
        System.out.println(" Left   : Youth Room");
        System.out.println(" Right  : UpStairs");
        System.out.println(" Behind :  BallRoom");
    }

    @Override
    public void activities(MainCharacter newPastor, ParentVariable defeated) throws IOException {
        BallRoom ballRoom = new BallRoom();
        YouthRoom youthRoom = new YouthRoom();
        String choice = "   ";
        do {
            printLocation(defeated);
            if(saveGame.getScanner().hasNextLine()) {
                choice = saveGame.getScanner().nextLine();
            }
            System.out.println(choice);
            int chooseItem = 10000;
            int shopCounter = 1;
            switch (choice) {
                case "buy":
                    System.out.println("Hello, i'm the store keeper, what would you like to buy?");
                    System.out.println("Enter the number by the item");
                    for (Items x : itemClass.getShop()) {
                        System.out.println(shopCounter + "    " + x.getName());
                        shopCounter++;
                    }
                    while(itemClass.getShop().size() < chooseItem && chooseItem != 0)
                    {
                        System.out.println("Please select what item you want to purchase, enter 0 to exit");
                        chooseItem = saveGame.getScanner().nextInt();
                    }
                    if(chooseItem > 0)//&& itemClass.getShop().get(chooseItem -1) < newPastor.getGold() )
                    {
                        Weapons bought = itemClass.getShop().get(chooseItem-1);
                        newPastor.getBigBag().obtainedWeapon(bought);
                        itemClass.getShop().remove(chooseItem-1);
                        itemClass.setShop(itemClass.getShop());
                        System.out.println(bought.getName() + " was just removed from the shop");
                        newPastor.setGold(newPastor.getGold());//- bought.gold);
                    }
                    System.out.println("Thanks for coming, See you next time!");
                    break;
                case "left":
                    youthRoom.activities(newPastor, defeated);
                    break;
                case "right":
                    break;
                case "forward":
                    System.out.println("Not a valid entry, Please reenter");
                    break;
                case "behind":
                    ballRoom.activities(newPastor, defeated);
                    break;
                case "save" :
                    saveGame.print(newPastor,defeated);
                default:
                    System.out.println("Not a valid entry, Please reenter");
            }
        } while (true);
    }
}
