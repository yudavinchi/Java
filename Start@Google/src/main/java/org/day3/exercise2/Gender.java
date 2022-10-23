package org.day3.exercise2;

import org.day3.exercise3.Prefix;

import java.util.Random;

public enum Gender {
    Male,
    Female;

    public static Gender random(){
        return Gender.values()[new Random().nextInt(Gender.values().length)];
    }
}
