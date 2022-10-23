package org.day3.exercise2;

import org.utilities.UniqueIdGeneretor;

import java.util.ArrayList;
import java.util.Random;

public class Farm {
    ArrayList<Animal> farm;

    public Farm() {
        farm = new ArrayList<Animal>();
    }

    public void acquire() {

        UniqueIdGeneretor uniqueIdGeneretor = new UniqueIdGeneretor();
        Random rnd = new Random();

        switch (AnimalType.random()) {
            case PIG:
                Animal pig = new Pig(Gender.random(), uniqueIdGeneretor.generate(), rnd.nextInt(100));
                farm.add(pig);
                break;
            case COW:
                Animal cow = new Cow(Gender.random(), uniqueIdGeneretor.generate(), rnd.nextInt(200));
                farm.add(cow);
                break;
            case CHICKEN:
                Animal chicken = new Chicken(Gender.random(), uniqueIdGeneretor.generate(), rnd.nextInt(10));
                farm.add(chicken);
                break;
        }
    }

    public void mate(Animal animal1, Animal animal2) {

        Animal temp = animal1.mate(animal2);

        if(temp != null){
            farm.add(temp);
        }
    }

    public Animal provide(int id) {
        for (Animal animal: farm) {
            if(animal.getId() == id){
                farm.remove(animal);
                return animal;
            }
        }
        return null;
    }
}
