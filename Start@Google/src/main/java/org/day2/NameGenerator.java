package org.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NameGenerator {
    private ArrayList<String> lst;
    private Random rnd;

    public NameGenerator(ArrayList<String> lst){
        this.lst = lst;
        rnd = new Random();
    }

    public String generateName(){
        int index = rnd.nextInt(lst.size());
        return lst.get(index);
    }

    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<>(Arrays.asList(
                "Avi", "Moshe", "Yossi", "Efi", "Roni", "Sarah", "Nicole", "Ben"));
        NameGenerator nameGenerator = new NameGenerator(lst);
        System.out.println(nameGenerator.generateName());
    }
}
