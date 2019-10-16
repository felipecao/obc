package obc.parking;

import java.util.Arrays;
import java.util.List;

public class Attendant {
    private List<ParkingLot> parkingLots;

    public Attendant(ParkingLot... lots) {
        this.parkingLots = Arrays.asList(lots);
    }

    public boolean park(Car car) {
        return parkingLots
                .stream()
                .anyMatch(lot -> lot.park(car));
    }

    public boolean fetch(Car car) {
        return parkingLots
                .stream()
                .anyMatch(lot -> lot.fetch(car));
    }
}