package org.day3.exercise3;

import java.util.Objects;

public class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {
    String areaCode, number;

    public PhoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public PhoneNumber(PhoneNumber phoneNumber){
        this.areaCode = phoneNumber.areaCode;
        this.number = phoneNumber.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(areaCode, that.areaCode) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "areaCode='" + areaCode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        int result = areaCode.compareTo(phoneNumber.areaCode);
        if (result == 0) {
            result = number.compareTo(phoneNumber.number);
            return result;
        }
        return -1;
    }

    @Override
    protected PhoneNumber clone() throws CloneNotSupportedException {
        try {
            PhoneNumber clone = (PhoneNumber) super.clone();
            clone.areaCode = new String(areaCode);
            clone.number = new String(number);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
