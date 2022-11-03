package org.day8.exercise2.Farm;

public class Chicken extends AbstractAnimal {

    public Chicken(Gender gender, int id, double weight){
        this.gender = gender;
        this.id = id;
        this.weight = weight;
    }

    public void move(){
        System.out.println("Koo-koo-ri-koo, chicken has moved");
    }
}