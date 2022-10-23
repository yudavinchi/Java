package org.day3.exercise2;

import org.day3.exercise3.Prefix;

import java.util.Random;

public enum AnimalType {
    PIG,
    COW,
    CHICKEN;

    public static AnimalType random(){
        return AnimalType.values()[new Random().nextInt(AnimalType.values().length)];
    }
}
