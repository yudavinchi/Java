package org.day7.exercise3.travelAgency;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TravelAgency {
    Map<Vehicle, Passenger> controller;
    int availableVehicles;

    public TravelAgency(HashMap<VehicleType, Integer> demand) {
        SingletonVehicleFactory.getInstance();
        controller = new HashMap<>();

        demand.forEach((key, value) -> {
            availableVehicles += value;
            for (int i = 0; i < value; i++) {
                controller.put(SingletonVehicleFactory.createVehicle(key), null);
            }
        });
    }

    public void assign(Passenger passenger) {
        boolean found = false;

        for (Map.Entry<Vehicle, Passenger> set : controller.entrySet()) {
            if (set.getKey().getType() == passenger.getFavoriteTypeOfVehicle() && set.getValue() == null) {
                controller.put(set.getKey(), passenger);
                availableVehicles -= 1;
                found = true;
                break;
            }
        }

        if (!found) {
            for (Map.Entry<Vehicle, Passenger> set : controller.entrySet()) {
                if (set.getValue() == null) {
                    controller.put(set.getKey(), passenger);
                    availableVehicles -= 1;
                    break;
                }
            }
        }
        if (availableVehicles == 0) {
            invokeTransport();
        }
    }

    public void invokeTransport() {
        for (Map.Entry<Vehicle, Passenger> set : controller.entrySet()) {
            set.getKey().transport(set.getValue());
        }
    }

    public void print() {
        controller.entrySet().forEach(set -> {
            if (set.getValue() == null) {
                System.out.println(set.getKey().getType() + " " + set.getValue());
            } else {
                System.out.println(set.getKey().getType() + " " + set.getValue().getFavoriteTypeOfVehicle());
            }
        });
    }
}
