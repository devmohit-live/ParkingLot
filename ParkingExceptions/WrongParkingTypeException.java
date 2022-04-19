package ParkingExceptions;

import Modals.ParkingSpot;

public class WrongParkingTypeException extends Exception {
    private static final String messagString = " : This Parking type is not supported yet";

    public WrongParkingTypeException(ParkingSpot parkingSpot) {
        super(parkingSpot.getParkingType() + messagString);
    }
}
