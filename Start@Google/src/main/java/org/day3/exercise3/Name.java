package org.day3.exercise3;

import java.util.Objects;

public class Name implements Cloneable {
    Prefix prefix;
    String firstName, lastName;

    public Name(Prefix prefix, String firstName, String lastName) {
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
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
        Name clone = super.clone();
    }
}
