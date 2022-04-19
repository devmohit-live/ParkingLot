package Modals;

public abstract class Vehicle {
    private final String vehicleType;
    private long licencePlateNumber;

    public Vehicle(String vehicleType, long licencePlateNumber) {
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

    /**
     * @param licencePlateNumber the licencePlateNumber to set
     */
    public void setLicencePlateNumber(long licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
    }
}
