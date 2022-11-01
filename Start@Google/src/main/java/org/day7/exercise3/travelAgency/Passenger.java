package org.day7.exercise3.travelAgency;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class Passenger {
    public String name;
    public VehicleType favoriteTypeOfVehicle;

    public Passenger() {
        Faker faker = new Faker();
        name = faker.name().firstName();

        favoriteTypeOfVehicle = VehicleType.values()[ThreadLocalRandom.current().nextInt(VehicleType.values().length)];
    }

    public String getName() {
        return new String(name);
    }

    public VehicleType getFavoriteTypeOfVehicle(){
        return favoriteTypeOfVehicle;
    }
}
