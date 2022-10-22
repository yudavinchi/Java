package org.day2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueJerseyNumberGenerator {

    Set<Integer> jerseySet;
    Random rnd;

    public UniqueJerseyNumberGenerator() {
        jerseySet = new HashSet<>();
        rnd = new Random();
    }

    public int generate() {

        int jerseyNum, upperBoundJerseyShirt = 100;

        do {

            jerseyNum = rnd.nextInt(upperBoundJerseyShirt);
        }
        while (!jerseySet.add(jerseyNum));

        return jerseyNum;
    }
}
