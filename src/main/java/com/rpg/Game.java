package com.rpg;


import BattleStuff.*;
import Characters.Boss;
import Characters.HighTier;
import Characters.LowTier;
import Routes.Entrance;
import utility.KeyItem;
import utility.Potions;
import utility.Weapons;

import java.io.FileNotFoundException;
import java.io.IOException;

class Game {
    private Potions normalPotion = new Potions("normal Potion", 20);
    private Weapons chopSticks = new Weapons("Pair of Chopsticks", 10, 0);
    private KeyItem keyToCloset = new KeyItem("Mysterious Key");
    private SaveGame saveGame = new SaveGame();
    LowTier low = new LowTier();
    private ParentVariable defeated = new ParentVariable();
    Battle battle = new Battle();
    Boss boss = new Boss();
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

    void story(MainCharacter newPastor) throws IOException {
        defeated.noOneDefeated = true;
       // saveGame.printOrder("RichardIntro.txt");
       //newPastor.getBigBag().obtainedPotion(normalPotion, 5);
       //newPastor.getBigBag().obtainedWeapon(chopSticks);
       //saveGame.printOrder("meetOrien.txt");
      //wBattle.startingOrienFight(newPastor, boss.weakOrien, defeated);
        //newPastor.getBigBag().obtainedKeyItem(keyToCloset);
        //saveGame.printOrder("defeatedOrien.txt");
        entrance.activities(newPastor, defeated);
        saveGame.print(newPastor, defeated);
        //Battle against GAbe
       //PeterBattle peter = new PeterBattle();
        //peter.Peterfight(newPastor, low.getCalvin(), defeated);
    }


}
