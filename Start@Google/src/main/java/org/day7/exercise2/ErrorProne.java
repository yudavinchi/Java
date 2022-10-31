package org.day7.exercise2;

import java.util.ArrayList;

public class ErrorProne {
    public static void main(String[] args) {
        int[] intArr1 = new int[5];
        int[] intArr2 = new int[10];

        System.out.println(intArr1.equals(intArr2));
    }
}
