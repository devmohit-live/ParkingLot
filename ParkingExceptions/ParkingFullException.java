package ParkingExceptions;

import Modals.ParkingSpot;

public class ParkingFullException extends Exception {
    private static final String messString = ": is Full. Can't park more.";

    public ParkingFullException(ParkingSpot parkingSpot) {
        super(parkingSpot.getParkingType() + messString);
    }
}
