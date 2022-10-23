package org.day3.exercise3;

import java.util.Objects;

public class Contact implements Cloneable{
    Name name;
    PhoneNumber phoneNumber;

    public Contact(Name name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name) && phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name=" + name +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public int compareTo(Contact contact){
        int result = name.compareTo(contact.name);
        if(result == 0){
            result = phoneNumber.compareTo(contact.phoneNumber);
            return result;
        }
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
