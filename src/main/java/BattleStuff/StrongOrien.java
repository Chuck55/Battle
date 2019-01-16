package BattleStuff;

import com.rpg.MainCharacter;
import com.rpg.Monster;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;

import java.util.Random;
import java.util.Scanner;

public class StrongOrien implements BattleBase {
    private SaveGame saveGame;

    public StrongOrien() {
        saveGame = new SaveGame();
    }

    public boolean orienRealFight(MainCharacter newPastor, Monster monster, ParentVariable defeated) {
        Random rand = new Random();
        int monsterAttack;
        int monsterDefense = monster.getDefense();
        boolean VL1 = false;
        boolean VL2 = false;
        boolean VL3 = false;
        Scanner newScanner = saveGame.getScanner();
        int totalHealth;
        printScores(newPastor, monster);
        while (newPastor.getHealth() > 0 && monster.getTotalHealth() > 0) {
            choiceMove(newPastor, monster);
            checkHealth(defeated, monster);
            totalHealth = monster.getTotalHealth();
            printVoiceline(VL1, VL2, VL3, totalHealth, monster);
            monster.setDefense(monsterDefense);
            StrongOrienAttack(newPastor, monster);
            newPastor.setDefense(newPastor.getRealDefense());
            if (newPastor.getTotalHealth() <= 0) {
                defeated.orienDefeated = false;
                break;
            }
            printScores(newPastor, monster);
            System.out.println();
        }
        newScanner.close();
        if (!defeated.orienDefeated) {
            System.out.println("Gotta train harder man! Can't beat me yet!");
            return false;
        } else {
            System.out.println("Gained 50 EXP");
            newPastor.exp(50);
            System.out.println("");
            return true;
        }
    }

    public void StrongOrienAttack(MainCharacter newPastor, Monster monster) {
        Random rand = new Random();
        int monsterAttack = monster.getDamage();
        int x = rand.nextInt(100);
        if (x < 75) {
            System.out.println("I'm feeling pumped!! Lets go!");
            monster.setChangedDamage(monsterAttack * 2);
            monster.setDefense(monster.getDefense() * 2);
            System.out.println("-- Attack and defense greatly increased");
            System.out.println("Defense is : " + monster.getDefense());
        } else {
            monster.setChangedDamage(monsterAttack / 2);
            monster.setDefense(monster.getDefense() / 2);
            System.out.print("Im not really feeling it....");
            System.out.println("-- Attack and defense greatly decreased");
            System.out.println("Defense is : " + monster.getDefense());
        }
        x = rand.nextInt(100);
        if (x < monster.getCritChance()) {
            monster.setChangedDamage(monster.getChangedDamage() * 3);
        }
        monster.setChangedDamage(monster.getChangedDamage() - newPastor.getDefense());
        if (monster.getChangedDamage() <= 0) {
            monster.setChangedDamage(0);
        }
        System.out.println("Enemy did " + monster.getChangedDamage() + " Amount of Damage");
        newPastor.setTotalHealth(newPastor.getTotalHealth() - monster.getChangedDamage());
    }

    @Override
    public void printVoiceline(boolean VL1, boolean VL2, boolean VL3, int totalHealth, Monster monster) {
        int monsterHealth = monster.getHealth();
        if (totalHealth < monsterHealth / 3 && !VL3) {
            System.out.println(monster.getThirdVoiceLine());
            VL3 = true;
            VL2 = true;
            VL1 = true;
            monster.setDamage(monster.getDamage() + 2);
            monster.setDefense(monster.getDefense() + 2);
            System.out.println("Enemy's attack and defense increased");
        } else if (totalHealth < monsterHealth * 2 / 3 && !VL2) {
            System.out.println(monster.getSecondVoiceLine());
            VL2 = true;
            VL1 = true;
            monster.setDamage(monster.getDamage() + 2);
            monster.setDefense(monster.getDefense() + 2);
            System.out.println("Enemy's attack and defense increased");
        } else if (totalHealth < monsterHealth && !VL1) {
            System.out.println(monster.getFirstVoiceLine());
            VL1 = true;
            monster.setDamage(monster.getDamage() + 2);
            monster.setDefense(monster.getDefense() + 2);
            System.out.println("Enemy's attack and defense increased");
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
        Scanner newScanner = saveGame.getScanner();
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
                    int x = newScanner.nextInt();
                    System.out.println("Equipped " + newPastor.getBigBag().getWeaponItems().get(x).name);
                    newPastor.equipWeapon(newPastor.getBigBag().getWeaponItems().get(x));
                    break;
                case 4:
                    newPastor.getBigBag().showPotions();
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
