package Modals;

public interface ParkingSpot {
    public boolean isSpotFree();

    public String getParkingType();

    public void fillSpot(Vehicle vehicle);

    public Vehicle freeSpot();

    public int getRatePerHours();

}
