package org.day4.exercise1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

public final class Coupon {

    final int id;
    final LocalDate expiryDate;
    final double value;

    public Coupon(int id, LocalDate expiryDate, double value) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        this.id = id;

        Objects.requireNonNull(expiryDate);
        this.expiryDate = expiryDate;

        if (value < 0) {
            throw new IllegalArgumentException("Coupon cannot store a negative value");
        }
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public LocalDate getExpiryDate() {
        return LocalDate.of(expiryDate.getYear(), expiryDate.getMonth(), expiryDate.getDayOfMonth());
    }

    public double getValue() {
        return value;
    }

}
