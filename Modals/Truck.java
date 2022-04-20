package Modals;
public class Truck extends VehicleClass {
    private static final String type = "TRUCK";
    private static final int ratePerHours = 50;
    private long licencePlateNumber;

    public Truck(final long licencePlateNumber) {
        super(type, licencePlateNumber);
    }
}
