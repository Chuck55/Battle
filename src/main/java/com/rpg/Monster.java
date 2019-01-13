package com.rpg;

public class Monster {
    private int health;
    private int totalHealth;
    private int damage;
    private Items dropItem;
    private int defense;
    private int critChance;
    private String FirstVoiceLine;
    private String SecondVoiceLine;
    private String ThirdVoiceLine;

    public Monster(int health, int damage, int critChance, int defense, String FirstVoiceLine, String SecondVoiceLine, String ThirdVoiceLine, Items dropItem) {
        this.health = health;
        this.defense = defense;
        this.totalHealth = health;
        this.damage = damage;
        this.critChance = critChance;
        this.FirstVoiceLine = FirstVoiceLine;
        this.SecondVoiceLine = SecondVoiceLine;
        this.ThirdVoiceLine = ThirdVoiceLine;
        this.dropItem = dropItem;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = totalHealth;
    }

    public String getFirstVoiceLine() {
        return FirstVoiceLine;
    }

    public void setFirstVoiceLine(String firstVoiceLine) {
        FirstVoiceLine = firstVoiceLine;
    }

    public String getSecondVoiceLine() {
        return SecondVoiceLine;
    }

    public void setSecondVoiceLine(String secondVoiceLine) {
        SecondVoiceLine = secondVoiceLine;
    }

    public String getThirdVoiceLine() {
        return ThirdVoiceLine;
    }

    public void setThirdVoiceLine(String thirdVoiceLine) {
        ThirdVoiceLine = thirdVoiceLine;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Items getDropItem() {
        return dropItem;
    }

    public void setDropItem(Items dropItem) {
        this.dropItem = dropItem;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

}