package org.day3.exercise2;

/*
    The Animal has this functionality:

    [V] - It can move().
    [V] - It has a gender.
    [V] - It has an id.
    [V] - It has weight.
    [V] - It can mate(Animal partner) and create a new animal of its type (only with the opposite gender).

    The Farm has the following capabilities:

    [V] - It can acquire() new Animals - meaning generating new animals.
    [V] - It can create new Animals by the mate() function of existing Animals
    [V] - It can provide Animals to outside users.

    The Farmer can do the following:

    [V] - He can make an animal move.
    [V] - He can request an animal from the Farm.

    Tasks:

    [V] - Create 3 different types of Animal in the farm. Animal should be an interface.
    [V] - Create a skeletal implementation abstract class for Animal.
    [V] - For one of your Animal types. implement a class to extend its functionality using composition and forwarding.

 */

import org.utilities.UniqueIdGeneretor;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();

        for (int i = 0; i < 10; i++) {
            farm.acquire();
        }

        UniqueIdGeneretor uniqueIdGeneretor = new UniqueIdGeneretor();
        Random rnd = new Random();

        Animal pig1 = new Pig(Gender.Male, uniqueIdGeneretor.generate(), rnd.nextInt(100));
        Animal pig2 = new Pig(Gender.Female, uniqueIdGeneretor.generate(), rnd.nextInt(100));

        Animal pig3 = pig1.mate(pig2);
        System.out.println(pig3);

        pig3 = pig1.mate(pig1);
        System.out.println(pig3);

        Animal cow1 = new Cow(Gender.Male, uniqueIdGeneretor.generate(), rnd.nextInt(200));
        Animal cow2 = new Cow(Gender.Female, uniqueIdGeneretor.generate(), rnd.nextInt(200));

        try {
            Animal cow3 = cow1.mate(cow1);
            System.out.println(cow3.getId());
        } catch (NullPointerException e) {
            System.out.println("Couldn't mate");
        }

        Animal cow3 = cow1.mate(cow2);
        System.out.println(cow3.getId());

        Farmer farmer = new Farmer();
        farmer.moveAnimal(cow3);
    }
}
