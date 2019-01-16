package utility;


import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Bag {
    private Map<Potions, Integer> consumableItems;
    private ArrayList<Weapons> weaponItems;
    private ArrayList<KeyItem> keyItems;

    public Bag() {
        consumableItems = new HashMap<>();
        weaponItems = new ArrayList<>();
        keyItems = new ArrayList<>();
    }

    public Bag(Map<Potions, Integer> consumableItems, ArrayList<Weapons> weaponItems) {
        this.consumableItems = consumableItems;
        this.weaponItems = weaponItems;
    }

    public int obtainedWeapon(Weapons weapon) {
        if (weaponItems.contains(weapon)) {
            return weapon.getAttackDamage();
        } else {
            weaponItems.add(weapon);
            return 0;
        }
    }

    public int obtainedKeyItem(KeyItem keyItem) {
        keyItems.add(keyItem);
        return 0;
    }

    public void obtainedPotion(Potions potion, int count) {
        if (consumableItems.get(potion) == null) {
            consumableItems.put(potion, count);
        } else {
            consumableItems.put(potion, consumableItems.get(potion) + count);
        }
    }

    public void showWeapons() {
        System.out.println("  Name                    Attack Damage     AddedCrit");
        int x = 0;
        for (Weapons weaponItem : weaponItems) {
            System.out.println(x + " " + weaponItem.name + "       " + weaponItem.getAttackDamage() + "             " + weaponItem.getAddedCrit());
            x++;
        }
    }

    public void showPotions() {
        System.out.println("Name    Healing     Count");
        for (Potions key : consumableItems.keySet()) {
            System.out.println(key.name + "     " + key.getHealing() + "    " + consumableItems.get(key));
        }
    }

    public ArrayList<KeyItem> getKeyItems() {
        return keyItems;
    }

    public void setKeyItems(ArrayList<KeyItem> keyItems) {
        this.keyItems = keyItems;
    }

    public Map<Potions, Integer> getConsumableItems() {
        return consumableItems;
    }

    public void setConsumableItems(Map<Potions, Integer> consumableItems) {
        this.consumableItems = consumableItems;
    }

    public ArrayList<Weapons> getWeaponItems() {
        return weaponItems;
    }

    public void setWeaponItems(ArrayList<Weapons> weaponItems) {
        this.weaponItems = weaponItems;
    }
}
