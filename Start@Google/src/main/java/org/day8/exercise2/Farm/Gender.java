package org.day8.exercise2.Farm;

import java.util.Random;

public enum Gender {
    Male,
    Female;

    public static Gender random(){
        return Gender.values()[new Random().nextInt(Gender.values().length)];
    }
}
