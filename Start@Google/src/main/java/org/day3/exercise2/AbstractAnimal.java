package org.day3.exercise2;

import org.utilities.UniqueIdGeneretor;

import java.util.Random;

public abstract class AbstractAnimal implements Animal {

    Gender gender;
    int id;
    double weight;

    public Gender getGender(){
        return gender;
    }

    public int getId(){
        return id;
    }

    public double getWeight() {return weight; }

    public Animal mate(Animal partner){

        if(gender != partner.getGender())
        {
            UniqueIdGeneretor uniqueIdGeneretor = new UniqueIdGeneretor();
            Random rnd = new Random();

            if(this instanceof Pig && partner instanceof Pig)
                return new Pig(Gender.random(), uniqueIdGeneretor.generate(), rnd.nextInt(20));
            if(this instanceof Cow && partner instanceof Cow)
                return new Cow(Gender.random(), uniqueIdGeneretor.generate(), rnd.nextInt(40));
            if(this instanceof Chicken && partner instanceof Chicken)
                return new Chicken(Gender.random(), uniqueIdGeneretor.generate(), rnd.nextInt(5));
        }
        return null;
    }
}
