package org.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------------------------- phase 1 ----------------------------");
        int num = 2;

        GenerateRandomIntArray generatedRandomIntArraynew = new GenerateRandomIntArray(0, 100, 5);

        // display int[] for visual purpose
        for (int i = 0; i < generatedRandomIntArraynew.get().length; i++) {
            System.out.print(generatedRandomIntArraynew.get()[i] + " ");
        }

        forPrint(generatedRandomIntArraynew.get(), num);
        System.out.println("----------------------------");
        forEachPrint(generatedRandomIntArraynew.get(), num);
        System.out.println("----------------------------");
        whilePrint(generatedRandomIntArraynew.get(), num);

        System.out.println("---------------------------- phase 2 ----------------------------");

        HashMap<userId, User> usersHashMap = new HashMap<userId, User>();

        for (int i = 0; i < 10; i++) {
            userId id = new userId();
            GenerateRandomString rndString = new GenerateRandomString(10);
            GenerateRandomBoolean rndBool = new GenerateRandomBoolean();
            User user = new User(rndString.get(), id.get(), rndBool.get());
            usersHashMap.put(id, user);
        }

        List<User> usersList = convertHashToList(usersHashMap);
        System.out.println(countActivatedUsers(usersList));
    }

    /*
    Using loops
    Write a method that gets an array of numbers and an int, and prints only the numbers in this array which are divided by that int without a remainder.
    *Implement this 3 times using for, for-each, and while
     */

    public static void forPrint(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % num == 0) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void forEachPrint(int[] arr, int num) {
        for (int val : arr) {
            if (val % num == 0) {
                System.out.println(val);
            }
        }
    }

    public static void whilePrint(int[] arr, int num) {
        int index = 0;
        while (index < arr.length) {
            if (arr[index] % num == 0) {
                System.out.println(arr[index]);
            }

            index++;
        }
    }

    public static List convertHashToList(HashMap<userId, User> map) {
        List<User> list = new ArrayList<User>(map.values());
        return list;
    }

    public static User getUserById(int id, List<User> lst) {

        User temp = null;

        for (User user : lst) {
            if (id == user.getId()) {
                return temp = user;
            }
        }
        return temp;
    }

    public static int countActivatedUsers(List<User> lst) {
        int counter = 0;
        for (User user : lst) {
            if (user.isActivated()) {
                counter++;
            }
        }
        return counter;
    }
}