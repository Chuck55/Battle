package Characters;

import com.rpg.Monster;
import utility.Potions;
import utility.Weapons;

public class HighMidTier {
    //HighMidtier Minions
    //Shawn   200        15          3            7
    //Andrew  200        16          2            9
    //William 250        15          2            8
    //Jonah   300        14          9            9
    //David   325        17          7            9
    private Weapons AndrewBall = new Weapons("Andrew's Soccerball", 17, 7);
    private Weapons ShawnBall = new Weapons("Shawn's Soccerball", 12, 15);
    Monster David = new Monster
            (
                    "David",
                    325,
                    17,
                    7,
                    9,
                    "",
                    "",
                    "",
                    null
            );
    Monster Jonah = new Monster
            (
                    "Jonah",
                    300,
                    14,
                    9,
                    9,
                    "",
                    "",
                    "",
                    null
            );
    Monster William = new Monster
            (
                    "William",
                    250,
                    15,
                    2,
                    8,
                    "",
                    "",
                    "",
                    null
            );
    Monster Shawn = new Monster
            (
                    "Shawn",
                    200,
                    12,
                    3,
                    5,
                    "Oh yeah",
                    "",
                    "",
                    ShawnBall
            );

    Monster Andrew = new Monster
            (
                    "Andrew",
                    200,
                    15,
                    2,
                    10,
                    "Oh Yeah",
                    "I don't really want to",
                    "Its boring",
                    AndrewBall
            );
}
