
/**
 * Main
 */
import Modals.*;

public class Main {

    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot = new ParkingLot(10, 10, 5);
        Car car = new Car(123);
        Vehicle car2 = new Car(456);
        Bike bike = new Bike(789);
        Truck truck = new Truck(101112);

        // test of classes
        System.out.println(car.getVehicleType());
        System.out.println(bike.getVehicleType());
        System.out.println(truck.getVehicleType());
        // System.out.println(truck.getLicencePlateNumber());
        System.out.println(car2.getVehicleType());

        // funtionalites: park
        CarParkingSpot parkingSpot = new CarParkingSpot();
        parkingLot.parkVehicle(car);
        System.out.println("Cars: " + parkingLot.noOfParkingsLeft(car));
        System.out.println("Cars: " + parkingLot.noOfParkingsLeft(parkingSpot));
        parkingLot.parkVehicle(bike);
        System.out.println("Bike: " + parkingLot.noOfParkingsLeft(bike));
        parkingLot.parkVehicle(truck);
        System.out.println("Truck: " + parkingLot.noOfParkingsLeft(truck));
        parkingLot.parkVehicle(car2);
        System.out.println("Cars: " + parkingLot.noOfParkingsLeft(car2));

        // functionalities: unpark
        System.out.println("Unpark truck : " + parkingLot.unParkAVehicleAndGetFare(truck));
        System.out.println("Truck parking now : " + parkingLot.noOfParkingsLeft(truck));
        System.out.println("Unpark car 2 " + parkingLot.unParkAVehicleAndGetFare(car2));
        System.out.println("Car parking now : " + parkingLot.noOfParkingsLeft(car2));
        System.out.println("Unparking Bike " + parkingLot.unParkAVehicleAndGetFare(bike));

    }
}