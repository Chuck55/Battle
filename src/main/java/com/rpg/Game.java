package com.rpg;


import java.io.FileNotFoundException;

public class Game {
    SaveGame saveGame = new SaveGame();
    Potions normalPotion = new Potions("normal Potion", 20);
    Weapons chopSticks = new Weapons("Pair of Chopsticks", 10, 0);
    Weapons AndrewBall = new Weapons("Andrew's Soccerball", 17, 7);
    Potions bowlOfRice = new Potions("Bowl of Rice", 30);
    Weapons LinusPhone = new Weapons("Linus's Phone", 10, 12);
    Potions middlePotion = new Potions("Middle Potion", 30);
    Weapons ShawnBall = new Weapons("Shawn's Soccerball", 12, 15);
    Weapons DanielTrack = new Weapons("Daniel's Finished Music Track", 18, 15);
    Monster Kyle = new Monster
            (
                    500,
                    30,
                    10,
                    10,
                    "Hey now..... What are you doing?",
                    "Whats the point? No one ever listens....",
                    "Are you really sure this will work? Something always goes wrong....",
                    bowlOfRice
            );
    Monster Gabe = new Monster
            (
                    450,
                    25,
                    8,
                    10,
                    "",
                    "",
                    "",
                    middlePotion
            );
    Monster Orien = new Monster
            (
                    500,
                    12,
                    5,
                    10,
                    "",
                    "",
                    "",
                    middlePotion
            );
    Monster Linus = new Monster
            (
                    700,
                    //20,
                    3,
                    1,
                    10,
                    "MHWAHAHAHAHA, YOU DARE FACE THE ALMIGHTY LINUS? PREPARE TO DIE",
                    "You expected me to feel that? You'll have to try harder than that",
                    "Don't Worry, its all according to my master plan....... I think...... BWAHAHAHAH......ha!",
                    LinusPhone
            );
    Monster Daniel = new Monster
            (
                    550,
                    12,
                    5,
                    10,
                    "Hmm, seems like you're pretty good. I'll have to get serious with this",
                    "Hey, Hey, Hey, That kind of hurt.",
                   "I should have trained harder for this" ,
                    middlePotion
            );
    Monster Samuel = new Monster
            (
                    600,
                    12,
                    5,
                    10,
                    "",
                    "",
                    "That almost hurt as much as the time I fell off the bed",
                    middlePotion
            );
    Monster Shawn = new Monster
            (
                    200,
                    15,
                    3,
                    10,
                    "Oh yeah",
                    "",
                    "",
                    ShawnBall
            );
    Monster Wendy = new Monster
            (
                    150,
                    15,
                    5,
                    10,
                    "What do you mean??",
                    "Oof",
                    "Oops",
                    normalPotion
            );
    Monster Andrew = new Monster
            (
                    200,
                    15,
                    2,
                    10,
                    "Oh Yeah",
                    "I don't really want to",
                    "Its boring",
                    AndrewBall
            );
    Monster Brittany = new Monster
            (
                    175,
                    12,
                    5,
                    10,
                    "",
                    "",
                    "",
                    middlePotion
            );

    public Game() throws FileNotFoundException {
    }

    public boolean story(MainCharacter newPastor) throws FileNotFoundException {
        saveGame.printOrder("introduction.txt");
        newPastor.getBigBag().consumableItems.put(normalPotion, 5);
        newPastor.getBigBag().weaponItems.add(chopSticks);
        Battle battle = new Battle();
        battle.DanielFight(newPastor, Daniel);
        //saveGame.print(newPastor);
        //Battle against GAbe
        return false;
    }
}
