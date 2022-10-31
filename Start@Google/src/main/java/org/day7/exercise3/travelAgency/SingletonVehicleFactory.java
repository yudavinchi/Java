package org.day7.exercise3.travelAgency;

public class SingletonVehicleFactory {
    private static SingletonVehicleFactory instance;

    public static SingletonVehicleFactory getInstance() {
        if (instance == null) {
            instance = new SingletonVehicleFactory();
        }
        return instance;
    }

    private SingletonVehicleFactory() {
    }

    public static Vehicle createVehicle(VehicleType vehicleType){
        switch (vehicleType){
            case VehicleType.BUS:
                return new Boat();
                break;
            case VehicleType.BOAT:
                return new Boat();
                break;
            case VehicleType.PLANE:
                return new Plane();
                break;
            case VehicleType.TAXI:
                return new Taxi();
                break;
            default:
                System.out.println("No match found...");
                break;
        }
        return null;
    }
}
