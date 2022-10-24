package org.day4.exercise3;

import org.day3.exercise3.Name;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;

/*
    Write a method:

    [V] - Gets an object
    [ ] - Checks if it has a constructor that accepts one string as a parameter.
    [ ] - if so, return a new instance of the class with a randomly generated string as the parameter.

    Test your method with at least two classes, one with a fitting constructor and one without.

 */

public class Main {

    public static void main(String[] args) {
        check(new String());
    }

    public static void check(Object object) {
    }

    public static Optional<Object> newInstance(Object o) {

        Class<?> cls = o.getClass();
        try {
            Constructor<?> constructor = cls.getConstructor(String.class);
            Object newObj = constructor.newInstance("Random String");
            return Optional.of(newObj);
        } catch (NoSuchMethodException e) {
            return Optional.empty();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to instantiate constructor", e);
        }
    }
}
