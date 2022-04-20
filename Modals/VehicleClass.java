package Modals;

public class VehicleClass implements Vehicle {
    private final String vehicleType;
    private long licencePlateNumber;

    public VehicleClass(String vehicleType, long licencePlateNumber) {
        this.vehicleType = vehicleType;
        this.licencePlateNumber = licencePlateNumber;
    }

    /**
     * @return the type
     */
    public String getVehicleType() {
        return this.vehicleType;
    }

    /**
     * @return the licencePlateNumber
     */
    public long getLicencePlateNumber() {
        return this.licencePlateNumber;
    }
}
