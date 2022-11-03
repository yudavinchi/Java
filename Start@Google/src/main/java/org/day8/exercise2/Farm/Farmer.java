package org.day8.exercise2.Farm;

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
