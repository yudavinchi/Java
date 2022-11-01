package org.day7.exercise3;

/*
Implement a travel agency.
    Specifications:

        [ ] - Use a factory method to provide the vehicles for the agency.
        [V] - The factory should be a singleton.
        [ ] - The travel agency has 4 buses, 8 taxis, 3 boats, and one plane.
        [V] - Plane, Bus, Taxi, and Boat all implement the Vehicle interface.
        [V] - Vehicle has the transport(Passenger passenger) method that accepts a passenger and prints it’s name to mark a successful transport.
        [V] - A Passenger has a name and a favorite Vehicle.
        [ ] - Your program should assign passengers to the available vehicles.
        [ ] - If a passenger’s favorite vehicle is available assign it to him, otherwise, assign a random available vehicle.
        [ ] - When all vehicles are used, invoke the transport method of all of them.

    Example flow:

        The program generated the passenger:
        {name:"shlomi", favorite: PLANE}
        The agency has no PLANE available, so shlomy gets a taxi.
        Now the agency has one less taxi available.


 */

import org.day7.exercise3.travelAgency.Passenger;
import org.day7.exercise3.travelAgency.TravelAgency;
import org.day7.exercise3.travelAgency.VehicleType;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<VehicleType, Integer> demand = new HashMap<>();

        demand.put(VehicleType.BUS, 4);
        demand.put(VehicleType.TAXI, 8);
        demand.put(VehicleType.BOAT, 3);
        demand.put(VehicleType.PLANE, 1);

        TravelAgency travelAgency = new TravelAgency(demand);

        for (int i = 0; i < 16; i++) {
            travelAgency.assign(new Passenger());
        }
    }
}
