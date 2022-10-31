package org.day7.exericise1.autoValue;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Person {
    public static Person create(int id, String name) {
        return new AutoValue_Person(id, name);
    }

    abstract int id();

    abstract String name();
}