package org.day2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueJerseyNumber {

    private final int upperBoundJerseyShirt = 100;
    Set<Integer> jerseySet;
    Random rnd;

    public UniqueJerseyNumber(){
        jerseySet = new HashSet<>();
        rnd = new Random();
    }

    public int generateUniqueNumber(){

        int jerseyNum;

        do{
            jerseyNum = rnd.nextInt(upperBoundJerseyShirt);
        }
        while(!jerseySet.add(jerseyNum));

        return jerseyNum;
    }

    public static void main(String[] args) {
        UniqueJerseyNumber uniqueJerseyNumber = new UniqueJerseyNumber();

        System.out.println(uniqueJerseyNumber.generateUniqueNumber());
    }
}
