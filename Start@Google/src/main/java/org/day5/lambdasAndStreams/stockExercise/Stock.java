package org.day5.lambdasAndStreams.stockExercise;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Stock {
    private final List<Item> items;

    public Stock() {
        items = new ArrayList<>();
    }

    public void generateItem() {
        Faker faker = new Faker();

        String name = faker.pokemon().name();
        Type type = Type.values()[ThreadLocalRandom.current().nextInt(Type.values().length)];
        LocalDate expiryDate = LocalDate.now().plusDays(ThreadLocalRandom.current().nextInt(-10, 11));
        double weight = ThreadLocalRandom.current().nextDouble(50);

        Item item = new Item(name, type, expiryDate, weight);
        items.add(item);
    }

    public ArrayList<Item> getExpiredItems() {
        return (ArrayList<Item>) items.stream().filter(item -> item.getExpiryDate().isBefore(LocalDate.now())).collect(Collectors.toList());
    }

    public ArrayList<Item> getSortedAlphabeticallyItems() {
        return (ArrayList<Item>) items.stream().sorted((item1, item2) -> item1.getName().compareTo(item2.getName())).collect(Collectors.toList());
    }

    public Item getExpiresFirstItem() {
        return items.stream().filter(item -> item.getExpiryDate().isAfter(LocalDate.now())).collect(Collectors.toList()).stream().min(Item::compareTo).get();
    }

    public Item getItemByName(String name) throws IllegalArgumentException {
        return items.stream().filter(item -> item.getName().equals(name)).findFirst().orElseThrow(() -> new IllegalArgumentException("No such name"));
    }

    public ArrayList<String> getListOfNamesAboveSpecificWeight(double weight) {
        return (ArrayList<String>) items.stream().filter(item -> item.getWeight() > weight).collect(Collectors.toList())
                .stream().map(item -> new String(item.getName())).collect(Collectors.toList());
    }

    public HashMap<Type, Integer> getSumOfItemsByType() {

        Map<Type, Integer> sumByType = new HashMap<>();

        for (Type type : Type.values()) {

            int sum = (int) items.stream().filter(item -> item.getType() == type).count();

            sumByType.put(type, sum);
        }

        return (HashMap<Type, Integer>) sumByType;
    }

    public void print() {
        for (Item item : items) {
            System.out.println(item.getName() + ", " + item.getType() + ", " + item.getExpiryDate() + ", " + item.getWeight());
        }
        System.out.println("-----------------------------------------");
    }
}
