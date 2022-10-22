package org.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NameGenerator {
    private final ArrayList<String> lst;
    private static Random rnd;

    public NameGenerator(ArrayList<String> lst) {
        this.lst = lst;
        rnd = new Random();
    }

    public static NameGenerator createNameGeneratorWithoutInput() {

        try {
            rnd = new Random();
            int num = rnd.nextInt(2) + 1;

            File file = new File("src/main/java/org/day2/txt/Names" + num);
            Scanner sc = new Scanner(file);

            ArrayList<String> lst = new ArrayList<>();

            while (sc.hasNextLine())
                lst.add(sc.nextLine());

            return new NameGenerator(lst);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return null;
    }

    public static NameGenerator createFootballNameGeneratorWithoutInput() {

        try {
            File file = new File("src/main/java/org/day2/txt/FootballNames");

            Scanner sc = new Scanner(file);

            ArrayList<String> lst = new ArrayList<>();

            while (sc.hasNextLine())
                lst.add(sc.nextLine());

            return new NameGenerator(lst);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return null;
    }

    public String generateName() {
        int index = rnd.nextInt(lst.size());
        return lst.get(index);
    }
}
