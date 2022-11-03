package org.day8.exercise2.Farm;

import java.util.Random;

public enum AnimalType {
    PIG,
    COW,
    CHICKEN;

    public static AnimalType random(){
        return AnimalType.values()[new Random().nextInt(AnimalType.values().length)];
    }
}
