package org.day4.exercise1;

/*
    [ ] - The Store:
    Can assign Coupon to User
    Can let a User use a Coupon if it is valid

    [V] - The Coupon:
    Has an id
    Has an expiry date
    Has value

    [V] - The User:
    Has a name
    Has a list of Coupons

    [ ] - Create the following methods to use coupons:
    by id
    by the highest value from a user’s list
    by the closest expiry date from a user’s list
    use a randomly selected coupon from a user’s list

 */

public class Main {
    public static void main(String[] args) {

        Store store = new Store();

        User user = new User();

        for (int i = 0; i < 5; i++) {
            store.assignCoupon(user);
        }
        System.out.println("-----------------------");
        user.print();
        System.out.println("-----------------------");

        store.useCouponByExpiresFirst(user);
        store.useCouponByHighestValue(user);
        store.useCouponById(user, 123); // 123 doesn't exist
        store.useCouponByRandom(user);
        System.out.println("-----------------------");
        user.print();
        System.out.println("-----------------------");
    }
}