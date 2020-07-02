package utility;

import java.util.ArrayList;

public class ItemClass {
    private final Potions normalPotion = new Potions("normal Potion", 20);
    private final Potions middlePotion = new Potions("Middle Potion", 30);
    private final Potions bowlOfRice = new Potions("Bowl of Rice", 30);
    private final Potions riceSoup = new Potions("Rice Soup", 20);
    private final Weapons LinusPhone = new Weapons("Linus's Phone", 10, 12);
    private final Weapons DanielTrack = new Weapons("Daniel's Finished Music Track", 18, 15);
    private final Weapons hockeyStick = new Weapons("Hockey Stick", 17, 10);
    private final Weapons littleErasers = new Weapons("Little Erasers", 3, 11);
    private final Weapons hymnBook = new Weapons("Hymn Book", 13, -2);
    private final Weapons pamphlet = new Weapons("Church Bulletin", 1, 1);
    private final Weapons propSword = new Weapons("Prop Sword", 14, 12);
    private final KeyItem keyToCloset = new KeyItem("Mysterious Key");
    private final Weapons tableLeg = new Weapons("Table Leg", 14,3);
    private ArrayList<Weapons> shop = new ArrayList<>();

    public ArrayList<Weapons> getShop() {
        return shop;
    }

    public void setShop(ArrayList<Weapons> shop) {
        this.shop = shop;
    }

    public Potions getRiceSoup() {
        return riceSoup;
    }

    public Weapons getHockeyStick() {
        return hockeyStick;
    }

    public Weapons getLittleErasers() {
        return littleErasers;
    }

    public Weapons getHymnBook() {
        return hymnBook;
    }

    public Weapons getPamphlet() {
        return pamphlet;
    }

    public Weapons getPropSword() {
        return propSword;
    }

    public Weapons getTableLeg() {
        return tableLeg;
    }

    public Potions getNormalPotion() {
        return normalPotion;
    }

    public Potions getMiddlePotion() {
        return middlePotion;
    }

    public Potions getBowlOfRice() {
        return bowlOfRice;
    }

    public Weapons getLinusPhone() {
        return LinusPhone;
    }

    public Weapons getDanielTrack() {
        return DanielTrack;
    }

    public KeyItem getKeyToCloset() {
        return keyToCloset;
    }
}
