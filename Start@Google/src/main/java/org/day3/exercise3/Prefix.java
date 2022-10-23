package org.day3.exercise3;

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
}
