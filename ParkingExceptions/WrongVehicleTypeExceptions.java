package ParkingExceptions;

import Modals.Vehicle;

public class WrongVehicleTypeExceptions extends Exception {
    private static final String messagString = " : This vehicle's Parking is not supported yet";

    public WrongVehicleTypeExceptions(Vehicle vehicle) {
        super(vehicle.getVehicleType() + messagString);
    }
}
