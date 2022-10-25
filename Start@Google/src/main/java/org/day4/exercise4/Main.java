package org.day4.exercise4;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Callable<Integer> integerCallable = new Callable<>() {
            @Override
            public Integer call() throws Exception {
                return ThreadLocalRandom.current().nextInt(10);
            }
        };
        Callable<Double> doubleCallable = new Callable<>() {
            @Override
            public Double call() throws Exception {
                return ThreadLocalRandom.current().nextDouble(10);
            }
        };

        Optional<?> result = retry(integerCallable, 5, 1000L);
        if(result.isPresent())
            System.out.println(result.get());


        result = retry(doubleCallable, 5.0, 5);
        if(result.isPresent())
            System.out.println(result.get());
    }

    public static <T> Optional<T> retry(Callable<T> action, T expectedResult) {
        System.out.println("1 second cycle & 10 cycles at total");
        return retry(action, expectedResult, 10, 1000L);
    }

    public static <T> Optional<T> retry(Callable<T> action, T expectedResult, int numberOfRetries) {
        System.out.println("1 second sleep cycle");
        return retry(action, expectedResult, numberOfRetries, 1000L);
    }

    public static <T> Optional<T> retry(Callable<T> action, T expectedResult, long sleep) {
        System.out.println("10 default cycles");
        return retry(action, expectedResult, 10, sleep);
    }

    public static <T> Optional<T> retry(Callable<T> action, T expectedResult, int numberOfRetries, long sleep) {
        T value = null;

        for (int i = 0; i < numberOfRetries; i++) {
            try {
                value = action.call();
                if (value == expectedResult) {
                    System.out.println("Found!");
                    return Optional.of(value);
                }
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Thread has interrupted");
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }
        return Optional.ofNullable(value);
    }
}