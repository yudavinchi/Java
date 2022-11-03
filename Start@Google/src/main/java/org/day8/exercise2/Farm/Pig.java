package org.day8.exercise2.Farm;

public class Pig extends AbstractAnimal {

    public Pig(Gender gender, int id, double weight){
        this.gender = gender;
        this.id = id;
        this.weight = weight;
    }
    public void move(){
        System.out.println("Oink oink, pig has moved");
    }
}
