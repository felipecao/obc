package obc.parking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Attendant {
    private List<ParkingLot> parkingLots;

    public Attendant(ParkingLot... lots) {
        this.parkingLots = Arrays.asList(lots);
    }

    public boolean park(Car car) {
        if (car.size().equals("LARGE")) {
            return parkingLots
                    .stream()
                    .sorted(byOccupancy())
                    .findFirst()
                    .get()
                    .park(car);
        }
        return parkingLots
                .stream()
                .anyMatch(lot -> lot.park(car));
    }

    public boolean fetch(Car car) {
        return parkingLots
                .stream()
                .anyMatch(lot -> lot.fetch(car));
    }

    private Comparator<ParkingLot> byOccupancy() {
        return Comparator.comparingInt(ParkingLot::occupancy);
    }
}