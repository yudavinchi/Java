package org.day7.exercise3.travelAgency;

public class Boat implements Vehicle{
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName() + " is in a boat, and his/her favorite vehicle is " + passenger.getFavoriteTypeOfVehicle().toString());
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BOAT;
    }
}
