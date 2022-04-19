package Modals;

public abstract class ParkingSpot {
    private boolean isSpotFree;
    private final String parkingType;
    private Vehicle vehicle;
    private int ratePerHour;

    public ParkingSpot(String parkingType, int ratePerHour) {
        this.parkingType = parkingType;
        this.ratePerHour = ratePerHour;
        this.isSpotFree = true;
    }

    /**
     * @return the spotIsFree
     */
    public boolean isSpotFree() {
        return isSpotFree;
    }

    /**
     * @return the parkingType
     */
    public String getParkingType() {
        return parkingType;
    }

    /**
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void fillSpot(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isSpotFree = false;
    }

    public Vehicle freeSpot() {
        Vehicle currentVehicle = this.vehicle;
        this.isSpotFree = true;
        this.vehicle = null;
        return currentVehicle;
    }

    public int getRatePerHours() {
        return this.ratePerHour;
    }

}
