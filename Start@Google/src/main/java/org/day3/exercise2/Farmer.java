package org.day3.exercise2;

import java.util.ArrayList;

public class Farmer {
    public void moveAnimal(Animal animal){
        animal.move();
    }

    public void requestAnimal(int id, ArrayList<Animal> farm){
        for(Animal animal : farm){
            if(animal.getId() == id){
                farm.remove(animal);
            }
        }
    }
}
