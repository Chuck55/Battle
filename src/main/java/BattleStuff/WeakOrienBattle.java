package BattleStuff;

import com.rpg.MainCharacter;
import com.rpg.Monster;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;
import utility.Potions;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class WeakOrienBattle implements BattleBase {
    private SaveGame saveGame;

    public WeakOrienBattle() {
        saveGame = new SaveGame();
    }

    public boolean startingOrienFight(MainCharacter newPastor, Monster monster, ParentVariable defeated) {
        printScores(newPastor, monster);
        int counter = 0;
        while (newPastor.getHealth() > 0 && monster.getTotalHealth() > 0) {
            System.out.println();
            switch (counter) {
                case 0:
                    System.out.println("Orien : See that button called 1? That allows you to attack your opponent. Give it a try, don't worry, my abs are hard as rock");
                    counter++;
                    break;
                case 1:
                    System.out.println("Orien : See that button called 2? That allows you to defend. You will gain half of your defense when you press it, so it is very useful for defending. ");
                    counter++;
                    break;
                case 2:
                    System.out.println("Orien : Now, you can also equip a weapon during battle. Just press the button 3 and press the number by the item you want to equip. You have a pair of chopsticks right? Try it out! (BTW, this is the same for potions)");
                    counter++;
                    break;
                case 3:
                    System.out.println("Orien : Good job! The last thing I have to teach you is that after you beat people, you gain EXP and bible dollars. So to get stronger, beat up more people. Hehehe");
                    counter++;
                    break;
            }
            choiceMove(newPastor, monster);
            checkHealth(defeated, monster);
            if(defeated.orienDefeated)
            {
                System.out.println("Orien : Nice job, You have the eyes of a legend");
                System.out.println("Gained 50 EXP");
                newPastor.exp(50);
                return true;

            }
            System.out.println("Its my turn now!");

            newPastor.setDefense(newPastor.getRealDefense());
            if (newPastor.getTotalHealth() <= 0) {
                defeated.orienDefeated = false;
                break;
            }
            monsterBattle(newPastor, monster);
            printScores(newPastor, monster);
            System.out.println();
        }
        if (!defeated.orienDefeated) {
            System.out.println("Orien : Wow, you really suc, don't you");
            System.out.println("Narrator : You were defeated");
        }
        return false;
    }

    public void monsterBattle(MainCharacter newPastor, Monster mon) {
        int totalDamage = mon.getDamage();
        Random rand = new Random();
        int x = rand.nextInt(100);
        if (x < mon.getCritChance()) {
            System.out.println("The opponent crit!");
            totalDamage = totalDamage * 3;
        }
        totalDamage -= newPastor.getDefense();
        if (totalDamage <= 0) {
            totalDamage = 0;
        }
        System.out.println("Enemy did " + totalDamage + " Points of Damage");
        newPastor.setTotalHealth(newPastor.getTotalHealth() - totalDamage);
    }

    @Override
    public void printVoiceline(boolean VL1, boolean VL2, boolean VL3, int totalHealth, Monster monster) {
        int monsterHealth = monster.getHealth();
        if (totalHealth < monsterHealth / 3 && !VL3) {
            System.out.println(monster.getThirdVoiceLine());
            VL3 = true;
            VL2 = true;
            VL1 = true;
        } else if (totalHealth < monsterHealth * 2 / 3 && !VL2) {
            System.out.println(monster.getSecondVoiceLine());
            VL2 = true;
            VL1 = true;
        } else if (totalHealth < monsterHealth && !VL1) {
            System.out.println(monster.getFirstVoiceLine());
            VL1 = true;
        }
    }

    @Override
    public void printScores(MainCharacter newPastor, Monster monster) {
        System.out.println("Monster Health  " + monster.getTotalHealth());
        System.out.println("Your Health     " + newPastor.getTotalHealth());
        System.out.println();
    }

    @Override
    public void checkHealth(ParentVariable defeated, Monster monster) {
        if (monster.getTotalHealth() <= 0) {
            defeated.orienDefeated = true;
        }
    }

    @Override
    public void choiceMove(MainCharacter newPastor, Monster monster) {
        int choice = 5;
        while (choice > 4) {
            System.out.println("Press 1 to attack, 2 to defend, 3 to equip new Weapon, 4 to heal ");
            choice = saveGame.getScanner().nextInt();
            switch (choice) {
                case 1:
                    printScores(newPastor, monster);
                    attack(newPastor, monster);
                    break;
                case 2:
                    System.out.println("You gained 10 defense for the turn");
                    newPastor.setDefense(newPastor.getRealDefense() + 10);
                    break;
                case 3:
                    newPastor.getBigBag().showWeapons();
                    //  newPastor.equipWeapon();
                    int x = saveGame.getScanner().nextInt();
                    System.out.println("Equipped " + newPastor.getBigBag().getWeaponItems().get(x).getName());
                    newPastor.equipWeapon(newPastor.getBigBag().getWeaponItems().get(x));
                    break;
                case 4:
                    newPastor.getBigBag().showPotions();
                    x = saveGame.getScanner().nextInt();
                    Map<Potions, Integer> potions = newPastor.getBigBag().getConsumableItems();
                    int count = 0;
                    for (Potions key : potions.keySet()) {
                        if (count == x && potions.get(key) > 0) {
                            newPastor.setTotalHealth(key.getHealing() + newPastor.getTotalHealth());
                            System.out.println("You recovered " + key.getHealing() + " Points of health");
                            if (newPastor.getTotalHealth() > newPastor.getHealth()) {
                                newPastor.setTotalHealth(newPastor.getHealth());
                            }
                            potions.put(key, potions.get(key) - 1);
                            if (potions.get(key) <= 0) {
                                potions.remove(key);
                            }
                            break;
                        } else {
                            count++;
                        }
                    }
                    break;
                default:
                    System.out.println("Please enter a viable option");
            }
        }
    }

    @Override
    public void attack(MainCharacter newPastor, Monster mon) {
        int totalDamage = newPastor.getAttackDamage();
        Random rand = new Random();
        int x = rand.nextInt(100);
        if (x < newPastor.getCritChance()) {
            totalDamage = totalDamage * 3;
            System.out.println("Wow! A Crit! You did " + totalDamage + " points of Damage");
        }
        totalDamage -= mon.getDefense();
        if (totalDamage <= 0) {
            totalDamage = 0;
        }
        System.out.println("You did " + totalDamage + " points of Damage");
        mon.setTotalHealth(mon.getTotalHealth() - totalDamage);
    }
}
