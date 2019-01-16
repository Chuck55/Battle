package com.rpg;

import utility.Bag;
import utility.Weapons;

public class MainCharacter {
    String name;
    Weapons equippedWeapon;
    //Armor armor;
    private Bag bigBag = new Bag();
    private int health;
    private int totalHealth;
    private int level;
    private int defense;
    private int realDefense;
    private int exp;
    private int attackDamage;
    private int critChance;

    public MainCharacter(String name) {
        this.name = name;
        equippedWeapon = null;
        health = 30;
        totalHealth = 30;
        level = 1;
        defense = 5;
        realDefense = 5;
        exp = 0;
        defense = 3;
        attackDamage = 10;
        critChance = 5;
    }

    public void levelUp() {
        level++;
        health += 3;
        totalHealth += 2;
        defense += 2;
        realDefense += 1;
        attackDamage += 2;
        exp = exp - 100;
        System.out.println("WOW! LEVEL UP! You are now Level " + level);
        System.out.println("Health + 2 = " + health);
        System.out.println("Defense + 2 = " + defense);
        System.out.println("Damage + 2 = " + attackDamage);
        return;
    }

    public void exp(int givenExp) {
        exp += givenExp;
        while (exp >= 100) {
            levelUp();
        }
        return;
    }

    public void equipWeapon(Weapons weapon) {
        if (equippedWeapon != null) {
            bigBag.getWeaponItems().add(equippedWeapon);
            attackDamage = attackDamage - equippedWeapon.getAttackDamage() + weapon.getAttackDamage();
            critChance = critChance - equippedWeapon.getAddedCrit() + weapon.getAddedCrit();
            bigBag.getWeaponItems().remove(weapon);
        } else {
            attackDamage = attackDamage + weapon.getAttackDamage();
            critChance = critChance + weapon.getAddedCrit();
            bigBag.getWeaponItems().remove(weapon);
        }


    }

    public int getRealDefense() {
        return realDefense;
    }

    public void setRealDefense(int realDefense) {
        this.realDefense = realDefense;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = totalHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapons getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapons equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Bag getBigBag() {
        return bigBag;
    }

    public void setBigBag(Bag bigBag) {
        this.bigBag = bigBag;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
