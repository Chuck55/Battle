package Characters;

import com.rpg.Monster;
import utility.ItemClass;
import utility.Potions;
import utility.Weapons;
public class LowTier {
    ItemClass itemClass = new ItemClass();
    // Lower Minions

    //Brit    75         9          5            4
    //Wendy   60         8          12           3
    //Q       70         7          7            5
    //Jay     60         9          12           2
    //Jessica 80         10         7            6

    private Monster Wendy = new Monster
            (
                    "Wendy",
                    150,
                    15,
                    5,
                    10,
                    "What do you mean??",
                    "Oof",
                    "Oops",
                    itemClass.getMiddlePotion()
            );
    private Monster Brittany = new Monster
            (
                    "Brittany",
                    75,
                    9,
                    5,
                    4,
                    "",
                    "",
                    "",
                    itemClass.getMiddlePotion()
            );
    private Monster Calvin = new Monster
            (
                    "Calvin",
                    75,
                    9,
                    5,
                    4,
                    "",
                    "",
                    "",
                    itemClass.getMiddlePotion()
            );
    private Monster Jessica = new Monster
            (
                    "Jessica",
                    80,
                    10,
                    7,
                    6,
                    "",
                    "",
                    "",
                    itemClass.getMiddlePotion()
            );
    private Monster Q = new Monster
            (
                    "Q",
                    70,
                    7,
                    7,
                    5,
                    "",
                    "",
                    "",
                    itemClass.getMiddlePotion()
            );
    private Monster Jay = new Monster
            (
                    "Brittany",
                    60,
                    9,
                    12,
                    2,
                    "",
                    "",
                    "",
                    itemClass.getMiddlePotion()
            );

    public Monster getWendy() {
        return Wendy;
    }

    public Monster getBrittany() {
        return Brittany;
    }

    public Monster getCalvin() {
        return Calvin;
    }

    public Monster getJessica() {
        return Jessica;
    }

    public Monster getQ() {
        return Q;
    }

    public Monster getJay() {
        return Jay;
    }
}
