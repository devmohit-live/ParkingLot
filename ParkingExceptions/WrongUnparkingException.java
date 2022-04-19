package ParkingExceptions;

public class WrongUnparkingException extends Exception {
    private static final String messagString = " The Parkings Spot you are trying to relaese doesn't contains a Vehicle yet";

    public WrongUnparkingException() {
        super(messagString);
    }
}
