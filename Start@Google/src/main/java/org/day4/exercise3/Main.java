package org.day4.exercise3;

import org.day3.exercise3.Name;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
    }
    // Assaf's example for exercise 3
    public static Optional<Object> newInstanceSingleString(Object o){
        Class<?> aClass = o.getClass();
        try {
            Constructor<?> constructor = aClass.getConstructor(String.class);
            Object newObject = constructor.newInstance("Random String");
            return Optional.of(newObject);
        } catch (NoSuchMethodException e) {
            return Optional.empty();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to instantiate constructor",e);
        }
    }
}
