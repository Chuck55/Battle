package com.rpg;

import utility.Bag;
import utility.KeyItem;
import utility.Potions;
import utility.Weapons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class SaveGame {
    private Map<Potions, Integer> consumableItems;
    ArrayList<Weapons> weaponItems;
    private Scanner potionScan;
    private PrintWriter potionPrint;
    Scanner readingScan;
    Scanner readIn = new Scanner(System.in);
    ClassLoader loader = SaveGame.class.getClassLoader();

    public SaveGame() {
        consumableItems = new HashMap<>();
        weaponItems = new ArrayList<>();

    }

    public void read(MainCharacter newPastor) throws FileNotFoundException {
        File file = new File("potions.txt");
        potionScan = new Scanner(file);
        String potionDescription = potionScan.nextLine();
        while (!potionDescription.equals("Weapons")) {
            String[] firstSplit = potionDescription.split("(?<=\\})|(?=\\{)");
            String name = firstSplit[0].substring(1, (firstSplit[0]).length() - 1);
            String[] splited = firstSplit[1].split("\\s+");
            System.out.println(name);
            int healing = Integer.parseInt(splited[1]);
            int count = Integer.parseInt(splited[2]);
            Potions potion = new Potions(name, healing);
            consumableItems.put(potion, count);
            potionDescription = potionScan.nextLine();
        }
        String weaponDescription = potionScan.nextLine();
        while (!weaponDescription.equals("Stats")) {
            String[] firstSplit = weaponDescription.split("(?<=\\})|(?=\\{)");
            String name = firstSplit[0].substring(1, (firstSplit[0]).length() - 1);
            String[] splited = firstSplit[1].split("\\s+");
            System.out.println(name);
            int power = Integer.parseInt(splited[1]);
            int crit = Integer.parseInt(splited[2]);
            Weapons weapon = new Weapons(name, power, crit);
            weaponItems.add(weapon);
            weaponDescription = potionScan.nextLine();
        }
        Bag bag = new Bag(consumableItems, weaponItems);
        newPastor.setBigBag(bag);
        String HeroDescription = potionScan.nextLine();
        while (!HeroDescription.equals("KeyItems")) {
            String[] splited = weaponDescription.split("\\s+");
            newPastor.setHealth(Integer.parseInt(splited[0]));
            newPastor.setTotalHealth(Integer.parseInt(splited[1]));
            newPastor.setLevel(Integer.parseInt(splited[2]));
            newPastor.setExp(Integer.parseInt(splited[3]));
            newPastor.setDefense(Integer.parseInt(splited[4]));
            newPastor.setAttackDamage(Integer.parseInt(splited[5]));
            HeroDescription = potionScan.nextLine();
        }
        ArrayList<KeyItem> keyItems = new ArrayList<>();
        int x = 0;
        while (potionScan.hasNextLine()) {
            KeyItem keyItem = new KeyItem(potionScan.nextLine());
            keyItems.add(keyItem);
            x++;
        }
        newPastor.getBigBag().setKeyItems(keyItems);
        potionScan.close();
    }

    public void print(MainCharacter newPastor) throws FileNotFoundException {
        File file = new File("potions.txt");
        potionPrint = new PrintWriter(file);
        Map<Potions, Integer> consumableItems = newPastor.getBigBag().getConsumableItems();
        ArrayList<Weapons> weaponItems = newPastor.getBigBag().getWeaponItems();
        ArrayList<KeyItem> keyItems = newPastor.getBigBag().getKeyItems();
        for (Potions key : consumableItems.keySet()) {
            potionPrint.print("{" + key.name + "}");
            potionPrint.print(" ");
            potionPrint.print(key.getHealing());
            potionPrint.print(" ");
            potionPrint.println(consumableItems.get(key));

        }
        potionPrint.println("Weapons");
        for (int x = 0; x < weaponItems.size(); x++) {
            potionPrint.print("{" + weaponItems.get(x).name + "}");
            potionPrint.print(" ");
            potionPrint.print(weaponItems.get(x).getAttackDamage());
            potionPrint.print(" ");
            potionPrint.println(weaponItems.get(x).getAddedCrit());
        }
        potionPrint.println("Stats");
        potionPrint.print(newPastor.getHealth());
        potionPrint.print(" ");
        potionPrint.print(newPastor.getTotalHealth());
        potionPrint.print(" ");
        potionPrint.print(newPastor.getLevel());
        potionPrint.print(" ");
        potionPrint.print(newPastor.getExp());
        potionPrint.print(" ");
        potionPrint.print(newPastor.getDefense());
        potionPrint.print(" ");
        potionPrint.println(newPastor.getAttackDamage());
        potionPrint.println("KeyItems");
        for (int x = 0; x < keyItems.size(); x++) {
            potionPrint.print("{" + newPastor.getBigBag().getKeyItems().get(x).getName() + "} ");
        }
        potionPrint.close();
    }

    public Scanner getScanner() {
        return readIn;
    }

    public void printOrder(String FileName) throws FileNotFoundException {
        File file = new File(FileName);
        System.out.println(file.getAbsolutePath());
        readingScan = new Scanner(file);
        // String filler = readingScan.nextLine();
        String spaceReader = "a";
        while (readingScan.hasNextLine() && !spaceReader.equals("wsejgklsnlk")) {
            String x = readingScan.nextLine();
            System.out.println(x);
            spaceReader = readIn.next();
        }
        readingScan.close();
        //readIn.close();
        return;
    }

}


