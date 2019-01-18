package Characters;

import com.rpg.Monster;
import utility.Potions;
import utility.Weapons;

public class LowTier {
   // Lower Minions

    //Brit    75         9          5            4
    //Wendy   60         8          12           3
    //Q       70         7          7            5
    //Jay     60         9          12           2
    //Jessica 80         10         7            6
    private Potions normalPotion = new Potions("normal Potion", 20);
    private Potions middlePotion = new Potions("Middle Potion", 30);
    Monster Wendy = new Monster
            (
                    "Wendy",
                    150,
                    15,
                    5,
                    10,
                    "What do you mean??",
                    "Oof",
                    "Oops",
                    normalPotion
            );
    Monster Brittany = new Monster
            (
                    "Brittany",
                    75,
                    9,
                    5,
                    4,
                    "",
                    "",
                    "",
                    middlePotion
            );
    Monster Jessica = new Monster
            (
                    "Jessica",
                    80,
                    10,
                    7,
                    6,
                    "",
                    "",
                    "",
                    middlePotion
            );
    public Monster Q = new Monster
            (
                    "Q",
                    70,
                    7,
                    7,
                    5,
                    "",
                    "",
                    "",
                    middlePotion
            );
    Monster Jay = new Monster
            (
                    "Brittany",
                    60,
                    9,
                    12,
                    2,
                    "",
                    "",
                    "",
                    middlePotion
            );

}
