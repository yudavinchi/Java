package org.day3.exercise2;

/*
The Animal has this functionality:

    It can move().
    It has a gender.
    It has an id.
    It has weight.
    It can mate(Animal partner) and create a new animal of its type (only with the opposite gender).

 */

public interface Animal {
    public void move();
    public Animal mate(Animal partner);

    public Gender getGender();

    public int getId();
}
