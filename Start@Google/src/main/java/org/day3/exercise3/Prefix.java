package org.day3.exercise3;

import java.util.Random;

public enum Prefix {
    Dr("Dr"),
    Mr("Mr"),
    Mrs("Mrs"),
    Ms("Ms"),
    Jr("Jr"),
    Sr("Sr");
    public final String label;

    private Prefix(String label) {
        this.label = label;
    }

    public static Prefix random(){
        return Prefix.values()[new Random().nextInt(Prefix.values().length)];
    }
}
