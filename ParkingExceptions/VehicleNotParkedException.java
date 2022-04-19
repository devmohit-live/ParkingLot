package ParkingExceptions;

public class VehicleNotParkedException extends Exception {
    private static final String messagString = "This Vehicle is Not parked yet";

    public VehicleNotParkedException() {
        super(messagString);
    }
}
