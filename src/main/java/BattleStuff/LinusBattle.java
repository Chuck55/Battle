package BattleStuff;

import com.rpg.MainCharacter;
import com.rpg.Monster;
import com.rpg.ParentVariable;
import com.rpg.SaveGame;
import utility.Potions;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class LinusBattle implements BattleBase {
    private SaveGame saveGame;

    public LinusBattle() {
        saveGame = new SaveGame();
    }

    public boolean Linusfight(MainCharacter newPastor, Monster monster, ParentVariable defeated) {
        Scanner scanner = new Scanner(System.in);
        boolean VL1 = false;
        boolean VL2 = false;
        boolean VL3 = false;
        int monsterHealth = monster.getHealth();
        while (newPastor.getHealth() > 0 && monster.getHealth() > 0) {
            int totalHealth = monster.getTotalHealth();
            choiceMove(newPastor, monster);
            checkHealth(defeated, monster);
            if(defeated.linusDefeated)
            {
                System.out.println("Linus : Yes, I assure you, losing was all part of my master plan.....");
                System.out.println("Gained 50 EXP");
                newPastor.exp(50);
                return true;
            }
            printVoiceline(VL1, VL2, VL3, totalHealth, monster);
            LinusAttack(newPastor, monster);
            newPastor.setDefense(newPastor.getRealDefense());
            if (newPastor.getTotalHealth() <= 0) {
                defeated.linusDefeated = false;
                break;
            }
            printScores(newPastor, monster);
        }
        scanner.close();
        if (!defeated.linusDefeated) {
            System.out.println("Linus : HAHAHAHAHA, I TOLD YOU I REIGN SUPREME!");
            System.out.println("Narrator : You were defeated");
        }
        return false;
    }

    public void LinusAttack(MainCharacter newPastor, Monster mon) {
        int totalDamage = mon.getDamage() / mon.getTotalHealth() / mon.getHealth();
        Random rand = new Random();
        int x = rand.nextInt(100);
        if (x < mon.getCritChance()) {
            System.out.println("Linus : My power unleashed! (hits a crit!)");
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
            defeated.linusDefeated = true;
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

