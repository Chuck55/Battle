package BattleStuff;

import com.rpg.MainCharacter;
import com.rpg.Monster;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;
import utility.Potions;

import java.util.Random;
import java.util.Scanner;

public class Battle implements BattleBase {
    private ParentVariable defeated = new ParentVariable();
    private boolean VL1;
    private boolean VL2;
    private boolean VL3;
    SaveGame saveGame = new SaveGame();

    public void monsterBattle(MainCharacter newPastor, Monster mon) {
        int totalDamage = mon.getDamage();
        Random rand = new Random();
        int x = rand.nextInt(100);
        if (x < mon.getCritChance()) {
            totalDamage = totalDamage * 3 - newPastor.getDefense();
        }
        System.out.println("Enemy did " + totalDamage + " Amount of Damage");
        newPastor.setTotalHealth(newPastor.getTotalHealth() - totalDamage);
    }

    public void attack(MainCharacter newPastor, Monster mon) {
        int totalDamage = newPastor.getAttackDamage();
        Random rand = new Random();
        int x = rand.nextInt(100);
        if (x < newPastor.getCritChance()) {
            totalDamage = totalDamage * 3;
            System.out.println("Wow! A Crit! You did " + totalDamage + " points of Damage");
        }
        totalDamage -= mon.getDefense();
        System.out.println("You did " + totalDamage + " points of Damage");
        mon.setTotalHealth(mon.getTotalHealth() - totalDamage);
    }

    public void provideHealing(MainCharacter newPastor, Potions potion) {
        int totalHealth = newPastor.getTotalHealth();
        int health = newPastor.getHealth();
        totalHealth = totalHealth + potion.getHealing();
        if (totalHealth > health) {
            newPastor.setTotalHealth(health);
        } else {
            newPastor.setTotalHealth(totalHealth);
        }
    }

    public boolean Basefight(MainCharacter newPastor, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        int monsterAttack = monster.getDamage();
        boolean VL1 = false;
        boolean VL2 = false;
        boolean VL3 = false;
        int monsterHealth = monster.getHealth();
        while (newPastor.getHealth() > 0 && monster.getHealth() > 0) {
            int totalHealth = monster.getTotalHealth();
            checkHealth(defeated, monster);
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
        Scanner newScanner = saveGame.getScanner();
        int attackDamage = 0;
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
}
