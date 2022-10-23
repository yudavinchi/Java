package org.day3.exercise2;

public class Cow extends AbstractAnimal{

    public Cow(Gender gender, int id, double weight){
        this.gender = gender;
        this.id = id;
        this.weight = weight;
    }

    public void move(){
        System.out.println("Moo moo, cow has moved");
    }
}