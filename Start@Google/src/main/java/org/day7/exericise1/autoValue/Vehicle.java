package org.day7.exericise1.autoValue;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Vehicle {
    public static Vehicle create(String type, int cost) {
        return new AutoValue_Vehicle(type, cost);
    }

    abstract String type();

    abstract int cost();
}
