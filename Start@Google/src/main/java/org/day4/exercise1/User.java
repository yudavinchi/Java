package org.day4.exercise1;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

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

    public Optional<Coupon> getCouponByExpiresFirst() {

        if (!coupons.isEmpty()) {
            LocalDate expiresSoonDate = java.time.LocalDate.now();
            ArrayList<Integer> tempValues = new ArrayList<>();

            for (Coupon coupon : coupons) {
                tempValues.add(coupon.getExpiryDate().compareTo(expiresSoonDate));
            }

            int min = tempValues.get(0);
            Coupon tempCoupon = coupons.get(0);

            for (int i = 1; i < tempValues.size(); i++) {
                if (tempValues.get(i) < min) {
                    min = tempValues.get(i);
                    tempCoupon = coupons.get(i);
                }
            }
            return Optional.of(tempCoupon);
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