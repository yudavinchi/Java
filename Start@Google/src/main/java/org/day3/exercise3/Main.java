package org.day3.exercise3;

/*
   [V] - Create a Contact class that has:

        a Name class which consists of:

        Prefix - Mr. Ms. etc…
        First Name
        Last Name

        a PhoneNumber which consists of:

        Area Code - 03, 06, 050, etc…
        Number

    [ ] - Create a PhoneBook which has a list of Contacts and a name

    [V] - Implement equals(), hashCode(), toString(), clone(), compareTo() for all your classes (excluding PhoneBook).


 */

import com.github.javafaker.Faker;
import org.utilities.NameGenerator;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        ArrayList<Contact> arr = new ArrayList<>();

        String streetAddress = faker.address().streetAddress();

        for (int i = 0; i < 50; i++) {

            String fullNumber = new String(phoneNumberGenerator());
            String areaCode = fullNumber.substring(0,3);
            String number = fullNumber.substring(3, 10);


            arr.add(new Contact(new Name(Prefix.random(), faker.name().firstName(), faker.name().firstName()),
                    new PhoneNumber(areaCode, number)));
        }

        for(Contact contact: arr){
            System.out.println(contact.toString());
        }
    }

    public static String phoneNumberGenerator(){
        String number = new String();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            number += String.valueOf(rnd.nextInt(10));
        }

        return number;
    }
}
