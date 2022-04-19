package Modals;
public class Bike extends Vehicle {
    private static final String type = "BIKE";
    private static final int ratePerHours = 10;
    private long licencePlateNumber;

    public Bike(final long licencePlateNumber) {
        super(type, licencePlateNumber);
    }
}
