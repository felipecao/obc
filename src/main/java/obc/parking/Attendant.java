package obc.parking;

import java.util.Arrays;
import java.util.List;

public class Attendant {
    private List<ParkingLot> parkingLots;

    public Attendant(ParkingLot... lots) {
        this.parkingLots = Arrays.asList(lots);
    }

    public boolean park(Car car) {
        boolean result = false;
        switch (car.getTrait()) {
            case NORMAL:
                result = parkingLots
                        .stream()
                        .anyMatch(lot -> lot.park(car));
                break;
            case LARGE:
                parkingLots.stream().sorted().findFirst();
                break;
            case HANDICAPPED:
                parkingLots.stream().filter(parkingLot -> parkingLot.isHandicappedEnabled()).findFirst(lot -> lot.park(car));
                break;
        }
        return result;
    }

    public boolean fetch(Car car) {
        return parkingLots
                .stream()
                .anyMatch(lot -> lot.fetch(car));
    }
}