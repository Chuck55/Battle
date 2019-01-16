package com.rpg;


import BattleStuff.Battle;
import BattleStuff.DanielBattle;
import BattleStuff.StrongOrien;
import BattleStuff.WeakOrienBattle;
import Routes.Entrance;
import utility.KeyItem;
import utility.Potions;
import utility.Weapons;

import java.io.FileNotFoundException;

class Game {
    private Potions normalPotion = new Potions("normal Potion", 20);
    private Weapons chopSticks = new Weapons("Pair of Chopsticks", 10, 0);
    private Potions bowlOfRice = new Potions("Bowl of Rice", 30);
    private Weapons LinusPhone = new Weapons("Linus's Phone", 10, 12);
    private Potions middlePotion = new Potions("Middle Potion", 30);
    Weapons DanielTrack = new Weapons("Daniel's Finished Music Track", 18, 15);
    private KeyItem keyToCloset = new KeyItem("Mysterious Key");
    Monster Kyle = new Monster
            (
                    "Kyle",
                    500,
                    30,
                    10,
                    10,
                    "Kyle : Hey now..... That's not very nice you know....",
                    "Kyle : Haaaaa..... Looks like I'll have to get serious now....",
                    "Kyle : Frick..... I'm losing....",
                    bowlOfRice
            );
    Monster Gabe = new Monster
            (
                    "Gabe",
                    700,
                    10,
                    5,
                    25,
                    "*Yawn*, oh, are we starting?",
                    "I'm kind of sleepy, can you come back later?",
                    "Gabe : Welp, looks like i'm losing, better put more effort...",
                    middlePotion
            );
    Monster Orien = new Monster
            (
                    "Orien",
                    500,
                    15,
                    5,
                    12,
                    "That barely hurt!",
                    "Na dude, i'm just warming up!",
                    "It's cuz you got that 34 ACT",
                    middlePotion
            );
    Monster weakOrien = new Monster
            (
                    "Orien",
                    24,
                    11,
                    1,
                    3,
                    "",
                    "",
                    "",
                    keyToCloset
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
                    LinusPhone
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
                    DanielTrack
            );
    Monster Samuel = new Monster
            (
                    "Samuel",
                    600,
                    12,
                    5,
                    10,
                    "",
                    "",
                    "That almost hurt as much as the time I fell off the bed",
                    middlePotion
            );

    private SaveGame saveGame = new SaveGame();
    private ParentVariable defeated = new ParentVariable();
    Battle battle = new Battle();
    WeakOrienBattle wBattle = new WeakOrienBattle();
    Entrance entrance = new Entrance();

    public Game() {
        //secondFloor = new Location(null, "Upstairs", null, null, null, null);
        //parkingLot = new Location(null, "Parking Lot", null, null, null, entrance);
        // kitchen = new Location(null, "Kitchen", entrance, null, null, ballRoom);
        //entrance = new Location(null, "Entrance", kitchen, secondFloor, parkingLot, null);
        //ballRoom = new Location(null, "BallRoom", outside, childrenRoom, kitchen, storageRoom);
        //storageRoom = new Location(null, "Storage Room", youthRoom, secondFloor, ballRoom, null);
        //youthRoom = new Location(null, "Youth Room", null, storageRoom, null, null);
        //outside = new Location(null, "Outside", null, null, ballRoom, null);
        //childrenRoom = new Location(null, "Children's Classroom", ballRoom, null, null, nursery);
        //nursery = new Location(null, "Nursery", ballRoom, null, childrenRoom, null);
    }

    void story(MainCharacter newPastor) throws FileNotFoundException {
        defeated.noOneDefeated = true;
        DanielBattle danielBattle = new DanielBattle();
        StrongOrien strongOrien = new StrongOrien();
        saveGame.printOrder("RichardIntro.txt");
        newPastor.getBigBag().obtainedPotion(normalPotion, 5);
        newPastor.getBigBag().obtainedWeapon(chopSticks);
        // saveGame.printOrder("meetOrien.txt");
        wBattle.startingOrienFight(newPastor, weakOrien, defeated);
        newPastor.getBigBag().obtainedKeyItem(keyToCloset);
        //saveGame.printOrder("defeatedOrien.txt");
        entrance.activities(newPastor, defeated);
        //strongOrien.orienRealFight(newPastor, Daniel, defeated);
        saveGame.print(newPastor);
        //Battle against GAbe

    }


}
