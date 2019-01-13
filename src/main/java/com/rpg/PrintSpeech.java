package com.rpg;

import java.util.Scanner;

public class PrintSpeech {
    ClassLoader loader = PrintSpeech.class.getClassLoader();

    public void printOrder(String FileName) {
        System.out.println("Starting PrintOrder");
        String spaceReader = "\n";
        Scanner scanner = new Scanner("introduction.txt");
        Scanner readIn = new Scanner(System.in);
        while (scanner.hasNextLine() && spaceReader.equals("\n")) {
            System.out.println(scanner.nextLine());
            spaceReader = readIn.next();

        }
        scanner.close();
        readIn.close();
        return;
    }
}
