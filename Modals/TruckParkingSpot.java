package Modals;

public class TruckParkingSpot extends ParkingSpotClass {
    private static final String parkingType = "Truck Parking";
    private static final int ratePerHour = 50;

    public TruckParkingSpot() {
        super(parkingType, ratePerHour);
    }
}
