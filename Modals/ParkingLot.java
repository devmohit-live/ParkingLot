package Modals;

import java.util.Date;
import java.util.HashMap;

import ParkingExceptions.VehicleNotParkedException;
import ParkingExceptions.WrongParkingTypeException;
import ParkingExceptions.WrongUnparkingException;
import ParkingExceptions.WrongVehicleTypeExceptions;

public class ParkingLot {

    class Pair {
        int idx;
        Date date;

        public Pair(int idx, Date date) {
            this.idx = idx;
            this.date = date;
        }

    }

    // licencePlateNumber : Pair{parkingSpot idx for instant search, Date}
    private HashMap<Long, Pair> carParkingSpots;
    private HashMap<Long, Pair> truckParkingSpots;
    private HashMap<Long, Pair> bikeParkingSpots;
    private GetFare getFare;

    private int carsParked, bikesParked, trucksParked;
    private final int MaxCarParkingSpots, MAXBikeParkingSpots, MAXTruckParkingSpots;
    private CarParkingSpot[] carParkingSpotArray;
    private TruckParkingSpot[] truckParkingSpotArray;
    private BikeParkingSpot[] bikeParkingSpotArray;

    public ParkingLot(final int MaxCarParkingSpots, final int MAXBikeParkingSpots, final int MAXTruckParkingSpots) {
        this.MaxCarParkingSpots = MaxCarParkingSpots;
        this.MAXBikeParkingSpots = MAXBikeParkingSpots;
        this.MAXTruckParkingSpots = MAXTruckParkingSpots;
        this.carParkingSpots = new HashMap<>();
        this.bikeParkingSpots = new HashMap<>();
        this.truckParkingSpots = new HashMap<>();
        this.carParkingSpotArray = new CarParkingSpot[this.MaxCarParkingSpots];
        this.bikeParkingSpotArray = new BikeParkingSpot[this.MAXBikeParkingSpots];
        this.truckParkingSpotArray = new TruckParkingSpot[this.MAXTruckParkingSpots];
        this.carsParked = this.bikesParked = this.trucksParked = 0;
        this.getFare = new GetFare();
        // System.out.println(Arrays.toString(carParkingSpotArray));
    }

    public int noOfParkingsLeft(final Vehicle vehicle) throws WrongVehicleTypeExceptions {
        if (vehicle.getVehicleType().equalsIgnoreCase("CAR"))
            return this.MaxCarParkingSpots - this.carsParked;
        else if (vehicle.getVehicleType().equalsIgnoreCase("Bike"))
            return this.MAXBikeParkingSpots - this.bikesParked;
        else if (vehicle.getVehicleType().equalsIgnoreCase("Truck"))
            return this.MAXTruckParkingSpots - this.trucksParked;
        else
            throw new WrongVehicleTypeExceptions(vehicle);

    }

    public int noOfParkingsLeft(final ParkingSpot parkingSpot) throws WrongParkingTypeException {
        if (parkingSpot.getParkingType().equalsIgnoreCase("Car Parking"))
            return this.MaxCarParkingSpots - this.carsParked;
        else if (parkingSpot.getParkingType().equalsIgnoreCase("Bike Parking"))
            return this.MAXBikeParkingSpots - this.bikesParked;
        else if (parkingSpot.getParkingType().equalsIgnoreCase("Truck Parking"))
            return this.MAXTruckParkingSpots - this.trucksParked;
        else
            throw new WrongParkingTypeException(parkingSpot);
    }

    public void parkVehicle(final Vehicle vehicle) throws WrongVehicleTypeExceptions {
        String type = vehicle.getVehicleType();
        ParkingSpot parkingSpot = null;

        if (type.equalsIgnoreCase("Car")) {
            carParkingSpotArray[this.carsParked] = new CarParkingSpot();
            parkingSpot = carParkingSpotArray[this.carsParked];
            carParkingSpots.put(vehicle.getLicencePlateNumber(), new Pair(this.carsParked++, new Date()));
        } else if (type.equalsIgnoreCase("Bike")) {
            bikeParkingSpotArray[this.bikesParked] = new BikeParkingSpot();
            parkingSpot = bikeParkingSpotArray[this.bikesParked];
            bikeParkingSpots.put(vehicle.getLicencePlateNumber(), new Pair(this.bikesParked++, new Date()));
        } else if (type.equalsIgnoreCase("Truck")) {
            truckParkingSpotArray[this.trucksParked] = new TruckParkingSpot();
            parkingSpot = truckParkingSpotArray[this.trucksParked];
            truckParkingSpots.put(vehicle.getLicencePlateNumber(), new Pair(this.trucksParked++, new Date()));
        } else {
            throw new WrongVehicleTypeExceptions(vehicle);
        }
        parkingSpot.fillSpot(vehicle);

    }

    public double unParkAVehicleAndGetFare(final Vehicle vehicle)
            throws WrongVehicleTypeExceptions, VehicleNotParkedException, WrongUnparkingException {
        ParkingSpot parkingSpot = null;
        Date start = null;
        int parkingSpotIdx = -1;

        final String type = vehicle.getVehicleType();

        if (type.equalsIgnoreCase("Car")) {
            Pair pair = carParkingSpots.getOrDefault(vehicle.getLicencePlateNumber(), null);
            if (pair != null) {
                parkingSpotIdx = pair.idx;
                start = pair.date;
                parkingSpot = carParkingSpotArray[parkingSpotIdx];
                carParkingSpots.remove(vehicle.getLicencePlateNumber());
                --this.carsParked;

            }

        } else if (type.equalsIgnoreCase("Bike")) {
            Pair pair = bikeParkingSpots.getOrDefault(vehicle.getLicencePlateNumber(), null);
            if (pair != null) {
                parkingSpotIdx = pair.idx;
                start = pair.date;
                parkingSpot = bikeParkingSpotArray[parkingSpotIdx];
                bikeParkingSpots.remove(vehicle.getLicencePlateNumber());
                --this.bikesParked;

            }
        } else if (type.equalsIgnoreCase("Truck")) {
            Pair pair = truckParkingSpots.getOrDefault(vehicle.getLicencePlateNumber(), null);
            if (pair != null) {
                parkingSpotIdx = pair.idx;
                start = pair.date;
                parkingSpot = truckParkingSpotArray[parkingSpotIdx];
                truckParkingSpots.remove(vehicle.getLicencePlateNumber());
                --this.trucksParked;

            }
        } else {
            throw new WrongVehicleTypeExceptions(vehicle);
        }

        if (parkingSpot == null) {
            throw new VehicleNotParkedException();
        }
        if (parkingSpot.isSpotFree())
            throw new WrongUnparkingException();

        parkingSpot.freeSpot();
        return getFare.getFare(parkingSpot, start, new Date());
    }
}
