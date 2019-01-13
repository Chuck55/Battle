package com.rpg;

public class Weapons extends Items {
    int attackDamage;
    int addedCrit;

    public Weapons(String name, int damage, int addedCrit) {
        this.name = name;
        attackDamage = damage;
        this.addedCrit = addedCrit;
    }
}


