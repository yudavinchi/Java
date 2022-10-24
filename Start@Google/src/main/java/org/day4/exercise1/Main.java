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
        User user1 = new User();
        User user2 = new User();

        store.assignCoupon(user1);
        store.assignCoupon(user1);
        store.assignCoupon(user1);

        store.assignCoupon(user2);

        user1.print();
        user2.print();

        System.out.println("-----------------------");

        store.useCoupon(user1, user1.getCouponByExpiresFirst().get());

        user1.print();
        user2.print();

        System.out.println("-----------------------");
    }

}
