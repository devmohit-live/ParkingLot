package Modals;

import java.util.Date;

public class GetFare {
    // Assumption minmum duration taken will be of 1 hour;
    public double getFare(ParkingSpot parkingSpot, Date starttime, Date endtime) {
        long diffHours = (endtime.getTime() - starttime.getTime()) / (60 * 60 * 1000);
        double res = parkingSpot.getRatePerHours() * 1.0 * diffHours;
        return res == 0 ? parkingSpot.getRatePerHours() * 1.0 : res;
    }

}
