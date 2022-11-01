package org.day7.exercise3.travelAgency;

class SingletonVehicleFactory {
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
            case BUS:
                return new Bus();
            case BOAT:
                return new Boat();
            case PLANE:
                return new Plane();
            case TAXI:
                return new Taxi();
            default:
                System.out.println("No match found...");
        }
        return null;
    }
}
