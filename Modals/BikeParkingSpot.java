package Modals;

public class BikeParkingSpot extends ParkingSpotClass {
    private static final String parkingType = "Bike Parking";
    private static final int ratePerHour = 10;

    public BikeParkingSpot() {
        super(parkingType, ratePerHour);
    }
}
