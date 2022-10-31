package org.day7.exericise1;

import org.day7.exericise1.autoValue.Person;
import org.day7.exericise1.autoValue.Vehicle;

public class Main {
    public static void main(String[] args) {
        Person person = Person.create(123, "David");
        Vehicle vehicle = Vehicle.create("Bus", 100);

        System.out.println(person.toString());
    }
}
