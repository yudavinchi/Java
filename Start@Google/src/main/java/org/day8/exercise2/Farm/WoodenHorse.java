package org.day8.exercise2.Farm;

import java.util.UUID;

public class
WoodenHorse implements WoodenStructures {

    UUID uniqueKey = UUID.randomUUID();

    public void roll() {
        System.out.println("The wooden horse rolls...");
    }

    @Override
    public WoodenStructures replicate() {
        return new WoodenHorse();
    }

    public UUID getUniqueId() {
        return uniqueKey;
    }
}
