package Modals;

public class CarParkingSpot extends ParkingSpotClass{
    private static final String parkingType = "Car Parking";
    private static final int ratePerHour = 30;
    
    public CarParkingSpot(){
        super(parkingType,ratePerHour);
    }
}
