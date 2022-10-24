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
        LocalDate localDate = java.time.LocalDate.now().plusDays(ThreadLocalRandom.current().nextInt(7) + 1);
        double value = ThreadLocalRandom.current().nextDouble(50);

        user.add(new Coupon(id, localDate, value));
    }

    public boolean useCoupon(User user, Coupon coupon) {
        LocalDate todaysDate = java.time.LocalDate.now();

        if (todaysDate.compareTo(coupon.getExpiryDate()) < 0 && uniqueIdGeneretor.exists(coupon.getId())) {
            System.out.println("The coupon is valid, you may use it");
            user.remove(coupon);
            uniqueIdGeneretor.remove(coupon.getId());

            return true;
        }
        System.out.println("The coupon is not valid, please use another one");
        return false;
    }
}
