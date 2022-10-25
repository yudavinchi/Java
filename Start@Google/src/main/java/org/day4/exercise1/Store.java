package org.day4.exercise1;

import org.utilities.UniqueIdGeneretor;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Store {
    static UniqueIdGeneretor uniqueIdGeneretor;

    public Store() {
        uniqueIdGeneretor = new UniqueIdGeneretor();
    }

    public void assignCoupon(User user) {
        int id = uniqueIdGeneretor.generate();
        LocalDate localDate = LocalDate.now().plusDays(ThreadLocalRandom.current().nextInt(7) + 1);
        double value = ThreadLocalRandom.current().nextDouble(50);

        user.add(new Coupon(id, localDate, value));
    }

    private void useCoupon(User user, Coupon coupon) {
        LocalDate todaysDate = java.time.LocalDate.now();

        if (todaysDate.compareTo(coupon.getExpiryDate()) < 0 && uniqueIdGeneretor.exists(coupon.getId())) {
            System.out.println("The coupon is valid, you may use it");
            user.remove(coupon);
            uniqueIdGeneretor.remove(coupon.getId());
        } else {
            System.out.println("The coupon is not valid, please use another one");
            throw new IllegalArgumentException("Coupon is expired");
        }
    }

    public void useCouponById(User user, int id) {
        try {
            Coupon temp = user.getCouponById(id).orElseThrow(() -> new IllegalArgumentException("User doesn't have that coupon"));
            try {
                useCoupon(user, temp);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void useCouponByHighestValue(User user) {
        try {
            Coupon temp = user.getCouponByHighestValue().orElseThrow(() -> new IllegalArgumentException("User doesn't have coupons"));
            try {
                useCoupon(user, temp);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void useCouponByExpiresFirst(User user) {
        try {
            Coupon temp = user.getCouponByExpiresFirst().orElseThrow(() -> new IllegalArgumentException("User doesn't have coupons"));
            try {
                useCoupon(user, temp);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void useCouponByRandom(User user) {
        try {
            Coupon temp = user.getCouponByRandom().orElseThrow(() -> new IllegalArgumentException("User doesn't have coupons"));
            useCoupon(user, temp);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
