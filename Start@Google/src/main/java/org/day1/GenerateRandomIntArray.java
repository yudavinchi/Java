package org.day1;

import java.util.Random;

public class GenerateRandomIntArray {
    private int[] arr;

    public GenerateRandomIntArray(int min, int max, int length)
    {
        arr = new int[length];

        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
    }

    public int[] get(){
        return arr;
    }
}
