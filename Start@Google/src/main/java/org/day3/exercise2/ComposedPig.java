package org.day3.exercise2;

public class ComposedPig extends AbstractAnimal{

    private Pig pig;

    public ComposedPig(Gender gender, int id, double weight){
        pig = new Pig(gender, id, weight);
    }

    public Gender getGender(){
        return pig.gender;
    }

    public int getId(){
        return pig.getId();
    }

    public double getWeight(){
        return pig.getWeight();
    }


    public void move(){
        pig.move();
    }
}
