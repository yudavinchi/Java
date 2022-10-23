package org.day3.exercise3;

import java.util.HashMap;
import java.util.Objects;

public class Name implements Cloneable, Comparable<Name> {
    Prefix prefix;
    String firstName, lastName;

    public Name(Prefix prefix, String firstName, String lastName) {
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name(Name name){
        this.prefix = name.prefix;
        this.firstName = name.firstName;
        this.lastName = name.lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return prefix == name.prefix && Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "prefix=" + prefix +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Name name) {
        int result = prefix.label.compareTo(name.prefix.label);
        if (result == 0) {
            result = firstName.compareTo(name.firstName);
            if (result == 0) {
                result = lastName.compareTo(name.lastName);
                return result;
            } else {
                return result;
            }
        }
        return result;
    }

    @Override
    protected Name clone() throws CloneNotSupportedException {
        try {
            Name clone = (Name) super.clone();
            clone.prefix = prefix;
            clone.firstName = new String(firstName);
            clone.lastName = new String(lastName);

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Name name1 = new Name(Prefix.Dr, "David", "Yudin");
        System.out.println(name1.toString());

        Name name2 = new Name(Prefix.Dr, "David", "Yudin");

        if(name1.equals(name2)) {
            System.out.println("Equal");
        }
        else{
            System.out.println("Not Equal");
        }

        HashMap<Name, String> test = new HashMap<>();
        test.put(name1, "test1");
        test.put(name2, "test2");

        System.out.println(test.toString());

        Name name3 = null;

        try{
            name3 = name1.clone();
        }
        catch (CloneNotSupportedException e){
            System.out.println("Clone didn't succeed");
        }

        System.out.println(Objects.requireNonNull(name3).toString());

        if(name1.equals(name3)) {
            System.out.println("Equal");
        }
        else{
            System.out.println("Not Equal");
        }

        System.out.println(name1 == name3);

        Name name4 = new Name(Prefix.Dr, "David", "Yudin");

        System.out.println(name1.compareTo(name4));
    }
}
