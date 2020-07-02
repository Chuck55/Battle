package Characters;

import com.rpg.Monster;
import utility.ItemClass;

public class Boss {
ItemClass itemClass = new ItemClass();

    public Monster Kyle = new Monster
            (
                    "Kyle",
                    500,
                    30,
                    10,
                    10,
                    "Kyle : Hey now..... That's not very nice you know....",
                    "Kyle : Haaaaa..... Looks like I'll have to get serious now....",
                    "Kyle : Frick..... I'm losing....",
                    itemClass.getBowlOfRice()
            );
    public Monster Gabe = new Monster
            (
                    "Gabe",
                    700,
                    10,
                    5,
                    25,
                    "*Yawn*, oh, are we starting?",
                    "I'm kind of sleepy, can you come back later?",
                    "Gabe : Welp, looks like i'm losing, better put more effort...",
                    itemClass.getMiddlePotion()
            );

    public Monster Martin = new Monster
            (
                    "Martin",
                    200,
                    20,
                    12,
                    10,
                    "Martin : You will see my POWER!",
                    "Martin : Time to go a bit harder I see!",
                    "Martin : I'm losing?...... NO!!! MORE POWER!",
                    itemClass.getMiddlePotion()
            );

    public Monster Orien = new Monster
            (
                    "Orien",
                    500,
                    15,
                    5,
                    12,
                    "That barely hurt!",
                    "Na dude, i'm just warming up!",
                    "It's cuz you got that 34 ACT",
                    itemClass.getMiddlePotion()
            );
    public Monster weakOrien = new Monster
            (
                    "Orien",
                    24,
                    11,
                    1,
                    3,
                    "",
                    "",
                    "",
                    itemClass.getKeyToCloset()
            );
    Monster Linus = new Monster
            (
                    "Linus",
                    700,
                    //20,
                    15,
                    1,
                    14,
                    "MHWAHAHAHAHA, YOU DARE FACE THE ALMIGHTY LINUS? PREPARE TO DIE",
                    "You expected me to feel that? You'll have to try harder than that",
                    "Don't Worry, its all according to my master plan....... I think...... BWAHAHAHAH......ha!",
                    itemClass.getLinusPhone()
            );
    Monster Daniel = new Monster
            (
                    "Daniel",
                    550,
                    12,
                    5,
                    10,
                    "Hmm, seems like you're pretty good. I'll have to get serious with this",
                    "Hey, Hey, Hey, That kind of hurt.",
                    "I should have trained harder for this",
                    itemClass.getDanielTrack()
            );
    Monster Samuel = new Monster
            (
                    "Samuel",
                    600,
                    12,
                    5,
                    10,
                    "That almost hurt as much as the time I fell off the bed",
                    "",
                    "Don't worry about it, I got this!",
                    itemClass.getMiddlePotion()
            );

}
