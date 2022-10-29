package org.day5.lambdasAndStreams;

import org.day5.lambdasAndStreams.stockExercise.Item;
import org.day5.lambdasAndStreams.stockExercise.Stock;
import org.day5.lambdasAndStreams.stockExercise.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();

        for (int i = 0; i < 10; i++) {
            stock.generateItem();
        }

        // stock itself
        stock.print();

        // expired items
        printList(stock.getExpiredItems());

        // expires first item
        printItem(stock.getExpiresFirstItem());
        System.out.println("-----------------------------------------");

        // sorted alphabetically
        printList(stock.getSortedAlphabeticallyItems());
        System.out.println("-----------------------------------------");

        // Item names that are above a curtain weight
        ArrayList<String> temp = stock.getListOfNamesAboveSpecificWeight(40.0);
        for (String name : temp) {
            System.out.println(name);
        }
        System.out.println("-----------------------------------------");

        // Count items by type
        HashMap<Type, Integer> temp2 = stock.getSumOfItemsByType();
        System.out.println(temp2.toString());
        System.out.println("-----------------------------------------");
    }

    public static void printList(List<Item> list) {
        for (Item item : list) {
            printItem(item);
        }
    }

    public static void printItem(Item item) {
        System.out.println(item.getName() + ", " + item.getType() + ", " + item.getExpiryDate() + ", " + item.getWeight());
    }
}
