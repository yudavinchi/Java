package org.day2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueJerseyNumberGenerator {

    private final int upperBoundJerseyShirt = 100;
    Set<Integer> jerseySet;
    Random rnd;

    public UniqueJerseyNumberGenerator(){
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
        UniqueJerseyNumberGenerator uniqueJerseyNumber = new UniqueJerseyNumberGenerator();

        System.out.println(uniqueJerseyNumber.generateUniqueNumber());
    }
}
