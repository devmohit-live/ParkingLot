package ParkingExceptions;

import Modals.ParkingSpot;

public class ParkingFullException extends Exception {
    private static final String messString = ": parking spots are Full. Can't park more.";

    public ParkingFullException(String parkingType) {
        super(parkingType + messString);
    }
}
