package com.rpg;

import sun.applet.Main;

import java.util.Random;
import java.util.Scanner;

public class Battle {
    ParentVariable defeated = new ParentVariable();

    public void Monsterattack(MainCharacter newPastor, Monster mon) {
        int totalDamage = mon.getDamage();
        Random rand = new Random();
        int x = rand.nextInt(100);
        if (x < mon.getCritChance()) {
            totalDamage = totalDamage * 3;
        }
        System.out.println("You did " + totalDamage + " Amount of Damage");
        newPastor.setTotalHealth(newPastor.getTotalHealth() - totalDamage);
    }

    public void attack(MainCharacter newPastor, Monster mon) {
        int totalDamage = newPastor.getAttackDamage();
        Random rand = new Random();
        int x = rand.nextInt(100);
        if (x < newPastor.getCritChance()) {
            totalDamage = totalDamage * 3;
            totalDamage -= mon.getDefense();
            System.out.println("Wow! A Crit! You did " + totalDamage + " Amount of Damage");
        }
        System.out.println("You did " + totalDamage + " Amount of Damage");
        mon.setTotalHealth(mon.getTotalHealth() - totalDamage);
    }

    public void provideHealing(MainCharacter newPastor, Potions potion) {
        newPastor.setHealth(newPastor.getHealth() + potion.getHealing());
    }

    public boolean Basefight(MainCharacter newPastor, Monster monster) {
        int x;
        Scanner scanner = new Scanner(System.in);
        int monsterAttack = monster.getDamage();
        boolean VL1 = false;
        boolean VL2 = false;
        boolean VL3 = false;
        int monsterHealth = monster.getHealth();
        while (newPastor.getHealth() > 0 && monster.getHealth() > 0) {
            int totalHealth = monster.getTotalHealth();
            checkHealth(defeated, monster);
            System.out.println();
            choiceMove(newPastor, monster);
            if (totalHealth < monsterHealth / 3 && !VL3) {
                System.out.println(monster.getThirdVoiceLine());
                VL3 = true;
            } else if (totalHealth < monsterHealth * 2 / 3 && !VL2) {
                System.out.println(monster.getSecondVoiceLine());
                VL2 = true;
            } else if (totalHealth < monsterHealth && !VL1) {
                System.out.println(monster.getFirstVoiceLine());
                VL1 = true;
            }
            newPastor.setTotalHealth(newPastor.getTotalHealth() - monsterAttack);
            newPastor.setDefense(newPastor.getRealDefense());
            if (newPastor.getTotalHealth() <= 0) {
                defeated.kyleDefeated = false;
                break;
            }

            monsterAttack = monster.getDamage();
            printScores(newPastor, monster);
        }
        scanner.close();
        if (!defeated.kyleDefeated) {
            System.out.println("Monster");
        } else {
            System.out.println("Gained 50 EXP");
            newPastor.exp(50);
            System.out.println("oof");
        }
        return false;
    }

    public boolean DanielFight(MainCharacter newPastor, Monster monster) {
        Random rand = new Random();
        int monsterAttack = monster.getDamage();
        boolean VL1 = false;
        boolean VL2 = false;
        boolean VL3 = false;
        int monsterHealth = monster.getHealth();
        Scanner newScanner = new Scanner(System.in);
        printScores(newPastor, monster);
        while (newPastor.getHealth() > 0 && monster.getTotalHealth() > 0) {
            System.out.println();
            choiceMove(newPastor, monster);
            checkHealth(defeated, monster);
            int totalHealth = monster.getTotalHealth();
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
            System.out.println("Its my turn now!");
            int x = rand.nextInt(100);
            if (x < 25) {
                System.out.println("Wow, I hit a crit!");
                monsterAttack *= 3;
                monsterAttack -= newPastor.getDefense();
                System.out.println("Attack did " + monsterAttack + " damage");
            } else {
                System.out.print("Ummmm, just wait, imma get u ");
                System.out.println("-- Attack did zero damage");
                monsterAttack = 0;
            }
            newPastor.setTotalHealth(newPastor.getTotalHealth() - monsterAttack);
            newPastor.setDefense(newPastor.getRealDefense());
            if (newPastor.getTotalHealth() <= 0) {
                defeated.danielDefeated = false;
                break;
            }
            monsterAttack = monster.getDamage();
            printScores(newPastor, monster);
            System.out.println();
        }
        newScanner.close();
        if (!defeated.danielDefeated) {
            System.out.println("Daniel: Dang, i'm sorry dude, but you gotta train more");
        } else {
            System.out.println("Gained 50 EXP");
            newPastor.exp(50);
            System.out.println("Daniel: Dang..... I Guess i'm not strong enough.....");
        }
        return false;
    }

    public void printScores(MainCharacter newPastor, Monster monster) {
        System.out.println("Monster Health  " + monster.getTotalHealth());
        System.out.println("Your Health     " + newPastor.getTotalHealth());
        System.out.println();
    }

    public void checkHealth(ParentVariable defeated, Monster monster) {
        if (monster.getTotalHealth() <= 0) {
            defeated.danielDefeated = true;
        }
    }


    public int choiceMove(MainCharacter newPastor, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        int x = 5;
        int attackDamage = 0;
        System.out.println("Press 1 to attack, 2 to defend, 3 to equip new Weapon, 4 to heal ");
        int choice = scanner.nextInt();
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
                x = scanner.nextInt();
                System.out.println("Equipped " + newPastor.getBigBag().weaponItems.get(x).name);
                newPastor.equipWeapon(newPastor.getBigBag().weaponItems.get(x));
                break;
            case 4:
                newPastor.getBigBag().showPotions();
                break;
        }
        return attackDamage;
    }
}
