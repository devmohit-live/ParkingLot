package Modals;
public class Car extends VehicleClass {
    private static final String type = "CAR";
    private static final int ratePerHours = 20;
    private long licencePlateNumber;

    public Car(final long licencePlateNumber) {
        super(type, licencePlateNumber);
    }
}
