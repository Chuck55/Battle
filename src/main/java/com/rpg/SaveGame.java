package com.rpg;

import utility.Bag;
import utility.KeyItem;
import utility.Potions;
import utility.Weapons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Boolean.parseBoolean;

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

    public void read(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException {
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
        System.out.println(HeroDescription);
        while (!HeroDescription.equals("KeyItems")) {
            String[] splited = HeroDescription.split("\\s+");
            System.out.println(splited.length);
            newPastor.setHealth(Integer.parseInt(splited[0]));
            newPastor.setTotalHealth(Integer.parseInt(splited[1]));
            newPastor.setLevel(Integer.parseInt(splited[2]));
            newPastor.setExp(Integer.parseInt(splited[3]));
            newPastor.setDefense(Integer.parseInt(splited[4]));
            newPastor.setAttackDamage(Integer.parseInt(splited[5]));
            newPastor.setGold(Integer.parseInt(splited[6]));
            HeroDescription = potionScan.nextLine();
        }
        ArrayList<KeyItem> keyItems = new ArrayList<>();
        String KeyItemsDescription = potionScan.nextLine();
        while (!KeyItemsDescription.equals("Defeated")) {
            KeyItem keyItem = new KeyItem(KeyItemsDescription.substring(1, (KeyItemsDescription).length() - 1));
            keyItems.add(keyItem);
            KeyItemsDescription = potionScan.nextLine();
        }
        newPastor.getBigBag().setKeyItems(keyItems);
        readVariables(potionScan, defeated);
        potionScan.close();
    }

    public void print(MainCharacter newPastor, ParentVariable defeated) throws FileNotFoundException {
        File file = new File("potions.txt");
        potionPrint = new PrintWriter(file);
        Map<Potions, Integer> consumableItems = newPastor.getBigBag().getConsumableItems();
        ArrayList<Weapons> weaponItems = newPastor.getBigBag().getWeaponItems();
        ArrayList<KeyItem> keyItems = newPastor.getBigBag().getKeyItems();
        for (Potions key : consumableItems.keySet()) {
            potionPrint.print("{" + key.getName() + "}");
            potionPrint.print(" ");
            potionPrint.print(key.getHealing());
            potionPrint.print(" ");
            potionPrint.println(consumableItems.get(key));

        }
        potionPrint.println("Weapons");
        for (int x = 0; x < weaponItems.size(); x++) {
            potionPrint.print("{" + weaponItems.get(x).getName() + "}");
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
        potionPrint.print(newPastor.getAttackDamage());
        potionPrint.print(" ");
        potionPrint.println(newPastor.getGold());
        potionPrint.println("KeyItems");
        for (int x = 0; x < keyItems.size(); x++) {
            potionPrint.println("{" + newPastor.getBigBag().getKeyItems().get(x).getName() + "} ");
        }
        potionPrint.print("\n");
        potionPrint.println("Defeated");
        printVariables(potionPrint, defeated);
        potionPrint.close();
    }

    public void printVariables(PrintWriter potionPrint, ParentVariable defeated)
    {
        potionPrint.println(defeated.noOneDefeated);
        potionPrint.println(defeated.gabeDefeated);
        potionPrint.println(defeated.kyleDefeated);
        potionPrint.println(defeated.orienDefeated);
        potionPrint.println(defeated.samuelDefeated);
        potionPrint.println(defeated.danielDefeated);
        potionPrint.println(defeated.linusDefeated);
        potionPrint.println(defeated.kevinDefeated);
        potionPrint.println(defeated.shawnDefeated);
        potionPrint.println(defeated.martinDefeated);
        potionPrint.println(defeated.qDefeated);
        potionPrint.println(defeated.andrewDefeated);
        potionPrint.println(defeated.melodyDefeated);
        potionPrint.println(defeated.jasonDefeated);
        potionPrint.println(defeated.jessicaDefeated);
        potionPrint.println(defeated.brittanyDefeated);
        potionPrint.println(defeated.jayDefeated);
        potionPrint.println(defeated.wendyDefeated);
        potionPrint.println(defeated.nathanDefeated);
        potionPrint.println(defeated.peterDefeated);
        potionPrint.println(defeated.ldanielDefeated);
        potionPrint.println(defeated.darrenDefeated);
        potionPrint.println(defeated.williamDefeated);
        potionPrint.println(defeated.davidDefeated);
        potionPrint.println(defeated.jonahDefeated);
        potionPrint.println(defeated.andyDefeated);
        potionPrint.println(defeated.emilyDefeated);
        potionPrint.println(defeated.sarahDefeated);
        potionPrint.println(defeated.doraDefeated);
        potionPrint.println(defeated.irisDefeated);
        potionPrint.println(defeated.hannahDefeated);
        potionPrint.println(defeated.sierraDefeated);
        potionPrint.println(defeated.aliceDefeated);
        potionPrint.println(defeated.doreenDefeated);
        potionPrint.println(defeated.shinzeDefeated);
        potionPrint.println(defeated.bshawnDefeated);
        potionPrint.println(defeated.talkedWithMartin);
        potionPrint.println(defeated.calvinDefeated);
        potionPrint.println(defeated.talkedWithJohn);
    }
    public void readVariables(Scanner potionScan, ParentVariable defeated)
    {
        //PARSE TO BOOLEAN
        defeated.noOneDefeated = parseBoolean(potionScan.nextLine());
        defeated.gabeDefeated = parseBoolean(potionScan.nextLine());
        defeated.kyleDefeated = parseBoolean(potionScan.nextLine());
        defeated.orienDefeated = parseBoolean(potionScan.nextLine());
        defeated.samuelDefeated = parseBoolean(potionScan.nextLine());
        defeated.danielDefeated = parseBoolean(potionScan.nextLine());
        defeated.linusDefeated = parseBoolean(potionScan.nextLine());
        defeated.kevinDefeated = parseBoolean(potionScan.nextLine());
        defeated.shawnDefeated = parseBoolean(potionScan.nextLine());
        defeated.martinDefeated = parseBoolean(potionScan.nextLine());
        defeated.qDefeated =    parseBoolean(potionScan.nextLine());
        defeated.andrewDefeated = parseBoolean(potionScan.nextLine());
        defeated.melodyDefeated = parseBoolean(potionScan.nextLine());
        defeated.jasonDefeated = parseBoolean(potionScan.nextLine());
        defeated.jessicaDefeated = parseBoolean(potionScan.nextLine());
        defeated.brittanyDefeated = parseBoolean(potionScan.nextLine());
        defeated.jayDefeated = parseBoolean(potionScan.nextLine());
        defeated.wendyDefeated = parseBoolean(potionScan.nextLine());
        defeated.nathanDefeated = parseBoolean(potionScan.nextLine());
        defeated.peterDefeated = parseBoolean(potionScan.nextLine());
        defeated.ldanielDefeated = parseBoolean(potionScan.nextLine());
        defeated.darrenDefeated = parseBoolean(potionScan.nextLine());
        defeated.williamDefeated = parseBoolean(potionScan.nextLine());
        defeated.davidDefeated = parseBoolean(potionScan.nextLine());
        defeated.jonahDefeated = parseBoolean(potionScan.nextLine());
        defeated.andyDefeated = parseBoolean(potionScan.nextLine());
        defeated.emilyDefeated = parseBoolean(potionScan.nextLine());
        defeated.sarahDefeated = parseBoolean(potionScan.nextLine());
        defeated.doraDefeated = parseBoolean(potionScan.nextLine());
        defeated.irisDefeated = parseBoolean(potionScan.nextLine());
        defeated.hannahDefeated = parseBoolean(potionScan.nextLine());
        defeated.sierraDefeated = parseBoolean(potionScan.nextLine());
        defeated.aliceDefeated = parseBoolean(potionScan.nextLine());
        defeated.doreenDefeated = parseBoolean(potionScan.nextLine());
        defeated.shinzeDefeated = parseBoolean(potionScan.nextLine());
        defeated.bshawnDefeated = parseBoolean(potionScan.nextLine());
        defeated.talkedWithMartin = parseBoolean(potionScan.nextLine());
        defeated.calvinDefeated = parseBoolean(potionScan.nextLine());
        defeated.talkedWithJohn = parseBoolean(potionScan.nextLine());

    }
    public Scanner getScanner() {
        return readIn;
    }

    public void printOrder(String FileName) throws IOException {
        File file = new File(FileName);
        //System.out.println(file.getAbsolutePath());
        readingScan = new Scanner(file);
        // String filler = readingScan.nextLine();
        int spaceReader = 0;
        while (readingScan.hasNextLine() && spaceReader != '.') {
            String x = readingScan.nextLine();
            System.out.print(x);
            spaceReader = System.in.read();
        }
        readingScan.close();
        //readIn.close();
        return;
    }

}


