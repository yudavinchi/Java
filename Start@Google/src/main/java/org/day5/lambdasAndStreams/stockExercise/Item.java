package org.day5.lambdasAndStreams.stockExercise;

import java.time.LocalDate;

public class Item implements Comparable<Item>{
    private final String name;
    private final Type type;
    private final LocalDate expiryDate;
    private final double weight;

    public Item(String name, Type type, LocalDate expiryDate, double weight){
        this.name = name;
        this.type = type;
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public String getName(){
        return new String(name);
    }

    public Type getType(){
        return type;
    }

    public LocalDate getExpiryDate(){
        return LocalDate.of(expiryDate.getYear(), expiryDate.getMonth(), expiryDate.getDayOfMonth());
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public int compareTo(Item item) {
        return expiryDate.compareTo(item.getExpiryDate());
    }
}
