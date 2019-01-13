package com.rpg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static sun.misc.Version.println;

public class Bag {
    Map<Potions, Integer> consumableItems;
    ArrayList<Weapons> weaponItems;

    public Bag() {
        consumableItems = new HashMap<>();
        weaponItems = new ArrayList<Weapons>();
    }
    public Bag(Map<Potions, Integer> consumableItems, ArrayList<Weapons> weaponItems)
    {
        this.consumableItems = consumableItems;
        this.weaponItems = weaponItems;
    }

    public int obtainedWeapon(Weapons weapon) {
        if (weaponItems.contains(weapon)) {
            return weapon.attackDamage;
        } else {
            weaponItems.add(weapon);
            return 0;
        }
    }

    public void obtainedPotion(Potions potion, int count) {
        if (consumableItems.get(potion) == null) {
            consumableItems.put(potion, count);
        } else {
            consumableItems.put(potion, consumableItems.get(potion) + count);
        }
    }

    public void showWeapons() {
        System.out.println("Name                    Attack Damage     AddedCrit");
        for (int x = 0; x < weaponItems.size(); x++) {
            System.out.println(weaponItems.get(x).name + "       " + weaponItems.get(x).attackDamage + "             " + weaponItems.get(x).addedCrit);
        }
    }

    public void showPotions() {
        System.out.println("Name    Healing     Count");
        for (Potions key : consumableItems.keySet()) {
            System.out.println(key.name + "     " + key.getHealing() + "    " + consumableItems.get(key));
        }
    }
}
