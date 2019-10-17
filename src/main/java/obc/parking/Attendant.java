package obc.parking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Attendant {
    private final boolean certified;
    private List<ParkingLot> parkingLots;

    public Attendant(ParkingLot... lots) {
        this.parkingLots = Arrays.asList(lots);
        this.certified = false;
    }

    public Attendant(ParkingLot emptyLot, boolean certified) {
        this.parkingLots = Arrays.asList(emptyLot);
        this.certified = certified;
    }

    public boolean park(Car car) {
        if (car.doesRequireCertifiedDriver() && !certified) {
            return false;
        }

        if (car instanceof LargeCar) {
            return findLeastOccupied().park(car);
        }
        if (car instanceof HandicappedCar) {
            return findFirstHandicappedFriendly().park(car);
        }

        return parkingLots
                .stream()
                .anyMatch(lot -> lot.park(car));
    }

    final Comparator<ParkingLot> byOccupancy = Comparator.comparingInt(ParkingLot::occupancy);

    private ParkingLot findLeastOccupied() {
        return parkingLots.stream().sorted(byOccupancy).findFirst().get();
    }

    private ParkingLot findFirstHandicappedFriendly() {
        return parkingLots.stream().filter(ParkingLot::isHandicappedFriendly).findFirst().orElse(ParkingLot.NULL_PARKING_LOG);
    }

    public boolean fetch(Car car) {
        return parkingLots
                .stream()
                .anyMatch(lot -> lot.fetch(car));
    }

    public boolean isCertified() {
        return certified;
    }
}