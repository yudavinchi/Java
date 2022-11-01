package org.day7.exercise3.travelAgency;

public enum VehicleType {
    PLANE("plane"), BUS("bus"), TAXI("taxi"), BOAT("boat");

    private final String vehicle;

    VehicleType(String vehicle) {
        this.vehicle = vehicle;
    }

    public String toString() {
        return vehicle;
    }
}
