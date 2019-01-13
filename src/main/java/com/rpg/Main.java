package com.rpg;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Game game = new Game();
        SaveGame save = new SaveGame();
        MainCharacter mainCharacter = new MainCharacter("Bob");
        //       Potions middlePotion = new Potions("Middle Potion",30);
        //     Weapons ShawnBall = new Weapons("Shawn's Soccerball", 12, 15);
        //   mainCharacter.getBigBag().weaponItems.add(ShawnBall);
        // mainCharacter.getBigBag().consumableItems.put(middlePotion, 4);
        //save.print(mainCharacter);
       game.story(mainCharacter);
        // Display the string.
    }
}
