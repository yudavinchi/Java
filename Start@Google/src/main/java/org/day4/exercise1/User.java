package org.day4.exercise1;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class User {
    String name;
    ArrayList<Coupon> coupons;
    Faker faker;

    public User(String name) {
        this.name = name;
        coupons = new ArrayList<>();
    }

    public User() {
        faker = new Faker();
        this.name = faker.name().firstName();
        coupons = new ArrayList<>();
    }

    public Optional<Coupon> getCouponById(int id) {
        for (Coupon coupon : coupons) {
            if (coupon.getId() == id) {
                coupons.remove(coupon);
                return Optional.of(coupon);
            }
        }
        return Optional.empty();
    }

    public Optional<Coupon> getCouponByHighestValue() {
        double max = -1;
        Coupon temp = null;

        for (Coupon coupon : coupons) {
            if (coupon.value > max) {
                max = coupon.value;
                temp = coupon;
            }
        }
        return Optional.ofNullable(temp);
    }

    public Optional<Coupon> getCouponByExpiresFirst() {

        LocalDate todaysDate = LocalDate.now();
        Coupon temp = null;

        if (!coupons.isEmpty()) {

            int i = 0;

            for (; i < coupons.size(); i++) {
                if (coupons.get(i).getExpiryDate().isAfter(todaysDate)) {
                    temp = coupons.get(i);
                    break;
                }
            }

            for (; i < coupons.size(); i++) {
                if (coupons.get(i).getExpiryDate().isAfter(todaysDate) &&
                    coupons.get(i).getExpiryDate().isBefore(temp.getExpiryDate())) {
                    temp = coupons.get(i);
                }
            }
            return Optional.of(temp);
        }
        return Optional.empty();
    }

    public Optional<Coupon> getCouponByRandom() {
        return Optional.ofNullable(coupons.get(ThreadLocalRandom.current().nextInt(coupons.size())));
    }

    public void add(Coupon coupon) {
        coupons.add(coupon);
    }

    public void remove(Coupon coupon) {
        coupons.remove(coupon);
    }

    public void print() {
        System.out.println("User: " + name);
        for (Coupon coupon : coupons) {
            System.out.println("id: " + coupon.getId() + ", expiration date: " + coupon.getExpiryDate() + ", value: " + coupon.getValue());
        }
    }
}